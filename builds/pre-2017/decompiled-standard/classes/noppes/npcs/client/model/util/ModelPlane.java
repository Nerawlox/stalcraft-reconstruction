/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.util;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import noppes.npcs.client.renderer.EnumPlanePosition;

public class ModelPlane
extends ModelBox {
    private PositionTextureVertex[] field_78253_h = new PositionTextureVertex[8];
    private TexturedQuad quad;

    public ModelPlane(ModelRenderer modelRenderer, int n, int n2, float f, float f2, float f3, int n3, int n4, int n5, float f4, EnumPlanePosition enumPlanePosition) {
        super(modelRenderer, n, n2, f, f2, f3, n3, n4, n5, f4);
        float f5 = f + (float)n3;
        float f6 = f2 + (float)n4;
        float f7 = f3 + (float)n5;
        f -= f4;
        f2 -= f4;
        f3 -= f4;
        f5 += f4;
        f6 += f4;
        f7 += f4;
        if (modelRenderer.field_78809_i) {
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
        this.field_78253_h[0] = positionTextureVertex;
        this.field_78253_h[1] = positionTextureVertex2;
        this.field_78253_h[2] = positionTextureVertex3;
        this.field_78253_h[3] = positionTextureVertex4;
        this.field_78253_h[4] = positionTextureVertex5;
        this.field_78253_h[5] = positionTextureVertex6;
        this.field_78253_h[6] = positionTextureVertex7;
        this.field_78253_h[7] = positionTextureVertex8;
        if (enumPlanePosition == EnumPlanePosition.LEFT) {
            this.quad = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex6, positionTextureVertex2, positionTextureVertex3, positionTextureVertex7}, n, n2, n + n5, n2 + n4, modelRenderer.field_78801_a, modelRenderer.field_78799_b);
        }
        if (enumPlanePosition == EnumPlanePosition.TOP) {
            this.quad = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex6, positionTextureVertex5, positionTextureVertex, positionTextureVertex2}, n, n2, n + n3, n2 + n5, modelRenderer.field_78801_a, modelRenderer.field_78799_b);
        }
        if (enumPlanePosition == EnumPlanePosition.BACK) {
            this.quad = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex2, positionTextureVertex, positionTextureVertex4, positionTextureVertex3}, n, n2, n + n3, n2 + n4, modelRenderer.field_78801_a, modelRenderer.field_78799_b);
        }
        if (modelRenderer.field_78809_i) {
            this.quad.func_78235_a();
        }
    }

    @Override
    public void func_78245_a(htvf htvf2, float f) {
        this.quad.func_78236_a(htvf2, f);
    }
}

