/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acd
 *  ad
 *  aln
 *  als
 *  amc
 *  amf
 *  asx
 *  ata
 *  ats
 *  atu
 *  atx
 *  aty
 *  atz
 *  aua
 *  aub
 *  auc
 *  aud
 *  aue
 *  auf
 *  aui
 *  auj
 *  auq
 *  aur
 *  aus
 *  avc
 *  avm
 *  avx
 *  awf
 *  bcy
 *  bdd
 *  bdi
 *  bdm
 *  bew
 *  bim
 *  bjm
 *  bjo
 *  bjp
 *  bjq
 *  bjr
 *  bjt
 *  bkb
 *  bkd
 *  bkh
 *  bki
 *  bko
 *  bkq
 *  bkr
 *  bks
 *  bku
 *  bkw
 *  bkx
 *  blv
 *  bma
 *  cm
 *  cn
 *  com.google.common.collect.Lists
 *  com.google.common.collect.MapDifference
 *  cpw.mods.fml.client.FMLClientHandler
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.registry.GameData
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  kp
 *  kq
 *  la
 *  lc
 *  lp
 *  lv
 *  lw
 *  mv
 *  mx
 *  net.minecraft.client.ClientBrandRetriever
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.client.ClientCommandHandler
 *  net.minecraftforge.client.ForgeHooksClient
 *  net.minecraftforge.client.GuiIngameForge
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$Action
 *  net.minecraftforge.event.world.WorldEvent$Unload
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.Sys
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.ContextCapabilities
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.DisplayMode
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GLContext
 *  org.lwjgl.util.glu.GLU
 *  u
 *  w
 */
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import javax.imageio.ImageIO;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

