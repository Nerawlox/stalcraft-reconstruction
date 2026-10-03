/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.typeUtil;

public final class TypeNullability
extends Enum<TypeNullability> {
    public static final /* enum */ TypeNullability NOT_NULL;
    public static final /* enum */ TypeNullability NULLABLE;
    public static final /* enum */ TypeNullability FLEXIBLE;
    private static final /* synthetic */ TypeNullability[] $VALUES;

    static {
        TypeNullability[] typeNullabilityArray = new TypeNullability[3];
        TypeNullability[] typeNullabilityArray2 = typeNullabilityArray;
        typeNullabilityArray[0] = NOT_NULL = new TypeNullability();
        typeNullabilityArray[1] = NULLABLE = new TypeNullability();
        typeNullabilityArray[2] = FLEXIBLE = new TypeNullability();
        $VALUES = typeNullabilityArray;
    }

    public static TypeNullability[] values() {
        return (TypeNullability[])$VALUES.clone();
    }

    public static TypeNullability valueOf(String string) {
        return Enum.valueOf(TypeNullability.class, string);
    }
}

