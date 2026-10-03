/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_l;
import com.sun.crypto.provider.SunJCE_q;
import com.sun.crypto.provider.SunJCE_t;
import com.sun.crypto.provider.SunJCE_u;
import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.PBEParameterSpec;

public final class PBEParameters
extends AlgorithmParametersSpi {
    private byte[] a;
    private int b;

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
            throw new InvalidParameterSpecException("Inappropriate parameter specification");
        }
        this.a = (byte[])((PBEParameterSpec)algorithmParameterSpec).getSalt().clone();
        this.b = ((PBEParameterSpec)algorithmParameterSpec).getIterationCount();
    }

    protected void engineInit(byte[] byArray) throws IOException {
        try {
            SunJCE_t sunJCE_t = new SunJCE_t(byArray);
            if (sunJCE_t.e != 48) {
                throw new IOException("PBE parameter parsing error: not a sequence");
            }
            sunJCE_t.g.s();
            this.a = sunJCE_t.g.f();
            this.b = sunJCE_t.g.b();
            if (sunJCE_t.g.t() != 0) {
                throw new IOException("PBE parameter parsing error: extra data");
            }
        }
        catch (NumberFormatException numberFormatException) {
            throw new IOException("iteration count too big");
        }
    }

    protected void engineInit(byte[] byArray, String string) throws IOException {
        this.engineInit(byArray);
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class clazz) throws InvalidParameterSpecException {
        try {
            Class<?> clazz2 = Class.forName("javax.crypto.spec.PBEParameterSpec");
            if (clazz2.isAssignableFrom(clazz)) {
                return new PBEParameterSpec(this.a, this.b);
            }
            throw new InvalidParameterSpecException("Inappropriate parameter specification");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new InvalidParameterSpecException("Unsupported parameter specification: " + classNotFoundException.getMessage());
        }
    }

    protected byte[] engineGetEncoded() throws IOException {
        SunJCE_l sunJCE_l = new SunJCE_l();
        SunJCE_l sunJCE_l2 = new SunJCE_l();
        sunJCE_l2.b(this.a);
        sunJCE_l2.a(BigInteger.valueOf(this.b));
        sunJCE_l.a((byte)48, sunJCE_l2);
        return sunJCE_l.toByteArray();
    }

    protected byte[] engineGetEncoded(String string) throws IOException {
        return this.engineGetEncoded();
    }

    protected String engineToString() {
        String string = "\n    salt:\n[";
        SunJCE_q sunJCE_q = new SunJCE_q();
        string = string + sunJCE_q.b(this.a);
        string = string + "]";
        return string + "\n    iterationCount:\n" + SunJCE_u.a(BigInteger.valueOf(this.b)) + "\n";
    }
}

