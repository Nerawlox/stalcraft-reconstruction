/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenConfirmation;
import net.minecraft.client.gui.GuiScreenEditOnlineWorld;
import net.minecraft.client.gui.GuiScreenInvite;
import net.minecraft.client.gui.GuiScreenSubscription;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.GuiScreenConfirmationType;
import net.minecraft.client.mco.McoServer;
import org.lwjgl.input.Keyboard;

public class xaxz
extends GuiScreen {
    public final GuiScreen _a;
    public McoServer _b;
    public ekfb _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g = -1;
    public String _h;
    public GuiButton _i;
    public GuiButton _j;
    public GuiButton _k;
    public GuiButton _l;
    public GuiButton _m;
    public GuiButton _n;
    public GuiButton _o;
    public GuiButton _p;
    public boolean _q;

    public xaxz(GuiScreen guiScreen, McoServer mcoServer) {
        this._a = guiScreen;
        this._b = mcoServer;
    }

    @Override
    public void updateScreen() {
    }

    @Override
    public void initGui() {
        this._d = this.width / 2 - 200;
        this._e = 180;
        this._f = this.width / 2;
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        if (this._b._d.equals("CLOSED")) {
            this._i = new GuiButton(0, this._d, this._a(12), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.open"));
            this.buttonList.add(this._i);
            this._i.enabled = !this._b._h;
        } else {
            this._j = new GuiButton(1, this._d, this._a(12), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.close"));
            this.buttonList.add(this._j);
            this._j.enabled = !this._b._h;
        }
        this._o = new GuiButton(7, this._d + this._e / 2 + 2, this._a(12), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.subscription"));
        this.buttonList.add(this._o);
        this._k = new GuiButton(5, this._d, this._a(10), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.edit"));
        this.buttonList.add(this._k);
        this._l = new GuiButton(6, this._d + this._e / 2 + 2, this._a(10), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.reset"));
        this.buttonList.add(this._l);
        this._m = new GuiButton(4, this._f, this._a(10), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.invite"));
        this.buttonList.add(this._m);
        this._n = new GuiButton(3, this._f + this._e / 2 + 2, this._a(10), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.uninvite"));
        this.buttonList.add(this._n);
        this._p = new GuiButton(8, this._f, this._a(12), this._e / 2 - 2, 20, wpcz._a("mco.configure.world.buttons.backup"));
        this.buttonList.add(this._p);
        this.buttonList.add(new GuiButton(10, this._f + this._e / 2 + 2, this._a(12), this._e / 2 - 2, 20, wpcz._a("gui.back")));
        this._c = new ekfb(this);
        this._k.enabled = !this._b._h;
        this._l.enabled = !this._b._h;
        this._m.enabled = !this._b._h;
        this._n.enabled = !this._b._h;
        this._p.enabled = !this._b._h;
    }

    public int _a(int n) {
        return 40 + n * 13;
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 10) {
            if (this._q) {
                ((htmo)this._a)._c(this._b._a);
            }
            this.mc._a(this._a);
        } else if (guiButton.id == 5) {
            this.mc._a(new GuiScreenEditOnlineWorld(this, this._a, this._b));
        } else if (guiButton.id == 1) {
            String string = wpcz._a("mco.configure.world.close.question.line1");
            String string2 = wpcz._a("mco.configure.world.close.question.line2");
            this.mc._a(new GuiScreenConfirmation(this, GuiScreenConfirmationType._b, string, string2, 1));
        } else if (guiButton.id == 0) {
            this._a();
        } else if (guiButton.id == 4) {
            this.mc._a(new GuiScreenInvite(this._a, this, this._b));
        } else if (guiButton.id == 3) {
            this._c();
        } else if (guiButton.id == 6) {
            this.mc._a(new scom(this, this._b));
        } else if (guiButton.id == 7) {
            this.mc._a(new GuiScreenSubscription(this, this._b));
        } else if (guiButton.id == 8) {
            this.mc._a(new scox(this, this._b._a));
        }
    }

    public void _a() {
        rqmi rqmi2 = new rqmi(this.mc._P());
        try {
            Boolean bl = rqmi2._e(this._b._a);
            if (bl.booleanValue()) {
                this._q = true;
                this._b._d = "OPEN";
                this.initGui();
            }
        }
        catch (ExceptionMcoService exceptionMcoService) {
            this.mc._O()._c(exceptionMcoService.toString());
        }
        catch (IOException iOException) {
            this.mc._O()._b("Realms: could not parse response");
        }
    }

    public void _b() {
        rqmi rqmi2 = new rqmi(this.mc._P());
        try {
            boolean bl = rqmi2._f(this._b._a);
            if (bl) {
                this._q = true;
                this._b._d = "CLOSED";
                this.initGui();
            }
        }
        catch (ExceptionMcoService exceptionMcoService) {
            this.mc._O()._c(exceptionMcoService.toString());
        }
        catch (IOException iOException) {
            this.mc._O()._b("Realms: could not parse response");
        }
    }

    public void _c() {
        if (this._g >= 0 && this._g < this._b._f.size()) {
            this._h = (String)this._b._f.get(this._g);
            GuiYesNo guiYesNo = new GuiYesNo(this, "Warning!", wpcz._a("mco.configure.world.uninvite.question") + " '" + this._h + "'", 3);
            this.mc._a(guiYesNo);
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (n == 3) {
            if (bl) {
                rqmi rqmi2 = new rqmi(this.mc._P());
                try {
                    rqmi2._a(this._b._a, this._h);
                }
                catch (ExceptionMcoService exceptionMcoService) {
                    this.mc._O()._c(exceptionMcoService.toString());
                }
                this._b(this._g);
            }
            this.mc._a(new xaxz(this._a, this._b));
        }
        if (n == 1) {
            if (bl) {
                this._b();
            }
            this.mc._a(this);
        }
    }

    public void _b(int n) {
        this._b._f.remove(n);
    }

    @Override
    public void keyTyped(char c, int n) {
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this._c._a(n, n2, f);
        this.drawCenteredString(this.fontRenderer, wpcz._a("mco.configure.world.title"), this.width / 2, 17, 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("mco.configure.world.name"), this._d, this._a(1), 0xA0A0A0);
        this.drawString(this.fontRenderer, this._b._b(), this._d, this._a(2), 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("mco.configure.world.description"), this._d, this._a(4), 0xA0A0A0);
        this.drawString(this.fontRenderer, this._b._a(), this._d, this._a(5), 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("mco.configure.world.status"), this._d, this._a(7), 0xA0A0A0);
        this.drawString(this.fontRenderer, this._d(), this._d, this._a(8), 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("mco.configure.world.invited"), this._f, this._a(1), 0xA0A0A0);
        super.drawScreen(n, n2, f);
    }

    public String _d() {
        if (this._b._h) {
            return "Expired";
        }
        String string = this._b._d.toLowerCase();
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    public static /* synthetic */ Minecraft _a(xaxz xaxz2) {
        return xaxz2.mc;
    }

    public static /* synthetic */ int _b(xaxz xaxz2) {
        return xaxz2._f;
    }

    public static /* synthetic */ int _a(xaxz xaxz2, int n) {
        return xaxz2._a(n);
    }

    public static /* synthetic */ int _c(xaxz xaxz2) {
        return xaxz2._e;
    }

    public static /* synthetic */ McoServer _d(xaxz xaxz2) {
        return xaxz2._b;
    }

    public static /* synthetic */ int _b(xaxz xaxz2, int n) {
        xaxz2._g = n;
        return xaxz2._g;
    }

    public static /* synthetic */ int _e(xaxz xaxz2) {
        return xaxz2._g;
    }

    public static /* synthetic */ FontRenderer _f(xaxz xaxz2) {
        return xaxz2.fontRenderer;
    }
}

