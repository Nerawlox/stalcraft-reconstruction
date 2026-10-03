/*
 * Decompiled with CFR 0.152.
 */
public class sdbw
extends yeso {
    public final tgbu _a;

    public sdbw(tgbu tgbu2, mssh mssh2, int n, int n2, int n3) {
        super(mssh2, n, n2, n3);
        this._a = tgbu2;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return cvzo2 != null ? tgdv.field_77698_e[cvzo2._d].isPotionIngredient(cvzo2) : false;
    }

    @Override
    public int func_75219_a() {
        return 64;
    }
}

