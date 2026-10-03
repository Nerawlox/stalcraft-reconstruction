/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.gcm.GCMMultiplier;
import org.bouncycastle.crypto.modes.gcm.Tables8kGCMMultiplier;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.Pack;
import org.bouncycastle.util.Arrays;

public class GCMBlockCipher
implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] ZEROES = new byte[16];
    private BlockCipher cipher;
    private GCMMultiplier multiplier;
    private boolean forEncryption;
    private int macSize;
    private byte[] nonce;
    private byte[] A;
    private byte[] H;
    private byte[] initS;
    private byte[] J0;
    private byte[] bufBlock;
    private byte[] macBlock;
    private byte[] S;
    private byte[] counter;
    private int bufOff;
    private long totalLength;

    public GCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, null);
    }

    public GCMBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
        if (gCMMultiplier == null) {
            gCMMultiplier = new Tables8kGCMMultiplier();
        }
        this.cipher = blockCipher;
        this.multiplier = gCMMultiplier;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCM";
    }

    public void init(boolean bl, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        CipherParameters cipherParameters2;
        this.forEncryption = bl;
        this.macBlock = null;
        if (cipherParameters instanceof AEADParameters) {
            cipherParameters2 = (AEADParameters)cipherParameters;
            this.nonce = ((AEADParameters)cipherParameters2).getNonce();
            this.A = ((AEADParameters)cipherParameters2).getAssociatedText();
            int n = ((AEADParameters)cipherParameters2).getMacSize();
            if (n < 96 || n > 128 || n % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + n);
            }
            this.macSize = n / 8;
            keyParameter = ((AEADParameters)cipherParameters2).getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            cipherParameters2 = (ParametersWithIV)cipherParameters;
            this.nonce = ((ParametersWithIV)cipherParameters2).getIV();
            this.A = null;
            this.macSize = 16;
            keyParameter = (KeyParameter)((ParametersWithIV)cipherParameters2).getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to GCM");
        }
        int n = bl ? 16 : 16 + this.macSize;
        this.bufBlock = new byte[n];
        if (this.nonce == null || this.nonce.length < 1) {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (this.A == null) {
            this.A = new byte[0];
        }
        if (keyParameter != null) {
            this.cipher.init(true, keyParameter);
        }
        this.H = new byte[16];
        this.cipher.processBlock(ZEROES, 0, this.H, 0);
        this.multiplier.init(this.H);
        this.initS = this.gHASH(this.A);
        if (this.nonce.length == 12) {
            this.J0 = new byte[16];
            System.arraycopy(this.nonce, 0, this.J0, 0, this.nonce.length);
            this.J0[15] = 1;
        } else {
            this.J0 = this.gHASH(this.nonce);
            byte[] byArray = new byte[16];
            GCMBlockCipher.packLength((long)this.nonce.length * 8L, byArray, 8);
            GCMBlockCipher.xor(this.J0, byArray);
            this.multiplier.multiplyH(this.J0);
        }
        this.S = Arrays.clone(this.initS);
        this.counter = Arrays.clone(this.J0);
        this.bufOff = 0;
        this.totalLength = 0L;
    }

    public byte[] getMac() {
        return Arrays.clone(this.macBlock);
    }

    public int getOutputSize(int n) {
        if (this.forEncryption) {
            return n + this.bufOff + this.macSize;
        }
        return n + this.bufOff - this.macSize;
    }

    public int getUpdateOutputSize(int n) {
        return (n + this.bufOff) / 16 * 16;
    }

    public int processByte(byte by, byte[] byArray, int n) throws DataLengthException {
        return this.process(by, byArray, n);
    }

    public int processBytes(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws DataLengthException {
        int n4 = 0;
        for (int i = 0; i != n2; ++i) {
            this.bufBlock[this.bufOff++] = byArray[n + i];
            if (this.bufOff != this.bufBlock.length) continue;
            this.gCTRBlock(this.bufBlock, 16, byArray2, n3 + n4);
            if (!this.forEncryption) {
                System.arraycopy(this.bufBlock, 16, this.bufBlock, 0, this.macSize);
            }
            this.bufOff = this.bufBlock.length - 16;
            n4 += 16;
        }
        return n4;
    }

    private int process(byte by, byte[] byArray, int n) throws DataLengthException {
        this.bufBlock[this.bufOff++] = by;
        if (this.bufOff == this.bufBlock.length) {
            this.gCTRBlock(this.bufBlock, 16, byArray, n);
            if (!this.forEncryption) {
                System.arraycopy(this.bufBlock, 16, this.bufBlock, 0, this.macSize);
            }
            this.bufOff = this.bufBlock.length - 16;
            return 16;
        }
        return 0;
    }

    public int doFinal(byte[] byArray, int n) throws IllegalStateException, InvalidCipherTextException {
        byte[] byArray2;
        int n2 = this.bufOff;
        if (!this.forEncryption) {
            if (n2 < this.macSize) {
                throw new InvalidCipherTextException("data too short");
            }
            n2 -= this.macSize;
        }
        if (n2 > 0) {
            byArray2 = new byte[16];
            System.arraycopy(this.bufBlock, 0, byArray2, 0, n2);
            this.gCTRBlock(byArray2, n2, byArray, n);
        }
        byArray2 = new byte[16];
        GCMBlockCipher.packLength((long)this.A.length * 8L, byArray2, 0);
        GCMBlockCipher.packLength(this.totalLength * 8L, byArray2, 8);
        GCMBlockCipher.xor(this.S, byArray2);
        this.multiplier.multiplyH(this.S);
        byte[] byArray3 = new byte[16];
        this.cipher.processBlock(this.J0, 0, byArray3, 0);
        GCMBlockCipher.xor(byArray3, this.S);
        int n3 = n2;
        this.macBlock = new byte[this.macSize];
        System.arraycopy(byArray3, 0, this.macBlock, 0, this.macSize);
        if (this.forEncryption) {
            System.arraycopy(this.macBlock, 0, byArray, n + this.bufOff, this.macSize);
            n3 += this.macSize;
        } else {
            byte[] byArray4 = new byte[this.macSize];
            System.arraycopy(this.bufBlock, n2, byArray4, 0, this.macSize);
            if (!Arrays.constantTimeAreEqual(this.macBlock, byArray4)) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        this.reset(false);
        return n3;
    }

    public void reset() {
        this.reset(true);
    }

    private void reset(boolean bl) {
        this.S = Arrays.clone(this.initS);
        this.counter = Arrays.clone(this.J0);
        this.bufOff = 0;
        this.totalLength = 0L;
        if (this.bufBlock != null) {
            Arrays.fill(this.bufBlock, (byte)0);
        }
        if (bl) {
            this.macBlock = null;
        }
        this.cipher.reset();
    }

    private void gCTRBlock(byte[] byArray, int n, byte[] byArray2, int n2) {
        byte[] byArray3;
        for (int i = 15; i >= 12; --i) {
            byte by;
            this.counter[i] = by = (byte)(this.counter[i] + 1 & 0xFF);
            if (by != 0) break;
        }
        byte[] byArray4 = new byte[16];
        this.cipher.processBlock(this.counter, 0, byArray4, 0);
        if (this.forEncryption) {
            System.arraycopy(ZEROES, n, byArray4, n, 16 - n);
            byArray3 = byArray4;
        } else {
            byArray3 = byArray;
        }
        for (int i = n - 1; i >= 0; --i) {
            int n3 = i;
            byArray4[n3] = (byte)(byArray4[n3] ^ byArray[i]);
            byArray2[n2 + i] = byArray4[i];
        }
        GCMBlockCipher.xor(this.S, byArray3);
        this.multiplier.multiplyH(this.S);
        this.totalLength += (long)n;
    }

    private byte[] gHASH(byte[] byArray) {
        byte[] byArray2 = new byte[16];
        for (int i = 0; i < byArray.length; i += 16) {
            byte[] byArray3 = new byte[16];
            int n = Math.min(byArray.length - i, 16);
            System.arraycopy(byArray, i, byArray3, 0, n);
            GCMBlockCipher.xor(byArray2, byArray3);
            this.multiplier.multiplyH(byArray2);
        }
        return byArray2;
    }

    private static void xor(byte[] byArray, byte[] byArray2) {
        for (int i = 15; i >= 0; --i) {
            int n = i;
            byArray[n] = (byte)(byArray[n] ^ byArray2[i]);
        }
    }

    private static void packLength(long l, byte[] byArray, int n) {
        Pack.intToBigEndian((int)(l >>> 32), byArray, n);
        Pack.intToBigEndian((int)l, byArray, n + 4);
    }
}

