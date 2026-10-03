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
        this.small.func_78789_a(0.0f, 0.0f, 0.0f, 4, 3, 1);
        this.small.func_78793_a(-2.0f, -3.0f, -5.0f);
        this.func_78792_a(this.small);
        this.medium = new ModelRenderer(modelMPM, 24, 0);
        this.medium.func_78789_a(0.0f, 0.0f, 0.0f, 4, 3, 2);
        this.medium.func_78793_a(-2.0f, -3.0f, -6.0f);
        this.func_78792_a(this.medium);
        this.large = new ModelRenderer(modelMPM, 24, 0);
        this.large.func_78789_a(0.0f, 0.0f, 0.0f, 4, 3, 3);
        this.large.func_78793_a(-2.0f, -3.0f, -7.0f);
        this.func_78792_a(this.large);
        this.bunny = new ModelRenderer(modelMPM, 24, 0);
        this.bunny.func_78789_a(1.0f, 1.0f, 0.0f, 4, 2, 1);
        this.bunny.func_78793_a(-3.0f, -4.0f, -5.0f);
        this.func_78792_a(this.bunny);
        ModelRenderer modelRenderer = new ModelRenderer(modelMPM, 24, 3);
        modelRenderer.func_78789_a(2.0f, 3.0f, 0.0f, 2, 1, 1);
        modelRenderer.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bunny.func_78792_a(modelRenderer);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("snout");
        if (modelPartData == null) {
            this.field_78807_k = true;
        } else {
            this.color = modelPartData.color;
            this.field_78807_k = false;
            this.small.field_78807_k = modelPartData.type != 0;
            this.medium.field_78807_k = modelPartData.type != 1;
            this.large.field_78807_k = modelPartData.type != 2;
            this.bunny.field_78807_k = modelPartData.type != 3;
            this.location = !modelPartData.playerTexture ? (ResourceLocation)modelPartData.getResource() : null;
        }
    }
}

