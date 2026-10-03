/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.ModelPartData;
import noppes.npcs.client.model.ModelMPM;
import noppes.npcs.client.model.util.ModelPartInterface;

public class ModelSnout
extends ModelPartInterface {
    private ModelRenderer small;
    private ModelRenderer medium;
    private ModelRenderer large;
    private ModelRenderer bunny;

    public ModelSnout(ModelMPM modelMPM) {
        super(modelMPM);
        this.small = new ModelRenderer(modelMPM, 24, 0);
        this.small.addBox(0.0f, 0.0f, 0.0f, 4, 3, 1);
        this.small.setRotationPoint(-2.0f, -3.0f, -5.0f);
        this.addChild(this.small);
        this.medium = new ModelRenderer(modelMPM, 24, 0);
        this.medium.addBox(0.0f, 0.0f, 0.0f, 4, 3, 2);
        this.medium.setRotationPoint(-2.0f, -3.0f, -6.0f);
        this.addChild(this.medium);
        this.large = new ModelRenderer(modelMPM, 24, 0);
        this.large.addBox(0.0f, 0.0f, 0.0f, 4, 3, 3);
        this.large.setRotationPoint(-2.0f, -3.0f, -7.0f);
        this.addChild(this.large);
        this.bunny = new ModelRenderer(modelMPM, 24, 0);
        this.bunny.addBox(1.0f, 1.0f, 0.0f, 4, 2, 1);
        this.bunny.setRotationPoint(-3.0f, -4.0f, -5.0f);
        this.addChild(this.bunny);
        ModelRenderer modelRenderer = new ModelRenderer(modelMPM, 24, 3);
        modelRenderer.addBox(2.0f, 3.0f, 0.0f, 2, 1, 1);
        modelRenderer.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bunny.addChild(modelRenderer);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("snout");
        if (modelPartData == null) {
            this.isHidden = true;
        } else {
            this.color = modelPartData.color;
            this.isHidden = false;
            this.small.isHidden = modelPartData.type != 0;
            this.medium.isHidden = modelPartData.type != 1;
            this.large.isHidden = modelPartData.type != 2;
            this.bunny.isHidden = modelPartData.type != 3;
            this.location = !modelPartData.playerTexture ? (ResourceLocation)modelPartData.getResource() : null;
        }
    }
}

