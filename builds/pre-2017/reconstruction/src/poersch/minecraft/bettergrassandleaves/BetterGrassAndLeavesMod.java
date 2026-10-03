/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.jgro;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.event.ForgeSubscribe;
import poersch.minecraft.bettergrassandleaves.renderer.BetterBloodRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLeavesRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;
import poersch.minecraft.util.ResourceHelper;
import poersch.minecraft.util.StringHelper;
import poersch.minecraft.util.gui.GuiModSettings;
import poersch.minecraft.util.gui.ISettingsUpdatedCallback;
import poersch.minecraft.util.keyhandler.IKeyReleasedCallback;
import poersch.minecraft.util.keyhandler.KeyReleasedHandler;
import poersch.minecraft.util.options.Option;
import poersch.minecraft.util.options.OptionBitList;
import poersch.minecraft.util.options.OptionChoice;
import poersch.minecraft.util.options.OptionInterval;
import poersch.minecraft.util.options.OptionOffFastFancy;
import poersch.minecraft.util.options.OptionOffOn;
import poersch.minecraft.util.options.OptionStringList;

@Mod(modid="BetterGrassAndLeavesMod", name="Better Grass & Leaves Mod", version="1.6.4.D")
@NetworkMod(clientSideRequired=false, serverSideRequired=false)
public class BetterGrassAndLeavesMod
implements ISettingsUpdatedCallback,
IKeyReleasedCallback {
    public static final String modID = "BetterGrassAndLeavesMod";
    public static final String modName = "Better Grass & Leaves Mod";
    public static final String modDomain = "bettergrassandleaves";
    public static final String modVersion = "1.6.4.D";
    public static final String modDescription = (Object)((Object)EnumChatFormatting._j) + "Better Grass & Leaves" + (Object)((Object)EnumChatFormatting._p) + " is a small mod which extends grass and leaves by a few juicy pixels.";
    public static final String modAuthor = "Poersch";
    public static final String modURL = "http://bit.ly/better-grass-and-leaves";
    public static final String modUpdateURL = "http://cantdie.com/uploads/better-grass-and-leaves-mod/";
    public static final String modVersionURL = "https://dl.dropboxusercontent.com/u/6971729/Minecraft%20Mods/BetterGrassAndLeaves/releases/versions.txt";
    public static final String modLogo = "assets/bettergrassandleaves/textures/logo.png";
    @Mod.Instance(value="BetterGrassAndLeavesMod")
    public static BetterGrassAndLeavesMod modInstance;
    public static Logger logger;
    private static Minecraft minecraft;
    public static boolean modActive;
    public static boolean workingRegisterIconsHook;
    public static HashMap<String, Integer> blockMap;
    public static List<Option> modOptions;
    public static OptionOffOn renderBetterGrass;
    public static OptionChoice currentGrassRenderer;
    public static OptionOffFastFancy renderGrassSides;
    public static OptionOffOn renderSnowedGrass;
    public static OptionOffFastFancy renderGrassFX;
    public static OptionInterval averageGrassHeight;
    public static OptionInterval betterGrassBrightness;
    public static OptionBitList allowBetterGrass;
    public static OptionOffOn renderBetterCacti;
    public static OptionInterval betterCactiBrightness;
    public static OptionOffOn renderBetterSeaweed;
    public static OptionInterval algaePopulation;
    public static OptionInterval betterAlgaeBrightness;
    public static OptionBitList algaeHostingBiomes;
    public static OptionInterval reedPopulation;
    public static OptionInterval reedOffshorePopulation;
    public static OptionInterval betterReedBrightness;
    public static OptionBitList reedHostingBiomes;
    public static OptionOffOn renderBetterCorals;
    public static OptionInterval coralPopulation;
    public static OptionInterval maximumCoralDepth;
    public static OptionInterval minimumCoralDepth;
    public static OptionInterval betterCoralsBrightness;
    public static OptionBitList coralHostingBiomes;
    public static OptionInterval bubblesFXSpawnRate;
    public static OptionOffOn renderBetterLeaves;
    public static OptionChoice currentLeavesRenderer;
    public static OptionOffOn renderSnowedLeaves;
    public static OptionOffFastFancy renderLeavesFX;
    public static OptionInterval leavesFXSpawnRate;
    public static OptionOffOn useRoundedVanillaLeaves;
    public static OptionOffOn renderOnlyOuterLeaves;
    public static OptionInterval betterLeavesBrightness;
    public static OptionOffFastFancy renderFootprintsFX;
    public static OptionInterval soulsFXSpawnRate;
    public static OptionOffOn renderBetterLilyPads;
    public static OptionInterval lilyPadFlowerPopulation;
    public static OptionInterval betterLilyPadsBrightness;
    public static OptionOffOn renderBetterNetherrack;
    public static OptionInterval betterNetherrackBrightness;
    public static OptionOffOn renderBetterLadders;
    public static OptionOffFastFancy waterSuspendedFX;
    public static OptionOffOn bloodFX;
    public static OptionOffOn useRegisterIconsHook;
    public static OptionChoice textureSource;
    public static OptionStringList blackList;
    public static OptionStringList addBloodTo;
    public static OptionStringList addRendererTo;
    public static OptionStringList whiteList;
    public static OptionOffOn debugMode;
    public static Option[] modIngameOptions;
    public static Configuration modConfig;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        ModMetadata modMetadata = fMLPreInitializationEvent.getModMetadata();
        modMetadata.autogenerated = false;
        modMetadata.description = modDescription;
        modMetadata.authorList.add(modAuthor);
        modMetadata.url = modURL;
        modMetadata.logoFile = modLogo;
        modConfig = new Configuration(fMLPreInitializationEvent.getSuggestedConfigurationFile());
        modConfig.load();
        Property property = modConfig.get("internal", "modVersion", "-1.6.4.D");
        if (!property.getString().equals(modVersion)) {
            property.set(modVersion);
            Configuration configuration = modConfig;
            ConfigCategory object = modConfig.getCategory("general");
            if (object != null) {
                modConfig.removeCategory(object);
            }
        }
        for (Option option : modOptions) {
            Configuration configuration = modConfig;
            option.read(modConfig, "general");
        }
        modConfig.save();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        KeyReleasedHandler.create(0, "Toggle Better Grass & Leaves Mod", 67, this);
        KeyReleasedHandler.create(1, "Better Grass & Leaves Mod Settings", 68, this);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        for (Block object : Block.blocksList) {
            if (object == null) continue;
            blockMap.put(object.getClass().getName(), object.blockID);
        }
        if (((Boolean)BetterGrassAndLeavesMod.debugMode.value).booleanValue()) {
            String string = "[BGAL Debug Info] Known blocks: ";
            Set<Map.Entry<String, Integer>> set = blockMap.entrySet();
            for (Map.Entry entry : set) {
                string = string + entry.getKey() + "; ";
            }
            System.out.println(string);
            string = "[BGAL Debug Info] Known entities: ";
            Set set2 = jgro._a.entrySet();
            Iterator iterator2 = set2.iterator();
            while (iterator2.hasNext()) {
                Map.Entry entry;
                entry = (Map.Entry)iterator2.next();
                string = string + (String)entry.getKey() + "; ";
            }
            System.out.println(string);
        }
    }

    public static void updatePlugins(IconRegister iconRegister) {
        int n;
        Object object;
        Map<String, ModContainer> map = Loader.instance().getIndexedModList();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (Map.Entry<String, ModContainer> object22 : map.entrySet()) {
            object = ResourceHelper.getResource(modDomain, "plugins/" + object22.getKey() + ".ini");
            if (object == null) continue;
            try {
                StringHelper.readStreamIntoMap(object._a(), hashMap);
            }
            catch (Exception arrayList) {}
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, (Object[])BetterGrassAndLeavesMod.blackList.value);
        object = (String)hashMap.get("blackList");
        if (object != null) {
            arrayList.addAll(StringHelper.splitTrimToList((String)object, ','));
        }
        ArrayList<String> arrayList2 = new ArrayList<String>();
        Collections.addAll(arrayList2, (Object[])BetterGrassAndLeavesMod.addBloodTo.value);
        object = (String)hashMap.get("addBloodTo");
        if (object != null) {
            arrayList2.addAll(StringHelper.splitTrimToList((String)object, ','));
        }
        ArrayList<String> arrayList3 = new ArrayList<String>();
        Collections.addAll(arrayList3, (Object[])BetterGrassAndLeavesMod.addRendererTo.value);
        object = (String)hashMap.get("addRendererTo");
        if (object != null) {
            arrayList3.addAll(StringHelper.splitTrimToList((String)object, ','));
        }
        ArrayList<String> arrayList4 = new ArrayList<String>();
        Collections.addAll(arrayList4, (Object[])BetterGrassAndLeavesMod.whiteList.value);
        object = (String)hashMap.get("whiteList");
        if (object != null) {
            arrayList4.addAll(StringHelper.splitTrimToList((String)object, ','));
        }
        BlockRendererList.resetBlackList();
        for (String string : arrayList) {
            if (string.charAt(0) != '-') {
                try {
                    BlockRendererList.addToBlackList(Integer.parseInt(string));
                }
                catch (Exception exception) {
                    Integer n2 = blockMap.get(string);
                    if (n2 == null) continue;
                    BlockRendererList.addToBlackList(n2);
                }
                continue;
            }
            if (string.length() <= 1) continue;
            String string2 = string.substring(1);
            try {
                BlockRendererList.removeFromBlackList(Integer.parseInt(string2));
            }
            catch (Exception exception) {
                Integer n3 = blockMap.get(string2);
                if (n3 == null) continue;
                BlockRendererList.removeFromBlackList(n3);
            }
        }
        BetterBloodRenderer.resetBloodColors();
        for (n = 0; n < arrayList2.size(); ++n) {
            Object object2;
            List<String> list2 = StringHelper.splitTrimToList((String)arrayList2.get(n), ':');
            if (list2.size() <= 1 || (object2 = (Class)jgro._a.get(list2.get(0))) == null) continue;
            try {
                BetterBloodRenderer.setColorBetterBlood((Class)object2, Integer.parseInt(list2.get(1), 16));
                continue;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        BlockRendererList.resetRendererAssignments();
        for (n = 0; n < arrayList3.size(); ++n) {
            List<String> list3 = StringHelper.splitTrimToList((String)arrayList3.get(n), ':');
            if (list3.size() <= 1) continue;
            for (BlockRendererList blockRendererList : BlockRendererList.rendererList) {
                if (!list3.get(0).equals(blockRendererList.getRendererName())) continue;
                List<String> list4 = StringHelper.splitTrimToList(list3.get(1), ';');
                for (String string : list4) {
                    Integer n4;
                    if (string.charAt(0) != '-') {
                        try {
                            blockRendererList.assignToBlockID(Integer.parseInt(string));
                        }
                        catch (Exception exception) {
                            n4 = blockMap.get(string);
                            if (n4 == null) continue;
                            blockRendererList.assignToBlockID(n4);
                        }
                        continue;
                    }
                    if (string.length() <= 1) continue;
                    string = string.substring(1);
                    try {
                        blockRendererList.removeFromBlockID(Integer.parseInt(string));
                    }
                    catch (Exception exception) {
                        n4 = blockMap.get(string);
                        if (n4 == null) continue;
                        blockRendererList.removeFromBlockID(n4);
                    }
                }
            }
        }
        BetterLeavesRenderer.resetBetterLeavesLinkage();
        for (String string : arrayList4) {
            BetterLeavesRenderer.linkBetterLeavesTo(iconRegister, string);
        }
    }

    public static void info(String string) {
        logger.log(Level.INFO, string);
    }

    public static void error(String string, Throwable throwable) {
        logger.log(Level.SEVERE, string, throwable);
    }

    @SideOnly(value=Side.CLIENT)
    @ForgeSubscribe
    public void registerIcons(TextureStitchEvent.Pre pre) {
        if (((Boolean)BetterGrassAndLeavesMod.useRegisterIconsHook.value).booleanValue() && pre.map._m == 0) {
            workingRegisterIconsHook = true;
            BlockRendererList.onRegisterIconsHook(null, pre.map);
        }
    }

    @Override
    public void onKeyReleased(KeyReleasedHandler keyReleasedHandler) {
        if (BetterGrassAndLeavesMod.minecraft.__ab && BetterGrassAndLeavesMod.minecraft._t != null && BetterGrassAndLeavesMod.minecraft._t.capabilities._d) {
            if (keyReleasedHandler.id == 0) {
                boolean bl = modActive = !modActive;
                if (modActive) {
                    BetterGrassAndLeavesMod.info("Activated mod.");
                } else {
                    BetterGrassAndLeavesMod.info("Deactivated mod.");
                }
                BetterGrassAndLeavesMod.minecraft._s._b();
            } else if (keyReleasedHandler.id == 1) {
                minecraft._a(new GuiModSettings(modName, null, modIngameOptions, modConfig, this));
            }
        }
    }

    @Override
    public void onSettingsUpdated() {
        if (textureSource.gotChanged()) {
            minecraft._c();
        }
        BetterGrassAndLeavesMod.minecraft._s._b();
    }

    static {
        logger = Logger.getLogger(modID);
        minecraft = Minecraft._E();
        modActive = true;
        workingRegisterIconsHook = false;
        blockMap = new HashMap();
        modOptions = new ArrayList<Option>();
        renderBetterGrass = new OptionOffOn(modOptions, "renderBetterGrass", "Better Grass", "Render Better Grass?", "On");
        currentGrassRenderer = new OptionChoice(modOptions, "currentGrassRenderer", "Grass Renderer", "Which grass renderer should be used?", "Standard", new String[]{"Standard", "Experimental"});
        renderGrassSides = new OptionOffFastFancy(modOptions, "renderGrassSides", "Grass Sides", "Render Better Grass Sides?", "Fast");
        renderSnowedGrass = new OptionOffOn(modOptions, "renderSnowedGrass", "Snowed Grass", "Render Better Grass Snowed?", "On");
        renderGrassFX = new OptionOffFastFancy(modOptions, "renderGrassFX", "Moving Grass FX", "Render Moving Grass effect?", "Fancy");
        averageGrassHeight = new OptionInterval(modOptions, "averageGrassHeight", "Average Grass Height", "Height multiplier for Better Grass.", "0.5");
        betterGrassBrightness = new OptionInterval(modOptions, "betterGrassBrightness", "Better Grass Brightness", "Brightness multiplier of Better Grass.", "1.0");
        allowBetterGrass = new OptionBitList(modOptions, "allowBetterGrass", "Allow Better Grass", "The listed block IDs will allow Better Grass to render under them. (e.g. allowBetterGrass=0, 10, 20)", "0, 50, 63, 65, 68, 75, 76, 78, 85, 106, 107, 132", false, 4096);
        renderBetterCacti = new OptionOffOn(modOptions, "renderBetterCacti", "Better Cacti", "Render Better Cacti?", "On");
        betterCactiBrightness = new OptionInterval(modOptions, "betterCactiBrightness", "Better Cacti Brightness", "Brightness multiplier of Better Cacti.", "1.0");
        renderBetterSeaweed = new OptionOffOn(modOptions, "renderBetterSeaweed", "Better Seaweed", "Render Better Seaweed?", "On");
        algaePopulation = new OptionInterval(modOptions, "algaePopulation", "Algae Population", "Spawn frenquency multiplier for Better Algae.", "0.3");
        betterAlgaeBrightness = new OptionInterval(modOptions, "betterAlgaeBrightness", "Better Algae Brightness", "Brightness multiplier of Better Algae.", "1.0");
        algaeHostingBiomes = new OptionBitList(modOptions, "algaeHostingBiomes", "Algae Hosting Biomes", "The listed biome IDs will allow Better Algae to render.", "0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22", false, 256);
        reedPopulation = new OptionInterval(modOptions, "reedPopulation", "Reed Population", "Spawn frenquency multiplier for Better Reed.", "0.9");
        reedOffshorePopulation = new OptionInterval(modOptions, "reedOffshorePopulation", "Reed Offshore Population", "Spawn frenquency multiplier for offshore Better Reed.", "0.0");
        betterReedBrightness = new OptionInterval(modOptions, "betterReedBrightness", "Better Reed Brightness", "Brightness multiplier of Better Reed.", "1.0");
        reedHostingBiomes = new OptionBitList(modOptions, "reedHostingBiomes", "Reed Hosting Biomes", "The listed biome IDs will allow Better Reed to render.", "1, 4, 6, 14, 18, 21, 22", false, 256);
        renderBetterCorals = new OptionOffOn(modOptions, "renderBetterCorals", "Better Corals", "Render Better Corals?", "On");
        coralPopulation = new OptionInterval(modOptions, "coralPopulation", "Coral Population", "Spawn frenquency multiplier for Better Corals.", "0.8");
        maximumCoralDepth = new OptionInterval(modOptions, "maximumCoralDepth", "Maximum Coral Depth", "The lowest Y position at which Better Corals will render.", "50", 0.0f, 255.0f);
        minimumCoralDepth = new OptionInterval(modOptions, "minimumCoralDepth", "Minimum Coral Depth", "The highest Y position at which Better Corals will render.", "63", 0.0f, 255.0f);
        betterCoralsBrightness = new OptionInterval(modOptions, "betterCoralsBrightness", "Better Corals Brightness", "Brightness multiplier of Better Corals.", "1.0");
        coralHostingBiomes = new OptionBitList(modOptions, "coralHostingBiomes", "Coral Hosting Biomes", "The listed biome IDs will allow Better Corals to render.", "0, 16", false, 256);
        bubblesFXSpawnRate = new OptionInterval(modOptions, "bubblesFXSpawnRate", "Rising Bubbles FX Spawn Rate", "Rising bubble spawn rate.", "0.3");
        renderBetterLeaves = new OptionOffOn(modOptions, "renderBetterLeaves", "Better Leaves", "Render Better Leaves?", "On");
        currentLeavesRenderer = new OptionChoice(modOptions, "currentLeavesRenderer", "Leaves Renderer", "Which leaves renderer should be used?", "Standard", new String[]{"Standard", "Advanced", "Experimental"});
        renderSnowedLeaves = new OptionOffOn(modOptions, "renderSnowedLeaves", "Snowed Leaves", "Render Better Leaves Snowed?", "On");
        renderLeavesFX = new OptionOffFastFancy(modOptions, "renderLeavesFX", "Falling Leaves FX", "Render falling leaves effect?", "Fast");
        leavesFXSpawnRate = new OptionInterval(modOptions, "leavesFXSpawnRate", "Falling Leaves FX Spawn Rate", "Falling Leaves spawn rate multiplier.", "0.5");
        useRoundedVanillaLeaves = new OptionOffOn(modOptions, "useRoundedVanillaLeaves", "Rounded Vanilla Leaves", "Use rounded versions of the vanilla leaf textures?", "false");
        renderOnlyOuterLeaves = new OptionOffOn(modOptions, "renderOnlyOuterLeaves", "Render Only Outer Leaves", "Render only the outer leaf blocks (On = better performance)?", "On");
        betterLeavesBrightness = new OptionInterval(modOptions, "betterLeavesBrightness", "Better Leaves Brightness", "Brightness multiplier of Better Leaves.", "1.0");
        renderFootprintsFX = new OptionOffFastFancy(modOptions, "renderFootprintsFX", "Footprints FX", "Render footprints effect?", "Fancy");
        soulsFXSpawnRate = new OptionInterval(modOptions, "soulsFXSpawnRate", "Rising Souls FX Spawn Rate", "Rising Souls spawn rate.", "0.2");
        renderBetterLilyPads = new OptionOffOn(modOptions, "renderBetterLilyPads", "Better Lily Pads", "Render Better Lily Pads?", "On");
        lilyPadFlowerPopulation = new OptionInterval(modOptions, "lilyPadFlowerPopulation", "Lily Pad Flower Population", "Spawn frenquency multiplier for Better Lily Pads.", "0.2");
        betterLilyPadsBrightness = new OptionInterval(modOptions, "betterLilyPadsBrightness", "Better Lily Pads Brightness", "Brightness multiplier of Lily Pads.", "1.0");
        renderBetterNetherrack = new OptionOffOn(modOptions, "renderBetterNetherrack", "Better Netherrack", "Render Better Netherrack?", "On");
        betterNetherrackBrightness = new OptionInterval(modOptions, "betterNetherrackBrightness", "Better Netherrack Brightness", "Brightness multiplier of Better Netherrack.", "1.0");
        renderBetterLadders = new OptionOffOn(modOptions, "renderBetterLadders", "Better Ladders", "Render Better Ladders?", "Off");
        waterSuspendedFX = new OptionOffFastFancy(modOptions, "waterSuspendedFX", "Water Suspended FX", "Render Water Suspended FX (Fast = Minecraft's default effect)?", "Fancy");
        bloodFX = new OptionOffOn(modOptions, "bloodFX", "Blood FX", "Render Blood Effect?", "On");
        useRegisterIconsHook = new OptionOffOn(modOptions, "useRegisterIconsHook", "Use Register Icons Hook", "Use Forge based register icons hook (won't work with MCPatcher)?", "Off");
        textureSource = new OptionChoice(modOptions, "textureSource", "Texture Source", "Define the mod's texture sources. Starting with the left source, it will fallback in case textures are missing (Pack = current Resourcepack, AutoGen = auto generator, Mod = the mod itself).", "Pack > AutoGen > Mod", new String[]{"Pack", "Pack > AutoGen", "Pack > AutoGen > Mod", "Pack > Mod", "Mod"});
        blackList = new OptionStringList(modOptions, "blackList", "Blacklist", "The listed block IDs or block classes won't be altered by the mod. (e.g. blackList=1, net.minecraft.block.BlockGrass, 3)", "");
        addBloodTo = new OptionStringList(modOptions, "addBloodTo", "Add Blood To", "Add the given blood color to the specified entity. (e.g. addBloodTo=Blaze:ff910f, Skeleton:-1)", "Blaze:ff910f, CaveSpider:2362f1, Creeper:4fc82a, EnderDragon:9f00b7, Enderman:9f00b7, Ghast:-1, LavaSlime:450100, PigZombie:711300, Skeleton:-1, Slime:4fc82a, SnowMan:-1, Spider:2362f1, Squid:09153d, VillagerGolem:-1, WitherBoss:282828, Zombie:711300");
        addRendererTo = new OptionStringList(modOptions, "addRendererTo", "Add Renderer To", "Add the given Better Renderer to the specified block IDs. (e.g. addRendererTo=better-grass:1;net.minecraft.BlockGrass;2, better-leaves:net.minecraft.BlockLeaves)", "better-grass:2, better-mycelium:110, better-leaves:18, better-cacti:81, better-seaweed:3, better-corals:1;12, better-soulsand:88, better-footprints:12;13;78;88, better-lily-pad:111, better-netherrack:87, better-water:9, better-ladder:65");
        whiteList = new OptionStringList(modOptions, "whiteList", "Whitelist", "The listed texture names will be linked to an auto generated Better Leaves icon, which will then be used as texture fallback. (e.g. whiteList=leaves_oak, leaves_spruce, leaves_birch)", "");
        debugMode = new OptionOffOn(modOptions, "debugMode", "Debug Mode", "Prints debug information to Minecraft's console? (search for the [BGAL-Debug-Info] to find it)", "Off");
        modIngameOptions = new Option[]{renderBetterGrass, currentGrassRenderer, renderGrassSides, renderSnowedGrass, renderGrassFX, averageGrassHeight, betterGrassBrightness, null, renderBetterLeaves, currentLeavesRenderer, useRoundedVanillaLeaves, renderSnowedLeaves, renderLeavesFX, leavesFXSpawnRate, renderOnlyOuterLeaves, betterLeavesBrightness, null, renderBetterSeaweed, reedPopulation, algaePopulation, reedOffshorePopulation, betterAlgaeBrightness, betterReedBrightness, null, renderBetterCorals, coralPopulation, maximumCoralDepth, minimumCoralDepth, betterCoralsBrightness, bubblesFXSpawnRate, null, renderBetterLilyPads, lilyPadFlowerPopulation, betterLilyPadsBrightness, null, renderBetterCacti, betterCactiBrightness, null, renderBetterNetherrack, betterNetherrackBrightness, null, renderBetterLadders, null, renderFootprintsFX, null, soulsFXSpawnRate, null, waterSuspendedFX, null, bloodFX, null, textureSource};
    }
}

