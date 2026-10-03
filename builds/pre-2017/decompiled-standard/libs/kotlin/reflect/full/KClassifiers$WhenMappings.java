/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.reflect.KVariance;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=3)
public final class KClassifiers$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        $EnumSwitchMapping$0 = new int[KVariance.values().length];
        KClassifiers$WhenMappings.$EnumSwitchMapping$0[KVariance.INVARIANT.ordinal()] = 1;
        KClassifiers$WhenMappings.$EnumSwitchMapping$0[KVariance.IN.ordinal()] = 2;
        KClassifiers$WhenMappings.$EnumSwitchMapping$0[KVariance.OUT.ordinal()] = 3;
    }
}

