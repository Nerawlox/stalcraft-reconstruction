/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.amww;
import net.minecraft.util.ofbx;

public class hank {
    public amww _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public ofbx _h;
    public Entity _i;
    public int _j = -1;
    public Object _k = null;

    public hank(int n, int n2, int n3, int n4, ofbx ofbx2) {
        this._c = amww._a;
        this._d = n;
        this._e = n2;
        this._f = n3;
        this._g = n4;
        this._h = ofbx2._b._a(ofbx2._c, ofbx2._d, ofbx2._e);
    }

    public hank(Entity entity) {
        this._c = amww._b;
        this._i = entity;
        this._h = entity.field_70170_p.func_82732_R()._a(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
    }
}

