/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.vjta;

public class neog
extends zhqo {
    public static final String[] _C = new String[]{"all", "undead", "arthropods"};
    public static final int[] _D = new int[]{1, 5, 5};
    public static final int[] _E = new int[]{11, 8, 8};
    public static final int[] _F = new int[]{20, 20, 20};
    public final int _G;

    public neog(int n, int n2, int n3) {
        super(n, n2, nvsz._g);
        this._G = n3;
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
        return 5;
    }

    @Override
    public float _a(int n, EntityLivingBase entityLivingBase) {
        if (this._G == 0) {
            return (float)n * 1.25f;
        }
        if (this._G == 1 && entityLivingBase.func_70668_bt() == vjta._b) {
            return (float)n * 2.5f;
        }
        if (this._G == 2 && entityLivingBase.func_70668_bt() == vjta._c) {
            return (float)n * 2.5f;
        }
        return 0.0f;
    }

    @Override
    public String _d() {
        return "enchantment.damage." + _C[this._G];
    }

    @Override
    public boolean _a(zhqo zhqo2) {
        return !(zhqo2 instanceof neog);
    }

    @Override
    public boolean _a(cvzo cvzo2) {
        if (cvzo2._a() instanceof bsrw) {
            return true;
        }
        return super._a(cvzo2);
    }
}

