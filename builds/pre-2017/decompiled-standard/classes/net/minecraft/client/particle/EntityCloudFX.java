/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.player.EntityPlayer;

public class EntityCloudFX
extends EntityFX {
    public float field_70569_a;

    public EntityCloudFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        float f = 2.5f;
        this.field_70159_w *= (double)0.1f;
        this.field_70181_x *= (double)0.1f;
        this.field_70179_y *= (double)0.1f;
        this.field_70159_w += d4;
        this.field_70181_x += d5;
        this.field_70179_y += d6;
        this.field_70553_i = this.field_70551_j = 1.0f - (float)(Math.random() * (double)0.3f);
        this.field_70552_h = this.field_70551_j;
        this.field_70544_f *= 0.75f;
        this.field_70544_f *= f;
        this.field_70569_a = this.field_70544_f;
        this.field_70547_e = (int)(8.0 / (Math.random() * 0.8 + 0.3));
        this.field_70547_e = (int)((float)this.field_70547_e * f);
        this.field_70145_X = false;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.field_70546_d + f) / (float)this.field_70547_e * 32.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        this.field_70544_f = this.field_70569_a * f7;
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
        this.func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.96f;
        this.field_70181_x *= (double)0.96f;
        this.field_70179_y *= (double)0.96f;
        EntityPlayer entityPlayer = this.field_70170_p.func_72890_a(this, 2.0);
        if (entityPlayer != null && this.field_70163_u > entityPlayer.field_70121_D._c) {
            this.field_70163_u += (entityPlayer.field_70121_D._c - this.field_70163_u) * 0.2;
            this.field_70181_x += (entityPlayer.field_70181_x - this.field_70181_x) * 0.2;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        }
        if (this.field_70122_E) {
            this.field_70159_w *= (double)0.7f;
            this.field_70179_y *= (double)0.7f;
        }
    }
}

