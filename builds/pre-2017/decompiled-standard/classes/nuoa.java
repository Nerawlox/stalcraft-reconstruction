/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.trace.EntityTracer;
import java.util.Random;

public class nuoa {
    public static final int _a = 15;
    public static final int _b = 60;
    private static Random _e = new Random();
    public kjui _c;
    public pidb _d;

    public void _a() {
        if (this._c != null && ++this._c._b > 15) {
            this._c = null;
        }
        if (this._d != null && ++this._d._c > 60) {
            this._d = null;
        }
    }

    public static class pidb {
        public float _a;
        public float _b;
        public int _c;

        public pidb(float f, float f2) {
            this._a = f;
            this._b = f2;
        }
    }

    public static class kjui {
        public EntityTracer.eidj _a;
        public int _b;

        public kjui(EntityTracer.eidj eidj2) {
            this._a = eidj2;
        }
    }
}

