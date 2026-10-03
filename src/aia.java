/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ail
 *  ait
 *  aiu
 *  net.minecraftforge.common.ChestGenHooks
 */
import java.util.List;
import java.util.Random;
import net.minecraftforge.common.ChestGenHooks;

public class aia
extends ail {
    public static final mk[] a = new mk[]{new mk(yc.aN.cv, 0, 1, 3, 20), new mk(yc.aM.cv, 0, 2, 7, 20), new mk(yc.bQ.cv, 0, 1, 1, 1), new mk(yc.aS.cv, 0, 1, 1, 1)};
    private boolean b;

    public aia() {
    }

    public aia(int par1, Random par2Random, agf par3StructureBoundingBox, int par4) {
        super(par1);
        this.g = par4;
        this.d = this.a(par2Random);
        this.f = par3StructureBoundingBox;
        this.b = par3StructureBoundingBox.c() > 6;
    }

    protected void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        par1NBTTagCompound.a("Tall", this.b);
    }

    protected void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        this.b = par1NBTTagCompound.n("Tall");
    }

    public static aia a(List par0List, Random par1Random, int par2, int par3, int par4, int par5, int par6) {
        agf structureboundingbox = agf.a(par2, par3, par4, -4, -1, 0, 14, 11, 15, par5);
        if (!(aia.a((agf)structureboundingbox) && ait.a((List)par0List, (agf)structureboundingbox) == null || aia.a((agf)(structureboundingbox = agf.a(par2, par3, par4, -4, -1, 0, 14, 6, 15, par5))) && ait.a((List)par0List, (agf)structureboundingbox) == null)) {
            return null;
        }
        return new aia(par6, par1Random, structureboundingbox, par5);
    }

    public boolean a(abw par1World, Random par2Random, agf par3StructureBoundingBox) {
        int i;
        if (this.a(par1World, par3StructureBoundingBox)) {
            return false;
        }
        int b0 = 11;
        if (!this.b) {
            b0 = 6;
        }
        this.a(par1World, par3StructureBoundingBox, 0, 0, 0, 13, b0 - 1, 14, true, par2Random, (aiu)ahs.c());
        this.a(par1World, par2Random, par3StructureBoundingBox, this.d, 4, 1, 0);
        this.a(par1World, par3StructureBoundingBox, par2Random, 0.07f, 2, 1, 1, 11, 4, 13, aqz.ab.cF, aqz.ab.cF, false);
        boolean flag = true;
        boolean flag1 = true;
        for (i = 1; i <= 13; ++i) {
            if ((i - 1) % 4 == 0) {
                this.a(par1World, par3StructureBoundingBox, 1, 1, i, 1, 4, i, aqz.C.cF, aqz.C.cF, false);
                this.a(par1World, par3StructureBoundingBox, 12, 1, i, 12, 4, i, aqz.C.cF, aqz.C.cF, false);
                this.a(par1World, aqz.av.cF, 0, 2, 3, i, par3StructureBoundingBox);
                this.a(par1World, aqz.av.cF, 0, 11, 3, i, par3StructureBoundingBox);
                if (!this.b) continue;
                this.a(par1World, par3StructureBoundingBox, 1, 6, i, 1, 9, i, aqz.C.cF, aqz.C.cF, false);
                this.a(par1World, par3StructureBoundingBox, 12, 6, i, 12, 9, i, aqz.C.cF, aqz.C.cF, false);
                continue;
            }
            this.a(par1World, par3StructureBoundingBox, 1, 1, i, 1, 4, i, aqz.as.cF, aqz.as.cF, false);
            this.a(par1World, par3StructureBoundingBox, 12, 1, i, 12, 4, i, aqz.as.cF, aqz.as.cF, false);
            if (!this.b) continue;
            this.a(par1World, par3StructureBoundingBox, 1, 6, i, 1, 9, i, aqz.as.cF, aqz.as.cF, false);
            this.a(par1World, par3StructureBoundingBox, 12, 6, i, 12, 9, i, aqz.as.cF, aqz.as.cF, false);
        }
        for (i = 3; i < 12; i += 2) {
            this.a(par1World, par3StructureBoundingBox, 3, 1, i, 4, 3, i, aqz.as.cF, aqz.as.cF, false);
            this.a(par1World, par3StructureBoundingBox, 6, 1, i, 7, 3, i, aqz.as.cF, aqz.as.cF, false);
            this.a(par1World, par3StructureBoundingBox, 9, 1, i, 10, 3, i, aqz.as.cF, aqz.as.cF, false);
        }
        if (this.b) {
            this.a(par1World, par3StructureBoundingBox, 1, 5, 1, 3, 5, 13, aqz.C.cF, aqz.C.cF, false);
            this.a(par1World, par3StructureBoundingBox, 10, 5, 1, 12, 5, 13, aqz.C.cF, aqz.C.cF, false);
            this.a(par1World, par3StructureBoundingBox, 4, 5, 1, 9, 5, 2, aqz.C.cF, aqz.C.cF, false);
            this.a(par1World, par3StructureBoundingBox, 4, 5, 12, 9, 5, 13, aqz.C.cF, aqz.C.cF, false);
            this.a(par1World, aqz.C.cF, 0, 9, 5, 11, par3StructureBoundingBox);
            this.a(par1World, aqz.C.cF, 0, 8, 5, 11, par3StructureBoundingBox);
            this.a(par1World, aqz.C.cF, 0, 9, 5, 10, par3StructureBoundingBox);
            this.a(par1World, par3StructureBoundingBox, 3, 6, 2, 3, 6, 12, aqz.be.cF, aqz.be.cF, false);
            this.a(par1World, par3StructureBoundingBox, 10, 6, 2, 10, 6, 10, aqz.be.cF, aqz.be.cF, false);
            this.a(par1World, par3StructureBoundingBox, 4, 6, 2, 9, 6, 2, aqz.be.cF, aqz.be.cF, false);
            this.a(par1World, par3StructureBoundingBox, 4, 6, 12, 8, 6, 12, aqz.be.cF, aqz.be.cF, false);
            this.a(par1World, aqz.be.cF, 0, 9, 6, 11, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, 8, 6, 11, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, 9, 6, 10, par3StructureBoundingBox);
            i = this.c(aqz.aK.cF, 3);
            this.a(par1World, aqz.aK.cF, i, 10, 1, 13, par3StructureBoundingBox);
            this.a(par1World, aqz.aK.cF, i, 10, 2, 13, par3StructureBoundingBox);
            this.a(par1World, aqz.aK.cF, i, 10, 3, 13, par3StructureBoundingBox);
            this.a(par1World, aqz.aK.cF, i, 10, 4, 13, par3StructureBoundingBox);
            this.a(par1World, aqz.aK.cF, i, 10, 5, 13, par3StructureBoundingBox);
            this.a(par1World, aqz.aK.cF, i, 10, 6, 13, par3StructureBoundingBox);
            this.a(par1World, aqz.aK.cF, i, 10, 7, 13, par3StructureBoundingBox);
            int b1 = 7;
            int b2 = 7;
            this.a(par1World, aqz.be.cF, 0, b1 - 1, 9, b2, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1, 9, b2, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1 - 1, 8, b2, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1, 8, b2, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1 - 1, 7, b2, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1, 7, b2, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1 - 2, 7, b2, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1 + 1, 7, b2, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1 - 1, 7, b2 - 1, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1 - 1, 7, b2 + 1, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1, 7, b2 - 1, par3StructureBoundingBox);
            this.a(par1World, aqz.be.cF, 0, b1, 7, b2 + 1, par3StructureBoundingBox);
            this.a(par1World, aqz.av.cF, 0, b1 - 2, 8, b2, par3StructureBoundingBox);
            this.a(par1World, aqz.av.cF, 0, b1 + 1, 8, b2, par3StructureBoundingBox);
            this.a(par1World, aqz.av.cF, 0, b1 - 1, 8, b2 - 1, par3StructureBoundingBox);
            this.a(par1World, aqz.av.cF, 0, b1 - 1, 8, b2 + 1, par3StructureBoundingBox);
            this.a(par1World, aqz.av.cF, 0, b1, 8, b2 - 1, par3StructureBoundingBox);
            this.a(par1World, aqz.av.cF, 0, b1, 8, b2 + 1, par3StructureBoundingBox);
        }
        ChestGenHooks info = ChestGenHooks.getInfo((String)"strongholdLibrary");
        this.a(par1World, par3StructureBoundingBox, par2Random, 3, 3, 5, info.getItems(par2Random), info.getCount(par2Random));
        if (this.b) {
            this.a(par1World, 0, 0, 12, 9, 1, par3StructureBoundingBox);
            this.a(par1World, par3StructureBoundingBox, par2Random, 12, 8, 1, info.getItems(par2Random), info.getCount(par2Random));
        }
        return true;
    }
}

