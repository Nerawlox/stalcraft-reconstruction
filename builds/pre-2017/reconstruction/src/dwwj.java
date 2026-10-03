/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.Logger;
import java.util.Properties;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.opengl.GL11;

public class dwwj
implements Comparable<dwwj> {
    public String _a = null;
    public int _b;
    private int _o = -1;
    private int _p = -1;
    private int _q = -1;
    private int _r = -1;
    private int _s = 0;
    private boolean _t = false;
    private float _u = 1.0f;
    private float[] _v = _n;
    ResourceLocation _c;
    boolean _d;
    public final String _e;
    public static final int _f = 0;
    public static final int _g = 1;
    public static final int _h = 2;
    public static final int _i = 3;
    public static final int _j = 4;
    public static final int _k = 5;
    public static final int _l = 6;
    public static final int _m = 7;
    public static final float[] _n = new float[]{1.0f, 0.0f, 0.0f};

    public dwwj(Properties properties) {
        this._a = properties.getProperty("source");
        this._o = this._b(properties.getProperty("startFadeIn"));
        this._p = this._b(properties.getProperty("endFadeIn"));
        this._q = this._b(properties.getProperty("startFadeOut"));
        this._r = this._b(properties.getProperty("endFadeOut"));
        this._s = this._c(properties.getProperty("blend"));
        this._t = this._a(properties.getProperty("rotate"), true);
        this._u = this._a(properties.getProperty("speed"), 1.0f);
        this._v = this._a(properties.getProperty("axis"), _n);
        this._e = properties.getProperty("type", "sun");
        this._d = this._a(properties.getProperty("envMap"), true);
        this._b = this._a(properties.getProperty("layer"), 0);
    }

    void _a() {
        this._c = new ResourceLocation(this._a);
        fmib._b(this._c)._a(34067);
    }

    private int _b(String string) {
        try {
            if (string == null) {
                return -1;
            }
            String[] stringArray = StringUtils.split(string, ":");
            if (stringArray.length != 2) {
                Logger.warning("Invalid time: " + string, new Object[0]);
                return -1;
            }
            String string2 = stringArray[0];
            String string3 = stringArray[1];
            int n = Integer.parseInt(string2);
            int n2 = Integer.parseInt(string3);
            if (n < 0 || n > 23 || n2 < 0 || n2 > 59) {
                Logger.warning("Invalid time: " + string, new Object[0]);
                return -1;
            }
            if (n >= 6 && n < 18) {
                int n3 = n - 6;
                return (int)(((double)n3 + (double)n2 / 60.0) * (double)(ytsw._c / 12));
            }
            int n4 = n >= 18 ? n - 18 : n + 6;
            return ytsw._c + (int)(((double)n4 + (double)n2 / 60.0) * (double)(ytsw._d / 12));
        }
        catch (Exception exception) {
            Logger.warning("Can not parse time: " + string, new Object[0]);
            return -1;
        }
    }

    private int _c(String string) {
        if (string == null) {
            return 0;
        }
        if (string.equals("add")) {
            return 0;
        }
        if (string.equals("subtract")) {
            return 1;
        }
        if (string.equals("multiply")) {
            return 2;
        }
        if (string.equals("dodge")) {
            return 3;
        }
        if (string.equals("burn")) {
            return 4;
        }
        if (string.equals("screen")) {
            return 5;
        }
        if (string.equals("replace")) {
            return 6;
        }
        if (string.equals("normal")) {
            return 7;
        }
        Logger.warning("Unknown blend: " + string, new Object[0]);
        return 0;
    }

    private boolean _a(String string, boolean bl) {
        if (string == null) {
            return bl;
        }
        if (string.toLowerCase().equals("true")) {
            return true;
        }
        if (string.toLowerCase().equals("false")) {
            return false;
        }
        Logger.warning("Unknown boolean: " + string, new Object[0]);
        return bl;
    }

    private float _a(String string, float f) {
        try {
            if (string == null) {
                return f;
            }
            return Float.parseFloat(string);
        }
        catch (NumberFormatException numberFormatException) {
            Logger.warning("Can not parse float: " + string, new Object[0]);
            return f;
        }
    }

    private int _a(String string, int n) {
        try {
            if (string == null) {
                return n;
            }
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            Logger.warning("Can not parse float: " + string, new Object[0]);
            return n;
        }
    }

    private float[] _a(String string, float[] fArray) {
        if (string == null) {
            return fArray;
        }
        String[] stringArray = StringUtils.split(string, " ");
        if (stringArray.length != 3) {
            Logger.warning("Invalid axis: " + string, new Object[0]);
            return fArray;
        }
        float[] fArray2 = new float[3];
        for (int i = 0; i < stringArray.length; ++i) {
            fArray2[i] = this._a(stringArray[i], fArray[i]);
            if (!(fArray2[i] < -1.0f) && !(fArray2[i] > 1.0f)) continue;
            Logger.warning("Invalid axis values: " + string, new Object[0]);
            return fArray;
        }
        float f = fArray2[0];
        float f2 = fArray2[1];
        float f3 = fArray2[2];
        if (f * f + f2 * f2 + f3 * f3 < 1.0E-5f) {
            Logger.warning("Invalid axis values: " + string, new Object[0]);
            return fArray;
        }
        float[] fArray3 = new float[]{f3, f2, -f};
        return fArray3;
    }

    public boolean _a(String string) {
        int n;
        int n2;
        int n3;
        int n4;
        if (this._a == null) {
            Logger.warning("No source texture: " + string, new Object[0]);
            return false;
        }
        if (this._o < 0 || this._p < 0 || this._r < 0) {
            Logger.warning("Invalid times, required are: startFadeIn, endFadeIn and endFadeOut.", new Object[0]);
            return false;
        }
        int n5 = this._b(this._p - this._o);
        if (this._q < 0) {
            this._q = this._b(this._r - n5);
        }
        if ((n4 = n5 + (n3 = this._b(this._q - this._p)) + (n2 = this._b(this._r - this._q)) + (n = this._b(this._o - this._r))) != ytsw._e) {
            Logger.warning("Invalid fadeIn/fadeOut times, sum is more than 24h: " + n4, new Object[0]);
            return false;
        }
        if (this._u < 0.0f) {
            Logger.warning("Invalid speed: " + this._u, new Object[0]);
            return false;
        }
        return true;
    }

    private int _b(int n) {
        while (n >= ytsw._e) {
            n -= ytsw._e;
        }
        while (n < 0) {
            n += ytsw._e;
        }
        return n;
    }

    void _a(int n, float f, float f2) {
        float f3 = f2 * this._c(n);
        if ((f3 = sajh._a(f3, 0.0f, 1.0f)) < 1.0E-4f) {
            return;
        }
        this._a(f3);
        Minecraft._E()._h._a(this._c);
        GL11.glPushMatrix();
        if (this._t) {
            GL11.glRotatef(f * 360.0f * this._u, this._v[0], this._v[1], this._v[2]);
        }
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glDisable(3553);
        GL11.glEnable(34067);
        GL11.glBegin(7);
        this._d(0);
        this._d(1);
        this._d(2);
        this._d(3);
        this._d(4);
        this._d(5);
        GL11.glEnd();
        GL11.glDisable(34067);
        GL11.glEnable(3553);
        GL11.glPopMatrix();
    }

    private float _c(int n) {
        if (this._a(n, this._o, this._p)) {
            float f = this._b(this._p - this._o);
            float f2 = this._b(n - this._o);
            return f2 / f;
        }
        if (this._a(n, this._p, this._q)) {
            return 1.0f;
        }
        if (this._a(n, this._q, this._r)) {
            float f = this._b(this._r - this._q);
            float f3 = this._b(n - this._q);
            return 1.0f - f3 / f;
        }
        return 0.0f;
    }

    private void _d(int n) {
        if (n == 0) {
            this._a(-50.0f, -50.0f, -50.0f);
            this._a(-50.0f, -50.0f, 50.0f);
            this._a(50.0f, -50.0f, 50.0f);
            this._a(50.0f, -50.0f, -50.0f);
        }
        if (n == 1) {
            this._a(-50.0f, 50.0f, -50.0f);
            this._a(50.0f, 50.0f, -50.0f);
            this._a(50.0f, 50.0f, 50.0f);
            this._a(-50.0f, 50.0f, 50.0f);
        }
        if (n == 2) {
            this._a(-50.0f, -50.0f, -50.0f);
            this._a(50.0f, -50.0f, -50.0f);
            this._a(50.0f, 50.0f, -50.0f);
            this._a(-50.0f, 50.0f, -50.0f);
        }
        if (n == 3) {
            this._a(-50.0f, -50.0f, 50.0f);
            this._a(-50.0f, 50.0f, 50.0f);
            this._a(50.0f, 50.0f, 50.0f);
            this._a(50.0f, -50.0f, 50.0f);
        }
        if (n == 4) {
            this._a(-50.0f, -50.0f, -50.0f);
            this._a(-50.0f, 50.0f, -50.0f);
            this._a(-50.0f, 50.0f, 50.0f);
            this._a(-50.0f, -50.0f, 50.0f);
        }
        if (n == 5) {
            this._a(50.0f, -50.0f, -50.0f);
            this._a(50.0f, -50.0f, 50.0f);
            this._a(50.0f, 50.0f, 50.0f);
            this._a(50.0f, 50.0f, -50.0f);
        }
    }

    private void _a(float f, float f2, float f3) {
        GL11.glTexCoord3f(f, f2, f3);
        GL11.glVertex3f(f, f2, f3);
    }

    void _a(float f) {
        switch (this._s) {
            case 0: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 1);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
                break;
            }
            case 1: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(775, 0);
                GL11.glColor4f(f, f, f, 1.0f);
                break;
            }
            case 2: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(774, 771);
                GL11.glColor4f(f, f, f, f);
                break;
            }
            case 3: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(1, 1);
                GL11.glColor4f(f, f, f, 1.0f);
                break;
            }
            case 4: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(0, 769);
                GL11.glColor4f(f, f, f, 1.0f);
                break;
            }
            case 5: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(1, 769);
                GL11.glColor4f(f, f, f, 1.0f);
                break;
            }
            case 6: {
                GL11.glEnable(3008);
                GL11.glDisable(3042);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
            }
            case 7: {
                GL11.glEnable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
            }
        }
        GL11.glAlphaFunc(516, 0.01f);
    }

    public boolean _a(int n) {
        return !this._a(n, this._r, this._o);
    }

    private boolean _a(int n, int n2, int n3) {
        if (n2 <= n3) {
            return n >= n2 && n <= n3;
        }
        return n >= n2 || n <= n3;
    }

    public int _a(dwwj dwwj2) {
        return Integer.compare(this._b, dwwj2._b);
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this._a((dwwj)object);
    }
}

