/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

public class NoppesStringUtils {
    public static String formatText(String string, String string2) {
        string = string.replaceAll("\\{player\\}", string2);
        string = string.replaceAll("@p", string2);
        string = string.replaceAll("&", Character.toChars(167)[0] + "");
        return string;
    }
}

