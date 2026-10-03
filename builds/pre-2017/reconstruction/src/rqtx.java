/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Function;

public class rqtx
implements Function {
    public final /* synthetic */ scvi _a;

    public rqtx(scvi scvi2) {
        this._a = scvi2;
    }

    public String _a(fnrl fnrl2) {
        return fnrl2.getPackName();
    }

    public /* synthetic */ Object apply(Object object) {
        return this._a((fnrl)object);
    }
}

