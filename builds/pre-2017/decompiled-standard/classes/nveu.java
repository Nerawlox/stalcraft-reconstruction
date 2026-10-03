/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class nveu
implements Callable {
    public final /* synthetic */ pkix _a;

    public nveu(pkix pkix2) {
        this._a = pkix2;
    }

    public String _a() {
        return pkix._b(this._a).size() + " total; " + pkix._b(this._a).toString();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

