/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.bundle.BundleMod;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.minecraft.client.Minecraft;
import org.apache.commons.lang3.StringUtils;
import ru.hoshimin.Protection;

public class eivd {
    public static boolean _a;
    private static final char[] _b;

    private static String _a(byte[] byArray) {
        char[] cArray = new char[byArray.length * 2];
        for (int i = 0; i < byArray.length; ++i) {
            int n = byArray[i] & 0xFF;
            cArray[i * 2] = _b[n >>> 4];
            cArray[i * 2 + 1] = _b[n & 0xF];
        }
        return new String(cArray);
    }

    public static void _a() {
        String string = eivd._b();
        try (InputStream inputStream = eivd.class.getClassLoader().getResourceAsStream(eivd.class.getName().replace('.', '/') + ".class");){
            if (inputStream.read() == 202 && inputStream.read() == 254 && inputStream.read() == 186 && inputStream.read() == 190) {
                _a = true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        new Thread(() -> {
            try {
                String string2;
                SecretKeySpec secretKeySpec = new SecretKeySpec(new byte[]{21, 75, 24, 85, 25, 88, 51, 9, 52, 17, 81, 34, 71, 54, 11, 40}, "AES");
                IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(1, (Key)secretKeySpec, ivParameterSpec);
                byte[] byArray = new byte[16];
                byArray[0] = (byte)(_a ? 1 : 0);
                for (int i = 1; i < byArray.length; ++i) {
                    int n = string.length() - 16 + i;
                    byArray[i] = n >= 0 ? (int)string.charAt(n) : 32;
                }
                byte[] byArray2 = cipher.doFinal(byArray);
                String string3 = eivd._a(byArray2);
                String string4 = Minecraft._E()._P()._a();
                String string5 = BundleMod._c;
                String string6 = StringUtils.split(string5, ':')[0];
                int n = Integer.parseInt(StringUtils.split(string5, ':')[1]) + 8000;
                String string7 = "http://" + string6 + ":" + n + "/check_version?username=" + string4 + "&version_hash=" + string3;
                URL uRL = new URL(string7);
                HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
                httpURLConnection.setRequestMethod("GET");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                while ((string2 = bufferedReader.readLine()) != null) {
                    stringBuilder.append(string2);
                }
                bufferedReader.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }).start();
    }

    public static String _b() {
        try {
            String string = Protection.getLastModifiedClass();
            if (string != null) {
                return string;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return "";
    }

    static {
        _b = "0123456789abcdef".toCharArray();
    }
}

