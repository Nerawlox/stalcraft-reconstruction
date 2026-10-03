/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class htwe {
    public final Set<cegl> _a = new HashSet<cegl>(256);
    public final List<nvhy> _b = new ArrayList<nvhy>(256);
    public int _c;
    public int _d;
    public final int _e;
    public final int _f;
    public final boolean _g;
    public final int _h;
    public int _i;

    public htwe(int n, int n2, boolean bl) {
        this(n, n2, bl, 0);
    }

    public htwe(int n, int n2, boolean bl, int n3) {
        this._e = n;
        this._f = n2;
        this._g = bl;
        this._h = n3;
    }

    public int _a() {
        return this._c;
    }

    public int _b() {
        return this._d;
    }

    public void _a(TextureAtlasSprite textureAtlasSprite) {
        cegl cegl2 = new cegl(textureAtlasSprite);
        if (this._h > 0) {
            cegl2._c(this._h);
        }
        if (this._i > 0) {
            cegl2._b(this._i);
        }
        this._a.add(cegl2);
    }

    public void _c() {
        Object[] objectArray = this._a.toArray(new cegl[this._a.size()]);
        Arrays.sort(objectArray);
        for (Object object : objectArray) {
            if (this._a((cegl)object)) continue;
            String string = String.format("Unable to fit: %s - size: %dx%d - Maybe try a lowerresolution texturepack?", ((cegl)object)._a().getIconName(), ((cegl)object)._a().getIconWidth(), ((cegl)object)._a().getIconHeight());
            throw new iwyc((cegl)object, string);
        }
        if (this._g) {
            this._c = this._a(this._c);
            this._d = this._a(this._d);
        }
    }

    public List<TextureAtlasSprite> _d() {
        ArrayList<nvhy> arrayList = Lists.newArrayList();
        for (nvhy object : this._b) {
            object._a(arrayList);
        }
        ArrayList arrayList2 = Lists.newArrayList();
        for (nvhy nvhy2 : arrayList) {
            cegl cegl2 = nvhy2._a();
            TextureAtlasSprite textureAtlasSprite = cegl2._a();
            textureAtlasSprite.initSprite(this._c, this._d, nvhy2._b(), nvhy2._c(), true);
            arrayList2.add(textureAtlasSprite);
        }
        return arrayList2;
    }

    public int _a(int n) {
        int n2 = n - 1;
        n2 |= n2 >> 1;
        n2 |= n2 >> 2;
        n2 |= n2 >> 4;
        n2 |= n2 >> 8;
        n2 |= n2 >> 16;
        return n2 + 1;
    }

    public boolean _a(cegl cegl2) {
        for (nvhy nvhy2 : this._b) {
            if (nvhy2._a(cegl2)) {
                return true;
            }
            cegl2._d();
            if (nvhy2._a(cegl2)) {
                return true;
            }
            cegl2._d();
        }
        return this._b(cegl2);
    }

    public boolean _b(cegl cegl2) {
        nvhy nvhy2;
        boolean bl;
        int n;
        boolean bl2;
        int n2 = Math.min(cegl2._c(), cegl2._b());
        boolean bl3 = bl2 = this._c == 0 && this._d == 0;
        if (this._g) {
            int n3;
            boolean bl4;
            n = this._a(this._c + n2);
            int n4 = this._a(this._d + n2);
            boolean bl5 = n <= this._e;
            boolean bl6 = bl4 = n4 <= this._f;
            if (!bl5 && !bl4) {
                return false;
            }
            int n5 = Math.max(cegl2._c(), cegl2._b());
            if (bl2 && !bl5 && this._a(this._d + n5) > this._f) {
                return false;
            }
            int n6 = this._a(this._c + n2);
            bl = n6 <= (n3 = this._a(this._d + n2));
        } else {
            boolean bl7;
            n = this._c + n2 <= this._e ? 1 : 0;
            boolean bl8 = bl7 = this._d + n2 <= this._f;
            if (n == 0 && !bl7) {
                return false;
            }
            boolean bl9 = bl = (bl2 || this._c <= this._d) && n != 0;
        }
        if (bl) {
            if (cegl2._b() > cegl2._c()) {
                cegl2._d();
            }
            if (this._d == 0) {
                this._d = cegl2._c();
            }
            nvhy2 = new nvhy(this._c, 0, cegl2._b(), this._d);
            this._c += cegl2._b();
        } else {
            nvhy2 = new nvhy(0, this._d, this._c, cegl2._c());
            this._d += cegl2._c();
        }
        nvhy2._a(cegl2);
        this._b.add(nvhy2);
        return true;
    }

    public int _b(int n) {
        int n2 = this._a(n);
        return n < n2 ? n2 / 2 : n2;
    }
}

