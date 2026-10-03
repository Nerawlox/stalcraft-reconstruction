/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.sajh;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class jytp
extends uhrn {
    public final String _a;
    public gpnw _b = gpnw._b;
    public float _c;
    public float _d;
    private int _e;
    private int _f;
    private float _g;
    private wnxc _h;
    private zxbe _i;
    private static final Quaternion _j = new Quaternion();
    private static final Quaternion _k = new Quaternion();
    private static final Vector3f _l = new Vector3f();
    private static final Vector3f _m = new Vector3f();

    public jytp(nuco nuco2, String string) {
        super(nuco2);
        this._a = string;
    }

    public jytp _a(gpnw gpnw2) {
        this._b = gpnw2;
        return this;
    }

    @Override
    protected void tick(zxbe zxbe2) {
        super.tick(zxbe2);
        wnxc wnxc2 = this._b(zxbe2);
        if (wnxc2 == null) {
            return;
        }
        if (this._d != 0.0f) {
            this.speedFactor = Math.copySign(wnxc2._c / this._d, this.speedFactor);
        }
        if (this.speedFactor != 0.0f) {
            this._c += this.speedFactor * 1.0f / wnxc2._c;
            if (this._c >= this._a(wnxc2) || this._c < 0.0f) {
                switch (this._b) {
                    case _a: {
                        this._c = this.speedFactor > 0.0f ? 1.0f : 0.0f;
                        this.speedFactor = 0.0f;
                        this.toRemove = true;
                        break;
                    }
                    case _b: {
                        this._c = this.speedFactor > 0.0f ? 1.0f : 0.0f;
                        this.speedFactor = 0.0f;
                        break;
                    }
                    case _c: 
                    case _d: {
                        this._h = null;
                        this._c %= this._a(wnxc2);
                        break;
                    }
                    case _e: {
                        this._c = this.speedFactor > 0.0f ? 1.0f - this._c % 1.0f : -this._c;
                        this.speedFactor *= -1.0f;
                    }
                }
            }
        }
    }

    private float _a(wnxc wnxc2) {
        return this._b == gpnw._d ? 1.0f + 1.0f / ((float)wnxc2._b - 1.0f) : 1.0f;
    }

    @Override
    protected boolean shouldApply() {
        return this._c() != null;
    }

    @Override
    protected void update(zxbe zxbe2, ivtm ivtm2, float f) {
        if (this._i != null && this._i != zxbe2) {
            this._h = null;
        }
        this._i = zxbe2;
        wnxc wnxc2 = this._c();
        if (wnxc2 == null) {
            return;
        }
        float f2 = this._a(f);
        int n = wnxc2._b;
        float f3 = f2 * (float)(n - 1);
        boolean bl = this._b();
        int n2 = (int)(bl ? Math.ceil(f3) : (double)f3);
        this._e = n2 % n;
        this._f = (this._e + (bl ? -1 : 1)) % n;
        if (this._f < 0) {
            this._f += n;
        }
        this._g = Math.abs(f3 - (float)n2);
    }

    @Override
    protected boolean writeRotation(jywl.kjui kjui2, Quaternion quaternion) {
        this._c()._f[this._e]._a(_j, kjui2._c);
        this._c()._f[this._f]._a(_k, kjui2._c);
        jywc._a(_j, _k, quaternion, this._g);
        return true;
    }

    @Override
    protected boolean writeTranslation(jywl.kjui kjui2, Vector3f vector3f) {
        this._c()._f[this._e]._a(_l, kjui2._c);
        this._c()._f[this._f]._a(_m, kjui2._c);
        jywc._a(_l, _m, vector3f, this._g);
        return true;
    }

    public boolean _a() {
        return this.speedFactor != 0.0f;
    }

    public boolean _b() {
        return this.speedFactor < 0.0f;
    }

    public float _a(zxbe zxbe2) {
        wnxc wnxc2 = this._b(zxbe2);
        return wnxc2 == null ? 0.0f : wnxc2._c;
    }

    private float _a(float f) {
        wnxc wnxc2 = this._c();
        if (wnxc2 == null) {
            return 0.0f;
        }
        float f2 = this._c + this.speedFactor * f / wnxc2._c;
        if (this._b == gpnw._c || this._b == gpnw._d) {
            float f3 = this._a(wnxc2);
            if ((f2 %= f3) < 0.0f) {
                f2 += f3;
            }
            return f2;
        }
        if (this._b == gpnw._e) {
            if (f2 > 1.0f) {
                return 1.0f - f2 % 1.0f;
            }
            if (f2 < 0.0f) {
                return -f2;
            }
            return f2;
        }
        return sajh._a(f2, 0.0f, 1.0f);
    }

    private wnxc _c() {
        return this._b(this._i);
    }

    private wnxc _b(zxbe zxbe2) {
        if (this._h == null) {
            this._h = zxbe2._a(this._a);
            if (this._h == null && !this.toRemove) {
                gpmu._b("Animation " + this._a + " not found!", new Object[0]);
                this.toRemove = true;
            }
        }
        return this._h;
    }
}

