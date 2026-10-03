/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProtoTypeTableUtilKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ProtoBuf.Type> supertypes(@NotNull ProtoBuf.Class $receiver, @NotNull TypeTable typeTable) {
        Collection collection;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        Collection $receiver$iv = $receiver.getSupertypeList();
        if ($receiver$iv.isEmpty()) {
            void $receiver$iv$iv;
            Iterable $receiver$iv2;
            Iterable iterable = $receiver$iv2 = (Iterable)$receiver.getSupertypeIdList();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void it;
                Integer n = (Integer)item$iv$iv;
                Collection collection2 = destination$iv$iv;
                void v0 = it;
                Intrinsics.checkExpressionValueIsNotNull(v0, "it");
                ProtoBuf.Type type2 = typeTable.get(v0.intValue());
                collection2.add(type2);
            }
            collection = (List)destination$iv$iv;
        } else {
            void var2_2;
            collection = var2_2;
        }
        Intrinsics.checkExpressionValueIsNotNull(collection, "supertypeList.ifEmpty { \u2026t.map { typeTable[it] } }");
        return (List)collection;
    }

    @Nullable
    public static final ProtoBuf.Type type(@NotNull ProtoBuf.Type.Argument $receiver, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        return $receiver.hasType() ? $receiver.getType() : ($receiver.hasTypeId() ? typeTable.get($receiver.getTypeId()) : null);
    }

    @Nullable
    public static final ProtoBuf.Type flexibleUpperBound(@NotNull ProtoBuf.Type $receiver, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        return $receiver.hasFlexibleUpperBound() ? $receiver.getFlexibleUpperBound() : ($receiver.hasFlexibleUpperBoundId() ? typeTable.get($receiver.getFlexibleUpperBoundId()) : null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ProtoBuf.Type> upperBounds(@NotNull ProtoBuf.TypeParameter $receiver, @NotNull TypeTable typeTable) {
        Collection collection;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        Collection $receiver$iv = $receiver.getUpperBoundList();
        if ($receiver$iv.isEmpty()) {
            void $receiver$iv$iv;
            Iterable $receiver$iv2;
            Iterable iterable = $receiver$iv2 = (Iterable)$receiver.getUpperBoundIdList();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void it;
                Integer n = (Integer)item$iv$iv;
                Collection collection2 = destination$iv$iv;
                void v0 = it;
                Intrinsics.checkExpressionValueIsNotNull(v0, "it");
                ProtoBuf.Type type2 = typeTable.get(v0.intValue());
                collection2.add(type2);
            }
            collection = (List)destination$iv$iv;
        } else {
            void var2_2;
            collection = var2_2;
        }
        Intrinsics.checkExpressionValueIsNotNull(collection, "upperBoundList.ifEmpty {\u2026t.map { typeTable[it] } }");
        return (List)collection;
    }

    @NotNull
    public static final ProtoBuf.Type returnType(@NotNull ProtoBuf.Function $receiver, @NotNull TypeTable typeTable) {
        ProtoBuf.Type type2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if ($receiver.hasReturnType()) {
            ProtoBuf.Type type3 = $receiver.getReturnType();
            type2 = type3;
            Intrinsics.checkExpressionValueIsNotNull(type3, "returnType");
        } else {
            type2 = typeTable.get($receiver.getReturnTypeId());
        }
        return type2;
    }

    public static final boolean hasReceiver(@NotNull ProtoBuf.Function $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.hasReceiverType() || $receiver.hasReceiverTypeId();
    }

    @Nullable
    public static final ProtoBuf.Type receiverType(@NotNull ProtoBuf.Function $receiver, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        return $receiver.hasReceiverType() ? $receiver.getReceiverType() : ($receiver.hasReceiverTypeId() ? typeTable.get($receiver.getReceiverTypeId()) : null);
    }

    @NotNull
    public static final ProtoBuf.Type returnType(@NotNull ProtoBuf.Property $receiver, @NotNull TypeTable typeTable) {
        ProtoBuf.Type type2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if ($receiver.hasReturnType()) {
            ProtoBuf.Type type3 = $receiver.getReturnType();
            type2 = type3;
            Intrinsics.checkExpressionValueIsNotNull(type3, "returnType");
        } else {
            type2 = typeTable.get($receiver.getReturnTypeId());
        }
        return type2;
    }

    public static final boolean hasReceiver(@NotNull ProtoBuf.Property $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.hasReceiverType() || $receiver.hasReceiverTypeId();
    }

    @Nullable
    public static final ProtoBuf.Type receiverType(@NotNull ProtoBuf.Property $receiver, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        return $receiver.hasReceiverType() ? $receiver.getReceiverType() : ($receiver.hasReceiverTypeId() ? typeTable.get($receiver.getReceiverTypeId()) : null);
    }

    @NotNull
    public static final ProtoBuf.Type type(@NotNull ProtoBuf.ValueParameter $receiver, @NotNull TypeTable typeTable) {
        ProtoBuf.Type type2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if ($receiver.hasType()) {
            ProtoBuf.Type type3 = $receiver.getType();
            type2 = type3;
            Intrinsics.checkExpressionValueIsNotNull(type3, "type");
        } else {
            type2 = typeTable.get($receiver.getTypeId());
        }
        return type2;
    }

    @Nullable
    public static final ProtoBuf.Type varargElementType(@NotNull ProtoBuf.ValueParameter $receiver, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        return $receiver.hasVarargElementType() ? $receiver.getVarargElementType() : ($receiver.hasVarargElementTypeId() ? typeTable.get($receiver.getVarargElementTypeId()) : null);
    }

    @Nullable
    public static final ProtoBuf.Type outerType(@NotNull ProtoBuf.Type $receiver, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        return $receiver.hasOuterType() ? $receiver.getOuterType() : ($receiver.hasOuterTypeId() ? typeTable.get($receiver.getOuterTypeId()) : null);
    }

    @Nullable
    public static final ProtoBuf.Type abbreviatedType(@NotNull ProtoBuf.Type $receiver, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        return $receiver.hasAbbreviatedType() ? $receiver.getAbbreviatedType() : ($receiver.hasAbbreviatedTypeId() ? typeTable.get($receiver.getAbbreviatedTypeId()) : null);
    }

    @NotNull
    public static final ProtoBuf.Type underlyingType(@NotNull ProtoBuf.TypeAlias $receiver, @NotNull TypeTable typeTable) {
        ProtoBuf.Type type2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if ($receiver.hasUnderlyingTypeId()) {
            type2 = typeTable.get($receiver.getUnderlyingTypeId());
        } else {
            ProtoBuf.Type type3 = $receiver.getUnderlyingType();
            type2 = type3;
            Intrinsics.checkExpressionValueIsNotNull(type3, "underlyingType");
        }
        return type2;
    }

    @NotNull
    public static final ProtoBuf.Type expandedType(@NotNull ProtoBuf.TypeAlias $receiver, @NotNull TypeTable typeTable) {
        ProtoBuf.Type type2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if ($receiver.hasExpandedTypeId()) {
            type2 = typeTable.get($receiver.getExpandedTypeId());
        } else {
            ProtoBuf.Type type3 = $receiver.getExpandedType();
            type2 = type3;
            Intrinsics.checkExpressionValueIsNotNull(type3, "expandedType");
        }
        return type2;
    }
}

