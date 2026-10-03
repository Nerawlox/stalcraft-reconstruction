/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.ezfc;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjwj;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.srok;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.eidj;
import net.minecraft.entity.passive.pidb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tupg;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityHorse
extends EntityAnimal
implements suea {
    public static final zhos field_110276_bu = new pidb();
    public static final txei field_110271_bv = new bbnt("horse.jumpStrength", 0.7, 0.0, 2.0)._a("Jump Strength")._a(true);
    public static final String[] field_110270_bw = new String[]{null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png"};
    public static final String[] field_110273_bx = new String[]{"", "meo", "goo", "dio"};
    public static final int[] field_110272_by = new int[]{0, 5, 7, 11};
    public static final String[] field_110268_bz = new String[]{"textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png"};
    public static final String[] field_110269_bA = new String[]{"hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb"};
    public static final String[] field_110291_bB = new String[]{null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png"};
    public static final String[] field_110292_bC = new String[]{"", "wo_", "wmo", "wdo", "bdo"};
    public int field_110289_bD;
    public int field_110290_bE;
    public int field_110295_bF;
    public int field_110278_bp;
    public int field_110279_bq;
    public boolean field_110275_br;
    public ohtz field_110296_bG;
    public boolean field_110293_bH;
    public int field_110274_bs;
    public float field_110277_bt;
    public boolean field_110294_bI;
    public float field_110283_bJ;
    public float field_110284_bK;
    public float field_110281_bL;
    public float field_110282_bM;
    public float field_110287_bN;
    public float field_110288_bO;
    public int field_110285_bP;
    public String field_110286_bQ;
    public String[] field_110280_bR = new String[3];

    public EntityHorse(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(1.4f, 1.6f);
        this.field_70178_ae = false;
        this.func_110207_m(false);
        this.func_70661_as()._a(true);
        this.field_70714_bg._a(0, new tdpx(this));
        this.field_70714_bg._a(1, new kjwj(this, 1.2));
        this.field_70714_bg._a(1, new srok(this, 1.2));
        this.field_70714_bg._a(2, new srli(this, 1.0));
        this.field_70714_bg._a(4, new ezfc(this, 1.0));
        this.field_70714_bg._a(6, new iurn(this, 0.7));
        this.field_70714_bg._a(7, new iurq(this, EntityPlayer.class, 6.0f));
        this.field_70714_bg._a(8, new tdmn(this));
        this.func_110226_cD();
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, (Object)0);
        this.field_70180_af._a(19, (Object)0);
        this.field_70180_af._a(20, (Object)0);
        this.field_70180_af._a(21, String.valueOf(""));
        this.field_70180_af._a(22, (Object)0);
    }

    public void func_110214_p(int n) {
        this.field_70180_af._b(19, (byte)n);
        this.func_110230_cF();
    }

    public int func_110265_bP() {
        return this.field_70180_af._a(19);
    }

    public void func_110235_q(int n) {
        this.field_70180_af._b(20, n);
        this.func_110230_cF();
    }

    public int func_110202_bQ() {
        return this.field_70180_af._c(20);
    }

    @Override
    public String func_70023_ak() {
        if (this.func_94056_bM()) {
            return this.func_94057_bL();
        }
        int n = this.func_110265_bP();
        switch (n) {
            default: {
                return net.minecraft.util.tdpx._a("entity.horse.name");
            }
            case 1: {
                return net.minecraft.util.tdpx._a("entity.donkey.name");
            }
            case 2: {
                return net.minecraft.util.tdpx._a("entity.mule.name");
            }
            case 4: {
                return net.minecraft.util.tdpx._a("entity.skeletonhorse.name");
            }
            case 3: 
        }
        return net.minecraft.util.tdpx._a("entity.zombiehorse.name");
    }

    public boolean func_110233_w(int n) {
        return (this.field_70180_af._c(16) & n) != 0;
    }

    public void func_110208_b(int n, boolean bl) {
        int n2 = this.field_70180_af._c(16);
        if (bl) {
            this.field_70180_af._b(16, n2 | n);
        } else {
            this.field_70180_af._b(16, n2 & ~n);
        }
    }

    public boolean func_110228_bR() {
        return !this.func_70631_g_();
    }

    public boolean func_110248_bS() {
        return this.func_110233_w(2);
    }

    public boolean func_110253_bW() {
        return this.func_110228_bR();
    }

    public String func_142019_cb() {
        return this.field_70180_af._e(21);
    }

    public void func_110213_b(String string) {
        this.field_70180_af._b(21, string);
    }

    public float func_110254_bY() {
        int n = this.func_70874_b();
        if (n >= 0) {
            return 1.0f;
        }
        return 0.5f + (float)(-24000 - n) / -24000.0f * 0.5f;
    }

    @Override
    public void func_98054_a(boolean bl) {
        if (bl) {
            this.func_98055_j(this.func_110254_bY());
        } else {
            this.func_98055_j(1.0f);
        }
    }

    public boolean func_110246_bZ() {
        return this.field_110275_br;
    }

    public void func_110234_j(boolean bl) {
        this.func_110208_b(2, bl);
    }

    public void func_110255_k(boolean bl) {
        this.field_110275_br = bl;
    }

    @Override
    public boolean func_110164_bC() {
        return !this.func_110256_cu() && super.func_110164_bC();
    }

    @Override
    public void func_142017_o(float f) {
        if (f > 6.0f && this.func_110204_cc()) {
            this.func_110227_p(false);
        }
    }

    public boolean func_110261_ca() {
        return this.func_110233_w(8);
    }

    public int func_110241_cb() {
        return this.field_70180_af._c(22);
    }

    public int func_110260_d(cvzo cvzo2) {
        if (cvzo2 == null) {
            return 0;
        }
        if (cvzo2._d == tgdv.field_111215_ce.field_77779_bT) {
            return 1;
        }
        if (cvzo2._d == tgdv.field_111216_cf.field_77779_bT) {
            return 2;
        }
        if (cvzo2._d == tgdv.field_111213_cg.field_77779_bT) {
            return 3;
        }
        return 0;
    }

    public boolean func_110204_cc() {
        return this.func_110233_w(32);
    }

    public boolean func_110209_cd() {
        return this.func_110233_w(64);
    }

    public boolean func_110205_ce() {
        return this.func_110233_w(16);
    }

    public boolean func_110243_cf() {
        return this.field_110293_bH;
    }

    public void func_110236_r(int n) {
        this.field_70180_af._b(22, n);
        this.func_110230_cF();
    }

    public void func_110242_l(boolean bl) {
        this.func_110208_b(16, bl);
    }

    public void func_110207_m(boolean bl) {
        this.func_110208_b(8, bl);
    }

    public void func_110221_n(boolean bl) {
        this.field_110293_bH = bl;
    }

    public void func_110251_o(boolean bl) {
        this.func_110208_b(4, bl);
    }

    public int func_110252_cg() {
        return this.field_110274_bs;
    }

    public void func_110238_s(int n) {
        this.field_110274_bs = n;
    }

    public int func_110198_t(int n) {
        int n2 = sajh._a(this.func_110252_cg() + n, 0, this.func_110218_cm());
        this.func_110238_s(n2);
        return n2;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        Entity entity = jxtc2.func_76346_g();
        if (this.field_70153_n != null && this.field_70153_n.equals(entity)) {
            return false;
        }
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public int func_70658_aO() {
        return field_110272_by[this.func_110241_cb()];
    }

    @Override
    public boolean func_70104_M() {
        return this.field_70153_n == null;
    }

    public boolean func_110262_ch() {
        int n = sajh._c(this.field_70165_t);
        int n2 = sajh._c(this.field_70161_v);
        this.field_70170_p.func_72807_a(n, n2);
        return true;
    }

    public void func_110224_ci() {
        if (this.field_70170_p.field_72995_K || !this.func_110261_ca()) {
            return;
        }
        this.func_70025_b(twgu.field_72077_au.field_71990_ca, 1);
        this.func_110207_m(false);
    }

    public void func_110266_cB() {
        this.func_110249_cI();
        this.field_70170_p.func_72956_a(this, "eating", 1.0f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f);
    }

    @Override
    public void func_70069_a(float f) {
        int n;
        int n2;
        if (f > 1.0f) {
            this.func_85030_a("mob.horse.land", 0.4f, 1.0f);
        }
        if ((n2 = sajh._f(f * 0.5f - 3.0f)) <= 0) {
            return;
        }
        this.func_70097_a(jxtc.field_76379_h, n2);
        if (this.field_70153_n != null) {
            this.field_70153_n.func_70097_a(jxtc.field_76379_h, n2);
        }
        if ((n = this.field_70170_p.func_72798_a(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u - 0.2 - (double)this.field_70126_B), sajh._c(this.field_70161_v))) > 0) {
            uioo uioo2 = twgu.field_71973_m[n].field_72020_cn;
            this.field_70170_p.func_72956_a(this, uioo2._d(), uioo2._a() * 0.5f, uioo2._b() * 0.75f);
        }
    }

    public int func_110225_cC() {
        int n = this.func_110265_bP();
        if (this.func_110261_ca() && (n == 1 || n == 2)) {
            return 17;
        }
        return 2;
    }

    public void func_110226_cD() {
        ohtz ohtz2 = this.field_110296_bG;
        this.field_110296_bG = new ohtz("HorseChest", this.func_110225_cC());
        this.field_110296_bG._a(this.func_70023_ak());
        if (ohtz2 != null) {
            ohtz2._b(this);
            int n = Math.min(ohtz2.func_70302_i_(), this.field_110296_bG.func_70302_i_());
            for (int i = 0; i < n; ++i) {
                cvzo cvzo2 = ohtz2.func_70301_a(i);
                if (cvzo2 == null) continue;
                this.field_110296_bG.func_70299_a(i, cvzo2._l());
            }
            ohtz2 = null;
        }
        this.field_110296_bG._a(this);
        this.func_110232_cE();
    }

    public void func_110232_cE() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_110251_o(this.field_110296_bG.func_70301_a(0) != null);
            if (this.func_110259_cr()) {
                this.func_110236_r(this.func_110260_d(this.field_110296_bG.func_70301_a(1)));
            }
        }
    }

    @Override
    public void func_76316_a(tgfo tgfo2) {
        int n = this.func_110241_cb();
        boolean bl = this.func_110257_ck();
        this.func_110232_cE();
        if (this.field_70173_aa > 20) {
            if (n == 0 && n != this.func_110241_cb()) {
                this.func_85030_a("mob.horse.armor", 0.5f, 1.0f);
            }
            if (!bl && this.func_110257_ck()) {
                this.func_85030_a("mob.horse.leather", 0.5f, 1.0f);
            }
        }
    }

    @Override
    public boolean func_70601_bi() {
        this.func_110262_ch();
        return super.func_70601_bi();
    }

    public EntityHorse func_110250_a(Entity entity, double d) {
        double d2 = Double.MAX_VALUE;
        Entity entity2 = null;
        List list = this.field_70170_p.func_94576_a(entity, entity.field_70121_D._a(d, d, d), field_110276_bu);
        for (Entity entity3 : list) {
            double d3 = entity3.func_70092_e(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
            if (!(d3 < d2)) continue;
            entity2 = entity3;
            d2 = d3;
        }
        return (EntityHorse)entity2;
    }

    public double func_110215_cj() {
        return this.func_110148_a(field_110271_bv)._e();
    }

    @Override
    public String func_70673_aS() {
        this.func_110249_cI();
        int n = this.func_110265_bP();
        if (n == 3) {
            return "mob.horse.zombie.death";
        }
        if (n == 4) {
            return "mob.horse.skeleton.death";
        }
        if (n == 1 || n == 2) {
            return "mob.horse.donkey.death";
        }
        return "mob.horse.death";
    }

    @Override
    public int func_70633_aT() {
        boolean bl = this.field_70146_Z.nextInt(4) == 0;
        int n = this.func_110265_bP();
        if (n == 4) {
            return tgdv.field_77755_aX.field_77779_bT;
        }
        if (n == 3) {
            if (bl) {
                return 0;
            }
            return tgdv.field_77737_bm.field_77779_bT;
        }
        return tgdv.field_77770_aF.field_77779_bT;
    }

    @Override
    public String func_70621_aR() {
        int n;
        this.func_110249_cI();
        if (this.field_70146_Z.nextInt(3) == 0) {
            this.func_110220_cK();
        }
        if ((n = this.func_110265_bP()) == 3) {
            return "mob.horse.zombie.hit";
        }
        if (n == 4) {
            return "mob.horse.skeleton.hit";
        }
        if (n == 1 || n == 2) {
            return "mob.horse.donkey.hit";
        }
        return "mob.horse.hit";
    }

    public boolean func_110257_ck() {
        return this.func_110233_w(4);
    }

    @Override
    public String func_70639_aQ() {
        int n;
        this.func_110249_cI();
        if (this.field_70146_Z.nextInt(10) == 0 && !this.func_70610_aX()) {
            this.func_110220_cK();
        }
        if ((n = this.func_110265_bP()) == 3) {
            return "mob.horse.zombie.idle";
        }
        if (n == 4) {
            return "mob.horse.skeleton.idle";
        }
        if (n == 1 || n == 2) {
            return "mob.horse.donkey.idle";
        }
        return "mob.horse.idle";
    }

    public String func_110217_cl() {
        this.func_110249_cI();
        this.func_110220_cK();
        int n = this.func_110265_bP();
        if (n == 3 || n == 4) {
            return null;
        }
        if (n == 1 || n == 2) {
            return "mob.horse.donkey.angry";
        }
        return "mob.horse.angry";
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        uioo uioo2 = twgu.field_71973_m[n4].field_72020_cn;
        if (this.field_70170_p.func_72798_a(n, n2 + 1, n3) == twgu.field_72037_aS.field_71990_ca) {
            uioo2 = twgu.field_72037_aS.field_72020_cn;
        }
        if (!twgu.field_71973_m[n4].field_72018_cp._d()) {
            int n5 = this.func_110265_bP();
            if (this.field_70153_n != null && n5 != 1 && n5 != 2) {
                ++this.field_110285_bP;
                if (this.field_110285_bP > 5 && this.field_110285_bP % 3 == 0) {
                    this.func_85030_a("mob.horse.gallop", uioo2._a() * 0.15f, uioo2._b());
                    if (n5 == 0 && this.field_70146_Z.nextInt(10) == 0) {
                        this.func_85030_a("mob.horse.breathe", uioo2._a() * 0.6f, uioo2._b());
                    }
                } else if (this.field_110285_bP <= 5) {
                    this.func_85030_a("mob.horse.wood", uioo2._a() * 0.15f, uioo2._b());
                }
            } else if (uioo2 == twgu.field_71967_e) {
                this.func_85030_a("mob.horse.soft", uioo2._a() * 0.15f, uioo2._b());
            } else {
                this.func_85030_a("mob.horse.wood", uioo2._a() * 0.15f, uioo2._b());
            }
        }
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110140_aT()._b(field_110271_bv);
        this.func_110148_a(sajz._a)._a(53.0);
        this.func_110148_a(sajz._d)._a(0.225f);
    }

    @Override
    public int func_70641_bl() {
        return 6;
    }

    public int func_110218_cm() {
        return 100;
    }

    @Override
    public float func_70599_aP() {
        return 0.8f;
    }

    @Override
    public int func_70627_aG() {
        return 400;
    }

    public boolean func_110239_cn() {
        return this.func_110265_bP() == 0 || this.func_110241_cb() > 0;
    }

    public void func_110230_cF() {
        this.field_110286_bQ = null;
    }

    public void func_110247_cG() {
        int n;
        this.field_110286_bQ = "horse/";
        this.field_110280_bR[0] = null;
        this.field_110280_bR[1] = null;
        this.field_110280_bR[2] = null;
        int n2 = this.func_110265_bP();
        int n3 = this.func_110202_bQ();
        if (n2 == 0) {
            n = n3 & 0xFF;
            int n4 = (n3 & 0xFF00) >> 8;
            this.field_110280_bR[0] = field_110268_bz[n];
            this.field_110286_bQ = this.field_110286_bQ + field_110269_bA[n];
            this.field_110280_bR[1] = field_110291_bB[n4];
            this.field_110286_bQ = this.field_110286_bQ + field_110292_bC[n4];
        } else {
            this.field_110280_bR[0] = "";
            this.field_110286_bQ = this.field_110286_bQ + "_" + n2 + "_";
        }
        n = this.func_110241_cb();
        this.field_110280_bR[2] = field_110270_bw[n];
        this.field_110286_bQ = this.field_110286_bQ + field_110273_bx[n];
    }

    public String func_110264_co() {
        if (this.field_110286_bQ == null) {
            this.func_110247_cG();
        }
        return this.field_110286_bQ;
    }

    public String[] func_110212_cp() {
        if (this.field_110286_bQ == null) {
            this.func_110247_cG();
        }
        return this.field_110280_bR;
    }

    public void func_110199_f(EntityPlayer entityPlayer) {
        if (!this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == entityPlayer) && this.func_110248_bS()) {
            this.field_110296_bG._a(this.func_70023_ak());
            entityPlayer.func_110298_a(this, this.field_110296_bG);
        }
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 != null && cvzo2._d == tgdv.field_77815_bC.field_77779_bT) {
            return super.func_70085_c(entityPlayer);
        }
        if (!this.func_110248_bS() && this.func_110256_cu()) {
            return false;
        }
        if (this.func_110248_bS() && this.func_110228_bR() && entityPlayer.func_70093_af()) {
            this.func_110199_f(entityPlayer);
            return true;
        }
        if (this.func_110253_bW() && this.field_70153_n != null) {
            return super.func_70085_c(entityPlayer);
        }
        if (cvzo2 != null) {
            boolean bl = false;
            if (this.func_110259_cr()) {
                int n = -1;
                if (cvzo2._d == tgdv.field_111215_ce.field_77779_bT) {
                    n = 1;
                } else if (cvzo2._d == tgdv.field_111216_cf.field_77779_bT) {
                    n = 2;
                } else if (cvzo2._d == tgdv.field_111213_cg.field_77779_bT) {
                    n = 3;
                }
                if (n >= 0) {
                    if (!this.func_110248_bS()) {
                        this.func_110231_cz();
                        return true;
                    }
                    this.func_110199_f(entityPlayer);
                    return true;
                }
            }
            if (!bl && !this.func_110256_cu()) {
                float f = 0.0f;
                int n = 0;
                int n2 = 0;
                if (cvzo2._d == tgdv.field_77685_T.field_77779_bT) {
                    f = 2.0f;
                    n = 60;
                    n2 = 3;
                } else if (cvzo2._d == tgdv.field_77747_aY.field_77779_bT) {
                    f = 1.0f;
                    n = 30;
                    n2 = 3;
                } else if (cvzo2._d == tgdv.field_77684_U.field_77779_bT) {
                    f = 7.0f;
                    n = 180;
                    n2 = 3;
                } else if (cvzo2._d == twgu.field_111038_cB.field_71990_ca) {
                    f = 20.0f;
                    n = 180;
                } else if (cvzo2._d == tgdv.field_77706_j.field_77779_bT) {
                    f = 3.0f;
                    n = 60;
                    n2 = 3;
                } else if (cvzo2._d == tgdv.field_82798_bP.field_77779_bT) {
                    f = 4.0f;
                    n = 60;
                    n2 = 5;
                    if (this.func_110248_bS() && this.func_70874_b() == 0) {
                        bl = true;
                        this.func_110196_bT();
                    }
                } else if (cvzo2._d == tgdv.field_77778_at.field_77779_bT) {
                    f = 10.0f;
                    n = 240;
                    n2 = 10;
                    if (this.func_110248_bS() && this.func_70874_b() == 0) {
                        bl = true;
                        this.func_110196_bT();
                    }
                }
                if (this.func_110143_aJ() < this.func_110138_aP() && f > 0.0f) {
                    this.func_70691_i(f);
                    bl = true;
                }
                if (!this.func_110228_bR() && n > 0) {
                    this.func_110195_a(n);
                    bl = true;
                }
                if (n2 > 0 && (bl || !this.func_110248_bS()) && n2 < this.func_110218_cm()) {
                    bl = true;
                    this.func_110198_t(n2);
                }
                if (bl) {
                    this.func_110266_cB();
                }
            }
            if (!this.func_110248_bS() && !bl) {
                if (cvzo2 != null && cvzo2._a(entityPlayer, (EntityLivingBase)this)) {
                    return true;
                }
                this.func_110231_cz();
                return true;
            }
            if (!bl && this.func_110229_cs() && !this.func_110261_ca() && cvzo2._d == twgu.field_72077_au.field_71990_ca) {
                this.func_110207_m(true);
                this.func_85030_a("mob.chickenplop", 1.0f, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
                bl = true;
                this.func_110226_cD();
            }
            if (!bl && this.func_110253_bW() && !this.func_110257_ck() && cvzo2._d == tgdv.field_77765_aA.field_77779_bT) {
                this.func_110199_f(entityPlayer);
                return true;
            }
            if (bl) {
                if (!entityPlayer.field_71075_bZ._d && --cvzo2._b == 0) {
                    entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
                }
                return true;
            }
        }
        if (this.func_110253_bW() && this.field_70153_n == null) {
            if (cvzo2 != null && cvzo2._a(entityPlayer, (EntityLivingBase)this)) {
                return true;
            }
            this.func_110237_h(entityPlayer);
            return true;
        }
        return super.func_70085_c(entityPlayer);
    }

    public void func_110237_h(EntityPlayer entityPlayer) {
        entityPlayer.field_70177_z = this.field_70177_z;
        entityPlayer.field_70125_A = this.field_70125_A;
        this.func_110227_p(false);
        this.func_110219_q(false);
        if (!this.field_70170_p.field_72995_K) {
            entityPlayer.func_70078_a(this);
        }
    }

    public boolean func_110259_cr() {
        return this.func_110265_bP() == 0;
    }

    public boolean func_110229_cs() {
        int n = this.func_110265_bP();
        return n == 2 || n == 1;
    }

    @Override
    public boolean func_70610_aX() {
        if (this.field_70153_n != null && this.func_110257_ck()) {
            return true;
        }
        return this.func_110204_cc() || this.func_110209_cd();
    }

    public boolean func_110256_cu() {
        int n = this.func_110265_bP();
        return n == 3 || n == 4;
    }

    public boolean func_110222_cv() {
        return this.func_110256_cu() || this.func_110265_bP() == 2;
    }

    @Override
    public boolean func_70877_b(cvzo cvzo2) {
        return false;
    }

    public void func_110210_cH() {
        this.field_110278_bp = 1;
    }

    @Override
    public void func_70645_a(jxtc jxtc2) {
        super.func_70645_a(jxtc2);
        if (!this.field_70170_p.field_72995_K) {
            this.func_110244_cA();
        }
    }

    @Override
    public void func_70636_d() {
        if (this.field_70146_Z.nextInt(200) == 0) {
            this.func_110210_cH();
        }
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            EntityHorse entityHorse;
            if (this.field_70146_Z.nextInt(900) == 0 && this.field_70725_aQ == 0) {
                this.func_70691_i(1.0f);
            }
            if (!this.func_110204_cc() && this.field_70153_n == null && this.field_70146_Z.nextInt(300) == 0 && this.field_70170_p.func_72798_a(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u) - 1, sajh._c(this.field_70161_v)) == twgu.field_71980_u.field_71990_ca) {
                this.func_110227_p(true);
            }
            if (this.func_110204_cc() && ++this.field_110289_bD > 50) {
                this.field_110289_bD = 0;
                this.func_110227_p(false);
            }
            if (this.func_110205_ce() && !this.func_110228_bR() && !this.func_110204_cc() && (entityHorse = this.func_110250_a(this, 16.0)) != null && this.func_70068_e(entityHorse) > 4.0) {
                suqn suqn2 = this.field_70170_p.func_72865_a(this, entityHorse, 16.0f, true, false, false, true);
                this.func_70778_a(suqn2);
            }
        }
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K && this.field_70180_af._a()) {
            this.field_70180_af._e();
            this.func_110230_cF();
        }
        if (this.field_110290_bE > 0 && ++this.field_110290_bE > 30) {
            this.field_110290_bE = 0;
            this.func_110208_b(128, false);
        }
        if (!this.field_70170_p.field_72995_K && this.field_110295_bF > 0 && ++this.field_110295_bF > 20) {
            this.field_110295_bF = 0;
            this.func_110219_q(false);
        }
        if (this.field_110278_bp > 0 && ++this.field_110278_bp > 8) {
            this.field_110278_bp = 0;
        }
        if (this.field_110279_bq > 0) {
            ++this.field_110279_bq;
            if (this.field_110279_bq > 300) {
                this.field_110279_bq = 0;
            }
        }
        this.field_110284_bK = this.field_110283_bJ;
        if (this.func_110204_cc()) {
            this.field_110283_bJ += (1.0f - this.field_110283_bJ) * 0.4f + 0.05f;
            if (this.field_110283_bJ > 1.0f) {
                this.field_110283_bJ = 1.0f;
            }
        } else {
            this.field_110283_bJ += (0.0f - this.field_110283_bJ) * 0.4f - 0.05f;
            if (this.field_110283_bJ < 0.0f) {
                this.field_110283_bJ = 0.0f;
            }
        }
        this.field_110282_bM = this.field_110281_bL;
        if (this.func_110209_cd()) {
            this.field_110283_bJ = 0.0f;
            this.field_110284_bK = 0.0f;
            this.field_110281_bL += (1.0f - this.field_110281_bL) * 0.4f + 0.05f;
            if (this.field_110281_bL > 1.0f) {
                this.field_110281_bL = 1.0f;
            }
        } else {
            this.field_110294_bI = false;
            this.field_110281_bL += (0.8f * this.field_110281_bL * this.field_110281_bL * this.field_110281_bL - this.field_110281_bL) * 0.6f - 0.05f;
            if (this.field_110281_bL < 0.0f) {
                this.field_110281_bL = 0.0f;
            }
        }
        this.field_110288_bO = this.field_110287_bN;
        if (this.func_110233_w(128)) {
            this.field_110287_bN += (1.0f - this.field_110287_bN) * 0.7f + 0.05f;
            if (this.field_110287_bN > 1.0f) {
                this.field_110287_bN = 1.0f;
            }
        } else {
            this.field_110287_bN += (0.0f - this.field_110287_bN) * 0.7f - 0.05f;
            if (this.field_110287_bN < 0.0f) {
                this.field_110287_bN = 0.0f;
            }
        }
    }

    public void func_110249_cI() {
        if (!this.field_70170_p.field_72995_K) {
            this.field_110290_bE = 1;
            this.func_110208_b(128, true);
        }
    }

    public boolean func_110200_cJ() {
        return this.field_70153_n == null && this.field_70154_o == null && this.func_110248_bS() && this.func_110228_bR() && !this.func_110222_cv() && this.func_110143_aJ() >= this.func_110138_aP();
    }

    @Override
    public void func_70019_c(boolean bl) {
        this.func_110208_b(32, bl);
    }

    public void func_110227_p(boolean bl) {
        this.func_70019_c(bl);
    }

    public void func_110219_q(boolean bl) {
        if (bl) {
            this.func_110227_p(false);
        }
        this.func_110208_b(64, bl);
    }

    public void func_110220_cK() {
        if (!this.field_70170_p.field_72995_K) {
            this.field_110295_bF = 1;
            this.func_110219_q(true);
        }
    }

    public void func_110231_cz() {
        this.func_110220_cK();
        String string = this.func_110217_cl();
        if (string != null) {
            this.func_85030_a(string, this.func_70599_aP(), this.func_70647_i());
        }
    }

    public void func_110244_cA() {
        this.func_110240_a(this, this.field_110296_bG);
        this.func_110224_ci();
    }

    public void func_110240_a(Entity entity, ohtz ohtz2) {
        if (ohtz2 == null || this.field_70170_p.field_72995_K) {
            return;
        }
        for (int i = 0; i < ohtz2.func_70302_i_(); ++i) {
            cvzo cvzo2 = ohtz2.func_70301_a(i);
            if (cvzo2 == null) continue;
            this.func_70099_a(cvzo2, 0.0f);
        }
    }

    public boolean func_110263_g(EntityPlayer entityPlayer) {
        this.func_110213_b(entityPlayer.func_70005_c_());
        this.func_110234_j(true);
        return true;
    }

    @Override
    public void func_70612_e(float f, float f2) {
        if (this.field_70153_n == null || !this.func_110257_ck()) {
            this.field_70138_W = 0.5f;
            this.field_70747_aH = 0.02f;
            super.func_70612_e(f, f2);
            return;
        }
        this.field_70126_B = this.field_70177_z = this.field_70153_n.field_70177_z;
        this.field_70125_A = this.field_70153_n.field_70125_A * 0.5f;
        this.func_70101_b(this.field_70177_z, this.field_70125_A);
        this.field_70759_as = this.field_70761_aq = this.field_70177_z;
        f = ((EntityLivingBase)this.field_70153_n).field_70702_br * 0.5f;
        f2 = ((EntityLivingBase)this.field_70153_n).field_70701_bs;
        if (f2 <= 0.0f) {
            f2 *= 0.25f;
            this.field_110285_bP = 0;
        }
        if (this.field_70122_E && this.field_110277_bt == 0.0f && this.func_110209_cd() && !this.field_110294_bI) {
            f = 0.0f;
            f2 = 0.0f;
        }
        if (this.field_110277_bt > 0.0f && !this.func_110246_bZ() && this.field_70122_E) {
            this.field_70181_x = this.func_110215_cj() * (double)this.field_110277_bt;
            if (this.func_70644_a(hdpq._j)) {
                this.field_70181_x += (double)((float)(this.func_70660_b(hdpq._j)._c() + 1) * 0.1f);
            }
            this.func_110255_k(true);
            this.field_70160_al = true;
            if (f2 > 0.0f) {
                float f3 = sajh._a(this.field_70177_z * (float)Math.PI / 180.0f);
                float f4 = sajh._b(this.field_70177_z * (float)Math.PI / 180.0f);
                this.field_70159_w += (double)(-0.4f * f3 * this.field_110277_bt);
                this.field_70179_y += (double)(0.4f * f4 * this.field_110277_bt);
                this.func_85030_a("mob.horse.jump", 0.4f, 1.0f);
            }
            this.field_110277_bt = 0.0f;
        }
        this.field_70138_W = 1.0f;
        this.field_70747_aH = this.func_70689_ay() * 0.1f;
        if (!this.field_70170_p.field_72995_K) {
            this.func_70659_e((float)this.func_110148_a(sajz._d)._e());
            super.func_70612_e(f, f2);
        }
        if (this.field_70122_E) {
            this.field_110277_bt = 0.0f;
            this.func_110255_k(false);
        }
        this.field_70722_aY = this.field_70721_aZ;
        double d = this.field_70165_t - this.field_70169_q;
        double d2 = this.field_70161_v - this.field_70166_s;
        float f5 = sajh._a(d * d + d2 * d2) * 4.0f;
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        this.field_70721_aZ += (f5 - this.field_70721_aZ) * 0.4f;
        this.field_70754_ba += this.field_70721_aZ;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("EatingHaystack", this.func_110204_cc());
        qoac2._a("ChestedHorse", this.func_110261_ca());
        qoac2._a("HasReproduced", this.func_110243_cf());
        qoac2._a("Bred", this.func_110205_ce());
        qoac2._a("Type", this.func_110265_bP());
        qoac2._a("Variant", this.func_110202_bQ());
        qoac2._a("Temper", this.func_110252_cg());
        qoac2._a("Tame", this.func_110248_bS());
        qoac2._a("OwnerName", this.func_142019_cb());
        if (this.func_110261_ca()) {
            bsyv bsyv2 = new bsyv();
            for (int i = 2; i < this.field_110296_bG.func_70302_i_(); ++i) {
                cvzo cvzo2 = this.field_110296_bG.func_70301_a(i);
                if (cvzo2 == null) continue;
                qoac qoac3 = new qoac();
                qoac3._a("Slot", (byte)i);
                cvzo2._b(qoac3);
                bsyv2._a(qoac3);
            }
            qoac2._a("Items", bsyv2);
        }
        if (this.field_110296_bG.func_70301_a(1) != null) {
            qoac2._a("ArmorItem", (huhy)this.field_110296_bG.func_70301_a(1)._b(new qoac("ArmorItem")));
        }
        if (this.field_110296_bG.func_70301_a(0) != null) {
            qoac2._a("SaddleItem", (huhy)this.field_110296_bG.func_70301_a(0)._b(new qoac("SaddleItem")));
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        Object object;
        hubf hubf2;
        super.func_70037_a(qoac2);
        this.func_110227_p(qoac2._o("EatingHaystack"));
        this.func_110242_l(qoac2._o("Bred"));
        this.func_110207_m(qoac2._o("ChestedHorse"));
        this.func_110221_n(qoac2._o("HasReproduced"));
        this.func_110214_p(qoac2._f("Type"));
        this.func_110235_q(qoac2._f("Variant"));
        this.func_110238_s(qoac2._f("Temper"));
        this.func_110234_j(qoac2._o("Tame"));
        if (qoac2._c("OwnerName")) {
            this.func_110213_b(qoac2._j("OwnerName"));
        }
        if ((hubf2 = this.func_110140_aT()._a("Speed")) != null) {
            this.func_110148_a(sajz._d)._a(hubf2._b() * 0.25);
        }
        if (this.func_110261_ca()) {
            object = qoac2._n("Items");
            this.func_110226_cD();
            for (int i = 0; i < ((bsyv)object)._d(); ++i) {
                qoac qoac3 = (qoac)((bsyv)object)._b(i);
                int n = qoac3._d("Slot") & 0xFF;
                if (n < 2 || n >= this.field_110296_bG.func_70302_i_()) continue;
                this.field_110296_bG.func_70299_a(n, cvzo._a(qoac3));
            }
        }
        if (qoac2._c("ArmorItem") && (object = cvzo._a(qoac2._m("ArmorItem"))) != null && EntityHorse.func_110211_v(((cvzo)object)._d)) {
            this.field_110296_bG.func_70299_a(1, (cvzo)object);
        }
        if (qoac2._c("SaddleItem")) {
            object = cvzo._a(qoac2._m("SaddleItem"));
            if (object != null && ((cvzo)object)._d == tgdv.field_77765_aA.field_77779_bT) {
                this.field_110296_bG.func_70299_a(0, (cvzo)object);
            }
        } else if (qoac2._o("Saddle")) {
            this.field_110296_bG.func_70299_a(0, new cvzo(tgdv.field_77765_aA));
        }
        this.func_110232_cE();
    }

    @Override
    public boolean func_70878_b(EntityAnimal entityAnimal) {
        int n;
        if (entityAnimal == this) {
            return false;
        }
        if (entityAnimal.getClass() != this.getClass()) {
            return false;
        }
        EntityHorse entityHorse = (EntityHorse)entityAnimal;
        if (!this.func_110200_cJ() || !entityHorse.func_110200_cJ()) {
            return false;
        }
        int n2 = this.func_110265_bP();
        return n2 == (n = entityHorse.func_110265_bP()) || n2 == 0 && n == 1 || n2 == 1 && n == 0;
    }

    @Override
    public EntityAgeable func_90011_a(EntityAgeable entityAgeable) {
        EntityHorse entityHorse = (EntityHorse)entityAgeable;
        EntityHorse entityHorse2 = new EntityHorse(this.field_70170_p);
        int n = this.func_110265_bP();
        int n2 = entityHorse.func_110265_bP();
        int n3 = 0;
        if (n == n2) {
            n3 = n;
        } else if (n == 0 && n2 == 1 || n == 1 && n2 == 0) {
            n3 = 2;
        }
        if (n3 == 0) {
            int n4 = this.field_70146_Z.nextInt(9);
            int n5 = n4 < 4 ? this.func_110202_bQ() & 0xFF : (n4 < 8 ? entityHorse.func_110202_bQ() & 0xFF : this.field_70146_Z.nextInt(7));
            int n6 = this.field_70146_Z.nextInt(5);
            n5 = n6 < 4 ? (n5 |= this.func_110202_bQ() & 0xFF00) : (n6 < 8 ? (n5 |= entityHorse.func_110202_bQ() & 0xFF00) : (n5 |= this.field_70146_Z.nextInt(5) << 8 & 0xFF00));
            entityHorse2.func_110235_q(n5);
        }
        entityHorse2.func_110214_p(n3);
        double d = this.func_110148_a(sajz._a)._b() + entityAgeable.func_110148_a(sajz._a)._b() + (double)this.func_110267_cL();
        entityHorse2.func_110148_a(sajz._a)._a(d / 3.0);
        double d2 = this.func_110148_a(field_110271_bv)._b() + entityAgeable.func_110148_a(field_110271_bv)._b() + this.func_110245_cM();
        entityHorse2.func_110148_a(field_110271_bv)._a(d2 / 3.0);
        double d3 = this.func_110148_a(sajz._d)._b() + entityAgeable.func_110148_a(sajz._d)._b() + this.func_110203_cN();
        entityHorse2.func_110148_a(sajz._d)._a(d3 / 3.0);
        return entityHorse2;
    }

    @Override
    public tupg func_110161_a(tupg tupg2) {
        tupg2 = super.func_110161_a(tupg2);
        int n = 0;
        int n2 = 0;
        if (tupg2 instanceof eidj) {
            n = ((eidj)tupg2)._a;
            n2 = ((eidj)tupg2)._b & 0xFF | this.field_70146_Z.nextInt(5) << 8;
        } else {
            if (this.field_70146_Z.nextInt(10) == 0) {
                n = 1;
            } else {
                int n3 = this.field_70146_Z.nextInt(7);
                int n4 = this.field_70146_Z.nextInt(5);
                n = 0;
                n2 = n3 | n4 << 8;
            }
            tupg2 = new eidj(n, n2);
        }
        this.func_110214_p(n);
        this.func_110235_q(n2);
        if (this.field_70146_Z.nextInt(5) == 0) {
            this.func_70873_a(-24000);
        }
        if (n == 4 || n == 3) {
            this.func_110148_a(sajz._a)._a(15.0);
            this.func_110148_a(sajz._d)._a(0.2f);
        } else {
            this.func_110148_a(sajz._a)._a(this.func_110267_cL());
            if (n == 0) {
                this.func_110148_a(sajz._d)._a(this.func_110203_cN());
            } else {
                this.func_110148_a(sajz._d)._a(0.175f);
            }
        }
        if (n == 2 || n == 1) {
            this.func_110148_a(field_110271_bv)._a(0.5);
        } else {
            this.func_110148_a(field_110271_bv)._a(this.func_110245_cM());
        }
        this.func_70606_j(this.func_110138_aP());
        return tupg2;
    }

    public float func_110258_o(float f) {
        return this.field_110284_bK + (this.field_110283_bJ - this.field_110284_bK) * f;
    }

    public float func_110223_p(float f) {
        return this.field_110282_bM + (this.field_110281_bL - this.field_110282_bM) * f;
    }

    public float func_110201_q(float f) {
        return this.field_110288_bO + (this.field_110287_bN - this.field_110288_bO) * f;
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    public void func_110206_u(int n) {
        if (this.func_110257_ck()) {
            if (n < 0) {
                n = 0;
            } else {
                this.field_110294_bI = true;
                this.func_110220_cK();
            }
            this.field_110277_bt = n >= 90 ? 1.0f : 0.4f + 0.4f * (float)n / 90.0f;
        }
    }

    public void func_110216_r(boolean bl) {
        String string = bl ? "heart" : "smoke";
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
            this.func_110216_r(true);
        } else if (by == 6) {
            this.func_110216_r(false);
        } else {
            super.func_70103_a(by);
        }
    }

    @Override
    public void func_70043_V() {
        super.func_70043_V();
        if (this.field_110282_bM > 0.0f) {
            float f = sajh._a(this.field_70761_aq * (float)Math.PI / 180.0f);
            float f2 = sajh._b(this.field_70761_aq * (float)Math.PI / 180.0f);
            float f3 = 0.7f * this.field_110282_bM;
            float f4 = 0.15f * this.field_110282_bM;
            this.field_70153_n.func_70107_b(this.field_70165_t + (double)(f3 * f), this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W() + (double)f4, this.field_70161_v - (double)(f3 * f2));
            if (this.field_70153_n instanceof EntityLivingBase) {
                ((EntityLivingBase)this.field_70153_n).field_70761_aq = this.field_70761_aq;
            }
        }
    }

    public float func_110267_cL() {
        return 15.0f + (float)this.field_70146_Z.nextInt(8) + (float)this.field_70146_Z.nextInt(9);
    }

    public double func_110245_cM() {
        return (double)0.4f + this.field_70146_Z.nextDouble() * 0.2 + this.field_70146_Z.nextDouble() * 0.2 + this.field_70146_Z.nextDouble() * 0.2;
    }

    public double func_110203_cN() {
        return ((double)0.45f + this.field_70146_Z.nextDouble() * 0.3 + this.field_70146_Z.nextDouble() * 0.3 + this.field_70146_Z.nextDouble() * 0.3) * 0.25;
    }

    public static boolean func_110211_v(int n) {
        return n == tgdv.field_111215_ce.field_77779_bT || n == tgdv.field_111216_cf.field_77779_bT || n == tgdv.field_111213_cg.field_77779_bT;
    }

    @Override
    public boolean func_70617_f_() {
        return false;
    }
}

