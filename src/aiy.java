/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ait
 *  aiw
 *  aiz
 *  aja
 *  ajb
 *  ajc
 *  ajd
 *  aje
 *  ajf
 *  ajg
 *  ajh
 *  ajj
 *  ajk
 *  ajl
 *  ajm
 *  ajo
 *  cpw.mods.fml.common.registry.VillagerRegistry
 */
import cpw.mods.fml.common.registry.VillagerRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class aiy {
    public static void a() {
        air.a(aiz.class, "ViBH");
        air.a(aja.class, "ViDF");
        air.a(ajb.class, "ViF");
        air.a(ajc.class, "ViL");
        air.a(aje.class, "ViPH");
        air.a(ajf.class, "ViSH");
        air.a(ajg.class, "ViSmH");
        air.a(ajh.class, "ViST");
        air.a(aji.class, "ViS");
        air.a(ajj.class, "ViStart");
        air.a(ajk.class, "ViSR");
        air.a(ajl.class, "ViTRH");
        air.a(ajo.class, "ViW");
    }

    public static List a(Random par0Random, int par1) {
        ArrayList<ajd> arraylist = new ArrayList<ajd>();
        arraylist.add(new ajd(ajf.class, 4, ls.a(par0Random, 2 + par1, 4 + par1 * 2)));
        arraylist.add(new ajd(ajh.class, 20, ls.a(par0Random, 0 + par1, 1 + par1)));
        arraylist.add(new ajd(aiz.class, 20, ls.a(par0Random, 0 + par1, 2 + par1)));
        arraylist.add(new ajd(ajg.class, 3, ls.a(par0Random, 2 + par1, 5 + par1 * 3)));
        arraylist.add(new ajd(aje.class, 15, ls.a(par0Random, 0 + par1, 2 + par1)));
        arraylist.add(new ajd(aja.class, 3, ls.a(par0Random, 1 + par1, 4 + par1)));
        arraylist.add(new ajd(ajb.class, 3, ls.a(par0Random, 2 + par1, 4 + par1 * 2)));
        arraylist.add(new ajd(aji.class, 15, ls.a(par0Random, 0, 1 + par1)));
        arraylist.add(new ajd(ajl.class, 8, ls.a(par0Random, 0 + par1, 3 + par1 * 2)));
        VillagerRegistry.addExtraVillageComponents(arraylist, (Random)par0Random, (int)par1);
        Iterator iterator = arraylist.iterator();
        while (iterator.hasNext()) {
            if (((ajd)iterator.next()).d != 0) continue;
            iterator.remove();
        }
        return arraylist;
    }

    private static int a(List par0List) {
        boolean flag = false;
        int i = 0;
        for (ajd structurevillagepieceweight : par0List) {
            if (structurevillagepieceweight.d > 0 && structurevillagepieceweight.c < structurevillagepieceweight.d) {
                flag = true;
            }
            i += structurevillagepieceweight.b;
        }
        return flag ? i : -1;
    }

    private static ajm a(ajj par0ComponentVillageStartPiece, ajd par1StructureVillagePieceWeight, List par2List, Random par3Random, int par4, int par5, int par6, int par7, int par8) {
        Class oclass = par1StructureVillagePieceWeight.a;
        Object object = null;
        object = oclass == ajf.class ? ajf.a((ajj)par0ComponentVillageStartPiece, (List)par2List, (Random)par3Random, (int)par4, (int)par5, (int)par6, (int)par7, (int)par8) : (oclass == ajh.class ? ajh.a((ajj)par0ComponentVillageStartPiece, (List)par2List, (Random)par3Random, (int)par4, (int)par5, (int)par6, (int)par7, (int)par8) : (oclass == aiz.class ? aiz.a((ajj)par0ComponentVillageStartPiece, (List)par2List, (Random)par3Random, (int)par4, (int)par5, (int)par6, (int)par7, (int)par8) : (oclass == ajg.class ? ajg.a((ajj)par0ComponentVillageStartPiece, (List)par2List, (Random)par3Random, (int)par4, (int)par5, (int)par6, (int)par7, (int)par8) : (oclass == aje.class ? aje.a((ajj)par0ComponentVillageStartPiece, (List)par2List, (Random)par3Random, (int)par4, (int)par5, (int)par6, (int)par7, (int)par8) : (oclass == aja.class ? aja.a((ajj)par0ComponentVillageStartPiece, (List)par2List, (Random)par3Random, (int)par4, (int)par5, (int)par6, (int)par7, (int)par8) : (oclass == ajb.class ? ajb.a((ajj)par0ComponentVillageStartPiece, (List)par2List, (Random)par3Random, (int)par4, (int)par5, (int)par6, (int)par7, (int)par8) : (oclass == aji.class ? aji.a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8) : (oclass == ajl.class ? ajl.a((ajj)par0ComponentVillageStartPiece, (List)par2List, (Random)par3Random, (int)par4, (int)par5, (int)par6, (int)par7, (int)par8) : VillagerRegistry.getVillageComponent((ajd)par1StructureVillagePieceWeight, (ajj)par0ComponentVillageStartPiece, (List)par2List, (Random)par3Random, (int)par4, (int)par5, (int)par6, (int)par7, (int)par8)))))))));
        return (ajm)object;
    }

    private static ajm c(ajj par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        int j1 = aiy.a(par0ComponentVillageStartPiece.e);
        if (j1 <= 0) {
            return null;
        }
        int k1 = 0;
        block0: while (k1 < 5) {
            ++k1;
            int l1 = par2Random.nextInt(j1);
            for (ajd structurevillagepieceweight : par0ComponentVillageStartPiece.e) {
                if ((l1 -= structurevillagepieceweight.b) >= 0) continue;
                if (!structurevillagepieceweight.a(par7) || structurevillagepieceweight == par0ComponentVillageStartPiece.d && par0ComponentVillageStartPiece.e.size() > 1) continue block0;
                ajm componentvillage = aiy.a(par0ComponentVillageStartPiece, structurevillagepieceweight, par1List, par2Random, par3, par4, par5, par6, par7);
                if (componentvillage == null) continue;
                ++structurevillagepieceweight.c;
                par0ComponentVillageStartPiece.d = structurevillagepieceweight;
                if (!structurevillagepieceweight.a()) {
                    par0ComponentVillageStartPiece.e.remove(structurevillagepieceweight);
                }
                return componentvillage;
            }
        }
        agf structureboundingbox = ajc.a((ajj)par0ComponentVillageStartPiece, (List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6);
        if (structureboundingbox != null) {
            return new ajc(par0ComponentVillageStartPiece, par7, par2Random, structureboundingbox, par6);
        }
        return null;
    }

    private static ait d(ajj par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        if (par7 > 50) {
            return null;
        }
        if (Math.abs(par3 - par0ComponentVillageStartPiece.c().a) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.c().c) <= 112) {
            ajm componentvillage = aiy.c(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7 + 1);
            if (componentvillage != null) {
                int j2;
                int j1 = (componentvillage.f.a + componentvillage.f.d) / 2;
                int k1 = (componentvillage.f.c + componentvillage.f.f) / 2;
                int l1 = componentvillage.f.d - componentvillage.f.a;
                int i2 = componentvillage.f.f - componentvillage.f.c;
                int n = j2 = l1 > i2 ? l1 : i2;
                if (par0ComponentVillageStartPiece.e().a(j1, k1, j2 / 2 + 4, aiw.e)) {
                    par1List.add(componentvillage);
                    par0ComponentVillageStartPiece.i.add(componentvillage);
                    return componentvillage;
                }
            }
            return null;
        }
        return null;
    }

    private static ait e(ajj par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        if (par7 > 3 + par0ComponentVillageStartPiece.c) {
            return null;
        }
        if (Math.abs(par3 - par0ComponentVillageStartPiece.c().a) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.c().c) <= 112) {
            agf structureboundingbox = ajk.a((ajj)par0ComponentVillageStartPiece, (List)par1List, (Random)par2Random, (int)par3, (int)par4, (int)par5, (int)par6);
            if (structureboundingbox != null && structureboundingbox.b > 10) {
                int j2;
                ajk componentvillagepathgen = new ajk(par0ComponentVillageStartPiece, par7, par2Random, structureboundingbox, par6);
                int j1 = (componentvillagepathgen.f.a + componentvillagepathgen.f.d) / 2;
                int k1 = (componentvillagepathgen.f.c + componentvillagepathgen.f.f) / 2;
                int l1 = componentvillagepathgen.f.d - componentvillagepathgen.f.a;
                int i2 = componentvillagepathgen.f.f - componentvillagepathgen.f.c;
                int n = j2 = l1 > i2 ? l1 : i2;
                if (par0ComponentVillageStartPiece.e().a(j1, k1, j2 / 2 + 4, aiw.e)) {
                    par1List.add(componentvillagepathgen);
                    par0ComponentVillageStartPiece.j.add(componentvillagepathgen);
                    return componentvillagepathgen;
                }
            }
            return null;
        }
        return null;
    }

    static ait a(ajj par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        return aiy.d(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static ait b(ajj par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        return aiy.e(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }
}

