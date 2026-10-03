/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.KCallablesJvm;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u00a8\u00012\u00020\u0001:\u0006\u00a8\u0001\u00a9\u0001\u00aa\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u0006J\n\u0010\u008d\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u008e\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010\u008f\u0001\u001a\u00020b2\t\b\u0002\u0010\u0090\u0001\u001a\u00020\nJ\u001d\u0010\u0091\u0001\u001a\u00020<2\u0014\u0010\u0092\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\u0093\u0001J\u0007\u0010\u0094\u0001\u001a\u00020\nJ\u0007\u0010\u0095\u0001\u001a\u00020\nJ\u0011\u0010\u0095\u0001\u001a\u00020\n2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001J\u0010\u0010\u0098\u0001\u001a\u00020C2\u0007\u0010\u0099\u0001\u001a\u00020\u0005J\u0013\u0010\u009a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u009b\u0001\u001a\u00020<H\u0002J\u0011\u0010\u009c\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u0006J\u0011\u0010\u009d\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u0005J\u0007\u0010\u009e\u0001\u001a\u00020CJ\b\u0010\u009f\u0001\u001a\u00030\u008b\u0001J\n\u0010\u00a0\u0001\u001a\u00030\u008b\u0001H\u0002J.\u0010\u00a1\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u00a2\u0001\u001a\u00020-2\u0007\u0010\u00a3\u0001\u001a\u00020-2\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\b\u0010\u00a6\u0001\u001a\u00030\u00a7\u0001R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR+\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR+\u0010\u001e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR+\u0010\"\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001a\u0010&\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\u001a\u0010)\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R+\u00102\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b5\u0010\u0011\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR+\u00106\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b9\u0010\u0011\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\u000e\u0010:\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010;\u001a\u0012\u0012\u0004\u0012\u00020<0\bj\b\u0012\u0004\u0012\u00020<`=X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010>\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bA\u0010\u0011\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR\u000e\u0010B\u001a\u00020CX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR+\u0010G\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bJ\u0010\u0011\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR+\u0010K\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bN\u0010\u0011\u001a\u0004\bL\u0010\r\"\u0004\bM\u0010\u000fR+\u0010O\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bR\u0010\u0011\u001a\u0004\bP\u0010\r\"\u0004\bQ\u0010\u000fR\u000e\u0010S\u001a\u00020TX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010U\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bX\u0010\u0011\u001a\u0004\bV\u0010\r\"\u0004\bW\u0010\u000fR+\u0010Y\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\\\u0010\u0011\u001a\u0004\bZ\u0010\r\"\u0004\b[\u0010\u000fR+\u0010]\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b`\u0010\u0011\u001a\u0004\b^\u0010\r\"\u0004\b_\u0010\u000fR\u0019\u0010a\u001a\n c*\u0004\u0018\u00010b0b\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u001a\u0010f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\r\"\u0004\bh\u0010\u000fR\u001a\u0010i\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\r\"\u0004\bk\u0010\u000fR+\u0010l\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bo\u0010\u0011\u001a\u0004\bm\u0010\r\"\u0004\bn\u0010\u000fR\u0019\u0010p\u001a\n c*\u0004\u0018\u00010b0b\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010eR\u001a\u0010r\u001a\u00020CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR+\u0010w\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bz\u0010\u0011\u001a\u0004\bx\u0010\r\"\u0004\by\u0010\u000fR+\u0010{\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b~\u0010\u0011\u001a\u0004\b|\u0010\r\"\u0004\b}\u0010\u000fR.\u0010\u007f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u0082\u0001\u0010\u0011\u001a\u0005\b\u0080\u0001\u0010\r\"\u0005\b\u0081\u0001\u0010\u000fR\u000f\u0010\u0083\u0001\u001a\u00020CX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R/\u0010\u0086\u0001\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u0089\u0001\u0010\u0011\u001a\u0005\b\u0087\u0001\u0010\r\"\u0005\b\u0088\u0001\u0010\u000f\u00a8\u0006\u00ab\u0001"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "", "()V", "activeNamedScreenEffects", "Ljava/util/HashMap;", "", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "activeScreenEffects", "Ljava/util/ArrayList;", "<set-?>", "", "bio", "getBio", "()D", "setBio", "(D)V", "bio$delegate", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager$EffectParameter;", "bloodAmount", "getBloodAmount", "setBloodAmount", "bloodAmount$delegate", "blurAmount", "getBlurAmount", "setBlurAmount", "blurAmount$delegate", "cameraHelper", "Lgloomyfolken/mods/effects/client/postprocess/effect/CameraHelper;", "getCameraHelper", "()Lgloomyfolken/mods/effects/client/postprocess/effect/CameraHelper;", "contrastAmount", "getContrastAmount", "setContrastAmount", "contrastAmount$delegate", "damageIndicator", "getDamageIndicator", "setDamageIndicator", "damageIndicator$delegate", "deafnessAmount", "getDeafnessAmount", "setDeafnessAmount", "deafnessDecayFactor", "getDeafnessDecayFactor", "setDeafnessDecayFactor", "deafnessDelay", "", "getDeafnessDelay", "()I", "setDeafnessDelay", "(I)V", "dualityH", "getDualityH", "setDualityH", "dualityH$delegate", "dualityV", "getDualityV", "setDualityV", "dualityV$delegate", "edgeStretchAmount", "effectParameters", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager$EffectParameter;", "Lkotlin/collections/ArrayList;", "flashAmount", "getFlashAmount", "setFlashAmount", "flashAmount$delegate", "fxaa", "", "globalDecayFactor", "getGlobalDecayFactor", "setGlobalDecayFactor", "grayAmount", "getGrayAmount", "setGrayAmount", "grayAmount$delegate", "heartBeatPower", "getHeartBeatPower", "setHeartBeatPower", "heartBeatPower$delegate", "heartBeatSpeed", "getHeartBeatSpeed", "setHeartBeatSpeed", "heartBeatSpeed$delegate", "immediateRenderParams", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager$ImmediateRenderParams;", "lensAmount", "getLensAmount", "setLensAmount", "lensAmount$delegate", "lensDirtContrastOffset", "getLensDirtContrastOffset", "setLensDirtContrastOffset", "lensDirtContrastOffset$delegate", "noiseAmount", "getNoiseAmount", "setNoiseAmount", "noiseAmount$delegate", "nv_AddColor", "Lnet/minecraft/util/Vec3;", "kotlin.jvm.PlatformType", "getNv_AddColor", "()Lnet/minecraft/util/Vec3;", "nv_GlitchAmount", "getNv_GlitchAmount", "setNv_GlitchAmount", "nv_LensAmount", "getNv_LensAmount", "setNv_LensAmount", "nv_NightVisionAmount", "getNv_NightVisionAmount", "setNv_NightVisionAmount", "nv_NightVisionAmount$delegate", "nv_ScreenColor", "getNv_ScreenColor", "overrideUsePostprocess", "getOverrideUsePostprocess", "()Z", "setOverrideUsePostprocess", "(Z)V", "psi", "getPsi", "setPsi", "psi$delegate", "suppression", "getSuppression", "setSuppression", "suppression$delegate", "terma", "getTerma", "setTerma", "terma$delegate", "usePostprocessingThisTick", "vignetteEdgeWidth", "vignetteRadius", "water", "getWater", "setWater", "water$delegate", "addEffect", "", "screenEffect", "applyGeneralEffects", "applyVignette", "getCentripetalMovementVector", "time", "getEffectParam", "kProperty", "Lkotlin/reflect/KProperty1;", "getHeartbeat", "getTime", "millis", "", "hasEffect", "id", "registerEffectParameter", "effectParameter", "removeEffect", "removeEffectById", "shouldUsePostprocessing", "update", "updateSoundEffects", "uploadShaderUniforms", "width", "height", "shader", "Lgloomyfolken/mods/effects/client/main/Shader;", "frame", "", "Companion", "EffectParameter", "ImmediateRenderParams", "minecraft"})
public final class jysc {
    private final ArrayList<pidb> _c;
    private final ArrayList<bqzs> _d;
    private final HashMap<String, bqzs> _e;
    private double _f;
    @NotNull
    private final pidb _g;
    @NotNull
    private final pidb _h;
    @NotNull
    private final pidb _i;
    @NotNull
    private final pidb _j;
    @NotNull
    private final pidb _k;
    @NotNull
    private final pidb _l;
    @NotNull
    private final pidb _m;
    @NotNull
    private final pidb _n;
    private final ofbx _o;
    private final ofbx _p;
    private double _q;
    private double _r;
    @NotNull
    private final pidb _s;
    @NotNull
    private final pidb _t;
    @NotNull
    private final pidb _u;
    @NotNull
    private final pidb _v;
    @NotNull
    private final pidb _w;
    @NotNull
    private final pidb _x;
    @NotNull
    private final pidb _y;
    @NotNull
    private final pidb _z;
    @NotNull
    private final pidb _A;
    @NotNull
    private final pidb _B;
    @NotNull
    private final pidb _C;
    private boolean _D;
    private double _E;
    private double _F;
    private double _G;
    private final eidj _H;
    private boolean _I;
    private double _J;
    private double _K;
    private int _L;
    @NotNull
    private final gpjn _M;
    private boolean _N;
    static final /* synthetic */ KProperty[] _a;
    public static final kjui _b = new kjui(null);

