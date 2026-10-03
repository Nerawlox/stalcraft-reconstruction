/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.lang.reflect.Field;
import mcoptifine.Config;
import mcoptifine.Reflector;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ItemRendererOF
extends ItemRenderer {
    private Minecraft mc = null;
    private RenderBlocks renderBlocksInstance = null;
    private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    private static Field ItemRenderer_renderBlockInstance = Reflector.getFieldByType(ItemRenderer.class, RenderBlocks.class);

    public ItemRendererOF(Minecraft minecraft) {
        super(minecraft);
        this.mc = minecraft;
        if (ItemRenderer_renderBlockInstance == null) {
            Config.error("ItemRenderOF not initialized");
        }
        try {
            this.renderBlocksInstance = (RenderBlocks)ItemRenderer_renderBlockInstance.get(this);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    @Override
    public void renderItem(EntityLivingBase entityLivingBase, ItemStack itemStack, int n) {
        GL11.glPushMatrix();
        TextureManager textureManager = this.mc._R();
        boolean bl = Reflector.MinecraftForgeClient.exists();
        Block block = null;
        if (itemStack._a() instanceof ItemBlock && itemStack._d < Block.blocksList.length) {
            block = Block.blocksList[itemStack._d];
        }
        Object object = null;
        Object object2 = null;
        if (bl) {
            object = Reflector.getFieldValue(Reflector.ItemRenderType_EQUIPPED);
            object2 = Reflector.call(Reflector.MinecraftForgeClient_getItemRenderer, itemStack, object);
        }
        if (object2 != null) {
            textureManager._a(textureManager._a(itemStack._c()));
            Reflector.callVoid(Reflector.ForgeHooksClient_renderEquippedItem, object, object2, this.renderBlocksInstance, entityLivingBase, itemStack);
        } else if (block != null && itemStack._c() == 0 && RenderBlocks._a(block.getRenderType())) {
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
            ItemRendererOF.renderItemIn2D(tessellator, f2, f3, f, f4, icon.getIconWidth(), icon.getIconHeight(), 0.0625f);
            boolean bl2 = false;
            if (Reflector.ForgeItemStack_hasEffect.exists()) {
                bl2 = Reflector.callBoolean(Reflector.ForgeItemStack_hasEffect, n);
            } else {
                boolean bl3 = bl2 = itemStack._v() && n == 0;
            }
            if (bl2) {
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
                ItemRendererOF.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 16, 16, 0.0625f);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f9, f9, f9);
                f10 = (float)(Minecraft._M() % 4873L) / 4873.0f * 8.0f;
                GL11.glTranslatef(-f10, 0.0f, 0.0f);
                GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                ItemRendererOF.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 16, 16, 0.0625f);
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
}

