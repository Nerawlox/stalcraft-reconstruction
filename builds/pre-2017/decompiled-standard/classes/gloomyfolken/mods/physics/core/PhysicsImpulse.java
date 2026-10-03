/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core;

import gloomyfolken.mods.physics.core.ImpulseApplyType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011\u00a8\u0006%"}, d2={"Lgloomyfolken/mods/physics/core/PhysicsImpulse;", "", "x", "", "y", "z", "dirX", "dirY", "dirZ", "(FFFFFF)V", "applyType", "Lgloomyfolken/mods/physics/core/ImpulseApplyType;", "getApplyType", "()Lgloomyfolken/mods/physics/core/ImpulseApplyType;", "setApplyType", "(Lgloomyfolken/mods/physics/core/ImpulseApplyType;)V", "getDirX", "()F", "getDirY", "getDirZ", "getX", "getY", "getZ", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "minecraft"})
public final class PhysicsImpulse {
    @NotNull
    private ImpulseApplyType applyType;
    private final float x;
    private final float y;
    private final float z;
    private final float dirX;
    private final float dirY;
    private final float dirZ;

    @NotNull
    public final ImpulseApplyType getApplyType() {
        return this.applyType;
    }

    public final void setApplyType(@NotNull ImpulseApplyType impulseApplyType) {
        Intrinsics.checkParameterIsNotNull((Object)impulseApplyType, "<set-?>");
        this.applyType = impulseApplyType;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final float getZ() {
        return this.z;
    }

    public final float getDirX() {
        return this.dirX;
    }

    public final float getDirY() {
        return this.dirY;
    }

    public final float getDirZ() {
        return this.dirZ;
    }

    public PhysicsImpulse(float f, float f2, float f3, float f4, float f5, float f6) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.dirX = f4;
        this.dirY = f5;
        this.dirZ = f6;
        this.applyType = ImpulseApplyType.NEAREST_PART;
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final float component3() {
        return this.z;
    }

    public final float component4() {
        return this.dirX;
    }

    public final float component5() {
        return this.dirY;
    }

    public final float component6() {
        return this.dirZ;
    }

    @NotNull
    public final PhysicsImpulse copy(float f, float f2, float f3, float f4, float f5, float f6) {
        return new PhysicsImpulse(f, f2, f3, f4, f5, f6);
    }

    @NotNull
    public static /* synthetic */ PhysicsImpulse copy$default(PhysicsImpulse physicsImpulse, float f, float f2, float f3, float f4, float f5, float f6, int n, Object object) {
        if ((n & 1) != 0) {
            f = physicsImpulse.x;
        }
        if ((n & 2) != 0) {
            f2 = physicsImpulse.y;
        }
        if ((n & 4) != 0) {
            f3 = physicsImpulse.z;
        }
        if ((n & 8) != 0) {
            f4 = physicsImpulse.dirX;
        }
        if ((n & 0x10) != 0) {
            f5 = physicsImpulse.dirY;
        }
        if ((n & 0x20) != 0) {
            f6 = physicsImpulse.dirZ;
        }
        return physicsImpulse.copy(f, f2, f3, f4, f5, f6);
    }

    public String toString() {
        return "PhysicsImpulse(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", dirX=" + this.dirX + ", dirY=" + this.dirY + ", dirZ=" + this.dirZ + ")";
    }

    public int hashCode() {
        return ((((Float.hashCode(this.x) * 31 + Float.hashCode(this.y)) * 31 + Float.hashCode(this.z)) * 31 + Float.hashCode(this.dirX)) * 31 + Float.hashCode(this.dirY)) * 31 + Float.hashCode(this.dirZ);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof PhysicsImpulse)) break block3;
                PhysicsImpulse physicsImpulse = (PhysicsImpulse)object;
                if (Float.compare(this.x, physicsImpulse.x) != 0 || Float.compare(this.y, physicsImpulse.y) != 0 || Float.compare(this.z, physicsImpulse.z) != 0 || Float.compare(this.dirX, physicsImpulse.dirX) != 0 || Float.compare(this.dirY, physicsImpulse.dirY) != 0 || Float.compare(this.dirZ, physicsImpulse.dirZ) != 0) break block3;
            }
            return true;
        }
        return false;
    }
}

