/*
 * Decompiled with CFR 0.152.
 */
public class ndjp
extends rpbk {
    public ndjp(jzak jzak2, mssh mssh2, int n, int n2, int n3) {
        super(jzak2, mssh2, n, n2, n3);
        this._b = jzak2;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        cvzo cvzo3 = this._a().getArmorSlots().get(2).func_75211_c();
        return cvzo2._a() instanceof brhe && (cvzo3 == null || !(cvzo3._a() instanceof dgmz) || ((dgmz)cvzo3._a())._k(cvzo2));
    }

    @Override
    public int func_75219_a() {
        return 1;
    }

    public jzak _a() {
        return (jzak)this._b;
    }
}

