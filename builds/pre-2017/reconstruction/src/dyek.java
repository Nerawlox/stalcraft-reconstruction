/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoServer;

public class dyek
extends Thread {
    public final /* synthetic */ htmo _a;

    public dyek(htmo htmo2) {
        this._a = htmo2;
    }

    @Override
    public void run() {
        try {
            McoServer mcoServer = htmo._a(this._a, htmo._a(this._a));
            if (mcoServer != null) {
                rqmi rqmi2 = new rqmi(htmo._b(this._a)._P());
                htmo._d()._a(mcoServer);
                htmo._c(this._a).remove(mcoServer);
                rqmi2._c(mcoServer._a);
                htmo._d()._a(mcoServer);
                htmo._c(this._a).remove(mcoServer);
                htmo._d(this._a);
            }
        }
        catch (ExceptionMcoService exceptionMcoService) {
            htmo._e(this._a)._O()._c(exceptionMcoService.toString());
        }
    }
}

