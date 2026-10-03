/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;

public class EntityExplodeFX
extends EntityFX {
    public EntityExplodeFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3, d4, d5, d6);
        this.field_70159_w = d4 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.05f);
        this.field_70181_x = d5 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.05f);
        this.field_70179_y = d6 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.05f);
        this.field_70553_i = this.field_70551_j = this.field_70146_Z.nextFloat() * 0.3f + 0.7f;
        this.field_70552_h = this.field_70551_j;
        this.field_70544_f = this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() * 6.0f + 1.0f;
        this.field_70547_e = (int)(16.0 / ((double)this.field_70146_Z.nextFloat() * 0.8 + 0.2)) + 2;
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
        this.func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
        this.field_70181_x += 0.004;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.9f;
        this.field_70181_x *= (double)0.9f;
        this.field_70179_y *= (double)0.9f;
        if (this.field_70122_E) {
            this.field_70159_w *= (double)0.7f;
            this.field_70179_y *= (double)0.7f;
        }
    }
}

