/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import org.jetbrains.annotations.NotNull;

public final class ReflectAnnotationSource
implements SourceElement {
    @NotNull
    private final Annotation annotation;

    @Override
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkExpressionValueIsNotNull(sourceFile, "SourceFile.NO_SOURCE_FILE");
        return sourceFile;
    }

    @NotNull
    public final Annotation getAnnotation() {
        return this.annotation;
    }

    public ReflectAnnotationSource(@NotNull Annotation annotation) {
        Intrinsics.checkParameterIsNotNull(annotation, "annotation");
        this.annotation = annotation;
    }
}

