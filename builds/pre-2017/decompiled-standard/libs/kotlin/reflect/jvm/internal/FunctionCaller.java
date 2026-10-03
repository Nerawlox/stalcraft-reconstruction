/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001e\b \u0018\u0000 /*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u001a#$%&'()*+,-./0123456789:;<B1\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\u0002\u0010\u000bJ\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\nH&\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u001f2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\nH\u0014\u00a2\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0004R\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00028\u0000X\u0080\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006="}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller;", "M", "Ljava/lang/reflect/Member;", "", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "arity", "", "getArity", "()I", "getInstanceClass$kotlin_reflection", "()Ljava/lang/Class;", "getMember$kotlin_reflection", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType$kotlin_reflection", "()Ljava/lang/reflect/Type;", "call", "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "checkObjectInstance", "obj", "BoundClassCompanionFieldGetter", "BoundClassCompanionFieldSetter", "BoundConstructor", "BoundInstanceFieldGetter", "BoundInstanceFieldSetter", "BoundInstanceMethod", "BoundJvmStaticInObject", "BoundJvmStaticInObjectFieldGetter", "BoundJvmStaticInObjectFieldSetter", "BoundStaticMethod", "ClassCompanionFieldGetter", "ClassCompanionFieldSetter", "Companion", "Constructor", "FieldGetter", "FieldSetter", "InstanceFieldGetter", "InstanceFieldSetter", "InstanceMethod", "JvmStaticInObject", "JvmStaticInObjectFieldGetter", "JvmStaticInObjectFieldSetter", "Method", "StaticFieldGetter", "StaticFieldSetter", "StaticMethod", "kotlin-reflection"})
public abstract class FunctionCaller<M extends Member> {
    @NotNull
    private final List<Type> parameterTypes;
    private final M member;
    @NotNull
    private final Type returnType;
    @Nullable
    private final Class<?> instanceClass;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    public final int getArity() {
        return this.parameterTypes.size();
    }

    @Nullable
    public abstract Object call(@NotNull Object[] var1);

    protected void checkArguments(@NotNull Object[] args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (this.getArity() != args.length) {
            throw (Throwable)new IllegalArgumentException("Callable expects " + this.getArity() + " arguments, but " + args.length + " were provided.");
        }
    }

    protected final void checkObjectInstance(@Nullable Object obj) {
        block5: {
            block4: {
                if (obj == null) break block4;
                M m = this.member;
                if (m == null) {
                    Intrinsics.throwNpe();
                }
                if (m.getDeclaringClass().isInstance(obj)) break block5;
            }
            throw (Throwable)new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public final M getMember$kotlin_reflection() {
        return this.member;
    }

    @NotNull
    public final Type getReturnType$kotlin_reflection() {
        return this.returnType;
    }

    @Nullable
    public final Class<?> getInstanceClass$kotlin_reflection() {
        return this.instanceClass;
    }

    public FunctionCaller(M member, @NotNull Type returnType, @Nullable Class<?> instanceClass, @NotNull Type[] valueParameterTypes) {
        List<Type[]> list;
        block3: {
            block2: {
                Intrinsics.checkParameterIsNotNull(returnType, "returnType");
                Intrinsics.checkParameterIsNotNull(valueParameterTypes, "valueParameterTypes");
                this.member = member;
                this.returnType = returnType;
                this.instanceClass = instanceClass;
                FunctionCaller functionCaller = this;
                list = this.instanceClass;
                if (list == null) break block2;
                Class<?> clazz = list;
                FunctionCaller functionCaller2 = functionCaller;
                Class<?> it = clazz;
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.add(it);
                spreadBuilder.addSpread(valueParameterTypes);
                List<Type[]> list2 = CollectionsKt.listOf((Type[])spreadBuilder.toArray(new Type[spreadBuilder.size()]));
                functionCaller = functionCaller2;
                list = list2;
                if (list != null) break block3;
            }
            list = ArraysKt.toList((Object[])valueParameterTypes);
        }
        functionCaller.parameterTypes = list;
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$Constructor;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class Constructor
    extends FunctionCaller<java.lang.reflect.Constructor<?>> {
        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            return ((java.lang.reflect.Constructor)this.getMember$kotlin_reflection()).newInstance(Arrays.copyOf(args, args.length));
        }

        public Constructor(@NotNull java.lang.reflect.Constructor<?> constructor) {
            Intrinsics.checkParameterIsNotNull(constructor, "constructor");
            Member member = constructor;
            Class<?> clazz = constructor.getDeclaringClass();
            Intrinsics.checkExpressionValueIsNotNull(clazz, "constructor.declaringClass");
            Class<?> clazz2 = constructor.getDeclaringClass();
            Type type2 = clazz;
            Member member2 = member;
            Constructor constructor2 = this;
            Class<?> klass = clazz2;
            Class<?> outerClass = klass.getDeclaringClass();
            Class<?> clazz3 = outerClass != null && !Modifier.isStatic(klass.getModifiers()) ? outerClass : null;
            Type[] typeArray = constructor.getGenericParameterTypes();
            Intrinsics.checkExpressionValueIsNotNull(typeArray, "constructor.genericParameterTypes");
            super(member2, type2, clazz3, typeArray);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundConstructor;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class BoundConstructor
    extends FunctionCaller<java.lang.reflect.Constructor<?>> {
        private final Object boundReceiver;

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            Object[] objectArray = Companion.argsWithReceiver(this.boundReceiver, args);
            return ((java.lang.reflect.Constructor)this.getMember$kotlin_reflection()).newInstance(Arrays.copyOf(objectArray, objectArray.length));
        }

        public BoundConstructor(@NotNull java.lang.reflect.Constructor<?> constructor, @Nullable Object boundReceiver) {
            Intrinsics.checkParameterIsNotNull(constructor, "constructor");
            Member member = constructor;
            Class<?> clazz = constructor.getDeclaringClass();
            Intrinsics.checkExpressionValueIsNotNull(clazz, "constructor.declaringClass");
            Type type2 = clazz;
            Type[] typeArray = constructor.getGenericParameterTypes();
            Intrinsics.checkExpressionValueIsNotNull(typeArray, "constructor.genericParameterTypes");
            super(member, type2, null, typeArray);
            this.boundReceiver = boundReceiver;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ%\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0004\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static abstract class Method
    extends FunctionCaller<java.lang.reflect.Method> {
        private final boolean isVoidMethod;

        @Nullable
        protected final Object callMethod(@Nullable Object instance, @NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            Object result2 = ((java.lang.reflect.Method)this.getMember$kotlin_reflection()).invoke(instance, Arrays.copyOf(args, args.length));
            return this.isVoidMethod ? Unit.INSTANCE : result2;
        }

        public Method(@NotNull java.lang.reflect.Method method, boolean requiresInstance, @NotNull Type[] parameterTypes) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            Intrinsics.checkParameterIsNotNull(parameterTypes, "parameterTypes");
            Member member = method;
            Type type2 = method.getGenericReturnType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "method.genericReturnType");
            super(member, type2, requiresInstance ? method.getDeclaringClass() : null, parameterTypes);
            this.isVoidMethod = Intrinsics.areEqual(this.getReturnType$kotlin_reflection(), Void.TYPE);
        }

        public /* synthetic */ Method(java.lang.reflect.Method method, boolean bl, Type[] typeArray, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                boolean bl2 = bl = !Modifier.isStatic(method.getModifiers());
            }
            if ((n & 4) != 0) {
                Type[] typeArray2 = method.getGenericParameterTypes();
                Intrinsics.checkExpressionValueIsNotNull(typeArray2, "method.genericParameterTypes");
                typeArray = typeArray2;
            }
            this(method, bl, typeArray);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class StaticMethod
    extends Method {
        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            return this.callMethod(null, args);
        }

        public StaticMethod(@NotNull java.lang.reflect.Method method) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            super(method, false, null, 6, null);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class InstanceMethod
    extends Method {
        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            return this.callMethod(args[0], Companion.dropFirstArg(args));
        }

        public InstanceMethod(@NotNull java.lang.reflect.Method method) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            super(method, false, null, 6, null);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class JvmStaticInObject
    extends Method {
        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            this.checkObjectInstance(ArraysKt.firstOrNull(args));
            return this.callMethod(null, Companion.dropFirstArg(args));
        }

        public JvmStaticInObject(@NotNull java.lang.reflect.Method method) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            super(method, true, null, 4, null);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundStaticMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class BoundStaticMethod
    extends Method {
        private final Object boundReceiver;

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            return this.callMethod(null, Companion.argsWithReceiver(this.boundReceiver, args));
        }

        /*
         * WARNING - void declaration
         */
        public BoundStaticMethod(@NotNull java.lang.reflect.Method method, @Nullable Object boundReceiver) {
            Object[] objectArray;
            void $receiver$iv;
            Intrinsics.checkParameterIsNotNull(method, "method");
            Object[] objectArray2 = method.getGenericParameterTypes();
            Companion companion = Companion;
            boolean bl = false;
            java.lang.reflect.Method method2 = method;
            BoundStaticMethod boundStaticMethod = this;
            if (((void)$receiver$iv).length <= 1) {
                objectArray = new Type[0];
            } else {
                void var8_8 = $receiver$iv;
                int n = 1;
                int n2 = ((void)$receiver$iv).length;
                T[] TArray = Arrays.copyOfRange(var8_8, n, n2);
                Intrinsics.checkExpressionValueIsNotNull(TArray, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
                if (TArray == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                objectArray = TArray;
            }
            Object[] objectArray3 = objectArray;
            super(method2, bl, (Type[])objectArray3);
            this.boundReceiver = boundReceiver;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class BoundInstanceMethod
    extends Method {
        private final Object boundReceiver;

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            return this.callMethod(this.boundReceiver, args);
        }

        public BoundInstanceMethod(@NotNull java.lang.reflect.Method method, @Nullable Object boundReceiver) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            super(method, false, null, 4, null);
            this.boundReceiver = boundReceiver;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class BoundJvmStaticInObject
    extends Method {
        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            return this.callMethod(null, args);
        }

        public BoundJvmStaticInObject(@NotNull java.lang.reflect.Method method) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            super(method, false, null, 4, null);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static abstract class FieldGetter
    extends FunctionCaller<Field> {
        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            return ((Field)this.getMember$kotlin_reflection()).get(this.getInstanceClass$kotlin_reflection() != null ? ArraysKt.first(args) : null);
        }

        public FieldGetter(@NotNull Field field, boolean requiresInstance) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            Member member = field;
            Type type2 = field.getGenericType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "field.genericType");
            Class<?> clazz = requiresInstance ? field.getDeclaringClass() : null;
            Type type3 = type2;
            Member member2 = member;
            FieldGetter fieldGetter = this;
            Object[] objectArray = new Type[0];
            super(member2, type3, clazz, (Type[])objectArray);
        }

        public /* synthetic */ FieldGetter(Field field, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                bl = !Modifier.isStatic(field.getModifiers());
            }
            this(field, bl);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0014\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
    public static abstract class FieldSetter
    extends FunctionCaller<Field> {
        private final boolean notNull;

        @Override
        protected void checkArguments(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            super.checkArguments(args);
            if (this.notNull && ArraysKt.last(args) == null) {
                throw (Throwable)new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            ((Field)this.getMember$kotlin_reflection()).set(this.getInstanceClass$kotlin_reflection() != null ? ArraysKt.first(args) : null, ArraysKt.last(args));
            return Unit.INSTANCE;
        }

        /*
         * WARNING - void declaration
         */
        public FieldSetter(@NotNull Field field, boolean notNull, boolean requiresInstance) {
            void elements$iv;
            Intrinsics.checkParameterIsNotNull(field, "field");
            Member member = field;
            Class<Void> clazz = Void.TYPE;
            Intrinsics.checkExpressionValueIsNotNull(clazz, "Void.TYPE");
            Type type2 = clazz;
            Class<?> clazz2 = requiresInstance ? field.getDeclaringClass() : null;
            Type[] typeArray = new Type[1];
            Type type3 = field.getGenericType();
            Intrinsics.checkExpressionValueIsNotNull(type3, "field.genericType");
            typeArray[0] = type3;
            Type[] typeArray2 = typeArray;
            Class<?> clazz3 = clazz2;
            Type type4 = type2;
            Member member2 = member;
            FieldSetter fieldSetter = this;
            Object[] objectArray = (Object[])elements$iv;
            super(member2, type4, clazz3, (Type[])objectArray);
            this.notNull = notNull;
        }

        public /* synthetic */ FieldSetter(Field field, boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                bl2 = !Modifier.isStatic(field.getModifiers());
            }
            this(field, bl, bl2);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
    public static final class StaticFieldGetter
    extends FieldGetter {
        public StaticFieldGetter(@NotNull Field field) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, false, 2, null);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
    public static final class InstanceFieldGetter
    extends FieldGetter {
        public InstanceFieldGetter(@NotNull Field field) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, false, 2, null);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0014\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObjectFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
    public static final class JvmStaticInObjectFieldGetter
    extends FieldGetter {
        @Override
        protected void checkArguments(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            super.checkArguments(args);
            this.checkObjectInstance(ArraysKt.firstOrNull(args));
        }

        public JvmStaticInObjectFieldGetter(@NotNull Field field) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, true);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$ClassCompanionFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class ClassCompanionFieldGetter
    extends FunctionCaller<Field> {
        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            return ((Field)this.getMember$kotlin_reflection()).get(ArraysKt.first(args));
        }

        public ClassCompanionFieldGetter(@NotNull Field field, @NotNull Class<?> klass) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            Intrinsics.checkParameterIsNotNull(klass, "klass");
            Member member = field;
            Type type2 = field.getGenericType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "field.genericType");
            Class<?> clazz = klass;
            Type type3 = type2;
            Member member2 = member;
            ClassCompanionFieldGetter classCompanionFieldGetter = this;
            Object[] objectArray = new Type[0];
            super(member2, type3, clazz, (Type[])objectArray);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class BoundInstanceFieldGetter
    extends FieldGetter {
        private final Object boundReceiver;

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            return ((Field)this.getMember$kotlin_reflection()).get(this.boundReceiver);
        }

        public BoundInstanceFieldGetter(@NotNull Field field, @Nullable Object boundReceiver) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, false);
            this.boundReceiver = boundReceiver;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObjectFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
    public static final class BoundJvmStaticInObjectFieldGetter
    extends FieldGetter {
        public BoundJvmStaticInObjectFieldGetter(@NotNull Field field) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, false);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundClassCompanionFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class BoundClassCompanionFieldGetter
    extends FieldGetter {
        private final Object boundReceiver;

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            return ((Field)this.getMember$kotlin_reflection()).get(this.boundReceiver);
        }

        public BoundClassCompanionFieldGetter(@NotNull Field field, @Nullable Object boundReceiver) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, false);
            this.boundReceiver = boundReceiver;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"})
    public static final class StaticFieldSetter
    extends FieldSetter {
        public StaticFieldSetter(@NotNull Field field, boolean notNull) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, notNull, false, 4, null);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"})
    public static final class InstanceFieldSetter
    extends FieldSetter {
        public InstanceFieldSetter(@NotNull Field field, boolean notNull) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, notNull, false, 4, null);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0014\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObjectFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
    public static final class JvmStaticInObjectFieldSetter
    extends FieldSetter {
        @Override
        protected void checkArguments(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            super.checkArguments(args);
            this.checkObjectInstance(ArraysKt.firstOrNull(args));
        }

        public JvmStaticInObjectFieldSetter(@NotNull Field field, boolean notNull) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, notNull, true);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$ClassCompanionFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class ClassCompanionFieldSetter
    extends FunctionCaller<Field> {
        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            ((Field)this.getMember$kotlin_reflection()).set(null, ArraysKt.last(args));
            return Unit.INSTANCE;
        }

        /*
         * WARNING - void declaration
         */
        public ClassCompanionFieldSetter(@NotNull Field field, @NotNull Class<?> klass) {
            void elements$iv;
            Intrinsics.checkParameterIsNotNull(field, "field");
            Intrinsics.checkParameterIsNotNull(klass, "klass");
            Member member = field;
            Class<Void> clazz = Void.TYPE;
            Intrinsics.checkExpressionValueIsNotNull(clazz, "Void.TYPE");
            Type type2 = clazz;
            Type[] typeArray = new Type[1];
            Type type3 = field.getGenericType();
            Intrinsics.checkExpressionValueIsNotNull(type3, "field.genericType");
            typeArray[0] = type3;
            Type[] typeArray2 = typeArray;
            Class<?> clazz2 = klass;
            Type type4 = type2;
            Member member2 = member;
            ClassCompanionFieldSetter classCompanionFieldSetter = this;
            Object[] objectArray = (Object[])elements$iv;
            super(member2, type4, clazz2, (Type[])objectArray);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class BoundInstanceFieldSetter
    extends FieldSetter {
        private final Object boundReceiver;

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            ((Field)this.getMember$kotlin_reflection()).set(this.boundReceiver, ArraysKt.first(args));
            return Unit.INSTANCE;
        }

        public BoundInstanceFieldSetter(@NotNull Field field, boolean notNull, @Nullable Object boundReceiver) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, notNull, false);
            this.boundReceiver = boundReceiver;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObjectFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class BoundJvmStaticInObjectFieldSetter
    extends FieldSetter {
        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            ((Field)this.getMember$kotlin_reflection()).set(null, ArraysKt.last(args));
            return Unit.INSTANCE;
        }

        public BoundJvmStaticInObjectFieldSetter(@NotNull Field field, boolean notNull) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(field, notNull, false);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundClassCompanionFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class BoundClassCompanionFieldSetter
    extends FunctionCaller<Field> {
        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            this.checkArguments(args);
            ((Field)this.getMember$kotlin_reflection()).set(null, ArraysKt.last(args));
            return Unit.INSTANCE;
        }

        /*
         * WARNING - void declaration
         */
        public BoundClassCompanionFieldSetter(@NotNull Field field, @NotNull Class<?> klass) {
            void elements$iv;
            Intrinsics.checkParameterIsNotNull(field, "field");
            Intrinsics.checkParameterIsNotNull(klass, "klass");
            Member member = field;
            Class<Void> clazz = Void.TYPE;
            Intrinsics.checkExpressionValueIsNotNull(clazz, "Void.TYPE");
            Type type2 = clazz;
            Type[] typeArray = new Type[1];
            Type type3 = field.getGenericType();
            Intrinsics.checkExpressionValueIsNotNull(type3, "field.genericType");
            typeArray[0] = type3;
            Type[] typeArray2 = typeArray;
            Class<?> clazz2 = klass;
            Type type4 = type2;
            Member member2 = member;
            BoundClassCompanionFieldSetter boundClassCompanionFieldSetter = this;
            Object[] objectArray = (Object[])elements$iv;
            super(member2, type4, clazz2, (Type[])objectArray);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\u00a2\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0004\"\u0006\b\u0001\u0010\t\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\t0\u0004H\u0087\b\u00a2\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004*\u0006\u0012\u0002\b\u00030\u0004H\u0007\u00a2\u0006\u0002\u0010\n\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$Companion;", "", "()V", "argsWithReceiver", "", "receiver", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirst", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirstArg", "kotlin-reflection"})
    public static final class Companion {
        @NotNull
        public final Object[] argsWithReceiver(@Nullable Object receiver, @NotNull Object[] args) {
            Object[] objectArray;
            Intrinsics.checkParameterIsNotNull(args, "args");
            Object[] $receiver = objectArray = new Object[args.length + 1];
            $receiver[0] = receiver;
            System.arraycopy(args, 0, $receiver, 1, args.length);
            return objectArray;
        }

        private final <T> T[] dropFirst(@NotNull T[] $receiver) {
            Object[] objectArray;
            if ($receiver.length <= 1) {
                Intrinsics.reifiedOperationMarker(0, "T?");
                objectArray = new Object[]{};
            } else {
                T[] TArray = $receiver;
                int n = 1;
                int n2 = $receiver.length;
                T[] TArray2 = Arrays.copyOfRange(TArray, n, n2);
                Intrinsics.checkExpressionValueIsNotNull(TArray2, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
                if (TArray2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                objectArray = TArray2;
            }
            return objectArray;
        }

        @NotNull
        public final Object[] dropFirstArg(@NotNull Object[] $receiver) {
            Object[] objectArray;
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            if ($receiver == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            Object[] $receiver$iv = $receiver;
            Companion this_$iv = this;
            if ($receiver$iv.length <= 1) {
                objectArray = new Object[]{};
            } else {
                Object[] objectArray2 = $receiver$iv;
                int n = 1;
                int n2 = $receiver$iv.length;
                Object[] objectArray3 = Arrays.copyOfRange(objectArray2, n, n2);
                Intrinsics.checkExpressionValueIsNotNull(objectArray3, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
                if (objectArray3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                objectArray = objectArray3;
            }
            return objectArray;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

