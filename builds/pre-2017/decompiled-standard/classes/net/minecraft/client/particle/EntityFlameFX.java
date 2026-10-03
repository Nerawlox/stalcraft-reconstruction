/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;

public class EntityFlameFX
extends EntityFX {
    public float field_70562_a;

    public EntityFlameFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3, d4, d5, d6);
        this.field_70159_w = this.field_70159_w * (double)0.01f + d4;
        this.field_70181_x = this.field_70181_x * (double)0.01f + d5;
        this.field_70179_y = this.field_70179_y * (double)0.01f + d6;
        d += (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05f);
        d2 += (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05f);
        d3 += (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05f);
        this.field_70562_a = this.field_70544_f;
        this.field_70551_j = 1.0f;
        this.field_70553_i = 1.0f;
        this.field_70552_h = 1.0f;
        this.field_70547_e = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.field_70145_X = true;
        this.func_70536_a(48);
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.field_70546_d + f) / (float)this.field_70547_e;
        this.field_70544_f = this.field_70562_a * (1.0f - f7 * f7 * 0.5f);
        super.func_70539_a(htvf2, f, f2, f3, f4, f5, f6);
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
        int n2 = n & 0xFF;
        int n3 = n >> 16 & 0xFF;
        if ((n2 += (int)(f2 * 15.0f * 16.0f)) > 240) {
            n2 = 240;
        }
        return n2 | n3 << 16;
    }

    @Override
    public float func_70013_c(float f) {
        float f2 = ((float)this.field_70546_d + f) / (float)this.field_70547_e;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = super.func_70013_c(f);
        return f3 * f2 + (1.0f - f2);
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.96f;
        this.field_70181_x *= (double)0.96f;
        this.field_70179_y *= (double)0.96f;
        if (this.field_70122_E) {
            this.field_70159_w *= (double)0.7f;
            this.field_70179_y *= (double)0.7f;
        }
    }
}

