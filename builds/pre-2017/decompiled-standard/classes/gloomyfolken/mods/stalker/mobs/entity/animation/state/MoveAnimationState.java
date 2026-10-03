/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.animation.state;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationProperty;
import gloomyfolken.mods.stalker.mobs.entity.animation.EnumPlayMode;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.AnimationState;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.LogicState;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.MoveAnimationState$WhenMappings;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/animation/state/MoveAnimationState;", "Lgloomyfolken/mods/stalker/mobs/entity/animation/state/AnimationState;", "entityMutant", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "AVG_MOTION_TICKS", "", "avgSpeed", "", "", "[Ljava/lang/Float;", "lastDamaged", "", "lastLogicState", "Lgloomyfolken/mods/stalker/mobs/entity/animation/state/LogicState;", "blocksMovement", "calculateAnimationSpeed", "animation", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "getActionName", "", "logicState", "getAvgSpeed", "isInterruptible", "playAnimation", "", "animationProperty", "blendMode", "Lgloomyfolken/mods/stalker/mobs/entity/animation/EnumPlayMode;", "setNewAnimation", "shouldAnimationLoop", "shouldEntityPlayDmgAnim", "tickAnimation", "minecraft"})
public final class MoveAnimationState
extends AnimationState {
    private final int AVG_MOTION_TICKS = 3;
    private boolean lastDamaged;
    private LogicState lastLogicState;
    private Float[] avgSpeed;

    private final boolean shouldEntityPlayDmgAnim() {
        return this.getEntity().func_110143_aJ() / this.getEntity().func_110138_aP() < this.getEntity().getProperties().getMovement().getSlowdownHpThresold();
    }

    private final void setNewAnimation() {
        String string = this.lastDamaged ? "_dmg" : "";
        this.setNextAnimation(this.getEntity().findAnimation(this.getActionName(this.getEntity().getLogicState()) + string));
        if (this.getNextAnimation() == null) {
            String string2 = this.getEntity().getLogicState().name();
            EntityMutant entityMutant = this.getEntity();
            MoveAnimationState moveAnimationState = this;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.String).toLowerCase()");
            String string5 = string4;
            moveAnimationState.setNextAnimation(entityMutant.findAnimation(string5));
        }
        this.setAnimationTicksLeft(1);
    }

    private final float getAvgSpeed() {
        float f = 0.0f;
        int n = 0;
        Float[] floatArray = this.avgSpeed;
        for (int i = 0; i < floatArray.length; ++i) {
            float f2 = floatArray[i].floatValue();
            if (!(f2 >= 0.0f)) continue;
            f += f2;
            ++n;
        }
        return f / (float)n;
    }

    private final String getActionName(LogicState logicState) {
        String string;
        switch (MoveAnimationState$WhenMappings.$EnumSwitchMapping$0[logicState.ordinal()]) {
            case 1: {
                string = "idle_stand";
                break;
            }
            default: {
                String string2;
                String string3 = string2 = logicState.name();
                if (string3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String string4 = string3.toLowerCase();
                string = string4;
                Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.String).toLowerCase()");
            }
        }
        return string;
    }

    @Override
    public boolean shouldAnimationLoop(@NotNull AnimationProperty animationProperty) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animation");
        return true;
    }

    @Override
    public float calculateAnimationSpeed(@NotNull AnimationProperty animationProperty) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animation");
        float f = 1.0f;
        if (this.getEntity().getLogicState() != LogicState.STAND) {
            float f2;
            float f3 = (float)owkq._d(this.getEntity().field_70159_w + this.getEntity().field_70159_w + this.getEntity().field_70179_y + this.getEntity().field_70179_y);
            if ((double)f3 > 1.0) {
                f3 = 1.0f;
            }
            if (!this.getEntity().field_70122_E) {
                f3 *= 0.5f;
            }
            if ((double)f3 <= 0.01 || Float.isNaN(f2 = f3)) {
                f3 = (float)VecExtensionsKt.subVector(McExtensionsKt.getPos(this.getEntity()), McExtensionsKt.getPrevPos(this.getEntity()))._b();
            }
            f *= f3 / (float)2 * this.getMAGIC_SPEED_VALUE();
            f /= this.getEntity().getProperties().getCommon().getScale();
            f *= this.getEntity().getLogicState().getInverseSpeedFactor();
        }
        this.avgSpeed[this.getEntity().field_70173_aa % this.AVG_MOTION_TICKS] = Float.valueOf(f);
        return this.getAvgSpeed();
    }

    @Override
    public void tickAnimation() {
        if (this.lastDamaged != this.shouldEntityPlayDmgAnim() || Intrinsics.areEqual((Object)this.lastLogicState, (Object)this.getEntity().getLogicState()) ^ true) {
            this.lastDamaged = this.shouldEntityPlayDmgAnim();
            this.lastLogicState = this.getEntity().getLogicState();
            this.setNewAnimation();
        }
        InvokeSideOnly.client(this.isClient(), new InvokeSideOnly.InvokeClientOnly(this){
            final /* synthetic */ MoveAnimationState this$0;

            public final void run() {
                block2: {
                    if (this.this$0.getActiveAnimation() == null || this.this$0.getActiveClip() == null) break block2;
                    AnimationProperty animationProperty = this.this$0.getActiveAnimation();
                    if (animationProperty == null) {
                        Intrinsics.throwNpe();
                    }
                    float f = animationProperty.getAnimationSpeed();
                    AnimationProperty animationProperty2 = this.this$0.getActiveAnimation();
                    if (animationProperty2 == null) {
                        Intrinsics.throwNpe();
                    }
                    this.this$0.getActiveClip().speedFactor = f * this.this$0.calculateAnimationSpeed(animationProperty2);
                }
            }
            {
                this.this$0 = moveAnimationState;
            }
        });
        super.tickAnimation();
        if (this.getActiveAnimation() == null) {
            this.playNextAnimation();
        }
    }

    @Override
    public void playAnimation(@NotNull AnimationProperty animationProperty, @NotNull EnumPlayMode enumPlayMode) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animationProperty");
        Intrinsics.checkParameterIsNotNull((Object)enumPlayMode, "blendMode");
        super.playAnimation(animationProperty, enumPlayMode);
        this.setAnimationTicksLeft(9999999);
        this.setAnimationDuration(this.getAnimationTicksLeft());
    }

    @Override
    public boolean isInterruptible() {
        return true;
    }

    @Override
    public boolean blocksMovement() {
        return false;
    }

    public MoveAnimationState(@NotNull EntityMutant entityMutant) {
        Float[] floatArray;
        Intrinsics.checkParameterIsNotNull(entityMutant, "entityMutant");
        super(entityMutant);
        this.AVG_MOTION_TICKS = 3;
        this.lastLogicState = entityMutant.getLogicState();
        int n = this.AVG_MOTION_TICKS;
        MoveAnimationState moveAnimationState = this;
        Float[] floatArray2 = new Float[n];
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            do {
                Float f;
                int n4 = ++n2;
                int n5 = n2;
                floatArray = floatArray2;
                floatArray[n5] = f = Float.valueOf(-1.0f);
            } while (n2 != n3);
        }
        floatArray = floatArray2;
        moveAnimationState.avgSpeed = floatArray;
        this.setNewAnimation();
    }
}

