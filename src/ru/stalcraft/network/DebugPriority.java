/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.network;

public enum DebugPriority {
    LOW("LOW", 0),
    MIDDLE("MIDDLE", 1),
    HIGH("HIGH", 2);

    private static final DebugPriority[] $VALUES;

    private DebugPriority(String var1, int var2) {
    }

    static {
        $VALUES = new DebugPriority[]{LOW, MIDDLE, HIGH};
    }
}

