/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class elgy
implements Callable {
    public final /* synthetic */ dzfd _a;

    public elgy(dzfd dzfd2) {
        this._a = dzfd2;
    }

    public String _a() {
        int n = this._a._j[0].func_82732_R()._c();
        int n2 = 56 * n;
        int n3 = n2 / 1024 / 1024;
        int n4 = this._a._j[0].func_82732_R()._d();
        int n5 = 56 * n4;
        int n6 = n5 / 1024 / 1024;
        return n + " (" + n2 + " bytes; " + n3 + " MB) allocated, " + n4 + " (" + n5 + " bytes; " + n6 + " MB) used";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

