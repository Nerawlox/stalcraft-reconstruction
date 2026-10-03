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

public class ModelBeard
extends ModelPartInterface {
    private Model2DRenderer model;

    public ModelBeard(ModelMPM modelMPM) {
        super(modelMPM);
        this.model = new Model2DRenderer(modelMPM, 56.0f, 20.0f, 8, 12, 64.0f, 32.0f);
        this.model.setRotationPoint(-3.99f, 11.9f, -4.0f);
        this.model.setScale(0.74f);
        this.addChild(this.model);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.rotateAngleX = this.base.bipedHead.rotateAngleX > 0.0f ? -this.base.bipedHead.rotateAngleX : 0.0f;
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("beard");
        if (modelPartData == null) {
            this.isHidden = true;
        } else {
            this.color = modelPartData.color;
            this.isHidden = false;
            this.location = !modelPartData.playerTexture ? (ResourceLocation)modelPartData.getResource() : null;
        }
    }
}

