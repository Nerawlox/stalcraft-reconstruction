/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;
import noppes.npcs.client.model.ModelNPCMale;
import noppes.npcs.client.model.util.ModelPlaneRenderer;
import org.lwjgl.opengl.GL11;

public class ModelNagaMale
extends ModelNPCMale {
    ModelRenderer leg;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer leg5;

    public ModelNagaMale(int n, int n2, float f) {
        super(n, n2, f);
    }

    @Override
    public void init(float f, float f2) {
        super.init(f, f2);
        this.bipedRightLeg = new ModelRenderer(this, 0, 0);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 0);
        this.leg = new ModelRenderer(this, 0, 0);
        ModelRenderer modelRenderer = new ModelRenderer(this, 0, 16);
        modelRenderer.func_78789_a(0.0f, -2.0f, -2.0f, 4, 4, 4);
        modelRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        this.leg.func_78792_a(modelRenderer);
        modelRenderer = new ModelRenderer(this, 0, 16);
        modelRenderer.field_78809_i = true;
        modelRenderer.func_78789_a(0.0f, -2.0f, -2.0f, 4, 4, 4);
        this.leg.func_78792_a(modelRenderer);
        this.leg2 = new ModelRenderer(this, 0, 0);
        this.leg2.field_78805_m = this.leg.field_78805_m;
        this.leg3 = new ModelRenderer(this, 0, 0);
        ModelPlaneRenderer modelPlaneRenderer = new ModelPlaneRenderer(this, 4, 24);
        modelPlaneRenderer.func_78787_b(this.field_78090_t, this.field_78089_u);
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 0.0f, 4, 4);
        modelPlaneRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        this.leg3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 4, 24);
        modelPlaneRenderer.func_78787_b(this.field_78090_t, this.field_78089_u);
        modelPlaneRenderer.field_78809_i = true;
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 0.0f, 4, 4);
        this.leg3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 8, 24);
        modelPlaneRenderer.func_78787_b(this.field_78090_t, this.field_78089_u);
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 6.0f, 4, 4);
        modelPlaneRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        this.leg3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 8, 24);
        modelPlaneRenderer.func_78787_b(this.field_78090_t, this.field_78089_u);
        modelPlaneRenderer.field_78809_i = true;
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 6.0f, 4, 4);
        this.leg3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 4, 26);
        modelPlaneRenderer.func_78787_b(this.field_78090_t, this.field_78089_u);
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, -6.0f, 4, 6);
        modelPlaneRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        modelPlaneRenderer.field_78795_f = (float)Math.PI;
        this.leg3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 4, 26);
        modelPlaneRenderer.func_78787_b(this.field_78090_t, this.field_78089_u);
        modelPlaneRenderer.field_78809_i = true;
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, -6.0f, 4, 6);
        modelPlaneRenderer.field_78795_f = (float)Math.PI;
        this.leg3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 8, 26);
        modelPlaneRenderer.func_78787_b(this.field_78090_t, this.field_78089_u);
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, 0.0f, 4, 6);
        modelPlaneRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        this.leg3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 8, 26);
        modelPlaneRenderer.func_78787_b(this.field_78090_t, this.field_78089_u);
        modelPlaneRenderer.field_78809_i = true;
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, 0.0f, 4, 6);
        this.leg3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 0, 26);
        modelPlaneRenderer.func_78787_b(this.field_78090_t, this.field_78089_u);
        modelPlaneRenderer.field_78795_f = 1.5707964f;
        modelPlaneRenderer.addSidePlane(0.0f, 0.0f, -2.0f, 6, 4);
        modelPlaneRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        this.leg3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(this, 0, 26);
        modelPlaneRenderer.func_78787_b(this.field_78090_t, this.field_78089_u);
        modelPlaneRenderer.field_78795_f = 1.5707964f;
        modelPlaneRenderer.addSidePlane(4.0f, 0.0f, -2.0f, 6, 4);
        this.leg3.func_78792_a(modelPlaneRenderer);
        this.leg4 = new ModelRenderer(this, 0, 0);
        this.leg4.func_78787_b(this.field_78090_t, this.field_78089_u);
        this.leg4.field_78805_m = this.leg3.field_78805_m;
        this.leg5 = new ModelRenderer(this, 0, 0);
        modelRenderer = new ModelRenderer(this, 56, 20);
        modelRenderer.func_78789_a(0.0f, 0.0f, -2.0f, 2, 5, 2);
        modelRenderer.func_78793_a(-2.0f, 0.0f, 0.0f);
        modelRenderer.field_78795_f = 1.5707964f;
        this.leg5.func_78792_a(modelRenderer);
        modelRenderer = new ModelRenderer(this, 56, 20);
        modelRenderer.field_78809_i = true;
        modelRenderer.func_78789_a(0.0f, 0.0f, -2.0f, 2, 5, 2);
        modelRenderer.field_78795_f = 1.5707964f;
        this.leg5.func_78792_a(modelRenderer);
        this.defaultRotation();
        if (this.field_78089_u != 32) {
            ModelRenderer modelRenderer2 = new ModelRenderer(this, 0, 32);
            modelRenderer2.func_78789_a(0.0f, 0.0f, 0.0f, 4, 3, 3);
            modelRenderer2.func_78793_a(-2.0f, -3.0f, -7.0f);
            this.bipedHead.func_78792_a(modelRenderer2);
            ModelRenderer modelRenderer3 = new ModelRenderer(this, 0, 38);
            modelRenderer3.func_78789_a(0.0f, 0.0f, 0.0f, 4, 3, 1);
            modelRenderer3.func_78793_a(-2.0f, -3.0f, -5.0f);
            this.bipedHead.func_78792_a(modelRenderer3);
            ModelPlaneRenderer modelPlaneRenderer2 = new ModelPlaneRenderer(this, 14, 32);
            modelPlaneRenderer2.func_78787_b(64, 64);
            modelPlaneRenderer2.addSidePlane(0.0f, -12.0f, -1.0f, 9, 9);
            this.bipedHead.func_78792_a(modelPlaneRenderer2);
            ModelPlaneRenderer modelPlaneRenderer3 = new ModelPlaneRenderer(this, 23, 32);
            modelPlaneRenderer3.func_78787_b(64, 64);
            modelPlaneRenderer3.addSidePlane(0.0f, 0.0f, 2.0f, 12, 7);
            this.bipedBody.func_78792_a(modelPlaneRenderer3);
        }
    }

    private void defaultRotation() {
        this.leg.func_78793_a(0.0f, 14.0f, 0.0f);
        this.leg2.func_78793_a(0.0f, 18.0f, 0.6f);
        this.leg3.func_78793_a(0.0f, 22.0f, -0.3f);
        this.leg4.func_78793_a(0.0f, 22.0f, 5.0f);
        this.leg5.func_78793_a(0.0f, 22.0f, 10.0f);
        this.leg.field_78795_f = 0.0f;
        this.leg2.field_78795_f = 0.0f;
        this.leg3.field_78795_f = 0.0f;
        this.leg4.field_78795_f = 0.0f;
        this.leg5.field_78795_f = 0.0f;
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_78088_a(entity, f, f2, f3, f4, f5, f6);
        this.leg.func_78785_a(f6);
        this.leg3.func_78785_a(f6);
        if (!this.field_78093_q) {
            this.leg2.func_78785_a(f6);
        }
        GL11.glPushMatrix();
        GL11.glScalef(0.64f, 0.7f, 0.85f);
        GL11.glTranslatef(this.leg3.field_78796_g, 0.66f, 0.06f);
        this.leg4.func_78785_a(f6);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.leg3.field_78796_g + this.leg4.field_78796_g, 0.0f, 0.0f);
        this.leg5.func_78785_a(f6);
        GL11.glPopMatrix();
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.func_78086_a(entityLivingBase, f, f2, f3);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6);
        this.leg.field_78796_g = sajh._b(f * 0.6662f) * 0.26f * f2;
        this.leg2.field_78796_g = sajh._b(f * 0.6662f) * 0.5f * f2;
        this.leg3.field_78796_g = sajh._b(f * 0.6662f) * 0.26f * f2;
        this.leg4.field_78796_g = -sajh._b(f * 0.6662f) * 0.16f * f2;
        this.leg5.field_78796_g = -sajh._b(f * 0.6662f) * 0.3f * f2;
        this.defaultRotation();
        if (this.isSleeping) {
            this.leg3.field_78795_f = -1.5707964f;
            this.leg4.field_78795_f = -1.5707964f;
            this.leg5.field_78795_f = -1.5707964f;
            this.leg3.field_78797_d -= 2.0f;
            this.leg3.field_78798_e = 0.9f;
            this.leg4.field_78797_d += 4.0f;
            this.leg4.field_78798_e = 0.9f;
            this.leg5.field_78797_d += 7.0f;
            this.leg5.field_78798_e = 2.9f;
        }
        if (this.field_78093_q) {
            this.leg.field_78797_d -= 1.0f;
            this.leg.field_78795_f = -0.19634955f;
            this.leg.field_78798_e = -1.0f;
            this.leg2.field_78797_d -= 4.0f;
            this.leg2.field_78798_e = -1.0f;
            this.leg3.field_78797_d -= 9.0f;
            this.leg3.field_78798_e -= 1.0f;
            this.leg4.field_78797_d -= 13.0f;
            this.leg4.field_78798_e -= 1.0f;
            this.leg5.field_78797_d -= 9.0f;
            this.leg5.field_78798_e -= 1.0f;
            if (this.isSneak) {
                this.leg.field_78798_e += 5.0f;
                this.leg3.field_78798_e += 5.0f;
                this.leg4.field_78798_e += 5.0f;
                this.leg5.field_78798_e += 4.0f;
                this.leg.field_78797_d -= 1.0f;
                this.leg2.field_78797_d -= 1.0f;
                this.leg3.field_78797_d -= 1.0f;
                this.leg4.field_78797_d -= 1.0f;
                this.leg5.field_78797_d -= 1.0f;
            }
        } else if (this.isSneak) {
            this.leg.field_78797_d -= 1.0f;
            this.leg2.field_78797_d -= 1.0f;
            this.leg3.field_78797_d -= 1.0f;
            this.leg4.field_78797_d -= 1.0f;
            this.leg5.field_78797_d -= 1.0f;
            this.leg.field_78798_e = 5.0f;
            this.leg2.field_78798_e = 3.0f;
        }
    }
}

