/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.encodings;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class PKCS1Encoding
implements AsymmetricBlockCipher {
    public static final String STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.strict";
    private static final int HEADER_LENGTH = 10;
    private SecureRandom random;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private boolean forPrivateKey;
    private boolean useStrictLength;

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = this.useStrict();
    }

    private boolean useStrict() {
        String string = (String)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                return System.getProperty(PKCS1Encoding.STRICT_LENGTH_ENABLED_PROPERTY);
            }
        });
        return string == null || string.equals("true");
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean bl, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom)cipherParameters;
            this.random = parametersWithRandom.getRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter)parametersWithRandom.getParameters();
        } else {
            this.random = new SecureRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter)cipherParameters;
        }
        this.engine.init(bl, cipherParameters);
        this.forPrivateKey = asymmetricKeyParameter.isPrivate();
        this.forEncryption = bl;
    }

    public int getInputBlockSize() {
        int n = this.engine.getInputBlockSize();
        if (this.forEncryption) {
            return n - 10;
        }
        return n;
    }

    public int getOutputBlockSize() {
        int n = this.engine.getOutputBlockSize();
        if (this.forEncryption) {
            return n;
        }
        return n - 10;
    }

    public byte[] processBlock(byte[] byArray, int n, int n2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            return this.encodeBlock(byArray, n, n2);
        }
        return this.decodeBlock(byArray, n, n2);
    }

    private byte[] encodeBlock(byte[] byArray, int n, int n2) throws InvalidCipherTextException {
        if (n2 > this.getInputBlockSize()) {
            throw new IllegalArgumentException("input data too large");
        }
        byte[] byArray2 = new byte[this.engine.getInputBlockSize()];
        if (this.forPrivateKey) {
            byArray2[0] = 1;
            for (int i = 1; i != byArray2.length - n2 - 1; ++i) {
                byArray2[i] = -1;
            }
        } else {
            this.random.nextBytes(byArray2);
            byArray2[0] = 2;
            for (int i = 1; i != byArray2.length - n2 - 1; ++i) {
                while (byArray2[i] == 0) {
                    byArray2[i] = (byte)this.random.nextInt();
                }
            }
        }
        byArray2[byArray2.length - n2 - 1] = 0;
        System.arraycopy(byArray, n, byArray2, byArray2.length - n2, n2);
        return this.engine.processBlock(byArray2, 0, byArray2.length);
    }

    private byte[] decodeBlock(byte[] byArray, int n, int n2) throws InvalidCipherTextException {
        byte by;
        int n3;
        byte[] byArray2 = this.engine.processBlock(byArray, n, n2);
        if (byArray2.length < this.getOutputBlockSize()) {
            throw new InvalidCipherTextException("block truncated");
        }
        byte by2 = byArray2[0];
        if (by2 != 1 && by2 != 2) {
            throw new InvalidCipherTextException("unknown block type");
        }
        if (this.useStrictLength && byArray2.length != this.engine.getOutputBlockSize()) {
            throw new InvalidCipherTextException("block incorrect size");
        }
        for (n3 = 1; n3 != byArray2.length && (by = byArray2[n3]) != 0; ++n3) {
            if (by2 != 1 || by == -1) continue;
            throw new InvalidCipherTextException("block padding incorrect");
        }
        if (++n3 > byArray2.length || n3 < 10) {
            throw new InvalidCipherTextException("no data in block");
        }
        byte[] byArray3 = new byte[byArray2.length - n3];
        System.arraycopy(byArray2, n3, byArray3, 0, byArray3.length);
        return byArray3;
    }
}

