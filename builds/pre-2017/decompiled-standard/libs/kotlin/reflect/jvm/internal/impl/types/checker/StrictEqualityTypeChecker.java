/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public final class StrictEqualityTypeChecker {
    public static final StrictEqualityTypeChecker INSTANCE;

    public final boolean strictEqualTypes(@NotNull UnwrappedType a, @NotNull UnwrappedType b) {
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        if (a == b) {
            return true;
        }
        if (a instanceof SimpleType && b instanceof SimpleType) {
            return this.strictEqualTypes((SimpleType)a, (SimpleType)b);
        }
        if (a instanceof FlexibleType && b instanceof FlexibleType) {
            return this.strictEqualTypes(((FlexibleType)a).getLowerBound(), ((FlexibleType)b).getLowerBound()) && this.strictEqualTypes(((FlexibleType)a).getUpperBound(), ((FlexibleType)b).getUpperBound());
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean strictEqualTypes(@NotNull SimpleType a, @NotNull SimpleType b) {
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        if (a.isMarkedNullable() != b.isMarkedNullable() || Intrinsics.areEqual(a.getConstructor(), b.getConstructor()) ^ true || a.getArguments().size() != b.getArguments().size()) {
            return false;
        }
        int n = 0;
        int n2 = ((Collection)a.getArguments()).size() - 1;
        if (n <= n2) {
            while (true) {
                void i;
                TypeProjection aArg = a.getArguments().get((int)i);
                TypeProjection bArg = b.getArguments().get((int)i);
                if (aArg.isStarProjection() != bArg.isStarProjection()) {
                    return false;
                }
                if (!aArg.isStarProjection()) {
                    if (Intrinsics.areEqual((Object)aArg.getProjectionKind(), (Object)bArg.getProjectionKind()) ^ true) {
                        return false;
                    }
                    if (!this.strictEqualTypes(aArg.getType().unwrap(), bArg.getType().unwrap())) {
                        return false;
                    }
                }
                if (i == n2) break;
                ++i;
            }
        }
        return true;
    }

    private StrictEqualityTypeChecker() {
        INSTANCE = this;
    }

    static {
        new StrictEqualityTypeChecker();
    }
}

