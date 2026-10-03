/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.asm.KeyboardListener;
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
import javax.imageio.ImageIO;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.ezey;
import net.minecraft.client.jgro;
import net.minecraft.client.jxsn;
import net.minecraft.client.jxtc;
import net.minecraft.client.particle.kjui;
import net.minecraft.client.pidb;
import net.minecraft.client.qlgf;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.eidj;
import net.minecraft.client.tupg;
import net.minecraft.client.ugqi;
import net.minecraft.client.ugqx;
import net.minecraft.client.vjta;
import net.minecraft.client.zwat;
import net.minecraft.client.zwaw;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.amww;
import net.minecraft.util.ezhm;
import net.minecraft.util.hank;
import net.minecraft.util.hanr;
import net.minecraft.util.pzde;
import net.minecraft.util.sajh;
import net.minecraft.util.samo;
import net.minecraft.util.srok;
import net.minecraft.util.tdpf;
import net.minecraft.util.turb;
import net.minecraft.util.uxqz;
import net.minecraft.util.vjsq;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
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
public class xpzm
implements ujun {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/title/mojang.png");
    public static final boolean _b = ezhm._a() == vjsq._d;
    public static byte[] _c = new byte[0xA00000];
    public static final List _d = Lists.newArrayList(new DisplayMode(2560, 1600), new DisplayMode(2880, 1800));
    public final jjmf _e;
    public final File _f;
    public htsm _g;
    public apbu _h;
    public static xpzm _i;
    public vlzh _j;
    public boolean _k;
    public boolean _l;
    public CrashReport _m;
    public int _n;
    public int _o;
    public tdpf _p = new tdpf(20.0f);
    public cfbu _q = new cfbu("client", this, dzfd.__aq());
    public pkix _r;
    public cvgz _s;
    public EntityClientPlayerMP _t;
    public EntityLivingBase _u;
    public EntityLivingBase _v;
    public kjui _w;
    public final hanr _x;
    public boolean _y;
    public qncw _z;
    public qncw _A;
    public gqjz _B;
    public uzug _C;
    public tfsl _D;
    public int _E;
    public int _F;
    public int _G;
    public yfci _H;
    public dhcu _I;
    public stiq _J;
    public boolean _K;
    public hank _L;
    public GameSettings _M;
    public jzqf _N;
    public pzde _O;
    public final File _P;
    public final File _Q;
    public final String _R;
    public final Proxy _S;
    public ozsq _T;
    public static int _U;
    public int _V;
    public boolean _W;
    public nwek _X;
    public String _Y;
    public int _Z;
    public boolean __aa;
    public boolean __ab;
    public long __ac = xpzm._M();
    public int __ad;
    public final boolean __ae;
    public jjpj __af;
    public boolean __ag;
    public final fokl __ah = new fokl();
    public long __ai = -1L;
    public ifzx __aj;
    public final rqxe __ak = new rqxe();
    public List __al = Lists.newArrayList();
    public vmay __am;
    public pknz __an;
    public gqvf __ao;
    public volatile boolean __ap = true;
    public String __aq = "";
    public long __ar = xpzm._M();
    public int __as;
    public long __at = -1L;
    public String __au = "root";
    public static int __av;

    public xpzm(hanr hanr2, int n, int n2, boolean bl, boolean bl2, File file, File file2, File file3, Proxy proxy, String string) {
        _i = this;
        this._e = new xbsz("Minecraft-Client", " [CLIENT]", new File(file, "output-client.log").getAbsolutePath());
        this._P = file;
        this._Q = file2;
        this._f = file3;
        this._R = string;
        this.__am = new vmay(this._Q);
        this._d();
        this._S = proxy;
        this._a();
        this._x = hanr2;
        this._e._a("Setting user: " + hanr2._a());
        this.__ae = bl2;
        this._n = n;
        this._o = n2;
        this._F = n;
        this._G = n2;
        this._k = bl;
        ImageIO.setUseCache(false);
        dzif._a();
    }

    public void _a() {
        ugqi ugqi2 = new ugqi(this, "Timer hack thread");
        ugqi2.setDaemon(true);
        ugqi2.start();
    }

    public void _a(CrashReport crashReport) {
        this._l = true;
        this._m = crashReport;
    }

    public void _b(CrashReport crashReport) {
        File file = new File(xpzm._E()._P, "crash-reports");
        File file2 = new File(file, "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-client.txt");
        System.out.println(crashReport.func_71502_e());
        if (crashReport.func_71497_f() != null) {
            System.out.println("#@!@# Game crashed! Crash report saved to: #@!@# " + crashReport.func_71497_f());
            System.exit(-1);
        } else if (crashReport.func_71508_a(file2, this._O())) {
            System.out.println("#@!@# Game crashed! Crash report saved to: #@!@# " + file2.getAbsolutePath());
            System.exit(-1);
        } else {
            System.out.println("#@?@# Game crashed! Crash report could not be saved. #@?@#");
            System.exit(-2);
        }
    }

    public void _a(String string, int n) {
        this._Y = string;
        this._Z = n;
    }

    public void _b() throws LWJGLException {
        this._M = new GameSettings(this, this._P);
        if (this._M.field_92119_C > 0 && this._M.field_92118_B > 0) {
            this._n = this._M.field_92118_B;
            this._o = this._M.field_92119_C;
        }
        if (this._k) {
            Display.setFullscreen(true);
            this._n = Display.getDisplayMode().getWidth();
            this._o = Display.getDisplayMode().getHeight();
            if (this._n <= 0) {
                this._n = 1;
            }
            if (this._o <= 0) {
                this._o = 1;
            }
        } else {
            Display.setDisplayMode(new DisplayMode(this._n, this._o));
        }
        Display.setResizable(true);
        Display.setTitle("Minecraft 1.6.4");
        this._O()._a("LWJGL Version: " + Sys.getVersion());
        if (ezhm._a() != vjsq._d) {
            try {
                Display.setIcon(new ByteBuffer[]{this._a(new File(this._Q, "/icons/icon_16x16.png")), this._a(new File(this._Q, "/icons/icon_32x32.png"))});
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        try {
            ForgeHooksClient.createDisplay();
        }
        catch (LWJGLException lWJGLException) {
            lWJGLException.printStackTrace();
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            if (this._k) {
                this._e();
            }
            Display.create();
        }
        iwya._a();
        this._I = new dhcu(this);
        this.__ak._a(new zyow(), dyqm.class);
        this.__ak._a(new wpgl(), oyqc.class);
        this.__ak._a(new bski(), htxz.class);
        this.__ak._a(new yvlu(), yekc.class);
        this.__ak._a(new yekq(), bbim.class);
        this._T = new mtel(new File(this._P, "saves"));
        this.__an = new pknz(this._f, this.__am, this.__ak, this._M);
        this.__aj = new scvi(this.__ak);
        this.__ao = new gqvf(this.__ak, this._M.field_74363_ab);
        this.__aj._a(this.__ao);
        this._c();
        this._h = new apbu(this.__aj);
        this.__aj._a(this._h);
        this._N = new jzqf(this.__aj, this._M, this._Q);
        this._N._a = false;
        this.__aj._a(this._N);
        this._f();
        this._z = new qncw(this._M, new ResourceLocation("textures/font/ascii.png"), this._h, false);
        FMLClientHandler.instance().beginMinecraftLoading(this, this.__al, this.__aj);
        if (this._M.field_74363_ab != null) {
            this._z._a(this.__ao._a());
            this._z._b(this.__ao._b());
        }
        this._A = new qncw(this._M, new ResourceLocation("textures/font/ascii_sga.png"), this._h, false);
        this.__aj._a(this._z);
        this.__aj._a(this._A);
        this.__aj._a(new xbes());
        this.__aj._a(new fnsz());
        gqqu._b._h = new jizq(this);
        this._D = new tfsl(this);
        this._X = new nwek(this._x, this._P);
        sdqa._f.func_75988_a(new jxsn(this));
        this._O = new pzde();
        this._a("Pre startup");
        GL11.glEnable(3553);
        GL11.glShadeModel(7425);
        GL11.glClearDepth(1.0);
        GL11.glEnable(2929);
        GL11.glDepthFunc(515);
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, 0.1f);
        GL11.glCullFace(1029);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        this._a("Startup");
        this._s = new cvgz(this);
        this._h._a(sctd._c, new sctd(0, "textures/blocks"));
        this._h._a(sctd._e, new sctd(1, "textures/items"));
        GL11.glViewport(0, 0, this._n, this._o);
        this._w = new kjui(this._r, this._h);
        FMLClientHandler.instance().finishMinecraftLoading();
        this._a("Post startup");
        this._J = new GuiIngameForge(this);
        if (this._Y != null) {
            this._a(new fnnc(new fngq(), this, this._Y, this._Z));
        } else {
            this._a(new fngq());
        }
        this._C = new uzug(this);
        if (this._M.field_74353_u && !this._k) {
            this._r();
        }
        FMLClientHandler.instance().onInitializationComplete();
    }

    public void _c() {
        ArrayList<fnrl> arrayList = Lists.newArrayList(this.__al);
        for (yehh yehh2 : this.__an._e()) {
            arrayList.add(yehh2._c());
        }
        this.__ao._a(arrayList);
        this.__aj._a(arrayList);
        if (this._s != null) {
            this._s._b();
        }
    }

    public void _d() {
        this.__al.add(this.__am);
    }

    public ByteBuffer _a(File file) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(file);
        int[] nArray = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 * nArray.length);
        int[] nArray2 = nArray;
        int n = nArray.length;
        for (int i = 0; i < n; ++i) {
            int n2 = nArray2[i];
            byteBuffer.putInt(n2 << 8 | n2 >> 24 & 0xFF);
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    public void _e() throws LWJGLException {
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, Display.getAvailableDisplayModes());
        DisplayMode displayMode = Display.getDesktopDisplayMode();
        if (!hashSet.contains(displayMode) && ezhm._a() == vjsq._d) {
            block0: for (DisplayMode displayMode2 : _d) {
                boolean bl = true;
                for (DisplayMode displayMode3 : hashSet) {
                    if (displayMode3.getBitsPerPixel() != 32 || displayMode3.getWidth() != displayMode2.getWidth() || displayMode3.getHeight() != displayMode2.getHeight()) continue;
                    bl = false;
                    break;
                }
                if (bl) continue;
                for (DisplayMode displayMode3 : hashSet) {
                    if (displayMode3.getBitsPerPixel() != 32 || displayMode3.getWidth() != displayMode2.getWidth() / 2 || displayMode3.getHeight() != displayMode2.getHeight() / 2) continue;
                    displayMode = displayMode3;
                    continue block0;
                }
            }
        }
        Display.setDisplayMode(displayMode);
        this._n = displayMode.getWidth();
        this._o = displayMode.getHeight();
    }

    public void _f() throws LWJGLException {
        htou htou2 = new htou(this._M, this._n, this._o);
        GL11.glClear(16640);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, htou2._c(), htou2._d(), 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
        GL11.glViewport(0, 0, this._n, this._o);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glDisable(2896);
        GL11.glEnable(3553);
        GL11.glDisable(2912);
        this._h._a(_a);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78378_d(0xFFFFFF);
        htvf2.func_78374_a(0.0, this._o, 0.0, 0.0, 0.0);
        htvf2.func_78374_a(this._n, this._o, 0.0, 0.0, 0.0);
        htvf2.func_78374_a(this._n, 0.0, 0.0, 0.0, 0.0);
        htvf2.func_78374_a(0.0, 0.0, 0.0, 0.0, 0.0);
        htvf2.func_78381_a();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        htvf2.func_78378_d(0xFFFFFF);
        int n = 256;
        int n2 = 256;
        this._a((htou2._a() - n) / 2, (htou2._b() - n2) / 2, 0, 0, n, n2);
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, 0.1f);
        Display.update();
    }

    public void _a(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = 0.00390625f;
        float f2 = 0.00390625f;
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(n + 0, n2 + n6, 0.0, (float)(n3 + 0) * f, (float)(n4 + n6) * f2);
        htvf2.func_78374_a(n + n5, n2 + n6, 0.0, (float)(n3 + n5) * f, (float)(n4 + n6) * f2);
        htvf2.func_78374_a(n + n5, n2 + 0, 0.0, (float)(n3 + n5) * f, (float)(n4 + 0) * f2);
        htvf2.func_78374_a(n + 0, n2 + 0, 0.0, (float)(n3 + 0) * f, (float)(n4 + 0) * f2);
        htvf2.func_78381_a();
    }

    public ozsq _g() {
        return this._T;
    }

    public void _a(gqjz gqjz2) {
        this._X._b();
        if (gqjz2 == null && this._r == null) {
            gqjz2 = new fngq();
        } else if (gqjz2 == null && this._t.func_110143_aJ() <= 0.0f) {
            gqjz2 = new jzpo();
        }
        gqjz gqjz3 = this._B;
        GuiOpenEvent guiOpenEvent = new GuiOpenEvent(gqjz2);
        if (MinecraftForge.EVENT_BUS.post(guiOpenEvent)) {
            return;
        }
        gqjz2 = guiOpenEvent.gui;
        if (gqjz3 != null && gqjz2 != gqjz3) {
            gqjz3.func_73874_b();
        }
        if (gqjz2 instanceof fngq) {
            this._M.field_74330_P = false;
            this._J.func_73827_b()._a();
        }
        this._B = gqjz2;
        if (gqjz2 != null) {
            this._p();
            htou htou2 = new htou(this._M, this._n, this._o);
            int n = htou2._a();
            int n2 = htou2._b();
            gqjz2.func_73872_a(this, n, n2);
            this._K = false;
        } else {
            this._o();
        }
    }

    public void _a(String string) {
        int n = GL11.glGetError();
        if (n != 0) {
            String string2 = GLU.gluErrorString(n);
            this._O()._c("########## GL ERROR ##########");
            this._O()._c("@ " + string);
            this._O()._c(n + ": " + string2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _h() {
        try {
            this._X._b();
            this._O()._a("Stopping!");
            try {
                this._a((pkix)null);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                pklh._b();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            this._N._d();
        }
        finally {
            Display.destroy();
            if (!this._l) {
                System.exit(0);
            }
        }
        System.gc();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _i() {
        this.__ap = true;
        try {
            this._b();
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Initializing game");
            crashReport.func_85058_a("Initialization");
            this._b(this._c(crashReport));
            return;
        }
        try {
            while (this.__ap) {
                if (!this.__ap) continue;
                if (this._l && this._m != null) {
                    this._b(this._m);
                    return;
                }
                if (this._W) {
                    this._W = false;
                    this._c();
                }
                try {
                    this._j();
                }
                catch (OutOfMemoryError outOfMemoryError) {
                    this._l();
                    this._a(new hcld());
                    System.gc();
                }
            }
        }
        catch (uxqz uxqz2) {
        }
        catch (turb turb2) {
            this._c(turb2._a());
            this._l();
            turb2.printStackTrace();
            this._b(turb2._a());
        }
        catch (Throwable throwable) {
            CrashReport crashReport = this._c(new CrashReport("Unexpected error", throwable));
            this._l();
            throwable.printStackTrace();
            this._b(crashReport);
        }
        finally {
            this._h();
        }
    }

    public void _j() {
        net.minecraft.util.eidj._a()._a();
        if (this._r != null) {
            this._r.func_82732_R()._a();
        }
        this.__ah._a("root");
        if (Display.isCloseRequested()) {
            this._n();
        }
        if (this._y && this._r != null) {
            float f = this._p._d;
            this._p._a();
            this._p._d = f;
        } else {
            this._p._a();
        }
        long l = System.nanoTime();
        this.__ah._a("tick");
        for (int i = 0; i < this._p._c; ++i) {
            this._s();
        }
        this.__ah._c("preRenderErrors");
        long l2 = System.nanoTime() - l;
        this._a("Pre render");
        htvc._e = this._M.field_74347_j;
        this.__ah._c("sound");
        this._N._a(this._t, this._p._d);
        if (!this._y) {
            this._N._i();
        }
        this.__ah._b();
        this.__ah._a("render");
        this.__ah._a("display");
        GL11.glEnable(3553);
        if (!Keyboard.isKeyDown(65)) {
            Display.update();
        }
        if (this._t != null && this._t.func_70094_T()) {
            this._M.field_74320_O = 0;
        }
        this.__ah._b();
        if (!this._K) {
            FMLCommonHandler.instance().onRenderTickStart(this._p._d);
            this.__ah._c("gameRenderer");
            this._D.func_78480_b(this._p._d);
            this.__ah._b();
            FMLCommonHandler.instance().onRenderTickEnd(this._p._d);
        }
        GL11.glFlush();
        this.__ah._b();
        if (!Display.isActive() && this._k) {
            this._r();
        }
        if (this._M.field_74330_P && this._M.field_74329_Q) {
            if (!this.__ah._c) {
                this.__ah._a();
            }
            this.__ah._c = true;
            this._a(l2);
        } else {
            this.__ah._c = false;
            this.__at = System.nanoTime();
        }
        this._I._b();
        this.__ah._a("root");
        Thread.yield();
        if (Keyboard.isKeyDown(65)) {
            Display.update();
        }
        this._m();
        if (!this._k && Display.wasResized()) {
            this._n = Display.getWidth();
            this._o = Display.getHeight();
            if (this._n <= 0) {
                this._n = 1;
            }
            if (this._o <= 0) {
                this._o = 1;
            }
            this._a(this._n, this._o);
        }
        this._a("Post render");
        ++this.__as;
        boolean bl = this._y;
        boolean bl2 = this._y = this._I() && this._B != null && this._B.func_73868_f() && !this._H._b();
        if (this._H() && this._t != null && this._t.field_71174_a != null && this._y != bl) {
            ((tgls)this._t.field_71174_a._d())._a(this._y);
        }
        while (xpzm._M() >= this.__ar + 1000L) {
            _U = this.__as;
            this.__aq = _U + " fps, " + nvgj.field_78922_b + " chunk updates";
            nvgj.field_78922_b = 0;
            this.__ar += 1000L;
            this.__as = 0;
            this._q._d();
            if (this._q._f()) continue;
            this._q._a();
        }
        this.__ah._b();
        if (this._k() > 0) {
            Display.sync(tfsl.func_78465_a(this._k()));
        }
        gloomyfolken.mods.bundle.pidb._a(this);
    }

    public int _k() {
        return this._B != null && this._B instanceof fngq ? 2 : this._M.field_74350_i;
    }

    public void _l() {
        try {
            _c = new byte[0];
            this._s._f();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            System.gc();
            net.minecraft.util.eidj._a()._b();
            this._r.func_82732_R()._b();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            System.gc();
            this._a((pkix)null);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        System.gc();
    }

    public void _m() {
        if (Keyboard.isKeyDown(60)) {
            if (!this.__aa) {
                this.__aa = true;
                this._J.func_73827_b()._a(srok._a(this._P, this._n, this._o));
            }
        } else {
            this.__aa = false;
        }
    }

    public void _a(int n) {
        List list = this.__ah._b(this.__au);
        if (list != null && !list.isEmpty()) {
            qojt qojt2 = (qojt)list.remove(0);
            if (n == 0) {
                int n2;
                if (qojt2._c.length() > 0 && (n2 = this.__au.lastIndexOf(".")) >= 0) {
                    this.__au = this.__au.substring(0, n2);
                }
            } else if (--n < list.size() && !((qojt)list.get((int)n))._c.equals("unspecified")) {
                if (this.__au.length() > 0) {
                    this.__au = this.__au + ".";
                }
                this.__au = this.__au + ((qojt)list.get((int)n))._c;
            }
        }
    }

    public void _a(long l) {
        if (this.__ah._c) {
            int n;
            int n2;
            Object object;
            List list = this.__ah._b(this.__au);
            qojt qojt2 = (qojt)list.remove(0);
            GL11.glClear(256);
            GL11.glMatrixMode(5889);
            GL11.glEnable(2903);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, this._n, this._o, 0.0, 1000.0, 3000.0);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
            GL11.glLineWidth(1.0f);
            GL11.glDisable(3553);
            htvf htvf2 = htvf.field_78398_a;
            int n3 = 160;
            int n4 = this._n - n3 - 10;
            int n5 = this._o - n3 * 2;
            GL11.glEnable(3042);
            htvf2.func_78382_b();
            htvf2.func_78384_a(0, 200);
            htvf2.func_78377_a((float)n4 - (float)n3 * 1.1f, (float)n5 - (float)n3 * 0.6f - 16.0f, 0.0);
            htvf2.func_78377_a((float)n4 - (float)n3 * 1.1f, n5 + n3 * 2, 0.0);
            htvf2.func_78377_a((float)n4 + (float)n3 * 1.1f, n5 + n3 * 2, 0.0);
            htvf2.func_78377_a((float)n4 + (float)n3 * 1.1f, (float)n5 - (float)n3 * 0.6f - 16.0f, 0.0);
            htvf2.func_78381_a();
            GL11.glDisable(3042);
            double d = 0.0;
            for (int i = 0; i < list.size(); ++i) {
                float f;
                float f2;
                float f3;
                object = (qojt)list.get(i);
                n2 = sajh._c(((qojt)object)._a / 4.0) + 1;
                htvf2.func_78371_b(6);
                htvf2.func_78378_d(((qojt)object)._a());
                htvf2.func_78377_a(n4, n5, 0.0);
                for (n = n2; n >= 0; --n) {
                    f3 = (float)((d + ((qojt)object)._a * (double)n / (double)n2) * Math.PI * 2.0 / 100.0);
                    f2 = sajh._a(f3) * (float)n3;
                    f = sajh._b(f3) * (float)n3 * 0.5f;
                    htvf2.func_78377_a((float)n4 + f2, (float)n5 - f, 0.0);
                }
                htvf2.func_78381_a();
                htvf2.func_78371_b(5);
                htvf2.func_78378_d((((qojt)object)._a() & 0xFEFEFE) >> 1);
                for (n = n2; n >= 0; --n) {
                    f3 = (float)((d + ((qojt)object)._a * (double)n / (double)n2) * Math.PI * 2.0 / 100.0);
                    f2 = sajh._a(f3) * (float)n3;
                    f = sajh._b(f3) * (float)n3 * 0.5f;
                    htvf2.func_78377_a((float)n4 + f2, (float)n5 - f, 0.0);
                    htvf2.func_78377_a((float)n4 + f2, (float)n5 - f + 10.0f, 0.0);
                }
                htvf2.func_78381_a();
                d += ((qojt)object)._a;
            }
            DecimalFormat decimalFormat = new DecimalFormat("##0.00");
            GL11.glEnable(3553);
            object = "";
            if (!qojt2._c.equals("unspecified")) {
                object = (String)object + "[0] ";
            }
            object = qojt2._c.length() == 0 ? (String)object + "ROOT " : (String)object + qojt2._c + " ";
            n2 = 0xFFFFFF;
            this._z._a((String)object, n4 - n3, n5 - n3 / 2 - 16, n2);
            object = decimalFormat.format(qojt2._b) + "%";
            this._z._a((String)object, n4 + n3 - this._z._b((String)object), n5 - n3 / 2 - 16, n2);
            for (n = 0; n < list.size(); ++n) {
                qojt qojt3 = (qojt)list.get(n);
                String string = "";
                string = qojt3._c.equals("unspecified") ? string + "[?] " : string + "[" + (n + 1) + "] ";
                string = string + qojt3._c;
                this._z._a(string, n4 - n3, n5 + n3 / 2 + n * 8 + 20, qojt3._a());
                string = decimalFormat.format(qojt3._a) + "%";
                this._z._a(string, n4 + n3 - 50 - this._z._b(string), n5 + n3 / 2 + n * 8 + 20, qojt3._a());
                string = decimalFormat.format(qojt3._b) + "%";
                this._z._a(string, n4 + n3 - this._z._b(string), n5 + n3 / 2 + n * 8 + 20, qojt3._a());
            }
        }
    }

    public void _n() {
        this.__ap = false;
    }

    public void _o() {
        if (Display.isActive() && !this.__ab) {
            this.__ab = true;
            this._O._a();
            this._a((gqjz)null);
            this._E = 10000;
        }
    }

    public void _p() {
        boolean bl = GloomyHooks.setIngameNotInFocus(this);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        if (this.__ab) {
            eidj._a();
            this.__ab = false;
            this._O._b();
        }
    }

    public void _q() {
        if (this._B == null) {
            this._a(new htjl());
            if (this._I() && !this._H._b()) {
                this._N._g();
            }
        }
    }

    public void _a(int n, boolean bl) {
        if (!bl) {
            this._E = 0;
        }
        if (n != 0 || this._E <= 0) {
            if (bl && this._L != null && this._L._c == amww._a && n == 0) {
                int n2 = this._L._d;
                int n3 = this._L._e;
                int n4 = this._L._f;
                this._j._c(n2, n3, n4, this._L._g);
                if (this._t.func_82246_f(n2, n3, n4)) {
                    this._w._a(n2, n3, n4, this._L);
                    this._t.func_71038_i();
                }
            } else {
                this._j._c();
            }
        }
    }

    public void _b(int n) {
        if (n != 0 || this._E <= 0) {
            int n2;
            if (n == 0) {
                this._t.func_71038_i();
            }
            if (n == 1) {
                this._V = 4;
            }
            boolean bl = true;
            cvzo cvzo2 = this._t.field_71071_by._a();
            if (this._L == null) {
                if (n == 0 && this._j._h()) {
                    this._E = 10;
                }
            } else if (this._L._c == amww._b) {
                if (n == 0) {
                    this._j._a(this._t, this._L._i);
                }
                if (n == 1 && this._j._b(this._t, this._L._i)) {
                    bl = false;
                }
            } else if (this._L._c == amww._a) {
                int n3 = this._L._d;
                n2 = this._L._e;
                int n4 = this._L._f;
                int n5 = this._L._g;
                if (n == 0) {
                    this._j._b(n3, n2, n4, this._L._g);
                } else {
                    boolean bl2;
                    int n6 = cvzo2 != null ? cvzo2._b : 0;
                    boolean bl3 = bl2 = !ForgeEventFactory.onPlayerInteract(this._t, PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK, n3, n2, n4, n5).isCanceled();
                    if (bl2 && this._j._a(this._t, this._r, cvzo2, n3, n2, n4, n5, this._L._h)) {
                        bl = false;
                        this._t.func_71038_i();
                    }
                    if (cvzo2 == null) {
                        return;
                    }
                    if (cvzo2._b == 0) {
                        this._t.field_71071_by._a[this._t.field_71071_by._c] = null;
                    } else if (cvzo2._b != n6 || this._j._i()) {
                        this._D.field_78516_c.func_78444_b();
                    }
                }
            }
            if (bl && n == 1) {
                cvzo cvzo3 = this._t.field_71071_by._a();
                int n7 = n2 = !ForgeEventFactory.onPlayerInteract(this._t, PlayerInteractEvent.Action.RIGHT_CLICK_AIR, 0, 0, 0, -1).isCanceled() ? 1 : 0;
                if (n2 != 0 && cvzo3 != null && this._j._a(this._t, this._r, cvzo3)) {
                    this._D.field_78516_c.func_78445_c();
                }
            }
        }
    }

    public void _r() {
        try {
            boolean bl = this._k = !this._k;
            if (this._k) {
                this._e();
                this._n = Display.getDisplayMode().getWidth();
                this._o = Display.getDisplayMode().getHeight();
                if (this._n <= 0) {
                    this._n = 1;
                }
                if (this._o <= 0) {
                    this._o = 1;
                }
            } else {
                Display.setDisplayMode(new DisplayMode(this._F, this._G));
                this._n = this._F;
                this._o = this._G;
                if (this._n <= 0) {
                    this._n = 1;
                }
                if (this._o <= 0) {
                    this._o = 1;
                }
            }
            if (this._B != null) {
                this._a(this._n, this._o);
            }
            Display.setFullscreen(this._k);
            Display.setVSyncEnabled(this._M.field_74352_v);
            Display.update();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void _a(int n, int n2) {
        this._n = n <= 0 ? 1 : n;
        int n3 = this._o = n2 <= 0 ? 1 : n2;
        if (this._B != null) {
            htou htou2 = new htou(this._M, n, n2);
            int n4 = htou2._a();
            int n5 = htou2._b();
            this._B.func_73872_a(this, n4, n5);
        }
    }

    public void _s() {
        KeyboardListener.listen();
        FMLCommonHandler.instance().rescheduleTicks(Side.CLIENT);
        if (this._V > 0) {
            --this._V;
        }
        FMLCommonHandler.instance().onPreClientTick();
        this.__ah._a("stats");
        this._X._c();
        this.__ah._c("gui");
        if (!this._y) {
            this._J.func_73831_a();
        }
        this.__ah._c("pick");
        this._D.func_78473_a(1.0f);
        this.__ah._c("gameMode");
        if (!this._y && this._r != null) {
            this._j._e();
        }
        this.__ah._c("textures");
        if (!this._y) {
            this._h.func_110550_d();
        }
        if (this._B == null && this._t != null) {
            if (this._t.func_110143_aJ() <= 0.0f) {
                this._a((gqjz)null);
            } else if (this._t.func_70608_bn() && this._r != null) {
                this._a(new jiqj());
            }
        } else if (this._B != null && this._B instanceof jiqj && !this._t.func_70608_bn()) {
            this._a((gqjz)null);
        }
        if (this._B != null) {
            this._E = 10000;
        }
        if (this._B != null) {
            try {
                this._B.func_73862_m();
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.func_85055_a(throwable, "Updating screen events");
                net.minecraft.crash.jxsn jxsn2 = crashReport.func_85058_a("Affected screen");
                jxsn2._a("Screen name", new ugqx(this));
                throw new turb(crashReport);
            }
            if (this._B != null) {
                try {
                    this._B.func_73876_c();
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.func_85055_a(throwable, "Ticking screen");
                    net.minecraft.crash.jxsn jxsn3 = crashReport.func_85058_a("Affected screen");
                    jxsn3._a("Screen name", new tupg(this));
                    throw new turb(crashReport);
                }
            }
        }
        if (this._B == null || this._B.field_73885_j) {
            boolean bl;
            int n;
            this.__ah._c("mouse");
            while (Mouse.next()) {
                long l;
                if (ForgeHooksClient.postMouseEvent()) continue;
                n = Mouse.getEventButton();
                if (_b && n == 0 && (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157))) {
                    n = 1;
                }
                eidj._a(n - 100, Mouse.getEventButtonState());
                if (Mouse.getEventButtonState()) {
                    eidj._a(n - 100);
                }
                if ((l = xpzm._M() - this.__ac) > 200L) continue;
                int n2 = Mouse.getEventDWheel();
                if (n2 != 0) {
                    this._t.field_71071_by._b(n2);
                    if (this._M.field_74331_S) {
                        if (n2 > 0) {
                            n2 = 1;
                        }
                        if (n2 < 0) {
                            n2 = -1;
                        }
                        this._M.field_74328_V += (float)n2 * 0.25f;
                    }
                }
                if (this._B == null) {
                    if (this.__ab || !Mouse.getEventButtonState()) continue;
                    this._o();
                    continue;
                }
                if (this._B == null) continue;
                this._B.func_73867_d();
            }
            if (this._E > 0) {
                --this._E;
            }
            this.__ah._c("keyboard");
            while (Keyboard.next()) {
                eidj._a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
                if (Keyboard.getEventKeyState()) {
                    eidj._a(Keyboard.getEventKey());
                }
                if (this.__ai > 0L) {
                    if (xpzm._M() - this.__ai >= 6000L) {
                        throw new turb(new CrashReport("Manually triggered debug crash", new Throwable()));
                    }
                    if (!Keyboard.isKeyDown(46) || !Keyboard.isKeyDown(61)) {
                        this.__ai = -1L;
                    }
                } else if (Keyboard.isKeyDown(46) && Keyboard.isKeyDown(61)) {
                    this.__ai = xpzm._M();
                }
                if (!Keyboard.getEventKeyState()) continue;
                if (Keyboard.getEventKey() == 87) {
                    this._r();
                    continue;
                }
                if (this._B != null) {
                    this._B.func_73860_n();
                } else {
                    if (Keyboard.getEventKey() == 1) {
                        this._q();
                    }
                    if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61)) {
                        this._c();
                    }
                    if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61)) {
                        this._c();
                    }
                    if (Keyboard.getEventKey() == 33 && Keyboard.isKeyDown(61)) {
                        bl = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
                        this._M.func_74306_a(net.minecraft.client.settings.kjui._g, bl ? -1 : 1);
                    }
                    if (Keyboard.getEventKey() == 30 && Keyboard.isKeyDown(61)) {
                        this._s._b();
                    }
                    if (Keyboard.getEventKey() == 35 && Keyboard.isKeyDown(61)) {
                        this._M.field_82882_x = !this._M.field_82882_x;
                        this._M.func_74303_b();
                    }
                    if (Keyboard.getEventKey() == 48 && Keyboard.isKeyDown(61)) {
                        boolean bl2 = gqqu._r = !gqqu._r;
                    }
                    if (Keyboard.getEventKey() == 25 && Keyboard.isKeyDown(61)) {
                        this._M.field_82881_y = !this._M.field_82881_y;
                        this._M.func_74303_b();
                    }
                    if (Keyboard.getEventKey() == 59) {
                        boolean bl3 = this._M.field_74319_N = !this._M.field_74319_N;
                    }
                    if (Keyboard.getEventKey() == 61) {
                        this._M.field_74330_P = !this._M.field_74330_P;
                        this._M.field_74329_Q = gqjz.func_73877_p();
                    }
                    if (Keyboard.getEventKey() == 63) {
                        ++this._M.field_74320_O;
                        if (this._M.field_74320_O > 2) {
                            this._M.field_74320_O = 0;
                        }
                    }
                    if (Keyboard.getEventKey() == 66) {
                        this._M.field_74326_T = !this._M.field_74326_T;
                    }
                }
                for (n = 0; n < 9; ++n) {
                    if (Keyboard.getEventKey() != 2 + n) continue;
                    this._t.field_71071_by._c = n;
                }
                if (!this._M.field_74330_P || !this._M.field_74329_Q) continue;
                if (Keyboard.getEventKey() == 11) {
                    this._a(0);
                }
                for (n = 0; n < 9; ++n) {
                    if (Keyboard.getEventKey() != 2 + n) continue;
                    this._a(n + 1);
                }
            }
            boolean bl4 = bl = this._M.field_74343_n != 2;
            while (this._M.field_74315_B._c()) {
                if (this._j._k()) {
                    this._t.func_110322_i();
                    continue;
                }
                this._a(new cebg(this._t));
            }
            while (this._M.field_74316_C._c()) {
                this._t.func_71040_bB(gqjz.func_73861_o());
            }
            while (this._M.field_74310_D._c() && bl) {
                this._a(new fndz());
            }
            if (this._B == null && this._M.field_74323_J._c() && bl) {
                this._a(new fndz("/"));
            }
            if (this._t.func_71039_bw()) {
                if (!this._M.field_74313_G._e) {
                    this._j._c(this._t);
                }
                while (this._M.field_74312_F._c()) {
                }
                while (this._M.field_74313_G._c()) {
                }
                while (this._M.field_74322_I._c()) {
                }
            } else {
                while (this._M.field_74312_F._c()) {
                    this._b(0);
                }
                while (this._M.field_74313_G._c()) {
                    this._b(1);
                }
                while (this._M.field_74322_I._c()) {
                    this._D();
                }
            }
            if (this._M.field_74313_G._e && this._V == 0 && !this._t.func_71039_bw()) {
                this._b(1);
            }
            this._a(0, this._B == null && this._M.field_74312_F._e && this.__ab);
        }
        if (this._r != null) {
            if (this._t != null) {
                ++this.__ad;
                if (this.__ad == 30) {
                    this.__ad = 0;
                    this._r.func_72897_h(this._t);
                }
            }
            this.__ah._c("gameRenderer");
            if (!this._y) {
                this._D.func_78464_a();
            }
            this.__ah._c("levelRenderer");
            if (!this._y) {
                this._s._e();
            }
            this.__ah._c("level");
            if (!this._y) {
                if (this._r.field_73016_r > 0) {
                    --this._r.field_73016_r;
                }
                this._r.func_72939_s();
            }
            if (!this._y) {
                this._r.func_72891_a(this._r.field_73013_u > 0, true);
                try {
                    this._r.func_72835_b();
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception in world tick");
                    if (this._r == null) {
                        net.minecraft.crash.jxsn jxsn4 = crashReport.func_85058_a("Affected level");
                        jxsn4._a("Problem", "Level is null!");
                    } else {
                        this._r.func_72914_a(crashReport);
                    }
                    throw new turb(crashReport);
                }
            }
            this.__ah._c("animateTick");
            if (!this._y && this._r != null) {
                this._r._a(sajh._c(this._t.field_70165_t), sajh._c(this._t.field_70163_u), sajh._c(this._t.field_70161_v));
            }
            this.__ah._c("particles");
            if (!this._y) {
                this._w._a();
            }
        } else if (this.__af != null) {
            this.__ah._c("pendingConnection");
            this.__af._b();
        }
        FMLCommonHandler.instance().onPostClientTick();
        this.__ah._b();
        this.__ac = xpzm._M();
    }

    public void _a(String string, String string2, nfhj nfhj2) {
        this._a((pkix)null);
        System.gc();
        mtms mtms2 = this._T._a(string, false);
        iyev iyev2 = mtms2.func_75757_d();
        if (iyev2 == null && nfhj2 != null) {
            iyev2 = new iyev(nfhj2, string);
            mtms2.func_75761_a(iyev2);
        }
        if (nfhj2 == null) {
            nfhj2 = new nfhj(iyev2);
        }
        this._X._a(dzif._f, 1);
        GameData.initializeServerGate(2);
        this._H = new yfci(this, string, string2, nfhj2);
        this._H._F();
        MapDifference<Integer, ItemData> mapDifference = GameData.gateWorldLoadingForValidation();
        if (mapDifference != null) {
            FMLClientHandler.instance().warnIDMismatch(mapDifference, true);
        } else {
            GameData.releaseGate(true);
            this._t();
        }
    }

    public void _t() {
        Object object;
        this.__ag = true;
        this._C._b(wpcz._a("menu.loadingLevel"));
        while (!this._H.__ai()) {
            object = this._H._o();
            if (object != null) {
                this._C._d(wpcz._a((String)object));
            } else {
                this._C._d("");
            }
            try {
                Thread.sleep(200L);
            }
            catch (InterruptedException interruptedException) {}
        }
        this._a((gqjz)null);
        try {
            object = new bscn(this, this._H);
            this.__af = ((bscn)object)._d();
        }
        catch (IOException iOException) {
            this._b(this._c(new CrashReport("Connecting to integrated server", iOException)));
        }
    }

    public void _a(pkix pkix2) {
        this._a(pkix2, "");
    }

    public void _a(pkix pkix2, String string) {
        GloomyHooks.loadWorld(this, pkix2, string);
        this._X._b();
        if (this._r != null) {
            MinecraftForge.EVENT_BUS.post(new WorldEvent.Unload(this._r));
        }
        if (pkix2 == null) {
            bscn bscn2 = this._z();
            if (bscn2 != null) {
                bscn2._a();
            }
            if (this.__af != null) {
                this.__af._f();
            }
            if (this._H != null) {
                this._H._z();
                if (this._C != null) {
                    this._C._d("Shutting down internal server...");
                }
                while (!this._H.__af()) {
                    try {
                        Thread.sleep(10L);
                    }
                    catch (InterruptedException interruptedException) {}
                }
            }
            this._H = null;
        }
        this._u = null;
        this.__af = null;
        if (this._C != null) {
            this._C._a(string);
            this._C._d("");
        }
        if (pkix2 == null && this._r != null) {
            this._a((htsm)null);
            this.__ag = false;
        }
        this._N._a(null, 0.0f, 0.0f, 0.0f);
        this._N._f();
        this._r = pkix2;
        if (pkix2 != null) {
            if (this._s != null) {
                this._s._a(pkix2);
            }
            if (this._w != null) {
                this._w._a(pkix2);
            }
            if (this._t == null) {
                this._t = this._j._a(pkix2);
                this._j._b(this._t);
            }
            this._t.func_70065_x();
            pkix2.func_72838_d(this._t);
            this._t.field_71158_b = new samo(this._M);
            this._j._a(this._t);
            this._u = this._t;
        } else {
            this._T._c();
            this._t = null;
        }
        System.gc();
        this.__ac = 0L;
    }

    public String _u() {
        return this._s._c();
    }

    public String _v() {
        return this._s._d();
    }

    public String _w() {
        return this._r.func_72827_u();
    }

    public String _x() {
        return "P: " + this._w._b() + ". T: " + this._r.func_72981_t();
    }

    public void _c(int n) {
        GloomyHooks.setDimensionAndSpawnPlayer(this, n);
        this._r.func_72974_f();
        this._r._a();
        int n2 = 0;
        String string = null;
        if (this._t != null) {
            n2 = this._t.field_70157_k;
            this._r.func_72900_e(this._t);
            string = this._t.func_142021_k();
        }
        this._u = null;
        this._t = this._j._a(this._r);
        this._t.field_71093_bK = n;
        this._u = this._t;
        this._t.func_70065_x();
        this._t.func_142020_c(string);
        this._r.func_72838_d(this._t);
        this._j._b(this._t);
        this._t.field_71158_b = new samo(this._M);
        this._t.field_70157_k = n2;
        this._j._a(this._t);
        if (this._B instanceof jzpo) {
            this._a((gqjz)null);
        }
    }

    public final boolean _y() {
        return this.__ae;
    }

    public bscn _z() {
        return this._t != null ? this._t.field_71174_a : null;
    }

    public static boolean _A() {
        return _i == null || !xpzm._i._M.field_74319_N;
    }

    public static boolean _B() {
        return _i != null && xpzm._i._M.field_74347_j;
    }

    public static boolean _C() {
        return _i != null && xpzm._i._M.field_74348_k != 0;
    }

    public boolean _b(String string) {
        return ClientCommandHandler.instance.func_71556_a(this._t, string) == 1;
    }

    public void _D() {
        boolean bl = GloomyHooks.clickMiddleMouseButton(this);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        if (this._L != null) {
            bl = this._t.field_71075_bZ._d;
            if (!ForgeHooks.onPickBlock(this._L, this._t, this._r)) {
                return;
            }
            if (bl) {
                int n = this._t.field_71069_bz.field_75151_b.size() - 9 + this._t.field_71071_by._c;
                this._j._a(this._t.field_71071_by.func_70301_a(this._t.field_71071_by._c), n);
            }
        }
    }

    public CrashReport _c(CrashReport crashReport) {
        crashReport.func_85056_g()._a("Launched Version", new zwaw(this));
        crashReport.func_85056_g()._a("LWJGL", new zwat(this));
        crashReport.func_85056_g()._a("OpenGL", new ezey(this));
        crashReport.func_85056_g()._a("Is Modded", new jgro(this));
        crashReport.func_85056_g()._a("Type", new jxtc(this));
        crashReport.func_85056_g()._a("Resource Pack", new qlgf(this));
        crashReport.func_85056_g()._a("Current Language", new net.minecraft.client.eidj(this));
        crashReport.func_85056_g()._a("Profiler Position", new pidb(this));
        crashReport.func_85056_g()._a("Vec3 Pool Size", new vjta(this));
        if (this._r != null) {
            this._r.func_72914_a(crashReport);
        }
        return crashReport;
    }

    public static xpzm _E() {
        return _i;
    }

    @Override
    public void _a(cfbu cfbu2) {
        cfbu2._a("fps", _U);
        cfbu2._a("texpack_name", this.__an._f());
        cfbu2._a("vsync_enabled", this._M.field_74352_v);
        cfbu2._a("display_frequency", Display.getDisplayMode().getFrequency());
        cfbu2._a("display_type", this._k ? "fullscreen" : "windowed");
        cfbu2._a("run_time", (dzfd.__aq() - cfbu2._i()) / 60L * 1000L);
        if (this._H != null && this._H.__am() != null) {
            cfbu2._a("snooper_partner", this._H.__am()._h());
        }
    }

    @Override
    public void _b(cfbu cfbu2) {
        cfbu2._a("opengl_version", GL11.glGetString(7938));
        cfbu2._a("opengl_vendor", GL11.glGetString(7936));
        cfbu2._a("client_brand", ClientBrandRetriever.getClientModName());
        cfbu2._a("launched_version", this._R);
        ContextCapabilities contextCapabilities = GLContext.getCapabilities();
        cfbu2._a("gl_caps[ARB_multitexture]", contextCapabilities.GL_ARB_multitexture);
        cfbu2._a("gl_caps[ARB_multisample]", contextCapabilities.GL_ARB_multisample);
        cfbu2._a("gl_caps[ARB_texture_cube_map]", contextCapabilities.GL_ARB_texture_cube_map);
        cfbu2._a("gl_caps[ARB_vertex_blend]", contextCapabilities.GL_ARB_vertex_blend);
        cfbu2._a("gl_caps[ARB_matrix_palette]", contextCapabilities.GL_ARB_matrix_palette);
        cfbu2._a("gl_caps[ARB_vertex_program]", contextCapabilities.GL_ARB_vertex_program);
        cfbu2._a("gl_caps[ARB_vertex_shader]", contextCapabilities.GL_ARB_vertex_shader);
        cfbu2._a("gl_caps[ARB_fragment_program]", contextCapabilities.GL_ARB_fragment_program);
        cfbu2._a("gl_caps[ARB_fragment_shader]", contextCapabilities.GL_ARB_fragment_shader);
        cfbu2._a("gl_caps[ARB_shader_objects]", contextCapabilities.GL_ARB_shader_objects);
        cfbu2._a("gl_caps[ARB_vertex_buffer_object]", contextCapabilities.GL_ARB_vertex_buffer_object);
        cfbu2._a("gl_caps[ARB_framebuffer_object]", contextCapabilities.GL_ARB_framebuffer_object);
        cfbu2._a("gl_caps[ARB_pixel_buffer_object]", contextCapabilities.GL_ARB_pixel_buffer_object);
        cfbu2._a("gl_caps[ARB_uniform_buffer_object]", contextCapabilities.GL_ARB_uniform_buffer_object);
        cfbu2._a("gl_caps[ARB_texture_non_power_of_two]", contextCapabilities.GL_ARB_texture_non_power_of_two);
        cfbu2._a("gl_caps[gl_max_vertex_uniforms]", GL11.glGetInteger(35658));
        cfbu2._a("gl_caps[gl_max_fragment_uniforms]", GL11.glGetInteger(35657));
        cfbu2._a("gl_max_texture_size", xpzm._F());
    }

    public static int _F() {
        if (__av != -1) {
            return __av;
        }
        for (int i = 16384; i > 0; i >>= 1) {
            GL11.glTexImage2D(32868, 0, 6408, i, i, 0, 6408, 5121, (ByteBuffer)null);
            int n = GL11.glGetTexLevelParameteri(32868, 0, 4096);
            if (n == 0) continue;
            __av = i;
            return i;
        }
        return -1;
    }

    @Override
    public boolean _G() {
        return this._M.field_74355_t;
    }

    public void _a(htsm htsm2) {
        this._g = htsm2;
    }

    public boolean _H() {
        return this.__ag;
    }

    public boolean _I() {
        return this.__ag && this._H != null;
    }

    public yfci _J() {
        return this._H;
    }

    public static void _K() {
        yfci yfci2;
        if (_i != null && (yfci2 = _i._J()) != null) {
            yfci2._w();
        }
    }

    public cfbu _L() {
        return this._q;
    }

    public static long _M() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }

    public boolean _N() {
        return this._k;
    }

    @Override
    public jjmf _O() {
        return this._e;
    }

    public hanr _P() {
        return this._x;
    }

    public Proxy _Q() {
        return this._S;
    }

    public apbu _R() {
        return this._h;
    }

    public xsfs _S() {
        return this.__aj;
    }

    public pknz _T() {
        return this.__an;
    }

    public gqvf _U() {
        return this.__ao;
    }

    public static String _a(xpzm xpzm2) {
        return xpzm2._R;
    }

    public static gqvf _b(xpzm xpzm2) {
        return xpzm2.__ao;
    }

    static {
        __av = -1;
    }
}

