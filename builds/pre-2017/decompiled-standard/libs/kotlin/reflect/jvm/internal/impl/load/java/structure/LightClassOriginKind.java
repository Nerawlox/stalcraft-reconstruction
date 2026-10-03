/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

public final class LightClassOriginKind
extends Enum<LightClassOriginKind> {
    public static final /* enum */ LightClassOriginKind SOURCE;
    public static final /* enum */ LightClassOriginKind BINARY;
    private static final /* synthetic */ LightClassOriginKind[] $VALUES;

    static {
        LightClassOriginKind[] lightClassOriginKindArray = new LightClassOriginKind[2];
        LightClassOriginKind[] lightClassOriginKindArray2 = lightClassOriginKindArray;
        lightClassOriginKindArray[0] = SOURCE = new LightClassOriginKind();
        lightClassOriginKindArray[1] = BINARY = new LightClassOriginKind();
        $VALUES = lightClassOriginKindArray;
    }

    public static LightClassOriginKind[] values() {
        return (LightClassOriginKind[])$VALUES.clone();
    }

    public static LightClassOriginKind valueOf(String string) {
        return Enum.valueOf(LightClassOriginKind.class, string);
    }
}

