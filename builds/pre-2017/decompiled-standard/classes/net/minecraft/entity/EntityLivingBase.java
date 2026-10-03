/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.sajz;
import net.minecraft.entity.ugqx;
import net.minecraft.entity.vjta;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.tupg;
import net.minecraftforge.common.ForgeHooks;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public abstract class EntityLivingBase
extends Entity {
    public static final UUID field_110156_b = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
    public static final xson field_110157_c = new xson(field_110156_b, "Sprinting speed boost", 0.3f, 2)._a(false);
    public mbno field_110155_d;
    public final tupg field_94063_bt = new tupg(this);
    public final HashMap field_70713_bf = new HashMap();
    public final cvzo[] field_82180_bT = new cvzo[5];
    public boolean field_82175_bq;
    public int field_110158_av;
    public int field_70720_be;
    public float field_70735_aL;
    public int field_70737_aN;
    public int field_70738_aO;
    public float field_70739_aP;
    public int field_70725_aQ;
    public int field_70724_aR;
    public float field_70732_aI;
    public float field_70733_aJ;
    public float field_70722_aY;
    public float field_70721_aZ;
    public float field_70754_ba;
    public int field_70771_an = 20;
    public float field_70727_aS;
    public float field_70726_aT;
    public float field_70769_ao;
    public float field_70770_ap;
    public float field_70761_aq;
    public float field_70760_ar;
    public float field_70759_as;
    public float field_70758_at;
    public float field_70747_aH = 0.02f;
    public EntityPlayer field_70717_bb;
    public int field_70718_bc;
    public boolean field_70729_aU;
    public int field_70708_bq;
    public float field_70768_au;
    public float field_110154_aX;
    public float field_70764_aw;
    public float field_70763_ax;
    public float field_70741_aB;
    public int field_70744_aE;
    public float field_110153_bc;
    public boolean field_70703_bu;
    public float field_70702_br;
    public float field_70701_bs;
    public float field_70704_bt;
    public int field_70716_bi;
    public double field_70709_bj;
    public double field_70710_bk;
    public double field_110152_bk;
    public double field_70712_bm;
    public double field_70705_bn;
    public boolean field_70752_e = true;
    public EntityLivingBase field_70755_b;
    public int field_70756_c;
    public EntityLivingBase field_110150_bn;
    public int field_142016_bo;
    public float field_70746_aG;
    public int field_70773_bE;
    public float field_110151_bq;

    public EntityLivingBase(ozlu ozlu2) {
        super(ozlu2);
        this.func_110147_ax();
        this.func_70606_j(this.func_110138_aP());
        this.field_70156_m = true;
        this.field_70770_ap = (float)(Math.random() + 1.0) * 0.01f;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70769_ao = (float)Math.random() * 12398.0f;
        this.field_70759_as = this.field_70177_z = (float)(Math.random() * Math.PI * 2.0);
        this.field_70138_W = 0.5f;
        GloomyHooks.setRenderDistanceWeight(this);
        GloomyHooks.onEntityLivingBaseInit(this, ozlu2);
    }

    @Override
    public void func_70088_a() {
        this.field_70180_af._a(7, (Object)0);
        this.field_70180_af._a(8, (Object)0);
        this.field_70180_af._a(9, (Object)0);
        this.field_70180_af._a(6, Float.valueOf(1.0f));
    }

    public void func_110147_ax() {
        this.func_110140_aT()._b(sajz._a);
        this.func_110140_aT()._b(sajz._c);
        this.func_110140_aT()._b(sajz._d);
        if (!this.func_70650_aV()) {
            this.func_110148_a(sajz._d)._a(0.1f);
        }
    }

    @Override
    public void func_70064_a(double d, boolean bl) {
        if (!this.func_70090_H()) {
            this.func_70072_I();
        }
        if (bl && this.field_70143_R > 0.0f) {
            int n;
            int n2;
            int n3;
            int n4 = sajh._c(this.field_70165_t);
            int n5 = this.field_70170_p.func_72798_a(n4, n3 = sajh._c(this.field_70163_u - (double)0.2f - (double)this.field_70129_M), n2 = sajh._c(this.field_70161_v));
            if (n5 == 0 && ((n = this.field_70170_p.func_85175_e(n4, n3 - 1, n2)) == 11 || n == 32 || n == 21)) {
                n5 = this.field_70170_p.func_72798_a(n4, n3 - 1, n2);
            }
            if (n5 > 0) {
                twgu.field_71973_m[n5].func_71866_a(this.field_70170_p, n4, n3, n2, this, this.field_70143_R);
            }
        }
        super.func_70064_a(d, bl);
    }

    public boolean func_70648_aU() {
        return false;
    }

    @Override
    public void func_70030_z() {
        boolean bl;
        this.field_70732_aI = this.field_70733_aJ;
        super.func_70030_z();
        this.field_70170_p.field_72984_F._a("livingEntityBaseTick");
        if (this.func_70089_S() && this.func_70094_T()) {
            this.func_70097_a(jxtc.field_76368_d, 1.0f);
        }
        if (this.func_70045_F() || this.field_70170_p.field_72995_K) {
            this.func_70066_B();
        }
        boolean bl2 = bl = this instanceof EntityPlayer && ((EntityPlayer)this).field_71075_bZ._a;
        if (this.func_70089_S() && this.func_70055_a(tflj._h)) {
            if (!(this.func_70648_aU() || this.func_82165_m(hdpq._o._H) || bl)) {
                this.func_70050_g(this.func_70682_h(this.func_70086_ai()));
                if (this.func_70086_ai() == -20) {
                    this.func_70050_g(0);
                    for (int i = 0; i < 8; ++i) {
                        float f = this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat();
                        float f2 = this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat();
                        float f3 = this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat();
                        this.field_70170_p.func_72869_a("bubble", this.field_70165_t + (double)f, this.field_70163_u + (double)f2, this.field_70161_v + (double)f3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                    }
                    this.func_70097_a(jxtc.field_76369_e, 2.0f);
                }
            }
            this.func_70066_B();
            if (!this.field_70170_p.field_72995_K && this.func_70115_ae() && this.field_70154_o != null && this.field_70154_o.shouldDismountInWater(this)) {
                this.func_70078_a(null);
            }
        } else {
            this.func_70050_g(300);
        }
        this.field_70727_aS = this.field_70726_aT;
        if (this.field_70724_aR > 0) {
            --this.field_70724_aR;
        }
        if (this.field_70737_aN > 0) {
            --this.field_70737_aN;
        }
        if (this.field_70172_ad > 0) {
            --this.field_70172_ad;
        }
        if (this.func_110143_aJ() <= 0.0f) {
            this.func_70609_aI();
        }
        if (this.field_70718_bc > 0) {
            --this.field_70718_bc;
        } else {
            this.field_70717_bb = null;
        }
        if (this.field_110150_bn != null && !this.field_110150_bn.func_70089_S()) {
            this.field_110150_bn = null;
        }
        if (this.field_70755_b != null && !this.field_70755_b.func_70089_S()) {
            this.func_70604_c(null);
        }
        this.func_70679_bo();
        this.field_70763_ax = this.field_70764_aw;
        this.field_70760_ar = this.field_70761_aq;
        this.field_70758_at = this.field_70759_as;
        this.field_70126_B = this.field_70177_z;
        this.field_70127_C = this.field_70125_A;
        this.field_70170_p.field_72984_F._b();
    }

    public boolean func_70631_g_() {
        return false;
    }

    public void func_70609_aI() {
        ++this.field_70725_aQ;
        if (this.field_70725_aQ == 20) {
            int n;
            if (!this.field_70170_p.field_72995_K && (this.field_70718_bc > 0 || this.func_70684_aJ()) && !this.func_70631_g_() && this.field_70170_p.func_82736_K()._b("doMobLoot")) {
                int n2;
                for (n = this.func_70693_a(this.field_70717_bb); n > 0; n -= n2) {
                    n2 = EntityXPOrb.func_70527_a(n);
                    this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, n2));
                }
            }
            this.func_70106_y();
            for (n = 0; n < 20; ++n) {
                double d = this.field_70146_Z.nextGaussian() * 0.02;
                double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                this.field_70170_p.func_72869_a("explode", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, d, d2, d3);
            }
        }
    }

    public int func_70682_h(int n) {
        int n2 = zhty._b(this);
        return n2 > 0 && this.field_70146_Z.nextInt(n2 + 1) > 0 ? n : n - 1;
    }

    public int func_70693_a(EntityPlayer entityPlayer) {
        return 0;
    }

    public boolean func_70684_aJ() {
        return false;
    }

    public Random func_70681_au() {
        return this.field_70146_Z;
    }

    public EntityLivingBase func_70643_av() {
        return this.field_70755_b;
    }

    public int func_142015_aE() {
        return this.field_70756_c;
    }

    public void func_70604_c(EntityLivingBase entityLivingBase) {
        this.field_70755_b = entityLivingBase;
        this.field_70756_c = this.field_70173_aa;
        ForgeHooks.onLivingSetAttackTarget(this, entityLivingBase);
    }

    public EntityLivingBase func_110144_aD() {
        return this.field_110150_bn;
    }

    public int func_142013_aG() {
        return this.field_142016_bo;
    }

    public void func_130011_c(Entity entity) {
        this.field_110150_bn = entity instanceof EntityLivingBase ? (EntityLivingBase)entity : null;
        this.field_142016_bo = this.field_70173_aa;
    }

    public int func_70654_ax() {
        return this.field_70708_bq;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("HealF", this.func_110143_aJ());
        qoac2._a("Health", (short)Math.ceil(this.func_110143_aJ()));
        qoac2._a("HurtTime", (short)this.field_70737_aN);
        qoac2._a("DeathTime", (short)this.field_70725_aQ);
        qoac2._a("AttackTime", (short)this.field_70724_aR);
        qoac2._a("AbsorptionAmount", this.func_110139_bj());
        for (cvzo cvzo2 : this.func_70035_c()) {
            if (cvzo2 == null) continue;
            this.field_110155_d._a(cvzo2._D());
        }
        qoac2._a("Attributes", sajz._a(this.func_110140_aT()));
        for (cvzo cvzo2 : this.func_70035_c()) {
            if (cvzo2 == null) continue;
            this.field_110155_d._b(cvzo2._D());
        }
        if (!this.field_70713_bf.isEmpty()) {
            bsyv bsyv2 = new bsyv();
            for (supr supr2 : this.field_70713_bf.values()) {
                bsyv2._a(supr2._a(new qoac()));
            }
            qoac2._a("ActiveEffects", bsyv2);
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        huhy huhy2;
        this.func_110149_m(qoac2._h("AbsorptionAmount"));
        if (qoac2._c("Attributes") && this.field_70170_p != null && !this.field_70170_p.field_72995_K) {
            sajz._a(this.func_110140_aT(), qoac2._n("Attributes"), this.field_70170_p == null ? null : this.field_70170_p.func_98180_V());
        }
        if (qoac2._c("ActiveEffects")) {
            huhy2 = qoac2._n("ActiveEffects");
            for (int i = 0; i < ((bsyv)huhy2)._d(); ++i) {
                qoac qoac3 = (qoac)((bsyv)huhy2)._b(i);
                supr supr2 = supr._b(qoac3);
                this.field_70713_bf.put(supr2._a(), supr2);
            }
        }
        if (qoac2._c("HealF")) {
            this.func_70606_j(qoac2._h("HealF"));
        } else {
            huhy2 = qoac2._b("Health");
            if (huhy2 == null) {
                this.func_70606_j(this.func_110138_aP());
            } else if (huhy2._a() == 5) {
                this.func_70606_j(((jjly)huhy2)._c);
            } else if (huhy2._a() == 2) {
                this.func_70606_j(((ixnt)huhy2)._c);
            }
        }
        this.field_70737_aN = qoac2._e("HurtTime");
        this.field_70725_aQ = qoac2._e("DeathTime");
        this.field_70724_aR = qoac2._e("AttackTime");
    }

    public void func_70679_bo() {
        boolean bl;
        Iterator iterator2 = this.field_70713_bf.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer n = (Integer)iterator2.next();
            supr supr2 = (supr)this.field_70713_bf.get(n);
            if (!supr2._a(this)) {
                if (this.field_70170_p.field_72995_K) continue;
                iterator2.remove();
                this.func_70688_c(supr2);
                continue;
            }
            if (supr2._b() % 600 != 0) continue;
            this.func_70695_b(supr2, false);
        }
        if (this.field_70752_e) {
            if (!this.field_70170_p.field_72995_K) {
                if (this.field_70713_bf.isEmpty()) {
                    this.field_70180_af._b(8, (byte)0);
                    this.field_70180_af._b(7, 0);
                    this.func_82142_c(false);
                } else {
                    int n = hdoy._a(this.field_70713_bf.values());
                    this.field_70180_af._b(8, (byte)(hdoy._b(this.field_70713_bf.values()) ? 1 : 0));
                    this.field_70180_af._b(7, n);
                    this.func_82142_c(this.func_82165_m(hdpq._p._H));
                }
            }
            this.field_70752_e = false;
        }
        int n = this.field_70180_af._c(7);
        boolean bl2 = bl = this.field_70180_af._a(8) > 0;
        if (n > 0) {
            boolean bl3 = false;
            if (!this.func_82150_aj()) {
                bl3 = this.field_70146_Z.nextBoolean();
            } else {
                boolean bl4 = bl3 = this.field_70146_Z.nextInt(15) == 0;
            }
            if (bl) {
                bl3 &= this.field_70146_Z.nextInt(5) == 0;
            }
            if (bl3 && n > 0) {
                double d = (double)(n >> 16 & 0xFF) / 255.0;
                double d2 = (double)(n >> 8 & 0xFF) / 255.0;
                double d3 = (double)(n >> 0 & 0xFF) / 255.0;
                this.field_70170_p.func_72869_a(bl ? "mobSpellAmbient" : "mobSpell", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - (double)this.field_70129_M, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, d, d2, d3);
            }
        }
    }

    public void func_70674_bp() {
        Iterator iterator2 = this.field_70713_bf.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer n = (Integer)iterator2.next();
            supr supr2 = (supr)this.field_70713_bf.get(n);
            if (this.field_70170_p.field_72995_K) continue;
            iterator2.remove();
            this.func_70688_c(supr2);
        }
    }

    public Collection func_70651_bq() {
        return this.field_70713_bf.values();
    }

    public boolean func_82165_m(int n) {
        return this.field_70713_bf.containsKey(n);
    }

    public boolean func_70644_a(hdpq hdpq2) {
        return this.field_70713_bf.containsKey(hdpq2._H);
    }

    public supr func_70660_b(hdpq hdpq2) {
        return (supr)this.field_70713_bf.get(hdpq2._H);
    }

    public void func_70690_d(supr supr2) {
        if (this.func_70687_e(supr2)) {
            if (this.field_70713_bf.containsKey(supr2._a())) {
                ((supr)this.field_70713_bf.get(supr2._a()))._a(supr2);
                this.func_70695_b((supr)this.field_70713_bf.get(supr2._a()), true);
            } else {
                this.field_70713_bf.put(supr2._a(), supr2);
                this.func_70670_a(supr2);
            }
        }
    }

    public boolean func_70687_e(supr supr2) {
        int n;
        return this.func_70668_bt() != vjta._b || (n = supr2._a()) != hdpq._l._H && n != hdpq._u._H;
    }

    public boolean func_70662_br() {
        return this.func_70668_bt() == vjta._b;
    }

    public void func_70618_n(int n) {
        this.field_70713_bf.remove(n);
    }

    public void func_82170_o(int n) {
        supr supr2 = (supr)this.field_70713_bf.remove(n);
        if (supr2 != null) {
            this.func_70688_c(supr2);
        }
    }

    public void func_70670_a(supr supr2) {
        this.field_70752_e = true;
        if (!this.field_70170_p.field_72995_K) {
            hdpq._a[supr2._a()]._b(this, this.func_110140_aT(), supr2._c());
        }
    }

    public void func_70695_b(supr supr2, boolean bl) {
        this.field_70752_e = true;
        if (bl && !this.field_70170_p.field_72995_K) {
            hdpq._a[supr2._a()]._a(this, this.func_110140_aT(), supr2._c());
            hdpq._a[supr2._a()]._b(this, this.func_110140_aT(), supr2._c());
        }
    }

    public void func_70688_c(supr supr2) {
        this.field_70752_e = true;
        if (!this.field_70170_p.field_72995_K) {
            hdpq._a[supr2._a()]._a(this, this.func_110140_aT(), supr2._c());
        }
    }

    public void func_70691_i(float f) {
        qlgf._a(this, f);
    }

    public final float func_110143_aJ() {
        return this.field_70180_af._d(6);
    }

    public void func_70606_j(float f) {
        this.field_70180_af._b(6, Float.valueOf(sajh._a(f, 0.0f, this.func_110138_aP())));
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (ForgeHooks.onLivingAttack(this, jxtc2, f)) {
            GloomyHooks.attackEntityFrom(this, jxtc2, f);
            return false;
        }
        if (this.func_85032_ar()) {
            GloomyHooks.attackEntityFrom(this, jxtc2, f);
            return false;
        }
        if (this.field_70170_p.field_72995_K) {
            GloomyHooks.attackEntityFrom(this, jxtc2, f);
            return false;
        }
        this.field_70708_bq = 0;
        if (this.func_110143_aJ() <= 0.0f) {
            GloomyHooks.attackEntityFrom(this, jxtc2, f);
            return false;
        }
        if (jxtc2.func_76347_k() && this.func_70644_a(hdpq._n)) {
            GloomyHooks.attackEntityFrom(this, jxtc2, f);
            return false;
        }
        if ((jxtc2 == jxtc.field_82728_o || jxtc2 == jxtc.field_82729_p) && this.func_71124_b(4) != null) {
            this.func_71124_b(4)._a((int)(f * 4.0f + this.field_70146_Z.nextFloat() * f * 2.0f), this);
            f *= 0.75f;
        }
        this.field_70721_aZ = 1.5f;
        boolean bl = true;
        if ((float)this.field_70172_ad > (float)this.field_70771_an / 2.0f) {
            if (f <= this.field_110153_bc) {
                GloomyHooks.attackEntityFrom(this, jxtc2, f);
                return false;
            }
            this.func_70665_d(jxtc2, f - this.field_110153_bc);
            this.field_110153_bc = f;
            bl = false;
        } else {
            this.field_110153_bc = f;
            this.field_70735_aL = this.func_110143_aJ();
            this.field_70172_ad = this.field_70771_an;
            this.func_70665_d(jxtc2, f);
            this.field_70738_aO = 10;
            this.field_70737_aN = 10;
        }
        this.field_70739_aP = 0.0f;
        Entity entity = jxtc2.func_76346_g();
        if (entity != null) {
            EntityWolf entityWolf;
            if (entity instanceof EntityLivingBase) {
                this.func_70604_c((EntityLivingBase)entity);
            }
            if (entity instanceof EntityPlayer) {
                this.field_70718_bc = 100;
                this.field_70717_bb = (EntityPlayer)entity;
            } else if (entity instanceof EntityWolf && (entityWolf = (EntityWolf)entity).func_70909_n()) {
                this.field_70718_bc = 100;
                this.field_70717_bb = null;
            }
        }
        if (bl) {
            this.field_70170_p.func_72960_a(this, (byte)2);
            if (jxtc2 != jxtc.field_76369_e) {
                this.func_70018_K();
            }
            if (entity != null) {
                double d = entity.field_70165_t - this.field_70165_t;
                double d2 = entity.field_70161_v - this.field_70161_v;
                while (d * d + d2 * d2 < 1.0E-4) {
                    d = (Math.random() - Math.random()) * 0.01;
                    d2 = (Math.random() - Math.random()) * 0.01;
                }
                this.field_70739_aP = (float)(Math.atan2(d2, d) * 180.0 / Math.PI) - this.field_70177_z;
                this.func_70653_a(entity, f, d, d2);
            } else {
                this.field_70739_aP = (int)(Math.random() * 2.0) * 180;
            }
        }
        if (this.func_110143_aJ() <= 0.0f) {
            if (bl) {
                this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
            }
            this.func_70645_a(jxtc2);
        } else if (bl) {
            this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i());
        }
        GloomyHooks.attackEntityFrom(this, jxtc2, f);
        return true;
    }

    public void func_70669_a(cvzo cvzo2) {
        this.func_85030_a("random.break", 0.8f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
        for (int i = 0; i < 5; ++i) {
            ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(((double)this.field_70146_Z.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
            ofbx2._a(-this.field_70125_A * (float)Math.PI / 180.0f);
            ofbx2._b(-this.field_70177_z * (float)Math.PI / 180.0f);
            ofbx ofbx3 = this.field_70170_p.func_82732_R()._a(((double)this.field_70146_Z.nextFloat() - 0.5) * 0.3, (double)(-this.field_70146_Z.nextFloat()) * 0.6 - 0.3, 0.6);
            ofbx3._a(-this.field_70125_A * (float)Math.PI / 180.0f);
            ofbx3._b(-this.field_70177_z * (float)Math.PI / 180.0f);
            ofbx3 = ofbx3._c(this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v);
            this.field_70170_p.func_72869_a("iconcrack_" + cvzo2._a().field_77779_bT, ofbx3._c, ofbx3._d, ofbx3._e, ofbx2._c, ofbx2._d + 0.05, ofbx2._e);
        }
    }

    public void func_70645_a(jxtc jxtc2) {
        if (ForgeHooks.onLivingDeath(this, jxtc2)) {
            return;
        }
        Entity entity = jxtc2.func_76346_g();
        EntityLivingBase entityLivingBase = this.func_94060_bK();
        if (this.field_70744_aE >= 0 && entityLivingBase != null) {
            entityLivingBase.func_70084_c(this, this.field_70744_aE);
        }
        if (entity != null) {
            entity.func_70074_a(this);
        }
        this.field_70729_aU = true;
        if (!this.field_70170_p.field_72995_K) {
            int n = 0;
            if (entity instanceof EntityPlayer) {
                n = zhty._f((EntityLivingBase)entity);
            }
            this.captureDrops = true;
            this.capturedDrops.clear();
            int n2 = 0;
            if (!this.func_70631_g_() && this.field_70170_p.func_82736_K()._b("doMobLoot")) {
                this.func_70628_a(this.field_70718_bc > 0, n);
                this.func_82160_b(this.field_70718_bc > 0, n);
                if (this.field_70718_bc > 0 && (n2 = this.field_70146_Z.nextInt(200) - n) < 5) {
                    this.func_70600_l(n2 <= 0 ? 1 : 0);
                }
            }
            this.captureDrops = false;
            if (!ForgeHooks.onLivingDrops(this, jxtc2, this.capturedDrops, n, this.field_70718_bc > 0, n2)) {
                for (EntityItem entityItem : this.capturedDrops) {
                    this.field_70170_p.func_72838_d(entityItem);
                }
            }
        }
        this.field_70170_p.func_72960_a(this, (byte)3);
    }

    public void func_82160_b(boolean bl, int n) {
    }

    public String func_70621_aR() {
        return "damage.hit";
    }

    public String func_70673_aS() {
        return "damage.hit";
    }

    public void func_70600_l(int n) {
    }

    public void func_70628_a(boolean bl, int n) {
    }

    public boolean func_70617_f_() {
        int n = sajh._c(this.field_70165_t);
        int n2 = sajh._c(this.field_70121_D._c);
        int n3 = sajh._c(this.field_70161_v);
        int n4 = this.field_70170_p.func_72798_a(n, n2, n3);
        return ForgeHooks.isLivingOnLadder(twgu.field_71973_m[n4], this.field_70170_p, n, n2, n3, this);
    }

    @Override
    public boolean func_70089_S() {
        return !this.field_70128_L && this.func_110143_aJ() > 0.0f;
    }

    @Override
    public void func_70069_a(float f) {
        if ((f = ForgeHooks.onLivingFall(this, f)) <= 0.0f) {
            return;
        }
        super.func_70069_a(f);
        supr supr2 = this.func_70660_b(hdpq._j);
        float f2 = supr2 != null ? (float)(supr2._c() + 1) : 0.0f;
        int n = sajh._f(f - 3.0f - f2);
        if (n > 0) {
            if (n > 4) {
                this.func_85030_a("damage.fallbig", 1.0f, 1.0f);
            } else {
                this.func_85030_a("damage.fallsmall", 1.0f, 1.0f);
            }
            this.func_70097_a(jxtc.field_76379_h, n);
            int n2 = this.field_70170_p.func_72798_a(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u - (double)0.2f - (double)this.field_70129_M), sajh._c(this.field_70161_v));
            if (n2 > 0) {
                uioo uioo2 = twgu.field_71973_m[n2].field_72020_cn;
                this.func_85030_a(uioo2._d(), uioo2._a() * 0.5f, uioo2._b() * 0.75f);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70057_ab() {
        this.field_70738_aO = 10;
        this.field_70737_aN = 10;
        this.field_70739_aP = 0.0f;
    }

    public int func_70658_aO() {
        int n = 0;
        for (cvzo cvzo2 : this.func_70035_c()) {
            if (cvzo2 == null || !(cvzo2._a() instanceof lpno)) continue;
            int n2 = ((lpno)cvzo2._a()).field_77879_b;
            n += n2;
        }
        return n;
    }

    public void func_70675_k(float f) {
    }

    public float func_70655_b(jxtc jxtc2, float f) {
        if (!jxtc2.func_76363_c()) {
            int n = 25 - this.func_70658_aO();
            float f2 = f * (float)n;
            this.func_70675_k(f);
            f = f2 / 25.0f;
        }
        return f;
    }

    public float func_70672_c(jxtc jxtc2, float f) {
        float f2;
        int n;
        int n2;
        if (this instanceof EntityZombie) {
            // empty if block
        }
        if (this.func_70644_a(hdpq._m) && jxtc2 != jxtc.field_76380_i) {
            n2 = (this.func_70660_b(hdpq._m)._c() + 1) * 5;
            n = 25 - n2;
            f2 = f * (float)n;
            f = f2 / 25.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        n2 = zhty._a(this.func_70035_c(), jxtc2);
        if (n2 > 20) {
            n2 = 20;
        }
        if (n2 > 0 && n2 <= 20) {
            n = 25 - n2;
            f2 = f * (float)n;
            f = f2 / 25.0f;
        }
        return f;
    }

    public void func_70665_d(jxtc jxtc2, float f) {
        if (!this.func_85032_ar()) {
            if ((f = ForgeHooks.onLivingHurt(this, jxtc2, f)) <= 0.0f) {
                return;
            }
            f = this.func_70655_b(jxtc2, f);
            float f2 = f = this.func_70672_c(jxtc2, f);
            f = Math.max(f - this.func_110139_bj(), 0.0f);
            this.func_110149_m(this.func_110139_bj() - (f2 - f));
            if (f != 0.0f) {
                float f3 = this.func_110143_aJ();
                this.func_70606_j(f3 - f);
                this.func_110142_aN()._a(jxtc2, f3, f);
                this.func_110149_m(this.func_110139_bj() - f);
            }
        }
    }

    public tupg func_110142_aN() {
        return this.field_94063_bt;
    }

    public EntityLivingBase func_94060_bK() {
        return this.field_94063_bt._c() != null ? this.field_94063_bt._c() : (this.field_70717_bb != null ? this.field_70717_bb : (this.field_70755_b != null ? this.field_70755_b : null));
    }

    public final float func_110138_aP() {
        return (float)this.func_110148_a(sajz._a)._e();
    }

    public final int func_85035_bI() {
        return this.field_70180_af._a(9);
    }

    public final void func_85034_r(int n) {
        this.field_70180_af._b(9, (byte)n);
    }

    public int func_82166_i() {
        return this.func_70644_a(hdpq._e) ? 6 - (1 + this.func_70660_b(hdpq._e)._c()) * 1 : (this.func_70644_a(hdpq._f) ? 6 + (1 + this.func_70660_b(hdpq._f)._c()) * 2 : 6);
    }

    public void func_71038_i() {
        tgdv tgdv2;
        gloomyfolken.mods.stalker.player.ugqx._a(this);
        cvzo cvzo2 = this.func_70694_bm();
        if (cvzo2 != null && cvzo2._a() != null && (tgdv2 = cvzo2._a()).onEntitySwing(this, cvzo2)) {
            return;
        }
        if (!this.field_82175_bq || this.field_110158_av >= this.func_82166_i() / 2 || this.field_110158_av < 0) {
            this.field_110158_av = -1;
            this.field_82175_bq = true;
            if (this.field_70170_p instanceof yfgy) {
                ((yfgy)this.field_70170_p).func_73039_n()._a(this, new jjrh(this, 1));
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70103_a(byte by) {
        if (by == 2) {
            this.field_70721_aZ = 1.5f;
            this.field_70172_ad = this.field_70771_an;
            this.field_70738_aO = 10;
            this.field_70737_aN = 10;
            this.field_70739_aP = 0.0f;
            this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
            this.func_70097_a(jxtc.field_76377_j, 0.0f);
        } else if (by == 3) {
            this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
            this.func_70606_j(0.0f);
            this.func_70645_a(jxtc.field_76377_j);
        } else {
            super.func_70103_a(by);
        }
    }

    @Override
    public void func_70076_C() {
        this.func_70097_a(jxtc.field_76380_i, 4.0f);
    }

    public void func_82168_bl() {
        int n = this.func_82166_i();
        if (this.field_82175_bq) {
            ++this.field_110158_av;
            if (this.field_110158_av >= n) {
                this.field_110158_av = 0;
                this.field_82175_bq = false;
            }
        } else {
            this.field_110158_av = 0;
        }
        this.field_70733_aJ = (float)this.field_110158_av / (float)n;
    }

    public hubf func_110148_a(txei txei2) {
        return this.func_110140_aT()._a(txei2);
    }

    public mbno func_110140_aT() {
        if (this.field_110155_d == null) {
            this.field_110155_d = new ceqs();
        }
        return this.field_110155_d;
    }

    public vjta func_70668_bt() {
        return vjta._a;
    }

    public abstract cvzo func_70694_bm();

    public abstract cvzo func_71124_b(int var1);

    @Override
    public abstract void func_70062_b(int var1, cvzo var2);

    @Override
    public void func_70031_b(boolean bl) {
        super.func_70031_b(bl);
        hubf hubf2 = this.func_110148_a(sajz._d);
        if (hubf2._a(field_110156_b) != null) {
            hubf2._b(field_110157_c);
        }
        if (bl) {
            hubf2._a(field_110157_c);
        }
    }

    @Override
    public abstract cvzo[] func_70035_c();

    public float func_70599_aP() {
        return 1.0f;
    }

    public float func_70647_i() {
        return this.func_70631_g_() ? (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.5f : (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f;
    }

    public boolean func_70610_aX() {
        return this.func_110143_aJ() <= 0.0f;
    }

    public void func_70634_a(double d, double d2, double d3) {
        this.func_70012_b(d, d2, d3, this.field_70177_z, this.field_70125_A);
    }

    public void func_110145_l(Entity entity) {
        double d = entity.field_70165_t;
        double d2 = entity.field_70121_D._c + (double)entity.field_70131_O;
        double d3 = entity.field_70161_v;
        for (double d4 = -1.5; d4 < 2.0; d4 += 1.0) {
            for (double d5 = -1.5; d5 < 2.0; d5 += 1.0) {
                if (d4 == 0.0 && d5 == 0.0) continue;
                int n = (int)(this.field_70165_t + d4);
                int n2 = (int)(this.field_70161_v + d5);
                eidj eidj2 = this.field_70121_D._c(d4, 1.0, d5);
                if (!this.field_70170_p.func_72840_a(eidj2).isEmpty()) continue;
                if (this.field_70170_p.func_72797_t(n, (int)this.field_70163_u, n2)) {
                    this.func_70634_a(this.field_70165_t + d4, this.field_70163_u + 1.0, this.field_70161_v + d5);
                    return;
                }
                if (!this.field_70170_p.func_72797_t(n, (int)this.field_70163_u - 1, n2) && this.field_70170_p.func_72803_f(n, (int)this.field_70163_u - 1, n2) != tflj._h) continue;
                d = this.field_70165_t + d4;
                d2 = this.field_70163_u + 1.0;
                d3 = this.field_70161_v + d5;
            }
        }
        this.func_70634_a(d, d2, d3);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_94059_bO() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public dwan func_70620_b(cvzo cvzo2, int n) {
        return cvzo2._b();
    }

    public void func_70664_aZ() {
        this.field_70181_x = 0.42f;
        if (this.func_70644_a(hdpq._j)) {
            this.field_70181_x += (double)((float)(this.func_70660_b(hdpq._j)._c() + 1) * 0.1f);
        }
        if (this.func_70051_ag()) {
            float f = this.field_70177_z * ((float)Math.PI / 180);
            this.field_70159_w -= (double)(sajh._a(f) * 0.2f);
            this.field_70179_y += (double)(sajh._b(f) * 0.2f);
        }
        this.field_70160_al = true;
        ForgeHooks.onLivingJump(this);
    }

    public void func_70612_e(float f, float f2) {
        float f3;
        double d;
        if (!(!this.func_70090_H() || this instanceof EntityPlayer && ((EntityPlayer)this).field_71075_bZ._b)) {
            d = this.field_70163_u;
            this.func_70060_a(f, f2, this.func_70650_aV() ? 0.04f : 0.02f);
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)0.8f;
            this.field_70181_x *= (double)0.8f;
            this.field_70179_y *= (double)0.8f;
            this.field_70181_x -= 0.02;
            if (this.field_70123_F && this.func_70038_c(this.field_70159_w, this.field_70181_x + (double)0.6f - this.field_70163_u + d, this.field_70179_y)) {
                this.field_70181_x = 0.3f;
            }
        } else if (!(!this.func_70058_J() || this instanceof EntityPlayer && ((EntityPlayer)this).field_71075_bZ._b)) {
            d = this.field_70163_u;
            this.func_70060_a(f, f2, 0.02f);
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= 0.5;
            this.field_70181_x *= 0.5;
            this.field_70179_y *= 0.5;
            this.field_70181_x -= 0.02;
            if (this.field_70123_F && this.func_70038_c(this.field_70159_w, this.field_70181_x + (double)0.6f - this.field_70163_u + d, this.field_70179_y)) {
                this.field_70181_x = 0.3f;
            }
        } else {
            float f4 = 0.91f;
            if (this.field_70122_E) {
                f4 = 0.54600006f;
                int n = this.field_70170_p.func_72798_a(sajh._c(this.field_70165_t), sajh._c(this.field_70121_D._c) - 1, sajh._c(this.field_70161_v));
                if (n > 0) {
                    f4 = twgu.field_71973_m[n].field_72016_cq * 0.91f;
                }
            }
            float f5 = 0.16277136f / (f4 * f4 * f4);
            f3 = this.field_70122_E ? this.func_70689_ay() * f5 : this.field_70747_aH;
            this.func_70060_a(f, f2, f3);
            f4 = 0.91f;
            if (this.field_70122_E) {
                f4 = 0.54600006f;
                int n = this.field_70170_p.func_72798_a(sajh._c(this.field_70165_t), sajh._c(this.field_70121_D._c) - 1, sajh._c(this.field_70161_v));
                if (n > 0) {
                    f4 = twgu.field_71973_m[n].field_72016_cq * 0.91f;
                }
            }
            if (this.func_70617_f_()) {
                boolean bl;
                float f6 = 0.15f;
                if (this.field_70159_w < (double)(-f6)) {
                    this.field_70159_w = -f6;
                }
                if (this.field_70159_w > (double)f6) {
                    this.field_70159_w = f6;
                }
                if (this.field_70179_y < (double)(-f6)) {
                    this.field_70179_y = -f6;
                }
                if (this.field_70179_y > (double)f6) {
                    this.field_70179_y = f6;
                }
                this.field_70143_R = 0.0f;
                if (this.field_70181_x < -0.15) {
                    this.field_70181_x = -0.15;
                }
                boolean bl2 = bl = this.func_70093_af() && this instanceof EntityPlayer;
                if (bl && this.field_70181_x < 0.0) {
                    this.field_70181_x = 0.0;
                }
            }
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            if (this.field_70123_F && this.func_70617_f_()) {
                this.field_70181_x = 0.2;
            }
            this.field_70181_x = !(!this.field_70170_p.field_72995_K || this.field_70170_p.func_72899_e((int)this.field_70165_t, 0, (int)this.field_70161_v) && this.field_70170_p.func_72938_d((int)((int)this.field_70165_t), (int)((int)this.field_70161_v))._f) ? (this.field_70163_u > 0.0 ? -0.1 : 0.0) : (this.field_70181_x -= 0.08);
            this.field_70181_x *= (double)0.98f;
            this.field_70159_w *= (double)f4;
            this.field_70179_y *= (double)f4;
        }
        this.field_70722_aY = this.field_70721_aZ;
        d = this.field_70165_t - this.field_70169_q;
        double d2 = this.field_70161_v - this.field_70166_s;
        f3 = sajh._a(d * d + d2 * d2) * 4.0f;
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.field_70721_aZ += (f3 - this.field_70721_aZ) * 0.4f;
        this.field_70754_ba += this.field_70721_aZ;
    }

    public boolean func_70650_aV() {
        return false;
    }

    public float func_70689_ay() {
        return this.func_70650_aV() ? this.field_70746_aG : 0.1f;
    }

    public void func_70659_e(float f) {
        this.field_70746_aG = f;
    }

    public boolean func_70652_k(Entity entity) {
        this.func_130011_c(entity);
        return false;
    }

    public boolean func_70608_bn() {
        return false;
    }

    @Override
    public void func_70071_h_() {
        if (ForgeHooks.onLivingUpdate(this)) {
            return;
        }
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            int n = this.func_85035_bI();
            if (n > 0) {
                if (this.field_70720_be <= 0) {
                    this.field_70720_be = 20 * (30 - n);
                }
                --this.field_70720_be;
                if (this.field_70720_be <= 0) {
                    this.func_85034_r(n - 1);
                }
            }
            for (int i = 0; i < 5; ++i) {
                cvzo cvzo2 = this.field_82180_bT[i];
                cvzo cvzo3 = this.func_71124_b(i);
                if (cvzo._b(cvzo3, cvzo2)) continue;
                ((yfgy)this.field_70170_p).func_73039_n()._a(this, new hdms(this.field_70157_k, i, cvzo3));
                if (cvzo2 != null) {
                    this.field_110155_d._a(cvzo2._D());
                }
                if (cvzo3 != null) {
                    this.field_110155_d._b(cvzo3._D());
                }
                this.field_82180_bT[i] = cvzo3 == null ? null : cvzo3._l();
            }
        }
        this.func_70636_d();
        double d = this.field_70165_t - this.field_70169_q;
        double d2 = this.field_70161_v - this.field_70166_s;
        float f = (float)(d * d + d2 * d2);
        float f2 = this.field_70761_aq;
        float f3 = 0.0f;
        this.field_70768_au = this.field_110154_aX;
        float f4 = 0.0f;
        if (f > 0.0025000002f) {
            f4 = 1.0f;
            f3 = (float)Math.sqrt(f) * 3.0f;
            f2 = (float)Math.atan2(d2, d) * 180.0f / (float)Math.PI - 90.0f;
        }
        if (this.field_70733_aJ > 0.0f) {
            f2 = this.field_70177_z;
        }
        if (!this.field_70122_E) {
            f4 = 0.0f;
        }
        this.field_110154_aX += (f4 - this.field_110154_aX) * 0.3f;
        this.field_70170_p.field_72984_F._a("headTurn");
        f3 = this.func_110146_f(f2, f3);
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("rangeChecks");
        while (this.field_70177_z - this.field_70126_B < -180.0f) {
            this.field_70126_B -= 360.0f;
        }
        while (this.field_70177_z - this.field_70126_B >= 180.0f) {
            this.field_70126_B += 360.0f;
        }
        while (this.field_70761_aq - this.field_70760_ar < -180.0f) {
            this.field_70760_ar -= 360.0f;
        }
        while (this.field_70761_aq - this.field_70760_ar >= 180.0f) {
            this.field_70760_ar += 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C < -180.0f) {
            this.field_70127_C -= 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C >= 180.0f) {
            this.field_70127_C += 360.0f;
        }
        while (this.field_70759_as - this.field_70758_at < -180.0f) {
            this.field_70758_at -= 360.0f;
        }
        while (this.field_70759_as - this.field_70758_at >= 180.0f) {
            this.field_70758_at += 360.0f;
        }
        this.field_70170_p.field_72984_F._b();
        this.field_70764_aw += f3;
    }

    public float func_110146_f(float f, float f2) {
        boolean bl;
        float f3 = sajh._g(f - this.field_70761_aq);
        this.field_70761_aq += f3 * 0.3f;
        float f4 = sajh._g(this.field_70177_z - this.field_70761_aq);
        boolean bl2 = bl = f4 < -90.0f || f4 >= 90.0f;
        if (f4 < -75.0f) {
            f4 = -75.0f;
        }
        if (f4 >= 75.0f) {
            f4 = 75.0f;
        }
        this.field_70761_aq = this.field_70177_z - f4;
        if (f4 * f4 > 2500.0f) {
            this.field_70761_aq += f4 * 0.2f;
        }
        if (bl) {
            f2 *= -1.0f;
        }
        return f2;
    }

    public void func_70636_d() {
        if (this.field_70773_bE > 0) {
            --this.field_70773_bE;
        }
        if (this.field_70716_bi > 0) {
            double d = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / (double)this.field_70716_bi;
            double d2 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / (double)this.field_70716_bi;
            double d3 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / (double)this.field_70716_bi;
            double d4 = sajh._f(this.field_70712_bm - (double)this.field_70177_z);
            this.field_70177_z = (float)((double)this.field_70177_z + d4 / (double)this.field_70716_bi);
            this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70705_bn - (double)this.field_70125_A) / (double)this.field_70716_bi);
            --this.field_70716_bi;
            this.func_70107_b(d, d2, d3);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
        } else if (!this.func_70613_aW()) {
            this.field_70159_w *= 0.98;
            this.field_70181_x *= 0.98;
            this.field_70179_y *= 0.98;
        }
        if (Math.abs(this.field_70159_w) < 0.005) {
            this.field_70159_w = 0.0;
        }
        if (Math.abs(this.field_70181_x) < 0.005) {
            this.field_70181_x = 0.0;
        }
        if (Math.abs(this.field_70179_y) < 0.005) {
            this.field_70179_y = 0.0;
        }
        this.field_70170_p.field_72984_F._a("ai");
        if (this.func_70610_aX()) {
            this.field_70703_bu = false;
            this.field_70702_br = 0.0f;
            this.field_70701_bs = 0.0f;
            this.field_70704_bt = 0.0f;
        } else if (this.func_70613_aW()) {
            if (this.func_70650_aV()) {
                this.field_70170_p.field_72984_F._a("newAi");
                this.func_70619_bc();
                this.field_70170_p.field_72984_F._b();
            } else {
                this.field_70170_p.field_72984_F._a("oldAi");
                this.func_70626_be();
                this.field_70170_p.field_72984_F._b();
                this.field_70759_as = this.field_70177_z;
            }
        }
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("jump");
        if (this.field_70703_bu) {
            if (!this.func_70090_H() && !this.func_70058_J()) {
                if (this.field_70122_E && this.field_70773_bE == 0) {
                    this.func_70664_aZ();
                    this.field_70773_bE = 10;
                }
            } else {
                this.field_70181_x += (double)0.04f;
            }
        } else {
            this.field_70773_bE = 0;
        }
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("travel");
        this.field_70702_br *= 0.98f;
        this.field_70701_bs *= 0.98f;
        this.field_70704_bt *= 0.9f;
        this.func_70612_e(this.field_70702_br, this.field_70701_bs);
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("push");
        if (!this.field_70170_p.field_72995_K) {
            this.func_85033_bc();
        }
        this.field_70170_p.field_72984_F._b();
    }

    public void func_70619_bc() {
    }

    public void func_85033_bc() {
        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D._b(0.2f, 0.0, 0.2f));
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (!entity.func_70104_M()) continue;
                this.func_82167_n(entity);
            }
        }
    }

    public void func_82167_n(Entity entity) {
        entity.func_70108_f(this);
    }

    @Override
    public void func_70098_U() {
        super.func_70098_U();
        this.field_70768_au = this.field_110154_aX;
        this.field_110154_aX = 0.0f;
        this.field_70143_R = 0.0f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
        this.field_70129_M = 0.0f;
        this.field_70709_bj = d;
        this.field_70710_bk = d2;
        this.field_110152_bk = d3;
        this.field_70712_bm = f;
        this.field_70705_bn = f2;
        this.field_70716_bi = n;
    }

    public void func_70629_bd() {
    }

    public void func_70626_be() {
        ++this.field_70708_bq;
    }

    public void func_70637_d(boolean bl) {
        this.field_70703_bu = bl;
    }

    public void func_71001_a(Entity entity, int n) {
        if (!entity.field_70128_L && !this.field_70170_p.field_72995_K) {
            ugqx ugqx2 = ((yfgy)this.field_70170_p).func_73039_n();
            if (entity instanceof EntityItem) {
                ugqx2._a(entity, new bbyg(entity.field_70157_k, this.field_70157_k));
            }
            if (entity instanceof EntityArrow) {
                ugqx2._a(entity, new bbyg(entity.field_70157_k, this.field_70157_k));
            }
            if (entity instanceof EntityXPOrb) {
                ugqx2._a(entity, new bbyg(entity.field_70157_k, this.field_70157_k));
            }
        }
    }

    public boolean func_70685_l(Entity entity) {
        return this.field_70170_p.func_72933_a(this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v), this.field_70170_p.func_82732_R()._a(entity.field_70165_t, entity.field_70163_u + (double)entity.func_70047_e(), entity.field_70161_v)) == null;
    }

    @Override
    public ofbx func_70040_Z() {
        return this.func_70676_i(1.0f);
    }

    public ofbx func_70676_i(float f) {
        if (f == 1.0f) {
            float f2 = sajh._b(-this.field_70177_z * ((float)Math.PI / 180) - (float)Math.PI);
            float f3 = sajh._a(-this.field_70177_z * ((float)Math.PI / 180) - (float)Math.PI);
            float f4 = -sajh._b(-this.field_70125_A * ((float)Math.PI / 180));
            float f5 = sajh._a(-this.field_70125_A * ((float)Math.PI / 180));
            return this.field_70170_p.func_82732_R()._a(f3 * f4, f5, f2 * f4);
        }
        float f6 = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * f;
        float f7 = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * f;
        float f8 = sajh._b(-f7 * ((float)Math.PI / 180) - (float)Math.PI);
        float f9 = sajh._a(-f7 * ((float)Math.PI / 180) - (float)Math.PI);
        float f10 = -sajh._b(-f6 * ((float)Math.PI / 180));
        float f11 = sajh._a(-f6 * ((float)Math.PI / 180));
        return this.field_70170_p.func_82732_R()._a(f9 * f10, f11, f8 * f10);
    }

    @SideOnly(value=Side.CLIENT)
    public float func_70678_g(float f) {
        float f2 = this.field_70733_aJ - this.field_70732_aI;
        if (f2 < 0.0f) {
            f2 += 1.0f;
        }
        return this.field_70732_aI + f2 * f;
    }

    @SideOnly(value=Side.CLIENT)
    public ofbx func_70666_h(float f) {
        if (f == 1.0f) {
            return this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        }
        double d = this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)f;
        double d2 = this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f;
        double d3 = this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)f;
        return this.field_70170_p.func_82732_R()._a(d, d2, d3);
    }

    @SideOnly(value=Side.CLIENT)
    public hank func_70614_a(double d, float f) {
        ofbx ofbx2 = this.func_70666_h(f);
        ofbx ofbx3 = this.func_70676_i(f);
        ofbx ofbx4 = ofbx2._c(ofbx3._c * d, ofbx3._d * d, ofbx3._e * d);
        return this.field_70170_p.func_72933_a(ofbx2, ofbx4);
    }

    public boolean func_70613_aW() {
        return !this.field_70170_p.field_72995_K;
    }

    @Override
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }

    @Override
    public boolean func_70104_M() {
        return !this.field_70128_L;
    }

    @Override
    public float func_70047_e() {
        return this.field_70131_O * 0.85f;
    }

    @Override
    public void func_70018_K() {
        this.field_70133_I = this.field_70146_Z.nextDouble() >= this.func_110148_a(sajz._c)._e();
    }

    @Override
    public float func_70079_am() {
        return this.field_70759_as;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70034_d(float f) {
        this.field_70759_as = f;
    }

    public float func_110139_bj() {
        return this.field_110151_bq;
    }

    public void func_110149_m(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.field_110151_bq = f;
    }

    public cwci func_96124_cp() {
        return null;
    }

    public boolean func_142014_c(EntityLivingBase entityLivingBase) {
        return this.func_142012_a(entityLivingBase.func_96124_cp());
    }

    public boolean func_142012_a(cwci cwci2) {
        return this.func_96124_cp() != null ? this.func_96124_cp()._a(cwci2) : false;
    }

    public void curePotionEffects(cvzo cvzo2) {
        Iterator iterator2 = this.field_70713_bf.keySet().iterator();
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        while (iterator2.hasNext()) {
            Integer n = (Integer)iterator2.next();
            supr supr2 = (supr)this.field_70713_bf.get(n);
            if (!supr2._a(cvzo2)) continue;
            iterator2.remove();
            this.func_70688_c(supr2);
        }
    }

    public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
        return this instanceof EntityPig;
    }

    public void func_70653_a(Entity entity, float f, double d, double d2) {
        GloomyHooks.knockBack(this, entity, f, d, d2);
    }

    @Override
    public boolean func_85031_j(Entity entity) {
        BlockRendererList.hitByEntity(this, entity);
        return super.func_85031_j(entity);
    }
}

