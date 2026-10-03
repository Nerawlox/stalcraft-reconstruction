/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.xpzm;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;
import net.minecraft.util.zwat;
import net.minecraft.util.zwaw;

@SideOnly(value=Side.CLIENT)
public class EntityOtherPlayerMP
extends AbstractClientPlayer {
    public boolean field_71186_a;
    public int field_71184_b;
    public double field_71185_c;
    public double field_71182_d;
    public double field_71183_e;
    public double field_71180_f;
    public double field_71181_g;

    public EntityOtherPlayerMP(ozlu ozlu2, String string) {
        super(ozlu2, string);
        this.field_70129_M = 0.0f;
        this.field_70138_W = 0.0f;
        this.field_70145_X = true;
        this.field_71082_cx = 0.25f;
        this.field_70155_l = 10.0;
    }

    @Override
    public void func_71061_d_() {
        this.field_70129_M = 0.0f;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        return true;
    }

    @Override
    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
        this.field_71185_c = d;
        this.field_71182_d = d2;
        this.field_71183_e = d3;
        this.field_71180_f = f;
        this.field_71181_g = f2;
        this.field_71184_b = n;
    }

    @Override
    public void func_70071_h_() {
        this.field_71082_cx = 0.0f;
        super.func_70071_h_();
        this.field_70722_aY = this.field_70721_aZ;
        double d = this.field_70165_t - this.field_70169_q;
        double d2 = this.field_70161_v - this.field_70166_s;
        float f = sajh._a(d * d + d2 * d2) * 4.0f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.field_70721_aZ += (f - this.field_70721_aZ) * 0.4f;
        this.field_70754_ba += this.field_70721_aZ;
        if (!this.field_71186_a && this.func_70113_ah() && this.field_71071_by._a[this.field_71071_by._c] != null) {
            cvzo cvzo2 = this.field_71071_by._a[this.field_71071_by._c];
            this.func_71008_a(this.field_71071_by._a[this.field_71071_by._c], tgdv.field_77698_e[cvzo2._d].func_77626_a(cvzo2));
            this.field_71186_a = true;
        } else if (this.field_71186_a && !this.func_70113_ah()) {
            this.func_71041_bz();
            this.field_71186_a = false;
        }
    }

    @Override
    public float func_70053_R() {
        return 0.0f;
    }

    @Override
    public void func_70636_d() {
        super.func_70626_be();
        if (this.field_71184_b > 0) {
            double d;
            double d2 = this.field_70165_t + (this.field_71185_c - this.field_70165_t) / (double)this.field_71184_b;
            double d3 = this.field_70163_u + (this.field_71182_d - this.field_70163_u) / (double)this.field_71184_b;
            double d4 = this.field_70161_v + (this.field_71183_e - this.field_70161_v) / (double)this.field_71184_b;
            for (d = this.field_71180_f - (double)this.field_70177_z; d < -180.0; d += 360.0) {
            }
            while (d >= 180.0) {
                d -= 360.0;
            }
            this.field_70177_z = (float)((double)this.field_70177_z + d / (double)this.field_71184_b);
            this.field_70125_A = (float)((double)this.field_70125_A + (this.field_71181_g - (double)this.field_70125_A) / (double)this.field_71184_b);
            --this.field_71184_b;
            this.func_70107_b(d2, d3, d4);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
        }
        this.field_71107_bF = this.field_71109_bG;
        float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        float f2 = (float)Math.atan(-this.field_70181_x * (double)0.2f) * 15.0f;
        if (f > 0.1f) {
            f = 0.1f;
        }
        if (!this.field_70122_E || this.func_110143_aJ() <= 0.0f) {
            f = 0.0f;
        }
        if (this.field_70122_E || this.func_110143_aJ() <= 0.0f) {
            f2 = 0.0f;
        }
        this.field_71109_bG += (f - this.field_71109_bG) * 0.4f;
        this.field_70726_aT += (f2 - this.field_70726_aT) * 0.8f;
    }

    @Override
    public void func_70062_b(int n, cvzo cvzo2) {
        if (n == 0) {
            this.field_71071_by._a[this.field_71071_by._c] = cvzo2;
        } else {
            this.field_71071_by._b[n - 1] = cvzo2;
        }
    }

    @Override
    public float getDefaultEyeHeight() {
        return 1.82f;
    }

    @Override
    public void func_70006_a(zwat zwat2) {
        xpzm._E()._J.func_73827_b()._a(zwat2._a(true));
    }

    @Override
    public boolean func_70003_b(int n, String string) {
        return false;
    }

    @Override
    public zwaw func_82114_b() {
        return new zwaw(sajh._c(this.field_70165_t + 0.5), sajh._c(this.field_70163_u + 0.5), sajh._c(this.field_70161_v + 0.5));
    }
}

