/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Vec3;

public class TexturedQuad {
    public PositionTextureVertex[] vertexPositions;
    public int nVertices;
    public boolean invertNormal;

    public TexturedQuad(PositionTextureVertex[] positionTextureVertexArray) {
        this.vertexPositions = positionTextureVertexArray;
        this.nVertices = positionTextureVertexArray.length;
    }

    public TexturedQuad(PositionTextureVertex[] positionTextureVertexArray, int n, int n2, int n3, int n4, float f, float f2) {
        this(positionTextureVertexArray);
        float f3 = 0.0f / f;
        float f4 = 0.0f / f2;
        positionTextureVertexArray[0] = positionTextureVertexArray[0].setTexturePosition((float)n3 / f - f3, (float)n2 / f2 + f4);
        positionTextureVertexArray[1] = positionTextureVertexArray[1].setTexturePosition((float)n / f + f3, (float)n2 / f2 + f4);
        positionTextureVertexArray[2] = positionTextureVertexArray[2].setTexturePosition((float)n / f + f3, (float)n4 / f2 - f4);
        positionTextureVertexArray[3] = positionTextureVertexArray[3].setTexturePosition((float)n3 / f - f3, (float)n4 / f2 - f4);
    }

    public void flipFace() {
        PositionTextureVertex[] positionTextureVertexArray = new PositionTextureVertex[this.vertexPositions.length];
        for (int i = 0; i < this.vertexPositions.length; ++i) {
            positionTextureVertexArray[i] = this.vertexPositions[this.vertexPositions.length - i - 1];
        }
        this.vertexPositions = positionTextureVertexArray;
    }

    public void draw(Tessellator tessellator, float f) {
        Vec3 vec3 = this.vertexPositions[1].vector3D._a(this.vertexPositions[0].vector3D);
        Vec3 vec32 = this.vertexPositions[1].vector3D._a(this.vertexPositions[2].vector3D);
        Vec3 vec33 = vec32._c(vec3)._a();
        tessellator.startDrawingQuads();
        if (this.invertNormal) {
            tessellator.setNormal(-((float)vec33._c), -((float)vec33._d), -((float)vec33._e));
        } else {
            tessellator.setNormal((float)vec33._c, (float)vec33._d, (float)vec33._e);
        }
        for (int i = 0; i < 4; ++i) {
            PositionTextureVertex positionTextureVertex = this.vertexPositions[i];
            tessellator.addVertexWithUV((float)positionTextureVertex.vector3D._c * f, (float)positionTextureVertex.vector3D._d * f, (float)positionTextureVertex.vector3D._e * f, positionTextureVertex.texturePositionX, positionTextureVertex.texturePositionY);
        }
        tessellator.draw();
    }
}

