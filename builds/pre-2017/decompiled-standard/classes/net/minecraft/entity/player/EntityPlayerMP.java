/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

import api.player.server.IServerPlayerAPI;
import api.player.server.ServerPlayerAPI;
import api.player.server.ServerPlayerBase;
import carpentersblocks.CarpentersHooks;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.amww;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.ezey;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import net.minecraft.entity.player.pidb;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.ugqi;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;
import net.minecraft.util.tdmn;
import net.minecraft.util.turb;
import net.minecraft.util.vjta;
import net.minecraft.util.zwat;
import net.minecraft.util.zwaw;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.ChunkWatchEvent;

public class EntityPlayerMP
extends EntityPlayer
implements IServerPlayerAPI,
sdcd {
    public String field_71148_cg;
    public xbvu field_71135_a;
    public dzfd field_71133_b;
    public mbsl field_71134_c;
    public double field_71131_d;
    public double field_71132_e;
    public final List field_71129_f;
    public final List field_71130_g;
    public float field_130068_bO;
    public float field_71149_ch;
    public int field_71146_ci;
    public boolean field_71147_cj;
    public int field_71144_ck;
    public int field_71145_cl;
    public int field_71142_cm;
    public int field_71143_cn;
    public boolean field_71140_co;
    public long field_143005_bX;
    public int field_71139_cq;
    public boolean field_71137_h;
    public int field_71138_i;
    public boolean field_71136_j;
    private final ServerPlayerAPI serverPlayerAPI = ServerPlayerAPI.create(this);

    public EntityPlayerMP(dzfd dzfd2, ozlu ozlu2, String string, mbsl mbsl2) {
        super(ozlu2, string);
        ServerPlayerAPI.beforeLocalConstructing(this, dzfd2, ozlu2, string, mbsl2);
        this.field_71148_cg = "en_US";
        this.field_71129_f = new LinkedList();
        this.field_71130_g = new LinkedList();
        this.field_130068_bO = Float.MIN_VALUE;
        this.field_71149_ch = -1.0E8f;
        this.field_71146_ci = -99999999;
        this.field_71147_cj = true;
        this.field_71144_ck = -99999999;
        this.field_71145_cl = 60;
        this.field_71140_co = true;
        this.field_143005_bX = 0L;
        mbsl2._c = this;
        this.field_71134_c = mbsl2;
        this.field_71142_cm = dzfd2 == null ? 0 : dzfd2.__ag()._u();
        zwaw zwaw2 = ozlu2.field_73011_w._s();
        int n = zwaw2._a;
        int n2 = zwaw2._c;
        int n3 = zwaw2._b;
        this.field_71133_b = dzfd2;
        this.field_70138_W = 0.0f;
        this.field_70129_M = 0.0f;
        this.func_70012_b((double)n + 0.5, n3, (double)n2 + 0.5, 0.0f, 0.0f);
        while (!ozlu2.func_72945_a(this, this.field_70121_D).isEmpty()) {
            this.func_70107_b(this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v);
        }
        ServerPlayerAPI.afterLocalConstructing(this, dzfd2, ozlu2, string, mbsl2);
    }

    @Override
    public final void localReadEntityFromNBT(qoac qoac2) {
        super.func_70037_a(qoac2);
        if (qoac2._c("playerGameType")) {
            if (dzfd._I().__ao()) {
                this.field_71134_c._a(dzfd._I()._r());
            } else {
                this.field_71134_c._a(xtby._a(qoac2._f("playerGameType")));
            }
        }
    }

    @Override
    public final void localWriteEntityToNBT(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("playerGameType", this.field_71134_c._a()._a());
    }

    @Override
    public final void localAddExperienceLevel(int n) {
        super.func_82242_a(n);
        this.field_71144_ck = -1;
    }

    public void func_71116_b() {
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public void func_71061_d_() {
        this.field_70129_M = 0.0f;
    }

    @Override
    public final void localOnUpdate() {
        Object object;
        Object object2;
        this.field_71134_c._c();
        --this.field_71145_cl;
        this.field_71070_bA.func_75142_b();
        if (!this.field_70170_p.field_72995_K && !ForgeHooks.canInteractWith(this, this.field_71070_bA)) {
            this.func_71053_j();
            this.field_71070_bA = this.field_71069_bz;
        }
        while (!this.field_71130_g.isEmpty()) {
            int n = Math.min(this.field_71130_g.size(), 127);
            object2 = new int[n];
            object = this.field_71130_g.iterator();
            int n2 = 0;
            while (object.hasNext() && n2 < n) {
                object2[n2++] = (Integer)object.next();
                object.remove();
            }
            this.field_71135_a.func_72567_b(new ixod((int[])object2));
        }
        if (!this.field_71129_f.isEmpty()) {
            ArrayList<ixzi> arrayList = new ArrayList<ixzi>();
            object2 = this.field_71129_f.iterator();
            object = new ArrayList();
            while (object2.hasNext() && arrayList.size() < 5) {
                jjym jjym2 = (jjym)object2.next();
                object2.remove();
                if (jjym2 == null || !this.field_70170_p.func_72899_e(jjym2._a << 4, 0, jjym2._b << 4)) continue;
                arrayList.add(this.field_70170_p.func_72964_e(jjym2._a, jjym2._b));
                ((ArrayList)object).addAll(((yfgy)this.field_70170_p).func_73049_a(jjym2._a * 16, 0, jjym2._b * 16, jjym2._a * 16 + 15, 256, jjym2._b * 16 + 15));
            }
            if (!arrayList.isEmpty()) {
                this.field_71135_a.func_72567_b(new xbzz(arrayList));
                Iterator iterator2 = ((ArrayList)object).iterator();
                while (iterator2.hasNext()) {
                    hurg object3 = (hurg)iterator2.next();
                    this.func_71119_a(object3);
                }
                for (ixzi ixzi2 : arrayList) {
                    this.func_71121_q().func_73039_n()._a(this, ixzi2);
                    MinecraftForge.EVENT_BUS.post(new ChunkWatchEvent.Watch(ixzi2._k(), this));
                }
            }
        }
        if (this.field_143005_bX > 0L && this.field_71133_b.__ar() > 0 && dzfd.__aq() - this.field_143005_bX > (long)(this.field_71133_b.__ar() * 1000 * 60)) {
            this.field_71135_a.func_72565_c("You have been idle for too long!");
        }
    }

    @Override
    public final void localOnUpdateEntity() {
        try {
            super.func_70071_h_();
            for (int i = 0; i < this.field_71071_by.func_70302_i_(); ++i) {
                Object object;
                cvzo cvzo2 = this.field_71071_by.func_70301_a(i);
                if (cvzo2 == null || !tgdv.field_77698_e[cvzo2._d].func_77643_m_() || this.field_71135_a.func_72568_e() > 5 || (object = ((nvwc)tgdv.field_77698_e[cvzo2._d])._a(cvzo2, this.field_70170_p, this)) == null) continue;
                this.field_71135_a.func_72567_b((cezg)object);
            }
            if (this.func_110143_aJ() != this.field_71149_ch || this.field_71146_ci != this.field_71100_bB._a() || this.field_71100_bB._d() == 0.0f != this.field_71147_cj) {
                this.field_71135_a.func_72567_b(new sdlz(this.func_110143_aJ(), this.field_71100_bB._a(), this.field_71100_bB._d()));
                this.field_71149_ch = this.func_110143_aJ();
                this.field_71146_ci = this.field_71100_bB._a();
                boolean bl = this.field_71147_cj = this.field_71100_bB._d() == 0.0f;
            }
            if (this.func_110143_aJ() + this.func_110139_bj() != this.field_130068_bO) {
                this.field_130068_bO = this.func_110143_aJ() + this.func_110139_bj();
                Collection collection = this.func_96123_co()._a(nwbn._g);
                for (Object object : collection) {
                    this.func_96123_co()._a(this.func_70023_ak(), (igri)object)._a(Arrays.asList(this));
                }
            }
            if (this.field_71067_cb != this.field_71144_ck) {
                this.field_71144_ck = this.field_71067_cb;
                this.field_71135_a.func_72567_b(new rajk(this.field_71106_cc, this.field_71067_cb, this.field_71068_ca));
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Ticking player");
            jxsn jxsn2 = crashReport.func_85058_a("Player being ticked");
            this.func_85029_a(jxsn2);
            throw new turb(crashReport);
        }
    }

    @Override
    public final void localOnDeath(jxtc jxtc2) {
        Object object3;
        Object object2;
        if (ForgeHooks.onLivingDeath(this, jxtc2)) {
            return;
        }
        this.field_71133_b.__ag()._a(this.func_110142_aN()._b());
        if (!this.field_70170_p.func_82736_K()._b("keepInventory")) {
            this.captureDrops = true;
            this.capturedDrops.clear();
            this.field_71071_by._f();
            this.captureDrops = false;
            object2 = new PlayerDropsEvent(this, jxtc2, this.capturedDrops, this.field_70718_bc > 0);
            if (!MinecraftForge.EVENT_BUS.post((Event)object2)) {
                for (Object object3 : this.capturedDrops) {
                    this.func_71012_a((EntityItem)object3);
                }
            }
        }
        object2 = this.field_70170_p.func_96441_U()._a(nwbn._d);
        Iterator iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            object3 = (igri)iterator2.next();
            cwdc cwdc2 = this.func_96123_co()._a(this.func_70023_ak(), (igri)object3);
            cwdc2._a();
        }
        object3 = this.func_94060_bK();
        if (object3 != null) {
            ((Entity)object3).func_70084_c(this, this.field_70744_aE);
        }
        this.func_71064_a(dzif._y, 1);
    }

    @Override
    public final boolean localAttackEntityFrom(jxtc jxtc2, float f) {
        boolean bl;
        if (this.func_85032_ar()) {
            return false;
        }
        boolean bl2 = bl = this.field_71133_b._W() && this.field_71133_b.__aa() && "fall".equals(jxtc2.field_76373_n);
        if (!bl && this.field_71145_cl > 0 && jxtc2 != jxtc.field_76380_i) {
            return false;
        }
        if (jxtc2 instanceof vjta) {
            Entity entity = jxtc2.func_76346_g();
            if (entity instanceof EntityPlayer && !this.func_96122_a((EntityPlayer)entity)) {
                return false;
            }
            if (entity instanceof EntityArrow) {
                EntityArrow entityArrow = (EntityArrow)entity;
                if (entityArrow.field_70250_c instanceof EntityPlayer && !this.func_96122_a((EntityPlayer)entityArrow.field_70250_c)) {
                    return false;
                }
            }
        }
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public boolean func_96122_a(EntityPlayer entityPlayer) {
        return !this.field_71133_b.__aa() ? false : super.func_96122_a(entityPlayer);
    }

    @Override
    public void func_71027_c(int n) {
        if (this.field_71093_bK == 1 && n == 1) {
            this.func_71029_a(sdqa._C);
            this.field_70170_p.func_72900_e(this);
            this.field_71136_j = true;
            this.field_71135_a.func_72567_b(new tgph(4, 0));
        } else {
            if (this.field_71093_bK == 0 && n == 1) {
                this.func_71029_a(sdqa._B);
                zwaw zwaw2 = this.field_71133_b._a(n).func_73054_j();
                if (zwaw2 != null) {
                    this.field_71135_a.func_72569_a(zwaw2._a, zwaw2._b, zwaw2._c, 0.0f, 0.0f);
                }
                n = 1;
            } else {
                this.func_71029_a(sdqa._x);
            }
            this.field_71133_b.__ag()._a(this, n);
            this.field_71144_ck = -1;
            this.field_71149_ch = -1.0f;
            this.field_71146_ci = -1;
        }
    }

    public void func_71119_a(hurg hurg2) {
        cezg cezg2;
        if (hurg2 != null && (cezg2 = hurg2.func_70319_e()) != null) {
            this.field_71135_a.func_72567_b(cezg2);
        }
    }

    @Override
    public void func_71001_a(Entity entity, int n) {
        super.func_71001_a(entity, n);
        this.field_71070_bA.func_75142_b();
    }

    @Override
    public pidb func_71018_a(int n, int n2, int n3) {
        pidb pidb2 = super.func_71018_a(n, n2, n3);
        if (pidb2 == pidb._a) {
            kmuh kmuh2 = new kmuh(this, 0, n, n2, n3);
            this.func_71121_q().func_73039_n()._a((Entity)this, kmuh2);
            this.field_71135_a.func_72569_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
            this.field_71135_a.func_72567_b(kmuh2);
        }
        return pidb2;
    }

    @Override
    public void func_70999_a(boolean bl, boolean bl2, boolean bl3) {
        if (this.func_70608_bn()) {
            this.func_71121_q().func_73039_n()._b(this, new jjrh(this, 3));
        }
        super.func_70999_a(bl, bl2, bl3);
        if (this.field_71135_a != null) {
            this.field_71135_a.func_72569_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
        }
    }

    @Override
    public void func_70078_a(Entity entity) {
        super.func_70078_a(entity);
        this.field_71135_a.func_72567_b(new nwaj(0, this, this.field_70154_o));
        this.field_71135_a.func_72569_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
    }

    @Override
    public void func_70064_a(double d, boolean bl) {
    }

    public void func_71122_b(double d, boolean bl) {
        super.func_70064_a(d, bl);
    }

    @Override
    public void func_71014_a(hurg hurg2) {
        if (hurg2 instanceof jjza) {
            ((jjza)hurg2)._a(this);
            this.field_71135_a.func_72567_b(new wpwt(0, hurg2.field_70329_l, hurg2.field_70330_m, hurg2.field_70327_n));
        }
    }

    public void func_71117_bO() {
        this.field_71139_cq = this.field_71139_cq % 100 + 1;
    }

    @Override
    public final void localDisplayGUIWorkbench(int n, int n2, int n3) {
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 1, "Crafting", 9, true));
        this.field_71070_bA = new xsrv(this.field_71071_by, this.field_70170_p, n, n2, n3);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public void func_71002_c(int n, int n2, int n3, String string) {
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 4, string == null ? "" : string, 9, string != null));
        this.field_71070_bA = new mson(this.field_71071_by, this.field_70170_p, n, n2, n3);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public void func_82244_d(int n, int n2, int n3) {
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 8, "Repairing", 9, true));
        this.field_71070_bA = new sdci(this.field_71071_by, this.field_70170_p, n, n2, n3, this);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public final void localDisplayGUIChest(mssh mssh2) {
        if (this.field_71070_bA != this.field_71069_bz) {
            this.func_71053_j();
        }
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 0, mssh2.func_70303_b(), mssh2.func_70302_i_(), mssh2.func_94042_c()));
        this.field_71070_bA = new wpkx(this.field_71071_by, mssh2);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public void func_94064_a(cffd cffd2) {
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 9, cffd2.func_70303_b(), cffd2.func_70302_i_(), cffd2.func_94042_c()));
        this.field_71070_bA = new xsns(this.field_71071_by, cffd2);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public void func_96125_a(EntityMinecartHopper entityMinecartHopper) {
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 9, entityMinecartHopper.func_70303_b(), entityMinecartHopper.func_70302_i_(), entityMinecartHopper.func_94042_c()));
        this.field_71070_bA = new xsns(this.field_71071_by, entityMinecartHopper);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public final void localDisplayGUIFurnace(nwgz nwgz2) {
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 2, nwgz2.func_70303_b(), nwgz2.func_70302_i_(), nwgz2.func_94042_c()));
        this.field_71070_bA = new lplm(this.field_71071_by, nwgz2);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public final void localDisplayGUIDispenser(jjzo jjzo2) {
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, jjzo2 instanceof hdtl ? 10 : 3, jjzo2.func_70303_b(), jjzo2.func_70302_i_(), jjzo2.func_94042_c()));
        this.field_71070_bA = new bbok(this.field_71071_by, jjzo2);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public void func_71017_a(nfbs nfbs2) {
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 5, nfbs2.func_70303_b(), nfbs2.func_70302_i_(), nfbs2.func_94042_c()));
        this.field_71070_bA = new tgbu(this.field_71071_by, nfbs2);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public void func_82240_a(vmyb vmyb2) {
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 7, vmyb2.func_70303_b(), vmyb2.func_70302_i_(), vmyb2.func_94042_c()));
        this.field_71070_bA = new ixdv(this.field_71071_by, vmyb2);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public void func_71030_a(amww amww2, String string) {
        this.func_71117_bO();
        this.field_71070_bA = new igct(this.field_71071_by, amww2, this.field_70170_p);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
        sdcl sdcl2 = ((igct)this.field_71070_bA)._a();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 6, string == null ? "" : string, sdcl2.func_70302_i_(), string != null));
        ywfi ywfi2 = amww2.func_70934_b(this);
        if (ywfi2 != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(this.field_71139_cq);
                ywfi2._a(dataOutputStream);
                this.field_71135_a.func_72567_b(new jjqf("MC|TrList", byteArrayOutputStream.toByteArray()));
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    @Override
    public void func_110298_a(EntityHorse entityHorse, mssh mssh2) {
        if (this.field_71070_bA != this.field_71069_bz) {
            this.func_71053_j();
        }
        this.func_71117_bO();
        this.field_71135_a.func_72567_b(new lpub(this.field_71139_cq, 11, mssh2.func_70303_b(), mssh2.func_70302_i_(), mssh2.func_94042_c(), entityHorse.field_70157_k));
        this.field_71070_bA = new qnzl(this.field_71071_by, mssh2, entityHorse);
        this.field_71070_bA.field_75152_c = this.field_71139_cq;
        this.field_71070_bA.func_75132_a(this);
    }

    @Override
    public void func_71111_a(jjgc jjgc2, int n, cvzo cvzo2) {
        if (!(jjgc2.func_75139_a(n) instanceof pkzb) && !this.field_71137_h) {
            this.field_71135_a.func_72567_b(new ixmv(jjgc2.field_75152_c, n, cvzo2));
        }
    }

    public void func_71120_a(jjgc jjgc2) {
        this.func_71110_a(jjgc2, jjgc2.func_75138_a());
    }

    @Override
    public void func_71110_a(jjgc jjgc2, List list) {
        this.field_71135_a.func_72567_b(new wptu(jjgc2.field_75152_c, list));
        this.field_71135_a.func_72567_b(new ixmv(-1, -1, this.field_71071_by._g()));
    }

    @Override
    public void func_71112_a(jjgc jjgc2, int n, int n2) {
        this.field_71135_a.func_72567_b(new neyc(jjgc2.field_75152_c, n, n2));
    }

    @Override
    public void func_71053_j() {
        this.field_71135_a.func_72567_b(new txlx(this.field_71070_bA.field_75152_c));
        this.func_71128_l();
    }

    public void func_71113_k() {
        if (!this.field_71137_h) {
            this.field_71135_a.func_72567_b(new ixmv(-1, -1, this.field_71071_by._g()));
        }
    }

    public void func_71128_l() {
        this.field_71070_bA.func_75134_a(this);
        this.field_71070_bA = this.field_71069_bz;
    }

    public void func_110430_a(float f, float f2, boolean bl, boolean bl2) {
        if (this.field_70154_o != null) {
            if (f >= -1.0f && f <= 1.0f) {
                this.field_70702_br = f;
            }
            if (f2 >= -1.0f && f2 <= 1.0f) {
                this.field_70701_bs = f2;
            }
            this.field_70703_bu = bl;
            this.func_70095_a(bl2);
        }
    }

    @Override
    public void func_71064_a(rann rann2, int n) {
        if (rann2 != null && !rann2.field_75972_f) {
            this.field_71135_a.func_72567_b(new dzcl(rann2.field_75975_e, n));
        }
    }

    public void func_71123_m() {
        if (this.field_70153_n != null) {
            this.field_70153_n.func_70078_a(this);
        }
        if (this.field_71083_bS) {
            this.func_70999_a(true, false, false);
        }
    }

    public void func_71118_n() {
        this.field_71149_ch = -1.0E8f;
    }

    @Override
    public void func_71035_c(String string) {
        this.field_71135_a.func_72567_b(new cwaz(zwat._e(string)));
    }

    @Override
    public void func_71036_o() {
        this.field_71135_a.func_72567_b(new bszz(this.field_70157_k, 9));
        super.func_71036_o();
    }

    @Override
    public void func_71008_a(cvzo cvzo2, int n) {
        super.func_71008_a(cvzo2, n);
        if (cvzo2 != null && cvzo2._a() != null && cvzo2._a().func_77661_b(cvzo2) == bsre._b) {
            this.func_71121_q().func_73039_n()._b(this, new jjrh(this, 5));
        }
    }

    @Override
    public final void localClonePlayer(EntityPlayer entityPlayer, boolean bl) {
        super.func_71049_a(entityPlayer, bl);
        this.field_71144_ck = -1;
        this.field_71149_ch = -1.0f;
        this.field_71146_ci = -1;
        this.field_71130_g.addAll(((EntityPlayerMP)entityPlayer).field_71130_g);
    }

    @Override
    public void func_70670_a(supr supr2) {
        super.func_70670_a(supr2);
        this.field_71135_a.func_72567_b(new cwaw(this.field_70157_k, supr2));
    }

    @Override
    public void func_70695_b(supr supr2, boolean bl) {
        super.func_70695_b(supr2, bl);
        this.field_71135_a.func_72567_b(new cwaw(this.field_70157_k, supr2));
    }

    @Override
    public void func_70688_c(supr supr2) {
        super.func_70688_c(supr2);
        this.field_71135_a.func_72567_b(new zibp(this.field_70157_k, supr2));
    }

    @Override
    public void func_70634_a(double d, double d2, double d3) {
        this.field_71135_a.func_72569_a(d, d2, d3, this.field_70177_z, this.field_70125_A);
    }

    @Override
    public void func_71009_b(Entity entity) {
        this.func_71121_q().func_73039_n()._b(this, new jjrh(entity, 6));
    }

    @Override
    public void func_71047_c(Entity entity) {
        this.func_71121_q().func_73039_n()._b(this, new jjrh(entity, 7));
    }

    @Override
    public void func_71016_p() {
        if (this.field_71135_a != null) {
            this.field_71135_a.func_72567_b(new ragy(this.field_71075_bZ));
        }
    }

    public yfgy func_71121_q() {
        return (yfgy)this.field_70170_p;
    }

    @Override
    public void func_71033_a(xtby xtby2) {
        this.field_71134_c._a(xtby2);
        this.field_71135_a.func_72567_b(new tgph(3, xtby2._a()));
    }

    @Override
    public void func_70006_a(zwat zwat2) {
        this.field_71135_a.func_72567_b(new cwaz(zwat2));
    }

    @Override
    public boolean func_70003_b(int n, String string) {
        return "seed".equals(string) && !this.field_71133_b._W() ? true : (!("tell".equals(string) || "help".equals(string) || "me".equals(string)) ? (this.field_71133_b.__ag()._g(this.field_71092_bJ) ? this.field_71133_b._u() >= n : false) : true);
    }

    public String func_71114_r() {
        String string = this.field_71135_a.field_72575_b._c().toString();
        string = string.substring(string.indexOf("/") + 1);
        string = string.substring(0, string.indexOf(":"));
        return string;
    }

    public void func_71125_a(grje grje2) {
        this.field_71148_cg = grje2._a();
        int n = 256 >> grje2._b();
        if (n > 3 && n < 15) {
            this.field_71142_cm = n;
        }
        this.field_71143_cn = grje2._c();
        this.field_71140_co = grje2._d();
        if (this.field_71133_b._N() && this.field_71133_b._M().equals(this.field_71092_bJ)) {
            this.field_71133_b._c(grje2._e());
        }
        this.func_82239_b(1, !grje2._f());
    }

    public int func_71126_v() {
        return this.field_71143_cn;
    }

    public void func_71115_a(String string, int n) {
        String string2 = string + "\u0000" + n;
        this.field_71135_a.func_72567_b(new jjqf("MC|TPack", string2.getBytes()));
    }

    @Override
    public zwaw func_82114_b() {
        return new zwaw(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u + 0.5), sajh._c(this.field_70161_v));
    }

    public void func_143004_u() {
        this.field_143005_bX = dzfd.__aq();
    }

    @Override
    public float getDefaultEyeHeight() {
        return 1.62f;
    }

    @Override
    public void func_71020_j(float f) {
        ServerPlayerAPI.addExhaustion(this, f);
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
    public void func_71023_q(int n) {
        ServerPlayerAPI.addExperience(this, n);
    }

    @Override
    public final void realAddExperience(int n) {
        this.func_71023_q(n);
    }

    @Override
    public final void superAddExperience(int n) {
        super.func_71023_q(n);
    }

    @Override
    public final void localAddExperience(int n) {
        super.func_71023_q(n);
    }

    @Override
    public void func_82242_a(int n) {
        ServerPlayerAPI.addExperienceLevel(this, n);
    }

    @Override
    public final void realAddExperienceLevel(int n) {
        this.func_82242_a(n);
    }

    @Override
    public final void superAddExperienceLevel(int n) {
        super.func_82242_a(n);
    }

    @Override
    public void func_71000_j(double d, double d2, double d3) {
        ServerPlayerAPI.addMovementStat(this, d, d2, d3);
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
    public boolean func_70097_a(jxtc jxtc2, float f) {
        return ServerPlayerAPI.attackEntityFrom(this, jxtc2, f);
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
    public void func_71059_n(Entity entity) {
        ServerPlayerAPI.attackTargetEntityWithCurrentItem(this, entity);
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
    public boolean func_71062_b(twgu twgu2) {
        return ServerPlayerAPI.canHarvestBlock(this, twgu2);
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
        return ServerPlayerAPI.canPlayerEdit(this, n, n2, n3, n4, cvzo2);
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
        return ServerPlayerAPI.canTriggerWalking(this);
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
    public void func_71049_a(EntityPlayer entityPlayer, boolean bl) {
        ServerPlayerAPI.clonePlayer(this, entityPlayer, bl);
    }

    @Override
    public final void realClonePlayer(EntityPlayer entityPlayer, boolean bl) {
        this.func_71049_a(entityPlayer, bl);
    }

    @Override
    public final void superClonePlayer(EntityPlayer entityPlayer, boolean bl) {
        super.func_71049_a(entityPlayer, bl);
    }

    @Override
    public void func_70665_d(jxtc jxtc2, float f) {
        ServerPlayerAPI.damageEntity(this, jxtc2, f);
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
    public void func_71007_a(mssh mssh2) {
        ServerPlayerAPI.displayGUIChest(this, mssh2);
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
        ServerPlayerAPI.displayGUIDispenser(this, jjzo2);
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
    public void func_71042_a(nwgz nwgz2) {
        ServerPlayerAPI.displayGUIFurnace(this, nwgz2);
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
        ServerPlayerAPI.displayGUIWorkbench(this, n, n2, n3);
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
        return ServerPlayerAPI.dropOneItem(this, bl);
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
        return ServerPlayerAPI.dropPlayerItem(this, cvzo2);
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
    public void func_70069_a(float f) {
        ServerPlayerAPI.fall(this, f);
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
    public float func_71055_a(twgu twgu2, boolean bl) {
        return ServerPlayerAPI.getCurrentPlayerStrVsBlock(this, twgu2, bl);
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
        return ServerPlayerAPI.getCurrentPlayerStrVsBlockForge(this, twgu2, bl, n);
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
        return ServerPlayerAPI.getDistanceSq(this, d, d2, d3);
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
    public float func_70013_c(float f) {
        return ServerPlayerAPI.getBrightness(this, f);
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
    public float func_70047_e() {
        return ServerPlayerAPI.getEyeHeight(this);
    }

    @Override
    public final float realGetEyeHeight() {
        return this.func_70047_e();
    }

    @Override
    public final float superGetEyeHeight() {
        return super.func_70047_e();
    }

    @Override
    public final float localGetEyeHeight() {
        return super.func_70047_e();
    }

    @Override
    public void func_70691_i(float f) {
        ServerPlayerAPI.heal(this, f);
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
        return ServerPlayerAPI.isEntityInsideOpaqueBlock(this);
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
        return ServerPlayerAPI.isInWater(this);
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
        return ServerPlayerAPI.isInsideOfMaterial(this, tflj2);
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
        return ServerPlayerAPI.isOnLadder(this);
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
        return ServerPlayerAPI.isPlayerSleeping(this);
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
    public void func_70664_aZ() {
        ServerPlayerAPI.jump(this);
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
        ServerPlayerAPI.knockBack(this, entity, f, d, d2);
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
        ServerPlayerAPI.moveEntity(this, d, d2, d3);
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
        ServerPlayerAPI.moveEntityWithHeading(this, f, f2);
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
        ServerPlayerAPI.moveFlying(this, f, f2, f3);
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
        ServerPlayerAPI.onDeath(this, jxtc2);
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
    public void func_70636_d() {
        ServerPlayerAPI.onLivingUpdate(this);
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
    public final void localOnLivingUpdate() {
        super.func_70636_d();
    }

    @Override
    public void func_70074_a(EntityLivingBase entityLivingBase) {
        ServerPlayerAPI.onKillEntity(this, entityLivingBase);
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
        ServerPlayerAPI.onStruckByLightning(this, entityLightningBolt);
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
        CarpentersHooks.onUpdate(this);
    }

    @Override
    public final void realOnUpdate() {
        this.func_70071_h_();
    }

    @Override
    public final void superOnUpdate() {
        super.func_70071_h_();
    }

    public void func_71127_g() {
        ServerPlayerAPI.onUpdateEntity(this);
    }

    @Override
    public final void realOnUpdateEntity() {
        this.func_71127_g();
    }

    public final void superOnUpdateEntity() {
        super.h();
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        ServerPlayerAPI.readEntityFromNBT(this, qoac2);
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
    public void func_70106_y() {
        ServerPlayerAPI.setDead(this);
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

    @Override
    public void func_70107_b(double d, double d2, double d3) {
        ServerPlayerAPI.setPosition(this, d, d2, d3);
    }

    @Override
    public final void realSetPosition(double d, double d2, double d3) {
        this.func_70107_b(d, d2, d3);
    }

    @Override
    public final void superSetPosition(double d, double d2, double d3) {
        super.func_70107_b(d, d2, d3);
    }

    @Override
    public final void localSetPosition(double d, double d2, double d3) {
        super.func_70107_b(d, d2, d3);
    }

    @Override
    public void func_71038_i() {
        ServerPlayerAPI.swingItem(this);
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
        ServerPlayerAPI.updateEntityActionState(this);
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
    public final void localUpdateEntityActionState() {
        super.func_70626_be();
    }

    @Override
    public void func_70679_bo() {
        ServerPlayerAPI.updatePotionEffects(this);
    }

    @Override
    public final void realUpdatePotionEffects() {
        this.func_70679_bo();
    }

    @Override
    public final void superUpdatePotionEffects() {
        super.func_70679_bo();
    }

    @Override
    public final void localUpdatePotionEffects() {
        super.func_70679_bo();
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        ServerPlayerAPI.writeEntityToNBT(this, qoac2);
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
    public final net.minecraft.entity.player.ezey getCapabilitiesField() {
        return this.field_71075_bZ;
    }

    @Override
    public final void setCapabilitiesField(net.minecraft.entity.player.ezey ezey2) {
        this.field_71075_bZ = ezey2;
    }

    @Override
    public final boolean getChatColoursField() {
        return this.field_71140_co;
    }

    @Override
    public final void setChatColoursField(boolean bl) {
        this.field_71140_co = bl;
    }

    @Override
    public final int getChatVisibilityField() {
        return this.field_71143_cn;
    }

    @Override
    public final void setChatVisibilityField(int n) {
        this.field_71143_cn = n;
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
    public final int getCurrentWindowIdField() {
        return this.field_71139_cq;
    }

    @Override
    public final void setCurrentWindowIdField(int n) {
        this.field_71139_cq = n;
    }

    @Override
    public final ezey getDataWatcherField() {
        return this.field_70180_af;
    }

    @Override
    public final void setDataWatcherField(ezey ezey2) {
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

    public final List getDestroyedItemsNetCacheField() {
        return this.field_71130_g;
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
    public final float getField_130068_bOField() {
        return this.field_130068_bO;
    }

    @Override
    public final void setField_130068_bOField(float f) {
        this.field_130068_bO = f;
    }

    @Override
    public final long getField_143005_bXField() {
        return this.field_143005_bX;
    }

    @Override
    public final void setField_143005_bXField(long l) {
        this.field_143005_bX = l;
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
    public final int getInitialInvulnerabilityField() {
        return this.field_71145_cl;
    }

    @Override
    public final void setInitialInvulnerabilityField(int n) {
        this.field_71145_cl = n;
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
    public final int getLastExperienceField() {
        return this.field_71144_ck;
    }

    @Override
    public final void setLastExperienceField(int n) {
        this.field_71144_ck = n;
    }

    @Override
    public final int getLastFoodLevelField() {
        return this.field_71146_ci;
    }

    @Override
    public final void setLastFoodLevelField(int n) {
        this.field_71146_ci = n;
    }

    @Override
    public final float getLastHealthField() {
        return this.field_71149_ch;
    }

    @Override
    public final void setLastHealthField(float f) {
        this.field_71149_ch = f;
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

    public final List getLoadedChunksField() {
        return this.field_71129_f;
    }

    @Override
    public final double getManagedPosXField() {
        return this.field_71131_d;
    }

    @Override
    public final void setManagedPosXField(double d) {
        this.field_71131_d = d;
    }

    @Override
    public final double getManagedPosZField() {
        return this.field_71132_e;
    }

    @Override
    public final void setManagedPosZField(double d) {
        this.field_71132_e = d;
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
    public final dzfd getMcServerField() {
        return this.field_71133_b;
    }

    @Override
    public final void setMcServerField(dzfd dzfd2) {
        this.field_71133_b = dzfd2;
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
    public final int getPingField() {
        return this.field_71138_i;
    }

    @Override
    public final void setPingField(int n) {
        this.field_71138_i = n;
    }

    @Override
    public final boolean getPlayerConqueredTheEndField() {
        return this.field_71136_j;
    }

    @Override
    public final void setPlayerConqueredTheEndField(boolean bl) {
        this.field_71136_j = bl;
    }

    @Override
    public final boolean getPlayerInventoryBeingManipulatedField() {
        return this.field_71137_h;
    }

    @Override
    public final void setPlayerInventoryBeingManipulatedField(boolean bl) {
        this.field_71137_h = bl;
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
    public final xbvu getPlayerNetServerHandlerField() {
        return this.field_71135_a;
    }

    @Override
    public final void setPlayerNetServerHandlerField(xbvu xbvu2) {
        this.field_71135_a = xbvu2;
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
    public final int getRenderDistanceField() {
        return this.field_71142_cm;
    }

    @Override
    public final void setRenderDistanceField(int n) {
        this.field_71142_cm = n;
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
    public final mbsl getTheItemInWorldManagerField() {
        return this.field_71134_c;
    }

    @Override
    public final void setTheItemInWorldManagerField(mbsl mbsl2) {
        this.field_71134_c = mbsl2;
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
    public final int getTimeUntilPortalField() {
        return this.field_71088_bW;
    }

    @Override
    public final void setTimeUntilPortalField(int n) {
        this.field_71088_bW = n;
    }

    @Override
    public final String getTranslatorField() {
        return this.field_71148_cg;
    }

    @Override
    public final void setTranslatorField(String string) {
        this.field_71148_cg = string;
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
    public final boolean getWasHungryField() {
        return this.field_71147_cj;
    }

    @Override
    public final void setWasHungryField(boolean bl) {
        this.field_71147_cj = bl;
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
    public final ServerPlayerBase getServerPlayerBase(String string) {
        return ServerPlayerAPI.getServerPlayerBase(this, string);
    }

    public final Set getServerPlayerBaseIds() {
        return ServerPlayerAPI.getServerPlayerBaseIds(this);
    }

    @Override
    public final Object dynamic(String string, Object[] objectArray) {
        return ServerPlayerAPI.dynamic(this, string, objectArray);
    }

    @Override
    public final ServerPlayerAPI getServerPlayerAPI() {
        return this.serverPlayerAPI;
    }

    @Override
    public final EntityPlayerMP getEntityPlayerMP() {
        return this;
    }
}

