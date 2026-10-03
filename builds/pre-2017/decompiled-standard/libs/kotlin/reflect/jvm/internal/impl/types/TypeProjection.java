/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public interface TypeProjection {
    @NotNull
    public Variance getProjectionKind();

    @NotNull
    public KotlinType getType();

    public boolean isStarProjection();
}

