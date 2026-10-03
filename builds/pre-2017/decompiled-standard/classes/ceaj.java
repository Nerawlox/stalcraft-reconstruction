/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ceaj
extends dydp {
    public final String _b;
    public final String _c;
    public final String _d;
    public final ekjj _e;
    public final /* synthetic */ bsao _f;

    public ceaj(bsao bsao2, String string, String string2, String string3, ekjj ekjj2) {
        this._f = bsao2;
        this._b = string;
        this._c = string2;
        this._d = string3;
        this._e = ekjj2;
    }

    @Override
    public void run() {
        String string = wpcz._a("mco.create.world.wait");
        this._b(string);
        rqmi rqmi2 = new rqmi(bsao._a(this._f)._P());
        try {
            if (this._e != null) {
                rqmi2._a(this._b, this._c, this._d, this._e._a);
            } else {
                rqmi2._a(this._b, this._c, this._d, "-1");
            }
            bsao._c(this._f)._a(bsao._b(this._f));
        }
        catch (twsl twsl2) {
            bsao._d(this._f)._O()._c(twsl2.toString());
            this._a(twsl2.toString());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            bsao._e(this._f)._O()._b("Realms: " + unsupportedEncodingException.getLocalizedMessage());
            this._a(unsupportedEncodingException.getLocalizedMessage());
        }
        catch (IOException iOException) {
            bsao._f(this._f)._O()._b("Realms: could not parse response");
            this._a(iOException.getLocalizedMessage());
        }
        catch (Exception exception) {
            this._a(exception.getLocalizedMessage());
        }
    }
}

