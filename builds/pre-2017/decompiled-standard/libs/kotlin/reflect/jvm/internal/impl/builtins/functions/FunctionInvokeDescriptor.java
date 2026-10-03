/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionInvokeDescriptor
extends SimpleFunctionDescriptorImpl {
    public static final Factory Factory = new Factory(null);

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    protected FunctionDescriptor doSubstitute(@NotNull FunctionDescriptorImpl.CopyConfiguration configuration) {
        void $receiver$iv$iv;
        boolean bl;
        Object element$iv2;
        FunctionInvokeDescriptor substituted;
        block4: {
            Intrinsics.checkParameterIsNotNull(configuration, "configuration");
            FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor)super.doSubstitute(configuration);
            if (functionInvokeDescriptor == null) {
                return null;
            }
            substituted = functionInvokeDescriptor;
            Iterable $receiver$iv = substituted.getValueParameters();
            for (Object element$iv2 : $receiver$iv) {
                ValueParameterDescriptor it = (ValueParameterDescriptor)element$iv2;
                if (!(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(it.getType()) != null)) continue;
                bl = false;
                break block4;
            }
            bl = true;
        }
        if (bl) {
            return substituted;
        }
        Iterable $receiver$iv = substituted.getValueParameters();
        element$iv2 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            Name name2 = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(it.getType());
            collection.add(name2);
        }
        List parameterNames = (List)destination$iv$iv;
        return substituted.replaceParameterNames(parameterNames);
    }

    @Override
    @NotNull
    protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name newName, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        Intrinsics.checkParameterIsNotNull(newOwner, "newOwner");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(source, "source");
        return new FunctionInvokeDescriptor(newOwner, (FunctionInvokeDescriptor)original, kind, this.isSuspend());
    }

    @Override
    public boolean isExternal() {
        return false;
    }

    @Override
    public boolean isInline() {
        return false;
    }

    @Override
    public boolean isTailrec() {
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private final FunctionDescriptor replaceParameterNames(List<Name> parameterNames) {
        boolean bl;
        List newValueParameters;
        Object object;
        block5: {
            void $receiver$iv;
            Iterable $receiver$iv$iv;
            Iterable $receiver$iv2;
            boolean bl2;
            int indexShift = this.getValueParameters().size() - parameterNames.size();
            boolean bl3 = bl2 = indexShift == 0 || indexShift == 1;
            if (_Assertions.ENABLED && !bl2) {
                String string = "Assertion failed";
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            Iterable iterable = $receiver$iv2 = (Iterable)this.getValueParameters();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                Name parameterName;
                void it;
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)item$iv$iv;
                object = destination$iv$iv;
                Name newName = it.getName();
                int parameterIndex = it.getIndex();
                int nameIndex = parameterIndex - indexShift;
                if (nameIndex >= 0 && (parameterName = parameterNames.get(nameIndex)) != null) {
                    newName = parameterName;
                }
                CallableDescriptor callableDescriptor = this;
                Name name2 = newName;
                Intrinsics.checkExpressionValueIsNotNull(name2, "newName");
                ValueParameterDescriptor valueParameterDescriptor2 = it.copy(callableDescriptor, name2, parameterIndex);
                object.add(valueParameterDescriptor2);
            }
            newValueParameters = (List)destination$iv$iv;
            $receiver$iv$iv = parameterNames;
            object = this.newCopyBuilder(TypeSubstitutor.EMPTY);
            for (Object element$iv : $receiver$iv) {
                Name it = (Name)element$iv;
                if (!(it == null)) continue;
                bl = true;
                break block5;
            }
            bl = false;
        }
        boolean bl4 = bl;
        FunctionDescriptorImpl.CopyConfiguration copyConfiguration = ((FunctionDescriptorImpl.CopyConfiguration)((FunctionDescriptorImpl.CopyConfiguration)object).setHasSynthesizedParameterNames(bl4).setValueParameters(newValueParameters)).setOriginal(this.getOriginal());
        FunctionDescriptor functionDescriptor = super.doSubstitute(copyConfiguration);
        if (functionDescriptor == null) {
            Intrinsics.throwNpe();
        }
        return functionDescriptor;
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor container, FunctionInvokeDescriptor original, CallableMemberDescriptor.Kind callableKind, boolean isSuspend) {
        super(container, original, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, callableKind, SourceElement.NO_SOURCE);
        this.setOperator(true);
        this.setSuspend(isSuspend);
        this.setHasStableParameterNames(false);
    }

    public /* synthetic */ FunctionInvokeDescriptor(@NotNull DeclarationDescriptor container, @Nullable FunctionInvokeDescriptor original, @NotNull CallableMemberDescriptor.Kind callableKind, boolean isSuspend, DefaultConstructorMarker $constructor_marker) {
        this(container, original, callableKind, isSuspend);
    }

    public static final class Factory {
        /*
         * WARNING - void declaration
         */
        @NotNull
        public final FunctionInvokeDescriptor create(@NotNull FunctionClassDescriptor functionClass, boolean isSuspend) {
            void $receiver$iv$iv;
            Object item$iv;
            TypeParameterDescriptor it;
            Iterable $receiver$iv;
            Intrinsics.checkParameterIsNotNull(functionClass, "functionClass");
            List<TypeParameterDescriptor> typeParameters2 = functionClass.getDeclaredTypeParameters();
            FunctionInvokeDescriptor result2 = new FunctionInvokeDescriptor(functionClass, null, CallableMemberDescriptor.Kind.DECLARATION, isSuspend, null);
            ReceiverParameterDescriptor receiverParameterDescriptor = functionClass.getThisAsReceiverParameter();
            KotlinType kotlinType = null;
            FunctionInvokeDescriptor functionInvokeDescriptor = result2;
            List list = CollectionsKt.emptyList();
            Iterable iterable = typeParameters2;
            Iterable<Object> list$iv = new ArrayList();
            Iterator iterator2 = $receiver$iv.iterator();
            while (iterator2.hasNext() && Intrinsics.areEqual((Object)(it = (TypeParameterDescriptor)(item$iv = iterator2.next())).getVariance(), (Object)Variance.IN_VARIANCE)) {
                list$iv.add(item$iv);
            }
            Collection<ValueParameterDescriptor> collection = list$iv;
            $receiver$iv = CollectionsKt.withIndex((Iterable)collection);
            list$iv = $receiver$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void it2;
                IndexedValue $i$a$1$takeWhile = (IndexedValue)item$iv$iv;
                collection = destination$iv$iv;
                ValueParameterDescriptor valueParameterDescriptor = Factory.createValueParameter(result2, it2.getIndex(), (TypeParameterDescriptor)it2.getValue());
                collection.add(valueParameterDescriptor);
            }
            collection = (List)destination$iv$iv;
            functionInvokeDescriptor.initialize(kotlinType, receiverParameterDescriptor, list, (List)collection, (KotlinType)CollectionsKt.last(typeParameters2).getDefaultType(), Modality.ABSTRACT, Visibilities.PUBLIC);
            result2.setHasSynthesizedParameterNames(true);
            return result2;
        }

        /*
         * Unable to fully structure code
         */
        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor containingDeclaration, int index, TypeParameterDescriptor typeParameter) {
            block5: {
                var5_5 = typeParameterName = typeParameter.getName().asString();
                switch (var5_5.hashCode()) {
                    case 69: {
                        if (!var5_5.equals("E")) ** break;
                        break;
                    }
                    case 84: {
                        if (!var5_5.equals("T")) ** break;
                        v0 = "instance";
                        break block5;
                    }
                }
                v0 = "receiver";
                break block5;
                v1 = var6_6 = typeParameterName;
                if (v1 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                v2 = v1.toLowerCase();
                v0 = v2;
                Intrinsics.checkExpressionValueIsNotNull(v2, "(this as java.lang.String).toLowerCase()");
            }
            name = v0;
            v3 = containingDeclaration;
            v4 = Annotations.Companion.getEMPTY();
            v5 = Name.identifier(name);
            Intrinsics.checkExpressionValueIsNotNull(v5, "Name.identifier(name)");
            v6 = typeParameter.getDefaultType();
            Intrinsics.checkExpressionValueIsNotNull(v6, "typeParameter.defaultType");
            v7 = v6;
            v8 = SourceElement.NO_SOURCE;
            Intrinsics.checkExpressionValueIsNotNull(v8, "SourceElement.NO_SOURCE");
            return new ValueParameterDescriptorImpl(v3, null, index, v4, v5, v7, false, false, false, null, v8);
        }

        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

