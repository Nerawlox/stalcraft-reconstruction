/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.tupg;
import java.awt.Dimension;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL32;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 @2\u00020\u0001:\u0001@BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0000H\u0016J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J \u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0002J\u0013\u00101\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u000103H\u0096\u0002J\b\u00104\u001a\u00020\rH\u0016J\b\u00105\u001a\u00020\bH\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u0005H\u0002J\b\u00109\u001a\u00020&H\u0016J\u0010\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u000207H\u0016J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020\rH\u0016J\u0012\u0010>\u001a\u00020&2\b\b\u0002\u0010?\u001a\u00020\nH\u0002R\u000e\u0010\u000f\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001d\u00a8\u0006A"}, d2={"Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "Lgloomyfolken/mods/effects/client/texture/FramebufferAttachment;", "name", "", "width", "", "height", "fbAttachmentTarget", "Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "clamp", "", "blur", "aaMode", "Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "(Ljava/lang/String;IILgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;ZZLgloomyfolken/mods/effects/client/texture/AntialiasingMode;)V", "DISABLE_DEPTH_BLUR", "<set-?>", "getAaMode", "()Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "setAaMode", "(Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;)V", "getBlur", "()Z", "getClamp", "getFbAttachmentTarget", "()Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "getHeight", "()I", "setHeight", "(I)V", "getName", "()Ljava/lang/String;", "textureId", "getTextureId", "setTextureId", "getWidth", "setWidth", "bindAsAttachment", "", "colorIndex", "bindAsTexture", "unit", "create", "createColorAttachment", "createDepthStencilAttachment", "createGlTex", "internalFormat", "format", "type", "equals", "other", "", "getAntialiasingMode", "getAttachmentTarget", "getSize", "Ljava/awt/Dimension;", "getTextureBindTarget", "release", "resize", "dimension", "setAntialiasing", "mode", "setupTexParams", "disableBlur", "Companion", "minecraft"})
public final class uyuh
implements tvno {
    private final boolean _c = true;
    private int _d;
    @NotNull
    private jhpr _e;
    @NotNull
    private final String _f;
    private int _g;
    private int _h;
    @NotNull
    private final fmfc _i;
    private final boolean _j;
    private final boolean _k;
    @NotNull
    private static final uyuh _l;
    @NotNull
    private static final uyuh _m;
    @NotNull
    private static final uyuh _n;
    @NotNull
    private static final Map<fmfc, uyuh> _o;
    public static final kjui _b;

    public final int _g() {
        return this._d;
    }

    private final void _e(int n) {
        this._d = n;
    }

    @NotNull
    public final jhpr _h() {
        return this._e;
    }

    private final void _b(jhpr jhpr2) {
        this._e = jhpr2;
    }

    @NotNull
    public uyuh _i() {
        tvno.pidb._b(this);
        this._d();
        this._d = GL11.glGenTextures();
        tvno.pidb._b(this, 0, 1, null);
        switch (ejfm._a[this._i.ordinal()]) {
            case 1: {
                this._u();
                break;
            }
            case 2: 
            case 3: {
                this._v();
            }
        }
        int n = GL11.glGetError();
        if (n != 0) {
            throw (Throwable)new IllegalStateException("GLERROR " + n + " while generating texture " + this._f + "! Aborting texture creation...");
        }
        return this;
    }

    @Override
    public /* synthetic */ nuau _e() {
        return this._i();
    }

    @Override
    public /* synthetic */ tvno _f() {
        return this._i();
    }

    @Override
    public void _d() {
        if (this._d > 0) {
            tvno.pidb._a(this);
            GL11.glDeleteTextures(this._d);
            this._d = -1;
        }
    }

    @Override
    public void _b(int n) {
        GL13.glActiveTexture(33984 + n);
        GL11.glBindTexture(this._t(), this._d);
        GL13.glActiveTexture(33984);
    }

    @Override
    public void _a(int n) {
        if (tupg._a._a()) {
            Object object;
            Object object2 = tvno._a._d().get((Object)this._i);
            if (object2 == null || (object2 = ArrayIteratorKt.iterator((Object[])object2)) == null) {
                throw (Throwable)new IllegalStateException("No attachment target found for " + (Object)((Object)this._i) + '!');
            }
            Object object3 = object = object2;
            while (object3.hasNext()) {
                int n2 = ((Number)object3.next()).intValue();
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, n2 + n, this._t(), this._d, 0);
            }
        } else {
            Object object;
            Object object4 = tvno._a._c().get((Object)this._i);
            if (object4 == null || (object4 = ArrayIteratorKt.iterator((Object[])object4)) == null) {
                throw (Throwable)new IllegalStateException("No attachment target found for " + (Object)((Object)this._i) + '!');
            }
            Object object5 = object = object4;
            while (object5.hasNext()) {
                int n3 = ((Number)object5.next()).intValue();
                GL30.glFramebufferTexture2D(36160, n3 + n, this._t(), this._d, 0);
            }
        }
    }

    @Override
    @NotNull
    public fmfc _a() {
        return this._i;
    }

    @Override
    public void _a(@NotNull Dimension dimension) {
        Intrinsics.checkParameterIsNotNull(dimension, "dimension");
        if (this._g != dimension.width || this._h != dimension.height) {
            this._g = dimension.width;
            this._h = dimension.height;
            if (this._d > 0) {
                this._i();
            }
        }
    }

    @Override
    @NotNull
    public Dimension _c() {
        return new Dimension(this._g, this._h);
    }

    @Override
    public void _a(@NotNull jhpr jhpr2) {
        Intrinsics.checkParameterIsNotNull((Object)jhpr2, "mode");
        this._e = jhpr2;
        this._i();
    }

    @Override
    @NotNull
    public jhpr _b() {
        return this._e;
    }

    private final int _t() {
        return this._e._b() > 0 ? 37120 : 3553;
    }

    private final void _a(boolean bl) {
        boolean bl2 = bl ? false : this._k;
        GL11.glTexParameteri(3553, 10241, bl2 ? 9729 : 9728);
        GL11.glTexParameteri(3553, 10240, bl2 ? 9729 : 9728);
        GL11.glTexParameteri(3553, 10242, this._j ? 33071 : 10497);
        GL11.glTexParameteri(3553, 10243, this._j ? 33071 : 10497);
        GL11.glTexParameteri(3553, 33084, 0);
        GL11.glTexParameteri(3553, 33085, 0);
    }

    static /* bridge */ /* synthetic */ void _a(uyuh uyuh2, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        uyuh2._a(bl);
    }

    private final void _u() {
        uyuh._a(this, false, 1, null);
        this._a(32856, 32993, 5121);
    }

    private final void _a(int n, int n2, int n3) {
        if (this._e._b() > 0) {
            GL32.glTexImage2DMultisample(37120, this._e._b(), n, this._g, this._h, false);
        } else {
            GL11.glTexImage2D(3553, 0, n, this._g, this._h, 0, n2, n3, (ByteBuffer)null);
        }
    }

    private final void _v() {
        int n;
        int n2;
        int n3;
        boolean bl = Intrinsics.areEqual((Object)this._i, (Object)fmfc._c);
        if (tupg._a._a()) {
            n3 = bl ? 35056 : 6402;
            n2 = bl ? 34041 : 6402;
            n = bl ? 34042 : 5126;
        } else {
            n3 = bl ? 35056 : 6402;
            n2 = bl ? 34041 : 6402;
            n = bl ? 34042 : 5126;
        }
        this._a(this._c);
        this._a(n3, n2, n);
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof uyuh) {
            return this._d == ((uyuh)object)._d && Intrinsics.areEqual(this._c(), ((uyuh)object)._c()) && Intrinsics.areEqual((Object)this._i, (Object)((uyuh)object)._i);
        }
        return false;
    }

    @NotNull
    public final String _j() {
        return this._f;
    }

    public final int _k() {
        return this._g;
    }

    public final void _c(int n) {
        this._g = n;
    }

    public final int _l() {
        return this._h;
    }

    public final void _d(int n) {
        this._h = n;
    }

    @NotNull
    public final fmfc _m() {
        return this._i;
    }

    public final boolean _n() {
        return this._j;
    }

    public final boolean _o() {
        return this._k;
    }

    public uyuh(@NotNull String string, int n, int n2, @NotNull fmfc fmfc2, boolean bl, boolean bl2, @NotNull jhpr jhpr2) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull((Object)fmfc2, "fbAttachmentTarget");
        Intrinsics.checkParameterIsNotNull((Object)jhpr2, "aaMode");
        this._f = string;
        this._g = n;
        this._h = n2;
        this._i = fmfc2;
        this._j = bl;
        this._k = bl2;
        this._c = true;
        this._d = -1;
        this._e = jhpr2;
        if (this._b()._d()) {
            throw (Throwable)new IllegalStateException("Renderable textures does not support CSAA antialiasing mode!");
        }
    }

    public /* synthetic */ uyuh(String string, int n, int n2, fmfc fmfc2, boolean bl, boolean bl2, jhpr jhpr2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 8) != 0) {
            fmfc2 = fmfc._a;
        }
        if ((n3 & 0x10) != 0) {
            bl = false;
        }
        if ((n3 & 0x20) != 0) {
            bl2 = false;
        }
        if ((n3 & 0x40) != 0) {
            jhpr2 = jhpr._a;
        }
        this(string, n, n2, fmfc2, bl, bl2, jhpr2);
    }

    static {
        _b = new kjui(null);
        _l = new uyuh("no_texture_color", 0, 0, fmfc._a, false, false, null, 112, null);
        _m = new uyuh("no_texture_depth", 0, 0, fmfc._b, false, false, null, 112, null);
        _n = new uyuh("no_texture_depth_stencil", 0, 0, fmfc._c, false, false, null, 112, null);
        uyuh._b._a()._d = 0;
        uyuh._b._b()._d = 0;
        uyuh._b._c()._d = 0;
        _o = MapsKt.mapOf(TuplesKt.to(fmfc._a, _b._a()), TuplesKt.to(fmfc._b, _b._b()), TuplesKt.to(fmfc._c, _b._c()));
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/mods/effects/client/texture/FramebufferTexture$Companion;", "", "()V", "NO_COLOR_TEXTURE", "Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "getNO_COLOR_TEXTURE", "()Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "NO_DEPTH_STENCIL_TEXTURE", "getNO_DEPTH_STENCIL_TEXTURE", "NO_DEPTH_TEXTURE", "getNO_DEPTH_TEXTURE", "emptyAttachment", "", "Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "getEmptyAttachment", "()Ljava/util/Map;", "minecraft"})
    public static final class kjui {
        @NotNull
        public final uyuh _a() {
            return _l;
        }

        @NotNull
        public final uyuh _b() {
            return _m;
        }

        @NotNull
        public final uyuh _c() {
            return _n;
        }

        @NotNull
        public final Map<fmfc, uyuh> _d() {
            return _o;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

