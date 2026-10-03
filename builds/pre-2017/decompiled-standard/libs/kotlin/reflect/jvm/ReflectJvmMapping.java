/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.FunctionCaller;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.serialization.PackageData;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010%\u001a\u0004\u0018\u00010&*\u00020'H\u0002\"2\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"-\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001e*\b\u0012\u0004\u0012\u0002H\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u001b\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2={"javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "Lkotlin/reflect/KFunction;", "javaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaMethod", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinFunction", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlin-reflection"})
@JvmName(name="ReflectJvmMapping")
public final class ReflectJvmMapping {
    @Nullable
    public static final Field getJavaField(@NotNull KProperty<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KPropertyImpl<?> kPropertyImpl = UtilKt.asKPropertyImpl($receiver);
        return kPropertyImpl != null ? kPropertyImpl.getJavaField() : null;
    }

    @Nullable
    public static final Method getJavaGetter(@NotNull KProperty<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return ReflectJvmMapping.getJavaMethod((KFunction)$receiver.getGetter());
    }

    @Nullable
    public static final Method getJavaSetter(@NotNull KMutableProperty<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return ReflectJvmMapping.getJavaMethod((KFunction)$receiver.getSetter());
    }

    @Nullable
    public static final Method getJavaMethod(@NotNull KFunction<?> $receiver) {
        Object v1;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KCallableImpl<?> kCallableImpl = UtilKt.asKCallableImpl($receiver);
        if (!((kCallableImpl != null && (kCallableImpl = kCallableImpl.getCaller()) != null ? ((FunctionCaller)((Object)kCallableImpl)).getMember$kotlin_reflection() : (v1 = null)) instanceof Method)) {
            v1 = null;
        }
        return v1;
    }

    private static /* synthetic */ void javaConstructor$annotations(KFunction kFunction) {
    }

    @Nullable
    public static final <T> Constructor<T> getJavaConstructor(@NotNull KFunction<? extends T> $receiver) {
        Object v1;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KCallableImpl<?> kCallableImpl = UtilKt.asKCallableImpl($receiver);
        if (!((kCallableImpl != null && (kCallableImpl = kCallableImpl.getCaller()) != null ? ((FunctionCaller)((Object)kCallableImpl)).getMember$kotlin_reflection() : (v1 = null)) instanceof Constructor)) {
            v1 = null;
        }
        return v1;
    }

