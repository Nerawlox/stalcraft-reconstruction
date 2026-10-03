/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.crash.jxsn;

public class bcmf
implements Callable {
    public final /* synthetic */ iyev _a;

    public bcmf(iyev iyev2) {
        this._a = iyev2;
    }

    public String _a() {
        return jxsn._a(iyev._d(this._a), iyev._e(this._a), iyev._f(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

