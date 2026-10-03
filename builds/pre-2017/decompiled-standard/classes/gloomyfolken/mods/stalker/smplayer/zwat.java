/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.smplayer;

import gloomyfolken.mods.stalker.smplayer.eidj;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001b\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00108\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u00109\u001a\u00020\u0004H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\b\u0010/\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001a\u0010)\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001a\u0010,\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001a\u0010/\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001a\u00102\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001a\u00105\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\b\u00a8\u0006<"}, d2={"Lgloomyfolken/mods/stalker/smplayer/SmartMeshRotationImpl;", "Lgloomyfolken/mods/stalker/smplayer/ISmartMeshRotation;", "()V", "_scaleY", "", "get_scaleY", "()F", "set_scaleY", "(F)V", "angleX", "getAngleX", "setAngleX", "angleY", "getAngleY", "setAngleY", "angleZ", "getAngleZ", "setAngleZ", "base", "getBase", "()Lgloomyfolken/mods/stalker/smplayer/SmartMeshRotationImpl;", "setBase", "(Lgloomyfolken/mods/stalker/smplayer/SmartMeshRotationImpl;)V", "ignoreBase", "", "getIgnoreBase", "()Z", "setIgnoreBase", "(Z)V", "ignoreSuperRotation", "getIgnoreSuperRotation", "setIgnoreSuperRotation", "rotationOrder", "", "getRotationOrder", "()I", "setRotationOrder", "(I)V", "rotationPointX", "getRotationPointX", "setRotationPointX", "rotationPointY", "getRotationPointY", "setRotationPointY", "rotationPointZ", "getRotationPointZ", "setRotationPointZ", "translationOffsetX", "getTranslationOffsetX", "setTranslationOffsetX", "translationOffsetY", "getTranslationOffsetY", "setTranslationOffsetY", "translationOffsetZ", "getTranslationOffsetZ", "setTranslationOffsetZ", "getScaleY", "rotateAngleX", "rotateAngleY", "rotateAngleZ", "minecraft"})
public class zwat
implements eidj {
    private int _a;
    private boolean _b;
    private boolean _c;
    private float _d;
    private float _e;
    private float _f;
    @Nullable
    private zwat _g;
    private float _h;
    private float _i;
    private float _j;
    private float _k;
    private float _l;
    private float _m;
    private float _n = 1.0f;

    public final int _a() {
        return this._a;
    }

    public final void _a(int n) {
        this._a = n;
    }

    public final boolean _b() {
        return this._b;
    }

    public final void _a(boolean bl) {
        this._b = bl;
    }

    public final boolean _c() {
        return this._c;
    }

    public final void _b(boolean bl) {
        this._c = bl;
    }

    public final float _d() {
        return this._d;
    }

    public final void _a(float f) {
        this._d = f;
    }

    public final float _e() {
        return this._e;
    }

    public final void _b(float f) {
        this._e = f;
    }

    public final float _f() {
        return this._f;
    }

    public final void _c(float f) {
        this._f = f;
    }

    @Nullable
    public final zwat _g() {
        return this._g;
    }

    public final void _a(@Nullable zwat zwat2) {
        this._g = zwat2;
    }

    public final float _h() {
        return this._h;
    }

    public final void _d(float f) {
        this._h = f;
    }

    public final float _i() {
        return this._i;
    }

    public final void _e(float f) {
        this._i = f;
    }

    public final float _j() {
        return this._j;
    }

    public final void _f(float f) {
        this._j = f;
    }

    public final float _k() {
        return this._k;
    }

    public final void _g(float f) {
        this._k = f;
    }

    public final float _l() {
        return this._l;
    }

    public final void _h(float f) {
        this._l = f;
    }

    public final float _m() {
        return this._m;
    }

    public final void _i(float f) {
        this._m = f;
    }

    public final float _n() {
        return this._n;
    }

    public final void _j(float f) {
        this._n = f;
    }

    @Override
    public int rotationOrder() {
        return this._a;
    }

    @Override
    public boolean ignoreBase() {
        return this._b;
    }

    @Override
    public boolean ignoreSuperRotation() {
        return this._c;
    }

    @Override
    public float rotateAngleX() {
        return this._d;
    }

    @Override
    public float rotateAngleY() {
        return this._e;
    }

    @Override
    public float rotateAngleZ() {
        return this._f;
    }

    @Override
    public float rotationPointX() {
        return this._h;
    }

    @Override
    public float rotationPointY() {
        return this._i;
    }

    @Override
    public float rotationPointZ() {
        return this._j;
    }

    @Override
    public float translationOffsetX() {
        zwat zwat2 = this._g;
        return zwat2 != null ? zwat2._k : this._k;
    }

    @Override
    public float translationOffsetY() {
        zwat zwat2 = this._g;
        return zwat2 != null ? zwat2._l : this._l;
    }

    @Override
    public float translationOffsetZ() {
        zwat zwat2 = this._g;
        return zwat2 != null ? zwat2._m : this._m;
    }

    @Override
    public float getScaleY() {
        return this._n;
    }
}

