/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.animation;

import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import noppes.npcs.client.model.ModelMPM;

public class AniCrawling {
    public static void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity, ModelMPM modelMPM) {
        modelMPM.bipedHead.field_78808_h = -f4 / 57.295776f;
        modelMPM.bipedHead.field_78796_g = 0.0f;
        modelMPM.bipedHeadwear.field_78795_f = modelMPM.bipedHead.field_78795_f = -0.95993114f;
        modelMPM.bipedHeadwear.field_78796_g = modelMPM.bipedHead.field_78796_g;
        modelMPM.bipedHeadwear.field_78808_h = modelMPM.bipedHead.field_78808_h;
        if ((double)f2 > 0.25) {
            f2 = 0.25f;
        }
        float f7 = sajh._b(f * 0.8f + (float)Math.PI) * f2;
        modelMPM.bipedLeftArm.field_78795_f = (float)Math.PI - f7 * 0.25f;
        modelMPM.bipedLeftArm.field_78796_g = f7 * -0.46f;
        modelMPM.bipedLeftArm.field_78808_h = f7 * -0.2f;
        modelMPM.bipedLeftArm.field_78797_d = 2.0f - f7 * 9.0f;
        modelMPM.bipedRightArm.field_78795_f = (float)Math.PI + f7 * 0.25f;
        modelMPM.bipedRightArm.field_78796_g = f7 * -0.4f;
        modelMPM.bipedRightArm.field_78808_h = f7 * -0.2f;
        modelMPM.bipedRightArm.field_78797_d = 2.0f + f7 * 9.0f;
        modelMPM.bipedBody.field_78796_g = f7 * 0.1f;
        modelMPM.bipedBody.field_78795_f = 0.0f;
        modelMPM.bipedBody.field_78808_h = f7 * 0.1f;
        modelMPM.bipedLeftLeg.field_78795_f = f7 * 0.1f;
        modelMPM.bipedLeftLeg.field_78796_g = f7 * 0.1f;
        modelMPM.bipedLeftLeg.field_78808_h = -0.122173056f - f7 * 0.25f;
        modelMPM.bipedLeftLeg.field_78797_d = 10.4f + f7 * 9.0f;
        modelMPM.bipedLeftLeg.field_78798_e = f7 * 0.6f;
        modelMPM.bipedRightLeg.field_78795_f = f7 * -0.1f;
        modelMPM.bipedRightLeg.field_78796_g = f7 * 0.1f;
        modelMPM.bipedRightLeg.field_78808_h = 0.122173056f - f7 * 0.25f;
        modelMPM.bipedRightLeg.field_78797_d = 10.4f - f7 * 9.0f;
        modelMPM.bipedRightLeg.field_78798_e = f7 * -0.6f;
    }
}

