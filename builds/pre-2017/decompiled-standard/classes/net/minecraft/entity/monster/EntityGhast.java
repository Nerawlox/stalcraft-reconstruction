/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.sajz;
import net.minecraft.util.eidj;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class EntityGhast
extends EntityFlying
implements ezey {
    public int field_70797_a;
    public double field_70795_b;
    public double field_70796_c;
    public double field_70793_d;
    public Entity field_70792_g;
    public int field_70798_h;
    public int field_70794_e;
    public int field_70791_f;
    public int field_92014_j = 1;

    public EntityGhast(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(4.0f, 4.0f);
        this.field_70178_ae = true;
        this.field_70728_aV = 5;
    }

    public boolean func_110182_bF() {
        return this.field_70180_af._a(16) != 0;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        if ("fireball".equals(jxtc2.func_76355_l()) && jxtc2.func_76346_g() instanceof EntityPlayer) {
            super.func_70097_a(jxtc2, 1000.0f);
            ((EntityPlayer)jxtc2.func_76346_g()).func_71029_a(sdqa._y);
            return true;
        }
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, (Object)0);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(10.0);
    }

    @Override
    public void func_70626_be() {
        byte by;
        byte by2;
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.func_70106_y();
        }
        this.func_70623_bb();
        this.field_70794_e = this.field_70791_f;
        double d = this.field_70795_b - this.field_70165_t;
        double d2 = this.field_70796_c - this.field_70163_u;
        double d3 = this.field_70793_d - this.field_70161_v;
        double d4 = d * d + d2 * d2 + d3 * d3;
        if (d4 < 1.0 || d4 > 3600.0) {
            this.field_70795_b = this.field_70165_t + (double)((this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.field_70796_c = this.field_70163_u + (double)((this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.field_70793_d = this.field_70161_v + (double)((this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f);
        }
        if (this.field_70797_a-- <= 0) {
            this.field_70797_a += this.field_70146_Z.nextInt(5) + 2;
            if (this.func_70790_a(this.field_70795_b, this.field_70796_c, this.field_70793_d, d4 = (double)sajh._a(d4))) {
                this.field_70159_w += d / d4 * 0.1;
                this.field_70181_x += d2 / d4 * 0.1;
                this.field_70179_y += d3 / d4 * 0.1;
            } else {
                this.field_70795_b = this.field_70165_t;
                this.field_70796_c = this.field_70163_u;
                this.field_70793_d = this.field_70161_v;
            }
        }
        if (this.field_70792_g != null && this.field_70792_g.field_70128_L) {
            this.field_70792_g = null;
        }
        if (this.field_70792_g == null || this.field_70798_h-- <= 0) {
            this.field_70792_g = this.field_70170_p.func_72856_b(this, 100.0);
            if (this.field_70792_g != null) {
                this.field_70798_h = 20;
            }
        }
        double d5 = 64.0;
        if (this.field_70792_g != null && this.field_70792_g.func_70068_e(this) < d5 * d5) {
            double d6 = this.field_70792_g.field_70165_t - this.field_70165_t;
            double d7 = this.field_70792_g.field_70121_D._c + (double)(this.field_70792_g.field_70131_O / 2.0f) - (this.field_70163_u + (double)(this.field_70131_O / 2.0f));
            double d8 = this.field_70792_g.field_70161_v - this.field_70161_v;
            this.field_70761_aq = this.field_70177_z = -((float)Math.atan2(d6, d8)) * 180.0f / (float)Math.PI;
            if (this.func_70685_l(this.field_70792_g)) {
                if (this.field_70791_f == 10) {
                    this.field_70170_p.func_72889_a(null, 1007, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                }
                ++this.field_70791_f;
                if (this.field_70791_f == 20) {
                    this.field_70170_p.func_72889_a(null, 1008, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                    EntityLargeFireball entityLargeFireball = new EntityLargeFireball(this.field_70170_p, this, d6, d7, d8);
                    entityLargeFireball.field_92057_e = this.field_92014_j;
                    double d9 = 4.0;
                    ofbx ofbx2 = this.func_70676_i(1.0f);
                    entityLargeFireball.field_70165_t = this.field_70165_t + ofbx2._c * d9;
                    entityLargeFireball.field_70163_u = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
                    entityLargeFireball.field_70161_v = this.field_70161_v + ofbx2._e * d9;
                    this.field_70170_p.func_72838_d(entityLargeFireball);
                    this.field_70791_f = -40;
                }
            } else if (this.field_70791_f > 0) {
                --this.field_70791_f;
            }
        } else {
            this.field_70761_aq = this.field_70177_z = -((float)Math.atan2(this.field_70159_w, this.field_70179_y)) * 180.0f / (float)Math.PI;
            if (this.field_70791_f > 0) {
                --this.field_70791_f;
            }
        }
        if (!this.field_70170_p.field_72995_K && (by2 = this.field_70180_af._a(16)) != (by = (byte)(this.field_70791_f > 10 ? 1 : 0))) {
            this.field_70180_af._b(16, by);
        }
    }

    public boolean func_70790_a(double d, double d2, double d3, double d4) {
        double d5 = (this.field_70795_b - this.field_70165_t) / d4;
        double d6 = (this.field_70796_c - this.field_70163_u) / d4;
        double d7 = (this.field_70793_d - this.field_70161_v) / d4;
        eidj eidj2 = this.field_70121_D._c();
        int n = 1;
        while ((double)n < d4) {
            eidj2._d(d5, d6, d7);
            if (!this.field_70170_p.func_72945_a(this, eidj2).isEmpty()) {
                return false;
            }
            ++n;
        }
        return true;
    }

    @Override
    public String func_70639_aQ() {
        return "mob.ghast.moan";
    }

    @Override
    public String func_70621_aR() {
        return "mob.ghast.scream";
    }

    @Override
    public String func_70673_aS() {
        return "mob.ghast.death";
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77677_M.field_77779_bT;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2;
        int n3 = this.field_70146_Z.nextInt(2) + this.field_70146_Z.nextInt(1 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.func_70025_b(tgdv.field_77732_bp.field_77779_bT, 1);
        }
        n3 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.func_70025_b(tgdv.field_77677_M.field_77779_bT, 1);
        }
    }

    @Override
    public float func_70599_aP() {
        return 10.0f;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(20) == 0 && super.func_70601_bi() && this.field_70170_p.field_73013_u > 0;
    }

    @Override
    public int func_70641_bl() {
        return 1;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("ExplosionPower", this.field_92014_j);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        if (qoac2._c("ExplosionPower")) {
            this.field_92014_j = qoac2._f("ExplosionPower");
        }
    }
}

