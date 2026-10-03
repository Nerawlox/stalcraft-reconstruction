/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import cpw.mods.fml.common.asm.ReobfuscationMarker;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.io.CipherInputStream;
import org.bouncycastle.crypto.io.CipherOutputStream;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

@ReobfuscationMarker
public class qlgf {
    @SideOnly(value=Side.CLIENT)
    public static SecretKey _a() {
        CipherKeyGenerator cipherKeyGenerator = new CipherKeyGenerator();
        cipherKeyGenerator.init(new KeyGenerationParameters(new SecureRandom(), 128));
        return new SecretKeySpec(cipherKeyGenerator.generateKey(), "AES");
    }

    public static KeyPair _b() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            return keyPairGenerator.generateKeyPair();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            System.err.println("Key pair generation failed!");
            return null;
        }
    }

    public static byte[] _a(String string, PublicKey publicKey, SecretKey secretKey) {
        try {
            return qlgf._a("SHA-1", string.getBytes("ISO_8859_1"), secretKey.getEncoded(), publicKey.getEncoded());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return null;
        }
    }

    public static byte[] _a(String string, byte[] ... byArray) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(string);
            byte[][] byArray2 = byArray;
            int n = byArray.length;
            for (int i = 0; i < n; ++i) {
                byte[] byArray3 = byArray2[i];
                messageDigest.update(byArray3);
            }
            return messageDigest.digest();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            return null;
        }
    }

    public static PublicKey _a(byte[] byArray) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byArray);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(x509EncodedKeySpec);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            invalidKeySpecException.printStackTrace();
        }
        System.err.println("Public key reconstitute failed!");
        return null;
    }

    public static SecretKey _a(PrivateKey privateKey, byte[] byArray) {
        return new SecretKeySpec(qlgf._b(privateKey, byArray), "AES");
    }

    @SideOnly(value=Side.CLIENT)
    public static byte[] _a(Key key, byte[] byArray) {
        return qlgf._a(1, key, byArray);
    }

    public static byte[] _b(Key key, byte[] byArray) {
        return qlgf._a(2, key, byArray);
    }

    public static byte[] _a(int n, Key key, byte[] byArray) {
        try {
            return qlgf._a(n, key.getAlgorithm(), key).doFinal(byArray);
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            illegalBlockSizeException.printStackTrace();
        }
        catch (BadPaddingException badPaddingException) {
            badPaddingException.printStackTrace();
        }
        System.err.println("Cipher data failed!");
        return null;
    }

    public static Cipher _a(int n, String string, Key key) {
        try {
            Cipher cipher = Cipher.getInstance(string);
            cipher.init(n, key);
            return cipher;
        }
        catch (InvalidKeyException invalidKeyException) {
            invalidKeyException.printStackTrace();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            noSuchPaddingException.printStackTrace();
        }
        System.err.println("Cipher creation failed!");
        return null;
    }

    public static BufferedBlockCipher _a(boolean bl, Key key) {
        BufferedBlockCipher bufferedBlockCipher = new BufferedBlockCipher(new CFBBlockCipher(new AESFastEngine(), 8));
        bufferedBlockCipher.init(bl, new ParametersWithIV(new KeyParameter(key.getEncoded()), key.getEncoded(), 0, 16));
        return bufferedBlockCipher;
    }

    public static OutputStream _a(SecretKey secretKey, OutputStream outputStream) {
        return new CipherOutputStream(outputStream, qlgf._a(true, secretKey));
    }

    public static InputStream _a(SecretKey secretKey, InputStream inputStream) {
        return new CipherInputStream(inputStream, qlgf._a(false, secretKey));
    }

    static {
        Security.addProvider(new BouncyCastleProvider());
    }
}

