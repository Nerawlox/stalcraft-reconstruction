/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  ayh
 *  ayo
 *  ayq
 *  ayr
 *  ayx
 *  aza
 *  azb
 *  aze
 *  azj
 *  bap
 *  bdl
 *  bjo
 *  bkb
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class ayz
extends awe {
    private static final bjo a = new bjo("textures/gui/widgets.png");
    private awe b;
    private azb c;
    private static int d;
    private static final Object e;
    private long p = -1L;
    private aut q;
    private aut r;
    private avu s;
    private aut t;
    private String u;
    private static azj v;
    private boolean w;
    private List x = Lists.newArrayList();
    private volatile int y = 0;
    private Long z;
    private int A;

    public ayz(awe par1GuiScreen) {
        this.b = par1GuiScreen;
    }

    @Override
    public void A_() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.i.clear();
        v.a(this.f.H());
        if (!this.w) {
            this.w = true;
            this.c = new azb(this);
        } else {
            this.c.a(this.g, this.h, 32, this.h - 64);
        }
        this.g();
    }

    public void g() {
        this.t = new aut(1, this.g / 2 - 154, this.h - 52, 100, 20, bkb.a((String)"mco.selectServer.play"));
        this.i.add(this.t);
        this.r = new aut(2, this.g / 2 - 48, this.h - 52, 100, 20, bkb.a((String)"mco.selectServer.create"));
        this.i.add(this.r);
        this.q = new aut(3, this.g / 2 + 58, this.h - 52, 100, 20, bkb.a((String)"mco.selectServer.configure"));
        this.i.add(this.q);
        this.s = new avu(4, this.g / 2 - 154, this.h - 28, 154, 20, bkb.a((String)"mco.selectServer.moreinfo"));
        this.i.add(this.s);
        this.i.add(new aut(0, this.g / 2 + 6, this.h - 28, 153, 20, bkb.a((String)"gui.cancel")));
        bak mcoserver = this.b(this.p);
        this.t.h = mcoserver != null && mcoserver.d.equals("OPEN") && !mcoserver.h;
        boolean bl2 = this.r.h = this.y > 0;
        if (mcoserver != null && !mcoserver.e.equals(this.f.H().a())) {
            this.q.f = bkb.a((String)"mco.selectServer.leave");
        }
    }

    @Override
    public void c() {
        super.c();
        ++this.A;
        if (v.a()) {
            List list = v.c();
            block0: for (bak mcoserver : list) {
                for (bak mcoserver1 : this.x) {
                    if (mcoserver.a != mcoserver1.a) continue;
                    mcoserver.a(mcoserver1);
                    if (this.z == null || this.z != mcoserver.a) continue block0;
                    this.z = null;
                    mcoserver.n = false;
                    continue block0;
                }
            }
            this.y = v.e();
            this.x = list;
            v.b();
        }
        this.r.h = this.y > 0;
    }

    @Override
    public void b() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.h) {
            if (par1GuiButton.g == 1) {
                this.e(this.p);
            } else if (par1GuiButton.g == 3) {
                this.s();
            } else if (par1GuiButton.g == 0) {
                v.f();
                this.f.a(this.b);
            } else if (par1GuiButton.g == 2) {
                v.f();
                this.f.a((awe)new ayh((awe)this));
            } else if (par1GuiButton.g == 4) {
                this.s.a("http://realms.minecraft.net/");
            } else {
                this.c.a(par1GuiButton);
            }
        }
    }

    private void s() {
        bak mcoserver = this.b(this.p);
        if (mcoserver != null) {
            if (this.f.H().a().equals(mcoserver.e)) {
                bak mcoserver1 = this.d(mcoserver.a);
                if (mcoserver1 != null) {
                    v.f();
                    this.f.a(new ayf(this, mcoserver1));
                }
            } else {
                String s2 = bkb.a((String)"mco.configure.world.leave.question.line1");
                String s1 = bkb.a((String)"mco.configure.world.leave.question.line2");
                this.f.a((awe)new ayo((awe)this, ayp.b, s2, s1, 3));
            }
        }
    }

    private bak b(long par1) {
        bak mcoserver;
        Iterator iterator = this.x.iterator();
        do {
            if (!iterator.hasNext()) {
                return null;
            }
            mcoserver = (bak)iterator.next();
        } while (mcoserver.a != par1);
        return mcoserver;
    }

    private int c(long par1) {
        for (int j2 = 0; j2 < this.x.size(); ++j2) {
            if (((bak)this.x.get((int)j2)).a != par1) continue;
            return j2;
        }
        return -1;
    }

    @Override
    public void a(boolean par1, int par2) {
        if (par2 == 3 && par1) {
            new aza(this).start();
        }
        this.f.a(this);
    }

    private void t() {
        int i = this.c(this.p);
        if (this.x.size() - 1 == i) {
            --i;
        }
        if (this.x.size() == 0) {
            i = -1;
        }
        if (i >= 0 && i < this.x.size()) {
            this.p = ((bak)this.x.get((int)i)).a;
        }
    }

    public void a(long par1) {
        this.p = -1L;
        this.z = par1;
    }

    private bak d(long par1) {
        azz mcoclient = new azz(this.f.H());
        try {
            return mcoclient.a(par1);
        }
        catch (bap exceptionmcoservice) {
            this.f.an().c(exceptionmcoservice.toString());
        }
        catch (IOException ioexception) {
            this.f.an().b("Realms: could not parse response");
        }
        return null;
    }

    @Override
    protected void a(char par1, int par2) {
        if (par2 == 59) {
            this.f.u.w = !this.f.u.w;
            this.f.u.b();
        } else if (par2 != 28 && par2 != 156) {
            super.a(par1, par2);
        } else {
            this.a((aut)this.i.get(0));
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.u = null;
        this.e();
        this.c.a(par1, par2, par3);
        this.a(this.o, bkb.a((String)"mco.title"), this.g / 2, 20, 0xFFFFFF);
        super.a(par1, par2, par3);
        if (this.u != null) {
            this.a(this.u, par1, par2);
        }
        this.b(par1, par2);
    }

    @Override
    protected void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
        if (this.c(par1, par2) && v.d() != 0) {
            aze guiscreenpendinginvitation = new aze((awe)this);
            this.f.a((awe)guiscreenpendinginvitation);
        }
    }

    private void b(int par1, int par2) {
        int i1;
        int l;
        int k = v.d();
        boolean flag = this.c(par1, par2);
        this.f.J().a(a);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPushMatrix();
        this.b(this.g / 2 + 58, 15, flag ? 166 : 182, 22, 16, 16);
        GL11.glPopMatrix();
        if (k != 0) {
            l = 198 + (Math.min(k, 6) - 1) * 8;
            i1 = (int)(Math.max(0.0f, Math.max(ls.a((float)(10 + this.A) * 0.57f), ls.b((float)this.A * 0.35f))) * -6.0f);
            this.f.J().a(a);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPushMatrix();
            this.b(this.g / 2 + 58 + 4, 19 + i1, l, 22, 8, 8);
            GL11.glPopMatrix();
        }
        if (flag && k != 0) {
            l = par1 + 12;
            i1 = par2 - 12;
            String s2 = bkb.a((String)"mco.invites.pending");
            int j1 = this.o.a(s2);
            this.a(l - 3, i1 - 3, l + j1 + 3, i1 + 8 + 3, -1073741824, -1073741824);
            this.o.a(s2, l, i1, -1);
        }
    }

    private boolean c(int par1, int par2) {
        int k = this.g / 2 + 56;
        int l = this.g / 2 + 78;
        int b0 = 13;
        int b1 = 27;
        return k <= par1 && par1 <= l && b0 <= par2 && par2 <= b1;
    }

    private void e(long par1) {
        bak mcoserver = this.b(par1);
        if (mcoserver != null) {
            v.f();
            ayq guiscreenlongrunningtask = new ayq(this.f, (awe)this, (ayr)new ayx((awe)this, mcoserver));
            guiscreenlongrunningtask.g();
            this.f.a((awe)guiscreenlongrunningtask);
        }
    }

    private void c(int par1, int par2, int par3, int par4) {
        this.f.J().a(a);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPushMatrix();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        this.b(par1 * 2, par2 * 2, 191, 0, 16, 15);
        GL11.glPopMatrix();
        if (par3 >= par1 && par3 <= par1 + 9 && par4 >= par2 && par4 <= par2 + 9) {
            this.u = bkb.a((String)"mco.selectServer.expired");
        }
    }

    private void b(int par1, int par2, int par3, int par4, int par5) {
        if (this.A % 20 < 10) {
            this.f.J().a(a);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPushMatrix();
            GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
            this.b(par1 * 2, par2 * 2, 207, 0, 16, 15);
            GL11.glPopMatrix();
        }
        if (par3 >= par1 && par3 <= par1 + 9 && par4 >= par2 && par4 <= par2 + 9) {
            this.u = par5 == 0 ? bkb.a((String)"mco.selectServer.expires.soon") : (par5 == 1 ? bkb.a((String)"mco.selectServer.expires.day") : bkb.a((String)"mco.selectServer.expires.days", (Object[])new Object[]{par5}));
        }
    }

    private void d(int par1, int par2, int par3, int par4) {
        this.f.J().a(a);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPushMatrix();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        this.b(par1 * 2, par2 * 2, 207, 0, 16, 15);
        GL11.glPopMatrix();
        if (par3 >= par1 && par3 <= par1 + 9 && par4 >= par2 && par4 <= par2 + 9) {
            this.u = bkb.a((String)"mco.selectServer.open");
        }
    }

    private void e(int par1, int par2, int par3, int par4) {
        this.f.J().a(a);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPushMatrix();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        this.b(par1 * 2, par2 * 2, 223, 0, 16, 15);
        GL11.glPopMatrix();
        if (par3 >= par1 && par3 <= par1 + 9 && par4 >= par2 && par4 <= par2 + 9) {
            this.u = bkb.a((String)"mco.selectServer.closed");
        }
    }

    protected void a(String par1Str, int par2, int par3) {
        if (par1Str != null) {
            int k = par2 + 12;
            int l = par3 - 12;
            int i1 = this.o.a(par1Str);
            this.a(k - 3, l - 3, k + i1 + 3, l + 8 + 3, -1073741824, -1073741824);
            this.o.a(par1Str, k, l, -1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(bak par1McoServer) throws IOException {
        block26: {
            if (par1McoServer.m.equals("")) {
                par1McoServer.m = (Object)((Object)a.h) + "" + 0;
            }
            par1McoServer.l = 78;
            bdl serveraddress = bdl.a((String)par1McoServer.g);
            Socket socket = null;
            FilterInputStream datainputstream = null;
            FilterOutputStream dataoutputstream = null;
            try {
                int j2;
                socket = new Socket();
                socket.setSoTimeout(3000);
                socket.setTcpNoDelay(true);
                socket.setTrafficClass(18);
                socket.connect(new InetSocketAddress(serveraddress.a(), serveraddress.b()), 3000);
                datainputstream = new DataInputStream(socket.getInputStream());
                dataoutputstream = new DataOutputStream(socket.getOutputStream());
                ((DataOutputStream)dataoutputstream).write(254);
                ((DataOutputStream)dataoutputstream).write(1);
                if (datainputstream.read() != 255) {
                    throw new IOException("Bad message");
                }
                String s2 = ey.a((DataInput)((Object)datainputstream), 256);
                char[] achar = s2.toCharArray();
                for (int i = 0; i < achar.length; ++i) {
                    if (achar[i] == '\u00a7' || achar[i] == '\u0000' || v.a.indexOf(achar[i]) >= 0) continue;
                    achar[i] = 63;
                }
                s2 = new String(achar);
                if (s2.startsWith("\u00a7") && s2.length() > 1) {
                    String[] astring = s2.substring(1).split("\u0000");
                    if (ls.a(astring[0], 0) == 1) {
                        par1McoServer.l = ls.a(astring[1], par1McoServer.l);
                        j2 = ls.a(astring[4], 0);
                        int k = ls.a(astring[5], 0);
                        par1McoServer.m = j2 >= 0 && k >= 0 ? (Object)((Object)a.h) + "" + j2 : "" + (Object)((Object)a.i) + "???";
                    } else {
                        par1McoServer.l = 79;
                        par1McoServer.m = "" + (Object)((Object)a.i) + "???";
                    }
                    break block26;
                }
                String[] astring = s2.split("\u00a7");
                s2 = astring[0];
                j2 = -1;
                int k = -1;
                try {
                    j2 = Integer.parseInt(astring[1]);
                    k = Integer.parseInt(astring[2]);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                par1McoServer.c = (Object)((Object)a.h) + s2;
                par1McoServer.m = j2 >= 0 && k > 0 ? (Object)((Object)a.h) + "" + j2 : "" + (Object)((Object)a.i) + "???";
                par1McoServer.l = 77;
            }
            finally {
                try {
                    if (datainputstream != null) {
                        datainputstream.close();
                    }
                }
                catch (Throwable throwable) {}
                try {
                    if (dataoutputstream != null) {
                        dataoutputstream.close();
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

    static long a(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.p;
    }

    static bak a(ayz par0GuiScreenOnlineServers, long par1) {
        return par0GuiScreenOnlineServers.b(par1);
    }

    static atv b(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.f;
    }

    static azj h() {
        return v;
    }

    static List c(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.x;
    }

    static void d(ayz par0GuiScreenOnlineServers) {
        par0GuiScreenOnlineServers.t();
    }

    static atv e(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.f;
    }

    static atv f(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.f;
    }

    static long b(ayz par0GuiScreenOnlineServers, long par1) {
        par0GuiScreenOnlineServers.p = par1;
        return par0GuiScreenOnlineServers.p;
    }

    static atv g(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.f;
    }

    static aut h(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.q;
    }

    static aut i(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.t;
    }

    static void c(ayz par0GuiScreenOnlineServers, long par1) {
        par0GuiScreenOnlineServers.e(par1);
    }

    static int d(ayz par0GuiScreenOnlineServers, long par1) {
        return par0GuiScreenOnlineServers.c(par1);
    }

    static atv j(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.f;
    }

    static avi k(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.o;
    }

    static void a(ayz par0GuiScreenOnlineServers, int par1, int par2, int par3, int par4) {
        par0GuiScreenOnlineServers.c(par1, par2, par3, par4);
    }

    static void b(ayz par0GuiScreenOnlineServers, int par1, int par2, int par3, int par4) {
        par0GuiScreenOnlineServers.e(par1, par2, par3, par4);
    }

    static atv l(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.f;
    }

    static void a(ayz par0GuiScreenOnlineServers, int par1, int par2, int par3, int par4, int par5) {
        par0GuiScreenOnlineServers.b(par1, par2, par3, par4, par5);
    }

    static void c(ayz par0GuiScreenOnlineServers, int par1, int par2, int par3, int par4) {
        par0GuiScreenOnlineServers.d(par1, par2, par3, par4);
    }

    static avi m(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.o;
    }

    static avi n(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.o;
    }

    static Object i() {
        return e;
    }

    static int j() {
        return d;
    }

    static int k() {
        return d++;
    }

    static void a(ayz par0GuiScreenOnlineServers, bak par1McoServer) throws IOException {
        par0GuiScreenOnlineServers.a(par1McoServer);
    }

    static int r() {
        return d--;
    }

    static avi o(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.o;
    }

    static avi p(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.o;
    }

    static atv q(ayz par0GuiScreenOnlineServers) {
        return par0GuiScreenOnlineServers.f;
    }

    static {
        e = new Object();
        v = new azj();
    }
}

