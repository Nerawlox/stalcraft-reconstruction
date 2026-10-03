/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_ah;
import com.sun.crypto.provider.SunJCE_t;
import java.io.IOException;
import java.math.BigInteger;

class SunJCE_ai {
    private static final BigInteger a = BigInteger.valueOf(0L);
    private SunJCE_ah b;
    private byte[] c;

    public SunJCE_ai(byte[] byArray) throws IOException {
        SunJCE_t sunJCE_t = new SunJCE_t(byArray);
        if (sunJCE_t.e != 48) {
            throw new IOException("private key parse error: not a sequence");
        }
        BigInteger bigInteger = sunJCE_t.g.c();
        if (!bigInteger.equals(a)) {
            throw new IOException("version mismatch: (supported: " + a + ", parsed: " + bigInteger);
        }
        this.b = new SunJCE_ah(sunJCE_t.g.i());
        this.c = sunJCE_t.g.f();
    }

    public SunJCE_ah a() {
        return this.b;
    }
}

