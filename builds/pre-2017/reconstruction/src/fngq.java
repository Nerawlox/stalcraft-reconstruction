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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.GuiScreenClientOutdated;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

@SideOnly(value=Side.CLIENT)
public class fngq
extends GuiScreen {
    public static final Random _b = new Random();
    public float _c;
    public String _d = "missingno";
    public GuiButton _e;
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
    public GuiButton _y;
    public GuiButton _z = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public fngq() {
        String string;
        Object object;
        BufferedReader bufferedReader = null;
        try {
            object = new ArrayList();
            bufferedReader = new BufferedReader(new InputStreamReader(Minecraft._E()._S()._a(_n)._a(), Charsets.UTF_8));
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
            this._l = "" + (Object)((Object)EnumChatFormatting._r) + "Notice!" + (Object)((Object)EnumChatFormatting._v) + " PowerPC compatibility will be dropped in Minecraft 1.6";
            this._m = "http://tinyurl.com/javappc";
        } else if (string != null && string.startsWith("1.5")) {
            this._l = "" + (Object)((Object)EnumChatFormatting._r) + "Notice!" + (Object)((Object)EnumChatFormatting._v) + " Java 1.5 compatibility will be dropped in Minecraft 1.6";
            this._m = "http://tinyurl.com/javappc";
        }
    }

    @Override
    public void updateScreen() {
        ++this._f;
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void keyTyped(char c, int n) {
        pidb._a(this, c, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void initGui() {
        this._g = new sctt(256, 256);
        this._x = this.mc._R()._a("background", this._g);
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
        int n = this.height / 4 + 48;
        if (this.mc._y()) {
            this._b(n, 24);
        } else {
            this._a(n, 24);
        }
        this._b();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, n + 72 + 12, 98, 20, wpcz._a("menu.options")));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 2, n + 72 + 12, 98, 20, wpcz._a("menu.quit")));
        this.buttonList.add(new iflj(5, this.width / 2 - 124, n + 72 + 12));
        Object object = this._k;
        Object object2 = this._k;
        synchronized (object2) {
            this._s = this.fontRenderer._b(this._l);
            this._r = this.fontRenderer._b(_q);
            int n2 = Math.max(this._s, this._r);
            this._t = (this.width - n2) / 2;
            this._u = ((GuiButton)this.buttonList.get((int)0)).yPosition - 24;
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
        this._y.drawButton = true;
        this._z.width = 98;
        this._z.xPosition = this.width / 2 + 2;
    }

    public void _a(int n, int n2) {
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, n, wpcz._a("menu.singleplayer")));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, n + n2 * 1, wpcz._a("menu.multiplayer")));
        this._z = new GuiButton(6, this.width / 2 - 100, n + n2 * 2, "Mods");
        this.buttonList.add(this._z);
        this._y = new GuiButton(14, this.width / 2 - 100, n + n2 * 2, wpcz._a("menu.online"));
        this._y.width = 98;
        this._y.xPosition = this.width / 2 - 100;
        this.buttonList.add(this._y);
        this._y.drawButton = false;
    }

    public void _b(int n, int n2) {
        this.buttonList.add(new GuiButton(11, this.width / 2 - 100, n, wpcz._a("menu.playdemo")));
        this._e = new GuiButton(12, this.width / 2 - 100, n + n2 * 1, wpcz._a("menu.resetdemo"));
        this.buttonList.add(this._e);
        ISaveFormat iSaveFormat = this.mc._g();
        WorldInfo worldInfo = iSaveFormat._c("Demo_World");
        if (worldInfo == null) {
            this._e.enabled = false;
        }
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        ISaveFormat iSaveFormat;
        WorldInfo worldInfo;
        if (guiButton.id == 0) {
            this.mc._a(new GuiOptions(this, this.mc._M));
        }
        if (guiButton.id == 5) {
            this.mc._a(new twpa(this, this.mc._M, this.mc._U()));
        }
        if (guiButton.id == 1) {
            this.mc._a(new fnfu(this));
        }
        if (guiButton.id == 2) {
            this.mc._a(new gqju(this));
        }
        if (guiButton.id == 14 && this._y.drawButton) {
            this._d();
        }
        if (guiButton.id == 4) {
            this.mc._n();
        }
        if (guiButton.id == 6) {
            this.mc._a(new GuiModList(this));
        }
        if (guiButton.id == 11) {
            this.mc._a("Demo_World", "Demo_World", zily._b);
        }
        if (guiButton.id == 12 && (worldInfo = (iSaveFormat = this.mc._g())._c("Demo_World")) != null) {
            GuiYesNo guiYesNo = fnfu._a(this, worldInfo._k(), 12);
            this.mc._a(guiYesNo);
        }
    }

    public void _d() {
        rqmi rqmi2 = new rqmi(this.mc._P());
        try {
            if (rqmi2._c().booleanValue()) {
                this.mc._a(new GuiScreenClientOutdated(this));
            } else {
                this.mc._a(new htmo(this));
            }
        }
        catch (ExceptionMcoService exceptionMcoService) {
            this.mc._O()._c(exceptionMcoService.toString());
        }
        catch (IOException iOException) {
            this.mc._O()._c(iOException.getLocalizedMessage());
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (bl && n == 12) {
            ISaveFormat iSaveFormat = this.mc._g();
            iSaveFormat._c();
            iSaveFormat._d("Demo_World");
            this.mc._a(this);
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
            this.mc._a(this);
        }
    }

    public void _a(int n, int n2, float f) {
        Tessellator tessellator = Tessellator.instance;
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
                this.mc._R()._a(_p[j]);
                tessellator.startDrawingQuads();
                tessellator.setColorRGBA_I(0xFFFFFF, 255 / (i + 1));
                float f5 = 0.0f;
                tessellator.addVertexWithUV(-1.0, -1.0, 1.0, 0.0f + f5, 0.0f + f5);
                tessellator.addVertexWithUV(1.0, -1.0, 1.0, 1.0f - f5, 0.0f + f5);
                tessellator.addVertexWithUV(1.0, 1.0, 1.0, 1.0f - f5, 1.0f - f5);
                tessellator.addVertexWithUV(-1.0, 1.0, 1.0, 0.0f + f5, 1.0f - f5);
                tessellator.draw();
                GL11.glPopMatrix();
            }
            GL11.glPopMatrix();
            GL11.glColorMask(true, true, true, false);
        }
        tessellator.setTranslation(0.0, 0.0, 0.0);
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
        this.mc._R()._a(this._x);
        GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColorMask(true, true, true, false);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        int n = 3;
        for (int i = 0; i < n; ++i) {
            tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, 1.0f / (float)(i + 1));
            int n2 = this.width;
            int n3 = this.height;
            float f2 = (float)(i - n / 2) / 256.0f;
            tessellator.addVertexWithUV(n2, n3, this.zLevel, 0.0f + f2, 0.0);
            tessellator.addVertexWithUV(n2, 0.0, this.zLevel, 1.0f + f2, 0.0);
            tessellator.addVertexWithUV(0.0, 0.0, this.zLevel, 1.0f + f2, 1.0);
            tessellator.addVertexWithUV(0.0, n3, this.zLevel, 0.0f + f2, 1.0);
        }
        tessellator.draw();
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
        GL11.glViewport(0, 0, this.mc._n, this.mc._o);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        float f2 = this.width > this.height ? 120.0f / (float)this.width : 120.0f / (float)this.height;
        float f3 = (float)this.height * f2 / 256.0f;
        float f4 = (float)this.width * f2 / 256.0f;
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.width;
        int n4 = this.height;
        tessellator.addVertexWithUV(0.0, n4, this.zLevel, 0.5f - f3, 0.5f + f4);
        tessellator.addVertexWithUV(n3, n4, this.zLevel, 0.5f - f3, 0.5f - f4);
        tessellator.addVertexWithUV(n3, 0.0, this.zLevel, 0.5f + f3, 0.5f - f4);
        tessellator.addVertexWithUV(0.0, 0.0, this.zLevel, 0.5f + f3, 0.5f + f4);
        tessellator.draw();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this._b(n, n2, f);
        Tessellator tessellator = Tessellator.instance;
        int n3 = 274;
        int n4 = this.width / 2 - n3 / 2;
        int n5 = 30;
        this.drawGradientRect(0, 0, this.width, this.height, -2130706433, 0xFFFFFF);
        this.drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);
        this.mc._R()._a(_o);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if ((double)this._c < 1.0E-4) {
            this.drawTexturedModalRect(n4 + 0, n5 + 0, 0, 0, 99, 44);
            this.drawTexturedModalRect(n4 + 99, n5 + 0, 129, 0, 27, 44);
            this.drawTexturedModalRect(n4 + 99 + 26, n5 + 0, 126, 0, 3, 44);
            this.drawTexturedModalRect(n4 + 99 + 26 + 3, n5 + 0, 99, 0, 26, 44);
            this.drawTexturedModalRect(n4 + 155, n5 + 0, 0, 45, 155, 44);
        } else {
            this.drawTexturedModalRect(n4 + 0, n5 + 0, 0, 0, 155, 44);
            this.drawTexturedModalRect(n4 + 155, n5 + 0, 0, 45, 155, 44);
        }
        tessellator.setColorOpaque_I(0xFFFFFF);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.width / 2 + 90, 70.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        float f2 = 1.8f - sajh._e(sajh._a((float)(Minecraft._M() % 1000L) / 1000.0f * (float)Math.PI * 2.0f) * 0.1f);
        f2 = f2 * 100.0f / (float)(this.fontRenderer._b(this._d) + 32);
        GL11.glScalef(f2, f2, f2);
        this.drawCenteredString(this.fontRenderer, this._d, 0, -8, 0xFFFF00);
        GL11.glPopMatrix();
        String string = "Minecraft 1.6.4";
        if (this.mc._y()) {
            string = string + " Demo";
        }
        List<String> list = Lists.reverse(FMLCommonHandler.instance().getBrandings());
        for (int i = 0; i < list.size(); ++i) {
            String string2 = list.get(i);
            if (Strings.isNullOrEmpty(string2)) continue;
            this.drawString(this.fontRenderer, string2, 2, this.height - (10 + i * (this.fontRenderer._c + 1)), 0xFFFFFF);
        }
        String string3 = "Copyright Mojang AB. Do not distribute!";
        this.drawString(this.fontRenderer, string3, this.width - this.fontRenderer._b(string3) - 2, this.height - 10, 0xFFFFFF);
        if (this._l != null && this._l.length() > 0) {
            fngq.drawRect(this._t - 2, this._u - 2, this._v + 2, this._w - 1, 0x55200000);
            this.drawString(this.fontRenderer, this._l, this._t, this._u, 0xFFFFFF);
            this.drawString(this.fontRenderer, _q, (this.width - this._r) / 2, ((GuiButton)this.buttonList.get((int)0)).yPosition - 12, 0xFFFFFF);
        }
        super.drawScreen(n, n2, f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        Object object = this._k;
        Object object2 = this._k;
        synchronized (object2) {
            if (this._l.length() > 0 && n >= this._t && n <= this._v && n2 >= this._u && n2 <= this._w) {
                GuiConfirmOpenLink guiConfirmOpenLink = new GuiConfirmOpenLink((GuiScreen)this, this._m, 13, true);
                guiConfirmOpenLink._b();
                this.mc._a(guiConfirmOpenLink);
            }
        }
    }

    public static Minecraft _a(fngq fngq2) {
        return fngq2.mc;
    }

    public static void _b(fngq fngq2) {
        fngq2._c();
    }

    public static boolean _a(boolean bl) {
        _j = bl;
        return bl;
    }

    public static Minecraft _c(fngq fngq2) {
        return fngq2.mc;
    }

    public static Minecraft _d(fngq fngq2) {
        return fngq2.mc;
    }

    static {
        _n = new ResourceLocation("texts/splashes.txt");
        _o = new ResourceLocation("textures/gui/title/minecraft.png");
        _p = new ResourceLocation[]{new ResourceLocation("textures/gui/title/background/panorama_0.png"), new ResourceLocation("textures/gui/title/background/panorama_1.png"), new ResourceLocation("textures/gui/title/background/panorama_2.png"), new ResourceLocation("textures/gui/title/background/panorama_3.png"), new ResourceLocation("textures/gui/title/background/panorama_4.png"), new ResourceLocation("textures/gui/title/background/panorama_5.png")};
        _q = "Please click " + (Object)((Object)EnumChatFormatting._t) + "here" + (Object)((Object)EnumChatFormatting._v) + " for more information.";
    }
}

