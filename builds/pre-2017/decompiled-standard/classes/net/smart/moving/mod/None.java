/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.mod;

import net.smart.moving.mod.Mod;

public class None
extends Mod {
    public static None create(mod_SmartMoving mod_SmartMoving2) {
        return new None(mod_SmartMoving2);
    }

    protected None(mod_SmartMoving mod_SmartMoving2) {
        super(mod_SmartMoving2);
    }

    @Override
    public String toString() {
        return super.toString() + " (disabled)";
    }
}

