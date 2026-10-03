/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ExemptionMechanismException;
import javax.crypto.ExemptionMechanismSpi;
import javax.crypto.ShortBufferException;
import javax.crypto.SunJCE_b;

public class ExemptionMechanism {
    private Provider provider;
    private ExemptionMechanismSpi exmechSpi;
    private String mechanism;
    private boolean done = false;
    private boolean initialized = false;
    private Key keyStored = null;

    protected ExemptionMechanism(ExemptionMechanismSpi exemptionMechanismSpi, Provider provider, String string) {
        this.exmechSpi = exemptionMechanismSpi;
        this.provider = provider;
        this.mechanism = string;
    }

    public final String getName() {
        return this.mechanism;
    }

    public static final ExemptionMechanism getInstance(String string) throws NoSuchAlgorithmException {
        try {
            Object[] objectArray = SunJCE_b.a(string, "ExemptionMechanism", (String)null);
            return new ExemptionMechanism((ExemptionMechanismSpi)objectArray[0], (Provider)objectArray[1], string);
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new NoSuchAlgorithmException(string + " not found");
        }
    }

    public static final ExemptionMechanism getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (string2 == null || string2.length() == 0) {
            throw new IllegalArgumentException("missing provider");
        }
        Object[] objectArray = SunJCE_b.a(string, "ExemptionMechanism", string2);
        return new ExemptionMechanism((ExemptionMechanismSpi)objectArray[0], (Provider)objectArray[1], string);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final boolean isCryptoAllowed(Key key) throws ExemptionMechanismException {
        boolean bl = false;
        if (this.done && key != null) {
            bl = this.keyStored.equals(key);
        }
        return bl;
    }

    public final int getOutputSize(int n) throws IllegalStateException {
        if (!this.initialized) {
            throw new IllegalStateException("ExemptionMechanism not initialized");
        }
        if (n < 0) {
            throw new IllegalArgumentException("Input size must be equal to or greater than zero");
        }
        return this.exmechSpi.engineGetOutputSize(n);
    }

    public final void init(Key key) throws InvalidKeyException, ExemptionMechanismException {
        this.done = false;
        this.initialized = false;
        this.keyStored = key;
        this.exmechSpi.engineInit(key);
        this.initialized = true;
    }

    public final void init(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException {
        this.done = false;
        this.initialized = false;
        this.keyStored = key;
        this.exmechSpi.engineInit(key, algorithmParameterSpec);
        this.initialized = true;
    }

    public final void init(Key key, AlgorithmParameters algorithmParameters) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException {
        this.done = false;
        this.initialized = false;
        this.keyStored = key;
        this.exmechSpi.engineInit(key, algorithmParameters);
        this.initialized = true;
    }

    public final byte[] genExemptionBlob() throws IllegalStateException, ExemptionMechanismException {
        if (!this.initialized) {
            throw new IllegalStateException("ExemptionMechanism not initialized");
        }
        byte[] byArray = this.exmechSpi.engineGenExemptionBlob();
        this.done = true;
        return byArray;
    }

    public final int genExemptionBlob(byte[] byArray) throws IllegalStateException, ShortBufferException, ExemptionMechanismException {
        if (!this.initialized) {
            throw new IllegalStateException("ExemptionMechanism not initialized");
        }
        int n = this.exmechSpi.engineGenExemptionBlob(byArray, 0);
        this.done = true;
        return n;
    }

    public final int genExemptionBlob(byte[] byArray, int n) throws IllegalStateException, ShortBufferException, ExemptionMechanismException {
        if (!this.initialized) {
            throw new IllegalStateException("ExemptionMechanism not initialized");
        }
        int n2 = this.exmechSpi.engineGenExemptionBlob(byArray, n);
        this.done = true;
        return n2;
    }

    protected void finalize() {
        this.keyStored = null;
    }
}

