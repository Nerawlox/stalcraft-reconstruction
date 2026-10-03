/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  ake
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.Mod
 *  cpw.mods.fml.common.Mod$EventHandler
 *  cpw.mods.fml.common.Mod$Instance
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.event.FMLServerStartingEvent
 *  cpw.mods.fml.common.network.IGuiHandler
 *  cpw.mods.fml.common.network.NetworkMod
 *  cpw.mods.fml.common.network.NetworkRegistry
 *  cpw.mods.fml.common.registry.EntityRegistry
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  net.minecraftforge.fluids.Fluid
 *  net.minecraftforge.fluids.FluidRegistry
 */
package ru.stalcraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.ArrayList;
import java.util.HashSet;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import ru.stalcraft.AnomalyDrop;
import ru.stalcraft.Config;
import ru.stalcraft.ItemsConfig;
import ru.stalcraft.Logger;
import ru.stalcraft.SmartMovingHelper;
import ru.stalcraft.blocks.BlockAnomaly;
import ru.stalcraft.blocks.BlockAnomalyNeighbor;
import ru.stalcraft.blocks.BlockCarousel;
import ru.stalcraft.blocks.BlockCoach;
import ru.stalcraft.blocks.BlockDebuff;
import ru.stalcraft.blocks.BlockElectra;
import ru.stalcraft.blocks.BlockFlag;
import ru.stalcraft.blocks.BlockFunnel;
import ru.stalcraft.blocks.BlockKisselFluid;
import ru.stalcraft.blocks.BlockLighter;
import ru.stalcraft.blocks.BlockMachineGun;
import ru.stalcraft.blocks.BlockRespawn;
import ru.stalcraft.blocks.BlockStalkerLadder;
import ru.stalcraft.blocks.BlockSteam;
import ru.stalcraft.blocks.BlockTrampoline;
import ru.stalcraft.blocks.MaterialFakeAir;
import ru.stalcraft.blocks.StalkerBlockStairs;
import ru.stalcraft.blocks.StalkerChest;
import ru.stalcraft.blocks.StalkerDoor;
import ru.stalcraft.clans.IClanManager;
import ru.stalcraft.clans.IFlagManager;
import ru.stalcraft.entity.EntityBullet;
import ru.stalcraft.entity.EntityCorpse;
import ru.stalcraft.entity.EntityExplosive;
import ru.stalcraft.entity.EntityGrenade;
import ru.stalcraft.entity.EntityRail;
import ru.stalcraft.entity.EntityShot;
import ru.stalcraft.entity.EntitySleeve;
import ru.stalcraft.entity.EntityTurrel1;
import ru.stalcraft.entity.EntityTurrel2;
import ru.stalcraft.entity.EntityTurrel3;
import ru.stalcraft.entity.EntityZombieShooter;
import ru.stalcraft.inventory.ArmorTab;
import ru.stalcraft.inventory.StalkerTab;
import ru.stalcraft.inventory.WeaponTab;
import ru.stalcraft.items.ItemBackpack;
import ru.stalcraft.items.ItemBullet;
import ru.stalcraft.items.ItemCrossbow;
import ru.stalcraft.items.ItemDetector;
import ru.stalcraft.items.ItemEmptyBottle;
import ru.stalcraft.items.ItemEnergy;
import ru.stalcraft.items.ItemExplosive;
import ru.stalcraft.items.ItemFlag;
import ru.stalcraft.items.ItemFlashlight;
import ru.stalcraft.items.ItemHandcuffs;
import ru.stalcraft.items.ItemKey;
import ru.stalcraft.items.ItemMachineGun;
import ru.stalcraft.items.ItemMedicine;
import ru.stalcraft.items.ItemRailgun;
import ru.stalcraft.items.ItemRope;
import ru.stalcraft.items.ItemSkin;
import ru.stalcraft.items.ItemStalkerDoor;
import ru.stalcraft.items.ItemTurrel1;
import ru.stalcraft.items.ItemTurrel2;
import ru.stalcraft.items.ItemTurrel3;
import ru.stalcraft.items.ItemVodka;
import ru.stalcraft.network.ConnectionHandler;
import ru.stalcraft.network.GuiHandler;
import ru.stalcraft.network.PacketHandler;
import ru.stalcraft.proxy.IClientProxy;
import ru.stalcraft.proxy.IProxy;
import ru.stalcraft.proxy.IServerProxy;
import ru.stalcraft.proxy.ProxyInstance;
import ru.stalcraft.server.CommonProxy;
import ru.stalcraft.tile.TileEntityCarousel;
import ru.stalcraft.tile.TileEntityCoach;
import ru.stalcraft.tile.TileEntityElectra;
import ru.stalcraft.tile.TileEntityFlag;
import ru.stalcraft.tile.TileEntityFunnel;
import ru.stalcraft.tile.TileEntityKissel;
import ru.stalcraft.tile.TileEntityLighter;
import ru.stalcraft.tile.TileEntityMachineGun;
import ru.stalcraft.tile.TileEntitySteam;
import ru.stalcraft.tile.TileEntityTrampoline;

