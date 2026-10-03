/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;

public class ModelBox {
    public PositionTextureVertex[] field_78253_h;
    public TexturedQuad[] field_78254_i;
    public final float field_78252_a;
    public final float field_78250_b;
    public final float field_78251_c;
    public final float field_78248_d;
    public final float field_78249_e;
    public final float field_78246_f;
    public String field_78247_g;

    public ModelBox(ModelRenderer modelRenderer, int n, int n2, float f, float f2, float f3, int n3, int n4, int n5, float f4) {
        this.field_78252_a = f;
        this.field_78250_b = f2;
        this.field_78251_c = f3;
        this.field_78248_d = f + (float)n3;
        this.field_78249_e = f2 + (float)n4;
        this.field_78246_f = f3 + (float)n5;
        this.field_78253_h = new PositionTextureVertex[8];
        this.field_78254_i = new TexturedQuad[6];
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
        this.field_78254_i[0] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex6, positionTextureVertex2, positionTextureVertex3, positionTextureVertex7}, n + n5 + n3, n2 + n5, n + n5 + n3 + n5, n2 + n5 + n4, modelRenderer.field_78801_a, modelRenderer.field_78799_b);
        this.field_78254_i[1] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex, positionTextureVertex5, positionTextureVertex8, positionTextureVertex4}, n, n2 + n5, n + n5, n2 + n5 + n4, modelRenderer.field_78801_a, modelRenderer.field_78799_b);
        this.field_78254_i[2] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex6, positionTextureVertex5, positionTextureVertex, positionTextureVertex2}, n + n5, n2, n + n5 + n3, n2 + n5, modelRenderer.field_78801_a, modelRenderer.field_78799_b);
        this.field_78254_i[3] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex3, positionTextureVertex4, positionTextureVertex8, positionTextureVertex7}, n + n5 + n3, n2 + n5, n + n5 + n3 + n3, n2, modelRenderer.field_78801_a, modelRenderer.field_78799_b);
        this.field_78254_i[4] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex2, positionTextureVertex, positionTextureVertex4, positionTextureVertex3}, n + n5, n2 + n5, n + n5 + n3, n2 + n5 + n4, modelRenderer.field_78801_a, modelRenderer.field_78799_b);
        this.field_78254_i[5] = new TexturedQuad(new PositionTextureVertex[]{positionTextureVertex5, positionTextureVertex6, positionTextureVertex7, positionTextureVertex8}, n + n5 + n3 + n5, n2 + n5, n + n5 + n3 + n5 + n3, n2 + n5 + n4, modelRenderer.field_78801_a, modelRenderer.field_78799_b);
        if (modelRenderer.field_78809_i) {
            for (int i = 0; i < this.field_78254_i.length; ++i) {
                this.field_78254_i[i].func_78235_a();
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_78245_a(htvf htvf2, float f) {
        for (int i = 0; i < this.field_78254_i.length; ++i) {
            this.field_78254_i[i].func_78236_a(htvf2, f);
        }
    }

    public ModelBox func_78244_a(String string) {
        this.field_78247_g = string;
        return this;
    }
}

