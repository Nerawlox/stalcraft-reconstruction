/*
 * Decompiled with CFR 0.152.
 */
public class igvq {
    public static int[] _a = new int[65536];

    public static void _a(int[] nArray) {
        _a = nArray;
    }

    public static int _a(double d, double d2) {
        int n = (int)((1.0 - d) * 255.0);
        int n2 = (int)((1.0 - (d2 *= d)) * 255.0);
        return _a[n2 << 8 | n];
    }

    public static int _a() {
        return 0x619961;
    }

    public static int _b() {
        return 8431445;
    }

    public static int _c() {
        return 4764952;
    }
}

