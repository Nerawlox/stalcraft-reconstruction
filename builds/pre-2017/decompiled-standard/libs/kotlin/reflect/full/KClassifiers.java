/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClassifiers$WhenMappings;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\u001a.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a6\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eH\u0007\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0015"}, d2={"starProjectedType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "starProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "createKotlinType", "Lorg/jetbrains/kotlin/types/SimpleType;", "typeAnnotations", "Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;", "typeConstructor", "Lorg/jetbrains/kotlin/types/TypeConstructor;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "nullable", "", "createType", "annotations", "", "kotlin-reflection"})
@JvmName(name="KClassifiers")
public final class KClassifiers {
    @SinceKotlin(version="1.1")
    @NotNull
    public static final KType createType(@NotNull KClassifier $receiver, @NotNull List<KTypeProjection> arguments2, boolean nullable, @NotNull List<? extends Annotation> annotations2) {
        Object object;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(arguments2, "arguments");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        KClassifier kClassifier = $receiver;
        if (!(kClassifier instanceof KClassifierImpl)) {
            kClassifier = null;
        }
        if ((object = (KClassifierImpl)((Object)kClassifier)) == null || (object = object.getDescriptor()) == null) {
            throw (Throwable)new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + $receiver + " (" + $receiver.getClass() + ")");
        }
        Object descriptor2 = object;
        TypeConstructor typeConstructor2 = descriptor2.getTypeConstructor();
        List<TypeParameterDescriptor> parameters2 = typeConstructor2.getParameters();
        if (parameters2.size() != arguments2.size()) {
            throw (Throwable)new IllegalArgumentException("Class declares " + parameters2.size() + " type parameters, but " + arguments2.size() + " were provided.");
        }
        Annotations typeAnnotations2 = annotations2.isEmpty() ? Annotations.Companion.getEMPTY() : Annotations.Companion.getEMPTY();
        TypeConstructor typeConstructor3 = typeConstructor2;
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor3, "typeConstructor");
        SimpleType kotlinType = KClassifiers.createKotlinType(typeAnnotations2, typeConstructor3, arguments2, nullable);
        return new KTypeImpl(kotlinType, new Function0($receiver){
            final /* synthetic */ KClassifier receiver$0;

            @NotNull
            public final Void invoke() {
                String string = "Java type is not yet supported for types created with createType (classifier = " + this.receiver$0 + ")";
                throw (Throwable)new NotImplementedError("An operation is not implemented: " + string);
            }
            {
                this.receiver$0 = kClassifier;
                super(0);
            }
        });
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static /* bridge */ /* synthetic */ KType createType$default(KClassifier kClassifier, List list, boolean bl, List list2, int n, Object object) {
        if ((n & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        return KClassifiers.createType(kClassifier, list, bl, list2);
    }

    /*
     * Unable to fully structure code
     */
    private static final SimpleType createKotlinType(Annotations typeAnnotations, TypeConstructor typeConstructor, List<KTypeProjection> arguments, boolean nullable) {
        parameters = typeConstructor.getParameters();
        var5_5 = arguments;
        var6_6 = typeConstructor;
        var7_7 = typeAnnotations;
        var8_8 = $receiver$iv;
        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        index$iv$iv = 0;
        for (T item$iv$iv : $receiver$iv$iv) {
            v0 = index$iv$iv++;
            var13_13 = (KTypeProjection)item$iv$iv;
            var14_14 = v0;
            var15_15 = destination$iv$iv;
            v1 = (KTypeImpl)typeProjection.getType();
            type = v1 != null ? v1.getType() : null;
            v2 = typeProjection.getVariance();
            if (v2 == null) ** GOTO lbl36
            switch (KClassifiers$WhenMappings.$EnumSwitchMapping$0[v2.ordinal()]) {
                case 1: {
                    v3 = type;
                    if (v3 == null) {
                        Intrinsics.throwNpe();
                    }
                    v4 = new TypeProjectionImpl(Variance.INVARIANT, v3);
                    break;
                }
                case 2: {
                    v5 = type;
                    if (v5 == null) {
                        Intrinsics.throwNpe();
                    }
                    v4 = new TypeProjectionImpl(Variance.IN_VARIANCE, v5);
                    break;
                }
                case 3: {
                    v6 = type;
                    if (v6 == null) {
                        Intrinsics.throwNpe();
                    }
                    v4 = new TypeProjectionImpl(Variance.OUT_VARIANCE, v6);
                    break;
                }
lbl36:
                // 1 sources

                v7 = parameters.get((int)index);
                Intrinsics.checkExpressionValueIsNotNull(v7, "parameters[index]");
                v4 = new StarProjectionImpl(v7);
                break;
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            var17_17 = v4;
            var15_15.add(var17_17);
        }
        var15_15 = (List)destination$iv$iv;
        return KotlinTypeFactory.simpleType$default(var7_7, var6_6, (List)var15_15, nullable, null, 16, null);
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void starProjectedType$annotations(KClassifier kClassifier) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final KType getStarProjectedType(@NotNull KClassifier $receiver) {
        Collection<KTypeProjection> collection;
        void $receiver$iv$iv;
        void $receiver$iv;
        Object object;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClassifier kClassifier = $receiver;
        if (!(kClassifier instanceof KClassifierImpl)) {
            kClassifier = null;
        }
        if ((object = (KClassifierImpl)((Object)kClassifier)) == null || (object = object.getDescriptor()) == null) {
            return KClassifiers.createType$default($receiver, null, false, null, 7, null);
        }
        Object descriptor2 = object;
        List<TypeParameterDescriptor> typeParameters2 = descriptor2.getTypeConstructor().getParameters();
        if (typeParameters2.isEmpty()) {
            return KClassifiers.createType$default($receiver, null, false, null, 7, null);
        }
        Iterable iterable = typeParameters2;
        KClassifier kClassifier2 = $receiver;
        void var5_5 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            collection = destination$iv$iv;
            KTypeProjection kTypeProjection = KTypeProjection.Companion.getSTAR();
            collection.add(kTypeProjection);
        }
        collection = (List)destination$iv$iv;
        return KClassifiers.createType$default(kClassifier2, (List)collection, false, null, 6, null);
    }
}

