/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;

public interface oxnm {
    default public int _e(cvzo cvzo2) {
        int n = cvzo2._k();
        int n2 = n - cvzo2._j();
        double d = StalkerMiscMod._U;
        int n3 = this._h_(cvzo2);
        if (n3 <= 0) {
            return 0;
        }
        if (n == 0) {
            return n3;
        }
        double d2 = (double)n3 * d + (double)n3 * (1.0 - d) * ((double)n2 / (double)n);
        return (int)Math.round(d2);
    }

    public int _h_(cvzo var1);

    default public String _a() {
        return "stalker:disassembly";
    }
}

