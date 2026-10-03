/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;

public class EntityPortalFX
extends EntityFX {
    public float field_70571_a;
    public double field_70574_aq;
    public double field_70573_ar;
    public double field_70572_as;

    public EntityPortalFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3, d4, d5, d6);
        this.field_70159_w = d4;
        this.field_70181_x = d5;
        this.field_70179_y = d6;
        this.field_70574_aq = this.field_70165_t = d;
        this.field_70573_ar = this.field_70163_u = d2;
        this.field_70572_as = this.field_70161_v = d3;
        float f = this.field_70146_Z.nextFloat() * 0.6f + 0.4f;
        this.field_70571_a = this.field_70544_f = this.field_70146_Z.nextFloat() * 0.2f + 0.5f;
        this.field_70553_i = this.field_70551_j = 1.0f * f;
        this.field_70552_h = this.field_70551_j;
        this.field_70553_i *= 0.3f;
        this.field_70552_h *= 0.9f;
        this.field_70547_e = (int)(Math.random() * 10.0) + 40;
        this.field_70145_X = true;
        this.func_70536_a((int)(Math.random() * 8.0));
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.field_70546_d + f) / (float)this.field_70547_e;
        f7 = 1.0f - f7;
        f7 *= f7;
        f7 = 1.0f - f7;
        this.field_70544_f = this.field_70571_a * f7;
        super.func_70539_a(htvf2, f, f2, f3, f4, f5, f6);
    }

    @Override
    public int func_70070_b(float f) {
        int n = super.func_70070_b(f);
        float f2 = (float)this.field_70546_d / (float)this.field_70547_e;
        f2 *= f2;
        f2 *= f2;
        int n2 = n & 0xFF;
        int n3 = n >> 16 & 0xFF;
        if ((n3 += (int)(f2 * 15.0f * 16.0f)) > 240) {
            n3 = 240;
        }
        return n2 | n3 << 16;
    }

    @Override
    public float func_70013_c(float f) {
        float f2 = super.func_70013_c(f);
        float f3 = (float)this.field_70546_d / (float)this.field_70547_e;
        f3 = f3 * f3 * f3 * f3;
        return f2 * (1.0f - f3) + f3;
    }

    @Override
    public void func_70071_h_() {
        float f;
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        float f2 = f = (float)this.field_70546_d / (float)this.field_70547_e;
        f = -f + f * f * 2.0f;
        f = 1.0f - f;
        this.field_70165_t = this.field_70574_aq + this.field_70159_w * (double)f;
        this.field_70163_u = this.field_70573_ar + this.field_70181_x * (double)f + (double)(1.0f - f2);
        this.field_70161_v = this.field_70572_as + this.field_70179_y * (double)f;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
    }
}

