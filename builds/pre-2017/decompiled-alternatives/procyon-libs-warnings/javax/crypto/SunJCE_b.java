// 
// Decompiled by Procyon v0.6.0
// 

package javax.crypto;

import java.util.Hashtable;
import java.security.Permission;
import java.security.PrivilegedExceptionAction;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Properties;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.util.zip.ZipEntry;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.io.File;
import java.security.cert.CertificateException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.net.URL;
import java.security.PrivilegedAction;
import java.security.AccessController;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Vector;

final class SunJCE_b
{
    static final boolean a = false;
    private static final SunJCE_n b;
    private static SunJCE_h c;
    private static SunJCE_h d;
    private static Vector e;
    private static Vector f;
    static X509Certificate[] g;
    private static final byte[][] h;
    private static X509Certificate[] i;
    private static final byte[][] j;
    static boolean k;
    static X509Certificate[] l;
    
    private SunJCE_b() {
    }
    
    private static String a(final String s, final Provider provider) {
        final String property = provider.getProperty(s);
        if (property != null) {
            return property;
        }
        final Enumeration<Object> keys = ((Hashtable<Object, V>)provider).keys();
        while (keys.hasMoreElements()) {
            final String s2 = keys.nextElement();
            if (s.equalsIgnoreCase(s2)) {
                return provider.getProperty(s2);
            }
        }
        return null;
    }
    
    private static String a(final String s, final String s2, final Provider provider) {
        return a("Alg.Alias." + s2 + "." + s, provider);
    }
    
    private static Class b(final String s, final String s2, final Provider provider) throws NoSuchAlgorithmException {
        String s3 = s2 + "." + s;
        String s4 = a(s3, provider);
        if (s4 == null) {
            final String a = a(s, s2, provider);
            if (a != null) {
                s3 = s2 + "." + a;
            }
            if (a == null || (s4 = a(s3, provider)) == null) {
                throw new NoSuchAlgorithmException("No such algorithm: " + s);
            }
        }
        Class<?> clazz;
        try {
            final ClassLoader classLoader = provider.getClass().getClassLoader();
            if (classLoader == null) {
                clazz = Class.forName(s4);
            }
            else {
                clazz = classLoader.loadClass(s4);
            }
        }
        catch (final ClassNotFoundException ex) {
            throw new NoSuchAlgorithmException("Class " + s4 + " configured for " + s2 + " not found: " + ex.getMessage());
        }
        catch (final SecurityException ex2) {
            throw new NoSuchAlgorithmException("Class " + s4 + " configured for " + s2 + " cannot be accessed: " + ex2.getMessage());
        }
        return clazz;
    }
    
    static Object[] a(final String s, final String s2, final String s3) throws NoSuchAlgorithmException, NoSuchProviderException {
        Class clazz = null;
        Provider provider = null;
        if (s3 != null) {
            provider = Security.getProvider(s3);
            if (provider == null) {
                throw new NoSuchProviderException("No such provider: " + s3);
            }
            clazz = b(s, s2, provider);
            a(provider);
        }
        else {
            final Provider[] providers = Security.getProviders();
            boolean b = false;
            for (int n = 0; n < providers.length && !b; ++n) {
                try {
                    clazz = b(s, s2, providers[n]);
                    a(providers[n]);
                    b = true;
                    provider = providers[n];
                }
                catch (final NoSuchAlgorithmException ex) {}
                catch (final NoSuchProviderException ex2) {}
            }
            if (!b) {
                throw new NoSuchAlgorithmException("Algorithm " + s + " not available");
            }
        }
        return a(s, s2, provider, clazz);
    }
    
