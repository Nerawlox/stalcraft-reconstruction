/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import org.lwjgl.opengl.GL11;
import ru.stalcraft.entity.EntityShot;

public class RenderShot
extends bgm {
    private bjo texture1 = new bjo("stalker", "textures/light1.png");
    private bjo texture2 = new bjo("stalker", "textures/light2.png");

    public void doRenderShot(EntityShot entity, double par2, double par4, double par6, float par8, float par9) {
        if (entity.size != 0.0f) {
            // empty if block
        }
    }

    private void renderSimpleShot(EntityShot entity, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4 - 0.1f), (float)((float)par6));
        GL11.glScalef((float)(entity.size / 2.0f), (float)(entity.size / 2.0f), (float)(entity.size / 2.0f));
        GL11.glEnable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glAlphaFunc((int)516, (float)0.1f);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2896);
        this.a(this.texture2);
        bfq t2 = bfq.a;
        GL11.glRotatef((float)(90.0f - entity.A), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)entity.B, (float)0.0f, (float)0.0f, (float)1.0f);
        double alpha = Math.toRadians(entity.B);
        entity.getClass();
        double distance1 = -1.0;
        double distance2 = distance1 + 1.0;
        double xMod = 0.0;
        double yMod = 0.5;
        double y1 = 0.0;
        double y2 = 0.0;
        double x1 = -1.25;
        double x2 = 0.0;
        GL11.glRotatef((float)entity.rotationRoll, (float)1.0f, (float)0.0f, (float)0.0f);
        t2.b();
        t2.a(x1 + xMod + (double)0.15f, y1 - yMod, 0.0, 0.0, 1.0);
        t2.a(x2 + xMod + (double)0.15f, y2 - yMod, 0.0, 1.0, 1.0);
        t2.a(x2 - xMod + (double)0.15f, y2 + yMod, 0.0, 1.0, 0.0);
        t2.a(x1 - xMod + (double)0.15f, y1 + yMod, 0.0, 0.0, 0.0);
        t2.a();
        t2.b();
        t2.a(x1 + xMod + (double)0.15f, y1 - yMod, 0.0, 0.0, 1.0);
        t2.a(x1 - xMod + (double)0.15f, y1 + yMod, 0.0, 0.0, 0.0);
        t2.a(x2 - xMod + (double)0.15f, y2 + yMod, 0.0, 1.0, 0.0);
        t2.a(x2 + xMod + (double)0.15f, y2 - yMod, 0.0, 1.0, 1.0);
        t2.a();
        t2.b();
        t2.a(x1 + (double)0.15f, y1, -0.5, 0.0, 1.0);
        t2.a(x2 + (double)0.15f, y2, -0.5, 1.0, 1.0);
        t2.a(x2 + (double)0.15f, y2, 0.5, 1.0, 0.0);
        t2.a(x1 + (double)0.15f, y1, 0.5, 0.0, 0.0);
        t2.a();
        t2.b();
        t2.a(x1 + (double)0.15f, y1, -0.5, 0.0, 1.0);
        t2.a(x1 + (double)0.15f, y1, 0.5, 0.0, 0.0);
        t2.a(x2 + (double)0.15f, y2, 0.5, 1.0, 0.0);
        t2.a(x2 + (double)0.15f, y2, -0.5, 1.0, 1.0);
        t2.a();
        this.a(this.texture2);
        t2.b();
        t2.a(x2 + xMod, y2 - yMod, -0.5, 0.0, 1.0);
        t2.a(x2 + xMod, y2 - yMod, 0.5, 1.0, 1.0);
        t2.a(x2 - xMod, y2 + yMod, 0.5, 1.0, 0.0);
        t2.a(x2 - xMod, y2 + yMod, -0.5, 0.0, 0.0);
        t2.a();
        t2.b();
        t2.a(x2 - xMod, y2 + yMod, -0.5, 0.0, 0.0);
        t2.a(x2 - xMod, y2 + yMod, 0.5, 1.0, 0.0);
        t2.a(x2 + xMod, y2 - yMod, 0.5, 1.0, 1.0);
        t2.a(x2 + xMod, y2 - yMod, -0.5, 0.0, 1.0);
        t2.a();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2896);
        GL11.glDisable((int)3042);
        GL11.glAlphaFunc((int)516, (float)0.1f);
        GL11.glPopMatrix();
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.doRenderShot((EntityShot)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn entity) {
        return null;
    }
}

