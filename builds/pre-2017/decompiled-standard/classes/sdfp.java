/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class sdfp
implements Callable {
    public final /* synthetic */ String _a;
    public final /* synthetic */ qoac _b;

    public sdfp(qoac qoac2, String string) {
        this._b = qoac2;
        this._a = string;
    }

    public String _a() {
        return huhy._a[((huhy)qoac._a(this._b).get(this._a))._a()];
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

