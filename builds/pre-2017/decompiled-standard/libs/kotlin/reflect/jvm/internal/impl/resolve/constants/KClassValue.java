/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class KClassValue
extends ConstantValue<KotlinType> {
    @NotNull
    private final KotlinType type;

    @Override
    @NotNull
    public KotlinType getValue() {
        KotlinType kotlinType = CollectionsKt.single(this.getType().getArguments()).getType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "type.arguments.single().type");
        return kotlinType;
    }

    @Override
    public <R, D> R accept(@NotNull AnnotationArgumentVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return visitor2.visitKClassValue(this, data2);
    }

    @Override
    @NotNull
    public KotlinType getType() {
        return this.type;
    }

    public KClassValue(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        super(type2);
        this.type = type2;
    }
}

