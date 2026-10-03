/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_d;
import javax.crypto.ShortBufferException;

class SunJCE_ac
implements SunJCE_d {
    SunJCE_ac() {
    }

    public int a(byte[] byArray, int n, int n2) throws ShortBufferException {
        if (byArray == null) {
            return 0;
        }
        int n3 = 8 - n2 % 8;
        if (n + n2 + n3 > byArray.length) {
            throw new ShortBufferException("Buffer too small to hold padding");
        }
        int n4 = 0;
        while (n4 < n3) {
            byArray[n4 + n + n2] = n3;
            ++n4;
        }
        return n3;
    }

    public void b(byte[] byArray, int n, int n2) throws ShortBufferException {
        if (byArray == null) {
            return;
        }
        if (n + n2 > byArray.length) {
            throw new ShortBufferException("Buffer too small to hold padding");
        }
        byte by = (byte)(n2 & 0xF);
        int n3 = 0;
        while (n3 < n2) {
            byArray[n3 + n] = by;
            ++n3;
        }
    }

    public int c(byte[] byArray, int n, int n2) {
        if (byArray == null || n2 == 0) {
            return 0;
        }
        byte by = byArray[n + n2 - 1];
        if ((by & 0xFF) < 1 || (by & 0xFF) > 8) {
            return -1;
        }
        int n3 = n + n2 - (by & 0xFF);
        if (n3 < n) {
            return -1;
        }
        int n4 = 0;
        while (n4 < (by & 0xFF)) {
            if (byArray[n3 + n4] != by) {
                return -1;
            }
            ++n4;
        }
        return n3;
    }

    public int a(int n) {
        int n2 = 8 - n % 8;
        return n2;
    }
}

