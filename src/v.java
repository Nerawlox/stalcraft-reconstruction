/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class v {
    public static final String a = v.a();
    public static final char[] b = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};

    private static String a() {
        String s2 = "";
        try {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(v.class.getResourceAsStream("/font.txt"), "UTF-8"));
            String s1 = "";
            while ((s1 = bufferedreader.readLine()) != null) {
                if (s1.startsWith("#")) continue;
                s2 = s2 + s1;
            }
            bufferedreader.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        return s2;
    }

    public static final boolean a(char par0) {
        return par0 != '\u00a7' && (a.indexOf(par0) >= 0 || par0 > ' ');
    }

    public static String a(String par0Str) {
        StringBuilder stringbuilder = new StringBuilder();
        for (char c0 : par0Str.toCharArray()) {
            if (!v.a(c0)) continue;
            stringbuilder.append(c0);
        }
        return stringbuilder.toString();
    }
}

