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
import net.minecraft.util.ezey;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;

public class gqju
extends gqjz {
    public static int _a;
    public static Object _b;
    public gqjz _c;
    public mayb _d;
    public necw _e;
    public int _f = -1;
    public jiok _g;
    public jiok _h;
    public jiok _i;
    public boolean _j;
    public boolean _k;
    public boolean _l;
    public boolean _m;
    public String _n;
    public htsm _o;
    public dyir _p;
    public jzyx _q;
    public int _r;
    public boolean _s;
    public List _t = Collections.emptyList();

    public gqju(gqjz gqjz2) {
        this._c = gqjz2;
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        if (!this._s) {
            this._s = true;
            this._e = new necw(this.field_73882_e);
            this._e._a();
            this._p = new dyir();
            try {
                this._q = new jzyx(this._p);
                this._q.start();
            }
            catch (Exception exception) {
                this.field_73882_e._O()._b("Unable to start LAN server detection: " + exception.getMessage());
            }
            this._d = new mayb(this);
        } else {
            this._d.func_77207_a(this.field_73880_f, this.field_73881_g, 32, this.field_73881_g - 64);
        }
        this._a();
    }

    public void _a() {
        boolean bl;
        this._g = new jiok(7, this.field_73880_f / 2 - 154, this.field_73881_g - 28, 70, 20, wpcz._a("selectServer.edit"));
        this.field_73887_h.add(this._g);
        this._i = new jiok(2, this.field_73880_f / 2 - 74, this.field_73881_g - 28, 70, 20, wpcz._a("selectServer.delete"));
        this.field_73887_h.add(this._i);
        this._h = new jiok(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 100, 20, wpcz._a("selectServer.select"));
        this.field_73887_h.add(this._h);
        this.field_73887_h.add(new jiok(4, this.field_73880_f / 2 - 50, this.field_73881_g - 52, 100, 20, wpcz._a("selectServer.direct")));
        this.field_73887_h.add(new jiok(3, this.field_73880_f / 2 + 4 + 50, this.field_73881_g - 52, 100, 20, wpcz._a("selectServer.add")));
        this.field_73887_h.add(new jiok(8, this.field_73880_f / 2 + 4, this.field_73881_g - 28, 70, 20, wpcz._a("selectServer.refresh")));
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 + 4 + 76, this.field_73881_g - 28, 75, 20, wpcz._a("gui.cancel")));
        this._h.field_73742_g = bl = this._f >= 0 && this._f < this._d.func_77217_a();
        this._g.field_73742_g = bl;
        this._i.field_73742_g = bl;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ++this._r;
        if (this._p._a()) {
            this._t = this._p._c();
            this._p._b();
        }
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
        if (this._q != null) {
            this._q.interrupt();
            this._q = null;
        }
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 2) {
            String string = this._e._a((int)this._f)._a;
            if (string != null) {
                this._j = true;
                String string2 = wpcz._a("selectServer.deleteQuestion");
                String string3 = "'" + string + "' " + wpcz._a("selectServer.deleteWarning");
                String string4 = wpcz._a("selectServer.deleteButton");
                String string5 = wpcz._a("gui.cancel");
                lowa lowa2 = new lowa(this, string2, string3, string4, string5, this._f);
                this.field_73882_e._a(lowa2);
            }
        } else if (jiok2.field_73741_f == 1) {
            this._a(this._f);
        } else if (jiok2.field_73741_f == 4) {
            this._m = true;
            this._o = new htsm(wpcz._a("selectServer.defaultName"), "");
            this.field_73882_e._a(new mrzl(this, this._o));
        } else if (jiok2.field_73741_f == 3) {
            this._k = true;
            this._o = new htsm(wpcz._a("selectServer.defaultName"), "");
            this.field_73882_e._a(new rqjd(this, this._o));
        } else if (jiok2.field_73741_f == 7) {
            this._l = true;
            htsm htsm2 = this._e._a(this._f);
            this._o = new htsm(htsm2._a, htsm2._b);
            this._o._b(htsm2._b());
            this.field_73882_e._a(new rqjd(this, this._o));
        } else if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(this._c);
        } else if (jiok2.field_73741_f == 8) {
            this.field_73882_e._a(new gqju(this._c));
        } else {
            this._d.func_77219_a(jiok2);
        }
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (this._j) {
            this._j = false;
            if (bl) {
                this._e._b(n);
                this._e._b();
                this._f = -1;
            }
            this.field_73882_e._a(this);
        } else if (this._m) {
            this._m = false;
            if (bl) {
                this._a(this._o);
            } else {
                this.field_73882_e._a(this);
            }
        } else if (this._k) {
            this._k = false;
            if (bl) {
                this._e._a(this._o);
                this._e._b();
                this._f = -1;
            }
            this.field_73882_e._a(this);
        } else if (this._l) {
            this._l = false;
            if (bl) {
                htsm htsm2 = this._e._a(this._f);
                htsm2._a = this._o._a;
                htsm2._b = this._o._b;
                htsm2._b(this._o._b());
                this._e._b();
            }
            this.field_73882_e._a(this);
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        int n2 = this._f--;
        if (n == 59) {
            this.field_73882_e._M.field_80005_w = !this.field_73882_e._M.field_80005_w;
            this.field_73882_e._M.func_74303_b();
            return;
        }
        if (gqju.func_73877_p() && n == 200) {
            if (n2 > 0 && n2 < this._e._c()) {
                this._e._a(n2, n2 - 1);
                if (n2 < this._e._c() - 1) {
                    this._d.func_77208_b(-this._d.field_77229_d);
                }
            }
        } else if (gqju.func_73877_p() && n == 208) {
            if (n2 >= 0 & n2 < this._e._c() - 1) {
                this._e._a(n2, n2 + 1);
                ++this._f;
                if (n2 > 0) {
                    this._d.func_77208_b(this._d.field_77229_d);
                }
            }
        } else if (n == 28 || n == 156) {
            this.func_73875_a((jiok)this.field_73887_h.get(2));
        } else {
            super.func_73869_a(c, n);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this._n = null;
        this.func_73873_v_();
        this._d.func_77211_a(n, n2, f);
        this.func_73732_a(this.field_73886_k, wpcz._a("multiplayer.title"), this.field_73880_f / 2, 20, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
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
            this._a(new htsm(ohgi2._a(), ohgi2._b()));
        }
    }

    public void _a(htsm htsm2) {
        this.field_73882_e._a(new fnnc(this, this.field_73882_e, htsm2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void _b(htsm htsm2) {
        block25: {
            qnlr qnlr2 = qnlr._a(htsm2._b);
            Socket socket = null;
            FilterInputStream filterInputStream = null;
            FilterOutputStream filterOutputStream = null;
            try {
                socket = new Socket();
                socket.setSoTimeout(3000);
                socket.setTcpNoDelay(true);
                socket.setTrafficClass(18);
                socket.connect(new InetSocketAddress(qnlr2._a(), qnlr2._b()), 3000);
                filterInputStream = new DataInputStream(socket.getInputStream());
                filterOutputStream = new DataOutputStream(socket.getOutputStream());
                kmtn kmtn2 = new kmtn(78, qnlr2._a(), qnlr2._b());
                ((DataOutputStream)filterOutputStream).writeByte(kmtn2.func_73281_k());
                kmtn2.func_73273_a((DataOutput)((Object)filterOutputStream));
                if (filterInputStream.read() != 255) {
                    throw new IOException("Bad message");
                }
                String string = cezg.func_73282_a((DataInput)((Object)filterInputStream), 256);
                char[] cArray = string.toCharArray();
                for (int i = 0; i < cArray.length; ++i) {
                    if (cArray[i] == '\u00a7' || cArray[i] == '\u0000' || ezey._a.indexOf(cArray[i]) >= 0) continue;
                    cArray[i] = 63;
                }
                string = new String(cArray);
                if (string.startsWith("\u00a7") && string.length() > 1) {
                    String[] stringArray = string.substring(1).split("\u0000");
                    if (sajh._a(stringArray[0], 0) == 1) {
                        htsm2._d = stringArray[3];
                        htsm2._f = sajh._a(stringArray[1], htsm2._f);
                        htsm2._g = stringArray[2];
                        int n = sajh._a(stringArray[4], 0);
                        int n2 = sajh._a(stringArray[5], 0);
                        htsm2._c = n >= 0 && n2 >= 0 ? (Object)((Object)ezfc._h) + "" + n + "" + (Object)((Object)ezfc._i) + "/" + (Object)((Object)ezfc._h) + n2 : "" + (Object)((Object)ezfc._i) + "???";
                    } else {
                        htsm2._g = "???";
                        htsm2._d = "" + (Object)((Object)ezfc._i) + "???";
                        htsm2._f = 79;
                        htsm2._c = "" + (Object)((Object)ezfc._i) + "???";
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
                htsm2._d = (Object)((Object)ezfc._h) + string;
                htsm2._c = n >= 0 && n3 > 0 ? (Object)((Object)ezfc._h) + "" + n + "" + (Object)((Object)ezfc._i) + "/" + (Object)((Object)ezfc._h) + n3 : "" + (Object)((Object)ezfc._i) + "???";
                htsm2._g = "1.3";
                htsm2._f = 77;
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
        int n5 = this.field_73886_k._b(string);
        this.func_73733_a(n3 - 3, n4 - 3, n3 + n5 + 3, n4 + 8 + 3, -1073741824, -1073741824);
        this.field_73886_k._a(string, n3, n4, -1);
    }

    public static /* synthetic */ necw _a(gqju gqju2) {
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

    public static /* synthetic */ jiok _d(gqju gqju2) {
        return gqju2._h;
    }

    public static /* synthetic */ jiok _e(gqju gqju2) {
        return gqju2._g;
    }

    public static /* synthetic */ jiok _f(gqju gqju2) {
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

    public static /* synthetic */ void _c(htsm htsm2) {
        gqju._b(htsm2);
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

