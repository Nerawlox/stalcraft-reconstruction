/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import net.minecraft.crash.jxsn;
import net.minecraft.util.eidj;

public class hurg {
    public static Map field_70326_a = new HashMap();
    public static Map field_70323_b = new HashMap();
    public ozlu field_70331_k;
    public int field_70329_l;
    public int field_70330_m;
    public int field_70327_n;
    public boolean field_70328_o;
    public int field_70325_p = -1;
    public twgu field_70324_q;
    public boolean isVanilla = this.getClass().getName().startsWith("net.minecraft.tileentity");
    public static final eidj INFINITE_EXTENT_AABB;

    public static void func_70306_a(Class clazz, String string) {
        if (field_70326_a.containsKey(string)) {
            throw new IllegalArgumentException("Duplicate id: " + string);
        }
        field_70326_a.put(string, clazz);
        field_70323_b.put(clazz, string);
    }

    public ozlu func_70314_l() {
        return this.field_70331_k;
    }

    public void func_70308_a(ozlu ozlu2) {
        this.field_70331_k = ozlu2;
    }

    public boolean func_70309_m() {
        return this.field_70331_k != null;
    }

    public void func_70307_a(qoac qoac2) {
        this.field_70329_l = qoac2._f("x");
        this.field_70330_m = qoac2._f("y");
        this.field_70327_n = qoac2._f("z");
    }

    public void func_70310_b(qoac qoac2) {
        String string = (String)field_70323_b.get(this.getClass());
        if (string == null) {
            throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
        }
        qoac2._a("id", string);
        qoac2._a("x", this.field_70329_l);
        qoac2._a("y", this.field_70330_m);
        qoac2._a("z", this.field_70327_n);
    }

    public void func_70316_g() {
    }

    public static hurg func_70317_c(qoac qoac2) {
        hurg hurg2 = null;
        Class clazz = null;
        try {
            clazz = (Class)field_70326_a.get(qoac2._j("id"));
            if (clazz != null) {
                hurg2 = (hurg)clazz.newInstance();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (hurg2 != null) {
            try {
                hurg2.func_70307_a(qoac2);
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "A TileEntity %s(%s) has thrown an exception during loading, its state cannot be restored. Report this to the mod author", qoac2._j("id"), clazz.getName());
                hurg2 = null;
            }
        } else {
            dzfd._I()._O()._b("Skipping TileEntity with id " + qoac2._j("id"));
        }
        return hurg2;
    }

    public int func_70322_n() {
        if (this.field_70325_p == -1) {
            this.field_70325_p = this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
        }
        return this.field_70325_p;
    }

    public void func_70296_d() {
        if (this.field_70331_k != null) {
            this.field_70325_p = this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
            this.field_70331_k.func_72944_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, this);
            if (this.func_70311_o() != null) {
                this.field_70331_k.func_96440_m(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca);
            }
        }
    }

    public double func_70318_a(double d, double d2, double d3) {
        double d4 = (double)this.field_70329_l + 0.5 - d;
        double d5 = (double)this.field_70330_m + 0.5 - d2;
        double d6 = (double)this.field_70327_n + 0.5 - d3;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    @SideOnly(value=Side.CLIENT)
    public double func_82115_m() {
        return 4096.0;
    }

    public twgu func_70311_o() {
        if (this.field_70324_q == null) {
            this.field_70324_q = twgu.field_71973_m[this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n)];
        }
        return this.field_70324_q;
    }

    public cezg func_70319_e() {
        return null;
    }

    public boolean func_70320_p() {
        return this.field_70328_o;
    }

    public void func_70313_j() {
        this.field_70328_o = true;
    }

    public void func_70312_q() {
        this.field_70328_o = false;
    }

    public boolean func_70315_b(int n, int n2) {
        return false;
    }

    public void func_70321_h() {
        this.field_70324_q = null;
        this.field_70325_p = -1;
    }

    public void func_85027_a(jxsn jxsn2) {
        jxsn2._a("Name", new nwdw(this));
        jxsn._a(jxsn2, this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca, this.func_70322_n());
        jxsn2._a("Actual block type", new ujvt(this));
        jxsn2._a("Actual block data value", new hurz(this));
    }

    public static Map func_85028_t() {
        return field_70323_b;
    }

    public boolean canUpdate() {
        return true;
    }

    public void onDataPacket(jjpj jjpj2, wpte wpte2) {
    }

    public void onChunkUnload() {
    }

    public boolean shouldRefresh(int n, int n2, int n3, int n4, ozlu ozlu2, int n5, int n6, int n7) {
        return !this.isVanilla || n != n2;
    }

    public boolean shouldRenderInPass(int n) {
        return n == 0;
    }

    @SideOnly(value=Side.CLIENT)
    public eidj getRenderBoundingBox() {
        eidj eidj2;
        eidj eidj3 = INFINITE_EXTENT_AABB;
        twgu twgu2 = this.func_70311_o();
        if (twgu2 == twgu.field_72096_bE) {
            eidj3 = eidj._a()._a(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.field_70329_l + 1, this.field_70330_m + 1, this.field_70327_n + 1);
        } else if (twgu2 == twgu.field_72077_au || twgu2 == twgu.field_94347_ck) {
            eidj3 = eidj._a()._a(this.field_70329_l - 1, this.field_70330_m, this.field_70327_n - 1, this.field_70329_l + 2, this.field_70330_m + 2, this.field_70327_n + 2);
        } else if (twgu2 != null && twgu2 != twgu.field_82518_cd && (eidj2 = this.func_70311_o().func_71872_e(this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n)) != null) {
            eidj3 = eidj2;
        }
        return eidj3;
    }

    static {
        hurg.func_70306_a(nwgz.class, "Furnace");
        hurg.func_70306_a(yfav.class, "Chest");
        hurg.func_70306_a(gaqr.class, "EnderChest");
        hurg.func_70306_a(xcbe.class, "RecordPlayer");
        hurg.func_70306_a(jjzo.class, "Trap");
        hurg.func_70306_a(hdtl.class, "Dropper");
        hurg.func_70306_a(jjza.class, "Sign");
        hurg.func_70306_a(xtcq.class, "MobSpawner");
        hurg.func_70306_a(tgvf.class, "Music");
        hurg.func_70306_a(mcbr.class, "Piston");
        hurg.func_70306_a(nfbs.class, "Cauldron");
        hurg.func_70306_a(mtdr.class, "EnchantTable");
        hurg.func_70306_a(zziy.class, "Airportal");
        hurg.func_70306_a(oiid.class, "Control");
        hurg.func_70306_a(vmyb.class, "Beacon");
        hurg.func_70306_a(fool.class, "Skull");
        hurg.func_70306_a(aqba.class, "DLDetector");
        hurg.func_70306_a(cffd.class, "Hopper");
        hurg.func_70306_a(jjzm.class, "Comparator");
        INFINITE_EXTENT_AABB = eidj._a(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
}