    public final double _a() {
        return this._f;
    }

    public final void _a(double d) {
        this._f = d;
    }

    public final double _b() {
        return this._g._a(this, _a[0]);
    }

    public final void _b(double d) {
        this._g._a(this, _a[0], d);
    }

    public final double _c() {
        return this._h._a(this, _a[1]);
    }

    public final void _c(double d) {
        this._h._a(this, _a[1], d);
    }

    public final double _d() {
        return this._i._a(this, _a[2]);
    }

    public final void _d(double d) {
        this._i._a(this, _a[2], d);
    }

    public final double _e() {
        return this._j._a(this, _a[3]);
    }

    public final void _e(double d) {
        this._j._a(this, _a[3], d);
    }

    public final double _f() {
        return this._k._a(this, _a[4]);
    }

    public final void _f(double d) {
        this._k._a(this, _a[4], d);
    }

    public final double _g() {
        return this._l._a(this, _a[5]);
    }

    public final void _g(double d) {
        this._l._a(this, _a[5], d);
    }

    public final double _h() {
        return this._m._a(this, _a[6]);
    }

    public final void _h(double d) {
        this._m._a(this, _a[6], d);
    }

    public final double _i() {
        return this._n._a(this, _a[7]);
    }

    public final void _i(double d) {
        this._n._a(this, _a[7], d);
    }

