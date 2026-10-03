/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class BooleanValue
extends ConstantValue<Boolean> {
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
        return visitor2.visitBooleanValue(this, data2);
    }

    public BooleanValue(boolean value, @NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        super(value);
        this.type = builtIns.getBooleanType();
    }
}

