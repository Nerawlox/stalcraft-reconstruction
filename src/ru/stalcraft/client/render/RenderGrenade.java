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
import ru.stalcraft.entity.EntityGrenade;

public class RenderGrenade
extends bgm {
    private HashMap models = new HashMap();

    public void doRenderGrenade(EntityGrenade entity, double par2, double par4, double par6, float par8, float frame) {
        GL11.glPushMatrix();
        try {
            IModelCustom e2;
            GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
            atv.w().N.a(new bjo("stalker", "models/" + entity.textureName + ".png"));
            GL11.glRotatef((float)(-entity.A), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(entity.D + (entity.B - entity.D) * frame), (float)0.0f, (float)0.0f, (float)1.0f);
            if (this.models.containsKey(entity.modelName)) {
                e2 = (IModelCustom)this.models.get(entity.modelName);
            } else {
                e2 = AdvancedModelLoader.loadModel((String)("/assets/stalker/models/" + entity.modelName));
                this.models.put(entity.modelName, e2);
            }
            e2.renderAll();
        }
        catch (Exception exception) {
            // empty catch block
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
        this.doRenderGrenade((EntityGrenade)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn entity) {
        return null;
    }
}

