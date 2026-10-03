/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance$WhenMappings;
import org.jetbrains.annotations.NotNull;

public final class Variance
extends Enum<Variance> {
    public static final /* enum */ Variance INVARIANT;
    public static final /* enum */ Variance IN_VARIANCE;
    public static final /* enum */ Variance OUT_VARIANCE;
    private static final /* synthetic */ Variance[] $VALUES;
    @NotNull
    private final String label;
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final int superpositionFactor;

    static {
        Variance[] varianceArray = new Variance[3];
        Variance[] varianceArray2 = varianceArray;
        varianceArray[0] = INVARIANT = new Variance("", true, true, 0);
        varianceArray[1] = IN_VARIANCE = new Variance("in", true, false, -1);
        varianceArray[2] = OUT_VARIANCE = new Variance("out", false, true, 1);
        $VALUES = varianceArray;
    }

    public final boolean allowsPosition(@NotNull Variance position) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull((Object)position, "position");
        switch (Variance$WhenMappings.$EnumSwitchMapping$0[position.ordinal()]) {
            case 1: {
                bl = this.allowsInPosition;
                break;
            }
            case 2: {
                bl = this.allowsOutPosition;
                break;
            }
            case 3: {
                if (this.allowsInPosition && this.allowsOutPosition) {
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return bl;
    }

    @NotNull
    public final Variance superpose(@NotNull Variance other) {
        Variance variance;
        Intrinsics.checkParameterIsNotNull((Object)other, "other");
        int r = this.superpositionFactor * other.superpositionFactor;
        switch (r) {
            case 0: {
                variance = INVARIANT;
                break;
            }
            case -1: {
                variance = IN_VARIANCE;
                break;
            }
            case 1: {
                variance = OUT_VARIANCE;
                break;
            }
            default: {
                throw (Throwable)new IllegalStateException("Illegal factor: " + r);
            }
        }
        return variance;
    }

    @NotNull
    public final Variance opposite() {
        Variance variance;
        switch (Variance$WhenMappings.$EnumSwitchMapping$1[this.ordinal()]) {
            case 1: {
                variance = INVARIANT;
                break;
            }
            case 2: {
                variance = OUT_VARIANCE;
                break;
            }
            case 3: {
                variance = IN_VARIANCE;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return variance;
    }

    @NotNull
    public String toString() {
        return this.label;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public final boolean getAllowsInPosition() {
        return this.allowsInPosition;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    protected Variance(String label, boolean allowsInPosition, boolean allowsOutPosition, int superpositionFactor) {
        Intrinsics.checkParameterIsNotNull(label, "label");
        this.label = label;
        this.allowsInPosition = allowsInPosition;
        this.allowsOutPosition = allowsOutPosition;
        this.superpositionFactor = superpositionFactor;
    }

    public static Variance[] values() {
        return (Variance[])$VALUES.clone();
    }

    public static Variance valueOf(String string) {
        return Enum.valueOf(Variance.class, string);
    }
}

