/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.Permission;
import java.security.PermissionCollection;
import javax.crypto.SunJCE_o;
import javax.crypto.SunJCE_u;

final class SunJCE_n
extends SunJCE_o {
    static final String a = "CryptoAllPermission";

    SunJCE_n() {
        super(a);
    }

    public boolean implies(Permission permission) {
        return permission instanceof SunJCE_o;
    }

    public boolean equals(Object object) {
        return object instanceof SunJCE_n;
    }

    public int hashCode() {
        return 1;
    }

    public PermissionCollection newPermissionCollection() {
        return new SunJCE_u();
    }
}

