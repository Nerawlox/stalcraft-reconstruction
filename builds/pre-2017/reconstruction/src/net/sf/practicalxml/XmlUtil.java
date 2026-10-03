/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import net.sf.kdgcommons.lang.StringUtil;
import net.sf.practicalxml.XmlException;

public class XmlUtil {
    private static final boolean[] LEGAL_CONTROL_CHARS = new boolean[]{false, false, false, false, false, false, false, false, false, true, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    private static ThreadLocal<DateFormat> _xsdDatetimeFormatter = new ThreadLocal();
    private static ThreadLocal<DecimalFormat> _xsdDecimalFormatter = new ThreadLocal();

    public static boolean isLegal(String string) {
        for (int i = 0; i < string.length(); ++i) {
            if (XmlUtil.isLegal(string.charAt(i))) continue;
            return false;
        }
        return true;
    }

    public static String stripIllegals(String string) {
        StringBuilder stringBuilder = null;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (!XmlUtil.isLegal(c)) {
                if (stringBuilder != null) continue;
                stringBuilder = new StringBuilder(string.length());
                stringBuilder.append(string.substring(0, i));
                continue;
            }
            if (stringBuilder == null) continue;
            stringBuilder.append(c);
        }
        return stringBuilder != null ? stringBuilder.toString() : string;
    }

    public static String formatXsdDatetime(Date date) {
        return XmlUtil.getXsdDatetimeFormatter().format(date);
    }

    public static Date parseXsdDatetime(String string) throws XmlException {
        try {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTimeInMillis(0L);
            int n = XmlUtil.parserHelper(string, calendar, 1, 0);
            n = XmlUtil.parserHelper(string, calendar, 2, n + 1);
            n = XmlUtil.parserHelper(string, calendar, 5, n + 1);
            n = XmlUtil.parserHelper(string, calendar, 11, n + 1);
            n = XmlUtil.parserHelper(string, calendar, 12, n + 1);
            n = XmlUtil.parserHelper(string, calendar, 13, n + 1);
            if (n < string.length() && string.charAt(n) == '.') {
                n = XmlUtil.parserHelper(string, calendar, 14, n + 1);
            }
            XmlUtil.parseTimezone(string, calendar, n);
            return calendar.getTime();
        }
        catch (Exception exception) {
            throw new XmlException("unable to parse: " + string, exception);
        }
    }

    public static String formatXsdDecimal(double d) {
        return XmlUtil.formatXsdDecimal((Number)d);
    }

    public static String formatXsdDecimal(Number number) {
        if (number == null) {
            return "";
        }
        return XmlUtil.getXsdDecimalFormatter().format(number);
    }

    public static String formatXsdBoolean(boolean bl) {
        return bl ? "true" : "false";
    }

    public static boolean parseXsdBoolean(String string) {
        try {
            string = string.trim();
            if (string.equals("true") || string.equals("1")) {
                return true;
            }
            if (string.equals("false") || string.equals("0")) {
                return false;
            }
            throw new XmlException("not an XSD boolean value: " + string);
        }
        catch (NullPointerException nullPointerException) {
            throw new XmlException("null values not allowed");
        }
    }

