/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.dwan;

public class zyjh
implements dwan {
    public final dwan _a;
    public final boolean _b;
    public final boolean _c;

    public zyjh(dwan dwan2, boolean bl, boolean bl2) {
        this._a = dwan2;
        this._b = bl;
        this._c = bl2;
    }

    @Override
    public int func_94211_a() {
        return this._a.func_94211_a();
    }

    @Override
    public int func_94216_b() {
        return this._a.func_94216_b();
    }

    @Override
    public float func_94209_e() {
        if (this._b) {
            return this._a.func_94212_f();
        }
        return this._a.func_94209_e();
    }

    @Override
    public float func_94212_f() {
        if (this._b) {
            return this._a.func_94209_e();
        }
        return this._a.func_94212_f();
    }

    @Override
    public float func_94214_a(double d) {
        float f = this.func_94212_f() - this.func_94209_e();
        return this.func_94209_e() + f * ((float)d / 16.0f);
    }

    @Override
    public float func_94206_g() {
        if (this._c) {
            return this._a.func_94206_g();
        }
        return this._a.func_94206_g();
    }

    @Override
    public float func_94210_h() {
        if (this._c) {
            return this._a.func_94206_g();
        }
        return this._a.func_94210_h();
    }

    @Override
    public float func_94207_b(double d) {
        float f = this.func_94210_h() - this.func_94206_g();
        return this.func_94206_g() + f * ((float)d / 16.0f);
    }

    @Override
    public String func_94215_i() {
        return this._a.func_94215_i();
    }
}

