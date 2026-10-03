/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.render;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.physics.ragdolls.client.render.CorpseAnimationHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

@ezey(_a={eidj.CLIENT})
@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/AnimationEntryRagdoll;", "Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationEntryDynamic;", "type", "Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationLayer;", "animationHandler", "Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationHandler;", "(Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationLayer;Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationHandler;)V", "getAnimationHandler", "()Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationHandler;", "update", "", "context", "Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationContext;", "target", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "partialTickTime", "", "writeRotation", "", "bone", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeleton$McsaBone;", "q", "Lorg/lwjgl/util/vector/Quaternion;", "writeTranslation", "v", "Lorg/lwjgl/util/vector/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3gl;", "minecraft"})
public final class AnimationEntryRagdoll
extends vkum {
    @NotNull
    private final CorpseAnimationHandler animationHandler;

    @Override
    public void update(@NotNull zxbe zxbe2, @NotNull ivtm ivtm2, float f) {
        Intrinsics.checkParameterIsNotNull(zxbe2, "context");
        Intrinsics.checkParameterIsNotNull(ivtm2, "target");
        super.update(zxbe2, ivtm2, f);
        this.animationHandler.getAnimationState().interpolate(f);
    }

    @Override
    public boolean writeTranslation(@NotNull jywl.kjui kjui2, @NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(kjui2, "bone");
        Intrinsics.checkParameterIsNotNull(vector3f, "v");
        vector3f.set(this.animationHandler.getAnimationState().getTranslation(kjui2._c));
        vector3f.scale(1.0f / this.animationHandler.getCorpse().getOwnerScale());
        return false;
    }

    @Override
    public boolean writeRotation(@NotNull jywl.kjui kjui2, @NotNull Quaternion quaternion) {
        Intrinsics.checkParameterIsNotNull(kjui2, "bone");
        Intrinsics.checkParameterIsNotNull(quaternion, "q");
        quaternion.set(this.animationHandler.getAnimationState().getRotation(kjui2._c));
        return false;
    }

    @NotNull
    public final CorpseAnimationHandler getAnimationHandler() {
        return this.animationHandler;
    }

    public AnimationEntryRagdoll(@NotNull nuco nuco2, @NotNull CorpseAnimationHandler corpseAnimationHandler) {
        Intrinsics.checkParameterIsNotNull(nuco2, "type");
        Intrinsics.checkParameterIsNotNull(corpseAnimationHandler, "animationHandler");
        super(nuco2);
        this.animationHandler = corpseAnimationHandler;
    }
}

