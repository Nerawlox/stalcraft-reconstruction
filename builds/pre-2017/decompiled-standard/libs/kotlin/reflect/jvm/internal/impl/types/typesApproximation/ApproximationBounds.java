/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ApproximationBounds<T> {
    private final T lower;
    private final T upper;

    public final T getLower() {
        return this.lower;
    }

    public final T getUpper() {
        return this.upper;
    }

    public ApproximationBounds(T lower, T upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public final T component1() {
        return this.lower;
    }

    public final T component2() {
        return this.upper;
    }

    @NotNull
    public final ApproximationBounds<T> copy(T lower, T upper) {
        return new ApproximationBounds<T>(lower, upper);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ ApproximationBounds copy$default(ApproximationBounds approximationBounds, Object object, Object object2, int n, Object object3) {
        if ((n & 1) != 0) {
            object = approximationBounds.lower;
        }
        if ((n & 2) != 0) {
            object2 = approximationBounds.upper;
        }
        return approximationBounds.copy(object, object2);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.lower + ", upper=" + this.upper + ")";
    }

    public int hashCode() {
        T t = this.lower;
        T t2 = this.upper;
        return (t != null ? t.hashCode() : 0) * 31 + (t2 != null ? t2.hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof ApproximationBounds)) break block3;
                ApproximationBounds approximationBounds = (ApproximationBounds)object;
                if (!Intrinsics.areEqual(this.lower, approximationBounds.lower) || !Intrinsics.areEqual(this.upper, approximationBounds.upper)) break block3;
            }
            return true;
        }
        return false;
    }
}

