/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibility;

public final class EffectiveVisibility$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        $EnumSwitchMapping$0 = new int[EffectiveVisibility.Permissiveness.values().length];
        EffectiveVisibility$WhenMappings.$EnumSwitchMapping$0[EffectiveVisibility.Permissiveness.SAME.ordinal()] = 1;
        EffectiveVisibility$WhenMappings.$EnumSwitchMapping$0[EffectiveVisibility.Permissiveness.LESS.ordinal()] = 2;
        EffectiveVisibility$WhenMappings.$EnumSwitchMapping$0[EffectiveVisibility.Permissiveness.MORE.ordinal()] = 3;
        EffectiveVisibility$WhenMappings.$EnumSwitchMapping$0[EffectiveVisibility.Permissiveness.UNKNOWN.ordinal()] = 4;
    }
}

