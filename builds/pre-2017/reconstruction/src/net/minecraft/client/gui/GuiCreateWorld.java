/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import org.lwjgl.input.Keyboard;

@SideOnly(value=Side.CLIENT)
public class GuiCreateWorld
extends GuiScreen {
    public GuiScreen _a;
    public GuiTextField _b;
    public GuiTextField _c;
    public String _d;
    public String _e = "survival";
    public boolean _f = true;
    public boolean _g;
    public boolean _h;
    public boolean _i;
    public boolean _j;
    public boolean _k;
    public boolean _l;
    public GuiButton _m;
    public GuiButton _n;
    public GuiButton _o;
    public GuiButton _p;
    public GuiButton _q;
    public GuiButton _r;
    public GuiButton _s;
    public String _t;
    public String _u;
    public String _v;
    public String _w;
    public int _x;
    public String _y = "";
    public static final String[] _z = new String[]{"CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};

    public GuiCreateWorld(GuiScreen guiScreen) {
        this._a = guiScreen;
        this._v = "";
        this._w = wpcz._a("selectWorld.newWorld");
    }

    @Override
    public void updateScreen() {
        this._b.updateCursorCounter();
        this._c.updateCursorCounter();
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, wpcz._a("selectWorld.create")));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, wpcz._a("gui.cancel")));
        this._m = new GuiButton(2, this.width / 2 - 75, 115, 150, 20, wpcz._a("selectWorld.gameMode"));
        this.buttonList.add(this._m);
        this._n = new GuiButton(3, this.width / 2 - 75, 187, 150, 20, wpcz._a("selectWorld.moreWorldOptions"));
        this.buttonList.add(this._n);
        this._o = new GuiButton(4, this.width / 2 - 155, 100, 150, 20, wpcz._a("selectWorld.mapFeatures"));
        this.buttonList.add(this._o);
        this._o.drawButton = false;
        this._p = new GuiButton(7, this.width / 2 + 5, 151, 150, 20, wpcz._a("selectWorld.bonusItems"));
        this.buttonList.add(this._p);
        this._p.drawButton = false;
        this._q = new GuiButton(5, this.width / 2 + 5, 100, 150, 20, wpcz._a("selectWorld.mapType"));
        this.buttonList.add(this._q);
        this._q.drawButton = false;
        this._r = new GuiButton(6, this.width / 2 - 155, 151, 150, 20, wpcz._a("selectWorld.allowCommands"));
        this.buttonList.add(this._r);
        this._r.drawButton = false;
        this._s = new GuiButton(8, this.width / 2 + 5, 120, 150, 20, wpcz._a("selectWorld.customizeType"));
        this.buttonList.add(this._s);
        this._s.drawButton = false;
        this._b = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 60, 200, 20);
        this._b.setFocused(true);
        this._b.setText(this._w);
        this._c = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 60, 200, 20);
        this._c.setText(this._v);
        this._a(this._l);
        this._a();
        this._b();
    }

    public void _a() {
        this._d = this._b.getText().trim();
        for (char c : ChatAllowedCharacters._b) {
            this._d = this._d.replace(c, '_');
        }
        if (sajh._a(this._d)) {
            this._d = "World";
        }
        this._d = GuiCreateWorld._a(this.mc._g(), this._d);
    }

    public void _b() {
        this._m.displayString = wpcz._a("selectWorld.gameMode") + " " + wpcz._a("selectWorld.gameMode." + this._e);
        this._t = wpcz._a("selectWorld.gameMode." + this._e + ".line1");
        this._u = wpcz._a("selectWorld.gameMode." + this._e + ".line2");
        this._o.displayString = wpcz._a("selectWorld.mapFeatures") + " ";
        this._o.displayString = this._f ? this._o.displayString + wpcz._a("options.on") : this._o.displayString + wpcz._a("options.off");
        this._p.displayString = wpcz._a("selectWorld.bonusItems") + " ";
        this._p.displayString = this._i && !this._j ? this._p.displayString + wpcz._a("options.on") : this._p.displayString + wpcz._a("options.off");
        this._q.displayString = wpcz._a("selectWorld.mapType") + " " + wpcz._a(nwix._c[this._x]._b());
        this._r.displayString = wpcz._a("selectWorld.allowCommands") + " ";
        this._r.displayString = this._g && !this._j ? this._r.displayString + wpcz._a("options.on") : this._r.displayString + wpcz._a("options.off");
    }

    public static String _a(ISaveFormat iSaveFormat, String string) {
        string = string.replaceAll("[\\./\"]", "_");
        for (String string2 : _z) {
            if (!string.equalsIgnoreCase(string2)) continue;
            string = "_" + string + "_";
        }
        while (iSaveFormat._c(string) != null) {
            string = string + "-";
        }
        return string;
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.enabled) {
            if (guiButton.id == 1) {
                this.mc._a(this._a);
            } else if (guiButton.id == 0) {
                this.mc._a((GuiScreen)null);
                if (this._k) {
                    return;
                }
                this._k = true;
                long l = new Random().nextLong();
                String string = this._c.getText();
                if (!sajh._a(string)) {
                    try {
                        long l2 = Long.parseLong(string);
                        if (l2 != 0L) {
                            l = l2;
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        l = string.hashCode();
                    }
                }
                nwix._c[this._x]._j();
                EnumGameType enumGameType = EnumGameType._a(this._e);
                WorldSettings worldSettings = new WorldSettings(l, enumGameType, this._f, this._j, nwix._c[this._x]);
                worldSettings._a(this._y);
                if (this._i && !this._j) {
                    worldSettings._a();
                }
                if (this._g && !this._j) {
                    worldSettings._b();
                }
                this.mc._a(this._d, this._b.getText().trim(), worldSettings);
                this.mc._X._a(dzif._g, 1);
            } else if (guiButton.id == 3) {
                this._c();
            } else if (guiButton.id == 2) {
                if (this._e.equals("survival")) {
                    if (!this._h) {
                        this._g = false;
                    }
                    this._j = false;
                    this._e = "hardcore";
                    this._j = true;
                    this._r.enabled = false;
                    this._p.enabled = false;
                    this._b();
                } else if (this._e.equals("hardcore")) {
                    if (!this._h) {
                        this._g = true;
                    }
                    this._j = false;
                    this._e = "creative";
                    this._b();
                    this._j = false;
                    this._r.enabled = true;
                    this._p.enabled = true;
                } else {
                    if (!this._h) {
                        this._g = false;
                    }
                    this._e = "survival";
                    this._b();
                    this._r.enabled = true;
                    this._p.enabled = true;
                    this._j = false;
                }
                this._b();
            } else if (guiButton.id == 4) {
                this._f = !this._f;
                this._b();
            } else if (guiButton.id == 7) {
                this._i = !this._i;
                this._b();
            } else if (guiButton.id == 5) {
                ++this._x;
                if (this._x >= nwix._c.length) {
                    this._x = 0;
                }
                while (nwix._c[this._x] == null || !nwix._c[this._x]._d()) {
                    ++this._x;
                    if (this._x < nwix._c.length) continue;
                    this._x = 0;
                }
                this._y = "";
                this._b();
                this._a(this._l);
            } else if (guiButton.id == 6) {
                this._h = true;
                this._g = !this._g;
                this._b();
            } else if (guiButton.id == 8) {
                nwix._c[this._x]._a(this.mc, this);
            }
        }
    }

    public void _c() {
        this._a(!this._l);
    }

    public void _a(boolean bl) {
        this._l = bl;
        this._m.drawButton = !this._l;
        this._o.drawButton = this._l;
        this._p.drawButton = this._l;
        this._q.drawButton = this._l;
        this._r.drawButton = this._l;
        this._s.drawButton = this._l && nwix._c[this._x]._l();
        this._n.displayString = this._l ? wpcz._a("gui.done") : wpcz._a("selectWorld.moreWorldOptions");
    }

    @Override
    public void keyTyped(char c, int n) {
        if (this._b.isFocused() && !this._l) {
            this._b.textboxKeyTyped(c, n);
            this._w = this._b.getText();
        } else if (this._c.isFocused() && this._l) {
            this._c.textboxKeyTyped(c, n);
            this._v = this._c.getText();
        }
        if (n == 28 || n == 156) {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
        ((GuiButton)this.buttonList.get((int)0)).enabled = this._b.getText().length() > 0;
        this._a();
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (this._l) {
            this._c.mouseClicked(n, n2, n3);
        } else {
            this._b.mouseClicked(n, n2, n3);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, wpcz._a("selectWorld.create"), this.width / 2, 20, 0xFFFFFF);
        if (this._l) {
            this.drawString(this.fontRenderer, wpcz._a("selectWorld.enterSeed"), this.width / 2 - 100, 47, 0xA0A0A0);
            this.drawString(this.fontRenderer, wpcz._a("selectWorld.seedInfo"), this.width / 2 - 100, 85, 0xA0A0A0);
            this.drawString(this.fontRenderer, wpcz._a("selectWorld.mapFeatures.info"), this.width / 2 - 150, 122, 0xA0A0A0);
            this.drawString(this.fontRenderer, wpcz._a("selectWorld.allowCommands.info"), this.width / 2 - 150, 172, 0xA0A0A0);
            this._c.drawTextBox();
        } else {
            this.drawString(this.fontRenderer, wpcz._a("selectWorld.enterName"), this.width / 2 - 100, 47, 0xA0A0A0);
            this.drawString(this.fontRenderer, wpcz._a("selectWorld.resultFolder") + " " + this._d, this.width / 2 - 100, 85, 0xA0A0A0);
            this._b.drawTextBox();
            this.drawString(this.fontRenderer, this._t, this.width / 2 - 100, 137, 0xA0A0A0);
            this.drawString(this.fontRenderer, this._u, this.width / 2 - 100, 149, 0xA0A0A0);
        }
        super.drawScreen(n, n2, f);
    }

    public void _a(WorldInfo worldInfo) {
        this._w = wpcz._a("selectWorld.newWorld.copyOf", worldInfo._k());
        this._v = worldInfo._b() + "";
        this._x = worldInfo._u()._g();
        this._y = worldInfo._y();
        this._f = worldInfo._s();
        this._g = worldInfo._v();
        if (worldInfo._t()) {
            this._e = "hardcore";
        } else if (worldInfo._r()._e()) {
            this._e = "survival";
        } else if (worldInfo._r()._d()) {
            this._e = "creative";
        }
    }
}

