/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClassesKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NotFoundClassesKt {
    /*
     * WARNING - void declaration
     */
    private static final List<TypeParameterDescriptor> createTypeParameters(ClassifierDescriptor classifierDescriptor, int numberOfDeclaredTypeParameters) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)new IntRange(1, numberOfDeclaredTypeParameters);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        Iterator iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void index;
            int item$iv$iv;
            int n = item$iv$iv = ((IntIterator)iterator2).nextInt();
            Collection collection = destination$iv$iv;
            TypeParameterDescriptor typeParameterDescriptor = TypeParameterDescriptorImpl.createWithDefaultBound(classifierDescriptor, Annotations.Companion.getEMPTY(), false, Variance.INVARIANT, Name.identifier("T" + (int)index), (int)index);
            collection.add(typeParameterDescriptor);
        }
        return (List)destination$iv$iv;
    }

    private static final List<Integer> computeTypeParametersCount(ClassId classId, ProtoBuf.Type proto, TypeTable typeTable) {
        List<Integer> typeParametersCount2 = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence(proto, (Function1)new Function1<ProtoBuf.Type, ProtoBuf.Type>(typeTable){
            final /* synthetic */ TypeTable $typeTable;

            @Nullable
            public final ProtoBuf.Type invoke(@NotNull ProtoBuf.Type it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return ProtoTypeTableUtilKt.outerType(it, this.$typeTable);
            }
            {
                this.$typeTable = typeTable;
                super(1);
            }
        }), computeTypeParametersCount.typeParametersCount.2.INSTANCE));
        int classNestingLevel2 = SequencesKt.count(SequencesKt.generateSequence(classId, (Function1)computeTypeParametersCount.classNestingLevel.1.INSTANCE));
        while (typeParametersCount2.size() < classNestingLevel2) {
            typeParametersCount2.add(0);
        }
        return typeParametersCount2;
    }

    @NotNull
    public static final /* synthetic */ List access$createTypeParameters(@NotNull ClassifierDescriptor classifierDescriptor, int numberOfDeclaredTypeParameters) {
        return NotFoundClassesKt.createTypeParameters(classifierDescriptor, numberOfDeclaredTypeParameters);
    }

    @NotNull
    public static final /* synthetic */ List access$computeTypeParametersCount(@NotNull ClassId classId, @NotNull ProtoBuf.Type proto, @NotNull TypeTable typeTable) {
        return NotFoundClassesKt.computeTypeParametersCount(classId, proto, typeTable);
    }
}

