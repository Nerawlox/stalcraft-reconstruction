/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelMinecart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class scrm
extends tfvm {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/minecart.png");
    public ModelBase _b = new ModelMinecart();
    public final htvc _c;

    public scrm() {
        this.field_76989_e = 0.5f;
        this._c = new htvc();
    }

    public void _a(EntityMinecart entityMinecart, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        this.func_110777_b(entityMinecart);
        long l = (long)entityMinecart.field_70157_k * 493286711L;
        l = l * l * 4392167121L + l * 98761L;
        float f3 = (((float)(l >> 16 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        float f4 = (((float)(l >> 20 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        float f5 = (((float)(l >> 24 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        GL11.glTranslatef(f3, f4, f5);
        double d4 = entityMinecart.field_70142_S + (entityMinecart.field_70165_t - entityMinecart.field_70142_S) * (double)f2;
        double d5 = entityMinecart.field_70137_T + (entityMinecart.field_70163_u - entityMinecart.field_70137_T) * (double)f2;
        double d6 = entityMinecart.field_70136_U + (entityMinecart.field_70161_v - entityMinecart.field_70136_U) * (double)f2;
        double d7 = 0.3f;
        ofbx ofbx2 = entityMinecart.func_70489_a(d4, d5, d6);
        float f6 = entityMinecart.field_70127_C + (entityMinecart.field_70125_A - entityMinecart.field_70127_C) * f2;
        if (ofbx2 != null) {
            ofbx ofbx3 = entityMinecart.func_70495_a(d4, d5, d6, d7);
            ofbx ofbx4 = entityMinecart.func_70495_a(d4, d5, d6, -d7);
            if (ofbx3 == null) {
                ofbx3 = ofbx2;
            }
            if (ofbx4 == null) {
                ofbx4 = ofbx2;
            }
            d += ofbx2._c - d4;
            d2 += (ofbx3._d + ofbx4._d) / 2.0 - d5;
            d3 += ofbx2._e - d6;
            ofbx ofbx5 = ofbx4._c(-ofbx3._c, -ofbx3._d, -ofbx3._e);
            if (ofbx5._b() != 0.0) {
                ofbx5 = ofbx5._a();
                f = (float)(Math.atan2(ofbx5._e, ofbx5._c) * 180.0 / Math.PI);
                f6 = (float)(Math.atan(ofbx5._d) * 73.0);
            }
        }
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glRotatef(180.0f - f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-f6, 0.0f, 0.0f, 1.0f);
        float f7 = (float)entityMinecart.func_70496_j() - f2;
        float f8 = entityMinecart.func_70491_i() - f2;
        if (f8 < 0.0f) {
            f8 = 0.0f;
        }
        if (f7 > 0.0f) {
            GL11.glRotatef(sajh._a(f7) * f7 * f8 / 10.0f * (float)entityMinecart.func_70493_k(), 1.0f, 0.0f, 0.0f);
        }
        int n = entityMinecart.func_94099_q();
        twgu twgu2 = entityMinecart.func_94089_m();
        int n2 = entityMinecart.func_94098_o();
        if (twgu2 != null) {
            GL11.glPushMatrix();
            this.func_110776_a(sctd._c);
            float f9 = 0.75f;
            GL11.glScalef(f9, f9, f9);
            GL11.glTranslatef(0.0f, (float)n / 16.0f, 0.0f);
            this._a(entityMinecart, f2, twgu2, n2);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.func_110777_b(entityMinecart);
        }
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this._b.func_78088_a(entityMinecart, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityMinecart entityMinecart) {
        return _a;
    }

    public void _a(EntityMinecart entityMinecart, float f, twgu twgu2, int n) {
        float f2 = entityMinecart.func_70013_c(f);
        GL11.glPushMatrix();
        this._c._a(twgu2, n, f2);
        GL11.glPopMatrix();
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityMinecart)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityMinecart)entity, d, d2, d3, f, f2);
    }
}

