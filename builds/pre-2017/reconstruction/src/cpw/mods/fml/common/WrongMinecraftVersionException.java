/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import cpw.mods.fml.common.ModContainer;

public class WrongMinecraftVersionException
extends RuntimeException {
    public ModContainer mod;

    public WrongMinecraftVersionException(ModContainer modContainer) {
        this.mod = modContainer;
    }
}

