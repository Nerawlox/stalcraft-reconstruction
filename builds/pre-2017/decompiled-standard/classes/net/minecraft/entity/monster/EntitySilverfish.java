/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.vjta;
import net.minecraft.util.jxtc;
import net.minecraft.util.owak;
import net.minecraft.util.sajh;

public class EntitySilverfish
extends EntityMob {
    public int field_70843_d;

    public EntitySilverfish(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.3f, 0.7f);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(8.0);
        this.func_110148_a(sajz._d)._a(0.6f);
        this.func_110148_a(sajz._e)._a(1.0);
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    @Override
    public Entity func_70782_k() {
        double d = 8.0;
        return this.field_70170_p.func_72856_b(this, d);
    }

    @Override
    public String func_70639_aQ() {
        return "mob.silverfish.say";
    }

    @Override
    public String func_70621_aR() {
        return "mob.silverfish.hit";
    }

    @Override
    public String func_70673_aS() {
        return "mob.silverfish.kill";
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        if (this.field_70843_d <= 0 && (jxtc2 instanceof net.minecraft.util.vjta || jxtc2 == jxtc.field_76376_m)) {
            this.field_70843_d = 20;
        }
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public void func_70785_a(Entity entity, float f) {
        if (this.field_70724_aR <= 0 && f < 1.2f && entity.field_70121_D._f > this.field_70121_D._c && entity.field_70121_D._c < this.field_70121_D._f) {
            this.field_70724_aR = 20;
            this.func_70652_k(entity);
        }
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.silverfish.step", 0.15f, 1.0f);
    }

    @Override
    public int func_70633_aT() {
        return 0;
    }

    @Override
    public void func_70071_h_() {
        this.field_70761_aq = this.field_70177_z;
        super.func_70071_h_();
    }

    @Override
    public void func_70626_be() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        super.func_70626_be();
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.field_70843_d > 0) {
            --this.field_70843_d;
            if (this.field_70843_d == 0) {
                n5 = sajh._c(this.field_70165_t);
                n4 = sajh._c(this.field_70163_u);
                n3 = sajh._c(this.field_70161_v);
                n2 = 0;
                n = 0;
                while (n2 == 0 && n <= 5 && n >= -5) {
                    int n6 = 0;
                    while (n2 == 0 && n6 <= 10 && n6 >= -10) {
                        int n7 = 0;
                        while (n2 == 0 && n7 <= 10 && n7 >= -10) {
                            int n8 = this.field_70170_p.func_72798_a(n5 + n6, n4 + n, n3 + n7);
                            if (n8 == twgu.field_72006_bl.field_71990_ca) {
                                if (!this.field_70170_p.func_82736_K()._b("mobGriefing")) {
                                    int n9 = this.field_70170_p.func_72805_g(n5 + n6, n4 + n, n3 + n7);
                                    twgu twgu2 = twgu.field_71981_t;
                                    if (n9 == 1) {
                                        twgu2 = twgu.field_71978_w;
                                    }
                                    if (n9 == 2) {
                                        twgu2 = twgu.field_72007_bm;
                                    }
                                    this.field_70170_p.func_72832_d(n5 + n6, n4 + n, n3 + n7, twgu2.field_71990_ca, 0, 3);
                                } else {
                                    this.field_70170_p.func_94578_a(n5 + n6, n4 + n, n3 + n7, false);
                                }
                                twgu.field_72006_bl.func_71898_d(this.field_70170_p, n5 + n6, n4 + n, n3 + n7, 0);
                                if (this.field_70146_Z.nextBoolean()) {
                                    n2 = 1;
                                    break;
                                }
                            }
                            n7 = n7 <= 0 ? 1 - n7 : 0 - n7;
                        }
                        n6 = n6 <= 0 ? 1 - n6 : 0 - n6;
                    }
                    n = n <= 0 ? 1 - n : 0 - n;
                }
            }
        }
        if (this.field_70789_a == null && !this.func_70781_l()) {
            n5 = sajh._c(this.field_70165_t);
            n4 = sajh._c(this.field_70163_u + 0.5);
            n3 = sajh._c(this.field_70161_v);
            n2 = this.field_70146_Z.nextInt(6);
            n = this.field_70170_p.func_72798_a(n5 + owak._b[n2], n4 + owak._c[n2], n3 + owak._d[n2]);
            if (htie._a(n)) {
                this.field_70170_p.func_72832_d(n5 + owak._b[n2], n4 + owak._c[n2], n3 + owak._d[n2], twgu.field_72006_bl.field_71990_ca, htie._b(n), 3);
                this.func_70656_aK();
                this.func_70106_y();
            } else {
                this.func_70779_j();
            }
        } else if (this.field_70789_a != null && !this.func_70781_l()) {
            this.field_70789_a = null;
        }
    }

    @Override
    public float func_70783_a(int n, int n2, int n3) {
        if (this.field_70170_p.func_72798_a(n, n2 - 1, n3) == twgu.field_71981_t.field_71990_ca) {
            return 10.0f;
        }
        return super.func_70783_a(n, n2, n3);
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    @Override
    public boolean func_70601_bi() {
        if (super.func_70601_bi()) {
            EntityPlayer entityPlayer = this.field_70170_p.func_72890_a(this, 5.0);
            return entityPlayer == null;
        }
        return false;
    }

    @Override
    public vjta func_70668_bt() {
        return vjta._c;
    }
}

