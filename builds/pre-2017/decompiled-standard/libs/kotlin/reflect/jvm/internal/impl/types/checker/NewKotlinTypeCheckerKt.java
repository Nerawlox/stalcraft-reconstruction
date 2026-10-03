/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import org.jetbrains.annotations.NotNull;

public final class NewKotlinTypeCheckerKt {
    private static final boolean isClassType(@NotNull SimpleType $receiver) {
        return $receiver.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor;
    }

    private static final boolean isSingleClassifierType(@NotNull SimpleType $receiver) {
        return !$receiver.isError() && !($receiver.getConstructor().getDeclarationDescriptor() instanceof TypeAliasDescriptor) && ($receiver.getConstructor().getDeclarationDescriptor() != null || $receiver instanceof CapturedType || $receiver instanceof NewCapturedType);
    }

    private static final boolean isIntersectionType(@NotNull SimpleType $receiver) {
        return $receiver.getConstructor() instanceof IntersectionTypeConstructor;
    }

    public static final /* synthetic */ boolean access$isClassType$p(@NotNull SimpleType $receiver) {
        return NewKotlinTypeCheckerKt.isClassType($receiver);
    }

    public static final /* synthetic */ boolean access$isSingleClassifierType$p(@NotNull SimpleType $receiver) {
        return NewKotlinTypeCheckerKt.isSingleClassifierType($receiver);
    }

    public static final /* synthetic */ boolean access$isIntersectionType$p(@NotNull SimpleType $receiver) {
        return NewKotlinTypeCheckerKt.isIntersectionType($receiver);
    }
}

