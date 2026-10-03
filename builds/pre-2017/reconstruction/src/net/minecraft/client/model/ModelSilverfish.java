/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelSilverfish
extends ModelBase {
    public ModelRenderer[] silverfishBodyParts;
    public ModelRenderer[] silverfishWings;
    public float[] field_78170_c = new float[7];
    public static final int[][] silverfishBoxLength = new int[][]{{3, 2, 2}, {4, 3, 2}, {6, 4, 3}, {3, 3, 3}, {2, 2, 3}, {2, 1, 2}, {1, 1, 2}};
    public static final int[][] silverfishTexturePositions = new int[][]{{0, 0}, {0, 4}, {0, 9}, {0, 16}, {0, 22}, {11, 0}, {13, 4}};

    public ModelSilverfish() {
        this.silverfishBodyParts = new ModelRenderer[7];
        float f = -3.5f;
        for (int i = 0; i < this.silverfishBodyParts.length; ++i) {
            this.silverfishBodyParts[i] = new ModelRenderer(this, silverfishTexturePositions[i][0], silverfishTexturePositions[i][1]);
            this.silverfishBodyParts[i].addBox((float)silverfishBoxLength[i][0] * -0.5f, 0.0f, (float)silverfishBoxLength[i][2] * -0.5f, silverfishBoxLength[i][0], silverfishBoxLength[i][1], silverfishBoxLength[i][2]);
            this.silverfishBodyParts[i].setRotationPoint(0.0f, 24 - silverfishBoxLength[i][1], f);
            this.field_78170_c[i] = f;
            if (i >= this.silverfishBodyParts.length - 1) continue;
            f += (float)(silverfishBoxLength[i][2] + silverfishBoxLength[i + 1][2]) * 0.5f;
        }
        this.silverfishWings = new ModelRenderer[3];
        this.silverfishWings[0] = new ModelRenderer(this, 20, 0);
        this.silverfishWings[0].addBox(-5.0f, 0.0f, (float)silverfishBoxLength[2][2] * -0.5f, 10, 8, silverfishBoxLength[2][2]);
        this.silverfishWings[0].setRotationPoint(0.0f, 16.0f, this.field_78170_c[2]);
        this.silverfishWings[1] = new ModelRenderer(this, 20, 11);
        this.silverfishWings[1].addBox(-3.0f, 0.0f, (float)silverfishBoxLength[4][2] * -0.5f, 6, 4, silverfishBoxLength[4][2]);
        this.silverfishWings[1].setRotationPoint(0.0f, 20.0f, this.field_78170_c[4]);
        this.silverfishWings[2] = new ModelRenderer(this, 20, 18);
        this.silverfishWings[2].addBox(-3.0f, 0.0f, (float)silverfishBoxLength[4][2] * -0.5f, 6, 5, silverfishBoxLength[1][2]);
        this.silverfishWings[2].setRotationPoint(0.0f, 19.0f, this.field_78170_c[1]);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        int n;
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        for (n = 0; n < this.silverfishBodyParts.length; ++n) {
            this.silverfishBodyParts[n].render(f6);
        }
        for (n = 0; n < this.silverfishWings.length; ++n) {
            this.silverfishWings[n].render(f6);
        }
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        for (int i = 0; i < this.silverfishBodyParts.length; ++i) {
            this.silverfishBodyParts[i].rotateAngleY = sajh._b(f3 * 0.9f + (float)i * 0.15f * (float)Math.PI) * (float)Math.PI * 0.05f * (float)(1 + Math.abs(i - 2));
            this.silverfishBodyParts[i].rotationPointX = sajh._a(f3 * 0.9f + (float)i * 0.15f * (float)Math.PI) * (float)Math.PI * 0.2f * (float)Math.abs(i - 2);
        }
        this.silverfishWings[0].rotateAngleY = this.silverfishBodyParts[2].rotateAngleY;
        this.silverfishWings[1].rotateAngleY = this.silverfishBodyParts[4].rotateAngleY;
        this.silverfishWings[1].rotationPointX = this.silverfishBodyParts[4].rotationPointX;
        this.silverfishWings[2].rotateAngleY = this.silverfishBodyParts[1].rotateAngleY;
        this.silverfishWings[2].rotationPointX = this.silverfishBodyParts[1].rotationPointX;
    }
}

