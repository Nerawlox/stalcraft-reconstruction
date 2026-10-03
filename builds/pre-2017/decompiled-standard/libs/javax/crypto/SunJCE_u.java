/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.Serializable;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import javax.crypto.SunJCE_n;
import javax.crypto.SunJCE_o;
import javax.crypto.SunJCE_v;

final class SunJCE_u
extends PermissionCollection
implements Serializable {
    private boolean a = false;

    SunJCE_u() {
    }

    public void add(Permission permission) {
        if (!(permission instanceof SunJCE_n)) {
            return;
        }
        if (this.isReadOnly()) {
            throw new SecurityException("attempt to add a Permission to a readonly PermissionCollection");
        }
        this.a = true;
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof SunJCE_o)) {
            return false;
        }
        return this.a;
    }

    public Enumeration elements() {
        return new SunJCE_v(this);
    }

    static /* synthetic */ boolean a(SunJCE_u sunJCE_u) {
        return sunJCE_u.a;
    }
}

