/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.util;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import noppes.npcs.ModelPartConfig;
import org.lwjgl.opengl.GL11;

public class ModelScaleRenderer
extends ModelRenderer {
    public boolean compiled;
    public int displayList;
    public float x;
    public float y;
    public float z;
    protected ModelPartConfig config;

    public ModelScaleRenderer(ModelBase modelBase) {
        super(modelBase);
    }

    public ModelScaleRenderer(ModelBase modelBase, int n, int n2) {
        this(modelBase);
        this.setTextureOffset(n, n2);
    }

    public void setConfig(ModelPartConfig modelPartConfig, float f, float f2, float f3) {
        this.config = modelPartConfig;
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.rotateAngleX = f;
        modelRenderer.rotateAngleY = f2;
        modelRenderer.rotateAngleZ = f3;
    }

    public void renderChilderen(float f) {
        if (this.showModel && !this.isHidden) {
            if (!this.compiled) {
                this.compileDisplayList(f);
            }
            GL11.glPushMatrix();
            GL11.glTranslatef(this.x, this.y, this.z);
            GL11.glTranslatef(this.config.transX, this.config.transY, this.config.transZ);
            this.postRender(f);
            GL11.glScalef(this.config.scaleX, this.config.scaleY, this.config.scaleZ);
            GL11.glCallList(this.displayList);
            if (this.childModels != null) {
                for (int i = 0; i < this.childModels.size(); ++i) {
                    ((ModelRenderer)this.childModels.get(i)).render(f);
                }
            }
            GL11.glPopMatrix();
        }
    }

    public void renderChild(float f, ModelRenderer modelRenderer) {
        if (this.showModel && !this.isHidden) {
            GL11.glPushMatrix();
            GL11.glTranslatef(this.x, this.y, this.z);
            GL11.glTranslatef(this.config.transX, this.config.transY, this.config.transZ);
            this.postRender(f);
            GL11.glScalef(this.config.scaleX, this.config.scaleY, this.config.scaleZ);
            modelRenderer.render(f);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void render(float f) {
        if (this.showModel && !this.isHidden) {
            if (!this.compiled) {
                this.compileDisplayList(f);
            }
            GL11.glPushMatrix();
            GL11.glTranslatef(this.x, this.y, this.z);
            GL11.glTranslatef(this.config.transX, this.config.transY, this.config.transZ);
            this.postRender(f);
            GL11.glScalef(this.config.scaleX, this.config.scaleY, this.config.scaleZ);
            GL11.glCallList(this.displayList);
            if (this.childModels != null) {
                for (int i = 0; i < this.childModels.size(); ++i) {
                    ((ModelRenderer)this.childModels.get(i)).render(f);
                }
            }
            GL11.glPopMatrix();
        }
    }

    public void parentRender(float f) {
        super.render(f);
    }

    @Override
    public void compileDisplayList(float f) {
        this.displayList = pklh._a(1);
        GL11.glNewList(this.displayList, 4864);
        Tessellator tessellator = Tessellator.instance;
        for (int i = 0; i < this.cubeList.size(); ++i) {
            ((ModelBox)this.cubeList.get(i)).render(tessellator, f);
        }
        GL11.glEndList();
        this.compiled = true;
    }
}

