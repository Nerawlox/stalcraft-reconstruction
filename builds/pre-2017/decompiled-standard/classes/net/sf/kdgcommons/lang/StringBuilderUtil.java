/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.lang;

public class StringBuilderUtil {
    private static final char[] NIBBLES = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static StringBuilder appendRepeat(StringBuilder stringBuilder, char c, int n) {
        stringBuilder.ensureCapacity(stringBuilder.length() + n);
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(c);
        }
        return stringBuilder;
    }

    public static StringBuilder appendHex(StringBuilder stringBuilder, int n, int n2) {
        StringBuilderUtil.appendRepeat(stringBuilder, '0', n2);
        int n3 = stringBuilder.length();
        for (int i = 1; i <= n2; ++i) {
            int n4 = n & 0xF;
            stringBuilder.setCharAt(n3 - i, NIBBLES[n4]);
            n >>>= 4;
        }
        return stringBuilder;
    }

    public static char lastChar(StringBuilder stringBuilder) {
        int n = stringBuilder != null ? stringBuilder.length() - 1 : -1;
        return n < 0 ? (char)'\u0000' : stringBuilder.charAt(n);
    }

    public static StringBuilder appendUnless(StringBuilder stringBuilder, String string, String string2) {
        int n = stringBuilder.length() - string.length();
        if (n < 0) {
            stringBuilder.append(string2);
            return stringBuilder;
        }
        for (int i = 0; i < string.length(); ++i) {
            if (stringBuilder.charAt(n + i) == string.charAt(i)) continue;
            stringBuilder.append(string2);
            return stringBuilder;
        }
        return stringBuilder;
    }
}

