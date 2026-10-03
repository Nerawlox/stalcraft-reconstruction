/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  agj
 *  agk
 *  agl
 *  ait
 */
import java.util.List;
import java.util.Random;

public class agh {
    public static final mk[] a = new mk[]{new mk(yc.q.cv, 0, 1, 5, 10), new mk(yc.r.cv, 0, 1, 3, 5), new mk(yc.aE.cv, 0, 4, 9, 5), new mk(yc.aY.cv, 4, 4, 9, 5), new mk(yc.p.cv, 0, 1, 2, 3), new mk(yc.o.cv, 0, 3, 8, 10), new mk(yc.W.cv, 0, 1, 3, 15), new mk(yc.i.cv, 0, 1, 1, 1), new mk(aqz.aL.cF, 0, 4, 8, 1), new mk(yc.bj.cv, 0, 2, 4, 10), new mk(yc.bi.cv, 0, 2, 4, 10), new mk(yc.aC.cv, 0, 1, 1, 3), new mk(yc.ce.cv, 0, 1, 1, 1)};

    public static void a() {
        air.a(agi.class, "MSCorridor");
        air.a(agj.class, "MSCrossing");
        air.a(agk.class, "MSRoom");
        air.a(agl.class, "MSStairs");
    }

    private static ait a(List par0List, Random par1Random, int par2, int par3, int par4, int par5, int par6) {
        int j1 = par1Random.nextInt(100);
        if (j1 >= 80) {
            agf structureboundingbox = agj.a((List)par0List, (Random)par1Random, (int)par2, (int)par3, (int)par4, (int)par5);
            if (structureboundingbox != null) {
                return new agj(par6, par1Random, structureboundingbox, par5);
            }
        } else if (j1 >= 70) {
            agf structureboundingbox = agl.a((List)par0List, (Random)par1Random, (int)par2, (int)par3, (int)par4, (int)par5);
            if (structureboundingbox != null) {
                return new agl(par6, par1Random, structureboundingbox, par5);
            }
        } else {
            agf structureboundingbox = agi.a(par0List, par1Random, par2, par3, par4, par5);
            if (structureboundingbox != null) {
                return new agi(par6, par1Random, structureboundingbox, par5);
            }
        }
        return null;
    }

    private static ait b(ait par0StructureComponent, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        if (par7 > 8) {
            return null;
        }
        if (Math.abs(par3 - par0StructureComponent.c().a) <= 80 && Math.abs(par5 - par0StructureComponent.c().c) <= 80) {
            ait structurecomponent1 = agh.a(par1List, par2Random, par3, par4, par5, par6, par7 + 1);
            if (structurecomponent1 != null) {
                par1List.add(structurecomponent1);
                structurecomponent1.a(par0StructureComponent, par1List, par2Random);
            }
            return structurecomponent1;
        }
        return null;
    }

    static ait a(ait par0StructureComponent, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        return agh.b(par0StructureComponent, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static mk[] b() {
        return a;
    }
}