    public final ofbx _j() {
        return this._o;
    }

    public final ofbx _k() {
        return this._p;
    }

    public final double _l() {
        return this._q;
    }

    public final void _j(double d) {
        this._q = d;
    }

    public final double _m() {
        return this._r;
    }

    public final void _k(double d) {
        this._r = d;
    }

    public final double _n() {
        return this._s._a(this, _a[8]);
    }

    public final void _l(double d) {
        this._s._a(this, _a[8], d);
    }

    public final double _o() {
        return this._t._a(this, _a[9]);
    }

    public final void _m(double d) {
        this._t._a(this, _a[9], d);
    }

    public final double _p() {
        return this._u._a(this, _a[10]);
    }

    public final void _n(double d) {
        this._u._a(this, _a[10], d);
    }

    public final double _q() {
        return this._v._a(this, _a[11]);
    }

    public final void _o(double d) {
        this._v._a(this, _a[11], d);
    }

    public final double _r() {
        return this._w._a(this, _a[12]);
    }

    public final void _p(double d) {
        this._w._a(this, _a[12], d);
    }

    public final double _s() {
        return this._x._a(this, _a[13]);
    }

    public final void _q(double d) {
        this._x._a(this, _a[13], d);
    }

    public final double _t() {
        return this._y._a(this, _a[14]);
    }

    public final void _r(double d) {
        this._y._a(this, _a[14], d);
    }

    public final double _u() {
        return this._z._a(this, _a[15]);
    }

    public final void _s(double d) {
        this._z._a(this, _a[15], d);
    }

    public final double _v() {
        return this._A._a(this, _a[16]);
    }

    public final void _t(double d) {
        this._A._a(this, _a[16], d);
    }

    public final double _w() {
        return this._B._a(this, _a[17]);
    }

    public final void _u(double d) {
        this._B._a(this, _a[17], d);
    }

    public final double _x() {
        return this._C._a(this, _a[18]);
    }

    public final void _v(double d) {
        this._C._a(this, _a[18], d);
    }

    public final boolean _y() {
        return this._D;
    }

    public final void _a(boolean bl) {
        this._D = bl;
    }

    public final double _z() {
        return this._J;
    }

    public final void _w(double d) {
        this._J = d;
    }

    public final double _A() {
        return this._K;
    }

    public final void _x(double d) {
        this._K = d;
    }

    public final int _B() {
        return this._L;
    }

    public final void _a(int n) {
        this._L = n;
    }

