/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.animation.state;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.AnimationState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0006\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/animation/state/RestAnimationState;", "Lgloomyfolken/mods/stalker/mobs/entity/animation/state/AnimationState;", "entity", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "targetStage", "", "playRandomRestStage", "", "readNbt", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "setTargetStage", "stage", "startExitingState", "writeNbt", "minecraft"})
public final class RestAnimationState
extends AnimationState {
    private int targetStage;

    private final void setTargetStage(int n) {
        this.targetStage = n;
        this.markDirty();
    }

    public final void startExitingState() {
        this.setTargetStage(0);
    }

    public final void playRandomRestStage() {
        int n = this.getEntity().getBaseConfig().getRestStages();
        this.setTargetStage(1 + this.getEntity().func_70681_au().nextInt(n));
    }

    @Override
    public void writeNbt(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.writeNbt(qoac2);
        qoac2._a(AnimationState.Companion.getID_REST_STAGE(), (byte)this.targetStage);
    }

    @Override
    public void readNbt(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.readNbt(qoac2);
        this.targetStage = qoac2._d(AnimationState.Companion.getID_REST_STAGE());
        this.playNextAnimation();
    }

    public RestAnimationState(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "entity");
        super(entityMutant);
        this.targetStage = 1;
    }
}

