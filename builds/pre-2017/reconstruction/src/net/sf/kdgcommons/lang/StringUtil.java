/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.lang;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import net.sf.kdgcommons.lang.NumberUtil;
import net.sf.kdgcommons.lang.StringCanon;

public class StringUtil {
    private static StringCanon _canon = new StringCanon();
    private static Random _RNG = new Random(System.currentTimeMillis());

    public static char lastChar(String string) {
        int n = string != null ? string.length() - 1 : -1;
        return n < 0 ? (char)'\u0000' : string.charAt(n);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isBlank(String string) {
        if (string == null) {
            string = "";
        }
        for (int i = 0; i < string.length(); ++i) {
            if (Character.isWhitespace(string.charAt(i))) continue;
            return false;
        }
        return true;
    }

    public static String trim(String string) {
        if (string == null) {
            return "";
        }
        if (string.length() == 0) {
            return "";
        }
        if (!Character.isWhitespace(string.charAt(0)) && !Character.isWhitespace(string.charAt(string.length() - 1))) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        while (stringBuilder.length() > 0 && Character.isWhitespace(stringBuilder.charAt(0))) {
            stringBuilder.deleteCharAt(0);
        }
        while (stringBuilder.length() > 0 && Character.isWhitespace(stringBuilder.charAt(stringBuilder.length() - 1))) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public static String padLeft(String string, int n, char c) {
        if (string == null) {
            string = "";
        }
        if (string.length() >= n) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = n - string.length(); i > 0; --i) {
            stringBuilder.append(c);
        }
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static String padRight(String string, int n, char c) {
        if (string == null) {
            string = "";
        }
        if (string.length() >= n) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(n);
        stringBuilder.append(string);
        while (stringBuilder.length() < n) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static boolean contains(String string, String string2) {
        if (string == null || string2 == null) {
            return false;
        }
        if (string2.length() == 0) {
            return true;
        }
        return string.indexOf(string2) >= 0;
    }

    public static boolean containsIgnoreCase(String string, String string2) {
        if (string == null || string2 == null) {
            return false;
        }
        return StringUtil.contains(string.toUpperCase(), string2.toUpperCase());
    }

    public static String repeat(char c, int n) {
        char[] cArray = new char[n];
        for (int i = 0; i < n; ++i) {
            cArray[i] = c;
        }
        return new String(cArray);
    }

    public static byte[] toUTF8(String string) {
        try {
            if (string == null) {
                return new byte[0];
            }
            return string.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("UTF-8 not supported", unsupportedEncodingException);
        }
    }

    public static String fromUTF8(byte[] byArray) {
        try {
            if (byArray == null) {
                return "";
            }
            return new String(byArray, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("UTF-8 not supported", unsupportedEncodingException);
        }
    }

    public static String unicodeEscape(String string) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < stringBuilder.length(); ++i) {
            char c = stringBuilder.charAt(i);
            if (c >= ' ' && c <= '~' && c != '\\' && c != '\'' && c != '\"') continue;
            stringBuilder.deleteCharAt(i);
            stringBuilder.insert(i, NumberUtil.toHexString(c, 4));
            stringBuilder.insert(i, "\\u");
            i += 5;
        }
        return stringBuilder.toString();
    }

    public static String unescape(String string) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < stringBuilder.length(); ++i) {
            if (stringBuilder.charAt(i) != '\\') continue;
            stringBuilder.deleteCharAt(i);
            if (stringBuilder.charAt(i) == 'u' || stringBuilder.charAt(i) == 'U') {
                int n = (StringUtil.hex2dec(stringBuilder.charAt(i + 1)) << 12) + (StringUtil.hex2dec(stringBuilder.charAt(i + 2)) << 8) + (StringUtil.hex2dec(stringBuilder.charAt(i + 3)) << 4) + StringUtil.hex2dec(stringBuilder.charAt(i + 4));
                stringBuilder.setCharAt(i, (char)n);
                stringBuilder.delete(i + 1, i + 5);
                continue;
            }
            if (stringBuilder.charAt(i) == 'b') {
                stringBuilder.setCharAt(i, '\b');
                continue;
            }
            if (stringBuilder.charAt(i) == 't') {
                stringBuilder.setCharAt(i, '\t');
                continue;
            }
            if (stringBuilder.charAt(i) == 'n') {
                stringBuilder.setCharAt(i, '\n');
                continue;
            }
            if (stringBuilder.charAt(i) == 'f') {
                stringBuilder.setCharAt(i, '\f');
                continue;
            }
            if (stringBuilder.charAt(i) != 'r') continue;
            stringBuilder.setCharAt(i, '\r');
        }
        return stringBuilder.toString();
    }

    public static int parseDigit(char c, int n) {
        int n2 = -1;
        if (c >= '0' && c <= '9') {
            n2 = c - 48;
        } else if (c >= 'a' && c <= 'z') {
            n2 = c - 97 + 10;
        } else if (c >= 'A' && c <= 'Z') {
            n2 = c - 65 + 10;
        }
        if (n2 >= n) {
            n2 = -1;
        }
        return n2;
    }

    public static String intern(String string) {
        return _canon.intern(string);
    }

    public static String randomString(String string, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder(n2);
        int n3 = n + _RNG.nextInt(n2 - n + 1);
        for (int i = 0; i < n3; ++i) {
            stringBuilder.append(string.charAt(_RNG.nextInt(string.length())));
        }
        return stringBuilder.toString();
    }

    public static String randomAlphaString(int n, int n2) {
        return StringUtil.randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", n, n2);
    }

    public static String extractLeft(String string, String string2) {
        if (string == null) {
            string = "";
        }
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            return string;
        }
        int n = string.indexOf(string2);
        if (n < 0) {
            return string;
        }
        return string.substring(0, n);
    }

    public static String extractRight(String string, String string2) {
        if (string == null) {
            string = "";
        }
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            return "";
        }
        int n = string.indexOf(string2);
        if (n < 0) {
            return "";
        }
        return string.substring(n + string2.length());
    }

    public static String extractLeftOfLast(String string, String string2) {
        if (string == null) {
            string = "";
        }
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            return string;
        }
        int n = string.lastIndexOf(string2);
        if (n < 0) {
            return string;
        }
        return string.substring(0, n);
    }

    public static String extractRightOfLast(String string, String string2) {
        if (string == null) {
            string = "";
        }
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            return "";
        }
        int n = string.lastIndexOf(string2);
        if (n < 0) {
            return "";
        }
        return string.substring(n + string2.length());
    }

    public static boolean isIn(String string, String ... stringArray) {
        for (String string2 : stringArray) {
            if (string == null && string2 == null) {
                return true;
            }
            if (string == null || !string.equals(string2)) continue;
            return true;
        }
        return false;
    }

    private static int hex2dec(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'A' && c <= 'F') {
            return c - 65 + 10;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 97 + 10;
        }
        throw new IllegalArgumentException("not a hex digit: " + c);
    }
}

