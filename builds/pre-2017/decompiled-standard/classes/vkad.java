/*
 * Decompiled with CFR 0.152.
 */
public class vkad
extends ccjd {
    @Override
    public void _a(String[] stringArray) {
        vkai vkai2 = this._b()._a;
        long l = 0L;
        for (int i = 0; i < vkai2._e.length; ++i) {
            l += vkai2._e[i];
        }
        double d = (double)l * 1.0E-6 / (double)vkai2._e.length;
        vkai2._b.info("Avg tick time: " + d + " ms");
        vkai2._b.info("Avg tps: " + Math.min(1000.0 / d, 20.0));
    }

    @Override
    public String _a() {
        return "tps";
    }
}

