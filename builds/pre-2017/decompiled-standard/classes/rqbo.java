/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.dwan;

public class rqbo
extends nuuf {
    public dwan[] _a;

    public rqbo(int n) {
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
        return tgdv.field_82794_bL.field_77779_bT;
    }

    @Override
    public int _b() {
        return tgdv.field_82794_bL.field_77779_bT;
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        super.func_71914_a(ozlu2, n, n2, n3, n4, f, n5);
        if (ozlu2.field_72995_K) {
            return;
        }
        if (n4 >= 7 && ozlu2.field_73012_v.nextInt(50) == 0) {
            this.func_71929_a(ozlu2, n, n2, n3, new cvzo(tgdv.field_82800_bN));
        }
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._a = new dwan[4];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = nege2._b(this.func_111023_E() + "_stage_" + i);
        }
    }
}

