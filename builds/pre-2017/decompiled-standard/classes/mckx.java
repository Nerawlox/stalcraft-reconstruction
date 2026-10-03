/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class mckx
implements Callable {
    public final /* synthetic */ iyev _a;

    public mckx(iyev iyev2) {
        this._a = iyev2;
    }

    public String _a() {
        return String.format("ID %02d - %s, ver %d. Features enabled: %b", iyev._a(this._a)._g(), iyev._a(this._a)._a(), iyev._a(this._a)._c(), iyev._b(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

