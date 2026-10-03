/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public class TypeProjectionImpl
extends TypeProjectionBase {
    private final Variance projection;
    private final KotlinType type;

    public TypeProjectionImpl(@NotNull Variance projection, @NotNull KotlinType type2) {
        if (projection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "projection", "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl", "<init>"));
        }
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl", "<init>"));
        }
        this.projection = projection;
        this.type = type2;
    }

    public TypeProjectionImpl(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl", "<init>"));
        }
        this(Variance.INVARIANT, type2);
    }

    @Override
    @NotNull
    public Variance getProjectionKind() {
        Variance variance = this.projection;
        if (variance == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl", "getProjectionKind"));
        }
        return variance;
    }

    @Override
    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = this.type;
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl", "getType"));
        }
        return kotlinType;
    }

    @Override
    public boolean isStarProjection() {
        return false;
    }
}

