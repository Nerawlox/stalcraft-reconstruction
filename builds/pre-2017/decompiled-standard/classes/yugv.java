/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.srok;

public class yugv
extends hsdi {
    public yugv(String string) {
        super(string);
    }

    @Override
    public boolean renderWorldBlock(sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4, htvc htvc2) {
        int n5 = sdrg2.func_72805_g(n, n2, n3);
        long l = srok._a(n, n2, n3);
        float f = (srok._a(l) - 0.5f) * 0.5f + 0.5f;
        float f2 = (srok._b(l) - 0.5f) * 0.5f + 0.5f;
        htvf htvf2 = htvc2.__aF;
        htvf2.func_78372_c((float)n + f, n2, (float)n3 + f2);
        htvf2.func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3));
        this._a(twgu2, n5, htvf2);
        htvf2.func_78372_c((float)(-n) - f, -n2, (float)(-n3) - f2);
        return true;
    }

    protected void _a(twgu twgu2, int n, htvf htvf2) {
        if (n == 2) {
            this.renderWithTessellator(twgu2.func_71858_a(0, n), hsdi.rotation0, htvf2);
        } else if (n == 3) {
            this.renderWithTessellator(twgu2.func_71858_a(0, n), hsdi.rotation270, htvf2);
        } else if (n == 0) {
            this.renderWithTessellator(twgu2.func_71858_a(0, n), hsdi.rotation180, htvf2);
        } else if (n == 1) {
            this.renderWithTessellator(twgu2.func_71858_a(0, n), hsdi.rotation90, htvf2);
        }
    }
}

