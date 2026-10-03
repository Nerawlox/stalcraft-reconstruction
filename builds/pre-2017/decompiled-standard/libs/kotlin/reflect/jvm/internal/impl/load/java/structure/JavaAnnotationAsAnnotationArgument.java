/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import org.jetbrains.annotations.NotNull;

public interface JavaAnnotationAsAnnotationArgument
extends JavaAnnotationArgument {
    @NotNull
    public JavaAnnotation getAnnotation();
}

