/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_l;
import com.sun.crypto.provider.SunJCE_t;
import com.sun.crypto.provider.SunJCE_u;
import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;

public final class DHParameters
extends AlgorithmParametersSpi {
    protected BigInteger a;
    protected BigInteger b;
    private int c;

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidParameterSpecException("Inappropriate parameter specification");
        }
        this.a = ((DHParameterSpec)algorithmParameterSpec).getP();
        this.b = ((DHParameterSpec)algorithmParameterSpec).getG();
        this.c = ((DHParameterSpec)algorithmParameterSpec).getL();
    }

    protected void engineInit(byte[] byArray) throws IOException {
        try {
            SunJCE_t sunJCE_t = new SunJCE_t(byArray);
            if (sunJCE_t.e != 48) {
                throw new IOException("DH params parsing error");
            }
            sunJCE_t.g.s();
            this.a = sunJCE_t.g.c();
            this.b = sunJCE_t.g.c();
            if (sunJCE_t.g.t() != 0) {
                this.c = sunJCE_t.g.b();
            }
            if (sunJCE_t.g.t() != 0) {
                throw new IOException("DH parameter parsing error: Extra data");
            }
        }
        catch (NumberFormatException numberFormatException) {
            throw new IOException("Private-value length too big");
        }
    }

    protected void engineInit(byte[] byArray, String string) throws IOException {
        this.engineInit(byArray);
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class clazz) throws InvalidParameterSpecException {
        try {
            Class<?> clazz2 = Class.forName("javax.crypto.spec.DHParameterSpec");
            if (clazz2.isAssignableFrom(clazz)) {
                return new DHParameterSpec(this.a, this.b, this.c);
            }
            throw new InvalidParameterSpecException("Inappropriate parameter Specification");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new InvalidParameterSpecException("Unsupported parameter specification: " + classNotFoundException.getMessage());
        }
    }

    protected byte[] engineGetEncoded() throws IOException {
        SunJCE_l sunJCE_l = new SunJCE_l();
        SunJCE_l sunJCE_l2 = new SunJCE_l();
        sunJCE_l2.a(this.a);
        sunJCE_l2.a(this.b);
        if (this.c > 0) {
            sunJCE_l2.a(BigInteger.valueOf(this.c));
        }
        sunJCE_l.a((byte)48, sunJCE_l2);
        return sunJCE_l.toByteArray();
    }

    protected byte[] engineGetEncoded(String string) throws IOException {
        return this.engineGetEncoded();
    }

    protected String engineToString() {
        StringBuffer stringBuffer = new StringBuffer("SunJCE Diffie-Hellman Parameters:\np:\n" + SunJCE_u.a(this.a) + "\n" + "g:\n" + SunJCE_u.a(this.b));
        if (this.c != 0) {
            stringBuffer.append("\nl:\n    " + this.c);
        }
        return stringBuffer.toString();
    }
}

