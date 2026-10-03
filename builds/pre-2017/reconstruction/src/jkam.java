/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.IntCache;

public class jkam
extends lqgz {
    public lqgz _e;
    public lqgz _f;

    public jkam(long l, lqgz lqgz2, lqgz lqgz3) {
        super(l);
        this._e = lqgz2;
        this._f = lqgz3;
    }

    @Override
    public void _a(long l) {
        this._e._a(l);
        this._f._a(l);
        super._a(l);
    }

    @Override
    public int[] _a(int n, int n2, int n3, int n4) {
        int[] nArray = this._e._a(n, n2, n3, n4);
        int[] nArray2 = this._f._a(n, n2, n3, n4);
        int[] nArray3 = IntCache._a(n3 * n4);
        for (int i = 0; i < n3 * n4; ++i) {
            if (nArray[i] == BiomeGenBase._b._P) {
                nArray3[i] = nArray[i];
                continue;
            }
            if (nArray2[i] >= 0) {
                if (nArray[i] == BiomeGenBase._n._P) {
                    nArray3[i] = BiomeGenBase._m._P;
                    continue;
                }
                if (nArray[i] == BiomeGenBase._p._P || nArray[i] == BiomeGenBase._q._P) {
                    nArray3[i] = BiomeGenBase._q._P;
                    continue;
                }
                nArray3[i] = nArray2[i];
                continue;
            }
            nArray3[i] = nArray[i];
        }
        return nArray3;
    }
}

