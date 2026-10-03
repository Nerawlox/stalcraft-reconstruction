/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_an;
import com.sun.crypto.provider.SunJCE_b;
import com.sun.crypto.provider.SunJCE_w;
import com.sun.crypto.provider.SunJCE_x;
import com.sun.crypto.provider.SunJCE_z;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.security.Provider;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public final class SunJCE
extends Provider {
    private static String a = "SunJCE Provider (implements DES, Triple DES, Blowfish, PBE, Diffie-Hellman, HMAC-MD5, HMAC-SHA1)";
    static final boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static X509Certificate[] e = null;
    private static final byte[][] f = new byte[][]{{48, -126, 3, -64, 48, -126, 3, 126, -96, 3, 2, 1, 2, 2, 1, 1, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 48, -127, -112, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 11, 48, 9, 6, 3, 85, 4, 8, 19, 2, 67, 65, 49, 18, 48, 16, 6, 3, 85, 4, 7, 19, 9, 80, 97, 108, 111, 32, 65, 108, 116, 111, 49, 29, 48, 27, 6, 3, 85, 4, 10, 19, 20, 83, 117, 110, 32, 77, 105, 99, 114, 111, 115, 121, 115, 116, 101, 109, 115, 32, 73, 110, 99, 49, 35, 48, 33, 6, 3, 85, 4, 11, 19, 26, 74, 97, 118, 97, 32, 83, 111, 102, 116, 119, 97, 114, 101, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, 30, 23, 13, 48, 48, 48, 52, 49, 50, 48, 55, 48, 48, 48, 48, 90, 23, 13, 48, 54, 48, 52, 49, 50, 48, 55, 48, 48, 48, 48, 90, 48, -127, -112, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 11, 48, 9, 6, 3, 85, 4, 8, 19, 2, 67, 65, 49, 18, 48, 16, 6, 3, 85, 4, 7, 19, 9, 80, 97, 108, 111, 32, 65, 108, 116, 111, 49, 29, 48, 27, 6, 3, 85, 4, 10, 19, 20, 83, 117, 110, 32, 77, 105, 99, 114, 111, 115, 121, 115, 116, 101, 109, 115, 32, 73, 110, 99, 49, 35, 48, 33, 6, 3, 85, 4, 11, 19, 26, 74, 97, 118, 97, 32, 83, 111, 102, 116, 119, 97, 114, 101, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, -126, 1, -73, 48, -126, 1, 44, 6, 7, 42, -122, 72, -50, 56, 4, 1, 48, -126, 1, 31, 2, -127, -127, 0, -21, -81, 55, 4, 30, -54, 81, 30, 105, 93, -80, -14, -113, -10, -75, 73, 31, -58, -92, -103, 5, -41, 41, -65, 116, -73, 106, -11, 25, -40, 30, -28, 27, -8, 10, 1, -102, -104, -1, 112, -85, -30, 74, 86, -122, 108, 83, -77, -4, -31, -56, -127, -116, 49, -16, -60, -13, -80, -117, -26, 112, 6, -20, -9, 105, 104, -37, -125, 76, 114, 41, -119, 41, 54, 23, 92, 59, 74, 7, -96, 32, 2, 42, 70, -105, 81, 29, 112, -56, 8, 24, 11, -50, 12, 110, -101, 118, -9, 5, -29, -25, -5, -45, 97, 121, -31, 96, -102, 36, -115, 6, -107, -125, 60, 81, 32, -31, 48, -49, 56, 87, -126, -90, 26, 114, 13, -50, -45, 2, 21, 0, -124, 37, 69, -31, -70, -71, -87, 98, -85, 121, -24, 91, 48, -72, -119, 107, 27, -1, 123, 117, 2, -127, -127, 0, -85, -55, 116, 123, 116, -17, -18, 66, -75, 106, 83, 77, 59, -35, -112, 6, 114, 104, -111, 15, 11, -92, 41, 118, 46, 85, 59, -43, -82, 77, 101, 92, 126, 42, 58, 4, -90, 103, -90, -48, 113, -86, -91, -41, -73, -30, -63, 114, 13, -92, -47, -86, 30, -110, 84, 76, 32, 0, 9, -94, -80, 9, 65, 25, 51, 0, -78, -61, 92, -82, 66, -8, -79, -117, -54, 124, -106, -40, 16, 127, 55, 68, 91, -86, -52, 120, -56, -41, 114, 118, 55, 107, 64, -103, -88, 85, 102, -6, -88, 3, 30, -117, 74, 17, 2, 105, -53, 76, -72, 37, 6, 28, -96, 119, -46, -55, -84, -46, 61, -23, 10, 16, -6, 118, 112, -73, -5, -36, 3, -127, -124, 0, 2, -127, -128, 45, 9, -104, 92, -84, -72, -100, -57, -103, 126, -18, 32, 25, 42, 52, -112, -7, -41, -85, -85, -82, -35, 107, 114, -107, 13, 102, -8, -17, 39, -113, 68, -78, -19, 40, 68, -57, -2, -81, -80, -90, 39, 111, 0, 103, 69, -126, 91, 7, -88, 86, 86, 59, -46, 41, 81, 97, 94, 105, 57, -41, 46, 116, 119, 18, -49, 25, 74, -11, 45, -56, -53, 114, 97, -60, 78, 111, -6, 71, 67, 63, 20, -69, -6, -68, 24, 102, 40, -62, -39, 102, -117, 122, 45, 47, -62, 96, -110, 75, 20, -2, 88, 62, 33, 127, 104, 98, -66, 108, 72, 73, -7, -96, 75, 94, -123, -99, 25, 16, -7, 21, 69, 81, 27, 113, -44, -9, 11, -93, 102, 48, 100, 48, 17, 6, 9, 96, -122, 72, 1, -122, -8, 66, 1, 1, 4, 4, 3, 2, 0, 7, 48, 15, 6, 3, 85, 29, 19, 1, 1, -1, 4, 5, 48, 3, 1, 1, -1, 48, 31, 6, 3, 85, 29, 35, 4, 24, 48, 22, -128, 20, 101, -30, -12, -122, -55, -45, 78, -16, -111, 78, 88, -94, 106, -11, -40, 120, 90, -102, -63, -90, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 101, -30, -12, -122, -55, -45, 78, -16, -111, 78, 88, -94, 106, -11, -40, 120, 90, -102, -63, -90, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 3, 47, 0, 48, 44, 2, 20, 36, -97, 2, -61, -5, 49, -43, -111, 59, -7, 126, 86, 111, -106, -33, 100, 10, 4, -104, -76, 2, 20, 110, 121, -124, -89, -18, 104, -93, 2, 114, 49, 99, -37, 67, -85, 8, -20, 77, -17, 22, 58}, {48, -126, 3, 79, 48, -126, 3, 13, -96, 3, 2, 1, 2, 2, 4, 57, 36, -91, 85, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 48, 96, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 24, 48, 22, 6, 3, 85, 4, 10, 19, 15, 73, 66, 77, 32, 67, 111, 114, 112, 111, 114, 97, 116, 105, 111, 110, 49, 25, 48, 23, 6, 3, 85, 4, 11, 19, 16, 73, 66, 77, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, 30, 23, 13, 48, 48, 48, 53, 49, 57, 48, 50, 50, 50, 49, 51, 90, 23, 13, 48, 54, 48, 53, 49, 56, 48, 50, 50, 50, 49, 51, 90, 48, 96, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 24, 48, 22, 6, 3, 85, 4, 10, 19, 15, 73, 66, 77, 32, 67, 111, 114, 112, 111, 114, 97, 116, 105, 111, 110, 49, 25, 48, 23, 6, 3, 85, 4, 11, 19, 16, 73, 66, 77, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, -126, 1, -72, 48, -126, 1, 44, 6, 7, 42, -122, 72, -50, 56, 4, 1, 48, -126, 1, 31, 2, -127, -127, 0, -3, 127, 83, -127, 29, 117, 18, 41, 82, -33, 74, -100, 46, -20, -28, -25, -10, 17, -73, 82, 60, -17, 68, 0, -61, 30, 63, -128, -74, 81, 38, 105, 69, 93, 64, 34, 81, -5, 89, 61, -115, 88, -6, -65, -59, -11, -70, 48, -10, -53, -101, 85, 108, -41, -127, 59, -128, 29, 52, 111, -14, 102, 96, -73, 107, -103, 80, -91, -92, -97, -97, -24, 4, 123, 16, 34, -62, 79, -69, -87, -41, -2, -73, -58, 27, -8, 59, 87, -25, -58, -88, -90, 21, 15, 4, -5, -125, -10, -45, -59, 30, -61, 2, 53, 84, 19, 90, 22, -111, 50, -10, 117, -13, -82, 43, 97, -41, 42, -17, -14, 34, 3, 25, -99, -47, 72, 1, -57, 2, 21, 0, -105, 96, 80, -113, 21, 35, 11, -52, -78, -110, -71, -126, -94, -21, -124, 11, -16, 88, 28, -11, 2, -127, -127, 0, -9, -31, -96, -123, -42, -101, 61, -34, -53, -68, -85, 92, 54, -72, 87, -71, 121, -108, -81, -69, -6, 58, -22, -126, -7, 87, 76, 11, 61, 7, -126, 103, 81, 89, 87, -114, -70, -44, 89, 79, -26, 113, 7, 16, -127, -128, -76, 73, 22, 113, 35, -24, 76, 40, 22, 19, -73, -49, 9, 50, -116, -56, -90, -31, 60, 22, 122, -117, 84, 124, -115, 40, -32, -93, -82, 30, 43, -77, -90, 117, -111, 110, -93, 127, 11, -6, 33, 53, 98, -15, -5, 98, 122, 1, 36, 59, -52, -92, -15, -66, -88, 81, -112, -119, -88, -125, -33, -31, 90, -27, -97, 6, -110, -117, 102, 94, -128, 123, 85, 37, 100, 1, 76, 59, -2, -49, 73, 42, 3, -127, -123, 0, 2, -127, -127, 0, -22, 107, 0, -57, -33, 16, 59, -71, 116, 53, -89, -31, 109, 102, -126, 77, -9, 91, 86, 113, -62, 38, 69, 39, 114, 61, 81, 16, 98, -1, -77, -36, 16, -55, -5, 81, 19, -44, -83, -117, -88, 37, 110, 93, -55, 120, -46, 91, 39, -45, 19, 65, 71, 20, 6, 124, -53, -126, 56, 94, -58, 11, 97, -96, 76, -125, 45, -108, -52, -116, 46, -124, -112, 58, -113, 66, 10, 105, 82, -45, 116, 38, 119, -92, 20, 125, 42, 113, 65, -120, -119, 119, -90, 45, 98, -102, -95, 88, -104, 109, 108, -49, -50, -88, -22, -70, -35, -24, -95, 16, 68, -116, -124, 66, -63, -72, 31, 43, -76, -68, -77, 93, 116, 96, -128, -115, 66, 84, -93, 83, 48, 81, 48, 31, 6, 3, 85, 29, 35, 4, 24, 48, 22, -128, 20, 126, 61, 77, 77, -52, 16, 89, -70, -7, -82, 66, 61, -27, -55, 87, 90, 82, 11, 126, -121, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 126, 61, 77, 77, -52, 16, 89, -70, -7, -82, 66, 61, -27, -55, 87, 90, 82, 11, 126, -121, 48, 15, 6, 3, 85, 29, 19, 1, 1, -1, 4, 5, 48, 3, 1, 1, -1, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 3, 47, 0, 48, 44, 2, 20, 28, -17, -10, -64, 92, -19, -109, 112, 34, -31, 75, -55, 15, -16, -99, 122, 9, -18, -122, -122, 2, 20, 18, 119, 71, 98, -62, -97, 25, 97, -36, 41, -6, -71, 73, -91, 25, -42, -91, -68, 69, 77}};
    static /* synthetic */ Class g;

    public SunJCE() {
        super("SunJCE", 1.22, a);
        AccessController.doPrivileged(new SunJCE_b(this));
    }

    static final void a() {
        if (c) {
            return;
        }
        SunJCE.b();
    }

    private static final synchronized void b() {
        Object object;
        if (c) {
            return;
        }
        URL uRL = null;
        try {
            object = g == null ? (g = SunJCE.class$("com.sun.crypto.provider.SunJCE")) : g;
            ClassLoader classLoader = ((Class)object).getClassLoader();
            URL uRL2 = (URL)AccessController.doPrivileged(new SunJCE_w(classLoader));
            if (uRL2 == null) {
                throw new SecurityException("Cannot get the JCE framework URL. Check that SunJCE can read the JCE framework");
            }
            int n = SunJCE.a(uRL2.toString());
            if (n == -1) {
                throw new SecurityException("The JCE framework is invalid");
            }
            uRL = new URL(uRL2.toString().substring(0, n + 1));
            int n2 = 4;
            URL uRL3 = new URL(uRL2.toString().substring(n2, n - 1));
            if (!uRL3.getProtocol().equalsIgnoreCase("file")) {
                throw new SecurityException("JCE should be deployed as an installed extension");
            }
        }
        catch (IOException iOException) {
            throw new SecurityException("The provider SunJCE cannot authenticate JCE framework" + iOException);
        }
        if (e == null) {
            try {
                e = SunJCE.c();
            }
            catch (Exception exception) {
                throw new SecurityException("Cannot setup the trusted CA certs to authenticate JCE framework " + exception);
            }
        }
        object = new SunJCE_x(uRL);
        try {
            ((SunJCE_x)object).a(e);
        }
        catch (Exception exception) {
            throw new SecurityException("Cannot authenticate JCE framework " + exception);
        }
        c = true;
    }

    private static X509Certificate[] c() throws IOException, CertificateException {
        int n = f.length;
        X509Certificate[] x509CertificateArray = new X509Certificate[n];
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        int n2 = 0;
        while (n2 < n) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(f[n2]);
            x509CertificateArray[n2] = (X509Certificate)certificateFactory.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            ++n2;
        }
        return x509CertificateArray;
    }

    private static int a(String string) {
        int n = string.lastIndexOf(".jar!/");
        if (n > 0) {
            return n + 5;
        }
        return -1;
    }

    static final boolean a(Class clazz) {
        if (d) {
            return true;
        }
        return SunJCE.b(clazz);
    }

    private static final synchronized boolean b(Class clazz) {
        Class clazz2;
        URL uRL;
        if (d) {
            return true;
        }
        if (e == null) {
            try {
                e = SunJCE.c();
            }
            catch (Exception exception) {
                return false;
            }
        }
        if ((uRL = (URL)AccessController.doPrivileged(new SunJCE_z(clazz2 = clazz))) == null) {
            return false;
        }
        SunJCE_x sunJCE_x = new SunJCE_x(uRL);
        try {
            sunJCE_x.a(e);
        }
        catch (Exception exception) {
            return false;
        }
        d = true;
        return true;
    }

    private static Certificate[] c(Class clazz) {
        Class clazz2 = clazz;
        return (Certificate[])AccessController.doPrivileged(new SunJCE_an(clazz2));
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

