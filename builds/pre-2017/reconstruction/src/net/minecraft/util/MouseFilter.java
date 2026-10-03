/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

public class MouseFilter {
    public float _a;
    public float _b;
    public float _c;

    public float _a(float f, float f2) {
        this._a += f;
        f = (this._a - this._b) * f2;
        this._c += (f - this._c) * 0.5f;
        if (f > 0.0f && f > this._c || f < 0.0f && f < this._c) {
            f = this._c;
        }
        this._b += f;
        return f;
    }
}

