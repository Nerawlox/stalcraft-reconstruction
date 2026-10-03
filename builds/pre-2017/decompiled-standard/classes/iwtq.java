/*
 * Decompiled with CFR 0.152.
 */
public class iwtq
extends Thread {
    public final /* synthetic */ nvce _a;

    public iwtq(nvce nvce2) {
        this._a = nvce2;
    }

    @Override
    public void run() {
        try {
            rqmi rqmi2 = new rqmi(nvce._c(this._a)._P());
            rqmi2._b(((stoq)nvce._e((nvce)this._a).get((int)nvce._d((nvce)this._a)))._a);
            nvce._f(this._a);
        }
        catch (twsl twsl2) {
            nvce._g(this._a)._O()._c(twsl2.toString());
        }
    }
}

