/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ats
 *  bkb
 *  cpw.mods.fml.client.FMLClientHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  dp
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.Display
 */
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

@SideOnly(value=Side.CLIENT)
public class aul {
    private static final String[] ao = new String[]{"options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"};
    private static final String[] ap = new String[]{"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};
    private static final String[] aq = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
    private static final String[] ar = new String[]{"options.chat.visibility.full", "options.chat.visibility.system", "options.chat.visibility.hidden"};
    private static final String[] as = new String[]{"options.particles.all", "options.particles.decreased", "options.particles.minimal"};
    private static final String[] at = new String[]{"performance.max", "performance.balanced", "performance.powersaver"};
    private static final String[] au = new String[]{"options.ao.off", "options.ao.min", "options.ao.max"};
    public float a = 1.0f;
    public float b = 1.0f;
    public float c = 0.5f;
    public boolean d;
    public int e;
    public boolean f = true;
    public boolean g;
    public boolean h;
    public int i = 1;
    public boolean j = true;
    public int k = 2;
    public boolean l = true;
    public String m = "Default";
    public int n;
    public boolean o = true;
    public boolean p = true;
    public boolean q = true;
    public float r = 1.0f;
    public boolean s = true;
    public boolean t = true;
    public boolean u;
    public boolean v = true;
    public boolean w;
    public boolean x;
    public boolean y = true;
    public boolean z = true;
    public boolean A;
    public int B;
    public int C;
    public boolean D = true;
    public float E = 1.0f;
    public float F = 1.0f;
    public float G = 0.44366196f;
    public float H = 1.0f;
    public ats I = new ats("key.forward", 17);
    public ats J = new ats("key.left", 30);
    public ats K = new ats("key.back", 31);
    public ats L = new ats("key.right", 32);
    public ats M = new ats("key.jump", 57);
    public ats N = new ats("key.inventory", 18);
    public ats O = new ats("key.drop", 16);
    public ats P = new ats("key.chat", 20);
    public ats Q = new ats("key.sneak", 42);
    public ats R = new ats("key.attack", -100);
    public ats S = new ats("key.use", -99);
    public ats T = new ats("key.playerlist", 15);
    public ats U = new ats("key.pickItem", -98);
    public ats V = new ats("key.command", 53);
    public ats[] W = new ats[]{this.R, this.S, this.I, this.J, this.K, this.L, this.M, this.Q, this.O, this.N, this.P, this.T, this.U, this.V};
    protected atv X;
    private File av;
    public int Y = 2;
    public boolean Z;
    public int aa;
    public boolean ab;
    public boolean ac;
    public String ad = "";
    public boolean ae;
    public boolean af;
    public boolean ag;
    public float ah = 1.0f;
    public float ai = 1.0f;
    public float aj;
    public float ak;
    public int al;
    public int am;
    public String an = "en_US";

    public aul(atv par1Minecraft, File par2File) {
        this.X = par1Minecraft;
        this.av = new File(par2File, "options.txt");
        this.a();
    }

    public aul() {
    }

    public String a(int par1) {
        return bkb.a((String)this.W[par1].c);
    }

    public String b(int par1) {
        int j2 = this.W[par1].d;
        return aul.c(j2);
    }

    public static String c(int par0) {
        return par0 < 0 ? bkb.a((String)"key.mouseButton", (Object[])new Object[]{par0 + 101}) : Keyboard.getKeyName((int)par0);
    }

    public static boolean a(ats par0KeyBinding) {
        return par0KeyBinding.d < 0 ? Mouse.isButtonDown((int)(par0KeyBinding.d + 100)) : Keyboard.isKeyDown((int)par0KeyBinding.d);
    }

    public void a(int par1, int par2) {
        this.W[par1].d = par2;
        this.b();
    }

    public void a(aun par1EnumOptions, float par2) {
        if (par1EnumOptions == aun.a) {
            this.a = par2;
            this.X.v.a();
        }
        if (par1EnumOptions == aun.b) {
            this.b = par2;
            this.X.v.a();
        }
        if (par1EnumOptions == aun.d) {
            this.c = par2;
        }
        if (par1EnumOptions == aun.e) {
            this.aj = par2;
        }
        if (par1EnumOptions == aun.f) {
            this.ak = par2;
        }
        if (par1EnumOptions == aun.u) {
            this.r = par2;
            this.X.r.b().b();
        }
        if (par1EnumOptions == aun.E) {
            this.H = par2;
            this.X.r.b().b();
        }
        if (par1EnumOptions == aun.F) {
            this.G = par2;
            this.X.r.b().b();
        }
        if (par1EnumOptions == aun.D) {
            this.F = par2;
            this.X.r.b().b();
        }
        if (par1EnumOptions == aun.C) {
            this.E = par2;
            this.X.r.b().b();
        }
    }

    public void a(aun par1EnumOptions, int par2) {
        if (par1EnumOptions == aun.c) {
            boolean bl2 = this.d = !this.d;
        }
        if (par1EnumOptions == aun.g) {
            this.e = this.e + par2 & 3;
        }
        if (par1EnumOptions == aun.o) {
            this.al = this.al + par2 & 3;
        }
        if (par1EnumOptions == aun.q) {
            this.am = (this.am + par2) % 3;
        }
        if (par1EnumOptions == aun.h) {
            boolean bl3 = this.f = !this.f;
        }
        if (par1EnumOptions == aun.p) {
            boolean bl4 = this.l = !this.l;
        }
        if (par1EnumOptions == aun.j) {
            this.h = !this.h;
            this.X.g.a();
        }
        if (par1EnumOptions == aun.i) {
            this.g = !this.g;
            this.X.a();
        }
        if (par1EnumOptions == aun.k) {
            this.i = (this.i + par2 + 3) % 3;
        }
        if (par1EnumOptions == aun.l) {
            this.Y = this.Y + par2 & 3;
        }
        if (par1EnumOptions == aun.m) {
            this.j = !this.j;
            this.X.g.a();
        }
        if (par1EnumOptions == aun.n) {
            this.k = (this.k + par2) % 3;
            this.X.g.a();
        }
        if (par1EnumOptions == aun.r) {
            this.n = (this.n + par2) % 3;
        }
        if (par1EnumOptions == aun.s) {
            boolean bl5 = this.o = !this.o;
        }
        if (par1EnumOptions == aun.t) {
            boolean bl6 = this.p = !this.p;
        }
        if (par1EnumOptions == aun.v) {
            boolean bl7 = this.q = !this.q;
        }
        if (par1EnumOptions == aun.w) {
            boolean bl8 = this.s = !this.s;
        }
        if (par1EnumOptions == aun.x) {
            boolean bl9 = this.t = !this.t;
        }
        if (par1EnumOptions == aun.A) {
            boolean bl10 = this.z = !this.z;
        }
        if (par1EnumOptions == aun.B) {
            boolean bl11 = this.A = !this.A;
        }
        if (par1EnumOptions == aun.y) {
            boolean bl12 = this.u = !this.u;
            if (this.X.G() != this.u) {
                this.X.j();
            }
        }
        if (par1EnumOptions == aun.z) {
            this.v = !this.v;
            Display.setVSyncEnabled((boolean)this.v);
        }
        this.b();
    }

    public float a(aun par1EnumOptions) {
        return par1EnumOptions == aun.e ? this.aj : (par1EnumOptions == aun.f ? this.ak : (par1EnumOptions == aun.a ? this.a : (par1EnumOptions == aun.b ? this.b : (par1EnumOptions == aun.d ? this.c : (par1EnumOptions == aun.u ? this.r : (par1EnumOptions == aun.E ? this.H : (par1EnumOptions == aun.F ? this.G : (par1EnumOptions == aun.C ? this.E : (par1EnumOptions == aun.D ? this.F : 0.0f)))))))));
    }

    public boolean b(aun par1EnumOptions) {
        switch (par1EnumOptions) {
            case c: {
                return this.d;
            }
            case h: {
                return this.f;
            }
            case i: {
                return this.g;
            }
            case j: {
                return this.h;
            }
            case p: {
                return this.l;
            }
            case s: {
                return this.o;
            }
            case t: {
                return this.p;
            }
            case v: {
                return this.q;
            }
            case w: {
                return this.s;
            }
            case x: {
                return this.t;
            }
            case y: {
                return this.u;
            }
            case z: {
                return this.v;
            }
            case A: {
                return this.z;
            }
            case B: {
                return this.A;
            }
        }
        return false;
    }

    private static String a(String[] par0ArrayOfStr, int par1) {
        if (par1 < 0 || par1 >= par0ArrayOfStr.length) {
            par1 = 0;
        }
        return bkb.a((String)par0ArrayOfStr[par1]);
    }

    public String c(aun par1EnumOptions) {
        String s2 = bkb.a((String)par1EnumOptions.d()) + ": ";
        if (par1EnumOptions.a()) {
            float f = this.a(par1EnumOptions);
            return par1EnumOptions == aun.d ? (f == 0.0f ? s2 + bkb.a((String)"options.sensitivity.min") : (f == 1.0f ? s2 + bkb.a((String)"options.sensitivity.max") : s2 + (int)(f * 200.0f) + "%")) : (par1EnumOptions == aun.e ? (f == 0.0f ? s2 + bkb.a((String)"options.fov.min") : (f == 1.0f ? s2 + bkb.a((String)"options.fov.max") : s2 + (int)(70.0f + f * 40.0f))) : (par1EnumOptions == aun.f ? (f == 0.0f ? s2 + bkb.a((String)"options.gamma.min") : (f == 1.0f ? s2 + bkb.a((String)"options.gamma.max") : s2 + "+" + (int)(f * 100.0f) + "%")) : (par1EnumOptions == aun.u ? s2 + (int)(f * 90.0f + 10.0f) + "%" : (par1EnumOptions == aun.F ? s2 + auu.b(f) + "px" : (par1EnumOptions == aun.E ? s2 + auu.b(f) + "px" : (par1EnumOptions == aun.D ? s2 + auu.a(f) + "px" : (f == 0.0f ? s2 + bkb.a((String)"options.off") : s2 + (int)(f * 100.0f) + "%")))))));
        }
        if (par1EnumOptions.b()) {
            boolean flag = this.b(par1EnumOptions);
            return flag ? s2 + bkb.a((String)"options.on") : s2 + bkb.a((String)"options.off");
        }
        if (par1EnumOptions == aun.g) {
            return s2 + aul.a(ao, this.e);
        }
        if (par1EnumOptions == aun.l) {
            return s2 + aul.a(ap, this.Y);
        }
        if (par1EnumOptions == aun.o) {
            return s2 + aul.a(aq, this.al);
        }
        if (par1EnumOptions == aun.r) {
            return s2 + aul.a(ar, this.n);
        }
        if (par1EnumOptions == aun.q) {
            return s2 + aul.a(as, this.am);
        }
        if (par1EnumOptions == aun.k) {
            return s2 + aul.a(at, this.i);
        }
        if (par1EnumOptions == aun.n) {
            return s2 + aul.a(au, this.k);
        }
        if (par1EnumOptions == aun.m) {
            if (this.j) {
                return s2 + bkb.a((String)"options.graphics.fancy");
            }
            String s1 = "options.graphics.fast";
            return s2 + bkb.a((String)"options.graphics.fast");
        }
        return s2;
    }

    public void a() {
        try {
            if (!this.av.exists()) {
                return;
            }
            BufferedReader bufferedreader = new BufferedReader(new FileReader(this.av));
            String s2 = "";
            while ((s2 = bufferedreader.readLine()) != null) {
                try {
                    String[] astring = s2.split(":");
                    if (astring[0].equals("music")) {
                        this.a = this.a(astring[1]);
                    }
                    if (astring[0].equals("sound")) {
                        this.b = this.a(astring[1]);
                    }
                    if (astring[0].equals("mouseSensitivity")) {
                        this.c = this.a(astring[1]);
                    }
                    if (astring[0].equals("fov")) {
                        this.aj = this.a(astring[1]);
                    }
                    if (astring[0].equals("gamma")) {
                        this.ak = this.a(astring[1]);
                    }
                    if (astring[0].equals("invertYMouse")) {
                        this.d = astring[1].equals("true");
                    }
                    if (astring[0].equals("viewDistance")) {
                        this.e = Integer.parseInt(astring[1]);
                    }
                    if (astring[0].equals("guiScale")) {
                        this.al = Integer.parseInt(astring[1]);
                    }
                    if (astring[0].equals("particles")) {
                        this.am = Integer.parseInt(astring[1]);
                    }
                    if (astring[0].equals("bobView")) {
                        this.f = astring[1].equals("true");
                    }
                    if (astring[0].equals("anaglyph3d")) {
                        this.g = astring[1].equals("true");
                    }
                    if (astring[0].equals("advancedOpengl")) {
                        this.h = astring[1].equals("true");
                    }
                    if (astring[0].equals("fpsLimit")) {
                        this.i = Integer.parseInt(astring[1]);
                    }
                    if (astring[0].equals("difficulty")) {
                        this.Y = Integer.parseInt(astring[1]);
                    }
                    if (astring[0].equals("fancyGraphics")) {
                        this.j = astring[1].equals("true");
                    }
                    if (astring[0].equals("ao")) {
                        this.k = astring[1].equals("true") ? 2 : (astring[1].equals("false") ? 0 : Integer.parseInt(astring[1]));
                    }
                    if (astring[0].equals("clouds")) {
                        this.l = astring[1].equals("true");
                    }
                    if (astring[0].equals("skin")) {
                        this.m = astring[1];
                    }
                    if (astring[0].equals("lastServer") && astring.length >= 2) {
                        this.ad = s2.substring(s2.indexOf(58) + 1);
                    }
                    if (astring[0].equals("lang") && astring.length >= 2) {
                        this.an = astring[1];
                    }
                    if (astring[0].equals("chatVisibility")) {
                        this.n = Integer.parseInt(astring[1]);
                    }
                    if (astring[0].equals("chatColors")) {
                        this.o = astring[1].equals("true");
                    }
                    if (astring[0].equals("chatLinks")) {
                        this.p = astring[1].equals("true");
                    }
                    if (astring[0].equals("chatLinksPrompt")) {
                        this.q = astring[1].equals("true");
                    }
                    if (astring[0].equals("chatOpacity")) {
                        this.r = this.a(astring[1]);
                    }
                    if (astring[0].equals("serverTextures")) {
                        this.s = astring[1].equals("true");
                    }
                    if (astring[0].equals("snooperEnabled")) {
                        this.t = astring[1].equals("true");
                    }
                    if (astring[0].equals("fullscreen")) {
                        this.u = astring[1].equals("true");
                    }
                    if (astring[0].equals("enableVsync")) {
                        this.v = astring[1].equals("true");
                    }
                    if (astring[0].equals("hideServerAddress")) {
                        this.w = astring[1].equals("true");
                    }
                    if (astring[0].equals("advancedItemTooltips")) {
                        this.x = astring[1].equals("true");
                    }
                    if (astring[0].equals("pauseOnLostFocus")) {
                        this.y = astring[1].equals("true");
                    }
                    if (astring[0].equals("showCape")) {
                        this.z = astring[1].equals("true");
                    }
                    if (astring[0].equals("touchscreen")) {
                        this.A = astring[1].equals("true");
                    }
                    if (astring[0].equals("overrideHeight")) {
                        this.C = Integer.parseInt(astring[1]);
                    }
                    if (astring[0].equals("overrideWidth")) {
                        this.B = Integer.parseInt(astring[1]);
                    }
                    if (astring[0].equals("heldItemTooltips")) {
                        this.D = astring[1].equals("true");
                    }
                    if (astring[0].equals("chatHeightFocused")) {
                        this.H = this.a(astring[1]);
                    }
                    if (astring[0].equals("chatHeightUnfocused")) {
                        this.G = this.a(astring[1]);
                    }
                    if (astring[0].equals("chatScale")) {
                        this.E = this.a(astring[1]);
                    }
                    if (astring[0].equals("chatWidth")) {
                        this.F = this.a(astring[1]);
                    }
                    for (int i = 0; i < this.W.length; ++i) {
                        if (!astring[0].equals("key_" + this.W[i].c)) continue;
                        this.W[i].d = Integer.parseInt(astring[1]);
                    }
                }
                catch (Exception exception) {
                    this.X.an().b("Skipping bad option: " + s2);
                }
            }
            ats.b();
            bufferedreader.close();
        }
        catch (Exception exception1) {
            this.X.an().b("Failed to load options");
            exception1.printStackTrace();
        }
    }

    private float a(String par1Str) {
        return par1Str.equals("true") ? 1.0f : (par1Str.equals("false") ? 0.0f : Float.parseFloat(par1Str));
    }

    public void b() {
        if (FMLClientHandler.instance().isLoading()) {
            return;
        }
        try {
            PrintWriter printwriter = new PrintWriter(new FileWriter(this.av));
            printwriter.println("music:" + this.a);
            printwriter.println("sound:" + this.b);
            printwriter.println("invertYMouse:" + this.d);
            printwriter.println("mouseSensitivity:" + this.c);
            printwriter.println("fov:" + this.aj);
            printwriter.println("gamma:" + this.ak);
            printwriter.println("viewDistance:" + this.e);
            printwriter.println("guiScale:" + this.al);
            printwriter.println("particles:" + this.am);
            printwriter.println("bobView:" + this.f);
            printwriter.println("anaglyph3d:" + this.g);
            printwriter.println("advancedOpengl:" + this.h);
            printwriter.println("fpsLimit:" + this.i);
            printwriter.println("difficulty:" + this.Y);
            printwriter.println("fancyGraphics:" + this.j);
            printwriter.println("ao:" + this.k);
            printwriter.println("clouds:" + this.l);
            printwriter.println("skin:" + this.m);
            printwriter.println("lastServer:" + this.ad);
            printwriter.println("lang:" + this.an);
            printwriter.println("chatVisibility:" + this.n);
            printwriter.println("chatColors:" + this.o);
            printwriter.println("chatLinks:" + this.p);
            printwriter.println("chatLinksPrompt:" + this.q);
            printwriter.println("chatOpacity:" + this.r);
            printwriter.println("serverTextures:" + this.s);
            printwriter.println("snooperEnabled:" + this.t);
            printwriter.println("fullscreen:" + this.u);
            printwriter.println("enableVsync:" + this.v);
            printwriter.println("hideServerAddress:" + this.w);
            printwriter.println("advancedItemTooltips:" + this.x);
            printwriter.println("pauseOnLostFocus:" + this.y);
            printwriter.println("showCape:" + this.z);
            printwriter.println("touchscreen:" + this.A);
            printwriter.println("overrideWidth:" + this.B);
            printwriter.println("overrideHeight:" + this.C);
            printwriter.println("heldItemTooltips:" + this.D);
            printwriter.println("chatHeightFocused:" + this.H);
            printwriter.println("chatHeightUnfocused:" + this.G);
            printwriter.println("chatScale:" + this.E);
            printwriter.println("chatWidth:" + this.F);
            for (int i = 0; i < this.W.length; ++i) {
                printwriter.println("key_" + this.W[i].c + ":" + this.W[i].d);
            }
            printwriter.close();
        }
        catch (Exception exception) {
            this.X.an().b("Failed to save options");
            exception.printStackTrace();
        }
        this.c();
    }

    public void c() {
        if (this.X.h != null) {
            this.X.h.a.c((ey)new dp(this.an, this.e, this.n, this.o, this.Y, this.z));
        }
    }

    public boolean d() {
        return this.e < 2 && this.l;
    }
}

