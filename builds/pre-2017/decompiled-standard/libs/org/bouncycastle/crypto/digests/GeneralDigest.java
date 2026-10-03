/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;

public abstract class GeneralDigest
implements ExtendedDigest {
    private static final int BYTE_LENGTH = 64;
    private byte[] xBuf;
    private int xBufOff;
    private long byteCount;

    protected GeneralDigest() {
        this.xBuf = new byte[4];
        this.xBufOff = 0;
    }

    protected GeneralDigest(GeneralDigest generalDigest) {
        this.xBuf = new byte[generalDigest.xBuf.length];
        System.arraycopy(generalDigest.xBuf, 0, this.xBuf, 0, generalDigest.xBuf.length);
        this.xBufOff = generalDigest.xBufOff;
        this.byteCount = generalDigest.byteCount;
    }

    public void update(byte by) {
        this.xBuf[this.xBufOff++] = by;
        if (this.xBufOff == this.xBuf.length) {
            this.processWord(this.xBuf, 0);
            this.xBufOff = 0;
        }
        ++this.byteCount;
    }

    public void update(byte[] byArray, int n, int n2) {
        while (this.xBufOff != 0 && n2 > 0) {
            this.update(byArray[n]);
            ++n;
            --n2;
        }
        while (n2 > this.xBuf.length) {
            this.processWord(byArray, n);
            n += this.xBuf.length;
            n2 -= this.xBuf.length;
            this.byteCount += (long)this.xBuf.length;
        }
        while (n2 > 0) {
            this.update(byArray[n]);
            ++n;
            --n2;
        }
    }

    public void finish() {
        long l = this.byteCount << 3;
        this.update((byte)-128);
        while (this.xBufOff != 0) {
            this.update((byte)0);
        }
        this.processLength(l);
        this.processBlock();
    }

    public void reset() {
        this.byteCount = 0L;
        this.xBufOff = 0;
        for (int i = 0; i < this.xBuf.length; ++i) {
            this.xBuf[i] = 0;
        }
    }

    public int getByteLength() {
        return 64;
    }

    protected abstract void processWord(byte[] var1, int var2);

    protected abstract void processLength(long var1);

    protected abstract void processBlock();
}

