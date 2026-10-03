/*
 * Decompiled with CFR 0.152.
 */
public class hdqh
extends Thread {
    public final /* synthetic */ jjwi _a;

    public hdqh(jjwi jjwi2) {
        this._a = jjwi2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            if (jjwi._a(this._a) != null) {
                jjwi._a(this._a, jjwi._a(this._a), jjwi._b(this._a), jjwi._c(this._a), jjwi._d(this._a));
            } else if (jjwi._b(this._a).exists()) {
                jjwi._a(this._a, jjwi._a(this._a, jjwi._b(this._a), jjwi._c(this._a), jjwi._d(this._a)));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            jjwi._a(this._a, false);
        }
    }
}

