/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_y;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.NoSuchProviderException;
import java.security.PrivilegedActionException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Set;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarException;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

class SunJCE_x {
    private static boolean a = false;
    private Vector b = null;
    private URL c;
    private JarFile d;
    private boolean e;

    SunJCE_x(URL uRL) {
        this.c = uRL;
        this.e = false;
    }

    public void a(X509Certificate[] x509CertificateArray) throws JarException, IOException {
        this.b = new Vector(2);
        try {
            try {
                this.a(this.c, null, x509CertificateArray);
            }
            catch (NoSuchProviderException noSuchProviderException) {
                throw new JarException("Cannot verify " + this.c.toString());
            }
            catch (CertificateException certificateException) {
                throw new JarException("Cannot verify " + this.c.toString());
            }
            Object var5_2 = null;
            this.b = null;
        }
        catch (Throwable throwable) {
            Object var5_3 = null;
            this.b = null;
            throw throwable;
        }
    }

    public JarFile a() {
        this.e = true;
        return this.d;
    }

    private void a(URL uRL, Vector vector, X509Certificate[] x509CertificateArray) throws NoSuchProviderException, CertificateException, IOException {
        String string = uRL.toString();
        if (vector == null || !vector.contains(string)) {
            String string2 = this.a(uRL, x509CertificateArray);
            if (vector != null) {
                vector.addElement(string);
            }
            if (string2 != null) {
                if (vector == null) {
                    vector = new Vector<String>();
                    vector.addElement(string);
                }
                this.a(uRL, string2, vector, x509CertificateArray);
            }
        }
    }

    private void a(URL uRL, String string, Vector vector, X509Certificate[] x509CertificateArray) throws NoSuchProviderException, CertificateException, IOException {
        String[] stringArray = this.a(string);
        try {
            int n = 0;
            while (n < stringArray.length) {
                URL uRL2 = new URL(uRL, stringArray[n]);
                this.a(uRL2, vector, x509CertificateArray);
                ++n;
            }
        }
        catch (MalformedURLException malformedURLException) {
            MalformedURLException malformedURLException2 = new MalformedURLException("The JAR file " + uRL.toString() + " contains invalid URLs in its Class-Path attribute: " + malformedURLException);
            throw malformedURLException2;
        }
    }

    private String a(URL uRL, X509Certificate[] x509CertificateArray) throws NoSuchProviderException, CertificateException, IOException {
        URL uRL2 = uRL.getProtocol().equalsIgnoreCase("jar") ? uRL : new URL("jar:" + uRL.toString() + "!/");
        JarFile jarFile = null;
        boolean bl = true;
        try {
            Object object;
            Cloneable cloneable2;
            try {
                jarFile = (JarFile)AccessController.doPrivileged(new SunJCE_y(this, uRL2));
            }
            catch (PrivilegedActionException privilegedActionException) {
                SecurityException securityException = new SecurityException("Cannot verify " + uRL2.toString() + ": " + privilegedActionException);
                throw securityException;
            }
            byte[] byArray = new byte[8192];
            Vector<JarEntry> vector = new Vector<JarEntry>();
            Enumeration<JarEntry> enumeration = jarFile.entries();
            while (enumeration.hasMoreElements()) {
                int n;
                cloneable2 = enumeration.nextElement();
                vector.addElement((JarEntry)cloneable2);
                object = jarFile.getInputStream((ZipEntry)cloneable2);
                while ((n = ((InputStream)object).read(byArray, 0, byArray.length)) != -1) {
                }
                ((InputStream)object).close();
            }
            if (this.c.equals(uRL)) {
                this.d = jarFile;
            } else {
                bl = false;
            }
            cloneable2 = jarFile.getManifest();
            if (cloneable2 == null) {
                throw new JarException(uRL.toString() + " is not signed.");
            }
            object = jarFile.entries();
            while (object.hasMoreElements()) {
                X509Certificate[] x509CertificateArray2;
                JarEntry jarEntry = (JarEntry)object.nextElement();
                if (jarEntry.isDirectory()) continue;
                Certificate[] certificateArray = jarEntry.getCertificates();
                if (certificateArray == null || certificateArray.length == 0) {
                    if (jarEntry.getName().startsWith("META-INF")) continue;
                    throw new JarException(uRL.toString() + " has unsigned entries - " + jarEntry.getName());
                }
                int n = 0;
                boolean bl2 = false;
                while ((x509CertificateArray2 = this.a(certificateArray, n)) != null) {
                    if (this.b.contains(x509CertificateArray2[0])) {
                        bl2 = true;
                        break;
                    }
                    if (this.a(x509CertificateArray2, x509CertificateArray)) {
                        bl2 = true;
                        this.b.addElement(x509CertificateArray2[0]);
                        break;
                    }
                    n += x509CertificateArray2.length;
                }
                if (bl2) continue;
                throw new JarException(uRL.toString() + " is not signed by a" + " trusted signer.");
            }
            String string = ((Manifest)cloneable2).getMainAttributes().getValue(Attributes.Name.CLASS_PATH);
            Object var17_20 = null;
            return string;
        }
        catch (Throwable throwable) {
            Object var17_21 = null;
            throw throwable;
        }
    }

