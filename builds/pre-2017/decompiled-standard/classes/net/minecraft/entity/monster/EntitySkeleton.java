/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import java.util.Calendar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjui;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.turb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tdmn;
import net.minecraft.entity.tupg;
import net.minecraft.entity.vjta;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntitySkeleton
extends EntityMob
implements tdmn {
    public kjui field_85037_d = new kjui(this, 1.0, 20, 60, 15.0f);
    public pidb field_85038_e = new pidb(this, EntityPlayer.class, 1.2, false);

    public EntitySkeleton(ozlu ozlu2) {
        super(ozlu2);
        this.field_70714_bg._a(1, new tdpx(this));
        this.field_70714_bg._a(2, new turb(this));
        this.field_70714_bg._a(3, new net.minecraft.entity.ai.vjta(this, 1.0));
        this.field_70714_bg._a(5, new iurn(this, 1.0));
        this.field_70714_bg._a(6, new iurq(this, EntityPlayer.class, 8.0f));
        this.field_70714_bg._a(6, new net.minecraft.entity.ai.tdmn(this));
        this.field_70715_bh._a(1, new ezfa(this, false));
        this.field_70715_bh._a(2, new pibk(this, EntityPlayer.class, 0, true));
        if (ozlu2 != null && !ozlu2.field_72995_K) {
            this.func_85036_m();
        }
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._d)._a(0.25);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(13, new Byte(0));
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public String func_70639_aQ() {
        return "mob.skeleton.say";
    }

    @Override
    public String func_70621_aR() {
        return "mob.skeleton.hurt";
    }

    @Override
    public String func_70673_aS() {
        return "mob.skeleton.death";
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.skeleton.step", 0.15f, 1.0f);
    }

    @Override
    public boolean func_70652_k(Entity entity) {
        if (super.func_70652_k(entity)) {
            if (this.func_82202_m() == 1 && entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).func_70690_d(new supr(hdpq._v._H, 200));
            }
            return true;
        }
        return false;
    }

    @Override
    public vjta func_70668_bt() {
        return vjta._b;
    }

    @Override
    public void func_70636_d() {
        float f;
        if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K && (f = this.func_70013_c(1.0f)) > 0.5f && this.field_70146_Z.nextFloat() * 30.0f < (f - 0.4f) * 2.0f && this.field_70170_p.func_72937_j(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v))) {
            boolean bl = true;
            cvzo cvzo2 = this.func_71124_b(4);
            if (cvzo2 != null) {
                if (cvzo2._f()) {
                    cvzo2._b(cvzo2._i() + this.field_70146_Z.nextInt(2));
                    if (cvzo2._i() >= cvzo2._k()) {
                        this.func_70669_a(cvzo2);
                        this.func_70062_b(4, null);
                    }
                }
                bl = false;
            }
            if (bl) {
                this.func_70015_d(8);
            }
        }
        if (this.field_70170_p.field_72995_K && this.func_82202_m() == 1) {
            this.func_70105_a(0.72f, 2.34f);
        }
        super.func_70636_d();
    }

    @Override
    public void func_70098_U() {
        super.func_70098_U();
        if (this.field_70154_o instanceof EntityCreature) {
            EntityCreature entityCreature = (EntityCreature)this.field_70154_o;
            this.field_70761_aq = entityCreature.field_70761_aq;
        }
    }

    @Override
    public void func_70645_a(jxtc jxtc2) {
        super.func_70645_a(jxtc2);
        if (jxtc2.func_76364_f() instanceof EntityArrow && jxtc2.func_76346_g() instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)jxtc2.func_76346_g();
            double d = entityPlayer.field_70165_t - this.field_70165_t;
            double d2 = entityPlayer.field_70161_v - this.field_70161_v;
            if (d * d + d2 * d2 >= 2500.0) {
                entityPlayer.func_71029_a(sdqa._v);
            }
        }
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77704_l.field_77779_bT;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2;
        int n3;
        if (this.func_82202_m() == 1) {
            n3 = this.field_70146_Z.nextInt(3 + n) - 1;
            for (n2 = 0; n2 < n3; ++n2) {
                this.func_70025_b(tgdv.field_77705_m.field_77779_bT, 1);
            }
        } else {
            n3 = this.field_70146_Z.nextInt(3 + n);
            for (n2 = 0; n2 < n3; ++n2) {
                this.func_70025_b(tgdv.field_77704_l.field_77779_bT, 1);
            }
        }
        n3 = this.field_70146_Z.nextInt(3 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.func_70025_b(tgdv.field_77755_aX.field_77779_bT, 1);
        }
    }

    @Override
    public void func_70600_l(int n) {
        if (this.func_82202_m() == 1) {
            this.func_70099_a(new cvzo(tgdv.field_82799_bQ.field_77779_bT, 1, 1), 0.0f);
        }
    }

    @Override
    public void func_82164_bB() {
        super.func_82164_bB();
        this.func_70062_b(0, new cvzo(tgdv.field_77707_k));
    }

    @Override
    public tupg func_110161_a(tupg tupg2) {
        Calendar calendar;
        tupg2 = super.func_110161_a(tupg2);
        if (this.field_70170_p.field_73011_w instanceof zzlh && this.func_70681_au().nextInt(5) > 0) {
            this.field_70714_bg._a(4, this.field_85038_e);
            this.func_82201_a(1);
            this.func_70062_b(0, new cvzo(tgdv.field_77711_v));
            this.func_110148_a(sajz._e)._a(4.0);
        } else {
            this.field_70714_bg._a(4, this.field_85037_d);
            this.func_82164_bB();
            this.func_82162_bC();
        }
        this.func_98053_h(this.field_70146_Z.nextFloat() < 0.55f * this.field_70170_p.func_110746_b(this.field_70165_t, this.field_70163_u, this.field_70161_v));
        if (this.func_71124_b(4) == null && (calendar = this.field_70170_p.func_83015_S()).get(2) + 1 == 10 && calendar.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25f) {
            this.func_70062_b(4, new cvzo(this.field_70146_Z.nextFloat() < 0.1f ? twgu.field_72008_bf : twgu.field_72061_ba));
            this.field_82174_bp[4] = 0.0f;
        }
        return tupg2;
    }

    public void func_85036_m() {
        this.field_70714_bg._a(this.field_85038_e);
        this.field_70714_bg._a(this.field_85037_d);
        cvzo cvzo2 = this.func_70694_bm();
        if (cvzo2 != null && cvzo2._d == tgdv.field_77707_k.field_77779_bT) {
            this.field_70714_bg._a(4, this.field_85037_d);
        } else {
            this.field_70714_bg._a(4, this.field_85038_e);
        }
    }

    @Override
    public void func_82196_d(EntityLivingBase entityLivingBase, float f) {
        EntityArrow entityArrow = new EntityArrow(this.field_70170_p, this, entityLivingBase, 1.6f, 14 - this.field_70170_p.field_73013_u * 4);
        int n = zhty._a(zhqo._u._y, this.func_70694_bm());
        int n2 = zhty._a(zhqo._v._y, this.func_70694_bm());
        entityArrow.func_70239_b((double)(f * 2.0f) + (this.field_70146_Z.nextGaussian() * 0.25 + (double)((float)this.field_70170_p.field_73013_u * 0.11f)));
        if (n > 0) {
            entityArrow.func_70239_b(entityArrow.func_70242_d() + (double)n * 0.5 + 0.5);
        }
        if (n2 > 0) {
            entityArrow.func_70240_a(n2);
        }
        if (zhty._a(zhqo._w._y, this.func_70694_bm()) > 0 || this.func_82202_m() == 1) {
            entityArrow.func_70015_d(100);
        }
        this.func_85030_a("random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        this.field_70170_p.func_72838_d(entityArrow);
    }

    public int func_82202_m() {
        return this.field_70180_af._a(13);
    }

    public void func_82201_a(int n) {
        this.field_70180_af._b(13, (byte)n);
        boolean bl = this.field_70178_ae = n == 1;
        if (n == 1) {
            this.func_70105_a(0.72f, 2.34f);
        } else {
            this.func_70105_a(0.6f, 1.8f);
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        if (qoac2._c("SkeletonType")) {
            byte by = qoac2._d("SkeletonType");
            this.func_82201_a(by);
        }
        this.func_85036_m();
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("SkeletonType", (byte)this.func_82202_m());
    }

    @Override
    public void func_70062_b(int n, cvzo cvzo2) {
        super.func_70062_b(n, cvzo2);
        if (!this.field_70170_p.field_72995_K && n == 0) {
            this.func_85036_m();
        }
    }

    @Override
    public double func_70033_W() {
        return super.func_70033_W() - 0.5;
    }
}

