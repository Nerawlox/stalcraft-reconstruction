/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atc
 *  ats
 *  aur
 *  aut
 *  avw
 *  bdd
 *  bdi
 *  beu
 *  bew
 *  bft
 *  bib
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  jx
 *  nb
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.client.model.techne.TechneModel
 *  net.minecraftforge.common.DimensionManager
 *  net.minecraftforge.common.IExtendedEntityProperties
 *  net.minecraftforge.fluids.BlockFluidBase
 *  ni
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 *  ud
 *  we
 */
package ru.stalcraft.asm;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.model.techne.TechneModel;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.fluids.BlockFluidBase;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import ru.stalcraft.Config;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.Util;
import ru.stalcraft.blocks.BlockEjectionSave;
import ru.stalcraft.clans.IClan;
import ru.stalcraft.clans.IFlag;
import ru.stalcraft.client.ClientEvents;
import ru.stalcraft.client.ClientWeaponInfo;
import ru.stalcraft.client.ejection.ClientEjection;
import ru.stalcraft.client.ejection.ClientEjectionManager;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.player.PlayerClientInfo;
import ru.stalcraft.entity.LastDamage;
import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.items.IArtefakt;
import ru.stalcraft.items.IFlashlight;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.IPlayerServerInfo;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.proxy.IClientProxy;
import ru.stalcraft.proxy.IProxy;
import ru.stalcraft.proxy.IServerProxy;
import ru.stalcraft.server.ServerTicker;
import ru.stalcraft.server.network.ServerPacketSender;

public class MethodsHelper {
    private static boolean wasGraphicsFansy;
    public static boolean isTickingThePlayer;
    private static boolean isTryingToStartWatching;
    private static float savedFarPlaneDistance;
    public static boolean shouldRenderRainShow;
    private static final int X_INV_SIZE = 227;
    private static final int Y_INV_SIZE = 181;

    public static void fakeFourFloats(float angle, float x2, float y2, float z2) {
    }

    public static void fakeThreeFloats(float x2, float y2, float z2) {
    }

