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
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.Tail = new ModelRenderer(this, 0, 0);
        this.Tail.func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 4);
        this.Tail.func_78793_a(-7.0f, 12.0f, -2.0f);
        this.Nose1 = new ModelRenderer(this, 0, 0);
        this.Nose1.func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 6);
        this.Nose1.func_78793_a(6.0f, 10.0f, -3.0f);
        this.Nose2 = new ModelRenderer(this, 0, 0);
        this.Nose2.func_78789_a(0.0f, 0.0f, 0.0f, 1, 4, 5);
        this.Nose2.func_78793_a(7.0f, 10.0f, -2.5f);
        this.Nose3 = new ModelRenderer(this, 0, 0);
        this.Nose3.func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 4);
        this.Nose3.func_78793_a(8.0f, 10.0f, -2.0f);
        this.Nose4 = new ModelRenderer(this, 0, 0);
        this.Nose4.func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.Nose4.func_78793_a(9.0f, 10.0f, -1.0f);
        this.Head1 = new ModelRenderer(this, 0, 0);
        this.Head1.func_78789_a(0.0f, 0.0f, 0.0f, 12, 4, 7);
        this.Head1.func_78793_a(-6.0f, 12.0f, -3.5f);
        this.Head2 = new ModelRenderer(this, 0, 0);
        this.Head2.func_78789_a(0.0f, 0.0f, 0.0f, 14, 2, 9);
        this.Head2.func_78793_a(-8.0f, 10.0f, -4.5f);
        this.Neck2 = new ModelRenderer(this, 0, 0);
        this.Neck2.func_78789_a(0.0f, 0.0f, 0.0f, 10, 1, 6);
        this.Neck2.func_78793_a(-5.0f, 16.0f, -3.0f);
        this.Bottom2 = new ModelRenderer(this, 0, 0);
        this.Bottom2.func_78789_a(0.0f, 0.0f, 0.0f, 10, 2, 7);
        this.Bottom2.func_78793_a(-5.0f, 20.0f, -3.5f);
        this.Bottom3 = new ModelRenderer(this, 0, 0);
        this.Bottom3.func_78789_a(0.0f, 0.0f, 0.0f, 8, 3, 4);
        this.Bottom3.func_78793_a(-4.0f, 17.0f, -2.0f);
        this.Foot4 = new ModelRenderer(this, 0, 0);
        this.Foot4.func_78789_a(0.0f, 0.0f, 0.0f, 14, 2, 10);
        this.Foot4.func_78793_a(-7.0f, 22.0f, -5.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_78088_a(entity, f, f2, f3, f4, f5, f6);
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.Tail.func_78785_a(f6);
        this.Nose1.func_78785_a(f6);
        this.Nose2.func_78785_a(f6);
        this.Nose3.func_78785_a(f6);
        this.Nose4.func_78785_a(f6);
        this.Head1.func_78785_a(f6);
        this.Head2.func_78785_a(f6);
        this.Neck2.func_78785_a(f6);
        this.Bottom2.func_78785_a(f6);
        this.Bottom3.func_78785_a(f6);
        this.Foot4.func_78785_a(f6);
    }
}

