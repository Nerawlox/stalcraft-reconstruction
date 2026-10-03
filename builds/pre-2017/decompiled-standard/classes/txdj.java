/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.passive.EntityHorse;

public class txdj
extends yeso {
    public final /* synthetic */ EntityHorse _a;
    public final /* synthetic */ qnzl _b;

    public txdj(qnzl qnzl2, mssh mssh2, int n, int n2, int n3, EntityHorse entityHorse) {
        this._b = qnzl2;
        this._a = entityHorse;
        super(mssh2, n, n2, n3);
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return super.func_75214_a(cvzo2) && this._a.func_110259_cr() && EntityHorse.func_110211_v(cvzo2._d);
    }

    @Override
    public boolean func_111238_b() {
        return this._a.func_110259_cr();
    }
}

