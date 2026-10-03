/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import java.util.List;
import java.util.UUID;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjui;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tdmn;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityWitch
extends EntityMob
implements tdmn {
    public static final UUID field_110184_bp = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
    public static final xson field_110185_bq = new xson(field_110184_bp, "Drinking speed penalty", -0.25, 0)._a(false);
    public static final int[] field_82199_d = new int[]{tgdv.field_77751_aT.field_77779_bT, tgdv.field_77747_aY.field_77779_bT, tgdv.field_77767_aC.field_77779_bT, tgdv.field_77728_bu.field_77779_bT, tgdv.field_77729_bt.field_77779_bT, tgdv.field_77677_M.field_77779_bT, tgdv.field_77669_D.field_77779_bT, tgdv.field_77669_D.field_77779_bT};
    public int field_82200_e;

    public EntityWitch(ozlu ozlu2) {
        super(ozlu2);
        this.field_70714_bg._a(1, new tdpx(this));
        this.field_70714_bg._a(2, new kjui(this, 1.0, 60, 10.0f));
        this.field_70714_bg._a(2, new iurn(this, 1.0));
        this.field_70714_bg._a(3, new iurq(this, EntityPlayer.class, 8.0f));
        this.field_70714_bg._a(3, new net.minecraft.entity.ai.tdmn(this));
        this.field_70715_bh._a(1, new ezfa(this, false));
        this.field_70715_bh._a(2, new pibk(this, EntityPlayer.class, 0, true));
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.func_70096_w()._a(21, (Object)0);
    }

    @Override
    public String func_70639_aQ() {
        return "mob.witch.idle";
    }

    @Override
    public String func_70621_aR() {
        return "mob.witch.hurt";
    }

    @Override
    public String func_70673_aS() {
        return "mob.witch.death";
    }

    public void func_82197_f(boolean bl) {
        this.func_70096_w()._b(21, bl ? (byte)1 : 0);
    }

    public boolean func_82198_m() {
        return this.func_70096_w()._a(21) == 1;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(26.0);
        this.func_110148_a(sajz._d)._a(0.25);
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_70636_d() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_82198_m()) {
                if (this.field_82200_e-- <= 0) {
                    List list2;
                    this.func_82197_f(false);
                    cvzo cvzo2 = this.func_70694_bm();
                    this.func_70062_b(0, null);
                    if (cvzo2 != null && cvzo2._d == tgdv.field_77726_bs.field_77779_bT && (list2 = tgdv.field_77726_bs._a(cvzo2)) != null) {
                        for (supr supr2 : list2) {
                            this.func_70690_d(new supr(supr2));
                        }
                    }
                    this.func_110148_a(sajz._d)._b(field_110185_bq);
                }
            } else {
                int n = -1;
                if (this.field_70146_Z.nextFloat() < 0.15f && this.func_70027_ad() && !this.func_70644_a(hdpq._n)) {
                    n = 16307;
                } else if (this.field_70146_Z.nextFloat() < 0.05f && this.func_110143_aJ() < this.func_110138_aP()) {
                    n = 16341;
                } else if (this.field_70146_Z.nextFloat() < 0.25f && this.func_70638_az() != null && !this.func_70644_a(hdpq._c) && this.func_70638_az().func_70068_e(this) > 121.0) {
                    n = 16274;
                } else if (this.field_70146_Z.nextFloat() < 0.25f && this.func_70638_az() != null && !this.func_70644_a(hdpq._c) && this.func_70638_az().func_70068_e(this) > 121.0) {
                    n = 16274;
                }
                if (n > -1) {
                    this.func_70062_b(0, new cvzo(tgdv.field_77726_bs, 1, n));
                    this.field_82200_e = this.func_70694_bm()._n();
                    this.func_82197_f(true);
                    hubf hubf2 = this.func_110148_a(sajz._d);
                    hubf2._b(field_110185_bq);
                    hubf2._a(field_110185_bq);
                }
            }
            if (this.field_70146_Z.nextFloat() < 7.5E-4f) {
                this.field_70170_p.func_72960_a(this, (byte)15);
            }
        }
        super.func_70636_d();
    }

    @Override
    public void func_70103_a(byte by) {
        if (by == 15) {
            for (int i = 0; i < this.field_70146_Z.nextInt(35) + 10; ++i) {
                this.field_70170_p.func_72869_a("witchMagic", this.field_70165_t + this.field_70146_Z.nextGaussian() * (double)0.13f, this.field_70121_D._f + 0.5 + this.field_70146_Z.nextGaussian() * (double)0.13f, this.field_70161_v + this.field_70146_Z.nextGaussian() * (double)0.13f, 0.0, 0.0, 0.0);
            }
        } else {
            super.func_70103_a(by);
        }
    }

    @Override
    public float func_70672_c(jxtc jxtc2, float f) {
        f = super.func_70672_c(jxtc2, f);
        if (jxtc2.func_76346_g() == this) {
            f = 0.0f;
        }
        if (jxtc2.func_82725_o()) {
            f = (float)((double)f * 0.15);
        }
        return f;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2 = this.field_70146_Z.nextInt(3) + 1;
        for (int i = 0; i < n2; ++i) {
            int n3 = this.field_70146_Z.nextInt(3);
            int n4 = field_82199_d[this.field_70146_Z.nextInt(field_82199_d.length)];
            if (n > 0) {
                n3 += this.field_70146_Z.nextInt(n + 1);
            }
            for (int j = 0; j < n3; ++j) {
                this.func_70025_b(n4, 1);
            }
        }
    }

    @Override
    public void func_82196_d(EntityLivingBase entityLivingBase, float f) {
        if (this.func_82198_m()) {
            return;
        }
        EntityPotion entityPotion = new EntityPotion(this.field_70170_p, (EntityLivingBase)this, 32732);
        entityPotion.field_70125_A -= -20.0f;
        double d = entityLivingBase.field_70165_t + entityLivingBase.field_70159_w - this.field_70165_t;
        double d2 = entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e() - (double)1.1f - this.field_70163_u;
        double d3 = entityLivingBase.field_70161_v + entityLivingBase.field_70179_y - this.field_70161_v;
        float f2 = sajh._a(d * d + d3 * d3);
        if (f2 >= 8.0f && !entityLivingBase.func_70644_a(hdpq._d)) {
            entityPotion.func_82340_a(32698);
        } else if (entityLivingBase.func_110143_aJ() >= 8.0f && !entityLivingBase.func_70644_a(hdpq._u)) {
            entityPotion.func_82340_a(32660);
        } else if (f2 <= 3.0f && !entityLivingBase.func_70644_a(hdpq._t) && this.field_70146_Z.nextFloat() < 0.25f) {
            entityPotion.func_82340_a(32696);
        }
        entityPotion.func_70186_c(d, d2 + (double)(f2 * 0.2f), d3, 0.75f, 8.0f);
        this.field_70170_p.func_72838_d(entityPotion);
    }
}

