/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.dwan;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tupg;
import net.minecraft.entity.vjta;
import net.minecraft.util.sajh;

public class EntitySpider
extends EntityMob {
    public EntitySpider(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(1.4f, 0.9f);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, new Byte(0));
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            this.func_70839_e(this.field_70123_F);
        }
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(16.0);
        this.func_110148_a(sajz._d)._a(0.8f);
    }

    @Override
    public Entity func_70782_k() {
        float f = this.func_70013_c(1.0f);
        if (f < 0.5f) {
            double d = 16.0;
            return this.field_70170_p.func_72856_b(this, d);
        }
        return null;
    }

    @Override
    public String func_70639_aQ() {
        return "mob.spider.say";
    }

    @Override
    public String func_70621_aR() {
        return "mob.spider.say";
    }

    @Override
    public String func_70673_aS() {
        return "mob.spider.death";
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.spider.step", 0.15f, 1.0f);
    }

    @Override
    public void func_70785_a(Entity entity, float f) {
        float f2 = this.func_70013_c(1.0f);
        if (f2 > 0.5f && this.field_70146_Z.nextInt(100) == 0) {
            this.field_70789_a = null;
            return;
        }
        if (f > 2.0f && f < 6.0f && this.field_70146_Z.nextInt(10) == 0) {
            if (this.field_70122_E) {
                double d = entity.field_70165_t - this.field_70165_t;
                double d2 = entity.field_70161_v - this.field_70161_v;
                float f3 = sajh._a(d * d + d2 * d2);
                this.field_70159_w = d / (double)f3 * 0.5 * (double)0.8f + this.field_70159_w * (double)0.2f;
                this.field_70179_y = d2 / (double)f3 * 0.5 * (double)0.8f + this.field_70179_y * (double)0.2f;
                this.field_70181_x = 0.4f;
            }
        } else {
            super.func_70785_a(entity, f);
        }
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77683_K.field_77779_bT;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        super.func_70628_a(bl, n);
        if (bl && (this.field_70146_Z.nextInt(3) == 0 || this.field_70146_Z.nextInt(1 + n) > 0)) {
            this.func_70025_b(tgdv.field_77728_bu.field_77779_bT, 1);
        }
    }

    @Override
    public boolean func_70617_f_() {
        return this.func_70841_p();
    }

    @Override
    public void func_70110_aj() {
    }

    @Override
    public vjta func_70668_bt() {
        return vjta._c;
    }

    @Override
    public boolean func_70687_e(supr supr2) {
        if (supr2._a() == hdpq._u._H) {
            return false;
        }
        return super.func_70687_e(supr2);
    }

    public boolean func_70841_p() {
        return (this.field_70180_af._a(16) & 1) != 0;
    }

    public void func_70839_e(boolean bl) {
        byte by = this.field_70180_af._a(16);
        by = bl ? (byte)(by | 1) : (byte)(by & 0xFFFFFFFE);
        this.field_70180_af._b(16, by);
    }

    @Override
    public tupg func_110161_a(tupg tupg2) {
        int n;
        tupg2 = super.func_110161_a(tupg2);
        if (this.field_70170_p.field_73012_v.nextInt(100) == 0) {
            EntitySkeleton entitySkeleton = new EntitySkeleton(this.field_70170_p);
            entitySkeleton.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0f);
            entitySkeleton.func_110161_a(null);
            this.field_70170_p.func_72838_d(entitySkeleton);
            entitySkeleton.func_70078_a(this);
        }
        if (tupg2 == null) {
            tupg2 = new dwan();
            if (this.field_70170_p.field_73013_u > 2 && this.field_70170_p.field_73012_v.nextFloat() < 0.1f * this.field_70170_p.func_110746_b(this.field_70165_t, this.field_70163_u, this.field_70161_v)) {
                ((dwan)tupg2)._a(this.field_70170_p.field_73012_v);
            }
        }
        if (tupg2 instanceof dwan && (n = ((dwan)tupg2)._a) > 0 && hdpq._a[n] != null) {
            this.func_70690_d(new supr(n, Integer.MAX_VALUE));
        }
        return tupg2;
    }
}

