/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=3)
public final class KClassImpl$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        $EnumSwitchMapping$0 = new int[KotlinClassHeader.Kind.values().length];
        KClassImpl$WhenMappings.$EnumSwitchMapping$0[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
        KClassImpl$WhenMappings.$EnumSwitchMapping$0[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
        KClassImpl$WhenMappings.$EnumSwitchMapping$0[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
        KClassImpl$WhenMappings.$EnumSwitchMapping$0[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
        KClassImpl$WhenMappings.$EnumSwitchMapping$0[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
        KClassImpl$WhenMappings.$EnumSwitchMapping$0[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
    }
}

