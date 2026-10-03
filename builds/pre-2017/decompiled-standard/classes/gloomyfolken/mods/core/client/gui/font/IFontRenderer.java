/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.font;

import java.util.Arrays;
import java.util.List;
import net.minecraft.client.xpzm;

public interface IFontRenderer {
    public int getStringWidth(String var1);

    public int getFontHeight();

    public String trimToWidth(String var1, int var2);

    public int renderString(String var1, int var2, int var3);

    public int renderString(String var1, int var2, int var3, int var4);

    public int renderString(String var1, int var2, int var3, int var4, boolean var5);

    public int renderString(String var1, int var2, int var3, boolean var4);

    public int renderCenteredString(String var1, int var2, int var3);

    public int renderCenteredString(String var1, int var2, int var3, int var4);

    public int renderCenteredString(String var1, int var2, int var3, int var4, boolean var5);

    public int renderCenteredString(String var1, int var2, int var3, boolean var4);

    default public List<String> wrapString(String string, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : string.split(" ")) {
            int n2 = stringBuilder.lastIndexOf(System.lineSeparator());
            String string3 = n2 != -1 ? stringBuilder.substring(n2) + string2 : stringBuilder + string2;
            if (this.getStringWidth(string3) > n) {
                stringBuilder.append(System.lineSeparator()).append(string2);
                continue;
            }
            stringBuilder.append(" ").append(string2);
        }
        return Arrays.asList(stringBuilder.toString().trim().split(System.lineSeparator()));
    }

    public static class Colors {
        static final String SPECIAL = "0123456789abcdefklmnor";
        static final long[] COLOR_CODES = new long[32];

        static {
            for (int i = 0; i < 32; ++i) {
                int n = (i >> 3 & 1) * 85;
                int n2 = (i >> 2 & 1) * 170 + n;
                int n3 = (i >> 1 & 1) * 170 + n;
                int n4 = (i & 1) * 170 + n;
                if (i == 6) {
                    n2 += 85;
                }
                if (xpzm._E()._M.field_74337_g) {
                    int n5 = (n2 * 30 + n3 * 59 + n4 * 11) / 100;
                    int n6 = (n2 * 30 + n3 * 70) / 100;
                    int n7 = (n2 * 30 + n4 * 70) / 100;
                    n2 = n5;
                    n3 = n6;
                    n4 = n7;
                }
                if (i >= 16) {
                    n2 /= 4;
                    n3 /= 4;
                    n4 /= 4;
                }
                Colors.COLOR_CODES[i] = (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
            }
        }
    }
}

