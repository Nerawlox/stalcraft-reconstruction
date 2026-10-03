/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class EntityFireworkRocket
extends Entity {
    public int field_92056_a;
    public int field_92055_b;

    public EntityFireworkRocket(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.25f, 0.25f);
    }

    @Override
    public void func_70088_a() {
        this.field_70180_af._a(8, 5);
    }

    @Override
    public boolean func_70112_a(double d) {
        return d < 4096.0;
    }

    public EntityFireworkRocket(ozlu ozlu2, double d, double d2, double d3, cvzo cvzo2) {
        super(ozlu2);
        this.field_92056_a = 0;
        this.func_70105_a(0.25f, 0.25f);
        this.func_70107_b(d, d2, d3);
        this.field_70129_M = 0.0f;
        int n = 1;
        if (cvzo2 != null && cvzo2._p()) {
            this.field_70180_af._b(8, cvzo2);
            qoac qoac2 = cvzo2._q();
            qoac qoac3 = qoac2._m("Fireworks");
            if (qoac3 != null) {
                n += qoac3._d("Flight");
            }
        }
        this.field_70159_w = this.field_70146_Z.nextGaussian() * 0.001;
        this.field_70179_y = this.field_70146_Z.nextGaussian() * 0.001;
        this.field_70181_x = 0.05;
        this.field_92055_b = 10 * n + this.field_70146_Z.nextInt(6) + this.field_70146_Z.nextInt(7);
    }

    @Override
    public void func_70016_h(double d, double d2, double d3) {
        this.field_70159_w = d;
        this.field_70181_x = d2;
        this.field_70179_y = d3;
        if (this.field_70127_C == 0.0f && this.field_70126_B == 0.0f) {
            float f = sajh._a(d * d + d3 * d3);
            this.field_70126_B = this.field_70177_z = (float)(Math.atan2(d, d3) * 180.0 / 3.1415927410125732);
            this.field_70127_C = this.field_70125_A = (float)(Math.atan2(d2, f) * 180.0 / 3.1415927410125732);
        }
    }

    @Override
    public void func_70071_h_() {
        this.field_70142_S = this.field_70165_t;
        this.field_70137_T = this.field_70163_u;
        this.field_70136_U = this.field_70161_v;
        super.func_70071_h_();
        this.field_70159_w *= 1.15;
        this.field_70179_y *= 1.15;
        this.field_70181_x += 0.04;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / 3.1415927410125732);
        this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0 / 3.1415927410125732);
        while (this.field_70125_A - this.field_70127_C < -180.0f) {
            this.field_70127_C -= 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C >= 180.0f) {
            this.field_70127_C += 360.0f;
        }
        while (this.field_70177_z - this.field_70126_B < -180.0f) {
            this.field_70126_B -= 360.0f;
        }
        while (this.field_70177_z - this.field_70126_B >= 180.0f) {
            this.field_70126_B += 360.0f;
        }
        this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2f;
        this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2f;
        if (this.field_92056_a == 0) {
            this.field_70170_p.func_72956_a(this, "fireworks.launch", 3.0f, 1.0f);
        }
        ++this.field_92056_a;
        if (this.field_70170_p.field_72995_K && this.field_92056_a % 2 < 2) {
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u - 0.3, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05, -this.field_70181_x * 0.5, this.field_70146_Z.nextGaussian() * 0.05);
        }
        if (!this.field_70170_p.field_72995_K && this.field_92056_a > this.field_92055_b) {
            this.field_70170_p.func_72960_a(this, (byte)17);
            this.func_70106_y();
        }
    }

    @Override
    public void func_70103_a(byte by) {
        if (by == 17 && this.field_70170_p.field_72995_K) {
            cvzo cvzo2 = this.field_70180_af._f(8);
            qoac qoac2 = null;
            if (cvzo2 != null && cvzo2._p()) {
                qoac2 = cvzo2._q()._m("Fireworks");
            }
            this.field_70170_p.func_92088_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y, qoac2);
        }
        super.func_70103_a(by);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("Life", this.field_92056_a);
        qoac2._a("LifeTime", this.field_92055_b);
        cvzo cvzo2 = this.field_70180_af._f(8);
        if (cvzo2 != null) {
            qoac qoac3 = new qoac();
            cvzo2._b(qoac3);
            qoac2._a("FireworksItem", qoac3);
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        cvzo cvzo2;
        this.field_92056_a = qoac2._f("Life");
        this.field_92055_b = qoac2._f("LifeTime");
        qoac qoac3 = qoac2._m("FireworksItem");
        if (qoac3 != null && (cvzo2 = cvzo._a(qoac3)) != null) {
            this.field_70180_af._b(8, cvzo2);
        }
    }

    @Override
    public float func_70053_R() {
        return 0.0f;
    }

    @Override
    public float func_70013_c(float f) {
        return super.func_70013_c(f);
    }

    @Override
    public int func_70070_b(float f) {
        return super.func_70070_b(f);
    }

    @Override
    public boolean func_70075_an() {
        return false;
    }
}

