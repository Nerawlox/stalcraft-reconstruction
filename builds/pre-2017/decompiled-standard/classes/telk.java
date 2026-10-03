/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.PathModifier;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.minecraft.util.ResourceLocation;

public class telk {
    private static IvParameterSpec _a = telk._a();
    private static SecretKeySpec _b = new SecretKeySpec(new byte[]{11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 12, 13, 14, 15}, "AES");
    private static Cipher _c = telk._b();

    private static IvParameterSpec _a() {
        try {
            return new IvParameterSpec("0123456789ABCDFE".getBytes("UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return null;
        }
    }

    private static Cipher _b() {
        try {
            return Cipher.getInstance("AES/CBC/PKCS5PADDING");
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException generalSecurityException) {
            generalSecurityException.printStackTrace();
            return null;
        }
    }

    public static byte[] _a(String string) {
        try {
            _c.init(1, (Key)_b, _a);
            return _c.doFinal(string.getBytes("UTF-8"));
        }
        catch (Exception exception) {
            exception.printStackTrace();
            throw new IllegalStateException("Ciphering gone wrong!");
        }
    }

    public static byte[] _a(byte[] byArray) {
        try {
            _c.init(1, (Key)_b, _a);
            return _c.doFinal(byArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            throw new IllegalStateException("Ciphering gone wrong!");
        }
    }

    public static byte[] _b(byte[] byArray) {
        if (PathModifier._b) {
            try {
                _c.init(2, (Key)_b, _a);
                return _c.doFinal(byArray);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }
        return byArray;
    }

    public static String _c(byte[] byArray) {
        if (PathModifier._b) {
            try {
                return new String(telk._b(byArray), "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
        } else {
            try {
                return new String(byArray, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] _a(ResourceLocation resourceLocation) {
        return telk._b(uyvo._g(resourceLocation));
    }

    public static String _b(ResourceLocation resourceLocation) {
        return telk._c(uyvo._g(resourceLocation));
    }
}

