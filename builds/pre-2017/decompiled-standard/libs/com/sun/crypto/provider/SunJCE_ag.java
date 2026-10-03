/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_ah;
import com.sun.crypto.provider.SunJCE_l;
import com.sun.crypto.provider.SunJCE_t;
import java.io.IOException;

class SunJCE_ag {
    private SunJCE_ah a;
    private byte[] b;
    private byte[] c;

    public SunJCE_ag(byte[] byArray) throws IOException {
        SunJCE_t sunJCE_t = new SunJCE_t(byArray);
        SunJCE_t[] sunJCE_tArray = new SunJCE_t[]{sunJCE_t.g.i(), sunJCE_t.g.i()};
        if (sunJCE_t.g.t() != 0) {
            throw new IOException("overrun, bytes = " + sunJCE_t.g.t());
        }
        this.a = new SunJCE_ah(sunJCE_tArray[0]);
        if (sunJCE_tArray[0].g.t() != 0) {
            throw new IOException("encryptionAlgorithm field overrun");
        }
        this.b = sunJCE_tArray[1].j();
        if (sunJCE_tArray[1].g.t() != 0) {
            throw new IOException("encryptedData field overrun");
        }
        this.c = (byte[])byArray.clone();
    }

    public SunJCE_ag(SunJCE_ah sunJCE_ah, byte[] byArray) {
        this.a = sunJCE_ah;
        this.b = (byte[])byArray.clone();
    }

    public SunJCE_ah a() {
        return this.a;
    }

    public byte[] b() {
        return (byte[])this.b.clone();
    }

    public byte[] c() throws IOException {
        if (this.c != null) {
            return (byte[])this.c.clone();
        }
        SunJCE_l sunJCE_l = new SunJCE_l();
        SunJCE_l sunJCE_l2 = new SunJCE_l();
        this.a.a(sunJCE_l2);
        sunJCE_l2.b(this.b);
        sunJCE_l.a((byte)48, sunJCE_l2);
        this.c = sunJCE_l.toByteArray();
        return (byte[])this.c.clone();
    }
}

