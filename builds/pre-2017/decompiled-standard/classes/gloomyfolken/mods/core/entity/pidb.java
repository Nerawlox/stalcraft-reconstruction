/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import gloomyfolken.mods.core.entity.jgro;
import gloomyfolken.mods.core.entity.tupg;
import gloomyfolken.mods.core.entity.zwaw;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.sajh;

public class pidb<T extends Entity & jgro>
extends zwat {
    private T _a;
    private tupg _b;
    private EntityLivingBase _c;
    private float _d;
    private float _e;
    private float _f;
    private float _g;
    private float _h;

    public pidb(T t, float f, float f2, float f3, float f4, float f5) {
        this._a = t;
        this.func_75248_a(3);
        this._d = f;
        this._e = f2;
        this._f = f3;
        this._g = f4;
        this._h = f5;
        if (t instanceof tupg) {
            this._b = (tupg)t;
        }
    }

    @Override
    public boolean func_75250_a() {
        return true;
    }

    @Override
    public boolean func_75253_b() {
        EntityLivingBase entityLivingBase = ((zwaw)this._a)._a();
        return true;
    }

    @Override
    public void func_75251_c() {
        this._c = null;
    }

    @Override
    public void func_75246_d() {
        this._c = ((zwaw)this._a)._a();
        if (this._c != null && !this._c.field_70128_L && this._c.func_110143_aJ() > 0.0f) {
            double d = ((Entity)this._a).func_70092_e(this._c.field_70165_t, this._c.field_70121_D._c, this._c.field_70161_v);
            boolean bl = ((zwaw)this._a)._a((Entity)this._c);
            if (this._b != null) {
                if (!bl || d > (double)(this._e * this._e)) {
                    if (this._b._a()._d() == null || Math.random() < 0.2) {
                        this._b._a()._a(this._c, (double)this._d);
                    }
                } else {
                    this._b._a()._h();
                }
            }
            double d2 = this._c.field_70165_t - ((Entity)this._a).field_70165_t;
            double d3 = this._c.field_70163_u + (double)this._c.func_70047_e() - (((Entity)this._a).field_70163_u + (double)((Entity)this._a).func_70047_e());
            double d4 = this._c.field_70161_v - ((Entity)this._a).field_70161_v;
            double d5 = sajh._a(d2 * d2 + d4 * d4);
            float f = (float)(Math.atan2(d4, d2) * 180.0 / Math.PI) - 90.0f;
            float f2 = (float)(-(Math.atan2(d3, d5) * 180.0 / Math.PI));
            if (f2 < this._g || f2 > this._h) {
                return;
            }
            ((zwaw)this._a)._a(this._c, this._f, 90.0f);
            float f3 = Math.abs(f - ((zwaw)this._a)._b()) % 360.0f;
            float f4 = Math.abs(f2 - ((Entity)this._a).field_70125_A) % 360.0f;
            if (f3 > 180.0f) {
                f3 = 360.0f - f3;
            }
            if (f4 > 180.0f) {
                f4 = 360.0f - f4;
            }
            if (((jgro)this._a)._c() && f3 < 5.0f && f4 < 5.0f && ((jgro)this._a)._b() >= 0 && bl) {
                ((jgro)this._a)._a();
            }
        }
    }
}

