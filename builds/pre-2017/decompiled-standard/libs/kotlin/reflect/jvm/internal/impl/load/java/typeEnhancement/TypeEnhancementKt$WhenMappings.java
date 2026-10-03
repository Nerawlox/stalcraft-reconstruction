/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

public final class TypeEnhancementKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        $EnumSwitchMapping$0 = new int[MutabilityQualifier.values().length];
        TypeEnhancementKt$WhenMappings.$EnumSwitchMapping$0[MutabilityQualifier.READ_ONLY.ordinal()] = 1;
        TypeEnhancementKt$WhenMappings.$EnumSwitchMapping$0[MutabilityQualifier.MUTABLE.ordinal()] = 2;
        $EnumSwitchMapping$1 = new int[NullabilityQualifier.values().length];
        TypeEnhancementKt$WhenMappings.$EnumSwitchMapping$1[NullabilityQualifier.NULLABLE.ordinal()] = 1;
        TypeEnhancementKt$WhenMappings.$EnumSwitchMapping$1[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
    }
}

