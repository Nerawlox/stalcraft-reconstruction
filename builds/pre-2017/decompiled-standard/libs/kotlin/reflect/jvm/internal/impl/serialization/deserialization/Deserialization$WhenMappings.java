/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;

public final class Deserialization$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;
    public static final /* synthetic */ int[] $EnumSwitchMapping$3;
    public static final /* synthetic */ int[] $EnumSwitchMapping$4;
    public static final /* synthetic */ int[] $EnumSwitchMapping$5;

    static {
        $EnumSwitchMapping$0 = new int[ProtoBuf.MemberKind.values().length];
        Deserialization$WhenMappings.$EnumSwitchMapping$0[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;
        Deserialization$WhenMappings.$EnumSwitchMapping$0[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
        Deserialization$WhenMappings.$EnumSwitchMapping$0[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;
        Deserialization$WhenMappings.$EnumSwitchMapping$0[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;
        $EnumSwitchMapping$1 = new int[ProtoBuf.Modality.values().length];
        Deserialization$WhenMappings.$EnumSwitchMapping$1[ProtoBuf.Modality.FINAL.ordinal()] = 1;
        Deserialization$WhenMappings.$EnumSwitchMapping$1[ProtoBuf.Modality.OPEN.ordinal()] = 2;
        Deserialization$WhenMappings.$EnumSwitchMapping$1[ProtoBuf.Modality.ABSTRACT.ordinal()] = 3;
        Deserialization$WhenMappings.$EnumSwitchMapping$1[ProtoBuf.Modality.SEALED.ordinal()] = 4;
        $EnumSwitchMapping$2 = new int[ProtoBuf.Visibility.values().length];
        Deserialization$WhenMappings.$EnumSwitchMapping$2[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
        Deserialization$WhenMappings.$EnumSwitchMapping$2[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
        Deserialization$WhenMappings.$EnumSwitchMapping$2[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
        Deserialization$WhenMappings.$EnumSwitchMapping$2[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
        Deserialization$WhenMappings.$EnumSwitchMapping$2[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
        Deserialization$WhenMappings.$EnumSwitchMapping$2[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
        $EnumSwitchMapping$3 = new int[ProtoBuf.Class.Kind.values().length];
        Deserialization$WhenMappings.$EnumSwitchMapping$3[ProtoBuf.Class.Kind.CLASS.ordinal()] = 1;
        Deserialization$WhenMappings.$EnumSwitchMapping$3[ProtoBuf.Class.Kind.INTERFACE.ordinal()] = 2;
        Deserialization$WhenMappings.$EnumSwitchMapping$3[ProtoBuf.Class.Kind.ENUM_CLASS.ordinal()] = 3;
        Deserialization$WhenMappings.$EnumSwitchMapping$3[ProtoBuf.Class.Kind.ENUM_ENTRY.ordinal()] = 4;
        Deserialization$WhenMappings.$EnumSwitchMapping$3[ProtoBuf.Class.Kind.ANNOTATION_CLASS.ordinal()] = 5;
        Deserialization$WhenMappings.$EnumSwitchMapping$3[ProtoBuf.Class.Kind.OBJECT.ordinal()] = 6;
        Deserialization$WhenMappings.$EnumSwitchMapping$3[ProtoBuf.Class.Kind.COMPANION_OBJECT.ordinal()] = 7;
        $EnumSwitchMapping$4 = new int[ProtoBuf.TypeParameter.Variance.values().length];
        Deserialization$WhenMappings.$EnumSwitchMapping$4[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
        Deserialization$WhenMappings.$EnumSwitchMapping$4[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
        Deserialization$WhenMappings.$EnumSwitchMapping$4[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
        $EnumSwitchMapping$5 = new int[ProtoBuf.Type.Argument.Projection.values().length];
        Deserialization$WhenMappings.$EnumSwitchMapping$5[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
        Deserialization$WhenMappings.$EnumSwitchMapping$5[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
        Deserialization$WhenMappings.$EnumSwitchMapping$5[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
        Deserialization$WhenMappings.$EnumSwitchMapping$5[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
    }
}

