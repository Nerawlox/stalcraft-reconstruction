/*
 * Decompiled with CFR 0.152.
 */
import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.gui.GuiDisconnected;

public class dhgx
extends Thread {
    public final /* synthetic */ String _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ fnnc _c;

    public dhgx(fnnc fnnc2, String string, int n) {
        this._c = fnnc2;
        this._a = string;
        this._b = n;
    }

    @Override
    public void run() {
        try {
            fnnc._a(this._c, new bscn(fnnc._a(this._c), this._a, this._b));
            if (fnnc._b(this._c)) {
                return;
            }
            fnnc._d(this._c)._b(new yezn(78, fnnc._c(this._c)._P()._a(), this._a, this._b));
        }
        catch (UnknownHostException unknownHostException) {
            if (fnnc._b(this._c)) {
                return;
            }
            fnnc._f(this._c)._a(new GuiDisconnected(fnnc._e(this._c), "connect.failed", "disconnect.genericReason", "Unknown host '" + this._a + "'"));
        }
        catch (ConnectException connectException) {
            if (fnnc._b(this._c)) {
                return;
            }
            fnnc._g(this._c)._a(new GuiDisconnected(fnnc._e(this._c), "connect.failed", "disconnect.genericReason", connectException.getMessage()));
        }
        catch (Exception exception) {
            if (fnnc._b(this._c)) {
                return;
            }
            exception.printStackTrace();
            fnnc._h(this._c)._a(new GuiDisconnected(fnnc._e(this._c), "connect.failed", "disconnect.genericReason", exception.toString()));
        }
    }
}

