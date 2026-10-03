/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.ErrorTypesAreEqualToAnything;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class FlexibleTypesKt {
    public static final boolean isFlexible(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.unwrap() instanceof FlexibleType;
    }

    @NotNull
    public static final FlexibleType asFlexibleType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType = $receiver.unwrap();
        if (unwrappedType == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        }
        return (FlexibleType)unwrappedType;
    }

    public static final boolean isNullabilityFlexible(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType = $receiver.unwrap();
        if (!(unwrappedType instanceof FlexibleType)) {
            unwrappedType = null;
        }
        FlexibleType flexibleType = (FlexibleType)unwrappedType;
        if (flexibleType == null) {
            return false;
        }
        FlexibleType flexibility = flexibleType;
        return TypeUtils.isNullableType(flexibility.getLowerBound()) != TypeUtils.isNullableType(flexibility.getUpperBound());
    }

    @Nullable
    public static final KotlinType singleBestRepresentative(@NotNull Collection<? extends KotlinType> $receiver) {
        Object v1;
        block4: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            if ($receiver.size() == 1) {
                return (KotlinType)CollectionsKt.first((Iterable)$receiver);
            }
            Iterable $receiver$iv = $receiver;
            for (Object element$iv : $receiver$iv) {
                boolean bl;
                block3: {
                    KotlinType candidate = (KotlinType)element$iv;
                    Iterable $receiver$iv2 = $receiver;
                    for (Object element$iv2 : $receiver$iv2) {
                        KotlinType other = (KotlinType)element$iv2;
                        if (Intrinsics.areEqual(candidate, other) || ErrorTypesAreEqualToAnything.INSTANCE.equalTypes(candidate, other)) continue;
                        bl = false;
                        break block3;
                    }
                    bl = true;
                }
                if (!bl) continue;
                v1 = element$iv;
                break block4;
            }
            v1 = null;
        }
        return v1;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final TypeProjection singleBestRepresentative(@NotNull Collection<? extends TypeProjection> $receiver) {
        void $receiver$iv$iv;
        Object object;
        Collection collection;
        void $receiver$iv$iv2;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver.size() == 1) {
            return (TypeProjection)CollectionsKt.first((Iterable)$receiver);
        }
        Iterable iterable = $receiver$iv = (Iterable)$receiver;
        Iterable destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv2) {
            void it;
            TypeProjection typeProjection = (TypeProjection)item$iv$iv;
            collection = destination$iv$iv;
            object = it.getProjectionKind();
            collection.add(object);
        }
        Set projectionKinds = CollectionsKt.toSet((List)destination$iv$iv);
        if (projectionKinds.size() != 1) {
            return null;
        }
        Iterable $receiver$iv2 = $receiver;
        destination$iv$iv = $receiver$iv2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            TypeProjection $i$a$1$map = (TypeProjection)item$iv$iv;
            collection = destination$iv$iv2;
            object = it.getType();
            collection.add(object);
        }
        KotlinType kotlinType = FlexibleTypesKt.singleBestRepresentative((List)destination$iv$iv2);
        if (kotlinType == null) {
            return null;
        }
        KotlinType bestType = kotlinType;
        return new TypeProjectionImpl((Variance)((Object)CollectionsKt.single(projectionKinds)), bestType);
    }

    @NotNull
    public static final SimpleType lowerIfFlexible(@NotNull KotlinType $receiver) {
        SimpleType simpleType2;
        UnwrappedType unwrappedType;
        UnwrappedType $receiver2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType2 = $receiver2 = (unwrappedType = $receiver.unwrap());
        if (unwrappedType2 instanceof FlexibleType) {
            simpleType2 = ((FlexibleType)$receiver2).getLowerBound();
        } else if (unwrappedType2 instanceof SimpleType) {
            simpleType2 = (SimpleType)$receiver2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return simpleType2;
    }

    @NotNull
    public static final SimpleType upperIfFlexible(@NotNull KotlinType $receiver) {
        SimpleType simpleType2;
        UnwrappedType unwrappedType;
        UnwrappedType $receiver2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType2 = $receiver2 = (unwrappedType = $receiver.unwrap());
        if (unwrappedType2 instanceof FlexibleType) {
            simpleType2 = ((FlexibleType)$receiver2).getUpperBound();
        } else if (unwrappedType2 instanceof SimpleType) {
            simpleType2 = (SimpleType)$receiver2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return simpleType2;
    }
}

