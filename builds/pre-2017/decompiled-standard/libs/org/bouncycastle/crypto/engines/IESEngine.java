/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.IESParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.BigIntegers;

public class IESEngine {
    BasicAgreement agree;
    DerivationFunction kdf;
    Mac mac;
    BufferedBlockCipher cipher;
    byte[] macBuf;
    boolean forEncryption;
    CipherParameters privParam;
    CipherParameters pubParam;
    IESParameters param;

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac;
        this.macBuf = new byte[mac.getMacSize()];
        this.cipher = null;
    }

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac, BufferedBlockCipher bufferedBlockCipher) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac;
        this.macBuf = new byte[mac.getMacSize()];
        this.cipher = bufferedBlockCipher;
    }

    public void init(boolean bl, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.forEncryption = bl;
        this.privParam = cipherParameters;
        this.pubParam = cipherParameters2;
        this.param = (IESParameters)cipherParameters3;
    }

    private byte[] decryptBlock(byte[] byArray, int n, int n2, byte[] byArray2) throws InvalidCipherTextException {
        int n3;
        byte[] byArray3;
        byte[] byArray4 = null;
        KeyParameter keyParameter = null;
        KDFParameters kDFParameters = new KDFParameters(byArray2, this.param.getDerivationV());
        int n4 = this.param.getMacKeySize();
        this.kdf.init(kDFParameters);
        n2 -= this.mac.getMacSize();
        if (this.cipher == null) {
            byArray3 = this.generateKdfBytes(kDFParameters, n2 + n4 / 8);
            byArray4 = new byte[n2];
            for (n3 = 0; n3 != n2; ++n3) {
                byArray4[n3] = (byte)(byArray[n + n3] ^ byArray3[n3]);
            }
            keyParameter = new KeyParameter(byArray3, n2, n4 / 8);
        } else {
            int n5 = ((IESWithCipherParameters)this.param).getCipherKeySize();
            byte[] byArray5 = this.generateKdfBytes(kDFParameters, n5 / 8 + n4 / 8);
            this.cipher.init(false, new KeyParameter(byArray5, 0, n5 / 8));
            byte[] byArray6 = new byte[this.cipher.getOutputSize(n2)];
            int n6 = this.cipher.processBytes(byArray, n, n2, byArray6, 0);
            n6 += this.cipher.doFinal(byArray6, n6);
            byArray4 = new byte[n6];
            System.arraycopy(byArray6, 0, byArray4, 0, n6);
            keyParameter = new KeyParameter(byArray5, n5 / 8, n4 / 8);
        }
        byArray3 = this.param.getEncodingV();
        this.mac.init(keyParameter);
        this.mac.update(byArray, n, n2);
        this.mac.update(byArray3, 0, byArray3.length);
        this.mac.doFinal(this.macBuf, 0);
        n += n2;
        for (n3 = 0; n3 < this.macBuf.length; ++n3) {
            if (this.macBuf[n3] == byArray[n + n3]) continue;
            throw new InvalidCipherTextException("Mac codes failed to equal.");
        }
        return byArray4;
    }

    private byte[] encryptBlock(byte[] byArray, int n, int n2, byte[] byArray2) throws InvalidCipherTextException {
        byte[] byArray3;
        byte[] byArray4 = null;
        KeyParameter keyParameter = null;
        KDFParameters kDFParameters = new KDFParameters(byArray2, this.param.getDerivationV());
        int n3 = 0;
        int n4 = this.param.getMacKeySize();
        if (this.cipher == null) {
            byArray3 = this.generateKdfBytes(kDFParameters, n2 + n4 / 8);
            byArray4 = new byte[n2 + this.mac.getMacSize()];
            n3 = n2;
            for (int i = 0; i != n2; ++i) {
                byArray4[i] = (byte)(byArray[n + i] ^ byArray3[i]);
            }
            keyParameter = new KeyParameter(byArray3, n2, n4 / 8);
        } else {
            int n5 = ((IESWithCipherParameters)this.param).getCipherKeySize();
            byte[] byArray5 = this.generateKdfBytes(kDFParameters, n5 / 8 + n4 / 8);
            this.cipher.init(true, new KeyParameter(byArray5, 0, n5 / 8));
            n3 = this.cipher.getOutputSize(n2);
            byte[] byArray6 = new byte[n3];
            int n6 = this.cipher.processBytes(byArray, n, n2, byArray6, 0);
            n6 += this.cipher.doFinal(byArray6, n6);
            byArray4 = new byte[n6 + this.mac.getMacSize()];
            n3 = n6;
            System.arraycopy(byArray6, 0, byArray4, 0, n6);
            keyParameter = new KeyParameter(byArray5, n5 / 8, n4 / 8);
        }
        byArray3 = this.param.getEncodingV();
        this.mac.init(keyParameter);
        this.mac.update(byArray4, 0, n3);
        this.mac.update(byArray3, 0, byArray3.length);
        this.mac.doFinal(byArray4, n3);
        return byArray4;
    }

    private byte[] generateKdfBytes(KDFParameters kDFParameters, int n) {
        byte[] byArray = new byte[n];
        this.kdf.init(kDFParameters);
        this.kdf.generateBytes(byArray, 0, byArray.length);
        return byArray;
    }

    public byte[] processBlock(byte[] byArray, int n, int n2) throws InvalidCipherTextException {
        this.agree.init(this.privParam);
        BigInteger bigInteger = this.agree.calculateAgreement(this.pubParam);
        byte[] byArray2 = BigIntegers.asUnsignedByteArray(bigInteger);
        return this.forEncryption ? this.encryptBlock(byArray, n, n2, byArray2) : this.decryptBlock(byArray, n, n2, byArray2);
    }
}

