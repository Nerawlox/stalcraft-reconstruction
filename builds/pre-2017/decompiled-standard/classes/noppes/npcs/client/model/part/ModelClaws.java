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

public class ModelClaws
extends ModelPartInterface {
    private Model2DRenderer model;
    private boolean isRight = false;

    public ModelClaws(ModelMPM modelMPM, boolean bl) {
        super(modelMPM);
        this.isRight = bl;
        this.model = new Model2DRenderer(modelMPM, 0.0f, 16.0f, 4, 4, 64.0f, 32.0f);
        if (bl) {
            this.model.func_78793_a(-2.0f, 14.0f, -2.0f);
        } else {
            this.model.func_78793_a(3.0f, 14.0f, -2.0f);
        }
        this.model.field_78796_g = -1.5707964f;
        this.model.setScale(0.25f);
        this.func_78792_a(this.model);
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("claws");
        if (!(modelPartData == null || this.isRight && modelPartData.type == 1 || !this.isRight && modelPartData.type == 2)) {
            this.color = modelPartData.color;
            this.field_78807_k = false;
            this.location = !modelPartData.playerTexture ? (ResourceLocation)modelPartData.getResource() : null;
        } else {
            this.field_78807_k = true;
        }
    }
}

