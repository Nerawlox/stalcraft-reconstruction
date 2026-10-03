/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class elgq
implements Callable {
    public final /* synthetic */ ujth _a;

    public elgq(ujth ujth2) {
        this._a = ujth2;
    }

    public String _a() {
        String string = this._a._H();
        if (!string.equals("vanilla")) {
            return "Definitely; Server brand changed to '" + string + "'";
        }
        return "Unknown (can't tell)";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

