/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfo;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DeserializedMemberDescriptor
extends MemberDescriptor {
    @NotNull
    public MessageLite getProto();

    @NotNull
    public NameResolver getNameResolver();

    @NotNull
    public TypeTable getTypeTable();

    @NotNull
    public SinceKotlinInfoTable getSinceKotlinInfoTable();

    @Nullable
    public SinceKotlinInfo getSinceKotlinInfo();

    @Nullable
    public DeserializedContainerSource getContainerSource();

    public static final class DefaultImpls {
        @Nullable
        public static SinceKotlinInfo getSinceKotlinInfo(DeserializedMemberDescriptor $this) {
            return SinceKotlinInfo.Companion.create($this.getProto(), $this.getNameResolver(), $this.getSinceKotlinInfoTable());
        }
    }
}

