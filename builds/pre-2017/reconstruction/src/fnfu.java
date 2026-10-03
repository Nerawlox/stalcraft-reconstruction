/*
 * Decompiled with CFR 0.152.
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraft.client.gui.GuiRenameWorld;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.kjui;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveFormatComparator;
import net.minecraft.world.storage.WorldInfo;

public class fnfu
extends GuiScreen {
    public final DateFormat _a = new SimpleDateFormat();
    public GuiScreen _b;
    public String _c = "Select world";
    public boolean _d;
    public int _e;
    public List _f;
    public fnfc _g;
    public String _h;
    public String _i;
    public String[] _j = new String[3];
    public boolean _k;
    public GuiButton _l;
    public GuiButton _m;
    public GuiButton _n;
    public GuiButton _o;

    public fnfu(GuiScreen guiScreen) {
        this._b = guiScreen;
    }

    @Override
    public void initGui() {
        this._c = wpcz._a("selectWorld.title");
        try {
            this._a();
        }
        catch (kjui kjui2) {
            kjui2.printStackTrace();
            this.mc._a(new GuiErrorScreen("Unable to load words", kjui2.getMessage()));
            return;
        }
        this._h = wpcz._a("selectWorld.world");
        this._i = wpcz._a("selectWorld.conversion");
        this._j[EnumGameType._b._a()] = wpcz._a("gameMode.survival");
        this._j[EnumGameType._c._a()] = wpcz._a("gameMode.creative");
        this._j[EnumGameType._d._a()] = wpcz._a("gameMode.adventure");
        this._g = new fnfc(this);
        this._g.registerScrollButtons(4, 5);
        this._b();
    }

    public void _a() {
        ISaveFormat iSaveFormat = this.mc._g();
        this._f = iSaveFormat._a();
        Collections.sort(this._f);
        this._e = -1;
    }

    public String _a(int n) {
        return ((SaveFormatComparator)this._f.get(n))._a();
    }

    public String _b(int n) {
        String string = ((SaveFormatComparator)this._f.get(n))._b();
        if (string == null || sajh._a(string)) {
            string = wpcz._a("selectWorld.world") + " " + (n + 1);
        }
        return string;
    }

    public void _b() {
        this._m = new GuiButton(1, this.width / 2 - 154, this.height - 52, 150, 20, wpcz._a("selectWorld.select"));
        this.buttonList.add(this._m);
        this.buttonList.add(new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, wpcz._a("selectWorld.create")));
        this._n = new GuiButton(6, this.width / 2 - 154, this.height - 28, 72, 20, wpcz._a("selectWorld.rename"));
        this.buttonList.add(this._n);
        this._l = new GuiButton(2, this.width / 2 - 76, this.height - 28, 72, 20, wpcz._a("selectWorld.delete"));
        this.buttonList.add(this._l);
        this._o = new GuiButton(7, this.width / 2 + 4, this.height - 28, 72, 20, wpcz._a("selectWorld.recreate"));
        this.buttonList.add(this._o);
        this.buttonList.add(new GuiButton(0, this.width / 2 + 82, this.height - 28, 72, 20, wpcz._a("gui.cancel")));
        this._m.enabled = false;
        this._l.enabled = false;
        this._n.enabled = false;
        this._o.enabled = false;
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 2) {
            String string = this._b(this._e);
            if (string != null) {
                this._k = true;
                GuiYesNo guiYesNo = fnfu._a(this, string, this._e);
                this.mc._a(guiYesNo);
            }
        } else if (guiButton.id == 1) {
            this._c(this._e);
        } else if (guiButton.id == 3) {
            this.mc._a(new GuiCreateWorld(this));
        } else if (guiButton.id == 6) {
            this.mc._a(new GuiRenameWorld(this, this._a(this._e)));
        } else if (guiButton.id == 0) {
            this.mc._a(this._b);
        } else if (guiButton.id == 7) {
            GuiCreateWorld guiCreateWorld = new GuiCreateWorld(this);
            ISaveHandler iSaveHandler = this.mc._g()._a(this._a(this._e), false);
            WorldInfo worldInfo = iSaveHandler.loadWorldInfo();
            iSaveHandler.flush();
            guiCreateWorld._a(worldInfo);
            this.mc._a(guiCreateWorld);
        } else {
            this._g.actionPerformed(guiButton);
        }
    }

    public void _c(int n) {
        String string;
        this.mc._a((GuiScreen)null);
        if (this._d) {
            return;
        }
        this._d = true;
        String string2 = this._a(n);
        if (string2 == null) {
            string2 = "World" + n;
        }
        if ((string = this._b(n)) == null) {
            string = "World" + n;
        }
        if (this.mc._g()._e(string2)) {
            this.mc._a(string2, string, null);
            this.mc._X._a(dzif._h, 1);
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (this._k) {
            this._k = false;
            if (bl) {
                ISaveFormat iSaveFormat = this.mc._g();
                iSaveFormat._c();
                iSaveFormat._d(this._a(n));
                try {
                    this._a();
                }
                catch (kjui kjui2) {
                    kjui2.printStackTrace();
                }
            }
            this.mc._a(this);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this._g.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRenderer, this._c, this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    public static GuiYesNo _a(GuiScreen guiScreen, String string, int n) {
        String string2 = wpcz._a("selectWorld.deleteQuestion");
        String string3 = "'" + string + "' " + wpcz._a("selectWorld.deleteWarning");
        String string4 = wpcz._a("selectWorld.deleteButton");
        String string5 = wpcz._a("gui.cancel");
        GuiYesNo guiYesNo = new GuiYesNo(guiScreen, string2, string3, string4, string5, n);
        return guiYesNo;
    }

    public static /* synthetic */ List _a(fnfu fnfu2) {
        return fnfu2._f;
    }

    public static /* synthetic */ int _a(fnfu fnfu2, int n) {
        fnfu2._e = n;
        return fnfu2._e;
    }

    public static /* synthetic */ int _b(fnfu fnfu2) {
        return fnfu2._e;
    }

    public static /* synthetic */ GuiButton _c(fnfu fnfu2) {
        return fnfu2._m;
    }

    public static /* synthetic */ GuiButton _d(fnfu fnfu2) {
        return fnfu2._l;
    }

    public static /* synthetic */ GuiButton _e(fnfu fnfu2) {
        return fnfu2._n;
    }

    public static /* synthetic */ GuiButton _f(fnfu fnfu2) {
        return fnfu2._o;
    }

    public static /* synthetic */ String _g(fnfu fnfu2) {
        return fnfu2._h;
    }

    public static /* synthetic */ DateFormat _h(fnfu fnfu2) {
        return fnfu2._a;
    }

    public static /* synthetic */ String _i(fnfu fnfu2) {
        return fnfu2._i;
    }

    public static /* synthetic */ String[] _j(fnfu fnfu2) {
        return fnfu2._j;
    }
}

