/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ait
 *  ajj
 *  ajm
 *  net.minecraftforge.common.ChestGenHooks
 */
import java.util.List;
import java.util.Random;
import net.minecraftforge.common.ChestGenHooks;

public class aji
extends ajm {
    public static final mk[] a = new mk[]{new mk(yc.p.cv, 0, 1, 3, 3), new mk(yc.q.cv, 0, 1, 5, 10), new mk(yc.r.cv, 0, 1, 3, 5), new mk(yc.W.cv, 0, 1, 3, 15), new mk(yc.l.cv, 0, 1, 3, 15), new mk(yc.i.cv, 0, 1, 1, 5), new mk(yc.s.cv, 0, 1, 1, 5), new mk(yc.ag.cv, 0, 1, 1, 5), new mk(yc.af.cv, 0, 1, 1, 5), new mk(yc.ah.cv, 0, 1, 1, 5), new mk(yc.ai.cv, 0, 1, 1, 5), new mk(aqz.au.cF, 0, 3, 7, 5), new mk(aqz.D.cF, 0, 3, 7, 5), new mk(yc.aC.cv, 0, 1, 1, 3), new mk(yc.ce.cv, 0, 1, 1, 1), new mk(yc.cf.cv, 0, 1, 1, 1), new mk(yc.cg.cv, 0, 1, 1, 1)};
    private boolean b;

    public aji() {
    }

    public aji(ajj par1ComponentVillageStartPiece, int par2, Random par3Random, agf par4StructureBoundingBox, int par5) {
        super(par1ComponentVillageStartPiece, par2);
        this.g = par5;
        this.f = par4StructureBoundingBox;
    }

    public static aji a(ajj par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
        agf structureboundingbox = agf.a(par3, par4, par5, 0, 0, 0, 10, 6, 7, par6);
        return aji.a((agf)structureboundingbox) && ait.a((List)par1List, (agf)structureboundingbox) == null ? new aji(par0ComponentVillageStartPiece, par7, par2Random, structureboundingbox, par6) : null;
    }

    protected void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        par1NBTTagCompound.a("Chest", this.b);
    }

    protected void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        this.b = par1NBTTagCompound.n("Chest");
    }

    public boolean a(abw par1World, Random par2Random, agf par3StructureBoundingBox) {
        int j2;
        int i;
        if (this.k < 0) {
            this.k = this.b(par1World, par3StructureBoundingBox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 6 - 1, 0);
        }
        this.a(par1World, par3StructureBoundingBox, 0, 1, 0, 9, 4, 6, 0, 0, false);
        this.a(par1World, par3StructureBoundingBox, 0, 0, 0, 9, 0, 6, aqz.B.cF, aqz.B.cF, false);
        this.a(par1World, par3StructureBoundingBox, 0, 4, 0, 9, 4, 6, aqz.B.cF, aqz.B.cF, false);
        this.a(par1World, par3StructureBoundingBox, 0, 5, 0, 9, 5, 6, aqz.ap.cF, aqz.ap.cF, false);
        this.a(par1World, par3StructureBoundingBox, 1, 5, 1, 8, 5, 5, 0, 0, false);
        this.a(par1World, par3StructureBoundingBox, 1, 1, 0, 2, 3, 0, aqz.C.cF, aqz.C.cF, false);
        this.a(par1World, par3StructureBoundingBox, 0, 1, 0, 0, 4, 0, aqz.O.cF, aqz.O.cF, false);
        this.a(par1World, par3StructureBoundingBox, 3, 1, 0, 3, 4, 0, aqz.O.cF, aqz.O.cF, false);
        this.a(par1World, par3StructureBoundingBox, 0, 1, 6, 0, 4, 6, aqz.O.cF, aqz.O.cF, false);
        this.a(par1World, aqz.C.cF, 0, 3, 3, 1, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 3, 1, 2, 3, 3, 2, aqz.C.cF, aqz.C.cF, false);
        this.a(par1World, par3StructureBoundingBox, 4, 1, 3, 5, 3, 3, aqz.C.cF, aqz.C.cF, false);
        this.a(par1World, par3StructureBoundingBox, 0, 1, 1, 0, 3, 5, aqz.C.cF, aqz.C.cF, false);
        this.a(par1World, par3StructureBoundingBox, 1, 1, 6, 5, 3, 6, aqz.C.cF, aqz.C.cF, false);
        this.a(par1World, par3StructureBoundingBox, 5, 1, 0, 5, 3, 0, aqz.be.cF, aqz.be.cF, false);
        this.a(par1World, par3StructureBoundingBox, 9, 1, 0, 9, 3, 0, aqz.be.cF, aqz.be.cF, false);
        this.a(par1World, par3StructureBoundingBox, 6, 1, 4, 9, 4, 6, aqz.B.cF, aqz.B.cF, false);
        this.a(par1World, aqz.H.cF, 0, 7, 1, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.H.cF, 0, 8, 1, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.bu.cF, 0, 9, 2, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.bu.cF, 0, 9, 2, 4, par3StructureBoundingBox);
        this.a(par1World, par3StructureBoundingBox, 7, 2, 4, 8, 2, 5, 0, 0, false);
        this.a(par1World, aqz.B.cF, 0, 6, 1, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.aG.cF, 0, 6, 2, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.aG.cF, 0, 6, 3, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.ao.cF, 0, 8, 1, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.bv.cF, 0, 0, 2, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.bv.cF, 0, 0, 2, 4, par3StructureBoundingBox);
        this.a(par1World, aqz.bv.cF, 0, 2, 2, 6, par3StructureBoundingBox);
        this.a(par1World, aqz.bv.cF, 0, 4, 2, 6, par3StructureBoundingBox);
        this.a(par1World, aqz.be.cF, 0, 2, 1, 4, par3StructureBoundingBox);
        this.a(par1World, aqz.aR.cF, 0, 2, 2, 4, par3StructureBoundingBox);
        this.a(par1World, aqz.C.cF, 0, 1, 1, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.ay.cF, this.c(aqz.ay.cF, 3), 2, 1, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.ay.cF, this.c(aqz.ay.cF, 1), 1, 1, 4, par3StructureBoundingBox);
        if (!this.b) {
            int k;
            i = this.a(1);
            j2 = this.a(5, 5);
            if (par3StructureBoundingBox.b(j2, i, k = this.b(5, 5))) {
                this.b = true;
                this.a(par1World, par3StructureBoundingBox, par2Random, 5, 1, 5, ChestGenHooks.getItems((String)"villageBlacksmith", (Random)par2Random), ChestGenHooks.getCount((String)"villageBlacksmith", (Random)par2Random));
            }
        }
        for (i = 6; i <= 8; ++i) {
            if (this.a(par1World, i, 0, -1, par3StructureBoundingBox) != 0 || this.a(par1World, i, -1, -1, par3StructureBoundingBox) == 0) continue;
            this.a(par1World, aqz.aM.cF, this.c(aqz.aM.cF, 3), i, 0, -1, par3StructureBoundingBox);
        }
        for (i = 0; i < 7; ++i) {
            for (j2 = 0; j2 < 10; ++j2) {
                this.b(par1World, j2, 6, i, par3StructureBoundingBox);
                this.b(par1World, aqz.B.cF, 0, j2, -1, i, par3StructureBoundingBox);
            }
        }
        this.a(par1World, par3StructureBoundingBox, 7, 1, 1, 1);
        return true;
    }

    protected int b(int par1) {
        return 3;
    }
}

