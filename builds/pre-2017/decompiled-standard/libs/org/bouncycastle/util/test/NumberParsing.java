/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util.test;

public final class NumberParsing {
    private NumberParsing() {
    }

    public static long decodeLongFromHex(String string) {
        if (string.charAt(1) == 'x' || string.charAt(1) == 'X') {
            return Long.parseLong(string.substring(2), 16);
        }
        return Long.parseLong(string, 16);
    }

    public static int decodeIntFromHex(String string) {
        if (string.charAt(1) == 'x' || string.charAt(1) == 'X') {
            return Integer.parseInt(string.substring(2), 16);
        }
        return Integer.parseInt(string, 16);
    }
}

