/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;

public final class DescriptorRenderer$Companion$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        $EnumSwitchMapping$0 = new int[ClassKind.values().length];
        DescriptorRenderer$Companion$WhenMappings.$EnumSwitchMapping$0[ClassKind.CLASS.ordinal()] = 1;
        DescriptorRenderer$Companion$WhenMappings.$EnumSwitchMapping$0[ClassKind.INTERFACE.ordinal()] = 2;
        DescriptorRenderer$Companion$WhenMappings.$EnumSwitchMapping$0[ClassKind.ENUM_CLASS.ordinal()] = 3;
        DescriptorRenderer$Companion$WhenMappings.$EnumSwitchMapping$0[ClassKind.OBJECT.ordinal()] = 4;
        DescriptorRenderer$Companion$WhenMappings.$EnumSwitchMapping$0[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
        DescriptorRenderer$Companion$WhenMappings.$EnumSwitchMapping$0[ClassKind.ENUM_ENTRY.ordinal()] = 6;
    }
}

