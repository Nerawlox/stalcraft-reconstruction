/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;

@SideOnly(value=Side.CLIENT)
public class EntityDiggingFX
extends EntityFX {
    public twgu field_70597_a;
    public int side;

    public EntityDiggingFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6, twgu twgu2, int n) {
        this(ozlu2, d, d2, d3, d4, d5, d6, twgu2, n, ozlu2.field_73012_v.nextInt(6));
    }

    public EntityDiggingFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6, twgu twgu2, int n, int n2) {
        super(ozlu2, d, d2, d3, d4, d5, d6);
        this.field_70597_a = twgu2;
        this.func_110125_a(twgu2.func_71858_a(n2, n));
        this.field_70545_g = twgu2.field_72017_co;
        this.field_70551_j = 0.6f;
        this.field_70553_i = 0.6f;
        this.field_70552_h = 0.6f;
        this.field_70544_f /= 2.0f;
        this.side = n2;
    }

    public EntityDiggingFX func_70596_a(int n, int n2, int n3) {
        if (this.field_70597_a == twgu.field_71980_u && this.side != 1) {
            return this;
        }
        int n4 = this.field_70597_a.func_71920_b(this.field_70170_p, n, n2, n3);
        this.field_70552_h *= (float)(n4 >> 16 & 0xFF) / 255.0f;
        this.field_70553_i *= (float)(n4 >> 8 & 0xFF) / 255.0f;
        this.field_70551_j *= (float)(n4 & 0xFF) / 255.0f;
        return this;
    }

    public EntityDiggingFX func_90019_g(int n) {
        if (this.field_70597_a == twgu.field_71980_u) {
            return this;
        }
        int n2 = this.field_70597_a.func_71889_f_(n);
        this.field_70552_h *= (float)(n2 >> 16 & 0xFF) / 255.0f;
        this.field_70553_i *= (float)(n2 >> 8 & 0xFF) / 255.0f;
        this.field_70551_j *= (float)(n2 & 0xFF) / 255.0f;
        return this;
    }

    @Override
    public int func_70537_b() {
        return 1;
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

