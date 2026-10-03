/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import java.math.BigInteger;

public class SunJCE_u {
    public static String a(BigInteger bigInteger) {
        String string = bigInteger.toString(16);
        StringBuffer stringBuffer = new StringBuffer(string.length() * 2);
        if (string.startsWith("-")) {
            stringBuffer.append("   -");
            string = string.substring(1);
        } else {
            stringBuffer.append("    ");
        }
        if (string.length() % 2 != 0) {
            string = "0" + string;
        }
        int n = 0;
        while (n < string.length()) {
            stringBuffer.append(string.substring(n, n + 2));
            if ((n += 2) == string.length()) continue;
            if (n % 64 == 0) {
                stringBuffer.append("\n    ");
                continue;
            }
            if (n % 8 != 0) continue;
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}

