/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class tgbl {
    public static tgbl[] field_78032_a = new tgbl[12];
    public static final tgbl field_78030_b = new jjev(0, "buildingBlocks");
    public static final tgbl field_78031_c = new yela(1, "decorations");
    public static final tgbl field_78028_d = new cvrk(2, "redstone");
    public static final tgbl field_78029_e = new bsof(3, "transportation");
    public static final tgbl field_78026_f = new ixdp(4, "misc").func_111229_a(nvsz._a);
    public static final tgbl field_78027_g = new qnyl(5, "search").func_78025_a("item_search.png");
    public static final tgbl field_78039_h = new wpkb(6, "food");
    public static final tgbl field_78040_i = new xsnm(7, "tools").func_111229_a(nvsz._h);
    public static final tgbl field_78037_j = new oyug(8, "combat").func_111229_a(nvsz._b, nvsz._c, nvsz._f, nvsz._d, nvsz._e, nvsz._i, nvsz._g);
    public static final tgbl field_78038_k = new pkse(9, "brewing");
    public static final tgbl field_78035_l = new bsok(10, "materials");
    public static final tgbl field_78036_m = new oyub(11, "inventory").func_78025_a("inventory.png").func_78022_j().func_78014_h();
    public final int field_78033_n;
    public final String field_78034_o;
    public String field_78043_p = "items.png";
    public boolean field_78042_q = true;
    public boolean field_78041_r = true;
    public nvsz[] field_111230_s;

    public tgbl(String string) {
        this(tgbl.getNextID(), string);
    }

    public tgbl(int n, String string) {
        if (n >= field_78032_a.length) {
            tgbl[] tgblArray = new tgbl[n + 1];
            for (int i = 0; i < field_78032_a.length; ++i) {
                tgblArray[i] = field_78032_a[i];
            }
            field_78032_a = tgblArray;
        }
        this.field_78033_n = n;
        this.field_78034_o = string;
        tgbl.field_78032_a[n] = this;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_78021_a() {
        return this.field_78033_n;
    }

    public tgbl func_78025_a(String string) {
        this.field_78043_p = string;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public String func_78013_b() {
        return this.field_78034_o;
    }

    @SideOnly(value=Side.CLIENT)
    public String func_78024_c() {
        return "itemGroup." + this.func_78013_b();
    }

    @SideOnly(value=Side.CLIENT)
    public tgdv func_78016_d() {
        return tgdv.field_77698_e[this.func_78012_e()];
    }

    @SideOnly(value=Side.CLIENT)
    public int func_78012_e() {
        return 1;
    }

    @SideOnly(value=Side.CLIENT)
    public String func_78015_f() {
        return this.field_78043_p;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_78019_g() {
        return this.field_78041_r;
    }

    public tgbl func_78014_h() {
        this.field_78041_r = false;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_78017_i() {
        return this.field_78042_q;
    }

    public tgbl func_78022_j() {
        this.field_78042_q = false;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_78020_k() {
        if (this.field_78033_n > 11) {
            return (this.field_78033_n - 12) % 10 % 5;
        }
        return this.field_78033_n % 6;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_78023_l() {
        if (this.field_78033_n > 11) {
            return (this.field_78033_n - 12) % 10 < 5;
        }
        return this.field_78033_n < 6;
    }

    @SideOnly(value=Side.CLIENT)
    public nvsz[] func_111225_m() {
        return this.field_111230_s;
    }

    public tgbl func_111229_a(nvsz ... nvszArray) {
        this.field_111230_s = nvszArray;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_111226_a(nvsz nvsz2) {
        if (this.field_111230_s == null) {
            return false;
        }
        for (nvsz nvsz3 : this.field_111230_s) {
            if (nvsz3 != nvsz2) continue;
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_78018_a(List list2) {
        for (tgdv tgdv2 : tgdv.field_77698_e) {
            if (tgdv2 == null) continue;
            for (tgbl tgbl2 : tgdv2.getCreativeTabs()) {
                if (tgbl2 != this) continue;
                tgdv2.func_77633_a(tgdv2.field_77779_bT, this, list2);
            }
        }
        if (this.func_111225_m() != null) {
            this.func_92116_a(list2, this.func_111225_m());
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_92116_a(List list2, nvsz ... nvszArray) {
        for (zhqo zhqo2 : zhqo._a) {
            if (zhqo2 == null || zhqo2._A == null) continue;
            boolean bl = false;
            for (int i = 0; i < nvszArray.length && !bl; ++i) {
                if (zhqo2._A != nvszArray[i]) continue;
                bl = true;
            }
            if (!bl) continue;
            list2.add(tgdv.field_92105_bW._a(new ixcc(zhqo2, zhqo2._c())));
        }
    }

    public int getTabPage() {
        if (this.field_78033_n > 11) {
            return (this.field_78033_n - 12) / 10 + 1;
        }
        return 0;
    }

    public static int getNextID() {
        return field_78032_a.length;
    }

    public cvzo getIconItemStack() {
        return new cvzo(this.func_78016_d());
    }

    public boolean hasSearchBar() {
        return this.field_78033_n == tgbl.field_78027_g.field_78033_n;
    }
}

