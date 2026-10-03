/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.asm.ItemAtlasHooks;
import java.util.Random;
import javax.imageio.ImageIO;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.hank;
import net.minecraft.util.sajh;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.ForgeDummyContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.RenderBlockFluid;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class ForgeHooksClient {
    private static final ResourceLocation ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    static int renderPass = -1;
    static int stencilBits = 0;
    private static int skyX;
    private static int skyZ;
    private static boolean skyInit;
    private static int skyRGBMultiplier;

    static apbu engine() {
        return FMLClientHandler.instance().getClient()._h;
    }

    @Deprecated
    public static String getArmorTexture(Entity entity, cvzo cvzo2, String string, int n, int n2, String string2) {
        return ForgeHooksClient.getArmorTexture(entity, cvzo2, string, n, string2);
    }

    public static String getArmorTexture(Entity entity, cvzo cvzo2, String string, int n, String string2) {
        String string3 = cvzo2._a().getArmorTexture(cvzo2, entity, n, string2);
        return string3 != null ? string3 : string;
    }

    public static boolean renderEntityItem(EntityItem entityItem, cvzo cvzo2, float f, float f2, Random random, apbu apbu2, htvc htvc2) {
        twgu twgu2;
        ItemAtlasHooks.renderEntityItem(null, entityItem, cvzo2, f, f2, random, apbu2, htvc2);
        IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.ENTITY);
        if (iItemRenderer == null) {
            return false;
        }
        if (iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.ENTITY, cvzo2, IItemRenderer.ItemRendererHelper.ENTITY_ROTATION)) {
            GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        }
        if (!iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.ENTITY, cvzo2, IItemRenderer.ItemRendererHelper.ENTITY_BOBBING)) {
            GL11.glTranslatef(0.0f, -f, 0.0f);
        }
        boolean bl = iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.ENTITY, cvzo2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
        apbu2._a(cvzo2._c() == 0 ? sctd._c : sctd._e);
        twgu twgu3 = twgu2 = cvzo2._d < twgu.field_71973_m.length ? twgu.field_71973_m[cvzo2._d] : null;
        if (bl || twgu2 != null && htvc._a(twgu2.func_71857_b())) {
            float f3;
            int n = twgu2 != null ? twgu2.func_71857_b() : 1;
            float f4 = f3 = n == 1 || n == 19 || n == 12 || n == 2 ? 0.5f : 0.25f;
            if (xsbj.field_82407_g) {
                GL11.glScalef(1.25f, 1.25f, 1.25f);
                GL11.glTranslatef(0.0f, 0.05f, 0.0f);
                GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            }
            GL11.glScalef(f3, f3, f3);
            int n2 = cvzo2._b;
            int n3 = n2 > 40 ? 5 : (n2 > 20 ? 4 : (n2 > 5 ? 3 : (n2 > 1 ? 2 : 1)));
            for (int i = 0; i < n3; ++i) {
                GL11.glPushMatrix();
                if (i > 0) {
                    GL11.glTranslatef((random.nextFloat() * 2.0f - 1.0f) * 0.2f / f3, (random.nextFloat() * 2.0f - 1.0f) * 0.2f / f3, (random.nextFloat() * 2.0f - 1.0f) * 0.2f / f3);
                }
                iItemRenderer.renderItem(IItemRenderer.ItemRenderType.ENTITY, cvzo2, htvc2, entityItem);
                GL11.glPopMatrix();
            }
        } else {
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            iItemRenderer.renderItem(IItemRenderer.ItemRenderType.ENTITY, cvzo2, htvc2, entityItem);
        }
        return true;
    }

    public static boolean renderInventoryItem(htvc htvc2, apbu apbu2, cvzo cvzo2, boolean bl, float f, float f2, float f3) {
        ItemAtlasHooks.renderInventoryItem(null, htvc2, apbu2, cvzo2, bl, f, f2, f3);
        IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.INVENTORY);
        if (iItemRenderer == null) {
            return false;
        }
        apbu2._a(cvzo2._c() == 0 ? sctd._c : sctd._e);
        if (iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.INVENTORY, cvzo2, IItemRenderer.ItemRendererHelper.INVENTORY_BLOCK)) {
            GL11.glPushMatrix();
            GL11.glTranslatef(f2 - 2.0f, f3 + 3.0f, -3.0f + f);
            GL11.glScalef(10.0f, 10.0f, 10.0f);
            GL11.glTranslatef(1.0f, 0.5f, 1.0f);
            GL11.glScalef(1.0f, 1.0f, -1.0f);
            GL11.glRotatef(210.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            if (bl) {
                int n = tgdv.field_77698_e[cvzo2._d].func_82790_a(cvzo2, 0);
                float f4 = (float)(n >> 16 & 0xFF) / 255.0f;
                float f5 = (float)(n >> 8 & 0xFF) / 255.0f;
                float f6 = (float)(n & 0xFF) / 255.0f;
                GL11.glColor4f(f4, f5, f6, 1.0f);
            }
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            htvc2._g = bl;
            iItemRenderer.renderItem(IItemRenderer.ItemRenderType.INVENTORY, cvzo2, htvc2);
            htvc2._g = true;
            GL11.glPopMatrix();
        } else {
            GL11.glDisable(2896);
            GL11.glPushMatrix();
            GL11.glTranslatef(f2, f3, -3.0f + f);
            if (bl) {
                int n = tgdv.field_77698_e[cvzo2._d].func_82790_a(cvzo2, 0);
                float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
                float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
                float f9 = (float)(n & 0xFF) / 255.0f;
                GL11.glColor4f(f7, f8, f9, 1.0f);
            }
            iItemRenderer.renderItem(IItemRenderer.ItemRenderType.INVENTORY, cvzo2, htvc2);
            GL11.glPopMatrix();
            GL11.glEnable(2896);
        }
        return true;
    }

    public static void renderEffectOverlay(apbu apbu2, xsbj xsbj2) {
    }

    public static void renderEquippedItem(IItemRenderer.ItemRenderType itemRenderType, IItemRenderer iItemRenderer, htvc htvc2, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        if (iItemRenderer.shouldUseRenderHelper(itemRenderType, cvzo2, IItemRenderer.ItemRendererHelper.EQUIPPED_BLOCK)) {
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            iItemRenderer.renderItem(itemRenderType, cvzo2, htvc2, entityLivingBase);
            GL11.glPopMatrix();
        } else {
            GL11.glPushMatrix();
            GL11.glEnable(32826);
            GL11.glTranslatef(0.0f, -0.3f, 0.0f);
            GL11.glScalef(1.5f, 1.5f, 1.5f);
            GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(335.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.9375f, -0.0625f, 0.0f);
            iItemRenderer.renderItem(itemRenderType, cvzo2, htvc2, entityLivingBase);
            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }
    }

    public static void orientBedCamera(xpzm xpzm2, EntityLivingBase entityLivingBase) {
        int n;
        int n2;
        int n3 = sajh._c(entityLivingBase.field_70165_t);
        twgu twgu2 = twgu.field_71973_m[xpzm2._r.func_72798_a(n3, n2 = sajh._c(entityLivingBase.field_70163_u), n = sajh._c(entityLivingBase.field_70161_v))];
        if (twgu2 != null && twgu2.isBed(xpzm2._r, n3, n2, n, entityLivingBase)) {
            int n4 = twgu2.getBedDirection(xpzm2._r, n3, n2, n);
            GL11.glRotatef(n4 * 90, 0.0f, 1.0f, 0.0f);
        }
    }

    public static boolean onDrawBlockHighlight(cvgz cvgz2, EntityPlayer entityPlayer, hank hank2, int n, cvzo cvzo2, float f) {
        return MinecraftForge.EVENT_BUS.post(new DrawBlockHighlightEvent(cvgz2, entityPlayer, hank2, n, cvzo2, f));
    }

    public static void dispatchRenderLast(cvgz cvgz2, float f) {
        GloomyHooks.dispatchRenderLast(null, cvgz2, f);
        MinecraftForge.EVENT_BUS.post(new RenderWorldLastEvent(cvgz2, f));
    }

    public static void onTextureStitchedPre(sctd sctd2) {
        MinecraftForge.EVENT_BUS.post(new TextureStitchEvent.Pre(sctd2));
    }

    public static void onTextureStitchedPost(sctd sctd2) {
        MinecraftForge.EVENT_BUS.post(new TextureStitchEvent.Post(sctd2));
        FluidRegistry.WATER.setIcons(ogyy._a("water_still"), ogyy._a("water_flow"));
        FluidRegistry.LAVA.setIcons(ogyy._a("lava_still"), ogyy._a("lava_flow"));
    }

    public static void onTextureLoadPre(String string) {
        if (htvf.renderingWorldRenderer) {
            String string2 = String.format("Warning: Texture %s not preloaded, will cause render glitches!", string);
            System.out.println(string2);
            if (htvf.class.getPackage() != null && htvf.class.getPackage().getName().startsWith("net.minecraft.")) {
                xpzm xpzm2 = FMLClientHandler.instance().getClient();
                if (xpzm2._J != null) {
                    xpzm2._J.func_73827_b()._a(string2);
                }
            }
        }
    }

    public static void setRenderPass(int n) {
        renderPass = n;
    }

    public static ModelBiped getArmorModel(EntityLivingBase entityLivingBase, cvzo cvzo2, int n, ModelBiped modelBiped) {
        ModelBiped modelBiped2 = cvzo2._a().getArmorModel(entityLivingBase, cvzo2, n);
        return modelBiped2 == null ? modelBiped : modelBiped2;
    }

    public static void createDisplay() throws LWJGLException {
        ImageIO.setUseCache(false);
        PixelFormat pixelFormat = new PixelFormat().withDepthBits(24);
        try {
            Display.create(pixelFormat.withStencilBits(8));
            stencilBits = 8;
        }
        catch (LWJGLException lWJGLException) {
            Display.create(pixelFormat);
            stencilBits = 0;
        }
        GloomyHooks.createDisplay(null);
    }

    public static String fixDomain(String string, String string2) {
        int n = string2.indexOf(58);
        if (n == -1) {
            return string + string2;
        }
        String string3 = string2.substring(n + 1, string2.length());
        if (n > 1) {
            String string4 = string2.substring(0, n);
            return string4 + ':' + string + string3;
        }
        return string + string3;
    }

    public static boolean postMouseEvent() {
        return MinecraftForge.EVENT_BUS.post(new MouseEvent());
    }

    public static float getOffsetFOV(EntityPlayerSP entityPlayerSP, float f) {
        FOVUpdateEvent fOVUpdateEvent = new FOVUpdateEvent(entityPlayerSP, f);
        MinecraftForge.EVENT_BUS.post(fOVUpdateEvent);
        return fOVUpdateEvent.newfov;
    }

    public static int getSkyBlendColour(ozlu ozlu2, int n, int n2) {
        int n3;
        if (n == skyX && n2 == skyZ && skyInit) {
            return skyRGBMultiplier;
        }
        skyInit = true;
        int n4 = xpzm._E()._M.field_74347_j ? ForgeDummyContainer.blendRanges[xpzm._E()._M.field_74339_e] : 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        for (n3 = -n4; n3 <= n4; ++n3) {
            for (int i = -n4; i <= n4; ++i) {
                foqh foqh2 = ozlu2.func_72807_a(n + n3, n2 + i);
                int n9 = foqh2._a(foqh2._k());
                n5 += (n9 & 0xFF0000) >> 16;
                n6 += (n9 & 0xFF00) >> 8;
                n7 += n9 & 0xFF;
                ++n8;
            }
        }
        n3 = (n5 / n8 & 0xFF) << 16 | (n6 / n8 & 0xFF) << 8 | n7 / n8 & 0xFF;
        skyX = n;
        skyZ = n2;
        skyRGBMultiplier = n3;
        return skyRGBMultiplier;
    }

    static {
        FluidRegistry.renderIdFluid = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(RenderBlockFluid.instance);
    }
}

