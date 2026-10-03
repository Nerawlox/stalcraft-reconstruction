/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

public final class JavaTypeFlexibility
extends Enum<JavaTypeFlexibility> {
    public static final /* enum */ JavaTypeFlexibility INFLEXIBLE;
    public static final /* enum */ JavaTypeFlexibility FLEXIBLE_UPPER_BOUND;
    public static final /* enum */ JavaTypeFlexibility FLEXIBLE_LOWER_BOUND;
    private static final /* synthetic */ JavaTypeFlexibility[] $VALUES;

    static {
        JavaTypeFlexibility[] javaTypeFlexibilityArray = new JavaTypeFlexibility[3];
        JavaTypeFlexibility[] javaTypeFlexibilityArray2 = javaTypeFlexibilityArray;
        javaTypeFlexibilityArray[0] = INFLEXIBLE = new JavaTypeFlexibility();
        javaTypeFlexibilityArray[1] = FLEXIBLE_UPPER_BOUND = new JavaTypeFlexibility();
        javaTypeFlexibilityArray[2] = FLEXIBLE_LOWER_BOUND = new JavaTypeFlexibility();
        $VALUES = javaTypeFlexibilityArray;
    }

    public static JavaTypeFlexibility[] values() {
        return (JavaTypeFlexibility[])$VALUES.clone();
    }

    public static JavaTypeFlexibility valueOf(String string) {
        return Enum.valueOf(JavaTypeFlexibility.class, string);
    }
}

