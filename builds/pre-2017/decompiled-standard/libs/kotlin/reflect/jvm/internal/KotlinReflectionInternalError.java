/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/KotlinReflectionInternalError;", "Lkotlin/reflect/KotlinReflectionInternalError;", "message", "", "(Ljava/lang/String;)V", "kotlin-reflection"})
public final class KotlinReflectionInternalError
extends kotlin.reflect.KotlinReflectionInternalError {
    public KotlinReflectionInternalError(@NotNull String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        super(message);
    }
}

