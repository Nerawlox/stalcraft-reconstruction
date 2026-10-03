/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TypeSubstitution {
    @JvmField
    @NotNull
    public static final TypeSubstitution EMPTY;
    public static final Companion Companion;

    @Nullable
    public abstract TypeProjection get(@NotNull KotlinType var1);

    @NotNull
    public KotlinType prepareTopLevelType(@NotNull KotlinType topLevelType, @NotNull Variance position) {
        Intrinsics.checkParameterIsNotNull(topLevelType, "topLevelType");
        Intrinsics.checkParameterIsNotNull((Object)position, "position");
        return topLevelType;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    @NotNull
    public Annotations filterAnnotations(@NotNull Annotations annotations2) {
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        return annotations2;
    }

    @NotNull
    public final TypeSubstitutor buildSubstitutor() {
        TypeSubstitutor typeSubstitutor2 = TypeSubstitutor.create(this);
        Intrinsics.checkExpressionValueIsNotNull(typeSubstitutor2, "TypeSubstitutor.create(this)");
        return typeSubstitutor2;
    }

    static {
        Companion = new Companion(null);
        EMPTY = new TypeSubstitution(){

            @Nullable
            public Void get(@NotNull KotlinType key) {
                Intrinsics.checkParameterIsNotNull(key, "key");
                return null;
            }

            public boolean isEmpty() {
                return true;
            }

            @NotNull
            public String toString() {
                return "Empty TypeSubstitution";
            }
        };
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

