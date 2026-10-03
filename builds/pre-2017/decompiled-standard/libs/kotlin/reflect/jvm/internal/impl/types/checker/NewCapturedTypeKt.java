/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;

public final class NewCapturedTypeKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final SimpleType captureFromArguments(@NotNull SimpleType type2, @NotNull CaptureStatus status, @NotNull Function2<? super Integer, ? super NewCapturedType, Unit> acceptNewCapturedType) {
        UnwrappedType unwrappedType;
        Collection collection;
        void $receiver$iv$iv2;
        boolean bl;
        Object element$iv2;
        List<TypeProjection> arguments2;
        block11: {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            Intrinsics.checkParameterIsNotNull((Object)status, "status");
            Intrinsics.checkParameterIsNotNull(acceptNewCapturedType, "acceptNewCapturedType");
            arguments2 = type2.getArguments();
            Iterable $receiver$iv = arguments2;
            for (Object element$iv2 : $receiver$iv) {
                TypeProjection it = (TypeProjection)element$iv2;
                if (Intrinsics.areEqual((Object)it.getProjectionKind(), (Object)Variance.INVARIANT)) continue;
                bl = false;
                break block11;
            }
            bl = true;
        }
        if (bl) {
            return type2;
        }
        Iterable $receiver$iv = arguments2;
        element$iv2 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $receiver$iv$iv2) {
            TypeProjection typeProjection;
            void projection;
            int n = index$iv$iv++;
            TypeProjection typeProjection2 = (TypeProjection)item$iv$iv;
            int n2 = n;
            collection = destination$iv$iv;
            if (Intrinsics.areEqual((Object)projection.getProjectionKind(), (Object)Variance.INVARIANT)) {
                typeProjection = projection;
            } else {
                UnwrappedType lowerType2 = !projection.isStarProjection() && Intrinsics.areEqual((Object)projection.getProjectionKind(), (Object)Variance.IN_VARIANCE) ? projection.getType().unwrap() : null;
                typeProjection = TypeUtilsKt.asTypeProjection(new NewCapturedType(status, lowerType2, (TypeProjection)projection));
            }
            unwrappedType = typeProjection;
            collection.add(unwrappedType);
        }
        List newArguments2 = (List)destination$iv$iv;
        TypeSubstitutor substitutor = TypeConstructorSubstitution.Companion.create(type2.getConstructor(), newArguments2).buildSubstitutor();
        int $receiver$iv$iv2 = 0;
        int n = ((Collection)arguments2).size() - 1;
        if ($receiver$iv$iv2 <= n) {
            while (true) {
                void index;
                TypeProjection oldProjection = arguments2.get((int)index);
                TypeProjection newProjection = (TypeProjection)newArguments2.get((int)index);
                if (!Intrinsics.areEqual((Object)oldProjection.getProjectionKind(), (Object)Variance.INVARIANT)) {
                    void $receiver$iv$iv3;
                    Iterable $receiver$iv2;
                    Iterable index2 = $receiver$iv2 = (Iterable)type2.getConstructor().getParameters().get((int)index).getUpperBounds();
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
                    for (Object item$iv$iv : $receiver$iv$iv3) {
                        void it;
                        KotlinType $i$f$mapIndexed = (KotlinType)item$iv$iv;
                        collection = destination$iv$iv2;
                        unwrappedType = NewKotlinTypeChecker.INSTANCE.transformToNewType(substitutor.safeSubstitute((KotlinType)it, Variance.INVARIANT).unwrap());
                        collection.add(unwrappedType);
                    }
                    List<UnwrappedType> upperBounds2 = (List<UnwrappedType>)destination$iv$iv2;
                    if (!oldProjection.isStarProjection() && Intrinsics.areEqual((Object)oldProjection.getProjectionKind(), (Object)Variance.OUT_VARIANCE)) {
                        upperBounds2 = CollectionsKt.plus((Collection)upperBounds2, NewKotlinTypeChecker.INSTANCE.transformToNewType(oldProjection.getType().unwrap()));
                    }
                    KotlinType kotlinType = newProjection.getType();
                    if (kotlinType == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                    }
                    NewCapturedType capturedType = (NewCapturedType)kotlinType;
                    capturedType.getConstructor().initializeSupertypes((List<? extends UnwrappedType>)upperBounds2);
                    acceptNewCapturedType.invoke((Integer)((int)index), capturedType);
                }
                if (index == n) break;
                ++index;
            }
        }
        return KotlinTypeFactory.simpleType$default(type2.getAnnotations(), type2.getConstructor(), newArguments2, type2.isMarkedNullable(), null, 16, null);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ SimpleType captureFromArguments$default(SimpleType simpleType2, CaptureStatus captureStatus, Function2 function2, int n, Object object) {
        if ((n & 4) != 0) {
            function2 = FunctionsKt.getDO_NOTHING_2();
        }
        return NewCapturedTypeKt.captureFromArguments(simpleType2, captureStatus, function2);
    }
}

