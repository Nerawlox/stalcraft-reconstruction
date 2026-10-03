/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;

public class zwat {
    public EntityLivingBase _a;
    public int _b;
    public float _c;

    public zwat(EntityLivingBase entityLivingBase) {
        this._a = entityLivingBase;
    }

    public void _a() {
        double d = this._a.field_70165_t - this._a.field_70169_q;
        double d2 = this._a.field_70161_v - this._a.field_70166_s;
        if (d * d + d2 * d2 > 2.500000277905201E-7) {
            this._a.field_70761_aq = this._a.field_70177_z;
            this._c = this._a.field_70759_as = this._a(this._a.field_70761_aq, this._a.field_70759_as, 75.0f);
            this._b = 0;
            return;
        }
        float f = 75.0f;
        if (Math.abs(this._a.field_70759_as - this._c) > 15.0f) {
            this._b = 0;
            this._c = this._a.field_70759_as;
        } else {
            ++this._b;
            int n = 10;
            if (this._b > 10) {
                f = Math.max(1.0f - (float)(this._b - 10) / 10.0f, 0.0f) * 75.0f;
            }
        }
        this._a.field_70761_aq = this._a(this._a.field_70759_as, this._a.field_70761_aq, f);
    }

    public float _a(float f, float f2, float f3) {
        float f4 = sajh._g(f - f2);
        if (f4 < -f3) {
            f4 = -f3;
        }
        if (f4 >= f3) {
            f4 = f3;
        }
        return f - f4;
    }
}

