/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReportCategory;

public class nvdp
implements Callable {
    public final /* synthetic */ double _a;
    public final /* synthetic */ double _b;
    public final /* synthetic */ double _c;
    public final /* synthetic */ cvgz _d;

    public nvdp(cvgz cvgz2, double d, double d2, double d3) {
        this._d = cvgz2;
        this._a = d;
        this._b = d2;
        this._c = d3;
    }

    public String _a() {
        return CrashReportCategory._a(this._a, this._b, this._c);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

