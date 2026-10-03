/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.util.ofbx;

public class TexturedQuad {
    public PositionTextureVertex[] field_78239_a;
    public int field_78237_b;
    public boolean field_78238_c;

    public TexturedQuad(PositionTextureVertex[] positionTextureVertexArray) {
        this.field_78239_a = positionTextureVertexArray;
        this.field_78237_b = positionTextureVertexArray.length;
    }

    public TexturedQuad(PositionTextureVertex[] positionTextureVertexArray, int n, int n2, int n3, int n4, float f, float f2) {
        this(positionTextureVertexArray);
        float f3 = 0.0f / f;
        float f4 = 0.0f / f2;
        positionTextureVertexArray[0] = positionTextureVertexArray[0].func_78240_a((float)n3 / f - f3, (float)n2 / f2 + f4);
        positionTextureVertexArray[1] = positionTextureVertexArray[1].func_78240_a((float)n / f + f3, (float)n2 / f2 + f4);
        positionTextureVertexArray[2] = positionTextureVertexArray[2].func_78240_a((float)n / f + f3, (float)n4 / f2 - f4);
        positionTextureVertexArray[3] = positionTextureVertexArray[3].func_78240_a((float)n3 / f - f3, (float)n4 / f2 - f4);
    }

    public void func_78235_a() {
        PositionTextureVertex[] positionTextureVertexArray = new PositionTextureVertex[this.field_78239_a.length];
        for (int i = 0; i < this.field_78239_a.length; ++i) {
            positionTextureVertexArray[i] = this.field_78239_a[this.field_78239_a.length - i - 1];
        }
        this.field_78239_a = positionTextureVertexArray;
    }

    public void func_78236_a(htvf htvf2, float f) {
        ofbx ofbx2 = this.field_78239_a[1].field_78243_a._a(this.field_78239_a[0].field_78243_a);
        ofbx ofbx3 = this.field_78239_a[1].field_78243_a._a(this.field_78239_a[2].field_78243_a);
        ofbx ofbx4 = ofbx3._c(ofbx2)._a();
        htvf2.func_78382_b();
        if (this.field_78238_c) {
            htvf2.func_78375_b(-((float)ofbx4._c), -((float)ofbx4._d), -((float)ofbx4._e));
        } else {
            htvf2.func_78375_b((float)ofbx4._c, (float)ofbx4._d, (float)ofbx4._e);
        }
        for (int i = 0; i < 4; ++i) {
            PositionTextureVertex positionTextureVertex = this.field_78239_a[i];
            htvf2.func_78374_a((float)positionTextureVertex.field_78243_a._c * f, (float)positionTextureVertex.field_78243_a._d * f, (float)positionTextureVertex.field_78243_a._e * f, positionTextureVertex.field_78241_b, positionTextureVertex.field_78242_c);
        }
        htvf2.func_78381_a();
    }
}

