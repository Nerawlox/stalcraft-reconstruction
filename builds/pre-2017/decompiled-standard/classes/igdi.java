/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class igdi
extends zhqo {
    public static final String[] _C = new String[]{"all", "fire", "fall", "explosion", "projectile"};
    public static final int[] _D = new int[]{1, 10, 5, 5, 3};
    public static final int[] _E = new int[]{11, 8, 6, 8, 6};
    public static final int[] _F = new int[]{20, 12, 10, 12, 15};
    public final int _G;

    public igdi(int n, int n2, int n3) {
        super(n, n2, nvsz._b);
        this._G = n3;
        if (n3 == 2) {
            this._A = nvsz._c;
        }
    }

    @Override
    public int _a(int n) {
        return _D[this._G] + (n - 1) * _E[this._G];
    }

    @Override
    public int _b(int n) {
        return this._a(n) + _F[this._G];
    }

    @Override
    public int _c() {
        return 4;
    }

    @Override
    public int _a(int n, jxtc jxtc2) {
        if (jxtc2.func_76357_e()) {
            return 0;
        }
        float f = (float)(6 + n * n) / 3.0f;
        if (this._G == 0) {
            return sajh._d(f * 0.75f);
        }
        if (this._G == 1 && jxtc2.func_76347_k()) {
            return sajh._d(f * 1.25f);
        }
        if (this._G == 2 && jxtc2 == jxtc.field_76379_h) {
            return sajh._d(f * 2.5f);
        }
        if (this._G == 3 && jxtc2.func_94541_c()) {
            return sajh._d(f * 1.5f);
        }
        if (this._G == 4 && jxtc2.func_76352_a()) {
            return sajh._d(f * 1.5f);
        }
        return 0;
    }

    @Override
    public String _d() {
        return "enchantment.protect." + _C[this._G];
    }

    @Override
    public boolean _a(zhqo zhqo2) {
        if (zhqo2 instanceof igdi) {
            igdi igdi2 = (igdi)zhqo2;
            if (igdi2._G == this._G) {
                return false;
            }
            return this._G == 2 || igdi2._G == 2;
        }
        return super._a(zhqo2);
    }

    public static int _a(Entity entity, int n) {
        int n2 = zhty._a(zhqo._d._y, entity.func_70035_c());
        if (n2 > 0) {
            n -= sajh._d((float)n * ((float)n2 * 0.15f));
        }
        return n;
    }

    public static double _a(Entity entity, double d) {
        int n = zhty._a(zhqo._f._y, entity.func_70035_c());
        if (n > 0) {
            d -= (double)sajh._c(d * (double)((float)n * 0.15f));
        }
        return d;
    }
}

