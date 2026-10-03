/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part;

import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.ModelPartData;
import noppes.npcs.client.model.ModelMPM;
import noppes.npcs.client.model.util.Model2DRenderer;
import noppes.npcs.client.model.util.ModelPartInterface;

public class ModelFin
extends ModelPartInterface {
    private Model2DRenderer model;

    public ModelFin(ModelMPM modelMPM) {
        super(modelMPM);
        this.model = new Model2DRenderer(modelMPM, 56.0f, 20.0f, 8, 12, 64.0f, 32.0f);
        this.model.func_78793_a(-0.5f, 12.0f, 10.0f);
        this.model.setScale(0.74f);
        this.model.field_78796_g = 1.5707964f;
        this.func_78792_a(this.model);
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("fin");
        if (modelPartData == null) {
            this.field_78807_k = true;
        } else {
            this.color = modelPartData.color;
            this.field_78807_k = false;
            this.location = !modelPartData.playerTexture ? (ResourceLocation)modelPartData.getResource() : null;
        }
    }
}

