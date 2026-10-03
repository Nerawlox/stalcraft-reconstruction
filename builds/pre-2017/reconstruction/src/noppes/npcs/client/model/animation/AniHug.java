/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.animation;

import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import noppes.npcs.client.model.ModelMPM;

public class AniHug {
    public static void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity, ModelMPM modelMPM) {
        float f7 = sajh._a(modelMPM.onGround * 3.141593f);
        float f8 = sajh._a((1.0f - (1.0f - modelMPM.onGround) * (1.0f - modelMPM.onGround)) * 3.141593f);
        modelMPM.bipedRightArm.rotateAngleZ = 0.0f;
        modelMPM.bipedLeftArm.rotateAngleZ = 0.0f;
        modelMPM.bipedRightArm.rotateAngleY = -(0.1f - f7 * 0.6f);
        modelMPM.bipedLeftArm.rotateAngleY = 0.1f;
        modelMPM.bipedRightArm.rotateAngleX = -1.570796f;
        modelMPM.bipedLeftArm.rotateAngleX = -1.570796f;
        modelMPM.bipedRightArm.rotateAngleX -= f7 * 1.2f - f8 * 0.4f;
        modelMPM.bipedRightArm.rotateAngleZ += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        modelMPM.bipedLeftArm.rotateAngleZ -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        modelMPM.bipedRightArm.rotateAngleX += sajh._a(f3 * 0.067f) * 0.05f;
        modelMPM.bipedLeftArm.rotateAngleX -= sajh._a(f3 * 0.067f) * 0.05f;
    }
}

