/*
 * Decompiled with CFR 0.152.
 */
import atomicstryker.dynamiclights.client.DynamicLights;
import com.google.common.collect.ImmutableSetMultimap;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.bundle.pidb;
import gloomyfolken.mods.ejection.ezey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mods.sound.SoundHooks;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.iurn;
import net.minecraft.util.ofbx;
import net.minecraft.util.owak;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import net.minecraft.util.zwaw;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeDummyContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.WorldSpecificSaveHandler;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import org.jetbrains.annotations.Nullable;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public abstract class ozlu
implements sdrg {
    public static double MAX_ENTITY_RADIUS = 2.0;
    public final thda perWorldStorage;
    public boolean field_72999_e;
    public List field_72996_f = new ArrayList();
    public List field_72997_g = new ArrayList();
    public List field_73009_h = new ArrayList();
    public List field_73002_a = new ArrayList();
    public List field_73000_b = new ArrayList();
    public List field_73010_i = new ArrayList();
    public List field_73007_j = new ArrayList();
    public long field_73001_c = 0xFFFFFFL;
    public int field_73008_k;
    public int field_73005_l = new Random().nextInt();
    public final int field_73006_m = 1013904223;
    public float field_73003_n;
    public float field_73004_o;
    public float field_73018_p;
    public float field_73017_q;
    public int field_73016_r;
    public int field_73013_u;
    public Random field_73012_v = new Random();
    public final rrte field_73011_w;
    public List field_73021_x = new ArrayList();
    public mccn field_73020_y;
    public final mtms field_73019_z;
    public iyev field_72986_A;
    public boolean field_72987_B;
    public thda field_72988_C;
    public ywfm field_72982_D;
    public final rapl field_72983_E = new rapl(this);
    public final fokl field_72984_F;
    public final ThreadLocal<iurn> J = new ThreadLocal();
    public final Calendar field_83016_L = Calendar.getInstance();
    public fojy field_96442_D = new fojy();
    public final jjmf field_98181_L;
    public ArrayList field_72998_d = new ArrayList();
    public boolean field_72989_L;
    public boolean field_72985_G = true;
    public boolean field_72992_H = true;
    public Set field_72993_I = new HashSet();
    public int field_72990_M;
    public int[] field_72994_J;
    public boolean field_72995_K;
    public static thda s_mapStorage;
    public static mtms s_savehandler;

    @Override
    public foqh func_72807_a(int n, int n2) {
        return this.field_73011_w._c(n, n2);
    }

    public foqh getBiomeGenForCoordsBody(int n, int n2) {
        ixzi ixzi2;
        if (this.func_72899_e(n, 0, n2) && (ixzi2 = this.func_72938_d(n, n2)) != null) {
            return ixzi2._a(n & 0xF, n2 & 0xF, this.field_73011_w._e);
        }
        return this.field_73011_w._e._a(n, n2);
    }

    public foqg func_72959_q() {
        return this.field_73011_w._e;
    }

    @SideOnly(value=Side.CLIENT)
    public ozlu(mtms mtms2, String string, rrte rrte2, nfhj nfhj2, fokl fokl2, jjmf jjmf2) {
        this.J.set(new iurn(300, 2000));
        this.field_72990_M = this.field_73012_v.nextInt(12000);
        this.field_72994_J = new int[32768];
        this.field_73019_z = mtms2;
        this.field_72984_F = fokl2;
        this.field_72986_A = new iyev(nfhj2, string);
        this.field_73011_w = rrte2;
        this.perWorldStorage = new thda(null);
        this.field_98181_L = jjmf2;
    }

    @SideOnly(value=Side.CLIENT)
    public void finishSetup() {
        ywfm ywfm2 = (ywfm)this.field_72988_C._a(ywfm.class, "villages");
        if (ywfm2 == null) {
            this.field_72982_D = new ywfm(this);
            this.field_72988_C._a("villages", this.field_72982_D);
        } else {
            this.field_72982_D = ywfm2;
            this.field_72982_D._a(this);
        }
        int n = this.field_73011_w._i;
        this.field_73011_w._a(this);
        this.field_73011_w._i = n;
        this.field_73020_y = this.func_72970_h();
        this.func_72966_v();
        this.func_72947_a();
    }

    public ozlu(mtms mtms2, String string, nfhj nfhj2, rrte rrte2, fokl fokl2, jjmf jjmf2) {
        ywfm ywfm2;
        this.J.set(new iurn(300, 2000));
        this.field_72990_M = this.field_73012_v.nextInt(12000);
        this.field_72994_J = new int[32768];
        this.field_73019_z = mtms2;
        this.field_72984_F = fokl2;
        this.field_72988_C = this.getMapStorage(mtms2);
        this.field_98181_L = jjmf2;
        this.field_72986_A = mtms2.func_75757_d();
        this.field_73011_w = rrte2 != null ? rrte2 : (this.field_72986_A != null && this.field_72986_A._j() != 0 ? rrte._a(this.field_72986_A._j()) : rrte._a(0));
        if (this.field_72986_A == null) {
            this.field_72986_A = new iyev(nfhj2, string);
        } else {
            this.field_72986_A._a(string);
        }
        this.field_73011_w._a(this);
        this.field_73020_y = this.func_72970_h();
        this.perWorldStorage = this instanceof yfgy ? new thda(new WorldSpecificSaveHandler((yfgy)this, mtms2)) : new thda(null);
        if (!this.field_72986_A._w()) {
            try {
                this.func_72963_a(nfhj2);
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception initializing level");
                try {
                    this.func_72914_a(crashReport);
                }
                catch (Throwable throwable2) {
                    // empty catch block
                }
                throw new turb(crashReport);
            }
            this.field_72986_A._c(true);
        }
        if ((ywfm2 = (ywfm)this.perWorldStorage._a(ywfm.class, "villages")) == null) {
            this.field_72982_D = new ywfm(this);
            this.perWorldStorage._a("villages", this.field_72982_D);
        } else {
            this.field_72982_D = ywfm2;
            this.field_72982_D._a(this);
        }
        this.func_72966_v();
        this.func_72947_a();
    }

    public thda getMapStorage(mtms mtms2) {
        if (s_savehandler != mtms2 || s_mapStorage == null) {
            s_mapStorage = new thda(mtms2);
            s_savehandler = mtms2;
        }
        return s_mapStorage;
    }

    public abstract mccn func_72970_h();

    public void func_72963_a(nfhj nfhj2) {
        this.field_72986_A._c(true);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_72974_f() {
        this.func_72950_A(8, 64, 8);
    }

    public int func_72922_b(int n, int n2) {
        int n3 = 63;
        while (!this.func_72799_c(n, n3 + 1, n2)) {
            ++n3;
        }
        return this.func_72798_a(n, n3, n2);
    }

    @Override
    public int func_72798_a(int n, int n2, int n3) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            if (n2 < 0) {
                return 0;
            }
            if (n2 >= 256) {
                return 0;
            }
            ixzi ixzi2 = null;
            try {
                ixzi2 = this.func_72964_e(n >> 4, n3 >> 4);
                return ixzi2._d(n & 0xF, n2, n3 & 0xF);
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception getting block type in world");
                jxsn jxsn2 = crashReport.func_85058_a("Requested block coordinates");
                jxsn2._a("Found chunk", ixzi2 == null);
                jxsn2._a("Location", jxsn._a(n, n2, n3));
                throw new turb(crashReport);
            }
        }
        return 0;
    }

    @Override
    public boolean func_72799_c(int n, int n2, int n3) {
        int n4 = this.func_72798_a(n, n2, n3);
        return n4 == 0 || twgu.field_71973_m[n4] == null || twgu.field_71973_m[n4].isAirBlock(this, n, n2, n3);
    }

    public boolean func_72927_d(int n, int n2, int n3) {
        int n4 = this.func_72798_a(n, n2, n3);
        int n5 = this.func_72805_g(n, n2, n3);
        return twgu.field_71973_m[n4] != null && twgu.field_71973_m[n4].hasTileEntity(n5);
    }

    public int func_85175_e(int n, int n2, int n3) {
        int n4 = this.func_72798_a(n, n2, n3);
        return twgu.field_71973_m[n4] != null ? twgu.field_71973_m[n4].func_71857_b() : -1;
    }

    public boolean func_72899_e(int n, int n2, int n3) {
        return n2 >= 0 && n2 < 256 ? this.func_72916_c(n >> 4, n3 >> 4) : false;
    }

    public boolean func_72873_a(int n, int n2, int n3, int n4) {
        return this.func_72904_c(n - n4, n2 - n4, n3 - n4, n + n4, n2 + n4, n3 + n4);
    }

    public boolean func_72904_c(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n5 >= 0 && n2 < 256) {
            n3 >>= 4;
            n4 >>= 4;
            n6 >>= 4;
            for (int i = n >>= 4; i <= n4; ++i) {
                for (int j = n3; j <= n6; ++j) {
                    if (this.func_72916_c(i, j)) continue;
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean func_72916_c(int n, int n2) {
        return this.field_73020_y._c(n, n2);
    }

    public ixzi func_72938_d(int n, int n2) {
        return this.func_72964_e(n >> 4, n2 >> 4);
    }

    public ixzi func_72964_e(int n, int n2) {
        return this.field_73020_y._b(n, n2);
    }

    public boolean func_72832_d(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            if (n2 < 0) {
                return false;
            }
            if (n2 >= 256) {
                return false;
            }
            ixzi ixzi2 = this.func_72964_e(n >> 4, n3 >> 4);
            int n7 = 0;
            if ((n6 & 1) != 0) {
                n7 = ixzi2._d(n & 0xF, n2, n3 & 0xF);
            }
            boolean bl = ixzi2._a(n & 0xF, n2, n3 & 0xF, n4, n5);
            this.field_72984_F._a("checkLight");
            this.func_72969_x(n, n2, n3);
            this.field_72984_F._b();
            if (bl) {
                if (!((n6 & 2) == 0 || this.field_72995_K && (n6 & 4) != 0)) {
                    this.func_72845_h(n, n2, n3);
                }
                if (!this.field_72995_K && (n6 & 1) != 0) {
                    this.func_72851_f(n, n2, n3, n7);
                    twgu twgu2 = twgu.field_71973_m[n4];
                    if (twgu2 != null && twgu2.func_96468_q_()) {
                        this.func_96440_m(n, n2, n3, n4);
                    }
                }
            }
            return bl;
        }
        return false;
    }

    @Override
    public tflj func_72803_f(int n, int n2, int n3) {
        int n4 = this.func_72798_a(n, n2, n3);
        return n4 == 0 ? tflj._a : twgu.field_71973_m[n4].field_72018_cp;
    }

    @Override
    public int func_72805_g(int n, int n2, int n3) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            if (n2 < 0) {
                return 0;
            }
            if (n2 >= 256) {
                return 0;
            }
            ixzi ixzi2 = this.func_72964_e(n >> 4, n3 >> 4);
            return ixzi2._e(n &= 0xF, n2, n3 &= 0xF);
        }
        return 0;
    }

    public boolean func_72921_c(int n, int n2, int n3, int n4, int n5) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            int n6;
            int n7;
            if (n2 < 0) {
                return false;
            }
            if (n2 >= 256) {
                return false;
            }
            ixzi ixzi2 = this.func_72964_e(n >> 4, n3 >> 4);
            boolean bl = ixzi2._b(n7 = n & 0xF, n2, n6 = n3 & 0xF, n4);
            if (bl) {
                int n8 = ixzi2._d(n7, n2, n6);
                if (!((n5 & 2) == 0 || this.field_72995_K && (n5 & 4) != 0)) {
                    this.func_72845_h(n, n2, n3);
                }
                if (!this.field_72995_K && (n5 & 1) != 0) {
                    this.func_72851_f(n, n2, n3, n8);
                    twgu twgu2 = twgu.field_71973_m[n8];
                    if (twgu2 != null && twgu2.func_96468_q_()) {
                        this.func_96440_m(n, n2, n3, n8);
                    }
                }
            }
            return bl;
        }
        return false;
    }

    public boolean func_94571_i(int n, int n2, int n3) {
        return this.func_72832_d(n, n2, n3, 0, 0, 3);
    }

    public boolean func_94578_a(int n, int n2, int n3, boolean bl) {
        int n4 = this.func_72798_a(n, n2, n3);
        if (n4 > 0) {
            int n5 = this.func_72805_g(n, n2, n3);
            this.func_72926_e(2001, n, n2, n3, n4 + (n5 << 12));
            if (bl) {
                twgu.field_71973_m[n4].func_71897_c(this, n, n2, n3, n5, 0);
            }
            return this.func_72832_d(n, n2, n3, 0, 0, 3);
        }
        return false;
    }

    public boolean func_94575_c(int n, int n2, int n3, int n4) {
        return this.func_72832_d(n, n2, n3, n4, 0, 3);
    }

    public void func_72845_h(int n, int n2, int n3) {
        for (int i = 0; i < this.field_73021_x.size(); ++i) {
            ((aqaj)this.field_73021_x.get(i))._b(n, n2, n3);
        }
    }

    public void func_72851_f(int n, int n2, int n3, int n4) {
        this.func_72898_h(n, n2, n3, n4);
    }

    public void func_72975_g(int n, int n2, int n3, int n4) {
        int n5;
        if (n3 > n4) {
            n5 = n4;
            n4 = n3;
            n3 = n5;
        }
        if (!this.field_73011_w._g) {
            for (n5 = n3; n5 <= n4; ++n5) {
                this.func_72936_c(rrqi._a, n, n5, n2);
            }
        }
        this.func_72909_d(n, n3, n2, n, n4, n2);
    }

    public void func_72909_d(int n, int n2, int n3, int n4, int n5, int n6) {
        for (int i = 0; i < this.field_73021_x.size(); ++i) {
            ((aqaj)this.field_73021_x.get(i))._b(n, n2, n3, n4, n5, n6);
        }
    }

    public void func_72898_h(int n, int n2, int n3, int n4) {
        this.func_72821_m(n - 1, n2, n3, n4);
        this.func_72821_m(n + 1, n2, n3, n4);
        this.func_72821_m(n, n2 - 1, n3, n4);
        this.func_72821_m(n, n2 + 1, n3, n4);
        this.func_72821_m(n, n2, n3 - 1, n4);
        this.func_72821_m(n, n2, n3 + 1, n4);
    }

    public void func_96439_d(int n, int n2, int n3, int n4, int n5) {
        if (n5 != 4) {
            this.func_72821_m(n - 1, n2, n3, n4);
        }
        if (n5 != 5) {
            this.func_72821_m(n + 1, n2, n3, n4);
        }
        if (n5 != 0) {
            this.func_72821_m(n, n2 - 1, n3, n4);
        }
        if (n5 != 1) {
            this.func_72821_m(n, n2 + 1, n3, n4);
        }
        if (n5 != 2) {
            this.func_72821_m(n, n2, n3 - 1, n4);
        }
        if (n5 != 3) {
            this.func_72821_m(n, n2, n3 + 1, n4);
        }
    }

    public void func_72821_m(int n, int n2, int n3, int n4) {
        int n5;
        twgu twgu2;
        if (!this.field_72995_K && (twgu2 = twgu.field_71973_m[n5 = this.func_72798_a(n, n2, n3)]) != null) {
            try {
                twgu2.func_71863_a(this, n, n2, n3, n4);
            }
            catch (Throwable throwable) {
                int n6;
                CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception while updating neighbours");
                jxsn jxsn2 = crashReport.func_85058_a("Block being updated");
                try {
                    n6 = this.func_72805_g(n, n2, n3);
                }
                catch (Throwable throwable2) {
                    n6 = -1;
                }
                jxsn2._a("Source block type", new ywfb(this, n4));
                jxsn._a(jxsn2, n, n2, n3, n5, n6);
                throw new turb(crashReport);
            }
        }
    }

    public boolean func_94573_a(int n, int n2, int n3, int n4) {
        return false;
    }

    public boolean func_72937_j(int n, int n2, int n3) {
        return this.func_72964_e(n >> 4, n3 >> 4)._f(n & 0xF, n2, n3 & 0xF);
    }

    public int func_72883_k(int n, int n2, int n3) {
        if (n2 < 0) {
            return 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        return this.func_72964_e(n >> 4, n3 >> 4)._c(n & 0xF, n2, n3 & 0xF, 0);
    }

    public int func_72957_l(int n, int n2, int n3) {
        return this.func_72849_a(n, n2, n3, true);
    }

    public int func_72849_a(int n, int n2, int n3, boolean bl) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            int n4;
            if (bl && twgu.field_71982_s[n4 = this.func_72798_a(n, n2, n3)]) {
                int n5 = this.func_72849_a(n, n2 + 1, n3, false);
                int n6 = this.func_72849_a(n + 1, n2, n3, false);
                int n7 = this.func_72849_a(n - 1, n2, n3, false);
                int n8 = this.func_72849_a(n, n2, n3 + 1, false);
                int n9 = this.func_72849_a(n, n2, n3 - 1, false);
                if (n6 > n5) {
                    n5 = n6;
                }
                if (n7 > n5) {
                    n5 = n7;
                }
                if (n8 > n5) {
                    n5 = n8;
                }
                if (n9 > n5) {
                    n5 = n9;
                }
                return n5;
            }
            if (n2 < 0) {
                return 0;
            }
            if (n2 >= 256) {
                n2 = 255;
            }
            ixzi ixzi2 = this.func_72964_e(n >> 4, n3 >> 4);
            return ixzi2._c(n &= 0xF, n2, n3 &= 0xF, this.field_73008_k);
        }
        return 15;
    }

    public int func_72976_f(int n, int n2) {
        if (n >= -30000000 && n2 >= -30000000 && n < 30000000 && n2 < 30000000) {
            if (!this.func_72916_c(n >> 4, n2 >> 4)) {
                return 0;
            }
            ixzi ixzi2 = this.func_72964_e(n >> 4, n2 >> 4);
            return ixzi2._b(n & 0xF, n2 & 0xF);
        }
        return 0;
    }

    public int func_82734_g(int n, int n2) {
        if (n >= -30000000 && n2 >= -30000000 && n < 30000000 && n2 < 30000000) {
            if (!this.func_72916_c(n >> 4, n2 >> 4)) {
                return 0;
            }
            ixzi ixzi2 = this.func_72964_e(n >> 4, n2 >> 4);
            return ixzi2._s;
        }
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_72925_a(rrqi rrqi2, int n, int n2, int n3) {
        if (this.field_73011_w._g && rrqi2 == rrqi._a) {
            return 0;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= 256) {
            return rrqi2._c;
        }
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            int n4 = n >> 4;
            int n5 = n3 >> 4;
            if (!this.func_72916_c(n4, n5)) {
                return rrqi2._c;
            }
            if (twgu.field_71982_s[this.func_72798_a(n, n2, n3)]) {
                int n6 = this.func_72972_b(rrqi2, n, n2 + 1, n3);
                int n7 = this.func_72972_b(rrqi2, n + 1, n2, n3);
                int n8 = this.func_72972_b(rrqi2, n - 1, n2, n3);
                int n9 = this.func_72972_b(rrqi2, n, n2, n3 + 1);
                int n10 = this.func_72972_b(rrqi2, n, n2, n3 - 1);
                if (n7 > n6) {
                    n6 = n7;
                }
                if (n8 > n6) {
                    n6 = n8;
                }
                if (n9 > n6) {
                    n6 = n9;
                }
                if (n10 > n6) {
                    n6 = n10;
                }
                return n6;
            }
            ixzi ixzi2 = this.func_72964_e(n4, n5);
            return ixzi2._a(rrqi2, n & 0xF, n2, n3 & 0xF);
        }
        return rrqi2._c;
    }

    public int func_72972_b(rrqi rrqi2, int n, int n2, int n3) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            int n4 = n >> 4;
            int n5 = n3 >> 4;
            if (!this.func_72916_c(n4, n5)) {
                return rrqi2._c;
            }
            ixzi ixzi2 = this.func_72964_e(n4, n5);
            return ixzi2._a(rrqi2, n & 0xF, n2, n3 & 0xF);
        }
        return rrqi2._c;
    }

    public void func_72915_b(rrqi rrqi2, int n, int n2, int n3, int n4) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000 && n2 >= 0 && n2 < 256 && this.func_72916_c(n >> 4, n3 >> 4)) {
            ixzi ixzi2 = this.func_72964_e(n >> 4, n3 >> 4);
            ixzi2._a(rrqi2, n & 0xF, n2, n3 & 0xF, n4);
            for (int i = 0; i < this.field_73021_x.size(); ++i) {
                ((aqaj)this.field_73021_x.get(i))._c(n, n2, n3);
            }
        }
    }

    public void func_72902_n(int n, int n2, int n3) {
        for (int i = 0; i < this.field_73021_x.size(); ++i) {
            ((aqaj)this.field_73021_x.get(i))._c(n, n2, n3);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_72802_i(int n, int n2, int n3, int n4) {
        int n5 = this.func_72925_a(rrqi._a, n, n2, n3);
        int n6 = this.func_72925_a(rrqi._b, n, n2, n3);
        if (n6 < n4) {
            n6 = n4;
        }
        return n5 << 20 | n6 << 4;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float func_72808_j(int n, int n2, int n3, int n4) {
        int n5 = this.func_72957_l(n, n2, n3);
        if (n5 < n4) {
            n5 = n4;
        }
        return this.field_73011_w._h[n5];
    }

    @Override
    public float func_72801_o(int n, int n2, int n3) {
        return this.field_73011_w._h[this.func_72957_l(n, n2, n3)];
    }

    public boolean func_72935_r() {
        return this.field_73011_w._t();
    }

    public hank func_72933_a(ofbx ofbx2, ofbx ofbx3) {
        return this.func_72831_a(ofbx2, ofbx3, false, false);
    }

    public hank func_72901_a(ofbx ofbx2, ofbx ofbx3, boolean bl) {
        return this.func_72831_a(ofbx2, ofbx3, bl, false);
    }

    @Nullable
    public hank func_72831_a(ofbx ofbx2, ofbx ofbx3, boolean bl, boolean bl2) {
        if (!(Double.isNaN(ofbx2._c) || Double.isNaN(ofbx2._d) || Double.isNaN(ofbx2._e))) {
            if (!(Double.isNaN(ofbx3._c) || Double.isNaN(ofbx3._d) || Double.isNaN(ofbx3._e))) {
                hank hank2;
                int n = sajh._c(ofbx3._c);
                int n2 = sajh._c(ofbx3._d);
                int n3 = sajh._c(ofbx3._e);
                int n4 = sajh._c(ofbx2._c);
                int n5 = sajh._c(ofbx2._d);
                int n6 = sajh._c(ofbx2._e);
                int n7 = this.func_72798_a(n4, n5, n6);
                int n8 = this.func_72805_g(n4, n5, n6);
                twgu twgu2 = twgu.field_71973_m[n7];
                if (twgu2 != null && (!bl2 || twgu2 == null || twgu2.func_71872_e(this, n4, n5, n6) != null) && n7 > 0 && twgu2.func_71913_a(n8, bl) && (hank2 = twgu2.func_71878_a(this, n4, n5, n6, ofbx2, ofbx3)) != null) {
                    return hank2;
                }
                n7 = 200;
                while (n7-- >= 0) {
                    hank hank3;
                    int n9;
                    if (Double.isNaN(ofbx2._c) || Double.isNaN(ofbx2._d) || Double.isNaN(ofbx2._e)) {
                        return null;
                    }
                    if (n4 == n && n5 == n2 && n6 == n3) {
                        return null;
                    }
                    boolean bl3 = true;
                    boolean bl4 = true;
                    boolean bl5 = true;
                    double d = 999.0;
                    double d2 = 999.0;
                    double d3 = 999.0;
                    if (n > n4) {
                        d = (double)n4 + 1.0;
                    } else if (n < n4) {
                        d = (double)n4 + 0.0;
                    } else {
                        bl3 = false;
                    }
                    if (n2 > n5) {
                        d2 = (double)n5 + 1.0;
                    } else if (n2 < n5) {
                        d2 = (double)n5 + 0.0;
                    } else {
                        bl4 = false;
                    }
                    if (n3 > n6) {
                        d3 = (double)n6 + 1.0;
                    } else if (n3 < n6) {
                        d3 = (double)n6 + 0.0;
                    } else {
                        bl5 = false;
                    }
                    double d4 = 999.0;
                    double d5 = 999.0;
                    double d6 = 999.0;
                    double d7 = ofbx3._c - ofbx2._c;
                    double d8 = ofbx3._d - ofbx2._d;
                    double d9 = ofbx3._e - ofbx2._e;
                    if (bl3) {
                        d4 = (d - ofbx2._c) / d7;
                    }
                    if (bl4) {
                        d5 = (d2 - ofbx2._d) / d8;
                    }
                    if (bl5) {
                        d6 = (d3 - ofbx2._e) / d9;
                    }
                    boolean bl6 = false;
                    if (d4 < d5 && d4 < d6) {
                        n9 = n > n4 ? 4 : 5;
                        ofbx2._c = d;
                        ofbx2._d += d8 * d4;
                        ofbx2._e += d9 * d4;
                    } else if (d5 < d6) {
                        n9 = n2 > n5 ? 0 : 1;
                        ofbx2._c += d7 * d5;
                        ofbx2._d = d2;
                        ofbx2._e += d9 * d5;
                    } else {
                        n9 = n3 > n6 ? 2 : 3;
                        ofbx2._c += d7 * d6;
                        ofbx2._d += d8 * d6;
                        ofbx2._e = d3;
                    }
                    ofbx ofbx4 = this.func_82732_R()._a(ofbx2._c, ofbx2._d, ofbx2._e);
                    ofbx4._c = sajh._c(ofbx2._c);
                    n4 = (int)ofbx4._c;
                    if (n9 == 5) {
                        --n4;
                        ofbx4._c += 1.0;
                    }
                    ofbx4._d = sajh._c(ofbx2._d);
                    n5 = (int)ofbx4._d;
                    if (n9 == 1) {
                        --n5;
                        ofbx4._d += 1.0;
                    }
                    ofbx4._e = sajh._c(ofbx2._e);
                    n6 = (int)ofbx4._e;
                    if (n9 == 3) {
                        --n6;
                        ofbx4._e += 1.0;
                    }
                    int n10 = this.func_72798_a(n4, n5, n6);
                    int n11 = this.func_72805_g(n4, n5, n6);
                    twgu twgu3 = twgu.field_71973_m[n10];
                    if (bl2 && twgu3 != null && twgu3.func_71872_e(this, n4, n5, n6) == null || n10 <= 0 || !twgu3.func_71913_a(n11, bl) || (hank3 = twgu3.func_71878_a(this, n4, n5, n6, ofbx2, ofbx3)) == null) continue;
                    return hank3;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public void func_72956_a(Entity entity, String string, float f, float f2) {
        boolean bl = SoundHooks.playSoundAtEntity(this, entity, string, f, f2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        PlaySoundAtEntityEvent playSoundAtEntityEvent = new PlaySoundAtEntityEvent(entity, string, f, f2);
        if (MinecraftForge.EVENT_BUS.post(playSoundAtEntityEvent)) {
            return;
        }
        string = playSoundAtEntityEvent.name;
        if (entity != null && string != null) {
            for (int i = 0; i < this.field_73021_x.size(); ++i) {
                ((aqaj)this.field_73021_x.get(i))._a(string, entity.field_70165_t, entity.field_70163_u - (double)entity.field_70129_M, entity.field_70161_v, f, f2);
            }
        }
    }

    public void func_85173_a(EntityPlayer entityPlayer, String string, float f, float f2) {
        boolean bl = SoundHooks.playSoundToNearExcept(this, entityPlayer, string, f, f2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        PlaySoundAtEntityEvent playSoundAtEntityEvent = new PlaySoundAtEntityEvent(entityPlayer, string, f, f2);
        if (MinecraftForge.EVENT_BUS.post(playSoundAtEntityEvent)) {
            return;
        }
        string = playSoundAtEntityEvent.name;
        if (entityPlayer != null && string != null) {
            for (int i = 0; i < this.field_73021_x.size(); ++i) {
                ((aqaj)this.field_73021_x.get(i))._a(entityPlayer, string, entityPlayer.field_70165_t, entityPlayer.field_70163_u - (double)entityPlayer.field_70129_M, entityPlayer.field_70161_v, f, f2);
            }
        }
    }

    public void func_72908_a(double d, double d2, double d3, String string, float f, float f2) {
        if (string != null) {
            for (int i = 0; i < this.field_73021_x.size(); ++i) {
                ((aqaj)this.field_73021_x.get(i))._a(string, d, d2, d3, f, f2);
            }
        }
    }

    public void func_72980_b(double d, double d2, double d3, String string, float f, float f2, boolean bl) {
    }

    public void func_72934_a(String string, int n, int n2, int n3) {
        for (int i = 0; i < this.field_73021_x.size(); ++i) {
            ((aqaj)this.field_73021_x.get(i))._a(string, n, n2, n3);
        }
    }

    public void func_72869_a(String string, double d, double d2, double d3, double d4, double d5, double d6) {
        int n = BlockRendererList.spawnParticle(this, string, d, d2, d3, d4, d5, d6);
        if (n != 0) {
            int n2 = n;
            return;
        }
        for (n = 0; n < this.field_73021_x.size(); ++n) {
            ((aqaj)this.field_73021_x.get(n))._a(string, d, d2, d3, d4, d5, d6);
        }
    }

    public boolean func_72942_c(Entity entity) {
        this.field_73007_j.add(entity);
        return true;
    }

    public boolean func_72838_d(Entity entity) {
        int n = sajh._c(entity.field_70165_t / 16.0);
        int n2 = sajh._c(entity.field_70161_v / 16.0);
        boolean bl = entity.field_98038_p;
        if (entity instanceof EntityPlayer) {
            bl = true;
        }
        if (!bl && !this.func_72916_c(n, n2)) {
            return false;
        }
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            this.field_73010_i.add(entityPlayer);
            this.func_72854_c();
        }
        if (MinecraftForge.EVENT_BUS.post(new EntityJoinWorldEvent(entity, this)) && !bl) {
            return false;
        }
        this.func_72964_e(n, n2)._a(entity);
        this.field_72996_f.add(entity);
        this.func_72923_a(entity);
        return true;
    }

    public void func_72923_a(Entity entity) {
        for (int i = 0; i < this.field_73021_x.size(); ++i) {
            ((aqaj)this.field_73021_x.get(i))._b(entity);
        }
    }

    public void func_72847_b(Entity entity) {
        for (int i = 0; i < this.field_73021_x.size(); ++i) {
            ((aqaj)this.field_73021_x.get(i))._c(entity);
        }
    }

    public void func_72900_e(Entity entity) {
        if (entity.field_70153_n != null) {
            entity.field_70153_n.func_70078_a(null);
        }
        if (entity.field_70154_o != null) {
            entity.func_70078_a(null);
        }
        entity.func_70106_y();
        if (entity instanceof EntityPlayer) {
            this.field_73010_i.remove(entity);
            this.func_72854_c();
        }
    }

    public void func_72973_f(Entity entity) {
        entity.func_70106_y();
        if (entity instanceof EntityPlayer) {
            this.field_73010_i.remove(entity);
            this.func_72854_c();
        }
        int n = entity.field_70176_ah;
        int n2 = entity.field_70164_aj;
        if (entity.field_70175_ag && this.func_72916_c(n, n2)) {
            this.func_72964_e(n, n2)._b(entity);
        }
        this.field_72996_f.remove(entity);
        this.func_72847_b(entity);
    }

    public void func_72954_a(aqaj aqaj2) {
        this.field_73021_x.add(aqaj2);
    }

    public List func_72945_a(Entity entity, eidj eidj2) {
        this.field_72998_d.clear();
        int n = sajh._c(eidj2._b);
        int n2 = sajh._c(eidj2._e + 1.0);
        int n3 = sajh._c(eidj2._c);
        int n4 = sajh._c(eidj2._f + 1.0);
        int n5 = sajh._c(eidj2._d);
        int n6 = sajh._c(eidj2._g + 1.0);
        for (int i = n; i < n2; ++i) {
            for (int j = n5; j < n6; ++j) {
                if (!this.func_72899_e(i, 64, j)) continue;
                for (int k = n3 - 1; k < n4; ++k) {
                    twgu twgu2 = twgu.field_71973_m[this.func_72798_a(i, k, j)];
                    if (twgu2 == null) continue;
                    twgu2.func_71871_a(this, i, k, j, eidj2, this.field_72998_d, entity);
                }
            }
        }
        double d = 0.25;
        List list = this.func_72839_b(entity, eidj2._b(d, d, d));
        for (int i = 0; i < list.size(); ++i) {
            eidj eidj3 = ((Entity)list.get(i)).func_70046_E();
            if (eidj3 != null && eidj3._b(eidj2)) {
                this.field_72998_d.add(eidj3);
            }
            if ((eidj3 = entity.func_70114_g((Entity)list.get(i))) == null || !eidj3._b(eidj2)) continue;
            this.field_72998_d.add(eidj3);
        }
        return this.field_72998_d;
    }

    public List func_72840_a(eidj eidj2) {
        this.field_72998_d.clear();
        int n = sajh._c(eidj2._b);
        int n2 = sajh._c(eidj2._e + 1.0);
        int n3 = sajh._c(eidj2._c);
        int n4 = sajh._c(eidj2._f + 1.0);
        int n5 = sajh._c(eidj2._d);
        int n6 = sajh._c(eidj2._g + 1.0);
        for (int i = n; i < n2; ++i) {
            for (int j = n5; j < n6; ++j) {
                if (!this.func_72899_e(i, 64, j)) continue;
                for (int k = n3 - 1; k < n4; ++k) {
                    twgu twgu2 = twgu.field_71973_m[this.func_72798_a(i, k, j)];
                    if (twgu2 == null) continue;
                    twgu2.func_71871_a(this, i, k, j, eidj2, this.field_72998_d, null);
                }
            }
        }
        return this.field_72998_d;
    }

    public int func_72967_a(float f) {
        float f2 = this.func_72826_c(f);
        float f3 = 1.0f - (sajh._b(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.5f);
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        f3 = 1.0f - f3;
        f3 = (float)((double)f3 * (1.0 - (double)(this.func_72867_j(f) * 5.0f) / 16.0));
        f3 = (float)((double)f3 * (1.0 - (double)(this.func_72819_i(f) * 5.0f) / 16.0));
        f3 = 1.0f - f3;
        return (int)(f3 * 11.0f);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_72848_b(aqaj aqaj2) {
        this.field_73021_x.remove(aqaj2);
    }

    @SideOnly(value=Side.CLIENT)
    public float func_72971_b(float f) {
        float f2 = this.func_72826_c(f);
        float f3 = 1.0f - (sajh._b(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.2f);
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        f3 = 1.0f - f3;
        f3 = (float)((double)f3 * (1.0 - (double)(this.func_72867_j(f) * 5.0f) / 16.0));
        f3 = (float)((double)f3 * (1.0 - (double)(this.func_72819_i(f) * 5.0f) / 16.0));
        return f3 * 0.8f + 0.2f;
    }

    @SideOnly(value=Side.CLIENT)
    public ofbx func_72833_a(Entity entity, float f) {
        return ezey._a(this.field_73011_w._a(entity, f));
    }

    @SideOnly(value=Side.CLIENT)
    public ofbx getSkyColorBody(Entity entity, float f) {
        float f2;
        float f3;
        float f4 = this.func_72826_c(f);
        float f5 = sajh._b(f4 * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        int n = sajh._c(entity.field_70165_t);
        int n2 = sajh._c(entity.field_70161_v);
        int n3 = ForgeHooksClient.getSkyBlendColour(this, n, n2);
        float f6 = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n3 & 0xFF) / 255.0f;
        f6 *= f5;
        f7 *= f5;
        f8 *= f5;
        float f9 = this.func_72867_j(f);
        if (f9 > 0.0f) {
            f3 = (f6 * 0.3f + f7 * 0.59f + f8 * 0.11f) * 0.6f;
            f2 = 1.0f - f9 * 0.75f;
            f6 = f6 * f2 + f3 * (1.0f - f2);
            f7 = f7 * f2 + f3 * (1.0f - f2);
            f8 = f8 * f2 + f3 * (1.0f - f2);
        }
        if ((f3 = this.func_72819_i(f)) > 0.0f) {
            f2 = (f6 * 0.3f + f7 * 0.59f + f8 * 0.11f) * 0.2f;
            float f10 = 1.0f - f3 * 0.75f;
            f6 = f6 * f10 + f2 * (1.0f - f10);
            f7 = f7 * f10 + f2 * (1.0f - f10);
            f8 = f8 * f10 + f2 * (1.0f - f10);
        }
        if (this.field_73016_r > 0) {
            f2 = (float)this.field_73016_r - f;
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            f6 = f6 * (1.0f - (f2 *= 0.45f)) + 0.8f * f2;
            f7 = f7 * (1.0f - f2) + 0.8f * f2;
            f8 = f8 * (1.0f - f2) + 1.0f * f2;
        }
        return this.func_82732_R()._a(f6, f7, f8);
    }

    public float func_72826_c(float f) {
        return this.field_73011_w._a(this.field_72986_A._g(), f);
    }

    @SideOnly(value=Side.CLIENT)
    public int func_72853_d() {
        return this.field_73011_w._a(this.field_72986_A._g());
    }

    public float func_130001_d() {
        return rrte._a[this.field_73011_w._a(this.field_72986_A._g())];
    }

    public float func_72929_e(float f) {
        float f2 = this.func_72826_c(f);
        return f2 * (float)Math.PI * 2.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public ofbx func_72824_f(float f) {
        return this.field_73011_w._a(f);
    }

    @SideOnly(value=Side.CLIENT)
    public ofbx drawCloudsBody(float f) {
        float f2;
        float f3;
        float f4 = this.func_72826_c(f);
        float f5 = sajh._b(f4 * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        float f6 = (float)(this.field_73001_c >> 16 & 0xFFL) / 255.0f;
        float f7 = (float)(this.field_73001_c >> 8 & 0xFFL) / 255.0f;
        float f8 = (float)(this.field_73001_c & 0xFFL) / 255.0f;
        float f9 = this.func_72867_j(f);
        if (f9 > 0.0f) {
            f3 = (f6 * 0.3f + f7 * 0.59f + f8 * 0.11f) * 0.6f;
            f2 = 1.0f - f9 * 0.95f;
            f6 = f6 * f2 + f3 * (1.0f - f2);
            f7 = f7 * f2 + f3 * (1.0f - f2);
            f8 = f8 * f2 + f3 * (1.0f - f2);
        }
        f6 *= f5 * 0.9f + 0.1f;
        f7 *= f5 * 0.9f + 0.1f;
        f8 *= f5 * 0.85f + 0.15f;
        f3 = this.func_72819_i(f);
        if (f3 > 0.0f) {
            f2 = (f6 * 0.3f + f7 * 0.59f + f8 * 0.11f) * 0.2f;
            float f10 = 1.0f - f3 * 0.95f;
            f6 = f6 * f10 + f2 * (1.0f - f10);
            f7 = f7 * f10 + f2 * (1.0f - f10);
            f8 = f8 * f10 + f2 * (1.0f - f10);
        }
        return this.func_82732_R()._a(f6, f7, f8);
    }

    @SideOnly(value=Side.CLIENT)
    public ofbx func_72948_g(float f) {
        float f2 = this.func_72826_c(f);
        return this.field_73011_w._b(f2, f);
    }

    public int func_72874_g(int n, int n2) {
        return this.func_72938_d(n, n2)._d(n & 0xF, n2 & 0xF);
    }

    public int func_72825_h(int n, int n2) {
        ixzi ixzi2 = this.func_72938_d(n, n2);
        int n3 = n;
        int n4 = n2;
        n &= 0xF;
        n2 &= 0xF;
        for (int i = ixzi2._a() + 15; i > 0; --i) {
            int n5 = ixzi2._d(n, i, n2);
            if (n5 == 0 || !twgu.field_71973_m[n5].field_72018_cp._c() || twgu.field_71973_m[n5].field_72018_cp == tflj._j || twgu.field_71973_m[n5].isBlockFoliage(this, n3, i, n4)) continue;
            return i + 1;
        }
        return -1;
    }

    @SideOnly(value=Side.CLIENT)
    public float func_72880_h(float f) {
        return this.field_73011_w._b(f);
    }

    @SideOnly(value=Side.CLIENT)
    public float getStarBrightnessBody(float f) {
        float f2 = this.func_72826_c(f);
        float f3 = 1.0f - (sajh._b(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.25f);
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        return f3 * f3 * 0.5f;
    }

    public void func_72836_a(int n, int n2, int n3, int n4, int n5) {
    }

    public void func_82740_a(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void func_72892_b(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void func_72939_s() {
        Object object2;
        int n;
        jxsn jxsn2;
        CrashReport crashReport;
        Entity entity;
        int n2;
        if (GloomyHooks.getWorldInitialized(this)) {
            this.a.get(-1);
        }
        this.field_72984_F._a("entities");
        this.field_72984_F._a("global");
        for (n2 = 0; n2 < this.field_73007_j.size(); ++n2) {
            entity = (Entity)this.field_73007_j.get(n2);
            try {
                ++entity.field_70173_aa;
                entity.func_70071_h_();
            }
            catch (Throwable throwable) {
                crashReport = CrashReport.func_85055_a(throwable, "Ticking entity");
                jxsn2 = crashReport.func_85058_a("Entity being ticked");
                if (entity == null) {
                    jxsn2._a("Entity", "~~NULL~~");
                } else {
                    entity.func_85029_a(jxsn2);
                }
                if (ForgeDummyContainer.removeErroringEntities) {
                    FMLLog.severe(crashReport.func_71502_e(), new Object[0]);
                    this.func_72900_e(entity);
                }
                throw new turb(crashReport);
            }
            if (!entity.field_70128_L) continue;
            this.field_73007_j.remove(n2--);
        }
        this.field_72984_F._c("remove");
        this.field_72996_f.removeAll(this.field_72997_g);
        for (n2 = 0; n2 < this.field_72997_g.size(); ++n2) {
            entity = (Entity)this.field_72997_g.get(n2);
            int n3 = entity.field_70176_ah;
            n = entity.field_70164_aj;
            if (!entity.field_70175_ag || !this.func_72916_c(n3, n)) continue;
            this.func_72964_e(n3, n)._b(entity);
        }
        for (n2 = 0; n2 < this.field_72997_g.size(); ++n2) {
            this.func_72847_b((Entity)this.field_72997_g.get(n2));
        }
        this.field_72997_g.clear();
        this.field_72984_F._c("regular");
        for (n2 = 0; n2 < this.field_72996_f.size(); ++n2) {
            entity = (Entity)this.field_72996_f.get(n2);
            if (entity.field_70154_o != null) {
                if (!entity.field_70154_o.field_70128_L && entity.field_70154_o.field_70153_n == entity) continue;
                entity.field_70154_o.field_70153_n = null;
                entity.field_70154_o = null;
            }
            this.field_72984_F._a("tick");
            if (!entity.field_70128_L) {
                try {
                    this.func_72870_g(entity);
                }
                catch (Throwable throwable) {
                    crashReport = CrashReport.func_85055_a(throwable, "Ticking entity");
                    jxsn2 = crashReport.func_85058_a("Entity being ticked");
                    entity.func_85029_a(jxsn2);
                    if (ForgeDummyContainer.removeErroringEntities) {
                        FMLLog.severe(crashReport.func_71502_e(), new Object[0]);
                        this.func_72900_e(entity);
                    }
                    throw new turb(crashReport);
                }
            }
            this.field_72984_F._b();
            this.field_72984_F._a("remove");
            if (entity.field_70128_L) {
                int n4 = entity.field_70176_ah;
                n = entity.field_70164_aj;
                if (entity.field_70175_ag && this.func_72916_c(n4, n)) {
                    this.func_72964_e(n4, n)._b(entity);
                }
                this.field_72996_f.remove(n2--);
                this.func_72847_b(entity);
            }
            this.field_72984_F._b();
        }
        this.field_72984_F._c("tileEntities");
        this.field_72989_L = true;
        Iterator iterator2 = this.field_73009_h.iterator();
        while (iterator2.hasNext()) {
            hurg hurg2 = (hurg)iterator2.next();
            if (!hurg2.func_70320_p() && hurg2.func_70309_m() && this.func_72899_e(hurg2.field_70329_l, hurg2.field_70330_m, hurg2.field_70327_n)) {
                try {
                    GloomyHooks.startTileProfiling(hurg2);
                    GloomyHooks.stopTileProfiling(hurg2);
                    hurg2.func_70316_g();
                }
                catch (Throwable throwable) {
                    crashReport = CrashReport.func_85055_a(throwable, "Ticking tile entity");
                    jxsn2 = crashReport.func_85058_a("Tile entity being ticked");
                    hurg2.func_85027_a(jxsn2);
                    if (ForgeDummyContainer.removeErroringTileEntities) {
                        FMLLog.severe(crashReport.func_71502_e(), new Object[0]);
                        hurg2.func_70313_j();
                        this.func_94571_i(hurg2.field_70329_l, hurg2.field_70330_m, hurg2.field_70327_n);
                    }
                    throw new turb(crashReport);
                }
            }
            if (!hurg2.func_70320_p()) continue;
            iterator2.remove();
            if (!this.func_72916_c(hurg2.field_70329_l >> 4, hurg2.field_70327_n >> 4) || (object2 = this.func_72964_e(hurg2.field_70329_l >> 4, hurg2.field_70327_n >> 4)) == null) continue;
            ((ixzi)object2)._i(hurg2.field_70329_l & 0xF, hurg2.field_70330_m, hurg2.field_70327_n & 0xF);
        }
        if (!this.field_73000_b.isEmpty()) {
            for (Object object2 : this.field_73000_b) {
                ((hurg)object2).onChunkUnload();
            }
            this.field_73009_h.removeAll(this.field_73000_b);
            this.field_73000_b.clear();
        }
        this.field_72989_L = false;
        this.field_72984_F._c("pendingTileEntities");
        if (!this.field_73002_a.isEmpty()) {
            for (int i = 0; i < this.field_73002_a.size(); ++i) {
                ixzi ixzi2;
                object2 = (hurg)this.field_73002_a.get(i);
                if (!((hurg)object2).func_70320_p()) {
                    if (this.field_73009_h.contains(object2)) continue;
                    this.field_73009_h.add(object2);
                    continue;
                }
                if (!this.func_72916_c(((hurg)object2).field_70329_l >> 4, ((hurg)object2).field_70327_n >> 4) || (ixzi2 = this.func_72964_e(((hurg)object2).field_70329_l >> 4, ((hurg)object2).field_70327_n >> 4)) == null) continue;
                ixzi2._i(((hurg)object2).field_70329_l & 0xF, ((hurg)object2).field_70330_m, ((hurg)object2).field_70327_n & 0xF);
            }
            this.field_73002_a.clear();
        }
        this.field_72984_F._b();
        this.field_72984_F._b();
    }

    public void func_72852_a(Collection collection) {
        List list2 = this.field_72989_L ? this.field_73002_a : this.field_73009_h;
        for (Object e : collection) {
            if (!((hurg)e).canUpdate()) continue;
            list2.add(e);
        }
    }

    public void func_72870_g(Entity entity) {
        this.func_72866_a(entity, true);
    }

    public void func_72866_a(Entity entity, boolean bl) {
        boolean bl2;
        int n = sajh._c(entity.field_70165_t);
        int n2 = sajh._c(entity.field_70161_v);
        boolean bl3 = this.getPersistentChunks().containsKey(new jjym(n >> 4, n2 >> 4));
        int n3 = bl3 ? 0 : 32;
        boolean bl4 = bl2 = !bl || this.func_72904_c(n - n3, 0, n2 - n3, n + n3, 0, n2 + n3);
        if (!bl2) {
            EntityEvent.CanUpdate canUpdate = new EntityEvent.CanUpdate(entity);
            MinecraftForge.EVENT_BUS.post(canUpdate);
            bl2 = canUpdate.canUpdate;
        }
        if (bl2) {
            entity.field_70142_S = entity.field_70165_t;
            entity.field_70137_T = entity.field_70163_u;
            entity.field_70136_U = entity.field_70161_v;
            entity.field_70126_B = entity.field_70177_z;
            entity.field_70127_C = entity.field_70125_A;
            if (bl && entity.field_70175_ag) {
                ++entity.field_70173_aa;
                if (entity.field_70154_o != null) {
                    entity.func_70098_U();
                } else {
                    entity.func_70071_h_();
                }
            }
            this.field_72984_F._a("chunkCheck");
            if (Double.isNaN(entity.field_70165_t) || Double.isInfinite(entity.field_70165_t)) {
                entity.field_70165_t = entity.field_70142_S;
            }
            if (Double.isNaN(entity.field_70163_u) || Double.isInfinite(entity.field_70163_u)) {
                entity.field_70163_u = entity.field_70137_T;
            }
            if (Double.isNaN(entity.field_70161_v) || Double.isInfinite(entity.field_70161_v)) {
                entity.field_70161_v = entity.field_70136_U;
            }
            if (Double.isNaN(entity.field_70125_A) || Double.isInfinite(entity.field_70125_A)) {
                entity.field_70125_A = entity.field_70127_C;
            }
            if (Double.isNaN(entity.field_70177_z) || Double.isInfinite(entity.field_70177_z)) {
                entity.field_70177_z = entity.field_70126_B;
            }
            int n4 = sajh._c(entity.field_70165_t / 16.0);
            int n5 = sajh._c(entity.field_70163_u / 16.0);
            int n6 = sajh._c(entity.field_70161_v / 16.0);
            if (!entity.field_70175_ag || entity.field_70176_ah != n4 || entity.field_70162_ai != n5 || entity.field_70164_aj != n6) {
                if (entity.field_70175_ag && this.func_72916_c(entity.field_70176_ah, entity.field_70164_aj)) {
                    this.func_72964_e(entity.field_70176_ah, entity.field_70164_aj)._a(entity, entity.field_70162_ai);
                }
                if (this.func_72916_c(n4, n6)) {
                    entity.field_70175_ag = true;
                    this.func_72964_e(n4, n6)._a(entity);
                } else {
                    entity.field_70175_ag = false;
                }
            }
            this.field_72984_F._b();
            if (bl && entity.field_70175_ag && entity.field_70153_n != null) {
                if (!entity.field_70153_n.field_70128_L && entity.field_70153_n.field_70154_o == entity) {
                    this.func_72870_g(entity.field_70153_n);
                } else {
                    entity.field_70153_n.field_70154_o = null;
                    entity.field_70153_n = null;
                }
            }
        }
    }

    public boolean func_72855_b(eidj eidj2) {
        return this.func_72917_a(eidj2, null);
    }

    public boolean func_72917_a(eidj eidj2, Entity entity) {
        List list2 = this.func_72839_b(null, eidj2);
        for (int i = 0; i < list2.size(); ++i) {
            Entity entity2 = (Entity)list2.get(i);
            if (entity2.field_70128_L || !entity2.field_70156_m || entity2 == entity) continue;
            return false;
        }
        return true;
    }

    public boolean func_72829_c(eidj eidj2) {
        int n = sajh._c(eidj2._b);
        int n2 = sajh._c(eidj2._e + 1.0);
        int n3 = sajh._c(eidj2._c);
        int n4 = sajh._c(eidj2._f + 1.0);
        int n5 = sajh._c(eidj2._d);
        int n6 = sajh._c(eidj2._g + 1.0);
        if (eidj2._b < 0.0) {
            --n;
        }
        if (eidj2._c < 0.0) {
            --n3;
        }
        if (eidj2._d < 0.0) {
            --n5;
        }
        for (int i = n; i < n2; ++i) {
            for (int j = n3; j < n4; ++j) {
                for (int k = n5; k < n6; ++k) {
                    twgu twgu2 = twgu.field_71973_m[this.func_72798_a(i, j, k)];
                    if (twgu2 == null) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean func_72953_d(eidj eidj2) {
        int n = sajh._c(eidj2._b);
        int n2 = sajh._c(eidj2._e + 1.0);
        int n3 = sajh._c(eidj2._c);
        int n4 = sajh._c(eidj2._f + 1.0);
        int n5 = sajh._c(eidj2._d);
        int n6 = sajh._c(eidj2._g + 1.0);
        if (eidj2._b < 0.0) {
            --n;
        }
        if (eidj2._c < 0.0) {
            --n3;
        }
        if (eidj2._d < 0.0) {
            --n5;
        }
        for (int i = n; i < n2; ++i) {
            for (int j = n3; j < n4; ++j) {
                for (int k = n5; k < n6; ++k) {
                    twgu twgu2 = twgu.field_71973_m[this.func_72798_a(i, j, k)];
                    if (twgu2 == null || !twgu2.field_72018_cp._d()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean func_72978_e(eidj eidj2) {
        int n;
        int n2 = sajh._c(eidj2._b);
        int n3 = sajh._c(eidj2._e + 1.0);
        int n4 = sajh._c(eidj2._c);
        int n5 = sajh._c(eidj2._f + 1.0);
        int n6 = sajh._c(eidj2._d);
        if (this.func_72904_c(n2, n4, n6, n3, n5, n = sajh._c(eidj2._g + 1.0))) {
            for (int i = n2; i < n3; ++i) {
                for (int j = n4; j < n5; ++j) {
                    for (int k = n6; k < n; ++k) {
                        int n7 = this.func_72798_a(i, j, k);
                        if (n7 == twgu.field_72067_ar.field_71990_ca || n7 == twgu.field_71944_C.field_71990_ca || n7 == twgu.field_71938_D.field_71990_ca) {
                            return true;
                        }
                        twgu twgu2 = twgu.field_71973_m[n7];
                        if (twgu2 == null || !twgu2.isBlockBurning(this, i, j, k)) continue;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean func_72918_a(eidj eidj2, tflj tflj2, Entity entity) {
        int n;
        int n2 = sajh._c(eidj2._b);
        int n3 = sajh._c(eidj2._e + 1.0);
        int n4 = sajh._c(eidj2._c);
        int n5 = sajh._c(eidj2._f + 1.0);
        int n6 = sajh._c(eidj2._d);
        if (!this.func_72904_c(n2, n4, n6, n3, n5, n = sajh._c(eidj2._g + 1.0))) {
            return false;
        }
        boolean bl = false;
        ofbx ofbx2 = this.func_82732_R()._a(0.0, 0.0, 0.0);
        for (int i = n2; i < n3; ++i) {
            for (int j = n4; j < n5; ++j) {
                for (int k = n6; k < n; ++k) {
                    double d;
                    twgu twgu2 = twgu.field_71973_m[this.func_72798_a(i, j, k)];
                    if (twgu2 == null || twgu2.field_72018_cp != tflj2 || !((double)n5 >= (d = (double)((float)(j + 1) - ogyy._a(this.func_72805_g(i, j, k)))))) continue;
                    bl = true;
                    twgu2.func_71901_a(this, i, j, k, entity, ofbx2);
                }
            }
        }
        if (ofbx2._b() > 0.0 && entity.func_96092_aw()) {
            ofbx2 = ofbx2._a();
            double d = 0.014;
            entity.field_70159_w += ofbx2._c * d;
            entity.field_70181_x += ofbx2._d * d;
            entity.field_70179_y += ofbx2._e * d;
        }
        return bl;
    }

    public boolean func_72875_a(eidj eidj2, tflj tflj2) {
        int n = sajh._c(eidj2._b);
        int n2 = sajh._c(eidj2._e + 1.0);
        int n3 = sajh._c(eidj2._c);
        int n4 = sajh._c(eidj2._f + 1.0);
        int n5 = sajh._c(eidj2._d);
        int n6 = sajh._c(eidj2._g + 1.0);
        for (int i = n; i < n2; ++i) {
            for (int j = n3; j < n4; ++j) {
                for (int k = n5; k < n6; ++k) {
                    twgu twgu2 = twgu.field_71973_m[this.func_72798_a(i, j, k)];
                    if (twgu2 == null || twgu2.field_72018_cp != tflj2) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean func_72830_b(eidj eidj2, tflj tflj2) {
        int n = sajh._c(eidj2._b);
        int n2 = sajh._c(eidj2._e + 1.0);
        int n3 = sajh._c(eidj2._c);
        int n4 = sajh._c(eidj2._f + 1.0);
        int n5 = sajh._c(eidj2._d);
        int n6 = sajh._c(eidj2._g + 1.0);
        for (int i = n; i < n2; ++i) {
            for (int j = n3; j < n4; ++j) {
                for (int k = n5; k < n6; ++k) {
                    twgu twgu2 = twgu.field_71973_m[this.func_72798_a(i, j, k)];
                    if (twgu2 == null || twgu2.field_72018_cp != tflj2) continue;
                    int n7 = this.func_72805_g(i, j, k);
                    double d = j + 1;
                    if (n7 < 8) {
                        d = (double)(j + 1) - (double)n7 / 8.0;
                    }
                    if (!(d >= eidj2._c)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public elkd func_72876_a(Entity entity, double d, double d2, double d3, float f, boolean bl) {
        return this.func_72885_a(entity, d, d2, d3, f, false, bl);
    }

    public elkd func_72885_a(Entity entity, double d, double d2, double d3, float f, boolean bl, boolean bl2) {
        elkd elkd2 = new elkd(this, entity, d, d2, d3, f);
        elkd2._a = bl;
        elkd2._b = bl2;
        elkd2._a();
        elkd2._a(true);
        return elkd2;
    }

    public float func_72842_a(ofbx ofbx2, eidj eidj2) {
        double d = 1.0 / ((eidj2._e - eidj2._b) * 2.0 + 1.0);
        double d2 = 1.0 / ((eidj2._f - eidj2._c) * 2.0 + 1.0);
        double d3 = 1.0 / ((eidj2._g - eidj2._d) * 2.0 + 1.0);
        int n = 0;
        int n2 = 0;
        float f = 0.0f;
        while (f <= 1.0f) {
            float f2 = 0.0f;
            while (f2 <= 1.0f) {
                float f3 = 0.0f;
                while (f3 <= 1.0f) {
                    double d4 = eidj2._b + (eidj2._e - eidj2._b) * (double)f;
                    double d5 = eidj2._c + (eidj2._f - eidj2._c) * (double)f2;
                    double d6 = eidj2._d + (eidj2._g - eidj2._d) * (double)f3;
                    if (this.func_72933_a(this.func_82732_R()._a(d4, d5, d6), ofbx2) == null) {
                        ++n;
                    }
                    ++n2;
                    f3 = (float)((double)f3 + d3);
                }
                f2 = (float)((double)f2 + d2);
            }
            f = (float)((double)f + d);
        }
        return (float)n / (float)n2;
    }

    public boolean func_72886_a(EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (this.func_72798_a(n, n2, n3) == twgu.field_72067_ar.field_71990_ca) {
            this.func_72889_a(entityPlayer, 1004, n, n2, n3, 0);
            this.func_94571_i(n, n2, n3);
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public String func_72981_t() {
        return "All: " + this.field_72996_f.size();
    }

    @SideOnly(value=Side.CLIENT)
    public String func_72827_u() {
        return this.field_73020_y._d();
    }

    @Override
    public hurg func_72796_p(int n, int n2, int n3) {
        if (n2 >= 0 && n2 < 256) {
            ixzi ixzi2;
            hurg hurg2;
            int n4;
            hurg hurg3 = null;
            if (this.field_72989_L) {
                for (n4 = 0; n4 < this.field_73002_a.size(); ++n4) {
                    hurg2 = (hurg)this.field_73002_a.get(n4);
                    if (hurg2.func_70320_p() || hurg2.field_70329_l != n || hurg2.field_70330_m != n2 || hurg2.field_70327_n != n3) continue;
                    hurg3 = hurg2;
                    break;
                }
            }
            if (hurg3 == null && (ixzi2 = this.func_72964_e(n >> 4, n3 >> 4)) != null) {
                hurg3 = ixzi2._g(n & 0xF, n2, n3 & 0xF);
            }
            if (hurg3 == null) {
                for (n4 = 0; n4 < this.field_73002_a.size(); ++n4) {
                    hurg2 = (hurg)this.field_73002_a.get(n4);
                    if (hurg2.func_70320_p() || hurg2.field_70329_l != n || hurg2.field_70330_m != n2 || hurg2.field_70327_n != n3) continue;
                    hurg3 = hurg2;
                    break;
                }
            }
            return hurg3;
        }
        return null;
    }

    public void func_72837_a(int n, int n2, int n3, hurg hurg2) {
        Object object;
        if (hurg2 == null || hurg2.func_70320_p()) {
            return;
        }
        if (hurg2.canUpdate()) {
            if (this.field_72989_L) {
                object = this.field_73002_a.iterator();
                while (object.hasNext()) {
                    hurg hurg3 = (hurg)object.next();
                    if (hurg3.field_70329_l != n || hurg3.field_70330_m != n2 || hurg3.field_70327_n != n3) continue;
                    hurg3.func_70313_j();
                    object.remove();
                }
                this.field_73002_a.add(hurg2);
            } else {
                this.field_73009_h.add(hurg2);
            }
        }
        if ((object = this.func_72964_e(n >> 4, n3 >> 4)) != null) {
            ((ixzi)object)._a(n & 0xF, n2, n3 & 0xF, hurg2);
        }
        this.func_96440_m(n, n2, n3, 0);
    }

    public void func_72932_q(int n, int n2, int n3) {
        ixzi ixzi2 = this.func_72964_e(n >> 4, n3 >> 4);
        if (ixzi2 != null) {
            ixzi2._h(n & 0xF, n2, n3 & 0xF);
        }
        this.func_96440_m(n, n2, n3, 0);
    }

    public void func_72928_a(hurg hurg2) {
        this.field_73000_b.add(hurg2);
    }

    @Override
    public boolean func_72804_r(int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[this.func_72798_a(n, n2, n3)];
        return twgu2 == null ? false : twgu2.func_71926_d();
    }

    @Override
    public boolean func_72809_s(int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[this.func_72798_a(n, n2, n3)];
        return twgu2 != null && twgu2.isBlockNormalCube(this, n, n2, n3);
    }

    public boolean func_85174_u(int n, int n2, int n3) {
        int n4 = this.func_72798_a(n, n2, n3);
        if (n4 != 0 && twgu.field_71973_m[n4] != null) {
            eidj eidj2 = twgu.field_71973_m[n4].func_71872_e(this, n, n2, n3);
            return eidj2 != null && eidj2._b() >= 1.0;
        }
        return false;
    }

    @Override
    public boolean func_72797_t(int n, int n2, int n3) {
        return this.isBlockSolidOnSide(n, n2, n3, ForgeDirection.UP);
    }

    @Deprecated
    public boolean func_102026_a(twgu twgu2, int n) {
        return twgu2 == null ? false : (twgu2.field_72018_cp._k() && twgu2.func_71886_c() ? true : (twgu2 instanceof yuxu ? (n & 4) == 4 : (twgu2 instanceof ndvn ? (n & 8) == 8 : (twgu2 instanceof ndvl ? true : (twgu2 instanceof zgzq ? (n & 7) == 7 : false)))));
    }

    public boolean func_72887_b(int n, int n2, int n3, boolean bl) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            ixzi ixzi2 = this.field_73020_y._b(n >> 4, n3 >> 4);
            if (ixzi2 != null && !ixzi2._i()) {
                twgu twgu2 = twgu.field_71973_m[this.func_72798_a(n, n2, n3)];
                return twgu2 == null ? false : this.func_72809_s(n, n2, n3);
            }
            return bl;
        }
        return bl;
    }

    public void func_72966_v() {
        int n = this.func_72967_a(1.0f);
        if (n != this.field_73008_k) {
            this.field_73008_k = n;
        }
    }

    public void func_72891_a(boolean bl, boolean bl2) {
        this.field_73011_w._a(bl, bl2);
    }

    public void func_72835_b() {
        this.func_72979_l();
    }

    public void func_72947_a() {
        this.field_73011_w._u();
    }

    public void calculateInitialWeatherBody() {
        if (this.field_72986_A._p()) {
            this.field_73004_o = 1.0f;
            if (this.field_72986_A._n()) {
                this.field_73017_q = 1.0f;
            }
        }
    }

    public void func_72979_l() {
        this.field_73011_w._v();
    }

    public void updateWeatherBody() {
        pidb._a(this);
    }

    public void func_72913_w() {
        this.field_73011_w._w();
    }

    public void func_72903_x() {
        int n;
        int n2;
        int n3;
        EntityPlayer entityPlayer;
        int n4;
        this.field_72993_I.clear();
        this.field_72993_I.addAll(this.getPersistentChunks().keySet());
        this.field_72984_F._a("buildList");
        for (n4 = 0; n4 < this.field_73010_i.size(); ++n4) {
            entityPlayer = (EntityPlayer)this.field_73010_i.get(n4);
            n3 = sajh._c(entityPlayer.field_70165_t / 16.0);
            n2 = sajh._c(entityPlayer.field_70161_v / 16.0);
            n = 7;
            for (int i = -n; i <= n; ++i) {
                for (int j = -n; j <= n; ++j) {
                    this.field_72993_I.add(new jjym(i + n3, j + n2));
                }
            }
        }
        this.field_72984_F._b();
        if (this.field_72990_M > 0) {
            --this.field_72990_M;
        }
        this.field_72984_F._a("playerCheckLight");
        if (!this.field_73010_i.isEmpty()) {
            n4 = this.field_73012_v.nextInt(this.field_73010_i.size());
            entityPlayer = (EntityPlayer)this.field_73010_i.get(n4);
            n3 = sajh._c(entityPlayer.field_70165_t) + this.field_73012_v.nextInt(11) - 5;
            n2 = sajh._c(entityPlayer.field_70163_u) + this.field_73012_v.nextInt(11) - 5;
            n = sajh._c(entityPlayer.field_70161_v) + this.field_73012_v.nextInt(11) - 5;
            this.func_72969_x(n3, n2, n);
        }
        this.field_72984_F._b();
    }

    public void func_72941_a(int n, int n2, ixzi ixzi2) {
        this.field_72984_F._c("moodSound");
        if (this.field_72990_M == 0 && !this.field_72995_K) {
            EntityPlayer entityPlayer;
            this.field_73005_l = this.field_73005_l * 3 + 1013904223;
            int n3 = this.field_73005_l >> 2;
            int n4 = n3 & 0xF;
            int n5 = n3 >> 8 & 0xF;
            int n6 = n3 >> 16 & 0x7F;
            int n7 = ixzi2._d(n4, n6, n5);
            if (n7 == 0 && this.func_72883_k(n4 += n, n6, n5 += n2) <= this.field_73012_v.nextInt(8) && this.func_72972_b(rrqi._a, n4, n6, n5) <= 0 && (entityPlayer = this.func_72977_a((double)n4 + 0.5, (double)n6 + 0.5, (double)n5 + 0.5, 8.0)) != null && entityPlayer.func_70092_e((double)n4 + 0.5, (double)n6 + 0.5, (double)n5 + 0.5) > 4.0) {
                this.func_72908_a((double)n4 + 0.5, (double)n6 + 0.5, (double)n5 + 0.5, "ambient.cave.cave", 0.7f, 0.8f + this.field_73012_v.nextFloat() * 0.2f);
                this.field_72990_M = this.field_73012_v.nextInt(12000) + 6000;
            }
        }
        this.field_72984_F._c("checkLight");
        ixzi2._n();
    }

    public void func_72893_g() {
        this.func_72903_x();
    }

    public boolean func_72884_u(int n, int n2, int n3) {
        return this.func_72834_c(n, n2, n3, false);
    }

    public boolean func_72850_v(int n, int n2, int n3) {
        return this.func_72834_c(n, n2, n3, true);
    }

    public boolean func_72834_c(int n, int n2, int n3, boolean bl) {
        return this.field_73011_w._a(n, n2, n3, bl);
    }

    public boolean canBlockFreezeBody(int n, int n2, int n3, boolean bl) {
        int n4;
        foqh foqh2 = this.func_72807_a(n, n3);
        float f = foqh2._k();
        if (f > 0.15f) {
            return false;
        }
        if (n2 >= 0 && n2 < 256 && this.func_72972_b(rrqi._b, n, n2, n3) < 10 && ((n4 = this.func_72798_a(n, n2, n3)) == twgu.field_71943_B.field_71990_ca || n4 == twgu.field_71942_A.field_71990_ca) && this.func_72805_g(n, n2, n3) == 0) {
            if (!bl) {
                return true;
            }
            boolean bl2 = true;
            if (bl2 && this.func_72803_f(n - 1, n2, n3) != tflj._h) {
                bl2 = false;
            }
            if (bl2 && this.func_72803_f(n + 1, n2, n3) != tflj._h) {
                bl2 = false;
            }
            if (bl2 && this.func_72803_f(n, n2, n3 - 1) != tflj._h) {
                bl2 = false;
            }
            if (bl2 && this.func_72803_f(n, n2, n3 + 1) != tflj._h) {
                bl2 = false;
            }
            if (!bl2) {
                return true;
            }
        }
        return false;
    }

    public boolean func_72858_w(int n, int n2, int n3) {
        return this.field_73011_w._a(n, n2, n3);
    }

    public boolean canSnowAtBody(int n, int n2, int n3) {
        foqh foqh2 = this.func_72807_a(n, n3);
        float f = foqh2._k();
        if (f > 0.15f) {
            return false;
        }
        if (n2 >= 0 && n2 < 256 && this.func_72972_b(rrqi._b, n, n2, n3) < 10) {
            int n4 = this.func_72798_a(n, n2 - 1, n3);
            int n5 = this.func_72798_a(n, n2, n3);
            if (n5 == 0 && twgu.field_72037_aS.func_71930_b(this, n, n2, n3) && n4 != 0 && n4 != twgu.field_72036_aT.field_71990_ca && twgu.field_71973_m[n4].field_72018_cp._c()) {
                return true;
            }
        }
        return false;
    }

    public void func_72969_x(int n, int n2, int n3) {
        if (!this.field_73011_w._g) {
            this.func_72936_c(rrqi._a, n, n2, n3);
        }
        this.func_72936_c(rrqi._b, n, n2, n3);
    }

    public int func_98179_a(int n, int n2, int n3, rrqi rrqi2) {
        int n4;
        if (rrqi2 == rrqi._a && this.func_72937_j(n, n2, n3)) {
            return 15;
        }
        int n5 = this.func_72798_a(n, n2, n3);
        twgu twgu2 = twgu.field_71973_m[n5];
        int n6 = DynamicLights.getLightValue(this, n5, n, n2, n3);
        int n7 = rrqi2 == rrqi._a ? 0 : n6;
        int n8 = n4 = twgu2 == null ? 0 : twgu2.getLightOpacity(this, n, n2, n3);
        if (n4 >= 15 && n6 > 0) {
            n4 = 1;
        }
        if (n4 < 1) {
            n4 = 1;
        }
        if (n4 >= 15) {
            return 0;
        }
        if (n7 >= 14) {
            return n7;
        }
        for (int i = 0; i < 6; ++i) {
            int n9 = n + owak._b[i];
            int n10 = n2 + owak._c[i];
            int n11 = n3 + owak._d[i];
            int n12 = this.func_72972_b(rrqi2, n9, n10, n11) - n4;
            if (n12 > n7) {
                n7 = n12;
            }
            if (n7 < 14) continue;
            return n7;
        }
        return n7;
    }

    public void func_72936_c(rrqi rrqi2, int n, int n2, int n3) {
        if (this.func_72873_a(n, n2, n3, 17)) {
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14 = 0;
            int n15 = 0;
            this.field_72984_F._a("getBrightness");
            int n16 = this.func_72972_b(rrqi2, n, n2, n3);
            int n17 = this.func_98179_a(n, n2, n3, rrqi2);
            if (n17 > n16) {
                this.field_72994_J[n15++] = 133152;
            } else if (n17 < n16) {
                this.field_72994_J[n15++] = 0x20820 | n16 << 18;
                while (n14 < n15) {
                    n13 = this.field_72994_J[n14++];
                    n12 = (n13 & 0x3F) - 32 + n;
                    n11 = (n13 >> 6 & 0x3F) - 32 + n2;
                    n10 = (n13 >> 12 & 0x3F) - 32 + n3;
                    n9 = n13 >> 18 & 0xF;
                    n8 = this.func_72972_b(rrqi2, n12, n11, n10);
                    if (n8 != n9) continue;
                    this.func_72915_b(rrqi2, n12, n11, n10, 0);
                    if (n9 <= 0 || (n7 = sajh._a(n12 - n)) + (n6 = sajh._a(n11 - n2)) + (n5 = sajh._a(n10 - n3)) >= 17) continue;
                    for (n4 = 0; n4 < 6; ++n4) {
                        int n18 = n12 + owak._b[n4];
                        int n19 = n11 + owak._c[n4];
                        int n20 = n10 + owak._d[n4];
                        twgu twgu2 = twgu.field_71973_m[this.func_72798_a(n18, n19, n20)];
                        int n21 = twgu2 == null ? 0 : twgu2.getLightOpacity(this, n18, n19, n20);
                        int n22 = Math.max(1, n21);
                        n8 = this.func_72972_b(rrqi2, n18, n19, n20);
                        if (n8 != n9 - n22 || n15 >= this.field_72994_J.length) continue;
                        this.field_72994_J[n15++] = n18 - n + 32 | n19 - n2 + 32 << 6 | n20 - n3 + 32 << 12 | n9 - n22 << 18;
                    }
                }
                n14 = 0;
            }
            this.field_72984_F._b();
            this.field_72984_F._a("checkedPosition < toCheckCount");
            while (n14 < n15) {
                n13 = this.field_72994_J[n14++];
                n12 = (n13 & 0x3F) - 32 + n;
                n11 = (n13 >> 6 & 0x3F) - 32 + n2;
                n10 = (n13 >> 12 & 0x3F) - 32 + n3;
                n9 = this.func_72972_b(rrqi2, n12, n11, n10);
                n8 = this.func_98179_a(n12, n11, n10, rrqi2);
                if (n8 == n9) continue;
                this.func_72915_b(rrqi2, n12, n11, n10, n8);
                if (n8 <= n9) continue;
                n7 = Math.abs(n12 - n);
                n6 = Math.abs(n11 - n2);
                n5 = Math.abs(n10 - n3);
                int n23 = n4 = n15 < this.field_72994_J.length - 6 ? 1 : 0;
                if (n7 + n6 + n5 >= 17 || n4 == 0) continue;
                if (this.func_72972_b(rrqi2, n12 - 1, n11, n10) < n8) {
                    this.field_72994_J[n15++] = n12 - 1 - n + 32 + (n11 - n2 + 32 << 6) + (n10 - n3 + 32 << 12);
                }
                if (this.func_72972_b(rrqi2, n12 + 1, n11, n10) < n8) {
                    this.field_72994_J[n15++] = n12 + 1 - n + 32 + (n11 - n2 + 32 << 6) + (n10 - n3 + 32 << 12);
                }
                if (this.func_72972_b(rrqi2, n12, n11 - 1, n10) < n8) {
                    this.field_72994_J[n15++] = n12 - n + 32 + (n11 - 1 - n2 + 32 << 6) + (n10 - n3 + 32 << 12);
                }
                if (this.func_72972_b(rrqi2, n12, n11 + 1, n10) < n8) {
                    this.field_72994_J[n15++] = n12 - n + 32 + (n11 + 1 - n2 + 32 << 6) + (n10 - n3 + 32 << 12);
                }
                if (this.func_72972_b(rrqi2, n12, n11, n10 - 1) < n8) {
                    this.field_72994_J[n15++] = n12 - n + 32 + (n11 - n2 + 32 << 6) + (n10 - 1 - n3 + 32 << 12);
                }
                if (this.func_72972_b(rrqi2, n12, n11, n10 + 1) >= n8) continue;
                this.field_72994_J[n15++] = n12 - n + 32 + (n11 - n2 + 32 << 6) + (n10 + 1 - n3 + 32 << 12);
            }
            this.field_72984_F._b();
        }
    }

    public boolean func_72955_a(boolean bl) {
        return false;
    }

    public List func_72920_a(ixzi ixzi2, boolean bl) {
        return null;
    }

    public List func_72839_b(Entity entity, eidj eidj2) {
        return this.func_94576_a(entity, eidj2, null);
    }

    public List func_94576_a(Entity entity, eidj eidj2, zhos zhos2) {
        ArrayList arrayList = new ArrayList();
        int n = sajh._c((eidj2._b - MAX_ENTITY_RADIUS) / 16.0);
        int n2 = sajh._c((eidj2._e + MAX_ENTITY_RADIUS) / 16.0);
        int n3 = sajh._c((eidj2._d - MAX_ENTITY_RADIUS) / 16.0);
        int n4 = sajh._c((eidj2._g + MAX_ENTITY_RADIUS) / 16.0);
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                if (!this.func_72916_c(i, j)) continue;
                this.func_72964_e(i, j)._a(entity, eidj2, arrayList, zhos2);
            }
        }
        return arrayList;
    }

    public List func_72872_a(Class clazz, eidj eidj2) {
        return this.func_82733_a(clazz, eidj2, null);
    }

    public List func_82733_a(Class clazz, eidj eidj2, zhos zhos2) {
        int n = sajh._c((eidj2._b - MAX_ENTITY_RADIUS) / 16.0);
        int n2 = sajh._c((eidj2._e + MAX_ENTITY_RADIUS) / 16.0);
        int n3 = sajh._c((eidj2._d - MAX_ENTITY_RADIUS) / 16.0);
        int n4 = sajh._c((eidj2._g + MAX_ENTITY_RADIUS) / 16.0);
        ArrayList arrayList = new ArrayList();
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                if (!this.func_72916_c(i, j)) continue;
                this.func_72964_e(i, j)._a(clazz, eidj2, arrayList, zhos2);
            }
        }
        return arrayList;
    }

    public Entity func_72857_a(Class clazz, eidj eidj2, Entity entity) {
        List list2 = this.func_72872_a(clazz, eidj2);
        Entity entity2 = null;
        double d = Double.MAX_VALUE;
        for (int i = 0; i < list2.size(); ++i) {
            double d2;
            Entity entity3 = (Entity)list2.get(i);
            if (entity3 == entity || !((d2 = entity.func_70068_e(entity3)) <= d)) continue;
            entity2 = entity3;
            d = d2;
        }
        return entity2;
    }

    public abstract Entity func_73045_a(int var1);

    @SideOnly(value=Side.CLIENT)
    public List func_72910_y() {
        return this.field_72996_f;
    }

    public void func_72944_b(int n, int n2, int n3, hurg hurg2) {
        if (this.func_72899_e(n, n2, n3)) {
            this.func_72938_d(n, n3)._h();
        }
    }

    public int func_72907_a(Class clazz) {
        int n = 0;
        for (int i = 0; i < this.field_72996_f.size(); ++i) {
            Entity entity = (Entity)this.field_72996_f.get(i);
            if (entity instanceof EntityLiving && ((EntityLiving)entity).func_104002_bU() || !clazz.isAssignableFrom(entity.getClass())) continue;
            ++n;
        }
        return n;
    }

    public void func_72868_a(List list2) {
        for (int i = 0; i < list2.size(); ++i) {
            Entity entity = (Entity)list2.get(i);
            if (MinecraftForge.EVENT_BUS.post(new EntityJoinWorldEvent(entity, this))) continue;
            this.field_72996_f.add(entity);
            this.func_72923_a(entity);
        }
    }

    public void func_72828_b(List list2) {
        this.field_72997_g.addAll(list2);
    }

    public boolean func_72931_a(int n, int n2, int n3, int n4, boolean bl, int n5, Entity entity, cvzo cvzo2) {
        int n6 = this.func_72798_a(n2, n3, n4);
        twgu twgu2 = twgu.field_71973_m[n6];
        twgu twgu3 = twgu.field_71973_m[n];
        eidj eidj2 = twgu3.func_71872_e(this, n2, n3, n4);
        if (bl) {
            eidj2 = null;
        }
        if (eidj2 != null && !this.func_72917_a(eidj2, entity)) {
            return false;
        }
        if (twgu2 != null && (twgu2 == twgu.field_71942_A || twgu2 == twgu.field_71943_B || twgu2 == twgu.field_71944_C || twgu2 == twgu.field_71938_D || twgu2 == twgu.field_72067_ar || twgu2.field_72018_cp._j())) {
            twgu2 = null;
        }
        if (twgu2 != null && twgu2.isBlockReplaceable(this, n2, n3, n4)) {
            twgu2 = null;
        }
        return twgu2 != null && twgu2.field_72018_cp == tflj._q && twgu3 == twgu.field_82510_ck ? true : n > 0 && twgu2 == null && twgu3.func_94331_a(this, n2, n3, n4, n5, cvzo2);
    }

    public suqn func_72865_a(Entity entity, Entity entity2, float f, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.field_72984_F._a("pathfind");
        int n = sajh._c(entity.field_70165_t);
        int n2 = sajh._c(entity.field_70163_u + 1.0);
        int n3 = sajh._c(entity.field_70161_v);
        int n4 = (int)(f + 16.0f);
        int n5 = n - n4;
        int n6 = n2 - n4;
        int n7 = n3 - n4;
        int n8 = n + n4;
        int n9 = n2 + n4;
        int n10 = n3 + n4;
        zzie zzie2 = new zzie(this, n5, n6, n7, n8, n9, n10, 0);
        suqn suqn2 = new rrnl(zzie2, bl, bl2, bl3, bl4)._a(entity, entity2, f);
        this.field_72984_F._b();
        return suqn2;
    }

    public suqn func_72844_a(Entity entity, int n, int n2, int n3, float f, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.field_72984_F._a("pathfind");
        int n4 = sajh._c(entity.field_70165_t);
        int n5 = sajh._c(entity.field_70163_u);
        int n6 = sajh._c(entity.field_70161_v);
        int n7 = (int)(f + 8.0f);
        int n8 = n4 - n7;
        int n9 = n5 - n7;
        int n10 = n6 - n7;
        int n11 = n4 + n7;
        int n12 = n5 + n7;
        int n13 = n6 + n7;
        zzie zzie2 = new zzie(this, n8, n9, n10, n11, n12, n13, 0);
        suqn suqn2 = new rrnl(zzie2, bl, bl2, bl3, bl4)._a(entity, n, n2, n3, f);
        this.field_72984_F._b();
        return suqn2;
    }

    @Override
    public int func_72879_k(int n, int n2, int n3, int n4) {
        int n5 = this.func_72798_a(n, n2, n3);
        return n5 == 0 ? 0 : twgu.field_71973_m[n5].func_71855_c(this, n, n2, n3, n4);
    }

    public int func_94577_B(int n, int n2, int n3) {
        int n4 = 0;
        int n5 = Math.max(n4, this.func_72879_k(n, n2 - 1, n3, 0));
        if (n5 >= 15) {
            return n5;
        }
        if ((n5 = Math.max(n5, this.func_72879_k(n, n2 + 1, n3, 1))) >= 15) {
            return n5;
        }
        if ((n5 = Math.max(n5, this.func_72879_k(n, n2, n3 - 1, 2))) >= 15) {
            return n5;
        }
        if ((n5 = Math.max(n5, this.func_72879_k(n, n2, n3 + 1, 3))) >= 15) {
            return n5;
        }
        if ((n5 = Math.max(n5, this.func_72879_k(n - 1, n2, n3, 4))) >= 15) {
            return n5;
        }
        return (n5 = Math.max(n5, this.func_72879_k(n + 1, n2, n3, 5))) >= 15 ? n5 : n5;
    }

    public boolean func_94574_k(int n, int n2, int n3, int n4) {
        return this.func_72878_l(n, n2, n3, n4) > 0;
    }

    public int func_72878_l(int n, int n2, int n3, int n4) {
        twgu twgu2 = twgu.field_71973_m[this.func_72798_a(n, n2, n3)];
        if (twgu2 == null) {
            return 0;
        }
        if (!twgu2.shouldCheckWeakPower(this, n, n2, n3, n4)) {
            return this.func_94577_B(n, n2, n3);
        }
        return twgu2.func_71865_a(this, n, n2, n3, n4);
    }

    public boolean func_72864_z(int n, int n2, int n3) {
        return this.func_72878_l(n, n2 - 1, n3, 0) > 0 ? true : (this.func_72878_l(n, n2 + 1, n3, 1) > 0 ? true : (this.func_72878_l(n, n2, n3 - 1, 2) > 0 ? true : (this.func_72878_l(n, n2, n3 + 1, 3) > 0 ? true : (this.func_72878_l(n - 1, n2, n3, 4) > 0 ? true : this.func_72878_l(n + 1, n2, n3, 5) > 0))));
    }

    public int func_94572_D(int n, int n2, int n3) {
        int n4 = 0;
        for (int i = 0; i < 6; ++i) {
            int n5 = this.func_72878_l(n + owak._b[i], n2 + owak._c[i], n3 + owak._d[i], i);
            if (n5 >= 15) {
                return 15;
            }
            if (n5 <= n4) continue;
            n4 = n5;
        }
        return n4;
    }

    public EntityPlayer func_72890_a(Entity entity, double d) {
        return this.func_72977_a(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, d);
    }

    public EntityPlayer func_72977_a(double d, double d2, double d3, double d4) {
        double d5 = -1.0;
        EntityPlayer entityPlayer = null;
        for (int i = 0; i < this.field_73010_i.size(); ++i) {
            EntityPlayer entityPlayer2 = (EntityPlayer)this.field_73010_i.get(i);
            double d6 = entityPlayer2.func_70092_e(d, d2, d3);
            if (!(d4 < 0.0) && !(d6 < d4 * d4) || d5 != -1.0 && !(d6 < d5)) continue;
            d5 = d6;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public EntityPlayer func_72856_b(Entity entity, double d) {
        return this.func_72846_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, d);
    }

    public EntityPlayer func_72846_b(double d, double d2, double d3, double d4) {
        double d5 = -1.0;
        EntityPlayer entityPlayer = null;
        for (int i = 0; i < this.field_73010_i.size(); ++i) {
            EntityPlayer entityPlayer2 = (EntityPlayer)this.field_73010_i.get(i);
            if (entityPlayer2.field_71075_bZ._a || !entityPlayer2.func_70089_S()) continue;
            double d6 = entityPlayer2.func_70092_e(d, d2, d3);
            double d7 = d4;
            if (entityPlayer2.func_70093_af()) {
                d7 = d4 * (double)0.8f;
            }
            if (entityPlayer2.func_82150_aj()) {
                float f = entityPlayer2.func_82243_bO();
                if (f < 0.1f) {
                    f = 0.1f;
                }
                d7 *= (double)(0.7f * f);
            }
            if (!(d4 < 0.0) && !(d6 < d7 * d7) || d5 != -1.0 && !(d6 < d5)) continue;
            d5 = d6;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public EntityPlayer func_72924_a(String string) {
        for (int i = 0; i < this.field_73010_i.size(); ++i) {
            if (!string.equals(((EntityPlayer)this.field_73010_i.get(i)).func_70005_c_())) continue;
            return (EntityPlayer)this.field_73010_i.get(i);
        }
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_72882_A() {
    }

    public void func_72906_B() throws xcad {
        this.field_73019_z.func_75762_c();
    }

    @SideOnly(value=Side.CLIENT)
    public void func_82738_a(long l) {
        this.field_72986_A._a(l);
    }

    public long func_72905_C() {
        return this.field_73011_w._x();
    }

    public long func_82737_E() {
        return this.field_72986_A._f();
    }

    public long func_72820_D() {
        return this.field_73011_w._y();
    }

    public void func_72877_b(long l) {
        this.field_73011_w._b(l);
    }

    public zwaw func_72861_E() {
        return this.field_73011_w._z();
    }

    @SideOnly(value=Side.CLIENT)
    public void func_72950_A(int n, int n2, int n3) {
        this.field_73011_w._b(n, n2, n3);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_72897_h(Entity entity) {
        int n = sajh._c(entity.field_70165_t / 16.0);
        int n2 = sajh._c(entity.field_70161_v / 16.0);
        int n3 = 2;
        for (int i = n - n3; i <= n + n3; ++i) {
            for (int j = n2 - n3; j <= n2 + n3; ++j) {
                this.func_72964_e(i, j);
            }
        }
        if (!this.field_72996_f.contains(entity) && !MinecraftForge.EVENT_BUS.post(new EntityJoinWorldEvent(entity, this))) {
            this.field_72996_f.add(entity);
        }
    }

    public boolean func_72962_a(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return this.field_73011_w._a(entityPlayer, n, n2, n3);
    }

    public boolean canMineBlockBody(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return true;
    }

    public void func_72960_a(Entity entity, byte by) {
    }

    public mccn func_72863_F() {
        return this.field_73020_y;
    }

    public void func_72965_b(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n4 > 0) {
            twgu.field_71973_m[n4].func_71883_b(this, n, n2, n3, n5, n6);
        }
    }

    public mtms func_72860_G() {
        return this.field_73019_z;
    }

    public iyev func_72912_H() {
        return this.field_72986_A;
    }

    public mcam func_82736_K() {
        return this.field_72986_A._x();
    }

    public void func_72854_c() {
    }

    public float func_72819_i(float f) {
        return (this.field_73018_p + (this.field_73017_q - this.field_73018_p) * f) * this.func_72867_j(f);
    }

    public float func_72867_j(float f) {
        return this.field_73003_n + (this.field_73004_o - this.field_73003_n) * f;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_72894_k(float f) {
        this.field_73003_n = f;
        this.field_73004_o = f;
    }

    public boolean func_72911_I() {
        return (double)this.func_72819_i(1.0f) > 0.9;
    }

    public boolean func_72896_J() {
        return (double)this.func_72867_j(1.0f) > 0.2;
    }

    public boolean func_72951_B(int n, int n2, int n3) {
        if (!this.func_72896_J()) {
            return false;
        }
        if (!this.func_72937_j(n, n2, n3)) {
            return false;
        }
        if (this.func_72874_g(n, n3) > n2) {
            return false;
        }
        foqh foqh2 = this.func_72807_a(n, n3);
        return foqh2._d() ? false : foqh2._e();
    }

    public boolean func_72958_C(int n, int n2, int n3) {
        return this.field_73011_w._c(n, n2, n3);
    }

    public void func_72823_a(String string, plne plne2) {
        this.field_72988_C._a(string, plne2);
    }

    public plne func_72943_a(Class clazz, String string) {
        return this.field_72988_C._a(clazz, string);
    }

    public int func_72841_b(String string) {
        return this.field_72988_C._a(string);
    }

    public void func_82739_e(int n, int n2, int n3, int n4, int n5) {
        for (int i = 0; i < this.field_73021_x.size(); ++i) {
            ((aqaj)this.field_73021_x.get(i))._a(n, n2, n3, n4, n5);
        }
    }

    public void func_72926_e(int n, int n2, int n3, int n4, int n5) {
        this.func_72889_a(null, n, n2, n3, n4, n5);
    }

    public void func_72889_a(EntityPlayer entityPlayer, int n, int n2, int n3, int n4, int n5) {
        try {
            for (int i = 0; i < this.field_73021_x.size(); ++i) {
                ((aqaj)this.field_73021_x.get(i))._a(entityPlayer, n, n2, n3, n4, n5);
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Playing level event");
            jxsn jxsn2 = crashReport.func_85058_a("Level event being played");
            jxsn2._a("Block coordinates", jxsn._a(n2, n3, n4));
            jxsn2._a("Event source", entityPlayer);
            jxsn2._a("Event type", n);
            jxsn2._a("Event data", n5);
            throw new turb(crashReport);
        }
    }

    @Override
    public int func_72800_K() {
        return this.field_73011_w._A();
    }

    public int func_72940_L() {
        return this.field_73011_w._B();
    }

    public ywed func_82735_a(EntityMinecart entityMinecart) {
        return null;
    }

    public Random func_72843_D(int n, int n2, int n3) {
        long l = (long)n * 341873128712L + (long)n2 * 132897987541L + this.func_72912_H()._b() + (long)n3;
        this.field_73012_v.setSeed(l);
        return this.field_73012_v;
    }

    public xtcd func_72946_b(String string, int n, int n2, int n3) {
        return this.func_72863_F()._a(this, string, n, n2, n3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_72806_N() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public double func_72919_O() {
        return this.field_73011_w._C();
    }

    public jxsn func_72914_a(CrashReport crashReport) {
        jxsn jxsn2 = crashReport.func_85057_a("Affected level", 1);
        jxsn2._a("Level name", this.field_72986_A == null ? "????" : this.field_72986_A._k());
        jxsn2._a("All players", new sutf(this));
        jxsn2._a("Chunk stats", new rrqg(this));
        try {
            this.field_72986_A._a(jxsn2);
        }
        catch (Throwable throwable) {
            jxsn2._a("Level Data Unobtainable", throwable);
        }
        return jxsn2;
    }

    public void func_72888_f(int n, int n2, int n3, int n4, int n5) {
        for (int i = 0; i < this.field_73021_x.size(); ++i) {
            aqaj aqaj2 = (aqaj)this.field_73021_x.get(i);
            aqaj2._b(n, n2, n3, n4, n5);
        }
    }

    @Override
    public iurn func_82732_R() {
        if (this.J.get() == null) {
            this.J.set(new iurn(300, 2000));
        }
        return this.J.get();
    }

    public Calendar func_83015_S() {
        if (this.func_82737_E() % 600L == 0L) {
            this.field_83016_L.setTimeInMillis(dzfd.__aq());
        }
        return this.field_83016_L;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_92088_a(double d, double d2, double d3, double d4, double d5, double d6, qoac qoac2) {
    }

    public fojy func_96441_U() {
        return this.field_96442_D;
    }

    public void func_96440_m(int n, int n2, int n3, int n4) {
        for (ForgeDirection forgeDirection : ForgeDirection.VALID_DIRECTIONS) {
            int n5 = n + forgeDirection.offsetX;
            int n6 = n2 + forgeDirection.offsetY;
            int n7 = n3 + forgeDirection.offsetZ;
            int n8 = this.func_72798_a(n5, n6, n7);
            twgu twgu2 = twgu.field_71973_m[n8];
            if (twgu2 == null) continue;
            twgu2.onNeighborTileChange(this, n5, n6, n7, n, n2, n3);
            if (!twgu.func_71932_i(n8) || (twgu2 = twgu.field_71973_m[n8 = this.func_72798_a(n5 += forgeDirection.offsetX, n6 += forgeDirection.offsetY, n7 += forgeDirection.offsetZ)]) == null || !twgu2.weakTileChanges()) continue;
            twgu2.onNeighborTileChange(this, n5, n6, n7, n, n2, n3);
        }
    }

    public jjmf func_98180_V() {
        return this.field_98181_L;
    }

    public float func_110746_b(double d, double d2, double d3) {
        return this.func_110750_I(sajh._c(d), sajh._c(d2), sajh._c(d3));
    }

    public float func_110750_I(int n, int n2, int n3) {
        boolean bl;
        float f = 0.0f;
        boolean bl2 = bl = this.field_73013_u == 3;
        if (this.func_72899_e(n, n2, n3)) {
            float f2 = this.func_130001_d();
            f += sajh._a((float)this.func_72938_d((int)n, (int)n3)._t / 3600000.0f, 0.0f, 1.0f) * (bl ? 1.0f : 0.75f);
            f += f2 * 0.25f;
        }
        if (this.field_73013_u < 2) {
            f *= (float)this.field_73013_u / 2.0f;
        }
        return sajh._a(f, 0.0f, bl ? 1.5f : 1.0f);
    }

    public void addTileEntity(hurg hurg2) {
        List list2;
        List list3 = list2 = this.field_72989_L ? this.field_73002_a : this.field_73009_h;
        if (hurg2.canUpdate()) {
            list2.add(hurg2);
        }
    }

    public boolean isBlockSolidOnSide(int n, int n2, int n3, ForgeDirection forgeDirection) {
        return this.isBlockSolidOnSide(n, n2, n3, forgeDirection, false);
    }

    @Override
    public boolean isBlockSolidOnSide(int n, int n2, int n3, ForgeDirection forgeDirection, boolean bl) {
        if (n < -30000000 || n3 < -30000000 || n >= 30000000 || n3 >= 30000000) {
            return bl;
        }
        ixzi ixzi2 = this.field_73020_y._b(n >> 4, n3 >> 4);
        if (ixzi2 == null || ixzi2._i()) {
            return bl;
        }
        twgu twgu2 = twgu.field_71973_m[this.func_72798_a(n, n2, n3)];
        if (twgu2 == null) {
            return false;
        }
        return twgu2.isBlockSolidOnSide(this, n, n2, n3, forgeDirection);
    }

    public ImmutableSetMultimap<jjym, ForgeChunkManager.Ticket> getPersistentChunks() {
        return ForgeChunkManager.getPersistentChunksFor(this);
    }

    public int getBlockLightOpacity(int n, int n2, int n3) {
        if (n < -30000000 || n3 < -30000000 || n >= 30000000 || n3 >= 30000000) {
            return 0;
        }
        if (n2 < 0 || n2 >= 256) {
            return 0;
        }
        return this.func_72964_e(n >> 4, n3 >> 4)._c(n & 0xF, n2, n3 & 0xF);
    }

    public int countEntities(net.minecraft.entity.jxsn jxsn2, boolean bl) {
        int n = 0;
        for (int i = 0; i < this.field_72996_f.size(); ++i) {
            if (!((Entity)this.field_72996_f.get(i)).isCreatureType(jxsn2, bl)) continue;
            ++n;
        }
        return n;
    }
}

