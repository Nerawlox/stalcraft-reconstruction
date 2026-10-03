/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  aux
 *  ave
 *  avg
 *  bcy
 *  bdl
 *  bdm
 *  bdn
 *  bkb
 *  ble
 *  blg
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  eg
 *  org.lwjgl.input.Keyboard
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
import org.lwjgl.input.Keyboard;

@SideOnly(value=Side.CLIENT)
public class avn
extends awe {
    private static int a;
    private static Object b;
    private awe c;
    private avo d;
    private bdn e;
    private int p = -1;
    private aut q;
    private aut r;
    private aut s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private String x;
    private bdm y;
    private blg z;
    private blf A;
    private int B;
    private boolean C;
    private List D = Collections.emptyList();

    public avn(awe par1GuiScreen) {
        this.c = par1GuiScreen;
    }

    @Override
    public void A_() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.i.clear();
        if (!this.C) {
            this.C = true;
            this.e = new bdn(this.f);
            this.e.a();
            this.z = new blg();
            try {
                this.A = new blf(this.z);
                this.A.start();
            }
            catch (Exception exception) {
                this.f.an().b("Unable to start LAN server detection: " + exception.getMessage());
            }
            this.d = new avo(this);
        } else {
            this.d.a(this.g, this.h, 32, this.h - 64);
        }
        this.g();
    }

    public void g() {
        boolean flag;
        this.q = new aut(7, this.g / 2 - 154, this.h - 28, 70, 20, bkb.a((String)"selectServer.edit"));
        this.i.add(this.q);
        this.s = new aut(2, this.g / 2 - 74, this.h - 28, 70, 20, bkb.a((String)"selectServer.delete"));
        this.i.add(this.s);
        this.r = new aut(1, this.g / 2 - 154, this.h - 52, 100, 20, bkb.a((String)"selectServer.select"));
        this.i.add(this.r);
        this.i.add(new aut(4, this.g / 2 - 50, this.h - 52, 100, 20, bkb.a((String)"selectServer.direct")));
        this.i.add(new aut(3, this.g / 2 + 4 + 50, this.h - 52, 100, 20, bkb.a((String)"selectServer.add")));
        this.i.add(new aut(8, this.g / 2 + 4, this.h - 28, 70, 20, bkb.a((String)"selectServer.refresh")));
        this.i.add(new aut(0, this.g / 2 + 4 + 76, this.h - 28, 75, 20, bkb.a((String)"gui.cancel")));
        this.r.h = flag = this.p >= 0 && this.p < this.d.a();
        this.q.h = flag;
        this.s.h = flag;
    }

    @Override
    public void c() {
        super.c();
        ++this.B;
        if (this.z.a()) {
            this.D = this.z.c();
            this.z.b();
        }
    }

    @Override
    public void b() {
        Keyboard.enableRepeatEvents((boolean)false);
        if (this.A != null) {
            this.A.interrupt();
            this.A = null;
        }
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.h) {
            if (par1GuiButton.g == 2) {
                String s2 = this.e.a((int)this.p).a;
                if (s2 != null) {
                    this.t = true;
                    String s1 = bkb.a((String)"selectServer.deleteQuestion");
                    String s22 = "'" + s2 + "' " + bkb.a((String)"selectServer.deleteWarning");
                    String s3 = bkb.a((String)"selectServer.deleteButton");
                    String s4 = bkb.a((String)"gui.cancel");
                    aux guiyesno = new aux((awe)this, s1, s22, s3, s4, this.p);
                    this.f.a((awe)guiyesno);
                }
            } else if (par1GuiButton.g == 1) {
                this.a(this.p);
            } else if (par1GuiButton.g == 4) {
                this.w = true;
                this.y = new bdm(bkb.a((String)"selectServer.defaultName"), "");
                this.f.a((awe)new ave((awe)this, this.y));
            } else if (par1GuiButton.g == 3) {
                this.u = true;
                this.y = new bdm(bkb.a((String)"selectServer.defaultName"), "");
                this.f.a((awe)new avg((awe)this, this.y));
            } else if (par1GuiButton.g == 7) {
                this.v = true;
                bdm serverdata = this.e.a(this.p);
                this.y = new bdm(serverdata.a, serverdata.b);
                this.y.b(serverdata.d());
                this.f.a((awe)new avg((awe)this, this.y));
            } else if (par1GuiButton.g == 0) {
                this.f.a(this.c);
            } else if (par1GuiButton.g == 8) {
                this.f.a(new avn(this.c));
            } else {
                this.d.a(par1GuiButton);
            }
        }
    }

    @Override
    public void a(boolean par1, int par2) {
        if (this.t) {
            this.t = false;
            if (par1) {
                this.e.b(par2);
                this.e.b();
                this.p = -1;
            }
            this.f.a(this);
        } else if (this.w) {
            this.w = false;
            if (par1) {
                this.b(this.y);
            } else {
                this.f.a(this);
            }
        } else if (this.u) {
            this.u = false;
            if (par1) {
                this.e.a(this.y);
                this.e.b();
                this.p = -1;
            }
            this.f.a(this);
        } else if (this.v) {
            this.v = false;
            if (par1) {
                bdm serverdata = this.e.a(this.p);
                serverdata.a = this.y.a;
                serverdata.b = this.y.b;
                serverdata.b(this.y.d());
                this.e.b();
            }
            this.f.a(this);
        }
    }

    @Override
    protected void a(char par1, int par2) {
        int j2 = this.p--;
        if (par2 == 59) {
            this.f.u.w = !this.f.u.w;
            this.f.u.b();
        } else if (avn.p() && par2 == 200) {
            if (j2 > 0 && j2 < this.e.c()) {
                this.e.a(j2, j2 - 1);
                if (j2 < this.e.c() - 1) {
                    this.d.b(-this.d.e);
                }
            }
        } else if (avn.p() && par2 == 208) {
            if (j2 >= 0 & j2 < this.e.c() - 1) {
                this.e.a(j2, j2 + 1);
                ++this.p;
                if (j2 > 0) {
                    this.d.b(this.d.e);
                }
            }
        } else if (par2 != 28 && par2 != 156) {
            super.a(par1, par2);
        } else {
            this.a((aut)this.i.get(2));
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.x = null;
        this.e();
        this.d.a(par1, par2, par3);
        this.a(this.o, bkb.a((String)"multiplayer.title"), this.g / 2, 20, 0xFFFFFF);
        super.a(par1, par2, par3);
        if (this.x != null) {
            this.a(this.x, par1, par2);
        }
    }

    private void a(int par1) {
        if (par1 < this.e.c()) {
            this.b(this.e.a(par1));
        } else if ((par1 -= this.e.c()) < this.D.size()) {
            ble lanserver = (ble)this.D.get(par1);
            this.b(new bdm(lanserver.a(), lanserver.b()));
        }
    }

    private void b(bdm par1ServerData) {
        this.f.a((awe)new bcy((awe)this, this.f, par1ServerData));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void c(bdm par0ServerData) throws IOException {
        block25: {
            bdl serveraddress = bdl.a((String)par0ServerData.b);
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
                eg packet254serverping = new eg(78, serveraddress.a(), serveraddress.b());
                ((DataOutputStream)dataoutputstream).writeByte(packet254serverping.n());
                packet254serverping.a((DataOutput)((Object)dataoutputstream));
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
                        par0ServerData.d = astring[3];
                        par0ServerData.f = ls.a(astring[1], par0ServerData.f);
                        par0ServerData.g = astring[2];
                        j2 = ls.a(astring[4], 0);
                        int k = ls.a(astring[5], 0);
                        par0ServerData.c = j2 >= 0 && k >= 0 ? (Object)((Object)a.h) + "" + j2 + "" + (Object)((Object)a.i) + "/" + (Object)((Object)a.h) + k : "" + (Object)((Object)a.i) + "???";
                    } else {
                        par0ServerData.g = "???";
                        par0ServerData.d = "" + (Object)((Object)a.i) + "???";
                        par0ServerData.f = 79;
                        par0ServerData.c = "" + (Object)((Object)a.i) + "???";
                    }
                    break block25;
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
                par0ServerData.d = (Object)((Object)a.h) + s2;
                par0ServerData.c = j2 >= 0 && k > 0 ? (Object)((Object)a.h) + "" + j2 + "" + (Object)((Object)a.i) + "/" + (Object)((Object)a.h) + k : "" + (Object)((Object)a.i) + "???";
                par0ServerData.g = "1.3";
                par0ServerData.f = 77;
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

    protected void a(String par1Str, int par2, int par3) {
        if (par1Str != null) {
            int k = par2 + 12;
            int l = par3 - 12;
            int i1 = this.o.a(par1Str);
            this.a(k - 3, l - 3, k + i1 + 3, l + 8 + 3, -1073741824, -1073741824);
            this.o.a(par1Str, k, l, -1);
        }
    }

    static bdn a(avn par0GuiMultiplayer) {
        return par0GuiMultiplayer.e;
    }

    static List b(avn par0GuiMultiplayer) {
        return par0GuiMultiplayer.D;
    }

    static int c(avn par0GuiMultiplayer) {
        return par0GuiMultiplayer.p;
    }

    static int a(avn par0GuiMultiplayer, int par1) {
        par0GuiMultiplayer.p = par1;
        return par0GuiMultiplayer.p;
    }

    static aut d(avn par0GuiMultiplayer) {
        return par0GuiMultiplayer.r;
    }

    static aut e(avn par0GuiMultiplayer) {
        return par0GuiMultiplayer.q;
    }

    static aut f(avn par0GuiMultiplayer) {
        return par0GuiMultiplayer.s;
    }

    static void b(avn par0GuiMultiplayer, int par1) {
        par0GuiMultiplayer.a(par1);
    }

    static int g(avn par0GuiMultiplayer) {
        return par0GuiMultiplayer.B;
    }

    static Object h() {
        return b;
    }

    static int i() {
        return a;
    }

    static int j() {
        return a++;
    }

    static void a(bdm par0ServerData) throws IOException {
        avn.c(par0ServerData);
    }

    static int k() {
        return a--;
    }

    static String a(avn par0GuiMultiplayer, String par1Str) {
        par0GuiMultiplayer.x = par1Str;
        return par0GuiMultiplayer.x;
    }

    static {
        b = new Object();
    }
}

