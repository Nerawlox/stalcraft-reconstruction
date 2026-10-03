/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotationsWithPossibleTargets;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class DeserializedAnnotations
extends DeserializedAnnotationsWithPossibleTargets {
    public DeserializedAnnotations(@NotNull StorageManager storageManager, final @NotNull Function0<? extends List<? extends AnnotationDescriptor>> compute) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(compute, "compute");
        super(storageManager, (Function0<? extends List<AnnotationWithTarget>>)new Function0<List<? extends AnnotationWithTarget>>(){

            /*
             * WARNING - void declaration
             */
            @Override
            @NotNull
            public final List<AnnotationWithTarget> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)compute.invoke();
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
        });
    }
}

