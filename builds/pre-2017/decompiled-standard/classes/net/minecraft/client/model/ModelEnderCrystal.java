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
    public ModelRenderer field_78230_a;
    public ModelRenderer field_78228_b = new ModelRenderer(this, "glass");
    public ModelRenderer field_78229_c;

    public ModelEnderCrystal(float f, boolean bl) {
        this.field_78228_b.func_78784_a(0, 0).func_78789_a(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.field_78230_a = new ModelRenderer(this, "cube");
        this.field_78230_a.func_78784_a(32, 0).func_78789_a(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        if (bl) {
            this.field_78229_c = new ModelRenderer(this, "base");
            this.field_78229_c.func_78784_a(0, 16).func_78789_a(-6.0f, 0.0f, -6.0f, 12, 4, 12);
        }
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        GL11.glPushMatrix();
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glTranslatef(0.0f, -0.5f, 0.0f);
        if (this.field_78229_c != null) {
            this.field_78229_c.func_78785_a(f6);
        }
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.8f + f3, 0.0f);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        this.field_78228_b.func_78785_a(f6);
        float f7 = 0.875f;
        GL11.glScalef(f7, f7, f7);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        this.field_78228_b.func_78785_a(f6);
        GL11.glScalef(f7, f7, f7);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        this.field_78230_a.func_78785_a(f6);
        GL11.glPopMatrix();
    }
}

