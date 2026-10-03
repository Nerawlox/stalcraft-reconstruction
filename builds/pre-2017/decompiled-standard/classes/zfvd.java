/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class zfvd
extends htys {
    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        bqyt bqyt2 = (bqyt)hurg2;
        if (xpzm._E()._t.field_71075_bZ._d && GloomyCore.transparentsRenderType >= 0) {
            htvf htvf2 = htvf.field_78398_a;
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glLineWidth(3.0f);
            GL11.glTranslated(d + (double)bqyt2.getXMin(), d2 + (double)bqyt2.getYMin(), d3 + (double)bqyt2.getZMin());
            htvf2.func_78371_b(1);
            if (bqyt2.getSpawnEnabled()) {
                htvf2.func_78369_a(0.0f, 0.0f, 0.75f, 0.25f);
            } else {
                htvf2.func_78369_a(0.75f, 0.0f, 0.0f, 0.25f);
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
            htvf2.func_78381_a();
            GL11.glPopMatrix();
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
    }
}

