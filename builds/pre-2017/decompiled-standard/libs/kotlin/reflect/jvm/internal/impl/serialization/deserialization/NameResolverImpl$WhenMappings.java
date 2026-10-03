/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;

public final class NameResolverImpl$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        $EnumSwitchMapping$0 = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
        NameResolverImpl$WhenMappings.$EnumSwitchMapping$0[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
        NameResolverImpl$WhenMappings.$EnumSwitchMapping$0[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
        NameResolverImpl$WhenMappings.$EnumSwitchMapping$0[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
    }
}

