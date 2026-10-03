/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk.storage;

import cpw.mods.fml.common.FMLLog;
import gloomyfolken.mods.asm.GloomyHooks;
import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.ThreadedFileIOBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ChunkDataEvent;

public class AnvilChunkLoader
implements bcgt,
kngp {
    public List _a = new ArrayList();
    public Set _b = new HashSet();
    public Object _c = new Object();
    public final File _d;

    public AnvilChunkLoader(File file) {
        this._d = file;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Chunk _a(World world, int n, int n2) throws IOException {
        NBTTagCompound nBTTagCompound = null;
        jjym jjym2 = new jjym(n, n2);
        Object object = this._c;
        Object object2 = this._c;
        synchronized (object2) {
            if (this._b.contains(jjym2)) {
                for (int i = 0; i < this._a.size(); ++i) {
                    if (!((dzlk)this._a.get((int)i))._a.equals(jjym2)) continue;
                    nBTTagCompound = ((dzlk)this._a.get((int)i))._b;
                    break;
                }
            }
        }
        if (nBTTagCompound == null) {
            object2 = suyl._b(this._d, n, n2);
            if (object2 == null) {
                return null;
            }
            nBTTagCompound = bsvf._a((DataInput)object2);
        }
        return this._a(world, n, n2, nBTTagCompound);
    }

    public Chunk _a(World world, int n, int n2, NBTTagCompound nBTTagCompound) {
        if (!nBTTagCompound._c("Level")) {
            world.getWorldLogAgent()._c("Chunk file at " + n + "," + n2 + " is missing level data, skipping");
            return null;
        }
        if (!nBTTagCompound._m("Level")._c("Sections")) {
            world.getWorldLogAgent()._c("Chunk file at " + n + "," + n2 + " is missing block data, skipping");
            return null;
        }
        Chunk chunk = this._a(world, nBTTagCompound._m("Level"));
        if (!chunk._a(n, n2)) {
            world.getWorldLogAgent()._c("Chunk file at " + n + "," + n2 + " is in the wrong location; relocating. (Expected " + n + ", " + n2 + ", got " + chunk._i + ", " + chunk._j + ")");
            nBTTagCompound._a("xPos", n);
            nBTTagCompound._a("zPos", n2);
            chunk = this._a(world, nBTTagCompound._m("Level"));
        }
        MinecraftForge.EVENT_BUS.post(new ChunkDataEvent.Load(chunk, nBTTagCompound));
        return chunk;
    }

    @Override
    public void _a(World world, Chunk chunk) throws xcad, IOException {
        world.checkSessionLock();
        try {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound._a("Level", (NBTBase)nBTTagCompound2);
            this._a(chunk, world, nBTTagCompound2);
            MinecraftForge.EVENT_BUS.post(new ChunkDataEvent.Save(chunk, nBTTagCompound));
            this._a(chunk._k(), nBTTagCompound);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(jjym jjym2, NBTTagCompound nBTTagCompound) {
        Object object = this._c;
        Object object2 = this._c;
        synchronized (object2) {
            if (this._b.contains(jjym2)) {
                for (int i = 0; i < this._a.size(); ++i) {
                    if (!((dzlk)this._a.get((int)i))._a.equals(jjym2)) continue;
                    this._a.set(i, new dzlk(jjym2, nBTTagCompound));
                    return;
                }
            }
            this._a.add(new dzlk(jjym2, nBTTagCompound));
            this._b.add(jjym2);
            ThreadedFileIOBase._a._a(this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean _a() {
        dzlk dzlk2 = null;
        Object object = this._c;
        Object object2 = this._c;
        synchronized (object2) {
            if (this._a.isEmpty()) {
                return false;
            }
            dzlk2 = (dzlk)this._a.remove(0);
            this._b.remove(dzlk2._a);
        }
        if (dzlk2 != null) {
            try {
                this._a(dzlk2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return true;
    }

    public void _a(dzlk dzlk2) throws IOException {
        DataOutputStream dataOutputStream = suyl._c(this._d, dzlk2._a._a, dzlk2._a._b);
        bsvf._a(dzlk2._b, dataOutputStream);
        dataOutputStream.close();
    }

    @Override
    public void _b(World world, Chunk chunk) {
    }

    @Override
    public void _b() {
    }

    @Override
    public void _c() {
        while (this._a()) {
        }
    }

    public void _a(Chunk chunk, World world, NBTTagCompound nBTTagCompound) {
        Object object3;
        Object object22;
        NBTTagCompound nBTTagCompound2;
        GloomyHooks.writeChunkToNBT(this, chunk, world, nBTTagCompound);
        nBTTagCompound._a("xPos", chunk._i);
        nBTTagCompound._a("zPos", chunk._j);
        nBTTagCompound._a("LastUpdate", world.getTotalWorldTime());
        nBTTagCompound._a("HeightMap", chunk._h);
        nBTTagCompound._a("TerrainPopulated", chunk._n);
        nBTTagCompound._a("InhabitedTime", chunk._t);
        ujzm[] ujzmArray = chunk._b();
        NBTTagList nBTTagList = new NBTTagList("Sections");
        boolean bl = !world.provider._g;
        ujzm[] ujzmArray2 = ujzmArray;
        int n = ujzmArray.length;
        for (int i = 0; i < n; ++i) {
            ujzm ujzm2 = ujzmArray2[i];
            if (ujzm2 == null) continue;
            nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Y", (byte)(ujzm2._c() >> 4 & 0xFF));
            nBTTagCompound2._a("Blocks", ujzm2._e());
            if (ujzm2._g() != null) {
                nBTTagCompound2._a("Add", ujzm2._g()._a);
            }
            nBTTagCompound2._a("Data", ujzm2._h()._a);
            nBTTagCompound2._a("BlockLight", ujzm2._i()._a);
            if (bl) {
                nBTTagCompound2._a("SkyLight", ujzm2._j()._a);
            } else {
                nBTTagCompound2._a("SkyLight", new byte[ujzm2._i()._a.length]);
            }
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Sections", nBTTagList);
        nBTTagCompound._a("Biomes", chunk._l());
        chunk._p = false;
        NBTTagList nBTTagList2 = new NBTTagList();
        for (n = 0; n < chunk._m.length; ++n) {
            for (Object object22 : chunk._m[n]) {
                nBTTagCompound2 = new NBTTagCompound();
                try {
                    if (!((Entity)object22).writeToNBTOptional(nBTTagCompound2)) continue;
                    chunk._p = true;
                    nBTTagList2._a(nBTTagCompound2);
                }
                catch (Exception exception) {
                    FMLLog.log(Level.SEVERE, exception, "An Entity type %s has thrown an exception trying to write state. It will not persist. Report this to the mod author", object22.getClass().getName());
                }
            }
        }
        nBTTagCompound._a("Entities", nBTTagList2);
        object22 = new NBTTagList();
        for (Object object3 : chunk._l.values()) {
            nBTTagCompound2 = new NBTTagCompound();
            try {
                ((TileEntity)object3).writeToNBT(nBTTagCompound2);
                ((NBTTagList)object22)._a(nBTTagCompound2);
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "A TileEntity type %s has throw an exception trying to write state. It will not persist. Report this to the mod author", object3.getClass().getName());
            }
        }
        nBTTagCompound._a("TileEntities", (NBTBase)object22);
        object3 = world.getPendingBlockUpdates(chunk, false);
        if (object3 != null) {
            long l = world.getTotalWorldTime();
            NBTTagList nBTTagList3 = new NBTTagList();
            Iterator iterator2 = object3.iterator();
            while (iterator2.hasNext()) {
                cfex cfex2 = (cfex)iterator2.next();
                NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
                nBTTagCompound3._a("i", cfex2._e);
                nBTTagCompound3._a("x", cfex2._b);
                nBTTagCompound3._a("y", cfex2._c);
                nBTTagCompound3._a("z", cfex2._d);
                nBTTagCompound3._a("t", (int)(cfex2._f - l));
                nBTTagCompound3._a("p", cfex2._g);
                nBTTagList3._a(nBTTagCompound3);
            }
            nBTTagCompound._a("TileTicks", nBTTagList3);
        }
    }

    public Chunk _a(World world, NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList;
        NBTTagList nBTTagList2;
        Object object;
        NBTTagList nBTTagList3;
        Object object2;
        int n = nBTTagCompound._f("xPos");
        int n2 = nBTTagCompound._f("zPos");
        Chunk chunk = new Chunk(world, n, n2);
        chunk._h = nBTTagCompound._l("HeightMap");
        chunk._n = nBTTagCompound._o("TerrainPopulated");
        chunk._t = nBTTagCompound._g("InhabitedTime");
        NBTTagList nBTTagList4 = nBTTagCompound._n("Sections");
        int n3 = 16;
        ujzm[] ujzmArray = new ujzm[n3];
        boolean bl = !world.provider._g;
        for (int i = 0; i < nBTTagList4._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList4._b(i);
            byte by = nBTTagCompound2._d("Y");
            object2 = new ujzm(by << 4, bl);
            ((ujzm)object2)._a(nBTTagCompound2._k("Blocks"));
            if (nBTTagCompound2._c("Add")) {
                ((ujzm)object2)._a(new wqak(nBTTagCompound2._k("Add"), 4));
            }
            ((ujzm)object2)._b(new wqak(nBTTagCompound2._k("Data"), 4));
            ((ujzm)object2)._c(new wqak(nBTTagCompound2._k("BlockLight"), 4));
            if (bl) {
                ((ujzm)object2)._d(new wqak(nBTTagCompound2._k("SkyLight"), 4));
            }
            ((ujzm)object2)._d();
            ujzmArray[by] = object2;
        }
        chunk._a(ujzmArray);
        if (nBTTagCompound._c("Biomes")) {
            chunk._a(nBTTagCompound._k("Biomes"));
        }
        if ((nBTTagList3 = nBTTagCompound._n("Entities")) != null) {
            for (int i = 0; i < nBTTagList3._d(); ++i) {
                NBTTagCompound nBTTagCompound3 = (NBTTagCompound)nBTTagList3._b(i);
                object2 = jgro._a(nBTTagCompound3, world);
                chunk._p = true;
                if (object2 == null) continue;
                chunk._a((Entity)object2);
                object = object2;
                NBTTagCompound nBTTagCompound4 = nBTTagCompound3;
                while (nBTTagCompound4._c("Riding")) {
                    Entity entity = jgro._a(nBTTagCompound4._m("Riding"), world);
                    if (entity != null) {
                        chunk._a(entity);
                        ((Entity)object).mountEntity(entity);
                    }
                    object = entity;
                    nBTTagCompound4 = nBTTagCompound4._m("Riding");
                }
            }
        }
        if ((nBTTagList2 = nBTTagCompound._n("TileEntities")) != null) {
            for (int i = 0; i < nBTTagList2._d(); ++i) {
                object2 = (NBTTagCompound)nBTTagList2._b(i);
                object = TileEntity.createAndLoadEntity((NBTTagCompound)object2);
                if (object == null) continue;
                chunk._a((TileEntity)object);
            }
        }
        if (nBTTagCompound._c("TileTicks") && (nBTTagList = nBTTagCompound._n("TileTicks")) != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                object = (NBTTagCompound)nBTTagList._b(i);
                world.scheduleBlockUpdateFromLoad(((NBTTagCompound)object)._f("x"), ((NBTTagCompound)object)._f("y"), ((NBTTagCompound)object)._f("z"), ((NBTTagCompound)object)._f("i"), ((NBTTagCompound)object)._f("t"), ((NBTTagCompound)object)._f("p"));
            }
        }
        return chunk;
    }
}

