/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public abstract class ConstantValue<T> {
    private final T value;

    @NotNull
    public abstract KotlinType getType();

    public abstract <R, D> R accept(@NotNull AnnotationArgumentVisitor<R, D> var1, D var2);

    @NotNull
    public String toString() {
        return String.valueOf(this.getValue());
    }

    public T getValue() {
        return this.value;
    }

    public ConstantValue(T value) {
        this.value = value;
    }
}

