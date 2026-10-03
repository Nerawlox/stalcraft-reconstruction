/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part.legs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import noppes.npcs.client.model.util.ModelPlaneRenderer;
import org.lwjgl.opengl.GL11;

public class ModelNagaLegs
extends ModelRenderer {
    public boolean isRiding = false;
    public boolean isSneaking = false;
    public boolean isSleeping = false;
    public boolean isCrawling = false;
    private ModelRenderer nagaPart1;
    private ModelRenderer nagaPart2;
    private ModelRenderer nagaPart3;
    private ModelRenderer nagaPart4;
    private ModelRenderer nagaPart5;

    public ModelNagaLegs(ModelBase modelBase) {
        super(modelBase);
        this.nagaPart1 = new ModelRenderer(modelBase, 0, 0);
        ModelRenderer modelRenderer = new ModelRenderer(modelBase, 0, 16);
        modelRenderer.func_78789_a(0.0f, -2.0f, -2.0f, 4, 4, 4);
        modelRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        this.nagaPart1.func_78792_a(modelRenderer);
        modelRenderer = new ModelRenderer(modelBase, 0, 16);
        modelRenderer.field_78809_i = true;
        modelRenderer.func_78789_a(0.0f, -2.0f, -2.0f, 4, 4, 4);
        this.nagaPart1.func_78792_a(modelRenderer);
        this.nagaPart2 = new ModelRenderer(modelBase, 0, 0);
        this.nagaPart2.field_78805_m = this.nagaPart1.field_78805_m;
        this.nagaPart3 = new ModelRenderer(modelBase, 0, 0);
        ModelPlaneRenderer modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 4, 24);
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 0.0f, 4, 4);
        modelPlaneRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        this.nagaPart3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 4, 24);
        modelPlaneRenderer.field_78809_i = true;
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 0.0f, 4, 4);
        this.nagaPart3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 8, 24);
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 6.0f, 4, 4);
        modelPlaneRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        this.nagaPart3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 8, 24);
        modelPlaneRenderer.field_78809_i = true;
        modelPlaneRenderer.addBackPlane(0.0f, -2.0f, 6.0f, 4, 4);
        this.nagaPart3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 4, 26);
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, -6.0f, 4, 6);
        modelPlaneRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        modelPlaneRenderer.field_78795_f = (float)Math.PI;
        this.nagaPart3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 4, 26);
        modelPlaneRenderer.field_78809_i = true;
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, -6.0f, 4, 6);
        modelPlaneRenderer.field_78795_f = (float)Math.PI;
        this.nagaPart3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 8, 26);
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, 0.0f, 4, 6);
        modelPlaneRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        this.nagaPart3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 8, 26);
        modelPlaneRenderer.field_78809_i = true;
        modelPlaneRenderer.addTopPlane(0.0f, -2.0f, 0.0f, 4, 6);
        this.nagaPart3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 0, 26);
        modelPlaneRenderer.field_78795_f = 1.5707964f;
        modelPlaneRenderer.addSidePlane(0.0f, 0.0f, -2.0f, 6, 4);
        modelPlaneRenderer.func_78793_a(-4.0f, 0.0f, 0.0f);
        this.nagaPart3.func_78792_a(modelPlaneRenderer);
        modelPlaneRenderer = new ModelPlaneRenderer(modelBase, 0, 26);
        modelPlaneRenderer.field_78795_f = 1.5707964f;
        modelPlaneRenderer.addSidePlane(4.0f, 0.0f, -2.0f, 6, 4);
        this.nagaPart3.func_78792_a(modelPlaneRenderer);
        this.nagaPart4 = new ModelRenderer(modelBase, 0, 0);
        this.nagaPart4.field_78805_m = this.nagaPart3.field_78805_m;
        this.nagaPart5 = new ModelRenderer(modelBase, 0, 0);
        modelRenderer = new ModelRenderer(modelBase, 56, 20);
        modelRenderer.func_78789_a(0.0f, 0.0f, -2.0f, 2, 5, 2);
        modelRenderer.func_78793_a(-2.0f, 0.0f, 0.0f);
        modelRenderer.field_78795_f = 1.5707964f;
        this.nagaPart5.func_78792_a(modelRenderer);
        modelRenderer = new ModelRenderer(modelBase, 56, 20);
        modelRenderer.field_78809_i = true;
        modelRenderer.func_78789_a(0.0f, 0.0f, -2.0f, 2, 5, 2);
        modelRenderer.field_78795_f = 1.5707964f;
        this.nagaPart5.func_78792_a(modelRenderer);
        this.func_78792_a(this.nagaPart1);
        this.func_78792_a(this.nagaPart2);
        this.func_78792_a(this.nagaPart3);
        this.func_78792_a(this.nagaPart4);
        this.func_78792_a(this.nagaPart5);
        this.nagaPart1.func_78793_a(0.0f, 14.0f, 0.0f);
        this.nagaPart2.func_78793_a(0.0f, 18.0f, 0.6f);
        this.nagaPart3.func_78793_a(0.0f, 22.0f, -0.3f);
        this.nagaPart4.func_78793_a(0.0f, 22.0f, 5.0f);
        this.nagaPart5.func_78793_a(0.0f, 22.0f, 10.0f);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.nagaPart1.field_78796_g = sajh._b(f * 0.6662f) * 0.26f * f2;
        this.nagaPart2.field_78796_g = sajh._b(f * 0.6662f) * 0.5f * f2;
        this.nagaPart3.field_78796_g = sajh._b(f * 0.6662f) * 0.26f * f2;
        this.nagaPart4.field_78796_g = -sajh._b(f * 0.6662f) * 0.16f * f2;
        this.nagaPart5.field_78796_g = -sajh._b(f * 0.6662f) * 0.3f * f2;
        this.nagaPart1.func_78793_a(0.0f, 14.0f, 0.0f);
        this.nagaPart2.func_78793_a(0.0f, 18.0f, 0.6f);
        this.nagaPart3.func_78793_a(0.0f, 22.0f, -0.3f);
        this.nagaPart4.func_78793_a(0.0f, 22.0f, 5.0f);
        this.nagaPart5.func_78793_a(0.0f, 22.0f, 10.0f);
        this.nagaPart1.field_78795_f = 0.0f;
        this.nagaPart2.field_78795_f = 0.0f;
        this.nagaPart3.field_78795_f = 0.0f;
        this.nagaPart4.field_78795_f = 0.0f;
        this.nagaPart5.field_78795_f = 0.0f;
        if (this.isSleeping || this.isCrawling) {
            this.nagaPart3.field_78795_f = -1.5707964f;
            this.nagaPart4.field_78795_f = -1.5707964f;
            this.nagaPart5.field_78795_f = -1.5707964f;
            this.nagaPart3.field_78797_d -= 2.0f;
            this.nagaPart3.field_78798_e = 0.9f;
            this.nagaPart4.field_78797_d += 4.0f;
            this.nagaPart4.field_78798_e = 0.9f;
            this.nagaPart5.field_78797_d += 7.0f;
            this.nagaPart5.field_78798_e = 2.9f;
        }
        if (this.isRiding) {
            this.nagaPart1.field_78797_d -= 1.0f;
            this.nagaPart1.field_78795_f = -0.19634955f;
            this.nagaPart1.field_78798_e = -1.0f;
            this.nagaPart2.field_78797_d -= 4.0f;
            this.nagaPart2.field_78798_e = -1.0f;
            this.nagaPart3.field_78797_d -= 9.0f;
            this.nagaPart3.field_78798_e -= 1.0f;
            this.nagaPart4.field_78797_d -= 13.0f;
            this.nagaPart4.field_78798_e -= 1.0f;
            this.nagaPart5.field_78797_d -= 9.0f;
            this.nagaPart5.field_78798_e -= 1.0f;
            if (this.isSneaking) {
                this.nagaPart1.field_78798_e += 5.0f;
                this.nagaPart3.field_78798_e += 5.0f;
                this.nagaPart4.field_78798_e += 5.0f;
                this.nagaPart5.field_78798_e += 4.0f;
                this.nagaPart1.field_78797_d -= 1.0f;
                this.nagaPart2.field_78797_d -= 1.0f;
                this.nagaPart3.field_78797_d -= 1.0f;
                this.nagaPart4.field_78797_d -= 1.0f;
                this.nagaPart5.field_78797_d -= 1.0f;
            }
        } else if (this.isSneaking) {
            this.nagaPart1.field_78797_d -= 1.0f;
            this.nagaPart2.field_78797_d -= 1.0f;
            this.nagaPart3.field_78797_d -= 1.0f;
            this.nagaPart4.field_78797_d -= 1.0f;
            this.nagaPart5.field_78797_d -= 1.0f;
            this.nagaPart1.field_78798_e = 5.0f;
            this.nagaPart2.field_78798_e = 3.0f;
        }
    }

    @Override
    public void func_78785_a(float f) {
        if (!this.field_78807_k && this.field_78806_j) {
            this.nagaPart1.func_78785_a(f);
            this.nagaPart3.func_78785_a(f);
            if (!this.isRiding) {
                this.nagaPart2.func_78785_a(f);
            }
            GL11.glPushMatrix();
            GL11.glScalef(0.74f, 0.7f, 0.85f);
            GL11.glTranslatef(this.nagaPart3.field_78796_g, 0.66f, 0.06f);
            this.nagaPart4.func_78785_a(f);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(this.nagaPart3.field_78796_g + this.nagaPart4.field_78796_g, 0.0f, 0.0f);
            this.nagaPart5.func_78785_a(f);
            GL11.glPopMatrix();
        }
    }
}

