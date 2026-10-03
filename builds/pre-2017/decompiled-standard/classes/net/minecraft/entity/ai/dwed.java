/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;

public class dwed {
    public EntityLiving _a;
    public float _b;
    public float _c;
    public boolean _d;
    public double _e;
    public double _f;
    public double _g;

    public dwed(EntityLiving entityLiving) {
        this._a = entityLiving;
    }

    public void _a(Entity entity, float f, float f2) {
        this._e = entity.field_70165_t;
        this._f = entity instanceof EntityLivingBase ? entity.field_70163_u + (double)entity.func_70047_e() : (entity.field_70121_D._c + entity.field_70121_D._f) / 2.0;
        this._g = entity.field_70161_v;
        this._b = f;
        this._c = f2;
        this._d = true;
    }

    public void _a(double d, double d2, double d3, float f, float f2) {
        this._e = d;
        this._f = d2;
        this._g = d3;
        this._b = f;
        this._c = f2;
        this._d = true;
    }

    public void _a() {
        this._a.field_70125_A = 0.0f;
        if (this._d) {
            this._d = false;
            double d = this._e - this._a.field_70165_t;
            double d2 = this._f - (this._a.field_70163_u + (double)this._a.func_70047_e());
            double d3 = this._g - this._a.field_70161_v;
            double d4 = sajh._a(d * d + d3 * d3);
            float f = (float)(Math.atan2(d3, d) * 180.0 / 3.1415927410125732) - 90.0f;
            float f2 = (float)(-(Math.atan2(d2, d4) * 180.0 / 3.1415927410125732));
            this._a.field_70125_A = this._a(this._a.field_70125_A, f2, this._c);
            this._a.field_70759_as = this._a(this._a.field_70759_as, f, this._b);
        } else {
            this._a.field_70759_as = this._a(this._a.field_70759_as, this._a.field_70761_aq, 10.0f);
        }
        float f = sajh._g(this._a.field_70759_as - this._a.field_70761_aq);
        if (!this._a.func_70661_as()._g()) {
            if (f < -75.0f) {
                this._a.field_70759_as = this._a.field_70761_aq - 75.0f;
            }
            if (f > 75.0f) {
                this._a.field_70759_as = this._a.field_70761_aq + 75.0f;
            }
        }
    }

    public float _a(float f, float f2, float f3) {
        float f4 = sajh._g(f2 - f);
        if (f4 > f3) {
            f4 = f3;
        }
        if (f4 < -f3) {
            f4 = -f3;
        }
        return f + f4;
    }
}

