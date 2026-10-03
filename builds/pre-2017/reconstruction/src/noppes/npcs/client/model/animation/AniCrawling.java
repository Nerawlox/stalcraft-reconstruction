/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.animation;

import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import noppes.npcs.client.model.ModelMPM;

public class AniCrawling {
    public static void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity, ModelMPM modelMPM) {
        modelMPM.bipedHead.rotateAngleZ = -f4 / 57.295776f;
        modelMPM.bipedHead.rotateAngleY = 0.0f;
        modelMPM.bipedHeadwear.rotateAngleX = modelMPM.bipedHead.rotateAngleX = -0.95993114f;
        modelMPM.bipedHeadwear.rotateAngleY = modelMPM.bipedHead.rotateAngleY;
        modelMPM.bipedHeadwear.rotateAngleZ = modelMPM.bipedHead.rotateAngleZ;
        if ((double)f2 > 0.25) {
            f2 = 0.25f;
        }
        float f7 = sajh._b(f * 0.8f + (float)Math.PI) * f2;
        modelMPM.bipedLeftArm.rotateAngleX = (float)Math.PI - f7 * 0.25f;
        modelMPM.bipedLeftArm.rotateAngleY = f7 * -0.46f;
        modelMPM.bipedLeftArm.rotateAngleZ = f7 * -0.2f;
        modelMPM.bipedLeftArm.rotationPointY = 2.0f - f7 * 9.0f;
        modelMPM.bipedRightArm.rotateAngleX = (float)Math.PI + f7 * 0.25f;
        modelMPM.bipedRightArm.rotateAngleY = f7 * -0.4f;
        modelMPM.bipedRightArm.rotateAngleZ = f7 * -0.2f;
        modelMPM.bipedRightArm.rotationPointY = 2.0f + f7 * 9.0f;
        modelMPM.bipedBody.rotateAngleY = f7 * 0.1f;
        modelMPM.bipedBody.rotateAngleX = 0.0f;
        modelMPM.bipedBody.rotateAngleZ = f7 * 0.1f;
        modelMPM.bipedLeftLeg.rotateAngleX = f7 * 0.1f;
        modelMPM.bipedLeftLeg.rotateAngleY = f7 * 0.1f;
        modelMPM.bipedLeftLeg.rotateAngleZ = -0.122173056f - f7 * 0.25f;
        modelMPM.bipedLeftLeg.rotationPointY = 10.4f + f7 * 9.0f;
        modelMPM.bipedLeftLeg.rotationPointZ = f7 * 0.6f;
        modelMPM.bipedRightLeg.rotateAngleX = f7 * -0.1f;
        modelMPM.bipedRightLeg.rotateAngleY = f7 * 0.1f;
        modelMPM.bipedRightLeg.rotateAngleZ = 0.122173056f - f7 * 0.25f;
        modelMPM.bipedRightLeg.rotationPointY = 10.4f - f7 * 9.0f;
        modelMPM.bipedRightLeg.rotationPointZ = f7 * -0.6f;
    }
}

