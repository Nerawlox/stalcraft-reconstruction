/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bje
 *  bjo
 *  net.minecraftforge.client.model.AdvancedModelLoader
 *  net.minecraftforge.client.model.IModelCustom
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.tile.TileEntityMachineGun;

public class RenderMachineGun
extends bje {
    private IModelCustom model = AdvancedModelLoader.loadModel((String)"/assets/stalker/models/machinegun.obj");
    private bjo texture = new bjo("stalker", "models/machinegun.png");

    public void a(asp tileentity, double x2, double y2, double z2, float f2) {
        GL11.glPushMatrix();
        atv.w().N.a(this.texture);
        TileEntityMachineGun tile = (TileEntityMachineGun)tileentity;
        int direction = tile.p();
        float rotationYaw = tile.prevYaw + (tile.yaw - tile.prevYaw) * f2;
        float rotationPitch = tile.prevPitch + (tile.pitch - tile.prevPitch) * f2;
        GL11.glTranslatef((float)((float)x2 + 0.5f), (float)((float)y2 + 0.35f), (float)((float)z2 + 0.5f));
        GL11.glRotatef((float)(-direction * 90 + 180), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glScalef((float)1.2f, (float)1.2f, (float)1.2f);
        GL11.glRotatef((float)(-rotationYaw), (float)0.0f, (float)1.0f, (float)0.0f);
        this.model.renderPart("Mesh2");
        GL11.glTranslatef((float)0.0f, (float)-0.15f, (float)0.15f);
        GL11.glRotatef((float)(-rotationPitch), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)0.15f, (float)-0.15f);
        this.model.renderPart("Mesh1");
        GL11.glPopMatrix();
    }
}

