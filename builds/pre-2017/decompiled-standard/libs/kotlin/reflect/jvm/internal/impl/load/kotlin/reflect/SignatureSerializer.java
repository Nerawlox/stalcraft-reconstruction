/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

final class SignatureSerializer {
    public static final SignatureSerializer INSTANCE;

    @NotNull
    public final String methodDesc(@NotNull Method method) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] classArray = method.getParameterTypes();
        for (int i = 0; i < classArray.length; ++i) {
            Class<?> parameterType = classArray[i];
            sb.append(ReflectClassUtilKt.getDesc(parameterType));
        }
        sb.append(")");
        sb.append(ReflectClassUtilKt.getDesc(method.getReturnType()));
        String string = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "sb.toString()");
        return string;
    }

    @NotNull
    public final String constructorDesc(@NotNull Constructor<?> constructor) {
        Intrinsics.checkParameterIsNotNull(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] classArray = constructor.getParameterTypes();
        for (int i = 0; i < classArray.length; ++i) {
            Class<?> parameterType = classArray[i];
            sb.append(ReflectClassUtilKt.getDesc(parameterType));
        }
        sb.append(")V");
        String string = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "sb.toString()");
        return string;
    }

    @NotNull
    public final String fieldDesc(@NotNull Field field) {
        Intrinsics.checkParameterIsNotNull(field, "field");
        return ReflectClassUtilKt.getDesc(field.getType());
    }

    private SignatureSerializer() {
        INSTANCE = this;
    }

    static {
        new SignatureSerializer();
    }
}

