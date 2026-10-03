/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class EntityTNTPrimed
extends Entity {
    public int field_70516_a;
    public EntityLivingBase field_94084_b;

    public EntityTNTPrimed(ozlu ozlu2) {
        super(ozlu2);
        this.field_70156_m = true;
        this.func_70105_a(0.98f, 0.98f);
        this.field_70129_M = this.field_70131_O / 2.0f;
    }

    public EntityTNTPrimed(ozlu ozlu2, double d, double d2, double d3, EntityLivingBase entityLivingBase) {
        this(ozlu2);
        this.func_70107_b(d, d2, d3);
        float f = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.field_70159_w = -((float)Math.sin(f)) * 0.02f;
        this.field_70181_x = 0.2f;
        this.field_70179_y = -((float)Math.cos(f)) * 0.02f;
        this.field_70516_a = 80;
        this.field_70169_q = d;
        this.field_70167_r = d2;
        this.field_70166_s = d3;
        this.field_94084_b = entityLivingBase;
    }

    @Override
    public void func_70088_a() {
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    @Override
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70181_x -= (double)0.04f;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.98f;
        this.field_70181_x *= (double)0.98f;
        this.field_70179_y *= (double)0.98f;
        if (this.field_70122_E) {
            this.field_70159_w *= (double)0.7f;
            this.field_70179_y *= (double)0.7f;
            this.field_70181_x *= -0.5;
        }
        if (this.field_70516_a-- <= 0) {
            this.func_70106_y();
            if (!this.field_70170_p.field_72995_K) {
                this.func_70515_d();
            }
        } else {
            this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5, this.field_70161_v, 0.0, 0.0, 0.0);
        }
    }

    public void func_70515_d() {
        float f = 4.0f;
        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, f, true);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("Fuse", (byte)this.field_70516_a);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        this.field_70516_a = qoac2._d("Fuse");
    }

    @Override
    public float func_70053_R() {
        return 0.0f;
    }

    public EntityLivingBase func_94083_c() {
        return this.field_94084_b;
    }
}

