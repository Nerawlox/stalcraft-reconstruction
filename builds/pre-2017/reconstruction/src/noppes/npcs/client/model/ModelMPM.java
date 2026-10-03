/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.ModelPartConfig;
import noppes.npcs.ModelPartData;
import noppes.npcs.client.model.ModelNPCMale;
import noppes.npcs.client.model.animation.AniCrawling;
import noppes.npcs.client.model.animation.AniHug;
import noppes.npcs.client.model.part.ModelBeard;
import noppes.npcs.client.model.part.ModelBreasts;
import noppes.npcs.client.model.part.ModelClaws;
import noppes.npcs.client.model.part.ModelEars;
import noppes.npcs.client.model.part.ModelFin;
import noppes.npcs.client.model.part.ModelHair;
import noppes.npcs.client.model.part.ModelHeadwear;
import noppes.npcs.client.model.part.ModelLegs;
import noppes.npcs.client.model.part.ModelMohawk;
import noppes.npcs.client.model.part.ModelSnout;
import noppes.npcs.client.model.part.ModelTail;
import noppes.npcs.client.model.part.ModelWings;
import noppes.npcs.client.model.util.ModelPartInterface;
import noppes.npcs.client.model.util.ModelScaleRenderer;
import noppes.npcs.constants.EnumAnimation;
import org.lwjgl.opengl.GL11;