    @NotNull
    public static final Type getJavaType(@NotNull KType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KType kType = $receiver;
        if (kType == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        }
        return ((KTypeImpl)kType).getJavaType$kotlin_reflection();
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final KProperty<?> getKotlinProperty(@NotNull Field $receiver) {
        Object v1;
        block6: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            if ($receiver.isSynthetic()) {
                return null;
            }
            KDeclarationContainer kotlinPackage = ReflectJvmMapping.getKPackage($receiver);
            if (kotlinPackage != null) {
                Object v0;
                block5: {
                    void $receiver$iv$iv;
                    Iterable $receiver$iv = kotlinPackage.getMembers();
                    Iterable iterable = $receiver$iv;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $receiver$iv$iv) {
                        if (!(element$iv$iv instanceof KProperty)) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $receiver$iv = (List)destination$iv$iv;
                    for (Object element$iv : $receiver$iv) {
                        KProperty it = (KProperty)element$iv;
                        if (!Intrinsics.areEqual(ReflectJvmMapping.getJavaField(it), $receiver)) continue;
                        v0 = element$iv;
                        break block5;
                    }
                    v0 = null;
                }
                return v0;
            }
            Iterable $receiver$iv = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass($receiver.getDeclaringClass()));
            for (Object element$iv : $receiver$iv) {
                KProperty1 it = (KProperty1)element$iv;
                if (!Intrinsics.areEqual(ReflectJvmMapping.getJavaField(it), $receiver)) continue;
                v1 = element$iv;
                break block6;
            }
            v1 = null;
        }
        return v1;
    }

    /*
     * WARNING - void declaration
     */
    private static final KDeclarationContainer getKPackage(@NotNull Member $receiver) {
        KotlinClassHeader header;
        Class<?> clazz = $receiver.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(clazz, "declaringClass");
        ReflectKotlinClass reflectKotlinClass = ReflectKotlinClass.Factory.create(clazz);
        KotlinClassHeader kotlinClassHeader = header = reflectKotlinClass != null ? reflectKotlinClass.getClassHeader() : null;
        if (header != null && Intrinsics.areEqual((Object)header.getKind(), (Object)KotlinClassHeader.Kind.FILE_FACADE) && header.getMetadataVersion().isCompatible()) {
            String string;
            void proto;
            String[] stringArray = header.getData();
            if (stringArray == null) {
                Intrinsics.throwNpe();
            }
            String[] stringArray2 = header.getStrings();
            if (stringArray2 == null) {
                Intrinsics.throwNpe();
            }
            PackageData packageData = JvmProtoBufUtil.readPackageDataFrom(stringArray, stringArray2);
            NameResolver nameResolver = packageData.component1();
            ProtoBuf.Package package_ = packageData.component2();
            packageData = null;
            if (proto.hasExtension(JvmProtoBuf.packageModuleName)) {
                void nameResolver2;
                Integer n = proto.getExtension(JvmProtoBuf.packageModuleName);
                Intrinsics.checkExpressionValueIsNotNull(n, "proto.getExtension(JvmProtoBuf.packageModuleName)");
                string = nameResolver2.getString(((Number)n).intValue());
            } else {
                string = "main";
            }
            String moduleName = string;
            return Reflection.getOrCreateKotlinPackage($receiver.getDeclaringClass(), moduleName);
        }
        return null;
    }

    @Nullable
    public static final KFunction<?> getKotlinFunction(@NotNull Method $receiver) {
        Object v3;
        block11: {
            KFunction it;
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            if ($receiver.isSynthetic()) {
                return null;
            }
            if (Modifier.isStatic($receiver.getModifiers())) {
                KDeclarationContainer kotlinPackage = ReflectJvmMapping.getKPackage($receiver);
                if (kotlinPackage != null) {
                    Object v0;
                    block9: {
                        Iterator $receiver$iv$iv;
                        Iterable $receiver$iv;
                        Iterable iterable = $receiver$iv = (Iterable)kotlinPackage.getMembers();
                        Collection destination$iv$iv = new ArrayList();
                        Iterator iterator2 = $receiver$iv$iv.iterator();
                        while (iterator2.hasNext()) {
                            Object element$iv$iv = iterator2.next();
                            if (!(element$iv$iv instanceof KFunction)) continue;
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $receiver$iv = (List)destination$iv$iv;
                        for (Object element$iv : $receiver$iv) {
                            KFunction it2 = (KFunction)element$iv;
                            if (!Intrinsics.areEqual(ReflectJvmMapping.getJavaMethod(it2), $receiver)) continue;
                            v0 = element$iv;
                            break block9;
                        }
                        v0 = null;
                    }
                    return v0;
                }
                KClass<?> companion = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass($receiver.getDeclaringClass()));
                if (companion != null) {
                    Object v1;
                    Object $receiver$iv;
                    block10: {
                        $receiver$iv = KClasses.getFunctions(companion);
                        Iterator element$iv = $receiver$iv.iterator();
                        while (element$iv.hasNext()) {
                            Object element$iv2 = element$iv.next();
                            KFunction it3 = (KFunction)element$iv2;
                            Method m = ReflectJvmMapping.getJavaMethod(it3);
                            if (!(m != null && Intrinsics.areEqual(m.getName(), $receiver.getName()) && Arrays.equals(m.getParameterTypes(), $receiver.getParameterTypes()) && Intrinsics.areEqual(m.getReturnType(), $receiver.getReturnType()))) continue;
                            v1 = element$iv2;
                            break block10;
                        }
                        v1 = null;
                    }
                    KFunction kFunction = v1;
                    if (kFunction != null) {
                        $receiver$iv = kFunction;
                        it = (KFunction)$receiver$iv;
                        return it;
                    }
                }
            }
            Iterable $receiver$iv = KClasses.getFunctions(JvmClassMappingKt.getKotlinClass($receiver.getDeclaringClass()));
            for (Object element$iv : $receiver$iv) {
                it = (KFunction)element$iv;
                if (!Intrinsics.areEqual(ReflectJvmMapping.getJavaMethod(it), $receiver)) continue;
                v3 = element$iv;
                break block11;
            }
            v3 = null;
        }
        return v3;
    }

    @Nullable
    public static final <T> KFunction<T> getKotlinFunction(@NotNull Constructor<T> $receiver) {
        Object v0;
        block2: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            if ($receiver.isSynthetic()) {
                return null;
            }
            Iterable $receiver$iv = JvmClassMappingKt.getKotlinClass($receiver.getDeclaringClass()).getConstructors();
            for (Object element$iv : $receiver$iv) {
                KFunction it = (KFunction)element$iv;
                if (!Intrinsics.areEqual(ReflectJvmMapping.getJavaConstructor(it), $receiver)) continue;
                v0 = element$iv;
                break block2;
            }
            v0 = null;
        }
        return v0;
    }
}

