/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.animation;

import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import noppes.npcs.client.model.ModelMPM;

public class AniHug {
    public static void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity, ModelMPM modelMPM) {
        float f7 = sajh._a(modelMPM.field_78095_p * 3.141593f);
        float f8 = sajh._a((1.0f - (1.0f - modelMPM.field_78095_p) * (1.0f - modelMPM.field_78095_p)) * 3.141593f);
        modelMPM.bipedRightArm.field_78808_h = 0.0f;
        modelMPM.bipedLeftArm.field_78808_h = 0.0f;
        modelMPM.bipedRightArm.field_78796_g = -(0.1f - f7 * 0.6f);
        modelMPM.bipedLeftArm.field_78796_g = 0.1f;
        modelMPM.bipedRightArm.field_78795_f = -1.570796f;
        modelMPM.bipedLeftArm.field_78795_f = -1.570796f;
        modelMPM.bipedRightArm.field_78795_f -= f7 * 1.2f - f8 * 0.4f;
        modelMPM.bipedRightArm.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        modelMPM.bipedLeftArm.field_78808_h -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        modelMPM.bipedRightArm.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
        modelMPM.bipedLeftArm.field_78795_f -= sajh._a(f3 * 0.067f) * 0.05f;
    }
}

