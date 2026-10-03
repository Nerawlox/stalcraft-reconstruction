/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public abstract class EntityMob
extends EntityCreature
implements ezey {
    public EntityMob(ozlu ozlu2) {
        super(ozlu2);
        this.field_70728_aV = 5;
    }

    @Override
    public void func_70636_d() {
        this.func_82168_bl();
        float f = this.func_70013_c(1.0f);
        if (f > 0.5f) {
            this.field_70708_bq += 2;
        }
        super.func_70636_d();
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.func_70106_y();
        }
    }

    @Override
    public Entity func_70782_k() {
        EntityPlayer entityPlayer = this.field_70170_p.func_72856_b(this, 16.0);
        if (entityPlayer != null && this.func_70685_l(entityPlayer)) {
            return entityPlayer;
        }
        return null;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        if (super.func_70097_a(jxtc2, f)) {
            Entity entity = jxtc2.func_76346_g();
            if (this.field_70153_n == entity || this.field_70154_o == entity) {
                return true;
            }
            if (entity != this) {
                this.field_70789_a = entity;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean func_70652_k(Entity entity) {
        boolean bl;
        float f = (float)this.func_110148_a(sajz._e)._e();
        int n = 0;
        if (entity instanceof EntityLivingBase) {
            f += zhty._a(this, (EntityLivingBase)entity);
            n += zhty._b(this, (EntityLivingBase)entity);
        }
        if (bl = entity.func_70097_a(jxtc.func_76358_a(this), f)) {
            int n2;
            if (n > 0) {
                entity.func_70024_g(-sajh._a(this.field_70177_z * (float)Math.PI / 180.0f) * (float)n * 0.5f, 0.1, sajh._b(this.field_70177_z * (float)Math.PI / 180.0f) * (float)n * 0.5f);
                this.field_70159_w *= 0.6;
                this.field_70179_y *= 0.6;
            }
            if ((n2 = zhty._a(this)) > 0) {
                entity.func_70015_d(n2 * 4);
            }
            if (entity instanceof EntityLivingBase) {
                ekyk._a(this, (EntityLivingBase)entity, this.field_70146_Z);
            }
        }
        return bl;
    }

    @Override
    public void func_70785_a(Entity entity, float f) {
        if (this.field_70724_aR <= 0 && f < 2.0f && entity.field_70121_D._f > this.field_70121_D._c && entity.field_70121_D._c < this.field_70121_D._f) {
            this.field_70724_aR = 20;
            this.func_70652_k(entity);
        }
    }

    @Override
    public float func_70783_a(int n, int n2, int n3) {
        return 0.5f - this.field_70170_p.func_72801_o(n, n2, n3);
    }

    public boolean func_70814_o() {
        int n;
        int n2;
        int n3 = sajh._c(this.field_70165_t);
        if (this.field_70170_p.func_72972_b(rrqi._a, n3, n2 = sajh._c(this.field_70121_D._c), n = sajh._c(this.field_70161_v)) > this.field_70146_Z.nextInt(32)) {
            return false;
        }
        int n4 = this.field_70170_p.func_72957_l(n3, n2, n);
        if (this.field_70170_p.func_72911_I()) {
            int n5 = this.field_70170_p.field_73008_k;
            this.field_70170_p.field_73008_k = 10;
            n4 = this.field_70170_p.func_72957_l(n3, n2, n);
            this.field_70170_p.field_73008_k = n5;
        }
        return n4 <= this.field_70146_Z.nextInt(8);
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.field_73013_u > 0 && this.func_70814_o() && super.func_70601_bi();
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110140_aT()._b(sajz._e);
    }
}

