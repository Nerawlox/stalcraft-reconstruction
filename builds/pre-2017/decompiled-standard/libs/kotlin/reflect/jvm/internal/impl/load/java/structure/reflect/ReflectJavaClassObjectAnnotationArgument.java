/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClassObjectAnnotationArgument
extends ReflectJavaAnnotationArgument
implements JavaClassObjectAnnotationArgument {
    private final Class<?> klass;

    @Override
    @NotNull
    public JavaType getReferencedType() {
        return ReflectJavaType.Factory.create(this.klass);
    }

    public ReflectJavaClassObjectAnnotationArgument(@Nullable Name name2, @NotNull Class<?> klass) {
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        super(name2);
        this.klass = klass;
    }
}

