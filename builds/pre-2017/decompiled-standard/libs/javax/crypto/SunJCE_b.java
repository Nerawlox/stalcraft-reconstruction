/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.crypto.ExemptionMechanism;
import javax.crypto.SunJCE_c;
import javax.crypto.SunJCE_d;
import javax.crypto.SunJCE_f;
import javax.crypto.SunJCE_g;
import javax.crypto.SunJCE_h;
import javax.crypto.SunJCE_n;
import javax.crypto.SunJCE_o;
import javax.crypto.SunJCE_w;
import javax.crypto.SunJCE_x;

final class SunJCE_b {
    static final boolean a = false;
    private static final SunJCE_n b = new SunJCE_n();
    private static SunJCE_h c = null;
    private static SunJCE_h d = null;
    private static Vector e = new Vector(2);
    private static Vector f = new Vector(2);
    static X509Certificate[] g = null;
    private static final byte[][] h = new byte[][]{{48, -126, 3, -64, 48, -126, 3, 126, -96, 3, 2, 1, 2, 2, 1, 1, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 48, -127, -112, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 11, 48, 9, 6, 3, 85, 4, 8, 19, 2, 67, 65, 49, 18, 48, 16, 6, 3, 85, 4, 7, 19, 9, 80, 97, 108, 111, 32, 65, 108, 116, 111, 49, 29, 48, 27, 6, 3, 85, 4, 10, 19, 20, 83, 117, 110, 32, 77, 105, 99, 114, 111, 115, 121, 115, 116, 101, 109, 115, 32, 73, 110, 99, 49, 35, 48, 33, 6, 3, 85, 4, 11, 19, 26, 74, 97, 118, 97, 32, 83, 111, 102, 116, 119, 97, 114, 101, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, 30, 23, 13, 48, 48, 48, 52, 49, 50, 48, 55, 48, 48, 48, 48, 90, 23, 13, 48, 54, 48, 52, 49, 50, 48, 55, 48, 48, 48, 48, 90, 48, -127, -112, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 11, 48, 9, 6, 3, 85, 4, 8, 19, 2, 67, 65, 49, 18, 48, 16, 6, 3, 85, 4, 7, 19, 9, 80, 97, 108, 111, 32, 65, 108, 116, 111, 49, 29, 48, 27, 6, 3, 85, 4, 10, 19, 20, 83, 117, 110, 32, 77, 105, 99, 114, 111, 115, 121, 115, 116, 101, 109, 115, 32, 73, 110, 99, 49, 35, 48, 33, 6, 3, 85, 4, 11, 19, 26, 74, 97, 118, 97, 32, 83, 111, 102, 116, 119, 97, 114, 101, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, -126, 1, -73, 48, -126, 1, 44, 6, 7, 42, -122, 72, -50, 56, 4, 1, 48, -126, 1, 31, 2, -127, -127, 0, -21, -81, 55, 4, 30, -54, 81, 30, 105, 93, -80, -14, -113, -10, -75, 73, 31, -58, -92, -103, 5, -41, 41, -65, 116, -73, 106, -11, 25, -40, 30, -28, 27, -8, 10, 1, -102, -104, -1, 112, -85, -30, 74, 86, -122, 108, 83, -77, -4, -31, -56, -127, -116, 49, -16, -60, -13, -80, -117, -26, 112, 6, -20, -9, 105, 104, -37, -125, 76, 114, 41, -119, 41, 54, 23, 92, 59, 74, 7, -96, 32, 2, 42, 70, -105, 81, 29, 112, -56, 8, 24, 11, -50, 12, 110, -101, 118, -9, 5, -29, -25, -5, -45, 97, 121, -31, 96, -102, 36, -115, 6, -107, -125, 60, 81, 32, -31, 48, -49, 56, 87, -126, -90, 26, 114, 13, -50, -45, 2, 21, 0, -124, 37, 69, -31, -70, -71, -87, 98, -85, 121, -24, 91, 48, -72, -119, 107, 27, -1, 123, 117, 2, -127, -127, 0, -85, -55, 116, 123, 116, -17, -18, 66, -75, 106, 83, 77, 59, -35, -112, 6, 114, 104, -111, 15, 11, -92, 41, 118, 46, 85, 59, -43, -82, 77, 101, 92, 126, 42, 58, 4, -90, 103, -90, -48, 113, -86, -91, -41, -73, -30, -63, 114, 13, -92, -47, -86, 30, -110, 84, 76, 32, 0, 9, -94, -80, 9, 65, 25, 51, 0, -78, -61, 92, -82, 66, -8, -79, -117, -54, 124, -106, -40, 16, 127, 55, 68, 91, -86, -52, 120, -56, -41, 114, 118, 55, 107, 64, -103, -88, 85, 102, -6, -88, 3, 30, -117, 74, 17, 2, 105, -53, 76, -72, 37, 6, 28, -96, 119, -46, -55, -84, -46, 61, -23, 10, 16, -6, 118, 112, -73, -5, -36, 3, -127, -124, 0, 2, -127, -128, 45, 9, -104, 92, -84, -72, -100, -57, -103, 126, -18, 32, 25, 42, 52, -112, -7, -41, -85, -85, -82, -35, 107, 114, -107, 13, 102, -8, -17, 39, -113, 68, -78, -19, 40, 68, -57, -2, -81, -80, -90, 39, 111, 0, 103, 69, -126, 91, 7, -88, 86, 86, 59, -46, 41, 81, 97, 94, 105, 57, -41, 46, 116, 119, 18, -49, 25, 74, -11, 45, -56, -53, 114, 97, -60, 78, 111, -6, 71, 67, 63, 20, -69, -6, -68, 24, 102, 40, -62, -39, 102, -117, 122, 45, 47, -62, 96, -110, 75, 20, -2, 88, 62, 33, 127, 104, 98, -66, 108, 72, 73, -7, -96, 75, 94, -123, -99, 25, 16, -7, 21, 69, 81, 27, 113, -44, -9, 11, -93, 102, 48, 100, 48, 17, 6, 9, 96, -122, 72, 1, -122, -8, 66, 1, 1, 4, 4, 3, 2, 0, 7, 48, 15, 6, 3, 85, 29, 19, 1, 1, -1, 4, 5, 48, 3, 1, 1, -1, 48, 31, 6, 3, 85, 29, 35, 4, 24, 48, 22, -128, 20, 101, -30, -12, -122, -55, -45, 78, -16, -111, 78, 88, -94, 106, -11, -40, 120, 90, -102, -63, -90, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 101, -30, -12, -122, -55, -45, 78, -16, -111, 78, 88, -94, 106, -11, -40, 120, 90, -102, -63, -90, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 3, 47, 0, 48, 44, 2, 20, 36, -97, 2, -61, -5, 49, -43, -111, 59, -7, 126, 86, 111, -106, -33, 100, 10, 4, -104, -76, 2, 20, 110, 121, -124, -89, -18, 104, -93, 2, 114, 49, 99, -37, 67, -85, 8, -20, 77, -17, 22, 58}, {48, -126, 3, 79, 48, -126, 3, 13, -96, 3, 2, 1, 2, 2, 4, 57, 36, -91, 85, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 48, 96, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 24, 48, 22, 6, 3, 85, 4, 10, 19, 15, 73, 66, 77, 32, 67, 111, 114, 112, 111, 114, 97, 116, 105, 111, 110, 49, 25, 48, 23, 6, 3, 85, 4, 11, 19, 16, 73, 66, 77, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, 30, 23, 13, 48, 48, 48, 53, 49, 57, 48, 50, 50, 50, 49, 51, 90, 23, 13, 48, 54, 48, 53, 49, 56, 48, 50, 50, 50, 49, 51, 90, 48, 96, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 24, 48, 22, 6, 3, 85, 4, 10, 19, 15, 73, 66, 77, 32, 67, 111, 114, 112, 111, 114, 97, 116, 105, 111, 110, 49, 25, 48, 23, 6, 3, 85, 4, 11, 19, 16, 73, 66, 77, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, -126, 1, -72, 48, -126, 1, 44, 6, 7, 42, -122, 72, -50, 56, 4, 1, 48, -126, 1, 31, 2, -127, -127, 0, -3, 127, 83, -127, 29, 117, 18, 41, 82, -33, 74, -100, 46, -20, -28, -25, -10, 17, -73, 82, 60, -17, 68, 0, -61, 30, 63, -128, -74, 81, 38, 105, 69, 93, 64, 34, 81, -5, 89, 61, -115, 88, -6, -65, -59, -11, -70, 48, -10, -53, -101, 85, 108, -41, -127, 59, -128, 29, 52, 111, -14, 102, 96, -73, 107, -103, 80, -91, -92, -97, -97, -24, 4, 123, 16, 34, -62, 79, -69, -87, -41, -2, -73, -58, 27, -8, 59, 87, -25, -58, -88, -90, 21, 15, 4, -5, -125, -10, -45, -59, 30, -61, 2, 53, 84, 19, 90, 22, -111, 50, -10, 117, -13, -82, 43, 97, -41, 42, -17, -14, 34, 3, 25, -99, -47, 72, 1, -57, 2, 21, 0, -105, 96, 80, -113, 21, 35, 11, -52, -78, -110, -71, -126, -94, -21, -124, 11, -16, 88, 28, -11, 2, -127, -127, 0, -9, -31, -96, -123, -42, -101, 61, -34, -53, -68, -85, 92, 54, -72, 87, -71, 121, -108, -81, -69, -6, 58, -22, -126, -7, 87, 76, 11, 61, 7, -126, 103, 81, 89, 87, -114, -70, -44, 89, 79, -26, 113, 7, 16, -127, -128, -76, 73, 22, 113, 35, -24, 76, 40, 22, 19, -73, -49, 9, 50, -116, -56, -90, -31, 60, 22, 122, -117, 84, 124, -115, 40, -32, -93, -82, 30, 43, -77, -90, 117, -111, 110, -93, 127, 11, -6, 33, 53, 98, -15, -5, 98, 122, 1, 36, 59, -52, -92, -15, -66, -88, 81, -112, -119, -88, -125, -33, -31, 90, -27, -97, 6, -110, -117, 102, 94, -128, 123, 85, 37, 100, 1, 76, 59, -2, -49, 73, 42, 3, -127, -123, 0, 2, -127, -127, 0, -22, 107, 0, -57, -33, 16, 59, -71, 116, 53, -89, -31, 109, 102, -126, 77, -9, 91, 86, 113, -62, 38, 69, 39, 114, 61, 81, 16, 98, -1, -77, -36, 16, -55, -5, 81, 19, -44, -83, -117, -88, 37, 110, 93, -55, 120, -46, 91, 39, -45, 19, 65, 71, 20, 6, 124, -53, -126, 56, 94, -58, 11, 97, -96, 76, -125, 45, -108, -52, -116, 46, -124, -112, 58, -113, 66, 10, 105, 82, -45, 116, 38, 119, -92, 20, 125, 42, 113, 65, -120, -119, 119, -90, 45, 98, -102, -95, 88, -104, 109, 108, -49, -50, -88, -22, -70, -35, -24, -95, 16, 68, -116, -124, 66, -63, -72, 31, 43, -76, -68, -77, 93, 116, 96, -128, -115, 66, 84, -93, 83, 48, 81, 48, 31, 6, 3, 85, 29, 35, 4, 24, 48, 22, -128, 20, 126, 61, 77, 77, -52, 16, 89, -70, -7, -82, 66, 61, -27, -55, 87, 90, 82, 11, 126, -121, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 126, 61, 77, 77, -52, 16, 89, -70, -7, -82, 66, 61, -27, -55, 87, 90, 82, 11, 126, -121, 48, 15, 6, 3, 85, 29, 19, 1, 1, -1, 4, 5, 48, 3, 1, 1, -1, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 3, 47, 0, 48, 44, 2, 20, 28, -17, -10, -64, 92, -19, -109, 112, 34, -31, 75, -55, 15, -16, -99, 122, 9, -18, -122, -122, 2, 20, 18, 119, 71, 98, -62, -97, 25, 97, -36, 41, -6, -71, 73, -91, 25, -42, -91, -68, 69, 77}};
    private static X509Certificate[] i = null;
    private static final byte[][] j = new byte[][]{h[0], h[1]};
    static boolean k = true;
    static X509Certificate[] l;
    static /* synthetic */ Class m;

