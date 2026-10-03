/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.client.model.ModelMPM;
import noppes.npcs.client.model.util.Model2DRenderer;
import noppes.npcs.client.model.util.ModelPartInterface;

public class ModelBreasts
extends ModelPartInterface {
    private Model2DRenderer breasts;
    private ModelRenderer breasts2;
    private ModelRenderer breasts3;

    public ModelBreasts(ModelMPM modelMPM) {
        super(modelMPM);
        this.breasts = new Model2DRenderer(modelMPM, 20.0f, 22.0f, 8, 3, 64.0f, 32.0f);
        this.breasts.setRotationPoint(-3.6f, 5.2f, -3.0f);
        this.breasts.setScale(0.17f, 0.19f);
        this.breasts.setThickness(1.0f);
        this.addChild(this.breasts);
        this.breasts2 = new ModelRenderer(modelMPM);
        this.addChild(this.breasts2);
        Model2DRenderer model2DRenderer = new Model2DRenderer(modelMPM, 20.0f, 22.0f, 8, 4, 64.0f, 32.0f);
        model2DRenderer.setRotationPoint(-3.6f, 5.0f, -3.1f);
        model2DRenderer.setScale(0.225f, 0.2f);
        model2DRenderer.setThickness(2.0f);
        model2DRenderer.rotateAngleX = -0.31415927f;
        this.breasts2.addChild(model2DRenderer);
        this.breasts3 = new ModelRenderer(modelMPM);
        this.addChild(this.breasts3);
        Model2DRenderer model2DRenderer2 = new Model2DRenderer(modelMPM, 20.0f, 22.0f, 3, 2, 64.0f, 32.0f);
        model2DRenderer2.setRotationPoint(-3.8f, 5.3f, -3.6f);
        model2DRenderer2.setScale(0.12f, 0.14f);
        model2DRenderer2.setThickness(1.75f);
        this.breasts3.addChild(model2DRenderer2);
        Model2DRenderer model2DRenderer3 = new Model2DRenderer(modelMPM, 20.0f, 22.0f, 3, 1, 64.0f, 32.0f);
        model2DRenderer3.setRotationPoint(-3.8f, 4.1f, -3.14f);
        model2DRenderer3.setScale(0.06f, 0.07f);
        model2DRenderer3.setThickness(1.75f);
        model2DRenderer3.rotateAngleX = 0.34906584f;
        this.breasts3.addChild(model2DRenderer3);
        Model2DRenderer model2DRenderer4 = new Model2DRenderer(modelMPM, 20.0f, 24.0f, 3, 1, 64.0f, 32.0f);
        model2DRenderer4.setRotationPoint(-3.8f, 5.3f, -3.6f);
        model2DRenderer4.setScale(0.06f, 0.07f);
        model2DRenderer4.setThickness(1.75f);
        model2DRenderer4.rotateAngleX = -0.34906584f;
        this.breasts3.addChild(model2DRenderer4);
        Model2DRenderer model2DRenderer5 = new Model2DRenderer(modelMPM, 23.0f, 22.0f, 1, 2, 64.0f, 32.0f);
        model2DRenderer5.setRotationPoint(-1.8f, 5.3f, -3.14f);
        model2DRenderer5.setScale(0.12f, 0.14f);
        model2DRenderer5.setThickness(1.75f);
        model2DRenderer5.rotateAngleY = 0.34906584f;
        this.breasts3.addChild(model2DRenderer5);
        Model2DRenderer model2DRenderer6 = new Model2DRenderer(modelMPM, 25.0f, 22.0f, 3, 2, 64.0f, 32.0f);
        model2DRenderer6.setRotationPoint(0.8f, 5.3f, -3.6f);
        model2DRenderer6.setScale(0.12f, 0.14f);
        model2DRenderer6.setThickness(1.75f);
        this.breasts3.addChild(model2DRenderer6);
        Model2DRenderer model2DRenderer7 = new Model2DRenderer(modelMPM, 25.0f, 22.0f, 3, 1, 64.0f, 32.0f);
        model2DRenderer7.setRotationPoint(0.8f, 4.1f, -3.18f);
        model2DRenderer7.setScale(0.06f, 0.07f);
        model2DRenderer7.setThickness(1.75f);
        model2DRenderer7.rotateAngleX = 0.34906584f;
        this.breasts3.addChild(model2DRenderer7);
        Model2DRenderer model2DRenderer8 = new Model2DRenderer(modelMPM, 25.0f, 24.0f, 3, 1, 64.0f, 32.0f);
        model2DRenderer8.setRotationPoint(0.8f, 5.3f, -3.6f);
        model2DRenderer8.setScale(0.06f, 0.07f);
        model2DRenderer8.setThickness(1.75f);
        model2DRenderer8.rotateAngleX = -0.34906584f;
        this.breasts3.addChild(model2DRenderer8);
        Model2DRenderer model2DRenderer9 = new Model2DRenderer(modelMPM, 24.0f, 22.0f, 1, 2, 64.0f, 32.0f);
        model2DRenderer9.setRotationPoint(0.8f, 5.3f, -3.6f);
        model2DRenderer9.setScale(0.12f, 0.14f);
        model2DRenderer9.setThickness(1.75f);
        model2DRenderer9.rotateAngleY = -0.34906584f;
        this.breasts3.addChild(model2DRenderer9);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        this.isHidden = entityCustomNpc.breasts == 0;
        this.breasts.isHidden = entityCustomNpc.breasts != 1;
        this.breasts2.isHidden = entityCustomNpc.breasts != 2;
        this.breasts3.isHidden = entityCustomNpc.breasts != 3;
    }
}

