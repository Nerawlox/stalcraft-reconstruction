/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMailboxWow
extends ModelBase {
    ModelRenderer Shape4;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;

    public ModelMailboxWow() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Shape4 = new ModelRenderer(this, 59, 0);
        this.Shape4.addBox(0.0f, 0.0f, 0.0f, 8, 6, 0);
        this.Shape4.setRotationPoint(-4.0f, -4.0f, 0.0f);
        this.Shape1 = new ModelRenderer(this, 0, 39);
        this.Shape1.addBox(0.0f, 0.0f, 0.0f, 8, 5, 8);
        this.Shape1.setRotationPoint(-4.0f, 19.0f, -4.0f);
        this.Shape2 = new ModelRenderer(this, 0, 21);
        this.Shape2.addBox(0.0f, 0.0f, 0.0f, 6, 9, 6);
        this.Shape2.setRotationPoint(-3.0f, 10.0f, -3.0f);
        this.Shape3 = new ModelRenderer(this, 0, 0);
        this.Shape3.addBox(0.0f, 0.0f, 0.0f, 12, 8, 12);
        this.Shape3.setRotationPoint(-6.0f, 2.0f, -6.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f, f2, f3, f4, f5, f6);
        this.Shape4.render(f6);
        this.Shape1.render(f6);
        this.Shape2.render(f6);
        this.Shape3.render(f6);
    }
}

