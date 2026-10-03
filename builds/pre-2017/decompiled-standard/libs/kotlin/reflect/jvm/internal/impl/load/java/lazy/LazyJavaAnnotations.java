/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaAnnotations
implements Annotations {
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> annotationDescriptors;
    private final LazyJavaResolverContext c;
    private final JavaAnnotationOwner annotationOwner;

    @Override
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName2) {
        JavaAnnotation javaAnnotation;
        Function1 function1;
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Object object = this.annotationOwner.findAnnotation(fqName2);
        if (object == null || (object = (AnnotationDescriptor)(function1 = (Function1)this.annotationDescriptors).invoke(javaAnnotation = object)) == null) {
            object = JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(fqName2, this.annotationOwner, this.c);
        }
        return object;
    }

    @Override
    @Nullable
    public AnnotationDescriptor findExternalAnnotation(@NotNull FqName fqName2) {
        AnnotationDescriptor annotationDescriptor;
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        JavaAnnotation javaAnnotation = this.c.getComponents().getExternalAnnotationResolver().findExternalAnnotation(this.annotationOwner, fqName2);
        if (javaAnnotation != null) {
            JavaAnnotation javaAnnotation2 = javaAnnotation;
            Function1 function1 = this.annotationDescriptors;
            annotationDescriptor = (AnnotationDescriptor)function1.invoke(javaAnnotation2);
        } else {
            annotationDescriptor = null;
        }
        return annotationDescriptor;
    }

    @Override
    @NotNull
    public List<AnnotationWithTarget> getUseSiteTargetedAnnotations() {
        return CollectionsKt.emptyList();
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
        Iterable iterable = $receiver$iv = (Iterable)this;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            AnnotationWithTarget annotationWithTarget = new AnnotationWithTarget((AnnotationDescriptor)it, null);
            collection.add(annotationWithTarget);
        }
        return (List)var3_3;
    }

    @Override
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        Sequence sequence = SequencesKt.map(CollectionsKt.asSequence((Iterable)this.annotationOwner.getAnnotations()), (Function1)this.annotationDescriptors);
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.deprecated;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.deprecated");
        return SequencesKt.filterNotNull(SequencesKt.plus(sequence, JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(fqName2, this.annotationOwner, this.c))).iterator();
    }

    @Override
    public boolean isEmpty() {
        return !this.iterator().hasNext();
    }

    public LazyJavaAnnotations(@NotNull LazyJavaResolverContext c, @NotNull JavaAnnotationOwner annotationOwner) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(annotationOwner, "annotationOwner");
        this.c = c;
        this.annotationOwner = annotationOwner;
        this.annotationDescriptors = this.c.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new Function1<JavaAnnotation, AnnotationDescriptor>(this){
            final /* synthetic */ LazyJavaAnnotations this$0;

            @Nullable
            public final AnnotationDescriptor invoke(@NotNull JavaAnnotation annotation) {
                Intrinsics.checkParameterIsNotNull(annotation, "annotation");
                return JavaAnnotationMapper.INSTANCE.mapOrResolveJavaAnnotation(annotation, LazyJavaAnnotations.access$getC$p(this.this$0));
            }
            {
                this.this$0 = lazyJavaAnnotations;
                super(1);
            }
        });
    }

    @Override
    public boolean hasAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return Annotations.DefaultImpls.hasAnnotation(this, fqName2);
    }

    @NotNull
    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaAnnotations $this) {
        return $this.c;
    }
}

