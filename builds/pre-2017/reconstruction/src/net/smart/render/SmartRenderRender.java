/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.render.IModelPlayer;
import net.smart.render.IRenderPlayer;
import net.smart.render.RendererData;
import net.smart.render.SmartRenderContext;
import net.smart.render.SmartRenderModel;
import net.smart.render.statistics.SmartStatistics;
import net.smart.render.statistics.SmartStatisticsFactory;

public class SmartRenderRender
extends SmartRenderContext {
    public IRenderPlayer irp;
    private static Map previousRendererData = new HashMap();
    private static int previousRendererDataAccessCounter = 0;
    public final SmartRenderModel modelBipedMain;

    public SmartRenderRender(IRenderPlayer iRenderPlayer) {
        this.irp = iRenderPlayer;
        this.modelBipedMain = iRenderPlayer.createModel(iRenderPlayer.getModelBipedMain(), 0.0f).getRenderModel();
        SmartRenderModel smartRenderModel = iRenderPlayer.createModel(iRenderPlayer.getModelArmorChestplate(), 1.0f).getRenderModel();
        SmartRenderModel smartRenderModel2 = iRenderPlayer.createModel(iRenderPlayer.getModelArmor(), 0.5f).getRenderModel();
        iRenderPlayer.initialize(this.modelBipedMain.mp, smartRenderModel.mp, smartRenderModel2.mp, 0.5f);
    }

    public void renderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        SmartStatistics smartStatistics = SmartStatisticsFactory.getInstance(abstractClientPlayer);
        if (smartStatistics != null) {
            boolean bl = d == 0.0 && d2 == 0.0 && d3 == 0.0 && f == 0.0f && f2 == 1.0f;
            boolean bl2 = abstractClientPlayer.isPlayerSleeping();
            float f3 = smartStatistics.getTotalVerticalDistance(f2);
            float f4 = smartStatistics.getCurrentVerticalSpeed(f2);
            float f5 = smartStatistics.getTotalDistance(f2);
            float f6 = smartStatistics.getCurrentSpeed(f2);
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = 0.0f;
            if (!bl) {
                double d7 = abstractClientPlayer.posX - abstractClientPlayer.prevPosX;
                double d8 = abstractClientPlayer.posY - abstractClientPlayer.prevPosY;
                double d9 = abstractClientPlayer.posZ - abstractClientPlayer.prevPosZ;
                d5 = Math.abs(d8);
                d6 = Math.sqrt(d7 * d7 + d9 * d9);
                d4 = Math.sqrt(d6 * d6 + d5 * d5);
                f7 = abstractClientPlayer.rotationYaw / 57.295776f;
                f8 = (float)Math.atan(d8 / d6);
                if (Float.isNaN(f8)) {
                    f8 = 1.5707964f;
                }
                if (Float.isNaN(f9 = (float)(-Math.atan(d7 / d9)))) {
                    f9 = Float.isNaN(smartStatistics.prevHorizontalAngle) ? f7 : smartStatistics.prevHorizontalAngle;
                } else if (d9 < 0.0) {
                    f9 += (float)Math.PI;
                }
                smartStatistics.prevHorizontalAngle = f9;
            }
            IModelPlayer[] iModelPlayerArray = this.irp.getRenderModels();
            for (int i = 0; i < iModelPlayerArray.length; ++i) {
                SmartRenderModel smartRenderModel = iModelPlayerArray[i].getRenderModel();
                smartRenderModel.isInventory = bl;
                smartRenderModel.totalVerticalDistance = f3;
                smartRenderModel.currentVerticalSpeed = f4;
                smartRenderModel.totalDistance = f5;
                smartRenderModel.currentSpeed = f6;
                smartRenderModel.distance = d4;
                smartRenderModel.verticalDistance = d5;
                smartRenderModel.horizontalDistance = d6;
                smartRenderModel.currentCameraAngle = f7;
                smartRenderModel.currentVerticalAngle = f8;
                smartRenderModel.currentHorizontalAngle = f9;
                smartRenderModel.prevOuterRenderData = SmartRenderRender.getPreviousRendererData(abstractClientPlayer);
                smartRenderModel.isSleeping = bl2;
            }
        }
        this.irp.superRenderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
    }

    public void drawFirstPersonHand(EntityPlayer entityPlayer) {
        this.modelBipedMain.firstPerson = true;
        this.irp.superDrawFirstPersonHand(entityPlayer);
        this.modelBipedMain.firstPerson = false;
    }

    public void rotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        boolean bl;
        boolean bl2 = abstractClientPlayer instanceof EntityPlayerSP;
        boolean bl3 = bl = f3 == 1.0f && bl2 && Minecraft._E()._B instanceof cebg;
        if (!bl) {
            float f4;
            float f5 = abstractClientPlayer.prevRotationYaw + (abstractClientPlayer.rotationYaw - abstractClientPlayer.prevRotationYaw) * f3;
            if (abstractClientPlayer.isPlayerSleeping()) {
                f2 = 0.0f;
                f5 = 0.0f;
            }
            Minecraft minecraft = Minecraft._E();
            if (!bl2) {
                f4 = -abstractClientPlayer.rotationYaw;
                f4 += minecraft._u.rotationYaw;
            } else {
                f4 = f2 - SmartRenderRender.getPreviousRendererData((EntityPlayer)abstractClientPlayer).rotateAngleY * 57.295776f;
            }
            if (minecraft._M.thirdPersonView == 2 && !minecraft._u.isPlayerSleeping()) {
                f4 += 180.0f;
            }
            IModelPlayer[] iModelPlayerArray = this.irp.getRenderModels();
            for (int i = 0; i < iModelPlayerArray.length; ++i) {
                SmartRenderModel smartRenderModel = iModelPlayerArray[i].getRenderModel();
                smartRenderModel.actualRotation = f2;
                smartRenderModel.forwardRotation = f5;
                smartRenderModel.workingAngle = f4;
            }
            f2 = 0.0f;
        }
        this.irp.superRotatePlayer(abstractClientPlayer, f, f2, f3);
    }

    public void renderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        this.modelBipedMain.bipedEars.beforeRender();
        this.modelBipedMain.bipedCloak.beforeRender(abstractClientPlayer, f);
        this.irp.superRenderSpecials(abstractClientPlayer, f);
        this.modelBipedMain.bipedCloak.afterRender();
        this.modelBipedMain.bipedEars.afterRender();
    }

    public void beforeHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        SmartStatistics smartStatistics;
        if (entityLivingBase instanceof EntityPlayer && (smartStatistics = SmartStatisticsFactory.getInstance((EntityPlayer)entityLivingBase)) != null) {
            entityLivingBase.ticksExisted += smartStatistics.ticksRiding;
        }
    }

    public void afterHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        SmartStatistics smartStatistics;
        if (entityLivingBase instanceof EntityPlayer && (smartStatistics = SmartStatisticsFactory.getInstance((EntityPlayer)entityLivingBase)) != null) {
            entityLivingBase.ticksExisted -= smartStatistics.ticksRiding;
        }
    }

    public static RendererData getPreviousRendererData(EntityPlayer entityPlayer) {
        Object object;
        if (++previousRendererDataAccessCounter > 1000) {
            object = Minecraft._E()._r.playerEntities;
            Iterator iterator2 = previousRendererData.keySet().iterator();
            while (iterator2.hasNext()) {
                if (object.contains(iterator2.next())) continue;
                iterator2.remove();
            }
            previousRendererDataAccessCounter = 0;
        }
        if ((object = (RendererData)previousRendererData.get(entityPlayer)) == null) {
            object = new RendererData();
            previousRendererData.put(entityPlayer, object);
        }
        return object;
    }
}

