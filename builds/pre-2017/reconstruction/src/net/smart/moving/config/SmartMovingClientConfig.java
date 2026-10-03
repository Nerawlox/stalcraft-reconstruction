/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.config;

import net.smart.moving.config.SmartMovingConfig;

public class SmartMovingClientConfig
extends SmartMovingConfig {
    public static final int Sprinting = 0;
    public static final int Running = 1;
    public static final int Walking = 2;
    public static final int Sneaking = 3;
    public static final int Standing = 4;
    public static final int Up = 0;
    public static final int ChargeUp = 1;
    public static final int Angle = 2;
    public static final int HeadUp = 3;
    public static final int SlideDown = 4;
    public static final int ClimbUp = 5;
    public static final int ClimbUpHandsOnly = 6;
    public static final int ClimbBackUp = 7;
    public static final int ClimbBackUpHandsOnly = 8;
    public static final int ClimbBackHead = 9;
    public static final int ClimbBackHeadHandsOnly = 10;
    public static final int WallUp = 11;
    public static final int WallHead = 12;
    public static final int WallUpSlide = 13;
    public static final int WallHeadSlide = 14;

    public boolean isSneakingEnabled() {
        return (Boolean)this._sneak.value != false || !this.enabled;
    }

    public boolean isStandardBaseClimb() {
        return (Boolean)this._isStandardBaseClimb.value != false || !this.enabled;
    }

    public boolean isSimpleBaseClimb() {
        return (Boolean)this._isSimpleBaseClimb.value != false && this.enabled;
    }

    public boolean isSmartBaseClimb() {
        return (Boolean)this._isSmartBaseClimb.value != false && this.enabled;
    }

    public boolean isFreeBaseClimb() {
        return (Boolean)this._isFreeBaseClimb.value != false && this.enabled;
    }

    public boolean isTotalFreeLadderClimb() {
        return this.isFreeBaseClimb() && (Boolean)this._freeBaseLadderClimb.value != false;
    }

    public boolean isTotalFreeVineClimb() {
        return this.isFreeBaseClimb() && (Boolean)this._freeBaseVineClimb.value != false;
    }

    public boolean isFreeClimbAutoLaddderEnabled() {
        return (Boolean)this._freeClimbingAutoLaddder.value != false && this.enabled;
    }

    public boolean isFreeClimbAutoVineEnabled() {
        return (Boolean)this._freeClimbingAutoVine.value != false && this.enabled;
    }

    public boolean isFreeClimbingEnabled() {
        return (Boolean)this._freeClimb.value != false && this.enabled;
    }

    public boolean isCeilingClimbingEnabled() {
        return (Boolean)this._ceilingClimbing.value != false && this.enabled;
    }

    public boolean isSwimmingEnabled() {
        return (Boolean)this._swim.value != false && this.enabled;
    }

    public boolean isDivingEnabled() {
        return (Boolean)this._dive.value != false && this.enabled;
    }

    public boolean isLavaLikeWaterEnabled() {
        return (Boolean)this._lavaLikeWater.value != false && this.enabled;
    }

    public boolean isFlyingEnabled() {
        return (Boolean)this._fly.value != false && this.enabled;
    }

    public boolean isLevitateSmallEnabled() {
        return (Boolean)this._levitateSmall.value != false && this.enabled;
    }

    public boolean isRunningEnabled() {
        return (Boolean)this._run.value != false || !this.enabled;
    }

    public boolean isRunExhaustionEnabled() {
        return (Boolean)this._runExhaustion.value != false && this.enabled;
    }

    public boolean isClimbExhaustionEnabled() {
        return (Boolean)this._climbExhaustion.value != false && this.enabled;
    }

    public boolean isCeilingClimbExhaustionEnabled() {
        return (Boolean)this._ceilingClimbExhaustion.value != false && this.enabled;
    }

    public boolean isSprintingEnabled() {
        return (Boolean)this._sprint.value != false && this.enabled;
    }

    public boolean isSprintExhaustionEnabled() {
        return (Boolean)this._sprintExhaustion.value != false && this.enabled;
    }

    public boolean isJumpChargingEnabled() {
        return (Boolean)this._jumpCharge.value != false && this.enabled;
    }

    public boolean isHeadJumpingEnabled() {
        return (Boolean)this._headJump.value != false && this.enabled;
    }

    public boolean isSlidingEnabled() {
        return (Boolean)this._slide.value != false && this.enabled;
    }

    public boolean isCrawlingEnabled() {
        return (Boolean)this._crawl.value != false && this.enabled;
    }

    public boolean isExhaustionLossHungerEnabled() {
        return (Boolean)this._exhaustionLossHunger.value != false && (Boolean)this._hungerGain.value != false && this.enabled;
    }

    public boolean isHungerGainEnabled() {
        return (Boolean)this._hungerGain.value != false || !this.enabled;
    }

    public boolean isLevitationAnimationEnabled() {
        return (Boolean)this._levitateAnimation.value != false && this.enabled;
    }

    public boolean isFallAnimationEnabled() {
        return (Boolean)this._fallAnimation.value != false && this.enabled;
    }

    public boolean isJumpingEnabled(int n, int n2) {
        return !this.enabled ? true : (n2 == 1 ? (Boolean)this._jumpCharge.value : (n2 == 4 ? (Boolean)this._slide.value : (n2 != 5 && n2 != 6 ? (n2 != 7 && n2 != 8 ? (n2 != 9 && n2 != 10 ? (n2 == 11 ? (Boolean)this._wallUpJump.value : (n2 == 12 ? (Boolean)this._wallHeadJump.value : (n == 0 ? (Boolean)this._sprintJump.value : (n == 1 ? (Boolean)this._runJump.value : (n == 2 ? (Boolean)this._walkJump.value : (n == 3 ? (Boolean)this._sneakJump.value : (n == 4 ? (Boolean)this._standJump.value : true))))))) : (Boolean)this._climbBackHeadJump.value) : (Boolean)this._climbBackUpJump.value) : (Boolean)this._climbUpJump.value)));
    }

    public boolean isSideJumpEnabled() {
        return this.enabled && (Boolean)this._angleJumpSide.value != false;
    }

    public boolean isBackJumpEnabled() {
        return this.enabled && (Boolean)this._angleJumpBack.value != false;
    }

    public boolean isWallJumpEnabled() {
        return this.enabled && (Boolean)this._wallUpJump.value != false;
    }

    public boolean isJumpExhaustionEnabled(int n, int n2) {
        if (!this.enabled) {
            return false;
        }
        boolean bl = (Boolean)this._jumpExhaustion.value;
        if (n2 == 4) {
            return bl && (Boolean)this._jumpSlideExhaustion.value != false;
        }
        bl = n2 == 2 ? (bl &= ((Boolean)this._angleJumpExhaustion.value).booleanValue()) : (n2 != 5 && n2 != 6 ? (n2 != 7 && n2 != 8 ? (n2 != 9 && n2 != 10 ? (n2 == 11 ? (bl &= ((Boolean)this._wallUpJumpExhaustion.value).booleanValue()) : (n2 == 12 ? (bl &= ((Boolean)this._wallHeadJumpExhaustion.value).booleanValue()) : (bl &= ((Boolean)this._upJumpExhaustion.value).booleanValue()))) : (bl &= ((Boolean)this._climbJumpBackHeadExhaustion.value).booleanValue())) : (bl &= ((Boolean)this._climbJumpBackUpExhaustion.value).booleanValue())) : (bl &= ((Boolean)this._climbJumpUpExhaustion.value).booleanValue()));
        if (n2 != 5 && n2 != 6 && n2 != 7 && n2 != 8 && n2 != 9 && n2 != 10) {
            if (n2 != 11 && n2 != 12) {
                if (n == 0) {
                    bl &= ((Boolean)this._sprintJumpExhaustion.value).booleanValue();
                } else if (n == 1) {
                    bl &= ((Boolean)this._runJumpExhaustion.value).booleanValue();
                } else if (n == 2) {
                    bl &= ((Boolean)this._walkJumpExhaustion.value).booleanValue();
                } else if (n == 3) {
                    bl &= ((Boolean)this._sneakJumpExhaustion.value).booleanValue();
                } else if (n == 4) {
                    bl &= ((Boolean)this._standJumpExhaustion.value).booleanValue();
                }
                if (n2 == 1) {
                    bl |= ((Boolean)this._jumpChargeExhaustion.value).booleanValue();
                }
                return bl;
            }
            return bl && (Boolean)this._wallJumpExhaustion.value != false;
        }
        return bl && (Boolean)this._climbJumpExhaustion.value != false;
    }

    public float getJumpExhaustionGain(int n, int n2, float f) {
        if (!this.enabled) {
            return 0.0f;
        }
        float f2 = ((Float)this._baseExhautionGainFactor.value).floatValue() * ((Float)this._jumpExhaustionGainFactor.value).floatValue();
        if (n2 == 4) {
            return f2 * ((Float)this._jumpSlideExhaustionGainFactor.value).floatValue();
        }
        f2 = n2 == 2 ? (f2 *= ((Float)this._angleJumpExhaustionGainFactor.value).floatValue()) : (n2 != 5 && n2 != 6 ? (n2 != 7 && n2 != 8 ? (n2 != 9 && n2 != 10 ? (n2 == 11 ? (f2 *= ((Float)this._wallUpJumpExhaustionGainFactor.value).floatValue()) : (n2 == 12 ? (f2 *= ((Float)this._wallHeadJumpExhaustionGainFactor.value).floatValue()) : (f2 *= ((Float)this._upJumpExhaustionGainFactor.value).floatValue()))) : (f2 *= ((Float)this._climbJumpBackHeadExhaustionGainFactor.value).floatValue())) : (f2 *= ((Float)this._climbJumpBackUpExhaustionGainFactor.value).floatValue())) : (f2 *= ((Float)this._climbJumpUpExhaustionGainFactor.value).floatValue()));
        if (n2 != 5 && n2 != 6 && n2 != 7 && n2 != 8 && n2 != 9 && n2 != 10) {
            if (n2 != 11 && n2 != 12) {
                if (n == 0) {
                    f2 *= ((Float)this._sprintJumpExhaustionGainFactor.value).floatValue();
                } else if (n == 1) {
                    f2 *= ((Float)this._runJumpExhaustionGainFactor.value).floatValue();
                } else if (n == 2) {
                    f2 *= ((Float)this._walkJumpExhaustionGainFactor.value).floatValue();
                } else if (n == 3) {
                    f2 *= ((Float)this._sneakJumpExhaustionGainFactor.value).floatValue();
                } else if (n == 4) {
                    f2 *= ((Float)this._standJumpExhaustionGainFactor.value).floatValue();
                }
                if (n2 == 1) {
                    if (!this.isJumpExhaustionEnabled(n, 0)) {
                        f2 = 0.0f;
                    }
                    f2 += ((Float)this._baseExhautionGainFactor.value).floatValue() * ((Float)this._jumpExhaustionGainFactor.value).floatValue() * ((Float)this._upJumpExhaustionGainFactor.value).floatValue() * ((Float)this._jumpChargeExhaustionGainFactor.value).floatValue() * Math.min(f, ((Float)this._jumpChargeMaximum.value).floatValue()) / ((Float)this._jumpChargeMaximum.value).floatValue();
                }
                return f2;
            }
            return f2 * ((Float)this._wallJumpExhaustionGainFactor.value).floatValue();
        }
        return f2 * ((Float)this._climbJumpExhaustionGainFactor.value).floatValue();
    }

    public float getJumpExhaustionStop(int n, int n2, float f) {
        float f2 = ((Float)this._jumpExhaustionStopFactor.value).floatValue();
        if (n2 == 4) {
            return f2 * ((Float)this._jumpSlideExhaustionStopFactor.value).floatValue();
        }
        f2 = n2 == 2 ? (f2 *= ((Float)this._angleJumpExhaustionStopFactor.value).floatValue()) : (n2 != 5 && n2 != 6 ? (n2 != 7 && n2 != 8 ? (n2 != 9 && n2 != 10 ? (n2 == 11 ? (f2 *= ((Float)this._wallUpJumpExhaustionStopFactor.value).floatValue()) : (n2 == 12 ? (f2 *= ((Float)this._wallHeadJumpExhaustionStopFactor.value).floatValue()) : (f2 *= ((Float)this._upJumpExhaustionStopFactor.value).floatValue()))) : (f2 *= ((Float)this._climbJumpBackHeadExhaustionStopFactor.value).floatValue())) : (f2 *= ((Float)this._climbJumpBackUpExhaustionStopFactor.value).floatValue())) : (f2 *= ((Float)this._climbJumpUpExhaustionStopFactor.value).floatValue()));
        if (n2 != 5 && n2 != 6 && n2 != 7 && n2 != 8 && n2 != 9 && n2 != 10) {
            if (n2 != 11 && n2 != 12) {
                if (n == 0) {
                    f2 *= ((Float)this._sprintJumpExhaustionStopFactor.value).floatValue();
                } else if (n == 1) {
                    f2 *= ((Float)this._runJumpExhaustionStopFactor.value).floatValue();
                } else if (n == 2) {
                    f2 *= ((Float)this._walkJumpExhaustionStopFactor.value).floatValue();
                } else if (n == 3) {
                    f2 *= ((Float)this._sneakJumpExhaustionStopFactor.value).floatValue();
                } else if (n == 4) {
                    f2 *= ((Float)this._standJumpExhaustionStopFactor.value).floatValue();
                }
                if (n2 == 1) {
                    if (!this.isJumpExhaustionEnabled(n, 0)) {
                        f2 += this.getJumpExhaustionGain(n, 0, 0.0f);
                    }
                    f2 -= ((Float)this._jumpExhaustionStopFactor.value).floatValue() * ((Float)this._upJumpExhaustionStopFactor.value).floatValue() * ((Float)this._jumpChargeExhaustionStopFactor.value).floatValue() * Math.min(f, ((Float)this._jumpChargeMaximum.value).floatValue()) / ((Float)this._jumpChargeMaximum.value).floatValue();
                }
                return f2;
            }
            return f2 * ((Float)this._wallJumpExhaustionStopFactor.value).floatValue();
        }
        return f2 * ((Float)this._climbJumpExhaustionStopFactor.value).floatValue();
    }

    public float getJumpChargeFactor(float f) {
        if (this.enabled && ((Boolean)this._jumpCharge.value).booleanValue()) {
            f = Math.min(f, ((Float)this._jumpChargeMaximum.value).floatValue());
            return 1.0f + f / ((Float)this._jumpChargeMaximum.value).floatValue() * (((Float)this._jumpChargeFactor.value).floatValue() - 1.0f);
        }
        return 1.0f;
    }

    public float getHeadJumpFactor(float f) {
        if (this.enabled && ((Boolean)this._headJump.value).booleanValue()) {
            f = Math.min(f, ((Float)this._headJumpChargeMaximum.value).floatValue());
            return (f - 1.0f) / (((Float)this._headJumpChargeMaximum.value).floatValue() - 1.0f);
        }
        return 1.0f;
    }

    public float getJumpVerticalFactor(int n, int n2) {
        if (!this.enabled) {
            return 1.0f;
        }
        float f = ((Float)this._jumpVerticalFactor.value).floatValue();
        if (n2 == 2) {
            return f * ((Float)this._angleJumpVerticalFactor.value).floatValue();
        }
        if (n2 == 5 || n2 == 6) {
            f *= ((Float)this._climbUpJumpVerticalFactor.value).floatValue();
        }
        if (n2 == 6) {
            f *= ((Float)this._climbUpJumpHandsOnlyVerticalFactor.value).floatValue();
        }
        if (n2 == 7 || n2 == 8) {
            f *= ((Float)this._climbBackUpJumpVerticalFactor.value).floatValue();
        }
        if (n2 == 8) {
            f *= ((Float)this._climbBackUpJumpHandsOnlyVerticalFactor.value).floatValue();
        }
        if (n2 == 9 || n2 == 10) {
            f *= ((Float)this._climbBackHeadJumpVerticalFactor.value).floatValue();
        }
        if (n2 == 10) {
            f *= ((Float)this._climbBackHeadJumpHandsOnlyVerticalFactor.value).floatValue();
        }
        if (n2 == 11 || n2 == 12) {
            f *= ((Float)this._wallUpJumpVerticalFactor.value).floatValue();
        }
        if (n2 == 12) {
            f *= ((Float)this._wallHeadJumpVerticalFactor.value).floatValue();
        }
        if (n2 != 2 && n2 != 5 && n2 != 6 && n2 != 7 && n2 != 8 && n2 != 9 && n2 != 10 && n2 != 11 && n2 != 12) {
            if (n == 0) {
                f *= ((Float)this._sprintJumpVerticalFactor.value).floatValue();
            } else if (n == 1) {
                f *= ((Float)this._runJumpVerticalFactor.value).floatValue();
            } else if (n == 2) {
                f *= ((Float)this._walkJumpVerticalFactor.value).floatValue();
            } else if (n == 3) {
                f *= ((Float)this._sneakJumpVerticalFactor.value).floatValue();
            } else if (n == 4) {
                f *= ((Float)this._standJumpVerticalFactor.value).floatValue();
            }
            return f;
        }
        return f;
    }

    public float getJumpHorizontalFactor(int n, int n2) {
        if (!this.enabled) {
            return n == 1 ? 2.0f : 1.0f;
        }
        float f = ((Float)this._jumpHorizontalFactor.value).floatValue();
        if (n2 == 2) {
            f *= ((Float)this._angleJumpHorizontalFactor.value).floatValue();
        }
        if (n2 == 7 || n2 == 8) {
            f *= ((Float)this._climbBackUpJumpHorizontalFactor.value).floatValue();
        }
        if (n2 == 8) {
            f *= ((Float)this._climbBackUpJumpHandsOnlyHorizontalFactor.value).floatValue();
        }
        if (n2 == 9 || n2 == 10) {
            f *= ((Float)this._climbBackHeadJumpHorizontalFactor.value).floatValue();
        }
        if (n2 == 10) {
            f *= ((Float)this._climbBackHeadJumpHandsOnlyHorizontalFactor.value).floatValue();
        }
        if (n2 == 11) {
            f *= ((Float)this._wallUpJumpHorizontalFactor.value).floatValue();
        }
        if (n2 == 12) {
            f *= ((Float)this._wallHeadJumpHorizontalFactor.value).floatValue();
        }
        if (n2 != 2 && n2 != 5 && n2 != 6 && n2 != 7 && n2 != 8 && n2 != 9 && n2 != 10 && n2 != 11 && n2 != 12) {
            if (n == 0) {
                f *= ((Float)this._sprintJumpHorizontalFactor.value).floatValue();
            } else if (n == 1) {
                f *= ((Float)this._runJumpHorizontalFactor.value).floatValue();
            } else if (n == 2) {
                f *= ((Float)this._walkJumpHorizontalFactor.value).floatValue();
            } else if (n == 3) {
                f *= ((Float)this._sneakJumpHorizontalFactor.value).floatValue();
            } else if (n == 4 && n2 != 7 && n2 != 8 && n2 != 9 && n2 != 10) {
                f *= 0.0f;
            }
            return f;
        }
        return f;
    }

    public float getMaxHorizontalMotion(int n, int n2, boolean bl) {
        float f = 0.11785204f;
        if (!this.enabled) {
            return n == 1 ? f * 1.3f : f;
        }
        if (bl) {
            f = 0.07839603f;
        }
        if (n == 0) {
            f *= ((Float)this._sprintFactor.value).floatValue();
        } else if (n == 1) {
            f *= ((Float)this._runFactor.value).floatValue();
        } else if (n == 3) {
            f *= ((Float)this._sneakFactor.value).floatValue();
        }
        return f;
    }

    public float getMaxExhaustion() {
        float f = 0.0f;
        if (((Boolean)this._run.value).booleanValue() && ((Boolean)this._runExhaustion.value).booleanValue()) {
            f = this.max(f, ((Float)this._runExhaustionStop.value).floatValue());
        }
        if (((Boolean)this._sprint.value).booleanValue() && ((Boolean)this._sprintExhaustion.value).booleanValue()) {
            f = this.max(f, ((Float)this._sprintExhaustionStop.value).floatValue());
        }
        if (((Boolean)this._jump.value).booleanValue()) {
            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 14; ++j) {
                    if (!this.isJumpExhaustionEnabled(i, j)) continue;
                    for (int k = 0; k <= 1; ++k) {
                        f = this.max(f, this.getJumpExhaustionStop(i, j, k) + this.getJumpExhaustionGain(i, j, k));
                    }
                }
            }
        }
        if (((Boolean)this._freeClimb.value).booleanValue() && ((Boolean)this._climbExhaustion.value).booleanValue()) {
            f = this.max(f, ((Float)this._climbExhaustionStop.value).floatValue());
        }
        if (((Boolean)this._ceilingClimbing.value).booleanValue() && ((Boolean)this._ceilingClimbExhaustion.value).booleanValue()) {
            f = this.max(f, ((Float)this._ceilingClimbExhaustionStop.value).floatValue());
        }
        return f;
    }

    private float max(float f, float f2) {
        return f2 == java.lang.Float.POSITIVE_INFINITY ? f : Math.max(f, f2);
    }

    public float getFactor(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15) {
        bl14 |= bl15;
        boolean bl16 = (bl8 |= bl9) || bl10 || bl13 || bl12;
        boolean bl17 = !bl2 && !bl16;
        bl3 = bl16 ? bl4 : bl3;
        float f = (bl ? (Float)this._baseHungerGainFactor.value : (Float)this._baseExhautionLossFactor.value).floatValue();
        f = bl17 ? (f *= bl ? 0.0f : ((Float)this._fallExhautionLossFactor.value).floatValue()) : (bl7 ? (f *= (bl ? (Float)this._sprintingHungerGainFactor.value : (Float)this._sprintingExhautionLossFactor.value).floatValue()) : (bl6 ? (f *= (bl ? (Float)this._runningHungerGainFactor.value : (Float)this._runningExhautionLossFactor.value).floatValue()) : ((bl5 &= !bl3) ? (f *= (bl ? (Float)this._sneakingHungerGainFactor.value : (Float)this._sneakingExhautionLossFactor.value).floatValue()) : (bl3 ? (f *= (bl ? (Float)this._standingHungerGainFactor.value : (Float)this._standingExhautionLossFactor.value).floatValue()) : (f *= (bl ? (Float)this._walkingHungerGainFactor.value : (Float)this._walkingExhautionLossFactor.value).floatValue())))));
        f = bl8 ? (f *= (bl ? (Float)this._climbingHungerGainFactor.value : (Float)this._climbingExhaustionLossFactor.value).floatValue()) : (bl14 ? (f *= (bl ? (Float)this._crawlingHungerGainFactor.value : (Float)this._crawlingExhaustionLossFactor.value).floatValue()) : (bl10 ? (f *= (bl ? (Float)this._ceilClimbingHungerGainFactor.value : (Float)this._ceilClimbingExhaustionLossFactor.value).floatValue()) : (bl12 ? (f *= (bl ? (Float)this._swimmingHungerGainFactor.value : (Float)this._swimmingExhaustionLossFactor.value).floatValue()) : (bl13 ? (f *= (bl ? (Float)this._divingHungerGainFactor.value : (Float)this._divingExhaustionLossFactor.value).floatValue()) : (bl11 ? (f *= (bl ? (Float)this._dippingHungerGainFactor.value : (Float)this._dippingExhaustionLossFactor.value).floatValue()) : (bl2 ? (f *= (bl ? (Float)this._normalHungerGainFactor.value : (Float)this._normalExhaustionLossFactor.value).floatValue()) : (f *= (bl ? (Float)this._normalHungerGainFactor.value : (Float)this._normalExhaustionLossFactor.value).floatValue())))))));
        return f;
    }
}

