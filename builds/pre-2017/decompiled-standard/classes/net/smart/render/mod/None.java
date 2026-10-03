/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.mod;

import net.smart.render.mod.Mod;

public class None
extends Mod {
    public static None create(mod_SmartRender mod_SmartRender2) {
        return new None(mod_SmartRender2);
    }

    public None(mod_SmartRender mod_SmartRender2) {
        super(mod_SmartRender2);
    }

    @Override
    public String toString() {
        return "Smart Render 1.1 (disabled)";
    }
}

