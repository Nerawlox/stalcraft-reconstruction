/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class EntityFootStepFX
extends EntityFX {
    public static final ResourceLocation field_110126_a = new ResourceLocation("textures/particle/footprint.png");
    public int field_70576_a;
    public int field_70578_aq;
    public apbu field_70577_ar;

    public EntityFootStepFX(apbu apbu2, ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70577_ar = apbu2;
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.field_70159_w = 0.0;
        this.field_70578_aq = 200;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8 = ((float)this.field_70576_a + f) / (float)this.field_70578_aq;
        if ((f7 = 2.0f - (f8 *= f8) * 2.0f) > 1.0f) {
            f7 = 1.0f;
        }
        f7 *= 0.2f;
        GL11.glDisable(2896);
        float f9 = 0.125f;
        float f10 = (float)(this.field_70165_t - field_70556_an);
        float f11 = (float)(this.field_70163_u - field_70554_ao);
        float f12 = (float)(this.field_70161_v - field_70555_ap);
        float f13 = this.field_70170_p.func_72801_o(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v));
        this.field_70577_ar._a(field_110126_a);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        htvf2.func_78382_b();
        htvf2.func_78369_a(f13, f13, f13, f7);
        htvf2.func_78374_a(f10 - f9, f11, f12 + f9, 0.0, 1.0);
        htvf2.func_78374_a(f10 + f9, f11, f12 + f9, 1.0, 1.0);
        htvf2.func_78374_a(f10 + f9, f11, f12 - f9, 1.0, 0.0);
        htvf2.func_78374_a(f10 - f9, f11, f12 - f9, 0.0, 0.0);
        htvf2.func_78381_a();
        GL11.glDisable(3042);
        GL11.glEnable(2896);
    }

    @Override
    public void func_70071_h_() {
        ++this.field_70576_a;
        if (this.field_70576_a == this.field_70578_aq) {
            this.func_70106_y();
        }
    }

    @Override
    public int func_70537_b() {
        return 3;
    }
}

