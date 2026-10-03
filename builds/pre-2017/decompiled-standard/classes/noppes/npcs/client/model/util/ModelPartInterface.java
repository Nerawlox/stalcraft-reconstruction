/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.util;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.ModelPartData;
import noppes.npcs.client.model.ModelMPM;
import org.lwjgl.opengl.GL11;

public abstract class ModelPartInterface
extends ModelRenderer {
    public float scale = 1.0f;
    public int color = 0xFFFFFF;
    public ModelMPM base;
    protected ResourceLocation location;
    private EntityCustomNpc entity;

    public ModelPartInterface(ModelMPM modelMPM) {
        super(modelMPM);
        this.base = modelMPM;
        this.func_78787_b(0, 0);
    }

    public void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    }

    public void setLivingAnimations(ModelPartData modelPartData, EntityLivingBase entityLivingBase, float f, float f2, float f3) {
    }

    public void setData(EntityCustomNpc entityCustomNpc) {
        this.entity = entityCustomNpc;
        this.initData(entityCustomNpc);
    }

    @Override
    public void func_78785_a(float f) {
        boolean bl;
        if (!this.base.isArmor) {
            apbu apbu2;
            if (this.location != null) {
                apbu2 = xpzm._E()._R();
                apbu2._a(this.location);
                this.base.currentlyPlayerTexture = false;
            } else if (!this.base.currentlyPlayerTexture) {
                apbu2 = xpzm._E()._R();
                apbu2._a((ResourceLocation)this.entity.textureLocation);
                this.base.currentlyPlayerTexture = true;
            }
        }
        boolean bl2 = bl = this.entity.field_70737_aN <= 0 && this.entity.deathTime <= 0L && !this.base.isArmor;
        if (bl) {
            float f2 = (float)(this.color >> 16 & 0xFF) / 255.0f;
            float f3 = (float)(this.color >> 8 & 0xFF) / 255.0f;
            float f4 = (float)(this.color & 0xFF) / 255.0f;
            GL11.glColor4f(f2, f3, f4, 1.0f);
        }
        super.func_78785_a(f);
        if (bl) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    public abstract void initData(EntityCustomNpc var1);
}

