/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public final class AnnotationsKt {
    public static final boolean checkAnnotationName(@NotNull AnnotationDescriptor annotation, @NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(annotation, "annotation");
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        ClassifierDescriptor descriptor2 = annotation.getType().getConstructor().getDeclarationDescriptor();
        return descriptor2 instanceof ClassDescriptor && Intrinsics.areEqual(fqName2.toUnsafe(), DescriptorUtils.getFqName(descriptor2));
    }

    @NotNull
    public static final Annotations composeAnnotations(@NotNull Annotations first, @NotNull Annotations second) {
        Intrinsics.checkParameterIsNotNull(first, "first");
        Intrinsics.checkParameterIsNotNull(second, "second");
        return first.isEmpty() ? second : (second.isEmpty() ? first : (Annotations)new CompositeAnnotations(first, second));
    }
}

