/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class hukt
implements Callable {
    public final /* synthetic */ cezg _a;
    public final /* synthetic */ xbvu _b;

    public hukt(xbvu xbvu2, cezg cezg2) {
        this._b = xbvu2;
        this._a = cezg2;
    }

    public String _a() {
        return this._a.getClass().getCanonicalName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

