/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.dwan;

public class jina
extends twgu {
    public static final String[] _a = new String[]{"default", "chiseled", "lines"};
    public static final String[] _b = new String[]{"side", "chiseled", "lines", null, null};
    public dwan[] _c;
    public dwan _d;
    public dwan _e;
    public dwan _f;
    public dwan _g;

    public jina(int n) {
        super(n, tflj._e);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n2 == 2 || n2 == 3 || n2 == 4) {
            if (n2 == 2 && (n == 1 || n == 0)) {
                return this._e;
            }
            if (n2 == 3 && (n == 5 || n == 4)) {
                return this._e;
            }
            if (n2 == 4 && (n == 2 || n == 3)) {
                return this._e;
            }
            return this._c[n2];
        }
        if (n == 1 || n == 0 && n2 == 1) {
            if (n2 == 1) {
                return this._d;
            }
            return this._f;
        }
        if (n == 0) {
            return this._g;
        }
        if (n2 < 0 || n2 >= this._c.length) {
            n2 = 0;
        }
        return this._c[n2];
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        if (n5 == 2) {
            switch (n4) {
                case 2: 
                case 3: {
                    n5 = 4;
                    break;
                }
                case 4: 
                case 5: {
                    n5 = 3;
                    break;
                }
                case 0: 
                case 1: {
                    n5 = 2;
                }
            }
        }
        return n5;
    }

    @Override
    public int func_71899_b(int n) {
        if (n == 3 || n == 4) {
            return 2;
        }
        return n;
    }

    @Override
    public cvzo func_71880_c_(int n) {
        if (n == 3 || n == 4) {
            return new cvzo(this.field_71990_ca, 1, 2);
        }
        return super.func_71880_c_(n);
    }

    @Override
    public int func_71857_b() {
        return 39;
    }

    @Override
    public void func_71879_a(int n, tgbl tgbl2, List list2) {
        list2.add(new cvzo(n, 1, 0));
        list2.add(new cvzo(n, 1, 1));
        list2.add(new cvzo(n, 1, 2));
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._c = new dwan[_b.length];
        for (int i = 0; i < this._c.length; ++i) {
            this._c[i] = _b[i] == null ? this._c[i - 1] : nege2._b(this.func_111023_E() + "_" + _b[i]);
        }
        this._f = nege2._b(this.func_111023_E() + "_" + "top");
        this._d = nege2._b(this.func_111023_E() + "_" + "chiseled_top");
        this._e = nege2._b(this.func_111023_E() + "_" + "lines_top");
        this._g = nege2._b(this.func_111023_E() + "_" + "bottom");
    }
}

