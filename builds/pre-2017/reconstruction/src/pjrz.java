/*
 * Decompiled with CFR 0.152.
 */
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class pjrz
implements Comparable<pjrz> {
    public final kjui _a;
    public final kjui _b;
    public final pidb _c;
    public float _d;
    public boolean _e = true;

    public pjrz(float f) {
        this(new kjui(0.0f, 0.0f, 0.0f, 1.0f), new kjui(0.0f, 0.0f, 0.0f, 1.0f), new pidb(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f), f, true);
    }

    public pjrz(kjui kjui2, kjui kjui3, pidb pidb2, float f, boolean bl) {
        this._a = kjui2;
        this._b = kjui3;
        this._c = pidb2;
        this._d = f;
        this._e = bl;
    }

    public int _a(@NotNull pjrz pjrz2) {
        if (pjrz2 == null) {
            pjrz._a(0);
        }
        return Float.compare(this._d, pjrz2._d);
    }

    void _a(pjrz pjrz2, pjrz pjrz3, float f) {
        this._a._a(pjrz2._a, pjrz3._a, f);
        this._b._a(pjrz2._b, pjrz3._b, f);
        this._c._a(pjrz2._c, pjrz3._c, f);
    }

    static Quaternion _a(float f, float f2, float f3) {
        return jywc._a(new Vector3f(f *= (float)Math.PI / 180, f2 *= (float)Math.PI / 180, f3 *= (float)Math.PI / 180), null);
    }

    @Override
    public /* synthetic */ int compareTo(@NotNull Object object) {
        return this._a((pjrz)object);
    }

    private static /* synthetic */ void _a(int n) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "o", "gloomyfolken/mods/weapon/client/animation/ThirdPersonAnimationKeyframe", "compareTo"));
    }

    public static class pidb {
        public Quaternion _a;
        public Vector3f _b;

        public pidb() {
            this._a = new Quaternion();
            this._b = new Vector3f();
        }

        public pidb(float f, float f2, float f3, float f4, float f5, float f6) {
            this._a = pjrz._a(f, f2, f3);
            this._b = new Vector3f(f4, f5, f6);
        }

        void _a(pidb pidb2, pidb pidb3, float f) {
            jywc._a(pidb2._a, pidb3._a, this._a, f);
            jywc._a(pidb2._b, pidb3._b, this._b, f);
        }
    }

    public static class kjui {
        public Quaternion _a;
        public float _b;

        public kjui() {
            this._a = new Quaternion();
            this._b = 1.0f;
        }

        public kjui(float f, float f2, float f3, float f4) {
            this._a = pjrz._a(f, f2, f3);
            this._b = f4;
        }

        void _a(kjui kjui2, kjui kjui3, float f) {
            jywc._a(kjui2._a, kjui3._a, this._a, f);
            this._b = jywc._a(kjui2._b, kjui3._b, f);
        }
    }
}

