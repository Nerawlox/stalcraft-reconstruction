/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.dwan;

public class hcgs
extends twgu {
    public static final String[] _a = new String[]{"default", "chiseled", "smooth"};
    public static final String[] _b = new String[]{"normal", "carved", "smooth"};
    public dwan[] _c;
    public dwan _d;
    public dwan _e;

    public hcgs(int n) {
        super(n, tflj._e);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1 || n == 0 && (n2 == 1 || n2 == 2)) {
            return this._d;
        }
        if (n == 0) {
            return this._e;
        }
        if (n2 < 0 || n2 >= this._c.length) {
            n2 = 0;
        }
        return this._c[n2];
    }

    @Override
    public int func_71899_b(int n) {
        return n;
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
            this._c[i] = nege2._b(this.func_111023_E() + "_" + _b[i]);
        }
        this._d = nege2._b(this.func_111023_E() + "_top");
        this._e = nege2._b(this.func_111023_E() + "_bottom");
    }
}

