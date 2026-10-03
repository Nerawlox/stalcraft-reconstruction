/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.lwjgl.opengl.GL11;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/effects/client/util/StencilUtils;", "", "()V", "clearScreenStencil", "", "disableStencil", "enableStencil", "endDrawingMask", "disableColorWrite", "", "disableDepthWrite", "StencilType", "minecraft"})
public final class ejef {
    public static final ejef _a;

    @JvmStatic
    public static final void _a() {
        GL11.glEnable(2960);
    }

    @JvmStatic
    public static final void _b() {
        GL11.glDisable(2960);
    }

    @JvmStatic
    public static final void _c() {
        GL11.glClearStencil(0);
        GL11.glClear(1024);
    }

    public final void _a(boolean bl, boolean bl2) {
        GL11.glStencilFunc(519, 0, 0);
        GL11.glStencilOp(7680, 7680, 7680);
        ejef._b();
        if (bl) {
            GL11.glColorMask(true, true, true, true);
        }
        if (bl2) {
            GL11.glDepthMask(true);
        }
    }

    private ejef() {
        _a = this;
    }

    static {
        new ejef();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001Bu\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014j\u0002\b\"j\u0002\b#j\u0002\b$\u00a8\u0006%"}, d2={"Lgloomyfolken/mods/effects/client/util/StencilUtils$StencilType;", "", "writeRef", "", "writeMask", "writeFunc", "szFailOp", "zFailOp", "zPassOp", "testFunc", "testRef", "testMask", "disableColorWrite", "", "disableDepthWrite", "(Ljava/lang/String;IIIIIIIIIIZZ)V", "getDisableColorWrite", "()Z", "getDisableDepthWrite", "getSzFailOp", "()I", "getTestFunc", "getTestMask", "getTestRef", "getWriteFunc", "getWriteMask", "getWriteRef", "getZFailOp", "getZPassOp", "disableTesting", "", "enableTesting", "endDrawingMask", "startDrawingMask", "GUN_UNBLUR", "GENERAL", "HUD_GENERAL", "minecraft"})
    public static final class kjui
    extends Enum<kjui> {
        public static final /* enum */ kjui _a;
        public static final /* enum */ kjui _b;
        public static final /* enum */ kjui _c;
        private static final /* synthetic */ kjui[] $VALUES;
        private final int _d;
        private final int _e;
        private final int _f;
        private final int _g;
        private final int _h;
        private final int _i;
        private final int _j;
        private final int _k;
        private final int _l;
        private final boolean _m;
        private final boolean _n;

        static {
            kjui[] kjuiArray = new kjui[3];
            kjui[] kjuiArray2 = kjuiArray;
            kjuiArray[0] = _a = new kjui("GUN_UNBLUR", 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, true, true, 508, null);
            kjuiArray[1] = _b = new kjui("GENERAL", 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, false, false, 2044, null);
            kjuiArray[2] = _c = new kjui("HUD_GENERAL", 2, 1, 1, 0, 0, 7681, 0, 0, 0, 0, false, false, 2028, null);
            $VALUES = kjuiArray;
        }

        public final void _a() {
            ejef._a();
            GL11.glStencilFunc(this._f, this._d, this._e);
            GL11.glStencilOp(this._g, this._h, this._i);
            if (this._m) {
                GL11.glColorMask(false, false, false, false);
            }
            if (this._n) {
                GL11.glDepthMask(false);
            }
        }

        public final void _b() {
            _a._a(this._m, this._n);
        }

        public final void _c() {
            ejef._a();
            GL11.glStencilOp(7680, 7680, 7680);
            GL11.glStencilFunc(this._j, this._k, this._l);
        }

        public final void _d() {
            ejef._b();
        }

        public final int _e() {
            return this._d;
        }

        public final int _f() {
            return this._e;
        }

        public final int _g() {
            return this._f;
        }

        public final int _h() {
            return this._g;
        }

        public final int _i() {
            return this._h;
        }

        public final int _j() {
            return this._i;
        }

        public final int _k() {
            return this._j;
        }

        public final int _l() {
            return this._k;
        }

        public final int _m() {
            return this._l;
        }

        public final boolean _n() {
            return this._m;
        }

        public final boolean _o() {
            return this._n;
        }

        protected kjui(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, boolean bl, boolean bl2) {
            this._d = n2;
            this._e = n3;
            this._f = n4;
            this._g = n5;
            this._h = n6;
            this._i = n7;
            this._j = n8;
            this._k = n9;
            this._l = n10;
            this._m = bl;
            this._n = bl2;
            if (this._d > 255) {
                throw (Throwable)new IllegalStateException("Incorrect write ref: no values higher than 8 bits can hold are supported!");
            }
        }

        /* synthetic */ kjui(String string, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, boolean bl, boolean bl2, int n11, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n11 & 1) != 0) {
                n2 = 1;
            }
            if ((n11 & 2) != 0) {
                n3 = -1;
            }
            if ((n11 & 4) != 0) {
                n4 = 519;
            }
            if ((n11 & 8) != 0) {
                n5 = 7680;
            }
            if ((n11 & 0x10) != 0) {
                n6 = 7680;
            }
            if ((n11 & 0x20) != 0) {
                n7 = 7681;
            }
            if ((n11 & 0x40) != 0) {
                n8 = 514;
            }
            if ((n11 & 0x80) != 0) {
                n9 = n2;
            }
            if ((n11 & 0x100) != 0) {
                n10 = n3;
            }
            if ((n11 & 0x200) != 0) {
                bl = false;
            }
            if ((n11 & 0x400) != 0) {
                bl2 = false;
            }
            this(n2, n3, n4, n5, n6, n7, n8, n9, n10, bl, bl2);
        }

        public static kjui[] values() {
            return (kjui[])$VALUES.clone();
        }

        public static kjui valueOf(String string) {
            return Enum.valueOf(kjui.class, string);
        }
    }
}

