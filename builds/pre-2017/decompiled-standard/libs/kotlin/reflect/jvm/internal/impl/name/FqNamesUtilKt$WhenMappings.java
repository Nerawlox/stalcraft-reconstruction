/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.name;

import kotlin.reflect.jvm.internal.impl.name.State;

public final class FqNamesUtilKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        $EnumSwitchMapping$0 = new int[State.values().length];
        FqNamesUtilKt$WhenMappings.$EnumSwitchMapping$0[State.BEGINNING.ordinal()] = 1;
        FqNamesUtilKt$WhenMappings.$EnumSwitchMapping$0[State.AFTER_DOT.ordinal()] = 2;
        FqNamesUtilKt$WhenMappings.$EnumSwitchMapping$0[State.MIDDLE.ordinal()] = 3;
    }
}

