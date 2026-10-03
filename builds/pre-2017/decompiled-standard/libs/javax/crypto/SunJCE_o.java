/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.Permission;
import java.security.PermissionCollection;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SunJCE_p;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;

class SunJCE_o
extends Permission {
    private String a;
    private String b;
    private int c;
    private AlgorithmParameterSpec d;
    static final String e = "*";

    SunJCE_o(String string) {
        super(string);
        this.a = string;
        this.c = -1;
    }

    SunJCE_o(String string, int n) {
        super(string);
        this.a = string;
        this.c = n;
    }

    SunJCE_o(String string, int n, AlgorithmParameterSpec algorithmParameterSpec) {
        super(string);
        this.a = string;
        this.c = n;
        this.d = algorithmParameterSpec;
    }

    SunJCE_o(String string, String string2) {
        super(string);
        this.a = string;
        this.b = string2;
        this.c = -1;
    }

    SunJCE_o(String string, int n, String string2) {
        super(string);
        this.a = string;
        this.b = string2;
        this.c = n;
    }

    SunJCE_o(String string, int n, AlgorithmParameterSpec algorithmParameterSpec, String string2) {
        super(string);
        this.a = string;
        this.b = string2;
        this.c = n;
        this.d = algorithmParameterSpec;
    }

    public boolean implies(Permission permission) {
        if (permission == null || !(permission instanceof SunJCE_o)) {
            return false;
        }
        SunJCE_o sunJCE_o = (SunJCE_o)permission;
        if (!this.a.equalsIgnoreCase(sunJCE_o.a) && !this.a.equalsIgnoreCase(e)) {
            return false;
        }
        if (this.c == -1 || sunJCE_o.c <= this.c) {
            if (!this.a(sunJCE_o.d)) {
                return false;
            }
            if (this.a(sunJCE_o.b)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SunJCE_o)) {
            return false;
        }
        SunJCE_o sunJCE_o = (SunJCE_o)object;
        if (!this.a.equalsIgnoreCase(sunJCE_o.a) || this.c != sunJCE_o.c) {
            return false;
        }
        return this.a(this.b, sunJCE_o.b) && this.a(this.d, sunJCE_o.d);
    }

    public int hashCode() {
        int n = this.a.hashCode();
        n ^= this.c;
        if (this.b != null) {
            n ^= this.b.hashCode();
        }
        if (this.d != null) {
            n ^= this.d.hashCode();
        }
        return n;
    }

    public String getActions() {
        return null;
    }

    public PermissionCollection newPermissionCollection() {
        return new SunJCE_p();
    }

    String a() {
        return this.a;
    }

    String b() {
        return this.b;
    }

    int c() {
        return this.c;
    }

    AlgorithmParameterSpec d() {
        return this.d;
    }

    public String toString() {
        if (this.b != null) {
            return "(" + this.getClass().getName() + " " + this.a + " " + this.c + " " + this.b + ")";
        }
        return "(" + this.getClass().getName() + " " + this.a + " " + this.c + ")";
    }

    private boolean a(String string) {
        if (this.b == null) {
            return true;
        }
        if (string == null) {
            return false;
        }
        return this.b.equals(string);
    }

    private boolean a(AlgorithmParameterSpec algorithmParameterSpec) {
        if (this.d == null) {
            return true;
        }
        if (algorithmParameterSpec == null) {
            return false;
        }
        if (this.d.getClass() != algorithmParameterSpec.getClass()) {
            return false;
        }
        if (algorithmParameterSpec instanceof RC2ParameterSpec && ((RC2ParameterSpec)algorithmParameterSpec).getEffectiveKeyBits() <= ((RC2ParameterSpec)this.d).getEffectiveKeyBits()) {
            return true;
        }
        if (algorithmParameterSpec instanceof RC5ParameterSpec && ((RC5ParameterSpec)algorithmParameterSpec).getRounds() <= ((RC5ParameterSpec)this.d).getRounds()) {
            return true;
        }
        if (algorithmParameterSpec instanceof PBEParameterSpec && ((PBEParameterSpec)algorithmParameterSpec).getIterationCount() <= ((PBEParameterSpec)this.d).getIterationCount()) {
            return true;
        }
        return this.d.equals(algorithmParameterSpec);
    }

    private boolean a(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }
}

