/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityLavaFX;
import net.minecraft.client.particle.EntitySplashFX;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import net.smart.moving.IEntityPlayerSP;
import net.smart.moving.SmartMovingBase;
import net.smart.moving.SmartMovingContext;
import net.smart.render.RendererData;
import net.smart.render.SmartRenderRender;

public abstract class SmartMoving
extends SmartMovingBase {
    public boolean isSlow;
    public boolean isFast;
    public boolean isClimbing;
    public boolean isHandsVineClimbing;
    public boolean isFeetVineClimbing;
    public boolean isClimbJumping;
    public boolean isClimbBackJumping;
    public boolean isWallJumping;
    public boolean isClimbCrawling;
    public boolean isCrawlClimbing;
    public boolean isCeilingClimbing;
    public boolean isRopeSliding;
    public boolean isDipping;
    public boolean isSwimming;
    public boolean isDiving;
    public boolean isLevitating;
    public boolean isHeadJumping;
    public boolean isCrawling;
    public boolean isSliding;
    public boolean isFlying;
    public int actualHandsClimbType;
    public int actualFeetClimbType;
    public int angleJumpType;
    public float heightOffset;
    private float spawnSlindingParticle;
    private float spawnSwimmingParticle;

    public SmartMoving(EntityPlayer entityPlayer, IEntityPlayerSP iEntityPlayerSP) {
        super(entityPlayer, iEntityPlayerSP);
    }

    public boolean isAngleJumping() {
        return this.angleJumpType > 1 && this.angleJumpType < 7;
    }

    public abstract boolean isJumping();

    public abstract boolean doFlyingAnimation();

    public abstract boolean doFallingAnimation();

    protected void spawnParticles(xpzm xpzm2, double d, double d2) {
        double d3;
        double d4;
        int n;
        int n2;
        int n3;
        int n4;
        float f = 0.0f;
        if (this.isSliding || this.isSwimming) {
            f = (float)(d * d + d2 * d2);
        }
        if (this.isSliding && (n4 = this.sp.field_70170_p.func_72798_a(n3 = sajh._c(this.sp.field_70165_t), n2 = sajh._c(this.sp.field_70121_D._c - (double)0.1f), n = sajh._c(this.sp.field_70161_v))) > 0) {
            double d5 = this.sp.field_70121_D._c + 0.1;
            double d6 = -d * 4.0;
            d4 = 1.5;
            d3 = -d2 * 4.0;
            this.spawnSlindingParticle += f;
            float f2 = ((Float)SmartMovingContext.Config._slideParticlePeriodFactor.value).floatValue() * 0.1f;
            while (this.spawnSlindingParticle > f2) {
                double d7 = this.sp.field_70165_t + (double)this.getSpawnOffset();
                double d8 = this.sp.field_70161_v + (double)this.getSpawnOffset();
                int n5 = this.sp.field_70170_p.func_72805_g(n3, n2, n);
                this.sp.field_70170_p.func_72869_a("tilecrack_" + n4 + "_" + n5, d7, d5, d8, d6, d4, d3);
                this.spawnSlindingParticle -= f2;
            }
        }
        if (this.isSwimming) {
            float f3 = (float)sajh._c(this.sp.field_70121_D._c) + 1.0f;
            n2 = (int)Math.floor(this.sp.field_70165_t);
            int n6 = this.sp.field_70170_p.func_72798_a(n2, n = (int)Math.floor((double)f3 - 0.5), n4 = (int)Math.floor(this.sp.field_70161_v));
            twgu twgu2 = n6 > 0 ? twgu.field_71973_m[n6] : null;
            boolean bl = twgu2 != null && this.isLava(twgu2.field_71990_ca);
            this.spawnSwimmingParticle += f;
            float f4 = (bl ? (Float)SmartMovingContext.Config._lavaSwimParticlePeriodFactor.value : (Float)SmartMovingContext.Config._swimParticlePeriodFactor.value).floatValue() * 0.01f;
            while (this.spawnSwimmingParticle > f4) {
                d4 = this.sp.field_70165_t + (double)this.getSpawnOffset();
                d3 = this.sp.field_70161_v + (double)this.getSpawnOffset();
                EntityFX entityFX = bl ? new EntityLavaFX(this.sp.field_70170_p, d4, f3, d3) : new EntitySplashFX(this.sp.field_70170_p, d4, f3, d3, 0.0, 0.0, 0.0);
                ((Entity)entityFX).field_70159_w = 0.0;
                ((Entity)entityFX).field_70181_x = 0.2;
                ((Entity)entityFX).field_70179_y = 0.0;
                xpzm2._w._a(entityFX);
                this.spawnSwimmingParticle -= f4;
            }
        }
    }

    private float getSpawnOffset() {
        return (this.sp.func_70681_au().nextFloat() - 0.5f) * 2.0f * this.sp.field_70130_N;
    }

    protected void onStartClimbBackJump() {
        RendererData rendererData = SmartRenderRender.getPreviousRendererData(this.sp);
        rendererData.rotateAngleY = rendererData.rotateAngleY + (this.isHeadJumping ? (float)Math.PI : 1.5707964f);
        this.isClimbBackJumping = true;
    }

    protected void onStartWallJump(Float f) {
        if (f != null) {
            SmartRenderRender.getPreviousRendererData((EntityPlayer)this.sp).rotateAngleY = f.floatValue() / 57.295776f;
        }
        this.isWallJumping = true;
        this.sp.field_70143_R = 0.0f;
    }
}

