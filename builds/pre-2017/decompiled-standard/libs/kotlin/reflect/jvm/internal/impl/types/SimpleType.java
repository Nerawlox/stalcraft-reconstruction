/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public abstract class SimpleType
extends UnwrappedType {
    @Override
    @NotNull
    public abstract SimpleType replaceAnnotations(@NotNull Annotations var1);

    @Override
    @NotNull
    public abstract SimpleType makeNullableAsSpecified(boolean var1);

    @NotNull
    public String toString() {
        StringBuilder stringBuilder;
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        for (AnnotationWithTarget annotationWithTarget : this.getAnnotations().getAllAnnotations()) {
            AnnotationDescriptor annotation = annotationWithTarget.component1();
            AnnotationUseSiteTarget target = annotationWithTarget.component2();
            StringsKt.append($receiver, "[", DescriptorRenderer.DEBUG_TEXT.renderAnnotation(annotation, target), "] ");
        }
        $receiver.append(this.getConstructor());
        if (!this.getArguments().isEmpty()) {
            CollectionsKt.joinTo$default(this.getArguments(), $receiver, ", ", "<", ">", 0, null, null, 112, null);
        }
        if (this.isMarkedNullable()) {
            $receiver.append("?");
        }
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public SimpleType() {
        super(null);
    }
}