    @NotNull
    public final gpjn _C() {
        return this._M;
    }

    public final void _D() {
        Object object;
        Object object22;
        this._D = false;
        xpzm._E().__ah._a("postprocess");
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP != null && entityClientPlayerMP.func_70055_a(tflj._h)) {
            this._t(1.0);
        }
        this._I = false;
        Iterable iterable = this._c;
        for (Object object22 : iterable) {
            object = (pidb)object22;
            ((pidb)object)._e();
        }
        iterable = this._d;
        Iterator iterator2 = iterable;
        object22 = new ArrayList();
        object = iterator2.iterator();
        while (object.hasNext()) {
            Object e = object.next();
            bqzs bqzs2 = (bqzs)e;
            if (!(!bqzs2.getActive())) continue;
            object22.add(e);
        }
        iterable = (List)object22;
        for (Object object22 : iterable) {
            object = (bqzs)object22;
            this._b((bqzs)object);
        }
        iterable = this._d;
        for (Object object22 : iterable) {
            object = (bqzs)object22;
            ((bqzs)object).doUpdate();
        }
        this._M._e();
        this._M();
        iterable = this._c;
        for (Object object22 : iterable) {
            object = (pidb)object22;
            ((pidb)object)._f();
            if (owkq._a(((pidb)object)._b(), 0.0, 0.0, 2, null)) {
                this._I = true;
                continue;
            }
            ((pidb)object)._g();
        }
        if (this._D) {
            this._I = true;
        }
        xpzm._E().__ah._b();
    }

    public final void _a(@NotNull bqzs bqzs2) {
        Object object;
        Intrinsics.checkParameterIsNotNull(bqzs2, "screenEffect");
        if (bqzs2.getEffectId() != null) {
            object = this._e.get(bqzs2.getEffectId());
            if (object != null) {
                this._b((bqzs)object);
            }
            Map map = this._e;
            Pair<String, bqzs> pair = TuplesKt.to(bqzs2.getEffectId(), bqzs2);
            map.put(pair.getFirst(), pair.getSecond());
        }
        object = this._d;
        object.add(bqzs2);
        bqzs2.setManager(this);
        bqzs2.doExecute();
    }

    public final void _b(@NotNull bqzs bqzs2) {
        Intrinsics.checkParameterIsNotNull(bqzs2, "screenEffect");
        this._d.remove(bqzs2);
        if (bqzs2.getEffectId() != null) {
            this._e.remove(bqzs2.getEffectId());
        }
    }

    public final void _a(@NotNull String string) {
        bqzs bqzs2;
        Intrinsics.checkParameterIsNotNull(string, "id");
        bqzs bqzs3 = this._e.get(string);
        if (bqzs3 == null) {
            return;
        }
        bqzs bqzs4 = bqzs2 = bqzs3;
        Intrinsics.checkExpressionValueIsNotNull(bqzs4, "effect");
        this._b(bqzs4);
    }

    public final boolean _b(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "id");
        return this._e.get(string) != null;
    }

    public final boolean _E() {
        return this._I;
    }

    @NotNull
    public final pidb _a(@NotNull KProperty1<jysc, Double> kProperty1) {
        KProperty1<jysc, Double> kProperty12;
        Intrinsics.checkParameterIsNotNull(kProperty1, "kProperty");
        KProperty1<jysc, Double> kProperty13 = kProperty12 = kProperty1;
        KCallablesJvm.setAccessible((KCallable)kProperty13, true);
        Object object = kProperty12.getDelegate(this);
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.effects.client.postprocess.effect.GameEffectManager.EffectParameter");
        }
        return (pidb)object;
    }

    public final void _a(int n, int n2, @NotNull jxtc jxtc2, float f) {
        Object object;
        Object t;
        Intrinsics.checkParameterIsNotNull(jxtc2, "shader");
        Object object2 = this._c;
        Iterator iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            t = iterator2.next();
            object = (pidb)t;
            ((pidb)object)._f();
            ((pidb)object)._e(f);
        }
        this._H._f();
        this._K();
        object2 = this._d;
        iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            t = iterator2.next();
            object = (bqzs)t;
            ((bqzs)object).renderUpdate(this, this._H);
        }
        object2 = this._H;
        iterator2 = object2;
        jxtc2._a("iResolution", (float)n, (float)n2);
        jxtc2._a("iGlobalTime", (float)this._F());
        jxtc2._a("dualityH", (float)this._c());
        jxtc2._a("dualityV", (float)this._b());
        jxtc2._a("edgeStretchAmount", (float)this._E);
        jxtc2._a("vignetteColor", VecExtensionsKt.getXf(((eidj)((Object)iterator2))._a()), VecExtensionsKt.getYf(((eidj)((Object)iterator2))._a()), VecExtensionsKt.getZf(((eidj)((Object)iterator2))._a()));
        jxtc2._a("vignetteRadius", (float)this._F);
        jxtc2._a("vignetteEdgeWidth", (float)this._G);
        jxtc2._a("contrastAmount", (float)this._d());
        jxtc2._a("noiseAmount", (float)this._o());
        jxtc2._a("grayAmount", (float)this._h());
        jxtc2._a("useScreenColor", ((eidj)((Object)iterator2))._d() ? 1 : 0);
        jxtc2._a("useAddColor", ((eidj)((Object)iterator2))._e() ? 1 : 0);
        jxtc2._a("screenColor", ((eidj)((Object)iterator2))._b());
        jxtc2._a("addColor", ((eidj)((Object)iterator2))._c());
        jxtc2._a("nv_ScreenColor", this._o);
        jxtc2._a("nv_AddColor", this._p);
        jxtc2._a("nv_GlitchAmount", (float)this._r);
        jxtc2._a("terma", (float)this._s());
        jxtc2._a("psi", (float)this._u());
        jxtc2._a("bio", (float)this._t());
        jxtc2._a("water", (float)this._v());
        jxtc2._a("useNv", (float)this._i());
        object2 = this._c;
        iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            t = iterator2.next();
            object = (pidb)t;
            ((pidb)object)._h();
        }
    }

    private final void _K() {
        this._L();
        this._E = owkq._i(this._G() * this._f() + this._g());
        ofbx ofbx2 = this._H._c();
        ofbx ofbx3 = VecExtensionsKt.vec3(RangesKt.coerceAtMost(owkq._i(this._n()), 0.2), 0.0, 0.0);
        Intrinsics.checkExpressionValueIsNotNull(ofbx3, "vec3(bloodAmount.saturat\u2026rceAtMost(0.2), 0.0, 0.0)");
        VecExtensionsKt.plusAssign(ofbx2, ofbx3);
        VecExtensionsKt.plusAssign(this._H._c(), this._w());
        VecExtensionsKt.plusAssign(this._H._b(), this._w());
    }

    private final void _L() {
        double d = this._i() > 0.0 ? this._i() : this._x() * 1.1;
        this._F = 0.75 + 2.0 * (1.0 - d);
        this._G = this._i() > 0.0 ? 0.5 : 0.75;
    }

    @NotNull
    public final ofbx _y(double d) {
        double d2 = this._a(System.currentTimeMillis() + (long)50);
        double d3 = Math.cos(d + (double)owkq._a() / 4.0) * Math.cos(d + (double)owkq._a() / 4.0);
        double d4 = Math.sin(d) * Math.sin(d);
        double d5 = Math.cos(d2 + (double)owkq._a() / 4.0) * Math.cos(d2 + (double)owkq._a() / 4.0);
        double d6 = Math.sin(d2) * Math.sin(d2);
        ofbx ofbx2 = ofbx._a(d5 - d3, d6 - d4, 0.0);
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "Vec3.createVectorHelper(\u2026C0, timeS1 - timeS0, 0.0)");
        return ofbx2;
    }

    @NotNull
    public static /* synthetic */ ofbx _a(jysc jysc2, double d, int n, Object object) {
        if ((n & 1) != 0) {
            d = jysc2._F();
        }
        return jysc2._y(d);
    }

    public final double _F() {
        return this._a(System.currentTimeMillis());
    }

    public final double _a(long l) {
        return (double)(l % (long)1000000) * 0.004;
    }

    public final double _G() {
        double d = McExtensionsKt.cos(this._e() * this._F());
        double d2 = McExtensionsKt.cos(this._e() * this._F() + (double)owkq._a() / 2.0);
        return Math.max(0.7071, Math.max(d, d2)) - 0.7071;
    }

    private final void _M() {
        this._K *= this._J * owkq._a(this._K, 0.01);
        this._K = owkq._i(this._K);
        if (this._L > 0) {
            int n = this._L;
            this._L = n + -1;
        }
    }

    private final void _a(pidb pidb2) {
        Collection collection = this._c;
        collection.add(pidb2);
    }

    public jysc() {
        jysc jysc2 = this;
        ArrayList arrayList = new ArrayList();
        jysc2._c = arrayList;
        this._d = new ArrayList();
        this._e = new HashMap();
        this._f = 1.0;
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 512.0;
        double d4 = 0.0;
        this._g = new pidb(this, 0.0, d3, d4, d2, d, 48, null);
        d = 0.0;
        d2 = 0.0;
        d3 = 512.0;
        d4 = 0.0;
        this._h = new pidb(this, 0.0, d3, d4, d2, d, 48, null);
        this._i = new pidb(this, 0.0, 5.0, 0.0, 0.0, 0.0, 56, null);
        this._j = new pidb(this, 0.0, 0.0, 0.0, 0.0, 0.0, 60, null);
        this._k = new pidb(this, 0.0, 1.0, 0.0, 0.99, 0.0, 40, null);
        this._l = new pidb(this, 0.0, 0.0, 0.0, 0.9, 0.0, 44, null);
        this._m = new pidb(this, 0.0, 1.0, 0.0, 0.0, 0.0, 56, null);
        this._n = new pidb(this, 0.0, 1.0, 0.0, 0.5, 0.0, 40, null);
        this._o = VecExtensionsKt.vec3(1.0);
        this._p = VecExtensionsKt.vec3(0.0);
        d = 0.0;
        d2 = 1.0;
        d3 = 0.0;
        d4 = 0.92;
        this._s = new pidb(this, 0.0, d2, d3, d4, d, 40, null);
        this._t = new pidb(this, 0.0, 0.0, 0.0, 0.97, 0.0, 44, null);
        this._u = new pidb(this, 0.0, 0.0, 0.0, 0.5, 0.0, 44, null);
        this._v = new pidb(this, 0.0, 0.0, 0.0, 0.5, 0.0, 44, null);
        this._w = new pidb(this, 0.0, 1.0, 0.0, 0.5, 0.0, 40, null);
        this._x = new pidb(this, 0.0, 2.0, 0.0, 0.97, 0.0, 40, null);
        this._y = new pidb(this, 0.0, 2.0, 0.0, 0.97, 0.0, 40, null);
        this._z = new pidb(this, 0.0, 2.0, 0.0, 0.97, 0.0, 40, null);
        this._A = new pidb(this, 0.0, 1.0, 0.0, 0.75, 0.0, 40, null);
        this._B = new pidb(this, 0.0, 1.0, 0.0, 0.9, 0.0, 40, null);
        this._C = new pidb(this, 0.0, 1.0, 0.0, 1.0, 0.0, 40, null);
        this._F = 2.0;
        this._H = new eidj();
        this._J = 0.999;
        this._M = new gpjn();
        this._a(new bqzs(null, 1, null).withFinishCondition(1._a).withContinousEffect((Function1<? super jysc, Unit>)new Function1<jysc, Unit>(){

            @Override
            public /* synthetic */ Object invoke(Object object) {
                this._a((jysc)object);
                return Unit.INSTANCE;
            }

            public final void _a(@NotNull jysc jysc2) {
                Intrinsics.checkParameterIsNotNull(jysc2, "it");
                _N = zwaw._p();
            }
        }));
    }

    static {
        _a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "dualityV", "getDualityV()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "dualityH", "getDualityH()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "contrastAmount", "getContrastAmount()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "heartBeatSpeed", "getHeartBeatSpeed()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "heartBeatPower", "getHeartBeatPower()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "damageIndicator", "getDamageIndicator()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "grayAmount", "getGrayAmount()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "nv_NightVisionAmount", "getNv_NightVisionAmount()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "bloodAmount", "getBloodAmount()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "noiseAmount", "getNoiseAmount()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "blurAmount", "getBlurAmount()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "lensDirtContrastOffset", "getLensDirtContrastOffset()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "lensAmount", "getLensAmount()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "terma", "getTerma()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "bio", "getBio()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "psi", "getPsi()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "water", "getWater()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "flashAmount", "getFlashAmount()D")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(jysc.class), "suppression", "getSuppression()D"))};
    }

    public static final /* synthetic */ boolean _a(jysc jysc2) {
        return jysc2._N;
    }

    @JvmStatic
    @Nullable
    public static final jysc _H() {
        return _b._a();
    }

    @JvmStatic
    @NotNull
    public static final jysc _I() {
        return _b._b();
    }

    @JvmStatic
    public static final void _J() {
        _b._c();
    }

    @JvmStatic
    public static final void _c(@NotNull bqzs bqzs2) {
        Intrinsics.checkParameterIsNotNull(bqzs2, "effect");
        _b._a(bqzs2);
    }

    @JvmStatic
    public static final void _c(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "id");
        _b._a(string);
    }

    @JvmStatic
    public static final boolean _d(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "id");
        return _b._b(string);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nJ\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\u000e\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0005J\u001f\u0010\u001f\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u00012\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+H\u0086\u0002J\u0006\u0010,\u001a\u00020$J\u000e\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0005J'\u0010 \u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\u00012\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0006\u0010/\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e\u00a8\u00060"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager$EffectParameter;", "", "effectManager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "defaultValue", "", "maxValue", "minValue", "decayFactor", "zeroThresold", "(Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;DDDDD)V", "getDecayFactor", "()D", "setDecayFactor", "(D)V", "defaultDecay", "getDefaultDecay", "getDefaultValue", "getEffectManager", "()Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "giveLerpValues", "", "lerpValue", "getLerpValue", "setLerpValue", "getMaxValue", "getMinValue", "prevValue", "getPrevValue", "setPrevValue", "value", "getValue", "setValue", "getZeroThresold", "setZeroThresold", "clamp", "", "decay", "disableLerpValue", "enableLerpValue", "frame", "thisRef", "property", "Lkotlin/reflect/KProperty;", "resetDecay", "setBiggerDecay", "newDecay", "newValue", "minecraft"})
    public static final class pidb {
        private double _a;
        private double _b;
        private double _c;
        private final double _d;
        private boolean _e;
        @NotNull
        private final jysc _f;
        private final double _g;
        private final double _h;
        private final double _i;
        private double _j;
        private double _k;

        public final double _a() {
            return this._a;
        }

        public final void _a(double d) {
            this._a = d;
        }

        public final double _b() {
            return this._b;
        }

        public final void _b(double d) {
            this._b = d;
        }

        public final double _c() {
            return this._c;
        }

        public final void _c(double d) {
            this._c = d;
        }

        public final double _d() {
            return this._d;
        }

        public final void _e() {
            boolean bl;
            this._a = this._b;
            this._b *= this._j * this._f._a();
            boolean bl2 = bl = this._b > 0.0;
            this._b = bl ? (this._b -= 0.001) : (this._b += 0.001);
            if (this._b > 0.0 != bl && owkq._e(this._b) < 0.01) {
                this._b = 0.0;
            }
        }

        public final void _d(double d) {
            if (this._j < d) {
                this._j = d;
            }
        }

        public final void _f() {
            this._b = owkq._b(this._b, this._i, this._h);
            if (owkq._e(this._b) < this._k) {
                this._b = 0.0;
            }
        }

        public final void _g() {
            this._j = this._d;
        }

        public final void _e(double d) {
            this._e = true;
            this._c = owkq._c(d, this._a, this._b);
        }

        public final void _h() {
            this._e = false;
        }

        public final double _a(@Nullable Object object, @NotNull KProperty<?> kProperty) {
            Intrinsics.checkParameterIsNotNull(kProperty, "property");
            return this._e ? this._c : this._b;
        }

        public final void _a(@Nullable Object object, @NotNull KProperty<?> kProperty, double d) {
            Intrinsics.checkParameterIsNotNull(kProperty, "property");
            this._b = d;
        }

        @NotNull
        public final jysc _i() {
            return this._f;
        }

        public final double _j() {
            return this._g;
        }

        public final double _k() {
            return this._h;
        }

        public final double _l() {
            return this._i;
        }

        public final double _m() {
            return this._j;
        }

        public final void _f(double d) {
            this._j = d;
        }

        public final double _n() {
            return this._k;
        }

        public final void _g(double d) {
            this._k = d;
        }

        public pidb(@NotNull jysc jysc2, double d, double d2, double d3, double d4, double d5) {
            Intrinsics.checkParameterIsNotNull(jysc2, "effectManager");
            this._f = jysc2;
            this._g = d;
            this._h = d2;
            this._i = d3;
            this._j = d4;
            this._k = d5;
            this._a = this._g;
            this._b = this._g;
            this._c = this._g;
            this._d = this._j;
            this._f._a(this);
        }

        public /* synthetic */ pidb(jysc jysc2, double d, double d2, double d3, double d4, double d5, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                d2 = DoubleCompanionObject.INSTANCE.getMAX_VALUE();
            }
            if ((n & 8) != 0) {
                d3 = 0.0;
            }
            if ((n & 0x10) != 0) {
                d4 = 0.97;
            }
            if ((n & 0x20) != 0) {
                d5 = 0.002;
            }
            this(jysc2, d, d2, d3, d4, d5);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007\u00a8\u0006\u0014"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager$ImmediateRenderParams;", "", "()V", "addColor", "Lnet/minecraft/util/Vec3;", "kotlin.jvm.PlatformType", "getAddColor", "()Lnet/minecraft/util/Vec3;", "screenColor", "getScreenColor", "shouldAddScreenColor", "", "getShouldAddScreenColor", "()Z", "shouldMultiplyScreenColor", "getShouldMultiplyScreenColor", "vignetteColor", "getVignetteColor", "reset", "", "minecraft"})
    public static final class eidj {
        private final ofbx _a = VecExtensionsKt.vec3(1.0, 0.0, 0.0);
        private final ofbx _b = VecExtensionsKt.vec3(1.0, 1.0, 1.0);
        private final ofbx _c = VecExtensionsKt.vec3(0.0, 0.0, 0.0);

        public final ofbx _a() {
            return this._a;
        }

        public final ofbx _b() {
            return this._b;
        }

        public final ofbx _c() {
            return this._c;
        }

        public final boolean _d() {
            return owkq._a(this._b._c, 1.0, 0.0, 2, null) || owkq._a(this._b._d, 1.0, 0.0, 2, null) || owkq._a(this._b._e, 1.0, 0.0, 2, null);
        }

        public final boolean _e() {
            return owkq._a(this._c._c, 0.0, 0.0, 2, null) || owkq._a(this._c._d, 0.0, 0.0, 2, null) || owkq._a(this._c._e, 0.0, 0.0, 2, null);
        }

        public final void _f() {
            VecExtensionsKt.reset(this._a);
            VecExtensionsKt.reset(this._c);
            VecExtensionsKt.set(this._b, 1.0, 1.0, 1.0);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\b\u0010\u000f\u001a\u00020\fH\u0007\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager$Companion;", "", "()V", "addEffectIfAvailable", "", "effect", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "hasEffectByIdIfAvailable", "", "id", "", "instance", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "removeEffectByIdIfAvailable", "restartEffectRenderer", "unsafeInstance", "minecraft"})
    public static final class kjui {
        @JvmStatic
        @Nullable
        public final jysc _a() {
            Object object = gloomyfolken.mods.effects.client.main.eidj._a;
            return object != null && (object = ((gloomyfolken.mods.effects.client.main.eidj)object)._c) != null ? ((hsmn)object)._b : null;
        }

        @JvmStatic
        @NotNull
        public final jysc _b() {
            Object object = gloomyfolken.mods.effects.client.main.eidj._a;
            jysc jysc2 = object != null && (object = ((gloomyfolken.mods.effects.client.main.eidj)object)._c) != null ? ((hsmn)object)._b : null;
            if (jysc2 == null) {
                Intrinsics.throwNpe();
            }
            return jysc2;
        }

        @JvmStatic
        public final void _c() {
            block0: {
                Object object;
                Object object2 = gloomyfolken.mods.effects.client.main.eidj._a;
                if (object2 == null || (object2 = ((gloomyfolken.mods.effects.client.main.eidj)object2)._c) == null) break block0;
                Object object3 = object = object2;
                ((hsmn)object3)._b = ((hsmn)object3)._a();
            }
        }

        @JvmStatic
        public final void _a(@NotNull bqzs bqzs2) {
            block0: {
                Intrinsics.checkParameterIsNotNull(bqzs2, "effect");
                jysc jysc2 = this._a();
                if (jysc2 == null) break block0;
                jysc2._a(bqzs2);
            }
        }

        @JvmStatic
        public final void _a(@NotNull String string) {
            block0: {
                Intrinsics.checkParameterIsNotNull(string, "id");
                jysc jysc2 = this._a();
                if (jysc2 == null) break block0;
                jysc2._a(string);
            }
        }

        @JvmStatic
        public final boolean _b(@NotNull String string) {
            Intrinsics.checkParameterIsNotNull(string, "id");
            jysc jysc2 = this._a();
            return jysc2 != null ? jysc2._b(string) : false;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

