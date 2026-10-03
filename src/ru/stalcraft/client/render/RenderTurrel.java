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
import ru.stalcraft.client.render.RenderUtils;
import ru.stalcraft.entity.EntityTurrel;

public class RenderTurrel
extends bgm {
    private IModelCustom model;
    private bjo texture;
    private float scale;

    public RenderTurrel(String modelName, String textureName, float scale) {
        this.model = AdvancedModelLoader.loadModel((String)("/assets/stalker/models/" + modelName + ".obj"));
        this.texture = new bjo("stalker", "models/" + textureName + ".png");
        this.scale = scale;
    }

    public void doRenderTurrel(EntityTurrel entity, double xPos, double yPos, double zPos, float par8, float frame) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
        atv.w().N.a(this.texture);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)xPos), (float)((float)yPos), (float)((float)zPos));
        GL11.glRotatef((float)(180.0f - RenderUtils.interpolateRotation(entity.C, entity.A, frame)), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
        this.model.renderPart("bashnya");
        GL11.glTranslatef((float)0.0f, (float)(entity.f() / this.scale), (float)(-entity.getRotationPointZ() / this.scale));
        float angle = -RenderUtils.interpolateRotation(entity.D, entity.B, frame);
        GL11.glRotatef((float)angle, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)(-entity.f() / this.scale), (float)(entity.getRotationPointZ() / this.scale));
        this.model.renderPart("stvol");
        angle = RenderUtils.interpolateRotation(entity.prevGunRoll, entity.gunRoll, frame);
        GL11.glTranslatef((float)0.0f, (float)(entity.f() / this.scale), (float)(-entity.getRotationPointZ() / this.scale));
        GL11.glRotatef((float)angle, (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glTranslatef((float)0.0f, (float)(-entity.f() / this.scale), (float)(entity.getRotationPointZ() / this.scale));
        this.model.renderPart("rotating");
        GL11.glPopMatrix();
        GL11.glEnable((int)2896);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.doRenderTurrel((EntityTurrel)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn entity) {
        return null;
    }
}

