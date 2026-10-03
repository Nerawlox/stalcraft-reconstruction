/*
 * Decompiled with CFR 0.152.
 */
package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u00004\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0007\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u00012\u001a\u0010\b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\tj\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\nH\u0007\u00a2\u0006\u0002\u0010\u000b\u001a?\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\tj\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\nH\u0007\u00a2\u0006\u0002\u0010\f\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000eH\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0010H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0010H\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0012H\u0087\b\u001a-\u0010\u0013\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a5\u0010\u0013\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0007\u001aG\u0010\u0013\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u00012\u001a\u0010\b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\tj\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\nH\u0007\u00a2\u0006\u0002\u0010\u000b\u001a?\u0010\u0013\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\tj\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\nH\u0007\u00a2\u0006\u0002\u0010\f\u001a\u0019\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u0019\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0087\b\u001a!\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000eH\u0087\b\u001a\u0019\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u0019\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0010H\u0087\b\u001a!\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0010H\u0087\b\u001a\u0019\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u0019\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012H\u0087\b\u001a!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0012H\u0087\b\u00a8\u0006\u0014"}, d2={"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, xs="kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsKt
extends ComparisonsKt__ComparisonsKt {
    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T a, @NotNull T b) {
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        return a.compareTo(b) >= 0 ? a : b;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final byte maxOf(byte a, byte b) {
        return (byte)Math.max(a, b);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final short maxOf(short a, short b) {
        return (short)Math.max(a, b);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final int maxOf(int a, int b) {
        return Math.max(a, b);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final long maxOf(long a, long b) {
        return Math.max(a, b);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final float maxOf(float a, float b) {
        return Math.max(a, b);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final double maxOf(double a, double b) {
        return Math.max(a, b);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T a, @NotNull T b, @NotNull T c) {
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        Intrinsics.checkParameterIsNotNull(c, "c");
        return ComparisonsKt.maxOf(a, ComparisonsKt.maxOf(b, c));
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final byte maxOf(byte a, byte b, byte c) {
        return (byte)Math.max(a, Math.max(b, c));
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final short maxOf(short a, short b, short c) {
        return (short)Math.max(a, Math.max(b, c));
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final int maxOf(int a, int b, int c) {
        int n = Math.max(b, c);
        return Math.max(a, n);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final long maxOf(long a, long b, long c) {
        long l = Math.max(b, c);
        return Math.max(a, l);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final float maxOf(float a, float b, float c) {
        float f = Math.max(b, c);
        return Math.max(a, f);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final double maxOf(double a, double b, double c) {
        double d = Math.max(b, c);
        return Math.max(a, d);
    }

    @SinceKotlin(version="1.1")
    public static final <T> T maxOf(T a, T b, T c, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return ComparisonsKt.maxOf(a, ComparisonsKt.maxOf(b, c, comparator), comparator);
    }

    @SinceKotlin(version="1.1")
    public static final <T> T maxOf(T a, T b, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return comparator.compare(a, b) >= 0 ? a : b;
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T a, @NotNull T b) {
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        return a.compareTo(b) <= 0 ? a : b;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final byte minOf(byte a, byte b) {
        return (byte)Math.min(a, b);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final short minOf(short a, short b) {
        return (short)Math.min(a, b);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final int minOf(int a, int b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final long minOf(long a, long b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final float minOf(float a, float b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final double minOf(double a, double b) {
        return Math.min(a, b);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T a, @NotNull T b, @NotNull T c) {
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        Intrinsics.checkParameterIsNotNull(c, "c");
        return ComparisonsKt.minOf(a, ComparisonsKt.minOf(b, c));
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final byte minOf(byte a, byte b, byte c) {
        return (byte)Math.min(a, Math.min(b, c));
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final short minOf(short a, short b, short c) {
        return (short)Math.min(a, Math.min(b, c));
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final int minOf(int a, int b, int c) {
        int n = Math.min(b, c);
        return Math.min(a, n);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final long minOf(long a, long b, long c) {
        long l = Math.min(b, c);
        return Math.min(a, l);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final float minOf(float a, float b, float c) {
        float f = Math.min(b, c);
        return Math.min(a, f);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final double minOf(double a, double b, double c) {
        double d = Math.min(b, c);
        return Math.min(a, d);
    }

    @SinceKotlin(version="1.1")
    public static final <T> T minOf(T a, T b, T c, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return ComparisonsKt.minOf(a, ComparisonsKt.minOf(b, c, comparator), comparator);
    }

    @SinceKotlin(version="1.1")
    public static final <T> T minOf(T a, T b, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return comparator.compare(a, b) <= 0 ? a : b;
    }
}

