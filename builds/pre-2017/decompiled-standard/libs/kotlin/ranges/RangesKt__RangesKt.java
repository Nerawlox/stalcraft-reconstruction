/*
 * Decompiled with CFR 0.152.
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedDoubleRange;
import kotlin.ranges.ClosedFloatRange;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.ComparableRange;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u0002H\b2\u0006\u0010\n\u001a\u0002H\bH\u0086\u0002\u00a2\u0006\u0002\u0010\u000b\u001a\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\r2\u0006\u0010\n\u001a\u00020\rH\u0087\u0002\u001a\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\f*\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000eH\u0087\u0002\u00a8\u0006\u000f"}, d2={"checkStepIsPositive", "", "isPositive", "", "step", "", "rangeTo", "Lkotlin/ranges/ClosedRange;", "T", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "kotlin-stdlib"}, xs="kotlin/ranges/RangesKt")
class RangesKt__RangesKt {
    @NotNull
    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(@NotNull T $receiver, @NotNull T that) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(that, "that");
        return new ComparableRange<T>($receiver, that);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final ClosedFloatingPointRange<Double> rangeTo(double $receiver, double that) {
        return new ClosedDoubleRange($receiver, that);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final ClosedFloatingPointRange<Float> rangeTo(float $receiver, float that) {
        return new ClosedFloatRange($receiver, that);
    }

    public static final void checkStepIsPositive(boolean isPositive, @NotNull Number step) {
        Intrinsics.checkParameterIsNotNull(step, "step");
        if (!isPositive) {
            throw (Throwable)new IllegalArgumentException("Step must be positive, was: " + step + ".");
        }
    }
}

