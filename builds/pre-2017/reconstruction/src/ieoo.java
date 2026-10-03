/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.jgro;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.effects.client.main.zwaw;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\"\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u000ej\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/BlurRenderer;", "", "()V", "BLUR_SCALE", "", "DOWNSCALE_THRESOLDS", "", "KERNEL_STEP", "", "MIN_KERNEL_SIZE", "activeBlurShader", "Lgloomyfolken/mods/effects/client/main/Shader;", "activeKernelSize", "kernelSizeToShader", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "applyBlur", "", "applyTransform", "", "blurPower", "", "targetFbo", "Lgloomyfolken/mods/effects/client/main/FramebufferObject;", "doBlur", "blurExecutionParams", "Lgloomyfolken/mods/effects/client/postprocess/BlurRenderer$BlurExecutionParams;", "getBlurExecutionParams", "prepareShader", "BlurExecutionParams", "minecraft"})
public final class ieoo {
    private static jxtc _b;
    private static int _c;
    private static final LinkedHashMap<Integer, jxtc> _d;
    private static final double[] _e;
    private static final double _f = 60.0;
    private static final int _g = 4;
    private static final int _h = 4;
    public static final ieoo _a;

    private final boolean _a() {
        jxtc jxtc2;
        Object object;
        if (_d.size() > 100) {
            object = _d;
            Map map = object;
            Iterator iterator2 = map.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry entry;
                Map.Entry entry2 = entry = iterator2.next();
                ((jxtc)entry2.getValue())._c();
            }
            _d.clear();
        }
        if ((jxtc2 = _d.get(_c)) == null) {
            jxtc2 = new jhrs(_c);
        }
        object = jxtc2;
        _d.putIfAbsent(_c, (jxtc)object);
        if (Intrinsics.areEqual(_b, object) ^ true) {
            _b = object;
        }
        return true;
    }

    private final kjui _a(float f) {
        double d;
        int n;
        double d2 = (double)f * 60.0;
        int n2 = 0;
        double[] dArray = _e;
        for (n = 0; n < dArray.length; ++n) {
            d = dArray[n];
            if (!((double)f > d)) continue;
            ++n2;
        }
        d = Math.pow(2.0, n2);
        n = (int)(d2 / d) * 4 + 1;
        if ((double)n <= 0.0) {
            return null;
        }
        int n3 = 4 + n;
        return new kjui(n3, n2, 0, 4, null);
    }

    private final void _a(boolean bl, kjui kjui2, jgro jgro2) {
        Object object = kjui2;
        int n = ((kjui)object)._d();
        int n2 = ((kjui)object)._e();
        int n3 = ((kjui)object)._f();
        object = null;
        _c = n;
        if (this._a() && _c > 4) {
            jxtc jxtc2 = _b;
            if (jxtc2 == null) {
                return;
            }
            object = jxtc2;
            if (bl) {
                hsmn._e();
            }
            int n4 = zwaw._b();
            int n5 = zwaw._d();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = jgro2._j()._c();
            ((uyuh)objectRef.element)._b(0);
            int n6 = 1;
            int n7 = n2;
            if (n6 <= n7) {
                while (fmgg._a._a(n6 - 1) != null) {
                    jgro jgro3;
                    jgro3._b(pidb._a);
                    objectRef.element = jgro3._j()._c();
                    ((uyuh)objectRef.element)._b(0);
                    n4 = ((uyuh)objectRef.element)._c().width;
                    n5 = ((uyuh)objectRef.element)._c().height;
                    if (n6 == n7) break;
                    ++n6;
                }
            }
            ((jxtc)object)._e();
            ((jxtc)object)._a("image", 0);
            ((jxtc)object)._a("pixelOffset", 1.0f / (float)n4, 0.0f);
            jgro jgro4 = jgro._a._b();
            if (jgro4 == null) {
                Intrinsics.throwNpe();
            }
            jgro4._a(new Function0<Unit>(){

                @Override
                public /* synthetic */ Object invoke() {
                    this._a();
                    return Unit.INSTANCE;
                }

                public final void _a() {
                    ((uyuh)objectRef.element)._b(0);
                    hsmn._c();
                }
            });
            ((jxtc)object)._a("pixelOffset", 0.0f, 1.0f / (float)n5);
            jgro jgro5 = jgro._a._b();
            if (jgro5 == null) {
                Intrinsics.throwNpe();
            }
            jgro5._a(ezey._a);
            GL20.glUseProgram(0);
            jgro jgro6 = jgro._a._b();
            if (jgro6 == null) {
                Intrinsics.throwNpe();
            }
            jgro6._j()._c()._b(0);
            GL11.glDisable(3042);
            jgro2._b(zwat._a);
            GL11.glEnable(3042);
            if (bl) {
                hsmn._f();
            }
        }
    }

    static /* bridge */ /* synthetic */ void _a(ieoo ieoo2, boolean bl, kjui kjui2, jgro jgro2, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        ieoo2._a(bl, kjui2, jgro2);
    }

    @JvmStatic
    public static final void _a(boolean bl, float f, @NotNull jgro jgro2) {
        Intrinsics.checkParameterIsNotNull(jgro2, "targetFbo");
        kjui kjui2 = _a._a(owkq._b(f, 0.0f, 1.0f));
        if (kjui2 == null) {
            return;
        }
        kjui kjui3 = kjui2;
        if (zwaw._n()) {
            _a._a(bl, kjui3, jgro2);
        }
    }

    @JvmStatic
    public static /* bridge */ /* synthetic */ void _a(boolean bl, float f, jgro jgro2, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        ieoo._a(bl, f, jgro2);
    }

    private ieoo() {
        _a = this;
        _c = 7;
        _d = new LinkedHashMap();
        _e = new double[]{0.125, 0.5, 1.0, 2.0};
    }

    static {
        new ieoo();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/BlurRenderer$BlurExecutionParams;", "", "kernelSize", "", "downscaleLevel", "passCount", "(III)V", "getDownscaleLevel", "()I", "getKernelSize", "getPassCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "minecraft"})
    private static final class kjui {
        private final int _a;
        private final int _b;
        private final int _c;

        public final int _a() {
            return this._a;
        }

        public final int _b() {
            return this._b;
        }

        public final int _c() {
            return this._c;
        }

        public kjui(int n, int n2, int n3) {
            this._a = n;
            this._b = n2;
            this._c = n3;
        }

        public /* synthetic */ kjui(int n, int n2, int n3, int n4, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n4 & 4) != 0) {
                n3 = 1;
            }
            this(n, n2, n3);
        }

        public final int _d() {
            return this._a;
        }

        public final int _e() {
            return this._b;
        }

        public final int _f() {
            return this._c;
        }

        @NotNull
        public final kjui _a(int n, int n2, int n3) {
            return new kjui(n, n2, n3);
        }

        @NotNull
        public static /* bridge */ /* synthetic */ kjui _a(kjui kjui2, int n, int n2, int n3, int n4, Object object) {
            if ((n4 & 1) != 0) {
                n = kjui2._a;
            }
            if ((n4 & 2) != 0) {
                n2 = kjui2._b;
            }
            if ((n4 & 4) != 0) {
                n3 = kjui2._c;
            }
            return kjui2._a(n, n2, n3);
        }

        public String toString() {
            return "BlurExecutionParams(kernelSize=" + this._a + ", downscaleLevel=" + this._b + ", passCount=" + this._c + ")";
        }

        public int hashCode() {
            return (Integer.hashCode(this._a) * 31 + Integer.hashCode(this._b)) * 31 + Integer.hashCode(this._c);
        }

        public boolean equals(Object object) {
            block3: {
                block2: {
                    if (this == object) break block2;
                    if (!(object instanceof kjui)) break block3;
                    kjui kjui2 = (kjui)object;
                    if (!(this._a == kjui2._a) || !(this._b == kjui2._b) || !(this._c == kjui2._c)) break block3;
                }
                return true;
            }
            return false;
        }
    }
}

