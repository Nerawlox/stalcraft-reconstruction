/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class ModelNpcSlime
extends ModelBase {
    ModelRenderer outerBody;
    ModelRenderer innerBody;
    ModelRenderer slimeRightEye;
    ModelRenderer slimeLeftEye;
    ModelRenderer slimeMouth;

    public ModelNpcSlime(int n) {
        this.field_78089_u = 64;
        this.field_78090_t = 64;
        this.outerBody = new ModelRenderer(this, 0, 0);
        this.outerBody = new ModelRenderer(this, 0, 0);
        this.outerBody.func_78789_a(-8.0f, 32.0f, -8.0f, 16, 16, 16);
        if (n > 0) {
            this.innerBody = new ModelRenderer(this, 0, 32);
            this.innerBody.func_78789_a(-3.0f, 17.0f, -3.0f, 6, 6, 6);
            this.slimeRightEye = new ModelRenderer(this, 0, 0);
            this.slimeRightEye.func_78789_a(-3.25f, 18.0f, -3.5f, 2, 2, 2);
            this.slimeLeftEye = new ModelRenderer(this, 0, 4);
            this.slimeLeftEye.func_78789_a(1.25f, 18.0f, -3.5f, 2, 2, 2);
            this.slimeMouth = new ModelRenderer(this, 0, 8);
            this.slimeMouth.func_78789_a(0.0f, 21.0f, -3.5f, 1, 1, 1);
        }
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        if (this.innerBody != null) {
            this.innerBody.func_78785_a(f6);
        } else {
            GL11.glPushMatrix();
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            this.outerBody.func_78785_a(f6);
            GL11.glPopMatrix();
        }
        if (this.slimeRightEye != null) {
            this.slimeRightEye.func_78785_a(f6);
            this.slimeLeftEye.func_78785_a(f6);
            this.slimeMouth.func_78785_a(f6);
        }
    }
}

