/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$1;
import kotlin.reflect.jvm.internal.AnnotationConstructorCallerKt$createAnnotationInstance$toString$1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a6\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0002\u001a$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u00a8\u0006\u0012"}, d2={"createAnnotationInstance", "", "annotationClass", "Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "values", "", "", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection"})
public final class AnnotationConstructorCallerKt {
    /*
     * WARNING - void declaration
     */
    private static final Object transformKotlinToJvm(@Nullable Object $receiver, Class<?> expectedType) {
        Object[] objectArray;
        Object object = $receiver;
        if (object instanceof Class) {
            return null;
        }
        if (object instanceof KClass) {
            objectArray = JvmClassMappingKt.getJavaClass((KClass)$receiver);
        } else if (object instanceof Object[]) {
            if ((Object[])$receiver instanceof Class[]) {
                return null;
            }
            if ((Object[])$receiver instanceof KClass[]) {
                void $receiver$iv$iv;
                Object $receiver$iv;
                Object object2 = $receiver;
                if (object2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                }
                Object[] objectArray2 = $receiver$iv = (Object[])((KClass[])object2);
                Collection destination$iv$iv = new ArrayList(((Object[])$receiver$iv).length);
                for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
                    void receiver;
                    void item$iv$iv;
                    void var8_8 = item$iv$iv = $receiver$iv$iv[i];
                    Collection collection = destination$iv$iv;
                    Class<KClass> clazz = JvmClassMappingKt.getJavaClass((KClass)receiver);
                    collection.add(clazz);
                }
                $receiver$iv = (List)destination$iv$iv;
                Collection thisCollection$iv = (Collection)$receiver$iv;
                Class[] classArray = thisCollection$iv.toArray(new Class[thisCollection$iv.size()]);
                if (classArray == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                objectArray = classArray;
            } else {
                objectArray = (Object[])$receiver;
            }
        } else {
            objectArray = $receiver;
        }
        Object[] result2 = objectArray;
        return expectedType.isInstance(result2) ? result2 : null;
    }

    private static final Void throwIllegalArgumentType(int index, String name2, Class<?> expectedJvmType) {
        KClass kotlinClass = Intrinsics.areEqual(expectedJvmType, Class.class) ? Reflection.getOrCreateKotlinClass(KClass.class) : (expectedJvmType.isArray() && Intrinsics.areEqual(expectedJvmType.getComponentType(), Class.class) ? Reflection.getOrCreateKotlinClass(KClass[].class) : JvmClassMappingKt.getKotlinClass(expectedJvmType));
        String typeString = Intrinsics.areEqual(kotlinClass.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName()) ? kotlinClass.getQualifiedName() + "<" + JvmClassMappingKt.getKotlinClass(JvmClassMappingKt.getJavaClass(kotlinClass).getComponentType()).getQualifiedName() + ">" : kotlinClass.getQualifiedName();
        throw (Throwable)new IllegalArgumentException("Argument #" + index + " " + name2 + " is not of the required type " + typeString);
    }