    private boolean fixTrader(ye item, uf entityplayer) {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public static float getSunBrightness(float par1) {
        bdd w2 = atv.w().f;
        float f1 = w2.c(par1);
        float f2 = 1.0f - (ls.b(f1 * (float)Math.PI * 2.0f) * 2.0f + 0.2f);
        f2 = ls.a(f2, 0.0f, 1.0f);
        f2 = 1.0f - f2;
        f2 = (float)((double)f2 * (1.0 - (double)(w2.i(par1) * 5.0f) / 16.0));
        f2 = (float)((double)f2 * (1.0 - (double)(w2.h(par1) * 5.0f) / 16.0));
        return f2;
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean shouldNotSetAngles(nn entity) {
        return entity == atv.w().h && !((PlayerClientInfo)PlayerUtils.getInfo((uf)atv.w().h)).navigator.noPath();
    }

    public static void setRenderDistanceWeight(of entity) {
        if (FMLCommonHandler.instance().getSide().isClient()) {
            entity.l = 10000.0;
        }
    }

    public static boolean shouldNotGiveItems(uf player) {
        return PlayerUtils.getInfo(player).getReputation() < -3;
    }

    public static boolean isKissel(BlockFluidBase fluid) {
        return fluid.cF == StalkerMain.kisselFluidBlock.cF;
    }

    public static boolean getWorldInitialized(abw w2) {
        return w2.N().f() > 4000000000000000000L;
    }

    public static boolean cantPlayerEdit(uf player, int x2, int y2, int z2, ye stack) {
        if (player.q.I) {
            return !player.bG.e;
        }
        if (stack != null && stack.d == StalkerMain.flag.cF) {
            return false;
        }
        if (!player.bG.e && !player.q.I) {
            if (StalkerMain.flagManager.getFlagNearby(player.ar, x2, z2) != null) {
                IFlag flag = StalkerMain.flagManager.getFlagNearby(player.ar, x2, z2);
                IClan clan = PlayerUtils.getInfo(MinecraftServer.F().af().f(player.bu)).getClan();
                return clan != flag.getClan();
            }
        }
        return !player.bG.e;
    }

    public static void onPlayerHurt(uf target, nb source, float damage) {
        IProxy proxy = StalkerMain.getProxy();
        if (!proxy.isRemote()) {
            PlayerInfo sufferedInfo;
            IServerProxy serverProxy = (IServerProxy)proxy;
            nn agressor = source.i();
            if (agressor instanceof uf && (sufferedInfo = PlayerUtils.getInfo(target)).getReputation() >= 0 && sufferedInfo.isPlayerAgressive() && damage > 0.0f) {
                PlayerUtils.getInfo((uf)agressor).onAgression();
            }
            if (damage > 0.0f && serverProxy.getAntiRelog().isPlayerRelogging((jv)target)) {
                serverProxy.getAntiRelog().onDamage((jv)target);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static void beforFogUpdate() {
    }

    @SideOnly(value=Side.CLIENT)
    public static void afterFogUpdate(int mode) {
    }

    @SideOnly(value=Side.CLIENT)
    public static void renderSkyOverlay() {
        IClientProxy proxyClient = (IClientProxy)StalkerMain.getProxy();
        if (proxyClient.getEjectionManager() != null && proxyClient.getEjectionManager().hasEjection()) {
            ClientEvents.renderEjectionSkyBox((ClientEjection)proxyClient.getEjectionManager().getEjection());
        }
        float rainBrightness = 1.0f - atv.w().f.i(0.0f);
        GL11.glDisable((int)3008);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)1);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)rainBrightness);
    }

    @SideOnly(value=Side.CLIENT)
    public static void updateLightmap(float frame) {
        atv mc = atv.w();
        bfe er2 = mc.p;
        bdd worldclient = mc.f;
        IProxy proxy = StalkerMain.getProxy();
        float cw = 0.0f;
        if (proxy.getEjectionManager() != null && proxy.getEjectionManager().hasEjection()) {
            cw = ((ClientEjection)proxy.getEjectionManager().getEjection()).getColorWeight();
        }
        float sunBrightness = 0.0f;
        if (worldclient != null) {
            for (int pixel = 0; pixel < 256; ++pixel) {
                float gamma;
                sunBrightness = MethodsHelper.getSunBrightness(1.0f) * 0.97f + 0.03f;
                sunBrightness = sunBrightness * (1.0f - cw) + cw * 0.95f;
                float skyBrightness = worldclient.t.h[pixel / 16] * sunBrightness;
                float varTorch = ((Float)ReflectionHelper.getPrivateValue(bfe.class, (Object)er2, (String[])new String[]{"torchFlickerX", "field_78514_e", "d"})).floatValue();
                float blockBrightness = worldclient.t.h[pixel % 16] * (varTorch * 0.1f + 1.5f);
                if (worldclient.q > 0) {
                    skyBrightness = worldclient.t.h[pixel / 16];
                }
                blockBrightness = blockBrightness * (1.0f - cw) + blockBrightness * (1.0f - skyBrightness) * cw;
                float f4 = skyBrightness * (worldclient.b(1.0f) * 0.65f + 0.35f);
                float f5 = skyBrightness * (worldclient.b(1.0f) * 0.65f + 0.35f);
                float f6 = blockBrightness * ((blockBrightness * 0.6f + 0.4f) * 0.6f + 0.4f);
                float f7 = blockBrightness * (blockBrightness * blockBrightness * 0.6f + 0.4f);
                float redf = f4 * (1.0f - cw) + f4 * 3.0f * cw + blockBrightness;
                float greenf = f5 * (1.0f - cw) + f5 * 0.3f * cw + f6;
                float bluef = skyBrightness * (1.0f - cw) + skyBrightness * 0.3f * cw + f7;
                redf = redf * 0.96f + 0.03f;
                greenf = greenf * 0.96f + 0.03f;
                bluef = bluef * 0.96f + 0.03f;
                float field_82831_U = 0.0f;
                float field_82832_V = 0.0f;
                try {
                    field_82831_U = ((Float)ReflectionHelper.getPrivateValue(bfe.class, (Object)er2, (String[])new String[]{"field_82831_U", "V"})).floatValue();
                }
                catch (Exception exception) {
                    // empty catch block
                }
                try {
                    field_82832_V = ((Float)ReflectionHelper.getPrivateValue(bfe.class, (Object)er2, (String[])new String[]{"field_82832_V", "W"})).floatValue();
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if (field_82831_U > 0.0f) {
                    gamma = field_82832_V + (field_82831_U - field_82832_V) * frame;
                    redf = redf * (1.0f - gamma) + redf * 0.7f * gamma;
                    greenf = greenf * (1.0f - gamma) + greenf * 0.6f * gamma;
                    bluef = bluef * (1.0f - gamma) + bluef * 0.6f * gamma;
                }
                if (worldclient.t.i == 1) {
                    redf = 0.22f + blockBrightness * 0.75f;
                    greenf = 0.28f + f6 * 0.75f;
                    bluef = 0.25f + f7 * 0.75f;
                }
                if (mc.h.a(ni.r)) {
                    gamma = MethodsHelper.getNightVisionBrightness((uf)mc.h, frame);
                    float ored = 1.0f / redf;
                    if (ored > 1.0f / greenf) {
                        ored = 1.0f / greenf;
                    }
                    if (ored > 1.0f / bluef) {
                        ored = 1.0f / bluef;
                    }
                    redf = redf * (1.0f - gamma) + redf * ored * gamma;
                    greenf = greenf * (1.0f - gamma) + greenf * ored * gamma;
                    bluef = bluef * (1.0f - gamma) + bluef * ored * gamma;
                }
                if (redf > 1.0f) {
                    redf = 1.0f;
                }
                if (greenf > 1.0f) {
                    greenf = 1.0f;
                }
                if (bluef > 1.0f) {
                    bluef = 1.0f;
                }
                gamma = mc.u.ak;
                float ored = 1.0f - redf;
                float ogreen = 1.0f - greenf;
                float oblue = 1.0f - bluef;
                ored = 1.0f - ored * ored * ored * ored;
                ogreen = 1.0f - ogreen * ogreen * ogreen * ogreen;
                oblue = 1.0f - oblue * oblue * oblue * oblue;
                redf = redf * (1.0f - gamma) + ored * gamma;
                greenf = greenf * (1.0f - gamma) + ogreen * gamma;
                bluef = bluef * (1.0f - gamma) + oblue * gamma;
                redf = redf * 0.96f + 0.03f;
                greenf = greenf * 0.96f + 0.03f;
                bluef = bluef * 0.96f + 0.03f;
                if (redf > 1.0f) {
                    redf = 1.0f;
                }
                if (greenf > 1.0f) {
                    greenf = 1.0f;
                }
                if (bluef > 1.0f) {
                    bluef = 1.0f;
                }
                if (redf < 0.0f) {
                    redf = 0.0f;
                }
                if (greenf < 0.0f) {
                    greenf = 0.0f;
                }
                if (bluef < 0.0f) {
                    bluef = 0.0f;
                }
                int alpha = 255;
                int red = (int)(redf * 255.0f);
                int green = (int)(greenf * 255.0f);
                int blue = (int)(bluef * 255.0f);
                ((int[])ReflectionHelper.getPrivateValue(bfe.class, (Object)er2, (String[])new String[]{"lightmapColors", "field_78504_Q", "Q"}))[pixel] = alpha << 24 | red << 16 | green << 8 | blue;
            }
            bib lightmapTexture = (bib)ReflectionHelper.getPrivateValue(bfe.class, (Object)er2, (String[])new String[]{"lightmapTexture", "field_78513_d", "P"});
            lightmapTexture.a();
            ReflectionHelper.setPrivateValue(bfe.class, (Object)er2, (Object)false, (String[])new String[]{"lightmapUpdateNeeded", "field_78536_aa", "ad"});
        }
    }

    private static float getNightVisionBrightness(uf par1EntityPlayer, float par2) {
        int i2 = par1EntityPlayer.b(ni.r).b();
        return i2 > 200 ? 1.0f : 0.7f + ls.a(((float)i2 - par2) * (float)Math.PI * 0.2f) * 0.3f;
    }

    @SideOnly(value=Side.CLIENT)
    public static void onFogColorUpdate() {
        IProxy proxy = StalkerMain.getProxy();
        if (proxy.getEjectionManager() != null && proxy.getEjectionManager().hasEjection()) {
            float blue;
            float green;
            float red;
            bfe er2 = atv.w().p;
            ClientEjection ej2 = (ClientEjection)proxy.getEjectionManager().getEjection();
            float cw = ej2.getColorWeight();
            if (cw < 0.5f) {
                red = ((Float)ReflectionHelper.getPrivateValue(bfe.class, (Object)er2, (String[])new String[]{"fogColorRed", "field_78518_n", "k"})).floatValue() * (1.0f - (cw *= 2.0f)) + 0.8f * cw;
                green = ((Float)ReflectionHelper.getPrivateValue(bfe.class, (Object)er2, (String[])new String[]{"fogColorGreen", "field_78519_o", "l"})).floatValue() * (1.0f - cw) + 0.4f * cw;
                blue = ((Float)ReflectionHelper.getPrivateValue(bfe.class, (Object)er2, (String[])new String[]{"fogColorBlue", "field_78533_p", "m"})).floatValue() * (1.0f - cw);
            } else {
                cw = (cw - 0.5f) * 2.0f;
                red = 0.8f;
                green = 0.4f * (1.0f - cw);
                blue = 0.0f;
            }
            ReflectionHelper.setPrivateValue(bfe.class, (Object)er2, (Object)Float.valueOf(red), (String[])new String[]{"fogColorRed", "field_78518_n", "k"});
            ReflectionHelper.setPrivateValue(bfe.class, (Object)er2, (Object)Float.valueOf(green), (String[])new String[]{"fogColorGreen", "field_78519_o", "l"});
            ReflectionHelper.setPrivateValue(bfe.class, (Object)er2, (Object)Float.valueOf(blue), (String[])new String[]{"fogColorBlue", "field_78533_p", "m"});
            GL11.glClearColor((float)red, (float)green, (float)blue, (float)0.0f);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static atc modifyWorldColor(atc oldColor) {
        IProxy proxy = StalkerMain.getProxy();
        if (proxy.getEjectionManager() != null && proxy.getEjectionManager().hasEjection()) {
            bfe er2 = atv.w().p;
            float cw = ((ClientEjection)proxy.getEjectionManager().getEjection()).getColorWeight();
            if (cw < 0.5f) {
                oldColor.c = oldColor.c * (double)(1.0f - (cw *= 2.0f)) + (double)(1.0f * cw);
                oldColor.d = oldColor.d * (double)(1.0f - cw) + (double)(0.45f * cw);
                oldColor.e *= (double)(1.0f - cw);
            } else {
                cw = (cw - 0.5f) * 2.0f;
                oldColor.c = 1.0;
                oldColor.d = 0.45f * (1.0f - cw);
                oldColor.e = 0.0;
            }
        }
        return oldColor;
    }

    @SideOnly(value=Side.CLIENT)
    private static boolean isHighRenderDistanceEnabled() {
        return GuiSettingsStalker.highRenderDistance;
    }

    @SideOnly(value=Side.CLIENT)
    public static void setTextureSize(TechneModel model, URL fileURL) {
        try {
            Field e2 = model.getClass().getDeclaredField("fileName");
            e2.setAccessible(true);
            String fileName = (String)e2.get(model);
            e2.setAccessible(false);
            HashMap<String, byte[]> zipContents = new HashMap<String, byte[]>();
            ZipInputStream zipInput = new ZipInputStream(fileURL.openStream());
            ZipEntry entry = null;
            byte[] modelXml = null;
            while ((entry = zipInput.getNextEntry()) != null) {
                modelXml = new byte[(int)entry.getSize()];
                int documentBuilderFactory = 0;
                while (zipInput.available() > 0 && documentBuilderFactory < modelXml.length) {
                    modelXml[documentBuilderFactory++] = (byte)zipInput.read();
                }
                zipContents.put(entry.getName(), modelXml);
            }
            modelXml = (byte[])zipContents.get("model.xml");
            if (modelXml == null) {
                return;
            }
            DocumentBuilderFactory var14 = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = var14.newDocumentBuilder();
            Document document = documentBuilder.parse(new ByteArrayInputStream(modelXml));
            NodeList textureSizeNodes = document.getElementsByTagName("TextureSize");
            if (textureSizeNodes.getLength() > 0) {
                String[] textureSizeStr = textureSizeNodes.item(0).getTextContent().split(",");
                model.t = Integer.parseInt(textureSizeStr[0]);
                model.u = Integer.parseInt(textureSizeStr[1]);
            }
        }
        catch (Exception var13) {
            var13.printStackTrace();
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean shouldRenderLeashedEntity(nn entity, bft camera) {
        uf leashedTo;
        if (entity instanceof uf && (leashedTo = PlayerUtils.getInfo((uf)entity).getLeashingPlayer()) != null) {
            return camera.a(leashedTo.E);
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean onMovementInput(bew input) {
        bdi p2 = atv.w().h;
        PlayerClientInfo info = (PlayerClientInfo)PlayerUtils.getInfo((uf)p2);
        if (info.getLeashingPlayer() != null) {
            input.a = 0.0f;
            input.b = 0.0f;
            if (info.shouldMove) {
                input.b += 1.0f;
            }
            input.d = false;
            input.c = info.shouldJump;
            info.shouldJump = false;
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean shouldNotRenderSlot(awy container, we slot) {
        try {
            if (container.e instanceof ICustomContainer) {
                ICustomContainer e2 = (ICustomContainer)((Object)container.e);
                return !e2.isSlotActive(slot);
            }
        }
        catch (Exception var3) {
            var3.printStackTrace();
        }
        return false;
    }

    public static boolean onJump(uf player) {
        return !PlayerUtils.getInfo(player).canJump();
    }

    public static void afterJump(uf player) {
    }

    public static boolean canCollideWithWater(abw world) {
        return !world.I ? false : MethodsHelper.hasThePlayerWaterWalking();
    }

    @SideOnly(value=Side.CLIENT)
    private static boolean hasThePlayerWaterWalking() {
        return atv.w().h != null && isTickingThePlayer ? PlayerUtils.getInfo((uf)atv.w().h).getWaterWalking() : false;
    }

    @SideOnly(value=Side.CLIENT)
    public static void renderDroppedItemBefore(bgw render, ss entity) {
        wasGraphicsFansy = bgl.a.l.j;
        bgl.a.l.j = true;
        GL11.glPushMatrix();
        if (!bgw.g) {
            if (entity.d() != null && entity.d().b() instanceof IArtefakt) {
                aur timer = (aur)ReflectionHelper.getPrivateValue(atv.class, (Object)atv.w(), (String[])new String[]{"timer", "field_71428_T", "S"});
                float frame = timer.c;
                GL11.glTranslatef((float)0.0f, (float)(ls.a(((float)entity.a + frame) / 10.0f + entity.c) * 0.1f + 0.1f), (float)0.0f);
                GL11.glRotatef((float)((((float)entity.a + frame) / 20.0f + entity.c) * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
            } else {
                GL11.glTranslatef((float)0.0f, (float)-0.12f, (float)0.0f);
                GL11.glRotatef((float)entity.A, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static void renderDroppedItemAfter() {
        bgl.a.l.j = wasGraphicsFansy;
        GL11.glPopMatrix();
    }

    @SideOnly(value=Side.CLIENT)
    public static void ejectionCameraEffect(float frame) {
        float[] tr2 = MethodsHelper.getCameraTransform(StalkerMain.getProxy(), frame);
        GL11.glTranslatef((float)tr2[0], (float)tr2[1], (float)tr2[2]);
        GL11.glRotatef((float)tr2[3], (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)tr2[4], (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)tr2[5], (float)0.0f, (float)0.0f, (float)1.0f);
    }

    private static float[] getCameraTransform(IProxy par1, float frame) {
        if (par1.getEjectionManager() != null && par1.getEjectionManager().hasEjection()) {
            ClientEjectionManager par3 = (ClientEjectionManager)par1.getEjectionManager();
            float translateX = par3.prevTranslateX + (par3.translateX - par3.prevTranslateX) * frame;
            float translateY = par3.prevTranslateY + (par3.translateY - par3.prevTranslateY) * frame;
            float translateZ = par3.prevTranslateZ + (par3.translateZ - par3.prevTranslateZ) * frame;
            return new float[]{translateX, translateY, translateZ, 0.0f, 0.0f, 0.0f};
        }
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public static void dropSecondInventory(ud first) {
        PlayerUtils.getInfo((uf)first.d).stInv.dropAllItems();
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean shouldReturnClickMouse(int button) {
        bdi thePlayer = atv.w().h;
        PlayerInfo info = PlayerUtils.getInfo((uf)thePlayer);
        return button == 0 && info.weaponInfo.currentGun != null ? true : (info.getHandcuffs() ? true : thePlayer.bn.a[thePlayer.bn.c] != null && thePlayer.bn.a[thePlayer.bn.c].b() instanceof IFlashlight);
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean shouldReturnClickMouse() {
        return MethodsHelper.shouldReturnClickMouse(0);
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean itemInUseCountIsZero(uf p2) {
        return p2 == atv.w().h && atv.w().u.aa == 0 && p2.bp() != null && p2.bp().b() instanceof ItemWeapon;
    }

    public static boolean isUsingWeapon(uf player) {
        return player.f != null && player.f.b() instanceof ItemWeapon;
    }

    public static boolean isUsingMachineGun(uf player) {
        return PlayerUtils.getInfo((uf)player).weaponInfo.isUsingMachineGun();
    }

    public static void inWeb(nn entity) {
        if (Math.random() > 0.95 && entity instanceof uf) {
            ((uf)entity).a(StalkerDamage.web, (float)Config.webDamage);
        }
    }

    public static void inLeaves(nn entity) {
        entity.am();
    }

    public static void readNBT(uf par1, by par2) {
        if (PlayerUtils.getInfo(par1) instanceof IPlayerServerInfo) {
            IPlayerServerInfo par3 = (IPlayerServerInfo)((Object)PlayerUtils.getInfo(par1));
            par3.readNBT(par2.l("playerInfo"));
        }
    }

    public static void writeNBT(uf par1, by par2) {
        if (PlayerUtils.getInfo(par1) instanceof IPlayerServerInfo) {
            IPlayerServerInfo par3 = (IPlayerServerInfo)((Object)PlayerUtils.getInfo(par1));
            by tag = new by();
            par3.writeNBT(tag);
            par2.a("playerInfo", tag);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static void onChangeCurrentItem(int par1) {
        PlayerInfo info;
        boolean handcuffed;
        ud inv = atv.w().h.bn;
        if (inv.c >= 4) {
            int n2 = inv.c = par1 < 0 ? 0 : 3;
        }
        if (handcuffed = (info = PlayerUtils.getInfo((uf)atv.w().h)).getHandcuffs()) {
            int n3 = inv.c = par1 < 0 ? inv.c - 1 : inv.c + 1;
            if (inv.c < 0) {
                inv.c = 3;
            } else if (inv.c > 3) {
                inv.c = 0;
            }
        }
    }

    public static boolean getTrue() {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public static void onInitGuiOptions(avw gui) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException, SecurityException {
        List buttonList = (List)ReflectionHelper.getPrivateValue(awe.class, (Object)gui, (String[])new String[]{"buttonList", "field_73887_h", "i"});
        buttonList.add(new aut(42, gui.g / 2 + 2, gui.h / 6 + 60, 150, 20, "S.T.A.L.K.E.R..."));
    }

    @SideOnly(value=Side.CLIENT)
    public static void onOptionsActionPerformed(avw gui, aut btn) {
        if (btn.g == 42) {
            atv.w().u.b();
            atv.w().a(new GuiSettingsStalker((awe)gui));
        }
    }

    public static void knockBack(of entityLiving, nn par1Entity, float par2, double par3, double par5) {
        IExtendedEntityProperties lastDamage = entityLiving.getExtendedProperties("last_damage");
        if ((lastDamage == null || !((LastDamage)lastDamage).isBulletDamage) && entityLiving.q.s.nextDouble() >= entityLiving.a(tp.c).e()) {
            entityLiving.an = true;
            float f1 = ls.a(par3 * par3 + par5 * par5);
            float f2 = 0.4f;
            entityLiving.x /= 2.0;
            entityLiving.y /= 2.0;
            entityLiving.z /= 2.0;
            entityLiving.x -= par3 / (double)f1 * (double)f2;
            entityLiving.y += (double)f2;
            entityLiving.z -= par5 / (double)f1 * (double)f2;
            if (entityLiving.y > (double)0.4f) {
                entityLiving.y = 0.4f;
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean shouldNotStopUseItem(uf player) {
        return player.bp() != null && player.bp().b() instanceof ItemWeapon;
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean onUpdateEquippedItem(bfj renderer) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException, SecurityException {
        float f2;
        float f1;
        float f22;
        boolean flag;
        float equippedProgress = ((Float)ReflectionHelper.getPrivateValue(bfj.class, (Object)renderer, (String[])new String[]{"equippedProgress", "field_78454_c", "g"})).floatValue();
        ReflectionHelper.setPrivateValue(bfj.class, (Object)renderer, (Object)Float.valueOf(equippedProgress), (String[])new String[]{"prevEquippedProgress", "field_78451_d", "h"});
        bdi entityclientplayermp = atv.w().h;
        ye itemstack = entityclientplayermp.bn.h();
        int equippedItemSlot = (Integer)ReflectionHelper.getPrivateValue(bfj.class, (Object)renderer, (String[])new String[]{"equippedItemSlot", "field_78450_g", "j"});
        ye itemToRender = (ye)ReflectionHelper.getPrivateValue(bfj.class, (Object)renderer, (String[])new String[]{"itemToRender", "field_78453_b", "f"});
        boolean bl2 = flag = equippedItemSlot == entityclientplayermp.bn.c && itemstack == itemToRender;
        if (itemToRender == null && itemstack == null) {
            flag = true;
        }
        if (itemstack != null && itemToRender != null && itemstack != itemToRender && itemstack.d == itemToRender.d) {
            Util.setPrivateValue(bfj.class, renderer, itemstack, "itemToRender", "field_78453_b", "f");
            flag = true;
        }
        if ((f22 = (f1 = flag ? 1.0f : 0.0f) - equippedProgress) < -(f2 = 0.4f)) {
            f22 = -f2;
        }
        if (f22 > f2) {
            f22 = f2;
        }
        Util.setPrivateValue(bfj.class, renderer, Float.valueOf(equippedProgress += f22), "equippedProgress", "field_78454_c", "g");
        if (equippedProgress < 0.1f) {
            Util.setPrivateValue(bfj.class, renderer, itemstack, "itemToRender", "field_78453_b", "f");
            Util.setPrivateValue(bfj.class, renderer, entityclientplayermp.bn.c, "equippedItemSlot", "field_78450_g", "j");
        }
        return true;
    }

    private static Field getField(Class clazz, String name, String obfName, boolean obf) throws NoSuchFieldException, SecurityException {
        if (!obf) {
            return clazz.getDeclaredField(name);
        }
        Field[] arr$ = clazz.getDeclaredFields();
        for (int i$ = 0; i$ < arr$.length; ++i$) {
            if (!arr$[i$].getName().endsWith(obfName)) continue;
            return arr$[i$];
        }
        throw new NoSuchFieldException();
    }

    public static boolean getGameRule(String rule) {
        try {
            if (!rule.equals("doDaylightCycle")) {
                return false;
            }
            if (!FMLCommonHandler.instance().getEffectiveSide().isClient()) {
                js e2 = DimensionManager.getWorld((int)0);
                return !(e2.J() % 24000L < 12000L ? ServerTicker.tickId % 18L == 0L : ServerTicker.tickId % 6L == 0L);
            }
            return true;
        }
        catch (Exception var2) {
            return true;
        }
    }

    public static void onPlayerPreTick() {
        isTickingThePlayer = true;
    }

    public static void onPlayerPostTick() {
        isTickingThePlayer = false;
    }

    @SideOnly(value=Side.CLIENT)
    public static void renderRope(beu player, double endX, double endY, double endZ, float frame) {
        uf leashingPlayer = PlayerUtils.getInfo((uf)player).getLeashingPlayer();
        boolean invertRope = false;
        if (atv.w().u.aa == 0 && player == PlayerUtils.getInfo((uf)atv.w().h).getLeashingPlayer()) {
            leashingPlayer = atv.w().h;
            invertRope = true;
        }
        if (leashingPlayer != null) {
            float f2;
            int i2;
            boolean firstPerson = atv.w().u.aa == 0 && (leashingPlayer == atv.w().h || invertRope);
            endY -= (1.6 - (double)player.P) * 0.5 + (invertRope ? 0.8 : 0.15);
            bfq t2 = bfq.a;
            double distanceBase = 0.01745329238474369;
            double yaw = MethodsHelper.interpolate(((nn)leashingPlayer).C, ((nn)leashingPlayer).A, frame * 0.5f) * distanceBase;
            double pitch = MethodsHelper.interpolate(((nn)leashingPlayer).D, ((nn)leashingPlayer).B, frame * 0.5f) * distanceBase;
            double yawCos = Math.cos(yaw);
            double yawSin = Math.sin(yaw);
            double pitchSin = Math.sin(pitch);
            double pitchCos = Math.cos(pitch);
            double xStart = MethodsHelper.interpolate(((nn)leashingPlayer).r, ((nn)leashingPlayer).u, frame) - yawCos * (firstPerson ? 0.7 : 0.2) - yawSin * 0.5 * pitchCos;
            double yStart = MethodsHelper.interpolate(((nn)leashingPlayer).s + (double)leashingPlayer.f() * 0.7, ((nn)leashingPlayer).v + (double)leashingPlayer.f() * 0.7, frame) + (firstPerson ? -pitchSin * 0.5 - 0.25 : -1.0);
            double zStart = MethodsHelper.interpolate(((nn)leashingPlayer).t, ((nn)leashingPlayer).w, frame) - yawSin * (firstPerson ? 0.7 : 0.2) + yawCos * 0.5 * pitchCos;
            double yawOffset = MethodsHelper.interpolate(player.aO, player.aN, frame) * distanceBase + 1.5707963267948966;
            if (invertRope) {
                yawOffset += 90.0;
            }
            yawCos = Math.cos(yawOffset) * (double)player.O * 0.4;
            yawSin = Math.sin(yawOffset) * (double)player.O * 0.4;
            double xEndInterpolated = MethodsHelper.interpolate(player.r, player.u, frame) + yawCos;
            double yEndInterpolated = MethodsHelper.interpolate(player.s, player.v, frame);
            double zEndInterpolated = MethodsHelper.interpolate(player.t, player.w, frame) + yawSin;
            endX += yawCos;
            endZ += yawSin;
            double xDistance = xStart - xEndInterpolated;
            double yDistance = yStart - yEndInterpolated;
            double zDistance = zStart - zEndInterpolated;
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2884);
            boolean flag = true;
            double d19 = 0.025;
            t2.b(5);
            for (i2 = 0; i2 <= 24; ++i2) {
                if (i2 % 2 == 0) {
                    t2.a(0.5f, 0.4f, 0.3f, 1.0f);
                } else {
                    t2.a(0.35f, 0.28f, 0.2f, 1.0f);
                }
                f2 = (float)i2 / 24.0f;
                t2.a(endX + xDistance * (double)f2, endY + yDistance * (double)(f2 * f2 + f2) * 0.5 + (double)((24.0f - (float)i2) / 18.0f + 0.125f), endZ + zDistance * (double)f2);
                t2.a(endX + xDistance * (double)f2 + 0.025, endY + yDistance * (double)(f2 * f2 + f2) * 0.5 + (double)((24.0f - (float)i2) / 18.0f + 0.125f) + 0.025, endZ + zDistance * (double)f2);
            }
            t2.a();
            t2.b(5);
            for (i2 = 0; i2 <= 24; ++i2) {
                if (i2 % 2 == 0) {
                    t2.a(0.5f, 0.4f, 0.3f, 1.0f);
                } else {
                    t2.a(0.35f, 0.28f, 0.21000001f, 1.0f);
                }
                f2 = (float)i2 / 24.0f;
                t2.a(endX + xDistance * (double)f2, endY + yDistance * (double)(f2 * f2 + f2) * 0.5 + (double)((24.0f - (float)i2) / 18.0f + 0.125f) + 0.025, endZ + zDistance * (double)f2);
                t2.a(endX + xDistance * (double)f2 + 0.025, endY + yDistance * (double)(f2 * f2 + f2) * 0.5 + (double)((24.0f - (float)i2) / 18.0f + 0.125f), endZ + zDistance * (double)f2 + 0.025);
            }
            t2.a();
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2884);
        }
    }

    public static double interpolate(double prev, double now, double frame) {
        return prev + (now - prev) * frame;
    }

    @SideOnly(value=Side.CLIENT)
    public static void onSetRotationAnglesPlayerAPI(Object fakeModel, float par1, float par2, float par3, float par4, float par5, float par6, nn entity) {
        try {
            Field e2 = fakeModel.getClass().getDeclaredField("model");
            e2.setAccessible(true);
            Object model = e2.get(fakeModel);
            Field mcModelField = model.getClass().getDeclaredField("mp");
            bbj mcModel = (bbj)((Object)mcModelField.get(model));
            Field bipedLeftArmField = model.getClass().getDeclaredField("bipedLeftArm");
            Field bipedRightArmField = model.getClass().getDeclaredField("bipedRightArm");
            Field bipedBodyField = model.getClass().getDeclaredField("bipedBody");
            bcu bipedLeftArm = (bcu)bipedLeftArmField.get(model);
            bcu bipedRightArm = (bcu)bipedRightArmField.get(model);
            bcu bipedBody = (bcu)bipedBodyField.get(model);
            MethodsHelper.onSetRotationAngles(model, mcModel, par1, par2, par3, par4, par5, par6, entity, bipedLeftArm, bipedRightArm, bipedBody, true);
            e2.setAccessible(false);
        }
        catch (Exception var18) {
            var18.printStackTrace();
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static void onSetRotationAnglesVanilla(bbj model, float par1, float par2, float par3, float par4, float par5, float par6, nn entity) {
        if (!StalkerMain.instance.smHelper.isSmartmovingEnabled) {
            MethodsHelper.onSetRotationAngles((Object)model, model, par1, par2, par3, par4, par5, par6, entity, model.g, model.f, model.e, false);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static void onSetRotationAngles(Object model, bbj mcModel, float par1, float par2, float par3, float par4, float par5, float par6, nn entity, bcu bipedLeftArm, bcu bipedRightArm, bcu bipedBody, boolean sm2) {
        if (entity instanceof uf) {
            uf player = (uf)entity;
            PlayerClientInfo info = (PlayerClientInfo)PlayerUtils.getInfo(player);
            if (info.getHandcuffs()) {
                boolean reloadProgress = entity.P <= 1.0f;
                bipedLeftArm.f = reloadProgress ? (float)(-Math.PI) : -0.9424778f;
                bipedRightArm.f = reloadProgress ? (float)(-Math.PI) : -0.9424778f;
                bipedLeftArm.g = bipedBody.g + 0.17453292f;
                bipedRightArm.g = bipedBody.g - 0.17453292f;
                bipedLeftArm.h = 0.0f;
                bipedRightArm.h = 0.0f;
            } else {
                float reloadProgress1;
                if (mcModel.o && player.by() != null && player.by().b() instanceof ItemWeapon && ((ItemWeapon)player.by().b()).isPistol) {
                    mcModel.o = false;
                    reloadProgress1 = bipedRightArm.f;
                    float yRotation = bipedRightArm.g;
                    float zRotation = bipedRightArm.h;
                    if (sm2) {
                        try {
                            Method e2 = model.getClass().getDeclaredMethod("setRotationAngles", Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, nn.class);
                            e2.invoke(model, Float.valueOf(par1), Float.valueOf(par2), Float.valueOf(par3), Float.valueOf(par4), Float.valueOf(par5), Float.valueOf(par6), entity);
                        }
                        catch (Exception var19) {
                            var19.printStackTrace();
                        }
                    } else {
                        mcModel.a(par1, par2, par3, par4, par5, par6, entity);
                    }
                    mcModel.o = true;
                    bipedRightArm.f = reloadProgress1;
                    bipedRightArm.g = yRotation;
                    bipedRightArm.h = zRotation;
                }
                if (mcModel.o && info.weaponInfo.isReloading(player.bn.a[player.bn.c])) {
                    aur timer = (aur)ReflectionHelper.getPrivateValue(atv.class, (Object)atv.w(), (String[])new String[]{"timer", "field_71428_T", "S"});
                    reloadProgress1 = ((ClientWeaponInfo)info.weaponInfo).getReloadRenderProgress(timer.c);
                    bipedRightArm.f = bipedBody.f + (bipedRightArm.f - bipedBody.f) * (1.0f - reloadProgress1);
                    if (((ClientWeaponInfo)info.weaponInfo).getReloadingWeapon() == null || !((ClientWeaponInfo)info.weaponInfo).getReloadingWeapon().isPistol) {
                        bipedLeftArm.f = bipedBody.f + (bipedLeftArm.f - bipedBody.f) * (1.0f - reloadProgress1);
                    }
                }
            }
            if (info.hasQuitted) {
                mcModel.h.f = -1.5707964f;
                mcModel.i.f = -1.5707964f;
                mcModel.h.g = 0.20943952f;
                mcModel.i.g = -0.20943952f;
            }
        }
    }

    public static void renameRegionFile(File file, int x2, int z2) {
        File file2 = new File(file, "region");
        File oldFile = new File(file2, "r." + (x2 >> 5) + "." + (z2 >> 5) + ".mca");
        File newFile = new File(file2, "r." + (x2 >> 5) + "." + (z2 >> 5) + ".m\u0441\u0430");
        if (oldFile.exists() && !newFile.exists()) {
            oldFile.renameTo(newFile);
        }
    }

    public static void onTryStartWatching(jx tracker, jv watcher) {
        nn entity = tracker.a;
        if (watcher != entity) {
            double d0 = watcher.u - (double)(tracker.d / 32);
            double d1 = watcher.w - (double)(tracker.f / 32);
            if (d0 >= (double)(-tracker.b) && d0 <= (double)tracker.b && d1 >= (double)(-tracker.b) && d1 <= (double)tracker.b && !tracker.o.contains(watcher) && (MethodsHelper.isPlayerWatchingThisChunk(watcher, tracker) || tracker.a.p)) {
                isTryingToStartWatching = true;
            }
        }
    }

    private static boolean isPlayerWatchingThisChunk(jv par1EntityPlayerMP, jx par2) {
        return par1EntityPlayerMP.p().s().a(par1EntityPlayerMP, par2.a.aj, par2.a.al);
    }

    public static void afterStartWatching(jx tracker, jv watcher) {
        nn entity = tracker.a;
        if (isTryingToStartWatching && entity instanceof uf) {
            uf player = (uf)entity;
            ServerPacketSender.sendStartWatchingPackets(player, watcher);
        }
        isTryingToStartWatching = false;
    }

    public static boolean cantDestroyBlock(uf player, int x2, int y2, int z2) {
        return !player.bG.e && !StalkerMain.destroyableBlocks.contains(player.q.a(x2, y2, z2));
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean cantThePlayerDestroyBlock(int x2, int y2, int z2) {
        return MethodsHelper.cantDestroyBlock((uf)atv.w().h, x2, y2, z2);
    }

    public static void listen() {
        if (atv.w().n == null || atv.w().n.j) {
            atv mc = atv.w();
            if (mc.n != null) {
                mc.n.m();
            }
            while (Keyboard.next()) {
                ats.a((int)Keyboard.getEventKey(), (boolean)Keyboard.getEventKeyState());
                if (Keyboard.getEventKeyState()) {
                    ats.a((int)Keyboard.getEventKey());
                }
                if (!Keyboard.getEventKeyState()) continue;
                if (Keyboard.getEventKey() == 87) {
                    atv.w().j();
                    continue;
                }
                if (atv.w().n != null) {
                    atv.w().n.n();
                    continue;
                }
                if (Keyboard.getEventKey() == 62 && Keyboard.isKeyDown((int)48)) {
                    boolean bl2 = BlockEjectionSave.isBoxSave = !BlockEjectionSave.isBoxSave;
                }
                if (Keyboard.getEventKey() == 1) {
                    atv.w().i();
                }
                if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown((int)61)) {
                    atv.w().a();
                }
                if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown((int)61)) {
                    atv.w().a();
                }
                if (Keyboard.getEventKey() == 33 && Keyboard.isKeyDown((int)61)) {
                    boolean flag = Keyboard.isKeyDown((int)42) | Keyboard.isKeyDown((int)54);
                    atv.w().u.a(aun.g, flag ? -1 : 1);
                }
                if (Keyboard.getEventKey() == 30 && Keyboard.isKeyDown((int)61)) {
                    atv.w().g.a();
                }
                if (Keyboard.getEventKey() == 35 && Keyboard.isKeyDown((int)61)) {
                    atv.w().u.x = !atv.w().u.x;
                    atv.w().u.b();
                }
                if (Keyboard.getEventKey() == 48 && Keyboard.isKeyDown((int)61)) {
                    boolean bl3 = bgl.p = !bgl.p;
                }
                if (Keyboard.getEventKey() == 25 && Keyboard.isKeyDown((int)61)) {
                    atv.w().u.y = !atv.w().u.y;
                    atv.w().u.b();
                }
                if (Keyboard.getEventKey() == 59) {
                    boolean bl4 = atv.w().u.Z = !atv.w().u.Z;
                }
                if (Keyboard.getEventKey() == 61) {
                    atv.w().u.ab = !atv.w().u.ab;
                    atv.w().u.ac = awe.p();
                }
                if (Keyboard.getEventKey() == 63) {
                    ++atv.w().u.aa;
                    if (atv.w().u.aa > 2) {
                        atv.w().u.aa = 0;
                    }
                }
                if (Keyboard.getEventKey() != 66) continue;
                atv.w().u.af = !atv.w().u.af;
            }
        }
    }

    static {
        isTickingThePlayer = false;
        isTryingToStartWatching = false;
    }
}

