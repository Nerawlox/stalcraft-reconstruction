/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfo;
import org.jetbrains.annotations.Nullable;

public interface DeserializedCallableMemberDescriptor
extends DeserializedMemberDescriptor,
CallableMemberDescriptor {

    public static final class DefaultImpls {
        @Nullable
        public static SinceKotlinInfo getSinceKotlinInfo(DeserializedCallableMemberDescriptor $this) {
            return DeserializedMemberDescriptor.DefaultImpls.getSinceKotlinInfo($this);
        }
    }
}

