/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class nwlw
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ tycn _c;

    public nwlw(tycn tycn2, int n, int n2) {
        this._c = tycn2;
        this._a = n;
        this._b = n2;
    }

    public String _a() {
        return this._c._a(this._a, this._b) ? "True" : "False";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