    private SunJCE_b() {
    }

    private static String a(String string, Provider provider) {
        String string2 = ((Properties)provider).getProperty(string);
        if (string2 != null) {
            return string2;
        }
        Enumeration enumeration = ((Hashtable)provider).keys();
        while (enumeration.hasMoreElements()) {
            String string3 = (String)enumeration.nextElement();
            if (!string.equalsIgnoreCase(string3)) continue;
            return ((Properties)provider).getProperty(string3);
        }
        return null;
    }

    private static String a(String string, String string2, Provider provider) {
        return SunJCE_b.a("Alg.Alias." + string2 + "." + string, provider);
    }

    private static Class b(String string, String string2, Provider provider) throws NoSuchAlgorithmException {
        Object object;
        Class<?> clazz = null;
        String string3 = string2 + "." + string;
        String string4 = SunJCE_b.a(string3, provider);
        if (string4 == null) {
            object = SunJCE_b.a(string, string2, provider);
            if (object != null) {
                string3 = string2 + "." + (String)object;
            }
            if (object == null || (string4 = SunJCE_b.a(string3, provider)) == null) {
                throw new NoSuchAlgorithmException("No such algorithm: " + string);
            }
        }
        try {
            object = provider.getClass().getClassLoader();
            clazz = object == null ? Class.forName(string4) : ((ClassLoader)object).loadClass(string4);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoSuchAlgorithmException("Class " + string4 + " configured for " + string2 + " not found: " + classNotFoundException.getMessage());
        }
        catch (SecurityException securityException) {
            throw new NoSuchAlgorithmException("Class " + string4 + " configured for " + string2 + " cannot be accessed: " + securityException.getMessage());
        }
        return clazz;
    }

