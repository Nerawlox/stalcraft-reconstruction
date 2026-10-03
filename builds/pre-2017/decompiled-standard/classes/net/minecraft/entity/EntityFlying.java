/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.sajh;

public abstract class EntityFlying
extends EntityLiving {
    public EntityFlying(ozlu ozlu2) {
        super(ozlu2);
    }

    @Override
    public void func_70069_a(float f) {
    }

    @Override
    public void func_70064_a(double d, boolean bl) {
    }

    @Override
    public void func_70612_e(float f, float f2) {
        if (this.func_70090_H()) {
            this.func_70060_a(f, f2, 0.02f);
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)0.8f;
            this.field_70181_x *= (double)0.8f;
            this.field_70179_y *= (double)0.8f;
        } else if (this.func_70058_J()) {
            this.func_70060_a(f, f2, 0.02f);
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= 0.5;
            this.field_70181_x *= 0.5;
            this.field_70179_y *= 0.5;
        } else {
            float f3 = 0.91f;
            if (this.field_70122_E) {
                f3 = 0.54600006f;
                int n = this.field_70170_p.func_72798_a(sajh._c(this.field_70165_t), sajh._c(this.field_70121_D._c) - 1, sajh._c(this.field_70161_v));
                if (n > 0) {
                    f3 = twgu.field_71973_m[n].field_72016_cq * 0.91f;
                }
            }
            float f4 = 0.16277136f / (f3 * f3 * f3);
            this.func_70060_a(f, f2, this.field_70122_E ? 0.1f * f4 : 0.02f);
            f3 = 0.91f;
            if (this.field_70122_E) {
                f3 = 0.54600006f;
                int n = this.field_70170_p.func_72798_a(sajh._c(this.field_70165_t), sajh._c(this.field_70121_D._c) - 1, sajh._c(this.field_70161_v));
                if (n > 0) {
                    f3 = twgu.field_71973_m[n].field_72016_cq * 0.91f;
                }
            }
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)f3;
            this.field_70181_x *= (double)f3;
            this.field_70179_y *= (double)f3;
        }
        this.field_70722_aY = this.field_70721_aZ;
        double d = this.field_70165_t - this.field_70169_q;
        double d2 = this.field_70161_v - this.field_70166_s;
        float f5 = sajh._a(d * d + d2 * d2) * 4.0f;
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        this.field_70721_aZ += (f5 - this.field_70721_aZ) * 0.4f;
        this.field_70754_ba += this.field_70721_aZ;
    }

    @Override
    public boolean func_70617_f_() {
        return false;
    }
}

