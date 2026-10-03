/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.jgro;
import gloomyfolken.mods.effects.client.main.kjui;
import gloomyfolken.mods.effects.client.main.zwaw;
import java.awt.Dimension;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0006J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/DownscaledScreenCache;", "", "()V", "CACHE_FREE_TIMEOUT", "", "DOWNSCALE_STAGES", "", "downscaledFramebuffers", "", "Lgloomyfolken/mods/effects/client/main/FramebufferObject;", "[Lgloomyfolken/mods/effects/client/main/FramebufferObject;", "downscaledRenderTargets", "Lgloomyfolken/mods/effects/client/main/BackBufferSet;", "[Lgloomyfolken/mods/effects/client/main/BackBufferSet;", "lastCacheUsed", "prevUseCache", "", "useCache", "createFramebufferTexture", "Lgloomyfolken/mods/effects/client/texture/FramebufferTexture;", "downscaleLevel", "getDownscaledFramebuffer", "level", "getDownscaledResolution", "Ljava/awt/Dimension;", "downscaleAmount", "requestAvailablity", "setInUse", "", "updateCache", "minecraft"})
public final class fmgg {
    private static final int _b = 4;
    private static boolean _c;
    private static boolean _d;
    private static final long _e = 5000L;
    private static long _f;
    private static final kjui[] _g;
    private static final jgro[] _h;
    public static final fmgg _a;

    private final Dimension _b(int n) {
        int n2 = (int)Math.pow(2.0, n);
        return new Dimension(zwaw._b() / n2, zwaw._d() / n2);
    }

    private final uyuh _c(int n) {
        return new uyuh("downscaled_stage_" + n, this._b((int)(n + 1)).width, this._b((int)(n + 1)).height, fmfc._a, true, true, null, 64, null);
    }

    public final void _a() {
        block6: {
            int n;
            Object object;
            Object object2;
            int n2;
            _c = System.currentTimeMillis() - _f < _e;
            Object[] objectArray = _g;
            int n3 = 0;
            for (n2 = 0; n2 < objectArray.length; ++n2) {
                object2 = objectArray[n2];
                int n4 = n3++;
                object = (kjui)object2;
                n = n4;
                ((kjui)object)._g();
                ((kjui)object)._a(_a._b(n + 1));
            }
            objectArray = _h;
            n3 = 0;
            for (n2 = 0; n2 < objectArray.length; ++n2) {
                object2 = objectArray[n2];
                int n5 = n3++;
                object = (jgro)object2;
                n = n5;
                ((jgro)object)._a(_a._b(n + 1));
            }
            if (_c == _d) break block6;
            _d = _c;
            if (_c) {
                objectArray = _g;
                for (n3 = 0; n3 < objectArray.length; ++n3) {
                    Object object3 = objectArray[n3];
                    object2 = (kjui)object3;
                    ((kjui)object2)._e();
                }
            } else {
                objectArray = _g;
                for (n3 = 0; n3 < objectArray.length; ++n3) {
                    Object object4 = objectArray[n3];
                    object2 = (kjui)object4;
                    ((kjui)object2)._d();
                }
            }
        }
    }

    public final void _b() {
        _f = System.currentTimeMillis();
    }

    public final boolean _c() {
        this._b();
        return _c;
    }

    @Nullable
    public final jgro _a(int n) {
        if (!this._c()) {
            return null;
        }
        return _h[owkq._a(n, 0, _b - 1)];
    }

    private fmgg() {
        Object object;
        Object[] objectArray;
        int n;
        int n2;
        _a = this;
        _b = 4;
        _e = 5000L;
        int n3 = _b;
        Object[] objectArray2 = new kjui[n3];
        int n4 = 0;
        int n5 = n3 - 1;
        if (n4 <= n5) {
            do {
                n2 = ++n4;
                n = n4;
                objectArray = objectArray2;
                objectArray[n] = object = new kjui(_a._c(n2), _a._c(n2));
            } while (n4 != n5);
        }
        _g = objectArray2;
        n3 = _b;
        objectArray2 = new jgro[n3];
        n4 = 0;
        n5 = n3 - 1;
        if (n4 <= n5) {
            do {
                n2 = ++n4;
                n = n4;
                objectArray = objectArray2;
                objectArray[n] = object = jgro._a._a("downscaled_" + n2, false, false, _a._b(n2 + 1), jhpr._a, _g[n2]);
            } while (n4 != n5);
        }
        _h = objectArray2;
    }

    static {
        new fmgg();
    }
}

