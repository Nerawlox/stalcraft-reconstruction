/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfigurationImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeSignatureMappingKt {
    @NotNull
    public static final String NON_EXISTENT_CLASS_NAME = "error/NonExistentClass";
    private static final String CONTINUATION_INTERNAL_NAME = JvmClassName.byClassId(ClassId.topLevel(DescriptorUtils.CONTINUATION_INTERFACE_FQ_NAME)).getInternalName();

    private static final <T> T boxTypeIfNeeded(@NotNull JvmTypeFactory<T> $receiver, T possiblyPrimitiveType, boolean needBoxedType) {
        return needBoxedType ? $receiver.boxType(possiblyPrimitiveType) : possiblyPrimitiveType;
    }

    @NotNull
    public static final <T> T mapType(@NotNull KotlinType kotlinType, @NotNull JvmTypeFactory<T> factory, @NotNull TypeMappingMode mode, @NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration, @Nullable JvmDescriptorTypeWriter<T> descriptorTypeWriter, @NotNull Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> writeGenericType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "kotlinType");
        Intrinsics.checkParameterIsNotNull(factory, "factory");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        Intrinsics.checkParameterIsNotNull(typeMappingConfiguration, "typeMappingConfiguration");
        Intrinsics.checkParameterIsNotNull(writeGenericType, "writeGenericType");
        if (FunctionTypesKt.isSuspendFunctionType(kotlinType)) {
            return TypeSignatureMappingKt.mapType(SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(kotlinType), factory, mode, typeMappingConfiguration, descriptorTypeWriter, writeGenericType);
        }
        T t = TypeSignatureMappingKt.mapBuiltInType(kotlinType, factory, typeMappingConfiguration);
        if (t != null) {
            T t2;
            T builtInType = t2 = t;
            T jvmType = TypeSignatureMappingKt.boxTypeIfNeeded(factory, builtInType, mode.getNeedPrimitiveBoxing());
            writeGenericType.invoke(kotlinType, jvmType, mode);
            return jvmType;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            Collection<KotlinType> collection = ((IntersectionTypeConstructor)constructor).getSupertypes();
            Intrinsics.checkExpressionValueIsNotNull(collection, "constructor.supertypes");
            KotlinType commonSupertype = typeMappingConfiguration.commonSupertype(collection);
            return TypeSignatureMappingKt.mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(commonSupertype), factory, mode, typeMappingConfiguration, descriptorTypeWriter, writeGenericType);
        }
        ClassifierDescriptor classifierDescriptor = constructor.getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            throw (Throwable)new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
        }
        ClassifierDescriptor descriptor2 = classifierDescriptor;
        if (ErrorUtils.isError(descriptor2)) {
            T jvmType = factory.createObjectType(NON_EXISTENT_CLASS_NAME);
            ClassifierDescriptor classifierDescriptor2 = descriptor2;
            if (classifierDescriptor2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            typeMappingConfiguration.processErrorType(kotlinType, (ClassDescriptor)classifierDescriptor2);
            JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter = descriptorTypeWriter;
            if (jvmDescriptorTypeWriter != null) {
                jvmDescriptorTypeWriter.writeClass(jvmType);
            }
            return jvmType;
        }
        if (descriptor2 instanceof ClassDescriptor && KotlinBuiltIns.isArray(kotlinType)) {
            T arrayElementType;
            if (kotlinType.getArguments().size() != 1) {
                throw (Throwable)new UnsupportedOperationException("arrays must have one type argument");
            }
            TypeProjection memberProjection = kotlinType.getArguments().get(0);
            KotlinType memberType = memberProjection.getType();
            if (memberProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                arrayElementType = factory.createObjectType("java/lang/Object");
                JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter = descriptorTypeWriter;
                if (jvmDescriptorTypeWriter != null) {
                    JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter2;
                    JvmDescriptorTypeWriter<Object> $receiver = jvmDescriptorTypeWriter2 = jvmDescriptorTypeWriter;
                    $receiver.writeArrayType();
                    $receiver.writeClass(arrayElementType);
                    $receiver.writeArrayEnd();
                }
            } else {
                JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter = descriptorTypeWriter;
                if (jvmDescriptorTypeWriter != null) {
                    jvmDescriptorTypeWriter.writeArrayType();
                }
                KotlinType kotlinType2 = memberType;
                Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "memberType");
                Variance variance = memberProjection.getProjectionKind();
                Intrinsics.checkExpressionValueIsNotNull((Object)variance, "memberProjection.projectionKind");
                arrayElementType = TypeSignatureMappingKt.mapType(kotlinType2, factory, mode.toGenericArgumentMode(variance), typeMappingConfiguration, descriptorTypeWriter, writeGenericType);
                JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter3 = descriptorTypeWriter;
                if (jvmDescriptorTypeWriter3 != null) {
                    jvmDescriptorTypeWriter3.writeArrayEnd();
                }
            }
            return factory.createFromString("[" + factory.toString(arrayElementType));
        }
        if (descriptor2 instanceof ClassDescriptor) {
            T t3;
            if (mode.isForAnnotationParameter() && KotlinBuiltIns.isKClass((ClassDescriptor)descriptor2)) {
                t3 = factory.getJavaLangClassType();
            } else {
                ClassDescriptor classDescriptor = ((ClassDescriptor)descriptor2).getOriginal();
                Intrinsics.checkExpressionValueIsNotNull(classDescriptor, "descriptor.original");
                t3 = typeMappingConfiguration.getPredefinedTypeForClass(classDescriptor);
                if (t3 == null) {
                    ClassDescriptor classDescriptor2 = ((ClassDescriptor)descriptor2).getOriginal();
                    Intrinsics.checkExpressionValueIsNotNull(classDescriptor2, "descriptor.original");
                    t3 = factory.createObjectType(TypeSignatureMappingKt.computeInternalName(classDescriptor2, typeMappingConfiguration));
                }
            }
            T jvmType = t3;
            writeGenericType.invoke(kotlinType, jvmType, mode);
            return jvmType;
        }
        if (descriptor2 instanceof TypeParameterDescriptor) {
            ClassifierDescriptor classifierDescriptor3 = descriptor2;
            Intrinsics.checkExpressionValueIsNotNull(classifierDescriptor3, "descriptor");
            JvmDescriptorTypeWriter<T> jvmDescriptorTypeWriter = null;
            Function3<Object, Object, Object, Unit> function3 = FunctionsKt.getDO_NOTHING_3();
            Object type2 = TypeSignatureMappingKt.mapType(TypeSignatureMappingKt.getRepresentativeUpperBound((TypeParameterDescriptor)classifierDescriptor3), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
            JvmDescriptorTypeWriter<Object> jvmDescriptorTypeWriter4 = descriptorTypeWriter;
            if (jvmDescriptorTypeWriter4 != null) {
                Name name2 = descriptor2.getName();
                Intrinsics.checkExpressionValueIsNotNull(name2, "descriptor.getName()");
                jvmDescriptorTypeWriter4.writeTypeVariable(name2, type2);
            }
            return (T)type2;
        }
        throw (Throwable)new UnsupportedOperationException("Unknown type " + kotlinType);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, Function3 function3, int n, Object object) {
        if ((n & 0x20) != 0) {
            function3 = FunctionsKt.getDO_NOTHING_3();
        }
        return TypeSignatureMappingKt.mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean hasVoidReturnType(@NotNull CallableDescriptor descriptor2) {
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        if (descriptor2 instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType kotlinType = descriptor2.getReturnType();
        if (kotlinType == null) {
            Intrinsics.throwNpe();
        }
        if (!KotlinBuiltIns.isUnit(kotlinType)) return false;
        KotlinType kotlinType2 = descriptor2.getReturnType();
        if (kotlinType2 == null) {
            Intrinsics.throwNpe();
        }
        if (TypeUtils.isNullableType(kotlinType2)) return false;
        if (descriptor2 instanceof PropertyGetterDescriptor) return false;
        return true;
    }

    private static final <T> T mapBuiltInType(KotlinType type2, JvmTypeFactory<T> typeFactory, TypeMappingConfiguration<? extends T> typeMappingConfiguration) {
        ClassifierDescriptor classifierDescriptor = type2.getConstructor().getDeclarationDescriptor();
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor descriptor2 = classDescriptor;
        if (descriptor2 == SuspendFunctionTypesKt.getFAKE_CONTINUATION_CLASS_DESCRIPTOR()) {
            String string = CONTINUATION_INTERNAL_NAME;
            Intrinsics.checkExpressionValueIsNotNull(string, "CONTINUATION_INTERNAL_NAME");
            return typeFactory.createObjectType(string);
        }
        FqNameUnsafe fqName2 = DescriptorUtilsKt.getFqNameUnsafe(descriptor2);
        PrimitiveType primitiveType = KotlinBuiltIns.getPrimitiveTypeByFqName(fqName2);
        if (primitiveType != null) {
            String string = JvmPrimitiveType.get(primitiveType).getDesc();
            Intrinsics.checkExpressionValueIsNotNull(string, "JvmPrimitiveType.get(primitiveType).desc");
            T jvmType = typeFactory.createFromString(string);
            boolean isNullableInJava = TypeUtils.isNullableType(type2) || TypeEnhancementKt.hasEnhancedNullability(type2);
            return TypeSignatureMappingKt.boxTypeIfNeeded(typeFactory, jvmType, isNullableInJava);
        }
        PrimitiveType arrayElementType = KotlinBuiltIns.getPrimitiveTypeByArrayClassFqName(fqName2);
        if (arrayElementType != null) {
            return typeFactory.createFromString("[" + JvmPrimitiveType.get(arrayElementType).getDesc());
        }
        ClassId classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqName2);
        if (classId != null) {
            String string = JvmClassName.byClassId(classId, typeMappingConfiguration).getInternalName();
            Intrinsics.checkExpressionValueIsNotNull(string, "JvmClassName.byClassId(c\u2026nfiguration).internalName");
            return typeFactory.createObjectType(string);
        }
        return null;
    }

    @NotNull
    public static final String computeInternalName(@NotNull ClassDescriptor klass, @NotNull TypeMappingConfiguration<?> typeMappingConfiguration) {
        String string;
        String containerInternalName;
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        Intrinsics.checkParameterIsNotNull(typeMappingConfiguration, "typeMappingConfiguration");
        DeclarationDescriptor container = klass.getContainingDeclaration();
        String name2 = SpecialNames.safeIdentifier(klass.getName()).getIdentifier();
        if (container instanceof PackageFragmentDescriptor) {
            String string2;
            FqName fqName2 = ((PackageFragmentDescriptor)container).getFqName();
            if (fqName2.isRoot()) {
                String string3 = name2;
                string2 = string3;
                Intrinsics.checkExpressionValueIsNotNull(string3, "name");
            } else {
                string2 = StringsKt.replace$default(fqName2.asString(), '.', '/', false, 4, null) + '/' + name2;
            }
            return string2;
        }
        DeclarationDescriptor declarationDescriptor = container;
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)declarationDescriptor;
        if (classDescriptor == null) {
            throw (Throwable)new IllegalArgumentException("Unexpected container: " + container + " for " + klass);
        }
        ClassDescriptor containerClass = classDescriptor;
        String string4 = typeMappingConfiguration.getPredefinedInternalNameForClass(containerClass);
        if (string4 == null) {
            string4 = containerInternalName = TypeSignatureMappingKt.computeInternalName(containerClass, typeMappingConfiguration);
        }
        if (Intrinsics.areEqual((Object)klass.getKind(), (Object)ClassKind.ENUM_ENTRY)) {
            string = containerInternalName;
        } else {
            Function2<String, String, String> function2 = typeMappingConfiguration.getInnerClassNameFactory();
            String string5 = name2;
            Intrinsics.checkExpressionValueIsNotNull(string5, "name");
            string = function2.invoke(containerInternalName, string5);
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int n, Object object) {
        if ((n & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return TypeSignatureMappingKt.computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    private static final KotlinType getRepresentativeUpperBound(TypeParameterDescriptor descriptor2) {
        KotlinType kotlinType;
        Object v3;
        List<KotlinType> upperBounds2;
        block4: {
            boolean bl;
            upperBounds2 = descriptor2.getUpperBounds();
            boolean bl2 = bl = !upperBounds2.isEmpty();
            if (_Assertions.ENABLED && !bl) {
                String string = "Upper bounds should not be empty: " + descriptor2;
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            Iterable $receiver$iv = upperBounds2;
            for (Object element$iv : $receiver$iv) {
                ClassDescriptor classDescriptor;
                KotlinType it = (KotlinType)element$iv;
                ClassifierDescriptor classifierDescriptor = it.getConstructor().getDeclarationDescriptor();
                if (!(classifierDescriptor instanceof ClassDescriptor)) {
                    classifierDescriptor = null;
                }
                boolean bl3 = (ClassDescriptor)classifierDescriptor == null ? false : Intrinsics.areEqual((Object)classDescriptor.getKind(), (Object)ClassKind.INTERFACE) ^ true && Intrinsics.areEqual((Object)classDescriptor.getKind(), (Object)ClassKind.ANNOTATION_CLASS) ^ true;
                if (!bl3) continue;
                v3 = element$iv;
                break block4;
            }
            v3 = null;
        }
        if ((kotlinType = (KotlinType)v3) == null) {
            KotlinType kotlinType2 = CollectionsKt.first(upperBounds2);
            Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "upperBounds.first()");
            kotlinType = kotlinType2;
        }
        return kotlinType;
    }
}

