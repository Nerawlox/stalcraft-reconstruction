/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class AnnotationsWithOnly
implements Annotations {
    @NotNull
    private final FqName presentAnnotation;

    @Override
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return CollectionsKt.emptyList().iterator();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean hasAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return Intrinsics.areEqual(fqName2, this.presentAnnotation);
    }

    @Override
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return null;
    }

    @Override
    @Nullable
    public AnnotationDescriptor findExternalAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return null;
    }

    @Override
    @NotNull
    public List<AnnotationWithTarget> getUseSiteTargetedAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public List<AnnotationWithTarget> getAllAnnotations() {
        return CollectionsKt.emptyList();
    }

    @NotNull
    public final FqName getPresentAnnotation() {
        return this.presentAnnotation;
    }

    public AnnotationsWithOnly(@NotNull FqName presentAnnotation) {
        Intrinsics.checkParameterIsNotNull(presentAnnotation, "presentAnnotation");
        this.presentAnnotation = presentAnnotation;
    }
}

