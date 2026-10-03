/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.dwan;

public class iwkf
extends twgu {
    public static final String[] _a = new String[]{"oak", "spruce", "birch", "jungle"};
    public dwan[] _b;

    public iwkf(int n) {
        super(n, tflj._d);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n2 < 0 || n2 >= this._b.length) {
            n2 = 0;
        }
        return this._b[n2];
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
        list2.add(new cvzo(n, 1, 3));
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._b = new dwan[_a.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = nege2._b(this.func_111023_E() + "_" + _a[i]);
        }
    }
}

