/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenAddServer;
import net.minecraft.client.gui.GuiSlotServer;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet254ServerPing;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;

public class gqju
extends GuiScreen {
    public static int _a;
    public static Object _b;
    public GuiScreen _c;
    public GuiSlotServer _d;
    public ServerList _e;
    public int _f = -1;
    public GuiButton _g;
    public GuiButton _h;
    public GuiButton _i;
    public boolean _j;
    public boolean _k;
    public boolean _l;
    public boolean _m;
    public String _n;
    public ServerData _o;
    public dyir _p;
    public jzyx _q;
    public int _r;
    public boolean _s;
    public List _t = Collections.emptyList();

    public gqju(GuiScreen guiScreen) {
        this._c = guiScreen;
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        if (!this._s) {
            this._s = true;
            this._e = new ServerList(this.mc);
            this._e._a();
            this._p = new dyir();
            try {
                this._q = new jzyx(this._p);
                this._q.start();
            }
            catch (Exception exception) {
                this.mc._O()._b("Unable to start LAN server detection: " + exception.getMessage());
            }
            this._d = new GuiSlotServer(this);
        } else {
            this._d.func_77207_a(this.width, this.height, 32, this.height - 64);
        }
        this._a();
    }

    public void _a() {
        boolean bl;
        this._g = new GuiButton(7, this.width / 2 - 154, this.height - 28, 70, 20, wpcz._a("selectServer.edit"));
        this.buttonList.add(this._g);
        this._i = new GuiButton(2, this.width / 2 - 74, this.height - 28, 70, 20, wpcz._a("selectServer.delete"));
        this.buttonList.add(this._i);
        this._h = new GuiButton(1, this.width / 2 - 154, this.height - 52, 100, 20, wpcz._a("selectServer.select"));
        this.buttonList.add(this._h);
        this.buttonList.add(new GuiButton(4, this.width / 2 - 50, this.height - 52, 100, 20, wpcz._a("selectServer.direct")));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 4 + 50, this.height - 52, 100, 20, wpcz._a("selectServer.add")));
        this.buttonList.add(new GuiButton(8, this.width / 2 + 4, this.height - 28, 70, 20, wpcz._a("selectServer.refresh")));
        this.buttonList.add(new GuiButton(0, this.width / 2 + 4 + 76, this.height - 28, 75, 20, wpcz._a("gui.cancel")));
        this._h.enabled = bl = this._f >= 0 && this._f < this._d.getSize();
        this._g.enabled = bl;
        this._i.enabled = bl;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this._r;
        if (this._p._a()) {
            this._t = this._p._c();
            this._p._b();
        }
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        if (this._q != null) {
            this._q.interrupt();
            this._q = null;
        }
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 2) {
            String string = this._e._a((int)this._f)._a;
            if (string != null) {
                this._j = true;
                String string2 = wpcz._a("selectServer.deleteQuestion");
                String string3 = "'" + string + "' " + wpcz._a("selectServer.deleteWarning");
                String string4 = wpcz._a("selectServer.deleteButton");
                String string5 = wpcz._a("gui.cancel");
                GuiYesNo guiYesNo = new GuiYesNo(this, string2, string3, string4, string5, this._f);
                this.mc._a(guiYesNo);
            }
        } else if (guiButton.id == 1) {
            this._a(this._f);
        } else if (guiButton.id == 4) {
            this._m = true;
            this._o = new ServerData(wpcz._a("selectServer.defaultName"), "");
            this.mc._a(new mrzl(this, this._o));
        } else if (guiButton.id == 3) {
            this._k = true;
            this._o = new ServerData(wpcz._a("selectServer.defaultName"), "");
            this.mc._a(new GuiScreenAddServer(this, this._o));
        } else if (guiButton.id == 7) {
            this._l = true;
            ServerData serverData = this._e._a(this._f);
            this._o = new ServerData(serverData._a, serverData._b);
            this._o._b(serverData._b());
            this.mc._a(new GuiScreenAddServer(this, this._o));
        } else if (guiButton.id == 0) {
            this.mc._a(this._c);
        } else if (guiButton.id == 8) {
            this.mc._a(new gqju(this._c));
        } else {
            this._d.actionPerformed(guiButton);
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (this._j) {
            this._j = false;
            if (bl) {
                this._e._b(n);
                this._e._b();
                this._f = -1;
            }
            this.mc._a(this);
        } else if (this._m) {
            this._m = false;
            if (bl) {
                this._a(this._o);
            } else {
                this.mc._a(this);
            }
        } else if (this._k) {
            this._k = false;
            if (bl) {
                this._e._a(this._o);
                this._e._b();
                this._f = -1;
            }
            this.mc._a(this);
        } else if (this._l) {
            this._l = false;
            if (bl) {
                ServerData serverData = this._e._a(this._f);
                serverData._a = this._o._a;
                serverData._b = this._o._b;
                serverData._b(this._o._b());
                this._e._b();
            }
            this.mc._a(this);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        int n2 = this._f--;
        if (n == 59) {
            this.mc._M.hideServerAddress = !this.mc._M.hideServerAddress;
            this.mc._M.saveOptions();
            return;
        }
        if (gqju.isShiftKeyDown() && n == 200) {
            if (n2 > 0 && n2 < this._e._c()) {
                this._e._a(n2, n2 - 1);
                if (n2 < this._e._c() - 1) {
                    this._d.func_77208_b(-this._d.slotHeight);
                }
            }
        } else if (gqju.isShiftKeyDown() && n == 208) {
            if (n2 >= 0 & n2 < this._e._c() - 1) {
                this._e._a(n2, n2 + 1);
                ++this._f;
                if (n2 > 0) {
                    this._d.func_77208_b(this._d.slotHeight);
                }
            }
        } else if (n == 28 || n == 156) {
            this.actionPerformed((GuiButton)this.buttonList.get(2));
        } else {
            super.keyTyped(c, n);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this._n = null;
        this.drawDefaultBackground();
        this._d.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRenderer, wpcz._a("multiplayer.title"), this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(n, n2, f);
        if (this._n != null) {
            this._a(this._n, n, n2);
        }
    }

    public void _a(int n) {
        if (n < this._e._c()) {
            this._a(this._e._a(n));
            return;
        }
        if ((n -= this._e._c()) < this._t.size()) {
            ohgi ohgi2 = (ohgi)this._t.get(n);
            this._a(new ServerData(ohgi2._a(), ohgi2._b()));
        }
    }

    public void _a(ServerData serverData) {
        this.mc._a(new fnnc(this, this.mc, serverData));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void _b(ServerData serverData) {
        block25: {
            ServerAddress serverAddress = ServerAddress._a(serverData._b);
            Socket socket = null;
            FilterInputStream filterInputStream = null;
            FilterOutputStream filterOutputStream = null;
            try {
                socket = new Socket();
                socket.setSoTimeout(3000);
                socket.setTcpNoDelay(true);
                socket.setTrafficClass(18);
                socket.connect(new InetSocketAddress(serverAddress._a(), serverAddress._b()), 3000);
                filterInputStream = new DataInputStream(socket.getInputStream());
                filterOutputStream = new DataOutputStream(socket.getOutputStream());
                Packet254ServerPing packet254ServerPing = new Packet254ServerPing(78, serverAddress._a(), serverAddress._b());
                ((DataOutputStream)filterOutputStream).writeByte(packet254ServerPing.getPacketId());
                packet254ServerPing.writePacketData((DataOutput)((Object)filterOutputStream));
                if (filterInputStream.read() != 255) {
                    throw new IOException("Bad message");
                }
                String string = Packet.readString((DataInput)((Object)filterInputStream), 256);
                char[] cArray = string.toCharArray();
                for (int i = 0; i < cArray.length; ++i) {
                    if (cArray[i] == '\u00a7' || cArray[i] == '\u0000' || ChatAllowedCharacters._a.indexOf(cArray[i]) >= 0) continue;
                    cArray[i] = 63;
                }
                string = new String(cArray);
                if (string.startsWith("\u00a7") && string.length() > 1) {
                    String[] stringArray = string.substring(1).split("\u0000");
                    if (sajh._a(stringArray[0], 0) == 1) {
                        serverData._d = stringArray[3];
                        serverData._f = sajh._a(stringArray[1], serverData._f);
                        serverData._g = stringArray[2];
                        int n = sajh._a(stringArray[4], 0);
                        int n2 = sajh._a(stringArray[5], 0);
                        serverData._c = n >= 0 && n2 >= 0 ? (Object)((Object)EnumChatFormatting._h) + "" + n + "" + (Object)((Object)EnumChatFormatting._i) + "/" + (Object)((Object)EnumChatFormatting._h) + n2 : "" + (Object)((Object)EnumChatFormatting._i) + "???";
                    } else {
                        serverData._g = "???";
                        serverData._d = "" + (Object)((Object)EnumChatFormatting._i) + "???";
                        serverData._f = 79;
                        serverData._c = "" + (Object)((Object)EnumChatFormatting._i) + "???";
                    }
                    break block25;
                }
                String[] stringArray = string.split("\u00a7");
                string = stringArray[0];
                int n = -1;
                int n3 = -1;
                try {
                    n = Integer.parseInt(stringArray[1]);
                    n3 = Integer.parseInt(stringArray[2]);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                serverData._d = (Object)((Object)EnumChatFormatting._h) + string;
                serverData._c = n >= 0 && n3 > 0 ? (Object)((Object)EnumChatFormatting._h) + "" + n + "" + (Object)((Object)EnumChatFormatting._i) + "/" + (Object)((Object)EnumChatFormatting._h) + n3 : "" + (Object)((Object)EnumChatFormatting._i) + "???";
                serverData._g = "1.3";
                serverData._f = 77;
            }
            finally {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                }
                catch (Throwable throwable) {}
                try {
                    if (filterOutputStream != null) {
                        filterOutputStream.close();
                    }
                }
                catch (Throwable throwable) {}
                try {
                    if (socket != null) {
                        socket.close();
                    }
                }
                catch (Throwable throwable) {}
            }
        }
    }

    public void _a(String string, int n, int n2) {
        if (string == null) {
            return;
        }
        int n3 = n + 12;
        int n4 = n2 - 12;
        int n5 = this.fontRenderer._b(string);
        this.drawGradientRect(n3 - 3, n4 - 3, n3 + n5 + 3, n4 + 8 + 3, -1073741824, -1073741824);
        this.fontRenderer._a(string, n3, n4, -1);
    }

    public static /* synthetic */ ServerList _a(gqju gqju2) {
        return gqju2._e;
    }

    public static /* synthetic */ List _b(gqju gqju2) {
        return gqju2._t;
    }

    public static /* synthetic */ int _c(gqju gqju2) {
        return gqju2._f;
    }

    public static /* synthetic */ int _a(gqju gqju2, int n) {
        gqju2._f = n;
        return gqju2._f;
    }

    public static /* synthetic */ GuiButton _d(gqju gqju2) {
        return gqju2._h;
    }

    public static /* synthetic */ GuiButton _e(gqju gqju2) {
        return gqju2._g;
    }

    public static /* synthetic */ GuiButton _f(gqju gqju2) {
        return gqju2._i;
    }

    public static /* synthetic */ void _b(gqju gqju2, int n) {
        gqju2._a(n);
    }

    public static /* synthetic */ int _g(gqju gqju2) {
        return gqju2._r;
    }

    public static /* synthetic */ Object _b() {
        return _b;
    }

    public static /* synthetic */ int _c() {
        return _a;
    }

    public static /* synthetic */ int _d() {
        return _a++;
    }

    public static /* synthetic */ void _c(ServerData serverData) {
        gqju._b(serverData);
    }

    public static /* synthetic */ int _e() {
        return _a--;
    }

    public static /* synthetic */ String _a(gqju gqju2, String string) {
        gqju2._n = string;
        return gqju2._n;
    }

    static {
        _b = new Object();
    }
}

