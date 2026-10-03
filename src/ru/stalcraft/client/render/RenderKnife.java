/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.IItemRenderer$ItemRenderType
 *  net.minecraftforge.client.IItemRenderer$ItemRendererHelper
 *  net.minecraftforge.client.model.AdvancedModelLoader
 *  net.minecraftforge.client.model.IModelCustom
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RenderKnife
implements IItemRenderer {
    private static atv mc = atv.w();
    private bjo texture = new bjo("stalker", "models/knife.png");
    protected IModelCustom model = AdvancedModelLoader.loadModel((String)"/assets/stalker/models/knife.obj");
    private static float[] pos = new float[]{0.66f, 1.3f, 0.78f, -76.8f, 14.1f, 45.3f};

    public boolean handleRenderType(ye item, IItemRenderer.ItemRenderType type) {
        return type != IItemRenderer.ItemRenderType.ENTITY && type != IItemRenderer.ItemRenderType.INVENTORY;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ye item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    private void renderModel() {
        RenderKnife.mc.N.a(this.texture);
        this.model.renderAll();
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ye item, Object ... data) {
        try {
            if (type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
                if (data[1] == RenderKnife.mc.h && RenderKnife.mc.u.aa == 0) {
                    GL11.glPushMatrix();
                    GL11.glRotatef((float)-33.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glTranslatef((float)0.2f, (float)1.475f, (float)1.05f);
                    GL11.glScalef((float)3.0f, (float)3.0f, (float)3.0f);
                    this.renderModel();
                    GL11.glPopMatrix();
                } else {
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)pos[0], (float)pos[1], (float)pos[2]);
                    GL11.glRotatef((float)pos[3], (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)pos[4], (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)pos[5], (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glScalef((float)4.0f, (float)4.0f, (float)4.0f);
                    this.renderModel();
                    GL11.glPopMatrix();
                }
            }
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
    }
}

