/*
 * Decompiled with CFR 0.152.
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\f\u00a8\u0006\u001c"}, d2={"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(FF)V", "_endInclusive", "get_endInclusive", "()F", "_start", "get_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"})
final class ClosedFloatRange
implements ClosedFloatingPointRange<Float> {
    private final float _start;
    private final float _endInclusive;

    private final float get_start() {
        return this._start;
    }

    private final float get_endInclusive() {
        return this._endInclusive;
    }

    @Override
    @NotNull
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    @Override
    @NotNull
    public Float getEndInclusive() {
        return Float.valueOf(this._endInclusive);
    }

    @Override
    public boolean lessThanOrEquals(float a, float b) {
        return a <= b;
    }

    @Override
    public boolean contains(float value) {
        return value >= this._start && value <= this._endInclusive;
    }

    @Override
    public boolean isEmpty() {
        return !(this._start <= this._endInclusive);
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ClosedFloatRange && (this.isEmpty() && ((ClosedFloatRange)other).isEmpty() || this._start == ((ClosedFloatRange)other)._start && this._endInclusive == ((ClosedFloatRange)other)._endInclusive);
    }

    public int hashCode() {
        return this.isEmpty() ? -1 : 31 * ((Object)Float.valueOf(this._start)).hashCode() + ((Object)Float.valueOf(this._endInclusive)).hashCode();
    }

    @NotNull
    public String toString() {
        return this._start + ".." + this._endInclusive;
    }

    public ClosedFloatRange(float start, float endInclusive) {
        this._start = start;
        this._endInclusive = endInclusive;
    }
}

