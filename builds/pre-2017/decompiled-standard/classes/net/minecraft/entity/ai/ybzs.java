/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityOcelot;

public class ybzs
extends zwat {
    public final EntityOcelot _a;
    public final double _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;

    public ybzs(EntityOcelot entityOcelot, double d) {
        this._a = entityOcelot;
        this._b = d;
        this.func_75248_a(5);
    }

    @Override
    public boolean func_75250_a() {
        return this._a.func_70909_n() && !this._a.func_70906_o() && this._a.func_70681_au().nextDouble() <= (double)0.0065f && this._a();
    }

    @Override
    public boolean func_75253_b() {
        return this._c <= this._e && this._d <= 60 && this._a(this._a.field_70170_p, this._f, this._g, this._h);
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._a((double)this._f + 0.5, this._g + 1, (double)this._h + 0.5, this._b);
        this._c = 0;
        this._d = 0;
        this._e = this._a.func_70681_au().nextInt(this._a.func_70681_au().nextInt(1200) + 1200) + 1200;
        this._a.func_70907_r()._a(false);
    }

    @Override
    public void func_75251_c() {
        this._a.func_70904_g(false);
    }

    @Override
    public void func_75246_d() {
        ++this._c;
        this._a.func_70907_r()._a(false);
        if (this._a.func_70092_e(this._f, this._g + 1, this._h) > 1.0) {
            this._a.func_70904_g(false);
            this._a.func_70661_as()._a((double)this._f + 0.5, this._g + 1, (double)this._h + 0.5, this._b);
            ++this._d;
        } else if (!this._a.func_70906_o()) {
            this._a.func_70904_g(true);
        } else {
            --this._d;
        }
    }

    public boolean _a() {
        int n = (int)this._a.field_70163_u;
        double d = 2.147483647E9;
        int n2 = (int)this._a.field_70165_t - 8;
        while ((double)n2 < this._a.field_70165_t + 8.0) {
            int n3 = (int)this._a.field_70161_v - 8;
            while ((double)n3 < this._a.field_70161_v + 8.0) {
                double d2;
                if (this._a(this._a.field_70170_p, n2, n, n3) && this._a.field_70170_p.func_72799_c(n2, n + 1, n3) && (d2 = this._a.func_70092_e(n2, n, n3)) < d) {
                    this._f = n2;
                    this._g = n;
                    this._h = n3;
                    d = d2;
                }
                ++n3;
            }
            ++n2;
        }
        return d < 2.147483647E9;
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        if (n4 == twgu.field_72077_au.field_71990_ca) {
            yfav yfav2 = (yfav)ozlu2.func_72796_p(n, n2, n3);
            if (yfav2._i < 1) {
                return true;
            }
        } else {
            if (n4 == twgu.field_72052_aC.field_71990_ca) {
                return true;
            }
            if (n4 == twgu.field_71959_S.field_71990_ca && !gqbt._a(n5)) {
                return true;
            }
        }
        return false;
    }
}

