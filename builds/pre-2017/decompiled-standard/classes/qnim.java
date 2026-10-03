/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;
import net.minecraft.client.xpzm;

public class qnim
extends TimerTask {
    public rqmi _a;
    public final /* synthetic */ ifqv _b;

    public qnim(ifqv ifqv2) {
        this._b = ifqv2;
    }

    @Override
    public void run() {
        if (!ifqv._a(this._b)) {
            this._c();
            this._a();
            this._b();
        }
    }

    public void _a() {
        try {
            if (ifqv._b(this._b) != null) {
                this._a = new rqmi(ifqv._b(this._b));
                List list2 = this._a._a()._a;
                if (list2 != null) {
                    this._a(list2);
                    ifqv._a(this._b, list2);
                }
            }
        }
        catch (twsl twsl2) {
            xpzm._E()._O()._c(twsl2.toString());
        }
        catch (IOException iOException) {
            xpzm._E()._O()._b("Realms: could not parse response from server");
        }
    }

    public void _b() {
        try {
            if (ifqv._b(this._b) != null) {
                int n = this._a._f();
                ifqv._a(this._b, n);
            }
        }
        catch (twsl twsl2) {
            xpzm._E()._O()._c(twsl2.toString());
        }
    }

    public void _c() {
        try {
            if (ifqv._b(this._b) != null) {
                rqmi rqmi2 = new rqmi(ifqv._b(this._b));
                ifqv._b(this._b, rqmi2._d());
            }
        }
        catch (twsl twsl2) {
            xpzm._E()._O()._c(twsl2.toString());
            ifqv._b(this._b, 0);
        }
    }

    public void _a(List list2) {
        Collections.sort(list2, new yvap(this, ifqv._b(this._b)._a(), null));
    }

    public /* synthetic */ qnim(ifqv ifqv2, dyfm dyfm2) {
        this(ifqv2);
    }
}

