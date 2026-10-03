/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.Serializable;
import java.net.URL;
import java.security.AccessController;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.crypto.ExemptionMechanism;
import javax.crypto.SunJCE_b;
import javax.crypto.SunJCE_d;
import javax.crypto.SunJCE_h;
import javax.crypto.SunJCE_i;
import javax.crypto.SunJCE_n;
import javax.crypto.SunJCE_o;

final class SunJCE_g
extends SecurityManager {
    private static final String a = "cryptoPerms";
    private static final SunJCE_h b;
    private static final SunJCE_h c;
    private static final SunJCE_n d;
    private static final Vector e;
    static /* synthetic */ Class f;

    SunJCE_g() {
    }

    SunJCE_o a(String string) {
        Serializable serializable;
        Object object;
        SunJCE_o sunJCE_o = this.b(string);
        if (sunJCE_o instanceof SunJCE_n) {
            return sunJCE_o;
        }
        URL uRL = SunJCE_g.a(f == null ? (f = SunJCE_g.class$("javax.crypto.Cipher")) : f);
        Class<?>[] classArray = this.getClassContext();
        URL uRL2 = null;
        int n = 0;
        while (n < classArray.length) {
            object = classArray[n];
            uRL2 = SunJCE_g.a(classArray[n]);
            if (!uRL.equals(uRL2)) break;
            ++n;
        }
        if (n == classArray.length) {
            return sunJCE_o;
        }
        object = new SunJCE_d(uRL2);
        try {
            ((SunJCE_d)object).verify(SunJCE_b.l);
        }
        catch (Exception exception) {
            try {
                ((SunJCE_d)object).verify(SunJCE_b.g);
            }
            catch (Exception exception2) {
                return sunJCE_o;
            }
        }
        JarFile jarFile = ((SunJCE_d)object).getJarFile();
        JarEntry jarEntry = jarFile.getJarEntry(a);
        if (jarEntry == null) {
            return sunJCE_o;
        }
        SunJCE_h sunJCE_h = new SunJCE_h();
        try {
            sunJCE_h.a(jarFile.getInputStream(jarEntry));
        }
        catch (Exception exception) {
            return sunJCE_o;
        }
        if (sunJCE_h.implies(d)) {
            return d;
        }
        PermissionCollection permissionCollection = sunJCE_h.a(string);
        if (permissionCollection == null) {
            return sunJCE_o;
        }
        Enumeration<Permission> enumeration = permissionCollection.elements();
        while (enumeration.hasMoreElements()) {
            serializable = (SunJCE_o)enumeration.nextElement();
            if (((SunJCE_o)serializable).b() != null) continue;
            return serializable;
        }
        serializable = c.a(string);
        if (serializable == null) {
            return sunJCE_o;
        }
        enumeration = ((PermissionCollection)serializable).elements();
        while (enumeration.hasMoreElements()) {
            SunJCE_o sunJCE_o2 = (SunJCE_o)enumeration.nextElement();
            try {
                SunJCE_o sunJCE_o3;
                ExemptionMechanism.getInstance(sunJCE_o2.b());
                if (sunJCE_o2.a().equals("*") && sunJCE_h.implies(sunJCE_o3 = new SunJCE_o(string, sunJCE_o2.c(), sunJCE_o2.d(), sunJCE_o2.b()))) {
                    return sunJCE_o3;
                }
                if (!sunJCE_h.implies(sunJCE_o2)) continue;
                return sunJCE_o2;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return sunJCE_o;
    }

    private static URL a(Class clazz) {
        return (URL)AccessController.doPrivileged(new SunJCE_i(clazz));
    }

    private SunJCE_o b(String string) {
        Enumeration<Permission> enumeration = b.a(string).elements();
        return (SunJCE_o)enumeration.nextElement();
    }

    boolean a() {
        Object object;
        URL uRL = SunJCE_g.a(f == null ? (f = SunJCE_g.class$("javax.crypto.Cipher")) : f);
        Class<?>[] classArray = this.getClassContext();
        URL uRL2 = null;
        int n = 0;
        while (n < classArray.length) {
            object = classArray[n];
            uRL2 = SunJCE_g.a(classArray[n]);
            if (!uRL.equals(uRL2)) break;
            ++n;
        }
        if (n == classArray.length) {
            return true;
        }
        if (e.contains(classArray[n])) {
            return true;
        }
        object = new SunJCE_d(uRL2);
        try {
            ((SunJCE_d)object).verify(SunJCE_b.g);
        }
        catch (Exception exception) {
            return false;
        }
        e.addElement(classArray[n]);
        return true;
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
        e = new Vector(2);
        b = SunJCE_b.a();
        c = SunJCE_b.b();
        d = new SunJCE_n();
    }
}