public class ModelMPM
extends ModelNPCMale {
    public boolean currentlyPlayerTexture;
    public boolean isArmor;
    private ModelPartInterface wings;
    private ModelPartInterface mohawk;
    private ModelPartInterface hair;
    private ModelPartInterface beard;
    private ModelPartInterface breasts;
    private ModelPartInterface snout;
    private ModelPartInterface ears;
    private ModelPartInterface fin;
    private ModelPartInterface clawsR;
    private ModelPartInterface clawsL;
    private ModelLegs legs;
    private ModelScaleRenderer headwear;
    private ModelTail tail;

    public ModelMPM(float f) {
        super(f);
        this.isArmor = f > 0.0f;
        float f2 = 0.0f;
        this.bipedCloak = new ModelRenderer(this, 0, 0);
        this.bipedCloak.addBox(-5.0f, 0.0f, -1.0f, 10, 16, 1, f);
        this.bipedEars = new ModelRenderer(this, 24, 0);
        this.bipedEars.addBox(-3.0f, -6.0f, -1.0f, 6, 6, 1, f);
        this.bipedHead = new ModelScaleRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.bipedHead.setRotationPoint(0.0f, 0.0f + f2, 0.0f);
        this.bipedHeadwear = new ModelScaleRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.bipedHeadwear.setRotationPoint(0.0f, 0.0f + f2, 0.0f);
        this.bipedBody = new ModelScaleRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.bipedBody.setRotationPoint(0.0f, 0.0f + f2, 0.0f);
        this.bipedRightArm = new ModelScaleRenderer(this, 40, 16);
        this.bipedRightArm.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.bipedRightArm.setRotationPoint(-5.0f, 2.0f + f2, 0.0f);
        this.bipedLeftArm = new ModelScaleRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + f2, 0.0f);
        this.bipedRightLeg = new ModelScaleRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f + f2, 0.0f);
        this.bipedLeftLeg = new ModelScaleRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f + f2, 0.0f);
        this.headwear = new ModelHeadwear(this);
        this.legs = new ModelLegs(this, (ModelScaleRenderer)this.bipedRightLeg, (ModelScaleRenderer)this.bipedLeftLeg);
        this.breasts = new ModelBreasts(this);
        this.bipedBody.addChild(this.breasts);
        if (!this.isArmor) {
            this.ears = new ModelEars(this);
            this.bipedHead.addChild(this.ears);
            this.mohawk = new ModelMohawk(this);
            this.bipedHead.addChild(this.mohawk);
            this.hair = new ModelHair(this);
            this.bipedHead.addChild(this.hair);
            this.beard = new ModelBeard(this);
            this.bipedHead.addChild(this.beard);
            this.snout = new ModelSnout(this);
            this.bipedHead.addChild(this.snout);
            this.tail = new ModelTail(this);
            this.wings = new ModelWings(this);
            this.bipedBody.addChild(this.wings);
            this.fin = new ModelFin(this);
            this.bipedBody.addChild(this.fin);
            this.clawsL = new ModelClaws(this, false);
            this.bipedLeftArm.addChild(this.clawsL);
            this.clawsR = new ModelClaws(this, true);
            this.bipedRightArm.addChild(this.clawsR);
        }
    }

    private void setPlayerData(EntityCustomNpc entityCustomNpc) {
        if (!this.isArmor) {
            this.mohawk.setData(entityCustomNpc);
            this.beard.setData(entityCustomNpc);
            this.hair.setData(entityCustomNpc);
            this.snout.setData(entityCustomNpc);
            this.tail.setData(entityCustomNpc);
            this.fin.setData(entityCustomNpc);
            this.wings.setData(entityCustomNpc);
            this.ears.setData(entityCustomNpc);
            this.clawsL.setData(entityCustomNpc);
            this.clawsR.setData(entityCustomNpc);
        }
        this.breasts.setData(entityCustomNpc);
        this.legs.setData(entityCustomNpc);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        EntityCustomNpc entityCustomNpc = (EntityCustomNpc)entity;
        this.setPlayerData(entityCustomNpc);
        this.currentlyPlayerTexture = true;
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        if (entityCustomNpc.currentAnimation == EnumAnimation.Aiming) {
            GL11.glPushMatrix();
            float f7 = (float)(entity.ticksExisted - entityCustomNpc.animationStart) / 10.0f;
            if (f7 > 1.0f) {
                f7 = 1.0f;
            }
            float f8 = 2.0f - entityCustomNpc.body.scaleY;
            GL11.glTranslatef(0.0f, 12.0f * f8 * f6, 0.0f);
            GL11.glRotatef(60.0f * f7, 1.0f, 0.0f, 0.0f);
            GL11.glTranslatef(0.0f, -12.0f * f8 * f6, 0.0f);
        }
        this.renderHead(entityCustomNpc, f6);
        this.renderArms(entityCustomNpc, f6, false);
        this.renderBody(entityCustomNpc, f6);
        if (entityCustomNpc.currentAnimation == EnumAnimation.Aiming) {
            GL11.glPopMatrix();
        }
        this.renderLegs(entityCustomNpc, f6);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        EntityCustomNpc entityCustomNpc = (EntityCustomNpc)entity;
        if (!this.isRiding) {
            boolean bl = this.isRiding = entityCustomNpc.currentAnimation == EnumAnimation.SITTING;
        }
        if (this.isSneak && (entityCustomNpc.currentAnimation == EnumAnimation.CRAWLING || entityCustomNpc.isSleeping())) {
            this.isSneak = false;
        }
        this.bipedBody.rotationPointZ = 0.0f;
        this.bipedBody.rotationPointY = 0.0f;
        this.bipedHead.rotateAngleZ = 0.0f;
        this.bipedHeadwear.rotateAngleZ = 0.0f;
        this.bipedLeftLeg.rotateAngleX = 0.0f;
        this.bipedLeftLeg.rotateAngleY = 0.0f;
        this.bipedLeftLeg.rotateAngleZ = 0.0f;
        this.bipedRightLeg.rotateAngleX = 0.0f;
        this.bipedRightLeg.rotateAngleY = 0.0f;
        this.bipedRightLeg.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotationPointY = 2.0f;
        this.bipedLeftArm.rotationPointZ = 0.0f;
        this.bipedRightArm.rotationPointY = 2.0f;
        this.bipedRightArm.rotationPointZ = 0.0f;
        super.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        if (!this.isArmor) {
            this.hair.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
            this.beard.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
            this.wings.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
            this.tail.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        }
        this.legs.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        if (this.isSleeping(entity)) {
            if (this.bipedHead.rotateAngleX < 0.0f) {
                this.bipedHead.rotateAngleX = 0.0f;
                this.bipedHeadwear.rotateAngleX = 0.0f;
            }
        } else if (entityCustomNpc.currentAnimation == EnumAnimation.CRY) {
            this.bipedHead.rotateAngleX = 0.7f;
            this.bipedHeadwear.rotateAngleX = 0.7f;
        } else if (entityCustomNpc.currentAnimation == EnumAnimation.HUG) {
            AniHug.setRotationAngles(f, f2, f3, f4, f5, f6, entity, this);
        } else if (entityCustomNpc.currentAnimation == EnumAnimation.CRAWLING) {
            AniCrawling.setRotationAngles(f, f2, f3, f4, f5, f6, entity, this);
        } else if (entityCustomNpc.currentAnimation == EnumAnimation.WAVING) {
            this.bipedRightArm.rotateAngleX = -0.1f;
            this.bipedRightArm.rotateAngleY = 0.0f;
            this.bipedRightArm.rotateAngleZ = (float)(2.141592653589793 - Math.sin((float)entity.ticksExisted * 0.27f) * 0.5);
        } else if (this.isSneak) {
            this.bipedBody.rotateAngleX = 0.5f / entityCustomNpc.body.scaleY;
        }
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        ModelPartData modelPartData;
        EntityCustomNpc entityCustomNpc = (EntityCustomNpc)entityLivingBase;
        if (!this.isArmor && (modelPartData = entityCustomNpc.getPartData("tail")) != null) {
            this.tail.setLivingAnimations(modelPartData, entityLivingBase, f, f2, f3);
        }
    }

    public void loadPlayerTexture(EntityCustomNpc entityCustomNpc) {
        if (!this.isArmor && !this.currentlyPlayerTexture) {
            TextureManager textureManager = Minecraft._E()._R();
            textureManager._a((ResourceLocation)entityCustomNpc.textureLocation);
            this.currentlyPlayerTexture = true;
        }
    }

    private void renderHead(EntityCustomNpc entityCustomNpc, float f) {
        this.loadPlayerTexture(entityCustomNpc);
        float f2 = 0.0f;
        float f3 = entityCustomNpc.getBodyY();
        float f4 = 0.0f;
        GL11.glPushMatrix();
        if (entityCustomNpc.currentAnimation == EnumAnimation.DANCING) {
            float f5 = (float)entityCustomNpc.ticksExisted / 4.0f;
            GL11.glTranslatef((float)Math.sin(f5) * 0.075f, (float)Math.abs(Math.cos(f5)) * 0.125f - 0.02f, (float)(-Math.abs(Math.cos(f5))) * 0.075f);
        }
        ModelPartConfig modelPartConfig = entityCustomNpc.head;
        ((ModelScaleRenderer)this.bipedHeadwear).setConfig(modelPartConfig, f2, f3, f4);
        ((ModelScaleRenderer)this.bipedHeadwear).render(f);
        ((ModelScaleRenderer)this.bipedHead).setConfig(modelPartConfig, f2, f3, f4);
        ((ModelScaleRenderer)this.bipedHead).render(f);
        GL11.glPopMatrix();
    }

    private void renderBody(EntityCustomNpc entityCustomNpc, float f) {
        this.loadPlayerTexture(entityCustomNpc);
        float f2 = 0.0f;
        float f3 = entityCustomNpc.getBodyY();
        float f4 = 0.0f;
        GL11.glPushMatrix();
        if (entityCustomNpc.currentAnimation == EnumAnimation.DANCING) {
            float f5 = (float)entityCustomNpc.ticksExisted / 4.0f;
            GL11.glTranslatef((float)Math.sin(f5) * 0.015f, 0.0f, 0.0f);
        }
        ModelPartConfig modelPartConfig = entityCustomNpc.body;
        ((ModelScaleRenderer)this.bipedBody).setConfig(modelPartConfig, f2, f3, f4);
        ((ModelScaleRenderer)this.bipedBody).render(f);
        GL11.glPopMatrix();
    }

    public void renderArms(EntityCustomNpc entityCustomNpc, float f, boolean bl) {
        this.loadPlayerTexture(entityCustomNpc);
        ModelPartConfig modelPartConfig = entityCustomNpc.arms;
        float f2 = (1.0f - entityCustomNpc.body.scaleX) * 0.25f + (1.0f - modelPartConfig.scaleX) * 0.075f;
        float f3 = entityCustomNpc.getBodyY() + (1.0f - modelPartConfig.scaleY) * -0.1f;
        float f4 = 0.0f;
        GL11.glPushMatrix();
        if (entityCustomNpc.currentAnimation == EnumAnimation.DANCING) {
            float f5 = (float)entityCustomNpc.ticksExisted / 4.0f;
            GL11.glTranslatef((float)Math.sin(f5) * 0.025f, (float)Math.abs(Math.cos(f5)) * 0.125f - 0.02f, 0.0f);
        }
        if (!bl) {
            ((ModelScaleRenderer)this.bipedLeftArm).setConfig(modelPartConfig, -f2, f3, f4);
            ((ModelScaleRenderer)this.bipedLeftArm).render(f);
            ((ModelScaleRenderer)this.bipedRightArm).setConfig(modelPartConfig, f2, f3, f4);
            ((ModelScaleRenderer)this.bipedRightArm).render(f);
        } else {
            ((ModelScaleRenderer)this.bipedRightArm).setConfig(modelPartConfig, 0.0f, 0.0f, 0.0f);
            ((ModelScaleRenderer)this.bipedRightArm).render(f);
        }
        GL11.glPopMatrix();
    }

    private void renderLegs(EntityCustomNpc entityCustomNpc, float f) {
        this.loadPlayerTexture(entityCustomNpc);
        ModelPartConfig modelPartConfig = entityCustomNpc.legs;
        float f2 = (1.0f - modelPartConfig.scaleX) * 0.125f;
        float f3 = entityCustomNpc.getLegsY();
        float f4 = 0.0f;
        GL11.glPushMatrix();
        this.legs.setConfig(modelPartConfig, f2, f3, f4);
        this.legs.render(f);
        if (!this.isArmor) {
            this.tail.setConfig(modelPartConfig, 0.0f, f3, f4);
            this.tail.render(f);
        }
        GL11.glPopMatrix();
    }

    @Override
    public ModelRenderer getRandomModelBox(Random random) {
        int n = random.nextInt(5);
        switch (n) {
            case 0: {
                return this.bipedRightLeg;
            }
            case 1: {
                return this.bipedHead;
            }
            case 2: {
                return this.bipedLeftArm;
            }
            case 3: {
                return this.bipedRightArm;
            }
            case 4: {
                return this.bipedLeftLeg;
            }
        }
        return this.bipedBody;
    }

    public boolean isSleeping(Entity entity) {
        return entity instanceof EntityPlayer && ((EntityPlayer)entity).isPlayerSleeping() ? true : ((EntityCustomNpc)entity).isSleeping();
    }
}

