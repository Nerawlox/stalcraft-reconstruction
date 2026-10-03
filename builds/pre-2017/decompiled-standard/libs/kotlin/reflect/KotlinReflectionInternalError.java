/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="Use 'KotlinReflectionInternalError' from kotlin.reflect.jvm.internal package", replaceWith=@ReplaceWith(expression="KotlinReflectionInternalError", imports={"kotlin.reflect.jvm.internal.KotlinReflectionInternalError"}), level=DeprecationLevel.WARNING)
@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/KotlinReflectionInternalError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "(Ljava/lang/String;)V", "kotlin-reflection"})
public class KotlinReflectionInternalError
extends Error {
    public KotlinReflectionInternalError(@NotNull String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        super(message);
    }
}

