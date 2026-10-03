/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0018\u001a\u00020\u0000J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0016J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0016J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\fR\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2={"Lgloomyfolken/mods/core/entity/pathfind/AdvancedPathEntity;", "Lnet/minecraft/pathfinding/PathEntity;", "target", "Lnet/minecraft/util/Vec3;", "(Lnet/minecraft/util/Vec3;)V", "par1ArrayOfPathPoint", "", "Lnet/minecraft/pathfinding/PathPoint;", "([Lnet/minecraft/pathfinding/PathPoint;)V", "exactTarget", "kotlin.jvm.PlatformType", "iterationCount", "", "getIterationCount", "()I", "setIterationCount", "(I)V", "useExactTargeting", "", "wasPathSearchAborted", "getWasPathSearchAborted", "()Z", "setWasPathSearchAborted", "(Z)V", "applyUnfinishedPathPenalty", "getVectorFromIndex", "par1Entity", "Lnet/minecraft/entity/Entity;", "par2", "isSamePath", "par1PathEntity", "withIterationCount", "count", "minecraft"})
public final class ofvb
extends PathEntity {
    private final Vec3 _d;
    private boolean _e;
    private boolean _f;
    private int _g;

    @Override
    @NotNull
    public Vec3 _a(@Nullable Entity entity, int n) {
        if (this._e) {
            Vec3 vec3 = this._d;
            Intrinsics.checkExpressionValueIsNotNull(vec3, "exactTarget");
            return vec3;
        }
        Vec3 vec3 = super._a(entity, n);
        Intrinsics.checkExpressionValueIsNotNull(vec3, "super.getVectorFromIndex(par1Entity, par2)");
        return vec3;
    }

    public final boolean _a() {
        return this._f;
    }

    public final void _a(boolean bl) {
        this._f = bl;
    }

    public final int _b() {
        return this._g;
    }

    public final void _a(int n) {
        this._g = n;
    }

    @NotNull
    public final ofvb _c() {
        this._f = true;
        return this;
    }

    @NotNull
    public final ofvb _b(int n) {
        this._g = n;
        return this;
    }

    @Override
    public boolean _a(@Nullable PathEntity pathEntity) {
        return false;
    }

    public ofvb(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "target");
        Object[] objectArray = new elhc[]{new elhc((int)vec3._c, (int)vec3._d, (int)vec3._e)};
        ofvb ofvb2 = this;
        Object[] objectArray2 = objectArray;
        super((elhc[])objectArray2);
        this._d = Vec3._a(0.0, 0.0, 0.0);
        VecExtensionsKt.set(this._d, vec3);
        this._e = true;
    }

    public ofvb(@NotNull elhc[] elhcArray) {
        Intrinsics.checkParameterIsNotNull(elhcArray, "par1ArrayOfPathPoint");
        super(elhcArray);
        this._d = Vec3._a(0.0, 0.0, 0.0);
    }
}

