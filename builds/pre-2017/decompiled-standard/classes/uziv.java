/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.dwan;

public class uziv
extends twgu {
    public dwan[] _a;

    public uziv(int n, tflj tflj2) {
        super(n, tflj2);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        return this._a[n2 % this._a.length];
    }

    @Override
    public int func_71899_b(int n) {
        return n;
    }

    public static int _a(int n) {
        return ~n & 0xF;
    }

    public static int _b(int n) {
        return ~n & 0xF;
    }

    @Override
    public void func_71879_a(int n, tgbl tgbl2, List list) {
        for (int i = 0; i < 16; ++i) {
            list.add(new cvzo(n, 1, i));
        }
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._a = new dwan[16];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = nege2._b(this.func_111023_E() + "_" + hugs._b[uziv._b(i)]);
        }
    }
}

