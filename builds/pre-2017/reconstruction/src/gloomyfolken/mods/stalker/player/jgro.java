/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.mods.stalker.player.zwat;
import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/stalker/player/MeshRotationImpl;", "Lgloomyfolken/mods/stalker/player/IMeshRotation;", "()V", "angleX", "", "getAngleX", "()F", "setAngleX", "(F)V", "angleY", "getAngleY", "setAngleY", "angleZ", "getAngleZ", "setAngleZ", "rotationPointX", "getRotationPointX", "setRotationPointX", "rotationPointY", "getRotationPointY", "setRotationPointY", "rotationPointZ", "getRotationPointZ", "setRotationPointZ", "rotateAngleX", "rotateAngleY", "rotateAngleZ", "minecraft"})
public class jgro
implements zwat {
    private float _a;
    private float _b;
    private float _c;
    private float _d;
    private float _e;
    private float _f;

    public final float _a() {
        return this._a;
    }

    public final void _a(float f) {
        this._a = f;
    }

    public final float _b() {
        return this._b;
    }

    public final void _b(float f) {
        this._b = f;
    }

    public final float _c() {
        return this._c;
    }

    public final void _c(float f) {
        this._c = f;
    }

    public final float _d() {
        return this._d;
    }

    public final void _d(float f) {
        this._d = f;
    }

    public final float _e() {
        return this._e;
    }

    public final void _e(float f) {
        this._e = f;
    }

    public final float _f() {
        return this._f;
    }

    public final void _f(float f) {
        this._f = f;
    }

    @Override
    public float rotateAngleX() {
        return this._a;
    }

    @Override
    public float rotateAngleY() {
        return this._b;
    }

    @Override
    public float rotateAngleZ() {
        return this._c;
    }

    @Override
    public float rotationPointX() {
        return this._d;
    }

    @Override
    public float rotationPointY() {
        return this._e;
    }

    @Override
    public float rotationPointZ() {
        return this._f;
    }
}

