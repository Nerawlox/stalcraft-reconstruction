/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import org.jetbrains.annotations.NotNull;

public final class JvmAbi {
    public static final String DEFAULT_IMPLS_CLASS_NAME = "DefaultImpls";
    public static final String DEFAULT_IMPLS_SUFFIX = "$DefaultImpls";
    public static final String DEFAULT_IMPLS_DELEGATE_SUFFIX = "$defaultImpl";
    public static final String DEFAULT_PARAMS_IMPL_SUFFIX = "$default";
    private static final String GET_PREFIX = "get";
    private static final String IS_PREFIX = "is";
    private static final String SET_PREFIX = "set";
    public static final String DELEGATED_PROPERTY_NAME_SUFFIX = "$delegate";
    public static final String DELEGATED_PROPERTIES_ARRAY_NAME = "$$delegatedProperties";
    public static final String DELEGATE_SUPER_FIELD_PREFIX = "$$delegate_";
    private static final String ANNOTATIONS_SUFFIX = "$annotations";
    private static final String ANNOTATED_PROPERTY_METHOD_NAME_SUFFIX = "$annotations";
    private static final String ANNOTATED_TYPEALIAS_METHOD_NAME_SUFFIX = "$annotations";
    public static final String INSTANCE_FIELD = "INSTANCE";
    public static final String DEFAULT_MODULE_NAME = "main";
    public static final ClassId REFLECTION_FACTORY_IMPL = ClassId.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
    public static final String LOCAL_VARIABLE_NAME_PREFIX_INLINE_ARGUMENT = "$i$a$";
    public static final String LOCAL_VARIABLE_NAME_PREFIX_INLINE_FUNCTION = "$i$f$";

    @NotNull
    public static String getSyntheticMethodNameForAnnotatedProperty(@NotNull Name propertyName) {
        if (propertyName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "propertyName", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "getSyntheticMethodNameForAnnotatedProperty"));
        }
        String string = propertyName.asString() + "$annotations";
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "getSyntheticMethodNameForAnnotatedProperty"));
        }
        return string;
    }

    @NotNull
    public static String getSyntheticMethodNameForAnnotatedTypeAlias(@NotNull Name typeAliasName) {
        if (typeAliasName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeAliasName", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "getSyntheticMethodNameForAnnotatedTypeAlias"));
        }
        String string = typeAliasName.asString() + "$annotations";
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "getSyntheticMethodNameForAnnotatedTypeAlias"));
        }
        return string;
    }

    public static boolean isGetterName(@NotNull String name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "isGetterName"));
        }
        return name2.startsWith(GET_PREFIX) || name2.startsWith(IS_PREFIX);
    }

    public static boolean isSetterName(@NotNull String name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "isSetterName"));
        }
        return name2.startsWith(SET_PREFIX);
    }

    @NotNull
    public static String getterName(@NotNull String propertyName) {
        if (propertyName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "propertyName", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "getterName"));
        }
        String string = JvmAbi.startsWithIsPrefix(propertyName) ? propertyName : GET_PREFIX + CapitalizeDecapitalizeKt.capitalizeAsciiOnly(propertyName);
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "getterName"));
        }
        return string;
    }

    @NotNull
    public static String setterName(@NotNull String propertyName) {
        if (propertyName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "propertyName", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "setterName"));
        }
        String string = SET_PREFIX + (JvmAbi.startsWithIsPrefix(propertyName) ? propertyName.substring(IS_PREFIX.length()) : CapitalizeDecapitalizeKt.capitalizeAsciiOnly(propertyName));
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "setterName"));
        }
        return string;
    }

    public static boolean startsWithIsPrefix(String name2) {
        if (!name2.startsWith(IS_PREFIX)) {
            return false;
        }
        if (name2.length() == IS_PREFIX.length()) {
            return false;
        }
        char c = name2.charAt(IS_PREFIX.length());
        return 'a' > c || c > 'z';
    }

    public static boolean isPropertyWithBackingFieldInOuterClass(@NotNull PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "propertyDescriptor", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "isPropertyWithBackingFieldInOuterClass"));
        }
        return propertyDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE && JvmAbi.isCompanionObjectWithBackingFieldsInOuter(propertyDescriptor.getContainingDeclaration());
    }

    public static boolean isCompanionObjectWithBackingFieldsInOuter(@NotNull DeclarationDescriptor companionObject) {
        if (companionObject == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "companionObject", "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi", "isCompanionObjectWithBackingFieldsInOuter"));
        }
        return DescriptorUtils.isCompanionObject(companionObject) && DescriptorUtils.isClassOrEnumClass(companionObject.getContainingDeclaration()) && !CompanionObjectMapping.INSTANCE.isMappedIntrinsicCompanionObject((ClassDescriptor)companionObject);
    }
}

