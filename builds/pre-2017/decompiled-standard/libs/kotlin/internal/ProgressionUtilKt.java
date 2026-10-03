/*
 * Decompiled with CFR 0.152.
 */
package kotlin.internal;

import kotlin.Metadata;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002\u00a8\u0006\u000b"}, d2={"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-runtime"})
public final class ProgressionUtilKt {
    private static final int mod(int a, int b) {
        int mod = a % b;
        return mod >= 0 ? mod : mod + b;
    }

    private static final long mod(long a, long b) {
        long mod = a % b;
        return mod >= (long)0 ? mod : mod + b;
    }

    private static final int differenceModulo(int a, int b, int c) {
        return ProgressionUtilKt.mod(ProgressionUtilKt.mod(a, c) - ProgressionUtilKt.mod(b, c), c);
    }

    private static final long differenceModulo(long a, long b, long c) {
        return ProgressionUtilKt.mod(ProgressionUtilKt.mod(a, c) - ProgressionUtilKt.mod(b, c), c);
    }

    public static final int getProgressionLastElement(int start, int end, int step) {
        if (step > 0) {
            return end - ProgressionUtilKt.differenceModulo(end, start, step);
        }
        if (step < 0) {
            return end + ProgressionUtilKt.differenceModulo(start, end, -step);
        }
        throw (Throwable)new IllegalArgumentException("Step is zero.");
    }

    public static final long getProgressionLastElement(long start, long end, long step) {
        if (step > (long)0) {
            return end - ProgressionUtilKt.differenceModulo(end, start, step);
        }
        if (step < (long)0) {
            return end + ProgressionUtilKt.differenceModulo(start, end, -step);
        }
        throw (Throwable)new IllegalArgumentException("Step is zero.");
    }
}

