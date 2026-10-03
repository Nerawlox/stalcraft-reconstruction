/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Java8ParameterNamesLoader {
    @Nullable
    private static Cache cache;
    public static final Java8ParameterNamesLoader INSTANCE;

    @Nullable
    public final Cache getCache() {
        return cache;
    }

    public final void setCache(@Nullable Cache cache) {
        Java8ParameterNamesLoader.cache = cache;
    }

    @NotNull
    public final Cache buildCache(@NotNull Member member) {
        Method method;
        Intrinsics.checkParameterIsNotNull(member, "member");
        Class<?> methodOrConstructorClass = member.getClass();
        try {
            method = methodOrConstructorClass.getMethod("getParameters", new Class[0]);
        }
        catch (NoSuchMethodException e) {
            return new Cache(null, null);
        }
        Method getParameters = method;
        Class<?> parameterClass = ReflectClassUtilKt.getSafeClassLoader(methodOrConstructorClass).loadClass("java.lang.reflect.Parameter");
        return new Cache(getParameters, parameterClass.getMethod("getName", new Class[0]));
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final List<String> loadParameterNames(@NotNull Member member) {
        void $receiver$iv$iv;
        Object[] $receiver$iv;
        Intrinsics.checkParameterIsNotNull(member, "member");
        Cache cache = Java8ParameterNamesLoader.cache;
        if (cache == null) {
            Java8ParameterNamesLoader.cache = cache = this.buildCache(member);
        }
        Method method = cache.getGetParameters();
        if (method == null) {
            return null;
        }
        Method getParameters = method;
        Method method2 = cache.getGetName();
        if (method2 == null) {
            return null;
        }
        Method getName = method2;
        Object object = getParameters.invoke(member, new Object[0]);
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
        }
        Object[] objectArray = $receiver$iv = (Object[])object;
        Collection destination$iv$iv = new ArrayList($receiver$iv.length);
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void param;
            void item$iv$iv;
            void var10_10 = item$iv$iv = $receiver$iv$iv[i];
            Collection collection = destination$iv$iv;
            Object object2 = getName.invoke(param, new Object[0]);
            if (object2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            String string = (String)object2;
            collection.add(string);
        }
        return (List)destination$iv$iv;
    }

    private Java8ParameterNamesLoader() {
        INSTANCE = this;
    }

    static {
        new Java8ParameterNamesLoader();
    }

    public static final class Cache {
        @Nullable
        private final Method getParameters;
        @Nullable
        private final Method getName;

        @Nullable
        public final Method getGetParameters() {
            return this.getParameters;
        }

        @Nullable
        public final Method getGetName() {
            return this.getName;
        }

        public Cache(@Nullable Method getParameters, @Nullable Method getName) {
            this.getParameters = getParameters;
            this.getName = getName;
        }
    }
}

