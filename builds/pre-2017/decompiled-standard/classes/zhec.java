/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class zhec
implements Callable {
    public final /* synthetic */ htou _a;
    public final /* synthetic */ tfsl _b;

    public zhec(tfsl tfsl2, htou htou2) {
        this._b = tfsl2;
        this._a = htou2;
    }

    public String _a() {
        return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", this._a._a(), this._a._b(), tfsl.func_90030_a((tfsl)this._b)._n, tfsl.func_90030_a((tfsl)this._b)._o, this._a._e());
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

