/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.crypto.SunJCE_j;
import javax.crypto.SunJCE_l;
import javax.crypto.SunJCE_n;
import javax.crypto.SunJCE_o;
import javax.crypto.SunJCE_t;

final class SunJCE_h
extends PermissionCollection
implements Serializable {
    private Hashtable a = new Hashtable(7);
    private PermissionCollection b = null;
    private boolean c = true;

    SunJCE_h() {
    }

    void a(InputStream inputStream) throws IOException, SunJCE_l {
        SunJCE_j sunJCE_j = new SunJCE_j();
        sunJCE_j.a(new BufferedReader(new InputStreamReader(inputStream, "UTF-8")));
        SunJCE_o[] sunJCE_oArray = sunJCE_j.a();
        int n = 0;
        while (n < sunJCE_oArray.length) {
            this.add(sunJCE_oArray[n]);
            ++n;
        }
        this.c = sunJCE_oArray.length <= 0;
    }

    boolean a() {
        return this.c;
    }

    public void add(Permission permission) {
        if (!(permission instanceof SunJCE_o)) {
            return;
        }
        if (this.isReadOnly()) {
            throw new SecurityException("Attempt to add a Permission to a readonly CryptoPermissions object");
        }
        SunJCE_o sunJCE_o = (SunJCE_o)permission;
        PermissionCollection permissionCollection = this.a(sunJCE_o);
        permissionCollection.add(sunJCE_o);
        String string = sunJCE_o.a();
        if (!this.a.containsKey(string)) {
            this.a.put(string, permissionCollection);
        }
        if (sunJCE_o instanceof SunJCE_n) {
            this.b = permissionCollection;
        }
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof SunJCE_o)) {
            throw new IllegalArgumentException("Expect a CryptoPermission object");
        }
        SunJCE_o sunJCE_o = (SunJCE_o)permission;
        PermissionCollection permissionCollection = this.a(sunJCE_o);
        if (this.b != null && this.b.implies(sunJCE_o)) {
            return true;
        }
        return permissionCollection.implies(sunJCE_o);
    }

    public Enumeration elements() {
        return new SunJCE_t(this.a.elements());
    }

    SunJCE_h a(SunJCE_h sunJCE_h) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        if (sunJCE_h == null) {
            return null;
        }
        if (this.a.containsKey("CryptoAllPermission")) {
            return sunJCE_h;
        }
        if (sunJCE_h.a.containsKey("CryptoAllPermission")) {
            return this;
        }
        SunJCE_h sunJCE_h2 = new SunJCE_h();
        PermissionCollection permissionCollection = (PermissionCollection)sunJCE_h.a.get("*");
        int n = 0;
        if (permissionCollection != null) {
            n = ((SunJCE_o)permissionCollection.elements().nextElement()).c();
        }
        Enumeration enumeration = this.a.keys();
        while (enumeration.hasMoreElements()) {
            object4 = (String)enumeration.nextElement();
            object3 = (PermissionCollection)this.a.get(object4);
            object2 = (PermissionCollection)sunJCE_h.a.get(object4);
            if (object2 == null) {
                if (permissionCollection == null) continue;
                object = this.a(n, (PermissionCollection)object3);
            } else {
                object = this.a((PermissionCollection)object3, (PermissionCollection)object2);
            }
            int n2 = 0;
            while (n2 < ((SunJCE_o[])object).length) {
                sunJCE_h2.add(object[n2]);
                ++n2;
            }
        }
        object4 = (PermissionCollection)this.a.get("*");
        if (object4 == null) {
            return sunJCE_h2;
        }
        n = ((SunJCE_o)((PermissionCollection)object4).elements().nextElement()).c();
        object3 = sunJCE_h.a.keys();
        while (object3.hasMoreElements()) {
            object2 = (String)object3.nextElement();
            if (this.a.containsKey(object2)) continue;
            object = (PermissionCollection)sunJCE_h.a.get(object2);
            SunJCE_o[] sunJCE_oArray = this.a(n, (PermissionCollection)object);
            int n3 = 0;
            while (n3 < sunJCE_oArray.length) {
                sunJCE_h2.add(sunJCE_oArray[n3]);
                ++n3;
            }
        }
        return sunJCE_h2;
    }

    SunJCE_o[] a(PermissionCollection permissionCollection, PermissionCollection permissionCollection2) {
        Object[] objectArray;
        Vector<Object> vector = new Vector<Object>(2);
        Enumeration<Permission> enumeration = permissionCollection.elements();
        block0: while (enumeration.hasMoreElements()) {
            objectArray = (SunJCE_o)enumeration.nextElement();
            Enumeration<Permission> enumeration2 = permissionCollection2.elements();
            while (enumeration2.hasMoreElements()) {
                SunJCE_o sunJCE_o = (SunJCE_o)enumeration2.nextElement();
                if (sunJCE_o.implies((Permission)objectArray)) {
                    vector.addElement(objectArray);
                    continue block0;
                }
                if (!objectArray.implies(sunJCE_o)) continue;
                vector.addElement(sunJCE_o);
            }
        }
        objectArray = new SunJCE_o[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    SunJCE_o[] a(int n, PermissionCollection permissionCollection) {
        Object[] objectArray;
        Vector<Object> vector = new Vector<Object>(1);
        Enumeration<Permission> enumeration = permissionCollection.elements();
        while (enumeration.hasMoreElements()) {
            objectArray = (SunJCE_o)enumeration.nextElement();
            if (n == -1 || objectArray.c() <= n) {
                vector.addElement(objectArray);
                continue;
            }
            vector.addElement(new SunJCE_o(objectArray.a(), n, objectArray.d(), objectArray.b()));
        }
        objectArray = new SunJCE_o[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    PermissionCollection a(String string) {
        if (this.a.containsKey("CryptoAllPermission")) {
            return (PermissionCollection)this.a.get("CryptoAllPermission");
        }
        PermissionCollection permissionCollection = (PermissionCollection)this.a.get(string);
        if (permissionCollection == null) {
            permissionCollection = (PermissionCollection)this.a.get("*");
        }
        return permissionCollection;
    }

    private PermissionCollection a(SunJCE_o sunJCE_o) {
        String string = sunJCE_o.a();
        PermissionCollection permissionCollection = (PermissionCollection)this.a.get(string);
        if (permissionCollection == null) {
            Hashtable hashtable = this.a;
            synchronized (hashtable) {
                permissionCollection = (PermissionCollection)this.a.get(string);
                if (permissionCollection == null) {
                    permissionCollection = sunJCE_o.newPermissionCollection();
                }
            }
        }
        return permissionCollection;
    }
}

