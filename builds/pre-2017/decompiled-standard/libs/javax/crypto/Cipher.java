/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.Serializable;
import java.security.AccessController;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringTokenizer;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.ExemptionMechanism;
import javax.crypto.ExemptionMechanismException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.NullCipher;
import javax.crypto.ShortBufferException;
import javax.crypto.SunJCE_b;
import javax.crypto.SunJCE_g;
import javax.crypto.SunJCE_n;
import javax.crypto.SunJCE_o;
import javax.crypto.SunJCE_q;
import javax.crypto.SunJCE_r;

public class Cipher {
    public static final int ENCRYPT_MODE = 1;
    public static final int DECRYPT_MODE = 2;
    public static final int WRAP_MODE = 3;
    public static final int UNWRAP_MODE = 4;
    public static final int PUBLIC_KEY = 1;
    public static final int PRIVATE_KEY = 2;
    public static final int SECRET_KEY = 3;
    private Provider a;
    private CipherSpi b;
    private String c;
    private SunJCE_o d;
    private ExemptionMechanism e;
    private boolean f = false;
    private int g = 0;
    private int h = 0;
    private boolean i;
    private static boolean j = false;
    private boolean k;
    private static final int l = 32;
    private byte[] m;
    private static final int n = 64;
    private byte[] o;
    private static final String p = "2.5.29.15";
    static /* synthetic */ Class q;
    static /* synthetic */ Class r;
    static /* synthetic */ Class s;
    static /* synthetic */ Class t;

    protected Cipher(CipherSpi cipherSpi, Provider provider, String string) {
        this.b = cipherSpi;
        this.a = provider;
        this.c = string;
    }

    Cipher(CipherSpi cipherSpi, Provider provider, SunJCE_o sunJCE_o, ExemptionMechanism exemptionMechanism, Boolean bl, String string) {
        this(cipherSpi, provider, string);
        this.d = sunJCE_o;
        this.e = exemptionMechanism;
        this.k = sunJCE_o != null && sunJCE_o.c() == -1 ? false : (bl != null ? bl : true);
        if (this.k) {
            this.m = new byte[32];
            this.o = new byte[64];
        }
    }

    private static String[] a(String string) throws NoSuchAlgorithmException {
        if (string == null) {
            throw new NoSuchAlgorithmException("No transformation given");
        }
        String[] stringArray = new String[3];
        int n = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(string, "/");
        try {
            while (stringTokenizer.hasMoreTokens() && n < 3) {
                stringArray[n++] = stringTokenizer.nextToken().trim();
            }
            if (n == 0 || n == 2 || stringTokenizer.hasMoreTokens()) {
                throw new NoSuchAlgorithmException("Invalid transformation format:" + string);
            }
        }
        catch (NoSuchElementException noSuchElementException) {
            throw new NoSuchAlgorithmException("Invalid transformation format:" + string);
        }
        if (stringArray[0] == null || stringArray[0].equals("")) {
            throw new NoSuchAlgorithmException("Invalid transformation:algorithm not specified-" + string);
        }
        return stringArray;
    }

