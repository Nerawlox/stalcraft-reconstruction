/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J?\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\f\u00a8\u0006%"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseConstructionInfo;", "", "_state", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "rotationYaw", "", "velocities", "scale", "lying", "", "(Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;FLgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;FZ)V", "get_state", "()Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "set_state", "(Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;)V", "getLying", "()Z", "setLying", "(Z)V", "getRotationYaw", "()F", "getScale", "state", "getState", "getVelocities", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "minecraft"})
public final class CorpseConstructionInfo {
    @Nullable
    private ivtm _state;
    private final float rotationYaw;
    @Nullable
    private final ivtm velocities;
    private final float scale;
    private boolean lying;

    @NotNull
    public final ivtm getState() {
        ivtm ivtm2 = this._state;
        if (ivtm2 == null) {
            Intrinsics.throwNpe();
        }
        return ivtm2;
    }

    @Nullable
    public final ivtm get_state() {
        return this._state;
    }

    public final void set_state(@Nullable ivtm ivtm2) {
        this._state = ivtm2;
    }

    public final float getRotationYaw() {
        return this.rotationYaw;
    }

    @Nullable
    public final ivtm getVelocities() {
        return this.velocities;
    }

    public final float getScale() {
        return this.scale;
    }

    public final boolean getLying() {
        return this.lying;
    }

    public final void setLying(boolean bl) {
        this.lying = bl;
    }

    public CorpseConstructionInfo(@Nullable ivtm ivtm2, float f, @Nullable ivtm ivtm3, float f2, boolean bl) {
        this._state = ivtm2;
        this.rotationYaw = f;
        this.velocities = ivtm3;
        this.scale = f2;
        this.lying = bl;
    }

    public /* synthetic */ CorpseConstructionInfo(ivtm ivtm2, float f, ivtm ivtm3, float f2, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            ivtm3 = null;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            bl = false;
        }
        this(ivtm2, f, ivtm3, f2, bl);
    }

    @Nullable
    public final ivtm component1() {
        return this._state;
    }

    public final float component2() {
        return this.rotationYaw;
    }

    @Nullable
    public final ivtm component3() {
        return this.velocities;
    }

    public final float component4() {
        return this.scale;
    }

    public final boolean component5() {
        return this.lying;
    }

    @NotNull
    public final CorpseConstructionInfo copy(@Nullable ivtm ivtm2, float f, @Nullable ivtm ivtm3, float f2, boolean bl) {
        return new CorpseConstructionInfo(ivtm2, f, ivtm3, f2, bl);
    }

    @NotNull
    public static /* synthetic */ CorpseConstructionInfo copy$default(CorpseConstructionInfo corpseConstructionInfo, ivtm ivtm2, float f, ivtm ivtm3, float f2, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            ivtm2 = corpseConstructionInfo._state;
        }
        if ((n & 2) != 0) {
            f = corpseConstructionInfo.rotationYaw;
        }
        if ((n & 4) != 0) {
            ivtm3 = corpseConstructionInfo.velocities;
        }
        if ((n & 8) != 0) {
            f2 = corpseConstructionInfo.scale;
        }
        if ((n & 0x10) != 0) {
            bl = corpseConstructionInfo.lying;
        }
        return corpseConstructionInfo.copy(ivtm2, f, ivtm3, f2, bl);
    }

    public String toString() {
        return "CorpseConstructionInfo(_state=" + this._state + ", rotationYaw=" + this.rotationYaw + ", velocities=" + this.velocities + ", scale=" + this.scale + ", lying=" + this.lying + ")";
    }

    public int hashCode() {
        ivtm ivtm2 = this._state;
        ivtm ivtm3 = this.velocities;
        int n = ((((ivtm2 != null ? ivtm2.hashCode() : 0) * 31 + Float.hashCode(this.rotationYaw)) * 31 + (ivtm3 != null ? ivtm3.hashCode() : 0)) * 31 + Float.hashCode(this.scale)) * 31;
        int n2 = this.lying ? 1 : 0;
        if (n2 != 0) {
            n2 = 1;
        }
        return n + n2;
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof CorpseConstructionInfo)) break block3;
                CorpseConstructionInfo corpseConstructionInfo = (CorpseConstructionInfo)object;
                if (!Intrinsics.areEqual(this._state, corpseConstructionInfo._state) || Float.compare(this.rotationYaw, corpseConstructionInfo.rotationYaw) != 0 || !Intrinsics.areEqual(this.velocities, corpseConstructionInfo.velocities) || Float.compare(this.scale, corpseConstructionInfo.scale) != 0 || !(this.lying == corpseConstructionInfo.lying)) break block3;
            }
            return true;
        }
        return false;
    }
}

