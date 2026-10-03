/*
 * Decompiled with CFR 0.152.
 */
import java.io.UnsupportedEncodingException;

public class ywcd {
    public static char[] _a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String _a(byte[] byArray, int n, int n2) {
        int n3;
        int n4 = n2 - 1;
        int n5 = n3 = n > n4 ? n4 : n;
        while (0 != byArray[n3] && n3 < n4) {
            ++n3;
        }
        try {
            return new String(byArray, n, n3 - n, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return null;
        }
    }

    public static int _a(byte[] byArray, int n) {
        return ywcd._b(byArray, n, byArray.length);
    }

    public static int _b(byte[] byArray, int n, int n2) {
        if (0 > n2 - n - 4) {
            return 0;
        }
        return byArray[n + 3] << 24 | (byArray[n + 2] & 0xFF) << 16 | (byArray[n + 1] & 0xFF) << 8 | byArray[n] & 0xFF;
    }

    public static int _c(byte[] byArray, int n, int n2) {
        if (0 > n2 - n - 4) {
            return 0;
        }
        return byArray[n] << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
    }

    public static String _a(byte by) {
        return "" + _a[(by & 0xF0) >>> 4] + _a[by & 0xF];
    }
}

