/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CompileTimeConstant;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntegerValueTypeConstant
implements CompileTimeConstant<Number> {
    private final IntegerValueTypeConstructor typeConstructor;
    @NotNull
    private final SimpleType unknownIntegerType;
    private final Number value;
    private final KotlinBuiltIns builtIns;
    @NotNull
    private final CompileTimeConstant.Parameters parameters;

    @Override
    @NotNull
    public ConstantValue<Number> toConstantValue(@NotNull KotlinType expectedType) {
        Intrinsics.checkParameterIsNotNull(expectedType, "expectedType");
        ConstantValueFactory factory = new ConstantValueFactory(this.builtIns);
        KotlinType type2 = this.getType(expectedType);
        return KotlinBuiltIns.isInt(type2) ? (ConstantValue)factory.createIntValue(this.value.intValue()) : (KotlinBuiltIns.isByte(type2) ? (ConstantValue)factory.createByteValue(this.value.byteValue()) : (KotlinBuiltIns.isShort(type2) ? (ConstantValue)factory.createShortValue(this.value.shortValue()) : (ConstantValue)factory.createLongValue(this.value.longValue())));
    }

    @NotNull
    public final SimpleType getUnknownIntegerType() {
        return this.unknownIntegerType;
    }

    @NotNull
    public final KotlinType getType(@NotNull KotlinType expectedType) {
        Intrinsics.checkParameterIsNotNull(expectedType, "expectedType");
        KotlinType kotlinType = TypeUtils.getPrimitiveNumberType(this.typeConstructor, expectedType);
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "TypeUtils.getPrimitiveNu\u2026onstructor, expectedType)");
        return kotlinType;
    }

    @NotNull
    public String toString() {
        return this.typeConstructor.toString();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof IntegerValueTypeConstant && Intrinsics.areEqual(this.value, ((IntegerValueTypeConstant)other).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    @NotNull
    public CompileTimeConstant.Parameters getParameters() {
        return this.parameters;
    }

    public IntegerValueTypeConstant(@NotNull Number value, @NotNull KotlinBuiltIns builtIns, @NotNull CompileTimeConstant.Parameters parameters2) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        Intrinsics.checkParameterIsNotNull(parameters2, "parameters");
        this.value = value;
        this.builtIns = builtIns;
        this.parameters = parameters2;
        this.typeConstructor = new IntegerValueTypeConstructor(this.value.longValue(), this.builtIns);
        Annotations annotations2 = Annotations.Companion.getEMPTY();
        TypeConstructor typeConstructor2 = this.typeConstructor;
        List list = CollectionsKt.emptyList();
        MemberScope memberScope2 = ErrorUtils.createErrorScope("Scope for number value type (" + this.typeConstructor.toString() + ")", true);
        Intrinsics.checkExpressionValueIsNotNull(memberScope2, "ErrorUtils.createErrorSc\u2026r.toString() + \")\", true)");
        this.unknownIntegerType = KotlinTypeFactory.simpleType(annotations2, typeConstructor2, list, false, memberScope2);
    }

    @Override
    public boolean getUsesNonConstValAsConstant() {
        return CompileTimeConstant.DefaultImpls.getUsesNonConstValAsConstant(this);
    }

    @Override
    @NotNull
    public Number getValue(@NotNull KotlinType expectedType) {
        Intrinsics.checkParameterIsNotNull(expectedType, "expectedType");
        return CompileTimeConstant.DefaultImpls.getValue(this, expectedType);
    }

    @Override
    public boolean getUsesVariableAsConstant() {
        return CompileTimeConstant.DefaultImpls.getUsesVariableAsConstant(this);
    }

    @Override
    public boolean getCanBeUsedInAnnotations() {
        return CompileTimeConstant.DefaultImpls.getCanBeUsedInAnnotations(this);
    }

    @Override
    public boolean isError() {
        return CompileTimeConstant.DefaultImpls.isError(this);
    }

    @Override
    public boolean isPure() {
        return CompileTimeConstant.DefaultImpls.isPure(this);
    }
}

