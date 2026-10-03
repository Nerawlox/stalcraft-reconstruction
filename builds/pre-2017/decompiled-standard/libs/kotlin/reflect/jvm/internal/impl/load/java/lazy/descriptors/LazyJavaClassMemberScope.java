/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaClassMemberScope
extends LazyJavaScope {
    @NotNull
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
    private final NotNullLazyValue<Map<Name, JavaClass>> nestedClassIndex;
    private final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
    private final MemoizedFunctionToNullable<Name, ClassDescriptorBase> nestedClasses;
    @NotNull
    private final ClassDescriptor ownerDescriptor;
    private final JavaClass jClass;

    @Override
    @NotNull
    protected ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, computeMemberIndex.1.INSTANCE);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected HashSet<Name> computeFunctionNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Iterable iterable = this.getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Collection destination$iv = new HashSet();
        for (Object element$iv : $receiver$iv) {
            KotlinType it = (KotlinType)element$iv;
            Iterable list$iv = it.getMemberScope().getFunctionNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        iterable = destination$iv;
        HashSet $receiver = (HashSet)iterable;
        $receiver.addAll((Collection)((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).getMethodNames());
        $receiver.addAll((Collection)this.computeClassNames(kindFilter, nameFilter));
        return (HashSet)iterable;
    }

    @NotNull
    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$kotlin_core() {
        return this.constructors;
    }

    @Override
    protected boolean isVisibleAsFunction(@NotNull JavaMethodDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (this.jClass.isAnnotationType()) {
            return false;
        }
        return this.isVisibleAsFunctionInCurrentClass($receiver);
    }

    private final boolean isVisibleAsFunctionInCurrentClass(SimpleFunctionDescriptor function) {
        boolean bl;
        block4: {
            Name name2 = function.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "function.name");
            Iterable $receiver$iv = PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(name2);
            for (Object element$iv : $receiver$iv) {
                boolean bl2;
                block3: {
                    Name propertyName = (Name)element$iv;
                    Iterable $receiver$iv2 = this.getPropertiesFromSupertypes(propertyName);
                    for (Object element$iv2 : $receiver$iv2) {
                        PropertyDescriptor property = (PropertyDescriptor)element$iv2;
                        if (!(this.doesClassOverridesProperty(property, (Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>>)new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>(this, function){
                            final /* synthetic */ LazyJavaClassMemberScope this$0;
                            final /* synthetic */ SimpleFunctionDescriptor $function$inlined;
                            {
                                this.this$0 = lazyJavaClassMemberScope;
                                this.$function$inlined = simpleFunctionDescriptor;
                                super(1);
                            }

                            public final Collection<SimpleFunctionDescriptor> invoke(Name accessorName) {
                                return Intrinsics.areEqual(this.$function$inlined.getName(), accessorName) ? (Collection)CollectionsKt.listOf(this.$function$inlined) : (Collection)CollectionsKt.plus(LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic(this.this$0, accessorName), (Iterable)LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.this$0, accessorName));
                            }
                        }) && (property.isVar() || !JvmAbi.isSetterName(function.getName().asString())))) continue;
                        bl2 = true;
                        break block3;
                    }
                    bl2 = false;
                }
                if (!bl2) continue;
                bl = true;
                break block4;
            }
            bl = false;
        }
        if (bl) {
            return false;
        }
        return !this.doesOverrideRenamedBuiltins(function) && !this.shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(function);
    }

    /*
     * WARNING - void declaration
     */
    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(@NotNull SimpleFunctionDescriptor $receiver) {
        boolean bl;
        block3: {
            void $receiver$iv$iv;
            if (!BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters($receiver.getName())) {
                return false;
            }
            Name name2 = $receiver.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "name");
            Iterable $receiver$iv = this.getFunctionsFromSupertypes(name2);
            Iterable iterable = $receiver$iv;
            Collection destination$iv$iv = new ArrayList();
            void $receiver$iv$iv$iv = $receiver$iv$iv;
            for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
                FunctionDescriptor functionDescriptor;
                Object element$iv$iv = element$iv$iv$iv;
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
                if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(it) == null) continue;
                FunctionDescriptor it$iv$iv = functionDescriptor;
                destination$iv$iv.add(it$iv$iv);
            }
            List candidatesToOverride = (List)destination$iv$iv;
            $receiver$iv = candidatesToOverride;
            for (Object element$iv : $receiver$iv) {
                FunctionDescriptor candidate = (FunctionDescriptor)element$iv;
                if (!this.hasSameJvmDescriptorButDoesNotOverride($receiver, candidate)) continue;
                bl = true;
                break block3;
            }
            bl = false;
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    private final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name name2) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).findMethodsByName(name2);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            JavaMethod javaMethod = (JavaMethod)item$iv$iv;
            Collection collection = destination$iv$iv;
            JavaMethodDescriptor javaMethodDescriptor = this.resolveMethodToFunctionDescriptor((JavaMethod)it);
            collection.add(javaMethodDescriptor);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name name2) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)this.getFunctionsFromSupertypes(name2);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
            if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(it) || BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(it) != null) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private final boolean doesOverrideRenamedBuiltins(@NotNull SimpleFunctionDescriptor $receiver) {
        boolean bl;
        block6: {
            Name name2 = $receiver.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "name");
            Iterable $receiver$iv = BuiltinMethodsWithDifferentJvmName.INSTANCE.getBuiltinFunctionNamesByJvmName(name2);
            for (Object element$iv : $receiver$iv) {
                boolean bl2;
                block5: {
                    void $receiver$iv$iv;
                    Iterable $receiver$iv2;
                    Name builtinName = (Name)element$iv;
                    Iterable iterable = $receiver$iv2 = (Iterable)this.getFunctionsFromSupertypes(builtinName);
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $receiver$iv$iv) {
                        SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
                        if (!SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(it)) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    List builtinSpecialFromSuperTypes = (List)destination$iv$iv;
                    if (builtinSpecialFromSuperTypes.isEmpty()) {
                        bl2 = false;
                    } else {
                        SimpleFunctionDescriptor methodDescriptor = this.createRenamedCopy($receiver, builtinName);
                        Iterable $receiver$iv3 = builtinSpecialFromSuperTypes;
                        for (Object element$iv2 : $receiver$iv3) {
                            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv2;
                            if (!this.doesOverrideRenamedDescriptor(it, methodDescriptor)) continue;
                            bl2 = true;
                            break block5;
                        }
                        bl2 = false;
                    }
                }
                if (!bl2) continue;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    private final SimpleFunctionDescriptor createRenamedCopy(@NotNull SimpleFunctionDescriptor $receiver, Name builtinName) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> copyBuilder;
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> $receiver2 = copyBuilder = $receiver.newCopyBuilder();
        $receiver2.setName(builtinName);
        $receiver2.setSignatureChange();
        $receiver2.setPreserveSourceElement();
        SimpleFunctionDescriptor simpleFunctionDescriptor = copyBuilder.build();
        if (simpleFunctionDescriptor == null) {
            Intrinsics.throwNpe();
        }
        return simpleFunctionDescriptor;
    }

    private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor superDescriptor, FunctionDescriptor subDescriptor) {
        FunctionDescriptor subDescriptorToCheck = BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(superDescriptor) ? subDescriptor.getOriginal() : subDescriptor;
        return this.doesOverride(subDescriptorToCheck, superDescriptor);
    }

    private final boolean doesOverride(@NotNull CallableDescriptor $receiver, CallableDescriptor superDescriptor) {
        OverridingUtil.OverrideCompatibilityInfo.Result commonOverridabilityResult = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, $receiver, true).getResult();
        return Intrinsics.areEqual((Object)commonOverridabilityResult, (Object)OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) && !JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(superDescriptor, $receiver);
    }

    private final SimpleFunctionDescriptor findGetterOverride(@NotNull PropertyDescriptor $receiver, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions2) {
        String specialGetterName;
        PropertyGetterDescriptor overriddenBuiltinProperty;
        PropertyGetterDescriptor propertyGetterDescriptor = $receiver.getGetter();
        PropertyGetterDescriptor propertyGetterDescriptor2 = overriddenBuiltinProperty = propertyGetterDescriptor != null ? (PropertyGetterDescriptor)SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName((CallableMemberDescriptor)propertyGetterDescriptor) : null;
        String string = specialGetterName = propertyGetterDescriptor2 != null ? BuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyGetterDescriptor2) : null;
        if (specialGetterName != null) {
            ClassDescriptor classDescriptor = this.getOwnerDescriptor();
            PropertyGetterDescriptor propertyGetterDescriptor3 = overriddenBuiltinProperty;
            if (propertyGetterDescriptor3 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(propertyGetterDescriptor3, "overriddenBuiltinProperty!!");
            if (!SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(classDescriptor, propertyGetterDescriptor3)) {
                return this.findGetterByName($receiver, specialGetterName, functions2);
            }
        }
        String string2 = JvmAbi.getterName($receiver.getName().asString());
        Intrinsics.checkExpressionValueIsNotNull(string2, "JvmAbi.getterName(name.asString())");
        return this.findGetterByName($receiver, string2, functions2);
    }

    private final SimpleFunctionDescriptor findGetterByName(@NotNull PropertyDescriptor $receiver, String getterName, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions2) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        block1: {
            Name name2 = Name.identifier(getterName);
            Intrinsics.checkExpressionValueIsNotNull(name2, "Name.identifier(getterName)");
            Iterable $receiver$iv = functions2.invoke(name2);
            for (Object element$iv : $receiver$iv) {
                SimpleFunctionDescriptor descriptor2 = (SimpleFunctionDescriptor)element$iv;
                SimpleFunctionDescriptor result$iv = descriptor2.getValueParameters().size() != 0 ? null : AddToStdlibKt.check(descriptor2, (Function1)new Function1<SimpleFunctionDescriptor, Boolean>(descriptor2, $receiver){
                    final /* synthetic */ SimpleFunctionDescriptor $descriptor;
                    final /* synthetic */ PropertyDescriptor receiver$0$inlined;
                    {
                        this.$descriptor = simpleFunctionDescriptor;
                        this.receiver$0$inlined = propertyDescriptor;
                        super(1);
                    }

                    public final boolean invoke(SimpleFunctionDescriptor it) {
                        KotlinType kotlinType = this.$descriptor.getReturnType();
                        if (kotlinType == null) {
                            boolean bl = false;
                            return bl;
                        }
                        return KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType, this.receiver$0$inlined.getType());
                    }
                });
                if (result$iv == null) continue;
                simpleFunctionDescriptor = result$iv;
                break block1;
            }
            simpleFunctionDescriptor = null;
        }
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor findSetterOverride(@NotNull PropertyDescriptor $receiver, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions2) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        block3: {
            Name name2 = Name.identifier(JvmAbi.setterName($receiver.getName().asString()));
            Intrinsics.checkExpressionValueIsNotNull(name2, "Name.identifier(JvmAbi.s\u2026terName(name.asString()))");
            Iterable $receiver$iv = functions2.invoke(name2);
            for (Object element$iv : $receiver$iv) {
                SimpleFunctionDescriptor result$iv;
                SimpleFunctionDescriptor simpleFunctionDescriptor2;
                SimpleFunctionDescriptor descriptor2 = (SimpleFunctionDescriptor)element$iv;
                if (descriptor2.getValueParameters().size() != 1) {
                    simpleFunctionDescriptor2 = null;
                } else {
                    KotlinType kotlinType = descriptor2.getReturnType();
                    simpleFunctionDescriptor2 = kotlinType == null ? null : (!KotlinBuiltIns.isUnit(kotlinType) ? null : AddToStdlibKt.check(descriptor2, (Function1)new Function1<SimpleFunctionDescriptor, Boolean>(descriptor2, $receiver){
                        final /* synthetic */ SimpleFunctionDescriptor $descriptor;
                        final /* synthetic */ PropertyDescriptor receiver$0$inlined;
                        {
                            this.$descriptor = simpleFunctionDescriptor;
                            this.receiver$0$inlined = propertyDescriptor;
                            super(1);
                        }

                        public final boolean invoke(SimpleFunctionDescriptor it) {
                            return KotlinTypeChecker.DEFAULT.equalTypes(CollectionsKt.single(this.$descriptor.getValueParameters()).getType(), this.receiver$0$inlined.getType());
                        }
                    }));
                }
                if ((result$iv = simpleFunctionDescriptor2) == null) continue;
                simpleFunctionDescriptor = result$iv;
                break block3;
            }
            simpleFunctionDescriptor = null;
        }
        return simpleFunctionDescriptor;
    }

    private final boolean doesClassOverridesProperty(PropertyDescriptor property, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions2) {
        if (JavaDescriptorUtilKt.isJavaField(property)) {
            return false;
        }
        SimpleFunctionDescriptor getter = this.findGetterOverride(property, functions2);
        SimpleFunctionDescriptor setter = this.findSetterOverride(property, functions2);
        if (getter == null) {
            return false;
        }
        if (!property.isVar()) {
            return true;
        }
        return setter != null && Intrinsics.areEqual((Object)setter.getModality(), (Object)getter.getModality());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result2, @NotNull Name name2) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Collection mergedFunctionFromSuperTypes;
        Intrinsics.checkParameterIsNotNull(result2, "result");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = this.getFunctionsFromSupertypes(name2);
        if (!BuiltinMethodsWithDifferentJvmName.INSTANCE.getSameAsRenamedInJvmBuiltin(name2) && !BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name2)) {
            void $receiver$iv$iv2;
            void $receiver$iv2;
            Iterable iterable = functionsFromSupertypes;
            Name name3 = name2;
            Collection<SimpleFunctionDescriptor> collection = result2;
            LazyJavaClassMemberScope lazyJavaClassMemberScope = this;
            void var8_9 = $receiver$iv2;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $receiver$iv$iv2) {
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
                if (!this.isVisibleAsFunctionInCurrentClass(it)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List list = (List)destination$iv$iv;
            lazyJavaClassMemberScope.addFunctionFromSupertypes(collection, name3, list, false);
            return;
        }
        SmartSet specialBuiltinsFromSuperTypes = SmartSet.Companion.create();
        Collection collection = mergedFunctionFromSuperTypes = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name2, (Collection)functionsFromSupertypes, CollectionsKt.emptyList(), this.getOwnerDescriptor(), ErrorReporter.DO_NOTHING);
        Intrinsics.checkExpressionValueIsNotNull(collection, "mergedFunctionFromSuperTypes");
        this.addOverriddenBuiltinMethods(name2, result2, collection, result2, (Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>>)new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>(this){

            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name p1) {
                Intrinsics.checkParameterIsNotNull(p1, "p1");
                return LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic((LazyJavaClassMemberScope)this.receiver, p1);
            }

            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(LazyJavaClassMemberScope.class);
            }

            public final String getName() {
                return "searchMethodsByNameWithoutBuiltinMagic";
            }

            public final String getSignature() {
                return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
            }
        });
        Collection collection2 = mergedFunctionFromSuperTypes;
        Intrinsics.checkExpressionValueIsNotNull(collection2, "mergedFunctionFromSuperTypes");
        this.addOverriddenBuiltinMethods(name2, result2, collection2, specialBuiltinsFromSuperTypes, (Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>>)new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>(this){

            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name p1) {
                Intrinsics.checkParameterIsNotNull(p1, "p1");
                return LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic((LazyJavaClassMemberScope)this.receiver, p1);
            }

            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(LazyJavaClassMemberScope.class);
            }

            public final String getName() {
                return "searchMethodsInSupertypesWithoutBuiltinMagic";
            }

            public final String getSignature() {
                return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
            }
        });
        Iterable element$iv$iv = $receiver$iv = (Iterable)functionsFromSupertypes;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv2 : $receiver$iv$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv2;
            if (!this.isVisibleAsFunctionInCurrentClass(it)) continue;
            destination$iv$iv.add(element$iv$iv2);
        }
        List visibleFunctionsFromSupertypes = CollectionsKt.plus((Collection)((List)destination$iv$iv), (Iterable)specialBuiltinsFromSuperTypes);
        this.addFunctionFromSupertypes(result2, name2, visibleFunctionsFromSupertypes, true);
    }

    /*
     * WARNING - void declaration
     */
    private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> result2, Name name2, Collection<? extends SimpleFunctionDescriptor> functionsFromSupertypes, boolean isSpecialBuiltinName) {
        Collection<SimpleFunctionDescriptor> additionalOverrides = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name2, functionsFromSupertypes, result2, this.getOwnerDescriptor(), this.getC().getComponents().getErrorReporter());
        if (!isSpecialBuiltinName) {
            Collection<SimpleFunctionDescriptor> collection = additionalOverrides;
            Intrinsics.checkExpressionValueIsNotNull(collection, "additionalOverrides");
            result2.addAll(collection);
        } else {
            Collection<void> collection;
            void $receiver$iv$iv;
            void $receiver$iv;
            Collection<SimpleFunctionDescriptor> collection2 = additionalOverrides;
            Intrinsics.checkExpressionValueIsNotNull(collection2, "additionalOverrides");
            List<SimpleFunctionDescriptor> allDescriptors2 = CollectionsKt.plus(result2, (Iterable)collection2);
            Iterable iterable = additionalOverrides;
            Collection<SimpleFunctionDescriptor> collection3 = result2;
            void var9_9 = $receiver$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                SimpleFunctionDescriptor overriddenBuiltin;
                void resolvedOverride;
                SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor)item$iv$iv;
                collection = destination$iv$iv;
                void var16_16 = (SimpleFunctionDescriptor)SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor)resolvedOverride) == null ? resolvedOverride : this.createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden((SimpleFunctionDescriptor)resolvedOverride, overriddenBuiltin, (Collection<? extends SimpleFunctionDescriptor>)allDescriptors2);
                collection.add(var16_16);
            }
            collection = (List)destination$iv$iv;
            collection3.addAll((Collection<SimpleFunctionDescriptor>)collection);
        }
    }

    private final void addOverriddenBuiltinMethods(Name name2, Collection<? extends SimpleFunctionDescriptor> alreadyDeclaredFunctions, Collection<? extends SimpleFunctionDescriptor> candidatesForOverride, Collection<SimpleFunctionDescriptor> result2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions2) {
        FunctionDescriptor overriddenBuiltin;
        block0: for (SimpleFunctionDescriptor simpleFunctionDescriptor : candidatesForOverride) {
            String nameInJava;
            if ((SimpleFunctionDescriptor)SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName((CallableMemberDescriptor)simpleFunctionDescriptor) == null) {
                continue;
            }
            if (SpecialBuiltinMembers.getJvmMethodNameIfSpecial(overriddenBuiltin) == null) {
                Intrinsics.throwNpe();
            }
            Name name3 = Name.identifier(nameInJava);
            Intrinsics.checkExpressionValueIsNotNull(name3, "Name.identifier(nameInJava)");
            for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : functions2.invoke(name3)) {
                SimpleFunctionDescriptor renamedCopy = this.createRenamedCopy(simpleFunctionDescriptor2, name2);
                if (!this.doesOverrideRenamedDescriptor((SimpleFunctionDescriptor)overriddenBuiltin, renamedCopy)) continue;
                result2.add(this.createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(renamedCopy, overriddenBuiltin, alreadyDeclaredFunctions));
                continue block0;
            }
        }
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : candidatesForOverride) {
            SimpleFunctionDescriptor simpleFunctionDescriptor3;
            if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor) == null) {
                continue;
            }
            if (this.createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(overriddenBuiltin, functions2) == null) continue;
            SimpleFunctionDescriptor simpleFunctionDescriptor4 = simpleFunctionDescriptor3;
            if (!this.isVisibleAsFunctionInCurrentClass(simpleFunctionDescriptor4)) continue;
            result2.add(this.createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(simpleFunctionDescriptor4, overriddenBuiltin, alreadyDeclaredFunctions));
        }
    }

    private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(@NotNull SimpleFunctionDescriptor $receiver, CallableDescriptor specialBuiltin, Collection<? extends SimpleFunctionDescriptor> alreadyDeclaredFunctions) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        boolean bl;
        block4: {
            Iterable $receiver$iv = alreadyDeclaredFunctions;
            for (Object element$iv : $receiver$iv) {
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv;
                if (!(Intrinsics.areEqual($receiver, it) ^ true && it.getInitialSignatureDescriptor() == null && this.doesOverride(it, specialBuiltin))) continue;
                bl = false;
                break block4;
            }
            bl = true;
        }
        if (bl) {
            simpleFunctionDescriptor = $receiver;
        } else {
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = $receiver.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
            if (simpleFunctionDescriptor2 == null) {
                Intrinsics.throwNpe();
            }
            simpleFunctionDescriptor = simpleFunctionDescriptor2;
        }
        return simpleFunctionDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor overridden, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions2) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Object v1;
        block4: {
            Name name2 = overridden.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "overridden.name");
            Iterable $receiver$iv = functions2.invoke(name2);
            for (Object element$iv : $receiver$iv) {
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv;
                if (!this.hasSameJvmDescriptorButDoesNotOverride(it, overridden)) continue;
                v1 = element$iv;
                break block4;
            }
            v1 = null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = v1;
        if (simpleFunctionDescriptor2 != null) {
            Collection<KotlinType> collection;
            void $receiver$iv$iv;
            void $receiver$iv;
            FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> copyBuilder;
            SimpleFunctionDescriptor simpleFunctionDescriptor3;
            SimpleFunctionDescriptor override = simpleFunctionDescriptor3 = simpleFunctionDescriptor2;
            FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> $receiver = copyBuilder = override.newCopyBuilder();
            Iterable $i$a$1$firstOrNull = overridden.getValueParameters();
            FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> copyBuilder2 = $receiver;
            void var9_9 = $receiver$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void it;
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)item$iv$iv;
                collection = destination$iv$iv;
                KotlinType kotlinType = it.getType();
                collection.add(kotlinType);
            }
            collection = (List)destination$iv$iv;
            Collection collection2 = collection;
            List<ValueParameterDescriptor> list = override.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(list, "override.valueParameters");
            copyBuilder2.setValueParameters(UtilKt.copyValueParameters(collection2, (Collection<? extends ValueParameterDescriptor>)list, overridden));
            $receiver.setSignatureChange();
            $receiver.setPreserveSourceElement();
            simpleFunctionDescriptor = copyBuilder.build();
        } else {
            simpleFunctionDescriptor = null;
        }
        return simpleFunctionDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name name2) {
        void var3_3;
        void $receiver$iv;
        Iterable iterable = this.getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Collection destination$iv = new LinkedHashSet();
        for (Object element$iv : $receiver$iv) {
            KotlinType it = (KotlinType)element$iv;
            Iterable list$iv = it.getMemberScope().getContributedFunctions(name2, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (Set)var3_3;
    }

    @Override
    protected void computeNonDeclaredProperties(@NotNull Name name2, @NotNull Collection<PropertyDescriptor> result2) {
        Set<PropertyDescriptor> propertiesFromSupertypes2;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(result2, "result");
        if (this.jClass.isAnnotationType()) {
            this.computeAnnotationProperties(name2, result2);
        }
        if ((propertiesFromSupertypes2 = this.getPropertiesFromSupertypes(name2)).isEmpty()) {
            return;
        }
        SmartSet propertiesOverridesFromSuperTypes = SmartSet.Companion.create();
        this.addPropertyOverrideByMethod(propertiesFromSupertypes2, result2, (Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>>)new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>(this){
            final /* synthetic */ LazyJavaClassMemberScope this$0;

            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic(this.this$0, it);
            }
            {
                this.this$0 = lazyJavaClassMemberScope;
                super(1);
            }
        });
        this.addPropertyOverrideByMethod(propertiesFromSupertypes2, propertiesOverridesFromSuperTypes, (Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>>)new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>(this){
            final /* synthetic */ LazyJavaClassMemberScope this$0;

            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.this$0, it);
            }
            {
                this.this$0 = lazyJavaClassMemberScope;
                super(1);
            }
        });
        Collection<PropertyDescriptor> collection = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name2, (Collection)SetsKt.plus(propertiesFromSupertypes2, propertiesOverridesFromSuperTypes), result2, this.getOwnerDescriptor(), this.getC().getComponents().getErrorReporter());
        Intrinsics.checkExpressionValueIsNotNull(collection, "resolveOverridesForNonSt\u2026components.errorReporter)");
        result2.addAll(collection);
    }

    private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> propertiesFromSupertypes2, Collection<PropertyDescriptor> result2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions2) {
        for (PropertyDescriptor propertyDescriptor : propertiesFromSupertypes2) {
            JavaPropertyDescriptor newProperty = this.createPropertyDescriptorByMethods(propertyDescriptor, functions2);
            if (newProperty == null) continue;
            result2.add(newProperty);
            break;
        }
    }

    private final void computeAnnotationProperties(Name name2, Collection<PropertyDescriptor> result2) {
        JavaMethod javaMethod = (JavaMethod)CollectionsKt.singleOrNull((Iterable)((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).findMethodsByName(name2));
        if (javaMethod == null) {
            return;
        }
        JavaMethod method = javaMethod;
        result2.add(LazyJavaClassMemberScope.createPropertyDescriptorWithDefaultGetter$default(this, method, null, Modality.FINAL, 2, null));
    }

    private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod method, KotlinType givenType, Modality modality) {
        KotlinType returnType;
        Annotations annotations2 = LazyJavaAnnotationsKt.resolveAnnotations(this.getC(), method);
        JavaPropertyDescriptor propertyDescriptor = JavaPropertyDescriptor.create(this.getOwnerDescriptor(), annotations2, modality, method.getVisibility(), false, method.getName(), this.getC().getComponents().getSourceElementFactory().source(method), false);
        PropertyGetterDescriptorImpl getter = DescriptorFactory.createDefaultGetter(propertyDescriptor, Annotations.Companion.getEMPTY());
        propertyDescriptor.initialize(getter, null);
        KotlinType kotlinType = givenType;
        if (kotlinType == null) {
            LazyJavaResolverContext lazyJavaResolverContext = this.getC();
            JavaPropertyDescriptor javaPropertyDescriptor = propertyDescriptor;
            Intrinsics.checkExpressionValueIsNotNull(javaPropertyDescriptor, "propertyDescriptor");
            kotlinType = this.computeMethodReturnType(method, annotations2, ContextKt.child$default(lazyJavaResolverContext, javaPropertyDescriptor, method, 0, 4, null));
        }
        KotlinType kotlinType2 = returnType = kotlinType;
        JavaPropertyDescriptor javaPropertyDescriptor = propertyDescriptor;
        List list = CollectionsKt.emptyList();
        javaPropertyDescriptor.setType(kotlinType2, list, this.getDispatchReceiverParameter(), (KotlinType)null);
        getter.initialize(returnType);
        JavaPropertyDescriptor javaPropertyDescriptor2 = propertyDescriptor;
        Intrinsics.checkExpressionValueIsNotNull(javaPropertyDescriptor2, "propertyDescriptor");
        return javaPropertyDescriptor2;
    }

    static /* bridge */ /* synthetic */ JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter$default(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaMethod javaMethod, KotlinType kotlinType, Modality modality, int n, Object object) {
        if ((n & 2) != 0) {
            kotlinType = null;
        }
        return lazyJavaClassMemberScope.createPropertyDescriptorWithDefaultGetter(javaMethod, kotlinType, modality);
    }

    private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor overriddenProperty, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions2) {
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        CallableMemberDescriptor callableMemberDescriptor;
        PropertyGetterDescriptorImpl $i$a$1$let2;
        boolean bl;
        boolean bl2;
        SimpleFunctionDescriptor setterMethod;
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        if (!this.doesClassOverridesProperty(overriddenProperty, functions2)) {
            return null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = this.findGetterOverride(overriddenProperty, functions2);
        if (simpleFunctionDescriptor2 == null) {
            Intrinsics.throwNpe();
        }
        SimpleFunctionDescriptor getterMethod = simpleFunctionDescriptor2;
        if (overriddenProperty.isVar()) {
            simpleFunctionDescriptor = this.findSetterOverride(overriddenProperty, functions2);
            if (simpleFunctionDescriptor == null) {
                Intrinsics.throwNpe();
            }
        } else {
            simpleFunctionDescriptor = null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor3 = setterMethod = simpleFunctionDescriptor;
        if (simpleFunctionDescriptor3 != null) {
            SimpleFunctionDescriptor simpleFunctionDescriptor4;
            SimpleFunctionDescriptor it = simpleFunctionDescriptor4 = simpleFunctionDescriptor3;
            bl2 = Intrinsics.areEqual((Object)it.getModality(), (Object)getterMethod.getModality());
        } else {
            bl2 = bl = true;
        }
        if (_Assertions.ENABLED && !bl) {
            SimpleFunctionDescriptor simpleFunctionDescriptor5 = setterMethod;
            String $i$a$1$let2 = "Different accessors modalities when creating overrides for " + overriddenProperty + " in " + this.getOwnerDescriptor() + ("for getter is " + (Object)((Object)getterMethod.getModality()) + ", but for setter is " + (Object)((Object)(simpleFunctionDescriptor5 != null ? simpleFunctionDescriptor5.getModality() : null)));
            throw (Throwable)((Object)new AssertionError((Object)$i$a$1$let2));
        }
        JavaPropertyDescriptor propertyDescriptor = JavaPropertyDescriptor.create(this.getOwnerDescriptor(), Annotations.Companion.getEMPTY(), getterMethod.getModality(), getterMethod.getVisibility(), setterMethod != null, overriddenProperty.getName(), getterMethod.getSource(), false);
        KotlinType kotlinType = getterMethod.getReturnType();
        if (kotlinType == null) {
            Intrinsics.throwNpe();
        }
        KotlinType kotlinType2 = kotlinType;
        JavaPropertyDescriptor javaPropertyDescriptor = propertyDescriptor;
        List list = CollectionsKt.emptyList();
        javaPropertyDescriptor.setType(kotlinType2, list, this.getDispatchReceiverParameter(), (KotlinType)null);
        PropertyGetterDescriptorImpl $receiver = $i$a$1$let2 = DescriptorFactory.createGetter(propertyDescriptor, getterMethod.getAnnotations(), false, false, false, getterMethod.getSource());
        $receiver.setInitialSignatureDescriptor(getterMethod);
        $receiver.initialize(propertyDescriptor.getType());
        PropertyGetterDescriptorImpl getter = $i$a$1$let2;
        SimpleFunctionDescriptor simpleFunctionDescriptor6 = setterMethod;
        if (simpleFunctionDescriptor6 != null) {
            PropertySetterDescriptorImpl propertySetterDescriptorImpl2;
            SimpleFunctionDescriptor setterMethod2 = callableMemberDescriptor = simpleFunctionDescriptor6;
            PropertySetterDescriptorImpl $receiver2 = propertySetterDescriptorImpl2 = DescriptorFactory.createSetter(propertyDescriptor, setterMethod2.getAnnotations(), false, false, false, setterMethod2.getVisibility(), setterMethod2.getSource());
            $receiver2.setInitialSignatureDescriptor(setterMethod2);
            propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
        } else {
            propertySetterDescriptorImpl = null;
        }
        PropertySetterDescriptorImpl setter = propertySetterDescriptorImpl;
        callableMemberDescriptor = propertyDescriptor;
        JavaPropertyDescriptor $receiver3 = (JavaPropertyDescriptor)callableMemberDescriptor;
        $receiver3.initialize(getter, setter);
        return (JavaPropertyDescriptor)callableMemberDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name name2) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)this.getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            void $receiver$iv$iv2;
            Iterable $receiver$iv2;
            KotlinType it = (KotlinType)element$iv$iv;
            Iterable iterable2 = $receiver$iv2 = (Iterable)it.getMemberScope().getContributedVariables(name2, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
            for (Object item$iv$iv : $receiver$iv$iv2) {
                void p;
                PropertyDescriptor propertyDescriptor = (PropertyDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv2;
                void var15_15 = p;
                collection.add(var15_15);
            }
            Iterable list$iv$iv = (List)destination$iv$iv2;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return CollectionsKt.toSet((List)destination$iv$iv);
    }

    @Override
    @NotNull
    protected LazyJavaScope.MethodSignatureData resolveMethodSignature(@NotNull JavaMethod method, @NotNull List<? extends TypeParameterDescriptor> methodTypeParameters, @NotNull KotlinType returnType, @NotNull List<? extends ValueParameterDescriptor> valueParameters) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        Intrinsics.checkParameterIsNotNull(methodTypeParameters, "methodTypeParameters");
        Intrinsics.checkParameterIsNotNull(returnType, "returnType");
        Intrinsics.checkParameterIsNotNull(valueParameters, "valueParameters");
        SignaturePropagator.PropagatedSignature propagated = this.getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(method, this.getOwnerDescriptor(), returnType, null, valueParameters, methodTypeParameters);
        KotlinType kotlinType = propagated.getReturnType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "propagated.returnType");
        KotlinType kotlinType2 = propagated.getReceiverType();
        List<ValueParameterDescriptor> list = propagated.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(list, "propagated.valueParameters");
        List<TypeParameterDescriptor> list2 = propagated.getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(list2, "propagated.typeParameters");
        boolean bl = propagated.hasStableParameterNames();
        List<String> list3 = propagated.getErrors();
        Intrinsics.checkExpressionValueIsNotNull(list3, "propagated.errors");
        return new LazyJavaScope.MethodSignatureData(kotlinType, kotlinType2, list, list2, bl, list3);
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(@NotNull SimpleFunctionDescriptor $receiver, FunctionDescriptor builtinWithErasedParameters) {
        return Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor($receiver, false), MethodSignatureMappingKt.computeJvmDescriptor(builtinWithErasedParameters.getOriginal(), false)) && !this.doesOverride($receiver, builtinWithErasedParameters);
    }

    /*
     * WARNING - void declaration
     */
    private final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor constructor) {
        Collection<TypeParameterDescriptor> collection;
        void $receiver$iv$iv;
        void $receiver$iv;
        ClassDescriptor classDescriptor = this.getOwnerDescriptor();
        JavaClassConstructorDescriptor constructorDescriptor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, LazyJavaAnnotationsKt.resolveAnnotations(this.getC(), constructor), false, this.getC().getComponents().getSourceElementFactory().source(constructor));
        LazyJavaResolverContext lazyJavaResolverContext = this.getC();
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = constructorDescriptor;
        Intrinsics.checkExpressionValueIsNotNull(javaClassConstructorDescriptor, "constructorDescriptor");
        LazyJavaResolverContext c = ContextKt.child(lazyJavaResolverContext, javaClassConstructorDescriptor, constructor, classDescriptor.getDeclaredTypeParameters().size());
        JavaClassConstructorDescriptor javaClassConstructorDescriptor2 = constructorDescriptor;
        Intrinsics.checkExpressionValueIsNotNull(javaClassConstructorDescriptor2, "constructorDescriptor");
        LazyJavaScope.ResolvedValueParameters valueParameters = this.resolveValueParameters(c, javaClassConstructorDescriptor2, constructor.getValueParameters());
        Iterable iterable = constructor.getTypeParameters();
        Collection collection2 = classDescriptor.getDeclaredTypeParameters();
        void var8_8 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            TypeParameterDescriptor typeParameterDescriptor;
            void p;
            JavaTypeParameter javaTypeParameter = (JavaTypeParameter)item$iv$iv;
            collection = destination$iv$iv;
            if (c.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter)p) == null) {
                Intrinsics.throwNpe();
            }
            collection.add(typeParameterDescriptor);
        }
        collection = (List)destination$iv$iv;
        List<TypeParameterDescriptor> constructorTypeParameters2 = CollectionsKt.plus(collection2, (Iterable)collection);
        constructorDescriptor.initialize(valueParameters.getDescriptors(), constructor.getVisibility(), constructorTypeParameters2);
        constructorDescriptor.setHasStableParameterNames(false);
        constructorDescriptor.setHasSynthesizedParameterNames(valueParameters.getHasSynthesizedNames());
        constructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        c.getComponents().getJavaResolverCache().recordConstructor(constructor, constructorDescriptor);
        JavaClassConstructorDescriptor javaClassConstructorDescriptor3 = constructorDescriptor;
        Intrinsics.checkExpressionValueIsNotNull(javaClassConstructorDescriptor3, "constructorDescriptor");
        return javaClassConstructorDescriptor3;
    }

    private final ClassConstructorDescriptor createDefaultConstructor() {
        List<ValueParameterDescriptor> list;
        boolean isAnnotation = this.jClass.isAnnotationType();
        if (this.jClass.isInterface() && !isAnnotation) {
            return null;
        }
        ClassDescriptor classDescriptor = this.getOwnerDescriptor();
        JavaClassConstructorDescriptor constructorDescriptor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, Annotations.Companion.getEMPTY(), true, this.getC().getComponents().getSourceElementFactory().source(this.jClass));
        if (isAnnotation) {
            JavaClassConstructorDescriptor javaClassConstructorDescriptor = constructorDescriptor;
            Intrinsics.checkExpressionValueIsNotNull(javaClassConstructorDescriptor, "constructorDescriptor");
            list = this.createAnnotationConstructorParameters(javaClassConstructorDescriptor);
        } else {
            list = Collections.emptyList();
        }
        List<ValueParameterDescriptor> valueParameters = list;
        constructorDescriptor.setHasSynthesizedParameterNames(false);
        constructorDescriptor.initialize(valueParameters, this.getConstructorVisibility(classDescriptor));
        constructorDescriptor.setHasStableParameterNames(true);
        constructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        this.getC().getComponents().getJavaResolverCache().recordConstructor(this.jClass, constructorDescriptor);
        return constructorDescriptor;
    }

    private final Visibility getConstructorVisibility(ClassDescriptor classDescriptor) {
        Visibility visibility = classDescriptor.getVisibility();
        if (Intrinsics.areEqual(visibility, JavaVisibilities.PROTECTED_STATIC_VISIBILITY)) {
            Visibility visibility2 = JavaVisibilities.PROTECTED_AND_PACKAGE;
            Intrinsics.checkExpressionValueIsNotNull(visibility2, "JavaVisibilities.PROTECTED_AND_PACKAGE");
            return visibility2;
        }
        Visibility visibility3 = visibility;
        Intrinsics.checkExpressionValueIsNotNull(visibility3, "visibility");
        return visibility3;
    }

    /*
     * WARNING - void declaration
     */
    private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl constructor) {
        void otherMethods;
        void methodsNamedValue;
        boolean bl;
        void $receiver$iv;
        Collection<JavaMethod> methods2 = this.jClass.getMethods();
        ArrayList result2 = new ArrayList(methods2.size());
        JavaTypeAttributes attr = JavaTypeResolverKt.toAttributes$default(TypeUsage.MEMBER_SIGNATURE_INVARIANT, false, true, null, 4, null);
        Iterable iterable = methods2;
        Object first$iv = new ArrayList();
        Object second$iv = new ArrayList();
        for (Object element$iv : $receiver$iv) {
            JavaMethod it = (JavaMethod)element$iv;
            if (Intrinsics.areEqual(it.getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                ((ArrayList)first$iv).add(element$iv);
                continue;
            }
            ((ArrayList)second$iv).add(element$iv);
        }
        Pair pair = new Pair(first$iv, second$iv);
        List list = pair.component1();
        List list2 = pair.component2();
        pair = null;
        boolean bl2 = bl = methodsNamedValue.size() <= 1;
        if (_Assertions.ENABLED && !bl) {
            first$iv = "There can't be more than one method named 'value' in annotation class: " + this.jClass;
            throw (Throwable)((Object)new AssertionError(first$iv));
        }
        JavaMethod methodNamedValue = (JavaMethod)CollectionsKt.firstOrNull(methodsNamedValue);
        if (methodNamedValue != null) {
            void varargType;
            void parameterType;
            JavaType parameterNamedValueJavaType = methodNamedValue.getReturnType();
            Object object = parameterNamedValueJavaType instanceof JavaArrayType ? new Pair<KotlinType, KotlinType>(this.getC().getTypeResolver().transformArrayType((JavaArrayType)parameterNamedValueJavaType, attr, true), this.getC().getTypeResolver().transformJavaType(((JavaArrayType)parameterNamedValueJavaType).getComponentType(), attr)) : new Pair<KotlinType, Object>(this.getC().getTypeResolver().transformJavaType(parameterNamedValueJavaType, attr), null);
            first$iv = (KotlinType)((Pair)object).component1();
            second$iv = (KotlinType)((Pair)object).component2();
            object = null;
            this.addAnnotationValueParameter(result2, constructor, 0, methodNamedValue, (KotlinType)parameterType, (KotlinType)varargType);
        }
        int startIndex = methodNamedValue != null ? 1 : 0;
        for (IndexedValue indexedValue : CollectionsKt.withIndex((Iterable)otherMethods)) {
            int index = indexedValue.component1();
            JavaMethod method = (JavaMethod)indexedValue.component2();
            KotlinType parameterType = this.getC().getTypeResolver().transformJavaType(method.getReturnType(), attr);
            this.addAnnotationValueParameter(result2, constructor, index + startIndex, method, parameterType, null);
        }
        return result2;
    }

    private final void addAnnotationValueParameter(@NotNull List<ValueParameterDescriptor> $receiver, ConstructorDescriptor constructor, int index, JavaMethod method, KotlinType returnType, KotlinType varargElementType) {
        KotlinType kotlinType;
        ValueParameterDescriptorImpl valueParameterDescriptorImpl;
        List<ValueParameterDescriptor> list = $receiver;
        ValueParameterDescriptorImpl valueParameterDescriptorImpl2 = valueParameterDescriptorImpl;
        ValueParameterDescriptorImpl valueParameterDescriptorImpl3 = valueParameterDescriptorImpl;
        CallableDescriptor callableDescriptor = constructor;
        ValueParameterDescriptor valueParameterDescriptor = null;
        int n = index;
        Annotations annotations2 = Annotations.Companion.getEMPTY();
        Name name2 = method.getName();
        KotlinType kotlinType2 = TypeUtils.makeNotNullable(returnType);
        KotlinType kotlinType3 = kotlinType2;
        Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "TypeUtils.makeNotNullable(returnType)");
        boolean bl = method.getHasAnnotationParameterDefaultValue();
        boolean bl2 = false;
        boolean bl3 = false;
        KotlinType kotlinType4 = varargElementType;
        if (kotlinType4 != null) {
            KotlinType kotlinType5 = kotlinType4;
            boolean bl4 = bl3;
            boolean bl5 = bl2;
            boolean bl6 = bl;
            KotlinType kotlinType6 = kotlinType3;
            Name name3 = name2;
            Annotations annotations3 = annotations2;
            int n2 = n;
            ValueParameterDescriptor valueParameterDescriptor2 = valueParameterDescriptor;
            CallableDescriptor callableDescriptor2 = callableDescriptor;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl4 = valueParameterDescriptorImpl2;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl5 = valueParameterDescriptorImpl3;
            List<ValueParameterDescriptor> list2 = list;
            KotlinType it = kotlinType5;
            KotlinType kotlinType7 = TypeUtils.makeNotNullable(it);
            list = list2;
            valueParameterDescriptorImpl3 = valueParameterDescriptorImpl5;
            valueParameterDescriptorImpl2 = valueParameterDescriptorImpl4;
            callableDescriptor = callableDescriptor2;
            valueParameterDescriptor = valueParameterDescriptor2;
            n = n2;
            annotations2 = annotations3;
            name2 = name3;
            kotlinType3 = kotlinType6;
            bl = bl6;
            bl2 = bl5;
            bl3 = bl4;
            kotlinType = kotlinType7;
        } else {
            kotlinType = null;
        }
        valueParameterDescriptorImpl2(callableDescriptor, valueParameterDescriptor, n, annotations2, name2, kotlinType3, bl, bl2, bl3, kotlinType, this.getC().getComponents().getSourceElementFactory().source(method));
        list.add(valueParameterDescriptorImpl3);
    }

    @Override
    @Nullable
    protected ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(this.getOwnerDescriptor());
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        this.recordLookup(name2, location);
        return (ClassifierDescriptor)this.nestedClasses.invoke(name2);
    }

    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        this.recordLookup(name2, location);
        return super.getContributedFunctions(name2, location);
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        this.recordLookup(name2, location);
        return super.getContributedVariables(name2, location);
    }

    @Override
    @NotNull
    protected Set<Name> computeClassNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        return SetsKt.plus(((Map)this.nestedClassIndex.invoke()).keySet(), ((Map)this.enumEntryIndex.invoke()).keySet());
    }

    @Override
    @NotNull
    protected Set<Name> computePropertyNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        if (this.jClass.isAnnotationType()) {
            return this.getFunctionNames();
        }
        LinkedHashSet result2 = new LinkedHashSet(((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).getFieldNames());
        Iterable $receiver$iv = this.getOwnerDescriptor().getTypeConstructor().getSupertypes();
        for (Object element$iv : $receiver$iv) {
            KotlinType supertype = (KotlinType)element$iv;
            Iterable list$iv = supertype.getMemberScope().getVariableNames();
            CollectionsKt.addAll((Collection)result2, list$iv);
        }
        return (Set)((Collection)result2);
    }

    private final void recordLookup(Name name2, LookupLocation from) {
        UtilsKt.record(this.getC().getComponents().getLookupTracker(), from, this.getOwnerDescriptor(), name2);
    }

    @Override
    @NotNull
    public String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }

    @Override
    @NotNull
    protected ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    public LazyJavaClassMemberScope(@NotNull LazyJavaResolverContext c, @NotNull ClassDescriptor ownerDescriptor, @NotNull JavaClass jClass) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(ownerDescriptor, "ownerDescriptor");
        Intrinsics.checkParameterIsNotNull(jClass, "jClass");
        super(c);
        this.ownerDescriptor = ownerDescriptor;
        this.jClass = jClass;
        this.constructors = c.getStorageManager().createLazyValue((Function0)new Function0<List<? extends ClassConstructorDescriptor>>(this, c){
            final /* synthetic */ LazyJavaClassMemberScope this$0;
            final /* synthetic */ LazyJavaResolverContext $c;

            @NotNull
            public final List<ClassConstructorDescriptor> invoke() {
                Collection<JavaConstructor> constructors2 = LazyJavaClassMemberScope.access$getJClass$p(this.this$0).getConstructors();
                ArrayList<JavaClassConstructorDescriptor> result2 = new ArrayList<JavaClassConstructorDescriptor>(constructors2.size());
                for (JavaConstructor constructor : constructors2) {
                    JavaClassConstructorDescriptor descriptor2 = LazyJavaClassMemberScope.access$resolveConstructor(this.this$0, constructor);
                    result2.add(descriptor2);
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)result2, this.$c.getComponents().getSamConversionResolver().resolveSamAdapter((FunctionDescriptor)descriptor2));
                }
                Collection $receiver$iv = result2;
                return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList(SignatureEnhancementKt.enhanceSignatures($receiver$iv.isEmpty() ? (Collection)kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.emptyOrSingletonList(LazyJavaClassMemberScope.access$createDefaultConstructor(this.this$0)) : $receiver$iv));
            }
            {
                this.this$0 = lazyJavaClassMemberScope;
                this.$c = lazyJavaResolverContext;
                super(0);
            }
        });
        this.nestedClassIndex = c.getStorageManager().createLazyValue((Function0)new Function0<Map<Name, ? extends JavaClass>>(this){
            final /* synthetic */ LazyJavaClassMemberScope this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final Map<Name, JavaClass> invoke() {
                void $receiver$iv$iv;
                Iterable $receiver$iv = LazyJavaClassMemberScope.access$getJClass$p(this.this$0).getInnerClasses();
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
                Iterable iterable = $receiver$iv;
                Map destination$iv$iv = new LinkedHashMap<K, V>(capacity$iv);
                for (T element$iv$iv : $receiver$iv$iv) {
                    void c;
                    JavaClass javaClass = (JavaClass)element$iv$iv;
                    Map map2 = destination$iv$iv;
                    Name name2 = c.getName();
                    map2.put(name2, element$iv$iv);
                }
                return destination$iv$iv;
            }
            {
                this.this$0 = lazyJavaClassMemberScope;
                super(0);
            }
        });
        this.enumEntryIndex = c.getStorageManager().createLazyValue((Function0)new Function0<Map<Name, ? extends JavaField>>(this){
            final /* synthetic */ LazyJavaClassMemberScope this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final Map<Name, JavaField> invoke() {
                void $receiver$iv$iv;
                void $receiver$iv$iv2;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)LazyJavaClassMemberScope.access$getJClass$p(this.this$0).getFields();
                Iterable<E> destination$iv$iv = new ArrayList<E>();
                for (T element$iv$iv : $receiver$iv$iv2) {
                    JavaField it = (JavaField)element$iv$iv;
                    if (!it.isEnumEntry()) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $receiver$iv = (List)destination$iv$iv;
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
                destination$iv$iv = $receiver$iv;
                Map destination$iv$iv2 = new LinkedHashMap<K, V>(capacity$iv);
                for (T element$iv$iv : $receiver$iv$iv) {
                    void f;
                    JavaField $i$a$1$filter = (JavaField)element$iv$iv;
                    Map map2 = destination$iv$iv2;
                    Name name2 = f.getName();
                    map2.put(name2, element$iv$iv);
                }
                return destination$iv$iv2;
            }
            {
                this.this$0 = lazyJavaClassMemberScope;
                super(0);
            }
        });
        this.nestedClasses = c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new Function1<Name, ClassDescriptorBase>(this, c){
            final /* synthetic */ LazyJavaClassMemberScope this$0;
            final /* synthetic */ LazyJavaResolverContext $c;

            @Nullable
            public final ClassDescriptorBase invoke(@NotNull Name name2) {
                ClassDescriptorBase classDescriptorBase;
                Intrinsics.checkParameterIsNotNull(name2, "name");
                JavaClass jNestedClass = (JavaClass)((Map)LazyJavaClassMemberScope.access$getNestedClassIndex$p(this.this$0).invoke()).get(name2);
                if (jNestedClass == null) {
                    EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor;
                    JavaField field = (JavaField)((Map)LazyJavaClassMemberScope.access$getEnumEntryIndex$p(this.this$0).invoke()).get(name2);
                    if (field != null) {
                        NotNullLazyValue<Set<Name>> enumMemberNames2 = this.$c.getStorageManager().createLazyValue((Function0)new Function0<Set<? extends Name>>(this){
                            final /* synthetic */ nestedClasses.1 this$0;

                            @NotNull
                            public final Set<Name> invoke() {
                                return SetsKt.plus(this.this$0.this$0.getFunctionNames(), (Iterable)this.this$0.this$0.getVariableNames());
                            }
                            {
                                this.this$0 = var1_1;
                                super(0);
                            }
                        });
                        enumEntrySyntheticClassDescriptor = EnumEntrySyntheticClassDescriptor.create(this.$c.getStorageManager(), this.this$0.getOwnerDescriptor(), name2, enumMemberNames2, LazyJavaAnnotationsKt.resolveAnnotations(this.$c, field), this.$c.getComponents().getSourceElementFactory().source(field));
                    } else {
                        enumEntrySyntheticClassDescriptor = null;
                    }
                    classDescriptorBase = enumEntrySyntheticClassDescriptor;
                } else {
                    classDescriptorBase = new LazyJavaClassDescriptor(this.$c, this.this$0.getOwnerDescriptor(), jNestedClass, null, 8, null);
                }
                return classDescriptorBase;
            }
            {
                this.this$0 = lazyJavaClassMemberScope;
                this.$c = lazyJavaResolverContext;
                super(1);
            }
        });
    }

    @NotNull
    public static final /* synthetic */ Collection access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope $this, @NotNull Name name2) {
        return $this.searchMethodsByNameWithoutBuiltinMagic(name2);
    }

    @NotNull
    public static final /* synthetic */ Collection access$searchMethodsInSupertypesWithoutBuiltinMagic(LazyJavaClassMemberScope $this, @NotNull Name name2) {
        return $this.searchMethodsInSupertypesWithoutBuiltinMagic(name2);
    }

    @NotNull
    public static final /* synthetic */ JavaClass access$getJClass$p(LazyJavaClassMemberScope $this) {
        return $this.jClass;
    }

    @NotNull
    public static final /* synthetic */ JavaClassConstructorDescriptor access$resolveConstructor(LazyJavaClassMemberScope $this, @NotNull JavaConstructor constructor) {
        return $this.resolveConstructor(constructor);
    }

    @Nullable
    public static final /* synthetic */ ClassConstructorDescriptor access$createDefaultConstructor(LazyJavaClassMemberScope $this) {
        return $this.createDefaultConstructor();
    }

    @NotNull
    public static final /* synthetic */ NotNullLazyValue access$getNestedClassIndex$p(LazyJavaClassMemberScope $this) {
        return $this.nestedClassIndex;
    }

    @NotNull
    public static final /* synthetic */ NotNullLazyValue access$getEnumEntryIndex$p(LazyJavaClassMemberScope $this) {
        return $this.enumEntryIndex;
    }
}

