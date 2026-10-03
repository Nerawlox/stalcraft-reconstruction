/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import java.util.HashMap;
import java.util.Map;

public class PathModifier {
    public static HashMap<String, Class> _a = new HashMap();
    public static final boolean _b = System.getProperty("read_derived", "false").equals("true");
    private static final HashMap<String, String> _c = new HashMap();

    public static String modifyPath(String string, String string2) {
        if (!_b) {
            return string;
        }
        int n = string.lastIndexOf(46);
        if (n > 0) {
            String string3 = string.substring(0, n);
            for (Map.Entry<String, String> entry : _c.entrySet()) {
                String string4 = entry.getKey();
                String string5 = entry.getValue();
                if (!string.endsWith(string4)) continue;
                return string3 + string5;
            }
        }
        return string;
    }

    static {
        _c.put(".dds", ".ol");
        _c.put(".erk", ".ol");
        _c.put(".png", ".mic");
    }
}

