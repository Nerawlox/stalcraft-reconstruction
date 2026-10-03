/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.jgro;
import gloomyfolken.mods.effects.client.main.kjui;
import gloomyfolken.mods.effects.client.main.tupg;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.client.xpzm;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u0006H\u0007J\u0016\u0010;\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0>H\u0007J\u0010\u0010;\u001a\u00020<2\u0006\u0010?\u001a\u00020@H\u0007J\b\u0010A\u001a\u00020(H\u0007J\b\u0010B\u001a\u00020<H\u0007J\b\u0010C\u001a\u00020<H\u0007J\u0016\u0010D\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0>H\u0007J\b\u0010E\u001a\u00020\u0012H\u0007J\u001c\u0010F\u001a\u00020\u00122\b\b\u0002\u0010G\u001a\u00020\u00192\b\b\u0002\u0010H\u001a\u00020\u0012H\u0007J\b\u0010I\u001a\u00020<H\u0002J\u0010\u0010J\u001a\u00020<2\u0006\u0010:\u001a\u00020\u0006H\u0007J\b\u0010K\u001a\u00020<H\u0007J\u0012\u0010L\u001a\u00020\u00122\b\b\u0002\u0010G\u001a\u00020\u0019H\u0007J\b\u0010M\u001a\u00020<H\u0007J\b\u0010N\u001a\u00020<H\u0002J\b\u0010O\u001a\u00020<H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R,\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@BX\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00198FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u00198FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\u001cR\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u00020(8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0002\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b-\u0010\u0002\u001a\u0004\b.\u0010\u0010R,\u0010/\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128\u0006@BX\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0002\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u000e\u00103\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u00105\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u0002\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017\u00a8\u0006P"}, d2={"Lgloomyfolken/mods/effects/client/main/FboPipeline;", "", "()V", "_multisampledFbo", "Lgloomyfolken/mods/effects/client/main/FramebufferObject;", "<set-?>", "Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "antialiasingMode", "antialiasingMode$annotations", "getAntialiasingMode", "()Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "setAntialiasingMode", "(Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;)V", "backbufferedFbo", "backbufferedFbo$annotations", "getBackbufferedFbo", "()Lgloomyfolken/mods/effects/client/main/FramebufferObject;", "debugBuffers", "", "debugBuffers$annotations", "getDebugBuffers", "()Z", "setDebugBuffers", "(Z)V", "displayHeight", "", "displayHeight$annotations", "getDisplayHeight", "()I", "displayWidth", "displayWidth$annotations", "getDisplayWidth", "framebuffersValid", "fxaaOn", "fxaaOn$annotations", "getFxaaOn", "setFxaaOn", "lastMemInfo", "", "mainDepth", "Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "mainDepth$annotations", "getMainDepth", "()Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "multisampledFbo", "multisampledFbo$annotations", "getMultisampledFbo", "multisampling", "multisampling$annotations", "getMultisampling", "setMultisampling", "prevRequestedAntialiasingMode", "resolvedMultisampleThisFrame", "useFBO", "useFBO$annotations", "getUseFBO", "setUseFBO", "checkAntialiasingAvailable", "mode", "drawWithoutFiltering", "", "action", "Lkotlin/Function0;", "runnable", "Ljava/lang/Runnable;", "getSceneTexture", "prepareFrame", "renderFboToScreen", "renderToNextTargetUsingActive", "resolveFrameMultisampling", "resolveMultisampling", "copyBits", "force", "revalidateFramebuffers", "setAntialiasing", "setRenderTargetToScene", "startMultisampling", "toggleSceneFboAndClear", "updateFramebufferResolutions", "updateSettings", "minecraft"})
public final class zwaw {
    @NotNull
    private static final uyuh _b;
    private static jgro _c;
    @NotNull
    private static final jgro _d;
    private static boolean _e;
    private static boolean _f;
    private static jhpr _g;
    @NotNull
    private static jhpr _h;
    private static boolean _i;
    private static boolean _j;
    private static boolean _k;
    private static long _l;
    private static boolean _m;
    public static final zwaw _a;

    @JvmStatic
    public static /* synthetic */ void _a() {
    }

    public static final int _b() {
        return xpzm._E()._n;
    }

    @JvmStatic
    public static /* synthetic */ void _c() {
    }

    public static final int _d() {
        return xpzm._E()._o;
    }

    @JvmStatic
    public static /* synthetic */ void _e() {
    }

    @NotNull
    public static final uyuh _f() {
        return _b;
    }

    @JvmStatic
    public static /* synthetic */ void _g() {
    }

    @NotNull
    public static final jgro _h() {
        jgro jgro2 = _c;
        if (jgro2 == null) {
            throw (Throwable)new IllegalStateException("Tried to access multisampled scene buffer when it does not exist (probably the antialiasing is off). Multisampled buffer is disabled when there is no antialiasing.");
        }
        return jgro2;
    }

    @JvmStatic
    public static /* synthetic */ void _i() {
    }

    @NotNull
    public static final jgro _j() {
        return _d;
    }

    @JvmStatic
    public static /* synthetic */ void _k() {
    }

    @NotNull
    public static final jhpr _l() {
        return _h;
    }

    private static final void _c(jhpr jhpr2) {
        _h = jhpr2;
    }

    @JvmStatic
    public static /* synthetic */ void _m() {
    }

    public static final boolean _n() {
        return _i;
    }

    public static final void _a(boolean bl) {
        _i = bl;
    }

    @JvmStatic
    public static /* synthetic */ void _o() {
    }

    public static final boolean _p() {
        return _j;
    }

    public static final void _b(boolean bl) {
        _j = bl;
    }

    @JvmStatic
    public static /* synthetic */ void _q() {
    }

    public static final boolean _r() {
        return _k;
    }

    public static final void _c(boolean bl) {
        _k = bl;
    }

    @JvmStatic
    public static /* synthetic */ void _s() {
    }

    public static final boolean _t() {
        return _m;
    }

    private static final void _d(boolean bl) {
        _m = bl;
    }

    private final void _A() {
        jgro jgro2 = _c;
        if (jgro2 != null) {
            jgro2._l();
        }
        _c = null;
        if (_h._a()) {
            _c = jgro.kjui._a(jgro._a, "scene_multisampled", true, true, new Dimension(zwaw._b(), zwaw._d()), _h, null, 32, null);
            zwaw._h()._a(true, true);
        }
    }

    private final void _B() {
        Dimension dimension = new Dimension(zwaw._b(), zwaw._d());
        jgro jgro2 = _c;
        if (jgro2 != null) {
            jgro2._a(dimension);
        }
        _d._a(dimension);
        _b._a(dimension);
    }

    private final void _C() {
        _j = ClientProxy.fxaaOn.enabled;
        jhpr jhpr2 = jhpr.values()[ClientProxy.antialiasingMode.value];
        if (Intrinsics.areEqual((Object)jhpr2, (Object)_g) ^ true) {
            _g = jhpr2;
            zwaw._b(jhpr2);
        }
    }

    @JvmStatic
    public static final boolean _a(@NotNull jhpr jhpr2) {
        Intrinsics.checkParameterIsNotNull((Object)jhpr2, "mode");
        return !tupg._a._a() && GL11.glGetInteger(36183) >= jhpr2._b() && (eidj._K || !jhpr2._d());
    }

    @JvmStatic
    public static final void _b(@NotNull jhpr jhpr2) {
        Intrinsics.checkParameterIsNotNull((Object)jhpr2, "mode");
        _h = jhpr._a;
        if (zwaw._a(jhpr2)) {
            _h = jhpr2;
        }
        _e = false;
    }

    @JvmStatic
    public static final void _a(final @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        zwaw._a(new Function0<Unit>(){

            @Override
            public /* synthetic */ Object invoke() {
                this._a();
                return Unit.INSTANCE;
            }

            public final void _a() {
                runnable.run();
            }
        });
    }

    @JvmStatic
    public static final void _a(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "action");
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10241, 9728);
        function0.invoke();
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10241, 9729);
    }

    @JvmStatic
    public static final void _b(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "action");
        _d._a(function0);
    }

    @JvmStatic
    public static final void _u() {
        if (_i) {
            GL11.glEnable(3553);
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            GL11.glDisable(2896);
            GL11.glDisable(3042);
            ejef._b();
            jgro._a._i();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            zwaw._z()._b(0);
            hsmn._e();
            hsmn._c();
            float f = 0.16666667f;
            float f2 = 1.0f / f;
            if (_k) {
                int n;
                GL11.glScalef(f, f, 1.0f);
                Iterable iterable = RangesKt.downTo(3, 0);
                Collection collection = CollectionsKt.plus((Collection)ArraysKt.toList((Object[])_d._i()._h()), _b);
                Iterable iterable2 = iterable;
                Collection collection2 = new ArrayList();
                Iterator<Object> iterator22 = iterable2.iterator();
                while (iterator22.hasNext()) {
                    int n2 = ((IntIterator)iterator22).nextInt();
                    n = n2;
                    uyuh[] uyuhArray = fmgg._a._a(n);
                    List<Object> list = uyuhArray != null && (uyuhArray = uyuhArray._i()) != null && (uyuhArray = uyuhArray._h()) != null ? ArraysKt.toList((Object[])uyuhArray) : null;
                    List<Object> list2 = list;
                    if (list2 == null) {
                        list2 = CollectionsKt.emptyList();
                    }
                    Iterable iterable3 = list2;
                    CollectionsKt.addAll(collection2, iterable3);
                }
                List list = (List)collection2;
                iterable = CollectionsKt.filterNotNull(CollectionsKt.plus(collection, (Iterable)list));
                int n3 = 0;
                for (Iterator<Object> iterator22 : iterable) {
                    int n4 = n3++;
                    uyuh uyuh2 = (uyuh)((Object)iterator22);
                    n = n4;
                    if (n % (int)f2 == 0 && n > 0) {
                        GL11.glTranslatef(zwaw._b(), -((float)zwaw._d()) * f2, 0.0f);
                    }
                    uyuh2._b(0);
                    hsmn._c();
                    GL11.glTranslatef(0.0f, zwaw._d(), 0.0f);
                }
            }
            hsmn._f();
            GL11.glEnable(3008);
        }
    }

    @JvmStatic
    public static final void _v() {
        if (_i) {
            _a._C();
            if (!_e) {
                _e = true;
                _a._A();
            }
            _a._B();
            _d._i()._g();
            jgro._a._h();
            _f = false;
            fmgg._a._a();
        }
        if (System.currentTimeMillis() - _l > (long)1000) {
            _l = System.currentTimeMillis();
        }
    }

    @JvmStatic
    public static final void _w() {
        if (_i) {
            _d._a(false);
            jgro._a(_d, _d._j(), 0, 2, null);
            jgro._a(_d, _b, 0, 2, null);
            GL11.glClearStencil(0);
            GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            if (_i && _h._a()) {
                GL11.glClear(1024);
            }
            zwaw._a(0);
            GL11.glClear(17664);
        }
    }

    @JvmStatic
    public static final boolean _a(int n) {
        if (_i && _h._a()) {
            zwaw._h()._a(true);
            if (n > 0) {
                jgro._a._a(_d, zwaw._h(), n);
            }
            GL11.glEnable(32925);
            _m = true;
            return true;
        }
        return false;
    }

    @JvmStatic
    public static /* bridge */ /* synthetic */ boolean _a(int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 17408;
        }
        return zwaw._a(n);
    }

    @JvmStatic
    public static final boolean _x() {
        return zwaw._a(16640, false);
    }

    @JvmStatic
    public static final boolean _a(int n, boolean bl) {
        if (_f && !bl) {
            return false;
        }
        if (!bl) {
            _f = true;
        }
        if (_i && _h._a() && Intrinsics.areEqual(jgro._a._b(), zwaw._h())) {
            _m = false;
            GL11.glDisable(32925);
            jgro._a._g();
            if (n > 0) {
                jgro._a._a(zwaw._h(), _d, n);
            }
            return true;
        }
        return false;
    }

    @JvmStatic
    public static /* bridge */ /* synthetic */ boolean _a(int n, boolean bl, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 16640;
        }
        if ((n2 & 2) != 0) {
            bl = false;
        }
        return zwaw._a(n, bl);
    }

    @JvmStatic
    public static final void _y() {
        jgro._a(_d, _d._j(), 0, 2, null);
    }

    @JvmStatic
    @NotNull
    public static final uyuh _z() {
        return _d._i()._b()._c();
    }

    private zwaw() {
        _a = this;
        _b = new uyuh("depth_scene", zwaw._b(), zwaw._d(), fmfc._c, false, false, null, 112, null)._i();
        _d = jgro._a._a("backbuffered_main", true, true, new Dimension(zwaw._b(), zwaw._d()), jhpr._a, new kjui(new uyuh("fullscreen_color_0_ldr", zwaw._b(), zwaw._d(), fmfc._a, true, true, null, 64, null)._i(), new uyuh("fullscreen_color_1_ldr", zwaw._b(), zwaw._d(), fmfc._a, true, true, null, 64, null)._i(), new uyuh("fullscreen_color_2_ldr", zwaw._b(), zwaw._d(), fmfc._a, true, true, null, 64, null)._i()));
        _g = jhpr._a;
        _h = jhpr._a;
        _i = true;
    }

    static {
        new zwaw();
    }
}

