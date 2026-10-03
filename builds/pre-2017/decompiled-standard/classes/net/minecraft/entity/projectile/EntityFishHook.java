/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class EntityFishHook
extends Entity {
    public int field_70202_d = -1;
    public int field_70203_e = -1;
    public int field_70200_f = -1;
    public int field_70201_g;
    public boolean field_70214_h;
    public int field_70206_a;
    public EntityPlayer field_70204_b;
    public int field_70216_i;
    public int field_70211_j;
    public int field_70219_an;
    public Entity field_70205_c;
    public int field_70217_ao;
    public double field_70218_ap;
    public double field_70210_aq;
    public double field_70209_ar;
    public double field_70208_as;
    public double field_70207_at;
    public double field_70215_au;
    public double field_70213_av;
    public double field_70212_aw;

    public EntityFishHook(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.25f, 0.25f);
        this.field_70158_ak = true;
    }

    public EntityFishHook(ozlu ozlu2, double d, double d2, double d3, EntityPlayer entityPlayer) {
        this(ozlu2);
        this.func_70107_b(d, d2, d3);
        this.field_70158_ak = true;
        this.field_70204_b = entityPlayer;
        entityPlayer.field_71104_cf = this;
    }

    public EntityFishHook(ozlu ozlu2, EntityPlayer entityPlayer) {
        super(ozlu2);
        this.field_70158_ak = true;
        this.field_70204_b = entityPlayer;
        this.field_70204_b.field_71104_cf = this;
        this.func_70105_a(0.25f, 0.25f);
        this.func_70012_b(entityPlayer.field_70165_t, entityPlayer.field_70163_u + 1.62 - (double)entityPlayer.field_70129_M, entityPlayer.field_70161_v, entityPlayer.field_70177_z, entityPlayer.field_70125_A);
        this.field_70165_t -= (double)(sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * 0.16f);
        this.field_70163_u -= (double)0.1f;
        this.field_70161_v -= (double)(sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * 0.16f);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70129_M = 0.0f;
        float f = 0.4f;
        this.field_70159_w = -sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI) * f;
        this.field_70179_y = sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI) * f;
        this.field_70181_x = -sajh._a(this.field_70125_A / 180.0f * (float)Math.PI) * f;
        this.func_70199_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, 1.5f, 1.0f);
    }

    @Override
    public void func_70088_a() {
    }

    @Override
    public boolean func_70112_a(double d) {
        double d2 = this.field_70121_D._b() * 4.0;
        return d < (d2 *= 64.0) * d2;
    }

    public void func_70199_c(double d, double d2, double d3, float f, float f2) {
        float f3 = sajh._a(d * d + d2 * d2 + d3 * d3);
        d /= (double)f3;
        d2 /= (double)f3;
        d3 /= (double)f3;
        d += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)f2;
        d2 += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)f2;
        d3 += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)f2;
        this.field_70159_w = d *= (double)f;
        this.field_70181_x = d2 *= (double)f;
        this.field_70179_y = d3 *= (double)f;
        float f4 = sajh._a(d * d + d3 * d3);
        this.field_70126_B = this.field_70177_z = (float)(Math.atan2(d, d3) * 180.0 / 3.1415927410125732);
        this.field_70127_C = this.field_70125_A = (float)(Math.atan2(d2, f4) * 180.0 / 3.1415927410125732);
        this.field_70216_i = 0;
    }

    @Override
    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
        this.field_70218_ap = d;
        this.field_70210_aq = d2;
        this.field_70209_ar = d3;
        this.field_70208_as = f;
        this.field_70207_at = f2;
        this.field_70217_ao = n;
        this.field_70159_w = this.field_70215_au;
        this.field_70181_x = this.field_70213_av;
        this.field_70179_y = this.field_70212_aw;
    }

    @Override
    public void func_70016_h(double d, double d2, double d3) {
        this.field_70215_au = this.field_70159_w = d;
        this.field_70213_av = this.field_70181_x = d2;
        this.field_70212_aw = this.field_70179_y = d3;
    }

    @Override
    public void func_70071_h_() {
        int n;
        double d;
        super.func_70071_h_();
        if (this.field_70217_ao > 0) {
            double d2 = this.field_70165_t + (this.field_70218_ap - this.field_70165_t) / (double)this.field_70217_ao;
            double d3 = this.field_70163_u + (this.field_70210_aq - this.field_70163_u) / (double)this.field_70217_ao;
            double d4 = this.field_70161_v + (this.field_70209_ar - this.field_70161_v) / (double)this.field_70217_ao;
            double d5 = sajh._f(this.field_70208_as - (double)this.field_70177_z);
            this.field_70177_z = (float)((double)this.field_70177_z + d5 / (double)this.field_70217_ao);
            this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70207_at - (double)this.field_70125_A) / (double)this.field_70217_ao);
            --this.field_70217_ao;
            this.func_70107_b(d2, d3, d4);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
            return;
        }
        if (!this.field_70170_p.field_72995_K) {
            cvzo cvzo2 = this.field_70204_b.func_71045_bC();
            if (this.field_70204_b.field_70128_L || !this.field_70204_b.func_70089_S() || cvzo2 == null || cvzo2._a() != tgdv.field_77749_aR || this.func_70068_e(this.field_70204_b) > 1024.0) {
                this.func_70106_y();
                this.field_70204_b.field_71104_cf = null;
                return;
            }
            if (this.field_70205_c != null) {
                if (this.field_70205_c.field_70128_L) {
                    this.field_70205_c = null;
                } else {
                    this.field_70165_t = this.field_70205_c.field_70165_t;
                    this.field_70163_u = this.field_70205_c.field_70121_D._c + (double)this.field_70205_c.field_70131_O * 0.8;
                    this.field_70161_v = this.field_70205_c.field_70161_v;
                    return;
                }
            }
        }
        if (this.field_70206_a > 0) {
            --this.field_70206_a;
        }
        if (this.field_70214_h) {
            int n2 = this.field_70170_p.func_72798_a(this.field_70202_d, this.field_70203_e, this.field_70200_f);
            if (n2 == this.field_70201_g) {
                ++this.field_70216_i;
                if (this.field_70216_i == 1200) {
                    this.func_70106_y();
                }
                return;
            }
            this.field_70214_h = false;
            this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
            this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
            this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
            this.field_70216_i = 0;
            this.field_70211_j = 0;
        } else {
            ++this.field_70211_j;
        }
        ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        hank hank2 = this.field_70170_p.func_72933_a(ofbx2, ofbx3);
        ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        if (hank2 != null) {
            ofbx3 = this.field_70170_p.func_82732_R()._a(hank2._h._c, hank2._h._d, hank2._h._e);
        }
        Entity entity = null;
        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D._a(this.field_70159_w, this.field_70181_x, this.field_70179_y)._b(1.0, 1.0, 1.0));
        double d6 = 0.0;
        for (int i = 0; i < list.size(); ++i) {
            float f;
            eidj eidj2;
            hank hank3;
            Entity entity2 = (Entity)list.get(i);
            if (!entity2.func_70067_L() || entity2 == this.field_70204_b && this.field_70211_j < 5 || (hank3 = (eidj2 = entity2.field_70121_D._b(f = 0.3f, f, f))._a(ofbx2, ofbx3)) == null || !((d = ofbx2._d(hank3._h)) < d6) && d6 != 0.0) continue;
            entity = entity2;
            d6 = d;
        }
        if (entity != null) {
            hank2 = new hank(entity);
        }
        if (hank2 != null) {
            if (hank2._i != null) {
                if (hank2._i.func_70097_a(jxtc.func_76356_a(this, this.field_70204_b), 0.0f)) {
                    this.field_70205_c = hank2._i;
                }
            } else {
                this.field_70214_h = true;
            }
        }
        if (this.field_70214_h) {
            return;
        }
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
        float f2 = 0.92f;
        if (this.field_70122_E || this.field_70123_F) {
            f2 = 0.5f;
        }
        int n3 = 5;
        double d7 = 0.0;
        for (n = 0; n < n3; ++n) {
            double d8 = this.field_70121_D._c + (this.field_70121_D._f - this.field_70121_D._c) * (double)(n + 0) / (double)n3 - 0.125 + 0.125;
            double d9 = this.field_70121_D._c + (this.field_70121_D._f - this.field_70121_D._c) * (double)(n + 1) / (double)n3 - 0.125 + 0.125;
            eidj eidj3 = eidj._a()._a(this.field_70121_D._b, d8, this.field_70121_D._d, this.field_70121_D._e, d9, this.field_70121_D._g);
            if (!this.field_70170_p.func_72830_b(eidj3, tflj._h)) continue;
            d7 += 1.0 / (double)n3;
        }
        if (d7 > 0.0) {
            if (this.field_70219_an > 0) {
                --this.field_70219_an;
            } else {
                n = 500;
                if (this.field_70170_p.func_72951_B(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u) + 1, sajh._c(this.field_70161_v))) {
                    n = 300;
                }
                if (this.field_70146_Z.nextInt(n) == 0) {
                    float f3;
                    float f4;
                    this.field_70219_an = this.field_70146_Z.nextInt(30) + 10;
                    this.field_70181_x -= (double)0.2f;
                    this.func_85030_a("random.splash", 0.25f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4f);
                    float f5 = sajh._c(this.field_70121_D._c);
                    int n4 = 0;
                    while ((float)n4 < 1.0f + this.field_70130_N * 20.0f) {
                        f4 = (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.field_70130_N;
                        f3 = (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.field_70130_N;
                        this.field_70170_p.func_72869_a("bubble", this.field_70165_t + (double)f4, f5 + 1.0f, this.field_70161_v + (double)f3, this.field_70159_w, this.field_70181_x - (double)(this.field_70146_Z.nextFloat() * 0.2f), this.field_70179_y);
                        ++n4;
                    }
                    n4 = 0;
                    while ((float)n4 < 1.0f + this.field_70130_N * 20.0f) {
                        f4 = (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.field_70130_N;
                        f3 = (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.field_70130_N;
                        this.field_70170_p.func_72869_a("splash", this.field_70165_t + (double)f4, f5 + 1.0f, this.field_70161_v + (double)f3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                        ++n4;
                    }
                }
            }
        }
        if (this.field_70219_an > 0) {
            this.field_70181_x -= (double)(this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat()) * 0.2;
        }
        d = d7 * 2.0 - 1.0;
        this.field_70181_x += (double)0.04f * d;
        if (d7 > 0.0) {
            f2 = (float)((double)f2 * 0.9);
            this.field_70181_x *= 0.8;
        }
        this.field_70159_w *= (double)f2;
        this.field_70181_x *= (double)f2;
        this.field_70179_y *= (double)f2;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("xTile", (short)this.field_70202_d);
        qoac2._a("yTile", (short)this.field_70203_e);
        qoac2._a("zTile", (short)this.field_70200_f);
        qoac2._a("inTile", (byte)this.field_70201_g);
        qoac2._a("shake", (byte)this.field_70206_a);
        qoac2._a("inGround", (byte)(this.field_70214_h ? 1 : 0));
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        this.field_70202_d = qoac2._e("xTile");
        this.field_70203_e = qoac2._e("yTile");
        this.field_70200_f = qoac2._e("zTile");
        this.field_70201_g = qoac2._d("inTile") & 0xFF;
        this.field_70206_a = qoac2._d("shake") & 0xFF;
        this.field_70214_h = qoac2._d("inGround") == 1;
    }

    @Override
    public float func_70053_R() {
        return 0.0f;
    }

    public int func_70198_d() {
        if (this.field_70170_p.field_72995_K) {
            return 0;
        }
        int n = 0;
        if (this.field_70205_c != null) {
            double d = this.field_70204_b.field_70165_t - this.field_70165_t;
            double d2 = this.field_70204_b.field_70163_u - this.field_70163_u;
            double d3 = this.field_70204_b.field_70161_v - this.field_70161_v;
            double d4 = sajh._a(d * d + d2 * d2 + d3 * d3);
            double d5 = 0.1;
            this.field_70205_c.field_70159_w += d * d5;
            this.field_70205_c.field_70181_x += d2 * d5 + (double)sajh._a(d4) * 0.08;
            this.field_70205_c.field_70179_y += d3 * d5;
            n = 3;
        } else if (this.field_70219_an > 0) {
            EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new cvzo(tgdv.field_77754_aU));
            double d = this.field_70204_b.field_70165_t - this.field_70165_t;
            double d6 = this.field_70204_b.field_70163_u - this.field_70163_u;
            double d7 = this.field_70204_b.field_70161_v - this.field_70161_v;
            double d8 = sajh._a(d * d + d6 * d6 + d7 * d7);
            double d9 = 0.1;
            entityItem.field_70159_w = d * d9;
            entityItem.field_70181_x = d6 * d9 + (double)sajh._a(d8) * 0.08;
            entityItem.field_70179_y = d7 * d9;
            this.field_70170_p.func_72838_d(entityItem);
            this.field_70204_b.func_71064_a(dzif._B, 1);
            this.field_70204_b.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70204_b.field_70170_p, this.field_70204_b.field_70165_t, this.field_70204_b.field_70163_u + 0.5, this.field_70204_b.field_70161_v + 0.5, this.field_70146_Z.nextInt(6) + 1));
            n = 1;
        }
        if (this.field_70214_h) {
            n = 2;
        }
        this.func_70106_y();
        this.field_70204_b.field_71104_cf = null;
        return n;
    }

    @Override
    public void func_70106_y() {
        super.func_70106_y();
        if (this.field_70204_b != null) {
            this.field_70204_b.field_71104_cf = null;
        }
    }
}

