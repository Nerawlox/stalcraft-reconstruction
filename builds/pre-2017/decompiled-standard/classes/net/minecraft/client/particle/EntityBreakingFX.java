/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;

public class EntityBreakingFX
extends EntityFX {
    public EntityBreakingFX(ozlu ozlu2, double d, double d2, double d3, tgdv tgdv2) {
        this(ozlu2, d, d2, d3, tgdv2, 0);
    }

    public EntityBreakingFX(ozlu ozlu2, double d, double d2, double d3, tgdv tgdv2, int n) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.func_110125_a(tgdv2.func_77617_a(n));
        this.field_70551_j = 1.0f;
        this.field_70553_i = 1.0f;
        this.field_70552_h = 1.0f;
        this.field_70545_g = twgu.field_72039_aU.field_72017_co;
        this.field_70544_f /= 2.0f;
    }

    public EntityBreakingFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6, tgdv tgdv2, int n) {
        this(ozlu2, d, d2, d3, tgdv2, n);
        this.field_70159_w *= (double)0.1f;
        this.field_70181_x *= (double)0.1f;
        this.field_70179_y *= (double)0.1f;
        this.field_70159_w += d4;
        this.field_70181_x += d5;
        this.field_70179_y += d6;
    }

    @Override
    public int func_70537_b() {
        return 2;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.field_94054_b + this.field_70548_b / 4.0f) / 16.0f;
        float f8 = f7 + 0.015609375f;
        float f9 = ((float)this.field_94055_c + this.field_70549_c / 4.0f) / 16.0f;
        float f10 = f9 + 0.015609375f;
        float f11 = 0.1f * this.field_70544_f;
        if (this.field_70550_a != null) {
            f7 = this.field_70550_a.func_94214_a(this.field_70548_b / 4.0f * 16.0f);
            f8 = this.field_70550_a.func_94214_a((this.field_70548_b + 1.0f) / 4.0f * 16.0f);
            f9 = this.field_70550_a.func_94207_b(this.field_70549_c / 4.0f * 16.0f);
            f10 = this.field_70550_a.func_94207_b((this.field_70549_c + 1.0f) / 4.0f * 16.0f);
        }
        float f12 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)f - field_70556_an);
        float f13 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f - field_70554_ao);
        float f14 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)f - field_70555_ap);
        float f15 = 1.0f;
        htvf2.func_78386_a(f15 * this.field_70552_h, f15 * this.field_70553_i, f15 * this.field_70551_j);
        htvf2.func_78374_a(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f7, f10);
        htvf2.func_78374_a(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11, f14 - f4 * f11 + f6 * f11, f7, f9);
        htvf2.func_78374_a(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f8, f9);
        htvf2.func_78374_a(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11, f14 + f4 * f11 - f6 * f11, f8, f10);
    }
}

