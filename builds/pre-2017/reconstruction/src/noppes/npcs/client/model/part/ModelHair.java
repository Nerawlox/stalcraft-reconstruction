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
import noppes.npcs.client.model.util.Model2DRenderer;
import noppes.npcs.client.model.util.ModelPartInterface;

public class ModelHair
extends ModelPartInterface {
    private Model2DRenderer model;

    public ModelHair(ModelMPM modelMPM) {
        super(modelMPM);
        this.model = new Model2DRenderer(modelMPM, 56.0f, 20.0f, 8, 12, 64.0f, 32.0f);
        this.model.setRotationPoint(-4.0f, 12.0f, 3.0f);
        this.model.setScale(0.75f);
        this.addChild(this.model);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        ModelRenderer modelRenderer = this.base.bipedHead;
        if (modelRenderer.rotateAngleX < 0.0f) {
            this.rotateAngleX = -modelRenderer.rotateAngleX * 1.2f;
            if (modelRenderer.rotateAngleX > -1.0f) {
                this.rotationPointY = -modelRenderer.rotateAngleX * 1.5f;
                this.rotationPointZ = -modelRenderer.rotateAngleX * 1.5f;
            }
        } else {
            this.rotateAngleX = 0.0f;
            this.rotationPointY = 0.0f;
            this.rotationPointZ = 0.0f;
        }
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("hair");
        if (modelPartData == null) {
            this.isHidden = true;
        } else {
            this.color = modelPartData.color;
            this.isHidden = false;
            this.location = !modelPartData.playerTexture ? (ResourceLocation)modelPartData.getResource() : null;
        }
    }
}

