/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.VisibilityUtilKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.Mutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OverridingUtil {
    private static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    public static final OverridingUtil DEFAULT = new OverridingUtil(new KotlinTypeChecker.TypeConstructorEquality(){

        @Override
        public boolean equals(@NotNull TypeConstructor a, @NotNull TypeConstructor b) {
            if (a == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "a", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1", "equals"));
            }
            if (b == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "b", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1", "equals"));
            }
            return a.equals(b);
        }
    });
    private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;

    @NotNull
    public static OverridingUtil createWithEqualityAxioms(@NotNull KotlinTypeChecker.TypeConstructorEquality equalityAxioms) {
        if (equalityAxioms == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "equalityAxioms", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createWithEqualityAxioms"));
        }
        OverridingUtil overridingUtil2 = new OverridingUtil(equalityAxioms);
        if (overridingUtil2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createWithEqualityAxioms"));
        }
        return overridingUtil2;
    }

    private OverridingUtil(KotlinTypeChecker.TypeConstructorEquality axioms) {
        this.equalityAxioms = axioms;
    }

    @NotNull
    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(@NotNull Set<D> candidateSet) {
        if (candidateSet == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "candidateSet", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterOutOverridden"));
        }
        Set<D> set = OverridingUtil.filterOverrides(candidateSet, FunctionsKt.identity());
        if (set == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterOutOverridden"));
        }
        return set;
    }

    @NotNull
    public static <D> Set<D> filterOverrides(@NotNull Set<D> candidateSet, @NotNull Function1<? super D, ? extends CallableDescriptor> transform) {
        if (candidateSet == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "candidateSet", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterOverrides"));
        }
        if (transform == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "transform", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterOverrides"));
        }
        if (candidateSet.size() <= 1) {
            Set<D> set = candidateSet;
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterOverrides"));
            }
            return set;
        }
        LinkedHashSet<D> result2 = new LinkedHashSet<D>();
        block0: for (D meD : candidateSet) {
            CallableDescriptor me = transform.invoke(meD);
            Iterator iterator2 = result2.iterator();
            while (iterator2.hasNext()) {
                Object otherD = iterator2.next();
                CallableDescriptor other = transform.invoke(otherD);
                if (OverridingUtil.overrides(me, other)) {
                    iterator2.remove();
                    continue;
                }
                if (!OverridingUtil.overrides(other, me)) continue;
                continue block0;
            }
            result2.add(meD);
        }
        assert (!result2.isEmpty()) : "All candidates filtered out from " + candidateSet;
        LinkedHashSet<D> linkedHashSet = result2;
        if (linkedHashSet == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterOverrides"));
        }
        return linkedHashSet;
    }

    public static <D extends CallableDescriptor> boolean overrides(@NotNull D f, @NotNull D g) {
        if (f == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "f", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "overrides"));
        }
        if (g == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "g", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "overrides"));
        }
        if (!f.equals(g) && DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(f.getOriginal(), g.getOriginal())) {
            return true;
        }
        CallableDescriptor originalG = g.getOriginal();
        for (D overriddenFunction : DescriptorUtils.getAllOverriddenDescriptors(f)) {
            if (!DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(originalG, overriddenFunction)) continue;
            return true;
        }
        return false;
    }

    @NotNull
    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(@NotNull CallableMemberDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getOverriddenDeclarations"));
        }
        LinkedHashSet<CallableMemberDescriptor> result2 = new LinkedHashSet<CallableMemberDescriptor>();
        OverridingUtil.collectOverriddenDeclarations(descriptor2, result2);
        LinkedHashSet<CallableMemberDescriptor> linkedHashSet = result2;
        if (linkedHashSet == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getOverriddenDeclarations"));
        }
        return linkedHashSet;
    }

    private static void collectOverriddenDeclarations(@NotNull CallableMemberDescriptor descriptor2, @NotNull Set<CallableMemberDescriptor> result2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "collectOverriddenDeclarations"));
        }
        if (result2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "collectOverriddenDeclarations"));
        }
        if (descriptor2.getKind().isReal()) {
            result2.add(descriptor2);
        } else {
            if (descriptor2.getOverriddenDescriptors().isEmpty()) {
                throw new IllegalStateException("No overridden descriptors found for (fake override) " + descriptor2);
            }
            for (CallableMemberDescriptor callableMemberDescriptor : descriptor2.getOverriddenDescriptors()) {
                OverridingUtil.collectOverriddenDeclarations(callableMemberDescriptor, result2);
            }
        }
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableBy(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, @Nullable ClassDescriptor subClassDescriptor) {
        if (superDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "superDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
        }
        if (subDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
        }
        OverrideCompatibilityInfo overrideCompatibilityInfo = this.isOverridableBy(superDescriptor, subDescriptor, subClassDescriptor, false);
        if (overrideCompatibilityInfo == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
        }
        return overrideCompatibilityInfo;
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableBy(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, @Nullable ClassDescriptor subClassDescriptor, boolean checkReturnType) {
        ExternalOverridabilityCondition.Result result2;
        if (superDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "superDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
        }
        if (subDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
        }
        OverrideCompatibilityInfo basicResult = this.isOverridableByWithoutExternalConditions(superDescriptor, subDescriptor, checkReturnType);
        boolean wasSuccess = basicResult.getResult() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalCondition : EXTERNAL_CONDITIONS) {
            if (externalCondition.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY || wasSuccess && externalCondition.getContract() == ExternalOverridabilityCondition.Contract.SUCCESS_ONLY) continue;
            result2 = externalCondition.isOverridable(superDescriptor, subDescriptor, subClassDescriptor);
            switch (result2) {
                case OVERRIDABLE: {
                    wasSuccess = true;
                    break;
                }
                case CONFLICT: {
                    OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.conflict("External condition failed");
                    if (overrideCompatibilityInfo == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
                    }
                    return overrideCompatibilityInfo;
                }
                case INCOMPATIBLE: {
                    OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("External condition");
                    if (overrideCompatibilityInfo == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
                    }
                    return overrideCompatibilityInfo;
                }
            }
        }
        if (!wasSuccess) {
            OverrideCompatibilityInfo overrideCompatibilityInfo = basicResult;
            if (overrideCompatibilityInfo == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
            }
            return overrideCompatibilityInfo;
        }
        for (ExternalOverridabilityCondition externalCondition : EXTERNAL_CONDITIONS) {
            if (externalCondition.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) continue;
            result2 = externalCondition.isOverridable(superDescriptor, subDescriptor, subClassDescriptor);
            switch (result2) {
                case CONFLICT: {
                    OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.conflict("External condition failed");
                    if (overrideCompatibilityInfo == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
                    }
                    return overrideCompatibilityInfo;
                }
                case INCOMPATIBLE: {
                    OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("External condition");
                    if (overrideCompatibilityInfo == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
                    }
                    return overrideCompatibilityInfo;
                }
                case OVERRIDABLE: {
                    throw new IllegalStateException("Contract violation in " + externalCondition.getClass().getName() + " condition. It's not supposed to end with success");
                }
            }
        }
        OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.success();
        if (overrideCompatibilityInfo == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"));
        }
        return overrideCompatibilityInfo;
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, boolean checkReturnType) {
        int i;
        if (superDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "superDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"));
        }
        if (subDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"));
        }
        OverrideCompatibilityInfo basicOverridability = OverridingUtil.getBasicOverridabilityProblem(superDescriptor, subDescriptor);
        if (basicOverridability != null) {
            OverrideCompatibilityInfo overrideCompatibilityInfo = basicOverridability;
            if (overrideCompatibilityInfo == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"));
            }
            return overrideCompatibilityInfo;
        }
        List<KotlinType> superValueParameters = OverridingUtil.compiledValueParameters(superDescriptor);
        List<KotlinType> subValueParameters = OverridingUtil.compiledValueParameters(subDescriptor);
        List<TypeParameterDescriptor> superTypeParameters = superDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> subTypeParameters = subDescriptor.getTypeParameters();
        if (superTypeParameters.size() != subTypeParameters.size()) {
            for (int i2 = 0; i2 < superValueParameters.size(); ++i2) {
                if (KotlinTypeChecker.DEFAULT.equalTypes(superValueParameters.get(i2), subValueParameters.get(i2))) continue;
                OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
                if (overrideCompatibilityInfo == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"));
                }
                return overrideCompatibilityInfo;
            }
            OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
            if (overrideCompatibilityInfo == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"));
            }
            return overrideCompatibilityInfo;
        }
        KotlinTypeChecker typeChecker = this.createTypeChecker(superTypeParameters, subTypeParameters);
        for (i = 0; i < superTypeParameters.size(); ++i) {
            if (OverridingUtil.areTypeParametersEquivalent(superTypeParameters.get(i), subTypeParameters.get(i), typeChecker)) continue;
            OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
            if (overrideCompatibilityInfo == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"));
            }
            return overrideCompatibilityInfo;
        }
        for (i = 0; i < superValueParameters.size(); ++i) {
            if (OverridingUtil.areTypesEquivalent(superValueParameters.get(i), subValueParameters.get(i), typeChecker)) continue;
            OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
            if (overrideCompatibilityInfo == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"));
            }
            return overrideCompatibilityInfo;
        }
        if (superDescriptor instanceof FunctionDescriptor && subDescriptor instanceof FunctionDescriptor && ((FunctionDescriptor)superDescriptor).isSuspend() != ((FunctionDescriptor)subDescriptor).isSuspend()) {
            OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.conflict("Incompatible suspendability");
            if (overrideCompatibilityInfo == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"));
            }
            return overrideCompatibilityInfo;
        }
        if (checkReturnType) {
            KotlinType superReturnType = superDescriptor.getReturnType();
            KotlinType subReturnType = subDescriptor.getReturnType();
            if (superReturnType != null && subReturnType != null) {
                boolean bothErrors;
                boolean bl = bothErrors = subReturnType.isError() && superReturnType.isError();
                if (!bothErrors && !typeChecker.isSubtypeOf(subReturnType, superReturnType)) {
                    OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.conflict("Return type mismatch");
                    if (overrideCompatibilityInfo == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"));
                    }
                    return overrideCompatibilityInfo;
                }
            }
        }
        OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.success();
        if (overrideCompatibilityInfo == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"));
        }
        return overrideCompatibilityInfo;
    }

    @Nullable
    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor) {
        if (superDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "superDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getBasicOverridabilityProblem"));
        }
        if (subDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getBasicOverridabilityProblem"));
        }
        if (superDescriptor instanceof FunctionDescriptor && !(subDescriptor instanceof FunctionDescriptor) || superDescriptor instanceof PropertyDescriptor && !(subDescriptor instanceof PropertyDescriptor)) {
            return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
        }
        if (!(superDescriptor instanceof FunctionDescriptor) && !(superDescriptor instanceof PropertyDescriptor)) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + superDescriptor);
        }
        if (!superDescriptor.getName().equals(subDescriptor.getName())) {
            return OverrideCompatibilityInfo.incompatible("Name mismatch");
        }
        OverrideCompatibilityInfo receiverAndParameterResult = OverridingUtil.checkReceiverAndParameterCount(superDescriptor, subDescriptor);
        if (receiverAndParameterResult != null) {
            return receiverAndParameterResult;
        }
        return null;
    }

    @NotNull
    private KotlinTypeChecker createTypeChecker(@NotNull List<TypeParameterDescriptor> firstParameters, @NotNull List<TypeParameterDescriptor> secondParameters) {
        if (firstParameters == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "firstParameters", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createTypeChecker"));
        }
        if (secondParameters == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "secondParameters", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createTypeChecker"));
        }
        assert (firstParameters.size() == secondParameters.size()) : "Should be the same number of type parameters: " + firstParameters + " vs " + secondParameters;
        if (firstParameters.isEmpty()) {
            KotlinTypeChecker kotlinTypeChecker = KotlinTypeCheckerImpl.withAxioms(this.equalityAxioms);
            if (kotlinTypeChecker == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createTypeChecker"));
            }
            return kotlinTypeChecker;
        }
        final HashMap<TypeConstructor, TypeConstructor> matchingTypeConstructors = new HashMap<TypeConstructor, TypeConstructor>();
        for (int i = 0; i < firstParameters.size(); ++i) {
            matchingTypeConstructors.put(firstParameters.get(i).getTypeConstructor(), secondParameters.get(i).getTypeConstructor());
        }
        KotlinTypeChecker kotlinTypeChecker = KotlinTypeCheckerImpl.withAxioms(new KotlinTypeChecker.TypeConstructorEquality(){

            @Override
            public boolean equals(@NotNull TypeConstructor a, @NotNull TypeConstructor b) {
                if (a == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "a", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$2", "equals"));
                }
                if (b == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "b", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$2", "equals"));
                }
                if (OverridingUtil.this.equalityAxioms.equals(a, b)) {
                    return true;
                }
                TypeConstructor img1 = (TypeConstructor)matchingTypeConstructors.get(a);
                TypeConstructor img2 = (TypeConstructor)matchingTypeConstructors.get(b);
                return img1 != null && img1.equals(b) || img2 != null && img2.equals(a);
            }
        });
        if (kotlinTypeChecker == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createTypeChecker"));
        }
        return kotlinTypeChecker;
    }

    @Nullable
    private static OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor) {
        if (superDescriptor.getExtensionReceiverParameter() == null != (subDescriptor.getExtensionReceiverParameter() == null)) {
            return OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
        }
        if (superDescriptor.getValueParameters().size() != subDescriptor.getValueParameters().size()) {
            return OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
        }
        return null;
    }

    private static boolean areTypesEquivalent(@NotNull KotlinType typeInSuper, @NotNull KotlinType typeInSub, @NotNull KotlinTypeChecker typeChecker) {
        if (typeInSuper == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeInSuper", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypesEquivalent"));
        }
        if (typeInSub == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeInSub", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypesEquivalent"));
        }
        if (typeChecker == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeChecker", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypesEquivalent"));
        }
        boolean bothErrors = typeInSuper.isError() && typeInSub.isError();
        return bothErrors || typeChecker.equalTypes(typeInSuper, typeInSub);
    }

    private static boolean areTypeParametersEquivalent(@NotNull TypeParameterDescriptor superTypeParameter, @NotNull TypeParameterDescriptor subTypeParameter, @NotNull KotlinTypeChecker typeChecker) {
        if (superTypeParameter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "superTypeParameter", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypeParametersEquivalent"));
        }
        if (subTypeParameter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subTypeParameter", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypeParametersEquivalent"));
        }
        if (typeChecker == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeChecker", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypeParametersEquivalent"));
        }
        List<KotlinType> superBounds = superTypeParameter.getUpperBounds();
        ArrayList<KotlinType> subBounds = new ArrayList<KotlinType>(subTypeParameter.getUpperBounds());
        if (superBounds.size() != subBounds.size()) {
            return false;
        }
        block0: for (KotlinType superBound : superBounds) {
            ListIterator it = subBounds.listIterator();
            while (it.hasNext()) {
                KotlinType subBound = (KotlinType)it.next();
                if (!OverridingUtil.areTypesEquivalent(superBound, subBound, typeChecker)) continue;
                it.remove();
                continue block0;
            }
            return false;
        }
        return true;
    }

    private static List<KotlinType> compiledValueParameters(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor receiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList<KotlinType> parameters2 = new ArrayList<KotlinType>();
        if (receiverParameter != null) {
            parameters2.add(receiverParameter.getType());
        }
        for (ValueParameterDescriptor valueParameterDescriptor : callableDescriptor.getValueParameters()) {
            parameters2.add(valueParameterDescriptor.getType());
        }
        return parameters2;
    }

    public static void generateOverridesInFunctionGroup(@NotNull Name name2, @NotNull Collection<? extends CallableMemberDescriptor> membersFromSupertypes, @NotNull Collection<? extends CallableMemberDescriptor> membersFromCurrent, @NotNull ClassDescriptor current, @NotNull OverridingStrategy strategy) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "generateOverridesInFunctionGroup"));
        }
        if (membersFromSupertypes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "membersFromSupertypes", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "generateOverridesInFunctionGroup"));
        }
        if (membersFromCurrent == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "membersFromCurrent", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "generateOverridesInFunctionGroup"));
        }
        if (current == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "current", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "generateOverridesInFunctionGroup"));
        }
        if (strategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "strategy", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "generateOverridesInFunctionGroup"));
        }
        LinkedHashSet<CallableMemberDescriptor> notOverridden = new LinkedHashSet<CallableMemberDescriptor>(membersFromSupertypes);
        for (CallableMemberDescriptor callableMemberDescriptor : membersFromCurrent) {
            Collection<CallableMemberDescriptor> bound = OverridingUtil.extractAndBindOverridesForMember(callableMemberDescriptor, membersFromSupertypes, current, strategy);
            notOverridden.removeAll(bound);
        }
        OverridingUtil.createAndBindFakeOverrides(current, notOverridden, strategy);
    }

    public static boolean isVisibleForOverride(@NotNull MemberDescriptor overriding, @NotNull MemberDescriptor fromSuper) {
        if (overriding == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overriding", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isVisibleForOverride"));
        }
        if (fromSuper == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fromSuper", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isVisibleForOverride"));
        }
        return !Visibilities.isPrivate(fromSuper.getVisibility()) && Visibilities.isVisibleIgnoringReceiver(fromSuper, overriding);
    }

    private static Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(@NotNull CallableMemberDescriptor fromCurrent, @NotNull Collection<? extends CallableMemberDescriptor> descriptorsFromSuper, @NotNull ClassDescriptor current, @NotNull OverridingStrategy strategy) {
        if (fromCurrent == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fromCurrent", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractAndBindOverridesForMember"));
        }
        if (descriptorsFromSuper == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptorsFromSuper", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractAndBindOverridesForMember"));
        }
        if (current == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "current", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractAndBindOverridesForMember"));
        }
        if (strategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "strategy", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractAndBindOverridesForMember"));
        }
        ArrayList<CallableMemberDescriptor> bound = new ArrayList<CallableMemberDescriptor>(descriptorsFromSuper.size());
        SmartSet overridden = SmartSet.create();
        for (CallableMemberDescriptor callableMemberDescriptor : descriptorsFromSuper) {
            OverrideCompatibilityInfo.Result result2 = DEFAULT.isOverridableBy(callableMemberDescriptor, fromCurrent, current).getResult();
            boolean isVisibleForOverride = OverridingUtil.isVisibleForOverride(fromCurrent, callableMemberDescriptor);
            switch (result2) {
                case OVERRIDABLE: {
                    if (isVisibleForOverride) {
                        overridden.add(callableMemberDescriptor);
                    }
                    bound.add(callableMemberDescriptor);
                    break;
                }
                case CONFLICT: {
                    if (isVisibleForOverride) {
                        strategy.overrideConflict(callableMemberDescriptor, fromCurrent);
                    }
                    bound.add(callableMemberDescriptor);
                    break;
                }
            }
        }
        strategy.setOverriddenDescriptors(fromCurrent, overridden);
        return bound;
    }

    private static boolean allHasSameContainingDeclaration(@NotNull Collection<CallableMemberDescriptor> notOverridden) {
        if (notOverridden == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "notOverridden", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "allHasSameContainingDeclaration"));
        }
        if (notOverridden.size() < 2) {
            return true;
        }
        final DeclarationDescriptor containingDeclaration = notOverridden.iterator().next().getContainingDeclaration();
        return CollectionsKt.all(notOverridden, new Function1<CallableMemberDescriptor, Boolean>(){

            @Override
            public Boolean invoke(CallableMemberDescriptor descriptor2) {
                return descriptor2.getContainingDeclaration() == containingDeclaration;
            }
        });
    }

    private static void createAndBindFakeOverrides(@NotNull ClassDescriptor current, @NotNull Collection<CallableMemberDescriptor> notOverridden, @NotNull OverridingStrategy strategy) {
        if (current == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "current", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverrides"));
        }
        if (notOverridden == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "notOverridden", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverrides"));
        }
        if (strategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "strategy", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverrides"));
        }
        if (OverridingUtil.allHasSameContainingDeclaration(notOverridden)) {
            for (CallableMemberDescriptor descriptor2 : notOverridden) {
                OverridingUtil.createAndBindFakeOverride(Collections.singleton(descriptor2), current, strategy);
            }
            return;
        }
        LinkedList<CallableMemberDescriptor> fromSuperQueue = new LinkedList<CallableMemberDescriptor>(notOverridden);
        while (!fromSuperQueue.isEmpty()) {
            CallableMemberDescriptor notOverriddenFromSuper = VisibilityUtilKt.findMemberWithMaxVisibility(fromSuperQueue);
            Collection<CallableMemberDescriptor> overridables = OverridingUtil.extractMembersOverridableInBothWays(notOverriddenFromSuper, fromSuperQueue, strategy);
            OverridingUtil.createAndBindFakeOverride(overridables, current, strategy);
        }
    }

    public static boolean isMoreSpecific(@NotNull CallableDescriptor a, @NotNull CallableDescriptor b) {
        if (a == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "a", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isMoreSpecific"));
        }
        if (b == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "b", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isMoreSpecific"));
        }
        KotlinType aReturnType = a.getReturnType();
        KotlinType bReturnType = b.getReturnType();
        assert (aReturnType != null) : "Return type of " + a + " is null";
        assert (bReturnType != null) : "Return type of " + b + " is null";
        if (!OverridingUtil.isVisibilityMoreSpecific(a, b)) {
            return false;
        }
        if (a instanceof SimpleFunctionDescriptor) {
            assert (b instanceof SimpleFunctionDescriptor) : "b is " + b.getClass();
            return OverridingUtil.isReturnTypeMoreSpecific(a, aReturnType, b, bReturnType);
        }
        if (a instanceof PropertyDescriptor) {
            assert (b instanceof PropertyDescriptor) : "b is " + b.getClass();
            PropertyDescriptor pa = (PropertyDescriptor)a;
            PropertyDescriptor pb = (PropertyDescriptor)b;
            if (!OverridingUtil.isAccessorMoreSpecific(pa.getSetter(), pb.getSetter())) {
                return false;
            }
            if (pa.isVar() && pb.isVar()) {
                return DEFAULT.createTypeChecker(a.getTypeParameters(), b.getTypeParameters()).equalTypes(aReturnType, bReturnType);
            }
            return (pa.isVar() || !pb.isVar()) && OverridingUtil.isReturnTypeMoreSpecific(a, aReturnType, b, bReturnType);
        }
        throw new IllegalArgumentException("Unexpected callable: " + a.getClass());
    }

    private static boolean isVisibilityMoreSpecific(@NotNull DeclarationDescriptorWithVisibility a, @NotNull DeclarationDescriptorWithVisibility b) {
        if (a == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "a", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isVisibilityMoreSpecific"));
        }
        if (b == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "b", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isVisibilityMoreSpecific"));
        }
        Integer result2 = Visibilities.compare(a.getVisibility(), b.getVisibility());
        return result2 == null || result2 >= 0;
    }

    private static boolean isAccessorMoreSpecific(@Nullable PropertyAccessorDescriptor a, @Nullable PropertyAccessorDescriptor b) {
        if (a == null || b == null) {
            return true;
        }
        return OverridingUtil.isVisibilityMoreSpecific(a, b);
    }

    private static boolean isMoreSpecificThenAllOf(@NotNull CallableDescriptor candidate, @NotNull Collection<CallableDescriptor> descriptors) {
        if (candidate == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "candidate", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isMoreSpecificThenAllOf"));
        }
        if (descriptors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptors", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isMoreSpecificThenAllOf"));
        }
        for (CallableDescriptor descriptor2 : descriptors) {
            if (OverridingUtil.isMoreSpecific(candidate, descriptor2)) continue;
            return false;
        }
        return true;
    }

    private static boolean isReturnTypeMoreSpecific(@NotNull CallableDescriptor a, @NotNull KotlinType aReturnType, @NotNull CallableDescriptor b, @NotNull KotlinType bReturnType) {
        if (a == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "a", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isReturnTypeMoreSpecific"));
        }
        if (aReturnType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "aReturnType", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isReturnTypeMoreSpecific"));
        }
        if (b == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "b", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isReturnTypeMoreSpecific"));
        }
        if (bReturnType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "bReturnType", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isReturnTypeMoreSpecific"));
        }
        KotlinTypeChecker typeChecker = DEFAULT.createTypeChecker(a.getTypeParameters(), b.getTypeParameters());
        return typeChecker.isSubtypeOf(aReturnType, bReturnType);
    }

    @NotNull
    public static <H> H selectMostSpecificMember(@NotNull Collection<H> overridables, @NotNull Function1<H, CallableDescriptor> descriptorByHandle) {
        if (overridables == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overridables", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"));
        }
        if (descriptorByHandle == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptorByHandle", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"));
        }
        assert (!overridables.isEmpty()) : "Should have at least one overridable descriptor";
        if (overridables.size() == 1) {
            H h = CollectionsKt.first(overridables);
            if (h == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"));
            }
            return h;
        }
        ArrayList<H> candidates = new ArrayList<H>(2);
        List<CallableDescriptor> callableMemberDescriptors = CollectionsKt.map(overridables, descriptorByHandle);
        H transitivelyMostSpecific = CollectionsKt.first(overridables);
        CallableDescriptor transitivelyMostSpecificDescriptor = descriptorByHandle.invoke(transitivelyMostSpecific);
        for (H overridable : overridables) {
            CallableDescriptor descriptor2 = descriptorByHandle.invoke(overridable);
            if (OverridingUtil.isMoreSpecificThenAllOf(descriptor2, callableMemberDescriptors)) {
                candidates.add(overridable);
            }
            if (!OverridingUtil.isMoreSpecific(descriptor2, transitivelyMostSpecificDescriptor) || OverridingUtil.isMoreSpecific(transitivelyMostSpecificDescriptor, descriptor2)) continue;
            transitivelyMostSpecific = overridable;
        }
        if (candidates.isEmpty()) {
            H h = transitivelyMostSpecific;
            if (h == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"));
            }
            return h;
        }
        if (candidates.size() == 1) {
            Object e = CollectionsKt.first(candidates);
            if (e == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"));
            }
            return (H)e;
        }
        H firstNonFlexible = null;
        for (Object candidate : candidates) {
            if (FlexibleTypesKt.isFlexible(descriptorByHandle.invoke(candidate).getReturnType())) continue;
            firstNonFlexible = (H)candidate;
            break;
        }
        if (firstNonFlexible != null) {
            H h = firstNonFlexible;
            if (h == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"));
            }
            return h;
        }
        Object e = CollectionsKt.first(candidates);
        if (e == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"));
        }
        return (H)e;
    }

    private static void createAndBindFakeOverride(@NotNull Collection<CallableMemberDescriptor> overridables, @NotNull ClassDescriptor current, @NotNull OverridingStrategy strategy) {
        if (overridables == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overridables", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverride"));
        }
        if (current == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "current", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverride"));
        }
        if (strategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "strategy", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverride"));
        }
        Collection<CallableMemberDescriptor> visibleOverridables = OverridingUtil.filterVisibleFakeOverrides(current, overridables);
        boolean allInvisible = visibleOverridables.isEmpty();
        Collection<CallableMemberDescriptor> effectiveOverridden = allInvisible ? overridables : visibleOverridables;
        Modality modality = OverridingUtil.determineModality(effectiveOverridden);
        Visibility visibility = allInvisible ? Visibilities.INVISIBLE_FAKE : Visibilities.INHERITED;
        CallableMemberDescriptor mostSpecific = OverridingUtil.selectMostSpecificMember(effectiveOverridden, new Function1<CallableMemberDescriptor, CallableDescriptor>(){

            @Override
            public CallableMemberDescriptor invoke(CallableMemberDescriptor descriptor2) {
                return descriptor2;
            }
        });
        CallableMemberDescriptor fakeOverride = mostSpecific.copy(current, modality, visibility, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        strategy.setOverriddenDescriptors(fakeOverride, effectiveOverridden);
        assert (!fakeOverride.getOverriddenDescriptors().isEmpty()) : "Overridden descriptors should be set for " + (Object)((Object)CallableMemberDescriptor.Kind.FAKE_OVERRIDE);
        strategy.addFakeOverride(fakeOverride);
    }

    @NotNull
    private static Modality determineModality(@NotNull Collection<CallableMemberDescriptor> descriptors) {
        if (descriptors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptors", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "determineModality"));
        }
        boolean hasOpen = false;
        boolean hasAbstract = false;
        for (CallableMemberDescriptor descriptor2 : descriptors) {
            switch (descriptor2.getModality()) {
                case FINAL: {
                    Modality modality = Modality.FINAL;
                    if (modality == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "determineModality"));
                    }
                    return modality;
                }
                case SEALED: {
                    throw new IllegalStateException("Member cannot have SEALED modality: " + descriptor2);
                }
                case OPEN: {
                    hasOpen = true;
                    break;
                }
                case ABSTRACT: {
                    hasAbstract = true;
                }
            }
        }
        if (hasOpen && !hasAbstract) {
            Modality modality = Modality.OPEN;
            if (modality == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "determineModality"));
            }
            return modality;
        }
        if (!hasOpen && hasAbstract) {
            Modality modality = Modality.ABSTRACT;
            if (modality == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "determineModality"));
            }
            return modality;
        }
        HashSet<CallableMemberDescriptor> allOverriddenDeclarations = new HashSet<CallableMemberDescriptor>();
        for (CallableMemberDescriptor descriptor3 : descriptors) {
            allOverriddenDeclarations.addAll(OverridingUtil.getOverriddenDeclarations(descriptor3));
        }
        Modality modality = OverridingUtil.getMinimalModality(OverridingUtil.filterOutOverridden(allOverriddenDeclarations));
        if (modality == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "determineModality"));
        }
        return modality;
    }

    @NotNull
    private static Modality getMinimalModality(@NotNull Collection<CallableMemberDescriptor> descriptors) {
        if (descriptors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptors", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getMinimalModality"));
        }
        Modality modality = Modality.ABSTRACT;
        for (CallableMemberDescriptor descriptor2 : descriptors) {
            if (descriptor2.getModality().compareTo(modality) >= 0) continue;
            modality = descriptor2.getModality();
        }
        Modality modality2 = modality;
        if (modality2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getMinimalModality"));
        }
        return modality2;
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(final @NotNull ClassDescriptor current, @NotNull Collection<CallableMemberDescriptor> toFilter) {
        if (current == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "current", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterVisibleFakeOverrides"));
        }
        if (toFilter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "toFilter", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterVisibleFakeOverrides"));
        }
        List<CallableMemberDescriptor> list = CollectionsKt.filter(toFilter, new Function1<CallableMemberDescriptor, Boolean>(){

            @Override
            public Boolean invoke(CallableMemberDescriptor descriptor2) {
                return !Visibilities.isPrivate(descriptor2.getVisibility()) && Visibilities.isVisibleIgnoringReceiver(descriptor2, current);
            }
        });
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterVisibleFakeOverrides"));
        }
        return list;
    }

    @NotNull
    public static <H> Collection<H> extractMembersOverridableInBothWays(@NotNull H overrider, @NotNull @Mutable Collection<H> extractFrom, @NotNull Function1<H, CallableDescriptor> descriptorByHandle, @NotNull Function1<H, Unit> onConflict) {
        if (overrider == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overrider", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"));
        }
        if (extractFrom == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "extractFrom", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"));
        }
        if (descriptorByHandle == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptorByHandle", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"));
        }
        if (onConflict == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "onConflict", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"));
        }
        ArrayList<H> overridable = new ArrayList<H>();
        overridable.add(overrider);
        CallableDescriptor overriderDescriptor = descriptorByHandle.invoke(overrider);
        Iterator<H> iterator2 = extractFrom.iterator();
        while (iterator2.hasNext()) {
            H candidate = iterator2.next();
            CallableDescriptor candidateDescriptor = descriptorByHandle.invoke(candidate);
            if (overrider == candidate) {
                iterator2.remove();
                continue;
            }
            OverrideCompatibilityInfo.Result finalResult = OverridingUtil.getBothWaysOverridability(overriderDescriptor, candidateDescriptor);
            if (finalResult == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                overridable.add(candidate);
                iterator2.remove();
                continue;
            }
            if (finalResult != OverrideCompatibilityInfo.Result.CONFLICT) continue;
            onConflict.invoke(candidate);
            iterator2.remove();
        }
        ArrayList<H> arrayList = overridable;
        if (arrayList == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"));
        }
        return arrayList;
    }

    @Nullable
    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor overriderDescriptor, CallableDescriptor candidateDescriptor) {
        OverrideCompatibilityInfo.Result result1 = DEFAULT.isOverridableBy(candidateDescriptor, overriderDescriptor, null).getResult();
        OverrideCompatibilityInfo.Result result2 = DEFAULT.isOverridableBy(overriderDescriptor, candidateDescriptor, null).getResult();
        return result1 == OverrideCompatibilityInfo.Result.OVERRIDABLE && result2 == OverrideCompatibilityInfo.Result.OVERRIDABLE ? OverrideCompatibilityInfo.Result.OVERRIDABLE : (result1 == OverrideCompatibilityInfo.Result.CONFLICT || result2 == OverrideCompatibilityInfo.Result.CONFLICT ? OverrideCompatibilityInfo.Result.CONFLICT : OverrideCompatibilityInfo.Result.INCOMPATIBLE);
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(final @NotNull CallableMemberDescriptor overrider, @NotNull Queue<CallableMemberDescriptor> extractFrom, final @NotNull OverridingStrategy strategy) {
        if (overrider == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overrider", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"));
        }
        if (extractFrom == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "extractFrom", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"));
        }
        if (strategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "strategy", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"));
        }
        Collection<CallableMemberDescriptor> collection = OverridingUtil.extractMembersOverridableInBothWays(overrider, extractFrom, new Function1<CallableMemberDescriptor, CallableDescriptor>(){

            @Override
            public CallableDescriptor invoke(CallableMemberDescriptor descriptor2) {
                return descriptor2;
            }
        }, new Function1<CallableMemberDescriptor, Unit>(){

            @Override
            public Unit invoke(CallableMemberDescriptor descriptor2) {
                strategy.inheritanceConflict(overrider, descriptor2);
                return Unit.INSTANCE;
            }
        });
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"));
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    public static void resolveUnknownVisibilityForMember(@NotNull CallableMemberDescriptor memberDescriptor, @Nullable Function1<CallableMemberDescriptor, Unit> cannotInferVisibility) {
        void var3_6;
        if (memberDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "memberDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "resolveUnknownVisibilityForMember"));
        }
        for (CallableMemberDescriptor callableMemberDescriptor : memberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor.getVisibility() != Visibilities.INHERITED) continue;
            OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, cannotInferVisibility);
        }
        if (memberDescriptor.getVisibility() != Visibilities.INHERITED) {
            return;
        }
        Visibility maxVisibility = OverridingUtil.computeVisibilityToInherit(memberDescriptor);
        if (maxVisibility == null) {
            if (cannotInferVisibility != null) {
                cannotInferVisibility.invoke(memberDescriptor);
            }
            Visibility visibility = Visibilities.PUBLIC;
        } else {
            Visibility visibility = maxVisibility;
        }
        if (memberDescriptor instanceof PropertyDescriptorImpl) {
            ((PropertyDescriptorImpl)memberDescriptor).setVisibility((Visibility)var3_6);
            for (PropertyAccessorDescriptor accessor : ((PropertyDescriptor)memberDescriptor).getAccessors()) {
                OverridingUtil.resolveUnknownVisibilityForMember(accessor, maxVisibility == null ? null : cannotInferVisibility);
            }
        } else if (memberDescriptor instanceof FunctionDescriptorImpl) {
            ((FunctionDescriptorImpl)memberDescriptor).setVisibility((Visibility)var3_6);
        } else {
            assert (memberDescriptor instanceof PropertyAccessorDescriptorImpl);
            ((PropertyAccessorDescriptorImpl)memberDescriptor).setVisibility((Visibility)var3_6);
        }
    }

    @Nullable
    private static Visibility computeVisibilityToInherit(@NotNull CallableMemberDescriptor memberDescriptor) {
        if (memberDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "memberDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "computeVisibilityToInherit"));
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = memberDescriptor.getOverriddenDescriptors();
        Visibility maxVisibility = OverridingUtil.findMaxVisibility(overriddenDescriptors);
        if (maxVisibility == null) {
            return null;
        }
        if (memberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            for (CallableMemberDescriptor callableMemberDescriptor : overriddenDescriptors) {
                if (callableMemberDescriptor.getModality() == Modality.ABSTRACT || callableMemberDescriptor.getVisibility().equals(maxVisibility)) continue;
                return null;
            }
            return maxVisibility;
        }
        return maxVisibility.normalize();
    }

    @Nullable
    public static Visibility findMaxVisibility(@NotNull Collection<? extends CallableMemberDescriptor> descriptors) {
        if (descriptors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptors", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "findMaxVisibility"));
        }
        if (descriptors.isEmpty()) {
            return Visibilities.DEFAULT_VISIBILITY;
        }
        Visibility maxVisibility = null;
        for (CallableMemberDescriptor callableMemberDescriptor : descriptors) {
            Visibility visibility = callableMemberDescriptor.getVisibility();
            assert (visibility != Visibilities.INHERITED) : "Visibility should have been computed for " + callableMemberDescriptor;
            if (maxVisibility == null) {
                maxVisibility = visibility;
                continue;
            }
            Integer compareResult = Visibilities.compare(visibility, maxVisibility);
            if (compareResult == null) {
                maxVisibility = null;
                continue;
            }
            if (compareResult <= 0) continue;
            maxVisibility = visibility;
        }
        if (maxVisibility == null) {
            return null;
        }
        for (CallableMemberDescriptor callableMemberDescriptor : descriptors) {
            Integer compareResult = Visibilities.compare(maxVisibility, callableMemberDescriptor.getVisibility());
            if (compareResult != null && compareResult >= 0) continue;
            return null;
        }
        return maxVisibility;
    }

    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final Result overridable;
        private final String debugMessage;

        @NotNull
        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = SUCCESS;
            if (overrideCompatibilityInfo == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "success"));
            }
            return overrideCompatibilityInfo;
        }

        @NotNull
        public static OverrideCompatibilityInfo incompatible(@NotNull String debugMessage) {
            if (debugMessage == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugMessage", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "incompatible"));
            }
            OverrideCompatibilityInfo overrideCompatibilityInfo = new OverrideCompatibilityInfo(Result.INCOMPATIBLE, debugMessage);
            if (overrideCompatibilityInfo == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "incompatible"));
            }
            return overrideCompatibilityInfo;
        }

        @NotNull
        public static OverrideCompatibilityInfo conflict(@NotNull String debugMessage) {
            if (debugMessage == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugMessage", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "conflict"));
            }
            OverrideCompatibilityInfo overrideCompatibilityInfo = new OverrideCompatibilityInfo(Result.CONFLICT, debugMessage);
            if (overrideCompatibilityInfo == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "conflict"));
            }
            return overrideCompatibilityInfo;
        }

        public OverrideCompatibilityInfo(@NotNull Result success, @NotNull String debugMessage) {
            if (success == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "success", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "<init>"));
            }
            if (debugMessage == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugMessage", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "<init>"));
            }
            this.overridable = success;
            this.debugMessage = debugMessage;
        }

        @NotNull
        public Result getResult() {
            Result result2 = this.overridable;
            if (result2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "getResult"));
            }
            return result2;
        }

        @NotNull
        public String getDebugMessage() {
            String string = this.debugMessage;
            if (string == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "getDebugMessage"));
            }
            return string;
        }

        public static enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT;

        }
    }
}

