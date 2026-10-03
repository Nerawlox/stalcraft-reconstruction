/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnnotationAndConstantLoaderImpl
implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>, AnnotationWithTarget> {
    private final AnnotationDeserializer deserializer;
    private final SerializerExtensionProtocol protocol;

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<AnnotationDescriptor> loadClassAnnotations(@NotNull ProtoContainer.Class container) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(container, "container");
        List<ProtoBuf.Annotation> list = container.getClassProto().getExtension(this.protocol.getClassAnnotation());
        List<ProtoBuf.Annotation> list2 = list;
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> annotations2 = list2;
        Iterable iterable = $receiver$iv = (Iterable)annotations2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void proto;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            AnnotationDescriptor annotationDescriptor = this.deserializer.deserializeAnnotation((ProtoBuf.Annotation)proto, container.getNameResolver());
            collection.add(annotationDescriptor);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<AnnotationWithTarget> loadCallableAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite proto, @NotNull AnnotatedCallableKind kind) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        List list;
        List<ProtoBuf.Annotation> list2;
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        List list3 = proto;
        if (list3 instanceof ProtoBuf.Constructor) {
            list2 = ((ProtoBuf.Constructor)proto).getExtension(this.protocol.getConstructorAnnotation());
        } else if (list3 instanceof ProtoBuf.Function) {
            list2 = ((ProtoBuf.Function)proto).getExtension(this.protocol.getFunctionAnnotation());
        } else if (list3 instanceof ProtoBuf.Property) {
            list2 = ((ProtoBuf.Property)proto).getExtension(this.protocol.getPropertyAnnotation());
        } else {
            String string = "Unknown message: " + proto;
            throw (Throwable)new IllegalStateException(string.toString());
        }
        if ((list = (list3 = list2)) == null) {
            list = CollectionsKt.emptyList();
        }
        List annotations2 = list;
        Iterable iterable = $receiver$iv = (Iterable)annotations2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void proto2;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            AnnotationWithTarget annotationWithTarget = new AnnotationWithTarget(this.deserializer.deserializeAnnotation((ProtoBuf.Annotation)proto2, container.getNameResolver()), null);
            collection.add(annotationWithTarget);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.EnumEntry proto) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        List<ProtoBuf.Annotation> list = proto.getExtension(this.protocol.getEnumEntryAnnotation());
        List<ProtoBuf.Annotation> list2 = list;
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> annotations2 = list2;
        Iterable iterable = $receiver$iv = (Iterable)annotations2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void proto2;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            AnnotationDescriptor annotationDescriptor = this.deserializer.deserializeAnnotation((ProtoBuf.Annotation)proto2, container.getNameResolver());
            collection.add(annotationDescriptor);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<AnnotationDescriptor> loadValueParameterAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite callableProto, @NotNull AnnotatedCallableKind kind, int parameterIndex, @NotNull ProtoBuf.ValueParameter proto) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(callableProto, "callableProto");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        List<ProtoBuf.Annotation> list = proto.getExtension(this.protocol.getParameterAnnotation());
        List<ProtoBuf.Annotation> list2 = list;
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> annotations2 = list2;
        Iterable iterable = $receiver$iv = (Iterable)annotations2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void proto2;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            AnnotationDescriptor annotationDescriptor = this.deserializer.deserializeAnnotation((ProtoBuf.Annotation)proto2, container.getNameResolver());
            collection.add(annotationDescriptor);
        }
        return (List)destination$iv$iv;
    }

    @Override
    @NotNull
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite proto, @NotNull AnnotatedCallableKind kind) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        return CollectionsKt.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<AnnotationDescriptor> loadTypeAnnotations(@NotNull ProtoBuf.Type proto, @NotNull NameResolver nameResolver) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        List<ProtoBuf.Annotation> list = proto.getExtension(this.protocol.getTypeAnnotation());
        List<ProtoBuf.Annotation> list2 = list;
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        Iterable iterable = $receiver$iv = (Iterable)list2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            AnnotationDescriptor annotationDescriptor = this.deserializer.deserializeAnnotation((ProtoBuf.Annotation)it, nameResolver);
            collection.add(annotationDescriptor);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter proto, @NotNull NameResolver nameResolver) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        List<ProtoBuf.Annotation> list = proto.getExtension(this.protocol.getTypeParameterAnnotation());
        List<ProtoBuf.Annotation> list2 = list;
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        Iterable iterable = $receiver$iv = (Iterable)list2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            AnnotationDescriptor annotationDescriptor = this.deserializer.deserializeAnnotation((ProtoBuf.Annotation)it, nameResolver);
            collection.add(annotationDescriptor);
        }
        return (List)destination$iv$iv;
    }

    @Override
    @Nullable
    public ConstantValue<?> loadPropertyConstant(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto, @NotNull KotlinType expectedType) {
        ProtoBuf.Annotation.Argument.Value value;
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(expectedType, "expectedType");
        if (!proto.hasExtension(this.protocol.getCompileTimeValue())) {
            return null;
        }
        ProtoBuf.Annotation.Argument.Value value2 = value = proto.getExtension(this.protocol.getCompileTimeValue());
        Intrinsics.checkExpressionValueIsNotNull(value2, "value");
        return this.deserializer.resolveValue(expectedType, value2, container.getNameResolver());
    }

    public AnnotationAndConstantLoaderImpl(@NotNull ModuleDescriptor module, @NotNull NotFoundClasses notFoundClasses, @NotNull SerializerExtensionProtocol protocol) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(notFoundClasses, "notFoundClasses");
        Intrinsics.checkParameterIsNotNull(protocol, "protocol");
        this.protocol = protocol;
        this.deserializer = new AnnotationDeserializer(module, notFoundClasses);
    }
}

