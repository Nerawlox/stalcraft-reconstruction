/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntitySlime
extends EntityLiving
implements ezey {
    public float field_70813_a;
    public float field_70811_b;
    public float field_70812_c;
    public int field_70810_d;

    public EntitySlime(ozlu ozlu2) {
        super(ozlu2);
        int n = 1 << this.field_70146_Z.nextInt(3);
        this.field_70129_M = 0.0f;
        this.field_70810_d = this.field_70146_Z.nextInt(20) + 10;
        this.func_70799_a(n);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, new Byte(1));
    }

    public void func_70799_a(int n) {
        this.field_70180_af._b(16, new Byte((byte)n));
        this.func_70105_a(0.6f * (float)n, 0.6f * (float)n);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.func_110148_a(sajz._a)._a(n * n);
        this.func_70606_j(this.func_110138_aP());
        this.field_70728_aV = n;
    }

    public int func_70809_q() {
        return this.field_70180_af._a(16);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("Size", this.func_70809_q() - 1);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.func_70799_a(qoac2._f("Size") + 1);
    }

    public String func_70801_i() {
        return "slime";
    }

    public String func_70803_o() {
        return "mob.slime." + (this.func_70809_q() > 1 ? "big" : "small");
    }

    @Override
    public void func_70071_h_() {
        int n;
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0 && this.func_70809_q() > 0) {
            this.field_70128_L = true;
        }
        this.field_70811_b += (this.field_70813_a - this.field_70811_b) * 0.5f;
        this.field_70812_c = this.field_70811_b;
        boolean bl = this.field_70122_E;
        super.func_70071_h_();
        if (this.field_70122_E && !bl) {
            n = this.func_70809_q();
            for (int i = 0; i < n * 8; ++i) {
                float f = this.field_70146_Z.nextFloat() * (float)Math.PI * 2.0f;
                float f2 = this.field_70146_Z.nextFloat() * 0.5f + 0.5f;
                float f3 = sajh._a(f) * (float)n * 0.5f * f2;
                float f4 = sajh._b(f) * (float)n * 0.5f * f2;
                this.field_70170_p.func_72869_a(this.func_70801_i(), this.field_70165_t + (double)f3, this.field_70121_D._c, this.field_70161_v + (double)f4, 0.0, 0.0, 0.0);
            }
            if (this.func_70804_p()) {
                this.func_85030_a(this.func_70803_o(), this.func_70599_aP(), ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f) / 0.8f);
            }
            this.field_70813_a = -0.5f;
        } else if (!this.field_70122_E && bl) {
            this.field_70813_a = 1.0f;
        }
        this.func_70808_l();
        if (this.field_70170_p.field_72995_K) {
            n = this.func_70809_q();
            this.func_70105_a(0.6f * (float)n, 0.6f * (float)n);
        }
    }

    @Override
    public void func_70626_be() {
        this.func_70623_bb();
        EntityPlayer entityPlayer = this.field_70170_p.func_72856_b(this, 16.0);
        if (entityPlayer != null) {
            this.func_70625_a(entityPlayer, 10.0f, 20.0f);
        }
        if (this.field_70122_E && this.field_70810_d-- <= 0) {
            this.field_70810_d = this.func_70806_k();
            if (entityPlayer != null) {
                this.field_70810_d /= 3;
            }
            this.field_70703_bu = true;
            if (this.func_70807_r()) {
                this.func_85030_a(this.func_70803_o(), this.func_70599_aP(), ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f) * 0.8f);
            }
            this.field_70702_br = 1.0f - this.field_70146_Z.nextFloat() * 2.0f;
            this.field_70701_bs = 1 * this.func_70809_q();
        } else {
            this.field_70703_bu = false;
            if (this.field_70122_E) {
                this.field_70701_bs = 0.0f;
                this.field_70702_br = 0.0f;
            }
        }
    }

    public void func_70808_l() {
        this.field_70813_a *= 0.6f;
    }

    public int func_70806_k() {
        return this.field_70146_Z.nextInt(20) + 10;
    }

    public EntitySlime func_70802_j() {
        return new EntitySlime(this.field_70170_p);
    }

    @Override
    public void func_70106_y() {
        int n = this.func_70809_q();
        if (!this.field_70170_p.field_72995_K && n > 1 && this.func_110143_aJ() <= 0.0f) {
            int n2 = 2 + this.field_70146_Z.nextInt(3);
            for (int i = 0; i < n2; ++i) {
                float f = ((float)(i % 2) - 0.5f) * (float)n / 4.0f;
                float f2 = ((float)(i / 2) - 0.5f) * (float)n / 4.0f;
                EntitySlime entitySlime = this.func_70802_j();
                entitySlime.func_70799_a(n / 2);
                entitySlime.func_70012_b(this.field_70165_t + (double)f, this.field_70163_u + 0.5, this.field_70161_v + (double)f2, this.field_70146_Z.nextFloat() * 360.0f, 0.0f);
                this.field_70170_p.func_72838_d(entitySlime);
            }
        }
        super.func_70106_y();
    }

    @Override
    public void func_70100_b_(EntityPlayer entityPlayer) {
        if (this.func_70800_m()) {
            int n = this.func_70809_q();
            if (this.func_70685_l(entityPlayer) && this.func_70068_e(entityPlayer) < 0.6 * (double)n * 0.6 * (double)n && entityPlayer.func_70097_a(jxtc.func_76358_a(this), this.func_70805_n())) {
                this.func_85030_a("mob.attack", 1.0f, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
            }
        }
    }

    public boolean func_70800_m() {
        return this.func_70809_q() > 1;
    }

    public int func_70805_n() {
        return this.func_70809_q();
    }

    @Override
    public String func_70621_aR() {
        return "mob.slime." + (this.func_70809_q() > 1 ? "big" : "small");
    }

    @Override
    public String func_70673_aS() {
        return "mob.slime." + (this.func_70809_q() > 1 ? "big" : "small");
    }

    @Override
    public int func_70633_aT() {
        return this.func_70809_q() == 1 ? tgdv.field_77761_aM.field_77779_bT : 0;
    }

    @Override
    public boolean func_70601_bi() {
        ixzi ixzi2 = this.field_70170_p.func_72938_d(sajh._c(this.field_70165_t), sajh._c(this.field_70161_v));
        if (this.field_70170_p.func_72912_H()._u()._a(this.field_70146_Z, this.field_70170_p)) {
            return false;
        }
        if (this.func_70809_q() == 1 || this.field_70170_p.field_73013_u > 0) {
            foqh foqh2 = this.field_70170_p.func_72807_a(sajh._c(this.field_70165_t), sajh._c(this.field_70161_v));
            if (foqh2 == foqh._h && this.field_70163_u > 50.0 && this.field_70163_u < 70.0 && this.field_70146_Z.nextFloat() < 0.5f && this.field_70146_Z.nextFloat() < this.field_70170_p.func_130001_d() && this.field_70170_p.func_72957_l(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)) <= this.field_70146_Z.nextInt(8)) {
                return super.func_70601_bi();
            }
            if (this.field_70146_Z.nextInt(10) == 0 && ixzi2._a(987234911L).nextInt(10) == 0 && this.field_70163_u < 40.0) {
                return super.func_70601_bi();
            }
        }
        return false;
    }

    @Override
    public float func_70599_aP() {
        return 0.4f * (float)this.func_70809_q();
    }

    @Override
    public int func_70646_bf() {
        return 0;
    }

    public boolean func_70807_r() {
        return this.func_70809_q() > 0;
    }

    public boolean func_70804_p() {
        return this.func_70809_q() > 2;
    }
}

