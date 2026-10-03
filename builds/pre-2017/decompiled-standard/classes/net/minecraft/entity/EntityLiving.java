/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.dwed;
import net.minecraft.entity.ai.flht;
import net.minecraft.entity.ai.idpz;
import net.minecraft.entity.ai.lmyh;
import net.minecraft.entity.ai.piet;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tupg;
import net.minecraft.entity.zwat;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;

public abstract class EntityLiving
extends EntityLivingBase {
    public int field_70757_a;
    public int field_70728_aV;
    public dwed field_70749_g;
    public lmyh field_70765_h;
    public piet field_70767_i;
    public zwat field_70762_j;
    public ujuz field_70699_by;
    public final idpz field_70714_bg;
    public final idpz field_70715_bh;
    public EntityLivingBase field_70696_bz;
    public flht field_70723_bA;
    public cvzo[] field_82182_bS = new cvzo[5];
    public float[] field_82174_bp = new float[5];
    public boolean field_82172_bs;
    public boolean field_82179_bU;
    public float field_70698_bv;
    public Entity field_70776_bF;
    public int field_70700_bx;
    public boolean field_110169_bv;
    public Entity field_110168_bw;
    public qoac field_110170_bx;

    public EntityLiving(ozlu ozlu2) {
        super(ozlu2);
        this.field_70714_bg = new idpz(ozlu2 != null && ozlu2.field_72984_F != null ? ozlu2.field_72984_F : null);
        this.field_70715_bh = new idpz(ozlu2 != null && ozlu2.field_72984_F != null ? ozlu2.field_72984_F : null);
        this.field_70749_g = new dwed(this);
        this.field_70765_h = new lmyh(this);
        this.field_70767_i = new piet(this);
        this.field_70762_j = new zwat(this);
        this.field_70699_by = new ujuz(this, ozlu2);
        this.field_70723_bA = new flht(this);
        for (int i = 0; i < this.field_82174_bp.length; ++i) {
            this.field_82174_bp[i] = 0.085f;
        }
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110140_aT()._b(sajz._b)._a(16.0);
    }

    public dwed func_70671_ap() {
        return this.field_70749_g;
    }

    public lmyh func_70605_aq() {
        return this.field_70765_h;
    }

    public piet func_70683_ar() {
        return this.field_70767_i;
    }

    public ujuz func_70661_as() {
        return this.field_70699_by;
    }

    public flht func_70635_at() {
        return this.field_70723_bA;
    }

    public EntityLivingBase func_70638_az() {
        return this.field_70696_bz;
    }

    public void func_70624_b(EntityLivingBase entityLivingBase) {
        this.field_70696_bz = entityLivingBase;
        ForgeHooks.onLivingSetAttackTarget(this, entityLivingBase);
    }

    public boolean func_70686_a(Class clazz) {
        return EntityCreeper.class != clazz && EntityGhast.class != clazz;
    }

    public void func_70615_aA() {
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(11, (Object)0);
        this.field_70180_af._a(10, "");
    }

    public int func_70627_aG() {
        return 80;
    }

    public void func_70642_aH() {
        String string = this.func_70639_aQ();
        if (string != null) {
            this.func_85030_a(string, this.func_70599_aP(), this.func_70647_i());
        }
    }

    @Override
    public void func_70030_z() {
        super.func_70030_z();
        this.field_70170_p.field_72984_F._a("mobBaseTick");
        if (this.func_70089_S() && this.field_70146_Z.nextInt(1000) < this.field_70757_a++) {
            this.field_70757_a = -this.func_70627_aG();
            this.func_70642_aH();
        }
        this.field_70170_p.field_72984_F._b();
    }

    @Override
    public int func_70693_a(EntityPlayer entityPlayer) {
        if (this.field_70728_aV > 0) {
            int n = this.field_70728_aV;
            cvzo[] cvzoArray = this.func_70035_c();
            for (int i = 0; i < cvzoArray.length; ++i) {
                if (cvzoArray[i] == null || !(this.field_82174_bp[i] <= 1.0f)) continue;
                n += 1 + this.field_70146_Z.nextInt(3);
            }
            return n;
        }
        return this.field_70728_aV;
    }

    public void func_70656_aK() {
        for (int i = 0; i < 20; ++i) {
            double d = this.field_70146_Z.nextGaussian() * 0.02;
            double d2 = this.field_70146_Z.nextGaussian() * 0.02;
            double d3 = this.field_70146_Z.nextGaussian() * 0.02;
            double d4 = 10.0;
            this.field_70170_p.func_72869_a("explode", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N - d * d4, this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O) - d2 * d4, this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N - d3 * d4, d, d2, d3);
        }
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            this.func_110159_bB();
        }
    }

    @Override
    public float func_110146_f(float f, float f2) {
        if (this.func_70650_aV()) {
            this.field_70762_j._a();
            return f2;
        }
        return super.func_110146_f(f, f2);
    }

    public String func_70639_aQ() {
        return null;
    }

    public int func_70633_aT() {
        return 0;
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        int n2 = this.func_70633_aT();
        if (n2 > 0) {
            int n3 = this.field_70146_Z.nextInt(3);
            if (n > 0) {
                n3 += this.field_70146_Z.nextInt(n + 1);
            }
            for (int i = 0; i < n3; ++i) {
                this.func_70025_b(n2, 1);
            }
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac qoac3;
        super.func_70014_b(qoac2);
        qoac2._a("CanPickUpLoot", this.func_98052_bS());
        qoac2._a("PersistenceRequired", this.field_82179_bU);
        bsyv bsyv2 = new bsyv();
        for (int i = 0; i < this.field_82182_bS.length; ++i) {
            qoac3 = new qoac();
            if (this.field_82182_bS[i] != null) {
                this.field_82182_bS[i]._b(qoac3);
            }
            bsyv2._a(qoac3);
        }
        qoac2._a("Equipment", bsyv2);
        bsyv bsyv3 = new bsyv();
        for (int i = 0; i < this.field_82174_bp.length; ++i) {
            bsyv3._a(new jjly(i + "", this.field_82174_bp[i]));
        }
        qoac2._a("DropChances", bsyv3);
        qoac2._a("CustomName", this.func_94057_bL());
        qoac2._a("CustomNameVisible", this.func_94062_bN());
        qoac2._a("Leashed", this.field_110169_bv);
        if (this.field_110168_bw != null) {
            qoac3 = new qoac("Leash");
            if (this.field_110168_bw instanceof EntityLivingBase) {
                qoac3._a("UUIDMost", this.field_110168_bw.func_110124_au().getMostSignificantBits());
                qoac3._a("UUIDLeast", this.field_110168_bw.func_110124_au().getLeastSignificantBits());
            } else if (this.field_110168_bw instanceof EntityHanging) {
                EntityHanging entityHanging = (EntityHanging)this.field_110168_bw;
                qoac3._a("X", entityHanging.field_70523_b);
                qoac3._a("Y", entityHanging.field_70524_c);
                qoac3._a("Z", entityHanging.field_70521_d);
            }
            qoac2._a("Leash", (huhy)qoac3);
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        int n;
        bsyv bsyv2;
        super.func_70037_a(qoac2);
        this.func_98053_h(qoac2._o("CanPickUpLoot"));
        this.field_82179_bU = qoac2._o("PersistenceRequired");
        if (qoac2._c("CustomName") && qoac2._j("CustomName").length() > 0) {
            this.func_94058_c(qoac2._j("CustomName"));
        }
        this.func_94061_f(qoac2._o("CustomNameVisible"));
        if (qoac2._c("Equipment")) {
            bsyv2 = qoac2._n("Equipment");
            for (n = 0; n < this.field_82182_bS.length; ++n) {
                this.field_82182_bS[n] = cvzo._a((qoac)bsyv2._b(n));
            }
        }
        if (qoac2._c("DropChances")) {
            bsyv2 = qoac2._n("DropChances");
            for (n = 0; n < bsyv2._d(); ++n) {
                this.field_82174_bp[n] = ((jjly)bsyv2._b((int)n))._c;
            }
        }
        this.field_110169_bv = qoac2._o("Leashed");
        if (this.field_110169_bv && qoac2._c("Leash")) {
            this.field_110170_bx = qoac2._m("Leash");
        }
    }

    public void func_70657_f(float f) {
        this.field_70701_bs = f;
    }

    @Override
    public void func_70659_e(float f) {
        super.func_70659_e(f);
        this.func_70657_f(f);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70170_p.field_72984_F._a("looting");
        if (!this.field_70170_p.field_72995_K && this.func_98052_bS() && !this.field_70729_aU && this.field_70170_p.func_82736_K()._b("mobGriefing")) {
            List list = this.field_70170_p.func_72872_a(EntityItem.class, this.field_70121_D._b(1.0, 0.0, 1.0));
            for (EntityItem entityItem : list) {
                cvzo cvzo2;
                int n;
                if (entityItem.field_70128_L || entityItem.func_92059_d() == null || (n = EntityLiving.func_82159_b(cvzo2 = entityItem.func_92059_d())) <= -1) continue;
                boolean bl = true;
                cvzo cvzo3 = this.func_71124_b(n);
                if (cvzo3 != null) {
                    tgdv tgdv2;
                    tgdv tgdv3;
                    if (n == 0) {
                        if (cvzo2._a() instanceof vmpw && !(cvzo3._a() instanceof vmpw)) {
                            bl = true;
                        } else if (cvzo2._a() instanceof vmpw && cvzo3._a() instanceof vmpw) {
                            tgdv3 = (vmpw)cvzo2._a();
                            tgdv2 = (vmpw)cvzo3._a();
                            bl = ((vmpw)tgdv3).func_82803_g() == ((vmpw)tgdv2).func_82803_g() ? cvzo2._j() > cvzo3._j() || cvzo2._p() && !cvzo3._p() : ((vmpw)tgdv3).func_82803_g() > ((vmpw)tgdv2).func_82803_g();
                        } else {
                            bl = false;
                        }
                    } else if (cvzo2._a() instanceof lpno && !(cvzo3._a() instanceof lpno)) {
                        bl = true;
                    } else if (cvzo2._a() instanceof lpno && cvzo3._a() instanceof lpno) {
                        tgdv3 = (lpno)cvzo2._a();
                        tgdv2 = (lpno)cvzo3._a();
                        bl = ((lpno)tgdv3).field_77879_b == ((lpno)tgdv2).field_77879_b ? cvzo2._j() > cvzo3._j() || cvzo2._p() && !cvzo3._p() : ((lpno)tgdv3).field_77879_b > ((lpno)tgdv2).field_77879_b;
                    } else {
                        bl = false;
                    }
                }
                if (!bl) continue;
                if (cvzo3 != null && this.field_70146_Z.nextFloat() - 0.1f < this.field_82174_bp[n]) {
                    this.func_70099_a(cvzo3, 0.0f);
                }
                this.func_70062_b(n, cvzo2);
                this.field_82174_bp[n] = 2.0f;
                this.field_82179_bU = true;
                this.func_71001_a(entityItem, 1);
                entityItem.func_70106_y();
            }
        }
        this.field_70170_p.field_72984_F._b();
    }

    @Override
    public boolean func_70650_aV() {
        return false;
    }

    public boolean func_70692_ba() {
        return true;
    }

    public void func_70623_bb() {
        Event.Result result = null;
        if (this.field_82179_bU) {
            this.field_70708_bq = 0;
        } else if ((this.field_70708_bq & 0x1F) == 31 && (result = ForgeEventFactory.canEntityDespawn(this)) != Event.Result.DEFAULT) {
            if (result == Event.Result.DENY) {
                this.field_70708_bq = 0;
            } else {
                this.func_70106_y();
            }
        } else {
            EntityPlayer entityPlayer = this.field_70170_p.func_72890_a(this, -1.0);
            if (entityPlayer != null) {
                double d = entityPlayer.field_70165_t - this.field_70165_t;
                double d2 = entityPlayer.field_70163_u - this.field_70163_u;
                double d3 = entityPlayer.field_70161_v - this.field_70161_v;
                double d4 = d * d + d2 * d2 + d3 * d3;
                if (this.func_70692_ba() && d4 > 16384.0) {
                    this.func_70106_y();
                }
                if (this.field_70708_bq > 600 && this.field_70146_Z.nextInt(800) == 0 && d4 > 1024.0 && this.func_70692_ba()) {
                    this.func_70106_y();
                } else if (d4 < 1024.0) {
                    this.field_70708_bq = 0;
                }
            }
        }
    }

    @Override
    public void func_70619_bc() {
        ++this.field_70708_bq;
        this.field_70170_p.field_72984_F._a("checkDespawn");
        this.func_70623_bb();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("sensing");
        this.field_70723_bA._a();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("targetSelector");
        this.field_70715_bh._a();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("goalSelector");
        this.field_70714_bg._a();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("navigation");
        this.field_70699_by._e();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("mob tick");
        this.func_70629_bd();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._a("controls");
        this.field_70170_p.field_72984_F._a("move");
        this.field_70765_h._c();
        this.field_70170_p.field_72984_F._c("look");
        this.field_70749_g._a();
        this.field_70170_p.field_72984_F._c("jump");
        this.field_70767_i._b();
        this.field_70170_p.field_72984_F._b();
        this.field_70170_p.field_72984_F._b();
    }

    @Override
    public void func_70626_be() {
        super.func_70626_be();
        this.field_70702_br = 0.0f;
        this.field_70701_bs = 0.0f;
        this.func_70623_bb();
        float f = 8.0f;
        if (this.field_70146_Z.nextFloat() < 0.02f) {
            EntityPlayer entityPlayer = this.field_70170_p.func_72890_a(this, f);
            if (entityPlayer != null) {
                this.field_70776_bF = entityPlayer;
                this.field_70700_bx = 10 + this.field_70146_Z.nextInt(20);
            } else {
                this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.field_70776_bF != null) {
            this.func_70625_a(this.field_70776_bF, 10.0f, this.func_70646_bf());
            if (this.field_70700_bx-- <= 0 || this.field_70776_bF.field_70128_L || this.field_70776_bF.func_70068_e(this) > (double)(f * f)) {
                this.field_70776_bF = null;
            }
        } else {
            if (this.field_70146_Z.nextFloat() < 0.05f) {
                this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5f) * 20.0f;
            }
            this.field_70177_z += this.field_70704_bt;
            this.field_70125_A = this.field_70698_bv;
        }
        boolean bl = this.func_70090_H();
        boolean bl2 = this.func_70058_J();
        if (bl || bl2) {
            this.field_70703_bu = this.field_70146_Z.nextFloat() < 0.8f;
        }
    }

    public int func_70646_bf() {
        return 40;
    }

    public void func_70625_a(Entity entity, float f, float f2) {
        double d;
        double d2 = entity.field_70165_t - this.field_70165_t;
        double d3 = entity.field_70161_v - this.field_70161_v;
        if (entity instanceof EntityLivingBase) {
            EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
            d = entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e() - (this.field_70163_u + (double)this.func_70047_e());
        } else {
            d = (entity.field_70121_D._c + entity.field_70121_D._f) / 2.0 - (this.field_70163_u + (double)this.func_70047_e());
        }
        double d4 = sajh._a(d2 * d2 + d3 * d3);
        float f3 = (float)(Math.atan2(d3, d2) * 180.0 / Math.PI) - 90.0f;
        float f4 = (float)(-(Math.atan2(d, d4) * 180.0 / Math.PI));
        this.field_70125_A = this.func_70663_b(this.field_70125_A, f4, f2);
        this.field_70177_z = this.func_70663_b(this.field_70177_z, f3, f);
    }

    public float func_70663_b(float f, float f2, float f3) {
        float f4 = sajh._g(f2 - f);
        if (f4 > f3) {
            f4 = f3;
        }
        if (f4 < -f3) {
            f4 = -f3;
        }
        return f + f4;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
    }

    public float func_70603_bj() {
        return 1.0f;
    }

    public int func_70641_bl() {
        return 4;
    }

    @Override
    public int func_82143_as() {
        if (this.func_70638_az() == null) {
            return 3;
        }
        int n = (int)(this.func_110143_aJ() - this.func_110138_aP() * 0.33f);
        if ((n -= (3 - this.field_70170_p.field_73013_u) * 4) < 0) {
            n = 0;
        }
        return n + 3;
    }

    @Override
    public cvzo func_70694_bm() {
        return this.field_82182_bS[0];
    }

    @Override
    public cvzo func_71124_b(int n) {
        return this.field_82182_bS[n];
    }

    public cvzo func_130225_q(int n) {
        return this.field_82182_bS[n + 1];
    }

    @Override
    public void func_70062_b(int n, cvzo cvzo2) {
        this.field_82182_bS[n] = cvzo2;
    }

    @Override
    public cvzo[] func_70035_c() {
        return this.field_82182_bS;
    }

    @Override
    public void func_82160_b(boolean bl, int n) {
        for (int i = 0; i < this.func_70035_c().length; ++i) {
            boolean bl2;
            cvzo cvzo2 = this.func_71124_b(i);
            boolean bl3 = bl2 = this.field_82174_bp[i] > 1.0f;
            if (cvzo2 == null || !bl && !bl2 || !(this.field_70146_Z.nextFloat() - (float)n * 0.01f < this.field_82174_bp[i])) continue;
            if (!bl2 && cvzo2._f()) {
                int n2 = Math.max(cvzo2._k() - 25, 1);
                int n3 = cvzo2._k() - this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(n2) + 1);
                if (n3 > n2) {
                    n3 = n2;
                }
                if (n3 < 1) {
                    n3 = 1;
                }
                cvzo2._b(n3);
            }
            this.func_70099_a(cvzo2, 0.0f);
        }
    }

    public void func_82164_bB() {
        if (this.field_70146_Z.nextFloat() < 0.15f * this.field_70170_p.func_110746_b(this.field_70165_t, this.field_70163_u, this.field_70161_v)) {
            float f;
            int n = this.field_70146_Z.nextInt(2);
            float f2 = f = this.field_70170_p.field_73013_u == 3 ? 0.1f : 0.25f;
            if (this.field_70146_Z.nextFloat() < 0.095f) {
                ++n;
            }
            if (this.field_70146_Z.nextFloat() < 0.095f) {
                ++n;
            }
            if (this.field_70146_Z.nextFloat() < 0.095f) {
                ++n;
            }
            for (int i = 3; i >= 0; --i) {
                tgdv tgdv2;
                cvzo cvzo2 = this.func_130225_q(i);
                if (i < 3 && this.field_70146_Z.nextFloat() < f) break;
                if (cvzo2 != null || (tgdv2 = EntityLiving.func_82161_a(i + 1, n)) == null) continue;
                this.func_70062_b(i + 1, new cvzo(tgdv2));
            }
        }
    }

    public static int func_82159_b(cvzo cvzo2) {
        if (cvzo2._d != twgu.field_72061_ba.field_71990_ca && cvzo2._d != tgdv.field_82799_bQ.field_77779_bT) {
            if (cvzo2._a() instanceof lpno) {
                switch (((lpno)cvzo2._a()).field_77881_a) {
                    case 0: {
                        return 4;
                    }
                    case 1: {
                        return 3;
                    }
                    case 2: {
                        return 2;
                    }
                    case 3: {
                        return 1;
                    }
                }
            }
            return 0;
        }
        return 4;
    }

    public static tgdv func_82161_a(int n, int n2) {
        switch (n) {
            case 4: {
                if (n2 == 0) {
                    return tgdv.field_77687_V;
                }
                if (n2 == 1) {
                    return tgdv.field_77796_al;
                }
                if (n2 == 2) {
                    return tgdv.field_77694_Z;
                }
                if (n2 == 3) {
                    return tgdv.field_77812_ad;
                }
                if (n2 == 4) {
                    return tgdv.field_77820_ah;
                }
            }
            case 3: {
                if (n2 == 0) {
                    return tgdv.field_77686_W;
                }
                if (n2 == 1) {
                    return tgdv.field_77806_am;
                }
                if (n2 == 2) {
                    return tgdv.field_77814_aa;
                }
                if (n2 == 3) {
                    return tgdv.field_77822_ae;
                }
                if (n2 == 4) {
                    return tgdv.field_77798_ai;
                }
            }
            case 2: {
                if (n2 == 0) {
                    return tgdv.field_77693_X;
                }
                if (n2 == 1) {
                    return tgdv.field_77808_an;
                }
                if (n2 == 2) {
                    return tgdv.field_77816_ab;
                }
                if (n2 == 3) {
                    return tgdv.field_77824_af;
                }
                if (n2 == 4) {
                    return tgdv.field_77800_aj;
                }
            }
            case 1: {
                if (n2 == 0) {
                    return tgdv.field_77692_Y;
                }
                if (n2 == 1) {
                    return tgdv.field_77802_ao;
                }
                if (n2 == 2) {
                    return tgdv.field_77810_ac;
                }
                if (n2 == 3) {
                    return tgdv.field_77818_ag;
                }
                if (n2 != 4) break;
                return tgdv.field_77794_ak;
            }
        }
        return null;
    }

    public void func_82162_bC() {
        float f = this.field_70170_p.func_110746_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        if (this.func_70694_bm() != null && this.field_70146_Z.nextFloat() < 0.25f * f) {
            zhty._a(this.field_70146_Z, this.func_70694_bm(), (int)(5.0f + f * (float)this.field_70146_Z.nextInt(18)));
        }
        for (int i = 0; i < 4; ++i) {
            cvzo cvzo2 = this.func_130225_q(i);
            if (cvzo2 == null || !(this.field_70146_Z.nextFloat() < 0.5f * f)) continue;
            zhty._a(this.field_70146_Z, cvzo2, (int)(5.0f + f * (float)this.field_70146_Z.nextInt(18)));
        }
    }

    public tupg func_110161_a(tupg tupg2) {
        this.func_110148_a(sajz._b)._a(new xson("Random spawn bonus", this.field_70146_Z.nextGaussian() * 0.05, 1));
        return tupg2;
    }

    public boolean func_82171_bF() {
        return false;
    }

    @Override
    public String func_70023_ak() {
        return this.func_94056_bM() ? this.func_94057_bL() : super.func_70023_ak();
    }

    public void func_110163_bv() {
        this.field_82179_bU = true;
    }

    public void func_94058_c(String string) {
        this.field_70180_af._b(10, string);
    }

    public String func_94057_bL() {
        return this.field_70180_af._e(10);
    }

    public boolean func_94056_bM() {
        return this.field_70180_af._e(10).length() > 0;
    }

    public void func_94061_f(boolean bl) {
        this.field_70180_af._b(11, (byte)(bl ? 1 : 0));
    }

    public boolean func_94062_bN() {
        return this.field_70180_af._a(11) == 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_94059_bO() {
        return this.func_94062_bN();
    }

    public void func_96120_a(int n, float f) {
        this.field_82174_bp[n] = f;
    }

    public boolean func_98052_bS() {
        return this.field_82172_bs;
    }

    public void func_98053_h(boolean bl) {
        this.field_82172_bs = bl;
    }

    public boolean func_104002_bU() {
        return this.field_82179_bU;
    }

    @Override
    public final boolean func_130002_c(EntityPlayer entityPlayer) {
        if (this.func_110167_bD() && this.func_110166_bE() == entityPlayer) {
            this.func_110160_i(true, !entityPlayer.field_71075_bZ._d);
            return true;
        }
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 != null && cvzo2._d == tgdv.field_111214_ch.field_77779_bT && this.func_110164_bC()) {
            if (!(this instanceof EntityTameable) || !((EntityTameable)this).func_70909_n()) {
                this.func_110162_b(entityPlayer, true);
                --cvzo2._b;
                return true;
            }
            if (entityPlayer.func_70005_c_().equalsIgnoreCase(((EntityTameable)this).func_70905_p())) {
                this.func_110162_b(entityPlayer, true);
                --cvzo2._b;
                return true;
            }
        }
        return this.func_70085_c(entityPlayer) ? true : super.func_130002_c(entityPlayer);
    }

    public boolean func_70085_c(EntityPlayer entityPlayer) {
        return false;
    }

    public void func_110159_bB() {
        if (this.field_110170_bx != null) {
            this.func_110165_bF();
        }
        if (this.field_110169_bv && (this.field_110168_bw == null || this.field_110168_bw.field_70128_L)) {
            this.func_110160_i(true, true);
        }
    }

    public void func_110160_i(boolean bl, boolean bl2) {
        if (this.field_110169_bv) {
            this.field_110169_bv = false;
            this.field_110168_bw = null;
            if (!this.field_70170_p.field_72995_K && bl2) {
                this.func_70025_b(tgdv.field_111214_ch.field_77779_bT, 1);
            }
            if (!this.field_70170_p.field_72995_K && bl && this.field_70170_p instanceof yfgy) {
                ((yfgy)this.field_70170_p).func_73039_n()._a(this, new nwaj(1, this, null));
            }
        }
    }

    public boolean func_110164_bC() {
        return !this.func_110167_bD() && !(this instanceof ezey);
    }

    public boolean func_110167_bD() {
        return this.field_110169_bv;
    }

    public Entity func_110166_bE() {
        return this.field_110168_bw;
    }

    public void func_110162_b(Entity entity, boolean bl) {
        this.field_110169_bv = true;
        this.field_110168_bw = entity;
        if (!this.field_70170_p.field_72995_K && bl && this.field_70170_p instanceof yfgy) {
            ((yfgy)this.field_70170_p).func_73039_n()._a(this, new nwaj(1, this, this.field_110168_bw));
        }
    }

    public void func_110165_bF() {
        if (this.field_110169_bv && this.field_110170_bx != null) {
            if (this.field_110170_bx._c("UUIDMost") && this.field_110170_bx._c("UUIDLeast")) {
                UUID uUID = new UUID(this.field_110170_bx._g("UUIDMost"), this.field_110170_bx._g("UUIDLeast"));
                List list = this.field_70170_p.func_72872_a(EntityLivingBase.class, this.field_70121_D._b(10.0, 10.0, 10.0));
                for (EntityLivingBase entityLivingBase : list) {
                    if (!entityLivingBase.func_110124_au().equals(uUID)) continue;
                    this.field_110168_bw = entityLivingBase;
                    break;
                }
            } else if (this.field_110170_bx._c("X") && this.field_110170_bx._c("Y") && this.field_110170_bx._c("Z")) {
                int n;
                int n2;
                int n3 = this.field_110170_bx._f("X");
                EntityLeashKnot entityLeashKnot = EntityLeashKnot.func_110130_b(this.field_70170_p, n3, n2 = this.field_110170_bx._f("Y"), n = this.field_110170_bx._f("Z"));
                if (entityLeashKnot == null) {
                    entityLeashKnot = EntityLeashKnot.func_110129_a(this.field_70170_p, n3, n2, n);
                }
                this.field_110168_bw = entityLeashKnot;
            } else {
                this.func_110160_i(false, true);
            }
        }
        this.field_110170_bx = null;
    }
}

