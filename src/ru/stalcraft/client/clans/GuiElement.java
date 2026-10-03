/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.clans;

import org.lwjgl.opengl.GL11;

public class GuiElement
extends avk {
    public static void drawRectHD(int par0, int par1, int par2, int par3, int par4) {
        int j1;
        if (par0 < par2) {
            j1 = par0;
            par0 = par2;
            par2 = j1;
        }
        if (par1 < par3) {
            j1 = par1;
            par1 = par3;
            par3 = j1;
        }
        float f2 = (float)(par4 >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(par4 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(par4 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(par4 & 0xFF) / 255.0f;
        bfq tessellator = bfq.a;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)f1, (float)f22, (float)f3, (float)f2);
        tessellator.b();
        tessellator.a((double)par0 / 2.0, (double)par3 / 2.0, 0.0);
        tessellator.a((double)par2 / 2.0, (double)par3 / 2.0, 0.0);
        tessellator.a((double)par2 / 2.0, (double)par1 / 2.0, 0.0);
        tessellator.a((double)par0 / 2.0, (double)par1 / 2.0, 0.0);
        tessellator.a();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
    }

    public static int getStringWidthHD(String str) {
        return atv.w().l.a(str) * 2;
    }
}

