/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

public final class RawBound
extends Enum<RawBound> {
    public static final /* enum */ RawBound LOWER;
    public static final /* enum */ RawBound UPPER;
    public static final /* enum */ RawBound NOT_RAW;
    private static final /* synthetic */ RawBound[] $VALUES;

    static {
        RawBound[] rawBoundArray = new RawBound[3];
        RawBound[] rawBoundArray2 = rawBoundArray;
        rawBoundArray[0] = LOWER = new RawBound();
        rawBoundArray[1] = UPPER = new RawBound();
        rawBoundArray[2] = NOT_RAW = new RawBound();
        $VALUES = rawBoundArray;
    }

    public static RawBound[] values() {
        return (RawBound[])$VALUES.clone();
    }

    public static RawBound valueOf(String string) {
        return Enum.valueOf(RawBound.class, string);
    }
}

