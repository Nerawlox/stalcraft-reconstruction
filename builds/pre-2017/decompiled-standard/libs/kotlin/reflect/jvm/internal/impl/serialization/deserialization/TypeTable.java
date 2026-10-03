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
import org.jetbrains.annotations.NotNull;

public final class TypeTable {
    @NotNull
    private final List<ProtoBuf.Type> types;

    @NotNull
    public final List<ProtoBuf.Type> getTypes() {
        return this.types;
    }

    @NotNull
    public final ProtoBuf.Type get(int index) {
        return this.types.get(index);
    }

    /*
     * WARNING - void declaration
     */
    public TypeTable(@NotNull ProtoBuf.TypeTable typeTable) {
        List list;
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        TypeTable typeTable2 = this;
        TypeTable typeTable3 = this;
        TypeTable $receiver = typeTable2;
        List originalTypes = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            void $receiver$iv$iv;
            Iterable $receiver$iv;
            int firstNullable = typeTable.getFirstNullable();
            Iterable iterable = $receiver$iv = (Iterable)typeTable.getTypeList();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $receiver$iv$iv) {
                void type2;
                void i;
                int n = index$iv$iv++;
                ProtoBuf.Type type3 = (ProtoBuf.Type)item$iv$iv;
                int n2 = n;
                Collection collection = destination$iv$iv;
                void var16_16 = i >= firstNullable ? type2.toBuilder().setNullable(true).build() : type2;
                collection.add(var16_16);
            }
            list = (List)destination$iv$iv;
        } else {
            List list2 = originalTypes;
            list = list2;
            Intrinsics.checkExpressionValueIsNotNull(list2, "originalTypes");
        }
        List list3 = list;
        typeTable3.types = list3;
    }
}

