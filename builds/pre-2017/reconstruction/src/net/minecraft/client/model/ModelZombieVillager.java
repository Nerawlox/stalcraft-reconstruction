/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelZombieVillager
extends ModelBiped {
    public ModelZombieVillager() {
        this(0.0f, 0.0f, false);
    }

    public ModelZombieVillager(float f, float f2, boolean bl) {
        super(f, 0.0f, 64, bl ? 32 : 64);
        if (bl) {
            this.bipedHead = new ModelRenderer(this, 0, 0);
            this.bipedHead.addBox(-4.0f, -10.0f, -4.0f, 8, 6, 8, f);
            this.bipedHead.setRotationPoint(0.0f, 0.0f + f2, 0.0f);
        } else {
            this.bipedHead = new ModelRenderer(this);
            this.bipedHead.setRotationPoint(0.0f, 0.0f + f2, 0.0f);
            this.bipedHead.setTextureOffset(0, 32).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, f);
            this.bipedHead.setTextureOffset(24, 32).addBox(-1.0f, -3.0f, -6.0f, 2, 4, 2, f);
        }
    }

    public int func_82897_a() {
        return 10;
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        float f7 = sajh._a(this.onGround * (float)Math.PI);
        float f8 = sajh._a((1.0f - (1.0f - this.onGround) * (1.0f - this.onGround)) * (float)Math.PI);
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightArm.rotateAngleY = -(0.1f - f7 * 0.6f);
        this.bipedLeftArm.rotateAngleY = 0.1f - f7 * 0.6f;
        this.bipedRightArm.rotateAngleX = -1.5707964f;
        this.bipedLeftArm.rotateAngleX = -1.5707964f;
        this.bipedRightArm.rotateAngleX -= f7 * 1.2f - f8 * 0.4f;
        this.bipedLeftArm.rotateAngleX -= f7 * 1.2f - f8 * 0.4f;
        this.bipedRightArm.rotateAngleZ += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedLeftArm.rotateAngleZ -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedRightArm.rotateAngleX += sajh._a(f3 * 0.067f) * 0.05f;
        this.bipedLeftArm.rotateAngleX -= sajh._a(f3 * 0.067f) * 0.05f;
    }
}

