/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class zfvd
extends TileEntitySpecialRenderer {
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        bqyt bqyt2 = (bqyt)tileEntity;
        if (Minecraft._E()._t.capabilities._d && GloomyCore.transparentsRenderType >= 0) {
            Tessellator tessellator = Tessellator.instance;
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glLineWidth(3.0f);
            GL11.glTranslated(d + (double)bqyt2.getXMin(), d2 + (double)bqyt2.getYMin(), d3 + (double)bqyt2.getZMin());
            tessellator.startDrawing(1);
            if (bqyt2.getSpawnEnabled()) {
                tessellator.setColorRGBA_F(0.0f, 0.0f, 0.75f, 0.25f);
            } else {
                tessellator.setColorRGBA_F(0.75f, 0.0f, 0.0f, 0.25f);
            }
            double d4 = bqyt2.getXMax() - bqyt2.getXMin() + 1;
            double d5 = bqyt2.getYMax() - bqyt2.getYMin() + 1;
            double d6 = bqyt2.getZMax() - bqyt2.getZMin() + 1;
            owxf._a(0.0, 0.0, 0.0, 0.0, d5, d6);
            owxf._a(0.0 + d4, 0.0, 0.0, 0.0, d5, d6);
            owxf._a(0.0, 0.0, 0.0, d4, d5, 0.0);
            owxf._a(0.0, 0.0, 0.0 + d6, d4, d5, 0.0);
            owxf._a(0.0, 0.0, 0.0, d4, 0.0, d6);
            owxf._a(0.0, d5, 0.0, d4, 0.0, d6);
            tessellator.draw();
            GL11.glPopMatrix();
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
    }
}

