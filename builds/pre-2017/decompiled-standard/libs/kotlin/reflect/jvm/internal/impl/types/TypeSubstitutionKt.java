/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public final class TypeSubstitutionKt {
    @JvmOverloads
    @NotNull
    public static final KotlinType replace(@NotNull KotlinType $receiver, @NotNull List<? extends TypeProjection> newArguments2, @NotNull Annotations newAnnotations) {
        KotlinType kotlinType;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(newArguments2, "newArguments");
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        if (newArguments2.isEmpty() && newAnnotations == $receiver.getAnnotations()) {
            return $receiver;
        }
        UnwrappedType unwrapped = $receiver.unwrap();
        UnwrappedType unwrappedType = unwrapped;
        if (unwrappedType instanceof FlexibleType) {
            kotlinType = KotlinTypeFactory.flexibleType(TypeSubstitutionKt.replace(((FlexibleType)unwrapped).getLowerBound(), newArguments2, newAnnotations), TypeSubstitutionKt.replace(((FlexibleType)unwrapped).getUpperBound(), newArguments2, newAnnotations));
        } else if (unwrappedType instanceof SimpleType) {
            kotlinType = TypeSubstitutionKt.replace((SimpleType)unwrapped, newArguments2, newAnnotations);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return kotlinType;
    }

    @JvmOverloads
    @NotNull
    public static /* bridge */ /* synthetic */ KotlinType replace$default(KotlinType kotlinType, List list, Annotations annotations2, int n, Object object) {
        if ((n & 1) != 0) {
            list = kotlinType.getArguments();
        }
        if ((n & 2) != 0) {
            annotations2 = kotlinType.getAnnotations();
        }
        return TypeSubstitutionKt.replace(kotlinType, list, annotations2);
    }

    @JvmOverloads
    @NotNull
    public static final KotlinType replace(@NotNull KotlinType $receiver, @NotNull List<? extends TypeProjection> newArguments2) {
        return TypeSubstitutionKt.replace$default($receiver, newArguments2, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public static final KotlinType replace(@NotNull KotlinType $receiver) {
        return TypeSubstitutionKt.replace$default($receiver, null, null, 3, null);
    }

    @JvmOverloads
    @NotNull
    public static final SimpleType replace(@NotNull SimpleType $receiver, @NotNull List<? extends TypeProjection> newArguments2, @NotNull Annotations newAnnotations) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(newArguments2, "newArguments");
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        if (newArguments2.isEmpty() && newAnnotations == $receiver.getAnnotations()) {
            return $receiver;
        }
        if (newArguments2.isEmpty()) {
            return KotlinTypeFactory.simpleType(newAnnotations, $receiver.getConstructor(), $receiver.getArguments(), $receiver.isMarkedNullable(), $receiver.getMemberScope());
        }
        return KotlinTypeFactory.simpleType$default(newAnnotations, $receiver.getConstructor(), newArguments2, $receiver.isMarkedNullable(), null, 16, null);
    }

    @JvmOverloads
    @NotNull
    public static /* bridge */ /* synthetic */ SimpleType replace$default(SimpleType simpleType2, List list, Annotations annotations2, int n, Object object) {
        if ((n & 1) != 0) {
            list = simpleType2.getArguments();
        }
        if ((n & 2) != 0) {
            annotations2 = simpleType2.getAnnotations();
        }
        return TypeSubstitutionKt.replace(simpleType2, list, annotations2);
    }

    @JvmOverloads
    @NotNull
    public static final SimpleType replace(@NotNull SimpleType $receiver, @NotNull List<? extends TypeProjection> newArguments2) {
        return TypeSubstitutionKt.replace$default($receiver, newArguments2, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public static final SimpleType replace(@NotNull SimpleType $receiver) {
        return TypeSubstitutionKt.replace$default($receiver, null, null, 3, null);
    }

    @NotNull
    public static final SimpleType asSimpleType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType = $receiver.unwrap();
        if (!(unwrappedType instanceof SimpleType)) {
            unwrappedType = null;
        }
        SimpleType simpleType2 = (SimpleType)unwrappedType;
        if (simpleType2 == null) {
            String string = "This is should be simple type: " + $receiver;
            throw (Throwable)new IllegalStateException(string.toString());
        }
        return simpleType2;
    }
}

