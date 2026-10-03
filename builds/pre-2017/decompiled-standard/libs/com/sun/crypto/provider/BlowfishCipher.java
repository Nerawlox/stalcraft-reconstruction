/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE;
import com.sun.crypto.provider.SunJCE_aa;
import com.sun.crypto.provider.SunJCE_ab;
import com.sun.crypto.provider.SunJCE_ac;
import com.sun.crypto.provider.SunJCE_c;
import com.sun.crypto.provider.SunJCE_d;
import com.sun.crypto.provider.SunJCE_e;
import com.sun.crypto.provider.SunJCE_f;
import com.sun.crypto.provider.SunJCE_g;
import com.sun.crypto.provider.SunJCE_h;
import com.sun.crypto.provider.SunJCE_i;
import com.sun.crypto.provider.SunJCE_j;
import com.sun.crypto.provider.SunJCE_k;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;

public final class BlowfishCipher
extends CipherSpi
implements SunJCE_c {
    private byte[] a = null;
    private int b = 0;
    private int c = 0;
    private int d = 8;
    private SunJCE_d e = null;
    private SunJCE_e f = null;
    private int g;
    private boolean h = false;
    private static final int i = 0;
    private static final int j = 1;
    private static final int k = 2;
    private static final int l = 3;
    private static final int m = 4;
    private SunJCE_e n;
    static /* synthetic */ Class o;

    public BlowfishCipher() {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
        try {
            this.a();
            this.b = 8;
            this.a = new byte[16];
            this.g = 0;
            SunJCE_ab sunJCE_ab = new SunJCE_ab();
            sunJCE_ab.a(this.n);
            this.f = sunJCE_ab;
            this.e = new SunJCE_ac();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
    }

    public BlowfishCipher(String string, String string2) throws NoSuchAlgorithmException, NoSuchPaddingException {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
        this.a();
        this.b = 8;
        this.a = new byte[16];
        if (string.equalsIgnoreCase("ECB")) {
            this.g = 0;
            SunJCE_ab sunJCE_ab = new SunJCE_ab();
            sunJCE_ab.a(this.n);
            this.f = sunJCE_ab;
        } else {
            this.engineSetMode(string);
        }
        if (string2.equalsIgnoreCase("PKCS5Padding")) {
            this.e = new SunJCE_ac();
        } else {
            this.engineSetPadding(string2);
        }
    }

    private void a() {
        this.n = new SunJCE_aa();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void engineSetMode(String string) throws NoSuchAlgorithmException {
        if (string == null) {
            throw new NoSuchAlgorithmException("null mode");
        }
        String string2 = string.toUpperCase();
        if (string2.equals("ECB")) {
            return;
        }
        if (string2.equals("CBC")) {
            this.g = 1;
            SunJCE_g sunJCE_g = new SunJCE_g();
            sunJCE_g.a(this.n);
            this.f = sunJCE_g;
            return;
        }
        if (string2.startsWith("CFB")) {
            this.g = 2;
            SunJCE_h sunJCE_h = null;
            if (string.length() > 3) {
                int n;
                Integer n2 = null;
                try {
                    n2 = Integer.valueOf(string.substring(3));
                }
                catch (NumberFormatException numberFormatException) {
                    throw new NoSuchAlgorithmException("Algorithm mode: " + string + " not implemented");
                }
                if (n2 == null || (n = n2.intValue()) % 8 != 0 || (this.b = n >> 3) > 8) throw new NoSuchAlgorithmException("Invalid algorithm mode: " + string);
                sunJCE_h = new SunJCE_h(this.b);
            } else {
                sunJCE_h = new SunJCE_h();
            }
            sunJCE_h.a(this.n);
            this.f = sunJCE_h;
            return;
        }
        if (string2.startsWith("OFB")) {
            this.g = 3;
            SunJCE_i sunJCE_i = null;
            if (string.length() > 3) {
                int n;
                Integer n3 = null;
                try {
                    n3 = Integer.valueOf(string.substring(3));
                }
                catch (NumberFormatException numberFormatException) {
                    throw new NoSuchAlgorithmException("Algorithm mode: " + string + " not implemented");
                }
                if (n3 == null || (n = n3.intValue()) % 8 != 0 || (this.b = n >> 3) > 8) throw new NoSuchAlgorithmException("Invalid algorithm mode: " + string);
                sunJCE_i = new SunJCE_i(this.b);
            } else {
                sunJCE_i = new SunJCE_i();
            }
            sunJCE_i.a(this.n);
            this.f = sunJCE_i;
            return;
        }
        if (!string2.equals("PCBC")) throw new NoSuchAlgorithmException("Cipher mode: " + string + " not found");
        this.g = 4;
        SunJCE_j sunJCE_j = new SunJCE_j();
        sunJCE_j.a(this.n);
        this.f = sunJCE_j;
    }

    protected void engineSetPadding(String string) throws NoSuchPaddingException {
        if (string == null) {
            throw new NoSuchPaddingException("null padding");
        }
        if (string.equalsIgnoreCase("PKCS5Padding")) {
            return;
        }
        if (!string.equalsIgnoreCase("NoPadding")) {
            throw new NoSuchPaddingException("Paddding: " + string + " not implemented");
        }
        this.e = null;
    }

    protected int engineGetBlockSize() {
        return 8;
    }

    protected int engineGetOutputSize(int n) {
        int n2 = this.c + n;
        if (this.e == null) {
            return n2;
        }
        if (this.h) {
            return n2;
        }
        if (this.b != 8) {
            if (n2 < this.d) {
                return this.d;
            }
            return n2 + 8 - (n2 - this.d) % 8;
        }
        return n2 + this.e.a(n2);
    }

    protected byte[] engineGetIV() {
        if (this.g == 0) {
            return null;
        }
        return ((SunJCE_f)((Object)this.f)).c();
    }

    protected AlgorithmParameters engineGetParameters() {
        AlgorithmParameters algorithmParameters = null;
        if (this.g == 0) {
            return null;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(this.engineGetIV());
        try {
            algorithmParameters = AlgorithmParameters.getInstance("Blowfish", "SunJCE");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("SunJCE called, but not configured");
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new RuntimeException("SunJCE called, but not configured");
        }
        try {
            algorithmParameters.init(ivParameterSpec);
        }
        catch (InvalidParameterSpecException invalidParameterSpecException) {
            throw new RuntimeException("IvParameterSpec not supported");
        }
        return algorithmParameters;
    }

    protected void engineInit(int n, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (n == 2 || n == 4) {
            if (this.g != 0) {
                throw new InvalidKeyException("Parameters missing");
            }
            this.h = true;
        } else {
            this.h = false;
        }
        if (key == null) {
            throw new InvalidKeyException("No key given");
        }
        this.c = 0;
        this.d = 8;
        if (this.g == 0 || secureRandom == null) {
            this.f.a(key);
            return;
        }
        byte[] byArray = new byte[8];
        secureRandom.nextBytes(byArray);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray);
        try {
            this.f.a(key, ivParameterSpec);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            // empty catch block
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void engineInit(int n, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (n == 2 || n == 4) {
            if (this.g != 0 && algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            this.h = true;
        } else {
            this.h = false;
        }
        if (key == null) {
            throw new InvalidKeyException("No key given");
        }
        this.c = 0;
        this.d = 8;
        if (this.g == 0) {
            this.f.a(key);
            return;
        }
        if (algorithmParameterSpec != null) {
            if (!(algorithmParameterSpec instanceof IvParameterSpec)) throw new InvalidAlgorithmParameterException("Wrong parameter type: IV expected");
            this.f.a(key, (IvParameterSpec)algorithmParameterSpec);
            return;
        } else if (secureRandom == null) {
            this.f.a(key);
            return;
        } else {
            byte[] byArray = new byte[8];
            secureRandom.nextBytes(byArray);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray);
            this.f.a(key, ivParameterSpec);
        }
    }

    protected void engineInit(int n, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        IvParameterSpec ivParameterSpec = null;
        if (algorithmParameters != null) {
            try {
                ivParameterSpec = (IvParameterSpec)algorithmParameters.getParameterSpec(o == null ? (o = BlowfishCipher.class$("javax.crypto.spec.IvParameterSpec")) : o);
            }
            catch (InvalidParameterSpecException invalidParameterSpecException) {
                throw new InvalidAlgorithmParameterException("Wrong parameter type: IV expected");
            }
        }
        this.engineInit(n, key, ivParameterSpec, secureRandom);
    }

    protected byte[] engineUpdate(byte[] byArray, int n, int n2) {
        byte[] byArray2 = null;
        byte[] byArray3 = null;
        try {
            byArray2 = new byte[this.engineGetOutputSize(n2)];
            int n3 = this.engineUpdate(byArray, n, n2, byArray2, 0);
            if (n3 < byArray2.length) {
                byArray3 = new byte[n3];
                System.arraycopy(byArray2, 0, byArray3, 0, n3);
            } else {
                byArray3 = byArray2;
            }
        }
        catch (ShortBufferException shortBufferException) {
            // empty catch block
        }
        return byArray3;
    }

    protected int engineUpdate(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws ShortBufferException {
        int n4 = this.c + n2;
        if (this.e != null && this.h) {
            n4 -= 8;
        }
        n4 = n4 < 0 ? 0 : n4;
        n4 -= n4 % this.b;
        if (byArray2 == null || byArray2.length - n3 < n4) {
            throw new ShortBufferException("Output buffer must be (at least) " + n4 + " bytes long");
        }
        if (n4 > 0) {
            byte[] byArray3 = new byte[n4];
            int n5 = n4 - this.c;
            int n6 = this.c;
            if (n5 < 0) {
                n5 = 0;
                n6 = n4;
            }
            if (this.c != 0) {
                System.arraycopy(this.a, 0, byArray3, 0, n6);
            }
            if (n5 > 0) {
                System.arraycopy(byArray, n, byArray3, n6, n5);
            }
            try {
                if (this.h) {
                    this.f.b(byArray3, 0, n4, byArray2, n3);
                } else {
                    this.f.a(byArray3, 0, n4, byArray2, n3);
                }
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                // empty catch block
            }
            if (this.b != 8) {
                this.d = n4 < this.d ? (this.d -= n4) : 8 - (n4 - this.d) % 8;
            }
            n2 -= n5;
            n += n5;
            n3 += n4;
            this.c -= n6;
            if (this.c > 0) {
                System.arraycopy(this.a, n6, this.a, 0, this.c);
            }
        }
        if (n2 > 0) {
            System.arraycopy(byArray, n, this.a, this.c, n2);
        }
        this.c += n2;
        return n4 < 0 ? 0 : n4;
    }

    protected byte[] engineDoFinal(byte[] byArray, int n, int n2) throws IllegalBlockSizeException, BadPaddingException {
        byte[] byArray2 = null;
        byte[] byArray3 = null;
        try {
            byArray2 = new byte[this.engineGetOutputSize(n2)];
            int n3 = this.engineDoFinal(byArray, n, n2, byArray2, 0);
            if (n3 < byArray2.length) {
                byArray3 = new byte[n3];
                if (n3 != 0) {
                    System.arraycopy(byArray2, 0, byArray3, 0, n3);
                }
            } else {
                byArray3 = byArray2;
            }
        }
        catch (ShortBufferException shortBufferException) {
            // empty catch block
        }
        return byArray3;
    }

    protected int engineDoFinal(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        int n4;
        int n5;
        int n6 = n5 = this.c + n2;
        int n7 = 0;
        if (this.b != 8) {
            this.d = n5 < this.d ? (this.d -= n5) : 8 - (n5 - this.d) % 8;
            n7 = this.d;
        } else if (this.e != null) {
            n7 = this.e.a(n5);
        }
        if (this.d > 0 && this.d != 8 && this.e != null && this.h) {
            throw new IllegalBlockSizeException("Input length must be multiple of 8 when decrypting with padded cipher");
        }
        if (!this.h && this.e != null) {
            n6 += n7;
        }
        if (byArray2 == null || byArray2.length - n3 < n6 && (!this.h || this.e == null)) {
            throw new ShortBufferException("Output buffer too short: " + (byArray2.length - n3) + " bytes given, " + n6 + " bytes needed");
        }
        byte[] byArray3 = null;
        byte[] byArray4 = null;
        if (this.e == null || this.h) {
            byte[] byArray5 = byArray2;
            n4 = n3;
            if (this.e != null) {
                byArray3 = new byte[n5];
                byArray5 = byArray3;
                n4 = 0;
            }
            if (this.c == 0) {
                n5 = this.a(byArray, n, byArray5, n4, n2);
            } else {
                byArray4 = new byte[n5];
                System.arraycopy(this.a, 0, byArray4, 0, this.c);
                if (n2 != 0) {
                    System.arraycopy(byArray, n, byArray4, this.c, n2);
                }
                n5 = this.a(byArray4, 0, byArray5, n4, n5);
            }
        } else {
            byArray4 = new byte[n6];
            if (this.c != 0) {
                System.arraycopy(this.a, 0, byArray4, 0, this.c);
            }
            if (n2 != 0) {
                System.arraycopy(byArray, n, byArray4, this.c, n2);
            }
            this.e.b(byArray4, n5, n7);
            n5 = this.a(byArray4, 0, byArray2, n3, n6);
        }
        if (this.h && this.e != null) {
            int n8 = this.e.c(byArray3, 0, n5);
            if (n8 < 0) {
                throw new BadPaddingException("Given final block not properly padded");
            }
            n5 = n8;
            if (byArray2.length - n3 < n5) {
                throw new ShortBufferException("Output buffer too short: " + (byArray2.length - n3) + " bytes given, " + n5 + " bytes needed");
            }
            n4 = 0;
            while (n4 < n5) {
                byArray2[n3 + n4] = byArray3[n4];
                ++n4;
            }
        }
        this.c = 0;
        this.d = 8;
        if (this.g != 0) {
            SunJCE_f sunJCE_f = (SunJCE_f)((Object)this.f);
            sunJCE_f.d();
        }
        return n5;
    }

    private int a(byte[] byArray, int n, byte[] byArray2, int n2, int n3) throws IllegalBlockSizeException {
        if (byArray == null || n3 == 0) {
            return 0;
        }
        if (this.g != 2 && this.g != 3 && n3 % this.b != 0) {
            if (this.e != null) {
                throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.b + " bytes");
            }
            throw new IllegalBlockSizeException("Input length not multiple of " + this.b + " bytes");
        }
        if (this.h) {
            this.f.b(byArray, n, n3, byArray2, n2);
        } else {
            this.f.a(byArray, n, n3, byArray2, n2);
        }
        return n3;
    }

    protected int engineGetKeySize(Key key) throws InvalidKeyException {
        return key.getEncoded().length * 8;
    }

    protected byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] byArray = null;
        try {
            byte[] byArray2 = key.getEncoded();
            if (byArray2 == null || byArray2.length == 0) {
                throw new InvalidKeyException("Cannot get an encoding of the key to be wrapped");
            }
            byArray = this.engineDoFinal(byArray2, 0, byArray2.length);
        }
        catch (BadPaddingException badPaddingException) {
            // empty catch block
        }
        return byArray;
    }

    protected Key engineUnwrap(byte[] byArray, String string, int n) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] byArray2;
        Key key = null;
        try {
            byArray2 = this.engineDoFinal(byArray, 0, byArray.length);
        }
        catch (BadPaddingException badPaddingException) {
            throw new InvalidKeyException();
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            throw new InvalidKeyException();
        }
        switch (n) {
            case 3: {
                key = SunJCE_k.c(byArray2, string);
                break;
            }
            case 2: {
                key = SunJCE_k.b(byArray2, string);
                break;
            }
            case 1: {
                key = SunJCE_k.a(byArray2, string);
            }
        }
        return key;
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

