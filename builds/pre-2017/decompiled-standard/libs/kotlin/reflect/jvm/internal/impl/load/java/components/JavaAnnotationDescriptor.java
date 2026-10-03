/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaAnnotationDescriptor
implements AnnotationDescriptor {
    private final SourceElement source;
    @Nullable
    private final JavaAnnotationArgument firstArgument;
    private final ClassDescriptor kotlinAnnotationClassDescriptor;

    @Override
    @NotNull
    public SimpleType getType() {
        return this.kotlinAnnotationClassDescriptor.getDefaultType();
    }

    @Override
    public SourceElement getSource() {
        return this.source;
    }

    @NotNull
    protected final List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = ((ClassConstructorDescriptor)CollectionsKt.single((Iterable)this.kotlinAnnotationClassDescriptor.getConstructors())).getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(list, "kotlinAnnotationClassDes\u2026.single().valueParameters");
        return list;
    }

    @Nullable
    protected final JavaAnnotationArgument getFirstArgument() {
        return this.firstArgument;
    }

    @Override
    @NotNull
    public Map<ValueParameterDescriptor, ConstantValue<?>> getAllValueArguments() {
        return MapsKt.emptyMap();
    }

    /*
     * Unable to fully structure code
     */
    public JavaAnnotationDescriptor(@NotNull LazyJavaResolverContext c, @Nullable JavaAnnotation annotation, @NotNull ClassDescriptor kotlinAnnotationClassDescriptor) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(kotlinAnnotationClassDescriptor, "kotlinAnnotationClassDescriptor");
        super();
        this.kotlinAnnotationClassDescriptor = kotlinAnnotationClassDescriptor;
        v0 = this;
        v1 = annotation;
        if (v1 == null) ** GOTO lbl-1000
        var4_4 = v1;
        var5_5 = v0;
        it = var4_4;
        var7_7 = c.getComponents().getSourceElementFactory().source(it);
        v0 = var5_5;
        v1 = var7_7;
        if (v1 != null) {
            v2 = (SourceElement)v1;
        } else lbl-1000:
        // 2 sources

        {
            v2 = SourceElement.NO_SOURCE;
        }
        v0.source = v2;
        v3 = annotation;
        this.firstArgument = v3 != null && (v3 = v3.getArguments()) != null ? (JavaAnnotationArgument)CollectionsKt.firstOrNull((Iterable)v3) : null;
    }
}

