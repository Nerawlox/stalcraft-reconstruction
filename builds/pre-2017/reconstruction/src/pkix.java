/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkStarterFX;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.kjui;
import net.minecraft.logging.ILogAgent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.IntHashMap;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

@SideOnly(value=Side.CLIENT)
public class pkix
extends World {
    public bscn _a;
    public hcrs _b;
    public IntHashMap _c = new IntHashMap();
    public Set _d = new HashSet();
    public Set _e = new HashSet();
    public final Minecraft _f = Minecraft._E();
    public final Set _g = new HashSet();

    public pkix(bscn bscn2, WorldSettings worldSettings, int n, int n2, fokl fokl2, ILogAgent iLogAgent) {
        super((ISaveHandler)new aqna(), "MpServer", WorldProvider._a(n), worldSettings, fokl2, iLogAgent);
        this._a = bscn2;
        this.difficultySetting = n2;
        this.mapStorage = bscn2._g;
        this.isRemote = true;
        this.finishSetup();
        this.setSpawnLocation(8, 64, 8);
        MinecraftForge.EVENT_BUS.post(new WorldEvent.Load(this));
    }

    @Override
    public void tick() {
        super.tick();
        this.func_82738_a(this.getTotalWorldTime() + 1L);
        if (this.getGameRules()._b("doDaylightCycle")) {
            this.setWorldTime(this.getWorldTime() + 1L);
        }
        this.theProfiler._a("reEntryProcessing");
        for (int i = 0; i < 10 && !this._e.isEmpty(); ++i) {
            Entity entity = (Entity)this._e.iterator().next();
            this._e.remove(entity);
            if (this.loadedEntityList.contains(entity)) continue;
            this.spawnEntityInWorld(entity);
        }
        this.theProfiler._c("connection");
        this._a._b();
        this.theProfiler._c("chunkCache");
        this._b._b();
        this.theProfiler._c("tiles");
        this.tickBlocksAndAmbiance();
        this.theProfiler._b();
    }

    public void _a(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public IChunkProvider createChunkProvider() {
        this._b = new hcrs(this);
        return this._b;
    }

    @Override
    public void tickBlocksAndAmbiance() {
        super.tickBlocksAndAmbiance();
        this._g.retainAll(this.activeChunkSet);
        if (this._g.size() == this.activeChunkSet.size()) {
            this._g.clear();
        }
        int n = 0;
        for (jjym jjym2 : this.activeChunkSet) {
            if (this._g.contains(jjym2)) continue;
            int n2 = jjym2._a * 16;
            int n3 = jjym2._b * 16;
            this.theProfiler._a("getChunk");
            Chunk chunk = this.getChunkFromChunkCoords(jjym2._a, jjym2._b);
            this.moodSoundAndLightCheck(n2, n3, chunk);
            this.theProfiler._b();
            this._g.add(jjym2);
            if (++n < 10) continue;
            return;
        }
    }

    public void _a(int n, int n2, boolean bl) {
        if (bl) {
            this._b._a(n, n2);
        } else {
            this._b._e(n, n2);
        }
        if (!bl) {
            this.markBlockRangeForRenderUpdate(n * 16, 0, n2 * 16, n * 16 + 15, 256, n2 * 16 + 15);
        }
    }

    @Override
    public boolean spawnEntityInWorld(Entity entity) {
        boolean bl = super.spawnEntityInWorld(entity);
        this._d.add(entity);
        if (!bl) {
            this._e.add(entity);
        }
        return bl;
    }

    @Override
    public void removeEntity(Entity entity) {
        super.removeEntity(entity);
        this._d.remove(entity);
    }

    @Override
    public void onEntityAdded(Entity entity) {
        super.onEntityAdded(entity);
        if (this._e.contains(entity)) {
            this._e.remove(entity);
        }
    }

    @Override
    public void onEntityRemoved(Entity entity) {
        super.onEntityRemoved(entity);
        if (this._d.contains(entity)) {
            if (entity.isEntityAlive()) {
                this._e.add(entity);
            } else {
                this._d.remove(entity);
            }
        }
    }

    public void _a(int n, Entity entity) {
        GloomyHooks.addEntityToWorld(this, n, entity);
        Entity entity2 = this.getEntityByID(n);
        if (entity2 != null) {
            this.removeEntity(entity2);
        }
        this._d.add(entity);
        entity.entityId = n;
        if (!this.spawnEntityInWorld(entity)) {
            this._e.add(entity);
        }
        this._c._a(n, entity);
    }

    @Override
    public Entity getEntityByID(int n) {
        return n == this._f._t.entityId ? this._f._t : (Entity)this._c._b(n);
    }

    public Entity _a(int n) {
        Entity entity = (Entity)this._c._f(n);
        if (entity != null) {
            this._d.remove(entity);
            this.removeEntity(entity);
        }
        return entity;
    }

    public boolean _a(int n, int n2, int n3, int n4, int n5) {
        this._a(n, n2, n3, n, n2, n3);
        return super.setBlock(n, n2, n3, n4, n5, 3);
    }

    @Override
    public void sendQuittingDisconnectingPacket() {
        this._a._a(new Packet255KickDisconnect("Quitting"));
    }

    @Override
    public IUpdatePlayerListBox getMinecartSoundUpdater(EntityMinecart entityMinecart) {
        return new kjui(this._f._N, entityMinecart, this._f._t);
    }

    @Override
    public void updateWeather() {
        super.updateWeather();
    }

    @Override
    public void updateWeatherBody() {
        if (!this.provider._g) {
            this.prevRainingStrength = this.rainingStrength;
            this.rainingStrength = this.worldInfo._p() ? (float)((double)this.rainingStrength + 0.01) : (float)((double)this.rainingStrength - 0.01);
            if (this.rainingStrength < 0.0f) {
                this.rainingStrength = 0.0f;
            }
            if (this.rainingStrength > 1.0f) {
                this.rainingStrength = 1.0f;
            }
            this.prevThunderingStrength = this.thunderingStrength;
            this.thunderingStrength = this.worldInfo._n() ? (float)((double)this.thunderingStrength + 0.01) : (float)((double)this.thunderingStrength - 0.01);
            if (this.thunderingStrength < 0.0f) {
                this.thunderingStrength = 0.0f;
            }
            if (this.thunderingStrength > 1.0f) {
                this.thunderingStrength = 1.0f;
            }
        }
    }

    public void _a(int n, int n2, int n3) {
        BlockRendererList.doVoidFogParticles(this, n, n2, n3);
    }

    public void _a() {
        int n;
        int n2;
        Entity entity;
        int n3;
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (n3 = 0; n3 < this.unloadedEntityList.size(); ++n3) {
            entity = (Entity)this.unloadedEntityList.get(n3);
            n2 = entity.chunkCoordX;
            n = entity.chunkCoordZ;
            if (!entity.addedToChunk || !this.chunkExists(n2, n)) continue;
            this.getChunkFromChunkCoords(n2, n)._b(entity);
        }
        for (n3 = 0; n3 < this.unloadedEntityList.size(); ++n3) {
            this.onEntityRemoved((Entity)this.unloadedEntityList.get(n3));
        }
        this.unloadedEntityList.clear();
        for (n3 = 0; n3 < this.loadedEntityList.size(); ++n3) {
            entity = (Entity)this.loadedEntityList.get(n3);
            if (entity.ridingEntity != null) {
                if (!entity.ridingEntity.isDead && entity.ridingEntity.riddenByEntity == entity) continue;
                entity.ridingEntity.riddenByEntity = null;
                entity.ridingEntity = null;
            }
            if (!entity.isDead) continue;
            n2 = entity.chunkCoordX;
            n = entity.chunkCoordZ;
            if (entity.addedToChunk && this.chunkExists(n2, n)) {
                this.getChunkFromChunkCoords(n2, n)._b(entity);
            }
            this.loadedEntityList.remove(n3--);
            this.onEntityRemoved(entity);
        }
    }

    @Override
    public CrashReportCategory addWorldInfoToCrashReport(CrashReport crashReport) {
        CrashReportCategory crashReportCategory = super.addWorldInfoToCrashReport(crashReport);
        crashReportCategory._a("Forced entities", new iwwd(this));
        crashReportCategory._a("Retry entities", new nveu(this));
        crashReportCategory._a("Server brand", new vlzl(this));
        crashReportCategory._a("Server type", new jiwk(this));
        return crashReportCategory;
    }

    @Override
    public void playSound(double d, double d2, double d3, String string, float f, float f2, boolean bl) {
        double d4;
        float f3 = 16.0f;
        if (f > 1.0f) {
            f3 *= f;
        }
        if ((d4 = this._f._u.getDistanceSq(d, d2, d3)) < (double)(f3 * f3)) {
            if (bl && d4 > 100.0) {
                double d5 = Math.sqrt(d4) / 40.0;
                this._f._N._a(string, (float)d, (float)d2, (float)d3, f, f2, (int)Math.round(d5 * 20.0));
            } else {
                this._f._N._a(string, (float)d, (float)d2, (float)d3, f, f2);
            }
        }
    }

    @Override
    public void func_92088_a(double d, double d2, double d3, double d4, double d5, double d6, NBTTagCompound nBTTagCompound) {
        this._f._w._a(new EntityFireworkStarterFX(this, d, d2, d3, d4, d5, d6, this._f._w, nBTTagCompound));
    }

    public void _a(Scoreboard scoreboard) {
        this.worldScoreboard = scoreboard;
    }

    @Override
    public void setWorldTime(long l) {
        if (l < 0L) {
            l = -l;
            this.getGameRules()._b("doDaylightCycle", "false");
        } else {
            this.getGameRules()._b("doDaylightCycle", "true");
        }
        super.setWorldTime(l);
    }

    public static Set _a(pkix pkix2) {
        return pkix2._d;
    }

    public static Set _b(pkix pkix2) {
        return pkix2._e;
    }

    public static Minecraft _c(pkix pkix2) {
        return pkix2._f;
    }
}

