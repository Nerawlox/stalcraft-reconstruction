/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.ItemAtlasHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderItem
extends Render {
    public static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    public RenderBlocks itemRenderBlocks = new RenderBlocks();
    public Random random = new Random();
    public boolean renderWithColor = true;
    public float zLevel;
    public static boolean renderInFrame;

    public RenderItem() {
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }

    public void doRenderItem(EntityItem entityItem, double d, double d2, double d3, float f, float f2) {
        this.bindEntityTexture(entityItem);
        this.random.setSeed(187L);
        ItemStack itemStack = entityItem.getEntityItem();
        if (itemStack._a() != null) {
            GL11.glPushMatrix();
            float f3 = this.shouldBob() ? sajh._a(((float)entityItem.age + f2) / 10.0f + entityItem.hoverStart) * 0.1f + 0.1f : 0.0f;
            float f4 = (((float)entityItem.age + f2) / 20.0f + entityItem.hoverStart) * 57.295776f;
            int n = this.getMiniBlockCount(itemStack);
            GL11.glTranslatef((float)d, (float)d2 + f3, (float)d3);
            GL11.glEnable(32826);
            Block block = null;
            if (itemStack._d < Block.blocksList.length) {
                block = Block.blocksList[itemStack._d];
            }
            if (!ForgeHooksClient.renderEntityItem(entityItem, itemStack, f3, f4, this.random, this.renderManager._g, this.renderBlocks)) {
                if (itemStack._c() == 0 && block != null && RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType())) {
                    qlgf._a(f4, 0.0f, 1.0f, 0.0f);
                    if (renderInFrame) {
                        GL11.glScalef(1.25f, 1.25f, 1.25f);
                        GL11.glTranslatef(0.0f, 0.05f, 0.0f);
                        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                    }
                    float f5 = 0.25f;
                    int n2 = block.getRenderType();
                    if (n2 == 1 || n2 == 19 || n2 == 12 || n2 == 2) {
                        f5 = 0.5f;
                    }
                    GL11.glScalef(f5, f5, f5);
                    for (int i = 0; i < n; ++i) {
                        float f6;
                        GL11.glPushMatrix();
                        if (i > 0) {
                            f6 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.2f / f5;
                            float f7 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.2f / f5;
                            float f8 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.2f / f5;
                            qlgf._a(f6, f7, f8);
                        }
                        f6 = 1.0f;
                        this.itemRenderBlocks._a(block, itemStack._j(), f6);
                        GL11.glPopMatrix();
                    }
                } else if (itemStack._a().requiresMultipleRenderPasses()) {
                    if (renderInFrame) {
                        GL11.glScalef(0.5128205f, 0.5128205f, 0.5128205f);
                        GL11.glTranslatef(0.0f, -0.05f, 0.0f);
                    } else {
                        GL11.glScalef(0.5f, 0.5f, 0.5f);
                    }
                    for (int i = 0; i < itemStack._a().getRenderPasses(itemStack._j()); ++i) {
                        this.random.setSeed(187L);
                        Icon icon = itemStack._a().getIcon(itemStack, i);
                        float f9 = 1.0f;
                        if (this.renderWithColor) {
                            int n3 = Item.itemsList[itemStack._d].getColorFromItemStack(itemStack, i);
                            float f10 = (float)(n3 >> 16 & 0xFF) / 255.0f;
                            float f11 = (float)(n3 >> 8 & 0xFF) / 255.0f;
                            float f12 = (float)(n3 & 0xFF) / 255.0f;
                            GL11.glColor4f(f10 * f9, f11 * f9, f12 * f9, 1.0f);
                            this.renderDroppedItem(entityItem, icon, n, f2, f10 * f9, f11 * f9, f12 * f9);
                            continue;
                        }
                        this.renderDroppedItem(entityItem, icon, n, f2, 1.0f, 1.0f, 1.0f);
                    }
                } else {
                    if (renderInFrame) {
                        GL11.glScalef(0.5128205f, 0.5128205f, 0.5128205f);
                        GL11.glTranslatef(0.0f, -0.05f, 0.0f);
                    } else {
                        GL11.glScalef(0.5f, 0.5f, 0.5f);
                    }
                    Icon icon = itemStack._b();
                    if (this.renderWithColor) {
                        int n4 = Item.itemsList[itemStack._d].getColorFromItemStack(itemStack, 0);
                        float f13 = (float)(n4 >> 16 & 0xFF) / 255.0f;
                        float f14 = (float)(n4 >> 8 & 0xFF) / 255.0f;
                        float f15 = (float)(n4 & 0xFF) / 255.0f;
                        float f16 = 1.0f;
                        this.renderDroppedItem(entityItem, icon, n, f2, f13 * f16, f14 * f16, f15 * f16);
                    } else {
                        this.renderDroppedItem(entityItem, icon, n, f2, 1.0f, 1.0f, 1.0f);
                    }
                }
            }
            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }
    }

    public ResourceLocation func_110796_a(EntityItem entityItem) {
        return this.renderManager._g._a(entityItem.getEntityItem()._c());
    }

    public void renderDroppedItem(EntityItem entityItem, Icon icon, int n, float f, float f2, float f3, float f4) {
        this.renderDroppedItem(entityItem, icon, n, f, f2, f3, f4, 0);
    }

    public void renderDroppedItem(EntityItem entityItem, Icon icon, int n, float f, float f2, float f3, float f4, int n2) {
        ItemAtlasHooks.renderDroppedItem(this, entityItem, icon, n, f, f2, f3, f4, n2);
        qlgf._b(entityItem);
        Tessellator tessellator = Tessellator.instance;
        if (icon == null) {
            TextureManager textureManager = Minecraft._E()._R();
            ResourceLocation resourceLocation = textureManager._a(entityItem.getEntityItem()._c());
            icon = ((sctd)textureManager._b(resourceLocation))._d("missingno");
        }
        float f5 = icon.getMinU();
        float f6 = icon.getMaxU();
        float f7 = icon.getMinV();
        float f8 = icon.getMaxV();
        float f9 = 1.0f;
        float f10 = 0.5f;
        float f11 = 0.25f;
        if (this.renderManager._n.fancyGraphics) {
            GL11.glPushMatrix();
            if (renderInFrame) {
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            } else {
                qlgf._a((((float)entityItem.age + f) / 20.0f + entityItem.hoverStart) * 57.295776f, 0.0f, 1.0f, 0.0f);
            }
            float f12 = 0.0625f;
            float f13 = 0.021875f;
            ItemStack itemStack = entityItem.getEntityItem();
            int n3 = itemStack._b;
            int n4 = this.getMiniItemCount(itemStack);
            GL11.glTranslatef(-f10, -f11, -((f12 + f13) * (float)n4 / 2.0f));
            for (int i = 0; i < n4; ++i) {
                float f14;
                float f15;
                float f16;
                if (i > 0 && this.shouldSpreadItems()) {
                    f16 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                    f15 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                    f14 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                    GL11.glTranslatef(f16, f15, f12 + f13);
                } else {
                    GL11.glTranslatef(0.0f, 0.0f, f12 + f13);
                }
                if (itemStack._c() == 0) {
                    this.bindTexture(sctd._c);
                } else {
                    this.bindTexture(sctd._e);
                }
                GL11.glColor4f(f2, f3, f4, 1.0f);
                ItemRenderer.renderItemIn2D(tessellator, f6, f7, f5, f8, icon.getIconWidth(), icon.getIconHeight(), f12);
                if (!itemStack._c(n2)) continue;
                GL11.glDepthFunc(514);
                GL11.glDisable(2896);
                this.renderManager._g._a(RES_ITEM_GLINT);
                GL11.glEnable(3042);
                GL11.glBlendFunc(768, 1);
                f16 = 0.76f;
                GL11.glColor4f(0.5f * f16, 0.25f * f16, 0.8f * f16, 1.0f);
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                f15 = 0.125f;
                GL11.glScalef(f15, f15, f15);
                f14 = (float)(Minecraft._M() % 3000L) / 3000.0f * 8.0f;
                GL11.glTranslatef(f14, 0.0f, 0.0f);
                GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
                ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, f12);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f15, f15, f15);
                f14 = (float)(Minecraft._M() % 4873L) / 4873.0f * 8.0f;
                GL11.glTranslatef(-f14, 0.0f, 0.0f);
                GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, f12);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
                GL11.glDisable(3042);
                GL11.glEnable(2896);
                GL11.glDepthFunc(515);
            }
            GL11.glPopMatrix();
        } else {
            for (int i = 0; i < n; ++i) {
                GL11.glPushMatrix();
                if (i > 0) {
                    float f17 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    float f18 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    float f19 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    GL11.glTranslatef(f17, f18, f19);
                }
                if (!renderInFrame) {
                    GL11.glRotatef(180.0f - this.renderManager._l, 0.0f, 1.0f, 0.0f);
                }
                GL11.glColor4f(f2, f3, f4, 1.0f);
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 1.0f, 0.0f);
                tessellator.addVertexWithUV(0.0f - f10, 0.0f - f11, 0.0, f5, f8);
                tessellator.addVertexWithUV(f9 - f10, 0.0f - f11, 0.0, f6, f8);
                tessellator.addVertexWithUV(f9 - f10, 1.0f - f11, 0.0, f6, f7);
                tessellator.addVertexWithUV(0.0f - f10, 1.0f - f11, 0.0, f5, f7);
                tessellator.draw();
                GL11.glPopMatrix();
            }
        }
        qlgf._c(entityItem);
    }

    public void renderItemIntoGUI(FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int n, int n2) {
        this.renderItemIntoGUI(fontRenderer, textureManager, itemStack, n, n2, false);
    }

    public void renderItemIntoGUI(FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int n, int n2, boolean bl) {
        Block block;
        qlgf._a(this, fontRenderer, textureManager, itemStack, n, n2, bl);
        ItemAtlasHooks.renderItemIntoGUI(this, fontRenderer, textureManager, itemStack, n, n2, bl);
        int n3 = itemStack._d;
        int n4 = itemStack._j();
        Icon icon = itemStack._b();
        Block block2 = block = n3 < Block.blocksList.length ? Block.blocksList[n3] : null;
        if (itemStack._c() == 0 && block != null && RenderBlocks._a(Block.blocksList[n3].getRenderType())) {
            textureManager._a(sctd._c);
            GL11.glPushMatrix();
            GL11.glTranslatef(n - 2, n2 + 3, -3.0f + this.zLevel);
            GL11.glScalef(10.0f, 10.0f, 10.0f);
            GL11.glTranslatef(1.0f, 0.5f, 1.0f);
            GL11.glScalef(1.0f, 1.0f, -1.0f);
            GL11.glRotatef(210.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            int n5 = Item.itemsList[n3].getColorFromItemStack(itemStack, 0);
            float f = (float)(n5 >> 16 & 0xFF) / 255.0f;
            float f2 = (float)(n5 >> 8 & 0xFF) / 255.0f;
            float f3 = (float)(n5 & 0xFF) / 255.0f;
            if (this.renderWithColor) {
                GL11.glColor4f(f, f2, f3, 1.0f);
            }
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            this.itemRenderBlocks._g = this.renderWithColor;
            this.itemRenderBlocks._a(block, n4, 1.0f);
            this.itemRenderBlocks._g = true;
            GL11.glPopMatrix();
        } else if (Item.itemsList[n3].requiresMultipleRenderPasses()) {
            GL11.glDisable(2896);
            for (int i = 0; i < Item.itemsList[n3].getRenderPasses(n4); ++i) {
                textureManager._a(itemStack._c() == 0 ? sctd._c : sctd._e);
                Icon icon2 = Item.itemsList[n3].getIcon(itemStack, i);
                int n6 = Item.itemsList[n3].getColorFromItemStack(itemStack, i);
                float f = (float)(n6 >> 16 & 0xFF) / 255.0f;
                float f4 = (float)(n6 >> 8 & 0xFF) / 255.0f;
                float f5 = (float)(n6 & 0xFF) / 255.0f;
                if (this.renderWithColor) {
                    GL11.glColor4f(f, f4, f5, 1.0f);
                }
                this.renderIcon(n, n2, icon2, 16, 16);
                if (!itemStack._c(i)) continue;
                this.renderEffect(textureManager, n, n2);
            }
            GL11.glEnable(2896);
        } else {
            GL11.glDisable(2896);
            ResourceLocation resourceLocation = textureManager._a(itemStack._c());
            textureManager._a(resourceLocation);
            if (icon == null) {
                icon = ((sctd)Minecraft._E()._R()._b(resourceLocation))._d("missingno");
            }
            int n7 = Item.itemsList[n3].getColorFromItemStack(itemStack, 0);
            float f = (float)(n7 >> 16 & 0xFF) / 255.0f;
            float f6 = (float)(n7 >> 8 & 0xFF) / 255.0f;
            float f7 = (float)(n7 & 0xFF) / 255.0f;
            if (this.renderWithColor) {
                GL11.glColor4f(f, f6, f7, 1.0f);
            }
            this.renderIcon(n, n2, icon, 16, 16);
            GL11.glEnable(2896);
            if (itemStack._c(0)) {
                this.renderEffect(textureManager, n, n2);
            }
        }
        GL11.glEnable(2884);
        qlgf._b(this, fontRenderer, textureManager, itemStack, n, n2, bl);
    }

    public void renderEffect(TextureManager textureManager, int n, int n2) {
        GL11.glDepthFunc(516);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        textureManager._a(RES_ITEM_GLINT);
        this.zLevel -= 50.0f;
        GL11.glEnable(3042);
        GL11.glBlendFunc(774, 774);
        GL11.glColor4f(0.5f, 0.25f, 0.8f, 1.0f);
        this.renderGlint(n * 431278612 + n2 * 32178161, n - 2, n2 - 2, 20, 20);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        this.zLevel += 50.0f;
        GL11.glEnable(2896);
        GL11.glDepthFunc(515);
    }

    public void renderItemAndEffectIntoGUI(FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int n, int n2) {
        if (itemStack != null && !ForgeHooksClient.renderInventoryItem(this.renderBlocks, textureManager, itemStack, this.renderWithColor, this.zLevel, n, n2)) {
            this.renderItemIntoGUI(fontRenderer, textureManager, itemStack, n, n2, true);
        }
    }

    public void renderGlint(int n, int n2, int n3, int n4, int n5) {
        for (int i = 0; i < 2; ++i) {
            if (i == 0) {
                GL11.glBlendFunc(768, 1);
            }
            if (i == 1) {
                GL11.glBlendFunc(768, 1);
            }
            float f = 0.00390625f;
            float f2 = 0.00390625f;
            float f3 = (float)(Minecraft._M() % (long)(3000 + i * 1873)) / (3000.0f + (float)(i * 1873)) * 256.0f;
            float f4 = 0.0f;
            Tessellator tessellator = Tessellator.instance;
            float f5 = 4.0f;
            if (i == 1) {
                f5 = -1.0f;
            }
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(n2 + 0, n3 + n5, this.zLevel, (f3 + (float)n5 * f5) * f, (f4 + (float)n5) * f2);
            tessellator.addVertexWithUV(n2 + n4, n3 + n5, this.zLevel, (f3 + (float)n4 + (float)n5 * f5) * f, (f4 + (float)n5) * f2);
            tessellator.addVertexWithUV(n2 + n4, n3 + 0, this.zLevel, (f3 + (float)n4) * f, (f4 + 0.0f) * f2);
            tessellator.addVertexWithUV(n2 + 0, n3 + 0, this.zLevel, (f3 + 0.0f) * f, (f4 + 0.0f) * f2);
            tessellator.draw();
        }
    }

    public void renderItemOverlayIntoGUI(FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int n, int n2) {
        this.renderItemOverlayIntoGUI(fontRenderer, textureManager, itemStack, n, n2, null);
    }

    public void renderItemOverlayIntoGUI(FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int n, int n2, String string) {
        if (itemStack != null) {
            if (itemStack._b > 1 || string != null) {
                String string2 = string == null ? String.valueOf(itemStack._b) : string;
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                fontRenderer._a(string2, n + 19 - 2 - fontRenderer._b(string2), n2 + 6 + 3, 0xFFFFFF);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
            }
            if (itemStack._h()) {
                int n3 = (int)Math.round(13.0 - (double)itemStack._i() * 13.0 / (double)itemStack._k());
                int n4 = (int)Math.round(255.0 - (double)itemStack._i() * 255.0 / (double)itemStack._k());
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                GL11.glDisable(3553);
                Tessellator tessellator = Tessellator.instance;
                int n5 = 255 - n4 << 16 | n4 << 8;
                int n6 = (255 - n4) / 4 << 16 | 0x3F00;
                this.renderQuad(tessellator, n + 2, n2 + 13, 13, 2, 0);
                this.renderQuad(tessellator, n + 2, n2 + 13, 12, 1, n6);
                this.renderQuad(tessellator, n + 2, n2 + 13, n3, 1, n5);
                GL11.glEnable(3553);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    public void renderQuad(Tessellator tessellator, int n, int n2, int n3, int n4, int n5) {
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(n5);
        tessellator.addVertex(n + 0, n2 + 0, 0.0);
        tessellator.addVertex(n + 0, n2 + n4, 0.0);
        tessellator.addVertex(n + n3, n2 + n4, 0.0);
        tessellator.addVertex(n + n3, n2 + 0, 0.0);
        tessellator.draw();
    }

    public void renderIcon(int n, int n2, Icon icon, int n3, int n4) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(n + 0, n2 + n4, this.zLevel, icon.getMinU(), icon.getMaxV());
        tessellator.addVertexWithUV(n + n3, n2 + n4, this.zLevel, icon.getMaxU(), icon.getMaxV());
        tessellator.addVertexWithUV(n + n3, n2 + 0, this.zLevel, icon.getMaxU(), icon.getMinV());
        tessellator.addVertexWithUV(n + 0, n2 + 0, this.zLevel, icon.getMinU(), icon.getMinV());
        tessellator.draw();
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        return this.func_110796_a((EntityItem)entity);
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.doRenderItem((EntityItem)entity, d, d2, d3, f, f2);
    }

    public boolean shouldSpreadItems() {
        return true;
    }

    public boolean shouldBob() {
        return !qlgf._a();
    }

    public byte getMiniBlockCount(ItemStack itemStack) {
        byte by = 1;
        if (itemStack._b > 1) {
            by = 2;
        }
        if (itemStack._b > 5) {
            by = 3;
        }
        if (itemStack._b > 20) {
            by = 4;
        }
        if (itemStack._b > 40) {
            by = 5;
        }
        return by;
    }

    public byte getMiniItemCount(ItemStack itemStack) {
        byte by = 1;
        if (itemStack._b > 1) {
            by = 2;
        }
        if (itemStack._b > 15) {
            by = 3;
        }
        if (itemStack._b > 31) {
            by = 4;
        }
        return by;
    }
}

