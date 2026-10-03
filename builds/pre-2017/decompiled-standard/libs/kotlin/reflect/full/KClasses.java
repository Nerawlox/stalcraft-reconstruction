/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClasses$isSubclassOf$1;
import kotlin.reflect.full.KClasses$sam$Neighbors$731aa0ec;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000Z\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u001a+\u0010S\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007\u00a2\u0006\u0002\u0010U\u001a!\u0010V\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u0002H\u0007\u00a2\u0006\u0002\u0010\u0013\u001a\u001c\u0010W\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010X\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a\u001c\u0010Y\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a-\u0010[\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007\u00a2\u0006\u0002\u0010U\",\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"(\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\"$\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013\",\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\",\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"B\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\",\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\">\u0010#\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\",\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\"\u0010+\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010.\",\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u001c\u00102\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00105\"\u001c\u00106\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00105\",\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"B\u0010:\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\",\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\">\u0010@\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"6\u0010C\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010\u0015\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bD\u0010\u0004\u001a\u0004\bE\u0010F\",\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\",\u0010J\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030K0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\",\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020O*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010R\u00a8\u0006\\"}, d2={"allSuperclasses", "", "Lkotlin/reflect/KClass;", "allSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSupertypes", "Lkotlin/reflect/KType;", "allSupertypes$annotations", "getAllSupertypes", "companionObject", "companionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "companionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "Lkotlin/reflect/KFunction;", "declaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberExtensionFunctions", "declaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", "T", "declaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "declaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "declaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMembers", "Lkotlin/reflect/KCallable;", "declaredMembers$annotations", "getDeclaredMembers", "defaultType", "defaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "functions$annotations", "getFunctions", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "memberExtensionFunctions", "memberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "memberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "memberFunctions$annotations", "getMemberFunctions", "memberProperties", "memberProperties$annotations", "getMemberProperties", "primaryConstructor", "primaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "staticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "staticProperties$annotations", "getStaticProperties", "superclasses", "", "superclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "isSubclassOf", "base", "isSuperclassOf", "derived", "safeCast", "kotlin-reflection"})
@JvmName(name="KClasses")
public final class KClasses {
    @SinceKotlin(version="1.1")
    private static /* synthetic */ void primaryConstructor$annotations(KClass kClass) {
    }

    @Nullable
    public static final <T> KFunction<T> getPrimaryConstructor(@NotNull KClass<T> $receiver) {
        Object v3;
        block4: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            KClass<T> kClass = $receiver;
            if (kClass == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T>");
            }
            Iterable $receiver$iv = ((KClassImpl)kClass).getConstructors();
            for (Object element$iv : $receiver$iv) {
                KFunction it;
                KFunction kFunction = it = (KFunction)element$iv;
                if (kFunction == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
                }
                FunctionDescriptor functionDescriptor = ((KFunctionImpl)kFunction).getDescriptor();
                if (functionDescriptor == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
                }
                if (!((ConstructorDescriptor)functionDescriptor).isPrimary()) continue;
                v3 = element$iv;
                break block4;
            }
            v3 = null;
        }
        return v3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void companionObject$annotations(KClass kClass) {
    }

    @Nullable
    public static final KClass<?> getCompanionObject(@NotNull KClass<?> $receiver) {
        Object v1;
        block2: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Iterable $receiver$iv = $receiver.getNestedClasses();
            for (Object element$iv : $receiver$iv) {
                KClass it;
                KClass kClass = it = (KClass)element$iv;
                if (kClass == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                }
                if (!((KClassImpl)kClass).getDescriptor().isCompanionObject()) continue;
                v1 = element$iv;
                break block2;
            }
            v1 = null;
        }
        return v1;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void companionObjectInstance$annotations(KClass kClass) {
    }

    @Nullable
    public static final Object getCompanionObjectInstance(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = KClasses.getCompanionObject($receiver);
        return kClass != null ? kClass.getObjectInstance() : null;
    }

