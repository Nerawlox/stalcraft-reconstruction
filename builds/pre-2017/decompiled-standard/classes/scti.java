/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class scti
implements Callable {
    public final /* synthetic */ sctg _a;
    public final /* synthetic */ apbu _b;

    public scti(apbu apbu2, sctg sctg2) {
        this._b = apbu2;
        this._a = sctg2;
    }

    public String _a() {
        return this._a.getClass().getName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

