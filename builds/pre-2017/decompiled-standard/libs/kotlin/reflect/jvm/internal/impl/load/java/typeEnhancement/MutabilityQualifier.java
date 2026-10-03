/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

public final class MutabilityQualifier
extends Enum<MutabilityQualifier> {
    public static final /* enum */ MutabilityQualifier READ_ONLY;
    public static final /* enum */ MutabilityQualifier MUTABLE;
    private static final /* synthetic */ MutabilityQualifier[] $VALUES;

    static {
        MutabilityQualifier[] mutabilityQualifierArray = new MutabilityQualifier[2];
        MutabilityQualifier[] mutabilityQualifierArray2 = mutabilityQualifierArray;
        mutabilityQualifierArray[0] = READ_ONLY = new MutabilityQualifier();
        mutabilityQualifierArray[1] = MUTABLE = new MutabilityQualifier();
        $VALUES = mutabilityQualifierArray;
    }

    public static MutabilityQualifier[] values() {
        return (MutabilityQualifier[])$VALUES.clone();
    }

    public static MutabilityQualifier valueOf(String string) {
        return Enum.valueOf(MutabilityQualifier.class, string);
    }
}

