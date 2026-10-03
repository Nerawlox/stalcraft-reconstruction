/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.util.sajh;
import noppes.npcs.client.model.ModelNPCMale;

public class ModelZombieMale
extends ModelNPCMale {
    public ModelZombieMale(float f) {
        super(f);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6);
        float f7 = sajh._a(this.field_78095_p * 3.141593f);
        float f8 = sajh._a((1.0f - (1.0f - this.field_78095_p) * (1.0f - this.field_78095_p)) * 3.141593f);
        this.bipedRightArm.field_78808_h = 0.0f;
        this.bipedLeftArm.field_78808_h = 0.0f;
        this.bipedRightArm.field_78796_g = -(0.1f - f7 * 0.6f);
        this.bipedLeftArm.field_78796_g = 0.1f - f7 * 0.6f;
        this.bipedRightArm.field_78795_f = -1.570796f;
        this.bipedLeftArm.field_78795_f = -1.570796f;
        this.bipedRightArm.field_78795_f -= f7 * 1.2f - f8 * 0.4f;
        this.bipedLeftArm.field_78795_f -= f7 * 1.2f - f8 * 0.4f;
        this.bipedRightArm.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedLeftArm.field_78808_h -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedRightArm.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
        this.bipedLeftArm.field_78795_f -= sajh._a(f3 * 0.067f) * 0.05f;
    }
}

