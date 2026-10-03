/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.sajh;

public class EntityEnderEye
extends Entity {
    public double field_70224_b;
    public double field_70225_c;
    public double field_70222_d;
    public int field_70223_e;
    public boolean field_70221_f;

    public EntityEnderEye(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.25f, 0.25f);
    }

    @Override
    public void func_70088_a() {
    }

    @Override
    public boolean func_70112_a(double d) {
        double d2 = this.field_70121_D._b() * 4.0;
        return d < (d2 *= 64.0) * d2;
    }

    public EntityEnderEye(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2);
        this.field_70223_e = 0;
        this.func_70105_a(0.25f, 0.25f);
        this.func_70107_b(d, d2, d3);
        this.field_70129_M = 0.0f;
    }

    public void func_70220_a(double d, int n, double d2) {
        double d3 = d - this.field_70165_t;
        double d4 = d2 - this.field_70161_v;
        float f = sajh._a(d3 * d3 + d4 * d4);
        if (f > 12.0f) {
            this.field_70224_b = this.field_70165_t + d3 / (double)f * 12.0;
            this.field_70222_d = this.field_70161_v + d4 / (double)f * 12.0;
            this.field_70225_c = this.field_70163_u + 8.0;
        } else {
            this.field_70224_b = d;
            this.field_70225_c = n;
            this.field_70222_d = d2;
        }
        this.field_70223_e = 0;
        this.field_70221_f = this.field_70146_Z.nextInt(5) > 0;
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
        this.field_70165_t += this.field_70159_w;
        this.field_70163_u += this.field_70181_x;
        this.field_70161_v += this.field_70179_y;
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
        if (!this.field_70170_p.field_72995_K) {
            double d = this.field_70224_b - this.field_70165_t;
            double d2 = this.field_70222_d - this.field_70161_v;
            float f2 = (float)Math.sqrt(d * d + d2 * d2);
            float f3 = (float)Math.atan2(d2, d);
            double d3 = (double)f + (double)(f2 - f) * 0.0025;
            if (f2 < 1.0f) {
                d3 *= 0.8;
                this.field_70181_x *= 0.8;
            }
            this.field_70159_w = Math.cos(f3) * d3;
            this.field_70179_y = Math.sin(f3) * d3;
            this.field_70181_x = this.field_70163_u < this.field_70225_c ? (this.field_70181_x += (1.0 - this.field_70181_x) * (double)0.015f) : (this.field_70181_x += (-1.0 - this.field_70181_x) * (double)0.015f);
        }
        float f4 = 0.25f;
        if (this.func_70090_H()) {
            for (int i = 0; i < 4; ++i) {
                this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)f4, this.field_70163_u - this.field_70181_x * (double)f4, this.field_70161_v - this.field_70179_y * (double)f4, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
        } else {
            this.field_70170_p.func_72869_a("portal", this.field_70165_t - this.field_70159_w * (double)f4 + this.field_70146_Z.nextDouble() * 0.6 - 0.3, this.field_70163_u - this.field_70181_x * (double)f4 - 0.5, this.field_70161_v - this.field_70179_y * (double)f4 + this.field_70146_Z.nextDouble() * 0.6 - 0.3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            ++this.field_70223_e;
            if (this.field_70223_e > 80 && !this.field_70170_p.field_72995_K) {
                this.func_70106_y();
                if (this.field_70221_f) {
                    this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new cvzo(tgdv.field_77748_bA)));
                } else {
                    this.field_70170_p.func_72926_e(2003, (int)Math.round(this.field_70165_t), (int)Math.round(this.field_70163_u), (int)Math.round(this.field_70161_v), 0);
                }
            }
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
    public float func_70013_c(float f) {
        return 1.0f;
    }

    @Override
    public int func_70070_b(float f) {
        return 0xF000F0;
    }

    @Override
    public boolean func_70075_an() {
        return false;
    }
}

