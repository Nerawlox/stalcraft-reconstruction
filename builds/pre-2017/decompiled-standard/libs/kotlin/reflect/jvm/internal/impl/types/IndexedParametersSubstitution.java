/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IndexedParametersSubstitution
extends TypeSubstitution {
    @NotNull
    private final TypeParameterDescriptor[] parameters;
    @NotNull
    private final TypeProjection[] arguments;
    private final boolean approximateCapturedTypes;

    @Override
    public boolean isEmpty() {
        Object[] objectArray = this.arguments;
        return objectArray.length == 0;
    }

    @Override
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateCapturedTypes;
    }

    @Override
    @Nullable
    public TypeProjection get(@NotNull KotlinType key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        ClassifierDescriptor classifierDescriptor = key.getConstructor().getDeclarationDescriptor();
        if (!(classifierDescriptor instanceof TypeParameterDescriptor)) {
            classifierDescriptor = null;
        }
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)classifierDescriptor;
        if (typeParameterDescriptor == null) {
            return null;
        }
        TypeParameterDescriptor parameter = typeParameterDescriptor;
        int index = parameter.getIndex();
        if (index < ((Object[])this.parameters).length && Intrinsics.areEqual(this.parameters[index].getTypeConstructor(), parameter.getTypeConstructor())) {
            return this.arguments[index];
        }
        return null;
    }

    @NotNull
    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    @NotNull
    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    public IndexedParametersSubstitution(@NotNull TypeParameterDescriptor[] parameters2, @NotNull TypeProjection[] arguments2, boolean approximateCapturedTypes2) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(parameters2, "parameters");
        Intrinsics.checkParameterIsNotNull(arguments2, "arguments");
        this.parameters = parameters2;
        this.arguments = arguments2;
        this.approximateCapturedTypes = approximateCapturedTypes2;
        boolean bl2 = bl = ((Object[])this.parameters).length <= ((Object[])this.arguments).length;
        if (_Assertions.ENABLED && !bl) {
            String string = "Number of arguments should not be less then number of parameters, but: parameters=" + ((Object[])this.parameters).length + ", args=" + ((Object[])this.arguments).length;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
    }

    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArray, TypeProjection[] typeProjectionArray, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            bl = false;
        }
        this(typeParameterDescriptorArray, typeProjectionArray, bl);
    }

    public IndexedParametersSubstitution(@NotNull List<? extends TypeParameterDescriptor> parameters2, @NotNull List<? extends TypeProjection> argumentsList) {
        Collection $receiver$iv;
        Intrinsics.checkParameterIsNotNull(parameters2, "parameters");
        Intrinsics.checkParameterIsNotNull(argumentsList, "argumentsList");
        Collection collection = parameters2;
        IndexedParametersSubstitution indexedParametersSubstitution = this;
        void v0 = $receiver$iv;
        if (v0 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        Collection thisCollection$iv = (Collection)v0;
        TypeParameterDescriptor[] typeParameterDescriptorArray = thisCollection$iv.toArray(new TypeParameterDescriptor[thisCollection$iv.size()]);
        if (typeParameterDescriptorArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Object[] objectArray = typeParameterDescriptorArray;
        $receiver$iv = argumentsList;
        objectArray = (TypeParameterDescriptor[])objectArray;
        Collection collection2 = $receiver$iv;
        if (collection2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        thisCollection$iv = collection2;
        TypeProjection[] typeProjectionArray = thisCollection$iv.toArray(new TypeProjection[thisCollection$iv.size()]);
        if (typeProjectionArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Object[] objectArray2 = typeProjectionArray;
        indexedParametersSubstitution((TypeParameterDescriptor[])objectArray, (TypeProjection[])objectArray2, false, 4, null);
    }
}

