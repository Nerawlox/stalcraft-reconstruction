/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelEnderCrystal
extends ModelBase {
    public ModelRenderer cube;
    public ModelRenderer glass = new ModelRenderer(this, "glass");
    public ModelRenderer base;

    public ModelEnderCrystal(float f, boolean bl) {
        this.glass.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.cube = new ModelRenderer(this, "cube");
        this.cube.setTextureOffset(32, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        if (bl) {
            this.base = new ModelRenderer(this, "base");
            this.base.setTextureOffset(0, 16).addBox(-6.0f, 0.0f, -6.0f, 12, 4, 12);
        }
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        GL11.glPushMatrix();
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glTranslatef(0.0f, -0.5f, 0.0f);
        if (this.base != null) {
            this.base.render(f6);
        }
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.8f + f3, 0.0f);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        this.glass.render(f6);
        float f7 = 0.875f;
        GL11.glScalef(f7, f7, f7);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        this.glass.render(f6);
        GL11.glScalef(f7, f7, f7);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        this.cube.render(f6);
        GL11.glPopMatrix();
    }
}

