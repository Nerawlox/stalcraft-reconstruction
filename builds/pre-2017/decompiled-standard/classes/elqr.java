/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class elqr
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ tycn _c;

    public elqr(tycn tycn2, int n, int n2) {
        this._c = tycn2;
        this._a = n;
        this._b = n2;
    }

    public String _a() {
        return String.valueOf(jjym._a(this._a, this._b));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

