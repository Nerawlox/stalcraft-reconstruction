/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.amww;
import net.minecraft.entity.ai.eifc;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.pzde;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.ugqi;
import net.minecraft.entity.ai.wmvj;
import net.minecraft.entity.ai.zwaw;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityWolf
extends EntityTameable {
    public float field_70926_e;
    public float field_70924_f;
    public boolean field_70925_g;
    public boolean field_70928_h;
    public float field_70929_i;
    public float field_70927_j;

    public EntityWolf(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.6f, 0.8f);
        this.func_70661_as()._a(true);
        this.field_70714_bg._a(1, new tdpx(this));
        this.field_70714_bg._a(2, this.field_70911_d);
        this.field_70714_bg._a(3, new amww(this, 0.4f));
        this.field_70714_bg._a(4, new pidb(this, 1.0, true));
        this.field_70714_bg._a(5, new ugqi(this, 1.0, 10.0f, 2.0f));
        this.field_70714_bg._a(6, new srli(this, 1.0));
        this.field_70714_bg._a(7, new iurn(this, 1.0));
        this.field_70714_bg._a(8, new zwaw(this, 8.0f));
        this.field_70714_bg._a(9, new iurq(this, EntityPlayer.class, 8.0f));
        this.field_70714_bg._a(9, new tdmn(this));
        this.field_70715_bh._a(1, new wmvj(this));
        this.field_70715_bh._a(2, new pzde(this));
        this.field_70715_bh._a(3, new ezfa(this, true));
        this.field_70715_bh._a(4, new eifc(this, EntitySheep.class, 200, false));
        this.func_70903_f(false);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._d)._a(0.3f);
        if (this.func_70909_n()) {
            this.func_110148_a(sajz._a)._a(20.0);
        } else {
            this.func_110148_a(sajz._a)._a(8.0);
        }
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_70624_b(EntityLivingBase entityLivingBase) {
        super.func_70624_b(entityLivingBase);
        if (entityLivingBase == null) {
            this.func_70916_h(false);
        } else if (!this.func_70909_n()) {
            this.func_70916_h(true);
        }
    }

    @Override
    public void func_70629_bd() {
        this.field_70180_af._b(18, Float.valueOf(this.func_110143_aJ()));
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(18, new Float(this.func_110143_aJ()));
        this.field_70180_af._a(19, new Byte(0));
        this.field_70180_af._a(20, new Byte((byte)uziv._a(1)));
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.wolf.step", 0.15f, 1.0f);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("Angry", this.func_70919_bu());
        qoac2._a("CollarColor", (byte)this.func_82186_bH());
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.func_70916_h(qoac2._o("Angry"));
        if (qoac2._c("CollarColor")) {
            this.func_82185_r(qoac2._d("CollarColor"));
        }
    }

    @Override
    public String func_70639_aQ() {
        if (this.func_70919_bu()) {
            return "mob.wolf.growl";
        }
        if (this.field_70146_Z.nextInt(3) == 0) {
            if (this.func_70909_n() && this.field_70180_af._d(18) < 10.0f) {
                return "mob.wolf.whine";
            }
            return "mob.wolf.panting";
        }
        return "mob.wolf.bark";
    }

    @Override
    public String func_70621_aR() {
        return "mob.wolf.hurt";
    }

    @Override
    public String func_70673_aS() {
        return "mob.wolf.death";
    }

    @Override
    public float func_70599_aP() {
        return 0.4f;
    }

    @Override
    public int func_70633_aT() {
        return -1;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70925_g && !this.field_70928_h && !this.func_70781_l() && this.field_70122_E) {
            this.field_70928_h = true;
            this.field_70929_i = 0.0f;
            this.field_70927_j = 0.0f;
            this.field_70170_p.func_72960_a(this, (byte)8);
        }
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70924_f = this.field_70926_e;
        this.field_70926_e = this.func_70922_bv() ? (this.field_70926_e += (1.0f - this.field_70926_e) * 0.4f) : (this.field_70926_e += (0.0f - this.field_70926_e) * 0.4f);
        if (this.func_70922_bv()) {
            this.field_70700_bx = 10;
        }
        if (this.func_70026_G()) {
            this.field_70925_g = true;
            this.field_70928_h = false;
            this.field_70929_i = 0.0f;
            this.field_70927_j = 0.0f;
        } else if ((this.field_70925_g || this.field_70928_h) && this.field_70928_h) {
            if (this.field_70929_i == 0.0f) {
                this.func_85030_a("mob.wolf.shake", this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
            }
            this.field_70927_j = this.field_70929_i;
            this.field_70929_i += 0.05f;
            if (this.field_70927_j >= 2.0f) {
                this.field_70925_g = false;
                this.field_70928_h = false;
                this.field_70927_j = 0.0f;
                this.field_70929_i = 0.0f;
            }
            if (this.field_70929_i > 0.4f) {
                float f = (float)this.field_70121_D._c;
                int n = (int)(sajh._a((this.field_70929_i - 0.4f) * (float)Math.PI) * 7.0f);
                for (int i = 0; i < n; ++i) {
                    float f2 = (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.field_70130_N * 0.5f;
                    float f3 = (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.field_70130_N * 0.5f;
                    this.field_70170_p.func_72869_a("splash", this.field_70165_t + (double)f2, f + 0.8f, this.field_70161_v + (double)f3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                }
            }
        }
    }

    public boolean func_70921_u() {
        return this.field_70925_g;
    }

    public float func_70915_j(float f) {
        return 0.75f + (this.field_70927_j + (this.field_70929_i - this.field_70927_j) * f) / 2.0f * 0.25f;
    }

    public float func_70923_f(float f, float f2) {
        float f3 = (this.field_70927_j + (this.field_70929_i - this.field_70927_j) * f + f2) / 1.8f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        return sajh._a(f3 * (float)Math.PI) * sajh._a(f3 * (float)Math.PI * 11.0f) * 0.15f * (float)Math.PI;
    }

    public float func_70917_k(float f) {
        return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * f) * 0.15f * (float)Math.PI;
    }

    @Override
    public float func_70047_e() {
        return this.field_70131_O * 0.8f;
    }

    @Override
    public int func_70646_bf() {
        if (this.func_70906_o()) {
            return 20;
        }
        return super.func_70646_bf();
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        Entity entity = jxtc2.func_76346_g();
        this.field_70911_d._a(false);
        if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
            f = (f + 1.0f) / 2.0f;
        }
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public boolean func_70652_k(Entity entity) {
        int n = this.func_70909_n() ? 4 : 2;
        return entity.func_70097_a(jxtc.func_76358_a(this), n);
    }

    @Override
    public void func_70903_f(boolean bl) {
        super.func_70903_f(bl);
        if (bl) {
            this.func_110148_a(sajz._a)._a(20.0);
        } else {
            this.func_110148_a(sajz._a)._a(8.0);
        }
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (this.func_70909_n()) {
            if (cvzo2 != null) {
                int n;
                if (tgdv.field_77698_e[cvzo2._d] instanceof tgha) {
                    tgha tgha2 = (tgha)tgdv.field_77698_e[cvzo2._d];
                    if (tgha2.func_77845_h() && this.field_70180_af._d(18) < 20.0f) {
                        if (!entityPlayer.field_71075_bZ._d) {
                            --cvzo2._b;
                        }
                        this.func_70691_i(tgha2.func_77847_f());
                        if (cvzo2._b <= 0) {
                            entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
                        }
                        return true;
                    }
                } else if (cvzo2._d == tgdv.field_77756_aW.field_77779_bT && (n = uziv._a(cvzo2._j())) != this.func_82186_bH()) {
                    this.func_82185_r(n);
                    if (!entityPlayer.field_71075_bZ._d && --cvzo2._b <= 0) {
                        entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
                    }
                    return true;
                }
            }
            if (entityPlayer.func_70005_c_().equalsIgnoreCase(this.func_70905_p()) && !this.field_70170_p.field_72995_K && !this.func_70877_b(cvzo2)) {
                this.field_70911_d._a(!this.func_70906_o());
                this.field_70703_bu = false;
                this.func_70778_a(null);
                this.func_70784_b(null);
                this.func_70624_b(null);
            }
        } else if (cvzo2 != null && cvzo2._d == tgdv.field_77755_aX.field_77779_bT && !this.func_70919_bu()) {
            if (!entityPlayer.field_71075_bZ._d) {
                --cvzo2._b;
            }
            if (cvzo2._b <= 0) {
                entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
            }
            if (!this.field_70170_p.field_72995_K) {
                if (this.field_70146_Z.nextInt(3) == 0) {
                    this.func_70903_f(true);
                    this.func_70778_a(null);
                    this.func_70624_b(null);
                    this.field_70911_d._a(true);
                    this.func_70606_j(20.0f);
                    this.func_70910_a(entityPlayer.func_70005_c_());
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a(this, (byte)7);
                } else {
                    this.func_70908_e(false);
                    this.field_70170_p.func_72960_a(this, (byte)6);
                }
            }
            return true;
        }
        return super.func_70085_c(entityPlayer);
    }

    @Override
    public void func_70103_a(byte by) {
        if (by == 8) {
            this.field_70928_h = true;
            this.field_70929_i = 0.0f;
            this.field_70927_j = 0.0f;
        } else {
            super.func_70103_a(by);
        }
    }

    public float func_70920_v() {
        if (this.func_70919_bu()) {
            return 1.5393804f;
        }
        if (this.func_70909_n()) {
            return (0.55f - (20.0f - this.field_70180_af._d(18)) * 0.02f) * (float)Math.PI;
        }
        return 0.62831855f;
    }

    @Override
    public boolean func_70877_b(cvzo cvzo2) {
        if (cvzo2 == null) {
            return false;
        }
        if (!(tgdv.field_77698_e[cvzo2._d] instanceof tgha)) {
            return false;
        }
        return ((tgha)tgdv.field_77698_e[cvzo2._d]).func_77845_h();
    }

    @Override
    public int func_70641_bl() {
        return 8;
    }

    public boolean func_70919_bu() {
        return (this.field_70180_af._a(16) & 2) != 0;
    }

    public void func_70916_h(boolean bl) {
        byte by = this.field_70180_af._a(16);
        if (bl) {
            this.field_70180_af._b(16, (byte)(by | 2));
        } else {
            this.field_70180_af._b(16, (byte)(by & 0xFFFFFFFD));
        }
    }

    public int func_82186_bH() {
        return this.field_70180_af._a(20) & 0xF;
    }

    public void func_82185_r(int n) {
        this.field_70180_af._b(20, (byte)(n & 0xF));
    }

    public EntityWolf func_70879_a(EntityAgeable entityAgeable) {
        EntityWolf entityWolf = new EntityWolf(this.field_70170_p);
        String string = this.func_70905_p();
        if (string != null && string.trim().length() > 0) {
            entityWolf.func_70910_a(string);
            entityWolf.func_70903_f(true);
        }
        return entityWolf;
    }

    public void func_70918_i(boolean bl) {
        if (bl) {
            this.field_70180_af._b(19, (byte)1);
        } else {
            this.field_70180_af._b(19, (byte)0);
        }
    }

    @Override
    public boolean func_70878_b(EntityAnimal entityAnimal) {
        if (entityAnimal == this) {
            return false;
        }
        if (!this.func_70909_n()) {
            return false;
        }
        if (!(entityAnimal instanceof EntityWolf)) {
            return false;
        }
        EntityWolf entityWolf = (EntityWolf)entityAnimal;
        if (!entityWolf.func_70909_n()) {
            return false;
        }
        if (entityWolf.func_70906_o()) {
            return false;
        }
        return this.func_70880_s() && entityWolf.func_70880_s();
    }

    public boolean func_70922_bv() {
        return this.field_70180_af._a(19) == 1;
    }

    @Override
    public boolean func_70692_ba() {
        return !this.func_70909_n() && this.field_70173_aa > 2400;
    }

    @Override
    public boolean func_142018_a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        EntityWolf entityWolf;
        if (entityLivingBase instanceof EntityCreeper || entityLivingBase instanceof EntityGhast) {
            return false;
        }
        if (entityLivingBase instanceof EntityWolf && (entityWolf = (EntityWolf)entityLivingBase).func_70909_n() && entityWolf.func_130012_q() == entityLivingBase2) {
            return false;
        }
        if (entityLivingBase instanceof EntityPlayer && entityLivingBase2 instanceof EntityPlayer && !((EntityPlayer)entityLivingBase2).func_96122_a((EntityPlayer)entityLivingBase)) {
            return false;
        }
        return !(entityLivingBase instanceof EntityHorse) || !((EntityHorse)entityLivingBase).func_110248_bS();
    }

    @Override
    public /* synthetic */ EntityAgeable func_90011_a(EntityAgeable entityAgeable) {
        return this.func_70879_a(entityAgeable);
    }
}

