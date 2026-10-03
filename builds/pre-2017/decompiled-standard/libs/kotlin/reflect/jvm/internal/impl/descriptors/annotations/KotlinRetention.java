/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

public final class KotlinRetention
extends Enum<KotlinRetention> {
    public static final /* enum */ KotlinRetention RUNTIME;
    public static final /* enum */ KotlinRetention BINARY;
    public static final /* enum */ KotlinRetention SOURCE;
    private static final /* synthetic */ KotlinRetention[] $VALUES;

    static {
        KotlinRetention[] kotlinRetentionArray = new KotlinRetention[3];
        KotlinRetention[] kotlinRetentionArray2 = kotlinRetentionArray;
        kotlinRetentionArray[0] = RUNTIME = new KotlinRetention();
        kotlinRetentionArray[1] = BINARY = new KotlinRetention();
        kotlinRetentionArray[2] = SOURCE = new KotlinRetention();
        $VALUES = kotlinRetentionArray;
    }

    public static KotlinRetention[] values() {
        return (KotlinRetention[])$VALUES.clone();
    }

    public static KotlinRetention valueOf(String string) {
        return Enum.valueOf(KotlinRetention.class, string);
    }
}

