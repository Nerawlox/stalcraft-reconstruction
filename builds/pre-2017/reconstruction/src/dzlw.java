/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.world.biome.BiomeGenBase;

public class dzlw {
    public float[] _a = new float[256];
    public float[] _b = new float[256];
    public BiomeGenBase[] _c = new BiomeGenBase[256];
    public int _d;
    public int _e;
    public long _f;
    public final /* synthetic */ plnl _g;

    public dzlw(plnl plnl2, int n, int n2) {
        this._g = plnl2;
        this._d = n;
        this._e = n2;
        plnl._a(plnl2)._b(this._a, n << 4, n2 << 4, 16, 16);
        plnl._a(plnl2)._a(this._b, n << 4, n2 << 4, 16, 16);
        plnl._a(plnl2)._a(this._c, n << 4, n2 << 4, 16, 16, false);
    }

    public BiomeGenBase _a(int n, int n2) {
        return this._c[n & 0xF | (n2 & 0xF) << 4];
    }
}

