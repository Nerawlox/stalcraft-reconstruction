/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.reflect.jvm.internal.impl.types.Variance;

public final class CapturedTypeApproximationKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        $EnumSwitchMapping$0 = new int[Variance.values().length];
        CapturedTypeApproximationKt$WhenMappings.$EnumSwitchMapping$0[Variance.INVARIANT.ordinal()] = 1;
        CapturedTypeApproximationKt$WhenMappings.$EnumSwitchMapping$0[Variance.IN_VARIANCE.ordinal()] = 2;
        CapturedTypeApproximationKt$WhenMappings.$EnumSwitchMapping$0[Variance.OUT_VARIANCE.ordinal()] = 3;
        $EnumSwitchMapping$1 = new int[Variance.values().length];
        CapturedTypeApproximationKt$WhenMappings.$EnumSwitchMapping$1[Variance.IN_VARIANCE.ordinal()] = 1;
        CapturedTypeApproximationKt$WhenMappings.$EnumSwitchMapping$1[Variance.OUT_VARIANCE.ordinal()] = 2;
    }
}

