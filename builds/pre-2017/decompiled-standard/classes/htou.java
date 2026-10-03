/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.sajh;

public class htou {
    public int _a;
    public int _b;
    public double _c;
    public double _d;
    public int _e;

    public htou(GameSettings gameSettings, int n, int n2) {
        this._a = n;
        this._b = n2;
        this._e = 1;
        int n3 = gameSettings.field_74335_Z;
        if (n3 == 0) {
            n3 = 1000;
        }
        while (this._e < n3 && this._a / (this._e + 1) >= 320 && this._b / (this._e + 1) >= 240) {
            ++this._e;
        }
        this._c = (double)this._a / (double)this._e;
        this._d = (double)this._b / (double)this._e;
        this._a = sajh._e(this._c);
        this._b = sajh._e(this._d);
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public double _c() {
        return this._c;
    }

    public double _d() {
        return this._d;
    }

    public int _e() {
        return this._e;
    }
}

