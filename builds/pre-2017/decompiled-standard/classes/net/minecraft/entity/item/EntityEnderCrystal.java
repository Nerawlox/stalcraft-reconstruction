/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityEnderCrystal
extends Entity {
    public int field_70261_a;
    public int field_70260_b;

    public EntityEnderCrystal(ozlu ozlu2) {
        super(ozlu2);
        this.field_70156_m = true;
        this.func_70105_a(2.0f, 2.0f);
        this.field_70129_M = this.field_70131_O / 2.0f;
        this.field_70260_b = 5;
        this.field_70261_a = this.field_70146_Z.nextInt(100000);
    }

    public EntityEnderCrystal(ozlu ozlu2, double d, double d2, double d3) {
        this(ozlu2);
        this.func_70107_b(d, d2, d3);
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    @Override
    public void func_70088_a() {
        this.field_70180_af._a(8, (Object)this.field_70260_b);
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        ++this.field_70261_a;
        this.field_70180_af._b(8, this.field_70260_b);
        int n = sajh._c(this.field_70165_t);
        int n2 = sajh._c(this.field_70163_u);
        int n3 = sajh._c(this.field_70161_v);
        if (this.field_70170_p.func_72798_a(n, n2, n3) != twgu.field_72067_ar.field_71990_ca) {
            this.field_70170_p.func_94575_c(n, n2, n3, twgu.field_72067_ar.field_71990_ca);
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
    }

    @Override
    public void func_70037_a(qoac qoac2) {
    }

    @Override
    public float func_70053_R() {
        return 0.0f;
    }

    @Override
    public boolean func_70067_L() {
        return true;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        if (!this.field_70128_L && !this.field_70170_p.field_72995_K) {
            this.field_70260_b = 0;
            if (this.field_70260_b <= 0) {
                this.func_70106_y();
                if (!this.field_70170_p.field_72995_K) {
                    this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 6.0f, true);
                }
            }
        }
        return true;
    }
}

