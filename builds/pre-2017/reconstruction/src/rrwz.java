/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.world.gen.layer.IntCache;

public class rrwz
extends lqgz {
    public rrwz(long l) {
        super(l);
    }

    @Override
    public int[] _a(int n, int n2, int n3, int n4) {
        int[] nArray = IntCache._a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this._a(n + j, n2 + i);
                nArray[j + i * n3] = this._a(10) == 0 ? 1 : 0;
            }
        }
        if (n > -n3 && n <= 0 && n2 > -n4 && n2 <= 0) {
            nArray[-n + -n2 * n3] = 1;
        }
        return nArray;
    }
}

