/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=3)
public final class KTypeParameterImpl$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        $EnumSwitchMapping$0 = new int[Variance.values().length];
        KTypeParameterImpl$WhenMappings.$EnumSwitchMapping$0[Variance.INVARIANT.ordinal()] = 1;
        KTypeParameterImpl$WhenMappings.$EnumSwitchMapping$0[Variance.IN_VARIANCE.ordinal()] = 2;
        KTypeParameterImpl$WhenMappings.$EnumSwitchMapping$0[Variance.OUT_VARIANCE.ordinal()] = 3;
    }
}

