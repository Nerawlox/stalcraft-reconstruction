/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=3)
public final class ReflectionObjectRenderer$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        $EnumSwitchMapping$0 = new int[KParameter.Kind.values().length];
        ReflectionObjectRenderer$WhenMappings.$EnumSwitchMapping$0[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;
        ReflectionObjectRenderer$WhenMappings.$EnumSwitchMapping$0[KParameter.Kind.INSTANCE.ordinal()] = 2;
        ReflectionObjectRenderer$WhenMappings.$EnumSwitchMapping$0[KParameter.Kind.VALUE.ordinal()] = 3;
        $EnumSwitchMapping$1 = new int[Variance.values().length];
        ReflectionObjectRenderer$WhenMappings.$EnumSwitchMapping$1[Variance.INVARIANT.ordinal()] = 1;
        ReflectionObjectRenderer$WhenMappings.$EnumSwitchMapping$1[Variance.IN_VARIANCE.ordinal()] = 2;
        ReflectionObjectRenderer$WhenMappings.$EnumSwitchMapping$1[Variance.OUT_VARIANCE.ordinal()] = 3;
    }
}

