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
        this.Snout.func_78789_a(0.0f, 0.0f, 0.0f, 4, 3, 3);
        this.Snout.func_78793_a(-2.0f, -3.0f, -7.0f);
        this.bipedHead.func_78792_a(this.Snout);
        this.Snout2 = new ModelRenderer(this, 0, 38);
        this.Snout2.func_78789_a(0.0f, 0.0f, 0.0f, 4, 3, 1);
        this.Snout2.func_78793_a(-2.0f, -3.0f, -5.0f);
        this.bipedHead.func_78792_a(this.Snout2);
        this.LeftEar = new ModelRenderer(this, 14, 32);
        this.LeftEar.func_78789_a(-1.5f, -3.0f, -0.1f, 3, 3, 2);
        this.LeftEar.func_78793_a(3.0f, -7.5f, 2.0f);
        this.bipedHead.func_78792_a(this.LeftEar);
        this.RightEar = new ModelRenderer(this, 14, 32);
        this.RightEar.field_78809_i = true;
        this.RightEar.func_78789_a(-1.5f, -3.0f, -0.1f, 3, 3, 2);
        this.RightEar.func_78793_a(-3.0f, -7.5f, 2.0f);
        this.bipedHead.func_78792_a(this.RightEar);
        this.Tail = new ModelRenderer(this, 24, 32);
        this.Tail.func_78789_a(0.0f, 0.0f, 0.0f, 2, 9, 2);
        this.Tail.func_78793_a(-1.0f, 11.0f, 1.0f);
        this.setRotation(this.Tail, 0.8714253f, 0.0f, 0.0f);
        this.bipedBody.func_78792_a(this.Tail);
        this.LeftWing = new ModelRenderer(this, 32, 32);
        this.LeftWing.field_78809_i = true;
        this.LeftWing.func_78789_a(0.0f, 0.0f, 0.0f, 15, 20, 0);
        this.LeftWing.func_78793_a(1.0f, -2.0f, 0.0f);
        this.setRotation(this.LeftWing, 0.3141593f, -0.5235988f, -0.3490659f);
        this.bipedBody.func_78792_a(this.LeftWing);
        this.RightWing = new ModelRenderer(this, 32, 32);
        this.RightWing.func_78789_a(-15.0f, 0.0f, 0.0f, 15, 20, 0);
        this.RightWing.func_78793_a(-1.0f, -2.0f, 0.0f);
        this.setRotation(this.RightWing, 0.3141593f, 0.5235988f, 0.3490659f);
        this.bipedBody.func_78792_a(this.RightWing);
        this.LeftHorn = new ModelRenderer(this, 0, 42);
        this.LeftHorn.field_78809_i = true;
        this.LeftHorn.func_78789_a(0.0f, 0.0f, 0.0f, 5, 2, 2);
        this.LeftHorn.func_78793_a(4.0f, -7.0f, 0.0f);
        this.bipedHead.func_78792_a(this.LeftHorn);
        this.RightHorn = new ModelRenderer(this, 0, 42);
        this.RightHorn.func_78789_a(0.0f, 0.0f, 0.0f, 5, 2, 2);
        this.RightHorn.func_78793_a(-9.0f, -7.0f, 0.0f);
        this.bipedHead.func_78792_a(this.RightHorn);
        ModelRenderer modelRenderer = new ModelRenderer(this, 56, 23);
        modelRenderer.field_78809_i = true;
        modelRenderer.func_78789_a(-1.466667f, -4.0f, 0.0f, 3, 8, 1);
        modelRenderer.func_78793_a(2.533333f, -12.0f, 0.0f);
        this.bipedHead.func_78792_a(modelRenderer);
        ModelRenderer modelRenderer2 = new ModelRenderer(this, 56, 23);
        modelRenderer2.func_78789_a(-1.5f, -4.0f, 0.0f, 3, 8, 1);
        modelRenderer2.func_78793_a(-2.466667f, -12.0f, 0.0f);
        this.bipedHead.func_78792_a(modelRenderer2);
        ModelRenderer modelRenderer3 = new ModelRenderer(this, 56, 18);
        modelRenderer3.func_78789_a(-1.5f, -2.0f, 0.0f, 3, 4, 1);
        modelRenderer3.func_78793_a(0.0f, 8.5f, 2.0f);
        modelRenderer3.func_78787_b(64, 32);
        modelRenderer3.field_78809_i = true;
        this.setRotation(modelRenderer3, 0.0f, 0.0f, -1.570796f);
        this.bipedBody.func_78792_a(modelRenderer3);
        ModelRenderer modelRenderer4 = new ModelRenderer(this, 56, 16);
        modelRenderer4.func_78789_a(0.0f, 0.0f, 0.0f, 2, 1, 1);
        modelRenderer4.func_78793_a(-1.0f, 6.0f, 2.0f);
        modelRenderer4.func_78787_b(64, 32);
        modelRenderer4.field_78809_i = true;
        this.bipedBody.func_78792_a(modelRenderer4);
        ModelRenderer modelRenderer5 = new ModelRenderer(this, 14, 40);
        modelRenderer5.func_78789_a(-1.0f, -2.0f, -5.0f, 2, 1, 1);
        modelRenderer5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bipedHead.func_78792_a(modelRenderer5);
        ModelRenderer modelRenderer6 = new ModelRenderer(this, 14, 37);
        modelRenderer6.func_78789_a(1.0f, 0.0f, 0.0f, 4, 2, 1);
        modelRenderer6.func_78793_a(-3.0f, -4.0f, -5.0f);
        this.bipedHead.func_78792_a(modelRenderer6);
    }
}

