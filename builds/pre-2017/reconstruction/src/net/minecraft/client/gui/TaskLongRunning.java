/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreenLongRunningTask;

public abstract class TaskLongRunning
implements Runnable {
    public GuiScreenLongRunningTask _a;

    public void _a(GuiScreenLongRunningTask guiScreenLongRunningTask) {
        this._a = guiScreenLongRunningTask;
    }

    public void _a(String string) {
        this._a._a(string);
    }

    public void _b(String string) {
        this._a._b(string);
    }

    public Minecraft _a() {
        return this._a._b();
    }

    public boolean _b() {
        return this._a._c();
    }

    public void _c() {
    }

    public void _a(GuiButton guiButton) {
    }

    public void _d() {
    }
}