@SideOnly(value=Side.CLIENT)
public class atv
implements mx {
    private static final bjo I = new bjo("textures/gui/title/mojang.png");
    public static final boolean a = w.a() == x.d;
    public static byte[] b = new byte[0xA00000];
    private static final List J = Lists.newArrayList((Object[])new DisplayMode[]{new DisplayMode(2560, 1600), new DisplayMode(2880, 1800)});
    private final lp K;
    private final File L;
    private bdm M;
    public bim N;
    private static atv O;
    public bdc c;
    private boolean P;
    private boolean Q;
    private b R;
    public int d;
    public int e;
    public aur S = new aur(20.0f);
    private mv T = new mv("client", (mx)this, MinecraftServer.aq());
    public bdd f;
    public bfl g;
    public bdi h;
    public of i;
    public of j;
    public beh k;
    private final aus U;
    private boolean V;
    public avi l;
    public avi m;
    public awe n;
    public auo o;
    public bfe p;
    private int W;
    private int X;
    private int Y;
    private bkz Z;
    public awp q;
    public avj r;
    public boolean s;
    public ata t;
    public aul u;
    public bln v;
    public auj w;
    public final File x;
    private final File aa;
    private final String ab;
    private final Proxy ac;
    private amf ad;
    private static int ae;
    private int af;
    private boolean ag;
    public blv y;
    private String ah;
    private int ai;
    boolean z;
    public boolean A;
    long B = atv.F();
    private int aj;
    private final boolean ak;
    private cm al;
    private boolean am;
    public final lv C = new lv();
    private long an = -1L;
    private bjm ao;
    private final bki ap = new bki();
    private List aq = Lists.newArrayList();
    private bjg ar;
    private bjt as;
    private bkd at;
    public volatile boolean D = true;
    public String E = "";
    long F = atv.F();
    int G;
    long H = -1L;
    private String au = "root";
    private static int max_texture_size;

    public atv(aus par1Session, int par2, int par3, boolean par4, boolean par5, File par6File, File par7File, File par8File, Proxy par9Proxy, String par10Str) {
        O = this;
        this.K = new lc("Minecraft-Client", " [CLIENT]", new File(par6File, "output-client.log").getAbsolutePath());
        this.x = par6File;
        this.aa = par7File;
        this.L = par8File;
        this.ab = par10Str;
        this.ar = new bjg(this.aa);
        this.P();
        this.ac = par9Proxy;
        this.N();
        this.U = par1Session;
        this.K.a("Setting user: " + par1Session.a());
        this.ak = par5;
        this.d = par2;
        this.e = par3;
        this.X = par2;
        this.Y = par3;
        this.P = par4;
        ImageIO.setUseCache(false);
        la.a();
    }

    private void N() {
        atw threadclientsleep = new atw(this, "Timer hack thread");
        threadclientsleep.setDaemon(true);
        threadclientsleep.start();
    }

    public void a(b par1CrashReport) {
        this.Q = true;
        this.R = par1CrashReport;
    }

    public void c(b par1CrashReport) {
        File file1 = new File(atv.w().x, "crash-reports");
        File file2 = new File(file1, "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-client.txt");
        System.out.println(par1CrashReport.e());
        if (par1CrashReport.f() != null) {
            System.out.println("#@!@# Game crashed! Crash report saved to: #@!@# " + par1CrashReport.f());
            System.exit(-1);
        } else if (par1CrashReport.a(file2, this.an())) {
            System.out.println("#@!@# Game crashed! Crash report saved to: #@!@# " + file2.getAbsolutePath());
            System.exit(-1);
        } else {
            System.out.println("#@?@# Game crashed! Crash report could not be saved. #@?@#");
            System.exit(-2);
        }
    }

    public void a(String par1Str, int par2) {
        this.ah = par1Str;
        this.ai = par2;
    }

    private void O() throws LWJGLException {
        this.u = new aul(this, this.x);
        if (this.u.C > 0 && this.u.B > 0) {
            this.d = this.u.B;
            this.e = this.u.C;
        }
        if (this.P) {
            Display.setFullscreen((boolean)true);
            this.d = Display.getDisplayMode().getWidth();
            this.e = Display.getDisplayMode().getHeight();
            if (this.d <= 0) {
                this.d = 1;
            }
            if (this.e <= 0) {
                this.e = 1;
            }
        } else {
            Display.setDisplayMode((DisplayMode)new DisplayMode(this.d, this.e));
        }
        Display.setResizable((boolean)true);
        Display.setTitle((String)"Minecraft 1.6.4");
        this.an().a("LWJGL Version: " + Sys.getVersion());
        if (w.a() != x.d) {
            try {
                Display.setIcon((ByteBuffer[])new ByteBuffer[]{this.a(new File(this.aa, "/icons/icon_16x16.png")), this.a(new File(this.aa, "/icons/icon_32x32.png"))});
            }
            catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
        }
        try {
            ForgeHooksClient.createDisplay();
        }
        catch (LWJGLException lwjglexception) {
            lwjglexception.printStackTrace();
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            if (this.P) {
                this.Q();
            }
            Display.create();
        }
        bma.a();
        this.q = new awp(this);
        this.ap.a((bkh)new bkx(), bkw.class);
        this.ap.a((bkh)new bkr(), bkq.class);
        this.ap.a((bkh)new bkp(), bko.class);
        this.ap.a((bkh)new bkv(), bku.class);
        this.ap.a((bkh)new bkt(), bks.class);
        this.ad = new aln(new File(this.x, "saves"));
        this.as = new bjt(this.L, (bjr)this.ar, this.ap, this.u);
        this.ao = new bjw(this.ap);
        this.at = new bkd(this.ap, this.u.an);
        this.ao.a((bjq)this.at);
        this.a();
        this.N = new bim((bjp)this.ao);
        this.ao.a((bjq)this.N);
        this.v = new bln((bjp)this.ao, this.u, this.aa);
        this.v.LOAD_SOUND_SYSTEM = false;
        this.ao.a((bjq)this.v);
        this.R();
        this.l = new avi(this.u, new bjo("textures/font/ascii.png"), this.N, false);
        FMLClientHandler.instance().beginMinecraftLoading(this, this.aq, this.ao);
        if (this.u.an != null) {
            this.l.a(this.at.a());
            this.l.b(this.at.b());
        }
        this.m = new avi(this.u, new bjo("textures/font/ascii_sga.png"), this.N, false);
        this.ao.a((bjq)this.l);
        this.ao.a((bjq)this.m);
        this.ao.a((bjq)new bjl());
        this.ao.a((bjq)new bjk());
        bgl.a.f = new bfj(this);
        this.p = new bfe(this);
        this.y = new blv(this.U, this.x);
        kp.f.a((kq)new aub(this));
        this.w = new auj();
        this.c("Pre startup");
        GL11.glEnable((int)3553);
        GL11.glShadeModel((int)7425);
        GL11.glClearDepth((double)1.0);
        GL11.glEnable((int)2929);
        GL11.glDepthFunc((int)515);
        GL11.glEnable((int)3008);
        GL11.glAlphaFunc((int)516, (float)0.1f);
        GL11.glCullFace((int)1029);
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode((int)5888);
        this.c("Startup");
        this.g = new bfl(this);
        this.N.a(bik.b, new bik(0, "textures/blocks"));
        this.N.a(bik.c, new bik(1, "textures/items"));
        GL11.glViewport((int)0, (int)0, (int)this.d, (int)this.e);
        this.k = new beh((abw)this.f, this.N);
        FMLClientHandler.instance().finishMinecraftLoading();
        this.c("Post startup");
        this.r = new GuiIngameForge(this);
        if (this.ah != null) {
            this.a((awe)new bcy((awe)new blt(), this, this.ah, this.ai));
        } else {
            this.a(new blt());
        }
        this.o = new auo(this);
        if (this.u.u && !this.P) {
            this.j();
        }
        FMLClientHandler.instance().onInitializationComplete();
    }

    public void a() {
        ArrayList arraylist = Lists.newArrayList((Iterable)this.aq);
        for (bjv resourcepackrepositoryentry : this.as.c()) {
            arraylist.add(resourcepackrepositoryentry.c());
        }
        this.at.a((List)arraylist);
        this.ao.a((List)arraylist);
        if (this.g != null) {
            this.g.a();
        }
    }

    private void P() {
        this.aq.add(this.ar);
    }

    private ByteBuffer a(File par1File) throws IOException {
        BufferedImage bufferedimage = ImageIO.read(par1File);
        int[] aint = bufferedimage.getRGB(0, 0, bufferedimage.getWidth(), bufferedimage.getHeight(), null, 0, bufferedimage.getWidth());
        ByteBuffer bytebuffer = ByteBuffer.allocate(4 * aint.length);
        int[] aint1 = aint;
        int i = aint.length;
        for (int j2 = 0; j2 < i; ++j2) {
            int k = aint1[j2];
            bytebuffer.putInt(k << 8 | k >> 24 & 0xFF);
        }
        bytebuffer.flip();
        return bytebuffer;
    }

    private void Q() throws LWJGLException {
        HashSet hashset = new HashSet();
        Collections.addAll(hashset, Display.getAvailableDisplayModes());
        DisplayMode displaymode = Display.getDesktopDisplayMode();
        if (!hashset.contains(displaymode) && w.a() == x.d) {
            block0: for (DisplayMode displaymode1 : J) {
                boolean flag = true;
                for (DisplayMode displaymode2 : hashset) {
                    if (displaymode2.getBitsPerPixel() != 32 || displaymode2.getWidth() != displaymode1.getWidth() || displaymode2.getHeight() != displaymode1.getHeight()) continue;
                    flag = false;
                    break;
                }
                if (flag) continue;
                for (DisplayMode displaymode2 : hashset) {
                    if (displaymode2.getBitsPerPixel() != 32 || displaymode2.getWidth() != displaymode1.getWidth() / 2 || displaymode2.getHeight() != displaymode1.getHeight() / 2) continue;
                    displaymode = displaymode2;
                    continue block0;
                }
            }
        }
        Display.setDisplayMode((DisplayMode)displaymode);
        this.d = displaymode.getWidth();
        this.e = displaymode.getHeight();
    }

    private void R() throws LWJGLException {
        awf scaledresolution = new awf(this.u, this.d, this.e);
        GL11.glClear((int)16640);
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glOrtho((double)0.0, (double)scaledresolution.c(), (double)scaledresolution.d(), (double)0.0, (double)1000.0, (double)3000.0);
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-2000.0f);
        GL11.glViewport((int)0, (int)0, (int)this.d, (int)this.e);
        GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
        GL11.glDisable((int)2896);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)2912);
        this.N.a(I);
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.d(0xFFFFFF);
        tessellator.a(0.0, this.e, 0.0, 0.0, 0.0);
        tessellator.a(this.d, this.e, 0.0, 0.0, 0.0);
        tessellator.a(this.d, 0.0, 0.0, 0.0, 0.0);
        tessellator.a(0.0, 0.0, 0.0, 0.0, 0.0);
        tessellator.a();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        tessellator.d(0xFFFFFF);
        int short1 = 256;
        int short2 = 256;
        this.a((scaledresolution.a() - short1) / 2, (scaledresolution.b() - short2) / 2, 0, 0, short1, short2);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2912);
        GL11.glEnable((int)3008);
        GL11.glAlphaFunc((int)516, (float)0.1f);
        Display.update();
    }

    public void a(int par1, int par2, int par3, int par4, int par5, int par6) {
        float f = 0.00390625f;
        float f1 = 0.00390625f;
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(par1 + 0, par2 + par6, 0.0, (float)(par3 + 0) * f, (float)(par4 + par6) * f1);
        tessellator.a(par1 + par5, par2 + par6, 0.0, (float)(par3 + par5) * f, (float)(par4 + par6) * f1);
        tessellator.a(par1 + par5, par2 + 0, 0.0, (float)(par3 + par5) * f, (float)(par4 + 0) * f1);
        tessellator.a(par1 + 0, par2 + 0, 0.0, (float)(par3 + 0) * f, (float)(par4 + 0) * f1);
        tessellator.a();
    }

    public amf b() {
        return this.ad;
    }

    public void a(awe par1GuiScreen) {
        this.y.d();
        if (par1GuiScreen == null && this.f == null) {
            par1GuiScreen = new blt();
        } else if (par1GuiScreen == null && this.h.aN() <= 0.0f) {
            par1GuiScreen = new avc();
        }
        awe old = this.n;
        GuiOpenEvent event = new GuiOpenEvent(par1GuiScreen);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return;
        }
        par1GuiScreen = event.gui;
        if (old != null && par1GuiScreen != old) {
            old.b();
        }
        if (par1GuiScreen instanceof blt) {
            this.u.ab = false;
            this.r.b().a();
        }
        this.n = par1GuiScreen;
        if (par1GuiScreen != null) {
            this.h();
            awf scaledresolution = new awf(this.u, this.d, this.e);
            int i = scaledresolution.a();
            int j2 = scaledresolution.b();
            par1GuiScreen.a(this, i, j2);
            this.s = false;
        } else {
            this.g();
        }
    }

    private void c(String par1Str) {
        int i = GL11.glGetError();
        if (i != 0) {
            String s1 = GLU.gluErrorString((int)i);
            this.an().c("########## GL ERROR ##########");
            this.an().c("@ " + par1Str);
            this.an().c(i + ": " + s1);
        }
    }

    public void c() {
        try {
            this.y.d();
            this.an().a("Stopping!");
            try {
                this.a((bdd)null);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                atu.c();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            this.v.b();
        }
        finally {
            Display.destroy();
            if (!this.Q) {
                System.exit(0);
            }
        }
        System.gc();
    }

    public void d() {
        this.D = true;
        try {
            this.O();
        }
        catch (Throwable throwable) {
            b crashreport = b.a(throwable, "Initializing game");
            crashreport.a("Initialization");
            this.c(this.b(crashreport));
            return;
        }
        try {
            while (this.D) {
                if (!this.D) continue;
                if (this.Q && this.R != null) {
                    this.c(this.R);
                    return;
                }
                if (this.ag) {
                    this.ag = false;
                    this.a();
                }
                try {
                    this.S();
                }
                catch (OutOfMemoryError outofmemoryerror) {
                    this.e();
                    this.a((awe)new avx());
                    System.gc();
                }
            }
        }
        catch (auq outofmemoryerror) {
        }
        catch (u reportedexception) {
            this.b(reportedexception.a());
            this.e();
            reportedexception.printStackTrace();
            this.c(reportedexception.a());
        }
        catch (Throwable throwable1) {
            b crashreport = this.b(new b("Unexpected error", throwable1));
            this.e();
            throwable1.printStackTrace();
            this.c(crashreport);
        }
        finally {
            this.c();
        }
    }

    private void S() {
        asx.a().a();
        if (this.f != null) {
            this.f.V().a();
        }
        this.C.a("root");
        if (Display.isCloseRequested()) {
            this.f();
        }
        if (this.V && this.f != null) {
            float f = this.S.c;
            this.S.a();
            this.S.c = f;
        } else {
            this.S.a();
        }
        long i = System.nanoTime();
        this.C.a("tick");
        for (int j2 = 0; j2 < this.S.b; ++j2) {
            this.k();
        }
        this.C.c("preRenderErrors");
        long k = System.nanoTime() - i;
        this.c("Pre render");
        bfr.b = this.u.j;
        this.C.c("sound");
        this.v.a((of)this.h, this.S.c);
        if (!this.V) {
            this.v.g();
        }
        this.C.b();
        this.C.a("render");
        this.C.a("display");
        GL11.glEnable((int)3553);
        if (!Keyboard.isKeyDown((int)65)) {
            Display.update();
        }
        if (this.h != null && this.h.U()) {
            this.u.aa = 0;
        }
        this.C.b();
        if (!this.s) {
            FMLCommonHandler.instance().onRenderTickStart(this.S.c);
            this.C.c("gameRenderer");
            this.p.b(this.S.c);
            this.C.b();
            FMLCommonHandler.instance().onRenderTickEnd(this.S.c);
        }
        GL11.glFlush();
        this.C.b();
        if (!Display.isActive() && this.P) {
            this.j();
        }
        if (this.u.ab && this.u.ac) {
            if (!this.C.a) {
                this.C.a();
            }
            this.C.a = true;
            this.a(k);
        } else {
            this.C.a = false;
            this.H = System.nanoTime();
        }
        this.q.a();
        this.C.a("root");
        Thread.yield();
        if (Keyboard.isKeyDown((int)65)) {
            Display.update();
        }
        this.V();
        if (!this.P && Display.wasResized()) {
            this.d = Display.getWidth();
            this.e = Display.getHeight();
            if (this.d <= 0) {
                this.d = 1;
            }
            if (this.e <= 0) {
                this.e = 1;
            }
            this.a(this.d, this.e);
        }
        this.c("Post render");
        ++this.G;
        boolean flag = this.V;
        boolean bl2 = this.V = this.B() && this.n != null && this.n.f() && !this.Z.c();
        if (this.A() && this.h != null && this.h.a != null && this.V != flag) {
            ((cn)this.h.a.g()).a(this.V);
        }
        while (atv.F() >= this.F + 1000L) {
            ae = this.G;
            this.E = ae + " fps, " + bfa.b + " chunk updates";
            bfa.b = 0;
            this.F += 1000L;
            this.G = 0;
            this.T.b();
            if (this.T.d()) continue;
            this.T.a();
        }
        this.C.b();
        if (this.U() > 0) {
            Display.sync((int)bfe.a(this.U()));
        }
    }

    private int U() {
        return this.n != null && this.n instanceof blt ? 2 : this.u.i;
    }

    public void e() {
        try {
            b = new byte[0];
            this.g.f();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            System.gc();
            asx.a().b();
            this.f.V().b();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            System.gc();
            this.a((bdd)null);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        System.gc();
    }

    private void V() {
        if (Keyboard.isKeyDown((int)60)) {
            if (!this.z) {
                this.z = true;
                this.r.b().a(aup.a(this.x, this.d, this.e));
            }
        } else {
            this.z = false;
        }
    }

    private void b(int par1) {
        List list = this.C.b(this.au);
        if (list != null && !list.isEmpty()) {
            lw profilerresult = (lw)list.remove(0);
            if (par1 == 0) {
                int j2;
                if (profilerresult.c.length() > 0 && (j2 = this.au.lastIndexOf(".")) >= 0) {
                    this.au = this.au.substring(0, j2);
                }
            } else if (--par1 < list.size() && !((lw)list.get((int)par1)).c.equals("unspecified")) {
                if (this.au.length() > 0) {
                    this.au = this.au + ".";
                }
                this.au = this.au + ((lw)list.get((int)par1)).c;
            }
        }
    }

    private void a(long par1) {
        if (this.C.a) {
            int l;
            List list = this.C.b(this.au);
            lw profilerresult = (lw)list.remove(0);
            GL11.glClear((int)256);
            GL11.glMatrixMode((int)5889);
            GL11.glEnable((int)2903);
            GL11.glLoadIdentity();
            GL11.glOrtho((double)0.0, (double)this.d, (double)this.e, (double)0.0, (double)1000.0, (double)3000.0);
            GL11.glMatrixMode((int)5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-2000.0f);
            GL11.glLineWidth((float)1.0f);
            GL11.glDisable((int)3553);
            bfq tessellator = bfq.a;
            int short1 = 160;
            int j2 = this.d - short1 - 10;
            int k = this.e - short1 * 2;
            GL11.glEnable((int)3042);
            tessellator.b();
            tessellator.a(0, 200);
            tessellator.a((double)((float)j2 - (float)short1 * 1.1f), (double)((float)k - (float)short1 * 0.6f - 16.0f), 0.0);
            tessellator.a((double)((float)j2 - (float)short1 * 1.1f), (double)(k + short1 * 2), 0.0);
            tessellator.a((double)((float)j2 + (float)short1 * 1.1f), (double)(k + short1 * 2), 0.0);
            tessellator.a((double)((float)j2 + (float)short1 * 1.1f), (double)((float)k - (float)short1 * 0.6f - 16.0f), 0.0);
            tessellator.a();
            GL11.glDisable((int)3042);
            double d0 = 0.0;
            for (int i1 = 0; i1 < list.size(); ++i1) {
                float f2;
                float f1;
                float f;
                int j1;
                lw profilerresult1 = (lw)list.get(i1);
                l = ls.c(profilerresult1.a / 4.0) + 1;
                tessellator.b(6);
                tessellator.d(profilerresult1.a());
                tessellator.a((double)j2, (double)k, 0.0);
                for (j1 = l; j1 >= 0; --j1) {
                    f = (float)((d0 + profilerresult1.a * (double)j1 / (double)l) * Math.PI * 2.0 / 100.0);
                    f1 = ls.a(f) * (float)short1;
                    f2 = ls.b(f) * (float)short1 * 0.5f;
                    tessellator.a((double)((float)j2 + f1), (double)((float)k - f2), 0.0);
                }
                tessellator.a();
                tessellator.b(5);
                tessellator.d((profilerresult1.a() & 0xFEFEFE) >> 1);
                for (j1 = l; j1 >= 0; --j1) {
                    f = (float)((d0 + profilerresult1.a * (double)j1 / (double)l) * Math.PI * 2.0 / 100.0);
                    f1 = ls.a(f) * (float)short1;
                    f2 = ls.b(f) * (float)short1 * 0.5f;
                    tessellator.a((double)((float)j2 + f1), (double)((float)k - f2), 0.0);
                    tessellator.a((double)((float)j2 + f1), (double)((float)k - f2 + 10.0f), 0.0);
                }
                tessellator.a();
                d0 += profilerresult1.a;
            }
            DecimalFormat decimalformat = new DecimalFormat("##0.00");
            GL11.glEnable((int)3553);
            String s2 = "";
            if (!profilerresult.c.equals("unspecified")) {
                s2 = s2 + "[0] ";
            }
            s2 = profilerresult.c.length() == 0 ? s2 + "ROOT " : s2 + profilerresult.c + " ";
            l = 0xFFFFFF;
            this.l.a(s2, j2 - short1, k - short1 / 2 - 16, l);
            s2 = decimalformat.format(profilerresult.b) + "%";
            this.l.a(s2, j2 + short1 - this.l.a(s2), k - short1 / 2 - 16, l);
            for (int k1 = 0; k1 < list.size(); ++k1) {
                lw profilerresult2 = (lw)list.get(k1);
                String s1 = "";
                s1 = profilerresult2.c.equals("unspecified") ? s1 + "[?] " : s1 + "[" + (k1 + 1) + "] ";
                s1 = s1 + profilerresult2.c;
                this.l.a(s1, j2 - short1, k + short1 / 2 + k1 * 8 + 20, profilerresult2.a());
                s1 = decimalformat.format(profilerresult2.a) + "%";
                this.l.a(s1, j2 + short1 - 50 - this.l.a(s1), k + short1 / 2 + k1 * 8 + 20, profilerresult2.a());
                s1 = decimalformat.format(profilerresult2.b) + "%";
                this.l.a(s1, j2 + short1 - this.l.a(s1), k + short1 / 2 + k1 * 8 + 20, profilerresult2.a());
            }
        }
    }

    public void f() {
        this.D = false;
    }

    public void g() {
        if (Display.isActive() && !this.A) {
            this.A = true;
            this.w.a();
            this.a((awe)null);
            this.W = 10000;
        }
    }

    public void h() {
        if (this.A) {
            ats.a();
            this.A = false;
            this.w.b();
        }
    }

    public void i() {
        if (this.n == null) {
            this.a(new avy());
            if (this.B() && !this.Z.c()) {
                this.v.e();
            }
        }
    }

    private void a(int par1, boolean par2) {
        if (!par2) {
            this.W = 0;
        }
        if (par1 != 0 || this.W <= 0) {
            if (par2 && this.t != null && this.t.a == atb.a && par1 == 0) {
                int j2 = this.t.b;
                int k = this.t.c;
                int l = this.t.d;
                this.c.c(j2, k, l, this.t.e);
                if (this.h.d(j2, k, l)) {
                    this.k.addBlockHitEffects(j2, k, l, this.t);
                    this.h.aV();
                }
            } else {
                this.c.c();
            }
        }
    }

    private void c(int par1) {
        if (par1 != 0 || this.W <= 0) {
            if (par1 == 0) {
                this.h.aV();
            }
            if (par1 == 1) {
                this.af = 4;
            }
            boolean flag = true;
            ye itemstack = this.h.bn.h();
            if (this.t == null) {
                if (par1 == 0 && this.c.g()) {
                    this.W = 10;
                }
            } else if (this.t.a == atb.b) {
                if (par1 == 0) {
                    this.c.a((uf)this.h, this.t.g);
                }
                if (par1 == 1 && this.c.b((uf)this.h, this.t.g)) {
                    flag = false;
                }
            } else if (this.t.a == atb.a) {
                int j2 = this.t.b;
                int k = this.t.c;
                int l = this.t.d;
                int i1 = this.t.e;
                if (par1 == 0) {
                    this.c.b(j2, k, l, this.t.e);
                } else {
                    boolean result;
                    int j1 = itemstack != null ? itemstack.b : 0;
                    boolean bl2 = result = !ForgeEventFactory.onPlayerInteract((uf)this.h, (PlayerInteractEvent.Action)PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK, (int)j2, (int)k, (int)l, (int)i1).isCanceled();
                    if (result && this.c.a((uf)this.h, (abw)this.f, itemstack, j2, k, l, i1, this.t.f)) {
                        flag = false;
                        this.h.aV();
                    }
                    if (itemstack == null) {
                        return;
                    }
                    if (itemstack.b == 0) {
                        this.h.bn.a[this.h.bn.c] = null;
                    } else if (itemstack.b != j1 || this.c.h()) {
                        this.p.c.b();
                    }
                }
            }
            if (flag && par1 == 1) {
                boolean result;
                ye itemstack1 = this.h.bn.h();
                boolean bl3 = result = !ForgeEventFactory.onPlayerInteract((uf)this.h, (PlayerInteractEvent.Action)PlayerInteractEvent.Action.RIGHT_CLICK_AIR, (int)0, (int)0, (int)0, (int)-1).isCanceled();
                if (result && itemstack1 != null && this.c.a((uf)this.h, (abw)this.f, itemstack1)) {
                    this.p.c.c();
                }
            }
        }
    }

    public void j() {
        try {
            boolean bl2 = this.P = !this.P;
            if (this.P) {
                this.Q();
                this.d = Display.getDisplayMode().getWidth();
                this.e = Display.getDisplayMode().getHeight();
                if (this.d <= 0) {
                    this.d = 1;
                }
                if (this.e <= 0) {
                    this.e = 1;
                }
            } else {
                Display.setDisplayMode((DisplayMode)new DisplayMode(this.X, this.Y));
                this.d = this.X;
                this.e = this.Y;
                if (this.d <= 0) {
                    this.d = 1;
                }
                if (this.e <= 0) {
                    this.e = 1;
                }
            }
            if (this.n != null) {
                this.a(this.d, this.e);
            }
            Display.setFullscreen((boolean)this.P);
            Display.setVSyncEnabled((boolean)this.u.v);
            Display.update();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void a(int par1, int par2) {
        this.d = par1 <= 0 ? 1 : par1;
        int n = this.e = par2 <= 0 ? 1 : par2;
        if (this.n != null) {
            awf scaledresolution = new awf(this.u, par1, par2);
            int k = scaledresolution.a();
            int l = scaledresolution.b();
            this.n.a(this, k, l);
        }
    }

    public void k() {
        FMLCommonHandler.instance().rescheduleTicks(Side.CLIENT);
        if (this.af > 0) {
            --this.af;
        }
        FMLCommonHandler.instance().onPreClientTick();
        this.C.a("stats");
        this.y.e();
        this.C.c("gui");
        if (!this.V) {
            this.r.a();
        }
        this.C.c("pick");
        this.p.a(1.0f);
        this.C.c("gameMode");
        if (!this.V && this.f != null) {
            this.c.e();
        }
        this.C.c("textures");
        if (!this.V) {
            this.N.d();
        }
        if (this.n == null && this.h != null) {
            if (this.h.aN() <= 0.0f) {
                this.a((awe)null);
            } else if (this.h.bh() && this.f != null) {
                this.a((awe)new avm());
            }
        } else if (this.n != null && this.n instanceof avm && !this.h.bh()) {
            this.a((awe)null);
        }
        if (this.n != null) {
            this.W = 10000;
        }
        if (this.n != null) {
            try {
                this.n.m();
            }
            catch (Throwable throwable) {
                b crashreport = b.a(throwable, "Updating screen events");
                m crashreportcategory = crashreport.a("Affected screen");
                crashreportcategory.a("Screen name", (Callable)new auc(this));
                throw new u(crashreport);
            }
            if (this.n != null) {
                try {
                    this.n.c();
                }
                catch (Throwable throwable1) {
                    b crashreport = b.a(throwable1, "Ticking screen");
                    m crashreportcategory = crashreport.a("Affected screen");
                    crashreportcategory.a("Screen name", (Callable)new aud(this));
                    throw new u(crashreport);
                }
            }
        }
        if (this.n == null || this.n.j) {
            boolean flag;
            int i;
            this.C.c("mouse");
            while (Mouse.next()) {
                long j2;
                if (ForgeHooksClient.postMouseEvent()) continue;
                i = Mouse.getEventButton();
                if (a && i == 0 && (Keyboard.isKeyDown((int)29) || Keyboard.isKeyDown((int)157))) {
                    i = 1;
                }
                ats.a((int)(i - 100), (boolean)Mouse.getEventButtonState());
                if (Mouse.getEventButtonState()) {
                    ats.a((int)(i - 100));
                }
                if ((j2 = atv.F() - this.B) > 200L) continue;
                int k = Mouse.getEventDWheel();
                if (k != 0) {
                    this.h.bn.c(k);
                    if (this.u.ae) {
                        if (k > 0) {
                            k = 1;
                        }
                        if (k < 0) {
                            k = -1;
                        }
                        this.u.ah += (float)k * 0.25f;
                    }
                }
                if (this.n == null) {
                    if (this.A || !Mouse.getEventButtonState()) continue;
                    this.g();
                    continue;
                }
                if (this.n == null) continue;
                this.n.d();
            }
            if (this.W > 0) {
                --this.W;
            }
            this.C.c("keyboard");
            while (Keyboard.next()) {
                ats.a((int)Keyboard.getEventKey(), (boolean)Keyboard.getEventKeyState());
                if (Keyboard.getEventKeyState()) {
                    ats.a((int)Keyboard.getEventKey());
                }
                if (this.an > 0L) {
                    if (atv.F() - this.an >= 6000L) {
                        throw new u(new b("Manually triggered debug crash", new Throwable()));
                    }
                    if (!Keyboard.isKeyDown((int)46) || !Keyboard.isKeyDown((int)61)) {
                        this.an = -1L;
                    }
                } else if (Keyboard.isKeyDown((int)46) && Keyboard.isKeyDown((int)61)) {
                    this.an = atv.F();
                }
                if (!Keyboard.getEventKeyState()) continue;
                if (Keyboard.getEventKey() == 87) {
                    this.j();
                    continue;
                }
                if (this.n != null) {
                    this.n.n();
                } else {
                    if (Keyboard.getEventKey() == 1) {
                        this.i();
                    }
                    if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown((int)61)) {
                        this.a();
                    }
                    if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown((int)61)) {
                        this.a();
                    }
                    if (Keyboard.getEventKey() == 33 && Keyboard.isKeyDown((int)61)) {
                        boolean flag2 = Keyboard.isKeyDown((int)42) | Keyboard.isKeyDown((int)54);
                        this.u.a(aun.g, flag2 ? -1 : 1);
                    }
                    if (Keyboard.getEventKey() == 30 && Keyboard.isKeyDown((int)61)) {
                        this.g.a();
                    }
                    if (Keyboard.getEventKey() == 35 && Keyboard.isKeyDown((int)61)) {
                        this.u.x = !this.u.x;
                        this.u.b();
                    }
                    if (Keyboard.getEventKey() == 48 && Keyboard.isKeyDown((int)61)) {
                        boolean bl2 = bgl.p = !bgl.p;
                    }
                    if (Keyboard.getEventKey() == 25 && Keyboard.isKeyDown((int)61)) {
                        this.u.y = !this.u.y;
                        this.u.b();
                    }
                    if (Keyboard.getEventKey() == 59) {
                        boolean bl3 = this.u.Z = !this.u.Z;
                    }
                    if (Keyboard.getEventKey() == 61) {
                        this.u.ab = !this.u.ab;
                        this.u.ac = awe.p();
                    }
                    if (Keyboard.getEventKey() == 63) {
                        ++this.u.aa;
                        if (this.u.aa > 2) {
                            this.u.aa = 0;
                        }
                    }
                    if (Keyboard.getEventKey() == 66) {
                        this.u.af = !this.u.af;
                    }
                }
                for (i = 0; i < 9; ++i) {
                    if (Keyboard.getEventKey() != 2 + i) continue;
                    this.h.bn.c = i;
                }
                if (!this.u.ab || !this.u.ac) continue;
                if (Keyboard.getEventKey() == 11) {
                    this.b(0);
                }
                for (i = 0; i < 9; ++i) {
                    if (Keyboard.getEventKey() != 2 + i) continue;
                    this.b(i + 1);
                }
            }
            boolean bl4 = flag = this.u.n != 2;
            while (this.u.N.c()) {
                if (this.c.j()) {
                    this.h.j();
                    continue;
                }
                this.a(new axv((uf)this.h));
            }
            while (this.u.O.c()) {
                this.h.a(awe.o());
            }
            while (this.u.P.c() && flag) {
                this.a(new auw());
            }
            if (this.n == null && this.u.V.c() && flag) {
                this.a(new auw("/"));
            }
            if (this.h.br()) {
                if (!this.u.S.e) {
                    this.c.c((uf)this.h);
                }
                while (this.u.R.c()) {
                }
                while (this.u.S.c()) {
                }
                while (this.u.U.c()) {
                }
            } else {
                while (this.u.R.c()) {
                    this.c(0);
                }
                while (this.u.S.c()) {
                    this.c(1);
                }
                while (this.u.U.c()) {
                    this.W();
                }
            }
            if (this.u.S.e && this.af == 0 && !this.h.br()) {
                this.c(1);
            }
            this.a(0, this.n == null && this.u.R.e && this.A);
        }
        if (this.f != null) {
            if (this.h != null) {
                ++this.aj;
                if (this.aj == 30) {
                    this.aj = 0;
                    this.f.h((nn)this.h);
                }
            }
            this.C.c("gameRenderer");
            if (!this.V) {
                this.p.a();
            }
            this.C.c("levelRenderer");
            if (!this.V) {
                this.g.e();
            }
            this.C.c("level");
            if (!this.V) {
                if (this.f.q > 0) {
                    --this.f.q;
                }
                this.f.h();
            }
            if (!this.V) {
                this.f.a(this.f.r > 0, true);
                try {
                    this.f.b();
                }
                catch (Throwable throwable2) {
                    b crashreport = b.a(throwable2, "Exception in world tick");
                    if (this.f == null) {
                        m crashreportcategory = crashreport.a("Affected level");
                        crashreportcategory.a("Problem", "Level is null!");
                    } else {
                        this.f.a(crashreport);
                    }
                    throw new u(crashreport);
                }
            }
            this.C.c("animateTick");
            if (!this.V && this.f != null) {
                this.f.J(ls.c(this.h.u), ls.c(this.h.v), ls.c(this.h.w));
            }
            this.C.c("particles");
            if (!this.V) {
                this.k.a();
            }
        } else if (this.al != null) {
            this.C.c("pendingConnection");
            this.al.b();
        }
        FMLCommonHandler.instance().onPostClientTick();
        this.C.b();
        this.B = atv.F();
    }

    public void a(String par1Str, String par2Str, acd par3WorldSettings) {
        this.a((bdd)null);
        System.gc();
        amc isavehandler = this.ad.a(par1Str, false);
        als worldinfo = isavehandler.d();
        if (worldinfo == null && par3WorldSettings != null) {
            worldinfo = new als(par3WorldSettings, par1Str);
            isavehandler.a(worldinfo);
        }
        if (par3WorldSettings == null) {
            par3WorldSettings = new acd(worldinfo);
        }
        this.y.a(la.f, 1);
        GameData.initializeServerGate((int)2);
        this.Z = new bkz(this, par1Str, par2Str, par3WorldSettings);
        this.Z.v();
        MapDifference idDifferences = GameData.gateWorldLoadingForValidation();
        if (idDifferences != null) {
            FMLClientHandler.instance().warnIDMismatch(idDifferences, true);
        } else {
            GameData.releaseGate((boolean)true);
            this.continueWorldLoading();
        }
    }

    public void continueWorldLoading() {
        this.am = true;
        this.o.a(bkb.a((String)"menu.loadingLevel"));
        while (!this.Z.ah()) {
            String s2 = this.Z.e();
            if (s2 != null) {
                this.o.c(bkb.a((String)s2));
            } else {
                this.o.c("");
            }
            try {
                Thread.sleep(200L);
            }
            catch (InterruptedException interruptedException) {}
        }
        this.a((awe)null);
        try {
            bcw netclienthandler = new bcw(this, this.Z);
            this.al = netclienthandler.g();
        }
        catch (IOException ioexception) {
            this.c(this.b(new b("Connecting to integrated server", ioexception)));
        }
    }

    public void a(bdd par1WorldClient) {
        this.a(par1WorldClient, "");
    }

    public void a(bdd par1WorldClient, String par2Str) {
        this.y.d();
        if (this.f != null) {
            MinecraftForge.EVENT_BUS.post((Event)new WorldEvent.Unload((abw)this.f));
        }
        if (par1WorldClient == null) {
            bcw netclienthandler = this.q();
            if (netclienthandler != null) {
                netclienthandler.d();
            }
            if (this.al != null) {
                this.al.f();
            }
            if (this.Z != null) {
                this.Z.p();
                if (this.o != null) {
                    this.o.c("Shutting down internal server...");
                }
                while (!this.Z.ae()) {
                    try {
                        Thread.sleep(10L);
                    }
                    catch (InterruptedException interruptedException) {}
                }
            }
            this.Z = null;
        }
        this.i = null;
        this.al = null;
        if (this.o != null) {
            this.o.b(par2Str);
            this.o.c("");
        }
        if (par1WorldClient == null && this.f != null) {
            this.a((bdm)null);
            this.am = false;
        }
        this.v.a(null, 0.0f, 0.0f, 0.0f);
        this.v.d();
        this.f = par1WorldClient;
        if (par1WorldClient != null) {
            if (this.g != null) {
                this.g.a(par1WorldClient);
            }
            if (this.k != null) {
                this.k.a((abw)par1WorldClient);
            }
            if (this.h == null) {
                this.h = this.c.a((abw)par1WorldClient);
                this.c.b((uf)this.h);
            }
            this.h.w();
            par1WorldClient.d((nn)this.h);
            this.h.c = new bew(this.u);
            this.c.a((uf)this.h);
            this.i = this.h;
        } else {
            this.ad.d();
            this.h = null;
        }
        System.gc();
        this.B = 0L;
    }

    public String l() {
        return this.g.c();
    }

    public String m() {
        return this.g.d();
    }

    public String n() {
        return this.f.z();
    }

    public String o() {
        return "P: " + this.k.b() + ". T: " + this.f.y();
    }

    public void a(int par1) {
        this.f.f();
        this.f.a();
        int j2 = 0;
        String s2 = null;
        if (this.h != null) {
            j2 = this.h.k;
            this.f.e((nn)this.h);
            s2 = this.h.k();
        }
        this.i = null;
        this.h = this.c.a((abw)this.f);
        this.h.ar = par1;
        this.i = this.h;
        this.h.w();
        this.h.c(s2);
        this.f.d((nn)this.h);
        this.c.b((uf)this.h);
        this.h.c = new bew(this.u);
        this.h.k = j2;
        this.c.a((uf)this.h);
        if (this.n instanceof avc) {
            this.a((awe)null);
        }
    }

    public final boolean p() {
        return this.ak;
    }

    public bcw q() {
        return this.h != null ? this.h.a : null;
    }

    public static boolean r() {
        return O == null || !atv.O.u.Z;
    }

    public static boolean s() {
        return O != null && atv.O.u.j;
    }

    public static boolean t() {
        return O != null && atv.O.u.k != 0;
    }

    public boolean b(String par1Str) {
        return ClientCommandHandler.instance.a((ad)this.h, par1Str) == 1;
    }

    private void W() {
        if (this.t != null) {
            boolean flag = this.h.bG.d;
            if (!ForgeHooks.onPickBlock((ata)this.t, (uf)this.h, (abw)this.f)) {
                return;
            }
            if (flag) {
                int k = this.h.bo.c.size() - 9 + this.h.bn.c;
                this.c.a(this.h.bn.a(this.h.bn.c), k);
            }
        }
    }

    public b b(b par1CrashReport) {
        par1CrashReport.g().a("Launched Version", (Callable)new aue(this));
        par1CrashReport.g().a("LWJGL", (Callable)new auf(this));
        par1CrashReport.g().a("OpenGL", new aug(this));
        par1CrashReport.g().a("Is Modded", new auh(this));
        par1CrashReport.g().a("Type", (Callable)new aui(this));
        par1CrashReport.g().a("Resource Pack", (Callable)new atx(this));
        par1CrashReport.g().a("Current Language", (Callable)new aty(this));
        par1CrashReport.g().a("Profiler Position", (Callable)new atz(this));
        par1CrashReport.g().a("Vec3 Pool Size", (Callable)new aua(this));
        if (this.f != null) {
            this.f.a(par1CrashReport);
        }
        return par1CrashReport;
    }

    public static atv w() {
        return O;
    }

    public void a(mv par1PlayerUsageSnooper) {
        par1PlayerUsageSnooper.a("fps", (Object)ae);
        par1PlayerUsageSnooper.a("texpack_name", (Object)this.as.d());
        par1PlayerUsageSnooper.a("vsync_enabled", (Object)this.u.v);
        par1PlayerUsageSnooper.a("display_frequency", (Object)Display.getDisplayMode().getFrequency());
        par1PlayerUsageSnooper.a("display_type", (Object)(this.P ? "fullscreen" : "windowed"));
        par1PlayerUsageSnooper.a("run_time", (Object)((MinecraftServer.aq() - par1PlayerUsageSnooper.g()) / 60L * 1000L));
        if (this.Z != null && this.Z.al() != null) {
            par1PlayerUsageSnooper.a("snooper_partner", (Object)this.Z.al().f());
        }
    }

    public void b(mv par1PlayerUsageSnooper) {
        par1PlayerUsageSnooper.a("opengl_version", (Object)GL11.glGetString((int)7938));
        par1PlayerUsageSnooper.a("opengl_vendor", (Object)GL11.glGetString((int)7936));
        par1PlayerUsageSnooper.a("client_brand", (Object)ClientBrandRetriever.getClientModName());
        par1PlayerUsageSnooper.a("launched_version", (Object)this.ab);
        ContextCapabilities contextcapabilities = GLContext.getCapabilities();
        par1PlayerUsageSnooper.a("gl_caps[ARB_multitexture]", (Object)contextcapabilities.GL_ARB_multitexture);
        par1PlayerUsageSnooper.a("gl_caps[ARB_multisample]", (Object)contextcapabilities.GL_ARB_multisample);
        par1PlayerUsageSnooper.a("gl_caps[ARB_texture_cube_map]", (Object)contextcapabilities.GL_ARB_texture_cube_map);
        par1PlayerUsageSnooper.a("gl_caps[ARB_vertex_blend]", (Object)contextcapabilities.GL_ARB_vertex_blend);
        par1PlayerUsageSnooper.a("gl_caps[ARB_matrix_palette]", (Object)contextcapabilities.GL_ARB_matrix_palette);
        par1PlayerUsageSnooper.a("gl_caps[ARB_vertex_program]", (Object)contextcapabilities.GL_ARB_vertex_program);
        par1PlayerUsageSnooper.a("gl_caps[ARB_vertex_shader]", (Object)contextcapabilities.GL_ARB_vertex_shader);
        par1PlayerUsageSnooper.a("gl_caps[ARB_fragment_program]", (Object)contextcapabilities.GL_ARB_fragment_program);
        par1PlayerUsageSnooper.a("gl_caps[ARB_fragment_shader]", (Object)contextcapabilities.GL_ARB_fragment_shader);
        par1PlayerUsageSnooper.a("gl_caps[ARB_shader_objects]", (Object)contextcapabilities.GL_ARB_shader_objects);
        par1PlayerUsageSnooper.a("gl_caps[ARB_vertex_buffer_object]", (Object)contextcapabilities.GL_ARB_vertex_buffer_object);
        par1PlayerUsageSnooper.a("gl_caps[ARB_framebuffer_object]", (Object)contextcapabilities.GL_ARB_framebuffer_object);
        par1PlayerUsageSnooper.a("gl_caps[ARB_pixel_buffer_object]", (Object)contextcapabilities.GL_ARB_pixel_buffer_object);
        par1PlayerUsageSnooper.a("gl_caps[ARB_uniform_buffer_object]", (Object)contextcapabilities.GL_ARB_uniform_buffer_object);
        par1PlayerUsageSnooper.a("gl_caps[ARB_texture_non_power_of_two]", (Object)contextcapabilities.GL_ARB_texture_non_power_of_two);
        par1PlayerUsageSnooper.a("gl_caps[gl_max_vertex_uniforms]", (Object)GL11.glGetInteger((int)35658));
        par1PlayerUsageSnooper.a("gl_caps[gl_max_fragment_uniforms]", (Object)GL11.glGetInteger((int)35657));
        par1PlayerUsageSnooper.a("gl_max_texture_size", (Object)atv.y());
    }

    public static int y() {
        if (max_texture_size != -1) {
            return max_texture_size;
        }
        for (int i = 16384; i > 0; i >>= 1) {
            GL11.glTexImage2D((int)32868, (int)0, (int)6408, (int)i, (int)i, (int)0, (int)6408, (int)5121, (ByteBuffer)null);
            int j2 = GL11.glGetTexLevelParameteri((int)32868, (int)0, (int)4096);
            if (j2 == 0) continue;
            max_texture_size = i;
            return i;
        }
        return -1;
    }

    public boolean T() {
        return this.u.t;
    }

    public void a(bdm par1ServerData) {
        this.M = par1ServerData;
    }

    public boolean A() {
        return this.am;
    }

    public boolean B() {
        return this.am && this.Z != null;
    }

    public bkz C() {
        return this.Z;
    }

    public static void D() {
        bkz integratedserver;
        if (O != null && (integratedserver = O.C()) != null) {
            integratedserver.m();
        }
    }

    public mv E() {
        return this.T;
    }

    public static long F() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }

    public boolean G() {
        return this.P;
    }

    public lp an() {
        return this.K;
    }

    public aus H() {
        return this.U;
    }

    public Proxy I() {
        return this.ac;
    }

    public bim J() {
        return this.N;
    }

    public bjp K() {
        return this.ao;
    }

    public bjt L() {
        return this.as;
    }

    public bkd M() {
        return this.at;
    }

    static String a(atv par0Minecraft) {
        return par0Minecraft.ab;
    }

    static bkd b(atv par0Minecraft) {
        return par0Minecraft.at;
    }

    static {
        max_texture_size = -1;
    }
}

