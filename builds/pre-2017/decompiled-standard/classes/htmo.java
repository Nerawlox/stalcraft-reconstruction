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
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezey;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class htmo
extends gqjz {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/widgets.png");
    public gqjz _b;
    public lowp _c;
    public static int _d;
    public static final Object _e;
    public long _f = -1L;
    public jiok _g;
    public jiok _h;
    public mrxl _i;
    public jiok _j;
    public String _k;
    public static ifqv _l;
    public boolean _m;
    public List _n = Lists.newArrayList();
    public volatile int _o = 0;
    public Long _p;
    public int _q;

    public htmo(gqjz gqjz2) {
        this._b = gqjz2;
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        _l._a(this.field_73882_e._P());
        if (!this._m) {
            this._m = true;
            this._c = new lowp(this);
        } else {
            this._c._a(this.field_73880_f, this.field_73881_g, 32, this.field_73881_g - 64);
        }
        this._a();
    }

    public void _a() {
        this._j = new jiok(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 100, 20, wpcz._a("mco.selectServer.play"));
        this.field_73887_h.add(this._j);
        this._h = new jiok(2, this.field_73880_f / 2 - 48, this.field_73881_g - 52, 100, 20, wpcz._a("mco.selectServer.create"));
        this.field_73887_h.add(this._h);
        this._g = new jiok(3, this.field_73880_f / 2 + 58, this.field_73881_g - 52, 100, 20, wpcz._a("mco.selectServer.configure"));
        this.field_73887_h.add(this._g);
        this._i = new mrxl(4, this.field_73880_f / 2 - 154, this.field_73881_g - 28, 154, 20, wpcz._a("mco.selectServer.moreinfo"));
        this.field_73887_h.add(this._i);
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 + 6, this.field_73881_g - 28, 153, 20, wpcz._a("gui.cancel")));
        rqmh rqmh2 = this._a(this._f);
        this._j.field_73742_g = rqmh2 != null && rqmh2._d.equals("OPEN") && !rqmh2._h;
        boolean bl = this._h.field_73742_g = this._o > 0;
        if (rqmh2 != null && !rqmh2._e.equals(this.field_73882_e._P()._a())) {
            this._g.field_73744_e = wpcz._a("mco.selectServer.leave");
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ++this._q;
        if (_l._a()) {
            List list2 = _l._c();
            block0: for (rqmh rqmh2 : list2) {
                for (rqmh rqmh3 : this._n) {
                    if (rqmh2._a != rqmh3._a) continue;
                    rqmh2._a(rqmh3);
                    if (this._p == null || this._p != rqmh2._a) continue block0;
                    this._p = null;
                    rqmh2._n = false;
                    continue block0;
                }
            }
            this._o = _l._e();
            this._n = list2;
            _l._b();
        }
        this._h.field_73742_g = this._o > 0;
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 1) {
            this._e(this._f);
        } else if (jiok2.field_73741_f == 3) {
            this._b();
        } else if (jiok2.field_73741_f == 0) {
            _l._f();
            this.field_73882_e._a(this._b);
        } else if (jiok2.field_73741_f == 2) {
            _l._f();
            this.field_73882_e._a(new bsao(this));
        } else if (jiok2.field_73741_f == 4) {
            this._i._a("http://realms.minecraft.net/");
        } else {
            this._c._a(jiok2);
        }
    }

    public void _b() {
        rqmh rqmh2 = this._a(this._f);
        if (rqmh2 != null) {
            if (this.field_73882_e._P()._a().equals(rqmh2._e)) {
                rqmh rqmh3 = this._d(rqmh2._a);
                if (rqmh3 != null) {
                    _l._f();
                    this.field_73882_e._a(new xaxz(this, rqmh3));
                }
            } else {
                String string = wpcz._a("mco.configure.world.leave.question.line1");
                String string2 = wpcz._a("mco.configure.world.leave.question.line2");
                this.field_73882_e._a(new jiqw(this, cvbr._b, string, string2, 3));
            }
        }
    }

    public rqmh _a(long l) {
        for (rqmh rqmh2 : this._n) {
            if (rqmh2._a != l) continue;
            return rqmh2;
        }
        return null;
    }

    public int _b(long l) {
        for (int i = 0; i < this._n.size(); ++i) {
            if (((rqmh)this._n.get((int)i))._a != l) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (n == 3 && bl) {
            new dyek(this).start();
        }
        this.field_73882_e._a(this);
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
            this._f = ((rqmh)this._n.get((int)n))._a;
        }
    }

    public void _c(long l) {
        this._f = -1L;
        this._p = l;
    }

    public rqmh _d(long l) {
        rqmi rqmi2 = new rqmi(this.field_73882_e._P());
        try {
            return rqmi2._a(l);
        }
        catch (twsl twsl2) {
            this.field_73882_e._O()._c(twsl2.toString());
        }
        catch (IOException iOException) {
            this.field_73882_e._O()._b("Realms: could not parse response");
        }
        return null;
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (n == 59) {
            this.field_73882_e._M.field_80005_w = !this.field_73882_e._M.field_80005_w;
            this.field_73882_e._M.func_74303_b();
            return;
        }
        if (n == 28 || n == 156) {
            this.func_73875_a((jiok)this.field_73887_h.get(0));
        } else {
            super.func_73869_a(c, n);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this._k = null;
        this.func_73873_v_();
        this._c._a(n, n2, f);
        this.func_73732_a(this.field_73886_k, wpcz._a("mco.title"), this.field_73880_f / 2, 20, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
        if (this._k != null) {
            this._a(this._k, n, n2);
        }
        this._a(n, n2);
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        if (this._b(n, n2) && _l._d() != 0) {
            nvce nvce2 = new nvce(this);
            this.field_73882_e._a(nvce2);
        }
    }

    public void _a(int n, int n2) {
        int n3;
        int n4;
        int n5 = _l._d();
        boolean bl = this._b(n, n2);
        this.field_73882_e._R()._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        this.func_73729_b(this.field_73880_f / 2 + 58, 15, bl ? 166 : 182, 22, 16, 16);
        GL11.glPopMatrix();
        if (n5 != 0) {
            n4 = 198 + (Math.min(n5, 6) - 1) * 8;
            n3 = (int)(Math.max(0.0f, Math.max(sajh._a((float)(10 + this._q) * 0.57f), sajh._b((float)this._q * 0.35f))) * -6.0f);
            this.field_73882_e._R()._a(_a);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            this.func_73729_b(this.field_73880_f / 2 + 58 + 4, 19 + n3, n4, 22, 8, 8);
            GL11.glPopMatrix();
        }
        if (bl && n5 != 0) {
            n4 = n + 12;
            n3 = n2 - 12;
            String string = wpcz._a("mco.invites.pending");
            int n6 = this.field_73886_k._b(string);
            this.func_73733_a(n4 - 3, n3 - 3, n4 + n6 + 3, n3 + 8 + 3, -1073741824, -1073741824);
            this.field_73886_k._a(string, n4, n3, -1);
        }
    }

    public boolean _b(int n, int n2) {
        int n3 = this.field_73880_f / 2 + 56;
        int n4 = this.field_73880_f / 2 + 78;
        int n5 = 13;
        int n6 = 27;
        return n3 <= n && n <= n4 && n5 <= n2 && n2 <= n6;
    }

    public void _e(long l) {
        rqmh rqmh2 = this._a(l);
        if (rqmh2 != null) {
            _l._f();
            kluc kluc2 = new kluc(this.field_73882_e, this, new gqmb(this, rqmh2));
            kluc2._a();
            this.field_73882_e._a(kluc2);
        }
    }

    public void _a(int n, int n2, int n3, int n4) {
        this.field_73882_e._R()._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.func_73729_b(n * 2, n2 * 2, 191, 0, 16, 15);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 9) {
            this._k = wpcz._a("mco.selectServer.expired");
        }
    }

    public void _a(int n, int n2, int n3, int n4, int n5) {
        if (this._q % 20 < 10) {
            this.field_73882_e._R()._a(_a);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            this.func_73729_b(n * 2, n2 * 2, 207, 0, 16, 15);
            GL11.glPopMatrix();
        }
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 9) {
            this._k = n5 == 0 ? wpcz._a("mco.selectServer.expires.soon") : (n5 == 1 ? wpcz._a("mco.selectServer.expires.day") : wpcz._a("mco.selectServer.expires.days", n5));
        }
    }

    public void _b(int n, int n2, int n3, int n4) {
        this.field_73882_e._R()._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.func_73729_b(n * 2, n2 * 2, 207, 0, 16, 15);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 9) {
            this._k = wpcz._a("mco.selectServer.open");
        }
    }

    public void _c(int n, int n2, int n3, int n4) {
        this.field_73882_e._R()._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.func_73729_b(n * 2, n2 * 2, 223, 0, 16, 15);
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
        int n5 = this.field_73886_k._b(string);
        this.func_73733_a(n3 - 3, n4 - 3, n3 + n5 + 3, n4 + 8 + 3, -1073741824, -1073741824);
        this.field_73886_k._a(string, n3, n4, -1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(rqmh rqmh2) {
        block26: {
            if (rqmh2._m.equals("")) {
                rqmh2._m = (Object)((Object)ezfc._h) + "" + 0;
            }
            rqmh2._l = 78;
            qnlr qnlr2 = qnlr._a(rqmh2._g);
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
                ((DataOutputStream)filterOutputStream).write(254);
                ((DataOutputStream)filterOutputStream).write(1);
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
                        rqmh2._l = sajh._a(stringArray[1], rqmh2._l);
                        int n = sajh._a(stringArray[4], 0);
                        int n2 = sajh._a(stringArray[5], 0);
                        rqmh2._m = n >= 0 && n2 >= 0 ? (Object)((Object)ezfc._h) + "" + n : "" + (Object)((Object)ezfc._i) + "???";
                    } else {
                        rqmh2._l = 79;
                        rqmh2._m = "" + (Object)((Object)ezfc._i) + "???";
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
                rqmh2._c = (Object)((Object)ezfc._h) + string;
                rqmh2._m = n >= 0 && n3 > 0 ? (Object)((Object)ezfc._h) + "" + n : "" + (Object)((Object)ezfc._i) + "???";
                rqmh2._l = 77;
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

    public static /* synthetic */ rqmh _a(htmo htmo2, long l) {
        return htmo2._a(l);
    }

    public static /* synthetic */ xpzm _b(htmo htmo2) {
        return htmo2.field_73882_e;
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

    public static /* synthetic */ xpzm _e(htmo htmo2) {
        return htmo2.field_73882_e;
    }

    public static /* synthetic */ xpzm _f(htmo htmo2) {
        return htmo2.field_73882_e;
    }

    public static /* synthetic */ long _b(htmo htmo2, long l) {
        htmo2._f = l;
        return htmo2._f;
    }

    public static /* synthetic */ xpzm _g(htmo htmo2) {
        return htmo2.field_73882_e;
    }

    public static /* synthetic */ jiok _h(htmo htmo2) {
        return htmo2._g;
    }

    public static /* synthetic */ jiok _i(htmo htmo2) {
        return htmo2._j;
    }

    public static /* synthetic */ void _c(htmo htmo2, long l) {
        htmo2._e(l);
    }

    public static /* synthetic */ int _d(htmo htmo2, long l) {
        return htmo2._b(l);
    }

    public static /* synthetic */ xpzm _j(htmo htmo2) {
        return htmo2.field_73882_e;
    }

    public static /* synthetic */ qncw _k(htmo htmo2) {
        return htmo2.field_73886_k;
    }

    public static /* synthetic */ void _a(htmo htmo2, int n, int n2, int n3, int n4) {
        htmo2._a(n, n2, n3, n4);
    }

    public static /* synthetic */ void _b(htmo htmo2, int n, int n2, int n3, int n4) {
        htmo2._c(n, n2, n3, n4);
    }

    public static /* synthetic */ xpzm _l(htmo htmo2) {
        return htmo2.field_73882_e;
    }

    public static /* synthetic */ void _a(htmo htmo2, int n, int n2, int n3, int n4, int n5) {
        htmo2._a(n, n2, n3, n4, n5);
    }

    public static /* synthetic */ void _c(htmo htmo2, int n, int n2, int n3, int n4) {
        htmo2._b(n, n2, n3, n4);
    }

    public static /* synthetic */ qncw _m(htmo htmo2) {
        return htmo2.field_73886_k;
    }

    public static /* synthetic */ qncw _n(htmo htmo2) {
        return htmo2.field_73886_k;
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

    public static /* synthetic */ void _a(htmo htmo2, rqmh rqmh2) {
        htmo2._a(rqmh2);
    }

    public static /* synthetic */ int _h() {
        return _d--;
    }

    public static /* synthetic */ qncw _o(htmo htmo2) {
        return htmo2.field_73886_k;
    }

    public static /* synthetic */ qncw _p(htmo htmo2) {
        return htmo2.field_73886_k;
    }

    public static /* synthetic */ xpzm _q(htmo htmo2) {
        return htmo2.field_73882_e;
    }

    static {
        _e = new Object();
        _l = new ifqv();
    }
}

