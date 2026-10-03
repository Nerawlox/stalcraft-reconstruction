/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.block.Block;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.vjsq;
import net.minecraft.item.Item;
import net.minecraft.logging.ILogAgent;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.scoreboard.ScoreboardSaveData;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.Vec3;
import net.minecraft.util.iurq;
import net.minecraft.util.sajz;
import net.minecraft.util.turb;
import net.minecraft.util.vjvn;
import net.minecraft.world.Explosion;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.world.WorldEvent;

public class WorldServer
extends World {
    public final MinecraftServer mcServer;
    public final EntityTracker theEntityTracker;
    public final PlayerManager thePlayerManager;
    public Set pendingTickListEntriesHashSet;
    public TreeSet pendingTickListEntriesTreeSet;
    public fotf theChunkProviderServer;
    public boolean field_73058_d;
    public boolean allPlayersSleeping;
    public int updateEntityTick;
    public final Teleporter worldTeleporter;
    public final xtbl animalSpawner = new xtbl();
    public nwfk[] blockEventCache = new nwfk[]{new nwfk((igvb)null), new nwfk((igvb)null)};
    public int blockEventCacheIndex;
    public static final vjvn[] bonusChestContent = new vjvn[]{new vjvn(Item.stick.itemID, 0, 1, 3, 10), new vjvn(Block.planks.blockID, 0, 1, 3, 10), new vjvn(Block.wood.blockID, 0, 1, 3, 10), new vjvn(Item.axeStone.itemID, 0, 1, 1, 3), new vjvn(Item.axeWood.itemID, 0, 1, 1, 5), new vjvn(Item.pickaxeStone.itemID, 0, 1, 1, 3), new vjvn(Item.pickaxeWood.itemID, 0, 1, 1, 5), new vjvn(Item.appleRed.itemID, 0, 2, 3, 5), new vjvn(Item.bread.itemID, 0, 2, 3, 3)};
    public List pendingTickListEntriesThisTick = new ArrayList();
    public IntHashMap entityIdMap;
    public Set<jjym> doneChunks = new HashSet<jjym>();
    public List<Teleporter> customTeleporters = new ArrayList<Teleporter>();

    public WorldServer(MinecraftServer minecraftServer, ISaveHandler iSaveHandler, String string, int n, WorldSettings worldSettings, fokl fokl2, ILogAgent iLogAgent) {
        super(iSaveHandler, string, worldSettings, WorldProvider._a(n), fokl2, iLogAgent);
        this.mcServer = minecraftServer;
        this.theEntityTracker = new EntityTracker(this);
        this.thePlayerManager = new PlayerManager(this, minecraftServer.__ag()._u());
        if (this.entityIdMap == null) {
            this.entityIdMap = new IntHashMap();
        }
        if (this.pendingTickListEntriesHashSet == null) {
            this.pendingTickListEntriesHashSet = new HashSet();
        }
        if (this.pendingTickListEntriesTreeSet == null) {
            this.pendingTickListEntriesTreeSet = new TreeSet();
        }
        this.worldTeleporter = new Teleporter(this);
        this.worldScoreboard = new ServerScoreboard(minecraftServer);
        ScoreboardSaveData scoreboardSaveData = (ScoreboardSaveData)this.mapStorage._a(ScoreboardSaveData.class, "scoreboard");
        if (scoreboardSaveData == null) {
            scoreboardSaveData = new ScoreboardSaveData();
            this.mapStorage._a("scoreboard", scoreboardSaveData);
        }
        if (!(this instanceof rasa)) {
            scoreboardSaveData._a(this.worldScoreboard);
        }
        ((ServerScoreboard)this.worldScoreboard)._a(scoreboardSaveData);
        DimensionManager.setWorld(n, this);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorldInfo()._t() && this.difficultySetting < 3) {
            this.difficultySetting = 3;
        }
        this.provider._e._b();
        if (this.areAllPlayersAsleep()) {
            if (this.getGameRules()._b("doDaylightCycle")) {
                long l = this.worldInfo._g() + 24000L;
                this.worldInfo._b(l - l % 24000L);
            }
            this.wakeAllPlayers();
        }
        this.theProfiler._a("mobSpawner");
        if (this.getGameRules()._b("doMobSpawning")) {
            this.animalSpawner._a(this, this.spawnHostileMobs, this.spawnPeacefulMobs, this.worldInfo._f() % 400L == 0L);
        }
        this.theProfiler._c("chunkSource");
        this.chunkProvider._b();
        int n = this.calculateSkylightSubtracted(1.0f);
        if (n != this.skylightSubtracted) {
            this.skylightSubtracted = n;
        }
        this.worldInfo._a(this.worldInfo._f() + 1L);
        if (this.getGameRules()._b("doDaylightCycle")) {
            this.worldInfo._b(this.worldInfo._g() + 1L);
        }
        this.theProfiler._c("tickPending");
        this.tickUpdates(false);
        this.theProfiler._c("tickTiles");
        this.tickBlocksAndAmbiance();
        this.theProfiler._c("chunkMap");
        this.thePlayerManager._b();
        this.theProfiler._c("village");
        this.villageCollectionObj._a();
        this.villageSiegeObj._a();
        this.theProfiler._c("portalForcer");
        this.worldTeleporter.removeStalePortalLocations(this.getTotalWorldTime());
        for (Teleporter teleporter : this.customTeleporters) {
            teleporter.removeStalePortalLocations(this.getTotalWorldTime());
        }
        this.theProfiler._b();
        this.sendAndApplyBlockEvents();
    }

    public yffo spawnRandomCreature(EnumCreatureType enumCreatureType, int n, int n2, int n3) {
        List list2 = this.getChunkProvider()._a(enumCreatureType, n, n2, n3);
        return (list2 = ForgeEventFactory.getPotentialSpawns(this, enumCreatureType, n, n2, n3, list2)) != null && !list2.isEmpty() ? (yffo)iurq._a(this.rand, list2) : null;
    }

    @Override
    public void updateAllPlayersSleepingFlag() {
        this.allPlayersSleeping = !this.playerEntities.isEmpty();
        for (EntityPlayer entityPlayer : this.playerEntities) {
            if (entityPlayer.isPlayerSleeping()) continue;
            this.allPlayersSleeping = false;
            break;
        }
    }

    public void wakeAllPlayers() {
        this.allPlayersSleeping = false;
        for (EntityPlayer entityPlayer : this.playerEntities) {
            if (!entityPlayer.isPlayerSleeping()) continue;
            entityPlayer.wakeUpPlayer(false, false, true);
        }
        this.resetRainAndThunder();
    }

    public void resetRainAndThunder() {
        this.provider._D();
    }

    public boolean areAllPlayersAsleep() {
        if (this.allPlayersSleeping && !this.isRemote) {
            EntityPlayer entityPlayer;
            Iterator iterator2 = this.playerEntities.iterator();
            do {
                if (iterator2.hasNext()) continue;
                return true;
            } while ((entityPlayer = (EntityPlayer)iterator2.next()).isPlayerFullyAsleep());
            return false;
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void setSpawnLocation() {
        if (this.worldInfo._d() <= 0) {
            this.worldInfo._b(64);
        }
        int n = this.worldInfo._c();
        int n2 = this.worldInfo._e();
        int n3 = 0;
        while (this.getFirstUncoveredBlock(n, n2) == 0) {
            n += this.rand.nextInt(8) - this.rand.nextInt(8);
            n2 += this.rand.nextInt(8) - this.rand.nextInt(8);
            if (++n3 != 10000) continue;
        }
        this.worldInfo._a(n);
        this.worldInfo._c(n2);
    }

    @Override
    public void tickBlocksAndAmbiance() {
        super.tickBlocksAndAmbiance();
        int n = 0;
        int n2 = 0;
        Iterator iterator2 = this.activeChunkSet.iterator();
        this.doneChunks.retainAll(this.activeChunkSet);
        if (this.doneChunks.size() == this.activeChunkSet.size()) {
            this.doneChunks.clear();
        }
        long l = System.nanoTime();
        while (iterator2.hasNext()) {
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            jjym jjym2 = (jjym)iterator2.next();
            int n8 = jjym2._a * 16;
            int n9 = jjym2._b * 16;
            this.theProfiler._a("getChunk");
            Chunk chunk = this.getChunkFromChunkCoords(jjym2._a, jjym2._b);
            this.moodSoundAndLightCheck(n8, n9, chunk);
            this.theProfiler._c("tickChunk");
            if (System.nanoTime() - l <= 4000000L && this.doneChunks.add(jjym2)) {
                chunk._j();
            }
            this.theProfiler._c("thunder");
            if (this.provider._a(chunk) && this.rand.nextInt(100000) == 0 && this.isRaining() && this.isThundering()) {
                this.updateLCG = this.updateLCG * 3 + 1013904223;
                n7 = this.updateLCG >> 2;
                n6 = n8 + (n7 & 0xF);
                n5 = n9 + (n7 >> 8 & 0xF);
                n4 = this.getPrecipitationHeight(n6, n5);
                if (this.canLightningStrikeAt(n6, n4, n5)) {
                    this.addWeatherEffect(new EntityLightningBolt(this, n6, n4, n5));
                }
            }
            this.theProfiler._c("iceandsnow");
            if (this.provider._b(chunk) && this.rand.nextInt(16) == 0) {
                Object object;
                this.updateLCG = this.updateLCG * 3 + 1013904223;
                n7 = this.updateLCG >> 2;
                n6 = n7 & 0xF;
                n5 = n7 >> 8 & 0xF;
                n4 = this.getPrecipitationHeight(n6 + n8, n5 + n9);
                if (this.isBlockFreezableNaturally(n6 + n8, n4 - 1, n5 + n9)) {
                    this.setBlock(n6 + n8, n4 - 1, n5 + n9, Block.ice.blockID);
                }
                if (this.isRaining() && this.canSnowAt(n6 + n8, n4, n5 + n9)) {
                    this.setBlock(n6 + n8, n4, n5 + n9, Block.snow.blockID);
                }
                if (this.isRaining() && ((BiomeGenBase)(object = this.getBiomeGenForCoords(n6 + n8, n5 + n9)))._e() && (n3 = this.getBlockId(n6 + n8, n4 - 1, n5 + n9)) != 0) {
                    Block.blocksList[n3].fillWithRain(this, n6 + n8, n4 - 1, n5 + n9);
                }
            }
            this.theProfiler._c("tickTiles");
            for (ujzm ujzm2 : chunk._b()) {
                if (ujzm2 == null || !ujzm2._b()) continue;
                for (int i = 0; i < 3; ++i) {
                    this.updateLCG = this.updateLCG * 3 + 1013904223;
                    n3 = this.updateLCG >> 2;
                    int n10 = n3 & 0xF;
                    int n11 = n3 >> 8 & 0xF;
                    int n12 = n3 >> 16 & 0xF;
                    int n13 = ujzm2._a(n10, n12, n11);
                    ++n2;
                    Block block = Block.blocksList[n13];
                    if (block == null || !block.getTickRandomly()) continue;
                    ++n;
                    block.updateTick(this, n10 + n8, n12 + ujzm2._c(), n11 + n9, this.rand);
                }
            }
            this.theProfiler._b();
        }
    }

    @Override
    public boolean isBlockTickScheduledThisTick(int n, int n2, int n3, int n4) {
        cfex cfex2 = new cfex(n, n2, n3, n4);
        return this.pendingTickListEntriesThisTick.contains(cfex2);
    }

    @Override
    public void scheduleBlockUpdate(int n, int n2, int n3, int n4, int n5) {
        this.scheduleBlockUpdateWithPriority(n, n2, n3, n4, n5, 0);
    }

    @Override
    public void scheduleBlockUpdateWithPriority(int n, int n2, int n3, int n4, int n5, int n6) {
        cfex cfex2 = new cfex(n, n2, n3, n4);
        int n7 = 0;
        if (this.scheduledUpdatesAreImmediate && n4 > 0) {
            if (Block.blocksList[n4].func_82506_l()) {
                int n8;
                n7 = 8;
                if (this.checkChunksExist(cfex2._b - n7, cfex2._c - n7, cfex2._d - n7, cfex2._b + n7, cfex2._c + n7, cfex2._d + n7) && (n8 = this.getBlockId(cfex2._b, cfex2._c, cfex2._d)) == cfex2._e && n8 > 0) {
                    Block.blocksList[n8].updateTick(this, cfex2._b, cfex2._c, cfex2._d, this.rand);
                }
                return;
            }
            n5 = 1;
        }
        if (this.checkChunksExist(n - n7, n2 - n7, n3 - n7, n + n7, n2 + n7, n3 + n7)) {
            if (n4 > 0) {
                cfex2._a((long)n5 + this.worldInfo._f());
                cfex2._a(n6);
            }
            if (!this.pendingTickListEntriesHashSet.contains(cfex2)) {
                this.pendingTickListEntriesHashSet.add(cfex2);
                this.pendingTickListEntriesTreeSet.add(cfex2);
            }
        }
    }

    @Override
    public void scheduleBlockUpdateFromLoad(int n, int n2, int n3, int n4, int n5, int n6) {
        cfex cfex2 = new cfex(n, n2, n3, n4);
        cfex2._a(n6);
        if (n4 > 0) {
            cfex2._a((long)n5 + this.worldInfo._f());
        }
        if (!this.pendingTickListEntriesHashSet.contains(cfex2)) {
            this.pendingTickListEntriesHashSet.add(cfex2);
            this.pendingTickListEntriesTreeSet.add(cfex2);
        }
    }

    @Override
    public void updateEntities() {
        if (this.playerEntities.isEmpty() && this.getPersistentChunks().isEmpty()) {
            if (this.updateEntityTick++ >= 1200) {
                return;
            }
        } else {
            this.resetUpdateEntityTick();
        }
        super.updateEntities();
    }

    public void resetUpdateEntityTick() {
        this.updateEntityTick = 0;
    }

    @Override
    public boolean tickUpdates(boolean bl) {
        cfex cfex2;
        int n = this.pendingTickListEntriesTreeSet.size();
        if (n != this.pendingTickListEntriesHashSet.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if (n > 1000) {
            n = 1000;
        }
        this.theProfiler._a("cleaning");
        for (int i = 0; i < n; ++i) {
            cfex2 = (cfex)this.pendingTickListEntriesTreeSet.first();
            if (!bl && cfex2._f > this.worldInfo._f()) break;
            this.pendingTickListEntriesTreeSet.remove(cfex2);
            this.pendingTickListEntriesHashSet.remove(cfex2);
            this.pendingTickListEntriesThisTick.add(cfex2);
        }
        this.theProfiler._b();
        this.theProfiler._a("ticking");
        Iterator iterator2 = this.pendingTickListEntriesThisTick.iterator();
        while (iterator2.hasNext()) {
            cfex2 = (cfex)iterator2.next();
            iterator2.remove();
            int n2 = 0;
            if (this.checkChunksExist(cfex2._b - n2, cfex2._c - n2, cfex2._d - n2, cfex2._b + n2, cfex2._c + n2, cfex2._d + n2)) {
                int n3 = this.getBlockId(cfex2._b, cfex2._c, cfex2._d);
                if (n3 <= 0 || !Block.isAssociatedBlockID(n3, cfex2._e)) continue;
                try {
                    Block.blocksList[n3].updateTick(this, cfex2._b, cfex2._c, cfex2._d, this.rand);
                    continue;
                }
                catch (Throwable throwable) {
                    int n4;
                    CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception while ticking a block");
                    CrashReportCategory crashReportCategory = crashReport.makeCategory("Block being ticked");
                    try {
                        n4 = this.getBlockMetadata(cfex2._b, cfex2._c, cfex2._d);
                    }
                    catch (Throwable throwable2) {
                        n4 = -1;
                    }
                    CrashReportCategory._a(crashReportCategory, cfex2._b, cfex2._c, cfex2._d, n3, n4);
                    throw new turb(crashReport);
                }
            }
            this.scheduleBlockUpdate(cfex2._b, cfex2._c, cfex2._d, cfex2._e, 0);
        }
        this.theProfiler._b();
        this.pendingTickListEntriesThisTick.clear();
        return !this.pendingTickListEntriesTreeSet.isEmpty();
    }

    @Override
    public List getPendingBlockUpdates(Chunk chunk, boolean bl) {
        ArrayList<cfex> arrayList = null;
        jjym jjym2 = chunk._k();
        int n = (jjym2._a << 4) - 2;
        int n2 = n + 16 + 2;
        int n3 = (jjym2._b << 4) - 2;
        int n4 = n3 + 16 + 2;
        for (int i = 0; i < 2; ++i) {
            Iterator iterator2;
            if (i == 0) {
                iterator2 = this.pendingTickListEntriesTreeSet.iterator();
            } else {
                iterator2 = this.pendingTickListEntriesThisTick.iterator();
                if (!this.pendingTickListEntriesThisTick.isEmpty()) {
                    System.out.println(this.pendingTickListEntriesThisTick.size());
                }
            }
            while (iterator2.hasNext()) {
                cfex cfex2 = (cfex)iterator2.next();
                if (cfex2._b < n || cfex2._b >= n2 || cfex2._d < n3 || cfex2._d >= n4) continue;
                if (bl) {
                    this.pendingTickListEntriesHashSet.remove(cfex2);
                    iterator2.remove();
                }
                if (arrayList == null) {
                    arrayList = new ArrayList<cfex>();
                }
                arrayList.add(cfex2);
            }
        }
        return arrayList;
    }

    @Override
    public void updateEntityWithOptionalForce(Entity entity, boolean bl) {
        if (!this.mcServer._Y() && (entity instanceof EntityAnimal || entity instanceof EntityWaterMob)) {
            entity.setDead();
        }
        if (!this.mcServer._Z() && entity instanceof vjsq) {
            entity.setDead();
        }
        super.updateEntityWithOptionalForce(entity, bl);
    }

    @Override
    public IChunkProvider createChunkProvider() {
        bcgt bcgt2 = this.saveHandler.getChunkLoader(this.provider);
        this.theChunkProviderServer = new fotf(this, bcgt2, this.provider._c());
        return this.theChunkProviderServer;
    }

    public List func_73049_a(int n, int n2, int n3, int n4, int n5, int n6) {
        ArrayList<TileEntity> arrayList = new ArrayList<TileEntity>();
        for (int i = n >> 4; i <= n4 >> 4; ++i) {
            for (int j = n3 >> 4; j <= n6 >> 4; ++j) {
                Chunk chunk = this.getChunkFromChunkCoords(i, j);
                if (chunk == null) continue;
                for (Object v : chunk._l.values()) {
                    TileEntity tileEntity = (TileEntity)v;
                    if (tileEntity.isInvalid() || tileEntity.xCoord < n || tileEntity.yCoord < n2 || tileEntity.zCoord < n3 || tileEntity.xCoord > n4 || tileEntity.yCoord > n5 || tileEntity.zCoord > n6) continue;
                    arrayList.add(tileEntity);
                }
            }
        }
        return arrayList;
    }

    @Override
    public boolean canMineBlock(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return super.canMineBlock(entityPlayer, n, n2, n3);
    }

    @Override
    public boolean canMineBlockBody(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return !this.mcServer._a(this, n, n2, n3, entityPlayer);
    }

    @Override
    public void initialize(WorldSettings worldSettings) {
        if (this.entityIdMap == null) {
            this.entityIdMap = new IntHashMap();
        }
        if (this.pendingTickListEntriesHashSet == null) {
            this.pendingTickListEntriesHashSet = new HashSet();
        }
        if (this.pendingTickListEntriesTreeSet == null) {
            this.pendingTickListEntriesTreeSet = new TreeSet();
        }
        this.createSpawnPosition(worldSettings);
        super.initialize(worldSettings);
    }

    public void createSpawnPosition(WorldSettings worldSettings) {
        if (!this.provider._e()) {
            this.worldInfo._a(0, this.provider._i(), 0);
        } else {
            this.findingSpawnPoint = true;
            WorldChunkManager worldChunkManager = this.provider._e;
            List list2 = worldChunkManager._a();
            Random random = new Random(this.getSeed());
            xtcd xtcd2 = worldChunkManager._a(0, 0, 256, list2, random);
            int n = 0;
            int n2 = this.provider._i();
            int n3 = 0;
            if (xtcd2 != null) {
                n = xtcd2._d;
                n3 = xtcd2._f;
            } else {
                this.getWorldLogAgent()._b("Unable to find spawn biome");
            }
            int n4 = 0;
            while (!this.provider._a(n, n3)) {
                n += random.nextInt(64) - random.nextInt(64);
                n3 += random.nextInt(64) - random.nextInt(64);
                if (++n4 != 1000) continue;
            }
            this.worldInfo._a(n, n2, n3);
            this.findingSpawnPoint = false;
            if (worldSettings._c()) {
                this.createBonusChest();
            }
        }
    }

    public void createBonusChest() {
        int n;
        int n2;
        int n3;
        ukai ukai2 = new ukai(ChestGenHooks.getItems("bonusChest", this.rand), ChestGenHooks.getCount("bonusChest", this.rand));
        for (int i = 0; i < 10 && !ukai2._a(this, this.rand, n3 = this.worldInfo._c() + this.rand.nextInt(6) - this.rand.nextInt(6), n2 = this.getTopSolidOrLiquidBlock(n3, n = this.worldInfo._e() + this.rand.nextInt(6) - this.rand.nextInt(6)) + 1, n); ++i) {
        }
    }

    public ChunkCoordinates getEntrancePortalLocation() {
        return this.provider._h();
    }

    public void saveAllChunks(boolean bl, sajz sajz2) throws xcad {
        if (this.chunkProvider._c()) {
            if (sajz2 != null) {
                sajz2._b("Saving level");
            }
            this.saveLevel();
            if (sajz2 != null) {
                sajz2._d("Saving chunks");
            }
            this.chunkProvider._a(bl, sajz2);
            MinecraftForge.EVENT_BUS.post(new WorldEvent.Save(this));
        }
    }

    public void saveChunkData() {
        if (this.chunkProvider._c()) {
            this.chunkProvider._a();
        }
    }

    public void saveLevel() throws xcad {
        this.checkSessionLock();
        this.saveHandler.saveWorldInfoWithPlayer(this.worldInfo, this.mcServer.__ag()._c());
        this.mapStorage._a();
        this.perWorldStorage._a();
    }

    @Override
    public void onEntityAdded(Entity entity) {
        super.onEntityAdded(entity);
        this.entityIdMap._a(entity.entityId, entity);
        Entity[] entityArray = entity.getParts();
        if (entityArray != null) {
            for (int i = 0; i < entityArray.length; ++i) {
                this.entityIdMap._a(entityArray[i].entityId, entityArray[i]);
            }
        }
    }

    @Override
    public void onEntityRemoved(Entity entity) {
        super.onEntityRemoved(entity);
        this.entityIdMap._f(entity.entityId);
        Entity[] entityArray = entity.getParts();
        if (entityArray != null) {
            for (int i = 0; i < entityArray.length; ++i) {
                this.entityIdMap._f(entityArray[i].entityId);
            }
        }
    }

    @Override
    public Entity getEntityByID(int n) {
        return (Entity)this.entityIdMap._b(n);
    }

    @Override
    public boolean addWeatherEffect(Entity entity) {
        if (super.addWeatherEffect(entity)) {
            this.mcServer.__ag()._a(entity.posX, entity.posY, entity.posZ, 512.0, this.provider._i, new dibg(entity));
            return true;
        }
        return false;
    }

    @Override
    public void setEntityState(Entity entity, byte by) {
        bszz bszz2 = new bszz(entity.entityId, by);
        this.getEntityTracker()._b(entity, bszz2);
    }

    @Override
    public Explosion newExplosion(Entity entity, double d, double d2, double d3, float f, boolean bl, boolean bl2) {
        Explosion explosion = new Explosion(this, entity, d, d2, d3, f);
        explosion._a = bl;
        explosion._b = bl2;
        explosion._a();
        explosion._a(false);
        if (!bl2) {
            explosion._k.clear();
        }
        for (EntityPlayer entityPlayer : this.playerEntities) {
            if (!(entityPlayer.getDistanceSq(d, d2, d3) < 4096.0)) continue;
            ((EntityPlayerMP)entityPlayer).playerNetServerHandler.func_72567_b(new ozcz(d, d2, d3, f, explosion._k, (Vec3)explosion._b().get(entityPlayer)));
        }
        return explosion;
    }

    @Override
    public void addBlockEvent(int n, int n2, int n3, int n4, int n5, int n6) {
        ejzh ejzh2;
        ejzh ejzh3 = new ejzh(n, n2, n3, n4, n5, n6);
        Iterator iterator2 = this.blockEventCache[this.blockEventCacheIndex].iterator();
        do {
            if (iterator2.hasNext()) continue;
            this.blockEventCache[this.blockEventCacheIndex].add(ejzh3);
            return;
        } while (!(ejzh2 = (ejzh)iterator2.next()).equals(ejzh3));
    }

    public void sendAndApplyBlockEvents() {
        while (!this.blockEventCache[this.blockEventCacheIndex].isEmpty()) {
            int n = this.blockEventCacheIndex;
            this.blockEventCacheIndex ^= 1;
            for (ejzh ejzh2 : this.blockEventCache[n]) {
                if (!this.onBlockEventReceived(ejzh2)) continue;
                this.mcServer.__ag()._a(ejzh2._a(), ejzh2._b(), ejzh2._c(), 64.0, this.provider._i, new ujsb(ejzh2._a(), ejzh2._b(), ejzh2._c(), ejzh2._f(), ejzh2._d(), ejzh2._e()));
            }
            this.blockEventCache[n].clear();
        }
    }

    public boolean onBlockEventReceived(ejzh ejzh2) {
        int n = this.getBlockId(ejzh2._a(), ejzh2._b(), ejzh2._c());
        return n == ejzh2._f() ? Block.blocksList[n].onBlockEventReceived(this, ejzh2._a(), ejzh2._b(), ejzh2._c(), ejzh2._d(), ejzh2._e()) : false;
    }

    public void flush() {
        this.saveHandler.flush();
    }

    @Override
    public void updateWeather() {
        boolean bl = this.isRaining();
        super.updateWeather();
        if (bl != this.isRaining()) {
            if (bl) {
                this.mcServer.__ag()._a(new Packet70GameEvent(2, 0));
            } else {
                this.mcServer.__ag()._a(new Packet70GameEvent(1, 0));
            }
        }
    }

    public MinecraftServer getMinecraftServer() {
        return this.mcServer;
    }

    public EntityTracker getEntityTracker() {
        return this.theEntityTracker;
    }

    public PlayerManager getPlayerManager() {
        return this.thePlayerManager;
    }

    public Teleporter getDefaultTeleporter() {
        return this.worldTeleporter;
    }

    public File getChunkSaveLocation() {
        return ((AnvilChunkLoader)this.theChunkProviderServer._d)._d;
    }
}

