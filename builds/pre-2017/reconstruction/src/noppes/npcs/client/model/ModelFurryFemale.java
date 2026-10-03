/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelRenderer;
import noppes.npcs.client.model.ModelNPCFemale;

public class ModelFurryFemale
extends ModelNPCFemale {
    public ModelRenderer Snout;
    public ModelRenderer Snout2;
    public ModelRenderer Tail;
    public ModelRenderer LeftEar;
    public ModelRenderer RightEar;
    public ModelRenderer LeftWing;
    public ModelRenderer RightWing;
    public ModelRenderer LeftHorn;
    public ModelRenderer RightHorn;

    public ModelFurryFemale(int n, int n2, float f) {
        super(n, n2, f);
    }

    @Override
    public void init(float f, float f2) {
        super.init(f, f2);
        this.Snout = new ModelRenderer(this, 0, 32);
        this.Snout.addBox(0.0f, 0.0f, 0.0f, 4, 3, 3);
        this.Snout.setRotationPoint(-2.0f, -3.0f, -7.0f);
        this.bipedHead.addChild(this.Snout);
        this.Snout2 = new ModelRenderer(this, 0, 38);
        this.Snout2.addBox(0.0f, 0.0f, 0.0f, 4, 3, 1);
        this.Snout2.setRotationPoint(-2.0f, -3.0f, -5.0f);
        this.bipedHead.addChild(this.Snout2);
        this.LeftEar = new ModelRenderer(this, 14, 32);
        this.LeftEar.addBox(-1.5f, -3.0f, -0.1f, 3, 3, 2);
        this.LeftEar.setRotationPoint(3.0f, -7.5f, 2.0f);
        this.bipedHead.addChild(this.LeftEar);
        this.RightEar = new ModelRenderer(this, 14, 32);
        this.RightEar.mirror = true;
        this.RightEar.addBox(-1.5f, -3.0f, -0.1f, 3, 3, 2);
        this.RightEar.setRotationPoint(-3.0f, -7.5f, 2.0f);
        this.bipedHead.addChild(this.RightEar);
        this.Tail = new ModelRenderer(this, 24, 32);
        this.Tail.addBox(0.0f, 0.0f, 0.0f, 2, 9, 2);
        this.Tail.setRotationPoint(-1.0f, 11.0f, 1.0f);
        this.setRotation(this.Tail, 0.8714253f, 0.0f, 0.0f);
        this.bipedBody.addChild(this.Tail);
        this.LeftWing = new ModelRenderer(this, 32, 32);
        this.LeftWing.mirror = true;
        this.LeftWing.addBox(0.0f, 0.0f, 0.0f, 15, 20, 0);
        this.LeftWing.setRotationPoint(1.0f, -2.0f, 0.0f);
        this.setRotation(this.LeftWing, 0.3141593f, -0.5235988f, -0.3490659f);
        this.bipedBody.addChild(this.LeftWing);
        this.RightWing = new ModelRenderer(this, 32, 32);
        this.RightWing.addBox(-15.0f, 0.0f, 0.0f, 15, 20, 0);
        this.RightWing.setRotationPoint(-1.0f, -2.0f, 0.0f);
        this.setRotation(this.RightWing, 0.3141593f, 0.5235988f, 0.3490659f);
        this.bipedBody.addChild(this.RightWing);
        this.LeftHorn = new ModelRenderer(this, 0, 42);
        this.LeftHorn.mirror = true;
        this.LeftHorn.addBox(0.0f, 0.0f, 0.0f, 5, 2, 2);
        this.LeftHorn.setRotationPoint(4.0f, -7.0f, 0.0f);
        this.bipedHead.addChild(this.LeftHorn);
        this.RightHorn = new ModelRenderer(this, 0, 42);
        this.RightHorn.addBox(0.0f, 0.0f, 0.0f, 5, 2, 2);
        this.RightHorn.setRotationPoint(-9.0f, -7.0f, 0.0f);
        this.bipedHead.addChild(this.RightHorn);
        ModelRenderer modelRenderer = new ModelRenderer(this, 56, 23);
        modelRenderer.mirror = true;
        modelRenderer.addBox(-1.466667f, -4.0f, 0.0f, 3, 8, 1);
        modelRenderer.setRotationPoint(2.533333f, -12.0f, 0.0f);
        this.bipedHead.addChild(modelRenderer);
        ModelRenderer modelRenderer2 = new ModelRenderer(this, 56, 23);
        modelRenderer2.addBox(-1.5f, -4.0f, 0.0f, 3, 8, 1);
        modelRenderer2.setRotationPoint(-2.466667f, -12.0f, 0.0f);
        this.bipedHead.addChild(modelRenderer2);
        ModelRenderer modelRenderer3 = new ModelRenderer(this, 56, 18);
        modelRenderer3.addBox(-1.5f, -2.0f, 0.0f, 3, 4, 1);
        modelRenderer3.setRotationPoint(0.0f, 8.5f, 2.0f);
        modelRenderer3.setTextureSize(64, 32);
        modelRenderer3.mirror = true;
        this.setRotation(modelRenderer3, 0.0f, 0.0f, -1.570796f);
        this.bipedBody.addChild(modelRenderer3);
        ModelRenderer modelRenderer4 = new ModelRenderer(this, 56, 16);
        modelRenderer4.addBox(0.0f, 0.0f, 0.0f, 2, 1, 1);
        modelRenderer4.setRotationPoint(-1.0f, 6.0f, 2.0f);
        modelRenderer4.setTextureSize(64, 32);
        modelRenderer4.mirror = true;
        this.bipedBody.addChild(modelRenderer4);
        ModelRenderer modelRenderer5 = new ModelRenderer(this, 14, 40);
        modelRenderer5.addBox(-1.0f, -2.0f, -5.0f, 2, 1, 1);
        modelRenderer5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedHead.addChild(modelRenderer5);
        ModelRenderer modelRenderer6 = new ModelRenderer(this, 14, 37);
        modelRenderer6.addBox(1.0f, 0.0f, 0.0f, 4, 2, 1);
        modelRenderer6.setRotationPoint(-3.0f, -4.0f, -5.0f);
        this.bipedHead.addChild(modelRenderer6);
    }
}

