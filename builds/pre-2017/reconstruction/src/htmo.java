/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenConfirmation;
import net.minecraft.client.gui.GuiScreenLongRunningTask;
import net.minecraft.client.gui.TaskOnlineConnect;
import net.minecraft.client.gui.mco.GuiScreenCreateOnlineWorld;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.GuiScreenConfirmationType;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class htmo
extends GuiScreen {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/widgets.png");
    public GuiScreen _b;
    public lowp _c;
    public static int _d;
    public static final Object _e;
    public long _f = -1L;
    public GuiButton _g;
    public GuiButton _h;
    public mrxl _i;
    public GuiButton _j;
    public String _k;
    public static ifqv _l;
    public boolean _m;
    public List _n = Lists.newArrayList();
    public volatile int _o = 0;
    public Long _p;
    public int _q;

    public htmo(GuiScreen guiScreen) {
        this._b = guiScreen;
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        _l._a(this.mc._P());
        if (!this._m) {
            this._m = true;
            this._c = new lowp(this);
        } else {
            this._c._a(this.width, this.height, 32, this.height - 64);
        }
        this._a();
    }

    public void _a() {
        this._j = new GuiButton(1, this.width / 2 - 154, this.height - 52, 100, 20, wpcz._a("mco.selectServer.play"));
        this.buttonList.add(this._j);
        this._h = new GuiButton(2, this.width / 2 - 48, this.height - 52, 100, 20, wpcz._a("mco.selectServer.create"));
        this.buttonList.add(this._h);
        this._g = new GuiButton(3, this.width / 2 + 58, this.height - 52, 100, 20, wpcz._a("mco.selectServer.configure"));
        this.buttonList.add(this._g);
        this._i = new mrxl(4, this.width / 2 - 154, this.height - 28, 154, 20, wpcz._a("mco.selectServer.moreinfo"));
        this.buttonList.add(this._i);
        this.buttonList.add(new GuiButton(0, this.width / 2 + 6, this.height - 28, 153, 20, wpcz._a("gui.cancel")));
        McoServer mcoServer = this._a(this._f);
        this._j.enabled = mcoServer != null && mcoServer._d.equals("OPEN") && !mcoServer._h;
        boolean bl = this._h.enabled = this._o > 0;
        if (mcoServer != null && !mcoServer._e.equals(this.mc._P()._a())) {
            this._g.displayString = wpcz._a("mco.selectServer.leave");
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this._q;
        if (_l._a()) {
            List list2 = _l._c();
            block0: for (McoServer mcoServer : list2) {
                for (McoServer mcoServer2 : this._n) {
                    if (mcoServer._a != mcoServer2._a) continue;
                    mcoServer._a(mcoServer2);
                    if (this._p == null || this._p != mcoServer._a) continue block0;
                    this._p = null;
                    mcoServer._n = false;
                    continue block0;
                }
            }
            this._o = _l._e();
            this._n = list2;
            _l._b();
        }
        this._h.enabled = this._o > 0;
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
        if (guiButton.id == 1) {
            this._e(this._f);
        } else if (guiButton.id == 3) {
            this._b();
        } else if (guiButton.id == 0) {
            _l._f();
            this.mc._a(this._b);
        } else if (guiButton.id == 2) {
            _l._f();
            this.mc._a(new GuiScreenCreateOnlineWorld(this));
        } else if (guiButton.id == 4) {
            this._i._a("http://realms.minecraft.net/");
        } else {
            this._c._a(guiButton);
        }
    }

    public void _b() {
        McoServer mcoServer = this._a(this._f);
        if (mcoServer != null) {
            if (this.mc._P()._a().equals(mcoServer._e)) {
                McoServer mcoServer2 = this._d(mcoServer._a);
                if (mcoServer2 != null) {
                    _l._f();
                    this.mc._a(new xaxz(this, mcoServer2));
                }
            } else {
                String string = wpcz._a("mco.configure.world.leave.question.line1");
                String string2 = wpcz._a("mco.configure.world.leave.question.line2");
                this.mc._a(new GuiScreenConfirmation(this, GuiScreenConfirmationType._b, string, string2, 3));
            }
        }
    }

    public McoServer _a(long l) {
        for (McoServer mcoServer : this._n) {
            if (mcoServer._a != l) continue;
            return mcoServer;
        }
        return null;
    }

    public int _b(long l) {
        for (int i = 0; i < this._n.size(); ++i) {
            if (((McoServer)this._n.get((int)i))._a != l) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (n == 3 && bl) {
            new dyek(this).start();
        }
        this.mc._a(this);
    }

    public void _c() {
        int n = this._b(this._f);
        if (this._n.size() - 1 == n) {
            --n;
        }
        if (this._n.size() == 0) {
            n = -1;
        }
        if (n >= 0 && n < this._n.size()) {
            this._f = ((McoServer)this._n.get((int)n))._a;
        }
    }

    public void _c(long l) {
        this._f = -1L;
        this._p = l;
    }

    public McoServer _d(long l) {
        rqmi rqmi2 = new rqmi(this.mc._P());
        try {
            return rqmi2._a(l);
        }
        catch (ExceptionMcoService exceptionMcoService) {
            this.mc._O()._c(exceptionMcoService.toString());
        }
        catch (IOException iOException) {
            this.mc._O()._b("Realms: could not parse response");
        }
        return null;
    }

    @Override
    public void keyTyped(char c, int n) {
        if (n == 59) {
            this.mc._M.hideServerAddress = !this.mc._M.hideServerAddress;
            this.mc._M.saveOptions();
            return;
        }
        if (n == 28 || n == 156) {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        } else {
            super.keyTyped(c, n);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this._k = null;
        this.drawDefaultBackground();
        this._c._a(n, n2, f);
        this.drawCenteredString(this.fontRenderer, wpcz._a("mco.title"), this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(n, n2, f);
        if (this._k != null) {
            this._a(this._k, n, n2);
        }
        this._a(n, n2);
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (this._b(n, n2) && _l._d() != 0) {
            nvce nvce2 = new nvce(this);
            this.mc._a(nvce2);
        }
    }

    public void _a(int n, int n2) {
        int n3;
        int n4;
        int n5 = _l._d();
        boolean bl = this._b(n, n2);
        this.mc._R()._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        this.drawTexturedModalRect(this.width / 2 + 58, 15, bl ? 166 : 182, 22, 16, 16);
        GL11.glPopMatrix();
        if (n5 != 0) {
            n4 = 198 + (Math.min(n5, 6) - 1) * 8;
            n3 = (int)(Math.max(0.0f, Math.max(sajh._a((float)(10 + this._q) * 0.57f), sajh._b((float)this._q * 0.35f))) * -6.0f);
            this.mc._R()._a(_a);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            this.drawTexturedModalRect(this.width / 2 + 58 + 4, 19 + n3, n4, 22, 8, 8);
            GL11.glPopMatrix();
        }
        if (bl && n5 != 0) {
            n4 = n + 12;
            n3 = n2 - 12;
            String string = wpcz._a("mco.invites.pending");
            int n6 = this.fontRenderer._b(string);
            this.drawGradientRect(n4 - 3, n3 - 3, n4 + n6 + 3, n3 + 8 + 3, -1073741824, -1073741824);
            this.fontRenderer._a(string, n4, n3, -1);
        }
    }

    public boolean _b(int n, int n2) {
        int n3 = this.width / 2 + 56;
        int n4 = this.width / 2 + 78;
        int n5 = 13;
        int n6 = 27;
        return n3 <= n && n <= n4 && n5 <= n2 && n2 <= n6;
    }

    public void _e(long l) {
        McoServer mcoServer = this._a(l);
        if (mcoServer != null) {
            _l._f();
            GuiScreenLongRunningTask guiScreenLongRunningTask = new GuiScreenLongRunningTask(this.mc, this, new TaskOnlineConnect(this, mcoServer));
            guiScreenLongRunningTask._a();
            this.mc._a(guiScreenLongRunningTask);
        }
    }

    public void _a(int n, int n2, int n3, int n4) {
        this.mc._R()._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.drawTexturedModalRect(n * 2, n2 * 2, 191, 0, 16, 15);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 9) {
            this._k = wpcz._a("mco.selectServer.expired");
        }
    }

    public void _a(int n, int n2, int n3, int n4, int n5) {
        if (this._q % 20 < 10) {
            this.mc._R()._a(_a);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            this.drawTexturedModalRect(n * 2, n2 * 2, 207, 0, 16, 15);
            GL11.glPopMatrix();
        }
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 9) {
            this._k = n5 == 0 ? wpcz._a("mco.selectServer.expires.soon") : (n5 == 1 ? wpcz._a("mco.selectServer.expires.day") : wpcz._a("mco.selectServer.expires.days", n5));
        }
    }

    public void _b(int n, int n2, int n3, int n4) {
        this.mc._R()._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.drawTexturedModalRect(n * 2, n2 * 2, 207, 0, 16, 15);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 9) {
            this._k = wpcz._a("mco.selectServer.open");
        }
    }

    public void _c(int n, int n2, int n3, int n4) {
        this.mc._R()._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.drawTexturedModalRect(n * 2, n2 * 2, 223, 0, 16, 15);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 9) {
            this._k = wpcz._a("mco.selectServer.closed");
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(McoServer mcoServer) {
        block26: {
            if (mcoServer._m.equals("")) {
                mcoServer._m = (Object)((Object)EnumChatFormatting._h) + "" + 0;
            }
            mcoServer._l = 78;
            ServerAddress serverAddress = ServerAddress._a(mcoServer._g);
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
                ((DataOutputStream)filterOutputStream).write(254);
                ((DataOutputStream)filterOutputStream).write(1);
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
                        mcoServer._l = sajh._a(stringArray[1], mcoServer._l);
                        int n = sajh._a(stringArray[4], 0);
                        int n2 = sajh._a(stringArray[5], 0);
                        mcoServer._m = n >= 0 && n2 >= 0 ? (Object)((Object)EnumChatFormatting._h) + "" + n : "" + (Object)((Object)EnumChatFormatting._i) + "???";
                    } else {
                        mcoServer._l = 79;
                        mcoServer._m = "" + (Object)((Object)EnumChatFormatting._i) + "???";
                    }
                    break block26;
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
                mcoServer._c = (Object)((Object)EnumChatFormatting._h) + string;
                mcoServer._m = n >= 0 && n3 > 0 ? (Object)((Object)EnumChatFormatting._h) + "" + n : "" + (Object)((Object)EnumChatFormatting._i) + "???";
                mcoServer._l = 77;
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

    public static /* synthetic */ long _a(htmo htmo2) {
        return htmo2._f;
    }

    public static /* synthetic */ McoServer _a(htmo htmo2, long l) {
        return htmo2._a(l);
    }

    public static /* synthetic */ Minecraft _b(htmo htmo2) {
        return htmo2.mc;
    }

    public static /* synthetic */ ifqv _d() {
        return _l;
    }

    public static /* synthetic */ List _c(htmo htmo2) {
        return htmo2._n;
    }

    public static /* synthetic */ void _d(htmo htmo2) {
        htmo2._c();
    }

    public static /* synthetic */ Minecraft _e(htmo htmo2) {
        return htmo2.mc;
    }

    public static /* synthetic */ Minecraft _f(htmo htmo2) {
        return htmo2.mc;
    }

    public static /* synthetic */ long _b(htmo htmo2, long l) {
        htmo2._f = l;
        return htmo2._f;
    }

    public static /* synthetic */ Minecraft _g(htmo htmo2) {
        return htmo2.mc;
    }

    public static /* synthetic */ GuiButton _h(htmo htmo2) {
        return htmo2._g;
    }

    public static /* synthetic */ GuiButton _i(htmo htmo2) {
        return htmo2._j;
    }

    public static /* synthetic */ void _c(htmo htmo2, long l) {
        htmo2._e(l);
    }

    public static /* synthetic */ int _d(htmo htmo2, long l) {
        return htmo2._b(l);
    }

    public static /* synthetic */ Minecraft _j(htmo htmo2) {
        return htmo2.mc;
    }

    public static /* synthetic */ FontRenderer _k(htmo htmo2) {
        return htmo2.fontRenderer;
    }

    public static /* synthetic */ void _a(htmo htmo2, int n, int n2, int n3, int n4) {
        htmo2._a(n, n2, n3, n4);
    }

    public static /* synthetic */ void _b(htmo htmo2, int n, int n2, int n3, int n4) {
        htmo2._c(n, n2, n3, n4);
    }

    public static /* synthetic */ Minecraft _l(htmo htmo2) {
        return htmo2.mc;
    }

    public static /* synthetic */ void _a(htmo htmo2, int n, int n2, int n3, int n4, int n5) {
        htmo2._a(n, n2, n3, n4, n5);
    }

    public static /* synthetic */ void _c(htmo htmo2, int n, int n2, int n3, int n4) {
        htmo2._b(n, n2, n3, n4);
    }

    public static /* synthetic */ FontRenderer _m(htmo htmo2) {
        return htmo2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _n(htmo htmo2) {
        return htmo2.fontRenderer;
    }

    public static /* synthetic */ Object _e() {
        return _e;
    }

    public static /* synthetic */ int _f() {
        return _d;
    }

    public static /* synthetic */ int _g() {
        return _d++;
    }

    public static /* synthetic */ void _a(htmo htmo2, McoServer mcoServer) {
        htmo2._a(mcoServer);
    }

    public static /* synthetic */ int _h() {
        return _d--;
    }

    public static /* synthetic */ FontRenderer _o(htmo htmo2) {
        return htmo2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _p(htmo htmo2) {
        return htmo2.fontRenderer;
    }

    public static /* synthetic */ Minecraft _q(htmo htmo2) {
        return htmo2.mc;
    }

    static {
        _e = new Object();
        _l = new ifqv();
    }
}

