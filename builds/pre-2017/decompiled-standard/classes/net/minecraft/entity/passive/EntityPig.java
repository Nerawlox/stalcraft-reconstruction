/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.ezfc;
import net.minecraft.entity.ai.ezhm;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjwj;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.tupg;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;

public class EntityPig
extends EntityAnimal {
    public final tupg field_82184_d;

    public EntityPig(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.9f, 0.9f);
        this.func_70661_as()._a(true);
        this.field_70714_bg._a(0, new tdpx(this));
        this.field_70714_bg._a(1, new kjwj(this, 1.25));
        this.field_82184_d = new tupg(this, 0.3f);
        this.field_70714_bg._a(2, this.field_82184_d);
        this.field_70714_bg._a(3, new srli(this, 1.0));
        this.field_70714_bg._a(4, new ezhm(this, 1.2, tgdv.field_82793_bR.field_77779_bT, false));
        this.field_70714_bg._a(4, new ezhm(this, 1.2, tgdv.field_82797_bK.field_77779_bT, false));
        this.field_70714_bg._a(5, new ezfc(this, 1.1));
        this.field_70714_bg._a(6, new iurn(this, 1.0));
        this.field_70714_bg._a(7, new iurq(this, EntityPlayer.class, 6.0f));
        this.field_70714_bg._a(8, new tdmn(this));
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(10.0);
        this.func_110148_a(sajz._d)._a(0.25);
    }

    @Override
    public void func_70619_bc() {
        super.func_70619_bc();
    }

    @Override
    public boolean func_82171_bF() {
        cvzo cvzo2 = ((EntityPlayer)this.field_70153_n).func_70694_bm();
        return cvzo2 != null && cvzo2._d == tgdv.field_82793_bR.field_77779_bT;
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, (Object)0);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("Saddle", this.func_70901_n());
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.func_70900_e(qoac2._o("Saddle"));
    }

    @Override
    public String func_70639_aQ() {
        return "mob.pig.say";
    }

    @Override
    public String func_70621_aR() {
        return "mob.pig.say";
    }

    @Override
    public String func_70673_aS() {
        return "mob.pig.death";
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.pig.step", 0.15f, 1.0f);
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        if (!super.func_70085_c(entityPlayer)) {
            if (this.func_70901_n() && !this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == entityPlayer)) {
                entityPlayer.func_70078_a(this);
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public int func_70633_aT() {
        if (this.func_70027_ad()) {
            return tgdv.field_77782_ar.field_77779_bT;
        }
        return tgdv.field_77784_aq.field_77779_bT;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2 = this.field_70146_Z.nextInt(3) + 1 + this.field_70146_Z.nextInt(1 + n);
        for (int i = 0; i < n2; ++i) {
            if (this.func_70027_ad()) {
                this.func_70025_b(tgdv.field_77782_ar.field_77779_bT, 1);
                continue;
            }
            this.func_70025_b(tgdv.field_77784_aq.field_77779_bT, 1);
        }
        if (this.func_70901_n()) {
            this.func_70025_b(tgdv.field_77765_aA.field_77779_bT, 1);
        }
    }

    public boolean func_70901_n() {
        return (this.field_70180_af._a(16) & 1) != 0;
    }

    public void func_70900_e(boolean bl) {
        if (bl) {
            this.field_70180_af._b(16, (byte)1);
        } else {
            this.field_70180_af._b(16, (byte)0);
        }
    }

    @Override
    public void func_70077_a(EntityLightningBolt entityLightningBolt) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        EntityPigZombie entityPigZombie = new EntityPigZombie(this.field_70170_p);
        entityPigZombie.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
        this.field_70170_p.func_72838_d(entityPigZombie);
        this.func_70106_y();
    }

    @Override
    public void func_70069_a(float f) {
        super.func_70069_a(f);
        if (f > 5.0f && this.field_70153_n instanceof EntityPlayer) {
            ((EntityPlayer)this.field_70153_n).func_71029_a(sdqa._u);
        }
    }

    public EntityPig func_70879_a(EntityAgeable entityAgeable) {
        return new EntityPig(this.field_70170_p);
    }

    @Override
    public boolean func_70877_b(cvzo cvzo2) {
        return cvzo2 != null && cvzo2._d == tgdv.field_82797_bK.field_77779_bT;
    }

    public tupg func_82183_n() {
        return this.field_82184_d;
    }

    @Override
    public /* synthetic */ EntityAgeable func_90011_a(EntityAgeable entityAgeable) {
        return this.func_70879_a(entityAgeable);
    }
}