    private static Cipher a(String[] stringArray, String string, String string2) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
        boolean bl = false;
        boolean bl2 = false;
        Object[] objectArray = null;
        int n = 4;
        if (stringArray[1] == null || stringArray[1].equals("")) {
            n -= 2;
        }
        if (stringArray[2] == null || stringArray[2].equals("")) {
            --n;
        }
        switch (n) {
            case 4: {
                try {
                    objectArray = SunJCE_b.a(stringArray[0] + "/" + stringArray[1] + "/" + stringArray[2], "Cipher", string2);
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    try {
                        objectArray = SunJCE_b.a(stringArray[0] + "/" + stringArray[1], "Cipher", string2);
                        bl2 = true;
                    }
                    catch (NoSuchAlgorithmException noSuchAlgorithmException2) {
                        try {
                            objectArray = SunJCE_b.a(stringArray[0] + "//" + stringArray[2], "Cipher", string2);
                            bl = true;
                        }
                        catch (NoSuchAlgorithmException noSuchAlgorithmException3) {
                            objectArray = SunJCE_b.a(stringArray[0], "Cipher", string2);
                            bl = true;
                            bl2 = true;
                        }
                    }
                }
                break;
            }
            case 3: {
                try {
                    objectArray = SunJCE_b.a(stringArray[0] + "/" + stringArray[1], "Cipher", string2);
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    objectArray = SunJCE_b.a(stringArray[0], "Cipher", string2);
                    bl = true;
                }
                break;
            }
            case 2: {
                try {
                    objectArray = SunJCE_b.a(stringArray[0] + "//" + stringArray[2], "Cipher", string2);
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    objectArray = SunJCE_b.a(stringArray[0], "Cipher", string2);
                    bl2 = true;
                }
                break;
            }
            case 1: {
                objectArray = SunJCE_b.a(stringArray[0], "Cipher", string2);
            }
        }
        Cipher cipher = new Cipher((CipherSpi)objectArray[0], (Provider)objectArray[1], (SunJCE_o)objectArray[2], (ExemptionMechanism)objectArray[3], (Boolean)objectArray[4], string);
        if (bl) {
            cipher.b.engineSetMode(stringArray[1]);
        }
        if (bl2) {
            cipher.b.engineSetPadding(stringArray[2]);
        }
        return cipher;
    }

    public static final Cipher getInstance(String string) throws NoSuchAlgorithmException, NoSuchPaddingException {
        String[] stringArray = Cipher.a(string);
        Cipher cipher = null;
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length && cipher == null) {
            try {
                cipher = Cipher.a(stringArray, string, providerArray[n].getName());
            }
            catch (Exception exception) {
                // empty catch block
            }
            ++n;
        }
        if (cipher == null) {
            throw new NoSuchAlgorithmException("Cannot find any provider supporting " + string);
        }
        return cipher;
    }

    public static final Cipher getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
        String[] stringArray = Cipher.a(string);
        if (string2 == null || string2.trim().equals("")) {
            throw new IllegalArgumentException("Missing provider");
        }
        return Cipher.a(stringArray, string, string2);
    }

    public final Provider getProvider() {
        return this.a;
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public final int getBlockSize() {
        return this.b.engineGetBlockSize();
    }

    public final int getOutputSize(int n) throws IllegalStateException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (n < 0) {
            throw new IllegalArgumentException("Input size must be equal to or greater than zero");
        }
        return this.b.engineGetOutputSize(n);
    }

    public final byte[] getIV() {
        return this.b.engineGetIV();
    }

    public final AlgorithmParameters getParameters() {
        return this.b.engineGetParameters();
    }

    public final ExemptionMechanism getExemptionMechanism() {
        return this.e;
    }

    public final void init(int n, Key key) throws InvalidKeyException {
        if (n != 1 && n != 2 && n != 3 && n != 4) {
            throw new InvalidParameterException("Invalid operation mode");
        }
        if (!(this.d instanceof SunJCE_n)) {
            int n2 = this.b.engineGetKeySize(key);
            if (!this.d.implies(new SunJCE_o(key.getAlgorithm(), n2, this.d.b()))) {
                throw new SecurityException("Unsupported keysize or algorithm parameters");
            }
            if (this.e != null) {
                try {
                    if (!this.e.isCryptoAllowed(key)) {
                        throw new SecurityException(this.e.getName() + " isn't enforced");
                    }
                }
                catch (ExemptionMechanismException exemptionMechanismException) {
                    throw new InvalidKeyException("Cannot determine whether " + this.e.getName() + " has " + "been enforced");
                }
            }
        }
        this.b.engineInit(n, key, new SecureRandom());
        this.f = true;
        this.h = this.g;
        this.g = n;
        this.i = true;
    }

    public final void init(int n, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (n != 1 && n != 2 && n != 3 && n != 4) {
            throw new InvalidParameterException("Invalid operation mode");
        }
        if (!(this.d instanceof SunJCE_n)) {
            int n2 = this.b.engineGetKeySize(key);
            if (!this.d.implies(new SunJCE_o(key.getAlgorithm(), n2, this.d.b()))) {
                throw new SecurityException("Unsupported keysize or algorithm parameters");
            }
            if (this.e != null) {
                try {
                    if (!this.e.isCryptoAllowed(key)) {
                        throw new SecurityException(this.e.getName() + " isn't enforced");
                    }
                }
                catch (ExemptionMechanismException exemptionMechanismException) {
                    throw new InvalidKeyException("Cannot determine whether " + this.e.getName() + " has " + "been enforced");
                }
            }
        }
        this.b.engineInit(n, key, secureRandom);
        this.f = true;
        this.h = this.g;
        this.g = n;
        this.i = true;
    }

    public final void init(int n, Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (n != 1 && n != 2 && n != 3 && n != 4) {
            throw new InvalidParameterException("Invalid operation mode");
        }
        if (this.d == null) {
            SunJCE_g sunJCE_g = (SunJCE_g)AccessController.doPrivileged(new SunJCE_r(this));
            if (!sunJCE_g.a()) {
                throw new NullPointerException();
            }
        } else if (!(this.d instanceof SunJCE_n)) {
            int n2 = this.b.engineGetKeySize(key);
            if (!this.d.implies(new SunJCE_o(key.getAlgorithm(), n2, algorithmParameterSpec, this.d.b()))) {
                throw new SecurityException("Unsupported keysize or algorithm parameters");
            }
            if (this.e != null) {
                try {
                    if (!this.e.isCryptoAllowed(key)) {
                        throw new SecurityException(this.e.getName() + " isn't enforced");
                    }
                }
                catch (ExemptionMechanismException exemptionMechanismException) {
                    throw new InvalidKeyException("Cannot determine whether " + this.e.getName() + " has " + "been enforced");
                }
            }
        }
        this.b.engineInit(n, key, algorithmParameterSpec, new SecureRandom());
        this.f = true;
        this.h = this.g;
        this.g = n;
        this.i = true;
    }

    public final void init(int n, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (n != 1 && n != 2 && n != 3 && n != 4) {
            throw new InvalidParameterException("Invalid operation mode");
        }
        if (!(this.d instanceof SunJCE_n)) {
            int n2 = this.b.engineGetKeySize(key);
            if (!this.d.implies(new SunJCE_o(key.getAlgorithm(), n2, algorithmParameterSpec, this.d.b()))) {
                throw new SecurityException("Unsupported keysize or algorithm parameters");
            }
            if (this.e != null) {
                try {
                    if (!this.e.isCryptoAllowed(key)) {
                        throw new SecurityException(this.e.getName() + " isn't enforced");
                    }
                }
                catch (ExemptionMechanismException exemptionMechanismException) {
                    throw new InvalidKeyException("Cannot determine whether " + this.e.getName() + " has " + "been enforced");
                }
            }
        }
        this.b.engineInit(n, key, algorithmParameterSpec, secureRandom);
        this.f = true;
        this.h = this.g;
        this.g = n;
        this.i = true;
    }

    public final void init(int n, Key key, AlgorithmParameters algorithmParameters) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (n != 1 && n != 2 && n != 3 && n != 4) {
            throw new InvalidParameterException("Invalid operation mode");
        }
        if (this.d == null) {
            SunJCE_g sunJCE_g = (SunJCE_g)AccessController.doPrivileged(new SunJCE_q(this));
            if (!sunJCE_g.a()) {
                throw new NullPointerException();
            }
        } else if (!(this.d instanceof SunJCE_n)) {
            int n2 = this.b.engineGetKeySize(key);
            AlgorithmParameterSpec algorithmParameterSpec = null;
            try {
                algorithmParameterSpec = this.a(algorithmParameters);
            }
            catch (InvalidParameterSpecException invalidParameterSpecException) {
                throw new InvalidAlgorithmParameterException("Failed to retrieve algorithm parameter specification");
            }
            if (!this.d.implies(new SunJCE_o(key.getAlgorithm(), n2, algorithmParameterSpec, this.d.b()))) {
                throw new SecurityException("Unsupported keysize or algorithm parameters");
            }
            if (this.e != null) {
                try {
                    if (!this.e.isCryptoAllowed(key)) {
                        throw new SecurityException(this.e.getName() + " isn't enforced");
                    }
                }
                catch (ExemptionMechanismException exemptionMechanismException) {
                    throw new InvalidKeyException("Cannot determine whether " + this.e.getName() + " has " + "been enforced");
                }
            }
        }
        this.b.engineInit(n, key, algorithmParameters, new SecureRandom());
        this.f = true;
        this.h = this.g;
        this.g = n;
        this.i = true;
    }

    public final void init(int n, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (n != 1 && n != 2 && n != 3 && n != 4) {
            throw new InvalidParameterException("Invalid operation mode");
        }
        if (!(this.d instanceof SunJCE_n)) {
            int n2 = this.b.engineGetKeySize(key);
            AlgorithmParameterSpec algorithmParameterSpec = null;
            try {
                algorithmParameterSpec = this.a(algorithmParameters);
            }
            catch (InvalidParameterSpecException invalidParameterSpecException) {
                throw new InvalidAlgorithmParameterException("Failed to retrieve algorithm parameter specification");
            }
            if (!this.d.implies(new SunJCE_o(key.getAlgorithm(), n2, algorithmParameterSpec, this.d.b()))) {
                throw new SecurityException("Unsupported keysize or algorithm parameters");
            }
            if (this.e != null) {
                try {
                    if (!this.e.isCryptoAllowed(key)) {
                        throw new SecurityException(this.e.getName() + " isn't enforced");
                    }
                }
                catch (ExemptionMechanismException exemptionMechanismException) {
                    throw new InvalidKeyException("Cannot determine whether " + this.e.getName() + " has " + "been enforced");
                }
            }
        }
        this.b.engineInit(n, key, algorithmParameters, secureRandom);
        this.f = true;
        this.h = this.g;
        this.g = n;
        this.i = true;
    }

    public final void init(int n, Certificate certificate) throws InvalidKeyException {
        this.init(n, certificate, new SecureRandom());
    }

    public final void init(int n, Certificate certificate, SecureRandom secureRandom) throws InvalidKeyException {
        boolean[] blArray;
        Serializable serializable;
        Set<String> set;
        if (n != 1 && n != 2 && n != 3 && n != 4) {
            throw new InvalidParameterException("Invalid operation mode");
        }
        if (certificate instanceof X509Certificate && (set = (serializable = (X509Certificate)certificate).getCriticalExtensionOIDs()) != null && !set.isEmpty() && set.contains(p) && (blArray = ((X509Certificate)serializable).getKeyUsage()) != null && (n == 1 && blArray.length > 3 && !blArray[3] || n == 3 && blArray.length > 2 && !blArray[2])) {
            throw new InvalidKeyException("Wrong key usage");
        }
        serializable = certificate.getPublicKey();
        if (!(this.d instanceof SunJCE_n)) {
            int n2 = this.b.engineGetKeySize((Key)serializable);
            if (!this.d.implies(new SunJCE_o(serializable.getAlgorithm(), n2))) {
                throw new SecurityException("Unsupported keysize or algorithm parameters");
            }
        }
        this.b.engineInit(n, (Key)serializable, secureRandom);
        this.f = true;
        this.g = n;
        this.i = true;
    }

    public final byte[] update(byte[] byArray) throws IllegalStateException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (byArray == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        if (byArray.length == 0) {
            return null;
        }
        if (this.k) {
            this.a(byArray, 0, byArray.length);
        }
        byte[] byArray2 = this.b.engineUpdate(byArray, 0, byArray.length);
        if (this.k) {
            this.a(byArray2, 0);
        }
        return byArray2;
    }

    public final byte[] update(byte[] byArray, int n, int n2) throws IllegalStateException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (byArray == null || n < 0 || n2 > byArray.length - n || n2 < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        if (n2 == 0) {
            return null;
        }
        if (this.k) {
            this.a(byArray, n, n2);
        }
        byte[] byArray2 = this.b.engineUpdate(byArray, n, n2);
        if (this.k) {
            this.a(byArray2, 0);
        }
        return byArray2;
    }

    public final int update(byte[] byArray, int n, int n2, byte[] byArray2) throws IllegalStateException, ShortBufferException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (byArray == null || n < 0 || n2 > byArray.length - n || n2 < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        if (n2 == 0) {
            return 0;
        }
        if (this.k) {
            this.a(byArray, n, n2);
        }
        int n3 = this.b.engineUpdate(byArray, n, n2, byArray2, 0);
        if (this.k) {
            this.a(byArray2, 0);
        }
        return n3;
    }

    public final int update(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalStateException, ShortBufferException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (byArray == null || n < 0 || n2 > byArray.length - n || n2 < 0 || n3 < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        if (n2 == 0) {
            return 0;
        }
        if (this.k) {
            this.a(byArray, n, n2);
        }
        int n4 = this.b.engineUpdate(byArray, n, n2, byArray2, n3);
        if (this.k) {
            this.a(byArray2, n3);
        }
        return n4;
    }

    public final byte[] doFinal() throws IllegalStateException, IllegalBlockSizeException, BadPaddingException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        byte[] byArray = this.b.engineDoFinal(null, 0, 0);
        if (this.k) {
            this.a(byArray, 0);
        }
        return byArray;
    }

    public final int doFinal(byte[] byArray, int n) throws IllegalStateException, IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (byArray == null || n < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        int n2 = this.b.engineDoFinal(null, 0, 0, byArray, n);
        if (this.k) {
            this.a(byArray, n);
        }
        return n2;
    }

    public final byte[] doFinal(byte[] byArray) throws IllegalStateException, IllegalBlockSizeException, BadPaddingException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (byArray == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        if (this.k) {
            this.a(byArray, 0, byArray.length);
        }
        byte[] byArray2 = this.b.engineDoFinal(byArray, 0, byArray.length);
        if (this.k) {
            this.a(byArray2, 0);
        }
        return byArray2;
    }

    public final byte[] doFinal(byte[] byArray, int n, int n2) throws IllegalStateException, IllegalBlockSizeException, BadPaddingException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (byArray == null || n < 0 || n2 > byArray.length - n || n2 < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        if (this.k) {
            this.a(byArray, n, n2);
        }
        byte[] byArray2 = this.b.engineDoFinal(byArray, n, n2);
        if (this.k) {
            this.a(byArray2, 0);
        }
        return byArray2;
    }

    public final int doFinal(byte[] byArray, int n, int n2, byte[] byArray2) throws IllegalStateException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (byArray == null || n < 0 || n2 > byArray.length - n || n2 < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        if (this.k && !(this instanceof NullCipher)) {
            this.a(byArray, n, n2);
        }
        int n3 = this.b.engineDoFinal(byArray, n, n2, byArray2, 0);
        if (this.k && !(this instanceof NullCipher)) {
            this.a(byArray2, 0);
        }
        return n3;
    }

    public final int doFinal(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalStateException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (byArray == null || n < 0 || n2 > byArray.length - n || n2 < 0 || n3 < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        if (this.k) {
            this.a(byArray, n, n2);
        }
        int n4 = this.b.engineDoFinal(byArray, n, n2, byArray2, n3);
        if (this.k) {
            this.a(byArray2, n3);
        }
        return n4;
    }

    public final byte[] wrap(Key key) throws IllegalStateException, IllegalBlockSizeException, InvalidKeyException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (this.g != 3) {
            throw new IllegalStateException("Cipher not initialized for wrapping keys");
        }
        return this.b.engineWrap(key);
    }

    public final Key unwrap(byte[] byArray, String string, int n) throws IllegalStateException, InvalidKeyException, NoSuchAlgorithmException {
        if (!this.f && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (this.g != 4) {
            throw new IllegalStateException("Cipher not initialized for unwrapping keys");
        }
        if (n != 3 && n != 2 && n != 1) {
            throw new InvalidParameterException("Invalid key type");
        }
        return this.b.engineUnwrap(byArray, string, n);
    }

    private void a(byte[] byArray, int n, int n2) {
        if (!j) {
            return;
        }
        if (!this.i && n2 - n >= 64 && this.a(byArray, n, this.o, 0, 64)) {
            throw new SecurityException("Bad cipher state");
        }
        if (this.i && this.h == this.g) {
            if (n2 - n >= 32 && this.a(byArray, n, this.m, 0, 32)) {
                throw new SecurityException("Bad cipher state");
            }
            if (n2 - n >= 64 && this.a(byArray, n, this.o, 0, 64)) {
                throw new SecurityException("Bad cipher state");
            }
        }
    }

    private void a(byte[] byArray, int n) {
        if (byArray == null) {
            j = false;
            return;
        }
        j = true;
        if (this.i) {
            if (byArray.length - n >= 32) {
                System.arraycopy(byArray, n, this.m, 0, 32);
            } else {
                System.arraycopy(byArray, n, this.m, 0, byArray.length - n);
                Arrays.fill(this.m, byArray.length - n, 32, (byte)0);
            }
            this.i = false;
        }
        if (byArray.length - n >= 64) {
            System.arraycopy(byArray, n, this.o, 0, 64);
        } else {
            System.arraycopy(byArray, n, this.o, 0, byArray.length - n);
            Arrays.fill(this.o, byArray.length - n, 64, (byte)0);
        }
    }

    private boolean a(byte[] byArray, int n, byte[] byArray2, int n2, int n3) {
        if (byArray.length < n + n3 || byArray2.length < n2 + n3) {
            return false;
        }
        int n4 = 0;
        while (n4 < n3) {
            if (byArray[n4 + n] != byArray2[n4 + n2]) {
                return false;
            }
            ++n4;
        }
        return true;
    }

    private AlgorithmParameterSpec a(AlgorithmParameters algorithmParameters) throws InvalidParameterSpecException {
        if (algorithmParameters == null) {
            return null;
        }
        String string = algorithmParameters.getAlgorithm().toUpperCase();
        if (string.equalsIgnoreCase("RC2")) {
            return algorithmParameters.getParameterSpec(q == null ? (q = Cipher.class$("javax.crypto.spec.RC2ParameterSpec")) : q);
        }
        if (string.equalsIgnoreCase("RC5")) {
            return algorithmParameters.getParameterSpec(r == null ? (r = Cipher.class$("javax.crypto.spec.RC5ParameterSpec")) : r);
        }
        if (string.startsWith("PBE")) {
            return algorithmParameters.getParameterSpec(s == null ? (s = Cipher.class$("javax.crypto.spec.PBEParameterSpec")) : s);
        }
        if (string.startsWith("DES")) {
            return algorithmParameters.getParameterSpec(t == null ? (t = Cipher.class$("javax.crypto.spec.IvParameterSpec")) : t);
        }
        return null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }
}

