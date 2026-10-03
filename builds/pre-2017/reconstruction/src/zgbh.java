/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.tupg;
import java.awt.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.NVFramebufferMultisampleCoverage;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 32\u00020\u0001:\u0003345B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\b\u0010\"\u001a\u00020\u001fH$J\b\u0010#\u001a\u00020\u001fH$J\b\u0010$\u001a\u00020\u001fH$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020\u0005H$J\b\u0010*\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\bH\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001fH\u0016J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020-H\u0016J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\nH\u0016R$\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005@BX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016\u00a8\u00066"}, d2={"Lgloomyfolken/mods/effects/client/texture/RenderbufferObject;", "Lgloomyfolken/mods/effects/client/texture/FramebufferAttachment;", "name", "", "width", "", "height", "fbAttachmentTarget", "Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "aaMode", "Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "(Ljava/lang/String;IILgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;)V", "<set-?>", "getAaMode", "()Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "setAaMode", "(Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;)V", "getFbAttachmentTarget", "()Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "getHeight", "()I", "setHeight", "(I)V", "getName", "()Ljava/lang/String;", "renderBufferId", "getRenderBufferId", "setRenderBufferId", "getWidth", "setWidth", "bindAsTexture", "", "unit", "create", "createColorAttachment", "createDepthStencilAttachment", "deleteRenderbuffer", "equals", "", "other", "", "genRenderbuffer", "getAntialiasingMode", "getAttachmentTarget", "getSize", "Ljava/awt/Dimension;", "release", "resize", "dimension", "setAntialiasing", "mode", "Companion", "RenderbufferObjectCore", "RenderbufferObjectEXT", "minecraft"})
public abstract class zgbh
implements tvno {
    @NotNull
    private jhpr _c;
    private int _d;
    @NotNull
    private final String _e;
    private int _f;
    private int _g;
    @NotNull
    private final fmfc _h;
    public static final kjui _b = new kjui(null);

    @NotNull
    public final jhpr _g() {
        return this._c;
    }

    private final void _b(jhpr jhpr2) {
        this._c = jhpr2;
    }

    protected final int _h() {
        return this._d;
    }

    private final void _e(int n) {
        this._d = n;
    }

    @Override
    public void _a(@NotNull jhpr jhpr2) {
        Intrinsics.checkParameterIsNotNull((Object)jhpr2, "mode");
        this._c = jhpr2;
        this._i();
    }

    @Override
    @NotNull
    public jhpr _b() {
        return this._c;
    }

    @Override
    @NotNull
    public Dimension _c() {
        return new Dimension(this._f, this._g);
    }

    @Override
    @NotNull
    public fmfc _a() {
        return this._h;
    }

    @Override
    public void _a(@NotNull Dimension dimension) {
        Intrinsics.checkParameterIsNotNull(dimension, "dimension");
        if (this._f != dimension.width || this._g != dimension.height) {
            this._f = dimension.width;
            this._g = dimension.height;
            this._i();
        }
    }

    @Override
    public void _d() {
        if (this._d > 0) {
            tvno.pidb._a(this);
            this._k();
            this._d = -1;
        }
    }

    @NotNull
    public zgbh _i() {
        tvno.pidb._b(this);
        this._d();
        this._d = this._j();
        switch (ivsc._a[this._h.ordinal()]) {
            case 1: {
                this._l();
                break;
            }
            case 2: 
            case 3: {
                this._m();
            }
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

    protected abstract int _j();

    protected abstract void _k();

    protected abstract void _l();

    protected abstract void _m();

    @Override
    public void _b(int n) {
        throw (Throwable)new IllegalStateException("Read-only texture is not renderable, so you can't attach it as a texture.");
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof zgbh) {
            return this._d == ((zgbh)object)._d && Intrinsics.areEqual(this._c(), ((zgbh)object)._c()) && Intrinsics.areEqual((Object)this._h, (Object)((zgbh)object)._h);
        }
        return false;
    }

    @NotNull
    public final String _n() {
        return this._e;
    }

    public final int _o() {
        return this._f;
    }

    public final void _c(int n) {
        this._f = n;
    }

    public final int _p() {
        return this._g;
    }

    public final void _d(int n) {
        this._g = n;
    }

    @NotNull
    public final fmfc _q() {
        return this._h;
    }

    public zgbh(@NotNull String string, int n, int n2, @NotNull fmfc fmfc2, @NotNull jhpr jhpr2) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull((Object)fmfc2, "fbAttachmentTarget");
        Intrinsics.checkParameterIsNotNull((Object)jhpr2, "aaMode");
        this._e = string;
        this._f = n;
        this._g = n2;
        this._h = fmfc2;
        this._c = jhpr2;
        this._d = -1;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0014J\b\u0010\u0012\u001a\u00020\u0005H\u0014\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/effects/client/texture/RenderbufferObject$RenderbufferObjectCore;", "Lgloomyfolken/mods/effects/client/texture/RenderbufferObject;", "name", "", "width", "", "height", "fbAttachmentTarget", "Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "aaMode", "Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "(Ljava/lang/String;IILgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;)V", "bindAsAttachment", "", "colorIndex", "createColorAttachment", "createDepthStencilAttachment", "deleteRenderbuffer", "genRenderbuffer", "minecraft"})
    private static final class pidb
    extends zgbh {
        @Override
        protected int _j() {
            return GL30.glGenRenderbuffers();
        }

        @Override
        protected void _k() {
            GL30.glDeleteRenderbuffers(this._h());
        }

        @Override
        protected void _l() {
            GL30.glBindRenderbuffer(36161, this._h());
            if (!this._g()._a()) {
                GL30.glRenderbufferStorage(36161, 32856, this._o(), this._p());
            } else {
                int n = owkq._b(this._g()._b(), GL11.glGetInteger(36183));
                if (this._g()._d() && gloomyfolken.mods.effects.client.main.eidj._K) {
                    NVFramebufferMultisampleCoverage.glRenderbufferStorageMultisampleCoverageNV(36161, this._g()._c(), n, 32856, this._o(), this._p());
                } else {
                    GL30.glRenderbufferStorageMultisample(36161, n, 32856, this._o(), this._p());
                }
            }
        }

        @Override
        protected void _m() {
            boolean bl = Intrinsics.areEqual((Object)this._q(), (Object)fmfc._c);
            int n = bl ? 35056 : 6402;
            GL30.glBindRenderbuffer(36161, this._h());
            if (!this._g()._a()) {
                GL30.glRenderbufferStorage(36161, n, this._o(), this._p());
            } else {
                int n2 = owkq._b(this._g()._b(), GL11.glGetInteger(36183));
                if (this._g()._d() && gloomyfolken.mods.effects.client.main.eidj._K) {
                    NVFramebufferMultisampleCoverage.glRenderbufferStorageMultisampleCoverageNV(36161, this._g()._c(), n2, n, this._o(), this._p());
                } else {
                    GL30.glRenderbufferStorageMultisample(36161, n2, n, this._o(), this._p());
                }
            }
        }

        @Override
        public void _a(int n) {
            Object object;
            Object object2 = tvno._a._c().get((Object)this._q());
            if (object2 == null || (object2 = ArrayIteratorKt.iterator((Object[])object2)) == null) {
                throw (Throwable)new IllegalStateException("No attachment target found for " + (Object)((Object)this._q()) + '!');
            }
            Object object3 = object = object2;
            while (object3.hasNext()) {
                int n2 = ((Number)object3.next()).intValue();
                GL30.glFramebufferRenderbuffer(36160, n2, 36161, this._h());
            }
        }

        public pidb(@NotNull String string, int n, int n2, @NotNull fmfc fmfc2, @NotNull jhpr jhpr2) {
            Intrinsics.checkParameterIsNotNull(string, "name");
            Intrinsics.checkParameterIsNotNull((Object)fmfc2, "fbAttachmentTarget");
            Intrinsics.checkParameterIsNotNull((Object)jhpr2, "aaMode");
            super(string, n, n2, fmfc2, jhpr2);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0014J\b\u0010\u0012\u001a\u00020\u0005H\u0014\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/effects/client/texture/RenderbufferObject$RenderbufferObjectEXT;", "Lgloomyfolken/mods/effects/client/texture/RenderbufferObject;", "name", "", "width", "", "height", "fbAttachmentTarget", "Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "aaMode", "Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "(Ljava/lang/String;IILgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;)V", "bindAsAttachment", "", "colorIndex", "createColorAttachment", "createDepthStencilAttachment", "deleteRenderbuffer", "genRenderbuffer", "minecraft"})
    private static final class eidj
    extends zgbh {
        @Override
        protected int _j() {
            return EXTFramebufferObject.glGenRenderbuffersEXT();
        }

        @Override
        protected void _k() {
            EXTFramebufferObject.glDeleteRenderbuffersEXT(this._h());
        }

        @Override
        protected void _l() {
            EXTFramebufferObject.glBindRenderbufferEXT(36161, this._h());
            EXTFramebufferObject.glRenderbufferStorageEXT(36161, 32856, this._o(), this._p());
        }

        @Override
        protected void _m() {
            boolean bl = Intrinsics.areEqual((Object)this._q(), (Object)fmfc._c);
            int n = bl ? 35056 : 6402;
            EXTFramebufferObject.glBindRenderbufferEXT(36161, this._h());
            EXTFramebufferObject.glRenderbufferStorageEXT(36161, n, this._o(), this._p());
        }

        @Override
        public void _a(int n) {
            Object object;
            Object object2 = tvno._a._d().get((Object)this._q());
            if (object2 == null || (object2 = ArrayIteratorKt.iterator((Object[])object2)) == null) {
                throw (Throwable)new IllegalStateException("No attachment target found for " + (Object)((Object)this._q()) + '!');
            }
            Object object3 = object = object2;
            while (object3.hasNext()) {
                int n2 = ((Number)object3.next()).intValue();
                EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, n2, 36161, this._h());
            }
        }

        public eidj(@NotNull String string, int n, int n2, @NotNull fmfc fmfc2, @NotNull jhpr jhpr2) {
            Intrinsics.checkParameterIsNotNull(string, "name");
            Intrinsics.checkParameterIsNotNull((Object)fmfc2, "fbAttachmentTarget");
            Intrinsics.checkParameterIsNotNull((Object)jhpr2, "aaMode");
            super(string, n, n2, fmfc2, jhpr2);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/effects/client/texture/RenderbufferObject$Companion;", "", "()V", "new", "Lgloomyfolken/mods/effects/client/texture/RenderbufferObject;", "name", "", "width", "", "height", "fbAttachmentTarget", "Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "aaMode", "Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "minecraft"})
    public static final class kjui {
        @NotNull
        public final zgbh _a(@NotNull String string, int n, int n2, @NotNull fmfc fmfc2, @NotNull jhpr jhpr2) {
            Intrinsics.checkParameterIsNotNull(string, "name");
            Intrinsics.checkParameterIsNotNull((Object)fmfc2, "fbAttachmentTarget");
            Intrinsics.checkParameterIsNotNull((Object)jhpr2, "aaMode");
            if (tupg._a._a()) {
                return new eidj(string, n, n2, fmfc2, jhpr2);
            }
            return new pidb(string, n, n2, fmfc2, jhpr2);
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

