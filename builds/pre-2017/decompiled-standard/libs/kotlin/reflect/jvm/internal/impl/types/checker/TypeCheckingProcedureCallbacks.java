/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
import org.jetbrains.annotations.NotNull;

public interface TypeCheckingProcedureCallbacks {
    public boolean assertEqualTypes(@NotNull KotlinType var1, @NotNull KotlinType var2, @NotNull TypeCheckingProcedure var3);

    public boolean assertEqualTypeConstructors(@NotNull TypeConstructor var1, @NotNull TypeConstructor var2);

    public boolean assertSubtype(@NotNull KotlinType var1, @NotNull KotlinType var2, @NotNull TypeCheckingProcedure var3);

    public boolean capture(@NotNull KotlinType var1, @NotNull TypeProjection var2);

    public boolean noCorrespondingSupertype(@NotNull KotlinType var1, @NotNull KotlinType var2);
}

