/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.InputSupplier;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.Nullable;

final class MultiInputStream
extends InputStream {
    private Iterator<? extends InputSupplier<? extends InputStream>> it;
    private InputStream in;

    public MultiInputStream(Iterator<? extends InputSupplier<? extends InputStream>> it) throws IOException {
        this.it = Preconditions.checkNotNull(it);
        this.advance();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() throws IOException {
        if (this.in != null) {
            try {
                this.in.close();
            }
            finally {
                this.in = null;
            }
        }
    }

    private void advance() throws IOException {
        this.close();
        if (this.it.hasNext()) {
            this.in = this.it.next().getInput();
        }
    }

    @Override
    public int available() throws IOException {
        if (this.in == null) {
            return 0;
        }
        return this.in.available();
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read() throws IOException {
        if (this.in == null) {
            return -1;
        }
        int result2 = this.in.read();
        if (result2 == -1) {
            this.advance();
            return this.read();
        }
        return result2;
    }

    @Override
    public int read(@Nullable byte[] b, int off, int len) throws IOException {
        if (this.in == null) {
            return -1;
        }
        int result2 = this.in.read(b, off, len);
        if (result2 == -1) {
            this.advance();
            return this.read(b, off, len);
        }
        return result2;
    }

    @Override
    public long skip(long n) throws IOException {
        if (this.in == null || n <= 0L) {
            return 0L;
        }
        long result2 = this.in.skip(n);
        if (result2 != 0L) {
            return result2;
        }
        if (this.read() == -1) {
            return 0L;
        }
        return 1L + this.in.skip(n - 1L);
    }
}

