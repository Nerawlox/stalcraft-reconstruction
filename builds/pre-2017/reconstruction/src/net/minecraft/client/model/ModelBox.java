/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.Tessellator;

public class ModelBox {
    public PositionTextureVertex[] vertexPositions;
    public TexturedQuad[] quadList;
    public final float posX1;
    public final float posY1;
    public final float posZ1;
    public final float posX2;
    public final float posY2;
    public final float posZ2;
    public String field_78247_g;

    public ModelBox(ModelRenderer modelRenderer, int n, int n2, float f, float f2, float f3, int n3, int n4, int n5, float f4) {
        this.posX1 = f;
        this.posY1 = f2;
        this.posZ1 = f3;
        this.posX2 = f + (float)n3;
        this.posY2 = f2 + (float)n4;
        this.posZ2 = f3 + (float)n5;
        this.vertexPositions = new PositionTextureVertex[8];
        this.quadList = new TexturedQuad[6];
        float f5 = f + (float)n3;
        float f6 = f2 + (float)n4;
        float f7 = f3 + (float)n5;
        f -= f4;
        f2 -= f4;
        f3 -= f4;
        f5 += f4;
        f6 += f4;
        f7 += f4;
        if (modelRenderer.mirror) {
            float f8 = f5;
            f5 = f;
            f = f8;
        }
        PositionTextureVertex positionTextureVertex = new PositionTextureVertex(f, f2, f3, 0.0f, 0.0f);
        PositionTextureVertex positionTextureVertex2 = new PositionTextureVertex(f5, f2, f3, 0.0f, 8.0f);
        PositionTextureVertex positionTextureVertex3 = new PositionTextureVertex(f5, f6, f3, 8.0f, 8.0f);
        PositionTextureVertex positionTextureVertex4 = new PositionTextureVertex(f, f6, f3, 8.0f, 0.0f);
        PositionTextureVertex positionTextureVertex5 = new PositionTextureVertex(f, f2, f7, 0.0f, 0.0f);
        PositionTextureVertex positionTextureVertex6 = new PositionTextureVertex(f5, f2, f7, 0.0f, 8.0f);
        PositionTextureVertex positionTextureVertex7 = new PositionTextureVertex(f5, f6, f7, 8.0f, 8.0f);
        PositionTextureVertex positionTextureVertex8 = new PositionTextureVertex(f, f6, f7, 8.0f, 0.0f);
        this.vertexPositions[0] = positionTextureVertex;
        this.vertexPositions[1] = positionTextureVertex2;
        this.vertexPositions[2] = positionTextureVertex3;
        this.vertexPositions[3] = positionTextureVertex4;
        this.vertexPositions[4] = positionTextureVertex5;
        this.vertexPositions[5] = positionTextureVertex6;
        this.vertexPositions[6] = positionTextureVertex7;
        this.vertexPositions[7] = positionTextureVertex8;
        this.quadList[0] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex6, positionTextureVertex2, positionTextureVertex3, positionTextureVertex7}, n + n5 + n3, n2 + n5, n + n5 + n3 + n5, n2 + n5 + n4, modelRenderer.textureWidth, modelRenderer.textureHeight);
        this.quadList[1] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex, positionTextureVertex5, positionTextureVertex8, positionTextureVertex4}, n, n2 + n5, n + n5, n2 + n5 + n4, modelRenderer.textureWidth, modelRenderer.textureHeight);
        this.quadList[2] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex6, positionTextureVertex5, positionTextureVertex, positionTextureVertex2}, n + n5, n2, n + n5 + n3, n2 + n5, modelRenderer.textureWidth, modelRenderer.textureHeight);
        this.quadList[3] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex3, positionTextureVertex4, positionTextureVertex8, positionTextureVertex7}, n + n5 + n3, n2 + n5, n + n5 + n3 + n3, n2, modelRenderer.textureWidth, modelRenderer.textureHeight);
        this.quadList[4] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex2, positionTextureVertex, positionTextureVertex4, positionTextureVertex3}, n + n5, n2 + n5, n + n5 + n3, n2 + n5 + n4, modelRenderer.textureWidth, modelRenderer.textureHeight);
        this.quadList[5] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex5, positionTextureVertex6, positionTextureVertex7, positionTextureVertex8}, n + n5 + n3 + n5, n2 + n5, n + n5 + n3 + n5 + n3, n2 + n5 + n4, modelRenderer.textureWidth, modelRenderer.textureHeight);
        if (modelRenderer.mirror) {
            for (int i = 0; i < this.quadList.length; ++i) {
                this.quadList[i].flipFace();
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void render(Tessellator tessellator, float f) {
        for (int i = 0; i < this.quadList.length; ++i) {
            this.quadList[i].draw(tessellator, f);
        }
    }

    public ModelBox func_78244_a(String string) {
        this.field_78247_g = string;
        return this;
    }
}

