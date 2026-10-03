/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.ugqx;
import net.minecraft.entity.vjsq;
import net.minecraft.util.amxi;
import net.minecraft.util.iurq;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajz;
import net.minecraft.util.turb;
import net.minecraft.util.vjvn;
import net.minecraft.util.zwaw;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.world.WorldEvent;

public class yfgy
extends ozlu {
    public final dzfd field_73061_a;
    public final ugqx field_73062_L;
    public final jjww field_73063_M;
    public Set field_73064_N;
    public TreeSet field_73065_O;
    public fotf field_73059_b;
    public boolean field_73058_d;
    public boolean field_73068_P;
    public int field_80004_Q;
    public final pljx field_85177_Q;
    public final xtbl field_135059_Q = new xtbl();
    public nwfk[] field_73067_Q = new nwfk[]{new nwfk((igvb)null), new nwfk((igvb)null)};
    public int field_73070_R;
    public static final vjvn[] field_73069_S = new vjvn[]{new vjvn(tgdv.field_77669_D.field_77779_bT, 0, 1, 3, 10), new vjvn(twgu.field_71988_x.field_71990_ca, 0, 1, 3, 10), new vjvn(twgu.field_71951_J.field_71990_ca, 0, 1, 3, 10), new vjvn(tgdv.field_77719_y.field_77779_bT, 0, 1, 1, 3), new vjvn(tgdv.field_77712_u.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77720_x.field_77779_bT, 0, 1, 1, 3), new vjvn(tgdv.field_77713_t.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77706_j.field_77779_bT, 0, 2, 3, 5), new vjvn(tgdv.field_77684_U.field_77779_bT, 0, 2, 3, 3)};
    public List field_94579_S = new ArrayList();
    public amxi field_73066_T;
    public Set<jjym> doneChunks = new HashSet<jjym>();
    public List<pljx> customTeleporters = new ArrayList<pljx>();

    public yfgy(dzfd dzfd2, mtms mtms2, String string, int n, nfhj nfhj2, fokl fokl2, jjmf jjmf2) {
        super(mtms2, string, nfhj2, rrte._a(n), fokl2, jjmf2);
        this.field_73061_a = dzfd2;
        this.field_73062_L = new ugqx(this);
        this.field_73063_M = new jjww(this, dzfd2.__ag()._u());
        if (this.field_73066_T == null) {
            this.field_73066_T = new amxi();
        }
        if (this.field_73064_N == null) {
            this.field_73064_N = new HashSet();
        }
        if (this.field_73065_O == null) {
            this.field_73065_O = new TreeSet();
        }
        this.field_85177_Q = new pljx(this);
        this.field_96442_D = new suor(dzfd2);
        qojj qojj2 = (qojj)this.field_72988_C._a(qojj.class, "scoreboard");
        if (qojj2 == null) {
            qojj2 = new qojj();
            this.field_72988_C._a("scoreboard", qojj2);
        }
        if (!(this instanceof rasa)) {
            qojj2._a(this.field_96442_D);
        }
        ((suor)this.field_96442_D)._a(qojj2);
        DimensionManager.setWorld(n, this);
    }

    @Override
    public void func_72835_b() {
        super.func_72835_b();
        if (this.func_72912_H()._t() && this.field_73013_u < 3) {
            this.field_73013_u = 3;
        }
        this.field_73011_w._e._b();
        if (this.func_73056_e()) {
            if (this.func_82736_K()._b("doDaylightCycle")) {
                long l = this.field_72986_A._g() + 24000L;
                this.field_72986_A._b(l - l % 24000L);
            }
            this.func_73053_d();
        }
        this.field_72984_F._a("mobSpawner");
        if (this.func_82736_K()._b("doMobSpawning")) {
            this.field_135059_Q._a(this, this.field_72985_G, this.field_72992_H, this.field_72986_A._f() % 400L == 0L);
        }
        this.field_72984_F._c("chunkSource");
        this.field_73020_y._b();
        int n = this.func_72967_a(1.0f);
        if (n != this.field_73008_k) {
            this.field_73008_k = n;
        }
        this.field_72986_A._a(this.field_72986_A._f() + 1L);
        if (this.func_82736_K()._b("doDaylightCycle")) {
            this.field_72986_A._b(this.field_72986_A._g() + 1L);
        }
        this.field_72984_F._c("tickPending");
        this.func_72955_a(false);
        this.field_72984_F._c("tickTiles");
        this.func_72893_g();
        this.field_72984_F._c("chunkMap");
        this.field_73063_M._b();
        this.field_72984_F._c("village");
        this.field_72982_D._a();
        this.field_72983_E._a();
        this.field_72984_F._c("portalForcer");
        this.field_85177_Q.func_85189_a(this.func_82737_E());
        for (pljx pljx2 : this.customTeleporters) {
            pljx2.func_85189_a(this.func_82737_E());
        }
        this.field_72984_F._b();
        this.func_73055_Q();
    }

    public yffo func_73057_a(net.minecraft.entity.jxsn jxsn2, int n, int n2, int n3) {
        List list2 = this.func_72863_F()._a(jxsn2, n, n2, n3);
        return (list2 = ForgeEventFactory.getPotentialSpawns(this, jxsn2, n, n2, n3, list2)) != null && !list2.isEmpty() ? (yffo)iurq._a(this.field_73012_v, list2) : null;
    }

    @Override
    public void func_72854_c() {
        this.field_73068_P = !this.field_73010_i.isEmpty();
        for (EntityPlayer entityPlayer : this.field_73010_i) {
            if (entityPlayer.func_70608_bn()) continue;
            this.field_73068_P = false;
            break;
        }
    }

    public void func_73053_d() {
        this.field_73068_P = false;
        for (EntityPlayer entityPlayer : this.field_73010_i) {
            if (!entityPlayer.func_70608_bn()) continue;
            entityPlayer.func_70999_a(false, false, true);
        }
        this.func_73051_P();
    }

    public void func_73051_P() {
        this.field_73011_w._D();
    }

    public boolean func_73056_e() {
        if (this.field_73068_P && !this.field_72995_K) {
            EntityPlayer entityPlayer;
            Iterator iterator2 = this.field_73010_i.iterator();
            do {
                if (iterator2.hasNext()) continue;
                return true;
            } while ((entityPlayer = (EntityPlayer)iterator2.next()).func_71026_bH());
            return false;
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_72974_f() {
        if (this.field_72986_A._d() <= 0) {
            this.field_72986_A._b(64);
        }
        int n = this.field_72986_A._c();
        int n2 = this.field_72986_A._e();
        int n3 = 0;
        while (this.func_72922_b(n, n2) == 0) {
            n += this.field_73012_v.nextInt(8) - this.field_73012_v.nextInt(8);
            n2 += this.field_73012_v.nextInt(8) - this.field_73012_v.nextInt(8);
            if (++n3 != 10000) continue;
        }
        this.field_72986_A._a(n);
        this.field_72986_A._c(n2);
    }

    @Override
    public void func_72893_g() {
        super.func_72893_g();
        int n = 0;
        int n2 = 0;
        Iterator iterator2 = this.field_72993_I.iterator();
        this.doneChunks.retainAll(this.field_72993_I);
        if (this.doneChunks.size() == this.field_72993_I.size()) {
            this.doneChunks.clear();
        }
        long l = System.nanoTime();
        while (iterator2.hasNext()) {
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            jjym jjym2 = (jjym)iterator2.next();
            int n8 = jjym2._a * 16;
            int n9 = jjym2._b * 16;
            this.field_72984_F._a("getChunk");
            ixzi ixzi2 = this.func_72964_e(jjym2._a, jjym2._b);
            this.func_72941_a(n8, n9, ixzi2);
            this.field_72984_F._c("tickChunk");
            if (System.nanoTime() - l <= 4000000L && this.doneChunks.add(jjym2)) {
                ixzi2._j();
            }
            this.field_72984_F._c("thunder");
            if (this.field_73011_w._a(ixzi2) && this.field_73012_v.nextInt(100000) == 0 && this.func_72896_J() && this.func_72911_I()) {
                this.field_73005_l = this.field_73005_l * 3 + 1013904223;
                n7 = this.field_73005_l >> 2;
                n6 = n8 + (n7 & 0xF);
                n5 = n9 + (n7 >> 8 & 0xF);
                n4 = this.func_72874_g(n6, n5);
                if (this.func_72951_B(n6, n4, n5)) {
                    this.func_72942_c(new EntityLightningBolt(this, n6, n4, n5));
                }
            }
            this.field_72984_F._c("iceandsnow");
            if (this.field_73011_w._b(ixzi2) && this.field_73012_v.nextInt(16) == 0) {
                Object object;
                this.field_73005_l = this.field_73005_l * 3 + 1013904223;
                n7 = this.field_73005_l >> 2;
                n6 = n7 & 0xF;
                n5 = n7 >> 8 & 0xF;
                n4 = this.func_72874_g(n6 + n8, n5 + n9);
                if (this.func_72850_v(n6 + n8, n4 - 1, n5 + n9)) {
                    this.func_94575_c(n6 + n8, n4 - 1, n5 + n9, twgu.field_72036_aT.field_71990_ca);
                }
                if (this.func_72896_J() && this.func_72858_w(n6 + n8, n4, n5 + n9)) {
                    this.func_94575_c(n6 + n8, n4, n5 + n9, twgu.field_72037_aS.field_71990_ca);
                }
                if (this.func_72896_J() && ((foqh)(object = this.func_72807_a(n6 + n8, n5 + n9)))._e() && (n3 = this.func_72798_a(n6 + n8, n4 - 1, n5 + n9)) != 0) {
                    twgu.field_71973_m[n3].func_71892_f(this, n6 + n8, n4 - 1, n5 + n9);
                }
            }
            this.field_72984_F._c("tickTiles");
            for (ujzm ujzm2 : ixzi2._b()) {
                if (ujzm2 == null || !ujzm2._b()) continue;
                for (int i = 0; i < 3; ++i) {
                    this.field_73005_l = this.field_73005_l * 3 + 1013904223;
                    n3 = this.field_73005_l >> 2;
                    int n10 = n3 & 0xF;
                    int n11 = n3 >> 8 & 0xF;
                    int n12 = n3 >> 16 & 0xF;
                    int n13 = ujzm2._a(n10, n12, n11);
                    ++n2;
                    twgu twgu2 = twgu.field_71973_m[n13];
                    if (twgu2 == null || !twgu2.func_71881_r()) continue;
                    ++n;
                    twgu2.func_71847_b(this, n10 + n8, n12 + ujzm2._c(), n11 + n9, this.field_73012_v);
                }
            }
            this.field_72984_F._b();
        }
    }

    @Override
    public boolean func_94573_a(int n, int n2, int n3, int n4) {
        cfex cfex2 = new cfex(n, n2, n3, n4);
        return this.field_94579_S.contains(cfex2);
    }

    @Override
    public void func_72836_a(int n, int n2, int n3, int n4, int n5) {
        this.func_82740_a(n, n2, n3, n4, n5, 0);
    }

    @Override
    public void func_82740_a(int n, int n2, int n3, int n4, int n5, int n6) {
        cfex cfex2 = new cfex(n, n2, n3, n4);
        int n7 = 0;
        if (this.field_72999_e && n4 > 0) {
            if (twgu.field_71973_m[n4].func_82506_l()) {
                int n8;
                n7 = 8;
                if (this.func_72904_c(cfex2._b - n7, cfex2._c - n7, cfex2._d - n7, cfex2._b + n7, cfex2._c + n7, cfex2._d + n7) && (n8 = this.func_72798_a(cfex2._b, cfex2._c, cfex2._d)) == cfex2._e && n8 > 0) {
                    twgu.field_71973_m[n8].func_71847_b(this, cfex2._b, cfex2._c, cfex2._d, this.field_73012_v);
                }
                return;
            }
            n5 = 1;
        }
        if (this.func_72904_c(n - n7, n2 - n7, n3 - n7, n + n7, n2 + n7, n3 + n7)) {
            if (n4 > 0) {
                cfex2._a((long)n5 + this.field_72986_A._f());
                cfex2._a(n6);
            }
            if (!this.field_73064_N.contains(cfex2)) {
                this.field_73064_N.add(cfex2);
                this.field_73065_O.add(cfex2);
            }
        }
    }

    @Override
    public void func_72892_b(int n, int n2, int n3, int n4, int n5, int n6) {
        cfex cfex2 = new cfex(n, n2, n3, n4);
        cfex2._a(n6);
        if (n4 > 0) {
            cfex2._a((long)n5 + this.field_72986_A._f());
        }
        if (!this.field_73064_N.contains(cfex2)) {
            this.field_73064_N.add(cfex2);
            this.field_73065_O.add(cfex2);
        }
    }

    @Override
    public void func_72939_s() {
        if (this.field_73010_i.isEmpty() && this.getPersistentChunks().isEmpty()) {
            if (this.field_80004_Q++ >= 1200) {
                return;
            }
        } else {
            this.func_82742_i();
        }
        super.func_72939_s();
    }

    public void func_82742_i() {
        this.field_80004_Q = 0;
    }

    @Override
    public boolean func_72955_a(boolean bl) {
        cfex cfex2;
        int n = this.field_73065_O.size();
        if (n != this.field_73064_N.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if (n > 1000) {
            n = 1000;
        }
        this.field_72984_F._a("cleaning");
        for (int i = 0; i < n; ++i) {
            cfex2 = (cfex)this.field_73065_O.first();
            if (!bl && cfex2._f > this.field_72986_A._f()) break;
            this.field_73065_O.remove(cfex2);
            this.field_73064_N.remove(cfex2);
            this.field_94579_S.add(cfex2);
        }
        this.field_72984_F._b();
        this.field_72984_F._a("ticking");
        Iterator iterator2 = this.field_94579_S.iterator();
        while (iterator2.hasNext()) {
            cfex2 = (cfex)iterator2.next();
            iterator2.remove();
            int n2 = 0;
            if (this.func_72904_c(cfex2._b - n2, cfex2._c - n2, cfex2._d - n2, cfex2._b + n2, cfex2._c + n2, cfex2._d + n2)) {
                int n3 = this.func_72798_a(cfex2._b, cfex2._c, cfex2._d);
                if (n3 <= 0 || !twgu.func_94329_b(n3, cfex2._e)) continue;
                try {
                    twgu.field_71973_m[n3].func_71847_b(this, cfex2._b, cfex2._c, cfex2._d, this.field_73012_v);
                    continue;
                }
                catch (Throwable throwable) {
                    int n4;
                    CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception while ticking a block");
                    jxsn jxsn2 = crashReport.func_85058_a("Block being ticked");
                    try {
                        n4 = this.func_72805_g(cfex2._b, cfex2._c, cfex2._d);
                    }
                    catch (Throwable throwable2) {
                        n4 = -1;
                    }
                    jxsn._a(jxsn2, cfex2._b, cfex2._c, cfex2._d, n3, n4);
                    throw new turb(crashReport);
                }
            }
            this.func_72836_a(cfex2._b, cfex2._c, cfex2._d, cfex2._e, 0);
        }
        this.field_72984_F._b();
        this.field_94579_S.clear();
        return !this.field_73065_O.isEmpty();
    }

    @Override
    public List func_72920_a(ixzi ixzi2, boolean bl) {
        ArrayList<cfex> arrayList = null;
        jjym jjym2 = ixzi2._k();
        int n = (jjym2._a << 4) - 2;
        int n2 = n + 16 + 2;
        int n3 = (jjym2._b << 4) - 2;
        int n4 = n3 + 16 + 2;
        for (int i = 0; i < 2; ++i) {
            Iterator iterator2;
            if (i == 0) {
                iterator2 = this.field_73065_O.iterator();
            } else {
                iterator2 = this.field_94579_S.iterator();
                if (!this.field_94579_S.isEmpty()) {
                    System.out.println(this.field_94579_S.size());
                }
            }
            while (iterator2.hasNext()) {
                cfex cfex2 = (cfex)iterator2.next();
                if (cfex2._b < n || cfex2._b >= n2 || cfex2._d < n3 || cfex2._d >= n4) continue;
                if (bl) {
                    this.field_73064_N.remove(cfex2);
                    iterator2.remove();
                }
                if (arrayList == null) {
                    arrayList = new ArrayList<cfex>();
                }
                arrayList.add(cfex2);
            }
        }
        return arrayList;
    }

    @Override
    public void func_72866_a(Entity entity, boolean bl) {
        if (!this.field_73061_a._Y() && (entity instanceof EntityAnimal || entity instanceof EntityWaterMob)) {
            entity.func_70106_y();
        }
        if (!this.field_73061_a._Z() && entity instanceof vjsq) {
            entity.func_70106_y();
        }
        super.func_72866_a(entity, bl);
    }

    @Override
    public mccn func_72970_h() {
        bcgt bcgt2 = this.field_73019_z.func_75763_a(this.field_73011_w);
        this.field_73059_b = new fotf(this, bcgt2, this.field_73011_w._c());
        return this.field_73059_b;
    }

    public List func_73049_a(int n, int n2, int n3, int n4, int n5, int n6) {
        ArrayList<hurg> arrayList = new ArrayList<hurg>();
        for (int i = n >> 4; i <= n4 >> 4; ++i) {
            for (int j = n3 >> 4; j <= n6 >> 4; ++j) {
                ixzi ixzi2 = this.func_72964_e(i, j);
                if (ixzi2 == null) continue;
                for (Object v : ixzi2._l.values()) {
                    hurg hurg2 = (hurg)v;
                    if (hurg2.func_70320_p() || hurg2.field_70329_l < n || hurg2.field_70330_m < n2 || hurg2.field_70327_n < n3 || hurg2.field_70329_l > n4 || hurg2.field_70330_m > n5 || hurg2.field_70327_n > n6) continue;
                    arrayList.add(hurg2);
                }
            }
        }
        return arrayList;
    }

    @Override
    public boolean func_72962_a(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return super.func_72962_a(entityPlayer, n, n2, n3);
    }

    @Override
    public boolean canMineBlockBody(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return !this.field_73061_a._a(this, n, n2, n3, entityPlayer);
    }

    @Override
    public void func_72963_a(nfhj nfhj2) {
        if (this.field_73066_T == null) {
            this.field_73066_T = new amxi();
        }
        if (this.field_73064_N == null) {
            this.field_73064_N = new HashSet();
        }
        if (this.field_73065_O == null) {
            this.field_73065_O = new TreeSet();
        }
        this.func_73052_b(nfhj2);
        super.func_72963_a(nfhj2);
    }

    public void func_73052_b(nfhj nfhj2) {
        if (!this.field_73011_w._e()) {
            this.field_72986_A._a(0, this.field_73011_w._i(), 0);
        } else {
            this.field_72987_B = true;
            foqg foqg2 = this.field_73011_w._e;
            List list2 = foqg2._a();
            Random random = new Random(this.func_72905_C());
            xtcd xtcd2 = foqg2._a(0, 0, 256, list2, random);
            int n = 0;
            int n2 = this.field_73011_w._i();
            int n3 = 0;
            if (xtcd2 != null) {
                n = xtcd2._d;
                n3 = xtcd2._f;
            } else {
                this.func_98180_V()._b("Unable to find spawn biome");
            }
            int n4 = 0;
            while (!this.field_73011_w._a(n, n3)) {
                n += random.nextInt(64) - random.nextInt(64);
                n3 += random.nextInt(64) - random.nextInt(64);
                if (++n4 != 1000) continue;
            }
            this.field_72986_A._a(n, n2, n3);
            this.field_72987_B = false;
            if (nfhj2._c()) {
                this.func_73047_i();
            }
        }
    }

    public void func_73047_i() {
        int n;
        int n2;
        int n3;
        ukai ukai2 = new ukai(ChestGenHooks.getItems("bonusChest", this.field_73012_v), ChestGenHooks.getCount("bonusChest", this.field_73012_v));
        for (int i = 0; i < 10 && !ukai2._a(this, this.field_73012_v, n3 = this.field_72986_A._c() + this.field_73012_v.nextInt(6) - this.field_73012_v.nextInt(6), n2 = this.func_72825_h(n3, n = this.field_72986_A._e() + this.field_73012_v.nextInt(6) - this.field_73012_v.nextInt(6)) + 1, n); ++i) {
        }
    }

    public zwaw func_73054_j() {
        return this.field_73011_w._h();
    }

    public void func_73044_a(boolean bl, sajz sajz2) throws xcad {
        if (this.field_73020_y._c()) {
            if (sajz2 != null) {
                sajz2._b("Saving level");
            }
            this.func_73042_a();
            if (sajz2 != null) {
                sajz2._d("Saving chunks");
            }
            this.field_73020_y._a(bl, sajz2);
            MinecraftForge.EVENT_BUS.post(new WorldEvent.Save(this));
        }
    }

    public void func_104140_m() {
        if (this.field_73020_y._c()) {
            this.field_73020_y._a();
        }
    }

    public void func_73042_a() throws xcad {
        this.func_72906_B();
        this.field_73019_z.func_75755_a(this.field_72986_A, this.field_73061_a.__ag()._c());
        this.field_72988_C._a();
        this.perWorldStorage._a();
    }

    @Override
    public void func_72923_a(Entity entity) {
        super.func_72923_a(entity);
        this.field_73066_T._a(entity.field_70157_k, entity);
        Entity[] entityArray = entity.func_70021_al();
        if (entityArray != null) {
            for (int i = 0; i < entityArray.length; ++i) {
                this.field_73066_T._a(entityArray[i].field_70157_k, entityArray[i]);
            }
        }
    }

    @Override
    public void func_72847_b(Entity entity) {
        super.func_72847_b(entity);
        this.field_73066_T._f(entity.field_70157_k);
        Entity[] entityArray = entity.func_70021_al();
        if (entityArray != null) {
            for (int i = 0; i < entityArray.length; ++i) {
                this.field_73066_T._f(entityArray[i].field_70157_k);
            }
        }
    }

    @Override
    public Entity func_73045_a(int n) {
        return (Entity)this.field_73066_T._b(n);
    }

    @Override
    public boolean func_72942_c(Entity entity) {
        if (super.func_72942_c(entity)) {
            this.field_73061_a.__ag()._a(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 512.0, this.field_73011_w._i, new dibg(entity));
            return true;
        }
        return false;
    }

    @Override
    public void func_72960_a(Entity entity, byte by) {
        bszz bszz2 = new bszz(entity.field_70157_k, by);
        this.func_73039_n()._b(entity, bszz2);
    }

    @Override
    public elkd func_72885_a(Entity entity, double d, double d2, double d3, float f, boolean bl, boolean bl2) {
        elkd elkd2 = new elkd(this, entity, d, d2, d3, f);
        elkd2._a = bl;
        elkd2._b = bl2;
        elkd2._a();
        elkd2._a(false);
        if (!bl2) {
            elkd2._k.clear();
        }
        for (EntityPlayer entityPlayer : this.field_73010_i) {
            if (!(entityPlayer.func_70092_e(d, d2, d3) < 4096.0)) continue;
            ((EntityPlayerMP)entityPlayer).field_71135_a.func_72567_b(new ozcz(d, d2, d3, f, elkd2._k, (ofbx)elkd2._b().get(entityPlayer)));
        }
        return elkd2;
    }

    @Override
    public void func_72965_b(int n, int n2, int n3, int n4, int n5, int n6) {
        ejzh ejzh2;
        ejzh ejzh3 = new ejzh(n, n2, n3, n4, n5, n6);
        Iterator iterator2 = this.field_73067_Q[this.field_73070_R].iterator();
        do {
            if (iterator2.hasNext()) continue;
            this.field_73067_Q[this.field_73070_R].add(ejzh3);
            return;
        } while (!(ejzh2 = (ejzh)iterator2.next()).equals(ejzh3));
    }

    public void func_73055_Q() {
        while (!this.field_73067_Q[this.field_73070_R].isEmpty()) {
            int n = this.field_73070_R;
            this.field_73070_R ^= 1;
            for (ejzh ejzh2 : this.field_73067_Q[n]) {
                if (!this.func_73043_a(ejzh2)) continue;
                this.field_73061_a.__ag()._a(ejzh2._a(), ejzh2._b(), ejzh2._c(), 64.0, this.field_73011_w._i, new ujsb(ejzh2._a(), ejzh2._b(), ejzh2._c(), ejzh2._f(), ejzh2._d(), ejzh2._e()));
            }
            this.field_73067_Q[n].clear();
        }
    }

    public boolean func_73043_a(ejzh ejzh2) {
        int n = this.func_72798_a(ejzh2._a(), ejzh2._b(), ejzh2._c());
        return n == ejzh2._f() ? twgu.field_71973_m[n].func_71883_b(this, ejzh2._a(), ejzh2._b(), ejzh2._c(), ejzh2._d(), ejzh2._e()) : false;
    }

    public void func_73041_k() {
        this.field_73019_z.func_75759_a();
    }

    @Override
    public void func_72979_l() {
        boolean bl = this.func_72896_J();
        super.func_72979_l();
        if (bl != this.func_72896_J()) {
            if (bl) {
                this.field_73061_a.__ag()._a(new tgph(2, 0));
            } else {
                this.field_73061_a.__ag()._a(new tgph(1, 0));
            }
        }
    }

    public dzfd func_73046_m() {
        return this.field_73061_a;
    }

    public ugqx func_73039_n() {
        return this.field_73062_L;
    }

    public jjww func_73040_p() {
        return this.field_73063_M;
    }

    public pljx func_85176_s() {
        return this.field_85177_Q;
    }

    public File getChunkSaveLocation() {
        return ((nffs)this.field_73059_b._d)._d;
    }
}

