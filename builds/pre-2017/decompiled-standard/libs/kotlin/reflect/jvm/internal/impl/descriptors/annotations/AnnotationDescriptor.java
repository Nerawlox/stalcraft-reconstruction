/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ReadOnly;

public interface AnnotationDescriptor {
    @NotNull
    public KotlinType getType();

    @NotNull
    @ReadOnly
    public Map<ValueParameterDescriptor, ConstantValue<?>> getAllValueArguments();

    @NotNull
    public SourceElement getSource();
}

