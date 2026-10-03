/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ctve<T extends hbcv> {
    @Nullable
    protected hbcv _a;
    protected static final xpzm _b = xpzm._E();
    protected ogej _c;
    protected static nuco _d = new nuco();
    protected float _e = 5.0f;

    protected jytp _a(String string, boolean bl, boolean bl2, boolean bl3) {
        if (this._c()) {
            return null;
        }
        jytp jytp2 = new jytp(_d, string);
        jytp2._b = bl ? gpnw._c : gpnw._b;
        float f = jytp2.speedFactor = bl2 ? 1.0f : 0.0f;
        if (bl3) {
            this._c._b(jytp2);
        } else {
            this._c._b(jytp2, this._e);
        }
        return jytp2;
    }

    public void _a() {
        if (this._c()) {
            return;
        }
        this._c._b();
        this._b();
    }

    protected void _b() {
    }

    public boolean _a(@Nullable T t) {
        if (this._a == t) {
            return false;
        }
        if (t == null) {
            this._a((ogej)null);
        } else {
            this._a(this._b(t));
        }
        this._a = t;
        return true;
    }

    protected ogej _b(@NotNull T t) {
        if (t == null) {
            ctve._a(0);
        }
        return new ogej(((iefv)t)._d, new hsnd[0]);
    }

    protected boolean _c() {
        return this._c == null;
    }

    protected void _a(ogej ogej2) {
        this._c = ogej2;
    }

    public boolean _d() {
        return !this._c() && this._c._i();
    }

    @Nullable
    public zxbe _e() {
        return this._d() ? (zxbe)this._c._u_() : null;
    }

    protected void _a(String string) {
        if (this._c()) {
            return;
        }
        this._a(this._c, string);
    }

    protected void _a(ogej ogej2, String string) {
        for (uhrn uhrn2 : ogej2._a(_d)) {
            if (!(uhrn2 instanceof jytp)) continue;
            jytp jytp2 = (jytp)uhrn2;
            if (!jytp2._a.equals(string)) continue;
            ogej2._a(uhrn2);
        }
    }

    protected jytp _a(String string, int n, gpnw gpnw2) {
        jytp jytp2 = new jytp(_d, string);
        this._a(jytp2, n);
        jytp2._b = gpnw2;
        return jytp2;
    }

    protected void _a(jytp jytp2, int n) {
        jytp2._d = (float)n / 50.0f;
    }

    private static /* synthetic */ void _a(int n) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "render", "gloomyfolken/mods/core/client/render/FirstPersonAnimationHandler", "createAnimationContext"));
    }
}

