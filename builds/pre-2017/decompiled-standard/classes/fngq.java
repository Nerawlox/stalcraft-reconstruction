/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import cpw.mods.fml.client.GuiModList;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.bundle.pidb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

@SideOnly(value=Side.CLIENT)
public class fngq
extends gqjz {
    public static final Random _b = new Random();
    public float _c;
    public String _d = "missingno";
    public jiok _e;
    public int _f;
    public sctt _g;
    public boolean _h = true;
    public static boolean _i;
    public static boolean _j;
    public final Object _k = new Object();
    public String _l;
    public String _m;
    public static final ResourceLocation _n;
    public static final ResourceLocation _o;
    public static final ResourceLocation[] _p;
    public static final String _q;
    public int _r;
    public int _s;
    public int _t;
    public int _u;
    public int _v;
    public int _w;
    public ResourceLocation _x;
    public jiok _y;
    public jiok _z = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public fngq() {
        String string;
        Object object;
        BufferedReader bufferedReader = null;
        try {
            object = new ArrayList();
            bufferedReader = new BufferedReader(new InputStreamReader(xpzm._E()._S()._a(_n)._a(), Charsets.UTF_8));
            while ((string = bufferedReader.readLine()) != null) {
                if ((string = string.trim()).isEmpty()) continue;
                ((ArrayList)object).add(string);
            }
            do {
                this._d = (String)((ArrayList)object).get(_b.nextInt(((ArrayList)object).size()));
            } while (this._d.hashCode() == 125780783);
        }
        catch (IOException iOException) {
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException iOException) {}
            }
        }
        this._c = _b.nextFloat();
        this._l = "";
        object = System.getProperty("os_architecture");
        string = System.getProperty("java_version");
        if ("ppc".equalsIgnoreCase((String)object)) {
            this._l = "" + (Object)((Object)ezfc._r) + "Notice!" + (Object)((Object)ezfc._v) + " PowerPC compatibility will be dropped in Minecraft 1.6";
            this._m = "http://tinyurl.com/javappc";
        } else if (string != null && string.startsWith("1.5")) {
            this._l = "" + (Object)((Object)ezfc._r) + "Notice!" + (Object)((Object)ezfc._v) + " Java 1.5 compatibility will be dropped in Minecraft 1.6";
            this._m = "http://tinyurl.com/javappc";
        }
    }

    @Override
    public void func_73876_c() {
        ++this._f;
    }

    @Override
    public boolean func_73868_f() {
        return false;
    }

    @Override
    public void func_73869_a(char c, int n) {
        pidb._a(this, c, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void func_73866_w_() {
        this._g = new sctt(256, 256);
        this._x = this.field_73882_e._R()._a("background", this._g);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9) {
            this._d = "Happy birthday, ez!";
        } else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1) {
            this._d = "Happy birthday, Notch!";
        } else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24) {
            this._d = "Merry X-mas!";
        } else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1) {
            this._d = "Happy new year!";
        } else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31) {
            this._d = "OOoooOOOoooo! Spooky!";
        }
        boolean bl = true;
        int n = this.field_73881_g / 4 + 48;
        if (this.field_73882_e._y()) {
            this._b(n, 24);
        } else {
            this._a(n, 24);
        }
        this._b();
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, n + 72 + 12, 98, 20, wpcz._a("menu.options")));
        this.field_73887_h.add(new jiok(4, this.field_73880_f / 2 + 2, n + 72 + 12, 98, 20, wpcz._a("menu.quit")));
        this.field_73887_h.add(new iflj(5, this.field_73880_f / 2 - 124, n + 72 + 12));
        Object object = this._k;
        Object object2 = this._k;
        synchronized (object2) {
            this._s = this.field_73886_k._b(this._l);
            this._r = this.field_73886_k._b(_q);
            int n2 = Math.max(this._s, this._r);
            this._t = (this.field_73880_f - n2) / 2;
            this._u = ((jiok)this.field_73887_h.get((int)0)).field_73743_d - 24;
            this._v = this._t + n2;
            this._w = this._u + 24;
        }
    }

    public void _b() {
        if (this._h) {
            if (!_i) {
                _i = true;
                new cvaz(this).start();
            } else if (_j) {
                this._c();
            }
        }
    }

    public void _c() {
        this._y.field_73748_h = true;
        this._z.field_73747_a = 98;
        this._z.field_73746_c = this.field_73880_f / 2 + 2;
    }

    public void _a(int n, int n2) {
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, n, wpcz._a("menu.singleplayer")));
        this.field_73887_h.add(new jiok(2, this.field_73880_f / 2 - 100, n + n2 * 1, wpcz._a("menu.multiplayer")));
        this._z = new jiok(6, this.field_73880_f / 2 - 100, n + n2 * 2, "Mods");
        this.field_73887_h.add(this._z);
        this._y = new jiok(14, this.field_73880_f / 2 - 100, n + n2 * 2, wpcz._a("menu.online"));
        this._y.field_73747_a = 98;
        this._y.field_73746_c = this.field_73880_f / 2 - 100;
        this.field_73887_h.add(this._y);
        this._y.field_73748_h = false;
    }

    public void _b(int n, int n2) {
        this.field_73887_h.add(new jiok(11, this.field_73880_f / 2 - 100, n, wpcz._a("menu.playdemo")));
        this._e = new jiok(12, this.field_73880_f / 2 - 100, n + n2 * 1, wpcz._a("menu.resetdemo"));
        this.field_73887_h.add(this._e);
        ozsq ozsq2 = this.field_73882_e._g();
        iyev iyev2 = ozsq2._c("Demo_World");
        if (iyev2 == null) {
            this._e.field_73742_g = false;
        }
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        ozsq ozsq2;
        iyev iyev2;
        if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(new xayo(this, this.field_73882_e._M));
        }
        if (jiok2.field_73741_f == 5) {
            this.field_73882_e._a(new twpa(this, this.field_73882_e._M, this.field_73882_e._U()));
        }
        if (jiok2.field_73741_f == 1) {
            this.field_73882_e._a(new fnfu(this));
        }
        if (jiok2.field_73741_f == 2) {
            this.field_73882_e._a(new gqju(this));
        }
        if (jiok2.field_73741_f == 14 && this._y.field_73748_h) {
            this._d();
        }
        if (jiok2.field_73741_f == 4) {
            this.field_73882_e._n();
        }
        if (jiok2.field_73741_f == 6) {
            this.field_73882_e._a(new GuiModList(this));
        }
        if (jiok2.field_73741_f == 11) {
            this.field_73882_e._a("Demo_World", "Demo_World", zily._b);
        }
        if (jiok2.field_73741_f == 12 && (iyev2 = (ozsq2 = this.field_73882_e._g())._c("Demo_World")) != null) {
            lowa lowa2 = fnfu._a(this, iyev2._k(), 12);
            this.field_73882_e._a(lowa2);
        }
    }

    public void _d() {
        rqmi rqmi2 = new rqmi(this.field_73882_e._P());
        try {
            if (rqmi2._c().booleanValue()) {
                this.field_73882_e._a(new oyes(this));
            } else {
                this.field_73882_e._a(new htmo(this));
            }
        }
        catch (twsl twsl2) {
            this.field_73882_e._O()._c(twsl2.toString());
        }
        catch (IOException iOException) {
            this.field_73882_e._O()._c(iOException.getLocalizedMessage());
        }
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (bl && n == 12) {
            ozsq ozsq2 = this.field_73882_e._g();
            ozsq2._c();
            ozsq2._d("Demo_World");
            this.field_73882_e._a(this);
        } else if (n == 13) {
            if (bl) {
                try {
                    Class<?> clazz = Class.forName("java.awt.Desktop");
                    Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                    clazz.getMethod("browse", URI.class).invoke(object, new URI(this._m));
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            this.field_73882_e._a(this);
        }
    }

    public void _a(int n, int n2, float f) {
        htvf htvf2 = htvf.field_78398_a;
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        Project.gluPerspective(120.0f, 1.0f, 0.05f, 10.0f);
        GL11.glMatrixMode(5888);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glDisable(2884);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        int n3 = 8;
        for (int i = 0; i < n3 * n3; ++i) {
            GL11.glPushMatrix();
            float f2 = ((float)(i % n3) / (float)n3 - 0.5f) / 64.0f;
            float f3 = ((float)(i / n3) / (float)n3 - 0.5f) / 64.0f;
            float f4 = 0.0f;
            GL11.glTranslatef(f2, f3, f4);
            GL11.glRotatef(sajh._a(((float)this._f + f) / 400.0f) * 25.0f + 20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-((float)this._f + f) * 0.1f, 0.0f, 1.0f, 0.0f);
            for (int j = 0; j < 6; ++j) {
                GL11.glPushMatrix();
                if (j == 1) {
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                }
                if (j == 2) {
                    GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                }
                if (j == 3) {
                    GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                }
                if (j == 4) {
                    GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (j == 5) {
                    GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                }
                this.field_73882_e._R()._a(_p[j]);
                htvf2.func_78382_b();
                htvf2.func_78384_a(0xFFFFFF, 255 / (i + 1));
                float f5 = 0.0f;
                htvf2.func_78374_a(-1.0, -1.0, 1.0, 0.0f + f5, 0.0f + f5);
                htvf2.func_78374_a(1.0, -1.0, 1.0, 1.0f - f5, 0.0f + f5);
                htvf2.func_78374_a(1.0, 1.0, 1.0, 1.0f - f5, 1.0f - f5);
                htvf2.func_78374_a(-1.0, 1.0, 1.0, 0.0f + f5, 1.0f - f5);
                htvf2.func_78381_a();
                GL11.glPopMatrix();
            }
            GL11.glPopMatrix();
            GL11.glColorMask(true, true, true, false);
        }
        htvf2.func_78373_b(0.0, 0.0, 0.0);
        GL11.glColorMask(true, true, true, true);
        GL11.glMatrixMode(5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        GL11.glDepthMask(true);
        GL11.glEnable(2884);
        GL11.glEnable(3008);
        GL11.glEnable(2929);
    }

    public void _a(float f) {
        this.field_73882_e._R()._a(this._x);
        GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColorMask(true, true, true, false);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        int n = 3;
        for (int i = 0; i < n; ++i) {
            htvf2.func_78369_a(1.0f, 1.0f, 1.0f, 1.0f / (float)(i + 1));
            int n2 = this.field_73880_f;
            int n3 = this.field_73881_g;
            float f2 = (float)(i - n / 2) / 256.0f;
            htvf2.func_78374_a(n2, n3, this.field_73735_i, 0.0f + f2, 0.0);
            htvf2.func_78374_a(n2, 0.0, this.field_73735_i, 1.0f + f2, 0.0);
            htvf2.func_78374_a(0.0, 0.0, this.field_73735_i, 1.0f + f2, 1.0);
            htvf2.func_78374_a(0.0, n3, this.field_73735_i, 0.0f + f2, 1.0);
        }
        htvf2.func_78381_a();
        GL11.glColorMask(true, true, true, true);
    }

    public void _b(int n, int n2, float f) {
        GL11.glViewport(0, 0, 256, 256);
        this._a(n, n2, f);
        GL11.glDisable(3553);
        GL11.glEnable(3553);
        this._a(f);
        this._a(f);
        this._a(f);
        this._a(f);
        this._a(f);
        this._a(f);
        this._a(f);
        this._a(f);
        GL11.glViewport(0, 0, this.field_73882_e._n, this.field_73882_e._o);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        float f2 = this.field_73880_f > this.field_73881_g ? 120.0f / (float)this.field_73880_f : 120.0f / (float)this.field_73881_g;
        float f3 = (float)this.field_73881_g * f2 / 256.0f;
        float f4 = (float)this.field_73880_f * f2 / 256.0f;
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        htvf2.func_78369_a(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.field_73880_f;
        int n4 = this.field_73881_g;
        htvf2.func_78374_a(0.0, n4, this.field_73735_i, 0.5f - f3, 0.5f + f4);
        htvf2.func_78374_a(n3, n4, this.field_73735_i, 0.5f - f3, 0.5f - f4);
        htvf2.func_78374_a(n3, 0.0, this.field_73735_i, 0.5f + f3, 0.5f - f4);
        htvf2.func_78374_a(0.0, 0.0, this.field_73735_i, 0.5f + f3, 0.5f + f4);
        htvf2.func_78381_a();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this._b(n, n2, f);
        htvf htvf2 = htvf.field_78398_a;
        int n3 = 274;
        int n4 = this.field_73880_f / 2 - n3 / 2;
        int n5 = 30;
        this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, -2130706433, 0xFFFFFF);
        this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, 0, Integer.MIN_VALUE);
        this.field_73882_e._R()._a(_o);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if ((double)this._c < 1.0E-4) {
            this.func_73729_b(n4 + 0, n5 + 0, 0, 0, 99, 44);
            this.func_73729_b(n4 + 99, n5 + 0, 129, 0, 27, 44);
            this.func_73729_b(n4 + 99 + 26, n5 + 0, 126, 0, 3, 44);
            this.func_73729_b(n4 + 99 + 26 + 3, n5 + 0, 99, 0, 26, 44);
            this.func_73729_b(n4 + 155, n5 + 0, 0, 45, 155, 44);
        } else {
            this.func_73729_b(n4 + 0, n5 + 0, 0, 0, 155, 44);
            this.func_73729_b(n4 + 155, n5 + 0, 0, 45, 155, 44);
        }
        htvf2.func_78378_d(0xFFFFFF);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.field_73880_f / 2 + 90, 70.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        float f2 = 1.8f - sajh._e(sajh._a((float)(xpzm._M() % 1000L) / 1000.0f * (float)Math.PI * 2.0f) * 0.1f);
        f2 = f2 * 100.0f / (float)(this.field_73886_k._b(this._d) + 32);
        GL11.glScalef(f2, f2, f2);
        this.func_73732_a(this.field_73886_k, this._d, 0, -8, 0xFFFF00);
        GL11.glPopMatrix();
        String string = "Minecraft 1.6.4";
        if (this.field_73882_e._y()) {
            string = string + " Demo";
        }
        List<String> list = Lists.reverse(FMLCommonHandler.instance().getBrandings());
        for (int i = 0; i < list.size(); ++i) {
            String string2 = list.get(i);
            if (Strings.isNullOrEmpty(string2)) continue;
            this.func_73731_b(this.field_73886_k, string2, 2, this.field_73881_g - (10 + i * (this.field_73886_k._c + 1)), 0xFFFFFF);
        }
        String string3 = "Copyright Mojang AB. Do not distribute!";
        this.func_73731_b(this.field_73886_k, string3, this.field_73880_f - this.field_73886_k._b(string3) - 2, this.field_73881_g - 10, 0xFFFFFF);
        if (this._l != null && this._l.length() > 0) {
            fngq.func_73734_a(this._t - 2, this._u - 2, this._v + 2, this._w - 1, 0x55200000);
            this.func_73731_b(this.field_73886_k, this._l, this._t, this._u, 0xFFFFFF);
            this.func_73731_b(this.field_73886_k, _q, (this.field_73880_f - this._r) / 2, ((jiok)this.field_73887_h.get((int)0)).field_73743_d - 12, 0xFFFFFF);
        }
        super.func_73863_a(n, n2, f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        Object object = this._k;
        Object object2 = this._k;
        synchronized (object2) {
            if (this._l.length() > 0 && n >= this._t && n <= this._v && n2 >= this._u && n2 <= this._w) {
                wotc wotc2 = new wotc((gqjz)this, this._m, 13, true);
                wotc2._b();
                this.field_73882_e._a(wotc2);
            }
        }
    }

    public static xpzm _a(fngq fngq2) {
        return fngq2.field_73882_e;
    }

    public static void _b(fngq fngq2) {
        fngq2._c();
    }

    public static boolean _a(boolean bl) {
        _j = bl;
        return bl;
    }

    public static xpzm _c(fngq fngq2) {
        return fngq2.field_73882_e;
    }

    public static xpzm _d(fngq fngq2) {
        return fngq2.field_73882_e;
    }

    static {
        _n = new ResourceLocation("texts/splashes.txt");
        _o = new ResourceLocation("textures/gui/title/minecraft.png");
        _p = new ResourceLocation[]{new ResourceLocation("textures/gui/title/background/panorama_0.png"), new ResourceLocation("textures/gui/title/background/panorama_1.png"), new ResourceLocation("textures/gui/title/background/panorama_2.png"), new ResourceLocation("textures/gui/title/background/panorama_3.png"), new ResourceLocation("textures/gui/title/background/panorama_4.png"), new ResourceLocation("textures/gui/title/background/panorama_5.png")};
        _q = "Please click " + (Object)((Object)ezfc._t) + "here" + (Object)((Object)ezfc._v) + " for more information.";
    }
}

