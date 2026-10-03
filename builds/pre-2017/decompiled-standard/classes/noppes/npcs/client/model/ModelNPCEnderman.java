/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelRenderer;
import noppes.npcs.client.model.ModelNPCMale;

public class ModelNPCEnderman
extends ModelNPCMale {
    public ModelNPCEnderman(float f) {
        super(f);
    }

    @Override
    public void init(float f, float f2) {
        super.init(f, f2);
        this.bipedHeadwear = new ModelRenderer(this, 0, 16);
        this.bipedHeadwear.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f2 + 0.5f);
        this.bipedHeadwear.func_78793_a(0.0f, 0.0f + f2, 0.0f);
        this.bipedBody = new ModelRenderer(this, 40, 0);
        this.bipedBody.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, f2);
        this.bipedBody.func_78793_a(0.0f, -14.0f, 0.0f);
        this.bipedRightArm = new ModelRenderer(this, 32, 0);
        this.bipedRightArm.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 30, 2, f2);
        this.bipedRightArm.func_78793_a(-3.0f, -12.0f, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 32, 0);
        this.bipedLeftArm.field_78809_i = true;
        this.bipedLeftArm.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 30, 2, f2);
        this.bipedLeftArm.func_78793_a(5.0f, -12.0f, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 32, 0);
        this.bipedRightLeg.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 30, 2, f2);
        this.bipedRightLeg.func_78793_a(-2.0f, -2.0f, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 32, 0);
        this.bipedLeftLeg.field_78809_i = true;
        this.bipedLeftLeg.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 30, 2, f2);
        this.bipedLeftLeg.func_78793_a(2.0f, -2.0f, 0.0f);
        this.bipedCloak.func_78793_a(0.0f, -12.0f, -2.0f);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6);
        float f7 = -14.0f;
        this.bipedBody.field_78795_f = 0.0f;
        this.bipedBody.field_78797_d = f7;
        this.bipedBody.field_78798_e = -0.0f;
        this.bipedRightLeg.field_78795_f -= 0.0f;
        this.bipedLeftLeg.field_78795_f -= 0.0f;
        this.bipedRightArm.field_78795_f = (float)((double)this.bipedRightArm.field_78795_f * 0.5);
        this.bipedLeftArm.field_78795_f = (float)((double)this.bipedLeftArm.field_78795_f * 0.5);
        this.bipedRightLeg.field_78795_f = (float)((double)this.bipedRightLeg.field_78795_f * 0.5);
        this.bipedLeftLeg.field_78795_f = (float)((double)this.bipedLeftLeg.field_78795_f * 0.5);
        float f8 = 0.4f;
        if (this.bipedRightLeg.field_78795_f > f8) {
            this.bipedRightLeg.field_78795_f = f8;
        }
        if (this.bipedLeftLeg.field_78795_f > f8) {
            this.bipedLeftLeg.field_78795_f = f8;
        }
        if (this.bipedRightLeg.field_78795_f < -f8) {
            this.bipedRightLeg.field_78795_f = -f8;
        }
        if (this.bipedLeftLeg.field_78795_f < -f8) {
            this.bipedLeftLeg.field_78795_f = -f8;
        }
        if (this.heldItemLeft != 0) {
            this.bipedRightArm.field_78795_f = -0.5f;
            this.bipedLeftArm.field_78795_f = -0.5f;
            this.bipedRightArm.field_78808_h = 0.05f;
            this.bipedLeftArm.field_78808_h = -0.05f;
        }
        this.bipedRightArm.field_78798_e = 0.0f;
        this.bipedLeftArm.field_78798_e = 0.0f;
        this.bipedRightLeg.field_78798_e = 0.0f;
        this.bipedLeftLeg.field_78798_e = 0.0f;
        this.bipedRightLeg.field_78797_d = 9.0f + f7;
        this.bipedLeftLeg.field_78797_d = 9.0f + f7;
        this.bipedHead.field_78798_e = -0.0f;
        this.bipedHead.field_78797_d = f7 + 1.0f;
        this.bipedHeadwear.field_78800_c = this.bipedHead.field_78800_c;
        this.bipedHeadwear.field_78797_d = this.bipedHead.field_78797_d;
        this.bipedHeadwear.field_78798_e = this.bipedHead.field_78798_e;
        this.bipedHeadwear.field_78795_f = this.bipedHead.field_78795_f;
        this.bipedHeadwear.field_78796_g = this.bipedHead.field_78796_g;
        this.bipedHeadwear.field_78808_h = this.bipedHead.field_78808_h;
    }
}

