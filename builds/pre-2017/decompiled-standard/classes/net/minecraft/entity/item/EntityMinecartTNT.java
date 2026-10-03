/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.jxtc;

public class EntityMinecartTNT
extends EntityMinecart {
    public int field_94106_a = -1;

    public EntityMinecartTNT(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityMinecartTNT(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
    }

    @Override
    public int func_94087_l() {
        return 3;
    }

    @Override
    public twgu func_94093_n() {
        return twgu.field_72091_am;
    }

    @Override
    public void func_70071_h_() {
        double d;
        super.func_70071_h_();
        if (this.field_94106_a > 0) {
            --this.field_94106_a;
            this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5, this.field_70161_v, 0.0, 0.0, 0.0);
        } else if (this.field_94106_a == 0) {
            this.func_94103_c(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        }
        if (this.field_70123_F && (d = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) >= (double)0.01f) {
            this.func_94103_c(d);
        }
    }

    @Override
    public void func_94095_a(jxtc jxtc2) {
        super.func_94095_a(jxtc2);
        double d = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
        if (!jxtc2.func_94541_c()) {
            this.func_70099_a(new cvzo(twgu.field_72091_am, 1), 0.0f);
        }
        if (jxtc2.func_76347_k() || jxtc2.func_94541_c() || d >= (double)0.01f) {
            this.func_94103_c(d);
        }
    }

    public void func_94103_c(double d) {
        if (!this.field_70170_p.field_72995_K) {
            double d2 = Math.sqrt(d);
            if (d2 > 5.0) {
                d2 = 5.0;
            }
            this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)(4.0 + this.field_70146_Z.nextDouble() * 1.5 * d2), true);
            this.func_70106_y();
        }
    }

    @Override
    public void func_70069_a(float f) {
        if (f >= 3.0f) {
            float f2 = f / 10.0f;
            this.func_94103_c(f2 * f2);
        }
        super.func_70069_a(f);
    }

    @Override
    public void func_96095_a(int n, int n2, int n3, boolean bl) {
        if (bl && this.field_94106_a < 0) {
            this.func_94105_c();
        }
    }

    @Override
    public void func_70103_a(byte by) {
        if (by == 10) {
            this.func_94105_c();
        } else {
            super.func_70103_a(by);
        }
    }

    public void func_94105_c() {
        this.field_94106_a = 80;
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72960_a(this, (byte)10);
            this.field_70170_p.func_72956_a(this, "random.fuse", 1.0f, 1.0f);
        }
    }

    public int func_94104_d() {
        return this.field_94106_a;
    }

    public boolean func_96096_ay() {
        return this.field_94106_a > -1;
    }

    @Override
    public float func_82146_a(elkd elkd2, ozlu ozlu2, int n, int n2, int n3, twgu twgu2) {
        if (this.func_96096_ay() && (scgt._a(twgu2.field_71990_ca) || scgt._a(ozlu2, n, n2 + 1, n3))) {
            return 0.0f;
        }
        return super.func_82146_a(elkd2, ozlu2, n, n2, n3, twgu2);
    }

    @Override
    public boolean func_96091_a(elkd elkd2, ozlu ozlu2, int n, int n2, int n3, int n4, float f) {
        if (this.func_96096_ay() && (scgt._a(n4) || scgt._a(ozlu2, n, n2 + 1, n3))) {
            return false;
        }
        return super.func_96091_a(elkd2, ozlu2, n, n2, n3, n4, f);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        if (qoac2._c("TNTFuse")) {
            this.field_94106_a = qoac2._f("TNTFuse");
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("TNTFuse", this.field_94106_a);
    }
}

