/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAnvil
extends ModelBase {
    ModelRenderer Tail;
    ModelRenderer Nose1;
    ModelRenderer Nose2;
    ModelRenderer Nose3;
    ModelRenderer Nose4;
    ModelRenderer Head1;
    ModelRenderer Head2;
    ModelRenderer Neck2;
    ModelRenderer Bottom2;
    ModelRenderer Bottom3;
    ModelRenderer Foot4;

    public ModelAnvil() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Tail = new ModelRenderer(this, 0, 0);
        this.Tail.addBox(0.0f, 0.0f, 0.0f, 1, 2, 4);
        this.Tail.setRotationPoint(-7.0f, 12.0f, -2.0f);
        this.Nose1 = new ModelRenderer(this, 0, 0);
        this.Nose1.addBox(0.0f, 0.0f, 0.0f, 1, 5, 6);
        this.Nose1.setRotationPoint(6.0f, 10.0f, -3.0f);
        this.Nose2 = new ModelRenderer(this, 0, 0);
        this.Nose2.addBox(0.0f, 0.0f, 0.0f, 1, 4, 5);
        this.Nose2.setRotationPoint(7.0f, 10.0f, -2.5f);
        this.Nose3 = new ModelRenderer(this, 0, 0);
        this.Nose3.addBox(0.0f, 0.0f, 0.0f, 1, 3, 4);
        this.Nose3.setRotationPoint(8.0f, 10.0f, -2.0f);
        this.Nose4 = new ModelRenderer(this, 0, 0);
        this.Nose4.addBox(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.Nose4.setRotationPoint(9.0f, 10.0f, -1.0f);
        this.Head1 = new ModelRenderer(this, 0, 0);
        this.Head1.addBox(0.0f, 0.0f, 0.0f, 12, 4, 7);
        this.Head1.setRotationPoint(-6.0f, 12.0f, -3.5f);
        this.Head2 = new ModelRenderer(this, 0, 0);
        this.Head2.addBox(0.0f, 0.0f, 0.0f, 14, 2, 9);
        this.Head2.setRotationPoint(-8.0f, 10.0f, -4.5f);
        this.Neck2 = new ModelRenderer(this, 0, 0);
        this.Neck2.addBox(0.0f, 0.0f, 0.0f, 10, 1, 6);
        this.Neck2.setRotationPoint(-5.0f, 16.0f, -3.0f);
        this.Bottom2 = new ModelRenderer(this, 0, 0);
        this.Bottom2.addBox(0.0f, 0.0f, 0.0f, 10, 2, 7);
        this.Bottom2.setRotationPoint(-5.0f, 20.0f, -3.5f);
        this.Bottom3 = new ModelRenderer(this, 0, 0);
        this.Bottom3.addBox(0.0f, 0.0f, 0.0f, 8, 3, 4);
        this.Bottom3.setRotationPoint(-4.0f, 17.0f, -2.0f);
        this.Foot4 = new ModelRenderer(this, 0, 0);
        this.Foot4.addBox(0.0f, 0.0f, 0.0f, 14, 2, 10);
        this.Foot4.setRotationPoint(-7.0f, 22.0f, -5.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f, f2, f3, f4, f5, f6);
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        this.Tail.render(f6);
        this.Nose1.render(f6);
        this.Nose2.render(f6);
        this.Nose3.render(f6);
        this.Nose4.render(f6);
        this.Head1.render(f6);
        this.Head2.render(f6);
        this.Neck2.render(f6);
        this.Bottom2.render(f6);
        this.Bottom3.render(f6);
        this.Foot4.render(f6);
    }
}

