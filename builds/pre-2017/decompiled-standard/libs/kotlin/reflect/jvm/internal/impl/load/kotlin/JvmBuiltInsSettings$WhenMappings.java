/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings;

public final class JvmBuiltInsSettings$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        $EnumSwitchMapping$0 = new int[JvmBuiltInsSettings.JDKMemberStatus.values().length];
        JvmBuiltInsSettings$WhenMappings.$EnumSwitchMapping$0[JvmBuiltInsSettings.JDKMemberStatus.BLACK_LIST.ordinal()] = 1;
        JvmBuiltInsSettings$WhenMappings.$EnumSwitchMapping$0[JvmBuiltInsSettings.JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 2;
        JvmBuiltInsSettings$WhenMappings.$EnumSwitchMapping$0[JvmBuiltInsSettings.JDKMemberStatus.DROP.ordinal()] = 3;
        JvmBuiltInsSettings$WhenMappings.$EnumSwitchMapping$0[JvmBuiltInsSettings.JDKMemberStatus.WHITE_LIST.ordinal()] = 4;
    }
}

