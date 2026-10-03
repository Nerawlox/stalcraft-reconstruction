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
        float f7 = sajh._a(this.onGround * 3.141593f);
        float f8 = sajh._a((1.0f - (1.0f - this.onGround) * (1.0f - this.onGround)) * 3.141593f);
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightArm.rotateAngleY = -(0.1f - f7 * 0.6f);
        this.bipedLeftArm.rotateAngleY = 0.1f - f7 * 0.6f;
        this.bipedRightArm.rotateAngleX = -1.570796f;
        this.bipedLeftArm.rotateAngleX = -1.570796f;
        this.bipedRightArm.rotateAngleX -= f7 * 1.2f - f8 * 0.4f;
        this.bipedLeftArm.rotateAngleX -= f7 * 1.2f - f8 * 0.4f;
        this.bipedRightArm.rotateAngleZ += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedLeftArm.rotateAngleZ -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedRightArm.rotateAngleX += sajh._a(f3 * 0.067f) * 0.05f;
        this.bipedLeftArm.rotateAngleX -= sajh._a(f3 * 0.067f) * 0.05f;
    }
}

