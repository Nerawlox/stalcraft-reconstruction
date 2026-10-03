/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll;

import gloomyfolken.mods.physics.ragdolls.client.ragdoll.RagdollBoneInfo;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.SkeletonPreset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/SkeletonPresetMesh;", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/SkeletonPreset;", "()V", "setFromSkeleton", "", "data", "", "", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollBoneInfo;", "minecraft"})
public class SkeletonPresetMesh
extends SkeletonPreset {
    public final void setFromSkeleton(@NotNull Map<Integer, RagdollBoneInfo> map) {
        Intrinsics.checkParameterIsNotNull(map, "data");
        this.clearSkeleton();
        this.get_ragdollBones().putAll(map);
    }
}

