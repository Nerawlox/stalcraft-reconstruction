/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.jxtc;
import gloomyfolken.mods.weapon.pidb;
import java.io.File;
import java.util.Collections;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.FileUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class yuni
extends gqjz {
    private static final ResourceLocation _e = new ResourceLocation("weapons", "textures/gui/weapondev.png");
    public xrpu _a;
    private int _f = 0;
    private static final int _g = 0;
    private static final int _h = 1;
    private static final int _i = 2;
    private static final int _j = 3;
    private static final int _k = 4;
    private static final int _l = 5;
    private static final int _m = 6;
    private static final int _n = 7;
    private static final int _o = 8;
    private static final int _p = 9;
    private static final int _q = 10;
    private static final int _r = 11;
    private static final int _s = 12;
    private static final int _t = 13;
    private static final int _u = 14;
    private static final int _v = 15;
    private static final int _w = 16;
    private static final int _x = 17;
    private static final int _y = 18;
    private static final int _z = 19;
    private static final int _A = 20;
    private static final int _B = 21;
    private static final int _C = 55;
    private static final int _D = 56;
    private static final int _E = 57;
    private static final int _F = 22;
    private static final int _G = 23;
    private static final int _H = 24;
    private static final int _I = 25;
    private static final int _J = 26;
    private static final int _K = 27;
    private static final int _L = 28;
    private static final int _M = 29;
    private static final int _N = 30;
    private static final int _O = 58;
    private static final int _P = 59;
    private static final int _Q = 60;
    private static final int _R = 31;
    private static final int _S = 32;
    private static final int _T = 33;
    private static final int _U = 34;
    private static final int _V = 35;
    private static final int _W = 36;
    private static final int _X = 37;
    private static final int _Y = 38;
    private static final int _Z = 39;
    private static final int __aa = 40;
    private static final int __ab = 41;
    private static final int __ac = 42;
    private static final int __ad = 43;
    private static final int __ae = 44;
    private static final int __af = 45;
    private static final int __ag = 61;
    private static final int __ah = 46;
    private static final int __ai = 47;
    private static final int __aj = 48;
    private static final int __ak = 49;
    private static final int __al = 50;
    private static final int __am = 51;
    private static final int __an = 52;
    private static final int __ao = 53;
    private static final int __ap = 54;
    private static float __aq = 0.02f;
    public static boolean _b = true;
    public static boolean _c;
    private int __ar;
    public static boolean _d;

    public yuni(xrpu xrpu2) {
        this._a = xrpu2;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(1, 26, 73, 20, 20, "<-"));
        this.field_73887_h.add(new jiok(0, 50, 73, 20, 20, "->"));
        this.field_73887_h.add(new jiok(2, 5, 7, 86, 20, "\u0422\u0435\u043a\u0441\u0442\u0443\u0440\u0430 \u043f\u0440\u0438\u0446\u0435\u043b\u0430: " + (_b ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.")));
        this.field_73887_h.add(new jiok(3, 5, 29, 86, 20, "\u041f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u0435: " + (_c ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.")));
        this.field_73887_h.add(new jiok(40, 5, 51, 86, 20, "\u0412\u044b\u0441\u0442\u0440\u0435\u043b\u0438\u0442\u044c"));
        this.field_73887_h.add(new jiok(5, 115, 104, 10, 8, "-"));
        this.field_73887_h.add(new jiok(4, 125, 104, 10, 8, "+"));
        this.field_73887_h.add(new jiok(6, 135, 104, 10, 8, "x"));
        this.field_73887_h.add(new jiok(8, 115, 114, 10, 8, "-"));
        this.field_73887_h.add(new jiok(7, 125, 114, 10, 8, "+"));
        this.field_73887_h.add(new jiok(9, 135, 114, 10, 8, "x"));
        this.field_73887_h.add(new jiok(11, 115, 124, 10, 8, "-"));
        this.field_73887_h.add(new jiok(10, 125, 124, 10, 8, "+"));
        this.field_73887_h.add(new jiok(12, 135, 124, 10, 8, "x"));
        this.field_73887_h.add(new jiok(14, 115, 134, 10, 8, "-"));
        this.field_73887_h.add(new jiok(13, 125, 134, 10, 8, "+"));
        this.field_73887_h.add(new jiok(15, 135, 134, 10, 8, "x"));
        this.field_73887_h.add(new jiok(17, 115, 144, 10, 8, "-"));
        this.field_73887_h.add(new jiok(16, 125, 144, 10, 8, "+"));
        this.field_73887_h.add(new jiok(18, 135, 144, 10, 8, "x"));
        this.field_73887_h.add(new jiok(20, 115, 154, 10, 8, "-"));
        this.field_73887_h.add(new jiok(19, 125, 154, 10, 8, "+"));
        this.field_73887_h.add(new jiok(21, 135, 154, 10, 8, "x"));
        this.field_73887_h.add(new jiok(29, 115, 164, 10, 8, "-"));
        this.field_73887_h.add(new jiok(28, 125, 164, 10, 8, "+"));
        this.field_73887_h.add(new jiok(30, 135, 164, 10, 8, "x"));
        this.field_73887_h.add(new jiok(59, 115, 174, 10, 8, "-"));
        this.field_73887_h.add(new jiok(58, 125, 174, 10, 8, "+"));
        this.field_73887_h.add(new jiok(60, 135, 174, 10, 8, "x"));
        this.field_73887_h.add(new jiok(56, 115, 184, 10, 8, "-"));
        this.field_73887_h.add(new jiok(55, 125, 184, 10, 8, "+"));
        this.field_73887_h.add(new jiok(57, 135, 184, 10, 8, "x"));
        this.field_73887_h.add(new jiok(23, 115, 194, 10, 8, "-"));
        this.field_73887_h.add(new jiok(22, 125, 194, 10, 8, "+"));
        this.field_73887_h.add(new jiok(24, 135, 194, 10, 8, "x"));
        this.field_73887_h.add(new jiok(26, 115, 204, 10, 8, "-"));
        this.field_73887_h.add(new jiok(25, 125, 204, 10, 8, "+"));
        this.field_73887_h.add(new jiok(27, 135, 204, 10, 8, "x"));
        this.field_73887_h.add(new jiok(32, 115, 214, 10, 8, "-"));
        this.field_73887_h.add(new jiok(31, 125, 214, 10, 8, "+"));
        this.field_73887_h.add(new jiok(33, 135, 214, 10, 8, "x"));
        this.field_73887_h.add(new jiok(35, 115, 224, 10, 8, "-"));
        this.field_73887_h.add(new jiok(34, 125, 224, 10, 8, "+"));
        this.field_73887_h.add(new jiok(36, 135, 224, 10, 8, "x"));
        this.field_73887_h.add(new jiok(38, 115, 234, 10, 8, "-"));
        this.field_73887_h.add(new jiok(37, 125, 234, 10, 8, "+"));
        this.field_73887_h.add(new jiok(39, 135, 234, 10, 8, "x"));
        this.field_73887_h.add(new jiok(42, 115, 244, 10, 8, "-"));
        this.field_73887_h.add(new jiok(41, 125, 244, 10, 8, "+"));
        this.field_73887_h.add(new jiok(43, 135, 244, 10, 8, "x"));
        this.field_73887_h.add(new jiok(46, 148, 135, 20, 20, "-"));
        this.field_73887_h.add(new jiok(47, 148, 157, 20, 20, "+"));
        this.field_73887_h.add(new jiok(48, 148, 179, 20, 20, "x"));
        this.field_73887_h.add(new jiok(49, 115, 254, 10, 8, "-"));
        this.field_73887_h.add(new jiok(50, 125, 254, 10, 8, "+"));
        this.field_73887_h.add(new jiok(51, 135, 254, 10, 8, "x"));
        this.field_73887_h.add(new jiok(52, 115, 264, 10, 8, "-"));
        this.field_73887_h.add(new jiok(53, 125, 264, 10, 8, "+"));
        this.field_73887_h.add(new jiok(54, 135, 264, 10, 8, "x"));
        this.field_73887_h.add(new jiok(44, 8, 274, 78, 20, "\u0417\u0430\u043f\u0438\u0441\u0430\u0442\u044c \u0432 \u0444\u0430\u0439\u043b"));
        this.field_73887_h.add(new jiok(45, 90, 274, 78, 20, "\u0412\u0438\u0434 \u0441\u043b\u0435\u0432\u0430: " + (_d ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.")));
        this.field_73887_h.add(new jiok(61, 8, 294, 160, 20, "\u0417\u0430\u043f\u0438\u0441\u0430\u0442\u044c \u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u043f\u0440\u0438\u0446\u0435\u043b\u0430"));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        switch (jiok2.field_73741_f) {
            case 0: {
                this._f -= 10;
                break;
            }
            case 1: {
                this._f += 10;
                break;
            }
            case 2: {
                _b = !_b;
                jiok2.field_73744_e = "\u0422\u0435\u043a\u0441\u0442\u0443\u0440\u0430 \u043f\u0440\u0438\u0446\u0435\u043b\u0430: " + (_b ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
                break;
            }
            case 3: {
                _c = !_c;
                jiok2.field_73744_e = "\u041f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u0435: " + (_c ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
                break;
            }
            case 40: {
                if (this.field_73882_e._t == null || this.field_73882_e._t.func_71045_bC() == null || !(this.field_73882_e._t.func_71045_bC()._a() instanceof wolf)) break;
                pidb._a(true);
                break;
            }
            case 5: {
                this._a._f -= __aq;
                break;
            }
            case 4: {
                this._a._f += __aq;
                break;
            }
            case 6: {
                this._a._f = 0.0f;
                break;
            }
            case 8: {
                this._a._g -= __aq;
                break;
            }
            case 7: {
                this._a._g += __aq;
                break;
            }
            case 9: {
                this._a._g = 0.0f;
                break;
            }
            case 11: {
                this._a._h -= __aq;
                break;
            }
            case 10: {
                this._a._h += __aq;
                break;
            }
            case 12: {
                this._a._h = 0.0f;
                break;
            }
            case 14: {
                this._a._i -= __aq;
                break;
            }
            case 13: {
                this._a._i += __aq;
                break;
            }
            case 15: {
                this._a._i = 0.0f;
                break;
            }
            case 17: {
                this._a._j -= __aq;
                break;
            }
            case 16: {
                this._a._j += __aq;
                break;
            }
            case 18: {
                this._a._j = 0.0f;
                break;
            }
            case 20: {
                this._a._k -= __aq;
                break;
            }
            case 19: {
                this._a._k += __aq;
                break;
            }
            case 21: {
                this._a._k = 0.0f;
                break;
            }
            case 29: {
                this._a._d -= __aq * 25.0f;
                break;
            }
            case 28: {
                this._a._d += __aq * 25.0f;
                break;
            }
            case 30: {
                this._a._d = 0.0f;
                break;
            }
            case 59: {
                this._a._e -= __aq * 25.0f;
                break;
            }
            case 58: {
                this._a._e += __aq * 25.0f;
                break;
            }
            case 60: {
                this._a._e = 0.0f;
                break;
            }
            case 56: {
                this._a._a -= __aq;
                break;
            }
            case 55: {
                this._a._a += __aq;
                break;
            }
            case 57: {
                this._a._a = 0.0f;
                break;
            }
            case 23: {
                this._a._b -= __aq;
                break;
            }
            case 22: {
                this._a._b += __aq;
                break;
            }
            case 24: {
                this._a._b = 0.0f;
                break;
            }
            case 26: {
                this._a._c -= __aq;
                break;
            }
            case 25: {
                this._a._c += __aq;
                break;
            }
            case 27: {
                this._a._c = 0.0f;
                break;
            }
            case 32: {
                this._a._o = Math.max(0.0f, this._a._o - __aq * 2.5f);
                break;
            }
            case 31: {
                this._a._o += __aq * 2.5f;
                break;
            }
            case 33: {
                this._a._o = 1.0f;
                break;
            }
            case 35: {
                this._a._p -= __aq;
                break;
            }
            case 34: {
                this._a._p += __aq;
                break;
            }
            case 36: {
                this._a._p = -0.1f;
                break;
            }
            case 38: {
                this._a._n = Math.max(0, this._a._n - 1);
                break;
            }
            case 37: {
                this._a._n = Math.min(twcp._a._a(), this._a._n + 1);
                break;
            }
            case 39: {
                this._a._n = 1;
                break;
            }
            case 41: {
                this._a._q += __aq;
                break;
            }
            case 42: {
                this._a._q -= __aq;
                break;
            }
            case 43: {
                this._a._q = 0.0f;
                break;
            }
            case 44: {
                this._a._b();
                break;
            }
            case 45: {
                if (!_d) {
                    this.__ar = this.field_73882_e._M.field_74320_O;
                    this.field_73882_e._M.field_74320_O = 1;
                    this.field_73882_e._t.field_70177_z = 90.0f;
                    this.field_73882_e._t.field_70761_aq = 90.0f;
                    this.field_73882_e._t.field_70125_A = 0.0f;
                } else {
                    this.field_73882_e._M.field_74320_O = this.__ar;
                }
                _d = !_d;
                jiok2.field_73744_e = "\u0412\u0438\u0434 \u0441\u043b\u0435\u0432\u0430: " + (_d ? "\u0432\u043a\u043b." : "\u0432\u044b\u043a\u043b.");
                break;
            }
            case 61: {
                this._a();
                break;
            }
            case 47: {
                __aq *= 1.3333334f;
                break;
            }
            case 46: {
                __aq *= 0.75f;
                break;
            }
            case 48: {
                __aq = 0.02f;
                break;
            }
            case 50: {
                this._a._l += __aq;
                break;
            }
            case 49: {
                this._a._l -= __aq;
                break;
            }
            case 51: {
                this._a._l = 0.0f;
                break;
            }
            case 53: {
                this._a._m += __aq;
                break;
            }
            case 52: {
                this._a._m -= __aq;
                break;
            }
            case 54: {
                this._a._m = 0.0f;
            }
        }
    }

    private void _a() {
        try {
            Object object;
            Vector3f vector3f;
            cvzo cvzo2 = this.field_73882_e._t.func_70694_bm();
            pjux pjux2 = pjux._a(cvzo2._d);
            jywl jywl2 = ((jxtc)pjux2._d._u_()).getSkeleton();
            zxbe zxbe2 = uiaq._k()._e();
            jytp jytp2 = new jytp(new nuco(), "idle");
            dxwc.pidb pidb2 = ((wolf)cvzo2._a())._O(cvzo2);
            if (pidb2 == null) {
                vector3f = new Vector3f();
            } else {
                object = jywl2._a(pidb2._r);
                ivtm ivtm2 = zxbe2._a(Collections.singletonList(jytp2), true, 0.0f);
                vector3f = ivtm2._a[((jywl.kjui)object)._c];
            }
            object = new File("sightpos.txt");
            FileUtils.writeStringToFile((File)object, String.format("posX: %f;\nposY: %f;\nposZ: %f;\nbonePosX: %f;\nbonePosY: %f;\nbonePosZ: %f;\nrotX: %f;\nrotY: %f;\n", Float.valueOf(this._a._a), Float.valueOf(this._a._b), Float.valueOf(this._a._c), Float.valueOf(vector3f.x), Float.valueOf(vector3f.y), Float.valueOf(vector3f.z), Float.valueOf(this._a._d), Float.valueOf(this._a._e)));
            this.field_73882_e._t.func_71035_c("\u0424\u0430\u0439\u043b \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d \u043a\u0430\u043a sightpos.txt");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void func_73874_b() {
        _b = true;
        _c = false;
        _d = false;
    }

    @Override
    public boolean func_73868_f() {
        return false;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(_e);
        this.func_73729_b(0, 0, 0, 0, 176, 240);
        this.func_73729_b(0, 240, 0, 197, 176, 59);
        if (_d) {
            this.field_73882_e._t.field_70177_z = 90.0f;
            this.field_73882_e._t.field_70761_aq = 90.0f;
            this.field_73882_e._t.field_70125_A = 0.0f;
        }
        if (_c) {
            this.field_73882_e._h._a(bawa.field_110324_m);
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            this.func_73729_b(this.field_73880_f / 2 - 7, this.field_73881_g / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(3042);
        }
        this._b();
        this._c();
        super.func_73863_a(n, n2, f);
    }

    private void _b() {
        this.func_73731_b(this.field_73886_k, "\u041f\u0435\u0440\u0432\u043e\u0435 \u043b\u0438\u0446\u043e, X: " + String.format("%.3f", Float.valueOf(this._a._f)), 5, 104, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u041f\u0435\u0440\u0432\u043e\u0435 \u043b\u0438\u0446\u043e, Y: " + String.format("%.3f", Float.valueOf(this._a._g)), 5, 114, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u041f\u0435\u0440\u0432\u043e\u0435 \u043b\u0438\u0446\u043e, Z: " + String.format("%.3f", Float.valueOf(this._a._h)), 5, 124, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u0422\u0440\u0435\u0442\u044c\u0435 \u043b\u0438\u0446\u043e, X: " + String.format("%.3f", Float.valueOf(this._a._i)), 5, 134, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u0422\u0440\u0435\u0442\u044c\u0435 \u043b\u0438\u0446\u043e, Y: " + String.format("%.3f", Float.valueOf(this._a._j)), 5, 144, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u0422\u0440\u0435\u0442\u044c\u0435 \u043b\u0438\u0446\u043e, Z: " + String.format("%.3f", Float.valueOf(this._a._k)), 5, 154, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u041f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u0435, RX: " + String.format("%.2f", Float.valueOf(this._a._d)), 5, 164, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u041f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u0435, RY: " + String.format("%.2f", Float.valueOf(this._a._e)), 5, 174, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u041f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u0435, X: " + String.format("%.3f", Float.valueOf(this._a._a)), 5, 184, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u041f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u0435, Y: " + String.format("%.3f", Float.valueOf(this._a._b)), 5, 194, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u041f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u0435, Z: " + String.format("%.3f", Float.valueOf(this._a._c)), 5, 204, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u0420\u0430\u0437\u043c\u0435\u0440 \u0432\u0441\u043f\u044b\u0448\u043a\u0438: " + String.format("%.3f", Float.valueOf(this._a._o)), 5, 214, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u0414\u0438\u0441\u0442\u0430\u043d\u0446\u0438\u044f \u0432\u0441\u043f\u044b\u0448\u043a\u0438: " + String.format("%.3f", Float.valueOf(this._a._p)), 5, 224, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u0422\u0438\u043f \u0432\u0441\u043f\u044b\u0448\u043a\u0438: " + twcp._a._a(this._a._n), 5, 234, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u0414\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u043f\u0440\u0438\u0446\u0435\u043b\u0430: " + String.format("%.3f", Float.valueOf(this._a._q)), 5, 244, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u041b\u0435\u0432\u0430\u044f \u0440\u0443\u043a\u0430, Y: " + String.format("%.3f", Float.valueOf(this._a._l)), 5, 254, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u041b\u0435\u0432\u0430\u044f \u0440\u0443\u043a\u0430, Z: " + String.format("%.3f", Float.valueOf(this._a._m)), 5, 264, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, "\u0428\u0430\u0433:", 148, 115, 0xFFFFFF);
        this.func_73731_b(this.field_73886_k, String.format("%.3f", Float.valueOf(__aq)), 148, 125, 0xFFFFFF);
    }

    private void _c() {
        EntityClientPlayerMP entityClientPlayerMP = this.field_73882_e._t;
        float f = 140.0f;
        float f2 = 85.0f;
        float f3 = 40.0f;
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(f, f2, 50.0f);
        GL11.glScalef(-f3, f3, f3);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        float f4 = entityClientPlayerMP.field_70761_aq;
        float f5 = entityClientPlayerMP.field_70177_z;
        float f6 = entityClientPlayerMP.field_70125_A;
        float f7 = entityClientPlayerMP.field_70758_at;
        float f8 = entityClientPlayerMP.field_70759_as;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-((float)Math.atan(0.0)) * 20.0f, 1.0f, 0.0f, 0.0f);
        entityClientPlayerMP.field_70761_aq = this._f;
        entityClientPlayerMP.field_70177_z = this._f;
        entityClientPlayerMP.field_70125_A = -((float)Math.atan(0.0)) * 20.0f;
        entityClientPlayerMP.field_70759_as = entityClientPlayerMP.field_70177_z;
        entityClientPlayerMP.field_70758_at = entityClientPlayerMP.field_70177_z;
        GL11.glTranslatef(0.0f, entityClientPlayerMP.field_70129_M, 0.0f);
        gqqu._b._l = 180.0f;
        eidj._a._c();
        gqqu._b._a(entityClientPlayerMP, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        ezfa._a._a();
        entityClientPlayerMP.field_70761_aq = f4;
        entityClientPlayerMP.field_70177_z = f5;
        entityClientPlayerMP.field_70125_A = f6;
        entityClientPlayerMP.field_70758_at = f7;
        entityClientPlayerMP.field_70759_as = f8;
        GL11.glPopMatrix();
        qnon._a();
        GL11.glDisable(32826);
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
    }
}

