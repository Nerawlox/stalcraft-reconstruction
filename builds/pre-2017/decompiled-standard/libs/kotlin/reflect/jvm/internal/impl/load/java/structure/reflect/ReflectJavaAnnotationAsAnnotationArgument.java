/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotationAsAnnotationArgument
extends ReflectJavaAnnotationArgument
implements JavaAnnotationAsAnnotationArgument {
    private final Annotation annotation;

    @Override
    @NotNull
    public JavaAnnotation getAnnotation() {
        return new ReflectJavaAnnotation(this.annotation);
    }

    public ReflectJavaAnnotationAsAnnotationArgument(@Nullable Name name2, @NotNull Annotation annotation) {
        Intrinsics.checkParameterIsNotNull(annotation, "annotation");
        super(name2);
        this.annotation = annotation;
    }
}

