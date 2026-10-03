/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.entity;

import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;
import api.player.client.IClientPlayerAPI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import java.util.Set;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.particle.EntityCrit2FX;
import net.minecraft.client.particle.EntityPickupFX;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.amww;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import net.minecraft.entity.player.ezey;
import net.minecraft.entity.player.pidb;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.sajz;
import net.minecraft.entity.ugqi;
import net.minecraft.util.dwan;
import net.minecraft.util.hank;
import net.minecraft.util.hanr;
import net.minecraft.util.jxtc;
import net.minecraft.util.kjwj;
import net.minecraft.util.sajh;
import net.minecraft.util.tdmn;
import net.minecraft.util.wmvj;
import net.minecraft.util.zwat;
import net.minecraft.util.zwaw;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;

@SideOnly(value=Side.CLIENT)
public class EntityPlayerSP
extends AbstractClientPlayer
implements IClientPlayerAPI {
    public kjwj field_71158_b;
    public xpzm field_71159_c;
    public int field_71156_d;
    public int field_71157_e;
    public float field_71154_f;
    public float field_71155_g;
    public float field_71163_h;
    public float field_71164_i;
    public int field_110320_a;
    public float field_110321_bQ;
    public wmvj field_71162_ch;
    public wmvj field_71160_ci;
    public wmvj field_71161_cj;
    public float field_71086_bY;
    public float field_71080_cy;
    private final ClientPlayerAPI clientPlayerAPI = ClientPlayerAPI.create(this);

    public EntityPlayerSP(xpzm xpzm2, ozlu ozlu2, hanr hanr2, int n) {
        super(ozlu2, hanr2._a());
        ClientPlayerAPI.beforeLocalConstructing(this, xpzm2, ozlu2, hanr2, n);
        this.field_71162_ch = new wmvj();
        this.field_71160_ci = new wmvj();
        this.field_71161_cj = new wmvj();
        this.field_71159_c = xpzm2;
        this.field_71093_bK = n;
        ClientPlayerAPI.afterLocalConstructing(this, xpzm2, ozlu2, hanr2, n);
    }

    @Override
    public final void localUpdateEntityActionState() {
        super.func_70626_be();
        this.field_70702_br = this.field_71158_b._a;
        this.field_70701_bs = this.field_71158_b._b;
        this.field_70703_bu = this.field_71158_b._c;
        this.field_71163_h = this.field_71154_f;
        this.field_71164_i = this.field_71155_g;
        this.field_71155_g = (float)((double)this.field_71155_g + (double)(this.field_70125_A - this.field_71155_g) * 0.5);
        this.field_71154_f = (float)((double)this.field_71154_f + (double)(this.field_70177_z - this.field_71154_f) * 0.5);
    }

    @Override
    public final void localOnLivingUpdate() {
        if (this.field_71157_e > 0) {
            --this.field_71157_e;
            if (this.field_71157_e == 0) {
                this.func_70031_b(false);
            }
        }
        if (this.field_71156_d > 0) {
            --this.field_71156_d;
        }
        if (this.field_71159_c._j._a()) {
            this.field_70161_v = 0.5;
            this.field_70165_t = 0.5;
            this.field_70165_t = 0.0;
            this.field_70161_v = 0.0;
            this.field_70177_z = (float)this.field_70173_aa / 12.0f;
            this.field_70125_A = 10.0f;
            this.field_70163_u = 68.5;
        } else {
            boolean bl;
            if (!this.field_71159_c._X._a(sdqa._f)) {
                this.field_71159_c._I._b(sdqa._f);
            }
            this.field_71080_cy = this.field_71086_bY;
            if (this.field_71087_bX) {
                if (this.field_71159_c._B != null) {
                    this.field_71159_c._a((gqjz)null);
                }
                if (this.field_71086_bY == 0.0f) {
                    this.field_71159_c._N._a("portal.trigger", 1.0f, this.field_70146_Z.nextFloat() * 0.4f + 0.8f);
                }
                this.field_71086_bY += 0.0125f;
                if (this.field_71086_bY >= 1.0f) {
                    this.field_71086_bY = 1.0f;
                }
                this.field_71087_bX = false;
            } else if (this.func_70644_a(hdpq._k) && this.func_70660_b(hdpq._k)._b() > 60) {
                this.field_71086_bY += 0.006666667f;
                if (this.field_71086_bY > 1.0f) {
                    this.field_71086_bY = 1.0f;
                }
            } else {
                if (this.field_71086_bY > 0.0f) {
                    this.field_71086_bY -= 0.05f;
                }
                if (this.field_71086_bY < 0.0f) {
                    this.field_71086_bY = 0.0f;
                }
            }
            if (this.field_71088_bW > 0) {
                --this.field_71088_bW;
            }
            boolean bl2 = this.field_71158_b._c;
            float f = 0.8f;
            boolean bl3 = this.field_71158_b._b >= f;
            this.field_71158_b._a();
            if (this.func_71039_bw() && !this.func_70115_ae()) {
                this.field_71158_b._a *= 0.2f;
                this.field_71158_b._b *= 0.2f;
                this.field_71156_d = 0;
            }
            if (this.field_71158_b._d && this.field_70139_V < 0.2f) {
                this.field_70139_V = 0.2f;
            }
            this.func_70048_i(this.field_70165_t - (double)this.field_70130_N * 0.35, this.field_70121_D._c + 0.5, this.field_70161_v + (double)this.field_70130_N * 0.35);
            this.func_70048_i(this.field_70165_t - (double)this.field_70130_N * 0.35, this.field_70121_D._c + 0.5, this.field_70161_v - (double)this.field_70130_N * 0.35);
            this.func_70048_i(this.field_70165_t + (double)this.field_70130_N * 0.35, this.field_70121_D._c + 0.5, this.field_70161_v - (double)this.field_70130_N * 0.35);
            this.func_70048_i(this.field_70165_t + (double)this.field_70130_N * 0.35, this.field_70121_D._c + 0.5, this.field_70161_v + (double)this.field_70130_N * 0.35);
            boolean bl4 = bl = (float)this.func_71024_bL()._a() > 6.0f || this.field_71075_bZ._c;
            if (this.field_70122_E && !bl3 && this.field_71158_b._b >= f && !this.func_70051_ag() && bl && !this.func_71039_bw() && !this.func_70644_a(hdpq._q)) {
                if (this.field_71156_d == 0) {
                    this.field_71156_d = 7;
                } else {
                    this.func_70031_b(true);
                    this.field_71156_d = 0;
                }
            }
            if (this.func_70093_af()) {
                this.field_71156_d = 0;
            }
            if (this.func_70051_ag() && (this.field_71158_b._b < f || this.field_70123_F || !bl)) {
                this.func_70031_b(false);
            }
            if (this.field_71075_bZ._c && !bl2 && this.field_71158_b._c) {
                if (this.field_71101_bC == 0) {
                    this.field_71101_bC = 7;
                } else {
                    this.field_71075_bZ._b = !this.field_71075_bZ._b;
                    this.func_71016_p();
                    this.field_71101_bC = 0;
                }
            }
            if (this.field_71075_bZ._b) {
                if (this.field_71158_b._d) {
                    this.field_70181_x -= 0.15;
                }
                if (this.field_71158_b._c) {
                    this.field_70181_x += 0.15;
                }
            }
            if (this.func_110317_t()) {
                if (this.field_110320_a < 0) {
                    ++this.field_110320_a;
                    if (this.field_110320_a == 0) {
                        this.field_110321_bQ = 0.0f;
                    }
                }
                if (bl2 && !this.field_71158_b._c) {
                    this.field_110320_a = -10;
                    this.func_110318_g();
                } else if (!bl2 && this.field_71158_b._c) {
                    this.field_110320_a = 0;
                    this.field_110321_bQ = 0.0f;
                } else if (bl2) {
                    ++this.field_110320_a;
                    this.field_110321_bQ = this.field_110320_a < 10 ? (float)this.field_110320_a * 0.1f : 0.8f + 2.0f / (float)(this.field_110320_a - 9) * 0.1f;
                }
            } else {
                this.field_110321_bQ = 0.0f;
            }
            super.func_70636_d();
            if (this.field_70122_E && this.field_71075_bZ._b) {
                this.field_71075_bZ._b = false;
                this.func_71016_p();
            }
        }
    }

    @Override
    public final float localGetFOVMultiplier() {
        float f = 1.0f;
        if (this.field_71075_bZ._b) {
            f *= 1.1f;
        }
        hubf hubf2 = this.func_110148_a(sajz._d);
        f = (float)((double)f * ((hubf2._e() / (double)this.field_71075_bZ._b() + 1.0) / 2.0));
        if (this.func_71039_bw() && this.func_71011_bu()._d == tgdv.field_77707_k.field_77779_bT) {
            int n = this.func_71057_bx();
            float f2 = (float)n / 20.0f;
            f2 = f2 > 1.0f ? 1.0f : (f2 *= f2);
            f *= 1.0f - f2 * 0.15f;
        }
        return ForgeHooksClient.getOffsetFOV(this, f);
    }

    @Override
    public final void localCloseScreen() {
        super.func_71053_j();
        this.field_71159_c._a((gqjz)null);
    }

    @Override
    public final void localDisplayGUIEditSign(hurg hurg2) {
        if (hurg2 instanceof jjza) {
            this.field_71159_c._a(new nvcq((jjza)hurg2));
        } else if (hurg2 instanceof oiid) {
            this.field_71159_c._a(new twlo((oiid)hurg2));
        }
    }

    @Override
    public void func_71048_c(cvzo cvzo2) {
        tgdv tgdv2 = cvzo2._a();
        if (tgdv2 == tgdv.field_77823_bG) {
            this.field_71159_c._a(new htmc(this, cvzo2, false));
        } else if (tgdv2 == tgdv.field_77821_bF) {
            this.field_71159_c._a(new htmc(this, cvzo2, true));
        }
    }

    @Override
    public final void localDisplayGUIChest(mssh mssh2) {
        this.field_71159_c._a(new hcly(this.field_71071_by, mssh2));
    }

    @Override
    public void func_94064_a(cffd cffd2) {
        this.field_71159_c._a(new iwmk(this.field_71071_by, cffd2));
    }

    @Override
    public void func_96125_a(EntityMinecartHopper entityMinecartHopper) {
        this.field_71159_c._a(new iwmk(this.field_71071_by, entityMinecartHopper));
    }

    @Override
    public void func_110298_a(EntityHorse entityHorse, mssh mssh2) {
        this.field_71159_c._a(new dhef(this.field_71071_by, mssh2, entityHorse));
    }

    @Override
    public final void localDisplayGUIWorkbench(int n, int n2, int n3) {
        this.field_71159_c._a(new htnm(this.field_71071_by, this.field_70170_p, n, n2, n3));
    }

    @Override
    public final void localDisplayGUIEnchantment(int n, int n2, int n3, String string) {
        this.field_71159_c._a(new vlqi(this.field_71071_by, this.field_70170_p, n, n2, n3, string));
    }

    @Override
    public void func_82244_d(int n, int n2, int n3) {
        this.field_71159_c._a(new pkdg(this.field_71071_by, this.field_70170_p, n, n2, n3));
    }

    @Override
    public final void localDisplayGUIFurnace(nwgz nwgz2) {
        this.field_71159_c._a(new iwtz(this.field_71071_by, nwgz2));
    }

    @Override
    public final void localDisplayGUIBrewingStand(nfbs nfbs2) {
        this.field_71159_c._a(new iwql(this.field_71071_by, nfbs2));
    }

    @Override
    public void func_82240_a(vmyb vmyb2) {
        this.field_71159_c._a(new tfow(this.field_71071_by, vmyb2));
    }

    @Override
    public final void localDisplayGUIDispenser(jjzo jjzo2) {
        this.field_71159_c._a(new aozb(this.field_71071_by, jjzo2));
    }

    @Override
    public void func_71030_a(amww amww2, String string) {
        this.field_71159_c._a(new xayk(this.field_71071_by, amww2, this.field_70170_p, string));
    }

    @Override
    public void func_71009_b(Entity entity) {
        this.field_71159_c._w._a(new EntityCrit2FX(this.field_71159_c._r, entity));
    }

    @Override
    public void func_71047_c(Entity entity) {
        EntityCrit2FX entityCrit2FX = new EntityCrit2FX(this.field_71159_c._r, entity, "magicCrit");
        this.field_71159_c._w._a(entityCrit2FX);
    }

    @Override
    public void func_71001_a(Entity entity, int n) {
        this.field_71159_c._w._a(new EntityPickupFX((ozlu)this.field_71159_c._r, entity, this, -0.5f));
    }

    @Override
    public final boolean localIsSneaking() {
        return this.field_71158_b._d && !this.field_71083_bS;
    }

    @Override
    public final void localSetPlayerSPHealth(float f) {
        float f2 = this.func_110143_aJ() - f;
        if (f2 <= 0.0f) {
            this.func_70606_j(f);
            if (f2 < 0.0f) {
                this.field_70172_ad = this.field_70771_an / 2;
            }
        } else {
            this.field_110153_bc = f2;
            this.func_70606_j(this.func_110143_aJ());
            this.field_70172_ad = this.field_70771_an;
            this.func_70665_d(jxtc.field_76377_j, f2);
            this.field_70738_aO = 10;
            this.field_70737_aN = 10;
        }
    }

    @Override
    public void func_71035_c(String string) {
        this.field_71159_c._J.func_73827_b()._a(string, new Object[0]);
    }

    @Override
    public final void localAddStat(rann rann2, int n) {
        if (rann2 != null) {
            if (rann2.func_75967_d()) {
                nfcl nfcl2 = (nfcl)rann2;
                if (nfcl2.field_75992_c == null || this.field_71159_c._X._a(nfcl2.field_75992_c)) {
                    if (!this.field_71159_c._X._a(nfcl2)) {
                        this.field_71159_c._I._a(nfcl2);
                    }
                    this.field_71159_c._X._a(rann2, n);
                }
            } else {
                this.field_71159_c._X._a(rann2, n);
            }
        }
    }

    public boolean func_71153_f(int n, int n2, int n3) {
        return this.field_70170_p.func_72809_s(n, n2, n3);
    }

    @Override
    public final boolean localPushOutOfBlocks(double d, double d2, double d3) {
        int n;
        if (this.field_70145_X) {
            return false;
        }
        int n2 = sajh._c(d);
        int n3 = sajh._c(d2);
        int n4 = sajh._c(d3);
        double d4 = d - (double)n2;
        double d5 = d3 - (double)n4;
        int n5 = Math.max(Math.round(this.field_70131_O), 1);
        boolean bl = true;
        for (n = 0; n < n5; ++n) {
            if (this.func_71153_f(n2, n3 + n, n4)) continue;
            bl = false;
        }
        if (bl) {
            int n6;
            n = 1;
            boolean bl2 = true;
            boolean bl3 = true;
            boolean bl4 = true;
            for (n6 = 0; n6 < n5; ++n6) {
                if (!this.func_71153_f(n2 - 1, n3 + n6, n4)) continue;
                n = 0;
                break;
            }
            for (n6 = 0; n6 < n5; ++n6) {
                if (!this.func_71153_f(n2 + 1, n3 + n6, n4)) continue;
                bl2 = false;
                break;
            }
            for (n6 = 0; n6 < n5; ++n6) {
                if (!this.func_71153_f(n2, n3 + n6, n4 - 1)) continue;
                bl3 = false;
                break;
            }
            for (n6 = 0; n6 < n5; ++n6) {
                if (!this.func_71153_f(n2, n3 + n6, n4 + 1)) continue;
                bl4 = false;
                break;
            }
            n6 = -1;
            double d6 = 9999.0;
            if (n != 0 && d4 < d6) {
                d6 = d4;
                n6 = 0;
            }
            if (bl2 && 1.0 - d4 < d6) {
                d6 = 1.0 - d4;
                n6 = 1;
            }
            if (bl3 && d5 < d6) {
                d6 = d5;
                n6 = 4;
            }
            if (bl4 && 1.0 - d5 < d6) {
                d6 = 1.0 - d5;
                n6 = 5;
            }
            float f = 0.1f;
            if (n6 == 0) {
                this.field_70159_w = -f;
            }
            if (n6 == 1) {
                this.field_70159_w = f;
            }
            if (n6 == 4) {
                this.field_70179_y = -f;
            }
            if (n6 == 5) {
                this.field_70179_y = f;
            }
        }
        return false;
    }

    @Override
    public void func_70031_b(boolean bl) {
        super.func_70031_b(bl);
        this.field_71157_e = bl ? 600 : 0;
    }

    public void func_71152_a(float f, int n, int n2) {
        this.field_71106_cc = f;
        this.field_71067_cb = n;
        this.field_71068_ca = n2;
    }

    @Override
    public void func_70006_a(zwat zwat2) {
        this.field_71159_c._J.func_73827_b()._a(zwat2._a(true));
    }

    @Override
    public boolean func_70003_b(int n, String string) {
        return n <= 0;
    }

    @Override
    public zwaw func_82114_b() {
        return new zwaw(sajh._c(this.field_70165_t + 0.5), sajh._c(this.field_70163_u + 0.5), sajh._c(this.field_70161_v + 0.5));
    }

    @Override
    public cvzo func_70694_bm() {
        return this.field_71071_by._a();
    }

    @Override
    public void func_85030_a(String string, float f, float f2) {
        PlaySoundAtEntityEvent playSoundAtEntityEvent = new PlaySoundAtEntityEvent(this, string, f, f2);
        if (MinecraftForge.EVENT_BUS.post(playSoundAtEntityEvent)) {
            return;
        }
        string = playSoundAtEntityEvent.name;
        this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u - (double)this.field_70129_M, this.field_70161_v, string, f, f2, false);
    }

    @Override
    public boolean func_70613_aW() {
        return true;
    }

    public boolean func_110317_t() {
        return this.field_70154_o != null && this.field_70154_o instanceof EntityHorse;
    }

    public float func_110319_bJ() {
        return this.field_110321_bQ;
    }

    public void func_110318_g() {
    }

    @Override
    public void func_71020_j(float f) {
        ClientPlayerAPI.addExhaustion(this, f);
    }

    @Override
    public final void realAddExhaustion(float f) {
        this.func_71020_j(f);
    }

    @Override
    public final void superAddExhaustion(float f) {
        super.func_71020_j(f);
    }

    @Override
    public final void localAddExhaustion(float f) {
        super.func_71020_j(f);
    }

    @Override
    public void func_71000_j(double d, double d2, double d3) {
        ClientPlayerAPI.addMovementStat(this, d, d2, d3);
    }

    @Override
    public final void realAddMovementStat(double d, double d2, double d3) {
        this.func_71000_j(d, d2, d3);
    }

    @Override
    public final void superAddMovementStat(double d, double d2, double d3) {
        super.func_71000_j(d, d2, d3);
    }

    @Override
    public final void localAddMovementStat(double d, double d2, double d3) {
        super.func_71000_j(d, d2, d3);
    }

    @Override
    public void func_71064_a(rann rann2, int n) {
        ClientPlayerAPI.addStat(this, rann2, n);
    }

    @Override
    public final void realAddStat(rann rann2, int n) {
        this.func_71064_a(rann2, n);
    }

    @Override
    public final void superAddStat(rann rann2, int n) {
        super.func_71064_a(rann2, n);
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        return ClientPlayerAPI.attackEntityFrom(this, jxtc2, f);
    }

    @Override
    public final boolean realAttackEntityFrom(jxtc jxtc2, float f) {
        return this.func_70097_a(jxtc2, f);
    }

    @Override
    public final boolean superAttackEntityFrom(jxtc jxtc2, float f) {
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public final boolean localAttackEntityFrom(jxtc jxtc2, float f) {
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public void func_71059_n(Entity entity) {
        ClientPlayerAPI.attackTargetEntityWithCurrentItem(this, entity);
    }

    @Override
    public final void realAttackTargetEntityWithCurrentItem(Entity entity) {
        this.func_71059_n(entity);
    }

    @Override
    public final void superAttackTargetEntityWithCurrentItem(Entity entity) {
        super.func_71059_n(entity);
    }

    @Override
    public final void localAttackTargetEntityWithCurrentItem(Entity entity) {
        super.func_71059_n(entity);
    }

    @Override
    public boolean func_70648_aU() {
        return ClientPlayerAPI.canBreatheUnderwater(this);
    }

    @Override
    public final boolean realCanBreatheUnderwater() {
        return this.func_70648_aU();
    }

    @Override
    public final boolean superCanBreatheUnderwater() {
        return super.func_70648_aU();
    }

    @Override
    public final boolean localCanBreatheUnderwater() {
        return super.func_70648_aU();
    }

    @Override
    public boolean func_71062_b(twgu twgu2) {
        return ClientPlayerAPI.canHarvestBlock(this, twgu2);
    }

    @Override
    public final boolean realCanHarvestBlock(twgu twgu2) {
        return this.func_71062_b(twgu2);
    }

    @Override
    public final boolean superCanHarvestBlock(twgu twgu2) {
        return super.func_71062_b(twgu2);
    }

    @Override
    public final boolean localCanHarvestBlock(twgu twgu2) {
        return super.func_71062_b(twgu2);
    }

    @Override
    public boolean func_82247_a(int n, int n2, int n3, int n4, cvzo cvzo2) {
        return ClientPlayerAPI.canPlayerEdit(this, n, n2, n3, n4, cvzo2);
    }

    @Override
    public final boolean realCanPlayerEdit(int n, int n2, int n3, int n4, cvzo cvzo2) {
        return this.func_82247_a(n, n2, n3, n4, cvzo2);
    }

    @Override
    public final boolean superCanPlayerEdit(int n, int n2, int n3, int n4, cvzo cvzo2) {
        return super.func_82247_a(n, n2, n3, n4, cvzo2);
    }

    @Override
    public final boolean localCanPlayerEdit(int n, int n2, int n3, int n4, cvzo cvzo2) {
        return super.func_82247_a(n, n2, n3, n4, cvzo2);
    }

    @Override
    public boolean func_70041_e_() {
        return ClientPlayerAPI.canTriggerWalking(this);
    }

    @Override
    public final boolean realCanTriggerWalking() {
        return this.func_70041_e_();
    }

    @Override
    public final boolean superCanTriggerWalking() {
        return super.func_70041_e_();
    }

    @Override
    public final boolean localCanTriggerWalking() {
        return super.func_70041_e_();
    }

    @Override
    public void func_71053_j() {
        ClientPlayerAPI.closeScreen(this);
    }

    @Override
    public final void realCloseScreen() {
        this.func_71053_j();
    }

    @Override
    public final void superCloseScreen() {
        super.func_71053_j();
    }

    @Override
    public void func_70665_d(jxtc jxtc2, float f) {
        ClientPlayerAPI.damageEntity(this, jxtc2, f);
    }

    @Override
    public final void realDamageEntity(jxtc jxtc2, float f) {
        this.func_70665_d(jxtc2, f);
    }

    @Override
    public final void superDamageEntity(jxtc jxtc2, float f) {
        super.func_70665_d(jxtc2, f);
    }

    @Override
    public final void localDamageEntity(jxtc jxtc2, float f) {
        super.func_70665_d(jxtc2, f);
    }

    @Override
    public void func_71017_a(nfbs nfbs2) {
        ClientPlayerAPI.displayGUIBrewingStand(this, nfbs2);
    }

    @Override
    public final void realDisplayGUIBrewingStand(nfbs nfbs2) {
        this.func_71017_a(nfbs2);
    }

    @Override
    public final void superDisplayGUIBrewingStand(nfbs nfbs2) {
        super.func_71017_a(nfbs2);
    }

    @Override
    public void func_71007_a(mssh mssh2) {
        ClientPlayerAPI.displayGUIChest(this, mssh2);
    }

    @Override
    public final void realDisplayGUIChest(mssh mssh2) {
        this.func_71007_a(mssh2);
    }

    @Override
    public final void superDisplayGUIChest(mssh mssh2) {
        super.func_71007_a(mssh2);
    }

    @Override
    public void func_71006_a(jjzo jjzo2) {
        ClientPlayerAPI.displayGUIDispenser(this, jjzo2);
    }

    @Override
    public final void realDisplayGUIDispenser(jjzo jjzo2) {
        this.func_71006_a(jjzo2);
    }

    @Override
    public final void superDisplayGUIDispenser(jjzo jjzo2) {
        super.func_71006_a(jjzo2);
    }

    @Override
    public void func_71014_a(hurg hurg2) {
        ClientPlayerAPI.displayGUIEditSign(this, hurg2);
    }

    @Override
    public final void realDisplayGUIEditSign(hurg hurg2) {
        this.func_71014_a(hurg2);
    }

    @Override
    public final void superDisplayGUIEditSign(hurg hurg2) {
        super.func_71014_a(hurg2);
    }

    @Override
    public void func_71002_c(int n, int n2, int n3, String string) {
        ClientPlayerAPI.displayGUIEnchantment(this, n, n2, n3, string);
    }

    @Override
    public final void realDisplayGUIEnchantment(int n, int n2, int n3, String string) {
        this.func_71002_c(n, n2, n3, string);
    }

    @Override
    public final void superDisplayGUIEnchantment(int n, int n2, int n3, String string) {
        super.func_71002_c(n, n2, n3, string);
    }

    @Override
    public void func_71042_a(nwgz nwgz2) {
        ClientPlayerAPI.displayGUIFurnace(this, nwgz2);
    }

    @Override
    public final void realDisplayGUIFurnace(nwgz nwgz2) {
        this.func_71042_a(nwgz2);
    }

    @Override
    public final void superDisplayGUIFurnace(nwgz nwgz2) {
        super.func_71042_a(nwgz2);
    }

    @Override
    public void func_71058_b(int n, int n2, int n3) {
        ClientPlayerAPI.displayGUIWorkbench(this, n, n2, n3);
    }

    @Override
    public final void realDisplayGUIWorkbench(int n, int n2, int n3) {
        this.func_71058_b(n, n2, n3);
    }

    @Override
    public final void superDisplayGUIWorkbench(int n, int n2, int n3) {
        super.func_71058_b(n, n2, n3);
    }

    @Override
    public EntityItem func_71040_bB(boolean bl) {
        return ClientPlayerAPI.dropOneItem(this, bl);
    }

    @Override
    public final EntityItem realDropOneItem(boolean bl) {
        return this.func_71040_bB(bl);
    }

    @Override
    public final EntityItem superDropOneItem(boolean bl) {
        return super.func_71040_bB(bl);
    }

    @Override
    public final EntityItem localDropOneItem(boolean bl) {
        return super.func_71040_bB(bl);
    }

    @Override
    public EntityItem func_71021_b(cvzo cvzo2) {
        return ClientPlayerAPI.dropPlayerItem(this, cvzo2);
    }

    @Override
    public final EntityItem realDropPlayerItem(cvzo cvzo2) {
        return this.func_71021_b(cvzo2);
    }

    @Override
    public final EntityItem superDropPlayerItem(cvzo cvzo2) {
        return super.func_71021_b(cvzo2);
    }

    @Override
    public final EntityItem localDropPlayerItem(cvzo cvzo2) {
        return super.func_71021_b(cvzo2);
    }

    @Override
    public EntityItem func_71019_a(cvzo cvzo2, boolean bl) {
        return ClientPlayerAPI.dropPlayerItemWithRandomChoice(this, cvzo2, bl);
    }

    @Override
    public final EntityItem realDropPlayerItemWithRandomChoice(cvzo cvzo2, boolean bl) {
        return this.func_71019_a(cvzo2, bl);
    }

    @Override
    public final EntityItem superDropPlayerItemWithRandomChoice(cvzo cvzo2, boolean bl) {
        return super.func_71019_a(cvzo2, bl);
    }

    @Override
    public final EntityItem localDropPlayerItemWithRandomChoice(cvzo cvzo2, boolean bl) {
        return super.func_71019_a(cvzo2, bl);
    }

    @Override
    public void func_70069_a(float f) {
        ClientPlayerAPI.fall(this, f);
    }

    @Override
    public final void realFall(float f) {
        this.func_70069_a(f);
    }

    @Override
    public final void superFall(float f) {
        super.func_70069_a(f);
    }

    @Override
    public final void localFall(float f) {
        super.func_70069_a(f);
    }

    @Override
    public float func_70013_c(float f) {
        return ClientPlayerAPI.getBrightness(this, f);
    }

    @Override
    public final float realGetBrightness(float f) {
        return this.func_70013_c(f);
    }

    @Override
    public final float superGetBrightness(float f) {
        return super.func_70013_c(f);
    }

    @Override
    public final float localGetBrightness(float f) {
        return super.func_70013_c(f);
    }

    @Override
    public int func_70070_b(float f) {
        return ClientPlayerAPI.getBrightnessForRender(this, f);
    }

    @Override
    public final int realGetBrightnessForRender(float f) {
        return this.func_70070_b(f);
    }

    @Override
    public final int superGetBrightnessForRender(float f) {
        return super.func_70070_b(f);
    }

    @Override
    public final int localGetBrightnessForRender(float f) {
        return super.func_70070_b(f);
    }

    @Override
    public float func_71055_a(twgu twgu2, boolean bl) {
        return ClientPlayerAPI.getCurrentPlayerStrVsBlock(this, twgu2, bl);
    }

    @Override
    public final float realGetCurrentPlayerStrVsBlock(twgu twgu2, boolean bl) {
        return this.func_71055_a(twgu2, bl);
    }

    @Override
    public final float superGetCurrentPlayerStrVsBlock(twgu twgu2, boolean bl) {
        return super.func_71055_a(twgu2, bl);
    }

    @Override
    public final float localGetCurrentPlayerStrVsBlock(twgu twgu2, boolean bl) {
        return super.func_71055_a(twgu2, bl);
    }

    @Override
    public float getCurrentPlayerStrVsBlock(twgu twgu2, boolean bl, int n) {
        return ClientPlayerAPI.getCurrentPlayerStrVsBlockForge(this, twgu2, bl, n);
    }

    @Override
    public final float realGetCurrentPlayerStrVsBlockForge(twgu twgu2, boolean bl, int n) {
        return this.getCurrentPlayerStrVsBlock(twgu2, bl, n);
    }

    @Override
    public final float superGetCurrentPlayerStrVsBlockForge(twgu twgu2, boolean bl, int n) {
        return super.getCurrentPlayerStrVsBlock(twgu2, bl, n);
    }

    @Override
    public final float localGetCurrentPlayerStrVsBlockForge(twgu twgu2, boolean bl, int n) {
        return super.getCurrentPlayerStrVsBlock(twgu2, bl, n);
    }

    @Override
    public double func_70092_e(double d, double d2, double d3) {
        return ClientPlayerAPI.getDistanceSq(this, d, d2, d3);
    }

    @Override
    public final double realGetDistanceSq(double d, double d2, double d3) {
        return this.func_70092_e(d, d2, d3);
    }

    @Override
    public final double superGetDistanceSq(double d, double d2, double d3) {
        return super.func_70092_e(d, d2, d3);
    }

    @Override
    public final double localGetDistanceSq(double d, double d2, double d3) {
        return super.func_70092_e(d, d2, d3);
    }

    @Override
    public double func_70068_e(Entity entity) {
        return ClientPlayerAPI.getDistanceSqToEntity(this, entity);
    }

    @Override
    public final double realGetDistanceSqToEntity(Entity entity) {
        return this.func_70068_e(entity);
    }

    @Override
    public final double superGetDistanceSqToEntity(Entity entity) {
        return super.func_70068_e(entity);
    }

    @Override
    public final double localGetDistanceSqToEntity(Entity entity) {
        return super.func_70068_e(entity);
    }

    public float func_71151_f() {
        return ClientPlayerAPI.getFOVMultiplier(this);
    }

    @Override
    public final float realGetFOVMultiplier() {
        return this.func_71151_f();
    }

    public final float superGetFOVMultiplier() {
        return super.t();
    }

    @Override
    public String func_70621_aR() {
        return ClientPlayerAPI.getHurtSound(this);
    }

    @Override
    public final String realGetHurtSound() {
        return this.func_70621_aR();
    }

    @Override
    public final String superGetHurtSound() {
        return super.func_70621_aR();
    }

    @Override
    public final String localGetHurtSound() {
        return super.func_70621_aR();
    }

    @Override
    public dwan func_70620_b(cvzo cvzo2, int n) {
        return ClientPlayerAPI.getItemIcon(this, cvzo2, n);
    }

    @Override
    public final dwan realGetItemIcon(cvzo cvzo2, int n) {
        return this.func_70620_b(cvzo2, n);
    }

    @Override
    public final dwan superGetItemIcon(cvzo cvzo2, int n) {
        return super.func_70620_b(cvzo2, n);
    }

    @Override
    public final dwan localGetItemIcon(cvzo cvzo2, int n) {
        return super.func_70620_b(cvzo2, n);
    }

    @Override
    public int func_71060_bI() {
        return ClientPlayerAPI.getSleepTimer(this);
    }

    @Override
    public final int realGetSleepTimer() {
        return this.func_71060_bI();
    }

    @Override
    public final int superGetSleepTimer() {
        return super.func_71060_bI();
    }

    @Override
    public final int localGetSleepTimer() {
        return super.func_71060_bI();
    }

    @Override
    public boolean func_70058_J() {
        return ClientPlayerAPI.handleLavaMovement(this);
    }

    @Override
    public final boolean realHandleLavaMovement() {
        return this.func_70058_J();
    }

    @Override
    public final boolean superHandleLavaMovement() {
        return super.func_70058_J();
    }

    @Override
    public final boolean localHandleLavaMovement() {
        return super.func_70058_J();
    }

    @Override
    public boolean func_70072_I() {
        return ClientPlayerAPI.handleWaterMovement(this);
    }

    @Override
    public final boolean realHandleWaterMovement() {
        return this.func_70072_I();
    }

    @Override
    public final boolean superHandleWaterMovement() {
        return super.func_70072_I();
    }

    @Override
    public final boolean localHandleWaterMovement() {
        return super.func_70072_I();
    }

    @Override
    public void func_70691_i(float f) {
        ClientPlayerAPI.heal(this, f);
    }

    @Override
    public final void realHeal(float f) {
        this.func_70691_i(f);
    }

    @Override
    public final void superHeal(float f) {
        super.func_70691_i(f);
    }

    @Override
    public final void localHeal(float f) {
        super.func_70691_i(f);
    }

    @Override
    public boolean func_70094_T() {
        return ClientPlayerAPI.isEntityInsideOpaqueBlock(this);
    }

    @Override
    public final boolean realIsEntityInsideOpaqueBlock() {
        return this.func_70094_T();
    }

    @Override
    public final boolean superIsEntityInsideOpaqueBlock() {
        return super.func_70094_T();
    }

    @Override
    public final boolean localIsEntityInsideOpaqueBlock() {
        return super.func_70094_T();
    }

    @Override
    public boolean func_70090_H() {
        return ClientPlayerAPI.isInWater(this);
    }

    @Override
    public final boolean realIsInWater() {
        return this.func_70090_H();
    }

    @Override
    public final boolean superIsInWater() {
        return super.func_70090_H();
    }

    @Override
    public final boolean localIsInWater() {
        return super.func_70090_H();
    }

    @Override
    public boolean func_70055_a(tflj tflj2) {
        return ClientPlayerAPI.isInsideOfMaterial(this, tflj2);
    }

    @Override
    public final boolean realIsInsideOfMaterial(tflj tflj2) {
        return this.func_70055_a(tflj2);
    }

    @Override
    public final boolean superIsInsideOfMaterial(tflj tflj2) {
        return super.func_70055_a(tflj2);
    }

    @Override
    public final boolean localIsInsideOfMaterial(tflj tflj2) {
        return super.func_70055_a(tflj2);
    }

    @Override
    public boolean func_70617_f_() {
        return ClientPlayerAPI.isOnLadder(this);
    }

    @Override
    public final boolean realIsOnLadder() {
        return this.func_70617_f_();
    }

    @Override
    public final boolean superIsOnLadder() {
        return super.func_70617_f_();
    }

    @Override
    public final boolean localIsOnLadder() {
        return super.func_70617_f_();
    }

    @Override
    public boolean func_70608_bn() {
        return ClientPlayerAPI.isPlayerSleeping(this);
    }

    @Override
    public final boolean realIsPlayerSleeping() {
        return this.func_70608_bn();
    }

    @Override
    public final boolean superIsPlayerSleeping() {
        return super.func_70608_bn();
    }

    @Override
    public final boolean localIsPlayerSleeping() {
        return super.func_70608_bn();
    }

    @Override
    public boolean func_70093_af() {
        return ClientPlayerAPI.isSneaking(this);
    }

    @Override
    public final boolean realIsSneaking() {
        return this.func_70093_af();
    }

    @Override
    public final boolean superIsSneaking() {
        return super.func_70093_af();
    }

    @Override
    public boolean func_70051_ag() {
        return ClientPlayerAPI.isSprinting(this);
    }

    @Override
    public final boolean realIsSprinting() {
        return this.func_70051_ag();
    }

    @Override
    public final boolean superIsSprinting() {
        return super.func_70051_ag();
    }

    @Override
    public final boolean localIsSprinting() {
        return super.func_70051_ag();
    }

    @Override
    public void func_70664_aZ() {
        ClientPlayerAPI.jump(this);
    }

    @Override
    public final void realJump() {
        this.func_70664_aZ();
    }

    @Override
    public final void superJump() {
        super.func_70664_aZ();
    }

    @Override
    public final void localJump() {
        super.func_70664_aZ();
    }

    @Override
    public void func_70653_a(Entity entity, float f, double d, double d2) {
        ClientPlayerAPI.knockBack(this, entity, f, d, d2);
    }

    @Override
    public final void realKnockBack(Entity entity, float f, double d, double d2) {
        this.func_70653_a(entity, f, d, d2);
    }

    @Override
    public final void superKnockBack(Entity entity, float f, double d, double d2) {
        super.func_70653_a(entity, f, d, d2);
    }

    @Override
    public final void localKnockBack(Entity entity, float f, double d, double d2) {
        super.func_70653_a(entity, f, d, d2);
    }

    @Override
    public void func_70091_d(double d, double d2, double d3) {
        ClientPlayerAPI.moveEntity(this, d, d2, d3);
    }

    @Override
    public final void realMoveEntity(double d, double d2, double d3) {
        this.func_70091_d(d, d2, d3);
    }

    @Override
    public final void superMoveEntity(double d, double d2, double d3) {
        super.func_70091_d(d, d2, d3);
    }

    @Override
    public final void localMoveEntity(double d, double d2, double d3) {
        super.func_70091_d(d, d2, d3);
    }

    @Override
    public void func_70612_e(float f, float f2) {
        ClientPlayerAPI.moveEntityWithHeading(this, f, f2);
    }

    @Override
    public final void realMoveEntityWithHeading(float f, float f2) {
        this.func_70612_e(f, f2);
    }

    @Override
    public final void superMoveEntityWithHeading(float f, float f2) {
        super.func_70612_e(f, f2);
    }

    @Override
    public final void localMoveEntityWithHeading(float f, float f2) {
        super.func_70612_e(f, f2);
    }

    @Override
    public void func_70060_a(float f, float f2, float f3) {
        ClientPlayerAPI.moveFlying(this, f, f2, f3);
    }

    @Override
    public final void realMoveFlying(float f, float f2, float f3) {
        this.func_70060_a(f, f2, f3);
    }

    @Override
    public final void superMoveFlying(float f, float f2, float f3) {
        super.func_70060_a(f, f2, f3);
    }

    @Override
    public final void localMoveFlying(float f, float f2, float f3) {
        super.func_70060_a(f, f2, f3);
    }

    @Override
    public void func_70645_a(jxtc jxtc2) {
        ClientPlayerAPI.onDeath(this, jxtc2);
    }

    @Override
    public final void realOnDeath(jxtc jxtc2) {
        this.func_70645_a(jxtc2);
    }

    @Override
    public final void superOnDeath(jxtc jxtc2) {
        super.func_70645_a(jxtc2);
    }

    @Override
    public final void localOnDeath(jxtc jxtc2) {
        super.func_70645_a(jxtc2);
    }

    @Override
    public void func_70636_d() {
        ClientPlayerAPI.onLivingUpdate(this);
    }

    @Override
    public final void realOnLivingUpdate() {
        this.func_70636_d();
    }

    @Override
    public final void superOnLivingUpdate() {
        super.func_70636_d();
    }

    @Override
    public void func_70074_a(EntityLivingBase entityLivingBase) {
        ClientPlayerAPI.onKillEntity(this, entityLivingBase);
    }

    @Override
    public final void realOnKillEntity(EntityLivingBase entityLivingBase) {
        this.func_70074_a(entityLivingBase);
    }

    @Override
    public final void superOnKillEntity(EntityLivingBase entityLivingBase) {
        super.func_70074_a(entityLivingBase);
    }

    @Override
    public final void localOnKillEntity(EntityLivingBase entityLivingBase) {
        super.func_70074_a(entityLivingBase);
    }

    @Override
    public void func_70077_a(EntityLightningBolt entityLightningBolt) {
        ClientPlayerAPI.onStruckByLightning(this, entityLightningBolt);
    }

    @Override
    public final void realOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
        this.func_70077_a(entityLightningBolt);
    }

    @Override
    public final void superOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
        super.func_70077_a(entityLightningBolt);
    }

    @Override
    public final void localOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
        super.func_70077_a(entityLightningBolt);
    }

    @Override
    public void func_70071_h_() {
        ClientPlayerAPI.onUpdate(this);
    }

    @Override
    public final void realOnUpdate() {
        this.func_70071_h_();
    }

    @Override
    public final void superOnUpdate() {
        super.func_70071_h_();
    }

    @Override
    public final void localOnUpdate() {
        super.func_70071_h_();
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        ClientPlayerAPI.playStepSound(this, n, n2, n3, n4);
    }

    @Override
    public final void realPlayStepSound(int n, int n2, int n3, int n4) {
        this.func_70036_a(n, n2, n3, n4);
    }

    @Override
    public final void superPlayStepSound(int n, int n2, int n3, int n4) {
        super.func_70036_a(n, n2, n3, n4);
    }

    @Override
    public final void localPlayStepSound(int n, int n2, int n3, int n4) {
        super.func_70036_a(n, n2, n3, n4);
    }

    @Override
    public boolean func_70048_i(double d, double d2, double d3) {
        return ClientPlayerAPI.pushOutOfBlocks(this, d, d2, d3);
    }

    @Override
    public final boolean realPushOutOfBlocks(double d, double d2, double d3) {
        return this.func_70048_i(d, d2, d3);
    }

    @Override
    public final boolean superPushOutOfBlocks(double d, double d2, double d3) {
        return super.func_70048_i(d, d2, d3);
    }

    @Override
    public hank func_70614_a(double d, float f) {
        return ClientPlayerAPI.rayTrace(this, d, f);
    }

    @Override
    public final hank realRayTrace(double d, float f) {
        return this.func_70614_a(d, f);
    }

    @Override
    public final hank superRayTrace(double d, float f) {
        return super.func_70614_a(d, f);
    }

    @Override
    public final hank localRayTrace(double d, float f) {
        return super.func_70614_a(d, f);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        ClientPlayerAPI.readEntityFromNBT(this, qoac2);
    }

    @Override
    public final void realReadEntityFromNBT(qoac qoac2) {
        this.func_70037_a(qoac2);
    }

    @Override
    public final void superReadEntityFromNBT(qoac qoac2) {
        super.func_70037_a(qoac2);
    }

    @Override
    public final void localReadEntityFromNBT(qoac qoac2) {
        super.func_70037_a(qoac2);
    }

    @Override
    public void func_71004_bE() {
        ClientPlayerAPI.respawnPlayer(this);
    }

    @Override
    public final void realRespawnPlayer() {
        this.func_71004_bE();
    }

    @Override
    public final void superRespawnPlayer() {
        super.func_71004_bE();
    }

    @Override
    public final void localRespawnPlayer() {
        super.func_71004_bE();
    }

    @Override
    public void func_70106_y() {
        ClientPlayerAPI.setDead(this);
    }

    @Override
    public final void realSetDead() {
        this.func_70106_y();
    }

    @Override
    public final void superSetDead() {
        super.func_70106_y();
    }

    @Override
    public final void localSetDead() {
        super.func_70106_y();
    }

    public void func_71150_b(float f) {
        ClientPlayerAPI.setPlayerSPHealth(this, f);
    }

    @Override
    public final void realSetPlayerSPHealth(float f) {
        this.func_71150_b(f);
    }

    public final void superSetPlayerSPHealth(float f) {
        super.n(f);
    }

    @Override
    public void func_70080_a(double d, double d2, double d3, float f, float f2) {
        ClientPlayerAPI.setPositionAndRotation(this, d, d2, d3, f, f2);
    }

    @Override
    public final void realSetPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        this.func_70080_a(d, d2, d3, f, f2);
    }

    @Override
    public final void superSetPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        super.func_70080_a(d, d2, d3, f, f2);
    }

    @Override
    public final void localSetPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        super.func_70080_a(d, d2, d3, f, f2);
    }

    @Override
    public pidb func_71018_a(int n, int n2, int n3) {
        return ClientPlayerAPI.sleepInBedAt(this, n, n2, n3);
    }

    @Override
    public final pidb realSleepInBedAt(int n, int n2, int n3) {
        return this.func_71018_a(n, n2, n3);
    }

    @Override
    public final pidb superSleepInBedAt(int n, int n2, int n3) {
        return super.func_71018_a(n, n2, n3);
    }

    @Override
    public final pidb localSleepInBedAt(int n, int n2, int n3) {
        return super.func_71018_a(n, n2, n3);
    }

    @Override
    public void func_71038_i() {
        ClientPlayerAPI.swingItem(this);
    }

    @Override
    public final void realSwingItem() {
        this.func_71038_i();
    }

    @Override
    public final void superSwingItem() {
        super.func_71038_i();
    }

    @Override
    public final void localSwingItem() {
        super.func_71038_i();
    }

    @Override
    public void func_70626_be() {
        ClientPlayerAPI.updateEntityActionState(this);
    }

    @Override
    public final void realUpdateEntityActionState() {
        this.func_70626_be();
    }

    @Override
    public final void superUpdateEntityActionState() {
        super.func_70626_be();
    }

    @Override
    public void func_70098_U() {
        ClientPlayerAPI.updateRidden(this);
    }

    @Override
    public final void realUpdateRidden() {
        this.func_70098_U();
    }

    @Override
    public final void superUpdateRidden() {
        super.func_70098_U();
    }

    @Override
    public final void localUpdateRidden() {
        super.func_70098_U();
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        ClientPlayerAPI.writeEntityToNBT(this, qoac2);
    }

    @Override
    public final void realWriteEntityToNBT(qoac qoac2) {
        this.func_70014_b(qoac2);
    }

    @Override
    public final void superWriteEntityToNBT(qoac qoac2) {
        super.func_70014_b(qoac2);
    }

    @Override
    public final void localWriteEntityToNBT(qoac qoac2) {
        super.func_70014_b(qoac2);
    }

    @Override
    public final boolean getAddedToChunkField() {
        return this.field_70175_ag;
    }

    @Override
    public final void setAddedToChunkField(boolean bl) {
        this.field_70175_ag = bl;
    }

    @Override
    public final int getArrowHitTimerField() {
        return this.field_70720_be;
    }

    @Override
    public final void setArrowHitTimerField(int n) {
        this.field_70720_be = n;
    }

    @Override
    public final int getAttackTimeField() {
        return this.field_70724_aR;
    }

    @Override
    public final void setAttackTimeField(int n) {
        this.field_70724_aR = n;
    }

    @Override
    public final float getAttackedAtYawField() {
        return this.field_70739_aP;
    }

    @Override
    public final void setAttackedAtYawField(float f) {
        this.field_70739_aP = f;
    }

    @Override
    public final EntityPlayer getAttackingPlayerField() {
        return this.field_70717_bb;
    }

    @Override
    public final void setAttackingPlayerField(EntityPlayer entityPlayer) {
        this.field_70717_bb = entityPlayer;
    }

    @Override
    public final net.minecraft.util.eidj getBoundingBoxField() {
        return this.field_70121_D;
    }

    @Override
    public final float getCameraPitchField() {
        return this.field_70726_aT;
    }

    @Override
    public final void setCameraPitchField(float f) {
        this.field_70726_aT = f;
    }

    @Override
    public final float getCameraYawField() {
        return this.field_71109_bG;
    }

    @Override
    public final void setCameraYawField(float f) {
        this.field_71109_bG = f;
    }

    @Override
    public final ezey getCapabilitiesField() {
        return this.field_71075_bZ;
    }

    @Override
    public final void setCapabilitiesField(ezey ezey2) {
        this.field_71075_bZ = ezey2;
    }

    @Override
    public final int getChunkCoordXField() {
        return this.field_70176_ah;
    }

    @Override
    public final void setChunkCoordXField(int n) {
        this.field_70176_ah = n;
    }

    @Override
    public final int getChunkCoordYField() {
        return this.field_70162_ai;
    }

    @Override
    public final void setChunkCoordYField(int n) {
        this.field_70162_ai = n;
    }

    @Override
    public final int getChunkCoordZField() {
        return this.field_70164_aj;
    }

    @Override
    public final void setChunkCoordZField(int n) {
        this.field_70164_aj = n;
    }

    @Override
    public final net.minecraft.entity.ezey getDataWatcherField() {
        return this.field_70180_af;
    }

    @Override
    public final void setDataWatcherField(net.minecraft.entity.ezey ezey2) {
        this.field_70180_af = ezey2;
    }

    @Override
    public final boolean getDeadField() {
        return this.field_70729_aU;
    }

    @Override
    public final void setDeadField(boolean bl) {
        this.field_70729_aU = bl;
    }

    @Override
    public final int getDeathTimeField() {
        return this.field_70725_aQ;
    }

    @Override
    public final void setDeathTimeField(int n) {
        this.field_70725_aQ = n;
    }

    @Override
    public final int getDimensionField() {
        return this.field_71093_bK;
    }

    @Override
    public final void setDimensionField(int n) {
        this.field_71093_bK = n;
    }

    @Override
    public final float getDistanceWalkedModifiedField() {
        return this.field_70140_Q;
    }

    @Override
    public final void setDistanceWalkedModifiedField(float f) {
        this.field_70140_Q = f;
    }

    @Override
    public final float getDistanceWalkedOnStepModifiedField() {
        return this.field_82151_R;
    }

    @Override
    public final void setDistanceWalkedOnStepModifiedField(float f) {
        this.field_82151_R = f;
    }

    @Override
    public final int getEntityAgeField() {
        return this.field_70708_bq;
    }

    @Override
    public final void setEntityAgeField(int n) {
        this.field_70708_bq = n;
    }

    @Override
    public final float getEntityCollisionReductionField() {
        return this.field_70144_Y;
    }

    @Override
    public final void setEntityCollisionReductionField(float f) {
        this.field_70144_Y = f;
    }

    @Override
    public final int getEntityIdField() {
        return this.field_70157_k;
    }

    @Override
    public final void setEntityIdField(int n) {
        this.field_70157_k = n;
    }

    @Override
    public final float getExperienceField() {
        return this.field_71106_cc;
    }

    @Override
    public final void setExperienceField(float f) {
        this.field_71106_cc = f;
    }

    @Override
    public final int getExperienceLevelField() {
        return this.field_71068_ca;
    }

    @Override
    public final void setExperienceLevelField(int n) {
        this.field_71068_ca = n;
    }

    @Override
    public final int getExperienceTotalField() {
        return this.field_71067_cb;
    }

    @Override
    public final void setExperienceTotalField(int n) {
        this.field_71067_cb = n;
    }

    @Override
    public final float getFallDistanceField() {
        return this.field_70143_R;
    }

    @Override
    public final void setFallDistanceField(float f) {
        this.field_70143_R = f;
    }

    @Override
    public final float getField_110154_aXField() {
        return this.field_110154_aX;
    }

    @Override
    public final void setField_110154_aXField(float f) {
        this.field_110154_aX = f;
    }

    @Override
    public final boolean getField_70135_KField() {
        return this.field_70135_K;
    }

    @Override
    public final void setField_70135_KField(boolean bl) {
        this.field_70135_K = bl;
    }

    @Override
    public final float getField_70741_aBField() {
        return this.field_70741_aB;
    }

    @Override
    public final void setField_70741_aBField(float f) {
        this.field_70741_aB = f;
    }

    @Override
    public final float getField_70763_axField() {
        return this.field_70763_ax;
    }

    @Override
    public final void setField_70763_axField(float f) {
        this.field_70763_ax = f;
    }

    @Override
    public final float getField_70764_awField() {
        return this.field_70764_aw;
    }

    @Override
    public final void setField_70764_awField(float f) {
        this.field_70764_aw = f;
    }

    @Override
    public final float getField_70768_auField() {
        return this.field_70768_au;
    }

    @Override
    public final void setField_70768_auField(float f) {
        this.field_70768_au = f;
    }

    @Override
    public final float getField_70769_aoField() {
        return this.field_70769_ao;
    }

    @Override
    public final void setField_70769_aoField(float f) {
        this.field_70769_ao = f;
    }

    @Override
    public final float getField_70770_apField() {
        return this.field_70770_ap;
    }

    @Override
    public final void setField_70770_apField(float f) {
        this.field_70770_ap = f;
    }

    @Override
    public final float getField_71079_bUField() {
        return this.field_71079_bU;
    }

    @Override
    public final void setField_71079_bUField(float f) {
        this.field_71079_bU = f;
    }

    @Override
    public final float getField_71082_cxField() {
        return this.field_71082_cx;
    }

    @Override
    public final void setField_71082_cxField(float f) {
        this.field_71082_cx = f;
    }

    @Override
    public final double getField_71085_bRField() {
        return this.field_71085_bR;
    }

    @Override
    public final void setField_71085_bRField(double d) {
        this.field_71085_bR = d;
    }

    @Override
    public final float getField_71089_bVField() {
        return this.field_71089_bV;
    }

    @Override
    public final void setField_71089_bVField(float f) {
        this.field_71089_bV = f;
    }

    @Override
    public final double getField_71091_bMField() {
        return this.field_71091_bM;
    }

    @Override
    public final void setField_71091_bMField(double d) {
        this.field_71091_bM = d;
    }

    @Override
    public final double getField_71094_bPField() {
        return this.field_71094_bP;
    }

    @Override
    public final void setField_71094_bPField(double d) {
        this.field_71094_bP = d;
    }

    @Override
    public final double getField_71095_bQField() {
        return this.field_71095_bQ;
    }

    @Override
    public final void setField_71095_bQField(double d) {
        this.field_71095_bQ = d;
    }

    @Override
    public final double getField_71096_bNField() {
        return this.field_71096_bN;
    }

    @Override
    public final void setField_71096_bNField(double d) {
        this.field_71096_bN = d;
    }

    @Override
    public final double getField_71097_bOField() {
        return this.field_71097_bO;
    }

    @Override
    public final void setField_71097_bOField(double d) {
        this.field_71097_bO = d;
    }

    @Override
    public final wmvj getField_71160_ciField() {
        return this.field_71160_ci;
    }

    @Override
    public final void setField_71160_ciField(wmvj wmvj2) {
        this.field_71160_ci = wmvj2;
    }

    @Override
    public final wmvj getField_71161_cjField() {
        return this.field_71161_cj;
    }

    @Override
    public final void setField_71161_cjField(wmvj wmvj2) {
        this.field_71161_cj = wmvj2;
    }

    @Override
    public final wmvj getField_71162_chField() {
        return this.field_71162_ch;
    }

    @Override
    public final void setField_71162_chField(wmvj wmvj2) {
        this.field_71162_ch = wmvj2;
    }

    @Override
    public final int getFireResistanceField() {
        return this.field_70174_ab;
    }

    @Override
    public final void setFireResistanceField(int n) {
        this.field_70174_ab = n;
    }

    @Override
    public final EntityFishHook getFishEntityField() {
        return this.field_71104_cf;
    }

    @Override
    public final void setFishEntityField(EntityFishHook entityFishHook) {
        this.field_71104_cf = entityFishHook;
    }

    @Override
    public final int getFlyToggleTimerField() {
        return this.field_71101_bC;
    }

    @Override
    public final void setFlyToggleTimerField(int n) {
        this.field_71101_bC = n;
    }

    @Override
    public final tdmn getFoodStatsField() {
        return this.field_71100_bB;
    }

    @Override
    public final void setFoodStatsField(tdmn tdmn2) {
        this.field_71100_bB = tdmn2;
    }

    @Override
    public final boolean getForceSpawnField() {
        return this.field_98038_p;
    }

    @Override
    public final void setForceSpawnField(boolean bl) {
        this.field_98038_p = bl;
    }

    @Override
    public final float getHeightField() {
        return this.field_70131_O;
    }

    @Override
    public final void setHeightField(float f) {
        this.field_70131_O = f;
    }

    @Override
    public final float getHorseJumpPowerField() {
        return this.field_110321_bQ;
    }

    @Override
    public final void setHorseJumpPowerField(float f) {
        this.field_110321_bQ = f;
    }

    @Override
    public final int getHorseJumpPowerCounterField() {
        return this.field_110320_a;
    }

    @Override
    public final void setHorseJumpPowerCounterField(int n) {
        this.field_110320_a = n;
    }

    @Override
    public final int getHurtResistantTimeField() {
        return this.field_70172_ad;
    }

    @Override
    public final void setHurtResistantTimeField(int n) {
        this.field_70172_ad = n;
    }

    @Override
    public final int getHurtTimeField() {
        return this.field_70737_aN;
    }

    @Override
    public final void setHurtTimeField(int n) {
        this.field_70737_aN = n;
    }

    @Override
    public final boolean getIgnoreFrustumCheckField() {
        return this.field_70158_ak;
    }

    @Override
    public final void setIgnoreFrustumCheckField(boolean bl) {
        this.field_70158_ak = bl;
    }

    @Override
    public final boolean getInPortalField() {
        return this.field_71087_bX;
    }

    @Override
    public final void setInPortalField(boolean bl) {
        this.field_71087_bX = bl;
    }

    @Override
    public final boolean getInWaterField() {
        return this.field_70171_ac;
    }

    @Override
    public final void setInWaterField(boolean bl) {
        this.field_70171_ac = bl;
    }

    @Override
    public final eidj getInventoryField() {
        return this.field_71071_by;
    }

    @Override
    public final void setInventoryField(eidj eidj2) {
        this.field_71071_by = eidj2;
    }

    @Override
    public final jjgc getInventoryContainerField() {
        return this.field_71069_bz;
    }

    @Override
    public final void setInventoryContainerField(jjgc jjgc2) {
        this.field_71069_bz = jjgc2;
    }

    @Override
    public final boolean getIsAirBorneField() {
        return this.field_70160_al;
    }

    @Override
    public final void setIsAirBorneField(boolean bl) {
        this.field_70160_al = bl;
    }

    @Override
    public final boolean getIsCollidedField() {
        return this.field_70132_H;
    }

    @Override
    public final void setIsCollidedField(boolean bl) {
        this.field_70132_H = bl;
    }

    @Override
    public final boolean getIsCollidedHorizontallyField() {
        return this.field_70123_F;
    }

    @Override
    public final void setIsCollidedHorizontallyField(boolean bl) {
        this.field_70123_F = bl;
    }

    @Override
    public final boolean getIsCollidedVerticallyField() {
        return this.field_70124_G;
    }

    @Override
    public final void setIsCollidedVerticallyField(boolean bl) {
        this.field_70124_G = bl;
    }

    @Override
    public final boolean getIsDeadField() {
        return this.field_70128_L;
    }

    @Override
    public final void setIsDeadField(boolean bl) {
        this.field_70128_L = bl;
    }

    @Override
    public final boolean getIsImmuneToFireField() {
        return this.field_70178_ae;
    }

    @Override
    public final void setIsImmuneToFireField(boolean bl) {
        this.field_70178_ae = bl;
    }

    @Override
    public final boolean getIsInWebField() {
        return this.field_70134_J;
    }

    @Override
    public final void setIsInWebField(boolean bl) {
        this.field_70134_J = bl;
    }

    @Override
    public final boolean getIsJumpingField() {
        return this.field_70703_bu;
    }

    @Override
    public final void setIsJumpingField(boolean bl) {
        this.field_70703_bu = bl;
    }

    @Override
    public final boolean getIsSwingInProgressField() {
        return this.field_82175_bq;
    }

    @Override
    public final void setIsSwingInProgressField(boolean bl) {
        this.field_82175_bq = bl;
    }

    @Override
    public final float getJumpMovementFactorField() {
        return this.field_70747_aH;
    }

    @Override
    public final void setJumpMovementFactorField(float f) {
        this.field_70747_aH = f;
    }

    @Override
    public final float getLastDamageField() {
        return this.field_110153_bc;
    }

    @Override
    public final void setLastDamageField(float f) {
        this.field_110153_bc = f;
    }

    @Override
    public final double getLastTickPosXField() {
        return this.field_70142_S;
    }

    @Override
    public final void setLastTickPosXField(double d) {
        this.field_70142_S = d;
    }

    @Override
    public final double getLastTickPosYField() {
        return this.field_70137_T;
    }

    @Override
    public final void setLastTickPosYField(double d) {
        this.field_70137_T = d;
    }

    @Override
    public final double getLastTickPosZField() {
        return this.field_70136_U;
    }

    @Override
    public final void setLastTickPosZField(double d) {
        this.field_70136_U = d;
    }

    @Override
    public final float getLimbSwingField() {
        return this.field_70754_ba;
    }

    @Override
    public final void setLimbSwingField(float f) {
        this.field_70754_ba = f;
    }

    @Override
    public final float getLimbSwingAmountField() {
        return this.field_70721_aZ;
    }

    @Override
    public final void setLimbSwingAmountField(float f) {
        this.field_70721_aZ = f;
    }

    @Override
    public final int getMaxHurtResistantTimeField() {
        return this.field_70771_an;
    }

    @Override
    public final void setMaxHurtResistantTimeField(int n) {
        this.field_70771_an = n;
    }

    @Override
    public final int getMaxHurtTimeField() {
        return this.field_70738_aO;
    }

    @Override
    public final void setMaxHurtTimeField(int n) {
        this.field_70738_aO = n;
    }

    @Override
    public final xpzm getMcField() {
        return this.field_71159_c;
    }

    @Override
    public final void setMcField(xpzm xpzm2) {
        this.field_71159_c = xpzm2;
    }

    @Override
    public final double getMotionXField() {
        return this.field_70159_w;
    }

    @Override
    public final void setMotionXField(double d) {
        this.field_70159_w = d;
    }

    @Override
    public final double getMotionYField() {
        return this.field_70181_x;
    }

    @Override
    public final void setMotionYField(double d) {
        this.field_70181_x = d;
    }

    @Override
    public final double getMotionZField() {
        return this.field_70179_y;
    }

    @Override
    public final void setMotionZField(double d) {
        this.field_70179_y = d;
    }

    @Override
    public final float getMoveForwardField() {
        return this.field_70701_bs;
    }

    @Override
    public final void setMoveForwardField(float f) {
        this.field_70701_bs = f;
    }

    @Override
    public final float getMoveStrafingField() {
        return this.field_70702_br;
    }

    @Override
    public final void setMoveStrafingField(float f) {
        this.field_70702_br = f;
    }

    @Override
    public final kjwj getMovementInputField() {
        return this.field_71158_b;
    }

    @Override
    public final void setMovementInputField(kjwj kjwj2) {
        this.field_71158_b = kjwj2;
    }

    @Override
    public final ugqi getMyEntitySizeField() {
        return this.field_70168_am;
    }

    @Override
    public final void setMyEntitySizeField(ugqi ugqi2) {
        this.field_70168_am = ugqi2;
    }

    @Override
    public final int getNewPosRotationIncrementsField() {
        return this.field_70716_bi;
    }

    @Override
    public final void setNewPosRotationIncrementsField(int n) {
        this.field_70716_bi = n;
    }

    @Override
    public final double getNewPosXField() {
        return this.field_70709_bj;
    }

    @Override
    public final void setNewPosXField(double d) {
        this.field_70709_bj = d;
    }

    @Override
    public final double getNewPosYField() {
        return this.field_70710_bk;
    }

    @Override
    public final void setNewPosYField(double d) {
        this.field_70710_bk = d;
    }

    @Override
    public final double getNewPosZField() {
        return this.field_110152_bk;
    }

    @Override
    public final void setNewPosZField(double d) {
        this.field_110152_bk = d;
    }

    @Override
    public final double getNewRotationPitchField() {
        return this.field_70705_bn;
    }

    @Override
    public final void setNewRotationPitchField(double d) {
        this.field_70705_bn = d;
    }

    @Override
    public final double getNewRotationYawField() {
        return this.field_70712_bm;
    }

    @Override
    public final void setNewRotationYawField(double d) {
        this.field_70712_bm = d;
    }

    @Override
    public final boolean getNoClipField() {
        return this.field_70145_X;
    }

    @Override
    public final void setNoClipField(boolean bl) {
        this.field_70145_X = bl;
    }

    @Override
    public final boolean getOnGroundField() {
        return this.field_70122_E;
    }

    @Override
    public final void setOnGroundField(boolean bl) {
        this.field_70122_E = bl;
    }

    @Override
    public final jjgc getOpenContainerField() {
        return this.field_71070_bA;
    }

    @Override
    public final void setOpenContainerField(jjgc jjgc2) {
        this.field_71070_bA = jjgc2;
    }

    @Override
    public final zwaw getPlayerLocationField() {
        return this.field_71081_bT;
    }

    @Override
    public final void setPlayerLocationField(zwaw zwaw2) {
        this.field_71081_bT = zwaw2;
    }

    @Override
    public final int getPortalCounterField() {
        return this.field_82153_h;
    }

    @Override
    public final void setPortalCounterField(int n) {
        this.field_82153_h = n;
    }

    @Override
    public final double getPosXField() {
        return this.field_70165_t;
    }

    @Override
    public final void setPosXField(double d) {
        this.field_70165_t = d;
    }

    @Override
    public final double getPosYField() {
        return this.field_70163_u;
    }

    @Override
    public final void setPosYField(double d) {
        this.field_70163_u = d;
    }

    @Override
    public final double getPosZField() {
        return this.field_70161_v;
    }

    @Override
    public final void setPosZField(double d) {
        this.field_70161_v = d;
    }

    @Override
    public final float getPrevCameraPitchField() {
        return this.field_70727_aS;
    }

    @Override
    public final void setPrevCameraPitchField(float f) {
        this.field_70727_aS = f;
    }

    @Override
    public final float getPrevCameraYawField() {
        return this.field_71107_bF;
    }

    @Override
    public final void setPrevCameraYawField(float f) {
        this.field_71107_bF = f;
    }

    @Override
    public final float getPrevDistanceWalkedModifiedField() {
        return this.field_70141_P;
    }

    @Override
    public final void setPrevDistanceWalkedModifiedField(float f) {
        this.field_70141_P = f;
    }

    @Override
    public final float getPrevHealthField() {
        return this.field_70735_aL;
    }

    @Override
    public final void setPrevHealthField(float f) {
        this.field_70735_aL = f;
    }

    @Override
    public final float getPrevLimbSwingAmountField() {
        return this.field_70722_aY;
    }

    @Override
    public final void setPrevLimbSwingAmountField(float f) {
        this.field_70722_aY = f;
    }

    @Override
    public final double getPrevPosXField() {
        return this.field_70169_q;
    }

    @Override
    public final void setPrevPosXField(double d) {
        this.field_70169_q = d;
    }

    @Override
    public final double getPrevPosYField() {
        return this.field_70167_r;
    }

    @Override
    public final void setPrevPosYField(double d) {
        this.field_70167_r = d;
    }

    @Override
    public final double getPrevPosZField() {
        return this.field_70166_s;
    }

    @Override
    public final void setPrevPosZField(double d) {
        this.field_70166_s = d;
    }

    @Override
    public final float getPrevRenderArmPitchField() {
        return this.field_71164_i;
    }

    @Override
    public final void setPrevRenderArmPitchField(float f) {
        this.field_71164_i = f;
    }

    @Override
    public final float getPrevRenderArmYawField() {
        return this.field_71163_h;
    }

    @Override
    public final void setPrevRenderArmYawField(float f) {
        this.field_71163_h = f;
    }

    @Override
    public final float getPrevRenderYawOffsetField() {
        return this.field_70760_ar;
    }

    @Override
    public final void setPrevRenderYawOffsetField(float f) {
        this.field_70760_ar = f;
    }

    @Override
    public final float getPrevRotationPitchField() {
        return this.field_70127_C;
    }

    @Override
    public final void setPrevRotationPitchField(float f) {
        this.field_70127_C = f;
    }

    @Override
    public final float getPrevRotationYawField() {
        return this.field_70126_B;
    }

    @Override
    public final void setPrevRotationYawField(float f) {
        this.field_70126_B = f;
    }

    @Override
    public final float getPrevRotationYawHeadField() {
        return this.field_70758_at;
    }

    @Override
    public final void setPrevRotationYawHeadField(float f) {
        this.field_70758_at = f;
    }

    @Override
    public final float getPrevSwingProgressField() {
        return this.field_70732_aI;
    }

    @Override
    public final void setPrevSwingProgressField(float f) {
        this.field_70732_aI = f;
    }

    @Override
    public final float getPrevTimeInPortalField() {
        return this.field_71080_cy;
    }

    @Override
    public final void setPrevTimeInPortalField(float f) {
        this.field_71080_cy = f;
    }

    @Override
    public final boolean getPreventEntitySpawningField() {
        return this.field_70156_m;
    }

    @Override
    public final void setPreventEntitySpawningField(boolean bl) {
        this.field_70156_m = bl;
    }

    @Override
    public final Random getRandField() {
        return this.field_70146_Z;
    }

    @Override
    public final void setRandField(Random random) {
        this.field_70146_Z = random;
    }

    @Override
    public final float getRandomYawVelocityField() {
        return this.field_70704_bt;
    }

    @Override
    public final void setRandomYawVelocityField(float f) {
        this.field_70704_bt = f;
    }

    @Override
    public final int getRecentlyHitField() {
        return this.field_70718_bc;
    }

    @Override
    public final void setRecentlyHitField(int n) {
        this.field_70718_bc = n;
    }

    @Override
    public final float getRenderArmPitchField() {
        return this.field_71155_g;
    }

    @Override
    public final void setRenderArmPitchField(float f) {
        this.field_71155_g = f;
    }

    @Override
    public final float getRenderArmYawField() {
        return this.field_71154_f;
    }

    @Override
    public final void setRenderArmYawField(float f) {
        this.field_71154_f = f;
    }

    @Override
    public final double getRenderDistanceWeightField() {
        return this.field_70155_l;
    }

    @Override
    public final void setRenderDistanceWeightField(double d) {
        this.field_70155_l = d;
    }

    @Override
    public final float getRenderYawOffsetField() {
        return this.field_70761_aq;
    }

    @Override
    public final void setRenderYawOffsetField(float f) {
        this.field_70761_aq = f;
    }

    @Override
    public final Entity getRiddenByEntityField() {
        return this.field_70153_n;
    }

    @Override
    public final void setRiddenByEntityField(Entity entity) {
        this.field_70153_n = entity;
    }

    @Override
    public final Entity getRidingEntityField() {
        return this.field_70154_o;
    }

    @Override
    public final void setRidingEntityField(Entity entity) {
        this.field_70154_o = entity;
    }

    @Override
    public final float getRotationPitchField() {
        return this.field_70125_A;
    }

    @Override
    public final void setRotationPitchField(float f) {
        this.field_70125_A = f;
    }

    @Override
    public final float getRotationYawField() {
        return this.field_70177_z;
    }

    @Override
    public final void setRotationYawField(float f) {
        this.field_70177_z = f;
    }

    @Override
    public final float getRotationYawHeadField() {
        return this.field_70759_as;
    }

    @Override
    public final void setRotationYawHeadField(float f) {
        this.field_70759_as = f;
    }

    @Override
    public final int getScoreValueField() {
        return this.field_70744_aE;
    }

    @Override
    public final void setScoreValueField(int n) {
        this.field_70744_aE = n;
    }

    @Override
    public final int getServerPosXField() {
        return this.field_70118_ct;
    }

    @Override
    public final void setServerPosXField(int n) {
        this.field_70118_ct = n;
    }

    @Override
    public final int getServerPosYField() {
        return this.field_70117_cu;
    }

    @Override
    public final void setServerPosYField(int n) {
        this.field_70117_cu = n;
    }

    @Override
    public final int getServerPosZField() {
        return this.field_70116_cv;
    }

    @Override
    public final void setServerPosZField(int n) {
        this.field_70116_cv = n;
    }

    @Override
    public final int getSleepTimerField() {
        return this.field_71076_b;
    }

    @Override
    public final void setSleepTimerField(int n) {
        this.field_71076_b = n;
    }

    @Override
    public final boolean getSleepingField() {
        return this.field_71083_bS;
    }

    @Override
    public final void setSleepingField(boolean bl) {
        this.field_71083_bS = bl;
    }

    @Override
    public final float getSpeedInAirField() {
        return this.field_71102_ce;
    }

    @Override
    public final void setSpeedInAirField(float f) {
        this.field_71102_ce = f;
    }

    @Override
    public final float getSpeedOnGroundField() {
        return this.field_71108_cd;
    }

    @Override
    public final void setSpeedOnGroundField(float f) {
        this.field_71108_cd = f;
    }

    @Override
    public final int getSprintToggleTimerField() {
        return this.field_71156_d;
    }

    @Override
    public final void setSprintToggleTimerField(int n) {
        this.field_71156_d = n;
    }

    @Override
    public final int getSprintingTicksLeftField() {
        return this.field_71157_e;
    }

    @Override
    public final void setSprintingTicksLeftField(int n) {
        this.field_71157_e = n;
    }

    @Override
    public final float getStepHeightField() {
        return this.field_70138_W;
    }

    @Override
    public final void setStepHeightField(float f) {
        this.field_70138_W = f;
    }

    @Override
    public final float getSwingProgressField() {
        return this.field_70733_aJ;
    }

    @Override
    public final void setSwingProgressField(float f) {
        this.field_70733_aJ = f;
    }

    @Override
    public final int getSwingProgressIntField() {
        return this.field_110158_av;
    }

    @Override
    public final void setSwingProgressIntField(int n) {
        this.field_110158_av = n;
    }

    @Override
    public final int getTeleportDirectionField() {
        return this.field_82152_aq;
    }

    @Override
    public final void setTeleportDirectionField(int n) {
        this.field_82152_aq = n;
    }

    @Override
    public final int getTicksExistedField() {
        return this.field_70173_aa;
    }

    @Override
    public final void setTicksExistedField(int n) {
        this.field_70173_aa = n;
    }

    @Override
    public final float getTimeInPortalField() {
        return this.field_71086_bY;
    }

    @Override
    public final void setTimeInPortalField(float f) {
        this.field_71086_bY = f;
    }

    @Override
    public final int getTimeUntilPortalField() {
        return this.field_71088_bW;
    }

    @Override
    public final void setTimeUntilPortalField(int n) {
        this.field_71088_bW = n;
    }

    @Override
    public final String getUsernameField() {
        return this.field_71092_bJ;
    }

    @Override
    public final boolean getVelocityChangedField() {
        return this.field_70133_I;
    }

    @Override
    public final void setVelocityChangedField(boolean bl) {
        this.field_70133_I = bl;
    }

    @Override
    public final float getWidthField() {
        return this.field_70130_N;
    }

    @Override
    public final void setWidthField(float f) {
        this.field_70130_N = f;
    }

    @Override
    public final ozlu getWorldObjField() {
        return this.field_70170_p;
    }

    @Override
    public final void setWorldObjField(ozlu ozlu2) {
        this.field_70170_p = ozlu2;
    }

    @Override
    public final int getXpCooldownField() {
        return this.field_71090_bL;
    }

    @Override
    public final void setXpCooldownField(int n) {
        this.field_71090_bL = n;
    }

    @Override
    public final float getYOffsetField() {
        return this.field_70129_M;
    }

    @Override
    public final void setYOffsetField(float f) {
        this.field_70129_M = f;
    }

    @Override
    public final float getYSizeField() {
        return this.field_70139_V;
    }

    @Override
    public final void setYSizeField(float f) {
        this.field_70139_V = f;
    }

    @Override
    public final ClientPlayerBase getClientPlayerBase(String string) {
        return ClientPlayerAPI.getClientPlayerBase(this, string);
    }

    public final Set getClientPlayerBaseIds() {
        return ClientPlayerAPI.getClientPlayerBaseIds(this);
    }

    @Override
    public final Object dynamic(String string, Object[] objectArray) {
        return ClientPlayerAPI.dynamic(this, string, objectArray);
    }

    @Override
    public final ClientPlayerAPI getClientPlayerAPI() {
        return this.clientPlayerAPI;
    }

    @Override
    public final EntityPlayerSP getEntityPlayerSP() {
        return this;
    }
}

