/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltinSpecialProperties {
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    private static final Set<FqName> SPECIAL_FQ_NAMES;
    @NotNull
    private static final Set<Name> SPECIAL_SHORT_NAMES;
    public static final BuiltinSpecialProperties INSTANCE;

    @NotNull
    public final Set<Name> getSPECIAL_SHORT_NAMES$kotlin_core() {
        return SPECIAL_SHORT_NAMES;
    }

    public final boolean hasBuiltinSpecialPropertyFqName(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "callableMemberDescriptor");
        if (SPECIAL_SHORT_NAMES.contains(callableMemberDescriptor.getName()) ^ true) {
            return false;
        }
        return this.hasBuiltinSpecialPropertyFqNameImpl(callableMemberDescriptor);
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(@NotNull CallableMemberDescriptor $receiver) {
        boolean bl;
        block3: {
            if (CollectionsKt.contains((Iterable)SPECIAL_FQ_NAMES, DescriptorUtilsKt.fqNameOrNull($receiver)) && $receiver.getValueParameters().isEmpty()) {
                return true;
            }
            if (!KotlinBuiltIns.isBuiltIn($receiver)) {
                return false;
            }
            Iterable $receiver$iv = $receiver.getOverriddenDescriptors();
            for (Object element$iv : $receiver$iv) {
                CallableMemberDescriptor it;
                CallableMemberDescriptor callableMemberDescriptor = it = (CallableMemberDescriptor)element$iv;
                Intrinsics.checkExpressionValueIsNotNull(callableMemberDescriptor, "it");
                if (!INSTANCE.hasBuiltinSpecialPropertyFqName(callableMemberDescriptor)) continue;
                bl = true;
                break block3;
            }
            bl = false;
        }
        return bl;
    }

    @NotNull
    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(@NotNull Name name1) {
        Intrinsics.checkParameterIsNotNull(name1, "name1");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name1);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    @Nullable
    public final String getBuiltinSpecialPropertyGetterName(@NotNull CallableMemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl = KotlinBuiltIns.isBuiltIn($receiver);
        if (_Assertions.ENABLED && !bl) {
            String string = "This method is defined only for builtin members, but " + $receiver + " found";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        CallableMemberDescriptor callableMemberDescriptor = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor($receiver), false, getBuiltinSpecialPropertyGetterName.descriptor.1.INSTANCE, 1, null);
        if (callableMemberDescriptor == null) {
            return null;
        }
        CallableMemberDescriptor descriptor2 = callableMemberDescriptor;
        Name name2 = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.get(DescriptorUtilsKt.getFqNameSafe(descriptor2));
        return name2 != null ? name2.asString() : null;
    }

    /*
     * WARNING - void declaration
     */
    private BuiltinSpecialProperties() {
        void var3_3;
        Object object;
        Object it;
        Object object2;
        Iterable $receiver$iv$iv;
        INSTANCE = this;
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = MapsKt.mapOf(TuplesKt.to(SpecialBuiltinMembers.access$childSafe(KotlinBuiltIns.FQ_NAMES._enum, "name"), Name.identifier("name")), TuplesKt.to(SpecialBuiltinMembers.access$childSafe(KotlinBuiltIns.FQ_NAMES._enum, "ordinal"), Name.identifier("ordinal")), TuplesKt.to(SpecialBuiltinMembers.access$child(KotlinBuiltIns.FQ_NAMES.collection, "size"), Name.identifier("size")), TuplesKt.to(SpecialBuiltinMembers.access$child(KotlinBuiltIns.FQ_NAMES.map, "size"), Name.identifier("size")), TuplesKt.to(SpecialBuiltinMembers.access$childSafe(KotlinBuiltIns.FQ_NAMES.charSequence, "length"), Name.identifier("length")), TuplesKt.to(SpecialBuiltinMembers.access$child(KotlinBuiltIns.FQ_NAMES.map, "keys"), Name.identifier("keySet")), TuplesKt.to(SpecialBuiltinMembers.access$child(KotlinBuiltIns.FQ_NAMES.map, "values"), Name.identifier("values")), TuplesKt.to(SpecialBuiltinMembers.access$child(KotlinBuiltIns.FQ_NAMES.map, "entries"), Name.identifier("entrySet")));
        Iterable $receiver$iv = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.entrySet();
        Iterable iterable = $receiver$iv;
        Object destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            Map.Entry entry = (Map.Entry)item$iv$iv;
            object2 = destination$iv$iv;
            object = new Pair(((FqName)it.getKey()).shortName(), it.getValue());
            object2.add(object);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new LinkedHashMap();
        Iterator iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object object3;
            Object $receiver$iv$iv$iv = destination$iv$iv;
            Object element$iv$iv = iterator2.next();
            it = (Pair)element$iv$iv;
            Name key$iv$iv = (Name)((Pair)it).getSecond();
            Object value$iv$iv$iv = $receiver$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                ArrayList answer$iv$iv$iv = new ArrayList();
                $receiver$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                object3 = answer$iv$iv$iv;
            } else {
                object3 = value$iv$iv$iv;
            }
            List list$iv$iv = (List)object3;
            it = (Pair)element$iv$iv;
            object2 = list$iv$iv;
            object = (Name)((Pair)it).getFirst();
            object2.add(object);
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = destination$iv$iv;
        SPECIAL_FQ_NAMES = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        $receiver$iv$iv = $receiver$iv = (Iterable)SPECIAL_FQ_NAMES;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            it = (FqName)item$iv$iv;
            object2 = destination$iv$iv;
            object = ((FqName)it).shortName();
            object2.add(object);
        }
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet((List)var3_3);
    }

    static {
        new BuiltinSpecialProperties();
    }
}

