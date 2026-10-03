/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part.tails;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import noppes.npcs.client.model.ModelMPM;
import noppes.npcs.client.model.util.ModelPlaneRenderer;

public class ModelDragonTail
extends ModelRenderer {
    public ModelDragonTail(ModelMPM modelMPM) {
        super(modelMPM);
        int n = 52;
        int n2 = 16;
        ModelRenderer modelRenderer = new ModelRenderer(modelMPM, n, n2);
        modelRenderer.func_78793_a(0.0f, 0.0f, 3.0f);
        this.func_78792_a(modelRenderer);
        ModelRenderer modelRenderer2 = new ModelRenderer(modelMPM, n, n2);
        modelRenderer2.func_78793_a(0.0f, 2.0f, 2.0f);
        ModelRenderer modelRenderer3 = new ModelRenderer(modelMPM, n, n2);
        modelRenderer3.func_78793_a(0.0f, 4.5f, 4.0f);
        ModelRenderer modelRenderer4 = new ModelRenderer(modelMPM, n, n2);
        modelRenderer4.func_78793_a(0.0f, 7.0f, 5.75f);
        ModelRenderer modelRenderer5 = new ModelRenderer(modelMPM, n, n2);
        modelRenderer5.func_78793_a(0.0f, 9.0f, 8.0f);
        ModelPlaneRenderer modelPlaneRenderer = new ModelPlaneRenderer(modelMPM, n, n2);
        modelPlaneRenderer.addSidePlane(-1.5f, -1.5f, -1.5f, 3, 3);
        ModelPlaneRenderer modelPlaneRenderer2 = new ModelPlaneRenderer(modelMPM, n, n2);
        modelPlaneRenderer2.addSidePlane(-1.5f, -1.5f, -1.5f, 3, 3);
        this.setRotation(modelPlaneRenderer2, (float)Math.PI, (float)Math.PI, 0.0f);
        ModelPlaneRenderer modelPlaneRenderer3 = new ModelPlaneRenderer(modelMPM, n, n2);
        modelPlaneRenderer3.addTopPlane(-1.5f, -1.5f, -1.5f, 3, 3);
        this.setRotation(modelPlaneRenderer3, 0.0f, -1.5707964f, 0.0f);
        ModelPlaneRenderer modelPlaneRenderer4 = new ModelPlaneRenderer(modelMPM, n, n2);
        modelPlaneRenderer4.addTopPlane(-1.5f, -1.5f, -1.5f, 3, 3);
        this.setRotation(modelPlaneRenderer4, 0.0f, -1.5707964f, (float)Math.PI);
        ModelPlaneRenderer modelPlaneRenderer5 = new ModelPlaneRenderer(modelMPM, n, n2);
        modelPlaneRenderer5.addBackPlane(-1.5f, -1.5f, -1.5f, 3, 3);
        this.setRotation(modelPlaneRenderer5, 0.0f, 0.0f, 1.5707964f);
        ModelPlaneRenderer modelPlaneRenderer6 = new ModelPlaneRenderer(modelMPM, n, n2);
        modelPlaneRenderer6.addBackPlane(-1.5f, -1.5f, -1.5f, 3, 3);
        this.setRotation(modelPlaneRenderer6, 0.0f, (float)Math.PI, -1.5707964f);
        modelRenderer.func_78792_a(modelPlaneRenderer);
        modelRenderer.func_78792_a(modelPlaneRenderer2);
        modelRenderer.func_78792_a(modelPlaneRenderer3);
        modelRenderer.func_78792_a(modelPlaneRenderer4);
        modelRenderer.func_78792_a(modelPlaneRenderer6);
        modelRenderer.func_78792_a(modelPlaneRenderer5);
        modelRenderer2.func_78792_a(modelPlaneRenderer);
        modelRenderer2.func_78792_a(modelPlaneRenderer2);
        modelRenderer2.func_78792_a(modelPlaneRenderer3);
        modelRenderer2.func_78792_a(modelPlaneRenderer4);
        modelRenderer2.func_78792_a(modelPlaneRenderer6);
        modelRenderer2.func_78792_a(modelPlaneRenderer5);
        modelRenderer3.func_78792_a(modelPlaneRenderer);
        modelRenderer3.func_78792_a(modelPlaneRenderer2);
        modelRenderer3.func_78792_a(modelPlaneRenderer3);
        modelRenderer3.func_78792_a(modelPlaneRenderer4);
        modelRenderer3.func_78792_a(modelPlaneRenderer6);
        modelRenderer3.func_78792_a(modelPlaneRenderer5);
        modelRenderer4.func_78792_a(modelPlaneRenderer);
        modelRenderer4.func_78792_a(modelPlaneRenderer2);
        modelRenderer4.func_78792_a(modelPlaneRenderer3);
        modelRenderer4.func_78792_a(modelPlaneRenderer4);
        modelRenderer4.func_78792_a(modelPlaneRenderer6);
        modelRenderer4.func_78792_a(modelPlaneRenderer5);
        modelRenderer.func_78792_a(modelRenderer2);
        modelRenderer.func_78792_a(modelRenderer3);
        modelRenderer.func_78792_a(modelRenderer4);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }
}

