/*
 * Decompiled with CFR 0.152.
 */
public class twsv
extends dydp {
    public final scnn _b;
    public final /* synthetic */ scox _c;

    public twsv(scox scox2, scnn scnn2) {
        this._c = scox2;
        this._b = scnn2;
    }

    @Override
    public void run() {
        this._b(wpcz._a("mco.backup.restoring"));
        try {
            rqmi rqmi2 = new rqmi(this._a()._P());
            rqmi2._c(scox._b(this._c), this._b._a);
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            this._a()._a(scox._d(this._c));
        }
        catch (twsl twsl2) {
            scox._e(this._c)._O()._c(twsl2.toString());
            this._a(twsl2.toString());
        }
        catch (Exception exception) {
            this._a(exception.getLocalizedMessage());
        }
    }

    public /* synthetic */ twsv(scox scox2, scnn scnn2, nvcw nvcw2) {
        this(scox2, scnn2);
    }
}

