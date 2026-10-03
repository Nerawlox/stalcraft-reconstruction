/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotationsWithPossibleTargets;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DeserializedAnnotationsWithPossibleTargets
implements Annotations {
    private final NotNullLazyValue<List<AnnotationWithTarget>> annotations;

    @Override
    public boolean isEmpty() {
        return ((List)this.annotations.invoke()).isEmpty();
    }

    @Override
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName2) {
        Object v0;
        block1: {
            Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
            Iterable $receiver$iv = (Iterable)this.annotations.invoke();
            for (Object element$iv : $receiver$iv) {
                ClassifierDescriptor descriptor2;
                AnnotationWithTarget annotationWithTarget = (AnnotationWithTarget)element$iv;
                if (!(annotationWithTarget.getTarget() != null ? false : (descriptor2 = annotationWithTarget.getAnnotation().getType().getConstructor().getDeclarationDescriptor()) instanceof ClassDescriptor && Intrinsics.areEqual(fqName2.toUnsafe(), DescriptorUtils.getFqName(descriptor2)))) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        AnnotationWithTarget annotationWithTarget = v0;
        return annotationWithTarget != null ? annotationWithTarget.getAnnotation() : null;
    }

    @Nullable
    public Void findExternalAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return null;
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
        Iterable iterable = $receiver$iv = (Iterable)this.annotations.invoke();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            AnnotationWithTarget it = (AnnotationWithTarget)element$iv$iv;
            if (!(it.getTarget() != null)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @Override
    @NotNull
    public List<AnnotationWithTarget> getAllAnnotations() {
        return (List)this.annotations.invoke();
    }

    @Override
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.annotations.invoke()), iterator.1.INSTANCE), iterator.2.INSTANCE).iterator();
    }

    public DeserializedAnnotationsWithPossibleTargets(@NotNull StorageManager storageManager, @NotNull Function0<? extends List<AnnotationWithTarget>> compute) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(compute, "compute");
        this.annotations = storageManager.createLazyValue((Function0)new Function0<List<? extends AnnotationWithTarget>>(compute){
            final /* synthetic */ Function0 $compute;

            @NotNull
            public final List<AnnotationWithTarget> invoke() {
                return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((Collection)this.$compute.invoke());
            }
            {
                this.$compute = function0;
                super(0);
            }
        });
    }

    @Override
    public boolean hasAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return Annotations.DefaultImpls.hasAnnotation(this, fqName2);
    }
}

