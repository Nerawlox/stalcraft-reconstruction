/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DescriptorUtils {
    public static final Name ENUM_VALUES = Name.identifier("values");
    public static final Name ENUM_VALUE_OF = Name.identifier("valueOf");
    public static final FqName JVM_NAME = new FqName("kotlin.jvm.JvmName");
    private static final FqName VOLATILE = new FqName("kotlin.jvm.Volatile");
    private static final FqName SYNCHRONIZED = new FqName("kotlin.jvm.Synchronized");
    public static final FqName COROUTINES_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.experimental");
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME = COROUTINES_PACKAGE_FQ_NAME.child(Name.identifier("Continuation"));

    private DescriptorUtils() {
    }

    @Nullable
    public static ReceiverParameterDescriptor getDispatchReceiverParameterIfNeeded(@NotNull DeclarationDescriptor containingDeclaration) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDispatchReceiverParameterIfNeeded"));
        }
        if (containingDeclaration instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor)containingDeclaration;
            return classDescriptor.getThisAsReceiverParameter();
        }
        return null;
    }

    public static boolean isLocal(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isLocal"));
        }
        for (DeclarationDescriptor current = descriptor2; current != null; current = current.getContainingDeclaration()) {
            if (!DescriptorUtils.isAnonymousObject(current) && !DescriptorUtils.isDescriptorWithLocalVisibility(current)) continue;
            return true;
        }
        return false;
    }

    public static boolean isDescriptorWithLocalVisibility(DeclarationDescriptor current) {
        return current instanceof DeclarationDescriptorWithVisibility && ((DeclarationDescriptorWithVisibility)current).getVisibility() == Visibilities.LOCAL;
    }

    @NotNull
    public static FqNameUnsafe getFqName(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqName"));
        }
        FqName safe = DescriptorUtils.getFqNameSafeIfPossible(descriptor2);
        FqNameUnsafe fqNameUnsafe = safe != null ? safe.toUnsafe() : DescriptorUtils.getFqNameUnsafe(descriptor2);
        if (fqNameUnsafe == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqName"));
        }
        return fqNameUnsafe;
    }

    @NotNull
    public static FqName getFqNameSafe(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameSafe"));
        }
        FqName safe = DescriptorUtils.getFqNameSafeIfPossible(descriptor2);
        FqName fqName2 = safe != null ? safe : DescriptorUtils.getFqNameUnsafe(descriptor2).toSafe();
        if (fqName2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameSafe"));
        }
        return fqName2;
    }

    @Nullable
    private static FqName getFqNameSafeIfPossible(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameSafeIfPossible"));
        }
        if (descriptor2 instanceof ModuleDescriptor || ErrorUtils.isError(descriptor2)) {
            return FqName.ROOT;
        }
        if (descriptor2 instanceof PackageViewDescriptor) {
            return ((PackageViewDescriptor)descriptor2).getFqName();
        }
        if (descriptor2 instanceof PackageFragmentDescriptor) {
            return ((PackageFragmentDescriptor)descriptor2).getFqName();
        }
        return null;
    }

    @NotNull
    private static FqNameUnsafe getFqNameUnsafe(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameUnsafe"));
        }
        DeclarationDescriptor containingDeclaration = descriptor2.getContainingDeclaration();
        assert (containingDeclaration != null) : "Not package/module descriptor doesn't have containing declaration: " + descriptor2;
        FqNameUnsafe fqNameUnsafe = DescriptorUtils.getFqName(containingDeclaration).child(descriptor2.getName());
        if (fqNameUnsafe == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameUnsafe"));
        }
        return fqNameUnsafe;
    }

    @NotNull
    public static FqName getFqNameFromTopLevelClass(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameFromTopLevelClass"));
        }
        DeclarationDescriptor containingDeclaration = descriptor2.getContainingDeclaration();
        Name name2 = descriptor2.getName();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            FqName fqName2 = FqName.topLevel(name2);
            if (fqName2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameFromTopLevelClass"));
            }
            return fqName2;
        }
        FqName fqName3 = DescriptorUtils.getFqNameFromTopLevelClass(containingDeclaration).child(name2);
        if (fqName3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameFromTopLevelClass"));
        }
        return fqName3;
    }

    public static boolean isTopLevelDeclaration(@Nullable DeclarationDescriptor descriptor2) {
        return descriptor2 != null && descriptor2.getContainingDeclaration() instanceof PackageFragmentDescriptor;
    }

    public static boolean isExtension(@NotNull CallableDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isExtension"));
        }
        return descriptor2.getExtensionReceiverParameter() != null;
    }

    public static boolean isOverride(@NotNull CallableMemberDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isOverride"));
        }
        return !descriptor2.getOverriddenDescriptors().isEmpty();
    }

    public static boolean isStaticDeclaration(@NotNull CallableDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isStaticDeclaration"));
        }
        if (descriptor2 instanceof ConstructorDescriptor) {
            return false;
        }
        DeclarationDescriptor container = descriptor2.getContainingDeclaration();
        return container instanceof PackageFragmentDescriptor || container instanceof ClassDescriptor && descriptor2.getDispatchReceiverParameter() == null;
    }

    public static boolean areInSameModule(@NotNull DeclarationDescriptor first, @NotNull DeclarationDescriptor second) {
        if (first == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "first", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "areInSameModule"));
        }
        if (second == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "second", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "areInSameModule"));
        }
        return DescriptorUtils.getContainingModule(first).equals(DescriptorUtils.getContainingModule(second));
    }

    @Nullable
    public static <D extends DeclarationDescriptor> D getParentOfType(@Nullable DeclarationDescriptor descriptor2, @NotNull Class<D> aClass) {
        if (aClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "aClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getParentOfType"));
        }
        return DescriptorUtils.getParentOfType(descriptor2, aClass, true);
    }

    @Nullable
    public static <D extends DeclarationDescriptor> D getParentOfType(@Nullable DeclarationDescriptor descriptor2, @NotNull Class<D> aClass, boolean strict) {
        if (aClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "aClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getParentOfType"));
        }
        if (descriptor2 == null) {
            return null;
        }
        if (strict) {
            descriptor2 = descriptor2.getContainingDeclaration();
        }
        while (descriptor2 != null) {
            if (aClass.isInstance(descriptor2)) {
                return (D)descriptor2;
            }
            descriptor2 = descriptor2.getContainingDeclaration();
        }
        return null;
    }

    @NotNull
    public static ModuleDescriptor getContainingModule(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingModule"));
        }
        ModuleDescriptor module = DescriptorUtils.getContainingModuleOrNull(descriptor2);
        assert (module != null) : "Descriptor without a containing module: " + descriptor2;
        ModuleDescriptor moduleDescriptor = module;
        if (moduleDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingModule"));
        }
        return moduleDescriptor;
    }

    @Nullable
    public static ModuleDescriptor getContainingModuleOrNull(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingModuleOrNull"));
        }
        while (descriptor2 != null) {
            if (descriptor2 instanceof ModuleDescriptor) {
                return (ModuleDescriptor)descriptor2;
            }
            if (descriptor2 instanceof PackageViewDescriptor) {
                return ((PackageViewDescriptor)descriptor2).getModule();
            }
            descriptor2 = descriptor2.getContainingDeclaration();
        }
        return null;
    }

    @Nullable
    public static ClassDescriptor getContainingClass(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingClass"));
        }
        for (DeclarationDescriptor containing = descriptor2.getContainingDeclaration(); containing != null; containing = containing.getContainingDeclaration()) {
            if (!(containing instanceof ClassDescriptor) || DescriptorUtils.isCompanionObject(containing)) continue;
            return (ClassDescriptor)containing;
        }
        return null;
    }

    public static boolean isAncestor(@Nullable DeclarationDescriptor ancestor, @NotNull DeclarationDescriptor declarationDescriptor, boolean strict) {
        DeclarationDescriptor descriptor2;
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "declarationDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isAncestor"));
        }
        if (ancestor == null) {
            return false;
        }
        DeclarationDescriptor declarationDescriptor2 = descriptor2 = strict ? declarationDescriptor.getContainingDeclaration() : declarationDescriptor;
        while (descriptor2 != null) {
            if (ancestor == descriptor2) {
                return true;
            }
            descriptor2 = descriptor2.getContainingDeclaration();
        }
        return false;
    }

    public static boolean isDirectSubclass(@NotNull ClassDescriptor subClass, @NotNull ClassDescriptor superClass) {
        if (subClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isDirectSubclass"));
        }
        if (superClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "superClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isDirectSubclass"));
        }
        for (KotlinType superType : subClass.getTypeConstructor().getSupertypes()) {
            if (!DescriptorUtils.isSameClass(superType, superClass.getOriginal())) continue;
            return true;
        }
        return false;
    }

    public static boolean isSubclass(@NotNull ClassDescriptor subClass, @NotNull ClassDescriptor superClass) {
        if (subClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSubclass"));
        }
        if (superClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "superClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSubclass"));
        }
        return DescriptorUtils.isSubtypeOfClass(subClass.getDefaultType(), superClass.getOriginal());
    }

    private static boolean isSameClass(@NotNull KotlinType type2, @NotNull DeclarationDescriptor other) {
        DeclarationDescriptor originalDescriptor;
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSameClass"));
        }
        if (other == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "other", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSameClass"));
        }
        ClassifierDescriptor descriptor2 = type2.getConstructor().getDeclarationDescriptor();
        return descriptor2 != null && (originalDescriptor = descriptor2.getOriginal()) instanceof ClassifierDescriptor && other instanceof ClassifierDescriptor && ((ClassifierDescriptor)other).getTypeConstructor().equals(((ClassifierDescriptor)originalDescriptor).getTypeConstructor());
    }

    public static boolean isSubtypeOfClass(@NotNull KotlinType type2, @NotNull DeclarationDescriptor superClass) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSubtypeOfClass"));
        }
        if (superClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "superClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSubtypeOfClass"));
        }
        if (DescriptorUtils.isSameClass(type2, superClass)) {
            return true;
        }
        for (KotlinType superType : type2.getConstructor().getSupertypes()) {
            if (!DescriptorUtils.isSubtypeOfClass(superType, superClass)) continue;
            return true;
        }
        return false;
    }

    public static boolean isCompanionObject(@Nullable DeclarationDescriptor descriptor2) {
        return DescriptorUtils.isKindOf(descriptor2, ClassKind.OBJECT) && ((ClassDescriptor)descriptor2).isCompanionObject();
    }

    public static boolean isSealedClass(@Nullable DeclarationDescriptor descriptor2) {
        return DescriptorUtils.isKindOf(descriptor2, ClassKind.CLASS) && ((ClassDescriptor)descriptor2).getModality() == Modality.SEALED;
    }

    public static boolean isAnonymousObject(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isAnonymousObject"));
        }
        return DescriptorUtils.isClass(descriptor2) && descriptor2.getName().equals(SpecialNames.NO_NAME_PROVIDED);
    }

    public static boolean isNonCompanionObject(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isNonCompanionObject"));
        }
        return DescriptorUtils.isKindOf(descriptor2, ClassKind.OBJECT) && !((ClassDescriptor)descriptor2).isCompanionObject();
    }

    public static boolean isObject(@Nullable DeclarationDescriptor descriptor2) {
        return DescriptorUtils.isKindOf(descriptor2, ClassKind.OBJECT);
    }

    public static boolean isEnumEntry(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isEnumEntry"));
        }
        return DescriptorUtils.isKindOf(descriptor2, ClassKind.ENUM_ENTRY);
    }

    public static boolean isEnumClass(@Nullable DeclarationDescriptor descriptor2) {
        return DescriptorUtils.isKindOf(descriptor2, ClassKind.ENUM_CLASS);
    }

    public static boolean isAnnotationClass(@Nullable DeclarationDescriptor descriptor2) {
        return DescriptorUtils.isKindOf(descriptor2, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean isInterface(@Nullable DeclarationDescriptor descriptor2) {
        return DescriptorUtils.isKindOf(descriptor2, ClassKind.INTERFACE);
    }

    public static boolean isClass(@Nullable DeclarationDescriptor descriptor2) {
        return DescriptorUtils.isKindOf(descriptor2, ClassKind.CLASS);
    }

    public static boolean isClassOrEnumClass(@Nullable DeclarationDescriptor descriptor2) {
        return DescriptorUtils.isClass(descriptor2) || DescriptorUtils.isEnumClass(descriptor2);
    }

    private static boolean isKindOf(@Nullable DeclarationDescriptor descriptor2, @NotNull ClassKind classKind) {
        if (classKind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classKind", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isKindOf"));
        }
        return descriptor2 instanceof ClassDescriptor && ((ClassDescriptor)descriptor2).getKind() == classKind;
    }

    @NotNull
    public static List<ClassDescriptor> getSuperclassDescriptors(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getSuperclassDescriptors"));
        }
        Collection<KotlinType> superclassTypes = classDescriptor.getTypeConstructor().getSupertypes();
        ArrayList<ClassDescriptor> superClassDescriptors = new ArrayList<ClassDescriptor>();
        for (KotlinType type2 : superclassTypes) {
            ClassDescriptor result2 = DescriptorUtils.getClassDescriptorForType(type2);
            if (KotlinBuiltIns.isAny(result2)) continue;
            superClassDescriptors.add(result2);
        }
        ArrayList<ClassDescriptor> arrayList = superClassDescriptors;
        if (arrayList == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getSuperclassDescriptors"));
        }
        return arrayList;
    }

    @NotNull
    public static KotlinType getSuperClassType(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getSuperClassType"));
        }
        Collection<KotlinType> superclassTypes = classDescriptor.getTypeConstructor().getSupertypes();
        for (KotlinType type2 : superclassTypes) {
            ClassDescriptor superClassDescriptor = DescriptorUtils.getClassDescriptorForType(type2);
            if (superClassDescriptor.getKind() == ClassKind.INTERFACE) continue;
            KotlinType kotlinType = type2;
            if (kotlinType == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getSuperClassType"));
            }
            return kotlinType;
        }
        SimpleType simpleType2 = DescriptorUtilsKt.getBuiltIns(classDescriptor).getAnyType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getSuperClassType"));
        }
        return simpleType2;
    }

    @Nullable
    public static ClassDescriptor getSuperClassDescriptor(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getSuperClassDescriptor"));
        }
        Collection<KotlinType> superclassTypes = classDescriptor.getTypeConstructor().getSupertypes();
        for (KotlinType type2 : superclassTypes) {
            ClassDescriptor superClassDescriptor = DescriptorUtils.getClassDescriptorForType(type2);
            if (superClassDescriptor.getKind() == ClassKind.INTERFACE) continue;
            return superClassDescriptor;
        }
        return null;
    }

    @NotNull
    public static ClassDescriptor getClassDescriptorForType(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getClassDescriptorForType"));
        }
        ClassDescriptor classDescriptor = DescriptorUtils.getClassDescriptorForTypeConstructor(type2.getConstructor());
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getClassDescriptorForType"));
        }
        return classDescriptor;
    }

    @NotNull
    public static ClassDescriptor getClassDescriptorForTypeConstructor(@NotNull TypeConstructor typeConstructor2) {
        if (typeConstructor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeConstructor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getClassDescriptorForTypeConstructor"));
        }
        ClassifierDescriptor descriptor2 = typeConstructor2.getDeclarationDescriptor();
        assert (descriptor2 instanceof ClassDescriptor) : "Classifier descriptor of a type should be of type ClassDescriptor: " + typeConstructor2;
        ClassDescriptor classDescriptor = (ClassDescriptor)descriptor2;
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getClassDescriptorForTypeConstructor"));
        }
        return classDescriptor;
    }

    @NotNull
    public static Visibility getDefaultConstructorVisibility(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDefaultConstructorVisibility"));
        }
        ClassKind classKind = classDescriptor.getKind();
        if (classKind == ClassKind.ENUM_CLASS || classKind.isSingleton() || DescriptorUtils.isSealedClass(classDescriptor)) {
            Visibility visibility = Visibilities.PRIVATE;
            if (visibility == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDefaultConstructorVisibility"));
            }
            return visibility;
        }
        if (DescriptorUtils.isAnonymousObject(classDescriptor)) {
            Visibility visibility = Visibilities.DEFAULT_VISIBILITY;
            if (visibility == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDefaultConstructorVisibility"));
            }
            return visibility;
        }
        assert (classKind == ClassKind.CLASS || classKind == ClassKind.INTERFACE || classKind == ClassKind.ANNOTATION_CLASS);
        Visibility visibility = Visibilities.PUBLIC;
        if (visibility == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDefaultConstructorVisibility"));
        }
        return visibility;
    }

    @Nullable
    public static ClassDescriptor getInnerClassByName(@NotNull ClassDescriptor classDescriptor, @NotNull String innerClassName, @NotNull LookupLocation location) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getInnerClassByName"));
        }
        if (innerClassName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "innerClassName", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getInnerClassByName"));
        }
        if (location == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "location", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getInnerClassByName"));
        }
        ClassifierDescriptor classifier2 = classDescriptor.getDefaultType().getMemberScope().getContributedClassifier(Name.identifier(innerClassName), location);
        assert (classifier2 instanceof ClassDescriptor) : "Inner class " + innerClassName + " in " + classDescriptor + " should be instance of ClassDescriptor, but was: " + (classifier2 == null ? "null" : classifier2.getClass());
        return (ClassDescriptor)classifier2;
    }

    @Nullable
    public static KotlinType getReceiverParameterType(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
        return receiverParameterDescriptor == null ? null : receiverParameterDescriptor.getType();
    }

    public static boolean isStaticNestedClass(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isStaticNestedClass"));
        }
        DeclarationDescriptor containing = descriptor2.getContainingDeclaration();
        return descriptor2 instanceof ClassDescriptor && containing instanceof ClassDescriptor && !((ClassDescriptor)descriptor2).isInner();
    }

    public static boolean isTopLevelOrInnerClass(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isTopLevelOrInnerClass"));
        }
        DeclarationDescriptor containing = descriptor2.getContainingDeclaration();
        return DescriptorUtils.isTopLevelDeclaration(descriptor2) || containing instanceof ClassDescriptor && DescriptorUtils.isTopLevelOrInnerClass((ClassDescriptor)containing);
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> D unwrapFakeOverride(@NotNull D descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "unwrapFakeOverride"));
        }
        while (descriptor2.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            Collection<? extends CallableMemberDescriptor> overridden = descriptor2.getOverriddenDescriptors();
            if (overridden.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + descriptor2);
            }
            descriptor2 = overridden.iterator().next();
        }
        D d = descriptor2;
        if (d == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "unwrapFakeOverride"));
        }
        return d;
    }

    @NotNull
    public static <D extends DeclarationDescriptorWithVisibility> D unwrapFakeOverrideToAnyDeclaration(@NotNull D descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "unwrapFakeOverrideToAnyDeclaration"));
        }
        if (descriptor2 instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = DescriptorUtils.unwrapFakeOverride((CallableMemberDescriptor)descriptor2);
            if (callableMemberDescriptor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "unwrapFakeOverrideToAnyDeclaration"));
            }
            return (D)callableMemberDescriptor;
        }
        D d = descriptor2;
        if (d == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "unwrapFakeOverrideToAnyDeclaration"));
        }
        return d;
    }

    public static boolean shouldRecordInitializerForProperty(@NotNull VariableDescriptor variable, @NotNull KotlinType type2) {
        if (variable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "variable", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "shouldRecordInitializerForProperty"));
        }
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "shouldRecordInitializerForProperty"));
        }
        if (variable.isVar() || type2.isError()) {
            return false;
        }
        if (TypeUtils.acceptsNullable(type2)) {
            return true;
        }
        KotlinBuiltIns builtIns = DescriptorUtilsKt.getBuiltIns(variable);
        return KotlinBuiltIns.isPrimitiveType(type2) || KotlinTypeChecker.DEFAULT.equalTypes(builtIns.getStringType(), type2) || KotlinTypeChecker.DEFAULT.equalTypes(builtIns.getNumber().getDefaultType(), type2) || KotlinTypeChecker.DEFAULT.equalTypes(builtIns.getAnyType(), type2);
    }

    public static boolean classCanHaveAbstractMembers(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "classCanHaveAbstractMembers"));
        }
        return classDescriptor.getModality() == Modality.ABSTRACT || DescriptorUtils.isSealedClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_CLASS;
    }

    public static boolean classCanHaveOpenMembers(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "classCanHaveOpenMembers"));
        }
        return classDescriptor.getModality() != Modality.FINAL || classDescriptor.getKind() == ClassKind.ENUM_CLASS;
    }

    @NotNull
    public static <D extends CallableDescriptor> Set<D> getAllOverriddenDescriptors(@NotNull D f) {
        if (f == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "f", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getAllOverriddenDescriptors"));
        }
        LinkedHashSet result2 = new LinkedHashSet();
        DescriptorUtils.collectAllOverriddenDescriptors(f.getOriginal(), result2);
        LinkedHashSet linkedHashSet = result2;
        if (linkedHashSet == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getAllOverriddenDescriptors"));
        }
        return linkedHashSet;
    }

    private static <D extends CallableDescriptor> void collectAllOverriddenDescriptors(@NotNull D current, @NotNull Set<D> result2) {
        if (current == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "current", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "collectAllOverriddenDescriptors"));
        }
        if (result2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "collectAllOverriddenDescriptors"));
        }
        if (result2.contains(current)) {
            return;
        }
        for (CallableDescriptor callableDescriptor : current.getOriginal().getOverriddenDescriptors()) {
            CallableDescriptor descriptor2 = callableDescriptor.getOriginal();
            DescriptorUtils.collectAllOverriddenDescriptors(descriptor2, result2);
            result2.add(descriptor2);
        }
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Set<D> getAllOverriddenDeclarations(@NotNull D memberDescriptor) {
        if (memberDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "memberDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getAllOverriddenDeclarations"));
        }
        HashSet<CallableMemberDescriptor> result2 = new HashSet<CallableMemberDescriptor>();
        for (CallableMemberDescriptor callableMemberDescriptor : memberDescriptor.getOverriddenDescriptors()) {
            CallableMemberDescriptor.Kind kind = callableMemberDescriptor.getKind();
            if (kind == CallableMemberDescriptor.Kind.DECLARATION) {
                result2.add(callableMemberDescriptor);
            } else if (kind != CallableMemberDescriptor.Kind.DELEGATION && kind != CallableMemberDescriptor.Kind.FAKE_OVERRIDE && kind != CallableMemberDescriptor.Kind.SYNTHESIZED) {
                throw new AssertionError((Object)("Unexpected callable kind " + (Object)((Object)kind)));
            }
            result2.addAll(DescriptorUtils.getAllOverriddenDeclarations(callableMemberDescriptor));
        }
        HashSet<CallableMemberDescriptor> hashSet = result2;
        if (hashSet == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getAllOverriddenDeclarations"));
        }
        return hashSet;
    }

    public static boolean isSingletonOrAnonymousObject(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSingletonOrAnonymousObject"));
        }
        return classDescriptor.getKind().isSingleton() || DescriptorUtils.isAnonymousObject(classDescriptor);
    }

    public static boolean canHaveDeclaredConstructors(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "canHaveDeclaredConstructors"));
        }
        return !DescriptorUtils.isSingletonOrAnonymousObject(classDescriptor) && !DescriptorUtils.isInterface(classDescriptor);
    }

    @Nullable
    public static String getJvmName(@NotNull Annotated annotated) {
        if (annotated == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotated", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getJvmName"));
        }
        return DescriptorUtils.getJvmName(DescriptorUtils.getJvmNameAnnotation(annotated));
    }

    @Nullable
    public static String getJvmName(@Nullable AnnotationDescriptor jvmNameAnnotation) {
        if (jvmNameAnnotation == null) {
            return null;
        }
        Map<ValueParameterDescriptor, ConstantValue<?>> arguments2 = jvmNameAnnotation.getAllValueArguments();
        if (arguments2.isEmpty()) {
            return null;
        }
        ConstantValue<?> name2 = arguments2.values().iterator().next();
        if (!(name2 instanceof StringValue)) {
            return null;
        }
        return (String)((StringValue)name2).getValue();
    }

    @Nullable
    public static AnnotationDescriptor getAnnotationByFqName(@NotNull Annotations annotations2, @NotNull FqName name2) {
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getAnnotationByFqName"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getAnnotationByFqName"));
        }
        AnnotationWithTarget annotationWithTarget = Annotations.Companion.findAnyAnnotation(annotations2, name2);
        return annotationWithTarget == null ? null : annotationWithTarget.getAnnotation();
    }

    @Nullable
    public static AnnotationDescriptor getJvmNameAnnotation(@NotNull Annotated annotated) {
        if (annotated == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotated", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getJvmNameAnnotation"));
        }
        return DescriptorUtils.getAnnotationByFqName(annotated.getAnnotations(), JVM_NAME);
    }

    @Nullable
    public static AnnotationDescriptor getVolatileAnnotation(@NotNull Annotated annotated) {
        if (annotated == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotated", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getVolatileAnnotation"));
        }
        return DescriptorUtils.getAnnotationByFqName(annotated.getAnnotations(), VOLATILE);
    }

    @Nullable
    public static AnnotationDescriptor getSynchronizedAnnotation(@NotNull Annotated annotated) {
        if (annotated == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotated", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getSynchronizedAnnotation"));
        }
        return DescriptorUtils.getAnnotationByFqName(annotated.getAnnotations(), SYNCHRONIZED);
    }

    @NotNull
    public static SourceFile getContainingSourceFile(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingSourceFile"));
        }
        if (descriptor2 instanceof PropertySetterDescriptor) {
            descriptor2 = ((PropertySetterDescriptor)descriptor2).getCorrespondingProperty();
        }
        if (descriptor2 instanceof DeclarationDescriptorWithSource) {
            SourceFile sourceFile = ((DeclarationDescriptorWithSource)descriptor2).getSource().getContainingFile();
            if (sourceFile == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingSourceFile"));
            }
            return sourceFile;
        }
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        if (sourceFile == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingSourceFile"));
        }
        return sourceFile;
    }

    @NotNull
    public static Collection<DeclarationDescriptor> getAllDescriptors(@NotNull MemberScope scope) {
        if (scope == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "scope", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getAllDescriptors"));
        }
        Collection<DeclarationDescriptor> collection = scope.getContributedDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER());
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getAllDescriptors"));
        }
        return collection;
    }

    public static boolean isEffectivelyExternal(@NotNull MemberDescriptor descriptor2) {
        PropertyDescriptor variableDescriptor;
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isEffectivelyExternal"));
        }
        if (descriptor2.isExternal()) {
            return true;
        }
        if (descriptor2 instanceof PropertyAccessorDescriptor && DescriptorUtils.isEffectivelyExternal(variableDescriptor = ((PropertyAccessorDescriptor)descriptor2).getCorrespondingProperty())) {
            return true;
        }
        ClassDescriptor containingClass = DescriptorUtils.getContainingClass(descriptor2);
        return containingClass != null && DescriptorUtils.isEffectivelyExternal(containingClass);
    }

    @NotNull
    public static FunctionDescriptor getFunctionByName(@NotNull MemberScope scope, @NotNull Name name2) {
        if (scope == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "scope", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFunctionByName"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFunctionByName"));
        }
        Collection<DeclarationDescriptor> functions2 = scope.getContributedDescriptors(DescriptorKindFilter.FUNCTIONS, MemberScope.Companion.getALL_NAME_FILTER());
        for (DeclarationDescriptor d : functions2) {
            if (!(d instanceof FunctionDescriptor) || !name2.equals(d.getOriginal().getName())) continue;
            FunctionDescriptor functionDescriptor = (FunctionDescriptor)d;
            if (functionDescriptor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFunctionByName"));
            }
            return functionDescriptor;
        }
        throw new IllegalStateException("Function not found");
    }

    @NotNull
    public static PropertyDescriptor getPropertyByName(@NotNull MemberScope scope, @NotNull Name name2) {
        if (scope == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "scope", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getPropertyByName"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getPropertyByName"));
        }
        Collection<DeclarationDescriptor> callables = scope.getContributedDescriptors(DescriptorKindFilter.CALLABLES, MemberScope.Companion.getALL_NAME_FILTER());
        for (DeclarationDescriptor d : callables) {
            if (!(d instanceof PropertyDescriptor) || !name2.equals(d.getOriginal().getName())) continue;
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor)d;
            if (propertyDescriptor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getPropertyByName"));
            }
            return propertyDescriptor;
        }
        throw new IllegalStateException("Property not found");
    }

    @NotNull
    public static CallableMemberDescriptor getDirectMember(@NotNull CallableMemberDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDirectMember"));
        }
        CallableMemberDescriptor callableMemberDescriptor = descriptor2 instanceof PropertyAccessorDescriptor ? ((PropertyAccessorDescriptor)descriptor2).getCorrespondingProperty() : descriptor2;
        if (callableMemberDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDirectMember"));
        }
        return callableMemberDescriptor;
    }
}