    /*
     * WARNING - void declaration
     */
    private static final Object createAnnotationInstance(Class<?> annotationClass, List<Method> methods2, Map<String, ? extends Object> values2) {
        void elements$iv;
        Function1<Object, Boolean> equals$ = new Function1<Object, Boolean>(annotationClass, methods2, values2){
            final /* synthetic */ Class $annotationClass;
            final /* synthetic */ List $methods;
            final /* synthetic */ Map $values;

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final boolean invoke(@Nullable Object other) {
                boolean bl;
                Object object;
                Object object2 = other;
                if (!(object2 instanceof Annotation)) {
                    object2 = null;
                }
                if (!Intrinsics.areEqual((object = (Annotation)object2) != null && (object = JvmClassMappingKt.getAnnotationClass(object)) != null ? JvmClassMappingKt.getJavaClass(object) : null, this.$annotationClass)) return false;
                Iterable $receiver$iv = this.$methods;
                Iterator<T> iterator2 = $receiver$iv.iterator();
                do {
                    if (!iterator2.hasNext()) return true;
                    T element$iv = iterator2.next();
                    Method method = (Method)element$iv;
                    V ours = this.$values.get(method.getName());
                    Object theirs = method.invoke(other, new Object[0]);
                    V v = ours;
                    if (v instanceof boolean[]) {
                        Object object3 = theirs;
                        if (object3 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.BooleanArray");
                        }
                        bl = Arrays.equals((boolean[])ours, (boolean[])object3);
                        continue;
                    }
                    if (v instanceof char[]) {
                        Object object4 = theirs;
                        if (object4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharArray");
                        }
                        bl = Arrays.equals((char[])ours, (char[])object4);
                        continue;
                    }
                    if (v instanceof byte[]) {
                        Object object5 = theirs;
                        if (object5 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
                        }
                        bl = Arrays.equals((byte[])ours, (byte[])object5);
                        continue;
                    }
                    if (v instanceof short[]) {
                        Object object6 = theirs;
                        if (object6 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.ShortArray");
                        }
                        bl = Arrays.equals((short[])ours, (short[])object6);
                        continue;
                    }
                    if (v instanceof int[]) {
                        Object object7 = theirs;
                        if (object7 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.IntArray");
                        }
                        bl = Arrays.equals((int[])ours, (int[])object7);
                        continue;
                    }
                    if (v instanceof float[]) {
                        Object object8 = theirs;
                        if (object8 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.FloatArray");
                        }
                        bl = Arrays.equals((float[])ours, (float[])object8);
                        continue;
                    }
                    if (v instanceof long[]) {
                        Object object9 = theirs;
                        if (object9 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.LongArray");
                        }
                        bl = Arrays.equals((long[])ours, (long[])object9);
                        continue;
                    }
                    if (v instanceof double[]) {
                        Object object10 = theirs;
                        if (object10 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.DoubleArray");
                        }
                        bl = Arrays.equals((double[])ours, (double[])object10);
                        continue;
                    }
                    if (v instanceof Object[]) {
                        Object object11 = theirs;
                        if (object11 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                        }
                        bl = Arrays.equals((Object[])ours, (Object[])object11);
                        continue;
                    }
                    bl = Intrinsics.areEqual(ours, theirs);
                } while (bl);
                return false;
            }
            {
                this.$annotationClass = clazz;
                this.$methods = list;
                this.$values = map2;
                super(1);
            }
        };
        KProperty kProperty = AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$1.INSTANCE;
        Lazy hashCode2 = LazyKt.lazy((Function0)new Function0<Integer>(values2){
            final /* synthetic */ Map $values;

            /*
             * WARNING - void declaration
             */
            public final int invoke() {
                void var2_2;
                Iterable $receiver$iv = this.$values.entrySet();
                int sum$iv = 0;
                for (T element$iv : $receiver$iv) {
                    void key;
                    void value;
                    void entry;
                    Map.Entry entry2 = (Map.Entry)element$iv;
                    int n = sum$iv;
                    Object var7_8 = entry;
                    void var8_9 = var7_8;
                    String string = (String)var8_9.getKey();
                    var8_9 = var7_8;
                    V v = var8_9.getValue();
                    var7_8 = null;
                    var8_9 = value;
                    int valueHash = var8_9 instanceof boolean[] ? Arrays.hashCode((boolean[])value) : (var8_9 instanceof char[] ? Arrays.hashCode((char[])value) : (var8_9 instanceof byte[] ? Arrays.hashCode((byte[])value) : (var8_9 instanceof short[] ? Arrays.hashCode((short[])value) : (var8_9 instanceof int[] ? Arrays.hashCode((int[])value) : (var8_9 instanceof float[] ? Arrays.hashCode((float[])value) : (var8_9 instanceof long[] ? Arrays.hashCode((long[])value) : (var8_9 instanceof double[] ? Arrays.hashCode((double[])value) : (var8_9 instanceof Object[] ? Arrays.hashCode((Object[])value) : value.hashCode()))))))));
                    int n2 = 127 * key.hashCode() ^ valueHash;
                    sum$iv = n + n2;
                }
                return (int)var2_2;
            }
            {
                this.$values = map2;
                super(0);
            }
        });
        KProperty kProperty2 = AnnotationConstructorCallerKt$createAnnotationInstance$toString$1.INSTANCE;
        Lazy toString2 = LazyKt.lazy((Function0)new Function0<String>(annotationClass, values2){
            final /* synthetic */ Class $annotationClass;
            final /* synthetic */ Map $values;

            @NotNull
            public final String invoke() {
                StringBuilder stringBuilder;
                StringBuilder $receiver = stringBuilder = new StringBuilder();
                $receiver.append('@');
                $receiver.append(this.$annotationClass.getCanonicalName());
                CollectionsKt.joinTo$default(this.$values.entrySet(), $receiver, ", ", "(", ")", 0, null, createAnnotationInstance.toString.1.1.INSTANCE, 48, null);
                String string = stringBuilder.toString();
                Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            {
                this.$annotationClass = clazz;
                this.$values = map2;
                super(0);
            }
        });
        Class[] classArray = new Class[]{annotationClass};
        ClassLoader classLoader = annotationClass.getClassLoader();
        Object[] objectArray = (Object[])elements$iv;
        Object object = Proxy.newProxyInstance(classLoader, (Class[])objectArray, new InvocationHandler(annotationClass, toString2, kProperty2, hashCode2, kProperty, equals$, values2){
            final /* synthetic */ Class $annotationClass;
            final /* synthetic */ Lazy $toString;
            final /* synthetic */ KProperty $toString$metadata;
            final /* synthetic */ Lazy $hashCode;
            final /* synthetic */ KProperty $hashCode$metadata;
            final /* synthetic */ createAnnotationInstance.1 $equals;
            final /* synthetic */ Map $values;

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            @Nullable
            public final Object invoke(Object proxy, Method method, Object[] args) {
                block13: {
                    block10: {
                        block11: {
                            block12: {
                                v0 = var5_5 = (name = method.getName());
                                if (v0 == null) break block10;
                                switch (v0.hashCode()) {
                                    case 1444986633: {
                                        if (!var5_5.equals("annotationType")) ** break;
                                        break;
                                    }
                                    case 147696667: {
                                        if (!var5_5.equals("hashCode")) ** break;
                                        break block11;
                                    }
                                    case -1776922004: {
                                        if (!var5_5.equals("toString")) ** break;
                                        break block12;
                                    }
                                }
                                v1 /* !! */  = this.$annotationClass;
                                break block13;
                            }
                            var6_6 = this.$toString;
                            var7_9 = null;
                            var8_11 = this.$toString$metadata;
                            v1 /* !! */  = var6_6.getValue();
                            break block13;
                        }
                        var6_7 = this.$hashCode;
                        var7_10 = null;
                        var8_12 = this.$hashCode$metadata;
                        v1 /* !! */  = var6_7.getValue();
                        break block13;
                    }
                    if (Intrinsics.areEqual(name, "equals") && Intrinsics.areEqual(args != null ? Integer.valueOf(args.length) : null, (Object)1)) {
                        v1 /* !! */  = Boolean.valueOf(this.$equals.invoke(ArraysKt.single(args)));
                    } else if (this.$values.containsKey(name)) {
                        v1 /* !! */  = this.$values.get(name);
                    } else {
                        var6_8 = args;
                        var9_13 = new StringBuilder().append("Method is not supported: ").append(method).append(" (args: ");
                        var10_14 = v2;
                        var11_15 = v2;
                        v3 = $receiver$iv;
                        if (v3 == null) {
                            v3 = new Object[]{};
                        }
                        var12_16 = v3;
                        var10_14(var9_13.append(ArraysKt.toList(var12_16)).append(")").toString());
                        throw (Throwable)var11_15;
                    }
                }
                return v1 /* !! */ ;
            }
            {
                this.$annotationClass = clazz;
                this.$toString = lazy;
                this.$toString$metadata = kProperty;
                this.$hashCode = lazy2;
                this.$hashCode$metadata = kProperty2;
                this.$equals = var6_6;
                this.$values = map2;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(object, "Proxy.newProxyInstance(a\u2026        }\n        }\n    }");
        return object;
    }

    @Nullable
    public static final /* synthetic */ Object access$transformKotlinToJvm(@Nullable Object $receiver, @NotNull Class expectedType) {
        return AnnotationConstructorCallerKt.transformKotlinToJvm($receiver, expectedType);
    }

    @NotNull
    public static final /* synthetic */ Void access$throwIllegalArgumentType(int index, @NotNull String name2, @NotNull Class expectedJvmType) {
        return AnnotationConstructorCallerKt.throwIllegalArgumentType(index, name2, expectedJvmType);
    }

    @NotNull
    public static final /* synthetic */ Object access$createAnnotationInstance(@NotNull Class annotationClass, @NotNull List methods2, @NotNull Map values2) {
        return AnnotationConstructorCallerKt.createAnnotationInstance(annotationClass, methods2, values2);
    }
}

