/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.RuntimeTypeMapperKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "BuiltInFunction", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$BuiltInFunction;", "kotlin-reflection"})
public abstract class JvmFunctionSignature {
    @NotNull
    public abstract String asString();

    private JvmFunctionSignature() {
    }

    public /* synthetic */ JvmFunctionSignature(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "", "(Ljava/lang/String;)V", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "asString", "kotlin-reflection"})
    public static final class KotlinFunction
    extends JvmFunctionSignature {
        @NotNull
        private final String signature;

        @NotNull
        public final String getMethodName() {
            return StringsKt.substringBefore$default(this.signature, '(', null, 2, null);
        }

        @NotNull
        public final String getMethodDesc() {
            String string = this.signature;
            int n = StringsKt.indexOf$default((CharSequence)this.signature, '(', 0, false, 6, null);
            String string2 = string;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string3 = string2.substring(n);
            Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
            return string3;
        }

        @Override
        @NotNull
        public String asString() {
            return this.signature;
        }

        @NotNull
        public final String getSignature() {
            return this.signature;
        }

        public KotlinFunction(@NotNull String signature2) {
            Intrinsics.checkParameterIsNotNull(signature2, "signature");
            super(null);
            this.signature = signature2;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "", "(Ljava/lang/String;)V", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "asString", "kotlin-reflection"})
    public static final class KotlinConstructor
    extends JvmFunctionSignature {
        @NotNull
        private final String signature;

        @NotNull
        public final String getConstructorDesc() {
            String string = this.signature;
            int n = StringsKt.indexOf$default((CharSequence)this.signature, '(', 0, false, 6, null);
            String string2 = string;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string3 = string2.substring(n);
            Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
            return string3;
        }

        @Override
        @NotNull
        public String asString() {
            return this.signature;
        }

        @NotNull
        public final String getSignature() {
            return this.signature;
        }

        public KotlinConstructor(@NotNull String signature2) {
            Intrinsics.checkParameterIsNotNull(signature2, "signature");
            super(null);
            this.signature = signature2;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"})
    public static final class JavaMethod
    extends JvmFunctionSignature {
        @NotNull
        private final Method method;

        @Override
        @NotNull
        public String asString() {
            return RuntimeTypeMapperKt.access$getSignature$p(this.method);
        }

        @NotNull
        public final Method getMethod() {
            return this.method;
        }

        public JavaMethod(@NotNull Method method) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            super(null);
            this.method = method;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"})
    public static final class JavaConstructor
    extends JvmFunctionSignature {
        @NotNull
        private final Constructor<?> constructor;

        @Override
        @NotNull
        public String asString() {
            return ArraysKt.joinToString$default(this.constructor.getParameterTypes(), (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (Function1)asString.1.INSTANCE, 24, null);
        }

        @NotNull
        public final Constructor<?> getConstructor() {
            return this.constructor;
        }

        public JavaConstructor(@NotNull Constructor<?> constructor) {
            Intrinsics.checkParameterIsNotNull(constructor, "constructor");
            super(null);
            this.constructor = constructor;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"})
    public static final class FakeJavaAnnotationConstructor
    extends JvmFunctionSignature {
        @NotNull
        private final List<Method> methods;
        @NotNull
        private final Class<?> jClass;

        @NotNull
        public final List<Method> getMethods() {
            return this.methods;
        }

        @Override
        @NotNull
        public String asString() {
            return CollectionsKt.joinToString$default(this.methods, "", "<init>(", ")V", 0, null, asString.1.INSTANCE, 24, null);
        }

        @NotNull
        public final Class<?> getJClass() {
            return this.jClass;
        }

        public FakeJavaAnnotationConstructor(@NotNull Class<?> jClass) {
            Intrinsics.checkParameterIsNotNull(jClass, "jClass");
            super(null);
            this.jClass = jClass;
            Object[] $receiver$iv = this.jClass.getDeclaredMethods();
            FakeJavaAnnotationConstructor fakeJavaAnnotationConstructor = this;
            Object[] objectArray = $receiver$iv;
            Comparator comparator = new Comparator<Method>(){

                /*
                 * Ignored method signature, as it can't be verified against descriptor
                 */
                public int compare(Object a, Object b) {
                    Method it = (Method)a;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (Method)b;
                    Comparable comparable2 = comparable;
                    String string = it.getName();
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)string));
                }
            };
            List<Object> list = ArraysKt.sortedWith(objectArray, comparator);
            fakeJavaAnnotationConstructor.methods = list;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$BuiltInFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "", "(Ljava/lang/String;)V", "asString", "getMember", "Ljava/lang/reflect/Member;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Predefined", "kotlin-reflection"})
    public static class BuiltInFunction
    extends JvmFunctionSignature {
        private final String signature;

        @Nullable
        public Member getMember(@NotNull KDeclarationContainerImpl container) {
            Intrinsics.checkParameterIsNotNull(container, "container");
            return null;
        }

        @Override
        @NotNull
        public String asString() {
            return this.signature;
        }

        public BuiltInFunction(@NotNull String signature2) {
            Intrinsics.checkParameterIsNotNull(signature2, "signature");
            super(null);
            this.signature = signature2;
        }

        @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$BuiltInFunction$Predefined;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$BuiltInFunction;", "signature", "", "member", "Ljava/lang/reflect/Member;", "(Ljava/lang/String;Ljava/lang/reflect/Member;)V", "getMember", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "kotlin-reflection"})
        public static final class Predefined
        extends BuiltInFunction {
            private final Member member;

            @Override
            @NotNull
            public Member getMember(@NotNull KDeclarationContainerImpl container) {
                Intrinsics.checkParameterIsNotNull(container, "container");
                return this.member;
            }

            public Predefined(@NotNull String signature2, @NotNull Member member) {
                Intrinsics.checkParameterIsNotNull(signature2, "signature");
                Intrinsics.checkParameterIsNotNull(member, "member");
                super(signature2);
                this.member = member;
            }
        }
    }
}

