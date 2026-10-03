/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectionTypes {
    private final Lazy kotlinReflectScope$delegate;
    @NotNull
    private final ClassLookup kClass$delegate;
    @NotNull
    private final ClassLookup kProperty0$delegate;
    @NotNull
    private final ClassLookup kProperty1$delegate;
    @NotNull
    private final ClassLookup kProperty2$delegate;
    @NotNull
    private final ClassLookup kMutableProperty0$delegate;
    @NotNull
    private final ClassLookup kMutableProperty1$delegate;
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);

    private final MemberScope getKotlinReflectScope() {
        Lazy lazy = this.kotlinReflectScope$delegate;
        ReflectionTypes reflectionTypes = this;
        KProperty kProperty = $$delegatedProperties[0];
        return (MemberScope)lazy.getValue();
    }

    @NotNull
    public final ClassDescriptor find(@NotNull String className) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkParameterIsNotNull(className, "className");
        Name name2 = Name.identifier(className);
        MemberScope memberScope2 = this.getKotlinReflectScope();
        Name name3 = name2;
        Intrinsics.checkExpressionValueIsNotNull(name3, "name");
        ClassifierDescriptor classifierDescriptor = memberScope2.getContributedClassifier(name3, NoLookupLocation.FROM_REFLECTION);
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        if ((classDescriptor = (ClassDescriptor)classifierDescriptor) == null) {
            ClassDescriptor classDescriptor2 = ErrorUtils.createErrorClass(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME().child(name2).asString());
            classDescriptor = classDescriptor2;
            Intrinsics.checkExpressionValueIsNotNull(classDescriptor2, "ErrorUtils.createErrorCl\u2026E.child(name).asString())");
        }
        return classDescriptor;
    }

    @NotNull
    public final ClassDescriptor getKFunction(int n) {
        return this.find("KFunction" + n);
    }

    @NotNull
    public final ClassDescriptor getKClass() {
        return this.kClass$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @NotNull
    public final ClassDescriptor getKProperty0() {
        return this.kProperty0$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @NotNull
    public final ClassDescriptor getKProperty1() {
        return this.kProperty1$delegate.getValue(this, $$delegatedProperties[3]);
    }

    @NotNull
    public final ClassDescriptor getKProperty2() {
        return this.kProperty2$delegate.getValue(this, $$delegatedProperties[4]);
    }

    @NotNull
    public final ClassDescriptor getKMutableProperty0() {
        return this.kMutableProperty0$delegate.getValue(this, $$delegatedProperties[5]);
    }

    @NotNull
    public final ClassDescriptor getKMutableProperty1() {
        return this.kMutableProperty1$delegate.getValue(this, $$delegatedProperties[6]);
    }

    @NotNull
    public final KotlinType getKClassType(@NotNull Annotations annotations2, @NotNull KotlinType type2, @NotNull Variance variance) {
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull((Object)variance, "variance");
        ClassDescriptor descriptor2 = this.getKClass();
        if (ErrorUtils.isError(descriptor2)) {
            SimpleType simpleType2 = descriptor2.getDefaultType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "descriptor.defaultType");
            return simpleType2;
        }
        List<TypeProjectionImpl> arguments2 = CollectionsKt.listOf(new TypeProjectionImpl(variance, type2));
        return KotlinTypeFactory.simpleNotNullType(annotations2, descriptor2, arguments2);
    }

    @NotNull
    public final KotlinType getKFunctionType(@NotNull Annotations annotations2, @Nullable KotlinType receiverType, @NotNull List<? extends KotlinType> parameterTypes, @Nullable List<Name> parameterNames, @NotNull KotlinType returnType, @NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(parameterTypes, "parameterTypes");
        Intrinsics.checkParameterIsNotNull(returnType, "returnType");
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        List<TypeProjection> arguments2 = FunctionTypesKt.getFunctionTypeArgumentProjections(receiverType, parameterTypes, parameterNames, returnType, builtIns);
        ClassDescriptor classDescriptor = this.getKFunction(arguments2.size() - 1);
        if (ErrorUtils.isError(classDescriptor)) {
            SimpleType simpleType2 = classDescriptor.getDefaultType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "classDescriptor.defaultType");
            return simpleType2;
        }
        return KotlinTypeFactory.simpleNotNullType(annotations2, classDescriptor, arguments2);
    }

    @NotNull
    public final KotlinType getKPropertyType(@NotNull Annotations annotations2, @Nullable KotlinType receiverType, @NotNull KotlinType returnType, boolean mutable) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(returnType, "returnType");
        ClassDescriptor classDescriptor2 = receiverType != null ? (mutable ? this.getKMutableProperty1() : this.getKProperty1()) : (classDescriptor = mutable ? this.getKMutableProperty0() : this.getKProperty0());
        if (ErrorUtils.isError(classDescriptor)) {
            SimpleType simpleType2 = classDescriptor.getDefaultType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "classDescriptor.defaultType");
            return simpleType2;
        }
        ArrayList<TypeProjectionImpl> arguments2 = new ArrayList<TypeProjectionImpl>(2);
        if (receiverType != null) {
            arguments2.add(new TypeProjectionImpl(receiverType));
        }
        arguments2.add(new TypeProjectionImpl(returnType));
        return KotlinTypeFactory.simpleNotNullType(annotations2, classDescriptor, (List<? extends TypeProjection>)arguments2);
    }

    public ReflectionTypes(@NotNull ModuleDescriptor module) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        this.kotlinReflectScope$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new Function0<MemberScope>(module){
            final /* synthetic */ ModuleDescriptor $module;

            @NotNull
            public final MemberScope invoke() {
                return this.$module.getPackage(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME()).getMemberScope();
            }
            {
                this.$module = moduleDescriptor;
                super(0);
            }
        });
        this.kClass$delegate = ClassLookup.INSTANCE;
        this.kProperty0$delegate = ClassLookup.INSTANCE;
        this.kProperty1$delegate = ClassLookup.INSTANCE;
        this.kProperty2$delegate = ClassLookup.INSTANCE;
        this.kMutableProperty0$delegate = ClassLookup.INSTANCE;
        this.kMutableProperty1$delegate = ClassLookup.INSTANCE;
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kotlinReflectScope", "getKotlinReflectScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    }

    @JvmStatic
    public static final boolean isNumberedKPropertyOrKMutablePropertyType(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        return Companion.isNumberedKPropertyOrKMutablePropertyType(type2);
    }

    private static final class ClassLookup {
        public static final ClassLookup INSTANCE;

        @NotNull
        public final ClassDescriptor getValue(@NotNull ReflectionTypes types, @NotNull KProperty<?> property) {
            Intrinsics.checkParameterIsNotNull(types, "types");
            Intrinsics.checkParameterIsNotNull(property, "property");
            return types.find(StringsKt.capitalize(property.getName()));
        }

        private ClassLookup() {
            INSTANCE = this;
        }

        static {
            new ClassLookup();
        }
    }

    public static final class Companion {
        public final boolean isReflectionClass(@NotNull ClassDescriptor descriptor2) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            PackageFragmentDescriptor containingPackage = DescriptorUtils.getParentOfType(descriptor2, PackageFragmentDescriptor.class);
            return containingPackage != null && Intrinsics.areEqual(containingPackage.getFqName(), ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME());
        }

        public final boolean isCallableType(@NotNull KotlinType type2) {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            return FunctionTypesKt.isFunctionTypeOrSubtype(type2) || this.isKCallableType(type2);
        }

        @JvmStatic
        public final boolean isNumberedKPropertyOrKMutablePropertyType(@NotNull KotlinType type2) {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            return this.isNumberedKPropertyType(type2) || this.isNumberedKMutablePropertyType(type2);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private final boolean isKCallableType(KotlinType type2) {
            KotlinType kotlinType;
            TypeConstructor typeConstructor2 = type2.getConstructor();
            FqNameUnsafe fqNameUnsafe = KotlinBuiltIns.FQ_NAMES.kCallable;
            Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "KotlinBuiltIns.FQ_NAMES.kCallable");
            if (this.hasFqName(typeConstructor2, fqNameUnsafe)) return true;
            Iterable $receiver$iv = type2.getConstructor().getSupertypes();
            Iterator iterator2 = $receiver$iv.iterator();
            do {
                KotlinType it;
                if (!iterator2.hasNext()) return false;
                Object element$iv = iterator2.next();
                kotlinType = it = (KotlinType)element$iv;
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "it");
            } while (!Companion.isKCallableType(kotlinType));
            return true;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final boolean isNumberedKMutablePropertyType(@NotNull KotlinType type2) {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            ClassifierDescriptor classifierDescriptor = type2.getConstructor().getDeclarationDescriptor();
            if (!(classifierDescriptor instanceof ClassDescriptor)) {
                classifierDescriptor = null;
            }
            ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
            if (classDescriptor == null) return false;
            ClassDescriptor descriptor2 = classDescriptor;
            FqNameUnsafe fqNameUnsafe = KotlinBuiltIns.FQ_NAMES.kMutableProperty0;
            Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "KotlinBuiltIns.FQ_NAMES.kMutableProperty0");
            if (this.hasFqName(descriptor2, fqNameUnsafe)) return true;
            FqNameUnsafe fqNameUnsafe2 = KotlinBuiltIns.FQ_NAMES.kMutableProperty1;
            Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe2, "KotlinBuiltIns.FQ_NAMES.kMutableProperty1");
            if (this.hasFqName(descriptor2, fqNameUnsafe2)) return true;
            FqNameUnsafe fqNameUnsafe3 = KotlinBuiltIns.FQ_NAMES.kMutableProperty2;
            Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe3, "KotlinBuiltIns.FQ_NAMES.kMutableProperty2");
            if (!this.hasFqName(descriptor2, fqNameUnsafe3)) return false;
            return true;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final boolean isNumberedKPropertyType(@NotNull KotlinType type2) {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            ClassifierDescriptor classifierDescriptor = type2.getConstructor().getDeclarationDescriptor();
            if (!(classifierDescriptor instanceof ClassDescriptor)) {
                classifierDescriptor = null;
            }
            ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
            if (classDescriptor == null) return false;
            ClassDescriptor descriptor2 = classDescriptor;
            FqNameUnsafe fqNameUnsafe = KotlinBuiltIns.FQ_NAMES.kProperty0;
            Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "KotlinBuiltIns.FQ_NAMES.kProperty0");
            if (this.hasFqName(descriptor2, fqNameUnsafe)) return true;
            FqNameUnsafe fqNameUnsafe2 = KotlinBuiltIns.FQ_NAMES.kProperty1;
            Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe2, "KotlinBuiltIns.FQ_NAMES.kProperty1");
            if (this.hasFqName(descriptor2, fqNameUnsafe2)) return true;
            FqNameUnsafe fqNameUnsafe3 = KotlinBuiltIns.FQ_NAMES.kProperty2;
            Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe3, "KotlinBuiltIns.FQ_NAMES.kProperty2");
            if (!this.hasFqName(descriptor2, fqNameUnsafe3)) return false;
            return true;
        }

        private final boolean hasFqName(TypeConstructor typeConstructor2, FqNameUnsafe fqName2) {
            ClassifierDescriptor descriptor2 = typeConstructor2.getDeclarationDescriptor();
            return descriptor2 instanceof ClassDescriptor && this.hasFqName((ClassDescriptor)descriptor2, fqName2);
        }

        private final boolean hasFqName(ClassDescriptor descriptor2, FqNameUnsafe fqName2) {
            return Intrinsics.areEqual(descriptor2.getName(), fqName2.shortName()) && Intrinsics.areEqual(DescriptorUtils.getFqName(descriptor2), fqName2);
        }

        @Nullable
        public final KotlinType createKPropertyStarType(@NotNull ModuleDescriptor module) {
            Intrinsics.checkParameterIsNotNull(module, "module");
            ClassId classId = KotlinBuiltIns.FQ_NAMES.kProperty;
            Intrinsics.checkExpressionValueIsNotNull(classId, "KotlinBuiltIns.FQ_NAMES.kProperty");
            ClassDescriptor classDescriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(module, classId);
            if (classDescriptor == null) {
                return null;
            }
            ClassDescriptor kPropertyClass = classDescriptor;
            Annotations annotations2 = Annotations.Companion.getEMPTY();
            TypeParameterDescriptor typeParameterDescriptor = CollectionsKt.single(kPropertyClass.getTypeConstructor().getParameters());
            Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "kPropertyClass.typeConstructor.parameters.single()");
            return KotlinTypeFactory.simpleNotNullType(annotations2, kPropertyClass, CollectionsKt.listOf(new StarProjectionImpl(typeParameterDescriptor)));
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

