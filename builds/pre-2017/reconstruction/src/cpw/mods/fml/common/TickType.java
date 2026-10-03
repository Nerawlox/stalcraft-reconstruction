/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import java.util.EnumSet;

public enum TickType {
    WORLD,
    RENDER,
    WORLDLOAD,
    CLIENT,
    PLAYER,
    SERVER;


    public EnumSet<TickType> partnerTicks() {
        if (this == CLIENT) {
            return EnumSet.of(RENDER);
        }
        if (this == RENDER) {
            return EnumSet.of(CLIENT);
        }
        return EnumSet.noneOf(TickType.class);
    }
}

