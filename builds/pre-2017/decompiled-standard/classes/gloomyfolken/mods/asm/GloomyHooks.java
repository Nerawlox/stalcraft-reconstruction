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
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.kjui;
import net.minecraft.client.xpzm;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.sajz;
import net.minecraft.util.amxi;
import net.minecraft.util.dwan;
import net.minecraft.util.ezfc;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.pibn;
import net.minecraft.util.pzde;
import net.minecraft.util.sajh;
import net.minecraft.util.samo;
import net.minecraft.util.zwat;
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
    public static void handleFlying(bscn bscn2, yvzj yvzj2) {
        wnja._a(bscn2.getPlayer());
    }

    @Hook(injectOnExit=true, targetMethod="handleFlying")
    @ezey(_a={eidj.CLIENT})
    public static void handleFlyingPost(bscn bscn2, yvzj yvzj2) {
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
    public void renderEntities(cvgz cvgz2, ofbx ofbx2, lpai lpai2, float f) {
        dwwh._a._b();
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void dispatchRenderLast(ForgeHooksClient forgeHooksClient, cvgz cvgz2, float f) {
        dwwh._a._b();
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void tick(apbu apbu2) {
        ClientProxy.ticker._a();
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=true)
    public static void canBlockStay(aorr aorr2, ozlu ozlu2, int n, int n2, int n3) {
    }

    @Hook(injectOnExit=true, priority=HookPriority.LOWEST, targetMethod="onInitializationComplete")
    public static void dumpClasses(FMLClientHandler fMLClientHandler) {
        new xqmv()._a();
    }

    @Hook(injectOnExit=true, targetMethod="<init>")
    public static void onEntityLivingBaseInit(EntityLivingBase entityLivingBase, ozlu ozlu2) {
        entityLivingBase.field_70138_W = 0.95f;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void updateEntity(cffd cffd2) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void updateHopper(cffd cffd2) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void suckItemsIntoHopper(cffd cffd2, sdpc sdpc2) {
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static int getRenderType(twgu twgu2) {
        return _a[twgu2.field_71990_ca];
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static int getRenderType(aorr aorr2) {
        int n = _a[aorr2.field_71990_ca];
        return n == 0 ? 1 : n;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean renderInsideOfBlock(jizq jizq2, float f, dwan dwan2) {
        return dwan2 == null;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean actionPerformed(htjl htjl2, jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            xpzm._E()._a(new GuiModMainOptions(htjl2));
            return true;
        }
        return false;
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void addEntityToWorld(pkix pkix2, int n, Entity entity) {
        entity.field_70157_k = n;
        pkix2.field_73010_i.remove(entity);
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void setDimensionAndSpawnPlayer(xpzm xpzm2, int n) {
        if (xpzm2._t != null) {
            _c = xpzm2._t.field_70157_k;
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void preparePlayerToSpawn(EntityPlayer entityPlayer) {
        if (_c >= 0) {
            entityPlayer.field_70157_k = _c;
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void tickBlocksAndAmbiance(pkix pkix2, int n, Entity entity) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void func_77449_e(nwek nwek2) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void addBaseDataToSnooper(cfbu cfbu2) {
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    @ezey(_a={eidj.CLIENT})
    public static boolean setIngameNotInFocus(xpzm xpzm2) {
        if (xpzm2._B instanceof owwh) {
            if (xpzm2.__ab) {
                xpzm2.__ab = false;
                xpzm2._O._b();
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
        cvzo cvzo2 = entityItem.func_92059_d();
        if (cvzo2 != null && (iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.ENTITY)) instanceof hbcv) {
            return ((hbcv)iItemRenderer)._a(cvzo2, n);
        }
        return n == 0;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void doExplosionB(elkd elkd2, boolean bl) {
        elkd2._e.func_72908_a(elkd2._f, elkd2._g, elkd2._h, "random.explode", 4.0f, (1.0f + (elkd2._e.field_73012_v.nextFloat() - elkd2._e.field_73012_v.nextFloat()) * 0.2f) * 0.7f);
        InvokeSideOnly.client(elkd2._e.field_72995_K, () -> pidb._a(new ogjo(elkd2._e, elkd2._e.func_82732_R()._a(elkd2._f, elkd2._g + 0.25, elkd2._h))));
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public boolean func_85069_a(jxsn jxsn2, StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (jxsn2._d.length != 0 && stackTraceElement != null) {
            StackTraceElement stackTraceElement3 = jxsn2._d[0];
            if (stackTraceElement3.isNativeMethod() == stackTraceElement.isNativeMethod() && Objects.equals(stackTraceElement3.getClassName(), stackTraceElement.getClassName()) && Objects.equals(stackTraceElement3.getFileName(), stackTraceElement.getFileName()) && Objects.equals(stackTraceElement3.getMethodName(), stackTraceElement.getMethodName())) {
                if (stackTraceElement2 != null != jxsn2._d.length > 1) {
                    return false;
                }
                if (stackTraceElement2 != null && !jxsn2._d[1].equals(stackTraceElement2)) {
                    return false;
                }
                jxsn2._d[0] = stackTraceElement;
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
        if (Float.isNaN(entityLivingBase.func_110143_aJ()) || Float.isNaN(entityLivingBase.func_110139_bj())) {
            entityLivingBase.func_110149_m(0.0f);
            entityLivingBase.func_70606_j(0.0f);
            entityLivingBase.func_70645_a(jxtc.field_76380_i);
            if (entityLivingBase instanceof EntityPlayerMP) {
                ((EntityPlayerMP)entityLivingBase).func_70006_a(zwat._d("\u0427\u0442\u043e-\u0442\u043e \u043f\u043e\u0448\u043b\u043e \u043e\u0447\u0435\u043d\u044c \u043d\u0435 \u0442\u0430\u043a, \u0438 \u0432\u044b \u0443\u043c\u0435\u0440\u043b\u0438. \u0421\u0440\u043e\u0447\u043d\u043e \u043d\u0430\u043f\u0438\u0448\u0438\u0442\u0435 \u0430\u0434\u043c\u0438\u043d\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u0438."));
            }
            Logger.severe("Entity " + entityLivingBase + " got NaN HP", new Object[0]);
            return true;
        }
        return false;
    }

    @Hook(injectOnExit=true)
    public static void attackEntityFrom(EntityLivingBase entityLivingBase, jxtc jxtc2, float f) {
        if (GloomyHooks.checkNanHealth(entityLivingBase)) {
            Logger.severe("Entity " + entityLivingBase + " got NaN hp after attack from " + jxtc2.func_76355_l() + "/" + jxtc2.func_76346_g() + ", damage = " + f, new Object[0]);
            Thread.dumpStack();
        }
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean heal(EntityLivingBase entityLivingBase, float f) {
        if (Float.isNaN(f)) {
            Logger.severe("NaN healing to " + entityLivingBase, new Object[0]);
            Thread.dumpStack();
            if (entityLivingBase instanceof EntityPlayerMP) {
                ((EntityPlayerMP)entityLivingBase).func_70006_a(zwat._d("\u0412\u0430\u043c \u0432\u043e\u0441\u0441\u0442\u0430\u043d\u043e\u0432\u0430\u043b\u0438 NaN \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u044f, \u044d\u0442\u043e \u043e\u0447\u0435\u043d\u044c \u043f\u043b\u043e\u0445\u043e. \u0421\u0440\u043e\u0447\u043d\u043e \u0441\u043e\u043e\u0431\u0449\u0438\u0442\u0435 \u0430\u0434\u043c\u0438\u043d\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u0438."));
            }
            return true;
        }
        return false;
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void loadWorld(xpzm xpzm2, pkix pkix2, String string) {
        ((ClientProxy)GloomyCore.proxy).onWorldLoaded(pkix2);
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderHand(tfsl tfsl2, float f, int n) {
        _e = xpzm._E()._M.field_74319_N;
        xpzm._E()._M.field_74319_N = _e && !KeyboardListener._a;
    }

    @Hook(injectOnExit=true, targetMethod="renderHand")
    @ezey(_a={eidj.CLIENT})
    public static void renderHandPost(tfsl tfsl2, float f, int n) {
        xpzm._E()._M.field_74319_N = _e;
    }

    @Hook
    public static void writeChunkToNBT(nffs nffs2, ixzi ixzi2, ozlu ozlu2, qoac qoac2) {
        GloomyHooks.cleanupChunk(ixzi2);
    }

    @Hook(injectOnExit=true)
    public static void readChunkFromNBT(nffs nffs2, qoac qoac2, @Hook.ReturnValue ixzi ixzi2) {
        GloomyHooks.cleanupChunk(ixzi2);
    }

    private static void cleanupChunk(ixzi ixzi2) {
        ujzm[] ujzmArray = ixzi2._b();
        for (int i = 0; i < ujzmArray.length; ++i) {
            ujzm ujzm2 = ujzmArray[i];
            if (ujzm2 == null || !ujzm2._a()) continue;
            ujzmArray[i] = null;
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void addKey(amxi amxi2, int n, Object object) {
        int n2 = amxi._a(n);
        int n3 = amxi._a(n2, amxi2._a.length);
        pibn pibn2 = amxi2._a[n3];
        while (pibn2 != null) {
            if (pibn2._a == n) {
                pibn2._b = object;
                return;
            }
            pibn2 = pibn2._c;
        }
        ++amxi2._e;
        amxi2._a(n2, n, object, n3);
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static Object removeObject(amxi amxi2, int n) {
        pibn pibn2 = amxi2._g(n);
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
        if (entityItem.field_70170_p.field_72995_K && (xqrn2 = xqrn._a(entityItem)) != null) {
            xqrn2._a();
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static boolean renderWorldBlock(FMLRenderAccessLibrary fMLRenderAccessLibrary, htvc htvc2, sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4) {
        try {
            return RenderingRegistry.instance().renderWorldBlock(htvc2, sdrg2, n, n2, n3, twgu2, n4);
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
    public static void beginMinecraftLoading(FMLClientHandler fMLClientHandler, xpzm xpzm2, List list, ifzx ifzx2) {
        FMLLog.fine("Adding mod assets directory to resource packs list: " + GloomyStartHooks._a.getAbsolutePath(), new Object[0]);
        list.add(new yvjs(GloomyStartHooks._a));
    }

    @Hook(injectOnExit=true)
    public static void getEnchantmentModifierDamage(zhty zhty2, cvzo[] cvzoArray, jxtc jxtc2) {
        zhty._b._b = null;
    }

    @Hook(injectOnExit=true)
    public static void getEnchantmentModifierLiving(zhty zhty2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        zhty._c._b = null;
    }

    @Hook(returnCondition=ReturnCondition.ON_NOT_NULL)
    public static mccn createChunkGenerator(rrte rrte2) {
        if (GloomyCore.chunkGenerationEnabled) {
            return null;
        }
        return new gloomyfolken.mods.core.misc.eidj(rrte2._b);
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void handleSpawnPosition(bscn bscn2, xbzt xbzt2) {
    }

    @Hook
    public static void setInventorySlotContents(net.minecraft.entity.player.eidj eidj2, int n, cvzo cvzo2) {
        if (cvzo2 != null && !eidj2._e.field_70170_p.field_72995_K) {
            ncwh._b(eidj2._e, cvzo2);
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
    public static void damageArmor(net.minecraft.entity.player.eidj eidj2, float f) {
        f = Math.min(f / 4.0f, 1.0f);
        for (int i = 0; i < eidj2._b.length; ++i) {
            if (eidj2._b[i] == null || !(eidj2._b[i]._a() instanceof lpno)) continue;
            eidj2._b[i]._a((int)f, eidj2._e.func_70681_au());
        }
        if (eidj2._e.field_71069_bz instanceof zwyn) {
            ((zwyn)eidj2._e.field_71069_bz).onItemsChanged();
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static String sendSessionRequest(bscn bscn2, String string, String string2, String string3) {
        if (string.startsWith("Test-")) {
            return "OK";
        }
        try {
            URL uRL = new URL("http://149.202.196.164:4390/join?user=" + GloomyHooks.urlEncode(string) + "&sessionId=" + GloomyHooks.urlEncode(string2) + "&serverId=" + GloomyHooks.urlEncode(string3));
            InputStream inputStream = uRL.openConnection(xpzm._E()._Q()).getInputStream();
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

    public static boolean isRendererHidden(nvgj nvgj2) {
        return nvgj2.field_78920_d < _b;
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
                dzfd dzfd2 = FMLCommonHandler.instance().getMinecraftServerInstance();
                Field field = object.getClass().getDeclaredField("vanillaConsoleSender");
                field.setAccessible(true);
                dzfd2._J().func_71556_a((nemo)field.get(object), string);
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
    public static boolean clickMiddleMouseButton(xpzm xpzm2) {
        if (xpzm2._t != null && !xpzm2._t.func_71039_bw() && xpzm2._L != null && xpzm2._t.field_71075_bZ._d) {
            if (!ForgeHooks.onPickBlock(xpzm2._L, xpzm2._t, xpzm2._r)) {
                return true;
            }
            int n = xpzm2._t.field_71071_by._c;
            cvzo cvzo2 = xpzm2._t.field_71071_by._a[n];
            new ivkt(n, cvzo2).sendToServer();
        }
        return true;
    }

    @ezey(_a={eidj.CLIENT})
    public static boolean onRenderHand(tfsl tfsl2, float f, int n) {
        return MinecraftForge.EVENT_BUS.post(new jylm.eidj(tfsl2, f, n));
    }

    public static void setRenderDistanceWeight(EntityLivingBase entityLivingBase) {
        if (FMLCommonHandler.instance().getSide().isClient()) {
            InvokeSideOnly.client(() -> {
                if (GloomyHooks.isHighRenderDistanceEnabled()) {
                    entityLivingBase.field_70155_l = 10000.0;
                }
            });
        }
    }

    public static boolean getWorldInitialized(ozlu ozlu2) {
        return ozlu2.field_72986_A._h > 4000000000000000000L;
    }

    @ezey(_a={eidj.CLIENT})
    private static float getSunBrightness(float f) {
        pkix pkix2 = xpzm._E()._r;
        float f2 = pkix2.func_72826_c(f);
        float f3 = 1.0f - (sajh._b(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.2f);
        f3 = sajh._a(f3, 0.0f, 1.0f);
        f3 = 1.0f - f3;
        f3 = (float)((double)f3 * (1.0 - (double)(pkix2.func_72867_j(f) * 5.0f) / 16.0));
        f3 = (float)((double)f3 * (1.0 - (double)(pkix2.func_72819_i(f) * 5.0f) / 16.0));
        return f3;
    }

    @ezey(_a={eidj.CLIENT})
    public static void updateLightmap(float f) {
        if (_f == null) {
            _f = new fmab();
        }
        xpzm xpzm2 = xpzm._E();
        tfsl tfsl2 = xpzm2._D;
        pkix pkix2 = xpzm2._r;
        if (pkix2 != null) {
            float f2 = pkix2.func_130001_d() * 0.1f;
            float f3 = GloomyHooks.getSunBrightness(1.0f) * (1.0f - f2) + f2;
            for (int i = 0; i < 256; ++i) {
                float f4;
                float f5;
                float f6 = pkix2.field_73011_w._h[i / 16] * f3;
                float f7 = pkix2.field_73011_w._h[i % 16] * (tfsl2.field_78514_e * 0.1f + 1.5f);
                if (pkix2.field_73016_r > 0) {
                    f6 = pkix2.field_73011_w._h[i / 16];
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
                if (tfsl2.field_82831_U > 0.0f) {
                    f5 = tfsl2.field_82832_V + (tfsl2.field_82831_U - tfsl2.field_82832_V) * f;
                    f8 = f8 * (1.0f - f5) + f8 * 0.7f * f5;
                    f9 = f9 * (1.0f - f5) + f9 * 0.6f * f5;
                    f10 = f10 * (1.0f - f5) + f10 * 0.6f * f5;
                }
                if (pkix2.field_73011_w._i == 1) {
                    f8 = 0.22f + f7 * 0.75f;
                    f9 = 0.28f + fmab2._d * 0.75f;
                    f10 = 0.25f + fmab2._e * 0.75f;
                }
                if (xpzm2._t.func_70644_a(hdpq._r)) {
                    f5 = tfsl2.func_82830_a(xpzm2._t, f);
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
                f5 = xpzm2._M.field_74333_Y;
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
                tfsl2.field_78504_Q[i] = n << 24 | n2 << 16 | n3 << 8 | n4;
            }
            tfsl2.field_78513_d._a();
            tfsl2.field_78536_aa = false;
        }
    }

    @ezey(_a={eidj.CLIENT})
    private static boolean isHighRenderDistanceEnabled() {
        return ClientProxy.highRenderDistance.enabled;
    }

    @ezey(_a={eidj.CLIENT})
    public static boolean shouldNotRenderSlot(zybc zybc2, yeso yeso2) {
        try {
            if (zybc2.field_74193_d instanceof zwyn) {
                zwyn zwyn2 = (zwyn)zybc2.field_74193_d;
                return !zwyn2.isSlotActive(yeso2);
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
    public static void changeCurrentItem(net.minecraft.entity.player.eidj eidj2, int n) {
        anrg anrg2;
        net.minecraft.entity.player.eidj eidj3 = xpzm._E()._t.field_71071_by;
        int n2 = n < 0 ? eidj3._c - 1 : eidj3._c + 1;
        int n3 = GloomyCore.instance.containerFactory._b();
        if (n2 < 0) {
            n2 = n3 - 1;
        } else if (n2 >= n3) {
            n2 = 0;
        }
        if (eidj3._c >= n3) {
            int n4 = eidj3._c = n < 0 ? 0 : n3 - 1;
        }
        if (MinecraftForge.EVENT_BUS.post(anrg2 = new anrg(n2, eidj3._c, false))) {
            eidj3._c = n2;
        }
    }

    public static boolean getTrue() {
        return true;
    }

    @ezey(_a={eidj.CLIENT})
    public static void onInitGuiOptions(xayo xayo2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException, SecurityException {
        xayo2.field_73887_h.add(new jiok(42, xayo2.field_73880_f / 2 + 2, xayo2.field_73881_g / 6 + 60, 150, 20, "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043c\u043e\u0434\u043e\u0432..."));
    }

    @ezey(_a={eidj.CLIENT})
    public static void onOptionsActionPerformed(xayo xayo2, jiok jiok2) {
        if (jiok2.field_73741_f == 42) {
            xpzm._E()._M.func_74303_b();
            xpzm._E()._a(new GuiModGameOptions(xayo2));
        }
    }

    public static void knockBack(EntityLivingBase entityLivingBase, Entity entity, float f, double d, double d2) {
        ntxh ntxh2 = new ntxh(entityLivingBase, entity, d, d2);
        if (MinecraftForge.EVENT_BUS.post(ntxh2)) {
            return;
        }
        if (entityLivingBase.field_70170_p.field_73012_v.nextDouble() >= entityLivingBase.func_110148_a(sajz._c)._e()) {
            float f2 = sajh._a(ntxh2._b * ntxh2._b + ntxh2._c * ntxh2._c);
            float f3 = ntxh2._d;
            double d3 = entityLivingBase.field_70159_w;
            double d4 = entityLivingBase.field_70181_x;
            double d5 = entityLivingBase.field_70179_y;
            d3 /= 2.0;
            d4 /= 2.0;
            d5 /= 2.0;
            d3 -= ntxh2._b / (double)f2 * (double)f3;
            d4 += (double)f3;
            d5 -= ntxh2._c / (double)f2 * (double)f3;
            if (d4 > (double)0.4f) {
                d4 = 0.4f;
            }
            entityLivingBase.func_70024_g(d3 - entityLivingBase.field_70159_w, d4 - entityLivingBase.field_70181_x, d5 - entityLivingBase.field_70179_y);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static boolean onUpdateEquippedItem(jizq jizq2) {
        return MinecraftForge.EVENT_BUS.post(new xqsm(jizq2));
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
        ncux2._a(entityPlayer, modelBiped, f, f2, f3, f4, f5, f6, modelBiped.field_78115_e, modelBiped.field_78116_c, modelBiped.field_78112_f, modelBiped.field_78113_g, modelBiped.field_78123_h, modelBiped.field_78124_i, _g);
        MinecraftForge.EVENT_BUS.post(ncux2);
    }

    public static boolean cantDestroyBlock(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return !entityPlayer.field_71075_bZ._e;
    }

    @ezey(_a={eidj.CLIENT})
    public static boolean cantThePlayerDestroyBlock(int n, int n2, int n3) {
        return GloomyHooks.cantDestroyBlock(xpzm._E()._t, n, n2, n3);
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

    public static void startTileProfiling(hurg hurg2) {
        InvokeSideOnly.frontend(!hurg2.field_70331_k.field_72995_K, () -> {});
    }

    public static void stopTileProfiling(hurg hurg2) {
        InvokeSideOnly.frontend(!hurg2.field_70331_k.field_72995_K, () -> {});
    }

    public static void onSlotChanged(yeso yeso2) {
        if (yeso2.func_75216_d() && !gloomyfolken.mods.core.misc.pidb._a(yeso2.field_75224_c) && gloomyfolken.mods.core.misc.pidb._e(yeso2.func_75211_c()) != null) {
            if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
                return;
            }
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static cvzo slotClick(jjgc jjgc2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        cvzo cvzo2 = null;
        net.minecraft.entity.player.eidj eidj2 = entityPlayer.field_71071_by;
        if (n3 == 5) {
            int n4 = jjgc2.field_94536_g;
            jjgc2.field_94536_g = jjgc.func_94532_c(n2);
            if ((n4 != 1 || jjgc2.field_94536_g != 2) && n4 != jjgc2.field_94536_g) {
                jjgc2.func_94533_d();
            } else if (eidj2._g() == null) {
                jjgc2.func_94533_d();
            } else if (jjgc2.field_94536_g == 0) {
                jjgc2.field_94535_f = jjgc.func_94529_b(n2);
                if (jjgc.func_94528_d(jjgc2.field_94535_f)) {
                    jjgc2.field_94536_g = 1;
                    jjgc2.field_94537_h.clear();
                } else {
                    jjgc2.func_94533_d();
                }
            } else if (jjgc2.field_94536_g == 1) {
                yeso yeso2 = (yeso)jjgc2.field_75151_b.get(n);
                if (yeso2 != null && jjgc.func_94527_a(yeso2, eidj2._g(), true) && yeso2.func_75214_a(eidj2._g()) && eidj2._g()._b > jjgc2.field_94537_h.size() && jjgc2.func_94531_b(yeso2)) {
                    jjgc2.field_94537_h.add(yeso2);
                }
            } else if (jjgc2.field_94536_g == 2) {
                if (!jjgc2.field_94537_h.isEmpty()) {
                    cvzo cvzo3 = eidj2._g()._l();
                    int n5 = eidj2._g()._b;
                    for (yeso yeso3 : jjgc2.field_94537_h) {
                        if (yeso3 == null || !jjgc.func_94527_a(yeso3, eidj2._g(), true) || !yeso3.func_75214_a(eidj2._g()) || eidj2._g()._b < jjgc2.field_94537_h.size() || !jjgc2.func_94531_b(yeso3)) continue;
                        cvzo cvzo4 = cvzo3._l();
                        int n6 = yeso3.func_75216_d() ? yeso3.func_75211_c()._b : 0;
                        jjgc.func_94525_a(jjgc2.field_94537_h, jjgc2.field_94535_f, cvzo4, n6);
                        if (cvzo4._b > cvzo4._d()) {
                            cvzo4._b = cvzo4._d();
                        }
                        if (cvzo4._b > yeso3.func_75219_a()) {
                            cvzo4._b = yeso3.func_75219_a();
                        }
                        n5 -= cvzo4._b - n6;
                        yeso3.func_75215_d(cvzo4);
                    }
                    cvzo3._b = n5;
                    if (cvzo3._b <= 0) {
                        cvzo3 = null;
                    }
                    eidj2._d(cvzo3);
                }
                jjgc2.func_94533_d();
            } else {
                jjgc2.func_94533_d();
            }
        } else if (jjgc2.field_94536_g != 0) {
            jjgc2.func_94533_d();
        } else if (!(n3 != 0 && n3 != 1 || n2 != 0 && n2 != 1)) {
            if (n == -999) {
                if (eidj2._g() != null && n == -999) {
                    if (n2 == 0) {
                        entityPlayer.func_71021_b(eidj2._g());
                        eidj2._d(null);
                    }
                    if (n2 == 1) {
                        entityPlayer.func_71021_b(eidj2._g()._a(1));
                        if (eidj2._g() != null && eidj2._g()._b == 0) {
                            eidj2._d(null);
                        }
                    }
                }
            } else if (n3 == 1) {
                if (n < 0) {
                    return null;
                }
                yeso yeso4 = (yeso)jjgc2.field_75151_b.get(n);
                if (yeso4 != null && yeso4.func_82869_a(entityPlayer)) {
                    cvzo cvzo5 = jjgc2.func_75139_a(n).func_75211_c();
                    if (cvzo5 != null) {
                        cvzo5 = cvzo5._l();
                    }
                    cvzo cvzo6 = jjgc2.func_82846_b(entityPlayer, n);
                    if (cvzo5 != null && cvzo6 != null) {
                        if (!yeso4.func_75216_d()) {
                            cvzo cvzo7 = cvzo6;
                            InvokeSideOnly.frontend(() -> {});
                        } else {
                            cvzo cvzo8 = yeso4.func_75211_c();
                            if (cvzo6._d == cvzo8._d && cvzo6._f == cvzo8._f && Objects.equals(cvzo6._e, cvzo8._e)) {
                                cvzo cvzo9 = cvzo6._l();
                                cvzo9._b = cvzo6._b - cvzo8._b;
                                InvokeSideOnly.frontend(() -> {});
                            }
                        }
                    }
                    if (cvzo6 != null) {
                        int n7 = cvzo6._d;
                        cvzo2 = cvzo6._l();
                        if (yeso4 != null && yeso4.func_75211_c() != null && yeso4.func_75211_c()._d == n7) {
                            jjgc2.func_75133_b(n, n2, true, entityPlayer);
                        }
                    }
                }
            } else {
                if (n < 0) {
                    return null;
                }
                yeso yeso5 = (yeso)jjgc2.field_75151_b.get(n);
                if (yeso5 != null) {
                    cvzo cvzo10 = yeso5.func_75211_c();
                    cvzo cvzo11 = eidj2._g();
                    if (cvzo10 != null) {
                        cvzo2 = cvzo10._l();
                    }
                    if (cvzo10 == null) {
                        if (cvzo11 != null && yeso5.func_75214_a(cvzo11)) {
                            int n8;
                            int n9 = n8 = n2 == 0 ? cvzo11._b : 1;
                            if (n8 > yeso5.func_75219_a()) {
                                n8 = yeso5.func_75219_a();
                            }
                            if (cvzo11._b >= n8) {
                                yeso5.func_75215_d(cvzo11._a(n8));
                            }
                            if (cvzo11._b == 0) {
                                eidj2._d(null);
                            }
                        }
                    } else if (yeso5.func_82869_a(entityPlayer)) {
                        int n10;
                        if (cvzo11 == null) {
                            int n11 = n2 == 0 ? cvzo10._b : (cvzo10._b + 1) / 2;
                            cvzo cvzo12 = yeso5.func_75209_a(n11);
                            eidj2._d(cvzo12);
                            if (cvzo10._b == 0) {
                                yeso5.func_75215_d(null);
                            }
                            yeso5.func_82870_a(entityPlayer, eidj2._g());
                        } else if (yeso5.func_75214_a(cvzo11)) {
                            if (cvzo10._d == cvzo11._d && cvzo10._j() == cvzo11._j() && cvzo._a(cvzo10, cvzo11)) {
                                int n12;
                                int n13 = n12 = n2 == 0 ? cvzo11._b : 1;
                                if (n12 > yeso5.func_75219_a() - cvzo10._b) {
                                    n12 = yeso5.func_75219_a() - cvzo10._b;
                                }
                                if (n12 > cvzo11._d() - cvzo10._b) {
                                    n12 = cvzo11._d() - cvzo10._b;
                                }
                                cvzo11._a(n12);
                                if (cvzo11._b == 0) {
                                    eidj2._d(null);
                                }
                                cvzo10._b += n12;
                            } else if (cvzo11._b <= yeso5.func_75219_a()) {
                                yeso5.func_75215_d(cvzo11);
                                eidj2._d(cvzo10);
                                cvzo cvzo13 = cvzo10;
                                InvokeSideOnly.frontend(() -> {});
                            }
                        } else if (cvzo10._d == cvzo11._d && cvzo11._d() > 1 && (!cvzo10._g() || cvzo10._j() == cvzo11._j()) && cvzo._a(cvzo10, cvzo11) && (n10 = cvzo10._b) > 0 && n10 + cvzo11._b <= cvzo11._d()) {
                            cvzo11._b += n10;
                            cvzo10 = yeso5.func_75209_a(n10);
                            if (cvzo10._b == 0) {
                                yeso5.func_75215_d(null);
                            }
                            yeso5.func_82870_a(entityPlayer, eidj2._g());
                        }
                    }
                    yeso5.func_75218_e();
                }
            }
        } else if (n3 == 2 && n2 >= 0 && n2 < 9) {
            yeso yeso6 = (yeso)jjgc2.field_75151_b.get(n);
            if (yeso6.func_82869_a(entityPlayer)) {
                cvzo cvzo14 = eidj2.func_70301_a(n2);
                boolean bl = cvzo14 == null || yeso6.field_75224_c == eidj2 && yeso6.func_75214_a(cvzo14) && yeso6.func_75219_a() >= cvzo14._b;
                int n14 = -1;
                if (!bl) {
                    n14 = eidj2._c();
                    bl |= n14 > -1;
                }
                yeso yeso7 = (yeso)jjgc2.field_75151_b.get(n2);
                cvzo cvzo15 = yeso6.func_75211_c();
                if (yeso7 != null && yeso7.func_75214_a(cvzo15)) {
                    if (cvzo15 != null && bl) {
                        cvzo15 = cvzo15._l();
                        eidj2.func_70299_a(n2, cvzo15);
                        if (!(cvzo14 == null || yeso6.field_75224_c == eidj2 && yeso6.func_75214_a(cvzo14) && yeso6.func_75219_a() >= cvzo14._b)) {
                            if (n14 > -1) {
                                eidj2._c(cvzo14);
                                yeso6.func_75209_a(cvzo15._b);
                                yeso6.func_75215_d(null);
                                yeso6.func_82870_a(entityPlayer, cvzo15);
                            }
                        } else {
                            yeso6.func_75209_a(cvzo15._b);
                            yeso6.func_75215_d(cvzo14);
                            yeso6.func_82870_a(entityPlayer, cvzo15);
                        }
                    } else if (!yeso6.func_75216_d() && cvzo14 != null && yeso6.func_75214_a(cvzo14) && yeso6.func_75219_a() >= cvzo14._b) {
                        eidj2.func_70299_a(n2, null);
                        yeso6.func_75215_d(cvzo14);
                    }
                }
            }
        } else if (n3 == 3 && entityPlayer.field_71075_bZ._d && eidj2._g() == null && n >= 0) {
            yeso yeso8 = (yeso)jjgc2.field_75151_b.get(n);
            if (yeso8 != null && yeso8.func_75216_d()) {
                cvzo cvzo16 = yeso8.func_75211_c()._l();
                cvzo16._b = cvzo16._d();
                eidj2._d(cvzo16);
            }
        } else if (n3 == 4 && eidj2._g() == null && n >= 0) {
            yeso yeso9 = (yeso)jjgc2.field_75151_b.get(n);
            if (yeso9 != null && yeso9.func_75216_d() && yeso9.func_82869_a(entityPlayer)) {
                cvzo cvzo17 = yeso9.func_75209_a(n2 == 0 ? 1 : yeso9.func_75211_c()._b);
                yeso9.func_82870_a(entityPlayer, cvzo17);
                entityPlayer.func_71021_b(cvzo17);
            }
        } else if (n3 == 6 && n >= 0) {
            yeso yeso10 = (yeso)jjgc2.field_75151_b.get(n);
            cvzo cvzo18 = eidj2._g();
            if (!(cvzo18 == null || yeso10 != null && yeso10.func_75216_d() && yeso10.func_82869_a(entityPlayer))) {
                int n15 = n2 == 0 ? 0 : jjgc2.field_75151_b.size() - 1;
                int n16 = n2 == 0 ? 1 : -1;
                for (int i = 0; i < 2; ++i) {
                    for (int j = n15; j >= 0 && j < jjgc2.field_75151_b.size() && cvzo18._b < cvzo18._d(); j += n16) {
                        yeso yeso11 = (yeso)jjgc2.field_75151_b.get(j);
                        if (!yeso11.func_75216_d() || !jjgc.func_94527_a(yeso11, cvzo18, true) || !yeso11.func_82869_a(entityPlayer) || !jjgc2.func_94530_a(cvzo18, yeso11) || i == 0 && yeso11.func_75211_c()._b == yeso11.func_75211_c()._d()) continue;
                        int n17 = Math.min(cvzo18._d() - cvzo18._b, yeso11.func_75211_c()._b);
                        cvzo cvzo19 = yeso11.func_75209_a(n17);
                        cvzo18._b += n17;
                        if (cvzo19._b <= 0) {
                            yeso11.func_75215_d(null);
                        }
                        yeso11.func_82870_a(entityPlayer, cvzo19);
                    }
                }
            }
            jjgc2.func_75142_b();
        }
        return cvzo2;
    }

    @Hook(injectOnExit=true)
    public static void createDisplay(ForgeHooksClient forgeHooksClient) {
        Display.setTitle("STALCRAFT");
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true, targetMethod="<init>")
    public static void onGuiSmallButtonInit(baxz baxz2, int n, int n2, int n3, kjui kjui2, String string) {
        if (kjui2 == kjui._h) {
            baxz2.field_73742_g = false;
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void loadOptions(GameSettings gameSettings) {
        gameSettings.field_74336_f = true;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true, targetMethod="<init>")
    public static void onGuiSliderInit(dyaq dyaq2, int n, int n2, int n3, kjui kjui2, String string, float f) {
        if (kjui2 == kjui._f) {
            dyaq2.field_73742_g = false;
        }
    }

    @Hook(targetMethod="<init>")
    public static void onTcpConnection(hdip hdip2, jjmf jjmf2, Socket socket, String string, elai elai2, PrivateKey privateKey) {
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
    public static hurg getChunkBlockTileEntity(ixzi ixzi2, int n, int n2, int n3) {
        xtcd xtcd2 = ixzi2._g.field_72995_K ? FakeChunkPosition.get(n, n2, n3) : new xtcd(n, n2, n3);
        hurg hurg2 = (hurg)ixzi2._l.get(xtcd2);
        if (hurg2 != null && hurg2.func_70320_p()) {
            ixzi2._l.remove(xtcd2);
            hurg2 = null;
        }
        if (hurg2 == null) {
            int n4 = ixzi2._d(n, n2, n3);
            int n5 = ixzi2._e(n, n2, n3);
            if (n4 <= 0 || !twgu.field_71973_m[n4].hasTileEntity(n5)) {
                return null;
            }
            hurg2 = twgu.field_71973_m[n4].createTileEntity(ixzi2._g, n5);
            ixzi2._g.func_72837_a(ixzi2._i * 16 + n, n2, ixzi2._j * 16 + n3, hurg2);
        }
        return hurg2;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void updateTick(jzmk jzmk2, ozlu ozlu2, int n, int n2, int n3, Random random) {
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, booleanReturnConstant=false, createMethod=true)
    public static boolean pushOutOfBlocks(EntityItem entityItem, double d, double d2, double d3) {
        int n;
        int n2;
        int n3 = sajh._c(d);
        return BlockStalkerSlope.isSlopeBlock(entityItem.field_70170_p.func_72798_a(n3, (n2 = sajh._c(d2)) - 1, n = sajh._c(d3))) || BlockStalkerSlope.isSlopeBlock(entityItem.field_70170_p.func_72798_a(n3 - 1, n2, n)) || BlockStalkerSlope.isSlopeBlock(entityItem.field_70170_p.func_72798_a(n3 + 1, n2, n)) || BlockStalkerSlope.isSlopeBlock(entityItem.field_70170_p.func_72798_a(n3, n2, n + 1)) || BlockStalkerSlope.isSlopeBlock(entityItem.field_70170_p.func_72798_a(n3, n2, n - 1));
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void onPreClientTick(FMLCommonHandler fMLCommonHandler) {
        gloomyfolken.mods.effects.client.main.eidj._a._k = false;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, injectOnExit=true)
    public static String getDisplayName(cvzo cvzo2, @Hook.ReturnValue String string) {
        String string2 = string;
        ezfc ezfc2 = hanr._c(cvzo2);
        if (ezfc2 != ezfc._p) {
            string2 = (Object)((Object)ezfc2) + string2;
        }
        return string2;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static int getFirstEmptyStack(net.minecraft.entity.player.eidj eidj2) {
        int n = GloomyCore.instance.containerFactory._b();
        int n2 = -1;
        for (int i = 0; i < eidj2._a.length; ++i) {
            if (eidj2._a[i] != null) continue;
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
            this._a.func_78087_a(f, f2, f, f4, f5, f6, entityPlayer);
        }
    }
}

