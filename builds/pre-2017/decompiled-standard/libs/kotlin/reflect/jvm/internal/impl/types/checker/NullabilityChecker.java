/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin._Assertions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext;
import org.jetbrains.annotations.NotNull;

public final class NullabilityChecker {
    public static final NullabilityChecker INSTANCE;

    public final boolean isPossibleSubtype(@NotNull TypeCheckerContext context, @NotNull SimpleType subType, @NotNull SimpleType superType) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(subType, "subType");
        Intrinsics.checkParameterIsNotNull(superType, "superType");
        return this.runIsPossibleSubtype(context, subType, superType);
    }

    private final boolean runIsPossibleSubtype(@NotNull TypeCheckerContext $receiver, SimpleType subType, SimpleType superType) {
        boolean bl;
        boolean bl2 = bl = NewKotlinTypeCheckerKt.access$isIntersectionType$p(subType) || NewKotlinTypeCheckerKt.access$isSingleClassifierType$p(subType);
        if (_Assertions.ENABLED && !bl) {
            String string = "Not singleClassifierType superType: " + superType;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        bl = NewKotlinTypeCheckerKt.access$isSingleClassifierType$p(superType);
        if (_Assertions.ENABLED && !bl) {
            String string = "Not singleClassifierType superType: " + superType;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        if (superType.isMarkedNullable()) {
            return true;
        }
        if (this.hasNotNullSupertype($receiver, subType, TypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if (this.hasNotNullSupertype($receiver, superType, TypeCheckerContext.SupertypesPolicy.UpperIfFlexible.INSTANCE)) {
            return false;
        }
        if (NewKotlinTypeCheckerKt.access$isClassType$p(subType)) {
            return false;
        }
        return this.hasPathByNotMarkedNullableNodes($receiver, subType, superType.getConstructor());
    }

    private final boolean hasNotNullSupertype(@NotNull TypeCheckerContext $receiver, SimpleType type2, TypeCheckerContext.SupertypesPolicy supertypesPolicy) {
        return $receiver.anySupertype$kotlin_core(type2, hasNotNullSupertype.1.INSTANCE, (Function1<? super SimpleType, ? extends TypeCheckerContext.SupertypesPolicy>)new Function1<SimpleType, TypeCheckerContext.SupertypesPolicy>(supertypesPolicy){
            final /* synthetic */ TypeCheckerContext.SupertypesPolicy $supertypesPolicy;

            @NotNull
            public final TypeCheckerContext.SupertypesPolicy invoke(@NotNull SimpleType it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.isMarkedNullable() ? (TypeCheckerContext.SupertypesPolicy)TypeCheckerContext.SupertypesPolicy.None.INSTANCE : this.$supertypesPolicy;
            }
            {
                this.$supertypesPolicy = supertypesPolicy;
                super(1);
            }
        });
    }

    private final boolean hasPathByNotMarkedNullableNodes(@NotNull TypeCheckerContext $receiver, SimpleType start, TypeConstructor end) {
        return $receiver.anySupertype$kotlin_core(start, (Function1<? super SimpleType, Boolean>)new Function1<SimpleType, Boolean>(end){
            final /* synthetic */ TypeConstructor $end;

            public final boolean invoke(@NotNull SimpleType it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return !it.isMarkedNullable() && Intrinsics.areEqual(it.getConstructor(), this.$end);
            }
            {
                this.$end = typeConstructor2;
                super(1);
            }
        }, hasPathByNotMarkedNullableNodes.2.INSTANCE);
    }

    private NullabilityChecker() {
        INSTANCE = this;
    }

    static {
        new NullabilityChecker();
    }
}

