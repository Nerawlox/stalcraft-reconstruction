/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

public final class SourceKind
extends Enum<SourceKind> {
    public static final /* enum */ SourceKind NONE;
    public static final /* enum */ SourceKind PRODUCTION;
    public static final /* enum */ SourceKind TEST;
    private static final /* synthetic */ SourceKind[] $VALUES;

    static {
        SourceKind[] sourceKindArray = new SourceKind[3];
        SourceKind[] sourceKindArray2 = sourceKindArray;
        sourceKindArray[0] = NONE = new SourceKind();
        sourceKindArray[1] = PRODUCTION = new SourceKind();
        sourceKindArray[2] = TEST = new SourceKind();
        $VALUES = sourceKindArray;
    }

    public static SourceKind[] values() {
        return (SourceKind[])$VALUES.clone();
    }

    public static SourceKind valueOf(String string) {
        return Enum.valueOf(SourceKind.class, string);
    }
}

