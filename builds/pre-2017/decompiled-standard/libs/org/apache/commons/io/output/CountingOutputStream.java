/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.output;

import java.io.OutputStream;
import org.apache.commons.io.output.ProxyOutputStream;

public class CountingOutputStream
extends ProxyOutputStream {
    private long count = 0L;

    public CountingOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    protected synchronized void beforeWrite(int n) {
        this.count += (long)n;
    }

    public int getCount() {
        long result2 = this.getByteCount();
        if (result2 > Integer.MAX_VALUE) {
            throw new ArithmeticException("The byte count " + result2 + " is too large to be converted to an int");
        }
        return (int)result2;
    }

    public int resetCount() {
        long result2 = this.resetByteCount();
        if (result2 > Integer.MAX_VALUE) {
            throw new ArithmeticException("The byte count " + result2 + " is too large to be converted to an int");
        }
        return (int)result2;
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public synchronized long resetByteCount() {
        long tmp = this.count;
        this.count = 0L;
        return tmp;
    }
}

