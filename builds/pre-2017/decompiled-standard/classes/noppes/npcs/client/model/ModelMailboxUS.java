/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMailboxUS
extends ModelBase {
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;

    public ModelMailboxUS() {
        this.field_78090_t = 64;
        this.field_78089_u = 128;
        this.Shape1 = new ModelRenderer(this, 0, 48);
        this.Shape1.func_78789_a(0.0f, 0.0f, 0.0f, 16, 14, 16);
        this.Shape1.func_78793_a(-8.0f, 8.0f, -8.0f);
        this.Shape2 = new ModelRenderer(this, 0, 79);
        this.Shape2.func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Shape2.func_78793_a(-8.0f, 22.0f, -8.0f);
        this.Shape3 = new ModelRenderer(this, 5, 79);
        this.Shape3.func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Shape3.func_78793_a(-8.0f, 22.0f, 7.0f);
        this.Shape4 = new ModelRenderer(this, 10, 79);
        this.Shape4.func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Shape4.func_78793_a(7.0f, 22.0f, -8.0f);
        this.Shape5 = new ModelRenderer(this, 15, 79);
        this.Shape5.func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Shape5.func_78793_a(7.0f, 22.0f, 7.0f);
        this.Shape6 = new ModelRenderer(this, 0, 14);
        this.Shape6.func_78789_a(0.0f, 0.0f, 0.0f, 16, 3, 7);
        this.Shape6.func_78793_a(-8.0f, 5.0f, 0.0f);
        this.Shape7 = new ModelRenderer(this, 0, 6);
        this.Shape7.func_78789_a(0.0f, 0.0f, 0.0f, 16, 2, 6);
        this.Shape7.func_78793_a(-8.0f, 3.0f, 0.0f);
        this.Shape8 = new ModelRenderer(this, 0, 0);
        this.Shape8.func_78789_a(0.0f, 0.0f, 0.0f, 16, 1, 5);
        this.Shape8.func_78793_a(-8.0f, 2.0f, 0.0f);
        this.Shape9 = new ModelRenderer(this, 0, 37);
        this.Shape9.func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 7);
        this.Shape9.func_78793_a(-8.0f, 5.0f, -7.0f);
        this.Shape10 = new ModelRenderer(this, 16, 37);
        this.Shape10.func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 7);
        this.Shape10.func_78793_a(7.0f, 5.0f, -7.0f);
        this.Shape11 = new ModelRenderer(this, 0, 29);
        this.Shape11.func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 6);
        this.Shape11.func_78793_a(-8.0f, 3.0f, -6.0f);
        this.Shape12 = new ModelRenderer(this, 14, 29);
        this.Shape12.func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 6);
        this.Shape12.func_78793_a(7.0f, 3.0f, -6.0f);
        this.Shape13 = new ModelRenderer(this, 0, 25);
        this.Shape13.func_78789_a(0.0f, 0.0f, 0.0f, 16, 1, 3);
        this.Shape13.func_78793_a(-8.0f, 2.0f, -3.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_78088_a(entity, f, f2, f3, f4, f5, f6);
        this.Shape1.func_78785_a(f6);
        this.Shape2.func_78785_a(f6);
        this.Shape3.func_78785_a(f6);
        this.Shape4.func_78785_a(f6);
        this.Shape5.func_78785_a(f6);
        this.Shape6.func_78785_a(f6);
        this.Shape7.func_78785_a(f6);
        this.Shape8.func_78785_a(f6);
        this.Shape9.func_78785_a(f6);
        this.Shape10.func_78785_a(f6);
        this.Shape11.func_78785_a(f6);
        this.Shape12.func_78785_a(f6);
        this.Shape13.func_78785_a(f6);
    }
}

