/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.dwan;

public class jjkf
extends mbpd {
    public final twgu _a;
    public final String[] _b;

    public jjkf(int n, twgu twgu2, String[] stringArray) {
        super(n);
        this._a = twgu2;
        this._b = stringArray;
        this.func_77656_e(0);
        this.func_77627_a(true);
    }

    @Override
    public dwan func_77617_a(int n) {
        return this._a.func_71858_a(2, n);
    }

    @Override
    public int func_77647_b(int n) {
        return n;
    }

    @Override
    public String func_77667_c(cvzo cvzo2) {
        int n = cvzo2._j();
        if (n < 0 || n >= this._b.length) {
            n = 0;
        }
        return super.func_77658_a() + "." + this._b[n];
    }
}

