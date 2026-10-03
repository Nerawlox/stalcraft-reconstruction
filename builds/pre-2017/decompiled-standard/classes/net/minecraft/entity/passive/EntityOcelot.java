/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.amww;
import net.minecraft.entity.ai.eidj;
import net.minecraft.entity.ai.eifc;
import net.minecraft.entity.ai.ezhm;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.ugqi;
import net.minecraft.entity.ai.ybzs;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tupg;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityOcelot
extends EntityTameable {
    public ezhm field_70914_e;

    public EntityOcelot(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.6f, 0.8f);
        this.func_70661_as()._a(true);
        this.field_70714_bg._a(1, new tdpx(this));
        this.field_70714_bg._a(2, this.field_70911_d);
        this.field_70914_e = new ezhm(this, 0.6, tgdv.field_77754_aU.field_77779_bT, true);
        this.field_70714_bg._a(3, this.field_70914_e);
        this.field_70714_bg._a(4, new eidj(this, EntityPlayer.class, 16.0f, 0.8, 1.33));
        this.field_70714_bg._a(5, new ugqi(this, 1.0, 10.0f, 5.0f));
        this.field_70714_bg._a(6, new ybzs(this, 1.33));
        this.field_70714_bg._a(7, new amww(this, 0.3f));
        this.field_70714_bg._a(8, new net.minecraft.entity.ai.sajh(this));
        this.field_70714_bg._a(9, new srli(this, 0.8));
        this.field_70714_bg._a(10, new iurn(this, 0.8));
        this.field_70714_bg._a(11, new iurq(this, EntityPlayer.class, 10.0f));
        this.field_70715_bh._a(1, new eifc(this, EntityChicken.class, 750, false));
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(18, (Object)0);
    }

    @Override
    public void func_70629_bd() {
        if (this.func_70605_aq()._a()) {
            double d = this.func_70605_aq()._b();
            if (d == 0.6) {
                this.func_70095_a(true);
                this.func_70031_b(false);
            } else if (d == 1.33) {
                this.func_70095_a(false);
                this.func_70031_b(true);
            } else {
                this.func_70095_a(false);
                this.func_70031_b(false);
            }
        } else {
            this.func_70095_a(false);
            this.func_70031_b(false);
        }
    }

    @Override
    public boolean func_70692_ba() {
        return !this.func_70909_n() && this.field_70173_aa > 2400;
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(10.0);
        this.func_110148_a(sajz._d)._a(0.3f);
    }

    @Override
    public void func_70069_a(float f) {
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("CatType", this.func_70913_u());
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.func_70912_b(qoac2._f("CatType"));
    }

    @Override
    public String func_70639_aQ() {
        return this.func_70909_n() ? (this.func_70880_s() ? "mob.cat.purr" : (this.field_70146_Z.nextInt(4) == 0 ? "mob.cat.purreow" : "mob.cat.meow")) : "";
    }

    @Override
    public String func_70621_aR() {
        return "mob.cat.hitt";
    }

    @Override
    public String func_70673_aS() {
        return "mob.cat.hitt";
    }

    @Override
    public float func_70599_aP() {
        return 0.4f;
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77770_aF.field_77779_bT;
    }

    @Override
    public boolean func_70652_k(Entity entity) {
        return entity.func_70097_a(jxtc.func_76358_a(this), 3.0f);
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        this.field_70911_d._a(false);
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (this.func_70909_n()) {
            if (entityPlayer.func_70005_c_().equalsIgnoreCase(this.func_70905_p()) && !this.field_70170_p.field_72995_K && !this.func_70877_b(cvzo2)) {
                this.field_70911_d._a(!this.func_70906_o());
            }
        } else if (this.field_70914_e._a() && cvzo2 != null && cvzo2._d == tgdv.field_77754_aU.field_77779_bT && entityPlayer.func_70068_e(this) < 9.0) {
            if (!entityPlayer.field_71075_bZ._d) {
                --cvzo2._b;
            }
            if (cvzo2._b <= 0) {
                entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
            }
            if (!this.field_70170_p.field_72995_K) {
                if (this.field_70146_Z.nextInt(3) == 0) {
                    this.func_70903_f(true);
                    this.func_70912_b(1 + this.field_70170_p.field_73012_v.nextInt(3));
                    this.func_70910_a(entityPlayer.func_70005_c_());
                    this.func_70908_e(true);
                    this.field_70911_d._a(true);
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

    public EntityOcelot func_70879_a(EntityAgeable entityAgeable) {
        EntityOcelot entityOcelot = new EntityOcelot(this.field_70170_p);
        if (this.func_70909_n()) {
            entityOcelot.func_70910_a(this.func_70905_p());
            entityOcelot.func_70903_f(true);
            entityOcelot.func_70912_b(this.func_70913_u());
        }
        return entityOcelot;
    }

    @Override
    public boolean func_70877_b(cvzo cvzo2) {
        return cvzo2 != null && cvzo2._d == tgdv.field_77754_aU.field_77779_bT;
    }

    @Override
    public boolean func_70878_b(EntityAnimal entityAnimal) {
        if (entityAnimal == this) {
            return false;
        }
        if (!this.func_70909_n()) {
            return false;
        }
        if (!(entityAnimal instanceof EntityOcelot)) {
            return false;
        }
        EntityOcelot entityOcelot = (EntityOcelot)entityAnimal;
        return !entityOcelot.func_70909_n() ? false : this.func_70880_s() && entityOcelot.func_70880_s();
    }

    public int func_70913_u() {
        return this.field_70180_af._a(18);
    }

    public void func_70912_b(int n) {
        this.field_70180_af._b(18, (byte)n);
    }

    @Override
    public boolean func_70601_bi() {
        if (this.field_70170_p.field_73012_v.nextInt(3) == 0) {
            return false;
        }
        if (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D)) {
            int n = sajh._c(this.field_70165_t);
            int n2 = sajh._c(this.field_70121_D._c);
            int n3 = sajh._c(this.field_70161_v);
            if (n2 < 63) {
                return false;
            }
            int n4 = this.field_70170_p.func_72798_a(n, n2 - 1, n3);
            twgu twgu2 = twgu.field_71973_m[n4];
            if (n4 == twgu.field_71980_u.field_71990_ca || twgu2 != null && twgu2.isLeaves(this.field_70170_p, n, n2 - 1, n3)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String func_70023_ak() {
        return this.func_94056_bM() ? this.func_94057_bL() : (this.func_70909_n() ? "entity.Cat.name" : super.func_70023_ak());
    }

    @Override
    public tupg func_110161_a(tupg tupg2) {
        tupg2 = super.func_110161_a(tupg2);
        if (this.field_70170_p.field_73012_v.nextInt(7) == 0) {
            for (int i = 0; i < 2; ++i) {
                EntityOcelot entityOcelot = new EntityOcelot(this.field_70170_p);
                entityOcelot.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0f);
                entityOcelot.func_70873_a(-24000);
                this.field_70170_p.func_72838_d(entityOcelot);
            }
        }
        return tupg2;
    }

    @Override
    public EntityAgeable func_90011_a(EntityAgeable entityAgeable) {
        return this.func_70879_a(entityAgeable);
    }
}

