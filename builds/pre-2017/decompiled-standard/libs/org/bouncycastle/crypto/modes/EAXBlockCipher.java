/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class EAXBlockCipher
implements AEADBlockCipher {
    private static final byte nTAG = 0;
    private static final byte hTAG = 1;
    private static final byte cTAG = 2;
    private SICBlockCipher cipher;
    private boolean forEncryption;
    private int blockSize;
    private Mac mac;
    private byte[] nonceMac;
    private byte[] associatedTextMac;
    private byte[] macBlock;
    private int macSize;
    private byte[] bufBlock;
    private int bufOff;

    public EAXBlockCipher(BlockCipher blockCipher) {
        this.blockSize = blockCipher.getBlockSize();
        this.mac = new CMac(blockCipher);
        this.macBlock = new byte[this.blockSize];
        this.bufBlock = new byte[this.blockSize * 2];
        this.associatedTextMac = new byte[this.mac.getMacSize()];
        this.nonceMac = new byte[this.mac.getMacSize()];
        this.cipher = new SICBlockCipher(blockCipher);
    }

    public String getAlgorithmName() {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + "/EAX";
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher.getUnderlyingCipher();
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public void init(boolean bl, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        byte[] byArray;
        byte[] byArray2;
        Object object;
        this.forEncryption = bl;
        if (cipherParameters instanceof AEADParameters) {
            object = (AEADParameters)cipherParameters;
            byArray2 = ((AEADParameters)object).getNonce();
            byArray = ((AEADParameters)object).getAssociatedText();
            this.macSize = ((AEADParameters)object).getMacSize() / 8;
            cipherParameters2 = ((AEADParameters)object).getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            object = (ParametersWithIV)cipherParameters;
            byArray2 = ((ParametersWithIV)object).getIV();
            byArray = new byte[]{};
            this.macSize = this.mac.getMacSize() / 2;
            cipherParameters2 = ((ParametersWithIV)object).getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to EAX");
        }
        object = new byte[this.blockSize];
        this.mac.init(cipherParameters2);
        object[this.blockSize - 1] = true;
        this.mac.update((byte[])object, 0, this.blockSize);
        this.mac.update(byArray, 0, byArray.length);
        this.mac.doFinal(this.associatedTextMac, 0);
        object[this.blockSize - 1] = false;
        this.mac.update((byte[])object, 0, this.blockSize);
        this.mac.update(byArray2, 0, byArray2.length);
        this.mac.doFinal(this.nonceMac, 0);
        object[this.blockSize - 1] = 2;
        this.mac.update((byte[])object, 0, this.blockSize);
        this.cipher.init(true, new ParametersWithIV(cipherParameters2, this.nonceMac));
    }

    private void calculateMac() {
        byte[] byArray = new byte[this.blockSize];
        this.mac.doFinal(byArray, 0);
        for (int i = 0; i < this.macBlock.length; ++i) {
            this.macBlock[i] = (byte)(this.nonceMac[i] ^ this.associatedTextMac[i] ^ byArray[i]);
        }
    }

    public void reset() {
        this.reset(true);
    }

    private void reset(boolean bl) {
        this.cipher.reset();
        this.mac.reset();
        this.bufOff = 0;
        Arrays.fill(this.bufBlock, (byte)0);
        if (bl) {
            Arrays.fill(this.macBlock, (byte)0);
        }
        byte[] byArray = new byte[this.blockSize];
        byArray[this.blockSize - 1] = 2;
        this.mac.update(byArray, 0, this.blockSize);
    }

    public int processByte(byte by, byte[] byArray, int n) throws DataLengthException {
        return this.process(by, byArray, n);
    }

    public int processBytes(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws DataLengthException {
        int n4 = 0;
        for (int i = 0; i != n2; ++i) {
            n4 += this.process(byArray[n + i], byArray2, n3 + n4);
        }
        return n4;
    }

    public int doFinal(byte[] byArray, int n) throws IllegalStateException, InvalidCipherTextException {
        int n2 = this.bufOff;
        byte[] byArray2 = new byte[this.bufBlock.length];
        this.bufOff = 0;
        if (this.forEncryption) {
            this.cipher.processBlock(this.bufBlock, 0, byArray2, 0);
            this.cipher.processBlock(this.bufBlock, this.blockSize, byArray2, this.blockSize);
            System.arraycopy(byArray2, 0, byArray, n, n2);
            this.mac.update(byArray2, 0, n2);
            this.calculateMac();
            System.arraycopy(this.macBlock, 0, byArray, n + n2, this.macSize);
            this.reset(false);
            return n2 + this.macSize;
        }
        if (n2 > this.macSize) {
            this.mac.update(this.bufBlock, 0, n2 - this.macSize);
            this.cipher.processBlock(this.bufBlock, 0, byArray2, 0);
            this.cipher.processBlock(this.bufBlock, this.blockSize, byArray2, this.blockSize);
            System.arraycopy(byArray2, 0, byArray, n, n2 - this.macSize);
        }
        this.calculateMac();
        if (!this.verifyMac(this.bufBlock, n2 - this.macSize)) {
            throw new InvalidCipherTextException("mac check in EAX failed");
        }
        this.reset(false);
        return n2 - this.macSize;
    }

    public byte[] getMac() {
        byte[] byArray = new byte[this.macSize];
        System.arraycopy(this.macBlock, 0, byArray, 0, this.macSize);
        return byArray;
    }

    public int getUpdateOutputSize(int n) {
        return (n + this.bufOff) / this.blockSize * this.blockSize;
    }

    public int getOutputSize(int n) {
        if (this.forEncryption) {
            return n + this.bufOff + this.macSize;
        }
        return n + this.bufOff - this.macSize;
    }

    private int process(byte by, byte[] byArray, int n) {
        this.bufBlock[this.bufOff++] = by;
        if (this.bufOff == this.bufBlock.length) {
            int n2;
            if (this.forEncryption) {
                n2 = this.cipher.processBlock(this.bufBlock, 0, byArray, n);
                this.mac.update(byArray, n, this.blockSize);
            } else {
                this.mac.update(this.bufBlock, 0, this.blockSize);
                n2 = this.cipher.processBlock(this.bufBlock, 0, byArray, n);
            }
            this.bufOff = this.blockSize;
            System.arraycopy(this.bufBlock, this.blockSize, this.bufBlock, 0, this.blockSize);
            return n2;
        }
        return 0;
    }

    private boolean verifyMac(byte[] byArray, int n) {
        for (int i = 0; i < this.macSize; ++i) {
            if (this.macBlock[i] == byArray[n + i]) continue;
            return false;
        }
        return true;
    }
}

