/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.NameAndSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltinMethodsWithSpecialGenericSignature {
    private static final List<NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    private static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES;
    private static final Map<NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    private static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;
    private static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    private static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES;
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE;

    private final boolean getHasErasedValueParametersInJava(@NotNull CallableMemberDescriptor $receiver) {
        return CollectionsKt.contains((Iterable)ERASED_VALUE_PARAMETERS_SIGNATURES, MethodSignatureMappingKt.computeJvmSignature($receiver));
    }

    @JvmStatic
    @Nullable
    public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        if (!INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(functionDescriptor.getName())) {
            return null;
        }
        return (FunctionDescriptor)DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, getOverriddenBuiltinFunctionWithErasedValueParametersInJava.1.INSTANCE, 1, null);
    }

    @JvmStatic
    @Nullable
    public static final TypeSafeBarrierDescription getDefaultValueForOverriddenBuiltinFunction(@NotNull FunctionDescriptor functionDescriptor) {
        TypeSafeBarrierDescription typeSafeBarrierDescription;
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        if (ERASED_VALUE_PARAMETERS_SHORT_NAMES.contains(functionDescriptor.getName()) ^ true) {
            return null;
        }
        CallableMemberDescriptor callableMemberDescriptor = DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, getDefaultValueForOverriddenBuiltinFunction.1.INSTANCE, 1, null);
        if (callableMemberDescriptor != null) {
            CallableMemberDescriptor callableMemberDescriptor2;
            CallableMemberDescriptor it = callableMemberDescriptor2 = callableMemberDescriptor;
            Map<String, TypeSafeBarrierDescription> map2 = SIGNATURE_TO_DEFAULT_VALUES_MAP;
            String string = MethodSignatureMappingKt.computeJvmSignature(it);
            Map<String, TypeSafeBarrierDescription> map3 = map2;
            if (map3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            }
            typeSafeBarrierDescription = map3.get(string);
        } else {
            typeSafeBarrierDescription = null;
        }
        return typeSafeBarrierDescription;
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(@NotNull Name $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return ERASED_VALUE_PARAMETERS_SHORT_NAMES.contains($receiver);
    }

    public final boolean isBuiltinWithSpecialDescriptorInJvm(@NotNull CallableMemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (!KotlinBuiltIns.isBuiltIn($receiver)) {
            return false;
        }
        SpecialSignatureInfo specialSignatureInfo = BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo($receiver);
        return (specialSignatureInfo != null ? specialSignatureInfo.isObjectReplacedWithTypeParameter() : false) || SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName($receiver);
    }

    @JvmStatic
    @Nullable
    public static final SpecialSignatureInfo getSpecialSignatureInfo(@NotNull CallableMemberDescriptor $receiver) {
        TypeSafeBarrierDescription defaultValue;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (ERASED_VALUE_PARAMETERS_SHORT_NAMES.contains($receiver.getName()) ^ true) {
            return null;
        }
        Object object = DescriptorUtilsKt.firstOverridden$default($receiver, false, getSpecialSignatureInfo.builtinSignature.1.INSTANCE, 1, null);
        if (object == null || (object = MethodSignatureMappingKt.computeJvmSignature((CallableDescriptor)object)) == null) {
            return null;
        }
        Object builtinSignature2 = object;
        if (ERASED_COLLECTION_PARAMETER_SIGNATURES.contains(builtinSignature2)) {
            return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
        }
        TypeSafeBarrierDescription typeSafeBarrierDescription = SIGNATURE_TO_DEFAULT_VALUES_MAP.get(builtinSignature2);
        if (typeSafeBarrierDescription == null) {
            Intrinsics.throwNpe();
        }
        return Intrinsics.areEqual((Object)(defaultValue = typeSafeBarrierDescription), (Object)TypeSafeBarrierDescription.NULL) ? SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC : SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
    }

    /*
     * WARNING - void declaration
     */
    private BuiltinMethodsWithSpecialGenericSignature() {
        Iterable $receiver$iv$iv;
        NameAndSignature it;
        Object object;
        NameAndSignature it2;
        Object object2;
        Iterable $receiver$iv$iv2;
        INSTANCE = this;
        Map<NameAndSignature, TypeSafeBarrierDescription> $receiver$iv = SetsKt.setOf(new String[]{"containsAll", "removeAll", "retainAll"});
        Iterable iterable = $receiver$iv;
        Object destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv2) {
            String string = (String)item$iv$iv;
            object2 = destination$iv$iv;
            String string2 = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics.checkExpressionValueIsNotNull(string2, "JvmPrimitiveType.BOOLEAN.desc");
            object = SpecialBuiltinMembers.access$method("java/util/Collection", (String)((Object)it2), "Ljava/util/Collection;", string2);
            object2.add(object);
        }
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = (List)destination$iv$iv;
        $receiver$iv = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        $receiver$iv$iv2 = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv2) {
            it2 = (NameAndSignature)item$iv$iv;
            object2 = destination$iv$iv;
            object = it2.getSignature();
            object2.add(object);
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = (List)destination$iv$iv;
        $receiver$iv = SignatureBuildingComponents.INSTANCE;
        Object $receiver = (SignatureBuildingComponents)((Object)$receiver$iv);
        Pair[] pairArray = new Pair[10];
        String string = ((SignatureBuildingComponents)$receiver).javaUtil("Collection");
        String string3 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string3, "JvmPrimitiveType.BOOLEAN.desc");
        pairArray[0] = TuplesKt.to(SpecialBuiltinMembers.access$method(string, "contains", "Ljava/lang/Object;", string3), TypeSafeBarrierDescription.FALSE);
        String string4 = ((SignatureBuildingComponents)$receiver).javaUtil("Collection");
        String string5 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string5, "JvmPrimitiveType.BOOLEAN.desc");
        pairArray[1] = TuplesKt.to(SpecialBuiltinMembers.access$method(string4, "remove", "Ljava/lang/Object;", string5), TypeSafeBarrierDescription.FALSE);
        String string6 = ((SignatureBuildingComponents)$receiver).javaUtil("Map");
        String string7 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string7, "JvmPrimitiveType.BOOLEAN.desc");
        pairArray[2] = TuplesKt.to(SpecialBuiltinMembers.access$method(string6, "containsKey", "Ljava/lang/Object;", string7), TypeSafeBarrierDescription.FALSE);
        String string8 = ((SignatureBuildingComponents)$receiver).javaUtil("Map");
        String string9 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string9, "JvmPrimitiveType.BOOLEAN.desc");
        pairArray[3] = TuplesKt.to(SpecialBuiltinMembers.access$method(string8, "containsValue", "Ljava/lang/Object;", string9), TypeSafeBarrierDescription.FALSE);
        String string10 = ((SignatureBuildingComponents)$receiver).javaUtil("Map");
        String string11 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string11, "JvmPrimitiveType.BOOLEAN.desc");
        pairArray[4] = TuplesKt.to(SpecialBuiltinMembers.access$method(string10, "remove", "Ljava/lang/Object;Ljava/lang/Object;", string11), TypeSafeBarrierDescription.FALSE);
        pairArray[5] = TuplesKt.to(SpecialBuiltinMembers.access$method(((SignatureBuildingComponents)$receiver).javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT);
        pairArray[6] = TuplesKt.to(SpecialBuiltinMembers.access$method(((SignatureBuildingComponents)$receiver).javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL);
        pairArray[7] = TuplesKt.to(SpecialBuiltinMembers.access$method(((SignatureBuildingComponents)$receiver).javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL);
        String string12 = ((SignatureBuildingComponents)$receiver).javaUtil("List");
        String string13 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string13, "JvmPrimitiveType.INT.desc");
        pairArray[8] = TuplesKt.to(SpecialBuiltinMembers.access$method(string12, "indexOf", "Ljava/lang/Object;", string13), TypeSafeBarrierDescription.INDEX);
        String string14 = ((SignatureBuildingComponents)$receiver).javaUtil("List");
        String string15 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(string15, "JvmPrimitiveType.INT.desc");
        pairArray[9] = TuplesKt.to(SpecialBuiltinMembers.access$method(string14, "lastIndexOf", "Ljava/lang/Object;", string15), TypeSafeBarrierDescription.INDEX);
        $receiver$iv = GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = MapsKt.mapOf(pairArray);
        $receiver = $receiver$iv;
        destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($receiver$iv.size()));
        Iterable $receiver$iv$iv$iv = $receiver$iv$iv2.entrySet();
        for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
            void it$iv$iv;
            Map.Entry $i$a$1$map = (Map.Entry)element$iv$iv$iv;
            object2 = destination$iv$iv;
            object = ((NameAndSignature)it.getKey()).getSignature();
            Map.Entry $i$f$map = (Map.Entry)element$iv$iv$iv;
            Object object3 = object;
            Object object4 = object2;
            Object v = it$iv$iv.getValue();
            object4.put(object3, v);
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = destination$iv$iv;
        Set<NameAndSignature> allMethods = SetsKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), (Iterable)ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        Iterable $receiver$iv2 = allMethods;
        destination$iv$iv = $receiver$iv2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            it = (NameAndSignature)item$iv$iv;
            object2 = destination$iv$iv2;
            object = it.getName();
            object2.add(object);
        }
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt.toSet((List)destination$iv$iv2);
        $receiver$iv$iv = $receiver$iv2 = (Iterable)allMethods;
        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            it = (NameAndSignature)item$iv$iv;
            object2 = destination$iv$iv2;
            object = it.getSignature();
            object2.add(object);
        }
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt.toSet((List)destination$iv$iv2);
    }

    static {
        new BuiltinMethodsWithSpecialGenericSignature();
    }

    public static final /* synthetic */ boolean access$getHasErasedValueParametersInJava$p(BuiltinMethodsWithSpecialGenericSignature $this, @NotNull CallableMemberDescriptor $receiver) {
        return $this.getHasErasedValueParametersInJava($receiver);
    }

    @NotNull
    public static final /* synthetic */ Map access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$p(BuiltinMethodsWithSpecialGenericSignature $this) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = $this;
        return SIGNATURE_TO_DEFAULT_VALUES_MAP;
    }

    public static final class TypeSafeBarrierDescription
    extends Enum<TypeSafeBarrierDescription> {
        public static final /* enum */ TypeSafeBarrierDescription NULL;
        public static final /* enum */ TypeSafeBarrierDescription INDEX;
        public static final /* enum */ TypeSafeBarrierDescription FALSE;
        public static final /* enum */ TypeSafeBarrierDescription MAP_GET_OR_DEFAULT;
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES;
        @Nullable
        private final Object defaultValue;

        static {
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArray = new TypeSafeBarrierDescription[4];
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArray2 = typeSafeBarrierDescriptionArray;
            typeSafeBarrierDescriptionArray[0] = NULL = new TypeSafeBarrierDescription(null);
            typeSafeBarrierDescriptionArray[1] = INDEX = new TypeSafeBarrierDescription(-1);
            typeSafeBarrierDescriptionArray[2] = FALSE = new TypeSafeBarrierDescription(false);
            typeSafeBarrierDescriptionArray[3] = MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
            $VALUES = typeSafeBarrierDescriptionArray;
        }

        public boolean checkParameter(int index) {
            return true;
        }

        @Nullable
        public final Object getDefaultValue() {
            return this.defaultValue;
        }

        protected TypeSafeBarrierDescription(Object defaultValue) {
            this.defaultValue = defaultValue;
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[])$VALUES.clone();
        }

        public static TypeSafeBarrierDescription valueOf(String string) {
            return Enum.valueOf(TypeSafeBarrierDescription.class, string);
        }

        public static final class MAP_GET_OR_DEFAULT
        extends TypeSafeBarrierDescription {
            @Override
            public boolean checkParameter(int index) {
                return index != 1;
            }

            /*
             * WARNING - void declaration
             */
            MAP_GET_OR_DEFAULT() {
                void var1_1;
            }
        }
    }

    public static final class SpecialSignatureInfo
    extends Enum<SpecialSignatureInfo> {
        public static final /* enum */ SpecialSignatureInfo ONE_COLLECTION_PARAMETER;
        public static final /* enum */ SpecialSignatureInfo OBJECT_PARAMETER_NON_GENERIC;
        public static final /* enum */ SpecialSignatureInfo OBJECT_PARAMETER_GENERIC;
        private static final /* synthetic */ SpecialSignatureInfo[] $VALUES;
        @Nullable
        private final String valueParametersSignature;
        private final boolean isObjectReplacedWithTypeParameter;

        static {
            SpecialSignatureInfo[] specialSignatureInfoArray = new SpecialSignatureInfo[3];
            SpecialSignatureInfo[] specialSignatureInfoArray2 = specialSignatureInfoArray;
            specialSignatureInfoArray[0] = ONE_COLLECTION_PARAMETER = new SpecialSignatureInfo("Ljava/util/Collection<+Ljava/lang/Object;>;", false);
            specialSignatureInfoArray[1] = OBJECT_PARAMETER_NON_GENERIC = new SpecialSignatureInfo(null, true);
            specialSignatureInfoArray[2] = OBJECT_PARAMETER_GENERIC = new SpecialSignatureInfo("Ljava/lang/Object;", true);
            $VALUES = specialSignatureInfoArray;
        }

        @Nullable
        public final String getValueParametersSignature() {
            return this.valueParametersSignature;
        }

        public final boolean isObjectReplacedWithTypeParameter() {
            return this.isObjectReplacedWithTypeParameter;
        }

        protected SpecialSignatureInfo(String valueParametersSignature, boolean isObjectReplacedWithTypeParameter) {
            this.valueParametersSignature = valueParametersSignature;
            this.isObjectReplacedWithTypeParameter = isObjectReplacedWithTypeParameter;
        }

        public static SpecialSignatureInfo[] values() {
            return (SpecialSignatureInfo[])$VALUES.clone();
        }

        public static SpecialSignatureInfo valueOf(String string) {
            return Enum.valueOf(SpecialSignatureInfo.class, string);
        }
    }
}

