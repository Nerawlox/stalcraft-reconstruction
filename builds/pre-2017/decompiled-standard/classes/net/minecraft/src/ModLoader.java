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
import net.minecraft.client.settings.eidj;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.jxsn;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.src.BaseMod;
import net.minecraft.src.TradeEntry;

@Deprecated
public class ModLoader {
    public static final String fmlMarker = "This is an FML marker";
    @Deprecated
    public static final Map<String, Map<String, String>> localizedStrings = Collections.emptyMap();

    @Deprecated
    public static void addAchievementDesc(nfcl nfcl2, String string, String string2) {
        String string3 = nfcl2.func_75970_i();
        ModLoader.addLocalization(string3, string);
        ModLoader.addLocalization(string3 + ".desc", string2);
    }

    @Deprecated
    public static int addAllFuel(int n, int n2) {
        return 0;
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void addAllRenderers(Map<Class<? extends Entity>, tfvm> map) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static int addArmor(String string) {
        return RenderingRegistry.addNewArmourRendererPrefix(string);
    }

    @Deprecated
    public static void addBiome(foqh foqh2) {
        GameRegistry.addBiome(foqh2);
    }

    @Deprecated
    public static void addEntityTracker(BaseMod baseMod, Class<? extends Entity> clazz, int n, int n2, int n3, boolean bl) {
        ModLoaderHelper.buildEntityTracker(baseMod, clazz, n, n2, n3, bl);
    }

    @Deprecated
    public static void addCommand(kmew kmew2) {
        ModLoaderHelper.addCommand(kmew2);
    }

    @Deprecated
    public static void addDispenserBehavior(tgdv tgdv2, vmgb vmgb2) {
        ejzs._a._a(tgdv2, vmgb2);
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
    public static void addRecipe(cvzo cvzo2, Object ... objectArray) {
        GameRegistry.addRecipe(cvzo2, objectArray);
    }

    @Deprecated
    public static void addShapelessRecipe(cvzo cvzo2, Object ... objectArray) {
        GameRegistry.addShapelessRecipe(cvzo2, objectArray);
    }

    @Deprecated
    public static void addSmelting(int n, cvzo cvzo2) {
        GameRegistry.addSmelting(n, cvzo2, 1.0f);
    }

    @Deprecated
    public static void addSmelting(int n, cvzo cvzo2, float f) {
        GameRegistry.addSmelting(n, cvzo2, f);
    }

    @Deprecated
    public static void addSpawn(Class<? extends EntityLiving> clazz, int n, int n2, int n3, jxsn jxsn2) {
        EntityRegistry.addSpawn(clazz, n, n2, n3, jxsn2, nwix._b);
    }

    @Deprecated
    public static void addSpawn(Class<? extends EntityLiving> clazz, int n, int n2, int n3, jxsn jxsn2, foqh ... foqhArray) {
        EntityRegistry.addSpawn(clazz, n, n2, n3, jxsn2, foqhArray);
    }

    @Deprecated
    public static void addSpawn(String string, int n, int n2, int n3, jxsn jxsn2) {
        EntityRegistry.addSpawn(string, n, n2, n3, jxsn2, nwix._b);
    }

    @Deprecated
    public static void addSpawn(String string, int n, int n2, int n3, jxsn jxsn2, foqh ... foqhArray) {
        EntityRegistry.addSpawn(string, n, n2, n3, jxsn2, foqhArray);
    }

    @Deprecated
    public static void addTrade(int n, TradeEntry tradeEntry) {
        ModLoaderHelper.registerTrade(n, tradeEntry);
    }

    @Deprecated
    public static void clientSendPacket(cezg cezg2) {
        PacketDispatcher.sendPacketToServer(cezg2);
    }

    @Deprecated
    public static boolean dispenseEntity(ozlu ozlu2, double d, double d2, double d3, int n, int n2, cvzo cvzo2) {
        return false;
    }

    @Deprecated
    public static void genericContainerRemoval(ozlu ozlu2, int n, int n2, int n3) {
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
    public static xpzm getMinecraftInstance() {
        return FMLClientHandler.instance().getClient();
    }

    @Deprecated
    public static dzfd getMinecraftServerInstance() {
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
    public static boolean isGUIOpen(Class<? extends gqjz> clazz) {
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
    public static void onItemPickup(EntityPlayer entityPlayer, cvzo cvzo2) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void onTick(float f, xpzm xpzm2) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void openGUI(EntityPlayer entityPlayer, gqjz gqjz2) {
        FMLClientHandler.instance().displayGuiScreen(entityPlayer, gqjz2);
    }

    @Deprecated
    public static void populateChunk(mccn mccn2, int n, int n2, ozlu ozlu2) {
    }

    @Deprecated
    public static void receivePacket(jjqf jjqf2) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static eidj[] registerAllKeys(eidj[] eidjArray) {
        return eidjArray;
    }

    @Deprecated
    public static void registerBlock(twgu twgu2) {
        GameRegistry.registerBlock(twgu2);
    }

    @Deprecated
    public static void registerBlock(twgu twgu2, Class<? extends mbpd> clazz) {
        GameRegistry.registerBlock(twgu2, clazz);
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
    public static void registerKey(BaseMod baseMod, eidj eidj2, boolean bl) {
        ModLoaderClientHelper.registerKeyBinding(baseMod, eidj2, bl);
    }

    @Deprecated
    public static void registerPacketChannel(BaseMod baseMod, String string) {
        NetworkRegistry.instance().registerChannel(ModLoaderHelper.buildPacketHandlerFor(baseMod), string);
    }

    @Deprecated
    public static void registerTileEntity(Class<? extends hurg> clazz, String string) {
        GameRegistry.registerTileEntity(clazz, string);
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public static void registerTileEntity(Class<? extends hurg> clazz, String string, htys htys2) {
        ClientRegistry.registerTileEntity(clazz, string, htys2);
    }

    @Deprecated
    public static void removeBiome(foqh foqh2) {
        GameRegistry.removeBiome(foqh2);
    }

    @Deprecated
    public static void removeSpawn(Class<? extends EntityLiving> clazz, jxsn jxsn2) {
        EntityRegistry.removeSpawn(clazz, jxsn2, nwix._b);
    }

    @Deprecated
    public static void removeSpawn(Class<? extends EntityLiving> clazz, jxsn jxsn2, foqh ... foqhArray) {
        EntityRegistry.removeSpawn(clazz, jxsn2, foqhArray);
    }

    @Deprecated
    public static void removeSpawn(String string, jxsn jxsn2) {
        EntityRegistry.removeSpawn(string, jxsn2, nwix._b);
    }

    @Deprecated
    public static void removeSpawn(String string, jxsn jxsn2, foqh ... foqhArray) {
        EntityRegistry.removeSpawn(string, jxsn2, foqhArray);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static boolean renderBlockIsItemFull3D(int n) {
        return RenderingRegistry.instance().renderItemAsFull3DBlock(n);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void renderInvBlock(htvc htvc2, twgu twgu2, int n, int n2) {
        RenderingRegistry.instance().renderInventoryBlock(htvc2, twgu2, n, n2);
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static boolean renderWorldBlock(htvc htvc2, sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4) {
        return RenderingRegistry.instance().renderWorldBlock(htvc2, sdrg2, n, n2, n3, twgu2, n4);
    }

    @Deprecated
    public static void saveConfig() {
    }

    @Deprecated
    public static void sendPacket(cezg cezg2) {
        PacketDispatcher.sendPacketToServer(cezg2);
    }

    @Deprecated
    public static void serverChat(String string) {
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public static void serverLogin(bscn bscn2, txpf txpf2) {
    }

    @Deprecated
    public static void serverSendPacket(xbvu xbvu2, cezg cezg2) {
        if (xbvu2 != null) {
            PacketDispatcher.sendPacketToPlayer(cezg2, xbvu2.getPlayer());
        }
    }

    @Deprecated
    public static void serverOpenWindow(EntityPlayerMP entityPlayerMP, jjgc jjgc2, int n, int n2, int n3, int n4) {
        ModLoaderHelper.openGui(n, entityPlayerMP, jjgc2, n2, n3, n4);
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
    public static void takenFromCrafting(EntityPlayer entityPlayer, cvzo cvzo2, mssh mssh2) {
    }

    @Deprecated
    public static void takenFromFurnace(EntityPlayer entityPlayer, cvzo cvzo2) {
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

