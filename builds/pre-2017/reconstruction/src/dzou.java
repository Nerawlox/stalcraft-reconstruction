/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class dzou
extends btis {
    public int[] _a = new int[512];
    public double _b;
    public double _c;
    public double _d;

    public dzou() {
        this(new Random());
    }

    public dzou(Random random) {
        int n;
        this._b = random.nextDouble() * 256.0;
        this._c = random.nextDouble() * 256.0;
        this._d = random.nextDouble() * 256.0;
        for (n = 0; n < 256; ++n) {
            this._a[n] = n;
        }
        for (n = 0; n < 256; ++n) {
            int n2 = random.nextInt(256 - n) + n;
            int n3 = this._a[n];
            this._a[n] = this._a[n2];
            this._a[n2] = n3;
            this._a[n + 256] = this._a[n];
        }
    }

    public final double _a(double d, double d2, double d3) {
        return d2 + d * (d3 - d2);
    }

    public final double _a(int n, double d, double d2) {
        int n2 = n & 0xF;
        double d3 = (double)(1 - ((n2 & 8) >> 3)) * d;
        double d4 = n2 < 4 ? 0.0 : (n2 == 12 || n2 == 14 ? d : d2);
        return ((n2 & 1) == 0 ? d3 : -d3) + ((n2 & 2) == 0 ? d4 : -d4);
    }

    public final double _a(int n, double d, double d2, double d3) {
        double d4;
        int n2 = n & 0xF;
        double d5 = d4 = n2 < 8 ? d : d2;
        double d6 = n2 < 4 ? d2 : (n2 == 12 || n2 == 14 ? d : d3);
        return ((n2 & 1) == 0 ? d4 : -d4) + ((n2 & 2) == 0 ? d6 : -d6);
    }

    public void _a(double[] dArray, double d, double d2, double d3, int n, int n2, int n3, double d4, double d5, double d6, double d7) {
        if (n2 == 1) {
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            double d8 = 0.0;
            double d9 = 0.0;
            int n8 = 0;
            double d10 = 1.0 / d7;
            for (int i = 0; i < n; ++i) {
                double d11 = d + (double)i * d4 + this._b;
                int n9 = (int)d11;
                if (d11 < (double)n9) {
                    --n9;
                }
                int n10 = n9 & 0xFF;
                double d12 = (d11 -= (double)n9) * d11 * d11 * (d11 * (d11 * 6.0 - 15.0) + 10.0);
                for (int j = 0; j < n3; ++j) {
                    double d13 = d3 + (double)j * d6 + this._d;
                    int n11 = (int)d13;
                    if (d13 < (double)n11) {
                        --n11;
                    }
                    int n12 = n11 & 0xFF;
                    double d14 = (d13 -= (double)n11) * d13 * d13 * (d13 * (d13 * 6.0 - 15.0) + 10.0);
                    n4 = this._a[n10] + 0;
                    n5 = this._a[n4] + n12;
                    n6 = this._a[n10 + 1] + 0;
                    n7 = this._a[n6] + n12;
                    d8 = this._a(d12, this._a(this._a[n5], d11, d13), this._a(this._a[n7], d11 - 1.0, 0.0, d13));
                    d9 = this._a(d12, this._a(this._a[n5 + 1], d11, 0.0, d13 - 1.0), this._a(this._a[n7 + 1], d11 - 1.0, 0.0, d13 - 1.0));
                    double d15 = this._a(d14, d8, d9);
                    int n13 = n8++;
                    dArray[n13] = dArray[n13] + d15 * d10;
                }
            }
            return;
        }
        int n14 = 0;
        double d16 = 1.0 / d7;
        int n15 = -1;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        int n19 = 0;
        int n20 = 0;
        int n21 = 0;
        double d17 = 0.0;
        double d18 = 0.0;
        double d19 = 0.0;
        double d20 = 0.0;
        for (int i = 0; i < n; ++i) {
            double d21 = d + (double)i * d4 + this._b;
            int n22 = (int)d21;
            if (d21 < (double)n22) {
                --n22;
            }
            int n23 = n22 & 0xFF;
            double d22 = (d21 -= (double)n22) * d21 * d21 * (d21 * (d21 * 6.0 - 15.0) + 10.0);
            for (int j = 0; j < n3; ++j) {
                double d23 = d3 + (double)j * d6 + this._d;
                int n24 = (int)d23;
                if (d23 < (double)n24) {
                    --n24;
                }
                int n25 = n24 & 0xFF;
                double d24 = (d23 -= (double)n24) * d23 * d23 * (d23 * (d23 * 6.0 - 15.0) + 10.0);
                for (int k = 0; k < n2; ++k) {
                    double d25 = d2 + (double)k * d5 + this._c;
                    int n26 = (int)d25;
                    if (d25 < (double)n26) {
                        --n26;
                    }
                    int n27 = n26 & 0xFF;
                    double d26 = (d25 -= (double)n26) * d25 * d25 * (d25 * (d25 * 6.0 - 15.0) + 10.0);
                    if (k == 0 || n27 != n15) {
                        n15 = n27;
                        n16 = this._a[n23] + n27;
                        n17 = this._a[n16] + n25;
                        n18 = this._a[n16 + 1] + n25;
                        n19 = this._a[n23 + 1] + n27;
                        n20 = this._a[n19] + n25;
                        n21 = this._a[n19 + 1] + n25;
                        d17 = this._a(d22, this._a(this._a[n17], d21, d25, d23), this._a(this._a[n20], d21 - 1.0, d25, d23));
                        d18 = this._a(d22, this._a(this._a[n18], d21, d25 - 1.0, d23), this._a(this._a[n21], d21 - 1.0, d25 - 1.0, d23));
                        d19 = this._a(d22, this._a(this._a[n17 + 1], d21, d25, d23 - 1.0), this._a(this._a[n20 + 1], d21 - 1.0, d25, d23 - 1.0));
                        d20 = this._a(d22, this._a(this._a[n18 + 1], d21, d25 - 1.0, d23 - 1.0), this._a(this._a[n21 + 1], d21 - 1.0, d25 - 1.0, d23 - 1.0));
                    }
                    double d27 = this._a(d26, d17, d18);
                    double d28 = this._a(d26, d19, d20);
                    double d29 = this._a(d24, d27, d28);
                    int n28 = n14++;
                    dArray[n28] = dArray[n28] + d29 * d16;
                }
            }
        }
    }
}

