/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class ujvt
implements Callable {
    public final /* synthetic */ hurg _a;

    public ujvt(hurg hurg2) {
        this._a = hurg2;
    }

    public String _a() {
        int n = this._a.field_70331_k.func_72798_a(this._a.field_70329_l, this._a.field_70330_m, this._a.field_70327_n);
        try {
            return String.format("ID #%d (%s // %s)", n, twgu.field_71973_m[n].func_71917_a(), twgu.field_71973_m[n].getClass().getCanonicalName());
        }
        catch (Throwable throwable) {
            return "ID #" + n;
        }
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

