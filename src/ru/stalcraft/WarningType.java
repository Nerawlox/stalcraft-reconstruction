/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft;

public enum WarningType {
    ABUSE_OF_AUTHORITY("ABUSE_OF_AUTHORITY", 0),
    INVALID_OPERATION("INVALID_OPERATION", 1),
    INVALID_TARGET("INVALID_TARGET", 2),
    INVALID_USER("INVALID_USER", 3);

    private static final WarningType[] $VALUES;

    private WarningType(String var1, int var2) {
    }

    static {
        $VALUES = new WarningType[]{ABUSE_OF_AUTHORITY, INVALID_OPERATION, INVALID_TARGET, INVALID_USER};
    }
}

