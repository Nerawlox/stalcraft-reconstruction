/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;
import noppes.npcs.entity.EntityNpcCrystal;
import org.lwjgl.opengl.GL11;

public class ModelNpcCrystal
extends ModelBase {
    float ticks;
    private ModelRenderer field_41057_g;
    private ModelRenderer field_41058_h = new ModelRenderer(this, "glass");
    private ModelRenderer field_41059_i;

    public ModelNpcCrystal(float f) {
        this.field_41058_h.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.field_41057_g = new ModelRenderer(this, "cube");
        this.field_41057_g.setTextureOffset(32, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.field_41059_i = new ModelRenderer(this, "base");
        this.field_41059_i.setTextureOffset(0, 16).addBox(-6.0f, 16.0f, -6.0f, 12, 4, 12);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.ticks = f3;
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        EntityNpcCrystal entityNpcCrystal = (EntityNpcCrystal)entity;
        GL11.glPushMatrix();
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glTranslatef(0.0f, -0.5f, 0.0f);
        this.field_41059_i.render(f6);
        float f7 = (float)entityNpcCrystal.innerRotation + this.ticks;
        float f8 = sajh._a(f7 * 0.2f) / 2.0f + 0.5f;
        f8 += f8 * f8;
        f2 = f7 * 3.0f;
        f3 = f8 * 0.2f;
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.1f + f3, 0.0f);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        this.field_41058_h.render(f6);
        float f9 = 0.875f;
        GL11.glScalef(f9, f9, f9);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        this.field_41058_h.render(f6);
        GL11.glScalef(f9, f9, f9);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        this.field_41057_g.render(f6);
        GL11.glPopMatrix();
    }
}

