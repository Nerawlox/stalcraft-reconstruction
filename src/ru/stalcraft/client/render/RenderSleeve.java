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

import java.util.HashMap;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.entity.EntitySleeve;

public class RenderSleeve
extends bgm {
    private static HashMap models = new HashMap();

    public void doRenderSleeve(EntitySleeve entity, double par2, double par4, double par6, float par8, float frame) {
        if (entity.model != null) {
            GL11.glPushMatrix();
            try {
                IModelCustom e2;
                if (entity.renderOnGround) {
                    par4 += 0.03;
                }
                GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
                GL11.glDisable((int)2884);
                atv.w().N.a(entity.texture);
                if (!models.containsKey(entity.model)) {
                    models.put(entity.model, null);
                    models.put(entity.model, AdvancedModelLoader.loadModel((String)("/assets/stalker/models/sleeves/" + entity.model + ".obj")));
                }
                if ((e2 = (IModelCustom)models.get(entity.model)) != null) {
                    GL11.glRotatef((float)this.angle(entity.xRotation + entity.xRotationSpeed * frame), (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)this.angle(entity.yRotation + entity.yRotationSpeed * frame), (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)this.angle(entity.zRotation + entity.zRotationSpeed * frame), (float)0.0f, (float)0.0f, (float)1.0f);
                    e2.renderAll();
                }
                GL11.glEnable((int)2884);
            }
            catch (Exception var11) {
                var11.printStackTrace();
            }
            GL11.glPopMatrix();
        }
    }

    private float angle(float angle) {
        if ((angle %= 360.0f) > 180.0f) {
            angle += -360.0f;
        }
        return angle;
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.doRenderSleeve((EntitySleeve)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn entity) {
        return null;
    }
}

