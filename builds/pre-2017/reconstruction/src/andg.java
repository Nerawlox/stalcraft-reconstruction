/*
 * Decompiled with CFR 0.152.
 */
import java.time.Duration;

public class andg {
    private static String[][] _a = new String[][]{{"\u0441\u0435\u043a\u0443\u043d\u0434", "\u0441\u0435\u043a\u0443\u043d\u0434\u0443", "\u0441\u0435\u043a\u0443\u043d\u0434\u044b"}, {"\u043c\u0438\u043d\u0443\u0442", "\u043c\u0438\u043d\u0443\u0442\u0443", "\u043c\u0438\u043d\u0443\u0442\u044b"}, {"\u0447\u0430\u0441\u043e\u0432", "\u0447\u0430\u0441", "\u0447\u0430\u0441\u0430"}, {"\u0434\u043d\u0435\u0439", "\u0434\u0435\u043d\u044c", "\u0434\u043d\u044f"}};

    public static String _a(int n) {
        return andg._a((long)(n * 50));
    }

    public static String _a(Duration duration) {
        return andg._a(duration.toMillis());
    }

    public static String _a(long l) {
        int n;
        long l2;
        if (l < 0L) {
            return "\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e";
        }
        long l3 = l / 1000L;
        if (l3 < 60L) {
            l2 = l3;
            n = 0;
        } else if (l3 < 3600L) {
            l2 = Math.round((float)l3 / 60.0f);
            n = 1;
        } else if (l3 < 86400L) {
            l2 = Math.round((float)l3 / 3600.0f);
            n = 2;
        } else {
            l2 = Math.round((float)l3 / 86400.0f);
            n = 3;
        }
        String string = String.valueOf(l2);
        int n2 = l2 % 100L >= 11L && l2 % 100L <= 14L ? 0 : (string.endsWith("1") ? 1 : (string.endsWith("2") || string.endsWith("3") || string.endsWith("4") ? 2 : 0));
        return string + " " + _a[n][n2];
    }
}

