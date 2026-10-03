/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u00000\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0011\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\t\u001a\u0011\u0010\n\u001a\u00020\b*\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\t\u001a\u001b\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r\u00a2\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r\u00a2\u0006\u0002\u0010\u000e\u001a#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2={"diff", "", "Lkotlin/ranges/ClosedRange;", "", "length", "offset", "Lkotlin/ranges/IntRange;", "orFalse", "", "(Ljava/lang/Boolean;)Z", "orTrue", "random", "T", "", "(Ljava/util/Collection;)Ljava/lang/Object;", "randomOrNull", "split", "", "numParts", "(Lkotlin/ranges/ClosedRange;I)[Lkotlin/ranges/IntRange;", "NetworkBase_main"})
public final class dwlr {
    public static final boolean _a(@Nullable Boolean bl) {
        return bl == null ? true : bl;
    }

    public static final boolean _b(@Nullable Boolean bl) {
        return false;
    }

    public static final int _a(@NotNull ClosedRange<Integer> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$receiver");
        return ((Number)closedRange.getEndInclusive()).intValue() - ((Number)closedRange.getStart()).intValue();
    }

    public static final double _b(@NotNull ClosedRange<Double> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$receiver");
        return ((Number)closedRange.getEndInclusive()).doubleValue() - ((Number)closedRange.getStart()).doubleValue();
    }

    @NotNull
    public static final IntRange _a(@NotNull ClosedRange<Integer> closedRange, int n) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$receiver");
        int n2 = ((Number)closedRange.getStart()).intValue() + n;
        return new IntRange(n2, ((Number)closedRange.getEndInclusive()).intValue() + n);
    }

    public static final int _c(@NotNull ClosedRange<Integer> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$receiver");
        return dwlr._a(closedRange) + 1;
    }

    @NotNull
    public static final IntRange[] _b(@NotNull ClosedRange<Integer> closedRange, int n) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$receiver");
        int n2 = dwlr._c(closedRange);
        IntRange[] intRangeArray = new IntRange[n];
        int n3 = 0;
        int n4 = n - 1;
        if (n3 <= n4) {
            do {
                IntRange intRange;
                int n5 = ++n3;
                int n6 = n3;
                IntRange[] intRangeArray2 = intRangeArray;
                int n7 = n5 * n2 / n;
                int n8 = (n5 + 1) * n2 / n - 1;
                int n9 = n7 + ((Number)closedRange.getStart()).intValue();
                intRangeArray2[n6] = intRange = new IntRange(n9, n8 + ((Number)closedRange.getStart()).intValue());
            } while (n3 != n4);
        }
        return intRangeArray;
    }

    public static final <T> T _a(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "$receiver");
        return CollectionsKt.elementAt((Iterable)collection, ThreadLocalRandom.current().nextInt(collection.size()));
    }

    @Nullable
    public static final <T> T _b(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "$receiver");
        return collection.size() == 0 ? null : (T)CollectionsKt.elementAt((Iterable)collection, ThreadLocalRandom.current().nextInt(collection.size()));
    }
}

