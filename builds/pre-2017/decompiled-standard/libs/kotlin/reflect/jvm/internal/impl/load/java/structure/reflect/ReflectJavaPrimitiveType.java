/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaPrimitiveType
extends ReflectJavaType
implements JavaPrimitiveType {
    @NotNull
    private final Class<?> reflectType;

    @Override
    @Nullable
    public PrimitiveType getType() {
        return Intrinsics.areEqual(this.getReflectType(), Void.TYPE) ? null : JvmPrimitiveType.get(((Class)this.getReflectType()).getName()).getPrimitiveType();
    }

    @Override
    @NotNull
    protected Class<?> getReflectType() {
        return this.reflectType;
    }

    public ReflectJavaPrimitiveType(@NotNull Class<?> reflectType) {
        Intrinsics.checkParameterIsNotNull(reflectType, "reflectType");
        this.reflectType = reflectType;
    }
}

