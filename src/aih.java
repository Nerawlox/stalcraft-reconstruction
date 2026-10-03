/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ahy
 *  aii
 *  ail
 *  ait
 *  aiu
 */
import java.util.List;
import java.util.Random;

public class aih
extends ail {
    private boolean a;

    public aih() {
    }

    public aih(int par1, Random par2Random, int par3, int par4) {
        super(par1);
        this.a = true;
        this.g = par2Random.nextInt(4);
        this.d = aim.a;
        switch (this.g) {
            case 0: 
            case 2: {
                this.f = new agf(par3, 64, par4, par3 + 5 - 1, 74, par4 + 5 - 1);
                break;
            }
            default: {
                this.f = new agf(par3, 64, par4, par3 + 5 - 1, 74, par4 + 5 - 1);
            }
        }
    }

    public aih(int par1, Random par2Random, agf par3StructureBoundingBox, int par4) {
        super(par1);
        this.a = false;
        this.g = par4;
        this.d = this.a(par2Random);
        this.f = par3StructureBoundingBox;
    }

    protected void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        par1NBTTagCompound.a("Source", this.a);
    }

    protected void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        this.a = par1NBTTagCompound.n("Source");
    }

    public void a(ait par1StructureComponent, List par2List, Random par3Random) {
        if (this.a) {
            ahs.a(ahy.class);
        }
        this.a((aii)par1StructureComponent, par2List, par3Random, 1, 1);
    }

    public static aih a(List par0List, Random par1Random, int par2, int par3, int par4, int par5, int par6) {
        agf structureboundingbox = agf.a(par2, par3, par4, -1, -7, 0, 5, 11, 5, par5);
        return aih.a((agf)structureboundingbox) && ait.a((List)par0List, (agf)structureboundingbox) == null ? new aih(par6, par1Random, structureboundingbox, par5) : null;
    }

    public boolean a(abw par1World, Random par2Random, agf par3StructureBoundingBox) {
        if (this.a(par1World, par3StructureBoundingBox)) {
            return false;
        }
        this.a(par1World, par3StructureBoundingBox, 0, 0, 0, 4, 10, 4, true, par2Random, (aiu)ahs.c());
        this.a(par1World, par2Random, par3StructureBoundingBox, this.d, 1, 7, 0);
        this.a(par1World, par2Random, par3StructureBoundingBox, aim.a, 1, 1, 4);
        this.a(par1World, aqz.br.cF, 0, 2, 6, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 0, 1, 5, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 0, 1, 6, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 0, 1, 5, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 0, 1, 4, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 0, 1, 5, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 0, 2, 4, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 0, 3, 3, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 0, 3, 4, 3, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 0, 3, 3, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 0, 3, 2, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 0, 3, 3, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 0, 2, 2, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 0, 1, 1, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 0, 1, 2, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.br.cF, 0, 1, 1, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 0, 1, 1, 3, par3StructureBoundingBox);
        return true;
    }
}

