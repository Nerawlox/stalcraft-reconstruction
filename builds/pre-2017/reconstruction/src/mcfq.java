/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.sajh;

public class mcfq
extends btis {
    public dzou[] _a;
    public int _b;

    public mcfq(Random random, int n) {
        this._b = n;
        this._a = new dzou[n];
        for (int i = 0; i < n; ++i) {
            this._a[i] = new dzou(random);
        }
    }

    public double[] _a(double[] dArray, int n, int n2, int n3, int n4, int n5, int n6, double d, double d2, double d3) {
        if (dArray == null) {
            dArray = new double[n4 * n5 * n6];
        } else {
            for (int i = 0; i < dArray.length; ++i) {
                dArray[i] = 0.0;
            }
        }
        double d4 = 1.0;
        for (int i = 0; i < this._b; ++i) {
            double d5 = (double)n * d4 * d;
            double d6 = (double)n2 * d4 * d2;
            double d7 = (double)n3 * d4 * d3;
            long l = sajh._d(d5);
            long l2 = sajh._d(d7);
            d5 -= (double)l;
            d7 -= (double)l2;
            this._a[i]._a(dArray, d5 += (double)(l %= 0x1000000L), d6, d7 += (double)(l2 %= 0x1000000L), n4, n5, n6, d * d4, d2 * d4, d3 * d4, d4);
            d4 /= 2.0;
        }
        return dArray;
    }

    public double[] _a(double[] dArray, int n, int n2, int n3, int n4, double d, double d2, double d3) {
        return this._a(dArray, n, 10, n2, n3, 1, n4, d, 1.0, d2);
    }
}

