/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  agq
 *  agr
 *  ags
 *  agt
 *  agu
 *  agv
 *  agw
 *  agx
 *  agy
 *  agz
 *  aha
 *  ahb
 *  ahc
 *  ahd
 *  ahe
 *  ahf
 *  ahg
 */
import java.util.List;
import java.util.Random;

public class agp {
    private static final ahd[] a = new ahd[]{new ahd(ags.class, 30, 0, true), new ahd(agq.class, 10, 4), new ahd(ahe.class, 10, 4), new ahd(ahf.class, 10, 3), new ahd(ahb.class, 5, 2), new ahd(agv.class, 5, 1)};
    private static final ahd[] b = new ahd[]{new ahd(agy.class, 25, 0, true), new ahd(agw.class, 15, 5), new ahd(agz.class, 5, 10), new ahd(agx.class, 5, 10), new ahd(agt.class, 10, 3, true), new ahd(agu.class, 7, 2), new ahd(aha.class, 5, 2)};

    public static void a() {
        air.a(agq.class, "NeBCr");
        air.a(agr.class, "NeBEF");
        air.a(ags.class, "NeBS");
        air.a(agt.class, "NeCCS");
        air.a(agu.class, "NeCTB");
        air.a(agv.class, "NeCE");
        air.a(agw.class, "NeSCSC");
        air.a(agx.class, "NeSCLT");
        air.a(agy.class, "NeSC");
        air.a(agz.class, "NeSCRT");
        air.a(aha.class, "NeCSR");
        air.a(ahb.class, "NeMT");
        air.a(ahe.class, "NeRC");
        air.a(ahf.class, "NeSR");
        air.a(ahg.class, "NeStart");
    }

    private static ahc b(ahd par0StructureNetherBridgePieceWeight, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        Class oclass = par0StructureNetherBridgePieceWeight.a;
        ags object = null;
        if (oclass == ags.class) {
            object = ags.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == agq.class) {
            object = agq.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == ahe.class) {
            object = ahe.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == ahf.class) {
            object = ahf.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == ahb.class) {
            object = ahb.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == agv.class) {
            object = agv.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == agy.class) {
            object = agy.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == agz.class) {
            object = agz.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == agx.class) {
            object = agx.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == agt.class) {
            object = agt.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == agu.class) {
            object = agu.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == agw.class) {
            object = agw.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        } else if (oclass == aha.class) {
            object = aha.a((List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6, (int)par7);
        }
        return (ahc)object;
    }

    static ahc a(ahd par0StructureNetherBridgePieceWeight, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        return agp.b(par0StructureNetherBridgePieceWeight, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static ahd[] b() {
        return a;
    }

    static ahd[] c() {
        return b;
    }
}

