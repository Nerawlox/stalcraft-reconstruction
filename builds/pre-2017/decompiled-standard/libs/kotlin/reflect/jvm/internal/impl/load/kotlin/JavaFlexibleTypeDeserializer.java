/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class JavaFlexibleTypeDeserializer
implements FlexibleTypeDeserializer {
    @NotNull
    private static final String id = "kotlin.jvm.PlatformType";
    public static final JavaFlexibleTypeDeserializer INSTANCE;

    @NotNull
    public final String getId() {
        return id;
    }

    @Override
    @NotNull
    public KotlinType create(@NotNull ProtoBuf.Type proto, @NotNull String flexibleId, @NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(flexibleId, "flexibleId");
        Intrinsics.checkParameterIsNotNull(lowerBound, "lowerBound");
        Intrinsics.checkParameterIsNotNull(upperBound, "upperBound");
        if (Intrinsics.areEqual(flexibleId, id) ^ true) {
            SimpleType simpleType2 = ErrorUtils.createErrorType("Error java flexible type with id: " + flexibleId + ". (" + lowerBound + ".." + upperBound + ")");
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "ErrorUtils.createErrorTy\u2026owerBound..$upperBound)\")");
            return simpleType2;
        }
        if (proto.hasExtension(JvmProtoBuf.isRaw)) {
            return new RawTypeImpl(lowerBound, upperBound);
        }
        return KotlinTypeFactory.flexibleType(lowerBound, upperBound);
    }

    private JavaFlexibleTypeDeserializer() {
        INSTANCE = this;
        id = id;
    }

    static {
        new JavaFlexibleTypeDeserializer();
    }
}

