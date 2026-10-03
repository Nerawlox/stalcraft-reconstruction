/*
 * Decompiled with CFR 0.152.
 */
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

public class bqgh {
    public static final DateTimeFormatter _a = DateTimeFormatter.ofPattern("dd-MM-yyyy").withZone(Clock.systemDefaultZone().getZone());
    public static final DateTimeFormatter _b = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy").withZone(Clock.systemDefaultZone().getZone());
    public static final DateTimeFormatter _c = DateTimeFormatter.ofPattern("HH:mm").withZone(Clock.systemDefaultZone().getZone());
    private static final int _e = 120000;
    private static final int _f = 40000;
    private static final int _g = 6666;
    private static final int _h = 111;
    private static final int _i = 5;
    public static final ZoneOffset _d = ZoneId.systemDefault().getRules().getOffset(Instant.now());

    public static LocalTime _a(long l) {
        int n = bqgh._c(l);
        int n2 = (n / 6666 + 5) % 24;
        int n3 = n % 6666 / 111;
        return LocalTime.of(n2, n3);
    }

    public static String _b(long l) {
        int n = bqgh._c(l);
        int n2 = (n / 6666 + 5) % 24;
        int n3 = n % 6666 / 111;
        return StringUtils.leftPad(String.valueOf(n2), 2, '0') + ":" + StringUtils.leftPad(String.valueOf(n3), 2, '0');
    }

    public static int _a(String string) {
        int n;
        String[] stringArray = string.split(":");
        try {
            n = Integer.parseInt(stringArray[0]) * 6666 - 33330;
            if (stringArray.length >= 2) {
                n += Integer.parseInt(stringArray[1]) * 111;
            }
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("Wrong time format: " + string);
        }
        if (n > 160000) {
            throw new IllegalArgumentException("Max limit is 24:00, was given " + string);
        }
        return n;
    }

    public static int _c(long l) {
        return (int)(l % 160000L);
    }

    public static boolean _d(long l) {
        int n = bqgh._c(l);
        return n >= 0 && n < 120000;
    }

    public static String _e(long l) {
        if (l < 1000L) {
            return "\u0442\u043e\u043b\u044c\u043a\u043e \u0447\u0442\u043e";
        }
        long l2 = (long)Math.floor(l / 1000L);
        if (l2 < 60L) {
            return l2 + " \u0441\u0435\u043a. \u043d\u0430\u0437\u0430\u0434";
        }
        long l3 = (long)Math.floor(l / 60000L);
        if (l3 < 60L) {
            return l3 + " \u043c\u0438\u043d. \u043d\u0430\u0437\u0430\u0434";
        }
        long l4 = (long)Math.floor(l / 3600000L);
        if (l4 < 24L) {
            return l4 + " \u0447. \u043d\u0430\u0437\u0430\u0434";
        }
        long l5 = (long)Math.floor(l / 86400000L);
        if (l5 < 7L) {
            if (l5 % 10L == 1L && l5 % 100L != 11L) {
                return l5 + " \u0434\u0435\u043d\u044c \u043d\u0430\u0437\u0430\u0434";
            }
            return l5 + " \u0434\u043d. \u043d\u0430\u0437\u0430\u0434";
        }
        long l6 = (long)Math.floor(l / TimeUnit.DAYS.toMillis(7L));
        if (l6 < 4L) {
            if (l6 == 1L) {
                return l6 + " \u043d\u0435\u0434\u0435\u043b\u044f \u043d\u0430\u0437\u0430\u0434";
            }
            return l6 + " \u043d\u0435\u0434\u0435\u043b\u0438 \u043d\u0430\u0437\u0430\u0434";
        }
        long l7 = (long)Math.floor(l / TimeUnit.DAYS.toMillis(30L));
        if (l7 < 12L) {
            if (l7 == 1L) {
                return l7 + " \u043c\u0435\u0441\u044f\u0446 \u043d\u0430\u0437\u0430\u0434";
            }
            if (l7 == 2L || l7 == 3L || l7 == 4L) {
                return l7 + " \u043c\u0435\u0441\u044f\u0446\u0430 \u043d\u0430\u0437\u0430\u0434";
            }
            return l7 + " \u043c\u0435\u0441\u044f\u0446\u0435\u0432 \u043d\u0430\u0437\u0430\u0434";
        }
        return null;
    }

    public static boolean _a(int n, long l, long l2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l2);
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(n) == calendar2.get(n);
    }
}

