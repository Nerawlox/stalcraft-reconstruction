/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class Model2DRenderer
extends ModelRenderer {
    private boolean compiled;
    private int displayList;
    private float x1;
    private float x2;
    private float y1;
    private float y2;
    private int width;
    private int height;
    private float rotationOffsetX;
    private float rotationOffsetY;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float thickness = 1.0f;

    public Model2DRenderer(ModelBase modelBase, float f, float f2, int n, int n2, float f3, float f4) {
        super(modelBase);
        this.width = n;
        this.height = n2;
        this.textureWidth = f3;
        this.textureHeight = f4;
        this.x1 = f / f3;
        this.y1 = f2 / f4;
        this.x2 = (f + (float)n) / f3;
        this.y2 = (f2 + (float)n2) / f4;
    }

    public Model2DRenderer(ModelBase modelBase, int n, int n2, int n3, int n4) {
        this(modelBase, n, n2, n3, n4, n3, n4);
    }

    @Override
    public void render(float f) {
        if (this.showModel && !this.isHidden) {
            if (!this.compiled) {
                this.compileDisplayList(f);
            }
            GL11.glPushMatrix();
            this.postRender(f);
            GL11.glCallList(this.displayList);
            GL11.glPopMatrix();
        }
    }

    public void setRotationOffset(float f, float f2) {
        this.rotationOffsetX = f;
        this.rotationOffsetY = f2;
    }

    public void setScale(float f) {
        this.scaleX = f;
        this.scaleY = f;
    }

    public void setScale(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }

    public void setThickness(float f) {
        this.thickness = f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    private void compileDisplayList(float f) {
        this.displayList = pklh._a(1);
        GL11.glNewList(this.displayList, 4864);
        GL11.glScalef(this.scaleX * (float)this.width / (float)this.height, this.scaleY, this.thickness);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        if (this.mirror) {
            GL11.glTranslatef(0.0f, 0.0f, -1.0f * f);
            GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        }
        GL11.glTranslated(this.rotationOffsetX * f, this.rotationOffsetY * f, 0.0);
        ItemRenderer.renderItemIn2D(Tessellator.instance, this.x1, this.y1, this.x2, this.y2, this.width, this.height, f);
        GL11.glEndList();
        this.compiled = true;
    }
}

