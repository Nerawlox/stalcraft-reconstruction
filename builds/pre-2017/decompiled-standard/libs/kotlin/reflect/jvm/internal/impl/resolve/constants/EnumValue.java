/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EnumValue
extends ConstantValue<ClassDescriptor> {
    @Override
    @NotNull
    public KotlinType getType() {
        KotlinType $receiver$iv;
        KotlinType kotlinType = $receiver$iv = DescriptorUtilsKt.getClassValueType((ClassDescriptor)this.getValue());
        if (kotlinType == null) {
            AssertionError assertionError;
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = assertionError;
            String string = "Enum entry must have a class object type: " + (ClassDescriptor)this.getValue();
            assertionError2((Object)string);
            throw (Throwable)((Object)assertionError3);
        }
        return kotlinType;
    }

    @Override
    public <R, D> R accept(@NotNull AnnotationArgumentVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return visitor2.visitEnumValue(this, data2);
    }

    @Override
    @NotNull
    public String toString() {
        return this.getType() + "." + ((ClassDescriptor)this.getValue()).getName();
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
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.EnumValue");
        }
        return Intrinsics.areEqual((ClassDescriptor)this.getValue(), (ClassDescriptor)((EnumValue)object2).getValue());
    }

    public int hashCode() {
        return this.getValue().hashCode();
    }

    public EnumValue(@NotNull ClassDescriptor value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        super(value);
    }
}

