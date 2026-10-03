/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.ModelPartData;
import noppes.npcs.client.model.ModelMPM;
import noppes.npcs.client.model.util.Model2DRenderer;
import noppes.npcs.client.model.util.ModelPartInterface;

public class ModelEars
extends ModelPartInterface {
    private ModelRenderer ears;
    private ModelRenderer bunny;

    public ModelEars(ModelMPM modelMPM) {
        super(modelMPM);
        this.ears = new ModelRenderer(this.base);
        this.addChild(this.ears);
        Model2DRenderer model2DRenderer = new Model2DRenderer(this.base, 56.0f, 0.0f, 8, 4, 64.0f, 32.0f);
        model2DRenderer.setRotationPoint(-7.44f, -7.3f, -0.0f);
        model2DRenderer.setScale(0.234f, 0.234f);
        model2DRenderer.setThickness(1.16f);
        this.ears.addChild(model2DRenderer);
        Model2DRenderer model2DRenderer2 = new Model2DRenderer(this.base, 56.0f, 0.0f, 8, 4, 64.0f, 32.0f);
        model2DRenderer2.setRotationPoint(7.44f, -7.3f, 1.15f);
        model2DRenderer2.setScale(0.234f, 0.234f);
        this.setRotation(model2DRenderer2, 0.0f, (float)Math.PI, 0.0f);
        model2DRenderer2.setThickness(1.16f);
        this.ears.addChild(model2DRenderer2);
        Model2DRenderer model2DRenderer3 = new Model2DRenderer(this.base, 56.0f, 4.0f, 8, 4, 64.0f, 32.0f);
        model2DRenderer3.setRotationPoint(-7.44f, -7.3f, 1.14f);
        model2DRenderer3.setScale(0.234f, 0.234f);
        model2DRenderer3.setThickness(1.16f);
        this.ears.addChild(model2DRenderer3);
        Model2DRenderer model2DRenderer4 = new Model2DRenderer(this.base, 56.0f, 4.0f, 8, 4, 64.0f, 32.0f);
        model2DRenderer4.setRotationPoint(7.44f, -7.3f, 2.31f);
        model2DRenderer4.setScale(0.234f, 0.234f);
        this.setRotation(model2DRenderer4, 0.0f, (float)Math.PI, 0.0f);
        model2DRenderer4.setThickness(1.16f);
        this.ears.addChild(model2DRenderer4);
        this.bunny = new ModelRenderer(this.base);
        this.addChild(this.bunny);
        ModelRenderer modelRenderer = new ModelRenderer(this.base, 56, 0);
        modelRenderer.mirror = true;
        modelRenderer.addBox(-1.466667f, -4.0f, 0.0f, 3, 7, 1);
        modelRenderer.setRotationPoint(2.533333f, -11.0f, 0.0f);
        this.bunny.addChild(modelRenderer);
        ModelRenderer modelRenderer2 = new ModelRenderer(this.base, 56, 0);
        modelRenderer2.addBox(-1.5f, -4.0f, 0.0f, 3, 7, 1);
        modelRenderer2.setRotationPoint(-2.466667f, -11.0f, 0.0f);
        this.bunny.addChild(modelRenderer2);
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("ears");
        if (modelPartData == null) {
            this.isHidden = true;
        } else {
            this.isHidden = false;
            this.color = modelPartData.color;
            this.ears.isHidden = modelPartData.type != 0;
            this.bunny.isHidden = modelPartData.type != 1;
            this.location = !modelPartData.playerTexture ? (ResourceLocation)modelPartData.getResource() : null;
        }
    }
}

