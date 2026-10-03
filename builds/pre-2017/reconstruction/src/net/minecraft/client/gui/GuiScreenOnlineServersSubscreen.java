/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiScreenOnlineServersSubscreen {
    public final int _a;
    public final int _b;
    public final int _c;
    public final int _d;
    public List _e = new ArrayList();
    public String[] _f;
    public String[] _g;
    public String[][] _h;
    public int _i;
    public int _j;

    public GuiScreenOnlineServersSubscreen(int n, int n2, int n3, int n4, int n5, int n6) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._i = n5;
        this._j = n6;
        this._a();
    }

    public void _a() {
        this._b();
        this._e.add(new GuiButton(5005, this._c, this._d + 1, 212, 20, this._c()));
        this._e.add(new GuiButton(5006, this._c, this._d + 25, 212, 20, this._d()));
    }

    public void _b() {
        this._f = new String[]{wpcz._a("options.difficulty.peaceful"), wpcz._a("options.difficulty.easy"), wpcz._a("options.difficulty.normal"), wpcz._a("options.difficulty.hard")};
        this._g = new String[]{wpcz._a("selectWorld.gameMode.survival"), wpcz._a("selectWorld.gameMode.creative"), wpcz._a("selectWorld.gameMode.adventure")};
        this._h = new String[][]{{wpcz._a("selectWorld.gameMode.survival.line1"), wpcz._a("selectWorld.gameMode.survival.line2")}, {wpcz._a("selectWorld.gameMode.creative.line1"), wpcz._a("selectWorld.gameMode.creative.line2")}, {wpcz._a("selectWorld.gameMode.adventure.line1"), wpcz._a("selectWorld.gameMode.adventure.line2")}};
    }

    public String _c() {
        String string = wpcz._a("options.difficulty");
        return string + ": " + this._f[this._i];
    }

    public String _d() {
        String string = wpcz._a("selectWorld.gameMode");
        return string + ": " + this._g[this._j];
    }

    public void _a(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 5005) {
            this._i = (this._i + 1) % this._f.length;
            guiButton.displayString = this._c();
        } else if (guiButton.id == 5006) {
            this._j = (this._j + 1) % this._g.length;
            guiButton.displayString = this._d();
        }
    }

    public void _a(GuiScreen guiScreen, FontRenderer fontRenderer) {
        guiScreen.drawString(fontRenderer, this._h[this._j][0], this._c, this._d + 50, 0xA0A0A0);
        guiScreen.drawString(fontRenderer, this._h[this._j][1], this._c, this._d + 60, 0xA0A0A0);
    }
}

