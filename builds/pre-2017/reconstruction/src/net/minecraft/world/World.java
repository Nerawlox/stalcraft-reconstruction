/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import atomicstryker.dynamiclights.client.DynamicLights;
import com.google.common.collect.ImmutableSetMultimap;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.bundle.pidb;
import gloomyfolken.mods.ejection.ezey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mods.sound.SoundHooks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.logging.ILogAgent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3Pool;
import net.minecraft.util.owak;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import net.minecraft.village.VillageCollection;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeDummyContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.WorldSpecificSaveHandler;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import org.jetbrains.annotations.Nullable;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public abstract class World
implements IBlockAccess {
    public static double MAX_ENTITY_RADIUS = 2.0;
    public final MapStorage perWorldStorage;
    public boolean scheduledUpdatesAreImmediate;
    public List loadedEntityList = new ArrayList();
    public List unloadedEntityList = new ArrayList();
    public List loadedTileEntityList = new ArrayList();
    public List addedTileEntityList = new ArrayList();
    public List entityRemoval = new ArrayList();
    public List playerEntities = new ArrayList();
    public List weatherEffects = new ArrayList();
    public long cloudColour = 0xFFFFFFL;
    public int skylightSubtracted;
    public int updateLCG = new Random().nextInt();
    public final int DIST_HASH_MAGIC = 1013904223;
    public float prevRainingStrength;
    public float rainingStrength;
    public float prevThunderingStrength;
    public float thunderingStrength;
    public int lastLightningBolt;
    public int difficultySetting;
    public Random rand = new Random();
    public final WorldProvider provider;
    public List worldAccesses = new ArrayList();
    public IChunkProvider chunkProvider;
    public final ISaveHandler saveHandler;
    public WorldInfo worldInfo;
    public boolean findingSpawnPoint;
    public MapStorage mapStorage;
    public VillageCollection villageCollectionObj;
    public final rapl villageSiegeObj = new rapl(this);
    public final fokl theProfiler;
    public final ThreadLocal<Vec3Pool> J = new ThreadLocal();
    public final Calendar theCalendar = Calendar.getInstance();
    public Scoreboard worldScoreboard = new Scoreboard();
    public final ILogAgent worldLogAgent;
    public ArrayList collidingBoundingBoxes = new ArrayList();
    public boolean scanningTileEntities;
    public boolean spawnHostileMobs = true;
    public boolean spawnPeacefulMobs = true;
    public Set activeChunkSet = new HashSet();
    public int ambientTickCountdown;
    public int[] lightUpdateBlockList;
    public boolean isRemote;
    public static MapStorage s_mapStorage;
    public static ISaveHandler s_savehandler;

    @Override
    public BiomeGenBase getBiomeGenForCoords(int n, int n2) {
        return this.provider._c(n, n2);
    }

    public BiomeGenBase getBiomeGenForCoordsBody(int n, int n2) {
        Chunk chunk;
        if (this.blockExists(n, 0, n2) && (chunk = this.getChunkFromBlockCoords(n, n2)) != null) {
            return chunk._a(n & 0xF, n2 & 0xF, this.provider._e);
        }
        return this.provider._e._a(n, n2);
    }

    public WorldChunkManager getWorldChunkManager() {
        return this.provider._e;
    }

    @SideOnly(value=Side.CLIENT)
    public World(ISaveHandler iSaveHandler, String string, WorldProvider worldProvider, WorldSettings worldSettings, fokl fokl2, ILogAgent iLogAgent) {
        this.J.set(new Vec3Pool(300, 2000));
        this.ambientTickCountdown = this.rand.nextInt(12000);
        this.lightUpdateBlockList = new int[32768];
        this.saveHandler = iSaveHandler;
        this.theProfiler = fokl2;
        this.worldInfo = new WorldInfo(worldSettings, string);
        this.provider = worldProvider;
        this.perWorldStorage = new MapStorage(null);
        this.worldLogAgent = iLogAgent;
    }

    @SideOnly(value=Side.CLIENT)
    public void finishSetup() {
        VillageCollection villageCollection = (VillageCollection)this.mapStorage._a(VillageCollection.class, "villages");
        if (villageCollection == null) {
            this.villageCollectionObj = new VillageCollection(this);
            this.mapStorage._a("villages", this.villageCollectionObj);
        } else {
            this.villageCollectionObj = villageCollection;
            this.villageCollectionObj._a(this);
        }
        int n = this.provider._i;
        this.provider._a(this);
        this.provider._i = n;
        this.chunkProvider = this.createChunkProvider();
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
    }

    public World(ISaveHandler iSaveHandler, String string, WorldSettings worldSettings, WorldProvider worldProvider, fokl fokl2, ILogAgent iLogAgent) {
        VillageCollection villageCollection;
        this.J.set(new Vec3Pool(300, 2000));
        this.ambientTickCountdown = this.rand.nextInt(12000);
        this.lightUpdateBlockList = new int[32768];
        this.saveHandler = iSaveHandler;
        this.theProfiler = fokl2;
        this.mapStorage = this.getMapStorage(iSaveHandler);
        this.worldLogAgent = iLogAgent;
        this.worldInfo = iSaveHandler.loadWorldInfo();
        this.provider = worldProvider != null ? worldProvider : (this.worldInfo != null && this.worldInfo._j() != 0 ? WorldProvider._a(this.worldInfo._j()) : WorldProvider._a(0));
        if (this.worldInfo == null) {
            this.worldInfo = new WorldInfo(worldSettings, string);
        } else {
            this.worldInfo._a(string);
        }
        this.provider._a(this);
        this.chunkProvider = this.createChunkProvider();
        this.perWorldStorage = this instanceof WorldServer ? new MapStorage(new WorldSpecificSaveHandler((WorldServer)this, iSaveHandler)) : new MapStorage(null);
        if (!this.worldInfo._w()) {
            try {
                this.initialize(worldSettings);
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception initializing level");
                try {
                    this.addWorldInfoToCrashReport(crashReport);
                }
                catch (Throwable throwable2) {
                    // empty catch block
                }
                throw new turb(crashReport);
            }
            this.worldInfo._c(true);
        }
        if ((villageCollection = (VillageCollection)this.perWorldStorage._a(VillageCollection.class, "villages")) == null) {
            this.villageCollectionObj = new VillageCollection(this);
            this.perWorldStorage._a("villages", this.villageCollectionObj);
        } else {
            this.villageCollectionObj = villageCollection;
            this.villageCollectionObj._a(this);
        }
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
    }

    public MapStorage getMapStorage(ISaveHandler iSaveHandler) {
        if (s_savehandler != iSaveHandler || s_mapStorage == null) {
            s_mapStorage = new MapStorage(iSaveHandler);
            s_savehandler = iSaveHandler;
        }
        return s_mapStorage;
    }

    public abstract IChunkProvider createChunkProvider();

    public void initialize(WorldSettings worldSettings) {
        this.worldInfo._c(true);
    }

    @SideOnly(value=Side.CLIENT)
    public void setSpawnLocation() {
        this.setSpawnLocation(8, 64, 8);
    }

    public int getFirstUncoveredBlock(int n, int n2) {
        int n3 = 63;
        while (!this.isAirBlock(n, n3 + 1, n2)) {
            ++n3;
        }
        return this.getBlockId(n, n3, n2);
    }

    @Override
    public int getBlockId(int n, int n2, int n3) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            if (n2 < 0) {
                return 0;
            }
            if (n2 >= 256) {
                return 0;
            }
            Chunk chunk = null;
            try {
                chunk = this.getChunkFromChunkCoords(n >> 4, n3 >> 4);
                return chunk._d(n & 0xF, n2, n3 & 0xF);
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception getting block type in world");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Requested block coordinates");
                crashReportCategory._a("Found chunk", chunk == null);
                crashReportCategory._a("Location", CrashReportCategory._a(n, n2, n3));
                throw new turb(crashReport);
            }
        }
        return 0;
    }

    @Override
    public boolean isAirBlock(int n, int n2, int n3) {
        int n4 = this.getBlockId(n, n2, n3);
        return n4 == 0 || Block.blocksList[n4] == null || Block.blocksList[n4].isAirBlock(this, n, n2, n3);
    }

    public boolean blockHasTileEntity(int n, int n2, int n3) {
        int n4 = this.getBlockId(n, n2, n3);
        int n5 = this.getBlockMetadata(n, n2, n3);
        return Block.blocksList[n4] != null && Block.blocksList[n4].hasTileEntity(n5);
    }

    public int blockGetRenderType(int n, int n2, int n3) {
        int n4 = this.getBlockId(n, n2, n3);
        return Block.blocksList[n4] != null ? Block.blocksList[n4].getRenderType() : -1;
    }

    public boolean blockExists(int n, int n2, int n3) {
        return n2 >= 0 && n2 < 256 ? this.chunkExists(n >> 4, n3 >> 4) : false;
    }

    public boolean doChunksNearChunkExist(int n, int n2, int n3, int n4) {
        return this.checkChunksExist(n - n4, n2 - n4, n3 - n4, n + n4, n2 + n4, n3 + n4);
    }

    public boolean checkChunksExist(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n5 >= 0 && n2 < 256) {
            n3 >>= 4;
            n4 >>= 4;
            n6 >>= 4;
            for (int i = n >>= 4; i <= n4; ++i) {
                for (int j = n3; j <= n6; ++j) {
                    if (this.chunkExists(i, j)) continue;
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean chunkExists(int n, int n2) {
        return this.chunkProvider._c(n, n2);
    }

    public Chunk getChunkFromBlockCoords(int n, int n2) {
        return this.getChunkFromChunkCoords(n >> 4, n2 >> 4);
    }

    public Chunk getChunkFromChunkCoords(int n, int n2) {
        return this.chunkProvider._b(n, n2);
    }

    public boolean setBlock(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            if (n2 < 0) {
                return false;
            }
            if (n2 >= 256) {
                return false;
            }
            Chunk chunk = this.getChunkFromChunkCoords(n >> 4, n3 >> 4);
            int n7 = 0;
            if ((n6 & 1) != 0) {
                n7 = chunk._d(n & 0xF, n2, n3 & 0xF);
            }
            boolean bl = chunk._a(n & 0xF, n2, n3 & 0xF, n4, n5);
            this.theProfiler._a("checkLight");
            this.updateAllLightTypes(n, n2, n3);
            this.theProfiler._b();
            if (bl) {
                if (!((n6 & 2) == 0 || this.isRemote && (n6 & 4) != 0)) {
                    this.markBlockForUpdate(n, n2, n3);
                }
                if (!this.isRemote && (n6 & 1) != 0) {
                    this.notifyBlockChange(n, n2, n3, n7);
                    Block block = Block.blocksList[n4];
                    if (block != null && block.hasComparatorInputOverride()) {
                        this.func_96440_m(n, n2, n3, n4);
                    }
                }
            }
            return bl;
        }
        return false;
    }

    @Override
    public Material getBlockMaterial(int n, int n2, int n3) {
        int n4 = this.getBlockId(n, n2, n3);
        return n4 == 0 ? Material._a : Block.blocksList[n4].blockMaterial;
    }

    @Override
    public int getBlockMetadata(int n, int n2, int n3) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            if (n2 < 0) {
                return 0;
            }
            if (n2 >= 256) {
                return 0;
            }
            Chunk chunk = this.getChunkFromChunkCoords(n >> 4, n3 >> 4);
            return chunk._e(n &= 0xF, n2, n3 &= 0xF);
        }
        return 0;
    }

    public boolean func_72921_c(int n, int n2, int n3, int n4, int n5) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            int n6;
            int n7;
            if (n2 < 0) {
                return false;
            }
            if (n2 >= 256) {
                return false;
            }
            Chunk chunk = this.getChunkFromChunkCoords(n >> 4, n3 >> 4);
            boolean bl = chunk._b(n7 = n & 0xF, n2, n6 = n3 & 0xF, n4);
            if (bl) {
                int n8 = chunk._d(n7, n2, n6);
                if (!((n5 & 2) == 0 || this.isRemote && (n5 & 4) != 0)) {
                    this.markBlockForUpdate(n, n2, n3);
                }
                if (!this.isRemote && (n5 & 1) != 0) {
                    this.notifyBlockChange(n, n2, n3, n8);
                    Block block = Block.blocksList[n8];
                    if (block != null && block.hasComparatorInputOverride()) {
                        this.func_96440_m(n, n2, n3, n8);
                    }
                }
            }
            return bl;
        }
        return false;
    }

    public boolean setBlockToAir(int n, int n2, int n3) {
        return this.setBlock(n, n2, n3, 0, 0, 3);
    }

    public boolean destroyBlock(int n, int n2, int n3, boolean bl) {
        int n4 = this.getBlockId(n, n2, n3);
        if (n4 > 0) {
            int n5 = this.getBlockMetadata(n, n2, n3);
            this.playAuxSFX(2001, n, n2, n3, n4 + (n5 << 12));
            if (bl) {
                Block.blocksList[n4].dropBlockAsItem(this, n, n2, n3, n5, 0);
            }
            return this.setBlock(n, n2, n3, 0, 0, 3);
        }
        return false;
    }

    public boolean setBlock(int n, int n2, int n3, int n4) {
        return this.setBlock(n, n2, n3, n4, 0, 3);
    }

    public void markBlockForUpdate(int n, int n2, int n3) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            ((IWorldAccess)this.worldAccesses.get(i))._b(n, n2, n3);
        }
    }

    public void notifyBlockChange(int n, int n2, int n3, int n4) {
        this.notifyBlocksOfNeighborChange(n, n2, n3, n4);
    }

    public void markBlocksDirtyVertical(int n, int n2, int n3, int n4) {
        int n5;
        if (n3 > n4) {
            n5 = n4;
            n4 = n3;
            n3 = n5;
        }
        if (!this.provider._g) {
            for (n5 = n3; n5 <= n4; ++n5) {
                this.updateLightByType(EnumSkyBlock._a, n, n5, n2);
            }
        }
        this.markBlockRangeForRenderUpdate(n, n3, n2, n, n4, n2);
    }

    public void markBlockRangeForRenderUpdate(int n, int n2, int n3, int n4, int n5, int n6) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            ((IWorldAccess)this.worldAccesses.get(i))._b(n, n2, n3, n4, n5, n6);
        }
    }

    public void notifyBlocksOfNeighborChange(int n, int n2, int n3, int n4) {
        this.notifyBlockOfNeighborChange(n - 1, n2, n3, n4);
        this.notifyBlockOfNeighborChange(n + 1, n2, n3, n4);
        this.notifyBlockOfNeighborChange(n, n2 - 1, n3, n4);
        this.notifyBlockOfNeighborChange(n, n2 + 1, n3, n4);
        this.notifyBlockOfNeighborChange(n, n2, n3 - 1, n4);
        this.notifyBlockOfNeighborChange(n, n2, n3 + 1, n4);
    }

    public void notifyBlocksOfNeighborChange(int n, int n2, int n3, int n4, int n5) {
        if (n5 != 4) {
            this.notifyBlockOfNeighborChange(n - 1, n2, n3, n4);
        }
        if (n5 != 5) {
            this.notifyBlockOfNeighborChange(n + 1, n2, n3, n4);
        }
        if (n5 != 0) {
            this.notifyBlockOfNeighborChange(n, n2 - 1, n3, n4);
        }
        if (n5 != 1) {
            this.notifyBlockOfNeighborChange(n, n2 + 1, n3, n4);
        }
        if (n5 != 2) {
            this.notifyBlockOfNeighborChange(n, n2, n3 - 1, n4);
        }
        if (n5 != 3) {
            this.notifyBlockOfNeighborChange(n, n2, n3 + 1, n4);
        }
    }

    public void notifyBlockOfNeighborChange(int n, int n2, int n3, int n4) {
        int n5;
        Block block;
        if (!this.isRemote && (block = Block.blocksList[n5 = this.getBlockId(n, n2, n3)]) != null) {
            try {
                block.onNeighborBlockChange(this, n, n2, n3, n4);
            }
            catch (Throwable throwable) {
                int n6;
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception while updating neighbours");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Block being updated");
                try {
                    n6 = this.getBlockMetadata(n, n2, n3);
                }
                catch (Throwable throwable2) {
                    n6 = -1;
                }
                crashReportCategory._a("Source block type", new ywfb(this, n4));
                CrashReportCategory._a(crashReportCategory, n, n2, n3, n5, n6);
                throw new turb(crashReport);
            }
        }
    }

    public boolean isBlockTickScheduledThisTick(int n, int n2, int n3, int n4) {
        return false;
    }

    public boolean canBlockSeeTheSky(int n, int n2, int n3) {
        return this.getChunkFromChunkCoords(n >> 4, n3 >> 4)._f(n & 0xF, n2, n3 & 0xF);
    }

    public int getFullBlockLightValue(int n, int n2, int n3) {
        if (n2 < 0) {
            return 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        return this.getChunkFromChunkCoords(n >> 4, n3 >> 4)._c(n & 0xF, n2, n3 & 0xF, 0);
    }

    public int getBlockLightValue(int n, int n2, int n3) {
        return this.getBlockLightValue_do(n, n2, n3, true);
    }

    public int getBlockLightValue_do(int n, int n2, int n3, boolean bl) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            int n4;
            if (bl && Block.useNeighborBrightness[n4 = this.getBlockId(n, n2, n3)]) {
                int n5 = this.getBlockLightValue_do(n, n2 + 1, n3, false);
                int n6 = this.getBlockLightValue_do(n + 1, n2, n3, false);
                int n7 = this.getBlockLightValue_do(n - 1, n2, n3, false);
                int n8 = this.getBlockLightValue_do(n, n2, n3 + 1, false);
                int n9 = this.getBlockLightValue_do(n, n2, n3 - 1, false);
                if (n6 > n5) {
                    n5 = n6;
                }
                if (n7 > n5) {
                    n5 = n7;
                }
                if (n8 > n5) {
                    n5 = n8;
                }
                if (n9 > n5) {
                    n5 = n9;
                }
                return n5;
            }
            if (n2 < 0) {
                return 0;
            }
            if (n2 >= 256) {
                n2 = 255;
            }
            Chunk chunk = this.getChunkFromChunkCoords(n >> 4, n3 >> 4);
            return chunk._c(n &= 0xF, n2, n3 &= 0xF, this.skylightSubtracted);
        }
        return 15;
    }

    public int getHeightValue(int n, int n2) {
        if (n >= -30000000 && n2 >= -30000000 && n < 30000000 && n2 < 30000000) {
            if (!this.chunkExists(n >> 4, n2 >> 4)) {
                return 0;
            }
            Chunk chunk = this.getChunkFromChunkCoords(n >> 4, n2 >> 4);
            return chunk._b(n & 0xF, n2 & 0xF);
        }
        return 0;
    }

    public int getChunkHeightMapMinimum(int n, int n2) {
        if (n >= -30000000 && n2 >= -30000000 && n < 30000000 && n2 < 30000000) {
            if (!this.chunkExists(n >> 4, n2 >> 4)) {
                return 0;
            }
            Chunk chunk = this.getChunkFromChunkCoords(n >> 4, n2 >> 4);
            return chunk._s;
        }
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public int getSkyBlockTypeBrightness(EnumSkyBlock enumSkyBlock, int n, int n2, int n3) {
        if (this.provider._g && enumSkyBlock == EnumSkyBlock._a) {
            return 0;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= 256) {
            return enumSkyBlock._c;
        }
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            int n4 = n >> 4;
            int n5 = n3 >> 4;
            if (!this.chunkExists(n4, n5)) {
                return enumSkyBlock._c;
            }
            if (Block.useNeighborBrightness[this.getBlockId(n, n2, n3)]) {
                int n6 = this.getSavedLightValue(enumSkyBlock, n, n2 + 1, n3);
                int n7 = this.getSavedLightValue(enumSkyBlock, n + 1, n2, n3);
                int n8 = this.getSavedLightValue(enumSkyBlock, n - 1, n2, n3);
                int n9 = this.getSavedLightValue(enumSkyBlock, n, n2, n3 + 1);
                int n10 = this.getSavedLightValue(enumSkyBlock, n, n2, n3 - 1);
                if (n7 > n6) {
                    n6 = n7;
                }
                if (n8 > n6) {
                    n6 = n8;
                }
                if (n9 > n6) {
                    n6 = n9;
                }
                if (n10 > n6) {
                    n6 = n10;
                }
                return n6;
            }
            Chunk chunk = this.getChunkFromChunkCoords(n4, n5);
            return chunk._a(enumSkyBlock, n & 0xF, n2, n3 & 0xF);
        }
        return enumSkyBlock._c;
    }

    public int getSavedLightValue(EnumSkyBlock enumSkyBlock, int n, int n2, int n3) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            int n4 = n >> 4;
            int n5 = n3 >> 4;
            if (!this.chunkExists(n4, n5)) {
                return enumSkyBlock._c;
            }
            Chunk chunk = this.getChunkFromChunkCoords(n4, n5);
            return chunk._a(enumSkyBlock, n & 0xF, n2, n3 & 0xF);
        }
        return enumSkyBlock._c;
    }

    public void setLightValue(EnumSkyBlock enumSkyBlock, int n, int n2, int n3, int n4) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000 && n2 >= 0 && n2 < 256 && this.chunkExists(n >> 4, n3 >> 4)) {
            Chunk chunk = this.getChunkFromChunkCoords(n >> 4, n3 >> 4);
            chunk._a(enumSkyBlock, n & 0xF, n2, n3 & 0xF, n4);
            for (int i = 0; i < this.worldAccesses.size(); ++i) {
                ((IWorldAccess)this.worldAccesses.get(i))._c(n, n2, n3);
            }
        }
    }

    public void markBlockForRenderUpdate(int n, int n2, int n3) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            ((IWorldAccess)this.worldAccesses.get(i))._c(n, n2, n3);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getLightBrightnessForSkyBlocks(int n, int n2, int n3, int n4) {
        int n5 = this.getSkyBlockTypeBrightness(EnumSkyBlock._a, n, n2, n3);
        int n6 = this.getSkyBlockTypeBrightness(EnumSkyBlock._b, n, n2, n3);
        if (n6 < n4) {
            n6 = n4;
        }
        return n5 << 20 | n6 << 4;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float getBrightness(int n, int n2, int n3, int n4) {
        int n5 = this.getBlockLightValue(n, n2, n3);
        if (n5 < n4) {
            n5 = n4;
        }
        return this.provider._h[n5];
    }

    @Override
    public float getLightBrightness(int n, int n2, int n3) {
        return this.provider._h[this.getBlockLightValue(n, n2, n3)];
    }

    public boolean isDaytime() {
        return this.provider._t();
    }

    public MovingObjectPosition func_72933_a(Vec3 vec3, Vec3 vec32) {
        return this.func_72831_a(vec3, vec32, false, false);
    }

    public MovingObjectPosition func_72901_a(Vec3 vec3, Vec3 vec32, boolean bl) {
        return this.func_72831_a(vec3, vec32, bl, false);
    }

    @Nullable
    public MovingObjectPosition func_72831_a(Vec3 vec3, Vec3 vec32, boolean bl, boolean bl2) {
        if (!(Double.isNaN(vec3._c) || Double.isNaN(vec3._d) || Double.isNaN(vec3._e))) {
            if (!(Double.isNaN(vec32._c) || Double.isNaN(vec32._d) || Double.isNaN(vec32._e))) {
                MovingObjectPosition movingObjectPosition;
                int n = sajh._c(vec32._c);
                int n2 = sajh._c(vec32._d);
                int n3 = sajh._c(vec32._e);
                int n4 = sajh._c(vec3._c);
                int n5 = sajh._c(vec3._d);
                int n6 = sajh._c(vec3._e);
                int n7 = this.getBlockId(n4, n5, n6);
                int n8 = this.getBlockMetadata(n4, n5, n6);
                Block block = Block.blocksList[n7];
                if (block != null && (!bl2 || block == null || block.getCollisionBoundingBoxFromPool(this, n4, n5, n6) != null) && n7 > 0 && block.canCollideCheck(n8, bl) && (movingObjectPosition = block.collisionRayTrace(this, n4, n5, n6, vec3, vec32)) != null) {
                    return movingObjectPosition;
                }
                n7 = 200;
                while (n7-- >= 0) {
                    MovingObjectPosition movingObjectPosition2;
                    int n9;
                    if (Double.isNaN(vec3._c) || Double.isNaN(vec3._d) || Double.isNaN(vec3._e)) {
                        return null;
                    }
                    if (n4 == n && n5 == n2 && n6 == n3) {
                        return null;
                    }
                    boolean bl3 = true;
                    boolean bl4 = true;
                    boolean bl5 = true;
                    double d = 999.0;
                    double d2 = 999.0;
                    double d3 = 999.0;
                    if (n > n4) {
                        d = (double)n4 + 1.0;
                    } else if (n < n4) {
                        d = (double)n4 + 0.0;
                    } else {
                        bl3 = false;
                    }
                    if (n2 > n5) {
                        d2 = (double)n5 + 1.0;
                    } else if (n2 < n5) {
                        d2 = (double)n5 + 0.0;
                    } else {
                        bl4 = false;
                    }
                    if (n3 > n6) {
                        d3 = (double)n6 + 1.0;
                    } else if (n3 < n6) {
                        d3 = (double)n6 + 0.0;
                    } else {
                        bl5 = false;
                    }
                    double d4 = 999.0;
                    double d5 = 999.0;
                    double d6 = 999.0;
                    double d7 = vec32._c - vec3._c;
                    double d8 = vec32._d - vec3._d;
                    double d9 = vec32._e - vec3._e;
                    if (bl3) {
                        d4 = (d - vec3._c) / d7;
                    }
                    if (bl4) {
                        d5 = (d2 - vec3._d) / d8;
                    }
                    if (bl5) {
                        d6 = (d3 - vec3._e) / d9;
                    }
                    boolean bl6 = false;
                    if (d4 < d5 && d4 < d6) {
                        n9 = n > n4 ? 4 : 5;
                        vec3._c = d;
                        vec3._d += d8 * d4;
                        vec3._e += d9 * d4;
                    } else if (d5 < d6) {
                        n9 = n2 > n5 ? 0 : 1;
                        vec3._c += d7 * d5;
                        vec3._d = d2;
                        vec3._e += d9 * d5;
                    } else {
                        n9 = n3 > n6 ? 2 : 3;
                        vec3._c += d7 * d6;
                        vec3._d += d8 * d6;
                        vec3._e = d3;
                    }
                    Vec3 vec33 = this.getWorldVec3Pool()._a(vec3._c, vec3._d, vec3._e);
                    vec33._c = sajh._c(vec3._c);
                    n4 = (int)vec33._c;
                    if (n9 == 5) {
                        --n4;
                        vec33._c += 1.0;
                    }
                    vec33._d = sajh._c(vec3._d);
                    n5 = (int)vec33._d;
                    if (n9 == 1) {
                        --n5;
                        vec33._d += 1.0;
                    }
                    vec33._e = sajh._c(vec3._e);
                    n6 = (int)vec33._e;
                    if (n9 == 3) {
                        --n6;
                        vec33._e += 1.0;
                    }
                    int n10 = this.getBlockId(n4, n5, n6);
                    int n11 = this.getBlockMetadata(n4, n5, n6);
                    Block block2 = Block.blocksList[n10];
                    if (bl2 && block2 != null && block2.getCollisionBoundingBoxFromPool(this, n4, n5, n6) == null || n10 <= 0 || !block2.canCollideCheck(n11, bl) || (movingObjectPosition2 = block2.collisionRayTrace(this, n4, n5, n6, vec3, vec32)) == null) continue;
                    return movingObjectPosition2;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public void playSoundAtEntity(Entity entity, String string, float f, float f2) {
        boolean bl = SoundHooks.playSoundAtEntity(this, entity, string, f, f2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        PlaySoundAtEntityEvent playSoundAtEntityEvent = new PlaySoundAtEntityEvent(entity, string, f, f2);
        if (MinecraftForge.EVENT_BUS.post(playSoundAtEntityEvent)) {
            return;
        }
        string = playSoundAtEntityEvent.name;
        if (entity != null && string != null) {
            for (int i = 0; i < this.worldAccesses.size(); ++i) {
                ((IWorldAccess)this.worldAccesses.get(i))._a(string, entity.posX, entity.posY - (double)entity.yOffset, entity.posZ, f, f2);
            }
        }
    }

    public void playSoundToNearExcept(EntityPlayer entityPlayer, String string, float f, float f2) {
        boolean bl = SoundHooks.playSoundToNearExcept(this, entityPlayer, string, f, f2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        PlaySoundAtEntityEvent playSoundAtEntityEvent = new PlaySoundAtEntityEvent(entityPlayer, string, f, f2);
        if (MinecraftForge.EVENT_BUS.post(playSoundAtEntityEvent)) {
            return;
        }
        string = playSoundAtEntityEvent.name;
        if (entityPlayer != null && string != null) {
            for (int i = 0; i < this.worldAccesses.size(); ++i) {
                ((IWorldAccess)this.worldAccesses.get(i))._a(entityPlayer, string, entityPlayer.posX, entityPlayer.posY - (double)entityPlayer.yOffset, entityPlayer.posZ, f, f2);
            }
        }
    }

    public void playSoundEffect(double d, double d2, double d3, String string, float f, float f2) {
        if (string != null) {
            for (int i = 0; i < this.worldAccesses.size(); ++i) {
                ((IWorldAccess)this.worldAccesses.get(i))._a(string, d, d2, d3, f, f2);
            }
        }
    }

    public void playSound(double d, double d2, double d3, String string, float f, float f2, boolean bl) {
    }

    public void playRecord(String string, int n, int n2, int n3) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            ((IWorldAccess)this.worldAccesses.get(i))._a(string, n, n2, n3);
        }
    }

    public void spawnParticle(String string, double d, double d2, double d3, double d4, double d5, double d6) {
        int n = BlockRendererList.spawnParticle(this, string, d, d2, d3, d4, d5, d6);
        if (n != 0) {
            int n2 = n;
            return;
        }
        for (n = 0; n < this.worldAccesses.size(); ++n) {
            ((IWorldAccess)this.worldAccesses.get(n))._a(string, d, d2, d3, d4, d5, d6);
        }
    }

    public boolean addWeatherEffect(Entity entity) {
        this.weatherEffects.add(entity);
        return true;
    }

    public boolean spawnEntityInWorld(Entity entity) {
        int n = sajh._c(entity.posX / 16.0);
        int n2 = sajh._c(entity.posZ / 16.0);
        boolean bl = entity.forceSpawn;
        if (entity instanceof EntityPlayer) {
            bl = true;
        }
        if (!bl && !this.chunkExists(n, n2)) {
            return false;
        }
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            this.playerEntities.add(entityPlayer);
            this.updateAllPlayersSleepingFlag();
        }
        if (MinecraftForge.EVENT_BUS.post(new EntityJoinWorldEvent(entity, this)) && !bl) {
            return false;
        }
        this.getChunkFromChunkCoords(n, n2)._a(entity);
        this.loadedEntityList.add(entity);
        this.onEntityAdded(entity);
        return true;
    }

    public void onEntityAdded(Entity entity) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            ((IWorldAccess)this.worldAccesses.get(i))._b(entity);
        }
    }

    public void onEntityRemoved(Entity entity) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            ((IWorldAccess)this.worldAccesses.get(i))._c(entity);
        }
    }

    public void removeEntity(Entity entity) {
        if (entity.riddenByEntity != null) {
            entity.riddenByEntity.mountEntity(null);
        }
        if (entity.ridingEntity != null) {
            entity.mountEntity(null);
        }
        entity.setDead();
        if (entity instanceof EntityPlayer) {
            this.playerEntities.remove(entity);
            this.updateAllPlayersSleepingFlag();
        }
    }

    public void removePlayerEntityDangerously(Entity entity) {
        entity.setDead();
        if (entity instanceof EntityPlayer) {
            this.playerEntities.remove(entity);
            this.updateAllPlayersSleepingFlag();
        }
        int n = entity.chunkCoordX;
        int n2 = entity.chunkCoordZ;
        if (entity.addedToChunk && this.chunkExists(n, n2)) {
            this.getChunkFromChunkCoords(n, n2)._b(entity);
        }
        this.loadedEntityList.remove(entity);
        this.onEntityRemoved(entity);
    }

    public void addWorldAccess(IWorldAccess iWorldAccess) {
        this.worldAccesses.add(iWorldAccess);
    }

    public List getCollidingBoundingBoxes(Entity entity, AxisAlignedBB axisAlignedBB) {
        this.collidingBoundingBoxes.clear();
        int n = sajh._c(axisAlignedBB._b);
        int n2 = sajh._c(axisAlignedBB._e + 1.0);
        int n3 = sajh._c(axisAlignedBB._c);
        int n4 = sajh._c(axisAlignedBB._f + 1.0);
        int n5 = sajh._c(axisAlignedBB._d);
        int n6 = sajh._c(axisAlignedBB._g + 1.0);
        for (int i = n; i < n2; ++i) {
            for (int j = n5; j < n6; ++j) {
                if (!this.blockExists(i, 64, j)) continue;
                for (int k = n3 - 1; k < n4; ++k) {
                    Block block = Block.blocksList[this.getBlockId(i, k, j)];
                    if (block == null) continue;
                    block.addCollisionBoxesToList(this, i, k, j, axisAlignedBB, this.collidingBoundingBoxes, entity);
                }
            }
        }
        double d = 0.25;
        List list = this.getEntitiesWithinAABBExcludingEntity(entity, axisAlignedBB._b(d, d, d));
        for (int i = 0; i < list.size(); ++i) {
            AxisAlignedBB axisAlignedBB2 = ((Entity)list.get(i)).getBoundingBox();
            if (axisAlignedBB2 != null && axisAlignedBB2._b(axisAlignedBB)) {
                this.collidingBoundingBoxes.add(axisAlignedBB2);
            }
            if ((axisAlignedBB2 = entity.getCollisionBox((Entity)list.get(i))) == null || !axisAlignedBB2._b(axisAlignedBB)) continue;
            this.collidingBoundingBoxes.add(axisAlignedBB2);
        }
        return this.collidingBoundingBoxes;
    }

    public List getCollidingBlockBounds(AxisAlignedBB axisAlignedBB) {
        this.collidingBoundingBoxes.clear();
        int n = sajh._c(axisAlignedBB._b);
        int n2 = sajh._c(axisAlignedBB._e + 1.0);
        int n3 = sajh._c(axisAlignedBB._c);
        int n4 = sajh._c(axisAlignedBB._f + 1.0);
        int n5 = sajh._c(axisAlignedBB._d);
        int n6 = sajh._c(axisAlignedBB._g + 1.0);
        for (int i = n; i < n2; ++i) {
            for (int j = n5; j < n6; ++j) {
                if (!this.blockExists(i, 64, j)) continue;
                for (int k = n3 - 1; k < n4; ++k) {
                    Block block = Block.blocksList[this.getBlockId(i, k, j)];
                    if (block == null) continue;
                    block.addCollisionBoxesToList(this, i, k, j, axisAlignedBB, this.collidingBoundingBoxes, null);
                }
            }
        }
        return this.collidingBoundingBoxes;
    }

    public int calculateSkylightSubtracted(float f) {
        float f2 = this.getCelestialAngle(f);
        float f3 = 1.0f - (sajh._b(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.5f);
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        f3 = 1.0f - f3;
        f3 = (float)((double)f3 * (1.0 - (double)(this.getRainStrength(f) * 5.0f) / 16.0));
        f3 = (float)((double)f3 * (1.0 - (double)(this.getWeightedThunderStrength(f) * 5.0f) / 16.0));
        f3 = 1.0f - f3;
        return (int)(f3 * 11.0f);
    }

    @SideOnly(value=Side.CLIENT)
    public void removeWorldAccess(IWorldAccess iWorldAccess) {
        this.worldAccesses.remove(iWorldAccess);
    }

    @SideOnly(value=Side.CLIENT)
    public float getSunBrightness(float f) {
        float f2 = this.getCelestialAngle(f);
        float f3 = 1.0f - (sajh._b(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.2f);
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        f3 = 1.0f - f3;
        f3 = (float)((double)f3 * (1.0 - (double)(this.getRainStrength(f) * 5.0f) / 16.0));
        f3 = (float)((double)f3 * (1.0 - (double)(this.getWeightedThunderStrength(f) * 5.0f) / 16.0));
        return f3 * 0.8f + 0.2f;
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 getSkyColor(Entity entity, float f) {
        return ezey._a(this.provider._a(entity, f));
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 getSkyColorBody(Entity entity, float f) {
        float f2;
        float f3;
        float f4 = this.getCelestialAngle(f);
        float f5 = sajh._b(f4 * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        int n = sajh._c(entity.posX);
        int n2 = sajh._c(entity.posZ);
        int n3 = ForgeHooksClient.getSkyBlendColour(this, n, n2);
        float f6 = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n3 & 0xFF) / 255.0f;
        f6 *= f5;
        f7 *= f5;
        f8 *= f5;
        float f9 = this.getRainStrength(f);
        if (f9 > 0.0f) {
            f3 = (f6 * 0.3f + f7 * 0.59f + f8 * 0.11f) * 0.6f;
            f2 = 1.0f - f9 * 0.75f;
            f6 = f6 * f2 + f3 * (1.0f - f2);
            f7 = f7 * f2 + f3 * (1.0f - f2);
            f8 = f8 * f2 + f3 * (1.0f - f2);
        }
        if ((f3 = this.getWeightedThunderStrength(f)) > 0.0f) {
            f2 = (f6 * 0.3f + f7 * 0.59f + f8 * 0.11f) * 0.2f;
            float f10 = 1.0f - f3 * 0.75f;
            f6 = f6 * f10 + f2 * (1.0f - f10);
            f7 = f7 * f10 + f2 * (1.0f - f10);
            f8 = f8 * f10 + f2 * (1.0f - f10);
        }
        if (this.lastLightningBolt > 0) {
            f2 = (float)this.lastLightningBolt - f;
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            f6 = f6 * (1.0f - (f2 *= 0.45f)) + 0.8f * f2;
            f7 = f7 * (1.0f - f2) + 0.8f * f2;
            f8 = f8 * (1.0f - f2) + 1.0f * f2;
        }
        return this.getWorldVec3Pool()._a(f6, f7, f8);
    }

    public float getCelestialAngle(float f) {
        return this.provider._a(this.worldInfo._g(), f);
    }

    @SideOnly(value=Side.CLIENT)
    public int getMoonPhase() {
        return this.provider._a(this.worldInfo._g());
    }

    public float getCurrentMoonPhaseFactor() {
        return WorldProvider._a[this.provider._a(this.worldInfo._g())];
    }

    public float getCelestialAngleRadians(float f) {
        float f2 = this.getCelestialAngle(f);
        return f2 * (float)Math.PI * 2.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 getCloudColour(float f) {
        return this.provider._a(f);
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 drawCloudsBody(float f) {
        float f2;
        float f3;
        float f4 = this.getCelestialAngle(f);
        float f5 = sajh._b(f4 * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        float f6 = (float)(this.cloudColour >> 16 & 0xFFL) / 255.0f;
        float f7 = (float)(this.cloudColour >> 8 & 0xFFL) / 255.0f;
        float f8 = (float)(this.cloudColour & 0xFFL) / 255.0f;
        float f9 = this.getRainStrength(f);
        if (f9 > 0.0f) {
            f3 = (f6 * 0.3f + f7 * 0.59f + f8 * 0.11f) * 0.6f;
            f2 = 1.0f - f9 * 0.95f;
            f6 = f6 * f2 + f3 * (1.0f - f2);
            f7 = f7 * f2 + f3 * (1.0f - f2);
            f8 = f8 * f2 + f3 * (1.0f - f2);
        }
        f6 *= f5 * 0.9f + 0.1f;
        f7 *= f5 * 0.9f + 0.1f;
        f8 *= f5 * 0.85f + 0.15f;
        f3 = this.getWeightedThunderStrength(f);
        if (f3 > 0.0f) {
            f2 = (f6 * 0.3f + f7 * 0.59f + f8 * 0.11f) * 0.2f;
            float f10 = 1.0f - f3 * 0.95f;
            f6 = f6 * f10 + f2 * (1.0f - f10);
            f7 = f7 * f10 + f2 * (1.0f - f10);
            f8 = f8 * f10 + f2 * (1.0f - f10);
        }
        return this.getWorldVec3Pool()._a(f6, f7, f8);
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 getFogColor(float f) {
        float f2 = this.getCelestialAngle(f);
        return this.provider._b(f2, f);
    }

    public int getPrecipitationHeight(int n, int n2) {
        return this.getChunkFromBlockCoords(n, n2)._d(n & 0xF, n2 & 0xF);
    }

    public int getTopSolidOrLiquidBlock(int n, int n2) {
        Chunk chunk = this.getChunkFromBlockCoords(n, n2);
        int n3 = n;
        int n4 = n2;
        n &= 0xF;
        n2 &= 0xF;
        for (int i = chunk._a() + 15; i > 0; --i) {
            int n5 = chunk._d(n, i, n2);
            if (n5 == 0 || !Block.blocksList[n5].blockMaterial._c() || Block.blocksList[n5].blockMaterial == Material._j || Block.blocksList[n5].isBlockFoliage(this, n3, i, n4)) continue;
            return i + 1;
        }
        return -1;
    }

    @SideOnly(value=Side.CLIENT)
    public float getStarBrightness(float f) {
        return this.provider._b(f);
    }

    @SideOnly(value=Side.CLIENT)
    public float getStarBrightnessBody(float f) {
        float f2 = this.getCelestialAngle(f);
        float f3 = 1.0f - (sajh._b(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.25f);
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        return f3 * f3 * 0.5f;
    }

    public void scheduleBlockUpdate(int n, int n2, int n3, int n4, int n5) {
    }

    public void scheduleBlockUpdateWithPriority(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void scheduleBlockUpdateFromLoad(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void updateEntities() {
        Object object2;
        int n;
        CrashReportCategory crashReportCategory;
        CrashReport crashReport;
        Entity entity;
        int n2;
        if (GloomyHooks.getWorldInitialized(this)) {
            this.a.get(-1);
        }
        this.theProfiler._a("entities");
        this.theProfiler._a("global");
        for (n2 = 0; n2 < this.weatherEffects.size(); ++n2) {
            entity = (Entity)this.weatherEffects.get(n2);
            try {
                ++entity.ticksExisted;
                entity.onUpdate();
            }
            catch (Throwable throwable) {
                crashReport = CrashReport.makeCrashReport(throwable, "Ticking entity");
                crashReportCategory = crashReport.makeCategory("Entity being ticked");
                if (entity == null) {
                    crashReportCategory._a("Entity", "~~NULL~~");
                } else {
                    entity.addEntityCrashInfo(crashReportCategory);
                }
                if (ForgeDummyContainer.removeErroringEntities) {
                    FMLLog.severe(crashReport.getCompleteReport(), new Object[0]);
                    this.removeEntity(entity);
                }
                throw new turb(crashReport);
            }
            if (!entity.isDead) continue;
            this.weatherEffects.remove(n2--);
        }
        this.theProfiler._c("remove");
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (n2 = 0; n2 < this.unloadedEntityList.size(); ++n2) {
            entity = (Entity)this.unloadedEntityList.get(n2);
            int n3 = entity.chunkCoordX;
            n = entity.chunkCoordZ;
            if (!entity.addedToChunk || !this.chunkExists(n3, n)) continue;
            this.getChunkFromChunkCoords(n3, n)._b(entity);
        }
        for (n2 = 0; n2 < this.unloadedEntityList.size(); ++n2) {
            this.onEntityRemoved((Entity)this.unloadedEntityList.get(n2));
        }
        this.unloadedEntityList.clear();
        this.theProfiler._c("regular");
        for (n2 = 0; n2 < this.loadedEntityList.size(); ++n2) {
            entity = (Entity)this.loadedEntityList.get(n2);
            if (entity.ridingEntity != null) {
                if (!entity.ridingEntity.isDead && entity.ridingEntity.riddenByEntity == entity) continue;
                entity.ridingEntity.riddenByEntity = null;
                entity.ridingEntity = null;
            }
            this.theProfiler._a("tick");
            if (!entity.isDead) {
                try {
                    this.updateEntity(entity);
                }
                catch (Throwable throwable) {
                    crashReport = CrashReport.makeCrashReport(throwable, "Ticking entity");
                    crashReportCategory = crashReport.makeCategory("Entity being ticked");
                    entity.addEntityCrashInfo(crashReportCategory);
                    if (ForgeDummyContainer.removeErroringEntities) {
                        FMLLog.severe(crashReport.getCompleteReport(), new Object[0]);
                        this.removeEntity(entity);
                    }
                    throw new turb(crashReport);
                }
            }
            this.theProfiler._b();
            this.theProfiler._a("remove");
            if (entity.isDead) {
                int n4 = entity.chunkCoordX;
                n = entity.chunkCoordZ;
                if (entity.addedToChunk && this.chunkExists(n4, n)) {
                    this.getChunkFromChunkCoords(n4, n)._b(entity);
                }
                this.loadedEntityList.remove(n2--);
                this.onEntityRemoved(entity);
            }
            this.theProfiler._b();
        }
        this.theProfiler._c("tileEntities");
        this.scanningTileEntities = true;
        Iterator iterator2 = this.loadedTileEntityList.iterator();
        while (iterator2.hasNext()) {
            TileEntity tileEntity = (TileEntity)iterator2.next();
            if (!tileEntity.isInvalid() && tileEntity.hasWorldObj() && this.blockExists(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord)) {
                try {
                    GloomyHooks.startTileProfiling(tileEntity);
                    GloomyHooks.stopTileProfiling(tileEntity);
                    tileEntity.updateEntity();
                }
                catch (Throwable throwable) {
                    crashReport = CrashReport.makeCrashReport(throwable, "Ticking tile entity");
                    crashReportCategory = crashReport.makeCategory("Tile entity being ticked");
                    tileEntity.func_85027_a(crashReportCategory);
                    if (ForgeDummyContainer.removeErroringTileEntities) {
                        FMLLog.severe(crashReport.getCompleteReport(), new Object[0]);
                        tileEntity.invalidate();
                        this.setBlockToAir(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
                    }
                    throw new turb(crashReport);
                }
            }
            if (!tileEntity.isInvalid()) continue;
            iterator2.remove();
            if (!this.chunkExists(tileEntity.xCoord >> 4, tileEntity.zCoord >> 4) || (object2 = this.getChunkFromChunkCoords(tileEntity.xCoord >> 4, tileEntity.zCoord >> 4)) == null) continue;
            ((Chunk)object2)._i(tileEntity.xCoord & 0xF, tileEntity.yCoord, tileEntity.zCoord & 0xF);
        }
        if (!this.entityRemoval.isEmpty()) {
            for (Object object2 : this.entityRemoval) {
                ((TileEntity)object2).onChunkUnload();
            }
            this.loadedTileEntityList.removeAll(this.entityRemoval);
            this.entityRemoval.clear();
        }
        this.scanningTileEntities = false;
        this.theProfiler._c("pendingTileEntities");
        if (!this.addedTileEntityList.isEmpty()) {
            for (int i = 0; i < this.addedTileEntityList.size(); ++i) {
                Chunk chunk;
                object2 = (TileEntity)this.addedTileEntityList.get(i);
                if (!((TileEntity)object2).isInvalid()) {
                    if (this.loadedTileEntityList.contains(object2)) continue;
                    this.loadedTileEntityList.add(object2);
                    continue;
                }
                if (!this.chunkExists(((TileEntity)object2).xCoord >> 4, ((TileEntity)object2).zCoord >> 4) || (chunk = this.getChunkFromChunkCoords(((TileEntity)object2).xCoord >> 4, ((TileEntity)object2).zCoord >> 4)) == null) continue;
                chunk._i(((TileEntity)object2).xCoord & 0xF, ((TileEntity)object2).yCoord, ((TileEntity)object2).zCoord & 0xF);
            }
            this.addedTileEntityList.clear();
        }
        this.theProfiler._b();
        this.theProfiler._b();
    }

    public void addTileEntity(Collection collection) {
        List list2 = this.scanningTileEntities ? this.addedTileEntityList : this.loadedTileEntityList;
        for (Object e : collection) {
            if (!((TileEntity)e).canUpdate()) continue;
            list2.add(e);
        }
    }

    public void updateEntity(Entity entity) {
        this.updateEntityWithOptionalForce(entity, true);
    }

    public void updateEntityWithOptionalForce(Entity entity, boolean bl) {
        boolean bl2;
        int n = sajh._c(entity.posX);
        int n2 = sajh._c(entity.posZ);
        boolean bl3 = this.getPersistentChunks().containsKey(new jjym(n >> 4, n2 >> 4));
        int n3 = bl3 ? 0 : 32;
        boolean bl4 = bl2 = !bl || this.checkChunksExist(n - n3, 0, n2 - n3, n + n3, 0, n2 + n3);
        if (!bl2) {
            EntityEvent.CanUpdate canUpdate = new EntityEvent.CanUpdate(entity);
            MinecraftForge.EVENT_BUS.post(canUpdate);
            bl2 = canUpdate.canUpdate;
        }
        if (bl2) {
            entity.lastTickPosX = entity.posX;
            entity.lastTickPosY = entity.posY;
            entity.lastTickPosZ = entity.posZ;
            entity.prevRotationYaw = entity.rotationYaw;
            entity.prevRotationPitch = entity.rotationPitch;
            if (bl && entity.addedToChunk) {
                ++entity.ticksExisted;
                if (entity.ridingEntity != null) {
                    entity.updateRidden();
                } else {
                    entity.onUpdate();
                }
            }
            this.theProfiler._a("chunkCheck");
            if (Double.isNaN(entity.posX) || Double.isInfinite(entity.posX)) {
                entity.posX = entity.lastTickPosX;
            }
            if (Double.isNaN(entity.posY) || Double.isInfinite(entity.posY)) {
                entity.posY = entity.lastTickPosY;
            }
            if (Double.isNaN(entity.posZ) || Double.isInfinite(entity.posZ)) {
                entity.posZ = entity.lastTickPosZ;
            }
            if (Double.isNaN(entity.rotationPitch) || Double.isInfinite(entity.rotationPitch)) {
                entity.rotationPitch = entity.prevRotationPitch;
            }
            if (Double.isNaN(entity.rotationYaw) || Double.isInfinite(entity.rotationYaw)) {
                entity.rotationYaw = entity.prevRotationYaw;
            }
            int n4 = sajh._c(entity.posX / 16.0);
            int n5 = sajh._c(entity.posY / 16.0);
            int n6 = sajh._c(entity.posZ / 16.0);
            if (!entity.addedToChunk || entity.chunkCoordX != n4 || entity.chunkCoordY != n5 || entity.chunkCoordZ != n6) {
                if (entity.addedToChunk && this.chunkExists(entity.chunkCoordX, entity.chunkCoordZ)) {
                    this.getChunkFromChunkCoords(entity.chunkCoordX, entity.chunkCoordZ)._a(entity, entity.chunkCoordY);
                }
                if (this.chunkExists(n4, n6)) {
                    entity.addedToChunk = true;
                    this.getChunkFromChunkCoords(n4, n6)._a(entity);
                } else {
                    entity.addedToChunk = false;
                }
            }
            this.theProfiler._b();
            if (bl && entity.addedToChunk && entity.riddenByEntity != null) {
                if (!entity.riddenByEntity.isDead && entity.riddenByEntity.ridingEntity == entity) {
                    this.updateEntity(entity.riddenByEntity);
                } else {
                    entity.riddenByEntity.ridingEntity = null;
                    entity.riddenByEntity = null;
                }
            }
        }
    }

    public boolean checkNoEntityCollision(AxisAlignedBB axisAlignedBB) {
        return this.checkNoEntityCollision(axisAlignedBB, null);
    }

    public boolean checkNoEntityCollision(AxisAlignedBB axisAlignedBB, Entity entity) {
        List list2 = this.getEntitiesWithinAABBExcludingEntity(null, axisAlignedBB);
        for (int i = 0; i < list2.size(); ++i) {
            Entity entity2 = (Entity)list2.get(i);
            if (entity2.isDead || !entity2.preventEntitySpawning || entity2 == entity) continue;
            return false;
        }
        return true;
    }

    public boolean checkBlockCollision(AxisAlignedBB axisAlignedBB) {
        int n = sajh._c(axisAlignedBB._b);
        int n2 = sajh._c(axisAlignedBB._e + 1.0);
        int n3 = sajh._c(axisAlignedBB._c);
        int n4 = sajh._c(axisAlignedBB._f + 1.0);
        int n5 = sajh._c(axisAlignedBB._d);
        int n6 = sajh._c(axisAlignedBB._g + 1.0);
        if (axisAlignedBB._b < 0.0) {
            --n;
        }
        if (axisAlignedBB._c < 0.0) {
            --n3;
        }
        if (axisAlignedBB._d < 0.0) {
            --n5;
        }
        for (int i = n; i < n2; ++i) {
            for (int j = n3; j < n4; ++j) {
                for (int k = n5; k < n6; ++k) {
                    Block block = Block.blocksList[this.getBlockId(i, j, k)];
                    if (block == null) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAnyLiquid(AxisAlignedBB axisAlignedBB) {
        int n = sajh._c(axisAlignedBB._b);
        int n2 = sajh._c(axisAlignedBB._e + 1.0);
        int n3 = sajh._c(axisAlignedBB._c);
        int n4 = sajh._c(axisAlignedBB._f + 1.0);
        int n5 = sajh._c(axisAlignedBB._d);
        int n6 = sajh._c(axisAlignedBB._g + 1.0);
        if (axisAlignedBB._b < 0.0) {
            --n;
        }
        if (axisAlignedBB._c < 0.0) {
            --n3;
        }
        if (axisAlignedBB._d < 0.0) {
            --n5;
        }
        for (int i = n; i < n2; ++i) {
            for (int j = n3; j < n4; ++j) {
                for (int k = n5; k < n6; ++k) {
                    Block block = Block.blocksList[this.getBlockId(i, j, k)];
                    if (block == null || !block.blockMaterial._d()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBoundingBoxBurning(AxisAlignedBB axisAlignedBB) {
        int n;
        int n2 = sajh._c(axisAlignedBB._b);
        int n3 = sajh._c(axisAlignedBB._e + 1.0);
        int n4 = sajh._c(axisAlignedBB._c);
        int n5 = sajh._c(axisAlignedBB._f + 1.0);
        int n6 = sajh._c(axisAlignedBB._d);
        if (this.checkChunksExist(n2, n4, n6, n3, n5, n = sajh._c(axisAlignedBB._g + 1.0))) {
            for (int i = n2; i < n3; ++i) {
                for (int j = n4; j < n5; ++j) {
                    for (int k = n6; k < n; ++k) {
                        int n7 = this.getBlockId(i, j, k);
                        if (n7 == Block.fire.blockID || n7 == Block.lavaMoving.blockID || n7 == Block.lavaStill.blockID) {
                            return true;
                        }
                        Block block = Block.blocksList[n7];
                        if (block == null || !block.isBlockBurning(this, i, j, k)) continue;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean handleMaterialAcceleration(AxisAlignedBB axisAlignedBB, Material material, Entity entity) {
        int n;
        int n2 = sajh._c(axisAlignedBB._b);
        int n3 = sajh._c(axisAlignedBB._e + 1.0);
        int n4 = sajh._c(axisAlignedBB._c);
        int n5 = sajh._c(axisAlignedBB._f + 1.0);
        int n6 = sajh._c(axisAlignedBB._d);
        if (!this.checkChunksExist(n2, n4, n6, n3, n5, n = sajh._c(axisAlignedBB._g + 1.0))) {
            return false;
        }
        boolean bl = false;
        Vec3 vec3 = this.getWorldVec3Pool()._a(0.0, 0.0, 0.0);
        for (int i = n2; i < n3; ++i) {
            for (int j = n4; j < n5; ++j) {
                for (int k = n6; k < n; ++k) {
                    double d;
                    Block block = Block.blocksList[this.getBlockId(i, j, k)];
                    if (block == null || block.blockMaterial != material || !((double)n5 >= (d = (double)((float)(j + 1) - BlockFluid._a(this.getBlockMetadata(i, j, k)))))) continue;
                    bl = true;
                    block.velocityToAddToEntity(this, i, j, k, entity, vec3);
                }
            }
        }
        if (vec3._b() > 0.0 && entity.isPushedByWater()) {
            vec3 = vec3._a();
            double d = 0.014;
            entity.motionX += vec3._c * d;
            entity.motionY += vec3._d * d;
            entity.motionZ += vec3._e * d;
        }
        return bl;
    }

    public boolean isMaterialInBB(AxisAlignedBB axisAlignedBB, Material material) {
        int n = sajh._c(axisAlignedBB._b);
        int n2 = sajh._c(axisAlignedBB._e + 1.0);
        int n3 = sajh._c(axisAlignedBB._c);
        int n4 = sajh._c(axisAlignedBB._f + 1.0);
        int n5 = sajh._c(axisAlignedBB._d);
        int n6 = sajh._c(axisAlignedBB._g + 1.0);
        for (int i = n; i < n2; ++i) {
            for (int j = n3; j < n4; ++j) {
                for (int k = n5; k < n6; ++k) {
                    Block block = Block.blocksList[this.getBlockId(i, j, k)];
                    if (block == null || block.blockMaterial != material) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAABBInMaterial(AxisAlignedBB axisAlignedBB, Material material) {
        int n = sajh._c(axisAlignedBB._b);
        int n2 = sajh._c(axisAlignedBB._e + 1.0);
        int n3 = sajh._c(axisAlignedBB._c);
        int n4 = sajh._c(axisAlignedBB._f + 1.0);
        int n5 = sajh._c(axisAlignedBB._d);
        int n6 = sajh._c(axisAlignedBB._g + 1.0);
        for (int i = n; i < n2; ++i) {
            for (int j = n3; j < n4; ++j) {
                for (int k = n5; k < n6; ++k) {
                    Block block = Block.blocksList[this.getBlockId(i, j, k)];
                    if (block == null || block.blockMaterial != material) continue;
                    int n7 = this.getBlockMetadata(i, j, k);
                    double d = j + 1;
                    if (n7 < 8) {
                        d = (double)(j + 1) - (double)n7 / 8.0;
                    }
                    if (!(d >= axisAlignedBB._c)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public Explosion createExplosion(Entity entity, double d, double d2, double d3, float f, boolean bl) {
        return this.newExplosion(entity, d, d2, d3, f, false, bl);
    }

    public Explosion newExplosion(Entity entity, double d, double d2, double d3, float f, boolean bl, boolean bl2) {
        Explosion explosion = new Explosion(this, entity, d, d2, d3, f);
        explosion._a = bl;
        explosion._b = bl2;
        explosion._a();
        explosion._a(true);
        return explosion;
    }

    public float getBlockDensity(Vec3 vec3, AxisAlignedBB axisAlignedBB) {
        double d = 1.0 / ((axisAlignedBB._e - axisAlignedBB._b) * 2.0 + 1.0);
        double d2 = 1.0 / ((axisAlignedBB._f - axisAlignedBB._c) * 2.0 + 1.0);
        double d3 = 1.0 / ((axisAlignedBB._g - axisAlignedBB._d) * 2.0 + 1.0);
        int n = 0;
        int n2 = 0;
        float f = 0.0f;
        while (f <= 1.0f) {
            float f2 = 0.0f;
            while (f2 <= 1.0f) {
                float f3 = 0.0f;
                while (f3 <= 1.0f) {
                    double d4 = axisAlignedBB._b + (axisAlignedBB._e - axisAlignedBB._b) * (double)f;
                    double d5 = axisAlignedBB._c + (axisAlignedBB._f - axisAlignedBB._c) * (double)f2;
                    double d6 = axisAlignedBB._d + (axisAlignedBB._g - axisAlignedBB._d) * (double)f3;
                    if (this.func_72933_a(this.getWorldVec3Pool()._a(d4, d5, d6), vec3) == null) {
                        ++n;
                    }
                    ++n2;
                    f3 = (float)((double)f3 + d3);
                }
                f2 = (float)((double)f2 + d2);
            }
            f = (float)((double)f + d);
        }
        return (float)n / (float)n2;
    }

    public boolean extinguishFire(EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (this.getBlockId(n, n2, n3) == Block.fire.blockID) {
            this.playAuxSFXAtEntity(entityPlayer, 1004, n, n2, n3, 0);
            this.setBlockToAir(n, n2, n3);
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public String getDebugLoadedEntities() {
        return "All: " + this.loadedEntityList.size();
    }

    @SideOnly(value=Side.CLIENT)
    public String getProviderName() {
        return this.chunkProvider._d();
    }

    @Override
    public TileEntity getBlockTileEntity(int n, int n2, int n3) {
        if (n2 >= 0 && n2 < 256) {
            Chunk chunk;
            TileEntity tileEntity;
            int n4;
            TileEntity tileEntity2 = null;
            if (this.scanningTileEntities) {
                for (n4 = 0; n4 < this.addedTileEntityList.size(); ++n4) {
                    tileEntity = (TileEntity)this.addedTileEntityList.get(n4);
                    if (tileEntity.isInvalid() || tileEntity.xCoord != n || tileEntity.yCoord != n2 || tileEntity.zCoord != n3) continue;
                    tileEntity2 = tileEntity;
                    break;
                }
            }
            if (tileEntity2 == null && (chunk = this.getChunkFromChunkCoords(n >> 4, n3 >> 4)) != null) {
                tileEntity2 = chunk._g(n & 0xF, n2, n3 & 0xF);
            }
            if (tileEntity2 == null) {
                for (n4 = 0; n4 < this.addedTileEntityList.size(); ++n4) {
                    tileEntity = (TileEntity)this.addedTileEntityList.get(n4);
                    if (tileEntity.isInvalid() || tileEntity.xCoord != n || tileEntity.yCoord != n2 || tileEntity.zCoord != n3) continue;
                    tileEntity2 = tileEntity;
                    break;
                }
            }
            return tileEntity2;
        }
        return null;
    }

    public void setBlockTileEntity(int n, int n2, int n3, TileEntity tileEntity) {
        Object object;
        if (tileEntity == null || tileEntity.isInvalid()) {
            return;
        }
        if (tileEntity.canUpdate()) {
            if (this.scanningTileEntities) {
                object = this.addedTileEntityList.iterator();
                while (object.hasNext()) {
                    TileEntity tileEntity2 = (TileEntity)object.next();
                    if (tileEntity2.xCoord != n || tileEntity2.yCoord != n2 || tileEntity2.zCoord != n3) continue;
                    tileEntity2.invalidate();
                    object.remove();
                }
                this.addedTileEntityList.add(tileEntity);
            } else {
                this.loadedTileEntityList.add(tileEntity);
            }
        }
        if ((object = this.getChunkFromChunkCoords(n >> 4, n3 >> 4)) != null) {
            ((Chunk)object)._a(n & 0xF, n2, n3 & 0xF, tileEntity);
        }
        this.func_96440_m(n, n2, n3, 0);
    }

    public void removeBlockTileEntity(int n, int n2, int n3) {
        Chunk chunk = this.getChunkFromChunkCoords(n >> 4, n3 >> 4);
        if (chunk != null) {
            chunk._h(n & 0xF, n2, n3 & 0xF);
        }
        this.func_96440_m(n, n2, n3, 0);
    }

    public void markTileEntityForDespawn(TileEntity tileEntity) {
        this.entityRemoval.add(tileEntity);
    }

    @Override
    public boolean isBlockOpaqueCube(int n, int n2, int n3) {
        Block block = Block.blocksList[this.getBlockId(n, n2, n3)];
        return block == null ? false : block.isOpaqueCube();
    }

    @Override
    public boolean isBlockNormalCube(int n, int n2, int n3) {
        Block block = Block.blocksList[this.getBlockId(n, n2, n3)];
        return block != null && block.isBlockNormalCube(this, n, n2, n3);
    }

    public boolean isBlockFullCube(int n, int n2, int n3) {
        int n4 = this.getBlockId(n, n2, n3);
        if (n4 != 0 && Block.blocksList[n4] != null) {
            AxisAlignedBB axisAlignedBB = Block.blocksList[n4].getCollisionBoundingBoxFromPool(this, n, n2, n3);
            return axisAlignedBB != null && axisAlignedBB._b() >= 1.0;
        }
        return false;
    }

    @Override
    public boolean doesBlockHaveSolidTopSurface(int n, int n2, int n3) {
        return this.isBlockSolidOnSide(n, n2, n3, ForgeDirection.UP);
    }

    @Deprecated
    public boolean isBlockTopFacingSurfaceSolid(Block block, int n) {
        return block == null ? false : (block.blockMaterial._k() && block.renderAsNormalBlock() ? true : (block instanceof yuxu ? (n & 4) == 4 : (block instanceof BlockHalfSlab ? (n & 8) == 8 : (block instanceof BlockHopper ? true : (block instanceof zgzq ? (n & 7) == 7 : false)))));
    }

    public boolean isBlockNormalCubeDefault(int n, int n2, int n3, boolean bl) {
        if (n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000) {
            Chunk chunk = this.chunkProvider._b(n >> 4, n3 >> 4);
            if (chunk != null && !chunk._i()) {
                Block block = Block.blocksList[this.getBlockId(n, n2, n3)];
                return block == null ? false : this.isBlockNormalCube(n, n2, n3);
            }
            return bl;
        }
        return bl;
    }

    public void calculateInitialSkylight() {
        int n = this.calculateSkylightSubtracted(1.0f);
        if (n != this.skylightSubtracted) {
            this.skylightSubtracted = n;
        }
    }

    public void setAllowedSpawnTypes(boolean bl, boolean bl2) {
        this.provider._a(bl, bl2);
    }

    public void tick() {
        this.updateWeather();
    }

    public void calculateInitialWeather() {
        this.provider._u();
    }

    public void calculateInitialWeatherBody() {
        if (this.worldInfo._p()) {
            this.rainingStrength = 1.0f;
            if (this.worldInfo._n()) {
                this.thunderingStrength = 1.0f;
            }
        }
    }

    public void updateWeather() {
        this.provider._v();
    }

    public void updateWeatherBody() {
        pidb._a(this);
    }

    public void func_72913_w() {
        this.provider._w();
    }

    public void setActivePlayerChunksAndCheckLight() {
        int n;
        int n2;
        int n3;
        EntityPlayer entityPlayer;
        int n4;
        this.activeChunkSet.clear();
        this.activeChunkSet.addAll(this.getPersistentChunks().keySet());
        this.theProfiler._a("buildList");
        for (n4 = 0; n4 < this.playerEntities.size(); ++n4) {
            entityPlayer = (EntityPlayer)this.playerEntities.get(n4);
            n3 = sajh._c(entityPlayer.posX / 16.0);
            n2 = sajh._c(entityPlayer.posZ / 16.0);
            n = 7;
            for (int i = -n; i <= n; ++i) {
                for (int j = -n; j <= n; ++j) {
                    this.activeChunkSet.add(new jjym(i + n3, j + n2));
                }
            }
        }
        this.theProfiler._b();
        if (this.ambientTickCountdown > 0) {
            --this.ambientTickCountdown;
        }
        this.theProfiler._a("playerCheckLight");
        if (!this.playerEntities.isEmpty()) {
            n4 = this.rand.nextInt(this.playerEntities.size());
            entityPlayer = (EntityPlayer)this.playerEntities.get(n4);
            n3 = sajh._c(entityPlayer.posX) + this.rand.nextInt(11) - 5;
            n2 = sajh._c(entityPlayer.posY) + this.rand.nextInt(11) - 5;
            n = sajh._c(entityPlayer.posZ) + this.rand.nextInt(11) - 5;
            this.updateAllLightTypes(n3, n2, n);
        }
        this.theProfiler._b();
    }

    public void moodSoundAndLightCheck(int n, int n2, Chunk chunk) {
        this.theProfiler._c("moodSound");
        if (this.ambientTickCountdown == 0 && !this.isRemote) {
            EntityPlayer entityPlayer;
            this.updateLCG = this.updateLCG * 3 + 1013904223;
            int n3 = this.updateLCG >> 2;
            int n4 = n3 & 0xF;
            int n5 = n3 >> 8 & 0xF;
            int n6 = n3 >> 16 & 0x7F;
            int n7 = chunk._d(n4, n6, n5);
            if (n7 == 0 && this.getFullBlockLightValue(n4 += n, n6, n5 += n2) <= this.rand.nextInt(8) && this.getSavedLightValue(EnumSkyBlock._a, n4, n6, n5) <= 0 && (entityPlayer = this.getClosestPlayer((double)n4 + 0.5, (double)n6 + 0.5, (double)n5 + 0.5, 8.0)) != null && entityPlayer.getDistanceSq((double)n4 + 0.5, (double)n6 + 0.5, (double)n5 + 0.5) > 4.0) {
                this.playSoundEffect((double)n4 + 0.5, (double)n6 + 0.5, (double)n5 + 0.5, "ambient.cave.cave", 0.7f, 0.8f + this.rand.nextFloat() * 0.2f);
                this.ambientTickCountdown = this.rand.nextInt(12000) + 6000;
            }
        }
        this.theProfiler._c("checkLight");
        chunk._n();
    }

    public void tickBlocksAndAmbiance() {
        this.setActivePlayerChunksAndCheckLight();
    }

    public boolean isBlockFreezable(int n, int n2, int n3) {
        return this.canBlockFreeze(n, n2, n3, false);
    }

    public boolean isBlockFreezableNaturally(int n, int n2, int n3) {
        return this.canBlockFreeze(n, n2, n3, true);
    }

    public boolean canBlockFreeze(int n, int n2, int n3, boolean bl) {
        return this.provider._a(n, n2, n3, bl);
    }

    public boolean canBlockFreezeBody(int n, int n2, int n3, boolean bl) {
        int n4;
        BiomeGenBase biomeGenBase = this.getBiomeGenForCoords(n, n3);
        float f = biomeGenBase._k();
        if (f > 0.15f) {
            return false;
        }
        if (n2 >= 0 && n2 < 256 && this.getSavedLightValue(EnumSkyBlock._b, n, n2, n3) < 10 && ((n4 = this.getBlockId(n, n2, n3)) == Block.waterStill.blockID || n4 == Block.waterMoving.blockID) && this.getBlockMetadata(n, n2, n3) == 0) {
            if (!bl) {
                return true;
            }
            boolean bl2 = true;
            if (bl2 && this.getBlockMaterial(n - 1, n2, n3) != Material._h) {
                bl2 = false;
            }
            if (bl2 && this.getBlockMaterial(n + 1, n2, n3) != Material._h) {
                bl2 = false;
            }
            if (bl2 && this.getBlockMaterial(n, n2, n3 - 1) != Material._h) {
                bl2 = false;
            }
            if (bl2 && this.getBlockMaterial(n, n2, n3 + 1) != Material._h) {
                bl2 = false;
            }
            if (!bl2) {
                return true;
            }
        }
        return false;
    }

    public boolean canSnowAt(int n, int n2, int n3) {
        return this.provider._a(n, n2, n3);
    }

    public boolean canSnowAtBody(int n, int n2, int n3) {
        BiomeGenBase biomeGenBase = this.getBiomeGenForCoords(n, n3);
        float f = biomeGenBase._k();
        if (f > 0.15f) {
            return false;
        }
        if (n2 >= 0 && n2 < 256 && this.getSavedLightValue(EnumSkyBlock._b, n, n2, n3) < 10) {
            int n4 = this.getBlockId(n, n2 - 1, n3);
            int n5 = this.getBlockId(n, n2, n3);
            if (n5 == 0 && Block.snow.canPlaceBlockAt(this, n, n2, n3) && n4 != 0 && n4 != Block.ice.blockID && Block.blocksList[n4].blockMaterial._c()) {
                return true;
            }
        }
        return false;
    }

    public void updateAllLightTypes(int n, int n2, int n3) {
        if (!this.provider._g) {
            this.updateLightByType(EnumSkyBlock._a, n, n2, n3);
        }
        this.updateLightByType(EnumSkyBlock._b, n, n2, n3);
    }

    public int computeLightValue(int n, int n2, int n3, EnumSkyBlock enumSkyBlock) {
        int n4;
        if (enumSkyBlock == EnumSkyBlock._a && this.canBlockSeeTheSky(n, n2, n3)) {
            return 15;
        }
        int n5 = this.getBlockId(n, n2, n3);
        Block block = Block.blocksList[n5];
        int n6 = DynamicLights.getLightValue(this, n5, n, n2, n3);
        int n7 = enumSkyBlock == EnumSkyBlock._a ? 0 : n6;
        int n8 = n4 = block == null ? 0 : block.getLightOpacity(this, n, n2, n3);
        if (n4 >= 15 && n6 > 0) {
            n4 = 1;
        }
        if (n4 < 1) {
            n4 = 1;
        }
        if (n4 >= 15) {
            return 0;
        }
        if (n7 >= 14) {
            return n7;
        }
        for (int i = 0; i < 6; ++i) {
            int n9 = n + owak._b[i];
            int n10 = n2 + owak._c[i];
            int n11 = n3 + owak._d[i];
            int n12 = this.getSavedLightValue(enumSkyBlock, n9, n10, n11) - n4;
            if (n12 > n7) {
                n7 = n12;
            }
            if (n7 < 14) continue;
            return n7;
        }
        return n7;
    }

    public void updateLightByType(EnumSkyBlock enumSkyBlock, int n, int n2, int n3) {
        if (this.doChunksNearChunkExist(n, n2, n3, 17)) {
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14 = 0;
            int n15 = 0;
            this.theProfiler._a("getBrightness");
            int n16 = this.getSavedLightValue(enumSkyBlock, n, n2, n3);
            int n17 = this.computeLightValue(n, n2, n3, enumSkyBlock);
            if (n17 > n16) {
                this.lightUpdateBlockList[n15++] = 133152;
            } else if (n17 < n16) {
                this.lightUpdateBlockList[n15++] = 0x20820 | n16 << 18;
                while (n14 < n15) {
                    n13 = this.lightUpdateBlockList[n14++];
                    n12 = (n13 & 0x3F) - 32 + n;
                    n11 = (n13 >> 6 & 0x3F) - 32 + n2;
                    n10 = (n13 >> 12 & 0x3F) - 32 + n3;
                    n9 = n13 >> 18 & 0xF;
                    n8 = this.getSavedLightValue(enumSkyBlock, n12, n11, n10);
                    if (n8 != n9) continue;
                    this.setLightValue(enumSkyBlock, n12, n11, n10, 0);
                    if (n9 <= 0 || (n7 = sajh._a(n12 - n)) + (n6 = sajh._a(n11 - n2)) + (n5 = sajh._a(n10 - n3)) >= 17) continue;
                    for (n4 = 0; n4 < 6; ++n4) {
                        int n18 = n12 + owak._b[n4];
                        int n19 = n11 + owak._c[n4];
                        int n20 = n10 + owak._d[n4];
                        Block block = Block.blocksList[this.getBlockId(n18, n19, n20)];
                        int n21 = block == null ? 0 : block.getLightOpacity(this, n18, n19, n20);
                        int n22 = Math.max(1, n21);
                        n8 = this.getSavedLightValue(enumSkyBlock, n18, n19, n20);
                        if (n8 != n9 - n22 || n15 >= this.lightUpdateBlockList.length) continue;
                        this.lightUpdateBlockList[n15++] = n18 - n + 32 | n19 - n2 + 32 << 6 | n20 - n3 + 32 << 12 | n9 - n22 << 18;
                    }
                }
                n14 = 0;
            }
            this.theProfiler._b();
            this.theProfiler._a("checkedPosition < toCheckCount");
            while (n14 < n15) {
                n13 = this.lightUpdateBlockList[n14++];
                n12 = (n13 & 0x3F) - 32 + n;
                n11 = (n13 >> 6 & 0x3F) - 32 + n2;
                n10 = (n13 >> 12 & 0x3F) - 32 + n3;
                n9 = this.getSavedLightValue(enumSkyBlock, n12, n11, n10);
                n8 = this.computeLightValue(n12, n11, n10, enumSkyBlock);
                if (n8 == n9) continue;
                this.setLightValue(enumSkyBlock, n12, n11, n10, n8);
                if (n8 <= n9) continue;
                n7 = Math.abs(n12 - n);
                n6 = Math.abs(n11 - n2);
                n5 = Math.abs(n10 - n3);
                int n23 = n4 = n15 < this.lightUpdateBlockList.length - 6 ? 1 : 0;
                if (n7 + n6 + n5 >= 17 || n4 == 0) continue;
                if (this.getSavedLightValue(enumSkyBlock, n12 - 1, n11, n10) < n8) {
                    this.lightUpdateBlockList[n15++] = n12 - 1 - n + 32 + (n11 - n2 + 32 << 6) + (n10 - n3 + 32 << 12);
                }
                if (this.getSavedLightValue(enumSkyBlock, n12 + 1, n11, n10) < n8) {
                    this.lightUpdateBlockList[n15++] = n12 + 1 - n + 32 + (n11 - n2 + 32 << 6) + (n10 - n3 + 32 << 12);
                }
                if (this.getSavedLightValue(enumSkyBlock, n12, n11 - 1, n10) < n8) {
                    this.lightUpdateBlockList[n15++] = n12 - n + 32 + (n11 - 1 - n2 + 32 << 6) + (n10 - n3 + 32 << 12);
                }
                if (this.getSavedLightValue(enumSkyBlock, n12, n11 + 1, n10) < n8) {
                    this.lightUpdateBlockList[n15++] = n12 - n + 32 + (n11 + 1 - n2 + 32 << 6) + (n10 - n3 + 32 << 12);
                }
                if (this.getSavedLightValue(enumSkyBlock, n12, n11, n10 - 1) < n8) {
                    this.lightUpdateBlockList[n15++] = n12 - n + 32 + (n11 - n2 + 32 << 6) + (n10 - 1 - n3 + 32 << 12);
                }
                if (this.getSavedLightValue(enumSkyBlock, n12, n11, n10 + 1) >= n8) continue;
                this.lightUpdateBlockList[n15++] = n12 - n + 32 + (n11 - n2 + 32 << 6) + (n10 + 1 - n3 + 32 << 12);
            }
            this.theProfiler._b();
        }
    }

    public boolean tickUpdates(boolean bl) {
        return false;
    }

    public List getPendingBlockUpdates(Chunk chunk, boolean bl) {
        return null;
    }

    public List getEntitiesWithinAABBExcludingEntity(Entity entity, AxisAlignedBB axisAlignedBB) {
        return this.getEntitiesWithinAABBExcludingEntity(entity, axisAlignedBB, null);
    }

    public List getEntitiesWithinAABBExcludingEntity(Entity entity, AxisAlignedBB axisAlignedBB, IEntitySelector iEntitySelector) {
        ArrayList arrayList = new ArrayList();
        int n = sajh._c((axisAlignedBB._b - MAX_ENTITY_RADIUS) / 16.0);
        int n2 = sajh._c((axisAlignedBB._e + MAX_ENTITY_RADIUS) / 16.0);
        int n3 = sajh._c((axisAlignedBB._d - MAX_ENTITY_RADIUS) / 16.0);
        int n4 = sajh._c((axisAlignedBB._g + MAX_ENTITY_RADIUS) / 16.0);
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                if (!this.chunkExists(i, j)) continue;
                this.getChunkFromChunkCoords(i, j)._a(entity, axisAlignedBB, arrayList, iEntitySelector);
            }
        }
        return arrayList;
    }

    public List getEntitiesWithinAABB(Class clazz, AxisAlignedBB axisAlignedBB) {
        return this.selectEntitiesWithinAABB(clazz, axisAlignedBB, null);
    }

    public List selectEntitiesWithinAABB(Class clazz, AxisAlignedBB axisAlignedBB, IEntitySelector iEntitySelector) {
        int n = sajh._c((axisAlignedBB._b - MAX_ENTITY_RADIUS) / 16.0);
        int n2 = sajh._c((axisAlignedBB._e + MAX_ENTITY_RADIUS) / 16.0);
        int n3 = sajh._c((axisAlignedBB._d - MAX_ENTITY_RADIUS) / 16.0);
        int n4 = sajh._c((axisAlignedBB._g + MAX_ENTITY_RADIUS) / 16.0);
        ArrayList arrayList = new ArrayList();
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                if (!this.chunkExists(i, j)) continue;
                this.getChunkFromChunkCoords(i, j)._a(clazz, axisAlignedBB, arrayList, iEntitySelector);
            }
        }
        return arrayList;
    }

    public Entity findNearestEntityWithinAABB(Class clazz, AxisAlignedBB axisAlignedBB, Entity entity) {
        List list2 = this.getEntitiesWithinAABB(clazz, axisAlignedBB);
        Entity entity2 = null;
        double d = Double.MAX_VALUE;
        for (int i = 0; i < list2.size(); ++i) {
            double d2;
            Entity entity3 = (Entity)list2.get(i);
            if (entity3 == entity || !((d2 = entity.getDistanceSqToEntity(entity3)) <= d)) continue;
            entity2 = entity3;
            d = d2;
        }
        return entity2;
    }

    public abstract Entity getEntityByID(int var1);

    @SideOnly(value=Side.CLIENT)
    public List getLoadedEntityList() {
        return this.loadedEntityList;
    }

    public void markTileEntityChunkModified(int n, int n2, int n3, TileEntity tileEntity) {
        if (this.blockExists(n, n2, n3)) {
            this.getChunkFromBlockCoords(n, n3)._h();
        }
    }

    public int countEntities(Class clazz) {
        int n = 0;
        for (int i = 0; i < this.loadedEntityList.size(); ++i) {
            Entity entity = (Entity)this.loadedEntityList.get(i);
            if (entity instanceof EntityLiving && ((EntityLiving)entity).isNoDespawnRequired() || !clazz.isAssignableFrom(entity.getClass())) continue;
            ++n;
        }
        return n;
    }

    public void addLoadedEntities(List list2) {
        for (int i = 0; i < list2.size(); ++i) {
            Entity entity = (Entity)list2.get(i);
            if (MinecraftForge.EVENT_BUS.post(new EntityJoinWorldEvent(entity, this))) continue;
            this.loadedEntityList.add(entity);
            this.onEntityAdded(entity);
        }
    }

    public void unloadEntities(List list2) {
        this.unloadedEntityList.addAll(list2);
    }

    public boolean canPlaceEntityOnSide(int n, int n2, int n3, int n4, boolean bl, int n5, Entity entity, ItemStack itemStack) {
        int n6 = this.getBlockId(n2, n3, n4);
        Block block = Block.blocksList[n6];
        Block block2 = Block.blocksList[n];
        AxisAlignedBB axisAlignedBB = block2.getCollisionBoundingBoxFromPool(this, n2, n3, n4);
        if (bl) {
            axisAlignedBB = null;
        }
        if (axisAlignedBB != null && !this.checkNoEntityCollision(axisAlignedBB, entity)) {
            return false;
        }
        if (block != null && (block == Block.waterMoving || block == Block.waterStill || block == Block.lavaMoving || block == Block.lavaStill || block == Block.fire || block.blockMaterial._j())) {
            block = null;
        }
        if (block != null && block.isBlockReplaceable(this, n2, n3, n4)) {
            block = null;
        }
        return block != null && block.blockMaterial == Material._q && block2 == Block.anvil ? true : n > 0 && block == null && block2.canPlaceBlockOnSide(this, n2, n3, n4, n5, itemStack);
    }

    public PathEntity getPathEntityToEntity(Entity entity, Entity entity2, float f, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.theProfiler._a("pathfind");
        int n = sajh._c(entity.posX);
        int n2 = sajh._c(entity.posY + 1.0);
        int n3 = sajh._c(entity.posZ);
        int n4 = (int)(f + 16.0f);
        int n5 = n - n4;
        int n6 = n2 - n4;
        int n7 = n3 - n4;
        int n8 = n + n4;
        int n9 = n2 + n4;
        int n10 = n3 + n4;
        zzie zzie2 = new zzie(this, n5, n6, n7, n8, n9, n10, 0);
        PathEntity pathEntity = new rrnl(zzie2, bl, bl2, bl3, bl4)._a(entity, entity2, f);
        this.theProfiler._b();
        return pathEntity;
    }

    public PathEntity getEntityPathToXYZ(Entity entity, int n, int n2, int n3, float f, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.theProfiler._a("pathfind");
        int n4 = sajh._c(entity.posX);
        int n5 = sajh._c(entity.posY);
        int n6 = sajh._c(entity.posZ);
        int n7 = (int)(f + 8.0f);
        int n8 = n4 - n7;
        int n9 = n5 - n7;
        int n10 = n6 - n7;
        int n11 = n4 + n7;
        int n12 = n5 + n7;
        int n13 = n6 + n7;
        zzie zzie2 = new zzie(this, n8, n9, n10, n11, n12, n13, 0);
        PathEntity pathEntity = new rrnl(zzie2, bl, bl2, bl3, bl4)._a(entity, n, n2, n3, f);
        this.theProfiler._b();
        return pathEntity;
    }

    @Override
    public int isBlockProvidingPowerTo(int n, int n2, int n3, int n4) {
        int n5 = this.getBlockId(n, n2, n3);
        return n5 == 0 ? 0 : Block.blocksList[n5].isProvidingStrongPower(this, n, n2, n3, n4);
    }

    public int getBlockPowerInput(int n, int n2, int n3) {
        int n4 = 0;
        int n5 = Math.max(n4, this.isBlockProvidingPowerTo(n, n2 - 1, n3, 0));
        if (n5 >= 15) {
            return n5;
        }
        if ((n5 = Math.max(n5, this.isBlockProvidingPowerTo(n, n2 + 1, n3, 1))) >= 15) {
            return n5;
        }
        if ((n5 = Math.max(n5, this.isBlockProvidingPowerTo(n, n2, n3 - 1, 2))) >= 15) {
            return n5;
        }
        if ((n5 = Math.max(n5, this.isBlockProvidingPowerTo(n, n2, n3 + 1, 3))) >= 15) {
            return n5;
        }
        if ((n5 = Math.max(n5, this.isBlockProvidingPowerTo(n - 1, n2, n3, 4))) >= 15) {
            return n5;
        }
        return (n5 = Math.max(n5, this.isBlockProvidingPowerTo(n + 1, n2, n3, 5))) >= 15 ? n5 : n5;
    }

    public boolean getIndirectPowerOutput(int n, int n2, int n3, int n4) {
        return this.getIndirectPowerLevelTo(n, n2, n3, n4) > 0;
    }

    public int getIndirectPowerLevelTo(int n, int n2, int n3, int n4) {
        Block block = Block.blocksList[this.getBlockId(n, n2, n3)];
        if (block == null) {
            return 0;
        }
        if (!block.shouldCheckWeakPower(this, n, n2, n3, n4)) {
            return this.getBlockPowerInput(n, n2, n3);
        }
        return block.isProvidingWeakPower(this, n, n2, n3, n4);
    }

    public boolean isBlockIndirectlyGettingPowered(int n, int n2, int n3) {
        return this.getIndirectPowerLevelTo(n, n2 - 1, n3, 0) > 0 ? true : (this.getIndirectPowerLevelTo(n, n2 + 1, n3, 1) > 0 ? true : (this.getIndirectPowerLevelTo(n, n2, n3 - 1, 2) > 0 ? true : (this.getIndirectPowerLevelTo(n, n2, n3 + 1, 3) > 0 ? true : (this.getIndirectPowerLevelTo(n - 1, n2, n3, 4) > 0 ? true : this.getIndirectPowerLevelTo(n + 1, n2, n3, 5) > 0))));
    }

    public int getStrongestIndirectPower(int n, int n2, int n3) {
        int n4 = 0;
        for (int i = 0; i < 6; ++i) {
            int n5 = this.getIndirectPowerLevelTo(n + owak._b[i], n2 + owak._c[i], n3 + owak._d[i], i);
            if (n5 >= 15) {
                return 15;
            }
            if (n5 <= n4) continue;
            n4 = n5;
        }
        return n4;
    }

    public EntityPlayer getClosestPlayerToEntity(Entity entity, double d) {
        return this.getClosestPlayer(entity.posX, entity.posY, entity.posZ, d);
    }

    public EntityPlayer getClosestPlayer(double d, double d2, double d3, double d4) {
        double d5 = -1.0;
        EntityPlayer entityPlayer = null;
        for (int i = 0; i < this.playerEntities.size(); ++i) {
            EntityPlayer entityPlayer2 = (EntityPlayer)this.playerEntities.get(i);
            double d6 = entityPlayer2.getDistanceSq(d, d2, d3);
            if (!(d4 < 0.0) && !(d6 < d4 * d4) || d5 != -1.0 && !(d6 < d5)) continue;
            d5 = d6;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public EntityPlayer getClosestVulnerablePlayerToEntity(Entity entity, double d) {
        return this.getClosestVulnerablePlayer(entity.posX, entity.posY, entity.posZ, d);
    }

    public EntityPlayer getClosestVulnerablePlayer(double d, double d2, double d3, double d4) {
        double d5 = -1.0;
        EntityPlayer entityPlayer = null;
        for (int i = 0; i < this.playerEntities.size(); ++i) {
            EntityPlayer entityPlayer2 = (EntityPlayer)this.playerEntities.get(i);
            if (entityPlayer2.capabilities._a || !entityPlayer2.isEntityAlive()) continue;
            double d6 = entityPlayer2.getDistanceSq(d, d2, d3);
            double d7 = d4;
            if (entityPlayer2.isSneaking()) {
                d7 = d4 * (double)0.8f;
            }
            if (entityPlayer2.isInvisible()) {
                float f = entityPlayer2.getArmorVisibility();
                if (f < 0.1f) {
                    f = 0.1f;
                }
                d7 *= (double)(0.7f * f);
            }
            if (!(d4 < 0.0) && !(d6 < d7 * d7) || d5 != -1.0 && !(d6 < d5)) continue;
            d5 = d6;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public EntityPlayer getPlayerEntityByName(String string) {
        for (int i = 0; i < this.playerEntities.size(); ++i) {
            if (!string.equals(((EntityPlayer)this.playerEntities.get(i)).getCommandSenderName())) continue;
            return (EntityPlayer)this.playerEntities.get(i);
        }
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public void sendQuittingDisconnectingPacket() {
    }

    public void checkSessionLock() throws xcad {
        this.saveHandler.checkSessionLock();
    }

    @SideOnly(value=Side.CLIENT)
    public void func_82738_a(long l) {
        this.worldInfo._a(l);
    }

    public long getSeed() {
        return this.provider._x();
    }

    public long getTotalWorldTime() {
        return this.worldInfo._f();
    }

    public long getWorldTime() {
        return this.provider._y();
    }

    public void setWorldTime(long l) {
        this.provider._b(l);
    }

    public ChunkCoordinates getSpawnPoint() {
        return this.provider._z();
    }

    @SideOnly(value=Side.CLIENT)
    public void setSpawnLocation(int n, int n2, int n3) {
        this.provider._b(n, n2, n3);
    }

    @SideOnly(value=Side.CLIENT)
    public void joinEntityInSurroundings(Entity entity) {
        int n = sajh._c(entity.posX / 16.0);
        int n2 = sajh._c(entity.posZ / 16.0);
        int n3 = 2;
        for (int i = n - n3; i <= n + n3; ++i) {
            for (int j = n2 - n3; j <= n2 + n3; ++j) {
                this.getChunkFromChunkCoords(i, j);
            }
        }
        if (!this.loadedEntityList.contains(entity) && !MinecraftForge.EVENT_BUS.post(new EntityJoinWorldEvent(entity, this))) {
            this.loadedEntityList.add(entity);
        }
    }

    public boolean canMineBlock(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return this.provider._a(entityPlayer, n, n2, n3);
    }

    public boolean canMineBlockBody(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return true;
    }

    public void setEntityState(Entity entity, byte by) {
    }

    public IChunkProvider getChunkProvider() {
        return this.chunkProvider;
    }

    public void addBlockEvent(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n4 > 0) {
            Block.blocksList[n4].onBlockEventReceived(this, n, n2, n3, n5, n6);
        }
    }

    public ISaveHandler getSaveHandler() {
        return this.saveHandler;
    }

    public WorldInfo getWorldInfo() {
        return this.worldInfo;
    }

    public GameRules getGameRules() {
        return this.worldInfo._x();
    }

    public void updateAllPlayersSleepingFlag() {
    }

    public float getWeightedThunderStrength(float f) {
        return (this.prevThunderingStrength + (this.thunderingStrength - this.prevThunderingStrength) * f) * this.getRainStrength(f);
    }

    public float getRainStrength(float f) {
        return this.prevRainingStrength + (this.rainingStrength - this.prevRainingStrength) * f;
    }

    @SideOnly(value=Side.CLIENT)
    public void setRainStrength(float f) {
        this.prevRainingStrength = f;
        this.rainingStrength = f;
    }

    public boolean isThundering() {
        return (double)this.getWeightedThunderStrength(1.0f) > 0.9;
    }

    public boolean isRaining() {
        return (double)this.getRainStrength(1.0f) > 0.2;
    }

    public boolean canLightningStrikeAt(int n, int n2, int n3) {
        if (!this.isRaining()) {
            return false;
        }
        if (!this.canBlockSeeTheSky(n, n2, n3)) {
            return false;
        }
        if (this.getPrecipitationHeight(n, n3) > n2) {
            return false;
        }
        BiomeGenBase biomeGenBase = this.getBiomeGenForCoords(n, n3);
        return biomeGenBase._d() ? false : biomeGenBase._e();
    }

    public boolean isBlockHighHumidity(int n, int n2, int n3) {
        return this.provider._c(n, n2, n3);
    }

    public void setItemData(String string, WorldSavedData worldSavedData) {
        this.mapStorage._a(string, worldSavedData);
    }

    public WorldSavedData loadItemData(Class clazz, String string) {
        return this.mapStorage._a(clazz, string);
    }

    public int getUniqueDataId(String string) {
        return this.mapStorage._a(string);
    }

    public void func_82739_e(int n, int n2, int n3, int n4, int n5) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            ((IWorldAccess)this.worldAccesses.get(i))._a(n, n2, n3, n4, n5);
        }
    }

    public void playAuxSFX(int n, int n2, int n3, int n4, int n5) {
        this.playAuxSFXAtEntity(null, n, n2, n3, n4, n5);
    }

    public void playAuxSFXAtEntity(EntityPlayer entityPlayer, int n, int n2, int n3, int n4, int n5) {
        try {
            for (int i = 0; i < this.worldAccesses.size(); ++i) {
                ((IWorldAccess)this.worldAccesses.get(i))._a(entityPlayer, n, n2, n3, n4, n5);
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Playing level event");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Level event being played");
            crashReportCategory._a("Block coordinates", CrashReportCategory._a(n2, n3, n4));
            crashReportCategory._a("Event source", entityPlayer);
            crashReportCategory._a("Event type", n);
            crashReportCategory._a("Event data", n5);
            throw new turb(crashReport);
        }
    }

    @Override
    public int getHeight() {
        return this.provider._A();
    }

    public int getActualHeight() {
        return this.provider._B();
    }

    public IUpdatePlayerListBox getMinecartSoundUpdater(EntityMinecart entityMinecart) {
        return null;
    }

    public Random setRandomSeed(int n, int n2, int n3) {
        long l = (long)n * 341873128712L + (long)n2 * 132897987541L + this.getWorldInfo()._b() + (long)n3;
        this.rand.setSeed(l);
        return this.rand;
    }

    public xtcd findClosestStructure(String string, int n, int n2, int n3) {
        return this.getChunkProvider()._a(this, string, n, n2, n3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean extendedLevelsInChunkCache() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public double getHorizon() {
        return this.provider._C();
    }

    public CrashReportCategory addWorldInfoToCrashReport(CrashReport crashReport) {
        CrashReportCategory crashReportCategory = crashReport.makeCategoryDepth("Affected level", 1);
        crashReportCategory._a("Level name", this.worldInfo == null ? "????" : this.worldInfo._k());
        crashReportCategory._a("All players", new sutf(this));
        crashReportCategory._a("Chunk stats", new rrqg(this));
        try {
            this.worldInfo._a(crashReportCategory);
        }
        catch (Throwable throwable) {
            crashReportCategory._a("Level Data Unobtainable", throwable);
        }
        return crashReportCategory;
    }

    public void destroyBlockInWorldPartially(int n, int n2, int n3, int n4, int n5) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            IWorldAccess iWorldAccess = (IWorldAccess)this.worldAccesses.get(i);
            iWorldAccess._b(n, n2, n3, n4, n5);
        }
    }

    @Override
    public Vec3Pool getWorldVec3Pool() {
        if (this.J.get() == null) {
            this.J.set(new Vec3Pool(300, 2000));
        }
        return this.J.get();
    }

    public Calendar getCurrentDate() {
        if (this.getTotalWorldTime() % 600L == 0L) {
            this.theCalendar.setTimeInMillis(MinecraftServer.__aq());
        }
        return this.theCalendar;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_92088_a(double d, double d2, double d3, double d4, double d5, double d6, NBTTagCompound nBTTagCompound) {
    }

    public Scoreboard getScoreboard() {
        return this.worldScoreboard;
    }

    public void func_96440_m(int n, int n2, int n3, int n4) {
        for (ForgeDirection forgeDirection : ForgeDirection.VALID_DIRECTIONS) {
            int n5 = n + forgeDirection.offsetX;
            int n6 = n2 + forgeDirection.offsetY;
            int n7 = n3 + forgeDirection.offsetZ;
            int n8 = this.getBlockId(n5, n6, n7);
            Block block = Block.blocksList[n8];
            if (block == null) continue;
            block.onNeighborTileChange(this, n5, n6, n7, n, n2, n3);
            if (!Block.isNormalCube(n8) || (block = Block.blocksList[n8 = this.getBlockId(n5 += forgeDirection.offsetX, n6 += forgeDirection.offsetY, n7 += forgeDirection.offsetZ)]) == null || !block.weakTileChanges()) continue;
            block.onNeighborTileChange(this, n5, n6, n7, n, n2, n3);
        }
    }

    public ILogAgent getWorldLogAgent() {
        return this.worldLogAgent;
    }

    public float getLocationTensionFactor(double d, double d2, double d3) {
        return this.getTensionFactorForBlock(sajh._c(d), sajh._c(d2), sajh._c(d3));
    }

    public float getTensionFactorForBlock(int n, int n2, int n3) {
        boolean bl;
        float f = 0.0f;
        boolean bl2 = bl = this.difficultySetting == 3;
        if (this.blockExists(n, n2, n3)) {
            float f2 = this.getCurrentMoonPhaseFactor();
            f += sajh._a((float)this.getChunkFromBlockCoords((int)n, (int)n3)._t / 3600000.0f, 0.0f, 1.0f) * (bl ? 1.0f : 0.75f);
            f += f2 * 0.25f;
        }
        if (this.difficultySetting < 2) {
            f *= (float)this.difficultySetting / 2.0f;
        }
        return sajh._a(f, 0.0f, bl ? 1.5f : 1.0f);
    }

    public void addTileEntity(TileEntity tileEntity) {
        List list2;
        List list3 = list2 = this.scanningTileEntities ? this.addedTileEntityList : this.loadedTileEntityList;
        if (tileEntity.canUpdate()) {
            list2.add(tileEntity);
        }
    }

    public boolean isBlockSolidOnSide(int n, int n2, int n3, ForgeDirection forgeDirection) {
        return this.isBlockSolidOnSide(n, n2, n3, forgeDirection, false);
    }

    @Override
    public boolean isBlockSolidOnSide(int n, int n2, int n3, ForgeDirection forgeDirection, boolean bl) {
        if (n < -30000000 || n3 < -30000000 || n >= 30000000 || n3 >= 30000000) {
            return bl;
        }
        Chunk chunk = this.chunkProvider._b(n >> 4, n3 >> 4);
        if (chunk == null || chunk._i()) {
            return bl;
        }
        Block block = Block.blocksList[this.getBlockId(n, n2, n3)];
        if (block == null) {
            return false;
        }
        return block.isBlockSolidOnSide(this, n, n2, n3, forgeDirection);
    }

    public ImmutableSetMultimap<jjym, ForgeChunkManager.Ticket> getPersistentChunks() {
        return ForgeChunkManager.getPersistentChunksFor(this);
    }

    public int getBlockLightOpacity(int n, int n2, int n3) {
        if (n < -30000000 || n3 < -30000000 || n >= 30000000 || n3 >= 30000000) {
            return 0;
        }
        if (n2 < 0 || n2 >= 256) {
            return 0;
        }
        return this.getChunkFromChunkCoords(n >> 4, n3 >> 4)._c(n & 0xF, n2, n3 & 0xF);
    }

    public int countEntities(EnumCreatureType enumCreatureType, boolean bl) {
        int n = 0;
        for (int i = 0; i < this.loadedEntityList.size(); ++i) {
            if (!((Entity)this.loadedEntityList.get(i)).isCreatureType(enumCreatureType, bl)) continue;
            ++n;
        }
        return n;
    }
}

