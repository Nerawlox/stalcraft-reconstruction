/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.NameAndSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltinMethodsWithDifferentJvmName {
    private static final NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
    private static final Map<NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    private static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;
    @NotNull
    private static final List<Name> ORIGINAL_SHORT_NAMES;
    private static final Map<Name, List<Name>> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    public static final BuiltinMethodsWithDifferentJvmName INSTANCE;

    @NotNull
    public final List<Name> getORIGINAL_SHORT_NAMES() {
        return ORIGINAL_SHORT_NAMES;
    }

    public final boolean getSameAsRenamedInJvmBuiltin(@NotNull Name $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return ORIGINAL_SHORT_NAMES.contains($receiver);
    }

    @Nullable
    public final Name getJvmName(@NotNull SimpleFunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        String string = MethodSignatureMappingKt.computeJvmSignature(functionDescriptor);
        if (string == null) {
            return null;
        }
        return SIGNATURE_TO_JVM_REPRESENTATION_NAME.get(string);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(@NotNull SimpleFunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        return KotlinBuiltIns.isBuiltIn(functionDescriptor) && DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, new Function1<CallableMemberDescriptor, Boolean>(functionDescriptor){
            final /* synthetic */ SimpleFunctionDescriptor $functionDescriptor;

            public final boolean invoke(@NotNull CallableMemberDescriptor it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                Map map2 = BuiltinMethodsWithDifferentJvmName.access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$p(BuiltinMethodsWithDifferentJvmName.INSTANCE);
                String string = MethodSignatureMappingKt.computeJvmSignature(this.$functionDescriptor);
                Map map3 = map2;
                if (map3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                }
                return map3.containsKey(string);
            }
            {
                this.$functionDescriptor = simpleFunctionDescriptor;
                super(1);
            }
        }, 1, null) != null;
    }

    @NotNull
    public final List<Name> getBuiltinFunctionNamesByJvmName(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        List<Name> list = JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP.get(name2);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    public final boolean isRemoveAtByIndex(@NotNull SimpleFunctionDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return Intrinsics.areEqual($receiver.getName().asString(), "removeAt") && Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmSignature($receiver), REMOVE_AT_NAME_AND_SIGNATURE.getSignature());
    }

    /*
     * WARNING - void declaration
     */
    private BuiltinMethodsWithDifferentJvmName() {
        void var3_3;
        Object it;
        Object item$iv$iv;
        Object object;
        Object object2;
        Object $receiver$iv$iv;
        Object $receiver$iv;
        INSTANCE = this;
        String string = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string, "JvmPrimitiveType.INT.desc");
        REMOVE_AT_NAME_AND_SIGNATURE = SpecialBuiltinMembers.access$method("java/util/List", "removeAt", string, "Ljava/lang/Object;");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        Object $receiver = signatureBuildingComponents;
        Pair[] pairArray = new Pair[8];
        String string2 = ((SignatureBuildingComponents)$receiver).javaLang("Number");
        String string3 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string3, "JvmPrimitiveType.BYTE.desc");
        pairArray[0] = TuplesKt.to(SpecialBuiltinMembers.access$method(string2, "toByte", "", string3), Name.identifier("byteValue"));
        String string4 = ((SignatureBuildingComponents)$receiver).javaLang("Number");
        String string5 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string5, "JvmPrimitiveType.SHORT.desc");
        pairArray[1] = TuplesKt.to(SpecialBuiltinMembers.access$method(string4, "toShort", "", string5), Name.identifier("shortValue"));
        String string6 = ((SignatureBuildingComponents)$receiver).javaLang("Number");
        String string7 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string7, "JvmPrimitiveType.INT.desc");
        pairArray[2] = TuplesKt.to(SpecialBuiltinMembers.access$method(string6, "toInt", "", string7), Name.identifier("intValue"));
        String string8 = ((SignatureBuildingComponents)$receiver).javaLang("Number");
        String string9 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string9, "JvmPrimitiveType.LONG.desc");
        pairArray[3] = TuplesKt.to(SpecialBuiltinMembers.access$method(string8, "toLong", "", string9), Name.identifier("longValue"));
        String string10 = ((SignatureBuildingComponents)$receiver).javaLang("Number");
        String string11 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string11, "JvmPrimitiveType.FLOAT.desc");
        pairArray[4] = TuplesKt.to(SpecialBuiltinMembers.access$method(string10, "toFloat", "", string11), Name.identifier("floatValue"));
        String string12 = ((SignatureBuildingComponents)$receiver).javaLang("Number");
        String string13 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string13, "JvmPrimitiveType.DOUBLE.desc");
        pairArray[5] = TuplesKt.to(SpecialBuiltinMembers.access$method(string12, "toDouble", "", string13), Name.identifier("doubleValue"));
        pairArray[6] = TuplesKt.to(REMOVE_AT_NAME_AND_SIGNATURE, Name.identifier("remove"));
        String string14 = ((SignatureBuildingComponents)$receiver).javaLang("CharSequence");
        String string15 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string15, "JvmPrimitiveType.INT.desc");
        String string16 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string16, "JvmPrimitiveType.CHAR.desc");
        pairArray[7] = TuplesKt.to(SpecialBuiltinMembers.access$method(string14, "get", string15, string16), Name.identifier("charAt"));
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = MapsKt.mapOf(pairArray);
        $receiver = $receiver$iv = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
        Object destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($receiver$iv.size()));
        Iterable $receiver$iv$iv$iv = $receiver$iv$iv.entrySet();
        for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
            void it$iv$iv;
            void it2;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            object2 = destination$iv$iv;
            object = ((NameAndSignature)it2.getKey()).getSignature();
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            String string17 = object;
            Map map2 = object2;
            Object v = it$iv$iv.getValue();
            map2.put(string17, v);
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = destination$iv$iv;
        $receiver$iv$iv = $receiver$iv = (Iterable)NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        Iterator iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object element$iv$iv$iv;
            item$iv$iv = iterator2.next();
            element$iv$iv$iv = (NameAndSignature)item$iv$iv;
            object2 = destination$iv$iv;
            object = ((NameAndSignature)it).getName();
            object2.add(object);
        }
        ORIGINAL_SHORT_NAMES = (List)destination$iv$iv;
        $receiver$iv = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv$iv = iterator2.next();
            it = (Map.Entry)item$iv$iv;
            object2 = destination$iv$iv;
            object = new Pair(((NameAndSignature)it.getKey()).getName(), it.getValue());
            object2.add(object);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new LinkedHashMap();
        iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object object3;
            Object $receiver$iv$iv$iv2 = destination$iv$iv;
            Object element$iv$iv = iterator2.next();
            it = (Pair)element$iv$iv;
            Name key$iv$iv = (Name)((Pair)it).getSecond();
            Object value$iv$iv$iv = $receiver$iv$iv$iv2.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                ArrayList answer$iv$iv$iv = new ArrayList();
                $receiver$iv$iv$iv2.put(key$iv$iv, answer$iv$iv$iv);
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
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = var3_3;
    }

    static {
        new BuiltinMethodsWithDifferentJvmName();
    }

    @NotNull
    public static final /* synthetic */ Map access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$p(BuiltinMethodsWithDifferentJvmName $this) {
        BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = $this;
        return SIGNATURE_TO_JVM_REPRESENTATION_NAME;
    }
}

