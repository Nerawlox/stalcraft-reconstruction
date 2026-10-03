/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.anticheat.pidb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.eidj;
import net.minecraft.entity.ezey;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.jgro;
import net.minecraft.entity.jxsn;
import net.minecraft.entity.kjui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ugqi;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import net.minecraft.util.turb;
import net.minecraft.util.ugqx;
import net.minecraft.util.zwaw;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterBlood;
import poersch.minecraft.bettergrassandleaves.renderer.BetterBloodRenderer;

public abstract class Entity
implements IBetterBlood {
    public static int field_70152_a;
    public int field_70157_k;
    public double field_70155_l = 1.0;
    public boolean field_70156_m;
    public Entity field_70153_n;
    public Entity field_70154_o;
    public boolean field_98038_p;
    public ozlu field_70170_p;
    public double field_70169_q;
    public double field_70167_r;
    public double field_70166_s;
    public double field_70165_t;
    public double field_70163_u;
    public double field_70161_v;
    public double field_70159_w;
    public double field_70181_x;
    public double field_70179_y;
    public float field_70177_z;
    public float field_70125_A;
    public float field_70126_B;
    public float field_70127_C;
    public final net.minecraft.util.eidj field_70121_D;
    public boolean field_70122_E;
    public boolean field_70123_F;
    public boolean field_70124_G;
    public boolean field_70132_H;
    public boolean field_70133_I;
    public boolean field_70134_J;
    public boolean field_70135_K = true;
    public boolean field_70128_L;
    public float field_70129_M;
    public float field_70130_N = 0.6f;
    public float field_70131_O = 1.8f;
    public float field_70141_P;
    public float field_70140_Q;
    public float field_82151_R;
    public float field_70143_R;
    public int field_70150_b = 1;
    public double field_70142_S;
    public double field_70137_T;
    public double field_70136_U;
    public float field_70139_V;
    public float field_70138_W;
    public boolean field_70145_X;
    public float field_70144_Y;
    public Random field_70146_Z;
    public int field_70173_aa;
    public int field_70174_ab = 1;
    public int field_70151_c;
    public boolean field_70171_ac;
    public int field_70172_ad;
    public boolean field_70148_d = true;
    public boolean field_70178_ae;
    public ezey field_70180_af;
    public double field_70149_e;
    public double field_70147_f;
    public boolean field_70175_ag;
    public int field_70176_ah;
    public int field_70162_ai;
    public int field_70164_aj;
    @SideOnly(value=Side.CLIENT)
    public int field_70118_ct;
    @SideOnly(value=Side.CLIENT)
    public int field_70117_cu;
    @SideOnly(value=Side.CLIENT)
    public int field_70116_cv;
    public boolean field_70158_ak;
    public boolean field_70160_al;
    public int field_71088_bW;
    public boolean field_71087_bX;
    public int field_82153_h;
    public int field_71093_bK;
    public int field_82152_aq;
    public boolean field_83001_bt;
    public UUID field_96093_i;
    public ugqi field_70168_am;
    public qoac customEntityData;
    public boolean captureDrops = false;
    public ArrayList<EntityItem> capturedDrops = new ArrayList();
    public UUID persistentID;
    public HashMap<String, IExtendedEntityProperties> extendedProperties;
    public int colorBetterBlood;

    public Entity(ozlu ozlu2) {
        this.field_70157_k = field_70152_a++;
        this.field_70121_D = net.minecraft.util.eidj._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        this.field_70146_Z = new Random();
        this.field_70180_af = new ezey();
        this.field_96093_i = UUID.randomUUID();
        this.field_70168_am = ugqi._b;
        this.field_70170_p = ozlu2;
        this.func_70107_b(0.0, 0.0, 0.0);
        if (ozlu2 != null) {
            this.field_71093_bK = ozlu2.field_73011_w._i;
        }
        this.field_70180_af._a(0, (Object)0);
        this.field_70180_af._a(1, (Object)300);
        this.func_70088_a();
        this.extendedProperties = new HashMap();
        MinecraftForge.EVENT_BUS.post(new EntityEvent.EntityConstructing(this));
        for (IExtendedEntityProperties iExtendedEntityProperties : this.extendedProperties.values()) {
            iExtendedEntityProperties.init(this, ozlu2);
        }
    }

    public abstract void func_70088_a();

    public ezey func_70096_w() {
        return this.field_70180_af;
    }

    public boolean equals(Object object) {
        return object instanceof Entity ? ((Entity)object).field_70157_k == this.field_70157_k : false;
    }

    public int hashCode() {
        return this.field_70157_k;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_70065_x() {
        if (this.field_70170_p != null) {
            while (this.field_70163_u > 0.0) {
                this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                if (this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty()) break;
                this.field_70163_u += 1.0;
            }
            this.field_70179_y = 0.0;
            this.field_70181_x = 0.0;
            this.field_70159_w = 0.0;
            this.field_70125_A = 0.0f;
        }
    }

    public void func_70106_y() {
        this.field_70128_L = true;
    }

    public void func_70105_a(float f, float f2) {
        float f3;
        if (f != this.field_70130_N || f2 != this.field_70131_O) {
            f3 = this.field_70130_N;
            this.field_70130_N = f;
            this.field_70131_O = f2;
            this.field_70121_D._e = this.field_70121_D._b + (double)this.field_70130_N;
            this.field_70121_D._g = this.field_70121_D._d + (double)this.field_70130_N;
            this.field_70121_D._f = this.field_70121_D._c + (double)this.field_70131_O;
            if (this.field_70130_N > f3 && !this.field_70148_d && !this.field_70170_p.field_72995_K) {
                this.func_70091_d(f3 - this.field_70130_N, 0.0, f3 - this.field_70130_N);
            }
        }
        this.field_70168_am = (double)(f3 = f % 2.0f) < 0.375 ? ugqi._a : ((double)f3 < 0.75 ? ugqi._b : ((double)f3 < 1.0 ? ugqi._c : ((double)f3 < 1.375 ? ugqi._d : ((double)f3 < 1.75 ? ugqi._e : ugqi._f))));
    }

    public void func_70101_b(float f, float f2) {
        this.field_70177_z = f % 360.0f;
        this.field_70125_A = f2 % 360.0f;
    }

    public void func_70107_b(double d, double d2, double d3) {
        this.field_70165_t = d;
        this.field_70163_u = d2;
        this.field_70161_v = d3;
        float f = this.field_70130_N / 2.0f;
        float f2 = this.field_70131_O;
        this.field_70121_D._b(d - (double)f, d2 - (double)this.field_70129_M + (double)this.field_70139_V, d3 - (double)f, d + (double)f, d2 - (double)this.field_70129_M + (double)this.field_70139_V + (double)f2, d3 + (double)f);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_70082_c(float f, float f2) {
        float f3 = this.field_70125_A;
        float f4 = this.field_70177_z;
        this.field_70177_z = (float)((double)this.field_70177_z + (double)f * 0.15);
        this.field_70125_A = (float)((double)this.field_70125_A - (double)f2 * 0.15);
        if (this.field_70125_A < -90.0f) {
            this.field_70125_A = -90.0f;
        }
        if (this.field_70125_A > 90.0f) {
            this.field_70125_A = 90.0f;
        }
        this.field_70127_C += this.field_70125_A - f3;
        this.field_70126_B += this.field_70177_z - f4;
    }

    public void func_70071_h_() {
        this.func_70030_z();
    }

    public void func_70030_z() {
        int n;
        int n2;
        int n3;
        int n4;
        this.field_70170_p.field_72984_F._a("entityBaseTick");
        if (this.field_70154_o != null && this.field_70154_o.field_70128_L) {
            this.field_70154_o = null;
        }
        this.field_70141_P = this.field_70140_Q;
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70127_C = this.field_70125_A;
        this.field_70126_B = this.field_70177_z;
        if (!this.field_70170_p.field_72995_K && this.field_70170_p instanceof yfgy) {
            this.field_70170_p.field_72984_F._a("portal");
            dzfd dzfd2 = ((yfgy)this.field_70170_p).func_73046_m();
            n4 = this.func_82145_z();
            if (this.field_71087_bX) {
                if (dzfd2._E()) {
                    if (this.field_70154_o == null && this.field_82153_h++ >= n4) {
                        this.field_82153_h = n4;
                        this.field_71088_bW = this.func_82147_ab();
                        n3 = this.field_70170_p.field_73011_w._i == -1 ? 0 : -1;
                        this.func_71027_c(n3);
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
        if (this.func_70051_ag() && !this.func_70090_H() && (n2 = this.field_70170_p.func_72798_a(n = sajh._c(this.field_70165_t), n4 = sajh._c(this.field_70163_u - (double)0.2f - (double)this.field_70129_M), n3 = sajh._c(this.field_70161_v))) > 0) {
            this.field_70170_p.func_72869_a("tilecrack_" + n2 + "_" + this.field_70170_p.func_72805_g(n, n4, n3), this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - 0.5) * (double)this.field_70130_N, this.field_70121_D._c + 0.1, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - 0.5) * (double)this.field_70130_N, -this.field_70159_w * 4.0, 1.5, -this.field_70179_y * 4.0);
        }
        this.func_70072_I();
        if (this.field_70170_p.field_72995_K) {
            this.field_70151_c = 0;
        } else if (this.field_70151_c > 0) {
            if (this.field_70178_ae) {
                this.field_70151_c -= 4;
                if (this.field_70151_c < 0) {
                    this.field_70151_c = 0;
                }
            } else {
                if (this.field_70151_c % 20 == 0) {
                    this.func_70097_a(jxtc.field_76370_b, 1.0f);
                }
                --this.field_70151_c;
            }
        }
        if (this.func_70058_J()) {
            this.func_70044_A();
            this.field_70143_R *= 0.5f;
        }
        if (this.field_70163_u < -64.0) {
            this.func_70076_C();
        }
        if (!this.field_70170_p.field_72995_K) {
            this.func_70052_a(0, this.field_70151_c > 0);
        }
        this.field_70148_d = false;
        this.field_70170_p.field_72984_F._b();
    }

    public int func_82145_z() {
        return 0;
    }

    public void func_70044_A() {
        if (!this.field_70178_ae) {
            this.func_70097_a(jxtc.field_76371_c, 4.0f);
            this.func_70015_d(15);
        }
    }

    public void func_70015_d(int n) {
        int n2 = n * 20;
        if (this.field_70151_c < (n2 = igdi._a(this, n2))) {
            this.field_70151_c = n2;
        }
    }

    public void func_70066_B() {
        this.field_70151_c = 0;
    }

    public void func_70076_C() {
        this.func_70106_y();
    }

    public boolean func_70038_c(double d, double d2, double d3) {
        net.minecraft.util.eidj eidj2 = this.field_70121_D._c(d, d2, d3);
        List list2 = this.field_70170_p.func_72945_a(this, eidj2);
        return !list2.isEmpty() ? false : !this.field_70170_p.func_72953_d(eidj2);
    }

    public void func_70091_d(double d, double d2, double d3) {
        if (this.field_70145_X) {
            this.field_70121_D._d(d, d2, d3);
            this.field_70165_t = (this.field_70121_D._b + this.field_70121_D._e) / 2.0;
            this.field_70163_u = this.field_70121_D._c + (double)this.field_70129_M - (double)this.field_70139_V;
            this.field_70161_v = (this.field_70121_D._d + this.field_70121_D._g) / 2.0;
        } else {
            int n;
            double d4;
            double d5;
            double d6;
            int n2;
            int n3;
            boolean bl;
            this.field_70170_p.field_72984_F._a("move");
            this.field_70139_V *= 0.4f;
            double d7 = this.field_70165_t;
            double d8 = this.field_70163_u;
            double d9 = this.field_70161_v;
            if (this.field_70134_J) {
                this.field_70134_J = false;
                d *= 0.25;
                d2 *= (double)0.05f;
                d3 *= 0.25;
                this.field_70159_w = 0.0;
                this.field_70181_x = 0.0;
                this.field_70179_y = 0.0;
            }
            double d10 = d;
            double d11 = d2;
            double d12 = d3;
            net.minecraft.util.eidj eidj2 = this.field_70121_D._c();
            boolean bl2 = bl = this.field_70122_E && this.func_70093_af() && this instanceof EntityPlayer;
            if (bl) {
                double d13 = 0.05;
                while (d != 0.0 && this.field_70170_p.func_72945_a(this, this.field_70121_D._c(d, -1.0, 0.0)).isEmpty()) {
                    d = d < d13 && d >= -d13 ? 0.0 : (d > 0.0 ? (d -= d13) : (d += d13));
                    d10 = d;
                }
                while (d3 != 0.0 && this.field_70170_p.func_72945_a(this, this.field_70121_D._c(0.0, -1.0, d3)).isEmpty()) {
                    d3 = d3 < d13 && d3 >= -d13 ? 0.0 : (d3 > 0.0 ? (d3 -= d13) : (d3 += d13));
                    d12 = d3;
                }
                while (d != 0.0 && d3 != 0.0 && this.field_70170_p.func_72945_a(this, this.field_70121_D._c(d, -1.0, d3)).isEmpty()) {
                    d = d < d13 && d >= -d13 ? 0.0 : (d > 0.0 ? (d -= d13) : (d += d13));
                    d3 = d3 < d13 && d3 >= -d13 ? 0.0 : (d3 > 0.0 ? (d3 -= d13) : (d3 += d13));
                    d10 = d;
                    d12 = d3;
                }
            }
            List list2 = this.field_70170_p.func_72945_a(this, this.field_70121_D._a(d, d2, d3));
            for (n3 = 0; n3 < list2.size(); ++n3) {
                d2 = ((net.minecraft.util.eidj)list2.get(n3))._b(this.field_70121_D, d2);
            }
            this.field_70121_D._d(0.0, d2, 0.0);
            if (!this.field_70135_K && d11 != d2) {
                d3 = 0.0;
                d2 = 0.0;
                d = 0.0;
            }
            n3 = this.field_70122_E || d11 != d2 && d11 < 0.0 ? 1 : 0;
            for (n2 = 0; n2 < list2.size(); ++n2) {
                d = ((net.minecraft.util.eidj)list2.get(n2))._a(this.field_70121_D, d);
            }
            this.field_70121_D._d(d, 0.0, 0.0);
            if (!this.field_70135_K && d10 != d) {
                d3 = 0.0;
                d2 = 0.0;
                d = 0.0;
            }
            for (n2 = 0; n2 < list2.size(); ++n2) {
                d3 = ((net.minecraft.util.eidj)list2.get(n2))._c(this.field_70121_D, d3);
            }
            this.field_70121_D._d(0.0, 0.0, d3);
            if (!this.field_70135_K && d12 != d3) {
                d3 = 0.0;
                d2 = 0.0;
                d = 0.0;
            }
            if (this.field_70138_W > 0.0f && n3 != 0 && (bl || this.field_70139_V < 0.05f) && (d10 != d || d12 != d3)) {
                d6 = d;
                d5 = d2;
                d4 = d3;
                d = d10;
                d2 = this.field_70138_W;
                d3 = d12;
                net.minecraft.util.eidj eidj3 = this.field_70121_D._c();
                this.field_70121_D._c(eidj2);
                list2 = this.field_70170_p.func_72945_a(this, this.field_70121_D._a(d10, d2, d12));
                for (n = 0; n < list2.size(); ++n) {
                    d2 = ((net.minecraft.util.eidj)list2.get(n))._b(this.field_70121_D, d2);
                }
                this.field_70121_D._d(0.0, d2, 0.0);
                if (!this.field_70135_K && d11 != d2) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                }
                for (n = 0; n < list2.size(); ++n) {
                    d = ((net.minecraft.util.eidj)list2.get(n))._a(this.field_70121_D, d);
                }
                this.field_70121_D._d(d, 0.0, 0.0);
                if (!this.field_70135_K && d10 != d) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                }
                for (n = 0; n < list2.size(); ++n) {
                    d3 = ((net.minecraft.util.eidj)list2.get(n))._c(this.field_70121_D, d3);
                }
                this.field_70121_D._d(0.0, 0.0, d3);
                if (!this.field_70135_K && d12 != d3) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                }
                if (!this.field_70135_K && d11 != d2) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                } else {
                    d2 = -this.field_70138_W;
                    for (n = 0; n < list2.size(); ++n) {
                        d2 = ((net.minecraft.util.eidj)list2.get(n))._b(this.field_70121_D, d2);
                    }
                    this.field_70121_D._d(0.0, d2, 0.0);
                }
                if (d6 * d6 + d4 * d4 >= d * d + d3 * d3) {
                    d = d6;
                    d2 = d5;
                    d3 = d4;
                    this.field_70121_D._c(eidj3);
                }
            }
            this.field_70170_p.field_72984_F._b();
            this.field_70170_p.field_72984_F._a("rest");
            this.field_70165_t = (this.field_70121_D._b + this.field_70121_D._e) / 2.0;
            this.field_70163_u = this.field_70121_D._c + (double)this.field_70129_M - (double)this.field_70139_V;
            this.field_70161_v = (this.field_70121_D._d + this.field_70121_D._g) / 2.0;
            this.field_70123_F = d10 != d || d12 != d3;
            this.field_70124_G = d11 != d2;
            this.field_70122_E = d11 != d2 && d11 < 0.0;
            this.field_70132_H = this.field_70123_F || this.field_70124_G;
            this.func_70064_a(d2, this.field_70122_E);
            if (d10 != d) {
                this.field_70159_w = 0.0;
            }
            if (d11 != d2) {
                this.field_70181_x = 0.0;
            }
            if (d12 != d3) {
                this.field_70179_y = 0.0;
            }
            d6 = this.field_70165_t - d7;
            d5 = this.field_70163_u - d8;
            d4 = this.field_70161_v - d9;
            if (this.func_70041_e_() && !bl && this.field_70154_o == null) {
                int n4;
                int n5;
                int n6 = sajh._c(this.field_70165_t);
                int n7 = this.field_70170_p.func_72798_a(n6, n = sajh._c(this.field_70163_u - (double)0.2f - (double)this.field_70129_M), n5 = sajh._c(this.field_70161_v));
                if (n7 == 0 && ((n4 = this.field_70170_p.func_85175_e(n6, n - 1, n5)) == 11 || n4 == 32 || n4 == 21)) {
                    n7 = this.field_70170_p.func_72798_a(n6, n - 1, n5);
                }
                if (n7 != twgu.field_72055_aF.field_71990_ca) {
                    d5 = 0.0;
                }
                this.field_70140_Q = (float)((double)this.field_70140_Q + (double)sajh._a(d6 * d6 + d4 * d4) * 0.6);
                this.field_82151_R = (float)((double)this.field_82151_R + (double)sajh._a(d6 * d6 + d5 * d5 + d4 * d4) * 0.6);
                if (this.field_82151_R > (float)this.field_70150_b && n7 > 0) {
                    this.field_70150_b = (int)this.field_82151_R + 1;
                    if (this.func_70090_H()) {
                        float f = sajh._a(this.field_70159_w * this.field_70159_w * (double)0.2f + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * (double)0.2f) * 0.35f;
                        if (f > 1.0f) {
                            f = 1.0f;
                        }
                        this.func_85030_a("liquid.swim", f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4f);
                    }
                    this.func_70036_a(n6, n, n5, n7);
                    twgu.field_71973_m[n7].func_71891_b(this.field_70170_p, n6, n, n5, this);
                }
            }
            try {
                this.func_70017_D();
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.func_85055_a(throwable, "Checking entity tile collision");
                net.minecraft.crash.jxsn jxsn2 = crashReport.func_85058_a("Entity being checked for collision");
                this.func_85029_a(jxsn2);
                throw new turb(crashReport);
            }
            boolean bl3 = this.func_70026_G();
            if (this.field_70170_p.func_72978_e(this.field_70121_D._e(0.001, 0.001, 0.001))) {
                this.func_70081_e(1);
                if (!bl3) {
                    ++this.field_70151_c;
                    if (this.field_70151_c == 0) {
                        this.func_70015_d(8);
                    }
                }
            } else if (this.field_70151_c <= 0) {
                this.field_70151_c = -this.field_70174_ab;
            }
            if (bl3 && this.field_70151_c > 0) {
                this.func_85030_a("random.fizz", 0.7f, 1.6f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4f);
                this.field_70151_c = -this.field_70174_ab;
            }
            this.field_70170_p.field_72984_F._b();
        }
    }

    public void func_70017_D() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6 = sajh._c(this.field_70121_D._b + 0.001);
        if (this.field_70170_p.func_72904_c(n6, n5 = sajh._c(this.field_70121_D._c + 0.001), n4 = sajh._c(this.field_70121_D._d + 0.001), n3 = sajh._c(this.field_70121_D._e - 0.001), n2 = sajh._c(this.field_70121_D._f - 0.001), n = sajh._c(this.field_70121_D._g - 0.001))) {
            for (int i = n6; i <= n3; ++i) {
                for (int j = n5; j <= n2; ++j) {
                    for (int k = n4; k <= n; ++k) {
                        int n7 = this.field_70170_p.func_72798_a(i, j, k);
                        if (n7 <= 0) continue;
                        try {
                            twgu.field_71973_m[n7].func_71869_a(this.field_70170_p, i, j, k, this);
                            continue;
                        }
                        catch (Throwable throwable) {
                            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Colliding entity with tile");
                            net.minecraft.crash.jxsn jxsn2 = crashReport.func_85058_a("Tile being collided with");
                            net.minecraft.crash.jxsn._a(jxsn2, i, j, k, n7, this.field_70170_p.func_72805_g(i, j, k));
                            throw new turb(crashReport);
                        }
                    }
                }
            }
        }
    }

    public void func_70036_a(int n, int n2, int n3, int n4) {
        uioo uioo2 = twgu.field_71973_m[n4].field_72020_cn;
        if (this.field_70170_p.func_72798_a(n, n2 + 1, n3) == twgu.field_72037_aS.field_71990_ca) {
            uioo2 = twgu.field_72037_aS.field_72020_cn;
            this.func_85030_a(uioo2._d(), uioo2._a() * 0.15f, uioo2._b());
        } else if (!twgu.field_71973_m[n4].field_72018_cp._d()) {
            this.func_85030_a(uioo2._d(), uioo2._a() * 0.15f, uioo2._b());
        }
    }

    public void func_85030_a(String string, float f, float f2) {
        this.field_70170_p.func_72956_a(this, string, f, f2);
    }

    public boolean func_70041_e_() {
        return true;
    }

    public void func_70064_a(double d, boolean bl) {
        if (bl) {
            if (this.field_70143_R > 0.0f) {
                this.func_70069_a(this.field_70143_R);
                this.field_70143_R = 0.0f;
            }
        } else if (d < 0.0) {
            this.field_70143_R = (float)((double)this.field_70143_R - d);
        }
    }

    public net.minecraft.util.eidj func_70046_E() {
        return null;
    }

    public void func_70081_e(int n) {
        if (!this.field_70178_ae) {
            this.func_70097_a(jxtc.field_76372_a, n);
        }
    }

    public final boolean func_70045_F() {
        return this.field_70178_ae;
    }

    public void func_70069_a(float f) {
        if (this.field_70153_n != null) {
            this.field_70153_n.func_70069_a(f);
        }
    }

    public boolean func_70026_G() {
        return this.field_70171_ac || this.field_70170_p.func_72951_B(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)) || this.field_70170_p.func_72951_B(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u + (double)this.field_70131_O), sajh._c(this.field_70161_v));
    }

    public boolean func_70090_H() {
        return this.field_70171_ac;
    }

    public boolean func_70072_I() {
        if (this.field_70170_p.func_72918_a(this.field_70121_D._b(0.0, -0.4f, 0.0)._e(0.001, 0.001, 0.001), tflj._h, this)) {
            if (!this.field_70171_ac && !this.field_70148_d) {
                float f;
                float f2;
                float f3 = sajh._a(this.field_70159_w * this.field_70159_w * (double)0.2f + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * (double)0.2f) * 0.2f;
                if (f3 > 1.0f) {
                    f3 = 1.0f;
                }
                this.func_85030_a("liquid.splash", f3, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4f);
                float f4 = sajh._c(this.field_70121_D._c);
                int n = 0;
                while ((float)n < 1.0f + this.field_70130_N * 20.0f) {
                    f2 = (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.field_70130_N;
                    f = (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.field_70130_N;
                    this.field_70170_p.func_72869_a("bubble", this.field_70165_t + (double)f2, f4 + 1.0f, this.field_70161_v + (double)f, this.field_70159_w, this.field_70181_x - (double)(this.field_70146_Z.nextFloat() * 0.2f), this.field_70179_y);
                    ++n;
                }
                n = 0;
                while ((float)n < 1.0f + this.field_70130_N * 20.0f) {
                    f2 = (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.field_70130_N;
                    f = (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.field_70130_N;
                    this.field_70170_p.func_72869_a("splash", this.field_70165_t + (double)f2, f4 + 1.0f, this.field_70161_v + (double)f, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                    ++n;
                }
            }
            this.field_70143_R = 0.0f;
            this.field_70171_ac = true;
            this.field_70151_c = 0;
        } else {
            this.field_70171_ac = false;
        }
        return this.field_70171_ac;
    }

    public boolean func_70055_a(tflj tflj2) {
        int n;
        int n2;
        double d = this.field_70163_u + (double)this.func_70047_e();
        int n3 = sajh._c(this.field_70165_t);
        int n4 = this.field_70170_p.func_72798_a(n3, n2 = sajh._d(sajh._c(d)), n = sajh._c(this.field_70161_v));
        twgu twgu2 = twgu.field_71973_m[n4];
        if (twgu2 != null && twgu2.field_72018_cp == tflj2) {
            double d2 = twgu2.getFilledPercentage(this.field_70170_p, n3, n2, n);
            if (d2 < 0.0) {
                return d > (double)n2 + (1.0 - (d2 *= -1.0));
            }
            return d < (double)n2 + d2;
        }
        return false;
    }

    public float func_70047_e() {
        return 0.0f;
    }

    public boolean func_70058_J() {
        return this.field_70170_p.func_72875_a(this.field_70121_D._b(-0.1f, -0.4f, -0.1f), tflj._i);
    }

    public void func_70060_a(float f, float f2, float f3) {
        float f4 = f * f + f2 * f2;
        if (f4 >= 1.0E-4f) {
            if ((f4 = sajh._c(f4)) < 1.0f) {
                f4 = 1.0f;
            }
            f4 = f3 / f4;
            float f5 = sajh._a(this.field_70177_z * (float)Math.PI / 180.0f);
            float f6 = sajh._b(this.field_70177_z * (float)Math.PI / 180.0f);
            this.field_70159_w += (double)((f *= f4) * f6 - (f2 *= f4) * f5);
            this.field_70179_y += (double)(f2 * f6 + f * f5);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public int func_70070_b(float f) {
        int n;
        int n2 = sajh._c(this.field_70165_t);
        if (this.field_70170_p.func_72899_e(n2, 0, n = sajh._c(this.field_70161_v))) {
            double d = (this.field_70121_D._f - this.field_70121_D._c) * 0.66;
            int n3 = sajh._c(this.field_70163_u - (double)this.field_70129_M + d);
            return this.field_70170_p.func_72802_i(n2, n3, n, 0);
        }
        return 0;
    }

    public float func_70013_c(float f) {
        int n;
        int n2 = sajh._c(this.field_70165_t);
        if (this.field_70170_p.func_72899_e(n2, 0, n = sajh._c(this.field_70161_v))) {
            double d = (this.field_70121_D._f - this.field_70121_D._c) * 0.66;
            int n3 = sajh._c(this.field_70163_u - (double)this.field_70129_M + d);
            return this.field_70170_p.func_72801_o(n2, n3, n);
        }
        return 0.0f;
    }

    public void func_70029_a(ozlu ozlu2) {
        this.field_70170_p = ozlu2;
    }

    public void func_70080_a(double d, double d2, double d3, float f, float f2) {
        this.field_70169_q = this.field_70165_t = d;
        this.field_70167_r = this.field_70163_u = d2;
        this.field_70166_s = this.field_70161_v = d3;
        this.field_70126_B = this.field_70177_z = f;
        this.field_70127_C = this.field_70125_A = f2;
        this.field_70139_V = 0.0f;
        double d4 = this.field_70126_B - f;
        if (d4 < -180.0) {
            this.field_70126_B += 360.0f;
        }
        if (d4 >= 180.0) {
            this.field_70126_B -= 360.0f;
        }
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.func_70101_b(f, f2);
    }

    public void func_70012_b(double d, double d2, double d3, float f, float f2) {
        this.field_70169_q = this.field_70165_t = d;
        this.field_70142_S = this.field_70165_t;
        this.field_70167_r = this.field_70163_u = d2 + (double)this.field_70129_M;
        this.field_70137_T = this.field_70163_u;
        this.field_70166_s = this.field_70161_v = d3;
        this.field_70136_U = this.field_70161_v;
        this.field_70177_z = f;
        this.field_70125_A = f2;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }

    public float func_70032_d(Entity entity) {
        float f = (float)(this.field_70165_t - entity.field_70165_t);
        float f2 = (float)(this.field_70163_u - entity.field_70163_u);
        float f3 = (float)(this.field_70161_v - entity.field_70161_v);
        return sajh._c(f * f + f2 * f2 + f3 * f3);
    }

    public double func_70092_e(double d, double d2, double d3) {
        double d4 = this.field_70165_t - d;
        double d5 = this.field_70163_u - d2;
        double d6 = this.field_70161_v - d3;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double func_70011_f(double d, double d2, double d3) {
        double d4 = this.field_70165_t - d;
        double d5 = this.field_70163_u - d2;
        double d6 = this.field_70161_v - d3;
        return sajh._a(d4 * d4 + d5 * d5 + d6 * d6);
    }

    public double func_70068_e(Entity entity) {
        double d = this.field_70165_t - entity.field_70165_t;
        double d2 = this.field_70163_u - entity.field_70163_u;
        double d3 = this.field_70161_v - entity.field_70161_v;
        return d * d + d2 * d2 + d3 * d3;
    }

    public void func_70100_b_(EntityPlayer entityPlayer) {
    }

    public void func_70108_f(Entity entity) {
        pidb._a(this, entity);
    }

    public void func_70024_g(double d, double d2, double d3) {
        this.field_70159_w += d;
        this.field_70181_x += d2;
        this.field_70179_y += d3;
        this.field_70160_al = true;
    }

    public void func_70018_K() {
        this.field_70133_I = true;
    }

    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        this.func_70018_K();
        return false;
    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70104_M() {
        return false;
    }

    public void func_70084_c(Entity entity, int n) {
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_70102_a(ofbx ofbx2) {
        double d = this.field_70165_t - ofbx2._c;
        double d2 = this.field_70163_u - ofbx2._d;
        double d3 = this.field_70161_v - ofbx2._e;
        double d4 = d * d + d2 * d2 + d3 * d3;
        return this.func_70112_a(d4);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_70112_a(double d) {
        double d2 = this.field_70121_D._b();
        return d < (d2 *= 64.0 * this.field_70155_l) * d2;
    }

    public boolean func_98035_c(qoac qoac2) {
        String string = this.func_70022_Q();
        if (!this.field_70128_L && string != null) {
            qoac2._a("id", string);
            this.func_70109_d(qoac2);
            return true;
        }
        return false;
    }

    public boolean func_70039_c(qoac qoac2) {
        String string = this.func_70022_Q();
        if (!this.field_70128_L && string != null && this.field_70153_n == null) {
            qoac2._a("id", string);
            this.func_70109_d(qoac2);
            return true;
        }
        return false;
    }

    public void func_70109_d(qoac qoac2) {
        try {
            qoac2._a("Pos", this.func_70087_a(this.field_70165_t, this.field_70163_u + (double)this.field_70139_V, this.field_70161_v));
            qoac2._a("Motion", this.func_70087_a(this.field_70159_w, this.field_70181_x, this.field_70179_y));
            qoac2._a("Rotation", this.func_70049_a(this.field_70177_z, this.field_70125_A));
            qoac2._a("FallDistance", this.field_70143_R);
            qoac2._a("Fire", (short)this.field_70151_c);
            qoac2._a("Air", (short)this.func_70086_ai());
            qoac2._a("OnGround", this.field_70122_E);
            qoac2._a("Dimension", this.field_71093_bK);
            qoac2._a("Invulnerable", this.field_83001_bt);
            qoac2._a("PortalCooldown", this.field_71088_bW);
            qoac2._a("UUIDMost", this.field_96093_i.getMostSignificantBits());
            qoac2._a("UUIDLeast", this.field_96093_i.getLeastSignificantBits());
            if (this.customEntityData != null) {
                qoac2._a("ForgeData", this.customEntityData);
            }
            Object object = this.extendedProperties.keySet().iterator();
            while (object.hasNext()) {
                String string = object.next();
                try {
                    IExtendedEntityProperties iExtendedEntityProperties = this.extendedProperties.get(string);
                    iExtendedEntityProperties.saveNBTData(qoac2);
                }
                catch (Throwable throwable) {
                    FMLLog.severe("Failed to save extended properties for %s.  This is a mod issue.", string);
                    throwable.printStackTrace();
                }
            }
            this.func_70014_b(qoac2);
            if (this.field_70154_o != null && this.field_70154_o.func_98035_c((qoac)(object = new qoac("Riding")))) {
                qoac2._a("Riding", (huhy)object);
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Saving entity NBT");
            net.minecraft.crash.jxsn jxsn2 = crashReport.func_85058_a("Entity being saved");
            this.func_85029_a(jxsn2);
            throw new turb(crashReport);
        }
    }

    public void func_70020_e(qoac qoac2) {
        try {
            bsyv bsyv2 = qoac2._n("Pos");
            bsyv bsyv3 = qoac2._n("Motion");
            bsyv bsyv4 = qoac2._n("Rotation");
            this.field_70159_w = ((qoae)bsyv3._b((int)0))._c;
            this.field_70181_x = ((qoae)bsyv3._b((int)1))._c;
            this.field_70179_y = ((qoae)bsyv3._b((int)2))._c;
            if (Math.abs(this.field_70159_w) > 10.0) {
                this.field_70159_w = 0.0;
            }
            if (Math.abs(this.field_70181_x) > 10.0) {
                this.field_70181_x = 0.0;
            }
            if (Math.abs(this.field_70179_y) > 10.0) {
                this.field_70179_y = 0.0;
            }
            this.field_70142_S = this.field_70165_t = ((qoae)bsyv2._b((int)0))._c;
            this.field_70169_q = this.field_70165_t;
            this.field_70137_T = this.field_70163_u = ((qoae)bsyv2._b((int)1))._c;
            this.field_70167_r = this.field_70163_u;
            this.field_70136_U = this.field_70161_v = ((qoae)bsyv2._b((int)2))._c;
            this.field_70166_s = this.field_70161_v;
            this.field_70126_B = this.field_70177_z = ((jjly)bsyv4._b((int)0))._c;
            this.field_70127_C = this.field_70125_A = ((jjly)bsyv4._b((int)1))._c;
            this.field_70143_R = qoac2._h("FallDistance");
            this.field_70151_c = qoac2._e("Fire");
            this.func_70050_g(qoac2._e("Air"));
            this.field_70122_E = qoac2._o("OnGround");
            this.field_71093_bK = qoac2._f("Dimension");
            this.field_83001_bt = qoac2._o("Invulnerable");
            this.field_71088_bW = qoac2._f("PortalCooldown");
            if (qoac2._c("UUIDMost") && qoac2._c("UUIDLeast")) {
                this.field_96093_i = new UUID(qoac2._g("UUIDMost"), qoac2._g("UUIDLeast"));
            }
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
            if (qoac2._c("ForgeData")) {
                this.customEntityData = qoac2._m("ForgeData");
            }
            for (String string : this.extendedProperties.keySet()) {
                try {
                    IExtendedEntityProperties iExtendedEntityProperties = this.extendedProperties.get(string);
                    iExtendedEntityProperties.loadNBTData(qoac2);
                }
                catch (Throwable throwable) {
                    FMLLog.severe("Failed to load extended properties for %s.  This is a mod issue.", string);
                    throwable.printStackTrace();
                }
            }
            if (qoac2._c("PersistentIDMSB") && qoac2._c("PersistentIDLSB")) {
                this.field_96093_i = new UUID(qoac2._g("PersistentIDMSB"), qoac2._g("PersistentIDLSB"));
            }
            this.func_70037_a(qoac2);
            if (this.func_142008_O()) {
                this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Loading entity NBT");
            net.minecraft.crash.jxsn jxsn2 = crashReport.func_85058_a("Entity being loaded");
            this.func_85029_a(jxsn2);
            throw new turb(crashReport);
        }
    }

    public boolean func_142008_O() {
        return true;
    }

    public final String func_70022_Q() {
        return jgro._b(this);
    }

    public abstract void func_70037_a(qoac var1);

    public abstract void func_70014_b(qoac var1);

    public void func_110123_P() {
    }

    public bsyv func_70087_a(double ... dArray) {
        bsyv bsyv2 = new bsyv();
        double[] dArray2 = dArray;
        int n = dArray.length;
        for (int i = 0; i < n; ++i) {
            double d = dArray2[i];
            bsyv2._a(new qoae(null, d));
        }
        return bsyv2;
    }

    public bsyv func_70049_a(float ... fArray) {
        bsyv bsyv2 = new bsyv();
        float[] fArray2 = fArray;
        int n = fArray.length;
        for (int i = 0; i < n; ++i) {
            float f = fArray2[i];
            bsyv2._a(new jjly(null, f));
        }
        return bsyv2;
    }

    @SideOnly(value=Side.CLIENT)
    public float func_70053_R() {
        return this.field_70131_O / 2.0f;
    }

    public EntityItem func_70025_b(int n, int n2) {
        return this.func_70054_a(n, n2, 0.0f);
    }

    public EntityItem func_70054_a(int n, int n2, float f) {
        return this.func_70099_a(new cvzo(n, n2, 0), f);
    }

    public EntityItem func_70099_a(cvzo cvzo2, float f) {
        if (cvzo2._b == 0) {
            return null;
        }
        EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)f, this.field_70161_v, cvzo2);
        entityItem.field_70293_c = 10;
        if (this.captureDrops) {
            this.capturedDrops.add(entityItem);
        } else {
            this.field_70170_p.func_72838_d(entityItem);
        }
        return entityItem;
    }

    public boolean func_70089_S() {
        return !this.field_70128_L;
    }

    public boolean func_70094_T() {
        for (int i = 0; i < 8; ++i) {
            int n;
            int n2;
            float f = ((float)((i >> 0) % 2) - 0.5f) * this.field_70130_N * 0.8f;
            float f2 = ((float)((i >> 1) % 2) - 0.5f) * 0.1f;
            float f3 = ((float)((i >> 2) % 2) - 0.5f) * this.field_70130_N * 0.8f;
            int n3 = sajh._c(this.field_70165_t + (double)f);
            if (!this.field_70170_p.func_72809_s(n3, n2 = sajh._c(this.field_70163_u + (double)this.func_70047_e() + (double)f2), n = sajh._c(this.field_70161_v + (double)f3))) continue;
            return true;
        }
        return false;
    }

    public boolean func_130002_c(EntityPlayer entityPlayer) {
        return false;
    }

    public net.minecraft.util.eidj func_70114_g(Entity entity) {
        return null;
    }

    public void func_70098_U() {
        if (this.field_70154_o.field_70128_L) {
            this.field_70154_o = null;
        } else {
            this.field_70159_w = 0.0;
            this.field_70181_x = 0.0;
            this.field_70179_y = 0.0;
            this.func_70071_h_();
            if (this.field_70154_o != null) {
                this.field_70154_o.func_70043_V();
                this.field_70147_f += (double)(this.field_70154_o.field_70177_z - this.field_70154_o.field_70126_B);
                this.field_70149_e += (double)(this.field_70154_o.field_70125_A - this.field_70154_o.field_70127_C);
                while (this.field_70147_f >= 180.0) {
                    this.field_70147_f -= 360.0;
                }
                while (this.field_70147_f < -180.0) {
                    this.field_70147_f += 360.0;
                }
                while (this.field_70149_e >= 180.0) {
                    this.field_70149_e -= 360.0;
                }
                while (this.field_70149_e < -180.0) {
                    this.field_70149_e += 360.0;
                }
                double d = this.field_70147_f * 0.5;
                double d2 = this.field_70149_e * 0.5;
                float f = 10.0f;
                if (d > (double)f) {
                    d = f;
                }
                if (d < (double)(-f)) {
                    d = -f;
                }
                if (d2 > (double)f) {
                    d2 = f;
                }
                if (d2 < (double)(-f)) {
                    d2 = -f;
                }
                this.field_70147_f -= d;
                this.field_70149_e -= d2;
            }
        }
    }

    public void func_70043_V() {
        if (this.field_70153_n != null) {
            this.field_70153_n.func_70107_b(this.field_70165_t, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v);
        }
    }

    public double func_70033_W() {
        return this.field_70129_M;
    }

    public double func_70042_X() {
        return (double)this.field_70131_O * 0.75;
    }

    public void func_70078_a(Entity entity) {
        this.field_70149_e = 0.0;
        this.field_70147_f = 0.0;
        if (entity == null) {
            if (this.field_70154_o != null) {
                this.func_70012_b(this.field_70154_o.field_70165_t, this.field_70154_o.field_70121_D._c + (double)this.field_70154_o.field_70131_O, this.field_70154_o.field_70161_v, this.field_70177_z, this.field_70125_A);
                this.field_70154_o.field_70153_n = null;
            }
            this.field_70154_o = null;
        } else {
            if (this.field_70154_o != null) {
                this.field_70154_o.field_70153_n = null;
            }
            this.field_70154_o = entity;
            entity.field_70153_n = this;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
        this.func_70107_b(d, d2, d3);
        this.func_70101_b(f, f2);
        List list2 = this.field_70170_p.func_72945_a(this, this.field_70121_D._e(0.03125, 0.0, 0.03125));
        if (!list2.isEmpty()) {
            double d4 = 0.0;
            for (int i = 0; i < list2.size(); ++i) {
                net.minecraft.util.eidj eidj2 = (net.minecraft.util.eidj)list2.get(i);
                if (!(eidj2._f > d4)) continue;
                d4 = eidj2._f;
            }
            this.func_70107_b(d, d2 += d4 - this.field_70121_D._c, d3);
        }
    }

    public float func_70111_Y() {
        return 0.1f;
    }

    public ofbx func_70040_Z() {
        return null;
    }

    public void func_70063_aa() {
        if (this.field_71088_bW > 0) {
            this.field_71088_bW = this.func_82147_ab();
        } else {
            double d = this.field_70169_q - this.field_70165_t;
            double d2 = this.field_70166_s - this.field_70161_v;
            if (!this.field_70170_p.field_72995_K && !this.field_71087_bX) {
                this.field_82152_aq = ugqx._a(d, d2);
            }
            this.field_71087_bX = true;
        }
    }

    public int func_82147_ab() {
        return 900;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_70016_h(double d, double d2, double d3) {
        this.field_70159_w = d;
        this.field_70181_x = d2;
        this.field_70179_y = d3;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_70103_a(byte by) {
    }

    @SideOnly(value=Side.CLIENT)
    public void func_70057_ab() {
    }

    public cvzo[] func_70035_c() {
        return null;
    }

    public void func_70062_b(int n, cvzo cvzo2) {
    }

    public boolean func_70027_ad() {
        return !this.field_70178_ae && (this.field_70151_c > 0 || this.func_70083_f(0));
    }

    public boolean func_70115_ae() {
        return this.field_70154_o != null && this.field_70154_o.shouldRiderSit();
    }

    public boolean func_70093_af() {
        return this.func_70083_f(1);
    }

    public void func_70095_a(boolean bl) {
        this.func_70052_a(1, bl);
    }

    public boolean func_70051_ag() {
        return this.func_70083_f(3);
    }

    public void func_70031_b(boolean bl) {
        this.func_70052_a(3, bl);
    }

    public boolean func_82150_aj() {
        return this.func_70083_f(5);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_98034_c(EntityPlayer entityPlayer) {
        return this.func_82150_aj();
    }

    public void func_82142_c(boolean bl) {
        this.func_70052_a(5, bl);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_70113_ah() {
        return this.func_70083_f(4);
    }

    public void func_70019_c(boolean bl) {
        this.func_70052_a(4, bl);
    }

    public boolean func_70083_f(int n) {
        return (this.field_70180_af._a(0) & 1 << n) != 0;
    }

    public void func_70052_a(int n, boolean bl) {
        byte by = this.field_70180_af._a(0);
        if (bl) {
            this.field_70180_af._b(0, (byte)(by | 1 << n));
        } else {
            this.field_70180_af._b(0, (byte)(by & ~(1 << n)));
        }
    }

    public int func_70086_ai() {
        return this.field_70180_af._b(1);
    }

    public void func_70050_g(int n) {
        this.field_70180_af._b(1, (short)n);
    }

    public void func_70077_a(EntityLightningBolt entityLightningBolt) {
        this.func_70081_e(5);
        ++this.field_70151_c;
        if (this.field_70151_c == 0) {
            this.func_70015_d(8);
        }
    }

    public void func_70074_a(EntityLivingBase entityLivingBase) {
    }

    public boolean func_70048_i(double d, double d2, double d3) {
        int n = sajh._c(d);
        int n2 = sajh._c(d2);
        int n3 = sajh._c(d3);
        double d4 = d - (double)n;
        double d5 = d2 - (double)n2;
        double d6 = d3 - (double)n3;
        List list2 = this.field_70170_p.func_72840_a(this.field_70121_D);
        if (list2.isEmpty() && !this.field_70170_p.func_85174_u(n, n2, n3)) {
            return false;
        }
        boolean bl = !this.field_70170_p.func_85174_u(n - 1, n2, n3);
        boolean bl2 = !this.field_70170_p.func_85174_u(n + 1, n2, n3);
        boolean bl3 = !this.field_70170_p.func_85174_u(n, n2 - 1, n3);
        boolean bl4 = !this.field_70170_p.func_85174_u(n, n2 + 1, n3);
        boolean bl5 = !this.field_70170_p.func_85174_u(n, n2, n3 - 1);
        boolean bl6 = !this.field_70170_p.func_85174_u(n, n2, n3 + 1);
        int n4 = 3;
        double d7 = 9999.0;
        if (bl && d4 < d7) {
            d7 = d4;
            n4 = 0;
        }
        if (bl2 && 1.0 - d4 < d7) {
            d7 = 1.0 - d4;
            n4 = 1;
        }
        if (bl4 && 1.0 - d5 < d7) {
            d7 = 1.0 - d5;
            n4 = 3;
        }
        if (bl5 && d6 < d7) {
            d7 = d6;
            n4 = 4;
        }
        if (bl6 && 1.0 - d6 < d7) {
            d7 = 1.0 - d6;
            n4 = 5;
        }
        float f = this.field_70146_Z.nextFloat() * 0.2f + 0.1f;
        if (n4 == 0) {
            this.field_70159_w = -f;
        }
        if (n4 == 1) {
            this.field_70159_w = f;
        }
        if (n4 == 2) {
            this.field_70181_x = -f;
        }
        if (n4 == 3) {
            this.field_70181_x = f;
        }
        if (n4 == 4) {
            this.field_70179_y = -f;
        }
        if (n4 == 5) {
            this.field_70179_y = f;
        }
        return true;
    }

    public void func_70110_aj() {
        this.field_70134_J = true;
        this.field_70143_R = 0.0f;
    }

    public String func_70023_ak() {
        String string = jgro._b(this);
        if (string == null) {
            string = "generic";
        }
        return tdpx._a("entity." + string + ".name");
    }

    public Entity[] func_70021_al() {
        return null;
    }

    public boolean func_70028_i(Entity entity) {
        return this == entity;
    }

    public float func_70079_am() {
        return 0.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_70034_d(float f) {
    }

    public boolean func_70075_an() {
        return true;
    }

    public boolean func_85031_j(Entity entity) {
        return false;
    }

    public String toString() {
        return String.format("%s['%s'/%d, l='%s', x=%.2f, y=%.2f, z=%.2f]", this.getClass().getSimpleName(), this.func_70023_ak(), this.field_70157_k, this.field_70170_p == null ? "~NULL~" : this.field_70170_p.func_72912_H()._k(), this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }

    public boolean func_85032_ar() {
        return this.field_83001_bt;
    }

    public void func_82149_j(Entity entity) {
        this.func_70012_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.field_70177_z, entity.field_70125_A);
    }

    public void func_82141_a(Entity entity, boolean bl) {
        qoac qoac2 = new qoac();
        entity.func_70109_d(qoac2);
        this.func_70020_e(qoac2);
        this.field_71088_bW = entity.field_71088_bW;
        this.field_82152_aq = entity.field_82152_aq;
    }

    public void func_71027_c(int n) {
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
            this.field_70170_p.field_72984_F._a("changeDimension");
            dzfd dzfd2 = dzfd._I();
            int n2 = this.field_71093_bK;
            yfgy yfgy2 = dzfd2._a(n2);
            yfgy yfgy3 = dzfd2._a(n);
            this.field_71093_bK = n;
            if (n2 == 1 && n == 1) {
                yfgy3 = dzfd2._a(0);
                this.field_71093_bK = 0;
            }
            this.field_70170_p.func_72900_e(this);
            this.field_70128_L = false;
            this.field_70170_p.field_72984_F._a("reposition");
            dzfd2.__ag()._a(this, n2, yfgy2, yfgy3);
            this.field_70170_p.field_72984_F._c("reloading");
            Entity entity = jgro._a(jgro._b(this), (ozlu)yfgy3);
            if (entity != null) {
                entity.func_82141_a(this, true);
                if (n2 == 1 && n == 1) {
                    zwaw zwaw2 = yfgy3.func_72861_E();
                    zwaw2._b = this.field_70170_p.func_72825_h(zwaw2._a, zwaw2._c);
                    entity.func_70012_b(zwaw2._a, zwaw2._b, zwaw2._c, entity.field_70177_z, entity.field_70125_A);
                }
                yfgy3.func_72838_d(entity);
            }
            this.field_70128_L = true;
            this.field_70170_p.field_72984_F._b();
            yfgy2.func_82742_i();
            yfgy3.func_82742_i();
            this.field_70170_p.field_72984_F._b();
        }
    }

    public float func_82146_a(elkd elkd2, ozlu ozlu2, int n, int n2, int n3, twgu twgu2) {
        return twgu2.getExplosionResistance(this, ozlu2, n, n2, n3, this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v);
    }

    public boolean func_96091_a(elkd elkd2, ozlu ozlu2, int n, int n2, int n3, int n4, float f) {
        return true;
    }

    public int func_82143_as() {
        return 3;
    }

    public int func_82148_at() {
        return this.field_82152_aq;
    }

    public boolean func_82144_au() {
        return false;
    }

    public void func_85029_a(net.minecraft.crash.jxsn jxsn2) {
        jxsn2._a("Entity Type", new eidj(this));
        jxsn2._a("Entity ID", this.field_70157_k);
        jxsn2._a("Entity Name", new kjui(this));
        jxsn2._a("Entity's Exact location", String.format("%.2f, %.2f, %.2f", this.field_70165_t, this.field_70163_u, this.field_70161_v));
        jxsn2._a("Entity's Block location", net.minecraft.crash.jxsn._a(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)));
        jxsn2._a("Entity's Momentum", String.format("%.2f, %.2f, %.2f", this.field_70159_w, this.field_70181_x, this.field_70179_y));
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_90999_ad() {
        return this.func_70027_ad();
    }

    public UUID func_110124_au() {
        return this.field_96093_i;
    }

    public boolean func_96092_aw() {
        return true;
    }

    public String func_96090_ax() {
        return this.func_70023_ak();
    }

    public qoac getEntityData() {
        if (this.customEntityData == null) {
            this.customEntityData = new qoac();
        }
        return this.customEntityData;
    }

    public boolean shouldRiderSit() {
        return true;
    }

    public cvzo getPickedResult(hank hank2) {
        if (this instanceof EntityPainting) {
            return new cvzo(tgdv.field_77780_as);
        }
        if (this instanceof EntityMinecart) {
            return ((EntityMinecart)this).getCartItem();
        }
        if (this instanceof EntityBoat) {
            return new cvzo(tgdv.field_77769_aE);
        }
        if (this instanceof EntityItemFrame) {
            cvzo cvzo2 = ((EntityItemFrame)this).func_82335_i();
            if (cvzo2 == null) {
                return new cvzo(tgdv.field_82802_bI);
            }
            return cvzo2._l();
        }
        if (this instanceof EntityLeashKnot) {
            return new cvzo(tgdv.field_111214_ch);
        }
        int n = jgro._a(this);
        if (n > 0 && jgro._f.containsKey(n)) {
            return new cvzo(tgdv.field_77815_bC, 1, n);
        }
        return null;
    }

    public UUID getPersistentID() {
        return this.field_96093_i;
    }

    public final void resetEntityId() {
        this.field_70157_k = field_70152_a++;
    }

    public boolean shouldRenderInPass(int n) {
        return n == 0;
    }

    public boolean isCreatureType(jxsn jxsn2, boolean bl) {
        return jxsn2._a().isAssignableFrom(this.getClass());
    }

    public String registerExtendedProperties(String string, IExtendedEntityProperties iExtendedEntityProperties) {
        if (string == null) {
            FMLLog.warning("Someone is attempting to register extended properties using a null identifier.  This is not allowed.  Aborting.  This may have caused instability.", new Object[0]);
            return "";
        }
        if (iExtendedEntityProperties == null) {
            FMLLog.warning("Someone is attempting to register null extended properties.  This is not allowed.  Aborting.  This may have caused instability.", new Object[0]);
            return "";
        }
        String string2 = string;
        int n = 1;
        while (this.extendedProperties.containsKey(string)) {
            string = String.format("%s%d", string2, n++);
        }
        if (string2 != string) {
            FMLLog.info("An attempt was made to register exended properties using an existing key.  The duplicate identifier (%s) has been remapped to %s.", string2, string);
        }
        this.extendedProperties.put(string, iExtendedEntityProperties);
        return string;
    }

    public IExtendedEntityProperties getExtendedProperties(String string) {
        return this.extendedProperties.get(string);
    }

    public boolean canRiderInteract() {
        return false;
    }

    public boolean shouldDismountInWater(Entity entity) {
        return this instanceof EntityLivingBase;
    }

    @Override
    public int getColorBetterBlood() {
        if (this.colorBetterBlood == 0) {
            this.colorBetterBlood = BetterBloodRenderer.getColorBetterBlood(this.getClass());
        }
        return this.colorBetterBlood;
    }
}

