/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.TlsCipher;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsMac;
import org.bouncycastle.crypto.tls.TlsUtils;
import org.bouncycastle.util.Arrays;

public class TlsBlockCipher
implements TlsCipher {
    protected TlsClientContext context;
    protected BlockCipher encryptCipher;
    protected BlockCipher decryptCipher;
    protected TlsMac writeMac;
    protected TlsMac readMac;

    public TlsMac getWriteMac() {
        return this.writeMac;
    }

    public TlsMac getReadMac() {
        return this.readMac;
    }

    public TlsBlockCipher(TlsClientContext tlsClientContext, BlockCipher blockCipher, BlockCipher blockCipher2, Digest digest, Digest digest2, int n) {
        this.context = tlsClientContext;
        this.encryptCipher = blockCipher;
        this.decryptCipher = blockCipher2;
        int n2 = 2 * n + digest.getDigestSize() + digest2.getDigestSize() + blockCipher.getBlockSize() + blockCipher2.getBlockSize();
        byte[] byArray = TlsUtils.calculateKeyBlock(tlsClientContext, n2);
        int n3 = 0;
        this.writeMac = new TlsMac(tlsClientContext, digest, byArray, n3, digest.getDigestSize());
        this.readMac = new TlsMac(tlsClientContext, digest2, byArray, n3 += digest.getDigestSize(), digest2.getDigestSize());
        this.initCipher(true, blockCipher, byArray, n, n3 += digest2.getDigestSize(), n3 + n * 2);
        this.initCipher(false, blockCipher2, byArray, n, n3 += n, n3 + n + blockCipher.getBlockSize());
    }

    protected void initCipher(boolean bl, BlockCipher blockCipher, byte[] byArray, int n, int n2, int n3) {
        KeyParameter keyParameter = new KeyParameter(byArray, n2, n);
        ParametersWithIV parametersWithIV = new ParametersWithIV(keyParameter, byArray, n3, blockCipher.getBlockSize());
        blockCipher.init(bl, parametersWithIV);
    }

    public byte[] encodePlaintext(short s, byte[] byArray, int n, int n2) {
        int n3;
        int n4;
        boolean bl;
        int n5;
        int n6 = this.encryptCipher.getBlockSize();
        int n7 = n5 = n6 - (n2 + this.writeMac.getSize() + 1) % n6;
        boolean bl2 = bl = this.context.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
        if (bl) {
            n4 = (255 - n5) / n6;
            int n8 = this.chooseExtraPadBlocks(this.context.getSecureRandom(), n4);
            n7 += n8 * n6;
        }
        n4 = n2 + this.writeMac.getSize() + n7 + 1;
        byte[] byArray2 = new byte[n4];
        System.arraycopy(byArray, n, byArray2, 0, n2);
        byte[] byArray3 = this.writeMac.calculateMac(s, byArray, n, n2);
        System.arraycopy(byArray3, 0, byArray2, n2, byArray3.length);
        int n9 = n2 + byArray3.length;
        for (n3 = 0; n3 <= n7; ++n3) {
            byArray2[n3 + n9] = (byte)n7;
        }
        for (n3 = 0; n3 < n4; n3 += n6) {
            this.encryptCipher.processBlock(byArray2, n3, byArray2, n3);
        }
        return byArray2;
    }

    public byte[] decodeCiphertext(short s, byte[] byArray, int n, int n2) throws IOException {
        int n3;
        int n4;
        int n5 = this.readMac.getSize() + 1;
        int n6 = this.decryptCipher.getBlockSize();
        boolean bl = false;
        if (n2 < n5) {
            throw new TlsFatalAlert(50);
        }
        if (n2 % n6 != 0) {
            throw new TlsFatalAlert(21);
        }
        for (n4 = 0; n4 < n2; n4 += n6) {
            this.decryptCipher.processBlock(byArray, n4 + n, byArray, n4 + n);
        }
        n4 = n + n2 - 1;
        byte by = byArray[n4];
        int n7 = by & 0xFF;
        boolean bl2 = this.context.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
        int n8 = n2 - n5;
        if (!bl2) {
            n8 = Math.min(n8, n6);
        }
        if (n7 > n8) {
            bl = true;
            n7 = 0;
        } else if (bl2) {
            n3 = 0;
            for (int i = n4 - n7; i < n4; ++i) {
                n3 = (byte)(n3 | byArray[i] ^ by);
            }
            if (n3 != 0) {
                bl = true;
                n7 = 0;
            }
        }
        n3 = n2 - n5 - n7;
        byte[] byArray2 = this.readMac.calculateMac(s, byArray, n, n3);
        byte[] byArray3 = new byte[byArray2.length];
        System.arraycopy(byArray, n + n3, byArray3, 0, byArray2.length);
        if (!Arrays.constantTimeAreEqual(byArray2, byArray3)) {
            bl = true;
        }
        if (bl) {
            throw new TlsFatalAlert(20);
        }
        byte[] byArray4 = new byte[n3];
        System.arraycopy(byArray, n, byArray4, 0, n3);
        return byArray4;
    }

    protected int chooseExtraPadBlocks(SecureRandom secureRandom, int n) {
        int n2 = secureRandom.nextInt();
        int n3 = this.lowestBitSet(n2);
        return Math.min(n3, n);
    }

    protected int lowestBitSet(int n) {
        if (n == 0) {
            return 32;
        }
        int n2 = 0;
        while ((n & 1) == 0) {
            ++n2;
            n >>= 1;
        }
        return n2;
    }
}

