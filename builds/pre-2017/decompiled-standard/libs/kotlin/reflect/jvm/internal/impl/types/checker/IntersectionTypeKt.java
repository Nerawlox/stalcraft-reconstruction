/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class IntersectionTypeKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final UnwrappedType intersectTypes(@NotNull List<? extends UnwrappedType> types) {
        void $receiver$iv$iv;
        void hasFlexibleTypes;
        SimpleType simpleType2;
        UnwrappedType unwrappedType;
        void hasErrorType;
        Collection collection;
        void $receiver$iv$iv2;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(types, "types");
        switch (types.size()) {
            case 0: {
                String string = "Expected some types";
                throw (Throwable)new IllegalStateException(string.toString());
            }
            case 1: {
                return CollectionsKt.single(types);
            }
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = false;
        Iterable iterable = $receiver$iv = (Iterable)types;
        Iterable destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv2) {
            SimpleType simpleType3;
            void it;
            UnwrappedType unwrappedType2 = (UnwrappedType)item$iv$iv;
            collection = destination$iv$iv;
            hasErrorType.element = hasErrorType.element || it.isError();
            unwrappedType = it;
            if (unwrappedType instanceof SimpleType) {
                simpleType3 = (SimpleType)it;
            } else if (unwrappedType instanceof FlexibleType) {
                hasFlexibleTypes.element = true;
                simpleType3 = ((FlexibleType)it).getLowerBound();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            simpleType2 = simpleType3;
            collection.add(simpleType2);
        }
        List lowerBounds = (List)destination$iv$iv;
        if (hasErrorType.element) {
            SimpleType simpleType4 = ErrorUtils.createErrorType("Intersection of error types: " + types);
            Intrinsics.checkExpressionValueIsNotNull(simpleType4, "ErrorUtils.createErrorTy\u2026 of error types: $types\")");
            return simpleType4;
        }
        if (!hasFlexibleTypes.element) {
            return IntersectionTypeKt.intersectTypes(lowerBounds);
        }
        Iterable $receiver$iv2 = types;
        destination$iv$iv = $receiver$iv2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            unwrappedType = (UnwrappedType)item$iv$iv;
            collection = destination$iv$iv2;
            simpleType2 = FlexibleTypesKt.upperIfFlexible((KotlinType)it);
            collection.add(simpleType2);
        }
        List upperBounds2 = (List)destination$iv$iv2;
        return KotlinTypeFactory.flexibleType(IntersectionTypeKt.intersectTypes(lowerBounds), IntersectionTypeKt.intersectTypes(upperBounds2));
    }

    private static final SimpleType intersectTypes(List<? extends SimpleType> types) {
        IntersectionTypeConstructor constructor = new IntersectionTypeConstructor((Collection<KotlinType>)types);
        TypeConstructor typeConstructor2 = constructor;
        Annotations annotations2 = Annotations.Companion.getEMPTY();
        List list = CollectionsKt.emptyList();
        MemberScope memberScope2 = constructor.createScopeForKotlinType();
        Intrinsics.checkExpressionValueIsNotNull(memberScope2, "constructor.createScopeForKotlinType()");
        return KotlinTypeFactory.simpleType(annotations2, typeConstructor2, list, false, memberScope2);
    }
}

