/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_l;
import com.sun.crypto.provider.SunJCE_n;
import com.sun.crypto.provider.SunJCE_q;
import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;

public final class DESedeParameters
extends AlgorithmParametersSpi {
    private byte[] a;

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof IvParameterSpec)) {
            throw new InvalidParameterSpecException("Inappropriate parameter specification");
        }
        byte[] byArray = ((IvParameterSpec)algorithmParameterSpec).getIV();
        if (byArray.length != 8) {
            throw new InvalidParameterSpecException("IV not 8 bytes long");
        }
        this.a = (byte[])byArray.clone();
    }

    protected void engineInit(byte[] byArray) throws IOException {
        SunJCE_n sunJCE_n = new SunJCE_n(byArray);
        byte[] byArray2 = sunJCE_n.f();
        if (sunJCE_n.t() != 0) {
            throw new IOException("IV parsing error: extra data");
        }
        if (byArray2.length != 8) {
            throw new IOException("IV not 8 bytes long");
        }
        this.a = byArray2;
    }

    protected void engineInit(byte[] byArray, String string) throws IOException {
        this.engineInit(byArray);
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class clazz) throws InvalidParameterSpecException {
        try {
            Class<?> clazz2 = Class.forName("javax.crypto.spec.IvParameterSpec");
            if (clazz2.isAssignableFrom(clazz)) {
                return new IvParameterSpec(this.a);
            }
            throw new InvalidParameterSpecException("Inappropriate parameter specification");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new InvalidParameterSpecException("Unsupported parameter specification: " + classNotFoundException.getMessage());
        }
    }

    protected byte[] engineGetEncoded() throws IOException {
        SunJCE_l sunJCE_l = new SunJCE_l();
        sunJCE_l.b(this.a);
        return sunJCE_l.toByteArray();
    }

    protected byte[] engineGetEncoded(String string) throws IOException {
        return this.engineGetEncoded();
    }

    protected String engineToString() {
        String string = "\n    iv:\n[";
        SunJCE_q sunJCE_q = new SunJCE_q();
        string = string + sunJCE_q.b(this.a);
        string = string + "]\n";
        return string;
    }
}

