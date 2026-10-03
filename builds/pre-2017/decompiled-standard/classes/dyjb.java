/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class dyjb
extends tfvm {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/arrow.png");

    public void _a(EntityArrow entityArrow, double d, double d2, double d3, float f, float f2) {
        this.func_110777_b(entityArrow);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glRotatef(entityArrow.field_70126_B + (entityArrow.field_70177_z - entityArrow.field_70126_B) * f2 - 90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(entityArrow.field_70127_C + (entityArrow.field_70125_A - entityArrow.field_70127_C) * f2, 0.0f, 0.0f, 1.0f);
        htvf htvf2 = htvf.field_78398_a;
        int n = 0;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = (float)(0 + n * 10) / 32.0f;
        float f6 = (float)(5 + n * 10) / 32.0f;
        float f7 = 0.0f;
        float f8 = 0.15625f;
        float f9 = (float)(5 + n * 10) / 32.0f;
        float f10 = (float)(10 + n * 10) / 32.0f;
        float f11 = 0.05625f;
        GL11.glEnable(32826);
        float f12 = (float)entityArrow.field_70249_b - f2;
        if (f12 > 0.0f) {
            float f13 = -sajh._a(f12 * 3.0f) * f12;
            GL11.glRotatef(f13, 0.0f, 0.0f, 1.0f);
        }
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(f11, f11, f11);
        GL11.glTranslatef(-4.0f, 0.0f, 0.0f);
        GL11.glNormal3f(f11, 0.0f, 0.0f);
        htvf2.func_78382_b();
        htvf2.func_78374_a(-7.0, -2.0, -2.0, f7, f9);
        htvf2.func_78374_a(-7.0, -2.0, 2.0, f8, f9);
        htvf2.func_78374_a(-7.0, 2.0, 2.0, f8, f10);
        htvf2.func_78374_a(-7.0, 2.0, -2.0, f7, f10);
        htvf2.func_78381_a();
        GL11.glNormal3f(-f11, 0.0f, 0.0f);
        htvf2.func_78382_b();
        htvf2.func_78374_a(-7.0, 2.0, -2.0, f7, f9);
        htvf2.func_78374_a(-7.0, 2.0, 2.0, f8, f9);
        htvf2.func_78374_a(-7.0, -2.0, 2.0, f8, f10);
        htvf2.func_78374_a(-7.0, -2.0, -2.0, f7, f10);
        htvf2.func_78381_a();
        for (int i = 0; i < 4; ++i) {
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glNormal3f(0.0f, 0.0f, f11);
            htvf2.func_78382_b();
            htvf2.func_78374_a(-8.0, -2.0, 0.0, f3, f5);
            htvf2.func_78374_a(8.0, -2.0, 0.0, f4, f5);
            htvf2.func_78374_a(8.0, 2.0, 0.0, f4, f6);
            htvf2.func_78374_a(-8.0, 2.0, 0.0, f3, f6);
            htvf2.func_78381_a();
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityArrow entityArrow) {
        return _a;
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityArrow)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityArrow)entity, d, d2, d3, f, f2);
    }
}