    static Object[] a(String string, String string2, String string3) throws NoSuchAlgorithmException, NoSuchProviderException {
        Class clazz = null;
        Provider provider = null;
        if (string3 != null) {
            provider = Security.getProvider(string3);
            if (provider == null) {
                throw new NoSuchProviderException("No such provider: " + string3);
            }
            clazz = SunJCE_b.b(string, string2, provider);
            SunJCE_b.a(provider);
        } else {
            Provider[] providerArray = Security.getProviders();
            boolean bl = false;
            int n = 0;
            while (n < providerArray.length && !bl) {
                try {
                    clazz = SunJCE_b.b(string, string2, providerArray[n]);
                    SunJCE_b.a(providerArray[n]);
                    bl = true;
                    provider = providerArray[n];
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                }
                catch (NoSuchProviderException noSuchProviderException) {
                    // empty catch block
                }
                ++n;
            }
            if (!bl) {
                throw new NoSuchAlgorithmException("Algorithm " + string + " not available");
            }
        }
        return SunJCE_b.a(string, string2, provider, clazz);
    }

    private static Object[] a(String string, String string2, Provider provider, Class clazz) throws NoSuchAlgorithmException {
        Object object;
        Class<?> clazz2 = null;
        try {
            clazz2 = Class.forName("javax.crypto." + string2 + "Spi");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoSuchAlgorithmException(classNotFoundException.getMessage());
        }
        if (!SunJCE_b.a(clazz, clazz2)) {
            throw new NoSuchAlgorithmException("Class " + clazz.getName() + " configured for " + string2 + " is not a " + string2);
        }
        SunJCE_o sunJCE_o = b;
        ExemptionMechanism exemptionMechanism = null;
        if (SunJCE_b.c() && string2.equals("Cipher")) {
            SunJCE_g sunJCE_g;
            String string3;
            object = string;
            int n = string.indexOf(47);
            if (n != -1) {
                object = string.substring(0, n);
            }
            if ((string3 = (sunJCE_o = (sunJCE_g = (SunJCE_g)AccessController.doPrivileged(new SunJCE_f())).a(((String)object).toUpperCase())).b()) != null) {
                try {
                    exemptionMechanism = ExemptionMechanism.getInstance(string3);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        try {
            object = clazz.newInstance();
            return new Object[]{object, provider, sunJCE_o, exemptionMechanism, new Boolean(SunJCE_b.c())};
        }
        catch (InstantiationException instantiationException) {
            throw new NoSuchAlgorithmException("Class " + clazz.getName() + " configured for " + string2 + " cannot be instantiated: " + instantiationException.getMessage());
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new NoSuchAlgorithmException("Class " + clazz.getName() + " configured for " + string2 + " cannot be accessed: " + illegalAccessException.getMessage());
        }
    }

    private static boolean a(Class clazz, Class clazz2) {
        while (!clazz.equals(clazz2)) {
            if ((clazz = clazz.getSuperclass()) != null) continue;
            return false;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(Provider provider) throws NoSuchProviderException {
        if (!SunJCE_b.b(provider)) return;
        try {
            try {
                URL uRL = SunJCE_b.a(provider.getClass());
                SunJCE_d sunJCE_d = new SunJCE_d(uRL);
                sunJCE_d.verify(g);
                e.addElement(provider);
            }
            catch (Exception exception) {
                throw new NoSuchProviderException("JCE cannot authenticate the provider " + provider.getName() + ": " + exception);
            }
            Object var4_4 = null;
        }
        catch (Throwable throwable) {
            Object var4_5 = null;
            SunJCE_b.c(provider);
            throw throwable;
        }
        SunJCE_b.c(provider);
    }

    /*
     * Unable to fully structure code
     */
    private static boolean b(Provider var0) {
        if (SunJCE_b.e.contains(var0)) {
            return false;
        }
        var1_1 = SunJCE_b.f;
        synchronized (var1_1) {
            if (SunJCE_b.f.contains(var0)) ** GOTO lbl15
            SunJCE_b.f.addElement(var0);
            var2_2 = true;
            return var2_2;
lbl-1000:
            // 1 sources

            {
                try {
                    SunJCE_b.f.wait();
                    continue;
                }
                catch (InterruptedException var2_3) {
                    // empty catch block
                }
lbl15:
                // 3 sources

                ** while (SunJCE_b.f.contains((Object)var0))
            }
lbl16:
            // 1 sources

            if (SunJCE_b.e.contains(var0)) {
                var2_4 = false;
                return var2_4;
            }
            SunJCE_b.f.addElement(var0);
            var2_5 = true;
            return var2_5;
        }
    }

    private static void c(Provider provider) {
        Vector vector = f;
        synchronized (vector) {
            f.remove(provider);
            f.notifyAll();
        }
    }

    private static URL a(Class clazz) {
        return (URL)AccessController.doPrivileged(new SunJCE_c(clazz));
    }

    private static X509Certificate[] b(byte[][] byArray) throws IOException, CertificateException {
        int n = byArray.length;
        X509Certificate[] x509CertificateArray = new X509Certificate[n];
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        int n2 = 0;
        while (n2 < n) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray[n2]);
            x509CertificateArray[n2] = (X509Certificate)certificateFactory.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            ++n2;
        }
        return x509CertificateArray;
    }

    private static void i() throws Exception {
        X509Certificate[] x509CertificateArray;
        URL uRL = SunJCE_b.a(m == null ? (m = SunJCE_b.class$("javax.crypto.Cipher")) : m);
        URL uRL2 = new URL(uRL, "US_export_policy.jar");
        URL uRL3 = new URL(uRL, "local_policy.jar");
        File file = new File(uRL.getFile());
        File file2 = new File(uRL2.getFile());
        File file3 = new File(uRL3.getFile());
        if (!(file.exists() && file2.exists() && file3.exists())) {
            throw new SecurityException("Cannot locate policy and/or framework files for signer restraint check!");
        }
        SunJCE_w[] sunJCE_wArray = SunJCE_d.a(uRL, "javax/crypto/Cipher.class");
        String[] stringArray = new String[]{new String("default_"), new String("exempt_")};
        SunJCE_w[] sunJCE_wArray2 = SunJCE_d.a(uRL2, stringArray);
        SunJCE_w[] sunJCE_wArray3 = SunJCE_d.a(uRL3, stringArray);
        SunJCE_w[] sunJCE_wArray4 = new SunJCE_w[]{};
        if (sunJCE_wArray.length != 0 && sunJCE_wArray2.length != 0 && sunJCE_wArray3.length != 0) {
            sunJCE_wArray4 = SunJCE_d.a(sunJCE_wArray, sunJCE_wArray2);
            if ((sunJCE_wArray4 = SunJCE_d.a(sunJCE_wArray4, sunJCE_wArray3)).length == 0) {
                throw new SecurityException("Signer restraint check failed!");
            }
        } else {
            throw new SecurityException("Signer restraint check failed!");
        }
        boolean bl = false;
        int n = 0;
        while (n < sunJCE_wArray4.length) {
            x509CertificateArray = sunJCE_wArray4[n].toArray();
            if (SunJCE_d.a(x509CertificateArray, i)) {
                bl = true;
                break;
            }
            ++n;
        }
        if (!bl) {
            throw new SecurityException("Jurisdiction policy files are not signed by trusted signers!");
        }
        x509CertificateArray = new SunJCE_h();
        SunJCE_h sunJCE_h = new SunJCE_h();
        SunJCE_b.a(file2, (SunJCE_h)x509CertificateArray, sunJCE_h);
        SunJCE_h sunJCE_h2 = new SunJCE_h();
        SunJCE_h sunJCE_h3 = new SunJCE_h();
        SunJCE_b.a(file3, sunJCE_h2, sunJCE_h3);
        if (x509CertificateArray.a() || sunJCE_h2.a()) {
            throw new SecurityException("Missing mandatory jurisdiction policy files");
        }
        c = x509CertificateArray.a(sunJCE_h2);
        d = sunJCE_h.a() ? (sunJCE_h3.a() ? null : sunJCE_h3) : sunJCE_h.a(sunJCE_h3);
    }

    private static void a(String string, SunJCE_w[] sunJCE_wArray) {
        System.out.println(string);
        int n = 0;
        while (n < sunJCE_wArray.length) {
            System.out.println("CHAIN#" + (n + 1) + ": ");
            System.out.println(sunJCE_wArray[n]);
            ++n;
        }
    }

    private static void a(File file, SunJCE_h sunJCE_h, SunJCE_h sunJCE_h2) throws Exception {
        File file2 = file;
        JarFile jarFile = new JarFile(file2, false);
        Enumeration<JarEntry> enumeration = jarFile.entries();
        while (enumeration.hasMoreElements()) {
            JarEntry jarEntry = enumeration.nextElement();
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            if (jarEntry.getName().startsWith("default_")) {
                sunJCE_h.a(inputStream);
            } else if (jarEntry.getName().startsWith("exempt_")) {
                sunJCE_h2.a(inputStream);
            }
            inputStream.close();
        }
        jarFile.close();
    }

    static SunJCE_h a() {
        return c;
    }

    static SunJCE_h b() {
        return d;
    }

    static boolean c() {
        return k;
    }

    static byte[] d() {
        Object object;
        Object object2;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new InternalError("internal error: SHA-1 not available.");
        }
        byte by = (byte)System.currentTimeMillis();
        messageDigest.update(by);
        try {
            object2 = System.getProperties();
            Enumeration<?> enumeration = ((Properties)object2).propertyNames();
            while (enumeration.hasMoreElements()) {
                object = (String)enumeration.nextElement();
                messageDigest.update(((String)object).getBytes());
                messageDigest.update(((Properties)object2).getProperty((String)object).getBytes());
            }
            messageDigest.update(InetAddress.getLocalHost().toString().getBytes());
            File file = new File(((Properties)object2).getProperty("java.io.tmpdir"));
            String[] stringArray = file.list();
            int n = 0;
            while (n < stringArray.length) {
                messageDigest.update(stringArray[n].getBytes());
                ++n;
            }
        }
        catch (Exception exception) {
            messageDigest.update((byte)exception.hashCode());
        }
        object = Runtime.getRuntime();
        object2 = SunJCE_b.a(((Runtime)object).totalMemory());
        messageDigest.update((byte[])object2, 0, ((Object)object2).length);
        object2 = SunJCE_b.a(((Runtime)object).freeMemory());
        messageDigest.update((byte[])object2, 0, ((Object)object2).length);
        return messageDigest.digest();
    }

    private static byte[] a(long l) {
        byte[] byArray = new byte[8];
        int n = 0;
        while (n < 8) {
            byArray[n] = (byte)l;
            l >>= 8;
            ++n;
        }
        return byArray;
    }

    static void e() throws Exception {
        byte[] byArray = new byte[]{48, -126, 3, 44, 48, -126, 2, -23, 2, 4, 55, -7, 57, -27, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 48, 123, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 11, 48, 9, 6, 3, 85, 4, 8, 19, 2, 67, 65, 49, 18, 48, 16, 6, 3, 85, 4, 7, 19, 9, 67, 117, 112, 101, 114, 116, 105, 110, 111, 49, 25, 48, 23, 6, 3, 85, 4, 10, 19, 16, 83, 117, 110, 32, 77, 105, 99, 114, 111, 115, 121, 115, 116, 101, 109, 115, 49, 22, 48, 20, 6, 3, 85, 4, 11, 19, 13, 74, 97, 118, 97, 32, 83, 111, 102, 116, 119, 97, 114, 101, 49, 24, 48, 22, 6, 3, 85, 4, 3, 19, 15, 74, 67, 69, 32, 68, 101, 118, 101, 108, 111, 112, 109, 101, 110, 116, 48, 30, 23, 13, 57, 57, 49, 48, 48, 52, 50, 51, 51, 54, 48, 53, 90, 23, 13, 48, 48, 49, 48, 48, 51, 50, 51, 51, 54, 48, 53, 90, 48, 123, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 11, 48, 9, 6, 3, 85, 4, 8, 19, 2, 67, 65, 49, 18, 48, 16, 6, 3, 85, 4, 7, 19, 9, 67, 117, 112, 101, 114, 116, 105, 110, 111, 49, 25, 48, 23, 6, 3, 85, 4, 10, 19, 16, 83, 117, 110, 32, 77, 105, 99, 114, 111, 115, 121, 115, 116, 101, 109, 115, 49, 22, 48, 20, 6, 3, 85, 4, 11, 19, 13, 74, 97, 118, 97, 32, 83, 111, 102, 116, 119, 97, 114, 101, 49, 24, 48, 22, 6, 3, 85, 4, 3, 19, 15, 74, 67, 69, 32, 68, 101, 118, 101, 108, 111, 112, 109, 101, 110, 116, 48, -126, 1, -72, 48, -126, 1, 44, 6, 7, 42, -122, 72, -50, 56, 4, 1, 48, -126, 1, 31, 2, -127, -127, 0, -3, 127, 83, -127, 29, 117, 18, 41, 82, -33, 74, -100, 46, -20, -28, -25, -10, 17, -73, 82, 60, -17, 68, 0, -61, 30, 63, -128, -74, 81, 38, 105, 69, 93, 64, 34, 81, -5, 89, 61, -115, 88, -6, -65, -59, -11, -70, 48, -10, -53, -101, 85, 108, -41, -127, 59, -128, 29, 52, 111, -14, 102, 96, -73, 107, -103, 80, -91, -92, -97, -97, -24, 4, 123, 16, 34, -62, 79, -69, -87, -41, -2, -73, -58, 27, -8, 59, 87, -25, -58, -88, -90, 21, 15, 4, -5, -125, -10, -45, -59, 30, -61, 2, 53, 84, 19, 90, 22, -111, 50, -10, 117, -13, -82, 43, 97, -41, 42, -17, -14, 34, 3, 25, -99, -47, 72, 1, -57, 2, 21, 0, -105, 96, 80, -113, 21, 35, 11, -52, -78, -110, -71, -126, -94, -21, -124, 11, -16, 88, 28, -11, 2, -127, -127, 0, -9, -31, -96, -123, -42, -101, 61, -34, -53, -68, -85, 92, 54, -72, 87, -71, 121, -108, -81, -69, -6, 58, -22, -126, -7, 87, 76, 11, 61, 7, -126, 103, 81, 89, 87, -114, -70, -44, 89, 79, -26, 113, 7, 16, -127, -128, -76, 73, 22, 113, 35, -24, 76, 40, 22, 19, -73, -49, 9, 50, -116, -56, -90, -31, 60, 22, 122, -117, 84, 124, -115, 40, -32, -93, -82, 30, 43, -77, -90, 117, -111, 110, -93, 127, 11, -6, 33, 53, 98, -15, -5, 98, 122, 1, 36, 59, -52, -92, -15, -66, -88, 81, -112, -119, -88, -125, -33, -31, 90, -27, -97, 6, -110, -117, 102, 94, -128, 123, 85, 37, 100, 1, 76, 59, -2, -49, 73, 42, 3, -127, -123, 0, 2, -127, -127, 0, -31, -84, 71, -52, 26, 71, -106, -94, -72, -23, 53, -56, 18, -34, -103, 25, 85, 9, -113, -128, 60, -101, -9, -58, -87, -113, 71, 21, -128, 23, -87, -16, 87, 108, 107, 21, 64, 124, -126, 20, -124, 48, 87, 7, -53, 10, 30, -30, -16, 67, -66, 65, -110, -96, 1, 115, 120, 30, 99, -53, -100, 35, 14, 33, 108, 55, -112, 5, 60, 69, 81, 126, -9, -110, -32, -45, 89, -43, -40, 17, 116, 118, -37, -121, 120, 121, 59, 87, 89, 19, -125, 0, 41, 12, 16, 125, 74, 33, -12, -26, -73, 105, -88, 101, 7, -22, 43, 71, 50, -114, 28, -71, 70, 14, -106, -51, 69, 2, -46, 79, -112, 66, -106, -6, 33, -83, -87, -126, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 3, 48, 0, 48, 45, 2, 20, 69, -29, -92, -9, -99, 47, -94, -100, -1, 83, 3, 90, 75, 119, 114, -56, 87, 67, 77, 13, 2, 21, 0, -122, -97, -117, -19, 127, -8, -110, -79, -69, 74, -36, -95, 117, -116, 21, 44, 77, 105, 22, -9};
        byte[] byArray2 = new byte[]{-128, 64, 32, 16, 8, 4, 2, 1};
        byte[] byArray3 = new byte[20];
        byArray3 = SunJCE_b.d();
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        X509Certificate x509Certificate = (X509Certificate)certificateFactory.generateCertificate(byteArrayInputStream);
        byteArrayInputStream.close();
        PublicKey publicKey = g[0].getPublicKey();
        int n = 0;
        while (n < 8) {
            if ((byArray3[0] & byArray2[n]) == byArray2[n]) {
                try {
                    x509Certificate.verify(publicKey);
                    throw new SecurityException("Signature classes have been tampered with");
                }
                catch (SignatureException signatureException) {}
            } else {
                try {
                    g[0].verify(publicKey);
                }
                catch (SignatureException signatureException) {
                    throw new SecurityException("Signature classes have been tampered with");
                }
            }
            ++n;
        }
    }

    static /* synthetic */ byte[][] f() {
        return h;
    }

    static /* synthetic */ X509Certificate[] a(byte[][] byArray) throws IOException, CertificateException {
        return SunJCE_b.b(byArray);
    }

    static /* synthetic */ X509Certificate[] a(X509Certificate[] x509CertificateArray) {
        i = x509CertificateArray;
        return x509CertificateArray;
    }

    static /* synthetic */ byte[][] g() {
        return j;
    }

    static /* synthetic */ void h() throws Exception {
        SunJCE_b.i();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    static {
        try {
            AccessController.doPrivileged(new SunJCE_x());
            k = !c.implies(b);
        }
        catch (Exception exception) {
            throw new SecurityException("Cannot set up certs for trusted CAs: " + exception);
        }
    }
}

