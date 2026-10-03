/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class AnnotationValue
extends ConstantValue<AnnotationDescriptor> {
    @Override
    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = ((AnnotationDescriptor)this.getValue()).getType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "value.type");
        return kotlinType;
    }

    @Override
    public <R, D> R accept(@NotNull AnnotationArgumentVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return visitor2.visitAnnotationValue(this, data2);
    }

    @Override
    @NotNull
    public String toString() {
        return this.getValue().toString();
    }

    public AnnotationValue(@NotNull AnnotationDescriptor value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        super(value);
    }
}

