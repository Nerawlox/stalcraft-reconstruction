/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part.legs;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import noppes.npcs.client.model.ModelMPM;

public class ModelDigitigradeLegs
extends ModelRenderer {
    public boolean isRiding = false;
    public boolean isSneaking = false;
    public boolean isSleeping = false;
    public boolean isCrawling = false;
    private ModelRenderer rightleg;
    private ModelRenderer rightleg2;
    private ModelRenderer rightleglow;
    private ModelRenderer rightfoot;
    private ModelRenderer leftleg;
    private ModelRenderer leftleg2;
    private ModelRenderer leftleglow;
    private ModelRenderer leftfoot;
    private ModelMPM base;

    public ModelDigitigradeLegs(ModelMPM modelMPM) {
        super(modelMPM);
        this.base = modelMPM;
        this.rightleg = new ModelRenderer(modelMPM, 0, 16);
        this.rightleg.func_78789_a(-2.0f, 0.0f, -2.0f, 4, 6, 4);
        this.rightleg.func_78793_a(-2.1f, 11.0f, 0.0f);
        this.setRotation(this.rightleg, -0.3f, 0.0f, 0.0f);
        this.func_78792_a(this.rightleg);
        this.rightleg2 = new ModelRenderer(modelMPM, 0, 20);
        this.rightleg2.func_78789_a(-1.5f, -1.0f, -2.0f, 3, 7, 3);
        this.rightleg2.func_78793_a(0.0f, 4.1f, 0.0f);
        this.setRotation(this.rightleg2, 1.1f, 0.0f, 0.0f);
        this.rightleg.func_78792_a(this.rightleg2);
        this.rightleglow = new ModelRenderer(modelMPM, 0, 24);
        this.rightleglow.func_78789_a(-1.5f, 0.0f, -1.0f, 3, 5, 2);
        this.rightleglow.func_78793_a(0.0f, 5.0f, 0.0f);
        this.setRotation(this.rightleglow, -1.35f, 0.0f, 0.0f);
        this.rightleg2.func_78792_a(this.rightleglow);
        this.rightfoot = new ModelRenderer(modelMPM, 1, 26);
        this.rightfoot.func_78789_a(-1.5f, 0.0f, -5.0f, 3, 2, 4);
        this.rightfoot.func_78793_a(0.0f, 3.7f, 1.2f);
        this.setRotation(this.rightfoot, 0.55f, 0.0f, 0.0f);
        this.rightleglow.func_78792_a(this.rightfoot);
        this.leftleg = new ModelRenderer(modelMPM, 0, 16);
        this.leftleg.field_78809_i = true;
        this.leftleg.func_78789_a(-2.0f, 0.0f, -2.0f, 4, 6, 4);
        this.leftleg.func_78793_a(2.1f, 11.0f, 0.0f);
        this.setRotation(this.leftleg, -0.3f, 0.0f, 0.0f);
        this.func_78792_a(this.leftleg);
        this.leftleg2 = new ModelRenderer(modelMPM, 0, 20);
        this.leftleg2.field_78809_i = true;
        this.leftleg2.func_78789_a(-1.5f, -1.0f, -2.0f, 3, 7, 3);
        this.leftleg2.func_78793_a(0.0f, 4.1f, 0.0f);
        this.setRotation(this.leftleg2, 1.1f, 0.0f, 0.0f);
        this.leftleg.func_78792_a(this.leftleg2);
        this.leftleglow = new ModelRenderer(modelMPM, 0, 24);
        this.leftleglow.field_78809_i = true;
        this.leftleglow.func_78789_a(-1.5f, 0.0f, -1.0f, 3, 5, 2);
        this.leftleglow.func_78793_a(0.0f, 5.0f, 0.0f);
        this.setRotation(this.leftleglow, -1.35f, 0.0f, 0.0f);
        this.leftleg2.func_78792_a(this.leftleglow);
        this.leftfoot = new ModelRenderer(modelMPM, 1, 26);
        this.leftfoot.field_78809_i = true;
        this.leftfoot.func_78789_a(-1.5f, 0.0f, -5.0f, 3, 2, 4);
        this.leftfoot.func_78793_a(0.0f, 3.7f, 1.2f);
        this.setRotation(this.leftfoot, 0.55f, 0.0f, 0.0f);
        this.leftleglow.func_78792_a(this.leftfoot);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.rightleg.field_78795_f = this.base.bipedRightLeg.field_78795_f - 0.3f;
        this.leftleg.field_78795_f = this.base.bipedLeftLeg.field_78795_f - 0.3f;
        this.rightleg.field_78797_d = this.base.bipedRightLeg.field_78797_d;
        this.leftleg.field_78797_d = this.base.bipedLeftLeg.field_78797_d;
        this.rightleg.field_78798_e = this.base.bipedRightLeg.field_78798_e;
        this.leftleg.field_78798_e = this.base.bipedLeftLeg.field_78798_e;
        if (!this.base.isSneak) {
            this.leftleg.field_78797_d -= 1.0f;
            this.rightleg.field_78797_d -= 1.0f;
        }
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }
}

