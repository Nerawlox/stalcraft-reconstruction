/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.amxi;
import net.minecraft.entity.ai.dwan;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.jgro;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.kjui;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tupg;
import net.minecraft.entity.vjta;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeDummyContainer;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.ZombieEvent;

public class EntityZombie
extends EntityMob {
    public static final txei field_110186_bp = new bbnt("zombie.spawnReinforcements", 0.0, 0.0, 1.0)._a("Spawn Reinforcements Chance");
    public static final UUID field_110187_bq = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    public static final xson field_110188_br = new xson(field_110187_bq, "Baby speed boost", 0.5, 1);
    public int field_82234_d;

    public EntityZombie(ozlu ozlu2) {
        super(ozlu2);
        this.func_70661_as()._b(true);
        this.field_70714_bg._a(0, new tdpx(this));
        this.field_70714_bg._a(1, new jgro(this));
        this.field_70714_bg._a(2, new pidb(this, EntityPlayer.class, 1.0, false));
        this.field_70714_bg._a(3, new pidb(this, EntityVillager.class, 1.0, true));
        this.field_70714_bg._a(4, new amxi(this, 1.0));
        this.field_70714_bg._a(5, new dwan(this, 1.0, false));
        this.field_70714_bg._a(6, new iurn(this, 1.0));
        this.field_70714_bg._a(7, new iurq(this, EntityPlayer.class, 8.0f));
        this.field_70714_bg._a(7, new tdmn(this));
        this.field_70715_bh._a(1, new ezfa(this, true));
        this.field_70715_bh._a(2, new pibk(this, EntityPlayer.class, 0, true));
        this.field_70715_bh._a(2, new pibk(this, EntityVillager.class, 0, false));
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._b)._a(40.0);
        this.func_110148_a(sajz._d)._a(0.23f);
        this.func_110148_a(sajz._e)._a(3.0);
        this.func_110140_aT()._b(field_110186_bp)._a(this.field_70146_Z.nextDouble() * ForgeDummyContainer.zombieSummonBaseChance);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.func_70096_w()._a(12, (Object)0);
        this.func_70096_w()._a(13, (Object)0);
        this.func_70096_w()._a(14, (Object)0);
    }

    @Override
    public int func_70658_aO() {
        int n = super.func_70658_aO() + 2;
        if (n > 20) {
            n = 20;
        }
        return n;
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public boolean func_70631_g_() {
        return this.func_70096_w()._a(12) == 1;
    }

    public void func_82227_f(boolean bl) {
        this.func_70096_w()._b(12, (byte)(bl ? 1 : 0));
        if (this.field_70170_p != null && !this.field_70170_p.field_72995_K) {
            hubf hubf2 = this.func_110148_a(sajz._d);
            hubf2._b(field_110188_br);
            if (bl) {
                hubf2._a(field_110188_br);
            }
        }
    }

    public boolean func_82231_m() {
        return this.func_70096_w()._a(13) == 1;
    }

    public void func_82229_g(boolean bl) {
        this.func_70096_w()._b(13, (byte)(bl ? 1 : 0));
    }

    @Override
    public void func_70636_d() {
        float f;
        if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K && !this.func_70631_g_() && (f = this.func_70013_c(1.0f)) > 0.5f && this.field_70146_Z.nextFloat() * 30.0f < (f - 0.4f) * 2.0f && this.field_70170_p.func_72937_j(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v))) {
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
        super.func_70636_d();
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        int n;
        int n2;
        int n3;
        ZombieEvent.SummonAidEvent summonAidEvent;
        if (!super.func_70097_a(jxtc2, f)) {
            return false;
        }
        EntityLivingBase entityLivingBase = this.func_70638_az();
        if (entityLivingBase == null && this.func_70777_m() instanceof EntityLivingBase) {
            entityLivingBase = (EntityLivingBase)this.func_70777_m();
        }
        if (entityLivingBase == null && jxtc2.func_76346_g() instanceof EntityLivingBase) {
            entityLivingBase = (EntityLivingBase)jxtc2.func_76346_g();
        }
        if ((summonAidEvent = ForgeEventFactory.fireZombieSummonAid(this, this.field_70170_p, n3 = sajh._c(this.field_70165_t), n2 = sajh._c(this.field_70163_u), n = sajh._c(this.field_70161_v), entityLivingBase, this.func_110148_a(field_110186_bp)._e())).getResult() == Event.Result.DENY) {
            return true;
        }
        if (summonAidEvent.getResult() == Event.Result.ALLOW || entityLivingBase != null && this.field_70170_p.field_73013_u >= 3 && (double)this.field_70146_Z.nextFloat() < this.func_110148_a(field_110186_bp)._e()) {
            EntityZombie entityZombie = summonAidEvent.customSummonedAid != null && summonAidEvent.getResult() == Event.Result.ALLOW ? summonAidEvent.customSummonedAid : new EntityZombie(this.field_70170_p);
            for (int i = 0; i < 50; ++i) {
                int n4;
                int n5;
                int n6 = n3 + sajh._a(this.field_70146_Z, 7, 40) * sajh._a(this.field_70146_Z, -1, 1);
                if (!this.field_70170_p.func_72797_t(n6, (n5 = n2 + sajh._a(this.field_70146_Z, 7, 40) * sajh._a(this.field_70146_Z, -1, 1)) - 1, n4 = n + sajh._a(this.field_70146_Z, 7, 40) * sajh._a(this.field_70146_Z, -1, 1)) || this.field_70170_p.func_72957_l(n6, n5, n4) >= 10) continue;
                entityZombie.func_70107_b(n6, n5, n4);
                if (!this.field_70170_p.func_72855_b(entityZombie.field_70121_D) || !this.field_70170_p.func_72945_a(entityZombie, entityZombie.field_70121_D).isEmpty() || this.field_70170_p.func_72953_d(entityZombie.field_70121_D)) continue;
                this.field_70170_p.func_72838_d(entityZombie);
                if (entityLivingBase != null) {
                    entityZombie.func_70624_b(entityLivingBase);
                }
                entityZombie.func_110161_a(null);
                this.func_110148_a(field_110186_bp)._a(new xson("Zombie reinforcement caller charge", -0.05f, 0));
                entityZombie.func_110148_a(field_110186_bp)._a(new xson("Zombie reinforcement callee charge", -0.05f, 0));
                break;
            }
        }
        return true;
    }

    @Override
    public void func_70071_h_() {
        if (!this.field_70170_p.field_72995_K && this.func_82230_o()) {
            int n = this.func_82233_q();
            this.field_82234_d -= n;
            if (this.field_82234_d <= 0) {
                this.func_82232_p();
            }
        }
        super.func_70071_h_();
    }

    @Override
    public boolean func_70652_k(Entity entity) {
        boolean bl = super.func_70652_k(entity);
        if (bl && this.func_70694_bm() == null && this.func_70027_ad() && this.field_70146_Z.nextFloat() < (float)this.field_70170_p.field_73013_u * 0.3f) {
            entity.func_70015_d(2 * this.field_70170_p.field_73013_u);
        }
        return bl;
    }

    @Override
    public String func_70639_aQ() {
        return "mob.zombie.say";
    }

    @Override
    public String func_70621_aR() {
        return "mob.zombie.hurt";
    }

    @Override
    public String func_70673_aS() {
        return "mob.zombie.death";
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.zombie.step", 0.15f, 1.0f);
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77737_bm.field_77779_bT;
    }

    @Override
    public vjta func_70668_bt() {
        return vjta._b;
    }

    @Override
    public void func_70600_l(int n) {
        switch (this.field_70146_Z.nextInt(3)) {
            case 0: {
                this.func_70025_b(tgdv.field_77703_o.field_77779_bT, 1);
                break;
            }
            case 1: {
                this.func_70025_b(tgdv.field_82797_bK.field_77779_bT, 1);
                break;
            }
            case 2: {
                this.func_70025_b(tgdv.field_82794_bL.field_77779_bT, 1);
            }
        }
    }

    @Override
    public void func_82164_bB() {
        super.func_82164_bB();
        float f = this.field_70146_Z.nextFloat();
        float f2 = this.field_70170_p.field_73013_u == 3 ? 0.05f : 0.01f;
        if (f < f2) {
            int n = this.field_70146_Z.nextInt(3);
            if (n == 0) {
                this.func_70062_b(0, new cvzo(tgdv.field_77716_q));
            } else {
                this.func_70062_b(0, new cvzo(tgdv.field_77695_f));
            }
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        if (this.func_70631_g_()) {
            qoac2._a("IsBaby", true);
        }
        if (this.func_82231_m()) {
            qoac2._a("IsVillager", true);
        }
        qoac2._a("ConversionTime", this.func_82230_o() ? this.field_82234_d : -1);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        if (qoac2._o("IsBaby")) {
            this.func_82227_f(true);
        }
        if (qoac2._o("IsVillager")) {
            this.func_82229_g(true);
        }
        if (qoac2._c("ConversionTime") && qoac2._f("ConversionTime") > -1) {
            this.func_82228_a(qoac2._f("ConversionTime"));
        }
    }

    @Override
    public void func_70074_a(EntityLivingBase entityLivingBase) {
        super.func_70074_a(entityLivingBase);
        if (this.field_70170_p.field_73013_u >= 2 && entityLivingBase instanceof EntityVillager) {
            if (this.field_70170_p.field_73013_u == 2 && this.field_70146_Z.nextBoolean()) {
                return;
            }
            EntityZombie entityZombie = new EntityZombie(this.field_70170_p);
            entityZombie.func_82149_j(entityLivingBase);
            this.field_70170_p.func_72900_e(entityLivingBase);
            entityZombie.func_110161_a(null);
            entityZombie.func_82229_g(true);
            if (entityLivingBase.func_70631_g_()) {
                entityZombie.func_82227_f(true);
            }
            this.field_70170_p.func_72838_d(entityZombie);
            this.field_70170_p.func_72889_a(null, 1016, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        }
    }

    @Override
    public tupg func_110161_a(tupg tupg2) {
        Object object;
        tupg tupg3 = super.func_110161_a(tupg2);
        float f = this.field_70170_p.func_110746_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.func_98053_h(this.field_70146_Z.nextFloat() < 0.55f * f);
        if (tupg3 == null) {
            tupg3 = new kjui(this, this.field_70170_p.field_73012_v.nextFloat() < ForgeDummyContainer.zombieBabyChance, this.field_70170_p.field_73012_v.nextFloat() < 0.05f, null);
        }
        if (tupg3 instanceof kjui) {
            object = (kjui)tupg3;
            if (((kjui)object)._b) {
                this.func_82229_g(true);
            }
            if (((kjui)object)._a) {
                this.func_82227_f(true);
            }
        }
        this.func_82164_bB();
        this.func_82162_bC();
        if (this.func_71124_b(4) == null && ((Calendar)(object = this.field_70170_p.func_83015_S())).get(2) + 1 == 10 && ((Calendar)object).get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25f) {
            this.func_70062_b(4, new cvzo(this.field_70146_Z.nextFloat() < 0.1f ? twgu.field_72008_bf : twgu.field_72061_ba));
            this.field_82174_bp[4] = 0.0f;
        }
        this.func_110148_a(sajz._c)._a(new xson("Random spawn bonus", this.field_70146_Z.nextDouble() * (double)0.05f, 0));
        this.func_110148_a(sajz._b)._a(new xson("Random zombie-spawn bonus", this.field_70146_Z.nextDouble() * 1.5, 2));
        if (this.field_70146_Z.nextFloat() < f * 0.05f) {
            this.func_110148_a(field_110186_bp)._a(new xson("Leader zombie bonus", this.field_70146_Z.nextDouble() * 0.25 + 0.5, 0));
            this.func_110148_a(sajz._a)._a(new xson("Leader zombie bonus", this.field_70146_Z.nextDouble() * 3.0 + 1.0, 2));
        }
        return tupg3;
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.func_71045_bC();
        if (cvzo2 != null && cvzo2._a() == tgdv.field_77778_at && cvzo2._j() == 0 && this.func_82231_m() && this.func_70644_a(hdpq._t)) {
            if (!entityPlayer.field_71075_bZ._d) {
                --cvzo2._b;
            }
            if (cvzo2._b <= 0) {
                entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
            }
            if (!this.field_70170_p.field_72995_K) {
                this.func_82228_a(this.field_70146_Z.nextInt(2401) + 3600);
            }
            return true;
        }
        return false;
    }

    public void func_82228_a(int n) {
        this.field_82234_d = n;
        this.func_70096_w()._b(14, (byte)1);
        this.func_82170_o(hdpq._t._H);
        this.func_70690_d(new supr(hdpq._g._H, n, Math.min(this.field_70170_p.field_73013_u - 1, 0)));
        this.field_70170_p.func_72960_a(this, (byte)16);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70103_a(byte by) {
        if (by == 16) {
            this.field_70170_p.func_72980_b(this.field_70165_t + 0.5, this.field_70163_u + 0.5, this.field_70161_v + 0.5, "mob.zombie.remedy", 1.0f + this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat() * 0.7f + 0.3f, false);
        } else {
            super.func_70103_a(by);
        }
    }

    @Override
    public boolean func_70692_ba() {
        return !this.func_82230_o();
    }

    public boolean func_82230_o() {
        return this.func_70096_w()._a(14) == 1;
    }

    public void func_82232_p() {
        EntityVillager entityVillager = new EntityVillager(this.field_70170_p);
        entityVillager.func_82149_j(this);
        entityVillager.func_110161_a(null);
        entityVillager.func_82187_q();
        if (this.func_70631_g_()) {
            entityVillager.func_70873_a(-24000);
        }
        this.field_70170_p.func_72900_e(this);
        this.field_70170_p.func_72838_d(entityVillager);
        entityVillager.func_70690_d(new supr(hdpq._k._H, 200, 0));
        this.field_70170_p.func_72889_a(null, 1017, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
    }

    public int func_82233_q() {
        int n = 1;
        if (this.field_70146_Z.nextFloat() < 0.01f) {
            int n2 = 0;
            for (int i = (int)this.field_70165_t - 4; i < (int)this.field_70165_t + 4 && n2 < 14; ++i) {
                for (int j = (int)this.field_70163_u - 4; j < (int)this.field_70163_u + 4 && n2 < 14; ++j) {
                    for (int k = (int)this.field_70161_v - 4; k < (int)this.field_70161_v + 4 && n2 < 14; ++k) {
                        int n3 = this.field_70170_p.func_72798_a(i, j, k);
                        if (n3 != twgu.field_72002_bp.field_71990_ca && n3 != twgu.field_71959_S.field_71990_ca) continue;
                        if (this.field_70146_Z.nextFloat() < 0.3f) {
                            ++n;
                        }
                        ++n2;
                    }
                }
            }
        }
        return n;
    }
}

