/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.smplayer;

import api.player.model.ModelPlayer;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.core.misc.qlgf;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.stalker.player.tupg;
import gloomyfolken.mods.stalker.smplayer.pidb;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.render.RenderPlayer;
import net.smart.moving.render.SmartMovingModel;
import net.smart.moving.render.playerapi.SmartMovingModelPlayerBase;
import net.smart.render.SmartRenderModel;
import net.smart.render.SmartRenderRender;
import net.smart.render.playerapi.SmartRenderModelPlayerBase;
import net.smart.render.statistics.SmartStatistics;
import net.smart.render.statistics.SmartStatisticsFactory;

@gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
public class ezey
extends tupg {
    private static ModelPlayer _e = new ModelPlayer(1.0f);
    private static SmartMovingModel _f;
    private static SmartRenderModel _g;
    private static zxbe _h;
    private static RenderPlayer _i;
    private float _j;

    @Override
    protected zxbe _d() {
        return _h;
    }

    @Override
    protected ModelBiped _e() {
        return _e;
    }

    public SmartRenderModel _f() {
        return _g;
    }

    @Override
    public void _a(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        if (ezey._f.isCrawl) {
            d2 += 1.0;
        }
        _i.func_77033_b(abstractClientPlayer, d, d2, d3);
    }

    @Override
    protected boolean _c() {
        return false;
    }

    @Override
    protected void _a(float f, float f2, float f3, float f4, float f5, float f6, float f7, AbstractClientPlayer abstractClientPlayer, boolean bl, float f8) {
        SmartStatistics smartStatistics = SmartStatisticsFactory.getInstance(abstractClientPlayer);
        if (smartStatistics == null) {
            return;
        }
        SmartMoving smartMoving = SmartMovingFactory.getInstance(abstractClientPlayer);
        f5 = this._a((EntityPlayer)abstractClientPlayer, smartMoving, _g, f5, bl, f8);
        this._a(_e, abstractClientPlayer, f8);
        this._a(smartMoving, _f, smartStatistics, f8);
        this._a((EntityPlayer)abstractClientPlayer, _g, smartStatistics, ezey._f.isLevitate, bl, f8);
        this._j = f5;
    }

    @Override
    protected void _a(AbstractClientPlayer abstractClientPlayer, boolean bl) {
        if (!bl && abstractClientPlayer.func_70093_af() && !(abstractClientPlayer instanceof EntityPlayerSP)) {
            ezfc._a(0.0f, -0.125f, 0.0f);
        }
        if (abstractClientPlayer instanceof EntityOtherPlayerMP && (ezey._f.isCrawl || ezey._f.isSwim || ezey._f.isDive)) {
            ezfc._a(0.0f, -1.0f, 0.0f);
        }
    }

    @Override
    protected void _a(float f, float f2, float f3, float f4, float f5, float f6, float f7, AbstractClientPlayer abstractClientPlayer) {
        super._a(f, f2, f3, f4, this._j, f6, f7, abstractClientPlayer);
    }

    private float _a(EntityPlayer entityPlayer, SmartMoving smartMoving, SmartRenderModel smartRenderModel, float f, boolean bl, float f2) {
        if (!bl) {
            float f3 = entityPlayer.field_70126_B + (entityPlayer.field_70177_z - entityPlayer.field_70126_B) * f2;
            if (smartMoving.isClimbing || smartMoving.isClimbCrawling || smartMoving.isCrawlClimbing || smartMoving.isFlying || smartMoving.isSwimming || smartMoving.isDiving || smartMoving.isCeilingClimbing || smartMoving.isHeadJumping || smartMoving.isSliding || smartMoving.isAngleJumping()) {
                entityPlayer.field_70761_aq = f3;
            }
        }
        boolean bl2 = entityPlayer instanceof EntityPlayerSP;
        if (!bl) {
            float f4;
            float f5 = entityPlayer.field_70126_B + (entityPlayer.field_70177_z - entityPlayer.field_70126_B) * f2;
            if (entityPlayer.func_70608_bn()) {
                f = 0.0f;
                f5 = 0.0f;
            }
            xpzm xpzm2 = xpzm._E();
            if (!bl2) {
                f4 = -entityPlayer.field_70177_z;
                f4 += xpzm2._u.field_70177_z;
            } else {
                f4 = f - SmartRenderRender.getPreviousRendererData((EntityPlayer)entityPlayer).rotateAngleY * 57.295776f;
            }
            if (xpzm2._M.field_74320_O == 2 && !xpzm2._u.func_70608_bn()) {
                f4 += 180.0f;
            }
            smartRenderModel.actualRotation = f;
            smartRenderModel.forwardRotation = f5;
            smartRenderModel.workingAngle = f;
        }
        return f;
    }

    private void _a(SmartMoving smartMoving, SmartMovingModel smartMovingModel, SmartStatistics smartStatistics, float f) {
        boolean bl = smartMoving.isClimbing && !smartMoving.isCrawling && !smartMoving.isCrawlClimbing && !smartMoving.isClimbJumping;
        boolean bl2 = smartMoving.isClimbJumping;
        int n = smartMoving.actualHandsClimbType;
        int n2 = smartMoving.actualFeetClimbType;
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
        int n3 = smartMoving.angleJumpType;
        boolean bl18 = smartMoving.isRopeSliding;
        float f2 = smartStatistics.getCurrentHorizontalSpeedFlattened(f, -1);
        float f3 = !bl10 && !bl12 ? 0.0f : (float)smartMoving.getOverGroundHeight(5.0);
        int n4 = bl12 && f3 < 5.0f ? smartMoving.getOverGroundBlockId(f3) : -1;
        smartMovingModel.isClimb = bl;
        smartMovingModel.isClimbJump = bl2;
        smartMovingModel.handsClimbType = n;
        smartMovingModel.feetClimbType = n2;
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
        smartMovingModel.angleJumpType = n3;
        smartMovingModel.isRopeSliding = bl18;
        smartMovingModel.currentHorizontalSpeedFlattened = f2;
        smartMovingModel.smallOverGroundHeight = f3;
        smartMovingModel.overGroundBlockId = n4;
    }

    private void _a(EntityPlayer entityPlayer, SmartRenderModel smartRenderModel, SmartStatistics smartStatistics, boolean bl, boolean bl2, float f) {
        boolean bl3 = entityPlayer.func_70608_bn();
        float f2 = smartStatistics.getTotalVerticalDistance(f);
        float f3 = smartStatistics.getCurrentVerticalSpeed(f);
        float f4 = smartStatistics.getTotalDistance(f);
        float f5 = smartStatistics.getCurrentSpeed(f);
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        if (!bl2) {
            float f12 = (float)(entityPlayer.field_70165_t - entityPlayer.field_70169_q);
            float f13 = (float)(entityPlayer.field_70163_u - entityPlayer.field_70167_r);
            float f14 = (float)(entityPlayer.field_70161_v - entityPlayer.field_70166_s);
            f7 = Math.abs(f13);
            f8 = sajh._c(f12 * f12 + f14 * f14);
            f6 = sajh._c(f8 * f8 + f7 * f7);
            f9 = entityPlayer.field_70177_z / 57.295776f;
            f10 = qlgf._c(f13, f8);
            if (Float.isNaN(f10)) {
                f10 = 1.5707964f;
            }
            if (Float.isNaN(f11 = -qlgf._c(f12, f14))) {
                f11 = Float.isNaN(smartStatistics.prevHorizontalAngle) ? f9 : smartStatistics.prevHorizontalAngle;
            }
            smartStatistics.prevHorizontalAngle = f11;
        }
        if (bl) {
            f11 = f9;
        }
        smartRenderModel.isInventory = bl2;
        smartRenderModel.totalVerticalDistance = f2;
        smartRenderModel.currentVerticalSpeed = f3;
        smartRenderModel.totalDistance = f4;
        smartRenderModel.currentSpeed = f5;
        smartRenderModel.distance = f6;
        smartRenderModel.verticalDistance = f7;
        smartRenderModel.horizontalDistance = f8;
        smartRenderModel.currentCameraAngle = f9;
        smartRenderModel.currentVerticalAngle = f10;
        smartRenderModel.currentHorizontalAngle = f11;
        smartRenderModel.prevOuterRenderData = SmartRenderRender.getPreviousRendererData(entityPlayer);
        smartRenderModel.isSleeping = bl3;
    }

    static {
        _i = new RenderPlayer();
        _h = new zxbe((jhuw)tupg._a._a, new iest[0]);
        SmartMovingModelPlayerBase smartMovingModelPlayerBase = (SmartMovingModelPlayerBase)_e.getModelPlayerBase("Smart Moving");
        _f = smartMovingModelPlayerBase.getMovingModel();
        SmartRenderModelPlayerBase smartRenderModelPlayerBase = (SmartRenderModelPlayerBase)_e.getModelPlayerBase("Smart Render");
        _g = smartRenderModelPlayerBase.getRenderModel();
        ezey._g.movingModel = _f;
        _h._b(new pidb(new nuco(), _g));
        _i.func_76976_a(gqqu._b);
    }
}

