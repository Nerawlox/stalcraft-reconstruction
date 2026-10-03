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
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
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

    static TextureManager engine() {
        return FMLClientHandler.instance().getClient()._h;
    }

    @Deprecated
    public static String getArmorTexture(Entity entity, ItemStack itemStack, String string, int n, int n2, String string2) {
        return ForgeHooksClient.getArmorTexture(entity, itemStack, string, n, string2);
    }

    public static String getArmorTexture(Entity entity, ItemStack itemStack, String string, int n, String string2) {
        String string3 = itemStack._a().getArmorTexture(itemStack, entity, n, string2);
        return string3 != null ? string3 : string;
    }

    public static boolean renderEntityItem(EntityItem entityItem, ItemStack itemStack, float f, float f2, Random random, TextureManager textureManager, RenderBlocks renderBlocks) {
        Block block;
        ItemAtlasHooks.renderEntityItem(null, entityItem, itemStack, f, f2, random, textureManager, renderBlocks);
        IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.ENTITY);
        if (iItemRenderer == null) {
            return false;
        }
        if (iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.ENTITY, itemStack, IItemRenderer.ItemRendererHelper.ENTITY_ROTATION)) {
            GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        }
        if (!iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.ENTITY, itemStack, IItemRenderer.ItemRendererHelper.ENTITY_BOBBING)) {
            GL11.glTranslatef(0.0f, -f, 0.0f);
        }
        boolean bl = iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.ENTITY, itemStack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
        textureManager._a(itemStack._c() == 0 ? sctd._c : sctd._e);
        Block block2 = block = itemStack._d < Block.blocksList.length ? Block.blocksList[itemStack._d] : null;
        if (bl || block != null && RenderBlocks._a(block.getRenderType())) {
            float f3;
            int n = block != null ? block.getRenderType() : 1;
            float f4 = f3 = n == 1 || n == 19 || n == 12 || n == 2 ? 0.5f : 0.25f;
            if (RenderItem.renderInFrame) {
                GL11.glScalef(1.25f, 1.25f, 1.25f);
                GL11.glTranslatef(0.0f, 0.05f, 0.0f);
                GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            }
            GL11.glScalef(f3, f3, f3);
            int n2 = itemStack._b;
            int n3 = n2 > 40 ? 5 : (n2 > 20 ? 4 : (n2 > 5 ? 3 : (n2 > 1 ? 2 : 1)));
            for (int i = 0; i < n3; ++i) {
                GL11.glPushMatrix();
                if (i > 0) {
                    GL11.glTranslatef((random.nextFloat() * 2.0f - 1.0f) * 0.2f / f3, (random.nextFloat() * 2.0f - 1.0f) * 0.2f / f3, (random.nextFloat() * 2.0f - 1.0f) * 0.2f / f3);
                }
                iItemRenderer.renderItem(IItemRenderer.ItemRenderType.ENTITY, itemStack, renderBlocks, entityItem);
                GL11.glPopMatrix();
            }
        } else {
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            iItemRenderer.renderItem(IItemRenderer.ItemRenderType.ENTITY, itemStack, renderBlocks, entityItem);
        }
        return true;
    }

    public static boolean renderInventoryItem(RenderBlocks renderBlocks, TextureManager textureManager, ItemStack itemStack, boolean bl, float f, float f2, float f3) {
        ItemAtlasHooks.renderInventoryItem(null, renderBlocks, textureManager, itemStack, bl, f, f2, f3);
        IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.INVENTORY);
        if (iItemRenderer == null) {
            return false;
        }
        textureManager._a(itemStack._c() == 0 ? sctd._c : sctd._e);
        if (iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.INVENTORY, itemStack, IItemRenderer.ItemRendererHelper.INVENTORY_BLOCK)) {
            GL11.glPushMatrix();
            GL11.glTranslatef(f2 - 2.0f, f3 + 3.0f, -3.0f + f);
            GL11.glScalef(10.0f, 10.0f, 10.0f);
            GL11.glTranslatef(1.0f, 0.5f, 1.0f);
            GL11.glScalef(1.0f, 1.0f, -1.0f);
            GL11.glRotatef(210.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            if (bl) {
                int n = Item.itemsList[itemStack._d].getColorFromItemStack(itemStack, 0);
                float f4 = (float)(n >> 16 & 0xFF) / 255.0f;
                float f5 = (float)(n >> 8 & 0xFF) / 255.0f;
                float f6 = (float)(n & 0xFF) / 255.0f;
                GL11.glColor4f(f4, f5, f6, 1.0f);
            }
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            renderBlocks._g = bl;
            iItemRenderer.renderItem(IItemRenderer.ItemRenderType.INVENTORY, itemStack, renderBlocks);
            renderBlocks._g = true;
            GL11.glPopMatrix();
        } else {
            GL11.glDisable(2896);
            GL11.glPushMatrix();
            GL11.glTranslatef(f2, f3, -3.0f + f);
            if (bl) {
                int n = Item.itemsList[itemStack._d].getColorFromItemStack(itemStack, 0);
                float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
                float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
                float f9 = (float)(n & 0xFF) / 255.0f;
                GL11.glColor4f(f7, f8, f9, 1.0f);
            }
            iItemRenderer.renderItem(IItemRenderer.ItemRenderType.INVENTORY, itemStack, renderBlocks);
            GL11.glPopMatrix();
            GL11.glEnable(2896);
        }
        return true;
    }

    public static void renderEffectOverlay(TextureManager textureManager, RenderItem renderItem) {
    }

    public static void renderEquippedItem(IItemRenderer.ItemRenderType itemRenderType, IItemRenderer iItemRenderer, RenderBlocks renderBlocks, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (iItemRenderer.shouldUseRenderHelper(itemRenderType, itemStack, IItemRenderer.ItemRendererHelper.EQUIPPED_BLOCK)) {
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            iItemRenderer.renderItem(itemRenderType, itemStack, renderBlocks, entityLivingBase);
            GL11.glPopMatrix();
        } else {
            GL11.glPushMatrix();
            GL11.glEnable(32826);
            GL11.glTranslatef(0.0f, -0.3f, 0.0f);
            GL11.glScalef(1.5f, 1.5f, 1.5f);
            GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(335.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.9375f, -0.0625f, 0.0f);
            iItemRenderer.renderItem(itemRenderType, itemStack, renderBlocks, entityLivingBase);
            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }
    }

    public static void orientBedCamera(Minecraft minecraft, EntityLivingBase entityLivingBase) {
        int n;
        int n2;
        int n3 = sajh._c(entityLivingBase.posX);
        Block block = Block.blocksList[minecraft._r.getBlockId(n3, n2 = sajh._c(entityLivingBase.posY), n = sajh._c(entityLivingBase.posZ))];
        if (block != null && block.isBed(minecraft._r, n3, n2, n, entityLivingBase)) {
            int n4 = block.getBedDirection(minecraft._r, n3, n2, n);
            GL11.glRotatef(n4 * 90, 0.0f, 1.0f, 0.0f);
        }
    }

    public static boolean onDrawBlockHighlight(cvgz cvgz2, EntityPlayer entityPlayer, MovingObjectPosition movingObjectPosition, int n, ItemStack itemStack, float f) {
        return MinecraftForge.EVENT_BUS.post(new DrawBlockHighlightEvent(cvgz2, entityPlayer, movingObjectPosition, n, itemStack, f));
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
        FluidRegistry.WATER.setIcons(BlockFluid._a("water_still"), BlockFluid._a("water_flow"));
        FluidRegistry.LAVA.setIcons(BlockFluid._a("lava_still"), BlockFluid._a("lava_flow"));
    }

    public static void onTextureLoadPre(String string) {
        if (Tessellator.renderingWorldRenderer) {
            String string2 = String.format("Warning: Texture %s not preloaded, will cause render glitches!", string);
            System.out.println(string2);
            if (Tessellator.class.getPackage() != null && Tessellator.class.getPackage().getName().startsWith("net.minecraft.")) {
                Minecraft minecraft = FMLClientHandler.instance().getClient();
                if (minecraft._J != null) {
                    minecraft._J.getChatGUI()._a(string2);
                }
            }
        }
    }

    public static void setRenderPass(int n) {
        renderPass = n;
    }

    public static ModelBiped getArmorModel(EntityLivingBase entityLivingBase, ItemStack itemStack, int n, ModelBiped modelBiped) {
        ModelBiped modelBiped2 = itemStack._a().getArmorModel(entityLivingBase, itemStack, n);
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

    public static int getSkyBlendColour(World world, int n, int n2) {
        int n3;
        if (n == skyX && n2 == skyZ && skyInit) {
            return skyRGBMultiplier;
        }
        skyInit = true;
        int n4 = Minecraft._E()._M.fancyGraphics ? ForgeDummyContainer.blendRanges[Minecraft._E()._M.renderDistance] : 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        for (n3 = -n4; n3 <= n4; ++n3) {
            for (int i = -n4; i <= n4; ++i) {
                BiomeGenBase biomeGenBase = world.getBiomeGenForCoords(n + n3, n2 + i);
                int n9 = biomeGenBase._a(biomeGenBase._k());
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

