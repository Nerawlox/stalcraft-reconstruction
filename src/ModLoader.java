/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  BaseMod
 *  TradeEntry
 *  ab
 *  acf
 *  acg
 *  ado
 *  any
 *  ats
 *  bj
 *  bje
 *  cpw.mods.fml.client.FMLClientHandler
 *  cpw.mods.fml.client.modloader.ModLoaderClientHelper
 *  cpw.mods.fml.client.registry.ClientRegistry
 *  cpw.mods.fml.client.registry.RenderingRegistry
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.FMLLog
 *  cpw.mods.fml.common.Loader
 *  cpw.mods.fml.common.ObfuscationReflectionHelper
 *  cpw.mods.fml.common.modloader.BaseModProxy
 *  cpw.mods.fml.common.modloader.ModLoaderHelper
 *  cpw.mods.fml.common.modloader.ModLoaderModContainer
 *  cpw.mods.fml.common.network.NetworkRegistry
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.network.Player
 *  cpw.mods.fml.common.registry.EntityRegistry
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ea
 *  ep
 *  ko
 *  mo
 *  net.minecraft.server.MinecraftServer
 */
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.modloader.ModLoaderClientHelper;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.ModLoaderHelper;
import cpw.mods.fml.common.modloader.ModLoaderModContainer;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

@Deprecated
public class ModLoader {
    public static final String fmlMarker = "This is an FML marker";
    @Deprecated
    public static final Map<String, Map<String, String>> localizedStrings = Collections.emptyMap();

    @Deprecated
    public static void addAchievementDesc(ko achievement, String name, String description) {
        String achName = achievement.i();
        ModLoader.addLocalization(achName, name);
        ModLoader.addLocalization(achName + ".desc", description);
    }

