/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCarpentryBench
extends ModelBase {
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Bottom_plate;
    ModelRenderer Desktop;
    ModelRenderer Backboard;
    ModelRenderer Vice_Jaw1;
    ModelRenderer Vice_Jaw2;
    ModelRenderer Vice_Base1;
    ModelRenderer Vice_Base2;
    ModelRenderer Vice_Crank;
    ModelRenderer Vice_Screw;
    ModelRenderer Blueprint;

    public ModelCarpentryBench() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Leg1 = new ModelRenderer(this, 0, 0);
        this.Leg1.func_78789_a(0.0f, 0.0f, 0.0f, 2, 14, 2);
        this.Leg1.func_78793_a(6.0f, 10.0f, 5.0f);
        this.Leg2 = new ModelRenderer(this, 0, 0);
        this.Leg2.func_78789_a(0.0f, 0.0f, 0.0f, 2, 14, 2);
        this.Leg2.func_78793_a(6.0f, 10.0f, -5.0f);
        this.Leg3 = new ModelRenderer(this, 0, 0);
        this.Leg3.func_78789_a(0.0f, 0.0f, 0.0f, 2, 14, 2);
        this.Leg3.func_78793_a(-8.0f, 10.0f, 5.0f);
        this.Leg4 = new ModelRenderer(this, 0, 0);
        this.Leg4.func_78789_a(0.0f, 0.0f, 0.0f, 2, 14, 2);
        this.Leg4.func_78793_a(-8.0f, 10.0f, -5.0f);
        this.Bottom_plate = new ModelRenderer(this, 0, 24);
        this.Bottom_plate.func_78789_a(0.0f, 0.0f, 0.0f, 14, 1, 10);
        this.Bottom_plate.func_78793_a(-7.0f, 21.0f, -4.0f);
        this.Bottom_plate.func_78787_b(130, 64);
        this.Desktop = new ModelRenderer(this, 0, 3);
        this.Desktop.func_78789_a(0.0f, 0.0f, 0.0f, 18, 2, 13);
        this.Desktop.func_78793_a(-9.0f, 9.0f, -6.0f);
        this.Backboard = new ModelRenderer(this, 0, 18);
        this.Backboard.func_78789_a(-1.0f, 0.0f, 0.0f, 18, 5, 1);
        this.Backboard.func_78793_a(-8.0f, 7.0f, 7.0f);
        this.Vice_Jaw1 = new ModelRenderer(this, 54, 18);
        this.Vice_Jaw1.func_78789_a(0.0f, 0.0f, 0.0f, 3, 2, 1);
        this.Vice_Jaw1.func_78793_a(3.0f, 6.0f, -8.0f);
        this.Vice_Jaw2 = new ModelRenderer(this, 54, 21);
        this.Vice_Jaw2.func_78789_a(0.0f, 0.0f, 0.0f, 3, 2, 1);
        this.Vice_Jaw2.func_78793_a(3.0f, 6.0f, -6.0f);
        this.Vice_Base1 = new ModelRenderer(this, 38, 30);
        this.Vice_Base1.func_78789_a(0.0f, 0.0f, 0.0f, 3, 1, 3);
        this.Vice_Base1.func_78793_a(3.0f, 8.0f, -5.0f);
        this.Vice_Base2 = new ModelRenderer(this, 38, 25);
        this.Vice_Base2.func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.Vice_Base2.func_78793_a(4.0f, 7.0f, -5.0f);
        this.Vice_Crank = new ModelRenderer(this, 54, 24);
        this.Vice_Crank.func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.Vice_Crank.func_78793_a(6.0f, 6.0f, -9.0f);
        this.Vice_Screw = new ModelRenderer(this, 44, 25);
        this.Vice_Screw.func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 4);
        this.Vice_Screw.func_78793_a(4.0f, 8.0f, -8.0f);
        this.Blueprint = new ModelRenderer(this, 31, 18);
        this.Blueprint.func_78789_a(0.0f, 0.0f, 0.0f, 8, 0, 7);
        this.Blueprint.func_78793_a(0.0f, 9.0f, 1.0f);
        this.setRotation(this.Blueprint, 0.3271718f, 0.1487144f, 0.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_78088_a(entity, f, f2, f3, f4, f5, f6);
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.Leg1.func_78785_a(f6);
        this.Leg2.func_78785_a(f6);
        this.Leg3.func_78785_a(f6);
        this.Leg4.func_78785_a(f6);
        this.Bottom_plate.func_78785_a(f6);
        this.Desktop.func_78785_a(f6);
        this.Backboard.func_78785_a(f6);
        this.Vice_Jaw1.func_78785_a(f6);
        this.Vice_Jaw2.func_78785_a(f6);
        this.Vice_Base1.func_78785_a(f6);
        this.Vice_Base2.func_78785_a(f6);
        this.Vice_Crank.func_78785_a(f6);
        this.Vice_Screw.func_78785_a(f6);
        this.Blueprint.func_78785_a(f6);
    }

    private void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }
}

