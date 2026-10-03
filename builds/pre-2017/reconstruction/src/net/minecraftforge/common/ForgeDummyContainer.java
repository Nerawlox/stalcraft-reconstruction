/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.client.FMLFileResourcePack;
import cpw.mods.fml.client.FMLFolderResourcePack;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.WorldAccessContainer;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.NetworkMod;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.classloading.FMLForgePlugin;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.Property;
import net.minecraftforge.common.network.ForgeConnectionHandler;
import net.minecraftforge.common.network.ForgeNetworkHandler;
import net.minecraftforge.common.network.ForgePacketHandler;
import net.minecraftforge.common.network.ForgeTinyPacketHandler;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.server.command.ForgeCommand;

@NetworkMod(channels={"FORGE"}, connectionHandler=ForgeConnectionHandler.class, packetHandler=ForgePacketHandler.class, tinyPacketHandler=ForgeTinyPacketHandler.class)
public class ForgeDummyContainer
extends DummyModContainer
implements WorldAccessContainer {
    public static int clumpingThreshold = 64;
    public static boolean removeErroringEntities = false;
    public static boolean removeErroringTileEntities = false;
    public static boolean disableStitchedFileSaving = false;
    public static boolean forceDuplicateFluidBlockCrash = true;
    public static boolean fullBoundingBoxLadders = false;
    public static double zombieSummonBaseChance = 0.1;
    public static int[] blendRanges = new int[]{20, 15, 10, 5};
    public static float zombieBabyChance = 0.05f;
    public static boolean shouldSortRecipies = false;

    public ForgeDummyContainer() {
        super(new ModMetadata());
        Property property;
        ModMetadata modMetadata = this.getMetadata();
        modMetadata.modId = "Forge";
        modMetadata.name = "Minecraft Forge";
        modMetadata.version = String.format("%d.%d.%d.%d", 9, 11, 1, 1345);
        modMetadata.credits = "Made possible with help from many people";
        modMetadata.authorList = Arrays.asList("LexManos", "Eloraam", "Spacetoad");
        modMetadata.description = "Minecraft Forge is a common open source API allowing a broad range of mods to work cooperatively together. It allows many mods to be created without them editing the main Minecraft code.";
        modMetadata.url = "http://MinecraftForge.net";
        modMetadata.updateUrl = "http://MinecraftForge.net/forum/index.php/topic,5.0.html";
        modMetadata.screenshots = new String[0];
        modMetadata.logoFile = "/forge_logo.png";
        Configuration configuration = null;
        File file = new File(Loader.instance().getConfigDir(), "forge.cfg");
        try {
            configuration = new Configuration(file);
        }
        catch (Exception exception) {
            System.out.println("Error loading forge.cfg, deleting file and resetting: ");
            exception.printStackTrace();
            if (file.exists()) {
                file.delete();
            }
            configuration = new Configuration(file);
        }
        if (!configuration.isChild) {
            configuration.load();
            property = configuration.get("general", "enableGlobalConfig", false);
            if (property.getBoolean(false)) {
                Configuration.enableGlobalConfig();
            }
        }
        property = configuration.get("general", "clumpingThreshold", 64);
        property.comment = "Controls the number threshold at which Packet51 is preferred over Packet52, default and minimum 64, maximum 1024";
        clumpingThreshold = property.getInt(64);
        if (clumpingThreshold > 1024 || clumpingThreshold < 64) {
            clumpingThreshold = 64;
            property.set(64);
        }
        property = configuration.get("general", "removeErroringEntities", false);
        property.comment = "Set this to just remove any TileEntity that throws a error in there update method instead of closing the server and reporting a crash log. BE WARNED THIS COULD SCREW UP EVERYTHING USE SPARINGLY WE ARE NOT RESPONSIBLE FOR DAMAGES.";
        removeErroringEntities = property.getBoolean(false);
        if (removeErroringEntities) {
            FMLLog.warning("Enabling removal of erroring Entities - USE AT YOUR OWN RISK", new Object[0]);
        }
        property = configuration.get("general", "removeErroringTileEntities", false);
        property.comment = "Set this to just remove any TileEntity that throws a error in there update method instead of closing the server and reporting a crash log. BE WARNED THIS COULD SCREW UP EVERYTHING USE SPARINGLY WE ARE NOT RESPONSIBLE FOR DAMAGES.";
        removeErroringTileEntities = property.getBoolean(false);
        if (removeErroringTileEntities) {
            FMLLog.warning("Enabling removal of erroring Tile Entities - USE AT YOUR OWN RISK", new Object[0]);
        }
        property = configuration.get("general", "fullBoundingBoxLadders", false);
        property.comment = "Set this to check the entire entity's collision bounding box for ladders instead of just the block they are in. Causes noticable differences in mechanics so default is vanilla behavior. Default: false";
        fullBoundingBoxLadders = property.getBoolean(false);
        property = configuration.get("general", "forceDuplicateFluidBlockCrash", true);
        property.comment = "Set this to force a crash if more than one block attempts to link back to the same Fluid. Enabled by default.";
        forceDuplicateFluidBlockCrash = property.getBoolean(true);
        if (!forceDuplicateFluidBlockCrash) {
            FMLLog.warning("Disabling forced crashes on duplicate Fluid Blocks - USE AT YOUR OWN RISK", new Object[0]);
        }
        property = configuration.get("general", "biomeSkyBlendRange", new int[]{20, 15, 10, 5});
        property.comment = "Control the range of sky blending for colored skies in biomes.";
        blendRanges = property.getIntList();
        property = configuration.get("general", "zombieBaseSummonChance", 0.1);
        property.comment = "Base zombie summoning spawn chance. Allows changing the bonus zombie summoning mechanic.";
        zombieSummonBaseChance = property.getDouble(0.1);
        property = configuration.get("general", "zombieBabyChance", 0.05);
        property.comment = "Chance that a zombie (or subclass) is a baby. Allows changing the zombie spawning mechanic.";
        zombieBabyChance = (float)property.getDouble(0.05);
        property = configuration.get("general", "sortRecipies", shouldSortRecipies);
        property.comment = "Set to true to enable the post initlization sorting of crafting recipes using Froge's sorter. May cause desyncing on conflicting recipies. ToDo: Set to true by default in 1.7";
        shouldSortRecipies = property.getBoolean(shouldSortRecipies);
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    @Override
    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        eventBus.register(this);
        return true;
    }

    @Subscribe
    public void modConstruction(FMLConstructionEvent fMLConstructionEvent) {
        FMLLog.info("Registering Forge Packet Handler", new Object[0]);
        try {
            FMLNetworkHandler.instance().registerNetworkMod(new ForgeNetworkHandler(this));
            FMLLog.info("Succeeded registering Forge Packet Handler", new Object[0]);
        }
        catch (Exception exception) {
            FMLLog.log(Level.SEVERE, exception, "Failed to register packet handler for Forge", new Object[0]);
        }
    }

    @Subscribe
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        ForgeChunkManager.captureConfig(fMLPreInitializationEvent.getModConfigurationDirectory());
    }

    @Subscribe
    public void postInit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        BiomeDictionary.registerAllBiomesAndGenerateEvents();
        ForgeChunkManager.loadConfiguration();
    }

    @Subscribe
    public void onAvalible(FMLLoadCompleteEvent fMLLoadCompleteEvent) {
        if (shouldSortRecipies) {
            RecipeSorter.sortCraftManager();
        }
    }

    @Subscribe
    public void serverStarting(FMLServerStartingEvent fMLServerStartingEvent) {
        fMLServerStartingEvent.registerServerCommand(new ForgeCommand(fMLServerStartingEvent.getServer()));
    }

    @Override
    public NBTTagCompound getDataForWriting(plxv plxv2, WorldInfo worldInfo) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        NBTTagCompound nBTTagCompound2 = DimensionManager.saveDimensionDataMap();
        nBTTagCompound._a("DimensionData", nBTTagCompound2);
        return nBTTagCompound;
    }

    @Override
    public void readData(plxv plxv2, WorldInfo worldInfo, Map<String, NBTBase> map, NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("DimensionData")) {
            DimensionManager.loadDimensionDataMap(nBTTagCompound._c("DimensionData") ? nBTTagCompound._m("DimensionData") : null);
        }
    }

    @Override
    public File getSource() {
        return FMLForgePlugin.forgeLocation;
    }

    @Override
    public Class<?> getCustomResourcePackClass() {
        if (this.getSource().isDirectory()) {
            return FMLFolderResourcePack.class;
        }
        return FMLFileResourcePack.class;
    }
}

