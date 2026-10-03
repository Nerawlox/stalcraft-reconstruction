/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;

public final class VarianceCheckerKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        $EnumSwitchMapping$0 = new int[TypeCheckingProcedure.EnrichedProjectionKind.values().length];
        VarianceCheckerKt$WhenMappings.$EnumSwitchMapping$0[TypeCheckingProcedure.EnrichedProjectionKind.OUT.ordinal()] = 1;
        VarianceCheckerKt$WhenMappings.$EnumSwitchMapping$0[TypeCheckingProcedure.EnrichedProjectionKind.IN.ordinal()] = 2;
        VarianceCheckerKt$WhenMappings.$EnumSwitchMapping$0[TypeCheckingProcedure.EnrichedProjectionKind.INV.ordinal()] = 3;
        VarianceCheckerKt$WhenMappings.$EnumSwitchMapping$0[TypeCheckingProcedure.EnrichedProjectionKind.STAR.ordinal()] = 4;
    }
}

