/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/mods/core/entity/ThrowSimulationParams;", "", "()V", "drag", "", "getDrag", "()D", "setDrag", "(D)V", "gravity", "Lnet/minecraft/util/Vec3;", "getGravity", "()Lnet/minecraft/util/Vec3;", "startPos", "getStartPos", "startVelocity", "getStartVelocity", "minecraft"})
public final class qlgf {
    @NotNull
    private final ofbx _a;
    @NotNull
    private final ofbx _b;
    @NotNull
    private final ofbx _c;
    private double _d;

    @NotNull
    public final ofbx _a() {
        return this._a;
    }

    @NotNull
    public final ofbx _b() {
        return this._b;
    }

    @NotNull
    public final ofbx _c() {
        return this._c;
    }

    public final double _d() {
        return this._d;
    }

    public final void _a(double d) {
        this._d = d;
    }

    public qlgf() {
        ofbx ofbx2 = VecExtensionsKt.vec3(0.0, -0.05, 0.0);
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "vec3(0.0, -0.05, 0.0)");
        this._a = ofbx2;
        ofbx ofbx3 = VecExtensionsKt.vec3();
        Intrinsics.checkExpressionValueIsNotNull(ofbx3, "vec3()");
        this._b = ofbx3;
        ofbx ofbx4 = VecExtensionsKt.vec3();
        Intrinsics.checkExpressionValueIsNotNull(ofbx4, "vec3()");
        this._c = ofbx4;
        this._d = 0.99;
    }
}

