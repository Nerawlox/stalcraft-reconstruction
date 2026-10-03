/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.asm.ItemAtlasHooks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class ItemRenderer {
    public static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    public static final ResourceLocation RES_MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");
    public static final ResourceLocation RES_UNDERWATER_OVERLAY = new ResourceLocation("textures/misc/underwater.png");
    public Minecraft mc;
    public ItemStack itemToRender;
    public float equippedProgress;
    public float prevEquippedProgress;
    public RenderBlocks renderBlocksInstance = new RenderBlocks();
    public final rqlb mapItemRenderer;
    public int equippedItemSlot = -1;

    public ItemRenderer(Minecraft minecraft) {
        this.mc = minecraft;
        this.mapItemRenderer = new rqlb(minecraft._M, minecraft._R());
    }

    public void renderItem(EntityLivingBase entityLivingBase, ItemStack itemStack, int n) {
        this.renderItem(entityLivingBase, itemStack, n, IItemRenderer.ItemRenderType.EQUIPPED);
    }

    public void renderItem(EntityLivingBase entityLivingBase, ItemStack itemStack, int n, IItemRenderer.ItemRenderType itemRenderType) {
        IItemRenderer iItemRenderer;
        ItemAtlasHooks.renderItem(this, entityLivingBase, itemStack, n, itemRenderType);
        GL11.glPushMatrix();
        TextureManager textureManager = this.mc._R();
        Block block = null;
        if (itemStack._a() instanceof ItemBlock && itemStack._d < Block.blocksList.length) {
            block = Block.blocksList[itemStack._d];
        }
        if ((iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, itemRenderType)) != null) {
            textureManager._a(textureManager._a(itemStack._c()));
            ForgeHooksClient.renderEquippedItem(itemRenderType, iItemRenderer, this.renderBlocksInstance, entityLivingBase, itemStack);
        } else if (block != null && itemStack._c() == 0 && RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType())) {
            textureManager._a(textureManager._a(0));
            this.renderBlocksInstance._a(Block.blocksList[itemStack._d], itemStack._j(), 1.0f);
        } else {
            Icon icon = entityLivingBase.getItemIcon(itemStack, n);
            if (icon == null) {
                GL11.glPopMatrix();
                return;
            }
            textureManager._a(textureManager._a(itemStack._c()));
            Tessellator tessellator = Tessellator.instance;
            float f = icon.getMinU();
            float f2 = icon.getMaxU();
            float f3 = icon.getMinV();
            float f4 = icon.getMaxV();
            float f5 = 0.0f;
            float f6 = 0.3f;
            GL11.glEnable(32826);
            GL11.glTranslatef(-f5, -f6, 0.0f);
            float f7 = 1.5f;
            GL11.glScalef(f7, f7, f7);
            GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(335.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.9375f, -0.0625f, 0.0f);
            ItemRenderer.renderItemIn2D(tessellator, f2, f3, f, f4, icon.getIconWidth(), icon.getIconHeight(), 0.0625f);
            if (itemStack._c(n)) {
                GL11.glDepthFunc(514);
                GL11.glDisable(2896);
                textureManager._a(RES_ITEM_GLINT);
                GL11.glEnable(3042);
                GL11.glBlendFunc(768, 1);
                float f8 = 0.76f;
                GL11.glColor4f(0.5f * f8, 0.25f * f8, 0.8f * f8, 1.0f);
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                float f9 = 0.125f;
                GL11.glScalef(f9, f9, f9);
                float f10 = (float)(Minecraft._M() % 3000L) / 3000.0f * 8.0f;
                GL11.glTranslatef(f10, 0.0f, 0.0f);
                GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
                ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f9, f9, f9);
                f10 = (float)(Minecraft._M() % 4873L) / 4873.0f * 8.0f;
                GL11.glTranslatef(-f10, 0.0f, 0.0f);
                GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
                GL11.glDisable(3042);
                GL11.glEnable(2896);
                GL11.glDepthFunc(515);
            }
            GL11.glDisable(32826);
        }
        GL11.glPopMatrix();
    }

    public static void renderItemIn2D(Tessellator tessellator, float f, float f2, float f3, float f4, int n, int n2, float f5) {
        float f6;
        float f7;
        float f8;
        int n3;
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 0.0f, 1.0f);
        tessellator.addVertexWithUV(0.0, 0.0, 0.0, f, f4);
        tessellator.addVertexWithUV(1.0, 0.0, 0.0, f3, f4);
        tessellator.addVertexWithUV(1.0, 1.0, 0.0, f3, f2);
        tessellator.addVertexWithUV(0.0, 1.0, 0.0, f, f2);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 0.0f, -1.0f);
        tessellator.addVertexWithUV(0.0, 1.0, 0.0f - f5, f, f2);
        tessellator.addVertexWithUV(1.0, 1.0, 0.0f - f5, f3, f2);
        tessellator.addVertexWithUV(1.0, 0.0, 0.0f - f5, f3, f4);
        tessellator.addVertexWithUV(0.0, 0.0, 0.0f - f5, f, f4);
        tessellator.draw();
        float f9 = 0.5f * (f - f3) / (float)n;
        float f10 = 0.5f * (f4 - f2) / (float)n2;
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0f, 0.0f, 0.0f);
        for (n3 = 0; n3 < n; ++n3) {
            f8 = (float)n3 / (float)n;
            f7 = f + (f3 - f) * f8 - f9;
            tessellator.addVertexWithUV(f8, 0.0, 0.0f - f5, f7, f4);
            tessellator.addVertexWithUV(f8, 0.0, 0.0, f7, f4);
            tessellator.addVertexWithUV(f8, 1.0, 0.0, f7, f2);
            tessellator.addVertexWithUV(f8, 1.0, 0.0f - f5, f7, f2);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0f, 0.0f, 0.0f);
        for (n3 = 0; n3 < n; ++n3) {
            f8 = (float)n3 / (float)n;
            f7 = f + (f3 - f) * f8 - f9;
            f6 = f8 + 1.0f / (float)n;
            tessellator.addVertexWithUV(f6, 1.0, 0.0f - f5, f7, f2);
            tessellator.addVertexWithUV(f6, 1.0, 0.0, f7, f2);
            tessellator.addVertexWithUV(f6, 0.0, 0.0, f7, f4);
            tessellator.addVertexWithUV(f6, 0.0, 0.0f - f5, f7, f4);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        for (n3 = 0; n3 < n2; ++n3) {
            f8 = (float)n3 / (float)n2;
            f7 = f4 + (f2 - f4) * f8 - f10;
            f6 = f8 + 1.0f / (float)n2;
            tessellator.addVertexWithUV(0.0, f6, 0.0, f, f7);
            tessellator.addVertexWithUV(1.0, f6, 0.0, f3, f7);
            tessellator.addVertexWithUV(1.0, f6, 0.0f - f5, f3, f7);
            tessellator.addVertexWithUV(0.0, f6, 0.0f - f5, f, f7);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, -1.0f, 0.0f);
        for (n3 = 0; n3 < n2; ++n3) {
            f8 = (float)n3 / (float)n2;
            f7 = f4 + (f2 - f4) * f8 - f10;
            tessellator.addVertexWithUV(1.0, f8, 0.0, f3, f7);
            tessellator.addVertexWithUV(0.0, f8, 0.0, f, f7);
            tessellator.addVertexWithUV(0.0, f8, 0.0f - f5, f, f7);
            tessellator.addVertexWithUV(1.0, f8, 0.0f - f5, f3, f7);
        }
        tessellator.draw();
    }

    public void renderItemInFirstPerson(float f) {
        float f2;
        float f3;
        float f4;
        float f5 = this.prevEquippedProgress + (this.equippedProgress - this.prevEquippedProgress) * f;
        EntityClientPlayerMP entityClientPlayerMP = this.mc._t;
        float f6 = entityClientPlayerMP.prevRotationPitch + (entityClientPlayerMP.rotationPitch - entityClientPlayerMP.prevRotationPitch) * f;
        GL11.glPushMatrix();
        GL11.glRotatef(f6, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(entityClientPlayerMP.prevRotationYaw + (entityClientPlayerMP.rotationYaw - entityClientPlayerMP.prevRotationYaw) * f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glPopMatrix();
        EntityClientPlayerMP entityClientPlayerMP2 = entityClientPlayerMP;
        float f7 = entityClientPlayerMP2.prevRenderArmPitch + (entityClientPlayerMP2.renderArmPitch - entityClientPlayerMP2.prevRenderArmPitch) * f;
        float f8 = entityClientPlayerMP2.prevRenderArmYaw + (entityClientPlayerMP2.renderArmYaw - entityClientPlayerMP2.prevRenderArmYaw) * f;
        GL11.glRotatef((entityClientPlayerMP.rotationPitch - f7) * 0.1f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef((entityClientPlayerMP.rotationYaw - f8) * 0.1f, 0.0f, 1.0f, 0.0f);
        ItemStack itemStack = this.itemToRender;
        float f9 = this.mc._r.getLightBrightness(sajh._c(entityClientPlayerMP.posX), sajh._c(entityClientPlayerMP.posY), sajh._c(entityClientPlayerMP.posZ));
        f9 = 1.0f;
        int n = this.mc._r.getLightBrightnessForSkyBlocks(sajh._c(entityClientPlayerMP.posX), sajh._c(entityClientPlayerMP.posY), sajh._c(entityClientPlayerMP.posZ), 0);
        int n2 = n % 65536;
        int n3 = n / 65536;
        iwya._a(iwya._b, (float)n2 / 1.0f, (float)n3 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (itemStack != null) {
            n = Item.itemsList[itemStack._d].getColorFromItemStack(itemStack, 0);
            f4 = (float)(n >> 16 & 0xFF) / 255.0f;
            f3 = (float)(n >> 8 & 0xFF) / 255.0f;
            f2 = (float)(n & 0xFF) / 255.0f;
            GL11.glColor4f(f9 * f4, f9 * f3, f9 * f2, 1.0f);
        } else {
            GL11.glColor4f(f9, f9, f9, 1.0f);
        }
        if (itemStack != null && itemStack._a() instanceof ItemMap) {
            float f10;
            GL11.glPushMatrix();
            float f11 = 0.8f;
            f4 = entityClientPlayerMP.getSwingProgress(f);
            f3 = sajh._a(f4 * (float)Math.PI);
            f2 = sajh._a(sajh._c(f4) * (float)Math.PI);
            GL11.glTranslatef(-f2 * 0.4f, sajh._a(sajh._c(f4) * (float)Math.PI * 2.0f) * 0.2f, -f3 * 0.2f);
            f4 = 1.0f - f6 / 45.0f + 0.1f;
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            f4 = -sajh._b(f4 * (float)Math.PI) * 0.5f + 0.5f;
            GL11.glTranslatef(0.0f, 0.0f * f11 - (1.0f - f5) * 1.2f - f4 * 0.5f + 0.04f, -0.9f * f11);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(f4 * -85.0f, 0.0f, 0.0f, 1.0f);
            GL11.glEnable(32826);
            this.mc._R()._a(entityClientPlayerMP.getLocationSkin());
            for (n3 = 0; n3 < 2; ++n3) {
                int n4 = n3 * 2 - 1;
                GL11.glPushMatrix();
                GL11.glTranslatef(-0.0f, -0.6f, 1.1f * (float)n4);
                GL11.glRotatef(-45 * n4, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(59.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-65 * n4, 0.0f, 1.0f, 0.0f);
                Render render = RenderManager._b._a(this.mc._t);
                RenderPlayer renderPlayer = (RenderPlayer)render;
                f10 = 1.0f;
                GL11.glScalef(f10, f10, f10);
                renderPlayer.renderFirstPersonArm(this.mc._t);
                GL11.glPopMatrix();
            }
            f3 = entityClientPlayerMP.getSwingProgress(f);
            f2 = sajh._a(f3 * f3 * (float)Math.PI);
            float f12 = sajh._a(sajh._c(f3) * (float)Math.PI);
            GL11.glRotatef(-f2 * 20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f12 * 20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f12 * 80.0f, 1.0f, 0.0f, 0.0f);
            float f13 = 0.38f;
            GL11.glScalef(f13, f13, f13);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.0f, -1.0f, 0.0f);
            f10 = 0.015625f;
            GL11.glScalef(f10, f10, f10);
            this.mc._R()._a(RES_MAP_BACKGROUND);
            Tessellator tessellator = Tessellator.instance;
            GL11.glNormal3f(0.0f, 0.0f, -1.0f);
            tessellator.startDrawingQuads();
            int n5 = 7;
            tessellator.addVertexWithUV(0 - n5, 128 + n5, 0.0, 0.0, 1.0);
            tessellator.addVertexWithUV(128 + n5, 128 + n5, 0.0, 1.0, 1.0);
            tessellator.addVertexWithUV(128 + n5, 0 - n5, 0.0, 1.0, 0.0);
            tessellator.addVertexWithUV(0 - n5, 0 - n5, 0.0, 0.0, 0.0);
            tessellator.draw();
            IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.FIRST_PERSON_MAP);
            thdd thdd2 = ((ItemMap)itemStack._a())._a(itemStack, this.mc._r);
            if (iItemRenderer == null) {
                if (thdd2 != null) {
                    this.mapItemRenderer._a(this.mc._t, this.mc._R(), thdd2);
                }
            } else {
                iItemRenderer.renderItem(IItemRenderer.ItemRenderType.FIRST_PERSON_MAP, itemStack, this.mc._t, this.mc._R(), thdd2);
            }
            GL11.glPopMatrix();
        } else if (itemStack != null) {
            float f14;
            float f15;
            float f16;
            GL11.glPushMatrix();
            float f17 = 0.8f;
            if (entityClientPlayerMP.getItemInUseCount() > 0) {
                EnumAction enumAction = itemStack._o();
                if (enumAction == EnumAction._b || enumAction == EnumAction._c) {
                    f3 = (float)entityClientPlayerMP.getItemInUseCount() - f + 1.0f;
                    f2 = 1.0f - f3 / (float)itemStack._n();
                    f16 = 1.0f - f2;
                    f16 = f16 * f16 * f16;
                    f16 = f16 * f16 * f16;
                    f16 = f16 * f16 * f16;
                    float f18 = 1.0f - f16;
                    GL11.glTranslatef(0.0f, sajh._e(sajh._b(f3 / 4.0f * (float)Math.PI) * 0.1f) * (float)((double)f2 > 0.2 ? 1 : 0), 0.0f);
                    GL11.glTranslatef(f18 * 0.6f, -f18 * 0.5f, 0.0f);
                    GL11.glRotatef(f18 * 90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(f18 * 10.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(f18 * 30.0f, 0.0f, 0.0f, 1.0f);
                }
            } else {
                f4 = entityClientPlayerMP.getSwingProgress(f);
                f3 = sajh._a(f4 * (float)Math.PI);
                f2 = sajh._a(sajh._c(f4) * (float)Math.PI);
                GL11.glTranslatef(-f2 * 0.4f, sajh._a(sajh._c(f4) * (float)Math.PI * 2.0f) * 0.2f, -f3 * 0.2f);
            }
            GL11.glTranslatef(0.7f * f17, -0.65f * f17 - (1.0f - f5) * 0.6f, -0.9f * f17);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glEnable(32826);
            f4 = entityClientPlayerMP.getSwingProgress(f);
            f3 = sajh._a(f4 * f4 * (float)Math.PI);
            f2 = sajh._a(sajh._c(f4) * (float)Math.PI);
            GL11.glRotatef(-f3 * 20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f2 * 20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f2 * 80.0f, 1.0f, 0.0f, 0.0f);
            f16 = 0.4f;
            GL11.glScalef(f16, f16, f16);
            if (entityClientPlayerMP.getItemInUseCount() > 0) {
                EnumAction enumAction = itemStack._o();
                if (enumAction == EnumAction._d) {
                    GL11.glTranslatef(-0.5f, 0.2f, 0.0f);
                    GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
                } else if (enumAction == EnumAction._e) {
                    GL11.glRotatef(-18.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glRotatef(-12.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(-8.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glTranslatef(-0.9f, 0.2f, 0.0f);
                    f15 = (float)itemStack._n() - ((float)entityClientPlayerMP.getItemInUseCount() - f + 1.0f);
                    float f19 = f15 / 20.0f;
                    f19 = (f19 * f19 + f19 * 2.0f) / 3.0f;
                    if (f19 > 1.0f) {
                        f19 = 1.0f;
                    }
                    if (f19 > 0.1f) {
                        GL11.glTranslatef(0.0f, sajh._a((f15 - 0.1f) * 1.3f) * 0.01f * (f19 - 0.1f), 0.0f);
                    }
                    GL11.glTranslatef(0.0f, 0.0f, f19 * 0.1f);
                    GL11.glRotatef(-335.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glTranslatef(0.0f, 0.5f, 0.0f);
                    f14 = 1.0f + f19 * 0.2f;
                    GL11.glScalef(1.0f, 1.0f, f14);
                    GL11.glTranslatef(0.0f, -0.5f, 0.0f);
                    GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(335.0f, 0.0f, 0.0f, 1.0f);
                }
            }
            if (itemStack._a().shouldRotateAroundWhenRendering()) {
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            }
            if (itemStack._a().requiresMultipleRenderPasses()) {
                this.renderItem(entityClientPlayerMP, itemStack, 0, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
                for (int i = 1; i < itemStack._a().getRenderPasses(itemStack._j()); ++i) {
                    int n6 = Item.itemsList[itemStack._d].getColorFromItemStack(itemStack, i);
                    f15 = (float)(n6 >> 16 & 0xFF) / 255.0f;
                    float f20 = (float)(n6 >> 8 & 0xFF) / 255.0f;
                    f14 = (float)(n6 & 0xFF) / 255.0f;
                    GL11.glColor4f(f9 * f15, f9 * f20, f9 * f14, 1.0f);
                    this.renderItem(entityClientPlayerMP, itemStack, i, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
                }
            } else {
                this.renderItem(entityClientPlayerMP, itemStack, 0, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
            }
            GL11.glPopMatrix();
        } else if (!entityClientPlayerMP.isInvisible()) {
            GL11.glPushMatrix();
            float f21 = 0.8f;
            f4 = entityClientPlayerMP.getSwingProgress(f);
            f3 = sajh._a(f4 * (float)Math.PI);
            f2 = sajh._a(sajh._c(f4) * (float)Math.PI);
            GL11.glTranslatef(-f2 * 0.3f, sajh._a(sajh._c(f4) * (float)Math.PI * 2.0f) * 0.4f, -f3 * 0.4f);
            GL11.glTranslatef(0.8f * f21, -0.75f * f21 - (1.0f - f5) * 0.6f, -0.9f * f21);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glEnable(32826);
            f4 = entityClientPlayerMP.getSwingProgress(f);
            f3 = sajh._a(f4 * f4 * (float)Math.PI);
            f2 = sajh._a(sajh._c(f4) * (float)Math.PI);
            GL11.glRotatef(f2 * 70.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f3 * 20.0f, 0.0f, 0.0f, 1.0f);
            this.mc._R()._a(entityClientPlayerMP.getLocationSkin());
            GL11.glTranslatef(-1.0f, 3.6f, 3.5f);
            GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(200.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glTranslatef(5.6f, 0.0f, 0.0f);
            Render render = RenderManager._b._a(this.mc._t);
            RenderPlayer renderPlayer = (RenderPlayer)render;
            float f22 = 1.0f;
            GL11.glScalef(f22, f22, f22);
            renderPlayer.renderFirstPersonArm(this.mc._t);
            GL11.glPopMatrix();
        }
        GL11.glDisable(32826);
        qnon._a();
    }

    public void renderOverlays(float f) {
        GL11.glDisable(3008);
        if (this.mc._t.isBurning()) {
            this.renderFireInFirstPerson(f);
        }
        if (this.mc._t.isEntityInsideOpaqueBlock()) {
            int n = sajh._c(this.mc._t.posX);
            int n2 = sajh._c(this.mc._t.posY);
            int n3 = sajh._c(this.mc._t.posZ);
            int n4 = this.mc._r.getBlockId(n, n2, n3);
            if (this.mc._r.isBlockNormalCube(n, n2, n3)) {
                this.renderInsideOfBlock(f, Block.blocksList[n4].getBlockTextureFromSide(2));
            } else {
                for (int i = 0; i < 8; ++i) {
                    int n5;
                    int n6;
                    float f2 = ((float)((i >> 0) % 2) - 0.5f) * this.mc._t.width * 0.9f;
                    float f3 = ((float)((i >> 1) % 2) - 0.5f) * this.mc._t.height * 0.2f;
                    float f4 = ((float)((i >> 2) % 2) - 0.5f) * this.mc._t.width * 0.9f;
                    int n7 = sajh._d((float)n + f2);
                    if (!this.mc._r.isBlockNormalCube(n7, n6 = sajh._d((float)n2 + f3), n5 = sajh._d((float)n3 + f4))) continue;
                    n4 = this.mc._r.getBlockId(n7, n6, n5);
                }
            }
            if (Block.blocksList[n4] != null) {
                this.renderInsideOfBlock(f, Block.blocksList[n4].getBlockTextureFromSide(2));
            }
        }
        if (this.mc._t.isInsideOfMaterial(Material._h)) {
            this.renderWarpedTextureOverlay(f);
        }
        GL11.glEnable(3008);
    }

    public void renderInsideOfBlock(float f, Icon icon) {
        boolean bl = GloomyHooks.renderInsideOfBlock(this, f, icon);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        this.mc._R()._a(sctd._c);
        Tessellator tessellator = Tessellator.instance;
        float f2 = 0.1f;
        GL11.glColor4f(f2, f2, f2, 0.5f);
        GL11.glPushMatrix();
        float f3 = -1.0f;
        float f4 = 1.0f;
        float f5 = -1.0f;
        float f6 = 1.0f;
        float f7 = -0.5f;
        float f8 = icon.getMinU();
        float f9 = icon.getMaxU();
        float f10 = icon.getMinV();
        float f11 = icon.getMaxV();
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(f3, f5, f7, f9, f11);
        tessellator.addVertexWithUV(f4, f5, f7, f8, f11);
        tessellator.addVertexWithUV(f4, f6, f7, f8, f10);
        tessellator.addVertexWithUV(f3, f6, f7, f9, f10);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void renderWarpedTextureOverlay(float f) {
        this.mc._R()._a(RES_UNDERWATER_OVERLAY);
        Tessellator tessellator = Tessellator.instance;
        float f2 = this.mc._t.getBrightness(f);
        GL11.glColor4f(f2, f2, f2, 0.5f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glPushMatrix();
        float f3 = 4.0f;
        float f4 = -1.0f;
        float f5 = 1.0f;
        float f6 = -1.0f;
        float f7 = 1.0f;
        float f8 = -0.5f;
        float f9 = -this.mc._t.rotationYaw / 64.0f;
        float f10 = this.mc._t.rotationPitch / 64.0f;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(f4, f6, f8, f3 + f9, f3 + f10);
        tessellator.addVertexWithUV(f5, f6, f8, 0.0f + f9, f3 + f10);
        tessellator.addVertexWithUV(f5, f7, f8, 0.0f + f9, 0.0f + f10);
        tessellator.addVertexWithUV(f4, f7, f8, f3 + f9, 0.0f + f10);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
    }

    public void renderFireInFirstPerson(float f) {
        EntityRenderer cfr_ignored_0 = Minecraft._E()._D;
        EntityRenderer.enableTerrainShader(-1);
        Tessellator tessellator = Tessellator.instance;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.9f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        float f2 = 1.0f;
        for (int i = 0; i < 2; ++i) {
            GL11.glPushMatrix();
            Icon icon = Block.fire._a(1);
            this.mc._R()._a(sctd._c);
            float f3 = icon.getMinU();
            float f4 = icon.getMaxU();
            float f5 = icon.getMinV();
            float f6 = icon.getMaxV();
            float f7 = (0.0f - f2) / 2.0f;
            float f8 = f7 + f2;
            float f9 = 0.0f - f2 / 2.0f;
            float f10 = f9 + f2;
            float f11 = -0.5f;
            GL11.glTranslatef((float)(-(i * 2 - 1)) * 0.24f, -0.3f, 0.0f);
            GL11.glRotatef((float)(i * 2 - 1) * 10.0f, 0.0f, 1.0f, 0.0f);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(f7, f9, f11, f4, f6);
            tessellator.addVertexWithUV(f8, f9, f11, f3, f6);
            tessellator.addVertexWithUV(f8, f10, f11, f3, f5);
            tessellator.addVertexWithUV(f7, f10, f11, f4, f5);
            tessellator.draw();
            GL11.glPopMatrix();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        Minecraft minecraft = Minecraft._E();
        minecraft._D.disableTerrainShader();
    }

    public void updateEquippedItem() {
        float f;
        float f2;
        float f3;
        boolean bl;
        if (GloomyHooks.onUpdateEquippedItem(this)) {
            return;
        }
        this.prevEquippedProgress = this.equippedProgress;
        EntityClientPlayerMP entityClientPlayerMP = this.mc._t;
        ItemStack itemStack = entityClientPlayerMP.inventory._a();
        boolean bl2 = bl = this.equippedItemSlot == entityClientPlayerMP.inventory._c && itemStack == this.itemToRender;
        if (this.itemToRender == null && itemStack == null) {
            bl = true;
        }
        if (itemStack != null && this.itemToRender != null && itemStack != this.itemToRender && itemStack._d == this.itemToRender._d && itemStack._j() == this.itemToRender._j()) {
            this.itemToRender = itemStack;
            bl = true;
        }
        if ((f3 = (f2 = bl ? 1.0f : 0.0f) - this.equippedProgress) < -(f = 0.4f)) {
            f3 = -f;
        }
        if (f3 > f) {
            f3 = f;
        }
        this.equippedProgress += f3;
        if (this.equippedProgress < 0.1f) {
            this.itemToRender = itemStack;
            this.equippedItemSlot = entityClientPlayerMP.inventory._c;
        }
    }

    public void resetEquippedProgress() {
        this.equippedProgress = 0.0f;
    }

    public void resetEquippedProgress2() {
        this.equippedProgress = 0.0f;
    }
}

