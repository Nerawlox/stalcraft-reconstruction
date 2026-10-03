/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class gavt
implements Callable {
    public final /* synthetic */ tycn _a;

    public gavt(tycn tycn2) {
        this._a = tycn2;
    }

    public String _a() {
        return this._a.getClass().getCanonicalName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

