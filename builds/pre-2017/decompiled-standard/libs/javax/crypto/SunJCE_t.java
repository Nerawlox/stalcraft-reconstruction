/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.NoSuchElementException;

final class SunJCE_t
implements Enumeration {
    private Enumeration a;
    private Enumeration b;

    SunJCE_t(Enumeration enumeration) {
        this.a = enumeration;
        this.b = this.a();
    }

    public synchronized boolean hasMoreElements() {
        if (this.b == null) {
            return false;
        }
        if (this.b.hasMoreElements()) {
            return true;
        }
        this.b = this.a();
        return this.b != null;
    }

    public synchronized Object nextElement() {
        if (this.hasMoreElements()) {
            return this.b.nextElement();
        }
        throw new NoSuchElementException("PermissionsEnumerator");
    }

    private Enumeration a() {
        while (this.a.hasMoreElements()) {
            PermissionCollection permissionCollection = (PermissionCollection)this.a.nextElement();
            Enumeration<Permission> enumeration = permissionCollection.elements();
            if (!enumeration.hasMoreElements()) continue;
            return enumeration;
        }
        return null;
    }
}

