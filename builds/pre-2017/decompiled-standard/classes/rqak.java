/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.dwan;

public class rqak
extends nuuf {
    public dwan[] _a;

    public rqak(int n) {
        super(n);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n2 < 7) {
            if (n2 == 6) {
                n2 = 5;
            }
            return this._a[n2 >> 1];
        }
        return this._a[3];
    }

    @Override
    public int _a() {
        return tgdv.field_82797_bK.field_77779_bT;
    }

    @Override
    public int _b() {
        return tgdv.field_82797_bK.field_77779_bT;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._a = new dwan[4];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = nege2._b(this.func_111023_E() + "_stage_" + i);
        }
    }
}

