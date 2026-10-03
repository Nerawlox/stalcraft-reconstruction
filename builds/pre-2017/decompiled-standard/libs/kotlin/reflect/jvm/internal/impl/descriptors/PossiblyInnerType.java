/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PossiblyInnerType {
    @NotNull
    private final ClassifierDescriptorWithTypeParameters classifierDescriptor;
    @NotNull
    private final List<TypeProjection> arguments;
    @Nullable
    private final PossiblyInnerType outerType;

    @NotNull
    public final ClassDescriptor getClassDescriptor() {
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = this.classifierDescriptor;
        if (classifierDescriptorWithTypeParameters == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        return (ClassDescriptor)classifierDescriptorWithTypeParameters;
    }

    @NotNull
    public final List<PossiblyInnerType> segments() {
        PossiblyInnerType possiblyInnerType = this.outerType;
        List<PossiblyInnerType> list = possiblyInnerType != null ? possiblyInnerType.segments() : null;
        List<PossiblyInnerType> list2 = list;
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        return CollectionsKt.plus((Collection)list2, this);
    }

    @NotNull
    public final ClassifierDescriptorWithTypeParameters getClassifierDescriptor() {
        return this.classifierDescriptor;
    }

    @NotNull
    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Nullable
    public final PossiblyInnerType getOuterType() {
        return this.outerType;
    }

    public PossiblyInnerType(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptor, @NotNull List<? extends TypeProjection> arguments2, @Nullable PossiblyInnerType outerType) {
        Intrinsics.checkParameterIsNotNull(classifierDescriptor, "classifierDescriptor");
        Intrinsics.checkParameterIsNotNull(arguments2, "arguments");
        this.classifierDescriptor = classifierDescriptor;
        this.arguments = arguments2;
        this.outerType = outerType;
    }
}

