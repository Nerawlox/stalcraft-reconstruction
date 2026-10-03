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

public class ahw
extends ail {
    public static final mk[] a = new mk[]{new mk(yc.bp.cv, 0, 1, 1, 10), new mk(yc.p.cv, 0, 1, 3, 3), new mk(yc.q.cv, 0, 1, 5, 10), new mk(yc.r.cv, 0, 1, 3, 5), new mk(yc.aE.cv, 0, 4, 9, 5), new mk(yc.W.cv, 0, 1, 3, 15), new mk(yc.l.cv, 0, 1, 3, 15), new mk(yc.i.cv, 0, 1, 1, 5), new mk(yc.s.cv, 0, 1, 1, 5), new mk(yc.ag.cv, 0, 1, 1, 5), new mk(yc.af.cv, 0, 1, 1, 5), new mk(yc.ah.cv, 0, 1, 1, 5), new mk(yc.ai.cv, 0, 1, 1, 5), new mk(yc.av.cv, 0, 1, 1, 1), new mk(yc.aC.cv, 0, 1, 1, 1), new mk(yc.ce.cv, 0, 1, 1, 1), new mk(yc.cf.cv, 0, 1, 1, 1), new mk(yc.cg.cv, 0, 1, 1, 1)};
    private boolean b;

    public ahw() {
    }

    public ahw(int par1, Random par2Random, agf par3StructureBoundingBox, int par4) {
        super(par1);
        this.g = par4;
        this.d = this.a(par2Random);
        this.f = par3StructureBoundingBox;
    }

    protected void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        par1NBTTagCompound.a("Chest", this.b);
    }

    protected void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        this.b = par1NBTTagCompound.n("Chest");
    }

    public void a(ait par1StructureComponent, List par2List, Random par3Random) {
        this.a((aii)par1StructureComponent, par2List, par3Random, 1, 1);
    }

    public static ahw a(List par0List, Random par1Random, int par2, int par3, int par4, int par5, int par6) {
        agf structureboundingbox = agf.a(par2, par3, par4, -1, -1, 0, 5, 5, 7, par5);
        return ahw.a((agf)structureboundingbox) && ait.a((List)par0List, (agf)structureboundingbox) == null ? new ahw(par6, par1Random, structureboundingbox, par5) : null;
    }

    public boolean a(abw par1World, Random par2Random, agf par3StructureBoundingBox) {
        int i;
        if (this.a(par1World, par3StructureBoundingBox)) {
            return false;
        }
        this.a(par1World, par3StructureBoundingBox, 0, 0, 0, 4, 4, 6, true, par2Random, (aiu)ahs.c());
        this.a(par1World, par2Random, par3StructureBoundingBox, this.d, 1, 1, 0);
        this.a(par1World, par2Random, par3StructureBoundingBox, aim.a, 1, 1, 6);
        this.a(par1World, par3StructureBoundingBox, 3, 1, 2, 3, 1, 4, aqz.br.cF, aqz.br.cF, false);
        this.a(par1World, aqz.ap.cF, 5, 3, 1, 1, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 5, 3, 1, 5, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 5, 3, 2, 2, par3StructureBoundingBox);
        this.a(par1World, aqz.ap.cF, 5, 3, 2, 4, par3StructureBoundingBox);
        for (i = 2; i <= 4; ++i) {
            this.a(par1World, aqz.ap.cF, 5, 2, 1, i, par3StructureBoundingBox);
        }
        if (!this.b) {
            int k;
            i = this.a(2);
            int j2 = this.a(3, 3);
            if (par3StructureBoundingBox.b(j2, i, k = this.b(3, 3))) {
                this.b = true;
                this.a(par1World, par3StructureBoundingBox, par2Random, 3, 2, 3, ChestGenHooks.getItems((String)"strongholdCorridor", (Random)par2Random), ChestGenHooks.getCount((String)"strongholdCorridor", (Random)par2Random));
            }
        }
        return true;
    }
}

