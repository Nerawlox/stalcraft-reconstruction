/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
@Beta
public final class LimitInputStream
extends FilterInputStream {
    private long left;
    private long mark = -1L;

    public LimitInputStream(InputStream in, long limit) {
        super(in);
        Preconditions.checkNotNull(in);
        Preconditions.checkArgument(limit >= 0L, "limit must be non-negative");
        this.left = limit;
    }

    @Override
    public int available() throws IOException {
        return (int)Math.min((long)this.in.available(), this.left);
    }

    @Override
    public synchronized void mark(int readlimit) {
        this.in.mark(readlimit);
        this.mark = this.left;
    }

    @Override
    public int read() throws IOException {
        if (this.left == 0L) {
            return -1;
        }
        int result2 = this.in.read();
        if (result2 != -1) {
            --this.left;
        }
        return result2;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.left == 0L) {
            return -1;
        }
        int result2 = this.in.read(b, off, len = (int)Math.min((long)len, this.left));
        if (result2 != -1) {
            this.left -= (long)result2;
        }
        return result2;
    }

    @Override
    public synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.mark == -1L) {
            throw new IOException("Mark not set");
        }
        this.in.reset();
        this.left = this.mark;
    }

    @Override
    public long skip(long n) throws IOException {
        n = Math.min(n, this.left);
        long skipped = this.in.skip(n);
        this.left -= skipped;
        return skipped;
    }
}

