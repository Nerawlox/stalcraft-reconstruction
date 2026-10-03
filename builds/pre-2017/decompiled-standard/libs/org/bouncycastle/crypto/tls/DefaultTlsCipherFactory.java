/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.tls.TlsBlockCipher;
import org.bouncycastle.crypto.tls.TlsCipher;
import org.bouncycastle.crypto.tls.TlsCipherFactory;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsFatalAlert;

public class DefaultTlsCipherFactory
implements TlsCipherFactory {
    public TlsCipher createCipher(TlsClientContext tlsClientContext, int n, int n2) throws IOException {
        switch (n) {
            case 7: {
                return this.createDESedeCipher(tlsClientContext, 24, n2);
            }
            case 8: {
                return this.createAESCipher(tlsClientContext, 16, n2);
            }
            case 9: {
                return this.createAESCipher(tlsClientContext, 32, n2);
            }
        }
        throw new TlsFatalAlert(80);
    }

    protected TlsCipher createAESCipher(TlsClientContext tlsClientContext, int n, int n2) throws IOException {
        return new TlsBlockCipher(tlsClientContext, this.createAESBlockCipher(), this.createAESBlockCipher(), this.createDigest(n2), this.createDigest(n2), n);
    }

    protected TlsCipher createDESedeCipher(TlsClientContext tlsClientContext, int n, int n2) throws IOException {
        return new TlsBlockCipher(tlsClientContext, this.createDESedeBlockCipher(), this.createDESedeBlockCipher(), this.createDigest(n2), this.createDigest(n2), n);
    }

    protected BlockCipher createAESBlockCipher() {
        return new CBCBlockCipher(new AESFastEngine());
    }

    protected BlockCipher createDESedeBlockCipher() {
        return new CBCBlockCipher(new DESedeEngine());
    }

    protected Digest createDigest(int n) throws IOException {
        switch (n) {
            case 1: {
                return new MD5Digest();
            }
            case 2: {
                return new SHA1Digest();
            }
            case 3: {
                return new SHA256Digest();
            }
            case 4: {
                return new SHA384Digest();
            }
        }
        throw new TlsFatalAlert(80);
    }
}

