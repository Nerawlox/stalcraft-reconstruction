/*
 * Decompiled with CFR 0.152.
 */
package kotlin;

import kotlin.MathKt__BigNumbersKt;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u00a8\u0006\u0006"}, d2={"isFinite", "", "", "", "isInfinite", "isNaN", "kotlin-stdlib"}, xs="kotlin/MathKt")
class MathKt__NumbersKt
extends MathKt__BigNumbersKt {
    @InlineOnly
    private static final boolean isNaN(double $receiver) {
        return Double.isNaN($receiver);
    }

    @InlineOnly
    private static final boolean isNaN(float $receiver) {
        return Float.isNaN($receiver);
    }

    @InlineOnly
    private static final boolean isInfinite(double $receiver) {
        return Double.isInfinite($receiver);
    }

    @InlineOnly
    private static final boolean isInfinite(float $receiver) {
        return Float.isInfinite($receiver);
    }

    @InlineOnly
    private static final boolean isFinite(double $receiver) {
        double d = $receiver;
        return !Double.isInfinite(d) && !Double.isNaN(d = $receiver);
    }

    @InlineOnly
    private static final boolean isFinite(float $receiver) {
        float f = $receiver;
        return !Float.isInfinite(f) && !Float.isNaN(f = $receiver);
    }
}

