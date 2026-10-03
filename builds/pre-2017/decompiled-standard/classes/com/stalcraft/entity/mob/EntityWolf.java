/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.amxi;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxtc;

public class EntityWolf
extends EntityMob {
    private int conversionTime;

    public EntityWolf(ozlu ozlu2) {
        super(ozlu2);
        this.func_70661_as()._b(true);
        this.field_70714_bg._a(0, new tdpx(this));
        this.field_70714_bg._a(2, new pidb(this, EntityPlayer.class, 1.0, false));
        this.field_70714_bg._a(3, new pidb(this, EntityVillager.class, 1.0, true));
        this.field_70714_bg._a(4, new amxi(this, 1.0));
        this.field_70714_bg._a(6, new iurn(this, 1.0));
        this.field_70714_bg._a(7, new iurq(this, EntityPlayer.class, 8.0f));
        this.field_70714_bg._a(7, new tdmn(this));
        this.field_70715_bh._a(1, new ezfa(this, true));
        this.field_70715_bh._a(2, new pibk(this, EntityPlayer.class, 0, true));
        this.field_70715_bh._a(2, new pibk(this, EntityVillager.class, 0, false));
    }

    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._b)._a(40.0);
        this.func_110148_a(sajz._d)._a(0.3);
        this.func_110148_a(sajz._a)._a(2.0);
        this.func_110148_a(sajz._e)._a(5.0);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.func_70096_w()._a(12, (Object)0);
        this.func_70096_w()._a(13, (Object)0);
        this.func_70096_w()._a(14, (Object)0);
    }

    @Override
    public int func_70658_aO() {
        int n = super.func_70658_aO() + 2;
        if (n > 20) {
            n = 20;
        }
        return n;
    }

    @Override
    protected boolean func_70650_aV() {
        return true;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public void func_70071_h_() {
        if (this.field_70170_p.field_72995_K || this.conversionTime <= 0) {
            // empty if block
        }
        super.func_70071_h_();
    }

    @Override
    public boolean func_70652_k(Entity entity) {
        boolean bl = super.func_70652_k(entity);
        if (bl && this.func_70694_bm() == null && this.func_70027_ad() && this.field_70146_Z.nextFloat() < (float)this.field_70170_p.field_73013_u * 0.3f) {
            entity.func_70015_d(2 * this.field_70170_p.field_73013_u);
        }
        return bl;
    }

    @Override
    protected String func_70639_aQ() {
        return "mob.wolf.bdog_idle_0";
    }

    @Override
    protected String func_70621_aR() {
        return "bdog_hurt_0";
    }

    @Override
    protected String func_70673_aS() {
        return "bdog_die_3";
    }

    @Override
    protected void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.zombie.step", 0.15f, 1.0f);
    }

    @Override
    protected int func_70633_aT() {
        return tgdv.field_77737_bm.field_77779_bT;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
    }
}

