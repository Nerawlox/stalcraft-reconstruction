/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.internal;

@Deprecated
public class StringUtils {
    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isBlank(String string) {
        if (string == null || string.length() == 0) {
            return true;
        }
        for (int i = 0; i < string.length(); ++i) {
            if (Character.isWhitespace(string.charAt(i))) continue;
            return false;
        }
        return true;
    }

    public static String trimToEmpty(String string) {
        if (string == null || string.length() == 0) {
            return "";
        }
        int n = 0;
        int n2 = string.length() - 1;
        while (n <= n2) {
            if (Character.isWhitespace(string.charAt(n))) {
                ++n;
                continue;
            }
            if (Character.isWhitespace(string.charAt(n2))) {
                --n2;
                continue;
            }
            return string.substring(n, n2 + 1);
        }
        return "";
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
}

