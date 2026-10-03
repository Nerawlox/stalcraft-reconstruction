/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.hank;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class kjui {
    public static final ResourceLocation _a = new ResourceLocation("textures/particle/particles.png");
    public ozlu _b;
    public List[] _c = new List[4];
    public apbu _d;
    public Random _e = new Random();

    public kjui(ozlu ozlu2, apbu apbu2) {
        if (ozlu2 != null) {
            this._b = ozlu2;
        }
        this._d = apbu2;
        for (int i = 0; i < 4; ++i) {
            this._c[i] = new ArrayList();
        }
    }

    public void _a(EntityFX entityFX) {
        int n = entityFX.func_70537_b();
        if (this._c[n].size() >= 4000) {
            this._c[n].remove(0);
        }
        this._c[n].add(entityFX);
    }

    public void _a() {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < this._c[i].size(); ++j) {
                EntityFX entityFX = (EntityFX)this._c[i].get(j);
                if (entityFX != null) {
                    entityFX.func_70071_h_();
                }
                if (entityFX != null && !entityFX.field_70128_L) continue;
                this._c[i].remove(j--);
            }
        }
    }

    public void _a(Entity entity, float f) {
        float f2 = tfss._h;
        float f3 = tfss._j;
        float f4 = tfss._k;
        float f5 = tfss._l;
        float f6 = tfss._i;
        EntityFX.field_70556_an = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * (double)f;
        EntityFX.field_70554_ao = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * (double)f;
        EntityFX.field_70555_ap = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * (double)f;
        for (int i = 0; i < 3; ++i) {
            if (this._c[i].isEmpty()) continue;
            switch (i) {
                default: {
                    this._d._a(_a);
                    break;
                }
                case 1: {
                    this._d._a(sctd._c);
                    break;
                }
                case 2: {
                    this._d._a(sctd._e);
                }
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDepthMask(false);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.003921569f);
            htvf htvf2 = htvf.field_78398_a;
            htvf2.func_78382_b();
            for (int j = 0; j < this._c[i].size(); ++j) {
                EntityFX entityFX = (EntityFX)this._c[i].get(j);
                if (entityFX == null) continue;
                htvf2.func_78380_c(entityFX.func_70070_b(f));
                entityFX.func_70539_a(htvf2, f, f2, f6, f3, f4, f5);
            }
            htvf2.func_78381_a();
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            GL11.glAlphaFunc(516, 0.1f);
        }
    }

    public void _b(Entity entity, float f) {
        float f2 = (float)Math.PI / 180;
        float f3 = sajh._b(entity.field_70177_z * ((float)Math.PI / 180));
        float f4 = sajh._a(entity.field_70177_z * ((float)Math.PI / 180));
        float f5 = -f4 * sajh._a(entity.field_70125_A * ((float)Math.PI / 180));
        float f6 = f3 * sajh._a(entity.field_70125_A * ((float)Math.PI / 180));
        float f7 = sajh._b(entity.field_70125_A * ((float)Math.PI / 180));
        int n = 3;
        List list = this._c[n];
        if (!list.isEmpty()) {
            htvf htvf2 = htvf.field_78398_a;
            for (int i = 0; i < list.size(); ++i) {
                EntityFX entityFX = (EntityFX)list.get(i);
                if (entityFX == null) continue;
                htvf2.func_78380_c(entityFX.func_70070_b(f));
                entityFX.func_70539_a(htvf2, f, f3, f7, f4, f5, f6);
            }
        }
    }

    public void _a(ozlu ozlu2) {
        this._b = ozlu2;
        for (int i = 0; i < 4; ++i) {
            this._c[i].clear();
        }
    }

    public void _a(int n, int n2, int n3, int n4, int n5) {
        twgu twgu2 = twgu.field_71973_m[n4];
        if (twgu2 != null && !twgu2.addBlockDestroyEffects(this._b, n, n2, n3, n5, this)) {
            int n6 = 4;
            for (int i = 0; i < n6; ++i) {
                for (int j = 0; j < n6; ++j) {
                    for (int k = 0; k < n6; ++k) {
                        double d = (double)n + ((double)i + 0.5) / (double)n6;
                        double d2 = (double)n2 + ((double)j + 0.5) / (double)n6;
                        double d3 = (double)n3 + ((double)k + 0.5) / (double)n6;
                        this._a(new EntityDiggingFX(this._b, d, d2, d3, d - (double)n - 0.5, d2 - (double)n2 - 0.5, d3 - (double)n3 - 0.5, twgu2, n5).func_70596_a(n, n2, n3));
                    }
                }
            }
        }
    }

    public void _a(int n, int n2, int n3, int n4) {
        int n5 = this._b.func_72798_a(n, n2, n3);
        if (n5 != 0) {
            twgu twgu2 = twgu.field_71973_m[n5];
            float f = 0.1f;
            double d = (double)n + this._e.nextDouble() * (twgu2.func_83007_w() - twgu2.func_83009_v() - (double)(f * 2.0f)) + (double)f + twgu2.func_83009_v();
            double d2 = (double)n2 + this._e.nextDouble() * (twgu2.func_83010_y() - twgu2.func_83008_x() - (double)(f * 2.0f)) + (double)f + twgu2.func_83008_x();
            double d3 = (double)n3 + this._e.nextDouble() * (twgu2.func_83006_A() - twgu2.func_83005_z() - (double)(f * 2.0f)) + (double)f + twgu2.func_83005_z();
            if (n4 == 0) {
                d2 = (double)n2 + twgu2.func_83008_x() - (double)f;
            }
            if (n4 == 1) {
                d2 = (double)n2 + twgu2.func_83010_y() + (double)f;
            }
            if (n4 == 2) {
                d3 = (double)n3 + twgu2.func_83005_z() - (double)f;
            }
            if (n4 == 3) {
                d3 = (double)n3 + twgu2.func_83006_A() + (double)f;
            }
            if (n4 == 4) {
                d = (double)n + twgu2.func_83009_v() - (double)f;
            }
            if (n4 == 5) {
                d = (double)n + twgu2.func_83007_w() + (double)f;
            }
            this._a(new EntityDiggingFX(this._b, d, d2, d3, 0.0, 0.0, 0.0, twgu2, this._b.func_72805_g(n, n2, n3)).func_70596_a(n, n2, n3).func_70543_e(0.2f).func_70541_f(0.6f));
        }
    }

    public String _b() {
        return "" + (this._c[0].size() + this._c[1].size() + this._c[2].size());
    }

    public void _a(int n, int n2, int n3, hank hank2) {
        twgu twgu2 = twgu.field_71973_m[this._b.func_72798_a(n, n2, n3)];
        if (twgu2 != null && !twgu2.addBlockHitEffects(this._b, hank2, this)) {
            this._a(n, n2, n3, hank2._g);
        }
    }
}

