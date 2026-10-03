/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import org.lwjgl.opengl.GL11;

public class Render2d
extends bgm {
    private double halfSize;
    private boolean decrementAlpha = false;
    private int lifetime = 0;
    private bjo texture;

    public Render2d(double halfSize, String textureName) {
        this.halfSize = halfSize;
        this.texture = new bjo("stalker", "textures/" + textureName + ".png");
    }

    public Render2d(double halfSize, String textureName, boolean decrementAlpha, int lifetime) {
        this(halfSize, textureName);
        this.decrementAlpha = decrementAlpha;
        this.lifetime = lifetime;
    }

    public void doRenderEntity(nn acid, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        GL11.glEnable((int)32826);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        atv.w().N.a(this.texture);
        if (this.decrementAlpha) {
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)Math.max(0.0f, 1.0f - (float)acid.ac / (float)this.lifetime));
        }
        bfq tessellator = bfq.a;
        GL11.glRotatef((float)(180.0f - this.b.j), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-this.b.k), (float)1.0f, (float)0.0f, (float)0.0f);
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        tessellator.a(-this.halfSize, -this.halfSize, 0.0, 0.0, 1.0);
        tessellator.a(this.halfSize, -this.halfSize, 0.0, 1.0, 1.0);
        tessellator.a(this.halfSize, this.halfSize, 0.0, 1.0, 0.0);
        tessellator.a(-this.halfSize, this.halfSize, 0.0, 0.0, 0.0);
        tessellator.a();
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.doRenderEntity(par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn entity) {
        return null;
    }
}

