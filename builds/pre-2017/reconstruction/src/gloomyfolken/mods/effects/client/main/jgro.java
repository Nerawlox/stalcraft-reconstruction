/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import gloomyfolken.mods.effects.client.main.kjui;
import gloomyfolken.mods.effects.client.main.tupg;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.EXTFramebufferBlit;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 ^2\u00020\u0001:\u0003^_`B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020\tJ\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00132\b\b\u0002\u0010<\u001a\u00020\tJ\b\u0010=\u001a\u000209H\u0002J\u000e\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020\u0013J\b\u0010@\u001a\u000209H$J\u0012\u0010A\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010B\u001a\u00020\tJ\b\u0010C\u001a\u0004\u0018\u00010\u0013J\u0016\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0005J\u001a\u0010G\u001a\u0002092\b\b\u0002\u0010H\u001a\u00020I2\b\b\u0002\u0010<\u001a\u00020\tJ\u0018\u0010J\u001a\u0004\u0018\u00010\u00132\u0006\u0010H\u001a\u00020I2\u0006\u0010K\u001a\u00020\tJ\u0010\u0010L\u001a\u0004\u0018\u00010\u00132\u0006\u0010K\u001a\u00020\tJ\u0006\u0010M\u001a\u00020;J\u0006\u0010N\u001a\u00020\u0005J\b\u0010O\u001a\u000209H\u0002J\b\u0010P\u001a\u000209H\u0002J\u0006\u0010Q\u001a\u000209J\b\u0010R\u001a\u000209H$J\u0014\u0010S\u001a\u0002092\f\u0010T\u001a\b\u0012\u0004\u0012\u0002090UJ&\u0010S\u001a\u0002092\f\u0010T\u001a\b\u0012\u0004\u0012\u0002090U2\b\b\u0002\u0010V\u001a\u00020;2\u0006\u0010W\u001a\u00020\u0005J\u0014\u0010X\u001a\u0002092\f\u0010T\u001a\b\u0012\u0004\u0012\u0002090UJ\u001e\u0010X\u001a\u0002092\f\u0010T\u001a\b\u0012\u0004\u0012\u0002090U2\b\b\u0002\u0010V\u001a\u00020;J\u000e\u0010Y\u001a\u0002092\u0006\u0010Z\u001a\u000205J\u0010\u0010[\u001a\u0002092\b\b\u0002\u0010\\\u001a\u00020\u0005J\b\u0010]\u001a\u000209H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R(\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001b@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001b@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u000e\u0010$\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t@DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\tX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u0010\u0006\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u000e\u00101\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u000205\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107\u00a8\u0006a"}, d2={"Lgloomyfolken/mods/effects/client/main/FramebufferObject;", "", "name", "", "hasDepth", "", "hasStencil", "(Ljava/lang/String;ZZ)V", "MAX_COLOR_ATTACHMENTS", "", "_backBufferSet", "Lgloomyfolken/mods/effects/client/main/BackBufferSet;", "aaMode", "Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "backBufferSet", "getBackBufferSet", "()Lgloomyfolken/mods/effects/client/main/BackBufferSet;", "boundColorAttachments", "", "Lgloomyfolken/mods/effects/client/texture/FramebufferAttachment;", "[Lgloomyfolken/mods/effects/client/texture/FramebufferAttachment;", "<set-?>", "boundDSAttachment", "getBoundDSAttachment", "()Lgloomyfolken/mods/effects/client/texture/FramebufferAttachment;", "setBoundDSAttachment", "(Lgloomyfolken/mods/effects/client/texture/FramebufferAttachment;)V", "Lgloomyfolken/mods/effects/client/texture/RenderbufferObject;", "colorRenderBuffer", "getColorRenderBuffer", "()Lgloomyfolken/mods/effects/client/texture/RenderbufferObject;", "setColorRenderBuffer", "(Lgloomyfolken/mods/effects/client/texture/RenderbufferObject;)V", "dsRenderBuffer", "getDsRenderBuffer", "setDsRenderBuffer", "framebufferHeight", "framebufferId", "getFramebufferId", "()I", "setFramebufferId", "(I)V", "framebufferWidth", "glStatus", "getGlStatus", "setGlStatus", "getHasDepth", "()Z", "getHasStencil", "isInvalid", "getName", "()Ljava/lang/String;", "resolution", "Ljava/awt/Dimension;", "getResolution", "()Ljava/awt/Dimension;", "attachRenderTarget", "", "framebufferTexture", "Lgloomyfolken/mods/effects/client/main/BackBufferSet$BufferedTexture;", "colorIndex", "bind", "checkAttachmentCompatible", "attachment", "create", "createColorRenderBuffer", "slot", "createDSRenderBuffer", "createRenderBuffers", "color", "depth", "detachRenderTarget", "fbAttachmentTarget", "Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "getAttachment", "index", "getColorAttachment", "getSceneTexture", "isMultisampled", "popFramebuffer", "pushFramebuffer", "release", "releaseFramebuffer", "renderToNextTarget", "action", "Lkotlin/Function0;", "rt", "useActive", "renderToNextTargetUsingActive", "setResolution", "newResolution", "switchFbo", "push", "validate", "Companion", "FramebufferObjectCore", "FramebufferObjectEXT", "minecraft"})
public abstract class jgro {
    private int _b;
    private int _c;
    private int _d;
    private int _e;
    private jhpr _f;
    @NotNull
    private final Dimension _g;
    @Nullable
    private zgbh _h;
    @Nullable
    private zgbh _i;
    private boolean _j;
    private final int _k = 16;
    private tvno[] _l;
    @Nullable
    private tvno _m;
    private gloomyfolken.mods.effects.client.main.kjui _n;
    @NotNull
    private final String _o;
    private final boolean _p;
    private final boolean _q;
    private static final ArrayList<jgro> _r;
    @Nullable
    private static jgro _s;
    private static int _t;
    private static int _u;
    private static final int _v = 1;
    private static final int _w = 2;
    private static final int _x = 3;
    public static final kjui _a;

    protected final int _a() {
        return this._b;
    }

    protected final void _a(int n) {
        this._b = n;
    }

    public final int _b() {
        return this._c;
    }

    protected final void _b(int n) {
        this._c = n;
    }

    @NotNull
    public final Dimension _c() {
        return this._g;
    }

    @Nullable
    public final zgbh _d() {
        return this._h;
    }

    private final void _a(zgbh zgbh2) {
        this._h = zgbh2;
    }

    @Nullable
    public final zgbh _e() {
        return this._i;
    }

    private final void _b(zgbh zgbh2) {
        this._i = zgbh2;
    }

    protected abstract void _f();

    protected abstract void _g();

    @Nullable
    public final tvno _h() {
        return this._m;
    }

    private final void _b(tvno tvno2) {
        this._m = tvno2;
    }

    @NotNull
    public final gloomyfolken.mods.effects.client.main.kjui _i() {
        gloomyfolken.mods.effects.client.main.kjui kjui2 = this._n;
        if (kjui2 == null) {
            throw (Throwable)new IllegalStateException("Tried to access back-buffer of not back-buffered FBO!");
        }
        return kjui2;
    }

    public final void _a(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "action");
        this._a(function0, this._i()._f());
    }

    public final void _a(@NotNull Function0<Unit> function0, @NotNull kjui.kjui kjui2) {
        Intrinsics.checkParameterIsNotNull(function0, "action");
        Intrinsics.checkParameterIsNotNull(kjui2, "rt");
        this._a(function0, kjui2, true);
    }

    public static /* synthetic */ void _a(jgro jgro2, Function0 function0, kjui.kjui kjui2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderToNextTargetUsingActive");
        }
        if ((n & 2) != 0) {
            kjui2 = jgro2._i()._f();
        }
        jgro2._a(function0, kjui2);
    }

    public final void _b(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "action");
        this._a(function0, this._i()._f(), false);
    }

    public final void _a(@NotNull Function0<Unit> function0, @NotNull kjui.kjui kjui2, boolean bl) {
        Intrinsics.checkParameterIsNotNull(function0, "action");
        Intrinsics.checkParameterIsNotNull(kjui2, "rt");
        if (Intrinsics.areEqual(kjui2, this._i()._b())) {
            throw (Throwable)new IllegalStateException("Target RT can't be the scene if the scene texture is going to be used!");
        }
        this._a(false);
        jgro._a(this, kjui2, 0, 2, null);
        if (bl) {
            tvno.pidb._b(this._i()._b()._c(), 0, 1, null);
        }
        function0.invoke();
        kjui2._a(true);
    }

    public static /* synthetic */ void _a(jgro jgro2, Function0 function0, kjui.kjui kjui2, boolean bl, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderToNextTarget");
        }
        if ((n & 2) != 0) {
            kjui2 = jgro2._i()._f();
        }
        jgro2._a(function0, kjui2, bl);
    }

    @NotNull
    public final kjui.kjui _j() {
        return this._i()._b();
    }

    public final boolean _k() {
        return this._f._a();
    }

    public final void _l() {
        int n;
        int n2;
        if (this._c > 0) {
            this._g();
            this._c = -1;
        }
        if ((n2 = 0) <= (n = this._k - 1)) {
            while (true) {
                this._l[n2] = null;
                if (n2 == n) break;
                ++n2;
            }
        }
        this._m = null;
        zgbh zgbh2 = this._h;
        if (zgbh2 != null) {
            zgbh2._d();
        }
        zgbh zgbh3 = this._i;
        if (zgbh3 != null) {
            zgbh3._d();
        }
        this._h = null;
        this._i = null;
        this._j = true;
    }

    public final void _a(@NotNull tvno tvno2) {
        Intrinsics.checkParameterIsNotNull(tvno2, "attachment");
        if (Intrinsics.areEqual((Object)this._f, (Object)tvno2._b()) ^ true) {
            throw (Throwable)new IllegalStateException("FBO and all its attachments must have the same antialiasing mode!");
        }
        if (this._d != tvno2._c().width || this._e != tvno2._c().height) {
            throw (Throwable)new IllegalStateException("FBO and all its attachments must have the same resolution!");
        }
    }

    @NotNull
    public final jgro _a(boolean bl, boolean bl2) {
        if (bl) {
            jgro._a(this, 0, 1, null);
        }
        if (bl2 && this._p) {
            this._m();
        }
        return this;
    }

    @Nullable
    public final tvno _c(int n) {
        zgbh zgbh2 = this._h;
        if (zgbh2 != null) {
            zgbh2._d();
        }
        zgbh zgbh3 = this._h = zgbh._b._a("" + this._o + "_COLOR", this._g.width, this._g.height, fmfc._a, this._f)._i();
        if (zgbh3 == null) {
            Intrinsics.throwNpe();
        }
        zgbh3._i();
        return this._h;
    }

    @Nullable
    public static /* synthetic */ tvno _a(jgro jgro2, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createColorRenderBuffer");
        }
        if ((n2 & 1) != 0) {
            n = 0;
        }
        return jgro2._c(n);
    }

    @Nullable
    public final tvno _m() {
        zgbh zgbh2 = this._i;
        if (zgbh2 != null) {
            zgbh2._d();
        }
        if (!this._p) {
            throw (Throwable)new IllegalStateException("Tried to create depth buffer for a FBO without depth! Please, create FBO with depth enabled if you need to attach a depth buffer.");
        }
        fmfc fmfc2 = this._q ? fmfc._c : fmfc._b;
        this._i = zgbh._b._a("" + this._o + '_' + fmfc2.name(), this._g.width, this._g.height, fmfc2, this._f)._i();
        return this._i;
    }

    public final void _a(@NotNull Dimension dimension) {
        block2: {
            Intrinsics.checkParameterIsNotNull(dimension, "newResolution");
            if (this._d == dimension.width && this._e == dimension.height) break block2;
            this._d = dimension.width;
            this._e = dimension.height;
            this._g.setSize(dimension);
            Iterable iterable = CollectionsKt.filterNotNull((Iterable)CollectionsKt.listOf(new zgbh[]{this._h, this._i}));
            for (Object t : iterable) {
                zgbh zgbh2 = (zgbh)t;
                zgbh2._a(this._g);
            }
            gloomyfolken.mods.effects.client.main.kjui kjui2 = this._n;
            if (kjui2 != null) {
                kjui2._a(this._g);
            }
        }
    }

    public final void _a(boolean bl) {
        if (this._j) {
            throw (Throwable)new IllegalStateException("The framebuffer " + this._o + " was released and is invalid to be used.");
        }
        if (bl) {
            this._F();
        }
        this._H();
        if (this._h != null) {
            zgbh zgbh2 = this._h;
            if (zgbh2 == null) {
                Intrinsics.throwNpe();
            }
            jgro._a(this, zgbh2, 0, 2, null);
        }
        if (this._i != null) {
            zgbh zgbh3 = this._i;
            if (zgbh3 == null) {
                Intrinsics.throwNpe();
            }
            jgro._a(this, zgbh3, 0, 2, null);
        }
    }

    public static /* synthetic */ void _a(jgro jgro2, boolean bl, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchFbo");
        }
        if ((n & 1) != 0) {
            bl = true;
        }
        jgro2._a(bl);
    }

    private final void _F() {
        if (_a._b() != null) {
            ArrayList arrayList = jgro._a._l();
            jgro jgro2 = _a._b();
            if (jgro2 == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(jgro2);
        }
    }

    private final void _G() {
        if (jgro._a._l().size() == 0) {
            _a._i();
        } else {
            jgro jgro2 = (jgro)jgro._a._l().remove(jgro._a._l().size() - 1);
            if (Intrinsics.areEqual(jgro2, this) ^ true) {
                jgro2._H();
            }
        }
    }

    private final void _H() {
        _a._a(this._d, this._e);
        if (Intrinsics.areEqual(_a._b(), this) ^ true) {
            jgro._a._b(jgro._a._e(), this._c);
        }
        jgro._a._a(this);
    }

    public final void _a(@NotNull kjui.kjui kjui2, int n) {
        Intrinsics.checkParameterIsNotNull(kjui2, "framebufferTexture");
        this._a(kjui2._c(), n);
    }

    public static /* synthetic */ void _a(jgro jgro2, kjui.kjui kjui2, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachRenderTarget");
        }
        if ((n2 & 2) != 0) {
            n = 0;
        }
        jgro2._a(kjui2, n);
    }

    public final void _a(@NotNull tvno tvno2, int n) {
        Intrinsics.checkParameterIsNotNull(tvno2, "framebufferTexture");
        this._a(tvno2);
        boolean bl = Intrinsics.areEqual(_a._b(), this) ^ true;
        if (bl) {
            this._a(true);
        }
        tvno2._a(n);
        if (tvno2._a()._a()) {
            this._l[n] = tvno2;
        } else {
            this._m = tvno2;
        }
        if (bl) {
            this._G();
        }
    }

    public static /* synthetic */ void _a(jgro jgro2, tvno tvno2, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachRenderTarget");
        }
        if ((n2 & 2) != 0) {
            n = 0;
        }
        jgro2._a(tvno2, n);
    }

    public final void _a(@NotNull fmfc fmfc2, int n) {
        Intrinsics.checkParameterIsNotNull((Object)fmfc2, "fbAttachmentTarget");
        boolean bl = Intrinsics.areEqual(_a._b(), this) ^ true;
        if (bl) {
            this._a(true);
        }
        uyuh uyuh2 = uyuh._b._d().get((Object)fmfc2);
        if (uyuh2 != null) {
            uyuh2._a(n);
        }
        if (fmfc2._a()) {
            this._l[n] = null;
        } else {
            this._m = null;
        }
        if (bl) {
            this._G();
        }
    }

    public static /* synthetic */ void _a(jgro jgro2, fmfc fmfc2, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: detachRenderTarget");
        }
        if ((n2 & 1) != 0) {
            fmfc2 = fmfc._a;
        }
        if ((n2 & 2) != 0) {
            n = 0;
        }
        jgro2._a(fmfc2, n);
    }

    @Nullable
    public final tvno _b(@NotNull fmfc fmfc2, int n) {
        Intrinsics.checkParameterIsNotNull((Object)fmfc2, "fbAttachmentTarget");
        if (fmfc2._a()) {
            return this._l[n];
        }
        return this._m;
    }

    @Nullable
    public final tvno _d(int n) {
        return this._l[n];
    }

    public void _n() {
    }

    @NotNull
    protected final String _o() {
        return this._o;
    }

    protected final boolean _p() {
        return this._p;
    }

    protected final boolean _q() {
        return this._q;
    }

    protected jgro(@NotNull String string, boolean bl, boolean bl2) {
        tvno[] tvnoArray;
        Intrinsics.checkParameterIsNotNull(string, "name");
        this._o = string;
        this._p = bl;
        this._q = bl2;
        this._c = -1;
        this._d = -1;
        this._e = -1;
        this._f = jhpr._a;
        this._g = new Dimension(this._d, this._e);
        if (this._q && !this._p) {
            throw (Throwable)new IllegalStateException("Current implementation does not support a separate stencil buffer. Please, use" + "packed depth_stencil instead! FBO '" + this._o + "' won't be created!");
        }
        int n = this._k = 16;
        jgro jgro2 = this;
        tvno[] tvnoArray2 = new tvno[n];
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            do {
                int n4 = ++n2;
                int n5 = n2;
                tvnoArray = tvnoArray2;
                Object var12_12 = null;
                tvnoArray[n5] = var12_12;
            } while (n2 != n3);
        }
        tvnoArray = tvnoArray2;
        jgro2._l = tvnoArray;
    }

    static {
        _a = new kjui(null);
        _r = new ArrayList();
        _v = 1;
        _w = 2;
        _x = 3;
    }

    @NotNull
    public static final /* synthetic */ jhpr _d(jgro jgro2) {
        return jgro2._f;
    }

    @Nullable
    public static final /* synthetic */ gloomyfolken.mods.effects.client.main.kjui _e(jgro jgro2) {
        return jgro2._n;
    }

    @Nullable
    public static final jgro _y() {
        return _a._b();
    }

    private static final void _f(jgro jgro2) {
        jgro._a._a(jgro2);
    }

    @JvmStatic
    public static final void _a(@Nullable jgro jgro2, @Nullable jgro jgro3, int n) {
        _a._a(jgro2, jgro3, n);
    }

    @JvmStatic
    public static final void _a(@Nullable jgro jgro2, @Nullable jgro jgro3, int n, @NotNull Dimension dimension, @NotNull Dimension dimension2) {
        Intrinsics.checkParameterIsNotNull(dimension, "src");
        Intrinsics.checkParameterIsNotNull(dimension2, "dst");
        _a._a(jgro2, jgro3, n, dimension, dimension2);
    }

    @JvmStatic
    public static final void _a(@Nullable jgro jgro2, @Nullable jgro jgro3, int n, @NotNull Rectangle rectangle, @NotNull Rectangle rectangle2) {
        Intrinsics.checkParameterIsNotNull(rectangle, "src");
        Intrinsics.checkParameterIsNotNull(rectangle2, "dst");
        _a._a(jgro2, jgro3, n, rectangle, rectangle2);
    }

    @JvmStatic
    public static final void _z() {
        _a._f();
    }

    @JvmStatic
    public static final void _A() {
        _a._g();
    }

    @JvmStatic
    public static final void _B() {
        _a._h();
    }

    @JvmStatic
    public static final void _C() {
        _a._i();
    }

    @JvmStatic
    @NotNull
    public static final Dimension _D() {
        return _a._j();
    }

    @JvmStatic
    @NotNull
    public static final Rectangle _E() {
        return _a._k();
    }

    @JvmStatic
    @NotNull
    public static final jgro _a(@NotNull String string, boolean bl, boolean bl2, @NotNull Dimension dimension, @NotNull jhpr jhpr2, @Nullable gloomyfolken.mods.effects.client.main.kjui kjui2) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(dimension, "resolution");
        Intrinsics.checkParameterIsNotNull((Object)jhpr2, "aaMode");
        return _a._a(string, bl, bl2, dimension, jhpr2, kjui2);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/effects/client/main/FramebufferObject$FramebufferObjectCore;", "Lgloomyfolken/mods/effects/client/main/FramebufferObject;", "name", "", "depth", "", "stencil", "(Ljava/lang/String;ZZ)V", "create", "", "releaseFramebuffer", "validate", "minecraft"})
    private static final class pidb
    extends jgro {
        @Override
        protected void _g() {
            GL30.glDeleteFramebuffers(this._b());
        }

        @Override
        protected void _f() {
            this._b(GL30.glGenFramebuffers());
        }

        @Override
        public void _n() {
            super._n();
            this._a(GL30.glCheckFramebufferStatus(36160));
            if (this._a() != 36053) {
                throw (Throwable)new IllegalStateException("invalid fbo, error code: " + this._a());
            }
        }

        public pidb(@NotNull String string, boolean bl, boolean bl2) {
            Intrinsics.checkParameterIsNotNull(string, "name");
            super(string, bl, bl2);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/effects/client/main/FramebufferObject$FramebufferObjectEXT;", "Lgloomyfolken/mods/effects/client/main/FramebufferObject;", "name", "", "depth", "", "stencil", "(Ljava/lang/String;ZZ)V", "create", "", "releaseFramebuffer", "validate", "minecraft"})
    private static final class eidj
    extends jgro {
        @Override
        protected void _g() {
            EXTFramebufferObject.glDeleteFramebuffersEXT(this._b());
        }

        @Override
        protected void _f() {
            this._b(EXTFramebufferObject.glGenFramebuffersEXT());
        }

        @Override
        public void _n() {
            super._n();
            this._a(EXTFramebufferObject.glCheckFramebufferStatusEXT(36160));
            if (this._a() != 36053) {
                throw (Throwable)new IllegalStateException("invalid fbo, error code: " + this._a());
            }
        }

        public eidj(@NotNull String string, boolean bl, boolean bl2) {
            Intrinsics.checkParameterIsNotNull(string, "name");
            super(string, bl, bl2);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020 H\u0007J$\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020\u0004H\u0007J4\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0007J8\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020*2\b\b\u0002\u0010)\u001a\u00020*H\u0007JD\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020(2\b\b\u0002\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u000105H\u0007J\b\u00106\u001a\u00020*H\u0007J\b\u00107\u001a\u00020(H\u0007J\b\u00108\u001a\u00020 H\u0007J\b\u00109\u001a\u00020 H\u0007J\b\u0010:\u001a\u00020 H\u0007J\u0010\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020(H\u0002J\u0016\u0010;\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R0\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@BX\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001bj\b\u0012\u0004\u0012\u00020\f`\u001cX\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006?"}, d2={"Lgloomyfolken/mods/effects/client/main/FramebufferObject$Companion;", "", "()V", "DRAW_FRAMEBUFFER", "", "getDRAW_FRAMEBUFFER", "()I", "FRAMEBUFFER", "getFRAMEBUFFER", "READ_FRAMEBUFFER", "getREAD_FRAMEBUFFER", "<set-?>", "Lgloomyfolken/mods/effects/client/main/FramebufferObject;", "currentFramebuffer", "currentFramebuffer$annotations", "getCurrentFramebuffer", "()Lgloomyfolken/mods/effects/client/main/FramebufferObject;", "setCurrentFramebuffer", "(Lgloomyfolken/mods/effects/client/main/FramebufferObject;)V", "lastViewportHeight", "getLastViewportHeight", "setLastViewportHeight", "(I)V", "lastViewportWidth", "getLastViewportWidth", "setLastViewportWidth", "stack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStack", "()Ljava/util/ArrayList;", "bind", "", "target", "framebufferId", "bindDefaultFramebuffer", "blit", "source", "blitBits", "src", "Ljava/awt/Dimension;", "dst", "Ljava/awt/Rectangle;", "create", "name", "", "hasDepth", "", "hasStencil", "resolution", "aaMode", "Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "backBufferSet", "Lgloomyfolken/mods/effects/client/main/BackBufferSet;", "getScreenBounds", "getScreenResolution", "pop", "push", "resetStack", "updateViewport", "dimension", "width", "height", "minecraft"})
    public static final class kjui {
        private final ArrayList<jgro> _l() {
            return _r;
        }

        @JvmStatic
        public static /* synthetic */ void _a() {
        }

        @Nullable
        public final jgro _b() {
            return _s;
        }

        private final void _a(jgro jgro2) {
            _s = jgro2;
        }

        private final int _m() {
            return _t;
        }

        private final void _a(int n) {
            _t = n;
        }

        private final int _n() {
            return _u;
        }

        private final void _b(int n) {
            _u = n;
        }

        public final int _c() {
            return _v;
        }

        public final int _d() {
            return _w;
        }

        public final int _e() {
            return _x;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private final void _b(int n, int n2) {
            if (tupg._a._a()) {
                int n3 = n;
                int n4 = n3 == this._c() ? 36009 : (n3 == this._d() ? 36008 : 36160);
                EXTFramebufferObject.glBindFramebufferEXT(n4, n2);
                if (n2 <= 0) return;
                if ((n & this._c()) != 0) {
                    // empty if block
                }
                if ((n & this._d()) == 0) return;
            }
            int n5 = n;
            int n6 = n5 == this._c() ? 36009 : (n5 == this._d() ? 36008 : 36160);
            GL30.glBindFramebuffer(n6, n2);
            if (n2 <= 0) return;
            if ((n & this._c()) != 0) {
                // empty if block
            }
            if ((n & this._d()) != 0) return;
        }

        @JvmStatic
        public final void _a(@Nullable jgro jgro2, @Nullable jgro jgro3, int n) {
            this._a(jgro2, jgro3, n, this._k(), this._k());
        }

        @JvmStatic
        public final void _a(@Nullable jgro jgro2, @Nullable jgro jgro3, int n, @NotNull Dimension dimension, @NotNull Dimension dimension2) {
            Intrinsics.checkParameterIsNotNull(dimension, "src");
            Intrinsics.checkParameterIsNotNull(dimension2, "dst");
            this._a(jgro2, jgro3, n, new Rectangle(0, 0, dimension.width, dimension.height), new Rectangle(0, 0, dimension2.width, dimension2.height));
        }

        @JvmStatic
        public final void _a(@Nullable jgro jgro2, @Nullable jgro jgro3, int n, @NotNull Rectangle rectangle, @NotNull Rectangle rectangle2) {
            Intrinsics.checkParameterIsNotNull(rectangle, "src");
            Intrinsics.checkParameterIsNotNull(rectangle2, "dst");
            jgro jgro4 = jgro2;
            int n2 = jgro4 != null ? jgro4._b() : 0;
            jgro jgro5 = jgro3;
            int n3 = jgro5 != null ? jgro5._b() : 0;
            this._b(this._d(), n2);
            this._b(this._c(), n3);
            if (tupg._a._a()) {
                EXTFramebufferBlit.glBlitFramebufferEXT(rectangle.x, rectangle.y, rectangle.x + rectangle.width, rectangle.y + rectangle.height, rectangle2.x, rectangle2.y, rectangle2.x + rectangle2.width, rectangle2.y + rectangle2.height, n, 9728);
            } else {
                GL30.glBlitFramebuffer(rectangle.x, rectangle.y, rectangle.x + rectangle.width, rectangle.y + rectangle.height, rectangle2.x, rectangle2.y, rectangle2.x + rectangle2.width, rectangle2.y + rectangle2.height, n, 9728);
            }
            if (this._b() != null) {
                int n4 = this._e();
                jgro jgro6 = this._b();
                if (jgro6 == null) {
                    Intrinsics.throwNpe();
                }
                this._b(n4, jgro6._b());
            }
        }

        @JvmStatic
        public static /* synthetic */ void _a(kjui kjui2, jgro jgro2, jgro jgro3, int n, Rectangle rectangle, Rectangle rectangle2, int n2, Object object) {
            if ((n2 & 8) != 0) {
                rectangle = kjui2._k();
            }
            if ((n2 & 0x10) != 0) {
                rectangle2 = kjui2._k();
            }
            kjui2._a(jgro2, jgro3, n, rectangle, rectangle2);
        }

        private final void _a(Dimension dimension) {
            this._a(dimension.width, dimension.height);
        }

        public final void _a(int n, int n2) {
            if (this._m() != n || this._n() != n2) {
                GL11.glViewport(0, 0, n, n2);
                this._a(n);
                this._b(n2);
            }
        }

        @JvmStatic
        public final void _f() {
            jgro jgro2 = this._b();
            if (jgro2 == null) {
                return;
            }
            jgro jgro3 = jgro2;
            jgro3._F();
        }

        @JvmStatic
        public final void _g() {
            jgro jgro2 = this._b();
            if (jgro2 == null) {
                throw (Throwable)new IllegalStateException("Stack underflow");
            }
            jgro jgro3 = jgro2;
            jgro3._G();
        }

        @JvmStatic
        public final void _h() {
            this._l().clear();
        }

        @JvmStatic
        public final void _i() {
            this._a((jgro)null);
            this._b(this._e(), 0);
            this._a(this._j());
        }

        @JvmStatic
        @NotNull
        public final Dimension _j() {
            return new Dimension(Minecraft._E()._n, Minecraft._E()._o);
        }

        @JvmStatic
        @NotNull
        public final Rectangle _k() {
            return new Rectangle(0, 0, this._j().width, this._j().height);
        }

        @JvmStatic
        @NotNull
        public final jgro _a(@NotNull String string, boolean bl, boolean bl2, @NotNull Dimension dimension, @NotNull jhpr jhpr2, @Nullable gloomyfolken.mods.effects.client.main.kjui kjui2) {
            Intrinsics.checkParameterIsNotNull(string, "name");
            Intrinsics.checkParameterIsNotNull(dimension, "resolution");
            Intrinsics.checkParameterIsNotNull((Object)jhpr2, "aaMode");
            jgro jgro2 = tupg._a._a() ? (jgro)new eidj(string, bl, bl2) : (jgro)new pidb(string, bl, bl2);
            jgro2._f = jhpr2;
            jgro2._a(dimension);
            jgro2._f();
            jgro2._n = kjui2;
            return jgro2;
        }

        @JvmStatic
        @NotNull
        public static /* synthetic */ jgro _a(kjui kjui2, String string, boolean bl, boolean bl2, Dimension dimension, jhpr jhpr2, gloomyfolken.mods.effects.client.main.kjui kjui3, int n, Object object) {
            if ((n & 2) != 0) {
                bl = false;
            }
            if ((n & 4) != 0) {
                bl2 = false;
            }
            if ((n & 8) != 0) {
                dimension = kjui2._j();
            }
            if ((n & 0x10) != 0) {
                jhpr2 = jhpr._a;
            }
            if ((n & 0x20) != 0) {
                kjui3 = null;
            }
            return kjui2._a(string, bl, bl2, dimension, jhpr2, kjui3);
        }

        private kjui() {
        }

        @Nullable
        public static final /* synthetic */ jgro _a(kjui kjui2) {
            return kjui2._b();
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

