/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import org.lwjgl.input.Mouse;

public class yebt
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ tfsl _c;

    public yebt(tfsl tfsl2, int n, int n2) {
        this._c = tfsl2;
        this._a = n;
        this._b = n2;
    }

    public String _a() {
        return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", this._a, this._b, Mouse.getX(), Mouse.getY());
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

