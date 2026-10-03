/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AnnotationAndConstantLoader<A, C, T> {
    @NotNull
    public List<A> loadClassAnnotations(@NotNull ProtoContainer.Class var1);

    @NotNull
    public List<T> loadCallableAnnotations(@NotNull ProtoContainer var1, @NotNull MessageLite var2, @NotNull AnnotatedCallableKind var3);

    @NotNull
    public List<A> loadEnumEntryAnnotations(@NotNull ProtoContainer var1, @NotNull ProtoBuf.EnumEntry var2);

    @NotNull
    public List<A> loadValueParameterAnnotations(@NotNull ProtoContainer var1, @NotNull MessageLite var2, @NotNull AnnotatedCallableKind var3, int var4, @NotNull ProtoBuf.ValueParameter var5);

    @NotNull
    public List<A> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer var1, @NotNull MessageLite var2, @NotNull AnnotatedCallableKind var3);

    @NotNull
    public List<A> loadTypeAnnotations(@NotNull ProtoBuf.Type var1, @NotNull NameResolver var2);

    @NotNull
    public List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter var1, @NotNull NameResolver var2);

    @Nullable
    public C loadPropertyConstant(@NotNull ProtoContainer var1, @NotNull ProtoBuf.Property var2, @NotNull KotlinType var3);
}

