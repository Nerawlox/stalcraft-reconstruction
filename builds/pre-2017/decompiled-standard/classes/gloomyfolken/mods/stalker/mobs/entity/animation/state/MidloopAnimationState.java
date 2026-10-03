/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.animation.state;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationProperty;
import gloomyfolken.mods.stalker.mobs.entity.animation.EnumPlayMode;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.AnimationState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0006\u0010\u001f\u001a\u00020\rJ\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/animation/state/MidloopAnimationState;", "Lgloomyfolken/mods/stalker/mobs/entity/animation/state/AnimationState;", "animationName", "", "entity", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "(Ljava/lang/String;Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "baseName", "exitLoop", "", "blocksMovement", "execute", "", "getAnimState", "", "getEndAnimation", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "getMidAnimation", "getStartAnimation", "isInterruptible", "onAnimationEnd", "animation", "playAnimation", "animationProperty", "blendMode", "Lgloomyfolken/mods/stalker/mobs/entity/animation/EnumPlayMode;", "readNbt", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "shouldAnimationLoop", "suspendAction", "writeNbt", "minecraft"})
public final class MidloopAnimationState
extends AnimationState {
    private String baseName;
    private boolean exitLoop;

    @Nullable
    public final AnimationProperty getStartAnimation() {
        return this.getEntity().findAnimation("" + this.baseName + "_start");
    }

    @Nullable
    public final AnimationProperty getMidAnimation() {
        return this.getEntity().findAnimation("" + this.baseName + "_mid");
    }

    @Nullable
    public final AnimationProperty getEndAnimation() {
        return this.getEntity().findAnimation("" + this.baseName + "_end");
    }

    @Override
    public void readNbt(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.readNbt(qoac2);
        String string = qoac2._j(AnimationState.Companion.getID_LONG_ANIM_NAME());
        Intrinsics.checkExpressionValueIsNotNull(string, "tag.getString(AnimationState.ID_LONG_ANIM_NAME)");
        this.baseName = string;
        this.exitLoop = qoac2._o(AnimationState.Companion.getID_LOOP_INDEX());
        if (this.exitLoop) {
            this.suspendAction();
        }
    }

    @Override
    public void writeNbt(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.writeNbt(qoac2);
        qoac2._a(AnimationState.Companion.getID_LONG_ANIM_NAME(), this.baseName);
        qoac2._a(AnimationState.Companion.getID_LOOP_INDEX(), this.exitLoop);
    }

    @Override
    public void execute() {
        this.setNextAnimation(this.getStartAnimation());
        if (this.getNextAnimation() == null) {
            this.exit();
        }
        super.execute();
    }

    @Override
    public boolean shouldAnimationLoop(@NotNull AnimationProperty animationProperty) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animation");
        return Intrinsics.areEqual(animationProperty, this.getMidAnimation());
    }

    @Override
    public void onAnimationEnd(@NotNull AnimationProperty animationProperty) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animation");
        if (Intrinsics.areEqual(animationProperty, this.getStartAnimation())) {
            this.setNextAnimation(this.getMidAnimation());
        } else if (Intrinsics.areEqual(animationProperty, this.getMidAnimation())) {
            if (this.exitLoop) {
                this.setNextAnimation(this.getEndAnimation());
            }
        } else {
            this.setNextAnimation(null);
            this.exit();
        }
    }

    @Override
    public void playAnimation(@NotNull AnimationProperty animationProperty, @NotNull EnumPlayMode enumPlayMode) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animationProperty");
        Intrinsics.checkParameterIsNotNull((Object)enumPlayMode, "blendMode");
        super.playAnimation(animationProperty, enumPlayMode);
        if (Intrinsics.areEqual(animationProperty, this.getMidAnimation())) {
            this.setAnimationTicksLeft(999999);
            this.setAnimationDuration(999999);
        }
    }

    public final int getAnimState() {
        AnimationProperty animationProperty = this.getActiveAnimation();
        return Intrinsics.areEqual(animationProperty, this.getStartAnimation()) ? 0 : (Intrinsics.areEqual(animationProperty, this.getMidAnimation()) ? 1 : 2);
    }

    public final void suspendAction() {
        boolean bl = this.exitLoop;
        this.exitLoop = true;
        this.setNextAnimation(this.getEndAnimation());
        this.playNextAnimation();
        if (!bl) {
            this.markDirty();
        }
    }

    @Override
    public boolean isInterruptible() {
        return !this.getStateActive();
    }

    @Override
    public boolean blocksMovement() {
        return true;
    }

    public MidloopAnimationState(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "entity");
        super(entityMutant);
        this.baseName = "";
    }

    public MidloopAnimationState(@NotNull String string, @NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(string, "animationName");
        Intrinsics.checkParameterIsNotNull(entityMutant, "entity");
        this(entityMutant);
        this.baseName = string;
    }
}