    private static Object[] a(final String s, final String s2, final Provider provider, final Class clazz) throws NoSuchAlgorithmException {
        Class<?> forName;
        try {
            forName = Class.forName("javax.crypto." + s2 + "Spi");
        }
        catch (final ClassNotFoundException ex) {
            throw new NoSuchAlgorithmException(ex.getMessage());
        }
        if (!a(clazz, forName)) {
            throw new NoSuchAlgorithmException("Class " + clazz.getName() + " configured for " + s2 + " is not a " + s2);
        }
        Object o = SunJCE_b.b;
        Object instance = null;
        if (c() && s2.equals("Cipher")) {
            String substring = s;
            final int index = s.indexOf(47);
            if (index != -1) {
                substring = s.substring(0, index);
            }
            o = AccessController.doPrivileged((PrivilegedAction<SunJCE_g>)new SunJCE_b.SunJCE_f()).a(substring.toUpperCase());
            final String b = ((SunJCE_o)o).b();
            if (b != null) {
                try {
                    instance = ExemptionMechanism.getInstance(b);
                }
                catch (final Exception ex2) {}
            }
        }
        try {
            return new Object[] { clazz.newInstance(), provider, o, instance, new Boolean(c()) };
        }
        catch (final InstantiationException ex3) {
            throw new NoSuchAlgorithmException("Class " + clazz.getName() + " configured for " + s2 + " cannot be instantiated: " + ex3.getMessage());
        }
        catch (final IllegalAccessException ex4) {
            throw new NoSuchAlgorithmException("Class " + clazz.getName() + " configured for " + s2 + " cannot be accessed: " + ex4.getMessage());
        }
    }
    
    private static boolean a(Class superclass, final Class clazz) {
        while (!superclass.equals(clazz)) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }
    
    private static void a(final Provider provider) throws NoSuchProviderException {
        if (b(provider)) {
            try {
                new SunJCE_d(a(provider.getClass())).verify(SunJCE_b.g);
                SunJCE_b.e.addElement(provider);
            }
            catch (final Exception ex) {
                throw new NoSuchProviderException("JCE cannot authenticate the provider " + provider.getName() + ": " + ex);
            }
            finally {
                c(provider);
            }
        }
    }
    
    private static boolean b(final Provider provider) {
        if (SunJCE_b.e.contains(provider)) {
            return false;
        }
        synchronized (SunJCE_b.f) {
            if (!SunJCE_b.f.contains(provider)) {
                SunJCE_b.f.addElement(provider);
                return true;
            }
            while (SunJCE_b.f.contains(provider)) {
                try {
                    SunJCE_b.f.wait();
                }
                catch (final InterruptedException ex) {}
            }
            if (SunJCE_b.e.contains(provider)) {
                return false;
            }
            SunJCE_b.f.addElement(provider);
            return true;
        }
    }
    
    private static void c(final Provider provider) {
        synchronized (SunJCE_b.f) {
            SunJCE_b.f.remove(provider);
            SunJCE_b.f.notifyAll();
        }
    }
    
    private static URL a(final Class clazz) {
        return AccessController.doPrivileged((PrivilegedAction<URL>)new SunJCE_b.SunJCE_c(clazz));
    }
    
