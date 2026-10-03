/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.Serializable;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;
import javax.crypto.SunJCE_o;

final class SunJCE_p
extends PermissionCollection
implements Serializable {
    private Vector a = new Vector(3);

    SunJCE_p() {
    }

    public void add(Permission permission) {
        if (!(permission instanceof SunJCE_o)) {
            return;
        }
        if (this.isReadOnly()) {
            throw new SecurityException("attempt to add a Permission to a readonly PermissionCollection");
        }
        this.a.addElement(permission);
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof SunJCE_o)) {
            return false;
        }
        SunJCE_o sunJCE_o = (SunJCE_o)permission;
        Enumeration enumeration = this.a.elements();
        while (enumeration.hasMoreElements()) {
            SunJCE_o sunJCE_o2 = (SunJCE_o)enumeration.nextElement();
            if (!sunJCE_o2.implies(sunJCE_o)) continue;
            return true;
        }
        return false;
    }

    public Enumeration elements() {
        return this.a.elements();
    }
}

