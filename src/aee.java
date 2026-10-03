/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abp
 *  aca
 *  acm
 *  adp
 *  ads
 *  adw
 *  aed
 *  aef
 *  ams
 *  amt
 *  cl
 *  cpw.mods.fml.common.FMLLog
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.world.ChunkDataEvent$Load
 *  net.minecraftforge.event.world.ChunkDataEvent$Save
 */
import cpw.mods.fml.common.FMLLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.world.ChunkDataEvent;

public class aee
implements adw,
amt {
    private List a = new ArrayList();
    private Set b = new HashSet();
    private Object c = new Object();
    public final File d;

    public aee(File par1File) {
        this.d = par1File;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public adr a(abw par1World, int par2, int par3) throws IOException {
        by nbttagcompound = null;
        abp chunkcoordintpair = new abp(par2, par3);
        Object object = this.c;
        Object object2 = this.c;
        synchronized (object2) {
            if (this.b.contains(chunkcoordintpair)) {
                for (int k = 0; k < this.a.size(); ++k) {
                    if (!((aef)this.a.get((int)k)).a.equals((Object)chunkcoordintpair)) continue;
                    nbttagcompound = ((aef)this.a.get((int)k)).b;
                    break;
                }
            }
        }
        if (nbttagcompound == null) {
            DataInputStream datainputstream = aed.c((File)this.d, (int)par2, (int)par3);
            if (datainputstream == null) {
                return null;
            }
            nbttagcompound = ci.a(datainputstream);
        }
        return this.a(par1World, par2, par3, nbttagcompound);
    }

    protected adr a(abw par1World, int par2, int par3, by par4NBTTagCompound) {
        if (!par4NBTTagCompound.b("Level")) {
            par1World.Y().c("Chunk file at " + par2 + "," + par3 + " is missing level data, skipping");
            return null;
        }
        if (!par4NBTTagCompound.l("Level").b("Sections")) {
            par1World.Y().c("Chunk file at " + par2 + "," + par3 + " is missing block data, skipping");
            return null;
        }
        adr chunk = this.a(par1World, par4NBTTagCompound.l("Level"));
        if (!chunk.a(par2, par3)) {
            par1World.Y().c("Chunk file at " + par2 + "," + par3 + " is in the wrong location; relocating. (Expected " + par2 + ", " + par3 + ", got " + chunk.g + ", " + chunk.h + ")");
            par4NBTTagCompound.a("xPos", par2);
            par4NBTTagCompound.a("zPos", par3);
            chunk = this.a(par1World, par4NBTTagCompound.l("Level"));
        }
        MinecraftForge.EVENT_BUS.post((Event)new ChunkDataEvent.Load(chunk, par4NBTTagCompound));
        return chunk;
    }

    public void a(abw par1World, adr par2Chunk) throws aca, IOException {
        par1World.G();
        try {
            by nbttagcompound = new by();
            by nbttagcompound1 = new by();
            nbttagcompound.a("Level", (cl)nbttagcompound1);
            this.a(par2Chunk, par1World, nbttagcompound1);
            MinecraftForge.EVENT_BUS.post((Event)new ChunkDataEvent.Save(par2Chunk, nbttagcompound));
            this.a(par2Chunk.l(), nbttagcompound);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void a(abp par1ChunkCoordIntPair, by par2NBTTagCompound) {
        Object object = this.c;
        Object object2 = this.c;
        synchronized (object2) {
            if (this.b.contains(par1ChunkCoordIntPair)) {
                for (int i = 0; i < this.a.size(); ++i) {
                    if (!((aef)this.a.get((int)i)).a.equals((Object)par1ChunkCoordIntPair)) continue;
                    this.a.set(i, new aef(par1ChunkCoordIntPair, par2NBTTagCompound));
                    return;
                }
            }
            this.a.add(new aef(par1ChunkCoordIntPair, par2NBTTagCompound));
            this.b.add(par1ChunkCoordIntPair);
            ams.a.a((amt)this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean c() {
        aef anvilchunkloaderpending = null;
        Object object = this.c;
        Object object2 = this.c;
        synchronized (object2) {
            if (this.a.isEmpty()) {
                return false;
            }
            anvilchunkloaderpending = (aef)this.a.remove(0);
            this.b.remove(anvilchunkloaderpending.a);
        }
        if (anvilchunkloaderpending != null) {
            try {
                this.a(anvilchunkloaderpending);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return true;
    }

    private void a(aef par1AnvilChunkLoaderPending) throws IOException {
        DataOutputStream dataoutputstream = aed.d((File)this.d, (int)par1AnvilChunkLoaderPending.a.a, (int)par1AnvilChunkLoaderPending.a.b);
        ci.a(par1AnvilChunkLoaderPending.b, dataoutputstream);
        dataoutputstream.close();
    }

    public void b(abw par1World, adr par2Chunk) {
    }

    public void a() {
    }

    public void b() {
        while (this.c()) {
        }
    }

    private void a(adr par1Chunk, abw par2World, by par3NBTTagCompound) {
        by nbttagcompound1;
        par3NBTTagCompound.a("xPos", par1Chunk.g);
        par3NBTTagCompound.a("zPos", par1Chunk.h);
        par3NBTTagCompound.a("LastUpdate", par2World.I());
        par3NBTTagCompound.a("HeightMap", par1Chunk.f);
        par3NBTTagCompound.a("TerrainPopulated", par1Chunk.k);
        par3NBTTagCompound.a("InhabitedTime", par1Chunk.q);
        ads[] aextendedblockstorage = par1Chunk.i();
        cg nbttaglist = new cg("Sections");
        boolean flag = !par2World.t.g;
        ads[] aextendedblockstorage1 = aextendedblockstorage;
        int i = aextendedblockstorage.length;
        for (int j2 = 0; j2 < i; ++j2) {
            ads extendedblockstorage = aextendedblockstorage1[j2];
            if (extendedblockstorage == null) continue;
            nbttagcompound1 = new by();
            nbttagcompound1.a("Y", (byte)(extendedblockstorage.d() >> 4 & 0xFF));
            nbttagcompound1.a("Blocks", extendedblockstorage.g());
            if (extendedblockstorage.i() != null) {
                nbttagcompound1.a("Add", extendedblockstorage.i().a);
            }
            nbttagcompound1.a("Data", extendedblockstorage.j().a);
            nbttagcompound1.a("BlockLight", extendedblockstorage.k().a);
            if (flag) {
                nbttagcompound1.a("SkyLight", extendedblockstorage.l().a);
            } else {
                nbttagcompound1.a("SkyLight", new byte[extendedblockstorage.k().a.length]);
            }
            nbttaglist.a(nbttagcompound1);
        }
        par3NBTTagCompound.a("Sections", nbttaglist);
        par3NBTTagCompound.a("Biomes", par1Chunk.m());
        par1Chunk.m = false;
        cg nbttaglist1 = new cg();
        for (i = 0; i < par1Chunk.j.length; ++i) {
            for (nn entity : par1Chunk.j[i]) {
                nbttagcompound1 = new by();
                try {
                    if (!entity.d(nbttagcompound1)) continue;
                    par1Chunk.m = true;
                    nbttaglist1.a(nbttagcompound1);
                }
                catch (Exception e) {
                    FMLLog.log((Level)Level.SEVERE, (Throwable)e, (String)"An Entity type %s has thrown an exception trying to write state. It will not persist. Report this to the mod author", (Object[])new Object[]{entity.getClass().getName()});
                }
            }
        }
        par3NBTTagCompound.a("Entities", nbttaglist1);
        cg nbttaglist2 = new cg();
        for (asp tileentity : par1Chunk.i.values()) {
            nbttagcompound1 = new by();
            try {
                tileentity.b(nbttagcompound1);
                nbttaglist2.a(nbttagcompound1);
            }
            catch (Exception e) {
                FMLLog.log((Level)Level.SEVERE, (Throwable)e, (String)"A TileEntity type %s has throw an exception trying to write state. It will not persist. Report this to the mod author", (Object[])new Object[]{tileentity.getClass().getName()});
            }
        }
        par3NBTTagCompound.a("TileEntities", nbttaglist2);
        List list = par2World.a(par1Chunk, false);
        if (list != null) {
            long k = par2World.I();
            cg nbttaglist3 = new cg();
            for (acm nextticklistentry : list) {
                by nbttagcompound2 = new by();
                nbttagcompound2.a("i", nextticklistentry.d);
                nbttagcompound2.a("x", nextticklistentry.a);
                nbttagcompound2.a("y", nextticklistentry.b);
                nbttagcompound2.a("z", nextticklistentry.c);
                nbttagcompound2.a("t", (int)(nextticklistentry.e - k));
                nbttagcompound2.a("p", nextticklistentry.f);
                nbttaglist3.a(nbttagcompound2);
            }
            par3NBTTagCompound.a("TileTicks", nbttaglist3);
        }
    }

    private adr a(abw par1World, by par2NBTTagCompound) {
        cg nbttaglist3;
        cg nbttaglist2;
        cg nbttaglist1;
        int i = par2NBTTagCompound.e("xPos");
        int j2 = par2NBTTagCompound.e("zPos");
        adr chunk = new adr(par1World, i, j2);
        chunk.f = par2NBTTagCompound.k("HeightMap");
        chunk.k = par2NBTTagCompound.n("TerrainPopulated");
        chunk.q = par2NBTTagCompound.f("InhabitedTime");
        cg nbttaglist = par2NBTTagCompound.m("Sections");
        int b0 = 16;
        ads[] aextendedblockstorage = new ads[b0];
        boolean flag = !par1World.t.g;
        for (int k = 0; k < nbttaglist.c(); ++k) {
            by nbttagcompound1 = (by)nbttaglist.b(k);
            byte b1 = nbttagcompound1.c("Y");
            ads extendedblockstorage = new ads(b1 << 4, flag);
            extendedblockstorage.a(nbttagcompound1.j("Blocks"));
            if (nbttagcompound1.b("Add")) {
                extendedblockstorage.a(new adp(nbttagcompound1.j("Add"), 4));
            }
            extendedblockstorage.b(new adp(nbttagcompound1.j("Data"), 4));
            extendedblockstorage.c(new adp(nbttagcompound1.j("BlockLight"), 4));
            if (flag) {
                extendedblockstorage.d(new adp(nbttagcompound1.j("SkyLight"), 4));
            }
            extendedblockstorage.e();
            aextendedblockstorage[b1] = extendedblockstorage;
        }
        chunk.a(aextendedblockstorage);
        if (par2NBTTagCompound.b("Biomes")) {
            chunk.a(par2NBTTagCompound.j("Biomes"));
        }
        if ((nbttaglist1 = par2NBTTagCompound.m("Entities")) != null) {
            for (int l = 0; l < nbttaglist1.c(); ++l) {
                by nbttagcompound2 = (by)nbttaglist1.b(l);
                nn entity = nt.a(nbttagcompound2, par1World);
                chunk.m = true;
                if (entity == null) continue;
                chunk.a(entity);
                nn entity1 = entity;
                by nbttagcompound3 = nbttagcompound2;
                while (nbttagcompound3.b("Riding")) {
                    nn entity2 = nt.a(nbttagcompound3.l("Riding"), par1World);
                    if (entity2 != null) {
                        chunk.a(entity2);
                        entity1.a(entity2);
                    }
                    entity1 = entity2;
                    nbttagcompound3 = nbttagcompound3.l("Riding");
                }
            }
        }
        if ((nbttaglist2 = par2NBTTagCompound.m("TileEntities")) != null) {
            for (int i1 = 0; i1 < nbttaglist2.c(); ++i1) {
                by nbttagcompound4 = (by)nbttaglist2.b(i1);
                asp tileentity = asp.c(nbttagcompound4);
                if (tileentity == null) continue;
                chunk.a(tileentity);
            }
        }
        if (par2NBTTagCompound.b("TileTicks") && (nbttaglist3 = par2NBTTagCompound.m("TileTicks")) != null) {
            for (int j1 = 0; j1 < nbttaglist3.c(); ++j1) {
                by nbttagcompound5 = (by)nbttaglist3.b(j1);
                par1World.b(nbttagcompound5.e("x"), nbttagcompound5.e("y"), nbttagcompound5.e("z"), nbttagcompound5.e("i"), nbttagcompound5.e("t"), nbttagcompound5.e("p"));
            }
        }
        return chunk;
    }
}