    private String[] a(String string) throws JarException {
        string = string.trim();
        int n = string.indexOf(32);
        String string2 = null;
        Vector<String> vector = new Vector<String>();
        boolean bl = false;
        do {
            if (n > 0) {
                string2 = string.substring(0, n);
                string = string.substring(n + 1).trim();
                n = string.indexOf(32);
            } else {
                string2 = string;
                bl = true;
            }
            if (!string2.endsWith(".jar")) {
                throw new JarException("The provider contains un-verifiable components");
            }
            vector.addElement(string2);
        } while (!bl);
        Object[] objectArray = new String[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    private boolean a(X509Certificate[] x509CertificateArray, X509Certificate[] x509CertificateArray2) {
        Serializable serializable;
        int n = 0;
        while (n < x509CertificateArray.length) {
            X509Certificate x509Certificate = x509CertificateArray[n];
            try {
                this.a(x509Certificate, n);
            }
            catch (Exception exception) {
                if (a) {
                    exception.printStackTrace();
                }
                return false;
            }
            ++n;
        }
        int n2 = 0;
        while (n2 < x509CertificateArray.length - 1) {
            serializable = x509CertificateArray[n2 + 1].getPublicKey();
            X509Certificate x509Certificate = x509CertificateArray[n2];
            try {
                x509Certificate.verify((PublicKey)serializable);
            }
            catch (Exception exception) {
                return false;
            }
            ++n2;
        }
        serializable = x509CertificateArray[x509CertificateArray.length - 1];
        int n3 = 0;
        while (n3 < x509CertificateArray2.length) {
            if (x509CertificateArray2[n3].getSubjectDN().equals(((X509Certificate)serializable).getSubjectDN()) && x509CertificateArray2[n3].equals(serializable)) {
                return true;
            }
            ++n3;
        }
        int n4 = 0;
        while (n4 < x509CertificateArray2.length) {
            if (x509CertificateArray2[n4].getSubjectDN().equals(((X509Certificate)serializable).getIssuerDN())) {
                try {
                    ((Certificate)serializable).verify(x509CertificateArray2[n4].getPublicKey());
                    return true;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            ++n4;
        }
        return false;
    }

    private void a(X509Certificate x509Certificate, int n) throws Exception {
        Set<String> set = x509Certificate.getCriticalExtensionOIDs();
        if (set == null || set.size() == 0) {
            return;
        }
        this.a(x509Certificate, set, n);
    }

    private void a(X509Certificate x509Certificate, Set set, int n) throws Exception {
        int n2;
        if (set != null && !set.isEmpty() && set.contains(new String("2.5.29.19")) && (n2 = x509Certificate.getBasicConstraints()) >= 0 && n > 0 && n - 1 > n2) {
            throw new Exception("Violated basic constraints");
        }
    }

    private X509Certificate[] a(Certificate[] certificateArray, int n) {
        if (n > certificateArray.length - 1) {
            return null;
        }
        int n2 = n;
        while (n2 < certificateArray.length - 1) {
            if (!((X509Certificate)certificateArray[n2 + 1]).getSubjectDN().equals(((X509Certificate)certificateArray[n2]).getIssuerDN())) break;
            ++n2;
        }
        int n3 = n2 - n + 1;
        X509Certificate[] x509CertificateArray = new X509Certificate[n3];
        int n4 = 0;
        while (n4 < n3) {
            x509CertificateArray[n4] = (X509Certificate)certificateArray[n + n4];
            ++n4;
        }
        return x509CertificateArray;
    }

    protected void finalize() throws Throwable {
    }
}

