/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CompileTimeConstant;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypedCompileTimeConstant<T>
implements CompileTimeConstant<T> {
    @NotNull
    private final KotlinType type;
    @NotNull
    private final ConstantValue<T> constantValue;
    @NotNull
    private final CompileTimeConstant.Parameters parameters;

    @Override
    public boolean isError() {
        return this.constantValue instanceof ErrorValue;
    }

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }

    @Override
    @NotNull
    public ConstantValue<T> toConstantValue(@NotNull KotlinType expectedType) {
        Intrinsics.checkParameterIsNotNull(expectedType, "expectedType");
        return this.constantValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypedCompileTimeConstant)) {
            return false;
        }
        if (this.isError()) {
            return ((TypedCompileTimeConstant)other).isError();
        }
        if (((TypedCompileTimeConstant)other).isError()) {
            return false;
        }
        return Intrinsics.areEqual(this.constantValue.getValue(), ((TypedCompileTimeConstant)other).constantValue.getValue()) && Intrinsics.areEqual(this.type, ((TypedCompileTimeConstant)other).type);
    }

    public int hashCode() {
        if (this.isError()) {
            return 13;
        }
        T t = this.constantValue.getValue();
        int result2 = t != null ? t.hashCode() : 0;
        result2 = 31 * result2 + this.type.hashCode();
        return result2;
    }

    @NotNull
    public final ConstantValue<T> getConstantValue() {
        return this.constantValue;
    }

    @Override
    @NotNull
    public CompileTimeConstant.Parameters getParameters() {
        return this.parameters;
    }

    public TypedCompileTimeConstant(@NotNull ConstantValue<? extends T> constantValue, @NotNull CompileTimeConstant.Parameters parameters2) {
        Intrinsics.checkParameterIsNotNull(constantValue, "constantValue");
        Intrinsics.checkParameterIsNotNull(parameters2, "parameters");
        this.constantValue = constantValue;
        this.parameters = parameters2;
        this.type = this.constantValue.getType();
    }

    @Override
    public boolean isPure() {
        return CompileTimeConstant.DefaultImpls.isPure(this);
    }

    @Override
    public T getValue(@NotNull KotlinType expectedType) {
        Intrinsics.checkParameterIsNotNull(expectedType, "expectedType");
        return CompileTimeConstant.DefaultImpls.getValue(this, expectedType);
    }

    @Override
    public boolean getUsesNonConstValAsConstant() {
        return CompileTimeConstant.DefaultImpls.getUsesNonConstValAsConstant(this);
    }

    @Override
    public boolean getCanBeUsedInAnnotations() {
        return CompileTimeConstant.DefaultImpls.getCanBeUsedInAnnotations(this);
    }

    @Override
    public boolean getUsesVariableAsConstant() {
        return CompileTimeConstant.DefaultImpls.getUsesVariableAsConstant(this);
    }
}

