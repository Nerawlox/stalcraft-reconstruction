/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FilteredAnnotations
implements Annotations {
    private final Annotations delegate;
    private final Function1<FqName, Boolean> fqNameFilter;

    @Override
    public boolean hasAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return this.fqNameFilter.invoke(fqName2) != false ? this.delegate.hasAnnotation(fqName2) : false;
    }

    @Override
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return this.fqNameFilter.invoke(fqName2) != false ? this.delegate.findAnnotation(fqName2) : null;
    }

    @Override
    @Nullable
    public AnnotationDescriptor findExternalAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return this.fqNameFilter.invoke(fqName2) != false ? this.delegate.findExternalAnnotation(fqName2) : null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<AnnotationWithTarget> getUseSiteTargetedAnnotations() {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)this.delegate.getUseSiteTargetedAnnotations();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            AnnotationWithTarget it = (AnnotationWithTarget)element$iv$iv;
            if (!this.shouldBeReturned(it.getAnnotation())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<AnnotationWithTarget> getAllAnnotations() {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)this.delegate.getAllAnnotations();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            AnnotationWithTarget it = (AnnotationWithTarget)element$iv$iv;
            if (!this.shouldBeReturned(it.getAnnotation())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)this.delegate;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            AnnotationDescriptor it = (AnnotationDescriptor)element$iv$iv;
            if (!this.shouldBeReturned(it)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return ((List)var3_3).iterator();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean shouldBeReturned(AnnotationDescriptor annotation) {
        ClassifierDescriptor descriptor2 = annotation.getType().getConstructor().getDeclarationDescriptor();
        if (descriptor2 == null) return false;
        FqNameUnsafe fqNameUnsafe = DescriptorUtils.getFqName(descriptor2);
        FqNameUnsafe fqName2 = fqNameUnsafe;
        if (!fqName2.isSafe()) return false;
        FqName fqName3 = fqName2.toSafe();
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "fqName.toSafe()");
        if (this.fqNameFilter.invoke(fqName3) == false) return false;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return !this.iterator().hasNext();
    }

    public FilteredAnnotations(@NotNull Annotations delegate, @NotNull Function1<? super FqName, Boolean> fqNameFilter) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        Intrinsics.checkParameterIsNotNull(fqNameFilter, "fqNameFilter");
        this.delegate = delegate;
        this.fqNameFilter = fqNameFilter;
    }
}

