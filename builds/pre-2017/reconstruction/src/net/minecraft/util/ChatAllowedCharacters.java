/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatAllowedCharacters {
    public static final String _a = ChatAllowedCharacters._a();
    public static final char[] _b = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};

    public static String _a() {
        String string = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ChatAllowedCharacters.class.getResourceAsStream("/font.txt"), "UTF-8"));
            String string2 = "";
            while ((string2 = bufferedReader.readLine()) != null) {
                if (string2.startsWith("#")) continue;
                string = string + string2;
            }
            bufferedReader.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        return string;
    }

    public static final boolean _a(char c) {
        return c != '\u00a7' && (_a.indexOf(c) >= 0 || c > ' ');
    }

    public static String _a(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (!ChatAllowedCharacters._a(c)) continue;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

