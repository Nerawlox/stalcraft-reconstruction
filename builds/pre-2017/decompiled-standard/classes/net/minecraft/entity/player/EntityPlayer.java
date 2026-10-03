/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.amww;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.ezfa;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.eidj;
import net.minecraft.entity.player.ezey;
import net.minecraft.entity.player.pidb;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.sajz;
import net.minecraft.util.dwan;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.tdmn;
import net.minecraft.util.zwaw;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public abstract class EntityPlayer
extends EntityLivingBase
implements Player,
nemo {
    public static final String PERSISTED_NBT_TAG = "PlayerPersisted";
    public eidj field_71071_by = new eidj(this);
    public tgfn field_71078_a = new tgfn();
    public jjgc field_71069_bz;
    public jjgc field_71070_bA;
    public tdmn field_71100_bB = new tdmn();
    public int field_71101_bC;
    public float field_71107_bF;
    public float field_71109_bG;
    public final String field_71092_bJ;
    public int field_71090_bL;
    public double field_71091_bM;
    public double field_71096_bN;
    public double field_71097_bO;
    public double field_71094_bP;
    public double field_71095_bQ;
    public double field_71085_bR;
    public boolean field_71083_bS;
    public zwaw field_71081_bT;
    public int field_71076_b;
    public float field_71079_bU;
    @SideOnly(value=Side.CLIENT)
    public float field_71082_cx;
    public float field_71089_bV;
    public zwaw field_71077_c;
    public HashMap<Integer, zwaw> spawnChunkMap = new HashMap();
    public boolean field_82248_d;
    public HashMap<Integer, Boolean> spawnForcedMap = new HashMap();
    public zwaw field_71073_d;
    public ezey field_71075_bZ = new ezey();
    public int field_71068_ca;
    public int field_71067_cb;
    public float field_71106_cc;
    public cvzo field_71074_e;
    public int field_71072_f;
    public float field_71108_cd = 0.1f;
    public float field_71102_ce = 0.02f;
    public int field_82249_h;
    public EntityFishHook field_71104_cf;
    public float eyeHeight;
    public String displayname;

    public EntityPlayer(ozlu ozlu2, String string) {
        super(ozlu2);
        this.field_71092_bJ = string;
        this.field_71070_bA = this.field_71069_bz = new ohws(this.field_71071_by, !ozlu2.field_72995_K, this);
        this.field_70129_M = 1.62f;
        zwaw zwaw2 = ozlu2.func_72861_E();
        this.func_70012_b((double)zwaw2._a + 0.5, zwaw2._b + 1, (double)zwaw2._c + 0.5, 0.0f, 0.0f);
        this.field_70741_aB = 180.0f;
        this.field_70174_ab = 20;
        this.eyeHeight = this.getDefaultEyeHeight();
        GloomyHooks.createInfo(this);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110140_aT()._b(sajz._e)._a(1.0);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, (Object)0);
        this.field_70180_af._a(17, Float.valueOf(0.0f));
        this.field_70180_af._a(18, (Object)0);
    }

    @SideOnly(value=Side.CLIENT)
    public cvzo func_71011_bu() {
        return this.field_71074_e;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_71052_bv() {
        return this.field_71072_f;
    }

    public boolean func_71039_bw() {
        return this.field_71074_e != null;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_71057_bx() {
        return this.func_71039_bw() ? this.field_71074_e._n() - this.field_71072_f : 0;
    }

    public void func_71034_by() {
        if (this.field_71074_e != null) {
            this.field_71074_e._b(this.field_70170_p, this, this.field_71072_f);
        }
        this.func_71041_bz();
    }

    public void func_71041_bz() {
        this.field_71074_e = null;
        this.field_71072_f = 0;
        if (!this.field_70170_p.field_72995_K) {
            this.func_70019_c(false);
        }
    }

    public boolean func_70632_aY() {
        return this.func_71039_bw() && tgdv.field_77698_e[this.field_71074_e._d].func_77661_b(this.field_71074_e) == bsre._d;
    }

    @Override
    public void func_70071_h_() {
        FMLCommonHandler.instance().onPlayerPreTick(this);
        if (this.field_71074_e != null) {
            cvzo cvzo2 = this.field_71071_by._a();
            if (cvzo2 == this.field_71074_e) {
                this.field_71074_e._a().onUsingItemTick(this.field_71074_e, this, this.field_71072_f);
                if (this.field_71072_f <= 25 && this.field_71072_f % 4 == 0) {
                    this.func_71010_c(cvzo2, 5);
                }
                if (--this.field_71072_f == 0 && !this.field_70170_p.field_72995_K) {
                    this.func_71036_o();
                }
            } else {
                this.func_71041_bz();
            }
        }
        if (this.field_71090_bL > 0) {
            --this.field_71090_bL;
        }
        if (this.func_70608_bn()) {
            ++this.field_71076_b;
            if (this.field_71076_b > 100) {
                this.field_71076_b = 100;
            }
            if (!this.field_70170_p.field_72995_K) {
                if (!this.func_71065_l()) {
                    this.func_70999_a(true, true, false);
                } else if (this.field_70170_p.func_72935_r()) {
                    this.func_70999_a(false, true, true);
                }
            }
        } else if (this.field_71076_b > 0) {
            ++this.field_71076_b;
            if (this.field_71076_b >= 110) {
                this.field_71076_b = 0;
            }
        }
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K && this.field_71070_bA != null && !ForgeHooks.canInteractWith(this, this.field_71070_bA)) {
            this.func_71053_j();
            this.field_71070_bA = this.field_71069_bz;
        }
        if (this.func_70027_ad() && this.field_71075_bZ._a) {
            this.func_70066_B();
        }
        this.field_71091_bM = this.field_71094_bP;
        this.field_71096_bN = this.field_71095_bQ;
        this.field_71097_bO = this.field_71085_bR;
        double d = this.field_70165_t - this.field_71094_bP;
        double d2 = this.field_70163_u - this.field_71095_bQ;
        double d3 = this.field_70161_v - this.field_71085_bR;
        double d4 = 10.0;
        if (d > d4) {
            this.field_71091_bM = this.field_71094_bP = this.field_70165_t;
        }
        if (d3 > d4) {
            this.field_71097_bO = this.field_71085_bR = this.field_70161_v;
        }
        if (d2 > d4) {
            this.field_71096_bN = this.field_71095_bQ = this.field_70163_u;
        }
        if (d < -d4) {
            this.field_71091_bM = this.field_71094_bP = this.field_70165_t;
        }
        if (d3 < -d4) {
            this.field_71097_bO = this.field_71085_bR = this.field_70161_v;
        }
        if (d2 < -d4) {
            this.field_71096_bN = this.field_71095_bQ = this.field_70163_u;
        }
        this.field_71094_bP += d * 0.25;
        this.field_71085_bR += d3 * 0.25;
        this.field_71095_bQ += d2 * 0.25;
        this.func_71064_a(dzif._k, 1);
        if (this.field_70154_o == null) {
            this.field_71073_d = null;
        }
        if (!this.field_70170_p.field_72995_K) {
            this.field_71100_bB._a(this);
        }
        FMLCommonHandler.instance().onPlayerPostTick(this);
    }

    @Override
    public int func_82145_z() {
        return this.field_71075_bZ._a ? 0 : 80;
    }

    @Override
    public int func_82147_ab() {
        return 10;
    }

    @Override
    public void func_85030_a(String string, float f, float f2) {
        this.field_70170_p.func_85173_a(this, string, f, f2);
    }

    public void func_71010_c(cvzo cvzo2, int n) {
        if (cvzo2._o() == bsre._c) {
            this.func_85030_a("random.drink", 0.5f, this.field_70170_p.field_73012_v.nextFloat() * 0.1f + 0.9f);
        }
        if (cvzo2._o() == bsre._b) {
            for (int i = 0; i < n; ++i) {
                ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(((double)this.field_70146_Z.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
                ofbx2._a(-this.field_70125_A * (float)Math.PI / 180.0f);
                ofbx2._b(-this.field_70177_z * (float)Math.PI / 180.0f);
                ofbx ofbx3 = this.field_70170_p.func_82732_R()._a(((double)this.field_70146_Z.nextFloat() - 0.5) * 0.3, (double)(-this.field_70146_Z.nextFloat()) * 0.6 - 0.3, 0.6);
                ofbx3._a(-this.field_70125_A * (float)Math.PI / 180.0f);
                ofbx3._b(-this.field_70177_z * (float)Math.PI / 180.0f);
                ofbx3 = ofbx3._c(this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v);
                this.field_70170_p.func_72869_a("iconcrack_" + cvzo2._a().field_77779_bT + "_" + cvzo2._j(), ofbx3._c, ofbx3._d, ofbx3._e, ofbx2._c, ofbx2._d + 0.05, ofbx2._e);
            }
            this.func_85030_a("random.eat", 0.5f + 0.5f * (float)this.field_70146_Z.nextInt(2), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
        }
    }

    public void func_71036_o() {
        if (this.field_71074_e != null) {
            this.func_71010_c(this.field_71074_e, 16);
            int n = this.field_71074_e._b;
            cvzo cvzo2 = this.field_71074_e._b(this.field_70170_p, this);
            if (cvzo2 != this.field_71074_e || cvzo2 != null && cvzo2._b != n) {
                this.field_71071_by._a[this.field_71071_by._c] = cvzo2;
                if (cvzo2._b == 0) {
                    this.field_71071_by._a[this.field_71071_by._c] = null;
                }
            }
            this.func_71041_bz();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70103_a(byte by) {
        if (by == 9) {
            this.func_71036_o();
        } else {
            super.func_70103_a(by);
        }
    }

    @Override
    public boolean func_70610_aX() {
        return this.func_110143_aJ() <= 0.0f || this.func_70608_bn();
    }

    public void func_71053_j() {
        this.field_71070_bA = this.field_71069_bz;
    }

    @Override
    public void func_70078_a(Entity entity) {
        if (this.field_70154_o != null && entity == null) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_110145_l(this.field_70154_o);
            }
            if (this.field_70154_o != null) {
                this.field_70154_o.field_70153_n = null;
            }
            this.field_70154_o = null;
        } else {
            super.func_70078_a(entity);
        }
    }

    @Override
    public void func_70098_U() {
        if (!this.field_70170_p.field_72995_K && this.func_70093_af()) {
            this.func_70078_a(null);
            this.func_70095_a(false);
        } else {
            double d = this.field_70165_t;
            double d2 = this.field_70163_u;
            double d3 = this.field_70161_v;
            float f = this.field_70177_z;
            float f2 = this.field_70125_A;
            super.func_70098_U();
            this.field_71107_bF = this.field_71109_bG;
            this.field_71109_bG = 0.0f;
            this.func_71015_k(this.field_70165_t - d, this.field_70163_u - d2, this.field_70161_v - d3);
            if (this.field_70154_o instanceof EntityLivingBase && ((EntityLivingBase)this.field_70154_o).shouldRiderFaceForward(this)) {
                this.field_70125_A = f2;
                this.field_70177_z = f;
                this.field_70761_aq = ((EntityLivingBase)this.field_70154_o).field_70761_aq;
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70065_x() {
        GloomyHooks.preparePlayerToSpawn(this);
        this.field_70129_M = 1.62f;
        this.func_70105_a(0.6f, 1.8f);
        super.func_70065_x();
        this.func_70606_j(this.func_110138_aP());
        this.field_70725_aQ = 0;
    }

    @Override
    public void func_70626_be() {
        super.func_70626_be();
        this.func_82168_bl();
    }

    @Override
    public void func_70636_d() {
        if (this.field_71101_bC > 0) {
            --this.field_71101_bC;
        }
        if (this.field_70170_p.field_73013_u == 0 && this.func_110143_aJ() < this.func_110138_aP() && this.field_70170_p.func_82736_K()._b("naturalRegeneration") && this.field_70173_aa % 20 * 12 == 0) {
            this.func_70691_i(1.0f);
        }
        this.field_71071_by._d();
        this.field_71107_bF = this.field_71109_bG;
        super.func_70636_d();
        hubf hubf2 = this.func_110148_a(sajz._d);
        if (!this.field_70170_p.field_72995_K) {
            hubf2._a(this.field_71075_bZ._b());
        }
        this.field_70747_aH = this.field_71102_ce;
        if (this.func_70051_ag()) {
            this.field_70747_aH = (float)((double)this.field_70747_aH + (double)this.field_71102_ce * 0.3);
        }
        this.func_70659_e((float)hubf2._e());
        float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        float f2 = (float)Math.atan(-this.field_70181_x * (double)0.2f) * 15.0f;
        if (f > 0.1f) {
            f = 0.1f;
        }
        if (!this.field_70122_E || this.func_110143_aJ() <= 0.0f) {
            f = 0.0f;
        }
        if (this.field_70122_E || this.func_110143_aJ() <= 0.0f) {
            f2 = 0.0f;
        }
        this.field_71109_bG += (f - this.field_71109_bG) * 0.4f;
        this.field_70726_aT += (f2 - this.field_70726_aT) * 0.8f;
        if (this.func_110143_aJ() > 0.0f) {
            net.minecraft.util.eidj eidj2 = null;
            eidj2 = this.field_70154_o != null && !this.field_70154_o.field_70128_L ? this.field_70121_D._a(this.field_70154_o.field_70121_D)._b(1.0, 0.0, 1.0) : this.field_70121_D._b(1.0, 0.5, 1.0);
            List list = this.field_70170_p.func_72839_b(this, eidj2);
            if (list != null) {
                for (int i = 0; i < list.size(); ++i) {
                    Entity entity = (Entity)list.get(i);
                    if (entity.field_70128_L) continue;
                    this.func_71044_o(entity);
                }
            }
        }
    }

    public void func_71044_o(Entity entity) {
        entity.func_70100_b_(this);
    }

    public int func_71037_bA() {
        return this.field_70180_af._c(18);
    }

    public void func_85040_s(int n) {
        this.field_70180_af._b(18, n);
    }

    public void func_85039_t(int n) {
        int n2 = this.func_71037_bA();
        this.field_70180_af._b(18, n2 + n);
    }

    @Override
    public void func_70645_a(jxtc jxtc2) {
        PlayerDropsEvent playerDropsEvent;
        if (ForgeHooks.onLivingDeath(this, jxtc2)) {
            return;
        }
        super.func_70645_a(jxtc2);
        this.func_70105_a(0.2f, 0.2f);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70181_x = 0.1f;
        this.captureDrops = true;
        this.capturedDrops.clear();
        if (this.field_71092_bJ.equals("Notch")) {
            this.func_71019_a(new cvzo(tgdv.field_77706_j, 1), true);
        }
        if (!this.field_70170_p.func_82736_K()._b("keepInventory")) {
            this.field_71071_by._f();
        }
        this.captureDrops = false;
        if (!this.field_70170_p.field_72995_K && !MinecraftForge.EVENT_BUS.post(playerDropsEvent = new PlayerDropsEvent(this, jxtc2, this.capturedDrops, this.field_70718_bc > 0))) {
            for (EntityItem entityItem : this.capturedDrops) {
                this.func_71012_a(entityItem);
            }
        }
        if (jxtc2 != null) {
            this.field_70159_w = -sajh._b((this.field_70739_aP + this.field_70177_z) * (float)Math.PI / 180.0f) * 0.1f;
            this.field_70179_y = -sajh._a((this.field_70739_aP + this.field_70177_z) * (float)Math.PI / 180.0f) * 0.1f;
        } else {
            this.field_70179_y = 0.0;
            this.field_70159_w = 0.0;
        }
        this.field_70129_M = 0.1f;
        this.func_71064_a(dzif._y, 1);
    }

    @Override
    public void func_70084_c(Entity entity, int n) {
        this.func_85039_t(n);
        Collection collection = this.func_96123_co()._a(nwbn._f);
        if (entity instanceof EntityPlayer) {
            this.func_71064_a(dzif._A, 1);
            collection.addAll(this.func_96123_co()._a(nwbn._e));
        } else {
            this.func_71064_a(dzif._z, 1);
        }
        for (igri igri2 : collection) {
            cwdc cwdc2 = this.func_96123_co()._a(this.func_70023_ak(), igri2);
            cwdc2._a();
        }
    }

    public EntityItem func_71040_bB(boolean bl) {
        cvzo cvzo2 = this.field_71071_by._a();
        if (cvzo2 == null) {
            return null;
        }
        if (cvzo2._a().onDroppedByPlayer(cvzo2, this)) {
            int n = bl && this.field_71071_by._a() != null ? this.field_71071_by._a()._b : 1;
            return ForgeHooks.onPlayerTossEvent(this, this.field_71071_by.func_70298_a(this.field_71071_by._c, n));
        }
        return null;
    }

    public EntityItem func_71021_b(cvzo cvzo2) {
        return ForgeHooks.onPlayerTossEvent(this, cvzo2);
    }

    public EntityItem func_71019_a(cvzo cvzo2, boolean bl) {
        if (cvzo2 == null) {
            return null;
        }
        if (cvzo2._b == 0) {
            return null;
        }
        EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u - (double)0.3f + (double)this.func_70047_e(), this.field_70161_v, cvzo2);
        entityItem.field_70293_c = 40;
        float f = 0.1f;
        if (bl) {
            float f2 = this.field_70146_Z.nextFloat() * 0.5f;
            float f3 = this.field_70146_Z.nextFloat() * (float)Math.PI * 2.0f;
            entityItem.field_70159_w = -sajh._a(f3) * f2;
            entityItem.field_70179_y = sajh._b(f3) * f2;
            entityItem.field_70181_x = 0.2f;
        } else {
            f = 0.3f;
            entityItem.field_70159_w = -sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI) * f;
            entityItem.field_70179_y = sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI) * f;
            entityItem.field_70181_x = -sajh._a(this.field_70125_A / 180.0f * (float)Math.PI) * f + 0.1f;
            f = 0.02f;
            float f4 = this.field_70146_Z.nextFloat() * (float)Math.PI * 2.0f;
            entityItem.field_70159_w += Math.cos(f4) * (double)(f *= this.field_70146_Z.nextFloat());
            entityItem.field_70181_x += (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1f);
            entityItem.field_70179_y += Math.sin(f4) * (double)f;
        }
        this.func_71012_a(entityItem);
        this.func_71064_a(dzif._v, 1);
        return entityItem;
    }

    public void func_71012_a(EntityItem entityItem) {
        if (this.captureDrops) {
            this.capturedDrops.add(entityItem);
            return;
        }
        this.field_70170_p.func_72838_d(entityItem);
    }

    @Deprecated
    public float func_71055_a(twgu twgu2, boolean bl) {
        return this.getCurrentPlayerStrVsBlock(twgu2, bl, 0);
    }

    public float getCurrentPlayerStrVsBlock(twgu twgu2, boolean bl, int n) {
        float f;
        cvzo cvzo2 = this.field_71071_by._a();
        float f2 = f = cvzo2 == null ? 1.0f : cvzo2._a().getStrVsBlock(cvzo2, twgu2, n);
        if (f > 1.0f) {
            int n2 = zhty._c(this);
            cvzo cvzo3 = this.field_71071_by._a();
            if (n2 > 0 && cvzo3 != null) {
                float f3 = n2 * n2 + 1;
                boolean bl2 = ForgeHooks.canToolHarvestBlock(twgu2, n, cvzo3);
                f = !bl2 && f <= 1.0f ? (f += f3 * 0.08f) : (f += f3);
            }
        }
        if (this.func_70644_a(hdpq._e)) {
            f *= 1.0f + (float)(this.func_70660_b(hdpq._e)._c() + 1) * 0.2f;
        }
        if (this.func_70644_a(hdpq._f)) {
            f *= 1.0f - (float)(this.func_70660_b(hdpq._f)._c() + 1) * 0.2f;
        }
        if (this.func_70055_a(tflj._h) && !zhty._g(this)) {
            f /= 5.0f;
        }
        if (!this.field_70122_E) {
            f /= 5.0f;
        }
        return (f = ForgeEventFactory.getBreakSpeed(this, twgu2, n, f)) < 0.0f ? 0.0f : f;
    }

    public boolean func_71062_b(twgu twgu2) {
        return ForgeEventFactory.doPlayerHarvestCheck(this, twgu2, this.field_71071_by._b(twgu2));
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        bsyv bsyv2 = qoac2._n("Inventory");
        this.field_71071_by._b(bsyv2);
        this.field_71071_by._c = qoac2._f("SelectedItemSlot");
        this.field_71083_bS = qoac2._o("Sleeping");
        this.field_71076_b = qoac2._e("SleepTimer");
        this.field_71106_cc = qoac2._h("XpP");
        this.field_71068_ca = qoac2._f("XpLevel");
        this.field_71067_cb = qoac2._f("XpTotal");
        this.func_85040_s(qoac2._f("Score"));
        if (this.field_71083_bS) {
            this.field_71081_bT = new zwaw(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v));
            this.func_70999_a(true, true, false);
        }
        if (qoac2._c("SpawnX") && qoac2._c("SpawnY") && qoac2._c("SpawnZ")) {
            this.field_71077_c = new zwaw(qoac2._f("SpawnX"), qoac2._f("SpawnY"), qoac2._f("SpawnZ"));
            this.field_82248_d = qoac2._o("SpawnForced");
        }
        bsyv bsyv3 = null;
        bsyv3 = qoac2._n("Spawns");
        for (int i = 0; i < bsyv3._d(); ++i) {
            qoac qoac3 = (qoac)bsyv3._b(i);
            int n = qoac3._f("Dim");
            this.spawnChunkMap.put(n, new zwaw(qoac3._f("SpawnX"), qoac3._f("SpawnY"), qoac3._f("SpawnZ")));
            this.spawnForcedMap.put(n, qoac3._o("SpawnForced"));
        }
        this.field_71100_bB._a(qoac2);
        this.field_71075_bZ._b(qoac2);
        if (qoac2._c("EnderItems")) {
            bsyv bsyv4 = qoac2._n("EnderItems");
            this.field_71078_a._a(bsyv4);
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("Inventory", this.field_71071_by._a(new bsyv()));
        qoac2._a("SelectedItemSlot", this.field_71071_by._c);
        qoac2._a("Sleeping", this.field_71083_bS);
        qoac2._a("SleepTimer", (short)this.field_71076_b);
        qoac2._a("XpP", this.field_71106_cc);
        qoac2._a("XpLevel", this.field_71068_ca);
        qoac2._a("XpTotal", this.field_71067_cb);
        qoac2._a("Score", this.func_71037_bA());
        if (this.field_71077_c != null) {
            qoac2._a("SpawnX", this.field_71077_c._a);
            qoac2._a("SpawnY", this.field_71077_c._b);
            qoac2._a("SpawnZ", this.field_71077_c._c);
            qoac2._a("SpawnForced", this.field_82248_d);
        }
        bsyv bsyv2 = new bsyv();
        for (Map.Entry<Integer, zwaw> entry : this.spawnChunkMap.entrySet()) {
            qoac qoac3 = new qoac();
            zwaw zwaw2 = entry.getValue();
            if (zwaw2 == null) continue;
            Boolean bl = this.spawnForcedMap.get(entry.getKey());
            if (bl == null) {
                bl = false;
            }
            qoac3._a("Dim", (int)entry.getKey());
            qoac3._a("SpawnX", zwaw2._a);
            qoac3._a("SpawnY", zwaw2._b);
            qoac3._a("SpawnZ", zwaw2._c);
            qoac3._a("SpawnForced", bl);
            bsyv2._a(qoac3);
        }
        qoac2._a("Spawns", bsyv2);
        this.field_71100_bB._b(qoac2);
        this.field_71075_bZ._a(qoac2);
        qoac2._a("EnderItems", this.field_71078_a._a());
    }

    public void func_71007_a(mssh mssh2) {
    }

    public void func_94064_a(cffd cffd2) {
    }

    public void func_96125_a(EntityMinecartHopper entityMinecartHopper) {
    }

    public void func_110298_a(EntityHorse entityHorse, mssh mssh2) {
    }

    public void func_71002_c(int n, int n2, int n3, String string) {
    }

    public void func_82244_d(int n, int n2, int n3) {
    }

    public void func_71058_b(int n, int n2, int n3) {
    }

    @Override
    public float func_70047_e() {
        return this.eyeHeight;
    }

    public void func_71061_d_() {
        this.field_70129_M = 1.62f;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (ForgeHooks.onLivingAttack(this, jxtc2, f)) {
            return false;
        }
        if (this.func_85032_ar()) {
            return false;
        }
        if (this.field_71075_bZ._a && !jxtc2.func_76357_e()) {
            return false;
        }
        this.field_70708_bq = 0;
        if (this.func_110143_aJ() <= 0.0f) {
            return false;
        }
        if (this.func_70608_bn() && !this.field_70170_p.field_72995_K) {
            this.func_70999_a(true, true, false);
        }
        if (jxtc2.func_76350_n()) {
            if (this.field_70170_p.field_73013_u == 0) {
                f = 0.0f;
            }
            if (this.field_70170_p.field_73013_u == 1) {
                f = f / 2.0f + 1.0f;
            }
            if (this.field_70170_p.field_73013_u == 3) {
                f = f * 3.0f / 2.0f;
            }
        }
        if (f == 0.0f) {
            return false;
        }
        Entity entity = jxtc2.func_76346_g();
        if (entity instanceof EntityArrow && ((EntityArrow)entity).field_70250_c != null) {
            entity = ((EntityArrow)entity).field_70250_c;
        }
        this.func_71064_a(dzif._x, Math.round(f * 10.0f));
        return super.func_70097_a(jxtc2, f);
    }

    public boolean func_96122_a(EntityPlayer entityPlayer) {
        cwci cwci2 = this.func_96124_cp();
        cwci cwci3 = entityPlayer.func_96124_cp();
        return cwci2 == null ? true : (!cwci2._a(cwci3) ? true : cwci2._f());
    }

    @Override
    public void func_70675_k(float f) {
        this.field_71071_by._a(f);
    }

    @Override
    public int func_70658_aO() {
        return this.field_71071_by._e();
    }

    public float func_82243_bO() {
        int n = 0;
        for (cvzo cvzo2 : this.field_71071_by._b) {
            if (cvzo2 == null) continue;
            ++n;
        }
        return (float)n / (float)this.field_71071_by._b.length;
    }

    @Override
    public void func_70665_d(jxtc jxtc2, float f) {
        if (!this.func_85032_ar()) {
            if ((f = ForgeHooks.onLivingHurt(this, jxtc2, f)) <= 0.0f) {
                return;
            }
            if (!jxtc2.func_76363_c() && this.func_70632_aY() && f > 0.0f) {
                f = (1.0f + f) * 0.5f;
            }
            if ((f = ISpecialArmor.ArmorProperties.ApplyArmor(this, this.field_71071_by._b, jxtc2, f)) <= 0.0f) {
                return;
            }
            float f2 = f = this.func_70672_c(jxtc2, f);
            f = Math.max(f - this.func_110139_bj(), 0.0f);
            this.func_110149_m(this.func_110139_bj() - (f2 - f));
            if (f != 0.0f) {
                this.func_71020_j(jxtc2.func_76345_d());
                float f3 = this.func_110143_aJ();
                this.func_70606_j(this.func_110143_aJ() - f);
                this.func_110142_aN()._a(jxtc2, f3, f);
            }
        }
    }

    public void func_71042_a(nwgz nwgz2) {
    }

    public void func_71006_a(jjzo jjzo2) {
    }

    public void func_71014_a(hurg hurg2) {
    }

    public void func_71017_a(nfbs nfbs2) {
    }

    public void func_82240_a(vmyb vmyb2) {
    }

    public void func_71030_a(amww amww2, String string) {
    }

    public void func_71048_c(cvzo cvzo2) {
    }

    public boolean func_70998_m(Entity entity) {
        cvzo cvzo2;
        if (MinecraftForge.EVENT_BUS.post(new EntityInteractEvent(this, entity))) {
            return false;
        }
        cvzo cvzo3 = this.func_71045_bC();
        cvzo cvzo4 = cvzo2 = cvzo3 != null ? cvzo3._l() : null;
        if (!entity.func_130002_c(this)) {
            if (cvzo3 != null && entity instanceof EntityLivingBase) {
                if (this.field_71075_bZ._d) {
                    cvzo3 = cvzo2;
                }
                if (cvzo3._a(this, (EntityLivingBase)entity)) {
                    if (cvzo3._b <= 0 && !this.field_71075_bZ._d) {
                        this.func_71028_bD();
                    }
                    return true;
                }
            }
            return false;
        }
        if (cvzo3 != null && cvzo3 == this.func_71045_bC()) {
            if (cvzo3._b <= 0 && !this.field_71075_bZ._d) {
                this.func_71028_bD();
            } else if (cvzo3._b < cvzo2._b && this.field_71075_bZ._d) {
                cvzo3._b = cvzo2._b;
            }
        }
        return true;
    }

    public cvzo func_71045_bC() {
        return this.field_71071_by._a();
    }

    public void func_71028_bD() {
        cvzo cvzo2 = this.func_71045_bC();
        this.field_71071_by.func_70299_a(this.field_71071_by._c, null);
        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(this, cvzo2));
    }

    @Override
    public double func_70033_W() {
        return this.field_70129_M - 0.5f;
    }

    public void func_71059_n(Entity entity) {
        if (MinecraftForge.EVENT_BUS.post(new AttackEntityEvent(this, entity))) {
            return;
        }
        cvzo cvzo2 = this.func_71045_bC();
        if (cvzo2 != null && cvzo2._a().onLeftClickEntity(cvzo2, this, entity)) {
            return;
        }
        if (entity.func_70075_an() && !entity.func_85031_j(this)) {
            float f = (float)this.func_110148_a(sajz._e)._e();
            int n = 0;
            float f2 = 0.0f;
            if (entity instanceof EntityLivingBase) {
                f2 = zhty._a(this, (EntityLivingBase)entity);
                n += zhty._b(this, (EntityLivingBase)entity);
            }
            if (this.func_70051_ag()) {
                ++n;
            }
            if (f > 0.0f || f2 > 0.0f) {
                ezfa ezfa2;
                boolean bl;
                boolean bl2;
                boolean bl3 = bl2 = this.field_70143_R > 0.0f && !this.field_70122_E && !this.func_70617_f_() && !this.func_70090_H() && !this.func_70644_a(hdpq._q) && this.field_70154_o == null && entity instanceof EntityLivingBase;
                if (bl2 && f > 0.0f) {
                    f *= 1.5f;
                }
                f += f2;
                boolean bl4 = false;
                int n2 = zhty._a(this);
                if (entity instanceof EntityLivingBase && n2 > 0 && !entity.func_70027_ad()) {
                    bl4 = true;
                    entity.func_70015_d(1);
                }
                if (bl = entity.func_70097_a(jxtc.func_76365_a(this), f)) {
                    if (n > 0) {
                        entity.func_70024_g(-sajh._a(this.field_70177_z * (float)Math.PI / 180.0f) * (float)n * 0.5f, 0.1, sajh._b(this.field_70177_z * (float)Math.PI / 180.0f) * (float)n * 0.5f);
                        this.field_70159_w *= 0.6;
                        this.field_70179_y *= 0.6;
                        this.func_70031_b(false);
                    }
                    if (bl2) {
                        this.func_71009_b(entity);
                    }
                    if (f2 > 0.0f) {
                        this.func_71047_c(entity);
                    }
                    if (f >= 18.0f) {
                        this.func_71029_a(sdqa._E);
                    }
                    this.func_130011_c(entity);
                    if (entity instanceof EntityLivingBase) {
                        ekyk._a(this, (EntityLivingBase)entity, this.field_70146_Z);
                    }
                }
                cvzo cvzo3 = this.func_71045_bC();
                Entity entity2 = entity;
                if (entity instanceof EntityDragonPart && (ezfa2 = ((EntityDragonPart)entity).field_70259_a) != null && ezfa2 instanceof EntityLivingBase) {
                    entity2 = (EntityLivingBase)((Object)ezfa2);
                }
                if (cvzo3 != null && entity2 instanceof EntityLivingBase) {
                    cvzo3._a((EntityLivingBase)entity2, this);
                    if (cvzo3._b <= 0) {
                        this.func_71028_bD();
                    }
                }
                if (entity instanceof EntityLivingBase) {
                    this.func_71064_a(dzif._w, Math.round(f * 10.0f));
                    if (n2 > 0 && bl) {
                        entity.func_70015_d(n2 * 4);
                    } else if (bl4) {
                        entity.func_70066_B();
                    }
                }
                this.func_71020_j(0.3f);
            }
        }
    }

    public void func_71009_b(Entity entity) {
    }

    public void func_71047_c(Entity entity) {
    }

    @SideOnly(value=Side.CLIENT)
    public void func_71004_bE() {
    }

    @Override
    public void func_70106_y() {
        super.func_70106_y();
        this.field_71069_bz.func_75134_a(this);
        if (this.field_71070_bA != null) {
            this.field_71070_bA.func_75134_a(this);
        }
    }

    @Override
    public boolean func_70094_T() {
        return !this.field_71083_bS && super.func_70094_T();
    }

    public pidb func_71018_a(int n, int n2, int n3) {
        PlayerSleepInBedEvent playerSleepInBedEvent = new PlayerSleepInBedEvent(this, n, n2, n3);
        MinecraftForge.EVENT_BUS.post(playerSleepInBedEvent);
        if (playerSleepInBedEvent.result != null) {
            return playerSleepInBedEvent.result;
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_70608_bn() || !this.func_70089_S()) {
                return pidb._e;
            }
            if (!this.field_70170_p.field_73011_w._d()) {
                return pidb._b;
            }
            if (this.field_70170_p.func_72935_r()) {
                return pidb._c;
            }
            if (Math.abs(this.field_70165_t - (double)n) > 3.0 || Math.abs(this.field_70163_u - (double)n2) > 2.0 || Math.abs(this.field_70161_v - (double)n3) > 3.0) {
                return pidb._d;
            }
            double d = 8.0;
            double d2 = 5.0;
            List list = this.field_70170_p.func_72872_a(EntityMob.class, net.minecraft.util.eidj._a()._a((double)n - d, (double)n2 - d2, (double)n3 - d, (double)n + d, (double)n2 + d2, (double)n3 + d));
            if (!list.isEmpty()) {
                return pidb._f;
            }
        }
        if (this.func_70115_ae()) {
            this.func_70078_a(null);
        }
        this.func_70105_a(0.2f, 0.2f);
        this.field_70129_M = 0.2f;
        if (this.field_70170_p.func_72899_e(n, n2, n3)) {
            int n4 = this.field_70170_p.func_72805_g(n, n2, n3);
            int n5 = gqbt._d(n4);
            twgu twgu2 = twgu.field_71973_m[this.field_70170_p.func_72798_a(n, n2, n3)];
            if (twgu2 != null) {
                n5 = twgu2.getBedDirection(this.field_70170_p, n, n2, n3);
            }
            float f = 0.5f;
            float f2 = 0.5f;
            switch (n5) {
                case 0: {
                    f2 = 0.9f;
                    break;
                }
                case 1: {
                    f = 0.1f;
                    break;
                }
                case 2: {
                    f2 = 0.1f;
                    break;
                }
                case 3: {
                    f = 0.9f;
                }
            }
            this.func_71013_b(n5);
            this.func_70107_b((float)n + f, (float)n2 + 0.9375f, (float)n3 + f2);
        } else {
            this.func_70107_b((float)n + 0.5f, (float)n2 + 0.9375f, (float)n3 + 0.5f);
        }
        this.field_71083_bS = true;
        this.field_71076_b = 0;
        this.field_71081_bT = new zwaw(n, n2, n3);
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        this.field_70159_w = 0.0;
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72854_c();
        }
        return pidb._a;
    }

    public void func_71013_b(int n) {
        this.field_71079_bU = 0.0f;
        this.field_71089_bV = 0.0f;
        switch (n) {
            case 0: {
                this.field_71089_bV = -1.8f;
                break;
            }
            case 1: {
                this.field_71079_bU = 1.8f;
                break;
            }
            case 2: {
                this.field_71089_bV = 1.8f;
                break;
            }
            case 3: {
                this.field_71079_bU = -1.8f;
            }
        }
    }

    public void func_70999_a(boolean bl, boolean bl2, boolean bl3) {
        twgu twgu2;
        this.func_70105_a(0.6f, 1.8f);
        this.func_71061_d_();
        zwaw zwaw2 = this.field_71081_bT;
        zwaw zwaw3 = this.field_71081_bT;
        twgu twgu3 = twgu2 = zwaw2 == null ? null : twgu.field_71973_m[this.field_70170_p.func_72798_a(zwaw2._a, zwaw2._b, zwaw2._c)];
        if (zwaw2 != null && twgu2 != null && twgu2.isBed(this.field_70170_p, zwaw2._a, zwaw2._b, zwaw2._c, this)) {
            twgu2.setBedOccupied(this.field_70170_p, zwaw2._a, zwaw2._b, zwaw2._c, this, false);
            zwaw3 = twgu2.getBedSpawnPosition(this.field_70170_p, zwaw2._a, zwaw2._b, zwaw2._c, this);
            if (zwaw3 == null) {
                zwaw3 = new zwaw(zwaw2._a, zwaw2._b + 1, zwaw2._c);
            }
            this.func_70107_b((float)zwaw3._a + 0.5f, (float)zwaw3._b + this.field_70129_M + 0.1f, (float)zwaw3._c + 0.5f);
        }
        this.field_71083_bS = false;
        if (!this.field_70170_p.field_72995_K && bl2) {
            this.field_70170_p.func_72854_c();
        }
        this.field_71076_b = bl ? 0 : 100;
        if (bl3) {
            this.func_71063_a(this.field_71081_bT, false);
        }
    }

    public boolean func_71065_l() {
        zwaw zwaw2 = this.field_71081_bT;
        int n = this.field_70170_p.func_72798_a(zwaw2._a, zwaw2._b, zwaw2._c);
        return twgu.field_71973_m[n] != null && twgu.field_71973_m[n].isBed(this.field_70170_p, zwaw2._a, zwaw2._b, zwaw2._c, this);
    }

    public static zwaw func_71056_a(ozlu ozlu2, zwaw zwaw2, boolean bl) {
        mccn mccn2 = ozlu2.func_72863_F();
        mccn2._a(zwaw2._a - 3 >> 4, zwaw2._c - 3 >> 4);
        mccn2._a(zwaw2._a + 3 >> 4, zwaw2._c - 3 >> 4);
        mccn2._a(zwaw2._a - 3 >> 4, zwaw2._c + 3 >> 4);
        mccn2._a(zwaw2._a + 3 >> 4, zwaw2._c + 3 >> 4);
        zwaw zwaw3 = zwaw2;
        twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(zwaw3._a, zwaw3._b, zwaw3._c)];
        if (twgu2 != null && twgu2.isBed(ozlu2, zwaw3._a, zwaw3._b, zwaw3._c, null)) {
            zwaw zwaw4 = twgu2.getBedSpawnPosition(ozlu2, zwaw3._a, zwaw3._b, zwaw3._c, null);
            return zwaw4;
        }
        tflj tflj2 = ozlu2.func_72803_f(zwaw2._a, zwaw2._b, zwaw2._c);
        tflj tflj3 = ozlu2.func_72803_f(zwaw2._a, zwaw2._b + 1, zwaw2._c);
        boolean bl2 = !tflj2._a() && !tflj2._d();
        boolean bl3 = !tflj3._a() && !tflj3._d();
        return bl && bl2 && bl3 ? zwaw2 : null;
    }

    @SideOnly(value=Side.CLIENT)
    public float func_71051_bG() {
        if (this.field_71081_bT != null) {
            int n = this.field_71081_bT._a;
            int n2 = this.field_71081_bT._b;
            int n3 = this.field_71081_bT._c;
            twgu twgu2 = twgu.field_71973_m[this.field_70170_p.func_72798_a(n, n2, n3)];
            int n4 = twgu2 == null ? 0 : twgu2.getBedDirection(this.field_70170_p, n, n2, n3);
            switch (n4) {
                case 0: {
                    return 90.0f;
                }
                case 1: {
                    return 0.0f;
                }
                case 2: {
                    return 270.0f;
                }
                case 3: {
                    return 180.0f;
                }
            }
        }
        return 0.0f;
    }

    @Override
    public boolean func_70608_bn() {
        return this.field_71083_bS;
    }

    public boolean func_71026_bH() {
        return this.field_71083_bS && this.field_71076_b >= 100;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_71060_bI() {
        return this.field_71076_b;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_82241_s(int n) {
        return (this.field_70180_af._a(16) & 1 << n) != 0;
    }

    public void func_82239_b(int n, boolean bl) {
        byte by = this.field_70180_af._a(16);
        if (bl) {
            this.field_70180_af._b(16, (byte)(by | 1 << n));
        } else {
            this.field_70180_af._b(16, (byte)(by & ~(1 << n)));
        }
    }

    public void func_71035_c(String string) {
    }

    @Deprecated
    public zwaw func_70997_bJ() {
        return this.getBedLocation(this.field_71093_bK);
    }

    @Deprecated
    public boolean func_82245_bX() {
        return this.isSpawnForced(this.field_71093_bK);
    }

    public zwaw getBedLocation(int n) {
        if (n == 0) {
            return this.field_71077_c;
        }
        return this.spawnChunkMap.get(n);
    }

    public boolean isSpawnForced(int n) {
        if (n == 0) {
            return this.field_82248_d;
        }
        Boolean bl = this.spawnForcedMap.get(n);
        if (bl == null) {
            return false;
        }
        return bl;
    }

    public void func_71063_a(zwaw zwaw2, boolean bl) {
        if (this.field_71093_bK != 0) {
            this.setSpawnChunk(zwaw2, bl, this.field_71093_bK);
            return;
        }
        if (zwaw2 != null) {
            this.field_71077_c = new zwaw(zwaw2);
            this.field_82248_d = bl;
        } else {
            this.field_71077_c = null;
            this.field_82248_d = false;
        }
    }

    public void setSpawnChunk(zwaw zwaw2, boolean bl, int n) {
        if (n == 0) {
            if (zwaw2 != null) {
                this.field_71077_c = new zwaw(zwaw2);
                this.field_82248_d = bl;
            } else {
                this.field_71077_c = null;
                this.field_82248_d = false;
            }
            return;
        }
        if (zwaw2 != null) {
            this.spawnChunkMap.put(n, new zwaw(zwaw2));
            this.spawnForcedMap.put(n, bl);
        } else {
            this.spawnChunkMap.remove(n);
            this.spawnForcedMap.remove(n);
        }
    }

    public void func_71029_a(rann rann2) {
        this.func_71064_a(rann2, 1);
    }

    public void func_71064_a(rann rann2, int n) {
    }

    @Override
    public void func_70664_aZ() {
        if (GloomyHooks.onJump(this)) {
            return;
        }
        super.func_70664_aZ();
        this.func_71064_a(dzif._u, 1);
        if (this.func_70051_ag()) {
            this.func_71020_j(0.8f);
        } else {
            this.func_71020_j(0.2f);
        }
        GloomyHooks.afterJump(this);
    }

    @Override
    public void func_70612_e(float f, float f2) {
        double d = this.field_70165_t;
        double d2 = this.field_70163_u;
        double d3 = this.field_70161_v;
        if (this.field_71075_bZ._b && this.field_70154_o == null) {
            double d4 = this.field_70181_x;
            float f3 = this.field_70747_aH;
            this.field_70747_aH = this.field_71075_bZ._a();
            super.func_70612_e(f, f2);
            this.field_70181_x = d4 * 0.6;
            this.field_70747_aH = f3;
        } else {
            super.func_70612_e(f, f2);
        }
        this.func_71000_j(this.field_70165_t - d, this.field_70163_u - d2, this.field_70161_v - d3);
    }

    @Override
    public float func_70689_ay() {
        return (float)this.func_110148_a(sajz._d)._e();
    }

    public void func_71000_j(double d, double d2, double d3) {
        if (this.field_70154_o == null) {
            if (this.func_70055_a(tflj._h)) {
                int n = Math.round(sajh._a(d * d + d2 * d2 + d3 * d3) * 100.0f);
                if (n > 0) {
                    this.func_71064_a(dzif._q, n);
                    this.func_71020_j(0.015f * (float)n * 0.01f);
                }
            } else if (this.func_70090_H()) {
                int n = Math.round(sajh._a(d * d + d3 * d3) * 100.0f);
                if (n > 0) {
                    this.func_71064_a(dzif._m, n);
                    this.func_71020_j(0.015f * (float)n * 0.01f);
                }
            } else if (this.func_70617_f_()) {
                if (d2 > 0.0) {
                    this.func_71064_a(dzif._o, (int)Math.round(d2 * 100.0));
                }
            } else if (this.field_70122_E) {
                int n = Math.round(sajh._a(d * d + d3 * d3) * 100.0f);
                if (n > 0) {
                    this.func_71064_a(dzif._l, n);
                    if (this.func_70051_ag()) {
                        this.func_71020_j(0.099999994f * (float)n * 0.01f);
                    } else {
                        this.func_71020_j(0.01f * (float)n * 0.01f);
                    }
                }
            } else {
                int n = Math.round(sajh._a(d * d + d3 * d3) * 100.0f);
                if (n > 25) {
                    this.func_71064_a(dzif._p, n);
                }
            }
        }
    }

    public void func_71015_k(double d, double d2, double d3) {
        int n;
        if (this.field_70154_o != null && (n = Math.round(sajh._a(d * d + d2 * d2 + d3 * d3) * 100.0f)) > 0) {
            if (this.field_70154_o instanceof EntityMinecart) {
                this.func_71064_a(dzif._r, n);
                if (this.field_71073_d == null) {
                    this.field_71073_d = new zwaw(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v));
                } else if ((double)this.field_71073_d._b(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)) >= 1000000.0) {
                    this.func_71064_a(sdqa._q, 1);
                }
            } else if (this.field_70154_o instanceof EntityBoat) {
                this.func_71064_a(dzif._s, n);
            } else if (this.field_70154_o instanceof EntityPig) {
                this.func_71064_a(dzif._t, n);
            }
        }
    }

    @Override
    public void func_70069_a(float f) {
        if (!this.field_71075_bZ._c) {
            if (f >= 2.0f) {
                this.func_71064_a(dzif._n, (int)Math.round((double)f * 100.0));
            }
            super.func_70069_a(f);
        } else {
            MinecraftForge.EVENT_BUS.post(new PlayerFlyableFallEvent(this, f));
        }
    }

    @Override
    public void func_70074_a(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof net.minecraft.entity.monster.ezey) {
            this.func_71029_a(sdqa._s);
        }
    }

    @Override
    public void func_70110_aj() {
        if (!this.field_71075_bZ._b) {
            super.func_70110_aj();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_70620_b(cvzo cvzo2, int n) {
        dwan dwan2 = super.func_70620_b(cvzo2, n);
        if (cvzo2._d == tgdv.field_77749_aR.field_77779_bT && this.field_71104_cf != null) {
            dwan2 = tgdv.field_77749_aR._a();
        } else {
            if (cvzo2._a().func_77623_v()) {
                return cvzo2._a().getIcon(cvzo2, n);
            }
            if (this.field_71074_e != null && cvzo2._d == tgdv.field_77707_k.field_77779_bT) {
                int n2 = cvzo2._n() - this.field_71072_f;
                if (n2 >= 18) {
                    return tgdv.field_77707_k._a(2);
                }
                if (n2 > 13) {
                    return tgdv.field_77707_k._a(1);
                }
                if (n2 > 0) {
                    return tgdv.field_77707_k._a(0);
                }
            }
            dwan2 = cvzo2._a().getIcon(cvzo2, n, this, this.field_71074_e, this.field_71072_f);
        }
        return dwan2;
    }

    public cvzo func_82169_q(int n) {
        return this.field_71071_by._e(n);
    }

    public void func_71023_q(int n) {
        this.func_85039_t(n);
        int n2 = Integer.MAX_VALUE - this.field_71067_cb;
        if (n > n2) {
            n = n2;
        }
        this.field_71106_cc += (float)n / (float)this.func_71050_bK();
        this.field_71067_cb += n;
        while (this.field_71106_cc >= 1.0f) {
            this.field_71106_cc = (this.field_71106_cc - 1.0f) * (float)this.func_71050_bK();
            this.func_82242_a(1);
            this.field_71106_cc /= (float)this.func_71050_bK();
        }
    }

    public void func_82242_a(int n) {
        this.field_71068_ca += n;
        if (this.field_71068_ca < 0) {
            this.field_71068_ca = 0;
            this.field_71106_cc = 0.0f;
            this.field_71067_cb = 0;
        }
        if (n > 0 && this.field_71068_ca % 5 == 0 && (float)this.field_82249_h < (float)this.field_70173_aa - 100.0f) {
            float f = this.field_71068_ca > 30 ? 1.0f : (float)this.field_71068_ca / 30.0f;
            this.field_70170_p.func_72956_a(this, "random.levelup", f * 0.75f, 1.0f);
            this.field_82249_h = this.field_70173_aa;
        }
    }

    public int func_71050_bK() {
        return this.field_71068_ca >= 30 ? 62 + (this.field_71068_ca - 30) * 7 : (this.field_71068_ca >= 15 ? 17 + (this.field_71068_ca - 15) * 3 : 17);
    }

    public void func_71020_j(float f) {
        if (!this.field_71075_bZ._a && !this.field_70170_p.field_72995_K) {
            this.field_71100_bB._a(f);
        }
    }

    public tdmn func_71024_bL() {
        return this.field_71100_bB;
    }

    public boolean func_71043_e(boolean bl) {
        return (bl || this.field_71100_bB._c()) && !this.field_71075_bZ._a;
    }

    public boolean func_70996_bM() {
        return this.func_110143_aJ() > 0.0f && this.func_110143_aJ() < this.func_110138_aP();
    }

    public void func_71008_a(cvzo cvzo2, int n) {
        if (cvzo2 != this.field_71074_e) {
            this.field_71074_e = cvzo2;
            this.field_71072_f = n;
            if (!this.field_70170_p.field_72995_K) {
                this.func_70019_c(true);
            }
        }
    }

    public boolean func_82246_f(int n, int n2, int n3) {
        if (GloomyHooks.cantDestroyBlock(this, n, n2, n3)) {
            return false;
        }
        if (this.field_71075_bZ._e) {
            return true;
        }
        int n4 = this.field_70170_p.func_72798_a(n, n2, n3);
        if (n4 > 0) {
            cvzo cvzo2;
            twgu twgu2 = twgu.field_71973_m[n4];
            if (twgu2.field_72018_cp._q()) {
                return true;
            }
            if (this.func_71045_bC() != null && ((cvzo2 = this.func_71045_bC())._b(twgu2) || cvzo2._a(twgu2) > 1.0f)) {
                return true;
            }
        }
        return false;
    }

    public boolean func_82247_a(int n, int n2, int n3, int n4, cvzo cvzo2) {
        return this.field_71075_bZ._e ? true : (cvzo2 != null ? cvzo2._z() : false);
    }

    @Override
    public int func_70693_a(EntityPlayer entityPlayer) {
        if (this.field_70170_p.func_82736_K()._b("keepInventory")) {
            return 0;
        }
        int n = this.field_71068_ca * 7;
        return n > 100 ? 100 : n;
    }

    @Override
    public boolean func_70684_aJ() {
        return true;
    }

    @Override
    public String func_70023_ak() {
        return this.field_71092_bJ;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_94059_bO() {
        return true;
    }

    public void func_71049_a(EntityPlayer entityPlayer, boolean bl) {
        if (bl) {
            this.field_71071_by._a(entityPlayer.field_71071_by);
            this.func_70606_j(entityPlayer.func_110143_aJ());
            this.field_71100_bB = entityPlayer.field_71100_bB;
            this.field_71068_ca = entityPlayer.field_71068_ca;
            this.field_71067_cb = entityPlayer.field_71067_cb;
            this.field_71106_cc = entityPlayer.field_71106_cc;
            this.func_85040_s(entityPlayer.func_71037_bA());
            this.field_82152_aq = entityPlayer.field_82152_aq;
        } else if (this.field_70170_p.func_82736_K()._b("keepInventory")) {
            this.field_71071_by._a(entityPlayer.field_71071_by);
            this.field_71068_ca = entityPlayer.field_71068_ca;
            this.field_71067_cb = entityPlayer.field_71067_cb;
            this.field_71106_cc = entityPlayer.field_71106_cc;
            this.func_85040_s(entityPlayer.func_71037_bA());
        }
        this.spawnChunkMap = entityPlayer.spawnChunkMap;
        this.spawnForcedMap = entityPlayer.spawnForcedMap;
        this.field_71078_a = entityPlayer.field_71078_a;
        qoac qoac2 = entityPlayer.getEntityData();
        if (qoac2._c(PERSISTED_NBT_TAG)) {
            this.getEntityData()._a(PERSISTED_NBT_TAG, qoac2._m(PERSISTED_NBT_TAG));
        }
    }

    @Override
    public boolean func_70041_e_() {
        return !this.field_71075_bZ._b;
    }

    public void func_71016_p() {
    }

    public void func_71033_a(xtby xtby2) {
    }

    @Override
    public String func_70005_c_() {
        return this.field_71092_bJ;
    }

    @Override
    public ozlu func_130014_f_() {
        return this.field_70170_p;
    }

    public tgfn func_71005_bN() {
        return this.field_71078_a;
    }

    @Override
    public cvzo func_71124_b(int n) {
        return n == 0 ? this.field_71071_by._a() : this.field_71071_by._b[n - 1];
    }

    @Override
    public cvzo func_70694_bm() {
        return this.field_71071_by._a();
    }

    @Override
    public void func_70062_b(int n, cvzo cvzo2) {
        if (n == 0) {
            this.field_71071_by._a[this.field_71071_by._c] = cvzo2;
        } else {
            this.field_71071_by._b[n - 1] = cvzo2;
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_98034_c(EntityPlayer entityPlayer) {
        if (!this.func_82150_aj()) {
            return false;
        }
        cwci cwci2 = this.func_96124_cp();
        return cwci2 == null || entityPlayer == null || entityPlayer.func_96124_cp() != cwci2 || !cwci2._g();
    }

    @Override
    public cvzo[] func_70035_c() {
        return this.field_71071_by._b;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_82238_cc() {
        return this.func_82241_s(1);
    }

    @Override
    public boolean func_96092_aw() {
        return !this.field_71075_bZ._b;
    }

    public fojy func_96123_co() {
        return this.field_70170_p.func_96441_U();
    }

    @Override
    public cwci func_96124_cp() {
        return this.func_96123_co()._g(this.field_71092_bJ);
    }

    @Override
    public String func_96090_ax() {
        return dzew._a(this.func_96124_cp(), this.getDisplayName());
    }

    @Override
    public void func_110149_m(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.func_70096_w()._b(17, Float.valueOf(f));
    }

    @Override
    public float func_110139_bj() {
        return this.func_70096_w()._d(17);
    }

    public void openGui(Object object, int n, ozlu ozlu2, int n2, int n3, int n4) {
        FMLNetworkHandler.openGui(this, object, n, ozlu2, n2, n3, n4);
    }

    public float getDefaultEyeHeight() {
        return 0.12f;
    }

    public String getDisplayName() {
        if (this.displayname == null) {
            this.displayname = ForgeEventFactory.getPlayerDisplayName(this, this.field_71092_bJ);
        }
        return this.displayname;
    }

    public void refreshDisplayName() {
        this.displayname = ForgeEventFactory.getPlayerDisplayName(this, this.field_71092_bJ);
    }
}

