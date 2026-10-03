/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.regex.Pattern;

public class eifc {
    public static final Pattern _a = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");

    public static String _a(int n) {
        int n2 = n / 20;
        int n3 = n2 / 60;
        if ((n2 %= 60) < 10) {
            return n3 + ":0" + n2;
        }
        return n3 + ":" + n2;
    }

    public static String _a(String string) {
        return _a.matcher(string).replaceAll("");
    }
}

