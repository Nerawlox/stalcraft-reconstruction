/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class DynamicType
extends FlexibleType {
    @NotNull
    private final Annotations annotations;

    @Override
    @NotNull
    public SimpleType getDelegate() {
        return this.getUpperBound();
    }

    @Override
    @NotNull
    public DynamicType makeNullableAsSpecified(boolean newNullability) {
        return this;
    }

    @Override
    public boolean isMarkedNullable() {
        return false;
    }

    @Override
    @NotNull
    public DynamicType replaceAnnotations(@NotNull Annotations newAnnotations) {
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        return new DynamicType(TypeUtilsKt.getBuiltIns(this.getDelegate()), this.getAnnotations());
    }

    @Override
    @NotNull
    public String render(@NotNull DescriptorRenderer renderer, @NotNull DescriptorRendererOptions options) {
        Intrinsics.checkParameterIsNotNull(renderer, "renderer");
        Intrinsics.checkParameterIsNotNull(options, "options");
        return "dynamic";
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    public DynamicType(@NotNull KotlinBuiltIns builtIns, @NotNull Annotations annotations2) {
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        SimpleType simpleType2 = builtIns.getNothingType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "builtIns.nothingType");
        SimpleType simpleType3 = builtIns.getNullableAnyType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType3, "builtIns.nullableAnyType");
        super(simpleType2, simpleType3);
        this.annotations = annotations2;
    }
}

