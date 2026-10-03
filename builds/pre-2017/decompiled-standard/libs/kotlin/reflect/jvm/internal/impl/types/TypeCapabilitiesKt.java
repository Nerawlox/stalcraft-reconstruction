/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeCapabilitiesKt {
    public static final boolean isCustomTypeVariable(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType = $receiver.unwrap();
        if (!(unwrappedType instanceof CustomTypeVariable)) {
            unwrappedType = null;
        }
        CustomTypeVariable customTypeVariable = (CustomTypeVariable)((Object)unwrappedType);
        return customTypeVariable != null ? customTypeVariable.isTypeVariable() : false;
    }

    @Nullable
    public static final CustomTypeVariable getCustomTypeVariable(@NotNull KotlinType $receiver) {
        CustomTypeVariable customTypeVariable;
        CustomTypeVariable it;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType = $receiver.unwrap();
        if (!(unwrappedType instanceof CustomTypeVariable)) {
            unwrappedType = null;
        }
        CustomTypeVariable customTypeVariable2 = (CustomTypeVariable)((Object)unwrappedType);
        return customTypeVariable2 != null ? ((it = (customTypeVariable = customTypeVariable2)).isTypeVariable() ? it : null) : null;
    }

    @NotNull
    public static final KotlinType getSubtypeRepresentative(@NotNull KotlinType $receiver) {
        Object object;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType = $receiver.unwrap();
        if (!(unwrappedType instanceof SubtypingRepresentatives)) {
            unwrappedType = null;
        }
        if ((object = (SubtypingRepresentatives)((Object)unwrappedType)) == null || (object = object.getSubTypeRepresentative()) == null) {
            object = $receiver;
        }
        return object;
    }

    @NotNull
    public static final KotlinType getSupertypeRepresentative(@NotNull KotlinType $receiver) {
        Object object;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType = $receiver.unwrap();
        if (!(unwrappedType instanceof SubtypingRepresentatives)) {
            unwrappedType = null;
        }
        if ((object = (SubtypingRepresentatives)((Object)unwrappedType)) == null || (object = object.getSuperTypeRepresentative()) == null) {
            object = $receiver;
        }
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean sameTypeConstructors(@NotNull KotlinType first, @NotNull KotlinType second) {
        Intrinsics.checkParameterIsNotNull(first, "first");
        Intrinsics.checkParameterIsNotNull(second, "second");
        UnwrappedType unwrappedType = first.unwrap();
        if (!(unwrappedType instanceof SubtypingRepresentatives)) {
            unwrappedType = null;
        }
        SubtypingRepresentatives subtypingRepresentatives = (SubtypingRepresentatives)((Object)unwrappedType);
        if (subtypingRepresentatives != null ? subtypingRepresentatives.sameTypeConstructor(second) : false) return true;
        UnwrappedType unwrappedType2 = second.unwrap();
        if (!(unwrappedType2 instanceof SubtypingRepresentatives)) {
            unwrappedType2 = null;
        }
        SubtypingRepresentatives subtypingRepresentatives2 = (SubtypingRepresentatives)((Object)unwrappedType2);
        if (subtypingRepresentatives2 == null) return false;
        boolean bl = subtypingRepresentatives2.sameTypeConstructor(first);
        if (!bl) return false;
        return true;
    }
}

