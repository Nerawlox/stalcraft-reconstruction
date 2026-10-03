/*
 * Decompiled with CFR 0.152.
 */
public class nvcw
extends Thread {
    public final /* synthetic */ scox _a;

    public nvcw(scox scox2) {
        this._a = scox2;
    }

    @Override
    public void run() {
        rqmi rqmi2 = new rqmi(scox._a(this._a)._P());
        try {
            scox._a(this._a, rqmi2._d((long)scox._b((scox)this._a))._a);
        }
        catch (twsl twsl2) {
            scox._c(this._a)._O()._c(twsl2.toString());
        }
    }
}

