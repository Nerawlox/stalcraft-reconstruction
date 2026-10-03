/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.boss;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.boss.eidj;
import net.minecraft.entity.ezfa;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class EntityDragon
extends EntityLiving
implements eidj,
ezfa,
ezey {
    public double field_70980_b;
    public double field_70981_c;
    public double field_70978_d;
    public double[][] field_70979_e = new double[64][3];
    public int field_70976_f = -1;
    public EntityDragonPart[] field_70977_g;
    public EntityDragonPart field_70986_h = new EntityDragonPart(this, "head", 6.0f, 6.0f);
    public EntityDragonPart field_70987_i = new EntityDragonPart(this, "body", 8.0f, 8.0f);
    public EntityDragonPart field_70985_j = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
    public EntityDragonPart field_70984_by = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
    public EntityDragonPart field_70982_bz = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
    public EntityDragonPart field_70983_bA = new EntityDragonPart(this, "wing", 4.0f, 4.0f);
    public EntityDragonPart field_70990_bB = new EntityDragonPart(this, "wing", 4.0f, 4.0f);
    public float field_70991_bC;
    public float field_70988_bD;
    public boolean field_70989_bE;
    public boolean field_70994_bF;
    public Entity field_70993_bI;
    public int field_70995_bG;
    public EntityEnderCrystal field_70992_bH;

    public EntityDragon(ozlu ozlu2) {
        super(ozlu2);
        this.field_70977_g = new EntityDragonPart[]{this.field_70986_h, this.field_70987_i, this.field_70985_j, this.field_70984_by, this.field_70982_bz, this.field_70983_bA, this.field_70990_bB};
        this.func_70606_j(this.func_110138_aP());
        this.func_70105_a(16.0f, 8.0f);
        this.field_70145_X = true;
        this.field_70178_ae = true;
        this.field_70981_c = 100.0;
        this.field_70158_ak = true;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(200.0);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
    }

    public double[] func_70974_a(int n, float f) {
        if (this.func_110143_aJ() <= 0.0f) {
            f = 0.0f;
        }
        f = 1.0f - f;
        int n2 = this.field_70976_f - n * 1 & 0x3F;
        int n3 = this.field_70976_f - n * 1 - 1 & 0x3F;
        double[] dArray = new double[3];
        double d = this.field_70979_e[n2][0];
        double d2 = sajh._f(this.field_70979_e[n3][0] - d);
        dArray[0] = d + d2 * (double)f;
        d = this.field_70979_e[n2][1];
        d2 = this.field_70979_e[n3][1] - d;
        dArray[1] = d + d2 * (double)f;
        dArray[2] = this.field_70979_e[n2][2] + (this.field_70979_e[n3][2] - this.field_70979_e[n2][2]) * (double)f;
        return dArray;
    }

    @Override
    public void func_70636_d() {
        float f;
        float f2;
        if (this.field_70170_p.field_72995_K) {
            f2 = sajh._b(this.field_70988_bD * (float)Math.PI * 2.0f);
            f = sajh._b(this.field_70991_bC * (float)Math.PI * 2.0f);
            if (f <= -0.3f && f2 >= -0.3f) {
                this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, "mob.enderdragon.wings", 5.0f, 0.8f + this.field_70146_Z.nextFloat() * 0.3f, false);
            }
        }
        this.field_70991_bC = this.field_70988_bD;
        if (this.func_110143_aJ() <= 0.0f) {
            f2 = (this.field_70146_Z.nextFloat() - 0.5f) * 8.0f;
            f = (this.field_70146_Z.nextFloat() - 0.5f) * 4.0f;
            float f3 = (this.field_70146_Z.nextFloat() - 0.5f) * 8.0f;
            this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (double)f2, this.field_70163_u + 2.0 + (double)f, this.field_70161_v + (double)f3, 0.0, 0.0, 0.0);
        } else {
            float f4;
            float f5;
            float f6;
            float f7;
            Object object;
            Object object2;
            float f8;
            double d;
            double d2;
            double d3;
            double d4;
            this.func_70969_j();
            f2 = 0.2f / (sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 10.0f + 1.0f);
            this.field_70988_bD = this.field_70994_bF ? (this.field_70988_bD += f2 * 0.5f) : (this.field_70988_bD += (f2 *= (float)Math.pow(2.0, this.field_70181_x)));
            this.field_70177_z = sajh._g(this.field_70177_z);
            if (this.field_70976_f < 0) {
                for (int i = 0; i < this.field_70979_e.length; ++i) {
                    this.field_70979_e[i][0] = this.field_70177_z;
                    this.field_70979_e[i][1] = this.field_70163_u;
                }
            }
            if (++this.field_70976_f == this.field_70979_e.length) {
                this.field_70976_f = 0;
            }
            this.field_70979_e[this.field_70976_f][0] = this.field_70177_z;
            this.field_70979_e[this.field_70976_f][1] = this.field_70163_u;
            if (this.field_70170_p.field_72995_K) {
                if (this.field_70716_bi > 0) {
                    d4 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / (double)this.field_70716_bi;
                    d3 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / (double)this.field_70716_bi;
                    d2 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / (double)this.field_70716_bi;
                    d = sajh._f(this.field_70712_bm - (double)this.field_70177_z);
                    this.field_70177_z = (float)((double)this.field_70177_z + d / (double)this.field_70716_bi);
                    this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70705_bn - (double)this.field_70125_A) / (double)this.field_70716_bi);
                    --this.field_70716_bi;
                    this.func_70107_b(d4, d3, d2);
                    this.func_70101_b(this.field_70177_z, this.field_70125_A);
                }
            } else {
                double d5;
                double d6;
                d4 = this.field_70980_b - this.field_70165_t;
                d3 = this.field_70981_c - this.field_70163_u;
                d2 = this.field_70978_d - this.field_70161_v;
                d = d4 * d4 + d3 * d3 + d2 * d2;
                if (this.field_70993_bI != null) {
                    this.field_70980_b = this.field_70993_bI.field_70165_t;
                    this.field_70978_d = this.field_70993_bI.field_70161_v;
                    d6 = this.field_70980_b - this.field_70165_t;
                    d5 = this.field_70978_d - this.field_70161_v;
                    double d7 = Math.sqrt(d6 * d6 + d5 * d5);
                    double d8 = (double)0.4f + d7 / 80.0 - 1.0;
                    if (d8 > 10.0) {
                        d8 = 10.0;
                    }
                    this.field_70981_c = this.field_70993_bI.field_70121_D._c + d8;
                } else {
                    this.field_70980_b += this.field_70146_Z.nextGaussian() * 2.0;
                    this.field_70978_d += this.field_70146_Z.nextGaussian() * 2.0;
                }
                if (this.field_70989_bE || d < 100.0 || d > 22500.0 || this.field_70123_F || this.field_70124_G) {
                    this.func_70967_k();
                }
                if ((d3 /= (double)sajh._a(d4 * d4 + d2 * d2)) < (double)(-(f8 = 0.6f))) {
                    d3 = -f8;
                }
                if (d3 > (double)f8) {
                    d3 = f8;
                }
                this.field_70181_x += d3 * (double)0.1f;
                this.field_70177_z = sajh._g(this.field_70177_z);
                d6 = 180.0 - Math.atan2(d4, d2) * 180.0 / Math.PI;
                d5 = sajh._f(d6 - (double)this.field_70177_z);
                if (d5 > 50.0) {
                    d5 = 50.0;
                }
                if (d5 < -50.0) {
                    d5 = -50.0;
                }
                object2 = this.field_70170_p.func_82732_R()._a(this.field_70980_b - this.field_70165_t, this.field_70981_c - this.field_70163_u, this.field_70978_d - this.field_70161_v)._a();
                object = this.field_70170_p.func_82732_R()._a(sajh._a(this.field_70177_z * (float)Math.PI / 180.0f), this.field_70181_x, -sajh._b(this.field_70177_z * (float)Math.PI / 180.0f))._a();
                f7 = (float)(((ofbx)object)._b((ofbx)object2) + 0.5) / 1.5f;
                if (f7 < 0.0f) {
                    f7 = 0.0f;
                }
                this.field_70704_bt *= 0.8f;
                float f9 = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 1.0f + 1.0f;
                double d9 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 1.0 + 1.0;
                if (d9 > 40.0) {
                    d9 = 40.0;
                }
                this.field_70704_bt = (float)((double)this.field_70704_bt + d5 * ((double)0.7f / d9 / (double)f9));
                this.field_70177_z += this.field_70704_bt * 0.1f;
                f6 = (float)(2.0 / (d9 + 1.0));
                f5 = 0.06f;
                this.func_70060_a(0.0f, -1.0f, f5 * (f7 * f6 + (1.0f - f6)));
                if (this.field_70994_bF) {
                    this.func_70091_d(this.field_70159_w * (double)0.8f, this.field_70181_x * (double)0.8f, this.field_70179_y * (double)0.8f);
                } else {
                    this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                }
                ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70159_w, this.field_70181_x, this.field_70179_y)._a();
                f4 = (float)(ofbx2._b((ofbx)object) + 1.0) / 2.0f;
                f4 = 0.8f + 0.15f * f4;
                this.field_70159_w *= (double)f4;
                this.field_70179_y *= (double)f4;
                this.field_70181_x *= (double)0.91f;
            }
            this.field_70761_aq = this.field_70177_z;
            this.field_70986_h.field_70131_O = 3.0f;
            this.field_70986_h.field_70130_N = 3.0f;
            this.field_70985_j.field_70131_O = 2.0f;
            this.field_70985_j.field_70130_N = 2.0f;
            this.field_70984_by.field_70131_O = 2.0f;
            this.field_70984_by.field_70130_N = 2.0f;
            this.field_70982_bz.field_70131_O = 2.0f;
            this.field_70982_bz.field_70130_N = 2.0f;
            this.field_70987_i.field_70131_O = 3.0f;
            this.field_70987_i.field_70130_N = 5.0f;
            this.field_70983_bA.field_70131_O = 2.0f;
            this.field_70983_bA.field_70130_N = 4.0f;
            this.field_70990_bB.field_70131_O = 3.0f;
            this.field_70990_bB.field_70130_N = 4.0f;
            f = (float)(this.func_70974_a(5, 1.0f)[1] - this.func_70974_a(10, 1.0f)[1]) * 10.0f / 180.0f * (float)Math.PI;
            float f10 = sajh._b(f);
            float f11 = -sajh._a(f);
            float f12 = this.field_70177_z * (float)Math.PI / 180.0f;
            float f13 = sajh._a(f12);
            float f14 = sajh._b(f12);
            this.field_70987_i.func_70071_h_();
            this.field_70987_i.func_70012_b(this.field_70165_t + (double)(f13 * 0.5f), this.field_70163_u, this.field_70161_v - (double)(f14 * 0.5f), 0.0f, 0.0f);
            this.field_70983_bA.func_70071_h_();
            this.field_70983_bA.func_70012_b(this.field_70165_t + (double)(f14 * 4.5f), this.field_70163_u + 2.0, this.field_70161_v + (double)(f13 * 4.5f), 0.0f, 0.0f);
            this.field_70990_bB.func_70071_h_();
            this.field_70990_bB.func_70012_b(this.field_70165_t - (double)(f14 * 4.5f), this.field_70163_u + 2.0, this.field_70161_v - (double)(f13 * 4.5f), 0.0f, 0.0f);
            if (!this.field_70170_p.field_72995_K && this.field_70737_aN == 0) {
                this.func_70970_a(this.field_70170_p.func_72839_b(this, this.field_70983_bA.field_70121_D._b(4.0, 2.0, 4.0)._d(0.0, -2.0, 0.0)));
                this.func_70970_a(this.field_70170_p.func_72839_b(this, this.field_70990_bB.field_70121_D._b(4.0, 2.0, 4.0)._d(0.0, -2.0, 0.0)));
                this.func_70971_b(this.field_70170_p.func_72839_b(this, this.field_70986_h.field_70121_D._b(1.0, 1.0, 1.0)));
            }
            object2 = this.func_70974_a(5, 1.0f);
            object = this.func_70974_a(0, 1.0f);
            f8 = sajh._a(this.field_70177_z * (float)Math.PI / 180.0f - this.field_70704_bt * 0.01f);
            f7 = sajh._b(this.field_70177_z * (float)Math.PI / 180.0f - this.field_70704_bt * 0.01f);
            this.field_70986_h.func_70071_h_();
            this.field_70986_h.func_70012_b(this.field_70165_t + (double)(f8 * 5.5f * f10), this.field_70163_u + (object[1] - object2[1]) * 1.0 + (double)(f11 * 5.5f), this.field_70161_v - (double)(f7 * 5.5f * f10), 0.0f, 0.0f);
            for (int i = 0; i < 3; ++i) {
                EntityDragonPart entityDragonPart = null;
                if (i == 0) {
                    entityDragonPart = this.field_70985_j;
                }
                if (i == 1) {
                    entityDragonPart = this.field_70984_by;
                }
                if (i == 2) {
                    entityDragonPart = this.field_70982_bz;
                }
                double[] dArray = this.func_70974_a(12 + i * 2, 1.0f);
                f6 = this.field_70177_z * (float)Math.PI / 180.0f + this.func_70973_b(dArray[0] - object2[0]) * (float)Math.PI / 180.0f * 1.0f;
                f5 = sajh._a(f6);
                float f15 = sajh._b(f6);
                f4 = 1.5f;
                float f16 = (float)(i + 1) * 2.0f;
                entityDragonPart.func_70071_h_();
                entityDragonPart.func_70012_b(this.field_70165_t - (double)((f13 * f4 + f5 * f16) * f10), this.field_70163_u + (dArray[1] - object2[1]) * 1.0 - (double)((f16 + f4) * f11) + 1.5, this.field_70161_v + (double)((f14 * f4 + f15 * f16) * f10), 0.0f, 0.0f);
            }
            if (!this.field_70170_p.field_72995_K) {
                this.field_70994_bF = this.func_70972_a(this.field_70986_h.field_70121_D) | this.func_70972_a(this.field_70987_i.field_70121_D);
            }
        }
    }

    public void func_70969_j() {
        if (this.field_70992_bH != null) {
            if (this.field_70992_bH.field_70128_L) {
                if (!this.field_70170_p.field_72995_K) {
                    this.func_70965_a(this.field_70986_h, jxtc.func_94539_a(null), 10.0f);
                }
                this.field_70992_bH = null;
            } else if (this.field_70173_aa % 10 == 0 && this.func_110143_aJ() < this.func_110138_aP()) {
                this.func_70606_j(this.func_110143_aJ() + 1.0f);
            }
        }
        if (this.field_70146_Z.nextInt(10) == 0) {
            float f = 32.0f;
            List list2 = this.field_70170_p.func_72872_a(EntityEnderCrystal.class, this.field_70121_D._b(f, f, f));
            EntityEnderCrystal entityEnderCrystal = null;
            double d = Double.MAX_VALUE;
            for (EntityEnderCrystal entityEnderCrystal2 : list2) {
                double d2 = entityEnderCrystal2.func_70068_e(this);
                if (!(d2 < d)) continue;
                d = d2;
                entityEnderCrystal = entityEnderCrystal2;
            }
            this.field_70992_bH = entityEnderCrystal;
        }
    }

    public void func_70970_a(List list2) {
        double d = (this.field_70987_i.field_70121_D._b + this.field_70987_i.field_70121_D._e) / 2.0;
        double d2 = (this.field_70987_i.field_70121_D._d + this.field_70987_i.field_70121_D._g) / 2.0;
        for (Entity entity : list2) {
            if (!(entity instanceof EntityLivingBase)) continue;
            double d3 = entity.field_70165_t - d;
            double d4 = entity.field_70161_v - d2;
            double d5 = d3 * d3 + d4 * d4;
            entity.func_70024_g(d3 / d5 * 4.0, 0.2f, d4 / d5 * 4.0);
        }
    }

    public void func_70971_b(List list2) {
        for (int i = 0; i < list2.size(); ++i) {
            Entity entity = (Entity)list2.get(i);
            if (!(entity instanceof EntityLivingBase)) continue;
            entity.func_70097_a(jxtc.func_76358_a(this), 10.0f);
        }
    }

    public void func_70967_k() {
        this.field_70989_bE = false;
        if (this.field_70146_Z.nextInt(2) == 0 && !this.field_70170_p.field_73010_i.isEmpty()) {
            this.field_70993_bI = (Entity)this.field_70170_p.field_73010_i.get(this.field_70146_Z.nextInt(this.field_70170_p.field_73010_i.size()));
        } else {
            double d;
            double d2;
            double d3;
            boolean bl = false;
            do {
                this.field_70980_b = 0.0;
                this.field_70981_c = 70.0f + this.field_70146_Z.nextFloat() * 50.0f;
                this.field_70978_d = 0.0;
                this.field_70980_b += (double)(this.field_70146_Z.nextFloat() * 120.0f - 60.0f);
                this.field_70978_d += (double)(this.field_70146_Z.nextFloat() * 120.0f - 60.0f);
            } while (!(bl = (d3 = this.field_70165_t - this.field_70980_b) * d3 + (d2 = this.field_70163_u - this.field_70981_c) * d2 + (d = this.field_70161_v - this.field_70978_d) * d > 100.0));
            this.field_70993_bI = null;
        }
    }

    public float func_70973_b(double d) {
        return (float)sajh._f(d);
    }

    public boolean func_70972_a(net.minecraft.util.eidj eidj2) {
        int n = sajh._c(eidj2._b);
        int n2 = sajh._c(eidj2._c);
        int n3 = sajh._c(eidj2._d);
        int n4 = sajh._c(eidj2._e);
        int n5 = sajh._c(eidj2._f);
        int n6 = sajh._c(eidj2._g);
        boolean bl = false;
        boolean bl2 = false;
        for (int i = n; i <= n4; ++i) {
            for (int j = n2; j <= n5; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    int n7 = this.field_70170_p.func_72798_a(i, j, k);
                    twgu twgu2 = twgu.field_71973_m[n7];
                    if (twgu2 == null) continue;
                    if (twgu2.canEntityDestroy(this.field_70170_p, i, j, k, this) && this.field_70170_p.func_82736_K()._b("mobGriefing")) {
                        bl2 = this.field_70170_p.func_94571_i(i, j, k) || bl2;
                        continue;
                    }
                    bl = true;
                }
            }
        }
        if (bl2) {
            double d = eidj2._b + (eidj2._e - eidj2._b) * (double)this.field_70146_Z.nextFloat();
            double d2 = eidj2._c + (eidj2._f - eidj2._c) * (double)this.field_70146_Z.nextFloat();
            double d3 = eidj2._d + (eidj2._g - eidj2._d) * (double)this.field_70146_Z.nextFloat();
            this.field_70170_p.func_72869_a("largeexplode", d, d2, d3, 0.0, 0.0, 0.0);
        }
        return bl;
    }

    @Override
    public boolean func_70965_a(EntityDragonPart entityDragonPart, jxtc jxtc2, float f) {
        if (entityDragonPart != this.field_70986_h) {
            f = f / 4.0f + 1.0f;
        }
        float f2 = this.field_70177_z * (float)Math.PI / 180.0f;
        float f3 = sajh._a(f2);
        float f4 = sajh._b(f2);
        this.field_70980_b = this.field_70165_t + (double)(f3 * 5.0f) + (double)((this.field_70146_Z.nextFloat() - 0.5f) * 2.0f);
        this.field_70981_c = this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * 3.0f) + 1.0;
        this.field_70978_d = this.field_70161_v - (double)(f4 * 5.0f) + (double)((this.field_70146_Z.nextFloat() - 0.5f) * 2.0f);
        this.field_70993_bI = null;
        if (jxtc2.func_76346_g() instanceof EntityPlayer || jxtc2.func_94541_c()) {
            this.func_82195_e(jxtc2, f);
        }
        return true;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        return false;
    }

    public boolean func_82195_e(jxtc jxtc2, float f) {
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public void func_70609_aI() {
        ++this.field_70995_bG;
        if (this.field_70995_bG >= 180 && this.field_70995_bG <= 200) {
            float f = (this.field_70146_Z.nextFloat() - 0.5f) * 8.0f;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5f) * 4.0f;
            float f3 = (this.field_70146_Z.nextFloat() - 0.5f) * 8.0f;
            this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + 2.0 + (double)f2, this.field_70161_v + (double)f3, 0.0, 0.0, 0.0);
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70995_bG > 150 && this.field_70995_bG % 5 == 0) {
                int n;
                for (int i = 1000; i > 0; i -= n) {
                    n = EntityXPOrb.func_70527_a(i);
                    this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, n));
                }
            }
            if (this.field_70995_bG == 1) {
                this.field_70170_p.func_82739_e(1018, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
            }
        }
        this.func_70091_d(0.0, 0.1f, 0.0);
        this.field_70761_aq = this.field_70177_z += 20.0f;
        if (this.field_70995_bG == 200 && !this.field_70170_p.field_72995_K) {
            int n;
            for (int i = 2000; i > 0; i -= n) {
                n = EntityXPOrb.func_70527_a(i);
                this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, n));
            }
            this.func_70975_a(sajh._c(this.field_70165_t), sajh._c(this.field_70161_v));
            this.func_70106_y();
        }
    }

    public void func_70975_a(int n, int n2) {
        int n3 = 64;
        klkp._a = true;
        int n4 = 4;
        for (int i = n3 - 1; i <= n3 + 32; ++i) {
            for (int j = n - n4; j <= n + n4; ++j) {
                for (int k = n2 - n4; k <= n2 + n4; ++k) {
                    double d = j - n;
                    double d2 = k - n2;
                    double d3 = d * d + d2 * d2;
                    if (!(d3 <= ((double)n4 - 0.5) * ((double)n4 - 0.5))) continue;
                    if (i < n3) {
                        if (!(d3 <= ((double)(n4 - 1) - 0.5) * ((double)(n4 - 1) - 0.5))) continue;
                        this.field_70170_p.func_94575_c(j, i, k, twgu.field_71986_z.field_71990_ca);
                        continue;
                    }
                    if (i > n3) {
                        this.field_70170_p.func_94575_c(j, i, k, 0);
                        continue;
                    }
                    if (d3 > ((double)(n4 - 1) - 0.5) * ((double)(n4 - 1) - 0.5)) {
                        this.field_70170_p.func_94575_c(j, i, k, twgu.field_71986_z.field_71990_ca);
                        continue;
                    }
                    this.field_70170_p.func_94575_c(j, i, k, twgu.field_72102_bH.field_71990_ca);
                }
            }
        }
        this.field_70170_p.func_94575_c(n, n3 + 0, n2, twgu.field_71986_z.field_71990_ca);
        this.field_70170_p.func_94575_c(n, n3 + 1, n2, twgu.field_71986_z.field_71990_ca);
        this.field_70170_p.func_94575_c(n, n3 + 2, n2, twgu.field_71986_z.field_71990_ca);
        this.field_70170_p.func_94575_c(n - 1, n3 + 2, n2, twgu.field_72069_aq.field_71990_ca);
        this.field_70170_p.func_94575_c(n + 1, n3 + 2, n2, twgu.field_72069_aq.field_71990_ca);
        this.field_70170_p.func_94575_c(n, n3 + 2, n2 - 1, twgu.field_72069_aq.field_71990_ca);
        this.field_70170_p.func_94575_c(n, n3 + 2, n2 + 1, twgu.field_72069_aq.field_71990_ca);
        this.field_70170_p.func_94575_c(n, n3 + 3, n2, twgu.field_71986_z.field_71990_ca);
        this.field_70170_p.func_94575_c(n, n3 + 4, n2, twgu.field_72084_bK.field_71990_ca);
        klkp._a = false;
    }

    @Override
    public void func_70623_bb() {
    }

    @Override
    public Entity[] func_70021_al() {
        return this.field_70977_g;
    }

    @Override
    public boolean func_70067_L() {
        return false;
    }

    @Override
    public ozlu func_82194_d() {
        return this.field_70170_p;
    }

    @Override
    public String func_70639_aQ() {
        return "mob.enderdragon.growl";
    }

    @Override
    public String func_70621_aR() {
        return "mob.enderdragon.hit";
    }

    @Override
    public float func_70599_aP() {
        return 5.0f;
    }
}

