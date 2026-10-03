/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.village;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class VillageCollection
extends WorldSavedData {
    public World _a;
    public final List _b = new ArrayList();
    public final List _c = new ArrayList();
    public final List _d = new ArrayList();
    public int _e;

    public VillageCollection(String string) {
        super(string);
    }

    public VillageCollection(World world) {
        super("villages");
        this._a = world;
        this.markDirty();
    }

    public void _a(World world) {
        this._a = world;
        for (Village village : this._d) {
            village._a(world);
        }
    }

    public void _a(int n, int n2, int n3) {
        if (this._b.size() <= 64 && !this._d(n, n2, n3)) {
            this._b.add(new ChunkCoordinates(n, n2, n3));
        }
    }

    public void _a() {
        ++this._e;
        for (Village village : this._d) {
            village._a(this._e);
        }
        this._b();
        this._d();
        this._e();
        if (this._e % 400 == 0) {
            this.markDirty();
        }
    }

    public void _b() {
        Iterator iterator2 = this._d.iterator();
        while (iterator2.hasNext()) {
            Village village = (Village)iterator2.next();
            if (!village._i()) continue;
            iterator2.remove();
            this.markDirty();
        }
    }

    public List _c() {
        return this._d;
    }

    public Village _a(int n, int n2, int n3, int n4) {
        Village village = null;
        float f = Float.MAX_VALUE;
        for (Village village2 : this._d) {
            float f2;
            float f3 = village2._c()._b(n, n2, n3);
            if (!(f3 < f) || !(f3 <= (f2 = (float)(n4 + village2._d())) * f2)) continue;
            village = village2;
            f = f3;
        }
        return village;
    }

    public void _d() {
        if (!this._b.isEmpty()) {
            this._a((ChunkCoordinates)this._b.remove(0));
        }
    }

    public void _e() {
        for (int i = 0; i < this._c.size(); ++i) {
            Village village2;
            ellv ellv2 = (ellv)this._c.get(i);
            boolean bl = false;
            for (Village village2 : this._d) {
                float f;
                int n = (int)village2._c()._b(ellv2._a, ellv2._b, ellv2._c);
                if ((float)n > (f = 32.0f + (float)village2._d()) * f) continue;
                village2._a(ellv2);
                bl = true;
                break;
            }
            if (bl) continue;
            village2 = new Village(this._a);
            village2._a(ellv2);
            this._d.add(village2);
            this.markDirty();
        }
        this._c.clear();
    }

    public void _a(ChunkCoordinates chunkCoordinates) {
        int n = 16;
        int n2 = 4;
        int n3 = 16;
        for (int i = chunkCoordinates._a - n; i < chunkCoordinates._a + n; ++i) {
            for (int j = chunkCoordinates._b - n2; j < chunkCoordinates._b + n2; ++j) {
                for (int k = chunkCoordinates._c - n3; k < chunkCoordinates._c + n3; ++k) {
                    if (!this._e(i, j, k)) continue;
                    ellv ellv2 = this._b(i, j, k);
                    if (ellv2 == null) {
                        this._c(i, j, k);
                        continue;
                    }
                    ellv2._f = this._e;
                }
            }
        }
    }

    public ellv _b(int n, int n2, int n3) {
        ellv ellv2;
        Iterator iterator2 = this._c.iterator();
        do {
            if (!iterator2.hasNext()) {
                Village village;
                ellv ellv3;
                iterator2 = this._d.iterator();
                do {
                    if (iterator2.hasNext()) continue;
                    return null;
                } while ((ellv3 = (village = (Village)iterator2.next())._d(n, n2, n3)) == null);
                return ellv3;
            }
            ellv2 = (ellv)iterator2.next();
        } while (ellv2._a != n || ellv2._c != n3 || Math.abs(ellv2._b - n2) > 1);
        return ellv2;
    }

    public void _c(int n, int n2, int n3) {
        int n4 = ((BlockDoor)Block.doorWood)._a(this._a, n, n2, n3);
        if (n4 != 0 && n4 != 2) {
            int n5;
            int n6 = 0;
            for (n5 = -5; n5 < 0; ++n5) {
                if (!this._a.canBlockSeeTheSky(n, n2, n3 + n5)) continue;
                --n6;
            }
            for (n5 = 1; n5 <= 5; ++n5) {
                if (!this._a.canBlockSeeTheSky(n, n2, n3 + n5)) continue;
                ++n6;
            }
            if (n6 != 0) {
                this._c.add(new ellv(n, n2, n3, 0, n6 > 0 ? -2 : 2, this._e));
            }
        } else {
            int n7;
            int n8 = 0;
            for (n7 = -5; n7 < 0; ++n7) {
                if (!this._a.canBlockSeeTheSky(n + n7, n2, n3)) continue;
                --n8;
            }
            for (n7 = 1; n7 <= 5; ++n7) {
                if (!this._a.canBlockSeeTheSky(n + n7, n2, n3)) continue;
                ++n8;
            }
            if (n8 != 0) {
                this._c.add(new ellv(n, n2, n3, n8 > 0 ? -2 : 2, 0, this._e));
            }
        }
    }

    public boolean _d(int n, int n2, int n3) {
        ChunkCoordinates chunkCoordinates;
        Iterator iterator2 = this._b.iterator();
        do {
            if (!iterator2.hasNext()) {
                return false;
            }
            chunkCoordinates = (ChunkCoordinates)iterator2.next();
        } while (chunkCoordinates._a != n || chunkCoordinates._b != n2 || chunkCoordinates._c != n3);
        return true;
    }

    public boolean _e(int n, int n2, int n3) {
        int n4 = this._a.getBlockId(n, n2, n3);
        return n4 == Block.doorWood.blockID;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this._e = nBTTagCompound._f("Tick");
        NBTTagList nBTTagList = nBTTagCompound._n("Villages");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            Village village = new Village();
            village._a(nBTTagCompound2);
            this._d.add(village);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Tick", this._e);
        NBTTagList nBTTagList = new NBTTagList("Villages");
        for (Village village : this._d) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound("Village");
            village._b(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Villages", nBTTagList);
    }
}

