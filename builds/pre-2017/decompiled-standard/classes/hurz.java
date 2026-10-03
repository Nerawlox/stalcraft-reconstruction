/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class hurz
implements Callable {
    public final /* synthetic */ hurg _a;

    public hurz(hurg hurg2) {
        this._a = hurg2;
    }

    public String _a() {
        int n = this._a.field_70331_k.func_72805_g(this._a.field_70329_l, this._a.field_70330_m, this._a.field_70327_n);
        if (n < 0) {
            return "Unknown? (Got " + n + ")";
        }
        String string = String.format("%4s", Integer.toBinaryString(n)).replace(" ", "0");
        return String.format("%1$d / 0x%1$X / 0b%2$s", n, string);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

