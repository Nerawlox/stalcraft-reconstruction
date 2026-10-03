/*
 * Decompiled with CFR 0.152.
 */
import carpentersblocks.renderer.helper.VertexHelper;
import mcoptifine.Config;
import mcoptifine.ConnectedProperties;
import mcoptifine.ConnectedTextures;
import mcoptifine.CustomColorizer;
import mcoptifine.NaturalProperties;
import mcoptifine.NaturalTextures;
import mcoptifine.Reflector;
import mcoptifine.TextureUtils;
import net.minecraft.client.xpzm;
import net.minecraft.util.dwan;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;
import org.lwjgl.opengl.GL11;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public class htvc {
    public sdrg _a;
    public dwan _b;
    public boolean _c;
    public boolean _d;
    public static boolean _e = true;
    public static boolean _f = true;
    public boolean _g = true;
    public double _h;
    public double _i;
    public double _j;
    public double _k;
    public double _l;
    public double _m;
    public boolean _n;
    public boolean _o;
    public final xpzm _p;
    public int _q;
    public int _r;
    public int _s;
    public int _t;
    public int _u;
    public int _v;
    public boolean _w;
    public float _x;
    public float _y;
    public float _z;
    public float _A;
    public float _B;
    public float _C;
    public float _D;
    public float _E;
    public float _F;
    public float _G;
    public float _H;
    public float _I;
    public float _J;
    public float _K;
    public float _L;
    public float _M;
    public float _N;
    public float _O;
    public float _P;
    public float _Q;
    public int _R;
    public int _S;
    public int _T;
    public int _U;
    public int _V;
    public int _W;
    public int _X;
    public int _Y;
    public int _Z;
    public int __aa;
    public int __ab;
    public int __ac;
    public int __ad;
    public int __ae;
    public int __af;
    public int __ag;
    public int __ah;
    public int __ai;
    public int __aj;
    public int __ak;
    public int __al;
    public int __am;
    public int __an;
    public int __ao;
    public float __ap;
    public float __aq;
    public float __ar;
    public float __as;
    public float __at;
    public float __au;
    public float __av;
    public float __aw;
    public float __ax;
    public float __ay;
    public float __az;
    public float __aA;
    public boolean __aB;
    public float __aC = 0.2f;
    public boolean __aD = true;
    public VertexHelper __aE = new VertexHelper();
    public htvf __aF = htvf.field_78398_a;

    public htvc(sdrg sdrg2) {
        this._a = sdrg2;
        this._p = xpzm._E();
        this.__aC = 1.0f - Config.getAmbientOcclusionLevel() * 0.8f;
    }

    public htvc() {
        this._p = xpzm._E();
    }

    public void _a(dwan dwan2) {
        this._b = dwan2;
    }

    public void _a() {
        this._b = null;
    }

    public boolean _b() {
        return this._b != null;
    }

    public void _a(double d, double d2, double d3, double d4, double d5, double d6) {
        if (!this._n) {
            this._h = d;
            this._i = d4;
            this._j = d2;
            this._k = d5;
            this._l = d3;
            this._m = d6;
            this._o = this._p._M.field_74348_k >= 2 && (this._h > 0.0 || this._i < 1.0 || this._j > 0.0 || this._k < 1.0 || this._l > 0.0 || this._m < 1.0);
        }
    }

    public void _a(twgu twgu2) {
        if (!this._n) {
            this._h = twgu2.func_83009_v();
            this._i = twgu2.func_83007_w();
            this._j = twgu2.func_83008_x();
            this._k = twgu2.func_83010_y();
            this._l = twgu2.func_83005_z();
            this._m = twgu2.func_83006_A();
            this._o = this._p._M.field_74348_k >= 2 && (this._h > 0.0 || this._i < 1.0 || this._j > 0.0 || this._k < 1.0 || this._l > 0.0 || this._m < 1.0);
        }
    }

    public void _b(double d, double d2, double d3, double d4, double d5, double d6) {
        this._h = d;
        this._i = d4;
        this._j = d2;
        this._k = d5;
        this._l = d3;
        this._m = d6;
        this._n = true;
        this._o = this._p._M.field_74348_k >= 2 && (this._h > 0.0 || this._i < 1.0 || this._j > 0.0 || this._k < 1.0 || this._l > 0.0 || this._m < 1.0);
    }

    public void _c() {
        this._n = false;
    }

    public void _a(twgu twgu2, int n, int n2, int n3, dwan dwan2) {
        this._a(dwan2);
        this._b(twgu2, n, n2, n3);
        this._a();
    }

    public void _a(twgu twgu2, int n, int n2, int n3) {
        this._d = true;
        this._b(twgu2, n, n2, n3);
        this._d = false;
    }

    public boolean _b(twgu twgu2, int n, int n2, int n3) {
        int n4 = BlockRendererList.onRenderBlockHook(this, twgu2, n, n2, n3);
        if (n4 != 0) {
            return n4 != 0;
        }
        n4 = twgu2.func_71857_b();
        if (n4 == -1) {
            return false;
        }
        twgu2.func_71902_a(this._a, n, n2, n3);
        if (Config.isBetterSnow() && twgu2 == twgu.field_72053_aD && this._a(n, n2, n3)) {
            this._a(n, n2, n3, twgu.field_72037_aS.field_72022_cl);
        }
        this._a(twgu2);
        switch (n4) {
            case 0: {
                return this._q(twgu2, n, n2, n3);
            }
            case 1: {
                return this._l(twgu2, n, n2, n3);
            }
            case 2: {
                return this._d(twgu2, n, n2, n3);
            }
            case 3: {
                return this._a((nuxa)twgu2, n, n2, n3);
            }
            case 4: {
                return this._p(twgu2, n, n2, n3);
            }
            case 5: {
                return this._i(twgu2, n, n2, n3);
            }
            case 6: {
                return this._n(twgu2, n, n2, n3);
            }
            case 7: {
                return this._u(twgu2, n, n2, n3);
            }
            case 8: {
                return this._j(twgu2, n, n2, n3);
            }
            case 9: {
                return this._a((scgt)twgu2, n, n2, n3);
            }
            case 10: {
                return this._a((yuxu)twgu2, n, n2, n3);
            }
            case 11: {
                return this._a((htgl)twgu2, n, n2, n3);
            }
            case 12: {
                return this._f(twgu2, n, n2, n3);
            }
            case 13: {
                return this._t(twgu2, n, n2, n3);
            }
            case 14: {
                return this._c(twgu2, n, n2, n3);
            }
            case 15: {
                return this._a((hcgl)twgu2, n, n2, n3);
            }
            case 16: {
                return this._a(twgu2, n, n2, n3, false);
            }
            case 17: {
                return this._c(twgu2, n, n2, n3, true);
            }
            case 18: {
                return this._a((zxyg)twgu2, n, n2, n3);
            }
            case 19: {
                return this._m(twgu2, n, n2, n3);
            }
            case 20: {
                return this._k(twgu2, n, n2, n3);
            }
            case 21: {
                return this._a((kloa)twgu2, n, n2, n3);
            }
            case 23: {
                return this._o(twgu2, n, n2, n3);
            }
            case 24: {
                return this._a((iwhh)twgu2, n, n2, n3);
            }
            case 25: {
                return this._a((baro)twgu2, n, n2, n3);
            }
            case 26: {
                return this._a((uigs)twgu2, n, n2, n3);
            }
            case 27: {
                return this._a((yutb)twgu2, n, n2, n3);
            }
            case 28: {
                return this._a((woni)twgu2, n, n2, n3);
            }
            case 29: {
                return this._g(twgu2, n, n2, n3);
            }
            case 30: {
                return this._h(twgu2, n, n2, n3);
            }
            case 31: {
                return this._r(twgu2, n, n2, n3);
            }
            case 32: {
                return this._a((ifiu)twgu2, n, n2, n3);
            }
            case 33: {
                return this._a((vlnw)twgu2, n, n2, n3);
            }
            case 34: {
                return this._a((cdtx)twgu2, n, n2, n3);
            }
            case 35: {
                return this._a((scce)twgu2, n, n2, n3);
            }
            case 36: {
                return this._a((uims)twgu2, n, n2, n3);
            }
            case 37: {
                return this._a((aool)twgu2, n, n2, n3);
            }
            case 38: {
                return this._a((ndvl)twgu2, n, n2, n3);
            }
            case 39: {
                return this._s(twgu2, n, n2, n3);
            }
        }
        return FMLRenderAccessLibrary.renderWorldBlock(this, this._a, n, n2, n3, twgu2, n4);
    }

    public boolean _a(uigs uigs2, int n, int n2, int n3) {
        int n4 = this._a.func_72805_g(n, n2, n3);
        int n5 = n4 & 3;
        if (n5 == 0) {
            this._u = 3;
        } else if (n5 == 3) {
            this._u = 1;
        } else if (n5 == 1) {
            this._u = 2;
        }
        if (!uigs._a(n4)) {
            this._a(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0);
            this._q(uigs2, n, n2, n3);
            this._u = 0;
            return true;
        }
        this._d = true;
        this._a(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0);
        this._q(uigs2, n, n2, n3);
        this._a(uigs2._a());
        this._a(0.25, 0.8125, 0.25, 0.75, 1.0, 0.75);
        this._q(uigs2, n, n2, n3);
        this._d = false;
        this._a();
        this._u = 0;
        return true;
    }

    public boolean _c(twgu twgu2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        int n4 = this._a.func_72805_g(n, n2, n3);
        int n5 = gqbt._d(n4);
        boolean bl = gqbt._a(n4);
        if (Reflector.ForgeBlock_getBedDirection.exists()) {
            n5 = Reflector.callInt(twgu2, Reflector.ForgeBlock_getBedDirection, this._a, n, n2, n3);
        }
        if (Reflector.ForgeBlock_isBedFoot.exists()) {
            bl = Reflector.callBoolean(twgu2, Reflector.ForgeBlock_isBedFoot, this._a, n, n2, n3);
        }
        float f = 0.5f;
        float f2 = 1.0f;
        float f3 = 0.8f;
        float f4 = 0.6f;
        int n6 = twgu2.func_71874_e(this._a, n, n2, n3);
        htvf2.func_78380_c(n6);
        htvf2.func_78386_a(f, f, f);
        dwan dwan2 = this._a(twgu2, this._a, n, n2, n3, 0);
        if (this._b != null) {
            dwan2 = this._b;
        }
        double d = dwan2.func_94209_e();
        double d2 = dwan2.func_94212_f();
        double d3 = dwan2.func_94206_g();
        double d4 = dwan2.func_94210_h();
        double d5 = (double)n + this._h;
        double d6 = (double)n + this._i;
        double d7 = (double)n2 + this._j + 0.1875;
        double d8 = (double)n3 + this._l;
        double d9 = (double)n3 + this._m;
        htvf2.func_78374_a(d5, d7, d9, d, d4);
        htvf2.func_78374_a(d5, d7, d8, d, d3);
        htvf2.func_78374_a(d6, d7, d8, d2, d3);
        htvf2.func_78374_a(d6, d7, d9, d2, d4);
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2 + 1, n3));
        htvf2.func_78386_a(f2, f2, f2);
        dwan2 = this._a(twgu2, this._a, n, n2, n3, 1);
        if (this._b != null) {
            dwan2 = this._b;
        }
        d = dwan2.func_94209_e();
        d2 = dwan2.func_94212_f();
        d3 = dwan2.func_94206_g();
        d4 = dwan2.func_94210_h();
        d5 = d;
        d6 = d2;
        d7 = d3;
        d8 = d3;
        d9 = d;
        double d10 = d2;
        double d11 = d4;
        double d12 = d4;
        if (n5 == 0) {
            d6 = d;
            d7 = d4;
            d9 = d2;
            d12 = d3;
        } else if (n5 == 2) {
            d5 = d2;
            d8 = d4;
            d10 = d;
            d11 = d3;
        } else if (n5 == 3) {
            d5 = d2;
            d8 = d4;
            d10 = d;
            d11 = d3;
            d6 = d;
            d7 = d4;
            d9 = d2;
            d12 = d3;
        }
        double d13 = (double)n + this._h;
        double d14 = (double)n + this._i;
        double d15 = (double)n2 + this._k;
        double d16 = (double)n3 + this._l;
        double d17 = (double)n3 + this._m;
        htvf2.func_78374_a(d14, d15, d17, d9, d11);
        htvf2.func_78374_a(d14, d15, d16, d5, d7);
        htvf2.func_78374_a(d13, d15, d16, d6, d8);
        htvf2.func_78374_a(d13, d15, d17, d10, d12);
        int n7 = ugqx._d[n5];
        if (bl) {
            n7 = ugqx._d[ugqx._f[n5]];
        }
        int n8 = 4;
        switch (n5) {
            case 0: {
                n8 = 5;
                break;
            }
            case 1: {
                n8 = 3;
            }
            default: {
                break;
            }
            case 3: {
                n8 = 2;
            }
        }
        if (n7 != 2 && (this._d || twgu2.func_71877_c(this._a, n, n2, n3 - 1, 2))) {
            htvf2.func_78380_c(this._l > 0.0 ? n6 : twgu2.func_71874_e(this._a, n, n2, n3 - 1));
            htvf2.func_78386_a(f3, f3, f3);
            this._c = n8 == 2;
            this._c(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 2));
        }
        if (n7 != 3 && (this._d || twgu2.func_71877_c(this._a, n, n2, n3 + 1, 3))) {
            htvf2.func_78380_c(this._m < 1.0 ? n6 : twgu2.func_71874_e(this._a, n, n2, n3 + 1));
            htvf2.func_78386_a(f3, f3, f3);
            this._c = n8 == 3;
            this._d(twgu2, n, n2, n3, this._a(twgu2, this._a, n, n2, n3, 3));
        }
        if (n7 != 4 && (this._d || twgu2.func_71877_c(this._a, n - 1, n2, n3, 4))) {
            htvf2.func_78380_c(this._l > 0.0 ? n6 : twgu2.func_71874_e(this._a, n - 1, n2, n3));
            htvf2.func_78386_a(f4, f4, f4);
            this._c = n8 == 4;
            this._e(twgu2, n, n2, n3, this._a(twgu2, this._a, n, n2, n3, 4));
        }
        if (n7 != 5 && (this._d || twgu2.func_71877_c(this._a, n + 1, n2, n3, 5))) {
            htvf2.func_78380_c(this._m < 1.0 ? n6 : twgu2.func_71874_e(this._a, n + 1, n2, n3));
            htvf2.func_78386_a(f4, f4, f4);
            this._c = n8 == 5;
            this._f(twgu2, n, n2, n3, this._a(twgu2, this._a, n, n2, n3, 5));
        }
        this._c = false;
        return true;
    }

    public boolean _a(baro baro2, int n, int n2, int n3) {
        this._a(0.4375, 0.0, 0.4375, 0.5625, 0.875, 0.5625);
        this._q(baro2, n, n2, n3);
        this._a(baro2._a());
        this._d = true;
        this._a(0.5625, 0.0, 0.3125, 0.9375, 0.125, 0.6875);
        this._q(baro2, n, n2, n3);
        this._a(0.125, 0.0, 0.0625, 0.5, 0.125, 0.4375);
        this._q(baro2, n, n2, n3);
        this._a(0.125, 0.0, 0.5625, 0.5, 0.125, 0.9375);
        this._q(baro2, n, n2, n3);
        this._d = false;
        this._a();
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(baro2.func_71874_e(this._a, n, n2, n3));
        float f = 1.0f;
        int n4 = baro2.func_71920_b(this._a, n, n2, n3);
        float f2 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n4 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        htvf2.func_78386_a(f * f2, f * f3, f * f4);
        dwan dwan2 = this._a((twgu)baro2, 0, 0);
        if (this._b()) {
            dwan2 = this._b;
        }
        double d = dwan2.func_94206_g();
        double d2 = dwan2.func_94210_h();
        int n5 = this._a.func_72805_g(n, n2, n3);
        for (int i = 0; i < 3; ++i) {
            double d3 = (double)i * Math.PI * 2.0 / 3.0 + 1.5707963267948966;
            double d4 = dwan2.func_94214_a(8.0);
            double d5 = dwan2.func_94212_f();
            if ((n5 & 1 << i) != 0) {
                d5 = dwan2.func_94209_e();
            }
            double d6 = (double)n + 0.5;
            double d7 = (double)n + 0.5 + Math.sin(d3) * 8.0 / 16.0;
            double d8 = (double)n3 + 0.5;
            double d9 = (double)n3 + 0.5 + Math.cos(d3) * 8.0 / 16.0;
            htvf2.func_78374_a(d6, n2 + 1, d8, d4, d);
            htvf2.func_78374_a(d6, n2 + 0, d8, d4, d2);
            htvf2.func_78374_a(d7, n2 + 0, d9, d5, d2);
            htvf2.func_78374_a(d7, n2 + 1, d9, d5, d);
            htvf2.func_78374_a(d7, n2 + 1, d9, d5, d);
            htvf2.func_78374_a(d7, n2 + 0, d9, d5, d2);
            htvf2.func_78374_a(d6, n2 + 0, d8, d4, d2);
            htvf2.func_78374_a(d6, n2 + 1, d8, d4, d);
        }
        baro2.func_71919_f();
        return true;
    }

    public boolean _a(iwhh iwhh2, int n, int n2, int n3) {
        float f;
        this._q(iwhh2, n, n2, n3);
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(iwhh2.func_71874_e(this._a, n, n2, n3));
        float f2 = 1.0f;
        int n4 = iwhh2.func_71920_b(this._a, n, n2, n3);
        float f3 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n4 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            float f6 = (f3 * 30.0f + f4 * 59.0f + f5 * 11.0f) / 100.0f;
            f = (f3 * 30.0f + f4 * 70.0f) / 100.0f;
            float f7 = (f3 * 30.0f + f5 * 70.0f) / 100.0f;
            f3 = f6;
            f4 = f;
            f5 = f7;
        }
        htvf2.func_78386_a(f2 * f3, f2 * f4, f2 * f5);
        dwan dwan2 = iwhh2.func_71851_a(2);
        f = 0.125f;
        this._f(iwhh2, (float)n - 1.0f + f, n2, n3, dwan2);
        this._e(iwhh2, (float)n + 1.0f - f, n2, n3, dwan2);
        this._d(iwhh2, n, n2, (float)n3 - 1.0f + f, dwan2);
        this._c((twgu)iwhh2, (double)n, (double)n2, (float)n3 + 1.0f - f, dwan2);
        dwan dwan3 = iwhh._a("inner");
        this._b((twgu)iwhh2, (double)n, (float)n2 - 1.0f + 0.25f, (double)n3, dwan3);
        this._a((twgu)iwhh2, (double)n, (double)((float)n2 + 1.0f - 0.75f), (double)n3, dwan3);
        int n5 = this._a.func_72805_g(n, n2, n3);
        if (n5 > 0) {
            dwan dwan4 = ogyy._a("water_still");
            if (n5 > 3) {
                n5 = 3;
            }
            int n6 = CustomColorizer.getFluidColor(twgu.field_71943_B, this._a, n, n2, n3);
            float f8 = (float)(n6 >> 16 & 0xFF) / 255.0f;
            float f9 = (float)(n6 >> 8 & 0xFF) / 255.0f;
            float f10 = (float)(n6 & 0xFF) / 255.0f;
            htvf2.func_78386_a(f8, f9, f10);
            this._b((twgu)iwhh2, (double)n, (float)n2 - 1.0f + (6.0f + (float)n5 * 3.0f) / 16.0f, (double)n3, dwan4);
        }
        return true;
    }

    public boolean _a(vlnw vlnw2, int n, int n2, int n3) {
        float f;
        float f2;
        this._q(vlnw2, n, n2, n3);
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(vlnw2.func_71874_e(this._a, n, n2, n3));
        float f3 = 1.0f;
        int n4 = vlnw2.func_71920_b(this._a, n, n2, n3);
        dwan dwan2 = this._a(vlnw2, 0);
        float f4 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n4 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            f2 = (f4 * 30.0f + f5 * 59.0f + f6 * 11.0f) / 100.0f;
            float f7 = (f4 * 30.0f + f5 * 70.0f) / 100.0f;
            f = (f4 * 30.0f + f6 * 70.0f) / 100.0f;
            f4 = f2;
            f5 = f7;
            f6 = f;
        }
        htvf2.func_78386_a(f3 * f4, f3 * f5, f3 * f6);
        f2 = 0.1865f;
        this._f(vlnw2, (float)n - 0.5f + f2, n2, n3, dwan2);
        this._e(vlnw2, (float)n + 0.5f - f2, n2, n3, dwan2);
        this._d(vlnw2, n, n2, (float)n3 - 0.5f + f2, dwan2);
        this._c((twgu)vlnw2, (double)n, (double)n2, (float)n3 + 0.5f - f2, dwan2);
        this._b((twgu)vlnw2, (double)n, (float)n2 - 0.5f + f2 + 0.1875f, (double)n3, this._b(twgu.field_71979_v));
        int n5 = this._a.func_72805_g(n, n2, n3);
        if (n5 != 0) {
            f = 0.0f;
            float f8 = 4.0f;
            float f9 = 0.0f;
            aorr aorr2 = null;
            switch (n5) {
                case 1: {
                    aorr2 = twgu.field_72107_ae;
                    break;
                }
                case 2: {
                    aorr2 = twgu.field_72097_ad;
                }
                default: {
                    break;
                }
                case 7: {
                    aorr2 = twgu.field_72103_ag;
                    break;
                }
                case 8: {
                    aorr2 = twgu.field_72109_af;
                }
            }
            htvf2.func_78372_c(f / 16.0f, f8 / 16.0f, f9 / 16.0f);
            this.__aD = false;
            if (aorr2 != null) {
                this._b(aorr2, n, n2, n3);
            } else if (n5 == 9) {
                this._d = true;
                float f10 = 0.125f;
                this._a(0.5f - f10, 0.0, (double)(0.5f - f10), (double)(0.5f + f10), 0.25, (double)(0.5f + f10));
                this._q(twgu.field_72038_aV, n, n2, n3);
                this._a(0.5f - f10, 0.25, (double)(0.5f - f10), (double)(0.5f + f10), 0.5, (double)(0.5f + f10));
                this._q(twgu.field_72038_aV, n, n2, n3);
                this._a(0.5f - f10, 0.5, (double)(0.5f - f10), (double)(0.5f + f10), 0.75, (double)(0.5f + f10));
                this._q(twgu.field_72038_aV, n, n2, n3);
                this._d = false;
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (n5 == 3) {
                this._a(twgu.field_71987_y, 0, (double)n, (double)n2, (double)n3, 0.75f);
            } else if (n5 == 5) {
                this._a(twgu.field_71987_y, 2, (double)n, (double)n2, (double)n3, 0.75f);
            } else if (n5 == 4) {
                this._a(twgu.field_71987_y, 1, (double)n, (double)n2, (double)n3, 0.75f);
            } else if (n5 == 6) {
                this._a(twgu.field_71987_y, 3, (double)n, (double)n2, (double)n3, 0.75f);
            } else if (n5 == 11) {
                n4 = twgu.field_71962_X.func_71920_b(this._a, n, n2, n3);
                f4 = (float)(n4 >> 16 & 0xFF) / 255.0f;
                f5 = (float)(n4 >> 8 & 0xFF) / 255.0f;
                f6 = (float)(n4 & 0xFF) / 255.0f;
                htvf2.func_78386_a(f3 * f4, f3 * f5, f3 * f6);
                this._a((twgu)twgu.field_71962_X, 2, (double)n, (double)n2, (double)n3, 0.75f);
            } else if (n5 == 10) {
                this._a((twgu)twgu.field_71961_Y, 2, (double)n, (double)n2, (double)n3, 0.75f);
            }
            htvf2.func_78372_c(-f / 16.0f, -f8 / 16.0f, -f9 / 16.0f);
        }
        this.__aD = true;
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, twgu.field_72037_aS.field_72022_cl);
        }
        return true;
    }

    public boolean _a(scce scce2, int n, int n2, int n3) {
        return this._a(scce2, n, n2, n3, this._a.func_72805_g(n, n2, n3));
    }

    public boolean _a(scce scce2, int n, int n2, int n3, int n4) {
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(scce2.func_71874_e(this._a, n, n2, n3));
        float f = 1.0f;
        int n5 = scce2.func_71920_b(this._a, n, n2, n3);
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        htvf2.func_78386_a(f * f2, f * f3, f * f4);
        return this._a(scce2, n, n2, n3, n4, false);
    }

    public boolean _a(scce scce2, int n, int n2, int n3, int n4, boolean bl) {
        int n5 = bl ? 0 : n4 & 3;
        boolean bl2 = false;
        float f = 0.0f;
        switch (n5) {
            case 0: {
                this._s = 2;
                this._t = 1;
                this._u = 3;
                this._v = 3;
                break;
            }
            case 1: {
                this._q = 1;
                this._r = 2;
                this._u = 2;
                this._v = 1;
                bl2 = true;
                break;
            }
            case 2: {
                this._s = 1;
                this._t = 2;
                break;
            }
            case 3: {
                this._q = 2;
                this._r = 1;
                this._u = 1;
                this._v = 2;
                bl2 = true;
            }
        }
        f = this._a(scce2, n, n2, n3, 0, f, 0.75f, 0.25f, 0.75f, bl2, bl, n4);
        f = this._a(scce2, n, n2, n3, 1, f, 0.5f, 0.0625f, 0.625f, bl2, bl, n4);
        f = this._a(scce2, n, n2, n3, 2, f, 0.25f, 0.3125f, 0.5f, bl2, bl, n4);
        this._a(scce2, n, n2, n3, 3, f, 0.625f, 0.375f, 1.0f, bl2, bl, n4);
        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        this._q = 0;
        this._r = 0;
        this._s = 0;
        this._t = 0;
        this._u = 0;
        this._v = 0;
        return true;
    }

    public float _a(scce scce2, int n, int n2, int n3, int n4, float f, float f2, float f3, float f4, boolean bl, boolean bl2, int n5) {
        if (bl) {
            float f5 = f2;
            f2 = f4;
            f4 = f5;
        }
        scce2._c = n4;
        this._a(0.5f - (f2 /= 2.0f), f, (double)(0.5f - (f4 /= 2.0f)), (double)(0.5f + f2), (double)(f + f3), (double)(0.5f + f4));
        if (bl2) {
            htvf htvf2 = this.__aF;
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
            this._a((twgu)scce2, 0.0, 0.0, 0.0, this._a((twgu)scce2, 0, n5));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
            this._b((twgu)scce2, 0.0, 0.0, 0.0, this._a((twgu)scce2, 1, n5));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
            this._c((twgu)scce2, 0.0, 0.0, 0.0, this._a((twgu)scce2, 2, n5));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
            this._d(scce2, 0.0, 0.0, 0.0, this._a((twgu)scce2, 3, n5));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
            this._e(scce2, 0.0, 0.0, 0.0, this._a((twgu)scce2, 4, n5));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
            this._f(scce2, 0.0, 0.0, 0.0, this._a((twgu)scce2, 5, n5));
            htvf2.func_78381_a();
        } else {
            this._q(scce2, n, n2, n3);
        }
        return f + f3;
    }

    public boolean _d(twgu twgu2, int n, int n2, int n3) {
        int n4 = this._a.func_72805_g(n, n2, n3);
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
        htvf2.func_78386_a(1.0f, 1.0f, 1.0f);
        double d = 0.4f;
        double d2 = 0.5 - d;
        double d3 = 0.2f;
        if (n4 == 1) {
            this._a(twgu2, (double)n - d2, (double)n2 + d3, (double)n3, -d, 0.0, 0);
        } else if (n4 == 2) {
            this._a(twgu2, (double)n + d2, (double)n2 + d3, (double)n3, d, 0.0, 0);
        } else if (n4 == 3) {
            this._a(twgu2, (double)n, (double)n2 + d3, (double)n3 - d2, 0.0, -d, 0);
        } else if (n4 == 4) {
            this._a(twgu2, (double)n, (double)n2 + d3, (double)n3 + d2, 0.0, d, 0);
        } else {
            this._a(twgu2, (double)n, (double)n2, (double)n3, 0.0, 0.0, 0);
            if (twgu2 != twgu.field_72069_aq && Config.isBetterSnow() && this._a(n, n2, n3)) {
                this._a(n, n2, n3, twgu.field_72037_aS.field_72022_cl);
            }
        }
        return true;
    }

    public boolean _a(hcgl hcgl2, int n, int n2, int n3) {
        int n4 = this._a.func_72805_g(n, n2, n3);
        int n5 = n4 & 3;
        int n6 = (n4 & 0xC) >> 2;
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(hcgl2.func_71874_e(this._a, n, n2, n3));
        htvf2.func_78386_a(1.0f, 1.0f, 1.0f);
        double d = -0.1875;
        boolean bl = hcgl2._b(this._a, n, n2, n3, n4);
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        switch (n5) {
            case 0: {
                d5 = -0.3125;
                d3 = hcgl._b[n6];
                break;
            }
            case 1: {
                d4 = 0.3125;
                d2 = -hcgl._b[n6];
                break;
            }
            case 2: {
                d5 = 0.3125;
                d3 = -hcgl._b[n6];
                break;
            }
            case 3: {
                d4 = -0.3125;
                d2 = hcgl._b[n6];
            }
        }
        if (!bl) {
            this._a((twgu)hcgl2, (double)n + d2, (double)n2 + d, (double)n3 + d3, 0.0, 0.0, 0);
        } else {
            dwan dwan2 = this._b(twgu.field_71986_z);
            this._a(dwan2);
            float f = 2.0f;
            float f2 = 14.0f;
            float f3 = 7.0f;
            float f4 = 9.0f;
            switch (n5) {
                case 1: 
                case 3: {
                    f = 7.0f;
                    f2 = 9.0f;
                    f3 = 2.0f;
                    f4 = 14.0f;
                }
            }
            this._a(f / 16.0f + (float)d2, 0.125, (double)(f3 / 16.0f + (float)d3), (double)(f2 / 16.0f + (float)d2), 0.25, (double)(f4 / 16.0f + (float)d3));
            double d6 = dwan2.func_94214_a(f);
            double d7 = dwan2.func_94207_b(f3);
            double d8 = dwan2.func_94214_a(f2);
            double d9 = dwan2.func_94207_b(f4);
            htvf2.func_78374_a((double)((float)n + f / 16.0f) + d2, (float)n2 + 0.25f, (double)((float)n3 + f3 / 16.0f) + d3, d6, d7);
            htvf2.func_78374_a((double)((float)n + f / 16.0f) + d2, (float)n2 + 0.25f, (double)((float)n3 + f4 / 16.0f) + d3, d6, d9);
            htvf2.func_78374_a((double)((float)n + f2 / 16.0f) + d2, (float)n2 + 0.25f, (double)((float)n3 + f4 / 16.0f) + d3, d8, d9);
            htvf2.func_78374_a((double)((float)n + f2 / 16.0f) + d2, (float)n2 + 0.25f, (double)((float)n3 + f3 / 16.0f) + d3, d8, d7);
            this._q(hcgl2, n, n2, n3);
            this._a(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
            this._a();
        }
        htvf2.func_78380_c(hcgl2.func_71874_e(this._a, n, n2, n3));
        htvf2.func_78386_a(1.0f, 1.0f, 1.0f);
        this._a((twgu)hcgl2, (double)n + d4, (double)n2 + d, (double)n3 + d5, 0.0, 0.0, 0);
        this._a((uims)hcgl2, n, n2, n3);
        return true;
    }

    public boolean _a(aool aool2, int n, int n2, int n3) {
        dwan dwan2;
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(aool2.func_71874_e(this._a, n, n2, n3));
        htvf2.func_78386_a(1.0f, 1.0f, 1.0f);
        int n4 = this._a.func_72805_g(n, n2, n3);
        int n5 = n4 & 3;
        double d = 0.0;
        double d2 = -0.1875;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        if (aool2._c(n4)) {
            dwan2 = twgu.field_72035_aQ.func_71851_a(0);
        } else {
            d2 -= 0.1875;
            dwan2 = twgu.field_72049_aP.func_71851_a(0);
        }
        switch (n5) {
            case 0: {
                d3 = -0.3125;
                d5 = 1.0;
                break;
            }
            case 1: {
                d = 0.3125;
                d4 = -1.0;
                break;
            }
            case 2: {
                d3 = 0.3125;
                d5 = -1.0;
                break;
            }
            case 3: {
                d = -0.3125;
                d4 = 1.0;
            }
        }
        this._a((twgu)aool2, (double)n + 0.25 * d4 + 0.1875 * d5, (float)n2 - 0.1875f, (double)n3 + 0.25 * d5 + 0.1875 * d4, 0.0, 0.0, n4);
        this._a((twgu)aool2, (double)n + 0.25 * d4 + -0.1875 * d5, (float)n2 - 0.1875f, (double)n3 + 0.25 * d5 + -0.1875 * d4, 0.0, 0.0, n4);
        this._a(dwan2);
        this._a((twgu)aool2, (double)n + d, (double)n2 + d2, (double)n3 + d3, 0.0, 0.0, n4);
        this._a();
        this._a(aool2, n, n2, n3, n5);
        return true;
    }

    public boolean _a(uims uims2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        this._a(uims2, n, n2, n3, this._a.func_72805_g(n, n2, n3) & 3);
        return true;
    }

    public void _a(uims uims2, int n, int n2, int n3, int n4) {
        this._q(uims2, n, n2, n3);
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(uims2.func_71874_e(this._a, n, n2, n3));
        htvf2.func_78386_a(1.0f, 1.0f, 1.0f);
        int n5 = this._a.func_72805_g(n, n2, n3);
        dwan dwan2 = this._a((twgu)uims2, 1, n5);
        double d = dwan2.func_94209_e();
        double d2 = dwan2.func_94212_f();
        double d3 = dwan2.func_94206_g();
        double d4 = dwan2.func_94210_h();
        double d5 = 0.125;
        double d6 = n + 1;
        double d7 = n + 1;
        double d8 = n + 0;
        double d9 = n + 0;
        double d10 = n3 + 0;
        double d11 = n3 + 1;
        double d12 = n3 + 1;
        double d13 = n3 + 0;
        double d14 = (double)n2 + d5;
        if (n4 == 2) {
            d6 = d7 = (double)(n + 0);
            d8 = d9 = (double)(n + 1);
            d10 = d13 = (double)(n3 + 1);
            d11 = d12 = (double)(n3 + 0);
        } else if (n4 == 3) {
            d6 = d9 = (double)(n + 0);
            d7 = d8 = (double)(n + 1);
            d10 = d11 = (double)(n3 + 0);
            d12 = d13 = (double)(n3 + 1);
        } else if (n4 == 1) {
            d6 = d9 = (double)(n + 1);
            d7 = d8 = (double)(n + 0);
            d10 = d11 = (double)(n3 + 1);
            d12 = d13 = (double)(n3 + 0);
        }
        htvf2.func_78374_a(d9, d14, d13, d, d3);
        htvf2.func_78374_a(d8, d14, d12, d, d4);
        htvf2.func_78374_a(d7, d14, d11, d2, d4);
        htvf2.func_78374_a(d6, d14, d10, d2, d3);
    }

    public void _e(twgu twgu2, int n, int n2, int n3) {
        this._d = true;
        this._a(twgu2, n, n2, n3, true);
        this._d = false;
    }

    public boolean _a(twgu twgu2, int n, int n2, int n3, boolean bl) {
        int n4 = this._a.func_72805_g(n, n2, n3);
        boolean bl2 = bl || (n4 & 8) != 0;
        int n5 = cdvp._a(n4);
        float f = 0.25f;
        if (bl2) {
            switch (n5) {
                case 0: {
                    this._q = 3;
                    this._r = 3;
                    this._s = 3;
                    this._t = 3;
                    this._a(0.0, 0.25, 0.0, 1.0, 1.0, 1.0);
                    break;
                }
                case 1: {
                    this._a(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
                    break;
                }
                case 2: {
                    this._s = 1;
                    this._t = 2;
                    this._a(0.0, 0.0, 0.25, 1.0, 1.0, 1.0);
                    break;
                }
                case 3: {
                    this._s = 2;
                    this._t = 1;
                    this._u = 3;
                    this._v = 3;
                    this._a(0.0, 0.0, 0.0, 1.0, 1.0, 0.75);
                    break;
                }
                case 4: {
                    this._q = 1;
                    this._r = 2;
                    this._u = 2;
                    this._v = 1;
                    this._a(0.25, 0.0, 0.0, 1.0, 1.0, 1.0);
                    break;
                }
                case 5: {
                    this._q = 2;
                    this._r = 1;
                    this._u = 1;
                    this._v = 2;
                    this._a(0.0, 0.0, 0.0, 0.75, 1.0, 1.0);
                }
            }
            ((cdvp)twgu2)._a((float)this._h, (float)this._j, (float)this._l, (float)this._i, (float)this._k, (float)this._m);
            this._q(twgu2, n, n2, n3);
            this._q = 0;
            this._r = 0;
            this._s = 0;
            this._t = 0;
            this._u = 0;
            this._v = 0;
            this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            ((cdvp)twgu2)._a((float)this._h, (float)this._j, (float)this._l, (float)this._i, (float)this._k, (float)this._m);
        } else {
            switch (n5) {
                case 0: {
                    this._q = 3;
                    this._r = 3;
                    this._s = 3;
                    this._t = 3;
                }
                default: {
                    break;
                }
                case 2: {
                    this._s = 1;
                    this._t = 2;
                    break;
                }
                case 3: {
                    this._s = 2;
                    this._t = 1;
                    this._u = 3;
                    this._v = 3;
                    break;
                }
                case 4: {
                    this._q = 1;
                    this._r = 2;
                    this._u = 2;
                    this._v = 1;
                    break;
                }
                case 5: {
                    this._q = 2;
                    this._r = 1;
                    this._u = 1;
                    this._v = 2;
                }
            }
            this._q(twgu2, n, n2, n3);
            this._q = 0;
            this._r = 0;
            this._s = 0;
            this._t = 0;
            this._u = 0;
            this._v = 0;
        }
        return true;
    }

    public void _a(double d, double d2, double d3, double d4, double d5, double d6, float f, double d7) {
        dwan dwan2 = cdvp._a("piston_side");
        if (this._b()) {
            dwan2 = this._b;
        }
        htvf htvf2 = this.__aF;
        double d8 = dwan2.func_94209_e();
        double d9 = dwan2.func_94206_g();
        double d10 = dwan2.func_94214_a(d7);
        double d11 = dwan2.func_94207_b(4.0);
        htvf2.func_78386_a(f, f, f);
        htvf2.func_78374_a(d, d4, d5, d10, d9);
        htvf2.func_78374_a(d, d3, d5, d8, d9);
        htvf2.func_78374_a(d2, d3, d6, d8, d11);
        htvf2.func_78374_a(d2, d4, d6, d10, d11);
    }

    public void _b(double d, double d2, double d3, double d4, double d5, double d6, float f, double d7) {
        dwan dwan2 = cdvp._a("piston_side");
        if (this._b()) {
            dwan2 = this._b;
        }
        htvf htvf2 = this.__aF;
        double d8 = dwan2.func_94209_e();
        double d9 = dwan2.func_94206_g();
        double d10 = dwan2.func_94214_a(d7);
        double d11 = dwan2.func_94207_b(4.0);
        htvf2.func_78386_a(f, f, f);
        htvf2.func_78374_a(d, d3, d6, d10, d9);
        htvf2.func_78374_a(d, d3, d5, d8, d9);
        htvf2.func_78374_a(d2, d4, d5, d8, d11);
        htvf2.func_78374_a(d2, d4, d6, d10, d11);
    }

    public void _c(double d, double d2, double d3, double d4, double d5, double d6, float f, double d7) {
        dwan dwan2 = cdvp._a("piston_side");
        if (this._b()) {
            dwan2 = this._b;
        }
        htvf htvf2 = this.__aF;
        double d8 = dwan2.func_94209_e();
        double d9 = dwan2.func_94206_g();
        double d10 = dwan2.func_94214_a(d7);
        double d11 = dwan2.func_94207_b(4.0);
        htvf2.func_78386_a(f, f, f);
        htvf2.func_78374_a(d2, d3, d5, d10, d9);
        htvf2.func_78374_a(d, d3, d5, d8, d9);
        htvf2.func_78374_a(d, d4, d6, d8, d11);
        htvf2.func_78374_a(d2, d4, d6, d10, d11);
    }

    public void _b(twgu twgu2, int n, int n2, int n3, boolean bl) {
        this._d = true;
        this._c(twgu2, n, n2, n3, bl);
        this._d = false;
    }

    public boolean _c(twgu twgu2, int n, int n2, int n3, boolean bl) {
        int n4 = this._a.func_72805_g(n, n2, n3);
        int n5 = hcdp._a(n4);
        float f = 0.25f;
        float f2 = 0.375f;
        float f3 = 0.625f;
        float f4 = twgu2.func_71870_f(this._a, n, n2, n3);
        float f5 = bl ? 1.0f : 0.5f;
        double d = bl ? 16.0 : 8.0;
        switch (n5) {
            case 0: {
                this._q = 3;
                this._r = 3;
                this._s = 3;
                this._t = 3;
                this._a(0.0, 0.0, 0.0, 1.0, 0.25, 1.0);
                this._q(twgu2, n, n2, n3);
                this._a((float)n + 0.375f, (float)n + 0.625f, (float)n2 + 0.25f, (float)n2 + 0.25f + f5, (double)((float)n3 + 0.625f), (double)((float)n3 + 0.625f), f4 * 0.8f, d);
                this._a((float)n + 0.625f, (float)n + 0.375f, (float)n2 + 0.25f, (float)n2 + 0.25f + f5, (double)((float)n3 + 0.375f), (double)((float)n3 + 0.375f), f4 * 0.8f, d);
                this._a((float)n + 0.375f, (float)n + 0.375f, (float)n2 + 0.25f, (float)n2 + 0.25f + f5, (double)((float)n3 + 0.375f), (double)((float)n3 + 0.625f), f4 * 0.6f, d);
                this._a((float)n + 0.625f, (float)n + 0.625f, (float)n2 + 0.25f, (float)n2 + 0.25f + f5, (double)((float)n3 + 0.625f), (double)((float)n3 + 0.375f), f4 * 0.6f, d);
                break;
            }
            case 1: {
                this._a(0.0, 0.75, 0.0, 1.0, 1.0, 1.0);
                this._q(twgu2, n, n2, n3);
                this._a((float)n + 0.375f, (float)n + 0.625f, (float)n2 - 0.25f + 1.0f - f5, (float)n2 - 0.25f + 1.0f, (double)((float)n3 + 0.625f), (double)((float)n3 + 0.625f), f4 * 0.8f, d);
                this._a((float)n + 0.625f, (float)n + 0.375f, (float)n2 - 0.25f + 1.0f - f5, (float)n2 - 0.25f + 1.0f, (double)((float)n3 + 0.375f), (double)((float)n3 + 0.375f), f4 * 0.8f, d);
                this._a((float)n + 0.375f, (float)n + 0.375f, (float)n2 - 0.25f + 1.0f - f5, (float)n2 - 0.25f + 1.0f, (double)((float)n3 + 0.375f), (double)((float)n3 + 0.625f), f4 * 0.6f, d);
                this._a((float)n + 0.625f, (float)n + 0.625f, (float)n2 - 0.25f + 1.0f - f5, (float)n2 - 0.25f + 1.0f, (double)((float)n3 + 0.625f), (double)((float)n3 + 0.375f), f4 * 0.6f, d);
                break;
            }
            case 2: {
                this._s = 1;
                this._t = 2;
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 0.25);
                this._q(twgu2, n, n2, n3);
                this._b((float)n + 0.375f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 + 0.25f, (float)n3 + 0.25f + f5, f4 * 0.6f, d);
                this._b((float)n + 0.625f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 + 0.25f, (float)n3 + 0.25f + f5, f4 * 0.6f, d);
                this._b((float)n + 0.375f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 + 0.25f, (float)n3 + 0.25f + f5, f4 * 0.5f, d);
                this._b((float)n + 0.625f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 + 0.25f, (float)n3 + 0.25f + f5, f4, d);
                break;
            }
            case 3: {
                this._s = 2;
                this._t = 1;
                this._u = 3;
                this._v = 3;
                this._a(0.0, 0.0, 0.75, 1.0, 1.0, 1.0);
                this._q(twgu2, n, n2, n3);
                this._b((float)n + 0.375f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 - 0.25f + 1.0f - f5, (float)n3 - 0.25f + 1.0f, f4 * 0.6f, d);
                this._b((float)n + 0.625f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 - 0.25f + 1.0f - f5, (float)n3 - 0.25f + 1.0f, f4 * 0.6f, d);
                this._b((float)n + 0.375f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 - 0.25f + 1.0f - f5, (float)n3 - 0.25f + 1.0f, f4 * 0.5f, d);
                this._b((float)n + 0.625f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 - 0.25f + 1.0f - f5, (float)n3 - 0.25f + 1.0f, f4, d);
                break;
            }
            case 4: {
                this._q = 1;
                this._r = 2;
                this._u = 2;
                this._v = 1;
                this._a(0.0, 0.0, 0.0, 0.25, 1.0, 1.0);
                this._q(twgu2, n, n2, n3);
                this._c((float)n + 0.25f, (float)n + 0.25f + f5, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.375f, f4 * 0.5f, d);
                this._c((float)n + 0.25f, (float)n + 0.25f + f5, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.625f, f4, d);
                this._c((float)n + 0.25f, (float)n + 0.25f + f5, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.375f, f4 * 0.6f, d);
                this._c((float)n + 0.25f, (float)n + 0.25f + f5, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.625f, f4 * 0.6f, d);
                break;
            }
            case 5: {
                this._q = 2;
                this._r = 1;
                this._u = 1;
                this._v = 2;
                this._a(0.75, 0.0, 0.0, 1.0, 1.0, 1.0);
                this._q(twgu2, n, n2, n3);
                this._c((float)n - 0.25f + 1.0f - f5, (float)n - 0.25f + 1.0f, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.375f, f4 * 0.5f, d);
                this._c((float)n - 0.25f + 1.0f - f5, (float)n - 0.25f + 1.0f, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.625f, f4, d);
                this._c((float)n - 0.25f + 1.0f - f5, (float)n - 0.25f + 1.0f, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.375f, f4 * 0.6f, d);
                this._c((float)n - 0.25f + 1.0f - f5, (float)n - 0.25f + 1.0f, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.625f, f4 * 0.6f, d);
            }
        }
        this._q = 0;
        this._r = 0;
        this._s = 0;
        this._t = 0;
        this._u = 0;
        this._v = 0;
        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        return true;
    }

    public boolean _f(twgu twgu2, int n, int n2, int n3) {
        int n4 = this._a.func_72805_g(n, n2, n3);
        int n5 = n4 & 7;
        boolean bl = (n4 & 8) > 0;
        htvf htvf2 = this.__aF;
        boolean bl2 = this._b();
        if (!bl2) {
            this._a(this._b(twgu.field_71978_w));
        }
        float f = 0.25f;
        float f2 = 0.1875f;
        float f3 = 0.1875f;
        if (n5 == 5) {
            this._a(0.5f - f2, 0.0, (double)(0.5f - f), (double)(0.5f + f2), (double)f3, (double)(0.5f + f));
        } else if (n5 == 6) {
            this._a(0.5f - f, 0.0, (double)(0.5f - f2), (double)(0.5f + f), (double)f3, (double)(0.5f + f2));
        } else if (n5 == 4) {
            this._a(0.5f - f2, 0.5f - f, (double)(1.0f - f3), (double)(0.5f + f2), (double)(0.5f + f), 1.0);
        } else if (n5 == 3) {
            this._a(0.5f - f2, 0.5f - f, 0.0, (double)(0.5f + f2), (double)(0.5f + f), (double)f3);
        } else if (n5 == 2) {
            this._a(1.0f - f3, 0.5f - f, (double)(0.5f - f2), 1.0, (double)(0.5f + f), (double)(0.5f + f2));
        } else if (n5 == 1) {
            this._a(0.0, 0.5f - f, (double)(0.5f - f2), (double)f3, (double)(0.5f + f), (double)(0.5f + f2));
        } else if (n5 == 0) {
            this._a(0.5f - f, 1.0f - f3, (double)(0.5f - f2), (double)(0.5f + f), 1.0, (double)(0.5f + f2));
        } else if (n5 == 7) {
            this._a(0.5f - f2, 1.0f - f3, (double)(0.5f - f), (double)(0.5f + f2), 1.0, (double)(0.5f + f));
        }
        this._q(twgu2, n, n2, n3);
        if (!bl2) {
            this._a();
        }
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
        float f4 = 1.0f;
        if (twgu.field_71984_q[twgu2.field_71990_ca] > 0) {
            f4 = 1.0f;
        }
        htvf2.func_78386_a(f4, f4, f4);
        dwan dwan2 = this._a(twgu2, 0);
        if (this._b()) {
            dwan2 = this._b;
        }
        double d = dwan2.func_94209_e();
        double d2 = dwan2.func_94206_g();
        double d3 = dwan2.func_94212_f();
        double d4 = dwan2.func_94210_h();
        ofbx[] ofbxArray = new ofbx[8];
        float f5 = 0.0625f;
        float f6 = 0.0625f;
        float f7 = 0.625f;
        ofbxArray[0] = this._a.func_82732_R()._a(-f5, 0.0, -f6);
        ofbxArray[1] = this._a.func_82732_R()._a(f5, 0.0, -f6);
        ofbxArray[2] = this._a.func_82732_R()._a(f5, 0.0, f6);
        ofbxArray[3] = this._a.func_82732_R()._a(-f5, 0.0, f6);
        ofbxArray[4] = this._a.func_82732_R()._a(-f5, f7, -f6);
        ofbxArray[5] = this._a.func_82732_R()._a(f5, f7, -f6);
        ofbxArray[6] = this._a.func_82732_R()._a(f5, f7, f6);
        ofbxArray[7] = this._a.func_82732_R()._a(-f5, f7, f6);
        for (int i = 0; i < 8; ++i) {
            if (bl) {
                ofbxArray[i]._e -= 0.0625;
                ofbxArray[i]._a(0.69813174f);
            } else {
                ofbxArray[i]._e += 0.0625;
                ofbxArray[i]._a(-0.69813174f);
            }
            if (n5 == 0 || n5 == 7) {
                ofbxArray[i]._c((float)Math.PI);
            }
            if (n5 == 6 || n5 == 0) {
                ofbxArray[i]._b(1.5707964f);
            }
            if (n5 > 0 && n5 < 5) {
                ofbxArray[i]._d -= 0.375;
                ofbxArray[i]._a(1.5707964f);
                if (n5 == 4) {
                    ofbxArray[i]._b(0.0f);
                }
                if (n5 == 3) {
                    ofbxArray[i]._b((float)Math.PI);
                }
                if (n5 == 2) {
                    ofbxArray[i]._b(1.5707964f);
                }
                if (n5 == 1) {
                    ofbxArray[i]._b(-1.5707964f);
                }
                ofbxArray[i]._c += (double)n + 0.5;
                ofbxArray[i]._d += (double)((float)n2 + 0.5f);
                ofbxArray[i]._e += (double)n3 + 0.5;
                continue;
            }
            if (n5 != 0 && n5 != 7) {
                ofbxArray[i]._c += (double)n + 0.5;
                ofbxArray[i]._d += (double)((float)n2 + 0.125f);
                ofbxArray[i]._e += (double)n3 + 0.5;
                continue;
            }
            ofbxArray[i]._c += (double)n + 0.5;
            ofbxArray[i]._d += (double)((float)n2 + 0.875f);
            ofbxArray[i]._e += (double)n3 + 0.5;
        }
        ofbx ofbx2 = null;
        ofbx ofbx3 = null;
        ofbx ofbx4 = null;
        ofbx ofbx5 = null;
        for (int i = 0; i < 6; ++i) {
            if (i == 0) {
                d = dwan2.func_94214_a(7.0);
                d2 = dwan2.func_94207_b(6.0);
                d3 = dwan2.func_94214_a(9.0);
                d4 = dwan2.func_94207_b(8.0);
            } else if (i == 2) {
                d = dwan2.func_94214_a(7.0);
                d2 = dwan2.func_94207_b(6.0);
                d3 = dwan2.func_94214_a(9.0);
                d4 = dwan2.func_94210_h();
            }
            if (i == 0) {
                ofbx2 = ofbxArray[0];
                ofbx3 = ofbxArray[1];
                ofbx4 = ofbxArray[2];
                ofbx5 = ofbxArray[3];
            } else if (i == 1) {
                ofbx2 = ofbxArray[7];
                ofbx3 = ofbxArray[6];
                ofbx4 = ofbxArray[5];
                ofbx5 = ofbxArray[4];
            } else if (i == 2) {
                ofbx2 = ofbxArray[1];
                ofbx3 = ofbxArray[0];
                ofbx4 = ofbxArray[4];
                ofbx5 = ofbxArray[5];
            } else if (i == 3) {
                ofbx2 = ofbxArray[2];
                ofbx3 = ofbxArray[1];
                ofbx4 = ofbxArray[5];
                ofbx5 = ofbxArray[6];
            } else if (i == 4) {
                ofbx2 = ofbxArray[3];
                ofbx3 = ofbxArray[2];
                ofbx4 = ofbxArray[6];
                ofbx5 = ofbxArray[7];
            } else if (i == 5) {
                ofbx2 = ofbxArray[0];
                ofbx3 = ofbxArray[3];
                ofbx4 = ofbxArray[7];
                ofbx5 = ofbxArray[4];
            }
            htvf2.func_78374_a(ofbx2._c, ofbx2._d, ofbx2._e, d, d4);
            htvf2.func_78374_a(ofbx3._c, ofbx3._d, ofbx3._e, d3, d4);
            htvf2.func_78374_a(ofbx4._c, ofbx4._d, ofbx4._e, d3, d2);
            htvf2.func_78374_a(ofbx5._c, ofbx5._d, ofbx5._e, d, d2);
        }
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, twgu.field_72037_aS.field_72022_cl);
        }
        return true;
    }

    public boolean _g(twgu twgu2, int n, int n2, int n3) {
        int n4;
        htvf htvf2 = this.__aF;
        int n5 = this._a.func_72805_g(n, n2, n3);
        int n6 = n5 & 3;
        boolean bl = (n5 & 4) == 4;
        boolean bl2 = (n5 & 8) == 8;
        boolean bl3 = !this._a.func_72797_t(n, n2 - 1, n3);
        boolean bl4 = this._b();
        if (!bl4) {
            this._a(this._b(twgu.field_71988_x));
        }
        float f = 0.25f;
        float f2 = 0.125f;
        float f3 = 0.125f;
        float f4 = 0.3f - f;
        float f5 = 0.3f + f;
        if (n6 == 2) {
            this._a(0.5f - f2, f4, (double)(1.0f - f3), (double)(0.5f + f2), (double)f5, 1.0);
        } else if (n6 == 0) {
            this._a(0.5f - f2, f4, 0.0, (double)(0.5f + f2), (double)f5, (double)f3);
        } else if (n6 == 1) {
            this._a(1.0f - f3, f4, (double)(0.5f - f2), 1.0, (double)f5, (double)(0.5f + f2));
        } else if (n6 == 3) {
            this._a(0.0, f4, (double)(0.5f - f2), (double)f3, (double)f5, (double)(0.5f + f2));
        }
        this._q(twgu2, n, n2, n3);
        if (!bl4) {
            this._a();
        }
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
        float f6 = 1.0f;
        if (twgu.field_71984_q[twgu2.field_71990_ca] > 0) {
            f6 = 1.0f;
        }
        htvf2.func_78386_a(f6, f6, f6);
        dwan dwan2 = this._a(twgu2, 0);
        if (this._b()) {
            dwan2 = this._b;
        }
        double d = dwan2.func_94209_e();
        double d2 = dwan2.func_94206_g();
        double d3 = dwan2.func_94212_f();
        double d4 = dwan2.func_94210_h();
        ofbx[] ofbxArray = new ofbx[8];
        float f7 = 0.046875f;
        float f8 = 0.046875f;
        float f9 = 0.3125f;
        ofbxArray[0] = this._a.func_82732_R()._a(-f7, 0.0, -f8);
        ofbxArray[1] = this._a.func_82732_R()._a(f7, 0.0, -f8);
        ofbxArray[2] = this._a.func_82732_R()._a(f7, 0.0, f8);
        ofbxArray[3] = this._a.func_82732_R()._a(-f7, 0.0, f8);
        ofbxArray[4] = this._a.func_82732_R()._a(-f7, f9, -f8);
        ofbxArray[5] = this._a.func_82732_R()._a(f7, f9, -f8);
        ofbxArray[6] = this._a.func_82732_R()._a(f7, f9, f8);
        ofbxArray[7] = this._a.func_82732_R()._a(-f7, f9, f8);
        for (int i = 0; i < 8; ++i) {
            ofbxArray[i]._e += 0.0625;
            if (bl2) {
                ofbxArray[i]._a(0.5235988f);
                ofbxArray[i]._d -= 0.4375;
            } else if (bl) {
                ofbxArray[i]._a(0.08726647f);
                ofbxArray[i]._d -= 0.4375;
            } else {
                ofbxArray[i]._a(-0.69813174f);
                ofbxArray[i]._d -= 0.375;
            }
            ofbxArray[i]._a(1.5707964f);
            if (n6 == 2) {
                ofbxArray[i]._b(0.0f);
            }
            if (n6 == 0) {
                ofbxArray[i]._b((float)Math.PI);
            }
            if (n6 == 1) {
                ofbxArray[i]._b(1.5707964f);
            }
            if (n6 == 3) {
                ofbxArray[i]._b(-1.5707964f);
            }
            ofbxArray[i]._c += (double)n + 0.5;
            ofbxArray[i]._d += (double)((float)n2 + 0.3125f);
            ofbxArray[i]._e += (double)n3 + 0.5;
        }
        ofbx ofbx2 = null;
        ofbx ofbx3 = null;
        ofbx ofbx4 = null;
        ofbx ofbx5 = null;
        int n7 = 7;
        int n8 = 9;
        int n9 = 9;
        int n10 = 16;
        for (int i = 0; i < 6; ++i) {
            if (i == 0) {
                ofbx2 = ofbxArray[0];
                ofbx3 = ofbxArray[1];
                ofbx4 = ofbxArray[2];
                ofbx5 = ofbxArray[3];
                d = dwan2.func_94214_a(n7);
                d2 = dwan2.func_94207_b(n9);
                d3 = dwan2.func_94214_a(n8);
                d4 = dwan2.func_94207_b(n9 + 2);
            } else if (i == 1) {
                ofbx2 = ofbxArray[7];
                ofbx3 = ofbxArray[6];
                ofbx4 = ofbxArray[5];
                ofbx5 = ofbxArray[4];
            } else if (i == 2) {
                ofbx2 = ofbxArray[1];
                ofbx3 = ofbxArray[0];
                ofbx4 = ofbxArray[4];
                ofbx5 = ofbxArray[5];
                d = dwan2.func_94214_a(n7);
                d2 = dwan2.func_94207_b(n9);
                d3 = dwan2.func_94214_a(n8);
                d4 = dwan2.func_94207_b(n10);
            } else if (i == 3) {
                ofbx2 = ofbxArray[2];
                ofbx3 = ofbxArray[1];
                ofbx4 = ofbxArray[5];
                ofbx5 = ofbxArray[6];
            } else if (i == 4) {
                ofbx2 = ofbxArray[3];
                ofbx3 = ofbxArray[2];
                ofbx4 = ofbxArray[6];
                ofbx5 = ofbxArray[7];
            } else if (i == 5) {
                ofbx2 = ofbxArray[0];
                ofbx3 = ofbxArray[3];
                ofbx4 = ofbxArray[7];
                ofbx5 = ofbxArray[4];
            }
            htvf2.func_78374_a(ofbx2._c, ofbx2._d, ofbx2._e, d, d4);
            htvf2.func_78374_a(ofbx3._c, ofbx3._d, ofbx3._e, d3, d4);
            htvf2.func_78374_a(ofbx4._c, ofbx4._d, ofbx4._e, d3, d2);
            htvf2.func_78374_a(ofbx5._c, ofbx5._d, ofbx5._e, d, d2);
        }
        float f10 = 0.09375f;
        float f11 = 0.09375f;
        float f12 = 0.03125f;
        ofbxArray[0] = this._a.func_82732_R()._a(-f10, 0.0, -f11);
        ofbxArray[1] = this._a.func_82732_R()._a(f10, 0.0, -f11);
        ofbxArray[2] = this._a.func_82732_R()._a(f10, 0.0, f11);
        ofbxArray[3] = this._a.func_82732_R()._a(-f10, 0.0, f11);
        ofbxArray[4] = this._a.func_82732_R()._a(-f10, f12, -f11);
        ofbxArray[5] = this._a.func_82732_R()._a(f10, f12, -f11);
        ofbxArray[6] = this._a.func_82732_R()._a(f10, f12, f11);
        ofbxArray[7] = this._a.func_82732_R()._a(-f10, f12, f11);
        for (n4 = 0; n4 < 8; ++n4) {
            ofbxArray[n4]._e += 0.21875;
            if (bl2) {
                ofbxArray[n4]._d -= 0.09375;
                ofbxArray[n4]._e -= 0.1625;
                ofbxArray[n4]._a(0.0f);
            } else if (bl) {
                ofbxArray[n4]._d += 0.015625;
                ofbxArray[n4]._e -= 0.171875;
                ofbxArray[n4]._a(0.17453294f);
            } else {
                ofbxArray[n4]._a(0.87266463f);
            }
            if (n6 == 2) {
                ofbxArray[n4]._b(0.0f);
            }
            if (n6 == 0) {
                ofbxArray[n4]._b((float)Math.PI);
            }
            if (n6 == 1) {
                ofbxArray[n4]._b(1.5707964f);
            }
            if (n6 == 3) {
                ofbxArray[n4]._b(-1.5707964f);
            }
            ofbxArray[n4]._c += (double)n + 0.5;
            ofbxArray[n4]._d += (double)((float)n2 + 0.3125f);
            ofbxArray[n4]._e += (double)n3 + 0.5;
        }
        n4 = 5;
        int n11 = 11;
        int n12 = 3;
        int n13 = 9;
        for (int i = 0; i < 6; ++i) {
            if (i == 0) {
                ofbx2 = ofbxArray[0];
                ofbx3 = ofbxArray[1];
                ofbx4 = ofbxArray[2];
                ofbx5 = ofbxArray[3];
                d = dwan2.func_94214_a(n4);
                d2 = dwan2.func_94207_b(n12);
                d3 = dwan2.func_94214_a(n11);
                d4 = dwan2.func_94207_b(n13);
            } else if (i == 1) {
                ofbx2 = ofbxArray[7];
                ofbx3 = ofbxArray[6];
                ofbx4 = ofbxArray[5];
                ofbx5 = ofbxArray[4];
            } else if (i == 2) {
                ofbx2 = ofbxArray[1];
                ofbx3 = ofbxArray[0];
                ofbx4 = ofbxArray[4];
                ofbx5 = ofbxArray[5];
                d = dwan2.func_94214_a(n4);
                d2 = dwan2.func_94207_b(n12);
                d3 = dwan2.func_94214_a(n11);
                d4 = dwan2.func_94207_b(n12 + 2);
            } else if (i == 3) {
                ofbx2 = ofbxArray[2];
                ofbx3 = ofbxArray[1];
                ofbx4 = ofbxArray[5];
                ofbx5 = ofbxArray[6];
            } else if (i == 4) {
                ofbx2 = ofbxArray[3];
                ofbx3 = ofbxArray[2];
                ofbx4 = ofbxArray[6];
                ofbx5 = ofbxArray[7];
            } else if (i == 5) {
                ofbx2 = ofbxArray[0];
                ofbx3 = ofbxArray[3];
                ofbx4 = ofbxArray[7];
                ofbx5 = ofbxArray[4];
            }
            htvf2.func_78374_a(ofbx2._c, ofbx2._d, ofbx2._e, d, d4);
            htvf2.func_78374_a(ofbx3._c, ofbx3._d, ofbx3._e, d3, d4);
            htvf2.func_78374_a(ofbx4._c, ofbx4._d, ofbx4._e, d3, d2);
            htvf2.func_78374_a(ofbx5._c, ofbx5._d, ofbx5._e, d, d2);
        }
        if (bl) {
            double d5 = ofbxArray[0]._d;
            float f13 = 0.03125f;
            float f14 = 0.5f - f13 / 2.0f;
            float f15 = f14 + f13;
            dwan dwan3 = this._b(twgu.field_72062_bU);
            double d6 = dwan2.func_94209_e();
            double d7 = dwan2.func_94207_b(bl ? 2.0 : 0.0);
            double d8 = dwan2.func_94212_f();
            double d9 = dwan2.func_94207_b(bl ? 4.0 : 2.0);
            double d10 = (double)(bl3 ? 3.5f : 1.5f) / 16.0;
            f6 = twgu2.func_71870_f(this._a, n, n2, n3) * 0.75f;
            htvf2.func_78386_a(f6, f6, f6);
            if (n6 == 2) {
                htvf2.func_78374_a((float)n + f14, (double)n2 + d10, (double)n3 + 0.25, d6, d7);
                htvf2.func_78374_a((float)n + f15, (double)n2 + d10, (double)n3 + 0.25, d6, d9);
                htvf2.func_78374_a((float)n + f15, (double)n2 + d10, n3, d8, d9);
                htvf2.func_78374_a((float)n + f14, (double)n2 + d10, n3, d8, d7);
                htvf2.func_78374_a((float)n + f14, d5, (double)n3 + 0.5, d6, d7);
                htvf2.func_78374_a((float)n + f15, d5, (double)n3 + 0.5, d6, d9);
                htvf2.func_78374_a((float)n + f15, (double)n2 + d10, (double)n3 + 0.25, d8, d9);
                htvf2.func_78374_a((float)n + f14, (double)n2 + d10, (double)n3 + 0.25, d8, d7);
            } else if (n6 == 0) {
                htvf2.func_78374_a((float)n + f14, (double)n2 + d10, (double)n3 + 0.75, d6, d7);
                htvf2.func_78374_a((float)n + f15, (double)n2 + d10, (double)n3 + 0.75, d6, d9);
                htvf2.func_78374_a((float)n + f15, d5, (double)n3 + 0.5, d8, d9);
                htvf2.func_78374_a((float)n + f14, d5, (double)n3 + 0.5, d8, d7);
                htvf2.func_78374_a((float)n + f14, (double)n2 + d10, n3 + 1, d6, d7);
                htvf2.func_78374_a((float)n + f15, (double)n2 + d10, n3 + 1, d6, d9);
                htvf2.func_78374_a((float)n + f15, (double)n2 + d10, (double)n3 + 0.75, d8, d9);
                htvf2.func_78374_a((float)n + f14, (double)n2 + d10, (double)n3 + 0.75, d8, d7);
            } else if (n6 == 1) {
                htvf2.func_78374_a(n, (double)n2 + d10, (float)n3 + f15, d6, d9);
                htvf2.func_78374_a((double)n + 0.25, (double)n2 + d10, (float)n3 + f15, d8, d9);
                htvf2.func_78374_a((double)n + 0.25, (double)n2 + d10, (float)n3 + f14, d8, d7);
                htvf2.func_78374_a(n, (double)n2 + d10, (float)n3 + f14, d6, d7);
                htvf2.func_78374_a((double)n + 0.25, (double)n2 + d10, (float)n3 + f15, d6, d9);
                htvf2.func_78374_a((double)n + 0.5, d5, (float)n3 + f15, d8, d9);
                htvf2.func_78374_a((double)n + 0.5, d5, (float)n3 + f14, d8, d7);
                htvf2.func_78374_a((double)n + 0.25, (double)n2 + d10, (float)n3 + f14, d6, d7);
            } else {
                htvf2.func_78374_a((double)n + 0.5, d5, (float)n3 + f15, d6, d9);
                htvf2.func_78374_a((double)n + 0.75, (double)n2 + d10, (float)n3 + f15, d8, d9);
                htvf2.func_78374_a((double)n + 0.75, (double)n2 + d10, (float)n3 + f14, d8, d7);
                htvf2.func_78374_a((double)n + 0.5, d5, (float)n3 + f14, d6, d7);
                htvf2.func_78374_a((double)n + 0.75, (double)n2 + d10, (float)n3 + f15, d6, d9);
                htvf2.func_78374_a(n + 1, (double)n2 + d10, (float)n3 + f15, d8, d9);
                htvf2.func_78374_a(n + 1, (double)n2 + d10, (float)n3 + f14, d8, d7);
                htvf2.func_78374_a((double)n + 0.75, (double)n2 + d10, (float)n3 + f14, d6, d7);
            }
        }
        return true;
    }

    public boolean _h(twgu twgu2, int n, int n2, int n3) {
        boolean bl;
        htvf htvf2 = this.__aF;
        dwan dwan2 = this._a(twgu2, 0);
        int n4 = this._a.func_72805_g(n, n2, n3);
        boolean bl2 = (n4 & 4) == 4;
        boolean bl3 = bl = (n4 & 2) == 2;
        if (this._b()) {
            dwan2 = this._b;
        }
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
        float f = twgu2.func_71870_f(this._a, n, n2, n3) * 0.75f;
        htvf2.func_78386_a(f, f, f);
        double d = dwan2.func_94209_e();
        double d2 = dwan2.func_94207_b(bl2 ? 2.0 : 0.0);
        double d3 = dwan2.func_94212_f();
        double d4 = dwan2.func_94207_b(bl2 ? 4.0 : 2.0);
        double d5 = (double)(bl ? 3.5f : 1.5f) / 16.0;
        boolean bl4 = uikz._a(this._a, n, n2, n3, n4, 1);
        boolean bl5 = uikz._a(this._a, n, n2, n3, n4, 3);
        boolean bl6 = uikz._a(this._a, n, n2, n3, n4, 2);
        boolean bl7 = uikz._a(this._a, n, n2, n3, n4, 0);
        float f2 = 0.03125f;
        float f3 = 0.5f - f2 / 2.0f;
        float f4 = f3 + f2;
        if (!(bl6 || bl5 || bl7 || bl4)) {
            bl6 = true;
            bl7 = true;
        }
        if (bl6) {
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.25, d, d2);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.25, d, d4);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, n3, d3, d4);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, n3, d3, d2);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, n3, d3, d2);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, n3, d3, d4);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.25, d, d4);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.25, d, d2);
        }
        if (bl6 || bl7 && !bl5 && !bl4) {
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.5, d, d2);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.5, d, d4);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.25, d3, d4);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.25, d3, d2);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.25, d3, d2);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.25, d3, d4);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.5, d, d4);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.5, d, d2);
        }
        if (bl7 || bl6 && !bl5 && !bl4) {
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.75, d, d2);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.75, d, d4);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.5, d3, d4);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.5, d3, d2);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.5, d3, d2);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.5, d3, d4);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.75, d, d4);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.75, d, d2);
        }
        if (bl7) {
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, n3 + 1, d, d2);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, n3 + 1, d, d4);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.75, d3, d4);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.75, d3, d2);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, (double)n3 + 0.75, d3, d2);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, (double)n3 + 0.75, d3, d4);
            htvf2.func_78374_a((float)n + f4, (double)n2 + d5, n3 + 1, d, d4);
            htvf2.func_78374_a((float)n + f3, (double)n2 + d5, n3 + 1, d, d2);
        }
        if (bl4) {
            htvf2.func_78374_a(n, (double)n2 + d5, (float)n3 + f4, d, d4);
            htvf2.func_78374_a((double)n + 0.25, (double)n2 + d5, (float)n3 + f4, d3, d4);
            htvf2.func_78374_a((double)n + 0.25, (double)n2 + d5, (float)n3 + f3, d3, d2);
            htvf2.func_78374_a(n, (double)n2 + d5, (float)n3 + f3, d, d2);
            htvf2.func_78374_a(n, (double)n2 + d5, (float)n3 + f3, d, d2);
            htvf2.func_78374_a((double)n + 0.25, (double)n2 + d5, (float)n3 + f3, d3, d2);
            htvf2.func_78374_a((double)n + 0.25, (double)n2 + d5, (float)n3 + f4, d3, d4);
            htvf2.func_78374_a(n, (double)n2 + d5, (float)n3 + f4, d, d4);
        }
        if (bl4 || bl5 && !bl6 && !bl7) {
            htvf2.func_78374_a((double)n + 0.25, (double)n2 + d5, (float)n3 + f4, d, d4);
            htvf2.func_78374_a((double)n + 0.5, (double)n2 + d5, (float)n3 + f4, d3, d4);
            htvf2.func_78374_a((double)n + 0.5, (double)n2 + d5, (float)n3 + f3, d3, d2);
            htvf2.func_78374_a((double)n + 0.25, (double)n2 + d5, (float)n3 + f3, d, d2);
            htvf2.func_78374_a((double)n + 0.25, (double)n2 + d5, (float)n3 + f3, d, d2);
            htvf2.func_78374_a((double)n + 0.5, (double)n2 + d5, (float)n3 + f3, d3, d2);
            htvf2.func_78374_a((double)n + 0.5, (double)n2 + d5, (float)n3 + f4, d3, d4);
            htvf2.func_78374_a((double)n + 0.25, (double)n2 + d5, (float)n3 + f4, d, d4);
        }
        if (bl5 || bl4 && !bl6 && !bl7) {
            htvf2.func_78374_a((double)n + 0.5, (double)n2 + d5, (float)n3 + f4, d, d4);
            htvf2.func_78374_a((double)n + 0.75, (double)n2 + d5, (float)n3 + f4, d3, d4);
            htvf2.func_78374_a((double)n + 0.75, (double)n2 + d5, (float)n3 + f3, d3, d2);
            htvf2.func_78374_a((double)n + 0.5, (double)n2 + d5, (float)n3 + f3, d, d2);
            htvf2.func_78374_a((double)n + 0.5, (double)n2 + d5, (float)n3 + f3, d, d2);
            htvf2.func_78374_a((double)n + 0.75, (double)n2 + d5, (float)n3 + f3, d3, d2);
            htvf2.func_78374_a((double)n + 0.75, (double)n2 + d5, (float)n3 + f4, d3, d4);
            htvf2.func_78374_a((double)n + 0.5, (double)n2 + d5, (float)n3 + f4, d, d4);
        }
        if (bl5) {
            htvf2.func_78374_a((double)n + 0.75, (double)n2 + d5, (float)n3 + f4, d, d4);
            htvf2.func_78374_a(n + 1, (double)n2 + d5, (float)n3 + f4, d3, d4);
            htvf2.func_78374_a(n + 1, (double)n2 + d5, (float)n3 + f3, d3, d2);
            htvf2.func_78374_a((double)n + 0.75, (double)n2 + d5, (float)n3 + f3, d, d2);
            htvf2.func_78374_a((double)n + 0.75, (double)n2 + d5, (float)n3 + f3, d, d2);
            htvf2.func_78374_a(n + 1, (double)n2 + d5, (float)n3 + f3, d3, d2);
            htvf2.func_78374_a(n + 1, (double)n2 + d5, (float)n3 + f4, d3, d4);
            htvf2.func_78374_a((double)n + 0.75, (double)n2 + d5, (float)n3 + f4, d, d4);
        }
        return true;
    }

    public boolean _a(nuxa nuxa2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        dwan dwan2 = nuxa2._a(0);
        dwan dwan3 = nuxa2._a(1);
        dwan dwan4 = dwan2;
        if (this._b()) {
            dwan4 = this._b;
        }
        htvf2.func_78386_a(1.0f, 1.0f, 1.0f);
        htvf2.func_78380_c(nuxa2.func_71874_e(this._a, n, n2, n3));
        double d = dwan4.func_94209_e();
        double d2 = dwan4.func_94206_g();
        double d3 = dwan4.func_94212_f();
        double d4 = dwan4.func_94210_h();
        float f = 1.4f;
        if (!this._a.func_72797_t(n, n2 - 1, n3) && !twgu.field_72067_ar._a(this._a, n, n2 - 1, n3)) {
            double d5;
            float f2 = 0.2f;
            float f3 = 0.0625f;
            if ((n + n2 + n3 & 1) == 1) {
                d = dwan3.func_94209_e();
                d2 = dwan3.func_94206_g();
                d3 = dwan3.func_94212_f();
                d4 = dwan3.func_94210_h();
            }
            if ((n / 2 + n2 / 2 + n3 / 2 & 1) == 1) {
                d5 = d3;
                d3 = d;
                d = d5;
            }
            if (twgu.field_72067_ar._a(this._a, n - 1, n2, n3)) {
                htvf2.func_78374_a((float)n + f2, (float)n2 + f + f3, n3 + 1, d3, d2);
                htvf2.func_78374_a(n + 0, (float)(n2 + 0) + f3, n3 + 1, d3, d4);
                htvf2.func_78374_a(n + 0, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                htvf2.func_78374_a((float)n + f2, (float)n2 + f + f3, n3 + 0, d, d2);
                htvf2.func_78374_a((float)n + f2, (float)n2 + f + f3, n3 + 0, d, d2);
                htvf2.func_78374_a(n + 0, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                htvf2.func_78374_a(n + 0, (float)(n2 + 0) + f3, n3 + 1, d3, d4);
                htvf2.func_78374_a((float)n + f2, (float)n2 + f + f3, n3 + 1, d3, d2);
            }
            if (twgu.field_72067_ar._a(this._a, n + 1, n2, n3)) {
                htvf2.func_78374_a((float)(n + 1) - f2, (float)n2 + f + f3, n3 + 0, d, d2);
                htvf2.func_78374_a(n + 1 - 0, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                htvf2.func_78374_a(n + 1 - 0, (float)(n2 + 0) + f3, n3 + 1, d3, d4);
                htvf2.func_78374_a((float)(n + 1) - f2, (float)n2 + f + f3, n3 + 1, d3, d2);
                htvf2.func_78374_a((float)(n + 1) - f2, (float)n2 + f + f3, n3 + 1, d3, d2);
                htvf2.func_78374_a(n + 1 - 0, (float)(n2 + 0) + f3, n3 + 1, d3, d4);
                htvf2.func_78374_a(n + 1 - 0, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                htvf2.func_78374_a((float)(n + 1) - f2, (float)n2 + f + f3, n3 + 0, d, d2);
            }
            if (twgu.field_72067_ar._a(this._a, n, n2, n3 - 1)) {
                htvf2.func_78374_a(n + 0, (float)n2 + f + f3, (float)n3 + f2, d3, d2);
                htvf2.func_78374_a(n + 0, (float)(n2 + 0) + f3, n3 + 0, d3, d4);
                htvf2.func_78374_a(n + 1, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                htvf2.func_78374_a(n + 1, (float)n2 + f + f3, (float)n3 + f2, d, d2);
                htvf2.func_78374_a(n + 1, (float)n2 + f + f3, (float)n3 + f2, d, d2);
                htvf2.func_78374_a(n + 1, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                htvf2.func_78374_a(n + 0, (float)(n2 + 0) + f3, n3 + 0, d3, d4);
                htvf2.func_78374_a(n + 0, (float)n2 + f + f3, (float)n3 + f2, d3, d2);
            }
            if (twgu.field_72067_ar._a(this._a, n, n2, n3 + 1)) {
                htvf2.func_78374_a(n + 1, (float)n2 + f + f3, (float)(n3 + 1) - f2, d, d2);
                htvf2.func_78374_a(n + 1, (float)(n2 + 0) + f3, n3 + 1 - 0, d, d4);
                htvf2.func_78374_a(n + 0, (float)(n2 + 0) + f3, n3 + 1 - 0, d3, d4);
                htvf2.func_78374_a(n + 0, (float)n2 + f + f3, (float)(n3 + 1) - f2, d3, d2);
                htvf2.func_78374_a(n + 0, (float)n2 + f + f3, (float)(n3 + 1) - f2, d3, d2);
                htvf2.func_78374_a(n + 0, (float)(n2 + 0) + f3, n3 + 1 - 0, d3, d4);
                htvf2.func_78374_a(n + 1, (float)(n2 + 0) + f3, n3 + 1 - 0, d, d4);
                htvf2.func_78374_a(n + 1, (float)n2 + f + f3, (float)(n3 + 1) - f2, d, d2);
            }
            if (twgu.field_72067_ar._a(this._a, n, n2 + 1, n3)) {
                d5 = (double)n + 0.5 + 0.5;
                double d6 = (double)n + 0.5 - 0.5;
                double d7 = (double)n3 + 0.5 + 0.5;
                double d8 = (double)n3 + 0.5 - 0.5;
                double d9 = (double)n + 0.5 - 0.5;
                double d10 = (double)n + 0.5 + 0.5;
                double d11 = (double)n3 + 0.5 - 0.5;
                double d12 = (double)n3 + 0.5 + 0.5;
                d = dwan2.func_94209_e();
                d2 = dwan2.func_94206_g();
                d3 = dwan2.func_94212_f();
                d4 = dwan2.func_94210_h();
                f = -0.2f;
                if ((n + ++n2 + n3 & 1) == 0) {
                    htvf2.func_78374_a(d9, (float)n2 + f, n3 + 0, d3, d2);
                    htvf2.func_78374_a(d5, n2 + 0, n3 + 0, d3, d4);
                    htvf2.func_78374_a(d5, n2 + 0, n3 + 1, d, d4);
                    htvf2.func_78374_a(d9, (float)n2 + f, n3 + 1, d, d2);
                    d = dwan3.func_94209_e();
                    d2 = dwan3.func_94206_g();
                    d3 = dwan3.func_94212_f();
                    d4 = dwan3.func_94210_h();
                    htvf2.func_78374_a(d10, (float)n2 + f, n3 + 1, d3, d2);
                    htvf2.func_78374_a(d6, n2 + 0, n3 + 1, d3, d4);
                    htvf2.func_78374_a(d6, n2 + 0, n3 + 0, d, d4);
                    htvf2.func_78374_a(d10, (float)n2 + f, n3 + 0, d, d2);
                } else {
                    htvf2.func_78374_a(n + 0, (float)n2 + f, d12, d3, d2);
                    htvf2.func_78374_a(n + 0, n2 + 0, d8, d3, d4);
                    htvf2.func_78374_a(n + 1, n2 + 0, d8, d, d4);
                    htvf2.func_78374_a(n + 1, (float)n2 + f, d12, d, d2);
                    d = dwan3.func_94209_e();
                    d2 = dwan3.func_94206_g();
                    d3 = dwan3.func_94212_f();
                    d4 = dwan3.func_94210_h();
                    htvf2.func_78374_a(n + 1, (float)n2 + f, d11, d3, d2);
                    htvf2.func_78374_a(n + 1, n2 + 0, d7, d3, d4);
                    htvf2.func_78374_a(n + 0, n2 + 0, d7, d, d4);
                    htvf2.func_78374_a(n + 0, (float)n2 + f, d11, d, d2);
                }
            }
        } else {
            double d13 = (double)n + 0.5 + 0.2;
            double d14 = (double)n + 0.5 - 0.2;
            double d15 = (double)n3 + 0.5 + 0.2;
            double d16 = (double)n3 + 0.5 - 0.2;
            double d17 = (double)n + 0.5 - 0.3;
            double d18 = (double)n + 0.5 + 0.3;
            double d19 = (double)n3 + 0.5 - 0.3;
            double d20 = (double)n3 + 0.5 + 0.3;
            htvf2.func_78374_a(d17, (float)n2 + f, n3 + 1, d3, d2);
            htvf2.func_78374_a(d13, n2 + 0, n3 + 1, d3, d4);
            htvf2.func_78374_a(d13, n2 + 0, n3 + 0, d, d4);
            htvf2.func_78374_a(d17, (float)n2 + f, n3 + 0, d, d2);
            htvf2.func_78374_a(d18, (float)n2 + f, n3 + 0, d3, d2);
            htvf2.func_78374_a(d14, n2 + 0, n3 + 0, d3, d4);
            htvf2.func_78374_a(d14, n2 + 0, n3 + 1, d, d4);
            htvf2.func_78374_a(d18, (float)n2 + f, n3 + 1, d, d2);
            d = dwan3.func_94209_e();
            d2 = dwan3.func_94206_g();
            d3 = dwan3.func_94212_f();
            d4 = dwan3.func_94210_h();
            htvf2.func_78374_a(n + 1, (float)n2 + f, d20, d3, d2);
            htvf2.func_78374_a(n + 1, n2 + 0, d16, d3, d4);
            htvf2.func_78374_a(n + 0, n2 + 0, d16, d, d4);
            htvf2.func_78374_a(n + 0, (float)n2 + f, d20, d, d2);
            htvf2.func_78374_a(n + 0, (float)n2 + f, d19, d3, d2);
            htvf2.func_78374_a(n + 0, n2 + 0, d15, d3, d4);
            htvf2.func_78374_a(n + 1, n2 + 0, d15, d, d4);
            htvf2.func_78374_a(n + 1, (float)n2 + f, d19, d, d2);
            d13 = (double)n + 0.5 - 0.5;
            d14 = (double)n + 0.5 + 0.5;
            d15 = (double)n3 + 0.5 - 0.5;
            d16 = (double)n3 + 0.5 + 0.5;
            d17 = (double)n + 0.5 - 0.4;
            d18 = (double)n + 0.5 + 0.4;
            d19 = (double)n3 + 0.5 - 0.4;
            d20 = (double)n3 + 0.5 + 0.4;
            htvf2.func_78374_a(d17, (float)n2 + f, n3 + 0, d, d2);
            htvf2.func_78374_a(d13, n2 + 0, n3 + 0, d, d4);
            htvf2.func_78374_a(d13, n2 + 0, n3 + 1, d3, d4);
            htvf2.func_78374_a(d17, (float)n2 + f, n3 + 1, d3, d2);
            htvf2.func_78374_a(d18, (float)n2 + f, n3 + 1, d, d2);
            htvf2.func_78374_a(d14, n2 + 0, n3 + 1, d, d4);
            htvf2.func_78374_a(d14, n2 + 0, n3 + 0, d3, d4);
            htvf2.func_78374_a(d18, (float)n2 + f, n3 + 0, d3, d2);
            d = dwan2.func_94209_e();
            d2 = dwan2.func_94206_g();
            d3 = dwan2.func_94212_f();
            d4 = dwan2.func_94210_h();
            htvf2.func_78374_a(n + 0, (float)n2 + f, d20, d, d2);
            htvf2.func_78374_a(n + 0, n2 + 0, d16, d, d4);
            htvf2.func_78374_a(n + 1, n2 + 0, d16, d3, d4);
            htvf2.func_78374_a(n + 1, (float)n2 + f, d20, d3, d2);
            htvf2.func_78374_a(n + 1, (float)n2 + f, d19, d, d2);
            htvf2.func_78374_a(n + 1, n2 + 0, d15, d, d4);
            htvf2.func_78374_a(n + 0, n2 + 0, d15, d3, d4);
            htvf2.func_78374_a(n + 0, (float)n2 + f, d19, d3, d2);
        }
        return true;
    }

    public boolean _i(twgu twgu2, int n, int n2, int n3) {
        boolean bl;
        int n4;
        htvf htvf2 = this.__aF;
        int n5 = this._a.func_72805_g(n, n2, n3);
        dwan dwan2 = losq._a("cross");
        dwan dwan3 = losq._a("line");
        dwan dwan4 = losq._a("cross_overlay");
        dwan dwan5 = losq._a("line_overlay");
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
        float f = 1.0f;
        float f2 = (float)n5 / 15.0f;
        float f3 = f2 * 0.6f + 0.4f;
        if (n5 == 0) {
            f3 = 0.3f;
        }
        float f4 = f2 * f2 * 0.7f - 0.5f;
        float f5 = f2 * f2 * 0.6f - 0.7f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if ((n4 = CustomColorizer.getRedstoneColor(n5)) != -1) {
            int n6 = n4 >> 16 & 0xFF;
            int n7 = n4 >> 8 & 0xFF;
            int n8 = n4 & 0xFF;
            f3 = (float)n6 / 255.0f;
            f4 = (float)n7 / 255.0f;
            f5 = (float)n8 / 255.0f;
        }
        htvf2.func_78386_a(f3, f4, f5);
        double d = 0.015625;
        double d2 = 0.015625;
        boolean bl2 = losq._a(this._a, n - 1, n2, n3, 1) || !this._a.func_72809_s(n - 1, n2, n3) && losq._a(this._a, n - 1, n2 - 1, n3, -1);
        boolean bl3 = losq._a(this._a, n + 1, n2, n3, 3) || !this._a.func_72809_s(n + 1, n2, n3) && losq._a(this._a, n + 1, n2 - 1, n3, -1);
        boolean bl4 = losq._a(this._a, n, n2, n3 - 1, 2) || !this._a.func_72809_s(n, n2, n3 - 1) && losq._a(this._a, n, n2 - 1, n3 - 1, -1);
        boolean bl5 = bl = losq._a(this._a, n, n2, n3 + 1, 0) || !this._a.func_72809_s(n, n2, n3 + 1) && losq._a(this._a, n, n2 - 1, n3 + 1, -1);
        if (!this._a.func_72809_s(n, n2 + 1, n3)) {
            if (this._a.func_72809_s(n - 1, n2, n3) && losq._a(this._a, n - 1, n2 + 1, n3, -1)) {
                bl2 = true;
            }
            if (this._a.func_72809_s(n + 1, n2, n3) && losq._a(this._a, n + 1, n2 + 1, n3, -1)) {
                bl3 = true;
            }
            if (this._a.func_72809_s(n, n2, n3 - 1) && losq._a(this._a, n, n2 + 1, n3 - 1, -1)) {
                bl4 = true;
            }
            if (this._a.func_72809_s(n, n2, n3 + 1) && losq._a(this._a, n, n2 + 1, n3 + 1, -1)) {
                bl = true;
            }
        }
        float f6 = n + 0;
        float f7 = n + 1;
        float f8 = n3 + 0;
        float f9 = n3 + 1;
        boolean bl6 = false;
        if ((bl2 || bl3) && !bl4 && !bl) {
            bl6 = true;
        }
        if ((bl4 || bl) && !bl3 && !bl2) {
            bl6 = true;
        }
        if (!bl6) {
            int n9 = 0;
            int n10 = 0;
            int n11 = 16;
            int n12 = 16;
            boolean bl7 = true;
            if (!bl2) {
                f6 += 0.3125f;
            }
            if (!bl2) {
                n9 += 5;
            }
            if (!bl3) {
                f7 -= 0.3125f;
            }
            if (!bl3) {
                n11 -= 5;
            }
            if (!bl4) {
                f8 += 0.3125f;
            }
            if (!bl4) {
                n10 += 5;
            }
            if (!bl) {
                f9 -= 0.3125f;
            }
            if (!bl) {
                n12 -= 5;
            }
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f9, dwan2.func_94214_a(n11), dwan2.func_94207_b(n12));
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f8, dwan2.func_94214_a(n11), dwan2.func_94207_b(n10));
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f8, dwan2.func_94214_a(n9), dwan2.func_94207_b(n10));
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f9, dwan2.func_94214_a(n9), dwan2.func_94207_b(n12));
            htvf2.func_78386_a(f, f, f);
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f9, dwan4.func_94214_a(n11), dwan4.func_94207_b(n12));
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f8, dwan4.func_94214_a(n11), dwan4.func_94207_b(n10));
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f8, dwan4.func_94214_a(n9), dwan4.func_94207_b(n10));
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f9, dwan4.func_94214_a(n9), dwan4.func_94207_b(n12));
        } else if (bl6) {
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f9, dwan3.func_94212_f(), dwan3.func_94210_h());
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f8, dwan3.func_94212_f(), dwan3.func_94206_g());
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f8, dwan3.func_94209_e(), dwan3.func_94206_g());
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f9, dwan3.func_94209_e(), dwan3.func_94210_h());
            htvf2.func_78386_a(f, f, f);
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f9, dwan5.func_94212_f(), dwan5.func_94210_h());
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f8, dwan5.func_94212_f(), dwan5.func_94206_g());
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f8, dwan5.func_94209_e(), dwan5.func_94206_g());
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f9, dwan5.func_94209_e(), dwan5.func_94210_h());
        } else {
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f9, dwan3.func_94212_f(), dwan3.func_94210_h());
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f8, dwan3.func_94209_e(), dwan3.func_94210_h());
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f8, dwan3.func_94209_e(), dwan3.func_94206_g());
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f9, dwan3.func_94212_f(), dwan3.func_94206_g());
            htvf2.func_78386_a(f, f, f);
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f9, dwan5.func_94212_f(), dwan5.func_94210_h());
            htvf2.func_78374_a(f7, (double)n2 + 0.015625, f8, dwan5.func_94209_e(), dwan5.func_94210_h());
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f8, dwan5.func_94209_e(), dwan5.func_94206_g());
            htvf2.func_78374_a(f6, (double)n2 + 0.015625, f9, dwan5.func_94212_f(), dwan5.func_94206_g());
        }
        if (!this._a.func_72809_s(n, n2 + 1, n3)) {
            float f10 = 0.021875f;
            if (this._a.func_72809_s(n - 1, n2, n3) && this._a.func_72798_a(n - 1, n2 + 1, n3) == twgu.field_72075_av.field_71990_ca) {
                htvf2.func_78386_a(f * f3, f * f4, f * f5);
                htvf2.func_78374_a((double)n + 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 1, dwan3.func_94212_f(), dwan3.func_94206_g());
                htvf2.func_78374_a((double)n + 0.015625, n2 + 0, n3 + 1, dwan3.func_94209_e(), dwan3.func_94206_g());
                htvf2.func_78374_a((double)n + 0.015625, n2 + 0, n3 + 0, dwan3.func_94209_e(), dwan3.func_94210_h());
                htvf2.func_78374_a((double)n + 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 0, dwan3.func_94212_f(), dwan3.func_94210_h());
                htvf2.func_78386_a(f, f, f);
                htvf2.func_78374_a((double)n + 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 1, dwan5.func_94212_f(), dwan5.func_94206_g());
                htvf2.func_78374_a((double)n + 0.015625, n2 + 0, n3 + 1, dwan5.func_94209_e(), dwan5.func_94206_g());
                htvf2.func_78374_a((double)n + 0.015625, n2 + 0, n3 + 0, dwan5.func_94209_e(), dwan5.func_94210_h());
                htvf2.func_78374_a((double)n + 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 0, dwan5.func_94212_f(), dwan5.func_94210_h());
            }
            if (this._a.func_72809_s(n + 1, n2, n3) && this._a.func_72798_a(n + 1, n2 + 1, n3) == twgu.field_72075_av.field_71990_ca) {
                htvf2.func_78386_a(f * f3, f * f4, f * f5);
                htvf2.func_78374_a((double)(n + 1) - 0.015625, n2 + 0, n3 + 1, dwan3.func_94209_e(), dwan3.func_94210_h());
                htvf2.func_78374_a((double)(n + 1) - 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 1, dwan3.func_94212_f(), dwan3.func_94210_h());
                htvf2.func_78374_a((double)(n + 1) - 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 0, dwan3.func_94212_f(), dwan3.func_94206_g());
                htvf2.func_78374_a((double)(n + 1) - 0.015625, n2 + 0, n3 + 0, dwan3.func_94209_e(), dwan3.func_94206_g());
                htvf2.func_78386_a(f, f, f);
                htvf2.func_78374_a((double)(n + 1) - 0.015625, n2 + 0, n3 + 1, dwan5.func_94209_e(), dwan5.func_94210_h());
                htvf2.func_78374_a((double)(n + 1) - 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 1, dwan5.func_94212_f(), dwan5.func_94210_h());
                htvf2.func_78374_a((double)(n + 1) - 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 0, dwan5.func_94212_f(), dwan5.func_94206_g());
                htvf2.func_78374_a((double)(n + 1) - 0.015625, n2 + 0, n3 + 0, dwan5.func_94209_e(), dwan5.func_94206_g());
            }
            if (this._a.func_72809_s(n, n2, n3 - 1) && this._a.func_72798_a(n, n2 + 1, n3 - 1) == twgu.field_72075_av.field_71990_ca) {
                htvf2.func_78386_a(f * f3, f * f4, f * f5);
                htvf2.func_78374_a(n + 1, n2 + 0, (double)n3 + 0.015625, dwan3.func_94209_e(), dwan3.func_94210_h());
                htvf2.func_78374_a(n + 1, (float)(n2 + 1) + 0.021875f, (double)n3 + 0.015625, dwan3.func_94212_f(), dwan3.func_94210_h());
                htvf2.func_78374_a(n + 0, (float)(n2 + 1) + 0.021875f, (double)n3 + 0.015625, dwan3.func_94212_f(), dwan3.func_94206_g());
                htvf2.func_78374_a(n + 0, n2 + 0, (double)n3 + 0.015625, dwan3.func_94209_e(), dwan3.func_94206_g());
                htvf2.func_78386_a(f, f, f);
                htvf2.func_78374_a(n + 1, n2 + 0, (double)n3 + 0.015625, dwan5.func_94209_e(), dwan5.func_94210_h());
                htvf2.func_78374_a(n + 1, (float)(n2 + 1) + 0.021875f, (double)n3 + 0.015625, dwan5.func_94212_f(), dwan5.func_94210_h());
                htvf2.func_78374_a(n + 0, (float)(n2 + 1) + 0.021875f, (double)n3 + 0.015625, dwan5.func_94212_f(), dwan5.func_94206_g());
                htvf2.func_78374_a(n + 0, n2 + 0, (double)n3 + 0.015625, dwan5.func_94209_e(), dwan5.func_94206_g());
            }
            if (this._a.func_72809_s(n, n2, n3 + 1) && this._a.func_72798_a(n, n2 + 1, n3 + 1) == twgu.field_72075_av.field_71990_ca) {
                htvf2.func_78386_a(f * f3, f * f4, f * f5);
                htvf2.func_78374_a(n + 1, (float)(n2 + 1) + 0.021875f, (double)(n3 + 1) - 0.015625, dwan3.func_94212_f(), dwan3.func_94206_g());
                htvf2.func_78374_a(n + 1, n2 + 0, (double)(n3 + 1) - 0.015625, dwan3.func_94209_e(), dwan3.func_94206_g());
                htvf2.func_78374_a(n + 0, n2 + 0, (double)(n3 + 1) - 0.015625, dwan3.func_94209_e(), dwan3.func_94210_h());
                htvf2.func_78374_a(n + 0, (float)(n2 + 1) + 0.021875f, (double)(n3 + 1) - 0.015625, dwan3.func_94212_f(), dwan3.func_94210_h());
                htvf2.func_78386_a(f, f, f);
                htvf2.func_78374_a(n + 1, (float)(n2 + 1) + 0.021875f, (double)(n3 + 1) - 0.015625, dwan5.func_94212_f(), dwan5.func_94206_g());
                htvf2.func_78374_a(n + 1, n2 + 0, (double)(n3 + 1) - 0.015625, dwan5.func_94209_e(), dwan5.func_94206_g());
                htvf2.func_78374_a(n + 0, n2 + 0, (double)(n3 + 1) - 0.015625, dwan5.func_94209_e(), dwan5.func_94210_h());
                htvf2.func_78374_a(n + 0, (float)(n2 + 1) + 0.021875f, (double)(n3 + 1) - 0.015625, dwan5.func_94212_f(), dwan5.func_94210_h());
            }
        }
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, 0.01);
        }
        return true;
    }

    public boolean _a(scgt scgt2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        int n4 = this._a.func_72805_g(n, n2, n3);
        dwan dwan2 = this._a((twgu)scgt2, 0, n4);
        if (this._b()) {
            dwan2 = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null) {
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, scgt2, n, n2, n3, 1, dwan2);
        }
        if (scgt2._a()) {
            n4 &= 7;
        }
        htvf2.func_78380_c(scgt2.func_71874_e(this._a, n, n2, n3));
        htvf2.func_78386_a(1.0f, 1.0f, 1.0f);
        double d = dwan2.func_94209_e();
        double d2 = dwan2.func_94206_g();
        double d3 = dwan2.func_94212_f();
        double d4 = dwan2.func_94210_h();
        double d5 = 0.0625;
        double d6 = n + 1;
        double d7 = n + 1;
        double d8 = n + 0;
        double d9 = n + 0;
        double d10 = n3 + 0;
        double d11 = n3 + 1;
        double d12 = n3 + 1;
        double d13 = n3 + 0;
        double d14 = (double)n2 + d5;
        double d15 = (double)n2 + d5;
        double d16 = (double)n2 + d5;
        double d17 = (double)n2 + d5;
        if (n4 != 1 && n4 != 2 && n4 != 3 && n4 != 7) {
            if (n4 == 8) {
                d6 = d7 = (double)(n + 0);
                d8 = d9 = (double)(n + 1);
                d10 = d13 = (double)(n3 + 1);
                d11 = d12 = (double)(n3 + 0);
            } else if (n4 == 9) {
                d6 = d9 = (double)(n + 0);
                d7 = d8 = (double)(n + 1);
                d10 = d11 = (double)(n3 + 0);
                d12 = d13 = (double)(n3 + 1);
            }
        } else {
            d6 = d9 = (double)(n + 1);
            d7 = d8 = (double)(n + 0);
            d10 = d11 = (double)(n3 + 1);
            d12 = d13 = (double)(n3 + 0);
        }
        if (n4 != 2 && n4 != 4) {
            if (n4 == 3 || n4 == 5) {
                d15 += 1.0;
                d16 += 1.0;
            }
        } else {
            d14 += 1.0;
            d17 += 1.0;
        }
        htvf2.func_78374_a(d6, d14, d10, d3, d2);
        htvf2.func_78374_a(d7, d15, d11, d3, d4);
        htvf2.func_78374_a(d8, d16, d12, d, d4);
        htvf2.func_78374_a(d9, d17, d13, d, d2);
        htvf2.func_78374_a(d9, d17, d13, d, d2);
        htvf2.func_78374_a(d8, d16, d12, d, d4);
        htvf2.func_78374_a(d7, d15, d11, d3, d4);
        htvf2.func_78374_a(d6, d14, d10, d3, d2);
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, 0.05);
        }
        return true;
    }

    public boolean _j(twgu twgu2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        dwan dwan2 = this._a(twgu2, 0);
        if (this._b()) {
            dwan2 = this._b;
        }
        int n4 = this._a.func_72805_g(n, n2, n3);
        if (Config.isConnectedTextures() && this._b == null) {
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, twgu2, n, n2, n3, n4, dwan2);
        }
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
        float f = 1.0f;
        htvf2.func_78386_a(f, f, f);
        double d = dwan2.func_94209_e();
        double d2 = dwan2.func_94206_g();
        double d3 = dwan2.func_94212_f();
        double d4 = dwan2.func_94210_h();
        double d5 = 0.0;
        double d6 = 0.05f;
        if (n4 == 5) {
            htvf2.func_78374_a((double)n + d6, (double)(n2 + 1) + d5, (double)(n3 + 1) + d5, d, d2);
            htvf2.func_78374_a((double)n + d6, (double)(n2 + 0) - d5, (double)(n3 + 1) + d5, d, d4);
            htvf2.func_78374_a((double)n + d6, (double)(n2 + 0) - d5, (double)(n3 + 0) - d5, d3, d4);
            htvf2.func_78374_a((double)n + d6, (double)(n2 + 1) + d5, (double)(n3 + 0) - d5, d3, d2);
        }
        if (n4 == 4) {
            htvf2.func_78374_a((double)(n + 1) - d6, (double)(n2 + 0) - d5, (double)(n3 + 1) + d5, d3, d4);
            htvf2.func_78374_a((double)(n + 1) - d6, (double)(n2 + 1) + d5, (double)(n3 + 1) + d5, d3, d2);
            htvf2.func_78374_a((double)(n + 1) - d6, (double)(n2 + 1) + d5, (double)(n3 + 0) - d5, d, d2);
            htvf2.func_78374_a((double)(n + 1) - d6, (double)(n2 + 0) - d5, (double)(n3 + 0) - d5, d, d4);
        }
        if (n4 == 3) {
            htvf2.func_78374_a((double)(n + 1) + d5, (double)(n2 + 0) - d5, (double)n3 + d6, d3, d4);
            htvf2.func_78374_a((double)(n + 1) + d5, (double)(n2 + 1) + d5, (double)n3 + d6, d3, d2);
            htvf2.func_78374_a((double)(n + 0) - d5, (double)(n2 + 1) + d5, (double)n3 + d6, d, d2);
            htvf2.func_78374_a((double)(n + 0) - d5, (double)(n2 + 0) - d5, (double)n3 + d6, d, d4);
        }
        if (n4 == 2) {
            htvf2.func_78374_a((double)(n + 1) + d5, (double)(n2 + 1) + d5, (double)(n3 + 1) - d6, d, d2);
            htvf2.func_78374_a((double)(n + 1) + d5, (double)(n2 + 0) - d5, (double)(n3 + 1) - d6, d, d4);
            htvf2.func_78374_a((double)(n + 0) - d5, (double)(n2 + 0) - d5, (double)(n3 + 1) - d6, d3, d4);
            htvf2.func_78374_a((double)(n + 0) - d5, (double)(n2 + 1) + d5, (double)(n3 + 1) - d6, d3, d2);
        }
        return true;
    }

    public boolean _k(twgu twgu2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        dwan dwan2 = this._a(twgu2, 0);
        if (this._b()) {
            dwan2 = this._b;
        }
        int n4 = this._a.func_72805_g(n, n2, n3);
        if (Config.isConnectedTextures() && this._b == null) {
            int n5 = 0;
            if ((n4 & 1) != 0) {
                n5 = 2;
            } else if ((n4 & 2) != 0) {
                n5 = 5;
            } else if ((n4 & 4) != 0) {
                n5 = 3;
            } else if ((n4 & 8) != 0) {
                n5 = 4;
            }
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, twgu2, n, n2, n3, n5, dwan2);
        }
        float f = 1.0f;
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
        int n6 = CustomColorizer.getColorMultiplier(twgu2, this._a, n, n2, n3);
        float f2 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n6 & 0xFF) / 255.0f;
        htvf2.func_78386_a(f * f2, f * f3, f * f4);
        double d = dwan2.func_94209_e();
        double d2 = dwan2.func_94206_g();
        double d3 = dwan2.func_94212_f();
        double d4 = dwan2.func_94210_h();
        double d5 = 0.05f;
        if ((n4 & 2) != 0) {
            htvf2.func_78374_a((double)n + d5, n2 + 1, n3 + 1, d, d2);
            htvf2.func_78374_a((double)n + d5, n2 + 0, n3 + 1, d, d4);
            htvf2.func_78374_a((double)n + d5, n2 + 0, n3 + 0, d3, d4);
            htvf2.func_78374_a((double)n + d5, n2 + 1, n3 + 0, d3, d2);
            htvf2.func_78374_a((double)n + d5, n2 + 1, n3 + 0, d3, d2);
            htvf2.func_78374_a((double)n + d5, n2 + 0, n3 + 0, d3, d4);
            htvf2.func_78374_a((double)n + d5, n2 + 0, n3 + 1, d, d4);
            htvf2.func_78374_a((double)n + d5, n2 + 1, n3 + 1, d, d2);
        }
        if ((n4 & 8) != 0) {
            htvf2.func_78374_a((double)(n + 1) - d5, n2 + 0, n3 + 1, d3, d4);
            htvf2.func_78374_a((double)(n + 1) - d5, n2 + 1, n3 + 1, d3, d2);
            htvf2.func_78374_a((double)(n + 1) - d5, n2 + 1, n3 + 0, d, d2);
            htvf2.func_78374_a((double)(n + 1) - d5, n2 + 0, n3 + 0, d, d4);
            htvf2.func_78374_a((double)(n + 1) - d5, n2 + 0, n3 + 0, d, d4);
            htvf2.func_78374_a((double)(n + 1) - d5, n2 + 1, n3 + 0, d, d2);
            htvf2.func_78374_a((double)(n + 1) - d5, n2 + 1, n3 + 1, d3, d2);
            htvf2.func_78374_a((double)(n + 1) - d5, n2 + 0, n3 + 1, d3, d4);
        }
        if ((n4 & 4) != 0) {
            htvf2.func_78374_a(n + 1, n2 + 0, (double)n3 + d5, d3, d4);
            htvf2.func_78374_a(n + 1, n2 + 1, (double)n3 + d5, d3, d2);
            htvf2.func_78374_a(n + 0, n2 + 1, (double)n3 + d5, d, d2);
            htvf2.func_78374_a(n + 0, n2 + 0, (double)n3 + d5, d, d4);
            htvf2.func_78374_a(n + 0, n2 + 0, (double)n3 + d5, d, d4);
            htvf2.func_78374_a(n + 0, n2 + 1, (double)n3 + d5, d, d2);
            htvf2.func_78374_a(n + 1, n2 + 1, (double)n3 + d5, d3, d2);
            htvf2.func_78374_a(n + 1, n2 + 0, (double)n3 + d5, d3, d4);
        }
        if ((n4 & 1) != 0) {
            htvf2.func_78374_a(n + 1, n2 + 1, (double)(n3 + 1) - d5, d, d2);
            htvf2.func_78374_a(n + 1, n2 + 0, (double)(n3 + 1) - d5, d, d4);
            htvf2.func_78374_a(n + 0, n2 + 0, (double)(n3 + 1) - d5, d3, d4);
            htvf2.func_78374_a(n + 0, n2 + 1, (double)(n3 + 1) - d5, d3, d2);
            htvf2.func_78374_a(n + 0, n2 + 1, (double)(n3 + 1) - d5, d3, d2);
            htvf2.func_78374_a(n + 0, n2 + 0, (double)(n3 + 1) - d5, d3, d4);
            htvf2.func_78374_a(n + 1, n2 + 0, (double)(n3 + 1) - d5, d, d4);
            htvf2.func_78374_a(n + 1, n2 + 1, (double)(n3 + 1) - d5, d, d2);
        }
        if (this._a.func_72809_s(n, n2 + 1, n3)) {
            htvf2.func_78374_a(n + 1, (double)(n2 + 1) - d5, n3 + 0, d, d2);
            htvf2.func_78374_a(n + 1, (double)(n2 + 1) - d5, n3 + 1, d, d4);
            htvf2.func_78374_a(n + 0, (double)(n2 + 1) - d5, n3 + 1, d3, d4);
            htvf2.func_78374_a(n + 0, (double)(n2 + 1) - d5, n3 + 0, d3, d2);
        }
        return true;
    }

    public boolean _a(zxyg zxyg2, int n, int n2, int n3) {
        dwan dwan2;
        dwan dwan3;
        int n4 = this._a.func_72800_K();
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(zxyg2.func_71874_e(this._a, n, n2, n3));
        float f = 1.0f;
        int n5 = zxyg2.func_71920_b(this._a, n, n2, n3);
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        htvf2.func_78386_a(f * f2, f * f3, f * f4);
        ConnectedProperties connectedProperties = null;
        if (this._b()) {
            dwan3 = this._b;
            dwan2 = this._b;
        } else {
            int n6 = this._a.func_72805_g(n, n2, n3);
            dwan3 = this._a((twgu)zxyg2, 0, n6);
            dwan2 = zxyg2._a();
            if (Config.isConnectedTextures()) {
                connectedProperties = ConnectedTextures.getConnectedProperties(this._a, zxyg2, n, n2, n3, -1, dwan3);
            }
        }
        dwan dwan4 = dwan3;
        dwan dwan5 = dwan3;
        dwan dwan6 = dwan3;
        if (connectedProperties != null) {
            int n7 = zxyg2.field_71990_ca;
            int n8 = this._a.func_72798_a(n + 1, n2, n3);
            int n9 = this._a.func_72798_a(n - 1, n2, n3);
            int n10 = this._a.func_72798_a(n, n2 + 1, n3);
            int n11 = this._a.func_72798_a(n, n2 - 1, n3);
            int n12 = this._a.func_72798_a(n, n2, n3 + 1);
            int n13 = this._a.func_72798_a(n, n2, n3 - 1);
            boolean bl = n8 == n7;
            boolean bl2 = n9 == n7;
            boolean bl3 = n10 == n7;
            boolean bl4 = n11 == n7;
            boolean bl5 = n12 == n7;
            boolean bl6 = n13 == n7;
            int n14 = ConnectedTextures.getPaneTextureIndex(bl, bl2, bl3, bl4);
            int n15 = ConnectedTextures.getReversePaneTextureIndex(n14);
            int n16 = ConnectedTextures.getPaneTextureIndex(bl5, bl6, bl3, bl4);
            int n17 = ConnectedTextures.getReversePaneTextureIndex(n16);
            dwan3 = ConnectedTextures.getCtmTexture(connectedProperties, n14, dwan3);
            dwan4 = ConnectedTextures.getCtmTexture(connectedProperties, n15, dwan4);
            dwan5 = ConnectedTextures.getCtmTexture(connectedProperties, n16, dwan5);
            dwan6 = ConnectedTextures.getCtmTexture(connectedProperties, n17, dwan6);
        }
        double d = dwan3.func_94209_e();
        double d2 = dwan3.func_94214_a(8.0);
        double d3 = dwan3.func_94212_f();
        double d4 = dwan3.func_94206_g();
        double d5 = dwan3.func_94210_h();
        double d6 = dwan4.func_94209_e();
        double d7 = dwan4.func_94214_a(8.0);
        double d8 = dwan4.func_94212_f();
        double d9 = dwan4.func_94206_g();
        double d10 = dwan4.func_94210_h();
        double d11 = dwan5.func_94209_e();
        double d12 = dwan5.func_94214_a(8.0);
        double d13 = dwan5.func_94212_f();
        double d14 = dwan5.func_94206_g();
        double d15 = dwan5.func_94210_h();
        double d16 = dwan6.func_94209_e();
        double d17 = dwan6.func_94214_a(8.0);
        double d18 = dwan6.func_94212_f();
        double d19 = dwan6.func_94206_g();
        double d20 = dwan6.func_94210_h();
        double d21 = dwan2.func_94214_a(7.0);
        double d22 = dwan2.func_94214_a(9.0);
        double d23 = dwan2.func_94206_g();
        double d24 = dwan2.func_94207_b(8.0);
        double d25 = dwan2.func_94210_h();
        double d26 = n;
        double d27 = (double)n + 0.5;
        double d28 = n + 1;
        double d29 = n3;
        double d30 = (double)n3 + 0.5;
        double d31 = n3 + 1;
        double d32 = (double)n + 0.5 - 0.0625;
        double d33 = (double)n + 0.5 + 0.0625;
        double d34 = (double)n3 + 0.5 - 0.0625;
        double d35 = (double)n3 + 0.5 + 0.0625;
        boolean bl = zxyg2._a(this._a.func_72798_a(n, n2, n3 - 1));
        boolean bl7 = zxyg2._a(this._a.func_72798_a(n, n2, n3 + 1));
        boolean bl8 = zxyg2._a(this._a.func_72798_a(n - 1, n2, n3));
        boolean bl9 = zxyg2._a(this._a.func_72798_a(n + 1, n2, n3));
        boolean bl10 = zxyg2.func_71877_c(this._a, n, n2 + 1, n3, 1);
        boolean bl11 = zxyg2.func_71877_c(this._a, n, n2 - 1, n3, 0);
        double d36 = 0.01;
        double d37 = 0.005;
        if ((!bl8 || !bl9) && (bl8 || bl9 || bl || bl7)) {
            if (bl8 && !bl9) {
                htvf2.func_78374_a(d26, n2 + 1, d30, d, d4);
                htvf2.func_78374_a(d26, n2 + 0, d30, d, d5);
                htvf2.func_78374_a(d27, n2 + 0, d30, d2, d5);
                htvf2.func_78374_a(d27, n2 + 1, d30, d2, d4);
                htvf2.func_78374_a(d27, n2 + 1, d30, d7, d9);
                htvf2.func_78374_a(d27, n2 + 0, d30, d7, d10);
                htvf2.func_78374_a(d26, n2 + 0, d30, d8, d10);
                htvf2.func_78374_a(d26, n2 + 1, d30, d8, d9);
                if (!bl7 && !bl) {
                    htvf2.func_78374_a(d27, n2 + 1, d35, d21, d23);
                    htvf2.func_78374_a(d27, n2 + 0, d35, d21, d25);
                    htvf2.func_78374_a(d27, n2 + 0, d34, d22, d25);
                    htvf2.func_78374_a(d27, n2 + 1, d34, d22, d23);
                    htvf2.func_78374_a(d27, n2 + 1, d34, d21, d23);
                    htvf2.func_78374_a(d27, n2 + 0, d34, d21, d25);
                    htvf2.func_78374_a(d27, n2 + 0, d35, d22, d25);
                    htvf2.func_78374_a(d27, n2 + 1, d35, d22, d23);
                }
                if (bl10 || n2 < n4 - 1 && this._a.func_72799_c(n - 1, n2 + 1, n3)) {
                    htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d35, d22, d25);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d34, d21, d25);
                    htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d35, d22, d25);
                    htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d34, d21, d25);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d34, d21, d24);
                }
                if (bl11 || n2 > 1 && this._a.func_72799_c(n - 1, n2 - 1, n3)) {
                    htvf2.func_78374_a(d26, (double)n2 - 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d35, d22, d25);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d34, d21, d25);
                    htvf2.func_78374_a(d26, (double)n2 - 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d26, (double)n2 - 0.01, d35, d22, d25);
                    htvf2.func_78374_a(d26, (double)n2 - 0.01, d34, d21, d25);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d34, d21, d24);
                }
            } else if (!bl8 && bl9) {
                htvf2.func_78374_a(d27, n2 + 1, d30, d2, d4);
                htvf2.func_78374_a(d27, n2 + 0, d30, d2, d5);
                htvf2.func_78374_a(d28, n2 + 0, d30, d3, d5);
                htvf2.func_78374_a(d28, n2 + 1, d30, d3, d4);
                htvf2.func_78374_a(d28, n2 + 1, d30, d6, d9);
                htvf2.func_78374_a(d28, n2 + 0, d30, d6, d10);
                htvf2.func_78374_a(d27, n2 + 0, d30, d7, d10);
                htvf2.func_78374_a(d27, n2 + 1, d30, d7, d9);
                if (!bl7 && !bl) {
                    htvf2.func_78374_a(d27, n2 + 1, d34, d21, d23);
                    htvf2.func_78374_a(d27, n2 + 0, d34, d21, d25);
                    htvf2.func_78374_a(d27, n2 + 0, d35, d22, d25);
                    htvf2.func_78374_a(d27, n2 + 1, d35, d22, d23);
                    htvf2.func_78374_a(d27, n2 + 1, d35, d21, d23);
                    htvf2.func_78374_a(d27, n2 + 0, d35, d21, d25);
                    htvf2.func_78374_a(d27, n2 + 0, d34, d22, d25);
                    htvf2.func_78374_a(d27, n2 + 1, d34, d22, d23);
                }
                if (bl10 || n2 < n4 - 1 && this._a.func_72799_c(n + 1, n2 + 1, n3)) {
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d35, d22, d23);
                    htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d34, d21, d23);
                    htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d35, d22, d23);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d34, d21, d23);
                }
                if (bl11 || n2 > 1 && this._a.func_72799_c(n + 1, n2 - 1, n3)) {
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d35, d22, d23);
                    htvf2.func_78374_a(d28, (double)n2 - 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d28, (double)n2 - 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d34, d21, d23);
                    htvf2.func_78374_a(d28, (double)n2 - 0.01, d35, d22, d23);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d28, (double)n2 - 0.01, d34, d21, d23);
                }
            }
        } else {
            htvf2.func_78374_a(d26, n2 + 1, d30, d, d4);
            htvf2.func_78374_a(d26, n2 + 0, d30, d, d5);
            htvf2.func_78374_a(d28, n2 + 0, d30, d3, d5);
            htvf2.func_78374_a(d28, n2 + 1, d30, d3, d4);
            htvf2.func_78374_a(d28, n2 + 1, d30, d6, d9);
            htvf2.func_78374_a(d28, n2 + 0, d30, d6, d10);
            htvf2.func_78374_a(d26, n2 + 0, d30, d8, d10);
            htvf2.func_78374_a(d26, n2 + 1, d30, d8, d9);
            if (bl10) {
                htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d35, d22, d25);
                htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d35, d22, d23);
                htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d34, d21, d23);
                htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d34, d21, d25);
                htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d35, d22, d25);
                htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d35, d22, d23);
                htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d34, d21, d23);
                htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d34, d21, d25);
            } else {
                if (n2 < n4 - 1 && this._a.func_72799_c(n - 1, n2 + 1, n3)) {
                    htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d35, d22, d25);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d34, d21, d25);
                    htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d35, d22, d25);
                    htvf2.func_78374_a(d26, (double)(n2 + 1) + 0.01, d34, d21, d25);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d34, d21, d24);
                }
                if (n2 < n4 - 1 && this._a.func_72799_c(n + 1, n2 + 1, n3)) {
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d35, d22, d23);
                    htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d34, d21, d23);
                    htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d35, d22, d23);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d27, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d28, (double)(n2 + 1) + 0.01, d34, d21, d23);
                }
            }
            if (bl11) {
                htvf2.func_78374_a(d26, (double)n2 - 0.01, d35, d22, d25);
                htvf2.func_78374_a(d28, (double)n2 - 0.01, d35, d22, d23);
                htvf2.func_78374_a(d28, (double)n2 - 0.01, d34, d21, d23);
                htvf2.func_78374_a(d26, (double)n2 - 0.01, d34, d21, d25);
                htvf2.func_78374_a(d28, (double)n2 - 0.01, d35, d22, d25);
                htvf2.func_78374_a(d26, (double)n2 - 0.01, d35, d22, d23);
                htvf2.func_78374_a(d26, (double)n2 - 0.01, d34, d21, d23);
                htvf2.func_78374_a(d28, (double)n2 - 0.01, d34, d21, d25);
            } else {
                if (n2 > 1 && this._a.func_72799_c(n - 1, n2 - 1, n3)) {
                    htvf2.func_78374_a(d26, (double)n2 - 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d35, d22, d25);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d34, d21, d25);
                    htvf2.func_78374_a(d26, (double)n2 - 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d26, (double)n2 - 0.01, d35, d22, d25);
                    htvf2.func_78374_a(d26, (double)n2 - 0.01, d34, d21, d25);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d34, d21, d24);
                }
                if (n2 > 1 && this._a.func_72799_c(n + 1, n2 - 1, n3)) {
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d35, d22, d23);
                    htvf2.func_78374_a(d28, (double)n2 - 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d28, (double)n2 - 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d34, d21, d23);
                    htvf2.func_78374_a(d28, (double)n2 - 0.01, d35, d22, d23);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d35, d22, d24);
                    htvf2.func_78374_a(d27, (double)n2 - 0.01, d34, d21, d24);
                    htvf2.func_78374_a(d28, (double)n2 - 0.01, d34, d21, d23);
                }
            }
        }
        if ((!bl || !bl7) && (bl8 || bl9 || bl || bl7)) {
            if (bl && !bl7) {
                htvf2.func_78374_a(d27, n2 + 1, d29, d11, d14);
                htvf2.func_78374_a(d27, n2 + 0, d29, d11, d15);
                htvf2.func_78374_a(d27, n2 + 0, d30, d12, d15);
                htvf2.func_78374_a(d27, n2 + 1, d30, d12, d14);
                htvf2.func_78374_a(d27, n2 + 1, d30, d17, d19);
                htvf2.func_78374_a(d27, n2 + 0, d30, d17, d20);
                htvf2.func_78374_a(d27, n2 + 0, d29, d18, d20);
                htvf2.func_78374_a(d27, n2 + 1, d29, d18, d19);
                if (!bl9 && !bl8) {
                    htvf2.func_78374_a(d32, n2 + 1, d30, d21, d23);
                    htvf2.func_78374_a(d32, n2 + 0, d30, d21, d25);
                    htvf2.func_78374_a(d33, n2 + 0, d30, d22, d25);
                    htvf2.func_78374_a(d33, n2 + 1, d30, d22, d23);
                    htvf2.func_78374_a(d33, n2 + 1, d30, d21, d23);
                    htvf2.func_78374_a(d33, n2 + 0, d30, d21, d25);
                    htvf2.func_78374_a(d32, n2 + 0, d30, d22, d25);
                    htvf2.func_78374_a(d32, n2 + 1, d30, d22, d23);
                }
                if (bl10 || n2 < n4 - 1 && this._a.func_72799_c(n, n2 + 1, n3 - 1)) {
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d29, d22, d23);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d30, d22, d24);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d30, d21, d24);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d29, d21, d23);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d30, d22, d23);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d29, d22, d24);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d29, d21, d24);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d30, d21, d23);
                }
                if (bl11 || n2 > 1 && this._a.func_72799_c(n, n2 - 1, n3 - 1)) {
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d29, d22, d23);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d30, d22, d24);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d30, d21, d24);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d29, d21, d23);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d30, d22, d23);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d29, d22, d24);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d29, d21, d24);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d30, d21, d23);
                }
            } else if (!bl && bl7) {
                htvf2.func_78374_a(d27, n2 + 1, d30, d12, d14);
                htvf2.func_78374_a(d27, n2 + 0, d30, d12, d15);
                htvf2.func_78374_a(d27, n2 + 0, d31, d13, d15);
                htvf2.func_78374_a(d27, n2 + 1, d31, d13, d14);
                htvf2.func_78374_a(d27, n2 + 1, d31, d16, d19);
                htvf2.func_78374_a(d27, n2 + 0, d31, d16, d20);
                htvf2.func_78374_a(d27, n2 + 0, d30, d17, d20);
                htvf2.func_78374_a(d27, n2 + 1, d30, d17, d19);
                if (!bl9 && !bl8) {
                    htvf2.func_78374_a(d33, n2 + 1, d30, d21, d23);
                    htvf2.func_78374_a(d33, n2 + 0, d30, d21, d25);
                    htvf2.func_78374_a(d32, n2 + 0, d30, d22, d25);
                    htvf2.func_78374_a(d32, n2 + 1, d30, d22, d23);
                    htvf2.func_78374_a(d32, n2 + 1, d30, d21, d23);
                    htvf2.func_78374_a(d32, n2 + 0, d30, d21, d25);
                    htvf2.func_78374_a(d33, n2 + 0, d30, d22, d25);
                    htvf2.func_78374_a(d33, n2 + 1, d30, d22, d23);
                }
                if (bl10 || n2 < n4 - 1 && this._a.func_72799_c(n, n2 + 1, n3 + 1)) {
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d30, d21, d24);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d31, d21, d25);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d31, d22, d25);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d30, d22, d24);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d31, d21, d24);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d30, d21, d25);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d30, d22, d25);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d31, d22, d24);
                }
                if (bl11 || n2 > 1 && this._a.func_72799_c(n, n2 - 1, n3 + 1)) {
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d30, d21, d24);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d31, d21, d25);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d31, d22, d25);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d30, d22, d24);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d31, d21, d24);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d30, d21, d25);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d30, d22, d25);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d31, d22, d24);
                }
            }
        } else {
            htvf2.func_78374_a(d27, n2 + 1, d31, d16, d19);
            htvf2.func_78374_a(d27, n2 + 0, d31, d16, d20);
            htvf2.func_78374_a(d27, n2 + 0, d29, d18, d20);
            htvf2.func_78374_a(d27, n2 + 1, d29, d18, d19);
            htvf2.func_78374_a(d27, n2 + 1, d29, d11, d14);
            htvf2.func_78374_a(d27, n2 + 0, d29, d11, d15);
            htvf2.func_78374_a(d27, n2 + 0, d31, d13, d15);
            htvf2.func_78374_a(d27, n2 + 1, d31, d13, d14);
            if (bl10) {
                htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d31, d22, d25);
                htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d29, d22, d23);
                htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d29, d21, d23);
                htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d31, d21, d25);
                htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d29, d22, d25);
                htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d31, d22, d23);
                htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d31, d21, d23);
                htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d29, d21, d25);
            } else {
                if (n2 < n4 - 1 && this._a.func_72799_c(n, n2 + 1, n3 - 1)) {
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d29, d22, d23);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d30, d22, d24);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d30, d21, d24);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d29, d21, d23);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d30, d22, d23);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d29, d22, d24);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d29, d21, d24);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d30, d21, d23);
                }
                if (n2 < n4 - 1 && this._a.func_72799_c(n, n2 + 1, n3 + 1)) {
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d30, d21, d24);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d31, d21, d25);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d31, d22, d25);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d30, d22, d24);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d31, d21, d24);
                    htvf2.func_78374_a(d32, (double)(n2 + 1) + 0.005, d30, d21, d25);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d30, d22, d25);
                    htvf2.func_78374_a(d33, (double)(n2 + 1) + 0.005, d31, d22, d24);
                }
            }
            if (bl11) {
                htvf2.func_78374_a(d33, (double)n2 - 0.005, d31, d22, d25);
                htvf2.func_78374_a(d33, (double)n2 - 0.005, d29, d22, d23);
                htvf2.func_78374_a(d32, (double)n2 - 0.005, d29, d21, d23);
                htvf2.func_78374_a(d32, (double)n2 - 0.005, d31, d21, d25);
                htvf2.func_78374_a(d33, (double)n2 - 0.005, d29, d22, d25);
                htvf2.func_78374_a(d33, (double)n2 - 0.005, d31, d22, d23);
                htvf2.func_78374_a(d32, (double)n2 - 0.005, d31, d21, d23);
                htvf2.func_78374_a(d32, (double)n2 - 0.005, d29, d21, d25);
            } else {
                if (n2 > 1 && this._a.func_72799_c(n, n2 - 1, n3 - 1)) {
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d29, d22, d23);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d30, d22, d24);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d30, d21, d24);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d29, d21, d23);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d30, d22, d23);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d29, d22, d24);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d29, d21, d24);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d30, d21, d23);
                }
                if (n2 > 1 && this._a.func_72799_c(n, n2 - 1, n3 + 1)) {
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d30, d21, d24);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d31, d21, d25);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d31, d22, d25);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d30, d22, d24);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d31, d21, d24);
                    htvf2.func_78374_a(d32, (double)n2 - 0.005, d30, d21, d25);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d30, d22, d25);
                    htvf2.func_78374_a(d33, (double)n2 - 0.005, d31, d22, d24);
                }
            }
        }
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, twgu.field_72037_aS.field_72022_cl);
        }
        return true;
    }

    public boolean _l(twgu twgu2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
        float f = 1.0f;
        int n4 = CustomColorizer.getColorMultiplier(twgu2, this._a, n, n2, n3);
        float f2 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n4 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        htvf2.func_78386_a(f * f2, f * f3, f * f4);
        double d = n;
        double d2 = n2;
        double d3 = n3;
        if (twgu2 == twgu.field_71962_X) {
            long l = (long)(n * 3129871) ^ (long)n3 * 116129781L ^ (long)n2;
            l = l * l * 42317861L + l * 11L;
            d += ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.5;
            d2 += ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 1.0) * 0.2;
            d3 += ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.5;
        }
        this._a(twgu2, this._a.func_72805_g(n, n2, n3), d, d2, d3, 1.0f);
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, twgu.field_72037_aS.field_72022_cl);
        }
        return true;
    }

    public boolean _m(twgu twgu2, int n, int n2, int n3) {
        xati xati2 = (xati)twgu2;
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(xati2.func_71874_e(this._a, n, n2, n3));
        float f = 1.0f;
        int n4 = CustomColorizer.getStemColorMultiplier(xati2, this._a, n, n2, n3);
        float f2 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n4 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        htvf2.func_78386_a(f * f2, f * f3, f * f4);
        xati2.func_71902_a(this._a, n, n2, n3);
        int n5 = xati2._a(this._a, n, n2, n3);
        if (n5 < 0) {
            this._a((twgu)xati2, this._a.func_72805_g(n, n2, n3), this._k, (double)n, (double)((float)n2 - 0.0625f), (double)n3);
        } else {
            this._a((twgu)xati2, this._a.func_72805_g(n, n2, n3), 0.5, (double)n, (double)((float)n2 - 0.0625f), (double)n3);
            this._a(xati2, this._a.func_72805_g(n, n2, n3), n5, this._k, (double)n, (double)((float)n2 - 0.0625f), (double)n3);
        }
        return true;
    }

    public boolean _n(twgu twgu2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
        htvf2.func_78386_a(1.0f, 1.0f, 1.0f);
        this._a(twgu2, this._a.func_72805_g(n, n2, n3), (double)n, (double)((float)n2 - 0.0625f), (double)n3);
        return true;
    }

    public void _a(twgu twgu2, double d, double d2, double d3, double d4, double d5, int n) {
        htvf htvf2 = this.__aF;
        dwan dwan2 = this._a(twgu2, 0, n);
        if (this._b()) {
            dwan2 = this._b;
        }
        double d6 = dwan2.func_94209_e();
        double d7 = dwan2.func_94206_g();
        double d8 = dwan2.func_94212_f();
        double d9 = dwan2.func_94210_h();
        double d10 = dwan2.func_94214_a(7.0);
        double d11 = dwan2.func_94207_b(6.0);
        double d12 = dwan2.func_94214_a(9.0);
        double d13 = dwan2.func_94207_b(8.0);
        double d14 = dwan2.func_94214_a(7.0);
        double d15 = dwan2.func_94207_b(13.0);
        double d16 = dwan2.func_94214_a(9.0);
        double d17 = dwan2.func_94207_b(15.0);
        double d18 = (d += 0.5) - 0.5;
        double d19 = d + 0.5;
        double d20 = (d3 += 0.5) - 0.5;
        double d21 = d3 + 0.5;
        double d22 = 0.0625;
        double d23 = 0.625;
        htvf2.func_78374_a(d + d4 * (1.0 - d23) - d22, d2 + d23, d3 + d5 * (1.0 - d23) - d22, d10, d11);
        htvf2.func_78374_a(d + d4 * (1.0 - d23) - d22, d2 + d23, d3 + d5 * (1.0 - d23) + d22, d10, d13);
        htvf2.func_78374_a(d + d4 * (1.0 - d23) + d22, d2 + d23, d3 + d5 * (1.0 - d23) + d22, d12, d13);
        htvf2.func_78374_a(d + d4 * (1.0 - d23) + d22, d2 + d23, d3 + d5 * (1.0 - d23) - d22, d12, d11);
        htvf2.func_78374_a(d + d22 + d4, d2, d3 - d22 + d5, d16, d15);
        htvf2.func_78374_a(d + d22 + d4, d2, d3 + d22 + d5, d16, d17);
        htvf2.func_78374_a(d - d22 + d4, d2, d3 + d22 + d5, d14, d17);
        htvf2.func_78374_a(d - d22 + d4, d2, d3 - d22 + d5, d14, d15);
        htvf2.func_78374_a(d - d22, d2 + 1.0, d20, d6, d7);
        htvf2.func_78374_a(d - d22 + d4, d2 + 0.0, d20 + d5, d6, d9);
        htvf2.func_78374_a(d - d22 + d4, d2 + 0.0, d21 + d5, d8, d9);
        htvf2.func_78374_a(d - d22, d2 + 1.0, d21, d8, d7);
        htvf2.func_78374_a(d + d22, d2 + 1.0, d21, d6, d7);
        htvf2.func_78374_a(d + d4 + d22, d2 + 0.0, d21 + d5, d6, d9);
        htvf2.func_78374_a(d + d4 + d22, d2 + 0.0, d20 + d5, d8, d9);
        htvf2.func_78374_a(d + d22, d2 + 1.0, d20, d8, d7);
        htvf2.func_78374_a(d18, d2 + 1.0, d3 + d22, d6, d7);
        htvf2.func_78374_a(d18 + d4, d2 + 0.0, d3 + d22 + d5, d6, d9);
        htvf2.func_78374_a(d19 + d4, d2 + 0.0, d3 + d22 + d5, d8, d9);
        htvf2.func_78374_a(d19, d2 + 1.0, d3 + d22, d8, d7);
        htvf2.func_78374_a(d19, d2 + 1.0, d3 - d22, d6, d7);
        htvf2.func_78374_a(d19 + d4, d2 + 0.0, d3 - d22 + d5, d6, d9);
        htvf2.func_78374_a(d18 + d4, d2 + 0.0, d3 - d22 + d5, d8, d9);
        htvf2.func_78374_a(d18, d2 + 1.0, d3 - d22, d8, d7);
    }

    public void _a(twgu twgu2, int n, double d, double d2, double d3, float f) {
        htvf htvf2 = this.__aF;
        dwan dwan2 = this._a(twgu2, 0, n);
        if (this._b()) {
            dwan2 = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null) {
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, twgu2, (int)d, (int)d2, (int)d3, -1, dwan2);
        }
        double d4 = dwan2.func_94209_e();
        double d5 = dwan2.func_94206_g();
        double d6 = dwan2.func_94212_f();
        double d7 = dwan2.func_94210_h();
        double d8 = 0.45 * (double)f;
        double d9 = d + 0.5 - d8;
        double d10 = d + 0.5 + d8;
        double d11 = d3 + 0.5 - d8;
        double d12 = d3 + 0.5 + d8;
        htvf2.func_78374_a(d9, d2 + (double)f, d11, d4, d5);
        htvf2.func_78374_a(d9, d2 + 0.0, d11, d4, d7);
        htvf2.func_78374_a(d10, d2 + 0.0, d12, d6, d7);
        htvf2.func_78374_a(d10, d2 + (double)f, d12, d6, d5);
        htvf2.func_78374_a(d10, d2 + (double)f, d12, d4, d5);
        htvf2.func_78374_a(d10, d2 + 0.0, d12, d4, d7);
        htvf2.func_78374_a(d9, d2 + 0.0, d11, d6, d7);
        htvf2.func_78374_a(d9, d2 + (double)f, d11, d6, d5);
        htvf2.func_78374_a(d9, d2 + (double)f, d12, d4, d5);
        htvf2.func_78374_a(d9, d2 + 0.0, d12, d4, d7);
        htvf2.func_78374_a(d10, d2 + 0.0, d11, d6, d7);
        htvf2.func_78374_a(d10, d2 + (double)f, d11, d6, d5);
        htvf2.func_78374_a(d10, d2 + (double)f, d11, d4, d5);
        htvf2.func_78374_a(d10, d2 + 0.0, d11, d4, d7);
        htvf2.func_78374_a(d9, d2 + 0.0, d12, d6, d7);
        htvf2.func_78374_a(d9, d2 + (double)f, d12, d6, d5);
    }

    public void _a(twgu twgu2, int n, double d, double d2, double d3, double d4) {
        htvf htvf2 = this.__aF;
        dwan dwan2 = this._a(twgu2, 0, n);
        if (this._b()) {
            dwan2 = this._b;
        }
        double d5 = dwan2.func_94209_e();
        double d6 = dwan2.func_94206_g();
        double d7 = dwan2.func_94212_f();
        double d8 = dwan2.func_94207_b(d * 16.0);
        double d9 = d2 + 0.5 - (double)0.45f;
        double d10 = d2 + 0.5 + (double)0.45f;
        double d11 = d4 + 0.5 - (double)0.45f;
        double d12 = d4 + 0.5 + (double)0.45f;
        htvf2.func_78374_a(d9, d3 + d, d11, d5, d6);
        htvf2.func_78374_a(d9, d3 + 0.0, d11, d5, d8);
        htvf2.func_78374_a(d10, d3 + 0.0, d12, d7, d8);
        htvf2.func_78374_a(d10, d3 + d, d12, d7, d6);
        htvf2.func_78374_a(d10, d3 + d, d12, d5, d6);
        htvf2.func_78374_a(d10, d3 + 0.0, d12, d5, d8);
        htvf2.func_78374_a(d9, d3 + 0.0, d11, d7, d8);
        htvf2.func_78374_a(d9, d3 + d, d11, d7, d6);
        htvf2.func_78374_a(d9, d3 + d, d12, d5, d6);
        htvf2.func_78374_a(d9, d3 + 0.0, d12, d5, d8);
        htvf2.func_78374_a(d10, d3 + 0.0, d11, d7, d8);
        htvf2.func_78374_a(d10, d3 + d, d11, d7, d6);
        htvf2.func_78374_a(d10, d3 + d, d11, d5, d6);
        htvf2.func_78374_a(d10, d3 + 0.0, d11, d5, d8);
        htvf2.func_78374_a(d9, d3 + 0.0, d12, d7, d8);
        htvf2.func_78374_a(d9, d3 + d, d12, d7, d6);
    }

    public boolean _o(twgu twgu2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        dwan dwan2 = this._a(twgu2, 1);
        if (this._b()) {
            dwan2 = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null) {
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, twgu2, n, n2, n3, 1, dwan2);
        }
        float f = 0.015625f;
        double d = dwan2.func_94209_e();
        double d2 = dwan2.func_94206_g();
        double d3 = dwan2.func_94212_f();
        double d4 = dwan2.func_94210_h();
        long l = (long)(n * 3129871) ^ (long)n3 * 116129781L ^ (long)n2;
        l = l * l * 42317861L + l * 11L;
        int n4 = (int)(l >> 16 & 3L);
        htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
        float f2 = (float)n + 0.5f;
        float f3 = (float)n3 + 0.5f;
        float f4 = (float)(n4 & 1) * 0.5f * (float)(1 - n4 / 2 % 2 * 2);
        float f5 = (float)(n4 + 1 & 1) * 0.5f * (float)(1 - (n4 + 1) / 2 % 2 * 2);
        int n5 = CustomColorizer.getLilypadColor();
        htvf2.func_78378_d(n5);
        htvf2.func_78374_a(f2 + f4 - f5, (float)n2 + f, f3 + f4 + f5, d, d2);
        htvf2.func_78374_a(f2 + f4 + f5, (float)n2 + f, f3 - f4 + f5, d3, d2);
        htvf2.func_78374_a(f2 - f4 + f5, (float)n2 + f, f3 - f4 - f5, d3, d4);
        htvf2.func_78374_a(f2 - f4 - f5, (float)n2 + f, f3 + f4 - f5, d, d4);
        htvf2.func_78378_d((n5 & 0xFEFEFE) >> 1);
        htvf2.func_78374_a(f2 - f4 - f5, (float)n2 + f, f3 + f4 - f5, d, d4);
        htvf2.func_78374_a(f2 - f4 + f5, (float)n2 + f, f3 - f4 - f5, d3, d4);
        htvf2.func_78374_a(f2 + f4 + f5, (float)n2 + f, f3 - f4 + f5, d3, d2);
        htvf2.func_78374_a(f2 + f4 - f5, (float)n2 + f, f3 + f4 + f5, d, d2);
        return true;
    }

    public void _a(xati xati2, int n, int n2, double d, double d2, double d3, double d4) {
        htvf htvf2 = this.__aF;
        dwan dwan2 = xati2._a();
        if (this._b()) {
            dwan2 = this._b;
        }
        double d5 = dwan2.func_94209_e();
        double d6 = dwan2.func_94206_g();
        double d7 = dwan2.func_94212_f();
        double d8 = dwan2.func_94210_h();
        double d9 = d2 + 0.5 - 0.5;
        double d10 = d2 + 0.5 + 0.5;
        double d11 = d4 + 0.5 - 0.5;
        double d12 = d4 + 0.5 + 0.5;
        double d13 = d2 + 0.5;
        double d14 = d4 + 0.5;
        if ((n2 + 1) / 2 % 2 == 1) {
            double d15 = d7;
            d7 = d5;
            d5 = d15;
        }
        if (n2 < 2) {
            htvf2.func_78374_a(d9, d3 + d, d14, d5, d6);
            htvf2.func_78374_a(d9, d3 + 0.0, d14, d5, d8);
            htvf2.func_78374_a(d10, d3 + 0.0, d14, d7, d8);
            htvf2.func_78374_a(d10, d3 + d, d14, d7, d6);
            htvf2.func_78374_a(d10, d3 + d, d14, d7, d6);
            htvf2.func_78374_a(d10, d3 + 0.0, d14, d7, d8);
            htvf2.func_78374_a(d9, d3 + 0.0, d14, d5, d8);
            htvf2.func_78374_a(d9, d3 + d, d14, d5, d6);
        } else {
            htvf2.func_78374_a(d13, d3 + d, d12, d5, d6);
            htvf2.func_78374_a(d13, d3 + 0.0, d12, d5, d8);
            htvf2.func_78374_a(d13, d3 + 0.0, d11, d7, d8);
            htvf2.func_78374_a(d13, d3 + d, d11, d7, d6);
            htvf2.func_78374_a(d13, d3 + d, d11, d7, d6);
            htvf2.func_78374_a(d13, d3 + 0.0, d11, d7, d8);
            htvf2.func_78374_a(d13, d3 + 0.0, d12, d5, d8);
            htvf2.func_78374_a(d13, d3 + d, d12, d5, d6);
        }
    }

    public void _a(twgu twgu2, int n, double d, double d2, double d3) {
        htvf htvf2 = this.__aF;
        dwan dwan2 = this._a(twgu2, 0, n);
        if (this._b()) {
            dwan2 = this._b;
        }
        double d4 = dwan2.func_94209_e();
        double d5 = dwan2.func_94206_g();
        double d6 = dwan2.func_94212_f();
        double d7 = dwan2.func_94210_h();
        double d8 = d + 0.5 - 0.25;
        double d9 = d + 0.5 + 0.25;
        double d10 = d3 + 0.5 - 0.5;
        double d11 = d3 + 0.5 + 0.5;
        htvf2.func_78374_a(d8, d2 + 1.0, d10, d4, d5);
        htvf2.func_78374_a(d8, d2 + 0.0, d10, d4, d7);
        htvf2.func_78374_a(d8, d2 + 0.0, d11, d6, d7);
        htvf2.func_78374_a(d8, d2 + 1.0, d11, d6, d5);
        htvf2.func_78374_a(d8, d2 + 1.0, d11, d4, d5);
        htvf2.func_78374_a(d8, d2 + 0.0, d11, d4, d7);
        htvf2.func_78374_a(d8, d2 + 0.0, d10, d6, d7);
        htvf2.func_78374_a(d8, d2 + 1.0, d10, d6, d5);
        htvf2.func_78374_a(d9, d2 + 1.0, d11, d4, d5);
        htvf2.func_78374_a(d9, d2 + 0.0, d11, d4, d7);
        htvf2.func_78374_a(d9, d2 + 0.0, d10, d6, d7);
        htvf2.func_78374_a(d9, d2 + 1.0, d10, d6, d5);
        htvf2.func_78374_a(d9, d2 + 1.0, d10, d4, d5);
        htvf2.func_78374_a(d9, d2 + 0.0, d10, d4, d7);
        htvf2.func_78374_a(d9, d2 + 0.0, d11, d6, d7);
        htvf2.func_78374_a(d9, d2 + 1.0, d11, d6, d5);
        d8 = d + 0.5 - 0.5;
        d9 = d + 0.5 + 0.5;
        d10 = d3 + 0.5 - 0.25;
        d11 = d3 + 0.5 + 0.25;
        htvf2.func_78374_a(d8, d2 + 1.0, d10, d4, d5);
        htvf2.func_78374_a(d8, d2 + 0.0, d10, d4, d7);
        htvf2.func_78374_a(d9, d2 + 0.0, d10, d6, d7);
        htvf2.func_78374_a(d9, d2 + 1.0, d10, d6, d5);
        htvf2.func_78374_a(d9, d2 + 1.0, d10, d4, d5);
        htvf2.func_78374_a(d9, d2 + 0.0, d10, d4, d7);
        htvf2.func_78374_a(d8, d2 + 0.0, d10, d6, d7);
        htvf2.func_78374_a(d8, d2 + 1.0, d10, d6, d5);
        htvf2.func_78374_a(d9, d2 + 1.0, d11, d4, d5);
        htvf2.func_78374_a(d9, d2 + 0.0, d11, d4, d7);
        htvf2.func_78374_a(d8, d2 + 0.0, d11, d6, d7);
        htvf2.func_78374_a(d8, d2 + 1.0, d11, d6, d5);
        htvf2.func_78374_a(d8, d2 + 1.0, d11, d4, d5);
        htvf2.func_78374_a(d8, d2 + 0.0, d11, d4, d7);
        htvf2.func_78374_a(d9, d2 + 0.0, d11, d6, d7);
        htvf2.func_78374_a(d9, d2 + 1.0, d11, d6, d5);
    }

    public boolean _p(twgu twgu2, int n, int n2, int n3) {
        float f;
        float f2;
        float f3;
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        htvf htvf2 = this.__aF;
        int n4 = CustomColorizer.getFluidColor(twgu2, this._a, n, n2, n3);
        float f4 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n4 & 0xFF) / 255.0f;
        boolean bl = twgu2.func_71877_c(this._a, n, n2 + 1, n3, 1);
        boolean bl2 = twgu2.func_71877_c(this._a, n, n2 - 1, n3, 0);
        boolean[] blArray = new boolean[]{twgu2.func_71877_c(this._a, n, n2, n3 - 1, 2), twgu2.func_71877_c(this._a, n, n2, n3 + 1, 3), twgu2.func_71877_c(this._a, n - 1, n2, n3, 4), twgu2.func_71877_c(this._a, n + 1, n2, n3, 5)};
        if (!(bl || bl2 || blArray[0] || blArray[1] || blArray[2] || blArray[3])) {
            return false;
        }
        boolean bl3 = false;
        float f7 = 0.5f;
        float f8 = 1.0f;
        float f9 = 0.8f;
        float f10 = 0.6f;
        double d7 = 0.0;
        double d8 = 1.0;
        tflj tflj2 = twgu2.field_72018_cp;
        int n5 = this._a.func_72805_g(n, n2, n3);
        double d9 = this._a(n, n2, n3, tflj2);
        double d10 = this._a(n, n2, n3 + 1, tflj2);
        double d11 = this._a(n + 1, n2, n3 + 1, tflj2);
        double d12 = this._a(n + 1, n2, n3, tflj2);
        double d13 = 0.001f;
        if (this._d || bl) {
            double d14;
            double d15;
            bl3 = true;
            dwan dwan2 = this._a(twgu2, 1, n5);
            float f11 = (float)ogyy._a(this._a, n, n2, n3, tflj2);
            if (f11 > -999.0f) {
                dwan2 = this._a(twgu2, 2, n5);
            }
            d9 -= d13;
            d10 -= d13;
            d11 -= d13;
            d12 -= d13;
            if (f11 < -999.0f) {
                d6 = dwan2.func_94214_a(0.0);
                d5 = dwan2.func_94207_b(0.0);
                d15 = d6;
                d4 = dwan2.func_94207_b(16.0);
                d3 = dwan2.func_94214_a(16.0);
                d14 = d4;
                d2 = d3;
                d = d5;
            } else {
                f3 = sajh._a(f11) * 0.25f;
                f2 = sajh._b(f11) * 0.25f;
                f = 8.0f;
                d6 = dwan2.func_94214_a(8.0f + (-f2 - f3) * 16.0f);
                d5 = dwan2.func_94207_b(8.0f + (-f2 + f3) * 16.0f);
                d15 = dwan2.func_94214_a(8.0f + (-f2 + f3) * 16.0f);
                d4 = dwan2.func_94207_b(8.0f + (f2 + f3) * 16.0f);
                d3 = dwan2.func_94214_a(8.0f + (f2 + f3) * 16.0f);
                d14 = dwan2.func_94207_b(8.0f + (f2 - f3) * 16.0f);
                d2 = dwan2.func_94214_a(8.0f + (f2 - f3) * 16.0f);
                d = dwan2.func_94207_b(8.0f + (-f2 - f3) * 16.0f);
            }
            htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2, n3));
            f3 = 1.0f;
            htvf2.func_78386_a(f8 * f3 * f4, f8 * f3 * f5, f8 * f3 * f6);
            double d16 = 3.90625E-5;
            htvf2.func_78374_a(n + 0, (double)n2 + d9, n3 + 0, d6 + d16, d5 + d16);
            htvf2.func_78374_a(n + 0, (double)n2 + d10, n3 + 1, d15 + d16, d4 - d16);
            htvf2.func_78374_a(n + 1, (double)n2 + d11, n3 + 1, d3 - d16, d14 - d16);
            htvf2.func_78374_a(n + 1, (double)n2 + d12, n3 + 0, d2 - d16, d + d16);
        }
        if (this._d || bl2) {
            htvf2.func_78380_c(twgu2.func_71874_e(this._a, n, n2 - 1, n3));
            float f12 = 1.0f;
            htvf2.func_78386_a(f7 * f12 * f4, f7 * f12 * f5, f7 * f12 * f6);
            this._a(twgu2, (double)n, (double)n2 + d13, (double)n3, this._a(twgu2, 0));
            bl3 = true;
        }
        for (int i = 0; i < 4; ++i) {
            int n6 = n;
            int n7 = n3;
            if (i == 0) {
                n7 = n3 - 1;
            }
            if (i == 1) {
                ++n7;
            }
            if (i == 2) {
                n6 = n - 1;
            }
            if (i == 3) {
                ++n6;
            }
            dwan dwan3 = this._a(twgu2, i + 2, n5);
            if (!this._d && !blArray[i]) continue;
            if (i == 0) {
                d6 = d9;
                d3 = d12;
                d2 = n;
                d4 = n + 1;
                d5 = (double)n3 + d13;
                d = (double)n3 + d13;
            } else if (i == 1) {
                d6 = d11;
                d3 = d10;
                d2 = n + 1;
                d4 = n;
                d5 = (double)(n3 + 1) - d13;
                d = (double)(n3 + 1) - d13;
            } else if (i == 2) {
                d6 = d10;
                d3 = d9;
                d2 = (double)n + d13;
                d4 = (double)n + d13;
                d5 = n3 + 1;
                d = n3;
            } else {
                d6 = d12;
                d3 = d11;
                d2 = (double)(n + 1) - d13;
                d4 = (double)(n + 1) - d13;
                d5 = n3;
                d = n3 + 1;
            }
            bl3 = true;
            float f13 = dwan3.func_94214_a(0.0);
            f3 = dwan3.func_94214_a(8.0);
            f2 = dwan3.func_94207_b((1.0 - d6) * 16.0 * 0.5);
            f = dwan3.func_94207_b((1.0 - d3) * 16.0 * 0.5);
            float f14 = dwan3.func_94207_b(8.0);
            htvf2.func_78380_c(twgu2.func_71874_e(this._a, n6, n2, n7));
            float f15 = 1.0f;
            f15 = i < 2 ? (f15 *= f9) : (f15 *= f10);
            htvf2.func_78386_a(f8 * f15 * f4, f8 * f15 * f5, f8 * f15 * f6);
            htvf2.func_78374_a(d2, (double)n2 + d6, d5, f13, f2);
            htvf2.func_78374_a(d4, (double)n2 + d3, d, f3, f);
            htvf2.func_78374_a(d4, n2 + 0, d, f3, f14);
            htvf2.func_78374_a(d2, n2 + 0, d5, f13, f14);
        }
        this._j = d7;
        this._k = d8;
        return bl3;
    }

    public float _a(int n, int n2, int n3, tflj tflj2) {
        int n4 = 0;
        float f = 0.0f;
        for (int i = 0; i < 4; ++i) {
            int n5 = n - (i & 1);
            int n6 = n3 - (i >> 1 & 1);
            if (this._a.func_72803_f(n5, n2 + 1, n6) == tflj2) {
                return 1.0f;
            }
            tflj tflj3 = this._a.func_72803_f(n5, n2, n6);
            if (tflj3 == tflj2) {
                int n7 = this._a.func_72805_g(n5, n2, n6);
                if (n7 >= 8 || n7 == 0) {
                    f += ogyy._a(n7) * 10.0f;
                    n4 += 10;
                }
                f += ogyy._a(n7);
                ++n4;
                continue;
            }
            if (tflj3._a()) continue;
            f += 1.0f;
            ++n4;
        }
        return 1.0f - f / (float)n4;
    }

    public void _a(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, int n4) {
        float f = 0.5f;
        float f2 = 1.0f;
        float f3 = 0.8f;
        float f4 = 0.6f;
        htvf htvf2 = this.__aF;
        htvf2.func_78382_b();
        htvf2.func_78380_c(twgu2.func_71874_e(ozlu2, n, n2, n3));
        float f5 = 1.0f;
        float f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        htvf2.func_78386_a(f * f6, f * f6, f * f6);
        this._a(twgu2, -0.5, -0.5, -0.5, this._a(twgu2, 0, n4));
        f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        htvf2.func_78386_a(f2 * f6, f2 * f6, f2 * f6);
        this._b(twgu2, -0.5, -0.5, -0.5, this._a(twgu2, 1, n4));
        f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        htvf2.func_78386_a(f3 * f6, f3 * f6, f3 * f6);
        this._c(twgu2, -0.5, -0.5, -0.5, this._a(twgu2, 2, n4));
        f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        htvf2.func_78386_a(f3 * f6, f3 * f6, f3 * f6);
        this._d(twgu2, -0.5, -0.5, -0.5, this._a(twgu2, 3, n4));
        f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        htvf2.func_78386_a(f4 * f6, f4 * f6, f4 * f6);
        this._e(twgu2, -0.5, -0.5, -0.5, this._a(twgu2, 4, n4));
        f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        htvf2.func_78386_a(f4 * f6, f4 * f6, f4 * f6);
        this._f(twgu2, -0.5, -0.5, -0.5, this._a(twgu2, 5, n4));
        htvf2.func_78381_a();
    }

    public boolean _q(twgu twgu2, int n, int n2, int n3) {
        int n4 = CustomColorizer.getColorMultiplier(twgu2, this._a, n, n2, n3);
        float f = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n4 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            float f4 = (f * 30.0f + f2 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f * 30.0f + f2 * 70.0f) / 100.0f;
            float f6 = (f * 30.0f + f3 * 70.0f) / 100.0f;
            f = f4;
            f2 = f5;
            f3 = f6;
        }
        return xpzm._C() && twgu.field_71984_q[twgu2.field_71990_ca] == 0 ? (this._o ? this._b(twgu2, n, n2, n3, f, f2, f3) : this._a(twgu2, n, n2, n3, f, f2, f3)) : this._c(twgu2, n, n2, n3, f, f2, f3);
    }

    public boolean _r(twgu twgu2, int n, int n2, int n3) {
        int n4 = this._a.func_72805_g(n, n2, n3);
        int n5 = n4 & 0xC;
        if (n5 == 4) {
            this._q = 1;
            this._r = 1;
            this._u = 1;
            this._v = 1;
        } else if (n5 == 8) {
            this._s = 1;
            this._t = 1;
        }
        boolean bl = this._q(twgu2, n, n2, n3);
        this._s = 0;
        this._q = 0;
        this._r = 0;
        this._t = 0;
        this._u = 0;
        this._v = 0;
        return bl;
    }

    public boolean _s(twgu twgu2, int n, int n2, int n3) {
        int n4 = this._a.func_72805_g(n, n2, n3);
        if (n4 == 3) {
            this._q = 1;
            this._r = 1;
            this._u = 1;
            this._v = 1;
        } else if (n4 == 4) {
            this._s = 1;
            this._t = 1;
        }
        boolean bl = this._q(twgu2, n, n2, n3);
        this._s = 0;
        this._q = 0;
        this._r = 0;
        this._t = 0;
        this._u = 0;
        this._v = 0;
        return bl;
    }

    public void _a(twgu twgu2, int n, int n2, int n3, int n4) {
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean bl = true;
        int n5 = -1;
        if (twgu2 == twgu.field_71980_u) {
            bl = false;
        } else if (this._b()) {
            bl = false;
        }
        boolean bl2 = twgu2 == twgu.field_71946_M;
        switch (n4) {
            case 0: {
                if (this._j <= 0.0) {
                    --n2;
                }
                this._S = twgu2.func_71874_e(this._a, n - 1, n2, n3);
                this._U = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
                this._V = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
                this._X = twgu2.func_71874_e(this._a, n + 1, n2, n3);
                this._y = this._a(this._a, n - 1, n2, n3);
                this._A = this._a(this._a, n, n2, n3 - 1);
                this._B = this._a(this._a, n, n2, n3 + 1);
                this._D = this._a(this._a, n + 1, n2, n3);
                boolean bl3 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 - 1, n3)];
                boolean bl4 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 - 1, n3)];
                boolean bl5 = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 + 1)];
                boolean bl6 = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 - 1)];
                if (!bl6 && !bl4) {
                    this._x = this._y;
                    this._R = this._S;
                } else {
                    this._x = this._a(this._a, n - 1, n2, n3 - 1);
                    this._R = twgu2.func_71874_e(this._a, n - 1, n2, n3 - 1);
                }
                if (!bl5 && !bl4) {
                    this._z = this._y;
                    this._T = this._S;
                } else {
                    this._z = this._a(this._a, n - 1, n2, n3 + 1);
                    this._T = twgu2.func_71874_e(this._a, n - 1, n2, n3 + 1);
                }
                if (!bl6 && !bl3) {
                    this._C = this._D;
                    this._W = this._X;
                } else {
                    this._C = this._a(this._a, n + 1, n2, n3 - 1);
                    this._W = twgu2.func_71874_e(this._a, n + 1, n2, n3 - 1);
                }
                if (!bl5 && !bl3) {
                    this._E = this._D;
                    this._Y = this._X;
                } else {
                    this._E = this._a(this._a, n + 1, n2, n3 + 1);
                    this._Y = twgu2.func_71874_e(this._a, n + 1, n2, n3 + 1);
                }
                if (this._j <= 0.0) {
                    ++n2;
                }
                if (n5 < 0) {
                    n5 = twgu2.func_71874_e(this._a, n, n2, n3);
                }
                int n6 = n5;
                if (this._j <= 0.0 || !this._a.func_72804_r(n, n2 - 1, n3)) {
                    n6 = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
                }
                float f5 = this._a(this._a, n, n2 - 1, n3);
                f = (this._z + this._y + this._B + f5) / 4.0f;
                f4 = (this._B + f5 + this._E + this._D) / 4.0f;
                f3 = (f5 + this._A + this._D + this._C) / 4.0f;
                f2 = (this._y + this._x + f5 + this._A) / 4.0f;
                this.__al = this._a(this._T, this._S, this._V, n6);
                this.__ao = this._a(this._V, this._Y, this._X, n6);
                this.__an = this._a(this._U, this._X, this._W, n6);
                this.__am = this._a(this._S, this._R, this._U, n6);
                if (bl2) {
                    f2 = f5;
                    f3 = f5;
                    f4 = f5;
                    f = f5;
                    this.__an = this.__am = n6;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                if (bl) {
                    this.__as = 0.5f;
                    this.__ar = 0.5f;
                    this.__aq = 0.5f;
                    this.__ap = 0.5f;
                    this.__aw = 0.5f;
                    this.__av = 0.5f;
                    this.__au = 0.5f;
                    this.__at = 0.5f;
                    this.__aA = 0.5f;
                    this.__az = 0.5f;
                    this.__ay = 0.5f;
                    this.__ax = 0.5f;
                } else {
                    this.__as = 0.5f;
                    this.__ar = 0.5f;
                    this.__aq = 0.5f;
                    this.__ap = 0.5f;
                    this.__aw = 0.5f;
                    this.__av = 0.5f;
                    this.__au = 0.5f;
                    this.__at = 0.5f;
                    this.__aA = 0.5f;
                    this.__az = 0.5f;
                    this.__ay = 0.5f;
                    this.__ax = 0.5f;
                }
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
                break;
            }
            case 1: {
                if (this._k >= 1.0) {
                    ++n2;
                }
                this.__aa = twgu2.func_71874_e(this._a, n - 1, n2, n3);
                this.__ae = twgu2.func_71874_e(this._a, n + 1, n2, n3);
                this.__ac = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
                this.__af = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
                this._G = this._a(this._a, n - 1, n2, n3);
                this._K = this._a(this._a, n + 1, n2, n3);
                this._I = this._a(this._a, n, n2, n3 - 1);
                this._L = this._a(this._a, n, n2, n3 + 1);
                boolean bl7 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 + 1, n3)];
                boolean bl8 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 + 1, n3)];
                boolean bl9 = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 + 1)];
                boolean bl10 = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 - 1)];
                if (!bl10 && !bl8) {
                    this._F = this._G;
                    this._Z = this.__aa;
                } else {
                    this._F = this._a(this._a, n - 1, n2, n3 - 1);
                    this._Z = twgu2.func_71874_e(this._a, n - 1, n2, n3 - 1);
                }
                if (!bl10 && !bl7) {
                    this._J = this._K;
                    this.__ad = this.__ae;
                } else {
                    this._J = this._a(this._a, n + 1, n2, n3 - 1);
                    this.__ad = twgu2.func_71874_e(this._a, n + 1, n2, n3 - 1);
                }
                if (!bl9 && !bl8) {
                    this._H = this._G;
                    this.__ab = this.__aa;
                } else {
                    this._H = this._a(this._a, n - 1, n2, n3 + 1);
                    this.__ab = twgu2.func_71874_e(this._a, n - 1, n2, n3 + 1);
                }
                if (!bl9 && !bl7) {
                    this._M = this._K;
                    this.__ag = this.__ae;
                } else {
                    this._M = this._a(this._a, n + 1, n2, n3 + 1);
                    this.__ag = twgu2.func_71874_e(this._a, n + 1, n2, n3 + 1);
                }
                if (this._k >= 1.0) {
                    --n2;
                }
                if (n5 < 0) {
                    n5 = twgu2.func_71874_e(this._a, n, n2, n3);
                }
                int n7 = n5;
                if (this._k >= 1.0 || !this._a.func_72804_r(n, n2 + 1, n3)) {
                    n7 = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
                }
                float f6 = this._a(this._a, n, n2 + 1, n3);
                f4 = (this._H + this._G + this._L + f6) / 4.0f;
                f = (this._L + f6 + this._M + this._K) / 4.0f;
                f2 = (f6 + this._I + this._K + this._J) / 4.0f;
                f3 = (this._G + this._F + f6 + this._I) / 4.0f;
                this.__ao = this._a(this.__ab, this.__aa, this.__af, n7);
                this.__al = this._a(this.__af, this.__ag, this.__ae, n7);
                this.__am = this._a(this.__ac, this.__ae, this.__ad, n7);
                this.__an = this._a(this.__aa, this._Z, this.__ac, n7);
                if (bl2) {
                    f2 = f6;
                    f3 = f6;
                    f4 = f6;
                    f = f6;
                    this.__an = this.__am = n7;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                this.__as = 1.0f;
                this.__ar = 1.0f;
                this.__aq = 1.0f;
                this.__ap = 1.0f;
                this.__aw = 1.0f;
                this.__av = 1.0f;
                this.__au = 1.0f;
                this.__at = 1.0f;
                this.__aA = 1.0f;
                this.__az = 1.0f;
                this.__ay = 1.0f;
                this.__ax = 1.0f;
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
                break;
            }
            case 2: {
                if (this._l <= 0.0) {
                    --n3;
                }
                this._N = this._a(this._a, n - 1, n2, n3);
                this._A = this._a(this._a, n, n2 - 1, n3);
                this._I = this._a(this._a, n, n2 + 1, n3);
                this._O = this._a(this._a, n + 1, n2, n3);
                this.__ah = twgu2.func_71874_e(this._a, n - 1, n2, n3);
                this._U = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
                this.__ac = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
                this.__ai = twgu2.func_71874_e(this._a, n + 1, n2, n3);
                boolean bl11 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 - 1)];
                boolean bl12 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 - 1)];
                boolean bl13 = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 - 1)];
                boolean bl14 = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 - 1)];
                if (!bl12 && !bl14) {
                    this._x = this._N;
                    this._R = this.__ah;
                } else {
                    this._x = this._a(this._a, n - 1, n2 - 1, n3);
                    this._R = twgu2.func_71874_e(this._a, n - 1, n2 - 1, n3);
                }
                if (!bl12 && !bl13) {
                    this._F = this._N;
                    this._Z = this.__ah;
                } else {
                    this._F = this._a(this._a, n - 1, n2 + 1, n3);
                    this._Z = twgu2.func_71874_e(this._a, n - 1, n2 + 1, n3);
                }
                if (!bl11 && !bl14) {
                    this._C = this._O;
                    this._W = this.__ai;
                } else {
                    this._C = this._a(this._a, n + 1, n2 - 1, n3);
                    this._W = twgu2.func_71874_e(this._a, n + 1, n2 - 1, n3);
                }
                if (!bl11 && !bl13) {
                    this._J = this._O;
                    this.__ad = this.__ai;
                } else {
                    this._J = this._a(this._a, n + 1, n2 + 1, n3);
                    this.__ad = twgu2.func_71874_e(this._a, n + 1, n2 + 1, n3);
                }
                if (this._l <= 0.0) {
                    ++n3;
                }
                if (n5 < 0) {
                    n5 = twgu2.func_71874_e(this._a, n, n2, n3);
                }
                int n8 = n5;
                if (this._l <= 0.0 || !this._a.func_72804_r(n, n2, n3 - 1)) {
                    n8 = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
                }
                float f7 = this._a(this._a, n, n2, n3 - 1);
                f = (this._N + this._F + f7 + this._I) / 4.0f;
                f2 = (f7 + this._I + this._O + this._J) / 4.0f;
                f3 = (this._A + f7 + this._C + this._O) / 4.0f;
                f4 = (this._x + this._N + this._A + f7) / 4.0f;
                this.__al = this._a(this.__ah, this._Z, this.__ac, n8);
                this.__am = this._a(this.__ac, this.__ai, this.__ad, n8);
                this.__an = this._a(this._U, this._W, this.__ai, n8);
                this.__ao = this._a(this._R, this.__ah, this._U, n8);
                if (bl2) {
                    f2 = f7;
                    f3 = f7;
                    f4 = f7;
                    f = f7;
                    this.__an = this.__am = n8;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                if (bl) {
                    this.__as = 0.8f;
                    this.__ar = 0.8f;
                    this.__aq = 0.8f;
                    this.__ap = 0.8f;
                    this.__aw = 0.8f;
                    this.__av = 0.8f;
                    this.__au = 0.8f;
                    this.__at = 0.8f;
                    this.__aA = 0.8f;
                    this.__az = 0.8f;
                    this.__ay = 0.8f;
                    this.__ax = 0.8f;
                } else {
                    this.__as = 0.8f;
                    this.__ar = 0.8f;
                    this.__aq = 0.8f;
                    this.__ap = 0.8f;
                    this.__aw = 0.8f;
                    this.__av = 0.8f;
                    this.__au = 0.8f;
                    this.__at = 0.8f;
                    this.__aA = 0.8f;
                    this.__az = 0.8f;
                    this.__ay = 0.8f;
                    this.__ax = 0.8f;
                }
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
                break;
            }
            case 3: {
                if (this._m >= 1.0) {
                    ++n3;
                }
                this._P = this._a(this._a, n - 1, n2, n3);
                this._Q = this._a(this._a, n + 1, n2, n3);
                this._B = this._a(this._a, n, n2 - 1, n3);
                this._L = this._a(this._a, n, n2 + 1, n3);
                this.__aj = twgu2.func_71874_e(this._a, n - 1, n2, n3);
                this.__ak = twgu2.func_71874_e(this._a, n + 1, n2, n3);
                this._V = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
                this.__af = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
                boolean bl15 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 + 1)];
                boolean bl16 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 + 1)];
                boolean bl17 = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 + 1)];
                boolean bl18 = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 + 1)];
                if (!bl16 && !bl18) {
                    this._z = this._P;
                    this._T = this.__aj;
                } else {
                    this._z = this._a(this._a, n - 1, n2 - 1, n3);
                    this._T = twgu2.func_71874_e(this._a, n - 1, n2 - 1, n3);
                }
                if (!bl16 && !bl17) {
                    this._H = this._P;
                    this.__ab = this.__aj;
                } else {
                    this._H = this._a(this._a, n - 1, n2 + 1, n3);
                    this.__ab = twgu2.func_71874_e(this._a, n - 1, n2 + 1, n3);
                }
                if (!bl15 && !bl18) {
                    this._E = this._Q;
                    this._Y = this.__ak;
                } else {
                    this._E = this._a(this._a, n + 1, n2 - 1, n3);
                    this._Y = twgu2.func_71874_e(this._a, n + 1, n2 - 1, n3);
                }
                if (!bl15 && !bl17) {
                    this._M = this._Q;
                    this.__ag = this.__ak;
                } else {
                    this._M = this._a(this._a, n + 1, n2 + 1, n3);
                    this.__ag = twgu2.func_71874_e(this._a, n + 1, n2 + 1, n3);
                }
                if (this._m >= 1.0) {
                    --n3;
                }
                if (n5 < 0) {
                    n5 = twgu2.func_71874_e(this._a, n, n2, n3);
                }
                int n9 = n5;
                if (this._m >= 1.0 || !this._a.func_72804_r(n, n2, n3 + 1)) {
                    n9 = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
                }
                float f8 = this._a(this._a, n, n2, n3 + 1);
                f = (this._P + this._H + f8 + this._L) / 4.0f;
                f4 = (f8 + this._L + this._Q + this._M) / 4.0f;
                f3 = (this._B + f8 + this._E + this._Q) / 4.0f;
                f2 = (this._z + this._P + this._B + f8) / 4.0f;
                this.__al = this._a(this.__aj, this.__ab, this.__af, n9);
                this.__ao = this._a(this.__af, this.__ak, this.__ag, n9);
                this.__an = this._a(this._V, this._Y, this.__ak, n9);
                this.__am = this._a(this._T, this.__aj, this._V, n9);
                if (bl2) {
                    f2 = f8;
                    f3 = f8;
                    f4 = f8;
                    f = f8;
                    this.__an = this.__am = n9;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                if (bl) {
                    this.__as = 0.8f;
                    this.__ar = 0.8f;
                    this.__aq = 0.8f;
                    this.__ap = 0.8f;
                    this.__aw = 0.8f;
                    this.__av = 0.8f;
                    this.__au = 0.8f;
                    this.__at = 0.8f;
                    this.__aA = 0.8f;
                    this.__az = 0.8f;
                    this.__ay = 0.8f;
                    this.__ax = 0.8f;
                } else {
                    this.__as = 0.8f;
                    this.__ar = 0.8f;
                    this.__aq = 0.8f;
                    this.__ap = 0.8f;
                    this.__aw = 0.8f;
                    this.__av = 0.8f;
                    this.__au = 0.8f;
                    this.__at = 0.8f;
                    this.__aA = 0.8f;
                    this.__az = 0.8f;
                    this.__ay = 0.8f;
                    this.__ax = 0.8f;
                }
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
                break;
            }
            case 4: {
                if (this._h <= 0.0) {
                    --n;
                }
                this._y = this._a(this._a, n, n2 - 1, n3);
                this._N = this._a(this._a, n, n2, n3 - 1);
                this._P = this._a(this._a, n, n2, n3 + 1);
                this._G = this._a(this._a, n, n2 + 1, n3);
                this._S = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
                this.__ah = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
                this.__aj = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
                this.__aa = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
                boolean bl19 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 + 1, n3)];
                boolean bl20 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 - 1, n3)];
                boolean bl21 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 - 1)];
                boolean bl22 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 + 1)];
                if (!bl21 && !bl20) {
                    this._x = this._N;
                    this._R = this.__ah;
                } else {
                    this._x = this._a(this._a, n, n2 - 1, n3 - 1);
                    this._R = twgu2.func_71874_e(this._a, n, n2 - 1, n3 - 1);
                }
                if (!bl22 && !bl20) {
                    this._z = this._P;
                    this._T = this.__aj;
                } else {
                    this._z = this._a(this._a, n, n2 - 1, n3 + 1);
                    this._T = twgu2.func_71874_e(this._a, n, n2 - 1, n3 + 1);
                }
                if (!bl21 && !bl19) {
                    this._F = this._N;
                    this._Z = this.__ah;
                } else {
                    this._F = this._a(this._a, n, n2 + 1, n3 - 1);
                    this._Z = twgu2.func_71874_e(this._a, n, n2 + 1, n3 - 1);
                }
                if (!bl22 && !bl19) {
                    this._H = this._P;
                    this.__ab = this.__aj;
                } else {
                    this._H = this._a(this._a, n, n2 + 1, n3 + 1);
                    this.__ab = twgu2.func_71874_e(this._a, n, n2 + 1, n3 + 1);
                }
                if (this._h <= 0.0) {
                    ++n;
                }
                if (n5 < 0) {
                    n5 = twgu2.func_71874_e(this._a, n, n2, n3);
                }
                int n10 = n5;
                if (this._h <= 0.0 || !this._a.func_72804_r(n - 1, n2, n3)) {
                    n10 = twgu2.func_71874_e(this._a, n - 1, n2, n3);
                }
                float f9 = this._a(this._a, n - 1, n2, n3);
                f4 = (this._y + this._z + f9 + this._P) / 4.0f;
                f = (f9 + this._P + this._G + this._H) / 4.0f;
                f2 = (this._N + f9 + this._F + this._G) / 4.0f;
                f3 = (this._x + this._y + this._N + f9) / 4.0f;
                this.__ao = this._a(this._S, this._T, this.__aj, n10);
                this.__al = this._a(this.__aj, this.__aa, this.__ab, n10);
                this.__am = this._a(this.__ah, this._Z, this.__aa, n10);
                this.__an = this._a(this._R, this._S, this.__ah, n10);
                if (bl2) {
                    f2 = f9;
                    f3 = f9;
                    f4 = f9;
                    f = f9;
                    this.__an = this.__am = n10;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                if (bl) {
                    this.__as = 0.6f;
                    this.__ar = 0.6f;
                    this.__aq = 0.6f;
                    this.__ap = 0.6f;
                    this.__aw = 0.6f;
                    this.__av = 0.6f;
                    this.__au = 0.6f;
                    this.__at = 0.6f;
                    this.__aA = 0.6f;
                    this.__az = 0.6f;
                    this.__ay = 0.6f;
                    this.__ax = 0.6f;
                } else {
                    this.__as = 0.6f;
                    this.__ar = 0.6f;
                    this.__aq = 0.6f;
                    this.__ap = 0.6f;
                    this.__aw = 0.6f;
                    this.__av = 0.6f;
                    this.__au = 0.6f;
                    this.__at = 0.6f;
                    this.__aA = 0.6f;
                    this.__az = 0.6f;
                    this.__ay = 0.6f;
                    this.__ax = 0.6f;
                }
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
                break;
            }
            case 5: {
                if (this._i >= 1.0) {
                    ++n;
                }
                this._D = this._a(this._a, n, n2 - 1, n3);
                this._O = this._a(this._a, n, n2, n3 - 1);
                this._Q = this._a(this._a, n, n2, n3 + 1);
                this._K = this._a(this._a, n, n2 + 1, n3);
                this._X = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
                this.__ai = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
                this.__ak = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
                this.__ae = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
                boolean bl23 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 + 1, n3)];
                boolean bl24 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 - 1, n3)];
                boolean bl25 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 + 1)];
                boolean bl26 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 - 1)];
                if (!bl24 && !bl26) {
                    this._C = this._O;
                    this._W = this.__ai;
                } else {
                    this._C = this._a(this._a, n, n2 - 1, n3 - 1);
                    this._W = twgu2.func_71874_e(this._a, n, n2 - 1, n3 - 1);
                }
                if (!bl24 && !bl25) {
                    this._E = this._Q;
                    this._Y = this.__ak;
                } else {
                    this._E = this._a(this._a, n, n2 - 1, n3 + 1);
                    this._Y = twgu2.func_71874_e(this._a, n, n2 - 1, n3 + 1);
                }
                if (!bl23 && !bl26) {
                    this._J = this._O;
                    this.__ad = this.__ai;
                } else {
                    this._J = this._a(this._a, n, n2 + 1, n3 - 1);
                    this.__ad = twgu2.func_71874_e(this._a, n, n2 + 1, n3 - 1);
                }
                if (!bl23 && !bl25) {
                    this._M = this._Q;
                    this.__ag = this.__ak;
                } else {
                    this._M = this._a(this._a, n, n2 + 1, n3 + 1);
                    this.__ag = twgu2.func_71874_e(this._a, n, n2 + 1, n3 + 1);
                }
                if (this._i >= 1.0) {
                    --n;
                }
                if (n5 < 0) {
                    n5 = twgu2.func_71874_e(this._a, n, n2, n3);
                }
                int n11 = n5;
                if (this._i >= 1.0 || !this._a.func_72804_r(n + 1, n2, n3)) {
                    n11 = twgu2.func_71874_e(this._a, n + 1, n2, n3);
                }
                float f10 = this._a(this._a, n + 1, n2, n3);
                f = (this._D + this._E + f10 + this._Q) / 4.0f;
                f2 = (this._C + this._D + this._O + f10) / 4.0f;
                f3 = (this._O + f10 + this._J + this._K) / 4.0f;
                f4 = (f10 + this._Q + this._K + this._M) / 4.0f;
                this.__al = this._a(this._X, this._Y, this.__ak, n11);
                this.__ao = this._a(this.__ak, this.__ae, this.__ag, n11);
                this.__an = this._a(this.__ai, this.__ad, this.__ae, n11);
                this.__am = this._a(this._W, this._X, this.__ai, n11);
                if (bl2) {
                    f2 = f10;
                    f3 = f10;
                    f4 = f10;
                    f = f10;
                    this.__an = this.__am = n11;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                if (bl) {
                    this.__as = 0.6f;
                    this.__ar = 0.6f;
                    this.__aq = 0.6f;
                    this.__ap = 0.6f;
                    this.__aw = 0.6f;
                    this.__av = 0.6f;
                    this.__au = 0.6f;
                    this.__at = 0.6f;
                    this.__aA = 0.6f;
                    this.__az = 0.6f;
                    this.__ay = 0.6f;
                    this.__ax = 0.6f;
                } else {
                    this.__as = 0.6f;
                    this.__ar = 0.6f;
                    this.__aq = 0.6f;
                    this.__ap = 0.6f;
                    this.__aw = 0.6f;
                    this.__av = 0.6f;
                    this.__au = 0.6f;
                    this.__at = 0.6f;
                    this.__aA = 0.6f;
                    this.__az = 0.6f;
                    this.__ay = 0.6f;
                    this.__ax = 0.6f;
                }
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
            }
        }
    }

    public boolean _a(twgu twgu2, int n, int n2, int n3, float f, float f2, float f3) {
        dwan dwan2;
        float f4;
        int n4;
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        this._w = true;
        boolean bl5 = this.__aF.defaultTexture;
        boolean bl6 = Config.isBetterGrass() && bl5;
        boolean bl7 = twgu2 == twgu.field_71946_M;
        boolean bl8 = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        boolean bl9 = true;
        int n5 = -1;
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(983055);
        if (twgu2 == twgu.field_71980_u) {
            bl9 = false;
        } else if (this._b()) {
            bl9 = false;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2 - 1, n3, 0)) {
            if (this._j <= 0.0) {
                --n2;
            }
            this._S = twgu2.func_71874_e(this._a, n - 1, n2, n3);
            this._U = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
            this._V = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
            this._X = twgu2.func_71874_e(this._a, n + 1, n2, n3);
            this._y = this._a(this._a, n - 1, n2, n3);
            this._A = this._a(this._a, n, n2, n3 - 1);
            this._B = this._a(this._a, n, n2, n3 + 1);
            this._D = this._a(this._a, n + 1, n2, n3);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 - 1, n3)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 - 1, n3)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 + 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 - 1)];
            if (!bl && !bl3) {
                this._x = this._y;
                this._R = this._S;
            } else {
                this._x = this._a(this._a, n - 1, n2, n3 - 1);
                this._R = twgu2.func_71874_e(this._a, n - 1, n2, n3 - 1);
            }
            if (!bl2 && !bl3) {
                this._z = this._y;
                this._T = this._S;
            } else {
                this._z = this._a(this._a, n - 1, n2, n3 + 1);
                this._T = twgu2.func_71874_e(this._a, n - 1, n2, n3 + 1);
            }
            if (!bl && !bl4) {
                this._C = this._D;
                this._W = this._X;
            } else {
                this._C = this._a(this._a, n + 1, n2, n3 - 1);
                this._W = twgu2.func_71874_e(this._a, n + 1, n2, n3 - 1);
            }
            if (!bl2 && !bl4) {
                this._E = this._D;
                this._Y = this._X;
            } else {
                this._E = this._a(this._a, n + 1, n2, n3 + 1);
                this._Y = twgu2.func_71874_e(this._a, n + 1, n2, n3 + 1);
            }
            if (this._j <= 0.0) {
                ++n2;
            }
            if (n5 < 0) {
                n5 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._j <= 0.0 || !this._a.func_72804_r(n, n2 - 1, n3)) {
                n4 = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
            }
            f4 = this._a(this._a, n, n2 - 1, n3);
            f5 = (this._z + this._y + this._B + f4) / 4.0f;
            f8 = (this._B + f4 + this._E + this._D) / 4.0f;
            f7 = (f4 + this._A + this._D + this._C) / 4.0f;
            f6 = (this._y + this._x + f4 + this._A) / 4.0f;
            this.__al = this._a(this._T, this._S, this._V, n4);
            this.__ao = this._a(this._V, this._Y, this._X, n4);
            this.__an = this._a(this._U, this._X, this._W, n4);
            this.__am = this._a(this._S, this._R, this._U, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            if (bl9) {
                this.__ar = this.__as = f * 0.5f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.5f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.5f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.5f;
                this.__ar = 0.5f;
                this.__aq = 0.5f;
                this.__ap = 0.5f;
                this.__aw = 0.5f;
                this.__av = 0.5f;
                this.__au = 0.5f;
                this.__at = 0.5f;
                this.__aA = 0.5f;
                this.__az = 0.5f;
                this.__ay = 0.5f;
                this.__ax = 0.5f;
            }
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            this._a(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 0));
            bl8 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2 + 1, n3, 1)) {
            if (this._k >= 1.0) {
                ++n2;
            }
            this.__aa = twgu2.func_71874_e(this._a, n - 1, n2, n3);
            this.__ae = twgu2.func_71874_e(this._a, n + 1, n2, n3);
            this.__ac = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
            this.__af = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
            this._G = this._a(this._a, n - 1, n2, n3);
            this._K = this._a(this._a, n + 1, n2, n3);
            this._I = this._a(this._a, n, n2, n3 - 1);
            this._L = this._a(this._a, n, n2, n3 + 1);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 + 1, n3)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 + 1, n3)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 + 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 - 1)];
            if (!bl && !bl3) {
                this._F = this._G;
                this._Z = this.__aa;
            } else {
                this._F = this._a(this._a, n - 1, n2, n3 - 1);
                this._Z = twgu2.func_71874_e(this._a, n - 1, n2, n3 - 1);
            }
            if (!bl && !bl4) {
                this._J = this._K;
                this.__ad = this.__ae;
            } else {
                this._J = this._a(this._a, n + 1, n2, n3 - 1);
                this.__ad = twgu2.func_71874_e(this._a, n + 1, n2, n3 - 1);
            }
            if (!bl2 && !bl3) {
                this._H = this._G;
                this.__ab = this.__aa;
            } else {
                this._H = this._a(this._a, n - 1, n2, n3 + 1);
                this.__ab = twgu2.func_71874_e(this._a, n - 1, n2, n3 + 1);
            }
            if (!bl2 && !bl4) {
                this._M = this._K;
                this.__ag = this.__ae;
            } else {
                this._M = this._a(this._a, n + 1, n2, n3 + 1);
                this.__ag = twgu2.func_71874_e(this._a, n + 1, n2, n3 + 1);
            }
            if (this._k >= 1.0) {
                --n2;
            }
            if (n5 < 0) {
                n5 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._k >= 1.0 || !this._a.func_72804_r(n, n2 + 1, n3)) {
                n4 = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
            }
            f4 = this._a(this._a, n, n2 + 1, n3);
            f8 = (this._H + this._G + this._L + f4) / 4.0f;
            f5 = (this._L + f4 + this._M + this._K) / 4.0f;
            f6 = (f4 + this._I + this._K + this._J) / 4.0f;
            f7 = (this._G + this._F + f4 + this._I) / 4.0f;
            this.__ao = this._a(this.__ab, this.__aa, this.__af, n4);
            this.__al = this._a(this.__af, this.__ag, this.__ae, n4);
            this.__am = this._a(this.__ac, this.__ae, this.__ad, n4);
            this.__an = this._a(this.__aa, this._Z, this.__ac, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            this.__ar = this.__as = f;
            this.__aq = this.__as;
            this.__ap = this.__as;
            this.__av = this.__aw = f2;
            this.__au = this.__aw;
            this.__at = this.__aw;
            this.__az = this.__aA = f3;
            this.__ay = this.__aA;
            this.__ax = this.__aA;
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            this._b(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 1));
            bl8 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2, n3 - 1, 2)) {
            if (this._l <= 0.0) {
                --n3;
            }
            this._N = this._a(this._a, n - 1, n2, n3);
            this._A = this._a(this._a, n, n2 - 1, n3);
            this._I = this._a(this._a, n, n2 + 1, n3);
            this._O = this._a(this._a, n + 1, n2, n3);
            this.__ah = twgu2.func_71874_e(this._a, n - 1, n2, n3);
            this._U = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
            this.__ac = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
            this.__ai = twgu2.func_71874_e(this._a, n + 1, n2, n3);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 - 1)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 - 1)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 - 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 - 1)];
            if (!bl3 && !bl) {
                this._x = this._N;
                this._R = this.__ah;
            } else {
                this._x = this._a(this._a, n - 1, n2 - 1, n3);
                this._R = twgu2.func_71874_e(this._a, n - 1, n2 - 1, n3);
            }
            if (!bl3 && !bl2) {
                this._F = this._N;
                this._Z = this.__ah;
            } else {
                this._F = this._a(this._a, n - 1, n2 + 1, n3);
                this._Z = twgu2.func_71874_e(this._a, n - 1, n2 + 1, n3);
            }
            if (!bl4 && !bl) {
                this._C = this._O;
                this._W = this.__ai;
            } else {
                this._C = this._a(this._a, n + 1, n2 - 1, n3);
                this._W = twgu2.func_71874_e(this._a, n + 1, n2 - 1, n3);
            }
            if (!bl4 && !bl2) {
                this._J = this._O;
                this.__ad = this.__ai;
            } else {
                this._J = this._a(this._a, n + 1, n2 + 1, n3);
                this.__ad = twgu2.func_71874_e(this._a, n + 1, n2 + 1, n3);
            }
            if (this._l <= 0.0) {
                ++n3;
            }
            if (n5 < 0) {
                n5 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._l <= 0.0 || !this._a.func_72804_r(n, n2, n3 - 1)) {
                n4 = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
            }
            f4 = this._a(this._a, n, n2, n3 - 1);
            f5 = (this._N + this._F + f4 + this._I) / 4.0f;
            f6 = (f4 + this._I + this._O + this._J) / 4.0f;
            f7 = (this._A + f4 + this._C + this._O) / 4.0f;
            f8 = (this._x + this._N + this._A + f4) / 4.0f;
            this.__al = this._a(this.__ah, this._Z, this.__ac, n4);
            this.__am = this._a(this.__ac, this.__ai, this.__ad, n4);
            this.__an = this._a(this._U, this._W, this.__ai, n4);
            this.__ao = this._a(this._R, this.__ah, this._U, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            if (bl9) {
                this.__ar = this.__as = f * 0.8f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.8f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.8f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.8f;
                this.__ar = 0.8f;
                this.__aq = 0.8f;
                this.__ap = 0.8f;
                this.__aw = 0.8f;
                this.__av = 0.8f;
                this.__au = 0.8f;
                this.__at = 0.8f;
                this.__aA = 0.8f;
                this.__az = 0.8f;
                this.__ay = 0.8f;
                this.__ax = 0.8f;
            }
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 2);
            if (bl6) {
                dwan2 = this._a(dwan2, n, n2, n3, 2, f, f2, f3);
            }
            this._c(twgu2, (double)n, (double)n2, (double)n3, dwan2);
            if (bl5 && _e && dwan2 == TextureUtils.iconGrassSide && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._c(twgu2, (double)n, (double)n2, (double)n3, jzmk._a());
            }
            bl8 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2, n3 + 1, 3)) {
            if (this._m >= 1.0) {
                ++n3;
            }
            this._P = this._a(this._a, n - 1, n2, n3);
            this._Q = this._a(this._a, n + 1, n2, n3);
            this._B = this._a(this._a, n, n2 - 1, n3);
            this._L = this._a(this._a, n, n2 + 1, n3);
            this.__aj = twgu2.func_71874_e(this._a, n - 1, n2, n3);
            this.__ak = twgu2.func_71874_e(this._a, n + 1, n2, n3);
            this._V = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
            this.__af = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 + 1)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 + 1)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 + 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 + 1)];
            if (!bl3 && !bl) {
                this._z = this._P;
                this._T = this.__aj;
            } else {
                this._z = this._a(this._a, n - 1, n2 - 1, n3);
                this._T = twgu2.func_71874_e(this._a, n - 1, n2 - 1, n3);
            }
            if (!bl3 && !bl2) {
                this._H = this._P;
                this.__ab = this.__aj;
            } else {
                this._H = this._a(this._a, n - 1, n2 + 1, n3);
                this.__ab = twgu2.func_71874_e(this._a, n - 1, n2 + 1, n3);
            }
            if (!bl4 && !bl) {
                this._E = this._Q;
                this._Y = this.__ak;
            } else {
                this._E = this._a(this._a, n + 1, n2 - 1, n3);
                this._Y = twgu2.func_71874_e(this._a, n + 1, n2 - 1, n3);
            }
            if (!bl4 && !bl2) {
                this._M = this._Q;
                this.__ag = this.__ak;
            } else {
                this._M = this._a(this._a, n + 1, n2 + 1, n3);
                this.__ag = twgu2.func_71874_e(this._a, n + 1, n2 + 1, n3);
            }
            if (this._m >= 1.0) {
                --n3;
            }
            if (n5 < 0) {
                n5 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._m >= 1.0 || !this._a.func_72804_r(n, n2, n3 + 1)) {
                n4 = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
            }
            f4 = this._a(this._a, n, n2, n3 + 1);
            f5 = (this._P + this._H + f4 + this._L) / 4.0f;
            f8 = (f4 + this._L + this._Q + this._M) / 4.0f;
            f7 = (this._B + f4 + this._E + this._Q) / 4.0f;
            f6 = (this._z + this._P + this._B + f4) / 4.0f;
            this.__al = this._a(this.__aj, this.__ab, this.__af, n4);
            this.__ao = this._a(this.__af, this.__ak, this.__ag, n4);
            this.__an = this._a(this._V, this._Y, this.__ak, n4);
            this.__am = this._a(this._T, this.__aj, this._V, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            if (bl9) {
                this.__ar = this.__as = f * 0.8f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.8f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.8f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.8f;
                this.__ar = 0.8f;
                this.__aq = 0.8f;
                this.__ap = 0.8f;
                this.__aw = 0.8f;
                this.__av = 0.8f;
                this.__au = 0.8f;
                this.__at = 0.8f;
                this.__aA = 0.8f;
                this.__az = 0.8f;
                this.__ay = 0.8f;
                this.__ax = 0.8f;
            }
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 3);
            if (bl6) {
                dwan2 = this._a(dwan2, n, n2, n3, 3, f, f2, f3);
            }
            this._d(twgu2, n, n2, n3, dwan2);
            if (bl5 && _e && dwan2 == TextureUtils.iconGrassSide && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._d(twgu2, n, n2, n3, jzmk._a());
            }
            bl8 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n - 1, n2, n3, 4)) {
            if (this._h <= 0.0) {
                --n;
            }
            this._y = this._a(this._a, n, n2 - 1, n3);
            this._N = this._a(this._a, n, n2, n3 - 1);
            this._P = this._a(this._a, n, n2, n3 + 1);
            this._G = this._a(this._a, n, n2 + 1, n3);
            this._S = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
            this.__ah = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
            this.__aj = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
            this.__aa = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 + 1, n3)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 - 1, n3)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 - 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 + 1)];
            if (!bl2 && !bl3) {
                this._x = this._N;
                this._R = this.__ah;
            } else {
                this._x = this._a(this._a, n, n2 - 1, n3 - 1);
                this._R = twgu2.func_71874_e(this._a, n, n2 - 1, n3 - 1);
            }
            if (!bl && !bl3) {
                this._z = this._P;
                this._T = this.__aj;
            } else {
                this._z = this._a(this._a, n, n2 - 1, n3 + 1);
                this._T = twgu2.func_71874_e(this._a, n, n2 - 1, n3 + 1);
            }
            if (!bl2 && !bl4) {
                this._F = this._N;
                this._Z = this.__ah;
            } else {
                this._F = this._a(this._a, n, n2 + 1, n3 - 1);
                this._Z = twgu2.func_71874_e(this._a, n, n2 + 1, n3 - 1);
            }
            if (!bl && !bl4) {
                this._H = this._P;
                this.__ab = this.__aj;
            } else {
                this._H = this._a(this._a, n, n2 + 1, n3 + 1);
                this.__ab = twgu2.func_71874_e(this._a, n, n2 + 1, n3 + 1);
            }
            if (this._h <= 0.0) {
                ++n;
            }
            if (n5 < 0) {
                n5 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._h <= 0.0 || !this._a.func_72804_r(n - 1, n2, n3)) {
                n4 = twgu2.func_71874_e(this._a, n - 1, n2, n3);
            }
            f4 = this._a(this._a, n - 1, n2, n3);
            f8 = (this._y + this._z + f4 + this._P) / 4.0f;
            f5 = (f4 + this._P + this._G + this._H) / 4.0f;
            f6 = (this._N + f4 + this._F + this._G) / 4.0f;
            f7 = (this._x + this._y + this._N + f4) / 4.0f;
            this.__ao = this._a(this._S, this._T, this.__aj, n4);
            this.__al = this._a(this.__aj, this.__aa, this.__ab, n4);
            this.__am = this._a(this.__ah, this._Z, this.__aa, n4);
            this.__an = this._a(this._R, this._S, this.__ah, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            if (bl9) {
                this.__ar = this.__as = f * 0.6f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.6f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.6f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.6f;
                this.__ar = 0.6f;
                this.__aq = 0.6f;
                this.__ap = 0.6f;
                this.__aw = 0.6f;
                this.__av = 0.6f;
                this.__au = 0.6f;
                this.__at = 0.6f;
                this.__aA = 0.6f;
                this.__az = 0.6f;
                this.__ay = 0.6f;
                this.__ax = 0.6f;
            }
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 4);
            if (bl6) {
                dwan2 = this._a(dwan2, n, n2, n3, 4, f, f2, f3);
            }
            this._e(twgu2, n, n2, n3, dwan2);
            if (bl5 && _e && dwan2 == TextureUtils.iconGrassSide && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._e(twgu2, n, n2, n3, jzmk._a());
            }
            bl8 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n + 1, n2, n3, 5)) {
            if (this._i >= 1.0) {
                ++n;
            }
            this._D = this._a(this._a, n, n2 - 1, n3);
            this._O = this._a(this._a, n, n2, n3 - 1);
            this._Q = this._a(this._a, n, n2, n3 + 1);
            this._K = this._a(this._a, n, n2 + 1, n3);
            this._X = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
            this.__ai = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
            this.__ak = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
            this.__ae = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 + 1, n3)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 - 1, n3)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 + 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 - 1)];
            if (!bl3 && !bl) {
                this._C = this._O;
                this._W = this.__ai;
            } else {
                this._C = this._a(this._a, n, n2 - 1, n3 - 1);
                this._W = twgu2.func_71874_e(this._a, n, n2 - 1, n3 - 1);
            }
            if (!bl3 && !bl2) {
                this._E = this._Q;
                this._Y = this.__ak;
            } else {
                this._E = this._a(this._a, n, n2 - 1, n3 + 1);
                this._Y = twgu2.func_71874_e(this._a, n, n2 - 1, n3 + 1);
            }
            if (!bl4 && !bl) {
                this._J = this._O;
                this.__ad = this.__ai;
            } else {
                this._J = this._a(this._a, n, n2 + 1, n3 - 1);
                this.__ad = twgu2.func_71874_e(this._a, n, n2 + 1, n3 - 1);
            }
            if (!bl4 && !bl2) {
                this._M = this._Q;
                this.__ag = this.__ak;
            } else {
                this._M = this._a(this._a, n, n2 + 1, n3 + 1);
                this.__ag = twgu2.func_71874_e(this._a, n, n2 + 1, n3 + 1);
            }
            if (this._i >= 1.0) {
                --n;
            }
            if (n5 < 0) {
                n5 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._i >= 1.0 || !this._a.func_72804_r(n + 1, n2, n3)) {
                n4 = twgu2.func_71874_e(this._a, n + 1, n2, n3);
            }
            f4 = this._a(this._a, n + 1, n2, n3);
            f5 = (this._D + this._E + f4 + this._Q) / 4.0f;
            f6 = (this._C + this._D + this._O + f4) / 4.0f;
            f7 = (this._O + f4 + this._J + this._K) / 4.0f;
            f8 = (f4 + this._Q + this._K + this._M) / 4.0f;
            this.__al = this._a(this._X, this._Y, this.__ak, n4);
            this.__ao = this._a(this.__ak, this.__ae, this.__ag, n4);
            this.__an = this._a(this.__ai, this.__ad, this.__ae, n4);
            this.__am = this._a(this._W, this._X, this.__ai, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            if (bl9) {
                this.__ar = this.__as = f * 0.6f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.6f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.6f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.6f;
                this.__ar = 0.6f;
                this.__aq = 0.6f;
                this.__ap = 0.6f;
                this.__aw = 0.6f;
                this.__av = 0.6f;
                this.__au = 0.6f;
                this.__at = 0.6f;
                this.__aA = 0.6f;
                this.__az = 0.6f;
                this.__ay = 0.6f;
                this.__ax = 0.6f;
            }
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 5);
            if (bl6) {
                dwan2 = this._a(dwan2, n, n2, n3, 5, f, f2, f3);
            }
            this._f(twgu2, n, n2, n3, dwan2);
            if (bl5 && _e && dwan2 == TextureUtils.iconGrassSide && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._f(twgu2, n, n2, n3, jzmk._a());
            }
            bl8 = true;
        }
        this._w = false;
        return bl8;
    }

    public boolean _b(twgu twgu2, int n, int n2, int n3, float f, float f2, float f3) {
        dwan dwan2;
        int n4;
        int n5;
        int n6;
        int n7;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        int n8;
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        this._w = true;
        boolean bl5 = false;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        boolean bl6 = true;
        int n9 = twgu2.func_71874_e(this._a, n, n2, n3);
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(983055);
        if (twgu2 == twgu.field_71980_u) {
            bl6 = false;
        } else if (this._b()) {
            bl6 = false;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2 - 1, n3, 0)) {
            if (this._j <= 0.0) {
                --n2;
            }
            this._S = twgu2.func_71874_e(this._a, n - 1, n2, n3);
            this._U = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
            this._V = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
            this._X = twgu2.func_71874_e(this._a, n + 1, n2, n3);
            this._y = this._a(this._a, n - 1, n2, n3);
            this._A = this._a(this._a, n, n2, n3 - 1);
            this._B = this._a(this._a, n, n2, n3 + 1);
            this._D = this._a(this._a, n + 1, n2, n3);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 - 1, n3)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 - 1, n3)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 + 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 - 1)];
            if (!bl && !bl3) {
                this._x = this._y;
                this._R = this._S;
            } else {
                this._x = this._a(this._a, n - 1, n2, n3 - 1);
                this._R = twgu2.func_71874_e(this._a, n - 1, n2, n3 - 1);
            }
            if (!bl2 && !bl3) {
                this._z = this._y;
                this._T = this._S;
            } else {
                this._z = this._a(this._a, n - 1, n2, n3 + 1);
                this._T = twgu2.func_71874_e(this._a, n - 1, n2, n3 + 1);
            }
            if (!bl && !bl4) {
                this._C = this._D;
                this._W = this._X;
            } else {
                this._C = this._a(this._a, n + 1, n2, n3 - 1);
                this._W = twgu2.func_71874_e(this._a, n + 1, n2, n3 - 1);
            }
            if (!bl2 && !bl4) {
                this._E = this._D;
                this._Y = this._X;
            } else {
                this._E = this._a(this._a, n + 1, n2, n3 + 1);
                this._Y = twgu2.func_71874_e(this._a, n + 1, n2, n3 + 1);
            }
            if (this._j <= 0.0) {
                ++n2;
            }
            n8 = n9;
            if (this._j <= 0.0 || !this._a.func_72804_r(n, n2 - 1, n3)) {
                n8 = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
            }
            f8 = this._a(this._a, n, n2 - 1, n3);
            f9 = (this._z + this._y + this._B + f8) / 4.0f;
            f12 = (this._B + f8 + this._E + this._D) / 4.0f;
            f11 = (f8 + this._A + this._D + this._C) / 4.0f;
            f10 = (this._y + this._x + f8 + this._A) / 4.0f;
            this.__al = this._a(this._T, this._S, this._V, n8);
            this.__ao = this._a(this._V, this._Y, this._X, n8);
            this.__an = this._a(this._U, this._X, this._W, n8);
            this.__am = this._a(this._S, this._R, this._U, n8);
            if (bl6) {
                this.__ar = this.__as = f * 0.5f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.5f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.5f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.5f;
                this.__ar = 0.5f;
                this.__aq = 0.5f;
                this.__ap = 0.5f;
                this.__aw = 0.5f;
                this.__av = 0.5f;
                this.__au = 0.5f;
                this.__at = 0.5f;
                this.__aA = 0.5f;
                this.__az = 0.5f;
                this.__ay = 0.5f;
                this.__ax = 0.5f;
            }
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            this._a(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 0));
            bl5 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2 + 1, n3, 1)) {
            if (this._k >= 1.0) {
                ++n2;
            }
            this.__aa = twgu2.func_71874_e(this._a, n - 1, n2, n3);
            this.__ae = twgu2.func_71874_e(this._a, n + 1, n2, n3);
            this.__ac = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
            this.__af = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
            this._G = this._a(this._a, n - 1, n2, n3);
            this._K = this._a(this._a, n + 1, n2, n3);
            this._I = this._a(this._a, n, n2, n3 - 1);
            this._L = this._a(this._a, n, n2, n3 + 1);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 + 1, n3)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 + 1, n3)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 + 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 - 1)];
            if (!bl && !bl3) {
                this._F = this._G;
                this._Z = this.__aa;
            } else {
                this._F = this._a(this._a, n - 1, n2, n3 - 1);
                this._Z = twgu2.func_71874_e(this._a, n - 1, n2, n3 - 1);
            }
            if (!bl && !bl4) {
                this._J = this._K;
                this.__ad = this.__ae;
            } else {
                this._J = this._a(this._a, n + 1, n2, n3 - 1);
                this.__ad = twgu2.func_71874_e(this._a, n + 1, n2, n3 - 1);
            }
            if (!bl2 && !bl3) {
                this._H = this._G;
                this.__ab = this.__aa;
            } else {
                this._H = this._a(this._a, n - 1, n2, n3 + 1);
                this.__ab = twgu2.func_71874_e(this._a, n - 1, n2, n3 + 1);
            }
            if (!bl2 && !bl4) {
                this._M = this._K;
                this.__ag = this.__ae;
            } else {
                this._M = this._a(this._a, n + 1, n2, n3 + 1);
                this.__ag = twgu2.func_71874_e(this._a, n + 1, n2, n3 + 1);
            }
            if (this._k >= 1.0) {
                --n2;
            }
            n8 = n9;
            if (this._k >= 1.0 || !this._a.func_72804_r(n, n2 + 1, n3)) {
                n8 = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
            }
            f8 = this._a(this._a, n, n2 + 1, n3);
            f12 = (this._H + this._G + this._L + f8) / 4.0f;
            f9 = (this._L + f8 + this._M + this._K) / 4.0f;
            f10 = (f8 + this._I + this._K + this._J) / 4.0f;
            f11 = (this._G + this._F + f8 + this._I) / 4.0f;
            this.__ao = this._a(this.__ab, this.__aa, this.__af, n8);
            this.__al = this._a(this.__af, this.__ag, this.__ae, n8);
            this.__am = this._a(this.__ac, this.__ae, this.__ad, n8);
            this.__an = this._a(this.__aa, this._Z, this.__ac, n8);
            this.__ar = this.__as = f;
            this.__aq = this.__as;
            this.__ap = this.__as;
            this.__av = this.__aw = f2;
            this.__au = this.__aw;
            this.__at = this.__aw;
            this.__az = this.__aA = f3;
            this.__ay = this.__aA;
            this.__ax = this.__aA;
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            this._b(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 1));
            bl5 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2, n3 - 1, 2)) {
            if (this._l <= 0.0) {
                --n3;
            }
            this._N = this._a(this._a, n - 1, n2, n3);
            this._A = this._a(this._a, n, n2 - 1, n3);
            this._I = this._a(this._a, n, n2 + 1, n3);
            this._O = this._a(this._a, n + 1, n2, n3);
            this.__ah = twgu2.func_71874_e(this._a, n - 1, n2, n3);
            this._U = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
            this.__ac = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
            this.__ai = twgu2.func_71874_e(this._a, n + 1, n2, n3);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 - 1)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 - 1)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 - 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 - 1)];
            if (!bl3 && !bl) {
                this._x = this._N;
                this._R = this.__ah;
            } else {
                this._x = this._a(this._a, n - 1, n2 - 1, n3);
                this._R = twgu2.func_71874_e(this._a, n - 1, n2 - 1, n3);
            }
            if (!bl3 && !bl2) {
                this._F = this._N;
                this._Z = this.__ah;
            } else {
                this._F = this._a(this._a, n - 1, n2 + 1, n3);
                this._Z = twgu2.func_71874_e(this._a, n - 1, n2 + 1, n3);
            }
            if (!bl4 && !bl) {
                this._C = this._O;
                this._W = this.__ai;
            } else {
                this._C = this._a(this._a, n + 1, n2 - 1, n3);
                this._W = twgu2.func_71874_e(this._a, n + 1, n2 - 1, n3);
            }
            if (!bl4 && !bl2) {
                this._J = this._O;
                this.__ad = this.__ai;
            } else {
                this._J = this._a(this._a, n + 1, n2 + 1, n3);
                this.__ad = twgu2.func_71874_e(this._a, n + 1, n2 + 1, n3);
            }
            if (this._l <= 0.0) {
                ++n3;
            }
            n8 = n9;
            if (this._l <= 0.0 || !this._a.func_72804_r(n, n2, n3 - 1)) {
                n8 = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
            }
            f8 = this._a(this._a, n, n2, n3 - 1);
            f7 = (this._N + this._F + f8 + this._I) / 4.0f;
            f6 = (f8 + this._I + this._O + this._J) / 4.0f;
            f5 = (this._A + f8 + this._C + this._O) / 4.0f;
            f4 = (this._x + this._N + this._A + f8) / 4.0f;
            f9 = (float)((double)f7 * this._k * (1.0 - this._h) + (double)f6 * this._j * this._h + (double)f5 * (1.0 - this._k) * this._h + (double)f4 * (1.0 - this._k) * (1.0 - this._h));
            f10 = (float)((double)f7 * this._k * (1.0 - this._i) + (double)f6 * this._k * this._i + (double)f5 * (1.0 - this._k) * this._i + (double)f4 * (1.0 - this._k) * (1.0 - this._i));
            f11 = (float)((double)f7 * this._j * (1.0 - this._i) + (double)f6 * this._j * this._i + (double)f5 * (1.0 - this._j) * this._i + (double)f4 * (1.0 - this._j) * (1.0 - this._i));
            f12 = (float)((double)f7 * this._j * (1.0 - this._h) + (double)f6 * this._j * this._h + (double)f5 * (1.0 - this._j) * this._h + (double)f4 * (1.0 - this._j) * (1.0 - this._h));
            n7 = this._a(this.__ah, this._Z, this.__ac, n8);
            n6 = this._a(this.__ac, this.__ai, this.__ad, n8);
            n5 = this._a(this._U, this._W, this.__ai, n8);
            n4 = this._a(this._R, this.__ah, this._U, n8);
            this.__al = this._a(n7, n6, n5, n4, this._k * (1.0 - this._h), this._k * this._h, (1.0 - this._k) * this._h, (1.0 - this._k) * (1.0 - this._h));
            this.__am = this._a(n7, n6, n5, n4, this._k * (1.0 - this._i), this._k * this._i, (1.0 - this._k) * this._i, (1.0 - this._k) * (1.0 - this._i));
            this.__an = this._a(n7, n6, n5, n4, this._j * (1.0 - this._i), this._j * this._i, (1.0 - this._j) * this._i, (1.0 - this._j) * (1.0 - this._i));
            this.__ao = this._a(n7, n6, n5, n4, this._j * (1.0 - this._h), this._j * this._h, (1.0 - this._j) * this._h, (1.0 - this._j) * (1.0 - this._h));
            if (bl6) {
                this.__ar = this.__as = f * 0.8f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.8f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.8f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.8f;
                this.__ar = 0.8f;
                this.__aq = 0.8f;
                this.__ap = 0.8f;
                this.__aw = 0.8f;
                this.__av = 0.8f;
                this.__au = 0.8f;
                this.__at = 0.8f;
                this.__aA = 0.8f;
                this.__az = 0.8f;
                this.__ay = 0.8f;
                this.__ax = 0.8f;
            }
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 2);
            this._c(twgu2, (double)n, (double)n2, (double)n3, dwan2);
            if (_e && dwan2.func_94215_i().equals("grass_side") && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._c(twgu2, (double)n, (double)n2, (double)n3, jzmk._a());
            }
            bl5 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2, n3 + 1, 3)) {
            if (this._m >= 1.0) {
                ++n3;
            }
            this._P = this._a(this._a, n - 1, n2, n3);
            this._Q = this._a(this._a, n + 1, n2, n3);
            this._B = this._a(this._a, n, n2 - 1, n3);
            this._L = this._a(this._a, n, n2 + 1, n3);
            this.__aj = twgu2.func_71874_e(this._a, n - 1, n2, n3);
            this.__ak = twgu2.func_71874_e(this._a, n + 1, n2, n3);
            this._V = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
            this.__af = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 + 1)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 + 1)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n, n2 + 1, n3 + 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n, n2 - 1, n3 + 1)];
            if (!bl3 && !bl) {
                this._z = this._P;
                this._T = this.__aj;
            } else {
                this._z = this._a(this._a, n - 1, n2 - 1, n3);
                this._T = twgu2.func_71874_e(this._a, n - 1, n2 - 1, n3);
            }
            if (!bl3 && !bl2) {
                this._H = this._P;
                this.__ab = this.__aj;
            } else {
                this._H = this._a(this._a, n - 1, n2 + 1, n3);
                this.__ab = twgu2.func_71874_e(this._a, n - 1, n2 + 1, n3);
            }
            if (!bl4 && !bl) {
                this._E = this._Q;
                this._Y = this.__ak;
            } else {
                this._E = this._a(this._a, n + 1, n2 - 1, n3);
                this._Y = twgu2.func_71874_e(this._a, n + 1, n2 - 1, n3);
            }
            if (!bl4 && !bl2) {
                this._M = this._Q;
                this.__ag = this.__ak;
            } else {
                this._M = this._a(this._a, n + 1, n2 + 1, n3);
                this.__ag = twgu2.func_71874_e(this._a, n + 1, n2 + 1, n3);
            }
            if (this._m >= 1.0) {
                --n3;
            }
            n8 = n9;
            if (this._m >= 1.0 || !this._a.func_72804_r(n, n2, n3 + 1)) {
                n8 = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
            }
            f8 = this._a(this._a, n, n2, n3 + 1);
            f7 = (this._P + this._H + f8 + this._L) / 4.0f;
            f6 = (f8 + this._L + this._Q + this._M) / 4.0f;
            f5 = (this._B + f8 + this._E + this._Q) / 4.0f;
            f4 = (this._z + this._P + this._B + f8) / 4.0f;
            f9 = (float)((double)f7 * this._k * (1.0 - this._h) + (double)f6 * this._k * this._h + (double)f5 * (1.0 - this._k) * this._h + (double)f4 * (1.0 - this._k) * (1.0 - this._h));
            f10 = (float)((double)f7 * this._j * (1.0 - this._h) + (double)f6 * this._j * this._h + (double)f5 * (1.0 - this._j) * this._h + (double)f4 * (1.0 - this._j) * (1.0 - this._h));
            f11 = (float)((double)f7 * this._j * (1.0 - this._i) + (double)f6 * this._j * this._i + (double)f5 * (1.0 - this._j) * this._i + (double)f4 * (1.0 - this._j) * (1.0 - this._i));
            f12 = (float)((double)f7 * this._k * (1.0 - this._i) + (double)f6 * this._k * this._i + (double)f5 * (1.0 - this._k) * this._i + (double)f4 * (1.0 - this._k) * (1.0 - this._i));
            n7 = this._a(this.__aj, this.__ab, this.__af, n8);
            n6 = this._a(this.__af, this.__ak, this.__ag, n8);
            n5 = this._a(this._V, this._Y, this.__ak, n8);
            n4 = this._a(this._T, this.__aj, this._V, n8);
            this.__al = this._a(n7, n4, n5, n6, this._k * (1.0 - this._h), (1.0 - this._k) * (1.0 - this._h), (1.0 - this._k) * this._h, this._k * this._h);
            this.__am = this._a(n7, n4, n5, n6, this._j * (1.0 - this._h), (1.0 - this._j) * (1.0 - this._h), (1.0 - this._j) * this._h, this._j * this._h);
            this.__an = this._a(n7, n4, n5, n6, this._j * (1.0 - this._i), (1.0 - this._j) * (1.0 - this._i), (1.0 - this._j) * this._i, this._j * this._i);
            this.__ao = this._a(n7, n4, n5, n6, this._k * (1.0 - this._i), (1.0 - this._k) * (1.0 - this._i), (1.0 - this._k) * this._i, this._k * this._i);
            if (bl6) {
                this.__ar = this.__as = f * 0.8f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.8f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.8f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.8f;
                this.__ar = 0.8f;
                this.__aq = 0.8f;
                this.__ap = 0.8f;
                this.__aw = 0.8f;
                this.__av = 0.8f;
                this.__au = 0.8f;
                this.__at = 0.8f;
                this.__aA = 0.8f;
                this.__az = 0.8f;
                this.__ay = 0.8f;
                this.__ax = 0.8f;
            }
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 3);
            this._d(twgu2, n, n2, n3, dwan2);
            if (_e && dwan2.func_94215_i().equals("grass_side") && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._d(twgu2, n, n2, n3, jzmk._a());
            }
            bl5 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n - 1, n2, n3, 4)) {
            if (this._h <= 0.0) {
                --n;
            }
            this._y = this._a(this._a, n, n2 - 1, n3);
            this._N = this._a(this._a, n, n2, n3 - 1);
            this._P = this._a(this._a, n, n2, n3 + 1);
            this._G = this._a(this._a, n, n2 + 1, n3);
            this._S = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
            this.__ah = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
            this.__aj = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
            this.__aa = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 + 1, n3)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2 - 1, n3)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 - 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n - 1, n2, n3 + 1)];
            if (!bl2 && !bl3) {
                this._x = this._N;
                this._R = this.__ah;
            } else {
                this._x = this._a(this._a, n, n2 - 1, n3 - 1);
                this._R = twgu2.func_71874_e(this._a, n, n2 - 1, n3 - 1);
            }
            if (!bl && !bl3) {
                this._z = this._P;
                this._T = this.__aj;
            } else {
                this._z = this._a(this._a, n, n2 - 1, n3 + 1);
                this._T = twgu2.func_71874_e(this._a, n, n2 - 1, n3 + 1);
            }
            if (!bl2 && !bl4) {
                this._F = this._N;
                this._Z = this.__ah;
            } else {
                this._F = this._a(this._a, n, n2 + 1, n3 - 1);
                this._Z = twgu2.func_71874_e(this._a, n, n2 + 1, n3 - 1);
            }
            if (!bl && !bl4) {
                this._H = this._P;
                this.__ab = this.__aj;
            } else {
                this._H = this._a(this._a, n, n2 + 1, n3 + 1);
                this.__ab = twgu2.func_71874_e(this._a, n, n2 + 1, n3 + 1);
            }
            if (this._h <= 0.0) {
                ++n;
            }
            n8 = n9;
            if (this._h <= 0.0 || !this._a.func_72804_r(n - 1, n2, n3)) {
                n8 = twgu2.func_71874_e(this._a, n - 1, n2, n3);
            }
            f8 = this._a(this._a, n - 1, n2, n3);
            f7 = (this._y + this._z + f8 + this._P) / 4.0f;
            f6 = (f8 + this._P + this._G + this._H) / 4.0f;
            f5 = (this._N + f8 + this._F + this._G) / 4.0f;
            f4 = (this._x + this._y + this._N + f8) / 4.0f;
            f9 = (float)((double)f6 * this._k * this._m + (double)f5 * this._k * (1.0 - this._m) + (double)f4 * (1.0 - this._k) * (1.0 - this._m) + (double)f7 * (1.0 - this._k) * this._m);
            f10 = (float)((double)f6 * this._k * this._l + (double)f5 * this._k * (1.0 - this._l) + (double)f4 * (1.0 - this._k) * (1.0 - this._l) + (double)f7 * (1.0 - this._k) * this._l);
            f11 = (float)((double)f6 * this._j * this._l + (double)f5 * this._j * (1.0 - this._l) + (double)f4 * (1.0 - this._j) * (1.0 - this._l) + (double)f7 * (1.0 - this._j) * this._l);
            f12 = (float)((double)f6 * this._j * this._m + (double)f5 * this._j * (1.0 - this._m) + (double)f4 * (1.0 - this._j) * (1.0 - this._m) + (double)f7 * (1.0 - this._j) * this._m);
            n7 = this._a(this._S, this._T, this.__aj, n8);
            n6 = this._a(this.__aj, this.__aa, this.__ab, n8);
            n5 = this._a(this.__ah, this._Z, this.__aa, n8);
            n4 = this._a(this._R, this._S, this.__ah, n8);
            this.__al = this._a(n6, n5, n4, n7, this._k * this._m, this._k * (1.0 - this._m), (1.0 - this._k) * (1.0 - this._m), (1.0 - this._k) * this._m);
            this.__am = this._a(n6, n5, n4, n7, this._k * this._l, this._k * (1.0 - this._l), (1.0 - this._k) * (1.0 - this._l), (1.0 - this._k) * this._l);
            this.__an = this._a(n6, n5, n4, n7, this._j * this._l, this._j * (1.0 - this._l), (1.0 - this._j) * (1.0 - this._l), (1.0 - this._j) * this._l);
            this.__ao = this._a(n6, n5, n4, n7, this._j * this._m, this._j * (1.0 - this._m), (1.0 - this._j) * (1.0 - this._m), (1.0 - this._j) * this._m);
            if (bl6) {
                this.__ar = this.__as = f * 0.6f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.6f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.6f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.6f;
                this.__ar = 0.6f;
                this.__aq = 0.6f;
                this.__ap = 0.6f;
                this.__aw = 0.6f;
                this.__av = 0.6f;
                this.__au = 0.6f;
                this.__at = 0.6f;
                this.__aA = 0.6f;
                this.__az = 0.6f;
                this.__ay = 0.6f;
                this.__ax = 0.6f;
            }
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 4);
            this._e(twgu2, n, n2, n3, dwan2);
            if (_e && dwan2.func_94215_i().equals("grass_side") && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._e(twgu2, n, n2, n3, jzmk._a());
            }
            bl5 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n + 1, n2, n3, 5)) {
            if (this._i >= 1.0) {
                ++n;
            }
            this._D = this._a(this._a, n, n2 - 1, n3);
            this._O = this._a(this._a, n, n2, n3 - 1);
            this._Q = this._a(this._a, n, n2, n3 + 1);
            this._K = this._a(this._a, n, n2 + 1, n3);
            this._X = twgu2.func_71874_e(this._a, n, n2 - 1, n3);
            this.__ai = twgu2.func_71874_e(this._a, n, n2, n3 - 1);
            this.__ak = twgu2.func_71874_e(this._a, n, n2, n3 + 1);
            this.__ae = twgu2.func_71874_e(this._a, n, n2 + 1, n3);
            bl4 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 + 1, n3)];
            bl3 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2 - 1, n3)];
            bl2 = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 + 1)];
            bl = twgu.field_71985_p[this._a.func_72798_a(n + 1, n2, n3 - 1)];
            if (!bl3 && !bl) {
                this._C = this._O;
                this._W = this.__ai;
            } else {
                this._C = this._a(this._a, n, n2 - 1, n3 - 1);
                this._W = twgu2.func_71874_e(this._a, n, n2 - 1, n3 - 1);
            }
            if (!bl3 && !bl2) {
                this._E = this._Q;
                this._Y = this.__ak;
            } else {
                this._E = this._a(this._a, n, n2 - 1, n3 + 1);
                this._Y = twgu2.func_71874_e(this._a, n, n2 - 1, n3 + 1);
            }
            if (!bl4 && !bl) {
                this._J = this._O;
                this.__ad = this.__ai;
            } else {
                this._J = this._a(this._a, n, n2 + 1, n3 - 1);
                this.__ad = twgu2.func_71874_e(this._a, n, n2 + 1, n3 - 1);
            }
            if (!bl4 && !bl2) {
                this._M = this._Q;
                this.__ag = this.__ak;
            } else {
                this._M = this._a(this._a, n, n2 + 1, n3 + 1);
                this.__ag = twgu2.func_71874_e(this._a, n, n2 + 1, n3 + 1);
            }
            if (this._i >= 1.0) {
                --n;
            }
            n8 = n9;
            if (this._i >= 1.0 || !this._a.func_72804_r(n + 1, n2, n3)) {
                n8 = twgu2.func_71874_e(this._a, n + 1, n2, n3);
            }
            f8 = this._a(this._a, n + 1, n2, n3);
            f7 = (this._D + this._E + f8 + this._Q) / 4.0f;
            f6 = (this._C + this._D + this._O + f8) / 4.0f;
            f5 = (this._O + f8 + this._J + this._K) / 4.0f;
            f4 = (f8 + this._Q + this._K + this._M) / 4.0f;
            f9 = (float)((double)f7 * (1.0 - this._j) * this._m + (double)f6 * (1.0 - this._j) * (1.0 - this._m) + (double)f5 * this._j * (1.0 - this._m) + (double)f4 * this._j * this._m);
            f10 = (float)((double)f7 * (1.0 - this._j) * this._l + (double)f6 * (1.0 - this._j) * (1.0 - this._l) + (double)f5 * this._j * (1.0 - this._l) + (double)f4 * this._j * this._l);
            f11 = (float)((double)f7 * (1.0 - this._k) * this._l + (double)f6 * (1.0 - this._k) * (1.0 - this._l) + (double)f5 * this._k * (1.0 - this._l) + (double)f4 * this._k * this._l);
            f12 = (float)((double)f7 * (1.0 - this._k) * this._m + (double)f6 * (1.0 - this._k) * (1.0 - this._m) + (double)f5 * this._k * (1.0 - this._m) + (double)f4 * this._k * this._m);
            n7 = this._a(this._X, this._Y, this.__ak, n8);
            n6 = this._a(this.__ak, this.__ae, this.__ag, n8);
            n5 = this._a(this.__ai, this.__ad, this.__ae, n8);
            n4 = this._a(this._W, this._X, this.__ai, n8);
            this.__al = this._a(n7, n4, n5, n6, (1.0 - this._j) * this._m, (1.0 - this._j) * (1.0 - this._m), this._j * (1.0 - this._m), this._j * this._m);
            this.__am = this._a(n7, n4, n5, n6, (1.0 - this._j) * this._l, (1.0 - this._j) * (1.0 - this._l), this._j * (1.0 - this._l), this._j * this._l);
            this.__an = this._a(n7, n4, n5, n6, (1.0 - this._k) * this._l, (1.0 - this._k) * (1.0 - this._l), this._k * (1.0 - this._l), this._k * this._l);
            this.__ao = this._a(n7, n4, n5, n6, (1.0 - this._k) * this._m, (1.0 - this._k) * (1.0 - this._m), this._k * (1.0 - this._m), this._k * this._m);
            if (bl6) {
                this.__ar = this.__as = f * 0.6f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.6f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.6f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.6f;
                this.__ar = 0.6f;
                this.__aq = 0.6f;
                this.__ap = 0.6f;
                this.__aw = 0.6f;
                this.__av = 0.6f;
                this.__au = 0.6f;
                this.__at = 0.6f;
                this.__aA = 0.6f;
                this.__az = 0.6f;
                this.__ay = 0.6f;
                this.__ax = 0.6f;
            }
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 5);
            this._f(twgu2, n, n2, n3, dwan2);
            if (_e && dwan2.func_94215_i().equals("grass_side") && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._f(twgu2, n, n2, n3, jzmk._a());
            }
            bl5 = true;
        }
        this._w = false;
        return bl5;
    }

    public int _a(int n, int n2, int n3, int n4) {
        if (n == 0) {
            n = n4;
        }
        if (n2 == 0) {
            n2 = n4;
        }
        if (n3 == 0) {
            n3 = n4;
        }
        return n + n2 + n3 + n4 >> 2 & 0xFF00FF;
    }

    public int _a(int n, int n2, int n3, int n4, double d, double d2, double d3, double d4) {
        int n5 = (int)((double)(n >> 16 & 0xFF) * d + (double)(n2 >> 16 & 0xFF) * d2 + (double)(n3 >> 16 & 0xFF) * d3 + (double)(n4 >> 16 & 0xFF) * d4) & 0xFF;
        int n6 = (int)((double)(n & 0xFF) * d + (double)(n2 & 0xFF) * d2 + (double)(n3 & 0xFF) * d3 + (double)(n4 & 0xFF) * d4) & 0xFF;
        return n5 << 16 | n6;
    }

    public boolean _c(twgu twgu2, int n, int n2, int n3, float f, float f2, float f3) {
        dwan dwan2;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        this._w = false;
        boolean bl = this.__aF.defaultTexture;
        boolean bl2 = Config.isBetterGrass() && bl;
        htvf htvf2 = this.__aF;
        boolean bl3 = false;
        int n4 = -1;
        if (this._d || twgu2.func_71877_c(this._a, n, n2 - 1, n3, 0)) {
            if (n4 < 0) {
                n4 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            f7 = f8 = 0.5f;
            f6 = f8;
            f5 = f8;
            if (twgu2 != twgu.field_71980_u) {
                f7 = f8 * f;
                f6 = f8 * f2;
                f5 = f8 * f3;
            }
            htvf2.func_78380_c(this._j > 0.0 ? n4 : twgu2.func_71874_e(this._a, n, n2 - 1, n3));
            htvf2.func_78386_a(f7, f6, f5);
            this._a(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 0));
            bl3 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2 + 1, n3, 1)) {
            if (n4 < 0) {
                n4 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            f8 = 1.0f;
            f7 = f8 * f;
            f6 = f8 * f2;
            f5 = f8 * f3;
            htvf2.func_78380_c(this._k < 1.0 ? n4 : twgu2.func_71874_e(this._a, n, n2 + 1, n3));
            htvf2.func_78386_a(f7, f6, f5);
            this._b(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 1));
            bl3 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2, n3 - 1, 2)) {
            if (n4 < 0) {
                n4 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            f6 = f7 = 0.8f;
            f5 = f7;
            f4 = f7;
            if (twgu2 != twgu.field_71980_u) {
                f6 = f7 * f;
                f5 = f7 * f2;
                f4 = f7 * f3;
            }
            htvf2.func_78380_c(this._l > 0.0 ? n4 : twgu2.func_71874_e(this._a, n, n2, n3 - 1));
            htvf2.func_78386_a(f6, f5, f4);
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 2);
            if (bl2) {
                if ((dwan2 == TextureUtils.iconGrassSide || dwan2 == TextureUtils.iconMyceliumSide) && (dwan2 = Config.getSideGrassTexture(this._a, n, n2, n3, 2, dwan2)) == TextureUtils.iconGrassTop) {
                    htvf2.func_78386_a(f6 * f, f5 * f2, f4 * f3);
                }
                if (dwan2 == TextureUtils.iconGrassSideSnowed) {
                    dwan2 = Config.getSideSnowGrassTexture(this._a, n, n2, n3, 2);
                }
            }
            this._c(twgu2, (double)n, (double)n2, (double)n3, dwan2);
            if (bl && _e && dwan2 == TextureUtils.iconGrassSide && !this._b()) {
                htvf2.func_78386_a(f6 * f, f5 * f2, f4 * f3);
                this._c(twgu2, (double)n, (double)n2, (double)n3, jzmk._a());
            }
            bl3 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2, n3 + 1, 3)) {
            if (n4 < 0) {
                n4 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            f6 = f7 = 0.8f;
            f5 = f7;
            f4 = f7;
            if (twgu2 != twgu.field_71980_u) {
                f6 = f7 * f;
                f5 = f7 * f2;
                f4 = f7 * f3;
            }
            htvf2.func_78380_c(this._m < 1.0 ? n4 : twgu2.func_71874_e(this._a, n, n2, n3 + 1));
            htvf2.func_78386_a(f6, f5, f4);
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 3);
            if (bl2) {
                if ((dwan2 == TextureUtils.iconGrassSide || dwan2 == TextureUtils.iconMyceliumSide) && (dwan2 = Config.getSideGrassTexture(this._a, n, n2, n3, 3, dwan2)) == TextureUtils.iconGrassTop) {
                    htvf2.func_78386_a(f6 * f, f5 * f2, f4 * f3);
                }
                if (dwan2 == TextureUtils.iconGrassSideSnowed) {
                    dwan2 = Config.getSideSnowGrassTexture(this._a, n, n2, n3, 3);
                }
            }
            this._d(twgu2, n, n2, n3, dwan2);
            if (bl && _e && dwan2 == TextureUtils.iconGrassSide && !this._b()) {
                htvf2.func_78386_a(f6 * f, f5 * f2, f4 * f3);
                this._d(twgu2, n, n2, n3, jzmk._a());
            }
            bl3 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n - 1, n2, n3, 4)) {
            if (n4 < 0) {
                n4 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            f6 = f7 = 0.6f;
            f5 = f7;
            f4 = f7;
            if (twgu2 != twgu.field_71980_u) {
                f6 = f7 * f;
                f5 = f7 * f2;
                f4 = f7 * f3;
            }
            htvf2.func_78380_c(this._h > 0.0 ? n4 : twgu2.func_71874_e(this._a, n - 1, n2, n3));
            htvf2.func_78386_a(f6, f5, f4);
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 4);
            if (bl2) {
                if ((dwan2 == TextureUtils.iconGrassSide || dwan2 == TextureUtils.iconMyceliumSide) && (dwan2 = Config.getSideGrassTexture(this._a, n, n2, n3, 4, dwan2)) == TextureUtils.iconGrassTop) {
                    htvf2.func_78386_a(f6 * f, f5 * f2, f4 * f3);
                }
                if (dwan2 == TextureUtils.iconGrassSideSnowed) {
                    dwan2 = Config.getSideSnowGrassTexture(this._a, n, n2, n3, 4);
                }
            }
            this._e(twgu2, n, n2, n3, dwan2);
            if (bl && _e && dwan2 == TextureUtils.iconGrassSide && !this._b()) {
                htvf2.func_78386_a(f6 * f, f5 * f2, f4 * f3);
                this._e(twgu2, n, n2, n3, jzmk._a());
            }
            bl3 = true;
        }
        if (this._d || twgu2.func_71877_c(this._a, n + 1, n2, n3, 5)) {
            if (n4 < 0) {
                n4 = twgu2.func_71874_e(this._a, n, n2, n3);
            }
            f6 = f7 = 0.6f;
            f5 = f7;
            f4 = f7;
            if (twgu2 != twgu.field_71980_u) {
                f6 = f7 * f;
                f5 = f7 * f2;
                f4 = f7 * f3;
            }
            htvf2.func_78380_c(this._i < 1.0 ? n4 : twgu2.func_71874_e(this._a, n + 1, n2, n3));
            htvf2.func_78386_a(f6, f5, f4);
            dwan2 = this._a(twgu2, this._a, n, n2, n3, 5);
            if (bl2) {
                if ((dwan2 == TextureUtils.iconGrassSide || dwan2 == TextureUtils.iconMyceliumSide) && (dwan2 = Config.getSideGrassTexture(this._a, n, n2, n3, 5, dwan2)) == TextureUtils.iconGrassTop) {
                    htvf2.func_78386_a(f6 * f, f5 * f2, f4 * f3);
                }
                if (dwan2 == TextureUtils.iconGrassSideSnowed) {
                    dwan2 = Config.getSideSnowGrassTexture(this._a, n, n2, n3, 5);
                }
            }
            this._f(twgu2, n, n2, n3, dwan2);
            if (bl && _e && dwan2 == TextureUtils.iconGrassSide && !this._b()) {
                htvf2.func_78386_a(f6 * f, f5 * f2, f4 * f3);
                this._f(twgu2, n, n2, n3, jzmk._a());
            }
            bl3 = true;
        }
        return bl3;
    }

    public boolean _a(woni woni2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(woni2.func_71874_e(this._a, n, n2, n3));
        htvf2.func_78386_a(1.0f, 1.0f, 1.0f);
        int n4 = this._a.func_72805_g(n, n2, n3);
        int n5 = gqau._d(n4);
        int n6 = woni._b(n4);
        dwan dwan2 = woni2._a(n6);
        int n7 = 4 + n6 * 2;
        int n8 = 5 + n6 * 2;
        double d = 15.0 - (double)n7;
        double d2 = 15.0;
        double d3 = 4.0;
        double d4 = 4.0 + (double)n8;
        double d5 = dwan2.func_94214_a(d);
        double d6 = dwan2.func_94214_a(d2);
        double d7 = dwan2.func_94207_b(d3);
        double d8 = dwan2.func_94207_b(d4);
        double d9 = 0.0;
        double d10 = 0.0;
        switch (n5) {
            case 0: {
                d9 = 8.0 - (double)(n7 / 2);
                d10 = 15.0 - (double)n7;
                break;
            }
            case 1: {
                d9 = 1.0;
                d10 = 8.0 - (double)(n7 / 2);
                break;
            }
            case 2: {
                d9 = 8.0 - (double)(n7 / 2);
                d10 = 1.0;
                break;
            }
            case 3: {
                d9 = 15.0 - (double)n7;
                d10 = 8.0 - (double)(n7 / 2);
            }
        }
        double d11 = (double)n + d9 / 16.0;
        double d12 = (double)n + (d9 + (double)n7) / 16.0;
        double d13 = (double)n2 + (12.0 - (double)n8) / 16.0;
        double d14 = (double)n2 + 0.75;
        double d15 = (double)n3 + d10 / 16.0;
        double d16 = (double)n3 + (d10 + (double)n7) / 16.0;
        htvf2.func_78374_a(d11, d13, d15, d5, d8);
        htvf2.func_78374_a(d11, d13, d16, d6, d8);
        htvf2.func_78374_a(d11, d14, d16, d6, d7);
        htvf2.func_78374_a(d11, d14, d15, d5, d7);
        htvf2.func_78374_a(d12, d13, d16, d5, d8);
        htvf2.func_78374_a(d12, d13, d15, d6, d8);
        htvf2.func_78374_a(d12, d14, d15, d6, d7);
        htvf2.func_78374_a(d12, d14, d16, d5, d7);
        htvf2.func_78374_a(d12, d13, d15, d5, d8);
        htvf2.func_78374_a(d11, d13, d15, d6, d8);
        htvf2.func_78374_a(d11, d14, d15, d6, d7);
        htvf2.func_78374_a(d12, d14, d15, d5, d7);
        htvf2.func_78374_a(d11, d13, d16, d5, d8);
        htvf2.func_78374_a(d12, d13, d16, d6, d8);
        htvf2.func_78374_a(d12, d14, d16, d6, d7);
        htvf2.func_78374_a(d11, d14, d16, d5, d7);
        int n9 = n7;
        if (n6 >= 2) {
            n9 = n7 - 1;
        }
        d5 = dwan2.func_94209_e();
        d6 = dwan2.func_94214_a(n9);
        d7 = dwan2.func_94206_g();
        d8 = dwan2.func_94207_b(n9);
        htvf2.func_78374_a(d11, d14, d16, d5, d8);
        htvf2.func_78374_a(d12, d14, d16, d6, d8);
        htvf2.func_78374_a(d12, d14, d15, d6, d7);
        htvf2.func_78374_a(d11, d14, d15, d5, d7);
        htvf2.func_78374_a(d11, d13, d15, d5, d7);
        htvf2.func_78374_a(d12, d13, d15, d6, d7);
        htvf2.func_78374_a(d12, d13, d16, d6, d8);
        htvf2.func_78374_a(d11, d13, d16, d5, d8);
        d5 = dwan2.func_94214_a(12.0);
        d6 = dwan2.func_94212_f();
        d7 = dwan2.func_94206_g();
        d8 = dwan2.func_94207_b(4.0);
        d9 = 8.0;
        d10 = 0.0;
        switch (n5) {
            case 0: {
                d9 = 8.0;
                d10 = 12.0;
                double d17 = d5;
                d5 = d6;
                d6 = d17;
                break;
            }
            case 1: {
                d9 = 0.0;
                d10 = 8.0;
                break;
            }
            case 2: {
                d9 = 8.0;
                d10 = 0.0;
                break;
            }
            case 3: {
                d9 = 12.0;
                d10 = 8.0;
                double d18 = d5;
                d5 = d6;
                d6 = d18;
            }
        }
        d11 = (double)n + d9 / 16.0;
        d12 = (double)n + (d9 + 4.0) / 16.0;
        d13 = (double)n2 + 0.75;
        d14 = (double)n2 + 1.0;
        d15 = (double)n3 + d10 / 16.0;
        d16 = (double)n3 + (d10 + 4.0) / 16.0;
        if (n5 != 2 && n5 != 0) {
            if (n5 == 1 || n5 == 3) {
                htvf2.func_78374_a(d12, d13, d15, d5, d8);
                htvf2.func_78374_a(d11, d13, d15, d6, d8);
                htvf2.func_78374_a(d11, d14, d15, d6, d7);
                htvf2.func_78374_a(d12, d14, d15, d5, d7);
                htvf2.func_78374_a(d11, d13, d15, d6, d8);
                htvf2.func_78374_a(d12, d13, d15, d5, d8);
                htvf2.func_78374_a(d12, d14, d15, d5, d7);
                htvf2.func_78374_a(d11, d14, d15, d6, d7);
            }
        } else {
            htvf2.func_78374_a(d11, d13, d15, d6, d8);
            htvf2.func_78374_a(d11, d13, d16, d5, d8);
            htvf2.func_78374_a(d11, d14, d16, d5, d7);
            htvf2.func_78374_a(d11, d14, d15, d6, d7);
            htvf2.func_78374_a(d11, d13, d16, d5, d8);
            htvf2.func_78374_a(d11, d13, d15, d6, d8);
            htvf2.func_78374_a(d11, d14, d15, d6, d7);
            htvf2.func_78374_a(d11, d14, d16, d5, d7);
        }
        return true;
    }

    public boolean _a(cdtx cdtx2, int n, int n2, int n3) {
        float f = 0.1875f;
        this._a(this._b(twgu.field_71946_M));
        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        this._q(cdtx2, n, n2, n3);
        this._d = true;
        this._a(this._b(twgu.field_72089_ap));
        this._a(0.125, 0.00625f, 0.125, 0.875, (double)f, 0.875);
        this._q(cdtx2, n, n2, n3);
        this._a(this._b(twgu.field_82518_cd));
        this._a(0.1875, f, 0.1875, 0.8125, 0.875, 0.8125);
        this._q(cdtx2, n, n2, n3);
        this._d = false;
        this._a();
        return true;
    }

    public boolean _t(twgu twgu2, int n, int n2, int n3) {
        int n4 = twgu2.func_71920_b(this._a, n, n2, n3);
        float f = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n4 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            float f4 = (f * 30.0f + f2 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f * 30.0f + f2 * 70.0f) / 100.0f;
            float f6 = (f * 30.0f + f3 * 70.0f) / 100.0f;
            f = f4;
            f2 = f5;
            f3 = f6;
        }
        return this._d(twgu2, n, n2, n3, f, f2, f3);
    }

    public boolean _d(twgu twgu2, int n, int n2, int n3, float f, float f2, float f3) {
        htvf htvf2 = this.__aF;
        boolean bl = false;
        float f4 = 0.5f;
        float f5 = 1.0f;
        float f6 = 0.8f;
        float f7 = 0.6f;
        float f8 = f4 * f;
        float f9 = f5 * f;
        float f10 = f6 * f;
        float f11 = f7 * f;
        float f12 = f4 * f2;
        float f13 = f5 * f2;
        float f14 = f6 * f2;
        float f15 = f7 * f2;
        float f16 = f4 * f3;
        float f17 = f5 * f3;
        float f18 = f6 * f3;
        float f19 = f7 * f3;
        float f20 = 0.0625f;
        int n4 = twgu2.func_71874_e(this._a, n, n2, n3);
        if (this._d || twgu2.func_71877_c(this._a, n, n2 - 1, n3, 0)) {
            htvf2.func_78380_c(this._j > 0.0 ? n4 : twgu2.func_71874_e(this._a, n, n2 - 1, n3));
            htvf2.func_78386_a(f8, f12, f16);
            this._a(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 0));
        }
        if (this._d || twgu2.func_71877_c(this._a, n, n2 + 1, n3, 1)) {
            htvf2.func_78380_c(this._k < 1.0 ? n4 : twgu2.func_71874_e(this._a, n, n2 + 1, n3));
            htvf2.func_78386_a(f9, f13, f17);
            this._b(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 1));
        }
        htvf2.func_78380_c(n4);
        htvf2.func_78386_a(f10, f14, f18);
        htvf2.func_78372_c(0.0f, 0.0f, f20);
        this._c(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 2));
        htvf2.func_78372_c(0.0f, 0.0f, -f20);
        htvf2.func_78372_c(0.0f, 0.0f, -f20);
        this._d(twgu2, n, n2, n3, this._a(twgu2, this._a, n, n2, n3, 3));
        htvf2.func_78372_c(0.0f, 0.0f, f20);
        htvf2.func_78386_a(f11, f15, f19);
        htvf2.func_78372_c(f20, 0.0f, 0.0f);
        this._e(twgu2, n, n2, n3, this._a(twgu2, this._a, n, n2, n3, 4));
        htvf2.func_78372_c(-f20, 0.0f, 0.0f);
        htvf2.func_78372_c(-f20, 0.0f, 0.0f);
        this._f(twgu2, n, n2, n3, this._a(twgu2, this._a, n, n2, n3, 5));
        htvf2.func_78372_c(f20, 0.0f, 0.0f);
        return true;
    }

    public boolean _a(htgl htgl2, int n, int n2, int n3) {
        float f;
        boolean bl = false;
        float f2 = 0.375f;
        float f3 = 0.625f;
        this._a(f2, 0.0, (double)f2, (double)f3, 1.0, (double)f3);
        this._q(htgl2, n, n2, n3);
        bl = true;
        boolean bl2 = false;
        boolean bl3 = false;
        if (htgl2._a(this._a, n - 1, n2, n3) || htgl2._a(this._a, n + 1, n2, n3)) {
            bl2 = true;
        }
        if (htgl2._a(this._a, n, n2, n3 - 1) || htgl2._a(this._a, n, n2, n3 + 1)) {
            bl3 = true;
        }
        boolean bl4 = htgl2._a(this._a, n - 1, n2, n3);
        boolean bl5 = htgl2._a(this._a, n + 1, n2, n3);
        boolean bl6 = htgl2._a(this._a, n, n2, n3 - 1);
        boolean bl7 = htgl2._a(this._a, n, n2, n3 + 1);
        if (!bl2 && !bl3) {
            bl2 = true;
        }
        f2 = 0.4375f;
        f3 = 0.5625f;
        float f4 = 0.75f;
        float f5 = 0.9375f;
        float f6 = bl4 ? 0.0f : f2;
        float f7 = bl5 ? 1.0f : f3;
        float f8 = bl6 ? 0.0f : f2;
        float f9 = f = bl7 ? 1.0f : f3;
        if (bl2) {
            this._a(f6, f4, (double)f2, (double)f7, (double)f5, (double)f3);
            this._q(htgl2, n, n2, n3);
            bl = true;
        }
        if (bl3) {
            this._a(f2, f4, (double)f8, (double)f3, (double)f5, (double)f);
            this._q(htgl2, n, n2, n3);
            bl = true;
        }
        f4 = 0.375f;
        f5 = 0.5625f;
        if (bl2) {
            this._a(f6, f4, (double)f2, (double)f7, (double)f5, (double)f3);
            this._q(htgl2, n, n2, n3);
            bl = true;
        }
        if (bl3) {
            this._a(f2, f4, (double)f8, (double)f3, (double)f5, (double)f);
            this._q(htgl2, n, n2, n3);
            bl = true;
        }
        htgl2.func_71902_a(this._a, n, n2, n3);
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, twgu.field_72037_aS.field_72022_cl);
        }
        return bl;
    }

    public boolean _a(ifiu ifiu2, int n, int n2, int n3) {
        boolean bl = ifiu2._a(this._a, n - 1, n2, n3);
        boolean bl2 = ifiu2._a(this._a, n + 1, n2, n3);
        boolean bl3 = ifiu2._a(this._a, n, n2, n3 - 1);
        boolean bl4 = ifiu2._a(this._a, n, n2, n3 + 1);
        boolean bl5 = bl3 && bl4 && !bl && !bl2;
        boolean bl6 = !bl3 && !bl4 && bl && bl2;
        boolean bl7 = this._a.func_72799_c(n, n2 + 1, n3);
        if ((bl5 || bl6) && bl7) {
            if (bl5) {
                this._a(0.3125, 0.0, 0.0, 0.6875, 0.8125, 1.0);
                this._q(ifiu2, n, n2, n3);
            } else {
                this._a(0.0, 0.0, 0.3125, 1.0, 0.8125, 0.6875);
                this._q(ifiu2, n, n2, n3);
            }
        } else {
            this._a(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
            this._q(ifiu2, n, n2, n3);
            if (bl) {
                this._a(0.0, 0.0, 0.3125, 0.25, 0.8125, 0.6875);
                this._q(ifiu2, n, n2, n3);
            }
            if (bl2) {
                this._a(0.75, 0.0, 0.3125, 1.0, 0.8125, 0.6875);
                this._q(ifiu2, n, n2, n3);
            }
            if (bl3) {
                this._a(0.3125, 0.0, 0.0, 0.6875, 0.8125, 0.25);
                this._q(ifiu2, n, n2, n3);
            }
            if (bl4) {
                this._a(0.3125, 0.0, 0.75, 0.6875, 0.8125, 1.0);
                this._q(ifiu2, n, n2, n3);
            }
        }
        ifiu2.func_71902_a(this._a, n, n2, n3);
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, twgu.field_72037_aS.field_72022_cl);
        }
        return true;
    }

    public boolean _a(yutb yutb2, int n, int n2, int n3) {
        boolean bl = false;
        int n4 = 0;
        for (int i = 0; i < 8; ++i) {
            int n5 = 0;
            int n6 = 1;
            if (i == 0) {
                n5 = 2;
            }
            if (i == 1) {
                n5 = 3;
            }
            if (i == 2) {
                n5 = 4;
            }
            if (i == 3) {
                n5 = 5;
                n6 = 2;
            }
            if (i == 4) {
                n5 = 6;
                n6 = 3;
            }
            if (i == 5) {
                n5 = 7;
                n6 = 5;
            }
            if (i == 6) {
                n5 = 6;
                n6 = 2;
            }
            if (i == 7) {
                n5 = 3;
            }
            float f = (float)n5 / 16.0f;
            float f2 = 1.0f - (float)n4 / 16.0f;
            float f3 = 1.0f - (float)(n4 + n6) / 16.0f;
            n4 += n6;
            this._a(0.5f - f, f3, (double)(0.5f - f), (double)(0.5f + f), (double)f2, (double)(0.5f + f));
            this._q(yutb2, n, n2, n3);
        }
        bl = true;
        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        return bl;
    }

    public boolean _a(kloa kloa2, int n, int n2, int n3) {
        float f;
        float f2;
        float f3;
        float f4;
        boolean bl = true;
        int n4 = this._a.func_72805_g(n, n2, n3);
        boolean bl2 = kloa._a(n4);
        int n5 = gqau._d(n4);
        float f5 = 0.375f;
        float f6 = 0.5625f;
        float f7 = 0.75f;
        float f8 = 0.9375f;
        float f9 = 0.3125f;
        float f10 = 1.0f;
        if ((n5 == 2 || n5 == 0) && this._a.func_72798_a(n - 1, n2, n3) == twgu.field_82515_ce.field_71990_ca && this._a.func_72798_a(n + 1, n2, n3) == twgu.field_82515_ce.field_71990_ca || (n5 == 3 || n5 == 1) && this._a.func_72798_a(n, n2, n3 - 1) == twgu.field_82515_ce.field_71990_ca && this._a.func_72798_a(n, n2, n3 + 1) == twgu.field_82515_ce.field_71990_ca) {
            f5 -= 0.1875f;
            f6 -= 0.1875f;
            f7 -= 0.1875f;
            f8 -= 0.1875f;
            f9 -= 0.1875f;
            f10 -= 0.1875f;
        }
        this._d = true;
        if (n5 != 3 && n5 != 1) {
            f4 = 0.0f;
            f3 = 0.125f;
            f2 = 0.4375f;
            f = 0.5625f;
            this._a(f4, f9, (double)f2, (double)f3, (double)f10, (double)f);
            this._q(kloa2, n, n2, n3);
            f4 = 0.875f;
            f3 = 1.0f;
            this._a(f4, f9, (double)f2, (double)f3, (double)f10, (double)f);
            this._q(kloa2, n, n2, n3);
        } else {
            this._u = 1;
            f4 = 0.4375f;
            f3 = 0.5625f;
            f2 = 0.0f;
            f = 0.125f;
            this._a(f4, f9, (double)f2, (double)f3, (double)f10, (double)f);
            this._q(kloa2, n, n2, n3);
            f2 = 0.875f;
            f = 1.0f;
            this._a(f4, f9, (double)f2, (double)f3, (double)f10, (double)f);
            this._q(kloa2, n, n2, n3);
            this._u = 0;
        }
        if (bl2) {
            if (n5 == 2 || n5 == 0) {
                this._u = 1;
            }
            if (n5 == 3) {
                f4 = 0.0f;
                f3 = 0.125f;
                f2 = 0.875f;
                f = 1.0f;
                float f11 = 0.5625f;
                float f12 = 0.8125f;
                float f13 = 0.9375f;
                this._a(0.8125, f5, 0.0, 0.9375, (double)f8, 0.125);
                this._q(kloa2, n, n2, n3);
                this._a(0.8125, f5, 0.875, 0.9375, (double)f8, 1.0);
                this._q(kloa2, n, n2, n3);
                this._a(0.5625, f5, 0.0, 0.8125, (double)f6, 0.125);
                this._q(kloa2, n, n2, n3);
                this._a(0.5625, f5, 0.875, 0.8125, (double)f6, 1.0);
                this._q(kloa2, n, n2, n3);
                this._a(0.5625, f7, 0.0, 0.8125, (double)f8, 0.125);
                this._q(kloa2, n, n2, n3);
                this._a(0.5625, f7, 0.875, 0.8125, (double)f8, 1.0);
                this._q(kloa2, n, n2, n3);
            } else if (n5 == 1) {
                f4 = 0.0f;
                f3 = 0.125f;
                f2 = 0.875f;
                f = 1.0f;
                float f14 = 0.0625f;
                float f15 = 0.1875f;
                float f16 = 0.4375f;
                this._a(0.0625, f5, 0.0, 0.1875, (double)f8, 0.125);
                this._q(kloa2, n, n2, n3);
                this._a(0.0625, f5, 0.875, 0.1875, (double)f8, 1.0);
                this._q(kloa2, n, n2, n3);
                this._a(0.1875, f5, 0.0, 0.4375, (double)f6, 0.125);
                this._q(kloa2, n, n2, n3);
                this._a(0.1875, f5, 0.875, 0.4375, (double)f6, 1.0);
                this._q(kloa2, n, n2, n3);
                this._a(0.1875, f7, 0.0, 0.4375, (double)f8, 0.125);
                this._q(kloa2, n, n2, n3);
                this._a(0.1875, f7, 0.875, 0.4375, (double)f8, 1.0);
                this._q(kloa2, n, n2, n3);
            } else if (n5 == 0) {
                f4 = 0.0f;
                f3 = 0.125f;
                f2 = 0.875f;
                f = 1.0f;
                float f17 = 0.5625f;
                float f18 = 0.8125f;
                float f19 = 0.9375f;
                this._a(0.0, f5, 0.8125, 0.125, (double)f8, 0.9375);
                this._q(kloa2, n, n2, n3);
                this._a(0.875, f5, 0.8125, 1.0, (double)f8, 0.9375);
                this._q(kloa2, n, n2, n3);
                this._a(0.0, f5, 0.5625, 0.125, (double)f6, 0.8125);
                this._q(kloa2, n, n2, n3);
                this._a(0.875, f5, 0.5625, 1.0, (double)f6, 0.8125);
                this._q(kloa2, n, n2, n3);
                this._a(0.0, f7, 0.5625, 0.125, (double)f8, 0.8125);
                this._q(kloa2, n, n2, n3);
                this._a(0.875, f7, 0.5625, 1.0, (double)f8, 0.8125);
                this._q(kloa2, n, n2, n3);
            } else if (n5 == 2) {
                f4 = 0.0f;
                f3 = 0.125f;
                f2 = 0.875f;
                f = 1.0f;
                float f20 = 0.0625f;
                float f21 = 0.1875f;
                float f22 = 0.4375f;
                this._a(0.0, f5, 0.0625, 0.125, (double)f8, 0.1875);
                this._q(kloa2, n, n2, n3);
                this._a(0.875, f5, 0.0625, 1.0, (double)f8, 0.1875);
                this._q(kloa2, n, n2, n3);
                this._a(0.0, f5, 0.1875, 0.125, (double)f6, 0.4375);
                this._q(kloa2, n, n2, n3);
                this._a(0.875, f5, 0.1875, 1.0, (double)f6, 0.4375);
                this._q(kloa2, n, n2, n3);
                this._a(0.0, f7, 0.1875, 0.125, (double)f8, 0.4375);
                this._q(kloa2, n, n2, n3);
                this._a(0.875, f7, 0.1875, 1.0, (double)f8, 0.4375);
                this._q(kloa2, n, n2, n3);
            }
        } else if (n5 != 3 && n5 != 1) {
            f4 = 0.375f;
            f3 = 0.5f;
            f2 = 0.4375f;
            f = 0.5625f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(kloa2, n, n2, n3);
            f4 = 0.5f;
            f3 = 0.625f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(kloa2, n, n2, n3);
            f4 = 0.625f;
            f3 = 0.875f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f6, (double)f);
            this._q(kloa2, n, n2, n3);
            this._a(f4, f7, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(kloa2, n, n2, n3);
            f4 = 0.125f;
            f3 = 0.375f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f6, (double)f);
            this._q(kloa2, n, n2, n3);
            this._a(f4, f7, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(kloa2, n, n2, n3);
        } else {
            this._u = 1;
            f4 = 0.4375f;
            f3 = 0.5625f;
            f2 = 0.375f;
            f = 0.5f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(kloa2, n, n2, n3);
            f2 = 0.5f;
            f = 0.625f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(kloa2, n, n2, n3);
            f2 = 0.625f;
            f = 0.875f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f6, (double)f);
            this._q(kloa2, n, n2, n3);
            this._a(f4, f7, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(kloa2, n, n2, n3);
            f2 = 0.125f;
            f = 0.375f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f6, (double)f);
            this._q(kloa2, n, n2, n3);
            this._a(f4, f7, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(kloa2, n, n2, n3);
        }
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, twgu.field_72037_aS.field_72022_cl);
        }
        this._d = false;
        this._u = 0;
        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        return bl;
    }

    public boolean _a(ndvl ndvl2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        htvf2.func_78380_c(ndvl2.func_71874_e(this._a, n, n2, n3));
        float f = 1.0f;
        int n4 = ndvl2.func_71920_b(this._a, n, n2, n3);
        float f2 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n4 & 0xFF) / 255.0f;
        if (tfsl.field_78517_a) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        htvf2.func_78386_a(f * f2, f * f3, f * f4);
        return this._a(ndvl2, n, n2, n3, this._a.func_72805_g(n, n2, n3), false);
    }

    public boolean _a(ndvl ndvl2, int n, int n2, int n3, int n4, boolean bl) {
        float f;
        htvf htvf2 = this.__aF;
        int n5 = ndvl._a(n4);
        double d = 0.625;
        this._a(0.0, d, 0.0, 1.0, 1.0, 1.0);
        if (bl) {
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
            this._a((twgu)ndvl2, 0.0, 0.0, 0.0, this._a((twgu)ndvl2, 0, n4));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
            this._b((twgu)ndvl2, 0.0, 0.0, 0.0, this._a((twgu)ndvl2, 1, n4));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
            this._c((twgu)ndvl2, 0.0, 0.0, 0.0, this._a((twgu)ndvl2, 2, n4));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
            this._d(ndvl2, 0.0, 0.0, 0.0, this._a((twgu)ndvl2, 3, n4));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
            this._e(ndvl2, 0.0, 0.0, 0.0, this._a((twgu)ndvl2, 4, n4));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
            this._f(ndvl2, 0.0, 0.0, 0.0, this._a((twgu)ndvl2, 5, n4));
            htvf2.func_78381_a();
        } else {
            this._q(ndvl2, n, n2, n3);
        }
        if (!bl) {
            htvf2.func_78380_c(ndvl2.func_71874_e(this._a, n, n2, n3));
            float f2 = 1.0f;
            int n6 = ndvl2.func_71920_b(this._a, n, n2, n3);
            f = (float)(n6 >> 16 & 0xFF) / 255.0f;
            float f3 = (float)(n6 >> 8 & 0xFF) / 255.0f;
            float f4 = (float)(n6 & 0xFF) / 255.0f;
            if (tfsl.field_78517_a) {
                float f5 = (f * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
                float f6 = (f * 30.0f + f3 * 70.0f) / 100.0f;
                float f7 = (f * 30.0f + f4 * 70.0f) / 100.0f;
                f = f5;
                f3 = f6;
                f4 = f7;
            }
            htvf2.func_78386_a(f2 * f, f2 * f3, f2 * f4);
        }
        dwan dwan2 = ndvl._a("hopper_outside");
        dwan dwan3 = ndvl._a("hopper_inside");
        f = 0.125f;
        if (bl) {
            htvf2.func_78382_b();
            htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
            this._f(ndvl2, -1.0f + f, 0.0, 0.0, dwan2);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
            this._e(ndvl2, 1.0f - f, 0.0, 0.0, dwan2);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
            this._d(ndvl2, 0.0, 0.0, -1.0f + f, dwan2);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
            this._c((twgu)ndvl2, 0.0, 0.0, 1.0f - f, dwan2);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
            this._b((twgu)ndvl2, 0.0, -1.0 + d, 0.0, dwan3);
            htvf2.func_78381_a();
        } else {
            this._f(ndvl2, (float)n - 1.0f + f, n2, n3, dwan2);
            this._e(ndvl2, (float)n + 1.0f - f, n2, n3, dwan2);
            this._d(ndvl2, n, n2, (float)n3 - 1.0f + f, dwan2);
            this._c((twgu)ndvl2, (double)n, (double)n2, (float)n3 + 1.0f - f, dwan2);
            this._b((twgu)ndvl2, (double)n, (double)((float)n2 - 1.0f) + d, (double)n3, dwan3);
        }
        this._a(dwan2);
        double d2 = 0.25;
        double d3 = 0.25;
        this._a(d2, d3, d2, 1.0 - d2, d - 0.002, 1.0 - d2);
        if (bl) {
            htvf2.func_78382_b();
            htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
            this._f(ndvl2, 0.0, 0.0, 0.0, dwan2);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
            this._e(ndvl2, 0.0, 0.0, 0.0, dwan2);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
            this._d(ndvl2, 0.0, 0.0, 0.0, dwan2);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
            this._c((twgu)ndvl2, 0.0, 0.0, 0.0, dwan2);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
            this._b((twgu)ndvl2, 0.0, 0.0, 0.0, dwan2);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
            this._a((twgu)ndvl2, 0.0, 0.0, 0.0, dwan2);
            htvf2.func_78381_a();
        } else {
            this._q(ndvl2, n, n2, n3);
        }
        if (!bl) {
            double d4 = 0.375;
            double d5 = 0.25;
            this._a(dwan2);
            if (n5 == 0) {
                this._a(d4, 0.0, d4, 1.0 - d4, 0.25, 1.0 - d4);
                this._q(ndvl2, n, n2, n3);
            }
            if (n5 == 2) {
                this._a(d4, d3, 0.0, 1.0 - d4, d3 + d5, d2);
                this._q(ndvl2, n, n2, n3);
            }
            if (n5 == 3) {
                this._a(d4, d3, 1.0 - d2, 1.0 - d4, d3 + d5, 1.0);
                this._q(ndvl2, n, n2, n3);
            }
            if (n5 == 4) {
                this._a(0.0, d3, d4, d2, d3 + d5, 1.0 - d4);
                this._q(ndvl2, n, n2, n3);
            }
            if (n5 == 5) {
                this._a(1.0 - d2, d3, d4, 1.0, d3 + d5, 1.0 - d4);
                this._q(ndvl2, n, n2, n3);
            }
        }
        this._a();
        return true;
    }

    public boolean _a(yuxu yuxu2, int n, int n2, int n3) {
        yuxu2._a(this._a, n, n2, n3);
        this._a(yuxu2);
        this._q(yuxu2, n, n2, n3);
        boolean bl = yuxu2._b(this._a, n, n2, n3);
        this._a(yuxu2);
        this._q(yuxu2, n, n2, n3);
        if (bl && yuxu2._c(this._a, n, n2, n3)) {
            this._a(yuxu2);
            this._q(yuxu2, n, n2, n3);
        }
        return true;
    }

    public boolean _u(twgu twgu2, int n, int n2, int n3) {
        htvf htvf2 = this.__aF;
        int n4 = this._a.func_72805_g(n, n2, n3);
        if ((n4 & 8) != 0 ? this._a.func_72798_a(n, n2 - 1, n3) != twgu2.field_71990_ca : this._a.func_72798_a(n, n2 + 1, n3) != twgu2.field_71990_ca) {
            return false;
        }
        boolean bl = false;
        float f = 0.5f;
        float f2 = 1.0f;
        float f3 = 0.8f;
        float f4 = 0.6f;
        int n5 = twgu2.func_71874_e(this._a, n, n2, n3);
        htvf2.func_78380_c(this._j > 0.0 ? n5 : twgu2.func_71874_e(this._a, n, n2 - 1, n3));
        htvf2.func_78386_a(f, f, f);
        this._a(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 0));
        bl = true;
        htvf2.func_78380_c(this._k < 1.0 ? n5 : twgu2.func_71874_e(this._a, n, n2 + 1, n3));
        htvf2.func_78386_a(f2, f2, f2);
        this._b(twgu2, (double)n, (double)n2, (double)n3, this._a(twgu2, this._a, n, n2, n3, 1));
        bl = true;
        htvf2.func_78380_c(this._l > 0.0 ? n5 : twgu2.func_71874_e(this._a, n, n2, n3 - 1));
        htvf2.func_78386_a(f3, f3, f3);
        dwan dwan2 = this._a(twgu2, this._a, n, n2, n3, 2);
        this._c(twgu2, (double)n, (double)n2, (double)n3, dwan2);
        bl = true;
        this._c = false;
        htvf2.func_78380_c(this._m < 1.0 ? n5 : twgu2.func_71874_e(this._a, n, n2, n3 + 1));
        htvf2.func_78386_a(f3, f3, f3);
        dwan2 = this._a(twgu2, this._a, n, n2, n3, 3);
        this._d(twgu2, n, n2, n3, dwan2);
        bl = true;
        this._c = false;
        htvf2.func_78380_c(this._h > 0.0 ? n5 : twgu2.func_71874_e(this._a, n - 1, n2, n3));
        htvf2.func_78386_a(f4, f4, f4);
        dwan2 = this._a(twgu2, this._a, n, n2, n3, 4);
        this._e(twgu2, n, n2, n3, dwan2);
        bl = true;
        this._c = false;
        htvf2.func_78380_c(this._i < 1.0 ? n5 : twgu2.func_71874_e(this._a, n + 1, n2, n3));
        htvf2.func_78386_a(f4, f4, f4);
        dwan2 = this._a(twgu2, this._a, n, n2, n3, 5);
        this._f(twgu2, n, n2, n3, dwan2);
        bl = true;
        this._c = false;
        return bl;
    }

    public void _a(twgu twgu2, double d, double d2, double d3, dwan dwan2) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        htvf htvf2 = this.__aF;
        if (this._b()) {
            dwan2 = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._v == 0) {
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, twgu2, (int)d, (int)d2, (int)d3, 0, dwan2);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._v == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(dwan2)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 0);
            if (naturalProperties.rotation > 1) {
                this._v = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._v = this._v / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = dwan2.func_94214_a(this._h * 16.0);
        double d7 = dwan2.func_94214_a(this._i * 16.0);
        double d8 = dwan2.func_94207_b(this._l * 16.0);
        double d9 = dwan2.func_94207_b(this._m * 16.0);
        if (this._h < 0.0 || this._i > 1.0) {
            d6 = dwan2.func_94209_e();
            d7 = dwan2.func_94212_f();
        }
        if (this._l < 0.0 || this._m > 1.0) {
            d8 = dwan2.func_94206_g();
            d9 = dwan2.func_94210_h();
        }
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._v == 2) {
            d6 = dwan2.func_94214_a(this._l * 16.0);
            d8 = dwan2.func_94207_b(16.0 - this._i * 16.0);
            d7 = dwan2.func_94214_a(this._m * 16.0);
            d9 = dwan2.func_94207_b(16.0 - this._h * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._v == 1) {
            d6 = dwan2.func_94214_a(16.0 - this._m * 16.0);
            d8 = dwan2.func_94207_b(this._h * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._l * 16.0);
            d9 = dwan2.func_94207_b(this._i * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._v == 3) {
            d6 = dwan2.func_94214_a(16.0 - this._h * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._i * 16.0);
            d8 = dwan2.func_94207_b(16.0 - this._l * 16.0);
            d9 = dwan2.func_94207_b(16.0 - this._m * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._v = 0;
            this._c = false;
        }
        d4 = d + this._h;
        double d13 = d + this._i;
        double d14 = d2 + this._j;
        double d15 = d3 + this._l;
        double d16 = d3 + this._m;
        if (this._w) {
            htvf2.func_78386_a(this.__ap, this.__at, this.__ax);
            htvf2.func_78380_c(this.__al);
            htvf2.func_78374_a(d4, d14, d16, d10, d12);
            htvf2.func_78386_a(this.__aq, this.__au, this.__ay);
            htvf2.func_78380_c(this.__am);
            htvf2.func_78374_a(d4, d14, d15, d6, d8);
            htvf2.func_78386_a(this.__ar, this.__av, this.__az);
            htvf2.func_78380_c(this.__an);
            htvf2.func_78374_a(d13, d14, d15, d5, d11);
            htvf2.func_78386_a(this.__as, this.__aw, this.__aA);
            htvf2.func_78380_c(this.__ao);
            htvf2.func_78374_a(d13, d14, d16, d7, d9);
        } else {
            htvf2.func_78374_a(d4, d14, d16, d10, d12);
            htvf2.func_78374_a(d4, d14, d15, d6, d8);
            htvf2.func_78374_a(d13, d14, d15, d5, d11);
            htvf2.func_78374_a(d13, d14, d16, d7, d9);
        }
    }

    public void _b(twgu twgu2, double d, double d2, double d3, dwan dwan2) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        htvf htvf2 = this.__aF;
        if (this._b()) {
            dwan2 = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._u == 0) {
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, twgu2, (int)d, (int)d2, (int)d3, 1, dwan2);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._u == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(dwan2)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 1);
            if (naturalProperties.rotation > 1) {
                this._u = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._u = this._u / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = dwan2.func_94214_a(this._h * 16.0);
        double d7 = dwan2.func_94214_a(this._i * 16.0);
        double d8 = dwan2.func_94207_b(this._l * 16.0);
        double d9 = dwan2.func_94207_b(this._m * 16.0);
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if (this._h < 0.0 || this._i > 1.0) {
            d6 = dwan2.func_94209_e();
            d7 = dwan2.func_94212_f();
        }
        if (this._l < 0.0 || this._m > 1.0) {
            d8 = dwan2.func_94206_g();
            d9 = dwan2.func_94210_h();
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._u == 1) {
            d6 = dwan2.func_94214_a(this._l * 16.0);
            d8 = dwan2.func_94207_b(16.0 - this._i * 16.0);
            d7 = dwan2.func_94214_a(this._m * 16.0);
            d9 = dwan2.func_94207_b(16.0 - this._h * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._u == 2) {
            d6 = dwan2.func_94214_a(16.0 - this._m * 16.0);
            d8 = dwan2.func_94207_b(this._h * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._l * 16.0);
            d9 = dwan2.func_94207_b(this._i * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._u == 3) {
            d6 = dwan2.func_94214_a(16.0 - this._h * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._i * 16.0);
            d8 = dwan2.func_94207_b(16.0 - this._l * 16.0);
            d9 = dwan2.func_94207_b(16.0 - this._m * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._u = 0;
            this._c = false;
        }
        d4 = d + this._h;
        double d13 = d + this._i;
        double d14 = d2 + this._k;
        double d15 = d3 + this._l;
        double d16 = d3 + this._m;
        if (this._w) {
            htvf2.func_78386_a(this.__ap, this.__at, this.__ax);
            htvf2.func_78380_c(this.__al);
            htvf2.func_78374_a(d13, d14, d16, d7, d9);
            htvf2.func_78386_a(this.__aq, this.__au, this.__ay);
            htvf2.func_78380_c(this.__am);
            htvf2.func_78374_a(d13, d14, d15, d5, d11);
            htvf2.func_78386_a(this.__ar, this.__av, this.__az);
            htvf2.func_78380_c(this.__an);
            htvf2.func_78374_a(d4, d14, d15, d6, d8);
            htvf2.func_78386_a(this.__as, this.__aw, this.__aA);
            htvf2.func_78380_c(this.__ao);
            htvf2.func_78374_a(d4, d14, d16, d10, d12);
        } else {
            htvf2.func_78374_a(d13, d14, d16, d7, d9);
            htvf2.func_78374_a(d13, d14, d15, d5, d11);
            htvf2.func_78374_a(d4, d14, d15, d6, d8);
            htvf2.func_78374_a(d4, d14, d16, d10, d12);
        }
    }

    public void _c(twgu twgu2, double d, double d2, double d3, dwan dwan2) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        htvf htvf2 = this.__aF;
        if (this._b()) {
            dwan2 = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._q == 0) {
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, twgu2, (int)d, (int)d2, (int)d3, 2, dwan2);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._q == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(dwan2)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 2);
            if (naturalProperties.rotation > 1) {
                this._q = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._q = this._q / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = dwan2.func_94214_a(this._h * 16.0);
        double d7 = dwan2.func_94214_a(this._i * 16.0);
        double d8 = dwan2.func_94207_b(16.0 - this._k * 16.0);
        double d9 = dwan2.func_94207_b(16.0 - this._j * 16.0);
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if (this._h < 0.0 || this._i > 1.0) {
            d6 = dwan2.func_94209_e();
            d7 = dwan2.func_94212_f();
        }
        if (this._j < 0.0 || this._k > 1.0) {
            d8 = dwan2.func_94206_g();
            d9 = dwan2.func_94210_h();
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._q == 2) {
            d6 = dwan2.func_94214_a(this._j * 16.0);
            d8 = dwan2.func_94207_b(16.0 - this._h * 16.0);
            d7 = dwan2.func_94214_a(this._k * 16.0);
            d9 = dwan2.func_94207_b(16.0 - this._i * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._q == 1) {
            d6 = dwan2.func_94214_a(16.0 - this._k * 16.0);
            d8 = dwan2.func_94207_b(this._i * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._j * 16.0);
            d9 = dwan2.func_94207_b(this._h * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._q == 3) {
            d6 = dwan2.func_94214_a(16.0 - this._h * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._i * 16.0);
            d8 = dwan2.func_94207_b(this._k * 16.0);
            d9 = dwan2.func_94207_b(this._j * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._q = 0;
            this._c = false;
        }
        d4 = d + this._h;
        double d13 = d + this._i;
        double d14 = d2 + this._j;
        double d15 = d2 + this._k;
        double d16 = d3 + this._l;
        if (this._w) {
            htvf2.func_78386_a(this.__ap, this.__at, this.__ax);
            htvf2.func_78380_c(this.__al);
            htvf2.func_78374_a(d4, d15, d16, d5, d11);
            htvf2.func_78386_a(this.__aq, this.__au, this.__ay);
            htvf2.func_78380_c(this.__am);
            htvf2.func_78374_a(d13, d15, d16, d6, d8);
            htvf2.func_78386_a(this.__ar, this.__av, this.__az);
            htvf2.func_78380_c(this.__an);
            htvf2.func_78374_a(d13, d14, d16, d10, d12);
            htvf2.func_78386_a(this.__as, this.__aw, this.__aA);
            htvf2.func_78380_c(this.__ao);
            htvf2.func_78374_a(d4, d14, d16, d7, d9);
        } else {
            htvf2.func_78374_a(d4, d15, d16, d5, d11);
            htvf2.func_78374_a(d13, d15, d16, d6, d8);
            htvf2.func_78374_a(d13, d14, d16, d10, d12);
            htvf2.func_78374_a(d4, d14, d16, d7, d9);
        }
    }

    public void _d(twgu twgu2, double d, double d2, double d3, dwan dwan2) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        htvf htvf2 = this.__aF;
        if (this._b()) {
            dwan2 = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._r == 0) {
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, twgu2, (int)d, (int)d2, (int)d3, 3, dwan2);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._r == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(dwan2)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 3);
            if (naturalProperties.rotation > 1) {
                this._r = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._r = this._r / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = dwan2.func_94214_a(this._h * 16.0);
        double d7 = dwan2.func_94214_a(this._i * 16.0);
        double d8 = dwan2.func_94207_b(16.0 - this._k * 16.0);
        double d9 = dwan2.func_94207_b(16.0 - this._j * 16.0);
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if (this._h < 0.0 || this._i > 1.0) {
            d6 = dwan2.func_94209_e();
            d7 = dwan2.func_94212_f();
        }
        if (this._j < 0.0 || this._k > 1.0) {
            d8 = dwan2.func_94206_g();
            d9 = dwan2.func_94210_h();
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._r == 1) {
            d6 = dwan2.func_94214_a(this._j * 16.0);
            d9 = dwan2.func_94207_b(16.0 - this._h * 16.0);
            d7 = dwan2.func_94214_a(this._k * 16.0);
            d8 = dwan2.func_94207_b(16.0 - this._i * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._r == 2) {
            d6 = dwan2.func_94214_a(16.0 - this._k * 16.0);
            d8 = dwan2.func_94207_b(this._h * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._j * 16.0);
            d9 = dwan2.func_94207_b(this._i * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._r == 3) {
            d6 = dwan2.func_94214_a(16.0 - this._h * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._i * 16.0);
            d8 = dwan2.func_94207_b(this._k * 16.0);
            d9 = dwan2.func_94207_b(this._j * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._r = 0;
            this._c = false;
        }
        d4 = d + this._h;
        double d13 = d + this._i;
        double d14 = d2 + this._j;
        double d15 = d2 + this._k;
        double d16 = d3 + this._m;
        if (this._w) {
            htvf2.func_78386_a(this.__ap, this.__at, this.__ax);
            htvf2.func_78380_c(this.__al);
            htvf2.func_78374_a(d4, d15, d16, d6, d8);
            htvf2.func_78386_a(this.__aq, this.__au, this.__ay);
            htvf2.func_78380_c(this.__am);
            htvf2.func_78374_a(d4, d14, d16, d10, d12);
            htvf2.func_78386_a(this.__ar, this.__av, this.__az);
            htvf2.func_78380_c(this.__an);
            htvf2.func_78374_a(d13, d14, d16, d7, d9);
            htvf2.func_78386_a(this.__as, this.__aw, this.__aA);
            htvf2.func_78380_c(this.__ao);
            htvf2.func_78374_a(d13, d15, d16, d5, d11);
        } else {
            htvf2.func_78374_a(d4, d15, d16, d6, d8);
            htvf2.func_78374_a(d4, d14, d16, d10, d12);
            htvf2.func_78374_a(d13, d14, d16, d7, d9);
            htvf2.func_78374_a(d13, d15, d16, d5, d11);
        }
    }

    public void _e(twgu twgu2, double d, double d2, double d3, dwan dwan2) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        htvf htvf2 = this.__aF;
        if (this._b()) {
            dwan2 = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._t == 0) {
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, twgu2, (int)d, (int)d2, (int)d3, 4, dwan2);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._t == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(dwan2)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 4);
            if (naturalProperties.rotation > 1) {
                this._t = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._t = this._t / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = dwan2.func_94214_a(this._l * 16.0);
        double d7 = dwan2.func_94214_a(this._m * 16.0);
        double d8 = dwan2.func_94207_b(16.0 - this._k * 16.0);
        double d9 = dwan2.func_94207_b(16.0 - this._j * 16.0);
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if (this._l < 0.0 || this._m > 1.0) {
            d6 = dwan2.func_94209_e();
            d7 = dwan2.func_94212_f();
        }
        if (this._j < 0.0 || this._k > 1.0) {
            d8 = dwan2.func_94206_g();
            d9 = dwan2.func_94210_h();
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._t == 1) {
            d6 = dwan2.func_94214_a(this._j * 16.0);
            d8 = dwan2.func_94207_b(16.0 - this._m * 16.0);
            d7 = dwan2.func_94214_a(this._k * 16.0);
            d9 = dwan2.func_94207_b(16.0 - this._l * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._t == 2) {
            d6 = dwan2.func_94214_a(16.0 - this._k * 16.0);
            d8 = dwan2.func_94207_b(this._l * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._j * 16.0);
            d9 = dwan2.func_94207_b(this._m * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._t == 3) {
            d6 = dwan2.func_94214_a(16.0 - this._l * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._m * 16.0);
            d8 = dwan2.func_94207_b(this._k * 16.0);
            d9 = dwan2.func_94207_b(this._j * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._t = 0;
            this._c = false;
        }
        d4 = d + this._h;
        double d13 = d2 + this._j;
        double d14 = d2 + this._k;
        double d15 = d3 + this._l;
        double d16 = d3 + this._m;
        if (this._w) {
            htvf2.func_78386_a(this.__ap, this.__at, this.__ax);
            htvf2.func_78380_c(this.__al);
            htvf2.func_78374_a(d4, d14, d16, d5, d11);
            htvf2.func_78386_a(this.__aq, this.__au, this.__ay);
            htvf2.func_78380_c(this.__am);
            htvf2.func_78374_a(d4, d14, d15, d6, d8);
            htvf2.func_78386_a(this.__ar, this.__av, this.__az);
            htvf2.func_78380_c(this.__an);
            htvf2.func_78374_a(d4, d13, d15, d10, d12);
            htvf2.func_78386_a(this.__as, this.__aw, this.__aA);
            htvf2.func_78380_c(this.__ao);
            htvf2.func_78374_a(d4, d13, d16, d7, d9);
        } else {
            htvf2.func_78374_a(d4, d14, d16, d5, d11);
            htvf2.func_78374_a(d4, d14, d15, d6, d8);
            htvf2.func_78374_a(d4, d13, d15, d10, d12);
            htvf2.func_78374_a(d4, d13, d16, d7, d9);
        }
    }

    public void _f(twgu twgu2, double d, double d2, double d3, dwan dwan2) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        htvf htvf2 = this.__aF;
        if (this._b()) {
            dwan2 = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._s == 0) {
            dwan2 = ConnectedTextures.getConnectedTexture(this._a, twgu2, (int)d, (int)d2, (int)d3, 5, dwan2);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._s == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(dwan2)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 5);
            if (naturalProperties.rotation > 1) {
                this._s = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._s = this._s / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = dwan2.func_94214_a(this._l * 16.0);
        double d7 = dwan2.func_94214_a(this._m * 16.0);
        double d8 = dwan2.func_94207_b(16.0 - this._k * 16.0);
        double d9 = dwan2.func_94207_b(16.0 - this._j * 16.0);
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if (this._l < 0.0 || this._m > 1.0) {
            d6 = dwan2.func_94209_e();
            d7 = dwan2.func_94212_f();
        }
        if (this._j < 0.0 || this._k > 1.0) {
            d8 = dwan2.func_94206_g();
            d9 = dwan2.func_94210_h();
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._s == 2) {
            d6 = dwan2.func_94214_a(this._j * 16.0);
            d8 = dwan2.func_94207_b(16.0 - this._l * 16.0);
            d7 = dwan2.func_94214_a(this._k * 16.0);
            d9 = dwan2.func_94207_b(16.0 - this._m * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._s == 1) {
            d6 = dwan2.func_94214_a(16.0 - this._k * 16.0);
            d8 = dwan2.func_94207_b(this._m * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._j * 16.0);
            d9 = dwan2.func_94207_b(this._l * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._s == 3) {
            d6 = dwan2.func_94214_a(16.0 - this._l * 16.0);
            d7 = dwan2.func_94214_a(16.0 - this._m * 16.0);
            d8 = dwan2.func_94207_b(this._k * 16.0);
            d9 = dwan2.func_94207_b(this._j * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._s = 0;
            this._c = false;
        }
        d4 = d + this._i;
        double d13 = d2 + this._j;
        double d14 = d2 + this._k;
        double d15 = d3 + this._l;
        double d16 = d3 + this._m;
        if (this._w) {
            htvf2.func_78386_a(this.__ap, this.__at, this.__ax);
            htvf2.func_78380_c(this.__al);
            htvf2.func_78374_a(d4, d13, d16, d10, d12);
            htvf2.func_78386_a(this.__aq, this.__au, this.__ay);
            htvf2.func_78380_c(this.__am);
            htvf2.func_78374_a(d4, d13, d15, d7, d9);
            htvf2.func_78386_a(this.__ar, this.__av, this.__az);
            htvf2.func_78380_c(this.__an);
            htvf2.func_78374_a(d4, d14, d15, d5, d11);
            htvf2.func_78386_a(this.__as, this.__aw, this.__aA);
            htvf2.func_78380_c(this.__ao);
            htvf2.func_78374_a(d4, d14, d16, d6, d8);
        } else {
            htvf2.func_78374_a(d4, d13, d16, d10, d12);
            htvf2.func_78374_a(d4, d13, d15, d7, d9);
            htvf2.func_78374_a(d4, d14, d15, d5, d11);
            htvf2.func_78374_a(d4, d14, d16, d6, d8);
        }
    }

    public void _a(twgu twgu2, int n, float f) {
        float f2;
        float f3;
        float f4;
        int n2;
        boolean bl;
        htvf htvf2 = this.__aF;
        boolean bl2 = bl = twgu2.field_71990_ca == twgu.field_71980_u.field_71990_ca;
        if (twgu2 == twgu.field_71958_P || twgu2 == twgu.field_96469_cy || twgu2 == twgu.field_72051_aB) {
            n = 3;
        }
        if (this._g) {
            n2 = twgu2.func_71889_f_(n);
            if (bl) {
                n2 = 0xFFFFFF;
            }
            f4 = (float)(n2 >> 16 & 0xFF) / 255.0f;
            f3 = (float)(n2 >> 8 & 0xFF) / 255.0f;
            f2 = (float)(n2 & 0xFF) / 255.0f;
            GL11.glColor4f(f4 * f, f3 * f, f2 * f, 1.0f);
        }
        n2 = twgu2.func_71857_b();
        this._a(twgu2);
        if (n2 != 0 && n2 != 31 && n2 != 39 && n2 != 16 && n2 != 26) {
            if (n2 == 1) {
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                this._a(twgu2, n, -0.5, -0.5, -0.5, 1.0f);
                htvf2.func_78381_a();
            } else if (n2 == 19) {
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                twgu2.func_71919_f();
                this._a(twgu2, n, this._k, -0.5, -0.5, -0.5);
                htvf2.func_78381_a();
            } else if (n2 == 23) {
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                twgu2.func_71919_f();
                htvf2.func_78381_a();
            } else if (n2 == 13) {
                twgu2.func_71919_f();
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                f4 = 0.0625f;
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                this._a(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 0));
                htvf2.func_78381_a();
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
                this._b(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 1));
                htvf2.func_78381_a();
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
                htvf2.func_78372_c(0.0f, 0.0f, f4);
                this._c(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 2));
                htvf2.func_78372_c(0.0f, 0.0f, -f4);
                htvf2.func_78381_a();
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
                htvf2.func_78372_c(0.0f, 0.0f, -f4);
                this._d(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 3));
                htvf2.func_78372_c(0.0f, 0.0f, f4);
                htvf2.func_78381_a();
                htvf2.func_78382_b();
                htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
                htvf2.func_78372_c(f4, 0.0f, 0.0f);
                this._e(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 4));
                htvf2.func_78372_c(-f4, 0.0f, 0.0f);
                htvf2.func_78381_a();
                htvf2.func_78382_b();
                htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
                htvf2.func_78372_c(-f4, 0.0f, 0.0f);
                this._f(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 5));
                htvf2.func_78372_c(f4, 0.0f, 0.0f);
                htvf2.func_78381_a();
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            } else if (n2 == 22) {
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                nvde._a._a(twgu2, n, f);
                GL11.glEnable(32826);
            } else if (n2 == 6) {
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                this._a(twgu2, n, -0.5, -0.5, -0.5);
                htvf2.func_78381_a();
            } else if (n2 == 2) {
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                this._a(twgu2, -0.5, -0.5, -0.5, 0.0, 0.0, 0);
                htvf2.func_78381_a();
            } else if (n2 == 10) {
                for (int i = 0; i < 2; ++i) {
                    if (i == 0) {
                        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 0.5);
                    }
                    if (i == 1) {
                        this._a(0.0, 0.0, 0.5, 1.0, 0.5, 1.0);
                    }
                    GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                    this._a(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 0));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
                    this._b(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 1));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
                    this._c(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 2));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
                    this._d(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 3));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
                    this._e(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 4));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
                    this._f(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 5));
                    htvf2.func_78381_a();
                    GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                }
            } else if (n2 == 27) {
                int n3 = 0;
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                htvf2.func_78382_b();
                for (int i = 0; i < 8; ++i) {
                    int n4 = 0;
                    int n5 = 1;
                    if (i == 0) {
                        n4 = 2;
                    }
                    if (i == 1) {
                        n4 = 3;
                    }
                    if (i == 2) {
                        n4 = 4;
                    }
                    if (i == 3) {
                        n4 = 5;
                        n5 = 2;
                    }
                    if (i == 4) {
                        n4 = 6;
                        n5 = 3;
                    }
                    if (i == 5) {
                        n4 = 7;
                        n5 = 5;
                    }
                    if (i == 6) {
                        n4 = 6;
                        n5 = 2;
                    }
                    if (i == 7) {
                        n4 = 3;
                    }
                    float f5 = (float)n4 / 16.0f;
                    float f6 = 1.0f - (float)n3 / 16.0f;
                    float f7 = 1.0f - (float)(n3 + n5) / 16.0f;
                    n3 += n5;
                    this._a(0.5f - f5, f7, (double)(0.5f - f5), (double)(0.5f + f5), (double)f6, (double)(0.5f + f5));
                    htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                    this._a(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 0));
                    htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
                    this._b(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 1));
                    htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
                    this._c(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 2));
                    htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
                    this._d(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 3));
                    htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
                    this._e(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 4));
                    htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
                    this._f(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 5));
                }
                htvf2.func_78381_a();
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (n2 == 11) {
                for (int i = 0; i < 4; ++i) {
                    f3 = 0.125f;
                    if (i == 0) {
                        this._a(0.5f - f3, 0.0, 0.0, (double)(0.5f + f3), 1.0, (double)(f3 * 2.0f));
                    }
                    if (i == 1) {
                        this._a(0.5f - f3, 0.0, (double)(1.0f - f3 * 2.0f), (double)(0.5f + f3), 1.0, 1.0);
                    }
                    f3 = 0.0625f;
                    if (i == 2) {
                        this._a(0.5f - f3, 1.0f - f3 * 3.0f, (double)(-f3 * 2.0f), (double)(0.5f + f3), (double)(1.0f - f3), (double)(1.0f + f3 * 2.0f));
                    }
                    if (i == 3) {
                        this._a(0.5f - f3, 0.5f - f3 * 3.0f, (double)(-f3 * 2.0f), (double)(0.5f + f3), (double)(0.5f - f3), (double)(1.0f + f3 * 2.0f));
                    }
                    GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                    this._a(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 0));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
                    this._b(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 1));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
                    this._c(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 2));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
                    this._d(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 3));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
                    this._e(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 4));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
                    this._f(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 5));
                    htvf2.func_78381_a();
                    GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                }
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (n2 == 21) {
                for (int i = 0; i < 3; ++i) {
                    f3 = 0.0625f;
                    if (i == 0) {
                        this._a(0.5f - f3, 0.3f, 0.0, (double)(0.5f + f3), 1.0, (double)(f3 * 2.0f));
                    }
                    if (i == 1) {
                        this._a(0.5f - f3, 0.3f, (double)(1.0f - f3 * 2.0f), (double)(0.5f + f3), 1.0, 1.0);
                    }
                    f3 = 0.0625f;
                    if (i == 2) {
                        this._a(0.5f - f3, 0.5, 0.0, (double)(0.5f + f3), (double)(1.0f - f3), 1.0);
                    }
                    GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                    this._a(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 0));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
                    this._b(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 1));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
                    this._c(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 2));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
                    this._d(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 3));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
                    this._e(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 4));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
                    this._f(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 5));
                    htvf2.func_78381_a();
                    GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                }
            } else if (n2 == 32) {
                for (int i = 0; i < 2; ++i) {
                    if (i == 0) {
                        this._a(0.0, 0.0, 0.3125, 1.0, 0.8125, 0.6875);
                    }
                    if (i == 1) {
                        this._a(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
                    }
                    GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                    this._a(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 0, n));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
                    this._b(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 1, n));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
                    this._c(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 2, n));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
                    this._d(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 3, n));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
                    this._e(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 4, n));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
                    this._f(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 5, n));
                    htvf2.func_78381_a();
                    GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                }
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (n2 == 35) {
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                this._a((scce)twgu2, 0, 0, 0, n << 2, true);
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            } else if (n2 == 34) {
                for (int i = 0; i < 3; ++i) {
                    if (i == 0) {
                        this._a(0.125, 0.0, 0.125, 0.875, 0.1875, 0.875);
                        this._a(this._b(twgu.field_72089_ap));
                    } else if (i == 1) {
                        this._a(0.1875, 0.1875, 0.1875, 0.8125, 0.875, 0.8125);
                        this._a(this._b(twgu.field_82518_cd));
                    } else if (i == 2) {
                        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
                        this._a(this._b(twgu.field_71946_M));
                    }
                    GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                    this._a(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 0, n));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
                    this._b(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 1, n));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
                    this._c(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 2, n));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
                    this._d(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 3, n));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
                    this._e(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 4, n));
                    htvf2.func_78381_a();
                    htvf2.func_78382_b();
                    htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
                    this._f(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 5, n));
                    htvf2.func_78381_a();
                    GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                }
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
                this._a();
            } else if (n2 == 38) {
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                this._a((ndvl)twgu2, 0, 0, 0, 0, true);
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            } else if (Reflector.ModLoader.exists()) {
                Reflector.callVoid(Reflector.ModLoader_renderInvBlock, this, twgu2, n, n2);
            } else if (Reflector.FMLRenderAccessLibrary.exists()) {
                Reflector.callVoid(Reflector.FMLRenderAccessLibrary_renderInventoryBlock, this, twgu2, n, n2);
            }
        } else {
            if (n2 == 16) {
                n = 1;
            }
            twgu2.func_71919_f();
            this._a(twgu2);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
            this._a(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 0, n));
            htvf2.func_78381_a();
            if (bl && this._g) {
                int n6 = twgu2.func_71889_f_(n);
                f3 = (float)(n6 >> 16 & 0xFF) / 255.0f;
                f2 = (float)(n6 >> 8 & 0xFF) / 255.0f;
                float f8 = (float)(n6 & 0xFF) / 255.0f;
                GL11.glColor4f(f3 * f, f2 * f, f8 * f, 1.0f);
            }
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
            this._b(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 1, n));
            htvf2.func_78381_a();
            if (bl && this._g) {
                GL11.glColor4f(f, f, f, 1.0f);
            }
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
            this._c(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 2, n));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
            this._d(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 3, n));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
            this._e(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 4, n));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
            this._f(twgu2, 0.0, 0.0, 0.0, this._a(twgu2, 5, n));
            htvf2.func_78381_a();
            GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        }
    }

    public static boolean _a(int n) {
        switch (n) {
            case 0: 
            case 10: 
            case 11: 
            case 13: 
            case 16: 
            case 21: 
            case 22: 
            case 26: 
            case 27: 
            case 31: 
            case 32: 
            case 34: 
            case 35: 
            case 39: {
                return true;
            }
        }
        return Reflector.ModLoader.exists() ? Reflector.callBoolean(Reflector.ModLoader_renderBlockIsItemFull3D, n) : (Reflector.FMLRenderAccessLibrary.exists() ? Reflector.callBoolean(Reflector.FMLRenderAccessLibrary_renderItemAsFull3DBlock, n) : false);
    }

    public dwan _a(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, int n4) {
        return this._b(twgu2.func_71895_b(sdrg2, n, n2, n3, n4));
    }

    public dwan _a(twgu twgu2, int n, int n2) {
        return this._b(twgu2.func_71858_a(n, n2));
    }

    public dwan _a(twgu twgu2, int n) {
        return this._b(twgu2.func_71851_a(n));
    }

    public dwan _b(twgu twgu2) {
        return this._b(twgu2.func_71851_a(1));
    }

    public dwan _b(dwan dwan2) {
        if (dwan2 == null) {
            dwan2 = ((sctd)xpzm._E()._R()._b(sctd._c))._d("missingno");
        }
        return dwan2;
    }

    public float _a(sdrg sdrg2, int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[sdrg2.func_72798_a(n, n2, n3)];
        if (twgu2 == null) {
            return 1.0f;
        }
        boolean bl = twgu2.field_72018_cp._c() && twgu2.func_71886_c();
        return bl ? this.__aC : 1.0f;
    }

    public dwan _a(dwan dwan2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if ((dwan2 == TextureUtils.iconGrassSide || dwan2 == TextureUtils.iconMyceliumSide) && (dwan2 = Config.getSideGrassTexture(this._a, n, n2, n3, n4, dwan2)) == TextureUtils.iconGrassTop) {
            this.__ap *= f;
            this.__aq *= f;
            this.__ar *= f;
            this.__as *= f;
            this.__at *= f2;
            this.__au *= f2;
            this.__av *= f2;
            this.__aw *= f2;
            this.__ax *= f3;
            this.__ay *= f3;
            this.__az *= f3;
            this.__aA *= f3;
        }
        if (dwan2 == TextureUtils.iconGrassSideSnowed) {
            dwan2 = Config.getSideSnowGrassTexture(this._a, n, n2, n3, n4);
        }
        return dwan2;
    }

    public boolean _a(int n, int n2, int n3) {
        int n4 = twgu.field_72037_aS.field_71990_ca;
        return this._a.func_72798_a(n - 1, n2, n3) != n4 && this._a.func_72798_a(n + 1, n2, n3) != n4 && this._a.func_72798_a(n, n2, n3 - 1) != n4 && this._a.func_72798_a(n, n2, n3 + 1) != n4 ? false : this._a.func_72804_r(n, n2 - 1, n3);
    }

    public void _a(int n, int n2, int n3, double d) {
        if (this.__aD) {
            this._a(twgu.field_72037_aS);
            this._k = d;
            this._q(twgu.field_72037_aS, n, n2, n3);
        }
    }
}

