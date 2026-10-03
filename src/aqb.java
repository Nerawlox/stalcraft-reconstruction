/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  aco
 *  akc
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 *  r
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class aqb
extends aqz {
    private boolean a = true;
    private Set b = new HashSet();
    @SideOnly(value=Side.CLIENT)
    private ms c;
    @SideOnly(value=Side.CLIENT)
    private ms d;
    @SideOnly(value=Side.CLIENT)
    private ms e;
    @SideOnly(value=Side.CLIENT)
    private ms cX;

    public aqb(int par1) {
        super(par1, akc.q);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
    }

    @Override
    public asx b(abw par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public int d() {
        return 5;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int c(acf par1IBlockAccess, int par2, int par3, int par4) {
        return 0x800000;
    }

    @Override
    public boolean c(abw par1World, int par2, int par3, int par4) {
        return par1World.w(par2, par3 - 1, par4) || par1World.a(par2, par3 - 1, par4) == aqz.bi.cF;
    }

    private void k(abw par1World, int par2, int par3, int par4) {
        this.a(par1World, par2, par3, par4, par2, par3, par4);
        ArrayList arraylist = new ArrayList(this.b);
        this.b.clear();
        for (int l = 0; l < arraylist.size(); ++l) {
            aco chunkposition = (aco)arraylist.get(l);
            par1World.f(chunkposition.a, chunkposition.b, chunkposition.c, this.cF);
        }
    }

    private void a(abw par1World, int par2, int par3, int par4, int par5, int par6, int par7) {
        int k1 = par1World.h(par2, par3, par4);
        int b0 = 0;
        int l1 = this.d(par1World, par5, par6, par7, b0);
        this.a = false;
        int i2 = par1World.D(par2, par3, par4);
        this.a = true;
        if (i2 > 0 && i2 > l1 - 1) {
            l1 = i2;
        }
        int j2 = 0;
        for (int k2 = 0; k2 < 4; ++k2) {
            int l2 = par2;
            int i3 = par4;
            if (k2 == 0) {
                l2 = par2 - 1;
            }
            if (k2 == 1) {
                ++l2;
            }
            if (k2 == 2) {
                i3 = par4 - 1;
            }
            if (k2 == 3) {
                ++i3;
            }
            if (l2 != par5 || i3 != par7) {
                j2 = this.d(par1World, l2, par3, i3, j2);
            }
            if (par1World.u(l2, par3, i3) && !par1World.u(par2, par3 + 1, par4)) {
                if (l2 == par5 && i3 == par7 || par3 < par6) continue;
                j2 = this.d(par1World, l2, par3 + 1, i3, j2);
                continue;
            }
            if (par1World.u(l2, par3, i3) || l2 == par5 && i3 == par7 || par3 > par6) continue;
            j2 = this.d(par1World, l2, par3 - 1, i3, j2);
        }
        l1 = j2 > l1 ? j2 - 1 : (l1 > 0 ? --l1 : 0);
        if (i2 > l1 - 1) {
            l1 = i2;
        }
        if (k1 != l1) {
            par1World.b(par2, par3, par4, l1, 2);
            this.b.add(new aco(par2, par3, par4));
            this.b.add(new aco(par2 - 1, par3, par4));
            this.b.add(new aco(par2 + 1, par3, par4));
            this.b.add(new aco(par2, par3 - 1, par4));
            this.b.add(new aco(par2, par3 + 1, par4));
            this.b.add(new aco(par2, par3, par4 - 1));
            this.b.add(new aco(par2, par3, par4 + 1));
        }
    }

    private void m(abw par1World, int par2, int par3, int par4) {
        if (par1World.a(par2, par3, par4) == this.cF) {
            par1World.f(par2, par3, par4, this.cF);
            par1World.f(par2 - 1, par3, par4, this.cF);
            par1World.f(par2 + 1, par3, par4, this.cF);
            par1World.f(par2, par3, par4 - 1, this.cF);
            par1World.f(par2, par3, par4 + 1, this.cF);
            par1World.f(par2, par3 - 1, par4, this.cF);
            par1World.f(par2, par3 + 1, par4, this.cF);
        }
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4) {
        super.a(par1World, par2, par3, par4);
        if (!par1World.I) {
            this.k(par1World, par2, par3, par4);
            par1World.f(par2, par3 + 1, par4, this.cF);
            par1World.f(par2, par3 - 1, par4, this.cF);
            this.m(par1World, par2 - 1, par3, par4);
            this.m(par1World, par2 + 1, par3, par4);
            this.m(par1World, par2, par3, par4 - 1);
            this.m(par1World, par2, par3, par4 + 1);
            if (par1World.u(par2 - 1, par3, par4)) {
                this.m(par1World, par2 - 1, par3 + 1, par4);
            } else {
                this.m(par1World, par2 - 1, par3 - 1, par4);
            }
            if (par1World.u(par2 + 1, par3, par4)) {
                this.m(par1World, par2 + 1, par3 + 1, par4);
            } else {
                this.m(par1World, par2 + 1, par3 - 1, par4);
            }
            if (par1World.u(par2, par3, par4 - 1)) {
                this.m(par1World, par2, par3 + 1, par4 - 1);
            } else {
                this.m(par1World, par2, par3 - 1, par4 - 1);
            }
            if (par1World.u(par2, par3, par4 + 1)) {
                this.m(par1World, par2, par3 + 1, par4 + 1);
            } else {
                this.m(par1World, par2, par3 - 1, par4 + 1);
            }
        }
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5, int par6) {
        super.a(par1World, par2, par3, par4, par5, par6);
        if (!par1World.I) {
            par1World.f(par2, par3 + 1, par4, this.cF);
            par1World.f(par2, par3 - 1, par4, this.cF);
            par1World.f(par2 + 1, par3, par4, this.cF);
            par1World.f(par2 - 1, par3, par4, this.cF);
            par1World.f(par2, par3, par4 + 1, this.cF);
            par1World.f(par2, par3, par4 - 1, this.cF);
            this.k(par1World, par2, par3, par4);
            this.m(par1World, par2 - 1, par3, par4);
            this.m(par1World, par2 + 1, par3, par4);
            this.m(par1World, par2, par3, par4 - 1);
            this.m(par1World, par2, par3, par4 + 1);
            if (par1World.u(par2 - 1, par3, par4)) {
                this.m(par1World, par2 - 1, par3 + 1, par4);
            } else {
                this.m(par1World, par2 - 1, par3 - 1, par4);
            }
            if (par1World.u(par2 + 1, par3, par4)) {
                this.m(par1World, par2 + 1, par3 + 1, par4);
            } else {
                this.m(par1World, par2 + 1, par3 - 1, par4);
            }
            if (par1World.u(par2, par3, par4 - 1)) {
                this.m(par1World, par2, par3 + 1, par4 - 1);
            } else {
                this.m(par1World, par2, par3 - 1, par4 - 1);
            }
            if (par1World.u(par2, par3, par4 + 1)) {
                this.m(par1World, par2, par3 + 1, par4 + 1);
            } else {
                this.m(par1World, par2, par3 - 1, par4 + 1);
            }
        }
    }

    private int d(abw par1World, int par2, int par3, int par4, int par5) {
        if (par1World.a(par2, par3, par4) != this.cF) {
            return par5;
        }
        int i1 = par1World.h(par2, par3, par4);
        return i1 > par5 ? i1 : par5;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5) {
        if (!par1World.I) {
            boolean flag = this.c(par1World, par2, par3, par4);
            if (flag) {
                this.k(par1World, par2, par3, par4);
            } else {
                this.c(par1World, par2, par3, par4, 0, 0);
                par1World.i(par2, par3, par4);
            }
            super.a(par1World, par2, par3, par4, par5);
        }
    }

    @Override
    public int a(int par1, Random par2Random, int par3) {
        return yc.aE.cv;
    }

    @Override
    public int c(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return !this.a ? 0 : this.b(par1IBlockAccess, par2, par3, par4, par5);
    }

    @Override
    public int b(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        boolean flag3;
        if (!this.a) {
            return 0;
        }
        int i1 = par1IBlockAccess.h(par2, par3, par4);
        if (i1 == 0) {
            return 0;
        }
        if (par5 == 1) {
            return i1;
        }
        boolean flag = aqb.g(par1IBlockAccess, par2 - 1, par3, par4, 1) || !par1IBlockAccess.u(par2 - 1, par3, par4) && aqb.g(par1IBlockAccess, par2 - 1, par3 - 1, par4, -1);
        boolean flag1 = aqb.g(par1IBlockAccess, par2 + 1, par3, par4, 3) || !par1IBlockAccess.u(par2 + 1, par3, par4) && aqb.g(par1IBlockAccess, par2 + 1, par3 - 1, par4, -1);
        boolean flag2 = aqb.g(par1IBlockAccess, par2, par3, par4 - 1, 2) || !par1IBlockAccess.u(par2, par3, par4 - 1) && aqb.g(par1IBlockAccess, par2, par3 - 1, par4 - 1, -1);
        boolean bl2 = flag3 = aqb.g(par1IBlockAccess, par2, par3, par4 + 1, 0) || !par1IBlockAccess.u(par2, par3, par4 + 1) && aqb.g(par1IBlockAccess, par2, par3 - 1, par4 + 1, -1);
        if (!par1IBlockAccess.u(par2, par3 + 1, par4)) {
            if (par1IBlockAccess.u(par2 - 1, par3, par4) && aqb.g(par1IBlockAccess, par2 - 1, par3 + 1, par4, -1)) {
                flag = true;
            }
            if (par1IBlockAccess.u(par2 + 1, par3, par4) && aqb.g(par1IBlockAccess, par2 + 1, par3 + 1, par4, -1)) {
                flag1 = true;
            }
            if (par1IBlockAccess.u(par2, par3, par4 - 1) && aqb.g(par1IBlockAccess, par2, par3 + 1, par4 - 1, -1)) {
                flag2 = true;
            }
            if (par1IBlockAccess.u(par2, par3, par4 + 1) && aqb.g(par1IBlockAccess, par2, par3 + 1, par4 + 1, -1)) {
                flag3 = true;
            }
        }
        return !flag2 && !flag1 && !flag && !flag3 && par5 >= 2 && par5 <= 5 ? i1 : (par5 == 2 && flag2 && !flag && !flag1 ? i1 : (par5 == 3 && flag3 && !flag && !flag1 ? i1 : (par5 == 4 && flag && !flag2 && !flag3 ? i1 : (par5 == 5 && flag1 && !flag2 && !flag3 ? i1 : 0))));
    }

    @Override
    public boolean f() {
        return this.a;
    }

    public static boolean f(acf par0IBlockAccess, int par1, int par2, int par3, int par4) {
        int i1 = par0IBlockAccess.a(par1, par2, par3);
        if (i1 == aqz.aA.cF) {
            return true;
        }
        if (i1 == 0) {
            return false;
        }
        if (!aqz.bm.g(i1)) {
            return aqz.s[i1] != null && aqz.s[i1].canConnectRedstone(par0IBlockAccess, par1, par2, par3, par4);
        }
        int j1 = par0IBlockAccess.h(par1, par2, par3);
        return par4 == (j1 & 3) || par4 == r.f[j1 & 3];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void b(abw par1World, int par2, int par3, int par4, Random par5Random) {
        int l = par1World.h(par2, par3, par4);
        if (l > 0) {
            double d0 = (double)par2 + 0.5 + ((double)par5Random.nextFloat() - 0.5) * 0.2;
            double d1 = (float)par3 + 0.0625f;
            double d2 = (double)par4 + 0.5 + ((double)par5Random.nextFloat() - 0.5) * 0.2;
            float f = (float)l / 15.0f;
            float f1 = f * 0.6f + 0.4f;
            if (l == 0) {
                f1 = 0.0f;
            }
            float f2 = f * f * 0.7f - 0.5f;
            float f3 = f * f * 0.6f - 0.7f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            par1World.a("reddust", d0, d1, d2, (double)f1, (double)f2, f3);
        }
    }

    public static boolean g(acf par0IBlockAccess, int par1, int par2, int par3, int par4) {
        if (aqb.f(par0IBlockAccess, par1, par2, par3, par4)) {
            return true;
        }
        int i1 = par0IBlockAccess.a(par1, par2, par3);
        if (i1 == aqz.bn.cF) {
            int j1 = par0IBlockAccess.h(par1, par2, par3);
            return par4 == (j1 & 3);
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int d(abw par1World, int par2, int par3, int par4) {
        return yc.aE.cv;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.c = par1IconRegister.a(this.E() + "_cross");
        this.d = par1IconRegister.a(this.E() + "_line");
        this.e = par1IconRegister.a(this.E() + "_cross_overlay");
        this.cX = par1IconRegister.a(this.E() + "_line_overlay");
        this.cW = this.c;
    }

    @SideOnly(value=Side.CLIENT)
    public static ms b(String par0Str) {
        return par0Str.equals("cross") ? aqz.aA.c : (par0Str.equals("line") ? aqz.aA.d : (par0Str.equals("cross_overlay") ? aqz.aA.e : (par0Str.equals("line_overlay") ? aqz.aA.cX : null)));
    }
}

