/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import noppes.npcs.client.model.util.Model2DRenderer;
import noppes.npcs.client.model.util.ModelScaleRenderer;

public class ModelHeadwear
extends ModelScaleRenderer {
    public ModelHeadwear(ModelBase modelBase) {
        super(modelBase);
        Model2DRenderer model2DRenderer = new Model2DRenderer(modelBase, 32.0f, 8.0f, 8, 8, 64.0f, 32.0f);
        model2DRenderer.setRotationPoint(-4.64f, 0.8f, 4.64f);
        model2DRenderer.setScale(0.58f);
        model2DRenderer.setThickness(0.65f);
        this.setRotation(model2DRenderer, 0.0f, 1.5707964f, 0.0f);
        this.addChild(model2DRenderer);
        Model2DRenderer model2DRenderer2 = new Model2DRenderer(modelBase, 48.0f, 8.0f, 8, 8, 64.0f, 32.0f);
        model2DRenderer2.setRotationPoint(4.64f, 0.8f, -4.64f);
        model2DRenderer2.setScale(0.58f);
        model2DRenderer2.setThickness(0.65f);
        this.setRotation(model2DRenderer2, 0.0f, -1.5707964f, 0.0f);
        this.addChild(model2DRenderer2);
        Model2DRenderer model2DRenderer3 = new Model2DRenderer(modelBase, 40.0f, 8.0f, 8, 8, 64.0f, 32.0f);
        model2DRenderer3.setRotationPoint(-4.64f, 0.8f, -4.64f);
        model2DRenderer3.setScale(0.58f);
        model2DRenderer3.setThickness(0.65f);
        this.setRotation(model2DRenderer3, 0.0f, 0.0f, 0.0f);
        this.addChild(model2DRenderer3);
        Model2DRenderer model2DRenderer4 = new Model2DRenderer(modelBase, 56.0f, 8.0f, 8, 8, 64.0f, 32.0f);
        model2DRenderer4.setRotationPoint(4.64f, 0.8f, 4.64f);
        model2DRenderer4.setScale(0.58f);
        model2DRenderer4.setThickness(0.65f);
        this.setRotation(model2DRenderer4, 0.0f, (float)Math.PI, 0.0f);
        this.addChild(model2DRenderer4);
        Model2DRenderer model2DRenderer5 = new Model2DRenderer(modelBase, 40.0f, 0.0f, 8, 8, 64.0f, 32.0f);
        model2DRenderer5.setRotationPoint(-4.64f, -8.5f, -4.64f);
        model2DRenderer5.setScale(0.58f);
        model2DRenderer5.setThickness(0.65f);
        this.setRotation(model2DRenderer5, -1.5707964f, 0.0f, 0.0f);
        this.addChild(model2DRenderer5);
        Model2DRenderer model2DRenderer6 = new Model2DRenderer(modelBase, 48.0f, 0.0f, 8, 8, 64.0f, 32.0f);
        model2DRenderer6.setRotationPoint(-4.64f, 0.0f, -4.64f);
        model2DRenderer6.setScale(0.58f);
        model2DRenderer6.setThickness(0.65f);
        this.setRotation(model2DRenderer6, -1.5707964f, 0.0f, 0.0f);
        this.addChild(model2DRenderer6);
    }

    @Override
    public void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.rotateAngleX = f;
        modelRenderer.rotateAngleY = f2;
        modelRenderer.rotateAngleZ = f3;
    }
}

