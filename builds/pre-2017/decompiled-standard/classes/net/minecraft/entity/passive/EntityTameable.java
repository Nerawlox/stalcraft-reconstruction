/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.hanr;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.qlgf;

public abstract class EntityTameable
extends EntityAnimal
implements qlgf {
    public hanr field_70911_d = new hanr(this);

    public EntityTameable(ozlu ozlu2) {
        super(ozlu2);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, (Object)0);
        this.field_70180_af._a(17, "");
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        if (this.func_70905_p() == null) {
            qoac2._a("Owner", "");
        } else {
            qoac2._a("Owner", this.func_70905_p());
        }
        qoac2._a("Sitting", this.func_70906_o());
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        String string = qoac2._j("Owner");
        if (string.length() > 0) {
            this.func_70910_a(string);
            this.func_70903_f(true);
        }
        this.field_70911_d._a(qoac2._o("Sitting"));
        this.func_70904_g(qoac2._o("Sitting"));
    }

    public void func_70908_e(boolean bl) {
        String string = "heart";
        if (!bl) {
            string = "smoke";
        }
        for (int i = 0; i < 7; ++i) {
            double d = this.field_70146_Z.nextGaussian() * 0.02;
            double d2 = this.field_70146_Z.nextGaussian() * 0.02;
            double d3 = this.field_70146_Z.nextGaussian() * 0.02;
            this.field_70170_p.func_72869_a(string, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, this.field_70163_u + 0.5 + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, d, d2, d3);
        }
    }

    @Override
    public void func_70103_a(byte by) {
        if (by == 7) {
            this.func_70908_e(true);
        } else if (by == 6) {
            this.func_70908_e(false);
        } else {
            super.func_70103_a(by);
        }
    }

    public boolean func_70909_n() {
        return (this.field_70180_af._a(16) & 4) != 0;
    }

    public void func_70903_f(boolean bl) {
        byte by = this.field_70180_af._a(16);
        if (bl) {
            this.field_70180_af._b(16, (byte)(by | 4));
        } else {
            this.field_70180_af._b(16, (byte)(by & 0xFFFFFFFB));
        }
    }

    public boolean func_70906_o() {
        return (this.field_70180_af._a(16) & 1) != 0;
    }

    public void func_70904_g(boolean bl) {
        byte by = this.field_70180_af._a(16);
        if (bl) {
            this.field_70180_af._b(16, (byte)(by | 1));
        } else {
            this.field_70180_af._b(16, (byte)(by & 0xFFFFFFFE));
        }
    }

    @Override
    public String func_70905_p() {
        return this.field_70180_af._e(17);
    }

    public void func_70910_a(String string) {
        this.field_70180_af._b(17, string);
    }

    public EntityLivingBase func_130012_q() {
        return this.field_70170_p.func_72924_a(this.func_70905_p());
    }

    public hanr func_70907_r() {
        return this.field_70911_d;
    }

    public boolean func_142018_a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        return true;
    }

    @Override
    public cwci func_96124_cp() {
        EntityLivingBase entityLivingBase;
        if (this.func_70909_n() && (entityLivingBase = this.func_130012_q()) != null) {
            return entityLivingBase.func_96124_cp();
        }
        return super.func_96124_cp();
    }

    @Override
    public boolean func_142014_c(EntityLivingBase entityLivingBase) {
        if (this.func_70909_n()) {
            EntityLivingBase entityLivingBase2 = this.func_130012_q();
            if (entityLivingBase == entityLivingBase2) {
                return true;
            }
            if (entityLivingBase2 != null) {
                return entityLivingBase2.func_142014_c(entityLivingBase);
            }
        }
        return super.func_142014_c(entityLivingBase);
    }

    @Override
    public /* synthetic */ Entity func_70902_q() {
        return this.func_130012_q();
    }
}

