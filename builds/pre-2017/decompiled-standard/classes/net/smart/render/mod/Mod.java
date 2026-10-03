/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.mod;

import java.util.Map;
import net.minecraft.client.xpzm;

public class Mod {
    protected final mod_SmartRender mod;

    protected Mod(mod_SmartRender mod_SmartRender2) {
        this.mod = mod_SmartRender2;
    }

    public void load() {
    }

    public void addRenderer(Map map) {
    }

    public void registerAnimation(xpzm xpzm2) {
    }

    public boolean onTickInGame(float f, xpzm xpzm2) {
        return false;
    }

    public String getName() {
        return "Smart Render";
    }

    public String getVersion() {
        return "1.1";
    }

    public String toString() {
        return "Smart Render 1.1";
    }
}

