/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.ezey;

public enum xtby {
    _a(-1, ""),
    _b(0, "survival"),
    _c(1, "creative"),
    _d(2, "adventure");

    public int _e;
    public String _f;

    /*
     * WARNING - void declaration
     */
    public xtby() {
        void var4_2;
        void var3_1;
        this._e = var3_1;
        this._f = var4_2;
    }

    public int _a() {
        return this._e;
    }

    public String _b() {
        return this._f;
    }

    public void _a(ezey ezey2) {
        if (this == _c) {
            ezey2._c = true;
            ezey2._d = true;
            ezey2._a = true;
        } else {
            ezey2._c = false;
            ezey2._d = false;
            ezey2._a = false;
            ezey2._b = false;
        }
        ezey2._e = !this._c();
    }

    public boolean _c() {
        return this == _d;
    }

    public boolean _d() {
        return this == _c;
    }

    public boolean _e() {
        return this == _b || this == _d;
    }

    public static xtby _a(int n) {
        for (xtby xtby2 : xtby.values()) {
            if (xtby2._e != n) continue;
            return xtby2;
        }
        return _b;
    }

    public static xtby _a(String string) {
        for (xtby xtby2 : xtby.values()) {
            if (!xtby2._f.equals(string)) continue;
            return xtby2;
        }
        return _b;
    }
}

