/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ait
 *  cl
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public abstract class aiv {
    public LinkedList a = new LinkedList();
    protected agf b;
    private int c;
    private int d;

    public aiv() {
    }

    public aiv(int par1, int par2) {
        this.c = par1;
        this.d = par2;
    }

    public agf a() {
        return this.b;
    }

    public LinkedList b() {
        return this.a;
    }

    public void a(abw par1World, Random par2Random, agf par3StructureBoundingBox) {
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ait structurecomponent = (ait)iterator.next();
            if (!structurecomponent.c().a(par3StructureBoundingBox) || structurecomponent.a(par1World, par2Random, par3StructureBoundingBox)) continue;
            iterator.remove();
        }
    }

    protected void c() {
        this.b = agf.a();
        for (ait structurecomponent : this.a) {
            this.b.b(structurecomponent.c());
        }
    }

    public by a(int par1, int par2) {
        if (air.a(this) == null) {
            throw new RuntimeException("StructureStart \"" + this.getClass().getName() + "\" missing ID Mapping, Modder see MapGenStructureIO");
        }
        by nbttagcompound = new by();
        nbttagcompound.a("id", air.a(this));
        nbttagcompound.a("ChunkX", par1);
        nbttagcompound.a("ChunkZ", par2);
        nbttagcompound.a("BB", (cl)this.b.a("BB"));
        cg nbttaglist = new cg("Children");
        for (ait structurecomponent : this.a) {
            nbttaglist.a(structurecomponent.b());
        }
        nbttagcompound.a("Children", nbttaglist);
        this.a(nbttagcompound);
        return nbttagcompound;
    }

    public void a(by par1NBTTagCompound) {
    }

    public void a(abw par1World, by par2NBTTagCompound) {
        this.c = par2NBTTagCompound.e("ChunkX");
        this.d = par2NBTTagCompound.e("ChunkZ");
        if (par2NBTTagCompound.b("BB")) {
            this.b = new agf(par2NBTTagCompound.k("BB"));
        }
        cg nbttaglist = par2NBTTagCompound.m("Children");
        for (int i = 0; i < nbttaglist.c(); ++i) {
            this.a.add(air.b((by)nbttaglist.b(i), par1World));
        }
        this.b(par2NBTTagCompound);
    }

    public void b(by par1NBTTagCompound) {
    }

    protected void a(abw par1World, Random par2Random, int par3) {
        int j2 = 63 - par3;
        int k = this.b.c() + 1;
        if (k < j2) {
            k += par2Random.nextInt(j2 - k);
        }
        int l = k - this.b.e;
        this.b.a(0, l, 0);
        for (ait structurecomponent : this.a) {
            structurecomponent.c().a(0, l, 0);
        }
    }

    protected void a(abw par1World, Random par2Random, int par3, int par4) {
        int k = par4 - par3 + 1 - this.b.c();
        boolean flag = true;
        int l = k > 1 ? par3 + par2Random.nextInt(k) : par3;
        int i1 = l - this.b.b;
        this.b.a(0, i1, 0);
        for (ait structurecomponent : this.a) {
            structurecomponent.c().a(0, i1, 0);
        }
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.d;
    }
}

