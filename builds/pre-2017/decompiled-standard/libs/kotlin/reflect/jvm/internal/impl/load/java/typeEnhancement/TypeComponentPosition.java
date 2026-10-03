/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

final class TypeComponentPosition
extends Enum<TypeComponentPosition> {
    public static final /* enum */ TypeComponentPosition FLEXIBLE_LOWER;
    public static final /* enum */ TypeComponentPosition FLEXIBLE_UPPER;
    public static final /* enum */ TypeComponentPosition INFLEXIBLE;
    private static final /* synthetic */ TypeComponentPosition[] $VALUES;

    static {
        TypeComponentPosition[] typeComponentPositionArray = new TypeComponentPosition[3];
        TypeComponentPosition[] typeComponentPositionArray2 = typeComponentPositionArray;
        typeComponentPositionArray[0] = FLEXIBLE_LOWER = new TypeComponentPosition();
        typeComponentPositionArray[1] = FLEXIBLE_UPPER = new TypeComponentPosition();
        typeComponentPositionArray[2] = INFLEXIBLE = new TypeComponentPosition();
        $VALUES = typeComponentPositionArray;
    }

    public static TypeComponentPosition[] values() {
        return (TypeComponentPosition[])$VALUES.clone();
    }

    public static TypeComponentPosition valueOf(String string) {
        return Enum.valueOf(TypeComponentPosition.class, string);
    }
}

