/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelRenderer;
import noppes.npcs.client.model.ModelZombieMale;

public class ModelNpcSkeleton
extends ModelZombieMale {
    public ModelNpcSkeleton(float f) {
        super(f);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.bipedRightArm.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.field_78809_i = true;
        this.bipedLeftArm.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.bipedLeftArm.func_78793_a(5.0f, 2.0f, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, f);
        this.bipedRightLeg.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.field_78809_i = true;
        this.bipedLeftLeg.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, f);
        this.bipedLeftLeg.func_78793_a(2.0f, 12.0f, 0.0f);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        this.aimedBow = true;
        super.setRotationAngles(f, f2, f3, f4, f5, f6);
    }
}

