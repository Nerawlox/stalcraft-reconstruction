/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class iwwd
implements Callable {
    public final /* synthetic */ pkix _a;

    public iwwd(pkix pkix2) {
        this._a = pkix2;
    }

    public String _a() {
        return pkix._a(this._a).size() + " total; " + pkix._a(this._a).toString();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

