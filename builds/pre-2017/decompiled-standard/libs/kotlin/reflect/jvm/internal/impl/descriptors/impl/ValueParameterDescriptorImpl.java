/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ValueParameterDescriptorImpl
extends VariableDescriptorImpl
implements ValueParameterDescriptor {
    private final ValueParameterDescriptor original;
    private final int index;
    private final boolean declaresDefaultValue;
    private final boolean isCrossinline;
    private final boolean isNoinline;
    @Nullable
    private final KotlinType varargElementType;
    public static final Companion Companion = new Companion(null);

    @Override
    @NotNull
    public CallableDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = super.getContainingDeclaration();
        if (declarationDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        }
        return (CallableDescriptor)declarationDescriptor;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean declaresDefaultValue() {
        if (!this.declaresDefaultValue) return false;
        CallableDescriptor callableDescriptor = this.getContainingDeclaration();
        if (callableDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        }
        if (!((CallableMemberDescriptor)callableDescriptor).getKind().isReal()) return false;
        return true;
    }

    @Override
    @NotNull
    public ValueParameterDescriptor getOriginal() {
        return this.original == this ? (ValueParameterDescriptor)this : this.original.getOriginal();
    }

    @Override
    @NotNull
    public ValueParameterDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        Intrinsics.checkParameterIsNotNull(substitutor, "substitutor");
        if (substitutor.isEmpty()) {
            return this;
        }
        throw (Throwable)new UnsupportedOperationException();
    }

    @Override
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return visitor2.visitValueParameterDescriptor(this, data2);
    }

    @Override
    public boolean isVar() {
        return false;
    }

    @Nullable
    public Void getCompileTimeInitializer() {
        return null;
    }

    @Override
    @NotNull
    public ValueParameterDescriptor copy(@NotNull CallableDescriptor newOwner, @NotNull Name newName, int newIndex) {
        Intrinsics.checkParameterIsNotNull(newOwner, "newOwner");
        Intrinsics.checkParameterIsNotNull(newName, "newName");
        Annotations annotations2 = this.getAnnotations();
        Intrinsics.checkExpressionValueIsNotNull(annotations2, "annotations");
        KotlinType kotlinType = this.getType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "type");
        boolean bl = this.declaresDefaultValue();
        boolean bl2 = this.isCrossinline();
        boolean bl3 = this.isNoinline();
        KotlinType kotlinType2 = this.getVarargElementType();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
        return new ValueParameterDescriptorImpl(newOwner, null, newIndex, annotations2, newName, kotlinType, bl, bl2, bl3, kotlinType2, sourceElement);
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        return Visibilities.LOCAL;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)this.getContainingDeclaration().getOverriddenDescriptors();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            CallableDescriptor callableDescriptor = (CallableDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            ValueParameterDescriptor valueParameterDescriptor = it.getValueParameters().get(this.getIndex());
            collection.add(valueParameterDescriptor);
        }
        return (List)var3_3;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean isCrossinline() {
        return this.isCrossinline;
    }

    @Override
    public boolean isNoinline() {
        return this.isNoinline;
    }

    @Override
    @Nullable
    public KotlinType getVarargElementType() {
        return this.varargElementType;
    }

    public ValueParameterDescriptorImpl(@NotNull CallableDescriptor containingDeclaration, @Nullable ValueParameterDescriptor original, int index, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull KotlinType outType, boolean declaresDefaultValue, boolean isCrossinline, boolean isNoinline, @Nullable KotlinType varargElementType, @NotNull SourceElement source) {
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(outType, "outType");
        Intrinsics.checkParameterIsNotNull(source, "source");
        super(containingDeclaration, annotations2, name2, outType, source);
        this.index = index;
        this.declaresDefaultValue = declaresDefaultValue;
        this.isCrossinline = isCrossinline;
        this.isNoinline = isNoinline;
        this.varargElementType = varargElementType;
        ValueParameterDescriptor valueParameterDescriptor = original;
        if (valueParameterDescriptor == null) {
            valueParameterDescriptor = this;
        }
        this.original = valueParameterDescriptor;
    }

    @JvmStatic
    @Nullable
    public static final List<VariableDescriptor> getDestructuringVariablesOrNull(@NotNull ValueParameterDescriptor valueParameterDescriptor) {
        Intrinsics.checkParameterIsNotNull(valueParameterDescriptor, "valueParameterDescriptor");
        return Companion.getDestructuringVariablesOrNull(valueParameterDescriptor);
    }

    @JvmStatic
    @NotNull
    public static final ValueParameterDescriptorImpl createWithDestructuringDeclarations(@NotNull CallableDescriptor containingDeclaration, @Nullable ValueParameterDescriptor original, int index, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull KotlinType outType, boolean declaresDefaultValue, boolean isCrossinline, boolean isNoinline, @Nullable KotlinType varargElementType, @NotNull SourceElement source, @Nullable Function0<? extends List<? extends VariableDescriptor>> destructuringVariables) {
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(outType, "outType");
        Intrinsics.checkParameterIsNotNull(source, "source");
        return Companion.createWithDestructuringDeclarations(containingDeclaration, original, index, annotations2, name2, outType, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, source, destructuringVariables);
    }

    public static final class WithDestructuringDeclaration
    extends ValueParameterDescriptorImpl {
        @NotNull
        private final Lazy destructuringVariables$delegate;
        static final /* synthetic */ KProperty[] $$delegatedProperties;

        @NotNull
        public final List<VariableDescriptor> getDestructuringVariables() {
            Lazy lazy = this.destructuringVariables$delegate;
            WithDestructuringDeclaration withDestructuringDeclaration = this;
            KProperty kProperty = $$delegatedProperties[0];
            return (List)lazy.getValue();
        }

        public WithDestructuringDeclaration(@NotNull CallableDescriptor containingDeclaration, @Nullable ValueParameterDescriptor original, int index, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull KotlinType outType, boolean declaresDefaultValue, boolean isCrossinline, boolean isNoinline, @Nullable KotlinType varargElementType, @NotNull SourceElement source, @NotNull Function0<? extends List<? extends VariableDescriptor>> destructuringVariables) {
            Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
            Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(outType, "outType");
            Intrinsics.checkParameterIsNotNull(source, "source");
            Intrinsics.checkParameterIsNotNull(destructuringVariables, "destructuringVariables");
            super(containingDeclaration, original, index, annotations2, name2, outType, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, source);
            this.destructuringVariables$delegate = LazyKt.lazy(destructuringVariables);
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(WithDestructuringDeclaration.class), "destructuringVariables", "getDestructuringVariables()Ljava/util/List;"))};
        }
    }

    public static final class Companion {
        @JvmStatic
        @Nullable
        public final List<VariableDescriptor> getDestructuringVariablesOrNull(@NotNull ValueParameterDescriptor valueParameterDescriptor) {
            Intrinsics.checkParameterIsNotNull(valueParameterDescriptor, "valueParameterDescriptor");
            ValueParameterDescriptor valueParameterDescriptor2 = valueParameterDescriptor;
            if (!(valueParameterDescriptor2 instanceof WithDestructuringDeclaration)) {
                valueParameterDescriptor2 = null;
            }
            WithDestructuringDeclaration withDestructuringDeclaration = (WithDestructuringDeclaration)valueParameterDescriptor2;
            return withDestructuringDeclaration != null ? withDestructuringDeclaration.getDestructuringVariables() : null;
        }

        @JvmStatic
        @NotNull
        public final ValueParameterDescriptorImpl createWithDestructuringDeclarations(@NotNull CallableDescriptor containingDeclaration, @Nullable ValueParameterDescriptor original, int index, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull KotlinType outType, boolean declaresDefaultValue, boolean isCrossinline, boolean isNoinline, @Nullable KotlinType varargElementType, @NotNull SourceElement source, @Nullable Function0<? extends List<? extends VariableDescriptor>> destructuringVariables) {
            Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
            Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(outType, "outType");
            Intrinsics.checkParameterIsNotNull(source, "source");
            return destructuringVariables == null ? new ValueParameterDescriptorImpl(containingDeclaration, original, index, annotations2, name2, outType, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, source) : (ValueParameterDescriptorImpl)new WithDestructuringDeclaration(containingDeclaration, original, index, annotations2, name2, outType, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, source, destructuringVariables);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

