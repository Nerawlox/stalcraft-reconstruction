/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.amxi;
import net.minecraft.entity.ai.dwan;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.jxtc;
import net.minecraft.entity.ai.owak;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.pibn;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.sajh;
import net.minecraft.util.zwaw;

public class EntityIronGolem
extends EntityGolem {
    public int field_70858_e;
    public mtdg field_70857_d;
    public int field_70855_f;
    public int field_70856_g;

    public EntityIronGolem(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(1.4f, 2.9f);
        this.func_70661_as()._a(true);
        this.field_70714_bg._a(1, new pidb(this, 1.0, true));
        this.field_70714_bg._a(2, new pibn(this, 0.9, 32.0f));
        this.field_70714_bg._a(3, new dwan(this, 0.6, true));
        this.field_70714_bg._a(4, new amxi(this, 1.0));
        this.field_70714_bg._a(5, new owak(this));
        this.field_70714_bg._a(6, new iurn(this, 0.6));
        this.field_70714_bg._a(7, new iurq(this, EntityPlayer.class, 6.0f));
        this.field_70714_bg._a(8, new tdmn(this));
        this.field_70715_bh._a(1, new jxtc(this));
        this.field_70715_bh._a(2, new ezfa(this, false));
        this.field_70715_bh._a(3, new pibk(this, EntityLiving.class, 0, false, true, ezey._a));
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, (Object)0);
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_70629_bd() {
        if (--this.field_70858_e <= 0) {
            this.field_70858_e = 70 + this.field_70146_Z.nextInt(50);
            this.field_70857_d = this.field_70170_p.field_72982_D._a(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v), 32);
            if (this.field_70857_d == null) {
                this.func_110177_bN();
            } else {
                zwaw zwaw2 = this.field_70857_d._c();
                this.func_110171_b(zwaw2._a, zwaw2._b, zwaw2._c, (int)((float)this.field_70857_d._d() * 0.6f));
            }
        }
        super.func_70629_bd();
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(100.0);
        this.func_110148_a(sajz._d)._a(0.25);
    }

    @Override
    public int func_70682_h(int n) {
        return n;
    }

    @Override
    public void func_82167_n(Entity entity) {
        if (entity instanceof ezey && this.func_70681_au().nextInt(20) == 0) {
            this.func_70624_b((EntityLivingBase)entity);
        }
        super.func_82167_n(entity);
    }

    @Override
    public void func_70636_d() {
        int n;
        int n2;
        int n3;
        int n4;
        super.func_70636_d();
        if (this.field_70855_f > 0) {
            --this.field_70855_f;
        }
        if (this.field_70856_g > 0) {
            --this.field_70856_g;
        }
        if (this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 2.500000277905201E-7 && this.field_70146_Z.nextInt(5) == 0 && (n4 = this.field_70170_p.func_72798_a(n3 = sajh._c(this.field_70165_t), n2 = sajh._c(this.field_70163_u - (double)0.2f - (double)this.field_70129_M), n = sajh._c(this.field_70161_v))) > 0) {
            this.field_70170_p.func_72869_a("tilecrack_" + n4 + "_" + this.field_70170_p.func_72805_g(n3, n2, n), this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - 0.5) * (double)this.field_70130_N, this.field_70121_D._c + 0.1, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - 0.5) * (double)this.field_70130_N, 4.0 * ((double)this.field_70146_Z.nextFloat() - 0.5), 0.5, ((double)this.field_70146_Z.nextFloat() - 0.5) * 4.0);
        }
    }

    @Override
    public boolean func_70686_a(Class clazz) {
        if (this.func_70850_q() && EntityPlayer.class.isAssignableFrom(clazz)) {
            return false;
        }
        return super.func_70686_a(clazz);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("PlayerCreated", this.func_70850_q());
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.func_70849_f(qoac2._o("PlayerCreated"));
    }

    @Override
    public boolean func_70652_k(Entity entity) {
        this.field_70855_f = 10;
        this.field_70170_p.func_72960_a(this, (byte)4);
        boolean bl = entity.func_70097_a(net.minecraft.util.jxtc.func_76358_a(this), 7 + this.field_70146_Z.nextInt(15));
        if (bl) {
            entity.field_70181_x += (double)0.4f;
        }
        this.func_85030_a("mob.irongolem.throw", 1.0f, 1.0f);
        return bl;
    }

    @Override
    public void func_70103_a(byte by) {
        if (by == 4) {
            this.field_70855_f = 10;
            this.func_85030_a("mob.irongolem.throw", 1.0f, 1.0f);
        } else if (by == 11) {
            this.field_70856_g = 400;
        } else {
            super.func_70103_a(by);
        }
    }

    public mtdg func_70852_n() {
        return this.field_70857_d;
    }

    public int func_70854_o() {
        return this.field_70855_f;
    }

    public void func_70851_e(boolean bl) {
        this.field_70856_g = bl ? 400 : 0;
        this.field_70170_p.func_72960_a(this, (byte)11);
    }

    @Override
    public String func_70639_aQ() {
        return "none";
    }

    @Override
    public String func_70621_aR() {
        return "mob.irongolem.hit";
    }

    @Override
    public String func_70673_aS() {
        return "mob.irongolem.death";
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.irongolem.walk", 1.0f, 1.0f);
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2;
        int n3 = this.field_70146_Z.nextInt(3);
        for (n2 = 0; n2 < n3; ++n2) {
            this.func_70025_b(twgu.field_72107_ae.field_71990_ca, 1);
        }
        n2 = 3 + this.field_70146_Z.nextInt(3);
        for (int i = 0; i < n2; ++i) {
            this.func_70025_b(tgdv.field_77703_o.field_77779_bT, 1);
        }
    }

    public int func_70853_p() {
        return this.field_70856_g;
    }

    public boolean func_70850_q() {
        return (this.field_70180_af._a(16) & 1) != 0;
    }

    public void func_70849_f(boolean bl) {
        byte by = this.field_70180_af._a(16);
        if (bl) {
            this.field_70180_af._b(16, (byte)(by | 1));
        } else {
            this.field_70180_af._b(16, (byte)(by & 0xFFFFFFFE));
        }
    }

    @Override
    public void func_70645_a(net.minecraft.util.jxtc jxtc2) {
        if (!this.func_70850_q() && this.field_70717_bb != null && this.field_70857_d != null) {
            this.field_70857_d._a(this.field_70717_bb.func_70005_c_(), -5);
        }
        super.func_70645_a(jxtc2);
    }
}

