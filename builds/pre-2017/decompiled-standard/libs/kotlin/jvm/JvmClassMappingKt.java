/*
 * Decompiled with CFR 0.152.
 */
package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a!\u0010\u0018\u001a\u00020\u0019\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\b\u00030\u001aH\u0007\u00a2\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018GX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\u0002H\u00028\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000e\";\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018\u00c7\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00078G\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2={"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-runtime"})
@JvmName(name="JvmClassMappingKt")
public final class JvmClassMappingKt {
    private static /* synthetic */ void java$annotations(KClass kClass) {
    }

    @JvmName(name="getJavaClass")
    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull KClass<T> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<T> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.jvm.internal.ClassBasedDeclarationContainer");
        }
        Class<?> clazz = ((ClassBasedDeclarationContainer)((Object)kClass)).getJClass();
        if (clazz == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        }
        return clazz;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Nullable
    public static final <T> Class<T> getJavaPrimitiveType(@NotNull KClass<T> $receiver) {
        block21: {
            block13: {
                block14: {
                    block15: {
                        block20: {
                            block17: {
                                block18: {
                                    block19: {
                                        block16: {
                                            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                                            v0 = $receiver;
                                            if (v0 == null) {
                                                throw new TypeCastException("null cannot be cast to non-null type kotlin.jvm.internal.ClassBasedDeclarationContainer");
                                            }
                                            thisJClass = ((ClassBasedDeclarationContainer)v0).getJClass();
                                            if (thisJClass.isPrimitive()) {
                                                v1 = thisJClass;
                                                if (v1 == null) {
                                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
                                                }
                                                return v1;
                                            }
                                            v2 = var2_2 = thisJClass.getName();
                                            if (v2 == null) break block13;
                                            switch (v2.hashCode()) {
                                                case 761287205: {
                                                    if (!var2_2.equals("java.lang.Double")) ** break;
                                                    break block14;
                                                }
                                                case 344809556: {
                                                    if (!var2_2.equals("java.lang.Boolean")) ** break;
                                                    break;
                                                }
                                                case 398795216: {
                                                    if (!var2_2.equals("java.lang.Long")) ** break;
                                                    break block15;
                                                }
                                                case 155276373: {
                                                    if (!var2_2.equals("java.lang.Character")) ** break;
                                                    break block16;
                                                }
                                                case -2056817302: {
                                                    if (!var2_2.equals("java.lang.Integer")) ** break;
                                                    break block17;
                                                }
                                                case -515992664: {
                                                    if (!var2_2.equals("java.lang.Short")) ** break;
                                                    break block18;
                                                }
                                                case 398507100: {
                                                    if (!var2_2.equals("java.lang.Byte")) ** break;
                                                    break block19;
                                                }
                                                case -527879800: {
                                                    if (!var2_2.equals("java.lang.Float")) ** break;
                                                    break block20;
                                                }
                                            }
                                            v3 /* !! */  = Boolean.TYPE;
                                            break block21;
                                        }
                                        v3 /* !! */  = Character.TYPE;
                                        break block21;
                                    }
                                    v3 /* !! */  = Byte.TYPE;
                                    break block21;
                                }
                                v3 /* !! */  = Short.TYPE;
                                break block21;
                            }
                            v3 /* !! */  = Integer.TYPE;
                            break block21;
                        }
                        v3 /* !! */  = Float.TYPE;
                        break block21;
                    }
                    v3 /* !! */  = Long.TYPE;
                    break block21;
                }
                v3 /* !! */  = Double.TYPE;
                break block21;
            }
            v3 /* !! */  = null;
        }
        return v3 /* !! */ ;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @NotNull
    public static final <T> Class<T> getJavaObjectType(@NotNull KClass<T> $receiver) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<T> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.jvm.internal.ClassBasedDeclarationContainer");
        }
        Class<?> thisJClass = ((ClassBasedDeclarationContainer)((Object)kClass)).getJClass();
        if (!thisJClass.isPrimitive()) {
            Class<?> clazz = thisJClass;
            if (clazz != null) return clazz;
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        }
        String string2 = string = thisJClass.getName();
        if (string2 != null) {
            switch (string2.hashCode()) {
                case 109413500: {
                    if (!string.equals("short")) break;
                    return Short.class;
                }
                case 3039496: {
                    if (!string.equals("byte")) break;
                    return Byte.class;
                }
                case 3052374: {
                    if (!string.equals("char")) break;
                    return Character.class;
                }
                case 104431: {
                    if (!string.equals("int")) break;
                    return Integer.class;
                }
                case 64711720: {
                    if (!string.equals("boolean")) break;
                    return Boolean.class;
                }
                case -1325958191: {
                    if (!string.equals("double")) break;
                    return Double.class;
                }
                case 3327612: {
                    if (!string.equals("long")) break;
                    return Long.class;
                }
                case 97526364: {
                    if (!string.equals("float")) break;
                    return Float.class;
                }
            }
        }
        Class<Object> clazz = thisJClass;
        if (clazz != null) return clazz;
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    @JvmName(name="getKotlinClass")
    @NotNull
    public static final <T> KClass<T> getKotlinClass(@NotNull Class<T> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass kClass = Reflection.createKotlinClass($receiver);
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<T>");
        }
        return kClass;
    }

    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull T $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        T t = $receiver;
        if (t == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
        }
        Class<?> clazz = t.getClass();
        if (clazz == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        }
        return clazz;
    }

    @Deprecated(message="Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith=@ReplaceWith(imports={}, expression="(this as Any).javaClass"), level=DeprecationLevel.ERROR)
    private static /* synthetic */ void javaClass$annotations(KClass kClass) {
    }

    @JvmName(name="getRuntimeClassOfKClassInstance")
    @NotNull
    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(@NotNull KClass<T> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<T> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
        }
        Class<KClass<T>> clazz = ((Object)kClass).getClass();
        if (clazz == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
        }
        return clazz;
    }

    private static final <T> boolean isArrayOf(@NotNull Object[] $receiver) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return Object.class.isAssignableFrom($receiver.getClass().getComponentType());
    }

    @NotNull
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(@NotNull T $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        T t = $receiver;
        if (t == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.annotation.Annotation");
        }
        KClass<? extends Annotation> kClass = JvmClassMappingKt.getKotlinClass(t.annotationType());
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
        }
        return kClass;
    }
}

