/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b\u00a8\u0006\t"}, d2={"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"})
@JvmName(name="KTypesJvm")
public final class KTypesJvm {
    @SinceKotlin(version="1.1")
    private static /* synthetic */ void jvmErasure$annotations(KType kType) {
    }

    @NotNull
    public static final KClass<?> getJvmErasure(@NotNull KType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver.getClassifier();
        if (kClass == null || (kClass = KTypesJvm.getJvmErasure(kClass)) == null) {
            throw (Throwable)new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + $receiver);
        }
        return kClass;
    }

    @NotNull
    public static final KClass<?> getJvmErasure(@NotNull KClassifier $receiver) {
        KClass kClass;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClassifier kClassifier = $receiver;
        if (kClassifier instanceof KClass) {
            kClass = (KClass)$receiver;
        } else if (kClassifier instanceof KTypeParameter) {
            KType representativeBound;
            KType kType;
            Object v3;
            List<KType> bounds;
            block9: {
                bounds = ((KTypeParameter)$receiver).getUpperBounds();
                Iterable $receiver$iv = bounds;
                for (Object element$iv : $receiver$iv) {
                    ClassDescriptor classDescriptor;
                    KType it;
                    KType kType2 = it = (KType)element$iv;
                    if (kType2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                    }
                    ClassifierDescriptor classifierDescriptor = ((KTypeImpl)kType2).getType().getConstructor().getDeclarationDescriptor();
                    if (!(classifierDescriptor instanceof ClassDescriptor)) {
                        classifierDescriptor = null;
                    }
                    if (!((classDescriptor = (ClassDescriptor)classifierDescriptor) != null && Intrinsics.areEqual((Object)classDescriptor.getKind(), (Object)ClassKind.INTERFACE) ^ true && Intrinsics.areEqual((Object)classDescriptor.getKind(), (Object)ClassKind.ANNOTATION_CLASS) ^ true)) continue;
                    v3 = element$iv;
                    break block9;
                }
                v3 = null;
            }
            if ((kType = (KType)v3) == null) {
                kType = CollectionsKt.firstOrNull(bounds);
            }
            if ((kClass = (representativeBound = kType)) == null || (kClass = KTypesJvm.getJvmErasure((KType)((Object)kClass))) == null) {
                kClass = Reflection.getOrCreateKotlinClass(Object.class);
            }
        } else {
            throw (Throwable)new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + $receiver);
        }
        return kClass;
    }
}

