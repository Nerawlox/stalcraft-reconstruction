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
        this.model.func_78793_a(-4.0f, 12.0f, 3.0f);
        this.model.setScale(0.75f);
        this.func_78792_a(this.model);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        ModelRenderer modelRenderer = this.base.bipedHead;
        if (modelRenderer.field_78795_f < 0.0f) {
            this.field_78795_f = -modelRenderer.field_78795_f * 1.2f;
            if (modelRenderer.field_78795_f > -1.0f) {
                this.field_78797_d = -modelRenderer.field_78795_f * 1.5f;
                this.field_78798_e = -modelRenderer.field_78795_f * 1.5f;
            }
        } else {
            this.field_78795_f = 0.0f;
            this.field_78797_d = 0.0f;
            this.field_78798_e = 0.0f;
        }
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("hair");
        if (modelPartData == null) {
            this.field_78807_k = true;
        } else {
            this.color = modelPartData.color;
            this.field_78807_k = false;
            this.location = !modelPartData.playerTexture ? (ResourceLocation)modelPartData.getResource() : null;
        }
    }
}

