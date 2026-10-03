/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.builtins.BuiltInsProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltInsClassDataFinder
implements ClassDataFinder {
    private final Map<ClassId, ProtoBuf.Class> classIdToProto;
    private final NameResolver nameResolver;

    @NotNull
    public final Collection<ClassId> getAllClassIds$kotlin_core() {
        return this.classIdToProto.keySet();
    }

    @Override
    @Nullable
    public ClassDataWithSource findClassData(@NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        ProtoBuf.Class clazz = this.classIdToProto.get(classId);
        if (clazz == null) {
            return null;
        }
        ProtoBuf.Class classProto = clazz;
        ClassData classData = new ClassData(this.nameResolver, classProto);
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
        return new ClassDataWithSource(classData, sourceElement);
    }

    /*
     * WARNING - void declaration
     */
    public BuiltInsClassDataFinder(@NotNull BuiltInsProtoBuf.BuiltIns proto, @NotNull NameResolver nameResolver) {
        Map map2;
        void $receiver$iv$iv;
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        this.nameResolver = nameResolver;
        Iterable iterable = proto.getClass_List();
        BuiltInsClassDataFinder builtInsClassDataFinder = this;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
        void var6_6 = $receiver$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $receiver$iv$iv) {
            void klass;
            ProtoBuf.Class clazz = (ProtoBuf.Class)element$iv$iv;
            map2 = destination$iv$iv;
            ClassId classId = this.nameResolver.getClassId(klass.getFqName());
            map2.put(classId, element$iv$iv);
        }
        builtInsClassDataFinder.classIdToProto = map2 = destination$iv$iv;
    }
}

