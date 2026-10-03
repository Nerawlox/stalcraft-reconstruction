/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import net.minecraft.client.xpzm;

public class gqmb
extends dydp {
    public bscn _b;
    public final rqmh _c;
    public final gqjz _d;

    public gqmb(gqjz gqjz2, rqmh rqmh2) {
        this._d = gqjz2;
        this._c = rqmh2;
    }

    @Override
    public void run() {
        this._b(wpcz._a("mco.connect.connecting"));
        rqmi rqmi2 = new rqmi(this._a()._P());
        boolean bl = false;
        boolean bl2 = false;
        int n = 5;
        vlwy vlwy2 = null;
        for (int i = 0; i < 10 && !this._b(); ++i) {
            try {
                vlwy2 = rqmi2._b(this._c._a);
                bl = true;
            }
            catch (dhdd dhdd2) {
                n = dhdd2._d;
            }
            catch (twsl twsl2) {
                bl2 = true;
                this._a(twsl2.toString());
                xpzm._E()._O()._c(twsl2.toString());
                break;
            }
            catch (IOException iOException) {
                xpzm._E()._O()._b("Realms: could not parse response");
            }
            catch (Exception exception) {
                bl2 = true;
                this._a(exception.getLocalizedMessage());
            }
            if (bl) break;
            this._a(n);
        }
        if (!this._b() && !bl2) {
            if (bl) {
                qnlr qnlr2 = qnlr._a(vlwy2._a);
                this._a(qnlr2._a(), qnlr2._b());
            } else {
                this._a()._a(this._d);
            }
        }
    }

    public void _a(int n) {
        try {
            Thread.sleep(n * 1000);
        }
        catch (InterruptedException interruptedException) {
            xpzm._E()._O()._b(interruptedException.getLocalizedMessage());
        }
    }

    public void _a(String string, int n) {
        new uzts(this, string, n).start();
    }

    @Override
    public void _c() {
        if (this._b != null) {
            this._b._b();
        }
    }

    public static /* synthetic */ bscn _a(gqmb gqmb2, bscn bscn2) {
        gqmb2._b = bscn2;
        return gqmb2._b;
    }

    public static /* synthetic */ gqjz _a(gqmb gqmb2) {
        return gqmb2._d;
    }

    public static /* synthetic */ bscn _b(gqmb gqmb2) {
        return gqmb2._b;
    }
}

