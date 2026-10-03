/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;

public class CMac
implements Mac {
    private static final byte CONSTANT_128 = -121;
    private static final byte CONSTANT_64 = 27;
    private byte[] ZEROES;
    private byte[] mac;
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;
    private int macSize;
    private byte[] L;
    private byte[] Lu;
    private byte[] Lu2;

    public CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    public CMac(BlockCipher blockCipher, int n) {
        if (n % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        if (n > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("MAC size must be less or equal to " + blockCipher.getBlockSize() * 8);
        }
        if (blockCipher.getBlockSize() != 8 && blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("Block size must be either 64 or 128 bits");
        }
        this.cipher = new CBCBlockCipher(blockCipher);
        this.macSize = n / 8;
        this.mac = new byte[blockCipher.getBlockSize()];
        this.buf = new byte[blockCipher.getBlockSize()];
        this.ZEROES = new byte[blockCipher.getBlockSize()];
        this.bufOff = 0;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    private byte[] doubleLu(byte[] byArray) {
        int n = (byArray[0] & 0xFF) >> 7;
        byte[] byArray2 = new byte[byArray.length];
        for (int i = 0; i < byArray.length - 1; ++i) {
            byArray2[i] = (byte)((byArray[i] << 1) + ((byArray[i + 1] & 0xFF) >> 7));
        }
        byArray2[byArray.length - 1] = (byte)(byArray[byArray.length - 1] << 1);
        if (n == 1) {
            int n2 = byArray.length - 1;
            byArray2[n2] = (byte)(byArray2[n2] ^ (byArray.length == 16 ? -121 : 27));
        }
        return byArray2;
    }

    public void init(CipherParameters cipherParameters) {
        this.reset();
        this.cipher.init(true, cipherParameters);
        this.L = new byte[this.ZEROES.length];
        this.cipher.processBlock(this.ZEROES, 0, this.L, 0);
        this.Lu = this.doubleLu(this.L);
        this.Lu2 = this.doubleLu(this.Lu);
        this.cipher.init(true, cipherParameters);
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void update(byte by) {
        if (this.bufOff == this.buf.length) {
            this.cipher.processBlock(this.buf, 0, this.mac, 0);
            this.bufOff = 0;
        }
        this.buf[this.bufOff++] = by;
    }

    public void update(byte[] byArray, int n, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int n3 = this.cipher.getBlockSize();
        int n4 = n3 - this.bufOff;
        if (n2 > n4) {
            System.arraycopy(byArray, n, this.buf, this.bufOff, n4);
            this.cipher.processBlock(this.buf, 0, this.mac, 0);
            this.bufOff = 0;
            n2 -= n4;
            n += n4;
            while (n2 > n3) {
                this.cipher.processBlock(byArray, n, this.mac, 0);
                n2 -= n3;
                n += n3;
            }
        }
        System.arraycopy(byArray, n, this.buf, this.bufOff, n2);
        this.bufOff += n2;
    }

    public int doFinal(byte[] byArray, int n) {
        byte[] byArray2;
        int n2 = this.cipher.getBlockSize();
        if (this.bufOff == n2) {
            byArray2 = this.Lu;
        } else {
            new ISO7816d4Padding().addPadding(this.buf, this.bufOff);
            byArray2 = this.Lu2;
        }
        for (int i = 0; i < this.mac.length; ++i) {
            int n3 = i;
            this.buf[n3] = (byte)(this.buf[n3] ^ byArray2[i]);
        }
        this.cipher.processBlock(this.buf, 0, this.mac, 0);
        System.arraycopy(this.mac, 0, byArray, n, this.macSize);
        this.reset();
        return this.macSize;
    }

    public void reset() {
        for (int i = 0; i < this.buf.length; ++i) {
            this.buf[i] = 0;
        }
        this.bufOff = 0;
        this.cipher.reset();
    }
}

