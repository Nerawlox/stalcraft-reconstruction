/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.boss;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjui;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.boss.eidj;
import net.minecraft.entity.boss.pidb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tdmn;
import net.minecraft.entity.vjta;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityWither
extends EntityMob
implements eidj,
tdmn {
    public float[] field_82220_d = new float[2];
    public float[] field_82221_e = new float[2];
    public float[] field_82217_f = new float[2];
    public float[] field_82218_g = new float[2];
    public int[] field_82223_h = new int[2];
    public int[] field_82224_i = new int[2];
    public int field_82222_j;
    public static final zhos field_82219_bJ = new pidb();

    public EntityWither(ozlu ozlu2) {
        super(ozlu2);
        this.func_70606_j(this.func_110138_aP());
        this.func_70105_a(0.9f, 4.0f);
        this.field_70178_ae = true;
        this.func_70661_as()._e(true);
        this.field_70714_bg._a(0, new tdpx(this));
        this.field_70714_bg._a(2, new kjui(this, 1.0, 40, 20.0f));
        this.field_70714_bg._a(5, new iurn(this, 1.0));
        this.field_70714_bg._a(6, new iurq(this, EntityPlayer.class, 8.0f));
        this.field_70714_bg._a(7, new net.minecraft.entity.ai.tdmn(this));
        this.field_70715_bh._a(1, new ezfa(this, false));
        this.field_70715_bh._a(2, new pibk(this, EntityLiving.class, 0, false, false, field_82219_bJ));
        this.field_70728_aV = 50;
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(17, new Integer(0));
        this.field_70180_af._a(18, new Integer(0));
        this.field_70180_af._a(19, new Integer(0));
        this.field_70180_af._a(20, new Integer(0));
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("Invul", this.func_82212_n());
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.func_82215_s(qoac2._f("Invul"));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float func_70053_R() {
        return this.field_70131_O / 8.0f;
    }

    @Override
    public String func_70639_aQ() {
        return "mob.wither.idle";
    }

    @Override
    public String func_70621_aR() {
        return "mob.wither.hurt";
    }

    @Override
    public String func_70673_aS() {
        return "mob.wither.death";
    }

    @Override
    public void func_70636_d() {
        double d;
        double d2;
        double d3;
        int n;
        int n2;
        double d4;
        double d5;
        double d6;
        Entity entity;
        this.field_70181_x *= (double)0.6f;
        if (!this.field_70170_p.field_72995_K && this.func_82203_t(0) > 0 && (entity = this.field_70170_p.func_73045_a(this.func_82203_t(0))) != null) {
            double d7;
            if (this.field_70163_u < entity.field_70163_u || !this.func_82205_o() && this.field_70163_u < entity.field_70163_u + 5.0) {
                if (this.field_70181_x < 0.0) {
                    this.field_70181_x = 0.0;
                }
                this.field_70181_x += (0.5 - this.field_70181_x) * (double)0.6f;
            }
            if ((d6 = (d7 = entity.field_70165_t - this.field_70165_t) * d7 + (d5 = entity.field_70161_v - this.field_70161_v) * d5) > 9.0) {
                d4 = sajh._a(d6);
                this.field_70159_w += (d7 / d4 * 0.5 - this.field_70159_w) * (double)0.6f;
                this.field_70179_y += (d5 / d4 * 0.5 - this.field_70179_y) * (double)0.6f;
            }
        }
        if (this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > (double)0.05f) {
            this.field_70177_z = (float)Math.atan2(this.field_70179_y, this.field_70159_w) * 57.295776f - 90.0f;
        }
        super.func_70636_d();
        for (n2 = 0; n2 < 2; ++n2) {
            this.field_82218_g[n2] = this.field_82221_e[n2];
            this.field_82217_f[n2] = this.field_82220_d[n2];
        }
        for (n2 = 0; n2 < 2; ++n2) {
            n = this.func_82203_t(n2 + 1);
            Entity entity2 = null;
            if (n > 0) {
                entity2 = this.field_70170_p.func_73045_a(n);
            }
            if (entity2 != null) {
                d5 = this.func_82214_u(n2 + 1);
                d6 = this.func_82208_v(n2 + 1);
                d4 = this.func_82213_w(n2 + 1);
                d3 = entity2.field_70165_t - d5;
                d2 = entity2.field_70163_u + (double)entity2.func_70047_e() - d6;
                d = entity2.field_70161_v - d4;
                double d8 = sajh._a(d3 * d3 + d * d);
                float f = (float)(Math.atan2(d, d3) * 180.0 / Math.PI) - 90.0f;
                float f2 = (float)(-(Math.atan2(d2, d8) * 180.0 / Math.PI));
                this.field_82220_d[n2] = this.func_82204_b(this.field_82220_d[n2], f2, 40.0f);
                this.field_82221_e[n2] = this.func_82204_b(this.field_82221_e[n2], f, 10.0f);
                continue;
            }
            this.field_82221_e[n2] = this.func_82204_b(this.field_82221_e[n2], this.field_70761_aq, 10.0f);
        }
        boolean bl = this.func_82205_o();
        for (n = 0; n < 3; ++n) {
            d3 = this.func_82214_u(n);
            d2 = this.func_82208_v(n);
            d = this.func_82213_w(n);
            this.field_70170_p.func_72869_a("smoke", d3 + this.field_70146_Z.nextGaussian() * (double)0.3f, d2 + this.field_70146_Z.nextGaussian() * (double)0.3f, d + this.field_70146_Z.nextGaussian() * (double)0.3f, 0.0, 0.0, 0.0);
            if (!bl || this.field_70170_p.field_73012_v.nextInt(4) != 0) continue;
            this.field_70170_p.func_72869_a("mobSpell", d3 + this.field_70146_Z.nextGaussian() * (double)0.3f, d2 + this.field_70146_Z.nextGaussian() * (double)0.3f, d + this.field_70146_Z.nextGaussian() * (double)0.3f, 0.7f, 0.7f, 0.5);
        }
        if (this.func_82212_n() > 0) {
            for (n = 0; n < 3; ++n) {
                this.field_70170_p.func_72869_a("mobSpell", this.field_70165_t + this.field_70146_Z.nextGaussian() * 1.0, this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * 3.3f), this.field_70161_v + this.field_70146_Z.nextGaussian() * 1.0, 0.7f, 0.7f, 0.9f);
            }
        }
    }

    @Override
    public void func_70619_bc() {
        if (this.func_82212_n() > 0) {
            int n = this.func_82212_n() - 1;
            if (n <= 0) {
                this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v, 7.0f, false, this.field_70170_p.func_82736_K()._b("mobGriefing"));
                this.field_70170_p.func_82739_e(1013, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
            }
            this.func_82215_s(n);
            if (this.field_70173_aa % 10 == 0) {
                this.func_70691_i(10.0f);
            }
        } else {
            int n;
            int n2;
            int n3;
            super.func_70619_bc();
            block0: for (n3 = 1; n3 < 3; ++n3) {
                Object object;
                if (this.field_70173_aa < this.field_82223_h[n3 - 1]) continue;
                this.field_82223_h[n3 - 1] = this.field_70173_aa + 10 + this.field_70146_Z.nextInt(10);
                if (this.field_70170_p.field_73013_u >= 2) {
                    int n4 = n3 - 1;
                    n2 = this.field_82224_i[n3 - 1];
                    this.field_82224_i[n4] = this.field_82224_i[n3 - 1] + 1;
                    if (n2 > 15) {
                        float f = 10.0f;
                        float f2 = 5.0f;
                        double d = sajh._a(this.field_70146_Z, this.field_70165_t - (double)f, this.field_70165_t + (double)f);
                        double d2 = sajh._a(this.field_70146_Z, this.field_70163_u - (double)f2, this.field_70163_u + (double)f2);
                        double d3 = sajh._a(this.field_70146_Z, this.field_70161_v - (double)f, this.field_70161_v + (double)f);
                        this.func_82209_a(n3 + 1, d, d2, d3, true);
                        this.field_82224_i[n3 - 1] = 0;
                    }
                }
                if ((n = this.func_82203_t(n3)) > 0) {
                    object = this.field_70170_p.func_73045_a(n);
                    if (object != null && ((Entity)object).func_70089_S() && this.func_70068_e((Entity)object) <= 900.0 && this.func_70685_l((Entity)object)) {
                        this.func_82216_a(n3 + 1, (EntityLivingBase)object);
                        this.field_82223_h[n3 - 1] = this.field_70173_aa + 40 + this.field_70146_Z.nextInt(20);
                        this.field_82224_i[n3 - 1] = 0;
                        continue;
                    }
                    this.func_82211_c(n3, 0);
                    continue;
                }
                object = this.field_70170_p.func_82733_a(EntityLivingBase.class, this.field_70121_D._b(20.0, 8.0, 20.0), field_82219_bJ);
                for (n2 = 0; n2 < 10 && !object.isEmpty(); ++n2) {
                    EntityLivingBase entityLivingBase = (EntityLivingBase)object.get(this.field_70146_Z.nextInt(object.size()));
                    if (entityLivingBase != this && entityLivingBase.func_70089_S() && this.func_70685_l(entityLivingBase)) {
                        if (entityLivingBase instanceof EntityPlayer) {
                            if (((EntityPlayer)entityLivingBase).field_71075_bZ._a) continue block0;
                            this.func_82211_c(n3, entityLivingBase.field_70157_k);
                            continue block0;
                        }
                        this.func_82211_c(n3, entityLivingBase.field_70157_k);
                        continue block0;
                    }
                    object.remove(entityLivingBase);
                }
            }
            if (this.func_70638_az() != null) {
                this.func_82211_c(0, this.func_70638_az().field_70157_k);
            } else {
                this.func_82211_c(0, 0);
            }
            if (this.field_82222_j > 0) {
                --this.field_82222_j;
                if (this.field_82222_j == 0 && this.field_70170_p.func_82736_K()._b("mobGriefing")) {
                    n3 = sajh._c(this.field_70163_u);
                    n = sajh._c(this.field_70165_t);
                    int n5 = sajh._c(this.field_70161_v);
                    n2 = 0;
                    for (int i = -1; i <= 1; ++i) {
                        for (int j = -1; j <= 1; ++j) {
                            for (int k = 0; k <= 3; ++k) {
                                int n6 = n + i;
                                int n7 = n3 + k;
                                int n8 = n5 + j;
                                int n9 = this.field_70170_p.func_72798_a(n6, n7, n8);
                                twgu twgu2 = twgu.field_71973_m[n9];
                                if (twgu2 == null || !twgu2.canEntityDestroy(this.field_70170_p, n6, n7, n8, this)) continue;
                                n2 = this.field_70170_p.func_94578_a(n6, n7, n8, true) || n2 != 0 ? 1 : 0;
                            }
                        }
                    }
                    if (n2 != 0) {
                        this.field_70170_p.func_72889_a(null, 1012, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                    }
                }
            }
            if (this.field_70173_aa % 20 == 0) {
                this.func_70691_i(1.0f);
            }
        }
    }

    public void func_82206_m() {
        this.func_82215_s(220);
        this.func_70606_j(this.func_110138_aP() / 3.0f);
    }

    @Override
    public void func_70110_aj() {
    }

    @Override
    public int func_70658_aO() {
        return 4;
    }

    public double func_82214_u(int n) {
        if (n <= 0) {
            return this.field_70165_t;
        }
        float f = (this.field_70761_aq + (float)(180 * (n - 1))) / 180.0f * (float)Math.PI;
        float f2 = sajh._b(f);
        return this.field_70165_t + (double)f2 * 1.3;
    }

    public double func_82208_v(int n) {
        return n <= 0 ? this.field_70163_u + 3.0 : this.field_70163_u + 2.2;
    }

    public double func_82213_w(int n) {
        if (n <= 0) {
            return this.field_70161_v;
        }
        float f = (this.field_70761_aq + (float)(180 * (n - 1))) / 180.0f * (float)Math.PI;
        float f2 = sajh._a(f);
        return this.field_70161_v + (double)f2 * 1.3;
    }

    public float func_82204_b(float f, float f2, float f3) {
        float f4 = sajh._g(f2 - f);
        if (f4 > f3) {
            f4 = f3;
        }
        if (f4 < -f3) {
            f4 = -f3;
        }
        return f + f4;
    }

    public void func_82216_a(int n, EntityLivingBase entityLivingBase) {
        this.func_82209_a(n, entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e() * 0.5, entityLivingBase.field_70161_v, n == 0 && this.field_70146_Z.nextFloat() < 0.001f);
    }

    public void func_82209_a(int n, double d, double d2, double d3, boolean bl) {
        this.field_70170_p.func_72889_a(null, 1014, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        double d4 = this.func_82214_u(n);
        double d5 = this.func_82208_v(n);
        double d6 = this.func_82213_w(n);
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        EntityWitherSkull entityWitherSkull = new EntityWitherSkull(this.field_70170_p, this, d7, d8, d9);
        if (bl) {
            entityWitherSkull.func_82343_e(true);
        }
        entityWitherSkull.field_70163_u = d5;
        entityWitherSkull.field_70165_t = d4;
        entityWitherSkull.field_70161_v = d6;
        this.field_70170_p.func_72838_d(entityWitherSkull);
    }

    @Override
    public void func_82196_d(EntityLivingBase entityLivingBase, float f) {
        this.func_82216_a(0, entityLivingBase);
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        Entity entity;
        if (this.func_85032_ar()) {
            return false;
        }
        if (jxtc2 == jxtc.field_76369_e) {
            return false;
        }
        if (this.func_82212_n() > 0) {
            return false;
        }
        if (this.func_82205_o() && (entity = jxtc2.func_76364_f()) instanceof EntityArrow) {
            return false;
        }
        entity = jxtc2.func_76346_g();
        if (entity != null && !(entity instanceof EntityPlayer) && entity instanceof EntityLivingBase && ((EntityLivingBase)entity).func_70668_bt() == this.func_70668_bt()) {
            return false;
        }
        if (this.field_82222_j <= 0) {
            this.field_82222_j = 20;
        }
        int n = 0;
        while (n < this.field_82224_i.length) {
            int n2 = n++;
            this.field_82224_i[n2] = this.field_82224_i[n2] + 3;
        }
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        this.func_70025_b(tgdv.field_82792_bS.field_77779_bT, 1);
    }

    @Override
    public void func_70623_bb() {
        this.field_70708_bq = 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_70070_b(float f) {
        return 0xF000F0;
    }

    @Override
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }

    @Override
    public void func_70069_a(float f) {
    }

    @Override
    public void func_70690_d(supr supr2) {
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(300.0);
        this.func_110148_a(sajz._d)._a(0.6f);
        this.func_110148_a(sajz._b)._a(40.0);
    }

    @SideOnly(value=Side.CLIENT)
    public float func_82207_a(int n) {
        return this.field_82221_e[n];
    }

    @SideOnly(value=Side.CLIENT)
    public float func_82210_r(int n) {
        return this.field_82220_d[n];
    }

    public int func_82212_n() {
        return this.field_70180_af._c(20);
    }

    public void func_82215_s(int n) {
        this.field_70180_af._b(20, n);
    }

    public int func_82203_t(int n) {
        return this.field_70180_af._c(17 + n);
    }

    public void func_82211_c(int n, int n2) {
        this.field_70180_af._b(17 + n, n2);
    }

    public boolean func_82205_o() {
        return this.func_110143_aJ() <= this.func_110138_aP() / 2.0f;
    }

    @Override
    public vjta func_70668_bt() {
        return vjta._b;
    }

    @Override
    public void func_70078_a(Entity entity) {
        this.field_70154_o = null;
    }
}

