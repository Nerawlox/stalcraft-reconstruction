/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class FunctionDescriptorImpl
extends DeclarationDescriptorNonRootImpl
implements FunctionDescriptor {
    private List<TypeParameterDescriptor> typeParameters;
    private List<ValueParameterDescriptor> unsubstitutedValueParameters;
    private KotlinType unsubstitutedReturnType;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private Modality modality;
    private Visibility visibility;
    private boolean isOperator;
    private boolean isInfix;
    private boolean isExternal;
    private boolean isInline;
    private boolean isTailrec;
    private boolean isHeader;
    private boolean isImpl;
    private boolean isHiddenToOvercomeSignatureClash;
    private boolean isHiddenForResolutionEverywhereBesideSupercalls;
    private boolean isSuspend;
    private boolean hasStableParameterNames;
    private boolean hasSynthesizedParameterNames;
    private Collection<? extends FunctionDescriptor> overriddenFunctions;
    private volatile Function0<Set<FunctionDescriptor>> lazyOverriddenFunctionsTask;
    private final FunctionDescriptor original;
    private final CallableMemberDescriptor.Kind kind;
    @Nullable
    private FunctionDescriptor initialSignatureDescriptor;
    protected Map<FunctionDescriptor.UserDataKey<?>, Object> userDataMap;

    protected FunctionDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @Nullable FunctionDescriptor original, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "<init>"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "<init>"));
        }
        super(containingDeclaration, annotations2, name2, source);
        this.visibility = Visibilities.UNKNOWN;
        this.isOperator = false;
        this.isInfix = false;
        this.isExternal = false;
        this.isInline = false;
        this.isTailrec = false;
        this.isHeader = false;
        this.isImpl = false;
        this.isHiddenToOvercomeSignatureClash = false;
        this.isHiddenForResolutionEverywhereBesideSupercalls = false;
        this.isSuspend = false;
        this.hasStableParameterNames = true;
        this.hasSynthesizedParameterNames = false;
        this.overriddenFunctions = null;
        this.lazyOverriddenFunctionsTask = null;
        this.initialSignatureDescriptor = null;
        this.userDataMap = null;
        this.original = original == null ? this : original;
        this.kind = kind;
    }

    @NotNull
    public FunctionDescriptorImpl initialize(@Nullable KotlinType receiverParameterType, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @NotNull List<? extends TypeParameterDescriptor> typeParameters2, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @Nullable KotlinType unsubstitutedReturnType, @Nullable Modality modality, @NotNull Visibility visibility) {
        int i;
        if (typeParameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "initialize"));
        }
        if (unsubstitutedValueParameters == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "initialize"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "initialize"));
        }
        this.typeParameters = CollectionsKt.toReadOnlyList(typeParameters2);
        this.unsubstitutedValueParameters = unsubstitutedValueParameters;
        this.unsubstitutedReturnType = unsubstitutedReturnType;
        this.modality = modality;
        this.visibility = visibility;
        this.extensionReceiverParameter = DescriptorFactory.createExtensionReceiverParameterForCallable(this, receiverParameterType);
        this.dispatchReceiverParameter = dispatchReceiverParameter;
        for (i = 0; i < typeParameters2.size(); ++i) {
            TypeParameterDescriptor typeParameterDescriptor = typeParameters2.get(i);
            if (typeParameterDescriptor.getIndex() == i) continue;
            throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i);
        }
        for (i = 0; i < unsubstitutedValueParameters.size(); ++i) {
            int firstValueParameterOffset = 0;
            ValueParameterDescriptor valueParameterDescriptor = unsubstitutedValueParameters.get(i);
            if (valueParameterDescriptor.getIndex() == i + firstValueParameterOffset) continue;
            throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i);
        }
        FunctionDescriptorImpl functionDescriptorImpl = this;
        if (functionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "initialize"));
        }
        return functionDescriptorImpl;
    }

    public void setVisibility(@NotNull Visibility visibility) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "setVisibility"));
        }
        this.visibility = visibility;
    }

    public void setOperator(boolean isOperator) {
        this.isOperator = isOperator;
    }

    public void setInfix(boolean isInfix) {
        this.isInfix = isInfix;
    }

    public void setExternal(boolean isExternal) {
        this.isExternal = isExternal;
    }

    public void setInline(boolean isInline) {
        this.isInline = isInline;
    }

    public void setTailrec(boolean isTailrec) {
        this.isTailrec = isTailrec;
    }

    public void setHeader(boolean isHeader) {
        this.isHeader = isHeader;
    }

    public void setImpl(boolean isImpl) {
        this.isImpl = isImpl;
    }

    public void setHiddenToOvercomeSignatureClash(boolean hiddenToOvercomeSignatureClash) {
        this.isHiddenToOvercomeSignatureClash = hiddenToOvercomeSignatureClash;
    }

    private void setHiddenForResolutionEverywhereBesideSupercalls(boolean hiddenForResolutionEverywhereBesideSupercalls) {
        this.isHiddenForResolutionEverywhereBesideSupercalls = hiddenForResolutionEverywhereBesideSupercalls;
    }

    public void setSuspend(boolean suspend) {
        this.isSuspend = suspend;
    }

    public void setReturnType(@NotNull KotlinType unsubstitutedReturnType) {
        if (unsubstitutedReturnType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unsubstitutedReturnType", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "setReturnType"));
        }
        if (this.unsubstitutedReturnType != null) {
            // empty if block
        }
        this.unsubstitutedReturnType = unsubstitutedReturnType;
    }

    public void setHasStableParameterNames(boolean hasStableParameterNames) {
        this.hasStableParameterNames = hasStableParameterNames;
    }

    public void setHasSynthesizedParameterNames(boolean hasSynthesizedParameterNames) {
        this.hasSynthesizedParameterNames = hasSynthesizedParameterNames;
    }

    @Override
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override
    @NotNull
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        this.performOverriddenLazyCalculationIfNeeded();
        Collection<Object> collection = this.overriddenFunctions != null ? this.overriddenFunctions : Collections.emptyList();
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getOverriddenDescriptors"));
        }
        return collection;
    }

    private void performOverriddenLazyCalculationIfNeeded() {
        Function0<Set<FunctionDescriptor>> overriddenTask = this.lazyOverriddenFunctionsTask;
        if (overriddenTask != null) {
            this.overriddenFunctions = overriddenTask.invoke();
            this.lazyOverriddenFunctionsTask = null;
        }
    }

    @Override
    @NotNull
    public Modality getModality() {
        Modality modality = this.modality;
        if (modality == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getModality"));
        }
        return modality;
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        Visibility visibility = this.visibility;
        if (visibility == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getVisibility"));
        }
        return visibility;
    }

    @Override
    public boolean isOperator() {
        if (this.isOperator) {
            return true;
        }
        for (FunctionDescriptor functionDescriptor : this.getOriginal().getOverriddenDescriptors()) {
            if (!functionDescriptor.isOperator()) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean isInfix() {
        if (this.isInfix) {
            return true;
        }
        for (FunctionDescriptor functionDescriptor : this.getOriginal().getOverriddenDescriptors()) {
            if (!functionDescriptor.isInfix()) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override
    public boolean isInline() {
        return this.isInline;
    }

    @Override
    public boolean isTailrec() {
        return this.isTailrec;
    }

    @Override
    public boolean isSuspend() {
        return this.isSuspend;
    }

    @Override
    public boolean isHeader() {
        return this.isHeader;
    }

    @Override
    public boolean isImpl() {
        return this.isImpl;
    }

    @Override
    public <V> V getUserData(FunctionDescriptor.UserDataKey<V> key) {
        if (this.userDataMap == null) {
            return null;
        }
        return (V)this.userDataMap.get(key);
    }

    @Override
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.isHiddenToOvercomeSignatureClash;
    }

    @Override
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        if (overriddenDescriptors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overriddenDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "setOverriddenDescriptors"));
        }
        this.overriddenFunctions = overriddenDescriptors;
        for (FunctionDescriptor functionDescriptor : this.overriddenFunctions) {
            if (!functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) continue;
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            break;
        }
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeParameters;
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getTypeParameters"));
        }
        return list;
    }

    @Override
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.unsubstitutedValueParameters;
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getValueParameters"));
        }
        return list;
    }

    @Override
    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames;
    }

    @Override
    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames;
    }

    @Override
    public KotlinType getReturnType() {
        return this.unsubstitutedReturnType;
    }

    @Override
    @NotNull
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.original == this ? this : this.original.getOriginal();
        if (functionDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getOriginal"));
        }
        return functionDescriptor;
    }

    @Override
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.kind;
        if (kind == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getKind"));
        }
        return kind;
    }

    @Override
    public FunctionDescriptor substitute(@NotNull TypeSubstitutor originalSubstitutor) {
        if (originalSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "originalSubstitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "substitute"));
        }
        if (originalSubstitutor.isEmpty()) {
            return this;
        }
        return this.newCopyBuilder(originalSubstitutor).setOriginal(this.getOriginal()).build();
    }

    @Nullable
    protected KotlinType getExtensionReceiverParameterType() {
        if (this.extensionReceiverParameter == null) {
            return null;
        }
        return this.extensionReceiverParameter.getType();
    }

    @Override
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.isHiddenForResolutionEverywhereBesideSupercalls;
    }

    @Override
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        CopyConfiguration copyConfiguration = this.newCopyBuilder(TypeSubstitutor.EMPTY);
        if (copyConfiguration == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "newCopyBuilder"));
        }
        return copyConfiguration;
    }

    @NotNull
    protected CopyConfiguration newCopyBuilder(@NotNull TypeSubstitutor substitutor) {
        if (substitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "newCopyBuilder"));
        }
        CopyConfiguration copyConfiguration = new CopyConfiguration(substitutor.getSubstitution(), this.getContainingDeclaration(), this.getModality(), this.getVisibility(), this.getKind(), this.getValueParameters(), this.getExtensionReceiverParameterType(), this.getReturnType(), null);
        if (copyConfiguration == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "newCopyBuilder"));
        }
        return copyConfiguration;
    }

    @Nullable
    protected FunctionDescriptor doSubstitute(@NotNull CopyConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "configuration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "doSubstitute"));
        }
        Annotations resultAnnotations = configuration.additionalAnnotations != null ? AnnotationsKt.composeAnnotations(this.getAnnotations(), configuration.additionalAnnotations) : this.getAnnotations();
        FunctionDescriptorImpl substitutedDescriptor = this.createSubstitutedCopy(configuration.newOwner, configuration.original, configuration.kind, configuration.name, resultAnnotations, this.getSourceToUseForCopy(configuration.preserveSourceElement, configuration.original, configuration.sourceElement));
        List unsubstitutedTypeParameters = configuration.newTypeParameters == null ? this.getTypeParameters() : configuration.newTypeParameters;
        ArrayList<TypeParameterDescriptor> substitutedTypeParameters = new ArrayList<TypeParameterDescriptor>(unsubstitutedTypeParameters.size());
        final TypeSubstitutor substitutor = DescriptorSubstitutor.substituteTypeParameters(unsubstitutedTypeParameters, configuration.substitution, substitutedDescriptor, substitutedTypeParameters);
        KotlinType substitutedReceiverParameterType = null;
        if (configuration.newExtensionReceiverParameterType != null && (substitutedReceiverParameterType = substitutor.substitute(configuration.newExtensionReceiverParameterType, Variance.IN_VARIANCE)) == null) {
            return null;
        }
        ReceiverParameterDescriptor substitutedExpectedThis = null;
        if (configuration.dispatchReceiverParameter != null && (substitutedExpectedThis = configuration.dispatchReceiverParameter.substitute(substitutor)) == null) {
            return null;
        }
        List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(substitutedDescriptor, configuration.newValueParameterDescriptors, substitutor, configuration.dropOriginalInContainingParts, configuration.preserveSourceElement);
        if (substitutedValueParameters == null) {
            return null;
        }
        KotlinType substitutedReturnType = substitutor.substitute(configuration.newReturnType, Variance.OUT_VARIANCE);
        if (substitutedReturnType == null) {
            return null;
        }
        substitutedDescriptor.initialize(substitutedReceiverParameterType, substitutedExpectedThis, substitutedTypeParameters, substitutedValueParameters, substitutedReturnType, configuration.newModality, configuration.newVisibility);
        substitutedDescriptor.setOperator(this.isOperator);
        substitutedDescriptor.setInfix(this.isInfix);
        substitutedDescriptor.setExternal(this.isExternal);
        substitutedDescriptor.setInline(this.isInline);
        substitutedDescriptor.setTailrec(this.isTailrec);
        substitutedDescriptor.setSuspend(this.isSuspend);
        substitutedDescriptor.setHeader(this.isHeader);
        substitutedDescriptor.setImpl(this.isImpl);
        substitutedDescriptor.setHasStableParameterNames(this.hasStableParameterNames);
        substitutedDescriptor.setHiddenToOvercomeSignatureClash(configuration.isHiddenToOvercomeSignatureClash);
        substitutedDescriptor.setHiddenForResolutionEverywhereBesideSupercalls(configuration.isHiddenForResolutionEverywhereBesideSupercalls);
        substitutedDescriptor.setHasSynthesizedParameterNames(configuration.newHasSynthesizedParameterNames != null ? configuration.newHasSynthesizedParameterNames : this.hasSynthesizedParameterNames);
        if (!configuration.userDataMap.isEmpty() || this.userDataMap != null) {
            Map newMap = configuration.userDataMap;
            if (this.userDataMap != null) {
                for (Map.Entry<FunctionDescriptor.UserDataKey<?>, Object> entry : this.userDataMap.entrySet()) {
                    if (newMap.containsKey(entry.getKey())) continue;
                    newMap.put(entry.getKey(), entry.getValue());
                }
            }
            substitutedDescriptor.userDataMap = newMap.size() == 1 ? Collections.singletonMap(newMap.keySet().iterator().next(), newMap.values().iterator().next()) : newMap;
        }
        if (configuration.signatureChange || this.getInitialSignatureDescriptor() != null) {
            FunctionDescriptor initialSignature = this.getInitialSignatureDescriptor() != null ? this.getInitialSignatureDescriptor() : this;
            FunctionDescriptor initialSignatureSubstituted = initialSignature.substitute(substitutor);
            substitutedDescriptor.setInitialSignatureDescriptor(initialSignatureSubstituted);
        }
        if (configuration.copyOverrides && !this.getOriginal().getOverriddenDescriptors().isEmpty()) {
            if (configuration.substitution.isEmpty()) {
                Function0<Set<FunctionDescriptor>> overriddenFunctionsTask = this.lazyOverriddenFunctionsTask;
                if (overriddenFunctionsTask != null) {
                    substitutedDescriptor.lazyOverriddenFunctionsTask = overriddenFunctionsTask;
                } else {
                    substitutedDescriptor.setOverriddenDescriptors(this.getOverriddenDescriptors());
                }
            } else {
                substitutedDescriptor.lazyOverriddenFunctionsTask = new Function0<Set<FunctionDescriptor>>(){

                    @Override
                    public Set<FunctionDescriptor> invoke() {
                        SmartSet<FunctionDescriptor> result2 = SmartSet.create();
                        for (FunctionDescriptor functionDescriptor : FunctionDescriptorImpl.this.getOverriddenDescriptors()) {
                            result2.add(functionDescriptor.substitute(substitutor));
                        }
                        return result2;
                    }
                };
            }
        }
        return substitutedDescriptor;
    }

    @Override
    @NotNull
    public FunctionDescriptor copy(DeclarationDescriptor newOwner, Modality modality, Visibility visibility, CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        FunctionDescriptor functionDescriptor = this.newCopyBuilder().setOwner(newOwner).setModality(modality).setVisibility(visibility).setKind(kind).setCopyOverrides(copyOverrides).build();
        if (functionDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "copy"));
        }
        return functionDescriptor;
    }

    @NotNull
    protected abstract FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor var1, @Nullable FunctionDescriptor var2, @NotNull CallableMemberDescriptor.Kind var3, @Nullable Name var4, @NotNull Annotations var5, @NotNull SourceElement var6);

    @NotNull
    private SourceElement getSourceToUseForCopy(boolean preserveSource, @Nullable FunctionDescriptor original, @Nullable SourceElement sourceElement) {
        if (sourceElement != null) {
            SourceElement sourceElement2 = sourceElement;
            if (sourceElement2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getSourceToUseForCopy"));
            }
            return sourceElement2;
        }
        SourceElement sourceElement3 = preserveSource ? (original != null ? original.getSource() : this.getOriginal().getSource()) : SourceElement.NO_SOURCE;
        if (sourceElement3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getSourceToUseForCopy"));
        }
        return sourceElement3;
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        return visitor2.visitFunctionDescriptor(this, data2);
    }

    @Nullable
    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor substitutedDescriptor, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @NotNull TypeSubstitutor substitutor, boolean dropOriginal, boolean preserveSourceElement) {
        if (unsubstitutedValueParameters == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getSubstitutedValueParameters"));
        }
        if (substitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "getSubstitutedValueParameters"));
        }
        ArrayList<ValueParameterDescriptor> result2 = new ArrayList<ValueParameterDescriptor>(unsubstitutedValueParameters.size());
        for (ValueParameterDescriptor unsubstitutedValueParameter : unsubstitutedValueParameters) {
            KotlinType substituteVarargElementType;
            KotlinType substitutedType = substitutor.substitute(unsubstitutedValueParameter.getType(), Variance.IN_VARIANCE);
            KotlinType varargElementType = unsubstitutedValueParameter.getVarargElementType();
            KotlinType kotlinType = substituteVarargElementType = varargElementType == null ? null : substitutor.substitute(varargElementType, Variance.IN_VARIANCE);
            if (substitutedType == null) {
                return null;
            }
            result2.add(new ValueParameterDescriptorImpl(substitutedDescriptor, dropOriginal ? null : unsubstitutedValueParameter, unsubstitutedValueParameter.getIndex(), unsubstitutedValueParameter.getAnnotations(), unsubstitutedValueParameter.getName(), substitutedType, unsubstitutedValueParameter.declaresDefaultValue(), unsubstitutedValueParameter.isCrossinline(), unsubstitutedValueParameter.isNoinline(), substituteVarargElementType, preserveSourceElement ? unsubstitutedValueParameter.getSource() : SourceElement.NO_SOURCE));
        }
        return result2;
    }

    @Override
    @Nullable
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    private void setInitialSignatureDescriptor(@Nullable FunctionDescriptor initialSignatureDescriptor) {
        this.initialSignatureDescriptor = initialSignatureDescriptor;
    }

    public class CopyConfiguration
    implements FunctionDescriptor.CopyBuilder<FunctionDescriptor> {
        @NotNull
        protected TypeSubstitution substitution;
        @NotNull
        protected DeclarationDescriptor newOwner;
        @NotNull
        protected Modality newModality;
        @NotNull
        protected Visibility newVisibility;
        @Nullable
        protected FunctionDescriptor original;
        @NotNull
        protected CallableMemberDescriptor.Kind kind;
        @NotNull
        protected List<ValueParameterDescriptor> newValueParameterDescriptors;
        @Nullable
        protected KotlinType newExtensionReceiverParameterType;
        @Nullable
        protected ReceiverParameterDescriptor dispatchReceiverParameter;
        @NotNull
        protected KotlinType newReturnType;
        @Nullable
        protected Name name;
        protected boolean copyOverrides;
        protected boolean signatureChange;
        protected boolean preserveSourceElement;
        protected boolean dropOriginalInContainingParts;
        private boolean isHiddenToOvercomeSignatureClash;
        private List<TypeParameterDescriptor> newTypeParameters;
        private Annotations additionalAnnotations;
        private boolean isHiddenForResolutionEverywhereBesideSupercalls;
        private SourceElement sourceElement;
        private Map<FunctionDescriptor.UserDataKey<?>, Object> userDataMap;
        private Boolean newHasSynthesizedParameterNames;

        public CopyConfiguration(@NotNull TypeSubstitution substitution, @NotNull DeclarationDescriptor newOwner, @NotNull Modality newModality, @NotNull Visibility newVisibility, @NotNull CallableMemberDescriptor.Kind kind, @Nullable List<ValueParameterDescriptor> newValueParameterDescriptors, @NotNull KotlinType newExtensionReceiverParameterType, @Nullable KotlinType newReturnType, Name name2) {
            if (substitution == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitution", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"));
            }
            if (newOwner == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newOwner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"));
            }
            if (newModality == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newModality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"));
            }
            if (newVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newVisibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"));
            }
            if (kind == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"));
            }
            if (newValueParameterDescriptors == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newValueParameterDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"));
            }
            if (newReturnType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newReturnType", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "<init>"));
            }
            this.original = null;
            this.dispatchReceiverParameter = FunctionDescriptorImpl.this.dispatchReceiverParameter;
            this.copyOverrides = true;
            this.signatureChange = false;
            this.preserveSourceElement = false;
            this.dropOriginalInContainingParts = false;
            this.isHiddenToOvercomeSignatureClash = FunctionDescriptorImpl.this.isHiddenToOvercomeSignatureClash();
            this.newTypeParameters = null;
            this.additionalAnnotations = null;
            this.isHiddenForResolutionEverywhereBesideSupercalls = FunctionDescriptorImpl.this.isHiddenForResolutionEverywhereBesideSupercalls();
            this.userDataMap = new LinkedHashMap();
            this.newHasSynthesizedParameterNames = null;
            this.substitution = substitution;
            this.newOwner = newOwner;
            this.newModality = newModality;
            this.newVisibility = newVisibility;
            this.kind = kind;
            this.newValueParameterDescriptors = newValueParameterDescriptors;
            this.newExtensionReceiverParameterType = newExtensionReceiverParameterType;
            this.newReturnType = newReturnType;
            this.name = name2;
        }

        @NotNull
        public CopyConfiguration setOwner(@NotNull DeclarationDescriptor owner) {
            if (owner == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "owner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setOwner"));
            }
            this.newOwner = owner;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setOwner"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setModality(@NotNull Modality modality) {
            if (modality == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setModality"));
            }
            this.newModality = modality;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setModality"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setVisibility(@NotNull Visibility visibility) {
            if (visibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setVisibility"));
            }
            this.newVisibility = visibility;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setVisibility"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setKind(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setKind"));
            }
            this.kind = kind;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setKind"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setCopyOverrides(boolean copyOverrides) {
            this.copyOverrides = copyOverrides;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setCopyOverrides"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setName(@NotNull Name name2) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setName"));
            }
            this.name = name2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setName"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setValueParameters(@NotNull List<ValueParameterDescriptor> parameters2) {
            if (parameters2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setValueParameters"));
            }
            this.newValueParameterDescriptors = parameters2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setValueParameters"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setTypeParameters(@NotNull List<TypeParameterDescriptor> parameters2) {
            if (parameters2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setTypeParameters"));
            }
            this.newTypeParameters = parameters2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setTypeParameters"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setReturnType(@NotNull KotlinType type2) {
            if (type2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setReturnType"));
            }
            this.newReturnType = type2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setReturnType"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setExtensionReceiverType(@Nullable KotlinType type2) {
            this.newExtensionReceiverParameterType = type2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setExtensionReceiverType"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor dispatchReceiverParameter) {
            this.dispatchReceiverParameter = dispatchReceiverParameter;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setDispatchReceiverParameter"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setOriginal(@Nullable FunctionDescriptor original) {
            this.original = original;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setOriginal"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setSignatureChange() {
            this.signatureChange = true;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setSignatureChange"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setPreserveSourceElement() {
            this.preserveSourceElement = true;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setPreserveSourceElement"));
            }
            return copyConfiguration;
        }

        @Override
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setSource(@NotNull SourceElement source) {
            if (source == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setSource"));
            }
            this.sourceElement = source;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setSource"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setDropOriginalInContainingParts() {
            this.dropOriginalInContainingParts = true;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setDropOriginalInContainingParts"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setHiddenToOvercomeSignatureClash() {
            this.isHiddenToOvercomeSignatureClash = true;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setHiddenToOvercomeSignatureClash"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setHiddenForResolutionEverywhereBesideSupercalls() {
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setHiddenForResolutionEverywhereBesideSupercalls"));
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setAdditionalAnnotations(@NotNull Annotations additionalAnnotations) {
            if (additionalAnnotations == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "additionalAnnotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setAdditionalAnnotations"));
            }
            this.additionalAnnotations = additionalAnnotations;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setAdditionalAnnotations"));
            }
            return copyConfiguration;
        }

        public CopyConfiguration setHasSynthesizedParameterNames(boolean value) {
            this.newHasSynthesizedParameterNames = value;
            return this;
        }

        @NotNull
        public CopyConfiguration setSubstitution(@NotNull TypeSubstitution substitution) {
            if (substitution == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitution", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setSubstitution"));
            }
            this.substitution = substitution;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "setSubstitution"));
            }
            return copyConfiguration;
        }

        @Override
        @NotNull
        public <V> FunctionDescriptor.CopyBuilder<FunctionDescriptor> putUserData(@NotNull FunctionDescriptor.UserDataKey<V> userDataKey, V value) {
            if (userDataKey == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "userDataKey", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "putUserData"));
            }
            this.userDataMap.put(userDataKey, value);
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "putUserData"));
            }
            return copyConfiguration;
        }

        @Override
        @Nullable
        public FunctionDescriptor build() {
            return FunctionDescriptorImpl.this.doSubstitute(this);
        }

        @Nullable
        public FunctionDescriptor getOriginal() {
            return this.original;
        }

        @NotNull
        public TypeSubstitution getSubstitution() {
            TypeSubstitution typeSubstitution = this.substitution;
            if (typeSubstitution == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration", "getSubstitution"));
            }
            return typeSubstitution;
        }
    }
}

