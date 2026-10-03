/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqi;
import org.lwjgl.opengl.GL11;

public class tfxx
extends tfvm {
    public static final ResourceLocation _a = new ResourceLocation("textures/painting/paintings_kristoffer_zetterstrand.png");

    public void _a(EntityPainting entityPainting, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glRotatef(f, 0.0f, 1.0f, 0.0f);
        GL11.glEnable(32826);
        this.func_110777_b(entityPainting);
        ugqi ugqi2 = entityPainting.field_70522_e;
        float f3 = 0.0625f;
        GL11.glScalef(f3, f3, f3);
        this._a(entityPainting, ugqi2.__aL, ugqi2.__aM, ugqi2.__aN, ugqi2.__aO);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityPainting entityPainting) {
        return _a;
    }

    public void _a(EntityPainting entityPainting, int n, int n2, int n3, int n4) {
        float f = (float)(-n) / 2.0f;
        float f2 = (float)(-n2) / 2.0f;
        float f3 = 0.5f;
        float f4 = 0.75f;
        float f5 = 0.8125f;
        float f6 = 0.0f;
        float f7 = 0.0625f;
        float f8 = 0.75f;
        float f9 = 0.8125f;
        float f10 = 0.001953125f;
        float f11 = 0.001953125f;
        float f12 = 0.7519531f;
        float f13 = 0.7519531f;
        float f14 = 0.0f;
        float f15 = 0.0625f;
        for (int i = 0; i < n / 16; ++i) {
            for (int j = 0; j < n2 / 16; ++j) {
                float f16 = f + (float)((i + 1) * 16);
                float f17 = f + (float)(i * 16);
                float f18 = f2 + (float)((j + 1) * 16);
                float f19 = f2 + (float)(j * 16);
                this._a(entityPainting, (f16 + f17) / 2.0f, (f18 + f19) / 2.0f);
                float f20 = (float)(n3 + n - i * 16) / 256.0f;
                float f21 = (float)(n3 + n - (i + 1) * 16) / 256.0f;
                float f22 = (float)(n4 + n2 - j * 16) / 256.0f;
                float f23 = (float)(n4 + n2 - (j + 1) * 16) / 256.0f;
                htvf htvf2 = htvf.field_78398_a;
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
                htvf2.func_78374_a(f16, f19, -f3, f21, f22);
                htvf2.func_78374_a(f17, f19, -f3, f20, f22);
                htvf2.func_78374_a(f17, f18, -f3, f20, f23);
                htvf2.func_78374_a(f16, f18, -f3, f21, f23);
                htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
                htvf2.func_78374_a(f16, f18, f3, f4, f6);
                htvf2.func_78374_a(f17, f18, f3, f5, f6);
                htvf2.func_78374_a(f17, f19, f3, f5, f7);
                htvf2.func_78374_a(f16, f19, f3, f4, f7);
                htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
                htvf2.func_78374_a(f16, f18, -f3, f8, f10);
                htvf2.func_78374_a(f17, f18, -f3, f9, f10);
                htvf2.func_78374_a(f17, f18, f3, f9, f11);
                htvf2.func_78374_a(f16, f18, f3, f8, f11);
                htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                htvf2.func_78374_a(f16, f19, f3, f8, f10);
                htvf2.func_78374_a(f17, f19, f3, f9, f10);
                htvf2.func_78374_a(f17, f19, -f3, f9, f11);
                htvf2.func_78374_a(f16, f19, -f3, f8, f11);
                htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
                htvf2.func_78374_a(f16, f18, f3, f13, f14);
                htvf2.func_78374_a(f16, f19, f3, f13, f15);
                htvf2.func_78374_a(f16, f19, -f3, f12, f15);
                htvf2.func_78374_a(f16, f18, -f3, f12, f14);
                htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
                htvf2.func_78374_a(f17, f18, -f3, f13, f14);
                htvf2.func_78374_a(f17, f19, -f3, f13, f15);
                htvf2.func_78374_a(f17, f19, f3, f12, f15);
                htvf2.func_78374_a(f17, f18, f3, f12, f14);
                htvf2.func_78381_a();
            }
        }
    }

    public void _a(EntityPainting entityPainting, float f, float f2) {
        int n = sajh._c(entityPainting.field_70165_t);
        int n2 = sajh._c(entityPainting.field_70163_u + (double)(f2 / 16.0f));
        int n3 = sajh._c(entityPainting.field_70161_v);
        if (entityPainting.field_82332_a == 2) {
            n = sajh._c(entityPainting.field_70165_t + (double)(f / 16.0f));
        }
        if (entityPainting.field_82332_a == 1) {
            n3 = sajh._c(entityPainting.field_70161_v - (double)(f / 16.0f));
        }
        if (entityPainting.field_82332_a == 0) {
            n = sajh._c(entityPainting.field_70165_t - (double)(f / 16.0f));
        }
        if (entityPainting.field_82332_a == 3) {
            n3 = sajh._c(entityPainting.field_70161_v + (double)(f / 16.0f));
        }
        int n4 = this.field_76990_c._i.func_72802_i(n, n2, n3, 0);
        int n5 = n4 % 65536;
        int n6 = n4 / 65536;
        iwya._a(iwya._b, n5, n6);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityPainting)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityPainting)entity, d, d2, d3, f, f2);
    }
}

