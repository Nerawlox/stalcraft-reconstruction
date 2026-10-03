/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;

public class EntityLavaFX
extends EntityFX {
    public float field_70586_a;

    public EntityLavaFX(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70159_w *= (double)0.8f;
        this.field_70181_x *= (double)0.8f;
        this.field_70179_y *= (double)0.8f;
        this.field_70181_x = this.field_70146_Z.nextFloat() * 0.4f + 0.05f;
        this.field_70551_j = 1.0f;
        this.field_70553_i = 1.0f;
        this.field_70552_h = 1.0f;
        this.field_70544_f *= this.field_70146_Z.nextFloat() * 2.0f + 0.2f;
        this.field_70586_a = this.field_70544_f;
        this.field_70547_e = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.field_70145_X = false;
        this.func_70536_a(49);
    }

    @Override
    public int func_70070_b(float f) {
        float f2 = ((float)this.field_70546_d + f) / (float)this.field_70547_e;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        int n = super.func_70070_b(f);
        int n2 = 240;
        int n3 = n >> 16 & 0xFF;
        return n2 | n3 << 16;
    }

    @Override
    public float func_70013_c(float f) {
        return 1.0f;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.field_70546_d + f) / (float)this.field_70547_e;
        this.field_70544_f = this.field_70586_a * (1.0f - f7 * f7);
        super.func_70539_a(htvf2, f, f2, f3, f4, f5, f6);
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
        float f = (float)this.field_70546_d / (float)this.field_70547_e;
        if (this.field_70146_Z.nextFloat() > f) {
            this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y);
        }
        this.field_70181_x -= 0.03;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.999f;
        this.field_70181_x *= (double)0.999f;
        this.field_70179_y *= (double)0.999f;
        if (this.field_70122_E) {
            this.field_70159_w *= (double)0.7f;
            this.field_70179_y *= (double)0.7f;
        }
    }
}

