/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import noppes.npcs.client.model.ModelNPCMale;
import noppes.npcs.client.model.util.ModelPlaneRenderer;
import org.lwjgl.opengl.GL11;

public class ModelNPCFemale
extends ModelNPCMale {
    public ModelRenderer Breasts;

    public ModelNPCFemale(float f) {
        super(f);
    }

    public ModelNPCFemale(int n, int n2, float f) {
        super(n, n2, f);
    }

    @Override
    public void init(float f, float f2) {
        super.init(f, f2);
        this.Breasts = new ModelRenderer(this, 24, 0);
        this.Breasts.func_78790_a(0.0f, 0.0f, 0.0f, 7, 3, 1, 0.0f);
        this.Breasts.func_78793_a(-3.5f, 1.8f, -2.85f);
        ModelPlaneRenderer modelPlaneRenderer = new ModelPlaneRenderer(this, 56, 0);
        modelPlaneRenderer.addTopPlane(0.0f, 0.0f, 0.0f, 7, 1, f);
        this.Breasts.func_78792_a(modelPlaneRenderer);
        ModelPlaneRenderer modelPlaneRenderer2 = new ModelPlaneRenderer(this, 56, 1);
        modelPlaneRenderer2.addBackPlane(0.0f, 0.0f, 0.0f, 7, 3, f);
        this.Breasts.func_78792_a(modelPlaneRenderer2);
        ModelPlaneRenderer modelPlaneRenderer3 = new ModelPlaneRenderer(this, 56, 4);
        modelPlaneRenderer3.addTopPlane(0.0f, -3.0f, -1.0f, 7, 1, f);
        modelPlaneRenderer3.field_78795_f = (float)Math.PI;
        this.Breasts.func_78792_a(modelPlaneRenderer3);
        ModelPlaneRenderer modelPlaneRenderer4 = new ModelPlaneRenderer(this, 63, 0);
        modelPlaneRenderer4.addSidePlane(0.0f, 0.0f, 0.0f, 3, 1, f);
        this.Breasts.func_78792_a(modelPlaneRenderer4);
        ModelPlaneRenderer modelPlaneRenderer5 = new ModelPlaneRenderer(this, 63, 3);
        modelPlaneRenderer5.addSidePlane(-7.0f, 0.0f, -1.0f, 3, 1, f);
        modelPlaneRenderer5.field_78796_g = (float)Math.PI;
        this.Breasts.func_78792_a(modelPlaneRenderer5);
        this.bipedBody.func_78792_a(this.Breasts);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6);
        float f7 = 0.85f;
        GL11.glPushMatrix();
        GL11.glScalef(f7, f7, f7);
        GL11.glTranslatef(0.0f, -0.015f, 0.0f);
        this.renderHead(entity, f6);
        GL11.glPopMatrix();
        f7 = 0.8f;
        GL11.glPushMatrix();
        GL11.glScalef(f7, 0.96f, f7);
        GL11.glTranslatef(0.07f, 0.0f, 0.0f);
        this.renderLeftArm(entity, f6);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(f7, 0.96f, f7);
        GL11.glTranslatef(-0.07f, 0.0f, 0.0f);
        this.renderRightArm(entity, f6);
        GL11.glPopMatrix();
        this.renderLegs(entity, f6);
        this.renderBody(entity, f6);
    }
}

