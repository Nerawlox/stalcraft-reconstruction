/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaLiteralAnnotationArgument
extends ReflectJavaAnnotationArgument
implements JavaLiteralAnnotationArgument {
    @NotNull
    private final Object value;

    @Override
    @NotNull
    public Object getValue() {
        return this.value;
    }

    public ReflectJavaLiteralAnnotationArgument(@Nullable Name name2, @NotNull Object value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        super(name2);
        this.value = value;
    }
}

