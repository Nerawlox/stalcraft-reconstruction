/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.render;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.core.client.SkeletonBody;
import gloomyfolken.mods.physics.core.client.SkeletonSegment;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.RagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.client.render.ICorpseAnimationState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0010\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nj\u0002`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationStateDynamic;", "Lgloomyfolken/mods/physics/ragdolls/client/render/ICorpseAnimationState;", "corpse", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollCorpse;", "(Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollCorpse;)V", "getCorpse", "()Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollCorpse;", "idq", "Lorg/lwjgl/util/vector/Quaternion;", "v", "Lorg/lwjgl/util/vector/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3gl;", "getRootTranslation", "getRotation", "index", "", "getTranslation", "interpolate", "", "partialTickTime", "", "minecraft"})
public final class CorpseAnimationStateDynamic
implements ICorpseAnimationState {
    private final Vector3f v;
    private final Quaternion idq;
    @NotNull
    private final RagdollCorpse corpse;

    private final Vector3f getRootTranslation() {
        SkeletonSegment skeletonSegment = this.corpse.getRoot();
        if (skeletonSegment == null) {
            Intrinsics.throwNpe();
        }
        return skeletonSegment.getWorldPosition();
    }

    @Override
    @NotNull
    public Vector3f getTranslation(int n) {
        SkeletonSegment skeletonSegment = this.corpse.getSegments().get(n);
        if (skeletonSegment != null) {
            Vector3f.sub(skeletonSegment.getWorldPosition(), this.getRootTranslation(), this.v);
        } else {
            VecExtensionsKt.resetl(this.v);
        }
        return this.v;
    }

    @Override
    @NotNull
    public Quaternion getRotation(int n) {
        Object object = this.corpse.getSegments().get(n);
        if (object == null || (object = ((SkeletonSegment)object).getBoneRotation()) == null) {
            object = this.idq;
        }
        return object;
    }

    @Override
    public void interpolate(float f) {
        Iterable iterable = this.corpse.getSegments().values();
        for (Object t : iterable) {
            SkeletonSegment skeletonSegment = (SkeletonSegment)t;
            SkeletonBody skeletonBody = skeletonSegment.getBody();
            if (skeletonBody == null) continue;
            skeletonBody.renderUpdate(f);
        }
    }

    @NotNull
    public final RagdollCorpse getCorpse() {
        return this.corpse;
    }

    public CorpseAnimationStateDynamic(@NotNull RagdollCorpse ragdollCorpse) {
        Intrinsics.checkParameterIsNotNull(ragdollCorpse, "corpse");
        this.corpse = ragdollCorpse;
        this.v = new Vector3f();
        this.idq = new Quaternion();
    }
}

