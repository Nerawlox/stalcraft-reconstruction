/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import com.google.common.collect.Lists;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.EnumChatFormatting;
import org.apache.commons.lang3.StringUtils;

public class jgro {
    public static final int _a = 160;

    public static float _a(float f) {
        return (f - 1.0f) * 100.0f;
    }

    public static float _b(float f) {
        return f / 100.0f + 1.0f;
    }

    public static float _c(float f) {
        return f * 100.0f;
    }

    public static float _d(float f) {
        return f / 100.0f;
    }

    public static float _e(float f) {
        return f * 5.0f;
    }

    public static void _a(List<String> list, String string, float f) {
        jgro._a(list, string, f, false, true);
    }

    public static void _b(List<String> list, String string, float f) {
        jgro._a(list, string, f, true, true);
    }

    public static void _a(List list, String string, float f, boolean bl, boolean bl2) {
        if ((double)Math.abs(f) < 0.01) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (f > 0.0f != bl) {
            stringBuilder.append((Object)EnumChatFormatting._c);
        } else {
            stringBuilder.append((Object)EnumChatFormatting._e);
        }
        stringBuilder.append(string);
        stringBuilder.append(": ");
        if (f > 0.0f) {
            stringBuilder.append("+");
        }
        stringBuilder.append(jgro._h(f));
        if (bl2) {
            stringBuilder.append("%");
        }
        list.add(stringBuilder.toString());
    }

    public static String _f(float f) {
        return jgro._h(jgro._e(f));
    }

    public static String _g(float f) {
        String string = jgro._h(f) + "%";
        if (f > 0.0f) {
            string = "+" + string;
        }
        return string;
    }

    public static String _h(float f) {
        String string = String.format(Locale.ENGLISH, "%.2f", Float.valueOf(f));
        if (string.endsWith(".00")) {
            string = string.substring(0, string.length() - 3);
        }
        return string;
    }

    public static String _i(float f) {
        return jgro._h(jgro._a(f)) + "%";
    }

    public static String _j(float f) {
        return jgro._h(jgro._c(f)) + "%";
    }

    public static String _k(float f) {
        return jgro._h(f) + " c.";
    }

    public static String _a(int n) {
        int n2 = n / 1000;
        int n3 = n % 1000 / 100;
        return n2 + "." + n3 + " c.";
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(List<String> list, List<String> list2) {
        int n;
        FontRenderer fontRenderer = Minecraft._E()._z;
        int n2 = fontRenderer._a(' ');
        if (list2.isEmpty()) {
            return;
        }
        int n3 = 0;
        int n4 = fontRenderer._b(list2.get(0));
        for (n = 0; n < list2.size(); ++n) {
            boolean bl = n == list2.size() - 1;
            int n5 = bl ? 0 : fontRenderer._b(list2.get(n + 1));
            int n6 = n5 + n2;
            if (n4 + n6 > 160 || bl) {
                list.add(StringUtils.join(list2.subList(n3, n + 1), " "));
                n4 = n5;
                n3 = n + 1;
                continue;
            }
            n4 += n6;
        }
        n = 0;
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(List<String> list, String string) {
        String[] stringArray = StringUtils.split(string, " ");
        jgro._a(list, Lists.newArrayList(stringArray));
    }

    @ezey(_a={eidj.CLIENT})
    public static void _b(List<String> list, String string) {
        FontRenderer fontRenderer = Minecraft._E()._z;
        int n = fontRenderer._a(' ');
        String[] stringArray = string.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = 0;
        for (String string2 : stringArray) {
            if ((n2 += fontRenderer._b(string2) + n) > 160) {
                list.add(stringBuffer.toString());
                stringBuffer.setLength(0);
            }
            stringBuffer.append(string2 + " ");
            if (n2 <= 160) continue;
            n2 = 0;
        }
        list.add(stringBuffer.toString());
    }
}

