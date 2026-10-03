/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class CompanionObjectMapping {
    private static final LinkedHashSet<ClassId> classIds;
    public static final CompanionObjectMapping INSTANCE;

    @NotNull
    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        Set<ClassId> set = Collections.unmodifiableSet((Set)classIds);
        Intrinsics.checkExpressionValueIsNotNull(set, "Collections.unmodifiableSet(classIds)");
        return set;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isMappedIntrinsicCompanionObject(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
        if (!DescriptorUtils.isCompanionObject(classDescriptor)) return false;
        ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
        if (!CollectionsKt.contains((Iterable)classIds, classId != null ? classId.getOuterClassId() : null)) return false;
        return true;
    }

    /*
     * WARNING - void declaration
     */
    private CompanionObjectMapping() {
        Iterator iterator2;
        Object object;
        Collection collection;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        INSTANCE = this;
        Iterable iterable = $receiver$iv = (Iterable)PrimitiveType.NUMBER_TYPES;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void p1;
            PrimitiveType primitiveType = (PrimitiveType)((Object)item$iv$iv);
            collection = destination$iv$iv;
            object = KotlinBuiltIns.getPrimitiveFqName((PrimitiveType)p1);
            collection.add(object);
        }
        $receiver$iv = CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)((List)((Object)iterator2)), KotlinBuiltIns.FQ_NAMES.string.toSafe()), KotlinBuiltIns.FQ_NAMES._enum.toSafe());
        Collection destination$iv = new LinkedHashSet();
        for (Object item$iv : $receiver$iv) {
            void p1;
            Object item$iv$iv;
            item$iv$iv = (FqName)item$iv;
            collection = destination$iv;
            object = ClassId.topLevel((FqName)p1);
            collection.add(object);
        }
        classIds = (LinkedHashSet)iterable;
    }

    static {
        new CompanionObjectMapping();
    }
}

