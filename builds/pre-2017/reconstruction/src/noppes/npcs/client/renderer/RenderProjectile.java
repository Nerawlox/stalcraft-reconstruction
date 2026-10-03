/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import noppes.npcs.client.ClientProxy;
import noppes.npcs.entity.EntityProjectile;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderProjectile
extends Render {
    private static final ResourceLocation arrowTextures = new ResourceLocation("textures/entity/arrow.png");
    private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    public boolean renderWithColor = true;
    private RenderBlocks itemRenderBlocks = new RenderBlocks();

    public void doRenderProjectile(EntityProjectile entityProjectile, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glEnable(32826);
        float f3 = (float)entityProjectile.getDataWatcher()._c(23) / 10.0f;
        ItemStack itemStack = entityProjectile.getItemDisplay();
        GL11.glScalef(f3, f3, f3);
        Tessellator tessellator = Tessellator.instance;
        if (entityProjectile.isArrow()) {
            this.bindEntityTexture(entityProjectile);
            GL11.glRotatef(entityProjectile.prevRotationYaw + (entityProjectile.rotationYaw - entityProjectile.prevRotationYaw) * f2 - 90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(entityProjectile.prevRotationPitch + (entityProjectile.rotationPitch - entityProjectile.prevRotationPitch) * f2, 0.0f, 0.0f, 1.0f);
            int n = 0;
            float f4 = 0.0f;
            float f5 = 0.5f;
            float f6 = (float)(0 + n * 10) / 32.0f;
            float f7 = (float)(5 + n * 10) / 32.0f;
            float f8 = 0.0f;
            float f9 = 0.15625f;
            float f10 = (float)(5 + n * 10) / 32.0f;
            float f11 = (float)(10 + n * 10) / 32.0f;
            float f12 = 0.05625f;
            GL11.glEnable(32826);
            float f13 = (float)entityProjectile.arrowShake - f2;
            if (f13 > 0.0f) {
                float f14 = -sajh._a(f13 * 3.0f) * f13;
                GL11.glRotatef(f14, 0.0f, 0.0f, 1.0f);
            }
            GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScalef(f12, f12, f12);
            GL11.glTranslatef(-4.0f, 0.0f, 0.0f);
            GL11.glNormal3f(f12, 0.0f, 0.0f);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-7.0, -2.0, -2.0, f8, f10);
            tessellator.addVertexWithUV(-7.0, -2.0, 2.0, f9, f10);
            tessellator.addVertexWithUV(-7.0, 2.0, 2.0, f9, f11);
            tessellator.addVertexWithUV(-7.0, 2.0, -2.0, f8, f11);
            tessellator.draw();
            GL11.glNormal3f(-f12, 0.0f, 0.0f);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-7.0, 2.0, -2.0, f8, f10);
            tessellator.addVertexWithUV(-7.0, 2.0, 2.0, f9, f10);
            tessellator.addVertexWithUV(-7.0, -2.0, 2.0, f9, f11);
            tessellator.addVertexWithUV(-7.0, -2.0, -2.0, f8, f11);
            tessellator.draw();
            for (int i = 0; i < 4; ++i) {
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glNormal3f(0.0f, 0.0f, f12);
                tessellator.startDrawingQuads();
                tessellator.addVertexWithUV(-8.0, -2.0, 0.0, f4, f6);
                tessellator.addVertexWithUV(8.0, -2.0, 0.0, f5, f6);
                tessellator.addVertexWithUV(8.0, 2.0, 0.0, f5, f7);
                tessellator.addVertexWithUV(-8.0, 2.0, 0.0, f4, f7);
                tessellator.draw();
            }
        } else if (entityProjectile.is3D()) {
            GL11.glRotatef(entityProjectile.prevRotationYaw + (entityProjectile.rotationYaw - entityProjectile.prevRotationYaw) * f2 - 90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(entityProjectile.prevRotationPitch + (entityProjectile.rotationPitch - entityProjectile.prevRotationPitch) * f2 - 180.0f, 0.0f, 0.0f, 1.0f);
            Block block = null;
            if (itemStack._d < Block.blocksList.length) {
                block = Block.blocksList[itemStack._d];
            }
            if (itemStack._c() == 0 && block != null && RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType())) {
                this.bindTexture(sctd._c);
                float f15 = 0.25f;
                int n = block.getRenderType();
                if (n == 1 || n == 19 || n == 12 || n == 2) {
                    f15 = 0.5f;
                }
                float f16 = 1.0f;
                this.renderBlocks._a(block, itemStack._j(), f16);
            } else if (itemStack._a().requiresMultipleRenderPasses()) {
                for (int i = 0; i < itemStack._a().getRenderPasses(itemStack._j()); ++i) {
                    itemStack._a().getIcon(itemStack, i);
                    float f17 = 1.0f;
                    if (this.renderWithColor) {
                        int n = Item.itemsList[itemStack._d].getColorFromItemStack(itemStack, i);
                        float f18 = (float)(n >> 16 & 0xFF) / 255.0f;
                        float f19 = (float)(n >> 8 & 0xFF) / 255.0f;
                        float f20 = (float)(n & 0xFF) / 255.0f;
                        GL11.glColor4f(f18 * f17, f19 * f17, f20 * f17, 1.0f);
                        this.renderManager._h.renderItem(Minecraft._E()._t, itemStack, 0);
                        continue;
                    }
                    this.renderManager._h.renderItem(Minecraft._E()._t, itemStack, 0);
                }
            } else {
                Icon icon = itemStack._b();
                if (this.renderWithColor) {
                    int n = Item.itemsList[itemStack._d].getColorFromItemStack(itemStack, 0);
                    float f21 = (float)(n >> 16 & 0xFF) / 255.0f;
                    float f22 = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f23 = (float)(n & 0xFF) / 255.0f;
                    float f24 = 1.0f;
                    this.renderDroppedItem(itemStack, icon, f2, f21 * f24, f22 * f24, f23 * f24, f3);
                } else {
                    this.renderDroppedItem(itemStack, icon, f2, 1.0f, 1.0f, 1.0f, f3);
                }
            }
        } else {
            float f25;
            float f26;
            int n;
            Icon icon = itemStack._b();
            this.bindTexture(sctd._e);
            if (itemStack._a().requiresMultipleRenderPasses()) {
                for (n = 0; n < itemStack._a().getRenderPasses(itemStack._j()); ++n) {
                    int n2 = Item.itemsList[itemStack._d].getColorFromItemStack(itemStack, n);
                    f26 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                    f25 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                    float f27 = (float)(n2 & 0xFF) / 255.0f;
                    GL11.glColor4f(f26, f25, f27, 1.0f);
                }
            }
            if (icon == ItemPotion._a("potion_splash")) {
                n = PotionHelper._a(itemStack._j(), false);
                float f28 = (float)(n >> 16 & 0xFF) / 255.0f;
                f26 = (float)(n >> 8 & 0xFF) / 255.0f;
                f25 = (float)(n & 0xFF) / 255.0f;
                GL11.glColor3f(f28, f26, f25);
                GL11.glPushMatrix();
                this.renderSprite(tessellator, ItemPotion._a("potion_contents"));
                GL11.glPopMatrix();
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
            }
            this.renderSprite(tessellator, icon);
        }
        if (entityProjectile.is3D() && entityProjectile.glows()) {
            GL11.glDisable(2896);
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        GL11.glEnable(2896);
    }

    private void renderSprite(Tessellator tessellator, Icon icon) {
        float f = icon.getMinU();
        float f2 = icon.getMaxU();
        float f3 = icon.getMinV();
        float f4 = icon.getMaxV();
        float f5 = 1.0f;
        float f6 = 0.5f;
        float f7 = 0.25f;
        GL11.glRotatef(180.0f - this.renderManager._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.renderManager._m, 1.0f, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.addVertexWithUV(0.0f - f6, 0.0f - f7, 0.0, f, f4);
        tessellator.addVertexWithUV(f5 - f6, 0.0f - f7, 0.0, f2, f4);
        tessellator.addVertexWithUV(f5 - f6, f5 - f7, 0.0, f2, f3);
        tessellator.addVertexWithUV(0.0f - f6, f5 - f7, 0.0, f, f3);
        tessellator.draw();
    }

    private void renderDroppedItem(ItemStack itemStack, Icon icon, float f, float f2, float f3, float f4, float f5) {
        Tessellator tessellator = Tessellator.instance;
        if (icon == null) {
            TextureManager textureManager = Minecraft._E()._R();
            ResourceLocation resourceLocation = textureManager._a(itemStack._c());
            icon = ((sctd)textureManager._b(resourceLocation))._b("missingno");
        }
        float f6 = icon.getMinU();
        float f7 = icon.getMaxU();
        float f8 = icon.getMinV();
        float f9 = icon.getMaxV();
        float f10 = 1.0f;
        float f11 = 0.5f;
        float f12 = 0.25f;
        float f13 = 0.0625f;
        if (itemStack._c() == 0) {
            this.bindTexture(sctd._c);
        } else {
            this.bindTexture(sctd._e);
        }
        GL11.glColor4f(f2, f3, f4, 1.0f);
        ItemRenderer.renderItemIn2D(tessellator, f7, f8, f6, f9, icon.getIconWidth(), icon.getIconHeight(), f13);
        if (itemStack != null && itemStack._c(0)) {
            GL11.glDepthFunc(514);
            GL11.glDisable(2896);
            ClientProxy.bindTexture(RES_ITEM_GLINT);
            GL11.glEnable(3042);
            GL11.glBlendFunc(768, 1);
            float f14 = 0.76f;
            GL11.glColor4f(0.5f * f14, 0.25f * f14, 0.8f * f14, 1.0f);
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            GL11.glScalef(f5, f5, f5);
            float f15 = (float)(Minecraft._M() % 3000L) / 3000.0f * 8.0f;
            GL11.glTranslatef(f15, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, f13);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f5, f5, f5);
            f15 = (float)(Minecraft._M() % 4873L) / 4873.0f * 8.0f;
            GL11.glTranslatef(-f15, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, f13);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
        }
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.doRenderProjectile((EntityProjectile)entity, d, d2, d3, f, f2);
    }

    protected ResourceLocation getArrowTextures(EntityProjectile entityProjectile) {
        return entityProjectile.isArrow() ? arrowTextures : this.renderManager._g._a(entityProjectile.getItemDisplay()._c());
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getArrowTextures((EntityProjectile)entity);
    }
}

