/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.dwan;

public class wopv
extends twgu {
    public static final String[] _a = new String[]{"skin_brown", "skin_red"};
    public final int _b;
    public dwan[] _c;
    public dwan _d;
    public dwan _e;

    public wopv(int n, tflj tflj2, int n2) {
        super(n, tflj2);
        this._b = n2;
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n2 == 10 && n > 1) {
            return this._d;
        }
        if (n2 >= 1 && n2 <= 9 && n == 1) {
            return this._c[this._b];
        }
        if (n2 >= 1 && n2 <= 3 && n == 2) {
            return this._c[this._b];
        }
        if (n2 >= 7 && n2 <= 9 && n == 3) {
            return this._c[this._b];
        }
        if ((n2 == 1 || n2 == 4 || n2 == 7) && n == 4) {
            return this._c[this._b];
        }
        if ((n2 == 3 || n2 == 6 || n2 == 9) && n == 5) {
            return this._c[this._b];
        }
        if (n2 == 14) {
            return this._c[this._b];
        }
        if (n2 == 15) {
            return this._d;
        }
        return this._e;
    }

    @Override
    public int func_71925_a(Random random) {
        int n = random.nextInt(10) - 7;
        if (n < 0) {
            n = 0;
        }
        return n;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_72109_af.field_71990_ca + this._b;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return twgu.field_72109_af.field_71990_ca + this._b;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._c = new dwan[_a.length];
        for (int i = 0; i < this._c.length; ++i) {
            this._c[i] = nege2._b(this.func_111023_E() + "_" + _a[i]);
        }
        this._e = nege2._b(this.func_111023_E() + "_" + "inside");
        this._d = nege2._b(this.func_111023_E() + "_" + "skin_stem");
    }
}

