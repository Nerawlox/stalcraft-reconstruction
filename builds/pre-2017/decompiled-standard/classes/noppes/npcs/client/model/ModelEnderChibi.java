/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import noppes.npcs.client.model.ModelNPCMale;
import org.lwjgl.opengl.GL11;

public class ModelEnderChibi
extends ModelNPCMale {
    public ModelEnderChibi(float f) {
        super(f);
    }

    @Override
    public void init(float f, float f2) {
        super.init(f, f2);
        this.bipedRightArm = new ModelRenderer(this, 44, 18);
        this.bipedRightArm.func_78789_a(-1.0f, 4.0f, -1.0f, 2, 12, 2);
        this.bipedRightArm.func_78793_a(-5.0f, 2.0f, 0.0f);
        ModelRenderer modelRenderer = new ModelRenderer(this, 44, 18);
        modelRenderer.func_78789_a(-1.0f, -2.0f, -1.0f, 2, 6, 2);
        this.bipedRightArm.func_78792_a(modelRenderer);
        this.bipedLeftArm = new ModelRenderer(this, 44, 18);
        this.bipedLeftArm.field_78809_i = true;
        this.bipedLeftArm.func_78789_a(-1.0f, 4.0f, -1.0f, 2, 12, 2);
        this.bipedLeftArm.func_78793_a(5.0f, 2.0f, 0.0f);
        ModelRenderer modelRenderer2 = new ModelRenderer(this, 44, 18);
        modelRenderer2.field_78809_i = true;
        modelRenderer2.func_78789_a(-1.0f, -2.0f, -1.0f, 2, 6, 2);
        this.bipedLeftArm.func_78792_a(modelRenderer2);
        this.bipedRightLeg = new ModelRenderer(this, 4, 20);
        this.bipedRightLeg.func_78789_a(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.bipedRightLeg.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 4, 20);
        this.bipedLeftLeg.field_78809_i = true;
        this.bipedLeftLeg.func_78789_a(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.bipedLeftLeg.func_78793_a(2.0f, 12.0f, 0.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.14f, 0.0f);
        super.func_78088_a(entity, f, f2, f3, f4, f5, f6);
        GL11.glPopMatrix();
    }
}

