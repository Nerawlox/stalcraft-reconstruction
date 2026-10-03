/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public interface FlexibleTypeDeserializer {
    @NotNull
    public KotlinType create(@NotNull ProtoBuf.Type var1, @NotNull String var2, @NotNull SimpleType var3, @NotNull SimpleType var4);

    public static final class ThrowException
    implements FlexibleTypeDeserializer {
        public static final ThrowException INSTANCE;

        @Override
        @NotNull
        public KotlinType create(@NotNull ProtoBuf.Type proto, @NotNull String flexibleId, @NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
            Intrinsics.checkParameterIsNotNull(proto, "proto");
            Intrinsics.checkParameterIsNotNull(flexibleId, "flexibleId");
            Intrinsics.checkParameterIsNotNull(lowerBound, "lowerBound");
            Intrinsics.checkParameterIsNotNull(upperBound, "upperBound");
            throw (Throwable)new IllegalArgumentException("This method should not be used.");
        }

        private ThrowException() {
            INSTANCE = this;
        }

        static {
            new ThrowException();
        }
    }
}

