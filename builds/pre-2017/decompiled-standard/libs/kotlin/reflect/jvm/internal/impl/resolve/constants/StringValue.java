/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StringValue
extends ConstantValue<String> {
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
        return visitor2.visitStringValue(this, data2);
    }

    @Override
    @NotNull
    public String toString() {
        return "\"" + (String)this.getValue() + "\"";
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || Intrinsics.areEqual(this.getClass(), other.getClass()) ^ true) {
            return false;
        }
        Object object = other;
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.StringValue");
        }
        return Intrinsics.areEqual((String)this.getValue(), (String)((StringValue)object).getValue()) ^ true;
    }

    public int hashCode() {
        return ((String)this.getValue()).hashCode();
    }

    public StringValue(@NotNull String value, @NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        super(value);
        this.type = builtIns.getStringType();
    }
}

