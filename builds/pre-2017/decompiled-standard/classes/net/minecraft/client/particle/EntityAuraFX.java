/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;

public class EntityAuraFX
extends EntityFX {
    public EntityAuraFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3, d4, d5, d6);
        float f;
        this.field_70552_h = f = this.field_70146_Z.nextFloat() * 0.1f + 0.2f;
        this.field_70553_i = f;
        this.field_70551_j = f;
        this.func_70536_a(0);
        this.func_70105_a(0.02f, 0.02f);
        this.field_70544_f *= this.field_70146_Z.nextFloat() * 0.6f + 0.5f;
        this.field_70159_w *= (double)0.02f;
        this.field_70181_x *= (double)0.02f;
        this.field_70179_y *= (double)0.02f;
        this.field_70547_e = (int)(20.0 / (Math.random() * 0.8 + 0.2));
        this.field_70145_X = true;
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= 0.99;
        this.field_70181_x *= 0.99;
        this.field_70179_y *= 0.99;
        if (this.field_70547_e-- <= 0) {
            this.func_70106_y();
        }
    }
}

