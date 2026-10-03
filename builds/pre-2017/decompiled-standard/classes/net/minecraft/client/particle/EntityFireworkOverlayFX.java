/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.sajh;

public class EntityFireworkOverlayFX
extends EntityFX {
    public EntityFireworkOverlayFX(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
        this.field_70547_e = 4;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = 0.25f;
        float f8 = f7 + 0.25f;
        float f9 = 0.125f;
        float f10 = f9 + 0.25f;
        float f11 = 7.1f * sajh._a(((float)this.field_70546_d + f - 1.0f) * 0.25f * (float)Math.PI);
        this.field_82339_as = 0.6f - ((float)this.field_70546_d + f - 1.0f) * 0.25f * 0.5f;
        float f12 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)f - field_70556_an);
        float f13 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f - field_70554_ao);
        float f14 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)f - field_70555_ap);
        htvf2.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
        htvf2.func_78374_a(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f8, f10);
        htvf2.func_78374_a(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11, f14 - f4 * f11 + f6 * f11, f8, f9);
        htvf2.func_78374_a(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f7, f9);
        htvf2.func_78374_a(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11, f14 + f4 * f11 - f6 * f11, f7, f10);
    }
}

