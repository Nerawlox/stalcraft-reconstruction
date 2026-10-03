/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.turb;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.CallableIsFeatureChunk;
import net.minecraft.world.gen.structure.MapGenStructureData;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class MapGenStructure
extends yfis {
    public MapGenStructureData _j;
    public Map _k = new HashMap();

    public abstract String _a();

    @Override
    public final void _a(World world, int n, int n2, int n3, int n4, byte[] byArray) {
        this._a(world);
        if (!this._k.containsKey(jjym._a(n, n2))) {
            this._b.nextInt();
            try {
                if (this._a(n, n2)) {
                    tycc tycc2 = this._b(n, n2);
                    this._k.put(jjym._a(n, n2), tycc2);
                    this._a(n, n2, tycc2);
                }
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception preparing structure feature");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Feature being prepared");
                crashReportCategory._a("Is feature chunk", new CallableIsFeatureChunk(this, n, n2));
                crashReportCategory._a("Chunk location", String.format("%d,%d", n, n2));
                crashReportCategory._a("Chunk pos hash", new elqr(this, n, n2));
                crashReportCategory._a("Structure type", new gavt(this));
                throw new turb(crashReport);
            }
        }
    }

    public boolean _a(World world, Random random, int n, int n2) {
        this._a(world);
        int n3 = (n << 4) + 8;
        int n4 = (n2 << 4) + 8;
        boolean bl = false;
        for (tycc tycc2 : this._k.values()) {
            if (!tycc2._d() || !tycc2._a()._a(n3, n4, n3 + 15, n4 + 15)) continue;
            tycc2._a(world, random, new uken(n3, n4, n3 + 15, n4 + 15));
            bl = true;
            this._a(tycc2._e(), tycc2._f(), tycc2);
        }
        return bl;
    }

    public boolean _b(int n, int n2, int n3) {
        this._a(this._c);
        return this._c(n, n2, n3) != null;
    }

    public tycc _c(int n, int n2, int n3) {
        for (tycc tycc2 : this._k.values()) {
            if (!tycc2._d() || !tycc2._a()._a(n, n3, n, n3)) continue;
            for (StructureComponent structureComponent : tycc2._b()) {
                if (!structureComponent._d()._b(n, n2, n3)) continue;
                return tycc2;
            }
        }
        return null;
    }

    public boolean _d(int n, int n2, int n3) {
        tycc tycc2;
        this._a(this._c);
        Iterator iterator2 = this._k.values().iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while (!(tycc2 = (tycc)iterator2.next())._d());
        return tycc2._a()._a(n, n3, n, n3);
    }

    public xtcd _a(World world, int n, int n2, int n3) {
        double d;
        int n4;
        int n5;
        int n6;
        xtcd xtcd2;
        Object object;
        Object object22;
        this._c = world;
        this._a(world);
        this._b.setSeed(world.getSeed());
        long l = this._b.nextLong();
        long l2 = this._b.nextLong();
        long l3 = (long)(n >> 4) * l;
        long l4 = (long)(n3 >> 4) * l2;
        this._b.setSeed(l3 ^ l4 ^ world.getSeed());
        this._a(world, n >> 4, n3 >> 4, 0, 0, null);
        double d2 = Double.MAX_VALUE;
        xtcd xtcd3 = null;
        for (Object object22 : this._k.values()) {
            if (!((tycc)object22)._d()) continue;
            object = (StructureComponent)((tycc)object22)._b().get(0);
            xtcd2 = ((StructureComponent)object)._a();
            n6 = xtcd2._d - n;
            n5 = xtcd2._e - n2;
            n4 = xtcd2._f - n3;
            d = n6 * n6 + n5 * n5 + n4 * n4;
            if (!(d < d2)) continue;
            d2 = d;
            xtcd3 = xtcd2;
        }
        if (xtcd3 != null) {
            return xtcd3;
        }
        object22 = this._b();
        if (object22 != null) {
            object = null;
            Iterator iterator2 = object22.iterator();
            while (iterator2.hasNext()) {
                xtcd2 = (xtcd)iterator2.next();
                n6 = xtcd2._d - n;
                n5 = xtcd2._e - n2;
                n4 = xtcd2._f - n3;
                d = n6 * n6 + n5 * n5 + n4 * n4;
                if (!(d < d2)) continue;
                d2 = d;
                object = xtcd2;
            }
            return object;
        }
        return null;
    }

    public List _b() {
        return null;
    }

    public void _a(World world) {
        if (this._j == null) {
            this._j = (MapGenStructureData)world.perWorldStorage._a(MapGenStructureData.class, this._a());
            if (this._j == null) {
                this._j = new MapGenStructureData(this._a());
                world.perWorldStorage._a(this._a(), this._j);
            } else {
                NBTTagCompound nBTTagCompound = this._j._a();
                for (NBTBase nBTBase : nBTTagCompound._d()) {
                    NBTTagCompound nBTTagCompound2;
                    if (nBTBase._a() != 10 || !(nBTTagCompound2 = (NBTTagCompound)nBTBase)._c("ChunkX") || !nBTTagCompound2._c("ChunkZ")) continue;
                    int n = nBTTagCompound2._f("ChunkX");
                    int n2 = nBTTagCompound2._f("ChunkZ");
                    tycc tycc2 = cfps._a(nBTTagCompound2, world);
                    this._k.put(jjym._a(n, n2), tycc2);
                }
            }
        }
    }

    public void _a(int n, int n2, tycc tycc2) {
        this._j._a(tycc2._a(n, n2), n, n2);
        this._j.markDirty();
    }

    public abstract boolean _a(int var1, int var2);

    public abstract tycc _b(int var1, int var2);
}

