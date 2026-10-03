/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import org.jetbrains.annotations.Nullable;

public interface JavaEnumValueAnnotationArgument
extends JavaAnnotationArgument {
    @Nullable
    public JavaField resolve();
}

