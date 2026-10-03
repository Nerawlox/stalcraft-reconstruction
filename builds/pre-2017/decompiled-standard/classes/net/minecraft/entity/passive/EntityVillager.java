/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.amxi;
import net.minecraft.entity.ai.eidj;
import net.minecraft.entity.ai.hank;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.jxsn;
import net.minecraft.entity.ai.ntaf;
import net.minecraft.entity.ai.ofbx;
import net.minecraft.entity.ai.samo;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.uxqz;
import net.minecraft.entity.ai.vjvn;
import net.minecraft.entity.amww;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tupg;
import net.minecraft.entity.vjsq;
import net.minecraft.util.idpz;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;
import net.minecraft.util.zwaw;

public class EntityVillager
extends EntityAgeable
implements amww,
vjsq {
    public int field_70955_e;
    public boolean field_70952_f;
    public boolean field_70953_g;
    public mtdg field_70954_d;
    public EntityPlayer field_70962_h;
    public ywfi field_70963_i;
    public int field_70961_j;
    public boolean field_70959_by;
    public int field_70956_bz;
    public String field_82189_bL;
    public boolean field_82190_bM;
    public float field_82191_bN;
    public static final Map field_70958_bB = new HashMap();
    public static final Map field_70960_bC = new HashMap();

    public EntityVillager(ozlu ozlu2) {
        this(ozlu2, 0);
    }

    public EntityVillager(ozlu ozlu2, int n) {
        super(ozlu2);
        this.func_70938_b(n);
        this.func_70105_a(0.6f, 1.8f);
        this.func_70661_as()._b(true);
        this.func_70661_as()._a(true);
        this.field_70714_bg._a(0, new tdpx(this));
        this.field_70714_bg._a(1, new eidj(this, EntityZombie.class, 8.0f, 0.6, 0.6));
        this.field_70714_bg._a(1, new ntaf(this));
        this.field_70714_bg._a(1, new net.minecraft.entity.ai.vjsq(this));
        this.field_70714_bg._a(2, new net.minecraft.entity.ai.sajz(this));
        this.field_70714_bg._a(3, new hank(this));
        this.field_70714_bg._a(4, new uxqz(this, true));
        this.field_70714_bg._a(5, new amxi(this, 0.6));
        this.field_70714_bg._a(6, new ofbx(this));
        this.field_70714_bg._a(7, new jxsn(this));
        this.field_70714_bg._a(8, new samo(this, 0.32));
        this.field_70714_bg._a(9, new vjvn(this, EntityPlayer.class, 3.0f, 1.0f));
        this.field_70714_bg._a(9, new vjvn(this, EntityVillager.class, 5.0f, 0.02f));
        this.field_70714_bg._a(9, new iurn(this, 0.6));
        this.field_70714_bg._a(10, new iurq(this, EntityLiving.class, 8.0f));
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._d)._a(0.5);
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_70629_bd() {
        if (--this.field_70955_e <= 0) {
            this.field_70170_p.field_72982_D._a(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v));
            this.field_70955_e = 70 + this.field_70146_Z.nextInt(50);
            this.field_70954_d = this.field_70170_p.field_72982_D._a(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v), 32);
            if (this.field_70954_d == null) {
                this.func_110177_bN();
            } else {
                zwaw zwaw2 = this.field_70954_d._c();
                this.func_110171_b(zwaw2._a, zwaw2._b, zwaw2._c, (int)((float)this.field_70954_d._d() * 0.6f));
                if (this.field_82190_bM) {
                    this.field_82190_bM = false;
                    this.field_70954_d._b(5);
                }
            }
        }
        if (!this.func_70940_q() && this.field_70961_j > 0) {
            --this.field_70961_j;
            if (this.field_70961_j <= 0) {
                if (this.field_70959_by) {
                    if (this.field_70963_i.size() > 1) {
                        for (ozjk ozjk2 : this.field_70963_i) {
                            if (!ozjk2._f()) continue;
                            ozjk2._a(this.field_70146_Z.nextInt(6) + this.field_70146_Z.nextInt(6) + 2);
                        }
                    }
                    this.func_70950_c(1);
                    this.field_70959_by = false;
                    if (this.field_70954_d != null && this.field_82189_bL != null) {
                        this.field_70170_p.func_72960_a(this, (byte)14);
                        this.field_70954_d._a(this.field_82189_bL, 1);
                    }
                }
                this.func_70690_d(new supr(hdpq._l._H, 200, 0));
            }
        }
        super.func_70629_bd();
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        boolean bl;
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        boolean bl2 = bl = cvzo2 != null && cvzo2._d == tgdv.field_77815_bC.field_77779_bT;
        if (!(bl || !this.func_70089_S() || this.func_70940_q() || this.func_70631_g_() || entityPlayer.func_70093_af())) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70932_a_(entityPlayer);
                entityPlayer.func_71030_a(this, this.func_94057_bL());
            }
            return true;
        }
        return super.func_70085_c(entityPlayer);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, (Object)0);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("Profession", this.func_70946_n());
        qoac2._a("Riches", this.field_70956_bz);
        if (this.field_70963_i != null) {
            qoac2._a("Offers", this.field_70963_i._a());
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.func_70938_b(qoac2._f("Profession"));
        this.field_70956_bz = qoac2._f("Riches");
        if (qoac2._c("Offers")) {
            qoac qoac3 = qoac2._m("Offers");
            this.field_70963_i = new ywfi(qoac3);
        }
    }

    @Override
    public boolean func_70692_ba() {
        return false;
    }

    @Override
    public String func_70639_aQ() {
        return this.func_70940_q() ? "mob.villager.haggle" : "mob.villager.idle";
    }

    @Override
    public String func_70621_aR() {
        return "mob.villager.hit";
    }

    @Override
    public String func_70673_aS() {
        return "mob.villager.death";
    }

    public void func_70938_b(int n) {
        this.field_70180_af._b(16, n);
    }

    public int func_70946_n() {
        return this.field_70180_af._c(16);
    }

    public boolean func_70941_o() {
        return this.field_70952_f;
    }

    public void func_70947_e(boolean bl) {
        this.field_70952_f = bl;
    }

    public void func_70939_f(boolean bl) {
        this.field_70953_g = bl;
    }

    public boolean func_70945_p() {
        return this.field_70953_g;
    }

    @Override
    public void func_70604_c(EntityLivingBase entityLivingBase) {
        super.func_70604_c(entityLivingBase);
        if (this.field_70954_d != null && entityLivingBase != null) {
            this.field_70954_d._a(entityLivingBase);
            if (entityLivingBase instanceof EntityPlayer) {
                int n = -1;
                if (this.func_70631_g_()) {
                    n = -3;
                }
                this.field_70954_d._a(((EntityPlayer)entityLivingBase).func_70005_c_(), n);
                if (this.func_70089_S()) {
                    this.field_70170_p.func_72960_a(this, (byte)13);
                }
            }
        }
    }

    @Override
    public void func_70645_a(jxtc jxtc2) {
        if (this.field_70954_d != null) {
            EntityPlayer entityPlayer;
            Entity entity = jxtc2.func_76346_g();
            if (entity != null) {
                if (entity instanceof EntityPlayer) {
                    this.field_70954_d._a(((EntityPlayer)entity).func_70005_c_(), -2);
                } else if (entity instanceof ezey) {
                    this.field_70954_d._m();
                }
            } else if (entity == null && (entityPlayer = this.field_70170_p.func_72890_a(this, 16.0)) != null) {
                this.field_70954_d._m();
            }
        }
        super.func_70645_a(jxtc2);
    }

    @Override
    public void func_70932_a_(EntityPlayer entityPlayer) {
        this.field_70962_h = entityPlayer;
    }

    @Override
    public EntityPlayer func_70931_l_() {
        return this.field_70962_h;
    }

    public boolean func_70940_q() {
        return this.field_70962_h != null;
    }

    @Override
    public void func_70933_a(ozjk ozjk2) {
        ozjk2._e();
        this.field_70757_a = -this.func_70627_aG();
        this.func_85030_a("mob.villager.yes", this.func_70599_aP(), this.func_70647_i());
        if (ozjk2._a((ozjk)this.field_70963_i.get(this.field_70963_i.size() - 1))) {
            this.field_70961_j = 40;
            this.field_70959_by = true;
            this.field_82189_bL = this.field_70962_h != null ? this.field_70962_h.func_70005_c_() : null;
        }
        if (ozjk2._a()._d == tgdv.field_77817_bH.field_77779_bT) {
            this.field_70956_bz += ozjk2._a()._b;
        }
    }

    @Override
    public void func_110297_a_(cvzo cvzo2) {
        if (!this.field_70170_p.field_72995_K && this.field_70757_a > -this.func_70627_aG() + 20) {
            this.field_70757_a = -this.func_70627_aG();
            if (cvzo2 != null) {
                this.func_85030_a("mob.villager.yes", this.func_70599_aP(), this.func_70647_i());
            } else {
                this.func_85030_a("mob.villager.no", this.func_70599_aP(), this.func_70647_i());
            }
        }
    }

    @Override
    public ywfi func_70934_b(EntityPlayer entityPlayer) {
        if (this.field_70963_i == null) {
            this.func_70950_c(1);
        }
        return this.field_70963_i;
    }

    public float func_82188_j(float f) {
        float f2 = f + this.field_82191_bN;
        return f2 > 0.9f ? 0.9f - (f2 - 0.9f) : f2;
    }

    public void func_70950_c(int n) {
        this.field_82191_bN = this.field_70963_i != null ? sajh._c(this.field_70963_i.size()) * 0.2f : 0.0f;
        ywfi ywfi2 = new ywfi();
        VillagerRegistry.manageVillagerTrades(ywfi2, this, this.func_70946_n(), this.field_70146_Z);
        switch (this.func_70946_n()) {
            case 0: {
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77685_T.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.9f));
                EntityVillager.func_70948_a(ywfi2, twgu.field_72101_ab.field_71990_ca, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77735_bk.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77753_aV.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.4f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77684_U.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.9f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77738_bf.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77706_j.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77743_bc.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77745_be.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77709_i.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77736_bl.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77704_l.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                if (!(this.field_70146_Z.nextFloat() < this.func_82188_j(0.5f))) break;
                ywfi2.add(new ozjk(new cvzo(twgu.field_71940_F, 10), new cvzo(tgdv.field_77817_bH), new cvzo(tgdv.field_77804_ap.field_77779_bT, 4 + this.field_70146_Z.nextInt(2), 0)));
                break;
            }
            case 1: {
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77759_aK.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.8f));
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77760_aL.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.8f));
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77823_bG.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, twgu.field_72093_an.field_71990_ca, this.field_70146_Z, this.func_82188_j(0.8f));
                EntityVillager.func_70949_b(ywfi2, twgu.field_71946_M.field_71990_ca, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77750_aQ.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77752_aS.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                if (!(this.field_70146_Z.nextFloat() < this.func_82188_j(0.07f))) break;
                Object object = zhqo._b[this.field_70146_Z.nextInt(zhqo._b.length)];
                int n2 = sajh._a(this.field_70146_Z, ((zhqo)object)._b(), ((zhqo)object)._c());
                cvzo cvzo2 = tgdv.field_92105_bW._a(new ixcc((zhqo)object, n2));
                int n3 = 2 + this.field_70146_Z.nextInt(5 + n2 * 10) + 3 * n2;
                ywfi2.add(new ozjk(new cvzo(tgdv.field_77760_aL), new cvzo(tgdv.field_77817_bH, n3), cvzo2));
                break;
            }
            case 2: {
                int n3;
                Object object;
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77748_bA.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77809_bD.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77767_aC.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.4f));
                EntityVillager.func_70949_b(ywfi2, twgu.field_72014_bd.field_71990_ca, this.field_70146_Z, this.func_82188_j(0.3f));
                Object object2 = object = (Object)new int[]{tgdv.field_77716_q.field_77779_bT, tgdv.field_77718_z.field_77779_bT, tgdv.field_77822_ae.field_77779_bT, tgdv.field_77798_ai.field_77779_bT, tgdv.field_77708_h.field_77779_bT, tgdv.field_77675_C.field_77779_bT, tgdv.field_77696_g.field_77779_bT, tgdv.field_77674_B.field_77779_bT};
                int n4 = ((Object)object).length;
                for (n3 = 0; n3 < n4; ++n3) {
                    Object object3 = object2[n3];
                    if (!(this.field_70146_Z.nextFloat() < this.func_82188_j(0.05f))) continue;
                    ywfi2.add(new ozjk(new cvzo((int)object3, 1, 0), new cvzo(tgdv.field_77817_bH, 2 + this.field_70146_Z.nextInt(3), 0), zhty._a(this.field_70146_Z, new cvzo((int)object3, 1, 0), 5 + this.field_70146_Z.nextInt(15))));
                }
                break;
            }
            case 3: {
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77705_m.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.7f));
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77703_o.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77717_p.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77702_n.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77716_q.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77718_z.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77708_h.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77675_C.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77696_g.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77674_B.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77695_f.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77673_A.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77689_P.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77688_Q.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77818_ag.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77794_ak.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77812_ad.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77820_ah.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77822_ae.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77798_ai.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77824_af.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77800_aj.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77810_ac.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.1f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77694_Z.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.1f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77814_aa.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.1f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77816_ab.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.1f));
                break;
            }
            case 4: {
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77705_m.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.7f));
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77784_aq.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70948_a(ywfi2, tgdv.field_77741_bi.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77765_aA.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.1f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77686_W.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77692_Y.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77687_V.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77693_X.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77782_ar.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
                EntityVillager.func_70949_b(ywfi2, tgdv.field_77734_bj.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3f));
            }
        }
        if (ywfi2.isEmpty()) {
            EntityVillager.func_70948_a(ywfi2, tgdv.field_77717_p.field_77779_bT, this.field_70146_Z, 1.0f);
        }
        Collections.shuffle(ywfi2);
        if (this.field_70963_i == null) {
            this.field_70963_i = new ywfi();
        }
        for (int i = 0; i < n && i < ywfi2.size(); ++i) {
            this.field_70963_i._a((ozjk)ywfi2.get(i));
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70930_a(ywfi ywfi2) {
    }

    public static void func_70948_a(ywfi ywfi2, int n, Random random, float f) {
        if (random.nextFloat() < f) {
            ywfi2.add(new ozjk(EntityVillager.func_70951_a(n, random), tgdv.field_77817_bH));
        }
    }

    public static cvzo func_70951_a(int n, Random random) {
        return new cvzo(n, EntityVillager.func_70944_b(n, random), 0);
    }

    public static int func_70944_b(int n, Random random) {
        idpz idpz2 = (idpz)field_70958_bB.get(n);
        return idpz2 == null ? 1 : ((Integer)idpz2._a() >= (Integer)idpz2._b() ? (Integer)idpz2._a() : (Integer)idpz2._a() + random.nextInt((Integer)idpz2._b() - (Integer)idpz2._a()));
    }

    public static void func_70949_b(ywfi ywfi2, int n, Random random, float f) {
        if (random.nextFloat() < f) {
            cvzo cvzo2;
            cvzo cvzo3;
            int n2 = EntityVillager.func_70943_c(n, random);
            if (n2 < 0) {
                cvzo3 = new cvzo(tgdv.field_77817_bH.field_77779_bT, 1, 0);
                cvzo2 = new cvzo(n, -n2, 0);
            } else {
                cvzo3 = new cvzo(tgdv.field_77817_bH.field_77779_bT, n2, 0);
                cvzo2 = new cvzo(n, 1, 0);
            }
            ywfi2.add(new ozjk(cvzo3, cvzo2));
        }
    }

    public static int func_70943_c(int n, Random random) {
        idpz idpz2 = (idpz)field_70960_bC.get(n);
        return idpz2 == null ? 1 : ((Integer)idpz2._a() >= (Integer)idpz2._b() ? (Integer)idpz2._a() : (Integer)idpz2._a() + random.nextInt((Integer)idpz2._b() - (Integer)idpz2._a()));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70103_a(byte by) {
        if (by == 12) {
            this.func_70942_a("heart");
        } else if (by == 13) {
            this.func_70942_a("angryVillager");
        } else if (by == 14) {
            this.func_70942_a("happyVillager");
        } else {
            super.func_70103_a(by);
        }
    }

    @Override
    public tupg func_110161_a(tupg tupg2) {
        tupg2 = super.func_110161_a(tupg2);
        VillagerRegistry.applyRandomTrade(this, this.field_70170_p.field_73012_v);
        return tupg2;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_70942_a(String string) {
        for (int i = 0; i < 5; ++i) {
            double d = this.field_70146_Z.nextGaussian() * 0.02;
            double d2 = this.field_70146_Z.nextGaussian() * 0.02;
            double d3 = this.field_70146_Z.nextGaussian() * 0.02;
            this.field_70170_p.func_72869_a(string, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, this.field_70163_u + 1.0 + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, d, d2, d3);
        }
    }

    public void func_82187_q() {
        this.field_82190_bM = true;
    }

    public EntityVillager func_90012_b(EntityAgeable entityAgeable) {
        EntityVillager entityVillager = new EntityVillager(this.field_70170_p);
        entityVillager.func_110161_a(null);
        return entityVillager;
    }

    @Override
    public boolean func_110164_bC() {
        return false;
    }

    @Override
    public EntityAgeable func_90011_a(EntityAgeable entityAgeable) {
        return this.func_90012_b(entityAgeable);
    }

    static {
        field_70958_bB.put(tgdv.field_77705_m.field_77779_bT, new idpz(16, 24));
        field_70958_bB.put(tgdv.field_77703_o.field_77779_bT, new idpz(8, 10));
        field_70958_bB.put(tgdv.field_77717_p.field_77779_bT, new idpz(8, 10));
        field_70958_bB.put(tgdv.field_77702_n.field_77779_bT, new idpz(4, 6));
        field_70958_bB.put(tgdv.field_77759_aK.field_77779_bT, new idpz(24, 36));
        field_70958_bB.put(tgdv.field_77760_aL.field_77779_bT, new idpz(11, 13));
        field_70958_bB.put(tgdv.field_77823_bG.field_77779_bT, new idpz(1, 1));
        field_70958_bB.put(tgdv.field_77730_bn.field_77779_bT, new idpz(3, 4));
        field_70958_bB.put(tgdv.field_77748_bA.field_77779_bT, new idpz(2, 3));
        field_70958_bB.put(tgdv.field_77784_aq.field_77779_bT, new idpz(14, 18));
        field_70958_bB.put(tgdv.field_77741_bi.field_77779_bT, new idpz(14, 18));
        field_70958_bB.put(tgdv.field_77735_bk.field_77779_bT, new idpz(14, 18));
        field_70958_bB.put(tgdv.field_77753_aV.field_77779_bT, new idpz(9, 13));
        field_70958_bB.put(tgdv.field_77690_S.field_77779_bT, new idpz(34, 48));
        field_70958_bB.put(tgdv.field_77740_bh.field_77779_bT, new idpz(30, 38));
        field_70958_bB.put(tgdv.field_77739_bg.field_77779_bT, new idpz(30, 38));
        field_70958_bB.put(tgdv.field_77685_T.field_77779_bT, new idpz(18, 22));
        field_70958_bB.put(twgu.field_72101_ab.field_71990_ca, new idpz(14, 22));
        field_70958_bB.put(tgdv.field_77737_bm.field_77779_bT, new idpz(36, 64));
        field_70960_bC.put(tgdv.field_77709_i.field_77779_bT, new idpz(3, 4));
        field_70960_bC.put(tgdv.field_77745_be.field_77779_bT, new idpz(3, 4));
        field_70960_bC.put(tgdv.field_77716_q.field_77779_bT, new idpz(7, 11));
        field_70960_bC.put(tgdv.field_77718_z.field_77779_bT, new idpz(12, 14));
        field_70960_bC.put(tgdv.field_77708_h.field_77779_bT, new idpz(6, 8));
        field_70960_bC.put(tgdv.field_77675_C.field_77779_bT, new idpz(9, 12));
        field_70960_bC.put(tgdv.field_77696_g.field_77779_bT, new idpz(7, 9));
        field_70960_bC.put(tgdv.field_77674_B.field_77779_bT, new idpz(10, 12));
        field_70960_bC.put(tgdv.field_77695_f.field_77779_bT, new idpz(4, 6));
        field_70960_bC.put(tgdv.field_77673_A.field_77779_bT, new idpz(7, 8));
        field_70960_bC.put(tgdv.field_77689_P.field_77779_bT, new idpz(4, 6));
        field_70960_bC.put(tgdv.field_77688_Q.field_77779_bT, new idpz(7, 8));
        field_70960_bC.put(tgdv.field_77818_ag.field_77779_bT, new idpz(4, 6));
        field_70960_bC.put(tgdv.field_77794_ak.field_77779_bT, new idpz(7, 8));
        field_70960_bC.put(tgdv.field_77812_ad.field_77779_bT, new idpz(4, 6));
        field_70960_bC.put(tgdv.field_77820_ah.field_77779_bT, new idpz(7, 8));
        field_70960_bC.put(tgdv.field_77822_ae.field_77779_bT, new idpz(10, 14));
        field_70960_bC.put(tgdv.field_77798_ai.field_77779_bT, new idpz(16, 19));
        field_70960_bC.put(tgdv.field_77824_af.field_77779_bT, new idpz(8, 10));
        field_70960_bC.put(tgdv.field_77800_aj.field_77779_bT, new idpz(11, 14));
        field_70960_bC.put(tgdv.field_77810_ac.field_77779_bT, new idpz(5, 7));
        field_70960_bC.put(tgdv.field_77694_Z.field_77779_bT, new idpz(5, 7));
        field_70960_bC.put(tgdv.field_77814_aa.field_77779_bT, new idpz(11, 15));
        field_70960_bC.put(tgdv.field_77816_ab.field_77779_bT, new idpz(9, 11));
        field_70960_bC.put(tgdv.field_77684_U.field_77779_bT, new idpz(-4, -2));
        field_70960_bC.put(tgdv.field_77738_bf.field_77779_bT, new idpz(-8, -4));
        field_70960_bC.put(tgdv.field_77706_j.field_77779_bT, new idpz(-8, -4));
        field_70960_bC.put(tgdv.field_77743_bc.field_77779_bT, new idpz(-10, -7));
        field_70960_bC.put(twgu.field_71946_M.field_71990_ca, new idpz(-5, -3));
        field_70960_bC.put(twgu.field_72093_an.field_71990_ca, new idpz(3, 4));
        field_70960_bC.put(tgdv.field_77686_W.field_77779_bT, new idpz(4, 5));
        field_70960_bC.put(tgdv.field_77692_Y.field_77779_bT, new idpz(2, 4));
        field_70960_bC.put(tgdv.field_77687_V.field_77779_bT, new idpz(2, 4));
        field_70960_bC.put(tgdv.field_77693_X.field_77779_bT, new idpz(2, 4));
        field_70960_bC.put(tgdv.field_77765_aA.field_77779_bT, new idpz(6, 8));
        field_70960_bC.put(tgdv.field_77809_bD.field_77779_bT, new idpz(-4, -1));
        field_70960_bC.put(tgdv.field_77767_aC.field_77779_bT, new idpz(-4, -1));
        field_70960_bC.put(tgdv.field_77750_aQ.field_77779_bT, new idpz(10, 12));
        field_70960_bC.put(tgdv.field_77752_aS.field_77779_bT, new idpz(10, 12));
        field_70960_bC.put(twgu.field_72014_bd.field_71990_ca, new idpz(-3, -1));
        field_70960_bC.put(tgdv.field_77782_ar.field_77779_bT, new idpz(-7, -5));
        field_70960_bC.put(tgdv.field_77734_bj.field_77779_bT, new idpz(-7, -5));
        field_70960_bC.put(tgdv.field_77736_bl.field_77779_bT, new idpz(-8, -6));
        field_70960_bC.put(tgdv.field_77748_bA.field_77779_bT, new idpz(7, 11));
        field_70960_bC.put(tgdv.field_77704_l.field_77779_bT, new idpz(-12, -8));
    }
}

