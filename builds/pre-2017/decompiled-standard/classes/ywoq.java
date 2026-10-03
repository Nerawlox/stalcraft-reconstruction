/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class ywoq
implements Callable {
    public final /* synthetic */ iyev _a;

    public ywoq(iyev iyev2) {
        this._a = iyev2;
    }

    public String _a() {
        return String.format("%d game time, %d day time", iyev._g(this._a), iyev._h(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

