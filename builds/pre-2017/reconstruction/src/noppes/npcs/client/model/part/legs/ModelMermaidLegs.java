/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part.legs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelMermaidLegs
extends ModelRenderer {
    ModelRenderer top;
    ModelRenderer middle;
    ModelRenderer bottom;
    ModelRenderer fin1;
    ModelRenderer fin2;

    public ModelMermaidLegs(ModelBase modelBase) {
        super(modelBase);
        this.textureWidth = 64.0f;
        this.textureHeight = 32.0f;
        this.top = new ModelRenderer(modelBase, 0, 16);
        this.top.addBox(-2.0f, -2.5f, -2.0f, 8, 9, 4);
        this.top.setRotationPoint(-2.0f, 14.0f, 1.0f);
        this.setRotation(this.top, 0.26f, 0.0f, 0.0f);
        this.middle = new ModelRenderer(modelBase, 28, 0);
        this.middle.addBox(0.0f, 0.0f, 0.0f, 7, 6, 4);
        this.middle.setRotationPoint(-1.5f, 6.5f, -1.0f);
        this.setRotation(this.middle, 0.86f, 0.0f, 0.0f);
        this.top.addChild(this.middle);
        this.bottom = new ModelRenderer(modelBase, 24, 16);
        this.bottom.addBox(0.0f, 0.0f, 0.0f, 6, 7, 3);
        this.bottom.setRotationPoint(0.5f, 6.0f, 0.5f);
        this.setRotation(this.bottom, 0.15f, 0.0f, 0.0f);
        this.middle.addChild(this.bottom);
        this.fin1 = new ModelRenderer(modelBase, 0, 0);
        this.fin1.addBox(0.0f, 0.0f, 0.0f, 5, 9, 1);
        this.fin1.setRotationPoint(0.0f, 4.5f, 1.0f);
        this.setRotation(this.fin1, 0.05f, 0.0f, 0.5911399f);
        this.bottom.addChild(this.fin1);
        this.fin2 = new ModelRenderer(modelBase, 0, 0);
        this.fin2.mirror = true;
        this.fin2.addBox(-5.0f, 0.0f, 0.0f, 5, 9, 1);
        this.fin2.setRotationPoint(6.0f, 4.5f, 1.0f);
        this.setRotation(this.fin2, 0.05f, 0.0f, -0.591143f);
        this.bottom.addChild(this.fin2);
    }

    @Override
    public void render(float f) {
        if (!this.isHidden && this.showModel) {
            this.top.render(f);
        }
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.rotateAngleX = f;
        modelRenderer.rotateAngleY = f2;
        modelRenderer.rotateAngleZ = f3;
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        float f7 = sajh._a(f * 0.6662f);
        if ((double)f7 > 0.2) {
            f7 /= 3.0f;
        }
        this.top.rotateAngleX = 0.26f - f7 * 0.2f * f2;
        this.middle.rotateAngleX = 0.86f - f7 * 0.24f * f2;
        this.bottom.rotateAngleX = 0.15f - f7 * 0.28f * f2;
        this.fin2.rotateAngleX = this.fin1.rotateAngleX = 0.05f - f7 * 0.35f * f2;
    }
}

