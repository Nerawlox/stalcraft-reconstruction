/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.Bidi;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import mcoptifine.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class FontRenderer
implements cvkw {
    public static final ResourceLocation[] _a = new ResourceLocation[256];
    public float[] _b = new float[256];
    public int _c = 9;
    public Random _d = new Random();
    public byte[] _e = new byte[65536];
    public int[] _f = new int[32];
    public ResourceLocation _g;
    public final TextureManager _h;
    public float _i;
    public float _j;
    public boolean _k;
    public boolean _l;
    public float _m;
    public float _n;
    public float _o;
    public float _p;
    public int _q;
    public boolean _r;
    public boolean _s;
    public boolean _t;
    public boolean _u;
    public boolean _v;
    public GameSettings _w;
    public ResourceLocation _x;
    public boolean _y = true;

    public FontRenderer(GameSettings gameSettings, ResourceLocation resourceLocation, TextureManager textureManager, boolean bl) {
        this._w = gameSettings;
        this._x = resourceLocation;
        this._g = resourceLocation;
        this._h = textureManager;
        this._k = bl;
        this._g = FontRenderer._a(this._x);
        textureManager._a(this._g);
        for (int i = 0; i < 32; ++i) {
            int n = (i >> 3 & 1) * 85;
            int n2 = (i >> 2 & 1) * 170 + n;
            int n3 = (i >> 1 & 1) * 170 + n;
            int n4 = (i >> 0 & 1) * 170 + n;
            if (i == 6) {
                n2 += 85;
            }
            if (gameSettings.anaglyph) {
                int n5 = (n2 * 30 + n3 * 59 + n4 * 11) / 100;
                int n6 = (n2 * 30 + n3 * 70) / 100;
                int n7 = (n2 * 30 + n4 * 70) / 100;
                n2 = n5;
                n3 = n6;
                n4 = n7;
            }
            if (i >= 16) {
                n2 /= 4;
                n3 /= 4;
                n4 /= 4;
            }
            this._f[i] = (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
        }
        this._b();
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        this._g = FontRenderer._a(this._x);
        for (int i = 0; i < _a.length; ++i) {
            FontRenderer._a[i] = null;
        }
        this._a();
    }

    public void _a() {
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(Minecraft._E()._S()._a(this._g)._a());
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int n3 = n / 16;
        int n4 = n2 / 16;
        float f = (float)n / 128.0f;
        int[] nArray = new int[n * n2];
        bufferedImage.getRGB(0, 0, n, n2, nArray, 0, n);
        for (int i = 0; i < 256; ++i) {
            int n5;
            int n6 = i % 16;
            int n7 = i / 16;
            boolean bl = false;
            for (n5 = n3 - 1; n5 >= 0; --n5) {
                int n8 = n6 * n3 + n5;
                boolean bl2 = true;
                for (int j = 0; j < n4 && bl2; ++j) {
                    int n9 = (n7 * n4 + j) * n;
                    int n10 = nArray[n8 + n9];
                    int n11 = n10 >> 24 & 0xFF;
                    if (n11 <= 16) continue;
                    bl2 = false;
                }
                if (!bl2) break;
            }
            if (i == 65) {
                // empty if block
            }
            if (i == 32) {
                n5 = n3 <= 8 ? (int)(2.0f * f) : (int)(1.5f * f);
            }
            this._b[i] = (float)(n5 + 1) / f + 1.0f;
        }
        this._f();
    }

    public void _b() {
        try {
            InputStream inputStream = Minecraft._E()._S()._a(new ResourceLocation("font/glyph_sizes.bin"))._a();
            inputStream.read(this._e);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public float _a(int n, char c, boolean bl) {
        return c == ' ' ? this._b[c] : (n > 0 && !this._k ? this._a(n + 32, bl) : this._a(c, bl));
    }

    public float _a(int n, boolean bl) {
        float f = n % 16 * 8;
        float f2 = n / 16 * 8;
        float f3 = bl ? 1.0f : 0.0f;
        this._h._a(this._g);
        float f4 = this._b[n] - 0.01f;
        GL11.glBegin(5);
        GL11.glTexCoord2f(f / 128.0f, f2 / 128.0f);
        GL11.glVertex3f(this._i + f3, this._j, 0.0f);
        GL11.glTexCoord2f(f / 128.0f, (f2 + 7.99f) / 128.0f);
        GL11.glVertex3f(this._i - f3, this._j + 7.99f, 0.0f);
        GL11.glTexCoord2f((f + f4 - 1.0f) / 128.0f, f2 / 128.0f);
        GL11.glVertex3f(this._i + f4 - 1.0f + f3, this._j, 0.0f);
        GL11.glTexCoord2f((f + f4 - 1.0f) / 128.0f, (f2 + 7.99f) / 128.0f);
        GL11.glVertex3f(this._i + f4 - 1.0f - f3, this._j + 7.99f, 0.0f);
        GL11.glEnd();
        return this._b[n];
    }

    public ResourceLocation _a(int n) {
        if (_a[n] == null) {
            FontRenderer._a[n] = new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", n));
            FontRenderer._a[n] = FontRenderer._a(_a[n]);
        }
        return _a[n];
    }

    public void _b(int n) {
        this._h._a(this._a(n));
    }

    public float _a(char c, boolean bl) {
        if (this._e[c] == 0) {
            return 0.0f;
        }
        int n = c / 256;
        this._b(n);
        int n2 = this._e[c] >>> 4;
        int n3 = this._e[c] & 0xF;
        float f = n2;
        float f2 = n3 + 1;
        float f3 = (float)(c % 16 * 16) + f;
        float f4 = (c & 0xFF) / 16 * 16;
        float f5 = f2 - f - 0.02f;
        float f6 = bl ? 1.0f : 0.0f;
        GL11.glBegin(5);
        GL11.glTexCoord2f(f3 / 256.0f, f4 / 256.0f);
        GL11.glVertex3f(this._i + f6, this._j, 0.0f);
        GL11.glTexCoord2f(f3 / 256.0f, (f4 + 15.98f) / 256.0f);
        GL11.glVertex3f(this._i - f6, this._j + 7.99f, 0.0f);
        GL11.glTexCoord2f((f3 + f5) / 256.0f, f4 / 256.0f);
        GL11.glVertex3f(this._i + f5 / 2.0f + f6, this._j, 0.0f);
        GL11.glTexCoord2f((f3 + f5) / 256.0f, (f4 + 15.98f) / 256.0f);
        GL11.glVertex3f(this._i + f5 / 2.0f - f6, this._j + 7.99f, 0.0f);
        GL11.glEnd();
        return (f2 - f) / 2.0f + 1.0f;
    }

    public int _a(String string, int n, int n2, int n3) {
        return this._a(string, n, n2, n3, true);
    }

    public int _b(String string, int n, int n2, int n3) {
        return !this._y ? 0 : this._a(string, n, n2, n3, false);
    }

    public int _a(String string, int n, int n2, int n3, boolean bl) {
        int n4;
        this._c();
        if (this._l) {
            string = this._a(string);
        }
        if (bl) {
            n4 = this._b(string, n + 1, n2 + 1, n3, true);
            n4 = Math.max(n4, this._b(string, n, n2, n3, false));
        } else {
            n4 = this._b(string, n, n2, n3, false);
        }
        return n4;
    }

    public String _a(String string) {
        if (string != null && Bidi.requiresBidi(string.toCharArray(), 0, string.length())) {
            int n;
            int n2;
            Bidi bidi = new Bidi(string, -2);
            byte[] byArray = new byte[bidi.getRunCount()];
            Object[] objectArray = new String[byArray.length];
            for (int i = 0; i < byArray.length; ++i) {
                int n3 = bidi.getRunStart(i);
                n2 = bidi.getRunLimit(i);
                n = bidi.getRunLevel(i);
                String string2 = string.substring(n3, n2);
                byArray[i] = (byte)n;
                objectArray[i] = string2;
            }
            String[] stringArray = (String[])objectArray.clone();
            Bidi.reorderVisually(byArray, 0, objectArray, 0, byArray.length);
            StringBuilder stringBuilder = new StringBuilder();
            for (n2 = 0; n2 < objectArray.length; ++n2) {
                int n4;
                n = byArray[n2];
                for (n4 = 0; n4 < stringArray.length; ++n4) {
                    if (!stringArray[n4].equals(objectArray[n2])) {
                        continue;
                    }
                    n = byArray[n4];
                    break;
                }
                if ((n & 1) == 0) {
                    stringBuilder.append((String)objectArray[n2]);
                    continue;
                }
                for (n4 = ((String)objectArray[n2]).length() - 1; n4 >= 0; --n4) {
                    char c = ((String)objectArray[n2]).charAt(n4);
                    if (c == '(') {
                        c = ')';
                    } else if (c == ')') {
                        c = '(';
                    }
                    stringBuilder.append(c);
                }
            }
            return stringBuilder.toString();
        }
        return string;
    }

    public void _c() {
        this._r = false;
        this._s = false;
        this._t = false;
        this._u = false;
        this._v = false;
    }

    public void _a(String string, boolean bl) {
        for (int i = 0; i < string.length(); ++i) {
            Tessellator tessellator;
            boolean bl2;
            int n;
            int n2;
            char c = string.charAt(i);
            if (c == '\u00a7' && i + 1 < string.length()) {
                n2 = "0123456789abcdefklmnor".indexOf(string.toLowerCase().charAt(i + 1));
                if (n2 < 16) {
                    this._r = false;
                    this._s = false;
                    this._v = false;
                    this._u = false;
                    this._t = false;
                    if (n2 < 0 || n2 > 15) {
                        n2 = 15;
                    }
                    if (bl) {
                        n2 += 16;
                    }
                    this._q = n = this._f[n2];
                    GL11.glColor4f((float)(n >> 16) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, this._p);
                } else if (n2 == 16) {
                    this._r = true;
                } else if (n2 == 17) {
                    this._s = true;
                } else if (n2 == 18) {
                    this._v = true;
                } else if (n2 == 19) {
                    this._u = true;
                } else if (n2 == 20) {
                    this._t = true;
                } else if (n2 == 21) {
                    this._r = false;
                    this._s = false;
                    this._v = false;
                    this._u = false;
                    this._t = false;
                    GL11.glColor4f(this._m, this._n, this._o, this._p);
                }
                ++i;
                continue;
            }
            n2 = ChatAllowedCharacters._a.indexOf(c);
            if (this._r && n2 > 0) {
                while ((int)this._b[n2 + 32] != (int)this._b[(n = this._d.nextInt(ChatAllowedCharacters._a.length())) + 32]) {
                }
                n2 = n;
            }
            float f = this._k ? 0.5f : 1.0f;
            boolean bl3 = bl2 = (n2 <= 0 || this._k) && bl;
            if (bl2) {
                this._i -= f;
                this._j -= f;
            }
            float f2 = this._a(n2, c, this._t);
            if (bl2) {
                this._i += f;
                this._j += f;
            }
            if (this._s) {
                this._i += f;
                if (bl2) {
                    this._i -= f;
                    this._j -= f;
                }
                this._a(n2, c, this._t);
                this._i -= f;
                if (bl2) {
                    this._i += f;
                    this._j += f;
                }
                f2 += 1.0f;
            }
            if (this._v) {
                tessellator = Tessellator.instance;
                GL11.glDisable(3553);
                tessellator.startDrawingQuads();
                tessellator.addVertex(this._i, this._j + (float)(this._c / 2), 0.0);
                tessellator.addVertex(this._i + f2, this._j + (float)(this._c / 2), 0.0);
                tessellator.addVertex(this._i + f2, this._j + (float)(this._c / 2) - 1.0f, 0.0);
                tessellator.addVertex(this._i, this._j + (float)(this._c / 2) - 1.0f, 0.0);
                tessellator.draw();
                GL11.glEnable(3553);
            }
            if (this._u) {
                tessellator = Tessellator.instance;
                GL11.glDisable(3553);
                tessellator.startDrawingQuads();
                int n3 = this._u ? -1 : 0;
                tessellator.addVertex(this._i + (float)n3, this._j + (float)this._c, 0.0);
                tessellator.addVertex(this._i + f2, this._j + (float)this._c, 0.0);
                tessellator.addVertex(this._i + f2, this._j + (float)this._c - 1.0f, 0.0);
                tessellator.addVertex(this._i + (float)n3, this._j + (float)this._c - 1.0f, 0.0);
                tessellator.draw();
                GL11.glEnable(3553);
            }
            this._i += f2;
        }
    }

    public int _a(String string, int n, int n2, int n3, int n4, boolean bl) {
        if (this._l) {
            string = this._a(string);
            int n5 = this._b(string);
            n = n + n3 - n5;
        }
        return this._b(string, n, n2, n4, bl);
    }

    public int _b(String string, int n, int n2, int n3, boolean bl) {
        if (string == null) {
            return 0;
        }
        if ((n3 & 0xFC000000) == 0) {
            n3 |= 0xFF000000;
        }
        if (bl) {
            n3 = (n3 & 0xFCFCFC) >> 2 | n3 & 0xFF000000;
        }
        this._m = (float)(n3 >> 16 & 0xFF) / 255.0f;
        this._n = (float)(n3 >> 8 & 0xFF) / 255.0f;
        this._o = (float)(n3 & 0xFF) / 255.0f;
        this._p = (float)(n3 >> 24 & 0xFF) / 255.0f;
        GL11.glColor4f(this._m, this._n, this._o, this._p);
        this._i = n;
        this._j = n2;
        this._a(string, bl);
        return (int)this._i;
    }

    public int _b(String string) {
        if (string == null) {
            return 0;
        }
        float f = 0.0f;
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            float f2 = this._b(c);
            if (f2 < 0.0f && i < string.length() - 1) {
                if ((c = string.charAt(++i)) != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl = false;
                    }
                } else {
                    bl = true;
                }
                f2 = 0.0f;
            }
            f += f2;
            if (!bl) continue;
            f += 1.0f;
        }
        return (int)f;
    }

    public int _a(char c) {
        return Math.round(this._b(c));
    }

    public float _b(char c) {
        if (c == '\u00a7') {
            return -1.0f;
        }
        if (c == ' ') {
            return this._b[32];
        }
        int n = ChatAllowedCharacters._a.indexOf(c);
        if (n >= 0 && !this._k) {
            return this._b[n + 32];
        }
        if (this._e[c] != 0) {
            int n2 = this._e[c] >>> 4;
            int n3 = this._e[c] & 0xF;
            if (n3 > 7) {
                n3 = 15;
                n2 = 0;
            }
            return (++n3 - n2) / 2 + 1;
        }
        return 0.0f;
    }

    public String _a(String string, int n) {
        return this._a(string, n, false);
    }

    public String _a(String string, int n, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        float f = 0.0f;
        int n2 = bl ? string.length() - 1 : 0;
        int n3 = bl ? -1 : 1;
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i = n2; i >= 0 && i < string.length() && f < (float)n; i += n3) {
            char c = string.charAt(i);
            float f2 = this._b(c);
            if (bl2) {
                bl2 = false;
                if (c != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl3 = false;
                    }
                } else {
                    bl3 = true;
                }
            } else if (f2 < 0.0f) {
                bl2 = true;
            } else {
                f += f2;
                if (bl3) {
                    f += 1.0f;
                }
            }
            if (f > (float)n) break;
            if (bl) {
                stringBuilder.insert(0, c);
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public String _c(String string) {
        while (string != null && string.endsWith("\n")) {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    public void _a(String string, int n, int n2, int n3, int n4) {
        this._c();
        this._q = n4;
        string = this._c(string);
        this._c(string, n, n2, n3, false);
    }

    public void _c(String string, int n, int n2, int n3, boolean bl) {
        List list2 = this._c(string, n3);
        for (String string2 : list2) {
            this._a(string2, n, n2, n3, this._q, bl);
            n2 += this._c;
        }
    }

    public int _b(String string, int n) {
        return this._c * this._c(string, n).size();
    }

    public void _a(boolean bl) {
        this._k = bl;
    }

    public boolean _d() {
        return this._k;
    }

    public void _b(boolean bl) {
        this._l = bl;
    }

    public List _c(String string, int n) {
        return Arrays.asList(this._d(string, n).split("\n"));
    }

    public String _d(String string, int n) {
        int n2 = this._e(string, n);
        if (string.length() <= n2) {
            return string;
        }
        String string2 = string.substring(0, n2);
        char c = string.charAt(n2);
        boolean bl = c == ' ' || c == '\n';
        String string3 = FontRenderer._d(string2) + string.substring(n2 + (bl ? 1 : 0));
        return string2 + "\n" + this._d(string3, n);
    }

    public int _e(String string, int n) {
        int n2;
        int n3 = string.length();
        float f = 0.0f;
        int n4 = -1;
        boolean bl = false;
        for (n2 = 0; n2 < n3; ++n2) {
            char c = string.charAt(n2);
            switch (c) {
                case '\n': {
                    --n2;
                    break;
                }
                case ' ': {
                    n4 = n2;
                }
                case '\u00a7': {
                    char c2;
                    if (n2 >= n3 - 1) break;
                    if ((c2 = string.charAt(++n2)) != 'l' && c2 != 'L') {
                        if (c2 != 'r' && c2 != 'R' && !FontRenderer._c(c2)) break;
                        bl = false;
                        break;
                    }
                    bl = true;
                    break;
                }
                default: {
                    f += this._b(c);
                    if (!bl) break;
                    f += 1.0f;
                }
            }
            if (c == '\n') {
                n4 = ++n2;
                break;
            }
            if (f > (float)n) break;
        }
        return n2 != n3 && n4 != -1 && n4 < n2 ? n4 : n2;
    }

    public static boolean _c(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F';
    }

    public static boolean _d(char c) {
        return c >= 'k' && c <= 'o' || c >= 'K' && c <= 'O' || c == 'r' || c == 'R';
    }

    public static String _d(String string) {
        String string2 = "";
        int n = -1;
        int n2 = string.length();
        while ((n = string.indexOf(167, n + 1)) != -1) {
            if (n >= n2 - 1) continue;
            char c = string.charAt(n + 1);
            if (FontRenderer._c(c)) {
                string2 = "\u00a7" + c;
                continue;
            }
            if (!FontRenderer._d(c)) continue;
            string2 = string2 + "\u00a7" + c;
        }
        return string2;
    }

    public boolean _e() {
        return this._l;
    }

    public void _f() {
        String string;
        String string2 = this._g.getResourcePath();
        if (string2.endsWith(string = ".png")) {
            String string3 = string2.substring(0, string2.length() - string.length()) + ".properties";
            try {
                ResourceLocation resourceLocation = new ResourceLocation(this._g.getResourceDomain(), string3);
                InputStream inputStream = Config.getResourceStream(Config.getResourceManager(), resourceLocation);
                if (inputStream == null) {
                    return;
                }
                Config.log("Loading " + string3);
                Properties properties = new Properties();
                properties.load(inputStream);
                Set<Object> set = properties.keySet();
                for (String string4 : set) {
                    String string5;
                    float f;
                    String string6;
                    int n;
                    String string7;
                    if (!string4.startsWith(string7 = "width.") || (n = Config.parseInt(string6 = string4.substring(string7.length()), -1)) < 0 || n >= this._b.length || !((f = Config.parseFloat(string5 = properties.getProperty(string4), -1.0f)) >= 0.0f)) continue;
                    this._b[n] = f;
                }
            }
            catch (FileNotFoundException fileNotFoundException) {
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static ResourceLocation _a(ResourceLocation resourceLocation) {
        if (!Config.isCustomFonts()) {
            return resourceLocation;
        }
        if (resourceLocation == null) {
            return resourceLocation;
        }
        String string = resourceLocation.getResourcePath();
        String string2 = "textures/";
        String string3 = "mcpatcher/";
        if (!string.startsWith(string2)) {
            return resourceLocation;
        }
        string = string.substring(string2.length());
        string = string3 + string;
        ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), string);
        return Config.hasResource(Config.getResourceManager(), resourceLocation2) ? resourceLocation2 : resourceLocation;
    }
}

