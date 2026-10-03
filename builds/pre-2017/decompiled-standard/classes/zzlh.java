/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ofbx;

public class zzlh
extends rrte {
    @Override
    public void _b() {
        this._e = new txyn(foqh._j, 1.0f, 0.0f);
        this._f = true;
        this._g = true;
        this._i = -1;
    }

    @Override
    public ofbx _b(float f, float f2) {
        return this._b.func_82732_R()._a(0.2f, 0.03f, 0.03f);
    }

    @Override
    public void _a() {
        float f = 0.1f;
        for (int i = 0; i <= 15; ++i) {
            float f2 = 1.0f - (float)i / 15.0f;
            this._h[i] = (1.0f - f2) / (f2 * 3.0f + 1.0f) * (1.0f - f) + f;
        }
    }

    @Override
    public mccn _c() {
        return new ozoc(this._b, this._b.func_72905_C());
    }

    @Override
    public boolean _d() {
        return false;
    }

    @Override
    public boolean _a(int n, int n2) {
        return false;
    }

    @Override
    public float _a(long l, float f) {
        return 0.5f;
    }

    @Override
    public boolean _e() {
        return false;
    }

    @Override
    public boolean _b(int n, int n2) {
        return true;
    }

    @Override
    public String _l() {
        return "Nether";
    }
}