    public static String escape(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        boolean bl = false;
        block7: for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            switch (c) {
                case '&': {
                    stringBuilder.append("&amp;");
                    bl = true;
                    continue block7;
                }
                case '<': {
                    stringBuilder.append("&lt;");
                    bl = true;
                    continue block7;
                }
                case '>': {
                    stringBuilder.append("&gt;");
                    bl = true;
                    continue block7;
                }
                case '\'': {
                    stringBuilder.append("&apos;");
                    bl = true;
                    continue block7;
                }
                case '\"': {
                    stringBuilder.append("&quot;");
                    bl = true;
                    continue block7;
                }
                default: {
                    stringBuilder.append(c);
                }
            }
        }
        return bl ? stringBuilder.toString() : string;
    }

    public static String unescape(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length() + 20);
        boolean bl = false;
        block3: for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            switch (c) {
                case '&': {
                    i = XmlUtil.unescapeHelper(string, i, stringBuilder);
                    bl = true;
                    continue block3;
                }
                default: {
                    stringBuilder.append(c);
                }
            }
        }
        return bl ? stringBuilder.toString() : string;
    }

    private static boolean isLegal(char c) {
        if (c < '\ud800') {
            return c < ' ' ? LEGAL_CONTROL_CHARS[c] : true;
        }
        return c >= '\ue000';
    }

    private static DateFormat getXsdDatetimeFormatter() {
        DateFormat dateFormat = _xsdDatetimeFormatter.get();
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            _xsdDatetimeFormatter.set(dateFormat);
        }
        return dateFormat;
    }

    private static DecimalFormat getXsdDecimalFormatter() {
        DecimalFormat decimalFormat = _xsdDecimalFormatter.get();
        if (decimalFormat == null) {
            decimalFormat = new DecimalFormat("#0.0################;-#");
            _xsdDecimalFormatter.set(decimalFormat);
        }
        return decimalFormat;
    }

    private static int parserHelper(String string, Calendar calendar, int n, int n2) {
        int n3 = n2;
        switch (n) {
            case 1: {
                n3 = string.indexOf(45, n2 + 1);
                break;
            }
            case 2: 
            case 5: 
            case 11: 
            case 12: 
            case 13: {
                n3 += 2;
                break;
            }
            case 14: {
                n3 = string.indexOf(43, n2);
                if (n3 < 0) {
                    n3 = string.indexOf(45, n2);
                }
                if (n3 < 0) {
                    n3 = string.indexOf(90, n2);
                }
                if (n3 >= 0) break;
                n3 = string.length();
            }
        }
        int n4 = Integer.parseInt(string.substring(n2, n3));
        switch (n) {
            case 2: {
                --n4;
            }
        }
        calendar.set(n, n4);
        return n3;
    }

    private static void parseTimezone(String string, Calendar calendar, int n) {
        String string2 = "GMT";
        if (n < string.length()) {
            char c = string.charAt(n);
            if (c == '+' || c == '-') {
                string2 = "GMT" + string.substring(n);
            } else if (c != 'Z' && c != 'z') {
                throw new XmlException("invalid timezone designator: " + string.substring(n));
            }
        }
        calendar.setTimeZone(TimeZone.getTimeZone(string2));
    }

    private static int unescapeHelper(String string, int n, StringBuilder stringBuilder) {
        try {
            char c;
            if (string.startsWith("&amp;", n)) {
                stringBuilder.append("&");
                return n + 4;
            }
            if (string.startsWith("&apos;", n)) {
                stringBuilder.append("'");
                return n + 5;
            }
            if (string.startsWith("&quot;", n)) {
                stringBuilder.append('\"');
                return n + 5;
            }
            if (string.startsWith("&lt;", n)) {
                stringBuilder.append("<");
                return n + 3;
            }
            if (string.startsWith("&gt;", n)) {
                stringBuilder.append(">");
                return n + 3;
            }
            if (string.startsWith("&#", n) && (c = XmlUtil.numericEntityHelper(string, n)) != '\u0000') {
                stringBuilder.append(c);
                return string.indexOf(59, n);
            }
        }
        catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            // empty catch block
        }
        stringBuilder.append('&');
        return n;
    }

    private static char numericEntityHelper(String string, int n) {
        char c;
        int n2 = 0;
        int n3 = 10;
        if (string.charAt(n += 2) == 'x') {
            n3 = 16;
            ++n;
        }
        for (int i = 0; i < 6 && (c = string.charAt(n + i)) != ';'; ++i) {
            int n4 = StringUtil.parseDigit(c, n3);
            if (n4 < 0) {
                return '\u0000';
            }
            n2 = n2 * n3 + n4;
        }
        if (n2 > 65535) {
            return '\u0000';
        }
        return (char)n2;
    }
}

