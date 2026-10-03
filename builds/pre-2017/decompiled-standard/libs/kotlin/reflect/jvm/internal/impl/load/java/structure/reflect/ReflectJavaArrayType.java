/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaArrayType
extends ReflectJavaType
implements JavaArrayType {
    @NotNull
    private final ReflectJavaType componentType;
    @NotNull
    private final Type reflectType;

    @Override
    @NotNull
    public ReflectJavaType getComponentType() {
        return this.componentType;
    }

    @Override
    @NotNull
    protected Type getReflectType() {
        return this.reflectType;
    }

    public ReflectJavaArrayType(@NotNull Type reflectType) {
        ReflectJavaType reflectJavaType;
        ReflectJavaType reflectJavaType2;
        Intrinsics.checkParameterIsNotNull(reflectType, "reflectType");
        this.reflectType = reflectType;
        Type type2 = this.getReflectType();
        ReflectJavaArrayType reflectJavaArrayType = this;
        Type $receiver = type2;
        if ($receiver instanceof GenericArrayType) {
            Type type3 = ((GenericArrayType)$receiver).getGenericComponentType();
            Intrinsics.checkExpressionValueIsNotNull(type3, "genericComponentType");
            reflectJavaType2 = ReflectJavaType.Factory.create(type3);
        } else if ($receiver instanceof Class && ((Class)$receiver).isArray()) {
            Class<?> clazz = ((Class)$receiver).getComponentType();
            Intrinsics.checkExpressionValueIsNotNull(clazz, "getComponentType()");
            reflectJavaType2 = ReflectJavaType.Factory.create(clazz);
        } else {
            throw (Throwable)new IllegalArgumentException("Not an array type (" + this.getReflectType().getClass() + "): " + this.getReflectType());
        }
        reflectJavaArrayType.componentType = reflectJavaType = reflectJavaType2;
    }
}

