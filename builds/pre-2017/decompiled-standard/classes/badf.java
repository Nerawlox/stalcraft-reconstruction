/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b*\u0018\u0000 N2\u00020\u0001:\u0001NB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001e\u00100\u001a\u00020%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001e\u00103\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001e\u00106\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001e\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001e\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001e\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001e\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001e\u0010H\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000eR\u001e\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\b\u00a8\u0006O"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionPreset;", "", "()V", "dirtAngleRand", "", "getDirtAngleRand", "()F", "setDirtAngleRand", "(F)V", "dirtCount", "", "getDirtCount", "()I", "setDirtCount", "(I)V", "dirtStartSize", "getDirtStartSize", "setDirtStartSize", "dirtStrechX", "getDirtStrechX", "setDirtStrechX", "dirtStrechXRand", "getDirtStrechXRand", "setDirtStrechXRand", "dirtStrechY", "getDirtStrechY", "setDirtStrechY", "dirtStrechYRand", "getDirtStrechYRand", "setDirtStrechYRand", "dirtStrechZ", "getDirtStrechZ", "setDirtStrechZ", "dirtStrechZRand", "getDirtStrechZRand", "setDirtStrechZRand", "distortion", "", "getDistortion", "()Z", "setDistortion", "(Z)V", "explosion", "getExplosion", "setExplosion", "flashSpeed", "getFlashSpeed", "setFlashSpeed", "glow", "getGlow", "setGlow", "smokeCount", "getSmokeCount", "setSmokeCount", "smokeMotionX", "getSmokeMotionX", "setSmokeMotionX", "smokeMotionXRand", "getSmokeMotionXRand", "setSmokeMotionXRand", "smokeMotionY", "getSmokeMotionY", "setSmokeMotionY", "smokeMotionYRand", "getSmokeMotionYRand", "setSmokeMotionYRand", "smokeMotionZ", "getSmokeMotionZ", "setSmokeMotionZ", "smokeMotionZRand", "getSmokeMotionZRand", "setSmokeMotionZRand", "totalLifetime", "getTotalLifetime", "setTotalLifetime", "totalScale", "getTotalScale", "setTotalScale", "Companion", "minecraft"})
public final class badf {
    @EditorProperty(name="flashSpeed")
    private float _b = 10.0f;
    @EditorProperty(name="totalLifetime", min="0", max="1000")
    private int _c = 60;
    @EditorProperty(name="totalSize")
    private float _d = 2.0f;
    @EditorProperty(name="smokeCount", min="0", max="1000")
    private int _e = 30;
    @EditorProperty(name="smokeMotionX")
    private float _f = 0.2f;
    @EditorProperty(name="smokeMotionY")
    private float _g = 0.2f;
    @EditorProperty(name="smokeMotionZ")
    private float _h = 0.2f;
    @EditorProperty(name="smokeMotionX+")
    private float _i = 0.3f;
    @EditorProperty(name="smokeMotionY+")
    private float _j = 0.6f;
    @EditorProperty(name="smokeMotionZ+")
    private float _k = 0.3f;
    @EditorProperty(name="dirtStrechX")
    private float _l = 0.5f;
    @EditorProperty(name="dirtStrechY")
    private float _m = 0.5f;
    @EditorProperty(name="dirtStrechZ")
    private float _n = 0.5f;
    @EditorProperty(name="dirtStrechX+")
    private float _o = 0.2f;
    @EditorProperty(name="dirtStrechY+")
    private float _p = 0.6f;
    @EditorProperty(name="dirtStrechZ+")
    private float _q = 0.2f;
    @EditorProperty(name="dirtCount", min="0", max="1000")
    private int _r = 10;
    @EditorProperty(name="dirtAngleRand", min="-1000", max="1000")
    private float _s = 120.0f;
    @EditorProperty(name="dirtStartSize")
    private float _t = 0.125f;
    @EditorProperty(name="glow")
    private boolean _u = true;
    @EditorProperty(name="explosion")
    private boolean _v = true;
    @EditorProperty(name="distortion")
    private boolean _w = true;
    @NotNull
    private static final badf _x;
    public static final kjui _a;

    public final float _a() {
        return this._b;
    }

    public final void _a(float f) {
        this._b = f;
    }

    public final int _b() {
        return this._c;
    }

    public final void _a(int n) {
        this._c = n;
    }

    public final float _c() {
        return this._d;
    }

    public final void _b(float f) {
        this._d = f;
    }

    public final int _d() {
        return this._e;
    }

    public final void _b(int n) {
        this._e = n;
    }

    public final float _e() {
        return this._f;
    }

    public final void _c(float f) {
        this._f = f;
    }

    public final float _f() {
        return this._g;
    }

    public final void _d(float f) {
        this._g = f;
    }

    public final float _g() {
        return this._h;
    }

    public final void _e(float f) {
        this._h = f;
    }

    public final float _h() {
        return this._i;
    }

    public final void _f(float f) {
        this._i = f;
    }

    public final float _i() {
        return this._j;
    }

    public final void _g(float f) {
        this._j = f;
    }

    public final float _j() {
        return this._k;
    }

    public final void _h(float f) {
        this._k = f;
    }

    public final float _k() {
        return this._l;
    }

    public final void _i(float f) {
        this._l = f;
    }

    public final float _l() {
        return this._m;
    }

    public final void _j(float f) {
        this._m = f;
    }

    public final float _m() {
        return this._n;
    }

    public final void _k(float f) {
        this._n = f;
    }

    public final float _n() {
        return this._o;
    }

    public final void _l(float f) {
        this._o = f;
    }

    public final float _o() {
        return this._p;
    }

    public final void _m(float f) {
        this._p = f;
    }

    public final float _p() {
        return this._q;
    }

    public final void _n(float f) {
        this._q = f;
    }

    public final int _q() {
        return this._r;
    }

    public final void _c(int n) {
        this._r = n;
    }

    public final float _r() {
        return this._s;
    }

    public final void _o(float f) {
        this._s = f;
    }

    public final float _s() {
        return this._t;
    }

    public final void _p(float f) {
        this._t = f;
    }

    public final boolean _t() {
        return this._u;
    }

    public final void _a(boolean bl) {
        this._u = bl;
    }

    public final boolean _u() {
        return this._v;
    }

    public final void _b(boolean bl) {
        this._v = bl;
    }

    public final boolean _v() {
        return this._w;
    }

    public final void _c(boolean bl) {
        this._w = bl;
    }

    static {
        _a = new kjui(null);
        _x = new badf();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionPreset$Companion;", "", "()V", "instance", "Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionPreset;", "getInstance", "()Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionPreset;", "minecraft"})
    public static final class kjui {
        @NotNull
        public final badf _a() {
            return _x;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

