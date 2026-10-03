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
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;

public class EntityChicken
extends EntityAnimal {
    public float field_70886_e;
    public float field_70883_f;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0f;
    public int field_70887_j;

    public EntityChicken(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.3f, 0.7f);
        this.field_70887_j = this.field_70146_Z.nextInt(6000) + 6000;
        this.field_70714_bg._a(0, new tdpx(this));
        this.field_70714_bg._a(1, new kjwj(this, 1.4));
        this.field_70714_bg._a(2, new srli(this, 1.0));
        this.field_70714_bg._a(3, new ezhm(this, 1.0, tgdv.field_77690_S.field_77779_bT, false));
        this.field_70714_bg._a(4, new ezfc(this, 1.1));
        this.field_70714_bg._a(5, new iurn(this, 1.0));
        this.field_70714_bg._a(6, new iurq(this, EntityPlayer.class, 6.0f));
        this.field_70714_bg._a(7, new tdmn(this));
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(4.0);
        this.func_110148_a(sajz._d)._a(0.25);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70888_h = this.field_70886_e;
        this.field_70884_g = this.field_70883_f;
        this.field_70883_f = (float)((double)this.field_70883_f + (double)(this.field_70122_E ? -1 : 4) * 0.3);
        if (this.field_70883_f < 0.0f) {
            this.field_70883_f = 0.0f;
        }
        if (this.field_70883_f > 1.0f) {
            this.field_70883_f = 1.0f;
        }
        if (!this.field_70122_E && this.field_70889_i < 1.0f) {
            this.field_70889_i = 1.0f;
        }
        this.field_70889_i = (float)((double)this.field_70889_i * 0.9);
        if (!this.field_70122_E && this.field_70181_x < 0.0) {
            this.field_70181_x *= 0.6;
        }
        this.field_70886_e += this.field_70889_i * 2.0f;
        if (!this.func_70631_g_() && !this.field_70170_p.field_72995_K && --this.field_70887_j <= 0) {
            this.func_85030_a("mob.chicken.plop", 1.0f, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
            this.func_70025_b(tgdv.field_77764_aP.field_77779_bT, 1);
            this.field_70887_j = this.field_70146_Z.nextInt(6000) + 6000;
        }
    }

    @Override
    public void func_70069_a(float f) {
    }

    @Override
    public String func_70639_aQ() {
        return "mob.chicken.say";
    }

    @Override
    public String func_70621_aR() {
        return "mob.chicken.hurt";
    }

    @Override
    public String func_70673_aS() {
        return "mob.chicken.hurt";
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.chicken.step", 0.15f, 1.0f);
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77676_L.field_77779_bT;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + n);
        for (int i = 0; i < n2; ++i) {
            this.func_70025_b(tgdv.field_77676_L.field_77779_bT, 1);
        }
        if (this.func_70027_ad()) {
            this.func_70025_b(tgdv.field_77736_bl.field_77779_bT, 1);
        } else {
            this.func_70025_b(tgdv.field_77735_bk.field_77779_bT, 1);
        }
    }

    public EntityChicken func_70879_a(EntityAgeable entityAgeable) {
        return new EntityChicken(this.field_70170_p);
    }

    @Override
    public boolean func_70877_b(cvzo cvzo2) {
        return cvzo2 != null && cvzo2._a() instanceof dhyk;
    }

    @Override
    public /* synthetic */ EntityAgeable func_90011_a(EntityAgeable entityAgeable) {
        return this.func_70879_a(entityAgeable);
    }
}

