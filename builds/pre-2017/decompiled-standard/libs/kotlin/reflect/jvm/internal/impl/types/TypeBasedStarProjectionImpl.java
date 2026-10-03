/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class TypeBasedStarProjectionImpl
extends TypeProjectionBase {
    private final KotlinType _type;

    @Override
    public boolean isStarProjection() {
        return true;
    }

    @Override
    @NotNull
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override
    @NotNull
    public KotlinType getType() {
        return this._type;
    }

    public TypeBasedStarProjectionImpl(@NotNull KotlinType _type2) {
        Intrinsics.checkParameterIsNotNull(_type2, "_type");
        this._type = _type2;
    }
}

