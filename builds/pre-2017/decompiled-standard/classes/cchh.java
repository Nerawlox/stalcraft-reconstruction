/*
 * Decompiled with CFR 0.152.
 */
public class cchh {
    public static String _a(String string) {
        if (string == null) {
            return null;
        }
        if (string.replaceAll("[a-zA-Z0-9_!@#$%^&*()-=+~.;:,\\Q[\\E\\Q]\\E<>{}\\/? ]", "").length() < 1) {
            return string;
        }
        String string2 = string;
        string2 = string2.replaceAll("\\\\", "\\\\\\\\");
        string2 = string2.replaceAll("\\n", "\\\\n");
        string2 = string2.replaceAll("\\r", "\\\\r");
        string2 = string2.replaceAll("\\t", "\\\\t");
        string2 = string2.replaceAll("\\00", "\\\\0");
        string2 = string2.replaceAll("'", "\\\\'");
        string2 = string2.replaceAll("\\\"", "\\\\\"");
        return string2;
    }
}

