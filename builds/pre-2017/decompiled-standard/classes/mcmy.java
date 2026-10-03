/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class mcmy {
    private static final ResourceLocation _d = new ResourceLocation("auction", "fonts/dictionary.txt");
    public static String _a = " !\"#$%&'()*+,-./0123456789:;<=>?@[\\]^_`{|}~\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\u5a38\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffdAaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    private static boolean _e = false;
    public static final String _b;
    public String _c;
    private ResourceLocation _f;
    private int _g;
    private int _h;
    private int _i;
    private int _j;
    private char[] _k;
    private int[] _l;
    private int[] _m;
    private int[] _n;
    private int[] _o;
    private int _p;
    private int _q;
    private double _r = 2.0;

    public mcmy(String string, int n, int n2, String string2) {
        try {
            this._c = string2;
            this._k = string2.toCharArray();
            this._b(string, n, n2);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public mcmy(File file, float f, int n, String string) {
        try {
            this._c = string;
            this._k = string.toCharArray();
            this._a(file, f, n, string.toCharArray());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public mcmy(String string, int n, int n2) {
        try {
            this._b(string, n, n2);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void _a(File file, float f, int n, char[] cArray) {
        try {
            Font font = Font.createFont(0, file);
            font = font.deriveFont(n);
            font = font.deriveFont(f);
            this._a(font, (int)f, n, cArray);
        }
        catch (FontFormatException fontFormatException) {
            fontFormatException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void _a(String string, int n, int n2, char[] cArray) {
        this._a(new Font(string, n2, n), n, n2, cArray);
    }

    private void _a(Font font, int n, int n2, char[] cArray) {
        Object object;
        this._l = new int[cArray.length];
        this._m = new int[cArray.length];
        this._n = new int[cArray.length];
        this._o = new int[cArray.length];
        BufferedImage bufferedImage = new BufferedImage(256, 256, 2);
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setFont(font);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setColor(new Color(255, 255, 255, 0));
        graphics2D.fillRect(0, 0, 256, 256);
        graphics2D.setColor(Color.white);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int n3 = 2;
        int n4 = 2;
        for (int i = 0; i < this._c.length(); ++i) {
            graphics2D.drawString("" + cArray[i], n3, n4 + graphics2D.getFontMetrics().getAscent());
            object = fontMetrics.getStringBounds("" + cArray[i], null);
            this._l[i] = n3;
            this._m[i] = n4 - fontMetrics.getMaxDescent() + 2;
            this._n[i] = (int)((RectangularShape)object).getWidth();
            this._o[i] = (int)((RectangularShape)object).getHeight();
            if ((n3 += fontMetrics.stringWidth("" + cArray[i]) + 2) < 250 - fontMetrics.getMaxAdvance()) continue;
            n3 = 2;
            n4 += fontMetrics.getMaxAscent() + fontMetrics.getMaxDescent() + n / 2;
        }
        try {
            String string = n2 == 1 ? "bold" : "";
            object = new File(font + "_" + string + "_" + n + ".png");
            if (!((File)object).exists()) {
                ((File)object).createNewFile();
            }
            ImageIO.write((RenderedImage)bufferedImage, "png", (File)object);
            object = new File(font + "_" + string + "_" + n + ".fmi");
            PrintWriter printWriter = new PrintWriter((File)object);
            printWriter.write(fontMetrics.getAscent() + "\n");
            printWriter.write(fontMetrics.getDescent() + "\n");
            printWriter.write(fontMetrics.getMaxAscent() + "\n");
            printWriter.write(fontMetrics.getMaxDescent() + "\n");
            printWriter.write(cArray.length + "\n");
            int n5 = 0;
            for (char c : cArray) {
                printWriter.write(this._l[n5] + "\t");
                printWriter.write(this._m[n5] + "\t");
                printWriter.write(this._n[n5] + "\t");
                printWriter.write(this._o[n5] + "\n");
                ++n5;
            }
            printWriter.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void _b(String string, int n, int n2) throws IOException {
        String string2 = n2 == 1 ? "bold" : "";
        ResourceLocation resourceLocation = new ResourceLocation("auction", "fonts/" + string + "_" + string2 + "_" + n + ".fmi");
        this._f = new ResourceLocation("auction", "fonts/" + string + "_" + string2 + "_" + n + ".png");
        htyg htyg2 = xpzm._E()._S()._a(resourceLocation);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(htyg2._a()));){
            this._g = Integer.parseInt(bufferedReader.readLine());
            this._h = Integer.parseInt(bufferedReader.readLine());
            this._i = Integer.parseInt(bufferedReader.readLine());
            this._j = Integer.parseInt(bufferedReader.readLine());
            int n3 = Integer.parseInt(bufferedReader.readLine());
            this._k = new char[n3];
            this._l = new int[n3];
            this._m = new int[n3];
            this._n = new int[n3];
            this._o = new int[n3];
            this._c = "";
            for (int i = 0; i < n3; ++i) {
                this._k[i] = _a.charAt(i);
                this._c = this._c + this._k[i];
                String[] stringArray = bufferedReader.readLine().split("\t");
                this._l[i] = Integer.parseInt(stringArray[0]);
                this._m[i] = Integer.parseInt(stringArray[1]);
                this._n[i] = Integer.parseInt(stringArray[2]);
                this._o[i] = Integer.parseInt(stringArray[3]);
            }
        }
    }

    public void _a(String string, double d, double d2, int n) {
        int n2 = n & 0xFF000000;
        int n3 = (n & 0xFCFCFC) >> 2;
        this._b(string, d + 1.0, d2 + 1.0, n3 += n2);
        this._b(string, d, d2, n);
    }

    public void _a(String string, double d, double d2, int n, float f) {
        String[] stringArray = string.split(_b);
        double d3 = -1.0;
        for (int i = 0; i < stringArray.length; ++i) {
            d3 = this._a(stringArray[i]);
            this._b(stringArray[i], d - d3 / 2.0, d2 + (double)(i * (int)(10.0f * f)), n);
        }
    }

    public void _b(String string, double d, double d2, int n, float f) {
        String[] stringArray = string.split(_b);
        double d3 = -1.0;
        for (int i = 0; i < stringArray.length; ++i) {
            d3 = this._a(stringArray[i]);
            this._a(stringArray[i], d - d3 / 2.0, d2 + (double)(i * (int)(10.0f * f)), n);
        }
    }

    public void _b(String string, double d, double d2, int n) {
        if (string == null) {
            return;
        }
        double d3 = 1.0 / this._r;
        d = (int)d;
        d2 = (int)d2;
        GL11.glScaled(d3, d3, d3);
        d *= this._r;
        d2 *= this._r;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(3553);
        xpzm._E()._R()._a(this._f);
        float f = (float)(n >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n & 0xFF) / 255.0f;
        float f4 = (float)(n >> 24 & 0xFF) / 255.0f;
        GL11.glColor4f(f, f2, f3, f4);
        double d4 = d;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\t') {
                this._a('|', d, d2);
                this._a('|', d - 1.0, d2);
            }
            if (string.indexOf(_b, i) == i) {
                d2 += (double)(this._g + 2);
                d = d4;
                continue;
            }
            int n2 = this._c.indexOf(c);
            if (n2 < 0) continue;
            char c2 = this._k[n2];
            this._a(c, d, d2);
            d += (double)this._n[n2];
        }
        GL11.glScaled(this._r, this._r, this._r);
    }

    public double _a(String string) {
        return this._c(string).getWidth() / this._r;
    }

    public double _b(String string) {
        return this._c(string).getHeight() / this._r;
    }

    private Rectangle _c(String string) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < string.length(); ++i) {
            int n4;
            char c = string.charAt(i);
            if (string.indexOf(_b, i) == i) {
                n2 += this._g + 2;
                if (n3 > n) {
                    n = n3;
                }
                n3 = 0;
            }
            if ((n4 = this._c.indexOf(c)) < 0) continue;
            char c2 = this._k[n4];
            n3 += this._n[n4];
        }
        if (n3 > n) {
            n = n3;
        }
        return new Rectangle(0, 0, n, n2 += this._g);
    }

    public String _a(String string, int n, int n2) {
        String string2 = "";
        int n3 = 0;
        int n4 = 0;
        for (char c : string.toCharArray()) {
            if (string.indexOf(_b, n4) == n4) {
                n -= n2 - n3;
                ++n4;
                n3 = 0;
                string2 = string2 + ' ';
                continue;
            }
            if (n3 >= n2) {
                n3 = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (!(this._a(stringBuilder.append(string2).append(c).toString()) <= (double)n)) break;
            string2 = string2 + c;
            n3 = (int)((double)n3 + this._a("" + c));
            ++n4;
        }
        return string2;
    }

    public String _a(String string, int n) {
        String string2 = "";
        int n2 = 0;
        for (char c : string.toCharArray()) {
            if (string.indexOf(_b, n2) == n2) {
                string2 = string2 + ' ';
                ++n2;
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (!(this._a(stringBuilder.append(string2).append(c).toString()) <= (double)n)) break;
            string2 = string2 + c;
            ++n2;
        }
        return string2;
    }

    public String _b(String string, int n) {
        String string2 = string;
        while (this._a(string2) > (double)n) {
            string2 = string2.substring(1);
        }
        return string2;
    }

    public String _c(String string, int n) {
        if (string == null) {
            return null;
        }
        String string2 = "";
        for (String string3 : string.split(" ")) {
            String string4 = "";
            string4 = string2.contains(_b) ? string2.substring(string2.lastIndexOf(_b)) + string3 : string2 + string3;
            string2 = this._a(string4) > (double)n ? string2 + _b + string3 : string2 + " " + string3;
        }
        return string2.trim();
    }

    public String _d(String string, int n) {
        if (string == null) {
            return null;
        }
        String string2 = "";
        for (char c : string.toCharArray()) {
            String string3 = "";
            string3 = string2.contains(_b) ? string2.substring(string2.lastIndexOf(_b)) + c : string2 + c;
            string2 = this._a(string3) > (double)n ? string2 + _b + c : string2 + c;
        }
        return string2;
    }

    private void _a(char c, double d, double d2) {
        int n = this._c.indexOf(c);
        if (n < 0) {
            return;
        }
        this._a(d, d2, this._l[n], this._m[n], this._n[n], this._o[n] + this._j);
    }

    public void _a(double d, double d2, double d3, double d4, double d5, double d6) {
        this._a(d, d2, d3, d4, d5, d6, 256.0, 256.0);
    }

    public void _a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(d, d2, d5, d6, d3, d4, d3 + d5, d4 + d6, d7, d8);
    }

    static {
        if (!_e) {
            try {
                htyg htyg2 = xpzm._E()._S()._a(_d);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(htyg2._a(), "UTF-8"));
                _a = bufferedReader.readLine().substring(1);
                bufferedReader.close();
                _e = true;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        _b = System.getProperty("line.separator");
    }
}

