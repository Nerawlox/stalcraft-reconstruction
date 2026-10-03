/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  beu
 *  bjo
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.IItemRenderer$ItemRenderType
 *  net.minecraftforge.client.IItemRenderer$ItemRendererHelper
 *  net.minecraftforge.client.model.IModelCustom
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.loaders.StalkerModelManager;
import ru.stalcraft.client.models.ModelHand;

public class RenderFlashlight
implements IItemRenderer {
    private static atv mc = atv.w();
    private String modelName = "flashlight.obj";
    private bjo texture = new bjo("stalker", "models/items/flashlight.png");
    protected ModelHand hand = new ModelHand();
    private static float[] fpTransform = new float[]{-0.355f, -0.06f, 0.234f, -0.6f, -15.4f, -3.85f};
    private static float[] playerTransform = new float[]{0.66f, 1.3f, 0.78f, -76.8f, 14.1f, 45.3f};
    private static float[] oldLivingTransform = new float[]{-0.49f, 1.08f, 0.57f, 29.0f, 233.7f, 33.6f};
    private static float[] newLivingTransform = new float[]{0.23f, 0.84f, 0.76f, 9.1f, 316.6f, 0.0f};
    private float aimPosY;
    private float aimPosZ;
    private float aimRotX;
    private float posX = 0.0f;
    private float posY = 0.0f;
    private float posZ = 0.0f;

    public boolean handleRenderType(ye item, IItemRenderer.ItemRenderType type) {
        return type != IItemRenderer.ItemRenderType.ENTITY && type != IItemRenderer.ItemRenderType.INVENTORY && (type != IItemRenderer.ItemRenderType.EQUIPPED || GuiSettingsStalker.useWeaponModels);
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ye item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    private void renderModel(ye stack) {
        StalkerModelManager m2 = ClientProxy.modelManager;
        m2.tryLoadTexture(this.texture);
        IModelCustom model = m2.getModel("items", this.modelName);
        if (model != null && m2.tryBindTexture(this.texture)) {
            model.renderAll();
        }
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ye item, Object ... data) {
        try {
            if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
                GL11.glTranslatef((float)fpTransform[0], (float)fpTransform[1], (float)fpTransform[2]);
                GL11.glRotatef((float)fpTransform[3], (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)fpTransform[4], (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)fpTransform[5], (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glPushMatrix();
                GL11.glRotatef((float)-33.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glTranslatef((float)(this.posX - 0.15f), (float)(this.posY + 1.325f), (float)(this.posZ + 0.95f));
                GL11.glScalef((float)3.0f, (float)3.0f, (float)3.0f);
                this.renderModel(item);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)0.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)-33.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)-0.3f, (float)-1.35f, (float)1.075f);
                this.hand.render((beu)RenderFlashlight.mc.h, 1);
                GL11.glPopMatrix();
            } else if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
                GL11.glPushMatrix();
                if (data[1] instanceof uf) {
                    GL11.glTranslatef((float)(playerTransform[0] - 0.05f), (float)(playerTransform[1] - 0.9f), (float)playerTransform[2]);
                    GL11.glRotatef((float)playerTransform[3], (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)playerTransform[4], (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)playerTransform[5], (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glScalef((float)4.0f, (float)4.0f, (float)4.0f);
                } else {
                    GL11.glTranslatef((float)(newLivingTransform[0] - 0.05f), (float)(newLivingTransform[1] - 0.9f), (float)newLivingTransform[2]);
                    GL11.glRotatef((float)newLivingTransform[3], (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)newLivingTransform[4], (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)newLivingTransform[5], (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
                }
                this.renderModel(item);
                GL11.glPopMatrix();
            }
        }
        catch (NullPointerException var5) {
            var5.printStackTrace();
        }
    }
}