    @Deprecated(message="This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @SinceKotlin(version="1.1")
    private static /* synthetic */ void defaultType$annotations(KClass kClass) {
    }

    @NotNull
    public static final KType getDefaultType(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        }
        SimpleType simpleType2 = ((KClassImpl)kClass).getDescriptor().getDefaultType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "(this as KClassImpl<*>).descriptor.defaultType");
        return new KTypeImpl(simpleType2, (Function0<? extends Type>)new Function0<Class<? extends Object>>($receiver){
            final /* synthetic */ KClass receiver$0;

            @NotNull
            public final Class<? extends Object> invoke() {
                return ((KClassImpl)this.receiver$0).getJClass();
            }
            {
                this.receiver$0 = kClass;
                super(0);
            }
        });
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void declaredMembers$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KCallable<?>> getDeclaredMembers(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<out kotlin.Any>");
        }
        return ((KClassImpl)kClass).getData().invoke().getDeclaredMembers();
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void functions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getFunctions(@NotNull KClass<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            if (!(element$iv$iv instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void staticFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getStaticFunctions(@NotNull KClass<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<out kotlin.Any>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getAllStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            if (!(element$iv$iv instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void memberFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getMemberFunctions(@NotNull KClass<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<out kotlin.Any>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getAllNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            if (!(KClasses.isNotExtension(it) && it instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void memberExtensionFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getMemberExtensionFunctions(@NotNull KClass<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<out kotlin.Any>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getAllNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            if (!(KClasses.isExtension(it) && it instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void declaredFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getDeclaredFunctions(@NotNull KClass<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<out kotlin.Any>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getDeclaredMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            if (!(element$iv$iv instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void declaredMemberFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(@NotNull KClass<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<out kotlin.Any>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getDeclaredNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            if (!(KClasses.isNotExtension(it) && it instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void declaredMemberExtensionFunctions$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(@NotNull KClass<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<out kotlin.Any>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getDeclaredNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            if (!(KClasses.isExtension(it) && it instanceof KFunction)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void staticProperties$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KProperty0<?>> getStaticProperties(@NotNull KClass<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<out kotlin.Any>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getAllStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            if (!(KClasses.isNotExtension(it) && it instanceof KProperty0)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void memberProperties$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(@NotNull KClass<T> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<T> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getAllNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            if (!(KClasses.isNotExtension(it) && it instanceof KProperty1)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void memberExtensionProperties$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(@NotNull KClass<T> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<T> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getAllNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            if (!(KClasses.isExtension(it) && it instanceof KProperty2)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void declaredMemberProperties$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(@NotNull KClass<T> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<T> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getDeclaredNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            if (!(KClasses.isNotExtension(it) && it instanceof KProperty1)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void declaredMemberExtensionProperties$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(@NotNull KClass<T> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<T> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T>");
        }
        Iterable iterable = $receiver$iv = (Iterable)((KClassImpl)kClass).getData().invoke().getDeclaredNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KCallableImpl it = (KCallableImpl)element$iv$iv;
            if (!(KClasses.isExtension(it) && it instanceof KProperty2)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    private static final boolean isExtension(@NotNull KCallableImpl<?> $receiver) {
        return $receiver.getDescriptor().getExtensionReceiverParameter() != null;
    }

    private static final boolean isNotExtension(@NotNull KCallableImpl<?> $receiver) {
        return !KClasses.isExtension($receiver);
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void superclasses$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<KClass<?>> getSuperclasses(@NotNull KClass<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getSupertypes();
        Collection destination$iv$iv = new ArrayList();
        void $receiver$iv$iv$iv = $receiver$iv$iv;
        for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
            KClass kClass;
            Object element$iv$iv = element$iv$iv$iv;
            KType it = (KType)element$iv$iv;
            KClassifier kClassifier = it.getClassifier();
            if (!(kClassifier instanceof KClass)) {
                kClassifier = null;
            }
            if ((KClass)kClassifier == null) continue;
            KClass it$iv$iv = kClass;
            destination$iv$iv.add(it$iv$iv);
        }
        return (List)var3_3;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void allSupertypes$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KType> getAllSupertypes(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Object r = DFS.dfs((Collection)$receiver.getSupertypes(), allSupertypes.1.INSTANCE, new DFS.VisitedWithSet(), (DFS.NodeHandler)new DFS.NodeHandlerWithListResult<KType, KType>(){

            public boolean beforeChildren(@NotNull KType current) {
                Intrinsics.checkParameterIsNotNull(current, "current");
                ((LinkedList)this.result).add(current);
                return true;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(r, "DFS.dfs(\n            sup\u2026    }\n            }\n    )");
        return (Collection)r;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void allSuperclasses$annotations(KClass kClass) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Collection<KClass<?>> getAllSuperclasses(@NotNull KClass<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable iterable = $receiver$iv = (Iterable)KClasses.getAllSupertypes($receiver);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            KClass kClass;
            void supertype;
            KType kType = (KType)item$iv$iv;
            Collection collection = destination$iv$iv;
            KClassifier kClassifier = supertype.getClassifier();
            if (!(kClassifier instanceof KClass)) {
                kClassifier = null;
            }
            if ((KClass)kClassifier == null) {
                throw (Throwable)new KotlinReflectionInternalError("Supertype not a class: " + supertype);
            }
            collection.add(kClass);
        }
        return (List)var3_3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @SinceKotlin(version="1.1")
    public static final boolean isSubclassOf(@NotNull KClass<?> $receiver, @NotNull KClass<?> base) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(base, "base");
        if (Intrinsics.areEqual($receiver, base)) return true;
        Function1 function1 = KClasses$isSubclassOf$1.INSTANCE;
        Boolean bl = DFS.ifAny((Collection)CollectionsKt.listOf($receiver), (DFS.Neighbors)(function1 == null ? null : new KClasses$sam$Neighbors$731aa0ec(function1)), new Function1<KClass<?>, Boolean>(base){
            final /* synthetic */ KClass $base;

            public final boolean invoke(KClass<?> it) {
                return Intrinsics.areEqual(it, this.$base);
            }
            {
                this.$base = kClass;
                super(1);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(bl, "DFS.ifAny(listOf(this), \u2026erclasses) { it == base }");
        if (bl == false) return false;
        return true;
    }

    @SinceKotlin(version="1.1")
    public static final boolean isSuperclassOf(@NotNull KClass<?> $receiver, @NotNull KClass<?> derived) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(derived, "derived");
        return KClasses.isSubclassOf(derived, $receiver);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T> T cast(@NotNull KClass<T> $receiver, @Nullable Object value) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (!$receiver.isInstance(value)) {
            throw (Throwable)new TypeCastException("Value cannot be cast to " + $receiver.getQualifiedName());
        }
        Object object = value;
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        return (T)object;
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final <T> T safeCast(@NotNull KClass<T> $receiver, @Nullable Object value) {
        Object object;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver.isInstance(value)) {
            Object object2 = value;
            if (object2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            object = object2;
        } else {
            object = null;
        }
        return (T)object;
    }

    /*
     * WARNING - void declaration
     */
    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T> T createInstance(@NotNull KClass<T> $receiver) {
        Object object;
        block5: {
            void var2_2;
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Iterable $receiver$iv = $receiver.getConstructors();
            Object single$iv = null;
            boolean found$iv = false;
            for (Object element$iv : $receiver$iv) {
                boolean bl;
                block4: {
                    KFunction it = (KFunction)element$iv;
                    Iterable $receiver$iv2 = it.getParameters();
                    for (Object element$iv2 : $receiver$iv2) {
                        Object receiver = element$iv2;
                        if (((KParameter)receiver).isOptional()) continue;
                        bl = false;
                        break block4;
                    }
                    bl = true;
                }
                if (!bl) continue;
                if (found$iv) {
                    object = null;
                    break block5;
                }
                single$iv = element$iv;
                found$iv = true;
            }
            object = !found$iv ? null : var2_2;
        }
        KFunction kFunction = (KFunction)object;
        if (kFunction == null) {
            throw (Throwable)new IllegalArgumentException("Class should have a single no-arg constructor: " + $receiver);
        }
        KFunction noArgsConstructor = kFunction;
        return (T)noArgsConstructor.callBy(MapsKt.emptyMap());
    }
}

