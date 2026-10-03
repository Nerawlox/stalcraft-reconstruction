/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.dwan;

public class hddy
extends mbpd {
    public hddy(int n) {
        super(n);
        this.func_77656_e(0);
        this.func_77627_a(true);
    }

    @Override
    public int func_77647_b(int n) {
        return n | 4;
    }

    @Override
    public dwan func_77617_a(int n) {
        return twgu.field_71952_K.func_71858_a(0, n);
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        int n2 = cvzo2._j();
        if ((n2 & 1) == 1) {
            return igvq._a();
        }
        if ((n2 & 2) == 2) {
            return igvq._b();
        }
        return igvq._c();
    }

    @Override
    public String func_77667_c(cvzo cvzo2) {
        int n = cvzo2._j();
        if (n < 0 || n >= marn._a.length) {
            n = 0;
        }
        return super.func_77658_a() + "." + marn._a[n];
    }
}

