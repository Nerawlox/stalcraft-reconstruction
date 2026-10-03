/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="Use 'NoSuchPropertyException' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="NoSuchPropertyException", imports={"kotlin.reflect.full.NoSuchPropertyException"}), level=DeprecationLevel.WARNING)
@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/NoSuchPropertyException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "(Ljava/lang/Exception;)V", "kotlin-reflection"})
public class NoSuchPropertyException
extends Exception {
    public NoSuchPropertyException(@Nullable Exception cause) {
        block1: {
            if (cause == null) break block1;
            NoSuchPropertyException noSuchPropertyException = this;
            if (noSuchPropertyException == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Throwable");
            }
            ((Throwable)noSuchPropertyException).initCause(cause);
        }
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

