/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ahk
 *  ahn
 *  aho
 *  aiu
 *  net.minecraftforge.common.ChestGenHooks
 */
import java.util.Random;
import net.minecraftforge.common.ChestGenHooks;

public class ahm
extends aho {
    private boolean e;
    private boolean i;
    private boolean j;
    private boolean k;
    public static final mk[] l = new mk[]{new mk(yc.p.cv, 0, 1, 3, 3), new mk(yc.q.cv, 0, 1, 5, 10), new mk(yc.r.cv, 0, 2, 7, 15), new mk(yc.bJ.cv, 0, 1, 3, 2), new mk(yc.aZ.cv, 0, 4, 6, 20), new mk(yc.bo.cv, 0, 3, 7, 16), new mk(yc.aC.cv, 0, 1, 1, 3), new mk(yc.ce.cv, 0, 1, 1, 1), new mk(yc.cf.cv, 0, 1, 1, 1), new mk(yc.cg.cv, 0, 1, 1, 1)};
    public static final mk[] m = new mk[]{new mk(yc.n.cv, 0, 2, 7, 30)};
    private static ahn n = new ahn((ahk)null);

    public ahm() {
    }

    public ahm(Random par1Random, int par2, int par3) {
        super(par1Random, par2, 64, par3, 12, 10, 15);
    }

    protected void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        par1NBTTagCompound.a("placedMainChest", this.e);
        par1NBTTagCompound.a("placedHiddenChest", this.i);
        par1NBTTagCompound.a("placedTrap1", this.j);
        par1NBTTagCompound.a("placedTrap2", this.k);
    }

    protected void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        this.e = par1NBTTagCompound.n("placedMainChest");
        this.i = par1NBTTagCompound.n("placedHiddenChest");
        this.j = par1NBTTagCompound.n("placedTrap1");
        this.k = par1NBTTagCompound.n("placedTrap2");
    }

    public boolean a(abw par1World, Random par2Random, agf par3StructureBoundingBox) {
        int i1;
        if (!this.a(par1World, par3StructureBoundingBox, 0)) {
            return false;
        }
        int i = this.c(aqz.aM.cF, 3);
        int j2 = this.c(aqz.aM.cF, 2);
        int k = this.c(aqz.aM.cF, 0);
        int l = this.c(aqz.aM.cF, 1);
        this.a(par1World, par3StructureBoundingBox, 0, -4, 0, this.a - 1, 0, this.c - 1, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 2, 1, 2, 9, 2, 2, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 2, 1, 12, 9, 2, 12, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 2, 1, 3, 2, 2, 11, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 9, 1, 3, 9, 2, 11, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 1, 3, 1, 10, 6, 1, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 1, 3, 13, 10, 6, 13, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 1, 3, 2, 1, 6, 12, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 10, 3, 2, 10, 6, 12, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 2, 3, 2, 9, 3, 12, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 2, 6, 2, 9, 6, 12, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 3, 7, 3, 8, 7, 11, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 4, 8, 4, 7, 8, 10, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 3, 1, 3, 8, 2, 11);
        this.a(par1World, par3StructureBoundingBox, 4, 3, 6, 7, 3, 9);
        this.a(par1World, par3StructureBoundingBox, 2, 4, 2, 9, 5, 12);
        this.a(par1World, par3StructureBoundingBox, 4, 6, 5, 7, 6, 9);
        this.a(par1World, par3StructureBoundingBox, 5, 7, 6, 6, 7, 8);
        this.a(par1World, par3StructureBoundingBox, 5, 1, 2, 6, 2, 2);
        this.a(par1World, par3StructureBoundingBox, 5, 2, 12, 6, 2, 12);
        this.a(par1World, par3StructureBoundingBox, 5, 5, 1, 6, 5, 1);
        this.a(par1World, par3StructureBoundingBox, 5, 5, 13, 6, 5, 13);
        this.a(par1World, 0, 0, 1, 5, 5, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 10, 5, 5, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 1, 5, 9, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 10, 5, 9, par3StructureBoundingBox);
        for (i1 = 0; i1 <= 14; i1 += 14) {
            this.a(par1World, par3StructureBoundingBox, 2, 4, i1, 2, 5, i1, false, par2Random, (aiu)n);
            this.a(par1World, par3StructureBoundingBox, 4, 4, i1, 4, 5, i1, false, par2Random, (aiu)n);
            this.a(par1World, par3StructureBoundingBox, 7, 4, i1, 7, 5, i1, false, par2Random, (aiu)n);
            this.a(par1World, par3StructureBoundingBox, 9, 4, i1, 9, 5, i1, false, par2Random, (aiu)n);
        }
        this.a(par1World, par3StructureBoundingBox, 5, 6, 0, 6, 6, 0, false, par2Random, (aiu)n);
        for (i1 = 0; i1 <= 11; i1 += 11) {
            for (int j1 = 2; j1 <= 12; j1 += 2) {
                this.a(par1World, par3StructureBoundingBox, i1, 4, j1, i1, 5, j1, false, par2Random, (aiu)n);
            }
            this.a(par1World, par3StructureBoundingBox, i1, 6, 5, i1, 6, 5, false, par2Random, (aiu)n);
            this.a(par1World, par3StructureBoundingBox, i1, 6, 9, i1, 6, 9, false, par2Random, (aiu)n);
        }
        this.a(par1World, par3StructureBoundingBox, 2, 7, 2, 2, 9, 2, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 9, 7, 2, 9, 9, 2, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 2, 7, 12, 2, 9, 12, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 9, 7, 12, 9, 9, 12, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 4, 9, 4, 4, 9, 4, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 7, 9, 4, 7, 9, 4, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 4, 9, 10, 4, 9, 10, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 7, 9, 10, 7, 9, 10, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 5, 9, 7, 6, 9, 7, false, par2Random, (aiu)n);
        this.a(par1World, aqz.aM.cF, i, 5, 9, 6, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 6, 9, 6, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, j2, 5, 9, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, j2, 6, 9, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 4, 0, 0, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 5, 0, 0, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 6, 0, 0, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 7, 0, 0, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 4, 1, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 4, 2, 9, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 4, 3, 10, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 7, 1, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 7, 2, 9, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, i, 7, 3, 10, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 4, 1, 9, 4, 1, 9, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 7, 1, 9, 7, 1, 9, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 4, 1, 10, 7, 2, 10, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 5, 4, 5, 6, 4, 5, false, par2Random, (aiu)n);
        this.a(par1World, aqz.aM.cF, k, 4, 4, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.aM.cF, l, 7, 4, 5, par3StructureBoundingBox);
        for (i1 = 0; i1 < 4; ++i1) {
            this.a(par1World, aqz.aM.cF, j2, 5, 0 - i1, 6 + i1, par3StructureBoundingBox);
            this.a(par1World, aqz.aM.cF, j2, 6, 0 - i1, 6 + i1, par3StructureBoundingBox);
            this.a(par1World, par3StructureBoundingBox, 5, 0 - i1, 7 + i1, 6, 0 - i1, 9 + i1);
        }
        this.a(par1World, par3StructureBoundingBox, 1, -3, 12, 10, -1, 13);
        this.a(par1World, par3StructureBoundingBox, 1, -3, 1, 3, -1, 13);
        this.a(par1World, par3StructureBoundingBox, 1, -3, 1, 9, -1, 5);
        for (i1 = 1; i1 <= 13; i1 += 2) {
            this.a(par1World, par3StructureBoundingBox, 1, -3, i1, 1, -2, i1, false, par2Random, (aiu)n);
        }
        for (i1 = 2; i1 <= 12; i1 += 2) {
            this.a(par1World, par3StructureBoundingBox, 1, -1, i1, 3, -1, i1, false, par2Random, (aiu)n);
        }
        this.a(par1World, par3StructureBoundingBox, 2, -2, 1, 5, -2, 1, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 7, -2, 1, 9, -2, 1, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 6, -3, 1, 6, -3, 1, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 6, -1, 1, 6, -1, 1, false, par2Random, (aiu)n);
        this.a(par1World, aqz.bY.cF, this.c(aqz.bY.cF, 3) | 4, 1, -3, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.bY.cF, this.c(aqz.bY.cF, 1) | 4, 4, -3, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.bZ.cF, 4, 2, -3, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.bZ.cF, 4, 3, -3, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 5, -3, 7, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 5, -3, 6, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 5, -3, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 5, -3, 4, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 5, -3, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 5, -3, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 5, -3, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 4, -3, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.at.cF, 0, 3, -3, 1, par3StructureBoundingBox);
        ChestGenHooks dispenser = ChestGenHooks.getInfo((String)"pyramidJungleDispenser");
        ChestGenHooks chest = ChestGenHooks.getInfo((String)"pyramidJungleChest");
        if (!this.j) {
            this.j = this.a(par1World, par3StructureBoundingBox, par2Random, 3, -2, 1, 2, dispenser.getItems(par2Random), dispenser.getCount(par2Random));
        }
        this.a(par1World, aqz.bz.cF, 15, 3, -2, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.bY.cF, this.c(aqz.bY.cF, 2) | 4, 7, -3, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.bY.cF, this.c(aqz.bY.cF, 0) | 4, 7, -3, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.bZ.cF, 4, 7, -3, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.bZ.cF, 4, 7, -3, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.bZ.cF, 4, 7, -3, 4, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 8, -3, 6, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 9, -3, 6, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 9, -3, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.at.cF, 0, 9, -3, 4, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 9, -2, 4, par3StructureBoundingBox);
        if (!this.k) {
            this.k = this.a(par1World, par3StructureBoundingBox, par2Random, 9, -2, 3, 4, dispenser.getItems(par2Random), dispenser.getCount(par2Random));
        }
        this.a(par1World, aqz.bz.cF, 15, 8, -1, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.bz.cF, 15, 8, -2, 3, par3StructureBoundingBox);
        if (!this.e) {
            this.e = this.a(par1World, par3StructureBoundingBox, par2Random, 8, -3, 3, chest.getItems(par2Random), chest.getCount(par2Random));
        }
        this.a(par1World, aqz.at.cF, 0, 9, -3, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.at.cF, 0, 8, -3, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.at.cF, 0, 4, -3, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.at.cF, 0, 5, -2, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.at.cF, 0, 5, -1, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.at.cF, 0, 6, -3, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.at.cF, 0, 7, -2, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.at.cF, 0, 7, -1, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.at.cF, 0, 8, -3, 5, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 9, -1, 1, 9, -1, 5, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 8, -3, 8, 10, -1, 10);
        this.a(par1World, aqz.br.cF, 3, 8, -2, 11, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 3, 9, -2, 11, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 3, 10, -2, 11, par3StructureBoundingBox);
        this.a(par1World, aqz.aO.cF, apb.d(this.c(aqz.aO.cF, 2)), 8, -2, 12, par3StructureBoundingBox);
        this.a(par1World, aqz.aO.cF, apb.d(this.c(aqz.aO.cF, 2)), 9, -2, 12, par3StructureBoundingBox);
        this.a(par1World, aqz.aO.cF, apb.d(this.c(aqz.aO.cF, 2)), 10, -2, 12, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 8, -3, 8, 8, -3, 10, false, par2Random, (aiu)n);
        this.a(par1World, par3StructureBoundingBox, 10, -3, 8, 10, -3, 10, false, par2Random, (aiu)n);
        this.a(par1World, aqz.at.cF, 0, 10, -2, 9, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 8, -2, 9, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 8, -2, 10, par3StructureBoundingBox);
        this.a(par1World, aqz.aA.cF, 0, 10, -1, 9, par3StructureBoundingBox);
        this.a(par1World, aqz.aa.cF, 1, 9, -2, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.aa.cF, this.c(aqz.aa.cF, 4), 10, -2, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.aa.cF, this.c(aqz.aa.cF, 4), 10, -1, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.bm.cF, this.c(aqz.bm.cF, 2), 10, -2, 10, par3StructureBoundingBox);
        if (!this.i) {
            this.i = this.a(par1World, par3StructureBoundingBox, par2Random, 9, -3, 10, chest.getItems(par2Random), chest.getCount(par2Random));
        }
        return true;
    }
}

