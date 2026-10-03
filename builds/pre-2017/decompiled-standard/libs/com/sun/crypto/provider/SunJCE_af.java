/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.PBEKey;
import com.sun.crypto.provider.PBEParameters;
import com.sun.crypto.provider.PBEWithMD5AndTripleDESCipher;
import com.sun.crypto.provider.SealedObjectForKeyProtector;
import com.sun.crypto.provider.SunJCE_ag;
import com.sun.crypto.provider.SunJCE_ah;
import com.sun.crypto.provider.SunJCE_ai;
import com.sun.crypto.provider.SunJCE_aj;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

final class SunJCE_af {
    private static final String a = "1.3.6.1.4.1.42.2.19.1";
    private static final String b = "1.3.6.1.4.1.42.2.17.1.1";
    private static final int c = 20;
    private static final int d = 20;
    private char[] e;
    private byte[] f;
    private static Provider g = Security.getProvider("SunJCE");

    SunJCE_af(char[] cArray) {
        if (cArray == null) {
            throw new IllegalArgumentException("password can't be null");
        }
        this.e = cArray;
    }

    protected void finalize() {
        if (this.f != null) {
            Arrays.fill(this.f, (byte)0);
            this.f = null;
        }
    }

    byte[] a(PrivateKey privateKey) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[8];
        secureRandom.nextBytes(byArray);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(byArray, 20);
        PBEKeySpec pBEKeySpec = new PBEKeySpec(this.e);
        PBEKey pBEKey = new PBEKey(pBEKeySpec);
        Arrays.fill(pBEKeySpec.getPassword(), ' ');
        PBEWithMD5AndTripleDESCipher pBEWithMD5AndTripleDESCipher = new PBEWithMD5AndTripleDESCipher();
        pBEWithMD5AndTripleDESCipher.engineInit(1, (Key)pBEKey, pBEParameterSpec, null);
        byte[] byArray2 = privateKey.getEncoded();
        byte[] byArray3 = pBEWithMD5AndTripleDESCipher.engineDoFinal(byArray2, 0, byArray2.length);
        PBEParameters pBEParameters = new PBEParameters();
        pBEParameters.engineInit(pBEParameterSpec);
        SunJCE_ah sunJCE_ah = new SunJCE_ah(a, pBEParameters.engineGetEncoded());
        return new SunJCE_ag(sunJCE_ah, byArray3).c();
    }

    Key a(SunJCE_ag sunJCE_ag) throws UnrecoverableKeyException, NoSuchAlgorithmException {
        try {
            Object object;
            Object object2;
            byte[] byArray;
            String string = sunJCE_ag.a().a().toString();
            if (!string.equals(a) && !string.equals(b)) {
                throw new UnrecoverableKeyException("Unsupported encryption algorithm");
            }
            if (string.equals(b)) {
                byArray = this.a(sunJCE_ag.b());
            } else {
                object2 = new PBEParameters();
                ((PBEParameters)object2).engineInit(sunJCE_ag.a().b());
                object = Class.forName("javax.crypto.spec.PBEParameterSpec");
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec)((PBEParameters)object2).engineGetParameterSpec((Class)object);
                PBEKeySpec pBEKeySpec = new PBEKeySpec(this.e);
                PBEKey pBEKey = new PBEKey(pBEKeySpec);
                Arrays.fill(pBEKeySpec.getPassword(), ' ');
                PBEWithMD5AndTripleDESCipher pBEWithMD5AndTripleDESCipher = new PBEWithMD5AndTripleDESCipher();
                pBEWithMD5AndTripleDESCipher.engineInit(2, (Key)pBEKey, pBEParameterSpec, null);
                byArray = pBEWithMD5AndTripleDESCipher.engineDoFinal(sunJCE_ag.b(), 0, sunJCE_ag.b().length);
            }
            object2 = SunJCE_ah.a(new SunJCE_ai(byArray).a().a());
            object = KeyFactory.getInstance((String)object2);
            return ((KeyFactory)object).generatePrivate(new PKCS8EncodedKeySpec(byArray));
        }
        catch (IOException iOException) {
            throw new UnrecoverableKeyException(iOException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new UnrecoverableKeyException(classNotFoundException.getMessage());
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            throw new UnrecoverableKeyException(noSuchPaddingException.getMessage());
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            throw new UnrecoverableKeyException(illegalBlockSizeException.getMessage());
        }
        catch (InvalidParameterException invalidParameterException) {
            throw new UnrecoverableKeyException(invalidParameterException.getMessage());
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            throw new UnrecoverableKeyException(invalidAlgorithmParameterException.getMessage());
        }
        catch (InvalidParameterSpecException invalidParameterSpecException) {
            throw new UnrecoverableKeyException(invalidParameterSpecException.getMessage());
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new UnrecoverableKeyException(invalidKeyException.getMessage());
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new UnrecoverableKeyException(invalidKeySpecException.getMessage());
        }
        catch (BadPaddingException badPaddingException) {
            throw new UnrecoverableKeyException(badPaddingException.getMessage());
        }
    }

    byte[] a(byte[] byArray) throws UnrecoverableKeyException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
        byte[] byArray2 = new byte[20];
        System.arraycopy(byArray, 0, byArray2, 0, 20);
        int n = byArray.length - 20 - 20;
        int n2 = n / 20;
        if (n % 20 != 0) {
            ++n2;
        }
        byte[] byArray3 = new byte[n];
        System.arraycopy(byArray, 20, byArray3, 0, n);
        byte[] byArray4 = new byte[byArray3.length];
        this.f = new byte[this.e.length * 2];
        int n3 = 0;
        int n4 = 0;
        while (n3 < this.e.length) {
            this.f[n4++] = (byte)(this.e[n3] >> 8);
            this.f[n4++] = (byte)this.e[n3];
            ++n3;
        }
        n3 = 0;
        int n5 = 0;
        byte[] byArray5 = byArray2;
        while (n3 < n2) {
            messageDigest.update(this.f);
            messageDigest.update(byArray5);
            byArray5 = messageDigest.digest();
            messageDigest.reset();
            if (n3 < n2 - 1) {
                System.arraycopy(byArray5, 0, byArray4, n5, byArray5.length);
            } else {
                System.arraycopy(byArray5, 0, byArray4, n5, byArray4.length - n5);
            }
            ++n3;
            n5 += 20;
        }
        byte[] byArray6 = new byte[byArray3.length];
        n3 = 0;
        while (n3 < byArray6.length) {
            byArray6[n3] = (byte)(byArray3[n3] ^ byArray4[n3]);
            ++n3;
        }
        messageDigest.update(this.f);
        Arrays.fill(this.f, (byte)0);
        this.f = null;
        messageDigest.update(byArray6);
        byArray5 = messageDigest.digest();
        messageDigest.reset();
        n3 = 0;
        while (n3 < byArray5.length) {
            if (byArray5[n3] != byArray[20 + n + n3]) {
                throw new UnrecoverableKeyException("Cannot recover key");
            }
            ++n3;
        }
        return byArray6;
    }

    SealedObject a(Key key) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[8];
        secureRandom.nextBytes(byArray);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(byArray, 20);
        PBEKeySpec pBEKeySpec = new PBEKeySpec(this.e);
        PBEKey pBEKey = new PBEKey(pBEKeySpec);
        Arrays.fill(pBEKeySpec.getPassword(), ' ');
        PBEWithMD5AndTripleDESCipher pBEWithMD5AndTripleDESCipher = new PBEWithMD5AndTripleDESCipher();
        SunJCE_aj sunJCE_aj = new SunJCE_aj(pBEWithMD5AndTripleDESCipher, g, "PBEWithMD5AndTripleDES");
        sunJCE_aj.init(1, (Key)pBEKey, pBEParameterSpec);
        return new SealedObjectForKeyProtector(key, sunJCE_aj);
    }

    Key a(SealedObject sealedObject) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(this.e);
            PBEKey pBEKey = new PBEKey(pBEKeySpec);
            Arrays.fill(pBEKeySpec.getPassword(), ' ');
            SealedObjectForKeyProtector sealedObjectForKeyProtector = null;
            sealedObjectForKeyProtector = !(sealedObject instanceof SealedObjectForKeyProtector) ? new SealedObjectForKeyProtector(sealedObject) : (SealedObjectForKeyProtector)sealedObject;
            AlgorithmParameters algorithmParameters = sealedObjectForKeyProtector.a();
            if (algorithmParameters == null) {
                throw new UnrecoverableKeyException("Cannot get algorithm parameters");
            }
            PBEWithMD5AndTripleDESCipher pBEWithMD5AndTripleDESCipher = new PBEWithMD5AndTripleDESCipher();
            SunJCE_aj sunJCE_aj = new SunJCE_aj(pBEWithMD5AndTripleDESCipher, g, "PBEWithMD5AndTripleDES");
            sunJCE_aj.init(2, (Key)pBEKey, algorithmParameters);
            return (Key)sealedObjectForKeyProtector.getObject(sunJCE_aj);
        }
        catch (IOException iOException) {
            throw new UnrecoverableKeyException(iOException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new UnrecoverableKeyException(classNotFoundException.getMessage());
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new UnrecoverableKeyException(invalidKeyException.getMessage());
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new UnrecoverableKeyException(invalidKeySpecException.getMessage());
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            throw new UnrecoverableKeyException(noSuchPaddingException.getMessage());
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            throw new UnrecoverableKeyException(illegalBlockSizeException.getMessage());
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            throw new UnrecoverableKeyException(invalidAlgorithmParameterException.getMessage());
        }
        catch (BadPaddingException badPaddingException) {
            throw new UnrecoverableKeyException(badPaddingException.getMessage());
        }
    }
}

