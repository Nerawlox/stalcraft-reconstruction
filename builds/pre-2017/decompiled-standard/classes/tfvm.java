/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class tfvm {
    public static final ResourceLocation field_110778_a = new ResourceLocation("textures/misc/shadow.png");
    public gqqu field_76990_c;
    public htvc field_76988_d = new htvc();
    public float field_76989_e;
    public float field_76987_f = 1.0f;

    public abstract void func_76986_a(Entity var1, double var2, double var4, double var6, float var8, float var9);

    public abstract ResourceLocation func_110775_a(Entity var1);

    public void func_110777_b(Entity entity) {
        this.func_110776_a(this.func_110775_a(entity));
    }

    public void func_110776_a(ResourceLocation resourceLocation) {
        this.field_76990_c._g._a(resourceLocation);
    }

    public void func_76977_a(Entity entity, double d, double d2, double d3, float f) {
        GL11.glDisable(2896);
        dwan dwan2 = twgu.field_72067_ar._a(0);
        dwan dwan3 = twgu.field_72067_ar._a(1);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        float f2 = entity.field_70130_N * 1.4f;
        GL11.glScalef(f2, f2, f2);
        htvf htvf2 = htvf.field_78398_a;
        float f3 = 0.5f;
        float f4 = 0.0f;
        float f5 = entity.field_70131_O / f2;
        float f6 = (float)(entity.field_70163_u - entity.field_70121_D._c);
        GL11.glRotatef(-this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.0f, -0.3f + (float)((int)f5) * 0.02f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f7 = 0.0f;
        int n = 0;
        tfsl cfr_ignored_0 = xpzm._E()._D;
        tfsl.enableTerrainShader(-1);
        htvf2.func_78382_b();
        while (f5 > 0.0f) {
            dwan dwan4 = n % 2 == 0 ? dwan2 : dwan3;
            this.func_110776_a(sctd._c);
            float f8 = dwan4.func_94209_e();
            float f9 = dwan4.func_94206_g();
            float f10 = dwan4.func_94212_f();
            float f11 = dwan4.func_94210_h();
            if (n / 2 % 2 == 0) {
                float f12 = f10;
                f10 = f8;
                f8 = f12;
            }
            htvf2.func_78374_a(f3 - f4, 0.0f - f6, f7, f10, f11);
            htvf2.func_78374_a(-f3 - f4, 0.0f - f6, f7, f8, f11);
            htvf2.func_78374_a(-f3 - f4, 1.4f - f6, f7, f8, f9);
            htvf2.func_78374_a(f3 - f4, 1.4f - f6, f7, f10, f9);
            f5 -= 0.45f;
            f6 -= 0.45f;
            f3 *= 0.9f;
            f7 += 0.03f;
            ++n;
        }
        htvf2.func_78381_a();
        xpzm xpzm2 = xpzm._E();
        xpzm2._D.disableTerrainShader();
        GL11.glPopMatrix();
        GL11.glEnable(2896);
    }

    public void func_76975_c(Entity entity, double d, double d2, double d3, float f, float f2) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        this.field_76990_c._g._a(field_110778_a);
        ozlu ozlu2 = this.func_76982_b();
        GL11.glDepthMask(false);
        float f3 = this.field_76989_e;
        if (entity instanceof EntityLiving) {
            EntityLiving entityLiving = (EntityLiving)entity;
            f3 *= entityLiving.func_70603_bj();
            if (entityLiving.func_70631_g_()) {
                f3 *= 0.5f;
            }
        }
        double d4 = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * (double)f2;
        double d5 = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * (double)f2 + (double)entity.func_70053_R();
        double d6 = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * (double)f2;
        int n = sajh._c(d4 - (double)f3);
        int n2 = sajh._c(d4 + (double)f3);
        int n3 = sajh._c(d5 - (double)f3);
        int n4 = sajh._c(d5);
        int n5 = sajh._c(d6 - (double)f3);
        int n6 = sajh._c(d6 + (double)f3);
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                for (int k = n5; k <= n6; ++k) {
                    int n7 = ozlu2.func_72798_a(i, j - 1, k);
                    if (n7 <= 0 || ozlu2.func_72957_l(i, j, k) <= 3) continue;
                    this.func_76981_a(twgu.field_71973_m[n7], d, d2 + (double)entity.func_70053_R(), d3, i, j, k, f, f3, d7, d8 + (double)entity.func_70053_R(), d9);
                }
            }
        }
        htvf2.func_78381_a();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
    }

    public ozlu func_76982_b() {
        return this.field_76990_c._i;
    }

    public void func_76981_a(twgu twgu2, double d, double d2, double d3, int n, int n2, int n3, float f, float f2, double d4, double d5, double d6) {
        double d7;
        htvf htvf2 = htvf.field_78398_a;
        if (twgu2.func_71886_c() && (d7 = ((double)f - (d2 - ((double)n2 + d5)) / 2.0) * 0.5 * (double)this.func_76982_b().func_72801_o(n, n2, n3)) >= 0.0) {
            if (d7 > 1.0) {
                d7 = 1.0;
            }
            htvf2.func_78369_a(1.0f, 1.0f, 1.0f, (float)d7);
            double d8 = (double)n + twgu2.func_83009_v() + d4;
            double d9 = (double)n + twgu2.func_83007_w() + d4;
            double d10 = (double)n2 + twgu2.func_83008_x() + d5 + 0.015625;
            double d11 = (double)n3 + twgu2.func_83005_z() + d6;
            double d12 = (double)n3 + twgu2.func_83006_A() + d6;
            float f3 = (float)((d - d8) / 2.0 / (double)f2 + 0.5);
            float f4 = (float)((d - d9) / 2.0 / (double)f2 + 0.5);
            float f5 = (float)((d3 - d11) / 2.0 / (double)f2 + 0.5);
            float f6 = (float)((d3 - d12) / 2.0 / (double)f2 + 0.5);
            htvf2.func_78374_a(d8, d10, d11, f3, f5);
            htvf2.func_78374_a(d8, d10, d12, f3, f6);
            htvf2.func_78374_a(d9, d10, d12, f4, f6);
            htvf2.func_78374_a(d9, d10, d11, f4, f5);
        }
    }

    public static void func_76978_a(eidj eidj2, double d, double d2, double d3) {
        GL11.glDisable(3553);
        htvf htvf2 = htvf.field_78398_a;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        htvf2.func_78382_b();
        htvf2.func_78373_b(d, d2, d3);
        htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._d);
        htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._g);
        htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._g);
        htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._d);
        htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._d);
        htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._g);
        htvf2.func_78373_b(0.0, 0.0, 0.0);
        htvf2.func_78381_a();
        GL11.glEnable(3553);
    }

    public static void func_76980_a(eidj eidj2) {
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._g);
        htvf2.func_78381_a();
    }

    public void func_76976_a(gqqu gqqu2) {
        this.field_76990_c = gqqu2;
    }

    public void func_76979_b(Entity entity, double d, double d2, double d3, float f, float f2) {
        double d4;
        float f3;
        if (this.field_76990_c._n.field_74347_j && this.field_76989_e > 0.0f && !entity.func_82150_aj() && (f3 = (float)((1.0 - (d4 = this.field_76990_c._a(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v)) / 256.0) * (double)this.field_76987_f)) > 0.0f) {
            this.func_76975_c(entity, d, d2, d3, f3, f2);
        }
        if (entity.func_90999_ad()) {
            this.func_76977_a(entity, d, d2, d3, f2);
        }
    }

    public qncw func_76983_a() {
        return this.field_76990_c._a();
    }

    public void func_94143_a(nege nege2) {
    }
}

