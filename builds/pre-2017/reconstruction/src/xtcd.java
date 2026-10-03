/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;

public class xtcd {
    public final int _d;
    public final int _e;
    public final int _f;

    public xtcd(int n, int n2, int n3) {
        this._d = n;
        this._e = n2;
        this._f = n3;
    }

    public xtcd(Vec3 vec3) {
        this(sajh._c(vec3._c), sajh._c(vec3._d), sajh._c(vec3._e));
    }

    public boolean equals(Object object) {
        boolean bl = GloomyHooks.equals(this, object);
        return bl;
    }

    public int hashCode() {
        return this._d * 8976890 + this._e * 981131 + this._f;
    }
}

