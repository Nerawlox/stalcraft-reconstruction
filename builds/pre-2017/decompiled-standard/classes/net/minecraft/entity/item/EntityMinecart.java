/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.item.EntityMinecartFurnace;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraftforge.common.IMinecartCollisionHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.event.entity.minecart.MinecartUpdateEvent;

public abstract class EntityMinecart
extends Entity {
    public boolean field_70499_f;
    public final ywed field_82344_g;
    public String field_94102_c;
    public static final int[][][] field_70500_g = new int[][][]{new int[][]{{0, 0, -1}, {0, 0, 1}}, new int[][]{{-1, 0, 0}, {1, 0, 0}}, new int[][]{{-1, -1, 0}, {1, 0, 0}}, new int[][]{{-1, 0, 0}, {1, -1, 0}}, new int[][]{{0, 0, -1}, {0, -1, 1}}, new int[][]{{0, -1, -1}, {0, 0, 1}}, new int[][]{{0, 0, 1}, {1, 0, 0}}, new int[][]{{0, 0, 1}, {-1, 0, 0}}, new int[][]{{0, 0, -1}, {-1, 0, 0}}, new int[][]{{0, 0, -1}, {1, 0, 0}}};
    public int field_70510_h;
    public double field_70511_i;
    public double field_70509_j;
    public double field_70514_an;
    public double field_70512_ao;
    public double field_70513_ap;
    @SideOnly(value=Side.CLIENT)
    public double field_70508_aq;
    @SideOnly(value=Side.CLIENT)
    public double field_70507_ar;
    @SideOnly(value=Side.CLIENT)
    public double field_70506_as;
    public static float defaultMaxSpeedAirLateral = 0.4f;
    public static float defaultMaxSpeedAirVertical = -1.0f;
    public static double defaultDragAir = 0.95f;
    public boolean canUseRail = true;
    public boolean canBePushed = true;
    public static IMinecartCollisionHandler collisionHandler = null;
    public float currentSpeedRail = this.getMaxCartSpeedOnRail();
    public float maxSpeedAirLateral = defaultMaxSpeedAirLateral;
    public float maxSpeedAirVertical = defaultMaxSpeedAirVertical;
    public double dragAir = defaultDragAir;

    public EntityMinecart(ozlu ozlu2) {
        super(ozlu2);
        this.field_70156_m = true;
        this.func_70105_a(0.98f, 0.7f);
        this.field_70129_M = this.field_70131_O / 2.0f;
        this.field_82344_g = ozlu2 != null ? ozlu2.func_82735_a(this) : null;
    }

    public static EntityMinecart func_94090_a(ozlu ozlu2, double d, double d2, double d3, int n) {
        switch (n) {
            case 1: {
                return new EntityMinecartChest(ozlu2, d, d2, d3);
            }
            case 2: {
                return new EntityMinecartFurnace(ozlu2, d, d2, d3);
            }
            case 3: {
                return new EntityMinecartTNT(ozlu2, d, d2, d3);
            }
            case 4: {
                return new EntityMinecartMobSpawner(ozlu2, d, d2, d3);
            }
            case 5: {
                return new EntityMinecartHopper(ozlu2, d, d2, d3);
            }
        }
        return new EntityMinecartEmpty(ozlu2, d, d2, d3);
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    @Override
    public void func_70088_a() {
        this.field_70180_af._a(17, new Integer(0));
        this.field_70180_af._a(18, new Integer(1));
        this.field_70180_af._a(19, new Float(0.0f));
        this.field_70180_af._a(20, new Integer(0));
        this.field_70180_af._a(21, new Integer(6));
        this.field_70180_af._a(22, (Object)0);
    }

    @Override
    public eidj func_70114_g(Entity entity) {
        if (EntityMinecart.getCollisionHandler() != null) {
            return EntityMinecart.getCollisionHandler().getCollisionBox(this, entity);
        }
        return entity.func_70104_M() ? entity.field_70121_D : null;
    }

    @Override
    public eidj func_70046_E() {
        if (EntityMinecart.getCollisionHandler() != null) {
            return EntityMinecart.getCollisionHandler().getBoundingBox(this);
        }
        return null;
    }

    @Override
    public boolean func_70104_M() {
        return this.canBePushed;
    }

    public EntityMinecart(ozlu ozlu2, double d, double d2, double d3) {
        this(ozlu2);
        this.func_70107_b(d, d2, d3);
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        this.field_70169_q = d;
        this.field_70167_r = d2;
        this.field_70166_s = d3;
    }

    @Override
    public double func_70042_X() {
        return (double)this.field_70131_O * 0.0 - (double)0.3f;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
            boolean bl;
            if (this.func_85032_ar()) {
                return false;
            }
            this.func_70494_i(-this.func_70493_k());
            this.func_70497_h(10);
            this.func_70018_K();
            this.func_70492_c(this.func_70491_i() + f * 10.0f);
            boolean bl2 = bl = jxtc2.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)jxtc2.func_76346_g()).field_71075_bZ._d;
            if (bl || this.func_70491_i() > 40.0f) {
                if (this.field_70153_n != null) {
                    this.field_70153_n.func_70078_a(this);
                }
                if (bl && !this.func_94042_c()) {
                    this.func_70106_y();
                } else {
                    this.func_94095_a(jxtc2);
                }
            }
            return true;
        }
        return true;
    }

    public void func_94095_a(jxtc jxtc2) {
        this.func_70106_y();
        cvzo cvzo2 = new cvzo(tgdv.field_77773_az, 1);
        if (this.field_94102_c != null) {
            cvzo2._a(this.field_94102_c);
        }
        this.func_70099_a(cvzo2, 0.0f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70057_ab() {
        this.func_70494_i(-this.func_70493_k());
        this.func_70497_h(10);
        this.func_70492_c(this.func_70491_i() + this.func_70491_i() * 10.0f);
    }

    @Override
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }

    @Override
    public void func_70106_y() {
        super.func_70106_y();
        if (this.field_82344_g != null) {
            this.field_82344_g._a();
        }
    }

    @Override
    public void func_70071_h_() {
        int n;
        int n2;
        if (this.field_82344_g != null) {
            this.field_82344_g._a();
        }
        if (this.func_70496_j() > 0) {
            this.func_70497_h(this.func_70496_j() - 1);
        }
        if (this.func_70491_i() > 0.0f) {
            this.func_70492_c(this.func_70491_i() - 1.0f);
        }
        if (this.field_70163_u < -64.0) {
            this.func_70076_C();
        }
        if (!this.field_70170_p.field_72995_K && this.field_70170_p instanceof yfgy) {
            this.field_70170_p.field_72984_F._a("portal");
            dzfd dzfd2 = ((yfgy)this.field_70170_p).func_73046_m();
            n2 = this.func_82145_z();
            if (this.field_71087_bX) {
                if (dzfd2._E()) {
                    if (this.field_70154_o == null && this.field_82153_h++ >= n2) {
                        this.field_82153_h = n2;
                        this.field_71088_bW = this.func_82147_ab();
                        n = this.field_70170_p.field_73011_w._i == -1 ? 0 : -1;
                        this.func_71027_c(n);
                    }
                    this.field_71087_bX = false;
                }
            } else {
                if (this.field_82153_h > 0) {
                    this.field_82153_h -= 4;
                }
                if (this.field_82153_h < 0) {
                    this.field_82153_h = 0;
                }
            }
            if (this.field_71088_bW > 0) {
                --this.field_71088_bW;
            }
            this.field_70170_p.field_72984_F._b();
        }
        if (this.field_70170_p.field_72995_K) {
            if (this.field_70510_h > 0) {
                double d = this.field_70165_t + (this.field_70511_i - this.field_70165_t) / (double)this.field_70510_h;
                double d2 = this.field_70163_u + (this.field_70509_j - this.field_70163_u) / (double)this.field_70510_h;
                double d3 = this.field_70161_v + (this.field_70514_an - this.field_70161_v) / (double)this.field_70510_h;
                double d4 = sajh._f(this.field_70512_ao - (double)this.field_70177_z);
                this.field_70177_z = (float)((double)this.field_70177_z + d4 / (double)this.field_70510_h);
                this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70513_ap - (double)this.field_70125_A) / (double)this.field_70510_h);
                --this.field_70510_h;
                this.func_70107_b(d, d2, d3);
                this.func_70101_b(this.field_70177_z, this.field_70125_A);
            } else {
                this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.func_70101_b(this.field_70177_z, this.field_70125_A);
            }
        } else {
            double d;
            double d5;
            this.field_70169_q = this.field_70165_t;
            this.field_70167_r = this.field_70163_u;
            this.field_70166_s = this.field_70161_v;
            this.field_70181_x -= (double)0.04f;
            int n3 = sajh._c(this.field_70165_t);
            if (scgt._a(this.field_70170_p, n3, (n2 = sajh._c(this.field_70163_u)) - 1, n = sajh._c(this.field_70161_v))) {
                --n2;
            }
            double d6 = 0.4;
            double d7 = 0.0078125;
            int n4 = this.field_70170_p.func_72798_a(n3, n2, n);
            if (this.canUseRail() && scgt._a(n4)) {
                scgt scgt2 = (scgt)twgu.field_71973_m[n4];
                float f = scgt2._a(this.field_70170_p, this, n3, n2, n);
                d5 = Math.min(f, this.getCurrentCartSpeedCapOnRail());
                int n5 = scgt2._a((sdrg)this.field_70170_p, this, n3, n2, n);
                this.func_94091_a(n3, n2, n, d5, this.getSlopeAdjustment(), n4, n5);
                if (n4 == twgu.field_94337_cv.field_71990_ca) {
                    this.func_96095_a(n3, n2, n, (this.field_70170_p.func_72805_g(n3, n2, n) & 8) != 0);
                }
            } else {
                this.func_94088_b(this.field_70122_E ? d6 : (double)this.getMaxSpeedAirLateral());
            }
            this.func_70017_D();
            this.field_70125_A = 0.0f;
            double d8 = this.field_70169_q - this.field_70165_t;
            d5 = this.field_70166_s - this.field_70161_v;
            if (d8 * d8 + d5 * d5 > 0.001) {
                this.field_70177_z = (float)(Math.atan2(d5, d8) * 180.0 / Math.PI);
                if (this.field_70499_f) {
                    this.field_70177_z += 180.0f;
                }
            }
            if ((d = (double)sajh._g(this.field_70177_z - this.field_70126_B)) < -170.0 || d >= 170.0) {
                this.field_70177_z += 180.0f;
                this.field_70499_f = !this.field_70499_f;
            }
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
            eidj eidj2 = EntityMinecart.getCollisionHandler() != null ? EntityMinecart.getCollisionHandler().getMinecartCollisionBox(this) : this.field_70121_D._b(0.2, 0.0, 0.2);
            List list2 = this.field_70170_p.func_72839_b(this, eidj2);
            if (list2 != null && !list2.isEmpty()) {
                for (int i = 0; i < list2.size(); ++i) {
                    Entity entity = (Entity)list2.get(i);
                    if (entity == this.field_70153_n || !entity.func_70104_M() || !(entity instanceof EntityMinecart)) continue;
                    entity.func_70108_f(this);
                }
            }
            if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
                if (this.field_70153_n.field_70154_o == this) {
                    this.field_70153_n.field_70154_o = null;
                }
                this.field_70153_n = null;
            }
            MinecraftForge.EVENT_BUS.post(new MinecartUpdateEvent(this, n3, n2, n));
        }
    }

    public void func_96095_a(int n, int n2, int n3, boolean bl) {
    }

    public void func_94088_b(double d) {
        if (this.field_70159_w < -d) {
            this.field_70159_w = -d;
        }
        if (this.field_70159_w > d) {
            this.field_70159_w = d;
        }
        if (this.field_70179_y < -d) {
            this.field_70179_y = -d;
        }
        if (this.field_70179_y > d) {
            this.field_70179_y = d;
        }
        double d2 = this.field_70181_x;
        if (this.getMaxSpeedAirVertical() > 0.0f && this.field_70181_x > (double)this.getMaxSpeedAirVertical()) {
            d2 = this.getMaxSpeedAirVertical();
            if (Math.abs(this.field_70159_w) < (double)0.3f && Math.abs(this.field_70179_y) < (double)0.3f) {
                this.field_70181_x = d2 = (double)0.15f;
            }
        }
        if (this.field_70122_E) {
            this.field_70159_w *= 0.5;
            this.field_70181_x *= 0.5;
            this.field_70179_y *= 0.5;
        }
        this.func_70091_d(this.field_70159_w, d2, this.field_70179_y);
        if (!this.field_70122_E) {
            this.field_70159_w *= this.getDragAir();
            this.field_70181_x *= this.getDragAir();
            this.field_70179_y *= this.getDragAir();
        }
    }

    public void func_94091_a(int n, int n2, int n3, double d, double d2, int n4, int n5) {
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        this.field_70143_R = 0.0f;
        ofbx ofbx2 = this.func_70489_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70163_u = n2;
        boolean bl = false;
        boolean bl2 = false;
        if (n4 == twgu.field_71954_T.field_71990_ca) {
            bl = (this.field_70170_p.func_72805_g(n, n2, n3) & 8) != 0;
            boolean bl3 = bl2 = !bl;
        }
        if (((scgt)twgu.field_71973_m[n4])._a()) {
            n5 &= 7;
        }
        if (n5 >= 2 && n5 <= 5) {
            this.field_70163_u = n2 + 1;
        }
        if (n5 == 2) {
            this.field_70159_w -= d2;
        }
        if (n5 == 3) {
            this.field_70159_w += d2;
        }
        if (n5 == 4) {
            this.field_70179_y += d2;
        }
        if (n5 == 5) {
            this.field_70179_y -= d2;
        }
        int[][] nArray = field_70500_g[n5];
        double d8 = nArray[1][0] - nArray[0][0];
        double d9 = nArray[1][2] - nArray[0][2];
        double d10 = Math.sqrt(d8 * d8 + d9 * d9);
        double d11 = this.field_70159_w * d8 + this.field_70179_y * d9;
        if (d11 < 0.0) {
            d8 = -d8;
            d9 = -d9;
        }
        if ((d7 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y)) > 2.0) {
            d7 = 2.0;
        }
        this.field_70159_w = d7 * d8 / d10;
        this.field_70179_y = d7 * d9 / d10;
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityLivingBase && (d6 = (double)((EntityLivingBase)this.field_70153_n).field_70701_bs) > 0.0) {
            d5 = -Math.sin(this.field_70153_n.field_70177_z * (float)Math.PI / 180.0f);
            d4 = Math.cos(this.field_70153_n.field_70177_z * (float)Math.PI / 180.0f);
            d3 = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
            if (d3 < 0.01) {
                this.field_70159_w += d5 * 0.1;
                this.field_70179_y += d4 * 0.1;
                bl2 = false;
            }
        }
        if (bl2 && this.shouldDoRailFunctions()) {
            d6 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            if (d6 < 0.03) {
                this.field_70159_w *= 0.0;
                this.field_70181_x *= 0.0;
                this.field_70179_y *= 0.0;
            } else {
                this.field_70159_w *= 0.5;
                this.field_70181_x *= 0.0;
                this.field_70179_y *= 0.5;
            }
        }
        d6 = 0.0;
        d5 = (double)n + 0.5 + (double)nArray[0][0] * 0.5;
        d4 = (double)n3 + 0.5 + (double)nArray[0][2] * 0.5;
        d3 = (double)n + 0.5 + (double)nArray[1][0] * 0.5;
        double d12 = (double)n3 + 0.5 + (double)nArray[1][2] * 0.5;
        d8 = d3 - d5;
        d9 = d12 - d4;
        if (d8 == 0.0) {
            this.field_70165_t = (double)n + 0.5;
            d6 = this.field_70161_v - (double)n3;
        } else if (d9 == 0.0) {
            this.field_70161_v = (double)n3 + 0.5;
            d6 = this.field_70165_t - (double)n;
        } else {
            double d13 = this.field_70165_t - d5;
            double d14 = this.field_70161_v - d4;
            d6 = (d13 * d8 + d14 * d9) * 2.0;
        }
        this.field_70165_t = d5 + d8 * d6;
        this.field_70161_v = d4 + d9 * d6;
        this.func_70107_b(this.field_70165_t, this.field_70163_u + (double)this.field_70129_M, this.field_70161_v);
        this.moveMinecartOnRail(n, n2, n3, d);
        if (nArray[0][1] != 0 && sajh._c(this.field_70165_t) - n == nArray[0][0] && sajh._c(this.field_70161_v) - n3 == nArray[0][2]) {
            this.func_70107_b(this.field_70165_t, this.field_70163_u + (double)nArray[0][1], this.field_70161_v);
        } else if (nArray[1][1] != 0 && sajh._c(this.field_70165_t) - n == nArray[1][0] && sajh._c(this.field_70161_v) - n3 == nArray[1][2]) {
            this.func_70107_b(this.field_70165_t, this.field_70163_u + (double)nArray[1][1], this.field_70161_v);
        }
        this.func_94101_h();
        ofbx ofbx3 = this.func_70489_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        if (ofbx3 != null && ofbx2 != null) {
            double d15 = (ofbx2._d - ofbx3._d) * 0.05;
            d7 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            if (d7 > 0.0) {
                this.field_70159_w = this.field_70159_w / d7 * (d7 + d15);
                this.field_70179_y = this.field_70179_y / d7 * (d7 + d15);
            }
            this.func_70107_b(this.field_70165_t, ofbx3._d, this.field_70161_v);
        }
        int n6 = sajh._c(this.field_70165_t);
        int n7 = sajh._c(this.field_70161_v);
        if (n6 != n || n7 != n3) {
            d7 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70159_w = d7 * (double)(n6 - n);
            this.field_70179_y = d7 * (double)(n7 - n3);
        }
        if (this.shouldDoRailFunctions()) {
            ((scgt)twgu.field_71973_m[n4])._b(this.field_70170_p, this, n, n2, n3);
        }
        if (bl && this.shouldDoRailFunctions()) {
            double d16 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            if (d16 > 0.01) {
                double d17 = 0.06;
                this.field_70159_w += this.field_70159_w / d16 * d17;
                this.field_70179_y += this.field_70179_y / d16 * d17;
            } else if (n5 == 1) {
                if (this.field_70170_p.func_72809_s(n - 1, n2, n3)) {
                    this.field_70159_w = 0.02;
                } else if (this.field_70170_p.func_72809_s(n + 1, n2, n3)) {
                    this.field_70159_w = -0.02;
                }
            } else if (n5 == 0) {
                if (this.field_70170_p.func_72809_s(n, n2, n3 - 1)) {
                    this.field_70179_y = 0.02;
                } else if (this.field_70170_p.func_72809_s(n, n2, n3 + 1)) {
                    this.field_70179_y = -0.02;
                }
            }
        }
    }

    public void func_94101_h() {
        if (this.field_70153_n != null) {
            this.field_70159_w *= (double)0.997f;
            this.field_70181_x *= 0.0;
            this.field_70179_y *= (double)0.997f;
        } else {
            this.field_70159_w *= (double)0.96f;
            this.field_70181_x *= 0.0;
            this.field_70179_y *= (double)0.96f;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public ofbx func_70495_a(double d, double d2, double d3, double d4) {
        int n;
        int n2;
        int n3;
        int n4 = sajh._c(d);
        if (scgt._a(this.field_70170_p, n4, (n3 = sajh._c(d2)) - 1, n2 = sajh._c(d3))) {
            --n3;
        }
        if (!scgt._a(n = this.field_70170_p.func_72798_a(n4, n3, n2))) {
            return null;
        }
        int n5 = ((scgt)twgu.field_71973_m[n])._a((sdrg)this.field_70170_p, this, n4, n3, n2);
        d2 = n3;
        if (n5 >= 2 && n5 <= 5) {
            d2 = n3 + 1;
        }
        int[][] nArray = field_70500_g[n5];
        double d5 = nArray[1][0] - nArray[0][0];
        double d6 = nArray[1][2] - nArray[0][2];
        double d7 = Math.sqrt(d5 * d5 + d6 * d6);
        if (nArray[0][1] != 0 && sajh._c(d += (d5 /= d7) * d4) - n4 == nArray[0][0] && sajh._c(d3 += (d6 /= d7) * d4) - n2 == nArray[0][2]) {
            d2 += (double)nArray[0][1];
        } else if (nArray[1][1] != 0 && sajh._c(d) - n4 == nArray[1][0] && sajh._c(d3) - n2 == nArray[1][2]) {
            d2 += (double)nArray[1][1];
        }
        return this.func_70489_a(d, d2, d3);
    }

    public ofbx func_70489_a(double d, double d2, double d3) {
        int n;
        int n2;
        int n3;
        int n4 = sajh._c(d);
        if (scgt._a(this.field_70170_p, n4, (n3 = sajh._c(d2)) - 1, n2 = sajh._c(d3))) {
            --n3;
        }
        if (scgt._a(n = this.field_70170_p.func_72798_a(n4, n3, n2))) {
            int n5 = ((scgt)twgu.field_71973_m[n])._a((sdrg)this.field_70170_p, this, n4, n3, n2);
            d2 = n3;
            if (n5 >= 2 && n5 <= 5) {
                d2 = n3 + 1;
            }
            int[][] nArray = field_70500_g[n5];
            double d4 = 0.0;
            double d5 = (double)n4 + 0.5 + (double)nArray[0][0] * 0.5;
            double d6 = (double)n3 + 0.5 + (double)nArray[0][1] * 0.5;
            double d7 = (double)n2 + 0.5 + (double)nArray[0][2] * 0.5;
            double d8 = (double)n4 + 0.5 + (double)nArray[1][0] * 0.5;
            double d9 = (double)n3 + 0.5 + (double)nArray[1][1] * 0.5;
            double d10 = (double)n2 + 0.5 + (double)nArray[1][2] * 0.5;
            double d11 = d8 - d5;
            double d12 = (d9 - d6) * 2.0;
            double d13 = d10 - d7;
            if (d11 == 0.0) {
                d = (double)n4 + 0.5;
                d4 = d3 - (double)n2;
            } else if (d13 == 0.0) {
                d3 = (double)n2 + 0.5;
                d4 = d - (double)n4;
            } else {
                double d14 = d - d5;
                double d15 = d3 - d7;
                d4 = (d14 * d11 + d15 * d13) * 2.0;
            }
            d = d5 + d11 * d4;
            d2 = d6 + d12 * d4;
            d3 = d7 + d13 * d4;
            if (d12 < 0.0) {
                d2 += 1.0;
            }
            if (d12 > 0.0) {
                d2 += 0.5;
            }
            return this.field_70170_p.func_82732_R()._a(d, d2, d3);
        }
        return null;
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        if (qoac2._o("CustomDisplayTile")) {
            this.func_94094_j(qoac2._f("DisplayTile"));
            this.func_94092_k(qoac2._f("DisplayData"));
            this.func_94086_l(qoac2._f("DisplayOffset"));
        }
        if (qoac2._c("CustomName") && qoac2._j("CustomName").length() > 0) {
            this.field_94102_c = qoac2._j("CustomName");
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        if (this.func_94100_s()) {
            qoac2._a("CustomDisplayTile", true);
            qoac2._a("DisplayTile", this.func_94089_m() == null ? 0 : this.func_94089_m().field_71990_ca);
            qoac2._a("DisplayData", this.func_94098_o());
            qoac2._a("DisplayOffset", this.func_94099_q());
        }
        if (this.field_94102_c != null && this.field_94102_c.length() > 0) {
            qoac2._a("CustomName", this.field_94102_c);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float func_70053_R() {
        return 0.0f;
    }

    @Override
    public void func_70108_f(Entity entity) {
        MinecraftForge.EVENT_BUS.post(new MinecartCollisionEvent(this, entity));
        if (EntityMinecart.getCollisionHandler() != null) {
            EntityMinecart.getCollisionHandler().onEntityCollision(this, entity);
            return;
        }
        if (!this.field_70170_p.field_72995_K && entity != this.field_70153_n) {
            double d;
            double d2;
            double d3;
            if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer) && !(entity instanceof EntityIronGolem) && this.canBeRidden() && this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 0.01 && this.field_70153_n == null && entity.field_70154_o == null) {
                entity.func_70078_a(this);
            }
            if ((d3 = (d2 = entity.field_70165_t - this.field_70165_t) * d2 + (d = entity.field_70161_v - this.field_70161_v) * d) >= (double)1.0E-4f) {
                d3 = sajh._a(d3);
                d2 /= d3;
                d /= d3;
                double d4 = 1.0 / d3;
                if (d4 > 1.0) {
                    d4 = 1.0;
                }
                d2 *= d4;
                d *= d4;
                d2 *= (double)0.1f;
                d *= (double)0.1f;
                d2 *= (double)(1.0f - this.field_70144_Y);
                d *= (double)(1.0f - this.field_70144_Y);
                d2 *= 0.5;
                d *= 0.5;
                if (entity instanceof EntityMinecart) {
                    ofbx ofbx2;
                    double d5 = entity.field_70165_t - this.field_70165_t;
                    double d6 = entity.field_70161_v - this.field_70161_v;
                    ofbx ofbx3 = this.field_70170_p.func_82732_R()._a(d5, 0.0, d6)._a();
                    double d7 = Math.abs(ofbx3._b(ofbx2 = this.field_70170_p.func_82732_R()._a(sajh._b(this.field_70177_z * (float)Math.PI / 180.0f), 0.0, sajh._a(this.field_70177_z * (float)Math.PI / 180.0f))._a()));
                    if (d7 < (double)0.8f) {
                        return;
                    }
                    double d8 = entity.field_70159_w + this.field_70159_w;
                    double d9 = entity.field_70179_y + this.field_70179_y;
                    if (((EntityMinecart)entity).isPoweredCart() && !this.isPoweredCart()) {
                        this.field_70159_w *= (double)0.2f;
                        this.field_70179_y *= (double)0.2f;
                        this.func_70024_g(entity.field_70159_w - d2, 0.0, entity.field_70179_y - d);
                        entity.field_70159_w *= (double)0.95f;
                        entity.field_70179_y *= (double)0.95f;
                    } else if (!((EntityMinecart)entity).isPoweredCart() && this.isPoweredCart()) {
                        entity.field_70159_w *= (double)0.2f;
                        entity.field_70179_y *= (double)0.2f;
                        entity.func_70024_g(this.field_70159_w + d2, 0.0, this.field_70179_y + d);
                        this.field_70159_w *= (double)0.95f;
                        this.field_70179_y *= (double)0.95f;
                    } else {
                        this.field_70159_w *= (double)0.2f;
                        this.field_70179_y *= (double)0.2f;
                        this.func_70024_g((d8 /= 2.0) - d2, 0.0, (d9 /= 2.0) - d);
                        entity.field_70159_w *= (double)0.2f;
                        entity.field_70179_y *= (double)0.2f;
                        entity.func_70024_g(d8 + d2, 0.0, d9 + d);
                    }
                } else {
                    this.func_70024_g(-d2, 0.0, -d);
                    entity.func_70024_g(d2 / 4.0, 0.0, d / 4.0);
                }
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
        this.field_70511_i = d;
        this.field_70509_j = d2;
        this.field_70514_an = d3;
        this.field_70512_ao = f;
        this.field_70513_ap = f2;
        this.field_70510_h = n + 2;
        this.field_70159_w = this.field_70508_aq;
        this.field_70181_x = this.field_70507_ar;
        this.field_70179_y = this.field_70506_as;
    }

    public void func_70492_c(float f) {
        this.field_70180_af._b(19, Float.valueOf(f));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70016_h(double d, double d2, double d3) {
        this.field_70508_aq = this.field_70159_w = d;
        this.field_70507_ar = this.field_70181_x = d2;
        this.field_70506_as = this.field_70179_y = d3;
    }

    public float func_70491_i() {
        return this.field_70180_af._d(19);
    }

    public void func_70497_h(int n) {
        this.field_70180_af._b(17, n);
    }

    public int func_70496_j() {
        return this.field_70180_af._c(17);
    }

    public void func_70494_i(int n) {
        this.field_70180_af._b(18, n);
    }

    public int func_70493_k() {
        return this.field_70180_af._c(18);
    }

    public abstract int func_94087_l();

    public twgu func_94089_m() {
        if (!this.func_94100_s()) {
            return this.func_94093_n();
        }
        int n = this.func_70096_w()._c(20) & 0xFFFF;
        return n > 0 && n < twgu.field_71973_m.length ? twgu.field_71973_m[n] : null;
    }

    public twgu func_94093_n() {
        return null;
    }

    public int func_94098_o() {
        return !this.func_94100_s() ? this.func_94097_p() : this.func_70096_w()._c(20) >> 16;
    }

    public int func_94097_p() {
        return 0;
    }

    public int func_94099_q() {
        return !this.func_94100_s() ? this.func_94085_r() : this.func_70096_w()._c(21);
    }

    public int func_94085_r() {
        return 6;
    }

    public void func_94094_j(int n) {
        this.func_70096_w()._b(20, n & 0xFFFF | this.func_94098_o() << 16);
        this.func_94096_e(true);
    }

    public void func_94092_k(int n) {
        twgu twgu2 = this.func_94089_m();
        int n2 = twgu2 == null ? 0 : twgu2.field_71990_ca;
        this.func_70096_w()._b(20, n2 & 0xFFFF | n << 16);
        this.func_94096_e(true);
    }

    public void func_94086_l(int n) {
        this.func_70096_w()._b(21, n);
        this.func_94096_e(true);
    }

    public boolean func_94100_s() {
        return this.func_70096_w()._a(22) == 1;
    }

    public void func_94096_e(boolean bl) {
        this.func_70096_w()._b(22, (byte)(bl ? 1 : 0));
    }

    public void func_96094_a(String string) {
        this.field_94102_c = string;
    }

    @Override
    public String func_70023_ak() {
        return this.field_94102_c != null ? this.field_94102_c : super.func_70023_ak();
    }

    public boolean func_94042_c() {
        return this.field_94102_c != null;
    }

    public String func_95999_t() {
        return this.field_94102_c;
    }

    public void moveMinecartOnRail(int n, int n2, int n3, double d) {
        double d2 = this.field_70159_w;
        double d3 = this.field_70179_y;
        if (this.field_70153_n != null) {
            d2 *= 0.75;
            d3 *= 0.75;
        }
        if (d2 < -d) {
            d2 = -d;
        }
        if (d2 > d) {
            d2 = d;
        }
        if (d3 < -d) {
            d3 = -d;
        }
        if (d3 > d) {
            d3 = d;
        }
        this.func_70091_d(d2, 0.0, d3);
    }

    public static IMinecartCollisionHandler getCollisionHandler() {
        return collisionHandler;
    }

    public static void setCollisionHandler(IMinecartCollisionHandler iMinecartCollisionHandler) {
        collisionHandler = iMinecartCollisionHandler;
    }

    public cvzo getCartItem() {
        if (this instanceof EntityMinecartChest) {
            return new cvzo(tgdv.field_77762_aN);
        }
        if (this instanceof EntityMinecartTNT) {
            return new cvzo(tgdv.field_94582_cb);
        }
        if (this instanceof EntityMinecartFurnace) {
            return new cvzo(tgdv.field_77763_aO);
        }
        if (this instanceof EntityMinecartHopper) {
            return new cvzo(tgdv.field_96600_cc);
        }
        return new cvzo(tgdv.field_77773_az);
    }

    public boolean canUseRail() {
        return this.canUseRail;
    }

    public void setCanUseRail(boolean bl) {
        this.canUseRail = bl;
    }

    public boolean shouldDoRailFunctions() {
        return true;
    }

    public boolean isPoweredCart() {
        return this.func_94087_l() == 2;
    }

    public boolean canBeRidden() {
        return this instanceof EntityMinecartEmpty;
    }

    public float getMaxCartSpeedOnRail() {
        return 1.2f;
    }

    public final float getCurrentCartSpeedCapOnRail() {
        return this.currentSpeedRail;
    }

    public final void setCurrentCartSpeedCapOnRail(float f) {
        this.currentSpeedRail = f = Math.min(f, this.getMaxCartSpeedOnRail());
    }

    public float getMaxSpeedAirLateral() {
        return this.maxSpeedAirLateral;
    }

    public void setMaxSpeedAirLateral(float f) {
        this.maxSpeedAirLateral = f;
    }

    public float getMaxSpeedAirVertical() {
        return this.maxSpeedAirVertical;
    }

    public void setMaxSpeedAirVertical(float f) {
        this.maxSpeedAirVertical = f;
    }

    public double getDragAir() {
        return this.dragAir;
    }

    public void setDragAir(double d) {
        this.dragAir = d;
    }

    public double getSlopeAdjustment() {
        return 0.0078125;
    }
}

