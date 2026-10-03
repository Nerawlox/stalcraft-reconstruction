/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter.internal;

import net.sf.kdgcommons.lang.StringUtil;

public class JsonUtils {
    public static String escape(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length() + 20);
        block8: for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            switch (c) {
                case '\"': 
                case '/': 
                case '\\': {
                    stringBuilder.append('\\').append(c);
                    continue block8;
                }
                case '\b': {
                    stringBuilder.append("\\b");
                    continue block8;
                }
                case '\f': {
                    stringBuilder.append("\\f");
                    continue block8;
                }
                case '\n': {
                    stringBuilder.append("\\n");
                    continue block8;
                }
                case '\r': {
                    stringBuilder.append("\\r");
                    continue block8;
                }
                case '\t': {
                    stringBuilder.append("\\t");
                    continue block8;
                }
                default: {
                    if (c >= ' ' && c <= '\u007f') {
                        stringBuilder.append(c);
                        continue block8;
                    }
                    stringBuilder.append(JsonUtils.escapeUnicode(c));
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String unescape(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        int n = 0;
        while (n < string.length()) {
            char c;
            if ((c = string.charAt(n++)) == '\\') {
                if (n == string.length()) {
                    throw new IllegalArgumentException("escape extends past end of string");
                }
                c = string.charAt(n++);
                switch (c) {
                    case '\"': 
                    case '/': 
                    case '\\': {
                        break;
                    }
                    case 'b': {
                        c = '\b';
                        break;
                    }
                    case 'f': {
                        c = '\f';
                        break;
                    }
                    case 'n': {
                        c = '\n';
                        break;
                    }
                    case 'r': {
                        c = '\r';
                        break;
                    }
                    case 't': {
                        c = '\t';
                        break;
                    }
                    case 'U': 
                    case 'u': {
                        c = JsonUtils.unescapeUnicode(string, n);
                        n += 4;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("invalid escape character: " + c);
                    }
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static char unescapeUnicode(String string, int n) {
        if (n + 4 > string.length()) {
            throw new IllegalArgumentException("unicode escape extends past end of string");
        }
        int n2 = 0;
        for (int i = 0; i < 4; ++i) {
            int n3 = StringUtil.parseDigit(string.charAt(n + i), 16);
            if (n3 < 0) {
                throw new IllegalArgumentException("invalid unicode escape: " + string.substring(n, n + 4));
            }
            n2 = n2 * 16 + n3;
        }
        return (char)n2;
    }

    private static String escapeUnicode(char c) {
        char[] cArray = new char[]{'\\', 'u', '0', '0', '0', '0'};
        int n = c & 0xFFFF;
        for (int i = 5; i > 1; --i) {
            int n2 = n % 16;
            n /= 16;
            cArray[i] = Character.forDigit(n2, 16);
        }
        return new String(cArray);
    }
}

