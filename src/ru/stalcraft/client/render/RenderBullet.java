/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  net.minecraftforge.client.model.AdvancedModelLoader
 *  net.minecraftforge.client.model.IModelCustom
 */
package ru.stalcraft.client.render;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ru.stalcraft.entity.EntityBullet;

public class RenderBullet
extends bgm {
    private static IModelCustom model = AdvancedModelLoader.loadModel((String)"/assets/stalker/models/bullet.obj");
    private static bjo texture = new bjo("stalker", "models/bullet.png");

    public void doRenderBullet(EntityBullet bullet, double par2, double par4, double par6, float par8, float frame) {
    }

    private float angle(float angle) {
        if ((angle %= 360.0f) > 180.0f) {
            angle += -360.0f;
        }
        return angle;
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.doRenderBullet((EntityBullet)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn entity) {
        return null;
    }
}

