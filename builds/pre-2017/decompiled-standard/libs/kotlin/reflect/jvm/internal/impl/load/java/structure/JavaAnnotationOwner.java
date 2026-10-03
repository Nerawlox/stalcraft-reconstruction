/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaAnnotationOwner
extends JavaElement {
    @NotNull
    public Collection<JavaAnnotation> getAnnotations();

    @Nullable
    public JavaAnnotation findAnnotation(@NotNull FqName var1);

    public boolean isDeprecatedInJavaDoc();
}

