/*
 * Decompiled with CFR 0.152.
 */
package kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000*\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\u0010\u0006\u001a,\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0086\b\u00a2\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a&\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0087\b\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"arrayOfNulls", "", "T", "reference", "size", "", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "orEmpty", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "", "charset", "Ljava/nio/charset/Charset;", "toTypedArray", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "kotlin-stdlib"}, xs="kotlin/collections/ArraysKt")
class ArraysKt__ArraysJVMKt {
    private static final <T> T[] orEmpty(@Nullable T[] $receiver) {
        Object[] objectArray = $receiver;
        if ($receiver == null) {
            Intrinsics.reifiedOperationMarker(0, "T?");
            objectArray = new Object[]{};
        }
        return objectArray;
    }

    @InlineOnly
    private static final String toString(@NotNull byte[] $receiver, Charset charset) {
        return new String($receiver, charset);
    }

    private static final <T> T[] toTypedArray(@NotNull Collection<? extends T> $receiver) {
        Collection<Object> collection = $receiver;
        if (collection == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        Collection<Object> thisCollection = collection;
        int n = thisCollection.size();
        Intrinsics.reifiedOperationMarker(0, "T?");
        Object[] objectArray = thisCollection.toArray(new Object[n]);
        if (objectArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return objectArray;
    }

    @NotNull
    public static final <T> T[] arrayOfNulls(@NotNull T[] reference, int size) {
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Object object = Array.newInstance(reference.getClass().getComponentType(), size);
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return (Object[])object;
    }
}

