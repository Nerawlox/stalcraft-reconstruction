/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.render;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingContext;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingSelf;
import net.smart.moving.render.IModelPlayer;
import net.smart.moving.render.IRenderPlayer;
import net.smart.moving.render.SmartMovingModel;
import net.smart.moving.render.SmartRenderContext;
import net.smart.render.statistics.SmartStatistics;
import net.smart.render.statistics.SmartStatisticsFactory;
import org.lwjgl.opengl.GL11;

public class SmartMovingRender
extends SmartRenderContext {
    public IRenderPlayer irp;
    public final SmartMovingModel modelBipedMain;
    private static int _iOffset;
    private static int _jOffset;
    private static Minecraft _minecraft;

    public SmartMovingRender(IRenderPlayer iRenderPlayer) {
        this.irp = iRenderPlayer;
        this.modelBipedMain = iRenderPlayer.getPlayerModelBipedMain().getMovingModel();
        SmartMovingModel smartMovingModel = iRenderPlayer.getPlayerModelArmorChestplate().getMovingModel();
        SmartMovingModel smartMovingModel2 = iRenderPlayer.getPlayerModelArmor().getMovingModel();
        this.modelBipedMain.scaleArmType = 0;
        this.modelBipedMain.scaleLegType = 0;
        smartMovingModel.scaleArmType = 1;
        smartMovingModel.scaleLegType = 2;
        smartMovingModel2.scaleArmType = 1;
        smartMovingModel2.scaleLegType = 0;
    }

    public void renderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        int n;
        IModelPlayer[] iModelPlayerArray = null;
        SmartMoving smartMoving = SmartMovingFactory.getInstance(abstractClientPlayer);
        if (smartMoving != null) {
            n = d == 0.0 && d2 == 0.0 && d3 == 0.0 && f == 0.0f && f2 == 1.0f ? 1 : 0;
            boolean bl = smartMoving.isClimbing && !smartMoving.isCrawling && !smartMoving.isCrawlClimbing && !smartMoving.isClimbJumping;
            boolean bl2 = smartMoving.isClimbJumping;
            int n2 = smartMoving.actualHandsClimbType;
            int n3 = smartMoving.actualFeetClimbType;
            boolean bl3 = smartMoving.isHandsVineClimbing;
            boolean bl4 = smartMoving.isFeetVineClimbing;
            boolean bl5 = smartMoving.isCeilingClimbing;
            boolean bl6 = smartMoving.isSwimming && !smartMoving.isDipping;
            boolean bl7 = smartMoving.isDiving;
            boolean bl8 = smartMoving.isLevitating;
            boolean bl9 = smartMoving.isCrawling && !smartMoving.isClimbing;
            boolean bl10 = smartMoving.isCrawlClimbing || smartMoving.isClimbing && smartMoving.isCrawling;
            boolean bl11 = smartMoving.isJumping();
            boolean bl12 = smartMoving.isHeadJumping;
            boolean bl13 = smartMoving.doFlyingAnimation();
            boolean bl14 = smartMoving.isSliding;
            boolean bl15 = smartMoving.doFallingAnimation();
            boolean bl16 = smartMoving.isSlow;
            boolean bl17 = smartMoving.isAngleJumping();
            int n4 = smartMoving.angleJumpType;
            boolean bl18 = smartMoving.isRopeSliding;
            SmartStatistics smartStatistics = SmartStatisticsFactory.getInstance(abstractClientPlayer);
            float f3 = smartStatistics != null ? smartStatistics.getCurrentHorizontalSpeedFlattened(f2, -1) : Float.NaN;
            float f4 = !bl10 && !bl12 ? 0.0f : (float)smartMoving.getOverGroundHeight(5.0);
            int n5 = bl12 && f4 < 5.0f ? smartMoving.getOverGroundBlockId(f4) : -1;
            iModelPlayerArray = this.irp.getPlayerModels();
            for (int i = 0; i < iModelPlayerArray.length; ++i) {
                SmartMovingModel smartMovingModel = iModelPlayerArray[i].getMovingModel();
                smartMovingModel.isClimb = bl;
                smartMovingModel.isClimbJump = bl2;
                smartMovingModel.handsClimbType = n2;
                smartMovingModel.feetClimbType = n3;
                smartMovingModel.isHandsVineClimbing = bl3;
                smartMovingModel.isFeetVineClimbing = bl4;
                smartMovingModel.isCeilingClimb = bl5;
                smartMovingModel.isSwim = bl6;
                smartMovingModel.isDive = bl7;
                smartMovingModel.isCrawl = bl9;
                smartMovingModel.isCrawlClimb = bl10;
                smartMovingModel.isJump = bl11;
                smartMovingModel.isHeadJump = bl12;
                smartMovingModel.isSlide = bl14;
                smartMovingModel.isFlying = bl13;
                smartMovingModel.isLevitate = bl8;
                smartMovingModel.isFalling = bl15;
                smartMovingModel.isGenericSneaking = bl16;
                smartMovingModel.isAngleJumping = bl17;
                smartMovingModel.angleJumpType = n4;
                smartMovingModel.isRopeSliding = bl18;
                smartMovingModel.currentHorizontalSpeedFlattened = f3;
                smartMovingModel.smallOverGroundHeight = f4;
                smartMovingModel.overGroundBlockId = n5;
            }
            if (n == 0 && abstractClientPlayer.isSneaking() && !(abstractClientPlayer instanceof EntityPlayerSP) && bl9) {
                d2 += 0.125;
            }
        }
        this.irp.superRenderRenderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
        if (smartMoving != null && smartMoving.isLevitating) {
            for (n = 0; n < iModelPlayerArray.length; ++n) {
                iModelPlayerArray[n].getMovingModel().md.currentHorizontalAngle = iModelPlayerArray[n].getMovingModel().md.currentCameraAngle;
            }
        }
    }

    public void rotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        SmartMoving smartMoving = SmartMovingFactory.getInstance(abstractClientPlayer);
        if (smartMoving != null) {
            boolean bl;
            boolean bl2 = bl = f3 == 1.0f && smartMoving.isp != null && smartMoving.isp.getMcField()._B instanceof cebg;
            if (!bl) {
                float f4 = abstractClientPlayer.prevRotationYaw + (abstractClientPlayer.rotationYaw - abstractClientPlayer.prevRotationYaw) * f3;
                if (smartMoving.isClimbing || smartMoving.isClimbCrawling || smartMoving.isCrawlClimbing || smartMoving.isFlying || smartMoving.isSwimming || smartMoving.isDiving || smartMoving.isCeilingClimbing || smartMoving.isHeadJumping || smartMoving.isSliding || smartMoving.isAngleJumping()) {
                    abstractClientPlayer.renderYawOffset = abstractClientPlayer.rotationYaw;
                }
            }
        }
        this.irp.superRenderRotatePlayer(abstractClientPlayer, f, f2, f3);
    }

    public void renderPlayerAt(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        SmartMoving smartMoving;
        if (abstractClientPlayer instanceof EntityOtherPlayerMP && (smartMoving = SmartMovingFactory.getOtherSmartMoving(abstractClientPlayer.entityId)) != null && smartMoving.heightOffset != 0.0f) {
            d2 += (double)smartMoving.heightOffset;
        }
        this.irp.superRenderRenderPlayerAt(abstractClientPlayer, d, d2, d3);
    }

    public void renderName(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        boolean bl = false;
        boolean bl2 = false;
        if (Minecraft._A() && entityLivingBase != this.irp.getRenderManager()._j) {
            SmartMoving smartMoving;
            SmartMoving smartMoving2 = smartMoving = entityLivingBase instanceof EntityPlayer ? SmartMovingFactory.getInstance((EntityPlayer)entityLivingBase) : null;
            if (smartMoving != null) {
                boolean bl3 = bl2 = entityLivingBase.isSneaking();
                if (smartMoving.isCrawling && !smartMoving.isClimbing) {
                    bl3 = (Boolean)SmartMovingContext.Config._crawlNameTag.value == false;
                } else if (bl2) {
                    bl3 = (Boolean)SmartMovingContext.Config._sneakNameTag.value == false;
                }
                boolean bl4 = bl = bl3 != bl2;
                if (bl) {
                    entityLivingBase.setSneaking(bl3);
                }
                if (smartMoving.heightOffset == -1.0f) {
                    d2 -= (double)0.2f;
                } else if (bl2 && !bl3) {
                    d2 -= (double)0.05f;
                }
            }
        }
        this.irp.superRenderRenderName(entityLivingBase, d, d2, d3);
        if (bl) {
            entityLivingBase.setSneaking(bl2);
        }
    }

    public static void renderGuiIngame(Minecraft minecraft) {
        SmartMovingSelf smartMovingSelf;
        if (SmartMovingContext.Client.getNativeUserInterfaceDrawing() && GL11.glGetBoolean(3008) && (smartMovingSelf = (SmartMovingSelf)SmartMovingFactory.getInstance(minecraft._t)) != null && SmartMovingContext.Config.enabled && (((Boolean)SmartMovingContext.Options._displayExhaustionBar.value).booleanValue() || ((Boolean)SmartMovingContext.Options._displayJumpChargeBar.value).booleanValue())) {
            htou htou2 = new htou(minecraft._M, minecraft._n, minecraft._o);
            int n = htou2._a();
            int n2 = htou2._b();
            if (minecraft._j._b()) {
                float f = SmartMovingContext.Client.getMaximumExhaustion();
                float f2 = Math.min(smartMovingSelf.exhaustion, f);
                boolean bl = f2 > 0.0f && f2 <= f;
                float f3 = ((Float)SmartMovingContext.Config._jumpChargeMaximum.value).floatValue();
                float f4 = Math.min(smartMovingSelf.jumpCharge, f3);
                float f5 = ((Float)SmartMovingContext.Config._headJumpChargeMaximum.value).floatValue();
                float f6 = Math.min(smartMovingSelf.headJumpCharge, f5);
                boolean bl2 = f4 > 0.0f || f6 > 0.0f;
                float f7 = f4 > f6 ? f3 : f5;
                float f8 = Math.max(f4, f6);
                if (bl || bl2) {
                    GL11.glPushAttrib(262144);
                    minecraft._R()._a(new ResourceLocation("SmartMoving", "gui/icons.png"));
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    _minecraft = minecraft;
                }
                if (bl) {
                    float f9 = Math.min(smartMovingSelf.maxExhaustionForAction, f);
                    float f10 = Math.min(smartMovingSelf.maxExhaustionToStartAction, f);
                    float f11 = f - f2;
                    float f12 = Float.isNaN(f9) ? 0.0f : f - f9;
                    float f13 = Float.isNaN(f10) ? 0.0f : f - f10;
                    float f14 = Math.max(Math.max(f13, f11), f12);
                    int n3 = (int)Math.floor(f14 / f * 21.0f);
                    int n4 = n3 / 2;
                    int n5 = n3 % 2;
                    int n6 = (int)Math.floor(f11 / f * 21.0f);
                    int n7 = n6 / 2;
                    int n8 = n6 % 2;
                    int n9 = (int)Math.floor(f12 / f * 21.0f);
                    int n10 = n9 / 2;
                    int n11 = n9 % 2;
                    int n12 = (int)Math.floor(f13 / f * 21.0f);
                    int n13 = n12 / 2;
                    _jOffset = n2 - 39 - 10 - (minecraft._t.isInsideOfMaterial(Material._h) ? 10 : 0);
                    for (int i = 0; i < Math.min(n4 + n5, 10); ++i) {
                        _iOffset = n / 2 + 90 - (i + 1) * 8;
                        if (i < n7) {
                            if (i < n10) {
                                SmartMovingRender.drawIcon(2, 2);
                                continue;
                            }
                            if (i == n10 && n11 > 0) {
                                SmartMovingRender.drawIcon(3, 2);
                                continue;
                            }
                            SmartMovingRender.drawIcon(0, 0);
                            continue;
                        }
                        if (i == n7 && n8 > 0) {
                            if (i < n10) {
                                SmartMovingRender.drawIcon(1, 2);
                                continue;
                            }
                            if (i == n10 && n11 > 0) {
                                if (i < n13) {
                                    SmartMovingRender.drawIcon(3, 1);
                                    continue;
                                }
                                SmartMovingRender.drawIcon(4, 2);
                                continue;
                            }
                            if (i < n13) {
                                SmartMovingRender.drawIcon(1, 1);
                                continue;
                            }
                            SmartMovingRender.drawIcon(1, 0);
                            continue;
                        }
                        if (i < n10) {
                            SmartMovingRender.drawIcon(0, 2);
                            continue;
                        }
                        if (i == n10 && n11 > 0) {
                            if (i < n13) {
                                SmartMovingRender.drawIcon(2, 1);
                                continue;
                            }
                            SmartMovingRender.drawIcon(5, 2);
                            continue;
                        }
                        if (i < n13) {
                            SmartMovingRender.drawIcon(0, 1);
                            continue;
                        }
                        SmartMovingRender.drawIcon(4, 1);
                    }
                }
                if (bl2) {
                    boolean bl3 = f8 == f7;
                    int n14 = bl3 ? 10 : (int)Math.ceil((double)(f8 - 2.0f) * 10.0 / (double)f7);
                    int n15 = bl3 ? 0 : (int)Math.ceil((double)f8 * 10.0 / (double)f7) - n14;
                    _jOffset = n2 - 39 - 10 - (minecraft._t.getTotalArmorValue() > 0 ? 10 : 0);
                    for (int i = 0; i < n14 + n15; ++i) {
                        _iOffset = n / 2 - 91 + i * 8;
                        SmartMovingRender.drawIcon(i < n14 ? 2 : 3, 0);
                    }
                }
                if (bl || bl2) {
                    GL11.glPopAttrib();
                }
            }
        }
    }

    private static void drawIcon(int n, int n2) {
        SmartMovingRender._minecraft._J.drawTexturedModalRect(_iOffset, _jOffset, n * 9, n2 * 9, 9, 9);
    }
}

