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

public class RenderFlag
extends bje {
    private IModelCustom model = AdvancedModelLoader.loadModel((String)"/assets/stalker/models/flag.obj");
    private bjo texture_down = new bjo("stalker", "models/flag_down.png");
    private bjo texture_up = new bjo("stalker", "models/flag_up.png");

    public void a(asp tileentity, double x2, double y2, double z2, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)x2 + 0.5f), (float)((float)y2), (float)((float)z2 + 0.5f));
        atv.w().N.a(this.texture_down);
        this.model.renderPart("palka");
        atv.w().N.a(this.texture_up);
        this.model.renderPart("flag");
        GL11.glPopMatrix();
    }
}

