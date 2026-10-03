/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibilityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$WhenMappings;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorUtilsKt {
    @NotNull
    public static final ClassDescriptor getClassObjectReferenceTarget(@NotNull ClassDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassDescriptor classDescriptor = $receiver.getCompanionObjectDescriptor();
        if (classDescriptor == null) {
            classDescriptor = $receiver;
        }
        return classDescriptor;
    }

    @NotNull
    public static final DeclarationDescriptor getImportableDescriptor(@NotNull DeclarationDescriptor $receiver) {
        DeclarationDescriptor declarationDescriptor;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver instanceof TypeAliasConstructorDescriptor) {
            declarationDescriptor = ((TypeAliasConstructorDescriptor)$receiver).getContainingDeclaration();
        } else if ($receiver instanceof ConstructorDescriptor) {
            ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = ((ConstructorDescriptor)$receiver).getContainingDeclaration();
            Intrinsics.checkExpressionValueIsNotNull(classifierDescriptorWithTypeParameters, "containingDeclaration");
            declarationDescriptor = classifierDescriptorWithTypeParameters;
        } else if ($receiver instanceof PropertyAccessorDescriptor) {
            PropertyDescriptor propertyDescriptor = ((PropertyAccessorDescriptor)$receiver).getCorrespondingProperty();
            Intrinsics.checkExpressionValueIsNotNull(propertyDescriptor, "correspondingProperty");
            declarationDescriptor = propertyDescriptor;
        } else {
            declarationDescriptor = $receiver;
        }
        return declarationDescriptor;
    }

    @NotNull
    public static final FqNameUnsafe getFqNameUnsafe(@NotNull DeclarationDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        FqNameUnsafe fqNameUnsafe = DescriptorUtils.getFqName($receiver);
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "DescriptorUtils.getFqName(this)");
        return fqNameUnsafe;
    }

    @NotNull
    public static final FqName getFqNameSafe(@NotNull DeclarationDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        FqName fqName2 = DescriptorUtils.getFqNameSafe($receiver);
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "DescriptorUtils.getFqNameSafe(this)");
        return fqName2;
    }

    public static final boolean isExtension(@NotNull DeclarationDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver instanceof CallableDescriptor && ((CallableDescriptor)$receiver).getExtensionReceiverParameter() != null;
    }

    @NotNull
    public static final ModuleDescriptor getModule(@NotNull DeclarationDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ModuleDescriptor moduleDescriptor = DescriptorUtils.getContainingModule($receiver);
        Intrinsics.checkExpressionValueIsNotNull(moduleDescriptor, "DescriptorUtils.getContainingModule(this)");
        return moduleDescriptor;
    }

    @Nullable
    public static final ClassDescriptor resolveTopLevelClass(@NotNull ModuleDescriptor $receiver, @NotNull FqName topLevelClassFqName, @NotNull LookupLocation location) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(topLevelClassFqName, "topLevelClassFqName");
        Intrinsics.checkParameterIsNotNull(location, "location");
        boolean bl2 = bl = !topLevelClassFqName.isRoot();
        if (_Assertions.ENABLED && !bl) {
            String string = "Assertion failed";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        FqName fqName2 = topLevelClassFqName.parent();
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "topLevelClassFqName.parent()");
        MemberScope memberScope2 = $receiver.getPackage(fqName2).getMemberScope();
        Name name2 = topLevelClassFqName.shortName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "topLevelClassFqName.shortName()");
        ClassifierDescriptor classifierDescriptor = memberScope2.getContributedClassifier(name2, location);
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        return (ClassDescriptor)classifierDescriptor;
    }

    @Nullable
    public static final ClassDescriptor getDenotedClassDescriptor(@NotNull ClassifierDescriptorWithTypeParameters $receiver) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = $receiver;
        if (classifierDescriptorWithTypeParameters instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor)$receiver;
        } else if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
            classDescriptor = ((TypeAliasDescriptor)$receiver).getClassDescriptor();
        } else {
            throw (Throwable)new UnsupportedOperationException("Unexpected descriptor kind: " + $receiver);
        }
        return classDescriptor;
    }

    @Nullable
    public static final ClassId getClassId(@NotNull ClassifierDescriptorWithTypeParameters $receiver) {
        ClassId classId;
        DeclarationDescriptor declarationDescriptor;
        DeclarationDescriptor owner;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        DeclarationDescriptor declarationDescriptor2 = owner = (declarationDescriptor = $receiver.getContainingDeclaration());
        if (declarationDescriptor2 instanceof PackageFragmentDescriptor) {
            classId = new ClassId(((PackageFragmentDescriptor)owner).getFqName(), $receiver.getName());
        } else if (declarationDescriptor2 instanceof ClassifierDescriptorWithTypeParameters) {
            ClassId classId2 = DescriptorUtilsKt.getClassId((ClassifierDescriptorWithTypeParameters)owner);
            classId = classId2 != null ? classId2.createNestedClassId($receiver.getName()) : null;
        } else {
            classId = null;
        }
        return classId;
    }

    public static final boolean getHasCompanionObject(@NotNull ClassifierDescriptorWithTypeParameters $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getDenotedClassDescriptor($receiver);
        return (classDescriptor != null ? classDescriptor.getCompanionObjectDescriptor() : null) != null;
    }

    public static final boolean getHasClassValueDescriptor(@NotNull ClassDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return DescriptorUtilsKt.getClassValueDescriptor($receiver) != null;
    }

    @Nullable
    public static final ClassDescriptor getClassValueDescriptor(@NotNull ClassifierDescriptorWithTypeParameters $receiver) {
        ClassDescriptor classDescriptor;
        ClassDescriptor it;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassDescriptor classDescriptor2 = DescriptorUtilsKt.getDenotedClassDescriptor($receiver);
        return classDescriptor2 != null ? ((it = (classDescriptor = classDescriptor2)).getKind().isSingleton() ? it : it.getCompanionObjectDescriptor()) : null;
    }

    @Nullable
    public static final ClassDescriptor getClassValueTypeDescriptor(@NotNull ClassifierDescriptorWithTypeParameters $receiver) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassDescriptor classDescriptor2 = DescriptorUtilsKt.getDenotedClassDescriptor($receiver);
        if (classDescriptor2 != null) {
            ClassDescriptor classDescriptor3;
            ClassDescriptor classDescriptor4;
            ClassDescriptor it = classDescriptor4 = classDescriptor2;
            switch (DescriptorUtilsKt$WhenMappings.$EnumSwitchMapping$0[it.getKind().ordinal()]) {
                case 1: {
                    classDescriptor3 = it;
                    break;
                }
                case 2: {
                    boolean bl;
                    DeclarationDescriptor container = $receiver.getContainingDeclaration();
                    boolean bl2 = bl = container instanceof ClassDescriptor && Intrinsics.areEqual((Object)((ClassDescriptor)container).getKind(), (Object)ClassKind.ENUM_CLASS);
                    if (_Assertions.ENABLED && !bl) {
                        String string = "Assertion failed";
                        throw (Throwable)((Object)new AssertionError((Object)string));
                    }
                    DeclarationDescriptor declarationDescriptor = container;
                    if (declarationDescriptor == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    }
                    classDescriptor3 = (ClassDescriptor)declarationDescriptor;
                    break;
                }
                default: {
                    classDescriptor3 = it.getCompanionObjectDescriptor();
                }
            }
            classDescriptor = classDescriptor3;
        } else {
            classDescriptor = null;
        }
        return classDescriptor;
    }

    @Nullable
    public static final KotlinType getClassValueType(@NotNull ClassDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getClassValueTypeDescriptor($receiver);
        return classDescriptor != null ? classDescriptor.getDefaultType() : null;
    }

    public static final boolean isEffectivelyPublicApi(@NotNull DeclarationDescriptorWithVisibility $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return EffectiveVisibilityKt.effectiveVisibility$default($receiver, null, false, 3, null).getPublicApi();
    }

    public static final boolean isEffectivelyPrivateApi(@NotNull DeclarationDescriptorWithVisibility $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return EffectiveVisibilityKt.effectiveVisibility$default($receiver, null, false, 3, null).getPrivateApi();
    }

    public static final boolean isInsidePrivateClass(@NotNull DeclarationDescriptor $receiver) {
        ClassDescriptor parent;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        DeclarationDescriptor declarationDescriptor = $receiver.getContainingDeclaration();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        return (parent = (ClassDescriptor)declarationDescriptor) != null && Visibilities.isPrivate(parent.getVisibility());
    }

    @Nullable
    public static final ClassDescriptor getSuperClassNotAny(@NotNull ClassDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        for (KotlinType supertype : $receiver.getDefaultType().getConstructor().getSupertypes()) {
            ClassifierDescriptor superClassifier;
            if (KotlinBuiltIns.isAnyOrNullableAny(supertype) || !DescriptorUtils.isClassOrEnumClass(superClassifier = supertype.getConstructor().getDeclarationDescriptor())) continue;
            ClassifierDescriptor classifierDescriptor = superClassifier;
            if (classifierDescriptor == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            return (ClassDescriptor)classifierDescriptor;
        }
        return null;
    }

    @NotNull
    public static final ClassDescriptor getSuperClassOrAny(@NotNull ClassDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getSuperClassNotAny($receiver);
        if (classDescriptor == null) {
            ClassDescriptor classDescriptor2 = DescriptorUtilsKt.getBuiltIns($receiver).getAny();
            classDescriptor = classDescriptor2;
            Intrinsics.checkExpressionValueIsNotNull(classDescriptor2, "builtIns.any");
        }
        return classDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ClassDescriptor> getSuperInterfaces(@NotNull ClassDescriptor $receiver) {
        void var3_3;
        Iterable $receiver$iv$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable $receiver$iv = $receiver.getDefaultType().getConstructor().getSupertypes();
        Iterable iterable = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KotlinType it = (KotlinType)element$iv$iv;
            if (KotlinBuiltIns.isAnyOrNullableAny(it)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList();
        Iterable $receiver$iv$iv$iv = $receiver$iv$iv;
        for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
            ClassDescriptor classDescriptor;
            ClassDescriptor classDescriptor2;
            Object element$iv$iv = element$iv$iv$iv;
            KotlinType it = (KotlinType)element$iv$iv;
            ClassifierDescriptor superClassifier = it.getConstructor().getDeclarationDescriptor();
            if (DescriptorUtils.isInterface(superClassifier)) {
                ClassifierDescriptor classifierDescriptor = superClassifier;
                if (classifierDescriptor == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
                classDescriptor2 = (ClassDescriptor)classifierDescriptor;
            } else {
                classDescriptor2 = null;
            }
            if (classDescriptor2 == null) continue;
            ClassDescriptor it$iv$iv = classDescriptor = classDescriptor2;
            destination$iv$iv.add(it$iv$iv);
        }
        return (List)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ClassConstructorDescriptor> getSecondaryConstructors(@NotNull ClassDescriptor $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getConstructors();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            ClassConstructorDescriptor it = (ClassConstructorDescriptor)element$iv$iv;
            if (it.isPrimary()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @NotNull
    public static final KotlinBuiltIns getBuiltIns(@NotNull DeclarationDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return DescriptorUtilsKt.getModule($receiver).getBuiltIns();
    }

    @Nullable
    public static final DeclarationDescriptor getOwnerForEffectiveDispatchReceiverParameter(@NotNull CallableDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver instanceof CallableMemberDescriptor && Intrinsics.areEqual((Object)((CallableMemberDescriptor)$receiver).getKind(), (Object)CallableMemberDescriptor.Kind.FAKE_OVERRIDE)) {
            return $receiver.getContainingDeclaration();
        }
        ReceiverParameterDescriptor receiverParameterDescriptor = $receiver.getDispatchReceiverParameter();
        return receiverParameterDescriptor != null ? receiverParameterDescriptor.getContainingDeclaration() : null;
    }

    public static final boolean hasDefaultValue(@NotNull ValueParameterDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Boolean bl = DFS.ifAny((Collection)CollectionsKt.listOf($receiver), hasDefaultValue.1.INSTANCE, hasDefaultValue.2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(bl, "DFS.ifAny(\n            l\u2026eclaresDefaultValue\n    )");
        return bl;
    }

    public static final boolean hasOrInheritsParametersWithDefaultValue(@NotNull FunctionDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Boolean bl = DFS.ifAny((Collection)CollectionsKt.listOf($receiver), hasOrInheritsParametersWithDefaultValue.1.INSTANCE, hasOrInheritsParametersWithDefaultValue.2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(bl, "DFS.ifAny(\n        listO\u2026ersWithDefaultValue() }\n)");
        return bl;
    }

    public static final boolean hasOwnParametersWithDefaultValue(@NotNull FunctionDescriptor $receiver) {
        boolean bl;
        block1: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Iterable $receiver$iv = $receiver.getOriginal().getValueParameters();
            for (Object element$iv : $receiver$iv) {
                ValueParameterDescriptor it = (ValueParameterDescriptor)element$iv;
                if (!it.declaresDefaultValue()) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }

    public static final boolean isRepeatableAnnotation(@NotNull Annotated $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Annotations annotations2 = $receiver.getAnnotations();
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.repeatable;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.repeatable");
        return annotations2.findAnnotation(fqName2) != null;
    }

    public static final boolean isDocumentedAnnotation(@NotNull Annotated $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Annotations annotations2 = $receiver.getAnnotations();
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.mustBeDocumented;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
        return annotations2.findAnnotation(fqName2) != null;
    }

    @Nullable
    public static final KotlinRetention getAnnotationRetention(@NotNull Annotated $receiver) {
        Object v3;
        block4: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Annotations annotations2 = $receiver.getAnnotations();
            FqName fqName2 = KotlinBuiltIns.FQ_NAMES.retention;
            Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.retention");
            AnnotationDescriptor annotationDescriptor = annotations2.findAnnotation(fqName2);
            if (annotationDescriptor == null) {
                return null;
            }
            AnnotationDescriptor annotationEntryDescriptor = annotationDescriptor;
            Iterable $receiver$iv = annotationEntryDescriptor.getAllValueArguments().entrySet();
            for (Object element$iv : $receiver$iv) {
                Map.Entry it = (Map.Entry)element$iv;
                if (!Intrinsics.areEqual(((ValueParameterDescriptor)it.getKey()).getName().asString(), "value")) continue;
                v3 = element$iv;
                break block4;
            }
            v3 = null;
        }
        Map.Entry entry = v3;
        ConstantValue constantValue = entry != null ? (ConstantValue)entry.getValue() : null;
        if (!(constantValue instanceof EnumValue)) {
            constantValue = null;
        }
        EnumValue enumValue = (EnumValue)constantValue;
        if (enumValue == null) {
            return null;
        }
        EnumValue retentionArgumentValue = enumValue;
        String string = ((ClassDescriptor)retentionArgumentValue.getValue()).getName().asString();
        Intrinsics.checkExpressionValueIsNotNull(string, "retentionArgumentValue.value.name.asString()");
        return KotlinRetention.valueOf(string);
    }

    @NotNull
    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(@NotNull DeclarationDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return SequencesKt.generateSequence($receiver, (Function1)parentsWithSelf.1.INSTANCE);
    }

    @NotNull
    public static final Sequence<DeclarationDescriptor> getParents(@NotNull DeclarationDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return SequencesKt.drop(DescriptorUtilsKt.getParentsWithSelf($receiver), 1);
    }

    @NotNull
    public static final CallableMemberDescriptor getPropertyIfAccessor(@NotNull CallableMemberDescriptor $receiver) {
        CallableMemberDescriptor callableMemberDescriptor;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver instanceof PropertyAccessorDescriptor) {
            PropertyDescriptor propertyDescriptor = ((PropertyAccessorDescriptor)$receiver).getCorrespondingProperty();
            Intrinsics.checkExpressionValueIsNotNull(propertyDescriptor, "correspondingProperty");
            callableMemberDescriptor = propertyDescriptor;
        } else {
            callableMemberDescriptor = $receiver;
        }
        return callableMemberDescriptor;
    }

    @Nullable
    public static final FqName fqNameOrNull(@NotNull CallableDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        FqNameUnsafe fqNameUnsafe = AddToStdlibKt.check(DescriptorUtilsKt.getFqNameUnsafe($receiver), fqNameOrNull.1.INSTANCE);
        return fqNameUnsafe != null ? fqNameUnsafe.toSafe() : null;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final CallableMemberDescriptor firstOverridden(@NotNull CallableMemberDescriptor $receiver, boolean useOriginal, @NotNull Function1<? super CallableMemberDescriptor, Boolean> predicate) {
        void result2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        return (CallableMemberDescriptor)DFS.dfs((Collection)CollectionsKt.listOf($receiver), new DFS.Neighbors<N>(useOriginal){
            final /* synthetic */ boolean $useOriginal;

            @NotNull
            public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor current) {
                CallableMemberDescriptor descriptor2;
                Object object;
                CallableMemberDescriptor callableMemberDescriptor;
                if (this.$useOriginal) {
                    CallableMemberDescriptor callableMemberDescriptor2 = current;
                    callableMemberDescriptor = callableMemberDescriptor2 != null ? callableMemberDescriptor2.getOriginal() : null;
                } else {
                    callableMemberDescriptor = current;
                }
                return (object = (descriptor2 = callableMemberDescriptor)) != null && (object = object.getOverriddenDescriptors()) != null ? (Iterable)object : (Iterable)CollectionsKt.emptyList();
            }
            {
                this.$useOriginal = bl;
            }
        }, new DFS.AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor>((Ref.ObjectRef)result2, predicate){
            final /* synthetic */ Ref.ObjectRef $result;
            final /* synthetic */ Function1 $predicate;

            public boolean beforeChildren(@NotNull CallableMemberDescriptor current) {
                Intrinsics.checkParameterIsNotNull(current, "current");
                return (CallableMemberDescriptor)this.$result.element == null;
            }

            public void afterChildren(@NotNull CallableMemberDescriptor current) {
                Intrinsics.checkParameterIsNotNull(current, "current");
                if ((CallableMemberDescriptor)this.$result.element == null && ((Boolean)this.$predicate.invoke(current)).booleanValue()) {
                    this.$result.element = current;
                }
            }

            @Nullable
            public CallableMemberDescriptor result() {
                return (CallableMemberDescriptor)this.$result.element;
            }
            {
                this.$result = $captured_local_variable$0;
                this.$predicate = $captured_local_variable$1;
            }
        });
    }

    @Nullable
    public static /* bridge */ /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor callableMemberDescriptor, boolean bl, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        return DescriptorUtilsKt.firstOverridden(callableMemberDescriptor, bl, function1);
    }

    public static final void setSingleOverridden(@NotNull CallableMemberDescriptor $receiver, @NotNull CallableMemberDescriptor overridden) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(overridden, "overridden");
        $receiver.setOverriddenDescriptors((Collection<? extends CallableMemberDescriptor>)CollectionsKt.listOf(overridden));
    }

    @NotNull
    public static final Sequence<CallableMemberDescriptor> overriddenTreeAsSequence(@NotNull CallableMemberDescriptor $receiver, boolean useOriginal) {
        CallableMemberDescriptor callableMemberDescriptor;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CallableMemberDescriptor $receiver2 = callableMemberDescriptor = useOriginal ? $receiver.getOriginal() : $receiver;
        return SequencesKt.plus(SequencesKt.sequenceOf($receiver2), SequencesKt.flatMap(CollectionsKt.asSequence((Iterable)$receiver2.getOverriddenDescriptors()), (Function1)new Function1<CallableMemberDescriptor, Sequence<? extends CallableMemberDescriptor>>(useOriginal){
            final /* synthetic */ boolean $useOriginal$inlined;
            {
                this.$useOriginal$inlined = bl;
                super(1);
            }

            public final Sequence<CallableMemberDescriptor> invoke(CallableMemberDescriptor it) {
                return DescriptorUtilsKt.overriddenTreeAsSequence(it, this.$useOriginal$inlined);
            }
        }));
    }

    @NotNull
    public static final <D extends CallableDescriptor> Sequence<D> overriddenTreeUniqueAsSequence(@NotNull D $receiver, boolean useOriginal) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        HashSet set = new HashSet();
        Function1 doBuildOverriddenTreeAsSequence$ = new Function1<D, Sequence<? extends D>>(useOriginal, set){
            final /* synthetic */ boolean $useOriginal;
            final /* synthetic */ HashSet $set;

            @NotNull
            public final Sequence<D> invoke(@NotNull D $receiver) {
                Sequence<Object> sequence;
                Object object;
                Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                if (this.$useOriginal) {
                    CallableDescriptor callableDescriptor = $receiver.getOriginal();
                    if (callableDescriptor == null) {
                        throw new TypeCastException("null cannot be cast to non-null type D");
                    }
                    object = callableDescriptor;
                } else {
                    object = $receiver;
                }
                D d = object;
                CallableDescriptor $receiver2 = (CallableDescriptor)d;
                if (CollectionsKt.contains(this.$set, $receiver2.getOriginal())) {
                    sequence = SequencesKt.emptySequence();
                } else {
                    Collection collection = this.$set;
                    CallableDescriptor callableDescriptor = $receiver2.getOriginal();
                    if (callableDescriptor == null) {
                        throw new TypeCastException("null cannot be cast to non-null type D");
                    }
                    CallableDescriptor callableDescriptor2 = callableDescriptor;
                    collection.add(callableDescriptor2);
                    Collection<? extends CallableDescriptor> collection2 = $receiver2.getOverriddenDescriptors();
                    if (collection2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<D>");
                    }
                    sequence = SequencesKt.plus(SequencesKt.sequenceOf($receiver2), SequencesKt.flatMap(CollectionsKt.asSequence((Iterable)collection2), (Function1)new Function1<D, Sequence<? extends D>>(this){
                        final /* synthetic */ overriddenTreeUniqueAsSequence.1 this$0;
                        {
                            this.this$0 = var1_1;
                            super(1);
                        }

                        public final Sequence<D> invoke(D it) {
                            return this.this$0.invoke(it);
                        }
                    }));
                }
                return sequence;
            }
            {
                this.$useOriginal = bl;
                this.$set = hashSet;
                super(1);
            }
        };
        return doBuildOverriddenTreeAsSequence$.invoke($receiver);
    }

    public static final int varargParameterPosition(@NotNull CallableDescriptor $receiver) {
        int n;
        block2: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            List<ValueParameterDescriptor> $receiver$iv = $receiver.getValueParameters();
            int index$iv = 0;
            for (ValueParameterDescriptor item$iv : $receiver$iv) {
                ValueParameterDescriptor it = item$iv;
                if (it.getVarargElementType() != null) {
                    n = index$iv;
                    break block2;
                }
                ++index$iv;
            }
            n = -1;
        }
        return n;
    }

    @Nullable
    public static final List<TypeProjection> findImplicitOuterClassArguments(@NotNull ClassDescriptor scopeOwner, @NotNull ClassDescriptor outerClass) {
        Intrinsics.checkParameterIsNotNull(scopeOwner, "scopeOwner");
        Intrinsics.checkParameterIsNotNull(outerClass, "outerClass");
        Iterator<ClassDescriptor> iterator2 = DescriptorUtilsKt.classesFromInnerToOuter(scopeOwner).iterator();
        while (iterator2.hasNext()) {
            ClassDescriptor current = iterator2.next();
            for (KotlinType supertype : DescriptorUtilsKt.getAllSuperClassesTypesIncludeItself(current)) {
                ClassifierDescriptor classifierDescriptor = supertype.getConstructor().getDeclarationDescriptor();
                if (classifierDescriptor == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
                ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
                if (!Intrinsics.areEqual(classDescriptor, outerClass)) continue;
                return supertype.getArguments();
            }
        }
        return null;
    }

    private static final Sequence<ClassDescriptor> classesFromInnerToOuter(@NotNull ClassDescriptor $receiver) {
        return SequencesKt.generateSequence($receiver, (Function1)classesFromInnerToOuter.1.INSTANCE);
    }

    private static final List<KotlinType> getAllSuperClassesTypesIncludeItself(@NotNull ClassDescriptor $receiver) {
        ArrayList<KotlinType> result2 = new ArrayList<KotlinType>();
        SimpleType simpleType2 = $receiver.getDefaultType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "defaultType");
        KotlinType current = simpleType2;
        while (!TypeUtilsKt.isAnyOrNullableAny(current)) {
            result2.add(current);
            ClassifierDescriptor classifierDescriptor = current.getConstructor().getDeclarationDescriptor();
            if (classifierDescriptor == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            KotlinType next = DescriptorUtils.getSuperClassType((ClassDescriptor)classifierDescriptor);
            if (TypeSubstitutor.create(current).substitute(next, Variance.INVARIANT) != null) continue;
            break;
        }
        return result2;
    }

    public static final boolean isEnumValueOfMethod(@NotNull FunctionDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        List<ValueParameterDescriptor> methodTypeParameters = $receiver.getValueParameters();
        KotlinType nullableString = TypeUtilsKt.makeNullable(DescriptorUtilsKt.getBuiltIns($receiver).getStringType());
        return Intrinsics.areEqual(DescriptorUtils.ENUM_VALUE_OF, $receiver.getName()) && methodTypeParameters.size() == 1 && KotlinTypeChecker.DEFAULT.isSubtypeOf(methodTypeParameters.get(0).getType(), nullableString);
    }

    public static final boolean isExtensionProperty(@NotNull DeclarationDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver instanceof PropertyDescriptor && ((PropertyDescriptor)$receiver).getExtensionReceiverParameter() != null;
    }

    @NotNull
    public static final SmartList<ClassDescriptor> getAllSuperclassesWithoutAny(@NotNull ClassDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return (SmartList)SequencesKt.toCollection(SequencesKt.generateSequence(DescriptorUtilsKt.getSuperClassNotAny($receiver), (Function1)getAllSuperclassesWithoutAny.1.INSTANCE), (Collection)new SmartList());
    }

    @NotNull
    public static final Sequence<ClassifierDescriptor> getAllSuperClassifiers(@NotNull ClassifierDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        HashSet set = new HashSet();
        Function1<ClassifierDescriptor, Sequence<? extends ClassifierDescriptor>> doGetAllSuperClassesAndInterfaces$ = new Function1<ClassifierDescriptor, Sequence<? extends ClassifierDescriptor>>(set){
            final /* synthetic */ HashSet $set;

            @NotNull
            public final Sequence<ClassifierDescriptor> invoke(@NotNull ClassifierDescriptor $receiver) {
                Sequence<ClassifierDescriptor> sequence;
                Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                if (this.$set.contains($receiver.getOriginal())) {
                    sequence = SequencesKt.emptySequence();
                } else {
                    Collection collection = this.$set;
                    ClassifierDescriptor classifierDescriptor = $receiver.getOriginal();
                    collection.add(classifierDescriptor);
                    sequence = SequencesKt.plus(SequencesKt.sequenceOf($receiver.getOriginal()), SequencesKt.flatMap(CollectionsKt.asSequence((Iterable)$receiver.getTypeConstructor().getSupertypes()), (Function1)new Function1<KotlinType, Sequence<? extends ClassifierDescriptor>>(this){
                        final /* synthetic */ getAllSuperClassifiers.1 this$0;

                        @NotNull
                        public final Sequence<ClassifierDescriptor> invoke(KotlinType it) {
                            Object object = it.getConstructor().getDeclarationDescriptor();
                            if (object == null || (object = this.this$0.invoke((ClassifierDescriptor)object)) == null) {
                                object = SequencesKt.sequenceOf(new ClassifierDescriptor[0]);
                            }
                            return object;
                        }
                        {
                            this.this$0 = var1_1;
                            super(1);
                        }
                    }));
                }
                return sequence;
            }
            {
                this.$set = hashSet;
                super(1);
            }
        };
        return doGetAllSuperClassesAndInterfaces$.invoke($receiver);
    }

    @NotNull
    public static final Collection<ClassDescriptor> computeSealedSubclasses(@NotNull ClassDescriptor sealedClass) {
        Intrinsics.checkParameterIsNotNull(sealedClass, "sealedClass");
        if (Intrinsics.areEqual((Object)sealedClass.getModality(), (Object)Modality.SEALED) ^ true) {
            return CollectionsKt.emptyList();
        }
        LinkedHashSet result2 = new LinkedHashSet();
        Function2<MemberScope, Boolean, Unit> collectSubclasses$ = new Function2<MemberScope, Boolean, Unit>(sealedClass, result2){
            final /* synthetic */ ClassDescriptor $sealedClass;
            final /* synthetic */ LinkedHashSet $result;

            public final void invoke(@NotNull MemberScope scope, boolean collectNested) {
                Intrinsics.checkParameterIsNotNull(scope, "scope");
                for (DeclarationDescriptor descriptor2 : ResolutionScope.DefaultImpls.getContributedDescriptors$default(scope, DescriptorKindFilter.CLASSIFIERS, null, 2, null)) {
                    if (!(descriptor2 instanceof ClassDescriptor)) continue;
                    if (DescriptorUtils.isDirectSubclass((ClassDescriptor)descriptor2, this.$sealedClass)) {
                        this.$result.add(descriptor2);
                    }
                    if (!collectNested) continue;
                    MemberScope memberScope2 = ((ClassDescriptor)descriptor2).getUnsubstitutedInnerClassesScope();
                    Intrinsics.checkExpressionValueIsNotNull(memberScope2, "descriptor.unsubstitutedInnerClassesScope");
                    this.invoke(memberScope2, collectNested);
                }
            }
            {
                this.$sealedClass = classDescriptor;
                this.$result = linkedHashSet;
                super(2);
            }
        };
        DeclarationDescriptor container = sealedClass.getContainingDeclaration();
        if (container instanceof PackageFragmentDescriptor) {
            collectSubclasses$.invoke(((PackageFragmentDescriptor)container).getMemberScope(), false);
        }
        MemberScope memberScope2 = sealedClass.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkExpressionValueIsNotNull(memberScope2, "sealedClass.unsubstitutedInnerClassesScope");
        collectSubclasses$.invoke(memberScope2, true);
        return result2;
    }

    @Nullable
    public static final ClassConstructorDescriptor getNoArgsConstructor(@NotNull ClassDescriptor $receiver) {
        Object v0;
        block1: {
            Iterable iterable;
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Iterable iterable2 = iterable = (Iterable)$receiver.getConstructors();
            for (Object t : iterable2) {
                ClassConstructorDescriptor it = (ClassConstructorDescriptor)t;
                if (!it.getValueParameters().isEmpty()) continue;
                v0 = t;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ClassConstructorDescriptor> getConstructorForEmptyArgumentsList(@NotNull ClassDescriptor $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getConstructors();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            boolean bl;
            block2: {
                ClassConstructorDescriptor it = (ClassConstructorDescriptor)element$iv$iv;
                Iterable $receiver$iv2 = it.getValueParameters();
                for (Object element$iv : $receiver$iv2) {
                    ValueParameterDescriptor it2 = (ValueParameterDescriptor)element$iv;
                    if (DescriptorUtilsKt.hasDefaultValue(it2) || it2.getVarargElementType() != null) continue;
                    bl = false;
                    break block2;
                }
                bl = true;
            }
            if (!bl) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    public static final boolean isPublishedApi(@NotNull DeclarationDescriptor $receiver) {
        DeclarationDescriptor declarationDescriptor;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = DescriptorUtils.getDirectMember((CallableMemberDescriptor)$receiver);
            Intrinsics.checkExpressionValueIsNotNull(callableMemberDescriptor, "DescriptorUtils.getDirectMember(this)");
            declarationDescriptor = callableMemberDescriptor;
        } else {
            declarationDescriptor = $receiver;
        }
        DeclarationDescriptor descriptor2 = declarationDescriptor;
        Annotations annotations2 = descriptor2.getAnnotations();
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.publishedApi;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.publishedApi");
        return annotations2.hasAnnotation(fqName2);
    }
}

