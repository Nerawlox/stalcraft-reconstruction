/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorResolverUtils {
    private DescriptorResolverUtils() {
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(@NotNull Name name2, @NotNull Collection<D> membersFromSupertypes, @NotNull Collection<D> membersFromCurrent, @NotNull ClassDescriptor classDescriptor, @NotNull ErrorReporter errorReporter) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"));
        }
        if (membersFromSupertypes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "membersFromSupertypes", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"));
        }
        if (membersFromCurrent == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "membersFromCurrent", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"));
        }
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"));
        }
        if (errorReporter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "errorReporter", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"));
        }
        Collection<D> collection = DescriptorResolverUtils.resolveOverrides(name2, membersFromSupertypes, membersFromCurrent, classDescriptor, errorReporter, false);
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"));
        }
        return collection;
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(@NotNull Name name2, @NotNull Collection<D> membersFromSupertypes, @NotNull Collection<D> membersFromCurrent, @NotNull ClassDescriptor classDescriptor, @NotNull ErrorReporter errorReporter) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"));
        }
        if (membersFromSupertypes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "membersFromSupertypes", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"));
        }
        if (membersFromCurrent == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "membersFromCurrent", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"));
        }
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"));
        }
        if (errorReporter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "errorReporter", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"));
        }
        Collection<D> collection = DescriptorResolverUtils.resolveOverrides(name2, membersFromSupertypes, membersFromCurrent, classDescriptor, errorReporter, true);
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"));
        }
        return collection;
    }

    @NotNull
    private static <D extends CallableMemberDescriptor> Collection<D> resolveOverrides(@NotNull Name name2, @NotNull Collection<D> membersFromSupertypes, @NotNull Collection<D> membersFromCurrent, @NotNull ClassDescriptor classDescriptor, final @NotNull ErrorReporter errorReporter, final boolean isStaticContext) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"));
        }
        if (membersFromSupertypes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "membersFromSupertypes", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"));
        }
        if (membersFromCurrent == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "membersFromCurrent", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"));
        }
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"));
        }
        if (errorReporter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "errorReporter", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"));
        }
        final LinkedHashSet result2 = new LinkedHashSet();
        OverridingUtil.generateOverridesInFunctionGroup(name2, membersFromSupertypes, membersFromCurrent, classDescriptor, new NonReportingOverrideStrategy(){

            @Override
            public void addFakeOverride(@NotNull CallableMemberDescriptor fakeOverride) {
                if (fakeOverride == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fakeOverride", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1", "addFakeOverride"));
                }
                OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, new Function1<CallableMemberDescriptor, Unit>(){

                    @Override
                    public Unit invoke(@NotNull CallableMemberDescriptor descriptor2) {
                        if (descriptor2 == null) {
                            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
                        }
                        errorReporter.reportCannotInferVisibility(descriptor2);
                        return Unit.INSTANCE;
                    }
                });
                result2.add(fakeOverride);
            }

            @Override
            public void conflict(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
                if (fromSuper == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fromSuper", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1", "conflict"));
                }
                if (fromCurrent == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fromCurrent", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1", "conflict"));
                }
            }

            @Override
            public void setOverriddenDescriptors(@NotNull CallableMemberDescriptor member, @NotNull Collection<? extends CallableMemberDescriptor> overridden) {
                if (member == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "member", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1", "setOverriddenDescriptors"));
                }
                if (overridden == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overridden", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1", "setOverriddenDescriptors"));
                }
                if (isStaticContext && member.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                    return;
                }
                super.setOverriddenDescriptors(member, overridden);
            }
        });
        LinkedHashSet linkedHashSet = result2;
        if (linkedHashSet == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"));
        }
        return linkedHashSet;
    }

    @Nullable
    public static ValueParameterDescriptor getAnnotationParameterByName(@NotNull Name name2, @NotNull ClassDescriptor annotationClass) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "getAnnotationParameterByName"));
        }
        if (annotationClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotationClass", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "getAnnotationParameterByName"));
        }
        Collection<ClassConstructorDescriptor> constructors2 = annotationClass.getConstructors();
        if (constructors2.size() != 1) {
            return null;
        }
        for (ValueParameterDescriptor parameter : constructors2.iterator().next().getValueParameters()) {
            if (!parameter.getName().equals(name2)) continue;
            return parameter;
        }
        return null;
    }

    public static boolean isObjectMethodInInterface(@NotNull JavaMember member) {
        if (member == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "member", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "isObjectMethodInInterface"));
        }
        return member.getContainingClass().isInterface() && member instanceof JavaMethod && DescriptorResolverUtils.isObjectMethod((JavaMethod)member);
    }

    public static boolean isObjectMethod(@NotNull JavaMethod method) {
        if (method == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "method", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "isObjectMethod"));
        }
        String name2 = method.getName().asString();
        if (name2.equals("toString") || name2.equals("hashCode")) {
            return method.getValueParameters().isEmpty();
        }
        if (name2.equals("equals")) {
            return DescriptorResolverUtils.isMethodWithOneParameterWithFqName(method, "java.lang.Object");
        }
        return false;
    }

    private static boolean isMethodWithOneParameterWithFqName(@NotNull JavaMethod method, @NotNull String fqName2) {
        JavaClassifier classifier2;
        JavaType type2;
        if (method == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "method", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "isMethodWithOneParameterWithFqName"));
        }
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "isMethodWithOneParameterWithFqName"));
        }
        List<JavaValueParameter> parameters2 = method.getValueParameters();
        if (parameters2.size() == 1 && (type2 = parameters2.get(0).getType()) instanceof JavaClassifierType && (classifier2 = ((JavaClassifierType)type2).getClassifier()) instanceof JavaClass) {
            FqName classFqName = ((JavaClass)classifier2).getFqName();
            return classFqName != null && classFqName.asString().equals(fqName2);
        }
        return false;
    }
}

