/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aii
 *  ail
 *  ait
 *  aiu
 *  net.minecraftforge.common.ChestGenHooks
 */
import java.util.List;
import java.util.Random;
import net.minecraftforge.common.ChestGenHooks;

public class aif
extends ail {
    public static final mk[] b = new mk[]{new mk(yc.q.cv, 0, 1, 5, 10), new mk(yc.r.cv, 0, 1, 3, 5), new mk(yc.aE.cv, 0, 4, 9, 5), new mk(yc.o.cv, 0, 3, 8, 10), new mk(yc.W.cv, 0, 1, 3, 15), new mk(yc.l.cv, 0, 1, 3, 15), new mk(yc.i.cv, 0, 1, 1, 1)};
    protected int a;

    public aif() {
    }

    public aif(int par1, Random par2Random, agf par3StructureBoundingBox, int par4) {
        super(par1);
        this.g = par4;
        this.d = this.a(par2Random);
        this.f = par3StructureBoundingBox;
        this.a = par2Random.nextInt(5);
    }

    protected void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        par1NBTTagCompound.a("Type", this.a);
    }

    protected void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        this.a = par1NBTTagCompound.e("Type");
    }

    public void a(ait par1StructureComponent, List par2List, Random par3Random) {
        this.a((aii)par1StructureComponent, par2List, par3Random, 4, 1);
        this.b((aii)par1StructureComponent, par2List, par3Random, 1, 4);
        this.c((aii)par1StructureComponent, par2List, par3Random, 1, 4);
    }

    public static aif a(List par0List, Random par1Random, int par2, int par3, int par4, int par5, int par6) {
        agf structureboundingbox = agf.a(par2, par3, par4, -4, -1, 0, 11, 7, 11, par5);
        return aif.a((agf)structureboundingbox) && ait.a((List)par0List, (agf)structureboundingbox) == null ? new aif(par6, par1Random, structureboundingbox, par5) : null;
    }

    public boolean a(abw par1World, Random par2Random, agf par3StructureBoundingBox) {
        if (this.a(par1World, par3StructureBoundingBox)) {
            return false;
        }
        this.a(par1World, par3StructureBoundingBox, 0, 0, 0, 10, 6, 10, true, par2Random, (aiu)ahs.c());
        this.a(par1World, par2Random, par3StructureBoundingBox, this.d, 4, 1, 0);
        this.a(par1World, par3StructureBoundingBox, 4, 1, 10, 6, 3, 10, 0, 0, false);
        this.a(par1World, par3StructureBoundingBox, 0, 1, 4, 0, 3, 6, 0, 0, false);
        this.a(par1World, par3StructureBoundingBox, 10, 1, 4, 10, 3, 6, 0, 0, false);
        switch (this.a) {
            case 0: {
                this.a(par1World, aqz.br.cF, 0, 5, 1, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.br.cF, 0, 5, 2, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.br.cF, 0, 5, 3, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.av.cF, 0, 4, 3, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.av.cF, 0, 6, 3, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.av.cF, 0, 5, 3, 4, par3StructureBoundingBox);
                this.a(par1World, aqz.av.cF, 0, 5, 3, 6, par3StructureBoundingBox);
                this.a(par1World, aqz.ap.cF, 0, 4, 1, 4, par3StructureBoundingBox);
                this.a(par1World, aqz.ap.cF, 0, 4, 1, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.ap.cF, 0, 4, 1, 6, par3StructureBoundingBox);
                this.a(par1World, aqz.ap.cF, 0, 6, 1, 4, par3StructureBoundingBox);
                this.a(par1World, aqz.ap.cF, 0, 6, 1, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.ap.cF, 0, 6, 1, 6, par3StructureBoundingBox);
                this.a(par1World, aqz.ap.cF, 0, 5, 1, 4, par3StructureBoundingBox);
                this.a(par1World, aqz.ap.cF, 0, 5, 1, 6, par3StructureBoundingBox);
                break;
            }
            case 1: {
                for (int i = 0; i < 5; ++i) {
                    this.a(par1World, aqz.br.cF, 0, 3, 1, 3 + i, par3StructureBoundingBox);
                    this.a(par1World, aqz.br.cF, 0, 7, 1, 3 + i, par3StructureBoundingBox);
                    this.a(par1World, aqz.br.cF, 0, 3 + i, 1, 3, par3StructureBoundingBox);
                    this.a(par1World, aqz.br.cF, 0, 3 + i, 1, 7, par3StructureBoundingBox);
                }
                this.a(par1World, aqz.br.cF, 0, 5, 1, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.br.cF, 0, 5, 2, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.br.cF, 0, 5, 3, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.F.cF, 0, 5, 4, 5, par3StructureBoundingBox);
                break;
            }
            case 2: {
                int i;
                for (i = 1; i <= 9; ++i) {
                    this.a(par1World, aqz.B.cF, 0, 1, 3, i, par3StructureBoundingBox);
                    this.a(par1World, aqz.B.cF, 0, 9, 3, i, par3StructureBoundingBox);
                }
                for (i = 1; i <= 9; ++i) {
                    this.a(par1World, aqz.B.cF, 0, i, 3, 1, par3StructureBoundingBox);
                    this.a(par1World, aqz.B.cF, 0, i, 3, 9, par3StructureBoundingBox);
                }
                this.a(par1World, aqz.B.cF, 0, 5, 1, 4, par3StructureBoundingBox);
                this.a(par1World, aqz.B.cF, 0, 5, 1, 6, par3StructureBoundingBox);
                this.a(par1World, aqz.B.cF, 0, 5, 3, 4, par3StructureBoundingBox);
                this.a(par1World, aqz.B.cF, 0, 5, 3, 6, par3StructureBoundingBox);
                this.a(par1World, aqz.B.cF, 0, 4, 1, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.B.cF, 0, 6, 1, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.B.cF, 0, 4, 3, 5, par3StructureBoundingBox);
                this.a(par1World, aqz.B.cF, 0, 6, 3, 5, par3StructureBoundingBox);
                for (i = 1; i <= 3; ++i) {
                    this.a(par1World, aqz.B.cF, 0, 4, i, 4, par3StructureBoundingBox);
                    this.a(par1World, aqz.B.cF, 0, 6, i, 4, par3StructureBoundingBox);
                    this.a(par1World, aqz.B.cF, 0, 4, i, 6, par3StructureBoundingBox);
                    this.a(par1World, aqz.B.cF, 0, 6, i, 6, par3StructureBoundingBox);
                }
                this.a(par1World, aqz.av.cF, 0, 5, 3, 5, par3StructureBoundingBox);
                for (i = 2; i <= 8; ++i) {
                    this.a(par1World, aqz.C.cF, 0, 2, 3, i, par3StructureBoundingBox);
                    this.a(par1World, aqz.C.cF, 0, 3, 3, i, par3StructureBoundingBox);
                    if (i <= 3 || i >= 7) {
                        this.a(par1World, aqz.C.cF, 0, 4, 3, i, par3StructureBoundingBox);
                        this.a(par1World, aqz.C.cF, 0, 5, 3, i, par3StructureBoundingBox);
                        this.a(par1World, aqz.C.cF, 0, 6, 3, i, par3StructureBoundingBox);
                    }
                    this.a(par1World, aqz.C.cF, 0, 7, 3, i, par3StructureBoundingBox);
                    this.a(par1World, aqz.C.cF, 0, 8, 3, i, par3StructureBoundingBox);
                }
                this.a(par1World, aqz.aK.cF, this.c(aqz.aK.cF, 4), 9, 1, 3, par3StructureBoundingBox);
                this.a(par1World, aqz.aK.cF, this.c(aqz.aK.cF, 4), 9, 2, 3, par3StructureBoundingBox);
                this.a(par1World, aqz.aK.cF, this.c(aqz.aK.cF, 4), 9, 3, 3, par3StructureBoundingBox);
                this.a(par1World, par3StructureBoundingBox, par2Random, 3, 4, 8, ChestGenHooks.getItems((String)"strongholdCrossing", (Random)par2Random), ChestGenHooks.getCount((String)"strongholdCrossing", (Random)par2Random));
            }
        }
        return true;
    }
}

