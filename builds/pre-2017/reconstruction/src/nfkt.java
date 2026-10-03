/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.IntCache;

public class nfkt
extends lqgz {
    public nfkt(long l, lqgz lqgz2) {
        super(l);
        this._b = lqgz2;
    }

    @Override
    public int[] _a(int n, int n2, int n3, int n4) {
        int n5 = n - 1;
        int n6 = n2 - 1;
        int n7 = n3 + 2;
        int n8 = n4 + 2;
        int[] nArray = this._b._a(n5, n6, n7, n8);
        int[] nArray2 = IntCache._a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n9 = nArray[j + 1 + (i + 1) * n7];
                this._a(j + n, i + n2);
                if (n9 == 0) {
                    nArray2[j + i * n3] = 0;
                    continue;
                }
                int n10 = this._a(5);
                n10 = n10 == 0 ? BiomeGenBase._n._P : 1;
                nArray2[j + i * n3] = n10;
            }
        }
        return nArray2;
    }
}

