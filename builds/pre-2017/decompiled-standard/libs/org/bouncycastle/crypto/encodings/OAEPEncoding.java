/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class OAEPEncoding
implements AsymmetricBlockCipher {
    private byte[] defHash;
    private Digest hash;
    private Digest mgf1Hash;
    private AsymmetricBlockCipher engine;
    private SecureRandom random;
    private boolean forEncryption;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this(asymmetricBlockCipher, new SHA1Digest(), null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] byArray) {
        this(asymmetricBlockCipher, digest, digest, byArray);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] byArray) {
        this.engine = asymmetricBlockCipher;
        this.hash = digest;
        this.mgf1Hash = digest2;
        this.defHash = new byte[digest.getDigestSize()];
        if (byArray != null) {
            digest.update(byArray, 0, byArray.length);
        }
        digest.doFinal(this.defHash, 0);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean bl, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom)cipherParameters;
            this.random = parametersWithRandom.getRandom();
        } else {
            this.random = new SecureRandom();
        }
        this.engine.init(bl, cipherParameters);
        this.forEncryption = bl;
    }

    public int getInputBlockSize() {
        int n = this.engine.getInputBlockSize();
        if (this.forEncryption) {
            return n - 1 - 2 * this.defHash.length;
        }
        return n;
    }

    public int getOutputBlockSize() {
        int n = this.engine.getOutputBlockSize();
        if (this.forEncryption) {
            return n;
        }
        return n - 1 - 2 * this.defHash.length;
    }

    public byte[] processBlock(byte[] byArray, int n, int n2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            return this.encodeBlock(byArray, n, n2);
        }
        return this.decodeBlock(byArray, n, n2);
    }

    public byte[] encodeBlock(byte[] byArray, int n, int n2) throws InvalidCipherTextException {
        int n3;
        byte[] byArray2 = new byte[this.getInputBlockSize() + 1 + 2 * this.defHash.length];
        System.arraycopy(byArray, n, byArray2, byArray2.length - n2, n2);
        byArray2[byArray2.length - n2 - 1] = 1;
        System.arraycopy(this.defHash, 0, byArray2, this.defHash.length, this.defHash.length);
        byte[] byArray3 = new byte[this.defHash.length];
        this.random.nextBytes(byArray3);
        byte[] byArray4 = this.maskGeneratorFunction1(byArray3, 0, byArray3.length, byArray2.length - this.defHash.length);
        for (n3 = this.defHash.length; n3 != byArray2.length; ++n3) {
            int n4 = n3;
            byArray2[n4] = (byte)(byArray2[n4] ^ byArray4[n3 - this.defHash.length]);
        }
        System.arraycopy(byArray3, 0, byArray2, 0, this.defHash.length);
        byArray4 = this.maskGeneratorFunction1(byArray2, this.defHash.length, byArray2.length - this.defHash.length, this.defHash.length);
        for (n3 = 0; n3 != this.defHash.length; ++n3) {
            int n5 = n3;
            byArray2[n5] = (byte)(byArray2[n5] ^ byArray4[n3]);
        }
        return this.engine.processBlock(byArray2, 0, byArray2.length);
    }

    public byte[] decodeBlock(byte[] byArray, int n, int n2) throws InvalidCipherTextException {
        int n3;
        byte[] byArray2;
        byte[] byArray3 = this.engine.processBlock(byArray, n, n2);
        if (byArray3.length < this.engine.getOutputBlockSize()) {
            byArray2 = new byte[this.engine.getOutputBlockSize()];
            System.arraycopy(byArray3, 0, byArray2, byArray2.length - byArray3.length, byArray3.length);
        } else {
            byArray2 = byArray3;
        }
        if (byArray2.length < 2 * this.defHash.length + 1) {
            throw new InvalidCipherTextException("data too short");
        }
        byte[] byArray4 = this.maskGeneratorFunction1(byArray2, this.defHash.length, byArray2.length - this.defHash.length, this.defHash.length);
        for (n3 = 0; n3 != this.defHash.length; ++n3) {
            int n4 = n3;
            byArray2[n4] = (byte)(byArray2[n4] ^ byArray4[n3]);
        }
        byArray4 = this.maskGeneratorFunction1(byArray2, 0, this.defHash.length, byArray2.length - this.defHash.length);
        for (n3 = this.defHash.length; n3 != byArray2.length; ++n3) {
            int n5 = n3;
            byArray2[n5] = (byte)(byArray2[n5] ^ byArray4[n3 - this.defHash.length]);
        }
        for (n3 = 0; n3 != this.defHash.length; ++n3) {
            if (this.defHash[n3] == byArray2[this.defHash.length + n3]) continue;
            throw new InvalidCipherTextException("data hash wrong");
        }
        for (n3 = 2 * this.defHash.length; n3 != byArray2.length && byArray2[n3] == 0; ++n3) {
        }
        if (n3 >= byArray2.length - 1 || byArray2[n3] != 1) {
            throw new InvalidCipherTextException("data start wrong " + n3);
        }
        byte[] byArray5 = new byte[byArray2.length - ++n3];
        System.arraycopy(byArray2, n3, byArray5, 0, byArray5.length);
        return byArray5;
    }

    private void ItoOSP(int n, byte[] byArray) {
        byArray[0] = (byte)(n >>> 24);
        byArray[1] = (byte)(n >>> 16);
        byArray[2] = (byte)(n >>> 8);
        byArray[3] = (byte)(n >>> 0);
    }

    private byte[] maskGeneratorFunction1(byte[] byArray, int n, int n2, int n3) {
        byte[] byArray2 = new byte[n3];
        byte[] byArray3 = new byte[this.mgf1Hash.getDigestSize()];
        byte[] byArray4 = new byte[4];
        int n4 = 0;
        this.hash.reset();
        do {
            this.ItoOSP(n4, byArray4);
            this.mgf1Hash.update(byArray, n, n2);
            this.mgf1Hash.update(byArray4, 0, byArray4.length);
            this.mgf1Hash.doFinal(byArray3, 0);
            System.arraycopy(byArray3, 0, byArray2, n4 * byArray3.length, byArray3.length);
        } while (++n4 < n3 / byArray3.length);
        if (n4 * byArray3.length < n3) {
            this.ItoOSP(n4, byArray4);
            this.mgf1Hash.update(byArray, n, n2);
            this.mgf1Hash.update(byArray4, 0, byArray4.length);
            this.mgf1Hash.doFinal(byArray3, 0);
            System.arraycopy(byArray3, 0, byArray2, n4 * byArray3.length, byArray2.length - n4 * byArray3.length);
        }
        return byArray2;
    }
}

