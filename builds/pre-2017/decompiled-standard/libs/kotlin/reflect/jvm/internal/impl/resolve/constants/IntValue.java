/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueConstant;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntValue
extends IntegerValueConstant<Integer> {
    @NotNull
    private final SimpleType type;

    @Override
    @NotNull
    public SimpleType getType() {
        return this.type;
    }

    @Override
    public <R, D> R accept(@NotNull AnnotationArgumentVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return visitor2.visitIntValue(this, data2);
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
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        }
        IntValue intValue = (IntValue)object2;
        return ((Number)this.getValue()).intValue() == ((Number)intValue.getValue()).intValue();
    }

    public int hashCode() {
        return ((Number)this.getValue()).intValue();
    }

    public IntValue(int value, @NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        super(value);
        this.type = builtIns.getIntType();
    }
}

