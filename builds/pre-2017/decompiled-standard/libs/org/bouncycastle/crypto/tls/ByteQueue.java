/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.tls.TlsRuntimeException;

public class ByteQueue {
    private static final int INITBUFSIZE = 1024;
    private byte[] databuf = new byte[1024];
    private int skipped = 0;
    private int available = 0;

    public static final int nextTwoPow(int n) {
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n + 1;
    }

    public void read(byte[] byArray, int n, int n2, int n3) {
        if (this.available - n3 < n2) {
            throw new TlsRuntimeException("Not enough data to read");
        }
        if (byArray.length - n < n2) {
            throw new TlsRuntimeException("Buffer size of " + byArray.length + " is too small for a read of " + n2 + " bytes");
        }
        System.arraycopy(this.databuf, this.skipped + n3, byArray, n, n2);
    }

    public void addData(byte[] byArray, int n, int n2) {
        if (this.skipped + this.available + n2 > this.databuf.length) {
            byte[] byArray2 = new byte[ByteQueue.nextTwoPow(byArray.length)];
            System.arraycopy(this.databuf, this.skipped, byArray2, 0, this.available);
            this.skipped = 0;
            this.databuf = byArray2;
        }
        System.arraycopy(byArray, n, this.databuf, this.skipped + this.available, n2);
        this.available += n2;
    }

    public void removeData(int n) {
        if (n > this.available) {
            throw new TlsRuntimeException("Cannot remove " + n + " bytes, only got " + this.available);
        }
        this.available -= n;
        this.skipped += n;
        if (this.skipped > this.databuf.length / 2) {
            System.arraycopy(this.databuf, this.skipped, this.databuf, 0, this.available);
            this.skipped = 0;
        }
    }

    public int size() {
        return this.available;
    }
}

