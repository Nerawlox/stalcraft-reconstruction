/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  bje
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import org.lwjgl.opengl.GL11;
import ru.stalcraft.blocks.BlockEjectionSave;
import ru.stalcraft.tile.TileEntityEjectionSave;

public class RenderBoxEjectionSave
extends bje {
    public void a(asp par1, double d0, double d1, double d2, float f2) {
        TileEntityEjectionSave par6 = (TileEntityEjectionSave)par1;
        if (atv.w().c.h() && BlockEjectionSave.isBoxSave) {
            GL11.glPushMatrix();
            GL11.glDisable((int)3008);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glLineWidth((float)2.0f);
            GL11.glDisable((int)3553);
            GL11.glDepthMask((boolean)false);
            GL11.glTranslated((double)(d0 + 0.5), (double)d1, (double)(d2 + 0.5));
            float f1 = -0.05f;
            GL11.glColor4d((double)0.0, (double)0.8, (double)0.0, (double)1.0);
            this.drawOutlinedBoundingBox(asx.a().a(-20.0, 0.0, -20.0, 20.0, 10.0, 20.0).b((double)f1, (double)f1, (double)f1));
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)3553);
            GL11.glDisable((int)3042);
            GL11.glEnable((int)3008);
            GL11.glPopMatrix();
        }
    }

    private void drawOutlinedBoundingBox(asx par1AxisAlignedBB) {
        bfq tessellator = bfq.a;
        tessellator.b(3);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
        tessellator.a();
        tessellator.b(3);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
        tessellator.a();
        tessellator.b(1);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
        tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
        tessellator.a();
    }
}

