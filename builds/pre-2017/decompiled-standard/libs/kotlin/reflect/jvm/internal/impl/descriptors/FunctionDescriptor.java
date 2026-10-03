/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface FunctionDescriptor
extends CallableMemberDescriptor {
    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration();

    @Override
    @NotNull
    public FunctionDescriptor getOriginal();

    @Override
    @Nullable
    public FunctionDescriptor substitute(@NotNull TypeSubstitutor var1);

    @NotNull
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors();

    @Nullable
    public FunctionDescriptor getInitialSignatureDescriptor();

    public boolean isHiddenToOvercomeSignatureClash();

    @Override
    @NotNull
    public FunctionDescriptor copy(DeclarationDescriptor var1, Modality var2, Visibility var3, CallableMemberDescriptor.Kind var4, boolean var5);

    public boolean isOperator();

    public boolean isInfix();

    public boolean isInline();

    public boolean isTailrec();

    public boolean isHiddenForResolutionEverywhereBesideSupercalls();

    public boolean isSuspend();

    @Nullable
    public <V> V getUserData(UserDataKey<V> var1);

    @NotNull
    public CopyBuilder<? extends FunctionDescriptor> newCopyBuilder();

    public static interface CopyBuilder<D extends FunctionDescriptor> {
        @NotNull
        public CopyBuilder<D> setOwner(@NotNull DeclarationDescriptor var1);

        @NotNull
        public CopyBuilder<D> setModality(@NotNull Modality var1);

        @NotNull
        public CopyBuilder<D> setVisibility(@NotNull Visibility var1);

        @NotNull
        public CopyBuilder<D> setKind(@NotNull CallableMemberDescriptor.Kind var1);

        @NotNull
        public CopyBuilder<D> setCopyOverrides(boolean var1);

        @NotNull
        public CopyBuilder<D> setName(@NotNull Name var1);

        @NotNull
        public CopyBuilder<D> setValueParameters(@NotNull List<ValueParameterDescriptor> var1);

        @NotNull
        public CopyBuilder<D> setTypeParameters(@NotNull List<TypeParameterDescriptor> var1);

        @NotNull
        public CopyBuilder<D> setReturnType(@NotNull KotlinType var1);

        @NotNull
        public CopyBuilder<D> setExtensionReceiverType(@Nullable KotlinType var1);

        @NotNull
        public CopyBuilder<D> setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor var1);

        @NotNull
        public CopyBuilder<D> setOriginal(@Nullable FunctionDescriptor var1);

        @NotNull
        public CopyBuilder<D> setSignatureChange();

        @NotNull
        public CopyBuilder<D> setPreserveSourceElement();

        @NotNull
        public CopyBuilder<D> setSource(@NotNull SourceElement var1);

        @NotNull
        public CopyBuilder<D> setDropOriginalInContainingParts();

        @NotNull
        public CopyBuilder<D> setHiddenToOvercomeSignatureClash();

        @NotNull
        public CopyBuilder<D> setHiddenForResolutionEverywhereBesideSupercalls();

        @NotNull
        public CopyBuilder<D> setAdditionalAnnotations(@NotNull Annotations var1);

        @NotNull
        public CopyBuilder<D> setSubstitution(@NotNull TypeSubstitution var1);

        @NotNull
        public <V> CopyBuilder<D> putUserData(@NotNull UserDataKey<V> var1, V var2);

        @Nullable
        public D build();
    }

    public static interface UserDataKey<V> {
    }
}

