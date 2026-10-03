/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.src;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.modloader.ModLoaderClientHelper;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.modloader.ModLoaderHelper;
import cpw.mods.fml.common.modloader.ModLoaderModContainer;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.command.ICommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.BaseMod;
import net.minecraft.src.TradeEntry;
import net.minecraft.stats.Achievement;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

@Deprecated
public class ModLoader {
    public static final String fmlMarker = "This is an FML marker";
    @Deprecated
    public static final Map<String, Map<String, String>> localizedStrings = Collections.emptyMap();

    @Deprecated
    public static void addAchievementDesc(Achievement achievement, String string, String string2) {
        String string3 = achievement.getName();
        ModLoader.addLocalization(string3, string);
        ModLoader.addLocalization(string3 + ".desc", string2);
    }

    @Deprecated
    public static int addAllFuel(int n, int n2) {
        return 0;
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void addAllRenderers(Map<Class<? extends Entity>, Render> map) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static int addArmor(String string) {
        return RenderingRegistry.addNewArmourRendererPrefix(string);
    }

    @Deprecated
    public static void addBiome(BiomeGenBase biomeGenBase) {
        GameRegistry.addBiome(biomeGenBase);
    }

    @Deprecated
    public static void addEntityTracker(BaseMod baseMod, Class<? extends Entity> clazz, int n, int n2, int n3, boolean bl) {
        ModLoaderHelper.buildEntityTracker(baseMod, clazz, n, n2, n3, bl);
    }

    @Deprecated
    public static void addCommand(ICommand iCommand) {
        ModLoaderHelper.addCommand(iCommand);
    }

    @Deprecated
    public static void addDispenserBehavior(Item item, vmgb vmgb2) {
        BlockDispenser._a._a(item, vmgb2);
    }

    @Deprecated
    public static void addLocalization(String string, String string2) {
        ModLoader.addLocalization(string, "en_US", string2);
    }

    @Deprecated
    public static void addLocalization(String string, String string2, String string3) {
        LanguageRegistry.instance().addStringLocalization(string, string2, string3);
    }

    @Deprecated
    public static void addName(Object object, String string) {
        ModLoader.addName(object, "en_US", string);
    }

    @Deprecated
    public static void addName(Object object, String string, String string2) {
        LanguageRegistry.instance().addNameForObject(object, string, string2);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static int addOverride(String string, String string2) {
        return RenderingRegistry.addTextureOverride(string, string2);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void addOverride(String string, String string2, int n) {
        RenderingRegistry.addTextureOverride(string, string2, n);
    }

    @Deprecated
    public static void addRecipe(ItemStack itemStack, Object ... objectArray) {
        GameRegistry.addRecipe(itemStack, objectArray);
    }

    @Deprecated
    public static void addShapelessRecipe(ItemStack itemStack, Object ... objectArray) {
        GameRegistry.addShapelessRecipe(itemStack, objectArray);
    }

    @Deprecated
    public static void addSmelting(int n, ItemStack itemStack) {
        GameRegistry.addSmelting(n, itemStack, 1.0f);
    }

    @Deprecated
    public static void addSmelting(int n, ItemStack itemStack, float f) {
        GameRegistry.addSmelting(n, itemStack, f);
    }

    @Deprecated
    public static void addSpawn(Class<? extends EntityLiving> clazz, int n, int n2, int n3, EnumCreatureType enumCreatureType) {
        EntityRegistry.addSpawn(clazz, n, n2, n3, enumCreatureType, nwix._b);
    }

    @Deprecated
    public static void addSpawn(Class<? extends EntityLiving> clazz, int n, int n2, int n3, EnumCreatureType enumCreatureType, BiomeGenBase ... biomeGenBaseArray) {
        EntityRegistry.addSpawn(clazz, n, n2, n3, enumCreatureType, biomeGenBaseArray);
    }

    @Deprecated
    public static void addSpawn(String string, int n, int n2, int n3, EnumCreatureType enumCreatureType) {
        EntityRegistry.addSpawn(string, n, n2, n3, enumCreatureType, nwix._b);
    }

    @Deprecated
    public static void addSpawn(String string, int n, int n2, int n3, EnumCreatureType enumCreatureType, BiomeGenBase ... biomeGenBaseArray) {
        EntityRegistry.addSpawn(string, n, n2, n3, enumCreatureType, biomeGenBaseArray);
    }

    @Deprecated
    public static void addTrade(int n, TradeEntry tradeEntry) {
        ModLoaderHelper.registerTrade(n, tradeEntry);
    }

    @Deprecated
    public static void clientSendPacket(Packet packet) {
        PacketDispatcher.sendPacketToServer(packet);
    }

    @Deprecated
    public static boolean dispenseEntity(World world, double d, double d2, double d3, int n, int n2, ItemStack itemStack) {
        return false;
    }

    @Deprecated
    public static void genericContainerRemoval(World world, int n, int n2, int n3) {
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
    public static Minecraft getMinecraftInstance() {
        return FMLClientHandler.instance().getClient();
    }

    @Deprecated
    public static MinecraftServer getMinecraftServerInstance() {
        return FMLCommonHandler.instance().getMinecraftServerInstance();
    }

    @Deprecated
    public static <T, E> T getPrivateValue(Class<? super E> clazz, E e, int n) {
        return ObfuscationReflectionHelper.getPrivateValue(clazz, e, n);
    }

    @Deprecated
    public static <T, E> T getPrivateValue(Class<? super E> clazz, E e, String string) {
        return ObfuscationReflectionHelper.getPrivateValue(clazz, e, string);
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public static int getUniqueBlockModelID(BaseMod baseMod, boolean bl) {
        return ModLoaderClientHelper.obtainBlockModelIdFor(baseMod, bl);
    }

    @Deprecated
    public static int getUniqueEntityId() {
        return EntityRegistry.findGlobalUniqueEntityId();
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static int getUniqueSpriteIndex(String string) {
        return -1;
    }

    @Deprecated
    public static boolean isChannelActive(EntityPlayer entityPlayer, String string) {
        return NetworkRegistry.instance().isChannelActive(string, entityPlayer);
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public static boolean isGUIOpen(Class<? extends GuiScreen> clazz) {
        return FMLClientHandler.instance().isGUIOpen(clazz);
    }

    @Deprecated
    public static boolean isModLoaded(String string) {
        return Loader.isModLoaded(string);
    }

    @Deprecated
    public static void loadConfig() {
    }

    @Deprecated
    public static void onItemPickup(EntityPlayer entityPlayer, ItemStack itemStack) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void onTick(float f, Minecraft minecraft) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void openGUI(EntityPlayer entityPlayer, GuiScreen guiScreen) {
        FMLClientHandler.instance().displayGuiScreen(entityPlayer, guiScreen);
    }

    @Deprecated
    public static void populateChunk(IChunkProvider iChunkProvider, int n, int n2, World world) {
    }

    @Deprecated
    public static void receivePacket(Packet250CustomPayload packet250CustomPayload) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static KeyBinding[] registerAllKeys(KeyBinding[] keyBindingArray) {
        return keyBindingArray;
    }

    @Deprecated
    public static void registerBlock(Block block) {
        GameRegistry.registerBlock(block);
    }

    @Deprecated
    public static void registerBlock(Block block, Class<? extends ItemBlock> clazz) {
        GameRegistry.registerBlock(block, clazz);
    }

    @Deprecated
    public static void registerContainerID(BaseMod baseMod, int n) {
        ModLoaderHelper.buildGuiHelper(baseMod, n);
    }

    @Deprecated
    public static void registerEntityID(Class<? extends Entity> clazz, String string, int n) {
        EntityRegistry.registerGlobalEntityID(clazz, string, n);
    }

    @Deprecated
    public static void registerEntityID(Class<? extends Entity> clazz, String string, int n, int n2, int n3) {
        EntityRegistry.registerGlobalEntityID(clazz, string, n, n2, n3);
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public static void registerKey(BaseMod baseMod, KeyBinding keyBinding, boolean bl) {
        ModLoaderClientHelper.registerKeyBinding(baseMod, keyBinding, bl);
    }

    @Deprecated
    public static void registerPacketChannel(BaseMod baseMod, String string) {
        NetworkRegistry.instance().registerChannel(ModLoaderHelper.buildPacketHandlerFor(baseMod), string);
    }

    @Deprecated
    public static void registerTileEntity(Class<? extends TileEntity> clazz, String string) {
        GameRegistry.registerTileEntity(clazz, string);
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public static void registerTileEntity(Class<? extends TileEntity> clazz, String string, TileEntitySpecialRenderer tileEntitySpecialRenderer) {
        ClientRegistry.registerTileEntity(clazz, string, tileEntitySpecialRenderer);
    }

    @Deprecated
    public static void removeBiome(BiomeGenBase biomeGenBase) {
        GameRegistry.removeBiome(biomeGenBase);
    }

    @Deprecated
    public static void removeSpawn(Class<? extends EntityLiving> clazz, EnumCreatureType enumCreatureType) {
        EntityRegistry.removeSpawn(clazz, enumCreatureType, nwix._b);
    }

    @Deprecated
    public static void removeSpawn(Class<? extends EntityLiving> clazz, EnumCreatureType enumCreatureType, BiomeGenBase ... biomeGenBaseArray) {
        EntityRegistry.removeSpawn(clazz, enumCreatureType, biomeGenBaseArray);
    }

    @Deprecated
    public static void removeSpawn(String string, EnumCreatureType enumCreatureType) {
        EntityRegistry.removeSpawn(string, enumCreatureType, nwix._b);
    }

    @Deprecated
    public static void removeSpawn(String string, EnumCreatureType enumCreatureType, BiomeGenBase ... biomeGenBaseArray) {
        EntityRegistry.removeSpawn(string, enumCreatureType, biomeGenBaseArray);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static boolean renderBlockIsItemFull3D(int n) {
        return RenderingRegistry.instance().renderItemAsFull3DBlock(n);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void renderInvBlock(RenderBlocks renderBlocks, Block block, int n, int n2) {
        RenderingRegistry.instance().renderInventoryBlock(renderBlocks, block, n, n2);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static boolean renderWorldBlock(RenderBlocks renderBlocks, IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4) {
        return RenderingRegistry.instance().renderWorldBlock(renderBlocks, iBlockAccess, n, n2, n3, block, n4);
    }

    @Deprecated
    public static void saveConfig() {
    }

    @Deprecated
    public static void sendPacket(Packet packet) {
        PacketDispatcher.sendPacketToServer(packet);
    }

    @Deprecated
    public static void serverChat(String string) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void serverLogin(bscn bscn2, txpf txpf2) {
    }

    @Deprecated
    public static void serverSendPacket(NetServerHandler netServerHandler, Packet packet) {
        if (netServerHandler != null) {
            PacketDispatcher.sendPacketToPlayer(packet, netServerHandler.getPlayer());
        }
    }

    @Deprecated
    public static void serverOpenWindow(EntityPlayerMP entityPlayerMP, Container container, int n, int n2, int n3, int n4) {
        ModLoaderHelper.openGui(n, entityPlayerMP, container, n2, n3, n4);
    }

    @Deprecated
    public static void setInGameHook(BaseMod baseMod, boolean bl, boolean bl2) {
        ModLoaderHelper.updateStandardTicks(baseMod, bl, bl2);
    }

    @Deprecated
    public static void setInGUIHook(BaseMod baseMod, boolean bl, boolean bl2) {
        ModLoaderHelper.updateGUITicks(baseMod, bl, bl2);
    }

    @Deprecated
    public static <T, E> void setPrivateValue(Class<? super T> clazz, T t, int n, E e) {
        ObfuscationReflectionHelper.setPrivateValue(clazz, t, e, n);
    }

    @Deprecated
    public static <T, E> void setPrivateValue(Class<? super T> clazz, T t, String string, E e) {
        ObfuscationReflectionHelper.setPrivateValue(clazz, t, e, string);
    }

    @Deprecated
    public static void takenFromCrafting(EntityPlayer entityPlayer, ItemStack itemStack, IInventory iInventory) {
    }

    @Deprecated
    public static void takenFromFurnace(EntityPlayer entityPlayer, ItemStack itemStack) {
    }

    @Deprecated
    public static void throwException(String string, Throwable throwable) {
        FMLCommonHandler.instance().raiseException(throwable, string, true);
    }

    @Deprecated
    public static void throwException(Throwable throwable) {
        ModLoader.throwException("Exception in ModLoader", throwable);
    }
}

