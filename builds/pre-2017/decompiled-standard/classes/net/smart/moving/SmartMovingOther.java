/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.smart.moving.SmartMoving;

public class SmartMovingOther
extends SmartMoving {
    public boolean foundAlive;
    private boolean _isJumping = false;
    private boolean _doFlyingAnimation = false;
    private boolean _doFallingAnimation = false;

    public SmartMovingOther(EntityOtherPlayerMP entityOtherPlayerMP) {
        super(entityOtherPlayerMP, null);
    }

    public void processStatePacket(long l) {
        this.actualFeetClimbType = (int)(l & 0xFL);
        this.actualHandsClimbType = (int)((l >>>= 4) & 0xFL);
        this._isJumping = ((l >>>= 4) & 1L) != 0L;
        this.isDiving = ((l >>>= 1) & 1L) != 0L;
        this.isDipping = ((l >>>= 1) & 1L) != 0L;
        this.isSwimming = ((l >>>= 1) & 1L) != 0L;
        this.isCrawlClimbing = ((l >>>= 1) & 1L) != 0L;
        this.isCrawling = ((l >>>= 1) & 1L) != 0L;
        this.isClimbing = ((l >>>= 1) & 1L) != 0L;
        boolean bl = ((l >>>= 1) & 1L) != 0L;
        this.heightOffset = bl ? -1.0f : 0.0f;
        this.sp.field_70131_O = 1.8f + this.heightOffset;
        this._doFallingAnimation = ((l >>>= 1) & 1L) != 0L;
        this._doFlyingAnimation = ((l >>>= 1) & 1L) != 0L;
        this.isCeilingClimbing = ((l >>>= 1) & 1L) != 0L;
        this.isLevitating = ((l >>>= 1) & 1L) != 0L;
        this.isHeadJumping = ((l >>>= 1) & 1L) != 0L;
        this.isSliding = ((l >>>= 1) & 1L) != 0L;
        this.angleJumpType = (int)((l >>>= 1) & 7L);
        this.isFeetVineClimbing = ((l >>>= 3) & 1L) != 0L;
        this.isHandsVineClimbing = ((l >>>= 1) & 1L) != 0L;
        this.isClimbJumping = ((l >>>= 1) & 1L) != 0L;
        boolean bl2 = this.isClimbBackJumping;
        boolean bl3 = this.isClimbBackJumping = ((l >>>= 1) & 1L) != 0L;
        if (!bl2 && this.isClimbBackJumping) {
            this.onStartClimbBackJump();
        }
        this.isSlow = ((l >>>= 1) & 1L) != 0L;
        this.isFast = ((l >>>= 1) & 1L) != 0L;
        boolean bl4 = this.isWallJumping;
        boolean bl5 = this.isWallJumping = ((l >>>= 1) & 1L) != 0L;
        if (!bl4 && this.isWallJumping) {
            this.onStartWallJump(null);
        }
        this.isRopeSliding = ((l >>>= 1) & 1L) != 0L;
    }

    @Override
    public boolean isJumping() {
        return this._isJumping;
    }

    @Override
    public boolean doFlyingAnimation() {
        return this._doFlyingAnimation;
    }

    @Override
    public boolean doFallingAnimation() {
        return this._doFallingAnimation;
    }
}

