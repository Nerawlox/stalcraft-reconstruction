/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CompositeAnnotations
implements Annotations {
    private final List<Annotations> delegates;

    @Override
    public boolean isEmpty() {
        boolean bl;
        block1: {
            Iterable $receiver$iv = this.delegates;
            for (Object element$iv : $receiver$iv) {
                Annotations it = (Annotations)element$iv;
                if (it.isEmpty()) continue;
                bl = false;
                break block1;
            }
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean hasAnnotation(@NotNull FqName fqName2) {
        boolean bl;
        block1: {
            Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
            Sequence $receiver$iv = CollectionsKt.asSequence((Iterable)this.delegates);
            Iterator iterator2 = $receiver$iv.iterator();
            while (iterator2.hasNext()) {
                Object element$iv = iterator2.next();
                Annotations it = (Annotations)element$iv;
                if (!it.hasAnnotation(fqName2)) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }

    @Override
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return (AnnotationDescriptor)SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable)this.delegates), (Function1)new Function1<Annotations, AnnotationDescriptor>(fqName2){
            final /* synthetic */ FqName $fqName;

            @Nullable
            public final AnnotationDescriptor invoke(@NotNull Annotations it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.findAnnotation(this.$fqName);
            }
            {
                this.$fqName = fqName2;
                super(1);
            }
        }));
    }

    @Override
    @Nullable
    public AnnotationDescriptor findExternalAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return (AnnotationDescriptor)SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable)this.delegates), (Function1)new Function1<Annotations, AnnotationDescriptor>(fqName2){
            final /* synthetic */ FqName $fqName;

            @Nullable
            public final AnnotationDescriptor invoke(@NotNull Annotations it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.findExternalAnnotation(this.$fqName);
            }
            {
                this.$fqName = fqName2;
                super(1);
            }
        }));
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
        Iterable iterable = $receiver$iv = (Iterable)this.delegates;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            Annotations it = (Annotations)element$iv$iv;
            Iterable list$iv$iv = it.getUseSiteTargetedAnnotations();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
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
        Iterable iterable = $receiver$iv = (Iterable)this.delegates;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            Annotations it = (Annotations)element$iv$iv;
            Iterable list$iv$iv = it.getAllAnnotations();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)var3_3;
    }

    @Override
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.flatMap(CollectionsKt.asSequence((Iterable)this.delegates), iterator.1.INSTANCE).iterator();
    }

    public CompositeAnnotations(@NotNull List<? extends Annotations> delegates) {
        Intrinsics.checkParameterIsNotNull(delegates, "delegates");
        this.delegates = delegates;
    }

    public CompositeAnnotations(Annotations ... delegates) {
        Intrinsics.checkParameterIsNotNull(delegates, "delegates");
        this(ArraysKt.toList((Object[])delegates));
    }
}

