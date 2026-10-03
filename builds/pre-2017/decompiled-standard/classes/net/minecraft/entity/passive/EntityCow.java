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

public class EntityCow
extends EntityAnimal {
    public EntityCow(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.9f, 1.3f);
        this.func_70661_as()._a(true);
        this.field_70714_bg._a(0, new tdpx(this));
        this.field_70714_bg._a(1, new kjwj(this, 2.0));
        this.field_70714_bg._a(2, new srli(this, 1.0));
        this.field_70714_bg._a(3, new ezhm(this, 1.25, tgdv.field_77685_T.field_77779_bT, false));
        this.field_70714_bg._a(4, new ezfc(this, 1.25));
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
        this.func_110148_a(sajz._a)._a(10.0);
        this.func_110148_a(sajz._d)._a(0.2f);
    }

    @Override
    public String func_70639_aQ() {
        return "mob.cow.say";
    }

    @Override
    public String func_70621_aR() {
        return "mob.cow.hurt";
    }

    @Override
    public String func_70673_aS() {
        return "mob.cow.hurt";
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.cow.step", 0.15f, 1.0f);
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
    public void func_70628_a(boolean bl, int n) {
        int n2;
        int n3 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.func_70025_b(tgdv.field_77770_aF.field_77779_bT, 1);
        }
        n3 = this.field_70146_Z.nextInt(3) + 1 + this.field_70146_Z.nextInt(1 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            if (this.func_70027_ad()) {
                this.func_70025_b(tgdv.field_77734_bj.field_77779_bT, 1);
                continue;
            }
            this.func_70025_b(tgdv.field_77741_bi.field_77779_bT, 1);
        }
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 != null && cvzo2._d == tgdv.field_77788_aw.field_77779_bT && !entityPlayer.field_71075_bZ._d) {
            if (cvzo2._b-- == 1) {
                entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, new cvzo(tgdv.field_77771_aG));
            } else if (!entityPlayer.field_71071_by._c(new cvzo(tgdv.field_77771_aG))) {
                entityPlayer.func_71021_b(new cvzo(tgdv.field_77771_aG.field_77779_bT, 1, 0));
            }
            return true;
        }
        return super.func_70085_c(entityPlayer);
    }

    public EntityCow func_70879_a(EntityAgeable entityAgeable) {
        return new EntityCow(this.field_70170_p);
    }

    @Override
    public /* synthetic */ EntityAgeable func_90011_a(EntityAgeable entityAgeable) {
        return this.func_70879_a(entityAgeable);
    }
}

