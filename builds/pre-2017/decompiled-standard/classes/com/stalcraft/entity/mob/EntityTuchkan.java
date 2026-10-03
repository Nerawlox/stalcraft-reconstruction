/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxtc;
import net.minecraft.util.vjta;

public class EntityTuchkan
extends EntityMob {
    private int allySummonCooldown;

    public EntityTuchkan(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.4f, 0.7f);
    }

    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(8.0);
        this.func_110148_a(sajz._d)._a(0.6f);
        this.func_110148_a(sajz._e)._a(1.0);
    }

    @Override
    protected Entity func_70782_k() {
        double d = 8.0;
        return this.field_70170_p.func_72856_b(this, d);
    }

    @Override
    protected String func_70639_aQ() {
        return "mob.silverfish.say";
    }

    @Override
    protected String func_70621_aR() {
        return "mob.silverfish.hit";
    }

    @Override
    protected String func_70673_aS() {
        return "mob.silverfish.kill";
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        if (this.allySummonCooldown <= 0 && (jxtc2 instanceof vjta || jxtc2 == jxtc.field_76376_m)) {
            this.allySummonCooldown = 20;
        }
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    protected void func_70785_a(Entity entity, float f) {
        if (this.field_70724_aR <= 0 && f < 1.2f && entity.field_70121_D._f > this.field_70121_D._c && entity.field_70121_D._c < this.field_70121_D._f) {
            this.field_70724_aR = 20;
            this.func_70652_k(entity);
        }
    }

    @Override
    protected void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.silverfish.step", 0.15f, 1.0f);
    }

    @Override
    public void func_70071_h_() {
        this.field_70761_aq = this.field_70177_z;
        super.func_70071_h_();
    }

    @Override
    public float func_70783_a(int n, int n2, int n3) {
        return this.field_70170_p.func_72798_a(n, n2 - 1, n3) == twgu.field_71981_t.field_71990_ca ? 10.0f : super.func_70783_a(n, n2, n3);
    }
}