@Mod(modid="StalkerMod", name="Stalker Mod", version="1.0[1.6.4]")
@NetworkMod(clientSideRequired=true, serverSideRequired=true, channels={"modST"}, packetHandler=PacketHandler.class, connectionHandler=ConnectionHandler.class)
public class StalkerMain {
    @Mod.Instance(value="StalkerMod")
    public static StalkerMain instance;
    private static final IProxy proxy;
    private static IServerProxy proxySinglePlayer;
    public static final boolean SINGLEPLAYER = true;
    public static final boolean LOCALHOST = false;
    public static ww tab;
    public static ww tabArmor;
    public static ww tabWeapon;
    public static HashSet destroyableBlocks;
    public static String serverIP;
    public static int kisselRenderId;
    public static akc fakeAir;
    public static aqz tramp;
    public static BlockCarousel carousel;
    public static BlockFunnel funnel;
    public static BlockAnomaly lighter;
    public static aqz coach;
    public static aqz electra;
    public static aqz steam;
    public static aqz kisselFluidBlock;
    public static BlockAnomalyNeighbor anomalyNeighbor;
    public static aqz radiation1;
    public static aqz radiation2;
    public static aqz radiation3;
    public static aqz chemical1;
    public static aqz chemical2;
    public static aqz chemical3;
    public static aqz biological1;
    public static aqz biological2;
    public static aqz biological3;
    public static aqz psycho;
    public static aqz machineGun;
    public static aqz flag;
    public static aqz respawnBlock;
    public static aqz stalkerWood;
    public static aqz stalkerStairs;
    public static aqz stalkerLadder;
    public static aqz stalkerDoor;
    public static aqz stalkerChest;
    public static Fluid kisselFluid;
    public static yc testArtefakt;
    public static yc radiationDetector;
    public static yc chemicalDetector;
    public static yc biologicalDetector;
    public static yc medicine1;
    public static yc medicine2;
    public static yc medicine3;
    public static yc bandage;
    public static yc radiationProtector;
    public static yc biologicalProtector;
    public static yc psychoProtector;
    public static yc novokaine;
    public static yc vodka;
    public static yc emptyBottle;
    public static yc backpack1;
    public static yc backpack2;
    public static yc backpack3;
    public static yc handcuffs;
    public static yc rope;
    public static yc key;
    public static yc flagAxe;
    public static yc flagSword;
    public static yc itemStalkerDoor;
    public static ItemExplosive explosive;
    public static yc turrel1;
    public static yc turrel2;
    public static yc turrel3;
    public static yc flashlight;
    public static yc silencer;
    public static yc sight;
    public SmartMovingHelper smHelper;
    public static IFlagManager flagManager;
    public static IClanManager clanManager;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent par1) {
        try {
            proxySinglePlayer = (IServerProxy)CommonProxy.class.newInstance();
            proxySinglePlayer.preInit(par1);
        }
        catch (InstantiationException e2) {
            e2.printStackTrace();
        }
        catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        proxy.preInit(par1);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent par1) {
        long time = System.currentTimeMillis();
        proxySinglePlayer.init(par1);
        proxy.init(par1);
        Logger.console("Proxy is loaded (" + (System.currentTimeMillis() - time) + " ms)");
        time = System.currentTimeMillis();
        Config.readConfig();
        tab = new StalkerTab();
        tabArmor = new ArmorTab();
        tabWeapon = new WeaponTab();
        ItemsConfig.readConfig();
        Logger.console("Custom items config is read (" + (System.currentTimeMillis() - time) + " ms)");
        time = System.currentTimeMillis();
        this.registerBlocks();
        this.registerItems();
        this.registerEntities();
        this.registerExplosibleBlocks();
        Logger.console("Items, blocks and entities are loaded (" + (System.currentTimeMillis() - time) + " ms)");
        if (proxy instanceof IClientProxy) {
            ((IClientProxy)proxy).registerRenderers();
            time = System.currentTimeMillis();
            Logger.console("Renderers are registered (" + (System.currentTimeMillis() - time) + " ms)");
        }
        NetworkRegistry.instance().registerGuiHandler((Object)this, (IGuiHandler)new GuiHandler());
    }

    private void registerExplosibleBlocks() {
        HashSet<Integer> blocks = new HashSet<Integer>();
        blocks.add(StalkerMain.stalkerWood.cF);
        blocks.add(StalkerMain.stalkerStairs.cF);
        blocks.add(StalkerMain.stalkerLadder.cF);
        blocks.add(StalkerMain.stalkerDoor.cF);
        blocks.add(StalkerMain.stalkerChest.cF);
        explosive.applyExplosibleBlocks(blocks);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent par1) {
        this.smHelper = new SmartMovingHelper();
        proxySinglePlayer.postInit(par1);
        proxy.postInit(par1);
    }

    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent par1) throws Exception {
        proxySinglePlayer.serverStart(par1);
        if (proxy instanceof IServerProxy) {
            ((IServerProxy)proxy).serverStart(par1);
        }
    }

    private void registerEntities() {
        int entityId = 1;
        int var2 = entityId + 1;
        EntityRegistry.registerModEntity(EntityBullet.class, (String)"EntityBullet", (int)entityId, (Object)this, (int)64, (int)10000, (boolean)true);
        EntityRegistry.registerModEntity(EntityShot.class, (String)"EntityLight", (int)var2++, (Object)this, (int)64, (int)3, (boolean)true);
        EntityRegistry.registerModEntity(EntityGrenade.class, (String)"EntityGrenade", (int)var2++, (Object)this, (int)64, (int)10000, (boolean)true);
        EntityRegistry.registerModEntity(EntitySleeve.class, (String)"EntitySleeve", (int)var2++, (Object)this, (int)64, (int)3, (boolean)true);
        EntityRegistry.registerModEntity(EntityRail.class, (String)"EntityRail", (int)var2++, (Object)this, (int)64, (int)10000, (boolean)true);
        EntityRegistry.registerModEntity(EntityExplosive.class, (String)"EntityExplosive", (int)var2++, (Object)this, (int)64, (int)10000, (boolean)true);
        EntityRegistry.registerModEntity(EntityTurrel1.class, (String)"EntityTurrel1", (int)var2++, (Object)this, (int)64, (int)10000, (boolean)true);
        EntityRegistry.registerModEntity(EntityTurrel2.class, (String)"EntityTurrel2", (int)var2++, (Object)this, (int)64, (int)10000, (boolean)true);
        EntityRegistry.registerModEntity(EntityTurrel3.class, (String)"EntityTurrel3", (int)var2++, (Object)this, (int)64, (int)10000, (boolean)true);
        EntityRegistry.registerModEntity(EntityCorpse.class, (String)"EntityCorpse", (int)var2++, (Object)this, (int)64, (int)20, (boolean)true);
        EntityRegistry.registerGlobalEntityID(EntityZombieShooter.class, (String)"EntityZombieShooter", (int)118, (int)20496, (int)0xFFFFFF);
    }

    public void registerBlocks() {
        BlockAnomalyNeighbor var18;
        fakeAir = new MaterialFakeAir(ake.b);
        int blockID = 3100;
        int var3 = blockID + 1;
        BlockTrampoline var10000 = new BlockTrampoline(var3++, new AnomalyDrop(Config.trampolineDrop));
        tramp = var10000.c("tramp");
        BlockCarousel var4 = new BlockCarousel(var3++, new AnomalyDrop(Config.carouselDrop));
        carousel = (BlockCarousel)var4.c("carousel");
        BlockFunnel var5 = new BlockFunnel(var3++, new AnomalyDrop(Config.blackHoleDrop));
        funnel = (BlockFunnel)var5.c("hole");
        BlockLighter var6 = new BlockLighter(var3++, new AnomalyDrop(Config.lighterDrop));
        lighter = (BlockAnomaly)var6.c("lighter");
        BlockCoach var7 = new BlockCoach(var3++, new AnomalyDrop(Config.coachDrop));
        coach = var7.c("coach");
        BlockElectra var8 = new BlockElectra(var3++, new AnomalyDrop(Config.electraDrop));
        electra = var8.c("electra");
        BlockSteam var9 = new BlockSteam(var3++, new AnomalyDrop(Config.steamDrop));
        steam = var9.c("steam");
        BlockDebuff var10 = new BlockDebuff(var3++, 0, 1, 5);
        radiation1 = var10.c("radiation1");
        var10 = new BlockDebuff(var3++, 0, 2, 5);
        radiation2 = var10.c("radiation2");
        var10 = new BlockDebuff(var3++, 0, 3, 5);
        radiation3 = var10.c("radiation3");
        var10 = new BlockDebuff(var3++, 1, 1, 5);
        chemical1 = var10.c("chemical1");
        var10 = new BlockDebuff(var3++, 1, 2, 5);
        chemical2 = var10.c("chemical2");
        var10 = new BlockDebuff(var3++, 1, 3, 5);
        chemical3 = var10.c("chemical3");
        var10 = new BlockDebuff(var3++, 2, 1, 5);
        biological1 = var10.c("biological1");
        var10 = new BlockDebuff(var3++, 2, 2, 5);
        biological2 = var10.c("biological2");
        var10 = new BlockDebuff(var3++, 2, 3, 5);
        biological3 = var10.c("biological3");
        var10 = new BlockDebuff(var3++, 3, 3, 5);
        psycho = var10.c("psycho");
        BlockMachineGun var11 = new BlockMachineGun(var3++);
        machineGun = var11;
        int kisselId = var3++;
        BlockFlag var12 = new BlockFlag(var3++);
        flag = var12;
        BlockRespawn var13 = new BlockRespawn(var3++);
        respawnBlock = var13;
        aqz var14 = new aqz(var3++, akc.d);
        stalkerWood = var14.c(1.0f).b(5.0f).a(aqz.h).c("stalker_wood").a(tab).d("stalker:wood");
        StalkerBlockStairs var15 = new StalkerBlockStairs(var3++, stalkerWood, 1);
        stalkerStairs = var15.c("stalker_stairs").d("stalker:wood").a(tab);
        BlockStalkerLadder var16 = new BlockStalkerLadder(var3++);
        stalkerLadder = var16.c(0.4f).a(aqz.q).c("stalker_ladder").d("stalker:ladder").a(tab);
        StalkerDoor var17 = new StalkerDoor(var3++);
        stalkerDoor = var17.c(3.0f).a(aqz.h).c("stalker_door").d("stalker:door");
        aqz.x[StalkerMain.stalkerStairs.cF] = true;
        anomalyNeighbor = var18 = new BlockAnomalyNeighbor(var3++);
        StalkerChest var19 = new StalkerChest(var3++);
        stalkerChest = var19.a(tab).c(2.5f).a(aqz.h).c("stalker_chest");
        kisselFluid = new Fluid("kisselFluid").setBlockID(kisselId);
        FluidRegistry.registerFluid((Fluid)kisselFluid);
        kisselFluidBlock = new BlockKisselFluid(kisselId, kisselFluid);
        GameRegistry.registerBlock((aqz)kisselFluidBlock, (String)"kisselFluidBlock");
        kisselFluid.setUnlocalizedName(kisselFluidBlock.a());
        LanguageRegistry.addName((Object)kisselFluidBlock, (String)"\u041a\u0438\u0441\u0435\u043b\u044c");
        GameRegistry.registerBlock((aqz)carousel, (String)"Carousel");
        GameRegistry.registerBlock((aqz)tramp, (String)"Trampoline");
        GameRegistry.registerBlock((aqz)funnel, (String)"BlackHole");
        GameRegistry.registerBlock((aqz)lighter, (String)"Lighter");
        GameRegistry.registerBlock((aqz)coach, (String)"Coach");
        GameRegistry.registerBlock((aqz)electra, (String)"Electra");
        GameRegistry.registerBlock((aqz)steam, (String)"Steam");
        GameRegistry.registerBlock((aqz)radiation1, (String)"Radiation (Level 1)");
        GameRegistry.registerBlock((aqz)radiation2, (String)"Radiation (Level 2)");
        GameRegistry.registerBlock((aqz)radiation3, (String)"Radiation (Level 3)");
        GameRegistry.registerBlock((aqz)chemical1, (String)"Chemical cont. (Level 1)");
        GameRegistry.registerBlock((aqz)chemical2, (String)"Chemical cont. (Level 2)");
        GameRegistry.registerBlock((aqz)chemical3, (String)"Chemical cont. (Level 3)");
        GameRegistry.registerBlock((aqz)biological1, (String)"Biological cont. (Level 1)");
        GameRegistry.registerBlock((aqz)biological2, (String)"Biological cont. (Level 2)");
        GameRegistry.registerBlock((aqz)biological3, (String)"Biological cont. (Level 3)");
        GameRegistry.registerBlock((aqz)psycho, (String)"Psycho cont.");
        GameRegistry.registerBlock((aqz)respawnBlock, (String)"Respawn");
        GameRegistry.registerBlock((aqz)stalkerWood, (String)"StalkerWood");
        GameRegistry.registerBlock((aqz)stalkerStairs, (String)"StalkerStairs");
        GameRegistry.registerBlock((aqz)stalkerLadder, (String)"StalkerLadder");
        GameRegistry.registerBlock((aqz)stalkerDoor, (String)"StalkerDoor");
        GameRegistry.registerBlock((aqz)stalkerChest, (String)"StalkerChest");
        GameRegistry.registerBlock((aqz)anomalyNeighbor, (String)"AnomalyNeighbor");
        GameRegistry.registerBlock((aqz)flag, ItemFlag.class, (String)"Flag");
        GameRegistry.registerBlock((aqz)machineGun, ItemMachineGun.class, (String)"Machine Gun");
        GameRegistry.registerTileEntity(TileEntitySteam.class, (String)"steamTile");
        GameRegistry.registerTileEntity(TileEntityMachineGun.class, (String)"MachineGunTile");
        GameRegistry.registerTileEntity(TileEntityFunnel.class, (String)"BlackHoleTile");
        GameRegistry.registerTileEntity(TileEntityTrampoline.class, (String)"TrampolineTile");
        GameRegistry.registerTileEntity(TileEntityLighter.class, (String)"LighterTile");
        GameRegistry.registerTileEntity(TileEntityElectra.class, (String)"ElectraTile");
        GameRegistry.registerTileEntity(TileEntityCoach.class, (String)"CoachTile");
        GameRegistry.registerTileEntity(TileEntityCarousel.class, (String)"CarouselTile");
        GameRegistry.registerTileEntity(TileEntityKissel.class, (String)"KisselTile");
        GameRegistry.registerTileEntity(TileEntityFlag.class, (String)"FlagTile");
        LanguageRegistry.addName((Object)tramp, (String)"\u0411\u0430\u0442\u0443\u0442");
        LanguageRegistry.addName((Object)carousel, (String)"\u041a\u0430\u0440\u0443\u0441\u0435\u043b\u044c");
        LanguageRegistry.addName((Object)funnel, (String)"\u0412\u043e\u0440\u043e\u043d\u043a\u0430");
        LanguageRegistry.addName((Object)lighter, (String)"\u0416\u0430\u0440\u043a\u0430");
        LanguageRegistry.addName((Object)coach, (String)"\u0422\u0440\u0435\u043d\u0435\u0440");
        LanguageRegistry.addName((Object)electra, (String)"\u042d\u043b\u0435\u043a\u0442\u0440\u0430");
        LanguageRegistry.addName((Object)steam, (String)"\u041f\u0430\u0440");
        LanguageRegistry.addName((Object)radiation1, (String)"Radiation (Level 1)");
        LanguageRegistry.addName((Object)radiation2, (String)"Radiation (Level 2)");
        LanguageRegistry.addName((Object)radiation3, (String)"Radiation (Level 3)");
        LanguageRegistry.addName((Object)chemical1, (String)"Chemical cont. (Level 1)");
        LanguageRegistry.addName((Object)chemical2, (String)"Chemical cont. (Level 2)");
        LanguageRegistry.addName((Object)chemical3, (String)"Chemical cont. (Level 3)");
        LanguageRegistry.addName((Object)biological1, (String)"Biological cont. (Level 1)");
        LanguageRegistry.addName((Object)biological2, (String)"Biological cont. (Level 2)");
        LanguageRegistry.addName((Object)biological3, (String)"Biological cont. (Level 3)");
        LanguageRegistry.addName((Object)psycho, (String)"Psycho cont.");
        LanguageRegistry.addName((Object)stalkerWood, (String)"\u0421\u0442\u0440\u043e\u0438\u0442\u0435\u043b\u044c\u043d\u044b\u0439 \u0431\u043b\u043e\u043a");
        LanguageRegistry.addName((Object)stalkerStairs, (String)"\u0421\u0442\u0443\u043f\u0435\u043d\u044c\u043a\u0438");
        LanguageRegistry.addName((Object)stalkerLadder, (String)"\u041b\u0435\u0441\u0442\u043d\u0438\u0446\u0430");
        LanguageRegistry.addName((Object)stalkerDoor, (String)"\u0414\u0432\u0435\u0440\u044c");
        LanguageRegistry.addName((Object)stalkerChest, (String)"\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435");
    }

    public void registerItems() {
        ItemExplosive var13;
        int itemID = 14700;
        int var2 = itemID + 1;
        ItemDetector var10000 = new ItemDetector(var2++, new int[]{StalkerMain.radiation1.cF, StalkerMain.radiation2.cF, StalkerMain.radiation3.cF}, "radiation_detector", "\u0414\u0435\u0442\u0435\u043a\u0442\u043e\u0440 \u0440\u0430\u0434\u0438\u0430\u0446\u0438\u0438");
        radiationDetector = var10000;
        var10000 = new ItemDetector(var2++, new int[]{StalkerMain.chemical1.cF, StalkerMain.chemical2.cF, StalkerMain.chemical3.cF}, "chemical_detector", "\u0422\u0435\u0440\u043c\u043e\u043c\u0435\u0442\u0440");
        chemicalDetector = var10000;
        var10000 = new ItemDetector(var2++, new int[]{StalkerMain.biological1.cF, StalkerMain.biological2.cF, StalkerMain.biological3.cF}, "biological_detector", "\u0414\u0435\u0442\u0435\u043a\u0442\u043e\u0440 \u0431\u0438\u043e\u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044f");
        biologicalDetector = var10000;
        ItemMedicine var3 = new ItemMedicine(var2++, "medicine_a", "\u0410\u043f\u0442\u0435\u0447\u043a\u0430 \u0418\u043d\u0434\u0438\u0432\u0438\u0434\u0443\u0430\u043b\u044c\u043d\u0430\u044f", 5, new int[]{0, 0, 0, 0}, false, 200, "medicine");
        medicine1 = var3;
        var3 = new ItemMedicine(var2++, "medicine_b", "\u0410\u043f\u0442\u0435\u0447\u043a\u0430 \u0410\u0440\u043c\u0435\u0439\u0441\u043a\u0430\u044f", 10, new int[]{0, 0, 0, 0}, false, 400, "medicine");
        medicine2 = var3;
        var3 = new ItemMedicine(var2++, "medicine_c", "\u0410\u043f\u0442\u0435\u0447\u043a\u0430 \u041d\u0430\u0443\u0447\u043d\u0430\u044f", 10, new int[]{-2, 0, -2, 0}, false, 400, "medicine");
        medicine3 = var3;
        var3 = new ItemMedicine(var2++, "bandage", "\u0411\u0438\u043d\u0442", 2, new int[]{0, 0, 0, 0}, true, 50, "medicine");
        bandage = var3;
        var3 = new ItemMedicine(var2++, "radiation_protector", "\u0420\u0430\u0434\u0438\u043e\u043f\u0440\u043e\u0442\u0435\u043a\u0442\u043e\u0440", 0, new int[]{-3, 0, 0, 0}, false, 500, "medicine");
        radiationProtector = var3;
        var3 = new ItemMedicine(var2++, "biological_protector", "\u0410\u043d\u0442\u0438\u0434\u043e\u0442", 0, new int[]{0, 0, -3, 0}, false, 500, "medicine");
        biologicalProtector = var3;
        var3 = new ItemMedicine(var2++, "psycho_protector", "\u041f\u0441\u0438-\u0431\u043b\u043e\u043a\u0430\u0434\u0430", 0, new int[]{0, 0, 0, -1}, false, 700, "medicine");
        psychoProtector = var3;
        var3 = new ItemMedicine(var2++, "novokaine", "\u041d\u043e\u0432\u043e\u043a\u0430\u0438\u043d", 2, new int[]{0, 0, 0, 0}, false, 20, "medicine");
        ++var2;
        new ItemEnergy(var2);
        novokaine = var3;
        ItemVodka var5 = new ItemVodka(var2++);
        vodka = var5;
        ItemEmptyBottle var6 = new ItemEmptyBottle(var2++);
        emptyBottle = var6;
        ItemBackpack var7 = new ItemBackpack(var2++, "backpack_a", "\u041c\u0430\u043b\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a", 10);
        backpack1 = var7;
        var7 = new ItemBackpack(var2++, "backpack_b", "\u0421\u0440\u0435\u0434\u043d\u0438\u0439 \u0440\u044e\u043a\u0437\u0430\u043a", 20);
        backpack2 = var7;
        var7 = new ItemBackpack(var2++, "backpack_c", "\u0411\u043e\u043b\u044c\u0448\u043e\u0439 \u0440\u044e\u043a\u0437\u0430\u043a", 30);
        backpack3 = var7;
        ItemHandcuffs var8 = new ItemHandcuffs(var2++);
        handcuffs = var8;
        ItemRope var9 = new ItemRope(var2++);
        rope = var9;
        ItemKey var10 = new ItemKey(var2++);
        key = var10;
        ItemCrossbow var10001 = new ItemCrossbow(var2++);
        var10001.b("crossbow");
        ItemRailgun var4 = new ItemRailgun(var2++);
        var4.b("railgun");
        new ItemBullet(14955, "\u041f\u0443\u043b\u0435\u043c\u0435\u0442\u043d\u0430\u044f \u043b\u0435\u043d\u0442\u0430", "machinegun_shell", new ArrayList(), 1);
        Object var11 = new yc(var2++);
        flagAxe = var11.b("flag_axe").d(1).d("wood_axe").a(tab).q();
        var11 = new yc(var2++);
        flagSword = var11.b("flag_sword").d(1).d("wood_sword").a(tab).q();
        ItemStalkerDoor var12 = new ItemStalkerDoor(var2++);
        itemStalkerDoor = var12;
        explosive = var13 = new ItemExplosive(var2++);
        ItemTurrel1 var14 = new ItemTurrel1(var2++);
        turrel1 = var14;
        ItemTurrel2 var15 = new ItemTurrel2(var2++);
        turrel2 = var15;
        ItemTurrel3 var16 = new ItemTurrel3(var2++);
        turrel3 = var16;
        ItemFlashlight var17 = new ItemFlashlight(var2++);
        flashlight = var17.b("flashlight").d(1).d("stalker:flashlight");
        int n2 = var2++;
        var11 = new yc(n2).a(tab);
        silencer = var11.b("silencer").d(1).d("stalker:silencer");
        int n3 = var2++;
        var11 = new yc(n3).a(tab);
        sight = var11.b("sight").d(1).d("stalker:sight");
        var11 = new ItemSkin(var2++, "\u0442\u0443\u043f\u043e \u0441\u043a\u0438\u043d", "test");
        LanguageRegistry.addName((Object)flashlight, (String)"\u0424\u043e\u043d\u0430\u0440\u0438\u043a");
        LanguageRegistry.addName((Object)silencer, (String)"\u0413\u043b\u0443\u0448\u0438\u0442\u0435\u043b\u044c");
        LanguageRegistry.addName((Object)sight, (String)"\u041e\u043f\u0442\u0438\u0447\u0435\u0441\u043a\u0438\u0439 \u043f\u0440\u0438\u0446\u0435\u043b");
    }

    public static IProxy getProxy() {
        return FMLCommonHandler.instance().getEffectiveSide().isServer() ? proxySinglePlayer : proxy;
    }

    static {
        proxy = new ProxyInstance("ru.stalcraft.client.ClientProxy", "ru.stalcraft.server.CommonProxy").getProxy();
        destroyableBlocks = new HashSet();
    }
}

