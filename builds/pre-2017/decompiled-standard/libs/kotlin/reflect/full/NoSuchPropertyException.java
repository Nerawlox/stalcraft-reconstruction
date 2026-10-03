/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/full/NoSuchPropertyException;", "Lkotlin/reflect/NoSuchPropertyException;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "kotlin-reflection"})
@SinceKotlin(version="1.1")
public final class NoSuchPropertyException
extends kotlin.reflect.NoSuchPropertyException {
    public NoSuchPropertyException(@Nullable Exception cause) {
        super(cause);
    }

    public /* synthetic */ NoSuchPropertyException(Exception exception, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            exception = null;
        }
        this(exception);
    }

    public NoSuchPropertyException() {
        this(null, 1, null);
    }
}

