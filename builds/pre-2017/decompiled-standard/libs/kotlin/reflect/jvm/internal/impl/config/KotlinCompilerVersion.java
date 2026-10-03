/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.config;

public class KotlinCompilerVersion {
    public static final String VERSION = "1.1.1";
    public static final boolean IS_PRE_RELEASE = false;

    static {
        if (VERSION.equals(VERSION) || !VERSION.contains("-")) {
            // empty if block
        }
    }
}

