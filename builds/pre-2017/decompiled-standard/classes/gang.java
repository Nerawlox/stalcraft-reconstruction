/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;

public class gang
extends Thread {
    public final /* synthetic */ Map _a;
    public final /* synthetic */ jjwi _b;

    public gang(jjwi jjwi2, Map map) {
        this._b = jjwi2;
        this._a = map;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            jjwi._a(this._b, this._a, jjwi._e(this._b), jjwi._f(this._b), jjwi._g(this._b));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            jjwi._a(this._b, false);
        }
    }
}

