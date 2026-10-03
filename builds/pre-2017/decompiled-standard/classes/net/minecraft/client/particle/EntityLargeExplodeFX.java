/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class EntityLargeExplodeFX
extends EntityFX {
    public static final ResourceLocation field_110127_a = new ResourceLocation("textures/entity/explosion.png");
    public int field_70581_a;
    public int field_70584_aq;
    public apbu field_70583_ar;
    public float field_70582_as;

    public EntityLargeExplodeFX(apbu apbu2, ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70583_ar = apbu2;
        this.field_70584_aq = 6 + this.field_70146_Z.nextInt(4);
        this.field_70553_i = this.field_70551_j = this.field_70146_Z.nextFloat() * 0.6f + 0.4f;
        this.field_70552_h = this.field_70551_j;
        this.field_70582_as = 1.0f - (float)d4 * 0.5f;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        int n = (int)(((float)this.field_70581_a + f) * 15.0f / (float)this.field_70584_aq);
        if (n > 15) {
            return;
        }
        this.field_70583_ar._a(field_110127_a);
        float f7 = (float)(n % 4) / 4.0f;
        float f8 = f7 + 0.24975f;
        float f9 = (float)(n / 4) / 4.0f;
        float f10 = f9 + 0.24975f;
        float f11 = 2.0f * this.field_70582_as;
        float f12 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)f - field_70556_an);
        float f13 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f - field_70554_ao);
        float f14 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)f - field_70555_ap);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        qnon._a();
        htvf2.func_78382_b();
        htvf2.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, 1.0f);
        htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
        htvf2.func_78380_c(240);
        htvf2.func_78374_a(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f8, f10);
        htvf2.func_78374_a(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11, f14 - f4 * f11 + f6 * f11, f8, f9);
        htvf2.func_78374_a(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f7, f9);
        htvf2.func_78374_a(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11, f14 + f4 * f11 - f6 * f11, f7, f10);
        htvf2.func_78381_a();
        GL11.glPolygonOffset(0.0f, 0.0f);
        GL11.glEnable(2896);
    }

    @Override
    public int func_70070_b(float f) {
        return 61680;
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        ++this.field_70581_a;
        if (this.field_70581_a == this.field_70584_aq) {
            this.func_70106_y();
        }
    }

    @Override
    public int func_70537_b() {
        return 3;
    }
}

