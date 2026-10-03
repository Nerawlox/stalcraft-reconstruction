/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.pibk;

public class pzdf {
    public final long _a;
    public Object _b;
    public pzdf _c;
    public final int _d;

    public pzdf(int n, long l, Object object, pzdf pzdf2) {
        this._b = object;
        this._c = pzdf2;
        this._a = l;
        this._d = n;
    }

    public final long _a() {
        return this._a;
    }

    public final Object _b() {
        return this._b;
    }

    public final boolean equals(Object object) {
        Object object2;
        Object object3;
        Long l;
        if (!(object instanceof pzdf)) {
            return false;
        }
        pzdf pzdf2 = (pzdf)object;
        Long l2 = this._a();
        return (l2 == (l = Long.valueOf(pzdf2._a())) || l2 != null && ((Object)l2).equals(l)) && ((object3 = this._b()) == (object2 = pzdf2._b()) || object3 != null && object3.equals(object2));
    }

    public final int hashCode() {
        return pibk._g(this._a);
    }

    public final String toString() {
        return this._a() + "=" + this._b();
    }
}

