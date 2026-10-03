/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class NotNullTypeParameter
extends DelegatingSimpleType
implements CustomTypeVariable {
    @NotNull
    private final SimpleType delegate;

    @Override
    public boolean isTypeVariable() {
        return true;
    }

    @Override
    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType replacement) {
        KotlinType kotlinType;
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        UnwrappedType unwrappedType = replacement.unwrap();
        if (!TypeUtils.isNullableType(unwrappedType) && !TypeUtilsKt.isTypeParameter(unwrappedType)) {
            return unwrappedType;
        }
        UnwrappedType unwrappedType2 = unwrappedType;
        if (unwrappedType2 instanceof SimpleType) {
            kotlinType = this.prepareReplacement((SimpleType)unwrappedType);
        } else if (unwrappedType2 instanceof FlexibleType) {
            kotlinType = KotlinTypeFactory.flexibleType(this.prepareReplacement(((FlexibleType)unwrappedType).getLowerBound()), this.prepareReplacement(((FlexibleType)unwrappedType).getUpperBound()));
        } else {
            String string = "Incorrect type: " + unwrappedType;
            throw (Throwable)new IllegalStateException(string.toString());
        }
        return kotlinType;
    }

    @Override
    public boolean isMarkedNullable() {
        return false;
    }

    private final SimpleType prepareReplacement(@NotNull SimpleType $receiver) {
        SimpleType result2 = $receiver.makeNullableAsSpecified(false);
        if (!TypeUtilsKt.isTypeParameter($receiver)) {
            return result2;
        }
        return new NotNullTypeParameter(result2);
    }

    @Override
    @NotNull
    public NotNullTypeParameter replaceAnnotations(@NotNull Annotations newAnnotations) {
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        return new NotNullTypeParameter(this.getDelegate().replaceAnnotations(newAnnotations));
    }

    @Override
    @NotNull
    public SimpleType makeNullableAsSpecified(boolean newNullability) {
        return newNullability ? this.getDelegate().makeNullableAsSpecified(true) : (SimpleType)this;
    }

    @Override
    public boolean isError() {
        return false;
    }

    @Override
    @NotNull
    protected SimpleType getDelegate() {
        return this.delegate;
    }

    public NotNullTypeParameter(@NotNull SimpleType delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        this.delegate = delegate;
    }
}

