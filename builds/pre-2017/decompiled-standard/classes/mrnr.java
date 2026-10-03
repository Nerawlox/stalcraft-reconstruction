/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.entity.EntityBulletHole;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class mrnr
extends tfvm {
    private ResourceLocation _a = new ResourceLocation("weapons", "textures/dirochki.dds");
    private dhji[] _b = new dhji[40];

    public mrnr() {
        fmib._b(this._a);
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = new dhji("bullet_hole_" + i);
            this._b[i].func_110966_b(64);
            this._b[i].func_110969_c(64);
            this._b[i].func_110971_a(256, 640, i % 4 * 64, i / 4 * 64, false);
        }
    }

    public void _a(EntityBulletHole entityBulletHole, double d, double d2, double d3, float f, float f2) {
        int n = entityBulletHole.sideHit;
        ozlu ozlu2 = entityBulletHole.field_70170_p;
        float f3 = 0.04f;
        int n2 = sajh._c(entityBulletHole.field_70165_t - (double)f3);
        int n3 = sajh._c(entityBulletHole.field_70165_t + (double)f3);
        int n4 = sajh._c(entityBulletHole.field_70163_u - (double)f3);
        int n5 = sajh._c(entityBulletHole.field_70163_u + (double)f3);
        int n6 = sajh._c(entityBulletHole.field_70161_v - (double)f3);
        int n7 = sajh._c(entityBulletHole.field_70161_v + (double)f3);
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        switch (n) {
            case 0: 
            case 1: {
                n9 = n == 0 ? 0 : -1;
                n4 = n5 = sajh._c(entityBulletHole.field_70163_u);
                break;
            }
            case 2: 
            case 3: {
                n10 = n == 3 ? -1 : 0;
                n6 = n7 = sajh._c(entityBulletHole.field_70161_v);
                break;
            }
            case 4: 
            case 5: {
                n8 = n == 5 ? -1 : 0;
                n2 = n3 = sajh._c(entityBulletHole.field_70165_t);
                break;
            }
            default: {
                return;
            }
        }
        GL11.glEnable(3042);
        GL11.glPolygonOffset(-5.0f, -5.0f);
        GL11.glEnable(32823);
        iwya._a(iwya._b, 240.0f, 0.0f);
        GL11.glBlendFunc(774, 768);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        xpzm._E()._h._a(this._a);
        GL11.glPushMatrix();
        GL11.glTranslated(d, d2, d3);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        for (int i = n2; i <= n3; ++i) {
            for (int j = n4; j <= n5; ++j) {
                for (int k = n6; k <= n7; ++k) {
                    int n11 = ozlu2.func_72798_a(i + n8, j + n9, k + n10);
                    if (n11 == 0) continue;
                    int n12 = entityBulletHole.atlasRow * 4 + entityBulletHole.field_70157_k % 4;
                    if (entityBulletHole.isKnifeHole) {
                        n12 += 20;
                    }
                    dhji dhji2 = this._b[n12];
                    this._a(twgu.field_71973_m[n11], entityBulletHole.field_70165_t, entityBulletHole.field_70163_u, entityBulletHole.field_70161_v, i, j, k, f3, dhji2, entityBulletHole.sideHit);
                }
            }
        }
        htvf2.func_78381_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2896);
        GL11.glPopMatrix();
        GL11.glBlendFunc(770, 771);
        GL11.glPolygonOffset(0.0f, 0.0f);
        GL11.glDisable(32823);
        GL11.glDisable(3042);
        entityBulletHole.lastRenderedFrame = piuf._c;
    }

    private void _a(twgu twgu2, double d, double d2, double d3, int n, int n2, int n3, float f, dwan dwan2, int n4) {
        htvf htvf2 = htvf.field_78398_a;
        if (twgu2.func_71886_c() || twgu2 == twgu.field_71946_M) {
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            double d7 = 0.0;
            double d8 = 0.0;
            double d9 = 0.0;
            float f2 = 0.5f;
            float f3 = 0.5f;
            switch (n4) {
                case 0: {
                    d4 = Math.max((double)n + twgu2.func_83009_v() - d, (double)(-f));
                    d6 = Math.max((double)n3 + twgu2.func_83005_z() - d3, (double)(-f));
                    d7 = Math.min((double)n + twgu2.func_83007_w() - d, (double)f);
                    d9 = Math.min((double)n3 + twgu2.func_83006_A() - d3, (double)f);
                    float f4 = 0.5f + f2 * (float)d4 / f;
                    float f5 = 0.5f + f2 * (float)d7 / f;
                    float f6 = 0.5f + f3 * (float)d6 / f;
                    float f7 = 0.5f + f3 * (float)d9 / f;
                    f4 = dwan2.func_94214_a(f4 * 16.0f);
                    f5 = dwan2.func_94214_a(f5 * 16.0f);
                    f6 = dwan2.func_94207_b(f6 * 16.0f);
                    f7 = dwan2.func_94207_b(f7 * 16.0f);
                    htvf2.func_78374_a(d7, 0.0, d6, f5, f6);
                    htvf2.func_78374_a(d7, 0.0, d9, f5, f7);
                    htvf2.func_78374_a(d4, 0.0, d9, f4, f7);
                    htvf2.func_78374_a(d4, 0.0, d6, f4, f6);
                    break;
                }
                case 1: {
                    d4 = Math.max((double)n + twgu2.func_83009_v() - d, (double)(-f));
                    d6 = Math.max((double)n3 + twgu2.func_83005_z() - d3, (double)(-f));
                    d7 = Math.min((double)n + twgu2.func_83007_w() - d, (double)f);
                    d9 = Math.min((double)n3 + twgu2.func_83006_A() - d3, (double)f);
                    float f8 = 0.5f + f2 * (float)d4 / f;
                    float f9 = 0.5f + f2 * (float)d7 / f;
                    float f10 = 0.5f + f3 * (float)d6 / f;
                    float f11 = 0.5f + f3 * (float)d9 / f;
                    f8 = dwan2.func_94214_a(f8 * 16.0f);
                    f9 = dwan2.func_94214_a(f9 * 16.0f);
                    f10 = dwan2.func_94207_b(f10 * 16.0f);
                    f11 = dwan2.func_94207_b(f11 * 16.0f);
                    htvf2.func_78374_a(d7, 0.0, d6, f9, f10);
                    htvf2.func_78374_a(d4, 0.0, d6, f8, f10);
                    htvf2.func_78374_a(d4, 0.0, d9, f8, f11);
                    htvf2.func_78374_a(d7, 0.0, d9, f9, f11);
                    break;
                }
                case 2: {
                    d4 = Math.max((double)n + twgu2.func_83009_v() - d, (double)(-f));
                    d5 = Math.max((double)n2 + twgu2.func_83008_x() - d2, (double)(-f));
                    d7 = Math.min((double)n + twgu2.func_83007_w() - d, (double)f);
                    d8 = Math.min((double)n2 + twgu2.func_83010_y() - d2, (double)f);
                    float f12 = 0.5f + f2 * (float)d4 / f;
                    float f13 = 0.5f + f2 * (float)d7 / f;
                    float f14 = 0.5f + f3 * (float)d5 / f;
                    float f15 = 0.5f + f3 * (float)d8 / f;
                    f12 = dwan2.func_94214_a(f12 * 16.0f);
                    f13 = dwan2.func_94214_a(f13 * 16.0f);
                    f14 = dwan2.func_94207_b(f14 * 16.0f);
                    f15 = dwan2.func_94207_b(f15 * 16.0f);
                    htvf2.func_78374_a(d4, d8, 0.0, f12, f15);
                    htvf2.func_78374_a(d7, d8, 0.0, f13, f15);
                    htvf2.func_78374_a(d7, d5, 0.0, f13, f14);
                    htvf2.func_78374_a(d4, d5, 0.0, f12, f14);
                    break;
                }
                case 3: {
                    d4 = Math.max((double)n + twgu2.func_83009_v() - d, (double)(-f));
                    d5 = Math.max((double)n2 + twgu2.func_83008_x() - d2, (double)(-f));
                    d7 = Math.min((double)n + twgu2.func_83007_w() - d, (double)f);
                    d8 = Math.min((double)n2 + twgu2.func_83010_y() - d2, (double)f);
                    float f16 = 0.5f + f2 * (float)d4 / f;
                    float f17 = 0.5f + f2 * (float)d7 / f;
                    float f18 = 0.5f + f3 * (float)d5 / f;
                    float f19 = 0.5f + f3 * (float)d8 / f;
                    f16 = dwan2.func_94214_a(f16 * 16.0f);
                    f17 = dwan2.func_94214_a(f17 * 16.0f);
                    f18 = dwan2.func_94207_b(f18 * 16.0f);
                    f19 = dwan2.func_94207_b(f19 * 16.0f);
                    htvf2.func_78374_a(d4, d8, 0.0, f16, f19);
                    htvf2.func_78374_a(d4, d5, 0.0, f16, f18);
                    htvf2.func_78374_a(d7, d5, 0.0, f17, f18);
                    htvf2.func_78374_a(d7, d8, 0.0, f17, f19);
                    break;
                }
                case 5: {
                    d5 = Math.max((double)n2 + twgu2.func_83008_x() - d2, (double)(-f));
                    d6 = Math.max((double)n3 + twgu2.func_83005_z() - d3, (double)(-f));
                    d8 = Math.min((double)n2 + twgu2.func_83010_y() - d2, (double)f);
                    d9 = Math.min((double)n3 + twgu2.func_83006_A() - d3, (double)f);
                    float f20 = 0.5f + f2 * (float)d9 / f;
                    float f21 = 0.5f + f2 * (float)d6 / f;
                    float f22 = 0.5f + f3 * (float)d5 / f;
                    float f23 = 0.5f + f3 * (float)d8 / f;
                    f20 = dwan2.func_94214_a(f20 * 16.0f);
                    f21 = dwan2.func_94214_a(f21 * 16.0f);
                    f22 = dwan2.func_94207_b(f22 * 16.0f);
                    f23 = dwan2.func_94207_b(f23 * 16.0f);
                    htvf2.func_78374_a(0.0, d8, d9, f20, f23);
                    htvf2.func_78374_a(0.0, d5, d9, f20, f22);
                    htvf2.func_78374_a(0.0, d5, d6, f21, f22);
                    htvf2.func_78374_a(0.0, d8, d6, f21, f23);
                    break;
                }
                case 4: {
                    d5 = Math.max((double)n2 + twgu2.func_83008_x() - d2, (double)(-f));
                    d6 = Math.max((double)n3 + twgu2.func_83005_z() - d3, (double)(-f));
                    d8 = Math.min((double)n2 + twgu2.func_83010_y() - d2, (double)f);
                    d9 = Math.min((double)n3 + twgu2.func_83006_A() - d3, (double)f);
                    float f24 = 0.5f + f2 * (float)d9 / f;
                    float f25 = 0.5f + f2 * (float)d6 / f;
                    float f26 = 0.5f + f3 * (float)d5 / f;
                    float f27 = 0.5f + f3 * (float)d8 / f;
                    f24 = dwan2.func_94214_a(f24 * 16.0f);
                    f25 = dwan2.func_94214_a(f25 * 16.0f);
                    f26 = dwan2.func_94207_b(f26 * 16.0f);
                    f27 = dwan2.func_94207_b(f27 * 16.0f);
                    htvf2.func_78374_a(0.0, d8, d9, f24, f27);
                    htvf2.func_78374_a(0.0, d8, d6, f25, f27);
                    htvf2.func_78374_a(0.0, d5, d6, f25, f26);
                    htvf2.func_78374_a(0.0, d5, d9, f24, f26);
                    break;
                }
                default: {
                    throw new RuntimeException("Invalid side!");
                }
            }
        }
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBulletHole)entity, d, d2, d3, f, f2);
    }

    @Override
    protected ResourceLocation func_110775_a(Entity entity) {
        return null;
    }
}

