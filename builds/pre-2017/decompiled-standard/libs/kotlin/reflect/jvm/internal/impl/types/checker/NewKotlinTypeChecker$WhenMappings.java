/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.Variance;

public final class NewKotlinTypeChecker$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        $EnumSwitchMapping$0 = new int[Variance.values().length];
        NewKotlinTypeChecker$WhenMappings.$EnumSwitchMapping$0[Variance.INVARIANT.ordinal()] = 1;
        NewKotlinTypeChecker$WhenMappings.$EnumSwitchMapping$0[Variance.OUT_VARIANCE.ordinal()] = 2;
        NewKotlinTypeChecker$WhenMappings.$EnumSwitchMapping$0[Variance.IN_VARIANCE.ordinal()] = 3;
    }
}

