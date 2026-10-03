/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class foyo
implements Callable {
    public final /* synthetic */ iyev _a;

    public foyo(iyev iyev2) {
        this._a = iyev2;
    }

    public String _a() {
        return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", iyev._o(this._a)._b(), iyev._o(this._a)._a(), iyev._p(this._a), iyev._q(this._a));
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

