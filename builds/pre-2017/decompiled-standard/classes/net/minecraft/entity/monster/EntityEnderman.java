/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxsn;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.vjta;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityEnderman
extends EntityMob {
    public static final UUID field_110192_bp = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    public static final xson field_110193_bq = new xson(field_110192_bp, "Attacking speed boost", 6.2f, 0)._a(false);
    public static boolean[] field_70827_d = new boolean[256];
    public int field_70828_e;
    public int field_70826_g;
    public Entity field_110194_bu;
    public boolean field_104003_g;

    public EntityEnderman(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.6f, 2.9f);
        this.field_70138_W = 1.0f;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(40.0);
        this.func_110148_a(sajz._d)._a(0.3f);
        this.func_110148_a(sajz._e)._a(7.0);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, new Byte(0));
        this.field_70180_af._a(17, new Byte(0));
        this.field_70180_af._a(18, new Byte(0));
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("carried", (short)this.func_70822_p());
        qoac2._a("carriedData", (short)this.func_70824_q());
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.func_70818_a(qoac2._e("carried"));
        this.func_70817_b(qoac2._e("carriedData"));
    }

    @Override
    public Entity func_70782_k() {
        EntityPlayer entityPlayer = this.field_70170_p.func_72856_b(this, 64.0);
        if (entityPlayer != null) {
            if (this.func_70821_d(entityPlayer)) {
                this.field_104003_g = true;
                if (this.field_70826_g == 0) {
                    this.field_70170_p.func_72956_a(entityPlayer, "mob.endermen.stare", 1.0f, 1.0f);
                }
                if (this.field_70826_g++ == 5) {
                    this.field_70826_g = 0;
                    this.func_70819_e(true);
                    return entityPlayer;
                }
            } else {
                this.field_70826_g = 0;
            }
        }
        return null;
    }

    public boolean func_70821_d(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.field_71071_by._b[3];
        if (cvzo2 != null && cvzo2._d == twgu.field_72061_ba.field_71990_ca) {
            return false;
        }
        ofbx ofbx2 = entityPlayer.func_70676_i(1.0f)._a();
        ofbx ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t - entityPlayer.field_70165_t, this.field_70121_D._c + (double)(this.field_70131_O / 2.0f) - (entityPlayer.field_70163_u + (double)entityPlayer.func_70047_e()), this.field_70161_v - entityPlayer.field_70161_v);
        double d = ofbx3._b();
        double d2 = ofbx2._b(ofbx3 = ofbx3._a());
        return d2 > 1.0 - 0.025 / d ? entityPlayer.func_70685_l(this) : false;
    }

    @Override
    public void func_70636_d() {
        float f;
        if (this.func_70026_G()) {
            this.func_70097_a(jxtc.field_76369_e, 1.0f);
        }
        if (this.field_110194_bu != this.field_70789_a) {
            hubf hubf2 = this.func_110148_a(sajz._d);
            hubf2._b(field_110193_bq);
            if (this.field_70789_a != null) {
                hubf2._a(field_110193_bq);
            }
        }
        this.field_110194_bu = this.field_70789_a;
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K()._b("mobGriefing")) {
            int n;
            int n2;
            int n3;
            if (this.func_70822_p() == 0) {
                int n4;
                if (this.field_70146_Z.nextInt(20) == 0 && field_70827_d[n3 = this.field_70170_p.func_72798_a(n4 = sajh._c(this.field_70165_t - 2.0 + this.field_70146_Z.nextDouble() * 4.0), n2 = sajh._c(this.field_70163_u + this.field_70146_Z.nextDouble() * 3.0), n = sajh._c(this.field_70161_v - 2.0 + this.field_70146_Z.nextDouble() * 4.0))]) {
                    this.func_70818_a(this.field_70170_p.func_72798_a(n4, n2, n));
                    this.func_70817_b(this.field_70170_p.func_72805_g(n4, n2, n));
                    this.field_70170_p.func_94575_c(n4, n2, n, 0);
                }
            } else if (this.field_70146_Z.nextInt(2000) == 0) {
                int n5 = sajh._c(this.field_70165_t - 1.0 + this.field_70146_Z.nextDouble() * 2.0);
                n2 = sajh._c(this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0);
                n = sajh._c(this.field_70161_v - 1.0 + this.field_70146_Z.nextDouble() * 2.0);
                n3 = this.field_70170_p.func_72798_a(n5, n2, n);
                int n6 = this.field_70170_p.func_72798_a(n5, n2 - 1, n);
                if (n3 == 0 && n6 > 0 && twgu.field_71973_m[n6].func_71886_c()) {
                    this.field_70170_p.func_72832_d(n5, n2, n, this.func_70822_p(), this.func_70824_q(), 3);
                    this.func_70818_a(0);
                }
            }
        }
        for (int i = 0; i < 2; ++i) {
            this.field_70170_p.func_72869_a("portal", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0);
        }
        if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K && (f = this.func_70013_c(1.0f)) > 0.5f && this.field_70170_p.func_72937_j(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)) && this.field_70146_Z.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {
            this.field_70789_a = null;
            this.func_70819_e(false);
            this.field_104003_g = false;
            this.func_70820_n();
        }
        if (this.func_70026_G() || this.func_70027_ad()) {
            this.field_70789_a = null;
            this.func_70819_e(false);
            this.field_104003_g = false;
            this.func_70820_n();
        }
        if (this.func_70823_r() && !this.field_104003_g && this.field_70146_Z.nextInt(100) == 0) {
            this.func_70819_e(false);
        }
        this.field_70703_bu = false;
        if (this.field_70789_a != null) {
            this.func_70625_a(this.field_70789_a, 100.0f, 100.0f);
        }
        if (!this.field_70170_p.field_72995_K && this.func_70089_S()) {
            if (this.field_70789_a != null) {
                if (this.field_70789_a instanceof EntityPlayer && this.func_70821_d((EntityPlayer)this.field_70789_a)) {
                    if (this.field_70789_a.func_70068_e(this) < 16.0) {
                        this.func_70820_n();
                    }
                    this.field_70828_e = 0;
                } else if (this.field_70789_a.func_70068_e(this) > 256.0 && this.field_70828_e++ >= 30 && this.func_70816_c(this.field_70789_a)) {
                    this.field_70828_e = 0;
                }
            } else {
                this.func_70819_e(false);
                this.field_70828_e = 0;
            }
        }
        super.func_70636_d();
    }

    public boolean func_70820_n() {
        double d = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * 64.0;
        double d2 = this.field_70163_u + (double)(this.field_70146_Z.nextInt(64) - 32);
        double d3 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * 64.0;
        return this.func_70825_j(d, d2, d3);
    }

    public boolean func_70816_c(Entity entity) {
        ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t - entity.field_70165_t, this.field_70121_D._c + (double)(this.field_70131_O / 2.0f) - entity.field_70163_u + (double)entity.func_70047_e(), this.field_70161_v - entity.field_70161_v);
        ofbx2 = ofbx2._a();
        double d = 16.0;
        double d2 = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * 8.0 - ofbx2._c * d;
        double d3 = this.field_70163_u + (double)(this.field_70146_Z.nextInt(16) - 8) - ofbx2._d * d;
        double d4 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * 8.0 - ofbx2._e * d;
        return this.func_70825_j(d2, d3, d4);
    }

    public boolean func_70825_j(double d, double d2, double d3) {
        int n;
        int n2;
        int n3;
        int n4;
        EnderTeleportEvent enderTeleportEvent = new EnderTeleportEvent(this, d, d2, d3, 0.0f);
        if (MinecraftForge.EVENT_BUS.post(enderTeleportEvent)) {
            return false;
        }
        double d4 = this.field_70165_t;
        double d5 = this.field_70163_u;
        double d6 = this.field_70161_v;
        this.field_70165_t = enderTeleportEvent.targetX;
        this.field_70163_u = enderTeleportEvent.targetY;
        this.field_70161_v = enderTeleportEvent.targetZ;
        boolean bl = false;
        int n5 = sajh._c(this.field_70165_t);
        if (this.field_70170_p.func_72899_e(n5, n4 = sajh._c(this.field_70163_u), n3 = sajh._c(this.field_70161_v))) {
            n2 = 0;
            while (n2 == 0 && n4 > 0) {
                n = this.field_70170_p.func_72798_a(n5, n4 - 1, n3);
                if (n != 0 && twgu.field_71973_m[n].field_72018_cp._c()) {
                    n2 = 1;
                    continue;
                }
                this.field_70163_u -= 1.0;
                --n4;
            }
            if (n2 != 0) {
                this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                if (this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D)) {
                    bl = true;
                }
            }
        }
        if (!bl) {
            this.func_70107_b(d4, d5, d6);
            return false;
        }
        n2 = 128;
        for (n = 0; n < n2; ++n) {
            double d7 = (double)n / ((double)n2 - 1.0);
            float f = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            float f3 = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            double d8 = d4 + (this.field_70165_t - d4) * d7 + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N * 2.0;
            double d9 = d5 + (this.field_70163_u - d5) * d7 + this.field_70146_Z.nextDouble() * (double)this.field_70131_O;
            double d10 = d6 + (this.field_70161_v - d6) * d7 + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N * 2.0;
            this.field_70170_p.func_72869_a("portal", d8, d9, d10, f, f2, f3);
        }
        this.field_70170_p.func_72908_a(d4, d5, d6, "mob.endermen.portal", 1.0f, 1.0f);
        this.func_85030_a("mob.endermen.portal", 1.0f, 1.0f);
        return true;
    }

    @Override
    public String func_70639_aQ() {
        return this.func_70823_r() ? "mob.endermen.scream" : "mob.endermen.idle";
    }

    @Override
    public String func_70621_aR() {
        return "mob.endermen.hit";
    }

    @Override
    public String func_70673_aS() {
        return "mob.endermen.death";
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77730_bn.field_77779_bT;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2 = this.func_70633_aT();
        if (n2 > 0) {
            int n3 = this.field_70146_Z.nextInt(2 + n);
            for (int i = 0; i < n3; ++i) {
                this.func_70025_b(n2, 1);
            }
        }
    }

    public void func_70818_a(int n) {
        this.field_70180_af._b(16, (byte)(n & 0xFF));
    }

    public int func_70822_p() {
        return this.field_70180_af._a(16);
    }

    public void func_70817_b(int n) {
        this.field_70180_af._b(17, (byte)(n & 0xFF));
    }

    public int func_70824_q() {
        return this.field_70180_af._a(17);
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        this.func_70819_e(true);
        if (jxtc2 instanceof vjta && jxtc2.func_76346_g() instanceof EntityPlayer) {
            this.field_104003_g = true;
        }
        if (jxtc2 instanceof jxsn) {
            this.field_104003_g = false;
            for (int i = 0; i < 64; ++i) {
                if (!this.func_70820_n()) continue;
                return true;
            }
            return super.func_70097_a(jxtc2, f);
        }
        return super.func_70097_a(jxtc2, f);
    }

    public boolean func_70823_r() {
        return this.field_70180_af._a(18) > 0;
    }

    public void func_70819_e(boolean bl) {
        this.field_70180_af._b(18, (byte)(bl ? 1 : 0));
    }

    static {
        EntityEnderman.field_70827_d[twgu.field_71980_u.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_71979_v.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_71939_E.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_71940_F.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_72097_ad.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_72107_ae.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_72109_af.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_72103_ag.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_72091_am.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_72038_aV.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_72041_aW.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_72061_ba.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_71997_br.field_71990_ca] = true;
        EntityEnderman.field_70827_d[twgu.field_71994_by.field_71990_ca] = true;
    }
}

