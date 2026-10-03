/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part.tails;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import noppes.npcs.client.model.ModelMPM;

public class ModelSquirrelTail
extends ModelRenderer {
    private ModelMPM base;

    public ModelSquirrelTail(ModelMPM modelMPM) {
        super(modelMPM);
        this.base = modelMPM;
        this.textureWidth = 64.0f;
        this.textureHeight = 32.0f;
        ModelRenderer modelRenderer = new ModelRenderer(modelMPM, 0, 0);
        modelRenderer.addBox(-1.0f, -1.0f, -1.0f, 2, 2, 3);
        modelRenderer.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.setRotation(modelRenderer, 0.0f, 0.0f, 0.0f);
        this.addChild(modelRenderer);
        ModelRenderer modelRenderer2 = new ModelRenderer(modelMPM, 0, 9);
        modelRenderer2.addBox(-2.0f, -5.0f, -1.0f, 4, 5, 3);
        modelRenderer2.setRotationPoint(0.0f, 0.0f, 1.0f);
        this.setRotation(modelRenderer2, -0.37f, 0.0f, 0.0f);
        modelRenderer.addChild(modelRenderer2);
        ModelRenderer modelRenderer3 = new ModelRenderer(modelMPM, 0, 18);
        modelRenderer3.addBox(-2.466667f, -6.0f, -1.0f, 5, 7, 3);
        modelRenderer3.setRotationPoint(0.0f, -5.0f, 0.0f);
        this.setRotation(modelRenderer3, 0.3f, 0.0f, 0.0f);
        modelRenderer2.addChild(modelRenderer3);
        ModelRenderer modelRenderer4 = new ModelRenderer(modelMPM, 25, 0);
        modelRenderer4.addBox(-3.0f, -0.6f, -1.0f, 6, 5, 3);
        modelRenderer4.setRotationPoint(0.0f, -5.0f, 1.0f);
        this.setRotation(modelRenderer4, 2.5f, 0.0f, 0.0f);
        modelRenderer3.addChild(modelRenderer4);
        ModelRenderer modelRenderer5 = new ModelRenderer(modelMPM, 25, 10);
        modelRenderer5.addBox(-3.0f, -2.0f, -1.0f, 6, 3, 5);
        modelRenderer5.setRotationPoint(0.0f, 3.5f, 0.0f);
        this.setRotation(modelRenderer5, -2.5f, 0.0f, 0.0f);
        modelRenderer4.addChild(modelRenderer5);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.rotateAngleX = f;
        modelRenderer.rotateAngleY = f2;
        modelRenderer.rotateAngleZ = f3;
    }
}

