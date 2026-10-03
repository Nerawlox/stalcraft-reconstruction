/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Field;

public class ivms {
    public static ivms _a;
    public boolean _b;
    private Class _c;
    private Field _d;
    private boolean _e;

    public ivms() {
        _a = this;
        try {
            this._c = Class.forName("poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod");
            this._d = this._c.getDeclaredField("modActive");
            this._b = true;
        }
        catch (Exception exception) {
            this._b = false;
        }
    }

    public void _a() {
        if (this._b) {
            try {
                this._e = this._d.getBoolean(null);
                if (this._e) {
                    this._d.setBoolean(null, false);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void _b() {
        if (this._b && this._e) {
            try {
                this._d.setBoolean(null, true);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

