/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

public interface KotlinTypeChecker {
    public static final KotlinTypeChecker DEFAULT = NewKotlinTypeChecker.INSTANCE;

    public boolean isSubtypeOf(@NotNull KotlinType var1, @NotNull KotlinType var2);

    public boolean equalTypes(@NotNull KotlinType var1, @NotNull KotlinType var2);

    public static interface TypeConstructorEquality {
        public boolean equals(@NotNull TypeConstructor var1, @NotNull TypeConstructor var2);
    }
}

