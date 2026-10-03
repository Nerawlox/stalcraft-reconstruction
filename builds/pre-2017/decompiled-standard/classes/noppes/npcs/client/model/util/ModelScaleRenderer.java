/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.util;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import noppes.npcs.ModelPartConfig;
import org.lwjgl.opengl.GL11;

public class ModelScaleRenderer
extends ModelRenderer {
    public boolean field_78812_q;
    public int field_78811_r;
    public float x;
    public float y;
    public float z;
    protected ModelPartConfig config;

    public ModelScaleRenderer(ModelBase modelBase) {
        super(modelBase);
    }

    public ModelScaleRenderer(ModelBase modelBase, int n, int n2) {
        this(modelBase);
        this.func_78784_a(n, n2);
    }

    public void setConfig(ModelPartConfig modelPartConfig, float f, float f2, float f3) {
        this.config = modelPartConfig;
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }

    public void renderChilderen(float f) {
        if (this.field_78806_j && !this.field_78807_k) {
            if (!this.field_78812_q) {
                this.func_78788_d(f);
            }
            GL11.glPushMatrix();
            GL11.glTranslatef(this.x, this.y, this.z);
            GL11.glTranslatef(this.config.transX, this.config.transY, this.config.transZ);
            this.func_78794_c(f);
            GL11.glScalef(this.config.scaleX, this.config.scaleY, this.config.scaleZ);
            GL11.glCallList(this.field_78811_r);
            if (this.field_78805_m != null) {
                for (int i = 0; i < this.field_78805_m.size(); ++i) {
                    ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(f);
                }
            }
            GL11.glPopMatrix();
        }
    }

    public void renderChild(float f, ModelRenderer modelRenderer) {
        if (this.field_78806_j && !this.field_78807_k) {
            GL11.glPushMatrix();
            GL11.glTranslatef(this.x, this.y, this.z);
            GL11.glTranslatef(this.config.transX, this.config.transY, this.config.transZ);
            this.func_78794_c(f);
            GL11.glScalef(this.config.scaleX, this.config.scaleY, this.config.scaleZ);
            modelRenderer.func_78785_a(f);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void func_78785_a(float f) {
        if (this.field_78806_j && !this.field_78807_k) {
            if (!this.field_78812_q) {
                this.func_78788_d(f);
            }
            GL11.glPushMatrix();
            GL11.glTranslatef(this.x, this.y, this.z);
            GL11.glTranslatef(this.config.transX, this.config.transY, this.config.transZ);
            this.func_78794_c(f);
            GL11.glScalef(this.config.scaleX, this.config.scaleY, this.config.scaleZ);
            GL11.glCallList(this.field_78811_r);
            if (this.field_78805_m != null) {
                for (int i = 0; i < this.field_78805_m.size(); ++i) {
                    ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(f);
                }
            }
            GL11.glPopMatrix();
        }
    }

    public void parentRender(float f) {
        super.func_78785_a(f);
    }

    @Override
    public void func_78788_d(float f) {
        this.field_78811_r = pklh._a(1);
        GL11.glNewList(this.field_78811_r, 4864);
        htvf htvf2 = htvf.field_78398_a;
        for (int i = 0; i < this.field_78804_l.size(); ++i) {
            ((ModelBox)this.field_78804_l.get(i)).func_78245_a(htvf2, f);
        }
        GL11.glEndList();
        this.field_78812_q = true;
    }
}

