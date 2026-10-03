/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeQualifiers {
    @Nullable
    private final NullabilityQualifier nullability;
    @Nullable
    private final MutabilityQualifier mutability;
    private final boolean isNotNullTypeParameter;
    @NotNull
    private static final JavaTypeQualifiers NONE;
    public static final Companion Companion;

    @Nullable
    public final NullabilityQualifier getNullability() {
        return this.nullability;
    }

    @Nullable
    public final MutabilityQualifier getMutability() {
        return this.mutability;
    }

    public final boolean isNotNullTypeParameter$kotlin_core() {
        return this.isNotNullTypeParameter;
    }

    public JavaTypeQualifiers(@Nullable NullabilityQualifier nullability, @Nullable MutabilityQualifier mutability, boolean isNotNullTypeParameter) {
        this.nullability = nullability;
        this.mutability = mutability;
        this.isNotNullTypeParameter = isNotNullTypeParameter;
    }

    static {
        Companion = new Companion(null);
        NONE = new JavaTypeQualifiers(null, null, false);
    }

    public static final class Companion {
        @NotNull
        public final JavaTypeQualifiers getNONE() {
            return NONE;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

