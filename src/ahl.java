/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aho
 *  net.minecraftforge.common.ChestGenHooks
 *  r
 */
import java.util.Random;
import net.minecraftforge.common.ChestGenHooks;

public class ahl
extends aho {
    private boolean[] e = new boolean[4];
    public static final mk[] i = new mk[]{new mk(yc.p.cv, 0, 1, 3, 3), new mk(yc.q.cv, 0, 1, 5, 10), new mk(yc.r.cv, 0, 2, 7, 15), new mk(yc.bJ.cv, 0, 1, 3, 2), new mk(yc.aZ.cv, 0, 4, 6, 20), new mk(yc.bo.cv, 0, 3, 7, 16), new mk(yc.aC.cv, 0, 1, 1, 3), new mk(yc.ce.cv, 0, 1, 1, 1), new mk(yc.cf.cv, 0, 1, 1, 1), new mk(yc.cg.cv, 0, 1, 1, 1)};

    public ahl() {
    }

    public ahl(Random par1Random, int par2, int par3) {
        super(par1Random, par2, 64, par3, 21, 15, 21);
    }

    protected void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        par1NBTTagCompound.a("hasPlacedChest0", this.e[0]);
        par1NBTTagCompound.a("hasPlacedChest1", this.e[1]);
        par1NBTTagCompound.a("hasPlacedChest2", this.e[2]);
        par1NBTTagCompound.a("hasPlacedChest3", this.e[3]);
    }

    protected void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        this.e[0] = par1NBTTagCompound.n("hasPlacedChest0");
        this.e[1] = par1NBTTagCompound.n("hasPlacedChest1");
        this.e[2] = par1NBTTagCompound.n("hasPlacedChest2");
        this.e[3] = par1NBTTagCompound.n("hasPlacedChest3");
    }

    public boolean a(abw par1World, Random par2Random, agf par3StructureBoundingBox) {
        int i1;
        int j2;
        int i;
        this.a(par1World, par3StructureBoundingBox, 0, -4, 0, this.a - 1, 0, this.c - 1, aqz.V.cF, aqz.V.cF, false);
        for (i = 1; i <= 9; ++i) {
            this.a(par1World, par3StructureBoundingBox, i, i, i, this.a - 1 - i, i, this.c - 1 - i, aqz.V.cF, aqz.V.cF, false);
            this.a(par1World, par3StructureBoundingBox, i + 1, i, i + 1, this.a - 2 - i, i, this.c - 2 - i, 0, 0, false);
        }
        for (i = 0; i < this.a; ++i) {
            for (j2 = 0; j2 < this.c; ++j2) {
                this.b(par1World, aqz.V.cF, 0, i, -5, j2, par3StructureBoundingBox);
            }
        }
        i = this.c(aqz.bV.cF, 3);
        j2 = this.c(aqz.bV.cF, 2);
        int k = this.c(aqz.bV.cF, 0);
        int l = this.c(aqz.bV.cF, 1);
        int b0 = 1;
        int b1 = 11;
        this.a(par1World, par3StructureBoundingBox, 0, 0, 0, 4, 9, 4, aqz.V.cF, 0, false);
        this.a(par1World, par3StructureBoundingBox, 1, 10, 1, 3, 10, 3, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, aqz.bV.cF, i, 2, 10, 0, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, j2, 2, 10, 4, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, k, 0, 10, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, l, 4, 10, 2, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, this.a - 5, 0, 0, this.a - 1, 9, 4, aqz.V.cF, 0, false);
        this.a(par1World, par3StructureBoundingBox, this.a - 4, 10, 1, this.a - 2, 10, 3, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, aqz.bV.cF, i, this.a - 3, 10, 0, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, j2, this.a - 3, 10, 4, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, k, this.a - 5, 10, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, l, this.a - 1, 10, 2, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 8, 0, 0, 12, 4, 4, aqz.V.cF, 0, false);
        this.a(par1World, par3StructureBoundingBox, 9, 1, 0, 11, 3, 4, 0, 0, false);
        this.a(par1World, aqz.V.cF, 2, 9, 1, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 2, 9, 2, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 2, 9, 3, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 2, 10, 3, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 2, 11, 3, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 2, 11, 2, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 2, 11, 1, 1, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 4, 1, 1, 8, 3, 3, aqz.V.cF, 0, false);
        this.a(par1World, par3StructureBoundingBox, 4, 1, 2, 8, 2, 2, 0, 0, false);
        this.a(par1World, par3StructureBoundingBox, 12, 1, 1, 16, 3, 3, aqz.V.cF, 0, false);
        this.a(par1World, par3StructureBoundingBox, 12, 1, 2, 16, 2, 2, 0, 0, false);
        this.a(par1World, par3StructureBoundingBox, 5, 4, 5, this.a - 6, 4, this.c - 6, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, par3StructureBoundingBox, 9, 4, 9, 11, 4, 11, 0, 0, false);
        this.a(par1World, par3StructureBoundingBox, 8, 1, 8, 8, 3, 8, aqz.V.cF, 2, aqz.V.cF, 2, false);
        this.a(par1World, par3StructureBoundingBox, 12, 1, 8, 12, 3, 8, aqz.V.cF, 2, aqz.V.cF, 2, false);
        this.a(par1World, par3StructureBoundingBox, 8, 1, 12, 8, 3, 12, aqz.V.cF, 2, aqz.V.cF, 2, false);
        this.a(par1World, par3StructureBoundingBox, 12, 1, 12, 12, 3, 12, aqz.V.cF, 2, aqz.V.cF, 2, false);
        this.a(par1World, par3StructureBoundingBox, 1, 1, 5, 4, 4, 11, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, par3StructureBoundingBox, this.a - 5, 1, 5, this.a - 2, 4, 11, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, par3StructureBoundingBox, 6, 7, 9, 6, 7, 11, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, par3StructureBoundingBox, this.a - 7, 7, 9, this.a - 7, 7, 11, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, par3StructureBoundingBox, 5, 5, 9, 5, 7, 11, aqz.V.cF, 2, aqz.V.cF, 2, false);
        this.a(par1World, par3StructureBoundingBox, this.a - 6, 5, 9, this.a - 6, 7, 11, aqz.V.cF, 2, aqz.V.cF, 2, false);
        this.a(par1World, 0, 0, 5, 5, 10, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 5, 6, 10, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 6, 6, 10, par3StructureBoundingBox);
        this.a(par1World, 0, 0, this.a - 6, 5, 10, par3StructureBoundingBox);
        this.a(par1World, 0, 0, this.a - 6, 6, 10, par3StructureBoundingBox);
        this.a(par1World, 0, 0, this.a - 7, 6, 10, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 2, 4, 4, 2, 6, 4, 0, 0, false);
        this.a(par1World, par3StructureBoundingBox, this.a - 3, 4, 4, this.a - 3, 6, 4, 0, 0, false);
        this.a(par1World, aqz.bV.cF, i, 2, 4, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, i, 2, 3, 4, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, i, this.a - 3, 4, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, i, this.a - 3, 3, 4, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 1, 1, 3, 2, 2, 3, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, par3StructureBoundingBox, this.a - 3, 1, 3, this.a - 2, 2, 3, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, aqz.bV.cF, 0, 1, 1, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, 0, this.a - 2, 1, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 1, 1, 2, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 1, this.a - 2, 2, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, l, 2, 1, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.bV.cF, k, this.a - 3, 1, 2, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 4, 3, 5, 4, 3, 18, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, par3StructureBoundingBox, this.a - 5, 3, 5, this.a - 5, 3, 17, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, par3StructureBoundingBox, 3, 1, 5, 4, 2, 16, 0, 0, false);
        this.a(par1World, par3StructureBoundingBox, this.a - 6, 1, 5, this.a - 5, 2, 16, 0, 0, false);
        for (i1 = 5; i1 <= 17; i1 += 2) {
            this.a(par1World, aqz.V.cF, 2, 4, 1, i1, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 1, 4, 2, i1, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, this.a - 5, 1, i1, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 1, this.a - 5, 2, i1, par3StructureBoundingBox);
        }
        this.a(par1World, aqz.ag.cF, b0, 10, 0, 7, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 10, 0, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 9, 0, 9, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 11, 0, 9, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 8, 0, 10, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 12, 0, 10, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 7, 0, 10, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 13, 0, 10, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 9, 0, 11, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 11, 0, 11, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 10, 0, 12, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 10, 0, 13, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b1, 10, 0, 10, par3StructureBoundingBox);
        for (i1 = 0; i1 <= this.a - 1; i1 += this.a - 1) {
            this.a(par1World, aqz.V.cF, 2, i1, 2, 1, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 2, 2, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1, 2, 3, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1, 3, 1, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 3, 2, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1, 3, 3, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 4, 1, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 1, i1, 4, 2, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 4, 3, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1, 5, 1, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 5, 2, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1, 5, 3, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 6, 1, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 1, i1, 6, 2, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 6, 3, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 7, 1, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 7, 2, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 7, 3, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1, 8, 1, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1, 8, 2, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1, 8, 3, par3StructureBoundingBox);
        }
        for (i1 = 2; i1 <= this.a - 3; i1 += this.a - 3 - 2) {
            this.a(par1World, aqz.V.cF, 2, i1 - 1, 2, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 2, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1 + 1, 2, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1 - 1, 3, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 3, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1 + 1, 3, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1 - 1, 4, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 1, i1, 4, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1 + 1, 4, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1 - 1, 5, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 5, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1 + 1, 5, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1 - 1, 6, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 1, i1, 6, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1 + 1, 6, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1 - 1, 7, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1, 7, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.ag.cF, b0, i1 + 1, 7, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1 - 1, 8, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1, 8, 0, par3StructureBoundingBox);
            this.a(par1World, aqz.V.cF, 2, i1 + 1, 8, 0, par3StructureBoundingBox);
        }
        this.a(par1World, par3StructureBoundingBox, 8, 4, 0, 12, 6, 0, aqz.V.cF, 2, aqz.V.cF, 2, false);
        this.a(par1World, 0, 0, 8, 6, 0, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 12, 6, 0, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 9, 5, 0, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 1, 10, 5, 0, par3StructureBoundingBox);
        this.a(par1World, aqz.ag.cF, b0, 11, 5, 0, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 8, -14, 8, 12, -11, 12, aqz.V.cF, 2, aqz.V.cF, 2, false);
        this.a(par1World, par3StructureBoundingBox, 8, -10, 8, 12, -10, 12, aqz.V.cF, 1, aqz.V.cF, 1, false);
        this.a(par1World, par3StructureBoundingBox, 8, -9, 8, 12, -9, 12, aqz.V.cF, 2, aqz.V.cF, 2, false);
        this.a(par1World, par3StructureBoundingBox, 8, -8, 8, 12, -1, 12, aqz.V.cF, aqz.V.cF, false);
        this.a(par1World, par3StructureBoundingBox, 9, -11, 9, 11, -1, 11, 0, 0, false);
        this.a(par1World, aqz.aP.cF, 0, 10, -11, 10, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 9, -13, 9, 11, -13, 11, aqz.ar.cF, 0, false);
        this.a(par1World, 0, 0, 8, -11, 10, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 8, -10, 10, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 1, 7, -10, 10, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 2, 7, -11, 10, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 12, -11, 10, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 12, -10, 10, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 1, 13, -10, 10, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 2, 13, -11, 10, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 10, -11, 8, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 10, -10, 8, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 1, 10, -10, 7, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 2, 10, -11, 7, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 10, -11, 12, par3StructureBoundingBox);
        this.a(par1World, 0, 0, 10, -10, 12, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 1, 10, -10, 13, par3StructureBoundingBox);
        this.a(par1World, aqz.V.cF, 2, 10, -11, 13, par3StructureBoundingBox);
        ChestGenHooks info = ChestGenHooks.getInfo((String)"pyramidDesertyChest");
        for (i1 = 0; i1 < 4; ++i1) {
            if (this.e[i1]) continue;
            int j1 = r.a[i1] * 2;
            int k1 = r.b[i1] * 2;
            this.e[i1] = this.a(par1World, par3StructureBoundingBox, par2Random, 10 + j1, -11, 10 + k1, info.getItems(par2Random), info.getCount(par2Random));
        }
        return true;
    }
}

