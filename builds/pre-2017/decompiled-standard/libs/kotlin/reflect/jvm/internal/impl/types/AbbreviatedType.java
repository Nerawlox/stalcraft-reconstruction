/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class AbbreviatedType
extends DelegatingSimpleType {
    @NotNull
    private final SimpleType delegate;
    @NotNull
    private final SimpleType abbreviation;

    @NotNull
    public final SimpleType getExpandedType() {
        return this.getDelegate();
    }

    @Override
    @NotNull
    public AbbreviatedType replaceAnnotations(@NotNull Annotations newAnnotations) {
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        return new AbbreviatedType(this.getDelegate().replaceAnnotations(newAnnotations), this.abbreviation);
    }

    @Override
    @NotNull
    public AbbreviatedType makeNullableAsSpecified(boolean newNullability) {
        return new AbbreviatedType(this.getDelegate().makeNullableAsSpecified(newNullability), this.abbreviation.makeNullableAsSpecified(newNullability));
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

    @NotNull
    public final SimpleType getAbbreviation() {
        return this.abbreviation;
    }

    public AbbreviatedType(@NotNull SimpleType delegate, @NotNull SimpleType abbreviation) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        Intrinsics.checkParameterIsNotNull(abbreviation, "abbreviation");
        this.delegate = delegate;
        this.abbreviation = abbreviation;
    }
}

