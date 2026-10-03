/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collections;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public class AnnotationDescriptorImpl
implements AnnotationDescriptor {
    private final KotlinType annotationType;
    private final Map<ValueParameterDescriptor, ConstantValue<?>> valueArguments;
    private final SourceElement source;

    public AnnotationDescriptorImpl(@NotNull KotlinType annotationType, @NotNull Map<ValueParameterDescriptor, ConstantValue<?>> valueArguments2, @NotNull SourceElement source) {
        if (annotationType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotationType", "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "<init>"));
        }
        if (valueArguments2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "valueArguments", "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "<init>"));
        }
        this.annotationType = annotationType;
        this.valueArguments = Collections.unmodifiableMap(valueArguments2);
        this.source = source;
    }

    @Override
    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = this.annotationType;
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "getType"));
        }
        return kotlinType;
    }

    @Override
    @NotNull
    public Map<ValueParameterDescriptor, ConstantValue<?>> getAllValueArguments() {
        Map<ValueParameterDescriptor, ConstantValue<?>> map2 = this.valueArguments;
        if (map2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "getAllValueArguments"));
        }
        return map2;
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = this.source;
        if (sourceElement == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl", "getSource"));
        }
        return sourceElement;
    }

    public String toString() {
        return DescriptorRenderer.FQ_NAMES_IN_TYPES.renderAnnotation(this, null);
    }
}

