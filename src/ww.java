/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aau
 *  abb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  wx
 *  wy
 *  wz
 *  xa
 *  xb
 *  xc
 *  xd
 *  xe
 *  xf
 *  xg
 *  xh
 *  xi
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ww {
    public static ww[] a = new ww[12];
    public static final ww b = new wx(0, "buildingBlocks");
    public static final ww c = new xb(1, "decorations");
    public static final ww d = new xc(2, "redstone");
    public static final ww e = new xd(3, "transportation");
    public static final ww f = new xe(4, "misc").a(new aav[]{aav.a});
    public static final ww g = new xf(5, "search").a("item_search.png");
    public static final ww h = new xg(6, "food");
    public static final ww i = new xh(7, "tools").a(new aav[]{aav.h});
    public static final ww j = new xi(8, "combat").a(new aav[]{aav.b, aav.c, aav.f, aav.d, aav.e, aav.i, aav.g});
    public static final ww k = new wy(9, "brewing");
    public static final ww l = new wz(10, "materials");
    public static final ww m = new xa(11, "inventory").a("inventory.png").j().h();
    private final int n;
    private final String o;
    private String p = "items.png";
    private boolean q = true;
    private boolean r = true;
    private aav[] s;

    public ww(String label) {
        this(ww.getNextID(), label);
    }

    public ww(int par1, String par2Str) {
        if (par1 >= a.length) {
            ww[] tmp = new ww[par1 + 1];
            for (int x2 = 0; x2 < a.length; ++x2) {
                tmp[x2] = a[x2];
            }
            a = tmp;
        }
        this.n = par1;
        this.o = par2Str;
        ww.a[par1] = this;
    }

    @SideOnly(value=Side.CLIENT)
    public int a() {
        return this.n;
    }

    public ww a(String par1Str) {
        this.p = par1Str;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public String b() {
        return this.o;
    }

    @SideOnly(value=Side.CLIENT)
    public String c() {
        return "itemGroup." + this.b();
    }

    @SideOnly(value=Side.CLIENT)
    public yc d() {
        return yc.g[this.e()];
    }

    @SideOnly(value=Side.CLIENT)
    public int e() {
        return 1;
    }

    @SideOnly(value=Side.CLIENT)
    public String f() {
        return this.p;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean g() {
        return this.r;
    }

    public ww h() {
        this.r = false;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean i() {
        return this.q;
    }

    public ww j() {
        this.q = false;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public int k() {
        if (this.n > 11) {
            return (this.n - 12) % 10 % 5;
        }
        return this.n % 6;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean l() {
        if (this.n > 11) {
            return (this.n - 12) % 10 < 5;
        }
        return this.n < 6;
    }

    @SideOnly(value=Side.CLIENT)
    public aav[] m() {
        return this.s;
    }

    public ww a(aav ... par1ArrayOfEnumEnchantmentType) {
        this.s = par1ArrayOfEnumEnchantmentType;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean a(aav par1EnumEnchantmentType) {
        if (this.s == null) {
            return false;
        }
        for (aav enumenchantmenttype1 : this.s) {
            if (enumenchantmenttype1 != par1EnumEnchantmentType) continue;
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(List par1List) {
        for (yc item : yc.g) {
            if (item == null) continue;
            for (ww tab : item.getCreativeTabs()) {
                if (tab != this) continue;
                item.a(item.cv, this, par1List);
            }
        }
        if (this.m() != null) {
            this.a(par1List, this.m());
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void a(List par1List, aav ... par2ArrayOfEnumEnchantmentType) {
        for (aau enchantment : aau.b) {
            if (enchantment == null || enchantment.A == null) continue;
            boolean flag = false;
            for (int k2 = 0; k2 < par2ArrayOfEnumEnchantmentType.length && !flag; ++k2) {
                if (enchantment.A != par2ArrayOfEnumEnchantmentType[k2]) continue;
                flag = true;
            }
            if (!flag) continue;
            par1List.add(yc.bY.a(new abb(enchantment, enchantment.b())));
        }
    }

    public int getTabPage() {
        if (this.n > 11) {
            return (this.n - 12) / 10 + 1;
        }
        return 0;
    }

    public static int getNextID() {
        return a.length;
    }

    public ye getIconItemStack() {
        return new ye(this.d());
    }

    public boolean hasSearchBar() {
        return this.n == ww.g.n;
    }
}

