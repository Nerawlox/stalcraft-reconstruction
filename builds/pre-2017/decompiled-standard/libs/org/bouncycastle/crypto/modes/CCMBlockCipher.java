/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class CCMBlockCipher
implements AEADBlockCipher {
    private BlockCipher cipher;
    private int blockSize;
    private boolean forEncryption;
    private byte[] nonce;
    private byte[] associatedText;
    private int macSize;
    private CipherParameters keyParam;
    private byte[] macBlock;
    private ByteArrayOutputStream data = new ByteArrayOutputStream();

    public CCMBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        this.blockSize = blockCipher.getBlockSize();
        this.macBlock = new byte[this.blockSize];
        if (this.blockSize != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean bl, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.forEncryption = bl;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters)cipherParameters;
            this.nonce = aEADParameters.getNonce();
            this.associatedText = aEADParameters.getAssociatedText();
            this.macSize = aEADParameters.getMacSize() / 8;
            this.keyParam = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV)cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.associatedText = null;
            this.macSize = this.macBlock.length / 2;
            this.keyParam = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to CCM");
        }
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CCM";
    }

    public int processByte(byte by, byte[] byArray, int n) throws DataLengthException, IllegalStateException {
        this.data.write(by);
        return 0;
    }

    public int processBytes(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws DataLengthException, IllegalStateException {
        this.data.write(byArray, n, n2);
        return 0;
    }

    public int doFinal(byte[] byArray, int n) throws IllegalStateException, InvalidCipherTextException {
        byte[] byArray2 = this.data.toByteArray();
        byte[] byArray3 = this.processPacket(byArray2, 0, byArray2.length);
        System.arraycopy(byArray3, 0, byArray, n, byArray3.length);
        this.reset();
        return byArray3.length;
    }

    public void reset() {
        this.cipher.reset();
        this.data.reset();
    }

    public byte[] getMac() {
        byte[] byArray = new byte[this.macSize];
        System.arraycopy(this.macBlock, 0, byArray, 0, byArray.length);
        return byArray;
    }

    public int getUpdateOutputSize(int n) {
        return 0;
    }

    public int getOutputSize(int n) {
        if (this.forEncryption) {
            return this.data.size() + n + this.macSize;
        }
        return this.data.size() + n - this.macSize;
    }

    public byte[] processPacket(byte[] byArray, int n, int n2) throws IllegalStateException, InvalidCipherTextException {
        byte[] byArray2;
        if (this.keyParam == null) {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
        SICBlockCipher sICBlockCipher = new SICBlockCipher(this.cipher);
        byte[] byArray3 = new byte[this.blockSize];
        byArray3[0] = (byte)(15 - this.nonce.length - 1 & 7);
        System.arraycopy(this.nonce, 0, byArray3, 1, this.nonce.length);
        sICBlockCipher.init(this.forEncryption, new ParametersWithIV(this.keyParam, byArray3));
        if (this.forEncryption) {
            int n3;
            int n4 = 0;
            byArray2 = new byte[n2 + this.macSize];
            this.calculateMac(byArray, n, n2, this.macBlock);
            sICBlockCipher.processBlock(this.macBlock, 0, this.macBlock, 0);
            for (n3 = n; n3 < n2 - this.blockSize; n3 += this.blockSize) {
                sICBlockCipher.processBlock(byArray, n3, byArray2, n4);
                n4 += this.blockSize;
            }
            byte[] byArray4 = new byte[this.blockSize];
            System.arraycopy(byArray, n3, byArray4, 0, n2 - n3);
            sICBlockCipher.processBlock(byArray4, 0, byArray4, 0);
            System.arraycopy(byArray4, 0, byArray2, n4, n2 - n3);
            System.arraycopy(this.macBlock, 0, byArray2, n4 += n2 - n3, byArray2.length - n4);
        } else {
            int n5 = n;
            int n6 = 0;
            byArray2 = new byte[n2 - this.macSize];
            System.arraycopy(byArray, n + n2 - this.macSize, this.macBlock, 0, this.macSize);
            sICBlockCipher.processBlock(this.macBlock, 0, this.macBlock, 0);
            for (int i = this.macSize; i != this.macBlock.length; ++i) {
                this.macBlock[i] = 0;
            }
            while (n6 < byArray2.length - this.blockSize) {
                sICBlockCipher.processBlock(byArray, n5, byArray2, n6);
                n6 += this.blockSize;
                n5 += this.blockSize;
            }
            byte[] byArray5 = new byte[this.blockSize];
            System.arraycopy(byArray, n5, byArray5, 0, byArray2.length - n6);
            sICBlockCipher.processBlock(byArray5, 0, byArray5, 0);
            System.arraycopy(byArray5, 0, byArray2, n6, byArray2.length - n6);
            byte[] byArray6 = new byte[this.blockSize];
            this.calculateMac(byArray2, 0, byArray2.length, byArray6);
            if (!Arrays.constantTimeAreEqual(this.macBlock, byArray6)) {
                throw new InvalidCipherTextException("mac check in CCM failed");
            }
        }
        return byArray2;
    }

    private int calculateMac(byte[] byArray, int n, int n2, byte[] byArray2) {
        CBCBlockCipherMac cBCBlockCipherMac = new CBCBlockCipherMac(this.cipher, this.macSize * 8);
        cBCBlockCipherMac.init(this.keyParam);
        byte[] byArray3 = new byte[16];
        if (this.hasAssociatedText()) {
            byArray3[0] = (byte)(byArray3[0] | 0x40);
        }
        byArray3[0] = (byte)(byArray3[0] | ((cBCBlockCipherMac.getMacSize() - 2) / 2 & 7) << 3);
        byArray3[0] = (byte)(byArray3[0] | 15 - this.nonce.length - 1 & 7);
        System.arraycopy(this.nonce, 0, byArray3, 1, this.nonce.length);
        int n3 = n2;
        int n4 = 1;
        while (n3 > 0) {
            byArray3[byArray3.length - n4] = (byte)(n3 & 0xFF);
            n3 >>>= 8;
            ++n4;
        }
        cBCBlockCipherMac.update(byArray3, 0, byArray3.length);
        if (this.hasAssociatedText()) {
            int n5;
            if (this.associatedText.length < 65280) {
                cBCBlockCipherMac.update((byte)(this.associatedText.length >> 8));
                cBCBlockCipherMac.update((byte)this.associatedText.length);
                n5 = 2;
            } else {
                cBCBlockCipherMac.update((byte)-1);
                cBCBlockCipherMac.update((byte)-2);
                cBCBlockCipherMac.update((byte)(this.associatedText.length >> 24));
                cBCBlockCipherMac.update((byte)(this.associatedText.length >> 16));
                cBCBlockCipherMac.update((byte)(this.associatedText.length >> 8));
                cBCBlockCipherMac.update((byte)this.associatedText.length);
                n5 = 6;
            }
            cBCBlockCipherMac.update(this.associatedText, 0, this.associatedText.length);
            n5 = (n5 + this.associatedText.length) % 16;
            if (n5 != 0) {
                for (int i = 0; i != 16 - n5; ++i) {
                    cBCBlockCipherMac.update((byte)0);
                }
            }
        }
        cBCBlockCipherMac.update(byArray, n, n2);
        return cBCBlockCipherMac.doFinal(byArray2, 0);
    }

    private boolean hasAssociatedText() {
        return this.associatedText != null && this.associatedText.length != 0;
    }
}

