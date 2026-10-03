/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class ModelRenderer {
    public float textureWidth = 64.0f;
    public float textureHeight = 32.0f;
    public int textureOffsetX;
    public int textureOffsetY;
    public float rotationPointX;
    public float rotationPointY;
    public float rotationPointZ;
    public float rotateAngleX;
    public float rotateAngleY;
    public float rotateAngleZ;
    public boolean compiled;
    public int displayList;
    public boolean mirror;
    public boolean showModel = true;
    public boolean isHidden;
    public List cubeList = new ArrayList();
    public List childModels;
    public final String boxName;
    public ModelBase baseModel;
    public float offsetX;
    public float offsetY;
    public float offsetZ;

    public ModelRenderer(ModelBase modelBase, String string) {
        this.baseModel = modelBase;
        modelBase.boxList.add(this);
        this.boxName = string;
        this.setTextureSize(modelBase.textureWidth, modelBase.textureHeight);
    }

    public ModelRenderer(ModelBase modelBase) {
        this(modelBase, null);
    }

    public ModelRenderer(ModelBase modelBase, int n, int n2) {
        this(modelBase);
        this.setTextureOffset(n, n2);
    }

    public void addChild(ModelRenderer modelRenderer) {
        if (this.childModels == null) {
            this.childModels = new ArrayList();
        }
        this.childModels.add(modelRenderer);
    }

    public ModelRenderer setTextureOffset(int n, int n2) {
        this.textureOffsetX = n;
        this.textureOffsetY = n2;
        return this;
    }

    public ModelRenderer addBox(String string, float f, float f2, float f3, int n, int n2, int n3) {
        string = this.boxName + "." + string;
        TextureOffset textureOffset = this.baseModel.getTextureOffset(string);
        this.setTextureOffset(textureOffset.textureOffsetX, textureOffset.textureOffsetY);
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, f, f2, f3, n, n2, n3, 0.0f).func_78244_a(string));
        return this;
    }

    public ModelRenderer addBox(float f, float f2, float f3, int n, int n2, int n3) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, f, f2, f3, n, n2, n3, 0.0f));
        return this;
    }

    public void addBox(float f, float f2, float f3, int n, int n2, int n3, float f4) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, f, f2, f3, n, n2, n3, f4));
    }

    public void setRotationPoint(float f, float f2, float f3) {
        this.rotationPointX = f;
        this.rotationPointY = f2;
        this.rotationPointZ = f3;
    }

    @SideOnly(value=Side.CLIENT)
    public void render(float f) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(f);
            }
            GL11.glTranslatef(this.offsetX, this.offsetY, this.offsetZ);
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX == 0.0f && this.rotationPointY == 0.0f && this.rotationPointZ == 0.0f) {
                    GL11.glCallList(this.displayList);
                    if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            ((ModelRenderer)this.childModels.get(i)).render(f);
                        }
                    }
                } else {
                    GL11.glTranslatef(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
                    GL11.glCallList(this.displayList);
                    if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            ((ModelRenderer)this.childModels.get(i)).render(f);
                        }
                    }
                    GL11.glTranslatef(-this.rotationPointX * f, -this.rotationPointY * f, -this.rotationPointZ * f);
                }
            } else {
                GL11.glPushMatrix();
                GL11.glTranslatef(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
                if (this.rotateAngleZ != 0.0f) {
                    GL11.glRotatef(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GL11.glRotatef(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GL11.glRotatef(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
                GL11.glCallList(this.displayList);
                if (this.childModels != null) {
                    for (int i = 0; i < this.childModels.size(); ++i) {
                        ((ModelRenderer)this.childModels.get(i)).render(f);
                    }
                }
                GL11.glPopMatrix();
            }
            GL11.glTranslatef(-this.offsetX, -this.offsetY, -this.offsetZ);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void renderWithRotation(float f) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(f);
            }
            GL11.glPushMatrix();
            GL11.glTranslatef(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
            if (this.rotateAngleY != 0.0f) {
                GL11.glRotatef(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
            }
            if (this.rotateAngleX != 0.0f) {
                GL11.glRotatef(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
            }
            if (this.rotateAngleZ != 0.0f) {
                GL11.glRotatef(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
            }
            GL11.glCallList(this.displayList);
            GL11.glPopMatrix();
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void postRender(float f) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(f);
            }
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX != 0.0f || this.rotationPointY != 0.0f || this.rotationPointZ != 0.0f) {
                    GL11.glTranslatef(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
                }
            } else {
                GL11.glTranslatef(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
                if (this.rotateAngleZ != 0.0f) {
                    GL11.glRotatef(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GL11.glRotatef(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GL11.glRotatef(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
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

    public ModelRenderer setTextureSize(int n, int n2) {
        this.textureWidth = n;
        this.textureHeight = n2;
        return this;
    }
}

