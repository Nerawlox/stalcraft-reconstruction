/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.animation.state;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationProperty;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationType;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.AnimationState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/animation/state/CustomAnimationState;", "Lgloomyfolken/mods/stalker/mobs/entity/animation/state/AnimationState;", "animation", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "entity", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "(Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "type", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationType;", "randomAnim", "", "(Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationType;Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;Z)V", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "customAnimation", "getCustomAnimation", "()Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "setCustomAnimation", "(Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;)V", "execute", "", "onAnimationEnd", "readNbt", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "writeNbt", "minecraft"})
public class CustomAnimationState
extends AnimationState {
    @Nullable
    private AnimationProperty customAnimation;

    @Nullable
    public final AnimationProperty getCustomAnimation() {
        return this.customAnimation;
    }

    public final void setCustomAnimation(@Nullable AnimationProperty animationProperty) {
        this.customAnimation = animationProperty;
    }

    @Override
    public void writeNbt(@NotNull qoac qoac2) {
        byte by;
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.writeNbt(qoac2);
        if (this.customAnimation == null) {
            by = -1;
            this.exit();
        } else {
            List<AnimationProperty> list2 = this.getEntity().getBaseConfig().getAnimationList();
            AnimationProperty animationProperty = this.customAnimation;
            if (animationProperty == null) {
                Intrinsics.throwNpe();
            }
            by = (byte)list2.indexOf(animationProperty);
        }
        qoac2._a(AnimationState.Companion.getID_CUSTOM_ANIM(), by);
    }

    @Override
    public void readNbt(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.readNbt(qoac2);
        byte by = qoac2._d(AnimationState.Companion.getID_CUSTOM_ANIM());
        if (by >= 0) {
            this.customAnimation = this.getEntity().getBaseConfig().getAnimationList().get(by);
        }
    }

    @Override
    public void onAnimationEnd(@NotNull AnimationProperty animationProperty) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animation");
        this.setNextAnimation(null);
    }

    @Override
    public void execute() {
        this.setNextAnimation(this.customAnimation);
        super.execute();
    }

    public CustomAnimationState(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "entity");
        super(entityMutant);
    }

    public CustomAnimationState(@Nullable AnimationProperty animationProperty, @NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "entity");
        this(entityMutant);
        this.customAnimation = animationProperty;
    }

    public CustomAnimationState(@NotNull AnimationType animationType, @NotNull EntityMutant entityMutant, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)animationType, "type");
        Intrinsics.checkParameterIsNotNull(entityMutant, "entity");
        this(entityMutant);
        this.customAnimation = entityMutant.findAnimation(animationType, entityMutant.getLogicState());
        if (bl) {
            this.generateNextRandomAnimationIndex();
        }
    }

    public /* synthetic */ CustomAnimationState(AnimationType animationType, EntityMutant entityMutant, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            bl = false;
        }
        this(animationType, entityMutant, bl);
    }
}

