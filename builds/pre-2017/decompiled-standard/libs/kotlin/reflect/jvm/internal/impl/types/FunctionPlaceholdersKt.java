/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.FunctionPlaceholderTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.Nullable;

public final class FunctionPlaceholdersKt {
    public static final boolean isFunctionPlaceholder(@Nullable KotlinType $receiver) {
        return $receiver != null && $receiver.getConstructor() instanceof FunctionPlaceholderTypeConstructor;
    }
}

