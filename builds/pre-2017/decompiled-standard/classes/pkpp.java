/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class pkpp
extends htys {
    public void _a(xtcq xtcq2, double d, double d2, double d3, float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2, (float)d3 + 0.5f);
        pkpp._a(xtcq2._a(), d, d2, d3, f);
        GL11.glPopMatrix();
    }

    public static void _a(qokq qokq2, double d, double d2, double d3, float f) {
        Entity entity = qokq2._i();
        if (entity != null) {
            entity.func_70029_a(qokq2._a());
            float f2 = 0.4375f;
            GL11.glTranslatef(0.0f, 0.4f, 0.0f);
            GL11.glRotatef((float)(qokq2._g + (qokq2._f - qokq2._g) * (double)f) * 10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glTranslatef(0.0f, -0.4f, 0.0f);
            GL11.glScalef(f2, f2, f2);
            entity.func_70012_b(d, d2, d3, 0.0f, 0.0f);
            gqqu._b._a(entity, 0.0, 0.0, 0.0, 0.0f, f);
        }
    }

    @Override
    public /* synthetic */ void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        this._a((xtcq)hurg2, d, d2, d3, f);
    }
}

