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
        this.field_78801_a = 64.0f;
        this.field_78799_b = 32.0f;
        ModelRenderer modelRenderer = new ModelRenderer(modelMPM, 0, 0);
        modelRenderer.func_78789_a(-1.0f, -1.0f, -1.0f, 2, 2, 3);
        modelRenderer.func_78793_a(0.0f, -1.0f, 3.0f);
        this.setRotation(modelRenderer, 0.0f, 0.0f, 0.0f);
        this.func_78792_a(modelRenderer);
        ModelRenderer modelRenderer2 = new ModelRenderer(modelMPM, 0, 9);
        modelRenderer2.func_78789_a(-2.0f, -5.0f, -1.0f, 4, 5, 3);
        modelRenderer2.func_78793_a(0.0f, 0.0f, 1.0f);
        this.setRotation(modelRenderer2, -0.37f, 0.0f, 0.0f);
        modelRenderer.func_78792_a(modelRenderer2);
        ModelRenderer modelRenderer3 = new ModelRenderer(modelMPM, 0, 18);
        modelRenderer3.func_78789_a(-2.466667f, -6.0f, -1.0f, 5, 7, 3);
        modelRenderer3.func_78793_a(0.0f, -5.0f, 0.0f);
        this.setRotation(modelRenderer3, 0.3f, 0.0f, 0.0f);
        modelRenderer2.func_78792_a(modelRenderer3);
        ModelRenderer modelRenderer4 = new ModelRenderer(modelMPM, 25, 0);
        modelRenderer4.func_78789_a(-3.0f, -0.6f, -1.0f, 6, 5, 3);
        modelRenderer4.func_78793_a(0.0f, -5.0f, 1.0f);
        this.setRotation(modelRenderer4, 2.5f, 0.0f, 0.0f);
        modelRenderer3.func_78792_a(modelRenderer4);
        ModelRenderer modelRenderer5 = new ModelRenderer(modelMPM, 25, 10);
        modelRenderer5.func_78789_a(-3.0f, -2.0f, -1.0f, 6, 3, 5);
        modelRenderer5.func_78793_a(0.0f, 3.5f, 0.0f);
        this.setRotation(modelRenderer5, -2.5f, 0.0f, 0.0f);
        modelRenderer4.func_78792_a(modelRenderer5);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }
}

