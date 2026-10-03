/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

public class ezey {
    public boolean _a;
    public boolean _b;
    public boolean _c;
    public boolean _d;
    public boolean _e = true;
    public float _f = 0.05f;
    public float _g = 0.1f;

    public void _a(qoac qoac2) {
        qoac qoac3 = new qoac();
        qoac3._a("invulnerable", this._a);
        qoac3._a("flying", this._b);
        qoac3._a("mayfly", this._c);
        qoac3._a("instabuild", this._d);
        qoac3._a("mayBuild", this._e);
        qoac3._a("flySpeed", this._f);
        qoac3._a("walkSpeed", this._g);
        qoac2._a("abilities", (huhy)qoac3);
    }

    public void _b(qoac qoac2) {
        if (qoac2._c("abilities")) {
            qoac qoac3 = qoac2._m("abilities");
            this._a = qoac3._o("invulnerable");
            this._b = qoac3._o("flying");
            this._c = qoac3._o("mayfly");
            this._d = qoac3._o("instabuild");
            if (qoac3._c("flySpeed")) {
                this._f = qoac3._h("flySpeed");
                this._g = qoac3._h("walkSpeed");
            }
            if (qoac3._c("mayBuild")) {
                this._e = qoac3._o("mayBuild");
            }
        }
    }

    public float _a() {
        return this._f;
    }

    public void _a(float f) {
        this._f = f;
    }

    public float _b() {
        return this._g;
    }

    public void _b(float f) {
        this._g = f;
    }
}

