/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.dwan;

public class tfit
extends twgu {
    public static final String[] _a = new String[]{"default", "mossy", "cracked", "chiseled"};
    public static final String[] _b = new String[]{null, "mossy", "cracked", "carved"};
    public dwan[] _c;

    public tfit(int n) {
        super(n, tflj._e);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n2 < 0 || n2 >= _b.length) {
            n2 = 0;
        }
        return this._c[n2];
    }

    @Override
    public int func_71899_b(int n) {
        return n;
    }

    @Override
    public void func_71879_a(int n, tgbl tgbl2, List list) {
        for (int i = 0; i < 4; ++i) {
            list.add(new cvzo(n, 1, i));
        }
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._c = new dwan[_b.length];
        for (int i = 0; i < this._c.length; ++i) {
            String string = this.func_111023_E();
            if (_b[i] != null) {
                string = string + "_" + _b[i];
            }
            this._c[i] = nege2._b(string);
        }
    }
}

