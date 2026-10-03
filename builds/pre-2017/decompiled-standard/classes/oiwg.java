/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;

public class oiwg
extends cfum {
    public static final int _a = 0;
    public static final int _b = 1;
    protected Entity _c;
    protected Entity _d;
    protected double _e;
    protected double _j;
    protected double _k;
    protected double _l = -1.0;
    protected boolean _m = false;
    protected eidj _n;
    protected int _o = 0;

    public static oiwg _a() {
        return new oiwg();
    }

    public oiwg _a(boolean bl) {
        this._m = bl;
        return this;
    }

    public boolean _b() {
        return this._m;
    }

    public oiwg _a(Entity entity) {
        this._d = entity;
        return this;
    }

    public oiwg _a(double d, double d2, double d3) {
        this._e = d;
        this._j = d2;
        this._k = d3;
        return this;
    }

    public eidj _c() {
        return this._n;
    }

    public int _d() {
        return this._o;
    }

    public oiwg _a(double d) {
        this._l = d;
        return this;
    }

    public oiwg _b(double d, double d2, double d3) {
        return this._a(eidj._a(this._e, this._j, this._k, this._e + d, this._j + d2, this._k + d3));
    }

    public oiwg _a(double d, double d2, double d3, double d4, double d5, double d6) {
        return this._a(eidj._a(d, d2, d3, d + d4, d2 + d5, d3 + d6));
    }

    public oiwg _a(eidj eidj2) {
        this._n = eidj2;
        this._o = 1;
        return this;
    }

    public double _e() {
        return this._l;
    }

    public ofbx _i() {
        double d = this._e;
        double d2 = this._j;
        double d3 = this._k;
        if (this._d != null) {
            d += this._d.field_70165_t;
            d2 += this._d.field_70163_u;
            d3 += this._d.field_70161_v;
        }
        return ofbx._a(d, d2, d3);
    }

    protected Entity _j() {
        return this._c != null ? this._c : this._f;
    }

    @Override
    public ywts _a(dzyj dzyj2) {
        this._i = new hebv.kjui(dzyj2){

            @Override
            public void _b(Entity entity) {
                double d;
                if (oiwg.this._n != null) {
                    if (oiwg.this._n._b(entity.field_70121_D)) {
                        oiwg.this._a(oiwg.this, this);
                    }
                    return;
                }
                double d2 = oiwg.this._e;
                double d3 = oiwg.this._j;
                double d4 = oiwg.this._k;
                if (oiwg.this._d != null) {
                    d = oiwg.this._d.field_70177_z;
                    double d5 = Math.sin(Math.toRadians(d - 90.0));
                    double d6 = Math.cos(Math.toRadians(d - 90.0));
                    d2 = oiwg.this._d.field_70165_t + (oiwg.this._e * d6 - oiwg.this._k * d5);
                    d3 = oiwg.this._d.field_70163_u + oiwg.this._j;
                    d4 = oiwg.this._d.field_70161_v + (oiwg.this._e * d5 + oiwg.this._k * d6);
                }
                if (oiwg.this._l != -1.0) {
                    d = entity.func_70011_f(d2, d3 + 1.0, d4);
                    if (d <= oiwg.this._l) {
                        oiwg.this._a(oiwg.this, this);
                    }
                } else if (entity.field_70121_D._b(0.0, 0.2, 0.0)._a(ofbx._a(d2, d3, d4))) {
                    oiwg.this._a(oiwg.this, this);
                }
            }

            @Override
            public void _a(hank hank2) {
            }

            @Override
            public void _a(Entity entity) {
            }
        };
        return this._i;
    }
}

