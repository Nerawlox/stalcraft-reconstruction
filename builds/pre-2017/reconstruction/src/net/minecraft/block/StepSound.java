/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

public class StepSound {
    public final String _a;
    public final float _b;
    public final float _c;

    public StepSound(String string, float f, float f2) {
        this._a = string;
        this._b = f;
        this._c = f2;
    }

    public float _a() {
        return this._b;
    }

    public float _b() {
        return this._c;
    }

    public String _c() {
        return "dig." + this._a;
    }

    public String _d() {
        return "step." + this._a;
    }

    public String _e() {
        return this._c();
    }
}

