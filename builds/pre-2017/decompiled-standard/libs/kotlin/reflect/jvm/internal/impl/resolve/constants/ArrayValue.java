/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ArrayValue
extends ConstantValue<List<? extends ConstantValue<?>>> {
    @NotNull
    private final KotlinType type;
    private final KotlinBuiltIns builtIns;

    @Override
    public <R, D> R accept(@NotNull AnnotationArgumentVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return visitor2.visitArrayValue(this, data2);
    }

    @NotNull
    public final KotlinType getElementType() {
        KotlinType kotlinType = this.builtIns.getArrayElementType(this.getType());
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "builtIns.getArrayElementType(type)");
        return kotlinType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        Object object = other;
        if (Intrinsics.areEqual(this.getClass(), object != null ? object.getClass() : null) ^ true) {
            return false;
        }
        Object object2 = other;
        if (object2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.ArrayValue");
        }
        return Intrinsics.areEqual((List)this.getValue(), (List)((ArrayValue)object2).getValue());
    }

    public int hashCode() {
        return this.getValue().hashCode();
    }

    @Override
    @NotNull
    public KotlinType getType() {
        return this.type;
    }

    public ArrayValue(@NotNull List<? extends ConstantValue<?>> value, @NotNull KotlinType type2, @NotNull KotlinBuiltIns builtIns) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        super(value);
        this.type = type2;
        this.builtIns = builtIns;
        boolean bl2 = bl = KotlinBuiltIns.isArray(this.getType()) || KotlinBuiltIns.isPrimitiveArray(this.getType());
        if (_Assertions.ENABLED && !bl) {
            String string = "Type should be an array, but was " + this.getType() + ": " + value;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
    }
}

