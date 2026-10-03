/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.ModelPartData;
import noppes.npcs.client.model.ModelMPM;
import noppes.npcs.client.model.util.Model2DRenderer;
import noppes.npcs.client.model.util.ModelPartInterface;

public class ModelWings
extends ModelPartInterface {
    private Model2DRenderer lWing;
    private Model2DRenderer rWing;

    public ModelWings(ModelMPM modelMPM) {
        super(modelMPM);
        this.lWing = new Model2DRenderer(modelMPM, 56.0f, 16.0f, 8, 16, 64.0f, 32.0f);
        this.lWing.field_78809_i = true;
        this.lWing.func_78793_a(2.0f, 4.0f, 2.0f);
        this.lWing.setRotationOffset(-16.0f, -12.0f);
        this.setRotation(this.lWing, 0.7141593f, -0.5235988f, -0.5090659f);
        this.func_78792_a(this.lWing);
        this.rWing = new Model2DRenderer(modelMPM, 56.0f, 16.0f, 8, 16, 64.0f, 32.0f);
        this.rWing.func_78793_a(-2.0f, 4.0f, 2.0f);
        this.rWing.setRotationOffset(-16.0f, -12.0f);
        this.setRotation(this.rWing, 0.7141593f, 0.5235988f, 0.5090659f);
        this.func_78792_a(this.rWing);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.rWing.field_78795_f = 0.7141593f;
        this.rWing.field_78808_h = 0.5090659f;
        this.lWing.field_78795_f = 0.7141593f;
        this.lWing.field_78808_h = -0.5090659f;
        float f7 = Math.abs(sajh._a(f * 0.033f + (float)Math.PI) * 0.4f) * f2;
        if (entity.field_70122_E && (double)f7 <= 0.01) {
            this.lWing.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.rWing.field_78808_h -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.lWing.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
            this.rWing.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
        } else {
            float f8 = 0.55f + 0.5f * f7;
            float f9 = sajh._a(f3 * 0.67f);
            this.rWing.field_78808_h += f9 * 0.5f * f8;
            this.rWing.field_78795_f += f9 * 0.5f * f8;
            this.lWing.field_78808_h -= f9 * 0.5f * f8;
            this.lWing.field_78795_f += f9 * 0.5f * f8;
        }
    }

    @Override
    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("wings");
        if (modelPartData == null) {
            this.field_78807_k = true;
        } else {
            this.color = modelPartData.color;
            this.field_78807_k = false;
            this.location = !modelPartData.playerTexture ? (ResourceLocation)modelPartData.getResource() : null;
        }
    }
}

