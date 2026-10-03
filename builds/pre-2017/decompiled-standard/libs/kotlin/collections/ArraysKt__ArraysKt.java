/*
 * Decompiled with CFR 0.152.
 */
package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003\u00a2\u0006\u0002\u0010\u0004\u001aG\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\u00060\u0003\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2={"flatten", "", "T", "", "([[Ljava/lang/Object;)Ljava/util/List;", "unzip", "Lkotlin/Pair;", "R", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, xs="kotlin/collections/ArraysKt")
class ArraysKt__ArraysKt
extends ArraysKt__ArraysJVMKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> List<T> flatten(@NotNull T[][] $receiver) {
        int n;
        int n2;
        void $receiver$iv;
        ArrayList arrayList;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Object[] objectArray = (Object[])$receiver;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList;
        int sum$iv = 0;
        for (int i = 0; i < ((void)$receiver$iv).length; ++i) {
            void it;
            void element$iv = $receiver$iv[i];
            Object[] objectArray2 = (Object[])element$iv;
            n2 = sum$iv;
            int n3 = ((void)it).length;
            sum$iv = n2 + n3;
        }
        n2 = n;
        arrayList2(n2);
        ArrayList result2 = arrayList3;
        for (n = 0; n < $receiver.length; ++n) {
            T[] element = $receiver[n];
            CollectionsKt.addAll((Collection)result2, element);
        }
        return result2;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Pair<? extends T, ? extends R>[] $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ArrayList<T> listT = new ArrayList<T>(((Object[])$receiver).length);
        ArrayList<R> listR = new ArrayList<R>(((Object[])$receiver).length);
        for (int i = 0; i < $receiver.length; ++i) {
            Pair<T, R> pair = $receiver[i];
            listT.add(pair.getFirst());
            listR.add(pair.getSecond());
        }
        return TuplesKt.to(listT, listR);
    }
}

