/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.dwan;

public class bsum
extends mbpd {
    public final twgu _a = twgu.field_71973_m[this.func_77883_f()];
    public String[] _b;

    public bsum(int n, boolean bl) {
        super(n);
        if (bl) {
            this.func_77656_e(0);
            this.func_77627_a(true);
        }
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        return this._a.func_71889_f_(cvzo2._j());
    }

    @Override
    public dwan func_77617_a(int n) {
        return this._a.func_71858_a(0, n);
    }

    @Override
    public int func_77647_b(int n) {
        return n;
    }

    public bsum _a(String[] stringArray) {
        this._b = stringArray;
        return this;
    }

    @Override
    public String func_77667_c(cvzo cvzo2) {
        if (this._b == null) {
            return super.func_77667_c(cvzo2);
        }
        int n = cvzo2._j();
        if (n >= 0 && n < this._b.length) {
            return super.func_77667_c(cvzo2) + "." + this._b[n];
        }
        return super.func_77667_c(cvzo2);
    }
}

