/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.Variance;

public final class Variance$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        $EnumSwitchMapping$0 = new int[Variance.values().length];
        Variance$WhenMappings.$EnumSwitchMapping$0[Variance.IN_VARIANCE.ordinal()] = 1;
        Variance$WhenMappings.$EnumSwitchMapping$0[Variance.OUT_VARIANCE.ordinal()] = 2;
        Variance$WhenMappings.$EnumSwitchMapping$0[Variance.INVARIANT.ordinal()] = 3;
        $EnumSwitchMapping$1 = new int[Variance.values().length];
        Variance$WhenMappings.$EnumSwitchMapping$1[Variance.INVARIANT.ordinal()] = 1;
        Variance$WhenMappings.$EnumSwitchMapping$1[Variance.IN_VARIANCE.ordinal()] = 2;
        Variance$WhenMappings.$EnumSwitchMapping$1[Variance.OUT_VARIANCE.ordinal()] = 3;
    }
}

