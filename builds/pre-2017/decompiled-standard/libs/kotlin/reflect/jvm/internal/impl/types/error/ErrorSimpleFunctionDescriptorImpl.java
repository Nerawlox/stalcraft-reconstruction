/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ErrorSimpleFunctionDescriptorImpl
extends SimpleFunctionDescriptorImpl {
    private final ErrorUtils.ErrorScope ownerScope;

    public ErrorSimpleFunctionDescriptorImpl(@NotNull ClassDescriptor containingDeclaration, @NotNull ErrorUtils.ErrorScope ownerScope) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "<init>"));
        }
        if (ownerScope == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "ownerScope", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "<init>"));
        }
        super((DeclarationDescriptor)containingDeclaration, null, Annotations.Companion.getEMPTY(), Name.special("<ERROR FUNCTION>"), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
        this.ownerScope = ownerScope;
    }

    @Override
    @NotNull
    protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name newName, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        if (newOwner == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newOwner", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "createSubstitutedCopy"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "createSubstitutedCopy"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "createSubstitutedCopy"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "createSubstitutedCopy"));
        }
        ErrorSimpleFunctionDescriptorImpl errorSimpleFunctionDescriptorImpl = this;
        if (errorSimpleFunctionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "createSubstitutedCopy"));
        }
        return errorSimpleFunctionDescriptorImpl;
    }

    @Override
    @NotNull
    public SimpleFunctionDescriptor copy(DeclarationDescriptor newOwner, Modality modality, Visibility visibility, CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        ErrorSimpleFunctionDescriptorImpl errorSimpleFunctionDescriptorImpl = this;
        if (errorSimpleFunctionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "copy"));
        }
        return errorSimpleFunctionDescriptorImpl;
    }

    @Override
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder() {
        FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> copyBuilder = new FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor>(){

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOwner(@NotNull DeclarationDescriptor owner) {
                if (owner == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "owner", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setOwner"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setOwner"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setModality(@NotNull Modality modality) {
                if (modality == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setModality"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setModality"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setVisibility(@NotNull Visibility visibility) {
                if (visibility == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setVisibility"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setVisibility"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setKind(@NotNull CallableMemberDescriptor.Kind kind) {
                if (kind == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setKind"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setKind"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setCopyOverrides(boolean copyOverrides) {
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setCopyOverrides"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setName(@NotNull Name name2) {
                if (name2 == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setName"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setName"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setValueParameters(@NotNull List<ValueParameterDescriptor> parameters2) {
                if (parameters2 == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameters", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setValueParameters"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setValueParameters"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSubstitution(@NotNull TypeSubstitution substitution) {
                if (substitution == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitution", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setSubstitution"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setSubstitution"));
                }
                return v0;
            }

            @Override
            @NotNull
            public <V> FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> putUserData(@NotNull FunctionDescriptor.UserDataKey<V> userDataKey, V value) {
                if (userDataKey == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "userDataKey", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "putUserData"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "putUserData"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setTypeParameters(@NotNull List<TypeParameterDescriptor> parameters2) {
                if (parameters2 == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameters", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setTypeParameters"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setTypeParameters"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setReturnType(@NotNull KotlinType type2) {
                if (type2 == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setReturnType"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setReturnType"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setExtensionReceiverType(@Nullable KotlinType type2) {
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setExtensionReceiverType"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor dispatchReceiverParameter) {
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setDispatchReceiverParameter"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOriginal(@Nullable FunctionDescriptor original) {
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setOriginal"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSignatureChange() {
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setSignatureChange"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setPreserveSourceElement() {
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setPreserveSourceElement"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSource(@NotNull SourceElement source) {
                if (source == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setSource"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setSource"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDropOriginalInContainingParts() {
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setDropOriginalInContainingParts"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenToOvercomeSignatureClash() {
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setHiddenToOvercomeSignatureClash"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setHiddenForResolutionEverywhereBesideSupercalls"));
                }
                return v0;
            }

            @Override
            @NotNull
            public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setAdditionalAnnotations(@NotNull Annotations additionalAnnotations) {
                if (additionalAnnotations == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "additionalAnnotations", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setAdditionalAnnotations"));
                }
                1 v0 = this;
                if (v0 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1", "setAdditionalAnnotations"));
                }
                return v0;
            }

            @Override
            @Nullable
            public SimpleFunctionDescriptor build() {
                return ErrorSimpleFunctionDescriptorImpl.this;
            }
        };
        if (copyBuilder == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "newCopyBuilder"));
        }
        return copyBuilder;
    }

    @Override
    public boolean isSuspend() {
        return false;
    }

    @Override
    public <V> V getUserData(FunctionDescriptor.UserDataKey<V> key) {
        return null;
    }

    @Override
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        if (overriddenDescriptors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overriddenDescriptors", "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl", "setOverriddenDescriptors"));
        }
    }
}

