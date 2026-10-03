/*
 * Decompiled with CFR 0.152.
 */
public class ifre
extends dydp {
    public final long _b;
    public final String _c;
    public final ekjj _d;
    public final /* synthetic */ scom _e;

    public ifre(scom scom2, long l, String string, ekjj ekjj2) {
        this._e = scom2;
        this._b = l;
        this._c = string;
        this._d = ekjj2;
    }

    @Override
    public void run() {
        rqmi rqmi2 = new rqmi(this._a()._P());
        String string = wpcz._a("mco.reset.world.resetting.screen.title");
        this._b(string);
        try {
            if (this._d != null) {
                rqmi2._e(this._b, this._d._a);
            } else {
                rqmi2._d(this._b, this._c);
            }
            scom._b(this._e)._a(scom._a(this._e));
        }
        catch (twsl twsl2) {
            scom._c(this._e)._O()._c(twsl2.toString());
            this._a(twsl2.toString());
        }
        catch (Exception exception) {
            scom._d(this._e)._O()._b("Realms: ");
            this._a(exception.toString());
        }
    }
}

