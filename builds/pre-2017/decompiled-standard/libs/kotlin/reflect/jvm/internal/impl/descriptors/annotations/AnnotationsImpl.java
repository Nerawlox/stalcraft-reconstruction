/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnnotationsImpl
implements Annotations {
    private final List<AnnotationDescriptor> annotations;
    private final List<AnnotationWithTarget> targetedAnnotations;
    public static final Companion Companion = new Companion(null);

    @Override
    public boolean isEmpty() {
        return this.targetedAnnotations.isEmpty();
    }

    @Override
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName2) {
        Object v0;
        block1: {
            Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
            Iterable $receiver$iv = this.annotations;
            for (Object element$iv : $receiver$iv) {
                AnnotationDescriptor it = (AnnotationDescriptor)element$iv;
                ClassifierDescriptor descriptor2 = it.getType().getConstructor().getDeclarationDescriptor();
                if (!(descriptor2 instanceof ClassDescriptor && Intrinsics.areEqual(fqName2.toUnsafe(), DescriptorUtils.getFqName(descriptor2)))) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<AnnotationWithTarget> getUseSiteTargetedAnnotations() {
        void var3_3;
        AnnotationWithTarget it;
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv = this.targetedAnnotations;
        Iterable iterable = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            it = (AnnotationWithTarget)element$iv$iv;
            if (!(it.getTarget() != null)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            it = (AnnotationWithTarget)item$iv$iv;
            Collection collection = destination$iv$iv;
            AnnotationDescriptor annotationDescriptor = it.getAnnotation();
            AnnotationUseSiteTarget annotationUseSiteTarget = it.getTarget();
            if (annotationUseSiteTarget == null) {
                Intrinsics.throwNpe();
            }
            AnnotationWithTarget annotationWithTarget = new AnnotationWithTarget(annotationDescriptor, annotationUseSiteTarget);
            collection.add(annotationWithTarget);
        }
        return (List)var3_3;
    }

    @Override
    @NotNull
    public List<AnnotationWithTarget> getAllAnnotations() {
        return this.targetedAnnotations;
    }

    @Nullable
    public Void findExternalAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return null;
    }

    @Override
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return this.annotations.iterator();
    }

    @NotNull
    public String toString() {
        return this.annotations.toString();
    }

    /*
     * WARNING - void declaration
     */
    public AnnotationsImpl(@NotNull List<? extends AnnotationDescriptor> annotations2) {
        Collection<AnnotationWithTarget> collection;
        void $receiver$iv$iv;
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        this.annotations = annotations2;
        Iterable $receiver$iv = annotations2;
        AnnotationsImpl annotationsImpl = this;
        Iterable iterable = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor)item$iv$iv;
            collection = destination$iv$iv;
            AnnotationWithTarget annotationWithTarget = new AnnotationWithTarget((AnnotationDescriptor)it, null);
            collection.add(annotationWithTarget);
        }
        collection = (List)destination$iv$iv;
        annotationsImpl.targetedAnnotations = collection;
    }

    private AnnotationsImpl(List<AnnotationWithTarget> targetedAnnotations, int i) {
        AnnotationWithTarget it;
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        this.targetedAnnotations = targetedAnnotations;
        Iterable iterable = targetedAnnotations;
        AnnotationsImpl annotationsImpl = this;
        void var5_5 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            it = (AnnotationWithTarget)element$iv$iv;
            if (!(it.getTarget() == null)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Collection<AnnotationDescriptor> collection = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv = (Iterable)collection;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            it = (AnnotationWithTarget)item$iv$iv;
            collection = destination$iv$iv;
            AnnotationDescriptor annotationDescriptor = it.getAnnotation();
            collection.add(annotationDescriptor);
        }
        collection = (List)destination$iv$iv;
        annotationsImpl.annotations = collection;
    }

    @Override
    public boolean hasAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return Annotations.DefaultImpls.hasAnnotation(this, fqName2);
    }

    public /* synthetic */ AnnotationsImpl(@NotNull List targetedAnnotations, int i, DefaultConstructorMarker $constructor_marker) {
        this(targetedAnnotations, i);
    }

    @JvmStatic
    @NotNull
    public static final AnnotationsImpl create(@NotNull List<AnnotationWithTarget> annotationsWithTargets) {
        Intrinsics.checkParameterIsNotNull(annotationsWithTargets, "annotationsWithTargets");
        return Companion.create(annotationsWithTargets);
    }

    public static final class Companion {
        @JvmStatic
        @NotNull
        public final AnnotationsImpl create(@NotNull List<AnnotationWithTarget> annotationsWithTargets) {
            Intrinsics.checkParameterIsNotNull(annotationsWithTargets, "annotationsWithTargets");
            return new AnnotationsImpl(annotationsWithTargets, 0, null);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

