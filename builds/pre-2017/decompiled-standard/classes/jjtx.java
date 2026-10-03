/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class jjtx
implements Callable {
    public final /* synthetic */ dzfd _a;

    public jjtx(dzfd dzfd2) {
        this._a = dzfd2;
    }

    public String _a() {
        return this._a._g._c ? this._a._g._c() : "N/A (disabled)";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