    private static X509Certificate[] b(final byte[][] array) throws IOException, CertificateException {
        final int length = array.length;
        final X509Certificate[] array2 = new X509Certificate[length];
        final CertificateFactory instance = CertificateFactory.getInstance("X.509");
        for (int i = 0; i < length; ++i) {
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array[i]);
            array2[i] = (X509Certificate)instance.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
        }
        return array2;
    }
    
    private static void i() throws Exception {
        final URL a = a(Cipher.class);
        final URL url = new URL(a, "US_export_policy.jar");
        final URL url2 = new URL(a, "local_policy.jar");
        final File file = new File(a.getFile());
        final File file2 = new File(url.getFile());
        final File file3 = new File(url2.getFile());
        if (!file.exists() || !file2.exists() || !file3.exists()) {
            throw new SecurityException("Cannot locate policy and/or framework files for signer restraint check!");
        }
        final SunJCE_w[] a2 = SunJCE_d.a(a, "javax/crypto/Cipher.class");
        final String[] array = { new String("default_"), new String("exempt_") };
        final SunJCE_w[] a3 = SunJCE_d.a(url, array);
        final SunJCE_w[] a4 = SunJCE_d.a(url2, array);
        final SunJCE_w[] array2 = new SunJCE_w[0];
        if (a2.length == 0 || a3.length == 0 || a4.length == 0) {
            throw new SecurityException("Signer restraint check failed!");
        }
        final SunJCE_w[] a5 = SunJCE_d.a(SunJCE_d.a(a2, a3), a4);
        if (a5.length == 0) {
            throw new SecurityException("Signer restraint check failed!");
        }
        boolean b = false;
        for (int i = 0; i < a5.length; ++i) {
            if (SunJCE_d.a(a5[i].toArray(), SunJCE_b.i)) {
                b = true;
                break;
            }
        }
        if (!b) {
            throw new SecurityException("Jurisdiction policy files are not signed by trusted signers!");
        }
        final SunJCE_h sunJCE_h = new SunJCE_h();
        final SunJCE_h sunJCE_h2 = new SunJCE_h();
        a(file2, sunJCE_h, sunJCE_h2);
        final SunJCE_h sunJCE_h3 = new SunJCE_h();
        final SunJCE_h sunJCE_h4 = new SunJCE_h();
        a(file3, sunJCE_h3, sunJCE_h4);
        if (sunJCE_h.a() || sunJCE_h3.a()) {
            throw new SecurityException("Missing mandatory jurisdiction policy files");
        }
        SunJCE_b.c = sunJCE_h.a(sunJCE_h3);
        if (sunJCE_h2.a()) {
            SunJCE_b.d = (sunJCE_h4.a() ? null : sunJCE_h4);
        }
        else {
            SunJCE_b.d = sunJCE_h2.a(sunJCE_h4);
        }
    }
    
    private static void a(final String s, final SunJCE_w[] array) {
        System.out.println(s);
        for (int i = 0; i < array.length; ++i) {
            System.out.println("CHAIN#" + (i + 1) + ": ");
            System.out.println(array[i]);
        }
    }
    
    private static void a(final File file, final SunJCE_h sunJCE_h, final SunJCE_h sunJCE_h2) throws Exception {
        final JarFile jarFile = new JarFile(file, false);
        final Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            final JarEntry jarEntry = entries.nextElement();
            final InputStream inputStream = jarFile.getInputStream(jarEntry);
            if (jarEntry.getName().startsWith("default_")) {
                sunJCE_h.a(inputStream);
            }
            else if (jarEntry.getName().startsWith("exempt_")) {
                sunJCE_h2.a(inputStream);
            }
            inputStream.close();
        }
        jarFile.close();
    }
    
    static SunJCE_h a() {
        return SunJCE_b.c;
    }
    
    static SunJCE_h b() {
        return SunJCE_b.d;
    }
    
    static boolean c() {
        return SunJCE_b.k;
    }
    
    static byte[] d() {
        MessageDigest instance;
        try {
            instance = MessageDigest.getInstance("SHA");
        }
        catch (final NoSuchAlgorithmException ex) {
            throw new InternalError("internal error: SHA-1 not available.");
        }
        instance.update((byte)System.currentTimeMillis());
        try {
            final Properties properties = System.getProperties();
            final Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                final String s = (String)propertyNames.nextElement();
                instance.update(s.getBytes());
                instance.update(properties.getProperty(s).getBytes());
            }
            instance.update(InetAddress.getLocalHost().toString().getBytes());
            final String[] list = new File(properties.getProperty("java.io.tmpdir")).list();
            for (int i = 0; i < list.length; ++i) {
                instance.update(list[i].getBytes());
            }
        }
        catch (final Exception ex2) {
            instance.update((byte)ex2.hashCode());
        }
        final Runtime runtime = Runtime.getRuntime();
        final byte[] a = a(runtime.totalMemory());
        instance.update(a, 0, a.length);
        final byte[] a2 = a(runtime.freeMemory());
        instance.update(a2, 0, a2.length);
        return instance.digest();
    }
    
    private static byte[] a(long n) {
        final byte[] array = new byte[8];
        for (int i = 0; i < 8; ++i) {
            array[i] = (byte)n;
            n >>= 8;
        }
        return array;
    }
    
    static void e() throws Exception {
        final byte[] array = { 48, -126, 3, 44, 48, -126, 2, -23, 2, 4, 55, -7, 57, -27, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 48, 123, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 11, 48, 9, 6, 3, 85, 4, 8, 19, 2, 67, 65, 49, 18, 48, 16, 6, 3, 85, 4, 7, 19, 9, 67, 117, 112, 101, 114, 116, 105, 110, 111, 49, 25, 48, 23, 6, 3, 85, 4, 10, 19, 16, 83, 117, 110, 32, 77, 105, 99, 114, 111, 115, 121, 115, 116, 101, 109, 115, 49, 22, 48, 20, 6, 3, 85, 4, 11, 19, 13, 74, 97, 118, 97, 32, 83, 111, 102, 116, 119, 97, 114, 101, 49, 24, 48, 22, 6, 3, 85, 4, 3, 19, 15, 74, 67, 69, 32, 68, 101, 118, 101, 108, 111, 112, 109, 101, 110, 116, 48, 30, 23, 13, 57, 57, 49, 48, 48, 52, 50, 51, 51, 54, 48, 53, 90, 23, 13, 48, 48, 49, 48, 48, 51, 50, 51, 51, 54, 48, 53, 90, 48, 123, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 11, 48, 9, 6, 3, 85, 4, 8, 19, 2, 67, 65, 49, 18, 48, 16, 6, 3, 85, 4, 7, 19, 9, 67, 117, 112, 101, 114, 116, 105, 110, 111, 49, 25, 48, 23, 6, 3, 85, 4, 10, 19, 16, 83, 117, 110, 32, 77, 105, 99, 114, 111, 115, 121, 115, 116, 101, 109, 115, 49, 22, 48, 20, 6, 3, 85, 4, 11, 19, 13, 74, 97, 118, 97, 32, 83, 111, 102, 116, 119, 97, 114, 101, 49, 24, 48, 22, 6, 3, 85, 4, 3, 19, 15, 74, 67, 69, 32, 68, 101, 118, 101, 108, 111, 112, 109, 101, 110, 116, 48, -126, 1, -72, 48, -126, 1, 44, 6, 7, 42, -122, 72, -50, 56, 4, 1, 48, -126, 1, 31, 2, -127, -127, 0, -3, 127, 83, -127, 29, 117, 18, 41, 82, -33, 74, -100, 46, -20, -28, -25, -10, 17, -73, 82, 60, -17, 68, 0, -61, 30, 63, -128, -74, 81, 38, 105, 69, 93, 64, 34, 81, -5, 89, 61, -115, 88, -6, -65, -59, -11, -70, 48, -10, -53, -101, 85, 108, -41, -127, 59, -128, 29, 52, 111, -14, 102, 96, -73, 107, -103, 80, -91, -92, -97, -97, -24, 4, 123, 16, 34, -62, 79, -69, -87, -41, -2, -73, -58, 27, -8, 59, 87, -25, -58, -88, -90, 21, 15, 4, -5, -125, -10, -45, -59, 30, -61, 2, 53, 84, 19, 90, 22, -111, 50, -10, 117, -13, -82, 43, 97, -41, 42, -17, -14, 34, 3, 25, -99, -47, 72, 1, -57, 2, 21, 0, -105, 96, 80, -113, 21, 35, 11, -52, -78, -110, -71, -126, -94, -21, -124, 11, -16, 88, 28, -11, 2, -127, -127, 0, -9, -31, -96, -123, -42, -101, 61, -34, -53, -68, -85, 92, 54, -72, 87, -71, 121, -108, -81, -69, -6, 58, -22, -126, -7, 87, 76, 11, 61, 7, -126, 103, 81, 89, 87, -114, -70, -44, 89, 79, -26, 113, 7, 16, -127, -128, -76, 73, 22, 113, 35, -24, 76, 40, 22, 19, -73, -49, 9, 50, -116, -56, -90, -31, 60, 22, 122, -117, 84, 124, -115, 40, -32, -93, -82, 30, 43, -77, -90, 117, -111, 110, -93, 127, 11, -6, 33, 53, 98, -15, -5, 98, 122, 1, 36, 59, -52, -92, -15, -66, -88, 81, -112, -119, -88, -125, -33, -31, 90, -27, -97, 6, -110, -117, 102, 94, -128, 123, 85, 37, 100, 1, 76, 59, -2, -49, 73, 42, 3, -127, -123, 0, 2, -127, -127, 0, -31, -84, 71, -52, 26, 71, -106, -94, -72, -23, 53, -56, 18, -34, -103, 25, 85, 9, -113, -128, 60, -101, -9, -58, -87, -113, 71, 21, -128, 23, -87, -16, 87, 108, 107, 21, 64, 124, -126, 20, -124, 48, 87, 7, -53, 10, 30, -30, -16, 67, -66, 65, -110, -96, 1, 115, 120, 30, 99, -53, -100, 35, 14, 33, 108, 55, -112, 5, 60, 69, 81, 126, -9, -110, -32, -45, 89, -43, -40, 17, 116, 118, -37, -121, 120, 121, 59, 87, 89, 19, -125, 0, 41, 12, 16, 125, 74, 33, -12, -26, -73, 105, -88, 101, 7, -22, 43, 71, 50, -114, 28, -71, 70, 14, -106, -51, 69, 2, -46, 79, -112, 66, -106, -6, 33, -83, -87, -126, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 3, 48, 0, 48, 45, 2, 20, 69, -29, -92, -9, -99, 47, -94, -100, -1, 83, 3, 90, 75, 119, 114, -56, 87, 67, 77, 13, 2, 21, 0, -122, -97, -117, -19, 127, -8, -110, -79, -69, 74, -36, -95, 117, -116, 21, 44, 77, 105, 22, -9 };
        final byte[] array2 = { -128, 64, 32, 16, 8, 4, 2, 1 };
        final byte[] array3 = new byte[20];
        final byte[] d = d();
        final CertificateFactory instance = CertificateFactory.getInstance("X.509");
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array);
        final X509Certificate x509Certificate = (X509Certificate)instance.generateCertificate(byteArrayInputStream);
        byteArrayInputStream.close();
        final PublicKey publicKey = SunJCE_b.g[0].getPublicKey();
        for (int i = 0; i < 8; ++i) {
            if ((d[0] & array2[i]) == array2[i]) {
                try {
                    x509Certificate.verify(publicKey);
                    throw new SecurityException("Signature classes have been tampered with");
                }
                catch (final SignatureException ex) {
                    continue;
                }
            }
            try {
                SunJCE_b.g[0].verify(publicKey);
            }
            catch (final SignatureException ex2) {
                throw new SecurityException("Signature classes have been tampered with");
            }
        }
    }
    
    static {
        b = new SunJCE_n();
        SunJCE_b.c = null;
        SunJCE_b.d = null;
        SunJCE_b.e = new Vector(2);
        SunJCE_b.f = new Vector(2);
        SunJCE_b.g = null;
        h = new byte[][] { { 48, -126, 3, -64, 48, -126, 3, 126, -96, 3, 2, 1, 2, 2, 1, 1, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 48, -127, -112, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 11, 48, 9, 6, 3, 85, 4, 8, 19, 2, 67, 65, 49, 18, 48, 16, 6, 3, 85, 4, 7, 19, 9, 80, 97, 108, 111, 32, 65, 108, 116, 111, 49, 29, 48, 27, 6, 3, 85, 4, 10, 19, 20, 83, 117, 110, 32, 77, 105, 99, 114, 111, 115, 121, 115, 116, 101, 109, 115, 32, 73, 110, 99, 49, 35, 48, 33, 6, 3, 85, 4, 11, 19, 26, 74, 97, 118, 97, 32, 83, 111, 102, 116, 119, 97, 114, 101, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, 30, 23, 13, 48, 48, 48, 52, 49, 50, 48, 55, 48, 48, 48, 48, 90, 23, 13, 48, 54, 48, 52, 49, 50, 48, 55, 48, 48, 48, 48, 90, 48, -127, -112, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 11, 48, 9, 6, 3, 85, 4, 8, 19, 2, 67, 65, 49, 18, 48, 16, 6, 3, 85, 4, 7, 19, 9, 80, 97, 108, 111, 32, 65, 108, 116, 111, 49, 29, 48, 27, 6, 3, 85, 4, 10, 19, 20, 83, 117, 110, 32, 77, 105, 99, 114, 111, 115, 121, 115, 116, 101, 109, 115, 32, 73, 110, 99, 49, 35, 48, 33, 6, 3, 85, 4, 11, 19, 26, 74, 97, 118, 97, 32, 83, 111, 102, 116, 119, 97, 114, 101, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, -126, 1, -73, 48, -126, 1, 44, 6, 7, 42, -122, 72, -50, 56, 4, 1, 48, -126, 1, 31, 2, -127, -127, 0, -21, -81, 55, 4, 30, -54, 81, 30, 105, 93, -80, -14, -113, -10, -75, 73, 31, -58, -92, -103, 5, -41, 41, -65, 116, -73, 106, -11, 25, -40, 30, -28, 27, -8, 10, 1, -102, -104, -1, 112, -85, -30, 74, 86, -122, 108, 83, -77, -4, -31, -56, -127, -116, 49, -16, -60, -13, -80, -117, -26, 112, 6, -20, -9, 105, 104, -37, -125, 76, 114, 41, -119, 41, 54, 23, 92, 59, 74, 7, -96, 32, 2, 42, 70, -105, 81, 29, 112, -56, 8, 24, 11, -50, 12, 110, -101, 118, -9, 5, -29, -25, -5, -45, 97, 121, -31, 96, -102, 36, -115, 6, -107, -125, 60, 81, 32, -31, 48, -49, 56, 87, -126, -90, 26, 114, 13, -50, -45, 2, 21, 0, -124, 37, 69, -31, -70, -71, -87, 98, -85, 121, -24, 91, 48, -72, -119, 107, 27, -1, 123, 117, 2, -127, -127, 0, -85, -55, 116, 123, 116, -17, -18, 66, -75, 106, 83, 77, 59, -35, -112, 6, 114, 104, -111, 15, 11, -92, 41, 118, 46, 85, 59, -43, -82, 77, 101, 92, 126, 42, 58, 4, -90, 103, -90, -48, 113, -86, -91, -41, -73, -30, -63, 114, 13, -92, -47, -86, 30, -110, 84, 76, 32, 0, 9, -94, -80, 9, 65, 25, 51, 0, -78, -61, 92, -82, 66, -8, -79, -117, -54, 124, -106, -40, 16, 127, 55, 68, 91, -86, -52, 120, -56, -41, 114, 118, 55, 107, 64, -103, -88, 85, 102, -6, -88, 3, 30, -117, 74, 17, 2, 105, -53, 76, -72, 37, 6, 28, -96, 119, -46, -55, -84, -46, 61, -23, 10, 16, -6, 118, 112, -73, -5, -36, 3, -127, -124, 0, 2, -127, -128, 45, 9, -104, 92, -84, -72, -100, -57, -103, 126, -18, 32, 25, 42, 52, -112, -7, -41, -85, -85, -82, -35, 107, 114, -107, 13, 102, -8, -17, 39, -113, 68, -78, -19, 40, 68, -57, -2, -81, -80, -90, 39, 111, 0, 103, 69, -126, 91, 7, -88, 86, 86, 59, -46, 41, 81, 97, 94, 105, 57, -41, 46, 116, 119, 18, -49, 25, 74, -11, 45, -56, -53, 114, 97, -60, 78, 111, -6, 71, 67, 63, 20, -69, -6, -68, 24, 102, 40, -62, -39, 102, -117, 122, 45, 47, -62, 96, -110, 75, 20, -2, 88, 62, 33, 127, 104, 98, -66, 108, 72, 73, -7, -96, 75, 94, -123, -99, 25, 16, -7, 21, 69, 81, 27, 113, -44, -9, 11, -93, 102, 48, 100, 48, 17, 6, 9, 96, -122, 72, 1, -122, -8, 66, 1, 1, 4, 4, 3, 2, 0, 7, 48, 15, 6, 3, 85, 29, 19, 1, 1, -1, 4, 5, 48, 3, 1, 1, -1, 48, 31, 6, 3, 85, 29, 35, 4, 24, 48, 22, -128, 20, 101, -30, -12, -122, -55, -45, 78, -16, -111, 78, 88, -94, 106, -11, -40, 120, 90, -102, -63, -90, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 101, -30, -12, -122, -55, -45, 78, -16, -111, 78, 88, -94, 106, -11, -40, 120, 90, -102, -63, -90, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 3, 47, 0, 48, 44, 2, 20, 36, -97, 2, -61, -5, 49, -43, -111, 59, -7, 126, 86, 111, -106, -33, 100, 10, 4, -104, -76, 2, 20, 110, 121, -124, -89, -18, 104, -93, 2, 114, 49, 99, -37, 67, -85, 8, -20, 77, -17, 22, 58 }, { 48, -126, 3, 79, 48, -126, 3, 13, -96, 3, 2, 1, 2, 2, 4, 57, 36, -91, 85, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 48, 96, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 24, 48, 22, 6, 3, 85, 4, 10, 19, 15, 73, 66, 77, 32, 67, 111, 114, 112, 111, 114, 97, 116, 105, 111, 110, 49, 25, 48, 23, 6, 3, 85, 4, 11, 19, 16, 73, 66, 77, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, 30, 23, 13, 48, 48, 48, 53, 49, 57, 48, 50, 50, 50, 49, 51, 90, 23, 13, 48, 54, 48, 53, 49, 56, 48, 50, 50, 50, 49, 51, 90, 48, 96, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 24, 48, 22, 6, 3, 85, 4, 10, 19, 15, 73, 66, 77, 32, 67, 111, 114, 112, 111, 114, 97, 116, 105, 111, 110, 49, 25, 48, 23, 6, 3, 85, 4, 11, 19, 16, 73, 66, 77, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 49, 28, 48, 26, 6, 3, 85, 4, 3, 19, 19, 74, 67, 69, 32, 67, 111, 100, 101, 32, 83, 105, 103, 110, 105, 110, 103, 32, 67, 65, 48, -126, 1, -72, 48, -126, 1, 44, 6, 7, 42, -122, 72, -50, 56, 4, 1, 48, -126, 1, 31, 2, -127, -127, 0, -3, 127, 83, -127, 29, 117, 18, 41, 82, -33, 74, -100, 46, -20, -28, -25, -10, 17, -73, 82, 60, -17, 68, 0, -61, 30, 63, -128, -74, 81, 38, 105, 69, 93, 64, 34, 81, -5, 89, 61, -115, 88, -6, -65, -59, -11, -70, 48, -10, -53, -101, 85, 108, -41, -127, 59, -128, 29, 52, 111, -14, 102, 96, -73, 107, -103, 80, -91, -92, -97, -97, -24, 4, 123, 16, 34, -62, 79, -69, -87, -41, -2, -73, -58, 27, -8, 59, 87, -25, -58, -88, -90, 21, 15, 4, -5, -125, -10, -45, -59, 30, -61, 2, 53, 84, 19, 90, 22, -111, 50, -10, 117, -13, -82, 43, 97, -41, 42, -17, -14, 34, 3, 25, -99, -47, 72, 1, -57, 2, 21, 0, -105, 96, 80, -113, 21, 35, 11, -52, -78, -110, -71, -126, -94, -21, -124, 11, -16, 88, 28, -11, 2, -127, -127, 0, -9, -31, -96, -123, -42, -101, 61, -34, -53, -68, -85, 92, 54, -72, 87, -71, 121, -108, -81, -69, -6, 58, -22, -126, -7, 87, 76, 11, 61, 7, -126, 103, 81, 89, 87, -114, -70, -44, 89, 79, -26, 113, 7, 16, -127, -128, -76, 73, 22, 113, 35, -24, 76, 40, 22, 19, -73, -49, 9, 50, -116, -56, -90, -31, 60, 22, 122, -117, 84, 124, -115, 40, -32, -93, -82, 30, 43, -77, -90, 117, -111, 110, -93, 127, 11, -6, 33, 53, 98, -15, -5, 98, 122, 1, 36, 59, -52, -92, -15, -66, -88, 81, -112, -119, -88, -125, -33, -31, 90, -27, -97, 6, -110, -117, 102, 94, -128, 123, 85, 37, 100, 1, 76, 59, -2, -49, 73, 42, 3, -127, -123, 0, 2, -127, -127, 0, -22, 107, 0, -57, -33, 16, 59, -71, 116, 53, -89, -31, 109, 102, -126, 77, -9, 91, 86, 113, -62, 38, 69, 39, 114, 61, 81, 16, 98, -1, -77, -36, 16, -55, -5, 81, 19, -44, -83, -117, -88, 37, 110, 93, -55, 120, -46, 91, 39, -45, 19, 65, 71, 20, 6, 124, -53, -126, 56, 94, -58, 11, 97, -96, 76, -125, 45, -108, -52, -116, 46, -124, -112, 58, -113, 66, 10, 105, 82, -45, 116, 38, 119, -92, 20, 125, 42, 113, 65, -120, -119, 119, -90, 45, 98, -102, -95, 88, -104, 109, 108, -49, -50, -88, -22, -70, -35, -24, -95, 16, 68, -116, -124, 66, -63, -72, 31, 43, -76, -68, -77, 93, 116, 96, -128, -115, 66, 84, -93, 83, 48, 81, 48, 31, 6, 3, 85, 29, 35, 4, 24, 48, 22, -128, 20, 126, 61, 77, 77, -52, 16, 89, -70, -7, -82, 66, 61, -27, -55, 87, 90, 82, 11, 126, -121, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 126, 61, 77, 77, -52, 16, 89, -70, -7, -82, 66, 61, -27, -55, 87, 90, 82, 11, 126, -121, 48, 15, 6, 3, 85, 29, 19, 1, 1, -1, 4, 5, 48, 3, 1, 1, -1, 48, 11, 6, 7, 42, -122, 72, -50, 56, 4, 3, 5, 0, 3, 47, 0, 48, 44, 2, 20, 28, -17, -10, -64, 92, -19, -109, 112, 34, -31, 75, -55, 15, -16, -99, 122, 9, -18, -122, -122, 2, 20, 18, 119, 71, 98, -62, -97, 25, 97, -36, 41, -6, -71, 73, -91, 25, -42, -91, -68, 69, 77 } };
        SunJCE_b.i = null;
        j = new byte[][] { SunJCE_b.h[0], SunJCE_b.h[1] };
        SunJCE_b.k = true;
        try {
            AccessController.doPrivileged((PrivilegedExceptionAction<Object>)new SunJCE_b.SunJCE_x());
            SunJCE_b.k = !SunJCE_b.c.implies((Permission)SunJCE_b.b);
        }
        catch (final Exception ex) {
            throw new SecurityException("Cannot set up certs for trusted CAs: " + ex);
        }
    }
}
