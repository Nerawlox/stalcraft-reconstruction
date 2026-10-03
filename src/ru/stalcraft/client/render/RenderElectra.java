/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bje
 *  bjo
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import org.lwjgl.opengl.GL11;

public class RenderElectra
extends bje {
    private bjo texture = new bjo("stalker", "textures/anomaly/electra.png");

    public void a(asp tileentity, double x2, double y2, double z2, float frame) {
        GL11.glPushMatrix();
        GL11.glPopMatrix();
    }
}

