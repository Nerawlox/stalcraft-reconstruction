/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.MacSpi;
import javax.crypto.ShortBufferException;
import javax.crypto.SunJCE_b;

public class Mac
implements Cloneable {
    private Provider a;
    private MacSpi b;
    private String c;
    private boolean d = false;

    protected Mac(MacSpi macSpi, Provider provider, String string) {
        this.b = macSpi;
        this.a = provider;
        this.c = string;
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public static final Mac getInstance(String string) throws NoSuchAlgorithmException {
        try {
            Object[] objectArray = SunJCE_b.a(string, "Mac", (String)null);
            return new Mac((MacSpi)objectArray[0], (Provider)objectArray[1], string);
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new NoSuchAlgorithmException(string + " not found");
        }
    }

    public static final Mac getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (string2 == null || string2.length() == 0) {
            throw new IllegalArgumentException("missing provider");
        }
        Object[] objectArray = SunJCE_b.a(string, "Mac", string2);
        return new Mac((MacSpi)objectArray[0], (Provider)objectArray[1], string);
    }

    public final Provider getProvider() {
        return this.a;
    }

    public final int getMacLength() {
        return this.b.engineGetMacLength();
    }

    public final void init(Key key) throws InvalidKeyException {
        try {
            this.b.engineInit(key, null);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            // empty catch block
        }
        this.d = true;
    }

    public final void init(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.b.engineInit(key, algorithmParameterSpec);
        this.d = true;
    }

    public final void update(byte by) throws IllegalStateException {
        if (!this.d) {
            throw new IllegalStateException("MAC not initialized");
        }
        this.b.engineUpdate(by);
    }

    public final void update(byte[] byArray) throws IllegalStateException {
        if (!this.d) {
            throw new IllegalStateException("MAC not initialized");
        }
        if (byArray != null) {
            this.b.engineUpdate(byArray, 0, byArray.length);
        }
    }

    public final void update(byte[] byArray, int n, int n2) throws IllegalStateException {
        if (!this.d) {
            throw new IllegalStateException("MAC not initialized");
        }
        if (byArray != null) {
            if (n < 0 || n2 > byArray.length - n || n2 < 0) {
                throw new IllegalArgumentException("Bad arguments");
            }
            this.b.engineUpdate(byArray, n, n2);
        }
    }

    public final byte[] doFinal() throws IllegalStateException {
        if (!this.d) {
            throw new IllegalStateException("MAC not initialized");
        }
        byte[] byArray = this.b.engineDoFinal();
        this.b.engineReset();
        return byArray;
    }

    public final void doFinal(byte[] byArray, int n) throws ShortBufferException, IllegalStateException {
        if (!this.d) {
            throw new IllegalStateException("MAC not initialized");
        }
        int n2 = this.getMacLength();
        if (byArray == null || byArray.length - n < n2) {
            throw new ShortBufferException("Cannot store MAC in output buffer");
        }
        byte[] byArray2 = this.doFinal();
        System.arraycopy(byArray2, 0, byArray, n, n2);
    }

    public final byte[] doFinal(byte[] byArray) throws IllegalStateException {
        if (!this.d) {
            throw new IllegalStateException("MAC not initialized");
        }
        this.update(byArray);
        return this.doFinal();
    }

    public final void reset() {
        this.b.engineReset();
    }

    public final Object clone() throws CloneNotSupportedException {
        Mac mac = (Mac)super.clone();
        mac.b = (MacSpi)this.b.clone();
        return mac;
    }
}

