/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  als
 *  amf
 *  aut
 *  aux
 *  avq
 *  avr
 *  avw
 *  awh
 *  aye
 *  bap
 *  bcx
 *  bib
 *  bjo
 *  bkb
 *  blu
 *  com.google.common.base.Strings
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.client.GuiModList
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  jj
 *  org.apache.commons.io.Charsets
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.Project
 */
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import cpw.mods.fml.client.GuiModList;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

@SideOnly(value=Side.CLIENT)
public class blt
extends awe {
    private static final Random b = new Random();
    private float c;
    private String d = "missingno";
    private aut e;
    private int p;
    private bib q;
    private boolean r = true;
    private static boolean s;
    private static boolean t;
    private final Object u = new Object();
    private String v;
    private String w;
    private static final bjo x;
    private static final bjo y;
    private static final bjo[] z;
    public static final String a;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private bjo G;
    private aut H;
    private aut fmlModButton = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public blt() {
        String s2;
        BufferedReader bufferedreader = null;
        try {
            ArrayList<String> arraylist = new ArrayList<String>();
            bufferedreader = new BufferedReader(new InputStreamReader(atv.w().K().a(x).b(), Charsets.UTF_8));
            while ((s2 = bufferedreader.readLine()) != null) {
                if ((s2 = s2.trim()).isEmpty()) continue;
                arraylist.add(s2);
            }
            do {
                this.d = (String)arraylist.get(b.nextInt(arraylist.size()));
            } while (this.d.hashCode() == 125780783);
        }
        catch (IOException arraylist) {
        }
        finally {
            if (bufferedreader != null) {
                try {
                    bufferedreader.close();
                }
                catch (IOException arraylist) {}
            }
        }
        this.c = b.nextFloat();
        this.v = "";
        String s1 = System.getProperty("os_architecture");
        s2 = System.getProperty("java_version");
        if ("ppc".equalsIgnoreCase(s1)) {
            this.v = "" + (Object)((Object)a.r) + "Notice!" + (Object)((Object)a.v) + " PowerPC compatibility will be dropped in Minecraft 1.6";
            this.w = "http://tinyurl.com/javappc";
        } else if (s2 != null && s2.startsWith("1.5")) {
            this.v = "" + (Object)((Object)a.r) + "Notice!" + (Object)((Object)a.v) + " Java 1.5 compatibility will be dropped in Minecraft 1.6";
            this.w = "http://tinyurl.com/javappc";
        }
    }

    @Override
    public void c() {
        ++this.p;
    }

    @Override
    public boolean f() {
        return false;
    }

    @Override
    protected void a(char par1, int par2) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void A_() {
        this.q = new bib(256, 256);
        this.G = this.f.J().a("background", this.q);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9) {
            this.d = "Happy birthday, ez!";
        } else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1) {
            this.d = "Happy birthday, Notch!";
        } else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24) {
            this.d = "Merry X-mas!";
        } else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1) {
            this.d = "Happy new year!";
        } else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31) {
            this.d = "OOoooOOOoooo! Spooky!";
        }
        boolean flag = true;
        int i2 = this.h / 4 + 48;
        if (this.f.p()) {
            this.c(i2, 24);
        } else {
            this.b(i2, 24);
        }
        this.g();
        this.i.add(new aut(0, this.g / 2 - 100, i2 + 72 + 12, 98, 20, bkb.a((String)"menu.options")));
        this.i.add(new aut(4, this.g / 2 + 2, i2 + 72 + 12, 98, 20, bkb.a((String)"menu.quit")));
        this.i.add(new avq(5, this.g / 2 - 124, i2 + 72 + 12));
        Object object = this.u;
        Object object2 = this.u;
        synchronized (object2) {
            this.B = this.o.a(this.v);
            this.A = this.o.a(a);
            int j2 = Math.max(this.B, this.A);
            this.C = (this.g - j2) / 2;
            this.D = ((aut)this.i.get((int)0)).e - 24;
            this.E = this.C + j2;
            this.F = this.D + 24;
        }
    }

    private void g() {
        if (this.r) {
            if (!s) {
                s = true;
                new blu(this).start();
            } else if (t) {
                this.h();
            }
        }
    }

    private void h() {
        this.H.i = true;
        this.fmlModButton.b = 98;
        this.fmlModButton.d = this.g / 2 + 2;
    }

    private void b(int par1, int par2) {
        this.i.add(new aut(1, this.g / 2 - 100, par1, bkb.a((String)"menu.singleplayer")));
        this.i.add(new aut(2, this.g / 2 - 100, par1 + par2 * 1, bkb.a((String)"menu.multiplayer")));
        this.fmlModButton = new aut(6, this.g / 2 - 100, par1 + par2 * 2, "Mods");
        this.i.add(this.fmlModButton);
        this.H = new aut(14, this.g / 2 - 100, par1 + par2 * 2, bkb.a((String)"menu.online"));
        this.H.b = 98;
        this.H.d = this.g / 2 - 100;
        this.i.add(this.H);
        this.H.i = false;
    }

    private void c(int par1, int par2) {
        this.i.add(new aut(11, this.g / 2 - 100, par1, bkb.a((String)"menu.playdemo")));
        this.e = new aut(12, this.g / 2 - 100, par1 + par2 * 1, bkb.a((String)"menu.resetdemo"));
        this.i.add(this.e);
        amf isaveformat = this.f.b();
        als worldinfo = isaveformat.c("Demo_World");
        if (worldinfo == null) {
            this.e.h = false;
        }
    }

    @Override
    protected void a(aut par1GuiButton) {
        amf isaveformat;
        als worldinfo;
        if (par1GuiButton.g == 0) {
            this.f.a((awe)new avw((awe)this, this.f.u));
        }
        if (par1GuiButton.g == 5) {
            this.f.a((awe)new avr((awe)this, this.f.u, this.f.M()));
        }
        if (par1GuiButton.g == 1) {
            this.f.a((awe)new awh((awe)this));
        }
        if (par1GuiButton.g == 2) {
            this.f.a(new avn(this));
        }
        if (par1GuiButton.g == 14 && this.H.i) {
            this.i();
        }
        if (par1GuiButton.g == 4) {
            this.f.f();
        }
        if (par1GuiButton.g == 6) {
            this.f.a((awe)new GuiModList((awe)this));
        }
        if (par1GuiButton.g == 11) {
            this.f.a("Demo_World", "Demo_World", jj.a);
        }
        if (par1GuiButton.g == 12 && (worldinfo = (isaveformat = this.f.b()).c("Demo_World")) != null) {
            aux guiyesno = awh.a((awe)this, (String)worldinfo.k(), (int)12);
            this.f.a((awe)guiyesno);
        }
    }

    private void i() {
        azz mcoclient = new azz(this.f.H());
        try {
            if (mcoclient.c().booleanValue()) {
                this.f.a((awe)new aye((awe)this));
            } else {
                this.f.a(new ayz(this));
            }
        }
        catch (bap exceptionmcoservice) {
            this.f.an().c(exceptionmcoservice.toString());
        }
        catch (IOException ioexception) {
            this.f.an().c(ioexception.getLocalizedMessage());
        }
    }

    @Override
    public void a(boolean par1, int par2) {
        if (par1 && par2 == 12) {
            amf isaveformat = this.f.b();
            isaveformat.d();
            isaveformat.e("Demo_World");
            this.f.a(this);
        } else if (par2 == 13) {
            if (par1) {
                try {
                    Class<?> oclass = Class.forName("java.awt.Desktop");
                    Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                    oclass.getMethod("browse", URI.class).invoke(object, new URI(this.w));
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            this.f.a(this);
        }
    }

    private void b(int par1, int par2, float par3) {
        bfq tessellator = bfq.a;
        GL11.glMatrixMode((int)5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        Project.gluPerspective((float)120.0f, (float)1.0f, (float)0.05f, (float)10.0f);
        GL11.glMatrixMode((int)5888);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glDisable((int)2884);
        GL11.glDepthMask((boolean)false);
        GL11.glBlendFunc((int)770, (int)771);
        int b0 = 8;
        for (int k = 0; k < b0 * b0; ++k) {
            GL11.glPushMatrix();
            float f1 = ((float)(k % b0) / (float)b0 - 0.5f) / 64.0f;
            float f2 = ((float)(k / b0) / (float)b0 - 0.5f) / 64.0f;
            float f3 = 0.0f;
            GL11.glTranslatef((float)f1, (float)f2, (float)f3);
            GL11.glRotatef((float)(ls.a(((float)this.p + par3) / 400.0f) * 25.0f + 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)(-((float)this.p + par3) * 0.1f), (float)0.0f, (float)1.0f, (float)0.0f);
            for (int l2 = 0; l2 < 6; ++l2) {
                GL11.glPushMatrix();
                if (l2 == 1) {
                    GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (l2 == 2) {
                    GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (l2 == 3) {
                    GL11.glRotatef((float)-90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (l2 == 4) {
                    GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                }
                if (l2 == 5) {
                    GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                }
                this.f.J().a(z[l2]);
                tessellator.b();
                tessellator.a(0xFFFFFF, 255 / (k + 1));
                float f4 = 0.0f;
                tessellator.a(-1.0, -1.0, 1.0, 0.0f + f4, 0.0f + f4);
                tessellator.a(1.0, -1.0, 1.0, 1.0f - f4, 0.0f + f4);
                tessellator.a(1.0, 1.0, 1.0, 1.0f - f4, 1.0f - f4);
                tessellator.a(-1.0, 1.0, 1.0, 0.0f + f4, 1.0f - f4);
                tessellator.a();
                GL11.glPopMatrix();
            }
            GL11.glPopMatrix();
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)false);
        }
        tessellator.b(0.0, 0.0, 0.0);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        GL11.glMatrixMode((int)5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode((int)5888);
        GL11.glPopMatrix();
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2884);
        GL11.glEnable((int)3008);
        GL11.glEnable((int)2929);
    }

    private void a(float par1) {
        this.f.J().a(this.G);
        GL11.glCopyTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)0, (int)0, (int)256, (int)256);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)false);
        bfq tessellator = bfq.a;
        tessellator.b();
        int b0 = 3;
        for (int i2 = 0; i2 < b0; ++i2) {
            tessellator.a(1.0f, 1.0f, 1.0f, 1.0f / (float)(i2 + 1));
            int j2 = this.g;
            int k = this.h;
            float f1 = (float)(i2 - b0 / 2) / 256.0f;
            tessellator.a(j2, k, this.n, 0.0f + f1, 0.0);
            tessellator.a(j2, 0.0, this.n, 1.0f + f1, 0.0);
            tessellator.a(0.0, 0.0, this.n, 1.0f + f1, 1.0);
            tessellator.a(0.0, k, this.n, 0.0f + f1, 1.0);
        }
        tessellator.a();
        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
    }

    private void c(int par1, int par2, float par3) {
        GL11.glViewport((int)0, (int)0, (int)256, (int)256);
        this.b(par1, par2, par3);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3553);
        this.a(par3);
        this.a(par3);
        this.a(par3);
        this.a(par3);
        this.a(par3);
        this.a(par3);
        this.a(par3);
        this.a(par3);
        GL11.glViewport((int)0, (int)0, (int)this.f.d, (int)this.f.e);
        bfq tessellator = bfq.a;
        tessellator.b();
        float f1 = this.g > this.h ? 120.0f / (float)this.g : 120.0f / (float)this.h;
        float f2 = (float)this.h * f1 / 256.0f;
        float f3 = (float)this.g * f1 / 256.0f;
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        tessellator.a(1.0f, 1.0f, 1.0f, 1.0f);
        int k = this.g;
        int l2 = this.h;
        tessellator.a(0.0, l2, this.n, 0.5f - f2, 0.5f + f3);
        tessellator.a(k, l2, this.n, 0.5f - f2, 0.5f - f3);
        tessellator.a(k, 0.0, this.n, 0.5f + f2, 0.5f - f3);
        tessellator.a(0.0, 0.0, this.n, 0.5f + f2, 0.5f + f3);
        tessellator.a();
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.c(par1, par2, par3);
        bfq tessellator = bfq.a;
        int short1 = 274;
        int k = this.g / 2 - short1 / 2;
        int b0 = 30;
        this.a(0, 0, this.g, this.h, -2130706433, 0xFFFFFF);
        this.a(0, 0, this.g, this.h, 0, Integer.MIN_VALUE);
        this.f.J().a(y);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if ((double)this.c < 1.0E-4) {
            this.b(k + 0, b0 + 0, 0, 0, 99, 44);
            this.b(k + 99, b0 + 0, 129, 0, 27, 44);
            this.b(k + 99 + 26, b0 + 0, 126, 0, 3, 44);
            this.b(k + 99 + 26 + 3, b0 + 0, 99, 0, 26, 44);
            this.b(k + 155, b0 + 0, 0, 45, 155, 44);
        } else {
            this.b(k + 0, b0 + 0, 0, 0, 155, 44);
            this.b(k + 155, b0 + 0, 0, 45, 155, 44);
        }
        tessellator.d(0xFFFFFF);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.g / 2 + 90), (float)70.0f, (float)0.0f);
        GL11.glRotatef((float)-20.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        float f1 = 1.8f - ls.e(ls.a((float)(atv.F() % 1000L) / 1000.0f * (float)Math.PI * 2.0f) * 0.1f);
        f1 = f1 * 100.0f / (float)(this.o.a(this.d) + 32);
        GL11.glScalef((float)f1, (float)f1, (float)f1);
        this.a(this.o, this.d, 0, -8, 0xFFFF00);
        GL11.glPopMatrix();
        String s2 = "Minecraft 1.6.4";
        if (this.f.p()) {
            s2 = s2 + " Demo";
        }
        List brandings = Lists.reverse((List)FMLCommonHandler.instance().getBrandings());
        for (int i2 = 0; i2 < brandings.size(); ++i2) {
            String brd = (String)brandings.get(i2);
            if (Strings.isNullOrEmpty((String)brd)) continue;
            this.b(this.o, brd, 2, this.h - (10 + i2 * (this.o.a + 1)), 0xFFFFFF);
        }
        String s1 = "Copyright Mojang AB. Do not distribute!";
        this.b(this.o, s1, this.g - this.o.a(s1) - 2, this.h - 10, 0xFFFFFF);
        if (this.v != null && this.v.length() > 0) {
            blt.a(this.C - 2, this.D - 2, this.E + 2, this.F - 1, 0x55200000);
            this.b(this.o, this.v, this.C, this.D, 0xFFFFFF);
            this.b(this.o, a, (this.g - this.A) / 2, ((aut)this.i.get((int)0)).e - 12, 0xFFFFFF);
        }
        super.a(par1, par2, par3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
        Object object = this.u;
        Object object2 = this.u;
        synchronized (object2) {
            if (this.v.length() > 0 && par1 >= this.C && par1 <= this.E && par2 >= this.D && par2 <= this.F) {
                bcx guiconfirmopenlink = new bcx((awe)this, this.w, 13, true);
                guiconfirmopenlink.h();
                this.f.a((awe)guiconfirmopenlink);
            }
        }
    }

    static atv a(blt par0GuiMainMenu) {
        return par0GuiMainMenu.f;
    }

    static void b(blt par0GuiMainMenu) {
        par0GuiMainMenu.h();
    }

    static boolean a(boolean par0) {
        t = par0;
        return par0;
    }

    static atv c(blt par0GuiMainMenu) {
        return par0GuiMainMenu.f;
    }

    static atv d(blt par0GuiMainMenu) {
        return par0GuiMainMenu.f;
    }

    static {
        x = new bjo("texts/splashes.txt");
        y = new bjo("textures/gui/title/minecraft.png");
        z = new bjo[]{new bjo("textures/gui/title/background/panorama_0.png"), new bjo("textures/gui/title/background/panorama_1.png"), new bjo("textures/gui/title/background/panorama_2.png"), new bjo("textures/gui/title/background/panorama_3.png"), new bjo("textures/gui/title/background/panorama_4.png"), new bjo("textures/gui/title/background/panorama_5.png")};
        a = "Please click " + (Object)((Object)a.t) + "here" + (Object)((Object)a.v) + " for more information.";
    }
}

