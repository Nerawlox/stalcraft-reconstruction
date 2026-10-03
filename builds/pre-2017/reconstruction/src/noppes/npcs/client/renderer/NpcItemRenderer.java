/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import gloomyfolken.mods.asm.ItemAtlasHooks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import noppes.npcs.items.ItemRenderInterface;
import org.lwjgl.opengl.GL11;

public class NpcItemRenderer
implements IItemRenderer {
    private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");

    @Override
    public boolean handleRenderType(ItemStack itemStack, IItemRenderer.ItemRenderType itemRenderType) {
        return itemRenderType == IItemRenderer.ItemRenderType.EQUIPPED;
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, IItemRenderer.ItemRendererHelper itemRendererHelper) {
        return false;
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, Object ... objectArray) {
        if (itemStack._a() instanceof ItemRenderInterface) {
            GL11.glTranslatef(0.9375f, 0.0625f, 0.0f);
            GL11.glRotatef(-335.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            ((ItemRenderInterface)((Object)itemStack._a())).renderSpecial();
            this.renderItem3d((EntityLivingBase)objectArray[1], itemStack);
        }
    }

    public void renderItem3d(EntityLivingBase entityLivingBase, ItemStack itemStack) {
        Minecraft minecraft = Minecraft._E();
        TextureManager textureManager = minecraft._R();
        int n = 0;
        Tessellator tessellator = Tessellator.instance;
        Icon icon = entityLivingBase.getItemIcon(itemStack, n);
        if (icon != null) {
            ItemAtlasHooks.bindItemTexture(icon, 0.0f);
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
    }
}

