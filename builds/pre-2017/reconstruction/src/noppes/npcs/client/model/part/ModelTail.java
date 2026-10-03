/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.part;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.ModelPartData;
import noppes.npcs.client.model.ModelMPM;
import noppes.npcs.client.model.part.tails.ModelDragonTail;
import noppes.npcs.client.model.part.tails.ModelSquirrelTail;
import noppes.npcs.client.model.util.ModelScaleRenderer;
import noppes.npcs.constants.EnumAnimation;
import org.lwjgl.opengl.GL11;

public class ModelTail
extends ModelScaleRenderer {
    private EntityCustomNpc entity;
    private ModelMPM base;
    private ModelRenderer tail;
    private ModelRenderer dragon;
    private ModelRenderer squirrel;
    private ModelRenderer horse;
    private int color = 0xFFFFFF;
    private ResourceLocation location = null;

    public ModelTail(ModelMPM modelMPM) {
        super(modelMPM);
        this.base = modelMPM;
        this.rotationPointY = 11.0f;
        this.tail = new ModelRenderer(modelMPM, 56, 21);
        this.tail.addBox(-1.0f, 0.0f, 0.0f, 2, 9, 2);
        this.tail.setRotationPoint(0.0f, 0.0f, 1.0f);
        this.setRotation(this.tail, 0.8714253f, 0.0f, 0.0f);
        this.addChild(this.tail);
        this.horse = new ModelRenderer(modelMPM);
        this.horse.setTextureSize(32, 32);
        this.horse.setRotationPoint(0.0f, -1.0f, 1.0f);
        this.addChild(this.horse);
        ModelRenderer modelRenderer = new ModelRenderer(modelMPM, 0, 26);
        modelRenderer.setTextureSize(32, 32);
        modelRenderer.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.setRotation(modelRenderer, -1.134464f, 0.0f, 0.0f);
        this.horse.addChild(modelRenderer);
        ModelRenderer modelRenderer2 = new ModelRenderer(modelMPM, 0, 13);
        modelRenderer2.setTextureSize(32, 32);
        modelRenderer2.addBox(-1.5f, -2.0f, 3.0f, 3, 4, 7);
        this.setRotation(modelRenderer2, -1.134464f, 0.0f, 0.0f);
        this.horse.addChild(modelRenderer2);
        ModelRenderer modelRenderer3 = new ModelRenderer(modelMPM, 0, 0);
        modelRenderer3.setTextureSize(32, 32);
        modelRenderer3.addBox(-1.5f, -4.5f, 9.0f, 3, 4, 7);
        this.setRotation(modelRenderer3, -1.40215f, 0.0f, 0.0f);
        this.horse.addChild(modelRenderer3);
        this.horse.rotateAngleX = 0.5f;
        this.dragon = new ModelDragonTail(modelMPM);
        this.addChild(this.dragon);
        this.squirrel = new ModelSquirrelTail(modelMPM);
        this.addChild(this.squirrel);
    }

    public void setData(EntityCustomNpc entityCustomNpc) {
        this.entity = entityCustomNpc;
        this.initData(entityCustomNpc);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.rotateAngleY = sajh._b(f * 0.6662f) * 0.3f * f2;
        this.rotateAngleX = sajh._a(f3 * 0.067f) * 0.05f;
        if (this.entity.legParts.type == 2) {
            this.rotationPointY = 13.0f;
            this.rotationPointZ = 14.0f * this.entity.legs.scaleZ;
            if (this.base.isSleeping(entity) || this.entity.currentAnimation == EnumAnimation.CRAWLING) {
                this.rotationPointY = 12.0f + 16.0f * this.entity.legs.scaleZ;
                this.rotationPointZ = 1.0f * this.entity.legs.scaleY;
                this.rotateAngleX = -0.7853982f;
            }
        } else if (this.entity.legParts.type == 3) {
            this.rotationPointY = 8.6f;
            this.rotationPointZ = 19.0f * this.entity.legs.scaleZ;
        } else {
            this.rotationPointY = 11.0f;
            this.rotationPointZ = -1.0f;
        }
        this.rotationPointZ += this.base.bipedRightLeg.rotationPointZ + 0.5f;
    }

    public void setLivingAnimations(ModelPartData modelPartData, EntityLivingBase entityLivingBase, float f, float f2, float f3) {
    }

    public void initData(EntityCustomNpc entityCustomNpc) {
        ModelPartData modelPartData = entityCustomNpc.getPartData("tail");
        if (modelPartData == null) {
            this.isHidden = true;
        } else {
            this.color = modelPartData.color;
            this.isHidden = false;
            this.tail.isHidden = modelPartData.type != 0;
            this.dragon.isHidden = modelPartData.type != 1;
            this.horse.isHidden = modelPartData.type != 2;
            this.squirrel.isHidden = modelPartData.type != 3;
            this.location = !modelPartData.playerTexture ? (ResourceLocation)modelPartData.getResource() : null;
        }
    }

    @Override
    public void render(float f) {
        if (!this.isHidden) {
            boolean bl;
            if (!this.base.isArmor) {
                TextureManager textureManager;
                if (this.location != null) {
                    textureManager = Minecraft._E()._R();
                    textureManager._a(this.location);
                    this.base.currentlyPlayerTexture = false;
                } else if (!this.base.currentlyPlayerTexture) {
                    textureManager = Minecraft._E()._R();
                    textureManager._a((ResourceLocation)this.entity.textureLocation);
                    this.base.currentlyPlayerTexture = true;
                }
            }
            boolean bl2 = bl = this.entity.hurtTime <= 0 && this.entity.deathTime <= 0L;
            if (bl) {
                float f2 = (float)(this.color >> 16 & 0xFF) / 255.0f;
                float f3 = (float)(this.color >> 8 & 0xFF) / 255.0f;
                float f4 = (float)(this.color & 0xFF) / 255.0f;
                GL11.glColor4f(f2, f3, f4, 1.0f);
            }
            super.render(f);
            if (bl) {
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }
}

