/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.ModelPartData;
import noppes.npcs.client.model.ModelMPM;
import noppes.npcs.client.model.util.Model2DRenderer;
import noppes.npcs.client.model.util.ModelPartInterface;

public class ModelMohawk
extends ModelPartInterface {
    private Model2DRenderer model;

    public ModelMohawk(ModelMPM modelMPM) {
        super(modelMPM);
        this.model = new Model2DRenderer(modelMPM, 0, 0, 13, 13);
        this.model.func_78793_a(-0.5f, 0.0f, 9.0f);
        this.setRotation(this.model, 0.0f, 1.5707964f, 0.0f);
        this.model.setScale(0.825f);
        this.func_78792_a(this.model);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("mohawk");
        if (modelPartData == null) {
            this.field_78807_k = true;
        } else {
            this.color = modelPartData.color;
            this.field_78807_k = false;
            this.location = (ResourceLocation)modelPartData.getResource();
        }
    }
}

