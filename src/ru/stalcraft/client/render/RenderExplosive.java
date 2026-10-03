/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  net.minecraftforge.client.model.AdvancedModelLoader
 *  net.minecraftforge.client.model.IModelCustom
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.entity.EntityExplosive;

public class RenderExplosive
extends bgm {
    private static IModelCustom model = AdvancedModelLoader.loadModel((String)"/assets/stalker/models/explosive.obj");
    private static bjo texture = new bjo("stalker", "models/explosive.png");

    public void doRenderExplosive(EntityExplosive explosive, double par2, double par4, double par6, float par8, float frame) {
        GL11.glPushMatrix();
        try {
            GL11.glTranslatef((float)((float)par2 + 0.0125f), (float)((float)par4 + 0.0125f), (float)((float)par6 + 0.0125f));
            atv.w().N.a(texture);
            GL11.glScalef((float)1.0E-4f, (float)1.0E-4f, (float)1.0E-4f);
            int e2 = explosive.getSidePlaced();
            if (e2 != 2 && e2 != 3) {
                if (e2 == 4 || e2 == 5) {
                    GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                }
            } else {
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            }
            model.renderAll();
        }
        catch (Exception var11) {
            var11.printStackTrace();
        }
        GL11.glPopMatrix();
    }

    private float angle(float angle) {
        if ((angle %= 360.0f) > 180.0f) {
            angle += -360.0f;
        }
        return angle;
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.doRenderExplosive((EntityExplosive)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn entity) {
        return null;
    }
}

