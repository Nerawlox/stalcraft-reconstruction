/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import org.jetbrains.annotations.NotNull;

public interface JavaArrayAnnotationArgument
extends JavaAnnotationArgument {
    @NotNull
    public List<JavaAnnotationArgument> getElements();
}

