/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abp
 *  aco
 *  aer
 *  aio
 *  aip
 *  aiq
 *  ais
 *  ait
 *  all
 *  cl
 *  u
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public abstract class ain
extends aer {
    private ais e;
    protected Map d = new HashMap();

    public abstract String a();

    protected final void a(abw par1World, int par2, int par3, int par4, int par5, byte[] par6ArrayOfByte) {
        this.a(par1World);
        if (!this.d.containsKey(abp.a((int)par2, (int)par3))) {
            this.b.nextInt();
            try {
                if (this.a(par2, par3)) {
                    aiv structurestart = this.b(par2, par3);
                    this.d.put(abp.a((int)par2, (int)par3), structurestart);
                    this.a(par2, par3, structurestart);
                }
            }
            catch (Throwable throwable) {
                b crashreport = b.a(throwable, "Exception preparing structure feature");
                m crashreportcategory = crashreport.a("Feature being prepared");
                crashreportcategory.a("Is feature chunk", (Callable)new aio(this, par2, par3));
                crashreportcategory.a("Chunk location", String.format("%d,%d", par2, par3));
                crashreportcategory.a("Chunk pos hash", (Callable)new aip(this, par2, par3));
                crashreportcategory.a("Structure type", (Callable)new aiq(this));
                throw new u(crashreport);
            }
        }
    }

    public boolean a(abw par1World, Random par2Random, int par3, int par4) {
        this.a(par1World);
        int k = (par3 << 4) + 8;
        int l = (par4 << 4) + 8;
        boolean flag = false;
        for (aiv structurestart : this.d.values()) {
            if (!structurestart.d() || !structurestart.a().a(k, l, k + 15, l + 15)) continue;
            structurestart.a(par1World, par2Random, new agf(k, l, k + 15, l + 15));
            flag = true;
            this.a(structurestart.e(), structurestart.f(), structurestart);
        }
        return flag;
    }

    public boolean b(int par1, int par2, int par3) {
        this.a(this.c);
        return this.c(par1, par2, par3) != null;
    }

    protected aiv c(int par1, int par2, int par3) {
        for (aiv structurestart : this.d.values()) {
            if (!structurestart.d() || !structurestart.a().a(par1, par3, par1, par3)) continue;
            for (ait structurecomponent : structurestart.b()) {
                if (!structurecomponent.c().b(par1, par2, par3)) continue;
                return structurestart;
            }
        }
        return null;
    }

    public boolean d(int par1, int par2, int par3) {
        aiv structurestart;
        this.a(this.c);
        Iterator iterator = this.d.values().iterator();
        do {
            if (iterator.hasNext()) continue;
            return false;
        } while (!(structurestart = (aiv)iterator.next()).d());
        return structurestart.a().a(par1, par3, par1, par3);
    }

    public aco a(abw par1World, int par2, int par3, int par4) {
        double d1;
        int j2;
        int l1;
        int i2;
        this.c = par1World;
        this.a(par1World);
        this.b.setSeed(par1World.H());
        long l = this.b.nextLong();
        long i1 = this.b.nextLong();
        long j1 = (long)(par2 >> 4) * l;
        long k1 = (long)(par4 >> 4) * i1;
        this.b.setSeed(j1 ^ k1 ^ par1World.H());
        this.a(par1World, par2 >> 4, par4 >> 4, 0, 0, null);
        double d0 = Double.MAX_VALUE;
        aco chunkposition = null;
        for (aiv structurestart : this.d.values()) {
            if (!structurestart.d()) continue;
            ait structurecomponent = (ait)structurestart.b().get(0);
            aco chunkposition1 = structurecomponent.a();
            i2 = chunkposition1.a - par2;
            l1 = chunkposition1.b - par3;
            j2 = chunkposition1.c - par4;
            d1 = i2 * i2 + l1 * l1 + j2 * j2;
            if (!(d1 < d0)) continue;
            d0 = d1;
            chunkposition = chunkposition1;
        }
        if (chunkposition != null) {
            return chunkposition;
        }
        List list = this.p_();
        if (list != null) {
            aco chunkposition2 = null;
            for (aco chunkposition1 : list) {
                i2 = chunkposition1.a - par2;
                l1 = chunkposition1.b - par3;
                j2 = chunkposition1.c - par4;
                d1 = i2 * i2 + l1 * l1 + j2 * j2;
                if (!(d1 < d0)) continue;
                d0 = d1;
                chunkposition2 = chunkposition1;
            }
            return chunkposition2;
        }
        return null;
    }

    protected List p_() {
        return null;
    }

    private void a(abw par1World) {
        if (this.e == null) {
            this.e = (ais)par1World.perWorldStorage.a(ais.class, this.a());
            if (this.e == null) {
                this.e = new ais(this.a());
                par1World.perWorldStorage.a(this.a(), (all)this.e);
            } else {
                by nbttagcompound = this.e.a();
                for (cl nbtbase : nbttagcompound.c()) {
                    by nbttagcompound1;
                    if (nbtbase.a() != 10 || !(nbttagcompound1 = (by)nbtbase).b("ChunkX") || !nbttagcompound1.b("ChunkZ")) continue;
                    int i = nbttagcompound1.e("ChunkX");
                    int j2 = nbttagcompound1.e("ChunkZ");
                    aiv structurestart = air.a(nbttagcompound1, par1World);
                    this.d.put(abp.a((int)i, (int)j2), structurestart);
                }
            }
        }
    }

    private void a(int par1, int par2, aiv par3StructureStart) {
        this.e.a(par3StructureStart.a(par1, par2), par1, par2);
        this.e.c();
    }

    protected abstract boolean a(int var1, int var2);

    protected abstract aiv b(int var1, int var2);
}

