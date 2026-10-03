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
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.Deserialization;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotationsWithPossibleTargets;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class DeserializedTypeParameterDescriptor
extends AbstractLazyTypeParameterDescriptor {
    @NotNull
    private final DeserializedAnnotationsWithPossibleTargets annotations;
    private final DeserializationContext c;
    private final ProtoBuf.TypeParameter proto;

    @Override
    @NotNull
    public DeserializedAnnotationsWithPossibleTargets getAnnotations() {
        return this.annotations;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    protected List<KotlinType> resolveUpperBounds() {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        List<ProtoBuf.Type> upperBounds2 = ProtoTypeTableUtilKt.upperBounds(this.proto, this.c.getTypeTable());
        if (upperBounds2.isEmpty()) {
            return CollectionsKt.listOf(DescriptorUtilsKt.getBuiltIns(this).getDefaultBound());
        }
        Iterable iterable = $receiver$iv = (Iterable)upperBounds2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            ProtoBuf.Type type2 = (ProtoBuf.Type)item$iv$iv;
            Collection collection = destination$iv$iv;
            KotlinType kotlinType = this.c.getTypeDeserializer().type((ProtoBuf.Type)it, Annotations.Companion.getEMPTY());
            collection.add(kotlinType);
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    protected Void reportSupertypeLoopError(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        throw (Throwable)new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }

    public DeserializedTypeParameterDescriptor(@NotNull DeserializationContext c, @NotNull ProtoBuf.TypeParameter proto, int index) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        StorageManager storageManager = c.getStorageManager();
        DeclarationDescriptor declarationDescriptor = c.getContainingDeclaration();
        Name name2 = c.getNameResolver().getName(proto.getName());
        ProtoBuf.TypeParameter.Variance variance = proto.getVariance();
        Intrinsics.checkExpressionValueIsNotNull(variance, "proto.variance");
        super(storageManager, declarationDescriptor, name2, Deserialization.variance(variance), proto.getReified(), index, SourceElement.NO_SOURCE, SupertypeLoopChecker.EMPTY.INSTANCE);
        this.c = c;
        this.proto = proto;
        this.annotations = new DeserializedAnnotationsWithPossibleTargets(this.c.getStorageManager(), (Function0<? extends List<AnnotationWithTarget>>)new Function0<List<? extends AnnotationWithTarget>>(this){
            final /* synthetic */ DeserializedTypeParameterDescriptor this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<AnnotationWithTarget> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv = DeserializedTypeParameterDescriptor.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(DeserializedTypeParameterDescriptor.access$getProto$p(this.this$0), DeserializedTypeParameterDescriptor.access$getC$p(this.this$0).getNameResolver());
                Iterable iterable = $receiver$iv;
                Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (T item$iv$iv : $receiver$iv$iv) {
                    void it;
                    AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    AnnotationWithTarget annotationWithTarget = new AnnotationWithTarget((AnnotationDescriptor)it, null);
                    collection.add(annotationWithTarget);
                }
                return (List)var3_3;
            }
            {
                this.this$0 = deserializedTypeParameterDescriptor;
                super(0);
            }
        });
    }

    @NotNull
    public static final /* synthetic */ DeserializationContext access$getC$p(DeserializedTypeParameterDescriptor $this) {
        return $this.c;
    }

    @NotNull
    public static final /* synthetic */ ProtoBuf.TypeParameter access$getProto$p(DeserializedTypeParameterDescriptor $this) {
        return $this.proto;
    }
}

