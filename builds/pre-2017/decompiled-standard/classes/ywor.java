/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class ywor
implements Callable {
    public final /* synthetic */ iyev _a;

    public ywor(iyev iyev2) {
        this._a = iyev2;
    }

    public String _a() {
        return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", iyev._k(this._a), iyev._l(this._a), iyev._m(this._a), iyev._n(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

