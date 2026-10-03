/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectClassUtilKt {
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES;
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE;
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER;
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;

    @NotNull
    public static final ClassLoader getSafeClassLoader(@NotNull Class<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassLoader classLoader = $receiver.getClassLoader();
        if (classLoader == null) {
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
            classLoader = classLoader2;
            Intrinsics.checkExpressionValueIsNotNull(classLoader2, "ClassLoader.getSystemClassLoader()");
        }
        return classLoader;
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(@NotNull Class<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return Enum.class.isAssignableFrom($receiver);
    }

    @Nullable
    public static final Class<?> getPrimitiveByWrapper(@NotNull Class<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return WRAPPER_TO_PRIMITIVE.get($receiver);
    }

    @Nullable
    public static final Class<?> getWrapperByPrimitive(@NotNull Class<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return PRIMITIVE_TO_WRAPPER.get($receiver);
    }

    @Nullable
    public static final Integer getFunctionClassArity(@NotNull Class<?> $receiver) {
        Map<Class<Function<?>>, Integer> map2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Map<Class<Function<?>>, Integer> map3 = map2 = FUNCTION_CLASSES;
        if (map3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        }
        return map3.get($receiver);
    }

    @NotNull
    public static final ClassId getClassId(@NotNull Class<?> $receiver) {
        Class<?> clazz;
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver.isPrimitive()) {
            throw (Throwable)new IllegalArgumentException("Can't compute ClassId for primitive type: " + $receiver);
        }
        if ($receiver.isArray()) {
            throw (Throwable)new IllegalArgumentException("Can't compute ClassId for array type: " + $receiver);
        }
        if ($receiver.getEnclosingMethod() != null || $receiver.getEnclosingConstructor() != null || (charSequence = (CharSequence)$receiver.getSimpleName()).length() == 0) {
            FqName fqName2 = new FqName($receiver.getName());
            clazz = new ClassId(fqName2.parent(), FqName.topLevel(fqName2.shortName()), true);
        } else {
            clazz = $receiver.getDeclaringClass();
            if (clazz == null || (clazz = ReflectClassUtilKt.getClassId(clazz)) == null || (clazz = ((ClassId)((Object)clazz)).createNestedClassId(Name.identifier($receiver.getSimpleName()))) == null) {
                ClassId classId = ClassId.topLevel(new FqName($receiver.getName()));
                clazz = classId;
                Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(FqName(name))");
            }
        }
        return clazz;
    }

    @NotNull
    public static final String getDesc(@NotNull Class<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (Intrinsics.areEqual($receiver, Void.TYPE)) {
            return "V";
        }
        String string = ReflectClassUtilKt.createArrayType($receiver).getName();
        int n = 1;
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.substring(n);
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
        return StringsKt.replace$default(string3, '.', '/', false, 4, null);
    }

    @NotNull
    public static final Class<?> createArrayType(@NotNull Class<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return Array.newInstance($receiver, 0).getClass();
    }

    @NotNull
    public static final List<Type> getParameterizedTypeArguments(@NotNull Type $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (!($receiver instanceof ParameterizedType)) {
            return CollectionsKt.emptyList();
        }
        if (((ParameterizedType)$receiver).getOwnerType() == null) {
            return ArraysKt.toList((Object[])((ParameterizedType)$receiver).getActualTypeArguments());
        }
        return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence($receiver, (Function1)parameterizedTypeArguments.1.INSTANCE), parameterizedTypeArguments.2.INSTANCE));
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var2_2;
        Pair<Object, Serializable> pair;
        KClass it;
        Collection collection;
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        PRIMITIVE_CLASSES = CollectionsKt.listOf(new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)});
        Iterable iterable = $receiver$iv = (Iterable)PRIMITIVE_CLASSES;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            KClass kClass = (KClass)item$iv$iv;
            collection = destination$iv$iv;
            pair = TuplesKt.to(JvmClassMappingKt.getJavaObjectType(it), JvmClassMappingKt.getJavaPrimitiveType(it));
            collection.add(pair);
        }
        WRAPPER_TO_PRIMITIVE = MapsKt.toMap((List)destination$iv$iv);
        $receiver$iv$iv = $receiver$iv = (Iterable)PRIMITIVE_CLASSES;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            it = (KClass)item$iv$iv;
            collection = destination$iv$iv;
            pair = TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(it), JvmClassMappingKt.getJavaObjectType(it));
            collection.add(pair);
        }
        PRIMITIVE_TO_WRAPPER = MapsKt.toMap((List)destination$iv$iv);
        $receiver$iv = CollectionsKt.listOf(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $receiver$iv$iv) {
            void i;
            void clazz;
            int n = index$iv$iv++;
            Class $i$a$1$map = (Class)item$iv$iv;
            int $i$f$mapTo = n;
            collection = destination$iv$iv;
            pair = TuplesKt.to(clazz, (int)i);
            collection.add(pair);
        }
        FUNCTION_CLASSES = MapsKt.toMap((List)var2_2);
    }
}

