/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.pathfind;

import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\fB\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\r\u0012\u0006\u0010\n\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010*\u001a\n +*\u0004\u0018\u00010\u00060\u0006J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\rJ\b\u0010,\u001a\u00020-H\u0016R\u001a\u0010\u000f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001a\u0010#\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0004\u00a8\u0006."}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathTarget;", "", "targetEntity", "Lnet/minecraft/entity/EntityLivingBase;", "(Lnet/minecraft/entity/EntityLivingBase;)V", "pos", "Lnet/minecraft/util/Vec3;", "(Lnet/minecraft/util/Vec3;)V", "x", "", "y", "z", "(III)V", "", "(DDD)V", "exactX", "getExactX", "()D", "setExactX", "(D)V", "exactY", "getExactY", "setExactY", "exactZ", "getExactZ", "setExactZ", "pathX", "getPathX", "setPathX", "pathY", "getPathY", "setPathY", "pathZ", "getPathZ", "setPathZ", "speed", "getSpeed", "setSpeed", "<set-?>", "getTargetEntity", "()Lnet/minecraft/entity/EntityLivingBase;", "setTargetEntity", "getPosition", "kotlin.jvm.PlatformType", "toString", "", "minecraft"})
public final class PathTarget {
    @Nullable
    private EntityLivingBase targetEntity;
    private double pathX;
    private double pathY;
    private double pathZ;
    private double exactX;
    private double exactY;
    private double exactZ;
    private double speed;

    @Nullable
    public final EntityLivingBase getTargetEntity() {
        return this.targetEntity;
    }

    private final void setTargetEntity(EntityLivingBase entityLivingBase) {
        this.targetEntity = entityLivingBase;
    }

    public final double getPathX() {
        return this.pathX;
    }

    public final void setPathX(double d) {
        this.pathX = d;
    }

    public final double getPathY() {
        return this.pathY;
    }

    public final void setPathY(double d) {
        this.pathY = d;
    }

    public final double getPathZ() {
        return this.pathZ;
    }

    public final void setPathZ(double d) {
        this.pathZ = d;
    }

    public final double getExactX() {
        return this.exactX;
    }

    public final void setExactX(double d) {
        this.exactX = d;
    }

    public final double getExactY() {
        return this.exactY;
    }

    public final void setExactY(double d) {
        this.exactY = d;
    }

    public final double getExactZ() {
        return this.exactZ;
    }

    public final void setExactZ(double d) {
        this.exactZ = d;
    }

    public final double getSpeed() {
        return this.speed;
    }

    public final void setSpeed(double d) {
        this.speed = d;
    }

    public final ofbx getPosition() {
        return ofbx._a(this.exactX, this.exactY, this.exactZ);
    }

    @NotNull
    public final PathTarget setSpeed(double d) {
        this.speed = d;
        return this;
    }

    @NotNull
    public String toString() {
        return "$[x: " + this.pathX + ", y: " + this.pathY + ", z: " + this.pathZ + "], speed: " + this.speed + ';';
    }

    public PathTarget(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "targetEntity");
        this.speed = 2.0;
        this.targetEntity = entityLivingBase;
        ofbx ofbx2 = McExtensionsKt.getNearestPathableBlock(entityLivingBase);
        this.pathX = (double)McExtensionsKt.floor_double(VecExtensionsKt.getX(ofbx2)) + 0.0;
        this.pathY = (double)McExtensionsKt.floor_double(VecExtensionsKt.getY(ofbx2)) + 1.0;
        this.pathZ = (double)McExtensionsKt.floor_double(VecExtensionsKt.getZ(ofbx2)) + 0.0;
        this.exactX = entityLivingBase.field_70165_t;
        this.exactY = entityLivingBase.field_70163_u;
        this.exactZ = entityLivingBase.field_70161_v;
    }

    public PathTarget(@NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(ofbx2, "pos");
        this(VecExtensionsKt.getX(ofbx2), VecExtensionsKt.getY(ofbx2), VecExtensionsKt.getZ(ofbx2));
    }

    public PathTarget(int n, int n2, int n3) {
        this((double)n + 0.0, (double)n2 + 0.0, (double)n3 + 0.0);
    }

    public PathTarget(double d, double d2, double d3) {
        this.speed = 2.0;
        this.pathX = d;
        this.pathY = d2;
        this.pathZ = d3;
        this.exactX = d;
        this.exactY = d2;
        this.exactZ = d3;
    }
}

