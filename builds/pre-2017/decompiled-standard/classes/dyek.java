/*
 * Decompiled with CFR 0.152.
 */
public class dyek
extends Thread {
    public final /* synthetic */ htmo _a;

    public dyek(htmo htmo2) {
        this._a = htmo2;
    }

    @Override
    public void run() {
        try {
            rqmh rqmh2 = htmo._a(this._a, htmo._a(this._a));
            if (rqmh2 != null) {
                rqmi rqmi2 = new rqmi(htmo._b(this._a)._P());
                htmo._d()._a(rqmh2);
                htmo._c(this._a).remove(rqmh2);
                rqmi2._c(rqmh2._a);
                htmo._d()._a(rqmh2);
                htmo._c(this._a).remove(rqmh2);
                htmo._d(this._a);
            }
        }
        catch (twsl twsl2) {
            htmo._e(this._a)._O()._c(twsl2.toString());
        }
    }
}

