/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class bbbz
extends tfvm {
    public static final ResourceLocation _a = new ResourceLocation("textures/particle/particles.png");

    public void _a(EntityFishHook entityFishHook, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.func_110777_b(entityFishHook);
        htvf htvf2 = htvf.field_78398_a;
        int n = 1;
        int n2 = 2;
        float f3 = (float)(n * 8 + 0) / 128.0f;
        float f4 = (float)(n * 8 + 8) / 128.0f;
        float f5 = (float)(n2 * 8 + 0) / 128.0f;
        float f6 = (float)(n2 * 8 + 8) / 128.0f;
        float f7 = 1.0f;
        float f8 = 0.5f;
        float f9 = 0.5f;
        GL11.glRotatef(180.0f - this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.field_76990_c._m, 1.0f, 0.0f, 0.0f);
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
        htvf2.func_78374_a(0.0f - f8, 0.0f - f9, 0.0, f3, f6);
        htvf2.func_78374_a(f7 - f8, 0.0f - f9, 0.0, f4, f6);
        htvf2.func_78374_a(f7 - f8, 1.0f - f9, 0.0, f4, f5);
        htvf2.func_78374_a(0.0f - f8, 1.0f - f9, 0.0, f3, f5);
        htvf2.func_78381_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        if (entityFishHook.field_70204_b != null) {
            double d4;
            float f10 = entityFishHook.field_70204_b.func_70678_g(f2);
            float f11 = sajh._a(sajh._c(f10) * (float)Math.PI);
            ofbx ofbx2 = entityFishHook.field_70170_p.func_82732_R()._a(-0.5, 0.03, 0.8);
            ofbx2._a(-(entityFishHook.field_70204_b.field_70127_C + (entityFishHook.field_70204_b.field_70125_A - entityFishHook.field_70204_b.field_70127_C) * f2) * (float)Math.PI / 180.0f);
            ofbx2._b(-(entityFishHook.field_70204_b.field_70126_B + (entityFishHook.field_70204_b.field_70177_z - entityFishHook.field_70204_b.field_70126_B) * f2) * (float)Math.PI / 180.0f);
            ofbx2._b(f11 * 0.5f);
            ofbx2._a(-f11 * 0.7f);
            double d5 = entityFishHook.field_70204_b.field_70169_q + (entityFishHook.field_70204_b.field_70165_t - entityFishHook.field_70204_b.field_70169_q) * (double)f2 + ofbx2._c;
            double d6 = entityFishHook.field_70204_b.field_70167_r + (entityFishHook.field_70204_b.field_70163_u - entityFishHook.field_70204_b.field_70167_r) * (double)f2 + ofbx2._d;
            double d7 = entityFishHook.field_70204_b.field_70166_s + (entityFishHook.field_70204_b.field_70161_v - entityFishHook.field_70204_b.field_70166_s) * (double)f2 + ofbx2._e;
            double d8 = d4 = entityFishHook.field_70204_b == xpzm._E()._t ? 0.0 : (double)entityFishHook.field_70204_b.func_70047_e();
            if (this.field_76990_c._n.field_74320_O > 0 || entityFishHook.field_70204_b != xpzm._E()._t) {
                float f12 = (entityFishHook.field_70204_b.field_70760_ar + (entityFishHook.field_70204_b.field_70761_aq - entityFishHook.field_70204_b.field_70760_ar) * f2) * (float)Math.PI / 180.0f;
                double d9 = sajh._a(f12);
                double d10 = sajh._b(f12);
                d5 = entityFishHook.field_70204_b.field_70169_q + (entityFishHook.field_70204_b.field_70165_t - entityFishHook.field_70204_b.field_70169_q) * (double)f2 - d10 * 0.35 - d9 * 0.85;
                d6 = entityFishHook.field_70204_b.field_70167_r + d4 + (entityFishHook.field_70204_b.field_70163_u - entityFishHook.field_70204_b.field_70167_r) * (double)f2 - 0.45;
                d7 = entityFishHook.field_70204_b.field_70166_s + (entityFishHook.field_70204_b.field_70161_v - entityFishHook.field_70204_b.field_70166_s) * (double)f2 - d9 * 0.35 + d10 * 0.85;
            }
            double d11 = entityFishHook.field_70169_q + (entityFishHook.field_70165_t - entityFishHook.field_70169_q) * (double)f2;
            double d12 = entityFishHook.field_70167_r + (entityFishHook.field_70163_u - entityFishHook.field_70167_r) * (double)f2 + 0.25;
            double d13 = entityFishHook.field_70166_s + (entityFishHook.field_70161_v - entityFishHook.field_70166_s) * (double)f2;
            double d14 = (float)(d5 - d11);
            double d15 = (float)(d6 - d12);
            double d16 = (float)(d7 - d13);
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            htvf2.func_78371_b(3);
            htvf2.func_78378_d(0);
            int n3 = 16;
            for (int i = 0; i <= n3; ++i) {
                float f13 = (float)i / (float)n3;
                htvf2.func_78377_a(d + d14 * (double)f13, d2 + d15 * (double)(f13 * f13 + f13) * 0.5 + 0.25, d3 + d16 * (double)f13);
            }
            htvf2.func_78381_a();
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
    }

    public ResourceLocation _a(EntityFishHook entityFishHook) {
        return _a;
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityFishHook)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityFishHook)entity, d, d2, d3, f, f2);
    }
}

