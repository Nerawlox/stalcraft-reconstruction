/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.bundle.BundleMod;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;

@ezey(_a={eidj.CLIENT})
public class ivbz
extends GuiScreen {
    private Minecraft _c = Minecraft._E();
    pzvp _a;
    String _b;
    private final GuiScreen _d;
    private boolean _e;
    private static String _f;
    private static int _g;
    private String _h;
    private String _i;

    public ivbz(GuiScreen guiScreen, boolean bl) {
        this._d = guiScreen;
        this._e = bl;
        this._c._a((pkix)null);
        Logger.info("Connecting to backend " + _f + ", " + _g, new Object[0]);
        new kjui().start();
    }

    @Override
    public void updateScreen() {
        if (this._a != null) {
            this._a._a();
        }
        this._c();
    }

    @Override
    protected void keyTyped(char c, int n) {
    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, wpcz._a("gui.cancel")));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            if (this._a != null) {
                this._a._a._a("User canceled connection");
            }
            this._c._a(this._d);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        String string = this._a == null ? "\u041f\u043e\u0434\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0435 \u043a \u0441\u0435\u0440\u0432\u0435\u0440\u0443 \u043b\u043e\u043a\u0430\u0446\u0438\u0439..." : (this._b == null ? "\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430 \u0434\u0430\u043d\u043d\u044b\u0445 \u0438\u0433\u0440\u043e\u043a\u0430..." : this._b);
        this.drawCenteredString(this.fontRenderer, string, this.width / 2, this.height / 2 - 50, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    private synchronized void _a(String string, String string2) {
        this._h = string;
        this._i = string2;
    }

    private synchronized void _c() {
        if (this._h != null) {
            this._c._a(new GuiDisconnected(this._d, "connect.failed", this._h + " (" + this._i + ")", new Object[0]));
        }
    }

    static {
        _g = 25565;
        String string = BundleMod._c;
        String[] stringArray = string.split(":");
        _f = stringArray[0];
        if (stringArray.length > 1) {
            try {
                _g = Integer.parseInt(stringArray[1]);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
    }

    private class kjui
    extends Thread {
        private kjui() {
        }

        @Override
        public void run() {
            try {
                pzvp pzvp2 = new pzvp(ivbz.this, _f, _g);
                Logger.info("Requesting frontend server address", new Object[0]);
                ivbz.this._a = pzvp2;
                String string = ivbz.this._c._P()._b();
                if (string == null) {
                    string = "nope";
                }
                String string2 = eivd._b();
                pzvp2._a(new mqbj(zwat.getProtocolVersion(), ivbz.this._c._P()._a(), string, string2, eivd._a, ivbz.this._e));
            }
            catch (UnknownHostException unknownHostException) {
                ivbz.this._a("Unknown backend host", unknownHostException.getMessage());
            }
            catch (ConnectException connectException) {
                ivbz.this._a("Connect exception", connectException.getMessage());
            }
            catch (SocketTimeoutException socketTimeoutException) {
                ivbz.this._a("Timeout", socketTimeoutException.getMessage());
            }
            catch (Exception exception) {
                exception.printStackTrace();
                ivbz.this._a("Unknown error", exception.getMessage());
            }
        }
    }
}

