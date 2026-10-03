/*
 * Decompiled with CFR 0.152.
 */
import mcoptifine.TextureUtils;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class cegl
implements Comparable {
    public final TextureAtlasSprite _a;
    public final int _b;
    public final int _c;
    public final int _d;
    public boolean _e;
    public float _f = 1.0f;

    public cegl(TextureAtlasSprite textureAtlasSprite) {
        this._a = textureAtlasSprite;
        this._b = textureAtlasSprite.getIconWidth();
        this._c = textureAtlasSprite.getIconHeight();
        this._e = this._a(this._c) > this._a(this._b);
        this._d = textureAtlasSprite.hasAnimationMetadata() ? 1 : 0;
    }

    public TextureAtlasSprite _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c;
    }

    public void _d() {
        this._e = !this._e;
    }

    public boolean _e() {
        return this._e;
    }

    public int _a(int n) {
        int n2 = TextureUtils.ceilPowerOfTwo(n);
        return n2 < 16 ? 16 : n2;
    }

    public void _b(int n) {
        if (this._b < n || this._c < n) {
            this._f = (float)n / (float)Math.min(this._b, this._c);
        }
    }

    public void _c(int n) {
        if (this._b > n && this._c > n) {
            this._f = (float)n / (float)Math.min(this._b, this._c);
        }
    }

    public String toString() {
        return "Holder{width=" + this._b + ", height=" + this._c + '}';
    }

    public int _a(cegl cegl2) {
        int n;
        if (cegl2._d != this._d) {
            return this._d < cegl2._d ? 1 : -1;
        }
        if (this._c() == cegl2._c()) {
            if (this._b() == cegl2._b()) {
                if (this._a.getIconName() == null) {
                    return cegl2._a.getIconName() == null ? 0 : -1;
                }
                return this._a.getIconName().compareTo(cegl2._a.getIconName());
            }
            n = this._b() < cegl2._b() ? 1 : -1;
        } else {
            n = this._c() < cegl2._c() ? 1 : -1;
        }
        return n;
    }

    public int compareTo(Object object) {
        return this._a((cegl)object);
    }
}

