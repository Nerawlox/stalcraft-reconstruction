/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aox
 *  arx
 *  arz
 *  asa
 *  asb
 *  asc
 *  asd
 *  asf
 *  asg
 *  asj
 *  asl
 *  asm
 *  asn
 *  aso
 *  asq
 *  asr
 *  ass
 *  asw
 *  asx
 *  cm
 *  cpw.mods.fml.common.FMLLog
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ge
 *  net.minecraft.server.MinecraftServer
 */
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import net.minecraft.server.MinecraftServer;

public class asp {
    private static Map a = new HashMap();
    private static Map b = new HashMap();
    public abw k;
    public int l;
    public int m;
    public int n;
    protected boolean o;
    public int p = -1;
    public aqz q;
    private boolean isVanilla = this.getClass().getName().startsWith("net.minecraft.tileentity");
    public static final asx INFINITE_EXTENT_AABB;

    public static void a(Class par0Class, String par1Str) {
        if (a.containsKey(par1Str)) {
            throw new IllegalArgumentException("Duplicate id: " + par1Str);
        }
        a.put(par1Str, par0Class);
        b.put(par0Class, par1Str);
    }

    public abw az() {
        return this.k;
    }

    public void b(abw par1World) {
        this.k = par1World;
    }

    public boolean o() {
        return this.k != null;
    }

    public void a(by par1NBTTagCompound) {
        this.l = par1NBTTagCompound.e("x");
        this.m = par1NBTTagCompound.e("y");
        this.n = par1NBTTagCompound.e("z");
    }

    public void b(by par1NBTTagCompound) {
        String s2 = (String)b.get(this.getClass());
        if (s2 == null) {
            throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
        }
        par1NBTTagCompound.a("id", s2);
        par1NBTTagCompound.a("x", this.l);
        par1NBTTagCompound.a("y", this.m);
        par1NBTTagCompound.a("z", this.n);
    }

    public void h() {
    }

    public static asp c(by par0NBTTagCompound) {
        asp tileentity = null;
        Class oclass = null;
        try {
            oclass = (Class)a.get(par0NBTTagCompound.i("id"));
            if (oclass != null) {
                tileentity = (asp)oclass.newInstance();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (tileentity != null) {
            try {
                tileentity.a(par0NBTTagCompound);
            }
            catch (Exception e) {
                FMLLog.log((Level)Level.SEVERE, (Throwable)e, (String)"A TileEntity %s(%s) has thrown an exception during loading, its state cannot be restored. Report this to the mod author", (Object[])new Object[]{par0NBTTagCompound.i("id"), oclass.getName()});
                tileentity = null;
            }
        } else {
            MinecraftServer.F().an().b("Skipping TileEntity with id " + par0NBTTagCompound.i("id"));
        }
        return tileentity;
    }

    public int p() {
        if (this.p == -1) {
            this.p = this.k.h(this.l, this.m, this.n);
        }
        return this.p;
    }

    public void e() {
        if (this.k != null) {
            this.p = this.k.h(this.l, this.m, this.n);
            this.k.b(this.l, this.m, this.n, this);
            if (this.q() != null) {
                this.k.m(this.l, this.m, this.n, this.q().cF);
            }
        }
    }

    public double a(double par1, double par3, double par5) {
        double d3 = (double)this.l + 0.5 - par1;
        double d4 = (double)this.m + 0.5 - par3;
        double d5 = (double)this.n + 0.5 - par5;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    @SideOnly(value=Side.CLIENT)
    public double n() {
        return 4096.0;
    }

    public aqz q() {
        if (this.q == null) {
            this.q = aqz.s[this.k.a(this.l, this.m, this.n)];
        }
        return this.q;
    }

    public ey m() {
        return null;
    }

    public boolean r() {
        return this.o;
    }

    public void w_() {
        this.o = true;
    }

    public void s() {
        this.o = false;
    }

    public boolean b(int par1, int par2) {
        return false;
    }

    public void i() {
        this.q = null;
        this.p = -1;
    }

    public void a(m par1CrashReportCategory) {
        par1CrashReportCategory.a("Name", (Callable)new asq(this));
        m.a(par1CrashReportCategory, this.l, this.m, this.n, this.q().cF, this.p());
        par1CrashReportCategory.a("Actual block type", (Callable)new asr(this));
        par1CrashReportCategory.a("Actual block data value", (Callable)new ass(this));
    }

    static Map t() {
        return b;
    }

    public boolean canUpdate() {
        return true;
    }

    public void onDataPacket(cm net, ge pkt) {
    }

    public void onChunkUnload() {
    }

    public boolean shouldRefresh(int oldID, int newID, int oldMeta, int newMeta, abw world, int x2, int y2, int z2) {
        return !this.isVanilla || oldID != newID;
    }

    public boolean shouldRenderInPass(int pass) {
        return pass == 0;
    }

    @SideOnly(value=Side.CLIENT)
    public asx getRenderBoundingBox() {
        asx cbb;
        asx bb2 = INFINITE_EXTENT_AABB;
        aqz type = this.q();
        if (type == aqz.bJ) {
            bb2 = asx.a().a((double)this.l, (double)this.m, (double)this.n, (double)(this.l + 1), (double)(this.m + 1), (double)(this.n + 1));
        } else if (type == aqz.az || type == aqz.cn) {
            bb2 = asx.a().a((double)(this.l - 1), (double)this.m, (double)(this.n - 1), (double)(this.l + 2), (double)(this.m + 2), (double)(this.n + 2));
        } else if (type != null && type != aqz.cf && (cbb = this.q().b(this.k, this.l, this.m, this.n)) != null) {
            bb2 = cbb;
        }
        return bb2;
    }

    static {
        asp.a(asg.class, "Furnace");
        asp.a(ary.class, "Chest");
        asp.a(asf.class, "EnderChest");
        asp.a(aox.class, "RecordPlayer");
        asp.a(asc.class, "Trap");
        asp.a(asd.class, "Dropper");
        asp.a(asm.class, "Sign");
        asp.a(asj.class, "MobSpawner");
        asp.a(asl.class, "Music");
        asp.a(asw.class, "Piston");
        asp.a(arx.class, "Cauldron");
        asp.a(ase.class, "EnchantTable");
        asp.a(aso.class, "Airportal");
        asp.a(arz.class, "Control");
        asp.a(arw.class, "Beacon");
        asp.a(asn.class, "Skull");
        asp.a(asb.class, "DLDetector");
        asp.a(asi.class, "Hopper");
        asp.a(asa.class, "Comparator");
        INFINITE_EXTENT_AABB = asx.a((double)Double.NEGATIVE_INFINITY, (double)Double.NEGATIVE_INFINITY, (double)Double.NEGATIVE_INFINITY, (double)Double.POSITIVE_INFINITY, (double)Double.POSITIVE_INFINITY, (double)Double.POSITIVE_INFINITY);
    }
}

