/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.amxi;

public class pibn {
    public final int _a;
    public Object _b;
    public pibn _c;
    public final int _d;

    public pibn(int n, int n2, Object object, pibn pibn2) {
        this._b = object;
        this._c = pibn2;
        this._a = n2;
        this._d = n;
    }

    public final int _a() {
        return this._a;
    }

    public final Object _b() {
        return this._b;
    }

    public final boolean equals(Object object) {
        Object object2;
        Object object3;
        Integer n;
        if (!(object instanceof pibn)) {
            return false;
        }
        pibn pibn2 = (pibn)object;
        Integer n2 = this._a();
        return (n2 == (n = Integer.valueOf(pibn2._a())) || n2 != null && ((Object)n2).equals(n)) && ((object3 = this._b()) == (object2 = pibn2._b()) || object3 != null && object3.equals(object2));
    }

    public final int hashCode() {
        return amxi._h(this._a);
    }

    public final String toString() {
        return this._a() + "=" + this._b();
    }
}