    @Deprecated
    public static int addAllFuel(int id, int metadata) {
        return 0;
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void addAllRenderers(Map<Class<? extends nn>, bgm> renderers) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static int addArmor(String armor) {
        return RenderingRegistry.addNewArmourRendererPrefix((String)armor);
    }

    @Deprecated
    public static void addBiome(acq biome) {
        GameRegistry.addBiome((acq)biome);
    }

    @Deprecated
    public static void addEntityTracker(BaseMod mod, Class<? extends nn> entityClass, int entityTypeId, int updateRange, int updateInterval, boolean sendVelocityInfo) {
        ModLoaderHelper.buildEntityTracker((BaseModProxy)mod, entityClass, (int)entityTypeId, (int)updateRange, (int)updateInterval, (boolean)sendVelocityInfo);
    }

    @Deprecated
    public static void addCommand(ab command) {
        ModLoaderHelper.addCommand((ab)command);
    }

    @Deprecated
    public static void addDispenserBehavior(yc item, bj behavior) {
        any.a.a((Object)item, (Object)behavior);
    }

    @Deprecated
    public static void addLocalization(String key, String value) {
        ModLoader.addLocalization(key, "en_US", value);
    }

    @Deprecated
    public static void addLocalization(String key, String lang, String value) {
        LanguageRegistry.instance().addStringLocalization(key, lang, value);
    }

    @Deprecated
    public static void addName(Object instance, String name) {
        ModLoader.addName(instance, "en_US", name);
    }

    @Deprecated
    public static void addName(Object instance, String lang, String name) {
        LanguageRegistry.instance().addNameForObject(instance, lang, name);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static int addOverride(String fileToOverride, String fileToAdd) {
        return RenderingRegistry.addTextureOverride((String)fileToOverride, (String)fileToAdd);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void addOverride(String path, String overlayPath, int index) {
        RenderingRegistry.addTextureOverride((String)path, (String)overlayPath, (int)index);
    }

    @Deprecated
    public static void addRecipe(ye output, Object ... params) {
        GameRegistry.addRecipe((ye)output, (Object[])params);
    }

    @Deprecated
    public static void addShapelessRecipe(ye output, Object ... params) {
        GameRegistry.addShapelessRecipe((ye)output, (Object[])params);
    }

    @Deprecated
    public static void addSmelting(int input, ye output) {
        GameRegistry.addSmelting((int)input, (ye)output, (float)1.0f);
    }

    @Deprecated
    public static void addSmelting(int input, ye output, float experience) {
        GameRegistry.addSmelting((int)input, (ye)output, (float)experience);
    }

    @Deprecated
    public static void addSpawn(Class<? extends og> entityClass, int weightedProb, int min, int max, oh spawnList) {
        EntityRegistry.addSpawn(entityClass, (int)weightedProb, (int)min, (int)max, (oh)spawnList, (acq[])acg.base12Biomes);
    }

    @Deprecated
    public static void addSpawn(Class<? extends og> entityClass, int weightedProb, int min, int max, oh spawnList, acq ... biomes) {
        EntityRegistry.addSpawn(entityClass, (int)weightedProb, (int)min, (int)max, (oh)spawnList, (acq[])biomes);
    }

    @Deprecated
    public static void addSpawn(String entityName, int weightedProb, int min, int max, oh spawnList) {
        EntityRegistry.addSpawn((String)entityName, (int)weightedProb, (int)min, (int)max, (oh)spawnList, (acq[])acg.base12Biomes);
    }

    @Deprecated
    public static void addSpawn(String entityName, int weightedProb, int min, int max, oh spawnList, acq ... biomes) {
        EntityRegistry.addSpawn((String)entityName, (int)weightedProb, (int)min, (int)max, (oh)spawnList, (acq[])biomes);
    }

    @Deprecated
    public static void addTrade(int profession, TradeEntry entry) {
        ModLoaderHelper.registerTrade((int)profession, (TradeEntry)entry);
    }

    @Deprecated
    public static void clientSendPacket(ey packet) {
        PacketDispatcher.sendPacketToServer((ey)packet);
    }

    @Deprecated
    public static boolean dispenseEntity(abw world, double x2, double y2, double z2, int xVel, int zVel, ye item) {
        return false;
    }

    @Deprecated
    public static void genericContainerRemoval(abw world, int x2, int y2, int z2) {
    }

    @Deprecated
    public static List<BaseMod> getLoadedMods() {
        return ModLoaderModContainer.findAll(BaseMod.class);
    }

    @Deprecated
    public static Logger getLogger() {
        return FMLLog.getLogger();
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public static atv getMinecraftInstance() {
        return FMLClientHandler.instance().getClient();
    }

    @Deprecated
    public static MinecraftServer getMinecraftServerInstance() {
        return FMLCommonHandler.instance().getMinecraftServerInstance();
    }

    @Deprecated
    public static <T, E> T getPrivateValue(Class<? super E> instanceclass, E instance, int fieldindex) {
        return (T)ObfuscationReflectionHelper.getPrivateValue(instanceclass, instance, (int)fieldindex);
    }

    @Deprecated
    public static <T, E> T getPrivateValue(Class<? super E> instanceclass, E instance, String field) {
        return (T)ObfuscationReflectionHelper.getPrivateValue(instanceclass, instance, (String[])new String[]{field});
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public static int getUniqueBlockModelID(BaseMod mod, boolean inventoryRenderer) {
        return ModLoaderClientHelper.obtainBlockModelIdFor((BaseMod)mod, (boolean)inventoryRenderer);
    }

    @Deprecated
    public static int getUniqueEntityId() {
        return EntityRegistry.findGlobalUniqueEntityId();
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static int getUniqueSpriteIndex(String path) {
        return -1;
    }

    @Deprecated
    public static boolean isChannelActive(uf player, String channel) {
        return NetworkRegistry.instance().isChannelActive(channel, (Player)player);
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public static boolean isGUIOpen(Class<? extends awe> gui) {
        return FMLClientHandler.instance().isGUIOpen(gui);
    }

    @Deprecated
    public static boolean isModLoaded(String modname) {
        return Loader.isModLoaded((String)modname);
    }

    @Deprecated
    public static void loadConfig() {
    }

    @Deprecated
    public static void onItemPickup(uf player, ye item) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void onTick(float tick, atv game) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void openGUI(uf player, awe gui) {
        FMLClientHandler.instance().displayGuiScreen(player, gui);
    }

    @Deprecated
    public static void populateChunk(ado generator, int chunkX, int chunkZ, abw world) {
    }

    @Deprecated
    public static void receivePacket(ea packet) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static ats[] registerAllKeys(ats[] keys) {
        return keys;
    }

    @Deprecated
    public static void registerBlock(aqz block) {
        GameRegistry.registerBlock((aqz)block);
    }

    @Deprecated
    public static void registerBlock(aqz block, Class<? extends zh> itemclass) {
        GameRegistry.registerBlock((aqz)block, itemclass);
    }

    @Deprecated
    public static void registerContainerID(BaseMod mod, int id) {
        ModLoaderHelper.buildGuiHelper((BaseModProxy)mod, (int)id);
    }

    @Deprecated
    public static void registerEntityID(Class<? extends nn> entityClass, String entityName, int id) {
        EntityRegistry.registerGlobalEntityID(entityClass, (String)entityName, (int)id);
    }

    @Deprecated
    public static void registerEntityID(Class<? extends nn> entityClass, String entityName, int id, int background, int foreground) {
        EntityRegistry.registerGlobalEntityID(entityClass, (String)entityName, (int)id, (int)background, (int)foreground);
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public static void registerKey(BaseMod mod, ats keyHandler, boolean allowRepeat) {
        ModLoaderClientHelper.registerKeyBinding((BaseModProxy)mod, (ats)keyHandler, (boolean)allowRepeat);
    }

    @Deprecated
    public static void registerPacketChannel(BaseMod mod, String channel) {
        NetworkRegistry.instance().registerChannel(ModLoaderHelper.buildPacketHandlerFor((BaseModProxy)mod), channel);
    }

    @Deprecated
    public static void registerTileEntity(Class<? extends asp> tileEntityClass, String id) {
        GameRegistry.registerTileEntity(tileEntityClass, (String)id);
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public static void registerTileEntity(Class<? extends asp> tileEntityClass, String id, bje renderer) {
        ClientRegistry.registerTileEntity(tileEntityClass, (String)id, (bje)renderer);
    }

    @Deprecated
    public static void removeBiome(acq biome) {
        GameRegistry.removeBiome((acq)biome);
    }

    @Deprecated
    public static void removeSpawn(Class<? extends og> entityClass, oh spawnList) {
        EntityRegistry.removeSpawn(entityClass, (oh)spawnList, (acq[])acg.base12Biomes);
    }

    @Deprecated
    public static void removeSpawn(Class<? extends og> entityClass, oh spawnList, acq ... biomes) {
        EntityRegistry.removeSpawn(entityClass, (oh)spawnList, (acq[])biomes);
    }

    @Deprecated
    public static void removeSpawn(String entityName, oh spawnList) {
        EntityRegistry.removeSpawn((String)entityName, (oh)spawnList, (acq[])acg.base12Biomes);
    }

    @Deprecated
    public static void removeSpawn(String entityName, oh spawnList, acq ... biomes) {
        EntityRegistry.removeSpawn((String)entityName, (oh)spawnList, (acq[])biomes);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static boolean renderBlockIsItemFull3D(int modelID) {
        return RenderingRegistry.instance().renderItemAsFull3DBlock(modelID);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void renderInvBlock(bfr renderer, aqz block, int metadata, int modelID) {
        RenderingRegistry.instance().renderInventoryBlock(renderer, block, metadata, modelID);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static boolean renderWorldBlock(bfr renderer, acf world, int x2, int y2, int z2, aqz block, int modelID) {
        return RenderingRegistry.instance().renderWorldBlock(renderer, world, x2, y2, z2, block, modelID);
    }

    @Deprecated
    public static void saveConfig() {
    }

    @Deprecated
    public static void sendPacket(ey packet) {
        PacketDispatcher.sendPacketToServer((ey)packet);
    }

    @Deprecated
    public static void serverChat(String text) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void serverLogin(bcw handler, ep loginPacket) {
    }

    @Deprecated
    public static void serverSendPacket(ka handler, ey packet) {
        if (handler != null) {
            PacketDispatcher.sendPacketToPlayer((ey)packet, (Player)((Player)handler.getPlayer()));
        }
    }

    @Deprecated
    public static void serverOpenWindow(jv player, uy container, int ID, int x2, int y2, int z2) {
        ModLoaderHelper.openGui((int)ID, (uf)player, (uy)container, (int)x2, (int)y2, (int)z2);
    }

    @Deprecated
    public static void setInGameHook(BaseMod mod, boolean enable, boolean useClock) {
        ModLoaderHelper.updateStandardTicks((BaseModProxy)mod, (boolean)enable, (boolean)useClock);
    }

    @Deprecated
    public static void setInGUIHook(BaseMod mod, boolean enable, boolean useClock) {
        ModLoaderHelper.updateGUITicks((BaseModProxy)mod, (boolean)enable, (boolean)useClock);
    }

    @Deprecated
    public static <T, E> void setPrivateValue(Class<? super T> instanceclass, T instance, int fieldindex, E value) {
        ObfuscationReflectionHelper.setPrivateValue(instanceclass, instance, value, (int)fieldindex);
    }

    @Deprecated
    public static <T, E> void setPrivateValue(Class<? super T> instanceclass, T instance, String field, E value) {
        ObfuscationReflectionHelper.setPrivateValue(instanceclass, instance, value, (String[])new String[]{field});
    }

    @Deprecated
    public static void takenFromCrafting(uf player, ye item, mo matrix) {
    }

    @Deprecated
    public static void takenFromFurnace(uf player, ye item) {
    }

    @Deprecated
    public static void throwException(String message, Throwable e2) {
        FMLCommonHandler.instance().raiseException(e2, message, true);
    }

    @Deprecated
    public static void throwException(Throwable e2) {
        ModLoader.throwException("Exception in ModLoader", e2);
    }
}

