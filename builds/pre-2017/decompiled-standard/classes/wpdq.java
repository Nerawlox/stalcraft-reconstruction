/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelSign;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class wpdq
extends htys {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/sign.png");
    public final ModelSign _b = new ModelSign();

    public void _a(jjza jjza2, double d, double d2, double d3, float f) {
        float f2;
        twgu twgu2 = jjza2.func_70311_o();
        GL11.glPushMatrix();
        float f3 = 0.6666667f;
        if (twgu2 == twgu.field_72053_aD) {
            GL11.glTranslatef((float)d + 0.5f, (float)d2 + 0.75f * f3, (float)d3 + 0.5f);
            float f4 = (float)(jjza2.func_70322_n() * 360) / 16.0f;
            GL11.glRotatef(-f4, 0.0f, 1.0f, 0.0f);
            this._b.field_78165_b.field_78806_j = true;
        } else {
            int n = jjza2.func_70322_n();
            f2 = 0.0f;
            if (n == 2) {
                f2 = 180.0f;
            }
            if (n == 4) {
                f2 = 90.0f;
            }
            if (n == 5) {
                f2 = -90.0f;
            }
            GL11.glTranslatef((float)d + 0.5f, (float)d2 + 0.75f * f3, (float)d3 + 0.5f);
            GL11.glRotatef(-f2, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, -0.3125f, -0.4375f);
            this._b.field_78165_b.field_78806_j = false;
        }
        this.func_110628_a(_a);
        GL11.glPushMatrix();
        GL11.glScalef(f3, -f3, -f3);
        this._b.func_78164_a();
        GL11.glPopMatrix();
        qncw qncw2 = this.func_76895_b();
        f2 = 0.016666668f * f3;
        GL11.glTranslatef(0.0f, 0.5f * f3, 0.07f * f3);
        GL11.glScalef(f2, -f2, f2);
        GL11.glNormal3f(0.0f, 0.0f, -1.0f * f2);
        GL11.glDepthMask(false);
        int n = 0;
        for (int i = 0; i < jjza2._a.length; ++i) {
            String string = jjza2._a[i];
            if (i == jjza2._b) {
                string = "> " + string + " <";
                qncw2._b(string, -qncw2._b(string) / 2, i * 10 - jjza2._a.length * 5, n);
                continue;
            }
            qncw2._b(string, -qncw2._b(string) / 2, i * 10 - jjza2._a.length * 5, n);
        }
        GL11.glDepthMask(true);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }

    @Override
    public /* synthetic */ void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        this._a((jjza)hurg2, d, d2, d3, f);
    }
}

