/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeQualifiersKt {
    /*
     * WARNING - void declaration
     */
    private static final JavaTypeQualifiers extractQualifiers(@NotNull KotlinType $receiver) {
        void upper;
        void lower;
        Pair<KotlinType, KotlinType> pair;
        if (FlexibleTypesKt.isFlexible($receiver)) {
            FlexibleType flexibleType;
            FlexibleType it = flexibleType = FlexibleTypesKt.asFlexibleType($receiver);
            pair = new Pair<SimpleType, SimpleType>(it.getLowerBound(), it.getUpperBound());
        } else {
            pair = new Pair<KotlinType, KotlinType>($receiver, $receiver);
        }
        Pair<KotlinType, KotlinType> pair2 = pair;
        KotlinType kotlinType = pair2.component1();
        KotlinType kotlinType2 = pair2.component2();
        pair2 = null;
        JavaToKotlinClassMap mapping = JavaToKotlinClassMap.INSTANCE;
        return new JavaTypeQualifiers(lower.isMarkedNullable() ? NullabilityQualifier.NULLABLE : (!upper.isMarkedNullable() ? NullabilityQualifier.NOT_NULL : null), mapping.isReadOnly((KotlinType)lower) ? MutabilityQualifier.READ_ONLY : (mapping.isMutable((KotlinType)upper) ? MutabilityQualifier.MUTABLE : null), $receiver.unwrap() instanceof NotNullTypeParameter);
    }

    private static final JavaTypeQualifiers extractQualifiersFromAnnotations(@NotNull KotlinType $receiver) {
        NullabilityQualifier nullability;
        Function2 ifPresent$ = new Function2<List<? extends FqName>, T, T>($receiver){
            final /* synthetic */ KotlinType receiver$0;

            @Nullable
            public final <T> T invoke(@NotNull List<FqName> $receiver, @NotNull T qualifier) {
                boolean bl;
                block1: {
                    Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                    Intrinsics.checkParameterIsNotNull(qualifier, "qualifier");
                    Iterable $receiver$iv = $receiver;
                    for (T element$iv : $receiver$iv) {
                        FqName it = (FqName)element$iv;
                        if (!(this.receiver$0.getAnnotations().findAnnotation(it) != null)) continue;
                        bl = true;
                        break block1;
                    }
                    bl = false;
                }
                return (T)(bl ? qualifier : null);
            }
            {
                this.receiver$0 = kotlinType;
                super(2);
            }
        };
        extractQualifiersFromAnnotations.2 uniqueNotNull$ = extractQualifiersFromAnnotations.2.INSTANCE;
        extractQualifiersFromAnnotations.3 uniqueNotNull$2 = extractQualifiersFromAnnotations.3.INSTANCE;
        Function1<FqName, NullabilityQualifier> extractQualifierFromAnnotationWithWhen$ = new Function1<FqName, NullabilityQualifier>($receiver){
            final /* synthetic */ KotlinType receiver$0;

            @Nullable
            public final NullabilityQualifier invoke(@NotNull FqName $receiver) {
                Object object;
                Object enumEntryDescriptor;
                Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                AnnotationDescriptor annotationDescriptor = this.receiver$0.getAnnotations().findAnnotation($receiver);
                if (annotationDescriptor == null) {
                    return null;
                }
                AnnotationDescriptor annotationDescriptor2 = annotationDescriptor;
                Object object2 = (ConstantValue)CollectionsKt.singleOrNull((Iterable)annotationDescriptor2.getAllValueArguments().values());
                if (object2 == null || (object2 = object2.getValue()) == null || (object2 = (NullabilityQualifier)(!((enumEntryDescriptor = (object = object2)) instanceof ClassDescriptor) ? null : (Intrinsics.areEqual(((ClassDescriptor)enumEntryDescriptor).getName().asString(), "ALWAYS") ? NullabilityQualifier.NOT_NULL : NullabilityQualifier.NULLABLE))) == null) {
                    object2 = NullabilityQualifier.NOT_NULL;
                }
                return object2;
            }
            {
                this.receiver$0 = kotlinType;
                super(1);
            }
        };
        return new JavaTypeQualifiers(nullability, uniqueNotNull$.invoke(ifPresent$.invoke(JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS(), MutabilityQualifier.READ_ONLY), ifPresent$.invoke(JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS(), MutabilityQualifier.MUTABLE)), Intrinsics.areEqual((Object)(nullability = uniqueNotNull$2.invoke(ifPresent$.invoke(JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS(), NullabilityQualifier.NULLABLE), ifPresent$.invoke(JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS(), NullabilityQualifier.NOT_NULL), extractQualifierFromAnnotationWithWhen$.invoke(JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION()))), (Object)NullabilityQualifier.NOT_NULL) && TypeUtilsKt.isTypeParameter($receiver));
    }

    /*
     * Unable to fully structure code
     */
    @NotNull
    public static final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiersForOverride(@NotNull KotlinType $receiver, @NotNull Collection<? extends KotlinType> fromSupertypes, boolean isCovariant) {
        block8: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Intrinsics.checkParameterIsNotNull(fromSupertypes, "fromSupertypes");
            toIndexed$ = computeIndexedQualifiersForOverride.1.INSTANCE;
            var5_5 = $receiver$iv = (Iterable)fromSupertypes;
            destination$iv$iv = (JavaTypeQualifiers[])new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (T item$iv$iv : $receiver$iv$iv) {
                var9_11 = (KotlinType)item$iv$iv;
                var10_13 = destination$iv$iv;
                var11_14 = computeIndexedQualifiersForOverride.1.INSTANCE.invoke(it);
                var10_13.add(var11_14);
            }
            indexedFromSupertypes = (List)destination$iv$iv;
            indexedThisType = toIndexed$.invoke($receiver);
            if (!isCovariant) ** GOTO lbl-1000
            $receiver$iv = fromSupertypes;
            for (T element$iv : $receiver$iv) {
                it = (KotlinType)element$iv;
                if (!(KotlinTypeChecker.DEFAULT.equalTypes(it, $receiver) == false)) continue;
                v0 = true;
                break block8;
            }
            v0 = false;
        }
        if (v0) {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = false;
        }
        onlyHeadTypeConstructor = v1;
        treeSize = onlyHeadTypeConstructor != false ? 1 : indexedThisType.size();
        result$iv = new JavaTypeQualifiers[treeSize];
        it = 0;
        var13_17 = treeSize - 1;
        if (it <= var13_17) {
            do {
                $i$f$any = ++i$iv;
                var11_15 = i$iv;
                var10_13 = result$iv;
                isHeadTypeConstructor = index == false;
                v2 = var16_21 = isHeadTypeConstructor != false || onlyHeadTypeConstructor == false;
                if (_Assertions.ENABLED && !var16_21) {
                    var17_22 = "Only head type constructors should be computed";
                    throw (Throwable)new AssertionError((Object)var17_22);
                }
                qualifiers = indexedThisType.get((int)index);
                var18_23 = $receiver$iv = (Iterable)indexedFromSupertypes;
                destination$iv$iv = new ArrayList<E>();
                $receiver$iv$iv$iv = $receiver$iv$iv;
                for (T element$iv$iv$iv : $receiver$iv$iv$iv) {
                    element$iv$iv = element$iv$iv$iv;
                    it = (List)element$iv$iv;
                    if ((KotlinType)CollectionsKt.getOrNull(it, (int)index) == null) continue;
                    it$iv$iv = var25_30;
                    destination$iv$iv.add(it$iv$iv);
                }
                verticalSlice = (List)destination$iv$iv;
                var10_13[var11_15] = var28_33 = TypeQualifiersKt.computeQualifiersForOverride(qualifiers, verticalSlice, isCovariant != false && isHeadTypeConstructor != false);
            } while (i$iv != var13_17);
        }
        computedResult = (JavaTypeQualifiers[])((Object[])result$iv);
        return new Function1<Integer, JavaTypeQualifiers>(computedResult){
            final /* synthetic */ JavaTypeQualifiers[] $computedResult;

            @NotNull
            public final JavaTypeQualifiers invoke(int index) {
                Object object;
                Object[] objectArray = this.$computedResult;
                if (index >= 0 && index <= ArraysKt.getLastIndex(objectArray)) {
                    object = objectArray[index];
                } else {
                    int it = index;
                    object = JavaTypeQualifiers.Companion.getNONE();
                }
                return object;
            }
            {
                this.$computedResult = javaTypeQualifiersArray;
                super(1);
            }
        };
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static final JavaTypeQualifiers computeQualifiersForOverride(@NotNull KotlinType $receiver, Collection<? extends KotlinType> fromSupertypes, boolean isCovariant) {
        block6: {
            var4_4 = $receiver$iv = (Iterable)fromSupertypes;
            destination$iv$iv = new ArrayList<E>();
            $receiver$iv$iv$iv = $receiver$iv$iv;
            for (T element$iv$iv$iv : $receiver$iv$iv$iv) {
                element$iv$iv /* !! */  = element$iv$iv$iv /* !! */ ;
                it = (KotlinType)element$iv$iv /* !! */ ;
                if (TypeQualifiersKt.extractQualifiers(it).getNullability() == null) continue;
                it$iv$iv = var11_12;
                destination$iv$iv.add(it$iv$iv);
            }
            nullabilityFromSupertypes = CollectionsKt.toSet((List)destination$iv$iv);
            $receiver$iv = fromSupertypes;
            destination$iv$iv = $receiver$iv;
            destination$iv$iv = new ArrayList<E>();
            $receiver$iv$iv$iv = $receiver$iv$iv;
            element$iv$iv$iv /* !! */  = $receiver$iv$iv$iv.iterator();
            while (element$iv$iv$iv /* !! */ .hasNext()) {
                element$iv$iv$iv = element$iv$iv$iv /* !! */ .next();
                element$iv$iv = element$iv$iv$iv;
                it = (KotlinType)element$iv$iv;
                if (TypeQualifiersKt.extractQualifiers(it).getMutability() == null) continue;
                it$iv$iv = var12_13;
                destination$iv$iv.add(it$iv$iv);
            }
            mutabilityFromSupertypes = CollectionsKt.toSet((List)destination$iv$iv);
            own = TypeQualifiersKt.extractQualifiersFromAnnotations($receiver);
            if (own.isNotNullTypeParameter$kotlin_core()) ** GOTO lbl-1000
            $receiver$iv = fromSupertypes;
            for (T element$iv : $receiver$iv) {
                it = (KotlinType)element$iv;
                if (!TypeQualifiersKt.extractQualifiers(it).isNotNullTypeParameter$kotlin_core()) continue;
                v0 = true;
                break block6;
            }
            v0 = false;
        }
        if (v0) lbl-1000:
        // 2 sources

        {
            v1 = true;
        } else {
            v1 = false;
        }
        isAnyNonNullTypeParameter = v1;
        createJavaTypeQualifiers$ = new Function2<NullabilityQualifier, MutabilityQualifier, JavaTypeQualifiers>(isAnyNonNullTypeParameter){
            final /* synthetic */ boolean $isAnyNonNullTypeParameter;

            @NotNull
            public final JavaTypeQualifiers invoke(@Nullable NullabilityQualifier nullability, @Nullable MutabilityQualifier mutability) {
                if (!this.$isAnyNonNullTypeParameter || Intrinsics.areEqual((Object)((Object)nullability), (Object)((Object)NullabilityQualifier.NOT_NULL)) ^ true) {
                    return new JavaTypeQualifiers(nullability, mutability, false);
                }
                return new JavaTypeQualifiers(nullability, mutability, true);
            }
            {
                this.$isAnyNonNullTypeParameter = bl;
                super(2);
            }
        };
        if (isCovariant) {
            selectCovariantly$ = computeQualifiersForOverride.2.INSTANCE;
            return createJavaTypeQualifiers$.invoke(selectCovariantly$.invoke(nullabilityFromSupertypes, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, own.getNullability()), selectCovariantly$.invoke(mutabilityFromSupertypes, MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, own.getMutability()));
        }
        selectInvariantly$ = computeQualifiersForOverride.3.INSTANCE;
        return createJavaTypeQualifiers$.invoke(selectInvariantly$.invoke(nullabilityFromSupertypes, own.getNullability()), selectInvariantly$.invoke(mutabilityFromSupertypes, own.getMutability()));
    }
}

