/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialTypesKt {
    @Nullable
    public static final AbbreviatedType getAbbreviatedType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType = $receiver.unwrap();
        if (!(unwrappedType instanceof AbbreviatedType)) {
            unwrappedType = null;
        }
        return (AbbreviatedType)unwrappedType;
    }

    @Nullable
    public static final SimpleType getAbbreviation(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        AbbreviatedType abbreviatedType = SpecialTypesKt.getAbbreviatedType($receiver);
        return abbreviatedType != null ? abbreviatedType.getAbbreviation() : null;
    }

    @NotNull
    public static final SimpleType withAbbreviation(@NotNull SimpleType $receiver, @NotNull SimpleType abbreviatedType) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(abbreviatedType, "abbreviatedType");
        if ($receiver.isError()) {
            return $receiver;
        }
        return new AbbreviatedType($receiver, abbreviatedType);
    }
}

