/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.render;

import gloomyfolken.mods.physics.ragdolls.client.render.CorpseAnimationStateDynamic;
import gloomyfolken.mods.physics.ragdolls.client.render.ICorpseAnimationState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationStateFrozen;", "Lgloomyfolken/mods/physics/ragdolls/client/render/ICorpseAnimationState;", "state", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "scale", "", "(Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;F)V", "getScale", "()F", "getState", "()Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "getRotation", "Lorg/lwjgl/util/vector/Quaternion;", "index", "", "getTranslation", "Lorg/lwjgl/util/vector/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3gl;", "setFromDynamicState", "", "corpseAnimationStateDynamic", "Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationStateDynamic;", "minecraft"})
public final class CorpseAnimationStateFrozen
implements ICorpseAnimationState {
    @NotNull
    private final ivtm state;
    private final float scale;

    public final void setFromDynamicState(@NotNull CorpseAnimationStateDynamic corpseAnimationStateDynamic) {
        Intrinsics.checkParameterIsNotNull(corpseAnimationStateDynamic, "corpseAnimationStateDynamic");
        int n = 0;
        int n2 = this.state._a() - 1;
        if (n <= n2) {
            while (true) {
                this.state._a[n].set(corpseAnimationStateDynamic.getTranslation(n));
                this.state._b[n].set(corpseAnimationStateDynamic.getRotation(n));
                if (n == n2) break;
                ++n;
            }
        }
    }

    @Override
    @NotNull
    public Vector3f getTranslation(int n) {
        Vector3f vector3f = this.state._a[n];
        Intrinsics.checkExpressionValueIsNotNull(vector3f, "state.translations[index]");
        return vector3f;
    }

    @Override
    @NotNull
    public Quaternion getRotation(int n) {
        Quaternion quaternion = this.state._b[n];
        Intrinsics.checkExpressionValueIsNotNull(quaternion, "state.rotations[index]");
        return quaternion;
    }

    @NotNull
    public final ivtm getState() {
        return this.state;
    }

    public final float getScale() {
        return this.scale;
    }

    public CorpseAnimationStateFrozen(@NotNull ivtm ivtm2, float f) {
        Intrinsics.checkParameterIsNotNull(ivtm2, "state");
        this.state = ivtm2;
        this.scale = f;
        Vector3f[] vector3fArray = this.state._a;
        for (int i = 0; i < vector3fArray.length; ++i) {
            Vector3f vector3f = vector3fArray[i];
            vector3f.scale(this.scale);
        }
    }

    @Override
    public void interpolate(float f) {
        ICorpseAnimationState.DefaultImpls.interpolate(this, f);
    }
}

