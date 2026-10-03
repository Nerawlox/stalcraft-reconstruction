/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class xqky
extends htys {
    private static ResourceLocation _a = new ResourceLocation("anomalies", "textures/anomaly/electra_overlay.dds");
    private static htvf _b = htvf.field_78398_a;
    private static xpzm _c = xpzm._E();

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        wnhj wnhj2 = (wnhj)hurg2;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        GL11.glDepthMask(false);
        GL11.glPolygonOffset(-3.0f, -3.0f);
        GL11.glEnable(32823);
        GL11.glPushMatrix();
        GL11.glTranslated(d + 0.5, d2 + 0.01, d3 + 0.5);
        xqky._c._h._a(_a);
        for (jhcr jhcr2 : wnhj2._f) {
            GL11.glPushMatrix();
            GL11.glRotatef(jhcr2._f, 0.0f, 1.0f, 0.0f);
            GL11.glColor4f(jhcr2._h, jhcr2._i, jhcr2._j, jhcr2._e + (jhcr2._d - jhcr2._e) * f);
            float f2 = (jhcr2._c + (jhcr2._b - jhcr2._c) * f) / 2.0f;
            _b.func_78382_b();
            _b.func_78380_c(0xF000F0);
            _b.func_78375_b(0.0f, 1.0f, 0.0f);
            _b.func_78374_a(-f2, 0.0, -f2, 0.0, 1.0);
            _b.func_78374_a(-f2, 0.0, f2, 0.0, 0.0);
            _b.func_78374_a(f2, 0.0, f2, 1.0, 0.0);
            _b.func_78374_a(f2, 0.0, -f2, 1.0, 1.0);
            _b.func_78381_a();
            GL11.glPopMatrix();
        }
        GL11.glPopMatrix();
        GL11.glPolygonOffset(0.0f, 0.0f);
        GL11.glDisable(32823);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
    }

    static {
        fmib._b(_a);
    }
}

