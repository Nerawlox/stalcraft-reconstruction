/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aht
 *  ahu
 *  ahx
 *  ahy
 *  ahz
 *  aib
 *  aic
 *  aid
 *  aie
 *  aig
 *  aii
 *  aij
 *  aik
 *  ail
 *  ait
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ahs {
    private static final aib[] b = new aib[]{new aib(aij.class, 40, 0), new aib(aid.class, 5, 5), new aib(ahz.class, 20, 0), new aib(aie.class, 20, 0), new aib(aif.class, 10, 6), new aib(aik.class, 5, 5), new aib(aih.class, 5, 5), new aib(ahy.class, 5, 4), new aib(ahw.class, 5, 4), new aht(aia.class, 10, 2), new ahu(aic.class, 20, 1)};
    private static List c;
    private static Class d;
    static int a;
    private static final aig e;

    public static void a() {
        air.a(ahw.class, "SHCC");
        air.a(ahx.class, "SHFC");
        air.a(ahy.class, "SH5C");
        air.a(ahz.class, "SHLT");
        air.a(aia.class, "SHLi");
        air.a(aic.class, "SHPR");
        air.a(aid.class, "SHPH");
        air.a(aie.class, "SHRT");
        air.a(aif.class, "SHRC");
        air.a(aih.class, "SHSD");
        air.a(aii.class, "SHStart");
        air.a(aij.class, "SHS");
        air.a(aik.class, "SHSSD");
    }

    public static void b() {
        c = new ArrayList();
        for (aib structurestrongholdpieceweight : b) {
            structurestrongholdpieceweight.c = 0;
            c.add(structurestrongholdpieceweight);
        }
        d = null;
    }

    private static boolean d() {
        boolean flag = false;
        a = 0;
        for (aib structurestrongholdpieceweight : c) {
            if (structurestrongholdpieceweight.d > 0 && structurestrongholdpieceweight.c < structurestrongholdpieceweight.d) {
                flag = true;
            }
            a += structurestrongholdpieceweight.b;
        }
        return flag;
    }

    private static ail a(Class par0Class, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        Object object = null;
        if (par0Class == aij.class) {
            object = aij.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (par0Class == aid.class) {
            object = aid.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (par0Class == ahz.class) {
            object = ahz.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (par0Class == aie.class) {
            object = aie.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (par0Class == aif.class) {
            object = aif.a(par1List, par2Random, par3, par4, par5, par6, par7);
        } else if (par0Class == aik.class) {
            object = aik.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (par0Class == aih.class) {
            object = aih.a(par1List, par2Random, par3, par4, par5, par6, par7);
        } else if (par0Class == ahy.class) {
            object = ahy.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (par0Class == ahw.class) {
            object = ahw.a(par1List, par2Random, par3, par4, par5, par6, par7);
        } else if (par0Class == aia.class) {
            object = aia.a(par1List, par2Random, par3, par4, par5, par6, par7);
        } else if (par0Class == aic.class) {
            object = aic.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        }
        return (ail)object;
    }

    private static ail b(aii par0ComponentStrongholdStairs2, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        if (!ahs.d()) {
            return null;
        }
        if (d != null) {
            ail componentstronghold = ahs.a(d, par1List, par2Random, par3, par4, par5, par6, par7);
            d = null;
            if (componentstronghold != null) {
                return componentstronghold;
            }
        }
        int j1 = 0;
        block0: while (j1 < 5) {
            ++j1;
            int k1 = par2Random.nextInt(a);
            for (aib structurestrongholdpieceweight : c) {
                if ((k1 -= structurestrongholdpieceweight.b) >= 0) continue;
                if (!structurestrongholdpieceweight.a(par7) || structurestrongholdpieceweight == par0ComponentStrongholdStairs2.a) continue block0;
                ail componentstronghold1 = ahs.a(structurestrongholdpieceweight.a, par1List, par2Random, par3, par4, par5, par6, par7);
                if (componentstronghold1 == null) continue;
                ++structurestrongholdpieceweight.c;
                par0ComponentStrongholdStairs2.a = structurestrongholdpieceweight;
                if (!structurestrongholdpieceweight.a()) {
                    c.remove(structurestrongholdpieceweight);
                }
                return componentstronghold1;
            }
        }
        agf structureboundingbox = ahx.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6);
        if (structureboundingbox != null && structureboundingbox.b > 1) {
            return new ahx(par7, par2Random, structureboundingbox, par6);
        }
        return null;
    }

    private static ait c(aii par0ComponentStrongholdStairs2, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        if (par7 > 50) {
            return null;
        }
        if (Math.abs(par3 - par0ComponentStrongholdStairs2.c().a) <= 112 && Math.abs(par5 - par0ComponentStrongholdStairs2.c().c) <= 112) {
            ail componentstronghold = ahs.b(par0ComponentStrongholdStairs2, par1List, par2Random, par3, par4, par5, par6, par7 + 1);
            if (componentstronghold != null) {
                par1List.add(componentstronghold);
                par0ComponentStrongholdStairs2.c.add(componentstronghold);
            }
            return componentstronghold;
        }
        return null;
    }

    static ait a(aii par0ComponentStrongholdStairs2, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        return ahs.c(par0ComponentStrongholdStairs2, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static Class a(Class par0Class) {
        d = par0Class;
        return par0Class;
    }

    static aig c() {
        return e;
    }

    static {
        e = new aig((aht)null);
    }
}

