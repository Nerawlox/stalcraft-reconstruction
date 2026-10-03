/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import carpentersblocks.block.BlockStalkerSlope;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.HookPriority;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.asm.FakeChunkPosition;
import gloomyfolken.mods.asm.GloomyStartHooks;
import gloomyfolken.mods.asm.KeyboardListener;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.client.gui.screens.GuiModGameOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModMainOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModPerformanceOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModSoundOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModVideoOptions;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.hanr;
import gloomyfolken.mods.effects.client.main.pidb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.command.ICommandSender;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.logging.ILogAgent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.TcpConnection;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.Vec3;
import net.minecraft.util.pibn;
import net.minecraft.util.pzde;
import net.minecraft.util.sajh;
import net.minecraft.util.samo;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.Display;

public class GloomyHooks {
    public static final int[] _a = new int[4096];
    private static int _c = -1;
    private static boolean _d = false;
    private static boolean _e;
    public static int _b;
    @ezey(_a={eidj.CLIENT})
    private static fmab _f;
    private static ModelBipedAnglesRotator _g;
    private static boolean _h;

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void handleFlying(bscn bscn2, Packet10Flying packet10Flying) {
        wnja._a(bscn2.getPlayer());
    }

    @Hook(injectOnExit=true, targetMethod="handleFlying")
    @ezey(_a={eidj.CLIENT})
    public static void handleFlyingPost(bscn bscn2, Packet10Flying packet10Flying) {
        wnja._b(bscn2.getPlayer());
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void updateRenderers(cvgz cvgz2, EntityLivingBase entityLivingBase, boolean bl) {
        dwwh._a._b();
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void sortAndRender(cvgz cvgz2, EntityLivingBase entityLivingBase, int n, double d) {
        dwwh._a._b();
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderAllSortedRenderers(cvgz cvgz2, int n, double d) {
        dwwh._a._b();
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public void renderEntities(cvgz cvgz2, Vec3 vec3, lpai lpai2, float f) {
        dwwh._a._b();
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void dispatchRenderLast(ForgeHooksClient forgeHooksClient, cvgz cvgz2, float f) {
        dwwh._a._b();
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void tick(TextureManager textureManager) {
        ClientProxy.ticker._a();
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=true)
    public static void canBlockStay(BlockFlower blockFlower, World world, int n, int n2, int n3) {
    }

    @Hook(injectOnExit=true, priority=HookPriority.LOWEST, targetMethod="onInitializationComplete")
    public static void dumpClasses(FMLClientHandler fMLClientHandler) {
        new xqmv()._a();
    }

    @Hook(injectOnExit=true, targetMethod="<init>")
    public static void onEntityLivingBaseInit(EntityLivingBase entityLivingBase, World world) {
        entityLivingBase.stepHeight = 0.95f;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void updateEntity(TileEntityHopper tileEntityHopper) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void updateHopper(TileEntityHopper tileEntityHopper) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void suckItemsIntoHopper(TileEntityHopper tileEntityHopper, sdpc sdpc2) {
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static int getRenderType(Block block) {
        return _a[block.blockID];
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static int getRenderType(BlockFlower blockFlower) {
        int n = _a[blockFlower.blockID];
        return n == 0 ? 1 : n;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean renderInsideOfBlock(ItemRenderer itemRenderer, float f, Icon icon) {
        return icon == null;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean actionPerformed(htjl htjl2, GuiButton guiButton) {
        if (guiButton.id == 0) {
            Minecraft._E()._a(new GuiModMainOptions(htjl2));
            return true;
        }
        return false;
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void addEntityToWorld(pkix pkix2, int n, Entity entity) {
        entity.entityId = n;
        pkix2.playerEntities.remove(entity);
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void setDimensionAndSpawnPlayer(Minecraft minecraft, int n) {
        if (minecraft._t != null) {
            _c = minecraft._t.entityId;
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void preparePlayerToSpawn(EntityPlayer entityPlayer) {
        if (_c >= 0) {
            entityPlayer.entityId = _c;
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void tickBlocksAndAmbiance(pkix pkix2, int n, Entity entity) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void func_77449_e(StatFileWriter statFileWriter) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void addBaseDataToSnooper(cfbu cfbu2) {
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    @ezey(_a={eidj.CLIENT})
    public static boolean setIngameNotInFocus(Minecraft minecraft) {
        if (minecraft._B instanceof owwh) {
            if (minecraft.__ab) {
                minecraft.__ab = false;
                minecraft._O._b();
            }
            return true;
        }
        return false;
    }

    @Hook(injectOnExit=true)
    @ezey(_a={eidj.CLIENT})
    public static void onInitializationComplete(FMLClientHandler fMLClientHandler) {
        GuiModVideoOptions.options.forEach(anpn::applyLoadedState);
        GuiModSoundOptions.options.forEach(anpn::applyLoadedState);
        GuiModGameOptions.options.forEach(anpn::applyLoadedState);
        GuiModPerformanceOptions.options.forEach(anpn::applyLoadedState);
        uhip._a._f(true);
    }

    @Hook(createMethod=true, returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static boolean shouldRenderInPass(EntityItem entityItem, int n) {
        IItemRenderer iItemRenderer;
        ItemStack itemStack = entityItem.getEntityItem();
        if (itemStack != null && (iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.ENTITY)) instanceof hbcv) {
            return ((hbcv)iItemRenderer)._a(itemStack, n);
        }
        return n == 0;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void doExplosionB(Explosion explosion, boolean bl) {
        explosion._e.playSoundEffect(explosion._f, explosion._g, explosion._h, "random.explode", 4.0f, (1.0f + (explosion._e.rand.nextFloat() - explosion._e.rand.nextFloat()) * 0.2f) * 0.7f);
        InvokeSideOnly.client(explosion._e.isRemote, () -> pidb._a(new ogjo(explosion._e, explosion._e.getWorldVec3Pool()._a(explosion._f, explosion._g + 0.25, explosion._h))));
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public boolean func_85069_a(CrashReportCategory crashReportCategory, StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (crashReportCategory._d.length != 0 && stackTraceElement != null) {
            StackTraceElement stackTraceElement3 = crashReportCategory._d[0];
            if (stackTraceElement3.isNativeMethod() == stackTraceElement.isNativeMethod() && Objects.equals(stackTraceElement3.getClassName(), stackTraceElement.getClassName()) && Objects.equals(stackTraceElement3.getFileName(), stackTraceElement.getFileName()) && Objects.equals(stackTraceElement3.getMethodName(), stackTraceElement.getMethodName())) {
                if (stackTraceElement2 != null != crashReportCategory._d.length > 1) {
                    return false;
                }
                if (stackTraceElement2 != null && !crashReportCategory._d[1].equals(stackTraceElement2)) {
                    return false;
                }
                crashReportCategory._d[0] = stackTraceElement;
                return true;
            }
            return false;
        }
        return false;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    @ezey(_a={eidj.CLIENT})
    public static boolean tryToSetLibraryAndCodecs(jzqf jzqf2) {
        if (_d) {
            return true;
        }
        _d = true;
        return false;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void cleanup(jzqf jzqf2) {
    }

    public static boolean checkNanHealth(EntityLivingBase entityLivingBase) {
        if (Float.isNaN(entityLivingBase.getHealth()) || Float.isNaN(entityLivingBase.getAbsorptionAmount())) {
            entityLivingBase.setAbsorptionAmount(0.0f);
            entityLivingBase.setHealth(0.0f);
            entityLivingBase.onDeath(DamageSource.outOfWorld);
            if (entityLivingBase instanceof EntityPlayerMP) {
                ((EntityPlayerMP)entityLivingBase).sendChatToPlayer(ChatMessageComponent._d("\u0427\u0442\u043e-\u0442\u043e \u043f\u043e\u0448\u043b\u043e \u043e\u0447\u0435\u043d\u044c \u043d\u0435 \u0442\u0430\u043a, \u0438 \u0432\u044b \u0443\u043c\u0435\u0440\u043b\u0438. \u0421\u0440\u043e\u0447\u043d\u043e \u043d\u0430\u043f\u0438\u0448\u0438\u0442\u0435 \u0430\u0434\u043c\u0438\u043d\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u0438."));
            }
            Logger.severe("Entity " + entityLivingBase + " got NaN HP", new Object[0]);
            return true;
        }
        return false;
    }

    @Hook(injectOnExit=true)
    public static void attackEntityFrom(EntityLivingBase entityLivingBase, DamageSource damageSource, float f) {
        if (GloomyHooks.checkNanHealth(entityLivingBase)) {
            Logger.severe("Entity " + entityLivingBase + " got NaN hp after attack from " + damageSource.getDamageType() + "/" + damageSource.getEntity() + ", damage = " + f, new Object[0]);
            Thread.dumpStack();
        }
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean heal(EntityLivingBase entityLivingBase, float f) {
        if (Float.isNaN(f)) {
            Logger.severe("NaN healing to " + entityLivingBase, new Object[0]);
            Thread.dumpStack();
            if (entityLivingBase instanceof EntityPlayerMP) {
                ((EntityPlayerMP)entityLivingBase).sendChatToPlayer(ChatMessageComponent._d("\u0412\u0430\u043c \u0432\u043e\u0441\u0441\u0442\u0430\u043d\u043e\u0432\u0430\u043b\u0438 NaN \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u044f, \u044d\u0442\u043e \u043e\u0447\u0435\u043d\u044c \u043f\u043b\u043e\u0445\u043e. \u0421\u0440\u043e\u0447\u043d\u043e \u0441\u043e\u043e\u0431\u0449\u0438\u0442\u0435 \u0430\u0434\u043c\u0438\u043d\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u0438."));
            }
            return true;
        }
        return false;
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void loadWorld(Minecraft minecraft, pkix pkix2, String string) {
        ((ClientProxy)GloomyCore.proxy).onWorldLoaded(pkix2);
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderHand(EntityRenderer entityRenderer, float f, int n) {
        _e = Minecraft._E()._M.hideGUI;
        Minecraft._E()._M.hideGUI = _e && !KeyboardListener._a;
    }

    @Hook(injectOnExit=true, targetMethod="renderHand")
    @ezey(_a={eidj.CLIENT})
    public static void renderHandPost(EntityRenderer entityRenderer, float f, int n) {
        Minecraft._E()._M.hideGUI = _e;
    }

    @Hook
    public static void writeChunkToNBT(AnvilChunkLoader anvilChunkLoader, Chunk chunk, World world, NBTTagCompound nBTTagCompound) {
        GloomyHooks.cleanupChunk(chunk);
    }

    @Hook(injectOnExit=true)
    public static void readChunkFromNBT(AnvilChunkLoader anvilChunkLoader, NBTTagCompound nBTTagCompound, @Hook.ReturnValue Chunk chunk) {
        GloomyHooks.cleanupChunk(chunk);
    }

    private static void cleanupChunk(Chunk chunk) {
        ujzm[] ujzmArray = chunk._b();
        for (int i = 0; i < ujzmArray.length; ++i) {
            ujzm ujzm2 = ujzmArray[i];
            if (ujzm2 == null || !ujzm2._a()) continue;
            ujzmArray[i] = null;
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void addKey(IntHashMap intHashMap, int n, Object object) {
        int n2 = IntHashMap._a(n);
        int n3 = IntHashMap._a(n2, intHashMap._a.length);
        pibn pibn2 = intHashMap._a[n3];
        while (pibn2 != null) {
            if (pibn2._a == n) {
                pibn2._b = object;
                return;
            }
            pibn2 = pibn2._c;
        }
        ++intHashMap._e;
        intHashMap._a(n2, n, object, n3);
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static Object removeObject(IntHashMap intHashMap, int n) {
        pibn pibn2 = intHashMap._g(n);
        return pibn2 == null ? null : pibn2._b;
    }

    @Hook(injectOnExit=true)
    @ezey(_a={eidj.CLIENT})
    public static void mouseXYChange(pzde pzde2) {
        jysc jysc2 = jysc._H();
        if (jysc2 != null && jysc2._C()._a()) {
            pzde2._a = 0;
            pzde2._b = 0;
        }
    }

    @Hook(injectOnExit=true)
    @ezey(_a={eidj.CLIENT})
    public static void updatePlayerMoveState(samo samo2) {
        jysc jysc2 = jysc._H();
        if (jysc2 != null && jysc2._C()._b()) {
            samo2._c = false;
            samo2._d = false;
            samo2._b = 0.0f;
            samo2._a = 0.0f;
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void onUpdate(EntityItem entityItem) {
        xqrn xqrn2;
        if (entityItem.worldObj.isRemote && (xqrn2 = xqrn._a(entityItem)) != null) {
            xqrn2._a();
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static boolean renderWorldBlock(FMLRenderAccessLibrary fMLRenderAccessLibrary, RenderBlocks renderBlocks, IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4) {
        try {
            return RenderingRegistry.instance().renderWorldBlock(renderBlocks, iBlockAccess, n, n2, n3, block, n4);
        }
        catch (Exception exception) {
            FMLLog.warning("Can not render block at " + n + " " + n2 + " " + n3, new Object[0]);
            exception.printStackTrace();
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            exception.printStackTrace(printWriter);
            return false;
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void beginMinecraftLoading(FMLClientHandler fMLClientHandler, Minecraft minecraft, List list, ifzx ifzx2) {
        FMLLog.fine("Adding mod assets directory to resource packs list: " + GloomyStartHooks._a.getAbsolutePath(), new Object[0]);
        list.add(new yvjs(GloomyStartHooks._a));
    }

    @Hook(injectOnExit=true)
    public static void getEnchantmentModifierDamage(zhty zhty2, ItemStack[] itemStackArray, DamageSource damageSource) {
        zhty._b._b = null;
    }

    @Hook(injectOnExit=true)
    public static void getEnchantmentModifierLiving(zhty zhty2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        zhty._c._b = null;
    }

    @Hook(returnCondition=ReturnCondition.ON_NOT_NULL)
    public static IChunkProvider createChunkGenerator(WorldProvider worldProvider) {
        if (GloomyCore.chunkGenerationEnabled) {
            return null;
        }
        return new gloomyfolken.mods.core.misc.eidj(worldProvider._b);
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void handleSpawnPosition(bscn bscn2, xbzt xbzt2) {
    }

    @Hook
    public static void setInventorySlotContents(InventoryPlayer inventoryPlayer, int n, ItemStack itemStack) {
        if (itemStack != null && !inventoryPlayer._e.worldObj.isRemote) {
            ncwh._b(inventoryPlayer._e, itemStack);
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void onStoppedUsingItem(vlzh vlzh2, EntityPlayer entityPlayer) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void renderSky(cvgz cvgz2, float f) {
        uhfi._a(cvgz2._f, f);
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void damageArmor(InventoryPlayer inventoryPlayer, float f) {
        f = Math.min(f / 4.0f, 1.0f);
        for (int i = 0; i < inventoryPlayer._b.length; ++i) {
            if (inventoryPlayer._b[i] == null || !(inventoryPlayer._b[i]._a() instanceof ItemArmor)) continue;
            inventoryPlayer._b[i]._a((int)f, inventoryPlayer._e.getRNG());
        }
        if (inventoryPlayer._e.inventoryContainer instanceof zwyn) {
            ((zwyn)inventoryPlayer._e.inventoryContainer).onItemsChanged();
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static String sendSessionRequest(bscn bscn2, String string, String string2, String string3) {
        if (string.startsWith("Test-")) {
            return "OK";
        }
        try {
            URL uRL = new URL("http://149.202.196.164:4390/join?user=" + GloomyHooks.urlEncode(string) + "&sessionId=" + GloomyHooks.urlEncode(string2) + "&serverId=" + GloomyHooks.urlEncode(string3));
            InputStream inputStream = uRL.openConnection(Minecraft._E()._Q()).getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String string4 = bufferedReader.readLine();
            bufferedReader.close();
            return string4;
        }
        catch (IOException iOException) {
            return iOException.toString();
        }
    }

    private static String urlEncode(String string) throws IOException {
        return URLEncoder.encode(string, "UTF-8");
    }

    public static boolean isRendererHidden(WorldRenderer worldRenderer) {
        return worldRenderer.posY < _b;
    }

    public static void createInfo(EntityPlayer entityPlayer) {
        ccxr ccxr2 = new ccxr(entityPlayer);
        entityPlayer.registerExtendedProperties("st_attrib", ccxr2);
        ccxr2._a();
    }

    public static boolean dispatchRcon(Object object, Object object2, String string) {
        try {
            Class<?> clazz = Class.forName("org.bukkit.craftbukkit.v1_6_R3.command.CraftRemoteConsoleCommandSender");
            if (clazz == object2.getClass()) {
                MinecraftServer minecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();
                Field field = object.getClass().getDeclaredField("vanillaConsoleSender");
                field.setAccessible(true);
                minecraftServer._J().executeCommand((ICommandSender)field.get(object), string);
                return true;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean clickMiddleMouseButton(Minecraft minecraft) {
        if (minecraft._t != null && !minecraft._t.isUsingItem() && minecraft._L != null && minecraft._t.capabilities._d) {
            if (!ForgeHooks.onPickBlock(minecraft._L, minecraft._t, minecraft._r)) {
                return true;
            }
            int n = minecraft._t.inventory._c;
            ItemStack itemStack = minecraft._t.inventory._a[n];
            new ivkt(n, itemStack).sendToServer();
        }
        return true;
    }

    @ezey(_a={eidj.CLIENT})
    public static boolean onRenderHand(EntityRenderer entityRenderer, float f, int n) {
        return MinecraftForge.EVENT_BUS.post(new jylm.eidj(entityRenderer, f, n));
    }

    public static void setRenderDistanceWeight(EntityLivingBase entityLivingBase) {
        if (FMLCommonHandler.instance().getSide().isClient()) {
            InvokeSideOnly.client(() -> {
                if (GloomyHooks.isHighRenderDistanceEnabled()) {
                    entityLivingBase.renderDistanceWeight = 10000.0;
                }
            });
        }
    }

    public static boolean getWorldInitialized(World world) {
        return world.worldInfo._h > 4000000000000000000L;
    }

    @ezey(_a={eidj.CLIENT})
    private static float getSunBrightness(float f) {
        pkix pkix2 = Minecraft._E()._r;
        float f2 = pkix2.getCelestialAngle(f);
        float f3 = 1.0f - (sajh._b(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.2f);
        f3 = sajh._a(f3, 0.0f, 1.0f);
        f3 = 1.0f - f3;
        f3 = (float)((double)f3 * (1.0 - (double)(pkix2.getRainStrength(f) * 5.0f) / 16.0));
        f3 = (float)((double)f3 * (1.0 - (double)(pkix2.getWeightedThunderStrength(f) * 5.0f) / 16.0));
        return f3;
    }

    @ezey(_a={eidj.CLIENT})
    public static void updateLightmap(float f) {
        if (_f == null) {
            _f = new fmab();
        }
        Minecraft minecraft = Minecraft._E();
        EntityRenderer entityRenderer = minecraft._D;
        pkix pkix2 = minecraft._r;
        if (pkix2 != null) {
            float f2 = pkix2.getCurrentMoonPhaseFactor() * 0.1f;
            float f3 = GloomyHooks.getSunBrightness(1.0f) * (1.0f - f2) + f2;
            for (int i = 0; i < 256; ++i) {
                float f4;
                float f5;
                float f6 = pkix2.provider._h[i / 16] * f3;
                float f7 = pkix2.provider._h[i % 16] * (entityRenderer.torchFlickerX * 0.1f + 1.5f);
                if (pkix2.lastLightningBolt > 0) {
                    f6 = pkix2.provider._h[i / 16];
                }
                fmab fmab2 = _f;
                fmab2._a = i;
                fmab2._b = f3;
                fmab2._c = f7;
                fmab2._d = f7 * ((f7 * 0.6f + 0.4f) * 0.6f + 0.4f);
                fmab2._e = f7 * (f7 * f7 * 0.6f + 0.4f);
                fmab2._f = f6 * (f3 * 0.65f + 0.35f);
                fmab2._g = f6 * (f3 * 0.65f + 0.35f);
                fmab2._h = f6;
                MinecraftForge.EVENT_BUS.post(fmab2);
                float f8 = fmab2._c + fmab2._f;
                float f9 = fmab2._d + fmab2._g;
                float f10 = fmab2._e + fmab2._h;
                f8 = f8 * 0.98f + 0.02f;
                f9 = f9 * 0.98f + 0.02f;
                f10 = f10 * 0.98f + 0.02f;
                if (entityRenderer.field_82831_U > 0.0f) {
                    f5 = entityRenderer.field_82832_V + (entityRenderer.field_82831_U - entityRenderer.field_82832_V) * f;
                    f8 = f8 * (1.0f - f5) + f8 * 0.7f * f5;
                    f9 = f9 * (1.0f - f5) + f9 * 0.6f * f5;
                    f10 = f10 * (1.0f - f5) + f10 * 0.6f * f5;
                }
                if (pkix2.provider._i == 1) {
                    f8 = 0.22f + f7 * 0.75f;
                    f9 = 0.28f + fmab2._d * 0.75f;
                    f10 = 0.25f + fmab2._e * 0.75f;
                }
                if (minecraft._t.isPotionActive(Potion._r)) {
                    f5 = entityRenderer.getNightVisionBrightness(minecraft._t, f);
                    f4 = 1.0f / f8;
                    if (f4 > 1.0f / f9) {
                        f4 = 1.0f / f9;
                    }
                    if (f4 > 1.0f / f10) {
                        f4 = 1.0f / f10;
                    }
                    f8 = f8 * (1.0f - f5) + f8 * f4 * f5;
                    f9 = f9 * (1.0f - f5) + f9 * f4 * f5;
                    f10 = f10 * (1.0f - f5) + f10 * f4 * f5;
                }
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                if (f9 > 1.0f) {
                    f9 = 1.0f;
                }
                if (f10 > 1.0f) {
                    f10 = 1.0f;
                }
                f5 = minecraft._M.gammaSetting;
                f4 = 1.0f - f8;
                float f11 = 1.0f - f9;
                float f12 = 1.0f - f10;
                f4 = 1.0f - f4 * f4 * f4 * f4;
                f11 = 1.0f - f11 * f11 * f11 * f11;
                f12 = 1.0f - f12 * f12 * f12 * f12;
                f8 = f8 * (1.0f - f5) + f4 * f5;
                f9 = f9 * (1.0f - f5) + f11 * f5;
                f10 = f10 * (1.0f - f5) + f12 * f5;
                f8 = f8 * 0.98f + 0.02f;
                f9 = f9 * 0.98f + 0.02f;
                f10 = f10 * 0.98f + 0.02f;
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                if (f9 > 1.0f) {
                    f9 = 1.0f;
                }
                if (f10 > 1.0f) {
                    f10 = 1.0f;
                }
                if (f8 < 0.0f) {
                    f8 = 0.0f;
                }
                if (f9 < 0.0f) {
                    f9 = 0.0f;
                }
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                int n = 255;
                int n2 = (int)(f8 * 255.0f);
                int n3 = (int)(f9 * 255.0f);
                int n4 = (int)(f10 * 255.0f);
                entityRenderer.lightmapColors[i] = n << 24 | n2 << 16 | n3 << 8 | n4;
            }
            entityRenderer.lightmapTexture._a();
            entityRenderer.lightmapUpdateNeeded = false;
        }
    }

    @ezey(_a={eidj.CLIENT})
    private static boolean isHighRenderDistanceEnabled() {
        return ClientProxy.highRenderDistance.enabled;
    }

    @ezey(_a={eidj.CLIENT})
    public static boolean shouldNotRenderSlot(GuiContainer guiContainer, Slot slot) {
        try {
            if (guiContainer.inventorySlots instanceof zwyn) {
                zwyn zwyn2 = (zwyn)guiContainer.inventorySlots;
                return !zwyn2.isSlotActive(slot);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public static boolean onJump(EntityPlayer entityPlayer) {
        return MinecraftForge.EVENT_BUS.post(new jymv.pidb(entityPlayer));
    }

    public static void afterJump(EntityPlayer entityPlayer) {
        MinecraftForge.EVENT_BUS.post(new jymv.kjui(entityPlayer));
    }

    @ezey(_a={eidj.CLIENT})
    public static void orientCameraPre(float f) {
        MinecraftForge.EVENT_BUS.post(new rpct.pidb(f));
    }

    @ezey(_a={eidj.CLIENT})
    public static void orientCameraPost(float f) {
        MinecraftForge.EVENT_BUS.post(new rpct.kjui(f));
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void changeCurrentItem(InventoryPlayer inventoryPlayer, int n) {
        anrg anrg2;
        InventoryPlayer inventoryPlayer2 = Minecraft._E()._t.inventory;
        int n2 = n < 0 ? inventoryPlayer2._c - 1 : inventoryPlayer2._c + 1;
        int n3 = GloomyCore.instance.containerFactory._b();
        if (n2 < 0) {
            n2 = n3 - 1;
        } else if (n2 >= n3) {
            n2 = 0;
        }
        if (inventoryPlayer2._c >= n3) {
            int n4 = inventoryPlayer2._c = n < 0 ? 0 : n3 - 1;
        }
        if (MinecraftForge.EVENT_BUS.post(anrg2 = new anrg(n2, inventoryPlayer2._c, false))) {
            inventoryPlayer2._c = n2;
        }
    }

    public static boolean getTrue() {
        return true;
    }

    @ezey(_a={eidj.CLIENT})
    public static void onInitGuiOptions(GuiOptions guiOptions) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException, SecurityException {
        guiOptions.buttonList.add(new GuiButton(42, guiOptions.width / 2 + 2, guiOptions.height / 6 + 60, 150, 20, "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043c\u043e\u0434\u043e\u0432..."));
    }

    @ezey(_a={eidj.CLIENT})
    public static void onOptionsActionPerformed(GuiOptions guiOptions, GuiButton guiButton) {
        if (guiButton.id == 42) {
            Minecraft._E()._M.saveOptions();
            Minecraft._E()._a(new GuiModGameOptions(guiOptions));
        }
    }

    public static void knockBack(EntityLivingBase entityLivingBase, Entity entity, float f, double d, double d2) {
        ntxh ntxh2 = new ntxh(entityLivingBase, entity, d, d2);
        if (MinecraftForge.EVENT_BUS.post(ntxh2)) {
            return;
        }
        if (entityLivingBase.worldObj.rand.nextDouble() >= entityLivingBase.getEntityAttribute(sajz._c)._e()) {
            float f2 = sajh._a(ntxh2._b * ntxh2._b + ntxh2._c * ntxh2._c);
            float f3 = ntxh2._d;
            double d3 = entityLivingBase.motionX;
            double d4 = entityLivingBase.motionY;
            double d5 = entityLivingBase.motionZ;
            d3 /= 2.0;
            d4 /= 2.0;
            d5 /= 2.0;
            d3 -= ntxh2._b / (double)f2 * (double)f3;
            d4 += (double)f3;
            d5 -= ntxh2._c / (double)f2 * (double)f3;
            if (d4 > (double)0.4f) {
                d4 = 0.4f;
            }
            entityLivingBase.addVelocity(d3 - entityLivingBase.motionX, d4 - entityLivingBase.motionY, d5 - entityLivingBase.motionZ);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static boolean onUpdateEquippedItem(ItemRenderer itemRenderer) {
        return MinecraftForge.EVENT_BUS.post(new xqsm(itemRenderer));
    }

    @ezey(_a={eidj.CLIENT})
    public static void onSetRotationAnglesVanilla(ModelBiped modelBiped, float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        if (GloomyCore.smartmovingEnabled) {
            return;
        }
        if (!(entity instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer entityPlayer = (EntityPlayer)entity;
        GloomyHooks._g._a = modelBiped;
        ncux ncux2 = ncux._p;
        ncux2._a(entityPlayer, modelBiped, f, f2, f3, f4, f5, f6, modelBiped.bipedBody, modelBiped.bipedHead, modelBiped.bipedRightArm, modelBiped.bipedLeftArm, modelBiped.bipedRightLeg, modelBiped.bipedLeftLeg, _g);
        MinecraftForge.EVENT_BUS.post(ncux2);
    }

    public static boolean cantDestroyBlock(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return !entityPlayer.capabilities._e;
    }

    @ezey(_a={eidj.CLIENT})
    public static boolean cantThePlayerDestroyBlock(int n, int n2, int n3) {
        return GloomyHooks.cantDestroyBlock(Minecraft._E()._t, n, n2, n3);
    }

    public static boolean onBgKeyReleased(Object object) {
        try {
            Class<?> clazz = Class.forName("poersch.minecraft.util.keyhandler.KeyReleasedHandler");
            Field field = clazz.getField("id");
            int n = field.getInt(object);
            if (n == 0) {
                return true;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public static void startTileProfiling(TileEntity tileEntity) {
        InvokeSideOnly.frontend(!tileEntity.worldObj.isRemote, () -> {});
    }

    public static void stopTileProfiling(TileEntity tileEntity) {
        InvokeSideOnly.frontend(!tileEntity.worldObj.isRemote, () -> {});
    }

    public static void onSlotChanged(Slot slot) {
        if (slot.getHasStack() && !gloomyfolken.mods.core.misc.pidb._a(slot.inventory) && gloomyfolken.mods.core.misc.pidb._e(slot.getStack()) != null) {
            if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
                return;
            }
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static ItemStack slotClick(Container container, int n, int n2, int n3, EntityPlayer entityPlayer) {
        ItemStack itemStack = null;
        InventoryPlayer inventoryPlayer = entityPlayer.inventory;
        if (n3 == 5) {
            int n4 = container.field_94536_g;
            container.field_94536_g = Container.func_94532_c(n2);
            if ((n4 != 1 || container.field_94536_g != 2) && n4 != container.field_94536_g) {
                container.func_94533_d();
            } else if (inventoryPlayer._g() == null) {
                container.func_94533_d();
            } else if (container.field_94536_g == 0) {
                container.field_94535_f = Container.func_94529_b(n2);
                if (Container.func_94528_d(container.field_94535_f)) {
                    container.field_94536_g = 1;
                    container.field_94537_h.clear();
                } else {
                    container.func_94533_d();
                }
            } else if (container.field_94536_g == 1) {
                Slot slot = (Slot)container.inventorySlots.get(n);
                if (slot != null && Container.func_94527_a(slot, inventoryPlayer._g(), true) && slot.isItemValid(inventoryPlayer._g()) && inventoryPlayer._g()._b > container.field_94537_h.size() && container.canDragIntoSlot(slot)) {
                    container.field_94537_h.add(slot);
                }
            } else if (container.field_94536_g == 2) {
                if (!container.field_94537_h.isEmpty()) {
                    ItemStack itemStack2 = inventoryPlayer._g()._l();
                    int n5 = inventoryPlayer._g()._b;
                    for (Slot slot : container.field_94537_h) {
                        if (slot == null || !Container.func_94527_a(slot, inventoryPlayer._g(), true) || !slot.isItemValid(inventoryPlayer._g()) || inventoryPlayer._g()._b < container.field_94537_h.size() || !container.canDragIntoSlot(slot)) continue;
                        ItemStack itemStack3 = itemStack2._l();
                        int n6 = slot.getHasStack() ? slot.getStack()._b : 0;
                        Container.func_94525_a(container.field_94537_h, container.field_94535_f, itemStack3, n6);
                        if (itemStack3._b > itemStack3._d()) {
                            itemStack3._b = itemStack3._d();
                        }
                        if (itemStack3._b > slot.getSlotStackLimit()) {
                            itemStack3._b = slot.getSlotStackLimit();
                        }
                        n5 -= itemStack3._b - n6;
                        slot.putStack(itemStack3);
                    }
                    itemStack2._b = n5;
                    if (itemStack2._b <= 0) {
                        itemStack2 = null;
                    }
                    inventoryPlayer._d(itemStack2);
                }
                container.func_94533_d();
            } else {
                container.func_94533_d();
            }
        } else if (container.field_94536_g != 0) {
            container.func_94533_d();
        } else if (!(n3 != 0 && n3 != 1 || n2 != 0 && n2 != 1)) {
            if (n == -999) {
                if (inventoryPlayer._g() != null && n == -999) {
                    if (n2 == 0) {
                        entityPlayer.dropPlayerItem(inventoryPlayer._g());
                        inventoryPlayer._d(null);
                    }
                    if (n2 == 1) {
                        entityPlayer.dropPlayerItem(inventoryPlayer._g()._a(1));
                        if (inventoryPlayer._g() != null && inventoryPlayer._g()._b == 0) {
                            inventoryPlayer._d(null);
                        }
                    }
                }
            } else if (n3 == 1) {
                if (n < 0) {
                    return null;
                }
                Slot slot = (Slot)container.inventorySlots.get(n);
                if (slot != null && slot.canTakeStack(entityPlayer)) {
                    ItemStack itemStack4 = container.getSlot(n).getStack();
                    if (itemStack4 != null) {
                        itemStack4 = itemStack4._l();
                    }
                    ItemStack itemStack5 = container.transferStackInSlot(entityPlayer, n);
                    if (itemStack4 != null && itemStack5 != null) {
                        if (!slot.getHasStack()) {
                            ItemStack itemStack6 = itemStack5;
                            InvokeSideOnly.frontend(() -> {});
                        } else {
                            ItemStack itemStack7 = slot.getStack();
                            if (itemStack5._d == itemStack7._d && itemStack5._f == itemStack7._f && Objects.equals(itemStack5._e, itemStack7._e)) {
                                ItemStack itemStack8 = itemStack5._l();
                                itemStack8._b = itemStack5._b - itemStack7._b;
                                InvokeSideOnly.frontend(() -> {});
                            }
                        }
                    }
                    if (itemStack5 != null) {
                        int n7 = itemStack5._d;
                        itemStack = itemStack5._l();
                        if (slot != null && slot.getStack() != null && slot.getStack()._d == n7) {
                            container.retrySlotClick(n, n2, true, entityPlayer);
                        }
                    }
                }
            } else {
                if (n < 0) {
                    return null;
                }
                Slot slot = (Slot)container.inventorySlots.get(n);
                if (slot != null) {
                    ItemStack itemStack9 = slot.getStack();
                    ItemStack itemStack10 = inventoryPlayer._g();
                    if (itemStack9 != null) {
                        itemStack = itemStack9._l();
                    }
                    if (itemStack9 == null) {
                        if (itemStack10 != null && slot.isItemValid(itemStack10)) {
                            int n8;
                            int n9 = n8 = n2 == 0 ? itemStack10._b : 1;
                            if (n8 > slot.getSlotStackLimit()) {
                                n8 = slot.getSlotStackLimit();
                            }
                            if (itemStack10._b >= n8) {
                                slot.putStack(itemStack10._a(n8));
                            }
                            if (itemStack10._b == 0) {
                                inventoryPlayer._d(null);
                            }
                        }
                    } else if (slot.canTakeStack(entityPlayer)) {
                        int n10;
                        if (itemStack10 == null) {
                            int n11 = n2 == 0 ? itemStack9._b : (itemStack9._b + 1) / 2;
                            ItemStack itemStack11 = slot.decrStackSize(n11);
                            inventoryPlayer._d(itemStack11);
                            if (itemStack9._b == 0) {
                                slot.putStack(null);
                            }
                            slot.onPickupFromSlot(entityPlayer, inventoryPlayer._g());
                        } else if (slot.isItemValid(itemStack10)) {
                            if (itemStack9._d == itemStack10._d && itemStack9._j() == itemStack10._j() && ItemStack._a(itemStack9, itemStack10)) {
                                int n12;
                                int n13 = n12 = n2 == 0 ? itemStack10._b : 1;
                                if (n12 > slot.getSlotStackLimit() - itemStack9._b) {
                                    n12 = slot.getSlotStackLimit() - itemStack9._b;
                                }
                                if (n12 > itemStack10._d() - itemStack9._b) {
                                    n12 = itemStack10._d() - itemStack9._b;
                                }
                                itemStack10._a(n12);
                                if (itemStack10._b == 0) {
                                    inventoryPlayer._d(null);
                                }
                                itemStack9._b += n12;
                            } else if (itemStack10._b <= slot.getSlotStackLimit()) {
                                slot.putStack(itemStack10);
                                inventoryPlayer._d(itemStack9);
                                ItemStack itemStack12 = itemStack9;
                                InvokeSideOnly.frontend(() -> {});
                            }
                        } else if (itemStack9._d == itemStack10._d && itemStack10._d() > 1 && (!itemStack9._g() || itemStack9._j() == itemStack10._j()) && ItemStack._a(itemStack9, itemStack10) && (n10 = itemStack9._b) > 0 && n10 + itemStack10._b <= itemStack10._d()) {
                            itemStack10._b += n10;
                            itemStack9 = slot.decrStackSize(n10);
                            if (itemStack9._b == 0) {
                                slot.putStack(null);
                            }
                            slot.onPickupFromSlot(entityPlayer, inventoryPlayer._g());
                        }
                    }
                    slot.onSlotChanged();
                }
            }
        } else if (n3 == 2 && n2 >= 0 && n2 < 9) {
            Slot slot = (Slot)container.inventorySlots.get(n);
            if (slot.canTakeStack(entityPlayer)) {
                ItemStack itemStack13 = inventoryPlayer.getStackInSlot(n2);
                boolean bl = itemStack13 == null || slot.inventory == inventoryPlayer && slot.isItemValid(itemStack13) && slot.getSlotStackLimit() >= itemStack13._b;
                int n14 = -1;
                if (!bl) {
                    n14 = inventoryPlayer._c();
                    bl |= n14 > -1;
                }
                Slot slot2 = (Slot)container.inventorySlots.get(n2);
                ItemStack itemStack14 = slot.getStack();
                if (slot2 != null && slot2.isItemValid(itemStack14)) {
                    if (itemStack14 != null && bl) {
                        itemStack14 = itemStack14._l();
                        inventoryPlayer.setInventorySlotContents(n2, itemStack14);
                        if (!(itemStack13 == null || slot.inventory == inventoryPlayer && slot.isItemValid(itemStack13) && slot.getSlotStackLimit() >= itemStack13._b)) {
                            if (n14 > -1) {
                                inventoryPlayer._c(itemStack13);
                                slot.decrStackSize(itemStack14._b);
                                slot.putStack(null);
                                slot.onPickupFromSlot(entityPlayer, itemStack14);
                            }
                        } else {
                            slot.decrStackSize(itemStack14._b);
                            slot.putStack(itemStack13);
                            slot.onPickupFromSlot(entityPlayer, itemStack14);
                        }
                    } else if (!slot.getHasStack() && itemStack13 != null && slot.isItemValid(itemStack13) && slot.getSlotStackLimit() >= itemStack13._b) {
                        inventoryPlayer.setInventorySlotContents(n2, null);
                        slot.putStack(itemStack13);
                    }
                }
            }
        } else if (n3 == 3 && entityPlayer.capabilities._d && inventoryPlayer._g() == null && n >= 0) {
            Slot slot = (Slot)container.inventorySlots.get(n);
            if (slot != null && slot.getHasStack()) {
                ItemStack itemStack15 = slot.getStack()._l();
                itemStack15._b = itemStack15._d();
                inventoryPlayer._d(itemStack15);
            }
        } else if (n3 == 4 && inventoryPlayer._g() == null && n >= 0) {
            Slot slot = (Slot)container.inventorySlots.get(n);
            if (slot != null && slot.getHasStack() && slot.canTakeStack(entityPlayer)) {
                ItemStack itemStack16 = slot.decrStackSize(n2 == 0 ? 1 : slot.getStack()._b);
                slot.onPickupFromSlot(entityPlayer, itemStack16);
                entityPlayer.dropPlayerItem(itemStack16);
            }
        } else if (n3 == 6 && n >= 0) {
            Slot slot = (Slot)container.inventorySlots.get(n);
            ItemStack itemStack17 = inventoryPlayer._g();
            if (!(itemStack17 == null || slot != null && slot.getHasStack() && slot.canTakeStack(entityPlayer))) {
                int n15 = n2 == 0 ? 0 : container.inventorySlots.size() - 1;
                int n16 = n2 == 0 ? 1 : -1;
                for (int i = 0; i < 2; ++i) {
                    for (int j = n15; j >= 0 && j < container.inventorySlots.size() && itemStack17._b < itemStack17._d(); j += n16) {
                        Slot slot3 = (Slot)container.inventorySlots.get(j);
                        if (!slot3.getHasStack() || !Container.func_94527_a(slot3, itemStack17, true) || !slot3.canTakeStack(entityPlayer) || !container.func_94530_a(itemStack17, slot3) || i == 0 && slot3.getStack()._b == slot3.getStack()._d()) continue;
                        int n17 = Math.min(itemStack17._d() - itemStack17._b, slot3.getStack()._b);
                        ItemStack itemStack18 = slot3.decrStackSize(n17);
                        itemStack17._b += n17;
                        if (itemStack18._b <= 0) {
                            slot3.putStack(null);
                        }
                        slot3.onPickupFromSlot(entityPlayer, itemStack18);
                    }
                }
            }
            container.detectAndSendChanges();
        }
        return itemStack;
    }

    @Hook(injectOnExit=true)
    public static void createDisplay(ForgeHooksClient forgeHooksClient) {
        Display.setTitle("STALCRAFT");
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true, targetMethod="<init>")
    public static void onGuiSmallButtonInit(baxz baxz2, int n, int n2, int n3, EnumOptions enumOptions, String string) {
        if (enumOptions == EnumOptions._h) {
            baxz2.enabled = false;
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void loadOptions(GameSettings gameSettings) {
        gameSettings.viewBobbing = true;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true, targetMethod="<init>")
    public static void onGuiSliderInit(GuiSlider guiSlider, int n, int n2, int n3, EnumOptions enumOptions, String string, float f) {
        if (enumOptions == EnumOptions._f) {
            guiSlider.enabled = false;
        }
    }

    @Hook(targetMethod="<init>")
    public static void onTcpConnection(TcpConnection tcpConnection, ILogAgent iLogAgent, Socket socket, String string, NetHandler netHandler, PrivateKey privateKey) {
        try {
            socket.setTcpNoDelay(true);
        }
        catch (SocketException socketException) {
            System.err.println(socketException.getMessage());
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static boolean equals(xtcd xtcd2, Object object) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        FakeChunkPosition fakeChunkPosition;
        if (!(object instanceof xtcd)) {
            return false;
        }
        xtcd xtcd3 = (xtcd)object;
        if (xtcd2 instanceof FakeChunkPosition) {
            fakeChunkPosition = (FakeChunkPosition)xtcd2;
            n6 = fakeChunkPosition._a;
            n5 = fakeChunkPosition._b;
            n4 = fakeChunkPosition._c;
        } else {
            n6 = xtcd2._d;
            n5 = xtcd2._e;
            n4 = xtcd2._f;
        }
        if (xtcd3 instanceof FakeChunkPosition) {
            fakeChunkPosition = (FakeChunkPosition)xtcd3;
            n3 = fakeChunkPosition._a;
            n2 = fakeChunkPosition._b;
            n = fakeChunkPosition._c;
        } else {
            n3 = xtcd3._d;
            n2 = xtcd3._e;
            n = xtcd3._f;
        }
        return n6 == n3 && n5 == n2 && n4 == n;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static TileEntity getChunkBlockTileEntity(Chunk chunk, int n, int n2, int n3) {
        xtcd xtcd2 = chunk._g.isRemote ? FakeChunkPosition.get(n, n2, n3) : new xtcd(n, n2, n3);
        TileEntity tileEntity = (TileEntity)chunk._l.get(xtcd2);
        if (tileEntity != null && tileEntity.isInvalid()) {
            chunk._l.remove(xtcd2);
            tileEntity = null;
        }
        if (tileEntity == null) {
            int n4 = chunk._d(n, n2, n3);
            int n5 = chunk._e(n, n2, n3);
            if (n4 <= 0 || !Block.blocksList[n4].hasTileEntity(n5)) {
                return null;
            }
            tileEntity = Block.blocksList[n4].createTileEntity(chunk._g, n5);
            chunk._g.setBlockTileEntity(chunk._i * 16 + n, n2, chunk._j * 16 + n3, tileEntity);
        }
        return tileEntity;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void updateTick(BlockGrass blockGrass, World world, int n, int n2, int n3, Random random) {
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, booleanReturnConstant=false, createMethod=true)
    public static boolean pushOutOfBlocks(EntityItem entityItem, double d, double d2, double d3) {
        int n;
        int n2;
        int n3 = sajh._c(d);
        return BlockStalkerSlope.isSlopeBlock(entityItem.worldObj.getBlockId(n3, (n2 = sajh._c(d2)) - 1, n = sajh._c(d3))) || BlockStalkerSlope.isSlopeBlock(entityItem.worldObj.getBlockId(n3 - 1, n2, n)) || BlockStalkerSlope.isSlopeBlock(entityItem.worldObj.getBlockId(n3 + 1, n2, n)) || BlockStalkerSlope.isSlopeBlock(entityItem.worldObj.getBlockId(n3, n2, n + 1)) || BlockStalkerSlope.isSlopeBlock(entityItem.worldObj.getBlockId(n3, n2, n - 1));
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void onPreClientTick(FMLCommonHandler fMLCommonHandler) {
        gloomyfolken.mods.effects.client.main.eidj._a._k = false;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, injectOnExit=true)
    public static String getDisplayName(ItemStack itemStack, @Hook.ReturnValue String string) {
        String string2 = string;
        EnumChatFormatting enumChatFormatting = hanr._c(itemStack);
        if (enumChatFormatting != EnumChatFormatting._p) {
            string2 = (Object)((Object)enumChatFormatting) + string2;
        }
        return string2;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static int getFirstEmptyStack(InventoryPlayer inventoryPlayer) {
        int n = GloomyCore.instance.containerFactory._b();
        int n2 = -1;
        for (int i = 0; i < inventoryPlayer._a.length; ++i) {
            if (inventoryPlayer._a[i] != null) continue;
            n2 = i;
            if (i >= n) break;
        }
        return n2;
    }

    static {
        _g = new ModelBipedAnglesRotator();
        _h = false;
    }

    private static class ModelBipedAnglesRotator
    implements vkmy {
        public ModelBiped _a;

        private ModelBipedAnglesRotator() {
        }

        @Override
        public void rotate(float f, float f2, float f3, float f4, float f5, float f6, EntityPlayer entityPlayer) {
            this._a.setRotationAngles(f, f2, f, f4, f5, f6, entityPlayer);
        }
    }
}

