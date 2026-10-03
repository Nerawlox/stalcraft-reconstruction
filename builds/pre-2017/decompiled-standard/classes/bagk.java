/*
 * Decompiled with CFR 0.152.
 */
public class bagk
extends ccvh {
    private final jzak _d;

    public bagk(jzak jzak2, mssh mssh2, int n, int n2, int n3, int n4) {
        super(jzak2, mssh2, n, n2, n3, n4);
        this._d = jzak2;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        if (cvzo2 != null && cvzo2._a() instanceof dgmz && !((dgmz)cvzo2._a())._k(this._d.backpackSlot.func_75211_c())) {
            return false;
        }
        return super.func_75214_a(cvzo2);
    }
}

