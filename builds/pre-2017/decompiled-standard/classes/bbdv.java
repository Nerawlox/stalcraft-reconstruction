/*
 * Decompiled with CFR 0.152.
 */
import java.nio.FloatBuffer;
import java.util.Random;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class bbdv
extends htys {
    public static final ResourceLocation _a = new ResourceLocation("textures/environment/end_sky.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/end_portal.png");
    public static final Random _c = new Random(31100L);
    public FloatBuffer _d = pklh._e(16);

    public void _a(zziy zziy2, double d, double d2, double d3, float f) {
        float f2 = (float)this.field_76898_b._l;
        float f3 = (float)this.field_76898_b._m;
        float f4 = (float)this.field_76898_b._n;
        GL11.glDisable(2896);
        _c.setSeed(31100L);
        float f5 = 0.75f;
        for (int i = 0; i < 16; ++i) {
            GL11.glPushMatrix();
            float f6 = 16 - i;
            float f7 = 0.0625f;
            float f8 = 1.0f / (f6 + 1.0f);
            if (i == 0) {
                this.func_110628_a(_a);
                f8 = 0.1f;
                f6 = 65.0f;
                f7 = 0.125f;
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
            }
            if (i == 1) {
                this.func_110628_a(_b);
                GL11.glEnable(3042);
                GL11.glBlendFunc(1, 1);
                f7 = 0.5f;
            }
            float f9 = (float)(-(d2 + (double)f5));
            float f10 = f9 + tfss._b;
            float f11 = f9 + f6 + tfss._b;
            float f12 = f10 / f11;
            f12 = (float)(d2 + (double)f5) + f12;
            GL11.glTranslatef(f2, f12, f4);
            GL11.glTexGeni(8192, 9472, 9217);
            GL11.glTexGeni(8193, 9472, 9217);
            GL11.glTexGeni(8194, 9472, 9217);
            GL11.glTexGeni(8195, 9472, 9216);
            GL11.glTexGen(8192, 9473, this._a(1.0f, 0.0f, 0.0f, 0.0f));
            GL11.glTexGen(8193, 9473, this._a(0.0f, 0.0f, 1.0f, 0.0f));
            GL11.glTexGen(8194, 9473, this._a(0.0f, 0.0f, 0.0f, 1.0f));
            GL11.glTexGen(8195, 9474, this._a(0.0f, 1.0f, 0.0f, 0.0f));
            GL11.glEnable(3168);
            GL11.glEnable(3169);
            GL11.glEnable(3170);
            GL11.glEnable(3171);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0f, (float)(xpzm._M() % 700000L) / 700000.0f, 0.0f);
            GL11.glScalef(f7, f7, f7);
            GL11.glTranslatef(0.5f, 0.5f, 0.0f);
            GL11.glRotatef((float)(i * i * 4321 + i * 9) * 2.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.5f, -0.5f, 0.0f);
            GL11.glTranslatef(-f2, -f4, -f3);
            f10 = f9 + tfss._b;
            GL11.glTranslatef(tfss._a * f6 / f10, tfss._c * f6 / f10, -f3);
            htvf htvf2 = htvf.field_78398_a;
            htvf2.func_78382_b();
            f12 = _c.nextFloat() * 0.5f + 0.1f;
            float f13 = _c.nextFloat() * 0.5f + 0.4f;
            float f14 = _c.nextFloat() * 0.5f + 0.5f;
            if (i == 0) {
                f14 = 1.0f;
                f13 = 1.0f;
                f12 = 1.0f;
            }
            htvf2.func_78369_a(f12 * f8, f13 * f8, f14 * f8, 1.0f);
            htvf2.func_78377_a(d, d2 + (double)f5, d3);
            htvf2.func_78377_a(d, d2 + (double)f5, d3 + 1.0);
            htvf2.func_78377_a(d + 1.0, d2 + (double)f5, d3 + 1.0);
            htvf2.func_78377_a(d + 1.0, d2 + (double)f5, d3);
            htvf2.func_78381_a();
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
        }
        GL11.glDisable(3042);
        GL11.glDisable(3168);
        GL11.glDisable(3169);
        GL11.glDisable(3170);
        GL11.glDisable(3171);
        GL11.glEnable(2896);
    }

    public FloatBuffer _a(float f, float f2, float f3, float f4) {
        this._d.clear();
        this._d.put(f).put(f2).put(f3).put(f4);
        this._d.flip();
        return this._d;
    }

    @Override
    public /* synthetic */ void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        this._a((zziy)hurg2, d, d2, d3, f);
    }
}

