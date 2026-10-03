/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import gloomyfolken.mods.asm.GloomyHooks;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class pzde {
    public int _a;
    public int _b;

    public void _a() {
        Mouse.setGrabbed(true);
        this._a = 0;
        this._b = 0;
    }

    public void _b() {
        Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
        Mouse.setGrabbed(false);
    }

    public void _c() {
        this._a = Mouse.getDX();
        this._b = Mouse.getDY();
        GloomyHooks.mouseXYChange(this);
    }
}

