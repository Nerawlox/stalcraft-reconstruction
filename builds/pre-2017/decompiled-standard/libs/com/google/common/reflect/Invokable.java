/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.reflect.Element;
import com.google.common.reflect.Parameter;
import com.google.common.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.Nullable;

@Beta
public abstract class Invokable<T, R>
extends Element
implements GenericDeclaration {
    <M extends AccessibleObject> Invokable(M member) {
        super(member);
    }

    public static Invokable<?, Object> from(Method method) {
        return new MethodInvokable(method);
    }

    public static <T> Invokable<T, T> from(Constructor<T> constructor) {
        return new ConstructorInvokable(constructor);
    }

    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    public final R invoke(@Nullable T receiver, Object ... args) throws InvocationTargetException, IllegalAccessException {
        return (R)this.invokeInternal(receiver, Preconditions.checkNotNull(args));
    }

    public final TypeToken<? extends R> getReturnType() {
        return TypeToken.of(this.getGenericReturnType());
    }

    public final ImmutableList<Parameter> getParameters() {
        Type[] parameterTypes = this.getGenericParameterTypes();
        Annotation[][] annotations2 = this.getParameterAnnotations();
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < parameterTypes.length; ++i) {
            builder.add(new Parameter(this, i, TypeToken.of(parameterTypes[i]), annotations2[i]));
        }
        return builder.build();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type2 : this.getGenericExceptionTypes()) {
            TypeToken<?> exceptionType = TypeToken.of(type2);
            builder.add(exceptionType);
        }
        return builder.build();
    }

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> returnType) {
        return this.returning(TypeToken.of(returnType));
    }

    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> returnType) {
        if (!returnType.isAssignableFrom(this.getReturnType())) {
            throw new IllegalArgumentException("Invokable is known to return " + this.getReturnType() + ", not " + returnType);
        }
        Invokable specialized = this;
        return specialized;
    }

    public final Class<? super T> getDeclaringClass() {
        return super.getDeclaringClass();
    }

    public TypeToken<T> getOwnerType() {
        return TypeToken.of(this.getDeclaringClass());
    }

    abstract Object invokeInternal(@Nullable Object var1, Object[] var2) throws InvocationTargetException, IllegalAccessException;

    abstract Type[] getGenericParameterTypes();

    abstract Type[] getGenericExceptionTypes();

    abstract Annotation[][] getParameterAnnotations();

    abstract Type getGenericReturnType();

    static class ConstructorInvokable<T>
    extends Invokable<T, T> {
        private final Constructor<?> constructor;

        ConstructorInvokable(Constructor<?> constructor) {
            super(constructor);
            this.constructor = constructor;
        }

        @Override
        final Object invokeInternal(@Nullable Object receiver, Object[] args) throws InvocationTargetException, IllegalAccessException {
            try {
                return this.constructor.newInstance(args);
            }
            catch (InstantiationException e) {
                throw new RuntimeException(this.constructor + " failed.", e);
            }
        }

        @Override
        Type getGenericReturnType() {
            return this.constructor.getDeclaringClass();
        }

        @Override
        Type[] getGenericParameterTypes() {
            Type[] types = this.constructor.getGenericParameterTypes();
            Class<?> declaringClass = this.constructor.getDeclaringClass();
            if (!Modifier.isStatic(declaringClass.getModifiers()) && declaringClass.getEnclosingClass() != null && types.length == this.constructor.getParameterTypes().length) {
                return Arrays.copyOfRange(types, 1, types.length);
            }
            return types;
        }

        @Override
        Type[] getGenericExceptionTypes() {
            return this.constructor.getGenericExceptionTypes();
        }

        @Override
        final Annotation[][] getParameterAnnotations() {
            return this.constructor.getParameterAnnotations();
        }

        @Override
        public final TypeVariable<?>[] getTypeParameters() {
            return this.constructor.getTypeParameters();
        }

        @Override
        public final boolean isOverridable() {
            return false;
        }

        @Override
        public final boolean isVarArgs() {
            return this.constructor.isVarArgs();
        }
    }

    static class MethodInvokable<T>
    extends Invokable<T, Object> {
        private final Method method;

        MethodInvokable(Method method) {
            super(method);
            this.method = method;
        }

        @Override
        final Object invokeInternal(@Nullable Object receiver, Object[] args) throws InvocationTargetException, IllegalAccessException {
            return this.method.invoke(receiver, args);
        }

        @Override
        Type getGenericReturnType() {
            return this.method.getGenericReturnType();
        }

        @Override
        Type[] getGenericParameterTypes() {
            return this.method.getGenericParameterTypes();
        }

        @Override
        Type[] getGenericExceptionTypes() {
            return this.method.getGenericExceptionTypes();
        }

        @Override
        final Annotation[][] getParameterAnnotations() {
            return this.method.getParameterAnnotations();
        }

        @Override
        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }

        @Override
        public final boolean isOverridable() {
            return !this.isFinal() && !this.isPrivate() && !this.isStatic() && !Modifier.isFinal(this.getDeclaringClass().getModifiers());
        }

        @Override
        public final boolean isVarArgs() {
            return this.method.isVarArgs();
        }
    }
}

