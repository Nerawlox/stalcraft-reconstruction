/*
 * Decompiled with CFR 0.152.
 */
import java.net.ConnectException;
import java.net.UnknownHostException;

public class uzts
extends Thread {
    public final /* synthetic */ String _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ gqmb _c;

    public uzts(gqmb gqmb2, String string, int n) {
        this._c = gqmb2;
        this._a = string;
        this._b = n;
    }

    @Override
    public void run() {
        try {
            gqmb._a(this._c, new bscn(this._c._a(), this._a, this._b, gqmb._a(this._c)));
            if (this._c._b()) {
                return;
            }
            this._c._b(wpcz._a("mco.connect.authorizing"));
            gqmb._b(this._c)._b(new yezn(78, this._c._a()._P()._a(), this._a, this._b));
        }
        catch (UnknownHostException unknownHostException) {
            if (this._c._b()) {
                return;
            }
            this._c._a()._a(new bazq(gqmb._a(this._c), "connect.failed", "disconnect.genericReason", "Unknown host '" + this._a + "'"));
        }
        catch (ConnectException connectException) {
            if (this._c._b()) {
                return;
            }
            this._c._a()._a(new bazq(gqmb._a(this._c), "connect.failed", "disconnect.genericReason", connectException.getMessage()));
        }
        catch (Exception exception) {
            if (this._c._b()) {
                return;
            }
            exception.printStackTrace();
            this._c._a()._a(new bazq(gqmb._a(this._c), "connect.failed", "disconnect.genericReason", exception.toString()));
        }
    }
}

