/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.TaskLongRunning;

public class GuiScreenLongRunningTask
extends GuiScreen {
    public final int _a = 666;
    public final GuiScreen _b;
    public final Thread _c;
    public volatile String _d = "";
    public volatile boolean _e;
    public volatile String _f;
    public volatile boolean _g;
    public int _h;
    public TaskLongRunning _i;
    public static final String[] _j = new String[]{"\u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192", "_ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e", "_ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026", "_ _ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020", "_ _ _ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021", "_ _ _ _ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6", "_ _ _ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021", "_ _ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020", "_ _ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026", "_ \u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e", "\u00e2\u2013\u0192 \u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192", "\u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _", "\u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _", "\u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _ _", "\u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _ _ _", "\u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _ _ _ _", "\u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _ _ _", "\u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _ _", "\u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _ _", "\u00e2\u2013\u201e \u00e2\u2013\u2026 \u00e2\u2013\u2020 \u00e2\u2013\u2021 \u00e2\u2013\u02c6 \u00e2\u2013\u2021 \u00e2\u2013\u2020 \u00e2\u2013\u2026 \u00e2\u2013\u201e \u00e2\u2013\u0192 _"};

    public GuiScreenLongRunningTask(Minecraft minecraft, GuiScreen guiScreen, TaskLongRunning taskLongRunning) {
        this.buttonList = Collections.synchronizedList(new ArrayList());
        this.mc = minecraft;
        this._b = guiScreen;
        this._i = taskLongRunning;
        taskLongRunning._a(this);
        this._c = new Thread(taskLongRunning);
    }

    public void _a() {
        this._c.start();
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this._h;
        this._i._c();
    }

    @Override
    public void keyTyped(char c, int n) {
    }

    @Override
    public void initGui() {
        this._i._d();
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 666) {
            this._g = true;
            this.mc._a(this._b);
        }
        this._i._a(guiButton);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this._d, this.width / 2, this.height / 2 - 50, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "", this.width / 2, this.height / 2 - 10, 0xFFFFFF);
        if (!this._e) {
            this.drawCenteredString(this.fontRenderer, _j[this._h % _j.length], this.width / 2, this.height / 2 + 15, 0x808080);
        }
        if (this._e) {
            this.drawCenteredString(this.fontRenderer, this._f, this.width / 2, this.height / 2 + 15, 0xFF0000);
        }
        super.drawScreen(n, n2, f);
    }

    public void _a(String string) {
        this._e = true;
        this._f = string;
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(666, this.width / 2 - 100, this.height / 4 + 120 + 12, "Back"));
    }

    public Minecraft _b() {
        return this.mc;
    }

    public void _b(String string) {
        this._d = string;
    }

    public boolean _c() {
        return this._g;
    }
}

