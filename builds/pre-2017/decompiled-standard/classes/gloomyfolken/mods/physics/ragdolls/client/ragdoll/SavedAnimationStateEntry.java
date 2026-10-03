/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.eidj;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/SavedAnimationStateEntry;", "", "entityId", "", "tickSavedAt", "", "state", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "pos", "Lnet/minecraft/util/Vec3;", "aabb", "Lnet/minecraft/util/AxisAlignedBB;", "(IJLgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/AxisAlignedBB;)V", "getAabb", "()Lnet/minecraft/util/AxisAlignedBB;", "setAabb", "(Lnet/minecraft/util/AxisAlignedBB;)V", "getEntityId", "()I", "setEntityId", "(I)V", "getPos", "()Lnet/minecraft/util/Vec3;", "setPos", "(Lnet/minecraft/util/Vec3;)V", "getState", "()Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "setState", "(Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;)V", "getTickSavedAt", "()J", "setTickSavedAt", "(J)V", "minecraft"})
public final class SavedAnimationStateEntry {
    private int entityId;
    private long tickSavedAt;
    @NotNull
    private ivtm state;
    @NotNull
    private ofbx pos;
    @NotNull
    private eidj aabb;

    public final int getEntityId() {
        return this.entityId;
    }

    public final void setEntityId(int n) {
        this.entityId = n;
    }

    public final long getTickSavedAt() {
        return this.tickSavedAt;
    }

    public final void setTickSavedAt(long l) {
        this.tickSavedAt = l;
    }

    @NotNull
    public final ivtm getState() {
        return this.state;
    }

    public final void setState(@NotNull ivtm ivtm2) {
        Intrinsics.checkParameterIsNotNull(ivtm2, "<set-?>");
        this.state = ivtm2;
    }

    @NotNull
    public final ofbx getPos() {
        return this.pos;
    }

    public final void setPos(@NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(ofbx2, "<set-?>");
        this.pos = ofbx2;
    }

    @NotNull
    public final eidj getAabb() {
        return this.aabb;
    }

    public final void setAabb(@NotNull eidj eidj2) {
        Intrinsics.checkParameterIsNotNull(eidj2, "<set-?>");
        this.aabb = eidj2;
    }

    public SavedAnimationStateEntry(int n, long l, @NotNull ivtm ivtm2, @NotNull ofbx ofbx2, @NotNull eidj eidj2) {
        Intrinsics.checkParameterIsNotNull(ivtm2, "state");
        Intrinsics.checkParameterIsNotNull(ofbx2, "pos");
        Intrinsics.checkParameterIsNotNull(eidj2, "aabb");
        ofbx ofbx3 = ofbx._a(0.0, 0.0, 0.0);
        Intrinsics.checkExpressionValueIsNotNull(ofbx3, "Vec3.createVectorHelper(0.0, 0.0, 0.0)");
        this.pos = ofbx3;
        eidj eidj3 = eidj._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        Intrinsics.checkExpressionValueIsNotNull(eidj3, "AxisAlignedBB.getBoundin\u2026 0.0, 0.0, 0.0, 0.0, 0.0)");
        this.aabb = eidj3;
        this.entityId = n;
        this.tickSavedAt = l;
        this.state = ivtm2;
        VecExtensionsKt.set(this.pos, VecExtensionsKt.getX(ofbx2), VecExtensionsKt.getY(ofbx2), VecExtensionsKt.getZ(ofbx2));
        this.aabb._c(eidj2);
    }
}

