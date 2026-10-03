/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityBoat
extends Entity {
    public boolean field_70279_a = true;
    public double field_70276_b = 0.07;
    public int field_70277_c;
    public double field_70274_d;
    public double field_70275_e;
    public double field_70272_f;
    public double field_70273_g;
    public double field_70281_h;
    public double field_70282_i;
    public double field_70280_j;
    public double field_70278_an;

    public EntityBoat(ozlu ozlu2) {
        super(ozlu2);
        this.field_70156_m = true;
        this.func_70105_a(1.5f, 0.6f);
        this.field_70129_M = this.field_70131_O / 2.0f;
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    @Override
    public void func_70088_a() {
        this.field_70180_af._a(17, new Integer(0));
        this.field_70180_af._a(18, new Integer(1));
        this.field_70180_af._a(19, new Float(0.0f));
    }

    @Override
    public eidj func_70114_g(Entity entity) {
        return entity.field_70121_D;
    }

    @Override
    public eidj func_70046_E() {
        return this.field_70121_D;
    }

    @Override
    public boolean func_70104_M() {
        return true;
    }

    public EntityBoat(ozlu ozlu2, double d, double d2, double d3) {
        this(ozlu2);
        this.func_70107_b(d, d2 + (double)this.field_70129_M, d3);
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        this.field_70169_q = d;
        this.field_70167_r = d2;
        this.field_70166_s = d3;
    }

    @Override
    public double func_70042_X() {
        return (double)this.field_70131_O * 0.0 - (double)0.3f;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        boolean bl;
        if (this.func_85032_ar()) {
            return false;
        }
        if (this.field_70170_p.field_72995_K || this.field_70128_L) {
            return true;
        }
        this.func_70269_c(-this.func_70267_i());
        this.func_70265_b(10);
        this.func_70266_a(this.func_70271_g() + f * 10.0f);
        this.func_70018_K();
        boolean bl2 = bl = jxtc2.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)jxtc2.func_76346_g()).field_71075_bZ._d;
        if (bl || this.func_70271_g() > 40.0f) {
            if (this.field_70153_n != null) {
                this.field_70153_n.func_70078_a(this);
            }
            if (!bl) {
                this.func_70054_a(tgdv.field_77769_aE.field_77779_bT, 1, 0.0f);
            }
            this.func_70106_y();
        }
        return true;
    }

    @Override
    public void func_70057_ab() {
        this.func_70269_c(-this.func_70267_i());
        this.func_70265_b(10);
        this.func_70266_a(this.func_70271_g() * 11.0f);
    }

    @Override
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }

    @Override
    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
        if (this.field_70279_a) {
            this.field_70277_c = n + 5;
        } else {
            double d4 = d - this.field_70165_t;
            double d5 = d2 - this.field_70163_u;
            double d6 = d3 - this.field_70161_v;
            double d7 = d4 * d4 + d5 * d5 + d6 * d6;
            if (d7 > 1.0) {
                this.field_70277_c = 3;
            } else {
                return;
            }
        }
        this.field_70274_d = d;
        this.field_70275_e = d2;
        this.field_70272_f = d3;
        this.field_70273_g = f;
        this.field_70281_h = f2;
        this.field_70159_w = this.field_70282_i;
        this.field_70181_x = this.field_70280_j;
        this.field_70179_y = this.field_70278_an;
    }

    @Override
    public void func_70016_h(double d, double d2, double d3) {
        this.field_70282_i = this.field_70159_w = d;
        this.field_70280_j = this.field_70181_x = d2;
        this.field_70278_an = this.field_70179_y = d3;
    }

    @Override
    public void func_70071_h_() {
        int n;
        double d;
        double d2;
        double d3;
        double d4;
        super.func_70071_h_();
        if (this.func_70268_h() > 0) {
            this.func_70265_b(this.func_70268_h() - 1);
        }
        if (this.func_70271_g() > 0.0f) {
            this.func_70266_a(this.func_70271_g() - 1.0f);
        }
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        int n2 = 5;
        double d5 = 0.0;
        for (int i = 0; i < n2; ++i) {
            double d6 = this.field_70121_D._c + (this.field_70121_D._f - this.field_70121_D._c) * (double)(i + 0) / (double)n2 - 0.125;
            double d7 = this.field_70121_D._c + (this.field_70121_D._f - this.field_70121_D._c) * (double)(i + 1) / (double)n2 - 0.125;
            eidj eidj2 = eidj._a()._a(this.field_70121_D._b, d6, this.field_70121_D._d, this.field_70121_D._e, d7, this.field_70121_D._g);
            if (!this.field_70170_p.func_72830_b(eidj2, tflj._h)) continue;
            d5 += 1.0 / (double)n2;
        }
        double d8 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        if (d8 > 0.26249999999999996) {
            d4 = Math.cos((double)this.field_70177_z * Math.PI / 180.0);
            d3 = Math.sin((double)this.field_70177_z * Math.PI / 180.0);
            int n3 = 0;
            while ((double)n3 < 1.0 + d8 * 60.0) {
                double d9;
                double d10;
                double d11 = this.field_70146_Z.nextFloat() * 2.0f - 1.0f;
                double d12 = (double)(this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7;
                if (this.field_70146_Z.nextBoolean()) {
                    d10 = this.field_70165_t - d4 * d11 * 0.8 + d3 * d12;
                    d9 = this.field_70161_v - d3 * d11 * 0.8 - d4 * d12;
                    this.field_70170_p.func_72869_a("splash", d10, this.field_70163_u - 0.125, d9, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                } else {
                    d10 = this.field_70165_t + d4 + d3 * d11 * 0.7;
                    d9 = this.field_70161_v + d3 - d4 * d11 * 0.7;
                    this.field_70170_p.func_72869_a("splash", d10, this.field_70163_u - 0.125, d9, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                }
                ++n3;
            }
        }
        if (this.field_70170_p.field_72995_K && this.field_70279_a) {
            if (this.field_70277_c > 0) {
                d4 = this.field_70165_t + (this.field_70274_d - this.field_70165_t) / (double)this.field_70277_c;
                d3 = this.field_70163_u + (this.field_70275_e - this.field_70163_u) / (double)this.field_70277_c;
                double d13 = this.field_70161_v + (this.field_70272_f - this.field_70161_v) / (double)this.field_70277_c;
                double d14 = sajh._f(this.field_70273_g - (double)this.field_70177_z);
                this.field_70177_z = (float)((double)this.field_70177_z + d14 / (double)this.field_70277_c);
                this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70281_h - (double)this.field_70125_A) / (double)this.field_70277_c);
                --this.field_70277_c;
                this.func_70107_b(d4, d3, d13);
                this.func_70101_b(this.field_70177_z, this.field_70125_A);
            } else {
                d4 = this.field_70165_t + this.field_70159_w;
                d3 = this.field_70163_u + this.field_70181_x;
                double d15 = this.field_70161_v + this.field_70179_y;
                this.func_70107_b(d4, d3, d15);
                if (this.field_70122_E) {
                    this.field_70159_w *= 0.5;
                    this.field_70181_x *= 0.5;
                    this.field_70179_y *= 0.5;
                }
                this.field_70159_w *= (double)0.99f;
                this.field_70181_x *= (double)0.95f;
                this.field_70179_y *= (double)0.99f;
            }
            return;
        }
        if (d5 < 1.0) {
            d4 = d5 * 2.0 - 1.0;
            this.field_70181_x += (double)0.04f * d4;
        } else {
            if (this.field_70181_x < 0.0) {
                this.field_70181_x /= 2.0;
            }
            this.field_70181_x += (double)0.007f;
        }
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityLivingBase && (d4 = (double)((EntityLivingBase)this.field_70153_n).field_70701_bs) > 0.0) {
            d3 = -Math.sin(this.field_70153_n.field_70177_z * (float)Math.PI / 180.0f);
            d2 = Math.cos(this.field_70153_n.field_70177_z * (float)Math.PI / 180.0f);
            this.field_70159_w += d3 * this.field_70276_b * (double)0.05f;
            this.field_70179_y += d2 * this.field_70276_b * (double)0.05f;
        }
        if ((d4 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y)) > 0.35) {
            d3 = 0.35 / d4;
            this.field_70159_w *= d3;
            this.field_70179_y *= d3;
            d4 = 0.35;
        }
        if (d4 > d8 && this.field_70276_b < 0.35) {
            this.field_70276_b += (0.35 - this.field_70276_b) / 35.0;
            if (this.field_70276_b > 0.35) {
                this.field_70276_b = 0.35;
            }
        } else {
            this.field_70276_b -= (this.field_70276_b - 0.07) / 35.0;
            if (this.field_70276_b < 0.07) {
                this.field_70276_b = 0.07;
            }
        }
        if (this.field_70122_E) {
            this.field_70159_w *= 0.5;
            this.field_70181_x *= 0.5;
            this.field_70179_y *= 0.5;
        }
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        if (this.field_70123_F && d8 > 0.2) {
            if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
                int n4;
                this.func_70106_y();
                for (n4 = 0; n4 < 3; ++n4) {
                    this.func_70054_a(twgu.field_71988_x.field_71990_ca, 1, 0.0f);
                }
                for (n4 = 0; n4 < 2; ++n4) {
                    this.func_70054_a(tgdv.field_77669_D.field_77779_bT, 1, 0.0f);
                }
            }
        } else {
            this.field_70159_w *= (double)0.99f;
            this.field_70181_x *= (double)0.95f;
            this.field_70179_y *= (double)0.99f;
        }
        this.field_70125_A = 0.0f;
        d3 = this.field_70177_z;
        d2 = this.field_70169_q - this.field_70165_t;
        double d16 = this.field_70166_s - this.field_70161_v;
        if (d2 * d2 + d16 * d16 > 0.001) {
            d3 = (float)(Math.atan2(d16, d2) * 180.0 / Math.PI);
        }
        if ((d = sajh._f(d3 - (double)this.field_70177_z)) > 20.0) {
            d = 20.0;
        }
        if (d < -20.0) {
            d = -20.0;
        }
        this.field_70177_z = (float)((double)this.field_70177_z + d);
        this.func_70101_b(this.field_70177_z, this.field_70125_A);
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        List list2 = this.field_70170_p.func_72839_b(this, this.field_70121_D._b(0.2f, 0.0, 0.2f));
        if (list2 != null && !list2.isEmpty()) {
            for (n = 0; n < list2.size(); ++n) {
                Entity entity = (Entity)list2.get(n);
                if (entity == this.field_70153_n || !entity.func_70104_M() || !(entity instanceof EntityBoat)) continue;
                entity.func_70108_f(this);
            }
        }
        for (n = 0; n < 4; ++n) {
            int n5 = sajh._c(this.field_70165_t + ((double)(n % 2) - 0.5) * 0.8);
            int n6 = sajh._c(this.field_70161_v + ((double)(n / 2) - 0.5) * 0.8);
            for (int i = 0; i < 2; ++i) {
                int n7 = sajh._c(this.field_70163_u) + i;
                int n8 = this.field_70170_p.func_72798_a(n5, n7, n6);
                if (n8 == twgu.field_72037_aS.field_71990_ca) {
                    this.field_70170_p.func_94571_i(n5, n7, n6);
                    continue;
                }
                if (n8 != twgu.field_71991_bz.field_71990_ca) continue;
                this.field_70170_p.func_94578_a(n5, n7, n6, true);
            }
        }
        if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
            this.field_70153_n = null;
        }
    }

    @Override
    public void func_70043_V() {
        if (this.field_70153_n == null) {
            return;
        }
        double d = Math.cos((double)this.field_70177_z * Math.PI / 180.0) * 0.4;
        double d2 = Math.sin((double)this.field_70177_z * Math.PI / 180.0) * 0.4;
        this.field_70153_n.func_70107_b(this.field_70165_t + d, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + d2);
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
    public boolean func_130002_c(EntityPlayer entityPlayer) {
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != entityPlayer) {
            return true;
        }
        if (!this.field_70170_p.field_72995_K) {
            entityPlayer.func_70078_a(this);
        }
        return true;
    }

    public void func_70266_a(float f) {
        this.field_70180_af._b(19, Float.valueOf(f));
    }

    public float func_70271_g() {
        return this.field_70180_af._d(19);
    }

    public void func_70265_b(int n) {
        this.field_70180_af._b(17, n);
    }

    public int func_70268_h() {
        return this.field_70180_af._c(17);
    }

    public void func_70269_c(int n) {
        this.field_70180_af._b(18, n);
    }

    public int func_70267_i() {
        return this.field_70180_af._c(18);
    }

    public void func_70270_d(boolean bl) {
        this.field_70279_a = bl;
    }
}

