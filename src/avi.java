/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bim
 *  bjo
 *  bjp
 *  bjq
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.Bidi;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class avi
implements bjq {
    private static final bjo[] c = new bjo[256];
    private int[] d = new int[256];
    public int a = 9;
    public Random b = new Random();
    private byte[] e = new byte[65536];
    private int[] f = new int[32];
    private final bjo g;
    private final bim h;
    private float i;
    private float j;
    private boolean k;
    private boolean l;
    private float m;
    private float n;
    private float o;
    private float p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;

    public avi(aul par1GameSettings, bjo par2ResourceLocation, bim par3TextureManager, boolean par4) {
        this.g = par2ResourceLocation;
        this.h = par3TextureManager;
        this.k = par4;
        par3TextureManager.a(this.g);
        for (int i = 0; i < 32; ++i) {
            int j2 = (i >> 3 & 1) * 85;
            int k = (i >> 2 & 1) * 170 + j2;
            int l = (i >> 1 & 1) * 170 + j2;
            int i1 = (i >> 0 & 1) * 170 + j2;
            if (i == 6) {
                k += 85;
            }
            if (par1GameSettings.g) {
                int j1 = (k * 30 + l * 59 + i1 * 11) / 100;
                int k1 = (k * 30 + l * 70) / 100;
                int l1 = (k * 30 + i1 * 70) / 100;
                k = j1;
                l = k1;
                i1 = l1;
            }
            if (i >= 16) {
                k /= 4;
                l /= 4;
                i1 /= 4;
            }
            this.f[i] = (k & 0xFF) << 16 | (l & 0xFF) << 8 | i1 & 0xFF;
        }
        this.d();
    }

    public void a(bjp par1ResourceManager) {
        this.c();
    }

    private void c() {
        BufferedImage bufferedimage;
        try {
            bufferedimage = ImageIO.read(atv.w().K().a(this.g).b());
        }
        catch (IOException ioexception) {
            throw new RuntimeException(ioexception);
        }
        int i = bufferedimage.getWidth();
        int j2 = bufferedimage.getHeight();
        int[] aint = new int[i * j2];
        bufferedimage.getRGB(0, 0, i, j2, aint, 0, i);
        int k = j2 / 16;
        int l = i / 16;
        int b0 = 1;
        float f = 8.0f / (float)l;
        for (int i1 = 0; i1 < 256; ++i1) {
            int l1;
            int j1 = i1 % 16;
            int k1 = i1 / 16;
            if (i1 == 32) {
                this.d[i1] = 3 + b0;
            }
            for (l1 = l - 1; l1 >= 0; --l1) {
                int i2 = j1 * l + l1;
                boolean flag = true;
                for (int j22 = 0; j22 < k && flag; ++j22) {
                    int k2 = (k1 * l + j22) * i;
                    if ((aint[i2 + k2] >> 24 & 0xFF) == 0) continue;
                    flag = false;
                }
                if (!flag) break;
            }
            this.d[i1] = (int)(0.5 + (double)((float)(++l1) * f)) + b0;
        }
    }

    private void d() {
        try {
            InputStream inputstream = atv.w().K().a(new bjo("font/glyph_sizes.bin")).b();
            inputstream.read(this.e);
        }
        catch (IOException ioexception) {
            throw new RuntimeException(ioexception);
        }
    }

    private float a(int par1, char par2, boolean par3) {
        return par2 == ' ' ? 4.0f : (par1 > 0 && !this.k ? this.a(par1 + 32, par3) : this.a(par2, par3));
    }

    private float a(int par1, boolean par2) {
        float f = par1 % 16 * 8;
        float f1 = par1 / 16 * 8;
        float f2 = par2 ? 1.0f : 0.0f;
        this.h.a(this.g);
        float f3 = (float)this.d[par1] - 0.01f;
        GL11.glBegin((int)5);
        GL11.glTexCoord2f((float)(f / 128.0f), (float)(f1 / 128.0f));
        GL11.glVertex3f((float)(this.i + f2), (float)this.j, (float)0.0f);
        GL11.glTexCoord2f((float)(f / 128.0f), (float)((f1 + 7.99f) / 128.0f));
        GL11.glVertex3f((float)(this.i - f2), (float)(this.j + 7.99f), (float)0.0f);
        GL11.glTexCoord2f((float)((f + f3 - 1.0f) / 128.0f), (float)(f1 / 128.0f));
        GL11.glVertex3f((float)(this.i + f3 - 1.0f + f2), (float)this.j, (float)0.0f);
        GL11.glTexCoord2f((float)((f + f3 - 1.0f) / 128.0f), (float)((f1 + 7.99f) / 128.0f));
        GL11.glVertex3f((float)(this.i + f3 - 1.0f - f2), (float)(this.j + 7.99f), (float)0.0f);
        GL11.glEnd();
        return this.d[par1];
    }

    private bjo a(int par1) {
        if (c[par1] == null) {
            avi.c[par1] = new bjo(String.format("textures/font/unicode_page_%02x.png", par1));
        }
        return c[par1];
    }

    private void b(int par1) {
        this.h.a(this.a(par1));
    }

    private float a(char par1, boolean par2) {
        if (this.e[par1] == 0) {
            return 0.0f;
        }
        int i = par1 / 256;
        this.b(i);
        int j2 = this.e[par1] >>> 4;
        int k = this.e[par1] & 0xF;
        float f = j2;
        float f1 = k + 1;
        float f2 = (float)(par1 % 16 * 16) + f;
        float f3 = (par1 & 0xFF) / 16 * 16;
        float f4 = f1 - f - 0.02f;
        float f5 = par2 ? 1.0f : 0.0f;
        GL11.glBegin((int)5);
        GL11.glTexCoord2f((float)(f2 / 256.0f), (float)(f3 / 256.0f));
        GL11.glVertex3f((float)(this.i + f5), (float)this.j, (float)0.0f);
        GL11.glTexCoord2f((float)(f2 / 256.0f), (float)((f3 + 15.98f) / 256.0f));
        GL11.glVertex3f((float)(this.i - f5), (float)(this.j + 7.99f), (float)0.0f);
        GL11.glTexCoord2f((float)((f2 + f4) / 256.0f), (float)(f3 / 256.0f));
        GL11.glVertex3f((float)(this.i + f4 / 2.0f + f5), (float)this.j, (float)0.0f);
        GL11.glTexCoord2f((float)((f2 + f4) / 256.0f), (float)((f3 + 15.98f) / 256.0f));
        GL11.glVertex3f((float)(this.i + f4 / 2.0f - f5), (float)(this.j + 7.99f), (float)0.0f);
        GL11.glEnd();
        return (f1 - f) / 2.0f + 1.0f;
    }

    public int a(String par1Str, int par2, int par3, int par4) {
        return this.a(par1Str, par2, par3, par4, true);
    }

    public int b(String par1Str, int par2, int par3, int par4) {
        return this.a(par1Str, par2, par3, par4, false);
    }

    public int a(String par1Str, int par2, int par3, int par4, boolean par5) {
        int l;
        this.e();
        if (this.l) {
            par1Str = this.c(par1Str);
        }
        if (par5) {
            l = this.b(par1Str, par2 + 1, par3 + 1, par4, true);
            l = Math.max(l, this.b(par1Str, par2, par3, par4, false));
        } else {
            l = this.b(par1Str, par2, par3, par4, false);
        }
        return l;
    }

    private String c(String par1Str) {
        if (par1Str != null && Bidi.requiresBidi(par1Str.toCharArray(), 0, par1Str.length())) {
            int i;
            Bidi bidi = new Bidi(par1Str, -2);
            byte[] abyte = new byte[bidi.getRunCount()];
            Object[] astring = new String[abyte.length];
            for (int j2 = 0; j2 < abyte.length; ++j2) {
                int k = bidi.getRunStart(j2);
                i = bidi.getRunLimit(j2);
                int l = bidi.getRunLevel(j2);
                String s1 = par1Str.substring(k, i);
                abyte[j2] = (byte)l;
                astring[j2] = s1;
            }
            String[] astring1 = (String[])astring.clone();
            Bidi.reorderVisually(abyte, 0, astring, 0, abyte.length);
            StringBuilder stringbuilder = new StringBuilder();
            for (i = 0; i < astring.length; ++i) {
                int i1;
                byte b0 = abyte[i];
                for (i1 = 0; i1 < astring1.length; ++i1) {
                    if (!astring1[i1].equals(astring[i])) {
                        continue;
                    }
                    b0 = abyte[i1];
                    break;
                }
                if ((b0 & 1) == 0) {
                    stringbuilder.append((String)astring[i]);
                    continue;
                }
                for (i1 = ((String)astring[i]).length() - 1; i1 >= 0; --i1) {
                    char c0 = ((String)astring[i]).charAt(i1);
                    if (c0 == '(') {
                        c0 = ')';
                    } else if (c0 == ')') {
                        c0 = '(';
                    }
                    stringbuilder.append(c0);
                }
            }
            return stringbuilder.toString();
        }
        return par1Str;
    }

    private void e() {
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
    }

    private void a(String par1Str, boolean par2) {
        for (int i = 0; i < par1Str.length(); ++i) {
            bfq tessellator;
            boolean flag1;
            int k;
            int j2;
            char c0 = par1Str.charAt(i);
            if (c0 == '\u00a7' && i + 1 < par1Str.length()) {
                j2 = "0123456789abcdefklmnor".indexOf(par1Str.toLowerCase().charAt(i + 1));
                if (j2 < 16) {
                    this.r = false;
                    this.s = false;
                    this.v = false;
                    this.u = false;
                    this.t = false;
                    if (j2 < 0 || j2 > 15) {
                        j2 = 15;
                    }
                    if (par2) {
                        j2 += 16;
                    }
                    this.q = k = this.f[j2];
                    GL11.glColor4f((float)((float)(k >> 16) / 255.0f), (float)((float)(k >> 8 & 0xFF) / 255.0f), (float)((float)(k & 0xFF) / 255.0f), (float)this.p);
                } else if (j2 == 16) {
                    this.r = true;
                } else if (j2 == 17) {
                    this.s = true;
                } else if (j2 == 18) {
                    this.v = true;
                } else if (j2 == 19) {
                    this.u = true;
                } else if (j2 == 20) {
                    this.t = true;
                } else if (j2 == 21) {
                    this.r = false;
                    this.s = false;
                    this.v = false;
                    this.u = false;
                    this.t = false;
                    GL11.glColor4f((float)this.m, (float)this.n, (float)this.o, (float)this.p);
                }
                ++i;
                continue;
            }
            j2 = v.a.indexOf(c0);
            if (this.r && j2 > 0) {
                while (this.d[j2 + 32] != this.d[(k = this.b.nextInt(v.a.length())) + 32]) {
                }
                j2 = k;
            }
            float f = this.k ? 0.5f : 1.0f;
            boolean bl2 = flag1 = (j2 <= 0 || this.k) && par2;
            if (flag1) {
                this.i -= f;
                this.j -= f;
            }
            float f1 = this.a(j2, c0, this.t);
            if (flag1) {
                this.i += f;
                this.j += f;
            }
            if (this.s) {
                this.i += f;
                if (flag1) {
                    this.i -= f;
                    this.j -= f;
                }
                this.a(j2, c0, this.t);
                this.i -= f;
                if (flag1) {
                    this.i += f;
                    this.j += f;
                }
                f1 += 1.0f;
            }
            if (this.v) {
                tessellator = bfq.a;
                GL11.glDisable((int)3553);
                tessellator.b();
                tessellator.a((double)this.i, (double)(this.j + (float)(this.a / 2)), 0.0);
                tessellator.a((double)(this.i + f1), (double)(this.j + (float)(this.a / 2)), 0.0);
                tessellator.a((double)(this.i + f1), (double)(this.j + (float)(this.a / 2) - 1.0f), 0.0);
                tessellator.a((double)this.i, (double)(this.j + (float)(this.a / 2) - 1.0f), 0.0);
                tessellator.a();
                GL11.glEnable((int)3553);
            }
            if (this.u) {
                tessellator = bfq.a;
                GL11.glDisable((int)3553);
                tessellator.b();
                int l = this.u ? -1 : 0;
                tessellator.a((double)(this.i + (float)l), (double)(this.j + (float)this.a), 0.0);
                tessellator.a((double)(this.i + f1), (double)(this.j + (float)this.a), 0.0);
                tessellator.a((double)(this.i + f1), (double)(this.j + (float)this.a - 1.0f), 0.0);
                tessellator.a((double)(this.i + (float)l), (double)(this.j + (float)this.a - 1.0f), 0.0);
                tessellator.a();
                GL11.glEnable((int)3553);
            }
            this.i += (float)((int)f1);
        }
    }

    private int a(String par1Str, int par2, int par3, int par4, int par5, boolean par6) {
        if (this.l) {
            par1Str = this.c(par1Str);
            int i1 = this.a(par1Str);
            par2 = par2 + par4 - i1;
        }
        return this.b(par1Str, par2, par3, par5, par6);
    }

    private int b(String par1Str, int par2, int par3, int par4, boolean par5) {
        if (par1Str == null) {
            return 0;
        }
        if ((par4 & 0xFC000000) == 0) {
            par4 |= 0xFF000000;
        }
        if (par5) {
            par4 = (par4 & 0xFCFCFC) >> 2 | par4 & 0xFF000000;
        }
        this.m = (float)(par4 >> 16 & 0xFF) / 255.0f;
        this.n = (float)(par4 >> 8 & 0xFF) / 255.0f;
        this.o = (float)(par4 & 0xFF) / 255.0f;
        this.p = (float)(par4 >> 24 & 0xFF) / 255.0f;
        GL11.glColor4f((float)this.m, (float)this.n, (float)this.o, (float)this.p);
        this.i = par2;
        this.j = par3;
        this.a(par1Str, par5);
        return (int)this.i;
    }

    public int a(String par1Str) {
        if (par1Str == null) {
            return 0;
        }
        int i = 0;
        boolean flag = false;
        for (int j2 = 0; j2 < par1Str.length(); ++j2) {
            char c0 = par1Str.charAt(j2);
            int k = this.a(c0);
            if (k < 0 && j2 < par1Str.length() - 1) {
                if ((c0 = par1Str.charAt(++j2)) != 'l' && c0 != 'L') {
                    if (c0 == 'r' || c0 == 'R') {
                        flag = false;
                    }
                } else {
                    flag = true;
                }
                k = 0;
            }
            i += k;
            if (!flag) continue;
            ++i;
        }
        return i;
    }

    public int a(char par1) {
        if (par1 == '\u00a7') {
            return -1;
        }
        if (par1 == ' ') {
            return 4;
        }
        int i = v.a.indexOf(par1);
        if (i >= 0 && !this.k) {
            return this.d[i + 32];
        }
        if (this.e[par1] != 0) {
            int j2 = this.e[par1] >>> 4;
            int k = this.e[par1] & 0xF;
            if (k > 7) {
                k = 15;
                j2 = 0;
            }
            return (++k - j2) / 2 + 1;
        }
        return 0;
    }

    public String a(String par1Str, int par2) {
        return this.a(par1Str, par2, false);
    }

    public String a(String par1Str, int par2, boolean par3) {
        StringBuilder stringbuilder = new StringBuilder();
        int j2 = 0;
        int k = par3 ? par1Str.length() - 1 : 0;
        int l = par3 ? -1 : 1;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i1 = k; i1 >= 0 && i1 < par1Str.length() && j2 < par2; i1 += l) {
            char c0 = par1Str.charAt(i1);
            int j1 = this.a(c0);
            if (flag1) {
                flag1 = false;
                if (c0 != 'l' && c0 != 'L') {
                    if (c0 == 'r' || c0 == 'R') {
                        flag2 = false;
                    }
                } else {
                    flag2 = true;
                }
            } else if (j1 < 0) {
                flag1 = true;
            } else {
                j2 += j1;
                if (flag2) {
                    ++j2;
                }
            }
            if (j2 > par2) break;
            if (par3) {
                stringbuilder.insert(0, c0);
                continue;
            }
            stringbuilder.append(c0);
        }
        return stringbuilder.toString();
    }

    private String d(String par1Str) {
        while (par1Str != null && par1Str.endsWith("\n")) {
            par1Str = par1Str.substring(0, par1Str.length() - 1);
        }
        return par1Str;
    }

    public void a(String par1Str, int par2, int par3, int par4, int par5) {
        this.e();
        this.q = par5;
        par1Str = this.d(par1Str);
        this.c(par1Str, par2, par3, par4, false);
    }

    private void c(String par1Str, int par2, int par3, int par4, boolean par5) {
        List list = this.c(par1Str, par4);
        for (String s1 : list) {
            this.a(s1, par2, par3, par4, this.q, par5);
            par3 += this.a;
        }
    }

    public int b(String par1Str, int par2) {
        return this.a * this.c(par1Str, par2).size();
    }

    public void a(boolean par1) {
        this.k = par1;
    }

    public boolean a() {
        return this.k;
    }

    public void b(boolean par1) {
        this.l = par1;
    }

    public List c(String par1Str, int par2) {
        return Arrays.asList(this.d(par1Str, par2).split("\n"));
    }

    String d(String par1Str, int par2) {
        int j2 = this.e(par1Str, par2);
        if (par1Str.length() <= j2) {
            return par1Str;
        }
        String s1 = par1Str.substring(0, j2);
        char c0 = par1Str.charAt(j2);
        boolean flag = c0 == ' ' || c0 == '\n';
        String s2 = avi.e(s1) + par1Str.substring(j2 + (flag ? 1 : 0));
        return s1 + "\n" + this.d(s2, par2);
    }

    private int e(String par1Str, int par2) {
        int l;
        int j2 = par1Str.length();
        int k = 0;
        int i1 = -1;
        boolean flag = false;
        for (l = 0; l < j2; ++l) {
            char c0 = par1Str.charAt(l);
            switch (c0) {
                case '\n': {
                    --l;
                    break;
                }
                case '\u00a7': {
                    char c1;
                    if (l >= j2 - 1) break;
                    if ((c1 = par1Str.charAt(++l)) != 'l' && c1 != 'L') {
                        if (c1 != 'r' && c1 != 'R' && !avi.b(c1)) break;
                        flag = false;
                        break;
                    }
                    flag = true;
                    break;
                }
                case ' ': {
                    i1 = l;
                }
                default: {
                    k += this.a(c0);
                    if (!flag) break;
                    ++k;
                }
            }
            if (c0 == '\n') {
                i1 = ++l;
                break;
            }
            if (k > par2) break;
        }
        return l != j2 && i1 != -1 && i1 < l ? i1 : l;
    }

    private static boolean b(char par0) {
        return par0 >= '0' && par0 <= '9' || par0 >= 'a' && par0 <= 'f' || par0 >= 'A' && par0 <= 'F';
    }

    private static boolean c(char par0) {
        return par0 >= 'k' && par0 <= 'o' || par0 >= 'K' && par0 <= 'O' || par0 == 'r' || par0 == 'R';
    }

    private static String e(String par0Str) {
        String s1 = "";
        int i = -1;
        int j2 = par0Str.length();
        while ((i = par0Str.indexOf(167, i + 1)) != -1) {
            if (i >= j2 - 1) continue;
            char c0 = par0Str.charAt(i + 1);
            if (avi.b(c0)) {
                s1 = "\u00a7" + c0;
                continue;
            }
            if (!avi.c(c0)) continue;
            s1 = s1 + "\u00a7" + c0;
        }
        return s1;
    }

    public boolean b() {
        return this.l;
    }
}

